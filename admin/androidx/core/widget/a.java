package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.view.x;

public abstract class a implements View.OnTouchListener {

    /* renamed from: r  reason: collision with root package name */
    private static final int f2449r = ViewConfiguration.getTapTimeout();

    /* renamed from: a  reason: collision with root package name */
    final C0024a f2450a = new C0024a();

    /* renamed from: b  reason: collision with root package name */
    private final Interpolator f2451b = new AccelerateInterpolator();

    /* renamed from: c  reason: collision with root package name */
    final View f2452c;

    /* renamed from: d  reason: collision with root package name */
    private Runnable f2453d;

    /* renamed from: e  reason: collision with root package name */
    private float[] f2454e = {0.0f, 0.0f};

    /* renamed from: f  reason: collision with root package name */
    private float[] f2455f = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: g  reason: collision with root package name */
    private int f2456g;

    /* renamed from: h  reason: collision with root package name */
    private int f2457h;

    /* renamed from: i  reason: collision with root package name */
    private float[] f2458i = {0.0f, 0.0f};

    /* renamed from: j  reason: collision with root package name */
    private float[] f2459j = {0.0f, 0.0f};

    /* renamed from: k  reason: collision with root package name */
    private float[] f2460k = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: l  reason: collision with root package name */
    private boolean f2461l;

    /* renamed from: m  reason: collision with root package name */
    boolean f2462m;

    /* renamed from: n  reason: collision with root package name */
    boolean f2463n;

    /* renamed from: o  reason: collision with root package name */
    boolean f2464o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f2465p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f2466q;

    /* renamed from: androidx.core.widget.a$a  reason: collision with other inner class name */
    private static class C0024a {

        /* renamed from: a  reason: collision with root package name */
        private int f2467a;

        /* renamed from: b  reason: collision with root package name */
        private int f2468b;

        /* renamed from: c  reason: collision with root package name */
        private float f2469c;

        /* renamed from: d  reason: collision with root package name */
        private float f2470d;

        /* renamed from: e  reason: collision with root package name */
        private long f2471e = Long.MIN_VALUE;

        /* renamed from: f  reason: collision with root package name */
        private long f2472f = 0;

        /* renamed from: g  reason: collision with root package name */
        private int f2473g = 0;

        /* renamed from: h  reason: collision with root package name */
        private int f2474h = 0;

        /* renamed from: i  reason: collision with root package name */
        private long f2475i = -1;

        /* renamed from: j  reason: collision with root package name */
        private float f2476j;

        /* renamed from: k  reason: collision with root package name */
        private int f2477k;

        C0024a() {
        }

        private float e(long j10) {
            long j11 = this.f2471e;
            if (j10 < j11) {
                return 0.0f;
            }
            long j12 = this.f2475i;
            if (j12 < 0 || j10 < j12) {
                return a.e(((float) (j10 - j11)) / ((float) this.f2467a), 0.0f, 1.0f) * 0.5f;
            }
            float f10 = this.f2476j;
            return (1.0f - f10) + (f10 * a.e(((float) (j10 - j12)) / ((float) this.f2477k), 0.0f, 1.0f));
        }

        private float g(float f10) {
            return (-4.0f * f10 * f10) + (f10 * 4.0f);
        }

        public void a() {
            if (this.f2472f != 0) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float g10 = g(e(currentAnimationTimeMillis));
                this.f2472f = currentAnimationTimeMillis;
                float f10 = ((float) (currentAnimationTimeMillis - this.f2472f)) * g10;
                this.f2473g = (int) (this.f2469c * f10);
                this.f2474h = (int) (f10 * this.f2470d);
                return;
            }
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }

        public int b() {
            return this.f2473g;
        }

        public int c() {
            return this.f2474h;
        }

        public int d() {
            float f10 = this.f2469c;
            return (int) (f10 / Math.abs(f10));
        }

        public int f() {
            float f10 = this.f2470d;
            return (int) (f10 / Math.abs(f10));
        }

        public boolean h() {
            return this.f2475i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f2475i + ((long) this.f2477k);
        }

