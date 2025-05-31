package ab;

import ab.n;
import mb.h;
import org.jetbrains.annotations.NotNull;

public final class o {
    @NotNull
    public static final Object a(@NotNull Throwable th) {
        h.e(th, "exception");
        return new n.b(th);
    }

    public static final void b(@NotNull Object obj) {
        if (obj instanceof n.b) {
            throw ((n.b) obj).f155a;
        }
    }
}
