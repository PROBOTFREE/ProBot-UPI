package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.u;
import androidx.appcompat.widget.v;
import androidx.core.view.f;
import androidx.core.view.x;
import j.g;
import java.util.ArrayList;
import java.util.List;

final class b extends h implements View.OnKeyListener, PopupWindow.OnDismissListener {
    private static final int B = g.abc_cascading_menu_item_layout;
    boolean A;

    /* renamed from: b  reason: collision with root package name */
    private final Context f510b;

    /* renamed from: c  reason: collision with root package name */
    private final int f511c;

    /* renamed from: d  reason: collision with root package name */
    private final int f512d;

    /* renamed from: e  reason: collision with root package name */
    private final int f513e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f514f;

    /* renamed from: g  reason: collision with root package name */
    final Handler f515g;

    /* renamed from: h  reason: collision with root package name */
    private final List<e> f516h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    final List<d> f517i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f518j = new a();

    /* renamed from: k  reason: collision with root package name */
    private final View.OnAttachStateChangeListener f519k = new C0008b();

    /* renamed from: l  reason: collision with root package name */
    private final u f520l = new c();

    /* renamed from: m  reason: collision with root package name */
    private int f521m = 0;

    /* renamed from: n  reason: collision with root package name */
    private int f522n = 0;

    /* renamed from: o  reason: collision with root package name */
    private View f523o;

    /* renamed from: p  reason: collision with root package name */
    View f524p;

    /* renamed from: q  reason: collision with root package name */
    private int f525q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f526r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f527s;

    /* renamed from: t  reason: collision with root package name */
    private int f528t;

    /* renamed from: u  reason: collision with root package name */
    private int f529u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f530v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f531w;

    /* renamed from: x  reason: collision with root package name */
    private j.a f532x;

    /* renamed from: y  reason: collision with root package name */
    ViewTreeObserver f533y;

