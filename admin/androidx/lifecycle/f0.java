package androidx.lifecycle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class f0 {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<String, c0> f3025a = new HashMap<>();

    public final void a() {
        for (c0 clear : this.f3025a.values()) {
            clear.clear();
        }
        this.f3025a.clear();
    }

    /* access modifiers changed from: package-private */
    public final c0 b(String str) {
        return this.f3025a.get(str);
    }

    /* access modifiers changed from: package-private */
    public Set<String> c() {
        return new HashSet(this.f3025a.keySet());
    }

    /* access modifiers changed from: package-private */
    public final void d(String str, c0 c0Var) {
        c0 put = this.f3025a.put(str, c0Var);
        if (put != null) {
            put.onCleared();
        }
    }
}
