package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

final class c {

    /* renamed from: a  reason: collision with root package name */
    protected static final Class<?> f2181a;

    /* renamed from: b  reason: collision with root package name */
    protected static final Field f2182b = b();

    /* renamed from: c  reason: collision with root package name */
    protected static final Field f2183c = f();

    /* renamed from: d  reason: collision with root package name */
    protected static final Method f2184d;

    /* renamed from: e  reason: collision with root package name */
    protected static final Method f2185e;

    /* renamed from: f  reason: collision with root package name */
    protected static final Method f2186f;

    /* renamed from: g  reason: collision with root package name */
    private static final Handler f2187g = new Handler(Looper.getMainLooper());

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f2188a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f2189b;

        a(d dVar, Object obj) {
            this.f2188a = dVar;
            this.f2189b = obj;
        }

        public void run() {
            this.f2188a.f2194a = this.f2189b;
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Application f2190a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f2191b;

        b(Application application, d dVar) {
            this.f2190a = application;
            this.f2191b = dVar;
        }

        public void run() {
            this.f2190a.unregisterActivityLifecycleCallbacks(this.f2191b);
        }
    }

    /* renamed from: androidx.core.app.c$c  reason: collision with other inner class name */
    class C0019c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f2192a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f2193b;

        C0019c(Object obj, Object obj2) {
            this.f2192a = obj;
            this.f2193b = obj2;
        }

        public void run() {
            try {
                Method method = c.f2184d;
                if (method != null) {
                    method.invoke(this.f2192a, new Object[]{this.f2193b, Boolean.FALSE, "AppCompat recreation"});
                    return;
                }
                c.f2185e.invoke(this.f2192a, new Object[]{this.f2193b, Boolean.FALSE});
            } catch (RuntimeException e10) {
                if (e10.getClass() == RuntimeException.class && e10.getMessage() != null && e10.getMessage().startsWith("Unable to stop")) {
                    throw e10;
                }
            } catch (Throwable th) {
                Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
            }
        }
    }

    private static final class d implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a  reason: collision with root package name */
        Object f2194a;

        /* renamed from: b  reason: collision with root package name */
        private Activity f2195b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2196c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f2197d = false;

        /* renamed from: e  reason: collision with root package name */
        private boolean f2198e = false;

        /* renamed from: f  reason: collision with root package name */
        private boolean f2199f = false;

        d(Activity activity) {
            this.f2195b = activity;
            this.f2196c = activity.hashCode();
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            if (this.f2195b == activity) {
                this.f2195b = null;
                this.f2198e = true;
            }
        }

        public void onActivityPaused(Activity activity) {
            if (this.f2198e && !this.f2199f && !this.f2197d && c.h(this.f2194a, this.f2196c, activity)) {
                this.f2199f = true;
                this.f2194a = null;
            }
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            if (this.f2195b == activity) {
                this.f2197d = true;
            }
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    static {
        Class<?> a10 = a();
        f2181a = a10;
        f2184d = d(a10);
        f2185e = c(a10);
        f2186f = e(a10);
    }

    private static Class<?> a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method c(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE});
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method d(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE, String.class});
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method e(Class<?> cls) {
        if (g() && cls != null) {
            try {
                Class cls2 = Boolean.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", new Class[]{IBinder.class, List.class, List.class, Integer.TYPE, cls2, Configuration.class, Configuration.class, cls2, cls2});
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static Field f() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean g() {
        int i10 = Build.VERSION.SDK_INT;
        return i10 == 26 || i10 == 27;
    }

    protected static boolean h(Object obj, int i10, Activity activity) {
        try {
            Object obj2 = f2183c.get(activity);
            if (obj2 == obj) {
                if (activity.hashCode() == i10) {
                    f2187g.postAtFrontOfQueue(new C0019c(f2182b.get(activity), obj2));
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    static boolean i(Activity activity) {
        Object obj;
        Application application;
        d dVar;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        } else if (g() && f2186f == null) {
            return false;
        } else {
            if (f2185e == null && f2184d == null) {
                return false;
            }
            try {
                Object obj2 = f2183c.get(activity);
                if (obj2 == null || (obj = f2182b.get(activity)) == null) {
                    return false;
                }
                application = activity.getApplication();
                dVar = new d(activity);
                application.registerActivityLifecycleCallbacks(dVar);
                Handler handler = f2187g;
                handler.post(new a(dVar, obj2));
                if (g()) {
                    Method method = f2186f;
                    Boolean bool = Boolean.FALSE;
                    method.invoke(obj, new Object[]{obj2, null, null, 0, bool, null, null, bool, bool});
                } else {
                    activity.recreate();
                }
                handler.post(new b(application, dVar));
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
    }
}
