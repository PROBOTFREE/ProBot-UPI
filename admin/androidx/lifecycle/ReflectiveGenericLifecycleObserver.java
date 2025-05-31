package androidx.lifecycle;

import androidx.lifecycle.b;
import androidx.lifecycle.h;

@Deprecated
class ReflectiveGenericLifecycleObserver implements m {

    /* renamed from: a  reason: collision with root package name */
    private final Object f2973a;

    /* renamed from: b  reason: collision with root package name */
    private final b.a f2974b;

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.f2973a = obj;
        this.f2974b = b.f3007c.c(obj.getClass());
    }

    public void c(o oVar, h.b bVar) {
        this.f2974b.a(oVar, bVar, this.f2973a);
    }
}
