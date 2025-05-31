package androidx.constraintlayout.helper.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.widget.VirtualLayout;
import h0.e;
import h0.f;
import h0.i;
import h0.l;
import h0.m;

public class MotionPlaceholder extends VirtualLayout {

    /* renamed from: l  reason: collision with root package name */
    l f1401l;

    public MotionPlaceholder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MotionPlaceholder(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    /* access modifiers changed from: protected */
    public void o(AttributeSet attributeSet) {
        super.o(attributeSet);
        this.f1865d = new l();
        w();
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"WrongCall"})
    public void onMeasure(int i10, int i11) {
        x(this.f1401l, i10, i11);
    }

    public void v(f fVar, i iVar, SparseArray<e> sparseArray) {
    }

    public void x(m mVar, int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i11);
        if (mVar != null) {
            mVar.G1(mode, size, mode2, size2);
            setMeasuredDimension(mVar.B1(), mVar.A1());
            return;
        }
        setMeasuredDimension(0, 0);
    }
}
