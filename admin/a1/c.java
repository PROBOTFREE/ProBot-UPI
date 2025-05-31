package a1;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.x;
import com.android.volley.toolbox.k;
import java.util.Arrays;

public class c {

    /* renamed from: x  reason: collision with root package name */
    private static final Interpolator f33x = new a();

    /* renamed from: a  reason: collision with root package name */
    private int f34a;

    /* renamed from: b  reason: collision with root package name */
    private int f35b;

    /* renamed from: c  reason: collision with root package name */
    private int f36c = -1;

    /* renamed from: d  reason: collision with root package name */
    private float[] f37d;

    /* renamed from: e  reason: collision with root package name */
    private float[] f38e;

    /* renamed from: f  reason: collision with root package name */
    private float[] f39f;

    /* renamed from: g  reason: collision with root package name */
    private float[] f40g;

    /* renamed from: h  reason: collision with root package name */
    private int[] f41h;

    /* renamed from: i  reason: collision with root package name */
    private int[] f42i;

    /* renamed from: j  reason: collision with root package name */
    private int[] f43j;

    /* renamed from: k  reason: collision with root package name */
    private int f44k;

    /* renamed from: l  reason: collision with root package name */
    private VelocityTracker f45l;

    /* renamed from: m  reason: collision with root package name */
    private float f46m;

    /* renamed from: n  reason: collision with root package name */
    private float f47n;

    /* renamed from: o  reason: collision with root package name */
    private int f48o;

    /* renamed from: p  reason: collision with root package name */
    private final int f49p;

    /* renamed from: q  reason: collision with root package name */
    private int f50q;

    /* renamed from: r  reason: collision with root package name */
    private OverScroller f51r;

    /* renamed from: s  reason: collision with root package name */
    private final C0002c f52s;

    /* renamed from: t  reason: collision with root package name */
    private View f53t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f54u;

    /* renamed from: v  reason: collision with root package name */
    private final ViewGroup f55v;

    /* renamed from: w  reason: collision with root package name */
    private final Runnable f56w = new b();

