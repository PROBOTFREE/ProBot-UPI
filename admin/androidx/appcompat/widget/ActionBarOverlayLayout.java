package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.appcompat.view.menu.j;
import androidx.core.view.f0;
import androidx.core.view.n;
import androidx.core.view.o;
import androidx.core.view.p;
import androidx.core.view.q;
import androidx.core.view.x;
import j.f;
import net.sourceforge.zbar.Config;

@SuppressLint({"UnknownNullness"})
public class ActionBarOverlayLayout extends ViewGroup implements o, p, n, o {
    static final int[] F = {j.a.actionBarSize, 16842841};
    ViewPropertyAnimator A;
    final AnimatorListenerAdapter B;
    private final Runnable C;
    private final Runnable D;
    private final q E;

    /* renamed from: a  reason: collision with root package name */
    private int f680a;

    /* renamed from: b  reason: collision with root package name */
    private int f681b = 0;

    /* renamed from: c  reason: collision with root package name */
    private ContentFrameLayout f682c;

    /* renamed from: d  reason: collision with root package name */
    ActionBarContainer f683d;

    /* renamed from: e  reason: collision with root package name */
    private p f684e;

    /* renamed from: f  reason: collision with root package name */
    private Drawable f685f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f686g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f687h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f688i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f689j;

    /* renamed from: k  reason: collision with root package name */
    boolean f690k;

    /* renamed from: l  reason: collision with root package name */
    private int f691l;

    /* renamed from: m  reason: collision with root package name */
    private int f692m;

    /* renamed from: n  reason: collision with root package name */
    private final Rect f693n = new Rect();

    /* renamed from: o  reason: collision with root package name */
    private final Rect f694o = new Rect();

    /* renamed from: p  reason: collision with root package name */
    private final Rect f695p = new Rect();

    /* renamed from: q  reason: collision with root package name */
    private final Rect f696q = new Rect();

    /* renamed from: r  reason: collision with root package name */
    private final Rect f697r = new Rect();

    /* renamed from: s  reason: collision with root package name */
    private final Rect f698s = new Rect();

    /* renamed from: t  reason: collision with root package name */
    private final Rect f699t = new Rect();

    /* renamed from: u  reason: collision with root package name */
    private f0 f700u;

    /* renamed from: v  reason: collision with root package name */
    private f0 f701v;

    /* renamed from: w  reason: collision with root package name */
    private f0 f702w;

    /* renamed from: x  reason: collision with root package name */
    private f0 f703x;

    /* renamed from: y  reason: collision with root package name */
    private d f704y;

