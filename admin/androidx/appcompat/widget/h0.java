package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.b0;
import androidx.core.view.d0;
import androidx.core.view.x;
import j.e;
import j.f;
import j.h;
import j.j;

public class h0 implements p {

    /* renamed from: a  reason: collision with root package name */
    Toolbar f1089a;

    /* renamed from: b  reason: collision with root package name */
    private int f1090b;

    /* renamed from: c  reason: collision with root package name */
    private View f1091c;

    /* renamed from: d  reason: collision with root package name */
    private View f1092d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f1093e;

    /* renamed from: f  reason: collision with root package name */
    private Drawable f1094f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f1095g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1096h;

    /* renamed from: i  reason: collision with root package name */
    CharSequence f1097i;

    /* renamed from: j  reason: collision with root package name */
    private CharSequence f1098j;

    /* renamed from: k  reason: collision with root package name */
    private CharSequence f1099k;

    /* renamed from: l  reason: collision with root package name */
    Window.Callback f1100l;

    /* renamed from: m  reason: collision with root package name */
    boolean f1101m;

    /* renamed from: n  reason: collision with root package name */
    private ActionMenuPresenter f1102n;

    /* renamed from: o  reason: collision with root package name */
    private int f1103o;

    /* renamed from: p  reason: collision with root package name */
    private int f1104p;

    /* renamed from: q  reason: collision with root package name */
    private Drawable f1105q;

    class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final p.a f1106a;

        a() {
            this.f1106a = new p.a(h0.this.f1089a.getContext(), 0, 16908332, 0, 0, h0.this.f1097i);
        }

