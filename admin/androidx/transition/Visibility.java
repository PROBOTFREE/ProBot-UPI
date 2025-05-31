package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import androidx.transition.a;
import n0.g;

public abstract class Visibility extends Transition {
    private static final String[] K = {"android:visibility:visibility", "android:visibility:parent"};
    private int J = 3;

    class a extends r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f4049a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f4050b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f4051c;

        a(ViewGroup viewGroup, View view, View view2) {
            this.f4049a = viewGroup;
            this.f4050b = view;
            this.f4051c = view2;
        }

        public void c(Transition transition) {
            a0.b(this.f4049a).d(this.f4050b);
        }

        public void d(Transition transition) {
            if (this.f4050b.getParent() == null) {
                a0.b(this.f4049a).c(this.f4050b);
            } else {
                Visibility.this.cancel();
            }
        }

        public void e(Transition transition) {
            this.f4051c.setTag(x1.b.save_overlay_view, (Object) null);
            a0.b(this.f4049a).d(this.f4050b);
            transition.d0(this);
        }
    }

    private static class b extends AnimatorListenerAdapter implements Transition.f, a.C0044a {

        /* renamed from: a  reason: collision with root package name */
        private final View f4053a;

        /* renamed from: b  reason: collision with root package name */
        private final int f4054b;

        /* renamed from: c  reason: collision with root package name */
        private final ViewGroup f4055c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f4056d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f4057e;

        /* renamed from: f  reason: collision with root package name */
        boolean f4058f = false;

        b(View view, int i10, boolean z10) {
            this.f4053a = view;
            this.f4054b = i10;
            this.f4055c = (ViewGroup) view.getParent();
            this.f4056d = z10;
            g(true);
        }

        private void f() {
            if (!this.f4058f) {
                f0.i(this.f4053a, this.f4054b);
                ViewGroup viewGroup = this.f4055c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            g(false);
        }

        private void g(boolean z10) {
            ViewGroup viewGroup;
            if (this.f4056d && this.f4057e != z10 && (viewGroup = this.f4055c) != null) {
                this.f4057e = z10;
                a0.d(viewGroup, z10);
            }
        }

        public void a(Transition transition) {
        }

        public void b(Transition transition) {
        }

        public void c(Transition transition) {
            g(false);
        }

        public void d(Transition transition) {
            g(true);
        }

        public void e(Transition transition) {
            f();
            transition.d0(this);
        }

        public void onAnimationCancel(Animator animator) {
            this.f4058f = true;
        }

        public void onAnimationEnd(Animator animator) {
            f();
        }

        public void onAnimationPause(Animator animator) {
            if (!this.f4058f) {
                f0.i(this.f4053a, this.f4054b);
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationResume(Animator animator) {
            if (!this.f4058f) {
                f0.i(this.f4053a, 0);
            }
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    private static class c {

        /* renamed from: a  reason: collision with root package name */
        boolean f4059a;

        /* renamed from: b  reason: collision with root package name */
        boolean f4060b;

        /* renamed from: c  reason: collision with root package name */
        int f4061c;

        /* renamed from: d  reason: collision with root package name */
        int f4062d;

        /* renamed from: e  reason: collision with root package name */
        ViewGroup f4063e;

        /* renamed from: f  reason: collision with root package name */
        ViewGroup f4064f;

        c() {
        }
    }

    public Visibility() {
    }

    @SuppressLint({"RestrictedApi"})
    public Visibility(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, q.f4144c);
        int g10 = g.g(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionVisibilityMode", 0, 0);
        obtainStyledAttributes.recycle();
        if (g10 != 0) {
            A0(g10);
        }
    }

    private void t0(u uVar) {
        uVar.f4164a.put("android:visibility:visibility", Integer.valueOf(uVar.f4165b.getVisibility()));
        uVar.f4164a.put("android:visibility:parent", uVar.f4165b.getParent());
        int[] iArr = new int[2];
        uVar.f4165b.getLocationOnScreen(iArr);
        uVar.f4164a.put("android:visibility:screenLocation", iArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0075, code lost:
        if (r9 == 0) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007f, code lost:
        if (r0.f4063e == null) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0091, code lost:
        if (r0.f4061c == 0) goto L_0x0093;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private androidx.transition.Visibility.c v0(androidx.transition.u r8, androidx.transition.u r9) {
        /*
            r7 = this;
            androidx.transition.Visibility$c r0 = new androidx.transition.Visibility$c
            r0.<init>()
            r1 = 0
            r0.f4059a = r1
            r0.f4060b = r1
            java.lang.String r2 = "android:visibility:parent"
            r3 = 0
            r4 = -1
            java.lang.String r5 = "android:visibility:visibility"
            if (r8 == 0) goto L_0x0033
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.f4164a
            boolean r6 = r6.containsKey(r5)
            if (r6 == 0) goto L_0x0033
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.f4164a
            java.lang.Object r6 = r6.get(r5)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            r0.f4061c = r6
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.f4164a
            java.lang.Object r6 = r6.get(r2)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0.f4063e = r6
            goto L_0x0037
        L_0x0033:
            r0.f4061c = r4
            r0.f4063e = r3
        L_0x0037:
            if (r9 == 0) goto L_0x005a
            java.util.Map<java.lang.String, java.lang.Object> r6 = r9.f4164a
            boolean r6 = r6.containsKey(r5)
            if (r6 == 0) goto L_0x005a
            java.util.Map<java.lang.String, java.lang.Object> r3 = r9.f4164a
            java.lang.Object r3 = r3.get(r5)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r0.f4062d = r3
            java.util.Map<java.lang.String, java.lang.Object> r3 = r9.f4164a
            java.lang.Object r2 = r3.get(r2)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r0.f4064f = r2
            goto L_0x005e
        L_0x005a:
            r0.f4062d = r4
            r0.f4064f = r3
        L_0x005e:
            r2 = 1
            if (r8 == 0) goto L_0x0082
            if (r9 == 0) goto L_0x0082
            int r8 = r0.f4061c
            int r9 = r0.f4062d
            if (r8 != r9) goto L_0x0070
            android.view.ViewGroup r3 = r0.f4063e
            android.view.ViewGroup r4 = r0.f4064f
            if (r3 != r4) goto L_0x0070
            return r0
        L_0x0070:
            if (r8 == r9) goto L_0x0078
            if (r8 != 0) goto L_0x0075
            goto L_0x0093
        L_0x0075:
            if (r9 != 0) goto L_0x0096
            goto L_0x0088
        L_0x0078:
            android.view.ViewGroup r8 = r0.f4064f
            if (r8 != 0) goto L_0x007d
            goto L_0x0093
        L_0x007d:
            android.view.ViewGroup r8 = r0.f4063e
            if (r8 != 0) goto L_0x0096
            goto L_0x0088
        L_0x0082:
            if (r8 != 0) goto L_0x008d
            int r8 = r0.f4062d
            if (r8 != 0) goto L_0x008d
        L_0x0088:
            r0.f4060b = r2
        L_0x008a:
            r0.f4059a = r2
            goto L_0x0096
        L_0x008d:
            if (r9 != 0) goto L_0x0096
            int r8 = r0.f4061c
            if (r8 != 0) goto L_0x0096
        L_0x0093:
            r0.f4060b = r1
            goto L_0x008a
        L_0x0096:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Visibility.v0(androidx.transition.u, androidx.transition.u):androidx.transition.Visibility$c");
    }

    public void A0(int i10) {
        if ((i10 & -4) == 0) {
            this.J = i10;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    public String[] N() {
        return K;
    }

    public boolean P(u uVar, u uVar2) {
        if (uVar == null && uVar2 == null) {
            return false;
        }
        if (uVar != null && uVar2 != null && uVar2.f4164a.containsKey("android:visibility:visibility") != uVar.f4164a.containsKey("android:visibility:visibility")) {
            return false;
        }
        c v02 = v0(uVar, uVar2);
        if (v02.f4059a) {
            return v02.f4061c == 0 || v02.f4062d == 0;
        }
        return false;
    }

    public void l(u uVar) {
        t0(uVar);
    }

    public void o(u uVar) {
        t0(uVar);
    }

    public Animator s(ViewGroup viewGroup, u uVar, u uVar2) {
        c v02 = v0(uVar, uVar2);
        if (!v02.f4059a) {
            return null;
        }
        if (v02.f4063e == null && v02.f4064f == null) {
            return null;
        }
        if (v02.f4060b) {
            return x0(viewGroup, uVar, v02.f4061c, uVar2, v02.f4062d);
        }
        return z0(viewGroup, uVar, v02.f4061c, uVar2, v02.f4062d);
    }

    public int u0() {
        return this.J;
    }

    public Animator w0(ViewGroup viewGroup, View view, u uVar, u uVar2) {
        return null;
    }

    public Animator x0(ViewGroup viewGroup, u uVar, int i10, u uVar2, int i11) {
        if ((this.J & 1) != 1 || uVar2 == null) {
            return null;
        }
        if (uVar == null) {
            View view = (View) uVar2.f4165b.getParent();
            if (v0(D(view, false), O(view, false)).f4059a) {
                return null;
            }
        }
        return w0(viewGroup, uVar2.f4165b, uVar, uVar2);
    }

    public Animator y0(ViewGroup viewGroup, View view, u uVar, u uVar2) {
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0089, code lost:
        if (r0.f4034v != false) goto L_0x008b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator z0(android.view.ViewGroup r18, androidx.transition.u r19, int r20, androidx.transition.u r21, int r22) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r21
            r4 = r22
            int r5 = r0.J
            r6 = 2
            r5 = r5 & r6
            r7 = 0
            if (r5 == r6) goto L_0x0012
            return r7
        L_0x0012:
            if (r2 != 0) goto L_0x0015
            return r7
        L_0x0015:
            android.view.View r5 = r2.f4165b
            if (r3 == 0) goto L_0x001c
            android.view.View r8 = r3.f4165b
            goto L_0x001d
        L_0x001c:
            r8 = r7
        L_0x001d:
            int r9 = x1.b.save_overlay_view
            java.lang.Object r10 = r5.getTag(r9)
            android.view.View r10 = (android.view.View) r10
            r11 = 0
            r12 = 1
            if (r10 == 0) goto L_0x002d
            r8 = r7
            r13 = r12
            goto L_0x0095
        L_0x002d:
            if (r8 == 0) goto L_0x0040
            android.view.ViewParent r10 = r8.getParent()
            if (r10 != 0) goto L_0x0036
            goto L_0x0040
        L_0x0036:
            r10 = 4
            if (r4 != r10) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            if (r5 != r8) goto L_0x0045
        L_0x003c:
            r10 = r8
            r13 = r11
            r8 = r7
            goto L_0x0048
        L_0x0040:
            if (r8 == 0) goto L_0x0045
            r10 = r7
            r13 = r11
            goto L_0x0048
        L_0x0045:
            r8 = r7
            r10 = r8
            r13 = r12
        L_0x0048:
            if (r13 == 0) goto L_0x008f
            android.view.ViewParent r13 = r5.getParent()
            if (r13 != 0) goto L_0x0051
            goto L_0x008b
        L_0x0051:
            android.view.ViewParent r13 = r5.getParent()
            boolean r13 = r13 instanceof android.view.View
            if (r13 == 0) goto L_0x008f
            android.view.ViewParent r13 = r5.getParent()
            android.view.View r13 = (android.view.View) r13
            androidx.transition.u r14 = r0.O(r13, r12)
            androidx.transition.u r15 = r0.D(r13, r12)
            androidx.transition.Visibility$c r14 = r0.v0(r14, r15)
            boolean r14 = r14.f4059a
            if (r14 != 0) goto L_0x0074
            android.view.View r8 = androidx.transition.t.a(r1, r5, r13)
            goto L_0x008f
        L_0x0074:
            int r14 = r13.getId()
            android.view.ViewParent r13 = r13.getParent()
            if (r13 != 0) goto L_0x008f
            r13 = -1
            if (r14 == r13) goto L_0x008f
            android.view.View r13 = r1.findViewById(r14)
            if (r13 == 0) goto L_0x008f
            boolean r13 = r0.f4034v
            if (r13 == 0) goto L_0x008f
        L_0x008b:
            r8 = r10
            r13 = r11
            r10 = r5
            goto L_0x0095
        L_0x008f:
            r13 = r11
            r16 = r10
            r10 = r8
            r8 = r16
        L_0x0095:
            if (r10 == 0) goto L_0x00e5
            if (r13 != 0) goto L_0x00c9
            java.util.Map<java.lang.String, java.lang.Object> r4 = r2.f4164a
            java.lang.String r7 = "android:visibility:screenLocation"
            java.lang.Object r4 = r4.get(r7)
            int[] r4 = (int[]) r4
            r7 = r4[r11]
            r4 = r4[r12]
            int[] r6 = new int[r6]
            r1.getLocationOnScreen(r6)
            r8 = r6[r11]
            int r7 = r7 - r8
            int r8 = r10.getLeft()
            int r7 = r7 - r8
            r10.offsetLeftAndRight(r7)
            r6 = r6[r12]
            int r4 = r4 - r6
            int r6 = r10.getTop()
            int r4 = r4 - r6
            r10.offsetTopAndBottom(r4)
            androidx.transition.z r4 = androidx.transition.a0.b(r18)
            r4.c(r10)
        L_0x00c9:
            android.animation.Animator r2 = r0.y0(r1, r10, r2, r3)
            if (r13 != 0) goto L_0x00e4
            if (r2 != 0) goto L_0x00d9
            androidx.transition.z r1 = androidx.transition.a0.b(r18)
            r1.d(r10)
            goto L_0x00e4
        L_0x00d9:
            r5.setTag(r9, r10)
            androidx.transition.Visibility$a r3 = new androidx.transition.Visibility$a
            r3.<init>(r1, r10, r5)
            r0.a(r3)
        L_0x00e4:
            return r2
        L_0x00e5:
            if (r8 == 0) goto L_0x0107
            int r5 = r8.getVisibility()
            androidx.transition.f0.i(r8, r11)
            android.animation.Animator r1 = r0.y0(r1, r8, r2, r3)
            if (r1 == 0) goto L_0x0103
            androidx.transition.Visibility$b r2 = new androidx.transition.Visibility$b
            r2.<init>(r8, r4, r12)
            r1.addListener(r2)
            androidx.transition.a.a(r1, r2)
            r0.a(r2)
            goto L_0x0106
        L_0x0103:
            androidx.transition.f0.i(r8, r5)
        L_0x0106:
            return r1
        L_0x0107:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Visibility.z0(android.view.ViewGroup, androidx.transition.u, int, androidx.transition.u, int):android.animation.Animator");
    }
}
