package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.v;
import androidx.core.view.x;
import j.d;
import j.g;

final class l extends h implements PopupWindow.OnDismissListener, View.OnKeyListener {

    /* renamed from: v  reason: collision with root package name */
    private static final int f634v = g.abc_popup_menu_item_layout;

    /* renamed from: b  reason: collision with root package name */
    private final Context f635b;

    /* renamed from: c  reason: collision with root package name */
    private final e f636c;

    /* renamed from: d  reason: collision with root package name */
    private final d f637d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f638e;

    /* renamed from: f  reason: collision with root package name */
    private final int f639f;

    /* renamed from: g  reason: collision with root package name */
    private final int f640g;

    /* renamed from: h  reason: collision with root package name */
    private final int f641h;

    /* renamed from: i  reason: collision with root package name */
    final v f642i;

    /* renamed from: j  reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f643j = new a();

    /* renamed from: k  reason: collision with root package name */
    private final View.OnAttachStateChangeListener f644k = new b();

    /* renamed from: l  reason: collision with root package name */
    private PopupWindow.OnDismissListener f645l;

    /* renamed from: m  reason: collision with root package name */
    private View f646m;

    /* renamed from: n  reason: collision with root package name */
    View f647n;

    /* renamed from: o  reason: collision with root package name */
    private j.a f648o;

    /* renamed from: p  reason: collision with root package name */
    ViewTreeObserver f649p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f650q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f651r;

    /* renamed from: s  reason: collision with root package name */
    private int f652s;

    /* renamed from: t  reason: collision with root package name */
    private int f653t = 0;

    /* renamed from: u  reason: collision with root package name */
    private boolean f654u;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        public void onGlobalLayout() {
            if (l.this.d() && !l.this.f642i.B()) {
                View view = l.this.f647n;
                if (view == null || !view.isShown()) {
                    l.this.dismiss();
                } else {
                    l.this.f642i.b();
                }
            }
        }
    }

    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = l.this.f649p;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    l.this.f649p = view.getViewTreeObserver();
                }
                l lVar = l.this;
                lVar.f649p.removeGlobalOnLayoutListener(lVar.f643j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public l(Context context, e eVar, View view, int i10, int i11, boolean z10) {
        this.f635b = context;
        this.f636c = eVar;
        this.f638e = z10;
        this.f637d = new d(eVar, LayoutInflater.from(context), z10, f634v);
        this.f640g = i10;
        this.f641h = i11;
        Resources resources = context.getResources();
        this.f639f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(d.abc_config_prefDialogWidth));
        this.f646m = view;
        this.f642i = new v(context, (AttributeSet) null, i10, i11);
        eVar.c(this, context);
    }

    private boolean C() {
        View view;
        if (d()) {
            return true;
        }
        if (this.f650q || (view = this.f646m) == null) {
            return false;
        }
        this.f647n = view;
        this.f642i.K(this);
        this.f642i.L(this);
        this.f642i.J(true);
        View view2 = this.f647n;
        boolean z10 = this.f649p == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f649p = viewTreeObserver;
        if (z10) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f643j);
        }
        view2.addOnAttachStateChangeListener(this.f644k);
        this.f642i.D(view2);
        this.f642i.G(this.f653t);
        if (!this.f651r) {
            this.f652s = h.r(this.f637d, (ViewGroup) null, this.f635b, this.f639f);
            this.f651r = true;
        }
        this.f642i.F(this.f652s);
        this.f642i.I(2);
        this.f642i.H(q());
        this.f642i.b();
        ListView h10 = this.f642i.h();
        h10.setOnKeyListener(this);
        if (this.f654u && this.f636c.z() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f635b).inflate(g.abc_popup_menu_header_item_layout, h10, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.f636c.z());
            }
            frameLayout.setEnabled(false);
            h10.addHeaderView(frameLayout, (Object) null, false);
        }
        this.f642i.p(this.f637d);
        this.f642i.b();
        return true;
    }

    public void b() {
        if (!C()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    public void c(e eVar, boolean z10) {
        if (eVar == this.f636c) {
            dismiss();
            j.a aVar = this.f648o;
            if (aVar != null) {
                aVar.c(eVar, z10);
            }
        }
    }

    public boolean d() {
        return !this.f650q && this.f642i.d();
    }

    public void dismiss() {
        if (d()) {
            this.f642i.dismiss();
        }
    }

    public void f(Parcelable parcelable) {
    }

    public boolean g(m mVar) {
        if (mVar.hasVisibleItems()) {
            i iVar = new i(this.f635b, mVar, this.f647n, this.f638e, this.f640g, this.f641h);
            iVar.j(this.f648o);
            iVar.g(h.A(mVar));
            iVar.i(this.f645l);
            this.f645l = null;
            this.f636c.e(false);
            int e10 = this.f642i.e();
            int n10 = this.f642i.n();
            if ((Gravity.getAbsoluteGravity(this.f653t, x.C(this.f646m)) & 7) == 5) {
                e10 += this.f646m.getWidth();
            }
            if (iVar.n(e10, n10)) {
                j.a aVar = this.f648o;
                if (aVar == null) {
                    return true;
                }
                aVar.d(mVar);
                return true;
            }
        }
        return false;
    }

    public ListView h() {
        return this.f642i.h();
    }

    public void i(boolean z10) {
        this.f651r = false;
        d dVar = this.f637d;
        if (dVar != null) {
            dVar.notifyDataSetChanged();
        }
    }

    public boolean j() {
        return false;
    }

    public Parcelable k() {
        return null;
    }

    public void n(j.a aVar) {
        this.f648o = aVar;
    }

    public void o(e eVar) {
    }

    public void onDismiss() {
        this.f650q = true;
        this.f636c.close();
        ViewTreeObserver viewTreeObserver = this.f649p;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f649p = this.f647n.getViewTreeObserver();
            }
            this.f649p.removeGlobalOnLayoutListener(this.f643j);
            this.f649p = null;
        }
        this.f647n.removeOnAttachStateChangeListener(this.f644k);
        PopupWindow.OnDismissListener onDismissListener = this.f645l;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public boolean onKey(View view, int i10, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i10 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public void s(View view) {
        this.f646m = view;
    }

    public void u(boolean z10) {
        this.f637d.d(z10);
    }

    public void v(int i10) {
        this.f653t = i10;
    }

    public void w(int i10) {
        this.f642i.l(i10);
    }

    public void x(PopupWindow.OnDismissListener onDismissListener) {
        this.f645l = onDismissListener;
    }

    public void y(boolean z10) {
        this.f654u = z10;
    }

    public void z(int i10) {
        this.f642i.j(i10);
    }
}