    class a implements Interpolator {
        a() {
        }

        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            c.this.L(0);
        }
    }

    /* renamed from: a1.c$c  reason: collision with other inner class name */
    public static abstract class C0002c {
        public abstract int a(View view, int i10, int i11);

        public abstract int b(View view, int i10, int i11);

        public int c(int i10) {
            return i10;
        }

        public int d(View view) {
            return 0;
        }

        public int e(View view) {
            return 0;
        }

        public void f(int i10, int i11) {
        }

        public boolean g(int i10) {
            return false;
        }

        public void h(int i10, int i11) {
        }

        public void i(View view, int i10) {
        }

        public abstract void j(int i10);

        public abstract void k(View view, int i10, int i11, int i12, int i13);

        public abstract void l(View view, float f10, float f11);

        public abstract boolean m(View view, int i10);
    }

    private c(Context context, ViewGroup viewGroup, C0002c cVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (cVar != null) {
            this.f55v = viewGroup;
            this.f52s = cVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int i10 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f49p = i10;
            this.f48o = i10;
            this.f35b = viewConfiguration.getScaledTouchSlop();
            this.f46m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f47n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.f51r = new OverScroller(context, f33x);
        } else {
            throw new IllegalArgumentException("Callback may not be null");
        }
    }

    private boolean E(int i10) {
        if (D(i10)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i10 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    private void H() {
        this.f45l.computeCurrentVelocity(k.DEFAULT_IMAGE_TIMEOUT_MS, this.f46m);
        q(h(this.f45l.getXVelocity(this.f36c), this.f47n, this.f46m), h(this.f45l.getYVelocity(this.f36c), this.f47n, this.f46m));
    }

    private void I(float f10, float f11, int i10) {
        boolean d10 = d(f10, f11, i10, 1);
        if (d(f11, f10, i10, 4)) {
            d10 |= true;
        }
        if (d(f10, f11, i10, 2)) {
            d10 |= true;
        }
        if (d(f11, f10, i10, 8)) {
            d10 |= true;
        }
        if (d10) {
            int[] iArr = this.f42i;
            iArr[i10] = iArr[i10] | d10;
            this.f52s.f(d10 ? 1 : 0, i10);
        }
    }

    private void J(float f10, float f11, int i10) {
        t(i10);
        float[] fArr = this.f37d;
        this.f39f[i10] = f10;
        fArr[i10] = f10;
        float[] fArr2 = this.f38e;
        this.f40g[i10] = f11;
        fArr2[i10] = f11;
        this.f41h[i10] = z((int) f10, (int) f11);
        this.f44k |= 1 << i10;
    }

    private void K(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i10 = 0; i10 < pointerCount; i10++) {
            int pointerId = motionEvent.getPointerId(i10);
            if (E(pointerId)) {
                float x10 = motionEvent.getX(i10);
                float y10 = motionEvent.getY(i10);
                this.f39f[pointerId] = x10;
                this.f40g[pointerId] = y10;
            }
        }
    }

    private boolean d(float f10, float f11, int i10, int i11) {
        float abs = Math.abs(f10);
        float abs2 = Math.abs(f11);
        if ((this.f41h[i10] & i11) != i11 || (this.f50q & i11) == 0 || (this.f43j[i10] & i11) == i11 || (this.f42i[i10] & i11) == i11) {
            return false;
        }
        int i12 = this.f35b;
        if (abs <= ((float) i12) && abs2 <= ((float) i12)) {
            return false;
        }
        if (abs >= abs2 * 0.5f || !this.f52s.g(i11)) {
            return (this.f42i[i10] & i11) == 0 && abs > ((float) this.f35b);
        }
        int[] iArr = this.f43j;
        iArr[i10] = iArr[i10] | i11;
        return false;
    }

    private boolean g(View view, float f10, float f11) {
        if (view == null) {
            return false;
        }
        boolean z10 = this.f52s.d(view) > 0;
        boolean z11 = this.f52s.e(view) > 0;
        if (!z10 || !z11) {
            return z10 ? Math.abs(f10) > ((float) this.f35b) : z11 && Math.abs(f11) > ((float) this.f35b);
        }
        int i10 = this.f35b;
        return (f10 * f10) + (f11 * f11) > ((float) (i10 * i10));
    }

    private float h(float f10, float f11, float f12) {
        float abs = Math.abs(f10);
        if (abs < f11) {
            return 0.0f;
        }
        return abs > f12 ? f10 > 0.0f ? f12 : -f12 : f10;
    }

    private int i(int i10, int i11, int i12) {
        int abs = Math.abs(i10);
        if (abs < i11) {
            return 0;
        }
        return abs > i12 ? i10 > 0 ? i12 : -i12 : i10;
    }

    private void j() {
        float[] fArr = this.f37d;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.f38e, 0.0f);
            Arrays.fill(this.f39f, 0.0f);
            Arrays.fill(this.f40g, 0.0f);
            Arrays.fill(this.f41h, 0);
            Arrays.fill(this.f42i, 0);
            Arrays.fill(this.f43j, 0);
            this.f44k = 0;
        }
    }

    private void k(int i10) {
        if (this.f37d != null && D(i10)) {
            this.f37d[i10] = 0.0f;
            this.f38e[i10] = 0.0f;
            this.f39f[i10] = 0.0f;
            this.f40g[i10] = 0.0f;
            this.f41h[i10] = 0;
            this.f42i[i10] = 0;
            this.f43j[i10] = 0;
            this.f44k = (~(1 << i10)) & this.f44k;
        }
    }

    private int l(int i10, int i11, int i12) {
        if (i10 == 0) {
            return 0;
        }
        int width = this.f55v.getWidth();
        float f10 = (float) (width / 2);
        float r10 = f10 + (r(Math.min(1.0f, ((float) Math.abs(i10)) / ((float) width))) * f10);
        int abs = Math.abs(i11);
        return Math.min(abs > 0 ? Math.round(Math.abs(r10 / ((float) abs)) * 1000.0f) * 4 : (int) (((((float) Math.abs(i10)) / ((float) i12)) + 1.0f) * 256.0f), 600);
    }

    private int m(View view, int i10, int i11, int i12, int i13) {
        float f10;
        float f11;
        float f12;
        float f13;
        int i14 = i(i12, (int) this.f47n, (int) this.f46m);
        int i15 = i(i13, (int) this.f47n, (int) this.f46m);
        int abs = Math.abs(i10);
        int abs2 = Math.abs(i11);
        int abs3 = Math.abs(i14);
        int abs4 = Math.abs(i15);
        int i16 = abs3 + abs4;
        int i17 = abs + abs2;
        if (i14 != 0) {
            f11 = (float) abs3;
            f10 = (float) i16;
        } else {
            f11 = (float) abs;
            f10 = (float) i17;
        }
        float f14 = f11 / f10;
        if (i15 != 0) {
            f13 = (float) abs4;
            f12 = (float) i16;
        } else {
            f13 = (float) abs2;
            f12 = (float) i17;
        }
        float f15 = f13 / f12;
        return (int) ((((float) l(i10, i14, this.f52s.d(view))) * f14) + (((float) l(i11, i15, this.f52s.e(view))) * f15));
    }

    public static c o(ViewGroup viewGroup, float f10, C0002c cVar) {
        c p10 = p(viewGroup, cVar);
        p10.f35b = (int) (((float) p10.f35b) * (1.0f / f10));
        return p10;
    }

    public static c p(ViewGroup viewGroup, C0002c cVar) {
        return new c(viewGroup.getContext(), viewGroup, cVar);
    }

    private void q(float f10, float f11) {
        this.f54u = true;
        this.f52s.l(this.f53t, f10, f11);
        this.f54u = false;
        if (this.f34a == 1) {
            L(0);
        }
    }

    private float r(float f10) {
        return (float) Math.sin((double) ((f10 - 0.5f) * 0.47123894f));
    }

    private void s(int i10, int i11, int i12, int i13) {
        int left = this.f53t.getLeft();
        int top = this.f53t.getTop();
        if (i12 != 0) {
            i10 = this.f52s.a(this.f53t, i10, i12);
            x.a0(this.f53t, i10 - left);
        }
        int i14 = i10;
        if (i13 != 0) {
            i11 = this.f52s.b(this.f53t, i11, i13);
            x.b0(this.f53t, i11 - top);
        }
        int i15 = i11;
        if (i12 != 0 || i13 != 0) {
            this.f52s.k(this.f53t, i14, i15, i14 - left, i15 - top);
        }
    }

    private void t(int i10) {
        float[] fArr = this.f37d;
        if (fArr == null || fArr.length <= i10) {
            int i11 = i10 + 1;
            float[] fArr2 = new float[i11];
            float[] fArr3 = new float[i11];
            float[] fArr4 = new float[i11];
            float[] fArr5 = new float[i11];
            int[] iArr = new int[i11];
            int[] iArr2 = new int[i11];
            int[] iArr3 = new int[i11];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f38e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f39f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f40g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f41h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f42i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f43j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f37d = fArr2;
            this.f38e = fArr3;
            this.f39f = fArr4;
            this.f40g = fArr5;
            this.f41h = iArr;
            this.f42i = iArr2;
            this.f43j = iArr3;
        }
    }

    private boolean v(int i10, int i11, int i12, int i13) {
        int left = this.f53t.getLeft();
        int top = this.f53t.getTop();
        int i14 = i10 - left;
        int i15 = i11 - top;
        if (i14 == 0 && i15 == 0) {
            this.f51r.abortAnimation();
            L(0);
            return false;
        }
        this.f51r.startScroll(left, top, i14, i15, m(this.f53t, i14, i15, i12, i13));
        L(2);
        return true;
    }

    private int z(int i10, int i11) {
        int i12 = i10 < this.f55v.getLeft() + this.f48o ? 1 : 0;
        if (i11 < this.f55v.getTop() + this.f48o) {
            i12 |= 4;
        }
        if (i10 > this.f55v.getRight() - this.f48o) {
            i12 |= 2;
        }
        return i11 > this.f55v.getBottom() - this.f48o ? i12 | 8 : i12;
    }

    public int A() {
        return this.f35b;
    }

    public int B() {
        return this.f34a;
    }

    public boolean C(int i10, int i11) {
        return F(this.f53t, i10, i11);
    }

    public boolean D(int i10) {
        return ((1 << i10) & this.f44k) != 0;
    }

    public boolean F(View view, int i10, int i11) {
        return view != null && i10 >= view.getLeft() && i10 < view.getRight() && i11 >= view.getTop() && i11 < view.getBottom();
    }

    public void G(MotionEvent motionEvent) {
        int i10;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            b();
        }
        if (this.f45l == null) {
            this.f45l = VelocityTracker.obtain();
        }
        this.f45l.addMovement(motionEvent);
        int i11 = 0;
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (this.f34a != 1) {
                        int pointerCount = motionEvent.getPointerCount();
                        while (i11 < pointerCount) {
                            int pointerId = motionEvent.getPointerId(i11);
                            if (E(pointerId)) {
                                float x10 = motionEvent.getX(i11);
                                float y10 = motionEvent.getY(i11);
                                float f10 = x10 - this.f37d[pointerId];
                                float f11 = y10 - this.f38e[pointerId];
                                I(f10, f11, pointerId);
                                if (this.f34a != 1) {
                                    View u10 = u((int) x10, (int) y10);
                                    if (g(u10, f10, f11) && S(u10, pointerId)) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                            i11++;
                        }
                    } else if (E(this.f36c)) {
                        int findPointerIndex = motionEvent.findPointerIndex(this.f36c);
                        float x11 = motionEvent.getX(findPointerIndex);
                        float y11 = motionEvent.getY(findPointerIndex);
                        float[] fArr = this.f39f;
                        int i12 = this.f36c;
                        int i13 = (int) (x11 - fArr[i12]);
                        int i14 = (int) (y11 - this.f40g[i12]);
                        s(this.f53t.getLeft() + i13, this.f53t.getTop() + i14, i13, i14);
                    } else {
                        return;
                    }
                    K(motionEvent);
                    return;
                } else if (actionMasked != 3) {
                    if (actionMasked == 5) {
                        int pointerId2 = motionEvent.getPointerId(actionIndex);
                        float x12 = motionEvent.getX(actionIndex);
                        float y12 = motionEvent.getY(actionIndex);
                        J(x12, y12, pointerId2);
                        if (this.f34a == 0) {
                            S(u((int) x12, (int) y12), pointerId2);
                            int i15 = this.f41h[pointerId2];
                            int i16 = this.f50q;
                            if ((i15 & i16) != 0) {
                                this.f52s.h(i15 & i16, pointerId2);
                                return;
                            }
                            return;
                        } else if (C((int) x12, (int) y12)) {
                            S(this.f53t, pointerId2);
                            return;
                        } else {
                            return;
                        }
                    } else if (actionMasked == 6) {
                        int pointerId3 = motionEvent.getPointerId(actionIndex);
                        if (this.f34a == 1 && pointerId3 == this.f36c) {
                            int pointerCount2 = motionEvent.getPointerCount();
                            while (true) {
                                if (i11 >= pointerCount2) {
                                    i10 = -1;
                                    break;
                                }
                                int pointerId4 = motionEvent.getPointerId(i11);
                                if (pointerId4 != this.f36c) {
                                    View u11 = u((int) motionEvent.getX(i11), (int) motionEvent.getY(i11));
                                    View view = this.f53t;
                                    if (u11 == view && S(view, pointerId4)) {
                                        i10 = this.f36c;
                                        break;
                                    }
                                }
                                i11++;
                            }
                            if (i10 == -1) {
                                H();
                            }
                        }
                        k(pointerId3);
                        return;
                    } else {
                        return;
                    }
                } else if (this.f34a == 1) {
                    q(0.0f, 0.0f);
                }
            } else if (this.f34a == 1) {
                H();
            }
            b();
            return;
        }
        float x13 = motionEvent.getX();
        float y13 = motionEvent.getY();
        int pointerId5 = motionEvent.getPointerId(0);
        View u12 = u((int) x13, (int) y13);
        J(x13, y13, pointerId5);
        S(u12, pointerId5);
        int i17 = this.f41h[pointerId5];
        int i18 = this.f50q;
        if ((i17 & i18) != 0) {
            this.f52s.h(i17 & i18, pointerId5);
        }
    }

    /* access modifiers changed from: package-private */
    public void L(int i10) {
        this.f55v.removeCallbacks(this.f56w);
        if (this.f34a != i10) {
            this.f34a = i10;
            this.f52s.j(i10);
            if (this.f34a == 0) {
                this.f53t = null;
            }
        }
    }

    public void M(int i10) {
        this.f48o = i10;
    }

    public void N(int i10) {
        this.f50q = i10;
    }

    public void O(float f10) {
        this.f47n = f10;
    }

    public boolean P(int i10, int i11) {
        if (this.f54u) {
            return v(i10, i11, (int) this.f45l.getXVelocity(this.f36c), (int) this.f45l.getYVelocity(this.f36c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00dd, code lost:
        if (r12 != r11) goto L_0x00e6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean Q(android.view.MotionEvent r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            int r2 = r17.getActionMasked()
            int r3 = r17.getActionIndex()
            if (r2 != 0) goto L_0x0011
            r16.b()
        L_0x0011:
            android.view.VelocityTracker r4 = r0.f45l
            if (r4 != 0) goto L_0x001b
            android.view.VelocityTracker r4 = android.view.VelocityTracker.obtain()
            r0.f45l = r4
        L_0x001b:
            android.view.VelocityTracker r4 = r0.f45l
            r4.addMovement(r1)
            r4 = 2
            r6 = 1
            if (r2 == 0) goto L_0x0104
            if (r2 == r6) goto L_0x00ff
            if (r2 == r4) goto L_0x0070
            r7 = 3
            if (r2 == r7) goto L_0x00ff
            r7 = 5
            if (r2 == r7) goto L_0x003c
            r4 = 6
            if (r2 == r4) goto L_0x0034
        L_0x0031:
            r5 = 0
            goto L_0x0135
        L_0x0034:
            int r1 = r1.getPointerId(r3)
            r0.k(r1)
            goto L_0x0031
        L_0x003c:
            int r2 = r1.getPointerId(r3)
            float r7 = r1.getX(r3)
            float r1 = r1.getY(r3)
            r0.J(r7, r1, r2)
            int r3 = r0.f34a
            if (r3 != 0) goto L_0x0060
            int[] r1 = r0.f41h
            r1 = r1[r2]
            int r3 = r0.f50q
            r4 = r1 & r3
            if (r4 == 0) goto L_0x0031
            a1.c$c r4 = r0.f52s
            r1 = r1 & r3
            r4.h(r1, r2)
            goto L_0x0031
        L_0x0060:
            if (r3 != r4) goto L_0x0031
            int r3 = (int) r7
            int r1 = (int) r1
            android.view.View r1 = r0.u(r3, r1)
            android.view.View r3 = r0.f53t
            if (r1 != r3) goto L_0x0031
            r0.S(r1, r2)
            goto L_0x0031
        L_0x0070:
            float[] r2 = r0.f37d
            if (r2 == 0) goto L_0x0031
            float[] r2 = r0.f38e
            if (r2 != 0) goto L_0x0079
            goto L_0x0031
        L_0x0079:
            int r2 = r17.getPointerCount()
            r3 = 0
        L_0x007e:
            if (r3 >= r2) goto L_0x00fa
            int r4 = r1.getPointerId(r3)
            boolean r7 = r0.E(r4)
            if (r7 != 0) goto L_0x008c
            goto L_0x00f7
        L_0x008c:
            float r7 = r1.getX(r3)
            float r8 = r1.getY(r3)
            float[] r9 = r0.f37d
            r9 = r9[r4]
            float r9 = r7 - r9
            float[] r10 = r0.f38e
            r10 = r10[r4]
            float r10 = r8 - r10
            int r7 = (int) r7
            int r8 = (int) r8
            android.view.View r7 = r0.u(r7, r8)
            if (r7 == 0) goto L_0x00b0
            boolean r8 = r0.g(r7, r9, r10)
            if (r8 == 0) goto L_0x00b0
            r8 = r6
            goto L_0x00b1
        L_0x00b0:
            r8 = 0
        L_0x00b1:
            if (r8 == 0) goto L_0x00e6
            int r11 = r7.getLeft()
            int r12 = (int) r9
            int r13 = r11 + r12
            a1.c$c r14 = r0.f52s
            int r12 = r14.a(r7, r13, r12)
            int r13 = r7.getTop()
            int r14 = (int) r10
            int r15 = r13 + r14
            a1.c$c r5 = r0.f52s
            int r5 = r5.b(r7, r15, r14)
            a1.c$c r14 = r0.f52s
            int r14 = r14.d(r7)
            a1.c$c r15 = r0.f52s
            int r15 = r15.e(r7)
            if (r14 == 0) goto L_0x00df
            if (r14 <= 0) goto L_0x00e6
            if (r12 != r11) goto L_0x00e6
        L_0x00df:
            if (r15 == 0) goto L_0x00fa
            if (r15 <= 0) goto L_0x00e6
            if (r5 != r13) goto L_0x00e6
            goto L_0x00fa
        L_0x00e6:
            r0.I(r9, r10, r4)
            int r5 = r0.f34a
            if (r5 != r6) goto L_0x00ee
            goto L_0x00fa
        L_0x00ee:
            if (r8 == 0) goto L_0x00f7
            boolean r4 = r0.S(r7, r4)
            if (r4 == 0) goto L_0x00f7
            goto L_0x00fa
        L_0x00f7:
            int r3 = r3 + 1
            goto L_0x007e
        L_0x00fa:
            r16.K(r17)
            goto L_0x0031
        L_0x00ff:
            r16.b()
            goto L_0x0031
        L_0x0104:
            float r2 = r17.getX()
            float r3 = r17.getY()
            r5 = 0
            int r1 = r1.getPointerId(r5)
            r0.J(r2, r3, r1)
            int r2 = (int) r2
            int r3 = (int) r3
            android.view.View r2 = r0.u(r2, r3)
            android.view.View r3 = r0.f53t
            if (r2 != r3) goto L_0x0125
            int r3 = r0.f34a
            if (r3 != r4) goto L_0x0125
            r0.S(r2, r1)
        L_0x0125:
            int[] r2 = r0.f41h
            r2 = r2[r1]
            int r3 = r0.f50q
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0135
            a1.c$c r4 = r0.f52s
            r2 = r2 & r3
            r4.h(r2, r1)
        L_0x0135:
            int r1 = r0.f34a
            if (r1 != r6) goto L_0x013a
            r5 = r6
        L_0x013a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: a1.c.Q(android.view.MotionEvent):boolean");
    }

    public boolean R(View view, int i10, int i11) {
        this.f53t = view;
        this.f36c = -1;
        boolean v10 = v(i10, i11, 0, 0);
        if (!v10 && this.f34a == 0 && this.f53t != null) {
            this.f53t = null;
        }
        return v10;
    }

    /* access modifiers changed from: package-private */
    public boolean S(View view, int i10) {
        if (view == this.f53t && this.f36c == i10) {
            return true;
        }
        if (view == null || !this.f52s.m(view, i10)) {
            return false;
        }
        this.f36c = i10;
        c(view, i10);
        return true;
    }

    public void a() {
        b();
        if (this.f34a == 2) {
            int currX = this.f51r.getCurrX();
            int currY = this.f51r.getCurrY();
            this.f51r.abortAnimation();
            int currX2 = this.f51r.getCurrX();
            int currY2 = this.f51r.getCurrY();
            this.f52s.k(this.f53t, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        L(0);
    }

    public void b() {
        this.f36c = -1;
        j();
        VelocityTracker velocityTracker = this.f45l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f45l = null;
        }
    }

    public void c(View view, int i10) {
        if (view.getParent() == this.f55v) {
            this.f53t = view;
            this.f36c = i10;
            this.f52s.i(view, i10);
            L(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f55v + ")");
    }

    public boolean e(int i10) {
        int length = this.f37d.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (f(i10, i11)) {
                return true;
            }
        }
        return false;
    }

    public boolean f(int i10, int i11) {
        if (!D(i11)) {
            return false;
        }
        boolean z10 = (i10 & 1) == 1;
        boolean z11 = (i10 & 2) == 2;
        float f10 = this.f39f[i11] - this.f37d[i11];
        float f11 = this.f40g[i11] - this.f38e[i11];
        if (!z10 || !z11) {
            return z10 ? Math.abs(f10) > ((float) this.f35b) : z11 && Math.abs(f11) > ((float) this.f35b);
        }
        int i12 = this.f35b;
        return (f10 * f10) + (f11 * f11) > ((float) (i12 * i12));
    }

    public boolean n(boolean z10) {
        if (this.f34a == 2) {
            boolean computeScrollOffset = this.f51r.computeScrollOffset();
            int currX = this.f51r.getCurrX();
            int currY = this.f51r.getCurrY();
            int left = currX - this.f53t.getLeft();
            int top = currY - this.f53t.getTop();
            if (left != 0) {
                x.a0(this.f53t, left);
            }
            if (top != 0) {
                x.b0(this.f53t, top);
            }
            if (!(left == 0 && top == 0)) {
                this.f52s.k(this.f53t, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.f51r.getFinalX() && currY == this.f51r.getFinalY()) {
                this.f51r.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z10) {
                    this.f55v.post(this.f56w);
                } else {
                    L(0);
                }
            }
        }
        return this.f34a == 2;
    }

    public View u(int i10, int i11) {
        for (int childCount = this.f55v.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f55v.getChildAt(this.f52s.c(childCount));
            if (i10 >= childAt.getLeft() && i10 < childAt.getRight() && i11 >= childAt.getTop() && i11 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public View w() {
        return this.f53t;
    }

    public int x() {
        return this.f49p;
    }

    public int y() {
        return this.f48o;
    }
}
