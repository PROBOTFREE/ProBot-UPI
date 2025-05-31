package androidx.lifecycle;

import android.annotation.SuppressLint;
import androidx.lifecycle.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import r.b;

public class p extends h {

    /* renamed from: a  reason: collision with root package name */
    private r.a<n, a> f3035a;

    /* renamed from: b  reason: collision with root package name */
    private h.c f3036b;

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference<o> f3037c;

    /* renamed from: d  reason: collision with root package name */
    private int f3038d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3039e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3040f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<h.c> f3041g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f3042h;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        h.c f3043a;

        /* renamed from: b  reason: collision with root package name */
        m f3044b;

        a(n nVar, h.c cVar) {
            this.f3044b = s.f(nVar);
            this.f3043a = cVar;
        }

        /* access modifiers changed from: package-private */
        public void a(o oVar, h.b bVar) {
            h.c b10 = bVar.b();
            this.f3043a = p.k(this.f3043a, b10);
            this.f3044b.c(oVar, bVar);
            this.f3043a = b10;
        }
    }

    public p(o oVar) {
        this(oVar, true);
    }

    private p(o oVar, boolean z10) {
        this.f3035a = new r.a<>();
        this.f3038d = 0;
        this.f3039e = false;
        this.f3040f = false;
        this.f3041g = new ArrayList<>();
        this.f3037c = new WeakReference<>(oVar);
        this.f3036b = h.c.INITIALIZED;
        this.f3042h = z10;
    }

    private void d(o oVar) {
        Iterator<Map.Entry<n, a>> c10 = this.f3035a.c();
        while (c10.hasNext() && !this.f3040f) {
            Map.Entry next = c10.next();
            a aVar = (a) next.getValue();
            while (aVar.f3043a.compareTo(this.f3036b) > 0 && !this.f3040f && this.f3035a.contains((n) next.getKey())) {
                h.b a10 = h.b.a(aVar.f3043a);
                if (a10 != null) {
                    n(a10.b());
                    aVar.a(oVar, a10);
                    m();
                } else {
                    throw new IllegalStateException("no event down from " + aVar.f3043a);
                }
            }
        }
    }

    private h.c e(n nVar) {
        Map.Entry<n, a> w10 = this.f3035a.w(nVar);
        h.c cVar = null;
        h.c cVar2 = w10 != null ? w10.getValue().f3043a : null;
        if (!this.f3041g.isEmpty()) {
            ArrayList<h.c> arrayList = this.f3041g;
            cVar = arrayList.get(arrayList.size() - 1);
        }
        return k(k(this.f3036b, cVar2), cVar);
    }

    @SuppressLint({"RestrictedApi"})
    private void f(String str) {
        if (this.f3042h && !q.a.e().b()) {
            throw new IllegalStateException("Method " + str + " must be called on the main thread");
        }
    }

    private void g(o oVar) {
        b<K, V>.d i10 = this.f3035a.i();
        while (i10.hasNext() && !this.f3040f) {
            Map.Entry entry = (Map.Entry) i10.next();
            a aVar = (a) entry.getValue();
            while (aVar.f3043a.compareTo(this.f3036b) < 0 && !this.f3040f && this.f3035a.contains((n) entry.getKey())) {
                n(aVar.f3043a);
                h.b e10 = h.b.e(aVar.f3043a);
                if (e10 != null) {
                    aVar.a(oVar, e10);
                    m();
                } else {
                    throw new IllegalStateException("no event up from " + aVar.f3043a);
                }
            }
        }
    }

    private boolean i() {
        if (this.f3035a.size() == 0) {
            return true;
        }
        h.c cVar = this.f3035a.f().getValue().f3043a;
        h.c cVar2 = this.f3035a.k().getValue().f3043a;
        return cVar == cVar2 && this.f3036b == cVar2;
    }

    static h.c k(h.c cVar, h.c cVar2) {
        return (cVar2 == null || cVar2.compareTo(cVar) >= 0) ? cVar : cVar2;
    }

    private void l(h.c cVar) {
        if (this.f3036b != cVar) {
            this.f3036b = cVar;
            if (this.f3039e || this.f3038d != 0) {
                this.f3040f = true;
                return;
            }
            this.f3039e = true;
            p();
            this.f3039e = false;
        }
    }

    private void m() {
        ArrayList<h.c> arrayList = this.f3041g;
        arrayList.remove(arrayList.size() - 1);
    }

    private void n(h.c cVar) {
        this.f3041g.add(cVar);
    }

    private void p() {
        o oVar = (o) this.f3037c.get();
        if (oVar != null) {
            while (true) {
                boolean i10 = i();
                this.f3040f = false;
                if (!i10) {
                    if (this.f3036b.compareTo(this.f3035a.f().getValue().f3043a) < 0) {
                        d(oVar);
                    }
                    Map.Entry<n, a> k10 = this.f3035a.k();
                    if (!this.f3040f && k10 != null && this.f3036b.compareTo(k10.getValue().f3043a) > 0) {
                        g(oVar);
                    }
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
    }

    public void a(n nVar) {
        o oVar;
        f("addObserver");
        h.c cVar = this.f3036b;
        h.c cVar2 = h.c.DESTROYED;
        if (cVar != cVar2) {
            cVar2 = h.c.INITIALIZED;
        }
        a aVar = new a(nVar, cVar2);
        if (this.f3035a.u(nVar, aVar) == null && (oVar = (o) this.f3037c.get()) != null) {
            boolean z10 = this.f3038d != 0 || this.f3039e;
            h.c e10 = e(nVar);
            this.f3038d++;
            while (aVar.f3043a.compareTo(e10) < 0 && this.f3035a.contains(nVar)) {
                n(aVar.f3043a);
                h.b e11 = h.b.e(aVar.f3043a);
                if (e11 != null) {
                    aVar.a(oVar, e11);
                    m();
                    e10 = e(nVar);
                } else {
                    throw new IllegalStateException("no event up from " + aVar.f3043a);
                }
            }
            if (!z10) {
                p();
            }
            this.f3038d--;
        }
    }

    public h.c b() {
        return this.f3036b;
    }

    public void c(n nVar) {
        f("removeObserver");
        this.f3035a.v(nVar);
    }

    public void h(h.b bVar) {
        f("handleLifecycleEvent");
        l(bVar.b());
    }

    @Deprecated
    public void j(h.c cVar) {
        f("markState");
        o(cVar);
    }

    public void o(h.c cVar) {
        f("setCurrentState");
        l(cVar);
    }
}
