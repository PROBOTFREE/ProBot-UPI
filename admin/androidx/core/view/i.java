package androidx.core.view;

import android.os.Build;
import android.view.ViewGroup;

public final class i {
    public static int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return Build.VERSION.SDK_INT >= 17 ? marginLayoutParams.getMarginEnd() : marginLayoutParams.rightMargin;
    }

    public static int b(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return Build.VERSION.SDK_INT >= 17 ? marginLayoutParams.getMarginStart() : marginLayoutParams.leftMargin;
    }

    public static void c(ViewGroup.MarginLayoutParams marginLayoutParams, int i10) {
        if (Build.VERSION.SDK_INT >= 17) {
            marginLayoutParams.setMarginEnd(i10);
        } else {
            marginLayoutParams.rightMargin = i10;
        }
    }

    public static void d(ViewGroup.MarginLayoutParams marginLayoutParams, int i10) {
        if (Build.VERSION.SDK_INT >= 17) {
            marginLayoutParams.setMarginStart(i10);
        } else {
            marginLayoutParams.leftMargin = i10;
        }
    }
}
