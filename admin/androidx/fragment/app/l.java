package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.c0;
import androidx.lifecycle.d0;
import androidx.lifecycle.f0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

final class l extends c0 {

    /* renamed from: h  reason: collision with root package name */
    private static final d0.b f2798h = new a();

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<String, Fragment> f2799a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, l> f2800b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, f0> f2801c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private final boolean f2802d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f2803e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f2804f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f2805g = false;

    class a implements d0.b {
        a() {
        }

        public <T extends c0> T create(Class<T> cls) {
            return new l(true);
        }
    }

    l(boolean z10) {
        this.f2802d = z10;
    }

    static l e(f0 f0Var) {
        return (l) new d0(f0Var, f2798h).a(l.class);
    }

    /* access modifiers changed from: package-private */
    public void a(Fragment fragment) {
        if (this.f2805g) {
            if (FragmentManager.H0(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else if (!this.f2799a.containsKey(fragment.mWho)) {
            this.f2799a.put(fragment.mWho, fragment);
            if (FragmentManager.H0(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Fragment fragment) {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        l lVar = this.f2800b.get(fragment.mWho);
        if (lVar != null) {
            lVar.onCleared();
            this.f2800b.remove(fragment.mWho);
        }
        f0 f0Var = this.f2801c.get(fragment.mWho);
        if (f0Var != null) {
            f0Var.a();
            this.f2801c.remove(fragment.mWho);
        }
    }

    /* access modifiers changed from: package-private */
    public Fragment c(String str) {
        return this.f2799a.get(str);
    }

    /* access modifiers changed from: package-private */
    public l d(Fragment fragment) {
        l lVar = this.f2800b.get(fragment.mWho);
        if (lVar != null) {
            return lVar;
        }
        l lVar2 = new l(this.f2802d);
        this.f2800b.put(fragment.mWho, lVar2);
        return lVar2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        return this.f2799a.equals(lVar.f2799a) && this.f2800b.equals(lVar.f2800b) && this.f2801c.equals(lVar.f2801c);
    }

    /* access modifiers changed from: package-private */
    public Collection<Fragment> f() {
        return new ArrayList(this.f2799a.values());
    }

    /* access modifiers changed from: package-private */
    public f0 g(Fragment fragment) {
        f0 f0Var = this.f2801c.get(fragment.mWho);
        if (f0Var != null) {
            return f0Var;
        }
        f0 f0Var2 = new f0();
        this.f2801c.put(fragment.mWho, f0Var2);
        return f0Var2;
    }

    /* access modifiers changed from: package-private */
    public boolean h() {
        return this.f2803e;
    }

    public int hashCode() {
        return (((this.f2799a.hashCode() * 31) + this.f2800b.hashCode()) * 31) + this.f2801c.hashCode();
    }

    /* access modifiers changed from: package-private */
    public void i(Fragment fragment) {
        if (!this.f2805g) {
            if ((this.f2799a.remove(fragment.mWho) != null) && FragmentManager.H0(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
            }
        } else if (FragmentManager.H0(2)) {
            Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
        }
    }

    /* access modifiers changed from: package-private */
    public void j(boolean z10) {
        this.f2805g = z10;
    }

    /* access modifiers changed from: package-private */
    public boolean k(Fragment fragment) {
        if (!this.f2799a.containsKey(fragment.mWho)) {
            return true;
        }
        return this.f2802d ? this.f2803e : !this.f2804f;
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f2803e = true;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("FragmentManagerViewModel{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("} Fragments (");
        Iterator<Fragment> it = this.f2799a.values().iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") Child Non Config (");
        Iterator<String> it2 = this.f2800b.keySet().iterator();
        while (it2.hasNext()) {
            sb2.append(it2.next());
            if (it2.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") ViewModelStores (");
        Iterator<String> it3 = this.f2801c.keySet().iterator();
        while (it3.hasNext()) {
            sb2.append(it3.next());
            if (it3.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(')');
        return sb2.toString();
    }
}
