package androidx.core.view;

import android.os.Build;
import android.view.DisplayCutout;
import w0.c;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final Object f2316a;

    private d(Object obj) {
        this.f2316a = obj;
    }

    static d e(Object obj) {
        if (obj == null) {
            return null;
        }
        return new d(obj);
    }

    public int a() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.f2316a).getSafeInsetBottom();
        }
        return 0;
    }

    public int b() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.f2316a).getSafeInsetLeft();
        }
        return 0;
    }

    public int c() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.f2316a).getSafeInsetRight();
        }
        return 0;
    }

    public int d() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.f2316a).getSafeInsetTop();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        return c.a(this.f2316a, ((d) obj).f2316a);
    }

    public int hashCode() {
        Object obj = this.f2316a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.f2316a + "}";
    }
}
