package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.core.view.x;
import j.j;

public class LinearLayoutCompat extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private boolean f848a;

    /* renamed from: b  reason: collision with root package name */
    private int f849b;

    /* renamed from: c  reason: collision with root package name */
    private int f850c;

    /* renamed from: d  reason: collision with root package name */
    private int f851d;

    /* renamed from: e  reason: collision with root package name */
    private int f852e;

    /* renamed from: f  reason: collision with root package name */
    private int f853f;

    /* renamed from: g  reason: collision with root package name */
    private float f854g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f855h;

    /* renamed from: i  reason: collision with root package name */
    private int[] f856i;

    /* renamed from: j  reason: collision with root package name */
    private int[] f857j;

    /* renamed from: k  reason: collision with root package name */
    private Drawable f858k;

    /* renamed from: l  reason: collision with root package name */
    private int f859l;

    /* renamed from: m  reason: collision with root package name */
    private int f860m;

    /* renamed from: n  reason: collision with root package name */
    private int f861n;

    /* renamed from: o  reason: collision with root package name */
    private int f862o;

    public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams(int i10, int i11) {
            super(i10, i11);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public LinearLayoutCompat(Context context) {
        this(context, (AttributeSet) null);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f848a = true;
        this.f849b = -1;
        this.f850c = 0;
        this.f852e = 8388659;
        int[] iArr = j.LinearLayoutCompat;
        g0 v10 = g0.v(context, attributeSet, iArr, i10, 0);
        x.p0(this, context, iArr, attributeSet, v10.r(), i10, 0);
        int k10 = v10.k(j.LinearLayoutCompat_android_orientation, -1);
        if (k10 >= 0) {
            setOrientation(k10);
        }
        int k11 = v10.k(j.LinearLayoutCompat_android_gravity, -1);
        if (k11 >= 0) {
            setGravity(k11);
        }
        boolean a10 = v10.a(j.LinearLayoutCompat_android_baselineAligned, true);
        if (!a10) {
            setBaselineAligned(a10);
        }
        this.f854g = v10.i(j.LinearLayoutCompat_android_weightSum, -1.0f);
        this.f849b = v10.k(j.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.f855h = v10.a(j.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(v10.g(j.LinearLayoutCompat_divider));
        this.f861n = v10.k(j.LinearLayoutCompat_showDividers, 0);
        this.f862o = v10.f(j.LinearLayoutCompat_dividerPadding, 0);
        v10.w();
    }

    private void A(View view, int i10, int i11, int i12, int i13) {
        view.layout(i10, i11, i12 + i10, i13 + i11);
    }

    private void k(int i10, int i11) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i12 = 0; i12 < i10; i12++) {
            View s10 = s(i12);
            if (s10.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) s10.getLayoutParams();
                if (layoutParams.height == -1) {
                    int i13 = layoutParams.width;
                    layoutParams.width = s10.getMeasuredWidth();
                    measureChildWithMargins(s10, i11, 0, makeMeasureSpec, 0);
                    layoutParams.width = i13;
                }
            }
        }
    }

    private void l(int i10, int i11) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i12 = 0; i12 < i10; i12++) {
            View s10 = s(i12);
            if (s10.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) s10.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i13 = layoutParams.height;
                    layoutParams.height = s10.getMeasuredHeight();
                    measureChildWithMargins(s10, makeMeasureSpec, 0, i11, 0);
                    layoutParams.height = i13;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: package-private */
    public void f(Canvas canvas) {
        int i10;
        int i11;
        int i12;
        int virtualChildCount = getVirtualChildCount();
        boolean b10 = m0.b(this);
        for (int i13 = 0; i13 < virtualChildCount; i13++) {
            View s10 = s(i13);
            if (!(s10 == null || s10.getVisibility() == 8 || !t(i13))) {
                LayoutParams layoutParams = (LayoutParams) s10.getLayoutParams();
                j(canvas, b10 ? s10.getRight() + layoutParams.rightMargin : (s10.getLeft() - layoutParams.leftMargin) - this.f859l);
            }
        }
        if (t(virtualChildCount)) {
            View s11 = s(virtualChildCount - 1);
            if (s11 != null) {
                LayoutParams layoutParams2 = (LayoutParams) s11.getLayoutParams();
                if (b10) {
                    i12 = s11.getLeft();
                    i11 = layoutParams2.leftMargin;
                } else {
                    i10 = s11.getRight() + layoutParams2.rightMargin;
                    j(canvas, i10);
                }
            } else if (b10) {
                i10 = getPaddingLeft();
                j(canvas, i10);
            } else {
                i12 = getWidth();
                i11 = getPaddingRight();
            }
            i10 = (i12 - i11) - this.f859l;
            j(canvas, i10);
        }
    }

    public int getBaseline() {
        int i10;
        if (this.f849b < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i11 = this.f849b;
        if (childCount > i11) {
            View childAt = getChildAt(i11);
            int baseline = childAt.getBaseline();
            if (baseline != -1) {
                int i12 = this.f850c;
                if (this.f851d == 1 && (i10 = this.f852e & 112) != 48) {
                    if (i10 == 16) {
                        i12 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f853f) / 2;
                    } else if (i10 == 80) {
                        i12 = ((getBottom() - getTop()) - getPaddingBottom()) - this.f853f;
                    }
                }
                return i12 + ((LayoutParams) childAt.getLayoutParams()).topMargin + baseline;
            } else if (this.f849b == 0) {
                return -1;
            } else {
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.f849b;
    }

    public Drawable getDividerDrawable() {
        return this.f858k;
    }

    public int getDividerPadding() {
        return this.f862o;
    }

    public int getDividerWidth() {
        return this.f859l;
    }

    public int getGravity() {
        return this.f852e;
    }

    public int getOrientation() {
        return this.f851d;
    }

    public int getShowDividers() {
        return this.f861n;
    }

    /* access modifiers changed from: package-private */
    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f854g;
    }

    /* access modifiers changed from: package-private */
    public void h(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i10 = 0; i10 < virtualChildCount; i10++) {
            View s10 = s(i10);
            if (!(s10 == null || s10.getVisibility() == 8 || !t(i10))) {
                i(canvas, (s10.getTop() - ((LayoutParams) s10.getLayoutParams()).topMargin) - this.f860m);
            }
        }
        if (t(virtualChildCount)) {
            View s11 = s(virtualChildCount - 1);
            i(canvas, s11 == null ? (getHeight() - getPaddingBottom()) - this.f860m : s11.getBottom() + ((LayoutParams) s11.getLayoutParams()).bottomMargin);
        }
    }

    /* access modifiers changed from: package-private */
    public void i(Canvas canvas, int i10) {
        this.f858k.setBounds(getPaddingLeft() + this.f862o, i10, (getWidth() - getPaddingRight()) - this.f862o, this.f860m + i10);
        this.f858k.draw(canvas);
    }

    /* access modifiers changed from: package-private */
    public void j(Canvas canvas, int i10) {
        this.f858k.setBounds(i10, getPaddingTop() + this.f862o, this.f859l + i10, (getHeight() - getPaddingBottom()) - this.f862o);
        this.f858k.draw(canvas);
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public LayoutParams generateDefaultLayoutParams() {
        int i10 = this.f851d;
        if (i10 == 0) {
            return new LayoutParams(-2, -2);
        }
        if (i10 == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    /* renamed from: n */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f858k != null) {
            if (this.f851d == 1) {
                h(canvas);
            } else {
                f(canvas);
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (this.f851d == 1) {
            v(i10, i11, i12, i13);
        } else {
            u(i10, i11, i12, i13);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        if (this.f851d == 1) {
            z(i10, i11);
        } else {
            x(i10, i11);
        }
    }

    /* access modifiers changed from: package-private */
    public int p(View view, int i10) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int q(View view) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int r(View view) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public View s(int i10) {
        return getChildAt(i10);
    }

    public void setBaselineAligned(boolean z10) {
        this.f848a = z10;
    }

    public void setBaselineAlignedChildIndex(int i10) {
        if (i10 < 0 || i10 >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.f849b = i10;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable != this.f858k) {
            this.f858k = drawable;
            boolean z10 = false;
            if (drawable != null) {
                this.f859l = drawable.getIntrinsicWidth();
                this.f860m = drawable.getIntrinsicHeight();
            } else {
                this.f859l = 0;
                this.f860m = 0;
            }
            if (drawable == null) {
                z10 = true;
            }
            setWillNotDraw(z10);
            requestLayout();
        }
    }

    public void setDividerPadding(int i10) {
        this.f862o = i10;
    }

    public void setGravity(int i10) {
        if (this.f852e != i10) {
            if ((8388615 & i10) == 0) {
                i10 |= 8388611;
            }
            if ((i10 & 112) == 0) {
                i10 |= 48;
            }
            this.f852e = i10;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i10) {
        int i11 = i10 & 8388615;
        int i12 = this.f852e;
        if ((8388615 & i12) != i11) {
            this.f852e = i11 | (-8388616 & i12);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z10) {
        this.f855h = z10;
    }

    public void setOrientation(int i10) {
        if (this.f851d != i10) {
            this.f851d = i10;
            requestLayout();
        }
    }

    public void setShowDividers(int i10) {
        if (i10 != this.f861n) {
            requestLayout();
        }
        this.f861n = i10;
    }

    public void setVerticalGravity(int i10) {
        int i11 = i10 & 112;
        int i12 = this.f852e;
        if ((i12 & 112) != i11) {
            this.f852e = i11 | (i12 & -113);
            requestLayout();
        }
    }

    public void setWeightSum(float f10) {
        this.f854g = Math.max(0.0f, f10);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean t(int i10) {
        if (i10 == 0) {
            return (this.f861n & 1) != 0;
        }
        if (i10 == getChildCount()) {
            return (this.f861n & 4) != 0;
        }
        if ((this.f861n & 2) == 0) {
            return false;
        }
        for (int i11 = i10 - 1; i11 >= 0; i11--) {
            if (getChildAt(i11).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ff  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void u(int r25, int r26, int r27, int r28) {
        /*
            r24 = this;
            r6 = r24
            boolean r0 = androidx.appcompat.widget.m0.b(r24)
            int r7 = r24.getPaddingTop()
            int r1 = r28 - r26
            int r2 = r24.getPaddingBottom()
            int r8 = r1 - r2
            int r1 = r1 - r7
            int r2 = r24.getPaddingBottom()
            int r9 = r1 - r2
            int r10 = r24.getVirtualChildCount()
            int r1 = r6.f852e
            r2 = 8388615(0x800007, float:1.1754953E-38)
            r2 = r2 & r1
            r11 = r1 & 112(0x70, float:1.57E-43)
            boolean r12 = r6.f848a
            int[] r13 = r6.f856i
            int[] r14 = r6.f857j
            int r1 = androidx.core.view.x.C(r24)
            int r1 = androidx.core.view.f.b(r2, r1)
            r15 = 2
            r5 = 1
            if (r1 == r5) goto L_0x004b
            r2 = 5
            if (r1 == r2) goto L_0x003f
            int r1 = r24.getPaddingLeft()
            goto L_0x0056
        L_0x003f:
            int r1 = r24.getPaddingLeft()
            int r1 = r1 + r27
            int r1 = r1 - r25
            int r2 = r6.f853f
            int r1 = r1 - r2
            goto L_0x0056
        L_0x004b:
            int r1 = r24.getPaddingLeft()
            int r2 = r27 - r25
            int r3 = r6.f853f
            int r2 = r2 - r3
            int r2 = r2 / r15
            int r1 = r1 + r2
        L_0x0056:
            r2 = 0
            if (r0 == 0) goto L_0x0060
            int r0 = r10 + -1
            r16 = r0
            r17 = -1
            goto L_0x0064
        L_0x0060:
            r16 = r2
            r17 = r5
        L_0x0064:
            r3 = r2
        L_0x0065:
            if (r3 >= r10) goto L_0x0148
            int r0 = r17 * r3
            int r2 = r16 + r0
            android.view.View r0 = r6.s(r2)
            if (r0 != 0) goto L_0x0080
            int r0 = r6.y(r2)
            int r1 = r1 + r0
            r21 = r5
            r22 = r7
            r19 = r10
            r20 = r11
            goto L_0x0139
        L_0x0080:
            int r5 = r0.getVisibility()
            r15 = 8
            if (r5 == r15) goto L_0x012f
            int r15 = r0.getMeasuredWidth()
            int r5 = r0.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r18 = r0.getLayoutParams()
            r4 = r18
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r4 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r4
            r18 = r3
            if (r12 == 0) goto L_0x00a8
            int r3 = r4.height
            r19 = r10
            r10 = -1
            if (r3 == r10) goto L_0x00aa
            int r10 = r0.getBaseline()
            goto L_0x00ab
        L_0x00a8:
            r19 = r10
        L_0x00aa:
            r10 = -1
        L_0x00ab:
            int r3 = r4.gravity
            if (r3 >= 0) goto L_0x00b0
            r3 = r11
        L_0x00b0:
            r3 = r3 & 112(0x70, float:1.57E-43)
            r20 = r11
            r11 = 16
            if (r3 == r11) goto L_0x00eb
            r11 = 48
            if (r3 == r11) goto L_0x00d9
            r11 = 80
            if (r3 == r11) goto L_0x00c3
            r3 = r7
            r11 = -1
            goto L_0x00e8
        L_0x00c3:
            int r3 = r8 - r5
            int r11 = r4.bottomMargin
            int r3 = r3 - r11
            r11 = -1
            if (r10 == r11) goto L_0x00e8
            int r21 = r0.getMeasuredHeight()
            int r21 = r21 - r10
            r10 = 2
            r22 = r14[r10]
            int r22 = r22 - r21
            int r3 = r3 - r22
            goto L_0x00e8
        L_0x00d9:
            r11 = -1
            int r3 = r4.topMargin
            int r3 = r3 + r7
            if (r10 == r11) goto L_0x00e8
            r21 = 1
            r22 = r13[r21]
            int r22 = r22 - r10
            int r3 = r3 + r22
            goto L_0x00f9
        L_0x00e8:
            r21 = 1
            goto L_0x00f9
        L_0x00eb:
            r11 = -1
            r21 = 1
            int r3 = r9 - r5
            r10 = 2
            int r3 = r3 / r10
            int r3 = r3 + r7
            int r10 = r4.topMargin
            int r3 = r3 + r10
            int r10 = r4.bottomMargin
            int r3 = r3 - r10
        L_0x00f9:
            boolean r10 = r6.t(r2)
            if (r10 == 0) goto L_0x0102
            int r10 = r6.f859l
            int r1 = r1 + r10
        L_0x0102:
            int r10 = r4.leftMargin
            int r10 = r10 + r1
            int r1 = r6.q(r0)
            int r22 = r10 + r1
            r1 = r0
            r0 = r24
            r25 = r1
            r11 = r2
            r2 = r22
            r22 = r7
            r23 = -1
            r7 = r4
            r4 = r15
            r0.A(r1, r2, r3, r4, r5)
            int r0 = r7.rightMargin
            int r15 = r15 + r0
            r0 = r25
            int r1 = r6.r(r0)
            int r15 = r15 + r1
            int r10 = r10 + r15
            int r0 = r6.p(r0, r11)
            int r3 = r18 + r0
            r1 = r10
            goto L_0x013b
        L_0x012f:
            r18 = r3
            r22 = r7
            r19 = r10
            r20 = r11
            r21 = 1
        L_0x0139:
            r23 = -1
        L_0x013b:
            int r3 = r3 + 1
            r10 = r19
            r11 = r20
            r5 = r21
            r7 = r22
            r15 = 2
            goto L_0x0065
        L_0x0148:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.u(int, int, int, int):void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void v(int r18, int r19, int r20, int r21) {
        /*
            r17 = this;
            r6 = r17
            int r7 = r17.getPaddingLeft()
            int r0 = r20 - r18
            int r1 = r17.getPaddingRight()
            int r8 = r0 - r1
            int r0 = r0 - r7
            int r1 = r17.getPaddingRight()
            int r9 = r0 - r1
            int r10 = r17.getVirtualChildCount()
            int r0 = r6.f852e
            r1 = r0 & 112(0x70, float:1.57E-43)
            r2 = 8388615(0x800007, float:1.1754953E-38)
            r11 = r0 & r2
            r0 = 16
            if (r1 == r0) goto L_0x003b
            r0 = 80
            if (r1 == r0) goto L_0x002f
            int r0 = r17.getPaddingTop()
            goto L_0x0047
        L_0x002f:
            int r0 = r17.getPaddingTop()
            int r0 = r0 + r21
            int r0 = r0 - r19
            int r1 = r6.f853f
            int r0 = r0 - r1
            goto L_0x0047
        L_0x003b:
            int r0 = r17.getPaddingTop()
            int r1 = r21 - r19
            int r2 = r6.f853f
            int r1 = r1 - r2
            int r1 = r1 / 2
            int r0 = r0 + r1
        L_0x0047:
            r1 = 0
            r12 = r1
        L_0x0049:
            if (r12 >= r10) goto L_0x00c8
            android.view.View r13 = r6.s(r12)
            r14 = 1
            if (r13 != 0) goto L_0x0059
            int r1 = r6.y(r12)
            int r0 = r0 + r1
            goto L_0x00c5
        L_0x0059:
            int r1 = r13.getVisibility()
            r2 = 8
            if (r1 == r2) goto L_0x00c5
            int r4 = r13.getMeasuredWidth()
            int r15 = r13.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r1 = r13.getLayoutParams()
            r5 = r1
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r5 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r5
            int r1 = r5.gravity
            if (r1 >= 0) goto L_0x0075
            r1 = r11
        L_0x0075:
            int r2 = androidx.core.view.x.C(r17)
            int r1 = androidx.core.view.f.b(r1, r2)
            r1 = r1 & 7
            if (r1 == r14) goto L_0x008b
            r2 = 5
            if (r1 == r2) goto L_0x0088
            int r1 = r5.leftMargin
            int r1 = r1 + r7
            goto L_0x0096
        L_0x0088:
            int r1 = r8 - r4
            goto L_0x0093
        L_0x008b:
            int r1 = r9 - r4
            int r1 = r1 / 2
            int r1 = r1 + r7
            int r2 = r5.leftMargin
            int r1 = r1 + r2
        L_0x0093:
            int r2 = r5.rightMargin
            int r1 = r1 - r2
        L_0x0096:
            r2 = r1
            boolean r1 = r6.t(r12)
            if (r1 == 0) goto L_0x00a0
            int r1 = r6.f860m
            int r0 = r0 + r1
        L_0x00a0:
            int r1 = r5.topMargin
            int r16 = r0 + r1
            int r0 = r6.q(r13)
            int r3 = r16 + r0
            r0 = r17
            r1 = r13
            r14 = r5
            r5 = r15
            r0.A(r1, r2, r3, r4, r5)
            int r0 = r14.bottomMargin
            int r15 = r15 + r0
            int r0 = r6.r(r13)
            int r15 = r15 + r0
            int r16 = r16 + r15
            int r0 = r6.p(r13, r12)
            int r12 = r12 + r0
            r0 = r16
            r1 = 1
            goto L_0x00c6
        L_0x00c5:
            r1 = r14
        L_0x00c6:
            int r12 = r12 + r1
            goto L_0x0049
        L_0x00c8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.v(int, int, int, int):void");
    }

    /* access modifiers changed from: package-private */
    public void w(View view, int i10, int i11, int i12, int i13, int i14) {
        measureChildWithMargins(view, i11, i12, i13, i14);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x03a5, code lost:
        if (r8 > 0) goto L_0x03b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x03b0, code lost:
        if (r8 < 0) goto L_0x03b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x03b2, code lost:
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x03b3, code lost:
        r14.measure(android.view.View.MeasureSpec.makeMeasureSpec(r8, r3), r0);
        r9 = android.view.View.combineMeasuredStates(r9, r14.getMeasuredState() & -16777216);
        r0 = r23;
        r3 = r24;
     */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x0440  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01bf  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01c7  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01d2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void x(int r39, int r40) {
        /*
            r38 = this;
            r7 = r38
            r8 = r39
            r9 = r40
            r10 = 0
            r7.f853f = r10
            int r11 = r38.getVirtualChildCount()
            int r12 = android.view.View.MeasureSpec.getMode(r39)
            int r13 = android.view.View.MeasureSpec.getMode(r40)
            int[] r0 = r7.f856i
            r14 = 4
            if (r0 == 0) goto L_0x001e
            int[] r0 = r7.f857j
            if (r0 != 0) goto L_0x0026
        L_0x001e:
            int[] r0 = new int[r14]
            r7.f856i = r0
            int[] r0 = new int[r14]
            r7.f857j = r0
        L_0x0026:
            int[] r15 = r7.f856i
            int[] r6 = r7.f857j
            r16 = 3
            r5 = -1
            r15[r16] = r5
            r17 = 2
            r15[r17] = r5
            r18 = 1
            r15[r18] = r5
            r15[r10] = r5
            r6[r16] = r5
            r6[r17] = r5
            r6[r18] = r5
            r6[r10] = r5
            boolean r4 = r7.f848a
            boolean r3 = r7.f855h
            r2 = 1073741824(0x40000000, float:2.0)
            if (r12 != r2) goto L_0x004c
            r19 = r18
            goto L_0x004e
        L_0x004c:
            r19 = r10
        L_0x004e:
            r20 = 0
            r1 = r10
            r14 = r1
            r21 = r14
            r22 = r21
            r23 = r22
            r24 = r23
            r25 = r24
            r27 = r25
            r26 = r18
            r0 = r20
        L_0x0062:
            r28 = r6
            r5 = 8
            if (r1 >= r11) goto L_0x01fd
            android.view.View r6 = r7.s(r1)
            if (r6 != 0) goto L_0x0082
            int r5 = r7.f853f
            int r6 = r7.y(r1)
            int r5 = r5 + r6
            r7.f853f = r5
        L_0x0077:
            r32 = r3
            r36 = r4
            r37 = r2
            r2 = r1
            r1 = r37
            goto L_0x01ea
        L_0x0082:
            int r10 = r6.getVisibility()
            if (r10 != r5) goto L_0x008e
            int r5 = r7.p(r6, r1)
            int r1 = r1 + r5
            goto L_0x0077
        L_0x008e:
            boolean r5 = r7.t(r1)
            if (r5 == 0) goto L_0x009b
            int r5 = r7.f853f
            int r10 = r7.f859l
            int r5 = r5 + r10
            r7.f853f = r5
        L_0x009b:
            android.view.ViewGroup$LayoutParams r5 = r6.getLayoutParams()
            r10 = r5
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r10 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r10
            float r5 = r10.weight
            float r31 = r0 + r5
            if (r12 != r2) goto L_0x00eb
            int r0 = r10.width
            if (r0 != 0) goto L_0x00eb
            int r0 = (r5 > r20 ? 1 : (r5 == r20 ? 0 : -1))
            if (r0 <= 0) goto L_0x00eb
            int r0 = r7.f853f
            if (r19 == 0) goto L_0x00bb
            int r5 = r10.leftMargin
            int r2 = r10.rightMargin
            int r5 = r5 + r2
            int r0 = r0 + r5
            goto L_0x00c5
        L_0x00bb:
            int r2 = r10.leftMargin
            int r2 = r2 + r0
            int r5 = r10.rightMargin
            int r2 = r2 + r5
            int r0 = java.lang.Math.max(r0, r2)
        L_0x00c5:
            r7.f853f = r0
            if (r4 == 0) goto L_0x00dc
            r0 = 0
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r0)
            r6.measure(r2, r2)
            r34 = r1
            r32 = r3
            r36 = r4
            r3 = r6
            r30 = -2
            goto L_0x0163
        L_0x00dc:
            r34 = r1
            r32 = r3
            r36 = r4
            r3 = r6
            r24 = r18
            r1 = 1073741824(0x40000000, float:2.0)
            r30 = -2
            goto L_0x0165
        L_0x00eb:
            int r0 = r10.width
            if (r0 != 0) goto L_0x00f8
            int r0 = (r5 > r20 ? 1 : (r5 == r20 ? 0 : -1))
            if (r0 <= 0) goto L_0x00f8
            r5 = -2
            r10.width = r5
            r2 = 0
            goto L_0x00fb
        L_0x00f8:
            r5 = -2
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x00fb:
            int r0 = (r31 > r20 ? 1 : (r31 == r20 ? 0 : -1))
            if (r0 != 0) goto L_0x0104
            int r0 = r7.f853f
            r29 = r0
            goto L_0x0106
        L_0x0104:
            r29 = 0
        L_0x0106:
            r33 = 0
            r0 = r38
            r34 = r1
            r1 = r6
            r35 = r2
            r2 = r34
            r32 = r3
            r3 = r39
            r36 = r4
            r4 = r29
            r29 = r5
            r9 = -1
            r5 = r40
            r30 = r29
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            r29 = r6
            r6 = r33
            r0.w(r1, r2, r3, r4, r5, r6)
            r0 = r35
            if (r0 == r9) goto L_0x012f
            r10.width = r0
        L_0x012f:
            int r0 = r29.getMeasuredWidth()
            if (r19 == 0) goto L_0x0146
            int r1 = r7.f853f
            int r2 = r10.leftMargin
            int r2 = r2 + r0
            int r3 = r10.rightMargin
            int r2 = r2 + r3
            r3 = r29
            int r4 = r7.r(r3)
            int r2 = r2 + r4
            int r1 = r1 + r2
            goto L_0x015b
        L_0x0146:
            r3 = r29
            int r1 = r7.f853f
            int r2 = r1 + r0
            int r4 = r10.leftMargin
            int r2 = r2 + r4
            int r4 = r10.rightMargin
            int r2 = r2 + r4
            int r4 = r7.r(r3)
            int r2 = r2 + r4
            int r1 = java.lang.Math.max(r1, r2)
        L_0x015b:
            r7.f853f = r1
            if (r32 == 0) goto L_0x0163
            int r14 = java.lang.Math.max(r0, r14)
        L_0x0163:
            r1 = 1073741824(0x40000000, float:2.0)
        L_0x0165:
            if (r13 == r1) goto L_0x0171
            int r0 = r10.height
            r2 = -1
            if (r0 != r2) goto L_0x0171
            r0 = r18
            r27 = r0
            goto L_0x0172
        L_0x0171:
            r0 = 0
        L_0x0172:
            int r2 = r10.topMargin
            int r4 = r10.bottomMargin
            int r2 = r2 + r4
            int r4 = r3.getMeasuredHeight()
            int r4 = r4 + r2
            int r5 = r3.getMeasuredState()
            r6 = r25
            int r25 = android.view.View.combineMeasuredStates(r6, r5)
            if (r36 == 0) goto L_0x01af
            int r5 = r3.getBaseline()
            r6 = -1
            if (r5 == r6) goto L_0x01af
            int r6 = r10.gravity
            if (r6 >= 0) goto L_0x0195
            int r6 = r7.f852e
        L_0x0195:
            r6 = r6 & 112(0x70, float:1.57E-43)
            r9 = 4
            int r6 = r6 >> r9
            r6 = r6 & -2
            int r6 = r6 >> 1
            r9 = r15[r6]
            int r9 = java.lang.Math.max(r9, r5)
            r15[r6] = r9
            r9 = r28[r6]
            int r5 = r4 - r5
            int r5 = java.lang.Math.max(r9, r5)
            r28[r6] = r5
        L_0x01af:
            r5 = r21
            int r21 = java.lang.Math.max(r5, r4)
            if (r26 == 0) goto L_0x01bf
            int r5 = r10.height
            r6 = -1
            if (r5 != r6) goto L_0x01bf
            r26 = r18
            goto L_0x01c1
        L_0x01bf:
            r26 = 0
        L_0x01c1:
            float r5 = r10.weight
            int r5 = (r5 > r20 ? 1 : (r5 == r20 ? 0 : -1))
            if (r5 <= 0) goto L_0x01d2
            if (r0 == 0) goto L_0x01ca
            goto L_0x01cb
        L_0x01ca:
            r2 = r4
        L_0x01cb:
            r10 = r23
            int r23 = java.lang.Math.max(r10, r2)
            goto L_0x01e0
        L_0x01d2:
            r10 = r23
            if (r0 == 0) goto L_0x01d7
            goto L_0x01d8
        L_0x01d7:
            r2 = r4
        L_0x01d8:
            r4 = r22
            int r22 = java.lang.Math.max(r4, r2)
            r23 = r10
        L_0x01e0:
            r10 = r34
            int r0 = r7.p(r3, r10)
            int r0 = r0 + r10
            r2 = r0
            r0 = r31
        L_0x01ea:
            int r2 = r2 + 1
            r9 = r40
            r6 = r28
            r3 = r32
            r4 = r36
            r5 = -1
            r10 = 0
            r37 = r2
            r2 = r1
            r1 = r37
            goto L_0x0062
        L_0x01fd:
            r1 = r2
            r32 = r3
            r36 = r4
            r2 = r21
            r4 = r22
            r10 = r23
            r6 = r25
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            r30 = -2
            int r3 = r7.f853f
            if (r3 <= 0) goto L_0x021f
            boolean r3 = r7.t(r11)
            if (r3 == 0) goto L_0x021f
            int r3 = r7.f853f
            int r1 = r7.f859l
            int r3 = r3 + r1
            r7.f853f = r3
        L_0x021f:
            r1 = r15[r18]
            r3 = -1
            if (r1 != r3) goto L_0x0236
            r1 = 0
            r5 = r15[r1]
            if (r5 != r3) goto L_0x0236
            r1 = r15[r17]
            if (r1 != r3) goto L_0x0236
            r1 = r15[r16]
            if (r1 == r3) goto L_0x0232
            goto L_0x0236
        L_0x0232:
            r1 = r2
            r23 = r6
            goto L_0x0267
        L_0x0236:
            r1 = r15[r16]
            r3 = 0
            r5 = r15[r3]
            r9 = r15[r18]
            r3 = r15[r17]
            int r3 = java.lang.Math.max(r9, r3)
            int r3 = java.lang.Math.max(r5, r3)
            int r1 = java.lang.Math.max(r1, r3)
            r3 = r28[r16]
            r5 = 0
            r9 = r28[r5]
            r5 = r28[r18]
            r23 = r6
            r6 = r28[r17]
            int r5 = java.lang.Math.max(r5, r6)
            int r5 = java.lang.Math.max(r9, r5)
            int r3 = java.lang.Math.max(r3, r5)
            int r1 = r1 + r3
            int r1 = java.lang.Math.max(r2, r1)
        L_0x0267:
            if (r32 == 0) goto L_0x02c8
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r12 == r2) goto L_0x026f
            if (r12 != 0) goto L_0x02c8
        L_0x026f:
            r2 = 0
            r7.f853f = r2
            r2 = 0
        L_0x0273:
            if (r2 >= r11) goto L_0x02c8
            android.view.View r3 = r7.s(r2)
            if (r3 != 0) goto L_0x0285
            int r3 = r7.f853f
            int r5 = r7.y(r2)
            int r3 = r3 + r5
            r7.f853f = r3
            goto L_0x0292
        L_0x0285:
            int r5 = r3.getVisibility()
            r6 = 8
            if (r5 != r6) goto L_0x0295
            int r3 = r7.p(r3, r2)
            int r2 = r2 + r3
        L_0x0292:
            r22 = r1
            goto L_0x02c3
        L_0x0295:
            android.view.ViewGroup$LayoutParams r5 = r3.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r5 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r5
            int r6 = r7.f853f
            if (r19 == 0) goto L_0x02ae
            int r9 = r5.leftMargin
            int r9 = r9 + r14
            int r5 = r5.rightMargin
            int r9 = r9 + r5
            int r3 = r7.r(r3)
            int r9 = r9 + r3
            int r6 = r6 + r9
            r7.f853f = r6
            goto L_0x0292
        L_0x02ae:
            int r9 = r6 + r14
            r22 = r1
            int r1 = r5.leftMargin
            int r9 = r9 + r1
            int r1 = r5.rightMargin
            int r9 = r9 + r1
            int r1 = r7.r(r3)
            int r9 = r9 + r1
            int r1 = java.lang.Math.max(r6, r9)
            r7.f853f = r1
        L_0x02c3:
            int r2 = r2 + 1
            r1 = r22
            goto L_0x0273
        L_0x02c8:
            r22 = r1
            int r1 = r7.f853f
            int r2 = r38.getPaddingLeft()
            int r3 = r38.getPaddingRight()
            int r2 = r2 + r3
            int r1 = r1 + r2
            r7.f853f = r1
            int r2 = r38.getSuggestedMinimumWidth()
            int r1 = java.lang.Math.max(r1, r2)
            r2 = 0
            int r1 = android.view.View.resolveSizeAndState(r1, r8, r2)
            r2 = 16777215(0xffffff, float:2.3509886E-38)
            r2 = r2 & r1
            int r3 = r7.f853f
            int r2 = r2 - r3
            if (r24 != 0) goto L_0x0339
            if (r2 == 0) goto L_0x02f5
            int r5 = (r0 > r20 ? 1 : (r0 == r20 ? 0 : -1))
            if (r5 <= 0) goto L_0x02f5
            goto L_0x0339
        L_0x02f5:
            int r0 = java.lang.Math.max(r4, r10)
            if (r32 == 0) goto L_0x0331
            r2 = 1073741824(0x40000000, float:2.0)
            if (r12 == r2) goto L_0x0331
            r10 = 0
        L_0x0300:
            if (r10 >= r11) goto L_0x0331
            android.view.View r2 = r7.s(r10)
            if (r2 == 0) goto L_0x032e
            int r4 = r2.getVisibility()
            r5 = 8
            if (r4 != r5) goto L_0x0311
            goto L_0x032e
        L_0x0311:
            android.view.ViewGroup$LayoutParams r4 = r2.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r4 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r4
            float r4 = r4.weight
            int r4 = (r4 > r20 ? 1 : (r4 == r20 ? 0 : -1))
            if (r4 <= 0) goto L_0x032e
            r4 = 1073741824(0x40000000, float:2.0)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r14, r4)
            int r6 = r2.getMeasuredHeight()
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r4)
            r2.measure(r5, r6)
        L_0x032e:
            int r10 = r10 + 1
            goto L_0x0300
        L_0x0331:
            r2 = r40
            r25 = r11
            r3 = r22
            goto L_0x04c9
        L_0x0339:
            float r5 = r7.f854g
            int r6 = (r5 > r20 ? 1 : (r5 == r20 ? 0 : -1))
            if (r6 <= 0) goto L_0x0340
            r0 = r5
        L_0x0340:
            r5 = -1
            r15[r16] = r5
            r15[r17] = r5
            r15[r18] = r5
            r6 = 0
            r15[r6] = r5
            r28[r16] = r5
            r28[r17] = r5
            r28[r18] = r5
            r28[r6] = r5
            r7.f853f = r6
            r6 = r4
            r4 = r5
            r9 = r23
            r10 = 0
        L_0x0359:
            if (r10 >= r11) goto L_0x0470
            android.view.View r14 = r7.s(r10)
            if (r14 == 0) goto L_0x0461
            int r5 = r14.getVisibility()
            r3 = 8
            if (r5 != r3) goto L_0x036b
            goto L_0x0461
        L_0x036b:
            android.view.ViewGroup$LayoutParams r5 = r14.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r5 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r5
            float r3 = r5.weight
            int r23 = (r3 > r20 ? 1 : (r3 == r20 ? 0 : -1))
            if (r23 <= 0) goto L_0x03ca
            float r8 = (float) r2
            float r8 = r8 * r3
            float r8 = r8 / r0
            int r8 = (int) r8
            float r0 = r0 - r3
            int r2 = r2 - r8
            int r3 = r38.getPaddingTop()
            int r23 = r38.getPaddingBottom()
            int r3 = r3 + r23
            r23 = r0
            int r0 = r5.topMargin
            int r3 = r3 + r0
            int r0 = r5.bottomMargin
            int r3 = r3 + r0
            int r0 = r5.height
            r24 = r2
            r25 = r11
            r11 = -1
            r2 = r40
            int r0 = android.view.ViewGroup.getChildMeasureSpec(r2, r3, r0)
            int r3 = r5.width
            if (r3 != 0) goto L_0x03a8
            r3 = 1073741824(0x40000000, float:2.0)
            if (r12 == r3) goto L_0x03a5
            goto L_0x03aa
        L_0x03a5:
            if (r8 <= 0) goto L_0x03b2
            goto L_0x03b3
        L_0x03a8:
            r3 = 1073741824(0x40000000, float:2.0)
        L_0x03aa:
            int r29 = r14.getMeasuredWidth()
            int r8 = r29 + r8
            if (r8 >= 0) goto L_0x03b3
        L_0x03b2:
            r8 = 0
        L_0x03b3:
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r3)
            r14.measure(r8, r0)
            int r0 = r14.getMeasuredState()
            r3 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r0 = r0 & r3
            int r9 = android.view.View.combineMeasuredStates(r9, r0)
            r0 = r23
            r3 = r24
            goto L_0x03d0
        L_0x03ca:
            r3 = r2
            r25 = r11
            r11 = -1
            r2 = r40
        L_0x03d0:
            int r8 = r7.f853f
            if (r19 == 0) goto L_0x03ed
            int r23 = r14.getMeasuredWidth()
            int r11 = r5.leftMargin
            int r23 = r23 + r11
            int r11 = r5.rightMargin
            int r23 = r23 + r11
            int r11 = r7.r(r14)
            int r23 = r23 + r11
            int r8 = r8 + r23
            r7.f853f = r8
            r23 = r0
            goto L_0x0405
        L_0x03ed:
            int r11 = r14.getMeasuredWidth()
            int r11 = r11 + r8
            r23 = r0
            int r0 = r5.leftMargin
            int r11 = r11 + r0
            int r0 = r5.rightMargin
            int r11 = r11 + r0
            int r0 = r7.r(r14)
            int r11 = r11 + r0
            int r0 = java.lang.Math.max(r8, r11)
            r7.f853f = r0
        L_0x0405:
            r0 = 1073741824(0x40000000, float:2.0)
            if (r13 == r0) goto L_0x0411
            int r0 = r5.height
            r8 = -1
            if (r0 != r8) goto L_0x0411
            r0 = r18
            goto L_0x0412
        L_0x0411:
            r0 = 0
        L_0x0412:
            int r8 = r5.topMargin
            int r11 = r5.bottomMargin
            int r8 = r8 + r11
            int r11 = r14.getMeasuredHeight()
            int r11 = r11 + r8
            int r4 = java.lang.Math.max(r4, r11)
            if (r0 == 0) goto L_0x0423
            goto L_0x0424
        L_0x0423:
            r8 = r11
        L_0x0424:
            int r0 = java.lang.Math.max(r6, r8)
            if (r26 == 0) goto L_0x0432
            int r6 = r5.height
            r8 = -1
            if (r6 != r8) goto L_0x0433
            r6 = r18
            goto L_0x0434
        L_0x0432:
            r8 = -1
        L_0x0433:
            r6 = 0
        L_0x0434:
            if (r36 == 0) goto L_0x045b
            int r14 = r14.getBaseline()
            if (r14 == r8) goto L_0x045b
            int r5 = r5.gravity
            if (r5 >= 0) goto L_0x0442
            int r5 = r7.f852e
        L_0x0442:
            r5 = r5 & 112(0x70, float:1.57E-43)
            r8 = 4
            int r5 = r5 >> r8
            r5 = r5 & -2
            int r5 = r5 >> 1
            r8 = r15[r5]
            int r8 = java.lang.Math.max(r8, r14)
            r15[r5] = r8
            r8 = r28[r5]
            int r11 = r11 - r14
            int r8 = java.lang.Math.max(r8, r11)
            r28[r5] = r8
        L_0x045b:
            r26 = r6
            r6 = r0
            r0 = r23
            goto L_0x0466
        L_0x0461:
            r3 = r2
            r25 = r11
            r2 = r40
        L_0x0466:
            int r10 = r10 + 1
            r8 = r39
            r2 = r3
            r11 = r25
            r5 = -1
            goto L_0x0359
        L_0x0470:
            r2 = r40
            r25 = r11
            int r0 = r7.f853f
            int r3 = r38.getPaddingLeft()
            int r5 = r38.getPaddingRight()
            int r3 = r3 + r5
            int r0 = r0 + r3
            r7.f853f = r0
            r0 = r15[r18]
            r3 = -1
            if (r0 != r3) goto L_0x0497
            r0 = 0
            r5 = r15[r0]
            if (r5 != r3) goto L_0x0497
            r0 = r15[r17]
            if (r0 != r3) goto L_0x0497
            r0 = r15[r16]
            if (r0 == r3) goto L_0x0495
            goto L_0x0497
        L_0x0495:
            r0 = r4
            goto L_0x04c5
        L_0x0497:
            r0 = r15[r16]
            r3 = 0
            r5 = r15[r3]
            r8 = r15[r18]
            r10 = r15[r17]
            int r8 = java.lang.Math.max(r8, r10)
            int r5 = java.lang.Math.max(r5, r8)
            int r0 = java.lang.Math.max(r0, r5)
            r5 = r28[r16]
            r3 = r28[r3]
            r8 = r28[r18]
            r10 = r28[r17]
            int r8 = java.lang.Math.max(r8, r10)
            int r3 = java.lang.Math.max(r3, r8)
            int r3 = java.lang.Math.max(r5, r3)
            int r0 = r0 + r3
            int r0 = java.lang.Math.max(r4, r0)
        L_0x04c5:
            r3 = r0
            r0 = r6
            r23 = r9
        L_0x04c9:
            if (r26 != 0) goto L_0x04d0
            r4 = 1073741824(0x40000000, float:2.0)
            if (r13 == r4) goto L_0x04d0
            goto L_0x04d1
        L_0x04d0:
            r0 = r3
        L_0x04d1:
            int r3 = r38.getPaddingTop()
            int r4 = r38.getPaddingBottom()
            int r3 = r3 + r4
            int r0 = r0 + r3
            int r3 = r38.getSuggestedMinimumHeight()
            int r0 = java.lang.Math.max(r0, r3)
            r3 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r3 = r23 & r3
            r1 = r1 | r3
            int r3 = r23 << 16
            int r0 = android.view.View.resolveSizeAndState(r0, r2, r3)
            r7.setMeasuredDimension(r1, r0)
            if (r27 == 0) goto L_0x04fa
            r0 = r39
            r1 = r25
            r7.k(r1, r0)
        L_0x04fa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.x(int, int):void");
    }

    /* access modifiers changed from: package-private */
    public int y(int i10) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x02cf, code lost:
        if (r15 > 0) goto L_0x02dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x02da, code lost:
        if (r15 < 0) goto L_0x02dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02dc, code lost:
        r15 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x02dd, code lost:
        r13.measure(r0, android.view.View.MeasureSpec.makeMeasureSpec(r15, r10));
        r1 = android.view.View.combineMeasuredStates(r1, r13.getMeasuredState() & -256);
        r0 = r18;
     */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x031b  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0326  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0329  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void z(int r34, int r35) {
        /*
            r33 = this;
            r7 = r33
            r8 = r34
            r9 = r35
            r10 = 0
            r7.f853f = r10
            int r11 = r33.getVirtualChildCount()
            int r12 = android.view.View.MeasureSpec.getMode(r34)
            int r13 = android.view.View.MeasureSpec.getMode(r35)
            int r14 = r7.f849b
            boolean r15 = r7.f855h
            r16 = 0
            r17 = 1
            r1 = r10
            r2 = r1
            r3 = r2
            r4 = r3
            r5 = r4
            r6 = r5
            r18 = r6
            r20 = r18
            r0 = r16
            r19 = r17
        L_0x002b:
            r10 = 8
            r22 = r4
            if (r6 >= r11) goto L_0x0199
            android.view.View r4 = r7.s(r6)
            if (r4 != 0) goto L_0x0048
            int r4 = r7.f853f
            int r10 = r7.y(r6)
            int r4 = r4 + r10
            r7.f853f = r4
            r26 = r11
            r24 = r13
            r4 = r22
            goto L_0x018d
        L_0x0048:
            r24 = r1
            int r1 = r4.getVisibility()
            if (r1 != r10) goto L_0x005f
            int r1 = r7.p(r4, r6)
            int r6 = r6 + r1
            r26 = r11
            r4 = r22
            r1 = r24
            r24 = r13
            goto L_0x018d
        L_0x005f:
            boolean r1 = r7.t(r6)
            if (r1 == 0) goto L_0x006c
            int r1 = r7.f853f
            int r10 = r7.f860m
            int r1 = r1 + r10
            r7.f853f = r1
        L_0x006c:
            android.view.ViewGroup$LayoutParams r1 = r4.getLayoutParams()
            r10 = r1
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r10 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r10
            float r1 = r10.weight
            float r25 = r0 + r1
            r0 = 1073741824(0x40000000, float:2.0)
            if (r13 != r0) goto L_0x00a6
            int r0 = r10.height
            if (r0 != 0) goto L_0x00a6
            int r0 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1))
            if (r0 <= 0) goto L_0x00a6
            int r0 = r7.f853f
            int r1 = r10.topMargin
            int r1 = r1 + r0
            r26 = r2
            int r2 = r10.bottomMargin
            int r1 = r1 + r2
            int r0 = java.lang.Math.max(r0, r1)
            r7.f853f = r0
            r0 = r3
            r3 = r4
            r31 = r5
            r18 = r17
            r8 = r24
            r29 = r26
            r26 = r11
            r24 = r13
            r13 = r22
            r11 = r6
            goto L_0x0114
        L_0x00a6:
            r26 = r2
            int r0 = r10.height
            if (r0 != 0) goto L_0x00b5
            int r0 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1))
            if (r0 <= 0) goto L_0x00b5
            r0 = -2
            r10.height = r0
            r2 = 0
            goto L_0x00b7
        L_0x00b5:
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x00b7:
            r27 = 0
            int r0 = (r25 > r16 ? 1 : (r25 == r16 ? 0 : -1))
            if (r0 != 0) goto L_0x00c2
            int r0 = r7.f853f
            r23 = r0
            goto L_0x00c4
        L_0x00c2:
            r23 = 0
        L_0x00c4:
            r28 = 1073741824(0x40000000, float:2.0)
            r0 = r33
            r8 = r24
            r1 = r4
            r30 = r2
            r29 = r26
            r2 = r6
            r9 = r3
            r3 = r34
            r26 = r11
            r24 = r13
            r13 = r22
            r11 = r28
            r22 = r4
            r4 = r27
            r31 = r5
            r5 = r35
            r11 = r6
            r6 = r23
            r0.w(r1, r2, r3, r4, r5, r6)
            r0 = r30
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 == r1) goto L_0x00f1
            r10.height = r0
        L_0x00f1:
            int r0 = r22.getMeasuredHeight()
            int r1 = r7.f853f
            int r2 = r1 + r0
            int r3 = r10.topMargin
            int r2 = r2 + r3
            int r3 = r10.bottomMargin
            int r2 = r2 + r3
            r3 = r22
            int r4 = r7.r(r3)
            int r2 = r2 + r4
            int r1 = java.lang.Math.max(r1, r2)
            r7.f853f = r1
            if (r15 == 0) goto L_0x0113
            int r0 = java.lang.Math.max(r0, r9)
            goto L_0x0114
        L_0x0113:
            r0 = r9
        L_0x0114:
            if (r14 < 0) goto L_0x011e
            int r6 = r11 + 1
            if (r14 != r6) goto L_0x011e
            int r1 = r7.f853f
            r7.f850c = r1
        L_0x011e:
            if (r11 >= r14) goto L_0x012f
            float r1 = r10.weight
            int r1 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1))
            if (r1 > 0) goto L_0x0127
            goto L_0x012f
        L_0x0127:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex."
            r0.<init>(r1)
            throw r0
        L_0x012f:
            r1 = 1073741824(0x40000000, float:2.0)
            if (r12 == r1) goto L_0x013d
            int r1 = r10.width
            r2 = -1
            if (r1 != r2) goto L_0x013d
            r1 = r17
            r20 = r1
            goto L_0x013e
        L_0x013d:
            r1 = 0
        L_0x013e:
            int r2 = r10.leftMargin
            int r4 = r10.rightMargin
            int r2 = r2 + r4
            int r4 = r3.getMeasuredWidth()
            int r4 = r4 + r2
            r5 = r29
            int r5 = java.lang.Math.max(r5, r4)
            int r6 = r3.getMeasuredState()
            int r6 = android.view.View.combineMeasuredStates(r8, r6)
            if (r19 == 0) goto L_0x0160
            int r8 = r10.width
            r9 = -1
            if (r8 != r9) goto L_0x0160
            r19 = r17
            goto L_0x0162
        L_0x0160:
            r19 = 0
        L_0x0162:
            float r8 = r10.weight
            int r8 = (r8 > r16 ? 1 : (r8 == r16 ? 0 : -1))
            if (r8 <= 0) goto L_0x0173
            if (r1 == 0) goto L_0x016b
            goto L_0x016c
        L_0x016b:
            r2 = r4
        L_0x016c:
            int r4 = java.lang.Math.max(r13, r2)
            r1 = r31
            goto L_0x017e
        L_0x0173:
            if (r1 == 0) goto L_0x0176
            goto L_0x0177
        L_0x0176:
            r2 = r4
        L_0x0177:
            r1 = r31
            int r1 = java.lang.Math.max(r1, r2)
            r4 = r13
        L_0x017e:
            int r2 = r7.p(r3, r11)
            int r2 = r2 + r11
            r3 = r0
            r0 = r25
            r32 = r5
            r5 = r1
            r1 = r6
            r6 = r2
            r2 = r32
        L_0x018d:
            int r6 = r6 + 1
            r8 = r34
            r9 = r35
            r13 = r24
            r11 = r26
            goto L_0x002b
        L_0x0199:
            r8 = r1
            r9 = r3
            r1 = r5
            r26 = r11
            r24 = r13
            r13 = r22
            r5 = r2
            int r2 = r7.f853f
            if (r2 <= 0) goto L_0x01b7
            r2 = r26
            boolean r3 = r7.t(r2)
            if (r3 == 0) goto L_0x01b9
            int r3 = r7.f853f
            int r4 = r7.f860m
            int r3 = r3 + r4
            r7.f853f = r3
            goto L_0x01b9
        L_0x01b7:
            r2 = r26
        L_0x01b9:
            r3 = r24
            if (r15 == 0) goto L_0x0207
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r3 == r4) goto L_0x01c3
            if (r3 != 0) goto L_0x0207
        L_0x01c3:
            r4 = 0
            r7.f853f = r4
            r4 = 0
        L_0x01c7:
            if (r4 >= r2) goto L_0x0207
            android.view.View r6 = r7.s(r4)
            if (r6 != 0) goto L_0x01d9
            int r6 = r7.f853f
            int r11 = r7.y(r4)
            int r6 = r6 + r11
        L_0x01d6:
            r7.f853f = r6
            goto L_0x0202
        L_0x01d9:
            int r11 = r6.getVisibility()
            if (r11 != r10) goto L_0x01e5
            int r6 = r7.p(r6, r4)
            int r4 = r4 + r6
            goto L_0x0202
        L_0x01e5:
            android.view.ViewGroup$LayoutParams r11 = r6.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r11 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r11
            int r14 = r7.f853f
            int r21 = r14 + r9
            int r10 = r11.topMargin
            int r21 = r21 + r10
            int r10 = r11.bottomMargin
            int r21 = r21 + r10
            int r6 = r7.r(r6)
            int r6 = r21 + r6
            int r6 = java.lang.Math.max(r14, r6)
            goto L_0x01d6
        L_0x0202:
            int r4 = r4 + 1
            r10 = 8
            goto L_0x01c7
        L_0x0207:
            int r4 = r7.f853f
            int r6 = r33.getPaddingTop()
            int r10 = r33.getPaddingBottom()
            int r6 = r6 + r10
            int r4 = r4 + r6
            r7.f853f = r4
            int r6 = r33.getSuggestedMinimumHeight()
            int r4 = java.lang.Math.max(r4, r6)
            r6 = r35
            r10 = r9
            r9 = 0
            int r4 = android.view.View.resolveSizeAndState(r4, r6, r9)
            r9 = 16777215(0xffffff, float:2.3509886E-38)
            r9 = r9 & r4
            int r11 = r7.f853f
            int r9 = r9 - r11
            if (r18 != 0) goto L_0x0276
            if (r9 == 0) goto L_0x0235
            int r11 = (r0 > r16 ? 1 : (r0 == r16 ? 0 : -1))
            if (r11 <= 0) goto L_0x0235
            goto L_0x0276
        L_0x0235:
            int r0 = java.lang.Math.max(r1, r13)
            if (r15 == 0) goto L_0x0271
            r1 = 1073741824(0x40000000, float:2.0)
            if (r3 == r1) goto L_0x0271
            r1 = 0
        L_0x0240:
            if (r1 >= r2) goto L_0x0271
            android.view.View r3 = r7.s(r1)
            if (r3 == 0) goto L_0x026e
            int r9 = r3.getVisibility()
            r11 = 8
            if (r9 != r11) goto L_0x0251
            goto L_0x026e
        L_0x0251:
            android.view.ViewGroup$LayoutParams r9 = r3.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r9 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r9
            float r9 = r9.weight
            int r9 = (r9 > r16 ? 1 : (r9 == r16 ? 0 : -1))
            if (r9 <= 0) goto L_0x026e
            int r9 = r3.getMeasuredWidth()
            r11 = 1073741824(0x40000000, float:2.0)
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r11)
            int r13 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r11)
            r3.measure(r9, r13)
        L_0x026e:
            int r1 = r1 + 1
            goto L_0x0240
        L_0x0271:
            r11 = r34
            r1 = r8
            goto L_0x0361
        L_0x0276:
            float r10 = r7.f854g
            int r11 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r11 <= 0) goto L_0x027d
            r0 = r10
        L_0x027d:
            r10 = 0
            r7.f853f = r10
            r11 = r9
            r9 = r1
            r1 = r8
            r8 = r10
        L_0x0284:
            if (r8 >= r2) goto L_0x0350
            android.view.View r13 = r7.s(r8)
            int r14 = r13.getVisibility()
            r15 = 8
            if (r14 != r15) goto L_0x0298
            r21 = r11
            r11 = r34
            goto L_0x0349
        L_0x0298:
            android.view.ViewGroup$LayoutParams r14 = r13.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r14 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r14
            float r10 = r14.weight
            int r18 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r18 <= 0) goto L_0x02f1
            float r15 = (float) r11
            float r15 = r15 * r10
            float r15 = r15 / r0
            int r15 = (int) r15
            float r0 = r0 - r10
            int r11 = r11 - r15
            int r10 = r33.getPaddingLeft()
            int r18 = r33.getPaddingRight()
            int r10 = r10 + r18
            r18 = r0
            int r0 = r14.leftMargin
            int r10 = r10 + r0
            int r0 = r14.rightMargin
            int r10 = r10 + r0
            int r0 = r14.width
            r21 = r11
            r11 = r34
            int r0 = android.view.ViewGroup.getChildMeasureSpec(r11, r10, r0)
            int r10 = r14.height
            if (r10 != 0) goto L_0x02d2
            r10 = 1073741824(0x40000000, float:2.0)
            if (r3 == r10) goto L_0x02cf
            goto L_0x02d4
        L_0x02cf:
            if (r15 <= 0) goto L_0x02dc
            goto L_0x02dd
        L_0x02d2:
            r10 = 1073741824(0x40000000, float:2.0)
        L_0x02d4:
            int r23 = r13.getMeasuredHeight()
            int r15 = r23 + r15
            if (r15 >= 0) goto L_0x02dd
        L_0x02dc:
            r15 = 0
        L_0x02dd:
            int r15 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r10)
            r13.measure(r0, r15)
            int r0 = r13.getMeasuredState()
            r0 = r0 & -256(0xffffffffffffff00, float:NaN)
            int r1 = android.view.View.combineMeasuredStates(r1, r0)
            r0 = r18
            goto L_0x02f6
        L_0x02f1:
            r10 = r11
            r11 = r34
            r21 = r10
        L_0x02f6:
            int r10 = r14.leftMargin
            int r15 = r14.rightMargin
            int r10 = r10 + r15
            int r15 = r13.getMeasuredWidth()
            int r15 = r15 + r10
            int r5 = java.lang.Math.max(r5, r15)
            r18 = r0
            r0 = 1073741824(0x40000000, float:2.0)
            if (r12 == r0) goto L_0x0314
            int r0 = r14.width
            r23 = r1
            r1 = -1
            if (r0 != r1) goto L_0x0317
            r0 = r17
            goto L_0x0318
        L_0x0314:
            r23 = r1
            r1 = -1
        L_0x0317:
            r0 = 0
        L_0x0318:
            if (r0 == 0) goto L_0x031b
            goto L_0x031c
        L_0x031b:
            r10 = r15
        L_0x031c:
            int r0 = java.lang.Math.max(r9, r10)
            if (r19 == 0) goto L_0x0329
            int r9 = r14.width
            if (r9 != r1) goto L_0x0329
            r9 = r17
            goto L_0x032a
        L_0x0329:
            r9 = 0
        L_0x032a:
            int r10 = r7.f853f
            int r15 = r13.getMeasuredHeight()
            int r15 = r15 + r10
            int r1 = r14.topMargin
            int r15 = r15 + r1
            int r1 = r14.bottomMargin
            int r15 = r15 + r1
            int r1 = r7.r(r13)
            int r15 = r15 + r1
            int r1 = java.lang.Math.max(r10, r15)
            r7.f853f = r1
            r19 = r9
            r1 = r23
            r9 = r0
            r0 = r18
        L_0x0349:
            int r8 = r8 + 1
            r11 = r21
            r10 = 0
            goto L_0x0284
        L_0x0350:
            r11 = r34
            int r0 = r7.f853f
            int r3 = r33.getPaddingTop()
            int r8 = r33.getPaddingBottom()
            int r3 = r3 + r8
            int r0 = r0 + r3
            r7.f853f = r0
            r0 = r9
        L_0x0361:
            if (r19 != 0) goto L_0x0368
            r3 = 1073741824(0x40000000, float:2.0)
            if (r12 == r3) goto L_0x0368
            goto L_0x0369
        L_0x0368:
            r0 = r5
        L_0x0369:
            int r3 = r33.getPaddingLeft()
            int r5 = r33.getPaddingRight()
            int r3 = r3 + r5
            int r0 = r0 + r3
            int r3 = r33.getSuggestedMinimumWidth()
            int r0 = java.lang.Math.max(r0, r3)
            int r0 = android.view.View.resolveSizeAndState(r0, r11, r1)
            r7.setMeasuredDimension(r0, r4)
            if (r20 == 0) goto L_0x0387
            r7.l(r2, r6)
        L_0x0387:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.z(int, int):void");
    }
}
