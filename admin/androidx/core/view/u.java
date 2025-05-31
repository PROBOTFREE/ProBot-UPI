package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Objects;

public final class u implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private final View f2390a;

    /* renamed from: b  reason: collision with root package name */
    private ViewTreeObserver f2391b;

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f2392c;

    private u(View view, Runnable runnable) {
        this.f2390a = view;
        this.f2391b = view.getViewTreeObserver();
        this.f2392c = runnable;
    }

    public static u a(View view, Runnable runnable) {
        Objects.requireNonNull(view, "view == null");
        Objects.requireNonNull(runnable, "runnable == null");
        u uVar = new u(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(uVar);
        view.addOnAttachStateChangeListener(uVar);
        return uVar;
    }

    public void b() {
        (this.f2391b.isAlive() ? this.f2391b : this.f2390a.getViewTreeObserver()).removeOnPreDrawListener(this);
        this.f2390a.removeOnAttachStateChangeListener(this);
    }

    public boolean onPreDraw() {
        b();
        this.f2392c.run();
        return true;
    }

    public void onViewAttachedToWindow(View view) {
        this.f2391b = view.getViewTreeObserver();
    }

    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
