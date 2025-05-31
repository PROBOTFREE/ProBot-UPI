package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.x;
import java.util.Map;

public class ChangeBounds extends Transition {
    private static final String[] M = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final Property<Drawable, PointF> N = new b(PointF.class, "boundsOrigin");
    private static final Property<k, PointF> O = new c(PointF.class, "topLeft");
    private static final Property<k, PointF> P = new d(PointF.class, "bottomRight");
    private static final Property<View, PointF> Q = new e(PointF.class, "bottomRight");
    private static final Property<View, PointF> R = new f(PointF.class, "topLeft");
    private static final Property<View, PointF> S = new g(PointF.class, "position");
    private static o T = new o();
    private int[] J = new int[2];
    private boolean K = false;
    private boolean L = false;

    class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f3961a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BitmapDrawable f3962b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f3963c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ float f3964d;

        a(ChangeBounds changeBounds, ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f10) {
            this.f3961a = viewGroup;
            this.f3962b = bitmapDrawable;
            this.f3963c = view;
            this.f3964d = f10;
        }

        public void onAnimationEnd(Animator animator) {
            f0.b(this.f3961a).b(this.f3962b);
            f0.h(this.f3963c, this.f3964d);
        }
    }

    static class b extends Property<Drawable, PointF> {

        /* renamed from: a  reason: collision with root package name */
        private Rect f3965a = new Rect();

        b(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f3965a);
            Rect rect = this.f3965a;
            return new PointF((float) rect.left, (float) rect.top);
        }

        /* renamed from: b */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f3965a);
            this.f3965a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f3965a);
        }
    }

    static class c extends Property<k, PointF> {
        c(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(k kVar) {
            return null;
        }

        /* renamed from: b */
        public void set(k kVar, PointF pointF) {
            kVar.c(pointF);
        }
    }

    static class d extends Property<k, PointF> {
        d(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(k kVar) {
            return null;
        }

        /* renamed from: b */
        public void set(k kVar, PointF pointF) {
            kVar.a(pointF);
        }
    }

    static class e extends Property<View, PointF> {
        e(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: b */
        public void set(View view, PointF pointF) {
            f0.g(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    static class f extends Property<View, PointF> {
        f(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: b */
        public void set(View view, PointF pointF) {
            f0.g(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    static class g extends Property<View, PointF> {
        g(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: b */
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            f0.g(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    }

    class h extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f3966a;
        private k mViewBounds;

        h(ChangeBounds changeBounds, k kVar) {
            this.f3966a = kVar;
            this.mViewBounds = kVar;
        }
    }

    class i extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private boolean f3967a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f3968b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Rect f3969c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f3970d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f3971e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f3972f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ int f3973g;

        i(ChangeBounds changeBounds, View view, Rect rect, int i10, int i11, int i12, int i13) {
            this.f3968b = view;
            this.f3969c = rect;
            this.f3970d = i10;
            this.f3971e = i11;
            this.f3972f = i12;
            this.f3973g = i13;
        }

        public void onAnimationCancel(Animator animator) {
            this.f3967a = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f3967a) {
                x.x0(this.f3968b, this.f3969c);
                f0.g(this.f3968b, this.f3970d, this.f3971e, this.f3972f, this.f3973g);
            }
        }
    }

    class j extends r {

        /* renamed from: a  reason: collision with root package name */
        boolean f3974a = false;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewGroup f3975b;

        j(ChangeBounds changeBounds, ViewGroup viewGroup) {
            this.f3975b = viewGroup;
        }

        public void b(Transition transition) {
            a0.d(this.f3975b, false);
            this.f3974a = true;
        }

        public void c(Transition transition) {
            a0.d(this.f3975b, false);
        }

        public void d(Transition transition) {
            a0.d(this.f3975b, true);
        }

        public void e(Transition transition) {
            if (!this.f3974a) {
                a0.d(this.f3975b, false);
            }
            transition.d0(this);
        }
    }

    private static class k {

        /* renamed from: a  reason: collision with root package name */
        private int f3976a;

        /* renamed from: b  reason: collision with root package name */
        private int f3977b;

        /* renamed from: c  reason: collision with root package name */
        private int f3978c;

        /* renamed from: d  reason: collision with root package name */
        private int f3979d;

        /* renamed from: e  reason: collision with root package name */
        private View f3980e;

        /* renamed from: f  reason: collision with root package name */
        private int f3981f;

        /* renamed from: g  reason: collision with root package name */
        private int f3982g;

        k(View view) {
            this.f3980e = view;
        }

        private void b() {
            f0.g(this.f3980e, this.f3976a, this.f3977b, this.f3978c, this.f3979d);
            this.f3981f = 0;
            this.f3982g = 0;
        }

        /* access modifiers changed from: package-private */
        public void a(PointF pointF) {
            this.f3978c = Math.round(pointF.x);
            this.f3979d = Math.round(pointF.y);
            int i10 = this.f3982g + 1;
            this.f3982g = i10;
            if (this.f3981f == i10) {
                b();
            }
        }

        /* access modifiers changed from: package-private */
        public void c(PointF pointF) {
            this.f3976a = Math.round(pointF.x);
            this.f3977b = Math.round(pointF.y);
            int i10 = this.f3981f + 1;
            this.f3981f = i10;
            if (i10 == this.f3982g) {
                b();
            }
        }
    }

    public ChangeBounds() {
    }

    @SuppressLint({"RestrictedApi"})
    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, q.f4143b);
        boolean a10 = n0.g.a(obtainStyledAttributes, (XmlResourceParser) attributeSet, "resizeClip", 0, false);
        obtainStyledAttributes.recycle();
        v0(a10);
    }

    private void t0(u uVar) {
        View view = uVar.f4165b;
        if (x.V(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            uVar.f4164a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            uVar.f4164a.put("android:changeBounds:parent", uVar.f4165b.getParent());
            if (this.L) {
                uVar.f4165b.getLocationInWindow(this.J);
                uVar.f4164a.put("android:changeBounds:windowX", Integer.valueOf(this.J[0]));
                uVar.f4164a.put("android:changeBounds:windowY", Integer.valueOf(this.J[1]));
            }
            if (this.K) {
                uVar.f4164a.put("android:changeBounds:clip", x.u(view));
            }
        }
    }

    private boolean u0(View view, View view2) {
        if (!this.L) {
            return true;
        }
        u D = D(view, true);
        if (D == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == D.f4165b) {
            return true;
        }
        return false;
    }

    public String[] N() {
        return M;
    }

    public void l(u uVar) {
        t0(uVar);
    }

    public void o(u uVar) {
        t0(uVar);
    }

    public Animator s(ViewGroup viewGroup, u uVar, u uVar2) {
        int i10;
        View view;
        Animator animator;
        int i11;
        Rect rect;
        ObjectAnimator objectAnimator;
        Property<View, PointF> property;
        Path path;
        u uVar3 = uVar;
        u uVar4 = uVar2;
        if (uVar3 == null || uVar4 == null) {
            return null;
        }
        Map<String, Object> map = uVar3.f4164a;
        Map<String, Object> map2 = uVar4.f4164a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = uVar4.f4165b;
        if (u0(viewGroup2, viewGroup3)) {
            Rect rect2 = (Rect) uVar3.f4164a.get("android:changeBounds:bounds");
            Rect rect3 = (Rect) uVar4.f4164a.get("android:changeBounds:bounds");
            int i12 = rect2.left;
            int i13 = rect3.left;
            int i14 = rect2.top;
            int i15 = rect3.top;
            int i16 = rect2.right;
            int i17 = rect3.right;
            int i18 = rect2.bottom;
            int i19 = rect3.bottom;
            int i20 = i16 - i12;
            int i21 = i18 - i14;
            int i22 = i17 - i13;
            int i23 = i19 - i15;
            View view3 = view2;
            Rect rect4 = (Rect) uVar3.f4164a.get("android:changeBounds:clip");
            Rect rect5 = (Rect) uVar4.f4164a.get("android:changeBounds:clip");
            if ((i20 == 0 || i21 == 0) && (i22 == 0 || i23 == 0)) {
                i10 = 0;
            } else {
                i10 = (i12 == i13 && i14 == i15) ? 0 : 1;
                if (!(i16 == i17 && i18 == i19)) {
                    i10++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                i10++;
            }
            if (i10 <= 0) {
                return null;
            }
            Rect rect6 = rect5;
            Rect rect7 = rect4;
            if (!this.K) {
                view = view3;
                f0.g(view, i12, i14, i16, i18);
                if (i10 == 2) {
                    if (i20 == i22 && i21 == i23) {
                        path = F().a((float) i12, (float) i14, (float) i13, (float) i15);
                        property = S;
                    } else {
                        k kVar = new k(view);
                        ObjectAnimator a10 = l.a(kVar, O, F().a((float) i12, (float) i14, (float) i13, (float) i15));
                        ObjectAnimator a11 = l.a(kVar, P, F().a((float) i16, (float) i18, (float) i17, (float) i19));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(new Animator[]{a10, a11});
                        animatorSet.addListener(new h(this, kVar));
                        animator = animatorSet;
                    }
                } else if (i12 == i13 && i14 == i15) {
                    path = F().a((float) i16, (float) i18, (float) i17, (float) i19);
                    property = Q;
                } else {
                    path = F().a((float) i12, (float) i14, (float) i13, (float) i15);
                    property = R;
                }
                animator = l.a(view, property, path);
            } else {
                view = view3;
                f0.g(view, i12, i14, Math.max(i20, i22) + i12, Math.max(i21, i23) + i14);
                ObjectAnimator a12 = (i12 == i13 && i14 == i15) ? null : l.a(view, S, F().a((float) i12, (float) i14, (float) i13, (float) i15));
                if (rect7 == null) {
                    i11 = 0;
                    rect = new Rect(0, 0, i20, i21);
                } else {
                    i11 = 0;
                    rect = rect7;
                }
                Rect rect8 = rect6 == null ? new Rect(i11, i11, i22, i23) : rect6;
                if (!rect.equals(rect8)) {
                    x.x0(view, rect);
                    o oVar = T;
                    Object[] objArr = new Object[2];
                    objArr[i11] = rect;
                    objArr[1] = rect8;
                    ObjectAnimator ofObject = ObjectAnimator.ofObject(view, "clipBounds", oVar, objArr);
                    ofObject.addListener(new i(this, view, rect6, i13, i15, i17, i19));
                    objectAnimator = ofObject;
                } else {
                    objectAnimator = null;
                }
                animator = t.c(a12, objectAnimator);
            }
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                a0.d(viewGroup4, true);
                a(new j(this, viewGroup4));
            }
            return animator;
        }
        int intValue = ((Integer) uVar3.f4164a.get("android:changeBounds:windowX")).intValue();
        int intValue2 = ((Integer) uVar3.f4164a.get("android:changeBounds:windowY")).intValue();
        int intValue3 = ((Integer) uVar4.f4164a.get("android:changeBounds:windowX")).intValue();
        int intValue4 = ((Integer) uVar4.f4164a.get("android:changeBounds:windowY")).intValue();
        if (intValue == intValue3 && intValue2 == intValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.J);
        Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(createBitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        float c10 = f0.c(view2);
        f0.h(view2, 0.0f);
        f0.b(viewGroup).a(bitmapDrawable);
        PathMotion F = F();
        int[] iArr = this.J;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, new PropertyValuesHolder[]{n.a(N, F.a((float) (intValue - iArr[0]), (float) (intValue2 - iArr[1]), (float) (intValue3 - iArr[0]), (float) (intValue4 - iArr[1])))});
        ofPropertyValuesHolder.addListener(new a(this, viewGroup, bitmapDrawable, view2, c10));
        return ofPropertyValuesHolder;
    }

    public void v0(boolean z10) {
        this.K = z10;
    }
}
