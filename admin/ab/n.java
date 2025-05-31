package ab;

import java.io.Serializable;
import mb.f;
import mb.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class n<T> implements Serializable {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f154a = new a((f) null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public static final class b implements Serializable {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f155a;

        public b(@NotNull Throwable th) {
            h.e(th, "exception");
            this.f155a = th;
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof b) && h.a(this.f155a, ((b) obj).f155a);
        }

        public int hashCode() {
            return this.f155a.hashCode();
        }

        @NotNull
        public String toString() {
            return "Failure(" + this.f155a + ')';
        }
    }

    @NotNull
    public static Object a(@Nullable Object obj) {
        return obj;
    }

    @Nullable
    public static final Throwable b(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).f155a;
        }
        return null;
    }

    public static final boolean c(Object obj) {
        return obj instanceof b;
    }

    public static final boolean d(Object obj) {
        return !(obj instanceof b);
    }
}
