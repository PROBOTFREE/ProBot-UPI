package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.h;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final c f3841a;

    /* renamed from: b  reason: collision with root package name */
    private final SavedStateRegistry f3842b = new SavedStateRegistry();

    private b(c cVar) {
        this.f3841a = cVar;
    }

    public static b a(c cVar) {
        return new b(cVar);
    }

    public SavedStateRegistry b() {
        return this.f3842b;
    }

    public void c(Bundle bundle) {
        h lifecycle = this.f3841a.getLifecycle();
        if (lifecycle.b() == h.c.INITIALIZED) {
            lifecycle.a(new Recreator(this.f3841a));
            this.f3842b.b(lifecycle, bundle);
            return;
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
    }

    public void d(Bundle bundle) {
        this.f3842b.c(bundle);
    }
}
