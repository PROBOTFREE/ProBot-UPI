package androidx.lifecycle;

import ab.n;
import ab.o;
import androidx.lifecycle.h;
import lb.a;
import org.jetbrains.annotations.NotNull;

public final class WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 implements m {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h.c f2996a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ h f2997b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ kotlinx.coroutines.h<Object> f2998c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ a<Object> f2999d;

    public void c(@NotNull o oVar, @NotNull h.b bVar) {
        Object obj;
        kotlinx.coroutines.h<Object> hVar;
        k th;
        mb.h.e(oVar, "source");
        mb.h.e(bVar, "event");
        if (bVar == h.b.f(this.f2996a)) {
            this.f2997b.c(this);
            hVar = this.f2998c;
            a<Object> aVar = this.f2999d;
            try {
                n.a aVar2 = n.f154a;
                obj = n.a(aVar.b());
            } catch (Throwable th2) {
                th = th2;
            }
        } else if (bVar == h.b.ON_DESTROY) {
            this.f2997b.c(this);
            hVar = this.f2998c;
            th = new k();
            n.a aVar3 = n.f154a;
            obj = n.a(o.a(th));
        } else {
            return;
        }
        hVar.e(obj);
    }
}
