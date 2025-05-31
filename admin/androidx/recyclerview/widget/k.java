package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import androidx.core.view.x;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class k extends RecyclerView.o implements RecyclerView.q {
    private g A;
    private final RecyclerView.s B = new b();
    private Rect C;
    private long D;

    /* renamed from: a  reason: collision with root package name */
    final List<View> f3619a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final float[] f3620b = new float[2];

    /* renamed from: c  reason: collision with root package name */
    RecyclerView.c0 f3621c = null;

    /* renamed from: d  reason: collision with root package name */
    float f3622d;

    /* renamed from: e  reason: collision with root package name */
    float f3623e;

    /* renamed from: f  reason: collision with root package name */
    private float f3624f;

    /* renamed from: g  reason: collision with root package name */
    private float f3625g;

    /* renamed from: h  reason: collision with root package name */
    float f3626h;

    /* renamed from: i  reason: collision with root package name */
    float f3627i;

    /* renamed from: j  reason: collision with root package name */
    private float f3628j;

    /* renamed from: k  reason: collision with root package name */
    private float f3629k;

    /* renamed from: l  reason: collision with root package name */
    int f3630l = -1;

    /* renamed from: m  reason: collision with root package name */
    f f3631m;

    /* renamed from: n  reason: collision with root package name */
    private int f3632n = 0;

    /* renamed from: o  reason: collision with root package name */
    int f3633o;

    /* renamed from: p  reason: collision with root package name */
    List<h> f3634p = new ArrayList();

    /* renamed from: q  reason: collision with root package name */
    private int f3635q;

    /* renamed from: r  reason: collision with root package name */
    RecyclerView f3636r;

    /* renamed from: s  reason: collision with root package name */
    final Runnable f3637s = new a();

    /* renamed from: t  reason: collision with root package name */
    VelocityTracker f3638t;

    /* renamed from: u  reason: collision with root package name */
    private List<RecyclerView.c0> f3639u;

    /* renamed from: v  reason: collision with root package name */
    private List<Integer> f3640v;

    /* renamed from: w  reason: collision with root package name */
    private RecyclerView.k f3641w = null;

    /* renamed from: x  reason: collision with root package name */
    View f3642x = null;

    /* renamed from: y  reason: collision with root package name */
    int f3643y = -1;

    /* renamed from: z  reason: collision with root package name */
    androidx.core.view.e f3644z;

    class a implements Runnable {
        a() {
        }

        public void run() {
            k kVar = k.this;
            if (kVar.f3621c != null && kVar.E()) {
                k kVar2 = k.this;
                RecyclerView.c0 c0Var = kVar2.f3621c;
                if (c0Var != null) {
                    kVar2.z(c0Var);
                }
                k kVar3 = k.this;
                kVar3.f3636r.removeCallbacks(kVar3.f3637s);
                x.j0(k.this.f3636r, this);
            }
        }
    }

    class b implements RecyclerView.s {
        b() {
        }

        public boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
            int findPointerIndex;
            h s10;
            k.this.f3644z.a(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                k.this.f3630l = motionEvent.getPointerId(0);
                k.this.f3622d = motionEvent.getX();
                k.this.f3623e = motionEvent.getY();
                k.this.A();
                k kVar = k.this;
                if (kVar.f3621c == null && (s10 = kVar.s(motionEvent)) != null) {
                    k kVar2 = k.this;
                    kVar2.f3622d -= s10.f3664i;
                    kVar2.f3623e -= s10.f3665j;
                    kVar2.r(s10.f3660e, true);
                    if (k.this.f3619a.remove(s10.f3660e.itemView)) {
                        k kVar3 = k.this;
                        kVar3.f3631m.clearView(kVar3.f3636r, s10.f3660e);
                    }
                    k.this.F(s10.f3660e, s10.f3661f);
                    k kVar4 = k.this;
                    kVar4.K(motionEvent, kVar4.f3633o, 0);
                }
            } else if (actionMasked == 3 || actionMasked == 1) {
                k kVar5 = k.this;
                kVar5.f3630l = -1;
                kVar5.F((RecyclerView.c0) null, 0);
            } else {
                int i10 = k.this.f3630l;
                if (i10 != -1 && (findPointerIndex = motionEvent.findPointerIndex(i10)) >= 0) {
                    k.this.o(actionMasked, motionEvent, findPointerIndex);
                }
            }
            VelocityTracker velocityTracker = k.this.f3638t;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            return k.this.f3621c != null;
        }

        public void c(RecyclerView recyclerView, MotionEvent motionEvent) {
            k.this.f3644z.a(motionEvent);
            VelocityTracker velocityTracker = k.this.f3638t;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            if (k.this.f3630l != -1) {
                int actionMasked = motionEvent.getActionMasked();
                int findPointerIndex = motionEvent.findPointerIndex(k.this.f3630l);
                if (findPointerIndex >= 0) {
                    k.this.o(actionMasked, motionEvent, findPointerIndex);
                }
                k kVar = k.this;
                RecyclerView.c0 c0Var = kVar.f3621c;
                if (c0Var != null) {
                    int i10 = 0;
                    if (actionMasked != 1) {
                        if (actionMasked != 2) {
                            if (actionMasked == 3) {
                                VelocityTracker velocityTracker2 = kVar.f3638t;
                                if (velocityTracker2 != null) {
                                    velocityTracker2.clear();
                                }
                            } else if (actionMasked == 6) {
                                int actionIndex = motionEvent.getActionIndex();
                                int pointerId = motionEvent.getPointerId(actionIndex);
                                k kVar2 = k.this;
                                if (pointerId == kVar2.f3630l) {
                                    if (actionIndex == 0) {
                                        i10 = 1;
                                    }
                                    kVar2.f3630l = motionEvent.getPointerId(i10);
                                    k kVar3 = k.this;
                                    kVar3.K(motionEvent, kVar3.f3633o, actionIndex);
                                    return;
                                }
                                return;
                            } else {
                                return;
                            }
                        } else if (findPointerIndex >= 0) {
                            kVar.K(motionEvent, kVar.f3633o, findPointerIndex);
                            k.this.z(c0Var);
                            k kVar4 = k.this;
                            kVar4.f3636r.removeCallbacks(kVar4.f3637s);
                            k.this.f3637s.run();
                            k.this.f3636r.invalidate();
                            return;
                        } else {
                            return;
                        }
                    }
                    k.this.F((RecyclerView.c0) null, 0);
                    k.this.f3630l = -1;
                }
            }
        }

        public void e(boolean z10) {
            if (z10) {
                k.this.F((RecyclerView.c0) null, 0);
            }
        }
    }

    class c extends h {

        /* renamed from: n  reason: collision with root package name */
        final /* synthetic */ int f3647n;

        /* renamed from: o  reason: collision with root package name */
        final /* synthetic */ RecyclerView.c0 f3648o;

        /* renamed from: p  reason: collision with root package name */
        final /* synthetic */ k f3649p;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(k kVar, RecyclerView.c0 c0Var, int i10, int i11, float f10, float f11, float f12, float f13, int i12, RecyclerView.c0 c0Var2) {
            super(c0Var, i10, i11, f10, f11, f12, f13);
            this.f3649p = kVar;
            this.f3647n = i12;
            this.f3648o = c0Var2;
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (!this.f3666k) {
                if (this.f3647n <= 0) {
                    k kVar = this.f3649p;
                    kVar.f3631m.clearView(kVar.f3636r, this.f3648o);
                } else {
                    this.f3649p.f3619a.add(this.f3648o.itemView);
                    this.f3663h = true;
                    int i10 = this.f3647n;
                    if (i10 > 0) {
                        this.f3649p.B(this, i10);
                    }
                }
                k kVar2 = this.f3649p;
                View view = kVar2.f3642x;
                View view2 = this.f3648o.itemView;
                if (view == view2) {
                    kVar2.D(view2);
                }
            }
        }
    }

    class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f3650a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f3651b;

        d(h hVar, int i10) {
            this.f3650a = hVar;
            this.f3651b = i10;
        }

        public void run() {
            RecyclerView recyclerView = k.this.f3636r;
            if (recyclerView != null && recyclerView.isAttachedToWindow()) {
                h hVar = this.f3650a;
                if (!hVar.f3666k && hVar.f3660e.getAbsoluteAdapterPosition() != -1) {
                    RecyclerView.m itemAnimator = k.this.f3636r.getItemAnimator();
                    if ((itemAnimator == null || !itemAnimator.isRunning((RecyclerView.m.a) null)) && !k.this.x()) {
                        k.this.f3631m.onSwiped(this.f3650a.f3660e, this.f3651b);
                    } else {
                        k.this.f3636r.post(this);
                    }
                }
            }
        }
    }

    class e implements RecyclerView.k {
        e() {
        }

        public int a(int i10, int i11) {
            k kVar = k.this;
            View view = kVar.f3642x;
            if (view == null) {
                return i11;
            }
            int i12 = kVar.f3643y;
            if (i12 == -1) {
                i12 = kVar.f3636r.indexOfChild(view);
                k.this.f3643y = i12;
            }
            return i11 == i10 + -1 ? i12 : i11 < i12 ? i11 : i11 + 1;
        }
    }

    public static abstract class f {
        private static final int ABS_HORIZONTAL_DIR_FLAGS = 789516;
        public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
        public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;
        private static final long DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS = 2000;
        static final int RELATIVE_DIR_FLAGS = 3158064;
        private static final Interpolator sDragScrollInterpolator = new a();
        private static final Interpolator sDragViewScrollCapInterpolator = new b();
        private int mCachedMaxScrollSpeed = -1;

        class a implements Interpolator {
            a() {
            }

            public float getInterpolation(float f10) {
                return f10 * f10 * f10 * f10 * f10;
            }
        }

        class b implements Interpolator {
            b() {
            }

            public float getInterpolation(float f10) {
                float f11 = f10 - 1.0f;
                return (f11 * f11 * f11 * f11 * f11) + 1.0f;
            }
        }

        public static int convertToRelativeDirection(int i10, int i11) {
            int i12;
            int i13 = i10 & ABS_HORIZONTAL_DIR_FLAGS;
            if (i13 == 0) {
                return i10;
            }
            int i14 = i10 & (~i13);
            if (i11 == 0) {
                i12 = i13 << 2;
            } else {
                int i15 = i13 << 1;
                i14 |= -789517 & i15;
                i12 = (i15 & ABS_HORIZONTAL_DIR_FLAGS) << 2;
            }
            return i14 | i12;
        }

        public static l getDefaultUIUtil() {
            return m.f3670a;
        }

        private int getMaxDragScroll(RecyclerView recyclerView) {
            if (this.mCachedMaxScrollSpeed == -1) {
                this.mCachedMaxScrollSpeed = recyclerView.getResources().getDimensionPixelSize(p1.b.item_touch_helper_max_drag_scroll_per_frame);
            }
            return this.mCachedMaxScrollSpeed;
        }

        public static int makeFlag(int i10, int i11) {
            return i11 << (i10 * 8);
        }

        public static int makeMovementFlags(int i10, int i11) {
            int makeFlag = makeFlag(0, i11 | i10);
            return makeFlag(2, i10) | makeFlag(1, i11) | makeFlag;
        }

        public boolean canDropOver(RecyclerView recyclerView, RecyclerView.c0 c0Var, RecyclerView.c0 c0Var2) {
            return true;
        }

        public RecyclerView.c0 chooseDropTarget(RecyclerView.c0 c0Var, List<RecyclerView.c0> list, int i10, int i11) {
            int bottom;
            int abs;
            int top;
            int abs2;
            int left;
            int abs3;
            int right;
            int abs4;
            RecyclerView.c0 c0Var2 = c0Var;
            int width = i10 + c0Var2.itemView.getWidth();
            int height = i11 + c0Var2.itemView.getHeight();
            int left2 = i10 - c0Var2.itemView.getLeft();
            int top2 = i11 - c0Var2.itemView.getTop();
            int size = list.size();
            RecyclerView.c0 c0Var3 = null;
            int i12 = -1;
            for (int i13 = 0; i13 < size; i13++) {
                RecyclerView.c0 c0Var4 = list.get(i13);
                if (left2 > 0 && (right = c0Var4.itemView.getRight() - width) < 0 && c0Var4.itemView.getRight() > c0Var2.itemView.getRight() && (abs4 = Math.abs(right)) > i12) {
                    c0Var3 = c0Var4;
                    i12 = abs4;
                }
                if (left2 < 0 && (left = c0Var4.itemView.getLeft() - i10) > 0 && c0Var4.itemView.getLeft() < c0Var2.itemView.getLeft() && (abs3 = Math.abs(left)) > i12) {
                    c0Var3 = c0Var4;
                    i12 = abs3;
                }
                if (top2 < 0 && (top = c0Var4.itemView.getTop() - i11) > 0 && c0Var4.itemView.getTop() < c0Var2.itemView.getTop() && (abs2 = Math.abs(top)) > i12) {
                    c0Var3 = c0Var4;
                    i12 = abs2;
                }
                if (top2 > 0 && (bottom = c0Var4.itemView.getBottom() - height) < 0 && c0Var4.itemView.getBottom() > c0Var2.itemView.getBottom() && (abs = Math.abs(bottom)) > i12) {
                    c0Var3 = c0Var4;
                    i12 = abs;
                }
            }
            return c0Var3;
        }

        public void clearView(RecyclerView recyclerView, RecyclerView.c0 c0Var) {
            m.f3670a.a(c0Var.itemView);
        }

        public int convertToAbsoluteDirection(int i10, int i11) {
            int i12;
            int i13 = i10 & RELATIVE_DIR_FLAGS;
            if (i13 == 0) {
                return i10;
            }
            int i14 = i10 & (~i13);
            if (i11 == 0) {
                i12 = i13 >> 2;
            } else {
                int i15 = i13 >> 1;
                i14 |= -3158065 & i15;
                i12 = (i15 & RELATIVE_DIR_FLAGS) >> 2;
            }
            return i14 | i12;
        }

        /* access modifiers changed from: package-private */
        public final int getAbsoluteMovementFlags(RecyclerView recyclerView, RecyclerView.c0 c0Var) {
            return convertToAbsoluteDirection(getMovementFlags(recyclerView, c0Var), x.C(recyclerView));
        }

        public long getAnimationDuration(RecyclerView recyclerView, int i10, float f10, float f11) {
            RecyclerView.m itemAnimator = recyclerView.getItemAnimator();
            return itemAnimator == null ? i10 == 8 ? 200 : 250 : i10 == 8 ? itemAnimator.getMoveDuration() : itemAnimator.getRemoveDuration();
        }

        public int getBoundingBoxMargin() {
            return 0;
        }

        public float getMoveThreshold(RecyclerView.c0 c0Var) {
            return 0.5f;
        }

        public abstract int getMovementFlags(RecyclerView recyclerView, RecyclerView.c0 c0Var);

        public float getSwipeEscapeVelocity(float f10) {
            return f10;
        }

        public float getSwipeThreshold(RecyclerView.c0 c0Var) {
            return 0.5f;
        }

        public float getSwipeVelocityThreshold(float f10) {
            return f10;
        }

        /* access modifiers changed from: package-private */
        public boolean hasDragFlag(RecyclerView recyclerView, RecyclerView.c0 c0Var) {
            return (getAbsoluteMovementFlags(recyclerView, c0Var) & 16711680) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean hasSwipeFlag(RecyclerView recyclerView, RecyclerView.c0 c0Var) {
            return (getAbsoluteMovementFlags(recyclerView, c0Var) & 65280) != 0;
        }

        public int interpolateOutOfBoundsScroll(RecyclerView recyclerView, int i10, int i11, int i12, long j10) {
            float f10 = 1.0f;
            int signum = (int) (((float) (((int) Math.signum((float) i11)) * getMaxDragScroll(recyclerView))) * sDragViewScrollCapInterpolator.getInterpolation(Math.min(1.0f, (((float) Math.abs(i11)) * 1.0f) / ((float) i10))));
            if (j10 <= DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS) {
                f10 = ((float) j10) / 2000.0f;
            }
            int interpolation = (int) (((float) signum) * sDragScrollInterpolator.getInterpolation(f10));
            return interpolation == 0 ? i11 > 0 ? 1 : -1 : interpolation;
        }

        public boolean isItemViewSwipeEnabled() {
            return true;
        }

        public boolean isLongPressDragEnabled() {
            return true;
        }

        public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.c0 c0Var, float f10, float f11, int i10, boolean z10) {
            m.f3670a.d(canvas, recyclerView, c0Var.itemView, f10, f11, i10, z10);
        }

        public void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.c0 c0Var, float f10, float f11, int i10, boolean z10) {
            m.f3670a.c(canvas, recyclerView, c0Var.itemView, f10, f11, i10, z10);
        }

        /* access modifiers changed from: package-private */
        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.c0 c0Var, List<h> list, int i10, float f10, float f11) {
            Canvas canvas2 = canvas;
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                h hVar = list.get(i11);
                hVar.e();
                int save = canvas.save();
                onChildDraw(canvas, recyclerView, hVar.f3660e, hVar.f3664i, hVar.f3665j, hVar.f3661f, false);
                canvas.restoreToCount(save);
            }
            if (c0Var != null) {
                int save2 = canvas.save();
                onChildDraw(canvas, recyclerView, c0Var, f10, f11, i10, true);
                canvas.restoreToCount(save2);
            }
        }

        /* access modifiers changed from: package-private */
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.c0 c0Var, List<h> list, int i10, float f10, float f11) {
            Canvas canvas2 = canvas;
            List<h> list2 = list;
            int size = list.size();
            boolean z10 = false;
            for (int i11 = 0; i11 < size; i11++) {
                h hVar = list2.get(i11);
                int save = canvas.save();
                onChildDrawOver(canvas, recyclerView, hVar.f3660e, hVar.f3664i, hVar.f3665j, hVar.f3661f, false);
                canvas.restoreToCount(save);
            }
            if (c0Var != null) {
                int save2 = canvas.save();
                onChildDrawOver(canvas, recyclerView, c0Var, f10, f11, i10, true);
                canvas.restoreToCount(save2);
            }
            for (int i12 = size - 1; i12 >= 0; i12--) {
                h hVar2 = list2.get(i12);
                boolean z11 = hVar2.f3667l;
                if (z11 && !hVar2.f3663h) {
                    list2.remove(i12);
                } else if (!z11) {
                    z10 = true;
                }
            }
            if (z10) {
                recyclerView.invalidate();
            }
        }

        public abstract boolean onMove(RecyclerView recyclerView, RecyclerView.c0 c0Var, RecyclerView.c0 c0Var2);

        public void onMoved(RecyclerView recyclerView, RecyclerView.c0 c0Var, int i10, RecyclerView.c0 c0Var2, int i11, int i12, int i13) {
            RecyclerView.p layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof j) {
                ((j) layoutManager).k(c0Var.itemView, c0Var2.itemView, i12, i13);
                return;
            }
            if (layoutManager.w()) {
                if (layoutManager.e0(c0Var2.itemView) <= recyclerView.getPaddingLeft()) {
                    recyclerView.k1(i11);
                }
                if (layoutManager.h0(c0Var2.itemView) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.k1(i11);
                }
            }
            if (layoutManager.x()) {
                if (layoutManager.i0(c0Var2.itemView) <= recyclerView.getPaddingTop()) {
                    recyclerView.k1(i11);
                }
                if (layoutManager.c0(c0Var2.itemView) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.k1(i11);
                }
            }
        }

        public void onSelectedChanged(RecyclerView.c0 c0Var, int i10) {
            if (c0Var != null) {
                m.f3670a.b(c0Var.itemView);
            }
        }

        public abstract void onSwiped(RecyclerView.c0 c0Var, int i10);
    }

    private class g extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: a  reason: collision with root package name */
        private boolean f3654a = true;

        g() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f3654a = false;
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public void onLongPress(MotionEvent motionEvent) {
            View t10;
            RecyclerView.c0 g02;
            int i10;
            if (this.f3654a && (t10 = k.this.t(motionEvent)) != null && (g02 = k.this.f3636r.g0(t10)) != null) {
                k kVar = k.this;
                if (kVar.f3631m.hasDragFlag(kVar.f3636r, g02) && motionEvent.getPointerId(0) == (i10 = k.this.f3630l)) {
                    int findPointerIndex = motionEvent.findPointerIndex(i10);
                    float x10 = motionEvent.getX(findPointerIndex);
                    float y10 = motionEvent.getY(findPointerIndex);
                    k kVar2 = k.this;
                    kVar2.f3622d = x10;
                    kVar2.f3623e = y10;
                    kVar2.f3627i = 0.0f;
                    kVar2.f3626h = 0.0f;
                    if (kVar2.f3631m.isLongPressDragEnabled()) {
                        k.this.F(g02, 2);
                    }
                }
            }
        }
    }

    static class h implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        final float f3656a;

        /* renamed from: b  reason: collision with root package name */
        final float f3657b;

        /* renamed from: c  reason: collision with root package name */
        final float f3658c;

        /* renamed from: d  reason: collision with root package name */
        final float f3659d;

        /* renamed from: e  reason: collision with root package name */
        final RecyclerView.c0 f3660e;

        /* renamed from: f  reason: collision with root package name */
        final int f3661f;

        /* renamed from: g  reason: collision with root package name */
        final ValueAnimator f3662g;

        /* renamed from: h  reason: collision with root package name */
        boolean f3663h;

        /* renamed from: i  reason: collision with root package name */
        float f3664i;

        /* renamed from: j  reason: collision with root package name */
        float f3665j;

        /* renamed from: k  reason: collision with root package name */
        boolean f3666k = false;

        /* renamed from: l  reason: collision with root package name */
        boolean f3667l = false;

        /* renamed from: m  reason: collision with root package name */
        private float f3668m;

        class a implements ValueAnimator.AnimatorUpdateListener {
            a() {
            }

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                h.this.c(valueAnimator.getAnimatedFraction());
            }
        }

        h(RecyclerView.c0 c0Var, int i10, int i11, float f10, float f11, float f12, float f13) {
            this.f3661f = i11;
            this.f3660e = c0Var;
            this.f3656a = f10;
            this.f3657b = f11;
            this.f3658c = f12;
            this.f3659d = f13;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.f3662g = ofFloat;
            ofFloat.addUpdateListener(new a());
            ofFloat.setTarget(c0Var.itemView);
            ofFloat.addListener(this);
            c(0.0f);
        }

        public void a() {
            this.f3662g.cancel();
        }

        public void b(long j10) {
            this.f3662g.setDuration(j10);
        }

        public void c(float f10) {
            this.f3668m = f10;
        }

        public void d() {
            this.f3660e.setIsRecyclable(false);
            this.f3662g.start();
        }

        public void e() {
            float f10 = this.f3656a;
            float f11 = this.f3658c;
            this.f3664i = f10 == f11 ? this.f3660e.itemView.getTranslationX() : f10 + (this.f3668m * (f11 - f10));
            float f12 = this.f3657b;
            float f13 = this.f3659d;
            this.f3665j = f12 == f13 ? this.f3660e.itemView.getTranslationY() : f12 + (this.f3668m * (f13 - f12));
        }

        public void onAnimationCancel(Animator animator) {
            c(1.0f);
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f3667l) {
                this.f3660e.setIsRecyclable(true);
            }
            this.f3667l = true;
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public static abstract class i extends f {
        private int mDefaultDragDirs;
        private int mDefaultSwipeDirs;

        public i(int i10, int i11) {
            this.mDefaultSwipeDirs = i11;
            this.mDefaultDragDirs = i10;
        }

        public int getDragDirs(RecyclerView recyclerView, RecyclerView.c0 c0Var) {
            return this.mDefaultDragDirs;
        }

        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.c0 c0Var) {
            return f.makeMovementFlags(getDragDirs(recyclerView, c0Var), getSwipeDirs(recyclerView, c0Var));
        }

        public int getSwipeDirs(RecyclerView recyclerView, RecyclerView.c0 c0Var) {
            return this.mDefaultSwipeDirs;
        }

        public void setDefaultDragDirs(int i10) {
            this.mDefaultDragDirs = i10;
        }

        public void setDefaultSwipeDirs(int i10) {
            this.mDefaultSwipeDirs = i10;
        }
    }

    public interface j {
        void k(View view, View view2, int i10, int i11);
    }

    public k(f fVar) {
        this.f3631m = fVar;
    }

    private void C() {
        VelocityTracker velocityTracker = this.f3638t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f3638t = null;
        }
    }

    private void G() {
        this.f3635q = ViewConfiguration.get(this.f3636r.getContext()).getScaledTouchSlop();
        this.f3636r.h(this);
        this.f3636r.k(this.B);
        this.f3636r.j(this);
        H();
    }

    private void H() {
        this.A = new g();
        this.f3644z = new androidx.core.view.e(this.f3636r.getContext(), this.A);
    }

    private void I() {
        g gVar = this.A;
        if (gVar != null) {
            gVar.a();
            this.A = null;
        }
        if (this.f3644z != null) {
            this.f3644z = null;
        }
    }

    private int J(RecyclerView.c0 c0Var) {
        if (this.f3632n == 2) {
            return 0;
        }
        int movementFlags = this.f3631m.getMovementFlags(this.f3636r, c0Var);
        int convertToAbsoluteDirection = (this.f3631m.convertToAbsoluteDirection(movementFlags, x.C(this.f3636r)) & 65280) >> 8;
        if (convertToAbsoluteDirection == 0) {
            return 0;
        }
        int i10 = (movementFlags & 65280) >> 8;
        if (Math.abs(this.f3626h) > Math.abs(this.f3627i)) {
            int n10 = n(c0Var, convertToAbsoluteDirection);
            if (n10 > 0) {
                return (i10 & n10) == 0 ? f.convertToRelativeDirection(n10, x.C(this.f3636r)) : n10;
            }
            int p10 = p(c0Var, convertToAbsoluteDirection);
            if (p10 > 0) {
                return p10;
            }
        } else {
            int p11 = p(c0Var, convertToAbsoluteDirection);
            if (p11 > 0) {
                return p11;
            }
            int n11 = n(c0Var, convertToAbsoluteDirection);
            if (n11 > 0) {
                return (i10 & n11) == 0 ? f.convertToRelativeDirection(n11, x.C(this.f3636r)) : n11;
            }
        }
        return 0;
    }

    private void l() {
        if (Build.VERSION.SDK_INT < 21) {
            if (this.f3641w == null) {
                this.f3641w = new e();
            }
            this.f3636r.setChildDrawingOrderCallback(this.f3641w);
        }
    }

    private int n(RecyclerView.c0 c0Var, int i10) {
        if ((i10 & 12) == 0) {
            return 0;
        }
        int i11 = 8;
        int i12 = this.f3626h > 0.0f ? 8 : 4;
        VelocityTracker velocityTracker = this.f3638t;
        if (velocityTracker != null && this.f3630l > -1) {
            velocityTracker.computeCurrentVelocity(com.android.volley.toolbox.k.DEFAULT_IMAGE_TIMEOUT_MS, this.f3631m.getSwipeVelocityThreshold(this.f3625g));
            float xVelocity = this.f3638t.getXVelocity(this.f3630l);
            float yVelocity = this.f3638t.getYVelocity(this.f3630l);
            if (xVelocity <= 0.0f) {
                i11 = 4;
            }
            float abs = Math.abs(xVelocity);
            if ((i11 & i10) != 0 && i12 == i11 && abs >= this.f3631m.getSwipeEscapeVelocity(this.f3624f) && abs > Math.abs(yVelocity)) {
                return i11;
            }
        }
        float width = ((float) this.f3636r.getWidth()) * this.f3631m.getSwipeThreshold(c0Var);
        if ((i10 & i12) == 0 || Math.abs(this.f3626h) <= width) {
            return 0;
        }
        return i12;
    }

    private int p(RecyclerView.c0 c0Var, int i10) {
        if ((i10 & 3) == 0) {
            return 0;
        }
        int i11 = 2;
        int i12 = this.f3627i > 0.0f ? 2 : 1;
        VelocityTracker velocityTracker = this.f3638t;
        if (velocityTracker != null && this.f3630l > -1) {
            velocityTracker.computeCurrentVelocity(com.android.volley.toolbox.k.DEFAULT_IMAGE_TIMEOUT_MS, this.f3631m.getSwipeVelocityThreshold(this.f3625g));
            float xVelocity = this.f3638t.getXVelocity(this.f3630l);
            float yVelocity = this.f3638t.getYVelocity(this.f3630l);
            if (yVelocity <= 0.0f) {
                i11 = 1;
            }
            float abs = Math.abs(yVelocity);
            if ((i11 & i10) != 0 && i11 == i12 && abs >= this.f3631m.getSwipeEscapeVelocity(this.f3624f) && abs > Math.abs(xVelocity)) {
                return i11;
            }
        }
        float height = ((float) this.f3636r.getHeight()) * this.f3631m.getSwipeThreshold(c0Var);
        if ((i10 & i12) == 0 || Math.abs(this.f3627i) <= height) {
            return 0;
        }
        return i12;
    }

    private void q() {
        this.f3636r.Y0(this);
        this.f3636r.a1(this.B);
        this.f3636r.Z0(this);
        for (int size = this.f3634p.size() - 1; size >= 0; size--) {
            h hVar = this.f3634p.get(0);
            hVar.a();
            this.f3631m.clearView(this.f3636r, hVar.f3660e);
        }
        this.f3634p.clear();
        this.f3642x = null;
        this.f3643y = -1;
        C();
        I();
    }

    private List<RecyclerView.c0> u(RecyclerView.c0 c0Var) {
        RecyclerView.c0 c0Var2 = c0Var;
        List<RecyclerView.c0> list = this.f3639u;
        if (list == null) {
            this.f3639u = new ArrayList();
            this.f3640v = new ArrayList();
        } else {
            list.clear();
            this.f3640v.clear();
        }
        int boundingBoxMargin = this.f3631m.getBoundingBoxMargin();
        int round = Math.round(this.f3628j + this.f3626h) - boundingBoxMargin;
        int round2 = Math.round(this.f3629k + this.f3627i) - boundingBoxMargin;
        int i10 = boundingBoxMargin * 2;
        int width = c0Var2.itemView.getWidth() + round + i10;
        int height = c0Var2.itemView.getHeight() + round2 + i10;
        int i11 = (round + width) / 2;
        int i12 = (round2 + height) / 2;
        RecyclerView.p layoutManager = this.f3636r.getLayoutManager();
        int X = layoutManager.X();
        int i13 = 0;
        while (i13 < X) {
            View W = layoutManager.W(i13);
            if (W != c0Var2.itemView && W.getBottom() >= round2 && W.getTop() <= height && W.getRight() >= round && W.getLeft() <= width) {
                RecyclerView.c0 g02 = this.f3636r.g0(W);
                if (this.f3631m.canDropOver(this.f3636r, this.f3621c, g02)) {
                    int abs = Math.abs(i11 - ((W.getLeft() + W.getRight()) / 2));
                    int abs2 = Math.abs(i12 - ((W.getTop() + W.getBottom()) / 2));
                    int i14 = (abs * abs) + (abs2 * abs2);
                    int size = this.f3639u.size();
                    int i15 = 0;
                    int i16 = 0;
                    while (i15 < size && i14 > this.f3640v.get(i15).intValue()) {
                        i16++;
                        i15++;
                        RecyclerView.c0 c0Var3 = c0Var;
                    }
                    this.f3639u.add(i16, g02);
                    this.f3640v.add(i16, Integer.valueOf(i14));
                }
            }
            i13++;
            c0Var2 = c0Var;
        }
        return this.f3639u;
    }

    private RecyclerView.c0 v(MotionEvent motionEvent) {
        View t10;
        RecyclerView.p layoutManager = this.f3636r.getLayoutManager();
        int i10 = this.f3630l;
        if (i10 == -1) {
            return null;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i10);
        float abs = Math.abs(motionEvent.getX(findPointerIndex) - this.f3622d);
        float abs2 = Math.abs(motionEvent.getY(findPointerIndex) - this.f3623e);
        int i11 = this.f3635q;
        if (abs < ((float) i11) && abs2 < ((float) i11)) {
            return null;
        }
        if (abs > abs2 && layoutManager.w()) {
            return null;
        }
        if ((abs2 <= abs || !layoutManager.x()) && (t10 = t(motionEvent)) != null) {
            return this.f3636r.g0(t10);
        }
        return null;
    }

    private void w(float[] fArr) {
        if ((this.f3633o & 12) != 0) {
            fArr[0] = (this.f3628j + this.f3626h) - ((float) this.f3621c.itemView.getLeft());
        } else {
            fArr[0] = this.f3621c.itemView.getTranslationX();
        }
        if ((this.f3633o & 3) != 0) {
            fArr[1] = (this.f3629k + this.f3627i) - ((float) this.f3621c.itemView.getTop());
        } else {
            fArr[1] = this.f3621c.itemView.getTranslationY();
        }
    }

    private static boolean y(View view, float f10, float f11, float f12, float f13) {
        return f10 >= f12 && f10 <= f12 + ((float) view.getWidth()) && f11 >= f13 && f11 <= f13 + ((float) view.getHeight());
    }

    /* access modifiers changed from: package-private */
    public void A() {
        VelocityTracker velocityTracker = this.f3638t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.f3638t = VelocityTracker.obtain();
    }

    /* access modifiers changed from: package-private */
    public void B(h hVar, int i10) {
        this.f3636r.post(new d(hVar, i10));
    }

    /* access modifiers changed from: package-private */
    public void D(View view) {
        if (view == this.f3642x) {
            this.f3642x = null;
            if (this.f3641w != null) {
                this.f3636r.setChildDrawingOrderCallback((RecyclerView.k) null);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c1, code lost:
        if (r1 > 0) goto L_0x00c5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0100 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x010c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean E() {
        /*
            r16 = this;
            r0 = r16
            androidx.recyclerview.widget.RecyclerView$c0 r1 = r0.f3621c
            r2 = 0
            r3 = -9223372036854775808
            if (r1 != 0) goto L_0x000c
            r0.D = r3
            return r2
        L_0x000c:
            long r5 = java.lang.System.currentTimeMillis()
            long r7 = r0.D
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x0019
            r7 = 0
            goto L_0x001b
        L_0x0019:
            long r7 = r5 - r7
        L_0x001b:
            androidx.recyclerview.widget.RecyclerView r1 = r0.f3636r
            androidx.recyclerview.widget.RecyclerView$p r1 = r1.getLayoutManager()
            android.graphics.Rect r9 = r0.C
            if (r9 != 0) goto L_0x002c
            android.graphics.Rect r9 = new android.graphics.Rect
            r9.<init>()
            r0.C = r9
        L_0x002c:
            androidx.recyclerview.widget.RecyclerView$c0 r9 = r0.f3621c
            android.view.View r9 = r9.itemView
            android.graphics.Rect r10 = r0.C
            r1.v(r9, r10)
            boolean r9 = r1.w()
            r10 = 0
            if (r9 == 0) goto L_0x007d
            float r9 = r0.f3628j
            float r11 = r0.f3626h
            float r9 = r9 + r11
            int r9 = (int) r9
            android.graphics.Rect r11 = r0.C
            int r11 = r11.left
            int r11 = r9 - r11
            androidx.recyclerview.widget.RecyclerView r12 = r0.f3636r
            int r12 = r12.getPaddingLeft()
            int r11 = r11 - r12
            float r12 = r0.f3626h
            int r13 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r13 >= 0) goto L_0x0059
            if (r11 >= 0) goto L_0x0059
            r12 = r11
            goto L_0x007e
        L_0x0059:
            int r11 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r11 <= 0) goto L_0x007d
            androidx.recyclerview.widget.RecyclerView$c0 r11 = r0.f3621c
            android.view.View r11 = r11.itemView
            int r11 = r11.getWidth()
            int r9 = r9 + r11
            android.graphics.Rect r11 = r0.C
            int r11 = r11.right
            int r9 = r9 + r11
            androidx.recyclerview.widget.RecyclerView r11 = r0.f3636r
            int r11 = r11.getWidth()
            androidx.recyclerview.widget.RecyclerView r12 = r0.f3636r
            int r12 = r12.getPaddingRight()
            int r11 = r11 - r12
            int r9 = r9 - r11
            if (r9 <= 0) goto L_0x007d
            r12 = r9
            goto L_0x007e
        L_0x007d:
            r12 = r2
        L_0x007e:
            boolean r1 = r1.x()
            if (r1 == 0) goto L_0x00c4
            float r1 = r0.f3629k
            float r9 = r0.f3627i
            float r1 = r1 + r9
            int r1 = (int) r1
            android.graphics.Rect r9 = r0.C
            int r9 = r9.top
            int r9 = r1 - r9
            androidx.recyclerview.widget.RecyclerView r11 = r0.f3636r
            int r11 = r11.getPaddingTop()
            int r9 = r9 - r11
            float r11 = r0.f3627i
            int r13 = (r11 > r10 ? 1 : (r11 == r10 ? 0 : -1))
            if (r13 >= 0) goto L_0x00a1
            if (r9 >= 0) goto L_0x00a1
            r1 = r9
            goto L_0x00c5
        L_0x00a1:
            int r9 = (r11 > r10 ? 1 : (r11 == r10 ? 0 : -1))
            if (r9 <= 0) goto L_0x00c4
            androidx.recyclerview.widget.RecyclerView$c0 r9 = r0.f3621c
            android.view.View r9 = r9.itemView
            int r9 = r9.getHeight()
            int r1 = r1 + r9
            android.graphics.Rect r9 = r0.C
            int r9 = r9.bottom
            int r1 = r1 + r9
            androidx.recyclerview.widget.RecyclerView r9 = r0.f3636r
            int r9 = r9.getHeight()
            androidx.recyclerview.widget.RecyclerView r10 = r0.f3636r
            int r10 = r10.getPaddingBottom()
            int r9 = r9 - r10
            int r1 = r1 - r9
            if (r1 <= 0) goto L_0x00c4
            goto L_0x00c5
        L_0x00c4:
            r1 = r2
        L_0x00c5:
            if (r12 == 0) goto L_0x00de
            androidx.recyclerview.widget.k$f r9 = r0.f3631m
            androidx.recyclerview.widget.RecyclerView r10 = r0.f3636r
            androidx.recyclerview.widget.RecyclerView$c0 r11 = r0.f3621c
            android.view.View r11 = r11.itemView
            int r11 = r11.getWidth()
            androidx.recyclerview.widget.RecyclerView r13 = r0.f3636r
            int r13 = r13.getWidth()
            r14 = r7
            int r12 = r9.interpolateOutOfBoundsScroll(r10, r11, r12, r13, r14)
        L_0x00de:
            r14 = r12
            if (r1 == 0) goto L_0x00fd
            androidx.recyclerview.widget.k$f r9 = r0.f3631m
            androidx.recyclerview.widget.RecyclerView r10 = r0.f3636r
            androidx.recyclerview.widget.RecyclerView$c0 r11 = r0.f3621c
            android.view.View r11 = r11.itemView
            int r11 = r11.getHeight()
            androidx.recyclerview.widget.RecyclerView r12 = r0.f3636r
            int r13 = r12.getHeight()
            r12 = r1
            r1 = r14
            r14 = r7
            int r7 = r9.interpolateOutOfBoundsScroll(r10, r11, r12, r13, r14)
            r12 = r1
            r1 = r7
            goto L_0x00fe
        L_0x00fd:
            r12 = r14
        L_0x00fe:
            if (r12 != 0) goto L_0x0106
            if (r1 == 0) goto L_0x0103
            goto L_0x0106
        L_0x0103:
            r0.D = r3
            return r2
        L_0x0106:
            long r7 = r0.D
            int r2 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r2 != 0) goto L_0x010e
            r0.D = r5
        L_0x010e:
            androidx.recyclerview.widget.RecyclerView r2 = r0.f3636r
            r2.scrollBy(r12, r1)
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.k.E():boolean");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0136  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void F(androidx.recyclerview.widget.RecyclerView.c0 r24, int r25) {
        /*
            r23 = this;
            r11 = r23
            r12 = r24
            r13 = r25
            androidx.recyclerview.widget.RecyclerView$c0 r0 = r11.f3621c
            if (r12 != r0) goto L_0x000f
            int r0 = r11.f3632n
            if (r13 != r0) goto L_0x000f
            return
        L_0x000f:
            r0 = -9223372036854775808
            r11.D = r0
            int r4 = r11.f3632n
            r14 = 1
            r11.r(r12, r14)
            r11.f3632n = r13
            r15 = 2
            if (r13 != r15) goto L_0x0030
            if (r12 == 0) goto L_0x0028
            android.view.View r0 = r12.itemView
            r11.f3642x = r0
            r23.l()
            goto L_0x0030
        L_0x0028:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Must pass a ViewHolder when dragging"
            r0.<init>(r1)
            throw r0
        L_0x0030:
            int r0 = r13 * 8
            r10 = 8
            int r0 = r0 + r10
            int r0 = r14 << r0
            int r16 = r0 + -1
            androidx.recyclerview.widget.RecyclerView$c0 r9 = r11.f3621c
            r8 = 0
            if (r9 == 0) goto L_0x00ed
            android.view.View r0 = r9.itemView
            android.view.ViewParent r0 = r0.getParent()
            if (r0 == 0) goto L_0x00d9
            if (r4 != r15) goto L_0x004a
            r7 = r8
            goto L_0x004f
        L_0x004a:
            int r0 = r11.J(r9)
            r7 = r0
        L_0x004f:
            r23.C()
            r0 = 4
            r1 = 0
            if (r7 == r14) goto L_0x007c
            if (r7 == r15) goto L_0x007c
            if (r7 == r0) goto L_0x0069
            if (r7 == r10) goto L_0x0069
            r2 = 16
            if (r7 == r2) goto L_0x0069
            r2 = 32
            if (r7 == r2) goto L_0x0069
            r17 = r1
            r18 = r17
            goto L_0x008e
        L_0x0069:
            float r2 = r11.f3626h
            float r2 = java.lang.Math.signum(r2)
            androidx.recyclerview.widget.RecyclerView r3 = r11.f3636r
            int r3 = r3.getWidth()
            float r3 = (float) r3
            float r2 = r2 * r3
            r18 = r1
            r17 = r2
            goto L_0x008e
        L_0x007c:
            float r2 = r11.f3627i
            float r2 = java.lang.Math.signum(r2)
            androidx.recyclerview.widget.RecyclerView r3 = r11.f3636r
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r2 = r2 * r3
            r17 = r1
            r18 = r2
        L_0x008e:
            if (r4 != r15) goto L_0x0092
            r6 = r10
            goto L_0x0097
        L_0x0092:
            if (r7 <= 0) goto L_0x0096
            r6 = r15
            goto L_0x0097
        L_0x0096:
            r6 = r0
        L_0x0097:
            float[] r0 = r11.f3620b
            r11.w(r0)
            float[] r0 = r11.f3620b
            r19 = r0[r8]
            r20 = r0[r14]
            androidx.recyclerview.widget.k$c r5 = new androidx.recyclerview.widget.k$c
            r0 = r5
            r1 = r23
            r2 = r9
            r3 = r6
            r14 = r5
            r5 = r19
            r15 = r6
            r6 = r20
            r21 = r7
            r7 = r17
            r8 = r18
            r22 = r9
            r9 = r21
            r21 = r10
            r10 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            androidx.recyclerview.widget.k$f r0 = r11.f3631m
            androidx.recyclerview.widget.RecyclerView r1 = r11.f3636r
            float r2 = r17 - r19
            float r3 = r18 - r20
            long r0 = r0.getAnimationDuration(r1, r15, r2, r3)
            r14.b(r0)
            java.util.List<androidx.recyclerview.widget.k$h> r0 = r11.f3634p
            r0.add(r14)
            r14.d()
            r8 = 1
            goto L_0x00e9
        L_0x00d9:
            r0 = r9
            r21 = r10
            android.view.View r1 = r0.itemView
            r11.D(r1)
            androidx.recyclerview.widget.k$f r1 = r11.f3631m
            androidx.recyclerview.widget.RecyclerView r2 = r11.f3636r
            r1.clearView(r2, r0)
            r8 = 0
        L_0x00e9:
            r0 = 0
            r11.f3621c = r0
            goto L_0x00f0
        L_0x00ed:
            r21 = r10
            r8 = 0
        L_0x00f0:
            if (r12 == 0) goto L_0x0121
            androidx.recyclerview.widget.k$f r0 = r11.f3631m
            androidx.recyclerview.widget.RecyclerView r1 = r11.f3636r
            int r0 = r0.getAbsoluteMovementFlags(r1, r12)
            r0 = r0 & r16
            int r1 = r11.f3632n
            int r1 = r1 * 8
            int r0 = r0 >> r1
            r11.f3633o = r0
            android.view.View r0 = r12.itemView
            int r0 = r0.getLeft()
            float r0 = (float) r0
            r11.f3628j = r0
            android.view.View r0 = r12.itemView
            int r0 = r0.getTop()
            float r0 = (float) r0
            r11.f3629k = r0
            r11.f3621c = r12
            r0 = 2
            if (r13 != r0) goto L_0x0121
            android.view.View r0 = r12.itemView
            r1 = 0
            r0.performHapticFeedback(r1)
            goto L_0x0122
        L_0x0121:
            r1 = 0
        L_0x0122:
            androidx.recyclerview.widget.RecyclerView r0 = r11.f3636r
            android.view.ViewParent r0 = r0.getParent()
            if (r0 == 0) goto L_0x0134
            androidx.recyclerview.widget.RecyclerView$c0 r2 = r11.f3621c
            if (r2 == 0) goto L_0x0130
            r14 = 1
            goto L_0x0131
        L_0x0130:
            r14 = r1
        L_0x0131:
            r0.requestDisallowInterceptTouchEvent(r14)
        L_0x0134:
            if (r8 != 0) goto L_0x013f
            androidx.recyclerview.widget.RecyclerView r0 = r11.f3636r
            androidx.recyclerview.widget.RecyclerView$p r0 = r0.getLayoutManager()
            r0.G1()
        L_0x013f:
            androidx.recyclerview.widget.k$f r0 = r11.f3631m
            androidx.recyclerview.widget.RecyclerView$c0 r1 = r11.f3621c
            int r2 = r11.f3632n
            r0.onSelectedChanged(r1, r2)
            androidx.recyclerview.widget.RecyclerView r0 = r11.f3636r
            r0.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.k.F(androidx.recyclerview.widget.RecyclerView$c0, int):void");
    }

    /* access modifiers changed from: package-private */
    public void K(MotionEvent motionEvent, int i10, int i11) {
        float x10 = motionEvent.getX(i11);
        float y10 = motionEvent.getY(i11);
        float f10 = x10 - this.f3622d;
        this.f3626h = f10;
        this.f3627i = y10 - this.f3623e;
        if ((i10 & 4) == 0) {
            this.f3626h = Math.max(0.0f, f10);
        }
        if ((i10 & 8) == 0) {
            this.f3626h = Math.min(0.0f, this.f3626h);
        }
        if ((i10 & 1) == 0) {
            this.f3627i = Math.max(0.0f, this.f3627i);
        }
        if ((i10 & 2) == 0) {
            this.f3627i = Math.min(0.0f, this.f3627i);
        }
    }

    public void b(View view) {
    }

    public void d(View view) {
        D(view);
        RecyclerView.c0 g02 = this.f3636r.g0(view);
        if (g02 != null) {
            RecyclerView.c0 c0Var = this.f3621c;
            if (c0Var == null || g02 != c0Var) {
                r(g02, false);
                if (this.f3619a.remove(g02.itemView)) {
                    this.f3631m.clearView(this.f3636r, g02);
                    return;
                }
                return;
            }
            F((RecyclerView.c0) null, 0);
        }
    }

    public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.z zVar) {
        rect.setEmpty();
    }

    public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.z zVar) {
        float f10;
        float f11;
        this.f3643y = -1;
        if (this.f3621c != null) {
            w(this.f3620b);
            float[] fArr = this.f3620b;
            float f12 = fArr[0];
            f10 = fArr[1];
            f11 = f12;
        } else {
            f11 = 0.0f;
            f10 = 0.0f;
        }
        this.f3631m.onDraw(canvas, recyclerView, this.f3621c, this.f3634p, this.f3632n, f11, f10);
    }

    public void k(Canvas canvas, RecyclerView recyclerView, RecyclerView.z zVar) {
        float f10;
        float f11;
        if (this.f3621c != null) {
            w(this.f3620b);
            float[] fArr = this.f3620b;
            float f12 = fArr[0];
            f10 = fArr[1];
            f11 = f12;
        } else {
            f11 = 0.0f;
            f10 = 0.0f;
        }
        this.f3631m.onDrawOver(canvas, recyclerView, this.f3621c, this.f3634p, this.f3632n, f11, f10);
    }

    public void m(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f3636r;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                q();
            }
            this.f3636r = recyclerView;
            if (recyclerView != null) {
                Resources resources = recyclerView.getResources();
                this.f3624f = resources.getDimension(p1.b.item_touch_helper_swipe_escape_velocity);
                this.f3625g = resources.getDimension(p1.b.item_touch_helper_swipe_escape_max_velocity);
                G();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void o(int i10, MotionEvent motionEvent, int i11) {
        RecyclerView.c0 v10;
        int absoluteMovementFlags;
        if (this.f3621c == null && i10 == 2 && this.f3632n != 2 && this.f3631m.isItemViewSwipeEnabled() && this.f3636r.getScrollState() != 1 && (v10 = v(motionEvent)) != null && (absoluteMovementFlags = (this.f3631m.getAbsoluteMovementFlags(this.f3636r, v10) & 65280) >> 8) != 0) {
            float x10 = motionEvent.getX(i11);
            float y10 = motionEvent.getY(i11);
            float f10 = x10 - this.f3622d;
            float f11 = y10 - this.f3623e;
            float abs = Math.abs(f10);
            float abs2 = Math.abs(f11);
            int i12 = this.f3635q;
            if (abs >= ((float) i12) || abs2 >= ((float) i12)) {
                if (abs > abs2) {
                    if (f10 < 0.0f && (absoluteMovementFlags & 4) == 0) {
                        return;
                    }
                    if (f10 > 0.0f && (absoluteMovementFlags & 8) == 0) {
                        return;
                    }
                } else if (f11 < 0.0f && (absoluteMovementFlags & 1) == 0) {
                    return;
                } else {
                    if (f11 > 0.0f && (absoluteMovementFlags & 2) == 0) {
                        return;
                    }
                }
                this.f3627i = 0.0f;
                this.f3626h = 0.0f;
                this.f3630l = motionEvent.getPointerId(0);
                F(v10, 1);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void r(RecyclerView.c0 c0Var, boolean z10) {
        for (int size = this.f3634p.size() - 1; size >= 0; size--) {
            h hVar = this.f3634p.get(size);
            if (hVar.f3660e == c0Var) {
                hVar.f3666k |= z10;
                if (!hVar.f3667l) {
                    hVar.a();
                }
                this.f3634p.remove(size);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public h s(MotionEvent motionEvent) {
        if (this.f3634p.isEmpty()) {
            return null;
        }
        View t10 = t(motionEvent);
        for (int size = this.f3634p.size() - 1; size >= 0; size--) {
            h hVar = this.f3634p.get(size);
            if (hVar.f3660e.itemView == t10) {
                return hVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public View t(MotionEvent motionEvent) {
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        RecyclerView.c0 c0Var = this.f3621c;
        if (c0Var != null) {
            View view = c0Var.itemView;
            if (y(view, x10, y10, this.f3628j + this.f3626h, this.f3629k + this.f3627i)) {
                return view;
            }
        }
        for (int size = this.f3634p.size() - 1; size >= 0; size--) {
            h hVar = this.f3634p.get(size);
            View view2 = hVar.f3660e.itemView;
            if (y(view2, x10, y10, hVar.f3664i, hVar.f3665j)) {
                return view2;
            }
        }
        return this.f3636r.S(x10, y10);
    }

    /* access modifiers changed from: package-private */
    public boolean x() {
        int size = this.f3634p.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!this.f3634p.get(i10).f3667l) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void z(RecyclerView.c0 c0Var) {
        if (!this.f3636r.isLayoutRequested() && this.f3632n == 2) {
            float moveThreshold = this.f3631m.getMoveThreshold(c0Var);
            int i10 = (int) (this.f3628j + this.f3626h);
            int i11 = (int) (this.f3629k + this.f3627i);
            if (((float) Math.abs(i11 - c0Var.itemView.getTop())) >= ((float) c0Var.itemView.getHeight()) * moveThreshold || ((float) Math.abs(i10 - c0Var.itemView.getLeft())) >= ((float) c0Var.itemView.getWidth()) * moveThreshold) {
                List<RecyclerView.c0> u10 = u(c0Var);
                if (u10.size() != 0) {
                    RecyclerView.c0 chooseDropTarget = this.f3631m.chooseDropTarget(c0Var, u10, i10, i11);
                    if (chooseDropTarget == null) {
                        this.f3639u.clear();
                        this.f3640v.clear();
                        return;
                    }
                    int absoluteAdapterPosition = chooseDropTarget.getAbsoluteAdapterPosition();
                    int absoluteAdapterPosition2 = c0Var.getAbsoluteAdapterPosition();
                    if (this.f3631m.onMove(this.f3636r, c0Var, chooseDropTarget)) {
                        this.f3631m.onMoved(this.f3636r, c0Var, absoluteAdapterPosition2, chooseDropTarget, absoluteAdapterPosition, i10, i11);
                    }
                }
            }
        }
    }
}
