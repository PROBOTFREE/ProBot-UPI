package androidx.transition;

import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build;
import android.util.Property;

class l {
    static <T> ObjectAnimator a(T t10, Property<T, PointF> property, Path path) {
        return Build.VERSION.SDK_INT >= 21 ? ObjectAnimator.ofObject(t10, property, (TypeConverter) null, path) : ObjectAnimator.ofFloat(t10, new m(property, path), new float[]{0.0f, 1.0f});
    }
}
