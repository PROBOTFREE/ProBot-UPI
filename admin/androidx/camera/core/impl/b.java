package androidx.camera.core.impl;

import java.util.Set;

public interface b {

    public static abstract class a<T> {
        a() {
        }

        public static <T> a<T> a(String str, Class<?> cls) {
            return b(str, cls, (Object) null);
        }

        public static <T> a<T> b(String str, Class<?> cls, Object obj) {
            return new a(str, cls, obj);
        }

        public abstract String c();

        public abstract Object d();

        public abstract Class<T> e();
    }

    /* renamed from: androidx.camera.core.impl.b$b  reason: collision with other inner class name */
    public enum C0010b {
        ALWAYS_OVERRIDE,
        REQUIRED,
        OPTIONAL
    }

    static boolean d(C0010b bVar, C0010b bVar2) {
        C0010b bVar3 = C0010b.ALWAYS_OVERRIDE;
        if (bVar == bVar3 && bVar2 == bVar3) {
            return true;
        }
        C0010b bVar4 = C0010b.REQUIRED;
        return bVar == bVar4 && bVar2 == bVar4;
    }

    Set<C0010b> a(a<?> aVar);

    <ValueT> ValueT b(a<ValueT> aVar, C0010b bVar);

    Set<a<?>> c();

    <ValueT> ValueT g(a<ValueT> aVar, ValueT valuet);
}