        public void onClick(View view) {
            h0 h0Var = h0.this;
            Window.Callback callback = h0Var.f1100l;
            if (callback != null && h0Var.f1101m) {
                callback.onMenuItemSelected(0, this.f1106a);
            }
        }
    }

    class b extends d0 {

        /* renamed from: a  reason: collision with root package name */
        private boolean f1108a = false;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f1109b;

        b(int i10) {
            this.f1109b = i10;
        }

        public void a(View view) {
            this.f1108a = true;
        }

        public void b(View view) {
            if (!this.f1108a) {
                h0.this.f1089a.setVisibility(this.f1109b);
            }
        }

        public void c(View view) {
            h0.this.f1089a.setVisibility(0);
        }
    }

    public h0(Toolbar toolbar, boolean z10) {
        this(toolbar, z10, h.abc_action_bar_up_description, e.abc_ic_ab_back_material);
    }

    public h0(Toolbar toolbar, boolean z10, int i10, int i11) {
        Drawable drawable;
        this.f1103o = 0;
        this.f1104p = 0;
        this.f1089a = toolbar;
        this.f1097i = toolbar.getTitle();
        this.f1098j = toolbar.getSubtitle();
        this.f1096h = this.f1097i != null;
        this.f1095g = toolbar.getNavigationIcon();
        g0 v10 = g0.v(toolbar.getContext(), (AttributeSet) null, j.ActionBar, j.a.actionBarStyle, 0);
        this.f1105q = v10.g(j.ActionBar_homeAsUpIndicator);
        if (z10) {
            CharSequence p10 = v10.p(j.ActionBar_title);
            if (!TextUtils.isEmpty(p10)) {
                F(p10);
            }
            CharSequence p11 = v10.p(j.ActionBar_subtitle);
            if (!TextUtils.isEmpty(p11)) {
                E(p11);
            }
            Drawable g10 = v10.g(j.ActionBar_logo);
            if (g10 != null) {
                A(g10);
            }
            Drawable g11 = v10.g(j.ActionBar_icon);
            if (g11 != null) {
                setIcon(g11);
            }
            if (this.f1095g == null && (drawable = this.f1105q) != null) {
                D(drawable);
            }
            o(v10.k(j.ActionBar_displayOptions, 0));
            int n10 = v10.n(j.ActionBar_customNavigationLayout, 0);
            if (n10 != 0) {
                y(LayoutInflater.from(this.f1089a.getContext()).inflate(n10, this.f1089a, false));
                o(this.f1090b | 16);
            }
            int m10 = v10.m(j.ActionBar_height, 0);
            if (m10 > 0) {
                ViewGroup.LayoutParams layoutParams = this.f1089a.getLayoutParams();
                layoutParams.height = m10;
                this.f1089a.setLayoutParams(layoutParams);
            }
            int e10 = v10.e(j.ActionBar_contentInsetStart, -1);
            int e11 = v10.e(j.ActionBar_contentInsetEnd, -1);
            if (e10 >= 0 || e11 >= 0) {
                this.f1089a.H(Math.max(e10, 0), Math.max(e11, 0));
            }
            int n11 = v10.n(j.ActionBar_titleTextStyle, 0);
            if (n11 != 0) {
                Toolbar toolbar2 = this.f1089a;
                toolbar2.L(toolbar2.getContext(), n11);
            }
            int n12 = v10.n(j.ActionBar_subtitleTextStyle, 0);
            if (n12 != 0) {
                Toolbar toolbar3 = this.f1089a;
                toolbar3.K(toolbar3.getContext(), n12);
            }
            int n13 = v10.n(j.ActionBar_popupTheme, 0);
            if (n13 != 0) {
                this.f1089a.setPopupTheme(n13);
            }
        } else {
            this.f1090b = x();
        }
        v10.w();
        z(i10);
        this.f1099k = this.f1089a.getNavigationContentDescription();
        this.f1089a.setNavigationOnClickListener(new a());
    }

    private void G(CharSequence charSequence) {
        this.f1097i = charSequence;
        if ((this.f1090b & 8) != 0) {
            this.f1089a.setTitle(charSequence);
        }
    }

    private void H() {
        if ((this.f1090b & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.f1099k)) {
            this.f1089a.setNavigationContentDescription(this.f1104p);
        } else {
            this.f1089a.setNavigationContentDescription(this.f1099k);
        }
    }

    private void I() {
        Drawable drawable;
        Toolbar toolbar;
        if ((this.f1090b & 4) != 0) {
            toolbar = this.f1089a;
            drawable = this.f1095g;
            if (drawable == null) {
                drawable = this.f1105q;
            }
        } else {
            toolbar = this.f1089a;
            drawable = null;
        }
        toolbar.setNavigationIcon(drawable);
    }

    private void J() {
        Drawable drawable;
        int i10 = this.f1090b;
        if ((i10 & 2) == 0) {
            drawable = null;
        } else if ((i10 & 1) == 0 || (drawable = this.f1094f) == null) {
            drawable = this.f1093e;
        }
        this.f1089a.setLogo(drawable);
    }

    private int x() {
        if (this.f1089a.getNavigationIcon() == null) {
            return 11;
        }
        this.f1105q = this.f1089a.getNavigationIcon();
        return 15;
    }

    public void A(Drawable drawable) {
        this.f1094f = drawable;
        J();
    }

    public void B(int i10) {
        C(i10 == 0 ? null : c().getString(i10));
    }

    public void C(CharSequence charSequence) {
        this.f1099k = charSequence;
        H();
    }

    public void D(Drawable drawable) {
        this.f1095g = drawable;
        I();
    }

    public void E(CharSequence charSequence) {
        this.f1098j = charSequence;
        if ((this.f1090b & 8) != 0) {
            this.f1089a.setSubtitle(charSequence);
        }
    }

    public void F(CharSequence charSequence) {
        this.f1096h = true;
        G(charSequence);
    }

    public void a(Menu menu, j.a aVar) {
        if (this.f1102n == null) {
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(this.f1089a.getContext());
            this.f1102n = actionMenuPresenter;
            actionMenuPresenter.t(f.action_menu_presenter);
        }
        this.f1102n.n(aVar);
        this.f1089a.I((androidx.appcompat.view.menu.e) menu, this.f1102n);
    }

    public boolean b() {
        return this.f1089a.A();
    }

    public Context c() {
        return this.f1089a.getContext();
    }

    public void collapseActionView() {
        this.f1089a.e();
    }

    public void d() {
        this.f1101m = true;
    }

    public boolean e() {
        return this.f1089a.z();
    }

    public boolean f() {
        return this.f1089a.w();
    }

    public boolean g() {
        return this.f1089a.O();
    }

    public CharSequence getTitle() {
        return this.f1089a.getTitle();
    }

    public boolean h() {
        return this.f1089a.d();
    }

    public void i() {
        this.f1089a.f();
    }

    public void j(j.a aVar, e.a aVar2) {
        this.f1089a.J(aVar, aVar2);
    }

    public void k(z zVar) {
        Toolbar toolbar;
        View view = this.f1091c;
        if (view != null && view.getParent() == (toolbar = this.f1089a)) {
            toolbar.removeView(this.f1091c);
        }
        this.f1091c = zVar;
        if (zVar != null && this.f1103o == 2) {
            this.f1089a.addView(zVar, 0);
            Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.f1091c.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.f230a = 8388691;
            zVar.setAllowCollapse(true);
        }
    }

    public ViewGroup l() {
        return this.f1089a;
    }

    public void m(boolean z10) {
    }

    public boolean n() {
        return this.f1089a.v();
    }

    public void o(int i10) {
        View view;
        CharSequence charSequence;
        Toolbar toolbar;
        int i11 = this.f1090b ^ i10;
        this.f1090b = i10;
        if (i11 != 0) {
            if ((i11 & 4) != 0) {
                if ((i10 & 4) != 0) {
                    H();
                }
                I();
            }
            if ((i11 & 3) != 0) {
                J();
            }
            if ((i11 & 8) != 0) {
                if ((i10 & 8) != 0) {
                    this.f1089a.setTitle(this.f1097i);
                    toolbar = this.f1089a;
                    charSequence = this.f1098j;
                } else {
                    charSequence = null;
                    this.f1089a.setTitle((CharSequence) null);
                    toolbar = this.f1089a;
                }
                toolbar.setSubtitle(charSequence);
            }
            if ((i11 & 16) != 0 && (view = this.f1092d) != null) {
                if ((i10 & 16) != 0) {
                    this.f1089a.addView(view);
                } else {
                    this.f1089a.removeView(view);
                }
            }
        }
    }

    public int p() {
        return this.f1090b;
    }

    public Menu q() {
        return this.f1089a.getMenu();
    }

    public void r(int i10) {
        A(i10 != 0 ? k.a.d(c(), i10) : null);
    }

    public int s() {
        return this.f1103o;
    }

    public void setIcon(int i10) {
        setIcon(i10 != 0 ? k.a.d(c(), i10) : null);
    }

    public void setIcon(Drawable drawable) {
        this.f1093e = drawable;
        J();
    }

    public void setVisibility(int i10) {
        this.f1089a.setVisibility(i10);
    }

    public void setWindowCallback(Window.Callback callback) {
        this.f1100l = callback;
    }

    public void setWindowTitle(CharSequence charSequence) {
        if (!this.f1096h) {
            G(charSequence);
        }
    }

    public b0 t(int i10, long j10) {
        return x.d(this.f1089a).a(i10 == 0 ? 1.0f : 0.0f).d(j10).f(new b(i10));
    }

    public void u() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void v() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void w(boolean z10) {
        this.f1089a.setCollapsible(z10);
    }

    public void y(View view) {
        View view2 = this.f1092d;
        if (!(view2 == null || (this.f1090b & 16) == 0)) {
            this.f1089a.removeView(view2);
        }
        this.f1092d = view;
        if (view != null && (this.f1090b & 16) != 0) {
            this.f1089a.addView(view);
        }
    }

    public void z(int i10) {
        if (i10 != this.f1104p) {
            this.f1104p = i10;
            if (TextUtils.isEmpty(this.f1089a.getNavigationContentDescription())) {
                B(this.f1104p);
            }
        }
    }
}
