package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

class i {

    /* renamed from: a  reason: collision with root package name */
    private static Field f403a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f404b;

    /* renamed from: c  reason: collision with root package name */
    private static Class<?> f405c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f406d;

    /* renamed from: e  reason: collision with root package name */
    private static Field f407e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f408f;

    /* renamed from: g  reason: collision with root package name */
    private static Field f409g;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f410h;

    static void a(Resources resources) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 28) {
            if (i10 >= 24) {
                d(resources);
            } else if (i10 >= 23) {
                c(resources);
            } else if (i10 >= 21) {
                b(resources);
            }
        }
    }

    private static void b(Resources resources) {
        if (!f404b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f403a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e10) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e10);
            }
            f404b = true;
        }
        Field field = f403a;
        if (field != null) {
            Map map = null;
            try {
                map = (Map) field.get(resources);
            } catch (IllegalAccessException e11) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e11);
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    private static void c(Resources resources) {
        if (!f404b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f403a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e10) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e10);
            }
            f404b = true;
        }
        Object obj = null;
        Field field = f403a;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e11) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e11);
            }
        }
        if (obj != null) {
            e(obj);
        }
    }

    private static void d(Resources resources) {
        Object obj;
        if (!f410h) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                f409g = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e10) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e10);
            }
            f410h = true;
        }
        Field field = f409g;
        if (field != null) {
            Object obj2 = null;
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e11) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e11);
                obj = null;
            }
            if (obj != null) {
                if (!f404b) {
                    try {
                        Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                        f403a = declaredField2;
                        declaredField2.setAccessible(true);
                    } catch (NoSuchFieldException e12) {
                        Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e12);
                    }
                    f404b = true;
                }
                Field field2 = f403a;
                if (field2 != null) {
                    try {
                        obj2 = field2.get(obj);
                    } catch (IllegalAccessException e13) {
                        Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e13);
                    }
                }
                if (obj2 != null) {
                    e(obj2);
                }
            }
        }
    }

    private static void e(Object obj) {
        if (!f406d) {
            try {
                f405c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e10) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e10);
            }
            f406d = true;
        }
        Class<?> cls = f405c;
        if (cls != null) {
            if (!f408f) {
                try {
                    Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                    f407e = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e11) {
                    Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e11);
                }
                f408f = true;
            }
            Field field = f407e;
            if (field != null) {
                LongSparseArray longSparseArray = null;
                try {
                    longSparseArray = (LongSparseArray) field.get(obj);
                } catch (IllegalAccessException e12) {
                    Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e12);
                }
                if (longSparseArray != null) {
                    longSparseArray.clear();
                }
            }
        }
    }
}
