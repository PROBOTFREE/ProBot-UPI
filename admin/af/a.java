package af;

import java.io.InputStream;
import java.io.Reader;
import java.util.Locale;
import of.k;

public final class a extends Reader {

    /* renamed from: a  reason: collision with root package name */
    protected final InputStream f19221a;

    /* renamed from: b  reason: collision with root package name */
    protected final byte[] f19222b;

    /* renamed from: c  reason: collision with root package name */
    private final k f19223c;

    /* renamed from: d  reason: collision with root package name */
    private final Locale f19224d;

    public a(InputStream inputStream, byte[] bArr, k kVar, Locale locale) {
        this.f19221a = inputStream;
        this.f19222b = bArr;
        this.f19223c = kVar;
        this.f19224d = locale;
    }

    public void close() {
        this.f19221a.close();
    }

    public void mark(int i10) {
        this.f19221a.mark(i10);
    }

    public boolean markSupported() {
        return this.f19221a.markSupported();
    }

    public int read() {
        int read = this.f19221a.read();
        if (read < 128) {
            return read;
        }
        throw new c(this.f19223c, this.f19224d, "http://www.w3.org/TR/1998/REC-xml-19980210", "InvalidASCII", new Object[]{Integer.toString(read)});
    }

    public int read(char[] cArr, int i10, int i11) {
        byte[] bArr = this.f19222b;
        if (i11 > bArr.length) {
            i11 = bArr.length;
        }
        int read = this.f19221a.read(bArr, 0, i11);
        int i12 = 0;
        while (i12 < read) {
            byte b10 = this.f19222b[i12];
            if (b10 >= 0) {
                cArr[i10 + i12] = (char) b10;
                i12++;
            } else {
                throw new c(this.f19223c, this.f19224d, "http://www.w3.org/TR/1998/REC-xml-19980210", "InvalidASCII", new Object[]{Integer.toString(b10 & 255)});
            }
        }
        return read;
    }

    public boolean ready() {
        return false;
    }

    public void reset() {
        this.f19221a.reset();
    }

    public long skip(long j10) {
        return this.f19221a.skip(j10);
    }
}
