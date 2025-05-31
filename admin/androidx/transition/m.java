package androidx.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

class m<T> extends Property<T, Float> {

    /* renamed from: a  reason: collision with root package name */
    private final Property<T, PointF> f4131a;

    /* renamed from: b  reason: collision with root package name */
    private final PathMeasure f4132b;

    /* renamed from: c  reason: collision with root package name */
    private final float f4133c;

    /* renamed from: d  reason: collision with root package name */
    private final float[] f4134d = new float[2];

    /* renamed from: e  reason: collision with root package name */
    private final PointF f4135e = new PointF();

    /* renamed from: f  reason: collision with root package name */
    private float f4136f;

    m(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.f4131a = property;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        this.f4132b = pathMeasure;
        this.f4133c = pathMeasure.getLength();
    }

    /* renamed from: a */
    public Float get(T t10) {
        return Float.valueOf(this.f4136f);
    }

    /* renamed from: b */
    public void set(T t10, Float f10) {
        this.f4136f = f10.floatValue();
        this.f4132b.getPosTan(this.f4133c * f10.floatValue(), this.f4134d, (float[]) null);
        PointF pointF = this.f4135e;
        float[] fArr = this.f4134d;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.f4131a.set(t10, pointF);
    }
}
