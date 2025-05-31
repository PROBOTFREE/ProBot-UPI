package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.x;
import j.f;

public class AlertDialogLayout extends LinearLayoutCompat {
    public AlertDialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void A(View view, int i10, int i11, int i12, int i13) {
        view.layout(i10, i11, i12 + i10, i13 + i11);
    }

    private static int B(View view) {
        int D = x.D(view);
        if (D > 0) {
            return D;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 1) {
                return B(viewGroup.getChildAt(0));
            }
        }
        return 0;
    }

    private boolean C(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16 = i10;
        int i17 = i11;
        int childCount = getChildCount();
        View view = null;
        View view2 = null;
        View view3 = null;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() != 8) {
                int id2 = childAt.getId();
                if (id2 == f.topPanel) {
                    view = childAt;
                } else if (id2 == f.buttonPanel) {
                    view2 = childAt;
                } else if ((id2 != f.contentPanel && id2 != f.customPanel) || view3 != null) {
                    return false;
                } else {
                    view3 = childAt;
                }
            }
        }
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i10);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (view != null) {
            view.measure(i16, 0);
            paddingTop += view.getMeasuredHeight();
            i12 = View.combineMeasuredStates(0, view.getMeasuredState());
        } else {
            i12 = 0;
        }
        if (view2 != null) {
            view2.measure(i16, 0);
            i14 = B(view2);
            i13 = view2.getMeasuredHeight() - i14;
            paddingTop += i14;
            i12 = View.combineMeasuredStates(i12, view2.getMeasuredState());
        } else {
            i14 = 0;
            i13 = 0;
        }
        if (view3 != null) {
            view3.measure(i16, mode == 0 ? 0 : View.MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingTop), mode));
            i15 = view3.getMeasuredHeight();
            paddingTop += i15;
            i12 = View.combineMeasuredStates(i12, view3.getMeasuredState());
        } else {
            i15 = 0;
        }
        int i19 = size - paddingTop;
        if (view2 != null) {
            int i20 = paddingTop - i14;
            int min = Math.min(i19, i13);
            if (min > 0) {
                i19 -= min;
                i14 += min;
            }
            view2.measure(i16, View.MeasureSpec.makeMeasureSpec(i14, 1073741824));
            paddingTop = i20 + view2.getMeasuredHeight();
            i12 = View.combineMeasuredStates(i12, view2.getMeasuredState());
        }
        if (view3 != null && i19 > 0) {
            view3.measure(i16, View.MeasureSpec.makeMeasureSpec(i15 + i19, mode));
            paddingTop = (paddingTop - i15) + view3.getMeasuredHeight();
            i12 = View.combineMeasuredStates(i12, view3.getMeasuredState());
        }
        int i21 = 0;
        for (int i22 = 0; i22 < childCount; i22++) {
            View childAt2 = getChildAt(i22);
            if (childAt2.getVisibility() != 8) {
                i21 = Math.max(i21, childAt2.getMeasuredWidth());
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i21 + getPaddingLeft() + getPaddingRight(), i16, i12), View.resolveSizeAndState(paddingTop, i17, 0));
        if (mode2 == 1073741824) {
            return true;
        }
        l(childCount, i17);
        return true;
    }

    private void l(int i10, int i11) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i12 = 0; i12 < i10; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i13 = layoutParams.height;
                    layoutParams.height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, i11, 0);
                    layoutParams.height = i13;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r18, int r19, int r20, int r21, int r22) {
        /*
            r17 = this;
            r6 = r17
            int r7 = r17.getPaddingLeft()
            int r0 = r21 - r19
            int r1 = r17.getPaddingRight()
            int r8 = r0 - r1
            int r0 = r0 - r7
            int r1 = r17.getPaddingRight()
            int r9 = r0 - r1
            int r0 = r17.getMeasuredHeight()
            int r10 = r17.getChildCount()
            int r1 = r17.getGravity()
            r2 = r1 & 112(0x70, float:1.57E-43)
            r3 = 8388615(0x800007, float:1.1754953E-38)
            r11 = r1 & r3
            r1 = 16
            if (r2 == r1) goto L_0x0040
            r1 = 80
            if (r2 == r1) goto L_0x0035
            int r0 = r17.getPaddingTop()
            goto L_0x004b
        L_0x0035:
            int r1 = r17.getPaddingTop()
            int r1 = r1 + r22
            int r1 = r1 - r20
            int r0 = r1 - r0
            goto L_0x004b
        L_0x0040:
            int r1 = r17.getPaddingTop()
            int r2 = r22 - r20
            int r2 = r2 - r0
            int r2 = r2 / 2
            int r0 = r1 + r2
        L_0x004b:
            android.graphics.drawable.Drawable r1 = r17.getDividerDrawable()
            r2 = 0
            if (r1 != 0) goto L_0x0054
            r12 = r2
            goto L_0x0059
        L_0x0054:
            int r1 = r1.getIntrinsicHeight()
            r12 = r1
        L_0x0059:
            r13 = r2
        L_0x005a:
            if (r13 >= r10) goto L_0x00bd
            android.view.View r1 = r6.getChildAt(r13)
            if (r1 == 0) goto L_0x00ba
            int r2 = r1.getVisibility()
            r3 = 8
            if (r2 == r3) goto L_0x00ba
            int r4 = r1.getMeasuredWidth()
            int r14 = r1.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()
            r15 = r2
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r15 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r15
            int r2 = r15.gravity
            if (r2 >= 0) goto L_0x007e
            r2 = r11
        L_0x007e:
            int r3 = androidx.core.view.x.C(r17)
            int r2 = androidx.core.view.f.b(r2, r3)
            r2 = r2 & 7
            r3 = 1
            if (r2 == r3) goto L_0x0095
            r3 = 5
            if (r2 == r3) goto L_0x0092
            int r2 = r15.leftMargin
            int r2 = r2 + r7
            goto L_0x00a0
        L_0x0092:
            int r2 = r8 - r4
            goto L_0x009d
        L_0x0095:
            int r2 = r9 - r4
            int r2 = r2 / 2
            int r2 = r2 + r7
            int r3 = r15.leftMargin
            int r2 = r2 + r3
        L_0x009d:
            int r3 = r15.rightMargin
            int r2 = r2 - r3
        L_0x00a0:
            boolean r3 = r6.t(r13)
            if (r3 == 0) goto L_0x00a7
            int r0 = r0 + r12
        L_0x00a7:
            int r3 = r15.topMargin
            int r16 = r0 + r3
            r0 = r17
            r3 = r16
            r5 = r14
            r0.A(r1, r2, r3, r4, r5)
            int r0 = r15.bottomMargin
            int r14 = r14 + r0
            int r16 = r16 + r14
            r0 = r16
        L_0x00ba:
            int r13 = r13 + 1
            goto L_0x005a
        L_0x00bd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AlertDialogLayout.onLayout(boolean, int, int, int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        if (!C(i10, i11)) {
            super.onMeasure(i10, i11);
        }
    }
}
