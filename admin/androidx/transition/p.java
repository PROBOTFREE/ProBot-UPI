package androidx.transition;

import android.view.ViewGroup;
import x1.b;

public class p {

    /* renamed from: a  reason: collision with root package name */
    private ViewGroup f4140a;

    /* renamed from: b  reason: collision with root package name */
    private Runnable f4141b;

    public static p b(ViewGroup viewGroup) {
        return (p) viewGroup.getTag(b.transition_current_scene);
    }

    static void c(ViewGroup viewGroup, p pVar) {
        viewGroup.setTag(b.transition_current_scene, pVar);
    }

    public void a() {
        Runnable runnable;
        if (b(this.f4140a) == this && (runnable = this.f4141b) != null) {
            runnable.run();
        }
    }
}
