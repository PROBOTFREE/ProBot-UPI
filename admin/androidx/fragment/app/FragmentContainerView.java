package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.core.view.f0;
import androidx.core.view.x;
import g1.c;
import java.util.ArrayList;

public final class FragmentContainerView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<View> f2638a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<View> f2639b;

    /* renamed from: c  reason: collision with root package name */
    private View.OnApplyWindowInsetsListener f2640c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2641d;

    public FragmentContainerView(Context context) {
        super(context);
        this.f2641d = true;
    }

    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FragmentContainerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        String str;
        this.f2641d = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.FragmentContainerView);
            if (classAttribute == null) {
                classAttribute = obtainStyledAttributes.getString(c.FragmentContainerView_android_name);
                str = "android:name";
            } else {
                str = "class";
            }
            obtainStyledAttributes.recycle();
            if (classAttribute != null && !isInEditMode()) {
                throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + "\"");
            }
        }
    }

    FragmentContainerView(Context context, AttributeSet attributeSet, FragmentManager fragmentManager) {
        super(context, attributeSet);
        String str;
        this.f2641d = true;
        String classAttribute = attributeSet.getClassAttribute();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.FragmentContainerView);
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(c.FragmentContainerView_android_name) : classAttribute;
        String string = obtainStyledAttributes.getString(c.FragmentContainerView_android_tag);
        obtainStyledAttributes.recycle();
        int id2 = getId();
        Fragment i02 = fragmentManager.i0(id2);
        if (classAttribute != null && i02 == null) {
            if (id2 <= 0) {
                if (string != null) {
                    str = " with tag " + string;
                } else {
                    str = "";
                }
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + classAttribute + str);
            }
            Fragment instantiate = fragmentManager.s0().instantiate(context.getClassLoader(), classAttribute);
            instantiate.onInflate(context, attributeSet, (Bundle) null);
            fragmentManager.m().w(true).d(this, instantiate, string).m();
        }
        fragmentManager.W0(this);
    }

    private void a(View view) {
        ArrayList<View> arrayList = this.f2639b;
        if (arrayList != null && arrayList.contains(view)) {
            if (this.f2638a == null) {
                this.f2638a = new ArrayList<>();
            }
            this.f2638a.add(view);
        }
    }

    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (FragmentManager.B0(view) != null) {
            super.addView(view, i10, layoutParams);
            return;
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    /* access modifiers changed from: protected */
    public boolean addViewInLayout(View view, int i10, ViewGroup.LayoutParams layoutParams, boolean z10) {
        if (FragmentManager.B0(view) != null) {
            return super.addViewInLayout(view, i10, layoutParams, z10);
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        f0 x10 = f0.x(windowInsets);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f2640c;
        f0 x11 = onApplyWindowInsetsListener != null ? f0.x(onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets)) : x.c0(this, x10);
        if (!x11.q()) {
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                x.h(getChildAt(i10), x11);
            }
        }
        return windowInsets;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (this.f2641d && this.f2638a != null) {
            for (int i10 = 0; i10 < this.f2638a.size(); i10++) {
                super.drawChild(canvas, this.f2638a.get(i10), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j10) {
        ArrayList<View> arrayList;
        if (!this.f2641d || (arrayList = this.f2638a) == null || arrayList.size() <= 0 || !this.f2638a.contains(view)) {
            return super.drawChild(canvas, view, j10);
        }
        return false;
    }

    public void endViewTransition(View view) {
        ArrayList<View> arrayList = this.f2639b;
        if (arrayList != null) {
            arrayList.remove(view);
            ArrayList<View> arrayList2 = this.f2638a;
            if (arrayList2 != null && arrayList2.remove(view)) {
                this.f2641d = true;
            }
        }
        super.endViewTransition(view);
    }

    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        return windowInsets;
    }

    public void removeAllViewsInLayout() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            a(getChildAt(childCount));
        }
        super.removeAllViewsInLayout();
    }

    /* access modifiers changed from: protected */
    public void removeDetachedView(View view, boolean z10) {
        if (z10) {
            a(view);
        }
        super.removeDetachedView(view, z10);
    }

    public void removeView(View view) {
        a(view);
        super.removeView(view);
    }

    public void removeViewAt(int i10) {
        a(getChildAt(i10));
        super.removeViewAt(i10);
    }

    public void removeViewInLayout(View view) {
        a(view);
        super.removeViewInLayout(view);
    }

    public void removeViews(int i10, int i11) {
        for (int i12 = i10; i12 < i10 + i11; i12++) {
            a(getChildAt(i12));
        }
        super.removeViews(i10, i11);
    }

    public void removeViewsInLayout(int i10, int i11) {
        for (int i12 = i10; i12 < i10 + i11; i12++) {
            a(getChildAt(i12));
        }
        super.removeViewsInLayout(i10, i11);
    }

    /* access modifiers changed from: package-private */
    public void setDrawDisappearingViewsLast(boolean z10) {
        this.f2641d = z10;
    }

    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (Build.VERSION.SDK_INT < 18) {
            super.setLayoutTransition(layoutTransition);
            return;
        }
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.f2640c = onApplyWindowInsetsListener;
    }

    public void startViewTransition(View view) {
        if (view.getParent() == this) {
            if (this.f2639b == null) {
                this.f2639b = new ArrayList<>();
            }
            this.f2639b.add(view);
        }
        super.startViewTransition(view);
    }
}
