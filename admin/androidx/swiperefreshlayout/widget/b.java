package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import w0.h;

public class b extends Drawable implements Animatable {

    /* renamed from: g  reason: collision with root package name */
    private static final Interpolator f3923g = new LinearInterpolator();

    /* renamed from: h  reason: collision with root package name */
    private static final Interpolator f3924h = new h1.b();

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f3925i = {-16777216};

    /* renamed from: a  reason: collision with root package name */
    private final c f3926a;

    /* renamed from: b  reason: collision with root package name */
    private float f3927b;

    /* renamed from: c  reason: collision with root package name */
    private Resources f3928c;

    /* renamed from: d  reason: collision with root package name */
    private Animator f3929d;

    /* renamed from: e  reason: collision with root package name */
    float f3930e;

    /* renamed from: f  reason: collision with root package name */
    boolean f3931f;

    class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f3932a;

        a(c cVar) {
            this.f3932a = cVar;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            b.this.n(floatValue, this.f3932a);
            b.this.b(floatValue, this.f3932a, false);
            b.this.invalidateSelf();
        }
    }

    /* renamed from: androidx.swiperefreshlayout.widget.b$b  reason: collision with other inner class name */
    class C0043b implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f3934a;

        C0043b(c cVar) {
            this.f3934a = cVar;
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
            b.this.b(1.0f, this.f3934a, true);
            this.f3934a.A();
            this.f3934a.l();
            b bVar = b.this;
            if (bVar.f3931f) {
                bVar.f3931f = false;
                animator.cancel();
                animator.setDuration(1332);
                animator.start();
                this.f3934a.x(false);
                return;
            }
            bVar.f3930e += 1.0f;
        }

        public void onAnimationStart(Animator animator) {
            b.this.f3930e = 0.0f;
        }
    }

    private static class c {

        /* renamed from: a  reason: collision with root package name */
        final RectF f3936a = new RectF();

        /* renamed from: b  reason: collision with root package name */
        final Paint f3937b;

        /* renamed from: c  reason: collision with root package name */
        final Paint f3938c;

        /* renamed from: d  reason: collision with root package name */
        final Paint f3939d;

        /* renamed from: e  reason: collision with root package name */
        float f3940e;

        /* renamed from: f  reason: collision with root package name */
        float f3941f;

        /* renamed from: g  reason: collision with root package name */
        float f3942g;

        /* renamed from: h  reason: collision with root package name */
        float f3943h;

        /* renamed from: i  reason: collision with root package name */
        int[] f3944i;

        /* renamed from: j  reason: collision with root package name */
        int f3945j;

        /* renamed from: k  reason: collision with root package name */
        float f3946k;

        /* renamed from: l  reason: collision with root package name */
        float f3947l;

        /* renamed from: m  reason: collision with root package name */
        float f3948m;

        /* renamed from: n  reason: collision with root package name */
        boolean f3949n;

        /* renamed from: o  reason: collision with root package name */
        Path f3950o;

        /* renamed from: p  reason: collision with root package name */
        float f3951p;

        /* renamed from: q  reason: collision with root package name */
        float f3952q;

        /* renamed from: r  reason: collision with root package name */
        int f3953r;

        /* renamed from: s  reason: collision with root package name */
        int f3954s;

        /* renamed from: t  reason: collision with root package name */
        int f3955t;

        /* renamed from: u  reason: collision with root package name */
        int f3956u;

        c() {
            Paint paint = new Paint();
            this.f3937b = paint;
            Paint paint2 = new Paint();
            this.f3938c = paint2;
            Paint paint3 = new Paint();
            this.f3939d = paint3;
            this.f3940e = 0.0f;
            this.f3941f = 0.0f;
            this.f3942g = 0.0f;
            this.f3943h = 5.0f;
            this.f3951p = 1.0f;
            this.f3955t = 255;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint3.setColor(0);
        }

        /* access modifiers changed from: package-private */
        public void A() {
            this.f3946k = this.f3940e;
            this.f3947l = this.f3941f;
            this.f3948m = this.f3942g;
        }

        /* access modifiers changed from: package-private */
        public void a(Canvas canvas, Rect rect) {
            RectF rectF = this.f3936a;
            float f10 = this.f3952q;
            float f11 = (this.f3943h / 2.0f) + f10;
            if (f10 <= 0.0f) {
                f11 = (((float) Math.min(rect.width(), rect.height())) / 2.0f) - Math.max((((float) this.f3953r) * this.f3951p) / 2.0f, this.f3943h / 2.0f);
            }
            rectF.set(((float) rect.centerX()) - f11, ((float) rect.centerY()) - f11, ((float) rect.centerX()) + f11, ((float) rect.centerY()) + f11);
            float f12 = this.f3940e;
            float f13 = this.f3942g;
            float f14 = (f12 + f13) * 360.0f;
            float f15 = ((this.f3941f + f13) * 360.0f) - f14;
            this.f3937b.setColor(this.f3956u);
            this.f3937b.setAlpha(this.f3955t);
            float f16 = this.f3943h / 2.0f;
            rectF.inset(f16, f16);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.f3939d);
            float f17 = -f16;
            rectF.inset(f17, f17);
            canvas.drawArc(rectF, f14, f15, false, this.f3937b);
            b(canvas, f14, f15, rectF);
        }

        /* access modifiers changed from: package-private */
        public void b(Canvas canvas, float f10, float f11, RectF rectF) {
            if (this.f3949n) {
                Path path = this.f3950o;
                if (path == null) {
                    Path path2 = new Path();
                    this.f3950o = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                this.f3950o.moveTo(0.0f, 0.0f);
                this.f3950o.lineTo(((float) this.f3953r) * this.f3951p, 0.0f);
                Path path3 = this.f3950o;
                float f12 = this.f3951p;
                path3.lineTo((((float) this.f3953r) * f12) / 2.0f, ((float) this.f3954s) * f12);
                this.f3950o.offset(((Math.min(rectF.width(), rectF.height()) / 2.0f) + rectF.centerX()) - ((((float) this.f3953r) * this.f3951p) / 2.0f), rectF.centerY() + (this.f3943h / 2.0f));
                this.f3950o.close();
                this.f3938c.setColor(this.f3956u);
                this.f3938c.setAlpha(this.f3955t);
                canvas.save();
                canvas.rotate(f10 + f11, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.f3950o, this.f3938c);
                canvas.restore();
            }
        }

        /* access modifiers changed from: package-private */
        public int c() {
            return this.f3955t;
        }

        /* access modifiers changed from: package-private */
        public float d() {
            return this.f3941f;
        }

        /* access modifiers changed from: package-private */
        public int e() {
            return this.f3944i[f()];
        }

        /* access modifiers changed from: package-private */
        public int f() {
            return (this.f3945j + 1) % this.f3944i.length;
        }

        /* access modifiers changed from: package-private */
        public float g() {
            return this.f3940e;
        }

        /* access modifiers changed from: package-private */
        public int h() {
            return this.f3944i[this.f3945j];
        }

        /* access modifiers changed from: package-private */
        public float i() {
            return this.f3947l;
        }

        /* access modifiers changed from: package-private */
        public float j() {
            return this.f3948m;
        }

        /* access modifiers changed from: package-private */
        public float k() {
            return this.f3946k;
        }

        /* access modifiers changed from: package-private */
        public void l() {
            t(f());
        }

        /* access modifiers changed from: package-private */
        public void m() {
            this.f3946k = 0.0f;
            this.f3947l = 0.0f;
            this.f3948m = 0.0f;
            y(0.0f);
            v(0.0f);
            w(0.0f);
        }

        /* access modifiers changed from: package-private */
        public void n(int i10) {
            this.f3955t = i10;
        }

        /* access modifiers changed from: package-private */
        public void o(float f10, float f11) {
            this.f3953r = (int) f10;
            this.f3954s = (int) f11;
        }

        /* access modifiers changed from: package-private */
        public void p(float f10) {
            if (f10 != this.f3951p) {
                this.f3951p = f10;
            }
        }

        /* access modifiers changed from: package-private */
        public void q(float f10) {
            this.f3952q = f10;
        }

        /* access modifiers changed from: package-private */
        public void r(int i10) {
            this.f3956u = i10;
        }

        /* access modifiers changed from: package-private */
        public void s(ColorFilter colorFilter) {
            this.f3937b.setColorFilter(colorFilter);
        }

        /* access modifiers changed from: package-private */
        public void t(int i10) {
            this.f3945j = i10;
            this.f3956u = this.f3944i[i10];
        }

        /* access modifiers changed from: package-private */
        public void u(int[] iArr) {
            this.f3944i = iArr;
            t(0);
        }

        /* access modifiers changed from: package-private */
        public void v(float f10) {
            this.f3941f = f10;
        }

        /* access modifiers changed from: package-private */
        public void w(float f10) {
            this.f3942g = f10;
        }

        /* access modifiers changed from: package-private */
        public void x(boolean z10) {
            if (this.f3949n != z10) {
                this.f3949n = z10;
            }
        }

        /* access modifiers changed from: package-private */
        public void y(float f10) {
            this.f3940e = f10;
        }

        /* access modifiers changed from: package-private */
        public void z(float f10) {
            this.f3943h = f10;
            this.f3937b.setStrokeWidth(f10);
        }
    }

    public b(Context context) {
        this.f3928c = ((Context) h.e(context)).getResources();
        c cVar = new c();
        this.f3926a = cVar;
        cVar.u(f3925i);
        k(2.5f);
        m();
    }

    private void a(float f10, c cVar) {
        n(f10, cVar);
        cVar.y(cVar.k() + (((cVar.i() - 0.01f) - cVar.k()) * f10));
        cVar.v(cVar.i());
        cVar.w(cVar.j() + ((((float) (Math.floor((double) (cVar.j() / 0.8f)) + 1.0d)) - cVar.j()) * f10));
    }

    private int c(float f10, int i10, int i11) {
        int i12 = (i10 >> 24) & 255;
        int i13 = (i10 >> 16) & 255;
        int i14 = (i10 >> 8) & 255;
        int i15 = i10 & 255;
        return ((i12 + ((int) (((float) (((i11 >> 24) & 255) - i12)) * f10))) << 24) | ((i13 + ((int) (((float) (((i11 >> 16) & 255) - i13)) * f10))) << 16) | ((i14 + ((int) (((float) (((i11 >> 8) & 255) - i14)) * f10))) << 8) | (i15 + ((int) (f10 * ((float) ((i11 & 255) - i15)))));
    }

    private void h(float f10) {
        this.f3927b = f10;
    }

    private void i(float f10, float f11, float f12, float f13) {
        c cVar = this.f3926a;
        float f14 = this.f3928c.getDisplayMetrics().density;
        cVar.z(f11 * f14);
        cVar.q(f10 * f14);
        cVar.t(0);
        cVar.o(f12 * f14, f13 * f14);
    }

    private void m() {
        c cVar = this.f3926a;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new a(cVar));
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(f3923g);
        ofFloat.addListener(new C0043b(cVar));
        this.f3929d = ofFloat;
    }

    /* access modifiers changed from: package-private */
    public void b(float f10, c cVar, boolean z10) {
        float f11;
        float f12;
        if (this.f3931f) {
            a(f10, cVar);
        } else if (f10 != 1.0f || z10) {
            float j10 = cVar.j();
            if (f10 < 0.5f) {
                f11 = cVar.k();
                f12 = (f3924h.getInterpolation(f10 / 0.5f) * 0.79f) + 0.01f + f11;
            } else {
                float k10 = cVar.k() + 0.79f;
                float f13 = k10;
                f11 = k10 - (((1.0f - f3924h.getInterpolation((f10 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                f12 = f13;
            }
            cVar.y(f11);
            cVar.v(f12);
            cVar.w(j10 + (0.20999998f * f10));
            h((f10 + this.f3930e) * 216.0f);
        }
    }

    public void d(boolean z10) {
        this.f3926a.x(z10);
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f3927b, bounds.exactCenterX(), bounds.exactCenterY());
        this.f3926a.a(canvas, bounds);
        canvas.restore();
    }

    public void e(float f10) {
        this.f3926a.p(f10);
        invalidateSelf();
    }

    public void f(int... iArr) {
        this.f3926a.u(iArr);
        this.f3926a.t(0);
        invalidateSelf();
    }

    public void g(float f10) {
        this.f3926a.w(f10);
        invalidateSelf();
    }

    public int getAlpha() {
        return this.f3926a.c();
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isRunning() {
        return this.f3929d.isRunning();
    }

    public void j(float f10, float f11) {
        this.f3926a.y(f10);
        this.f3926a.v(f11);
        invalidateSelf();
    }

    public void k(float f10) {
        this.f3926a.z(f10);
        invalidateSelf();
    }

    public void l(int i10) {
        float f10;
        float f11;
        float f12;
        float f13;
        if (i10 == 0) {
            f10 = 11.0f;
            f13 = 3.0f;
            f12 = 12.0f;
            f11 = 6.0f;
        } else {
            f10 = 7.5f;
            f13 = 2.5f;
            f12 = 10.0f;
            f11 = 5.0f;
        }
        i(f10, f13, f12, f11);
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    public void n(float f10, c cVar) {
        cVar.r(f10 > 0.75f ? c((f10 - 0.75f) / 0.25f, cVar.h(), cVar.e()) : cVar.h());
    }

    public void setAlpha(int i10) {
        this.f3926a.n(i10);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f3926a.s(colorFilter);
        invalidateSelf();
    }

    public void start() {
        long j10;
        Animator animator;
        this.f3929d.cancel();
        this.f3926a.A();
        if (this.f3926a.d() != this.f3926a.g()) {
            this.f3931f = true;
            animator = this.f3929d;
            j10 = 666;
        } else {
            this.f3926a.t(0);
            this.f3926a.m();
            animator = this.f3929d;
            j10 = 1332;
        }
        animator.setDuration(j10);
        this.f3929d.start();
    }

    public void stop() {
        this.f3929d.cancel();
        h(0.0f);
        this.f3926a.x(false);
        this.f3926a.t(0);
        this.f3926a.m();
        invalidateSelf();
    }
}
