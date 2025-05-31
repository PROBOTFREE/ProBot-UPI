package a1;

import a1.b;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.x;
import androidx.recyclerview.widget.RecyclerView;
import c0.h;
import java.util.ArrayList;
import java.util.List;
import net.sourceforge.zbar.Config;
import x0.d;
import x0.e;

public abstract class a extends androidx.core.view.a {

    /* renamed from: n  reason: collision with root package name */
    private static final Rect f15n = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* renamed from: o  reason: collision with root package name */
    private static final b.a<x0.c> f16o = new C0000a();

    /* renamed from: p  reason: collision with root package name */
    private static final b.C0001b<h<x0.c>, x0.c> f17p = new b();

    /* renamed from: d  reason: collision with root package name */
    private final Rect f18d = new Rect();

    /* renamed from: e  reason: collision with root package name */
    private final Rect f19e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    private final Rect f20f = new Rect();

    /* renamed from: g  reason: collision with root package name */
    private final int[] f21g = new int[2];

    /* renamed from: h  reason: collision with root package name */
    private final AccessibilityManager f22h;

    /* renamed from: i  reason: collision with root package name */
    private final View f23i;

    /* renamed from: j  reason: collision with root package name */
    private c f24j;

    /* renamed from: k  reason: collision with root package name */
    int f25k = Integer.MIN_VALUE;

    /* renamed from: l  reason: collision with root package name */
    int f26l = Integer.MIN_VALUE;

    /* renamed from: m  reason: collision with root package name */
    private int f27m = Integer.MIN_VALUE;

    /* renamed from: a1.a$a  reason: collision with other inner class name */
    class C0000a implements b.a<x0.c> {
        C0000a() {
        }

        /* renamed from: b */
        public void a(x0.c cVar, Rect rect) {
            cVar.m(rect);
        }
    }

    class b implements b.C0001b<h<x0.c>, x0.c> {
        b() {
        }

        /* renamed from: c */
        public x0.c a(h<x0.c> hVar, int i10) {
            return hVar.q(i10);
        }

        /* renamed from: d */
        public int b(h<x0.c> hVar) {
            return hVar.p();
        }
    }

    private class c extends d {
        c() {
        }

        public x0.c b(int i10) {
            return x0.c.Q(a.this.J(i10));
        }

        public x0.c d(int i10) {
            int i11 = i10 == 2 ? a.this.f25k : a.this.f26l;
            if (i11 == Integer.MIN_VALUE) {
                return null;
            }
            return b(i11);
        }

        public boolean f(int i10, int i11, Bundle bundle) {
            return a.this.R(i10, i11, bundle);
        }
    }

