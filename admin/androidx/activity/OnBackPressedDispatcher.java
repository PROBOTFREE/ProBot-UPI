package androidx.activity;

import android.annotation.SuppressLint;
import androidx.lifecycle.h;
import androidx.lifecycle.m;
import androidx.lifecycle.o;
import java.util.ArrayDeque;
import java.util.Iterator;

public final class OnBackPressedDispatcher {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f188a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayDeque<b> f189b = new ArrayDeque<>();

    private class LifecycleOnBackPressedCancellable implements m, a {

        /* renamed from: a  reason: collision with root package name */
        private final h f190a;

        /* renamed from: b  reason: collision with root package name */
        private final b f191b;

        /* renamed from: c  reason: collision with root package name */
        private a f192c;

        LifecycleOnBackPressedCancellable(h hVar, b bVar) {
            this.f190a = hVar;
            this.f191b = bVar;
            hVar.a(this);
        }

        public void c(o oVar, h.b bVar) {
            if (bVar == h.b.ON_START) {
                this.f192c = OnBackPressedDispatcher.this.b(this.f191b);
            } else if (bVar == h.b.ON_STOP) {
                a aVar = this.f192c;
                if (aVar != null) {
                    aVar.cancel();
                }
            } else if (bVar == h.b.ON_DESTROY) {
                cancel();
            }
        }

        public void cancel() {
            this.f190a.c(this);
            this.f191b.removeCancellable(this);
            a aVar = this.f192c;
            if (aVar != null) {
                aVar.cancel();
                this.f192c = null;
            }
        }
    }

    private class a implements a {

        /* renamed from: a  reason: collision with root package name */
        private final b f194a;

        a(b bVar) {
            this.f194a = bVar;
        }

        public void cancel() {
            OnBackPressedDispatcher.this.f189b.remove(this.f194a);
            this.f194a.removeCancellable(this);
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f188a = runnable;
    }

    @SuppressLint({"LambdaLast"})
    public void a(o oVar, b bVar) {
        h lifecycle = oVar.getLifecycle();
        if (lifecycle.b() != h.c.DESTROYED) {
            bVar.addCancellable(new LifecycleOnBackPressedCancellable(lifecycle, bVar));
        }
    }

    /* access modifiers changed from: package-private */
    public a b(b bVar) {
        this.f189b.add(bVar);
        a aVar = new a(bVar);
        bVar.addCancellable(aVar);
        return aVar;
    }

    public void c() {
        Iterator<b> descendingIterator = this.f189b.descendingIterator();
        while (descendingIterator.hasNext()) {
            b next = descendingIterator.next();
            if (next.isEnabled()) {
                next.handleOnBackPressed();
                return;
            }
        }
        Runnable runnable = this.f188a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
