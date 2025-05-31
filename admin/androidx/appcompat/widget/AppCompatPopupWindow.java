package androidx.appcompat.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import j.j;

class AppCompatPopupWindow extends PopupWindow {

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f798b = (Build.VERSION.SDK_INT < 21);

    /* renamed from: a  reason: collision with root package name */
    private boolean f799a;

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a(context, attributeSet, i10, 0);
    }

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        a(context, attributeSet, i10, i11);
    }

    private void a(Context context, AttributeSet attributeSet, int i10, int i11) {
        g0 v10 = g0.v(context, attributeSet, j.PopupWindow, i10, i11);
        int i12 = j.PopupWindow_overlapAnchor;
        if (v10.s(i12)) {
            b(v10.a(i12, false));
        }
        setBackgroundDrawable(v10.g(j.PopupWindow_android_popupBackground));
        v10.w();
    }

    private void b(boolean z10) {
        if (f798b) {
            this.f799a = z10;
        } else {
            androidx.core.widget.j.a(this, z10);
        }
    }

    public void showAsDropDown(View view, int i10, int i11) {
        if (f798b && this.f799a) {
            i11 -= view.getHeight();
        }
        super.showAsDropDown(view, i10, i11);
    }

    public void showAsDropDown(View view, int i10, int i11, int i12) {
        if (f798b && this.f799a) {
            i11 -= view.getHeight();
        }
        super.showAsDropDown(view, i10, i11, i12);
    }

    public void update(View view, int i10, int i11, int i12, int i13) {
        if (f798b && this.f799a) {
            i11 -= view.getHeight();
        }
        super.update(view, i10, i11, i12, i13);
    }
}
