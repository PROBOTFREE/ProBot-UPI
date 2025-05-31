package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import h0.m;

public abstract class VirtualLayout extends ConstraintHelper {

    /* renamed from: j  reason: collision with root package name */
    private boolean f1962j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f1963k;

    public VirtualLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VirtualLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    /* access modifiers changed from: protected */
    public void j(ConstraintLayout constraintLayout) {
        i(constraintLayout);
    }

    /* access modifiers changed from: protected */
    public void o(AttributeSet attributeSet) {
        super.o(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, f.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == f.ConstraintLayout_Layout_android_visibility) {
                    this.f1962j = true;
                } else if (index == f.ConstraintLayout_Layout_android_elevation) {
                    this.f1963k = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f1962j || this.f1963k) {
            ViewParent parent = getParent();
            if (parent instanceof ConstraintLayout) {
                ConstraintLayout constraintLayout = (ConstraintLayout) parent;
                int visibility = getVisibility();
                float elevation = Build.VERSION.SDK_INT >= 21 ? getElevation() : 0.0f;
                for (int i10 = 0; i10 < this.f1863b; i10++) {
                    View l10 = constraintLayout.l(this.f1862a[i10]);
                    if (l10 != null) {
                        if (this.f1962j) {
                            l10.setVisibility(visibility);
                        }
                        if (this.f1963k && elevation > 0.0f && Build.VERSION.SDK_INT >= 21) {
                            l10.setTranslationZ(l10.getTranslationZ() + elevation);
                        }
                    }
                }
            }
        }
    }

    public void setElevation(float f10) {
        super.setElevation(f10);
        h();
    }

    public void setVisibility(int i10) {
        super.setVisibility(i10);
        h();
    }

    public void x(m mVar, int i10, int i11) {
    }
}
