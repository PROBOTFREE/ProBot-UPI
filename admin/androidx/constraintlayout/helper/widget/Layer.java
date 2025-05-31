package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.f;
import h0.e;

public class Layer extends ConstraintHelper {
    private boolean A;

    /* renamed from: j  reason: collision with root package name */
    private float f1376j = Float.NaN;

    /* renamed from: k  reason: collision with root package name */
    private float f1377k = Float.NaN;

    /* renamed from: l  reason: collision with root package name */
    private float f1378l = Float.NaN;

    /* renamed from: m  reason: collision with root package name */
    ConstraintLayout f1379m;

    /* renamed from: n  reason: collision with root package name */
    private float f1380n = 1.0f;

    /* renamed from: o  reason: collision with root package name */
    private float f1381o = 1.0f;

    /* renamed from: p  reason: collision with root package name */
    protected float f1382p = Float.NaN;

    /* renamed from: q  reason: collision with root package name */
    protected float f1383q = Float.NaN;

    /* renamed from: r  reason: collision with root package name */
    protected float f1384r = Float.NaN;

    /* renamed from: s  reason: collision with root package name */
    protected float f1385s = Float.NaN;

    /* renamed from: t  reason: collision with root package name */
    protected float f1386t = Float.NaN;

    /* renamed from: u  reason: collision with root package name */
    protected float f1387u = Float.NaN;

    /* renamed from: v  reason: collision with root package name */
    boolean f1388v = true;

    /* renamed from: w  reason: collision with root package name */
    View[] f1389w = null;

    /* renamed from: x  reason: collision with root package name */
    private float f1390x = 0.0f;

    /* renamed from: y  reason: collision with root package name */
    private float f1391y = 0.0f;

    /* renamed from: z  reason: collision with root package name */
    private boolean f1392z;

    public Layer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Layer(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    private void y() {
        int i10;
        if (this.f1379m != null && (i10 = this.f1863b) != 0) {
            View[] viewArr = this.f1389w;
            if (viewArr == null || viewArr.length != i10) {
                this.f1389w = new View[i10];
            }
            for (int i11 = 0; i11 < this.f1863b; i11++) {
                this.f1389w[i11] = this.f1379m.l(this.f1862a[i11]);
            }
        }
    }

    private void z() {
        if (this.f1379m != null) {
            if (this.f1389w == null) {
                y();
            }
            x();
            double radians = Float.isNaN(this.f1378l) ? 0.0d : Math.toRadians((double) this.f1378l);
            float sin = (float) Math.sin(radians);
            float cos = (float) Math.cos(radians);
            float f10 = this.f1380n;
            float f11 = f10 * cos;
            float f12 = this.f1381o;
            float f13 = (-f12) * sin;
            float f14 = f10 * sin;
            float f15 = f12 * cos;
            for (int i10 = 0; i10 < this.f1863b; i10++) {
                View view = this.f1389w[i10];
                float left = ((float) ((view.getLeft() + view.getRight()) / 2)) - this.f1382p;
                float top = ((float) ((view.getTop() + view.getBottom()) / 2)) - this.f1383q;
                view.setTranslationX((((f11 * left) + (f13 * top)) - left) + this.f1390x);
                view.setTranslationY((((left * f14) + (f15 * top)) - top) + this.f1391y);
                view.setScaleY(this.f1381o);
                view.setScaleX(this.f1380n);
                if (!Float.isNaN(this.f1378l)) {
                    view.setRotation(this.f1378l);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void j(ConstraintLayout constraintLayout) {
        i(constraintLayout);
    }

    /* access modifiers changed from: protected */
    public void o(AttributeSet attributeSet) {
        super.o(attributeSet);
        this.f1866e = false;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, f.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == f.ConstraintLayout_Layout_android_visibility) {
                    this.f1392z = true;
                } else if (index == f.ConstraintLayout_Layout_android_elevation) {
                    this.A = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1379m = (ConstraintLayout) getParent();
        if (this.f1392z || this.A) {
            int visibility = getVisibility();
            float elevation = Build.VERSION.SDK_INT >= 21 ? getElevation() : 0.0f;
            for (int i10 = 0; i10 < this.f1863b; i10++) {
                View l10 = this.f1379m.l(this.f1862a[i10]);
                if (l10 != null) {
                    if (this.f1392z) {
                        l10.setVisibility(visibility);
                    }
                    if (this.A && elevation > 0.0f && Build.VERSION.SDK_INT >= 21) {
                        l10.setTranslationZ(l10.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    public void r(ConstraintLayout constraintLayout) {
        y();
        this.f1382p = Float.NaN;
        this.f1383q = Float.NaN;
        e b10 = ((ConstraintLayout.LayoutParams) getLayoutParams()).b();
        b10.o1(0);
        b10.P0(0);
        x();
        layout(((int) this.f1386t) - getPaddingLeft(), ((int) this.f1387u) - getPaddingTop(), ((int) this.f1384r) + getPaddingRight(), ((int) this.f1385s) + getPaddingBottom());
        z();
    }

    public void setElevation(float f10) {
        super.setElevation(f10);
        h();
    }

    public void setPivotX(float f10) {
        this.f1376j = f10;
        z();
    }

    public void setPivotY(float f10) {
        this.f1377k = f10;
        z();
    }

    public void setRotation(float f10) {
        this.f1378l = f10;
        z();
    }

    public void setScaleX(float f10) {
        this.f1380n = f10;
        z();
    }

    public void setScaleY(float f10) {
        this.f1381o = f10;
        z();
    }

    public void setTranslationX(float f10) {
        this.f1390x = f10;
        z();
    }

    public void setTranslationY(float f10) {
        this.f1391y = f10;
        z();
    }

    public void setVisibility(int i10) {
        super.setVisibility(i10);
        h();
    }

    public void t(ConstraintLayout constraintLayout) {
        this.f1379m = constraintLayout;
        float rotation = getRotation();
        if (rotation != 0.0f || !Float.isNaN(this.f1378l)) {
            this.f1378l = rotation;
        }
    }

    /* access modifiers changed from: protected */
    public void x() {
        if (this.f1379m != null) {
            if (!this.f1388v && !Float.isNaN(this.f1382p) && !Float.isNaN(this.f1383q)) {
                return;
            }
            if (Float.isNaN(this.f1376j) || Float.isNaN(this.f1377k)) {
                View[] n10 = n(this.f1379m);
                int left = n10[0].getLeft();
                int top = n10[0].getTop();
                int right = n10[0].getRight();
                int bottom = n10[0].getBottom();
                for (int i10 = 0; i10 < this.f1863b; i10++) {
                    View view = n10[i10];
                    left = Math.min(left, view.getLeft());
                    top = Math.min(top, view.getTop());
                    right = Math.max(right, view.getRight());
                    bottom = Math.max(bottom, view.getBottom());
                }
                this.f1384r = (float) right;
                this.f1385s = (float) bottom;
                this.f1386t = (float) left;
                this.f1387u = (float) top;
                this.f1382p = Float.isNaN(this.f1376j) ? (float) ((left + right) / 2) : this.f1376j;
                this.f1383q = Float.isNaN(this.f1377k) ? (float) ((top + bottom) / 2) : this.f1377k;
                return;
            }
            this.f1383q = this.f1377k;
            this.f1382p = this.f1376j;
        }
    }
}
