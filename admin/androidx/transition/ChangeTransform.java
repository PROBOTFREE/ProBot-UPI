package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.x;
import n0.g;
import org.xmlpull.v1.XmlPullParser;

public class ChangeTransform extends Transition {
    private static final String[] M = {"android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix"};
    private static final Property<e, float[]> N = new a(float[].class, "nonTranslations");
    private static final Property<e, PointF> O = new b(PointF.class, "translations");
    private static final boolean P = (Build.VERSION.SDK_INT >= 21);
    boolean J = true;
    private boolean K = true;
    private Matrix L = new Matrix();

    static class a extends Property<e, float[]> {
        a(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public float[] get(e eVar) {
            return null;
        }

        /* renamed from: b */
        public void set(e eVar, float[] fArr) {
            eVar.d(fArr);
        }
    }

    static class b extends Property<e, PointF> {
        b(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(e eVar) {
            return null;
        }

        /* renamed from: b */
        public void set(e eVar, PointF pointF) {
            eVar.c(pointF);
        }
    }

    class c extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private boolean f3985a;

        /* renamed from: b  reason: collision with root package name */
        private Matrix f3986b = new Matrix();

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f3987c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Matrix f3988d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ View f3989e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ f f3990f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ e f3991g;

        c(boolean z10, Matrix matrix, View view, f fVar, e eVar) {
            this.f3987c = z10;
            this.f3988d = matrix;
            this.f3989e = view;
            this.f3990f = fVar;
            this.f3991g = eVar;
        }

        private void a(Matrix matrix) {
            this.f3986b.set(matrix);
            this.f3989e.setTag(x1.b.transition_transform, this.f3986b);
            this.f3990f.a(this.f3989e);
        }

        public void onAnimationCancel(Animator animator) {
            this.f3985a = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f3985a) {
                if (!this.f3987c || !ChangeTransform.this.J) {
                    this.f3989e.setTag(x1.b.transition_transform, (Object) null);
                    this.f3989e.setTag(x1.b.parent_matrix, (Object) null);
                } else {
                    a(this.f3988d);
                }
            }
            f0.f(this.f3989e, (Matrix) null);
            this.f3990f.a(this.f3989e);
        }

        public void onAnimationPause(Animator animator) {
            a(this.f3991g.a());
        }

        public void onAnimationResume(Animator animator) {
            ChangeTransform.x0(this.f3989e);
        }
    }

    private static class d extends r {

        /* renamed from: a  reason: collision with root package name */
        private View f3993a;

        /* renamed from: b  reason: collision with root package name */
        private e f3994b;

        d(View view, e eVar) {
            this.f3993a = view;
            this.f3994b = eVar;
        }

        public void c(Transition transition) {
            this.f3994b.setVisibility(4);
        }

        public void d(Transition transition) {
            this.f3994b.setVisibility(0);
        }

        public void e(Transition transition) {
            transition.d0(this);
            i.b(this.f3993a);
            this.f3993a.setTag(x1.b.transition_transform, (Object) null);
            this.f3993a.setTag(x1.b.parent_matrix, (Object) null);
        }
    }

    private static class e {

        /* renamed from: a  reason: collision with root package name */
        private final Matrix f3995a = new Matrix();

        /* renamed from: b  reason: collision with root package name */
        private final View f3996b;

        /* renamed from: c  reason: collision with root package name */
        private final float[] f3997c;

        /* renamed from: d  reason: collision with root package name */
        private float f3998d;

        /* renamed from: e  reason: collision with root package name */
        private float f3999e;

        e(View view, float[] fArr) {
            this.f3996b = view;
            float[] fArr2 = (float[]) fArr.clone();
            this.f3997c = fArr2;
            this.f3998d = fArr2[2];
            this.f3999e = fArr2[5];
            b();
        }

        private void b() {
            float[] fArr = this.f3997c;
            fArr[2] = this.f3998d;
            fArr[5] = this.f3999e;
            this.f3995a.setValues(fArr);
            f0.f(this.f3996b, this.f3995a);
        }

        /* access modifiers changed from: package-private */
        public Matrix a() {
            return this.f3995a;
        }

        /* access modifiers changed from: package-private */
        public void c(PointF pointF) {
            this.f3998d = pointF.x;
            this.f3999e = pointF.y;
            b();
        }

        /* access modifiers changed from: package-private */
        public void d(float[] fArr) {
            System.arraycopy(fArr, 0, this.f3997c, 0, fArr.length);
            b();
        }
    }

    private static class f {

        /* renamed from: a  reason: collision with root package name */
        final float f4000a;

        /* renamed from: b  reason: collision with root package name */
        final float f4001b;

        /* renamed from: c  reason: collision with root package name */
        final float f4002c;

        /* renamed from: d  reason: collision with root package name */
        final float f4003d;

        /* renamed from: e  reason: collision with root package name */
        final float f4004e;

