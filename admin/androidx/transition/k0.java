package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

class k0 extends j0 {
    k0() {
    }

    public float c(View view) {
        return view.getTransitionAlpha();
    }

    public void e(View view, Matrix matrix) {
        view.setAnimationMatrix(matrix);
    }

    public void f(View view, int i10, int i11, int i12, int i13) {
        view.setLeftTopRightBottom(i10, i11, i12, i13);
    }

    public void g(View view, float f10) {
        view.setTransitionAlpha(f10);
    }

    public void h(View view, int i10) {
        view.setTransitionVisibility(i10);
    }

    public void i(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    public void j(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
