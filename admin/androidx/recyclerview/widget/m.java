package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.os.Build;
import android.view.View;
import androidx.core.view.x;
import p1.c;

class m implements l {

    /* renamed from: a  reason: collision with root package name */
    static final l f3670a = new m();

    m() {
    }

    private static float e(RecyclerView recyclerView, View view) {
        int childCount = recyclerView.getChildCount();
        float f10 = 0.0f;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = recyclerView.getChildAt(i10);
            if (childAt != view) {
                float w10 = x.w(childAt);
                if (w10 > f10) {
                    f10 = w10;
                }
            }
        }
        return f10;
    }

    public void a(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            int i10 = c.item_touch_helper_previous_elevation;
            Object tag = view.getTag(i10);
            if (tag instanceof Float) {
                x.y0(view, ((Float) tag).floatValue());
            }
            view.setTag(i10, (Object) null);
        }
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }

    public void b(View view) {
    }

    public void c(Canvas canvas, RecyclerView recyclerView, View view, float f10, float f11, int i10, boolean z10) {
    }

    public void d(Canvas canvas, RecyclerView recyclerView, View view, float f10, float f11, int i10, boolean z10) {
        if (Build.VERSION.SDK_INT >= 21 && z10) {
            int i11 = c.item_touch_helper_previous_elevation;
            if (view.getTag(i11) == null) {
                Float valueOf = Float.valueOf(x.w(view));
                x.y0(view, e(recyclerView, view) + 1.0f);
                view.setTag(i11, valueOf);
            }
        }
        view.setTranslationX(f10);
        view.setTranslationY(f11);
    }
}
