package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.view.View;
import androidx.transition.Transition;
import x1.b;

class w {

    private static class a extends AnimatorListenerAdapter implements Transition.f {

        /* renamed from: a  reason: collision with root package name */
        private final View f4171a;

        /* renamed from: b  reason: collision with root package name */
        private final View f4172b;

        /* renamed from: c  reason: collision with root package name */
        private final int f4173c;

        /* renamed from: d  reason: collision with root package name */
        private final int f4174d;

        /* renamed from: e  reason: collision with root package name */
        private int[] f4175e;

        /* renamed from: f  reason: collision with root package name */
        private float f4176f;

        /* renamed from: g  reason: collision with root package name */
        private float f4177g;

        /* renamed from: h  reason: collision with root package name */
        private final float f4178h;

        /* renamed from: i  reason: collision with root package name */
        private final float f4179i;

        a(View view, View view2, int i10, int i11, float f10, float f11) {
            this.f4172b = view;
            this.f4171a = view2;
            this.f4173c = i10 - Math.round(view.getTranslationX());
            this.f4174d = i11 - Math.round(view.getTranslationY());
            this.f4178h = f10;
            this.f4179i = f11;
            int i12 = b.transition_position;
            int[] iArr = (int[]) view2.getTag(i12);
            this.f4175e = iArr;
            if (iArr != null) {
                view2.setTag(i12, (Object) null);
            }
        }

        public void a(Transition transition) {
        }

        public void b(Transition transition) {
        }

        public void c(Transition transition) {
        }

        public void d(Transition transition) {
        }

        public void e(Transition transition) {
            this.f4172b.setTranslationX(this.f4178h);
            this.f4172b.setTranslationY(this.f4179i);
            transition.d0(this);
        }

        public void onAnimationCancel(Animator animator) {
            if (this.f4175e == null) {
                this.f4175e = new int[2];
            }
            this.f4175e[0] = Math.round(((float) this.f4173c) + this.f4172b.getTranslationX());
            this.f4175e[1] = Math.round(((float) this.f4174d) + this.f4172b.getTranslationY());
            this.f4171a.setTag(b.transition_position, this.f4175e);
        }

        public void onAnimationPause(Animator animator) {
            this.f4176f = this.f4172b.getTranslationX();
            this.f4177g = this.f4172b.getTranslationY();
            this.f4172b.setTranslationX(this.f4178h);
            this.f4172b.setTranslationY(this.f4179i);
        }

        public void onAnimationResume(Animator animator) {
            this.f4172b.setTranslationX(this.f4176f);
            this.f4172b.setTranslationY(this.f4177g);
        }
    }

    static Animator a(View view, u uVar, int i10, int i11, float f10, float f11, float f12, float f13, TimeInterpolator timeInterpolator, Transition transition) {
        float f14;
        float f15;
        View view2 = view;
        u uVar2 = uVar;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) uVar2.f4165b.getTag(b.transition_position);
        if (iArr != null) {
            f14 = ((float) (iArr[0] - i10)) + translationX;
            f15 = ((float) (iArr[1] - i11)) + translationY;
        } else {
            f14 = f10;
            f15 = f11;
        }
        int round = i10 + Math.round(f14 - translationX);
        int round2 = i11 + Math.round(f15 - translationY);
        view.setTranslationX(f14);
        view.setTranslationY(f15);
        if (f14 == f12 && f15 == f13) {
            return null;
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{f14, f12}), PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{f15, f13})});
        a aVar = new a(view, uVar2.f4165b, round, round2, translationX, translationY);
        transition.a(aVar);
        ofPropertyValuesHolder.addListener(aVar);
        a.a(ofPropertyValuesHolder, aVar);
        ofPropertyValuesHolder.setInterpolator(timeInterpolator);
        return ofPropertyValuesHolder;
    }
}
