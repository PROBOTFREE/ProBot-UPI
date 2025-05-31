package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.q;

@q.b("navigation")
public class k extends q<j> {

    /* renamed from: a  reason: collision with root package name */
    private final r f3195a;

    public k(r rVar) {
        this.f3195a = rVar;
    }

    public boolean e() {
        return true;
    }

    /* renamed from: f */
    public j a() {
        return new j(this);
    }

    /* renamed from: g */
    public i b(j jVar, Bundle bundle, n nVar, q.a aVar) {
        int K = jVar.K();
        if (K != 0) {
            i I = jVar.I(K, false);
            if (I != null) {
                return this.f3195a.e(I.x()).b(I, I.h(bundle), nVar, aVar);
            }
            String J = jVar.J();
            throw new IllegalArgumentException("navigation destination " + J + " is not a direct child of this NavGraph");
        }
        throw new IllegalStateException("no start destination defined via app:startDestination for " + jVar.u());
    }
}
