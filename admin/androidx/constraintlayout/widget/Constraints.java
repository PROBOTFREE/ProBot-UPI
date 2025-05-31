package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Constraints extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    c f1945a;

    public static class LayoutParams extends ConstraintLayout.LayoutParams {
        public float A0;
        public float B0;
        public float C0;
        public float D0;
        public float E0;

        /* renamed from: s0  reason: collision with root package name */
        public float f1946s0;

        /* renamed from: t0  reason: collision with root package name */
        public boolean f1947t0;

        /* renamed from: u0  reason: collision with root package name */
        public float f1948u0;

        /* renamed from: v0  reason: collision with root package name */
        public float f1949v0;

        /* renamed from: w0  reason: collision with root package name */
        public float f1950w0;

        /* renamed from: x0  reason: collision with root package name */
        public float f1951x0;

        /* renamed from: y0  reason: collision with root package name */
        public float f1952y0;

        /* renamed from: z0  reason: collision with root package name */
        public float f1953z0;

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
            this.f1946s0 = 1.0f;
            this.f1947t0 = false;
            this.f1948u0 = 0.0f;
            this.f1949v0 = 0.0f;
            this.f1950w0 = 0.0f;
            this.f1951x0 = 0.0f;
            this.f1952y0 = 1.0f;
            this.f1953z0 = 1.0f;
            this.A0 = 0.0f;
            this.B0 = 0.0f;
            this.C0 = 0.0f;
            this.D0 = 0.0f;
            this.E0 = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1946s0 = 1.0f;
            this.f1947t0 = false;
            this.f1948u0 = 0.0f;
            this.f1949v0 = 0.0f;
            this.f1950w0 = 0.0f;
            this.f1951x0 = 0.0f;
            this.f1952y0 = 1.0f;
            this.f1953z0 = 1.0f;
            this.A0 = 0.0f;
            this.B0 = 0.0f;
            this.C0 = 0.0f;
            this.D0 = 0.0f;
            this.E0 = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.ConstraintSet);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == f.ConstraintSet_android_alpha) {
                    this.f1946s0 = obtainStyledAttributes.getFloat(index, this.f1946s0);
                } else if (index == f.ConstraintSet_android_elevation) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        this.f1948u0 = obtainStyledAttributes.getFloat(index, this.f1948u0);
                        this.f1947t0 = true;
                    }
                } else if (index == f.ConstraintSet_android_rotationX) {
                    this.f1950w0 = obtainStyledAttributes.getFloat(index, this.f1950w0);
                } else if (index == f.ConstraintSet_android_rotationY) {
                    this.f1951x0 = obtainStyledAttributes.getFloat(index, this.f1951x0);
                } else if (index == f.ConstraintSet_android_rotation) {
                    this.f1949v0 = obtainStyledAttributes.getFloat(index, this.f1949v0);
                } else if (index == f.ConstraintSet_android_scaleX) {
                    this.f1952y0 = obtainStyledAttributes.getFloat(index, this.f1952y0);
                } else if (index == f.ConstraintSet_android_scaleY) {
                    this.f1953z0 = obtainStyledAttributes.getFloat(index, this.f1953z0);
                } else if (index == f.ConstraintSet_android_transformPivotX) {
                    this.A0 = obtainStyledAttributes.getFloat(index, this.A0);
                } else if (index == f.ConstraintSet_android_transformPivotY) {
                    this.B0 = obtainStyledAttributes.getFloat(index, this.B0);
                } else if (index == f.ConstraintSet_android_translationX) {
                    this.C0 = obtainStyledAttributes.getFloat(index, this.C0);
                } else if (index == f.ConstraintSet_android_translationY) {
                    this.D0 = obtainStyledAttributes.getFloat(index, this.D0);
                } else if (index == f.ConstraintSet_android_translationZ && Build.VERSION.SDK_INT >= 21) {
                    this.E0 = obtainStyledAttributes.getFloat(index, this.E0);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public Constraints(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(attributeSet);
        super.setVisibility(8);
    }

    public Constraints(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        c(attributeSet);
        super.setVisibility(8);
    }

    private void c(AttributeSet attributeSet) {
        Log.v("Constraints", " ################# init");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    /* renamed from: b */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.LayoutParams(layoutParams);
    }

    public c getConstraintSet() {
        if (this.f1945a == null) {
            this.f1945a = new c();
        }
        this.f1945a.r(this);
        return this.f1945a;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
    }
}
