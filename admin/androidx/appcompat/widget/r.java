package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.core.view.b0;
import androidx.core.widget.h;
import java.lang.reflect.Field;
import l.c;

class r extends ListView {

    /* renamed from: a  reason: collision with root package name */
    private final Rect f1184a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    private int f1185b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f1186c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f1187d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f1188e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f1189f;

    /* renamed from: g  reason: collision with root package name */
    private Field f1190g;

    /* renamed from: h  reason: collision with root package name */
    private a f1191h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1192i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f1193j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f1194k;

    /* renamed from: l  reason: collision with root package name */
    private b0 f1195l;

    /* renamed from: m  reason: collision with root package name */
    private h f1196m;

    /* renamed from: n  reason: collision with root package name */
    b f1197n;

    private static class a extends c {

        /* renamed from: b  reason: collision with root package name */
        private boolean f1198b = true;

        a(Drawable drawable) {
            super(drawable);
        }

        /* access modifiers changed from: package-private */
        public void c(boolean z10) {
            this.f1198b = z10;
        }

        public void draw(Canvas canvas) {
            if (this.f1198b) {
                super.draw(canvas);
            }
        }

        public void setHotspot(float f10, float f11) {
            if (this.f1198b) {
                super.setHotspot(f10, f11);
            }
        }

        public void setHotspotBounds(int i10, int i11, int i12, int i13) {
            if (this.f1198b) {
                super.setHotspotBounds(i10, i11, i12, i13);
            }
        }

        public boolean setState(int[] iArr) {
            if (this.f1198b) {
                return super.setState(iArr);
            }
            return false;
        }

        public boolean setVisible(boolean z10, boolean z11) {
            if (this.f1198b) {
                return super.setVisible(z10, z11);
            }
            return false;
        }
    }

    private class b implements Runnable {
        b() {
        }

        public void a() {
            r rVar = r.this;
            rVar.f1197n = null;
            rVar.removeCallbacks(this);
        }

        public void b() {
            r.this.post(this);
        }

        public void run() {
            r rVar = r.this;
            rVar.f1197n = null;
            rVar.drawableStateChanged();
        }
    }

    r(Context context, boolean z10) {
        super(context, (AttributeSet) null, j.a.dropDownListViewStyle);
        this.f1193j = z10;
        setCacheColorHint(0);
        try {
            Field declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f1190g = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e10) {
            e10.printStackTrace();
        }
    }

    private void a() {
        this.f1194k = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f1189f - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        b0 b0Var = this.f1195l;
        if (b0Var != null) {
            b0Var.b();
            this.f1195l = null;
        }
    }

    private void b(View view, int i10) {
        performItemClick(view, i10, getItemIdAtPosition(i10));
    }

    private void c(Canvas canvas) {
        Drawable selector;
        if (!this.f1184a.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(this.f1184a);
            selector.draw(canvas);
        }
    }

