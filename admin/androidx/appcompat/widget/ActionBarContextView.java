package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.x;
import j.f;
import j.g;
import j.j;
import o.b;

public class ActionBarContextView extends a {

    /* renamed from: i  reason: collision with root package name */
    private CharSequence f667i;

    /* renamed from: j  reason: collision with root package name */
    private CharSequence f668j;

    /* renamed from: k  reason: collision with root package name */
    private View f669k;

    /* renamed from: l  reason: collision with root package name */
    private View f670l;

    /* renamed from: m  reason: collision with root package name */
    private View f671m;

    /* renamed from: n  reason: collision with root package name */
    private LinearLayout f672n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f673o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f674p;

    /* renamed from: q  reason: collision with root package name */
    private int f675q;

    /* renamed from: r  reason: collision with root package name */
    private int f676r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f677s;

    /* renamed from: t  reason: collision with root package name */
    private int f678t;

    class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f679a;

        a(ActionBarContextView actionBarContextView, b bVar) {
            this.f679a = bVar;
        }

        public void onClick(View view) {
            this.f679a.c();
        }
    }

    public ActionBarContextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, j.a.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        g0 v10 = g0.v(context, attributeSet, j.ActionMode, i10, 0);
        x.u0(this, v10.g(j.ActionMode_background));
        this.f675q = v10.n(j.ActionMode_titleTextStyle, 0);
        this.f676r = v10.n(j.ActionMode_subtitleTextStyle, 0);
        this.f1018e = v10.m(j.ActionMode_height, 0);
        this.f678t = v10.n(j.ActionMode_closeItemLayout, g.abc_action_mode_close_item_material);
        v10.w();
    }

    private void i() {
        if (this.f672n == null) {
            LayoutInflater.from(getContext()).inflate(g.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f672n = linearLayout;
            this.f673o = (TextView) linearLayout.findViewById(f.action_bar_title);
            this.f674p = (TextView) this.f672n.findViewById(f.action_bar_subtitle);
            if (this.f675q != 0) {
                this.f673o.setTextAppearance(getContext(), this.f675q);
            }
            if (this.f676r != 0) {
                this.f674p.setTextAppearance(getContext(), this.f676r);
            }
        }
        this.f673o.setText(this.f667i);
        this.f674p.setText(this.f668j);
        boolean z10 = !TextUtils.isEmpty(this.f667i);
        boolean z11 = !TextUtils.isEmpty(this.f668j);
        int i10 = 0;
        this.f674p.setVisibility(z11 ? 0 : 8);
        LinearLayout linearLayout2 = this.f672n;
        if (!z10 && !z11) {
            i10 = 8;
        }
        linearLayout2.setVisibility(i10);
        if (this.f672n.getParent() == null) {
            addView(this.f672n);
        }
    }

    public void g() {
        if (this.f669k == null) {
            k();
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f668j;
    }

    public CharSequence getTitle() {
        return this.f667i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void h(o.b r4) {
        /*
            r3 = this;
            android.view.View r0 = r3.f669k
            if (r0 != 0) goto L_0x0019
            android.content.Context r0 = r3.getContext()
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r1 = r3.f678t
            r2 = 0
            android.view.View r0 = r0.inflate(r1, r3, r2)
            r3.f669k = r0
        L_0x0015:
            r3.addView(r0)
            goto L_0x0022
        L_0x0019:
            android.view.ViewParent r0 = r0.getParent()
            if (r0 != 0) goto L_0x0022
            android.view.View r0 = r3.f669k
            goto L_0x0015
        L_0x0022:
            android.view.View r0 = r3.f669k
            int r1 = j.f.action_mode_close_button
            android.view.View r0 = r0.findViewById(r1)
            r3.f670l = r0
            androidx.appcompat.widget.ActionBarContextView$a r1 = new androidx.appcompat.widget.ActionBarContextView$a
            r1.<init>(r3, r4)
            r0.setOnClickListener(r1)
            android.view.Menu r4 = r4.e()
            androidx.appcompat.view.menu.e r4 = (androidx.appcompat.view.menu.e) r4
            androidx.appcompat.widget.ActionMenuPresenter r0 = r3.f1017d
            if (r0 == 0) goto L_0x0041
            r0.C()
        L_0x0041:
            androidx.appcompat.widget.ActionMenuPresenter r0 = new androidx.appcompat.widget.ActionMenuPresenter
            android.content.Context r1 = r3.getContext()
            r0.<init>(r1)
            r3.f1017d = r0
            r1 = 1
            r0.N(r1)
            android.view.ViewGroup$LayoutParams r0 = new android.view.ViewGroup$LayoutParams
            r1 = -2
            r2 = -1
            r0.<init>(r1, r2)
            androidx.appcompat.widget.ActionMenuPresenter r1 = r3.f1017d
            android.content.Context r2 = r3.f1015b
            r4.c(r1, r2)
            androidx.appcompat.widget.ActionMenuPresenter r4 = r3.f1017d
            androidx.appcompat.view.menu.k r4 = r4.s(r3)
            androidx.appcompat.widget.ActionMenuView r4 = (androidx.appcompat.widget.ActionMenuView) r4
            r3.f1016c = r4
            r1 = 0
            androidx.core.view.x.u0(r4, r1)
            androidx.appcompat.widget.ActionMenuView r4 = r3.f1016c
            r3.addView(r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContextView.h(o.b):void");
    }

    public boolean j() {
        return this.f677s;
    }

    public void k() {
        removeAllViews();
        this.f671m = null;
        this.f1016c = null;
        this.f1017d = null;
        View view = this.f670l;
        if (view != null) {
            view.setOnClickListener((View.OnClickListener) null);
        }
    }

    public boolean l() {
        ActionMenuPresenter actionMenuPresenter = this.f1017d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.O();
        }
        return false;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.f1017d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.F();
            this.f1017d.G();
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.f667i);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        boolean b10 = m0.b(this);
        int paddingRight = b10 ? (i12 - i10) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i13 - i11) - getPaddingTop()) - getPaddingBottom();
        View view = this.f669k;
        if (!(view == null || view.getVisibility() == 8)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f669k.getLayoutParams();
            int i14 = b10 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i15 = b10 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int d10 = a.d(paddingRight, i14, b10);
            paddingRight = a.d(d10 + e(this.f669k, d10, paddingTop, paddingTop2, b10), i15, b10);
        }
        int i16 = paddingRight;
        LinearLayout linearLayout = this.f672n;
        if (!(linearLayout == null || this.f671m != null || linearLayout.getVisibility() == 8)) {
            i16 += e(this.f672n, i16, paddingTop, paddingTop2, b10);
        }
        int i17 = i16;
        View view2 = this.f671m;
        if (view2 != null) {
            e(view2, i17, paddingTop, paddingTop2, b10);
        }
        int paddingLeft = b10 ? getPaddingLeft() : (i12 - i10) - getPaddingRight();
        ActionMenuView actionMenuView = this.f1016c;
        if (actionMenuView != null) {
            e(actionMenuView, paddingLeft, paddingTop, paddingTop2, !b10);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        int i12 = 1073741824;
        if (View.MeasureSpec.getMode(i10) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (View.MeasureSpec.getMode(i11) != 0) {
            int size = View.MeasureSpec.getSize(i10);
            int i13 = this.f1018e;
            if (i13 <= 0) {
                i13 = View.MeasureSpec.getSize(i11);
            }
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i14 = i13 - paddingTop;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i14, Integer.MIN_VALUE);
            View view = this.f669k;
            if (view != null) {
                int c10 = c(view, paddingLeft, makeMeasureSpec, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f669k.getLayoutParams();
                paddingLeft = c10 - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
            }
            ActionMenuView actionMenuView = this.f1016c;
            if (actionMenuView != null && actionMenuView.getParent() == this) {
                paddingLeft = c(this.f1016c, paddingLeft, makeMeasureSpec, 0);
            }
            LinearLayout linearLayout = this.f672n;
            if (linearLayout != null && this.f671m == null) {
                if (this.f677s) {
                    this.f672n.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    int measuredWidth = this.f672n.getMeasuredWidth();
                    boolean z10 = measuredWidth <= paddingLeft;
                    if (z10) {
                        paddingLeft -= measuredWidth;
                    }
                    this.f672n.setVisibility(z10 ? 0 : 8);
                } else {
                    paddingLeft = c(linearLayout, paddingLeft, makeMeasureSpec, 0);
                }
            }
            View view2 = this.f671m;
            if (view2 != null) {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                int i15 = layoutParams.width;
                int i16 = i15 != -2 ? 1073741824 : Integer.MIN_VALUE;
                if (i15 >= 0) {
                    paddingLeft = Math.min(i15, paddingLeft);
                }
                int i17 = layoutParams.height;
                if (i17 == -2) {
                    i12 = Integer.MIN_VALUE;
                }
                if (i17 >= 0) {
                    i14 = Math.min(i17, i14);
                }
                this.f671m.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i16), View.MeasureSpec.makeMeasureSpec(i14, i12));
            }
            if (this.f1018e <= 0) {
                int childCount = getChildCount();
                int i18 = 0;
                for (int i19 = 0; i19 < childCount; i19++) {
                    int measuredHeight = getChildAt(i19).getMeasuredHeight() + paddingTop;
                    if (measuredHeight > i18) {
                        i18 = measuredHeight;
                    }
                }
                setMeasuredDimension(size, i18);
                return;
            }
            setMeasuredDimension(size, i13);
        } else {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
    }

    public void setContentHeight(int i10) {
        this.f1018e = i10;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f671m;
        if (view2 != null) {
            removeView(view2);
        }
        this.f671m = view;
        if (!(view == null || (linearLayout = this.f672n) == null)) {
            removeView(linearLayout);
            this.f672n = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f668j = charSequence;
        i();
    }

    public void setTitle(CharSequence charSequence) {
        this.f667i = charSequence;
        i();
    }

    public void setTitleOptional(boolean z10) {
        if (z10 != this.f677s) {
            requestLayout();
        }
        this.f677s = z10;
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i10) {
        super.setVisibility(i10);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
