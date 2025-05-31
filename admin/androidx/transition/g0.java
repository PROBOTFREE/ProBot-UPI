package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;

class g0 extends l0 {

    /* renamed from: f  reason: collision with root package name */
    private static boolean f4109f = true;

    g0() {
    }

    public void a(View view) {
    }

    @SuppressLint({"NewApi"})
    public float c(View view) {
        if (f4109f) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f4109f = false;
            }
        }
        return view.getAlpha();
    }

    public void d(View view) {
    }

    @SuppressLint({"NewApi"})
    public void g(View view, float f10) {
        if (f4109f) {
            try {
                view.setTransitionAlpha(f10);
                return;
            } catch (NoSuchMethodError unused) {
                f4109f = false;
            }
        }
        view.setAlpha(f10);
    }
}
