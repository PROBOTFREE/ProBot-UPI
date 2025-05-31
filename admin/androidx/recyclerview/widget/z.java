package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import c0.d;
import c0.g;
import w0.e;
import w0.f;

class z {

    /* renamed from: a  reason: collision with root package name */
    final g<RecyclerView.c0, a> f3711a = new g<>();

    /* renamed from: b  reason: collision with root package name */
    final d<RecyclerView.c0> f3712b = new d<>();

    static class a {

        /* renamed from: d  reason: collision with root package name */
        static e<a> f3713d = new f(20);

        /* renamed from: a  reason: collision with root package name */
        int f3714a;

        /* renamed from: b  reason: collision with root package name */
        RecyclerView.m.c f3715b;

        /* renamed from: c  reason: collision with root package name */
        RecyclerView.m.c f3716c;

        private a() {
        }

        static void a() {
            do {
            } while (f3713d.b() != null);
        }

        static a b() {
            a b10 = f3713d.b();
            return b10 == null ? new a() : b10;
        }

        static void c(a aVar) {
            aVar.f3714a = 0;
            aVar.f3715b = null;
            aVar.f3716c = null;
            f3713d.a(aVar);
        }
    }

    interface b {
        void a(RecyclerView.c0 c0Var);

        void b(RecyclerView.c0 c0Var, RecyclerView.m.c cVar, RecyclerView.m.c cVar2);

        void c(RecyclerView.c0 c0Var, RecyclerView.m.c cVar, RecyclerView.m.c cVar2);

        void d(RecyclerView.c0 c0Var, RecyclerView.m.c cVar, RecyclerView.m.c cVar2);
    }

    z() {
    }

    private RecyclerView.m.c l(RecyclerView.c0 c0Var, int i10) {
        a o10;
        RecyclerView.m.c cVar;
        int h10 = this.f3711a.h(c0Var);
        if (h10 >= 0 && (o10 = this.f3711a.o(h10)) != null) {
            int i11 = o10.f3714a;
            if ((i11 & i10) != 0) {
                int i12 = (~i10) & i11;
                o10.f3714a = i12;
                if (i10 == 4) {
                    cVar = o10.f3715b;
                } else if (i10 == 8) {
                    cVar = o10.f3716c;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((i12 & 12) == 0) {
                    this.f3711a.m(h10);
                    a.c(o10);
                }
                return cVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.c0 c0Var, RecyclerView.m.c cVar) {
        a aVar = this.f3711a.get(c0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f3711a.put(c0Var, aVar);
        }
        aVar.f3714a |= 2;
        aVar.f3715b = cVar;
    }

    /* access modifiers changed from: package-private */
    public void b(RecyclerView.c0 c0Var) {
        a aVar = this.f3711a.get(c0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f3711a.put(c0Var, aVar);
        }
        aVar.f3714a |= 1;
    }

    /* access modifiers changed from: package-private */
    public void c(long j10, RecyclerView.c0 c0Var) {
        this.f3712b.n(j10, c0Var);
    }

    /* access modifiers changed from: package-private */
    public void d(RecyclerView.c0 c0Var, RecyclerView.m.c cVar) {
        a aVar = this.f3711a.get(c0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f3711a.put(c0Var, aVar);
        }
        aVar.f3716c = cVar;
        aVar.f3714a |= 8;
    }

    /* access modifiers changed from: package-private */
    public void e(RecyclerView.c0 c0Var, RecyclerView.m.c cVar) {
        a aVar = this.f3711a.get(c0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f3711a.put(c0Var, aVar);
        }
        aVar.f3715b = cVar;
        aVar.f3714a |= 4;
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.f3711a.clear();
        this.f3712b.b();
    }

    /* access modifiers changed from: package-private */
    public RecyclerView.c0 g(long j10) {
        return this.f3712b.i(j10);
    }

    /* access modifiers changed from: package-private */
    public boolean h(RecyclerView.c0 c0Var) {
        a aVar = this.f3711a.get(c0Var);
        return (aVar == null || (aVar.f3714a & 1) == 0) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public boolean i(RecyclerView.c0 c0Var) {
        a aVar = this.f3711a.get(c0Var);
        return (aVar == null || (aVar.f3714a & 4) == 0) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public void j() {
        a.a();
    }

    public void k(RecyclerView.c0 c0Var) {
        p(c0Var);
    }

    /* access modifiers changed from: package-private */
    public RecyclerView.m.c m(RecyclerView.c0 c0Var) {
        return l(c0Var, 8);
    }

    /* access modifiers changed from: package-private */
    public RecyclerView.m.c n(RecyclerView.c0 c0Var) {
        return l(c0Var, 4);
    }

    /* access modifiers changed from: package-private */
    public void o(b bVar) {
        RecyclerView.m.c cVar;
        RecyclerView.m.c cVar2;
        for (int size = this.f3711a.size() - 1; size >= 0; size--) {
            RecyclerView.c0 k10 = this.f3711a.k(size);
            a m10 = this.f3711a.m(size);
            int i10 = m10.f3714a;
            if ((i10 & 3) != 3) {
                if ((i10 & 1) != 0) {
                    cVar = m10.f3715b;
                    if (cVar != null) {
                        cVar2 = m10.f3716c;
                    }
                } else {
                    if ((i10 & 14) != 14) {
                        if ((i10 & 12) == 12) {
                            bVar.d(k10, m10.f3715b, m10.f3716c);
                        } else if ((i10 & 4) != 0) {
                            cVar = m10.f3715b;
                            cVar2 = null;
                        } else if ((i10 & 8) == 0) {
                        }
                        a.c(m10);
                    }
                    bVar.b(k10, m10.f3715b, m10.f3716c);
                    a.c(m10);
                }
                bVar.c(k10, cVar, cVar2);
                a.c(m10);
            }
            bVar.a(k10);
            a.c(m10);
        }
    }

    /* access modifiers changed from: package-private */
    public void p(RecyclerView.c0 c0Var) {
        a aVar = this.f3711a.get(c0Var);
        if (aVar != null) {
            aVar.f3714a &= -2;
        }
    }

    /* access modifiers changed from: package-private */
    public void q(RecyclerView.c0 c0Var) {
        int q10 = this.f3712b.q() - 1;
        while (true) {
            if (q10 < 0) {
                break;
            } else if (c0Var == this.f3712b.r(q10)) {
                this.f3712b.p(q10);
                break;
            } else {
                q10--;
            }
        }
        a remove = this.f3711a.remove(c0Var);
        if (remove != null) {
            a.c(remove);
        }
    }
}
