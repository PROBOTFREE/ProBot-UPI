package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.Gravity;

public final class f {
    public static void a(int i10, int i11, int i12, Rect rect, Rect rect2, int i13) {
        if (Build.VERSION.SDK_INT >= 17) {
            Gravity.apply(i10, i11, i12, rect, rect2, i13);
        } else {
            Gravity.apply(i10, i11, i12, rect, rect2);
        }
    }

    public static int b(int i10, int i11) {
        return Build.VERSION.SDK_INT >= 17 ? Gravity.getAbsoluteGravity(i10, i11) : i10 & -8388609;
    }
}
