package af;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Locale;
import of.k;

public final class e extends Reader {

    /* renamed from: a  reason: collision with root package name */
    protected final InputStream f19236a;

    /* renamed from: b  reason: collision with root package name */
    protected final byte[] f19237b;

    /* renamed from: c  reason: collision with root package name */
    protected final boolean f19238c;

    /* renamed from: d  reason: collision with root package name */
    private final k f19239d;

    /* renamed from: e  reason: collision with root package name */
    private final Locale f19240e;

    public e(InputStream inputStream, byte[] bArr, boolean z10, k kVar, Locale locale) {
        this.f19236a = inputStream;
        this.f19237b = bArr;
        this.f19238c = z10;
        this.f19239d = kVar;
        this.f19240e = locale;
    }

    private void c() {
        throw new c(this.f19239d, this.f19240e, "http://www.w3.org/TR/1998/REC-xml-19980210", "ExpectedByte", new Object[]{"2", "2"});
    }

    private void d(char[] cArr, int i10, int i11) {
        int i12 = 0;
        int i13 = 0;
        while (i12 < i11) {
            byte[] bArr = this.f19237b;
            int i14 = i13 + 1;
            cArr[i10] = (char) (((bArr[i13] & 255) << 8) | (bArr[i14] & 255));
            i12++;
            i10++;
            i13 = i14 + 1;
        }
    }

    private void f(char[] cArr, int i10, int i11) {
        int i12 = 0;
        int i13 = 0;
        while (i12 < i11) {
            byte[] bArr = this.f19237b;
            int i14 = i13 + 1;
            cArr[i10] = (char) ((bArr[i13] & 255) | ((bArr[i14] & 255) << 8));
            i12++;
            i10++;
            i13 = i14 + 1;
        }
    }

    public void close() {
        this.f19236a.close();
    }

    public void mark(int i10) {
        throw new IOException(this.f19239d.a(this.f19240e, "OperationNotSupported", new Object[]{"mark()", "UTF-16"}));
    }

    public boolean markSupported() {
        return false;
    }

    public int read() {
        int read = this.f19236a.read();
        if (read == -1) {
            return -1;
        }
        int read2 = this.f19236a.read();
        if (read2 == -1) {
            c();
        }
        return this.f19238c ? (read << 8) | read2 : read | (read2 << 8);
    }

    public int read(char[] cArr, int i10, int i11) {
        int i12 = i11 << 1;
        byte[] bArr = this.f19237b;
        if (i12 > bArr.length) {
            i12 = bArr.length;
        }
        int read = this.f19236a.read(bArr, 0, i12);
        if (read == -1) {
            return -1;
        }
        if ((read & 1) != 0) {
            int read2 = this.f19236a.read();
            if (read2 == -1) {
                c();
            }
            this.f19237b[read] = (byte) read2;
            read++;
        }
        int i13 = read >> 1;
        if (this.f19238c) {
            d(cArr, i10, i13);
        } else {
            f(cArr, i10, i13);
        }
        return i13;
    }

    public boolean ready() {
        return false;
    }

    public void reset() {
    }

    public long skip(long j10) {
        long skip = this.f19236a.skip(j10 << 1);
        if ((skip & 1) != 0) {
            if (this.f19236a.read() == -1) {
                c();
            }
            skip++;
        }
        return skip >> 1;
    }
}
