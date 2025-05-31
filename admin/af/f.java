package af;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Locale;
import of.k;

public final class f extends Reader {

    /* renamed from: a  reason: collision with root package name */
    protected final InputStream f19241a;

    /* renamed from: b  reason: collision with root package name */
    protected final byte[] f19242b;

    /* renamed from: c  reason: collision with root package name */
    protected int f19243c;

    /* renamed from: d  reason: collision with root package name */
    private int f19244d = -1;

    /* renamed from: e  reason: collision with root package name */
    private final k f19245e;

    /* renamed from: f  reason: collision with root package name */
    private final Locale f19246f;

    public f(InputStream inputStream, byte[] bArr, k kVar, Locale locale) {
        this.f19241a = inputStream;
        this.f19242b = bArr;
        this.f19245e = kVar;
        this.f19246f = locale;
    }

    private void c(int i10, int i11) {
        throw new c(this.f19245e, this.f19246f, "http://www.w3.org/TR/1998/REC-xml-19980210", "ExpectedByte", new Object[]{Integer.toString(i10), Integer.toString(i11)});
    }

    private void d(int i10, int i11, int i12) {
        throw new c(this.f19245e, this.f19246f, "http://www.w3.org/TR/1998/REC-xml-19980210", "InvalidByte", new Object[]{Integer.toString(i10), Integer.toString(i11)});
    }

    private void f(int i10) {
        throw new c(this.f19245e, this.f19246f, "http://www.w3.org/TR/1998/REC-xml-19980210", "InvalidHighSurrogate", new Object[]{Integer.toHexString(i10)});
    }

    public void close() {
        this.f19241a.close();
    }

    public void mark(int i10) {
        throw new IOException(this.f19245e.a(this.f19246f, "OperationNotSupported", new Object[]{"mark()", "UTF-8"}));
    }

    public boolean markSupported() {
        return false;
    }

    public int read() {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14 = this.f19244d;
        int i15 = -1;
        if (i14 == -1) {
            int i16 = 0;
            if (this.f19243c == 0) {
                i10 = this.f19241a.read();
            } else {
                i10 = this.f19242b[0] & 255;
                i16 = 1;
            }
            if (i10 == -1) {
                return -1;
            }
            if (i10 < 128) {
                return (char) i10;
            }
            if ((i10 & 224) == 192 && (i10 & 30) != 0) {
                int read = i16 == this.f19243c ? this.f19241a.read() : this.f19242b[i16] & 255;
                if (read == -1) {
                    c(2, 2);
                }
                if ((read & 192) != 128) {
                    d(2, 2, read);
                }
                return (read & 63) | ((i10 << 6) & 1984);
            } else if ((i10 & 240) == 224) {
                if (i16 == this.f19243c) {
                    i13 = this.f19241a.read();
                } else {
                    i13 = this.f19242b[i16] & 255;
                    i16++;
                }
                if (i13 == -1) {
                    c(2, 3);
                }
                if ((i13 & 192) != 128 || ((i10 == 237 && i13 >= 160) || ((i10 & 15) == 0 && (i13 & 32) == 0))) {
                    d(2, 3, i13);
                }
                int read2 = i16 == this.f19243c ? this.f19241a.read() : this.f19242b[i16] & 255;
                if (read2 == -1) {
                    c(3, 3);
                }
                if ((read2 & 192) != 128) {
                    d(3, 3, read2);
                }
                return ((i13 << 6) & 4032) | ((i10 << 12) & 61440) | (read2 & 63);
            } else if ((i10 & 248) == 240) {
                if (i16 == this.f19243c) {
                    i11 = this.f19241a.read();
                } else {
                    i11 = this.f19242b[i16] & 255;
                    i16++;
                }
                if (i11 == -1) {
                    c(2, 4);
                }
                if ((i11 & 192) != 128 || ((i11 & 48) == 0 && (i10 & 7) == 0)) {
                    d(2, 3, i11);
                }
                if (i16 == this.f19243c) {
                    i12 = this.f19241a.read();
                } else {
                    i12 = this.f19242b[i16] & 255;
                    i16++;
                }
                if (i12 == -1) {
                    c(3, 4);
                }
                if ((i12 & 192) != 128) {
                    d(3, 3, i12);
                }
                int read3 = i16 == this.f19243c ? this.f19241a.read() : this.f19242b[i16] & 255;
                if (read3 == -1) {
                    c(4, 4);
                }
                if ((read3 & 192) != 128) {
                    d(4, 4, read3);
                }
                int i17 = ((i10 << 2) & 28) | ((i11 >> 4) & 3);
                if (i17 > 16) {
                    f(i17);
                }
                i14 = ((i11 << 2) & 60) | (((i17 - 1) << 6) & 960) | 55296 | ((i12 >> 4) & 3);
                i15 = 56320 | ((i12 << 6) & 960) | (read3 & 63);
            } else {
                d(1, 1, i10);
                return i14;
            }
        }
        this.f19244d = i15;
        return i14;
    }

