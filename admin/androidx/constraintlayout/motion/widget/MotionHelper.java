package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.f;
import java.util.HashMap;

public class MotionHelper extends ConstraintHelper implements MotionLayout.j {

    /* renamed from: j  reason: collision with root package name */
    private boolean f1402j = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f1403k = false;

    /* renamed from: l  reason: collision with root package name */
    private float f1404l;

    /* renamed from: m  reason: collision with root package name */
    protected View[] f1405m;

    public MotionHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        o(attributeSet);
    }

    public MotionHelper(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        o(attributeSet);
    }

    public void A(MotionLayout motionLayout) {
    }

    public void B(Canvas canvas) {
    }

    public void C(Canvas canvas) {
    }

    public void D(MotionLayout motionLayout, HashMap<View, m> hashMap) {
    }

    public void E(View view, float f10) {
    }

    public void a(MotionLayout motionLayout, int i10, int i11, float f10) {
    }

    public void b(MotionLayout motionLayout, int i10, int i11) {
    }

    public void c(MotionLayout motionLayout, int i10, boolean z10, float f10) {
    }

    public void d(MotionLayout motionLayout, int i10) {
    }

    public float getProgress() {
        return this.f1404l;
    }

    /* access modifiers changed from: protected */
    public void o(AttributeSet attributeSet) {
        super.o(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, f.MotionHelper);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == f.MotionHelper_onShow) {
                    this.f1402j = obtainStyledAttributes.getBoolean(index, this.f1402j);
                } else if (index == f.MotionHelper_onHide) {
                    this.f1403k = obtainStyledAttributes.getBoolean(index, this.f1403k);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void setProgress(float f10) {
        this.f1404l = f10;
        int i10 = 0;
        if (this.f1863b > 0) {
            this.f1405m = n((ConstraintLayout) getParent());
            while (i10 < this.f1863b) {
                E(this.f1405m[i10], f10);
                i10++;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        while (i10 < childCount) {
            View childAt = viewGroup.getChildAt(i10);
            if (!(childAt instanceof MotionHelper)) {
                E(childAt, f10);
            }
            i10++;
        }
    }

    public boolean x() {
        return false;
    }

    public boolean y() {
        return this.f1403k;
    }

    public boolean z() {
        return this.f1402j;
    }
}
