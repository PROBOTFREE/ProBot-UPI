package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.core.view.f0;
import androidx.core.view.r;
import androidx.core.view.x;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager extends ViewGroup {
    private static final int CLOSE_ENOUGH = 2;
    private static final Comparator<f> COMPARATOR = new a();
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = -1;
    static final int[] LAYOUT_ATTRS = {16842931};
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE = false;
    private static final Interpolator sInterpolator = new b();
    private static final l sPositionComparator = new l();
    private int mActivePointerId = -1;
    a mAdapter;
    private List<h> mAdapterChangeListeners;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList<View> mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable = new c();
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout = true;
    private float mFirstOffset = -3.4028235E38f;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private i mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsScrollStarted;
    private boolean mIsUnableToDrag;
    private final ArrayList<f> mItems = new ArrayList<>();
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset = Float.MAX_VALUE;
    private EdgeEffect mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets = false;
    private k mObserver;
    private int mOffscreenPageLimit = 1;
    private i mOnPageChangeListener;
    private List<i> mOnPageChangeListeners;
    private int mPageMargin;
    private j mPageTransformer;
    private int mPageTransformerLayerType;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState = null;
    private ClassLoader mRestoredClassLoader = null;
    private int mRestoredCurItem = -1;
    private EdgeEffect mRightEdge;
    private int mScrollState = 0;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private final f mTempItem = new f();
    private final Rect mTempRect = new Rect();
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public boolean f4320a;

        /* renamed from: b  reason: collision with root package name */
        public int f4321b;

        /* renamed from: c  reason: collision with root package name */
        float f4322c = 0.0f;

        /* renamed from: d  reason: collision with root package name */
        boolean f4323d;

        /* renamed from: e  reason: collision with root package name */
        int f4324e;

        /* renamed from: f  reason: collision with root package name */
        int f4325f;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.LAYOUT_ATTRS);
            this.f4321b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        int f4326c;

        /* renamed from: d  reason: collision with root package name */
        Parcelable f4327d;

        /* renamed from: e  reason: collision with root package name */
        ClassLoader f4328e;

        static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f4326c = parcel.readInt();
            this.f4327d = parcel.readParcelable(classLoader);
            this.f4328e = classLoader;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f4326c + "}";
        }

        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f4326c);
            parcel.writeParcelable(this.f4327d, i10);
        }
    }

    static class a implements Comparator<f> {
        a() {
        }

        /* renamed from: a */
        public int compare(f fVar, f fVar2) {
            return fVar.f4333b - fVar2.f4333b;
        }
    }

    static class b implements Interpolator {
        b() {
        }

        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager.this.populate();
        }
    }

    class d implements r {

        /* renamed from: a  reason: collision with root package name */
        private final Rect f4330a = new Rect();

        d() {
        }

        public f0 a(View view, f0 f0Var) {
            f0 c02 = x.c0(view, f0Var);
            if (c02.q()) {
                return c02;
            }
            Rect rect = this.f4330a;
            rect.left = c02.k();
            rect.top = c02.m();
            rect.right = c02.l();
            rect.bottom = c02.j();
            int childCount = ViewPager.this.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                f0 h10 = x.h(ViewPager.this.getChildAt(i10), c02);
                rect.left = Math.min(h10.k(), rect.left);
                rect.top = Math.min(h10.m(), rect.top);
                rect.right = Math.min(h10.l(), rect.right);
                rect.bottom = Math.min(h10.j(), rect.bottom);
            }
            return c02.r(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Inherited
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface e {
    }

    static class f {

        /* renamed from: a  reason: collision with root package name */
        Object f4332a;

        /* renamed from: b  reason: collision with root package name */
        int f4333b;

        /* renamed from: c  reason: collision with root package name */
        boolean f4334c;

        /* renamed from: d  reason: collision with root package name */
        float f4335d;

        /* renamed from: e  reason: collision with root package name */
        float f4336e;

        f() {
        }
    }

    class g extends androidx.core.view.a {
        g() {
        }

        private boolean n() {
            a aVar = ViewPager.this.mAdapter;
            return aVar != null && aVar.getCount() > 1;
        }

        public void f(View view, AccessibilityEvent accessibilityEvent) {
            a aVar;
            super.f(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(n());
            if (accessibilityEvent.getEventType() == 4096 && (aVar = ViewPager.this.mAdapter) != null) {
                accessibilityEvent.setItemCount(aVar.getCount());
                accessibilityEvent.setFromIndex(ViewPager.this.mCurItem);
                accessibilityEvent.setToIndex(ViewPager.this.mCurItem);
            }
        }

        public void g(View view, x0.c cVar) {
            super.g(view, cVar);
            cVar.c0(ViewPager.class.getName());
            cVar.y0(n());
            if (ViewPager.this.canScrollHorizontally(1)) {
                cVar.a(RecyclerView.m.FLAG_APPEARED_IN_PRE_LAYOUT);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                cVar.a(8192);
            }
        }

        public boolean j(View view, int i10, Bundle bundle) {
            ViewPager viewPager;
            int i11;
            if (super.j(view, i10, bundle)) {
                return true;
            }
            if (i10 != 4096) {
                if (i10 != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                    return false;
                }
                viewPager = ViewPager.this;
                i11 = viewPager.mCurItem - 1;
            } else if (!ViewPager.this.canScrollHorizontally(1)) {
                return false;
            } else {
                viewPager = ViewPager.this;
                i11 = viewPager.mCurItem + 1;
            }
            viewPager.setCurrentItem(i11);
            return true;
        }
    }

    public interface h {
        void d(ViewPager viewPager, a aVar, a aVar2);
    }

    public interface i {
        void a(int i10, float f10, int i11);

        void b(int i10);

        void c(int i10);
    }

    public interface j {
        void a(View view, float f10);
    }

    private class k extends DataSetObserver {
        k() {
        }

        public void onChanged() {
            ViewPager.this.dataSetChanged();
        }

        public void onInvalidated() {
            ViewPager.this.dataSetChanged();
        }
    }

    static class l implements Comparator<View> {
        l() {
        }

        /* renamed from: a */
        public int compare(View view, View view2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            boolean z10 = layoutParams.f4320a;
            return z10 != layoutParams2.f4320a ? z10 ? 1 : -1 : layoutParams.f4324e - layoutParams2.f4324e;
        }
    }

    public ViewPager(Context context) {
        super(context);
        initViewPager();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initViewPager();
    }

    private void calculatePageOffsets(f fVar, int i10, f fVar2) {
        int i11;
        int i12;
        f fVar3;
        f fVar4;
        int count = this.mAdapter.getCount();
        int clientWidth = getClientWidth();
        float f10 = clientWidth > 0 ? ((float) this.mPageMargin) / ((float) clientWidth) : 0.0f;
        if (fVar2 != null) {
            int i13 = fVar2.f4333b;
            int i14 = fVar.f4333b;
            if (i13 < i14) {
                float f11 = fVar2.f4336e + fVar2.f4335d + f10;
                int i15 = i13 + 1;
                int i16 = 0;
                while (i15 <= fVar.f4333b && i16 < this.mItems.size()) {
                    while (true) {
                        fVar4 = this.mItems.get(i16);
                        if (i15 > fVar4.f4333b && i16 < this.mItems.size() - 1) {
                            i16++;
                        }
                    }
                    while (i15 < fVar4.f4333b) {
                        f11 += this.mAdapter.getPageWidth(i15) + f10;
                        i15++;
                    }
                    fVar4.f4336e = f11;
                    f11 += fVar4.f4335d + f10;
                    i15++;
                }
            } else if (i13 > i14) {
                int size = this.mItems.size() - 1;
                float f12 = fVar2.f4336e;
                while (true) {
                    i13--;
                    if (i13 < fVar.f4333b || size < 0) {
                        break;
                    }
                    while (true) {
                        fVar3 = this.mItems.get(size);
                        if (i13 < fVar3.f4333b && size > 0) {
                            size--;
                        }
                    }
                    while (i13 > fVar3.f4333b) {
                        f12 -= this.mAdapter.getPageWidth(i13) + f10;
                        i13--;
                    }
                    f12 -= fVar3.f4335d + f10;
                    fVar3.f4336e = f12;
                }
            }
        }
        int size2 = this.mItems.size();
        float f13 = fVar.f4336e;
        int i17 = fVar.f4333b;
        int i18 = i17 - 1;
        this.mFirstOffset = i17 == 0 ? f13 : -3.4028235E38f;
        int i19 = count - 1;
        this.mLastOffset = i17 == i19 ? (fVar.f4335d + f13) - 1.0f : Float.MAX_VALUE;
        int i20 = i10 - 1;
        while (i20 >= 0) {
            f fVar5 = this.mItems.get(i20);
            while (true) {
                i12 = fVar5.f4333b;
                if (i18 <= i12) {
                    break;
                }
                f13 -= this.mAdapter.getPageWidth(i18) + f10;
                i18--;
            }
            f13 -= fVar5.f4335d + f10;
            fVar5.f4336e = f13;
            if (i12 == 0) {
                this.mFirstOffset = f13;
            }
            i20--;
            i18--;
        }
        float f14 = fVar.f4336e + fVar.f4335d + f10;
        int i21 = fVar.f4333b + 1;
        int i22 = i10 + 1;
        while (i22 < size2) {
            f fVar6 = this.mItems.get(i22);
            while (true) {
                i11 = fVar6.f4333b;
                if (i21 >= i11) {
                    break;
                }
                f14 += this.mAdapter.getPageWidth(i21) + f10;
                i21++;
            }
            if (i11 == i19) {
                this.mLastOffset = (fVar6.f4335d + f14) - 1.0f;
            }
            fVar6.f4336e = f14;
            f14 += fVar6.f4335d + f10;
            i22++;
            i21++;
        }
        this.mNeedCalculatePageOffsets = false;
    }

    private void completeScroll(boolean z10) {
        boolean z11 = this.mScrollState == 2;
        if (z11) {
            setScrollingCacheEnabled(false);
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        pageScrolled(currX);
                    }
                }
            }
        }
        this.mPopulatePending = false;
        for (int i10 = 0; i10 < this.mItems.size(); i10++) {
            f fVar = this.mItems.get(i10);
            if (fVar.f4334c) {
                fVar.f4334c = false;
                z11 = true;
            }
        }
        if (!z11) {
            return;
        }
        if (z10) {
            x.j0(this, this.mEndScrollRunnable);
        } else {
            this.mEndScrollRunnable.run();
        }
    }

    private int determineTargetPage(int i10, float f10, int i11, int i12) {
        if (Math.abs(i12) <= this.mFlingDistance || Math.abs(i11) <= this.mMinimumVelocity) {
            i10 += (int) (f10 + (i10 >= this.mCurItem ? 0.4f : 0.6f));
        } else if (i11 <= 0) {
            i10++;
        }
        if (this.mItems.size() <= 0) {
            return i10;
        }
        ArrayList<f> arrayList = this.mItems;
        return Math.max(this.mItems.get(0).f4333b, Math.min(i10, arrayList.get(arrayList.size() - 1).f4333b));
    }

    private void dispatchOnPageScrolled(int i10, float f10, int i11) {
        i iVar = this.mOnPageChangeListener;
        if (iVar != null) {
            iVar.a(i10, f10, i11);
        }
        List<i> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i12 = 0; i12 < size; i12++) {
                i iVar2 = this.mOnPageChangeListeners.get(i12);
                if (iVar2 != null) {
                    iVar2.a(i10, f10, i11);
                }
            }
        }
        i iVar3 = this.mInternalPageChangeListener;
        if (iVar3 != null) {
            iVar3.a(i10, f10, i11);
        }
    }

    private void dispatchOnPageSelected(int i10) {
        i iVar = this.mOnPageChangeListener;
        if (iVar != null) {
            iVar.c(i10);
        }
        List<i> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                i iVar2 = this.mOnPageChangeListeners.get(i11);
                if (iVar2 != null) {
                    iVar2.c(i10);
                }
            }
        }
        i iVar3 = this.mInternalPageChangeListener;
        if (iVar3 != null) {
            iVar3.c(i10);
        }
    }

    private void dispatchOnScrollStateChanged(int i10) {
        i iVar = this.mOnPageChangeListener;
        if (iVar != null) {
            iVar.b(i10);
        }
        List<i> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                i iVar2 = this.mOnPageChangeListeners.get(i11);
                if (iVar2 != null) {
                    iVar2.b(i10);
                }
            }
        }
        i iVar3 = this.mInternalPageChangeListener;
        if (iVar3 != null) {
            iVar3.b(i10);
        }
    }

    private void enableLayers(boolean z10) {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            getChildAt(i10).setLayerType(z10 ? this.mPageTransformerLayerType : 0, (Paint) null);
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private Rect getChildRectInPagerCoordinates(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private f infoForCurrentScrollPosition() {
        int i10;
        int clientWidth = getClientWidth();
        float f10 = 0.0f;
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        float f11 = clientWidth > 0 ? ((float) this.mPageMargin) / ((float) clientWidth) : 0.0f;
        f fVar = null;
        int i11 = 0;
        int i12 = -1;
        boolean z10 = true;
        float f12 = 0.0f;
        while (i11 < this.mItems.size()) {
            f fVar2 = this.mItems.get(i11);
            if (!z10 && fVar2.f4333b != (i10 = i12 + 1)) {
                fVar2 = this.mTempItem;
                fVar2.f4336e = f10 + f12 + f11;
                fVar2.f4333b = i10;
                fVar2.f4335d = this.mAdapter.getPageWidth(i10);
                i11--;
            }
            f10 = fVar2.f4336e;
            float f13 = fVar2.f4335d + f10 + f11;
            if (!z10 && scrollX < f10) {
                return fVar;
            }
            if (scrollX < f13 || i11 == this.mItems.size() - 1) {
                return fVar2;
            }
            i12 = fVar2.f4333b;
            f12 = fVar2.f4335d;
            i11++;
            z10 = false;
            fVar = fVar2;
        }
        return fVar;
    }

    private static boolean isDecorView(View view) {
        return view.getClass().getAnnotation(e.class) != null;
    }

    private boolean isGutterDrag(float f10, float f11) {
        return (f10 < ((float) this.mGutterSize) && f11 > 0.0f) || (f10 > ((float) (getWidth() - this.mGutterSize)) && f11 < 0.0f);
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            int i10 = actionIndex == 0 ? 1 : 0;
            this.mLastMotionX = motionEvent.getX(i10);
            this.mActivePointerId = motionEvent.getPointerId(i10);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private boolean pageScrolled(int i10) {
        if (this.mItems.size() != 0) {
            f infoForCurrentScrollPosition = infoForCurrentScrollPosition();
            int clientWidth = getClientWidth();
            int i11 = this.mPageMargin;
            int i12 = clientWidth + i11;
            float f10 = (float) clientWidth;
            int i13 = infoForCurrentScrollPosition.f4333b;
            float f11 = ((((float) i10) / f10) - infoForCurrentScrollPosition.f4336e) / (infoForCurrentScrollPosition.f4335d + (((float) i11) / f10));
            this.mCalledSuper = false;
            onPageScrolled(i13, f11, (int) (((float) i12) * f11));
            if (this.mCalledSuper) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else if (this.mFirstLayout) {
            return false;
        } else {
            this.mCalledSuper = false;
            onPageScrolled(0, 0.0f, 0);
            if (this.mCalledSuper) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    private boolean performDrag(float f10) {
        boolean z10;
        boolean z11;
        float f11 = this.mLastMotionX - f10;
        this.mLastMotionX = f10;
        float scrollX = ((float) getScrollX()) + f11;
        float clientWidth = (float) getClientWidth();
        float f12 = this.mFirstOffset * clientWidth;
        float f13 = this.mLastOffset * clientWidth;
        boolean z12 = false;
        f fVar = this.mItems.get(0);
        ArrayList<f> arrayList = this.mItems;
        f fVar2 = arrayList.get(arrayList.size() - 1);
        if (fVar.f4333b != 0) {
            f12 = fVar.f4336e * clientWidth;
            z10 = false;
        } else {
            z10 = true;
        }
        if (fVar2.f4333b != this.mAdapter.getCount() - 1) {
            f13 = fVar2.f4336e * clientWidth;
            z11 = false;
        } else {
            z11 = true;
        }
        if (scrollX < f12) {
            if (z10) {
                this.mLeftEdge.onPull(Math.abs(f12 - scrollX) / clientWidth);
                z12 = true;
            }
            scrollX = f12;
        } else if (scrollX > f13) {
            if (z11) {
                this.mRightEdge.onPull(Math.abs(scrollX - f13) / clientWidth);
                z12 = true;
            }
            scrollX = f13;
        }
        int i10 = (int) scrollX;
        this.mLastMotionX += scrollX - ((float) i10);
        scrollTo(i10, getScrollY());
        pageScrolled(i10);
        return z12;
    }

    private void recomputeScrollPosition(int i10, int i11, int i12, int i13) {
        int min;
        if (i11 <= 0 || this.mItems.isEmpty()) {
            f infoForPosition = infoForPosition(this.mCurItem);
            min = (int) ((infoForPosition != null ? Math.min(infoForPosition.f4336e, this.mLastOffset) : 0.0f) * ((float) ((i10 - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                completeScroll(false);
            } else {
                return;
            }
        } else if (!this.mScroller.isFinished()) {
            this.mScroller.setFinalX(getCurrentItem() * getClientWidth());
            return;
        } else {
            min = (int) ((((float) getScrollX()) / ((float) (((i11 - getPaddingLeft()) - getPaddingRight()) + i13))) * ((float) (((i10 - getPaddingLeft()) - getPaddingRight()) + i12)));
        }
        scrollTo(min, getScrollY());
    }

    private void removeNonDecorViews() {
        int i10 = 0;
        while (i10 < getChildCount()) {
            if (!((LayoutParams) getChildAt(i10).getLayoutParams()).f4320a) {
                removeViewAt(i10);
                i10--;
            }
            i10++;
        }
    }

    private void requestParentDisallowInterceptTouchEvent(boolean z10) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z10);
        }
    }

    private boolean resetTouch() {
        this.mActivePointerId = -1;
        endDrag();
        this.mLeftEdge.onRelease();
        this.mRightEdge.onRelease();
        return this.mLeftEdge.isFinished() || this.mRightEdge.isFinished();
    }

    private void scrollToItem(int i10, boolean z10, int i11, boolean z11) {
        f infoForPosition = infoForPosition(i10);
        int clientWidth = infoForPosition != null ? (int) (((float) getClientWidth()) * Math.max(this.mFirstOffset, Math.min(infoForPosition.f4336e, this.mLastOffset))) : 0;
        if (z10) {
            smoothScrollTo(clientWidth, 0, i11);
            if (z11) {
                dispatchOnPageSelected(i10);
                return;
            }
            return;
        }
        if (z11) {
            dispatchOnPageSelected(i10);
        }
        completeScroll(false);
        scrollTo(clientWidth, 0);
        pageScrolled(clientWidth);
    }

    private void setScrollingCacheEnabled(boolean z10) {
        if (this.mScrollingCacheEnabled != z10) {
            this.mScrollingCacheEnabled = z10;
        }
    }

    private void sortChildDrawingOrder() {
        if (this.mDrawingOrder != 0) {
            ArrayList<View> arrayList = this.mDrawingOrderedChildren;
            if (arrayList == null) {
                this.mDrawingOrderedChildren = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                this.mDrawingOrderedChildren.add(getChildAt(i10));
            }
            Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
        }
    }

    public void addFocusables(ArrayList<View> arrayList, int i10, int i11) {
        f infoForChild;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i12 = 0; i12 < getChildCount(); i12++) {
                View childAt = getChildAt(i12);
                if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.f4333b == this.mCurItem) {
                    childAt.addFocusables(arrayList, i10, i11);
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if ((i11 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) {
            arrayList.add(this);
        }
    }

    /* access modifiers changed from: package-private */
    public f addNewItem(int i10, int i11) {
        f fVar = new f();
        fVar.f4333b = i10;
        fVar.f4332a = this.mAdapter.instantiateItem((ViewGroup) this, i10);
        fVar.f4335d = this.mAdapter.getPageWidth(i10);
        if (i11 < 0 || i11 >= this.mItems.size()) {
            this.mItems.add(fVar);
        } else {
            this.mItems.add(i11, fVar);
        }
        return fVar;
    }

    public void addOnAdapterChangeListener(h hVar) {
        if (this.mAdapterChangeListeners == null) {
            this.mAdapterChangeListeners = new ArrayList();
        }
        this.mAdapterChangeListeners.add(hVar);
    }

    public void addOnPageChangeListener(i iVar) {
        if (this.mOnPageChangeListeners == null) {
            this.mOnPageChangeListeners = new ArrayList();
        }
        this.mOnPageChangeListeners.add(iVar);
    }

    public void addTouchables(ArrayList<View> arrayList) {
        f infoForChild;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.f4333b == this.mCurItem) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        boolean isDecorView = layoutParams2.f4320a | isDecorView(view);
        layoutParams2.f4320a = isDecorView;
        if (!this.mInLayout) {
            super.addView(view, i10, layoutParams);
        } else if (!isDecorView) {
            layoutParams2.f4323d = true;
            addViewInLayout(view, i10, layoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ca  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean arrowScroll(int r7) {
        /*
            r6 = this;
            android.view.View r0 = r6.findFocus()
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 != r6) goto L_0x000b
        L_0x0009:
            r0 = r3
            goto L_0x0069
        L_0x000b:
            if (r0 == 0) goto L_0x0069
            android.view.ViewParent r4 = r0.getParent()
        L_0x0011:
            boolean r5 = r4 instanceof android.view.ViewGroup
            if (r5 == 0) goto L_0x001e
            if (r4 != r6) goto L_0x0019
            r4 = r1
            goto L_0x001f
        L_0x0019:
            android.view.ViewParent r4 = r4.getParent()
            goto L_0x0011
        L_0x001e:
            r4 = r2
        L_0x001f:
            if (r4 != 0) goto L_0x0069
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r4.append(r5)
            android.view.ViewParent r0 = r0.getParent()
        L_0x0035:
            boolean r5 = r0 instanceof android.view.ViewGroup
            if (r5 == 0) goto L_0x004e
            java.lang.String r5 = " => "
            r4.append(r5)
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r4.append(r5)
            android.view.ViewParent r0 = r0.getParent()
            goto L_0x0035
        L_0x004e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "arrowScroll tried to find focus based on non-child current focused view "
            r0.append(r5)
            java.lang.String r4 = r4.toString()
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.String r4 = "ViewPager"
            android.util.Log.e(r4, r0)
            goto L_0x0009
        L_0x0069:
            android.view.FocusFinder r3 = android.view.FocusFinder.getInstance()
            android.view.View r3 = r3.findNextFocus(r6, r0, r7)
            r4 = 66
            r5 = 17
            if (r3 == 0) goto L_0x00b5
            if (r3 == r0) goto L_0x00b5
            if (r7 != r5) goto L_0x009a
            android.graphics.Rect r1 = r6.mTempRect
            android.graphics.Rect r1 = r6.getChildRectInPagerCoordinates(r1, r3)
            int r1 = r1.left
            android.graphics.Rect r2 = r6.mTempRect
            android.graphics.Rect r2 = r6.getChildRectInPagerCoordinates(r2, r0)
            int r2 = r2.left
            if (r0 == 0) goto L_0x0094
            if (r1 < r2) goto L_0x0094
            boolean r0 = r6.pageLeft()
            goto L_0x0098
        L_0x0094:
            boolean r0 = r3.requestFocus()
        L_0x0098:
            r2 = r0
            goto L_0x00c8
        L_0x009a:
            if (r7 != r4) goto L_0x00c8
            android.graphics.Rect r1 = r6.mTempRect
            android.graphics.Rect r1 = r6.getChildRectInPagerCoordinates(r1, r3)
            int r1 = r1.left
            android.graphics.Rect r2 = r6.mTempRect
            android.graphics.Rect r2 = r6.getChildRectInPagerCoordinates(r2, r0)
            int r2 = r2.left
            if (r0 == 0) goto L_0x0094
            if (r1 > r2) goto L_0x0094
            boolean r0 = r6.pageRight()
            goto L_0x0098
        L_0x00b5:
            if (r7 == r5) goto L_0x00c4
            if (r7 != r1) goto L_0x00ba
            goto L_0x00c4
        L_0x00ba:
            if (r7 == r4) goto L_0x00bf
            r0 = 2
            if (r7 != r0) goto L_0x00c8
        L_0x00bf:
            boolean r2 = r6.pageRight()
            goto L_0x00c8
        L_0x00c4:
            boolean r2 = r6.pageLeft()
        L_0x00c8:
            if (r2 == 0) goto L_0x00d1
            int r7 = android.view.SoundEffectConstants.getContantForFocusDirection(r7)
            r6.playSoundEffect(r7)
        L_0x00d1:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.arrowScroll(int):boolean");
    }

    public boolean beginFakeDrag() {
        if (this.mIsBeingDragged) {
            return false;
        }
        this.mFakeDragging = true;
        setScrollState(1);
        this.mLastMotionX = 0.0f;
        this.mInitialMotionX = 0.0f;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
        this.mFakeDragBeginTime = uptimeMillis;
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean canScroll(View view, boolean z10, int i10, int i11, int i12) {
        int i13;
        View view2 = view;
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i14 = i11 + scrollX;
                if (i14 >= childAt.getLeft() && i14 < childAt.getRight() && (i13 = i12 + scrollY) >= childAt.getTop() && i13 < childAt.getBottom()) {
                    if (canScroll(childAt, true, i10, i14 - childAt.getLeft(), i13 - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        return z10 && view.canScrollHorizontally(-i10);
    }

    public boolean canScrollHorizontally(int i10) {
        if (this.mAdapter == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i10 < 0 ? scrollX > ((int) (((float) clientWidth) * this.mFirstOffset)) : i10 > 0 && scrollX < ((int) (((float) clientWidth) * this.mLastOffset));
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void clearOnPageChangeListeners() {
        List<i> list = this.mOnPageChangeListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void computeScroll() {
        this.mIsScrollStarted = true;
        if (this.mScroller.isFinished() || !this.mScroller.computeScrollOffset()) {
            completeScroll(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.mScroller.getCurrX();
        int currY = this.mScroller.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!pageScrolled(currX)) {
                this.mScroller.abortAnimation();
                scrollTo(0, currY);
            }
        }
        x.h0(this);
    }

    /* access modifiers changed from: package-private */
    public void dataSetChanged() {
        int count = this.mAdapter.getCount();
        this.mExpectedAdapterCount = count;
        boolean z10 = this.mItems.size() < (this.mOffscreenPageLimit * 2) + 1 && this.mItems.size() < count;
        int i10 = this.mCurItem;
        int i11 = 0;
        boolean z11 = false;
        while (i11 < this.mItems.size()) {
            f fVar = this.mItems.get(i11);
            int itemPosition = this.mAdapter.getItemPosition(fVar.f4332a);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.mItems.remove(i11);
                    i11--;
                    if (!z11) {
                        this.mAdapter.startUpdate((ViewGroup) this);
                        z11 = true;
                    }
                    this.mAdapter.destroyItem((ViewGroup) this, fVar.f4333b, fVar.f4332a);
                    int i12 = this.mCurItem;
                    if (i12 == fVar.f4333b) {
                        i10 = Math.max(0, Math.min(i12, count - 1));
                    }
                } else {
                    int i13 = fVar.f4333b;
                    if (i13 != itemPosition) {
                        if (i13 == this.mCurItem) {
                            i10 = itemPosition;
                        }
                        fVar.f4333b = itemPosition;
                    }
                }
                z10 = true;
            }
            i11++;
        }
        if (z11) {
            this.mAdapter.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (z10) {
            int childCount = getChildCount();
            for (int i14 = 0; i14 < childCount; i14++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i14).getLayoutParams();
                if (!layoutParams.f4320a) {
                    layoutParams.f4322c = 0.0f;
                }
            }
            setCurrentItemInternal(i10, false, true);
            requestLayout();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        f infoForChild;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.f4333b == this.mCurItem && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public float distanceInfluenceForSnapDuration(float f10) {
        return (float) Math.sin((double) ((f10 - 0.5f) * 0.47123894f));
    }

    public void draw(Canvas canvas) {
        a aVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z10 = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (aVar = this.mAdapter) != null && aVar.getCount() > 1)) {
            if (!this.mLeftEdge.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-height) + getPaddingTop()), this.mFirstOffset * ((float) width));
                this.mLeftEdge.setSize(height, width);
                z10 = false | this.mLeftEdge.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.mRightEdge.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.mLastOffset + 1.0f)) * ((float) width2));
                this.mRightEdge.setSize(height2, width2);
                z10 |= this.mRightEdge.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.mLeftEdge.finish();
            this.mRightEdge.finish();
        }
        if (z10) {
            x.h0(this);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mMarginDrawable;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    public void endFakeDrag() {
        if (this.mFakeDragging) {
            if (this.mAdapter != null) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(com.android.volley.toolbox.k.DEFAULT_IMAGE_TIMEOUT_MS, (float) this.mMaximumVelocity);
                int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
                this.mPopulatePending = true;
                int clientWidth = getClientWidth();
                int scrollX = getScrollX();
                f infoForCurrentScrollPosition = infoForCurrentScrollPosition();
                setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.f4333b, ((((float) scrollX) / ((float) clientWidth)) - infoForCurrentScrollPosition.f4336e) / infoForCurrentScrollPosition.f4335d, xVelocity, (int) (this.mLastMotionX - this.mInitialMotionX)), true, true, xVelocity);
            }
            endDrag();
            this.mFakeDragging = false;
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        int i10;
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 21) {
                if (keyCode != 22) {
                    if (keyCode == 61) {
                        if (keyEvent.hasNoModifiers()) {
                            return arrowScroll(2);
                        }
                        if (keyEvent.hasModifiers(1)) {
                            return arrowScroll(1);
                        }
                    }
                } else if (keyEvent.hasModifiers(2)) {
                    return pageRight();
                } else {
                    i10 = 66;
                }
            } else if (keyEvent.hasModifiers(2)) {
                return pageLeft();
            } else {
                i10 = 17;
            }
            return arrowScroll(i10);
        }
        return false;
    }

    public void fakeDragBy(float f10) {
        if (!this.mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        } else if (this.mAdapter != null) {
            this.mLastMotionX += f10;
            float scrollX = ((float) getScrollX()) - f10;
            float clientWidth = (float) getClientWidth();
            float f11 = this.mFirstOffset * clientWidth;
            float f12 = this.mLastOffset * clientWidth;
            f fVar = this.mItems.get(0);
            ArrayList<f> arrayList = this.mItems;
            f fVar2 = arrayList.get(arrayList.size() - 1);
            if (fVar.f4333b != 0) {
                f11 = fVar.f4336e * clientWidth;
            }
            if (fVar2.f4333b != this.mAdapter.getCount() - 1) {
                f12 = fVar2.f4336e * clientWidth;
            }
            if (scrollX < f11) {
                scrollX = f11;
            } else if (scrollX > f12) {
                scrollX = f12;
            }
            int i10 = (int) scrollX;
            this.mLastMotionX += scrollX - ((float) i10);
            scrollTo(i10, getScrollY());
            pageScrolled(i10);
            MotionEvent obtain = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), 2, this.mLastMotionX, 0.0f, 0);
            this.mVelocityTracker.addMovement(obtain);
            obtain.recycle();
        }
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
        return generateDefaultLayoutParams();
    }

    public a getAdapter() {
        return this.mAdapter;
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i10, int i11) {
        if (this.mDrawingOrder == 2) {
            i11 = (i10 - 1) - i11;
        }
        return ((LayoutParams) this.mDrawingOrderedChildren.get(i11).getLayoutParams()).f4325f;
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    /* access modifiers changed from: package-private */
    public f infoForAnyChild(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent == this) {
                return infoForChild(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    /* access modifiers changed from: package-private */
    public f infoForChild(View view) {
        for (int i10 = 0; i10 < this.mItems.size(); i10++) {
            f fVar = this.mItems.get(i10);
            if (this.mAdapter.isViewFromObject(view, fVar.f4332a)) {
                return fVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public f infoForPosition(int i10) {
        for (int i11 = 0; i11 < this.mItems.size(); i11++) {
            f fVar = this.mItems.get(i11);
            if (fVar.f4333b == i10) {
                return fVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void initViewPager() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
        this.mMinimumVelocity = (int) (400.0f * f10);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new EdgeEffect(context);
        this.mRightEdge = new EdgeEffect(context);
        this.mFlingDistance = (int) (25.0f * f10);
        this.mCloseEnough = (int) (2.0f * f10);
        this.mDefaultGutterSize = (int) (f10 * 16.0f);
        x.r0(this, new g());
        if (x.A(this) == 0) {
            x.B0(this, 1);
        }
        x.F0(this, new d());
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.mEndScrollRunnable);
        Scroller scroller = this.mScroller;
        if (scroller != null && !scroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0064  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r18) {
        /*
            r17 = this;
            r0 = r17
            super.onDraw(r18)
            int r1 = r0.mPageMargin
            if (r1 <= 0) goto L_0x00a8
            android.graphics.drawable.Drawable r1 = r0.mMarginDrawable
            if (r1 == 0) goto L_0x00a8
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$f> r1 = r0.mItems
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x00a8
            androidx.viewpager.widget.a r1 = r0.mAdapter
            if (r1 == 0) goto L_0x00a8
            int r1 = r17.getScrollX()
            int r2 = r17.getWidth()
            int r3 = r0.mPageMargin
            float r3 = (float) r3
            float r4 = (float) r2
            float r3 = r3 / r4
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$f> r5 = r0.mItems
            r6 = 0
            java.lang.Object r5 = r5.get(r6)
            androidx.viewpager.widget.ViewPager$f r5 = (androidx.viewpager.widget.ViewPager.f) r5
            float r7 = r5.f4336e
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$f> r8 = r0.mItems
            int r8 = r8.size()
            int r9 = r5.f4333b
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$f> r10 = r0.mItems
            int r11 = r8 + -1
            java.lang.Object r10 = r10.get(r11)
            androidx.viewpager.widget.ViewPager$f r10 = (androidx.viewpager.widget.ViewPager.f) r10
            int r10 = r10.f4333b
        L_0x0045:
            if (r9 >= r10) goto L_0x00a8
        L_0x0047:
            int r11 = r5.f4333b
            if (r9 <= r11) goto L_0x0058
            if (r6 >= r8) goto L_0x0058
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$f> r5 = r0.mItems
            int r6 = r6 + 1
            java.lang.Object r5 = r5.get(r6)
            androidx.viewpager.widget.ViewPager$f r5 = (androidx.viewpager.widget.ViewPager.f) r5
            goto L_0x0047
        L_0x0058:
            if (r9 != r11) goto L_0x0064
            float r7 = r5.f4336e
            float r11 = r5.f4335d
            float r12 = r7 + r11
            float r12 = r12 * r4
            float r7 = r7 + r11
            float r7 = r7 + r3
            goto L_0x006f
        L_0x0064:
            androidx.viewpager.widget.a r11 = r0.mAdapter
            float r11 = r11.getPageWidth(r9)
            float r12 = r7 + r11
            float r12 = r12 * r4
            float r11 = r11 + r3
            float r7 = r7 + r11
        L_0x006f:
            int r11 = r0.mPageMargin
            float r11 = (float) r11
            float r11 = r11 + r12
            float r13 = (float) r1
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 <= 0) goto L_0x0097
            android.graphics.drawable.Drawable r11 = r0.mMarginDrawable
            int r13 = java.lang.Math.round(r12)
            int r14 = r0.mTopPageBounds
            int r15 = r0.mPageMargin
            float r15 = (float) r15
            float r15 = r15 + r12
            int r15 = java.lang.Math.round(r15)
            r16 = r3
            int r3 = r0.mBottomPageBounds
            r11.setBounds(r13, r14, r15, r3)
            android.graphics.drawable.Drawable r3 = r0.mMarginDrawable
            r11 = r18
            r3.draw(r11)
            goto L_0x009b
        L_0x0097:
            r11 = r18
            r16 = r3
        L_0x009b:
            int r3 = r1 + r2
            float r3 = (float) r3
            int r3 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x00a3
            goto L_0x00a8
        L_0x00a3:
            int r9 = r9 + 1
            r3 = r16
            goto L_0x0045
        L_0x00a8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onDraw(android.graphics.Canvas):void");
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            resetTouch();
            return false;
        }
        if (action != 0) {
            if (this.mIsBeingDragged) {
                return true;
            }
            if (this.mIsUnableToDrag) {
                return false;
            }
        }
        if (action == 0) {
            float x10 = motionEvent.getX();
            this.mInitialMotionX = x10;
            this.mLastMotionX = x10;
            float y10 = motionEvent.getY();
            this.mInitialMotionY = y10;
            this.mLastMotionY = y10;
            this.mActivePointerId = motionEvent2.getPointerId(0);
            this.mIsUnableToDrag = false;
            this.mIsScrollStarted = true;
            this.mScroller.computeScrollOffset();
            if (this.mScrollState != 2 || Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) <= this.mCloseEnough) {
                completeScroll(false);
                this.mIsBeingDragged = false;
            } else {
                this.mScroller.abortAnimation();
                this.mPopulatePending = false;
                populate();
                this.mIsBeingDragged = true;
                requestParentDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i10 = this.mActivePointerId;
            if (i10 != -1) {
                int findPointerIndex = motionEvent2.findPointerIndex(i10);
                float x11 = motionEvent2.getX(findPointerIndex);
                float f10 = x11 - this.mLastMotionX;
                float abs = Math.abs(f10);
                float y11 = motionEvent2.getY(findPointerIndex);
                float abs2 = Math.abs(y11 - this.mInitialMotionY);
                int i11 = (f10 > 0.0f ? 1 : (f10 == 0.0f ? 0 : -1));
                if (i11 != 0 && !isGutterDrag(this.mLastMotionX, f10)) {
                    if (canScroll(this, false, (int) f10, (int) x11, (int) y11)) {
                        this.mLastMotionX = x11;
                        this.mLastMotionY = y11;
                        this.mIsUnableToDrag = true;
                        return false;
                    }
                }
                int i12 = this.mTouchSlop;
                if (abs > ((float) i12) && abs * 0.5f > abs2) {
                    this.mIsBeingDragged = true;
                    requestParentDisallowInterceptTouchEvent(true);
                    setScrollState(1);
                    float f11 = this.mInitialMotionX;
                    float f12 = (float) this.mTouchSlop;
                    this.mLastMotionX = i11 > 0 ? f11 + f12 : f11 - f12;
                    this.mLastMotionY = y11;
                    setScrollingCacheEnabled(true);
                } else if (abs2 > ((float) i12)) {
                    this.mIsUnableToDrag = true;
                }
                if (this.mIsBeingDragged && performDrag(x11)) {
                    x.h0(this);
                }
            }
        } else if (action == 6) {
            onSecondaryPointerUp(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent2);
        return this.mIsBeingDragged;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            r18 = this;
            r0 = r18
            int r1 = r18.getChildCount()
            int r2 = r22 - r20
            int r3 = r23 - r21
            int r4 = r18.getPaddingLeft()
            int r5 = r18.getPaddingTop()
            int r6 = r18.getPaddingRight()
            int r7 = r18.getPaddingBottom()
            int r8 = r18.getScrollX()
            r10 = 0
            r11 = 0
        L_0x0020:
            r12 = 8
            if (r10 >= r1) goto L_0x00b6
            android.view.View r13 = r0.getChildAt(r10)
            int r14 = r13.getVisibility()
            if (r14 == r12) goto L_0x00b2
            android.view.ViewGroup$LayoutParams r12 = r13.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r12 = (androidx.viewpager.widget.ViewPager.LayoutParams) r12
            boolean r14 = r12.f4320a
            if (r14 == 0) goto L_0x00b2
            int r12 = r12.f4321b
            r14 = r12 & 7
            r12 = r12 & 112(0x70, float:1.57E-43)
            r15 = 1
            if (r14 == r15) goto L_0x005c
            r15 = 3
            if (r14 == r15) goto L_0x0056
            r15 = 5
            if (r14 == r15) goto L_0x0049
            r14 = r4
            goto L_0x006d
        L_0x0049:
            int r14 = r2 - r6
            int r15 = r13.getMeasuredWidth()
            int r14 = r14 - r15
            int r15 = r13.getMeasuredWidth()
            int r6 = r6 + r15
            goto L_0x0068
        L_0x0056:
            int r14 = r13.getMeasuredWidth()
            int r14 = r14 + r4
            goto L_0x006d
        L_0x005c:
            int r14 = r13.getMeasuredWidth()
            int r14 = r2 - r14
            int r14 = r14 / 2
            int r14 = java.lang.Math.max(r14, r4)
        L_0x0068:
            r17 = r14
            r14 = r4
            r4 = r17
        L_0x006d:
            r15 = 16
            if (r12 == r15) goto L_0x008e
            r15 = 48
            if (r12 == r15) goto L_0x0088
            r15 = 80
            if (r12 == r15) goto L_0x007b
            r12 = r5
            goto L_0x009f
        L_0x007b:
            int r12 = r3 - r7
            int r15 = r13.getMeasuredHeight()
            int r12 = r12 - r15
            int r15 = r13.getMeasuredHeight()
            int r7 = r7 + r15
            goto L_0x009a
        L_0x0088:
            int r12 = r13.getMeasuredHeight()
            int r12 = r12 + r5
            goto L_0x009f
        L_0x008e:
            int r12 = r13.getMeasuredHeight()
            int r12 = r3 - r12
            int r12 = r12 / 2
            int r12 = java.lang.Math.max(r12, r5)
        L_0x009a:
            r17 = r12
            r12 = r5
            r5 = r17
        L_0x009f:
            int r4 = r4 + r8
            int r15 = r13.getMeasuredWidth()
            int r15 = r15 + r4
            int r16 = r13.getMeasuredHeight()
            int r9 = r5 + r16
            r13.layout(r4, r5, r15, r9)
            int r11 = r11 + 1
            r5 = r12
            r4 = r14
        L_0x00b2:
            int r10 = r10 + 1
            goto L_0x0020
        L_0x00b6:
            int r2 = r2 - r4
            int r2 = r2 - r6
            r6 = 0
        L_0x00b9:
            if (r6 >= r1) goto L_0x0106
            android.view.View r8 = r0.getChildAt(r6)
            int r9 = r8.getVisibility()
            if (r9 == r12) goto L_0x0103
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r9 = (androidx.viewpager.widget.ViewPager.LayoutParams) r9
            boolean r10 = r9.f4320a
            if (r10 != 0) goto L_0x0103
            androidx.viewpager.widget.ViewPager$f r10 = r0.infoForChild(r8)
            if (r10 == 0) goto L_0x0103
            float r13 = (float) r2
            float r10 = r10.f4336e
            float r10 = r10 * r13
            int r10 = (int) r10
            int r10 = r10 + r4
            boolean r14 = r9.f4323d
            if (r14 == 0) goto L_0x00f6
            r14 = 0
            r9.f4323d = r14
            float r9 = r9.f4322c
            float r13 = r13 * r9
            int r9 = (int) r13
            r13 = 1073741824(0x40000000, float:2.0)
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r13)
            int r14 = r3 - r5
            int r14 = r14 - r7
            int r13 = android.view.View.MeasureSpec.makeMeasureSpec(r14, r13)
            r8.measure(r9, r13)
        L_0x00f6:
            int r9 = r8.getMeasuredWidth()
            int r9 = r9 + r10
            int r13 = r8.getMeasuredHeight()
            int r13 = r13 + r5
            r8.layout(r10, r5, r9, r13)
        L_0x0103:
            int r6 = r6 + 1
            goto L_0x00b9
        L_0x0106:
            r0.mTopPageBounds = r5
            int r3 = r3 - r7
            r0.mBottomPageBounds = r3
            r0.mDecorChildCount = r11
            boolean r1 = r0.mFirstLayout
            if (r1 == 0) goto L_0x0118
            int r1 = r0.mCurItem
            r2 = 0
            r0.scrollToItem(r1, r2, r2, r2)
            goto L_0x0119
        L_0x0118:
            r2 = 0
        L_0x0119:
            r0.mFirstLayout = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onLayout(boolean, int, int, int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        LayoutParams layoutParams;
        LayoutParams layoutParams2;
        int i12;
        setMeasuredDimension(ViewGroup.getDefaultSize(0, i10), ViewGroup.getDefaultSize(0, i11));
        int measuredWidth = getMeasuredWidth();
        this.mGutterSize = Math.min(measuredWidth / 10, this.mDefaultGutterSize);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i13 = 0;
        while (true) {
            boolean z10 = true;
            int i14 = 1073741824;
            if (i13 >= childCount) {
                break;
            }
            View childAt = getChildAt(i13);
            if (!(childAt.getVisibility() == 8 || (layoutParams2 = (LayoutParams) childAt.getLayoutParams()) == null || !layoutParams2.f4320a)) {
                int i15 = layoutParams2.f4321b;
                int i16 = i15 & 7;
                int i17 = i15 & 112;
                boolean z11 = i17 == 48 || i17 == 80;
                if (!(i16 == 3 || i16 == 5)) {
                    z10 = false;
                }
                int i18 = Integer.MIN_VALUE;
                if (z11) {
                    i12 = Integer.MIN_VALUE;
                    i18 = 1073741824;
                } else {
                    i12 = z10 ? 1073741824 : Integer.MIN_VALUE;
                }
                int i19 = layoutParams2.width;
                if (i19 != -2) {
                    if (i19 == -1) {
                        i19 = paddingLeft;
                    }
                    i18 = 1073741824;
                } else {
                    i19 = paddingLeft;
                }
                int i20 = layoutParams2.height;
                if (i20 == -2) {
                    i20 = measuredHeight;
                    i14 = i12;
                } else if (i20 == -1) {
                    i20 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i19, i18), View.MeasureSpec.makeMeasureSpec(i20, i14));
                if (z11) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z10) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i13++;
        }
        this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.mInLayout = true;
        populate();
        this.mInLayout = false;
        int childCount2 = getChildCount();
        for (int i21 = 0; i21 < childCount2; i21++) {
            View childAt2 = getChildAt(i21);
            if (childAt2.getVisibility() != 8 && ((layoutParams = (LayoutParams) childAt2.getLayoutParams()) == null || !layoutParams.f4320a)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (((float) paddingLeft) * layoutParams.f4322c), 1073741824), this.mChildHeightMeasureSpec);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0064  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPageScrolled(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.mDecorChildCount
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L_0x006b
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = r1
        L_0x001b:
            if (r7 >= r6) goto L_0x006b
            android.view.View r8 = r12.getChildAt(r7)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r9 = (androidx.viewpager.widget.ViewPager.LayoutParams) r9
            boolean r10 = r9.f4320a
            if (r10 != 0) goto L_0x002c
            goto L_0x0068
        L_0x002c:
            int r9 = r9.f4321b
            r9 = r9 & 7
            if (r9 == r2) goto L_0x004d
            r10 = 3
            if (r9 == r10) goto L_0x0047
            r10 = 5
            if (r9 == r10) goto L_0x003a
            r9 = r3
            goto L_0x005c
        L_0x003a:
            int r9 = r5 - r4
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r4 = r4 + r10
            goto L_0x0059
        L_0x0047:
            int r9 = r8.getWidth()
            int r9 = r9 + r3
            goto L_0x005c
        L_0x004d:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r3)
        L_0x0059:
            r11 = r9
            r9 = r3
            r3 = r11
        L_0x005c:
            int r3 = r3 + r0
            int r10 = r8.getLeft()
            int r3 = r3 - r10
            if (r3 == 0) goto L_0x0067
            r8.offsetLeftAndRight(r3)
        L_0x0067:
            r3 = r9
        L_0x0068:
            int r7 = r7 + 1
            goto L_0x001b
        L_0x006b:
            r12.dispatchOnPageScrolled(r13, r14, r15)
            androidx.viewpager.widget.ViewPager$j r13 = r12.mPageTransformer
            if (r13 == 0) goto L_0x009f
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        L_0x007a:
            if (r1 >= r14) goto L_0x009f
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r0 = (androidx.viewpager.widget.ViewPager.LayoutParams) r0
            boolean r0 = r0.f4320a
            if (r0 == 0) goto L_0x008b
            goto L_0x009c
        L_0x008b:
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.getClientWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            androidx.viewpager.widget.ViewPager$j r3 = r12.mPageTransformer
            r3.a(r15, r0)
        L_0x009c:
            int r1 = r1 + 1
            goto L_0x007a
        L_0x009f:
            r12.mCalledSuper = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onPageScrolled(int, float, int):void");
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i10, Rect rect) {
        int i11;
        int i12;
        f infoForChild;
        int childCount = getChildCount();
        int i13 = -1;
        if ((i10 & 2) != 0) {
            i13 = childCount;
            i12 = 0;
            i11 = 1;
        } else {
            i12 = childCount - 1;
            i11 = -1;
        }
        while (i12 != i13) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.f4333b == this.mCurItem && childAt.requestFocus(i10, rect)) {
                return true;
            }
            i12 += i11;
        }
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        a aVar = this.mAdapter;
        if (aVar != null) {
            aVar.restoreState(savedState.f4327d, savedState.f4328e);
            setCurrentItemInternal(savedState.f4326c, false, true);
            return;
        }
        this.mRestoredCurItem = savedState.f4326c;
        this.mRestoredAdapterState = savedState.f4327d;
        this.mRestoredClassLoader = savedState.f4328e;
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f4326c = this.mCurItem;
        a aVar = this.mAdapter;
        if (aVar != null) {
            savedState.f4327d = aVar.saveState();
        }
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (i10 != i12) {
            int i14 = this.mPageMargin;
            recomputeScrollPosition(i10, i12, i14, i14);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x0151  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            boolean r0 = r7.mFakeDragging
            r1 = 1
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = r8.getAction()
            r2 = 0
            if (r0 != 0) goto L_0x0014
            int r0 = r8.getEdgeFlags()
            if (r0 == 0) goto L_0x0014
            return r2
        L_0x0014:
            androidx.viewpager.widget.a r0 = r7.mAdapter
            if (r0 == 0) goto L_0x0155
            int r0 = r0.getCount()
            if (r0 != 0) goto L_0x0020
            goto L_0x0155
        L_0x0020:
            android.view.VelocityTracker r0 = r7.mVelocityTracker
            if (r0 != 0) goto L_0x002a
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r7.mVelocityTracker = r0
        L_0x002a:
            android.view.VelocityTracker r0 = r7.mVelocityTracker
            r0.addMovement(r8)
            int r0 = r8.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            if (r0 == 0) goto L_0x012f
            if (r0 == r1) goto L_0x00e2
            r3 = 2
            if (r0 == r3) goto L_0x0073
            r3 = 3
            if (r0 == r3) goto L_0x0068
            r3 = 5
            if (r0 == r3) goto L_0x0058
            r3 = 6
            if (r0 == r3) goto L_0x0047
            goto L_0x014f
        L_0x0047:
            r7.onSecondaryPointerUp(r8)
            int r0 = r7.mActivePointerId
            int r0 = r8.findPointerIndex(r0)
            float r8 = r8.getX(r0)
            r7.mLastMotionX = r8
            goto L_0x014f
        L_0x0058:
            int r0 = r8.getActionIndex()
            float r3 = r8.getX(r0)
            r7.mLastMotionX = r3
            int r8 = r8.getPointerId(r0)
            goto L_0x014d
        L_0x0068:
            boolean r8 = r7.mIsBeingDragged
            if (r8 == 0) goto L_0x014f
            int r8 = r7.mCurItem
            r7.scrollToItem(r8, r1, r2, r2)
            goto L_0x012a
        L_0x0073:
            boolean r0 = r7.mIsBeingDragged
            if (r0 != 0) goto L_0x00ce
            int r0 = r7.mActivePointerId
            int r0 = r8.findPointerIndex(r0)
            r3 = -1
            if (r0 != r3) goto L_0x0082
            goto L_0x012a
        L_0x0082:
            float r3 = r8.getX(r0)
            float r4 = r7.mLastMotionX
            float r4 = r3 - r4
            float r4 = java.lang.Math.abs(r4)
            float r0 = r8.getY(r0)
            float r5 = r7.mLastMotionY
            float r5 = r0 - r5
            float r5 = java.lang.Math.abs(r5)
            int r6 = r7.mTouchSlop
            float r6 = (float) r6
            int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x00ce
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x00ce
            r7.mIsBeingDragged = r1
            r7.requestParentDisallowInterceptTouchEvent(r1)
            float r4 = r7.mInitialMotionX
            float r3 = r3 - r4
            r5 = 0
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x00b7
            int r3 = r7.mTouchSlop
            float r3 = (float) r3
            float r4 = r4 + r3
            goto L_0x00bb
        L_0x00b7:
            int r3 = r7.mTouchSlop
            float r3 = (float) r3
            float r4 = r4 - r3
        L_0x00bb:
            r7.mLastMotionX = r4
            r7.mLastMotionY = r0
            r7.setScrollState(r1)
            r7.setScrollingCacheEnabled(r1)
            android.view.ViewParent r0 = r7.getParent()
            if (r0 == 0) goto L_0x00ce
            r0.requestDisallowInterceptTouchEvent(r1)
        L_0x00ce:
            boolean r0 = r7.mIsBeingDragged
            if (r0 == 0) goto L_0x014f
            int r0 = r7.mActivePointerId
            int r0 = r8.findPointerIndex(r0)
            float r8 = r8.getX(r0)
            boolean r8 = r7.performDrag(r8)
            r2 = r2 | r8
            goto L_0x014f
        L_0x00e2:
            boolean r0 = r7.mIsBeingDragged
            if (r0 == 0) goto L_0x014f
            android.view.VelocityTracker r0 = r7.mVelocityTracker
            r2 = 1000(0x3e8, float:1.401E-42)
            int r3 = r7.mMaximumVelocity
            float r3 = (float) r3
            r0.computeCurrentVelocity(r2, r3)
            int r2 = r7.mActivePointerId
            float r0 = r0.getXVelocity(r2)
            int r0 = (int) r0
            r7.mPopulatePending = r1
            int r2 = r7.getClientWidth()
            int r3 = r7.getScrollX()
            androidx.viewpager.widget.ViewPager$f r4 = r7.infoForCurrentScrollPosition()
            int r5 = r7.mPageMargin
            float r5 = (float) r5
            float r2 = (float) r2
            float r5 = r5 / r2
            int r6 = r4.f4333b
            float r3 = (float) r3
            float r3 = r3 / r2
            float r2 = r4.f4336e
            float r3 = r3 - r2
            float r2 = r4.f4335d
            float r2 = r2 + r5
            float r3 = r3 / r2
            int r2 = r7.mActivePointerId
            int r2 = r8.findPointerIndex(r2)
            float r8 = r8.getX(r2)
            float r2 = r7.mInitialMotionX
            float r8 = r8 - r2
            int r8 = (int) r8
            int r8 = r7.determineTargetPage(r6, r3, r0, r8)
            r7.setCurrentItemInternal(r8, r1, r1, r0)
        L_0x012a:
            boolean r2 = r7.resetTouch()
            goto L_0x014f
        L_0x012f:
            android.widget.Scroller r0 = r7.mScroller
            r0.abortAnimation()
            r7.mPopulatePending = r2
            r7.populate()
            float r0 = r8.getX()
            r7.mInitialMotionX = r0
            r7.mLastMotionX = r0
            float r0 = r8.getY()
            r7.mInitialMotionY = r0
            r7.mLastMotionY = r0
            int r8 = r8.getPointerId(r2)
        L_0x014d:
            r7.mActivePointerId = r8
        L_0x014f:
            if (r2 == 0) goto L_0x0154
            androidx.core.view.x.h0(r7)
        L_0x0154:
            return r1
        L_0x0155:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: package-private */
    public boolean pageLeft() {
        int i10 = this.mCurItem;
        if (i10 <= 0) {
            return false;
        }
        setCurrentItem(i10 - 1, true);
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean pageRight() {
        a aVar = this.mAdapter;
        if (aVar == null || this.mCurItem >= aVar.getCount() - 1) {
            return false;
        }
        setCurrentItem(this.mCurItem + 1, true);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void populate() {
        populate(this.mCurItem);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0060, code lost:
        if (r9 == r10) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0066, code lost:
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00c0, code lost:
        if (r10 >= 0) goto L_0x00de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ce, code lost:
        if (r10 >= 0) goto L_0x00de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00dc, code lost:
        if (r10 >= 0) goto L_0x00de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00e7, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x013c, code lost:
        if (r4 < r0.mItems.size()) goto L_0x013e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0147, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x015a, code lost:
        if (r4 < r0.mItems.size()) goto L_0x013e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x016c, code lost:
        if (r4 < r0.mItems.size()) goto L_0x013e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void populate(int r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r0.mCurItem
            if (r2 == r1) goto L_0x000f
            androidx.viewpager.widget.ViewPager$f r2 = r0.infoForPosition(r2)
            r0.mCurItem = r1
            goto L_0x0010
        L_0x000f:
            r2 = 0
        L_0x0010:
            androidx.viewpager.widget.a r1 = r0.mAdapter
            if (r1 != 0) goto L_0x0018
            r17.sortChildDrawingOrder()
            return
        L_0x0018:
            boolean r1 = r0.mPopulatePending
            if (r1 == 0) goto L_0x0020
            r17.sortChildDrawingOrder()
            return
        L_0x0020:
            android.os.IBinder r1 = r17.getWindowToken()
            if (r1 != 0) goto L_0x0027
            return
        L_0x0027:
            androidx.viewpager.widget.a r1 = r0.mAdapter
            r1.startUpdate((android.view.ViewGroup) r0)
            int r1 = r0.mOffscreenPageLimit
            int r4 = r0.mCurItem
            int r4 = r4 - r1
            r5 = 0
            int r4 = java.lang.Math.max(r5, r4)
            androidx.viewpager.widget.a r6 = r0.mAdapter
            int r6 = r6.getCount()
            int r7 = r6 + -1
            int r8 = r0.mCurItem
            int r8 = r8 + r1
            int r1 = java.lang.Math.min(r7, r8)
            int r7 = r0.mExpectedAdapterCount
            if (r6 != r7) goto L_0x01ef
            r7 = r5
        L_0x004a:
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$f> r8 = r0.mItems
            int r8 = r8.size()
            if (r7 >= r8) goto L_0x0066
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$f> r8 = r0.mItems
            java.lang.Object r8 = r8.get(r7)
            androidx.viewpager.widget.ViewPager$f r8 = (androidx.viewpager.widget.ViewPager.f) r8
            int r9 = r8.f4333b
            int r10 = r0.mCurItem
            if (r9 < r10) goto L_0x0063
            if (r9 != r10) goto L_0x0066
            goto L_0x0067
        L_0x0063:
            int r7 = r7 + 1
            goto L_0x004a
        L_0x0066:
            r8 = 0
        L_0x0067:
            if (r8 != 0) goto L_0x0071
            if (r6 <= 0) goto L_0x0071
            int r8 = r0.mCurItem
            androidx.viewpager.widget.ViewPager$f r8 = r0.addNewItem(r8, r7)
        L_0x0071:
            r9 = 0
            if (r8 == 0) goto L_0x017c
            int r10 = r7 + -1
            if (r10 < 0) goto L_0x0081
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$f> r11 = r0.mItems
            java.lang.Object r11 = r11.get(r10)
            androidx.viewpager.widget.ViewPager$f r11 = (androidx.viewpager.widget.ViewPager.f) r11
            goto L_0x0082
        L_0x0081:
            r11 = 0
        L_0x0082:
            int r12 = r17.getClientWidth()
            r13 = 1073741824(0x40000000, float:2.0)
            if (r12 > 0) goto L_0x008c
            r14 = r9
            goto L_0x0098
        L_0x008c:
            float r14 = r8.f4335d
            float r14 = r13 - r14
            int r15 = r17.getPaddingLeft()
            float r15 = (float) r15
            float r3 = (float) r12
            float r15 = r15 / r3
            float r14 = r14 + r15
        L_0x0098:
            int r3 = r0.mCurItem
            int r3 = r3 + -1
            r15 = r9
        L_0x009d:
            if (r3 < 0) goto L_0x00ed
            int r16 = (r15 > r14 ? 1 : (r15 == r14 ? 0 : -1))
            if (r16 < 0) goto L_0x00c3
            if (r3 >= r4) goto L_0x00c3
            if (r11 != 0) goto L_0x00a8
            goto L_0x00ed
        L_0x00a8:
            int r5 = r11.f4333b
            if (r3 != r5) goto L_0x00e9
            boolean r5 = r11.f4334c
            if (r5 != 0) goto L_0x00e9
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$f> r5 = r0.mItems
            r5.remove(r10)
            androidx.viewpager.widget.a r5 = r0.mAdapter
            java.lang.Object r11 = r11.f4332a
            r5.destroyItem((android.view.ViewGroup) r0, (int) r3, (java.lang.Object) r11)
            int r10 = r10 + -1
            int r7 = r7 + -1
            if (r10 < 0) goto L_0x00e7
            goto L_0x00de
        L_0x00c3:
            if (r11 == 0) goto L_0x00d1
            int r5 = r11.f4333b
            if (r3 != r5) goto L_0x00d1
            float r5 = r11.f4335d
            float r15 = r15 + r5
            int r10 = r10 + -1
            if (r10 < 0) goto L_0x00e7
            goto L_0x00de
        L_0x00d1:
            int r5 = r10 + 1
            androidx.viewpager.widget.ViewPager$f r5 = r0.addNewItem(r3, r5)
            float r5 = r5.f4335d
            float r15 = r15 + r5
            int r7 = r7 + 1
            if (r10 < 0) goto L_0x00e7
        L_0x00de:
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$f> r5 = r0.mItems
            java.lang.Object r5 = r5.get(r10)
            androidx.viewpager.widget.ViewPager$f r5 = (androidx.viewpager.widget.ViewPager.f) r5
            goto L_0x00e8
        L_0x00e7:
            r5 = 0
        L_0x00e8:
            r11 = r5
        L_0x00e9:
            int r3 = r3 + -1
            r5 = 0
            goto L_0x009d
        L_0x00ed:
            float r3 = r8.f4335d
            int r4 = r7 + 1
            int r5 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r5 >= 0) goto L_0x0170
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$f> r5 = r0.mItems
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x0106
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$f> r5 = r0.mItems
            java.lang.Object r5 = r5.get(r4)
            androidx.viewpager.widget.ViewPager$f r5 = (androidx.viewpager.widget.ViewPager.f) r5
            goto L_0x0107
        L_0x0106:
            r5 = 0
        L_0x0107:
            if (r12 > 0) goto L_0x010b
            r10 = r9
            goto L_0x0113
        L_0x010b:
            int r10 = r17.getPaddingRight()
            float r10 = (float) r10
            float r11 = (float) r12
            float r10 = r10 / r11
            float r10 = r10 + r13
        L_0x0113:
            int r11 = r0.mCurItem
        L_0x0115:
            int r11 = r11 + 1
            if (r11 >= r6) goto L_0x0170
            int r12 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r12 < 0) goto L_0x0149
            if (r11 <= r1) goto L_0x0149
            if (r5 != 0) goto L_0x0122
            goto L_0x0170
        L_0x0122:
            int r12 = r5.f4333b
            if (r11 != r12) goto L_0x016f
            boolean r12 = r5.f4334c
            if (r12 != 0) goto L_0x016f
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$f> r12 = r0.mItems
            r12.remove(r4)
            androidx.viewpager.widget.a r12 = r0.mAdapter
            java.lang.Object r5 = r5.f4332a
            r12.destroyItem((android.view.ViewGroup) r0, (int) r11, (java.lang.Object) r5)
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$f> r5 = r0.mItems
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x0147
        L_0x013e:
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$f> r5 = r0.mItems
            java.lang.Object r5 = r5.get(r4)
            androidx.viewpager.widget.ViewPager$f r5 = (androidx.viewpager.widget.ViewPager.f) r5
            goto L_0x016f
        L_0x0147:
            r5 = 0
            goto L_0x016f
        L_0x0149:
            if (r5 == 0) goto L_0x015d
            int r12 = r5.f4333b
            if (r11 != r12) goto L_0x015d
            float r5 = r5.f4335d
            float r3 = r3 + r5
            int r4 = r4 + 1
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$f> r5 = r0.mItems
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x0147
            goto L_0x013e
        L_0x015d:
            androidx.viewpager.widget.ViewPager$f r5 = r0.addNewItem(r11, r4)
            int r4 = r4 + 1
            float r5 = r5.f4335d
            float r3 = r3 + r5
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$f> r5 = r0.mItems
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x0147
            goto L_0x013e
        L_0x016f:
            goto L_0x0115
        L_0x0170:
            r0.calculatePageOffsets(r8, r7, r2)
            androidx.viewpager.widget.a r1 = r0.mAdapter
            int r2 = r0.mCurItem
            java.lang.Object r3 = r8.f4332a
            r1.setPrimaryItem((android.view.ViewGroup) r0, (int) r2, (java.lang.Object) r3)
        L_0x017c:
            androidx.viewpager.widget.a r1 = r0.mAdapter
            r1.finishUpdate((android.view.ViewGroup) r0)
            int r1 = r17.getChildCount()
            r2 = 0
        L_0x0186:
            if (r2 >= r1) goto L_0x01af
            android.view.View r3 = r0.getChildAt(r2)
            android.view.ViewGroup$LayoutParams r4 = r3.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r4 = (androidx.viewpager.widget.ViewPager.LayoutParams) r4
            r4.f4325f = r2
            boolean r5 = r4.f4320a
            if (r5 != 0) goto L_0x01ac
            float r5 = r4.f4322c
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 != 0) goto L_0x01ac
            androidx.viewpager.widget.ViewPager$f r3 = r0.infoForChild(r3)
            if (r3 == 0) goto L_0x01ac
            float r5 = r3.f4335d
            r4.f4322c = r5
            int r3 = r3.f4333b
            r4.f4324e = r3
        L_0x01ac:
            int r2 = r2 + 1
            goto L_0x0186
        L_0x01af:
            r17.sortChildDrawingOrder()
            boolean r1 = r17.hasFocus()
            if (r1 == 0) goto L_0x01ee
            android.view.View r1 = r17.findFocus()
            if (r1 == 0) goto L_0x01c3
            androidx.viewpager.widget.ViewPager$f r3 = r0.infoForAnyChild(r1)
            goto L_0x01c4
        L_0x01c3:
            r3 = 0
        L_0x01c4:
            if (r3 == 0) goto L_0x01cc
            int r1 = r3.f4333b
            int r2 = r0.mCurItem
            if (r1 == r2) goto L_0x01ee
        L_0x01cc:
            r5 = 0
        L_0x01cd:
            int r1 = r17.getChildCount()
            if (r5 >= r1) goto L_0x01ee
            android.view.View r1 = r0.getChildAt(r5)
            androidx.viewpager.widget.ViewPager$f r2 = r0.infoForChild(r1)
            if (r2 == 0) goto L_0x01eb
            int r2 = r2.f4333b
            int r3 = r0.mCurItem
            if (r2 != r3) goto L_0x01eb
            r2 = 2
            boolean r1 = r1.requestFocus(r2)
            if (r1 == 0) goto L_0x01eb
            goto L_0x01ee
        L_0x01eb:
            int r5 = r5 + 1
            goto L_0x01cd
        L_0x01ee:
            return
        L_0x01ef:
            android.content.res.Resources r1 = r17.getResources()     // Catch:{ NotFoundException -> 0x01fc }
            int r2 = r17.getId()     // Catch:{ NotFoundException -> 0x01fc }
            java.lang.String r1 = r1.getResourceName(r2)     // Catch:{ NotFoundException -> 0x01fc }
            goto L_0x0204
        L_0x01fc:
            int r1 = r17.getId()
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
        L_0x0204:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: "
            r3.append(r4)
            int r4 = r0.mExpectedAdapterCount
            r3.append(r4)
            java.lang.String r4 = ", found: "
            r3.append(r4)
            r3.append(r6)
            java.lang.String r4 = " Pager id: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = " Pager class: "
            r3.append(r1)
            java.lang.Class r1 = r17.getClass()
            r3.append(r1)
            java.lang.String r1 = " Problematic adapter: "
            r3.append(r1)
            androidx.viewpager.widget.a r1 = r0.mAdapter
            java.lang.Class r1 = r1.getClass()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.populate(int):void");
    }

    public void removeOnAdapterChangeListener(h hVar) {
        List<h> list = this.mAdapterChangeListeners;
        if (list != null) {
            list.remove(hVar);
        }
    }

    public void removeOnPageChangeListener(i iVar) {
        List<i> list = this.mOnPageChangeListeners;
        if (list != null) {
            list.remove(iVar);
        }
    }

    public void removeView(View view) {
        if (this.mInLayout) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(a aVar) {
        a aVar2 = this.mAdapter;
        if (aVar2 != null) {
            aVar2.setViewPagerObserver((DataSetObserver) null);
            this.mAdapter.startUpdate((ViewGroup) this);
            for (int i10 = 0; i10 < this.mItems.size(); i10++) {
                f fVar = this.mItems.get(i10);
                this.mAdapter.destroyItem((ViewGroup) this, fVar.f4333b, fVar.f4332a);
            }
            this.mAdapter.finishUpdate((ViewGroup) this);
            this.mItems.clear();
            removeNonDecorViews();
            this.mCurItem = 0;
            scrollTo(0, 0);
        }
        a aVar3 = this.mAdapter;
        this.mAdapter = aVar;
        this.mExpectedAdapterCount = 0;
        if (aVar != null) {
            if (this.mObserver == null) {
                this.mObserver = new k();
            }
            this.mAdapter.setViewPagerObserver(this.mObserver);
            this.mPopulatePending = false;
            boolean z10 = this.mFirstLayout;
            this.mFirstLayout = true;
            this.mExpectedAdapterCount = this.mAdapter.getCount();
            if (this.mRestoredCurItem >= 0) {
                this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
                setCurrentItemInternal(this.mRestoredCurItem, false, true);
                this.mRestoredCurItem = -1;
                this.mRestoredAdapterState = null;
                this.mRestoredClassLoader = null;
            } else if (!z10) {
                populate();
            } else {
                requestLayout();
            }
        }
        List<h> list = this.mAdapterChangeListeners;
        if (list != null && !list.isEmpty()) {
            int size = this.mAdapterChangeListeners.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.mAdapterChangeListeners.get(i11).d(this, aVar3, aVar);
            }
        }
    }

    public void setCurrentItem(int i10) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i10, !this.mFirstLayout, false);
    }

    public void setCurrentItem(int i10, boolean z10) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i10, z10, false);
    }

    /* access modifiers changed from: package-private */
    public void setCurrentItemInternal(int i10, boolean z10, boolean z11) {
        setCurrentItemInternal(i10, z10, z11, 0);
    }

    /* access modifiers changed from: package-private */
    public void setCurrentItemInternal(int i10, boolean z10, boolean z11, int i11) {
        a aVar = this.mAdapter;
        boolean z12 = false;
        if (aVar == null || aVar.getCount() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z11 || this.mCurItem != i10 || this.mItems.size() == 0) {
            if (i10 < 0) {
                i10 = 0;
            } else if (i10 >= this.mAdapter.getCount()) {
                i10 = this.mAdapter.getCount() - 1;
            }
            int i12 = this.mOffscreenPageLimit;
            int i13 = this.mCurItem;
            if (i10 > i13 + i12 || i10 < i13 - i12) {
                for (int i14 = 0; i14 < this.mItems.size(); i14++) {
                    this.mItems.get(i14).f4334c = true;
                }
            }
            if (this.mCurItem != i10) {
                z12 = true;
            }
            if (this.mFirstLayout) {
                this.mCurItem = i10;
                if (z12) {
                    dispatchOnPageSelected(i10);
                }
                requestLayout();
                return;
            }
            populate(i10);
            scrollToItem(i10, z10, i11, z12);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    /* access modifiers changed from: package-private */
    public i setInternalPageChangeListener(i iVar) {
        i iVar2 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = iVar;
        return iVar2;
    }

    public void setOffscreenPageLimit(int i10) {
        if (i10 < 1) {
            Log.w(TAG, "Requested offscreen page limit " + i10 + " too small; defaulting to " + 1);
            i10 = 1;
        }
        if (i10 != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = i10;
            populate();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(i iVar) {
        this.mOnPageChangeListener = iVar;
    }

    public void setPageMargin(int i10) {
        int i11 = this.mPageMargin;
        this.mPageMargin = i10;
        int width = getWidth();
        recomputeScrollPosition(width, width, i10, i11);
        requestLayout();
    }

    public void setPageMarginDrawable(int i10) {
        setPageMarginDrawable(androidx.core.content.a.f(getContext(), i10));
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.mMarginDrawable = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageTransformer(boolean z10, j jVar) {
        setPageTransformer(z10, jVar, 2);
    }

    public void setPageTransformer(boolean z10, j jVar, int i10) {
        int i11 = 1;
        boolean z11 = jVar != null;
        boolean z12 = z11 != (this.mPageTransformer != null);
        this.mPageTransformer = jVar;
        setChildrenDrawingOrderEnabled(z11);
        if (z11) {
            if (z10) {
                i11 = 2;
            }
            this.mDrawingOrder = i11;
            this.mPageTransformerLayerType = i10;
        } else {
            this.mDrawingOrder = 0;
        }
        if (z12) {
            populate();
        }
    }

    /* access modifiers changed from: package-private */
    public void setScrollState(int i10) {
        if (this.mScrollState != i10) {
            this.mScrollState = i10;
            if (this.mPageTransformer != null) {
                enableLayers(i10 != 0);
            }
            dispatchOnScrollStateChanged(i10);
        }
    }

    /* access modifiers changed from: package-private */
    public void smoothScrollTo(int i10, int i11) {
        smoothScrollTo(i10, i11, 0);
    }

    /* access modifiers changed from: package-private */
    public void smoothScrollTo(int i10, int i11, int i12) {
        int i13;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.mScroller;
        if (scroller != null && !scroller.isFinished()) {
            i13 = this.mIsScrollStarted ? this.mScroller.getCurrX() : this.mScroller.getStartX();
            this.mScroller.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            i13 = getScrollX();
        }
        int i14 = i13;
        int scrollY = getScrollY();
        int i15 = i10 - i14;
        int i16 = i11 - scrollY;
        if (i15 == 0 && i16 == 0) {
            completeScroll(false);
            populate();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i17 = clientWidth / 2;
        float f10 = (float) clientWidth;
        float f11 = (float) i17;
        float distanceInfluenceForSnapDuration = f11 + (distanceInfluenceForSnapDuration(Math.min(1.0f, (((float) Math.abs(i15)) * 1.0f) / f10)) * f11);
        int abs = Math.abs(i12);
        int min = Math.min(abs > 0 ? Math.round(Math.abs(distanceInfluenceForSnapDuration / ((float) abs)) * 1000.0f) * 4 : (int) (((((float) Math.abs(i15)) / ((f10 * this.mAdapter.getPageWidth(this.mCurItem)) + ((float) this.mPageMargin))) + 1.0f) * 100.0f), MAX_SETTLE_DURATION);
        this.mIsScrollStarted = false;
        this.mScroller.startScroll(i14, scrollY, i15, i16, min);
        x.h0(this);
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mMarginDrawable;
    }
}
