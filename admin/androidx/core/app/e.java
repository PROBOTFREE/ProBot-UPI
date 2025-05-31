package androidx.core.app;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class e {

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static Method f2200a;

        /* renamed from: b  reason: collision with root package name */
        private static boolean f2201b;

        /* renamed from: c  reason: collision with root package name */
        private static Method f2202c;

        /* renamed from: d  reason: collision with root package name */
        private static boolean f2203d;

        public static IBinder a(Bundle bundle, String str) {
            if (!f2201b) {
                try {
                    Method method = Bundle.class.getMethod("getIBinder", new Class[]{String.class});
                    f2200a = method;
                    method.setAccessible(true);
                } catch (NoSuchMethodException e10) {
                    Log.i("BundleCompatBaseImpl", "Failed to retrieve getIBinder method", e10);
                }
                f2201b = true;
            }
            Method method2 = f2200a;
            if (method2 != null) {
                try {
                    return (IBinder) method2.invoke(bundle, new Object[]{str});
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e11) {
                    Log.i("BundleCompatBaseImpl", "Failed to invoke getIBinder via reflection", e11);
                    f2200a = null;
                }
            }
            return null;
        }

        public static void b(Bundle bundle, String str, IBinder iBinder) {
            if (!f2203d) {
                try {
                    Method method = Bundle.class.getMethod("putIBinder", new Class[]{String.class, IBinder.class});
                    f2202c = method;
                    method.setAccessible(true);
                } catch (NoSuchMethodException e10) {
                    Log.i("BundleCompatBaseImpl", "Failed to retrieve putIBinder method", e10);
                }
                f2203d = true;
            }
            Method method2 = f2202c;
            if (method2 != null) {
                try {
                    method2.invoke(bundle, new Object[]{str, iBinder});
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e11) {
                    Log.i("BundleCompatBaseImpl", "Failed to invoke putIBinder via reflection", e11);
                    f2202c = null;
                }
            }
        }
    }

    public static IBinder a(Bundle bundle, String str) {
        return Build.VERSION.SDK_INT >= 18 ? bundle.getBinder(str) : a.a(bundle, str);
    }

    public static void b(Bundle bundle, String str, IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 18) {
            bundle.putBinder(str, iBinder);
        } else {
            a.b(bundle, str, iBinder);
        }
    }
}
