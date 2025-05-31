package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class s {

    /* renamed from: a  reason: collision with root package name */
    private static Map<Class<?>, Integer> f3046a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static Map<Class<?>, List<Constructor<? extends f>>> f3047b = new HashMap();

    private static f a(Constructor<? extends f> constructor, Object obj) {
        try {
            return (f) constructor.newInstance(new Object[]{obj});
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(e10);
        } catch (InstantiationException e11) {
            throw new RuntimeException(e11);
        } catch (InvocationTargetException e12) {
            throw new RuntimeException(e12);
        }
    }

    private static Constructor<? extends f> b(Class<?> cls) {
        try {
            Package packageR = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = packageR != null ? packageR.getName() : "";
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            String c10 = c(canonicalName);
            if (!name.isEmpty()) {
                c10 = name + "." + c10;
            }
            Constructor<?> declaredConstructor = Class.forName(c10).getDeclaredConstructor(new Class[]{cls});
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static String c(String str) {
        return str.replace(".", "_") + "_LifecycleAdapter";
    }

    private static int d(Class<?> cls) {
        Integer num = f3046a.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int g10 = g(cls);
        f3046a.put(cls, Integer.valueOf(g10));
        return g10;
    }

    private static boolean e(Class<?> cls) {
        return cls != null && n.class.isAssignableFrom(cls);
    }

    static m f(Object obj) {
        boolean z10 = obj instanceof m;
        boolean z11 = obj instanceof e;
        if (z10 && z11) {
            return new FullLifecycleObserverAdapter((e) obj, (m) obj);
        }
        if (z11) {
            return new FullLifecycleObserverAdapter((e) obj, (m) null);
        }
        if (z10) {
            return (m) obj;
        }
        Class<?> cls = obj.getClass();
        if (d(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        List list = f3047b.get(cls);
        if (list.size() == 1) {
            return new SingleGeneratedAdapterObserver(a((Constructor) list.get(0), obj));
        }
        f[] fVarArr = new f[list.size()];
        for (int i10 = 0; i10 < list.size(); i10++) {
            fVarArr[i10] = a((Constructor) list.get(i10), obj);
        }
        return new CompositeGeneratedAdaptersObserver(fVarArr);
    }

    private static int g(Class<?> cls) {
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends f> b10 = b(cls);
        if (b10 != null) {
            f3047b.put(cls, Collections.singletonList(b10));
            return 2;
        } else if (b.f3007c.d(cls)) {
            return 1;
        } else {
            Class<? super Object> superclass = cls.getSuperclass();
            ArrayList arrayList = null;
            if (e(superclass)) {
                if (d(superclass) == 1) {
                    return 1;
                }
                arrayList = new ArrayList(f3047b.get(superclass));
            }
            for (Class cls2 : cls.getInterfaces()) {
                if (e(cls2)) {
                    if (d(cls2) == 1) {
                        return 1;
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.addAll(f3047b.get(cls2));
                }
            }
            if (arrayList == null) {
                return 1;
            }
            f3047b.put(cls, arrayList);
            return 2;
        }
    }
}
