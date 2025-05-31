package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.core.view.x;
import androidx.recyclerview.widget.RecyclerView;

class i extends RecyclerView.o implements RecyclerView.s {
    private static final int[] D = {16842919};
    private static final int[] E = new int[0];
    int A;
    private final Runnable B;
    private final RecyclerView.t C;

    /* renamed from: a  reason: collision with root package name */
    private final int f3573a;

    /* renamed from: b  reason: collision with root package name */
    private final int f3574b;

    /* renamed from: c  reason: collision with root package name */
    final StateListDrawable f3575c;

    /* renamed from: d  reason: collision with root package name */
    final Drawable f3576d;

    /* renamed from: e  reason: collision with root package name */
    private final int f3577e;

    /* renamed from: f  reason: collision with root package name */
    private final int f3578f;

    /* renamed from: g  reason: collision with root package name */
    private final StateListDrawable f3579g;

    /* renamed from: h  reason: collision with root package name */
    private final Drawable f3580h;

    /* renamed from: i  reason: collision with root package name */
    private final int f3581i;

    /* renamed from: j  reason: collision with root package name */
    private final int f3582j;

    /* renamed from: k  reason: collision with root package name */
    int f3583k;

    /* renamed from: l  reason: collision with root package name */
    int f3584l;

    /* renamed from: m  reason: collision with root package name */
    float f3585m;

    /* renamed from: n  reason: collision with root package name */
    int f3586n;

    /* renamed from: o  reason: collision with root package name */
    int f3587o;

    /* renamed from: p  reason: collision with root package name */
    float f3588p;

    /* renamed from: q  reason: collision with root package name */
    private int f3589q = 0;

    /* renamed from: r  reason: collision with root package name */
    private int f3590r = 0;

    /* renamed from: s  reason: collision with root package name */
    private RecyclerView f3591s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f3592t = false;

    /* renamed from: u  reason: collision with root package name */
    private boolean f3593u = false;

    /* renamed from: v  reason: collision with root package name */
    private int f3594v = 0;

    /* renamed from: w  reason: collision with root package name */
    private int f3595w = 0;

    /* renamed from: x  reason: collision with root package name */
    private final int[] f3596x = new int[2];

    /* renamed from: y  reason: collision with root package name */
    private final int[] f3597y = new int[2];

    /* renamed from: z  reason: collision with root package name */
    final ValueAnimator f3598z;

    class a implements Runnable {
        a() {
        }

        public void run() {
            i.this.s(500);
        }
    }

    class b extends RecyclerView.t {
        b() {
        }

        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            i.this.D(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    }

    private class c extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private boolean f3601a = false;

        c() {
        }

