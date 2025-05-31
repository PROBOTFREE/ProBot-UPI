package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

class f {

    /* renamed from: a  reason: collision with root package name */
    final b f3504a;

    /* renamed from: b  reason: collision with root package name */
    final a f3505b = new a();

    /* renamed from: c  reason: collision with root package name */
    final List<View> f3506c = new ArrayList();

    static class a {

        /* renamed from: a  reason: collision with root package name */
        long f3507a = 0;

        /* renamed from: b  reason: collision with root package name */
        a f3508b;

        a() {
        }

        private void c() {
            if (this.f3508b == null) {
                this.f3508b = new a();
            }
        }

        /* access modifiers changed from: package-private */
        public void a(int i10) {
            if (i10 >= 64) {
                a aVar = this.f3508b;
                if (aVar != null) {
                    aVar.a(i10 - 64);
                    return;
                }
                return;
            }
            this.f3507a &= ~(1 << i10);
        }

        /* access modifiers changed from: package-private */
        public int b(int i10) {
            a aVar = this.f3508b;
            return aVar == null ? i10 >= 64 ? Long.bitCount(this.f3507a) : Long.bitCount(this.f3507a & ((1 << i10) - 1)) : i10 < 64 ? Long.bitCount(this.f3507a & ((1 << i10) - 1)) : aVar.b(i10 - 64) + Long.bitCount(this.f3507a);
        }

        /* access modifiers changed from: package-private */
        public boolean d(int i10) {
            if (i10 < 64) {
                return (this.f3507a & (1 << i10)) != 0;
            }
            c();
            return this.f3508b.d(i10 - 64);
        }

        /* access modifiers changed from: package-private */
        public void e(int i10, boolean z10) {
            if (i10 >= 64) {
                c();
                this.f3508b.e(i10 - 64, z10);
                return;
            }
            long j10 = this.f3507a;
            boolean z11 = (Long.MIN_VALUE & j10) != 0;
            long j11 = (1 << i10) - 1;
            this.f3507a = ((j10 & (~j11)) << 1) | (j10 & j11);
            if (z10) {
                h(i10);
            } else {
                a(i10);
            }
            if (z11 || this.f3508b != null) {
                c();
                this.f3508b.e(0, z11);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean f(int i10) {
            if (i10 >= 64) {
                c();
                return this.f3508b.f(i10 - 64);
            }
            long j10 = 1 << i10;
            long j11 = this.f3507a;
            boolean z10 = (j11 & j10) != 0;
            long j12 = j11 & (~j10);
            this.f3507a = j12;
            long j13 = j10 - 1;
            this.f3507a = (j12 & j13) | Long.rotateRight((~j13) & j12, 1);
            a aVar = this.f3508b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.f3508b.f(0);
            }
            return z10;
        }

        /* access modifiers changed from: package-private */
        public void g() {
            this.f3507a = 0;
            a aVar = this.f3508b;
            if (aVar != null) {
                aVar.g();
            }
        }

        /* access modifiers changed from: package-private */
        public void h(int i10) {
            if (i10 >= 64) {
                c();
                this.f3508b.h(i10 - 64);
                return;
            }
            this.f3507a |= 1 << i10;
        }

        public String toString() {
            if (this.f3508b == null) {
                return Long.toBinaryString(this.f3507a);
            }
            return this.f3508b.toString() + "xx" + Long.toBinaryString(this.f3507a);
        }
    }

    interface b {
        View a(int i10);

        void b(View view);

        RecyclerView.c0 c(View view);

        void d(int i10);

        void e(View view);

        void f(View view, int i10);

        int g();

        void h(int i10);

        void i();

        void j(View view, int i10, ViewGroup.LayoutParams layoutParams);

        int k(View view);
    }

    f(b bVar) {
        this.f3504a = bVar;
    }

