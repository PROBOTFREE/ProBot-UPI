package androidx.camera.core.impl;

import androidx.camera.core.impl.b;
import java.util.Objects;

final class a<T> extends b.a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final String f1253a;

    /* renamed from: b  reason: collision with root package name */
    private final Class<T> f1254b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f1255c;

    a(String str, Class<T> cls, Object obj) {
        Objects.requireNonNull(str, "Null id");
        this.f1253a = str;
        Objects.requireNonNull(cls, "Null valueClass");
        this.f1254b = cls;
        this.f1255c = obj;
    }

    public String c() {
        return this.f1253a;
    }

    public Object d() {
        return this.f1255c;
    }

    public Class<T> e() {
        return this.f1254b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b.a)) {
            return false;
        }
        b.a aVar = (b.a) obj;
        if (this.f1253a.equals(aVar.c()) && this.f1254b.equals(aVar.e())) {
            Object obj2 = this.f1255c;
            Object d10 = aVar.d();
            if (obj2 == null) {
                if (d10 == null) {
                    return true;
                }
            } else if (obj2.equals(d10)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (((this.f1253a.hashCode() ^ 1000003) * 1000003) ^ this.f1254b.hashCode()) * 1000003;
        Object obj = this.f1255c;
        return hashCode ^ (obj == null ? 0 : obj.hashCode());
    }

    public String toString() {
        return "Option{id=" + this.f1253a + ", valueClass=" + this.f1254b + ", token=" + this.f1255c + "}";
    }
}