    private void f(int i10, View view) {
        Rect rect = this.f1184a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f1185b;
        rect.top -= this.f1186c;
        rect.right += this.f1187d;
        rect.bottom += this.f1188e;
        try {
            boolean z10 = this.f1190g.getBoolean(this);
            if (view.isEnabled() != z10) {
                this.f1190g.set(this, Boolean.valueOf(!z10));
                if (i10 != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e10) {
            e10.printStackTrace();
        }
    }

    private void g(int i10, View view) {
        Drawable selector = getSelector();
        boolean z10 = true;
        boolean z11 = (selector == null || i10 == -1) ? false : true;
        if (z11) {
            selector.setVisible(false, false);
        }
        f(i10, view);
        if (z11) {
            Rect rect = this.f1184a;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            if (getVisibility() != 0) {
                z10 = false;
            }
            selector.setVisible(z10, false);
            p0.a.k(selector, exactCenterX, exactCenterY);
        }
    }

    private void h(int i10, View view, float f10, float f11) {
        g(i10, view);
        Drawable selector = getSelector();
        if (selector != null && i10 != -1) {
            p0.a.k(selector, f10, f11);
        }
    }

    private void i(View view, int i10, float f10, float f11) {
        View childAt;
        this.f1194k = true;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 21) {
            drawableHotspotChanged(f10, f11);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i12 = this.f1189f;
        if (!(i12 == -1 || (childAt = getChildAt(i12 - getFirstVisiblePosition())) == null || childAt == view || !childAt.isPressed())) {
            childAt.setPressed(false);
        }
        this.f1189f = i10;
        float left = f10 - ((float) view.getLeft());
        float top = f11 - ((float) view.getTop());
        if (i11 >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        h(i10, view, f10, f11);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    private boolean j() {
        return this.f1194k;
    }

    private void k() {
        Drawable selector = getSelector();
        if (selector != null && j() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    private void setSelectorEnabled(boolean z10) {
        a aVar = this.f1191h;
        if (aVar != null) {
            aVar.c(z10);
        }
    }

    public int d(int i10, int i11, int i12, int i13, int i14) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        int i15 = listPaddingTop + listPaddingBottom;
        if (adapter == null) {
            return i15;
        }
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        View view = null;
        while (i16 < count) {
            int itemViewType = adapter.getItemViewType(i16);
            if (itemViewType != i17) {
                view = null;
                i17 = itemViewType;
            }
            view = adapter.getView(i16, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i19 = layoutParams.height;
            view.measure(i10, i19 > 0 ? View.MeasureSpec.makeMeasureSpec(i19, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i16 > 0) {
                i15 += dividerHeight;
            }
            i15 += view.getMeasuredHeight();
            if (i15 >= i13) {
                return (i14 < 0 || i16 <= i14 || i18 <= 0 || i15 == i13) ? i13 : i18;
            }
            if (i14 >= 0 && i16 >= i14) {
                i18 = i15;
            }
            i16++;
        }
        return i15;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        c(canvas);
        super.dispatchDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        if (this.f1197n == null) {
            super.drawableStateChanged();
            setSelectorEnabled(true);
            k();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
        if (r0 != 3) goto L_0x000e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean e(android.view.MotionEvent r8, int r9) {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L_0x0016
            r3 = 2
            if (r0 == r3) goto L_0x0014
            r9 = 3
            if (r0 == r9) goto L_0x0011
        L_0x000e:
            r9 = r1
            r3 = r2
            goto L_0x0046
        L_0x0011:
            r9 = r1
            r3 = r9
            goto L_0x0046
        L_0x0014:
            r3 = r2
            goto L_0x0017
        L_0x0016:
            r3 = r1
        L_0x0017:
            int r9 = r8.findPointerIndex(r9)
            if (r9 >= 0) goto L_0x001e
            goto L_0x0011
        L_0x001e:
            float r4 = r8.getX(r9)
            int r4 = (int) r4
            float r9 = r8.getY(r9)
            int r9 = (int) r9
            int r5 = r7.pointToPosition(r4, r9)
            r6 = -1
            if (r5 != r6) goto L_0x0031
            r9 = r2
            goto L_0x0046
        L_0x0031:
            int r3 = r7.getFirstVisiblePosition()
            int r3 = r5 - r3
            android.view.View r3 = r7.getChildAt(r3)
            float r4 = (float) r4
            float r9 = (float) r9
            r7.i(r3, r5, r4, r9)
            if (r0 != r2) goto L_0x000e
            r7.b(r3, r5)
            goto L_0x000e
        L_0x0046:
            if (r3 == 0) goto L_0x004a
            if (r9 == 0) goto L_0x004d
        L_0x004a:
            r7.a()
        L_0x004d:
            if (r3 == 0) goto L_0x0065
            androidx.core.widget.h r9 = r7.f1196m
            if (r9 != 0) goto L_0x005a
            androidx.core.widget.h r9 = new androidx.core.widget.h
            r9.<init>(r7)
            r7.f1196m = r9
        L_0x005a:
            androidx.core.widget.h r9 = r7.f1196m
            r9.m(r2)
            androidx.core.widget.h r9 = r7.f1196m
            r9.onTouch(r7, r8)
            goto L_0x006c
        L_0x0065:
            androidx.core.widget.h r8 = r7.f1196m
            if (r8 == 0) goto L_0x006c
            r8.m(r1)
        L_0x006c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.r.e(android.view.MotionEvent, int):boolean");
    }

    public boolean hasFocus() {
        return this.f1193j || super.hasFocus();
    }

    public boolean hasWindowFocus() {
        return this.f1193j || super.hasWindowFocus();
    }

    public boolean isFocused() {
        return this.f1193j || super.isFocused();
    }

    public boolean isInTouchMode() {
        return (this.f1193j && this.f1192i) || super.isInTouchMode();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.f1197n = null;
        super.onDetachedFromWindow();
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f1197n == null) {
            b bVar = new b();
            this.f1197n = bVar;
            bVar.b();
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (!(pointToPosition == -1 || pointToPosition == getSelectedItemPosition())) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                }
                k();
            }
        } else {
            setSelection(-1);
        }
        return onHoverEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f1189f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        b bVar = this.f1197n;
        if (bVar != null) {
            bVar.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: package-private */
    public void setListSelectionHidden(boolean z10) {
        this.f1192i = z10;
    }

    public void setSelector(Drawable drawable) {
        a aVar = drawable != null ? new a(drawable) : null;
        this.f1191h = aVar;
        super.setSelector(aVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f1185b = rect.left;
        this.f1186c = rect.top;
        this.f1187d = rect.right;
        this.f1188e = rect.bottom;
    }
}
