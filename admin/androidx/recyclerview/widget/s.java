package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class s {

    /* renamed from: a  reason: collision with root package name */
    protected final RecyclerView.p f3690a;

    /* renamed from: b  reason: collision with root package name */
    private int f3691b;

    /* renamed from: c  reason: collision with root package name */
    final Rect f3692c;

    class a extends s {
        a(RecyclerView.p pVar) {
            super(pVar, (a) null);
        }

        public int d(View view) {
            return this.f3690a.h0(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).rightMargin;
        }

        public int e(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f3690a.g0(view) + layoutParams.leftMargin + layoutParams.rightMargin;
        }

        public int f(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f3690a.f0(view) + layoutParams.topMargin + layoutParams.bottomMargin;
        }

        public int g(View view) {
            return this.f3690a.e0(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin;
        }

        public int h() {
            return this.f3690a.y0();
        }

        public int i() {
            return this.f3690a.y0() - this.f3690a.getPaddingRight();
        }

        public int j() {
            return this.f3690a.getPaddingRight();
        }

        public int k() {
            return this.f3690a.z0();
        }

        public int l() {
            return this.f3690a.l0();
        }

        public int m() {
            return this.f3690a.getPaddingLeft();
        }

        public int n() {
            return (this.f3690a.y0() - this.f3690a.getPaddingLeft()) - this.f3690a.getPaddingRight();
        }

        public int p(View view) {
            this.f3690a.x0(view, true, this.f3692c);
            return this.f3692c.right;
        }

        public int q(View view) {
            this.f3690a.x0(view, true, this.f3692c);
            return this.f3692c.left;
        }

        public void r(int i10) {
            this.f3690a.N0(i10);
        }
    }

    class b extends s {
        b(RecyclerView.p pVar) {
            super(pVar, (a) null);
        }

        public int d(View view) {
            return this.f3690a.c0(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).bottomMargin;
        }

        public int e(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f3690a.f0(view) + layoutParams.topMargin + layoutParams.bottomMargin;
        }

        public int f(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f3690a.g0(view) + layoutParams.leftMargin + layoutParams.rightMargin;
        }

        public int g(View view) {
            return this.f3690a.i0(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
        }

        public int h() {
            return this.f3690a.k0();
        }

        public int i() {
            return this.f3690a.k0() - this.f3690a.getPaddingBottom();
        }

        public int j() {
            return this.f3690a.getPaddingBottom();
        }

        public int k() {
            return this.f3690a.l0();
        }

        public int l() {
            return this.f3690a.z0();
        }

        public int m() {
            return this.f3690a.getPaddingTop();
        }

        public int n() {
            return (this.f3690a.k0() - this.f3690a.getPaddingTop()) - this.f3690a.getPaddingBottom();
        }

        public int p(View view) {
            this.f3690a.x0(view, true, this.f3692c);
            return this.f3692c.bottom;
        }

        public int q(View view) {
            this.f3690a.x0(view, true, this.f3692c);
            return this.f3692c.top;
        }

        public void r(int i10) {
            this.f3690a.O0(i10);
        }
    }

    private s(RecyclerView.p pVar) {
        this.f3691b = Integer.MIN_VALUE;
        this.f3692c = new Rect();
        this.f3690a = pVar;
    }

    /* synthetic */ s(RecyclerView.p pVar, a aVar) {
        this(pVar);
    }

    public static s a(RecyclerView.p pVar) {
        return new a(pVar);
    }

    public static s b(RecyclerView.p pVar, int i10) {
        if (i10 == 0) {
            return a(pVar);
        }
        if (i10 == 1) {
            return c(pVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static s c(RecyclerView.p pVar) {
        return new b(pVar);
    }

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public int o() {
        if (Integer.MIN_VALUE == this.f3691b) {
            return 0;
        }
        return n() - this.f3691b;
    }

    public abstract int p(View view);

    public abstract int q(View view);

    public abstract void r(int i10);

    public void s() {
        this.f3691b = n();
    }
}
