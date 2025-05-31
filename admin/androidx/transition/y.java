package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

class y implements z {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroupOverlay f4180a;

    y(ViewGroup viewGroup) {
        this.f4180a = viewGroup.getOverlay();
    }

    public void a(Drawable drawable) {
        this.f4180a.add(drawable);
    }

    public void b(Drawable drawable) {
        this.f4180a.remove(drawable);
    }

    public void c(View view) {
        this.f4180a.add(view);
    }

    public void d(View view) {
        this.f4180a.remove(view);
    }
}
