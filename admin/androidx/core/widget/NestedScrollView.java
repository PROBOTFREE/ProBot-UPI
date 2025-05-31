package androidx.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.view.l;
import androidx.core.view.m;
import androidx.core.view.o;
import androidx.core.view.q;
import androidx.core.view.x;
import java.util.ArrayList;
import x0.c;
import x0.e;

public class NestedScrollView extends FrameLayout implements o, l {
    private static final a A = new a();
    private static final int[] B = {16843130};

    /* renamed from: a  reason: collision with root package name */
    private long f2422a;

    /* renamed from: b  reason: collision with root package name */
    private final Rect f2423b;

    /* renamed from: c  reason: collision with root package name */
    private OverScroller f2424c;

    /* renamed from: d  reason: collision with root package name */
    private EdgeEffect f2425d;

    /* renamed from: e  reason: collision with root package name */
    private EdgeEffect f2426e;

    /* renamed from: f  reason: collision with root package name */
    private int f2427f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f2428g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f2429h;

    /* renamed from: i  reason: collision with root package name */
    private View f2430i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f2431j;

    /* renamed from: k  reason: collision with root package name */
    private VelocityTracker f2432k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f2433l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f2434m;

    /* renamed from: n  reason: collision with root package name */
    private int f2435n;

    /* renamed from: o  reason: collision with root package name */
    private int f2436o;

    /* renamed from: p  reason: collision with root package name */
    private int f2437p;

    /* renamed from: q  reason: collision with root package name */
    private int f2438q;

    /* renamed from: r  reason: collision with root package name */
    private final int[] f2439r;

    /* renamed from: s  reason: collision with root package name */
    private final int[] f2440s;

    /* renamed from: t  reason: collision with root package name */
    private int f2441t;

    /* renamed from: u  reason: collision with root package name */
    private int f2442u;

    /* renamed from: v  reason: collision with root package name */
    private SavedState f2443v;

    /* renamed from: w  reason: collision with root package name */
    private final q f2444w;

    /* renamed from: x  reason: collision with root package name */
    private final m f2445x;

    /* renamed from: y  reason: collision with root package name */
    private float f2446y;

