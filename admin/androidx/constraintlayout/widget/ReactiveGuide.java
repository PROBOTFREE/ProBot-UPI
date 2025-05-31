package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.g;

public class ReactiveGuide extends View implements g.a {

    /* renamed from: a  reason: collision with root package name */
    private int f1958a = -1;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1959b = false;

    /* renamed from: c  reason: collision with root package name */
    private int f1960c = 0;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1961d = true;

    public ReactiveGuide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
        a(attributeSet);
    }

    public ReactiveGuide(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        super.setVisibility(8);
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, f.ConstraintLayout_ReactiveGuide);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == f.ConstraintLayout_ReactiveGuide_reactiveGuide_valueId) {
                    this.f1958a = obtainStyledAttributes.getResourceId(index, this.f1958a);
                } else if (index == f.ConstraintLayout_ReactiveGuide_reactiveGuide_animateChange) {
                    this.f1959b = obtainStyledAttributes.getBoolean(index, this.f1959b);
                } else if (index == f.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToConstraintSet) {
                    this.f1960c = obtainStyledAttributes.getResourceId(index, this.f1960c);
                } else if (index == f.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToAllConstraintSets) {
                    this.f1961d = obtainStyledAttributes.getBoolean(index, this.f1961d);
                }
            }
            obtainStyledAttributes.recycle();
        }
        if (this.f1958a != -1) {
            ConstraintLayout.getSharedValues().a(this.f1958a, this);
        }
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    public int getApplyToConstraintSetId() {
        return this.f1960c;
    }

    public int getAttributeId() {
        return this.f1958a;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        setMeasuredDimension(0, 0);
    }

    public void setAnimateChange(boolean z10) {
        this.f1959b = z10;
    }

    public void setApplyToConstraintSetId(int i10) {
        this.f1960c = i10;
    }

    public void setAttributeId(int i10) {
        g sharedValues = ConstraintLayout.getSharedValues();
        int i11 = this.f1958a;
        if (i11 != -1) {
            sharedValues.b(i11, this);
        }
        this.f1958a = i10;
        if (i10 != -1) {
            sharedValues.a(i10, this);
        }
    }

    public void setGuidelineBegin(int i10) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.f1891a = i10;
        setLayoutParams(layoutParams);
    }

    public void setGuidelineEnd(int i10) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.f1893b = i10;
        setLayoutParams(layoutParams);
    }

    public void setGuidelinePercent(float f10) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.f1895c = f10;
        setLayoutParams(layoutParams);
    }

    public void setVisibility(int i10) {
    }
}
