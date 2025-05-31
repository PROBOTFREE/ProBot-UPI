package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;

class i0 extends h0 {

    /* renamed from: j  reason: collision with root package name */
    private static boolean f4120j = true;

    i0() {
    }

    @SuppressLint({"NewApi"})
    public void f(View view, int i10, int i11, int i12, int i13) {
        if (f4120j) {
            try {
                view.setLeftTopRightBottom(i10, i11, i12, i13);
            } catch (NoSuchMethodError unused) {
                f4120j = false;
            }
        }
    }
}