    /* renamed from: z  reason: collision with root package name */
    private OverScroller f705z;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(int i10, int i11) {
            super(i10, i11);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    class a extends AnimatorListenerAdapter {
        a() {
        }

        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.A = null;
            actionBarOverlayLayout.f690k = false;
        }

        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.A = null;
            actionBarOverlayLayout.f690k = false;
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            ActionBarOverlayLayout.this.u();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.A = actionBarOverlayLayout.f683d.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.B);
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            ActionBarOverlayLayout.this.u();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.A = actionBarOverlayLayout.f683d.animate().translationY((float) (-ActionBarOverlayLayout.this.f683d.getHeight())).setListener(ActionBarOverlayLayout.this.B);
        }
    }

    public interface d {
        void a();

        void b();

        void c(int i10);

        void d();

        void e(boolean z10);

        void f();
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f0 f0Var = f0.f2343b;
        this.f700u = f0Var;
        this.f701v = f0Var;
        this.f702w = f0Var;
        this.f703x = f0Var;
        this.B = new a();
        this.C = new b();
        this.D = new c();
        v(context);
        this.E = new q(this);
    }

    private void A() {
        u();
        this.C.run();
    }

    private boolean B(float f10) {
        this.f705z.fling(0, 0, 0, (int) f10, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.f705z.getFinalY() > this.f683d.getHeight();
    }

    private void p() {
        u();
        this.D.run();
    }

    private boolean q(View view, Rect rect, boolean z10, boolean z11, boolean z12, boolean z13) {
        boolean z14;
        int i10;
        int i11;
        int i12;
        int i13;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!z10 || layoutParams.leftMargin == (i13 = rect.left)) {
            z14 = false;
        } else {
            layoutParams.leftMargin = i13;
            z14 = true;
        }
        if (z11 && layoutParams.topMargin != (i12 = rect.top)) {
            layoutParams.topMargin = i12;
            z14 = true;
        }
        if (z13 && layoutParams.rightMargin != (i11 = rect.right)) {
            layoutParams.rightMargin = i11;
            z14 = true;
        }
        if (!z12 || layoutParams.bottomMargin == (i10 = rect.bottom)) {
            return z14;
        }
        layoutParams.bottomMargin = i10;
        return true;
    }

    private p t(View view) {
        if (view instanceof p) {
            return (p) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    private void v(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(F);
        boolean z10 = false;
        this.f680a = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f685f = drawable;
        setWillNotDraw(drawable == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            z10 = true;
        }
        this.f686g = z10;
        this.f705z = new OverScroller(context);
    }

    private void x() {
        u();
        postDelayed(this.D, 600);
    }

    private void y() {
        u();
        postDelayed(this.C, 600);
    }

    public void a(Menu menu, j.a aVar) {
        z();
        this.f684e.a(menu, aVar);
    }

    public boolean b() {
        z();
        return this.f684e.b();
    }

    public void c(View view, View view2, int i10, int i11) {
        if (i11 == 0) {
            onNestedScrollAccepted(view, view2, i10);
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void d() {
        z();
        this.f684e.d();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f685f != null && !this.f686g) {
            int bottom = this.f683d.getVisibility() == 0 ? (int) (((float) this.f683d.getBottom()) + this.f683d.getTranslationY() + 0.5f) : 0;
            this.f685f.setBounds(0, bottom, getWidth(), this.f685f.getIntrinsicHeight() + bottom);
            this.f685f.draw(canvas);
        }
    }

    public boolean e() {
        z();
        return this.f684e.e();
    }

    public boolean f() {
        z();
        return this.f684e.f();
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        if (Build.VERSION.SDK_INT >= 21) {
            return super.fitSystemWindows(rect);
        }
        z();
        boolean q10 = q(this.f683d, rect, true, true, false, true);
        this.f696q.set(rect);
        m0.a(this, this.f696q, this.f693n);
        if (!this.f697r.equals(this.f696q)) {
            this.f697r.set(this.f696q);
            q10 = true;
        }
        if (!this.f694o.equals(this.f693n)) {
            this.f694o.set(this.f693n);
            q10 = true;
        }
        if (q10) {
            requestLayout();
        }
        return true;
    }

    public boolean g() {
        z();
        return this.f684e.g();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f683d;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    public int getNestedScrollAxes() {
        return this.E.a();
    }

    public CharSequence getTitle() {
        z();
        return this.f684e.getTitle();
    }

    public boolean h() {
        z();
        return this.f684e.h();
    }

    public void i(View view, int i10) {
        if (i10 == 0) {
            onStopNestedScroll(view);
        }
    }

    public void j(View view, int i10, int i11, int[] iArr, int i12) {
        if (i12 == 0) {
            onNestedPreScroll(view, i10, i11, iArr);
        }
    }

    public void k(int i10) {
        z();
        if (i10 == 2) {
            this.f684e.u();
        } else if (i10 == 5) {
            this.f684e.v();
        } else if (i10 == 109) {
            setOverlayMode(true);
        }
    }

    public void l() {
        z();
        this.f684e.i();
    }

    public void m(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        n(view, i10, i11, i12, i13, i14);
    }

    public void n(View view, int i10, int i11, int i12, int i13, int i14) {
        if (i14 == 0) {
            onNestedScroll(view, i10, i11, i12, i13);
        }
    }

    public boolean o(View view, View view2, int i10, int i11) {
        return i11 == 0 && onStartNestedScroll(view, view2, i10);
    }

    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        z();
        f0 y10 = f0.y(windowInsets, this);
        boolean q10 = q(this.f683d, new Rect(y10.k(), y10.m(), y10.l(), y10.j()), true, true, false, true);
        x.g(this, y10, this.f693n);
        Rect rect = this.f693n;
        f0 o10 = y10.o(rect.left, rect.top, rect.right, rect.bottom);
        this.f700u = o10;
        boolean z10 = true;
        if (!this.f701v.equals(o10)) {
            this.f701v = this.f700u;
            q10 = true;
        }
        if (!this.f694o.equals(this.f693n)) {
            this.f694o.set(this.f693n);
        } else {
            z10 = q10;
        }
        if (z10) {
            requestLayout();
        }
        return y10.a().c().b().w();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        v(getContext());
        x.o0(this);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i15 = layoutParams.leftMargin + paddingLeft;
                int i16 = layoutParams.topMargin + paddingTop;
                childAt.layout(i15, i16, measuredWidth + i15, measuredHeight + i16);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0105 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r13, int r14) {
        /*
            r12 = this;
            r12.z()
            androidx.appcompat.widget.ActionBarContainer r1 = r12.f683d
            r3 = 0
            r5 = 0
            r0 = r12
            r2 = r13
            r4 = r14
            r0.measureChildWithMargins(r1, r2, r3, r4, r5)
            androidx.appcompat.widget.ActionBarContainer r0 = r12.f683d
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            androidx.appcompat.widget.ActionBarOverlayLayout$LayoutParams r0 = (androidx.appcompat.widget.ActionBarOverlayLayout.LayoutParams) r0
            androidx.appcompat.widget.ActionBarContainer r1 = r12.f683d
            int r1 = r1.getMeasuredWidth()
            int r2 = r0.leftMargin
            int r1 = r1 + r2
            int r2 = r0.rightMargin
            int r1 = r1 + r2
            r2 = 0
            int r7 = java.lang.Math.max(r2, r1)
            androidx.appcompat.widget.ActionBarContainer r1 = r12.f683d
            int r1 = r1.getMeasuredHeight()
            int r3 = r0.topMargin
            int r1 = r1 + r3
            int r0 = r0.bottomMargin
            int r1 = r1 + r0
            int r8 = java.lang.Math.max(r2, r1)
            androidx.appcompat.widget.ActionBarContainer r0 = r12.f683d
            int r0 = r0.getMeasuredState()
            int r9 = android.view.View.combineMeasuredStates(r2, r0)
            int r0 = androidx.core.view.x.O(r12)
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x004a
            r0 = 1
            goto L_0x004b
        L_0x004a:
            r0 = r2
        L_0x004b:
            if (r0 == 0) goto L_0x005f
            int r1 = r12.f680a
            boolean r3 = r12.f688i
            if (r3 == 0) goto L_0x0071
            androidx.appcompat.widget.ActionBarContainer r3 = r12.f683d
            android.view.View r3 = r3.getTabContainer()
            if (r3 == 0) goto L_0x0071
            int r3 = r12.f680a
            int r1 = r1 + r3
            goto L_0x0071
        L_0x005f:
            androidx.appcompat.widget.ActionBarContainer r1 = r12.f683d
            int r1 = r1.getVisibility()
            r3 = 8
            if (r1 == r3) goto L_0x0070
            androidx.appcompat.widget.ActionBarContainer r1 = r12.f683d
            int r1 = r1.getMeasuredHeight()
            goto L_0x0071
        L_0x0070:
            r1 = r2
        L_0x0071:
            android.graphics.Rect r3 = r12.f695p
            android.graphics.Rect r4 = r12.f693n
            r3.set(r4)
            int r10 = android.os.Build.VERSION.SDK_INT
            r11 = 21
            if (r10 < r11) goto L_0x0083
            androidx.core.view.f0 r3 = r12.f700u
            r12.f702w = r3
            goto L_0x008a
        L_0x0083:
            android.graphics.Rect r3 = r12.f698s
            android.graphics.Rect r4 = r12.f696q
            r3.set(r4)
        L_0x008a:
            boolean r3 = r12.f687h
            if (r3 != 0) goto L_0x00a5
            if (r0 != 0) goto L_0x00a5
            android.graphics.Rect r0 = r12.f695p
            int r3 = r0.top
            int r3 = r3 + r1
            r0.top = r3
            int r3 = r0.bottom
            int r3 = r3 + r2
            r0.bottom = r3
            if (r10 < r11) goto L_0x00e3
            androidx.core.view.f0 r0 = r12.f702w
            androidx.core.view.f0 r0 = r0.o(r2, r1, r2, r2)
            goto L_0x00d4
        L_0x00a5:
            if (r10 < r11) goto L_0x00d7
            androidx.core.view.f0 r0 = r12.f702w
            int r0 = r0.k()
            androidx.core.view.f0 r3 = r12.f702w
            int r3 = r3.m()
            int r3 = r3 + r1
            androidx.core.view.f0 r1 = r12.f702w
            int r1 = r1.l()
            androidx.core.view.f0 r4 = r12.f702w
            int r4 = r4.j()
            int r4 = r4 + r2
            o0.b r0 = o0.b.b(r0, r3, r1, r4)
            androidx.core.view.f0$b r1 = new androidx.core.view.f0$b
            androidx.core.view.f0 r2 = r12.f702w
            r1.<init>(r2)
            androidx.core.view.f0$b r0 = r1.c(r0)
            androidx.core.view.f0 r0 = r0.a()
        L_0x00d4:
            r12.f702w = r0
            goto L_0x00e3
        L_0x00d7:
            android.graphics.Rect r0 = r12.f698s
            int r3 = r0.top
            int r3 = r3 + r1
            r0.top = r3
            int r1 = r0.bottom
            int r1 = r1 + r2
            r0.bottom = r1
        L_0x00e3:
            androidx.appcompat.widget.ContentFrameLayout r1 = r12.f682c
            android.graphics.Rect r2 = r12.f695p
            r3 = 1
            r4 = 1
            r5 = 1
            r6 = 1
            r0 = r12
            r0.q(r1, r2, r3, r4, r5, r6)
            if (r10 < r11) goto L_0x0105
            androidx.core.view.f0 r0 = r12.f703x
            androidx.core.view.f0 r1 = r12.f702w
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0105
            androidx.core.view.f0 r0 = r12.f702w
            r12.f703x = r0
            androidx.appcompat.widget.ContentFrameLayout r1 = r12.f682c
            androidx.core.view.x.h(r1, r0)
            goto L_0x011f
        L_0x0105:
            if (r10 >= r11) goto L_0x011f
            android.graphics.Rect r0 = r12.f699t
            android.graphics.Rect r1 = r12.f698s
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x011f
            android.graphics.Rect r0 = r12.f699t
            android.graphics.Rect r1 = r12.f698s
            r0.set(r1)
            androidx.appcompat.widget.ContentFrameLayout r0 = r12.f682c
            android.graphics.Rect r1 = r12.f698s
            r0.a(r1)
        L_0x011f:
            androidx.appcompat.widget.ContentFrameLayout r1 = r12.f682c
            r3 = 0
            r5 = 0
            r0 = r12
            r2 = r13
            r4 = r14
            r0.measureChildWithMargins(r1, r2, r3, r4, r5)
            androidx.appcompat.widget.ContentFrameLayout r0 = r12.f682c
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            androidx.appcompat.widget.ActionBarOverlayLayout$LayoutParams r0 = (androidx.appcompat.widget.ActionBarOverlayLayout.LayoutParams) r0
            androidx.appcompat.widget.ContentFrameLayout r1 = r12.f682c
            int r1 = r1.getMeasuredWidth()
            int r2 = r0.leftMargin
            int r1 = r1 + r2
            int r2 = r0.rightMargin
            int r1 = r1 + r2
            int r1 = java.lang.Math.max(r7, r1)
            androidx.appcompat.widget.ContentFrameLayout r2 = r12.f682c
            int r2 = r2.getMeasuredHeight()
            int r3 = r0.topMargin
            int r2 = r2 + r3
            int r0 = r0.bottomMargin
            int r2 = r2 + r0
            int r0 = java.lang.Math.max(r8, r2)
            androidx.appcompat.widget.ContentFrameLayout r2 = r12.f682c
            int r2 = r2.getMeasuredState()
            int r2 = android.view.View.combineMeasuredStates(r9, r2)
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r3 = r3 + r4
            int r1 = r1 + r3
            int r3 = r12.getPaddingTop()
            int r4 = r12.getPaddingBottom()
            int r3 = r3 + r4
            int r0 = r0 + r3
            int r3 = r12.getSuggestedMinimumHeight()
            int r0 = java.lang.Math.max(r0, r3)
            int r3 = r12.getSuggestedMinimumWidth()
            int r1 = java.lang.Math.max(r1, r3)
            int r1 = android.view.View.resolveSizeAndState(r1, r13, r2)
            int r2 = r2 << 16
            int r0 = android.view.View.resolveSizeAndState(r0, r14, r2)
            r12.setMeasuredDimension(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.onMeasure(int, int):void");
    }

    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        if (!this.f689j || !z10) {
            return false;
        }
        if (B(f11)) {
            p();
        } else {
            A();
        }
        this.f690k = true;
        return true;
    }

    public boolean onNestedPreFling(View view, float f10, float f11) {
        return false;
    }

    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
    }

    public void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        int i14 = this.f691l + i11;
        this.f691l = i14;
        setActionBarHideOffset(i14);
    }

    public void onNestedScrollAccepted(View view, View view2, int i10) {
        this.E.b(view, view2, i10);
        this.f691l = getActionBarHideOffset();
        u();
        d dVar = this.f704y;
        if (dVar != null) {
            dVar.b();
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i10) {
        if ((i10 & 2) == 0 || this.f683d.getVisibility() != 0) {
            return false;
        }
        return this.f689j;
    }

    public void onStopNestedScroll(View view) {
        if (this.f689j && !this.f690k) {
            if (this.f691l <= this.f683d.getHeight()) {
                y();
            } else {
                x();
            }
        }
        d dVar = this.f704y;
        if (dVar != null) {
            dVar.d();
        }
    }

    @Deprecated
    public void onWindowSystemUiVisibilityChanged(int i10) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i10);
        }
        z();
        int i11 = this.f692m ^ i10;
        this.f692m = i10;
        boolean z10 = false;
        boolean z11 = (i10 & 4) == 0;
        if ((i10 & Config.X_DENSITY) != 0) {
            z10 = true;
        }
        d dVar = this.f704y;
        if (dVar != null) {
            dVar.e(!z10);
            if (z11 || !z10) {
                this.f704y.a();
            } else {
                this.f704y.f();
            }
        }
        if ((i11 & Config.X_DENSITY) != 0 && this.f704y != null) {
            x.o0(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        this.f681b = i10;
        d dVar = this.f704y;
        if (dVar != null) {
            dVar.c(i10);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    /* renamed from: s */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void setActionBarHideOffset(int i10) {
        u();
        this.f683d.setTranslationY((float) (-Math.max(0, Math.min(i10, this.f683d.getHeight()))));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.f704y = dVar;
        if (getWindowToken() != null) {
            this.f704y.c(this.f681b);
            int i10 = this.f692m;
            if (i10 != 0) {
                onWindowSystemUiVisibilityChanged(i10);
                x.o0(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z10) {
        this.f688i = z10;
    }

    public void setHideOnContentScrollEnabled(boolean z10) {
        if (z10 != this.f689j) {
            this.f689j = z10;
            if (!z10) {
                u();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i10) {
        z();
        this.f684e.setIcon(i10);
    }

    public void setIcon(Drawable drawable) {
        z();
        this.f684e.setIcon(drawable);
    }

    public void setLogo(int i10) {
        z();
        this.f684e.r(i10);
    }

    public void setOverlayMode(boolean z10) {
        this.f687h = z10;
        this.f686g = z10 && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z10) {
    }

    public void setUiOptions(int i10) {
    }

    public void setWindowCallback(Window.Callback callback) {
        z();
        this.f684e.setWindowCallback(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        z();
        this.f684e.setWindowTitle(charSequence);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public void u() {
        removeCallbacks(this.C);
        removeCallbacks(this.D);
        ViewPropertyAnimator viewPropertyAnimator = this.A;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public boolean w() {
        return this.f687h;
    }

    /* access modifiers changed from: package-private */
    public void z() {
        if (this.f682c == null) {
            this.f682c = (ContentFrameLayout) findViewById(f.action_bar_activity_content);
            this.f683d = (ActionBarContainer) findViewById(f.action_bar_container);
            this.f684e = t(findViewById(f.action_bar));
        }
    }
}
