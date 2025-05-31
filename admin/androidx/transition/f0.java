package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.core.view.x;

class f0 {

    /* renamed from: a  reason: collision with root package name */
    private static final l0 f4099a;

    /* renamed from: b  reason: collision with root package name */
    static final Property<View, Float> f4100b = new a(Float.class, "translationAlpha");

    /* renamed from: c  reason: collision with root package name */
    static final Property<View, Rect> f4101c = new b(Rect.class, "clipBounds");

    static class a extends Property<View, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf(f0.c(view));
        }

        /* renamed from: b */
        public void set(View view, Float f10) {
            f0.h(view, f10.floatValue());
        }
    }

    static class b extends Property<View, Rect> {
        b(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Rect get(View view) {
            return x.u(view);
        }

        /* renamed from: b */
        public void set(View view, Rect rect) {
            x.x0(view, rect);
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        f4099a = i10 >= 29 ? new k0() : i10 >= 23 ? new j0() : i10 >= 22 ? new i0() : i10 >= 21 ? new h0() : i10 >= 19 ? new g0() : new l0();
    }

    static void a(View view) {
        f4099a.a(view);
    }

    static e0 b(View view) {
        return Build.VERSION.SDK_INT >= 18 ? new d0(view) : c0.e(view);
    }

    static float c(View view) {
        return f4099a.c(view);
    }

    static o0 d(View view) {
        return Build.VERSION.SDK_INT >= 18 ? new n0(view) : new m0(view.getWindowToken());
    }

    static void e(View view) {
        f4099a.d(view);
    }

    static void f(View view, Matrix matrix) {
        f4099a.e(view, matrix);
    }

    static void g(View view, int i10, int i11, int i12, int i13) {
        f4099a.f(view, i10, i11, i12, i13);
    }

    static void h(View view, float f10) {
        f4099a.g(view, f10);
    }

    static void i(View view, int i10) {
        f4099a.h(view, i10);
    }

    static void j(View view, Matrix matrix) {
        f4099a.i(view, matrix);
    }

    static void k(View view, Matrix matrix) {
        f4099a.j(view, matrix);
    }
}
