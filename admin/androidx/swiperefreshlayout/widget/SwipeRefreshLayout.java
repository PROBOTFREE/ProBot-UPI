package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.ListView;
import androidx.core.view.l;
import androidx.core.view.m;
import androidx.core.view.p;
import androidx.core.view.q;
import androidx.core.view.x;

public class SwipeRefreshLayout extends ViewGroup implements p, l {
    private static final String O = SwipeRefreshLayout.class.getSimpleName();
    private static final int[] P = {16842766};
    int A;
    b B;
    private Animation C;
    private Animation D;
    private Animation E;
    private Animation F;
    private Animation G;
    boolean H;
    private int I;
    boolean J;
    private i K;
    private Animation.AnimationListener L = new a();
    private final Animation M = new f();
    private final Animation N = new g();

    /* renamed from: a  reason: collision with root package name */
    private View f3882a;

    /* renamed from: b  reason: collision with root package name */
    j f3883b;

    /* renamed from: c  reason: collision with root package name */
    boolean f3884c = false;

    /* renamed from: d  reason: collision with root package name */
    private int f3885d;

    /* renamed from: e  reason: collision with root package name */
    private float f3886e = -1.0f;

    /* renamed from: f  reason: collision with root package name */
    private float f3887f;

    /* renamed from: g  reason: collision with root package name */
    private final q f3888g;

    /* renamed from: h  reason: collision with root package name */
    private final m f3889h;

    /* renamed from: i  reason: collision with root package name */
    private final int[] f3890i = new int[2];

    /* renamed from: j  reason: collision with root package name */
    private final int[] f3891j = new int[2];

    /* renamed from: k  reason: collision with root package name */
    private boolean f3892k;

    /* renamed from: l  reason: collision with root package name */
    private int f3893l;

    /* renamed from: m  reason: collision with root package name */
    int f3894m;

    /* renamed from: n  reason: collision with root package name */
    private float f3895n;

    /* renamed from: o  reason: collision with root package name */
    private float f3896o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f3897p;

    /* renamed from: q  reason: collision with root package name */
    private int f3898q = -1;

    /* renamed from: r  reason: collision with root package name */
    boolean f3899r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f3900s;

    /* renamed from: t  reason: collision with root package name */
    private final DecelerateInterpolator f3901t;

    /* renamed from: u  reason: collision with root package name */
    a f3902u;

    /* renamed from: v  reason: collision with root package name */
    private int f3903v = -1;

    /* renamed from: w  reason: collision with root package name */
    protected int f3904w;

    /* renamed from: x  reason: collision with root package name */
    float f3905x;

    /* renamed from: y  reason: collision with root package name */
    protected int f3906y;

    /* renamed from: z  reason: collision with root package name */
    int f3907z;

    class a implements Animation.AnimationListener {
        a() {
        }

