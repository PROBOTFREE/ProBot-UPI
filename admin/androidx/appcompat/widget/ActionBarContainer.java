package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.x;
import j.f;
import j.j;

public class ActionBarContainer extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private boolean f657a;

    /* renamed from: b  reason: collision with root package name */
    private View f658b;

    /* renamed from: c  reason: collision with root package name */
    private View f659c;

    /* renamed from: d  reason: collision with root package name */
    private View f660d;

    /* renamed from: e  reason: collision with root package name */
    Drawable f661e;

    /* renamed from: f  reason: collision with root package name */
    Drawable f662f;

    /* renamed from: g  reason: collision with root package name */
    Drawable f663g;

    /* renamed from: h  reason: collision with root package name */
    boolean f664h;

    /* renamed from: i  reason: collision with root package name */
    boolean f665i;

    /* renamed from: j  reason: collision with root package name */
    private int f666j;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        x.u0(this, new b(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ActionBar);
        this.f661e = obtainStyledAttributes.getDrawable(j.ActionBar_background);
        this.f662f = obtainStyledAttributes.getDrawable(j.ActionBar_backgroundStacked);
        this.f666j = obtainStyledAttributes.getDimensionPixelSize(j.ActionBar_height, -1);
        boolean z10 = true;
        if (getId() == f.split_action_bar) {
            this.f664h = true;
            this.f663g = obtainStyledAttributes.getDrawable(j.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        if (!this.f664h ? !(this.f661e == null && this.f662f == null) : this.f663g != null) {
            z10 = false;
        }
        setWillNotDraw(z10);
    }

    private int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    private boolean b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f661e;
        if (drawable != null && drawable.isStateful()) {
            this.f661e.setState(getDrawableState());
        }
        Drawable drawable2 = this.f662f;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f662f.setState(getDrawableState());
        }
        Drawable drawable3 = this.f663g;
        if (drawable3 != null && drawable3.isStateful()) {
            this.f663g.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return this.f658b;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f661e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f662f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f663g;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f659c = findViewById(f.action_bar);
        this.f660d = findViewById(f.action_context_bar);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f657a || super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r5, int r6, int r7, int r8, int r9) {
        /*
            r4 = this;
            super.onLayout(r5, r6, r7, r8, r9)
            android.view.View r5 = r4.f658b
            r7 = 8
            r9 = 1
            r0 = 0
            if (r5 == 0) goto L_0x0013
            int r1 = r5.getVisibility()
            if (r1 == r7) goto L_0x0013
            r1 = r9
            goto L_0x0014
        L_0x0013:
            r1 = r0
        L_0x0014:
            if (r5 == 0) goto L_0x0033
            int r2 = r5.getVisibility()
            if (r2 == r7) goto L_0x0033
            int r7 = r4.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r2 = r5.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r2 = (android.widget.FrameLayout.LayoutParams) r2
            int r3 = r5.getMeasuredHeight()
            int r3 = r7 - r3
            int r2 = r2.bottomMargin
            int r3 = r3 - r2
            int r7 = r7 - r2
            r5.layout(r6, r3, r8, r7)
        L_0x0033:
            boolean r6 = r4.f664h
            if (r6 == 0) goto L_0x004a
            android.graphics.drawable.Drawable r5 = r4.f663g
            if (r5 == 0) goto L_0x0048
            int r6 = r4.getMeasuredWidth()
            int r7 = r4.getMeasuredHeight()
            r5.setBounds(r0, r0, r6, r7)
            goto L_0x00b6
        L_0x0048:
            r9 = r0
            goto L_0x00b6
        L_0x004a:
            android.graphics.drawable.Drawable r6 = r4.f661e
            if (r6 == 0) goto L_0x009b
            android.view.View r6 = r4.f659c
            int r6 = r6.getVisibility()
            if (r6 != 0) goto L_0x0074
            android.graphics.drawable.Drawable r6 = r4.f661e
            android.view.View r7 = r4.f659c
            int r7 = r7.getLeft()
            android.view.View r8 = r4.f659c
            int r8 = r8.getTop()
            android.view.View r0 = r4.f659c
            int r0 = r0.getRight()
            android.view.View r2 = r4.f659c
        L_0x006c:
            int r2 = r2.getBottom()
            r6.setBounds(r7, r8, r0, r2)
            goto L_0x009a
        L_0x0074:
            android.view.View r6 = r4.f660d
            if (r6 == 0) goto L_0x0095
            int r6 = r6.getVisibility()
            if (r6 != 0) goto L_0x0095
            android.graphics.drawable.Drawable r6 = r4.f661e
            android.view.View r7 = r4.f660d
            int r7 = r7.getLeft()
            android.view.View r8 = r4.f660d
            int r8 = r8.getTop()
            android.view.View r0 = r4.f660d
            int r0 = r0.getRight()
            android.view.View r2 = r4.f660d
            goto L_0x006c
        L_0x0095:
            android.graphics.drawable.Drawable r6 = r4.f661e
            r6.setBounds(r0, r0, r0, r0)
        L_0x009a:
            r0 = r9
        L_0x009b:
            r4.f665i = r1
            if (r1 == 0) goto L_0x0048
            android.graphics.drawable.Drawable r6 = r4.f662f
            if (r6 == 0) goto L_0x0048
            int r7 = r5.getLeft()
            int r8 = r5.getTop()
            int r0 = r5.getRight()
            int r5 = r5.getBottom()
            r6.setBounds(r7, r8, r0, r5)
        L_0x00b6:
            if (r9 == 0) goto L_0x00bb
            r4.invalidate()
        L_0x00bb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContainer.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r4, int r5) {
        /*
            r3 = this;
            android.view.View r0 = r3.f659c
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != 0) goto L_0x001c
            int r0 = android.view.View.MeasureSpec.getMode(r5)
            if (r0 != r1) goto L_0x001c
            int r0 = r3.f666j
            if (r0 < 0) goto L_0x001c
            int r5 = android.view.View.MeasureSpec.getSize(r5)
            int r5 = java.lang.Math.min(r0, r5)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r1)
        L_0x001c:
            super.onMeasure(r4, r5)
            android.view.View r4 = r3.f659c
            if (r4 != 0) goto L_0x0024
            return
        L_0x0024:
            int r4 = android.view.View.MeasureSpec.getMode(r5)
            android.view.View r0 = r3.f658b
            if (r0 == 0) goto L_0x006f
            int r0 = r0.getVisibility()
            r2 = 8
            if (r0 == r2) goto L_0x006f
            r0 = 1073741824(0x40000000, float:2.0)
            if (r4 == r0) goto L_0x006f
            android.view.View r0 = r3.f659c
            boolean r0 = r3.b(r0)
            if (r0 != 0) goto L_0x0047
            android.view.View r0 = r3.f659c
        L_0x0042:
            int r0 = r3.a(r0)
            goto L_0x0053
        L_0x0047:
            android.view.View r0 = r3.f660d
            boolean r0 = r3.b(r0)
            if (r0 != 0) goto L_0x0052
            android.view.View r0 = r3.f660d
            goto L_0x0042
        L_0x0052:
            r0 = 0
        L_0x0053:
            if (r4 != r1) goto L_0x005a
            int r4 = android.view.View.MeasureSpec.getSize(r5)
            goto L_0x005d
        L_0x005a:
            r4 = 2147483647(0x7fffffff, float:NaN)
        L_0x005d:
            int r5 = r3.getMeasuredWidth()
            android.view.View r1 = r3.f658b
            int r1 = r3.a(r1)
            int r0 = r0 + r1
            int r4 = java.lang.Math.min(r0, r4)
            r3.setMeasuredDimension(r5, r4)
        L_0x006f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContainer.onMeasure(int, int):void");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f661e;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f661e);
        }
        this.f661e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f659c;
            if (view != null) {
                this.f661e.setBounds(view.getLeft(), this.f659c.getTop(), this.f659c.getRight(), this.f659c.getBottom());
            }
        }
        boolean z10 = true;
        if (!this.f664h ? !(this.f661e == null && this.f662f == null) : this.f663g != null) {
            z10 = false;
        }
        setWillNotDraw(z10);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f663g;
        if (drawable3 != null) {
            drawable3.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f663g);
        }
        this.f663g = drawable;
        boolean z10 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f664h && (drawable2 = this.f663g) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f664h ? this.f661e == null && this.f662f == null : this.f663g == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f662f;
        if (drawable3 != null) {
            drawable3.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f662f);
        }
        this.f662f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f665i && (drawable2 = this.f662f) != null) {
                drawable2.setBounds(this.f658b.getLeft(), this.f658b.getTop(), this.f658b.getRight(), this.f658b.getBottom());
            }
        }
        boolean z10 = true;
        if (!this.f664h ? !(this.f661e == null && this.f662f == null) : this.f663g != null) {
            z10 = false;
        }
        setWillNotDraw(z10);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setTabContainer(z zVar) {
        View view = this.f658b;
        if (view != null) {
            removeView(view);
        }
        this.f658b = zVar;
        if (zVar != null) {
            addView(zVar);
            ViewGroup.LayoutParams layoutParams = zVar.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            zVar.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z10) {
        this.f657a = z10;
        setDescendantFocusability(z10 ? 393216 : 262144);
    }

    public void setVisibility(int i10) {
        super.setVisibility(i10);
        boolean z10 = i10 == 0;
        Drawable drawable = this.f661e;
        if (drawable != null) {
            drawable.setVisible(z10, false);
        }
        Drawable drawable2 = this.f662f;
        if (drawable2 != null) {
            drawable2.setVisible(z10, false);
        }
        Drawable drawable3 = this.f663g;
        if (drawable3 != null) {
            drawable3.setVisible(z10, false);
        }
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i10) {
        if (i10 != 0) {
            return super.startActionModeForChild(view, callback, i10);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f661e && !this.f664h) || (drawable == this.f662f && this.f665i) || ((drawable == this.f663g && this.f664h) || super.verifyDrawable(drawable));
    }
}
