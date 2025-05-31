package androidx.transition;

import android.content.Context;
import android.util.AttributeSet;

public class AutoTransition extends TransitionSet {
    public AutoTransition() {
        G0();
    }

    public AutoTransition(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        G0();
    }

    private void G0() {
        D0(1);
        v0(new Fade(2)).v0(new ChangeBounds()).v0(new Fade(1));
    }
}