        public void onAnimationEnd(Animation animation) {
            j jVar;
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (swipeRefreshLayout.f3884c) {
                swipeRefreshLayout.B.setAlpha(255);
                SwipeRefreshLayout.this.B.start();
                SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
                if (swipeRefreshLayout2.H && (jVar = swipeRefreshLayout2.f3883b) != null) {
                    jVar.onRefresh();
                }
                SwipeRefreshLayout swipeRefreshLayout3 = SwipeRefreshLayout.this;
                swipeRefreshLayout3.f3894m = swipeRefreshLayout3.f3902u.getTop();
                return;
            }
            swipeRefreshLayout.q();
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    class b extends Animation {
        b() {
        }

        public void applyTransformation(float f10, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(f10);
        }
    }

    class c extends Animation {
        c() {
        }

        public void applyTransformation(float f10, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(1.0f - f10);
        }
    }

    class d extends Animation {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f3911a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f3912b;

        d(int i10, int i11) {
            this.f3911a = i10;
            this.f3912b = i11;
        }

        public void applyTransformation(float f10, Transformation transformation) {
            b bVar = SwipeRefreshLayout.this.B;
            int i10 = this.f3911a;
            bVar.setAlpha((int) (((float) i10) + (((float) (this.f3912b - i10)) * f10)));
        }
    }

    class e implements Animation.AnimationListener {
        e() {
        }

        public void onAnimationEnd(Animation animation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (!swipeRefreshLayout.f3899r) {
                swipeRefreshLayout.w((Animation.AnimationListener) null);
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    class f extends Animation {
        f() {
        }

        public void applyTransformation(float f10, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            int abs = !swipeRefreshLayout.J ? swipeRefreshLayout.f3907z - Math.abs(swipeRefreshLayout.f3906y) : swipeRefreshLayout.f3907z;
            SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
            int i10 = swipeRefreshLayout2.f3904w;
            SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((i10 + ((int) (((float) (abs - i10)) * f10))) - swipeRefreshLayout2.f3902u.getTop());
            SwipeRefreshLayout.this.B.e(1.0f - f10);
        }
    }

    class g extends Animation {
        g() {
        }

        public void applyTransformation(float f10, Transformation transformation) {
            SwipeRefreshLayout.this.l(f10);
        }
    }

    class h extends Animation {
        h() {
        }

        public void applyTransformation(float f10, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            float f11 = swipeRefreshLayout.f3905x;
            swipeRefreshLayout.setAnimationProgress(f11 + ((-f11) * f10));
            SwipeRefreshLayout.this.l(f10);
        }
    }

    public interface i {
        boolean a(SwipeRefreshLayout swipeRefreshLayout, View view);
    }

    public interface j {
        void onRefresh();
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3885d = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f3893l = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.f3901t = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.I = (int) (displayMetrics.density * 40.0f);
        e();
        setChildrenDrawingOrderEnabled(true);
        int i10 = (int) (displayMetrics.density * 64.0f);
        this.f3907z = i10;
        this.f3886e = (float) i10;
        this.f3888g = new q(this);
        this.f3889h = new m(this);
        setNestedScrollingEnabled(true);
        int i11 = -this.I;
        this.f3894m = i11;
        this.f3906y = i11;
        l(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, P);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }

    private void a(int i10, Animation.AnimationListener animationListener) {
        this.f3904w = i10;
        this.M.reset();
        this.M.setDuration(200);
        this.M.setInterpolator(this.f3901t);
        if (animationListener != null) {
            this.f3902u.b(animationListener);
        }
        this.f3902u.clearAnimation();
        this.f3902u.startAnimation(this.M);
    }

    private void b(int i10, Animation.AnimationListener animationListener) {
        if (this.f3899r) {
            x(i10, animationListener);
            return;
        }
        this.f3904w = i10;
        this.N.reset();
        this.N.setDuration(200);
        this.N.setInterpolator(this.f3901t);
        if (animationListener != null) {
            this.f3902u.b(animationListener);
        }
        this.f3902u.clearAnimation();
        this.f3902u.startAnimation(this.N);
    }

    private void e() {
        this.f3902u = new a(getContext(), -328966);
        b bVar = new b(getContext());
        this.B = bVar;
        bVar.l(1);
        this.f3902u.setImageDrawable(this.B);
        this.f3902u.setVisibility(8);
        addView(this.f3902u);
    }

    private void f() {
        if (this.f3882a == null) {
            for (int i10 = 0; i10 < getChildCount(); i10++) {
                View childAt = getChildAt(i10);
                if (!childAt.equals(this.f3902u)) {
                    this.f3882a = childAt;
                    return;
                }
            }
        }
    }

    private void g(float f10) {
        if (f10 > this.f3886e) {
            r(true, true);
            return;
        }
        this.f3884c = false;
        this.B.j(0.0f, 0.0f);
        e eVar = null;
        if (!this.f3899r) {
            eVar = new e();
        }
        b(this.f3894m, eVar);
        this.B.d(false);
    }

    private boolean h(Animation animation) {
        return animation != null && animation.hasStarted() && !animation.hasEnded();
    }

    private void k(float f10) {
        this.B.d(true);
        float min = Math.min(1.0f, Math.abs(f10 / this.f3886e));
        float max = (((float) Math.max(((double) min) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f10) - this.f3886e;
        int i10 = this.A;
        if (i10 <= 0) {
            i10 = this.J ? this.f3907z - this.f3906y : this.f3907z;
        }
        float f11 = (float) i10;
        double max2 = (double) (Math.max(0.0f, Math.min(abs, f11 * 2.0f) / f11) / 4.0f);
        float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f;
        int i11 = this.f3906y + ((int) ((f11 * min) + (f11 * pow * 2.0f)));
        if (this.f3902u.getVisibility() != 0) {
            this.f3902u.setVisibility(0);
        }
        if (!this.f3899r) {
            this.f3902u.setScaleX(1.0f);
            this.f3902u.setScaleY(1.0f);
        }
        if (this.f3899r) {
            setAnimationProgress(Math.min(1.0f, f10 / this.f3886e));
        }
        if (f10 < this.f3886e) {
            if (this.B.getAlpha() > 76 && !h(this.E)) {
                v();
            }
        } else if (this.B.getAlpha() < 255 && !h(this.F)) {
            u();
        }
        this.B.j(0.0f, Math.min(0.8f, max * 0.8f));
        this.B.e(Math.min(1.0f, max));
        this.B.g((((max * 0.4f) - 16.0f) + (pow * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i11 - this.f3894m);
    }

    private void p(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f3898q) {
            this.f3898q = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    private void r(boolean z10, boolean z11) {
        if (this.f3884c != z10) {
            this.H = z11;
            f();
            this.f3884c = z10;
            if (z10) {
                a(this.f3894m, this.L);
            } else {
                w(this.L);
            }
        }
    }

    private Animation s(int i10, int i11) {
        d dVar = new d(i10, i11);
        dVar.setDuration(300);
        this.f3902u.b((Animation.AnimationListener) null);
        this.f3902u.clearAnimation();
        this.f3902u.startAnimation(dVar);
        return dVar;
    }

    private void setColorViewAlpha(int i10) {
        this.f3902u.getBackground().setAlpha(i10);
        this.B.setAlpha(i10);
    }

    private void t(float f10) {
        float f11 = this.f3896o;
        int i10 = this.f3885d;
        if (f10 - f11 > ((float) i10) && !this.f3897p) {
            this.f3895n = f11 + ((float) i10);
            this.f3897p = true;
            this.B.setAlpha(76);
        }
    }

    private void u() {
        this.F = s(this.B.getAlpha(), 255);
    }

    private void v() {
        this.E = s(this.B.getAlpha(), 76);
    }

    private void x(int i10, Animation.AnimationListener animationListener) {
        this.f3904w = i10;
        this.f3905x = this.f3902u.getScaleX();
        h hVar = new h();
        this.G = hVar;
        hVar.setDuration(150);
        if (animationListener != null) {
            this.f3902u.b(animationListener);
        }
        this.f3902u.clearAnimation();
        this.f3902u.startAnimation(this.G);
    }

    private void y(Animation.AnimationListener animationListener) {
        this.f3902u.setVisibility(0);
        this.B.setAlpha(255);
        b bVar = new b();
        this.C = bVar;
        bVar.setDuration((long) this.f3893l);
        if (animationListener != null) {
            this.f3902u.b(animationListener);
        }
        this.f3902u.clearAnimation();
        this.f3902u.startAnimation(this.C);
    }

    public boolean d() {
        i iVar = this.K;
        if (iVar != null) {
            return iVar.a(this, this.f3882a);
        }
        View view = this.f3882a;
        return view instanceof ListView ? androidx.core.widget.i.a((ListView) view, -1) : view.canScrollVertically(-1);
    }

    public boolean dispatchNestedFling(float f10, float f11, boolean z10) {
        return this.f3889h.a(f10, f11, z10);
    }

    public boolean dispatchNestedPreFling(float f10, float f11) {
        return this.f3889h.b(f10, f11);
    }

    public boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2) {
        return this.f3889h.c(i10, i11, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr) {
        return this.f3889h.f(i10, i11, i12, i13, iArr);
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i10, int i11) {
        int i12 = this.f3903v;
        return i12 < 0 ? i11 : i11 == i10 + -1 ? i12 : i11 >= i12 ? i11 + 1 : i11;
    }

    public int getNestedScrollAxes() {
        return this.f3888g.a();
    }

    public int getProgressCircleDiameter() {
        return this.I;
    }

    public int getProgressViewEndOffset() {
        return this.f3907z;
    }

    public int getProgressViewStartOffset() {
        return this.f3906y;
    }

    public boolean hasNestedScrollingParent() {
        return this.f3889h.j();
    }

    public boolean isNestedScrollingEnabled() {
        return this.f3889h.l();
    }

    /* access modifiers changed from: package-private */
    public void l(float f10) {
        int i10 = this.f3904w;
        setTargetOffsetTopAndBottom((i10 + ((int) (((float) (this.f3906y - i10)) * f10))) - this.f3902u.getTop());
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        q();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        f();
        int actionMasked = motionEvent.getActionMasked();
        if (this.f3900s && actionMasked == 0) {
            this.f3900s = false;
        }
        if (!isEnabled() || this.f3900s || d() || this.f3884c || this.f3892k) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i10 = this.f3898q;
                    if (i10 == -1) {
                        Log.e(O, "Got ACTION_MOVE event but don't have an active pointer id.");
                        return false;
                    }
                    int findPointerIndex = motionEvent.findPointerIndex(i10);
                    if (findPointerIndex < 0) {
                        return false;
                    }
                    t(motionEvent.getY(findPointerIndex));
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        p(motionEvent);
                    }
                }
            }
            this.f3897p = false;
            this.f3898q = -1;
        } else {
            setTargetOffsetTopAndBottom(this.f3906y - this.f3902u.getTop());
            int pointerId = motionEvent.getPointerId(0);
            this.f3898q = pointerId;
            this.f3897p = false;
            int findPointerIndex2 = motionEvent.findPointerIndex(pointerId);
            if (findPointerIndex2 < 0) {
                return false;
            }
            this.f3896o = motionEvent.getY(findPointerIndex2);
        }
        return this.f3897p;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.f3882a == null) {
                f();
            }
            View view = this.f3882a;
            if (view != null) {
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                int measuredWidth2 = this.f3902u.getMeasuredWidth();
                int measuredHeight2 = this.f3902u.getMeasuredHeight();
                int i14 = measuredWidth / 2;
                int i15 = measuredWidth2 / 2;
                int i16 = this.f3894m;
                this.f3902u.layout(i14 - i15, i16, i14 + i15, measuredHeight2 + i16);
            }
        }
    }

    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f3882a == null) {
            f();
        }
        View view = this.f3882a;
        if (view != null) {
            view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.f3902u.measure(View.MeasureSpec.makeMeasureSpec(this.I, 1073741824), View.MeasureSpec.makeMeasureSpec(this.I, 1073741824));
            this.f3903v = -1;
            for (int i12 = 0; i12 < getChildCount(); i12++) {
                if (getChildAt(i12) == this.f3902u) {
                    this.f3903v = i12;
                    return;
                }
            }
        }
    }

    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        return dispatchNestedFling(f10, f11, z10);
    }

