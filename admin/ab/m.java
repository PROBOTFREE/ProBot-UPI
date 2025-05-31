package ab;

import java.io.Serializable;
import mb.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class m<A, B> implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final A f152a;

    /* renamed from: b  reason: collision with root package name */
    private final B f153b;

    public m(A a10, B b10) {
        this.f152a = a10;
        this.f153b = b10;
    }

    public final A a() {
        return this.f152a;
    }

    public final B b() {
        return this.f153b;
    }

    public final A c() {
        return this.f152a;
    }

    public final B d() {
        return this.f153b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return h.a(this.f152a, mVar.f152a) && h.a(this.f153b, mVar.f153b);
    }

    public int hashCode() {
        A a10 = this.f152a;
        int i10 = 0;
        int hashCode = (a10 != null ? a10.hashCode() : 0) * 31;
        B b10 = this.f153b;
        if (b10 != null) {
            i10 = b10.hashCode();
        }
        return hashCode + i10;
    }

    @NotNull
    public String toString() {
        return '(' + this.f152a + ", " + this.f153b + ')';
    }
}
