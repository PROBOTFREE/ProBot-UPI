package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;

public class o extends RecyclerView.y {

    /* renamed from: i  reason: collision with root package name */
    protected final LinearInterpolator f3680i = new LinearInterpolator();

    /* renamed from: j  reason: collision with root package name */
    protected final DecelerateInterpolator f3681j = new DecelerateInterpolator();

    /* renamed from: k  reason: collision with root package name */
    protected PointF f3682k;

    /* renamed from: l  reason: collision with root package name */
    private final DisplayMetrics f3683l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f3684m = false;

    /* renamed from: n  reason: collision with root package name */
    private float f3685n;

    /* renamed from: o  reason: collision with root package name */
    protected int f3686o = 0;

    /* renamed from: p  reason: collision with root package name */
    protected int f3687p = 0;

    public o(Context context) {
        this.f3683l = context.getResources().getDisplayMetrics();
    }

    private float A() {
        if (!this.f3684m) {
            this.f3685n = v(this.f3683l);
            this.f3684m = true;
        }
        return this.f3685n;
    }

    private int y(int i10, int i11) {
        int i12 = i10 - i11;
        if (i10 * i12 <= 0) {
            return 0;
        }
        return i12;
    }

    /* access modifiers changed from: protected */
    public int B() {
        PointF pointF = this.f3682k;
        if (pointF != null) {
            float f10 = pointF.y;
            if (f10 != 0.0f) {
                return f10 > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void C(RecyclerView.y.a aVar) {
        PointF a10 = a(f());
        if (a10 == null || (a10.x == 0.0f && a10.y == 0.0f)) {
            aVar.b(f());
            r();
            return;
        }
        i(a10);
        this.f3682k = a10;
        this.f3686o = (int) (a10.x * 10000.0f);
        this.f3687p = (int) (a10.y * 10000.0f);
        aVar.d((int) (((float) this.f3686o) * 1.2f), (int) (((float) this.f3687p) * 1.2f), (int) (((float) x(10000)) * 1.2f), this.f3680i);
    }

    /* access modifiers changed from: protected */
    public void l(int i10, int i11, RecyclerView.z zVar, RecyclerView.y.a aVar) {
        if (c() == 0) {
            r();
            return;
        }
        this.f3686o = y(this.f3686o, i10);
        int y10 = y(this.f3687p, i11);
        this.f3687p = y10;
        if (this.f3686o == 0 && y10 == 0) {
            C(aVar);
        }
    }

    /* access modifiers changed from: protected */
    public void m() {
    }

    /* access modifiers changed from: protected */
    public void n() {
        this.f3687p = 0;
        this.f3686o = 0;
        this.f3682k = null;
    }

    /* access modifiers changed from: protected */
    public void o(View view, RecyclerView.z zVar, RecyclerView.y.a aVar) {
        int t10 = t(view, z());
        int u10 = u(view, B());
        int w10 = w((int) Math.sqrt((double) ((t10 * t10) + (u10 * u10))));
        if (w10 > 0) {
            aVar.d(-t10, -u10, w10, this.f3681j);
        }
    }

    public int s(int i10, int i11, int i12, int i13, int i14) {
        if (i14 == -1) {
            return i12 - i10;
        }
        if (i14 == 0) {
            int i15 = i12 - i10;
            if (i15 > 0) {
                return i15;
            }
            int i16 = i13 - i11;
            if (i16 < 0) {
                return i16;
            }
            return 0;
        } else if (i14 == 1) {
            return i13 - i11;
        } else {
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
    }

    public int t(View view, int i10) {
        RecyclerView.p e10 = e();
        if (e10 == null || !e10.w()) {
            return 0;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return s(e10.e0(view) - layoutParams.leftMargin, e10.h0(view) + layoutParams.rightMargin, e10.getPaddingLeft(), e10.y0() - e10.getPaddingRight(), i10);
    }

    public int u(View view, int i10) {
        RecyclerView.p e10 = e();
        if (e10 == null || !e10.x()) {
            return 0;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return s(e10.i0(view) - layoutParams.topMargin, e10.c0(view) + layoutParams.bottomMargin, e10.getPaddingTop(), e10.k0() - e10.getPaddingBottom(), i10);
    }

    /* access modifiers changed from: protected */
    public float v(DisplayMetrics displayMetrics) {
        return 25.0f / ((float) displayMetrics.densityDpi);
    }

    /* access modifiers changed from: protected */
    public int w(int i10) {
        return (int) Math.ceil(((double) x(i10)) / 0.3356d);
    }

    /* access modifiers changed from: protected */
    public int x(int i10) {
        return (int) Math.ceil((double) (((float) Math.abs(i10)) * A()));
    }

    /* access modifiers changed from: protected */
    public int z() {
        PointF pointF = this.f3682k;
        if (pointF != null) {
            float f10 = pointF.x;
            if (f10 != 0.0f) {
                return f10 > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }
}