    private int h(int i10) {
        if (i10 < 0) {
            return -1;
        }
        int g10 = this.f3504a.g();
        int i11 = i10;
        while (i11 < g10) {
            int b10 = i10 - (i11 - this.f3505b.b(i11));
            if (b10 == 0) {
                while (this.f3505b.d(i11)) {
                    i11++;
                }
                return i11;
            }
            i11 += b10;
        }
        return -1;
    }

    private void l(View view) {
        this.f3506c.add(view);
        this.f3504a.b(view);
    }

    private boolean t(View view) {
        if (!this.f3506c.remove(view)) {
            return false;
        }
        this.f3504a.e(view);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a(View view, int i10, boolean z10) {
        int g10 = i10 < 0 ? this.f3504a.g() : h(i10);
        this.f3505b.e(g10, z10);
        if (z10) {
            l(view);
        }
        this.f3504a.f(view, g10);
    }

    /* access modifiers changed from: package-private */
    public void b(View view, boolean z10) {
        a(view, -1, z10);
    }

    /* access modifiers changed from: package-private */
    public void c(View view, int i10, ViewGroup.LayoutParams layoutParams, boolean z10) {
        int g10 = i10 < 0 ? this.f3504a.g() : h(i10);
        this.f3505b.e(g10, z10);
        if (z10) {
            l(view);
        }
        this.f3504a.j(view, g10, layoutParams);
    }

    /* access modifiers changed from: package-private */
    public void d(int i10) {
        int h10 = h(i10);
        this.f3505b.f(h10);
        this.f3504a.d(h10);
    }

    /* access modifiers changed from: package-private */
    public View e(int i10) {
        int size = this.f3506c.size();
        for (int i11 = 0; i11 < size; i11++) {
            View view = this.f3506c.get(i11);
            RecyclerView.c0 c10 = this.f3504a.c(view);
            if (c10.getLayoutPosition() == i10 && !c10.isInvalid() && !c10.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public View f(int i10) {
        return this.f3504a.a(h(i10));
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.f3504a.g() - this.f3506c.size();
    }

    /* access modifiers changed from: package-private */
    public View i(int i10) {
        return this.f3504a.a(i10);
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return this.f3504a.g();
    }

    /* access modifiers changed from: package-private */
    public void k(View view) {
        int k10 = this.f3504a.k(view);
        if (k10 >= 0) {
            this.f3505b.h(k10);
            l(view);
            return;
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    /* access modifiers changed from: package-private */
    public int m(View view) {
        int k10 = this.f3504a.k(view);
        if (k10 != -1 && !this.f3505b.d(k10)) {
            return k10 - this.f3505b.b(k10);
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public boolean n(View view) {
        return this.f3506c.contains(view);
    }

    /* access modifiers changed from: package-private */
    public void o() {
        this.f3505b.g();
        for (int size = this.f3506c.size() - 1; size >= 0; size--) {
            this.f3504a.e(this.f3506c.get(size));
            this.f3506c.remove(size);
        }
        this.f3504a.i();
    }

    /* access modifiers changed from: package-private */
    public void p(View view) {
        int k10 = this.f3504a.k(view);
        if (k10 >= 0) {
            if (this.f3505b.f(k10)) {
                t(view);
            }
            this.f3504a.h(k10);
        }
    }

    /* access modifiers changed from: package-private */
    public void q(int i10) {
        int h10 = h(i10);
        View a10 = this.f3504a.a(h10);
        if (a10 != null) {
            if (this.f3505b.f(h10)) {
                t(a10);
            }
            this.f3504a.h(h10);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean r(View view) {
        int k10 = this.f3504a.k(view);
        if (k10 == -1) {
            t(view);
            return true;
        } else if (!this.f3505b.d(k10)) {
            return false;
        } else {
            this.f3505b.f(k10);
            t(view);
            this.f3504a.h(k10);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public void s(View view) {
        int k10 = this.f3504a.k(view);
        if (k10 < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        } else if (this.f3505b.d(k10)) {
            this.f3505b.a(k10);
            t(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public String toString() {
        return this.f3505b.toString() + ", hidden list:" + this.f3506c.size();
    }
}