    public int read(char[] cArr, int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22 = i10;
        int i23 = this.f19243c;
        int i24 = -1;
        if (i23 == 0) {
            byte[] bArr = this.f19242b;
            int i25 = i11;
            i13 = i25 > bArr.length ? bArr.length : i25;
            int i26 = this.f19244d;
            if (i26 != -1) {
                i12 = i22 + 1;
                cArr[i22] = (char) i26;
                this.f19244d = -1;
                i13--;
            } else {
                i12 = i22;
            }
            int read = this.f19241a.read(bArr, 0, i13);
            if (read == -1) {
                return -1;
            }
            i23 = read + (i12 - i22);
        } else {
            this.f19243c = 0;
            i12 = i22;
            i13 = i11;
        }
        int i27 = 0;
        while (i27 < i23) {
            byte b10 = this.f19242b[i27];
            if (b10 < 0) {
                break;
            }
            cArr[i12] = (char) b10;
            i27++;
            i12++;
        }
        int i28 = i23;
        while (i27 < i23) {
            byte[] bArr2 = this.f19242b;
            byte b11 = bArr2[i27];
            if (b11 >= 0) {
                i20 = i12 + 1;
                cArr[i12] = (char) b11;
            } else {
                byte b12 = b11 & 255;
                if ((b12 & 224) != 192 || (b12 & 30) == 0) {
                    int i29 = 3;
                    if ((b12 & 240) == 224) {
                        int i30 = i27 + 1;
                        if (i30 < i23) {
                            i18 = bArr2[i30] & 255;
                        } else {
                            i18 = this.f19241a.read();
                            if (i18 == i24) {
                                if (i12 > i22) {
                                    this.f19242b[0] = (byte) b12;
                                } else {
                                    c(2, 3);
                                }
                            }
                            i28++;
                        }
                        if ((i18 & 192) != 128 || ((b12 == 237 && i18 >= 160) || ((b12 & 15) == 0 && (i18 & 32) == 0))) {
                            if (i12 > i22) {
                                byte[] bArr3 = this.f19242b;
                                bArr3[0] = (byte) b12;
                                bArr3[1] = (byte) i18;
                                this.f19243c = 2;
                                return i12 - i22;
                            }
                            d(2, 3, i18);
                        }
                        i27 = i30 + 1;
                        if (i27 < i23) {
                            i19 = this.f19242b[i27] & 255;
                        } else {
                            i19 = this.f19241a.read();
                            if (i19 == i24) {
                                if (i12 > i22) {
                                    byte[] bArr4 = this.f19242b;
                                    bArr4[0] = (byte) b12;
                                    bArr4[1] = (byte) i18;
                                    this.f19243c = 2;
                                    return i12 - i22;
                                }
                                c(3, 3);
                            }
                            i28++;
                        }
                        if ((i19 & 192) != 128) {
                            if (i12 > i22) {
                                byte[] bArr5 = this.f19242b;
                                bArr5[0] = (byte) b12;
                                bArr5[1] = (byte) i18;
                                bArr5[2] = (byte) i19;
                            } else {
                                d(3, 3, i19);
                            }
                        }
                        int i31 = ((b12 << 12) & 61440) | ((i18 << 6) & 4032) | (i19 & 63);
                        i20 = i12 + 1;
                        cArr[i12] = (char) i31;
                        i28 -= 2;
                    } else if ((b12 & 248) == 240) {
                        int i32 = i27 + 1;
                        if (i32 < i23) {
                            i14 = bArr2[i32] & 255;
                        } else {
                            i14 = this.f19241a.read();
                            if (i14 == -1) {
                                if (i12 > i22) {
                                    this.f19242b[0] = (byte) b12;
                                } else {
                                    c(2, 4);
                                }
                            }
                            i28++;
                        }
                        if ((i14 & 192) != 128 || ((i14 & 48) == 0 && (b12 & 7) == 0)) {
                            if (i12 > i22) {
                                byte[] bArr6 = this.f19242b;
                                bArr6[0] = (byte) b12;
                                bArr6[1] = (byte) i14;
                                this.f19243c = 2;
                                return i12 - i22;
                            }
                            d(2, 4, i14);
                        }
                        int i33 = i32 + 1;
                        if (i33 < i23) {
                            i15 = this.f19242b[i33] & 255;
                        } else {
                            i15 = this.f19241a.read();
                            if (i15 == -1) {
                                if (i12 > i22) {
                                    byte[] bArr7 = this.f19242b;
                                    bArr7[0] = (byte) b12;
                                    bArr7[1] = (byte) i14;
                                    this.f19243c = 2;
                                    return i12 - i22;
                                }
                                c(3, 4);
                            }
                            i28++;
                        }
                        if ((i15 & 192) != 128) {
                            if (i12 > i22) {
                                byte[] bArr8 = this.f19242b;
                                bArr8[0] = (byte) b12;
                                bArr8[1] = (byte) i14;
                                bArr8[2] = (byte) i15;
                            } else {
                                d(3, 4, i15);
                            }
                        }
                        i27 = i33 + 1;
                        if (i27 < i23) {
                            i16 = this.f19242b[i27] & 255;
                        } else {
                            i16 = this.f19241a.read();
                            if (i16 == -1) {
                                if (i12 > i22) {
                                    byte[] bArr9 = this.f19242b;
                                    bArr9[0] = (byte) b12;
                                    bArr9[1] = (byte) i14;
                                    bArr9[2] = (byte) i15;
                                } else {
                                    c(4, 4);
                                }
                            }
                            i28++;
                        }
                        if ((i16 & 192) != 128) {
                            if (i12 > i22) {
                                byte[] bArr10 = this.f19242b;
                                bArr10[0] = (byte) b12;
                                bArr10[1] = (byte) i14;
                                bArr10[2] = (byte) i15;
                                bArr10[3] = (byte) i16;
                                i29 = 4;
                            } else {
                                d(4, 4, i15);
                            }
                        }
                        int i34 = ((b12 << 2) & 28) | ((i14 >> 4) & 3);
                        if (i34 > 16) {
                            f(i34);
                        }
                        int i35 = i15 & 63;
                        int i36 = ((i14 & 15) << 2) | (((i34 - 1) << 6) & 960) | 55296 | (i35 >> 4);
                        int i37 = (i16 & 63) | 56320 | ((i35 << 6) & 960);
                        i17 = i12 + 1;
                        cArr[i12] = (char) i36;
                        i28 -= 2;
                        if (i28 <= i13) {
                            i12 = i17 + 1;
                            cArr[i17] = (char) i37;
                            i27++;
                            i24 = -1;
                        } else {
                            this.f19244d = i37;
                            i28--;
                            i12 = i17;
                            i27++;
                            i24 = -1;
                        }
                    } else if (i12 > i22) {
                        bArr2[0] = (byte) b12;
                    } else {
                        d(1, 1, b12);
                        i27++;
                        i24 = -1;
                    }
                    this.f19243c = i29;
                    return i12 - i22;
                }
                i27++;
                if (i27 < i23) {
                    i21 = bArr2[i27] & 255;
                } else {
                    i21 = this.f19241a.read();
                    if (i21 == i24) {
                        if (i12 > i22) {
                            this.f19242b[0] = (byte) b12;
                        } else {
                            c(2, 2);
                        }
                    }
                    i28++;
                }
                if ((i21 & 192) != 128) {
                    if (i12 > i22) {
                        byte[] bArr11 = this.f19242b;
                        bArr11[0] = (byte) b12;
                        bArr11[1] = (byte) i21;
                        this.f19243c = 2;
                        return i12 - i22;
                    }
                    d(2, 2, i21);
                }
                int i38 = (i21 & 63) | ((b12 << 6) & 1984);
                i17 = i12 + 1;
                cArr[i12] = (char) i38;
                i28 += i24;
                i12 = i17;
                i27++;
                i24 = -1;
                this.f19243c = 1;
                return i12 - i22;
            }
            i12 = i20;
            i27++;
            i24 = -1;
        }
        return i28;
    }

    public boolean ready() {
        return false;
    }

    public void reset() {
        this.f19243c = 0;
        this.f19244d = -1;
    }

    public long skip(long j10) {
        int length = this.f19242b.length;
        char[] cArr = new char[length];
        long j11 = j10;
        do {
            int read = read(cArr, 0, ((long) length) < j11 ? length : (int) j11);
            if (read <= 0) {
                break;
            }
            j11 -= (long) read;
        } while (j11 > 0);
        return j10 - j11;
    }
}
