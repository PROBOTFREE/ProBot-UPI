package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.core.view.x;
import org.xmlpull.v1.XmlPullParser;

public class Slide extends Visibility {
    private static final TimeInterpolator M = new DecelerateInterpolator();
    private static final TimeInterpolator N = new AccelerateInterpolator();
    private static final g O = new a();
    private static final g P = new b();
    private static final g Q = new c();
    private static final g R = new d();
    private static final g S = new e();
    private static final g T = new f();
    private g L = T;

    static class a extends h {
        a() {
            super((a) null);
        }

        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX() - ((float) viewGroup.getWidth());
        }
    }

    static class b extends h {
        b() {
            super((a) null);
        }

        public float b(ViewGroup viewGroup, View view) {
            boolean z10 = true;
            if (x.C(viewGroup) != 1) {
                z10 = false;
            }
            float translationX = view.getTranslationX();
            float width = (float) viewGroup.getWidth();
            return z10 ? translationX + width : translationX - width;
        }
    }

    static class c extends i {
        c() {
            super((a) null);
        }

        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY() - ((float) viewGroup.getHeight());
        }
    }

    static class d extends h {
        d() {
            super((a) null);
        }

        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX() + ((float) viewGroup.getWidth());
        }
    }

    static class e extends h {
        e() {
            super((a) null);
        }

        public float b(ViewGroup viewGroup, View view) {
            boolean z10 = true;
            if (x.C(viewGroup) != 1) {
                z10 = false;
            }
            float translationX = view.getTranslationX();
            float width = (float) viewGroup.getWidth();
            return z10 ? translationX - width : translationX + width;
        }
    }

    static class f extends i {
        f() {
            super((a) null);
        }

        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY() + ((float) viewGroup.getHeight());
        }
    }

    private interface g {
        float a(ViewGroup viewGroup, View view);

        float b(ViewGroup viewGroup, View view);
    }

    private static abstract class h implements g {
        private h() {
        }

        /* synthetic */ h(a aVar) {
            this();
        }

        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY();
        }
    }

    private static abstract class i implements g {
        private i() {
        }

        /* synthetic */ i(a aVar) {
            this();
        }

        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX();
        }
    }

    public Slide() {
        B0(80);
    }

    public Slide(int i10) {
        B0(i10);
    }

    @SuppressLint({"RestrictedApi"})
    public Slide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, q.f4147f);
        int g10 = n0.g.g(obtainStyledAttributes, (XmlPullParser) attributeSet, "slideEdge", 0, 80);
        obtainStyledAttributes.recycle();
        B0(g10);
    }

    private void t0(u uVar) {
        int[] iArr = new int[2];
        uVar.f4165b.getLocationOnScreen(iArr);
        uVar.f4164a.put("android:slide:screenPosition", iArr);
    }

    public void B0(int i10) {
        g gVar;
        if (i10 == 3) {
            gVar = O;
        } else if (i10 == 5) {
            gVar = R;
        } else if (i10 == 48) {
            gVar = Q;
        } else if (i10 == 80) {
            gVar = T;
        } else if (i10 == 8388611) {
            gVar = P;
        } else if (i10 == 8388613) {
            gVar = S;
        } else {
            throw new IllegalArgumentException("Invalid slide direction");
        }
        this.L = gVar;
        x1.c cVar = new x1.c();
        cVar.j(i10);
        o0(cVar);
    }

    public void l(u uVar) {
        super.l(uVar);
        t0(uVar);
    }

    public void o(u uVar) {
        super.o(uVar);
        t0(uVar);
    }

    public Animator w0(ViewGroup viewGroup, View view, u uVar, u uVar2) {
        if (uVar2 == null) {
            return null;
        }
        int[] iArr = (int[]) uVar2.f4164a.get("android:slide:screenPosition");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        return w.a(view, uVar2, iArr[0], iArr[1], this.L.b(viewGroup, view), this.L.a(viewGroup, view), translationX, translationY, M, this);
    }

    public Animator y0(ViewGroup viewGroup, View view, u uVar, u uVar2) {
        if (uVar == null) {
            return null;
        }
        int[] iArr = (int[]) uVar.f4164a.get("android:slide:screenPosition");
        return w.a(view, uVar, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.L.b(viewGroup, view), this.L.a(viewGroup, view), N, this);
    }
}
