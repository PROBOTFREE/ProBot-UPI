package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.h;
import androidx.lifecycle.m;
import androidx.lifecycle.o;
import androidx.savedstate.Recreator;
import java.util.Map;

@SuppressLint({"RestrictedApi"})
public final class SavedStateRegistry {

    /* renamed from: a  reason: collision with root package name */
    private r.b<String, b> f3835a = new r.b<>();

    /* renamed from: b  reason: collision with root package name */
    private Bundle f3836b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3837c;

    /* renamed from: d  reason: collision with root package name */
    private Recreator.a f3838d;

    /* renamed from: e  reason: collision with root package name */
    boolean f3839e = true;

    public interface a {
        void a(c cVar);
    }

    public interface b {
        Bundle a();
    }

    SavedStateRegistry() {
    }

    public Bundle a(String str) {
        if (this.f3837c) {
            Bundle bundle = this.f3836b;
            if (bundle == null) {
                return null;
            }
            Bundle bundle2 = bundle.getBundle(str);
            this.f3836b.remove(str);
            if (this.f3836b.isEmpty()) {
                this.f3836b = null;
            }
            return bundle2;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
    }

    /* access modifiers changed from: package-private */
    public void b(h hVar, Bundle bundle) {
        if (!this.f3837c) {
            if (bundle != null) {
                this.f3836b = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
            }
            hVar.a(new m() {
                public void c(o oVar, h.b bVar) {
                    SavedStateRegistry savedStateRegistry;
                    boolean z10;
                    if (bVar == h.b.ON_START) {
                        savedStateRegistry = SavedStateRegistry.this;
                        z10 = true;
                    } else if (bVar == h.b.ON_STOP) {
                        savedStateRegistry = SavedStateRegistry.this;
                        z10 = false;
                    } else {
                        return;
                    }
                    savedStateRegistry.f3839e = z10;
                }
            });
            this.f3837c = true;
            return;
        }
        throw new IllegalStateException("SavedStateRegistry was already restored.");
    }

    /* access modifiers changed from: package-private */
    public void c(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f3836b;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        r.b<K, V>.d i10 = this.f3835a.i();
        while (i10.hasNext()) {
            Map.Entry entry = (Map.Entry) i10.next();
            bundle2.putBundle((String) entry.getKey(), ((b) entry.getValue()).a());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }

    public void d(String str, b bVar) {
        if (this.f3835a.u(str, bVar) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public void e(Class<? extends a> cls) {
        if (this.f3839e) {
            if (this.f3838d == null) {
                this.f3838d = new Recreator.a(this);
            }
            try {
                cls.getDeclaredConstructor(new Class[0]);
                this.f3838d.b(cls.getName());
            } catch (NoSuchMethodException e10) {
                throw new IllegalArgumentException("Class" + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e10);
            }
        } else {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }
}
