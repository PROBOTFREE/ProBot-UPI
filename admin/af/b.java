package af;

import java.io.InputStream;
import java.io.Reader;

public final class b extends Reader {

    /* renamed from: a  reason: collision with root package name */
    protected final InputStream f19225a;

    /* renamed from: b  reason: collision with root package name */
    protected final byte[] f19226b;

    public b(InputStream inputStream, byte[] bArr) {
        this.f19225a = inputStream;
        this.f19226b = bArr;
    }

    public void close() {
        this.f19225a.close();
    }

    public void mark(int i10) {
        this.f19225a.mark(i10);
    }

    public boolean markSupported() {
        return this.f19225a.markSupported();
    }

    public int read() {
        return this.f19225a.read();
    }

    public int read(char[] cArr, int i10, int i11) {
        byte[] bArr = this.f19226b;
        if (i11 > bArr.length) {
            i11 = bArr.length;
        }
        int read = this.f19225a.read(bArr, 0, i11);
        for (int i12 = 0; i12 < read; i12++) {
            cArr[i10 + i12] = (char) (this.f19226b[i12] & 255);
        }
        return read;
    }

    public boolean ready() {
        return false;
    }

    public void reset() {
        this.f19225a.reset();
    }

    public long skip(long j10) {
        return this.f19225a.skip(j10);
    }
}
