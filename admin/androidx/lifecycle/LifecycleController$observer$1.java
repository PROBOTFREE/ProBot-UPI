package androidx.lifecycle;

import androidx.lifecycle.h;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.a1;
import org.jetbrains.annotations.NotNull;

final class LifecycleController$observer$1 implements m {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f2950a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a1 f2951b;

    public final void c(@NotNull o oVar, @NotNull h.b bVar) {
        mb.h.e(oVar, "source");
        mb.h.e(bVar, "$noName_1");
        if (oVar.getLifecycle().b() == h.c.DESTROYED) {
            a1.a.a(this.f2951b, (CancellationException) null, 1, (Object) null);
            throw null;
        } else if (oVar.getLifecycle().b().compareTo(i.b(this.f2950a)) < 0) {
            i.a(this.f2950a);
            throw null;
        } else {
            i.a(this.f2950a);
            throw null;
        }
    }
}
