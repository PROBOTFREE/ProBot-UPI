package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.p;
import androidx.appcompat.widget.z;
import androidx.core.view.b0;
import androidx.core.view.c0;
import androidx.core.view.d0;
import androidx.core.view.e0;
import androidx.core.view.x;
import j.f;
import j.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import o.b;
import o.g;
import o.h;

public class m extends ActionBar implements ActionBarOverlayLayout.d {
    private static final Interpolator B = new AccelerateInterpolator();
    private static final Interpolator C = new DecelerateInterpolator();
    final e0 A = new c();

    /* renamed from: a  reason: collision with root package name */
    Context f435a;

    /* renamed from: b  reason: collision with root package name */
    private Context f436b;

    /* renamed from: c  reason: collision with root package name */
    ActionBarOverlayLayout f437c;

    /* renamed from: d  reason: collision with root package name */
    ActionBarContainer f438d;

    /* renamed from: e  reason: collision with root package name */
    p f439e;

    /* renamed from: f  reason: collision with root package name */
    ActionBarContextView f440f;

    /* renamed from: g  reason: collision with root package name */
    View f441g;

    /* renamed from: h  reason: collision with root package name */
    z f442h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f443i;

    /* renamed from: j  reason: collision with root package name */
    d f444j;

    /* renamed from: k  reason: collision with root package name */
    o.b f445k;

    /* renamed from: l  reason: collision with root package name */
    b.a f446l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f447m;

    /* renamed from: n  reason: collision with root package name */
    private ArrayList<ActionBar.a> f448n = new ArrayList<>();

    /* renamed from: o  reason: collision with root package name */
    private boolean f449o;

    /* renamed from: p  reason: collision with root package name */
    private int f450p = 0;

    /* renamed from: q  reason: collision with root package name */
    boolean f451q = true;

    /* renamed from: r  reason: collision with root package name */
    boolean f452r;

    /* renamed from: s  reason: collision with root package name */
    boolean f453s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f454t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f455u = true;

    /* renamed from: v  reason: collision with root package name */
    h f456v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f457w;

    /* renamed from: x  reason: collision with root package name */
    boolean f458x;

    /* renamed from: y  reason: collision with root package name */
    final c0 f459y = new a();

    /* renamed from: z  reason: collision with root package name */
    final c0 f460z = new b();

    class a extends d0 {
        a() {
        }

        public void b(View view) {
            View view2;
            m mVar = m.this;
            if (mVar.f451q && (view2 = mVar.f441g) != null) {
                view2.setTranslationY(0.0f);
                m.this.f438d.setTranslationY(0.0f);
            }
            m.this.f438d.setVisibility(8);
            m.this.f438d.setTransitioning(false);
            m mVar2 = m.this;
            mVar2.f456v = null;
            mVar2.x();
            ActionBarOverlayLayout actionBarOverlayLayout = m.this.f437c;
            if (actionBarOverlayLayout != null) {
                x.o0(actionBarOverlayLayout);
            }
        }
    }

    class b extends d0 {
        b() {
        }

        public void b(View view) {
            m mVar = m.this;
            mVar.f456v = null;
            mVar.f438d.requestLayout();
        }
    }

    class c implements e0 {
        c() {
        }

        public void a(View view) {
            ((View) m.this.f438d.getParent()).invalidate();
        }
    }

    public class d extends o.b implements e.a {

        /* renamed from: c  reason: collision with root package name */
        private final Context f464c;

        /* renamed from: d  reason: collision with root package name */
        private final e f465d;

        /* renamed from: e  reason: collision with root package name */
        private b.a f466e;

        /* renamed from: f  reason: collision with root package name */
        private WeakReference<View> f467f;

        public d(Context context, b.a aVar) {
            this.f464c = context;
            this.f466e = aVar;
            e W = new e(context).W(1);
            this.f465d = W;
            W.V(this);
        }

        public boolean a(e eVar, MenuItem menuItem) {
            b.a aVar = this.f466e;
            if (aVar != null) {
                return aVar.c(this, menuItem);
            }
            return false;
        }

