package androidx.lifecycle;

import androidx.lifecycle.h;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
final class b {

    /* renamed from: c  reason: collision with root package name */
    static b f3007c = new b();

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, a> f3008a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class<?>, Boolean> f3009b = new HashMap();

    @Deprecated
    static class a {

        /* renamed from: a  reason: collision with root package name */
        final Map<h.b, List<C0029b>> f3010a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        final Map<C0029b, h.b> f3011b;

        a(Map<C0029b, h.b> map) {
            this.f3011b = map;
            for (Map.Entry next : map.entrySet()) {
                h.b bVar = (h.b) next.getValue();
                List list = this.f3010a.get(bVar);
                if (list == null) {
                    list = new ArrayList();
                    this.f3010a.put(bVar, list);
                }
                list.add((C0029b) next.getKey());
            }
        }

        private static void b(List<C0029b> list, o oVar, h.b bVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(oVar, bVar, obj);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(o oVar, h.b bVar, Object obj) {
            b(this.f3010a.get(bVar), oVar, bVar, obj);
            b(this.f3010a.get(h.b.ON_ANY), oVar, bVar, obj);
        }
    }

    @Deprecated
    /* renamed from: androidx.lifecycle.b$b  reason: collision with other inner class name */
    static final class C0029b {

        /* renamed from: a  reason: collision with root package name */
        final int f3012a;

        /* renamed from: b  reason: collision with root package name */
        final Method f3013b;

        C0029b(int i10, Method method) {
            this.f3012a = i10;
            this.f3013b = method;
            method.setAccessible(true);
        }

        /* access modifiers changed from: package-private */
        public void a(o oVar, h.b bVar, Object obj) {
            try {
                int i10 = this.f3012a;
                if (i10 == 0) {
                    this.f3013b.invoke(obj, new Object[0]);
                } else if (i10 == 1) {
                    this.f3013b.invoke(obj, new Object[]{oVar});
                } else if (i10 == 2) {
                    this.f3013b.invoke(obj, new Object[]{oVar, bVar});
                }
            } catch (InvocationTargetException e10) {
                throw new RuntimeException("Failed to call observer method", e10.getCause());
            } catch (IllegalAccessException e11) {
                throw new RuntimeException(e11);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0029b)) {
                return false;
            }
            C0029b bVar = (C0029b) obj;
            return this.f3012a == bVar.f3012a && this.f3013b.getName().equals(bVar.f3013b.getName());
        }

        public int hashCode() {
            return (this.f3012a * 31) + this.f3013b.getName().hashCode();
        }
    }

    b() {
    }

    private a a(Class<?> cls, Method[] methodArr) {
        int i10;
        a c10;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (!(superclass == null || (c10 = c(superclass)) == null)) {
            hashMap.putAll(c10.f3011b);
        }
        for (Class c11 : cls.getInterfaces()) {
            for (Map.Entry next : c(c11).f3011b.entrySet()) {
                e(hashMap, (C0029b) next.getKey(), (h.b) next.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z10 = false;
        for (Method method : methodArr) {
            w wVar = (w) method.getAnnotation(w.class);
            if (wVar != null) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i10 = 0;
                } else if (parameterTypes[0].isAssignableFrom(o.class)) {
                    i10 = 1;
                } else {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                h.b value = wVar.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(h.b.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (value == h.b.ON_ANY) {
                        i10 = 2;
                    } else {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                }
                if (parameterTypes.length <= 2) {
                    e(hashMap, new C0029b(i10, method), value, cls);
                    z10 = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        a aVar = new a(hashMap);
        this.f3008a.put(cls, aVar);
        this.f3009b.put(cls, Boolean.valueOf(z10));
        return aVar;
    }

    private Method[] b(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e10) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e10);
        }
    }

    private void e(Map<C0029b, h.b> map, C0029b bVar, h.b bVar2, Class<?> cls) {
        h.b bVar3 = map.get(bVar);
        if (bVar3 != null && bVar2 != bVar3) {
            Method method = bVar.f3013b;
            throw new IllegalArgumentException("Method " + method.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + bVar3 + ", new value " + bVar2);
        } else if (bVar3 == null) {
            map.put(bVar, bVar2);
        }
    }

    /* access modifiers changed from: package-private */
    public a c(Class<?> cls) {
        a aVar = this.f3008a.get(cls);
        return aVar != null ? aVar : a(cls, (Method[]) null);
    }

    /* access modifiers changed from: package-private */
    public boolean d(Class<?> cls) {
        Boolean bool = this.f3009b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] b10 = b(cls);
        for (Method annotation : b10) {
            if (((w) annotation.getAnnotation(w.class)) != null) {
                a(cls, b10);
                return true;
            }
        }
        this.f3009b.put(cls, Boolean.FALSE);
        return false;
    }
}
