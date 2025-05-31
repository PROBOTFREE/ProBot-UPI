package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

class d0 implements e0 {

    /* renamed from: a  reason: collision with root package name */
    private final ViewOverlay f4096a;

    d0(View view) {
        this.f4096a = view.getOverlay();
    }

    public void a(Drawable drawable) {
        this.f4096a.add(drawable);
    }

    public void b(Drawable drawable) {
        this.f4096a.remove(drawable);
    }
}