        public void b(e eVar) {
            if (this.f466e != null) {
                k();
                m.this.f440f.l();
            }
        }

        public void c() {
            m mVar = m.this;
            if (mVar.f444j == this) {
                if (!m.w(mVar.f452r, mVar.f453s, false)) {
                    m mVar2 = m.this;
                    mVar2.f445k = this;
                    mVar2.f446l = this.f466e;
                } else {
                    this.f466e.b(this);
                }
                this.f466e = null;
                m.this.v(false);
                m.this.f440f.g();
                m.this.f439e.l().sendAccessibilityEvent(32);
                m mVar3 = m.this;
                mVar3.f437c.setHideOnContentScrollEnabled(mVar3.f458x);
                m.this.f444j = null;
            }
        }

        public View d() {
            WeakReference<View> weakReference = this.f467f;
            if (weakReference != null) {
                return (View) weakReference.get();
            }
            return null;
        }

        public Menu e() {
            return this.f465d;
        }

        public MenuInflater f() {
            return new g(this.f464c);
        }

        public CharSequence g() {
            return m.this.f440f.getSubtitle();
        }

        public CharSequence i() {
            return m.this.f440f.getTitle();
        }

        public void k() {
            if (m.this.f444j == this) {
                this.f465d.h0();
                try {
                    this.f466e.d(this, this.f465d);
                } finally {
                    this.f465d.g0();
                }
            }
        }

        public boolean l() {
            return m.this.f440f.j();
        }

        public void m(View view) {
            m.this.f440f.setCustomView(view);
            this.f467f = new WeakReference<>(view);
        }

        public void n(int i10) {
            o(m.this.f435a.getResources().getString(i10));
        }

        public void o(CharSequence charSequence) {
            m.this.f440f.setSubtitle(charSequence);
        }

        public void q(int i10) {
            r(m.this.f435a.getResources().getString(i10));
        }

        public void r(CharSequence charSequence) {
            m.this.f440f.setTitle(charSequence);
        }

        public void s(boolean z10) {
            super.s(z10);
            m.this.f440f.setTitleOptional(z10);
        }

        public boolean t() {
            this.f465d.h0();
            try {
                return this.f466e.a(this, this.f465d);
            } finally {
                this.f465d.g0();
            }
        }
    }

    public m(Activity activity, boolean z10) {
        new ArrayList();
        View decorView = activity.getWindow().getDecorView();
        D(decorView);
        if (!z10) {
            this.f441g = decorView.findViewById(16908290);
        }
    }

    public m(Dialog dialog) {
        new ArrayList();
        D(dialog.getWindow().getDecorView());
    }

