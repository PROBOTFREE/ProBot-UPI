package androidx.core.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

public class f0 {

    /* renamed from: b  reason: collision with root package name */
    public static final f0 f2343b = (Build.VERSION.SDK_INT >= 30 ? k.f2374r : l.f2375b);

    /* renamed from: a  reason: collision with root package name */
    private final l f2344a;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static Field f2345a;

        /* renamed from: b  reason: collision with root package name */
        private static Field f2346b;

        /* renamed from: c  reason: collision with root package name */
        private static Field f2347c;

        /* renamed from: d  reason: collision with root package name */
        private static boolean f2348d = true;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f2345a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f2346b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f2347c = declaredField3;
                declaredField3.setAccessible(true);
            } catch (ReflectiveOperationException e10) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e10.getMessage(), e10);
            }
        }

        public static f0 a(View view) {
            if (f2348d && view.isAttachedToWindow()) {
                try {
                    Object obj = f2345a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f2346b.get(obj);
                        Rect rect2 = (Rect) f2347c.get(obj);
                        if (!(rect == null || rect2 == null)) {
                            f0 a10 = new b().b(o0.b.c(rect)).c(o0.b.c(rect2)).a();
                            a10.u(a10);
                            a10.d(view.getRootView());
                            return a10;
                        }
                    }
                } catch (IllegalAccessException e10) {
                    Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e10.getMessage(), e10);
                }
            }
            return null;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final f f2349a;

        public b() {
            int i10 = Build.VERSION.SDK_INT;
            this.f2349a = i10 >= 30 ? new e() : i10 >= 29 ? new d() : i10 >= 20 ? new c() : new f();
        }

        public b(f0 f0Var) {
            int i10 = Build.VERSION.SDK_INT;
            this.f2349a = i10 >= 30 ? new e(f0Var) : i10 >= 29 ? new d(f0Var) : i10 >= 20 ? new c(f0Var) : new f(f0Var);
        }

        public f0 a() {
            return this.f2349a.b();
        }

        @Deprecated
        public b b(o0.b bVar) {
            this.f2349a.d(bVar);
            return this;
        }

        @Deprecated
        public b c(o0.b bVar) {
            this.f2349a.f(bVar);
            return this;
        }
    }

    private static class c extends f {

        /* renamed from: e  reason: collision with root package name */
        private static Field f2350e = null;

        /* renamed from: f  reason: collision with root package name */
        private static boolean f2351f = false;

        /* renamed from: g  reason: collision with root package name */
        private static Constructor<WindowInsets> f2352g = null;

        /* renamed from: h  reason: collision with root package name */
        private static boolean f2353h = false;

        /* renamed from: c  reason: collision with root package name */
        private WindowInsets f2354c;

        /* renamed from: d  reason: collision with root package name */
        private o0.b f2355d;

        c() {
            this.f2354c = h();
        }

        c(f0 f0Var) {
            super(f0Var);
            this.f2354c = f0Var.w();
        }

        private static WindowInsets h() {
            if (!f2351f) {
                try {
                    f2350e = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e10) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e10);
                }
                f2351f = true;
            }
            Field field = f2350e;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get((Object) null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e11) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e11);
                }
            }
            if (!f2353h) {
                try {
                    f2352g = WindowInsets.class.getConstructor(new Class[]{Rect.class});
                } catch (ReflectiveOperationException e12) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e12);
                }
                f2353h = true;
            }
            Constructor<WindowInsets> constructor = f2352g;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Object[]{new Rect()});
                } catch (ReflectiveOperationException e13) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e13);
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public f0 b() {
            a();
            f0 x10 = f0.x(this.f2354c);
            x10.s(this.f2358b);
            x10.v(this.f2355d);
            return x10;
        }

        /* access modifiers changed from: package-private */
        public void d(o0.b bVar) {
            this.f2355d = bVar;
        }

        /* access modifiers changed from: package-private */
        public void f(o0.b bVar) {
            WindowInsets windowInsets = this.f2354c;
            if (windowInsets != null) {
                this.f2354c = windowInsets.replaceSystemWindowInsets(bVar.f16299a, bVar.f16300b, bVar.f16301c, bVar.f16302d);
            }
        }
    }

    private static class d extends f {

        /* renamed from: c  reason: collision with root package name */
        final WindowInsets.Builder f2356c;

        d() {
            this.f2356c = new WindowInsets.Builder();
        }

        d(f0 f0Var) {
            super(f0Var);
            WindowInsets.Builder builder;
            WindowInsets w10 = f0Var.w();
            if (w10 == null) {
                builder = new WindowInsets.Builder();
            }
            this.f2356c = builder;
        }

        /* access modifiers changed from: package-private */
        public f0 b() {
            a();
            f0 x10 = f0.x(this.f2356c.build());
            x10.s(this.f2358b);
            return x10;
        }

        /* access modifiers changed from: package-private */
        public void c(o0.b bVar) {
            this.f2356c.setMandatorySystemGestureInsets(bVar.e());
        }

        /* access modifiers changed from: package-private */
        public void d(o0.b bVar) {
            this.f2356c.setStableInsets(bVar.e());
        }

        /* access modifiers changed from: package-private */
        public void e(o0.b bVar) {
            this.f2356c.setSystemGestureInsets(bVar.e());
        }

        /* access modifiers changed from: package-private */
        public void f(o0.b bVar) {
            this.f2356c.setSystemWindowInsets(bVar.e());
        }

        /* access modifiers changed from: package-private */
        public void g(o0.b bVar) {
            this.f2356c.setTappableElementInsets(bVar.e());
        }
    }

    private static class e extends d {
        e() {
        }

        e(f0 f0Var) {
            super(f0Var);
        }
    }

    private static class f {

        /* renamed from: a  reason: collision with root package name */
        private final f0 f2357a;

        /* renamed from: b  reason: collision with root package name */
        o0.b[] f2358b;

        f() {
            this(new f0((f0) null));
        }

        f(f0 f0Var) {
            this.f2357a = f0Var;
        }

        /* access modifiers changed from: protected */
        public final void a() {
            o0.b[] bVarArr = this.f2358b;
            if (bVarArr != null) {
                o0.b bVar = bVarArr[m.a(1)];
                o0.b bVar2 = this.f2358b[m.a(2)];
                if (bVar2 == null) {
                    bVar2 = this.f2357a.f(2);
                }
                if (bVar == null) {
                    bVar = this.f2357a.f(1);
                }
                f(o0.b.a(bVar, bVar2));
                o0.b bVar3 = this.f2358b[m.a(16)];
                if (bVar3 != null) {
                    e(bVar3);
                }
                o0.b bVar4 = this.f2358b[m.a(32)];
                if (bVar4 != null) {
                    c(bVar4);
                }
                o0.b bVar5 = this.f2358b[m.a(64)];
                if (bVar5 != null) {
                    g(bVar5);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public f0 b() {
            a();
            return this.f2357a;
        }

        /* access modifiers changed from: package-private */
        public void c(o0.b bVar) {
        }

        /* access modifiers changed from: package-private */
        public void d(o0.b bVar) {
        }

        /* access modifiers changed from: package-private */
        public void e(o0.b bVar) {
        }

        /* access modifiers changed from: package-private */
        public void f(o0.b bVar) {
        }

        /* access modifiers changed from: package-private */
        public void g(o0.b bVar) {
        }
    }

    private static class g extends l {

        /* renamed from: h  reason: collision with root package name */
        private static boolean f2359h = false;

        /* renamed from: i  reason: collision with root package name */
        private static Method f2360i;

        /* renamed from: j  reason: collision with root package name */
        private static Class<?> f2361j;

        /* renamed from: k  reason: collision with root package name */
        private static Class<?> f2362k;

        /* renamed from: l  reason: collision with root package name */
        private static Field f2363l;

        /* renamed from: m  reason: collision with root package name */
        private static Field f2364m;

        /* renamed from: c  reason: collision with root package name */
        final WindowInsets f2365c;

        /* renamed from: d  reason: collision with root package name */
        private o0.b[] f2366d;

        /* renamed from: e  reason: collision with root package name */
        private o0.b f2367e;

        /* renamed from: f  reason: collision with root package name */
        private f0 f2368f;

        /* renamed from: g  reason: collision with root package name */
        o0.b f2369g;

        g(f0 f0Var, WindowInsets windowInsets) {
            super(f0Var);
            this.f2367e = null;
            this.f2365c = windowInsets;
        }

        g(f0 f0Var, g gVar) {
            this(f0Var, new WindowInsets(gVar.f2365c));
        }

        @SuppressLint({"WrongConstant"})
        private o0.b t(int i10, boolean z10) {
            o0.b bVar = o0.b.f16298e;
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) != 0) {
                    bVar = o0.b.a(bVar, u(i11, z10));
                }
            }
            return bVar;
        }

        private o0.b v() {
            f0 f0Var = this.f2368f;
            return f0Var != null ? f0Var.h() : o0.b.f16298e;
        }

        private o0.b w(View view) {
            if (Build.VERSION.SDK_INT < 30) {
                if (!f2359h) {
                    x();
                }
                Method method = f2360i;
                if (!(method == null || f2362k == null || f2363l == null)) {
                    try {
                        Object invoke = method.invoke(view, new Object[0]);
                        if (invoke == null) {
                            Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                            return null;
                        }
                        Rect rect = (Rect) f2363l.get(f2364m.get(invoke));
                        if (rect != null) {
                            return o0.b.c(rect);
                        }
                        return null;
                    } catch (ReflectiveOperationException e10) {
                        Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e10.getMessage(), e10);
                    }
                }
                return null;
            }
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        @SuppressLint({"PrivateApi"})
        private static void x() {
            try {
                f2360i = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                f2361j = Class.forName("android.view.ViewRootImpl");
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f2362k = cls;
                f2363l = cls.getDeclaredField("mVisibleInsets");
                f2364m = f2361j.getDeclaredField("mAttachInfo");
                f2363l.setAccessible(true);
                f2364m.setAccessible(true);
            } catch (ReflectiveOperationException e10) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e10.getMessage(), e10);
            }
            f2359h = true;
        }

        /* access modifiers changed from: package-private */
        public void d(View view) {
            o0.b w10 = w(view);
            if (w10 == null) {
                w10 = o0.b.f16298e;
            }
            q(w10);
        }

        /* access modifiers changed from: package-private */
        public void e(f0 f0Var) {
            f0Var.u(this.f2368f);
            f0Var.t(this.f2369g);
        }

        public boolean equals(Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            return Objects.equals(this.f2369g, ((g) obj).f2369g);
        }

        public o0.b g(int i10) {
            return t(i10, false);
        }

        /* access modifiers changed from: package-private */
        public final o0.b k() {
            if (this.f2367e == null) {
                this.f2367e = o0.b.b(this.f2365c.getSystemWindowInsetLeft(), this.f2365c.getSystemWindowInsetTop(), this.f2365c.getSystemWindowInsetRight(), this.f2365c.getSystemWindowInsetBottom());
            }
            return this.f2367e;
        }

        /* access modifiers changed from: package-private */
        public f0 m(int i10, int i11, int i12, int i13) {
            b bVar = new b(f0.x(this.f2365c));
            bVar.c(f0.p(k(), i10, i11, i12, i13));
            bVar.b(f0.p(i(), i10, i11, i12, i13));
            return bVar.a();
        }

        /* access modifiers changed from: package-private */
        public boolean o() {
            return this.f2365c.isRound();
        }

        public void p(o0.b[] bVarArr) {
            this.f2366d = bVarArr;
        }

        /* access modifiers changed from: package-private */
        public void q(o0.b bVar) {
            this.f2369g = bVar;
        }

        /* access modifiers changed from: package-private */
        public void r(f0 f0Var) {
            this.f2368f = f0Var;
        }

        /* access modifiers changed from: protected */
        public o0.b u(int i10, boolean z10) {
            int i11;
            if (i10 == 1) {
                return z10 ? o0.b.b(0, Math.max(v().f16300b, k().f16300b), 0, 0) : o0.b.b(0, k().f16300b, 0, 0);
            }
            o0.b bVar = null;
            if (i10 != 2) {
                if (i10 == 8) {
                    o0.b[] bVarArr = this.f2366d;
                    if (bVarArr != null) {
                        bVar = bVarArr[m.a(8)];
                    }
                    if (bVar != null) {
                        return bVar;
                    }
                    o0.b k10 = k();
                    o0.b v10 = v();
                    int i12 = k10.f16302d;
                    if (i12 > v10.f16302d) {
                        return o0.b.b(0, 0, 0, i12);
                    }
                    o0.b bVar2 = this.f2369g;
                    return (bVar2 == null || bVar2.equals(o0.b.f16298e) || (i11 = this.f2369g.f16302d) <= v10.f16302d) ? o0.b.f16298e : o0.b.b(0, 0, 0, i11);
                } else if (i10 == 16) {
                    return j();
                } else {
                    if (i10 == 32) {
                        return h();
                    }
                    if (i10 == 64) {
                        return l();
                    }
                    if (i10 != 128) {
                        return o0.b.f16298e;
                    }
                    f0 f0Var = this.f2368f;
                    d e10 = f0Var != null ? f0Var.e() : f();
                    return e10 != null ? o0.b.b(e10.b(), e10.d(), e10.c(), e10.a()) : o0.b.f16298e;
                }
            } else if (z10) {
                o0.b v11 = v();
                o0.b i13 = i();
                return o0.b.b(Math.max(v11.f16299a, i13.f16299a), 0, Math.max(v11.f16301c, i13.f16301c), Math.max(v11.f16302d, i13.f16302d));
            } else {
                o0.b k11 = k();
                f0 f0Var2 = this.f2368f;
                if (f0Var2 != null) {
                    bVar = f0Var2.h();
                }
                int i14 = k11.f16302d;
                if (bVar != null) {
                    i14 = Math.min(i14, bVar.f16302d);
                }
                return o0.b.b(k11.f16299a, 0, k11.f16301c, i14);
            }
        }
    }

    private static class h extends g {

        /* renamed from: n  reason: collision with root package name */
        private o0.b f2370n = null;

        h(f0 f0Var, WindowInsets windowInsets) {
            super(f0Var, windowInsets);
        }

        h(f0 f0Var, h hVar) {
            super(f0Var, (g) hVar);
            this.f2370n = hVar.f2370n;
        }

        /* access modifiers changed from: package-private */
        public f0 b() {
            return f0.x(this.f2365c.consumeStableInsets());
        }

        /* access modifiers changed from: package-private */
        public f0 c() {
            return f0.x(this.f2365c.consumeSystemWindowInsets());
        }

        /* access modifiers changed from: package-private */
        public final o0.b i() {
            if (this.f2370n == null) {
                this.f2370n = o0.b.b(this.f2365c.getStableInsetLeft(), this.f2365c.getStableInsetTop(), this.f2365c.getStableInsetRight(), this.f2365c.getStableInsetBottom());
            }
            return this.f2370n;
        }

        /* access modifiers changed from: package-private */
        public boolean n() {
            return this.f2365c.isConsumed();
        }

        public void s(o0.b bVar) {
            this.f2370n = bVar;
        }
    }

    private static class i extends h {
        i(f0 f0Var, WindowInsets windowInsets) {
            super(f0Var, windowInsets);
        }

        i(f0 f0Var, i iVar) {
            super(f0Var, (h) iVar);
        }

        /* access modifiers changed from: package-private */
        public f0 a() {
            return f0.x(this.f2365c.consumeDisplayCutout());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return Objects.equals(this.f2365c, iVar.f2365c) && Objects.equals(this.f2369g, iVar.f2369g);
        }

        /* access modifiers changed from: package-private */
        public d f() {
            return d.e(this.f2365c.getDisplayCutout());
        }

        public int hashCode() {
            return this.f2365c.hashCode();
        }
    }

    private static class j extends i {

        /* renamed from: o  reason: collision with root package name */
        private o0.b f2371o = null;

        /* renamed from: p  reason: collision with root package name */
        private o0.b f2372p = null;

        /* renamed from: q  reason: collision with root package name */
        private o0.b f2373q = null;

        j(f0 f0Var, WindowInsets windowInsets) {
            super(f0Var, windowInsets);
        }

        j(f0 f0Var, j jVar) {
            super(f0Var, (i) jVar);
        }

        /* access modifiers changed from: package-private */
        public o0.b h() {
            if (this.f2372p == null) {
                this.f2372p = o0.b.d(this.f2365c.getMandatorySystemGestureInsets());
            }
            return this.f2372p;
        }

        /* access modifiers changed from: package-private */
        public o0.b j() {
            if (this.f2371o == null) {
                this.f2371o = o0.b.d(this.f2365c.getSystemGestureInsets());
            }
            return this.f2371o;
        }

        /* access modifiers changed from: package-private */
        public o0.b l() {
            if (this.f2373q == null) {
                this.f2373q = o0.b.d(this.f2365c.getTappableElementInsets());
            }
            return this.f2373q;
        }

        /* access modifiers changed from: package-private */
        public f0 m(int i10, int i11, int i12, int i13) {
            return f0.x(this.f2365c.inset(i10, i11, i12, i13));
        }

        public void s(o0.b bVar) {
        }
    }

    private static class k extends j {

        /* renamed from: r  reason: collision with root package name */
        static final f0 f2374r = f0.x(WindowInsets.CONSUMED);

        k(f0 f0Var, WindowInsets windowInsets) {
            super(f0Var, windowInsets);
        }

        k(f0 f0Var, k kVar) {
            super(f0Var, (j) kVar);
        }

        /* access modifiers changed from: package-private */
        public final void d(View view) {
        }

        public o0.b g(int i10) {
            return o0.b.d(this.f2365c.getInsets(n.a(i10)));
        }
    }

    private static class l {

        /* renamed from: b  reason: collision with root package name */
        static final f0 f2375b = new b().a().a().b().c();

        /* renamed from: a  reason: collision with root package name */
        final f0 f2376a;

        l(f0 f0Var) {
            this.f2376a = f0Var;
        }

        /* access modifiers changed from: package-private */
        public f0 a() {
            return this.f2376a;
        }

        /* access modifiers changed from: package-private */
        public f0 b() {
            return this.f2376a;
        }

        /* access modifiers changed from: package-private */
        public f0 c() {
            return this.f2376a;
        }

        /* access modifiers changed from: package-private */
        public void d(View view) {
        }

        /* access modifiers changed from: package-private */
        public void e(f0 f0Var) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            return o() == lVar.o() && n() == lVar.n() && w0.c.a(k(), lVar.k()) && w0.c.a(i(), lVar.i()) && w0.c.a(f(), lVar.f());
        }

        /* access modifiers changed from: package-private */
        public d f() {
            return null;
        }

        /* access modifiers changed from: package-private */
        public o0.b g(int i10) {
            return o0.b.f16298e;
        }

        /* access modifiers changed from: package-private */
        public o0.b h() {
            return k();
        }

        public int hashCode() {
            return w0.c.b(Boolean.valueOf(o()), Boolean.valueOf(n()), k(), i(), f());
        }

        /* access modifiers changed from: package-private */
        public o0.b i() {
            return o0.b.f16298e;
        }

        /* access modifiers changed from: package-private */
        public o0.b j() {
            return k();
        }

        /* access modifiers changed from: package-private */
        public o0.b k() {
            return o0.b.f16298e;
        }

        /* access modifiers changed from: package-private */
        public o0.b l() {
            return k();
        }

        /* access modifiers changed from: package-private */
        public f0 m(int i10, int i11, int i12, int i13) {
            return f2375b;
        }

        /* access modifiers changed from: package-private */
        public boolean n() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean o() {
            return false;
        }

        public void p(o0.b[] bVarArr) {
        }

        /* access modifiers changed from: package-private */
        public void q(o0.b bVar) {
        }

        /* access modifiers changed from: package-private */
        public void r(f0 f0Var) {
        }

        public void s(o0.b bVar) {
        }
    }

    public static final class m {
        static int a(int i10) {
            if (i10 == 1) {
                return 0;
            }
            if (i10 == 2) {
                return 1;
            }
            if (i10 == 4) {
                return 2;
            }
            if (i10 == 8) {
                return 3;
            }
            if (i10 == 16) {
                return 4;
            }
            if (i10 == 32) {
                return 5;
            }
            if (i10 == 64) {
                return 6;
            }
            if (i10 == 128) {
                return 7;
            }
            if (i10 == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i10);
        }
    }

    private static final class n {
        static int a(int i10) {
            int i11;
            int i12 = 0;
            for (int i13 = 1; i13 <= 256; i13 <<= 1) {
                if ((i10 & i13) != 0) {
                    if (i13 == 1) {
                        i11 = WindowInsets.Type.statusBars();
                    } else if (i13 == 2) {
                        i11 = WindowInsets.Type.navigationBars();
                    } else if (i13 == 4) {
                        i11 = WindowInsets.Type.captionBar();
                    } else if (i13 == 8) {
                        i11 = WindowInsets.Type.ime();
                    } else if (i13 == 16) {
                        i11 = WindowInsets.Type.systemGestures();
                    } else if (i13 == 32) {
                        i11 = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i13 == 64) {
                        i11 = WindowInsets.Type.tappableElement();
                    } else if (i13 == 128) {
                        i11 = WindowInsets.Type.displayCutout();
                    }
                    i12 |= i11;
                }
            }
            return i12;
        }
    }

    private f0(WindowInsets windowInsets) {
        l gVar;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30) {
            gVar = new k(this, windowInsets);
        } else if (i10 >= 29) {
            gVar = new j(this, windowInsets);
        } else if (i10 >= 28) {
            gVar = new i(this, windowInsets);
        } else if (i10 >= 21) {
            gVar = new h(this, windowInsets);
        } else if (i10 >= 20) {
            gVar = new g(this, windowInsets);
        } else {
            this.f2344a = new l(this);
            return;
        }
        this.f2344a = gVar;
    }

    public f0(f0 f0Var) {
        if (f0Var != null) {
            l lVar = f0Var.f2344a;
            int i10 = Build.VERSION.SDK_INT;
            this.f2344a = (i10 < 30 || !(lVar instanceof k)) ? (i10 < 29 || !(lVar instanceof j)) ? (i10 < 28 || !(lVar instanceof i)) ? (i10 < 21 || !(lVar instanceof h)) ? (i10 < 20 || !(lVar instanceof g)) ? new l(this) : new g(this, (g) lVar) : new h(this, (h) lVar) : new i(this, (i) lVar) : new j(this, (j) lVar) : new k(this, (k) lVar);
            lVar.e(this);
            return;
        }
        this.f2344a = new l(this);
    }

    static o0.b p(o0.b bVar, int i10, int i11, int i12, int i13) {
        int max = Math.max(0, bVar.f16299a - i10);
        int max2 = Math.max(0, bVar.f16300b - i11);
        int max3 = Math.max(0, bVar.f16301c - i12);
        int max4 = Math.max(0, bVar.f16302d - i13);
        return (max == i10 && max2 == i11 && max3 == i12 && max4 == i13) ? bVar : o0.b.b(max, max2, max3, max4);
    }

    public static f0 x(WindowInsets windowInsets) {
        return y(windowInsets, (View) null);
    }

    public static f0 y(WindowInsets windowInsets, View view) {
        f0 f0Var = new f0((WindowInsets) w0.h.e(windowInsets));
        if (view != null && view.isAttachedToWindow()) {
            f0Var.u(x.K(view));
            f0Var.d(view.getRootView());
        }
        return f0Var;
    }

    @Deprecated
    public f0 a() {
        return this.f2344a.a();
    }

    @Deprecated
    public f0 b() {
        return this.f2344a.b();
    }

    @Deprecated
    public f0 c() {
        return this.f2344a.c();
    }

    /* access modifiers changed from: package-private */
    public void d(View view) {
        this.f2344a.d(view);
    }

    public d e() {
        return this.f2344a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        return w0.c.a(this.f2344a, ((f0) obj).f2344a);
    }

    public o0.b f(int i10) {
        return this.f2344a.g(i10);
    }

    @Deprecated
    public o0.b g() {
        return this.f2344a.h();
    }

    @Deprecated
    public o0.b h() {
        return this.f2344a.i();
    }

    public int hashCode() {
        l lVar = this.f2344a;
        if (lVar == null) {
            return 0;
        }
        return lVar.hashCode();
    }

    @Deprecated
    public o0.b i() {
        return this.f2344a.j();
    }

    @Deprecated
    public int j() {
        return this.f2344a.k().f16302d;
    }

    @Deprecated
    public int k() {
        return this.f2344a.k().f16299a;
    }

    @Deprecated
    public int l() {
        return this.f2344a.k().f16301c;
    }

    @Deprecated
    public int m() {
        return this.f2344a.k().f16300b;
    }

    @Deprecated
    public boolean n() {
        return !this.f2344a.k().equals(o0.b.f16298e);
    }

    public f0 o(int i10, int i11, int i12, int i13) {
        return this.f2344a.m(i10, i11, i12, i13);
    }

    public boolean q() {
        return this.f2344a.n();
    }

    @Deprecated
    public f0 r(int i10, int i11, int i12, int i13) {
        return new b(this).c(o0.b.b(i10, i11, i12, i13)).a();
    }

    /* access modifiers changed from: package-private */
    public void s(o0.b[] bVarArr) {
        this.f2344a.p(bVarArr);
    }

    /* access modifiers changed from: package-private */
    public void t(o0.b bVar) {
        this.f2344a.q(bVar);
    }

    /* access modifiers changed from: package-private */
    public void u(f0 f0Var) {
        this.f2344a.r(f0Var);
    }

    /* access modifiers changed from: package-private */
    public void v(o0.b bVar) {
        this.f2344a.s(bVar);
    }

    public WindowInsets w() {
        l lVar = this.f2344a;
        if (lVar instanceof g) {
            return ((g) lVar).f2365c;
        }
        return null;
    }
}
