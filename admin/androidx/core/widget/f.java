package androidx.core.widget;

import android.os.Build;
import android.widget.EdgeEffect;

public final class f {
    public static void a(EdgeEffect edgeEffect, float f10, float f11) {
        if (Build.VERSION.SDK_INT >= 21) {
            edgeEffect.onPull(f10, f11);
        } else {
            edgeEffect.onPull(f10);
        }
    }
}