        /* renamed from: f  reason: collision with root package name */
        final float f4005f;

        /* renamed from: g  reason: collision with root package name */
        final float f4006g;

        /* renamed from: h  reason: collision with root package name */
        final float f4007h;

        f(View view) {
            this.f4000a = view.getTranslationX();
            this.f4001b = view.getTranslationY();
            this.f4002c = x.N(view);
            this.f4003d = view.getScaleX();
            this.f4004e = view.getScaleY();
            this.f4005f = view.getRotationX();
            this.f4006g = view.getRotationY();
            this.f4007h = view.getRotation();
        }

        public void a(View view) {
            ChangeTransform.z0(view, this.f4000a, this.f4001b, this.f4002c, this.f4003d, this.f4004e, this.f4005f, this.f4006g, this.f4007h);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return fVar.f4000a == this.f4000a && fVar.f4001b == this.f4001b && fVar.f4002c == this.f4002c && fVar.f4003d == this.f4003d && fVar.f4004e == this.f4004e && fVar.f4005f == this.f4005f && fVar.f4006g == this.f4006g && fVar.f4007h == this.f4007h;
        }

        public int hashCode() {
            float f10 = this.f4000a;
            int i10 = 0;
            int floatToIntBits = (f10 != 0.0f ? Float.floatToIntBits(f10) : 0) * 31;
            float f11 = this.f4001b;
            int floatToIntBits2 = (floatToIntBits + (f11 != 0.0f ? Float.floatToIntBits(f11) : 0)) * 31;
            float f12 = this.f4002c;
            int floatToIntBits3 = (floatToIntBits2 + (f12 != 0.0f ? Float.floatToIntBits(f12) : 0)) * 31;
            float f13 = this.f4003d;
            int floatToIntBits4 = (floatToIntBits3 + (f13 != 0.0f ? Float.floatToIntBits(f13) : 0)) * 31;
            float f14 = this.f4004e;
            int floatToIntBits5 = (floatToIntBits4 + (f14 != 0.0f ? Float.floatToIntBits(f14) : 0)) * 31;
            float f15 = this.f4005f;
            int floatToIntBits6 = (floatToIntBits5 + (f15 != 0.0f ? Float.floatToIntBits(f15) : 0)) * 31;
            float f16 = this.f4006g;
            int floatToIntBits7 = (floatToIntBits6 + (f16 != 0.0f ? Float.floatToIntBits(f16) : 0)) * 31;
            float f17 = this.f4007h;
            if (f17 != 0.0f) {
                i10 = Float.floatToIntBits(f17);
            }
            return floatToIntBits7 + i10;
        }
    }

    public ChangeTransform() {
    }

