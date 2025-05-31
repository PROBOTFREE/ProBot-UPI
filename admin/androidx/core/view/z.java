package androidx.core.view;

import android.os.Build;
import android.view.ViewGroup;
import m0.c;

public final class z {
    public static boolean a(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 21) {
            return viewGroup.isTransitionGroup();
        }
        Boolean bool = (Boolean) viewGroup.getTag(c.tag_transition_group);
        return ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null && x.M(viewGroup) == null) ? false : true;
    }
}
