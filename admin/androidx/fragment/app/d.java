package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.core.view.u;
import androidx.fragment.app.t;
import t0.b;

class d {

    class a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Fragment f2768a;

        a(Fragment fragment) {
            this.f2768a = fragment;
        }

        public void a() {
            if (this.f2768a.getAnimatingAway() != null) {
                View animatingAway = this.f2768a.getAnimatingAway();
                this.f2768a.setAnimatingAway((View) null);
                animatingAway.clearAnimation();
            }
            this.f2768a.setAnimator((Animator) null);
        }
    }

    class b implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f2769a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Fragment f2770b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ t.g f2771c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ t0.b f2772d;

        class a implements Runnable {
            a() {
            }

            public void run() {
                if (b.this.f2770b.getAnimatingAway() != null) {
                    b.this.f2770b.setAnimatingAway((View) null);
                    b bVar = b.this;
                    bVar.f2771c.a(bVar.f2770b, bVar.f2772d);
                }
            }
        }

        b(ViewGroup viewGroup, Fragment fragment, t.g gVar, t0.b bVar) {
            this.f2769a = viewGroup;
            this.f2770b = fragment;
            this.f2771c = gVar;
            this.f2772d = bVar;
        }

        public void onAnimationEnd(Animation animation) {
            this.f2769a.post(new a());
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    class c extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f2774a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f2775b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Fragment f2776c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ t.g f2777d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ t0.b f2778e;

        c(ViewGroup viewGroup, View view, Fragment fragment, t.g gVar, t0.b bVar) {
            this.f2774a = viewGroup;
            this.f2775b = view;
            this.f2776c = fragment;
            this.f2777d = gVar;
            this.f2778e = bVar;
        }

        public void onAnimationEnd(Animator animator) {
            this.f2774a.endViewTransition(this.f2775b);
            Animator animator2 = this.f2776c.getAnimator();
            this.f2776c.setAnimator((Animator) null);
            if (animator2 != null && this.f2774a.indexOfChild(this.f2775b) < 0) {
                this.f2777d.a(this.f2776c, this.f2778e);
            }
        }
    }

    /* renamed from: androidx.fragment.app.d$d  reason: collision with other inner class name */
    static class C0027d {

        /* renamed from: a  reason: collision with root package name */
        public final Animation f2779a;

        /* renamed from: b  reason: collision with root package name */
        public final Animator f2780b;

        C0027d(Animator animator) {
            this.f2779a = null;
            this.f2780b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }

        C0027d(Animation animation) {
            this.f2779a = animation;
            this.f2780b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }
    }

    static class e extends AnimationSet implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f2781a;

        /* renamed from: b  reason: collision with root package name */
        private final View f2782b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f2783c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f2784d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f2785e = true;

        e(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f2781a = viewGroup;
            this.f2782b = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        public boolean getTransformation(long j10, Transformation transformation) {
            this.f2785e = true;
            if (this.f2783c) {
                return !this.f2784d;
            }
            if (!super.getTransformation(j10, transformation)) {
                this.f2783c = true;
                u.a(this.f2781a, this);
            }
            return true;
        }

        public boolean getTransformation(long j10, Transformation transformation, float f10) {
            this.f2785e = true;
            if (this.f2783c) {
                return !this.f2784d;
            }
            if (!super.getTransformation(j10, transformation, f10)) {
                this.f2783c = true;
                u.a(this.f2781a, this);
            }
            return true;
        }

        public void run() {
            if (this.f2783c || !this.f2785e) {
                this.f2781a.endViewTransition(this.f2782b);
                this.f2784d = true;
                return;
            }
            this.f2785e = false;
            this.f2781a.post(this);
        }
    }

    static void a(Fragment fragment, C0027d dVar, t.g gVar) {
        View view = fragment.mView;
        ViewGroup viewGroup = fragment.mContainer;
        viewGroup.startViewTransition(view);
        t0.b bVar = new t0.b();
        bVar.c(new a(fragment));
        gVar.b(fragment, bVar);
        if (dVar.f2779a != null) {
            e eVar = new e(dVar.f2779a, viewGroup, view);
            fragment.setAnimatingAway(fragment.mView);
            eVar.setAnimationListener(new b(viewGroup, fragment, gVar, bVar));
            fragment.mView.startAnimation(eVar);
            return;
        }
        Animator animator = dVar.f2780b;
        fragment.setAnimator(animator);
        animator.addListener(new c(viewGroup, view, fragment, gVar, bVar));
        animator.setTarget(fragment.mView);
        animator.start();
    }

    private static int b(Fragment fragment, boolean z10, boolean z11) {
        return z11 ? z10 ? fragment.getPopEnterAnim() : fragment.getPopExitAnim() : z10 ? fragment.getEnterAnim() : fragment.getExitAnim();
    }

    static C0027d c(Context context, Fragment fragment, boolean z10, boolean z11) {
        int nextTransition = fragment.getNextTransition();
        int b10 = b(fragment, z10, z11);
        boolean z12 = false;
        fragment.setAnimations(0, 0, 0, 0);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            int i10 = g1.b.visible_removing_fragment_view_tag;
            if (viewGroup.getTag(i10) != null) {
                fragment.mContainer.setTag(i10, (Object) null);
            }
        }
        ViewGroup viewGroup2 = fragment.mContainer;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        Animation onCreateAnimation = fragment.onCreateAnimation(nextTransition, z10, b10);
        if (onCreateAnimation != null) {
            return new C0027d(onCreateAnimation);
        }
        Animator onCreateAnimator = fragment.onCreateAnimator(nextTransition, z10, b10);
        if (onCreateAnimator != null) {
            return new C0027d(onCreateAnimator);
        }
        if (b10 == 0 && nextTransition != 0) {
            b10 = d(nextTransition, z10);
        }
        if (b10 != 0) {
            boolean equals = "anim".equals(context.getResources().getResourceTypeName(b10));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(context, b10);
                    if (loadAnimation != null) {
                        return new C0027d(loadAnimation);
                    }
                    z12 = true;
                } catch (Resources.NotFoundException e10) {
                    throw e10;
                } catch (RuntimeException unused) {
                }
            }
            if (!z12) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(context, b10);
                    if (loadAnimator != null) {
                        return new C0027d(loadAnimator);
                    }
                } catch (RuntimeException e11) {
                    if (!equals) {
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(context, b10);
                        if (loadAnimation2 != null) {
                            return new C0027d(loadAnimation2);
                        }
                    } else {
                        throw e11;
                    }
                }
            }
        }
        return null;
    }

    private static int d(int i10, boolean z10) {
        if (i10 == 4097) {
            return z10 ? g1.a.fragment_open_enter : g1.a.fragment_open_exit;
        }
        if (i10 == 4099) {
            return z10 ? g1.a.fragment_fade_enter : g1.a.fragment_fade_exit;
        }
        if (i10 != 8194) {
            return -1;
        }
        return z10 ? g1.a.fragment_close_enter : g1.a.fragment_close_exit;
    }
}
