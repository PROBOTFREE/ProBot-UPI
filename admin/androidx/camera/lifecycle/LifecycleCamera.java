package androidx.camera.lifecycle;

import androidx.lifecycle.h;
import androidx.lifecycle.n;
import androidx.lifecycle.o;
import androidx.lifecycle.w;

final class LifecycleCamera implements n {

    /* renamed from: a  reason: collision with root package name */
    private final Object f1265a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1266b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1267c;

    @w(h.b.ON_DESTROY)
    public void onDestroy(o oVar) {
        synchronized (this.f1265a) {
            throw null;
        }
    }

    @w(h.b.ON_START)
    public void onStart(o oVar) {
        synchronized (this.f1265a) {
            if (!this.f1266b) {
                if (!this.f1267c) {
                    throw null;
                }
            }
        }
    }

    @w(h.b.ON_STOP)
    public void onStop(o oVar) {
        synchronized (this.f1265a) {
            if (!this.f1266b) {
                if (!this.f1267c) {
                    throw null;
                }
            }
        }
    }
}
