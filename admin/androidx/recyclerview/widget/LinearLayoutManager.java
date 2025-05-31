package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.k;
import java.util.List;

public class LinearLayoutManager extends RecyclerView.p implements k.j, RecyclerView.y.b {
    int A;
    int B;
    private boolean C;
    SavedState D;
    final a E;
    private final b F;
    private int G;
    private int[] H;

    /* renamed from: s  reason: collision with root package name */
    int f3238s;

    /* renamed from: t  reason: collision with root package name */
    private c f3239t;

    /* renamed from: u  reason: collision with root package name */
    s f3240u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f3241v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f3242w;

    /* renamed from: x  reason: collision with root package name */
    boolean f3243x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f3244y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f3245z;

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        int f3246a;

        /* renamed from: b  reason: collision with root package name */
        int f3247b;

        /* renamed from: c  reason: collision with root package name */
        boolean f3248c;

        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f3246a = parcel.readInt();
            this.f3247b = parcel.readInt();
            this.f3248c = parcel.readInt() != 1 ? false : true;
        }

        public SavedState(SavedState savedState) {
            this.f3246a = savedState.f3246a;
            this.f3247b = savedState.f3247b;
            this.f3248c = savedState.f3248c;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.f3246a >= 0;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f3246a = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f3246a);
            parcel.writeInt(this.f3247b);
            parcel.writeInt(this.f3248c ? 1 : 0);
        }
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        s f3249a;

        /* renamed from: b  reason: collision with root package name */
        int f3250b;

        /* renamed from: c  reason: collision with root package name */
        int f3251c;

        /* renamed from: d  reason: collision with root package name */
        boolean f3252d;

        /* renamed from: e  reason: collision with root package name */
        boolean f3253e;

        a() {
            e();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f3251c = this.f3252d ? this.f3249a.i() : this.f3249a.m();
        }

        public void b(View view, int i10) {
            this.f3251c = this.f3252d ? this.f3249a.d(view) + this.f3249a.o() : this.f3249a.g(view);
            this.f3250b = i10;
        }

        public void c(View view, int i10) {
            int o10 = this.f3249a.o();
            if (o10 >= 0) {
                b(view, i10);
                return;
            }
            this.f3250b = i10;
            if (this.f3252d) {
                int i11 = (this.f3249a.i() - o10) - this.f3249a.d(view);
                this.f3251c = this.f3249a.i() - i11;
                if (i11 > 0) {
                    int e10 = this.f3251c - this.f3249a.e(view);
                    int m10 = this.f3249a.m();
                    int min = e10 - (m10 + Math.min(this.f3249a.g(view) - m10, 0));
                    if (min < 0) {
                        this.f3251c += Math.min(i11, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int g10 = this.f3249a.g(view);
            int m11 = g10 - this.f3249a.m();
            this.f3251c = g10;
            if (m11 > 0) {
                int i12 = (this.f3249a.i() - Math.min(0, (this.f3249a.i() - o10) - this.f3249a.d(view))) - (g10 + this.f3249a.e(view));
                if (i12 < 0) {
                    this.f3251c -= Math.min(m11, -i12);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean d(View view, RecyclerView.z zVar) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return !layoutParams.c() && layoutParams.a() >= 0 && layoutParams.a() < zVar.b();
        }

        /* access modifiers changed from: package-private */
        public void e() {
            this.f3250b = -1;
            this.f3251c = Integer.MIN_VALUE;
            this.f3252d = false;
            this.f3253e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f3250b + ", mCoordinate=" + this.f3251c + ", mLayoutFromEnd=" + this.f3252d + ", mValid=" + this.f3253e + '}';
        }
    }

    protected static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f3254a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f3255b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f3256c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f3257d;

        protected b() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f3254a = 0;
            this.f3255b = false;
            this.f3256c = false;
            this.f3257d = false;
        }
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        boolean f3258a = true;

        /* renamed from: b  reason: collision with root package name */
        int f3259b;

        /* renamed from: c  reason: collision with root package name */
        int f3260c;

        /* renamed from: d  reason: collision with root package name */
        int f3261d;

        /* renamed from: e  reason: collision with root package name */
        int f3262e;

        /* renamed from: f  reason: collision with root package name */
        int f3263f;

        /* renamed from: g  reason: collision with root package name */
        int f3264g;

        /* renamed from: h  reason: collision with root package name */
        int f3265h = 0;

        /* renamed from: i  reason: collision with root package name */
        int f3266i = 0;

        /* renamed from: j  reason: collision with root package name */
        boolean f3267j;

        /* renamed from: k  reason: collision with root package name */
        int f3268k;

        /* renamed from: l  reason: collision with root package name */
        List<RecyclerView.c0> f3269l = null;

        /* renamed from: m  reason: collision with root package name */
        boolean f3270m;

        c() {
        }

        private View e() {
            int size = this.f3269l.size();
            for (int i10 = 0; i10 < size; i10++) {
                View view = this.f3269l.get(i10).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (!layoutParams.c() && this.f3261d == layoutParams.a()) {
                    b(view);
                    return view;
                }
            }
            return null;
        }

        public void a() {
            b((View) null);
        }

        public void b(View view) {
            View f10 = f(view);
            this.f3261d = f10 == null ? -1 : ((RecyclerView.LayoutParams) f10.getLayoutParams()).a();
        }

        /* access modifiers changed from: package-private */
        public boolean c(RecyclerView.z zVar) {
            int i10 = this.f3261d;
            return i10 >= 0 && i10 < zVar.b();
        }

        /* access modifiers changed from: package-private */
        public View d(RecyclerView.v vVar) {
            if (this.f3269l != null) {
                return e();
            }
            View o10 = vVar.o(this.f3261d);
            this.f3261d += this.f3262e;
            return o10;
        }

        public View f(View view) {
            int a10;
            int size = this.f3269l.size();
            View view2 = null;
            int i10 = Integer.MAX_VALUE;
            for (int i11 = 0; i11 < size; i11++) {
                View view3 = this.f3269l.get(i11).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view3.getLayoutParams();
                if (view3 != view && !layoutParams.c() && (a10 = (layoutParams.a() - this.f3261d) * this.f3262e) >= 0 && a10 < i10) {
                    view2 = view3;
                    if (a10 == 0) {
                        break;
                    }
                    i10 = a10;
                }
            }
            return view2;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i10, boolean z10) {
        this.f3238s = 1;
        this.f3242w = false;
        this.f3243x = false;
        this.f3244y = false;
        this.f3245z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = null;
        this.E = new a();
        this.F = new b();
        this.G = 2;
        this.H = new int[2];
        L2(i10);
        M2(z10);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.f3238s = 1;
        this.f3242w = false;
        this.f3243x = false;
        this.f3244y = false;
        this.f3245z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = null;
        this.E = new a();
        this.F = new b();
        this.G = 2;
        this.H = new int[2];
        RecyclerView.p.d s02 = RecyclerView.p.s0(context, attributeSet, i10, i11);
        L2(s02.f3371a);
        M2(s02.f3373c);
        N2(s02.f3374d);
    }

    private void B2(RecyclerView.v vVar, RecyclerView.z zVar, int i10, int i11) {
        RecyclerView.v vVar2 = vVar;
        RecyclerView.z zVar2 = zVar;
        if (zVar.h() && X() != 0 && !zVar.f() && X1()) {
            List<RecyclerView.c0> k10 = vVar.k();
            int size = k10.size();
            int r02 = r0(W(0));
            int i12 = 0;
            int i13 = 0;
            for (int i14 = 0; i14 < size; i14++) {
                RecyclerView.c0 c0Var = k10.get(i14);
                if (!c0Var.isRemoved()) {
                    boolean z10 = true;
                    if ((c0Var.getLayoutPosition() < r02) != this.f3243x) {
                        z10 = true;
                    }
                    int e10 = this.f3240u.e(c0Var.itemView);
                    if (z10) {
                        i12 += e10;
                    } else {
                        i13 += e10;
                    }
                }
            }
            this.f3239t.f3269l = k10;
            if (i12 > 0) {
                U2(r0(v2()), i10);
                c cVar = this.f3239t;
                cVar.f3265h = i12;
                cVar.f3260c = 0;
                cVar.a();
                g2(vVar2, this.f3239t, zVar2, false);
            }
            if (i13 > 0) {
                S2(r0(u2()), i11);
                c cVar2 = this.f3239t;
                cVar2.f3265h = i13;
                cVar2.f3260c = 0;
                cVar2.a();
                g2(vVar2, this.f3239t, zVar2, false);
            }
            this.f3239t.f3269l = null;
        }
    }

    private void D2(RecyclerView.v vVar, c cVar) {
        if (cVar.f3258a && !cVar.f3270m) {
            int i10 = cVar.f3264g;
            int i11 = cVar.f3266i;
            if (cVar.f3263f == -1) {
                F2(vVar, i10, i11);
            } else {
                G2(vVar, i10, i11);
            }
        }
    }

    private void E2(RecyclerView.v vVar, int i10, int i11) {
        if (i10 != i11) {
            if (i11 > i10) {
                for (int i12 = i11 - 1; i12 >= i10; i12--) {
                    z1(i12, vVar);
                }
                return;
            }
            while (i10 > i11) {
                z1(i10, vVar);
                i10--;
            }
        }
    }

    private void F2(RecyclerView.v vVar, int i10, int i11) {
        int X = X();
        if (i10 >= 0) {
            int h10 = (this.f3240u.h() - i10) + i11;
            if (this.f3243x) {
                for (int i12 = 0; i12 < X; i12++) {
                    View W = W(i12);
                    if (this.f3240u.g(W) < h10 || this.f3240u.q(W) < h10) {
                        E2(vVar, 0, i12);
                        return;
                    }
                }
                return;
            }
            int i13 = X - 1;
            for (int i14 = i13; i14 >= 0; i14--) {
                View W2 = W(i14);
                if (this.f3240u.g(W2) < h10 || this.f3240u.q(W2) < h10) {
                    E2(vVar, i13, i14);
                    return;
                }
            }
        }
    }

    private void G2(RecyclerView.v vVar, int i10, int i11) {
        if (i10 >= 0) {
            int i12 = i10 - i11;
            int X = X();
            if (this.f3243x) {
                int i13 = X - 1;
                for (int i14 = i13; i14 >= 0; i14--) {
                    View W = W(i14);
                    if (this.f3240u.d(W) > i12 || this.f3240u.p(W) > i12) {
                        E2(vVar, i13, i14);
                        return;
                    }
                }
                return;
            }
            for (int i15 = 0; i15 < X; i15++) {
                View W2 = W(i15);
                if (this.f3240u.d(W2) > i12 || this.f3240u.p(W2) > i12) {
                    E2(vVar, 0, i15);
                    return;
                }
            }
        }
    }

    private void I2() {
        this.f3243x = (this.f3238s == 1 || !y2()) ? this.f3242w : !this.f3242w;
    }

    private boolean O2(RecyclerView.v vVar, RecyclerView.z zVar, a aVar) {
        View r22;
        boolean z10 = false;
        if (X() == 0) {
            return false;
        }
        View j02 = j0();
        if (j02 == null || !aVar.d(j02, zVar)) {
            boolean z11 = this.f3241v;
            boolean z12 = this.f3244y;
            if (z11 != z12 || (r22 = r2(vVar, zVar, aVar.f3252d, z12)) == null) {
                return false;
            }
            aVar.b(r22, r0(r22));
            if (!zVar.f() && X1()) {
                int g10 = this.f3240u.g(r22);
                int d10 = this.f3240u.d(r22);
                int m10 = this.f3240u.m();
                int i10 = this.f3240u.i();
                boolean z13 = d10 <= m10 && g10 < m10;
                if (g10 >= i10 && d10 > i10) {
                    z10 = true;
                }
                if (z13 || z10) {
                    if (aVar.f3252d) {
                        m10 = i10;
                    }
                    aVar.f3251c = m10;
                }
            }
            return true;
        }
        aVar.c(j02, r0(j02));
        return true;
    }

    private boolean P2(RecyclerView.z zVar, a aVar) {
        int i10;
        boolean z10 = false;
        if (!zVar.f() && (i10 = this.A) != -1) {
            if (i10 < 0 || i10 >= zVar.b()) {
                this.A = -1;
                this.B = Integer.MIN_VALUE;
            } else {
                aVar.f3250b = this.A;
                SavedState savedState = this.D;
                if (savedState != null && savedState.a()) {
                    boolean z11 = this.D.f3248c;
                    aVar.f3252d = z11;
                    aVar.f3251c = z11 ? this.f3240u.i() - this.D.f3247b : this.f3240u.m() + this.D.f3247b;
                    return true;
                } else if (this.B == Integer.MIN_VALUE) {
                    View Q = Q(this.A);
                    if (Q == null) {
                        if (X() > 0) {
                            if ((this.A < r0(W(0))) == this.f3243x) {
                                z10 = true;
                            }
                            aVar.f3252d = z10;
                        }
                        aVar.a();
                    } else if (this.f3240u.e(Q) > this.f3240u.n()) {
                        aVar.a();
                        return true;
                    } else if (this.f3240u.g(Q) - this.f3240u.m() < 0) {
                        aVar.f3251c = this.f3240u.m();
                        aVar.f3252d = false;
                        return true;
                    } else if (this.f3240u.i() - this.f3240u.d(Q) < 0) {
                        aVar.f3251c = this.f3240u.i();
                        aVar.f3252d = true;
                        return true;
                    } else {
                        aVar.f3251c = aVar.f3252d ? this.f3240u.d(Q) + this.f3240u.o() : this.f3240u.g(Q);
                    }
                    return true;
                } else {
                    boolean z12 = this.f3243x;
                    aVar.f3252d = z12;
                    aVar.f3251c = z12 ? this.f3240u.i() - this.B : this.f3240u.m() + this.B;
                    return true;
                }
            }
        }
        return false;
    }

    private void Q2(RecyclerView.v vVar, RecyclerView.z zVar, a aVar) {
        if (!P2(zVar, aVar) && !O2(vVar, zVar, aVar)) {
            aVar.a();
            aVar.f3250b = this.f3244y ? zVar.b() - 1 : 0;
        }
    }

    private void R2(int i10, int i11, boolean z10, RecyclerView.z zVar) {
        int i12;
        this.f3239t.f3270m = H2();
        this.f3239t.f3263f = i10;
        int[] iArr = this.H;
        boolean z11 = false;
        iArr[0] = 0;
        int i13 = 1;
        iArr[1] = 0;
        Y1(zVar, iArr);
        int max = Math.max(0, this.H[0]);
        int max2 = Math.max(0, this.H[1]);
        if (i10 == 1) {
            z11 = true;
        }
        c cVar = this.f3239t;
        int i14 = z11 ? max2 : max;
        cVar.f3265h = i14;
        if (!z11) {
            max = max2;
        }
        cVar.f3266i = max;
        if (z11) {
            cVar.f3265h = i14 + this.f3240u.j();
            View u22 = u2();
            c cVar2 = this.f3239t;
            if (this.f3243x) {
                i13 = -1;
            }
            cVar2.f3262e = i13;
            int r02 = r0(u22);
            c cVar3 = this.f3239t;
            cVar2.f3261d = r02 + cVar3.f3262e;
            cVar3.f3259b = this.f3240u.d(u22);
            i12 = this.f3240u.d(u22) - this.f3240u.i();
        } else {
            View v22 = v2();
            this.f3239t.f3265h += this.f3240u.m();
            c cVar4 = this.f3239t;
            if (!this.f3243x) {
                i13 = -1;
            }
            cVar4.f3262e = i13;
            int r03 = r0(v22);
            c cVar5 = this.f3239t;
            cVar4.f3261d = r03 + cVar5.f3262e;
            cVar5.f3259b = this.f3240u.g(v22);
            i12 = (-this.f3240u.g(v22)) + this.f3240u.m();
        }
        c cVar6 = this.f3239t;
        cVar6.f3260c = i11;
        if (z10) {
            cVar6.f3260c = i11 - i12;
        }
        cVar6.f3264g = i12;
    }

    private void S2(int i10, int i11) {
        this.f3239t.f3260c = this.f3240u.i() - i11;
        c cVar = this.f3239t;
        cVar.f3262e = this.f3243x ? -1 : 1;
        cVar.f3261d = i10;
        cVar.f3263f = 1;
        cVar.f3259b = i11;
        cVar.f3264g = Integer.MIN_VALUE;
    }

    private void T2(a aVar) {
        S2(aVar.f3250b, aVar.f3251c);
    }

    private void U2(int i10, int i11) {
        this.f3239t.f3260c = i11 - this.f3240u.m();
        c cVar = this.f3239t;
        cVar.f3261d = i10;
        cVar.f3262e = this.f3243x ? 1 : -1;
        cVar.f3263f = -1;
        cVar.f3259b = i11;
        cVar.f3264g = Integer.MIN_VALUE;
    }

    private void V2(a aVar) {
        U2(aVar.f3250b, aVar.f3251c);
    }

    private int a2(RecyclerView.z zVar) {
        if (X() == 0) {
            return 0;
        }
        f2();
        s sVar = this.f3240u;
        View j22 = j2(!this.f3245z, true);
        return v.a(zVar, sVar, j22, i2(!this.f3245z, true), this, this.f3245z);
    }

    private int b2(RecyclerView.z zVar) {
        if (X() == 0) {
            return 0;
        }
        f2();
        s sVar = this.f3240u;
        View j22 = j2(!this.f3245z, true);
        return v.b(zVar, sVar, j22, i2(!this.f3245z, true), this, this.f3245z, this.f3243x);
    }

    private int c2(RecyclerView.z zVar) {
        if (X() == 0) {
            return 0;
        }
        f2();
        s sVar = this.f3240u;
        View j22 = j2(!this.f3245z, true);
        return v.c(zVar, sVar, j22, i2(!this.f3245z, true), this, this.f3245z);
    }

    private View h2() {
        return n2(0, X());
    }

    private View l2() {
        return n2(X() - 1, -1);
    }

    private View p2() {
        return this.f3243x ? h2() : l2();
    }

    private View q2() {
        return this.f3243x ? l2() : h2();
    }

    private int s2(int i10, RecyclerView.v vVar, RecyclerView.z zVar, boolean z10) {
        int i11;
        int i12 = this.f3240u.i() - i10;
        if (i12 <= 0) {
            return 0;
        }
        int i13 = -J2(-i12, vVar, zVar);
        int i14 = i10 + i13;
        if (!z10 || (i11 = this.f3240u.i() - i14) <= 0) {
            return i13;
        }
        this.f3240u.r(i11);
        return i11 + i13;
    }

    private int t2(int i10, RecyclerView.v vVar, RecyclerView.z zVar, boolean z10) {
        int m10;
        int m11 = i10 - this.f3240u.m();
        if (m11 <= 0) {
            return 0;
        }
        int i11 = -J2(m11, vVar, zVar);
        int i12 = i10 + i11;
        if (!z10 || (m10 = i12 - this.f3240u.m()) <= 0) {
            return i11;
        }
        this.f3240u.r(-m10);
        return i11 - m10;
    }

    private View u2() {
        return W(this.f3243x ? 0 : X() - 1);
    }

    private View v2() {
        return W(this.f3243x ? X() - 1 : 0);
    }

    public void A(int i10, int i11, RecyclerView.z zVar, RecyclerView.p.c cVar) {
        if (this.f3238s != 0) {
            i10 = i11;
        }
        if (X() != 0 && i10 != 0) {
            f2();
            R2(i10 > 0 ? 1 : -1, Math.abs(i10), true, zVar);
            Z1(zVar, this.f3239t, cVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void A2(RecyclerView.v vVar, RecyclerView.z zVar, c cVar, b bVar) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        View d10 = cVar.d(vVar);
        if (d10 == null) {
            bVar.f3255b = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) d10.getLayoutParams();
        if (cVar.f3269l == null) {
            if (this.f3243x == (cVar.f3263f == -1)) {
                o(d10);
            } else {
                p(d10, 0);
            }
        } else {
            if (this.f3243x == (cVar.f3263f == -1)) {
                m(d10);
            } else {
                n(d10, 0);
            }
        }
        L0(d10, 0, 0);
        bVar.f3254a = this.f3240u.e(d10);
        if (this.f3238s == 1) {
            if (y2()) {
                i14 = y0() - getPaddingRight();
                i13 = i14 - this.f3240u.f(d10);
            } else {
                i13 = getPaddingLeft();
                i14 = this.f3240u.f(d10) + i13;
            }
            int i15 = cVar.f3263f;
            int i16 = cVar.f3259b;
            if (i15 == -1) {
                i10 = i16;
                i11 = i14;
                i12 = i16 - bVar.f3254a;
            } else {
                i12 = i16;
                i11 = i14;
                i10 = bVar.f3254a + i16;
            }
        } else {
            int paddingTop = getPaddingTop();
            int f10 = this.f3240u.f(d10) + paddingTop;
            int i17 = cVar.f3263f;
            int i18 = cVar.f3259b;
            if (i17 == -1) {
                i11 = i18;
                i12 = paddingTop;
                i10 = f10;
                i13 = i18 - bVar.f3254a;
            } else {
                i12 = paddingTop;
                i11 = bVar.f3254a + i18;
                i10 = f10;
                i13 = i18;
            }
        }
        K0(d10, i13, i12, i11, i10);
        if (layoutParams.c() || layoutParams.b()) {
            bVar.f3256c = true;
        }
        bVar.f3257d = d10.hasFocusable();
    }

    public void B(int i10, RecyclerView.p.c cVar) {
        boolean z10;
        int i11;
        SavedState savedState = this.D;
        int i12 = -1;
        if (savedState == null || !savedState.a()) {
            I2();
            z10 = this.f3243x;
            i11 = this.A;
            if (i11 == -1) {
                i11 = z10 ? i10 - 1 : 0;
            }
        } else {
            SavedState savedState2 = this.D;
            z10 = savedState2.f3248c;
            i11 = savedState2.f3246a;
        }
        if (!z10) {
            i12 = 1;
        }
        for (int i13 = 0; i13 < this.G && i11 >= 0 && i11 < i10; i13++) {
            cVar.a(i11, 0);
            i11 += i12;
        }
    }

    public int C(RecyclerView.z zVar) {
        return a2(zVar);
    }

    public boolean C0() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public void C2(RecyclerView.v vVar, RecyclerView.z zVar, a aVar, int i10) {
    }

    public int D(RecyclerView.z zVar) {
        return b2(zVar);
    }

    public int E(RecyclerView.z zVar) {
        return c2(zVar);
    }

    public int F(RecyclerView.z zVar) {
        return a2(zVar);
    }

    public int G(RecyclerView.z zVar) {
        return b2(zVar);
    }

    public int H(RecyclerView.z zVar) {
        return c2(zVar);
    }

    /* access modifiers changed from: package-private */
    public boolean H2() {
        return this.f3240u.k() == 0 && this.f3240u.h() == 0;
    }

    public int I1(int i10, RecyclerView.v vVar, RecyclerView.z zVar) {
        if (this.f3238s == 1) {
            return 0;
        }
        return J2(i10, vVar, zVar);
    }

    public void J1(int i10) {
        this.A = i10;
        this.B = Integer.MIN_VALUE;
        SavedState savedState = this.D;
        if (savedState != null) {
            savedState.b();
        }
        F1();
    }

    /* access modifiers changed from: package-private */
    public int J2(int i10, RecyclerView.v vVar, RecyclerView.z zVar) {
        if (X() == 0 || i10 == 0) {
            return 0;
        }
        f2();
        this.f3239t.f3258a = true;
        int i11 = i10 > 0 ? 1 : -1;
        int abs = Math.abs(i10);
        R2(i11, abs, true, zVar);
        c cVar = this.f3239t;
        int g22 = cVar.f3264g + g2(vVar, cVar, zVar, false);
        if (g22 < 0) {
            return 0;
        }
        if (abs > g22) {
            i10 = i11 * g22;
        }
        this.f3240u.r(-i10);
        this.f3239t.f3268k = i10;
        return i10;
    }

    public int K1(int i10, RecyclerView.v vVar, RecyclerView.z zVar) {
        if (this.f3238s == 0) {
            return 0;
        }
        return J2(i10, vVar, zVar);
    }

    public void K2(int i10, int i11) {
        this.A = i10;
        this.B = i11;
        SavedState savedState = this.D;
        if (savedState != null) {
            savedState.b();
        }
        F1();
    }

    public void L2(int i10) {
        if (i10 == 0 || i10 == 1) {
            r((String) null);
            if (i10 != this.f3238s || this.f3240u == null) {
                s b10 = s.b(this, i10);
                this.f3240u = b10;
                this.E.f3249a = b10;
                this.f3238s = i10;
                F1();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i10);
    }

    public void M2(boolean z10) {
        r((String) null);
        if (z10 != this.f3242w) {
            this.f3242w = z10;
            F1();
        }
    }

    public void N2(boolean z10) {
        r((String) null);
        if (this.f3244y != z10) {
            this.f3244y = z10;
            F1();
        }
    }

    public View Q(int i10) {
        int X = X();
        if (X == 0) {
            return null;
        }
        int r02 = i10 - r0(W(0));
        if (r02 >= 0 && r02 < X) {
            View W = W(r02);
            if (r0(W) == i10) {
                return W;
            }
        }
        return super.Q(i10);
    }

    public RecyclerView.LayoutParams R() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    /* access modifiers changed from: package-private */
    public boolean S1() {
        return (l0() == 1073741824 || z0() == 1073741824 || !A0()) ? false : true;
    }

    public void T0(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.T0(recyclerView, vVar);
        if (this.C) {
            w1(vVar);
            vVar.c();
        }
    }

    public View U0(View view, int i10, RecyclerView.v vVar, RecyclerView.z zVar) {
        int d22;
        I2();
        if (X() == 0 || (d22 = d2(i10)) == Integer.MIN_VALUE) {
            return null;
        }
        f2();
        R2(d22, (int) (((float) this.f3240u.n()) * 0.33333334f), false, zVar);
        c cVar = this.f3239t;
        cVar.f3264g = Integer.MIN_VALUE;
        cVar.f3258a = false;
        g2(vVar, cVar, zVar, true);
        View q22 = d22 == -1 ? q2() : p2();
        View v22 = d22 == -1 ? v2() : u2();
        if (!v22.hasFocusable()) {
            return q22;
        }
        if (q22 == null) {
            return null;
        }
        return v22;
    }

    public void U1(RecyclerView recyclerView, RecyclerView.z zVar, int i10) {
        o oVar = new o(recyclerView.getContext());
        oVar.p(i10);
        V1(oVar);
    }

    public void V0(AccessibilityEvent accessibilityEvent) {
        super.V0(accessibilityEvent);
        if (X() > 0) {
            accessibilityEvent.setFromIndex(k2());
            accessibilityEvent.setToIndex(m2());
        }
    }

    public boolean X1() {
        return this.D == null && this.f3241v == this.f3244y;
    }

    /* access modifiers changed from: protected */
    public void Y1(RecyclerView.z zVar, int[] iArr) {
        int i10;
        int w22 = w2(zVar);
        if (this.f3239t.f3263f == -1) {
            i10 = 0;
        } else {
            i10 = w22;
            w22 = 0;
        }
        iArr[0] = w22;
        iArr[1] = i10;
    }

    /* access modifiers changed from: package-private */
    public void Z1(RecyclerView.z zVar, c cVar, RecyclerView.p.c cVar2) {
        int i10 = cVar.f3261d;
        if (i10 >= 0 && i10 < zVar.b()) {
            cVar2.a(i10, Math.max(0, cVar.f3264g));
        }
    }

    public PointF d(int i10) {
        if (X() == 0) {
            return null;
        }
        boolean z10 = false;
        int i11 = 1;
        if (i10 < r0(W(0))) {
            z10 = true;
        }
        if (z10 != this.f3243x) {
            i11 = -1;
        }
        return this.f3238s == 0 ? new PointF((float) i11, 0.0f) : new PointF(0.0f, (float) i11);
    }

    /* access modifiers changed from: package-private */
    public int d2(int i10) {
        if (i10 == 1) {
            return (this.f3238s != 1 && y2()) ? 1 : -1;
        }
        if (i10 == 2) {
            return (this.f3238s != 1 && y2()) ? -1 : 1;
        }
        if (i10 == 17) {
            return this.f3238s == 0 ? -1 : Integer.MIN_VALUE;
        }
        if (i10 == 33) {
            return this.f3238s == 1 ? -1 : Integer.MIN_VALUE;
        }
        if (i10 == 66) {
            return this.f3238s == 0 ? 1 : Integer.MIN_VALUE;
        }
        if (i10 != 130) {
            return Integer.MIN_VALUE;
        }
        return this.f3238s == 1 ? 1 : Integer.MIN_VALUE;
    }

    /* access modifiers changed from: package-private */
    public c e2() {
        return new c();
    }

    /* access modifiers changed from: package-private */
    public void f2() {
        if (this.f3239t == null) {
            this.f3239t = e2();
        }
    }

    /* access modifiers changed from: package-private */
    public int g2(RecyclerView.v vVar, c cVar, RecyclerView.z zVar, boolean z10) {
        int i10 = cVar.f3260c;
        int i11 = cVar.f3264g;
        if (i11 != Integer.MIN_VALUE) {
            if (i10 < 0) {
                cVar.f3264g = i11 + i10;
            }
            D2(vVar, cVar);
        }
        int i12 = cVar.f3260c + cVar.f3265h;
        b bVar = this.F;
        while (true) {
            if ((!cVar.f3270m && i12 <= 0) || !cVar.c(zVar)) {
                break;
            }
            bVar.a();
            A2(vVar, zVar, cVar, bVar);
            if (!bVar.f3255b) {
                cVar.f3259b += bVar.f3254a * cVar.f3263f;
                if (!bVar.f3256c || cVar.f3269l != null || !zVar.f()) {
                    int i13 = cVar.f3260c;
                    int i14 = bVar.f3254a;
                    cVar.f3260c = i13 - i14;
                    i12 -= i14;
                }
                int i15 = cVar.f3264g;
                if (i15 != Integer.MIN_VALUE) {
                    int i16 = i15 + bVar.f3254a;
                    cVar.f3264g = i16;
                    int i17 = cVar.f3260c;
                    if (i17 < 0) {
                        cVar.f3264g = i16 + i17;
                    }
                    D2(vVar, cVar);
                }
                if (z10 && bVar.f3257d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i10 - cVar.f3260c;
    }

    public void i1(RecyclerView.v vVar, RecyclerView.z zVar) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        View Q;
        int i16;
        int i17;
        int i18 = -1;
        if (!(this.D == null && this.A == -1) && zVar.b() == 0) {
            w1(vVar);
            return;
        }
        SavedState savedState = this.D;
        if (savedState != null && savedState.a()) {
            this.A = this.D.f3246a;
        }
        f2();
        this.f3239t.f3258a = false;
        I2();
        View j02 = j0();
        a aVar = this.E;
        if (!aVar.f3253e || this.A != -1 || this.D != null) {
            aVar.e();
            a aVar2 = this.E;
            aVar2.f3252d = this.f3243x ^ this.f3244y;
            Q2(vVar, zVar, aVar2);
            this.E.f3253e = true;
        } else if (j02 != null && (this.f3240u.g(j02) >= this.f3240u.i() || this.f3240u.d(j02) <= this.f3240u.m())) {
            this.E.c(j02, r0(j02));
        }
        c cVar = this.f3239t;
        cVar.f3263f = cVar.f3268k >= 0 ? 1 : -1;
        int[] iArr = this.H;
        iArr[0] = 0;
        iArr[1] = 0;
        Y1(zVar, iArr);
        int max = Math.max(0, this.H[0]) + this.f3240u.m();
        int max2 = Math.max(0, this.H[1]) + this.f3240u.j();
        if (!(!zVar.f() || (i15 = this.A) == -1 || this.B == Integer.MIN_VALUE || (Q = Q(i15)) == null)) {
            if (this.f3243x) {
                i16 = this.f3240u.i() - this.f3240u.d(Q);
                i17 = this.B;
            } else {
                i17 = this.f3240u.g(Q) - this.f3240u.m();
                i16 = this.B;
            }
            int i19 = i16 - i17;
            if (i19 > 0) {
                max += i19;
            } else {
                max2 -= i19;
            }
        }
        a aVar3 = this.E;
        if (!aVar3.f3252d ? !this.f3243x : this.f3243x) {
            i18 = 1;
        }
        C2(vVar, zVar, aVar3, i18);
        I(vVar);
        this.f3239t.f3270m = H2();
        this.f3239t.f3267j = zVar.f();
        this.f3239t.f3266i = 0;
        a aVar4 = this.E;
        if (aVar4.f3252d) {
            V2(aVar4);
            c cVar2 = this.f3239t;
            cVar2.f3265h = max;
            g2(vVar, cVar2, zVar, false);
            c cVar3 = this.f3239t;
            i11 = cVar3.f3259b;
            int i20 = cVar3.f3261d;
            int i21 = cVar3.f3260c;
            if (i21 > 0) {
                max2 += i21;
            }
            T2(this.E);
            c cVar4 = this.f3239t;
            cVar4.f3265h = max2;
            cVar4.f3261d += cVar4.f3262e;
            g2(vVar, cVar4, zVar, false);
            c cVar5 = this.f3239t;
            i10 = cVar5.f3259b;
            int i22 = cVar5.f3260c;
            if (i22 > 0) {
                U2(i20, i11);
                c cVar6 = this.f3239t;
                cVar6.f3265h = i22;
                g2(vVar, cVar6, zVar, false);
                i11 = this.f3239t.f3259b;
            }
        } else {
            T2(aVar4);
            c cVar7 = this.f3239t;
            cVar7.f3265h = max2;
            g2(vVar, cVar7, zVar, false);
            c cVar8 = this.f3239t;
            i10 = cVar8.f3259b;
            int i23 = cVar8.f3261d;
            int i24 = cVar8.f3260c;
            if (i24 > 0) {
                max += i24;
            }
            V2(this.E);
            c cVar9 = this.f3239t;
            cVar9.f3265h = max;
            cVar9.f3261d += cVar9.f3262e;
            g2(vVar, cVar9, zVar, false);
            c cVar10 = this.f3239t;
            i11 = cVar10.f3259b;
            int i25 = cVar10.f3260c;
            if (i25 > 0) {
                S2(i23, i10);
                c cVar11 = this.f3239t;
                cVar11.f3265h = i25;
                g2(vVar, cVar11, zVar, false);
                i10 = this.f3239t.f3259b;
            }
        }
        if (X() > 0) {
            if (this.f3243x ^ this.f3244y) {
                int s22 = s2(i10, vVar, zVar, true);
                i13 = i11 + s22;
                i12 = i10 + s22;
                i14 = t2(i13, vVar, zVar, false);
            } else {
                int t22 = t2(i11, vVar, zVar, true);
                i13 = i11 + t22;
                i12 = i10 + t22;
                i14 = s2(i12, vVar, zVar, false);
            }
            i11 = i13 + i14;
            i10 = i12 + i14;
        }
        B2(vVar, zVar, i11, i10);
        if (!zVar.f()) {
            this.f3240u.s();
        } else {
            this.E.e();
        }
        this.f3241v = this.f3244y;
    }

    /* access modifiers changed from: package-private */
    public View i2(boolean z10, boolean z11) {
        int X;
        int i10;
        if (this.f3243x) {
            X = 0;
            i10 = X();
        } else {
            X = X() - 1;
            i10 = -1;
        }
        return o2(X, i10, z10, z11);
    }

    public void j1(RecyclerView.z zVar) {
        super.j1(zVar);
        this.D = null;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.E.e();
    }

    /* access modifiers changed from: package-private */
    public View j2(boolean z10, boolean z11) {
        int i10;
        int X;
        if (this.f3243x) {
            i10 = X() - 1;
            X = -1;
        } else {
            i10 = 0;
            X = X();
        }
        return o2(i10, X, z10, z11);
    }

    public void k(View view, View view2, int i10, int i11) {
        int i12;
        r("Cannot drop a view during a scroll or layout calculation");
        f2();
        I2();
        int r02 = r0(view);
        int r03 = r0(view2);
        boolean z10 = r02 < r03 ? true : true;
        if (this.f3243x) {
            if (z10) {
                K2(r03, this.f3240u.i() - (this.f3240u.g(view2) + this.f3240u.e(view)));
                return;
            }
            i12 = this.f3240u.i() - this.f3240u.d(view2);
        } else if (z10) {
            i12 = this.f3240u.g(view2);
        } else {
            K2(r03, this.f3240u.d(view2) - this.f3240u.e(view));
            return;
        }
        K2(r03, i12);
    }

    public int k2() {
        View o22 = o2(0, X(), false, true);
        if (o22 == null) {
            return -1;
        }
        return r0(o22);
    }

    public int m2() {
        View o22 = o2(X() - 1, -1, false, true);
        if (o22 == null) {
            return -1;
        }
        return r0(o22);
    }

    public void n1(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.D = savedState;
            if (this.A != -1) {
                savedState.b();
            }
            F1();
        }
    }

    /* access modifiers changed from: package-private */
    public View n2(int i10, int i11) {
        int i12;
        int i13;
        f2();
        if ((i11 > i10 ? 1 : i11 < i10 ? (char) 65535 : 0) == 0) {
            return W(i10);
        }
        if (this.f3240u.g(W(i10)) < this.f3240u.m()) {
            i13 = 16644;
            i12 = 16388;
        } else {
            i13 = 4161;
            i12 = 4097;
        }
        return (this.f3238s == 0 ? this.f3355e : this.f3356f).a(i10, i11, i13, i12);
    }

    public Parcelable o1() {
        if (this.D != null) {
            return new SavedState(this.D);
        }
        SavedState savedState = new SavedState();
        if (X() > 0) {
            f2();
            boolean z10 = this.f3241v ^ this.f3243x;
            savedState.f3248c = z10;
            if (z10) {
                View u22 = u2();
                savedState.f3247b = this.f3240u.i() - this.f3240u.d(u22);
                savedState.f3246a = r0(u22);
            } else {
                View v22 = v2();
                savedState.f3246a = r0(v22);
                savedState.f3247b = this.f3240u.g(v22) - this.f3240u.m();
            }
        } else {
            savedState.b();
        }
        return savedState;
    }

    /* access modifiers changed from: package-private */
    public View o2(int i10, int i11, boolean z10, boolean z11) {
        f2();
        int i12 = 320;
        int i13 = z10 ? 24579 : 320;
        if (!z11) {
            i12 = 0;
        }
        return (this.f3238s == 0 ? this.f3355e : this.f3356f).a(i10, i11, i13, i12);
    }

    public void r(String str) {
        if (this.D == null) {
            super.r(str);
        }
    }

    /* access modifiers changed from: package-private */
    public View r2(RecyclerView.v vVar, RecyclerView.z zVar, boolean z10, boolean z11) {
        int i10;
        int i11;
        f2();
        int X = X();
        int i12 = -1;
        if (z11) {
            i11 = X() - 1;
            i10 = -1;
        } else {
            i12 = X;
            i11 = 0;
            i10 = 1;
        }
        int b10 = zVar.b();
        int m10 = this.f3240u.m();
        int i13 = this.f3240u.i();
        View view = null;
        View view2 = null;
        View view3 = null;
        while (i11 != i12) {
            View W = W(i11);
            int r02 = r0(W);
            int g10 = this.f3240u.g(W);
            int d10 = this.f3240u.d(W);
            if (r02 >= 0 && r02 < b10) {
                if (!((RecyclerView.LayoutParams) W.getLayoutParams()).c()) {
                    boolean z12 = d10 <= m10 && g10 < m10;
                    boolean z13 = g10 >= i13 && d10 > i13;
                    if (!z12 && !z13) {
                        return W;
                    }
                    if (z10) {
                        if (!z13) {
                            if (view != null) {
                            }
                            view = W;
                        }
                    } else if (!z12) {
                        if (view != null) {
                        }
                        view = W;
                    }
                    view2 = W;
                } else if (view3 == null) {
                    view3 = W;
                }
            }
            i11 += i10;
        }
        return view != null ? view : view2 != null ? view2 : view3;
    }

    public boolean w() {
        return this.f3238s == 0;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public int w2(RecyclerView.z zVar) {
        if (zVar.d()) {
            return this.f3240u.n();
        }
        return 0;
    }

    public boolean x() {
        return this.f3238s == 1;
    }

    public int x2() {
        return this.f3238s;
    }

    /* access modifiers changed from: protected */
    public boolean y2() {
        return n0() == 1;
    }

    public boolean z2() {
        return this.f3245z;
    }
}
