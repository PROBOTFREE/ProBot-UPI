package androidx.core.view;

import android.view.MotionEvent;

public final class k {
    public static boolean a(MotionEvent motionEvent, int i10) {
        return (motionEvent.getSource() & i10) == i10;
    }
}
