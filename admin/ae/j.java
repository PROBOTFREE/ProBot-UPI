package ae;

import java.io.IOException;
import mb.h;
import org.jetbrains.annotations.NotNull;

public final class j extends RuntimeException {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private IOException f19205a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final IOException f19206b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(@NotNull IOException iOException) {
        super(iOException);
        h.e(iOException, "firstConnectException");
        this.f19206b = iOException;
        this.f19205a = iOException;
    }

    public final void a(@NotNull IOException iOException) {
        h.e(iOException, "e");
        b.a(this.f19206b, iOException);
        this.f19205a = iOException;
    }

    @NotNull
    public final IOException b() {
        return this.f19206b;
    }

    @NotNull
    public final IOException c() {
        return this.f19205a;
    }
}