    /* renamed from: z  reason: collision with root package name */
    private PopupWindow.OnDismissListener f534z;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        public void onGlobalLayout() {
            if (b.this.d() && b.this.f517i.size() > 0 && !b.this.f517i.get(0).f542a.B()) {
                View view = b.this.f524p;
                if (view == null || !view.isShown()) {
                    b.this.dismiss();
                    return;
                }
                for (d dVar : b.this.f517i) {
                    dVar.f542a.b();
                }
            }
        }
    }

    /* renamed from: androidx.appcompat.view.menu.b$b  reason: collision with other inner class name */
    class C0008b implements View.OnAttachStateChangeListener {
        C0008b() {
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = b.this.f533y;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    b.this.f533y = view.getViewTreeObserver();
                }
                b bVar = b.this;
                bVar.f533y.removeGlobalOnLayoutListener(bVar.f518j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    class c implements u {

        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ d f538a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ MenuItem f539b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ e f540c;

            a(d dVar, MenuItem menuItem, e eVar) {
                this.f538a = dVar;
                this.f539b = menuItem;
                this.f540c = eVar;
            }

            public void run() {
                d dVar = this.f538a;
                if (dVar != null) {
                    b.this.A = true;
                    dVar.f543b.e(false);
                    b.this.A = false;
                }
                if (this.f539b.isEnabled() && this.f539b.hasSubMenu()) {
                    this.f540c.N(this.f539b, 4);
                }
            }
        }

        c() {
        }

        public void a(e eVar, MenuItem menuItem) {
            d dVar = null;
            b.this.f515g.removeCallbacksAndMessages((Object) null);
            int size = b.this.f517i.size();
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    i10 = -1;
                    break;
                } else if (eVar == b.this.f517i.get(i10).f543b) {
                    break;
                } else {
                    i10++;
                }
            }
            if (i10 != -1) {
                int i11 = i10 + 1;
                if (i11 < b.this.f517i.size()) {
                    dVar = b.this.f517i.get(i11);
                }
                b.this.f515g.postAtTime(new a(dVar, menuItem, eVar), eVar, SystemClock.uptimeMillis() + 200);
            }
        }

        public void f(e eVar, MenuItem menuItem) {
            b.this.f515g.removeCallbacksAndMessages(eVar);
        }
    }

    private static class d {

        /* renamed from: a  reason: collision with root package name */
        public final v f542a;

        /* renamed from: b  reason: collision with root package name */
        public final e f543b;

        /* renamed from: c  reason: collision with root package name */
        public final int f544c;

        public d(v vVar, e eVar, int i10) {
            this.f542a = vVar;
            this.f543b = eVar;
            this.f544c = i10;
        }

        public ListView a() {
            return this.f542a.h();
        }
    }

    public b(Context context, View view, int i10, int i11, boolean z10) {
        this.f510b = context;
        this.f523o = view;
        this.f512d = i10;
        this.f513e = i11;
        this.f514f = z10;
        this.f530v = false;
        this.f525q = G();
        Resources resources = context.getResources();
        this.f511c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(j.d.abc_config_prefDialogWidth));
        this.f515g = new Handler();
    }

    private v C() {
        v vVar = new v(this.f510b, (AttributeSet) null, this.f512d, this.f513e);
        vVar.T(this.f520l);
        vVar.L(this);
        vVar.K(this);
        vVar.D(this.f523o);
        vVar.G(this.f522n);
        vVar.J(true);
        vVar.I(2);
        return vVar;
    }

    private int D(e eVar) {
        int size = this.f517i.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (eVar == this.f517i.get(i10).f543b) {
                return i10;
            }
        }
        return -1;
    }

    private MenuItem E(e eVar, e eVar2) {
        int size = eVar.size();
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = eVar.getItem(i10);
            if (item.hasSubMenu() && eVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View F(d dVar, e eVar) {
        int i10;
        d dVar2;
        int firstVisiblePosition;
        MenuItem E = E(dVar.f543b, eVar);
        if (E == null) {
            return null;
        }
        ListView a10 = dVar.a();
        ListAdapter adapter = a10.getAdapter();
        int i11 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i10 = headerViewListAdapter.getHeadersCount();
            dVar2 = (d) headerViewListAdapter.getWrappedAdapter();
        } else {
            dVar2 = (d) adapter;
            i10 = 0;
        }
        int count = dVar2.getCount();
        while (true) {
            if (i11 >= count) {
                i11 = -1;
                break;
            } else if (E == dVar2.getItem(i11)) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 != -1 && (firstVisiblePosition = (i11 + i10) - a10.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < a10.getChildCount()) {
            return a10.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    private int G() {
        return x.C(this.f523o) == 1 ? 0 : 1;
    }

    private int H(int i10) {
        List<d> list = this.f517i;
        ListView a10 = list.get(list.size() - 1).a();
        int[] iArr = new int[2];
        a10.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f524p.getWindowVisibleDisplayFrame(rect);
        return this.f525q == 1 ? (iArr[0] + a10.getWidth()) + i10 > rect.right ? 0 : 1 : iArr[0] - i10 < 0 ? 1 : 0;
    }

    private void I(e eVar) {
        View view;
        d dVar;
        int i10;
        int i11;
        int i12;
        LayoutInflater from = LayoutInflater.from(this.f510b);
        d dVar2 = new d(eVar, from, this.f514f, B);
        if (!d() && this.f530v) {
            dVar2.d(true);
        } else if (d()) {
            dVar2.d(h.A(eVar));
        }
        int r10 = h.r(dVar2, (ViewGroup) null, this.f510b, this.f511c);
        v C = C();
        C.p(dVar2);
        C.F(r10);
        C.G(this.f522n);
        if (this.f517i.size() > 0) {
            List<d> list = this.f517i;
            dVar = list.get(list.size() - 1);
            view = F(dVar, eVar);
        } else {
            dVar = null;
            view = null;
        }
        if (view != null) {
            C.U(false);
            C.R((Object) null);
            int H = H(r10);
            boolean z10 = H == 1;
            this.f525q = H;
            if (Build.VERSION.SDK_INT >= 26) {
                C.D(view);
                i11 = 0;
                i10 = 0;
            } else {
                int[] iArr = new int[2];
                this.f523o.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.f522n & 7) == 5) {
                    iArr[0] = iArr[0] + this.f523o.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i10 = iArr2[0] - iArr[0];
                i11 = iArr2[1] - iArr[1];
            }
            if ((this.f522n & 5) != 5) {
                if (z10) {
                    r10 = view.getWidth();
                }
                i12 = i10 - r10;
                C.l(i12);
                C.M(true);
                C.j(i11);
            } else if (!z10) {
                r10 = view.getWidth();
                i12 = i10 - r10;
                C.l(i12);
                C.M(true);
                C.j(i11);
            }
            i12 = i10 + r10;
            C.l(i12);
            C.M(true);
            C.j(i11);
        } else {
            if (this.f526r) {
                C.l(this.f528t);
            }
            if (this.f527s) {
                C.j(this.f529u);
            }
            C.H(q());
        }
        this.f517i.add(new d(C, eVar, this.f525q));
        C.b();
        ListView h10 = C.h();
        h10.setOnKeyListener(this);
        if (dVar == null && this.f531w && eVar.z() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(g.abc_popup_menu_header_item_layout, h10, false);
            frameLayout.setEnabled(false);
            ((TextView) frameLayout.findViewById(16908310)).setText(eVar.z());
            h10.addHeaderView(frameLayout, (Object) null, false);
            C.b();
        }
    }

    public void b() {
        if (!d()) {
            for (e I : this.f516h) {
                I(I);
            }
            this.f516h.clear();
            View view = this.f523o;
            this.f524p = view;
            if (view != null) {
                boolean z10 = this.f533y == null;
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                this.f533y = viewTreeObserver;
                if (z10) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.f518j);
                }
                this.f524p.addOnAttachStateChangeListener(this.f519k);
            }
        }
    }

    public void c(e eVar, boolean z10) {
        int D = D(eVar);
        if (D >= 0) {
            int i10 = D + 1;
            if (i10 < this.f517i.size()) {
                this.f517i.get(i10).f543b.e(false);
            }
            d remove = this.f517i.remove(D);
            remove.f543b.Q(this);
            if (this.A) {
                remove.f542a.S((Object) null);
                remove.f542a.E(0);
            }
            remove.f542a.dismiss();
            int size = this.f517i.size();
            this.f525q = size > 0 ? this.f517i.get(size - 1).f544c : G();
            if (size == 0) {
                dismiss();
                j.a aVar = this.f532x;
                if (aVar != null) {
                    aVar.c(eVar, true);
                }
                ViewTreeObserver viewTreeObserver = this.f533y;
                if (viewTreeObserver != null) {
                    if (viewTreeObserver.isAlive()) {
                        this.f533y.removeGlobalOnLayoutListener(this.f518j);
                    }
                    this.f533y = null;
                }
                this.f524p.removeOnAttachStateChangeListener(this.f519k);
                this.f534z.onDismiss();
            } else if (z10) {
                this.f517i.get(0).f543b.e(false);
            }
        }
    }

    public boolean d() {
        return this.f517i.size() > 0 && this.f517i.get(0).f542a.d();
    }

    public void dismiss() {
        int size = this.f517i.size();
        if (size > 0) {
            d[] dVarArr = (d[]) this.f517i.toArray(new d[size]);
            for (int i10 = size - 1; i10 >= 0; i10--) {
                d dVar = dVarArr[i10];
                if (dVar.f542a.d()) {
                    dVar.f542a.dismiss();
                }
            }
        }
    }

    public void f(Parcelable parcelable) {
    }

    public boolean g(m mVar) {
        for (d next : this.f517i) {
            if (mVar == next.f543b) {
                next.a().requestFocus();
                return true;
            }
        }
        if (!mVar.hasVisibleItems()) {
            return false;
        }
        o(mVar);
        j.a aVar = this.f532x;
        if (aVar != null) {
            aVar.d(mVar);
        }
        return true;
    }

    public ListView h() {
        if (this.f517i.isEmpty()) {
            return null;
        }
        List<d> list = this.f517i;
        return list.get(list.size() - 1).a();
    }

    public void i(boolean z10) {
        for (d a10 : this.f517i) {
            h.B(a10.a().getAdapter()).notifyDataSetChanged();
        }
    }

    public boolean j() {
        return false;
    }

    public Parcelable k() {
        return null;
    }

    public void n(j.a aVar) {
        this.f532x = aVar;
    }

    public void o(e eVar) {
        eVar.c(this, this.f510b);
        if (d()) {
            I(eVar);
        } else {
            this.f516h.add(eVar);
        }
    }

    public void onDismiss() {
        d dVar;
        int size = this.f517i.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                dVar = null;
                break;
            }
            dVar = this.f517i.get(i10);
            if (!dVar.f542a.d()) {
                break;
            }
            i10++;
        }
        if (dVar != null) {
            dVar.f543b.e(false);
        }
    }

    public boolean onKey(View view, int i10, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i10 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean p() {
        return false;
    }

    public void s(View view) {
        if (this.f523o != view) {
            this.f523o = view;
            this.f522n = f.b(this.f521m, x.C(view));
        }
    }

    public void u(boolean z10) {
        this.f530v = z10;
    }

    public void v(int i10) {
        if (this.f521m != i10) {
            this.f521m = i10;
            this.f522n = f.b(i10, x.C(this.f523o));
        }
    }

    public void w(int i10) {
        this.f526r = true;
        this.f528t = i10;
    }

    public void x(PopupWindow.OnDismissListener onDismissListener) {
        this.f534z = onDismissListener;
    }

    public void y(boolean z10) {
        this.f531w = z10;
    }

    public void z(int i10) {
        this.f527s = true;
        this.f529u = i10;
    }
}