    public a(View view) {
        if (view != null) {
            this.f23i = view;
            this.f22h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            if (x.A(view) == 0) {
                x.B0(view, 1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    private static Rect D(View view, int i10, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i10 == 17) {
            rect.set(width, 0, width, height);
        } else if (i10 == 33) {
            rect.set(0, height, width, height);
        } else if (i10 == 66) {
            rect.set(-1, 0, -1, height);
        } else if (i10 == 130) {
            rect.set(0, -1, width, -1);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return rect;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x002f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean G(android.graphics.Rect r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 == 0) goto L_0x0032
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x000a
            goto L_0x0032
        L_0x000a:
            android.view.View r4 = r3.f23i
            int r4 = r4.getWindowVisibility()
            if (r4 == 0) goto L_0x0013
            return r0
        L_0x0013:
            android.view.View r4 = r3.f23i
        L_0x0015:
            android.view.ViewParent r4 = r4.getParent()
            boolean r1 = r4 instanceof android.view.View
            if (r1 == 0) goto L_0x002f
            android.view.View r4 = (android.view.View) r4
            float r1 = r4.getAlpha()
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 <= 0) goto L_0x002e
            int r1 = r4.getVisibility()
            if (r1 == 0) goto L_0x0015
        L_0x002e:
            return r0
        L_0x002f:
            if (r4 == 0) goto L_0x0032
            r0 = 1
        L_0x0032:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a1.a.G(android.graphics.Rect):boolean");
    }

    private static int H(int i10) {
        if (i10 == 19) {
            return 33;
        }
        if (i10 != 21) {
            return i10 != 22 ? 130 : 66;
        }
        return 17;
    }

    private boolean I(int i10, Rect rect) {
        Object obj;
        h<x0.c> y10 = y();
        int i11 = this.f26l;
        int i12 = Integer.MIN_VALUE;
        x0.c i13 = i11 == Integer.MIN_VALUE ? null : y10.i(i11);
        if (i10 == 1 || i10 == 2) {
            obj = b.d(y10, f17p, f16o, i13, i10, x.C(this.f23i) == 1, false);
        } else if (i10 == 17 || i10 == 33 || i10 == 66 || i10 == 130) {
            Rect rect2 = new Rect();
            int i14 = this.f26l;
            if (i14 != Integer.MIN_VALUE) {
                z(i14, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                D(this.f23i, i10, rect2);
            }
            obj = b.c(y10, f17p, f16o, i13, rect2, i10);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        x0.c cVar = (x0.c) obj;
        if (cVar != null) {
            i12 = y10.m(y10.l(cVar));
        }
        return V(i12);
    }

    private boolean S(int i10, int i11, Bundle bundle) {
        return i11 != 1 ? i11 != 2 ? i11 != 64 ? i11 != 128 ? L(i10, i11, bundle) : n(i10) : U(i10) : o(i10) : V(i10);
    }

    private boolean T(int i10, Bundle bundle) {
        return x.f0(this.f23i, i10, bundle);
    }

    private boolean U(int i10) {
        int i11;
        if (!this.f22h.isEnabled() || !this.f22h.isTouchExplorationEnabled() || (i11 = this.f25k) == i10) {
            return false;
        }
        if (i11 != Integer.MIN_VALUE) {
            n(i11);
        }
        this.f25k = i10;
        this.f23i.invalidate();
        W(i10, 32768);
        return true;
    }

    private void X(int i10) {
        int i11 = this.f27m;
        if (i11 != i10) {
            this.f27m = i10;
            W(i10, 128);
            W(i11, Config.X_DENSITY);
        }
    }

    private boolean n(int i10) {
        if (this.f25k != i10) {
            return false;
        }
        this.f25k = Integer.MIN_VALUE;
        this.f23i.invalidate();
        W(i10, 65536);
        return true;
    }

    private boolean p() {
        int i10 = this.f26l;
        return i10 != Integer.MIN_VALUE && L(i10, 16, (Bundle) null);
    }

    private AccessibilityEvent q(int i10, int i11) {
        return i10 != -1 ? r(i10, i11) : s(i11);
    }

    private AccessibilityEvent r(int i10, int i11) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i11);
        x0.c J = J(i10);
        obtain.getText().add(J.x());
        obtain.setContentDescription(J.r());
        obtain.setScrollable(J.K());
        obtain.setPassword(J.J());
        obtain.setEnabled(J.F());
        obtain.setChecked(J.D());
        N(i10, obtain);
        if (!obtain.getText().isEmpty() || obtain.getContentDescription() != null) {
            obtain.setClassName(J.p());
            e.c(obtain, this.f23i, i10);
            obtain.setPackageName(this.f23i.getContext().getPackageName());
            return obtain;
        }
        throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
    }

    private AccessibilityEvent s(int i10) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i10);
        this.f23i.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    private x0.c t(int i10) {
        x0.c O = x0.c.O();
        O.i0(true);
        O.k0(true);
        O.c0("android.view.View");
        Rect rect = f15n;
        O.X(rect);
        O.Y(rect);
        O.t0(this.f23i);
        P(i10, O);
        if (O.x() == null && O.r() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        O.m(this.f19e);
        if (!this.f19e.equals(rect)) {
            int k10 = O.k();
            if ((k10 & 64) != 0) {
                throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            } else if ((k10 & 128) == 0) {
                O.r0(this.f23i.getContext().getPackageName());
                O.C0(this.f23i, i10);
                if (this.f25k == i10) {
                    O.V(true);
                    O.a(128);
                } else {
                    O.V(false);
                    O.a(64);
                }
                boolean z10 = this.f26l == i10;
                if (z10) {
                    O.a(2);
                } else if (O.G()) {
                    O.a(1);
                }
                O.l0(z10);
                this.f23i.getLocationOnScreen(this.f21g);
                O.n(this.f18d);
                if (this.f18d.equals(rect)) {
                    O.m(this.f18d);
                    if (O.f18120b != -1) {
                        x0.c O2 = x0.c.O();
                        for (int i11 = O.f18120b; i11 != -1; i11 = O2.f18120b) {
                            O2.u0(this.f23i, -1);
                            O2.X(f15n);
                            P(i11, O2);
                            O2.m(this.f19e);
                            Rect rect2 = this.f18d;
                            Rect rect3 = this.f19e;
                            rect2.offset(rect3.left, rect3.top);
                        }
                        O2.S();
                    }
                    this.f18d.offset(this.f21g[0] - this.f23i.getScrollX(), this.f21g[1] - this.f23i.getScrollY());
                }
                if (this.f23i.getLocalVisibleRect(this.f20f)) {
                    this.f20f.offset(this.f21g[0] - this.f23i.getScrollX(), this.f21g[1] - this.f23i.getScrollY());
                    if (this.f18d.intersect(this.f20f)) {
                        O.Y(this.f18d);
                        if (G(this.f18d)) {
                            O.G0(true);
                        }
                    }
                }
                return O;
            } else {
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
        } else {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
    }

    private x0.c u() {
        x0.c P = x0.c.P(this.f23i);
        x.d0(this.f23i, P);
        ArrayList arrayList = new ArrayList();
        C(arrayList);
        if (P.o() <= 0 || arrayList.size() <= 0) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                P.d(this.f23i, ((Integer) arrayList.get(i10)).intValue());
            }
            return P;
        }
        throw new RuntimeException("Views cannot have both real and virtual children");
    }

    private h<x0.c> y() {
        ArrayList arrayList = new ArrayList();
        C(arrayList);
        h<x0.c> hVar = new h<>();
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            hVar.n(((Integer) arrayList.get(i10)).intValue(), t(((Integer) arrayList.get(i10)).intValue()));
        }
        return hVar;
    }

    private void z(int i10, Rect rect) {
        J(i10).m(rect);
    }

    public final int A() {
        return this.f26l;
    }

    /* access modifiers changed from: protected */
    public abstract int B(float f10, float f11);

    /* access modifiers changed from: protected */
    public abstract void C(List<Integer> list);

    public final void E(int i10) {
        F(i10, 0);
    }

    public final void F(int i10, int i11) {
        ViewParent parent;
        if (i10 != Integer.MIN_VALUE && this.f22h.isEnabled() && (parent = this.f23i.getParent()) != null) {
            AccessibilityEvent q10 = q(i10, RecyclerView.m.FLAG_MOVED);
            x0.b.b(q10, i11);
            parent.requestSendAccessibilityEvent(this.f23i, q10);
        }
    }

    /* access modifiers changed from: package-private */
    public x0.c J(int i10) {
        return i10 == -1 ? u() : t(i10);
    }

    public final void K(boolean z10, int i10, Rect rect) {
        int i11 = this.f26l;
        if (i11 != Integer.MIN_VALUE) {
            o(i11);
        }
        if (z10) {
            I(i10, rect);
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean L(int i10, int i11, Bundle bundle);

    /* access modifiers changed from: protected */
    public void M(AccessibilityEvent accessibilityEvent) {
    }

    /* access modifiers changed from: protected */
    public void N(int i10, AccessibilityEvent accessibilityEvent) {
    }

    /* access modifiers changed from: protected */
    public void O(x0.c cVar) {
    }

    /* access modifiers changed from: protected */
    public abstract void P(int i10, x0.c cVar);

    /* access modifiers changed from: protected */
    public void Q(int i10, boolean z10) {
    }

    /* access modifiers changed from: package-private */
    public boolean R(int i10, int i11, Bundle bundle) {
        return i10 != -1 ? S(i10, i11, bundle) : T(i11, bundle);
    }

    public final boolean V(int i10) {
        int i11;
        if ((!this.f23i.isFocused() && !this.f23i.requestFocus()) || (i11 = this.f26l) == i10) {
            return false;
        }
        if (i11 != Integer.MIN_VALUE) {
            o(i11);
        }
        if (i10 == Integer.MIN_VALUE) {
            return false;
        }
        this.f26l = i10;
        Q(i10, true);
        W(i10, 8);
        return true;
    }

    public final boolean W(int i10, int i11) {
        ViewParent parent;
        if (i10 == Integer.MIN_VALUE || !this.f22h.isEnabled() || (parent = this.f23i.getParent()) == null) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this.f23i, q(i10, i11));
    }

    public d b(View view) {
        if (this.f24j == null) {
            this.f24j = new c();
        }
        return this.f24j;
    }

    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        M(accessibilityEvent);
    }

    public void g(View view, x0.c cVar) {
        super.g(view, cVar);
        O(cVar);
    }

    public final boolean o(int i10) {
        if (this.f26l != i10) {
            return false;
        }
        this.f26l = Integer.MIN_VALUE;
        Q(i10, false);
        W(i10, 8);
        return true;
    }

    public final boolean v(MotionEvent motionEvent) {
        if (!this.f22h.isEnabled() || !this.f22h.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int B = B(motionEvent.getX(), motionEvent.getY());
            X(B);
            return B != Integer.MIN_VALUE;
        } else if (action != 10 || this.f27m == Integer.MIN_VALUE) {
            return false;
        } else {
            X(Integer.MIN_VALUE);
            return true;
        }
    }

    public final boolean w(KeyEvent keyEvent) {
        int i10 = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 61) {
            if (keyCode != 66) {
                switch (keyCode) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                        if (!keyEvent.hasNoModifiers()) {
                            return false;
                        }
                        int H = H(keyCode);
                        int repeatCount = keyEvent.getRepeatCount() + 1;
                        boolean z10 = false;
                        while (i10 < repeatCount && I(H, (Rect) null)) {
                            i10++;
                            z10 = true;
                        }
                        return z10;
                    case 23:
                        break;
                    default:
                        return false;
                }
            }
            if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
                return false;
            }
            p();
            return true;
        } else if (keyEvent.hasNoModifiers()) {
            return I(2, (Rect) null);
        } else {
            if (keyEvent.hasModifiers(1)) {
                return I(1, (Rect) null);
            }
            return false;
        }
    }

    public final int x() {
        return this.f25k;
    }
}
