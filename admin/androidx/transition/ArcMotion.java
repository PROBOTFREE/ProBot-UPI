package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import n0.g;
import org.xmlpull.v1.XmlPullParser;

public class ArcMotion extends PathMotion {

    /* renamed from: d  reason: collision with root package name */
    private static final float f3957d = ((float) Math.tan(Math.toRadians(35.0d)));

    /* renamed from: a  reason: collision with root package name */
    private float f3958a = 0.0f;

    /* renamed from: b  reason: collision with root package name */
    private float f3959b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    private float f3960c = f3957d;

    public ArcMotion() {
    }

    @SuppressLint({"RestrictedApi"})
    public ArcMotion(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, q.f4149h);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        d(g.f(obtainStyledAttributes, xmlPullParser, "minimumVerticalAngle", 1, 0.0f));
        c(g.f(obtainStyledAttributes, xmlPullParser, "minimumHorizontalAngle", 0, 0.0f));
        b(g.f(obtainStyledAttributes, xmlPullParser, "maximumAngle", 2, 70.0f));
        obtainStyledAttributes.recycle();
    }

    private static float e(float f10) {
        if (f10 >= 0.0f && f10 <= 90.0f) {
            return (float) Math.tan(Math.toRadians((double) (f10 / 2.0f)));
        }
        throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
    }

    public Path a(float f10, float f11, float f12, float f13) {
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        Path path = new Path();
        path.moveTo(f10, f11);
        float f19 = f12 - f10;
        float f20 = f13 - f11;
        float f21 = (f19 * f19) + (f20 * f20);
        float f22 = (f10 + f12) / 2.0f;
        float f23 = (f11 + f13) / 2.0f;
        float f24 = 0.25f * f21;
        boolean z10 = f11 > f13;
        if (Math.abs(f19) < Math.abs(f20)) {
            float abs = Math.abs(f21 / (f20 * 2.0f));
            if (z10) {
                f16 = abs + f13;
                f15 = f12;
            } else {
                f16 = abs + f11;
                f15 = f10;
            }
            f14 = this.f3959b;
        } else {
            float f25 = f21 / (f19 * 2.0f);
            if (z10) {
                f18 = f11;
                f17 = f25 + f10;
            } else {
                f17 = f12 - f25;
                f18 = f13;
            }
            f14 = this.f3958a;
        }
        float f26 = f24 * f14 * f14;
        float f27 = f22 - f15;
        float f28 = f23 - f16;
        float f29 = (f27 * f27) + (f28 * f28);
        float f30 = this.f3960c;
        float f31 = f24 * f30 * f30;
        if (f29 >= f26) {
            f26 = f29 > f31 ? f31 : 0.0f;
        }
        if (f26 != 0.0f) {
            float sqrt = (float) Math.sqrt((double) (f26 / f29));
            f15 = ((f15 - f22) * sqrt) + f22;
            f16 = f23 + (sqrt * (f16 - f23));
        }
        path.cubicTo((f10 + f15) / 2.0f, (f11 + f16) / 2.0f, (f15 + f12) / 2.0f, (f16 + f13) / 2.0f, f12, f13);
        return path;
    }

    public void b(float f10) {
        this.f3960c = e(f10);
    }

    public void c(float f10) {
        this.f3958a = e(f10);
    }

    public void d(float f10) {
        this.f3959b = e(f10);
    }
}
