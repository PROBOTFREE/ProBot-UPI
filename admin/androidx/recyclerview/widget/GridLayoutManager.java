package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import x0.c;

public class GridLayoutManager extends LinearLayoutManager {
    boolean I = false;
    int J = -1;
    int[] K;
    View[] L;
    final SparseIntArray M = new SparseIntArray();
    final SparseIntArray N = new SparseIntArray();
    b O = new a();
    final Rect P = new Rect();
    private boolean Q;

    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* renamed from: e  reason: collision with root package name */
        int f3232e = -1;

        /* renamed from: f  reason: collision with root package name */
        int f3233f = 0;

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public int e() {
            return this.f3232e;
        }

        public int f() {
            return this.f3233f;
        }
    }

    public static final class a extends b {
        public int e(int i10, int i11) {
            return i10 % i11;
        }

        public int f(int i10) {
            return 1;
        }
    }

    public static abstract class b {

        /* renamed from: a  reason: collision with root package name */
        final SparseIntArray f3234a = new SparseIntArray();

        /* renamed from: b  reason: collision with root package name */
        final SparseIntArray f3235b = new SparseIntArray();

        /* renamed from: c  reason: collision with root package name */
        private boolean f3236c = false;

        /* renamed from: d  reason: collision with root package name */
        private boolean f3237d = false;

        static int a(SparseIntArray sparseIntArray, int i10) {
            int size = sparseIntArray.size() - 1;
            int i11 = 0;
            while (i11 <= size) {
                int i12 = (i11 + size) >>> 1;
                if (sparseIntArray.keyAt(i12) < i10) {
                    i11 = i12 + 1;
                } else {
                    size = i12 - 1;
                }
            }
            int i13 = i11 - 1;
            if (i13 < 0 || i13 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i13);
        }

        /* access modifiers changed from: package-private */
        public int b(int i10, int i11) {
            if (!this.f3237d) {
                return d(i10, i11);
            }
            int i12 = this.f3235b.get(i10, -1);
            if (i12 != -1) {
                return i12;
            }
            int d10 = d(i10, i11);
            this.f3235b.put(i10, d10);
            return d10;
        }

        /* access modifiers changed from: package-private */
        public int c(int i10, int i11) {
            if (!this.f3236c) {
                return e(i10, i11);
            }
            int i12 = this.f3234a.get(i10, -1);
            if (i12 != -1) {
                return i12;
            }
            int e10 = e(i10, i11);
            this.f3234a.put(i10, e10);
            return e10;
        }

        public int d(int i10, int i11) {
            int i12;
            int i13;
            int i14;
            int a10;
            if (!this.f3237d || (a10 = a(this.f3235b, i10)) == -1) {
                i14 = 0;
                i13 = 0;
                i12 = 0;
            } else {
                i14 = this.f3235b.get(a10);
                i13 = a10 + 1;
                i12 = c(a10, i11) + f(a10);
                if (i12 == i11) {
                    i14++;
                    i12 = 0;
                }
            }
            int f10 = f(i10);
            while (i13 < i10) {
                int f11 = f(i13);
                int i15 = i12 + f11;
                if (i15 == i11) {
                    i14++;
                    i15 = 0;
                } else if (i15 > i11) {
                    i14++;
                    i15 = f11;
                }
                i13++;
            }
            return i12 + f10 > i11 ? i14 + 1 : i14;
        }

        public abstract int e(int i10, int i11);

        public abstract int f(int i10);

        public void g() {
            this.f3235b.clear();
        }

        public void h() {
            this.f3234a.clear();
        }
    }

    public GridLayoutManager(Context context, int i10) {
        super(context);
        n3(i10);
    }

    public GridLayoutManager(Context context, int i10, int i11, boolean z10) {
        super(context, i11, z10);
        n3(i10);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        n3(RecyclerView.p.s0(context, attributeSet, i10, i11).f3372b);
    }

    private void W2(RecyclerView.v vVar, RecyclerView.z zVar, int i10, boolean z10) {
        int i11;
        int i12;
        int i13 = 0;
        int i14 = -1;
        if (z10) {
            i11 = 1;
            i14 = i10;
            i12 = 0;
        } else {
            i12 = i10 - 1;
            i11 = -1;
        }
        while (i12 != i14) {
            View view = this.L[i12];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int j32 = j3(vVar, zVar, r0(view));
            layoutParams.f3233f = j32;
            layoutParams.f3232e = i13;
            i13 += j32;
            i12 += i11;
        }
    }

    private void X2() {
        int X = X();
        for (int i10 = 0; i10 < X; i10++) {
            LayoutParams layoutParams = (LayoutParams) W(i10).getLayoutParams();
            int a10 = layoutParams.a();
            this.M.put(a10, layoutParams.f());
            this.N.put(a10, layoutParams.e());
        }
    }

    private void Y2(int i10) {
        this.K = Z2(this.K, this.J, i10);
    }

    static int[] Z2(int[] iArr, int i10, int i11) {
        int i12;
        if (!(iArr != null && iArr.length == i10 + 1 && iArr[iArr.length - 1] == i11)) {
            iArr = new int[(i10 + 1)];
        }
        int i13 = 0;
        iArr[0] = 0;
        int i14 = i11 / i10;
        int i15 = i11 % i10;
        int i16 = 0;
        for (int i17 = 1; i17 <= i10; i17++) {
            i13 += i15;
            if (i13 <= 0 || i10 - i13 >= i15) {
                i12 = i14;
            } else {
                i12 = i14 + 1;
                i13 -= i10;
            }
            i16 += i12;
            iArr[i17] = i16;
        }
        return iArr;
    }

    private void a3() {
        this.M.clear();
        this.N.clear();
    }

    private int b3(RecyclerView.z zVar) {
        if (!(X() == 0 || zVar.b() == 0)) {
            f2();
            boolean z22 = z2();
            View j22 = j2(!z22, true);
            View i22 = i2(!z22, true);
            if (!(j22 == null || i22 == null)) {
                int b10 = this.O.b(r0(j22), this.J);
                int b11 = this.O.b(r0(i22), this.J);
                int min = Math.min(b10, b11);
                int max = this.f3243x ? Math.max(0, ((this.O.b(zVar.b() - 1, this.J) + 1) - Math.max(b10, b11)) - 1) : Math.max(0, min);
                if (!z22) {
                    return max;
                }
                return Math.round((((float) max) * (((float) Math.abs(this.f3240u.d(i22) - this.f3240u.g(j22))) / ((float) ((this.O.b(r0(i22), this.J) - this.O.b(r0(j22), this.J)) + 1)))) + ((float) (this.f3240u.m() - this.f3240u.g(j22))));
            }
        }
        return 0;
    }

    private int c3(RecyclerView.z zVar) {
        if (!(X() == 0 || zVar.b() == 0)) {
            f2();
            View j22 = j2(!z2(), true);
            View i22 = i2(!z2(), true);
            if (!(j22 == null || i22 == null)) {
                if (!z2()) {
                    return this.O.b(zVar.b() - 1, this.J) + 1;
                }
                int d10 = this.f3240u.d(i22) - this.f3240u.g(j22);
                int b10 = this.O.b(r0(j22), this.J);
                return (int) ((((float) d10) / ((float) ((this.O.b(r0(i22), this.J) - b10) + 1))) * ((float) (this.O.b(zVar.b() - 1, this.J) + 1)));
            }
        }
        return 0;
    }

    private void d3(RecyclerView.v vVar, RecyclerView.z zVar, LinearLayoutManager.a aVar, int i10) {
        boolean z10 = i10 == 1;
        int i32 = i3(vVar, zVar, aVar.f3250b);
        if (z10) {
            while (i32 > 0) {
                int i11 = aVar.f3250b;
                if (i11 > 0) {
                    int i12 = i11 - 1;
                    aVar.f3250b = i12;
                    i32 = i3(vVar, zVar, i12);
                } else {
                    return;
                }
            }
            return;
        }
        int b10 = zVar.b() - 1;
        int i13 = aVar.f3250b;
        while (i13 < b10) {
            int i14 = i13 + 1;
            int i33 = i3(vVar, zVar, i14);
            if (i33 <= i32) {
                break;
            }
            i13 = i14;
            i32 = i33;
        }
        aVar.f3250b = i13;
    }

    private void e3() {
        View[] viewArr = this.L;
        if (viewArr == null || viewArr.length != this.J) {
            this.L = new View[this.J];
        }
    }

    private int h3(RecyclerView.v vVar, RecyclerView.z zVar, int i10) {
        if (!zVar.f()) {
            return this.O.b(i10, this.J);
        }
        int f10 = vVar.f(i10);
        if (f10 != -1) {
            return this.O.b(f10, this.J);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i10);
        return 0;
    }

    private int i3(RecyclerView.v vVar, RecyclerView.z zVar, int i10) {
        if (!zVar.f()) {
            return this.O.c(i10, this.J);
        }
        int i11 = this.N.get(i10, -1);
        if (i11 != -1) {
            return i11;
        }
        int f10 = vVar.f(i10);
        if (f10 != -1) {
            return this.O.c(f10, this.J);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i10);
        return 0;
    }

    private int j3(RecyclerView.v vVar, RecyclerView.z zVar, int i10) {
        if (!zVar.f()) {
            return this.O.f(i10);
        }
        int i11 = this.M.get(i10, -1);
        if (i11 != -1) {
            return i11;
        }
        int f10 = vVar.f(i10);
        if (f10 != -1) {
            return this.O.f(f10);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i10);
        return 1;
    }

    private void k3(float f10, int i10) {
        Y2(Math.max(Math.round(f10 * ((float) this.J)), i10));
    }

    private void l3(View view, int i10, boolean z10) {
        int i11;
        int i12;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.f3327b;
        int i13 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
        int i14 = rect.left + rect.right + layoutParams.leftMargin + layoutParams.rightMargin;
        int f32 = f3(layoutParams.f3232e, layoutParams.f3233f);
        if (this.f3238s == 1) {
            i11 = RecyclerView.p.Y(f32, i10, i14, layoutParams.width, false);
            i12 = RecyclerView.p.Y(this.f3240u.n(), l0(), i13, layoutParams.height, true);
        } else {
            int Y = RecyclerView.p.Y(f32, i10, i13, layoutParams.height, false);
            int Y2 = RecyclerView.p.Y(this.f3240u.n(), z0(), i14, layoutParams.width, true);
            i12 = Y;
            i11 = Y2;
        }
        m3(view, i11, i12, z10);
    }

    private void m3(View view, int i10, int i11, boolean z10) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z10 ? T1(view, i10, i11, layoutParams) : R1(view, i10, i11, layoutParams)) {
            view.measure(i10, i11);
        }
    }

    private void o3() {
        int i10;
        int i11;
        if (x2() == 1) {
            i11 = y0() - getPaddingRight();
            i10 = getPaddingLeft();
        } else {
            i11 = k0() - getPaddingBottom();
            i10 = getPaddingTop();
        }
        Y2(i11 - i10);
    }

    /* access modifiers changed from: package-private */
    public void A2(RecyclerView.v vVar, RecyclerView.z zVar, LinearLayoutManager.c cVar, LinearLayoutManager.b bVar) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        View d10;
        RecyclerView.v vVar2 = vVar;
        RecyclerView.z zVar2 = zVar;
        LinearLayoutManager.c cVar2 = cVar;
        LinearLayoutManager.b bVar2 = bVar;
        int l10 = this.f3240u.l();
        boolean z10 = false;
        boolean z11 = l10 != 1073741824;
        int i20 = X() > 0 ? this.K[this.J] : 0;
        if (z11) {
            o3();
        }
        boolean z12 = cVar2.f3262e == 1;
        int i21 = this.J;
        if (!z12) {
            i21 = i3(vVar2, zVar2, cVar2.f3261d) + j3(vVar2, zVar2, cVar2.f3261d);
        }
        int i22 = 0;
        while (i22 < this.J && cVar2.c(zVar2) && i21 > 0) {
            int i23 = cVar2.f3261d;
            int j32 = j3(vVar2, zVar2, i23);
            if (j32 <= this.J) {
                i21 -= j32;
                if (i21 < 0 || (d10 = cVar2.d(vVar2)) == null) {
                    break;
                }
                this.L[i22] = d10;
                i22++;
            } else {
                throw new IllegalArgumentException("Item at position " + i23 + " requires " + j32 + " spans but GridLayoutManager has only " + this.J + " spans.");
            }
        }
        if (i22 == 0) {
            bVar2.f3255b = true;
            return;
        }
        float f10 = 0.0f;
        W2(vVar2, zVar2, i22, z12);
        int i24 = 0;
        int i25 = 0;
        while (i24 < i22) {
            View view = this.L[i24];
            if (cVar2.f3269l == null) {
                if (z12) {
                    o(view);
                } else {
                    p(view, z10);
                }
            } else if (z12) {
                m(view);
            } else {
                n(view, z10 ? 1 : 0);
            }
            v(view, this.P);
            l3(view, l10, z10);
            int e10 = this.f3240u.e(view);
            if (e10 > i25) {
                i25 = e10;
            }
            float f11 = (((float) this.f3240u.f(view)) * 1.0f) / ((float) ((LayoutParams) view.getLayoutParams()).f3233f);
            if (f11 > f10) {
                f10 = f11;
            }
            i24++;
            z10 = false;
        }
        if (z11) {
            k3(f10, i20);
            i25 = 0;
            for (int i26 = 0; i26 < i22; i26++) {
                View view2 = this.L[i26];
                l3(view2, 1073741824, true);
                int e11 = this.f3240u.e(view2);
                if (e11 > i25) {
                    i25 = e11;
                }
            }
        }
        for (int i27 = 0; i27 < i22; i27++) {
            View view3 = this.L[i27];
            if (this.f3240u.e(view3) != i25) {
                LayoutParams layoutParams = (LayoutParams) view3.getLayoutParams();
                Rect rect = layoutParams.f3327b;
                int i28 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
                int i29 = rect.left + rect.right + layoutParams.leftMargin + layoutParams.rightMargin;
                int f32 = f3(layoutParams.f3232e, layoutParams.f3233f);
                if (this.f3238s == 1) {
                    i19 = RecyclerView.p.Y(f32, 1073741824, i29, layoutParams.width, false);
                    i18 = View.MeasureSpec.makeMeasureSpec(i25 - i28, 1073741824);
                } else {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i25 - i29, 1073741824);
                    i18 = RecyclerView.p.Y(f32, 1073741824, i28, layoutParams.height, false);
                    i19 = makeMeasureSpec;
                }
                m3(view3, i19, i18, true);
            }
        }
        int i30 = 0;
        bVar2.f3254a = i25;
        if (this.f3238s == 1) {
            if (cVar2.f3263f == -1) {
                i13 = cVar2.f3259b;
                i10 = i13 - i25;
            } else {
                int i31 = cVar2.f3259b;
                i10 = i31;
                i13 = i25 + i31;
            }
            i12 = 0;
            i11 = 0;
        } else if (cVar2.f3263f == -1) {
            int i32 = cVar2.f3259b;
            i11 = i32 - i25;
            i10 = 0;
            i12 = i32;
            i13 = 0;
        } else {
            int i33 = cVar2.f3259b;
            i12 = i25 + i33;
            i11 = i33;
            i13 = 0;
            i10 = 0;
        }
        while (i30 < i22) {
            View view4 = this.L[i30];
            LayoutParams layoutParams2 = (LayoutParams) view4.getLayoutParams();
            if (this.f3238s == 1) {
                if (y2()) {
                    int paddingLeft = getPaddingLeft() + this.K[this.J - layoutParams2.f3232e];
                    i17 = i13;
                    i16 = paddingLeft;
                    i15 = paddingLeft - this.f3240u.f(view4);
                } else {
                    int paddingLeft2 = getPaddingLeft() + this.K[layoutParams2.f3232e];
                    i17 = i13;
                    i15 = paddingLeft2;
                    i16 = this.f3240u.f(view4) + paddingLeft2;
                }
                i14 = i10;
            } else {
                int paddingTop = getPaddingTop() + this.K[layoutParams2.f3232e];
                i14 = paddingTop;
                i16 = i12;
                i15 = i11;
                i17 = this.f3240u.f(view4) + paddingTop;
            }
            K0(view4, i15, i14, i16, i17);
            if (layoutParams2.c() || layoutParams2.b()) {
                bVar2.f3256c = true;
            }
            bVar2.f3257d |= view4.hasFocusable();
            i30++;
            i13 = i17;
            i12 = i16;
            i11 = i15;
            i10 = i14;
        }
        Arrays.fill(this.L, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public void C2(RecyclerView.v vVar, RecyclerView.z zVar, LinearLayoutManager.a aVar, int i10) {
        super.C2(vVar, zVar, aVar, i10);
        o3();
        if (zVar.b() > 0 && !zVar.f()) {
            d3(vVar, zVar, aVar, i10);
        }
        e3();
    }

    public int D(RecyclerView.z zVar) {
        return this.Q ? b3(zVar) : super.D(zVar);
    }

    public int E(RecyclerView.z zVar) {
        return this.Q ? c3(zVar) : super.E(zVar);
    }

    public int G(RecyclerView.z zVar) {
        return this.Q ? b3(zVar) : super.G(zVar);
    }

    public int H(RecyclerView.z zVar) {
        return this.Q ? c3(zVar) : super.H(zVar);
    }

    public int I1(int i10, RecyclerView.v vVar, RecyclerView.z zVar) {
        o3();
        e3();
        return super.I1(i10, vVar, zVar);
    }

    public int K1(int i10, RecyclerView.v vVar, RecyclerView.z zVar) {
        o3();
        e3();
        return super.K1(i10, vVar, zVar);
    }

    public void N2(boolean z10) {
        if (!z10) {
            super.N2(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    public void O1(Rect rect, int i10, int i11) {
        int i12;
        int i13;
        if (this.K == null) {
            super.O1(rect, i10, i11);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.f3238s == 1) {
            i13 = RecyclerView.p.z(i11, rect.height() + paddingTop, p0());
            int[] iArr = this.K;
            i12 = RecyclerView.p.z(i10, iArr[iArr.length - 1] + paddingLeft, q0());
        } else {
            i12 = RecyclerView.p.z(i10, rect.width() + paddingLeft, q0());
            int[] iArr2 = this.K;
            i13 = RecyclerView.p.z(i11, iArr2[iArr2.length - 1] + paddingTop, p0());
        }
        N1(i12, i13);
    }

    public RecyclerView.LayoutParams R() {
        return this.f3238s == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
    }

    public RecyclerView.LayoutParams S(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public RecyclerView.LayoutParams T(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00d6, code lost:
        if (r13 == (r2 > r15)) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00f6, code lost:
        if (r13 == r11) goto L_0x00b8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0107  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View U0(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.v r26, androidx.recyclerview.widget.RecyclerView.z r27) {
        /*
            r23 = this;
            r0 = r23
            r1 = r26
            r2 = r27
            android.view.View r3 = r23.P(r24)
            r4 = 0
            if (r3 != 0) goto L_0x000e
            return r4
        L_0x000e:
            android.view.ViewGroup$LayoutParams r5 = r3.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$LayoutParams r5 = (androidx.recyclerview.widget.GridLayoutManager.LayoutParams) r5
            int r6 = r5.f3232e
            int r5 = r5.f3233f
            int r5 = r5 + r6
            android.view.View r7 = super.U0(r24, r25, r26, r27)
            if (r7 != 0) goto L_0x0020
            return r4
        L_0x0020:
            r7 = r25
            int r7 = r0.d2(r7)
            r9 = 1
            if (r7 != r9) goto L_0x002b
            r7 = r9
            goto L_0x002c
        L_0x002b:
            r7 = 0
        L_0x002c:
            boolean r10 = r0.f3243x
            if (r7 == r10) goto L_0x0032
            r7 = r9
            goto L_0x0033
        L_0x0032:
            r7 = 0
        L_0x0033:
            r10 = -1
            if (r7 == 0) goto L_0x003e
            int r7 = r23.X()
            int r7 = r7 - r9
            r11 = r10
            r12 = r11
            goto L_0x0045
        L_0x003e:
            int r7 = r23.X()
            r11 = r7
            r12 = r9
            r7 = 0
        L_0x0045:
            int r13 = r0.f3238s
            if (r13 != r9) goto L_0x0051
            boolean r13 = r23.y2()
            if (r13 == 0) goto L_0x0051
            r13 = r9
            goto L_0x0052
        L_0x0051:
            r13 = 0
        L_0x0052:
            int r14 = r0.h3(r1, r2, r7)
            r15 = r10
            r16 = r15
            r8 = 0
            r17 = 0
            r10 = r7
            r7 = r4
        L_0x005e:
            if (r10 == r11) goto L_0x0149
            int r9 = r0.h3(r1, r2, r10)
            android.view.View r1 = r0.W(r10)
            if (r1 != r3) goto L_0x006c
            goto L_0x0149
        L_0x006c:
            boolean r18 = r1.hasFocusable()
            if (r18 == 0) goto L_0x0086
            if (r9 == r14) goto L_0x0086
            if (r4 == 0) goto L_0x0078
            goto L_0x0149
        L_0x0078:
            r18 = r3
            r21 = r7
            r19 = r8
            r20 = r11
            r7 = r16
            r8 = r17
            goto L_0x0135
        L_0x0086:
            android.view.ViewGroup$LayoutParams r9 = r1.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$LayoutParams r9 = (androidx.recyclerview.widget.GridLayoutManager.LayoutParams) r9
            int r2 = r9.f3232e
            r18 = r3
            int r3 = r9.f3233f
            int r3 = r3 + r2
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x009e
            if (r2 != r6) goto L_0x009e
            if (r3 != r5) goto L_0x009e
            return r1
        L_0x009e:
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x00a6
            if (r4 == 0) goto L_0x00ae
        L_0x00a6:
            boolean r19 = r1.hasFocusable()
            if (r19 != 0) goto L_0x00ba
            if (r7 != 0) goto L_0x00ba
        L_0x00ae:
            r21 = r7
        L_0x00b0:
            r19 = r8
            r20 = r11
            r7 = r16
            r8 = r17
        L_0x00b8:
            r11 = 1
            goto L_0x0105
        L_0x00ba:
            int r19 = java.lang.Math.max(r2, r6)
            int r20 = java.lang.Math.min(r3, r5)
            r21 = r7
            int r7 = r20 - r19
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x00d9
            if (r7 <= r8) goto L_0x00cf
        L_0x00ce:
            goto L_0x00b0
        L_0x00cf:
            if (r7 != r8) goto L_0x00fc
            if (r2 <= r15) goto L_0x00d5
            r7 = 1
            goto L_0x00d6
        L_0x00d5:
            r7 = 0
        L_0x00d6:
            if (r13 != r7) goto L_0x00fc
            goto L_0x00ce
        L_0x00d9:
            if (r4 != 0) goto L_0x00fc
            r19 = r8
            r20 = r11
            r8 = 0
            r11 = 1
            boolean r22 = r0.J0(r1, r8, r11)
            if (r22 == 0) goto L_0x0100
            r8 = r17
            if (r7 <= r8) goto L_0x00ee
            r7 = r16
            goto L_0x0105
        L_0x00ee:
            if (r7 != r8) goto L_0x00f9
            r7 = r16
            if (r2 <= r7) goto L_0x00f5
            goto L_0x00f6
        L_0x00f5:
            r11 = 0
        L_0x00f6:
            if (r13 != r11) goto L_0x0104
            goto L_0x00b8
        L_0x00f9:
            r7 = r16
            goto L_0x0104
        L_0x00fc:
            r19 = r8
            r20 = r11
        L_0x0100:
            r7 = r16
            r8 = r17
        L_0x0104:
            r11 = 0
        L_0x0105:
            if (r11 == 0) goto L_0x0135
            boolean r11 = r1.hasFocusable()
            if (r11 == 0) goto L_0x0123
            int r4 = r9.f3232e
            int r3 = java.lang.Math.min(r3, r5)
            int r2 = java.lang.Math.max(r2, r6)
            int r2 = r3 - r2
            r15 = r4
            r16 = r7
            r17 = r8
            r7 = r21
            r4 = r1
            r8 = r2
            goto L_0x013d
        L_0x0123:
            int r7 = r9.f3232e
            int r3 = java.lang.Math.min(r3, r5)
            int r2 = java.lang.Math.max(r2, r6)
            int r17 = r3 - r2
            r16 = r7
            r8 = r19
            r7 = r1
            goto L_0x013d
        L_0x0135:
            r16 = r7
            r17 = r8
            r8 = r19
            r7 = r21
        L_0x013d:
            int r10 = r10 + r12
            r1 = r26
            r2 = r27
            r3 = r18
            r11 = r20
            r9 = 1
            goto L_0x005e
        L_0x0149:
            r21 = r7
            if (r4 == 0) goto L_0x014e
            goto L_0x0150
        L_0x014e:
            r4 = r21
        L_0x0150:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.U0(android.view.View, int, androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$z):android.view.View");
    }

    public boolean X1() {
        return this.D == null && !this.I;
    }

    /* access modifiers changed from: package-private */
    public void Z1(RecyclerView.z zVar, LinearLayoutManager.c cVar, RecyclerView.p.c cVar2) {
        int i10 = this.J;
        for (int i11 = 0; i11 < this.J && cVar.c(zVar) && i10 > 0; i11++) {
            int i12 = cVar.f3261d;
            cVar2.a(i12, Math.max(0, cVar.f3264g));
            i10 -= this.O.f(i12);
            cVar.f3261d += cVar.f3262e;
        }
    }

    public void a1(RecyclerView.v vVar, RecyclerView.z zVar, View view, c cVar) {
        boolean z10;
        boolean z11;
        int i10;
        int i11;
        int i12;
        int i13;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.Z0(view, cVar);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int h32 = h3(vVar, zVar, layoutParams2.a());
        if (this.f3238s == 0) {
            i13 = layoutParams2.e();
            i12 = layoutParams2.f();
            i10 = 1;
            z11 = false;
            z10 = false;
            i11 = h32;
        } else {
            i12 = 1;
            i11 = layoutParams2.e();
            i10 = layoutParams2.f();
            z11 = false;
            z10 = false;
            i13 = h32;
        }
        cVar.f0(c.C0244c.a(i13, i12, i11, i10, z11, z10));
    }

    public int b0(RecyclerView.v vVar, RecyclerView.z zVar) {
        if (this.f3238s == 1) {
            return this.J;
        }
        if (zVar.b() < 1) {
            return 0;
        }
        return h3(vVar, zVar, zVar.b() - 1) + 1;
    }

    public void c1(RecyclerView recyclerView, int i10, int i11) {
        this.O.h();
        this.O.g();
    }

    public void d1(RecyclerView recyclerView) {
        this.O.h();
        this.O.g();
    }

    public void e1(RecyclerView recyclerView, int i10, int i11, int i12) {
        this.O.h();
        this.O.g();
    }

    public void f1(RecyclerView recyclerView, int i10, int i11) {
        this.O.h();
        this.O.g();
    }

    /* access modifiers changed from: package-private */
    public int f3(int i10, int i11) {
        if (this.f3238s != 1 || !y2()) {
            int[] iArr = this.K;
            return iArr[i11 + i10] - iArr[i10];
        }
        int[] iArr2 = this.K;
        int i12 = this.J;
        return iArr2[i12 - i10] - iArr2[(i12 - i10) - i11];
    }

    public int g3() {
        return this.J;
    }

    public void h1(RecyclerView recyclerView, int i10, int i11, Object obj) {
        this.O.h();
        this.O.g();
    }

    public void i1(RecyclerView.v vVar, RecyclerView.z zVar) {
        if (zVar.f()) {
            X2();
        }
        super.i1(vVar, zVar);
        a3();
    }

    public void j1(RecyclerView.z zVar) {
        super.j1(zVar);
        this.I = false;
    }

    public void n3(int i10) {
        if (i10 != this.J) {
            this.I = true;
            if (i10 >= 1) {
                this.J = i10;
                this.O.h();
                F1();
                return;
            }
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i10);
        }
    }

    /* access modifiers changed from: package-private */
    public View r2(RecyclerView.v vVar, RecyclerView.z zVar, boolean z10, boolean z11) {
        int i10;
        int X = X();
        int i11 = -1;
        int i12 = 1;
        if (z11) {
            i10 = X() - 1;
            i12 = -1;
        } else {
            i11 = X;
            i10 = 0;
        }
        int b10 = zVar.b();
        f2();
        int m10 = this.f3240u.m();
        int i13 = this.f3240u.i();
        View view = null;
        View view2 = null;
        while (i10 != i11) {
            View W = W(i10);
            int r02 = r0(W);
            if (r02 >= 0 && r02 < b10 && i3(vVar, zVar, r02) == 0) {
                if (((RecyclerView.LayoutParams) W.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = W;
                    }
                } else if (this.f3240u.g(W) < i13 && this.f3240u.d(W) >= m10) {
                    return W;
                } else {
                    if (view == null) {
                        view = W;
                    }
                }
            }
            i10 += i12;
        }
        return view != null ? view : view2;
    }

    public int u0(RecyclerView.v vVar, RecyclerView.z zVar) {
        if (this.f3238s == 0) {
            return this.J;
        }
        if (zVar.b() < 1) {
            return 0;
        }
        return h3(vVar, zVar, zVar.b() - 1) + 1;
    }

    public boolean y(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }
}
