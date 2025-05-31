package ae;

import java.util.LinkedHashSet;
import java.util.Set;
import mb.h;
import org.jetbrains.annotations.NotNull;
import vd.f0;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    private final Set<f0> f19204a = new LinkedHashSet();

    public final synchronized void a(@NotNull f0 f0Var) {
        h.e(f0Var, "route");
        this.f19204a.remove(f0Var);
    }

    public final synchronized void b(@NotNull f0 f0Var) {
        h.e(f0Var, "failedRoute");
        this.f19204a.add(f0Var);
    }

    public final synchronized boolean c(@NotNull f0 f0Var) {
        h.e(f0Var, "route");
        return this.f19204a.contains(f0Var);
    }
}
