package ab;

import java.io.Serializable;
import lb.a;
import mb.f;
import mb.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class p<T> implements h<T>, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private a<? extends T> f156a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f157b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f158c;

    public p(@NotNull a<? extends T> aVar, @Nullable Object obj) {
        h.e(aVar, "initializer");
        this.f156a = aVar;
        this.f157b = s.f159a;
        this.f158c = obj == null ? this : obj;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p(a aVar, Object obj, int i10, f fVar) {
        this(aVar, (i10 & 2) != 0 ? null : obj);
    }

    public boolean a() {
        return this.f157b != s.f159a;
    }

    public T getValue() {
        T t10;
        T t11 = this.f157b;
        T t12 = s.f159a;
        if (t11 != t12) {
            return t11;
        }
        synchronized (this.f158c) {
            t10 = this.f157b;
            if (t10 == t12) {
                a aVar = this.f156a;
                h.c(aVar);
                t10 = aVar.b();
                this.f157b = t10;
                this.f156a = null;
            }
        }
        return t10;
    }

    @NotNull
    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
