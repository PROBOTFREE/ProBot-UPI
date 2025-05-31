package androidx.navigation;

import android.view.View;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

public final class p {
    public static NavController a(View view) {
        NavController b10 = b(view);
        if (b10 != null) {
            return b10;
        }
        throw new IllegalStateException("View " + view + " does not have a NavController set");
    }

    private static NavController b(View view) {
        while (view != null) {
            NavController c10 = c(view);
            if (c10 != null) {
                return c10;
            }
            ViewParent parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    private static NavController c(View view) {
        Object tag = view.getTag(s.nav_controller_view_tag);
        if (tag instanceof WeakReference) {
            tag = ((WeakReference) tag).get();
        } else if (!(tag instanceof NavController)) {
            return null;
        }
        return (NavController) tag;
    }

    public static void d(View view, NavController navController) {
        view.setTag(s.nav_controller_view_tag, navController);
    }
}
