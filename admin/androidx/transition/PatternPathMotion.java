package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import n0.g;
import o0.c;
import org.xmlpull.v1.XmlPullParser;

public class PatternPathMotion extends PathMotion {

    /* renamed from: a  reason: collision with root package name */
    private final Path f4011a;

    /* renamed from: b  reason: collision with root package name */
    private final Matrix f4012b;

    public PatternPathMotion() {
        Path path = new Path();
        this.f4011a = path;
        this.f4012b = new Matrix();
        path.lineTo(1.0f, 0.0f);
    }

    @SuppressLint({"RestrictedApi"})
    public PatternPathMotion(Context context, AttributeSet attributeSet) {
        this.f4011a = new Path();
        this.f4012b = new Matrix();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, q.f4150i);
        try {
            String i10 = g.i(obtainStyledAttributes, (XmlPullParser) attributeSet, "patternPathData", 0);
            if (i10 != null) {
                c(c.e(i10));
                return;
            }
            throw new RuntimeException("pathData must be supplied for patternPathMotion");
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private static float b(float f10, float f11) {
        return (float) Math.sqrt((double) ((f10 * f10) + (f11 * f11)));
    }

    public Path a(float f10, float f11, float f12, float f13) {
        float f14 = f12 - f10;
        float f15 = f13 - f11;
        float b10 = b(f14, f15);
        double atan2 = Math.atan2((double) f15, (double) f14);
        this.f4012b.setScale(b10, b10);
        this.f4012b.postRotate((float) Math.toDegrees(atan2));
        this.f4012b.postTranslate(f10, f11);
        Path path = new Path();
        this.f4011a.transform(this.f4012b, path);
        return path;
    }

    public void c(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float[] fArr = new float[2];
        pathMeasure.getPosTan(pathMeasure.getLength(), fArr, (float[]) null);
        float f10 = fArr[0];
        float f11 = fArr[1];
        pathMeasure.getPosTan(0.0f, fArr, (float[]) null);
        float f12 = fArr[0];
        float f13 = fArr[1];
        if (f12 == f10 && f13 == f11) {
            throw new IllegalArgumentException("pattern must not end at the starting point");
        }
        this.f4012b.setTranslate(-f12, -f13);
        float f14 = f10 - f12;
        float f15 = f11 - f13;
        float b10 = 1.0f / b(f14, f15);
        this.f4012b.postScale(b10, b10);
        this.f4012b.postRotate((float) Math.toDegrees(-Math.atan2((double) f15, (double) f14)));
        path.transform(this.f4012b, this.f4011a);
    }
}
