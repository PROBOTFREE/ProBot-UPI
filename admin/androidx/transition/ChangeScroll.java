package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class ChangeScroll extends Transition {
    private static final String[] J = {"android:changeScroll:x", "android:changeScroll:y"};

    public ChangeScroll() {
    }

    public ChangeScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void t0(u uVar) {
        uVar.f4164a.put("android:changeScroll:x", Integer.valueOf(uVar.f4165b.getScrollX()));
        uVar.f4164a.put("android:changeScroll:y", Integer.valueOf(uVar.f4165b.getScrollY()));
    }

    public String[] N() {
        return J;
    }

    public void l(u uVar) {
        t0(uVar);
    }

    public void o(u uVar) {
        t0(uVar);
    }

    public Animator s(ViewGroup viewGroup, u uVar, u uVar2) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2 = null;
        if (uVar == null || uVar2 == null) {
            return null;
        }
        View view = uVar2.f4165b;
        int intValue = ((Integer) uVar.f4164a.get("android:changeScroll:x")).intValue();
        int intValue2 = ((Integer) uVar2.f4164a.get("android:changeScroll:x")).intValue();
        int intValue3 = ((Integer) uVar.f4164a.get("android:changeScroll:y")).intValue();
        int intValue4 = ((Integer) uVar2.f4164a.get("android:changeScroll:y")).intValue();
        if (intValue != intValue2) {
            view.setScrollX(intValue);
            objectAnimator = ObjectAnimator.ofInt(view, "scrollX", new int[]{intValue, intValue2});
        } else {
            objectAnimator = null;
        }
        if (intValue3 != intValue4) {
            view.setScrollY(intValue3);
            objectAnimator2 = ObjectAnimator.ofInt(view, "scrollY", new int[]{intValue3, intValue4});
        }
        return t.c(objectAnimator, objectAnimator2);
    }
}
