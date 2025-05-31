package androidx.lifecycle;

import androidx.lifecycle.h;
import db.g;
import java.util.concurrent.CancellationException;
import org.jetbrains.annotations.NotNull;

public final class LifecycleCoroutineScopeImpl extends j implements m {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final h f2952a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final g f2953b;

    public void c(@NotNull o oVar, @NotNull h.b bVar) {
        mb.h.e(oVar, "source");
        mb.h.e(bVar, "event");
        if (f().b().compareTo(h.c.DESTROYED) <= 0) {
            f().c(this);
            e1.d(d(), (CancellationException) null, 1, (Object) null);
        }
    }

    @NotNull
    public g d() {
        return this.f2953b;
    }

    @NotNull
    public h f() {
        return this.f2952a;
    }
}