    @SuppressLint({"RestrictedApi"})
    public ChangeTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, q.f4146e);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        this.J = g.a(obtainStyledAttributes, xmlPullParser, "reparentWithOverlay", 1, true);
        this.K = g.a(obtainStyledAttributes, xmlPullParser, "reparent", 0, true);
        obtainStyledAttributes.recycle();
    }

    private void t0(u uVar) {
        View view = uVar.f4165b;
        if (view.getVisibility() != 8) {
            uVar.f4164a.put("android:changeTransform:parent", view.getParent());
            uVar.f4164a.put("android:changeTransform:transforms", new f(view));
            Matrix matrix = view.getMatrix();
            uVar.f4164a.put("android:changeTransform:matrix", (matrix == null || matrix.isIdentity()) ? null : new Matrix(matrix));
            if (this.K) {
                Matrix matrix2 = new Matrix();
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                f0.j(viewGroup, matrix2);
                matrix2.preTranslate((float) (-viewGroup.getScrollX()), (float) (-viewGroup.getScrollY()));
                uVar.f4164a.put("android:changeTransform:parentMatrix", matrix2);
                uVar.f4164a.put("android:changeTransform:intermediateMatrix", view.getTag(x1.b.transition_transform));
                uVar.f4164a.put("android:changeTransform:intermediateParentMatrix", view.getTag(x1.b.parent_matrix));
            }
        }
    }

    private void u0(ViewGroup viewGroup, u uVar, u uVar2) {
        View view = uVar2.f4165b;
        Matrix matrix = new Matrix((Matrix) uVar2.f4164a.get("android:changeTransform:parentMatrix"));
        f0.k(viewGroup, matrix);
        e a10 = i.a(view, viewGroup, matrix);
        if (a10 != null) {
            a10.a((ViewGroup) uVar.f4164a.get("android:changeTransform:parent"), uVar.f4165b);
            Transition transition = this;
            while (true) {
                Transition transition2 = transition.f4030r;
                if (transition2 == null) {
                    break;
                }
                transition = transition2;
            }
            transition.a(new d(view, a10));
            if (P) {
                View view2 = uVar.f4165b;
                if (view2 != uVar2.f4165b) {
                    f0.h(view2, 0.0f);
                }
                f0.h(view, 1.0f);
            }
        }
    }

    private ObjectAnimator v0(u uVar, u uVar2, boolean z10) {
        Matrix matrix = (Matrix) uVar.f4164a.get("android:changeTransform:matrix");
        Matrix matrix2 = (Matrix) uVar2.f4164a.get("android:changeTransform:matrix");
        if (matrix == null) {
            matrix = k.f4125a;
        }
        if (matrix2 == null) {
            matrix2 = k.f4125a;
        }
        Matrix matrix3 = matrix2;
        if (matrix.equals(matrix3)) {
            return null;
        }
        View view = uVar2.f4165b;
        x0(view);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        float[] fArr2 = new float[9];
        matrix3.getValues(fArr2);
        e eVar = new e(view, fArr);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(eVar, new PropertyValuesHolder[]{PropertyValuesHolder.ofObject(N, new c(new float[9]), new float[][]{fArr, fArr2}), n.a(O, F().a(fArr[2], fArr[5], fArr2[2], fArr2[5]))});
        c cVar = new c(z10, matrix3, view, (f) uVar2.f4164a.get("android:changeTransform:transforms"), eVar);
        ofPropertyValuesHolder.addListener(cVar);
        a.a(ofPropertyValuesHolder, cVar);
        return ofPropertyValuesHolder;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r5 == r4.f4165b) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        if (r4 == r5) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean w0(android.view.ViewGroup r4, android.view.ViewGroup r5) {
        /*
            r3 = this;
            boolean r0 = r3.R(r4)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x001a
            boolean r0 = r3.R(r5)
            if (r0 != 0) goto L_0x000f
            goto L_0x001a
        L_0x000f:
            androidx.transition.u r4 = r3.D(r4, r1)
            if (r4 == 0) goto L_0x001f
            android.view.View r4 = r4.f4165b
            if (r5 != r4) goto L_0x001d
            goto L_0x001e
        L_0x001a:
            if (r4 != r5) goto L_0x001d
            goto L_0x001e
        L_0x001d:
            r1 = r2
        L_0x001e:
            r2 = r1
        L_0x001f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ChangeTransform.w0(android.view.ViewGroup, android.view.ViewGroup):boolean");
    }

    static void x0(View view) {
        z0(view, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    private void y0(u uVar, u uVar2) {
        Matrix matrix = (Matrix) uVar2.f4164a.get("android:changeTransform:parentMatrix");
        uVar2.f4165b.setTag(x1.b.parent_matrix, matrix);
        Matrix matrix2 = this.L;
        matrix2.reset();
        matrix.invert(matrix2);
        Matrix matrix3 = (Matrix) uVar.f4164a.get("android:changeTransform:matrix");
        if (matrix3 == null) {
            matrix3 = new Matrix();
            uVar.f4164a.put("android:changeTransform:matrix", matrix3);
        }
        matrix3.postConcat((Matrix) uVar.f4164a.get("android:changeTransform:parentMatrix"));
        matrix3.postConcat(matrix2);
    }

    static void z0(View view, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        view.setTranslationX(f10);
        view.setTranslationY(f11);
        x.L0(view, f12);
        view.setScaleX(f13);
        view.setScaleY(f14);
        view.setRotationX(f15);
        view.setRotationY(f16);
        view.setRotation(f17);
    }

    public String[] N() {
        return M;
    }

    public void l(u uVar) {
        t0(uVar);
    }

    public void o(u uVar) {
        t0(uVar);
        if (!P) {
            ((ViewGroup) uVar.f4165b.getParent()).startViewTransition(uVar.f4165b);
        }
    }

    public Animator s(ViewGroup viewGroup, u uVar, u uVar2) {
        if (uVar == null || uVar2 == null || !uVar.f4164a.containsKey("android:changeTransform:parent") || !uVar2.f4164a.containsKey("android:changeTransform:parent")) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) uVar.f4164a.get("android:changeTransform:parent");
        boolean z10 = this.K && !w0(viewGroup2, (ViewGroup) uVar2.f4164a.get("android:changeTransform:parent"));
        Matrix matrix = (Matrix) uVar.f4164a.get("android:changeTransform:intermediateMatrix");
        if (matrix != null) {
            uVar.f4164a.put("android:changeTransform:matrix", matrix);
        }
        Matrix matrix2 = (Matrix) uVar.f4164a.get("android:changeTransform:intermediateParentMatrix");
        if (matrix2 != null) {
            uVar.f4164a.put("android:changeTransform:parentMatrix", matrix2);
        }
        if (z10) {
            y0(uVar, uVar2);
        }
        ObjectAnimator v02 = v0(uVar, uVar2, z10);
        if (z10 && v02 != null && this.J) {
            u0(viewGroup, uVar, uVar2);
        } else if (!P) {
            viewGroup2.endViewTransition(uVar.f4165b);
        }
        return v02;
    }
}