    public boolean onNestedPreFling(View view, float f10, float f11) {
        return dispatchNestedPreFling(f10, f11);
    }

    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
        if (i11 > 0) {
            float f10 = this.f3887f;
            if (f10 > 0.0f) {
                float f11 = (float) i11;
                if (f11 > f10) {
                    iArr[1] = i11 - ((int) f10);
                    this.f3887f = 0.0f;
                } else {
                    this.f3887f = f10 - f11;
                    iArr[1] = i11;
                }
                k(this.f3887f);
            }
        }
        if (this.J && i11 > 0 && this.f3887f == 0.0f && Math.abs(i11 - iArr[1]) > 0) {
            this.f3902u.setVisibility(8);
        }
        int[] iArr2 = this.f3890i;
        if (dispatchNestedPreScroll(i10 - iArr[0], i11 - iArr[1], iArr2, (int[]) null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    public void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        dispatchNestedScroll(i10, i11, i12, i13, this.f3891j);
        int i14 = i13 + this.f3891j[1];
        if (i14 < 0 && !d()) {
            float abs = this.f3887f + ((float) Math.abs(i14));
            this.f3887f = abs;
            k(abs);
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i10) {
        this.f3888g.b(view, view2, i10);
        startNestedScroll(i10 & 2);
        this.f3887f = 0.0f;
        this.f3892k = true;
    }

    public boolean onStartNestedScroll(View view, View view2, int i10) {
        return isEnabled() && !this.f3900s && !this.f3884c && (i10 & 2) != 0;
    }

    public void onStopNestedScroll(View view) {
        this.f3888g.d(view);
        this.f3892k = false;
        float f10 = this.f3887f;
        if (f10 > 0.0f) {
            g(f10);
            this.f3887f = 0.0f;
        }
        stopNestedScroll();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.f3900s && actionMasked == 0) {
            this.f3900s = false;
        }
        if (!isEnabled() || this.f3900s || d() || this.f3884c || this.f3892k) {
            return false;
        }
        if (actionMasked == 0) {
            this.f3898q = motionEvent.getPointerId(0);
            this.f3897p = false;
        } else if (actionMasked == 1) {
            int findPointerIndex = motionEvent.findPointerIndex(this.f3898q);
            if (findPointerIndex < 0) {
                Log.e(O, "Got ACTION_UP event but don't have an active pointer id.");
                return false;
            }
            if (this.f3897p) {
                this.f3897p = false;
                g((motionEvent.getY(findPointerIndex) - this.f3895n) * 0.5f);
            }
            this.f3898q = -1;
            return false;
        } else if (actionMasked == 2) {
            int findPointerIndex2 = motionEvent.findPointerIndex(this.f3898q);
            if (findPointerIndex2 < 0) {
                Log.e(O, "Got ACTION_MOVE event but have an invalid active pointer id.");
                return false;
            }
            float y10 = motionEvent.getY(findPointerIndex2);
            t(y10);
            if (this.f3897p) {
                float f10 = (y10 - this.f3895n) * 0.5f;
                if (f10 <= 0.0f) {
                    return false;
                }
                k(f10);
            }
        } else if (actionMasked == 3) {
            return false;
        } else {
            if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                if (actionIndex < 0) {
                    Log.e(O, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                    return false;
                }
                this.f3898q = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                p(motionEvent);
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void q() {
        this.f3902u.clearAnimation();
        this.B.stop();
        this.f3902u.setVisibility(8);
        setColorViewAlpha(255);
        if (this.f3899r) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.f3906y - this.f3894m);
        }
        this.f3894m = this.f3902u.getTop();
    }

    public void requestDisallowInterceptTouchEvent(boolean z10) {
        if (Build.VERSION.SDK_INT >= 21 || !(this.f3882a instanceof AbsListView)) {
            View view = this.f3882a;
            if (view == null || x.W(view)) {
                super.requestDisallowInterceptTouchEvent(z10);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setAnimationProgress(float f10) {
        this.f3902u.setScaleX(f10);
        this.f3902u.setScaleY(f10);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        f();
        this.B.f(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            iArr2[i10] = androidx.core.content.a.d(context, iArr[i10]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i10) {
        this.f3886e = (float) i10;
    }

    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        if (!z10) {
            q();
        }
    }

    public void setNestedScrollingEnabled(boolean z10) {
        this.f3889h.m(z10);
    }

    public void setOnChildScrollUpCallback(i iVar) {
        this.K = iVar;
    }

    public void setOnRefreshListener(j jVar) {
        this.f3883b = jVar;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i10) {
        setProgressBackgroundColorSchemeResource(i10);
    }

    public void setProgressBackgroundColorSchemeColor(int i10) {
        this.f3902u.setBackgroundColor(i10);
    }

    public void setProgressBackgroundColorSchemeResource(int i10) {
        setProgressBackgroundColorSchemeColor(androidx.core.content.a.d(getContext(), i10));
    }

    public void setRefreshing(boolean z10) {
        if (!z10 || this.f3884c == z10) {
            r(z10, false);
            return;
        }
        this.f3884c = z10;
        setTargetOffsetTopAndBottom((!this.J ? this.f3907z + this.f3906y : this.f3907z) - this.f3894m);
        this.H = false;
        y(this.L);
    }

    public void setSize(int i10) {
        if (i10 == 0 || i10 == 1) {
            this.I = (int) (getResources().getDisplayMetrics().density * (i10 == 0 ? 56.0f : 40.0f));
            this.f3902u.setImageDrawable((Drawable) null);
            this.B.l(i10);
            this.f3902u.setImageDrawable(this.B);
        }
    }

    public void setSlingshotDistance(int i10) {
        this.A = i10;
    }

    /* access modifiers changed from: package-private */
    public void setTargetOffsetTopAndBottom(int i10) {
        this.f3902u.bringToFront();
        x.b0(this.f3902u, i10);
        this.f3894m = this.f3902u.getTop();
    }

    public boolean startNestedScroll(int i10) {
        return this.f3889h.o(i10);
    }

    public void stopNestedScroll() {
        this.f3889h.q();
    }

    /* access modifiers changed from: package-private */
    public void w(Animation.AnimationListener animationListener) {
        c cVar = new c();
        this.D = cVar;
        cVar.setDuration(150);
        this.f3902u.b(animationListener);
        this.f3902u.clearAnimation();
        this.f3902u.startAnimation(this.D);
    }
}