        public void onAnimationCancel(Animator animator) {
            this.f3601a = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.f3601a) {
                this.f3601a = false;
            } else if (((Float) i.this.f3598z.getAnimatedValue()).floatValue() == 0.0f) {
                i iVar = i.this;
                iVar.A = 0;
                iVar.A(0);
            } else {
                i iVar2 = i.this;
                iVar2.A = 2;
                iVar2.x();
            }
        }
    }

    private class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            i.this.f3575c.setAlpha(floatValue);
            i.this.f3576d.setAlpha(floatValue);
            i.this.x();
        }
    }

    i(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i10, int i11, int i12) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f3598z = ofFloat;
        this.A = 0;
        this.B = new a();
        this.C = new b();
        this.f3575c = stateListDrawable;
        this.f3576d = drawable;
        this.f3579g = stateListDrawable2;
        this.f3580h = drawable2;
        this.f3577e = Math.max(i10, stateListDrawable.getIntrinsicWidth());
        this.f3578f = Math.max(i10, drawable.getIntrinsicWidth());
        this.f3581i = Math.max(i10, stateListDrawable2.getIntrinsicWidth());
        this.f3582j = Math.max(i10, drawable2.getIntrinsicWidth());
        this.f3573a = i11;
        this.f3574b = i12;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new c());
        ofFloat.addUpdateListener(new d());
        l(recyclerView);
    }

    private void B() {
        this.f3591s.h(this);
        this.f3591s.k(this);
        this.f3591s.l(this.C);
    }

    private void E(float f10) {
        int[] r10 = r();
        float max = Math.max((float) r10[0], Math.min((float) r10[1], f10));
        if (Math.abs(((float) this.f3584l) - max) >= 2.0f) {
            int z10 = z(this.f3585m, max, r10, this.f3591s.computeVerticalScrollRange(), this.f3591s.computeVerticalScrollOffset(), this.f3590r);
            if (z10 != 0) {
                this.f3591s.scrollBy(0, z10);
            }
            this.f3585m = max;
        }
    }

    private void m() {
        this.f3591s.removeCallbacks(this.B);
    }

    private void n() {
        this.f3591s.Y0(this);
        this.f3591s.a1(this);
        this.f3591s.b1(this.C);
        m();
    }

    private void o(Canvas canvas) {
        int i10 = this.f3590r;
        int i11 = this.f3581i;
        int i12 = i10 - i11;
        int i13 = this.f3587o;
        int i14 = this.f3586n;
        int i15 = i13 - (i14 / 2);
        this.f3579g.setBounds(0, 0, i14, i11);
        this.f3580h.setBounds(0, 0, this.f3589q, this.f3582j);
        canvas.translate(0.0f, (float) i12);
        this.f3580h.draw(canvas);
        canvas.translate((float) i15, 0.0f);
        this.f3579g.draw(canvas);
        canvas.translate((float) (-i15), (float) (-i12));
    }

    private void p(Canvas canvas) {
        int i10 = this.f3589q;
        int i11 = this.f3577e;
        int i12 = i10 - i11;
        int i13 = this.f3584l;
        int i14 = this.f3583k;
        int i15 = i13 - (i14 / 2);
        this.f3575c.setBounds(0, 0, i11, i14);
        this.f3576d.setBounds(0, 0, this.f3578f, this.f3590r);
        if (u()) {
            this.f3576d.draw(canvas);
            canvas.translate((float) this.f3577e, (float) i15);
            canvas.scale(-1.0f, 1.0f);
            this.f3575c.draw(canvas);
            canvas.scale(-1.0f, 1.0f);
            i12 = this.f3577e;
        } else {
            canvas.translate((float) i12, 0.0f);
            this.f3576d.draw(canvas);
            canvas.translate(0.0f, (float) i15);
            this.f3575c.draw(canvas);
        }
        canvas.translate((float) (-i12), (float) (-i15));
    }

    private int[] q() {
        int[] iArr = this.f3597y;
        int i10 = this.f3574b;
        iArr[0] = i10;
        iArr[1] = this.f3589q - i10;
        return iArr;
    }

    private int[] r() {
        int[] iArr = this.f3596x;
        int i10 = this.f3574b;
        iArr[0] = i10;
        iArr[1] = this.f3590r - i10;
        return iArr;
    }

    private void t(float f10) {
        int[] q10 = q();
        float max = Math.max((float) q10[0], Math.min((float) q10[1], f10));
        if (Math.abs(((float) this.f3587o) - max) >= 2.0f) {
            int z10 = z(this.f3588p, max, q10, this.f3591s.computeHorizontalScrollRange(), this.f3591s.computeHorizontalScrollOffset(), this.f3589q);
            if (z10 != 0) {
                this.f3591s.scrollBy(z10, 0);
            }
            this.f3588p = max;
        }
    }

    private boolean u() {
        return x.C(this.f3591s) == 1;
    }

    private void y(int i10) {
        m();
        this.f3591s.postDelayed(this.B, (long) i10);
    }

    private int z(float f10, float f11, int[] iArr, int i10, int i11, int i12) {
        int i13 = iArr[1] - iArr[0];
        if (i13 == 0) {
            return 0;
        }
        int i14 = i10 - i12;
        int i15 = (int) (((f11 - f10) / ((float) i13)) * ((float) i14));
        int i16 = i11 + i15;
        if (i16 >= i14 || i16 < 0) {
            return 0;
        }
        return i15;
    }

    /* access modifiers changed from: package-private */
    public void A(int i10) {
        int i11;
        if (i10 == 2 && this.f3594v != 2) {
            this.f3575c.setState(D);
            m();
        }
        if (i10 == 0) {
            x();
        } else {
            C();
        }
        if (this.f3594v != 2 || i10 == 2) {
            if (i10 == 1) {
                i11 = 1500;
            }
            this.f3594v = i10;
        }
        this.f3575c.setState(E);
        i11 = 1200;
        y(i11);
        this.f3594v = i10;
    }

    public void C() {
        int i10 = this.A;
        if (i10 != 0) {
            if (i10 == 3) {
                this.f3598z.cancel();
            } else {
                return;
            }
        }
        this.A = 1;
        ValueAnimator valueAnimator = this.f3598z;
        valueAnimator.setFloatValues(new float[]{((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f});
        this.f3598z.setDuration(500);
        this.f3598z.setStartDelay(0);
        this.f3598z.start();
    }

    /* access modifiers changed from: package-private */
    public void D(int i10, int i11) {
        int computeVerticalScrollRange = this.f3591s.computeVerticalScrollRange();
        int i12 = this.f3590r;
        this.f3592t = computeVerticalScrollRange - i12 > 0 && i12 >= this.f3573a;
        int computeHorizontalScrollRange = this.f3591s.computeHorizontalScrollRange();
        int i13 = this.f3589q;
        boolean z10 = computeHorizontalScrollRange - i13 > 0 && i13 >= this.f3573a;
        this.f3593u = z10;
        boolean z11 = this.f3592t;
        if (z11 || z10) {
            if (z11) {
                float f10 = (float) i12;
                this.f3584l = (int) ((f10 * (((float) i11) + (f10 / 2.0f))) / ((float) computeVerticalScrollRange));
                this.f3583k = Math.min(i12, (i12 * i12) / computeVerticalScrollRange);
            }
            if (this.f3593u) {
                float f11 = (float) i13;
                this.f3587o = (int) ((f11 * (((float) i10) + (f11 / 2.0f))) / ((float) computeHorizontalScrollRange));
                this.f3586n = Math.min(i13, (i13 * i13) / computeHorizontalScrollRange);
            }
            int i14 = this.f3594v;
            if (i14 == 0 || i14 == 1) {
                A(1);
            }
        } else if (this.f3594v != 0) {
            A(0);
        }
    }

    public boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i10 = this.f3594v;
        if (i10 == 1) {
            boolean w10 = w(motionEvent.getX(), motionEvent.getY());
            boolean v10 = v(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!w10 && !v10) {
                return false;
            }
            if (v10) {
                this.f3595w = 1;
                this.f3588p = (float) ((int) motionEvent.getX());
            } else if (w10) {
                this.f3595w = 2;
                this.f3585m = (float) ((int) motionEvent.getY());
            }
            A(2);
        } else if (i10 != 2) {
            return false;
        }
        return true;
    }

    public void c(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f3594v != 0) {
            if (motionEvent.getAction() == 0) {
                boolean w10 = w(motionEvent.getX(), motionEvent.getY());
                boolean v10 = v(motionEvent.getX(), motionEvent.getY());
                if (w10 || v10) {
                    if (v10) {
                        this.f3595w = 1;
                        this.f3588p = (float) ((int) motionEvent.getX());
                    } else if (w10) {
                        this.f3595w = 2;
                        this.f3585m = (float) ((int) motionEvent.getY());
                    }
                    A(2);
                }
            } else if (motionEvent.getAction() == 1 && this.f3594v == 2) {
                this.f3585m = 0.0f;
                this.f3588p = 0.0f;
                A(1);
                this.f3595w = 0;
            } else if (motionEvent.getAction() == 2 && this.f3594v == 2) {
                C();
                if (this.f3595w == 1) {
                    t(motionEvent.getX());
                }
                if (this.f3595w == 2) {
                    E(motionEvent.getY());
                }
            }
        }
    }

    public void e(boolean z10) {
    }

    public void k(Canvas canvas, RecyclerView recyclerView, RecyclerView.z zVar) {
        if (this.f3589q != this.f3591s.getWidth() || this.f3590r != this.f3591s.getHeight()) {
            this.f3589q = this.f3591s.getWidth();
            this.f3590r = this.f3591s.getHeight();
            A(0);
        } else if (this.A != 0) {
            if (this.f3592t) {
                p(canvas);
            }
            if (this.f3593u) {
                o(canvas);
            }
        }
    }

    public void l(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f3591s;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                n();
            }
            this.f3591s = recyclerView;
            if (recyclerView != null) {
                B();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void s(int i10) {
        int i11 = this.A;
        if (i11 == 1) {
            this.f3598z.cancel();
        } else if (i11 != 2) {
            return;
        }
        this.A = 3;
        ValueAnimator valueAnimator = this.f3598z;
        valueAnimator.setFloatValues(new float[]{((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f});
        this.f3598z.setDuration((long) i10);
        this.f3598z.start();
    }

    /* access modifiers changed from: package-private */
    public boolean v(float f10, float f11) {
        if (f11 >= ((float) (this.f3590r - this.f3581i))) {
            int i10 = this.f3587o;
            int i11 = this.f3586n;
            return f10 >= ((float) (i10 - (i11 / 2))) && f10 <= ((float) (i10 + (i11 / 2)));
        }
    }

    /* access modifiers changed from: package-private */
    public boolean w(float f10, float f11) {
        if (!u() ? f10 >= ((float) (this.f3589q - this.f3577e)) : f10 <= ((float) this.f3577e)) {
            int i10 = this.f3584l;
            int i11 = this.f3583k;
            return f11 >= ((float) (i10 - (i11 / 2))) && f11 <= ((float) (i10 + (i11 / 2)));
        }
    }

    /* access modifiers changed from: package-private */
    public void x() {
        this.f3591s.invalidate();
    }
}
