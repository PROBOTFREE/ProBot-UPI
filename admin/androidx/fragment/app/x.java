package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

final class x extends Writer {

    /* renamed from: a  reason: collision with root package name */
    private final String f2915a;

    /* renamed from: b  reason: collision with root package name */
    private StringBuilder f2916b = new StringBuilder(128);

    x(String str) {
        this.f2915a = str;
    }

    private void c() {
        if (this.f2916b.length() > 0) {
            Log.d(this.f2915a, this.f2916b.toString());
            StringBuilder sb2 = this.f2916b;
            sb2.delete(0, sb2.length());
        }
    }

    public void close() {
        c();
    }

    public void flush() {
        c();
    }

    public void write(char[] cArr, int i10, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            char c10 = cArr[i10 + i12];
            if (c10 == 10) {
                c();
            } else {
                this.f2916b.append(c10);
            }
        }
    }
}
