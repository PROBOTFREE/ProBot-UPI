package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewParent;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.f;

public class MotionTelltales extends MockView {

    /* renamed from: l  reason: collision with root package name */
    private Paint f1852l = new Paint();

    /* renamed from: m  reason: collision with root package name */
    MotionLayout f1853m;

    /* renamed from: n  reason: collision with root package name */
    float[] f1854n = new float[2];

    /* renamed from: o  reason: collision with root package name */
    Matrix f1855o = new Matrix();

    /* renamed from: p  reason: collision with root package name */
    int f1856p = 0;

    /* renamed from: q  reason: collision with root package name */
    int f1857q = -65281;

    /* renamed from: r  reason: collision with root package name */
    float f1858r = 0.25f;

    public MotionTelltales(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public MotionTelltales(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.MotionTelltales);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == f.MotionTelltales_telltales_tailColor) {
                    this.f1857q = obtainStyledAttributes.getColor(index, this.f1857q);
                } else if (index == f.MotionTelltales_telltales_velocityMode) {
                    this.f1856p = obtainStyledAttributes.getInt(index, this.f1856p);
                } else if (index == f.MotionTelltales_telltales_tailScale) {
                    this.f1858r = obtainStyledAttributes.getFloat(index, this.f1858r);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f1852l.setColor(this.f1857q);
        this.f1852l.setStrokeWidth(5.0f);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        getMatrix().invert(this.f1855o);
        if (this.f1853m == null) {
            ViewParent parent = getParent();
            if (parent instanceof MotionLayout) {
                this.f1853m = (MotionLayout) parent;
                return;
            }
            return;
        }
        int width = getWidth();
        int height = getHeight();
        float[] fArr = {0.1f, 0.25f, 0.5f, 0.75f, 0.9f};
        for (int i10 = 0; i10 < 5; i10++) {
            float f10 = fArr[i10];
            for (int i11 = 0; i11 < 5; i11++) {
                float f11 = fArr[i11];
                this.f1853m.p0(this, f11, f10, this.f1854n, this.f1856p);
                this.f1855o.mapVectors(this.f1854n);
                float f12 = ((float) width) * f11;
                float f13 = ((float) height) * f10;
                float[] fArr2 = this.f1854n;
                float f14 = fArr2[0];
                float f15 = this.f1858r;
                float f16 = f13 - (fArr2[1] * f15);
                this.f1855o.mapVectors(fArr2);
                canvas.drawLine(f12, f13, f12 - (f14 * f15), f16, this.f1852l);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        postInvalidate();
    }

    public void setText(CharSequence charSequence) {
        this.f1811f = charSequence.toString();
        requestLayout();
    }
}