    /* renamed from: z  reason: collision with root package name */
    private b f2447z;

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public int f2448a;

        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f2448a = parcel.readInt();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f2448a + "}";
        }

        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f2448a);
        }
    }

    static class a extends androidx.core.view.a {
        a() {
        }

        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            e.a(accessibilityEvent, nestedScrollView.getScrollX());
            e.b(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        public void g(View view, c cVar) {
            int scrollRange;
            super.g(view, cVar);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            cVar.c0(ScrollView.class.getName());
            if (nestedScrollView.isEnabled() && (scrollRange = nestedScrollView.getScrollRange()) > 0) {
                cVar.y0(true);
                if (nestedScrollView.getScrollY() > 0) {
                    cVar.b(c.a.f18126i);
                    cVar.b(c.a.f18130m);
                }
                if (nestedScrollView.getScrollY() < scrollRange) {
                    cVar.b(c.a.f18125h);
                    cVar.b(c.a.f18131n);
                }
            }
        }

        public boolean j(View view, int i10, Bundle bundle) {
            if (super.j(view, i10, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            if (i10 != 4096) {
                if (i10 == 8192 || i10 == 16908344) {
                    int max = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (max == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.O(0, max, true);
                    return true;
                } else if (i10 != 16908346) {
                    return false;
                }
            }
            int min = Math.min(nestedScrollView.getScrollY() + ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (min == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.O(0, min, true);
            return true;
        }
    }

    public interface b {
        void onScrollChange(NestedScrollView nestedScrollView, int i10, int i11, int i12, int i13);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, m0.a.nestedScrollViewStyle);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2423b = new Rect();
        this.f2428g = true;
        this.f2429h = false;
        this.f2430i = null;
        this.f2431j = false;
        this.f2434m = true;
        this.f2438q = -1;
        this.f2439r = new int[2];
        this.f2440s = new int[2];
        x();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, B, i10, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.f2444w = new q(this);
        this.f2445x = new m(this);
        setNestedScrollingEnabled(true);
        x.r0(this, A);
    }

    private static boolean A(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        return (parent instanceof ViewGroup) && A((View) parent, view2);
    }

    private boolean B(View view, int i10, int i11) {
        view.getDrawingRect(this.f2423b);
        offsetDescendantRectToMyCoords(view, this.f2423b);
        return this.f2423b.bottom + i10 >= getScrollY() && this.f2423b.top - i10 <= getScrollY() + i11;
    }

    private void C(int i10, int i11, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i10);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.f2445x.e(0, scrollY2, 0, i10 - scrollY2, (int[]) null, i11, iArr);
    }

    private void D(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f2438q) {
            int i10 = actionIndex == 0 ? 1 : 0;
            this.f2427f = (int) motionEvent.getY(i10);
            this.f2438q = motionEvent.getPointerId(i10);
            VelocityTracker velocityTracker = this.f2432k;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void G() {
        VelocityTracker velocityTracker = this.f2432k;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f2432k = null;
        }
    }

    private void H(boolean z10) {
        if (z10) {
            P(2, 1);
        } else {
            Q(1);
        }
        this.f2442u = getScrollY();
        x.h0(this);
    }

    private boolean I(int i10, int i11, int i12) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i13 = height + scrollY;
        boolean z10 = false;
        boolean z11 = i10 == 33;
        View r10 = r(z11, i11, i12);
        if (r10 == null) {
            r10 = this;
        }
        if (i11 < scrollY || i12 > i13) {
            k(z11 ? i11 - scrollY : i12 - i13);
            z10 = true;
        }
        if (r10 != findFocus()) {
            r10.requestFocus(i10);
        }
        return z10;
    }

    private void J(View view) {
        view.getDrawingRect(this.f2423b);
        offsetDescendantRectToMyCoords(view, this.f2423b);
        int f10 = f(this.f2423b);
        if (f10 != 0) {
            scrollBy(0, f10);
        }
    }

    private boolean K(Rect rect, boolean z10) {
        int f10 = f(rect);
        boolean z11 = f10 != 0;
        if (z11) {
            if (z10) {
                scrollBy(0, f10);
            } else {
                L(0, f10);
            }
        }
        return z11;
    }

    private void M(int i10, int i11, int i12, boolean z10) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.f2422a > 250) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                int scrollY = getScrollY();
                OverScroller overScroller = this.f2424c;
                int scrollX = getScrollX();
                overScroller.startScroll(scrollX, scrollY, 0, Math.max(0, Math.min(i11 + scrollY, Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom())))) - scrollY, i12);
                H(z10);
            } else {
                if (!this.f2424c.isFinished()) {
                    a();
                }
                scrollBy(i10, i11);
            }
            this.f2422a = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    private void a() {
        this.f2424c.abortAnimation();
        Q(1);
    }

    private boolean d() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private static int e(int i10, int i11, int i12) {
        if (i11 >= i12 || i10 < 0) {
            return 0;
        }
        return i11 + i10 > i12 ? i12 - i11 : i10;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f2446y == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.f2446y = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.f2446y;
    }

    private void k(int i10) {
        if (i10 == 0) {
            return;
        }
        if (this.f2434m) {
            L(0, i10);
        } else {
            scrollBy(0, i10);
        }
    }

    private void l() {
        this.f2431j = false;
        G();
        Q(0);
        EdgeEffect edgeEffect = this.f2425d;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            this.f2426e.onRelease();
        }
    }

    private void p() {
        if (getOverScrollMode() == 2) {
            this.f2425d = null;
            this.f2426e = null;
        } else if (this.f2425d == null) {
            Context context = getContext();
            this.f2425d = new EdgeEffect(context);
            this.f2426e = new EdgeEffect(context);
        }
    }

    private View r(boolean z10, int i10, int i11) {
        ArrayList focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z11 = false;
        for (int i12 = 0; i12 < size; i12++) {
            View view2 = (View) focusables.get(i12);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i10 < bottom && top < i11) {
                boolean z12 = i10 < top && bottom < i11;
                if (view == null) {
                    view = view2;
                    z11 = z12;
                } else {
                    boolean z13 = (z10 && top < view.getTop()) || (!z10 && bottom > view.getBottom());
                    if (z11) {
                        if (z12) {
                            if (!z13) {
                            }
                        }
                    } else if (z12) {
                        view = view2;
                        z11 = true;
                    } else if (!z13) {
                    }
                    view = view2;
                }
            }
        }
        return view;
    }

    private boolean v(int i10, int i11) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i11 >= childAt.getTop() - scrollY && i11 < childAt.getBottom() - scrollY && i10 >= childAt.getLeft() && i10 < childAt.getRight();
    }

    private void w() {
        VelocityTracker velocityTracker = this.f2432k;
        if (velocityTracker == null) {
            this.f2432k = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void x() {
        this.f2424c = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f2435n = viewConfiguration.getScaledTouchSlop();
        this.f2436o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f2437p = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void y() {
        if (this.f2432k == null) {
            this.f2432k = VelocityTracker.obtain();
        }
    }

    private boolean z(View view) {
        return !B(view, 0, getHeight());
    }

    /* access modifiers changed from: package-private */
    public boolean E(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, boolean z10) {
        boolean z11;
        boolean z12;
        int overScrollMode = getOverScrollMode();
        boolean z13 = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        boolean z14 = computeVerticalScrollRange() > computeVerticalScrollExtent();
        boolean z15 = overScrollMode == 0 || (overScrollMode == 1 && z13);
        boolean z16 = overScrollMode == 0 || (overScrollMode == 1 && z14);
        int i18 = i12 + i10;
        int i19 = !z15 ? 0 : i16;
        int i20 = i13 + i11;
        int i21 = !z16 ? 0 : i17;
        int i22 = -i19;
        int i23 = i19 + i14;
        int i24 = -i21;
        int i25 = i21 + i15;
        if (i18 > i23) {
            i18 = i23;
            z11 = true;
        } else if (i18 < i22) {
            z11 = true;
            i18 = i22;
        } else {
            z11 = false;
        }
        if (i20 > i25) {
            i20 = i25;
            z12 = true;
        } else if (i20 < i24) {
            z12 = true;
            i20 = i24;
        } else {
            z12 = false;
        }
        if (z12 && !u(1)) {
            this.f2424c.springBack(i18, i20, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i18, i20, z11, z12);
        return z11 || z12;
    }

    public boolean F(int i10) {
        boolean z10 = i10 == 130;
        int height = getHeight();
        if (z10) {
            this.f2423b.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect = this.f2423b;
                if (rect.top + height > bottom) {
                    rect.top = bottom - height;
                }
            }
        } else {
            this.f2423b.top = getScrollY() - height;
            Rect rect2 = this.f2423b;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.f2423b;
        int i11 = rect3.top;
        int i12 = height + i11;
        rect3.bottom = i12;
        return I(i10, i11, i12);
    }

    public final void L(int i10, int i11) {
        M(i10, i11, 250, false);
    }

    /* access modifiers changed from: package-private */
    public void N(int i10, int i11, int i12, boolean z10) {
        M(i10 - getScrollX(), i11 - getScrollY(), i12, z10);
    }

    /* access modifiers changed from: package-private */
    public void O(int i10, int i11, boolean z10) {
        N(i10, i11, 250, z10);
    }

    public boolean P(int i10, int i11) {
        return this.f2445x.p(i10, i11);
    }

    public void Q(int i10) {
        this.f2445x.r(i10);
    }

    public void addView(View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, int i10) {
        if (getChildCount() <= 0) {
            super.addView(view, i10);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i10, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public boolean b(int i10) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i10);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !B(findNextFocus, maxScrollAmount, getHeight())) {
            if (i10 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i10 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i10 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            k(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.f2423b);
            offsetDescendantRectToMyCoords(findNextFocus, this.f2423b);
            k(f(this.f2423b));
            findNextFocus.requestFocus(i10);
        }
        if (findFocus == null || !findFocus.isFocused() || !z(findFocus)) {
            return true;
        }
        int descendantFocusability = getDescendantFocusability();
        setDescendantFocusability(131072);
        requestFocus();
        setDescendantFocusability(descendantFocusability);
        return true;
    }

    public void c(View view, View view2, int i10, int i11) {
        this.f2444w.c(view, view2, i10, i11);
        P(2, i11);
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public void computeScroll() {
        EdgeEffect edgeEffect;
        if (!this.f2424c.isFinished()) {
            this.f2424c.computeScrollOffset();
            int currY = this.f2424c.getCurrY();
            int i10 = currY - this.f2442u;
            this.f2442u = currY;
            int[] iArr = this.f2440s;
            boolean z10 = false;
            iArr[1] = 0;
            g(0, i10, iArr, (int[]) null, 1);
            int i11 = i10 - this.f2440s[1];
            int scrollRange = getScrollRange();
            if (i11 != 0) {
                int scrollY = getScrollY();
                E(0, i11, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
                int scrollY2 = getScrollY() - scrollY;
                int i12 = i11 - scrollY2;
                int[] iArr2 = this.f2440s;
                iArr2[1] = 0;
                h(0, scrollY2, 0, i12, this.f2439r, 1, iArr2);
                i11 = i12 - this.f2440s[1];
            }
            if (i11 != 0) {
                int overScrollMode = getOverScrollMode();
                if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                    z10 = true;
                }
                if (z10) {
                    p();
                    if (i11 < 0) {
                        if (this.f2425d.isFinished()) {
                            edgeEffect = this.f2425d;
                        }
                    } else if (this.f2426e.isFinished()) {
                        edgeEffect = this.f2426e;
                    }
                    edgeEffect.onAbsorb((int) this.f2424c.getCurrVelocity());
                }
                a();
            }
            if (!this.f2424c.isFinished()) {
                x.h0(this);
            } else {
                Q(1);
            }
        }
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > max ? bottom + (scrollY - max) : bottom;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || q(keyEvent);
    }

    public boolean dispatchNestedFling(float f10, float f11, boolean z10) {
        return this.f2445x.a(f10, f11, z10);
    }

    public boolean dispatchNestedPreFling(float f10, float f11) {
        return this.f2445x.b(f10, f11);
    }

    public boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2) {
        return g(i10, i11, iArr, iArr2, 0);
    }

    public boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr) {
        return this.f2445x.f(i10, i11, i12, i13, iArr);
    }

    public void draw(Canvas canvas) {
        int i10;
        super.draw(canvas);
        if (this.f2425d != null) {
            int scrollY = getScrollY();
            int i11 = 0;
            if (!this.f2425d.isFinished()) {
                int save = canvas.save();
                int width = getWidth();
                int height = getHeight();
                int min = Math.min(0, scrollY);
                int i12 = Build.VERSION.SDK_INT;
                if (i12 < 21 || getClipToPadding()) {
                    width -= getPaddingLeft() + getPaddingRight();
                    i10 = getPaddingLeft() + 0;
                } else {
                    i10 = 0;
                }
                if (i12 >= 21 && getClipToPadding()) {
                    height -= getPaddingTop() + getPaddingBottom();
                    min += getPaddingTop();
                }
                canvas.translate((float) i10, (float) min);
                this.f2425d.setSize(width, height);
                if (this.f2425d.draw(canvas)) {
                    x.h0(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.f2426e.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = getHeight();
                int max = Math.max(getScrollRange(), scrollY) + height2;
                int i13 = Build.VERSION.SDK_INT;
                if (i13 < 21 || getClipToPadding()) {
                    width2 -= getPaddingLeft() + getPaddingRight();
                    i11 = 0 + getPaddingLeft();
                }
                if (i13 >= 21 && getClipToPadding()) {
                    height2 -= getPaddingTop() + getPaddingBottom();
                    max -= getPaddingBottom();
                }
                canvas.translate((float) (i11 - width2), (float) max);
                canvas.rotate(180.0f, (float) width2, 0.0f);
                this.f2426e.setSize(width2, height2);
                if (this.f2426e.draw(canvas)) {
                    x.h0(this);
                }
                canvas.restoreToCount(save2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public int f(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i10 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i11 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i10 - verticalFadingEdgeLength : i10;
        int i12 = rect.bottom;
        if (i12 > i11 && rect.top > scrollY) {
            return Math.min((rect.height() > height ? rect.top - scrollY : rect.bottom - i11) + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i10);
        } else if (rect.top >= scrollY || i12 >= i11) {
            return 0;
        } else {
            return Math.max(rect.height() > height ? 0 - (i11 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
        }
    }

    public boolean g(int i10, int i11, int[] iArr, int[] iArr2, int i12) {
        return this.f2445x.d(i10, i11, iArr, iArr2, i12);
    }

    /* access modifiers changed from: protected */
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return ((float) bottom) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (((float) getHeight()) * 0.5f);
    }

    public int getNestedScrollAxes() {
        return this.f2444w.a();
    }

    /* access modifiers changed from: package-private */
    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    /* access modifiers changed from: protected */
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return ((float) scrollY) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public void h(int i10, int i11, int i12, int i13, int[] iArr, int i14, int[] iArr2) {
        this.f2445x.e(i10, i11, i12, i13, iArr, i14, iArr2);
    }

    public boolean hasNestedScrollingParent() {
        return u(0);
    }

    public void i(View view, int i10) {
        this.f2444w.e(view, i10);
        Q(i10);
    }

    public boolean isNestedScrollingEnabled() {
        return this.f2445x.l();
    }

    public void j(View view, int i10, int i11, int[] iArr, int i12) {
        g(i10, i11, iArr, (int[]) null, i12);
    }

    public void m(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        C(i13, i14, iArr);
    }

    /* access modifiers changed from: protected */
    public void measureChild(View view, int i10, int i11) {
        view.measure(FrameLayout.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    /* access modifiers changed from: protected */
    public void measureChildWithMargins(View view, int i10, int i11, int i12, int i13) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(FrameLayout.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    public void n(View view, int i10, int i11, int i12, int i13, int i14) {
        C(i13, i14, (int[]) null);
    }

    public boolean o(View view, View view2, int i10, int i11) {
        return (i10 & 2) != 0;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2429h = false;
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8 && !this.f2431j) {
            float axisValue = motionEvent.getAxisValue(9);
            if (axisValue != 0.0f) {
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int verticalScrollFactorCompat = scrollY - ((int) (axisValue * getVerticalScrollFactorCompat()));
                if (verticalScrollFactorCompat < 0) {
                    scrollRange = 0;
                } else if (verticalScrollFactorCompat <= scrollRange) {
                    scrollRange = verticalScrollFactorCompat;
                }
                if (scrollRange != scrollY) {
                    super.scrollTo(getScrollX(), scrollRange);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 2 && this.f2431j) {
            return true;
        }
        int i10 = action & 255;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 2) {
                    int i11 = this.f2438q;
                    if (i11 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i11);
                        if (findPointerIndex == -1) {
                            Log.e("NestedScrollView", "Invalid pointerId=" + i11 + " in onInterceptTouchEvent");
                        } else {
                            int y10 = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y10 - this.f2427f) > this.f2435n && (2 & getNestedScrollAxes()) == 0) {
                                this.f2431j = true;
                                this.f2427f = y10;
                                y();
                                this.f2432k.addMovement(motionEvent);
                                this.f2441t = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                } else if (i10 != 3) {
                    if (i10 == 6) {
                        D(motionEvent);
                    }
                }
            }
            this.f2431j = false;
            this.f2438q = -1;
            G();
            if (this.f2424c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                x.h0(this);
            }
            Q(0);
        } else {
            int y11 = (int) motionEvent.getY();
            if (!v((int) motionEvent.getX(), y11)) {
                this.f2431j = false;
                G();
            } else {
                this.f2427f = y11;
                this.f2438q = motionEvent.getPointerId(0);
                w();
                this.f2432k.addMovement(motionEvent);
                this.f2424c.computeScrollOffset();
                this.f2431j = !this.f2424c.isFinished();
                P(2, 0);
            }
        }
        return this.f2431j;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        int i14 = 0;
        this.f2428g = false;
        View view = this.f2430i;
        if (view != null && A(view, this)) {
            J(this.f2430i);
        }
        this.f2430i = null;
        if (!this.f2429h) {
            if (this.f2443v != null) {
                scrollTo(getScrollX(), this.f2443v.f2448a);
                this.f2443v = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i14 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i13 - i11) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int e10 = e(scrollY, paddingTop, i14);
            if (e10 != scrollY) {
                scrollTo(getScrollX(), e10);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f2429h = true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f2433l && View.MeasureSpec.getMode(i11) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(FrameLayout.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        if (z10) {
            return false;
        }
        dispatchNestedFling(0.0f, f11, true);
        s((int) f11);
        return true;
    }

    public boolean onNestedPreFling(View view, float f10, float f11) {
        return dispatchNestedPreFling(f10, f11);
    }

    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
        j(view, i10, i11, iArr, 0);
    }

    public void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        C(i13, 0, (int[]) null);
    }

    public void onNestedScrollAccepted(View view, View view2, int i10) {
        c(view, view2, i10, 0);
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i10, int i11, boolean z10, boolean z11) {
        super.scrollTo(i10, i11);
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i10, Rect rect) {
        if (i10 == 2) {
            i10 = 130;
        } else if (i10 == 1) {
            i10 = 33;
        }
        FocusFinder instance = FocusFinder.getInstance();
        View findNextFocus = rect == null ? instance.findNextFocus(this, (View) null, i10) : instance.findNextFocusFromRect(this, rect, i10);
        if (findNextFocus != null && !z(findNextFocus)) {
            return findNextFocus.requestFocus(i10, rect);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f2443v = savedState;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f2448a = getScrollY();
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i10, int i11, int i12, int i13) {
        super.onScrollChanged(i10, i11, i12, i13);
        b bVar = this.f2447z;
        if (bVar != null) {
            bVar.onScrollChange(this, i10, i11, i12, i13);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && B(findFocus, 0, i13)) {
            findFocus.getDrawingRect(this.f2423b);
            offsetDescendantRectToMyCoords(findFocus, this.f2423b);
            k(f(this.f2423b));
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i10) {
        return o(view, view2, i10, 0);
    }

    public void onStopNestedScroll(View view) {
        i(view, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0076, code lost:
        if (r10.f2424c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) != false) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0210, code lost:
        if (r10.f2424c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) != false) goto L_0x0078;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r24) {
        /*
            r23 = this;
            r10 = r23
            r11 = r24
            r23.y()
            int r0 = r24.getActionMasked()
            r12 = 0
            if (r0 != 0) goto L_0x0010
            r10.f2441t = r12
        L_0x0010:
            android.view.MotionEvent r13 = android.view.MotionEvent.obtain(r24)
            int r1 = r10.f2441t
            float r1 = (float) r1
            r2 = 0
            r13.offsetLocation(r2, r1)
            r1 = 2
            r14 = 1
            if (r0 == 0) goto L_0x0214
            r3 = -1
            if (r0 == r14) goto L_0x01cf
            if (r0 == r1) goto L_0x0082
            r1 = 3
            if (r0 == r1) goto L_0x0054
            r1 = 5
            if (r0 == r1) goto L_0x0041
            r1 = 6
            if (r0 == r1) goto L_0x002f
            goto L_0x024a
        L_0x002f:
            r23.D(r24)
            int r0 = r10.f2438q
            int r0 = r11.findPointerIndex(r0)
            float r0 = r11.getY(r0)
            int r0 = (int) r0
            r10.f2427f = r0
            goto L_0x024a
        L_0x0041:
            int r0 = r24.getActionIndex()
            float r1 = r11.getY(r0)
            int r1 = (int) r1
            r10.f2427f = r1
            int r0 = r11.getPointerId(r0)
            r10.f2438q = r0
            goto L_0x024a
        L_0x0054:
            boolean r0 = r10.f2431j
            if (r0 == 0) goto L_0x007b
            int r0 = r23.getChildCount()
            if (r0 <= 0) goto L_0x007b
            android.widget.OverScroller r15 = r10.f2424c
            int r16 = r23.getScrollX()
            int r17 = r23.getScrollY()
            r18 = 0
            r19 = 0
            r20 = 0
            int r21 = r23.getScrollRange()
            boolean r0 = r15.springBack(r16, r17, r18, r19, r20, r21)
            if (r0 == 0) goto L_0x007b
        L_0x0078:
            androidx.core.view.x.h0(r23)
        L_0x007b:
            r10.f2438q = r3
            r23.l()
            goto L_0x024a
        L_0x0082:
            int r0 = r10.f2438q
            int r15 = r11.findPointerIndex(r0)
            if (r15 != r3) goto L_0x00a9
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Invalid pointerId="
            r0.append(r1)
            int r1 = r10.f2438q
            r0.append(r1)
            java.lang.String r1 = " in onTouchEvent"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "NestedScrollView"
            android.util.Log.e(r1, r0)
            goto L_0x024a
        L_0x00a9:
            float r0 = r11.getY(r15)
            int r6 = (int) r0
            int r0 = r10.f2427f
            int r0 = r0 - r6
            boolean r1 = r10.f2431j
            if (r1 != 0) goto L_0x00cf
            int r1 = java.lang.Math.abs(r0)
            int r2 = r10.f2435n
            if (r1 <= r2) goto L_0x00cf
            android.view.ViewParent r1 = r23.getParent()
            if (r1 == 0) goto L_0x00c6
            r1.requestDisallowInterceptTouchEvent(r14)
        L_0x00c6:
            r10.f2431j = r14
            int r1 = r10.f2435n
            if (r0 <= 0) goto L_0x00ce
            int r0 = r0 - r1
            goto L_0x00cf
        L_0x00ce:
            int r0 = r0 + r1
        L_0x00cf:
            r7 = r0
            boolean r0 = r10.f2431j
            if (r0 == 0) goto L_0x024a
            r1 = 0
            int[] r3 = r10.f2440s
            int[] r4 = r10.f2439r
            r5 = 0
            r0 = r23
            r2 = r7
            boolean r0 = r0.g(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x00f1
            int[] r0 = r10.f2440s
            r0 = r0[r14]
            int r7 = r7 - r0
            int r0 = r10.f2441t
            int[] r1 = r10.f2439r
            r1 = r1[r14]
            int r0 = r0 + r1
            r10.f2441t = r0
        L_0x00f1:
            r16 = r7
            int[] r0 = r10.f2439r
            r0 = r0[r14]
            int r6 = r6 - r0
            r10.f2427f = r6
            int r17 = r23.getScrollY()
            int r9 = r23.getScrollRange()
            int r0 = r23.getOverScrollMode()
            if (r0 == 0) goto L_0x0110
            if (r0 != r14) goto L_0x010d
            if (r9 <= 0) goto L_0x010d
            goto L_0x0110
        L_0x010d:
            r18 = r12
            goto L_0x0112
        L_0x0110:
            r18 = r14
        L_0x0112:
            r1 = 0
            r3 = 0
            int r4 = r23.getScrollY()
            r5 = 0
            r7 = 0
            r8 = 0
            r19 = 1
            r0 = r23
            r2 = r16
            r6 = r9
            r22 = r9
            r9 = r19
            boolean r0 = r0.E(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            if (r0 == 0) goto L_0x0137
            boolean r0 = r10.u(r12)
            if (r0 != 0) goto L_0x0137
            android.view.VelocityTracker r0 = r10.f2432k
            r0.clear()
        L_0x0137:
            int r0 = r23.getScrollY()
            int r2 = r0 - r17
            int r4 = r16 - r2
            int[] r7 = r10.f2440s
            r7[r14] = r12
            r1 = 0
            r3 = 0
            int[] r5 = r10.f2439r
            r6 = 0
            r0 = r23
            r0.h(r1, r2, r3, r4, r5, r6, r7)
            int r0 = r10.f2427f
            int[] r1 = r10.f2439r
            r2 = r1[r14]
            int r0 = r0 - r2
            r10.f2427f = r0
            int r0 = r10.f2441t
            r1 = r1[r14]
            int r0 = r0 + r1
            r10.f2441t = r0
            if (r18 == 0) goto L_0x024a
            int[] r0 = r10.f2440s
            r0 = r0[r14]
            int r0 = r16 - r0
            r23.p()
            int r1 = r17 + r0
            if (r1 >= 0) goto L_0x0190
            android.widget.EdgeEffect r1 = r10.f2425d
            float r0 = (float) r0
            int r2 = r23.getHeight()
            float r2 = (float) r2
            float r0 = r0 / r2
            float r2 = r11.getX(r15)
            int r3 = r23.getWidth()
            float r3 = (float) r3
            float r2 = r2 / r3
            androidx.core.widget.f.a(r1, r0, r2)
            android.widget.EdgeEffect r0 = r10.f2426e
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L_0x01b8
            android.widget.EdgeEffect r0 = r10.f2426e
        L_0x018c:
            r0.onRelease()
            goto L_0x01b8
        L_0x0190:
            r2 = r22
            if (r1 <= r2) goto L_0x01b8
            android.widget.EdgeEffect r1 = r10.f2426e
            float r0 = (float) r0
            int r2 = r23.getHeight()
            float r2 = (float) r2
            float r0 = r0 / r2
            r2 = 1065353216(0x3f800000, float:1.0)
            float r3 = r11.getX(r15)
            int r4 = r23.getWidth()
            float r4 = (float) r4
            float r3 = r3 / r4
            float r2 = r2 - r3
            androidx.core.widget.f.a(r1, r0, r2)
            android.widget.EdgeEffect r0 = r10.f2425d
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L_0x01b8
            android.widget.EdgeEffect r0 = r10.f2425d
            goto L_0x018c
        L_0x01b8:
            android.widget.EdgeEffect r0 = r10.f2425d
            if (r0 == 0) goto L_0x024a
            boolean r0 = r0.isFinished()
            if (r0 == 0) goto L_0x01ca
            android.widget.EdgeEffect r0 = r10.f2426e
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L_0x024a
        L_0x01ca:
            androidx.core.view.x.h0(r23)
            goto L_0x024a
        L_0x01cf:
            android.view.VelocityTracker r0 = r10.f2432k
            r1 = 1000(0x3e8, float:1.401E-42)
            int r4 = r10.f2437p
            float r4 = (float) r4
            r0.computeCurrentVelocity(r1, r4)
            int r1 = r10.f2438q
            float r0 = r0.getYVelocity(r1)
            int r0 = (int) r0
            int r1 = java.lang.Math.abs(r0)
            int r4 = r10.f2436o
            if (r1 < r4) goto L_0x01f8
            int r0 = -r0
            float r1 = (float) r0
            boolean r4 = r10.dispatchNestedPreFling(r2, r1)
            if (r4 != 0) goto L_0x007b
            r10.dispatchNestedFling(r2, r1, r14)
            r10.s(r0)
            goto L_0x007b
        L_0x01f8:
            android.widget.OverScroller r15 = r10.f2424c
            int r16 = r23.getScrollX()
            int r17 = r23.getScrollY()
            r18 = 0
            r19 = 0
            r20 = 0
            int r21 = r23.getScrollRange()
            boolean r0 = r15.springBack(r16, r17, r18, r19, r20, r21)
            if (r0 == 0) goto L_0x007b
            goto L_0x0078
        L_0x0214:
            int r0 = r23.getChildCount()
            if (r0 != 0) goto L_0x021b
            return r12
        L_0x021b:
            android.widget.OverScroller r0 = r10.f2424c
            boolean r0 = r0.isFinished()
            r0 = r0 ^ r14
            r10.f2431j = r0
            if (r0 == 0) goto L_0x022f
            android.view.ViewParent r0 = r23.getParent()
            if (r0 == 0) goto L_0x022f
            r0.requestDisallowInterceptTouchEvent(r14)
        L_0x022f:
            android.widget.OverScroller r0 = r10.f2424c
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L_0x023a
            r23.a()
        L_0x023a:
            float r0 = r24.getY()
            int r0 = (int) r0
            r10.f2427f = r0
            int r0 = r11.getPointerId(r12)
            r10.f2438q = r0
            r10.P(r1, r12)
        L_0x024a:
            android.view.VelocityTracker r0 = r10.f2432k
            if (r0 == 0) goto L_0x0251
            r0.addMovement(r13)
        L_0x0251:
            r13.recycle()
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean q(KeyEvent keyEvent) {
        this.f2423b.setEmpty();
        int i10 = 130;
        if (!d()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            return (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(130)) ? false : true;
        } else if (keyEvent.getAction() != 0) {
            return false;
        } else {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 19) {
                return !keyEvent.isAltPressed() ? b(33) : t(33);
            }
            if (keyCode == 20) {
                return !keyEvent.isAltPressed() ? b(130) : t(130);
            }
            if (keyCode != 62) {
                return false;
            }
            if (keyEvent.isShiftPressed()) {
                i10 = 33;
            }
            F(i10);
            return false;
        }
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.f2428g) {
            J(view2);
        } else {
            this.f2430i = view2;
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z10) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return K(rect, z10);
    }

    public void requestDisallowInterceptTouchEvent(boolean z10) {
        if (z10) {
            G();
        }
        super.requestDisallowInterceptTouchEvent(z10);
    }

    public void requestLayout() {
        this.f2428g = true;
        super.requestLayout();
    }

    public void s(int i10) {
        if (getChildCount() > 0) {
            this.f2424c.fling(getScrollX(), getScrollY(), 0, i10, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            H(true);
        }
    }

    public void scrollTo(int i10, int i11) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int e10 = e(i10, (getWidth() - getPaddingLeft()) - getPaddingRight(), childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
            int e11 = e(i11, (getHeight() - getPaddingTop()) - getPaddingBottom(), childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
            if (e10 != getScrollX() || e11 != getScrollY()) {
                super.scrollTo(e10, e11);
            }
        }
    }

    public void setFillViewport(boolean z10) {
        if (z10 != this.f2433l) {
            this.f2433l = z10;
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean z10) {
        this.f2445x.m(z10);
    }

    public void setOnScrollChangeListener(b bVar) {
        this.f2447z = bVar;
    }

    public void setSmoothScrollingEnabled(boolean z10) {
        this.f2434m = z10;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public boolean startNestedScroll(int i10) {
        return P(i10, 0);
    }

    public void stopNestedScroll() {
        Q(0);
    }

    public boolean t(int i10) {
        int childCount;
        boolean z10 = i10 == 130;
        int height = getHeight();
        Rect rect = this.f2423b;
        rect.top = 0;
        rect.bottom = height;
        if (z10 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.f2423b.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.f2423b;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.f2423b;
        return I(i10, rect3.top, rect3.bottom);
    }

    public boolean u(int i10) {
        return this.f2445x.k(i10);
    }
}
