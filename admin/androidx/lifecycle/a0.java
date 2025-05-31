package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.d0;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.c;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public final class a0 extends d0.c {

    /* renamed from: f  reason: collision with root package name */
    private static final Class<?>[] f3000f;

    /* renamed from: g  reason: collision with root package name */
    private static final Class<?>[] f3001g;

    /* renamed from: a  reason: collision with root package name */
    private final Application f3002a;

    /* renamed from: b  reason: collision with root package name */
    private final d0.b f3003b;

    /* renamed from: c  reason: collision with root package name */
    private final Bundle f3004c;

    /* renamed from: d  reason: collision with root package name */
    private final h f3005d;

    /* renamed from: e  reason: collision with root package name */
    private final SavedStateRegistry f3006e;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Class<?>[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.Class<androidx.lifecycle.z> r0 = androidx.lifecycle.z.class
            r1 = 2
            java.lang.Class[] r1 = new java.lang.Class[r1]
            java.lang.Class<android.app.Application> r2 = android.app.Application.class
            r3 = 0
            r1[r3] = r2
            r2 = 1
            r1[r2] = r0
            f3000f = r1
            java.lang.Class[] r1 = new java.lang.Class[r2]
            r1[r3] = r0
            f3001g = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.a0.<clinit>():void");
    }

    @SuppressLint({"LambdaLast"})
    public a0(Application application, c cVar, Bundle bundle) {
        this.f3006e = cVar.getSavedStateRegistry();
        this.f3005d = cVar.getLifecycle();
        this.f3004c = bundle;
        this.f3002a = application;
        this.f3003b = application != null ? d0.a.b(application) : d0.d.a();
    }

    private static <T> Constructor<T> c(Class<T> cls, Class<?>[] clsArr) {
        for (Constructor<T> constructor : cls.getConstructors()) {
            if (Arrays.equals(clsArr, constructor.getParameterTypes())) {
                return constructor;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a(c0 c0Var) {
        SavedStateHandleController.d(c0Var, this.f3006e, this.f3005d);
    }

    public <T extends c0> T b(String str, Class<T> cls) {
        T newInstance;
        boolean isAssignableFrom = a.class.isAssignableFrom(cls);
        Constructor<T> c10 = (!isAssignableFrom || this.f3002a == null) ? c(cls, f3001g) : c(cls, f3000f);
        if (c10 == null) {
            return this.f3003b.create(cls);
        }
        SavedStateHandleController g10 = SavedStateHandleController.g(this.f3006e, this.f3005d, str, this.f3004c);
        if (isAssignableFrom) {
            try {
                Application application = this.f3002a;
                if (application != null) {
                    newInstance = c10.newInstance(new Object[]{application, g10.h()});
                    T t10 = (c0) newInstance;
                    t10.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", g10);
                    return t10;
                }
            } catch (IllegalAccessException e10) {
                throw new RuntimeException("Failed to access " + cls, e10);
            } catch (InstantiationException e11) {
                throw new RuntimeException("A " + cls + " cannot be instantiated.", e11);
            } catch (InvocationTargetException e12) {
                throw new RuntimeException("An exception happened in constructor of " + cls, e12.getCause());
            }
        }
        newInstance = c10.newInstance(new Object[]{g10.h()});
        T t102 = (c0) newInstance;
        t102.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", g10);
        return t102;
    }

    public <T extends c0> T create(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return b(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
