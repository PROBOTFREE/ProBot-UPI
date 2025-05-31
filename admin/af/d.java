package af;

import java.io.InputStream;
import java.io.Reader;

public final class d extends Reader {

    /* renamed from: a  reason: collision with root package name */
    protected final InputStream f19233a;

    /* renamed from: b  reason: collision with root package name */
    protected final byte[] f19234b;

    /* renamed from: c  reason: collision with root package name */
    protected final short f19235c;

    public d(InputStream inputStream, int i10, short s10) {
        this(inputStream, new byte[i10], s10);
    }

    public d(InputStream inputStream, short s10) {
        this(inputStream, 8192, s10);
    }

    public d(InputStream inputStream, byte[] bArr, short s10) {
        this.f19233a = inputStream;
        this.f19234b = bArr;
        this.f19235c = s10;
    }

    public void close() {
        this.f19233a.close();
    }

    public void mark(int i10) {
        this.f19233a.mark(i10);
    }

    public boolean markSupported() {
        return this.f19233a.markSupported();
    }

    public int read() {
        int read;
        int i10;
        int read2;
        int read3 = this.f19233a.read() & 255;
        if (read3 == 255 || (read = this.f19233a.read() & 255) == 255) {
            return -1;
        }
        short s10 = this.f19235c;
        if (s10 >= 4) {
            int read4 = this.f19233a.read() & 255;
            if (read4 == 255 || (read2 = this.f19233a.read() & 255) == 255) {
                return -1;
            }
            if (this.f19235c == 8) {
                return (read3 << 24) + (read << 16) + (read4 << 8) + read2;
            }
            i10 = (read2 << 24) + (read4 << 16) + (read << 8);
        } else if (s10 == 2) {
            return (read3 << 8) + read;
        } else {
            i10 = read << 8;
        }
        return i10 + read3;
    }

    public int read(char[] cArr, int i10, int i11) {
        int i12 = 1;
        int i13 = i11 << (this.f19235c >= 4 ? 2 : 1);
        byte[] bArr = this.f19234b;
        if (i13 > bArr.length) {
            i13 = bArr.length;
        }
        int read = this.f19233a.read(bArr, 0, i13);
        if (read == -1) {
            return -1;
        }
        if (this.f19235c >= 4) {
            int i14 = (4 - (read & 3)) & 3;
            int i15 = 0;
            while (true) {
                if (i15 >= i14) {
                    break;
                }
                int read2 = this.f19233a.read();
                if (read2 == -1) {
                    while (i15 < i14) {
                        this.f19234b[read + i15] = 0;
                        i15++;
                    }
                } else {
                    this.f19234b[read + i15] = (byte) read2;
                    i15++;
                }
            }
            read += i14;
        } else if ((read & 1) != 0) {
            read++;
            int read3 = this.f19233a.read();
            if (read3 == -1) {
                this.f19234b[read] = 0;
            } else {
                this.f19234b[read] = (byte) read3;
            }
        }
        if (this.f19235c >= 4) {
            i12 = 2;
        }
        int i16 = read >> i12;
        int i17 = 0;
        for (int i18 = 0; i18 < i16; i18++) {
            byte[] bArr2 = this.f19234b;
            int i19 = i17 + 1;
            byte b10 = bArr2[i17] & 255;
            int i20 = i19 + 1;
            byte b11 = bArr2[i19] & 255;
            short s10 = this.f19235c;
            if (s10 >= 4) {
                int i21 = i20 + 1;
                byte b12 = bArr2[i20] & 255;
                int i22 = i21 + 1;
                byte b13 = bArr2[i21] & 255;
                if (s10 == 8) {
                    cArr[i10 + i18] = (char) ((b10 << 24) + (b11 << 16) + (b12 << 8) + b13);
                } else {
                    cArr[i10 + i18] = (char) ((b13 << 24) + (b12 << 16) + (b11 << 8) + b10);
                }
                i17 = i22;
            } else {
                int i23 = i10 + i18;
                if (s10 == 2) {
                    cArr[i23] = (char) ((b10 << 8) + b11);
                } else {
                    cArr[i23] = (char) ((b11 << 8) + b10);
                }
                i17 = i20;
            }
        }
        return i16;
    }

    public boolean ready() {
        return false;
    }

    public void reset() {
        this.f19233a.reset();
    }

    public long skip(long j10) {
        int i10 = this.f19235c >= 4 ? 2 : 1;
        long skip = this.f19233a.skip(j10 << i10);
        int i11 = ((((long) (i10 | 1)) & skip) > 0 ? 1 : ((((long) (i10 | 1)) & skip) == 0 ? 0 : -1));
        long j11 = skip >> i10;
        return i11 == 0 ? j11 : j11 + 1;
    }
}
