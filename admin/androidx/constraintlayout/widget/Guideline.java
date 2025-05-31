package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Guideline extends View {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1954a = true;

    public Guideline(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public Guideline(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Guideline(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        super.setVisibility(8);
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        setMeasuredDimension(0, 0);
    }

    public void setFilterRedundantCalls(boolean z10) {
        this.f1954a = z10;
    }

    public void setGuidelineBegin(int i10) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (!this.f1954a || layoutParams.f1891a != i10) {
            layoutParams.f1891a = i10;
            setLayoutParams(layoutParams);
        }
    }

    public void setGuidelineEnd(int i10) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (!this.f1954a || layoutParams.f1893b != i10) {
            layoutParams.f1893b = i10;
            setLayoutParams(layoutParams);
        }
    }

    public void setGuidelinePercent(float f10) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (!this.f1954a || layoutParams.f1895c != f10) {
            layoutParams.f1895c = f10;
            setLayoutParams(layoutParams);
        }
    }

    public void setVisibility(int i10) {
    }
}
