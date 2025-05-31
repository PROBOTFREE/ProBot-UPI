package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

class b extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    final ActionBarContainer f1044a;

    public b(ActionBarContainer actionBarContainer) {
        this.f1044a = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f1044a;
        if (actionBarContainer.f664h) {
            Drawable drawable = actionBarContainer.f663g;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f661e;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        ActionBarContainer actionBarContainer2 = this.f1044a;
        Drawable drawable3 = actionBarContainer2.f662f;
        if (drawable3 != null && actionBarContainer2.f665i) {
            drawable3.draw(canvas);
        }
    }

    public int getOpacity() {
        return 0;
    }

    public void getOutline(Outline outline) {
        Drawable drawable;
        ActionBarContainer actionBarContainer = this.f1044a;
        if (actionBarContainer.f664h) {
            drawable = actionBarContainer.f663g;
            if (drawable == null) {
                return;
            }
        } else {
            drawable = actionBarContainer.f661e;
            if (drawable == null) {
                return;
            }
        }
        drawable.getOutline(outline);
    }

    public void setAlpha(int i10) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
