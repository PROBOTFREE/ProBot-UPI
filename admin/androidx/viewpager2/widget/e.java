package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

final class e extends RecyclerView.t {

    /* renamed from: a  reason: collision with root package name */
    private ViewPager2.i f4385a;

    /* renamed from: b  reason: collision with root package name */
    private final ViewPager2 f4386b;

    /* renamed from: c  reason: collision with root package name */
    private final RecyclerView f4387c;

    /* renamed from: d  reason: collision with root package name */
    private final LinearLayoutManager f4388d;

    /* renamed from: e  reason: collision with root package name */
    private int f4389e;

    /* renamed from: f  reason: collision with root package name */
    private int f4390f;

    /* renamed from: g  reason: collision with root package name */
    private a f4391g = new a();

    /* renamed from: h  reason: collision with root package name */
    private int f4392h;

    /* renamed from: i  reason: collision with root package name */
    private int f4393i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f4394j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f4395k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f4396l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f4397m;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        int f4398a;

        /* renamed from: b  reason: collision with root package name */
        float f4399b;

        /* renamed from: c  reason: collision with root package name */
        int f4400c;

        a() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f4398a = -1;
            this.f4399b = 0.0f;
            this.f4400c = 0;
        }
    }

    e(ViewPager2 viewPager2) {
        this.f4386b = viewPager2;
        RecyclerView recyclerView = viewPager2.f4351j;
        this.f4387c = recyclerView;
        this.f4388d = (LinearLayoutManager) recyclerView.getLayoutManager();
        l();
    }

    private void a(int i10, float f10, int i11) {
        ViewPager2.i iVar = this.f4385a;
        if (iVar != null) {
            iVar.onPageScrolled(i10, f10, i11);
        }
    }

    private void b(int i10) {
        ViewPager2.i iVar = this.f4385a;
        if (iVar != null) {
            iVar.onPageSelected(i10);
        }
    }

    private void c(int i10) {
        if ((this.f4389e != 3 || this.f4390f != 0) && this.f4390f != i10) {
            this.f4390f = i10;
            ViewPager2.i iVar = this.f4385a;
            if (iVar != null) {
                iVar.onPageScrollStateChanged(i10);
            }
        }
    }

    private int d() {
        return this.f4388d.k2();
    }

    private boolean i() {
        int i10 = this.f4389e;
        return i10 == 1 || i10 == 4;
    }

    private void l() {
        this.f4389e = 0;
        this.f4390f = 0;
        this.f4391g.a();
        this.f4392h = -1;
        this.f4393i = -1;
        this.f4394j = false;
        this.f4395k = false;
        this.f4397m = false;
        this.f4396l = false;
    }

    private void n(boolean z10) {
        this.f4397m = z10;
        this.f4389e = z10 ? 4 : 1;
        int i10 = this.f4393i;
        if (i10 != -1) {
            this.f4392h = i10;
            this.f4393i = -1;
        } else if (this.f4392h == -1) {
            this.f4392h = d();
        }
        c(1);
    }

    private void o() {
        int i10;
        a aVar = this.f4391g;
        int k22 = this.f4388d.k2();
        aVar.f4398a = k22;
        if (k22 == -1) {
            aVar.a();
            return;
        }
        View Q = this.f4388d.Q(k22);
        if (Q == null) {
            aVar.a();
            return;
        }
        int o02 = this.f4388d.o0(Q);
        int t02 = this.f4388d.t0(Q);
        int w02 = this.f4388d.w0(Q);
        int V = this.f4388d.V(Q);
        ViewGroup.LayoutParams layoutParams = Q.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            o02 += marginLayoutParams.leftMargin;
            t02 += marginLayoutParams.rightMargin;
            w02 += marginLayoutParams.topMargin;
            V += marginLayoutParams.bottomMargin;
        }
        int height = Q.getHeight() + w02 + V;
        int width = Q.getWidth() + o02 + t02;
        if (this.f4388d.x2() == 0) {
            i10 = (Q.getLeft() - o02) - this.f4387c.getPaddingLeft();
            if (this.f4386b.d()) {
                i10 = -i10;
            }
            height = width;
        } else {
            i10 = (Q.getTop() - w02) - this.f4387c.getPaddingTop();
        }
        int i11 = -i10;
        aVar.f4400c = i11;
        if (i11 >= 0) {
            aVar.f4399b = height == 0 ? 0.0f : ((float) i11) / ((float) height);
        } else if (new a(this.f4388d).d()) {
            throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
        } else {
            throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", new Object[]{Integer.valueOf(aVar.f4400c)}));
        }
    }

    /* access modifiers changed from: package-private */
    public double e() {
        o();
        a aVar = this.f4391g;
        return ((double) aVar.f4398a) + ((double) aVar.f4399b);
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f4390f;
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        return this.f4397m;
    }

    /* access modifiers changed from: package-private */
    public boolean h() {
        return this.f4390f == 0;
    }

    /* access modifiers changed from: package-private */
    public void j() {
        this.f4396l = true;
    }

    /* access modifiers changed from: package-private */
    public void k(int i10, boolean z10) {
        this.f4389e = z10 ? 2 : 3;
        boolean z11 = false;
        this.f4397m = false;
        if (this.f4393i != i10) {
            z11 = true;
        }
        this.f4393i = i10;
        c(2);
        if (z11) {
            b(i10);
        }
    }

    /* access modifiers changed from: package-private */
    public void m(ViewPager2.i iVar) {
        this.f4385a = iVar;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
        boolean z10 = true;
        if (!(this.f4389e == 1 && this.f4390f == 1) && i10 == 1) {
            n(false);
        } else if (!i() || i10 != 2) {
            if (i() && i10 == 0) {
                o();
                if (!this.f4395k) {
                    int i11 = this.f4391g.f4398a;
                    if (i11 != -1) {
                        a(i11, 0.0f, 0);
                    }
                } else {
                    a aVar = this.f4391g;
                    if (aVar.f4400c == 0) {
                        int i12 = this.f4392h;
                        int i13 = aVar.f4398a;
                        if (i12 != i13) {
                            b(i13);
                        }
                    } else {
                        z10 = false;
                    }
                }
                if (z10) {
                    c(0);
                    l();
                }
            }
            if (this.f4389e == 2 && i10 == 0 && this.f4396l) {
                o();
                a aVar2 = this.f4391g;
                if (aVar2.f4400c == 0) {
                    int i14 = this.f4393i;
                    int i15 = aVar2.f4398a;
                    if (i14 != i15) {
                        if (i15 == -1) {
                            i15 = 0;
                        }
                        b(i15);
                    }
                    c(0);
                    l();
                }
            }
        } else if (this.f4395k) {
            c(2);
            this.f4394j = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0037, code lost:
        if (r3.f4392h != r5) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        if ((r5 < 0) == r3.f4386b.d()) goto L_0x0022;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onScrolled(androidx.recyclerview.widget.RecyclerView r4, int r5, int r6) {
        /*
            r3 = this;
            r4 = 1
            r3.f4395k = r4
            r3.o()
            boolean r0 = r3.f4394j
            r1 = -1
            r2 = 0
            if (r0 == 0) goto L_0x003a
            r3.f4394j = r2
            if (r6 > 0) goto L_0x0022
            if (r6 != 0) goto L_0x0020
            if (r5 >= 0) goto L_0x0016
            r5 = r4
            goto L_0x0017
        L_0x0016:
            r5 = r2
        L_0x0017:
            androidx.viewpager2.widget.ViewPager2 r6 = r3.f4386b
            boolean r6 = r6.d()
            if (r5 != r6) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r5 = r2
            goto L_0x0023
        L_0x0022:
            r5 = r4
        L_0x0023:
            if (r5 == 0) goto L_0x002f
            androidx.viewpager2.widget.e$a r5 = r3.f4391g
            int r6 = r5.f4400c
            if (r6 == 0) goto L_0x002f
            int r5 = r5.f4398a
            int r5 = r5 + r4
            goto L_0x0033
        L_0x002f:
            androidx.viewpager2.widget.e$a r5 = r3.f4391g
            int r5 = r5.f4398a
        L_0x0033:
            r3.f4393i = r5
            int r6 = r3.f4392h
            if (r6 == r5) goto L_0x0048
            goto L_0x0045
        L_0x003a:
            int r5 = r3.f4389e
            if (r5 != 0) goto L_0x0048
            androidx.viewpager2.widget.e$a r5 = r3.f4391g
            int r5 = r5.f4398a
            if (r5 != r1) goto L_0x0045
            r5 = r2
        L_0x0045:
            r3.b(r5)
        L_0x0048:
            androidx.viewpager2.widget.e$a r5 = r3.f4391g
            int r6 = r5.f4398a
            if (r6 != r1) goto L_0x004f
            r6 = r2
        L_0x004f:
            float r0 = r5.f4399b
            int r5 = r5.f4400c
            r3.a(r6, r0, r5)
            androidx.viewpager2.widget.e$a r5 = r3.f4391g
            int r6 = r5.f4398a
            int r0 = r3.f4393i
            if (r6 == r0) goto L_0x0060
            if (r0 != r1) goto L_0x006e
        L_0x0060:
            int r5 = r5.f4400c
            if (r5 != 0) goto L_0x006e
            int r5 = r3.f4390f
            if (r5 == r4) goto L_0x006e
            r3.c(r2)
            r3.l()
        L_0x006e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.e.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }
}
