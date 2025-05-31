package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
import t0.i;

final class j implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    static final ThreadLocal<j> f3604e = new ThreadLocal<>();

    /* renamed from: f  reason: collision with root package name */
    static Comparator<c> f3605f = new a();

    /* renamed from: a  reason: collision with root package name */
    ArrayList<RecyclerView> f3606a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    long f3607b;

    /* renamed from: c  reason: collision with root package name */
    long f3608c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<c> f3609d = new ArrayList<>();

    class a implements Comparator<c> {
        a() {
        }

        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            RecyclerView recyclerView = cVar.f3617d;
            if ((recyclerView == null) != (cVar2.f3617d == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z10 = cVar.f3614a;
            if (z10 != cVar2.f3614a) {
                return z10 ? -1 : 1;
            }
            int i10 = cVar2.f3615b - cVar.f3615b;
            if (i10 != 0) {
                return i10;
            }
            int i11 = cVar.f3616c - cVar2.f3616c;
            if (i11 != 0) {
                return i11;
            }
            return 0;
        }
    }

    @SuppressLint({"VisibleForTests"})
    static class b implements RecyclerView.p.c {

        /* renamed from: a  reason: collision with root package name */
        int f3610a;

        /* renamed from: b  reason: collision with root package name */
        int f3611b;

        /* renamed from: c  reason: collision with root package name */
        int[] f3612c;

        /* renamed from: d  reason: collision with root package name */
        int f3613d;

        b() {
        }

        public void a(int i10, int i11) {
            if (i10 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i11 >= 0) {
                int i12 = this.f3613d * 2;
                int[] iArr = this.f3612c;
                if (iArr == null) {
                    int[] iArr2 = new int[4];
                    this.f3612c = iArr2;
                    Arrays.fill(iArr2, -1);
                } else if (i12 >= iArr.length) {
                    int[] iArr3 = new int[(i12 * 2)];
                    this.f3612c = iArr3;
                    System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                }
                int[] iArr4 = this.f3612c;
                iArr4[i12] = i10;
                iArr4[i12 + 1] = i11;
                this.f3613d++;
            } else {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            int[] iArr = this.f3612c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f3613d = 0;
        }

        /* access modifiers changed from: package-private */
        public void c(RecyclerView recyclerView, boolean z10) {
            this.f3613d = 0;
            int[] iArr = this.f3612c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.p pVar = recyclerView.f3300m;
            if (recyclerView.f3298l != null && pVar != null && pVar.E0()) {
                if (z10) {
                    if (!recyclerView.f3282d.p()) {
                        pVar.B(recyclerView.f3298l.getItemCount(), this);
                    }
                } else if (!recyclerView.n0()) {
                    pVar.A(this.f3610a, this.f3611b, recyclerView.f3285e1, this);
                }
                int i10 = this.f3613d;
                if (i10 > pVar.f3363m) {
                    pVar.f3363m = i10;
                    pVar.f3364n = z10;
                    recyclerView.f3276b.K();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean d(int i10) {
            if (this.f3612c != null) {
                int i11 = this.f3613d * 2;
                for (int i12 = 0; i12 < i11; i12 += 2) {
                    if (this.f3612c[i12] == i10) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void e(int i10, int i11) {
            this.f3610a = i10;
            this.f3611b = i11;
        }
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f3614a;

        /* renamed from: b  reason: collision with root package name */
        public int f3615b;

        /* renamed from: c  reason: collision with root package name */
        public int f3616c;

        /* renamed from: d  reason: collision with root package name */
        public RecyclerView f3617d;

        /* renamed from: e  reason: collision with root package name */
        public int f3618e;

        c() {
        }

        public void a() {
            this.f3614a = false;
            this.f3615b = 0;
            this.f3616c = 0;
            this.f3617d = null;
            this.f3618e = 0;
        }
    }

    j() {
    }

    private void b() {
        c cVar;
        int size = this.f3606a.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            RecyclerView recyclerView = this.f3606a.get(i11);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.f3283d1.c(recyclerView, false);
                i10 += recyclerView.f3283d1.f3613d;
            }
        }
        this.f3609d.ensureCapacity(i10);
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            RecyclerView recyclerView2 = this.f3606a.get(i13);
            if (recyclerView2.getWindowVisibility() == 0) {
                b bVar = recyclerView2.f3283d1;
                int abs = Math.abs(bVar.f3610a) + Math.abs(bVar.f3611b);
                for (int i14 = 0; i14 < bVar.f3613d * 2; i14 += 2) {
                    if (i12 >= this.f3609d.size()) {
                        cVar = new c();
                        this.f3609d.add(cVar);
                    } else {
                        cVar = this.f3609d.get(i12);
                    }
                    int[] iArr = bVar.f3612c;
                    int i15 = iArr[i14 + 1];
                    cVar.f3614a = i15 <= abs;
                    cVar.f3615b = abs;
                    cVar.f3616c = i15;
                    cVar.f3617d = recyclerView2;
                    cVar.f3618e = iArr[i14];
                    i12++;
                }
            }
        }
        Collections.sort(this.f3609d, f3605f);
    }

    private void c(c cVar, long j10) {
        RecyclerView.c0 i10 = i(cVar.f3617d, cVar.f3618e, cVar.f3614a ? Long.MAX_VALUE : j10);
        if (i10 != null && i10.mNestedRecyclerView != null && i10.isBound() && !i10.isInvalid()) {
            h((RecyclerView) i10.mNestedRecyclerView.get(), j10);
        }
    }

    private void d(long j10) {
        int i10 = 0;
        while (i10 < this.f3609d.size()) {
            c cVar = this.f3609d.get(i10);
            if (cVar.f3617d != null) {
                c(cVar, j10);
                cVar.a();
                i10++;
            } else {
                return;
            }
        }
    }

    static boolean e(RecyclerView recyclerView, int i10) {
        int j10 = recyclerView.f3284e.j();
        for (int i11 = 0; i11 < j10; i11++) {
            RecyclerView.c0 h02 = RecyclerView.h0(recyclerView.f3284e.i(i11));
            if (h02.mPosition == i10 && !h02.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    private void h(RecyclerView recyclerView, long j10) {
        if (recyclerView != null) {
            if (recyclerView.E && recyclerView.f3284e.j() != 0) {
                recyclerView.W0();
            }
            b bVar = recyclerView.f3283d1;
            bVar.c(recyclerView, true);
            if (bVar.f3613d != 0) {
                try {
                    i.a("RV Nested Prefetch");
                    recyclerView.f3285e1.g(recyclerView.f3298l);
                    for (int i10 = 0; i10 < bVar.f3613d * 2; i10 += 2) {
                        i(recyclerView, bVar.f3612c[i10], j10);
                    }
                } finally {
                    i.b();
                }
            }
        }
    }

    private RecyclerView.c0 i(RecyclerView recyclerView, int i10, long j10) {
        if (e(recyclerView, i10)) {
            return null;
        }
        RecyclerView.v vVar = recyclerView.f3276b;
        try {
            recyclerView.I0();
            RecyclerView.c0 I = vVar.I(i10, false, j10);
            if (I != null) {
                if (!I.isBound() || I.isInvalid()) {
                    vVar.a(I, false);
                } else {
                    vVar.B(I.itemView);
                }
            }
            return I;
        } finally {
            recyclerView.K0(false);
        }
    }

    public void a(RecyclerView recyclerView) {
        this.f3606a.add(recyclerView);
    }

    /* access modifiers changed from: package-private */
    public void f(RecyclerView recyclerView, int i10, int i11) {
        if (recyclerView.isAttachedToWindow() && this.f3607b == 0) {
            this.f3607b = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.f3283d1.e(i10, i11);
    }

    /* access modifiers changed from: package-private */
    public void g(long j10) {
        b();
        d(j10);
    }

    public void j(RecyclerView recyclerView) {
        this.f3606a.remove(recyclerView);
    }

    public void run() {
        try {
            i.a("RV Prefetch");
            if (!this.f3606a.isEmpty()) {
                int size = this.f3606a.size();
                long j10 = 0;
                for (int i10 = 0; i10 < size; i10++) {
                    RecyclerView recyclerView = this.f3606a.get(i10);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j10 = Math.max(recyclerView.getDrawingTime(), j10);
                    }
                }
                if (j10 != 0) {
                    g(TimeUnit.MILLISECONDS.toNanos(j10) + this.f3608c);
                    this.f3607b = 0;
                    i.b();
                }
            }
        } finally {
            this.f3607b = 0;
            i.b();
        }
    }
}
