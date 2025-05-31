package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;

public class d0 {

    /* renamed from: a  reason: collision with root package name */
    private final b f3020a;

    /* renamed from: b  reason: collision with root package name */
    private final f0 f3021b;

    public static class a extends d {

        /* renamed from: c  reason: collision with root package name */
        private static a f3022c;

        /* renamed from: b  reason: collision with root package name */
        private Application f3023b;

        public a(Application application) {
            this.f3023b = application;
        }

        public static a b(Application application) {
            if (f3022c == null) {
                f3022c = new a(application);
            }
            return f3022c;
        }

        public <T extends c0> T create(Class<T> cls) {
            if (!a.class.isAssignableFrom(cls)) {
                return super.create(cls);
            }
            try {
                return (c0) cls.getConstructor(new Class[]{Application.class}).newInstance(new Object[]{this.f3023b});
            } catch (NoSuchMethodException e10) {
                throw new RuntimeException("Cannot create an instance of " + cls, e10);
            } catch (IllegalAccessException e11) {
                throw new RuntimeException("Cannot create an instance of " + cls, e11);
            } catch (InstantiationException e12) {
                throw new RuntimeException("Cannot create an instance of " + cls, e12);
            } catch (InvocationTargetException e13) {
                throw new RuntimeException("Cannot create an instance of " + cls, e13);
            }
        }
    }

    public interface b {
        <T extends c0> T create(Class<T> cls);
    }

    static abstract class c extends e implements b {
        c() {
        }

        public abstract <T extends c0> T b(String str, Class<T> cls);

        public <T extends c0> T create(Class<T> cls) {
            throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
        }
    }

    public static class d implements b {

        /* renamed from: a  reason: collision with root package name */
        private static d f3024a;

        static d a() {
            if (f3024a == null) {
                f3024a = new d();
            }
            return f3024a;
        }

        public <T extends c0> T create(Class<T> cls) {
            try {
                return (c0) cls.newInstance();
            } catch (InstantiationException e10) {
                throw new RuntimeException("Cannot create an instance of " + cls, e10);
            } catch (IllegalAccessException e11) {
                throw new RuntimeException("Cannot create an instance of " + cls, e11);
            }
        }
    }

    static class e {
        e() {
        }

        /* access modifiers changed from: package-private */
        public void a(c0 c0Var) {
        }
    }

    public d0(f0 f0Var, b bVar) {
        this.f3020a = bVar;
        this.f3021b = f0Var;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public d0(g0 g0Var) {
        this(g0Var.getViewModelStore(), g0Var instanceof g ? ((g) g0Var).getDefaultViewModelProviderFactory() : d.a());
    }

    public d0(g0 g0Var, b bVar) {
        this(g0Var.getViewModelStore(), bVar);
    }

    public <T extends c0> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public <T extends c0> T b(String str, Class<T> cls) {
        T b10 = this.f3021b.b(str);
        if (cls.isInstance(b10)) {
            b bVar = this.f3020a;
            if (bVar instanceof e) {
                ((e) bVar).a(b10);
            }
            return b10;
        }
        b bVar2 = this.f3020a;
        T b11 = bVar2 instanceof c ? ((c) bVar2).b(str, cls) : bVar2.create(cls);
        this.f3021b.d(str, b11);
        return b11;
    }
}
