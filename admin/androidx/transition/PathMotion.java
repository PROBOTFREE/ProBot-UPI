package androidx.transition;

import android.content.Context;
import android.graphics.Path;
import android.util.AttributeSet;

public abstract class PathMotion {
    public PathMotion() {
    }

    public PathMotion(Context context, AttributeSet attributeSet) {
    }

    public abstract Path a(float f10, float f11, float f12, float f13);
}
