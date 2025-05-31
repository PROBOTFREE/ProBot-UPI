package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.h;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.c;

final class SavedStateHandleController implements m {

    /* renamed from: a  reason: collision with root package name */
    private final String f2990a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f2991b = false;

    /* renamed from: c  reason: collision with root package name */
    private final z f2992c;

    static final class a implements SavedStateRegistry.a {
        a() {
        }

        public void a(c cVar) {
            if (cVar instanceof g0) {
                f0 viewModelStore = ((g0) cVar).getViewModelStore();
                SavedStateRegistry savedStateRegistry = cVar.getSavedStateRegistry();
                for (String b10 : viewModelStore.c()) {
                    SavedStateHandleController.d(viewModelStore.b(b10), savedStateRegistry, cVar.getLifecycle());
                }
                if (!viewModelStore.c().isEmpty()) {
                    savedStateRegistry.e(a.class);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error: OnRecreation should be registered only on componentsthat implement ViewModelStoreOwner");
        }
    }

    SavedStateHandleController(String str, z zVar) {
        this.f2990a = str;
        this.f2992c = zVar;
    }

    static void d(c0 c0Var, SavedStateRegistry savedStateRegistry, h hVar) {
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) c0Var.getTag("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController != null && !savedStateHandleController.i()) {
            savedStateHandleController.f(savedStateRegistry, hVar);
            j(savedStateRegistry, hVar);
        }
    }

    static SavedStateHandleController g(SavedStateRegistry savedStateRegistry, h hVar, String str, Bundle bundle) {
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, z.a(savedStateRegistry.a(str), bundle));
        savedStateHandleController.f(savedStateRegistry, hVar);
        j(savedStateRegistry, hVar);
        return savedStateHandleController;
    }

    private static void j(final SavedStateRegistry savedStateRegistry, final h hVar) {
        h.c b10 = hVar.b();
        if (b10 == h.c.INITIALIZED || b10.a(h.c.STARTED)) {
            savedStateRegistry.e(a.class);
        } else {
            hVar.a(new m() {
                public void c(o oVar, h.b bVar) {
                    if (bVar == h.b.ON_START) {
                        h.this.c(this);
                        savedStateRegistry.e(a.class);
                    }
                }
            });
        }
    }

    public void c(o oVar, h.b bVar) {
        if (bVar == h.b.ON_DESTROY) {
            this.f2991b = false;
            oVar.getLifecycle().c(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void f(SavedStateRegistry savedStateRegistry, h hVar) {
        if (!this.f2991b) {
            this.f2991b = true;
            hVar.a(this);
            savedStateRegistry.d(this.f2990a, this.f2992c.b());
            return;
        }
        throw new IllegalStateException("Already attached to lifecycleOwner");
    }

    /* access modifiers changed from: package-private */
    public z h() {
        return this.f2992c;
    }

    /* access modifiers changed from: package-private */
    public boolean i() {
        return this.f2991b;
    }
}