    private p A(View view) {
        if (view instanceof p) {
            return (p) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Can't make a decor toolbar out of ");
        sb2.append(view != null ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb2.toString());
    }

    private void C() {
        if (this.f454t) {
            this.f454t = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f437c;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            M(false);
        }
    }

    private void D(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(f.decor_content_parent);
        this.f437c = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f439e = A(view.findViewById(f.action_bar));
        this.f440f = (ActionBarContextView) view.findViewById(f.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(f.action_bar_container);
        this.f438d = actionBarContainer;
        p pVar = this.f439e;
        if (pVar == null || this.f440f == null || actionBarContainer == null) {
            throw new IllegalStateException(m.class.getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f435a = pVar.c();
        boolean z10 = (this.f439e.p() & 4) != 0;
        if (z10) {
            this.f443i = true;
        }
        o.a b10 = o.a.b(this.f435a);
        J(b10.a() || z10);
        H(b10.g());
        TypedArray obtainStyledAttributes = this.f435a.obtainStyledAttributes((AttributeSet) null, j.ActionBar, j.a.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(j.ActionBar_hideOnContentScroll, false)) {
            I(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(j.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            G((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private void H(boolean z10) {
        this.f449o = z10;
        if (!z10) {
            this.f439e.k((z) null);
            this.f438d.setTabContainer(this.f442h);
        } else {
            this.f438d.setTabContainer((z) null);
            this.f439e.k(this.f442h);
        }
        boolean z11 = true;
        boolean z12 = B() == 2;
        z zVar = this.f442h;
        if (zVar != null) {
            if (z12) {
                zVar.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f437c;
                if (actionBarOverlayLayout != null) {
                    x.o0(actionBarOverlayLayout);
                }
            } else {
                zVar.setVisibility(8);
            }
        }
        this.f439e.w(!this.f449o && z12);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.f437c;
        if (this.f449o || !z12) {
            z11 = false;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z11);
    }

    private boolean K() {
        return x.V(this.f438d);
    }

    private void L() {
        if (!this.f454t) {
            this.f454t = true;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f437c;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(true);
            }
            M(false);
        }
    }

    private void M(boolean z10) {
        if (w(this.f452r, this.f453s, this.f454t)) {
            if (!this.f455u) {
                this.f455u = true;
                z(z10);
            }
        } else if (this.f455u) {
            this.f455u = false;
            y(z10);
        }
    }

    static boolean w(boolean z10, boolean z11, boolean z12) {
        if (z12) {
            return true;
        }
        return !z10 && !z11;
    }

    public int B() {
        return this.f439e.s();
    }

    public void E(boolean z10) {
        F(z10 ? 4 : 0, 4);
    }

    public void F(int i10, int i11) {
        int p10 = this.f439e.p();
        if ((i11 & 4) != 0) {
            this.f443i = true;
        }
        this.f439e.o((i10 & i11) | ((~i11) & p10));
    }

    public void G(float f10) {
        x.y0(this.f438d, f10);
    }

    public void I(boolean z10) {
        if (!z10 || this.f437c.w()) {
            this.f458x = z10;
            this.f437c.setHideOnContentScrollEnabled(z10);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    public void J(boolean z10) {
        this.f439e.m(z10);
    }

    public void a() {
        if (this.f453s) {
            this.f453s = false;
            M(true);
        }
    }

    public void b() {
        h hVar = this.f456v;
        if (hVar != null) {
            hVar.a();
            this.f456v = null;
        }
    }

    public void c(int i10) {
        this.f450p = i10;
    }

    public void d() {
    }

    public void e(boolean z10) {
        this.f451q = z10;
    }

    public void f() {
        if (!this.f453s) {
            this.f453s = true;
            M(true);
        }
    }

    public boolean h() {
        p pVar = this.f439e;
        if (pVar == null || !pVar.n()) {
            return false;
        }
        this.f439e.collapseActionView();
        return true;
    }

    public void i(boolean z10) {
        if (z10 != this.f447m) {
            this.f447m = z10;
            int size = this.f448n.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f448n.get(i10).a(z10);
            }
        }
    }

    public int j() {
        return this.f439e.p();
    }

    public Context k() {
        if (this.f436b == null) {
            TypedValue typedValue = new TypedValue();
            this.f435a.getTheme().resolveAttribute(j.a.actionBarWidgetTheme, typedValue, true);
            int i10 = typedValue.resourceId;
            if (i10 != 0) {
                this.f436b = new ContextThemeWrapper(this.f435a, i10);
            } else {
                this.f436b = this.f435a;
            }
        }
        return this.f436b;
    }

    public void m(Configuration configuration) {
        H(o.a.b(this.f435a).g());
    }

    public boolean o(int i10, KeyEvent keyEvent) {
        Menu e10;
        d dVar = this.f444j;
        if (dVar == null || (e10 = dVar.e()) == null) {
            return false;
        }
        boolean z10 = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z10 = false;
        }
        e10.setQwertyMode(z10);
        return e10.performShortcut(i10, keyEvent, 0);
    }

    public void r(boolean z10) {
        if (!this.f443i) {
            E(z10);
        }
    }

    public void s(boolean z10) {
        h hVar;
        this.f457w = z10;
        if (!z10 && (hVar = this.f456v) != null) {
            hVar.a();
        }
    }

    public void t(CharSequence charSequence) {
        this.f439e.setWindowTitle(charSequence);
    }

    public o.b u(b.a aVar) {
        d dVar = this.f444j;
        if (dVar != null) {
            dVar.c();
        }
        this.f437c.setHideOnContentScrollEnabled(false);
        this.f440f.k();
        d dVar2 = new d(this.f440f.getContext(), aVar);
        if (!dVar2.t()) {
            return null;
        }
        this.f444j = dVar2;
        dVar2.k();
        this.f440f.h(dVar2);
        v(true);
        this.f440f.sendAccessibilityEvent(32);
        return dVar2;
    }

    public void v(boolean z10) {
        b0 b0Var;
        b0 b0Var2;
        if (z10) {
            L();
        } else {
            C();
        }
        if (K()) {
            if (z10) {
                b0Var = this.f439e.t(4, 100);
                b0Var2 = this.f440f.f(0, 200);
            } else {
                b0Var2 = this.f439e.t(0, 200);
                b0Var = this.f440f.f(8, 100);
            }
            h hVar = new h();
            hVar.d(b0Var, b0Var2);
            hVar.h();
        } else if (z10) {
            this.f439e.setVisibility(4);
            this.f440f.setVisibility(0);
        } else {
            this.f439e.setVisibility(0);
            this.f440f.setVisibility(8);
        }
    }

    /* access modifiers changed from: package-private */
    public void x() {
        b.a aVar = this.f446l;
        if (aVar != null) {
            aVar.b(this.f445k);
            this.f445k = null;
            this.f446l = null;
        }
    }

    public void y(boolean z10) {
        View view;
        h hVar = this.f456v;
        if (hVar != null) {
            hVar.a();
        }
        if (this.f450p != 0 || (!this.f457w && !z10)) {
            this.f459y.b((View) null);
            return;
        }
        this.f438d.setAlpha(1.0f);
        this.f438d.setTransitioning(true);
        h hVar2 = new h();
        float f10 = (float) (-this.f438d.getHeight());
        if (z10) {
            int[] iArr = {0, 0};
            this.f438d.getLocationInWindow(iArr);
            f10 -= (float) iArr[1];
        }
        b0 k10 = x.d(this.f438d).k(f10);
        k10.i(this.A);
        hVar2.c(k10);
        if (this.f451q && (view = this.f441g) != null) {
            hVar2.c(x.d(view).k(f10));
        }
        hVar2.f(B);
        hVar2.e(250);
        hVar2.g(this.f459y);
        this.f456v = hVar2;
        hVar2.h();
    }

    public void z(boolean z10) {
        View view;
        View view2;
        h hVar = this.f456v;
        if (hVar != null) {
            hVar.a();
        }
        this.f438d.setVisibility(0);
        if (this.f450p != 0 || (!this.f457w && !z10)) {
            this.f438d.setAlpha(1.0f);
            this.f438d.setTranslationY(0.0f);
            if (this.f451q && (view = this.f441g) != null) {
                view.setTranslationY(0.0f);
            }
            this.f460z.b((View) null);
        } else {
            this.f438d.setTranslationY(0.0f);
            float f10 = (float) (-this.f438d.getHeight());
            if (z10) {
                int[] iArr = {0, 0};
                this.f438d.getLocationInWindow(iArr);
                f10 -= (float) iArr[1];
            }
            this.f438d.setTranslationY(f10);
            h hVar2 = new h();
            b0 k10 = x.d(this.f438d).k(0.0f);
            k10.i(this.A);
            hVar2.c(k10);
            if (this.f451q && (view2 = this.f441g) != null) {
                view2.setTranslationY(f10);
                hVar2.c(x.d(this.f441g).k(0.0f));
            }
            hVar2.f(C);
            hVar2.e(250);
            hVar2.g(this.f460z);
            this.f456v = hVar2;
            hVar2.h();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f437c;
        if (actionBarOverlayLayout != null) {
            x.o0(actionBarOverlayLayout);
        }
    }
}
