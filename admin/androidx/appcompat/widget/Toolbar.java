package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.f;
import androidx.core.view.i;
import androidx.core.view.x;
import androidx.customview.view.AbsSavedState;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
    private ColorStateList A;
    private boolean B;
    private boolean C;
    private final ArrayList<View> D;
    private final ArrayList<View> E;
    private final int[] F;
    e G;
    private final ActionMenuView.d H;
    private h0 I;
    private ActionMenuPresenter J;
    private d K;
    private j.a L;
    private e.a M;
    private boolean N;
    private final Runnable O;

    /* renamed from: a  reason: collision with root package name */
    private ActionMenuView f974a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f975b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f976c;

    /* renamed from: d  reason: collision with root package name */
    private ImageButton f977d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f978e;

    /* renamed from: f  reason: collision with root package name */
    private Drawable f979f;

    /* renamed from: g  reason: collision with root package name */
    private CharSequence f980g;

    /* renamed from: h  reason: collision with root package name */
    ImageButton f981h;

    /* renamed from: i  reason: collision with root package name */
    View f982i;

    /* renamed from: j  reason: collision with root package name */
    private Context f983j;

    /* renamed from: k  reason: collision with root package name */
    private int f984k;

    /* renamed from: l  reason: collision with root package name */
    private int f985l;

    /* renamed from: m  reason: collision with root package name */
    private int f986m;

    /* renamed from: n  reason: collision with root package name */
    int f987n;

    /* renamed from: o  reason: collision with root package name */
    private int f988o;

    /* renamed from: p  reason: collision with root package name */
    private int f989p;

    /* renamed from: q  reason: collision with root package name */
    private int f990q;

    /* renamed from: r  reason: collision with root package name */
    private int f991r;

    /* renamed from: s  reason: collision with root package name */
    private int f992s;

    /* renamed from: t  reason: collision with root package name */
    private y f993t;

    /* renamed from: u  reason: collision with root package name */
    private int f994u;

    /* renamed from: v  reason: collision with root package name */
    private int f995v;

    /* renamed from: w  reason: collision with root package name */
    private int f996w;

    /* renamed from: x  reason: collision with root package name */
    private CharSequence f997x;

    /* renamed from: y  reason: collision with root package name */
    private CharSequence f998y;

    /* renamed from: z  reason: collision with root package name */
    private ColorStateList f999z;

    public static class LayoutParams extends ActionBar.LayoutParams {

        /* renamed from: b  reason: collision with root package name */
        int f1000b = 0;

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
            this.f230a = 8388627;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super((ViewGroup.LayoutParams) marginLayoutParams);
            a(marginLayoutParams);
        }

        public LayoutParams(ActionBar.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ActionBar.LayoutParams) layoutParams);
            this.f1000b = layoutParams.f1000b;
        }

        /* access modifiers changed from: package-private */
        public void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        int f1001c;

        /* renamed from: d  reason: collision with root package name */
        boolean f1002d;

        class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1001c = parcel.readInt();
            this.f1002d = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f1001c);
            parcel.writeInt(this.f1002d ? 1 : 0);
        }
    }

    class a implements ActionMenuView.d {
        a() {
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            e eVar = Toolbar.this.G;
            if (eVar != null) {
                return eVar.onMenuItemClick(menuItem);
            }
            return false;
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            Toolbar.this.O();
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View view) {
            Toolbar.this.e();
        }
    }

    private class d implements j {

        /* renamed from: a  reason: collision with root package name */
        androidx.appcompat.view.menu.e f1006a;

        /* renamed from: b  reason: collision with root package name */
        g f1007b;

        d() {
        }

        public int a() {
            return 0;
        }

        public void c(androidx.appcompat.view.menu.e eVar, boolean z10) {
        }

        public void e(Context context, androidx.appcompat.view.menu.e eVar) {
            g gVar;
            androidx.appcompat.view.menu.e eVar2 = this.f1006a;
            if (!(eVar2 == null || (gVar = this.f1007b) == null)) {
                eVar2.f(gVar);
            }
            this.f1006a = eVar;
        }

        public void f(Parcelable parcelable) {
        }

        public boolean g(m mVar) {
            return false;
        }

        public void i(boolean z10) {
            if (this.f1007b != null) {
                androidx.appcompat.view.menu.e eVar = this.f1006a;
                boolean z11 = false;
                if (eVar != null) {
                    int size = eVar.size();
                    int i10 = 0;
                    while (true) {
                        if (i10 >= size) {
                            break;
                        } else if (this.f1006a.getItem(i10) == this.f1007b) {
                            z11 = true;
                            break;
                        } else {
                            i10++;
                        }
                    }
                }
                if (!z11) {
                    l(this.f1006a, this.f1007b);
                }
            }
        }

        public boolean j() {
            return false;
        }

        public Parcelable k() {
            return null;
        }

        public boolean l(androidx.appcompat.view.menu.e eVar, g gVar) {
            View view = Toolbar.this.f982i;
            if (view instanceof o.c) {
                ((o.c) view).e();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f982i);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.f981h);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f982i = null;
            toolbar3.a();
            this.f1007b = null;
            Toolbar.this.requestLayout();
            gVar.r(false);
            return true;
        }

        public boolean m(androidx.appcompat.view.menu.e eVar, g gVar) {
            Toolbar.this.g();
            ViewParent parent = Toolbar.this.f981h.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.f981h);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.f981h);
            }
            Toolbar.this.f982i = gVar.getActionView();
            this.f1007b = gVar;
            ViewParent parent2 = Toolbar.this.f982i.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.f982i);
                }
                LayoutParams m10 = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                m10.f230a = 8388611 | (toolbar4.f987n & 112);
                m10.f1000b = 2;
                toolbar4.f982i.setLayoutParams(m10);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.f982i);
            }
            Toolbar.this.G();
            Toolbar.this.requestLayout();
            gVar.r(true);
            View view = Toolbar.this.f982i;
            if (view instanceof o.c) {
                ((o.c) view).c();
            }
            return true;
        }
    }

    public interface e {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, j.a.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f996w = 8388627;
        this.D = new ArrayList<>();
        this.E = new ArrayList<>();
        this.F = new int[2];
        this.H = new a();
        this.O = new b();
        Context context2 = getContext();
        int[] iArr = j.j.Toolbar;
        g0 v10 = g0.v(context2, attributeSet, iArr, i10, 0);
        x.p0(this, context, iArr, attributeSet, v10.r(), i10, 0);
        this.f985l = v10.n(j.j.Toolbar_titleTextAppearance, 0);
        this.f986m = v10.n(j.j.Toolbar_subtitleTextAppearance, 0);
        this.f996w = v10.l(j.j.Toolbar_android_gravity, this.f996w);
        this.f987n = v10.l(j.j.Toolbar_buttonGravity, 48);
        int e10 = v10.e(j.j.Toolbar_titleMargin, 0);
        int i11 = j.j.Toolbar_titleMargins;
        e10 = v10.s(i11) ? v10.e(i11, e10) : e10;
        this.f992s = e10;
        this.f991r = e10;
        this.f990q = e10;
        this.f989p = e10;
        int e11 = v10.e(j.j.Toolbar_titleMarginStart, -1);
        if (e11 >= 0) {
            this.f989p = e11;
        }
        int e12 = v10.e(j.j.Toolbar_titleMarginEnd, -1);
        if (e12 >= 0) {
            this.f990q = e12;
        }
        int e13 = v10.e(j.j.Toolbar_titleMarginTop, -1);
        if (e13 >= 0) {
            this.f991r = e13;
        }
        int e14 = v10.e(j.j.Toolbar_titleMarginBottom, -1);
        if (e14 >= 0) {
            this.f992s = e14;
        }
        this.f988o = v10.f(j.j.Toolbar_maxButtonHeight, -1);
        int e15 = v10.e(j.j.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int e16 = v10.e(j.j.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int f10 = v10.f(j.j.Toolbar_contentInsetLeft, 0);
        int f11 = v10.f(j.j.Toolbar_contentInsetRight, 0);
        h();
        this.f993t.e(f10, f11);
        if (!(e15 == Integer.MIN_VALUE && e16 == Integer.MIN_VALUE)) {
            this.f993t.g(e15, e16);
        }
        this.f994u = v10.e(j.j.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.f995v = v10.e(j.j.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.f979f = v10.g(j.j.Toolbar_collapseIcon);
        this.f980g = v10.p(j.j.Toolbar_collapseContentDescription);
        CharSequence p10 = v10.p(j.j.Toolbar_title);
        if (!TextUtils.isEmpty(p10)) {
            setTitle(p10);
        }
        CharSequence p11 = v10.p(j.j.Toolbar_subtitle);
        if (!TextUtils.isEmpty(p11)) {
            setSubtitle(p11);
        }
        this.f983j = getContext();
        setPopupTheme(v10.n(j.j.Toolbar_popupTheme, 0));
        Drawable g10 = v10.g(j.j.Toolbar_navigationIcon);
        if (g10 != null) {
            setNavigationIcon(g10);
        }
        CharSequence p12 = v10.p(j.j.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(p12)) {
            setNavigationContentDescription(p12);
        }
        Drawable g11 = v10.g(j.j.Toolbar_logo);
        if (g11 != null) {
            setLogo(g11);
        }
        CharSequence p13 = v10.p(j.j.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(p13)) {
            setLogoDescription(p13);
        }
        int i12 = j.j.Toolbar_titleTextColor;
        if (v10.s(i12)) {
            setTitleTextColor(v10.c(i12));
        }
        int i13 = j.j.Toolbar_subtitleTextColor;
        if (v10.s(i13)) {
            setSubtitleTextColor(v10.c(i13));
        }
        int i14 = j.j.Toolbar_menu;
        if (v10.s(i14)) {
            x(v10.n(i14, 0));
        }
        v10.w();
    }

    private int B(View view, int i10, int[] iArr, int i11) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i12 = layoutParams.leftMargin - iArr[0];
        int max = i10 + Math.max(0, i12);
        iArr[0] = Math.max(0, -i12);
        int q10 = q(view, i11);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, q10, max + measuredWidth, view.getMeasuredHeight() + q10);
        return max + measuredWidth + layoutParams.rightMargin;
    }

    private int C(View view, int i10, int[] iArr, int i11) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i12 = layoutParams.rightMargin - iArr[1];
        int max = i10 - Math.max(0, i12);
        iArr[1] = Math.max(0, -i12);
        int q10 = q(view, i11);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, q10, max, view.getMeasuredHeight() + q10);
        return max - (measuredWidth + layoutParams.leftMargin);
    }

    private int D(View view, int i10, int i11, int i12, int i13, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i14 = marginLayoutParams.leftMargin - iArr[0];
        int i15 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i14) + Math.max(0, i15);
        iArr[0] = Math.max(0, -i14);
        iArr[1] = Math.max(0, -i15);
        view.measure(ViewGroup.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight() + max + i11, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i12, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private void E(View view, int i10, int i11, int i12, int i13, int i14) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i12, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i14 >= 0) {
            if (mode != 0) {
                i14 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i14);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i14, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void F() {
        removeCallbacks(this.O);
        post(this.O);
    }

    private boolean M() {
        if (!this.N) {
            return false;
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (N(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean N(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private void b(List<View> list, int i10) {
        boolean z10 = x.C(this) == 1;
        int childCount = getChildCount();
        int b10 = f.b(i10, x.C(this));
        list.clear();
        if (z10) {
            for (int i11 = childCount - 1; i11 >= 0; i11--) {
                View childAt = getChildAt(i11);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f1000b == 0 && N(childAt) && p(layoutParams.f230a) == b10) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt2 = getChildAt(i12);
            LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams2.f1000b == 0 && N(childAt2) && p(layoutParams2.f230a) == b10) {
                list.add(childAt2);
            }
        }
    }

    private void c(View view, boolean z10) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        LayoutParams m10 = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (LayoutParams) layoutParams;
        m10.f1000b = 1;
        if (!z10 || this.f982i == null) {
            addView(view, m10);
            return;
        }
        view.setLayoutParams(m10);
        this.E.add(view);
    }

    private MenuInflater getMenuInflater() {
        return new o.g(getContext());
    }

    private void h() {
        if (this.f993t == null) {
            this.f993t = new y();
        }
    }

    private void i() {
        if (this.f978e == null) {
            this.f978e = new AppCompatImageView(getContext());
        }
    }

    private void j() {
        k();
        if (this.f974a.N() == null) {
            androidx.appcompat.view.menu.e eVar = (androidx.appcompat.view.menu.e) this.f974a.getMenu();
            if (this.K == null) {
                this.K = new d();
            }
            this.f974a.setExpandedActionViewsExclusive(true);
            eVar.c(this.K, this.f983j);
        }
    }

    private void k() {
        if (this.f974a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f974a = actionMenuView;
            actionMenuView.setPopupTheme(this.f984k);
            this.f974a.setOnMenuItemClickListener(this.H);
            this.f974a.O(this.L, this.M);
            LayoutParams m10 = generateDefaultLayoutParams();
            m10.f230a = 8388613 | (this.f987n & 112);
            this.f974a.setLayoutParams(m10);
            c(this.f974a, false);
        }
    }

    private void l() {
        if (this.f977d == null) {
            this.f977d = new AppCompatImageButton(getContext(), (AttributeSet) null, j.a.toolbarNavigationButtonStyle);
            LayoutParams m10 = generateDefaultLayoutParams();
            m10.f230a = 8388611 | (this.f987n & 112);
            this.f977d.setLayoutParams(m10);
        }
    }

    private int p(int i10) {
        int C2 = x.C(this);
        int b10 = f.b(i10, C2) & 7;
        return (b10 == 1 || b10 == 3 || b10 == 5) ? b10 : C2 == 1 ? 5 : 3;
    }

    private int q(View view, int i10) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i11 = i10 > 0 ? (measuredHeight - i10) / 2 : 0;
        int r10 = r(layoutParams.f230a);
        if (r10 == 48) {
            return getPaddingTop() - i11;
        }
        if (r10 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - layoutParams.bottomMargin) - i11;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i12 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i13 = layoutParams.topMargin;
        if (i12 < i13) {
            i12 = i13;
        } else {
            int i14 = (((height - paddingBottom) - measuredHeight) - i12) - paddingTop;
            int i15 = layoutParams.bottomMargin;
            if (i14 < i15) {
                i12 = Math.max(0, i12 - (i15 - i14));
            }
        }
        return paddingTop + i12;
    }

    private int r(int i10) {
        int i11 = i10 & 112;
        return (i11 == 16 || i11 == 48 || i11 == 80) ? i11 : this.f996w & 112;
    }

    private int s(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return i.b(marginLayoutParams) + i.a(marginLayoutParams);
    }

    private int t(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private int u(List<View> list, int[] iArr) {
        int i10 = iArr[0];
        int i11 = iArr[1];
        int size = list.size();
        int i12 = 0;
        int i13 = 0;
        while (i12 < size) {
            View view = list.get(i12);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int i14 = layoutParams.leftMargin - i10;
            int i15 = layoutParams.rightMargin - i11;
            int max = Math.max(0, i14);
            int max2 = Math.max(0, i15);
            int max3 = Math.max(0, -i14);
            int max4 = Math.max(0, -i15);
            i13 += max + view.getMeasuredWidth() + max2;
            i12++;
            i11 = max4;
            i10 = max3;
        }
        return i13;
    }

    private boolean y(View view) {
        return view.getParent() == this || this.E.contains(view);
    }

    public boolean A() {
        ActionMenuView actionMenuView = this.f974a;
        return actionMenuView != null && actionMenuView.J();
    }

    /* access modifiers changed from: package-private */
    public void G() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((LayoutParams) childAt.getLayoutParams()).f1000b == 2 || childAt == this.f974a)) {
                removeViewAt(childCount);
                this.E.add(childAt);
            }
        }
    }

    public void H(int i10, int i11) {
        h();
        this.f993t.g(i10, i11);
    }

    public void I(androidx.appcompat.view.menu.e eVar, ActionMenuPresenter actionMenuPresenter) {
        if (eVar != null || this.f974a != null) {
            k();
            androidx.appcompat.view.menu.e N2 = this.f974a.N();
            if (N2 != eVar) {
                if (N2 != null) {
                    N2.Q(this.J);
                    N2.Q(this.K);
                }
                if (this.K == null) {
                    this.K = new d();
                }
                actionMenuPresenter.K(true);
                if (eVar != null) {
                    eVar.c(actionMenuPresenter, this.f983j);
                    eVar.c(this.K, this.f983j);
                } else {
                    actionMenuPresenter.e(this.f983j, (androidx.appcompat.view.menu.e) null);
                    this.K.e(this.f983j, (androidx.appcompat.view.menu.e) null);
                    actionMenuPresenter.i(true);
                    this.K.i(true);
                }
                this.f974a.setPopupTheme(this.f984k);
                this.f974a.setPresenter(actionMenuPresenter);
                this.J = actionMenuPresenter;
            }
        }
    }

    public void J(j.a aVar, e.a aVar2) {
        this.L = aVar;
        this.M = aVar2;
        ActionMenuView actionMenuView = this.f974a;
        if (actionMenuView != null) {
            actionMenuView.O(aVar, aVar2);
        }
    }

    public void K(Context context, int i10) {
        this.f986m = i10;
        TextView textView = this.f976c;
        if (textView != null) {
            textView.setTextAppearance(context, i10);
        }
    }

    public void L(Context context, int i10) {
        this.f985l = i10;
        TextView textView = this.f975b;
        if (textView != null) {
            textView.setTextAppearance(context, i10);
        }
    }

    public boolean O() {
        ActionMenuView actionMenuView = this.f974a;
        return actionMenuView != null && actionMenuView.P();
    }

    /* access modifiers changed from: package-private */
    public void a() {
        for (int size = this.E.size() - 1; size >= 0; size--) {
            addView(this.E.get(size));
        }
        this.E.clear();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.f974a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean d() {
        /*
            r1 = this;
            int r0 = r1.getVisibility()
            if (r0 != 0) goto L_0x0012
            androidx.appcompat.widget.ActionMenuView r0 = r1.f974a
            if (r0 == 0) goto L_0x0012
            boolean r0 = r0.K()
            if (r0 == 0) goto L_0x0012
            r0 = 1
            goto L_0x0013
        L_0x0012:
            r0 = 0
        L_0x0013:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.d():boolean");
    }

    public void e() {
        d dVar = this.K;
        g gVar = dVar == null ? null : dVar.f1007b;
        if (gVar != null) {
            gVar.collapseActionView();
        }
    }

    public void f() {
        ActionMenuView actionMenuView = this.f974a;
        if (actionMenuView != null) {
            actionMenuView.B();
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        if (this.f981h == null) {
            AppCompatImageButton appCompatImageButton = new AppCompatImageButton(getContext(), (AttributeSet) null, j.a.toolbarNavigationButtonStyle);
            this.f981h = appCompatImageButton;
            appCompatImageButton.setImageDrawable(this.f979f);
            this.f981h.setContentDescription(this.f980g);
            LayoutParams m10 = generateDefaultLayoutParams();
            m10.f230a = 8388611 | (this.f987n & 112);
            m10.f1000b = 2;
            this.f981h.setLayoutParams(m10);
            this.f981h.setOnClickListener(new c());
        }
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.f981h;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.f981h;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        y yVar = this.f993t;
        if (yVar != null) {
            return yVar.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i10 = this.f995v;
        return i10 != Integer.MIN_VALUE ? i10 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        y yVar = this.f993t;
        if (yVar != null) {
            return yVar.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        y yVar = this.f993t;
        if (yVar != null) {
            return yVar.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        y yVar = this.f993t;
        if (yVar != null) {
            return yVar.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i10 = this.f994u;
        return i10 != Integer.MIN_VALUE ? i10 : getContentInsetStart();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.N();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getCurrentContentInsetEnd() {
        /*
            r3 = this;
            androidx.appcompat.widget.ActionMenuView r0 = r3.f974a
            r1 = 0
            if (r0 == 0) goto L_0x0013
            androidx.appcompat.view.menu.e r0 = r0.N()
            if (r0 == 0) goto L_0x0013
            boolean r0 = r0.hasVisibleItems()
            if (r0 == 0) goto L_0x0013
            r0 = 1
            goto L_0x0014
        L_0x0013:
            r0 = r1
        L_0x0014:
            if (r0 == 0) goto L_0x0025
            int r0 = r3.getContentInsetEnd()
            int r2 = r3.f995v
            int r1 = java.lang.Math.max(r2, r1)
            int r0 = java.lang.Math.max(r0, r1)
            goto L_0x0029
        L_0x0025:
            int r0 = r3.getContentInsetEnd()
        L_0x0029:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.getCurrentContentInsetEnd():int");
    }

    public int getCurrentContentInsetLeft() {
        return x.C(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return x.C(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.f994u, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.f978e;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f978e;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        j();
        return this.f974a.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f977d;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f977d;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.J;
    }

    public Drawable getOverflowIcon() {
        j();
        return this.f974a.getOverflowIcon();
    }

    /* access modifiers changed from: package-private */
    public Context getPopupContext() {
        return this.f983j;
    }

    public int getPopupTheme() {
        return this.f984k;
    }

    public CharSequence getSubtitle() {
        return this.f998y;
    }

    /* access modifiers changed from: package-private */
    public final TextView getSubtitleTextView() {
        return this.f976c;
    }

    public CharSequence getTitle() {
        return this.f997x;
    }

    public int getTitleMarginBottom() {
        return this.f992s;
    }

    public int getTitleMarginEnd() {
        return this.f990q;
    }

    public int getTitleMarginStart() {
        return this.f989p;
    }

    public int getTitleMarginTop() {
        return this.f991r;
    }

    /* access modifiers changed from: package-private */
    public final TextView getTitleTextView() {
        return this.f975b;
    }

    public p getWrapper() {
        if (this.I == null) {
            this.I = new h0(this, true);
        }
        return this.I;
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    /* renamed from: n */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof ActionBar.LayoutParams ? new LayoutParams((ActionBar.LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.O);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.C = false;
        }
        if (!this.C) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.C = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.C = false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0295 A[LOOP:0: B:106:0x0293->B:107:0x0295, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x02b7 A[LOOP:1: B:109:0x02b5->B:110:0x02b7, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x02e1  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02f0 A[LOOP:2: B:117:0x02ee->B:118:0x02f0, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x021d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            r19 = this;
            r0 = r19
            int r1 = androidx.core.view.x.C(r19)
            r2 = 1
            r3 = 0
            if (r1 != r2) goto L_0x000c
            r1 = r2
            goto L_0x000d
        L_0x000c:
            r1 = r3
        L_0x000d:
            int r4 = r19.getWidth()
            int r5 = r19.getHeight()
            int r6 = r19.getPaddingLeft()
            int r7 = r19.getPaddingRight()
            int r8 = r19.getPaddingTop()
            int r9 = r19.getPaddingBottom()
            int r10 = r4 - r7
            int[] r11 = r0.F
            r11[r2] = r3
            r11[r3] = r3
            int r12 = androidx.core.view.x.D(r19)
            if (r12 < 0) goto L_0x003a
            int r13 = r24 - r22
            int r12 = java.lang.Math.min(r12, r13)
            goto L_0x003b
        L_0x003a:
            r12 = r3
        L_0x003b:
            android.widget.ImageButton r13 = r0.f977d
            boolean r13 = r0.N(r13)
            if (r13 == 0) goto L_0x0053
            android.widget.ImageButton r13 = r0.f977d
            if (r1 == 0) goto L_0x004e
            int r13 = r0.C(r13, r10, r11, r12)
            r14 = r13
            r13 = r6
            goto L_0x0055
        L_0x004e:
            int r13 = r0.B(r13, r6, r11, r12)
            goto L_0x0054
        L_0x0053:
            r13 = r6
        L_0x0054:
            r14 = r10
        L_0x0055:
            android.widget.ImageButton r15 = r0.f981h
            boolean r15 = r0.N(r15)
            if (r15 == 0) goto L_0x006a
            android.widget.ImageButton r15 = r0.f981h
            if (r1 == 0) goto L_0x0066
            int r14 = r0.C(r15, r14, r11, r12)
            goto L_0x006a
        L_0x0066:
            int r13 = r0.B(r15, r13, r11, r12)
        L_0x006a:
            androidx.appcompat.widget.ActionMenuView r15 = r0.f974a
            boolean r15 = r0.N(r15)
            if (r15 == 0) goto L_0x007f
            androidx.appcompat.widget.ActionMenuView r15 = r0.f974a
            if (r1 == 0) goto L_0x007b
            int r13 = r0.B(r15, r13, r11, r12)
            goto L_0x007f
        L_0x007b:
            int r14 = r0.C(r15, r14, r11, r12)
        L_0x007f:
            int r15 = r19.getCurrentContentInsetLeft()
            int r16 = r19.getCurrentContentInsetRight()
            int r2 = r15 - r13
            int r2 = java.lang.Math.max(r3, r2)
            r11[r3] = r2
            int r2 = r10 - r14
            int r2 = r16 - r2
            int r2 = java.lang.Math.max(r3, r2)
            r17 = 1
            r11[r17] = r2
            int r2 = java.lang.Math.max(r13, r15)
            int r10 = r10 - r16
            int r10 = java.lang.Math.min(r14, r10)
            android.view.View r13 = r0.f982i
            boolean r13 = r0.N(r13)
            if (r13 == 0) goto L_0x00ba
            android.view.View r13 = r0.f982i
            if (r1 == 0) goto L_0x00b6
            int r10 = r0.C(r13, r10, r11, r12)
            goto L_0x00ba
        L_0x00b6:
            int r2 = r0.B(r13, r2, r11, r12)
        L_0x00ba:
            android.widget.ImageView r13 = r0.f978e
            boolean r13 = r0.N(r13)
            if (r13 == 0) goto L_0x00cf
            android.widget.ImageView r13 = r0.f978e
            if (r1 == 0) goto L_0x00cb
            int r10 = r0.C(r13, r10, r11, r12)
            goto L_0x00cf
        L_0x00cb:
            int r2 = r0.B(r13, r2, r11, r12)
        L_0x00cf:
            android.widget.TextView r13 = r0.f975b
            boolean r13 = r0.N(r13)
            android.widget.TextView r14 = r0.f976c
            boolean r14 = r0.N(r14)
            if (r13 == 0) goto L_0x00f6
            android.widget.TextView r15 = r0.f975b
            android.view.ViewGroup$LayoutParams r15 = r15.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r15 = (androidx.appcompat.widget.Toolbar.LayoutParams) r15
            int r3 = r15.topMargin
            r23 = r7
            android.widget.TextView r7 = r0.f975b
            int r7 = r7.getMeasuredHeight()
            int r3 = r3 + r7
            int r7 = r15.bottomMargin
            int r3 = r3 + r7
            r7 = 0
            int r3 = r3 + r7
            goto L_0x00f9
        L_0x00f6:
            r23 = r7
            r3 = 0
        L_0x00f9:
            if (r14 == 0) goto L_0x0113
            android.widget.TextView r7 = r0.f976c
            android.view.ViewGroup$LayoutParams r7 = r7.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r7 = (androidx.appcompat.widget.Toolbar.LayoutParams) r7
            int r15 = r7.topMargin
            r16 = r4
            android.widget.TextView r4 = r0.f976c
            int r4 = r4.getMeasuredHeight()
            int r15 = r15 + r4
            int r4 = r7.bottomMargin
            int r15 = r15 + r4
            int r3 = r3 + r15
            goto L_0x0115
        L_0x0113:
            r16 = r4
        L_0x0115:
            if (r13 != 0) goto L_0x0121
            if (r14 == 0) goto L_0x011a
            goto L_0x0121
        L_0x011a:
            r18 = r6
            r22 = r12
        L_0x011e:
            r1 = 0
            goto L_0x0286
        L_0x0121:
            if (r13 == 0) goto L_0x0126
            android.widget.TextView r4 = r0.f975b
            goto L_0x0128
        L_0x0126:
            android.widget.TextView r4 = r0.f976c
        L_0x0128:
            if (r14 == 0) goto L_0x012d
            android.widget.TextView r7 = r0.f976c
            goto L_0x012f
        L_0x012d:
            android.widget.TextView r7 = r0.f975b
        L_0x012f:
            android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r4 = (androidx.appcompat.widget.Toolbar.LayoutParams) r4
            android.view.ViewGroup$LayoutParams r7 = r7.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r7 = (androidx.appcompat.widget.Toolbar.LayoutParams) r7
            if (r13 == 0) goto L_0x0145
            android.widget.TextView r15 = r0.f975b
            int r15 = r15.getMeasuredWidth()
            if (r15 > 0) goto L_0x014f
        L_0x0145:
            if (r14 == 0) goto L_0x0152
            android.widget.TextView r15 = r0.f976c
            int r15 = r15.getMeasuredWidth()
            if (r15 <= 0) goto L_0x0152
        L_0x014f:
            r17 = 1
            goto L_0x0154
        L_0x0152:
            r17 = 0
        L_0x0154:
            int r15 = r0.f996w
            r15 = r15 & 112(0x70, float:1.57E-43)
            r18 = r6
            r6 = 48
            if (r15 == r6) goto L_0x019c
            r6 = 80
            if (r15 == r6) goto L_0x018e
            int r6 = r5 - r8
            int r6 = r6 - r9
            int r6 = r6 - r3
            int r6 = r6 / 2
            int r15 = r4.topMargin
            r22 = r12
            int r12 = r0.f991r
            r24 = r2
            int r2 = r15 + r12
            if (r6 >= r2) goto L_0x0177
            int r6 = r15 + r12
            goto L_0x018c
        L_0x0177:
            int r5 = r5 - r9
            int r5 = r5 - r3
            int r5 = r5 - r6
            int r5 = r5 - r8
            int r2 = r4.bottomMargin
            int r3 = r0.f992s
            int r2 = r2 + r3
            if (r5 >= r2) goto L_0x018c
            int r2 = r7.bottomMargin
            int r2 = r2 + r3
            int r2 = r2 - r5
            int r6 = r6 - r2
            r2 = 0
            int r6 = java.lang.Math.max(r2, r6)
        L_0x018c:
            int r8 = r8 + r6
            goto L_0x01ab
        L_0x018e:
            r24 = r2
            r22 = r12
            int r5 = r5 - r9
            int r2 = r7.bottomMargin
            int r5 = r5 - r2
            int r2 = r0.f992s
            int r5 = r5 - r2
            int r8 = r5 - r3
            goto L_0x01ab
        L_0x019c:
            r24 = r2
            r22 = r12
            int r2 = r19.getPaddingTop()
            int r3 = r4.topMargin
            int r2 = r2 + r3
            int r3 = r0.f991r
            int r8 = r2 + r3
        L_0x01ab:
            if (r1 == 0) goto L_0x021d
            if (r17 == 0) goto L_0x01b2
            int r1 = r0.f989p
            goto L_0x01b3
        L_0x01b2:
            r1 = 0
        L_0x01b3:
            r2 = 1
            r3 = r11[r2]
            int r1 = r1 - r3
            r3 = 0
            int r4 = java.lang.Math.max(r3, r1)
            int r10 = r10 - r4
            int r1 = -r1
            int r1 = java.lang.Math.max(r3, r1)
            r11[r2] = r1
            if (r13 == 0) goto L_0x01ea
            android.widget.TextView r1 = r0.f975b
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r1 = (androidx.appcompat.widget.Toolbar.LayoutParams) r1
            android.widget.TextView r2 = r0.f975b
            int r2 = r2.getMeasuredWidth()
            int r2 = r10 - r2
            android.widget.TextView r3 = r0.f975b
            int r3 = r3.getMeasuredHeight()
            int r3 = r3 + r8
            android.widget.TextView r4 = r0.f975b
            r4.layout(r2, r8, r10, r3)
            int r4 = r0.f990q
            int r2 = r2 - r4
            int r1 = r1.bottomMargin
            int r8 = r3 + r1
            goto L_0x01eb
        L_0x01ea:
            r2 = r10
        L_0x01eb:
            if (r14 == 0) goto L_0x0211
            android.widget.TextView r1 = r0.f976c
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r1 = (androidx.appcompat.widget.Toolbar.LayoutParams) r1
            int r1 = r1.topMargin
            int r8 = r8 + r1
            android.widget.TextView r1 = r0.f976c
            int r1 = r1.getMeasuredWidth()
            int r1 = r10 - r1
            android.widget.TextView r3 = r0.f976c
            int r3 = r3.getMeasuredHeight()
            int r3 = r3 + r8
            android.widget.TextView r4 = r0.f976c
            r4.layout(r1, r8, r10, r3)
            int r1 = r0.f990q
            int r1 = r10 - r1
            goto L_0x0212
        L_0x0211:
            r1 = r10
        L_0x0212:
            if (r17 == 0) goto L_0x0219
            int r1 = java.lang.Math.min(r2, r1)
            r10 = r1
        L_0x0219:
            r2 = r24
            goto L_0x011e
        L_0x021d:
            if (r17 == 0) goto L_0x0223
            int r7 = r0.f989p
            r1 = 0
            goto L_0x0225
        L_0x0223:
            r1 = 0
            r7 = 0
        L_0x0225:
            r2 = r11[r1]
            int r7 = r7 - r2
            int r2 = java.lang.Math.max(r1, r7)
            int r2 = r24 + r2
            int r3 = -r7
            int r3 = java.lang.Math.max(r1, r3)
            r11[r1] = r3
            if (r13 == 0) goto L_0x025a
            android.widget.TextView r3 = r0.f975b
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r3 = (androidx.appcompat.widget.Toolbar.LayoutParams) r3
            android.widget.TextView r4 = r0.f975b
            int r4 = r4.getMeasuredWidth()
            int r4 = r4 + r2
            android.widget.TextView r5 = r0.f975b
            int r5 = r5.getMeasuredHeight()
            int r5 = r5 + r8
            android.widget.TextView r6 = r0.f975b
            r6.layout(r2, r8, r4, r5)
            int r6 = r0.f990q
            int r4 = r4 + r6
            int r3 = r3.bottomMargin
            int r8 = r5 + r3
            goto L_0x025b
        L_0x025a:
            r4 = r2
        L_0x025b:
            if (r14 == 0) goto L_0x027f
            android.widget.TextView r3 = r0.f976c
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r3 = (androidx.appcompat.widget.Toolbar.LayoutParams) r3
            int r3 = r3.topMargin
            int r8 = r8 + r3
            android.widget.TextView r3 = r0.f976c
            int r3 = r3.getMeasuredWidth()
            int r3 = r3 + r2
            android.widget.TextView r5 = r0.f976c
            int r5 = r5.getMeasuredHeight()
            int r5 = r5 + r8
            android.widget.TextView r6 = r0.f976c
            r6.layout(r2, r8, r3, r5)
            int r5 = r0.f990q
            int r3 = r3 + r5
            goto L_0x0280
        L_0x027f:
            r3 = r2
        L_0x0280:
            if (r17 == 0) goto L_0x0286
            int r2 = java.lang.Math.max(r4, r3)
        L_0x0286:
            java.util.ArrayList<android.view.View> r3 = r0.D
            r4 = 3
            r0.b(r3, r4)
            java.util.ArrayList<android.view.View> r3 = r0.D
            int r3 = r3.size()
            r7 = r1
        L_0x0293:
            if (r7 >= r3) goto L_0x02a6
            java.util.ArrayList<android.view.View> r4 = r0.D
            java.lang.Object r4 = r4.get(r7)
            android.view.View r4 = (android.view.View) r4
            r12 = r22
            int r2 = r0.B(r4, r2, r11, r12)
            int r7 = r7 + 1
            goto L_0x0293
        L_0x02a6:
            r12 = r22
            java.util.ArrayList<android.view.View> r3 = r0.D
            r4 = 5
            r0.b(r3, r4)
            java.util.ArrayList<android.view.View> r3 = r0.D
            int r3 = r3.size()
            r7 = r1
        L_0x02b5:
            if (r7 >= r3) goto L_0x02c6
            java.util.ArrayList<android.view.View> r4 = r0.D
            java.lang.Object r4 = r4.get(r7)
            android.view.View r4 = (android.view.View) r4
            int r10 = r0.C(r4, r10, r11, r12)
            int r7 = r7 + 1
            goto L_0x02b5
        L_0x02c6:
            java.util.ArrayList<android.view.View> r3 = r0.D
            r4 = 1
            r0.b(r3, r4)
            java.util.ArrayList<android.view.View> r3 = r0.D
            int r3 = r0.u(r3, r11)
            int r4 = r16 - r18
            int r4 = r4 - r23
            int r4 = r4 / 2
            int r6 = r18 + r4
            int r4 = r3 / 2
            int r6 = r6 - r4
            int r3 = r3 + r6
            if (r6 >= r2) goto L_0x02e1
            goto L_0x02e8
        L_0x02e1:
            if (r3 <= r10) goto L_0x02e7
            int r3 = r3 - r10
            int r2 = r6 - r3
            goto L_0x02e8
        L_0x02e7:
            r2 = r6
        L_0x02e8:
            java.util.ArrayList<android.view.View> r3 = r0.D
            int r3 = r3.size()
        L_0x02ee:
            if (r1 >= r3) goto L_0x02ff
            java.util.ArrayList<android.view.View> r4 = r0.D
            java.lang.Object r4 = r4.get(r1)
            android.view.View r4 = (android.view.View) r4
            int r2 = r0.B(r4, r2, r11, r12)
            int r1 = r1 + 1
            goto L_0x02ee
        L_0x02ff:
            java.util.ArrayList<android.view.View> r1 = r0.D
            r1.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int[] iArr = this.F;
        char b10 = m0.b(this);
        int i19 = 0;
        char c10 = b10 ^ 1;
        if (N(this.f977d)) {
            E(this.f977d, i10, 0, i11, 0, this.f988o);
            i14 = this.f977d.getMeasuredWidth() + s(this.f977d);
            i13 = Math.max(0, this.f977d.getMeasuredHeight() + t(this.f977d));
            i12 = View.combineMeasuredStates(0, this.f977d.getMeasuredState());
        } else {
            i14 = 0;
            i13 = 0;
            i12 = 0;
        }
        if (N(this.f981h)) {
            E(this.f981h, i10, 0, i11, 0, this.f988o);
            i14 = this.f981h.getMeasuredWidth() + s(this.f981h);
            i13 = Math.max(i13, this.f981h.getMeasuredHeight() + t(this.f981h));
            i12 = View.combineMeasuredStates(i12, this.f981h.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = 0 + Math.max(currentContentInsetStart, i14);
        iArr[b10] = Math.max(0, currentContentInsetStart - i14);
        if (N(this.f974a)) {
            E(this.f974a, i10, max, i11, 0, this.f988o);
            i15 = this.f974a.getMeasuredWidth() + s(this.f974a);
            i13 = Math.max(i13, this.f974a.getMeasuredHeight() + t(this.f974a));
            i12 = View.combineMeasuredStates(i12, this.f974a.getMeasuredState());
        } else {
            i15 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max2 = max + Math.max(currentContentInsetEnd, i15);
        iArr[c10] = Math.max(0, currentContentInsetEnd - i15);
        if (N(this.f982i)) {
            max2 += D(this.f982i, i10, max2, i11, 0, iArr);
            i13 = Math.max(i13, this.f982i.getMeasuredHeight() + t(this.f982i));
            i12 = View.combineMeasuredStates(i12, this.f982i.getMeasuredState());
        }
        if (N(this.f978e)) {
            max2 += D(this.f978e, i10, max2, i11, 0, iArr);
            i13 = Math.max(i13, this.f978e.getMeasuredHeight() + t(this.f978e));
            i12 = View.combineMeasuredStates(i12, this.f978e.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i20 = 0; i20 < childCount; i20++) {
            View childAt = getChildAt(i20);
            if (((LayoutParams) childAt.getLayoutParams()).f1000b == 0 && N(childAt)) {
                max2 += D(childAt, i10, max2, i11, 0, iArr);
                i13 = Math.max(i13, childAt.getMeasuredHeight() + t(childAt));
                i12 = View.combineMeasuredStates(i12, childAt.getMeasuredState());
            }
        }
        int i21 = this.f991r + this.f992s;
        int i22 = this.f989p + this.f990q;
        if (N(this.f975b)) {
            D(this.f975b, i10, max2 + i22, i11, i21, iArr);
            int measuredWidth = this.f975b.getMeasuredWidth() + s(this.f975b);
            i16 = this.f975b.getMeasuredHeight() + t(this.f975b);
            i18 = View.combineMeasuredStates(i12, this.f975b.getMeasuredState());
            i17 = measuredWidth;
        } else {
            i16 = 0;
            i18 = i12;
            i17 = 0;
        }
        if (N(this.f976c)) {
            i17 = Math.max(i17, D(this.f976c, i10, max2 + i22, i11, i16 + i21, iArr));
            i16 += this.f976c.getMeasuredHeight() + t(this.f976c);
            i18 = View.combineMeasuredStates(i18, this.f976c.getMeasuredState());
        } else {
            int i23 = i18;
        }
        int max3 = Math.max(i13, i16);
        int paddingLeft = max2 + i17 + getPaddingLeft() + getPaddingRight();
        int paddingTop = max3 + getPaddingTop() + getPaddingBottom();
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i10, -16777216 & i18);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i11, i18 << 16);
        if (!M()) {
            i19 = resolveSizeAndState2;
        }
        setMeasuredDimension(resolveSizeAndState, i19);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        ActionMenuView actionMenuView = this.f974a;
        androidx.appcompat.view.menu.e N2 = actionMenuView != null ? actionMenuView.N() : null;
        int i10 = savedState.f1001c;
        if (!(i10 == 0 || this.K == null || N2 == null || (findItem = N2.findItem(i10)) == null)) {
            findItem.expandActionView();
        }
        if (savedState.f1002d) {
            F();
        }
    }

    public void onRtlPropertiesChanged(int i10) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i10);
        }
        h();
        y yVar = this.f993t;
        boolean z10 = true;
        if (i10 != 1) {
            z10 = false;
        }
        yVar.f(z10);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        g gVar;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        d dVar = this.K;
        if (!(dVar == null || (gVar = dVar.f1007b) == null)) {
            savedState.f1001c = gVar.getItemId();
        }
        savedState.f1002d = A();
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.B = false;
        }
        if (!this.B) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.B = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.B = false;
        }
        return true;
    }

    public void setCollapseContentDescription(int i10) {
        setCollapseContentDescription(i10 != 0 ? getContext().getText(i10) : null);
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        ImageButton imageButton = this.f981h;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(int i10) {
        setCollapseIcon(k.a.d(getContext(), i10));
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            g();
            this.f981h.setImageDrawable(drawable);
            return;
        }
        ImageButton imageButton = this.f981h;
        if (imageButton != null) {
            imageButton.setImageDrawable(this.f979f);
        }
    }

    public void setCollapsible(boolean z10) {
        this.N = z10;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i10) {
        if (i10 < 0) {
            i10 = Integer.MIN_VALUE;
        }
        if (i10 != this.f995v) {
            this.f995v = i10;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i10) {
        if (i10 < 0) {
            i10 = Integer.MIN_VALUE;
        }
        if (i10 != this.f994u) {
            this.f994u = i10;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i10) {
        setLogo(k.a.d(getContext(), i10));
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            i();
            if (!y(this.f978e)) {
                c(this.f978e, true);
            }
        } else {
            ImageView imageView = this.f978e;
            if (imageView != null && y(imageView)) {
                removeView(this.f978e);
                this.E.remove(this.f978e);
            }
        }
        ImageView imageView2 = this.f978e;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(int i10) {
        setLogoDescription(getContext().getText(i10));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            i();
        }
        ImageView imageView = this.f978e;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(int i10) {
        setNavigationContentDescription(i10 != 0 ? getContext().getText(i10) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            l();
        }
        ImageButton imageButton = this.f977d;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i10) {
        setNavigationIcon(k.a.d(getContext(), i10));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            l();
            if (!y(this.f977d)) {
                c(this.f977d, true);
            }
        } else {
            ImageButton imageButton = this.f977d;
            if (imageButton != null && y(imageButton)) {
                removeView(this.f977d);
                this.E.remove(this.f977d);
            }
        }
        ImageButton imageButton2 = this.f977d;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        l();
        this.f977d.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.G = eVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        j();
        this.f974a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i10) {
        if (this.f984k != i10) {
            this.f984k = i10;
            if (i10 == 0) {
                this.f983j = getContext();
            } else {
                this.f983j = new ContextThemeWrapper(getContext(), i10);
            }
        }
    }

    public void setSubtitle(int i10) {
        setSubtitle(getContext().getText(i10));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f976c == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.f976c = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.f976c.setEllipsize(TextUtils.TruncateAt.END);
                int i10 = this.f986m;
                if (i10 != 0) {
                    this.f976c.setTextAppearance(context, i10);
                }
                ColorStateList colorStateList = this.A;
                if (colorStateList != null) {
                    this.f976c.setTextColor(colorStateList);
                }
            }
            if (!y(this.f976c)) {
                c(this.f976c, true);
            }
        } else {
            TextView textView = this.f976c;
            if (textView != null && y(textView)) {
                removeView(this.f976c);
                this.E.remove(this.f976c);
            }
        }
        TextView textView2 = this.f976c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f998y = charSequence;
    }

    public void setSubtitleTextColor(int i10) {
        setSubtitleTextColor(ColorStateList.valueOf(i10));
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.A = colorStateList;
        TextView textView = this.f976c;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(int i10) {
        setTitle(getContext().getText(i10));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f975b == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.f975b = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.f975b.setEllipsize(TextUtils.TruncateAt.END);
                int i10 = this.f985l;
                if (i10 != 0) {
                    this.f975b.setTextAppearance(context, i10);
                }
                ColorStateList colorStateList = this.f999z;
                if (colorStateList != null) {
                    this.f975b.setTextColor(colorStateList);
                }
            }
            if (!y(this.f975b)) {
                c(this.f975b, true);
            }
        } else {
            TextView textView = this.f975b;
            if (textView != null && y(textView)) {
                removeView(this.f975b);
                this.E.remove(this.f975b);
            }
        }
        TextView textView2 = this.f975b;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f997x = charSequence;
    }

    public void setTitleMarginBottom(int i10) {
        this.f992s = i10;
        requestLayout();
    }

    public void setTitleMarginEnd(int i10) {
        this.f990q = i10;
        requestLayout();
    }

    public void setTitleMarginStart(int i10) {
        this.f989p = i10;
        requestLayout();
    }

    public void setTitleMarginTop(int i10) {
        this.f991r = i10;
        requestLayout();
    }

    public void setTitleTextColor(int i10) {
        setTitleTextColor(ColorStateList.valueOf(i10));
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.f999z = colorStateList;
        TextView textView = this.f975b;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public boolean v() {
        d dVar = this.K;
        return (dVar == null || dVar.f1007b == null) ? false : true;
    }

    public boolean w() {
        ActionMenuView actionMenuView = this.f974a;
        return actionMenuView != null && actionMenuView.H();
    }

    public void x(int i10) {
        getMenuInflater().inflate(i10, getMenu());
    }

    public boolean z() {
        ActionMenuView actionMenuView = this.f974a;
        return actionMenuView != null && actionMenuView.I();
    }
}
