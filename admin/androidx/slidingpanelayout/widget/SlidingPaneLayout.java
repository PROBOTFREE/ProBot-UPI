package androidx.slidingpanelayout.widget;

import a1.c;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.x;
import androidx.customview.view.AbsSavedState;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SlidingPaneLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private int f3843a;

    /* renamed from: b  reason: collision with root package name */
    private int f3844b;

    /* renamed from: c  reason: collision with root package name */
    private Drawable f3845c;

    /* renamed from: d  reason: collision with root package name */
    private Drawable f3846d;

    /* renamed from: e  reason: collision with root package name */
    private final int f3847e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3848f;

    /* renamed from: g  reason: collision with root package name */
    View f3849g;

    /* renamed from: h  reason: collision with root package name */
    float f3850h;

    /* renamed from: i  reason: collision with root package name */
    private float f3851i;

    /* renamed from: j  reason: collision with root package name */
    int f3852j;

    /* renamed from: k  reason: collision with root package name */
    boolean f3853k;

    /* renamed from: l  reason: collision with root package name */
    private int f3854l;

    /* renamed from: m  reason: collision with root package name */
    private float f3855m;

    /* renamed from: n  reason: collision with root package name */
    private float f3856n;

    /* renamed from: o  reason: collision with root package name */
    private d f3857o;

    /* renamed from: p  reason: collision with root package name */
    final a1.c f3858p;

    /* renamed from: q  reason: collision with root package name */
    boolean f3859q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f3860r;

    /* renamed from: s  reason: collision with root package name */
    private final Rect f3861s;

    /* renamed from: t  reason: collision with root package name */
    final ArrayList<b> f3862t;

    /* renamed from: u  reason: collision with root package name */
    private Method f3863u;

    /* renamed from: v  reason: collision with root package name */
    private Field f3864v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f3865w;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: e  reason: collision with root package name */
        private static final int[] f3866e = {16843137};

        /* renamed from: a  reason: collision with root package name */
        public float f3867a = 0.0f;

        /* renamed from: b  reason: collision with root package name */
        boolean f3868b;

        /* renamed from: c  reason: collision with root package name */
        boolean f3869c;

        /* renamed from: d  reason: collision with root package name */
        Paint f3870d;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f3866e);
            this.f3867a = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        boolean f3871c;

        static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3871c = parcel.readInt() != 0;
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f3871c ? 1 : 0);
        }
    }

    class a extends androidx.core.view.a {

        /* renamed from: d  reason: collision with root package name */
        private final Rect f3872d = new Rect();

        a() {
        }

        private void n(x0.c cVar, x0.c cVar2) {
            Rect rect = this.f3872d;
            cVar2.m(rect);
            cVar.X(rect);
            cVar2.n(rect);
            cVar.Y(rect);
            cVar.G0(cVar2.N());
            cVar.r0(cVar2.v());
            cVar.c0(cVar2.p());
            cVar.g0(cVar2.r());
            cVar.i0(cVar2.F());
            cVar.d0(cVar2.E());
            cVar.k0(cVar2.G());
            cVar.l0(cVar2.H());
            cVar.V(cVar2.B());
            cVar.z0(cVar2.L());
            cVar.o0(cVar2.I());
            cVar.a(cVar2.k());
            cVar.q0(cVar2.t());
        }

        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
        }

        public void g(View view, x0.c cVar) {
            x0.c Q = x0.c.Q(cVar);
            super.g(view, Q);
            n(cVar, Q);
            Q.S();
            cVar.c0(SlidingPaneLayout.class.getName());
            cVar.B0(view);
            ViewParent J = x.J(view);
            if (J instanceof View) {
                cVar.t0((View) J);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = SlidingPaneLayout.this.getChildAt(i10);
                if (!o(childAt) && childAt.getVisibility() == 0) {
                    x.B0(childAt, 1);
                    cVar.c(childAt);
                }
            }
        }

        public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (!o(view)) {
                return super.i(viewGroup, view, accessibilityEvent);
            }
            return false;
        }

        public boolean o(View view) {
            return SlidingPaneLayout.this.h(view);
        }
    }

    private class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final View f3874a;

        b(View view) {
            this.f3874a = view;
        }

        public void run() {
            if (this.f3874a.getParent() == SlidingPaneLayout.this) {
                this.f3874a.setLayerType(0, (Paint) null);
                SlidingPaneLayout.this.g(this.f3874a);
            }
            SlidingPaneLayout.this.f3862t.remove(this);
        }
    }

    private class c extends c.C0002c {
        c() {
        }

        public int a(View view, int i10, int i11) {
            LayoutParams layoutParams = (LayoutParams) SlidingPaneLayout.this.f3849g.getLayoutParams();
            if (SlidingPaneLayout.this.i()) {
                int width = SlidingPaneLayout.this.getWidth() - ((SlidingPaneLayout.this.getPaddingRight() + layoutParams.rightMargin) + SlidingPaneLayout.this.f3849g.getWidth());
                return Math.max(Math.min(i10, width), width - SlidingPaneLayout.this.f3852j);
            }
            int paddingLeft = SlidingPaneLayout.this.getPaddingLeft() + layoutParams.leftMargin;
            return Math.min(Math.max(i10, paddingLeft), SlidingPaneLayout.this.f3852j + paddingLeft);
        }

        public int b(View view, int i10, int i11) {
            return view.getTop();
        }

        public int d(View view) {
            return SlidingPaneLayout.this.f3852j;
        }

        public void f(int i10, int i11) {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            slidingPaneLayout.f3858p.c(slidingPaneLayout.f3849g, i11);
        }

        public void i(View view, int i10) {
            SlidingPaneLayout.this.p();
        }

        public void j(int i10) {
            SlidingPaneLayout slidingPaneLayout;
            boolean z10;
            if (SlidingPaneLayout.this.f3858p.B() == 0) {
                SlidingPaneLayout slidingPaneLayout2 = SlidingPaneLayout.this;
                if (slidingPaneLayout2.f3850h == 0.0f) {
                    slidingPaneLayout2.r(slidingPaneLayout2.f3849g);
                    SlidingPaneLayout slidingPaneLayout3 = SlidingPaneLayout.this;
                    slidingPaneLayout3.d(slidingPaneLayout3.f3849g);
                    slidingPaneLayout = SlidingPaneLayout.this;
                    z10 = false;
                } else {
                    slidingPaneLayout2.e(slidingPaneLayout2.f3849g);
                    slidingPaneLayout = SlidingPaneLayout.this;
                    z10 = true;
                }
                slidingPaneLayout.f3859q = z10;
            }
        }

        public void k(View view, int i10, int i11, int i12, int i13) {
            SlidingPaneLayout.this.l(i10);
            SlidingPaneLayout.this.invalidate();
        }

        public void l(View view, float f10, float f11) {
            int i10;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (SlidingPaneLayout.this.i()) {
                int paddingRight = SlidingPaneLayout.this.getPaddingRight() + layoutParams.rightMargin;
                if (f10 < 0.0f || (f10 == 0.0f && SlidingPaneLayout.this.f3850h > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.f3852j;
                }
                i10 = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.f3849g.getWidth();
            } else {
                i10 = layoutParams.leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                int i11 = (f10 > 0.0f ? 1 : (f10 == 0.0f ? 0 : -1));
                if (i11 > 0 || (i11 == 0 && SlidingPaneLayout.this.f3850h > 0.5f)) {
                    i10 += SlidingPaneLayout.this.f3852j;
                }
            }
            SlidingPaneLayout.this.f3858p.P(i10, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        public boolean m(View view, int i10) {
            if (SlidingPaneLayout.this.f3853k) {
                return false;
            }
            return ((LayoutParams) view.getLayoutParams()).f3868b;
        }
    }

    public interface d {
        void a(View view, float f10);

        void b(View view);

        void c(View view);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f3843a = -858993460;
        this.f3860r = true;
        this.f3861s = new Rect();
        this.f3862t = new ArrayList<>();
        float f10 = context.getResources().getDisplayMetrics().density;
        this.f3847e = (int) ((32.0f * f10) + 0.5f);
        setWillNotDraw(false);
        x.r0(this, new a());
        x.B0(this, 1);
        a1.c o10 = a1.c.o(this, 0.5f, new c());
        this.f3858p = o10;
        o10.O(f10 * 400.0f);
    }

    private boolean b(View view, int i10) {
        if (!this.f3860r && !q(0.0f, i10)) {
            return false;
        }
        this.f3859q = false;
        return true;
    }

    private void c(View view, float f10, int i10) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f10 > 0.0f && i10 != 0) {
            int i11 = (((int) (((float) ((-16777216 & i10) >>> 24)) * f10)) << 24) | (i10 & 16777215);
            if (layoutParams.f3870d == null) {
                layoutParams.f3870d = new Paint();
            }
            layoutParams.f3870d.setColorFilter(new PorterDuffColorFilter(i11, PorterDuff.Mode.SRC_OVER));
            if (view.getLayerType() != 2) {
                view.setLayerType(2, layoutParams.f3870d);
            }
            g(view);
        } else if (view.getLayerType() != 0) {
            Paint paint = layoutParams.f3870d;
            if (paint != null) {
                paint.setColorFilter((ColorFilter) null);
            }
            b bVar = new b(view);
            this.f3862t.add(bVar);
            x.j0(this, bVar);
        }
    }

    private boolean n(View view, int i10) {
        if (!this.f3860r && !q(1.0f, i10)) {
            return false;
        }
        this.f3859q = true;
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void o(float r10) {
        /*
            r9 = this;
            boolean r0 = r9.i()
            android.view.View r1 = r9.f3849g
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.slidingpanelayout.widget.SlidingPaneLayout$LayoutParams r1 = (androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) r1
            boolean r2 = r1.f3869c
            r3 = 0
            if (r2 == 0) goto L_0x001c
            if (r0 == 0) goto L_0x0016
            int r1 = r1.rightMargin
            goto L_0x0018
        L_0x0016:
            int r1 = r1.leftMargin
        L_0x0018:
            if (r1 > 0) goto L_0x001c
            r1 = 1
            goto L_0x001d
        L_0x001c:
            r1 = r3
        L_0x001d:
            int r2 = r9.getChildCount()
        L_0x0021:
            if (r3 >= r2) goto L_0x0057
            android.view.View r4 = r9.getChildAt(r3)
            android.view.View r5 = r9.f3849g
            if (r4 != r5) goto L_0x002c
            goto L_0x0054
        L_0x002c:
            float r5 = r9.f3851i
            r6 = 1065353216(0x3f800000, float:1.0)
            float r5 = r6 - r5
            int r7 = r9.f3854l
            float r8 = (float) r7
            float r5 = r5 * r8
            int r5 = (int) r5
            r9.f3851i = r10
            float r8 = r6 - r10
            float r7 = (float) r7
            float r8 = r8 * r7
            int r7 = (int) r8
            int r5 = r5 - r7
            if (r0 == 0) goto L_0x0042
            int r5 = -r5
        L_0x0042:
            r4.offsetLeftAndRight(r5)
            if (r1 == 0) goto L_0x0054
            float r5 = r9.f3851i
            if (r0 == 0) goto L_0x004d
            float r5 = r5 - r6
            goto L_0x004f
        L_0x004d:
            float r5 = r6 - r5
        L_0x004f:
            int r6 = r9.f3844b
            r9.c(r4, r5, r6)
        L_0x0054:
            int r3 = r3 + 1
            goto L_0x0021
        L_0x0057:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.o(float):void");
    }

    private static boolean s(View view) {
        Drawable background;
        if (view.isOpaque()) {
            return true;
        }
        if (Build.VERSION.SDK_INT < 18 && (background = view.getBackground()) != null) {
            return background.getOpacity() == -1;
        }
        return false;
    }

    public boolean a() {
        return b(this.f3849g, 0);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        if (!this.f3858p.n(true)) {
            return;
        }
        if (!this.f3848f) {
            this.f3858p.a();
        } else {
            x.h0(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void d(View view) {
        d dVar = this.f3857o;
        if (dVar != null) {
            dVar.c(view);
        }
        sendAccessibilityEvent(32);
    }

    public void draw(Canvas canvas) {
        int i10;
        int i11;
        super.draw(canvas);
        Drawable drawable = i() ? this.f3846d : this.f3845c;
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt != null && drawable != null) {
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (i()) {
                i11 = childAt.getRight();
                i10 = intrinsicWidth + i11;
            } else {
                int left = childAt.getLeft();
                int i12 = left - intrinsicWidth;
                i10 = left;
                i11 = i12;
            }
            drawable.setBounds(i11, top, i10, bottom);
            drawable.draw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j10) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save();
        if (this.f3848f && !layoutParams.f3868b && this.f3849g != null) {
            canvas.getClipBounds(this.f3861s);
            if (i()) {
                Rect rect = this.f3861s;
                rect.left = Math.max(rect.left, this.f3849g.getRight());
            } else {
                Rect rect2 = this.f3861s;
                rect2.right = Math.min(rect2.right, this.f3849g.getLeft());
            }
            canvas.clipRect(this.f3861s);
        }
        boolean drawChild = super.drawChild(canvas, view, j10);
        canvas.restoreToCount(save);
        return drawChild;
    }

    /* access modifiers changed from: package-private */
    public void e(View view) {
        d dVar = this.f3857o;
        if (dVar != null) {
            dVar.b(view);
        }
        sendAccessibilityEvent(32);
    }

    /* access modifiers changed from: package-private */
    public void f(View view) {
        d dVar = this.f3857o;
        if (dVar != null) {
            dVar.a(view, this.f3850h);
        }
    }

    /* access modifiers changed from: package-private */
    public void g(View view) {
        Field field;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 17) {
            x.D0(view, ((LayoutParams) view.getLayoutParams()).f3870d);
            return;
        }
        if (i10 >= 16) {
            if (!this.f3865w) {
                try {
                    this.f3863u = View.class.getDeclaredMethod("getDisplayList", (Class[]) null);
                } catch (NoSuchMethodException e10) {
                    Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", e10);
                }
                try {
                    Field declaredField = View.class.getDeclaredField("mRecreateDisplayList");
                    this.f3864v = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e11) {
                    Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", e11);
                }
                this.f3865w = true;
            }
            if (this.f3863u == null || (field = this.f3864v) == null) {
                view.invalidate();
                return;
            }
            try {
                field.setBoolean(view, true);
                this.f3863u.invoke(view, (Object[]) null);
            } catch (Exception e12) {
                Log.e("SlidingPaneLayout", "Error refreshing display list state", e12);
            }
        }
        x.i0(this, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public int getCoveredFadeColor() {
        return this.f3844b;
    }

    public int getParallaxDistance() {
        return this.f3854l;
    }

    public int getSliderFadeColor() {
        return this.f3843a;
    }

    /* access modifiers changed from: package-private */
    public boolean h(View view) {
        if (view == null) {
            return false;
        }
        return this.f3848f && ((LayoutParams) view.getLayoutParams()).f3869c && this.f3850h > 0.0f;
    }

    /* access modifiers changed from: package-private */
    public boolean i() {
        return x.C(this) == 1;
    }

    public boolean j() {
        return !this.f3848f || this.f3850h == 1.0f;
    }

    public boolean k() {
        return this.f3848f;
    }

    /* access modifiers changed from: package-private */
    public void l(int i10) {
        if (this.f3849g == null) {
            this.f3850h = 0.0f;
            return;
        }
        boolean i11 = i();
        LayoutParams layoutParams = (LayoutParams) this.f3849g.getLayoutParams();
        int width = this.f3849g.getWidth();
        if (i11) {
            i10 = (getWidth() - i10) - width;
        }
        float paddingRight = ((float) (i10 - ((i11 ? getPaddingRight() : getPaddingLeft()) + (i11 ? layoutParams.rightMargin : layoutParams.leftMargin)))) / ((float) this.f3852j);
        this.f3850h = paddingRight;
        if (this.f3854l != 0) {
            o(paddingRight);
        }
        if (layoutParams.f3869c) {
            c(this.f3849g, this.f3850h, this.f3843a);
        }
        f(this.f3849g);
    }

    public boolean m() {
        return n(this.f3849g, 0);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f3860r = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f3860r = true;
        int size = this.f3862t.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f3862t.get(i10).run();
        }
        this.f3862t.clear();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        View childAt;
        int actionMasked = motionEvent.getActionMasked();
        if (!this.f3848f && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.f3859q = !this.f3858p.F(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.f3848f || (this.f3853k && actionMasked != 0)) {
            this.f3858p.b();
            return super.onInterceptTouchEvent(motionEvent);
        } else if (actionMasked == 3 || actionMasked == 1) {
            this.f3858p.b();
            return false;
        } else {
            if (actionMasked == 0) {
                this.f3853k = false;
                float x10 = motionEvent.getX();
                float y10 = motionEvent.getY();
                this.f3855m = x10;
                this.f3856n = y10;
                if (this.f3858p.F(this.f3849g, (int) x10, (int) y10) && h(this.f3849g)) {
                    z10 = true;
                    return this.f3858p.Q(motionEvent) || z10;
                }
            } else if (actionMasked == 2) {
                float x11 = motionEvent.getX();
                float y11 = motionEvent.getY();
                float abs = Math.abs(x11 - this.f3855m);
                float abs2 = Math.abs(y11 - this.f3856n);
                if (abs > ((float) this.f3858p.A()) && abs2 > abs) {
                    this.f3858p.b();
                    this.f3853k = true;
                    return false;
                }
            }
            z10 = false;
            if (this.f3858p.Q(motionEvent)) {
                return true;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16;
        int i17;
        boolean i18 = i();
        a1.c cVar = this.f3858p;
        if (i18) {
            cVar.N(2);
        } else {
            cVar.N(1);
        }
        int i19 = i12 - i10;
        int paddingRight = i18 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = i18 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.f3860r) {
            this.f3850h = (!this.f3848f || !this.f3859q) ? 0.0f : 1.0f;
        }
        int i20 = paddingRight;
        for (int i21 = 0; i21 < childCount; i21++) {
            View childAt = getChildAt(i21);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (layoutParams.f3868b) {
                    int i22 = i19 - paddingLeft;
                    int min = (Math.min(paddingRight, i22 - this.f3847e) - i20) - (layoutParams.leftMargin + layoutParams.rightMargin);
                    this.f3852j = min;
                    int i23 = i18 ? layoutParams.rightMargin : layoutParams.leftMargin;
                    layoutParams.f3869c = ((i20 + i23) + min) + (measuredWidth / 2) > i22;
                    int i24 = (int) (((float) min) * this.f3850h);
                    i20 += i23 + i24;
                    this.f3850h = ((float) i24) / ((float) min);
                    i14 = 0;
                } else if (!this.f3848f || (i17 = this.f3854l) == 0) {
                    i20 = paddingRight;
                    i14 = 0;
                } else {
                    i14 = (int) ((1.0f - this.f3850h) * ((float) i17));
                    i20 = paddingRight;
                }
                if (i18) {
                    i15 = (i19 - i20) + i14;
                    i16 = i15 - measuredWidth;
                } else {
                    i16 = i20 - i14;
                    i15 = i16 + measuredWidth;
                }
                childAt.layout(i16, paddingTop, i15, childAt.getMeasuredHeight() + paddingTop);
                paddingRight += childAt.getWidth();
            }
        }
        if (this.f3860r) {
            if (this.f3848f) {
                if (this.f3854l != 0) {
                    o(this.f3850h);
                }
                if (((LayoutParams) this.f3849g.getLayoutParams()).f3869c) {
                    c(this.f3849g, this.f3850h, this.f3843a);
                }
            } else {
                for (int i25 = 0; i25 < childCount; i25++) {
                    c(getChildAt(i25), 0.0f, this.f3843a);
                }
            }
            r(this.f3849g);
        }
        this.f3860r = false;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01ef  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0115  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r21, int r22) {
        /*
            r20 = this;
            r0 = r20
            int r1 = android.view.View.MeasureSpec.getMode(r21)
            int r2 = android.view.View.MeasureSpec.getSize(r21)
            int r3 = android.view.View.MeasureSpec.getMode(r22)
            int r4 = android.view.View.MeasureSpec.getSize(r22)
            r5 = 300(0x12c, float:4.2E-43)
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = 1073741824(0x40000000, float:2.0)
            if (r1 == r7) goto L_0x002f
            boolean r8 = r20.isInEditMode()
            if (r8 == 0) goto L_0x0027
            if (r1 != r6) goto L_0x0023
            goto L_0x0044
        L_0x0023:
            if (r1 != 0) goto L_0x0044
            r2 = r5
            goto L_0x0044
        L_0x0027:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Width must have an exact value or MATCH_PARENT"
            r1.<init>(r2)
            throw r1
        L_0x002f:
            if (r3 != 0) goto L_0x0044
            boolean r1 = r20.isInEditMode()
            if (r1 == 0) goto L_0x003c
            if (r3 != 0) goto L_0x0044
            r4 = r5
            r3 = r6
            goto L_0x0044
        L_0x003c:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Height must not be UNSPECIFIED"
            r1.<init>(r2)
            throw r1
        L_0x0044:
            r1 = 0
            if (r3 == r6) goto L_0x0057
            if (r3 == r7) goto L_0x004c
            r4 = r1
        L_0x004a:
            r5 = r4
            goto L_0x0063
        L_0x004c:
            int r5 = r20.getPaddingTop()
            int r4 = r4 - r5
            int r5 = r20.getPaddingBottom()
            int r4 = r4 - r5
            goto L_0x004a
        L_0x0057:
            int r5 = r20.getPaddingTop()
            int r4 = r4 - r5
            int r5 = r20.getPaddingBottom()
            int r4 = r4 - r5
            r5 = r4
            r4 = r1
        L_0x0063:
            int r8 = r20.getPaddingLeft()
            int r8 = r2 - r8
            int r9 = r20.getPaddingRight()
            int r8 = r8 - r9
            int r9 = r20.getChildCount()
            r10 = 2
            if (r9 <= r10) goto L_0x007c
            java.lang.String r10 = "SlidingPaneLayout"
            java.lang.String r11 = "onMeasure: More than two child views are not supported."
            android.util.Log.e(r10, r11)
        L_0x007c:
            r10 = 0
            r0.f3849g = r10
            r11 = r1
            r12 = r11
            r14 = r8
            r13 = 0
        L_0x0083:
            r15 = 8
            r16 = 1
            if (r11 >= r9) goto L_0x0122
            android.view.View r6 = r0.getChildAt(r11)
            android.view.ViewGroup$LayoutParams r17 = r6.getLayoutParams()
            r7 = r17
            androidx.slidingpanelayout.widget.SlidingPaneLayout$LayoutParams r7 = (androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) r7
            int r10 = r6.getVisibility()
            if (r10 != r15) goto L_0x009f
            r7.f3869c = r1
            goto L_0x0119
        L_0x009f:
            float r10 = r7.f3867a
            r15 = 0
            int r18 = (r10 > r15 ? 1 : (r10 == r15 ? 0 : -1))
            if (r18 <= 0) goto L_0x00ad
            float r13 = r13 + r10
            int r10 = r7.width
            if (r10 != 0) goto L_0x00ad
            goto L_0x0119
        L_0x00ad:
            int r10 = r7.leftMargin
            int r15 = r7.rightMargin
            int r10 = r10 + r15
            int r15 = r7.width
            r1 = -2
            if (r15 != r1) goto L_0x00c5
            int r10 = r8 - r10
            r15 = -2147483648(0xffffffff80000000, float:-0.0)
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r15)
            r22 = r13
            r13 = r15
            r1 = -1
        L_0x00c3:
            r15 = r10
            goto L_0x00db
        L_0x00c5:
            r22 = r13
            r1 = -1
            r13 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r15 != r1) goto L_0x00d5
            int r10 = r8 - r10
            r15 = 1073741824(0x40000000, float:2.0)
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r15)
            goto L_0x00c3
        L_0x00d5:
            r10 = 1073741824(0x40000000, float:2.0)
            int r15 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r10)
        L_0x00db:
            int r10 = r7.height
            r1 = -2
            if (r10 != r1) goto L_0x00e5
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r13)
            goto L_0x00f6
        L_0x00e5:
            r1 = -1
            if (r10 != r1) goto L_0x00ef
            r1 = 1073741824(0x40000000, float:2.0)
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r1)
            goto L_0x00f5
        L_0x00ef:
            r1 = 1073741824(0x40000000, float:2.0)
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r1)
        L_0x00f5:
            r1 = r10
        L_0x00f6:
            r6.measure(r15, r1)
            int r1 = r6.getMeasuredWidth()
            int r10 = r6.getMeasuredHeight()
            if (r3 != r13) goto L_0x0109
            if (r10 <= r4) goto L_0x0109
            int r4 = java.lang.Math.min(r10, r5)
        L_0x0109:
            int r14 = r14 - r1
            if (r14 >= 0) goto L_0x010f
            r1 = r16
            goto L_0x0110
        L_0x010f:
            r1 = 0
        L_0x0110:
            r7.f3868b = r1
            r12 = r12 | r1
            if (r1 == 0) goto L_0x0117
            r0.f3849g = r6
        L_0x0117:
            r13 = r22
        L_0x0119:
            int r11 = r11 + 1
            r1 = 0
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = 1073741824(0x40000000, float:2.0)
            goto L_0x0083
        L_0x0122:
            if (r12 != 0) goto L_0x0129
            r1 = 0
            int r3 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x020e
        L_0x0129:
            int r1 = r0.f3847e
            int r1 = r8 - r1
            r3 = 0
        L_0x012e:
            if (r3 >= r9) goto L_0x020e
            android.view.View r6 = r0.getChildAt(r3)
            int r7 = r6.getVisibility()
            if (r7 != r15) goto L_0x0141
        L_0x013a:
            r19 = r1
        L_0x013c:
            r1 = 0
            r7 = 1073741824(0x40000000, float:2.0)
            goto L_0x0206
        L_0x0141:
            android.view.ViewGroup$LayoutParams r7 = r6.getLayoutParams()
            androidx.slidingpanelayout.widget.SlidingPaneLayout$LayoutParams r7 = (androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) r7
            int r10 = r6.getVisibility()
            if (r10 != r15) goto L_0x014e
            goto L_0x013a
        L_0x014e:
            int r10 = r7.width
            if (r10 != 0) goto L_0x015c
            float r10 = r7.f3867a
            r11 = 0
            int r10 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r10 <= 0) goto L_0x015c
            r10 = r16
            goto L_0x015d
        L_0x015c:
            r10 = 0
        L_0x015d:
            if (r10 == 0) goto L_0x0161
            r11 = 0
            goto L_0x0165
        L_0x0161:
            int r11 = r6.getMeasuredWidth()
        L_0x0165:
            if (r12 == 0) goto L_0x01a7
            android.view.View r15 = r0.f3849g
            if (r6 == r15) goto L_0x01a7
            int r15 = r7.width
            if (r15 >= 0) goto L_0x013a
            if (r11 > r1) goto L_0x0178
            float r11 = r7.f3867a
            r15 = 0
            int r11 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r11 <= 0) goto L_0x013a
        L_0x0178:
            if (r10 == 0) goto L_0x0195
            int r7 = r7.height
            r10 = -2
            if (r7 != r10) goto L_0x0188
            r10 = -2147483648(0xffffffff80000000, float:-0.0)
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r10)
            r10 = 1073741824(0x40000000, float:2.0)
            goto L_0x019f
        L_0x0188:
            r10 = -1
            if (r7 != r10) goto L_0x0192
            r10 = 1073741824(0x40000000, float:2.0)
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r10)
            goto L_0x019f
        L_0x0192:
            r10 = 1073741824(0x40000000, float:2.0)
            goto L_0x019b
        L_0x0195:
            r10 = 1073741824(0x40000000, float:2.0)
            int r7 = r6.getMeasuredHeight()
        L_0x019b:
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r10)
        L_0x019f:
            int r11 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r10)
            r6.measure(r11, r7)
            goto L_0x013a
        L_0x01a7:
            float r10 = r7.f3867a
            r15 = 0
            int r10 = (r10 > r15 ? 1 : (r10 == r15 ? 0 : -1))
            if (r10 <= 0) goto L_0x013a
            int r10 = r7.width
            if (r10 != 0) goto L_0x01cd
            int r10 = r7.height
            r15 = -2
            if (r10 != r15) goto L_0x01c0
            r15 = -2147483648(0xffffffff80000000, float:-0.0)
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r15)
            r15 = 1073741824(0x40000000, float:2.0)
            goto L_0x01d7
        L_0x01c0:
            r15 = -1
            if (r10 != r15) goto L_0x01ca
            r15 = 1073741824(0x40000000, float:2.0)
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r15)
            goto L_0x01d7
        L_0x01ca:
            r15 = 1073741824(0x40000000, float:2.0)
            goto L_0x01d3
        L_0x01cd:
            r15 = 1073741824(0x40000000, float:2.0)
            int r10 = r6.getMeasuredHeight()
        L_0x01d3:
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r15)
        L_0x01d7:
            if (r12 == 0) goto L_0x01ef
            int r15 = r7.leftMargin
            int r7 = r7.rightMargin
            int r15 = r15 + r7
            int r7 = r8 - r15
            r19 = r1
            r15 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r15)
            if (r11 == r7) goto L_0x013c
            r6.measure(r1, r10)
            goto L_0x013c
        L_0x01ef:
            r19 = r1
            r1 = 0
            int r15 = java.lang.Math.max(r1, r14)
            float r7 = r7.f3867a
            float r15 = (float) r15
            float r7 = r7 * r15
            float r7 = r7 / r13
            int r7 = (int) r7
            int r11 = r11 + r7
            r7 = 1073741824(0x40000000, float:2.0)
            int r11 = android.view.View.MeasureSpec.makeMeasureSpec(r11, r7)
            r6.measure(r11, r10)
        L_0x0206:
            int r3 = r3 + 1
            r1 = r19
            r15 = 8
            goto L_0x012e
        L_0x020e:
            int r1 = r20.getPaddingTop()
            int r4 = r4 + r1
            int r1 = r20.getPaddingBottom()
            int r4 = r4 + r1
            r0.setMeasuredDimension(r2, r4)
            r0.f3848f = r12
            a1.c r1 = r0.f3858p
            int r1 = r1.B()
            if (r1 == 0) goto L_0x022c
            if (r12 != 0) goto L_0x022c
            a1.c r1 = r0.f3858p
            r1.a()
        L_0x022c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        if (savedState.f3871c) {
            m();
        } else {
            a();
        }
        this.f3859q = savedState.f3871c;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f3871c = k() ? j() : this.f3859q;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (i10 != i12) {
            this.f3860r = true;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f3848f) {
            return super.onTouchEvent(motionEvent);
        }
        this.f3858p.G(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            this.f3855m = x10;
            this.f3856n = y10;
        } else if (actionMasked == 1 && h(this.f3849g)) {
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            float f10 = x11 - this.f3855m;
            float f11 = y11 - this.f3856n;
            int A = this.f3858p.A();
            if ((f10 * f10) + (f11 * f11) < ((float) (A * A)) && this.f3858p.F(this.f3849g, (int) x11, (int) y11)) {
                b(this.f3849g, 0);
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void p() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean q(float f10, int i10) {
        int i11;
        if (!this.f3848f) {
            return false;
        }
        boolean i12 = i();
        LayoutParams layoutParams = (LayoutParams) this.f3849g.getLayoutParams();
        if (i12) {
            i11 = (int) (((float) getWidth()) - ((((float) (getPaddingRight() + layoutParams.rightMargin)) + (f10 * ((float) this.f3852j))) + ((float) this.f3849g.getWidth())));
        } else {
            i11 = (int) (((float) (getPaddingLeft() + layoutParams.leftMargin)) + (f10 * ((float) this.f3852j)));
        }
        a1.c cVar = this.f3858p;
        View view = this.f3849g;
        if (!cVar.R(view, i11, view.getTop())) {
            return false;
        }
        p();
        x.h0(this);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void r(View view) {
        int i10;
        int i11;
        int i12;
        int i13;
        View childAt;
        boolean z10;
        View view2 = view;
        boolean i14 = i();
        int width = i14 ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = i14 ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 == null || !s(view)) {
            i13 = 0;
            i12 = 0;
            i11 = 0;
            i10 = 0;
        } else {
            i13 = view.getLeft();
            i12 = view.getRight();
            i11 = view.getTop();
            i10 = view.getBottom();
        }
        int childCount = getChildCount();
        int i15 = 0;
        while (true) {
            if (i15 < childCount && (childAt = getChildAt(i15)) != view2) {
                if (childAt.getVisibility() == 8) {
                    z10 = i14;
                } else {
                    z10 = i14;
                    childAt.setVisibility((Math.max(i14 ? paddingLeft : width, childAt.getLeft()) < i13 || Math.max(paddingTop, childAt.getTop()) < i11 || Math.min(i14 ? width : paddingLeft, childAt.getRight()) > i12 || Math.min(height, childAt.getBottom()) > i10) ? 0 : 4);
                }
                i15++;
                view2 = view;
                i14 = z10;
            } else {
                return;
            }
        }
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.f3848f) {
            this.f3859q = view == this.f3849g;
        }
    }

    public void setCoveredFadeColor(int i10) {
        this.f3844b = i10;
    }

    public void setPanelSlideListener(d dVar) {
        this.f3857o = dVar;
    }

    public void setParallaxDistance(int i10) {
        this.f3854l = i10;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(Drawable drawable) {
        this.f3845c = drawable;
    }

    public void setShadowDrawableRight(Drawable drawable) {
        this.f3846d = drawable;
    }

    @Deprecated
    public void setShadowResource(int i10) {
        setShadowDrawable(getResources().getDrawable(i10));
    }

    public void setShadowResourceLeft(int i10) {
        setShadowDrawableLeft(androidx.core.content.a.f(getContext(), i10));
    }

    public void setShadowResourceRight(int i10) {
        setShadowDrawableRight(androidx.core.content.a.f(getContext(), i10));
    }

    public void setSliderFadeColor(int i10) {
        this.f3843a = i10;
    }
}
