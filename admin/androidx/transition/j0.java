package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;

class j0 extends i0 {

    /* renamed from: k  reason: collision with root package name */
    private static boolean f4124k = true;

    j0() {
    }

    @SuppressLint({"NewApi"})
    public void h(View view, int i10) {
        if (Build.VERSION.SDK_INT == 28) {
            super.h(view, i10);
        } else if (f4124k) {
            try {
                view.setTransitionVisibility(i10);
            } catch (NoSuchMethodError unused) {
                f4124k = false;
            }
        }
    }
}