        public void i() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f2477k = a.f((int) (currentAnimationTimeMillis - this.f2471e), 0, this.f2468b);
            this.f2476j = e(currentAnimationTimeMillis);
            this.f2475i = currentAnimationTimeMillis;
        }

        public void j(int i10) {
            this.f2468b = i10;
        }

        public void k(int i10) {
            this.f2467a = i10;
        }

        public void l(float f10, float f11) {
            this.f2469c = f10;
            this.f2470d = f11;
        }

        public void m() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f2471e = currentAnimationTimeMillis;
            this.f2475i = -1;
            this.f2472f = currentAnimationTimeMillis;
            this.f2476j = 0.5f;
            this.f2473g = 0;
            this.f2474h = 0;
        }
    }

    private class b implements Runnable {
        b() {
        }

        public void run() {
            a aVar = a.this;
            if (aVar.f2464o) {
                if (aVar.f2462m) {
                    aVar.f2462m = false;
                    aVar.f2450a.m();
                }
                C0024a aVar2 = a.this.f2450a;
                if (aVar2.h() || !a.this.u()) {
                    a.this.f2464o = false;
                    return;
                }
                a aVar3 = a.this;
                if (aVar3.f2463n) {
                    aVar3.f2463n = false;
                    aVar3.c();
                }
                aVar2.a();
                a.this.j(aVar2.b(), aVar2.c());
                x.j0(a.this.f2452c, this);
            }
        }
    }

    public a(View view) {
        this.f2452c = view;
        float f10 = Resources.getSystem().getDisplayMetrics().density;
        float f11 = (float) ((int) ((1575.0f * f10) + 0.5f));
        o(f11, f11);
        float f12 = (float) ((int) ((f10 * 315.0f) + 0.5f));
        p(f12, f12);
        l(1);
        n(Float.MAX_VALUE, Float.MAX_VALUE);
        s(0.2f, 0.2f);
        t(1.0f, 1.0f);
        k(f2449r);
        r(500);
        q(500);
    }

    private float d(int i10, float f10, float f11, float f12) {
        float h10 = h(this.f2454e[i10], f11, this.f2455f[i10], f10);
        int i11 = (h10 > 0.0f ? 1 : (h10 == 0.0f ? 0 : -1));
        if (i11 == 0) {
            return 0.0f;
        }
        float f13 = this.f2458i[i10];
        float f14 = this.f2459j[i10];
        float f15 = this.f2460k[i10];
        float f16 = f13 * f12;
        return i11 > 0 ? e(h10 * f16, f14, f15) : -e((-h10) * f16, f14, f15);
    }

    static float e(float f10, float f11, float f12) {
        return f10 > f12 ? f12 : f10 < f11 ? f11 : f10;
    }

    static int f(int i10, int i11, int i12) {
        return i10 > i12 ? i12 : i10 < i11 ? i11 : i10;
    }

    private float g(float f10, float f11) {
        if (f11 == 0.0f) {
            return 0.0f;
        }
        int i10 = this.f2456g;
        if (i10 == 0 || i10 == 1) {
            if (f10 < f11) {
                return f10 >= 0.0f ? 1.0f - (f10 / f11) : (!this.f2464o || i10 != 1) ? 0.0f : 1.0f;
            }
        } else if (i10 == 2 && f10 < 0.0f) {
            return f10 / (-f11);
        }
    }

    private float h(float f10, float f11, float f12, float f13) {
        float f14;
        float e10 = e(f10 * f11, 0.0f, f12);
        float g10 = g(f11 - f13, e10) - g(f13, e10);
        if (g10 < 0.0f) {
            f14 = -this.f2451b.getInterpolation(-g10);
        } else if (g10 <= 0.0f) {
            return 0.0f;
        } else {
            f14 = this.f2451b.getInterpolation(g10);
        }
        return e(f14, -1.0f, 1.0f);
    }

    private void i() {
        if (this.f2462m) {
            this.f2464o = false;
        } else {
            this.f2450a.i();
        }
    }

    private void v() {
        int i10;
        if (this.f2453d == null) {
            this.f2453d = new b();
        }
        this.f2464o = true;
        this.f2462m = true;
        if (this.f2461l || (i10 = this.f2457h) <= 0) {
            this.f2453d.run();
        } else {
            x.k0(this.f2452c, this.f2453d, (long) i10);
        }
        this.f2461l = true;
    }

    public abstract boolean a(int i10);

    public abstract boolean b(int i10);

    /* access modifiers changed from: package-private */
    public void c() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f2452c.onTouchEvent(obtain);
        obtain.recycle();
    }

    public abstract void j(int i10, int i11);

    public a k(int i10) {
        this.f2457h = i10;
        return this;
    }

    public a l(int i10) {
        this.f2456g = i10;
        return this;
    }

    public a m(boolean z10) {
        if (this.f2465p && !z10) {
            i();
        }
        this.f2465p = z10;
        return this;
    }

    public a n(float f10, float f11) {
        float[] fArr = this.f2455f;
        fArr[0] = f10;
        fArr[1] = f11;
        return this;
    }

    public a o(float f10, float f11) {
        float[] fArr = this.f2460k;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        if (r0 != 3) goto L_0x0058;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.f2465p
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L_0x001a
            if (r0 == r2) goto L_0x0016
            r3 = 2
            if (r0 == r3) goto L_0x001e
            r6 = 3
            if (r0 == r6) goto L_0x0016
            goto L_0x0058
        L_0x0016:
            r5.i()
            goto L_0x0058
        L_0x001a:
            r5.f2463n = r2
            r5.f2461l = r1
        L_0x001e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f2452c
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.d(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f2452c
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.d(r2, r7, r6, r3)
            androidx.core.widget.a$a r7 = r5.f2450a
            r7.l(r0, r6)
            boolean r6 = r5.f2464o
            if (r6 != 0) goto L_0x0058
            boolean r6 = r5.u()
            if (r6 == 0) goto L_0x0058
            r5.v()
        L_0x0058:
            boolean r6 = r5.f2466q
            if (r6 == 0) goto L_0x0061
            boolean r6 = r5.f2464o
            if (r6 == 0) goto L_0x0061
            r1 = r2
        L_0x0061:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public a p(float f10, float f11) {
        float[] fArr = this.f2459j;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
        return this;
    }

    public a q(int i10) {
        this.f2450a.j(i10);
        return this;
    }

    public a r(int i10) {
        this.f2450a.k(i10);
        return this;
    }

    public a s(float f10, float f11) {
        float[] fArr = this.f2454e;
        fArr[0] = f10;
        fArr[1] = f11;
        return this;
    }

    public a t(float f10, float f11) {
        float[] fArr = this.f2458i;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean u() {
        C0024a aVar = this.f2450a;
        int f10 = aVar.f();
        int d10 = aVar.d();
        return (f10 != 0 && b(f10)) || (d10 != 0 && a(d10));
    }
}
