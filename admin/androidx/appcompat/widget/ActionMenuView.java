package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.LinearLayoutCompat;

public class ActionMenuView extends LinearLayoutCompat implements e.b, k {
    d A;

    /* renamed from: p  reason: collision with root package name */
    private e f735p;

    /* renamed from: q  reason: collision with root package name */
    private Context f736q;

    /* renamed from: r  reason: collision with root package name */
    private int f737r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f738s;

    /* renamed from: t  reason: collision with root package name */
    private ActionMenuPresenter f739t;

    /* renamed from: u  reason: collision with root package name */
    private j.a f740u;

    /* renamed from: v  reason: collision with root package name */
    e.a f741v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f742w;

    /* renamed from: x  reason: collision with root package name */
    private int f743x;

    /* renamed from: y  reason: collision with root package name */
    private int f744y;

    /* renamed from: z  reason: collision with root package name */
    private int f745z;

    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {
        @ViewDebug.ExportedProperty

        /* renamed from: a  reason: collision with root package name */
        public boolean f746a;
        @ViewDebug.ExportedProperty

        /* renamed from: b  reason: collision with root package name */
        public int f747b;
        @ViewDebug.ExportedProperty

        /* renamed from: c  reason: collision with root package name */
        public int f748c;
        @ViewDebug.ExportedProperty

        /* renamed from: d  reason: collision with root package name */
        public boolean f749d;
        @ViewDebug.ExportedProperty

        /* renamed from: e  reason: collision with root package name */
        public boolean f750e;

        /* renamed from: f  reason: collision with root package name */
        boolean f751f;

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
            this.f746a = false;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.f746a = layoutParams.f746a;
        }
    }

    public interface a {
        boolean e();

        boolean f();
    }

    private static class b implements j.a {
        b() {
        }

        public void c(e eVar, boolean z10) {
        }

        public boolean d(e eVar) {
            return false;
        }
    }

    private class c implements e.a {
        c() {
        }

        public boolean a(e eVar, MenuItem menuItem) {
            d dVar = ActionMenuView.this.A;
            return dVar != null && dVar.onMenuItemClick(menuItem);
        }

        public void b(e eVar) {
            e.a aVar = ActionMenuView.this.f741v;
            if (aVar != null) {
                aVar.b(eVar);
            }
        }
    }

    public interface d {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.f744y = (int) (56.0f * f10);
        this.f745z = (int) (f10 * 4.0f);
        this.f736q = context;
        this.f737r = 0;
    }

    static int L(View view, int i10, int i11, int i12, int i13) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i12) - i13, View.MeasureSpec.getMode(i12));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z10 = true;
        boolean z11 = actionMenuItemView != null && actionMenuItemView.b();
        int i14 = 2;
        if (i11 <= 0 || (z11 && i11 < 2)) {
            i14 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i11 * i10, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i15 = measuredWidth / i10;
            if (measuredWidth % i10 != 0) {
                i15++;
            }
            if (!z11 || i15 >= 2) {
                i14 = i15;
            }
        }
        if (layoutParams.f746a || !z11) {
            z10 = false;
        }
        layoutParams.f749d = z10;
        layoutParams.f747b = i14;
        view.measure(View.MeasureSpec.makeMeasureSpec(i10 * i14, 1073741824), makeMeasureSpec);
        return i14;
    }

    private void M(int i10, int i11) {
        int i12;
        boolean z10;
        int i13;
        int i14;
        int i15;
        boolean z11;
        boolean z12;
        int i16;
        boolean z13;
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i11, paddingTop, -2);
        int i17 = size - paddingLeft;
        int i18 = this.f744y;
        int i19 = i17 / i18;
        int i20 = i17 % i18;
        if (i19 == 0) {
            setMeasuredDimension(i17, 0);
            return;
        }
        int i21 = i18 + (i20 / i19);
        int childCount = getChildCount();
        int i22 = 0;
        int i23 = 0;
        boolean z14 = false;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        long j10 = 0;
        while (i23 < childCount) {
            View childAt = getChildAt(i23);
            int i27 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z15 = childAt instanceof ActionMenuItemView;
                int i28 = i24 + 1;
                if (z15) {
                    int i29 = this.f745z;
                    i16 = i28;
                    z13 = false;
                    childAt.setPadding(i29, 0, i29, 0);
                } else {
                    i16 = i28;
                    z13 = false;
                }
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.f751f = z13;
                layoutParams.f748c = z13 ? 1 : 0;
                layoutParams.f747b = z13;
                layoutParams.f749d = z13;
                layoutParams.leftMargin = z13;
                layoutParams.rightMargin = z13;
                layoutParams.f750e = z15 && ((ActionMenuItemView) childAt).b();
                int L = L(childAt, i21, layoutParams.f746a ? 1 : i19, childMeasureSpec, paddingTop);
                i25 = Math.max(i25, L);
                if (layoutParams.f749d) {
                    i26++;
                }
                if (layoutParams.f746a) {
                    z14 = true;
                }
                i19 -= L;
                i22 = Math.max(i22, childAt.getMeasuredHeight());
                if (L == 1) {
                    j10 |= (long) (1 << i23);
                    i22 = i22;
                } else {
                    int i30 = i22;
                }
                i24 = i16;
            }
            i23++;
            size2 = i27;
        }
        int i31 = size2;
        boolean z16 = z14 && i24 == 2;
        boolean z17 = false;
        while (true) {
            if (i26 <= 0 || i19 <= 0) {
                i14 = mode;
                i12 = i17;
                z10 = z17;
                i13 = i22;
            } else {
                int i32 = Integer.MAX_VALUE;
                int i33 = 0;
                int i34 = 0;
                long j11 = 0;
                while (i34 < childCount) {
                    boolean z18 = z17;
                    LayoutParams layoutParams2 = (LayoutParams) getChildAt(i34).getLayoutParams();
                    int i35 = i22;
                    if (layoutParams2.f749d) {
                        int i36 = layoutParams2.f747b;
                        if (i36 < i32) {
                            j11 = 1 << i34;
                            i32 = i36;
                            i33 = 1;
                        } else if (i36 == i32) {
                            i33++;
                            j11 |= 1 << i34;
                        }
                    }
                    i34++;
                    i22 = i35;
                    z17 = z18;
                }
                z10 = z17;
                i13 = i22;
                j10 |= j11;
                if (i33 > i19) {
                    i14 = mode;
                    i12 = i17;
                    break;
                }
                int i37 = i32 + 1;
                int i38 = 0;
                while (i38 < childCount) {
                    View childAt2 = getChildAt(i38);
                    LayoutParams layoutParams3 = (LayoutParams) childAt2.getLayoutParams();
                    int i39 = i17;
                    int i40 = mode;
                    long j12 = (long) (1 << i38);
                    if ((j11 & j12) == 0) {
                        if (layoutParams3.f747b == i37) {
                            j10 |= j12;
                        }
                        z12 = z16;
                    } else {
                        if (!z16 || !layoutParams3.f750e || i19 != 1) {
                            z12 = z16;
                        } else {
                            int i41 = this.f745z;
                            z12 = z16;
                            childAt2.setPadding(i41 + i21, 0, i41, 0);
                        }
                        layoutParams3.f747b++;
                        layoutParams3.f751f = true;
                        i19--;
                    }
                    i38++;
                    mode = i40;
                    i17 = i39;
                    z16 = z12;
                }
                i22 = i13;
                z17 = true;
            }
        }
        boolean z19 = !z14 && i24 == 1;
        if (i19 <= 0 || j10 == 0 || (i19 >= i24 - 1 && !z19 && i25 <= 1)) {
            i15 = 0;
            z11 = z10;
        } else {
            float bitCount = (float) Long.bitCount(j10);
            if (!z19) {
                i15 = 0;
                if ((j10 & 1) != 0 && !((LayoutParams) getChildAt(0).getLayoutParams()).f750e) {
                    bitCount -= 0.5f;
                }
                int i42 = childCount - 1;
                if ((j10 & ((long) (1 << i42))) != 0 && !((LayoutParams) getChildAt(i42).getLayoutParams()).f750e) {
                    bitCount -= 0.5f;
                }
            } else {
                i15 = 0;
            }
            int i43 = bitCount > 0.0f ? (int) (((float) (i19 * i21)) / bitCount) : i15;
            z11 = z10;
            for (int i44 = i15; i44 < childCount; i44++) {
                if ((j10 & ((long) (1 << i44))) != 0) {
                    View childAt3 = getChildAt(i44);
                    LayoutParams layoutParams4 = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        layoutParams4.f748c = i43;
                        layoutParams4.f751f = true;
                        if (i44 == 0 && !layoutParams4.f750e) {
                            layoutParams4.leftMargin = (-i43) / 2;
                        }
                        z11 = true;
                    } else if (layoutParams4.f746a) {
                        layoutParams4.f748c = i43;
                        layoutParams4.f751f = true;
                        layoutParams4.rightMargin = (-i43) / 2;
                        z11 = true;
                    } else {
                        if (i44 != 0) {
                            layoutParams4.leftMargin = i43 / 2;
                        }
                        if (i44 != childCount - 1) {
                            layoutParams4.rightMargin = i43 / 2;
                        }
                    }
                }
            }
        }
        if (z11) {
            for (int i45 = i15; i45 < childCount; i45++) {
                View childAt4 = getChildAt(i45);
                LayoutParams layoutParams5 = (LayoutParams) childAt4.getLayoutParams();
                if (layoutParams5.f751f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((layoutParams5.f747b * i21) + layoutParams5.f748c, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i12, i14 != 1073741824 ? i13 : i31);
    }

    public void B() {
        ActionMenuPresenter actionMenuPresenter = this.f739t;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.C();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: C */
    public LayoutParams m() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        return layoutParams;
    }

    /* renamed from: D */
    public LayoutParams n(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: E */
    public LayoutParams o(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return m();
        }
        LayoutParams layoutParams2 = layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : new LayoutParams(layoutParams);
        if (layoutParams2.gravity <= 0) {
            layoutParams2.gravity = 16;
        }
        return layoutParams2;
    }

    public LayoutParams F() {
        LayoutParams C = m();
        C.f746a = true;
        return C;
    }

    /* access modifiers changed from: protected */
    public boolean G(int i10) {
        boolean z10 = false;
        if (i10 == 0) {
            return false;
        }
        View childAt = getChildAt(i10 - 1);
        View childAt2 = getChildAt(i10);
        if (i10 < getChildCount() && (childAt instanceof a)) {
            z10 = false | ((a) childAt).e();
        }
        return (i10 <= 0 || !(childAt2 instanceof a)) ? z10 : z10 | ((a) childAt2).f();
    }

    public boolean H() {
        ActionMenuPresenter actionMenuPresenter = this.f739t;
        return actionMenuPresenter != null && actionMenuPresenter.F();
    }

    public boolean I() {
        ActionMenuPresenter actionMenuPresenter = this.f739t;
        return actionMenuPresenter != null && actionMenuPresenter.H();
    }

    public boolean J() {
        ActionMenuPresenter actionMenuPresenter = this.f739t;
        return actionMenuPresenter != null && actionMenuPresenter.I();
    }

    public boolean K() {
        return this.f738s;
    }

    public e N() {
        return this.f735p;
    }

    public void O(j.a aVar, e.a aVar2) {
        this.f740u = aVar;
        this.f741v = aVar2;
    }

    public boolean P() {
        ActionMenuPresenter actionMenuPresenter = this.f739t;
        return actionMenuPresenter != null && actionMenuPresenter.O();
    }

    public boolean a(g gVar) {
        return this.f735p.N(gVar, 0);
    }

    public void b(e eVar) {
        this.f735p = eVar;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public Menu getMenu() {
        if (this.f735p == null) {
            Context context = getContext();
            e eVar = new e(context);
            this.f735p = eVar;
            eVar.V(new c());
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(context);
            this.f739t = actionMenuPresenter;
            actionMenuPresenter.N(true);
            ActionMenuPresenter actionMenuPresenter2 = this.f739t;
            j.a aVar = this.f740u;
            if (aVar == null) {
                aVar = new b();
            }
            actionMenuPresenter2.n(aVar);
            this.f735p.c(this.f739t, this.f736q);
            this.f739t.L(this);
        }
        return this.f735p;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f739t.E();
    }

    public int getPopupTheme() {
        return this.f737r;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.f739t;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.i(false);
            if (this.f739t.I()) {
                this.f739t.F();
                this.f739t.O();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        B();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        if (!this.f742w) {
            super.onLayout(z10, i10, i11, i12, i13);
            return;
        }
        int childCount = getChildCount();
        int i16 = (i13 - i11) / 2;
        int dividerWidth = getDividerWidth();
        int i17 = i12 - i10;
        int paddingRight = (i17 - getPaddingRight()) - getPaddingLeft();
        boolean b10 = m0.b(this);
        int i18 = 0;
        int i19 = 0;
        for (int i20 = 0; i20 < childCount; i20++) {
            View childAt = getChildAt(i20);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f746a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (G(i20)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (b10) {
                        i14 = getPaddingLeft() + layoutParams.leftMargin;
                        i15 = i14 + measuredWidth;
                    } else {
                        i15 = (getWidth() - getPaddingRight()) - layoutParams.rightMargin;
                        i14 = i15 - measuredWidth;
                    }
                    int i21 = i16 - (measuredHeight / 2);
                    childAt.layout(i14, i21, i15, measuredHeight + i21);
                    paddingRight -= measuredWidth;
                    i18 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin;
                    G(i20);
                    i19++;
                }
            }
        }
        if (childCount == 1 && i18 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i22 = (i17 / 2) - (measuredWidth2 / 2);
            int i23 = i16 - (measuredHeight2 / 2);
            childAt2.layout(i22, i23, measuredWidth2 + i22, measuredHeight2 + i23);
            return;
        }
        int i24 = i19 - (i18 ^ 1);
        int max = Math.max(0, i24 > 0 ? paddingRight / i24 : 0);
        if (b10) {
            int width = getWidth() - getPaddingRight();
            for (int i25 = 0; i25 < childCount; i25++) {
                View childAt3 = getChildAt(i25);
                LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !layoutParams2.f746a) {
                    int i26 = width - layoutParams2.rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i27 = i16 - (measuredHeight3 / 2);
                    childAt3.layout(i26 - measuredWidth3, i27, i26, measuredHeight3 + i27);
                    width = i26 - ((measuredWidth3 + layoutParams2.leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i28 = 0; i28 < childCount; i28++) {
            View childAt4 = getChildAt(i28);
            LayoutParams layoutParams3 = (LayoutParams) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !layoutParams3.f746a) {
                int i29 = paddingLeft + layoutParams3.leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i30 = i16 - (measuredHeight4 / 2);
                childAt4.layout(i29, i30, i29 + measuredWidth4, measuredHeight4 + i30);
                paddingLeft = i29 + measuredWidth4 + layoutParams3.rightMargin + max;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        e eVar;
        boolean z10 = this.f742w;
        boolean z11 = View.MeasureSpec.getMode(i10) == 1073741824;
        this.f742w = z11;
        if (z10 != z11) {
            this.f743x = 0;
        }
        int size = View.MeasureSpec.getSize(i10);
        if (!(!this.f742w || (eVar = this.f735p) == null || size == this.f743x)) {
            this.f743x = size;
            eVar.M(true);
        }
        int childCount = getChildCount();
        if (!this.f742w || childCount <= 0) {
            for (int i12 = 0; i12 < childCount; i12++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i12).getLayoutParams();
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
            }
            super.onMeasure(i10, i11);
            return;
        }
        M(i10, i11);
    }

    public void setExpandedActionViewsExclusive(boolean z10) {
        this.f739t.K(z10);
    }

    public void setOnMenuItemClickListener(d dVar) {
        this.A = dVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f739t.M(drawable);
    }

    public void setOverflowReserved(boolean z10) {
        this.f738s = z10;
    }

    public void setPopupTheme(int i10) {
        if (this.f737r != i10) {
            this.f737r = i10;
            if (i10 == 0) {
                this.f736q = getContext();
            } else {
                this.f736q = new ContextThemeWrapper(getContext(), i10);
            }
        }
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.f739t = actionMenuPresenter;
        actionMenuPresenter.L(this);
    }
}
