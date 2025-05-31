package androidx.transition;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

class i {
    static e a(View view, ViewGroup viewGroup, Matrix matrix) {
        return Build.VERSION.SDK_INT == 28 ? g.b(view, viewGroup, matrix) : h.b(view, viewGroup, matrix);
    }

    static void b(View view) {
        if (Build.VERSION.SDK_INT == 28) {
            g.f(view);
        } else {
            h.f(view);
        }
    }
}
