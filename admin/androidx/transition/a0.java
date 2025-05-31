package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class a0 {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f4065a = true;

    /* renamed from: b  reason: collision with root package name */
    private static Method f4066b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f4067c;

    static int a(ViewGroup viewGroup, int i10) {
        if (Build.VERSION.SDK_INT >= 29) {
            return viewGroup.getChildDrawingOrder(i10);
        }
        if (!f4067c) {
            Class<ViewGroup> cls = ViewGroup.class;
            try {
                Class cls2 = Integer.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("getChildDrawingOrder", new Class[]{cls2, cls2});
                f4066b = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            f4067c = true;
        }
        Method method = f4066b;
        if (method != null) {
            try {
                return ((Integer) method.invoke(viewGroup, new Object[]{Integer.valueOf(viewGroup.getChildCount()), Integer.valueOf(i10)})).intValue();
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
        }
        return i10;
    }

    static z b(ViewGroup viewGroup) {
        return Build.VERSION.SDK_INT >= 18 ? new y(viewGroup) : x.g(viewGroup);
    }

    @SuppressLint({"NewApi"})
    private static void c(ViewGroup viewGroup, boolean z10) {
        if (f4065a) {
            try {
                viewGroup.suppressLayout(z10);
            } catch (NoSuchMethodError unused) {
                f4065a = false;
            }
        }
    }

    static void d(ViewGroup viewGroup, boolean z10) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29) {
            viewGroup.suppressLayout(z10);
        } else if (i10 >= 18) {
            c(viewGroup, z10);
        } else {
            b0.b(viewGroup, z10);
        }
    }
}
