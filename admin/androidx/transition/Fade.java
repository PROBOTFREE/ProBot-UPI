package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.x;
import n0.g;

public class Fade extends Visibility {

    class a extends r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f4008a;

        a(Fade fade, View view) {
            this.f4008a = view;
        }

        public void e(Transition transition) {
            f0.h(this.f4008a, 1.0f);
            f0.a(this.f4008a);
            transition.d0(this);
        }
    }

    private static class b extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final View f4009a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f4010b = false;

        b(View view) {
            this.f4009a = view;
        }

        public void onAnimationEnd(Animator animator) {
            f0.h(this.f4009a, 1.0f);
            if (this.f4010b) {
                this.f4009a.setLayerType(0, (Paint) null);
            }
        }

        public void onAnimationStart(Animator animator) {
            if (x.R(this.f4009a) && this.f4009a.getLayerType() == 0) {
                this.f4010b = true;
                this.f4009a.setLayerType(2, (Paint) null);
            }
        }
    }

    public Fade() {
    }

    public Fade(int i10) {
        A0(i10);
    }

    @SuppressLint({"RestrictedApi"})
    public Fade(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, q.f4145d);
        A0(g.g(obtainStyledAttributes, (XmlResourceParser) attributeSet, "fadingMode", 0, u0()));
        obtainStyledAttributes.recycle();
    }

    private Animator B0(View view, float f10, float f11) {
        if (f10 == f11) {
            return null;
        }
        f0.h(view, f10);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, f0.f4100b, new float[]{f11});
        ofFloat.addListener(new b(view));
        a(new a(this, view));
        return ofFloat;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r1 = (java.lang.Float) r1.f4164a.get("android:fade:transitionAlpha");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static float C0(androidx.transition.u r1, float r2) {
        /*
            if (r1 == 0) goto L_0x0012
            java.util.Map<java.lang.String, java.lang.Object> r1 = r1.f4164a
            java.lang.String r0 = "android:fade:transitionAlpha"
            java.lang.Object r1 = r1.get(r0)
            java.lang.Float r1 = (java.lang.Float) r1
            if (r1 == 0) goto L_0x0012
            float r2 = r1.floatValue()
        L_0x0012:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Fade.C0(androidx.transition.u, float):float");
    }

    public void o(u uVar) {
        super.o(uVar);
        uVar.f4164a.put("android:fade:transitionAlpha", Float.valueOf(f0.c(uVar.f4165b)));
    }

    public Animator w0(ViewGroup viewGroup, View view, u uVar, u uVar2) {
        float f10 = 0.0f;
        float C0 = C0(uVar, 0.0f);
        if (C0 != 1.0f) {
            f10 = C0;
        }
        return B0(view, f10, 1.0f);
    }

    public Animator y0(ViewGroup viewGroup, View view, u uVar, u uVar2) {
        f0.e(view);
        return B0(view, C0(uVar, 1.0f), 0.0f);
    }
}
