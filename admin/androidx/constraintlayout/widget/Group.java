package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Group extends ConstraintHelper {
    public Group(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Group(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    /* access modifiers changed from: protected */
    public void j(ConstraintLayout constraintLayout) {
        i(constraintLayout);
    }

    /* access modifiers changed from: protected */
    public void o(AttributeSet attributeSet) {
        super.o(attributeSet);
        this.f1866e = false;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h();
    }

    public void r(ConstraintLayout constraintLayout) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.f1926r0.o1(0);
        layoutParams.f1926r0.P0(0);
    }

    public void setElevation(float f10) {
        super.setElevation(f10);
        h();
    }

    public void setVisibility(int i10) {
        super.setVisibility(i10);
        h();
    }
}
