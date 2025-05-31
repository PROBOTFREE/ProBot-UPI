package androidx.constraintlayout.helper.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.VirtualLayout;
import androidx.constraintlayout.widget.c;
import androidx.constraintlayout.widget.f;
import h0.e;
import h0.g;
import h0.j;
import h0.m;

public class Flow extends VirtualLayout {

    /* renamed from: l  reason: collision with root package name */
    private g f1375l;

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Flow(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    /* access modifiers changed from: protected */
    public void o(AttributeSet attributeSet) {
        super.o(attributeSet);
        this.f1375l = new g();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, f.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == f.ConstraintLayout_Layout_android_orientation) {
                    this.f1375l.H2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == f.ConstraintLayout_Layout_android_padding) {
                    this.f1375l.M1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == f.ConstraintLayout_Layout_android_paddingStart) {
                    if (Build.VERSION.SDK_INT >= 17) {
                        this.f1375l.R1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                    }
                } else if (index == f.ConstraintLayout_Layout_android_paddingEnd) {
                    if (Build.VERSION.SDK_INT >= 17) {
                        this.f1375l.O1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                    }
                } else if (index == f.ConstraintLayout_Layout_android_paddingLeft) {
                    this.f1375l.P1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == f.ConstraintLayout_Layout_android_paddingTop) {
                    this.f1375l.S1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == f.ConstraintLayout_Layout_android_paddingRight) {
                    this.f1375l.Q1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == f.ConstraintLayout_Layout_android_paddingBottom) {
                    this.f1375l.N1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == f.ConstraintLayout_Layout_flow_wrapMode) {
                    this.f1375l.M2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == f.ConstraintLayout_Layout_flow_horizontalStyle) {
                    this.f1375l.B2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == f.ConstraintLayout_Layout_flow_verticalStyle) {
                    this.f1375l.L2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == f.ConstraintLayout_Layout_flow_firstHorizontalStyle) {
                    this.f1375l.v2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == f.ConstraintLayout_Layout_flow_lastHorizontalStyle) {
                    this.f1375l.D2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == f.ConstraintLayout_Layout_flow_firstVerticalStyle) {
                    this.f1375l.x2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == f.ConstraintLayout_Layout_flow_lastVerticalStyle) {
                    this.f1375l.F2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == f.ConstraintLayout_Layout_flow_horizontalBias) {
                    this.f1375l.z2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == f.ConstraintLayout_Layout_flow_firstHorizontalBias) {
                    this.f1375l.u2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == f.ConstraintLayout_Layout_flow_lastHorizontalBias) {
                    this.f1375l.C2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == f.ConstraintLayout_Layout_flow_firstVerticalBias) {
                    this.f1375l.w2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == f.ConstraintLayout_Layout_flow_lastVerticalBias) {
                    this.f1375l.E2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == f.ConstraintLayout_Layout_flow_verticalBias) {
                    this.f1375l.J2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == f.ConstraintLayout_Layout_flow_horizontalAlign) {
                    this.f1375l.y2(obtainStyledAttributes.getInt(index, 2));
                } else if (index == f.ConstraintLayout_Layout_flow_verticalAlign) {
                    this.f1375l.I2(obtainStyledAttributes.getInt(index, 2));
                } else if (index == f.ConstraintLayout_Layout_flow_horizontalGap) {
                    this.f1375l.A2(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == f.ConstraintLayout_Layout_flow_verticalGap) {
                    this.f1375l.K2(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == f.ConstraintLayout_Layout_flow_maxElementsWrap) {
                    this.f1375l.G2(obtainStyledAttributes.getInt(index, -1));
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f1865d = this.f1375l;
        w();
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"WrongCall"})
    public void onMeasure(int i10, int i11) {
        x(this.f1375l, i10, i11);
    }

    public void p(c.a aVar, j jVar, ConstraintLayout.LayoutParams layoutParams, SparseArray<e> sparseArray) {
        super.p(aVar, jVar, layoutParams, sparseArray);
        if (jVar instanceof g) {
            g gVar = (g) jVar;
            int i10 = layoutParams.V;
            if (i10 != -1) {
                gVar.H2(i10);
            }
        }
    }

    public void q(e eVar, boolean z10) {
        this.f1375l.x1(z10);
    }

    public void setFirstHorizontalBias(float f10) {
        this.f1375l.u2(f10);
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i10) {
        this.f1375l.v2(i10);
        requestLayout();
    }

    public void setFirstVerticalBias(float f10) {
        this.f1375l.w2(f10);
        requestLayout();
    }

    public void setFirstVerticalStyle(int i10) {
        this.f1375l.x2(i10);
        requestLayout();
    }

    public void setHorizontalAlign(int i10) {
        this.f1375l.y2(i10);
        requestLayout();
    }

    public void setHorizontalBias(float f10) {
        this.f1375l.z2(f10);
        requestLayout();
    }

    public void setHorizontalGap(int i10) {
        this.f1375l.A2(i10);
        requestLayout();
    }

    public void setHorizontalStyle(int i10) {
        this.f1375l.B2(i10);
        requestLayout();
    }

    public void setLastHorizontalBias(float f10) {
        this.f1375l.C2(f10);
        requestLayout();
    }

    public void setLastHorizontalStyle(int i10) {
        this.f1375l.D2(i10);
        requestLayout();
    }

    public void setLastVerticalBias(float f10) {
        this.f1375l.E2(f10);
        requestLayout();
    }

    public void setLastVerticalStyle(int i10) {
        this.f1375l.F2(i10);
        requestLayout();
    }

    public void setMaxElementsWrap(int i10) {
        this.f1375l.G2(i10);
        requestLayout();
    }

    public void setOrientation(int i10) {
        this.f1375l.H2(i10);
        requestLayout();
    }

    public void setPadding(int i10) {
        this.f1375l.M1(i10);
        requestLayout();
    }

    public void setPaddingBottom(int i10) {
        this.f1375l.N1(i10);
        requestLayout();
    }

    public void setPaddingLeft(int i10) {
        this.f1375l.P1(i10);
        requestLayout();
    }

    public void setPaddingRight(int i10) {
        this.f1375l.Q1(i10);
        requestLayout();
    }

    public void setPaddingTop(int i10) {
        this.f1375l.S1(i10);
        requestLayout();
    }

    public void setVerticalAlign(int i10) {
        this.f1375l.I2(i10);
        requestLayout();
    }

    public void setVerticalBias(float f10) {
        this.f1375l.J2(f10);
        requestLayout();
    }

    public void setVerticalGap(int i10) {
        this.f1375l.K2(i10);
        requestLayout();
    }

    public void setVerticalStyle(int i10) {
        this.f1375l.L2(i10);
        requestLayout();
    }

    public void setWrapMode(int i10) {
        this.f1375l.M2(i10);
        requestLayout();
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
