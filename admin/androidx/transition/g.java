package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class g implements e {

    /* renamed from: b  reason: collision with root package name */
    private static Class<?> f4102b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f4103c;

    /* renamed from: d  reason: collision with root package name */
    private static Method f4104d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f4105e;

    /* renamed from: f  reason: collision with root package name */
    private static Method f4106f;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f4107g;

    /* renamed from: a  reason: collision with root package name */
    private final View f4108a;

    private g(View view) {
        this.f4108a = view;
    }

    static e b(View view, ViewGroup viewGroup, Matrix matrix) {
        c();
        Method method = f4104d;
        if (method != null) {
            try {
                return new g((View) method.invoke((Object) null, new Object[]{view, viewGroup, matrix}));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e10) {
                throw new RuntimeException(e10.getCause());
            }
        }
        return null;
    }

    private static void c() {
        if (!f4105e) {
            try {
                d();
                Method declaredMethod = f4102b.getDeclaredMethod("addGhost", new Class[]{View.class, ViewGroup.class, Matrix.class});
                f4104d = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e10) {
                Log.i("GhostViewApi21", "Failed to retrieve addGhost method", e10);
            }
            f4105e = true;
        }
    }

    private static void d() {
        if (!f4103c) {
            try {
                f4102b = Class.forName("android.view.GhostView");
            } catch (ClassNotFoundException e10) {
                Log.i("GhostViewApi21", "Failed to retrieve GhostView class", e10);
            }
            f4103c = true;
        }
    }

    private static void e() {
        if (!f4107g) {
            try {
                d();
                Method declaredMethod = f4102b.getDeclaredMethod("removeGhost", new Class[]{View.class});
                f4106f = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e10) {
                Log.i("GhostViewApi21", "Failed to retrieve removeGhost method", e10);
            }
            f4107g = true;
        }
    }

    static void f(View view) {
        e();
        Method method = f4106f;
        if (method != null) {
            try {
                method.invoke((Object) null, new Object[]{view});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e10) {
                throw new RuntimeException(e10.getCause());
            }
        }
    }

    public void a(ViewGroup viewGroup, View view) {
    }

    public void setVisibility(int i10) {
        this.f4108a.setVisibility(i10);
    }
}
