package androidx.navigation;

import androidx.lifecycle.c0;
import androidx.lifecycle.d0;
import androidx.lifecycle.f0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

class f extends c0 {

    /* renamed from: b  reason: collision with root package name */
    private static final d0.b f3138b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<UUID, f0> f3139a = new HashMap<>();

    class a implements d0.b {
        a() {
        }

        public <T extends c0> T create(Class<T> cls) {
            return new f();
        }
    }

    f() {
    }

    static f b(f0 f0Var) {
        return (f) new d0(f0Var, f3138b).a(f.class);
    }

    /* access modifiers changed from: package-private */
    public void a(UUID uuid) {
        f0 remove = this.f3139a.remove(uuid);
        if (remove != null) {
            remove.a();
        }
    }

    /* access modifiers changed from: package-private */
    public f0 c(UUID uuid) {
        f0 f0Var = this.f3139a.get(uuid);
        if (f0Var != null) {
            return f0Var;
        }
        f0 f0Var2 = new f0();
        this.f3139a.put(uuid, f0Var2);
        return f0Var2;
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        for (f0 a10 : this.f3139a.values()) {
            a10.a();
        }
        this.f3139a.clear();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("NavControllerViewModel{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("} ViewModelStores (");
        Iterator<UUID> it = this.f3139a.keySet().iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(')');
        return sb2.toString();
    }
}
