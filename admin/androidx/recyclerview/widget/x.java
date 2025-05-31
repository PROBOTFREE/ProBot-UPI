package androidx.recyclerview.widget;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;

public abstract class x extends RecyclerView.r {

    /* renamed from: a  reason: collision with root package name */
    RecyclerView f3700a;

    /* renamed from: b  reason: collision with root package name */
    private final RecyclerView.t f3701b = new a();

    class a extends RecyclerView.t {

        /* renamed from: a  reason: collision with root package name */
        boolean f3702a = false;

        a() {
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
            super.onScrollStateChanged(recyclerView, i10);
            if (i10 == 0 && this.f3702a) {
                this.f3702a = false;
                x.this.j();
            }
        }

        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            if (i10 != 0 || i11 != 0) {
                this.f3702a = true;
            }
        }
    }

    private void e() {
        this.f3700a.b1(this.f3701b);
        this.f3700a.setOnFlingListener((RecyclerView.r) null);
    }

    private void h() {
        if (this.f3700a.getOnFlingListener() == null) {
            this.f3700a.l(this.f3701b);
            this.f3700a.setOnFlingListener(this);
            return;
        }
        throw new IllegalStateException("An instance of OnFlingListener already set.");
    }

    private boolean i(RecyclerView.p pVar, int i10, int i11) {
        RecyclerView.y d10;
        int g10;
        if (!(pVar instanceof RecyclerView.y.b) || (d10 = d(pVar)) == null || (g10 = g(pVar, i10, i11)) == -1) {
            return false;
        }
        d10.p(g10);
        pVar.V1(d10);
        return true;
    }

    public boolean a(int i10, int i11) {
        RecyclerView.p layoutManager = this.f3700a.getLayoutManager();
        if (layoutManager == null || this.f3700a.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f3700a.getMinFlingVelocity();
        return (Math.abs(i11) > minFlingVelocity || Math.abs(i10) > minFlingVelocity) && i(layoutManager, i10, i11);
    }

    public void b(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f3700a;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                e();
            }
            this.f3700a = recyclerView;
            if (recyclerView != null) {
                h();
                new Scroller(this.f3700a.getContext(), new DecelerateInterpolator());
                j();
            }
        }
    }

    public abstract int[] c(RecyclerView.p pVar, View view);

    /* access modifiers changed from: protected */
    public abstract RecyclerView.y d(RecyclerView.p pVar);

    public abstract View f(RecyclerView.p pVar);

    public abstract int g(RecyclerView.p pVar, int i10, int i11);

    /* access modifiers changed from: package-private */
    public void j() {
        RecyclerView.p layoutManager;
        View f10;
        RecyclerView recyclerView = this.f3700a;
        if (recyclerView != null && (layoutManager = recyclerView.getLayoutManager()) != null && (f10 = f(layoutManager)) != null) {
            int[] c10 = c(layoutManager, f10);
            if (c10[0] != 0 || c10[1] != 0) {
                this.f3700a.o1(c10[0], c10[1]);
            }
        }
    }
}
