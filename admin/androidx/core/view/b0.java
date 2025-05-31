package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public final class b0 {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<View> f2296a;

    /* renamed from: b  reason: collision with root package name */
    Runnable f2297b = null;

    /* renamed from: c  reason: collision with root package name */
    Runnable f2298c = null;

    /* renamed from: d  reason: collision with root package name */
    int f2299d = -1;

    class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c0 f2300a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f2301b;

        a(b0 b0Var, c0 c0Var, View view) {
            this.f2300a = c0Var;
            this.f2301b = view;
        }

        public void onAnimationCancel(Animator animator) {
            this.f2300a.a(this.f2301b);
        }

        public void onAnimationEnd(Animator animator) {
            this.f2300a.b(this.f2301b);
        }

        public void onAnimationStart(Animator animator) {
            this.f2300a.c(this.f2301b);
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e0 f2302a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f2303b;

        b(b0 b0Var, e0 e0Var, View view) {
            this.f2302a = e0Var;
            this.f2303b = view;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f2302a.a(this.f2303b);
        }
    }

    static class c implements c0 {

        /* renamed from: a  reason: collision with root package name */
        b0 f2304a;

        /* renamed from: b  reason: collision with root package name */
        boolean f2305b;

        c(b0 b0Var) {
            this.f2304a = b0Var;
        }

        public void a(View view) {
            Object tag = view.getTag(2113929216);
            c0 c0Var = tag instanceof c0 ? (c0) tag : null;
            if (c0Var != null) {
                c0Var.a(view);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: androidx.core.view.c0} */
        /* JADX WARNING: Multi-variable type inference failed */
        @android.annotation.SuppressLint({"WrongConstant"})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b(android.view.View r4) {
            /*
                r3 = this;
                androidx.core.view.b0 r0 = r3.f2304a
                int r0 = r0.f2299d
                r1 = -1
                r2 = 0
                if (r0 <= r1) goto L_0x000f
                r4.setLayerType(r0, r2)
                androidx.core.view.b0 r0 = r3.f2304a
                r0.f2299d = r1
            L_0x000f:
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 16
                if (r0 >= r1) goto L_0x0019
                boolean r0 = r3.f2305b
                if (r0 != 0) goto L_0x0039
            L_0x0019:
                androidx.core.view.b0 r0 = r3.f2304a
                java.lang.Runnable r1 = r0.f2298c
                if (r1 == 0) goto L_0x0024
                r0.f2298c = r2
                r1.run()
            L_0x0024:
                r0 = 2113929216(0x7e000000, float:4.2535296E37)
                java.lang.Object r0 = r4.getTag(r0)
                boolean r1 = r0 instanceof androidx.core.view.c0
                if (r1 == 0) goto L_0x0031
                r2 = r0
                androidx.core.view.c0 r2 = (androidx.core.view.c0) r2
            L_0x0031:
                if (r2 == 0) goto L_0x0036
                r2.b(r4)
            L_0x0036:
                r4 = 1
                r3.f2305b = r4
            L_0x0039:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.b0.c.b(android.view.View):void");
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: androidx.core.view.c0} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void c(android.view.View r4) {
            /*
                r3 = this;
                r0 = 0
                r3.f2305b = r0
                androidx.core.view.b0 r0 = r3.f2304a
                int r0 = r0.f2299d
                r1 = 0
                r2 = -1
                if (r0 <= r2) goto L_0x000f
                r0 = 2
                r4.setLayerType(r0, r1)
            L_0x000f:
                androidx.core.view.b0 r0 = r3.f2304a
                java.lang.Runnable r2 = r0.f2297b
                if (r2 == 0) goto L_0x001a
                r0.f2297b = r1
                r2.run()
            L_0x001a:
                r0 = 2113929216(0x7e000000, float:4.2535296E37)
                java.lang.Object r0 = r4.getTag(r0)
                boolean r2 = r0 instanceof androidx.core.view.c0
                if (r2 == 0) goto L_0x0027
                r1 = r0
                androidx.core.view.c0 r1 = (androidx.core.view.c0) r1
            L_0x0027:
                if (r1 == 0) goto L_0x002c
                r1.c(r4)
            L_0x002c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.b0.c.c(android.view.View):void");
        }
    }

    b0(View view) {
        this.f2296a = new WeakReference<>(view);
    }

    private void g(View view, c0 c0Var) {
        if (c0Var != null) {
            view.animate().setListener(new a(this, c0Var, view));
        } else {
            view.animate().setListener((Animator.AnimatorListener) null);
        }
    }

    public b0 a(float f10) {
        View view = (View) this.f2296a.get();
        if (view != null) {
            view.animate().alpha(f10);
        }
        return this;
    }

    public void b() {
        View view = (View) this.f2296a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long c() {
        View view = (View) this.f2296a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0;
    }

    public b0 d(long j10) {
        View view = (View) this.f2296a.get();
        if (view != null) {
            view.animate().setDuration(j10);
        }
        return this;
    }

    public b0 e(Interpolator interpolator) {
        View view = (View) this.f2296a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public b0 f(c0 c0Var) {
        View view = (View) this.f2296a.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT < 16) {
                view.setTag(2113929216, c0Var);
                c0Var = new c(this);
            }
            g(view, c0Var);
        }
        return this;
    }

    public b0 h(long j10) {
        View view = (View) this.f2296a.get();
        if (view != null) {
            view.animate().setStartDelay(j10);
        }
        return this;
    }

    public b0 i(e0 e0Var) {
        View view = (View) this.f2296a.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            b bVar = null;
            if (e0Var != null) {
                bVar = new b(this, e0Var, view);
            }
            view.animate().setUpdateListener(bVar);
        }
        return this;
    }

    public void j() {
        View view = (View) this.f2296a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public b0 k(float f10) {
        View view = (View) this.f2296a.get();
        if (view != null) {
            view.animate().translationY(f10);
        }
        return this;
    }
}
