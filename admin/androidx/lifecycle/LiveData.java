package androidx.lifecycle;

import androidx.lifecycle.h;
import java.util.Map;

public abstract class LiveData<T> {

    /* renamed from: k  reason: collision with root package name */
    static final Object f2955k = new Object();

    /* renamed from: a  reason: collision with root package name */
    final Object f2956a;

    /* renamed from: b  reason: collision with root package name */
    private r.b<v<? super T>, LiveData<T>.c> f2957b;

    /* renamed from: c  reason: collision with root package name */
    int f2958c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2959d;

    /* renamed from: e  reason: collision with root package name */
    private volatile Object f2960e;

    /* renamed from: f  reason: collision with root package name */
    volatile Object f2961f;

    /* renamed from: g  reason: collision with root package name */
    private int f2962g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f2963h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f2964i;

    /* renamed from: j  reason: collision with root package name */
    private final Runnable f2965j;

    class LifecycleBoundObserver extends LiveData<T>.c implements m {

        /* renamed from: e  reason: collision with root package name */
        final o f2966e;

        LifecycleBoundObserver(o oVar, v<? super T> vVar) {
            super(vVar);
            this.f2966e = oVar;
        }

        public void c(o oVar, h.b bVar) {
            h.c b10 = this.f2966e.getLifecycle().b();
            if (b10 == h.c.DESTROYED) {
                LiveData.this.k(this.f2969a);
                return;
            }
            h.c cVar = null;
            while (cVar != b10) {
                d(h());
                cVar = b10;
                b10 = this.f2966e.getLifecycle().b();
            }
        }

        /* access modifiers changed from: package-private */
        public void f() {
            this.f2966e.getLifecycle().c(this);
        }

        /* access modifiers changed from: package-private */
        public boolean g(o oVar) {
            return this.f2966e == oVar;
        }

        /* access modifiers changed from: package-private */
        public boolean h() {
            return this.f2966e.getLifecycle().b().a(h.c.STARTED);
        }
    }

    class a implements Runnable {
        a() {
        }

        public void run() {
            Object obj;
            synchronized (LiveData.this.f2956a) {
                obj = LiveData.this.f2961f;
                LiveData.this.f2961f = LiveData.f2955k;
            }
            LiveData.this.l(obj);
        }
    }

    private class b extends LiveData<T>.c {
        b(LiveData liveData, v<? super T> vVar) {
            super(vVar);
        }

        /* access modifiers changed from: package-private */
        public boolean h() {
            return true;
        }
    }

    private abstract class c {

        /* renamed from: a  reason: collision with root package name */
        final v<? super T> f2969a;

        /* renamed from: b  reason: collision with root package name */
        boolean f2970b;

        /* renamed from: c  reason: collision with root package name */
        int f2971c = -1;

        c(v<? super T> vVar) {
            this.f2969a = vVar;
        }

        /* access modifiers changed from: package-private */
        public void d(boolean z10) {
            if (z10 != this.f2970b) {
                this.f2970b = z10;
                LiveData.this.b(z10 ? 1 : -1);
                if (this.f2970b) {
                    LiveData.this.d(this);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void f() {
        }

        /* access modifiers changed from: package-private */
        public boolean g(o oVar) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public abstract boolean h();
    }

    public LiveData() {
        this.f2956a = new Object();
        this.f2957b = new r.b<>();
        this.f2958c = 0;
        Object obj = f2955k;
        this.f2961f = obj;
        this.f2965j = new a();
        this.f2960e = obj;
        this.f2962g = -1;
    }

    public LiveData(T t10) {
        this.f2956a = new Object();
        this.f2957b = new r.b<>();
        this.f2958c = 0;
        this.f2961f = f2955k;
        this.f2965j = new a();
        this.f2960e = t10;
        this.f2962g = 0;
    }

    static void a(String str) {
        if (!q.a.e().b()) {
            throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
        }
    }

    private void c(LiveData<T>.c cVar) {
        if (cVar.f2970b) {
            if (!cVar.h()) {
                cVar.d(false);
                return;
            }
            int i10 = cVar.f2971c;
            int i11 = this.f2962g;
            if (i10 < i11) {
                cVar.f2971c = i11;
                cVar.f2969a.onChanged(this.f2960e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(int i10) {
        int i11 = this.f2958c;
        this.f2958c = i10 + i11;
        if (!this.f2959d) {
            this.f2959d = true;
            while (true) {
                try {
                    int i12 = this.f2958c;
                    if (i11 != i12) {
                        boolean z10 = i11 == 0 && i12 > 0;
                        boolean z11 = i11 > 0 && i12 == 0;
                        if (z10) {
                            h();
                        } else if (z11) {
                            i();
                        }
                        i11 = i12;
                    } else {
                        return;
                    }
                } finally {
                    this.f2959d = false;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d(LiveData<T>.c cVar) {
        if (this.f2963h) {
            this.f2964i = true;
            return;
        }
        this.f2963h = true;
        do {
            this.f2964i = false;
            if (cVar == null) {
                r.b<K, V>.d i10 = this.f2957b.i();
                while (i10.hasNext()) {
                    c((c) ((Map.Entry) i10.next()).getValue());
                    if (this.f2964i) {
                        break;
                    }
                }
            } else {
                c(cVar);
                cVar = null;
            }
        } while (this.f2964i);
        this.f2963h = false;
    }

    public T e() {
        T t10 = this.f2960e;
        if (t10 != f2955k) {
            return t10;
        }
        return null;
    }

    public void f(o oVar, v<? super T> vVar) {
        a("observe");
        if (oVar.getLifecycle().b() != h.c.DESTROYED) {
            LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(oVar, vVar);
            c u10 = this.f2957b.u(vVar, lifecycleBoundObserver);
            if (u10 != null && !u10.g(oVar)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (u10 == null) {
                oVar.getLifecycle().a(lifecycleBoundObserver);
            }
        }
    }

    public void g(v<? super T> vVar) {
        a("observeForever");
        b bVar = new b(this, vVar);
        c u10 = this.f2957b.u(vVar, bVar);
        if (u10 instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        } else if (u10 == null) {
            bVar.d(true);
        }
    }

    /* access modifiers changed from: protected */
    public void h() {
    }

    /* access modifiers changed from: protected */
    public void i() {
    }

    /* access modifiers changed from: protected */
    public void j(T t10) {
        boolean z10;
        synchronized (this.f2956a) {
            z10 = this.f2961f == f2955k;
            this.f2961f = t10;
        }
        if (z10) {
            q.a.e().c(this.f2965j);
        }
    }

    public void k(v<? super T> vVar) {
        a("removeObserver");
        c v10 = this.f2957b.v(vVar);
        if (v10 != null) {
            v10.f();
            v10.d(false);
        }
    }

    /* access modifiers changed from: protected */
    public void l(T t10) {
        a("setValue");
        this.f2962g++;
        this.f2960e = t10;
        d((LiveData<T>.c) null);
    }
}
