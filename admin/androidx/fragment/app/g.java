package androidx.fragment.app;

import androidx.fragment.app.Fragment;
import java.lang.reflect.InvocationTargetException;

public class g {
    private static final c0.g<ClassLoader, c0.g<String, Class<?>>> sClassCacheMap = new c0.g<>();

    static boolean isFragmentClass(ClassLoader classLoader, String str) {
        try {
            return Fragment.class.isAssignableFrom(loadClass(classLoader, str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static Class<?> loadClass(ClassLoader classLoader, String str) {
        c0.g<ClassLoader, c0.g<String, Class<?>>> gVar = sClassCacheMap;
        c0.g gVar2 = gVar.get(classLoader);
        if (gVar2 == null) {
            gVar2 = new c0.g();
            gVar.put(classLoader, gVar2);
        }
        Class<?> cls = (Class) gVar2.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        gVar2.put(str, cls2);
        return cls2;
    }

    public static Class<? extends Fragment> loadFragmentClass(ClassLoader classLoader, String str) {
        try {
            return loadClass(classLoader, str);
        } catch (ClassNotFoundException e10) {
            throw new Fragment.j("Unable to instantiate fragment " + str + ": make sure class name exists", e10);
        } catch (ClassCastException e11) {
            throw new Fragment.j("Unable to instantiate fragment " + str + ": make sure class is a valid subclass of Fragment", e11);
        }
    }

    public Fragment instantiate(ClassLoader classLoader, String str) {
        try {
            return (Fragment) loadFragmentClass(classLoader, str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (InstantiationException e10) {
            throw new Fragment.j("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e10);
        } catch (IllegalAccessException e11) {
            throw new Fragment.j("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e11);
        } catch (NoSuchMethodException e12) {
            throw new Fragment.j("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e12);
        } catch (InvocationTargetException e13) {
            throw new Fragment.j("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e13);
        }
    }
}
