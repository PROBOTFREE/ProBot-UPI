package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;

class h0 extends g0 {

    /* renamed from: g  reason: collision with root package name */
    private static boolean f4117g = true;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f4118h = true;

    /* renamed from: i  reason: collision with root package name */
    private static boolean f4119i = true;

    h0() {
    }

    @SuppressLint({"NewApi"})
    public void e(View view, Matrix matrix) {
        if (f4117g) {
            try {
                view.setAnimationMatrix(matrix);
            } catch (NoSuchMethodError unused) {
                f4117g = false;
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void i(View view, Matrix matrix) {
        if (f4118h) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f4118h = false;
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void j(View view, Matrix matrix) {
        if (f4119i) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f4119i = false;
            }
        }
    }
}
