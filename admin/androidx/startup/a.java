package androidx.startup;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import v1.b;
import v1.c;

public final class a {

    /* renamed from: d  reason: collision with root package name */
    private static volatile a f3877d;

    /* renamed from: e  reason: collision with root package name */
    private static final Object f3878e = new Object();

    /* renamed from: a  reason: collision with root package name */
    final Map<Class<?>, Object> f3879a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    final Set<Class<? extends v1.a<?>>> f3880b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    final Context f3881c;

    a(Context context) {
        this.f3881c = context.getApplicationContext();
    }

    public static a c(Context context) {
        if (f3877d == null) {
            synchronized (f3878e) {
                if (f3877d == null) {
                    f3877d = new a(context);
                }
            }
        }
        return f3877d;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        try {
            w1.a.a("Startup");
            Bundle bundle = this.f3881c.getPackageManager().getProviderInfo(new ComponentName(this.f3881c.getPackageName(), InitializationProvider.class.getName()), 128).metaData;
            String string = this.f3881c.getString(b.androidx_startup);
            if (bundle != null) {
                HashSet hashSet = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, (String) null))) {
                        Class<?> cls = Class.forName(str);
                        if (v1.a.class.isAssignableFrom(cls)) {
                            this.f3880b.add(cls);
                            b(cls, hashSet);
                        }
                    }
                }
            }
            w1.a.b();
        } catch (PackageManager.NameNotFoundException | ClassNotFoundException e10) {
            throw new c(e10);
        } catch (Throwable th) {
            w1.a.b();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public <T> T b(Class<? extends v1.a<?>> cls, Set<Class<?>> set) {
        T t10;
        synchronized (f3878e) {
            if (w1.a.d()) {
                try {
                    w1.a.a(cls.getSimpleName());
                } catch (Throwable th) {
                    w1.a.b();
                    throw th;
                }
            }
            if (!set.contains(cls)) {
                if (!this.f3879a.containsKey(cls)) {
                    set.add(cls);
                    v1.a aVar = (v1.a) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    List<Class<? extends v1.a<?>>> a10 = aVar.a();
                    if (!a10.isEmpty()) {
                        for (Class next : a10) {
                            if (!this.f3879a.containsKey(next)) {
                                b(next, set);
                            }
                        }
                    }
                    t10 = aVar.b(this.f3881c);
                    set.remove(cls);
                    this.f3879a.put(cls, t10);
                } else {
                    t10 = this.f3879a.get(cls);
                }
                w1.a.b();
            } else {
                throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", new Object[]{cls.getName()}));
            }
        }
        return t10;
    }
}
