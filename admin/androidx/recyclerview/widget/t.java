package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class t extends x {

    /* renamed from: c  reason: collision with root package name */
    private s f3693c;

    /* renamed from: d  reason: collision with root package name */
    private s f3694d;

    class a extends o {
        a(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public void o(View view, RecyclerView.z zVar, RecyclerView.y.a aVar) {
            t tVar = t.this;
            int[] c10 = tVar.c(tVar.f3700a.getLayoutManager(), view);
            int i10 = c10[0];
            int i11 = c10[1];
            int w10 = w(Math.max(Math.abs(i10), Math.abs(i11)));
            if (w10 > 0) {
                aVar.d(i10, i11, w10, this.f3681j);
            }
        }

        /* access modifiers changed from: protected */
        public float v(DisplayMetrics displayMetrics) {
            return 100.0f / ((float) displayMetrics.densityDpi);
        }

        /* access modifiers changed from: protected */
        public int x(int i10) {
            return Math.min(100, super.x(i10));
        }
    }

    private int k(View view, s sVar) {
        return (sVar.g(view) + (sVar.e(view) / 2)) - (sVar.m() + (sVar.n() / 2));
    }

    private View l(RecyclerView.p pVar, s sVar) {
        int X = pVar.X();
        View view = null;
        if (X == 0) {
            return null;
        }
        int m10 = sVar.m() + (sVar.n() / 2);
        int i10 = Integer.MAX_VALUE;
        for (int i11 = 0; i11 < X; i11++) {
            View W = pVar.W(i11);
            int abs = Math.abs((sVar.g(W) + (sVar.e(W) / 2)) - m10);
            if (abs < i10) {
                view = W;
                i10 = abs;
            }
        }
        return view;
    }

    private s m(RecyclerView.p pVar) {
        s sVar = this.f3694d;
        if (sVar == null || sVar.f3690a != pVar) {
            this.f3694d = s.a(pVar);
        }
        return this.f3694d;
    }

    private s n(RecyclerView.p pVar) {
        if (pVar.x()) {
            return o(pVar);
        }
        if (pVar.w()) {
            return m(pVar);
        }
        return null;
    }

    private s o(RecyclerView.p pVar) {
        s sVar = this.f3693c;
        if (sVar == null || sVar.f3690a != pVar) {
            this.f3693c = s.c(pVar);
        }
        return this.f3693c;
    }

    private boolean p(RecyclerView.p pVar, int i10, int i11) {
        return pVar.w() ? i10 > 0 : i11 > 0;
    }

    private boolean q(RecyclerView.p pVar) {
        PointF d10;
        int m02 = pVar.m0();
        if (!(pVar instanceof RecyclerView.y.b) || (d10 = ((RecyclerView.y.b) pVar).d(m02 - 1)) == null) {
            return false;
        }
        return d10.x < 0.0f || d10.y < 0.0f;
    }

    public int[] c(RecyclerView.p pVar, View view) {
        int[] iArr = new int[2];
        if (pVar.w()) {
            iArr[0] = k(view, m(pVar));
        } else {
            iArr[0] = 0;
        }
        if (pVar.x()) {
            iArr[1] = k(view, o(pVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    /* access modifiers changed from: protected */
    public RecyclerView.y d(RecyclerView.p pVar) {
        if (!(pVar instanceof RecyclerView.y.b)) {
            return null;
        }
        return new a(this.f3700a.getContext());
    }

    public View f(RecyclerView.p pVar) {
        s m10;
        if (pVar.x()) {
            m10 = o(pVar);
        } else if (!pVar.w()) {
            return null;
        } else {
            m10 = m(pVar);
        }
        return l(pVar, m10);
    }

    public int g(RecyclerView.p pVar, int i10, int i11) {
        s n10;
        int m02 = pVar.m0();
        if (m02 == 0 || (n10 = n(pVar)) == null) {
            return -1;
        }
        int i12 = Integer.MIN_VALUE;
        int i13 = Integer.MAX_VALUE;
        int X = pVar.X();
        View view = null;
        View view2 = null;
        for (int i14 = 0; i14 < X; i14++) {
            View W = pVar.W(i14);
            if (W != null) {
                int k10 = k(W, n10);
                if (k10 <= 0 && k10 > i12) {
                    view2 = W;
                    i12 = k10;
                }
                if (k10 >= 0 && k10 < i13) {
                    view = W;
                    i13 = k10;
                }
            }
        }
        boolean p10 = p(pVar, i10, i11);
        if (p10 && view != null) {
            return pVar.r0(view);
        }
        if (!p10 && view2 != null) {
            return pVar.r0(view2);
        }
        if (p10) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int r02 = pVar.r0(view) + (q(pVar) == p10 ? -1 : 1);
        if (r02 < 0 || r02 >= m02) {
            return -1;
        }
        return r02;
    }
}
