package androidx.vectordrawable.graphics.drawable;

import android.animation.TypeEvaluator;

public class f implements TypeEvaluator {

    /* renamed from: a  reason: collision with root package name */
    private static final f f4205a = new f();

    public static f a() {
        return f4205a;
    }

    public Object evaluate(float f10, Object obj, Object obj2) {
        int intValue = ((Integer) obj).intValue();
        float f11 = ((float) ((intValue >> 24) & 255)) / 255.0f;
        int intValue2 = ((Integer) obj2).intValue();
        float pow = (float) Math.pow((double) (((float) ((intValue >> 16) & 255)) / 255.0f), 2.2d);
        float pow2 = (float) Math.pow((double) (((float) ((intValue >> 8) & 255)) / 255.0f), 2.2d);
        float pow3 = (float) Math.pow((double) (((float) (intValue & 255)) / 255.0f), 2.2d);
        float pow4 = (float) Math.pow((double) (((float) ((intValue2 >> 16) & 255)) / 255.0f), 2.2d);
        float pow5 = pow3 + (f10 * (((float) Math.pow((double) (((float) (intValue2 & 255)) / 255.0f), 2.2d)) - pow3));
        return Integer.valueOf((Math.round(((float) Math.pow((double) (pow + ((pow4 - pow) * f10)), 0.45454545454545453d)) * 255.0f) << 16) | (Math.round((f11 + (((((float) ((intValue2 >> 24) & 255)) / 255.0f) - f11) * f10)) * 255.0f) << 24) | (Math.round(((float) Math.pow((double) (pow2 + ((((float) Math.pow((double) (((float) ((intValue2 >> 8) & 255)) / 255.0f), 2.2d)) - pow2) * f10)), 0.45454545454545453d)) * 255.0f) << 8) | Math.round(((float) Math.pow((double) pow5, 0.45454545454545453d)) * 255.0f));
    }
}
