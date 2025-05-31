package androidx.lifecycle;

import android.os.Handler;
import androidx.lifecycle.h;

public class b0 {

    /* renamed from: a  reason: collision with root package name */
    private final p f3014a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f3015b = new Handler();

    /* renamed from: c  reason: collision with root package name */
    private a f3016c;

    static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final p f3017a;

        /* renamed from: b  reason: collision with root package name */
        final h.b f3018b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f3019c = false;

        a(p pVar, h.b bVar) {
            this.f3017a = pVar;
            this.f3018b = bVar;
        }

        public void run() {
            if (!this.f3019c) {
                this.f3017a.h(this.f3018b);
                this.f3019c = true;
            }
        }
    }

    public b0(o oVar) {
        this.f3014a = new p(oVar);
    }

    private void f(h.b bVar) {
        a aVar = this.f3016c;
        if (aVar != null) {
            aVar.run();
        }
        a aVar2 = new a(this.f3014a, bVar);
        this.f3016c = aVar2;
        this.f3015b.postAtFrontOfQueue(aVar2);
    }

    public h a() {
        return this.f3014a;
    }

    public void b() {
        f(h.b.ON_START);
    }

    public void c() {
        f(h.b.ON_CREATE);
    }

    public void d() {
        f(h.b.ON_STOP);
        f(h.b.ON_DESTROY);
    }

    public void e() {
        f(h.b.ON_START);
    }
}
