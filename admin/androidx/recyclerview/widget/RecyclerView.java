package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.widget.a;
import androidx.recyclerview.widget.f;
import androidx.recyclerview.widget.j;
import androidx.recyclerview.widget.u;
import androidx.recyclerview.widget.y;
import androidx.recyclerview.widget.z;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.sourceforge.zbar.Config;
import x0.c;

public class RecyclerView extends ViewGroup implements androidx.core.view.l {
    static final boolean A1;
    static final boolean B1;
    static final boolean C1;
    private static final boolean D1;
    private static final boolean E1;
    private static final Class<?>[] F1;
    static final Interpolator G1 = new c();

    /* renamed from: y1  reason: collision with root package name */
    private static final int[] f3271y1 = {16843830};

    /* renamed from: z1  reason: collision with root package name */
    static final boolean f3272z1;
    private int A;
    boolean B;
    private final AccessibilityManager C;
    private List<q> D;
    boolean E;
    boolean F;
    private int G;
    private int H;
    private l I;
    private EdgeEffect J;
    private EdgeEffect K;
    private EdgeEffect L;
    private EdgeEffect M;
    m N;
    private int O;
    private int P;
    private VelocityTracker Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private int V;
    private r W;
    private float Z0;

    /* renamed from: a  reason: collision with root package name */
    private final x f3273a;

    /* renamed from: a0  reason: collision with root package name */
    private final int f3274a0;

    /* renamed from: a1  reason: collision with root package name */
    private boolean f3275a1;

    /* renamed from: b  reason: collision with root package name */
    final v f3276b;

    /* renamed from: b0  reason: collision with root package name */
    private final int f3277b0;

    /* renamed from: b1  reason: collision with root package name */
    final b0 f3278b1;

    /* renamed from: c  reason: collision with root package name */
    SavedState f3279c;

    /* renamed from: c0  reason: collision with root package name */
    private float f3280c0;

    /* renamed from: c1  reason: collision with root package name */
    j f3281c1;

    /* renamed from: d  reason: collision with root package name */
    a f3282d;

    /* renamed from: d1  reason: collision with root package name */
    j.b f3283d1;

    /* renamed from: e  reason: collision with root package name */
    f f3284e;

    /* renamed from: e1  reason: collision with root package name */
    final z f3285e1;

    /* renamed from: f  reason: collision with root package name */
    final z f3286f;

    /* renamed from: f1  reason: collision with root package name */
    private t f3287f1;

    /* renamed from: g  reason: collision with root package name */
    boolean f3288g;

    /* renamed from: g1  reason: collision with root package name */
    private List<t> f3289g1;

    /* renamed from: h  reason: collision with root package name */
    final Runnable f3290h;

    /* renamed from: h1  reason: collision with root package name */
    boolean f3291h1;

    /* renamed from: i  reason: collision with root package name */
    final Rect f3292i;

    /* renamed from: i1  reason: collision with root package name */
    boolean f3293i1;

    /* renamed from: j  reason: collision with root package name */
    private final Rect f3294j;

    /* renamed from: j1  reason: collision with root package name */
    private m.b f3295j1;

    /* renamed from: k  reason: collision with root package name */
    final RectF f3296k;

    /* renamed from: k1  reason: collision with root package name */
    boolean f3297k1;

    /* renamed from: l  reason: collision with root package name */
    h f3298l;

    /* renamed from: l1  reason: collision with root package name */
    u f3299l1;

    /* renamed from: m  reason: collision with root package name */
    p f3300m;

    /* renamed from: m1  reason: collision with root package name */
    private k f3301m1;

    /* renamed from: n  reason: collision with root package name */
    w f3302n;

    /* renamed from: n1  reason: collision with root package name */
    private final int[] f3303n1;

    /* renamed from: o  reason: collision with root package name */
    final List<w> f3304o;

    /* renamed from: o1  reason: collision with root package name */
    private androidx.core.view.m f3305o1;

    /* renamed from: p  reason: collision with root package name */
    final ArrayList<o> f3306p;

    /* renamed from: p1  reason: collision with root package name */
    private final int[] f3307p1;

    /* renamed from: q  reason: collision with root package name */
    private final ArrayList<s> f3308q;

    /* renamed from: q1  reason: collision with root package name */
    private final int[] f3309q1;

    /* renamed from: r  reason: collision with root package name */
    private s f3310r;

    /* renamed from: r1  reason: collision with root package name */
    final int[] f3311r1;

    /* renamed from: s  reason: collision with root package name */
    boolean f3312s;

    /* renamed from: s1  reason: collision with root package name */
    final List<c0> f3313s1;

    /* renamed from: t  reason: collision with root package name */
    boolean f3314t;

    /* renamed from: t1  reason: collision with root package name */
    private Runnable f3315t1;

    /* renamed from: u  reason: collision with root package name */
    boolean f3316u;

    /* renamed from: u1  reason: collision with root package name */
    private boolean f3317u1;

    /* renamed from: v  reason: collision with root package name */
    boolean f3318v;

    /* renamed from: v1  reason: collision with root package name */
    private int f3319v1;

    /* renamed from: w  reason: collision with root package name */
    private int f3320w;

    /* renamed from: w1  reason: collision with root package name */
    private int f3321w1;

    /* renamed from: x  reason: collision with root package name */
    boolean f3322x;

    /* renamed from: x1  reason: collision with root package name */
    private final z.b f3323x1;

    /* renamed from: y  reason: collision with root package name */
    boolean f3324y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f3325z;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        c0 f3326a;

        /* renamed from: b  reason: collision with root package name */
        final Rect f3327b = new Rect();

        /* renamed from: c  reason: collision with root package name */
        boolean f3328c = true;

        /* renamed from: d  reason: collision with root package name */
        boolean f3329d = false;

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public int a() {
            return this.f3326a.getLayoutPosition();
        }

        public boolean b() {
            return this.f3326a.isUpdated();
        }

        public boolean c() {
            return this.f3326a.isRemoved();
        }

        public boolean d() {
            return this.f3326a.isInvalid();
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        Parcelable f3330c;

        class a implements Parcelable.ClassLoaderCreator<SavedState> {
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
            this.f3330c = parcel.readParcelable(classLoader == null ? p.class.getClassLoader() : classLoader);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        /* access modifiers changed from: package-private */
        public void b(SavedState savedState) {
            this.f3330c = savedState.f3330c;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeParcelable(this.f3330c, 0);
        }
    }

    class a implements Runnable {
        a() {
        }

        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f3318v && !recyclerView.isLayoutRequested()) {
                RecyclerView recyclerView2 = RecyclerView.this;
                if (!recyclerView2.f3312s) {
                    recyclerView2.requestLayout();
                } else if (recyclerView2.f3324y) {
                    recyclerView2.f3322x = true;
                } else {
                    recyclerView2.v();
                }
            }
        }
    }

    public static abstract class a0 {
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            m mVar = RecyclerView.this.N;
            if (mVar != null) {
                mVar.runPendingAnimations();
            }
            RecyclerView.this.f3297k1 = false;
        }
    }

    class b0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private int f3333a;

        /* renamed from: b  reason: collision with root package name */
        private int f3334b;

        /* renamed from: c  reason: collision with root package name */
        OverScroller f3335c;

        /* renamed from: d  reason: collision with root package name */
        Interpolator f3336d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f3337e = false;

        /* renamed from: f  reason: collision with root package name */
        private boolean f3338f = false;

        b0() {
            Interpolator interpolator = RecyclerView.G1;
            this.f3336d = interpolator;
            this.f3335c = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        private int a(int i10, int i11) {
            int abs = Math.abs(i10);
            int abs2 = Math.abs(i11);
            boolean z10 = abs > abs2;
            RecyclerView recyclerView = RecyclerView.this;
            int width = z10 ? recyclerView.getWidth() : recyclerView.getHeight();
            if (!z10) {
                abs = abs2;
            }
            return Math.min((int) (((((float) abs) / ((float) width)) + 1.0f) * 300.0f), 2000);
        }

        private void c() {
            RecyclerView.this.removeCallbacks(this);
            androidx.core.view.x.j0(RecyclerView.this, this);
        }

        public void b(int i10, int i11) {
            RecyclerView.this.setScrollState(2);
            this.f3334b = 0;
            this.f3333a = 0;
            Interpolator interpolator = this.f3336d;
            Interpolator interpolator2 = RecyclerView.G1;
            if (interpolator != interpolator2) {
                this.f3336d = interpolator2;
                this.f3335c = new OverScroller(RecyclerView.this.getContext(), interpolator2);
            }
            this.f3335c.fling(0, 0, i10, i11, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            d();
        }

        /* access modifiers changed from: package-private */
        public void d() {
            if (this.f3337e) {
                this.f3338f = true;
            } else {
                c();
            }
        }

        public void e(int i10, int i11, int i12, Interpolator interpolator) {
            if (i12 == Integer.MIN_VALUE) {
                i12 = a(i10, i11);
            }
            int i13 = i12;
            if (interpolator == null) {
                interpolator = RecyclerView.G1;
            }
            if (this.f3336d != interpolator) {
                this.f3336d = interpolator;
                this.f3335c = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.f3334b = 0;
            this.f3333a = 0;
            RecyclerView.this.setScrollState(2);
            this.f3335c.startScroll(0, 0, i10, i11, i13);
            if (Build.VERSION.SDK_INT < 23) {
                this.f3335c.computeScrollOffset();
            }
            d();
        }

        public void f() {
            RecyclerView.this.removeCallbacks(this);
            this.f3335c.abortAnimation();
        }

        public void run() {
            int i10;
            int i11;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f3300m == null) {
                f();
                return;
            }
            this.f3338f = false;
            this.f3337e = true;
            recyclerView.v();
            OverScroller overScroller = this.f3335c;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i12 = currX - this.f3333a;
                int i13 = currY - this.f3334b;
                this.f3333a = currX;
                this.f3334b = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.f3311r1;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.G(i12, i13, iArr, (int[]) null, 1)) {
                    int[] iArr2 = RecyclerView.this.f3311r1;
                    i12 -= iArr2[0];
                    i13 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.u(i12, i13);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.f3298l != null) {
                    int[] iArr3 = recyclerView3.f3311r1;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.j1(i12, i13, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.f3311r1;
                    i10 = iArr4[0];
                    i11 = iArr4[1];
                    i12 -= i10;
                    i13 -= i11;
                    y yVar = recyclerView4.f3300m.f3357g;
                    if (yVar != null && !yVar.g() && yVar.h()) {
                        int b10 = RecyclerView.this.f3285e1.b();
                        if (b10 == 0) {
                            yVar.r();
                        } else {
                            if (yVar.f() >= b10) {
                                yVar.p(b10 - 1);
                            }
                            yVar.j(i10, i11);
                        }
                    }
                } else {
                    i11 = 0;
                    i10 = 0;
                }
                if (!RecyclerView.this.f3306p.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.f3311r1;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.H(i10, i11, i12, i13, (int[]) null, 1, iArr5);
                RecyclerView recyclerView6 = RecyclerView.this;
                int[] iArr6 = recyclerView6.f3311r1;
                int i14 = i12 - iArr6[0];
                int i15 = i13 - iArr6[1];
                if (!(i10 == 0 && i11 == 0)) {
                    recyclerView6.J(i10, i11);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z10 = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i14 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i15 != 0));
                y yVar2 = RecyclerView.this.f3300m.f3357g;
                if ((yVar2 != null && yVar2.g()) || !z10) {
                    d();
                    RecyclerView recyclerView7 = RecyclerView.this;
                    j jVar = recyclerView7.f3281c1;
                    if (jVar != null) {
                        jVar.f(recyclerView7, i10, i11);
                    }
                } else {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i16 = i14 < 0 ? -currVelocity : i14 > 0 ? currVelocity : 0;
                        if (i15 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i15 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.a(i16, currVelocity);
                    }
                    if (RecyclerView.C1) {
                        RecyclerView.this.f3283d1.b();
                    }
                }
            }
            y yVar3 = RecyclerView.this.f3300m.f3357g;
            if (yVar3 != null && yVar3.g()) {
                yVar3.j(0, 0);
            }
            this.f3337e = false;
            if (this.f3338f) {
                c();
                return;
            }
            RecyclerView.this.setScrollState(0);
            RecyclerView.this.w1(1);
        }
    }

    class c implements Interpolator {
        c() {
        }

        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    }

    public static abstract class c0 {
        static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        static final int FLAG_BOUND = 1;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_MOVED = 2048;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS = Collections.emptyList();
        static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
        public final View itemView;
        h<? extends c0> mBindingAdapter;
        int mFlags;
        boolean mInChangeScrap = false;
        private int mIsRecyclableCount = 0;
        long mItemId = -1;
        int mItemViewType = -1;
        WeakReference<RecyclerView> mNestedRecyclerView;
        int mOldPosition = -1;
        RecyclerView mOwnerRecyclerView;
        List<Object> mPayloads = null;
        int mPendingAccessibilityState = -1;
        int mPosition = -1;
        int mPreLayoutPosition = -1;
        v mScrapContainer = null;
        c0 mShadowedHolder = null;
        c0 mShadowingHolder = null;
        List<Object> mUnmodifiedPayloads = null;
        private int mWasImportantForAccessibilityBeforeHidden = 0;

        public c0(View view) {
            if (view != null) {
                this.itemView = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                ArrayList arrayList = new ArrayList();
                this.mPayloads = arrayList;
                this.mUnmodifiedPayloads = Collections.unmodifiableList(arrayList);
            }
        }

        /* access modifiers changed from: package-private */
        public void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(FLAG_ADAPTER_FULLUPDATE);
            } else if ((FLAG_ADAPTER_FULLUPDATE & this.mFlags) == 0) {
                createPayloadsIfNeeded();
                this.mPayloads.add(obj);
            }
        }

        /* access modifiers changed from: package-private */
        public void addFlags(int i10) {
            this.mFlags = i10 | this.mFlags;
        }

        /* access modifiers changed from: package-private */
        public void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        /* access modifiers changed from: package-private */
        public void clearPayload() {
            List<Object> list = this.mPayloads;
            if (list != null) {
                list.clear();
            }
            this.mFlags &= -1025;
        }

        /* access modifiers changed from: package-private */
        public void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        /* access modifiers changed from: package-private */
        public void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        /* access modifiers changed from: package-private */
        public boolean doesTransientStatePreventRecycling() {
            return (this.mFlags & 16) == 0 && androidx.core.view.x.S(this.itemView);
        }

        /* access modifiers changed from: package-private */
        public void flagRemovedAndOffsetPosition(int i10, int i11, boolean z10) {
            addFlags(8);
            offsetPosition(i11, z10);
            this.mPosition = i10;
        }

        public final int getAbsoluteAdapterPosition() {
            RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.d0(this);
        }

        @Deprecated
        public final int getAdapterPosition() {
            return getBindingAdapterPosition();
        }

        public final h<? extends c0> getBindingAdapter() {
            return this.mBindingAdapter;
        }

        public final int getBindingAdapterPosition() {
            RecyclerView recyclerView;
            h adapter;
            int d02;
            if (this.mBindingAdapter == null || (recyclerView = this.mOwnerRecyclerView) == null || (adapter = recyclerView.getAdapter()) == null || (d02 = this.mOwnerRecyclerView.d0(this)) == -1) {
                return -1;
            }
            return adapter.findRelativeAdapterPositionIn(this.mBindingAdapter, this, d02);
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        public final int getLayoutPosition() {
            int i10 = this.mPreLayoutPosition;
            return i10 == -1 ? this.mPosition : i10;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        @Deprecated
        public final int getPosition() {
            int i10 = this.mPreLayoutPosition;
            return i10 == -1 ? this.mPosition : i10;
        }

        /* access modifiers changed from: package-private */
        public List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & FLAG_ADAPTER_FULLUPDATE) != 0) {
                return FULLUPDATE_PAYLOADS;
            }
            List<Object> list = this.mPayloads;
            return (list == null || list.size() == 0) ? FULLUPDATE_PAYLOADS : this.mUnmodifiedPayloads;
        }

        /* access modifiers changed from: package-private */
        public boolean hasAnyOfTheFlags(int i10) {
            return (i10 & this.mFlags) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean isAdapterPositionUnknown() {
            return (this.mFlags & FLAG_ADAPTER_POSITION_UNKNOWN) != 0 || isInvalid();
        }

        /* access modifiers changed from: package-private */
        public boolean isAttachedToTransitionOverlay() {
            return (this.itemView.getParent() == null || this.itemView.getParent() == this.mOwnerRecyclerView) ? false : true;
        }

        /* access modifiers changed from: package-private */
        public boolean isBound() {
            return (this.mFlags & 1) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean isInvalid() {
            return (this.mFlags & 4) != 0;
        }

        public final boolean isRecyclable() {
            return (this.mFlags & 16) == 0 && !androidx.core.view.x.S(this.itemView);
        }

        /* access modifiers changed from: package-private */
        public boolean isRemoved() {
            return (this.mFlags & 8) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean isScrap() {
            return this.mScrapContainer != null;
        }

        /* access modifiers changed from: package-private */
        public boolean isTmpDetached() {
            return (this.mFlags & 256) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean isUpdated() {
            return (this.mFlags & 2) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean needsUpdate() {
            return (this.mFlags & 2) != 0;
        }

        /* access modifiers changed from: package-private */
        public void offsetPosition(int i10, boolean z10) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z10) {
                this.mPreLayoutPosition += i10;
            }
            this.mPosition += i10;
            if (this.itemView.getLayoutParams() != null) {
                ((LayoutParams) this.itemView.getLayoutParams()).f3328c = true;
            }
        }

        /* access modifiers changed from: package-private */
        public void onEnteredHiddenState(RecyclerView recyclerView) {
            int i10 = this.mPendingAccessibilityState;
            if (i10 == -1) {
                i10 = androidx.core.view.x.A(this.itemView);
            }
            this.mWasImportantForAccessibilityBeforeHidden = i10;
            recyclerView.m1(this, 4);
        }

        /* access modifiers changed from: package-private */
        public void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.m1(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        /* access modifiers changed from: package-private */
        public void resetInternal() {
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.s(this);
        }

        /* access modifiers changed from: package-private */
        public void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        /* access modifiers changed from: package-private */
        public void setFlags(int i10, int i11) {
            this.mFlags = (i10 & i11) | (this.mFlags & (~i11));
        }

        public final void setIsRecyclable(boolean z10) {
            int i10;
            int i11 = this.mIsRecyclableCount;
            int i12 = z10 ? i11 - 1 : i11 + 1;
            this.mIsRecyclableCount = i12;
            if (i12 < 0) {
                this.mIsRecyclableCount = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z10 && i12 == 1) {
                i10 = this.mFlags | 16;
            } else if (z10 && i12 == 0) {
                i10 = this.mFlags & -17;
            } else {
                return;
            }
            this.mFlags = i10;
        }

        /* access modifiers changed from: package-private */
        public void setScrapContainer(v vVar, boolean z10) {
            this.mScrapContainer = vVar;
            this.mInChangeScrap = z10;
        }

        /* access modifiers changed from: package-private */
        public boolean shouldBeKeptAsChild() {
            return (this.mFlags & 16) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean shouldIgnore() {
            return (this.mFlags & 128) != 0;
        }

        /* access modifiers changed from: package-private */
        public void stopIgnoring() {
            this.mFlags &= -129;
        }

        public String toString() {
            String simpleName = getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName();
            StringBuilder sb2 = new StringBuilder(simpleName + "{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
            if (isScrap()) {
                sb2.append(" scrap ");
                sb2.append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                sb2.append(" invalid");
            }
            if (!isBound()) {
                sb2.append(" unbound");
            }
            if (needsUpdate()) {
                sb2.append(" update");
            }
            if (isRemoved()) {
                sb2.append(" removed");
            }
            if (shouldIgnore()) {
                sb2.append(" ignored");
            }
            if (isTmpDetached()) {
                sb2.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb2.append(" not recyclable(" + this.mIsRecyclableCount + ")");
            }
            if (isAdapterPositionUnknown()) {
                sb2.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb2.append(" no parent");
            }
            sb2.append("}");
            return sb2.toString();
        }

        /* access modifiers changed from: package-private */
        public void unScrap() {
            this.mScrapContainer.J(this);
        }

        /* access modifiers changed from: package-private */
        public boolean wasReturnedFromScrap() {
            return (this.mFlags & 32) != 0;
        }
    }

    class d implements z.b {
        d() {
        }

        public void a(c0 c0Var) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f3300m.y1(c0Var.itemView, recyclerView.f3276b);
        }

        public void b(c0 c0Var, m.c cVar, m.c cVar2) {
            RecyclerView.this.m(c0Var, cVar, cVar2);
        }

        public void c(c0 c0Var, m.c cVar, m.c cVar2) {
            RecyclerView.this.f3276b.J(c0Var);
            RecyclerView.this.o(c0Var, cVar, cVar2);
        }

        public void d(c0 c0Var, m.c cVar, m.c cVar2) {
            c0Var.setIsRecyclable(false);
            RecyclerView recyclerView = RecyclerView.this;
            boolean z10 = recyclerView.E;
            m mVar = recyclerView.N;
            if (z10) {
                if (!mVar.animateChange(c0Var, c0Var, cVar, cVar2)) {
                    return;
                }
            } else if (!mVar.animatePersistence(c0Var, cVar, cVar2)) {
                return;
            }
            RecyclerView.this.O0();
        }
    }

    class e implements f.b {
        e() {
        }

        public View a(int i10) {
            return RecyclerView.this.getChildAt(i10);
        }

        public void b(View view) {
            c0 h02 = RecyclerView.h0(view);
            if (h02 != null) {
                h02.onEnteredHiddenState(RecyclerView.this);
            }
        }

        public c0 c(View view) {
            return RecyclerView.h0(view);
        }

        public void d(int i10) {
            c0 h02;
            View a10 = a(i10);
            if (!(a10 == null || (h02 = RecyclerView.h0(a10)) == null)) {
                if (!h02.isTmpDetached() || h02.shouldIgnore()) {
                    h02.addFlags(Config.X_DENSITY);
                } else {
                    throw new IllegalArgumentException("called detach on an already detached child " + h02 + RecyclerView.this.Q());
                }
            }
            RecyclerView.this.detachViewFromParent(i10);
        }

        public void e(View view) {
            c0 h02 = RecyclerView.h0(view);
            if (h02 != null) {
                h02.onLeftHiddenState(RecyclerView.this);
            }
        }

        public void f(View view, int i10) {
            RecyclerView.this.addView(view, i10);
            RecyclerView.this.z(view);
        }

        public int g() {
            return RecyclerView.this.getChildCount();
        }

        public void h(int i10) {
            View childAt = RecyclerView.this.getChildAt(i10);
            if (childAt != null) {
                RecyclerView.this.A(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i10);
        }

        public void i() {
            int g10 = g();
            for (int i10 = 0; i10 < g10; i10++) {
                View a10 = a(i10);
                RecyclerView.this.A(a10);
                a10.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }

        public void j(View view, int i10, ViewGroup.LayoutParams layoutParams) {
            c0 h02 = RecyclerView.h0(view);
            if (h02 != null) {
                if (h02.isTmpDetached() || h02.shouldIgnore()) {
                    h02.clearTmpDetachFlag();
                } else {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + h02 + RecyclerView.this.Q());
                }
            }
            RecyclerView.this.attachViewToParent(view, i10, layoutParams);
        }

        public int k(View view) {
            return RecyclerView.this.indexOfChild(view);
        }
    }

    class f implements a.C0034a {
        f() {
        }

        public void a(int i10, int i11) {
            RecyclerView.this.E0(i10, i11);
            RecyclerView.this.f3291h1 = true;
        }

        public void b(a.b bVar) {
            i(bVar);
        }

        public c0 c(int i10) {
            c0 b02 = RecyclerView.this.b0(i10, true);
            if (b02 != null && !RecyclerView.this.f3284e.n(b02.itemView)) {
                return b02;
            }
            return null;
        }

        public void d(int i10, int i11) {
            RecyclerView.this.F0(i10, i11, false);
            RecyclerView.this.f3291h1 = true;
        }

        public void e(int i10, int i11) {
            RecyclerView.this.D0(i10, i11);
            RecyclerView.this.f3291h1 = true;
        }

        public void f(int i10, int i11) {
            RecyclerView.this.F0(i10, i11, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f3291h1 = true;
            recyclerView.f3285e1.f3408d += i11;
        }

        public void g(a.b bVar) {
            i(bVar);
        }

        public void h(int i10, int i11, Object obj) {
            RecyclerView.this.z1(i10, i11, obj);
            RecyclerView.this.f3293i1 = true;
        }

        /* access modifiers changed from: package-private */
        public void i(a.b bVar) {
            int i10 = bVar.f3469a;
            if (i10 == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.f3300m.c1(recyclerView, bVar.f3470b, bVar.f3472d);
            } else if (i10 == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.f3300m.f1(recyclerView2, bVar.f3470b, bVar.f3472d);
            } else if (i10 == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.f3300m.h1(recyclerView3, bVar.f3470b, bVar.f3472d, bVar.f3471c);
            } else if (i10 == 8) {
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.f3300m.e1(recyclerView4, bVar.f3470b, bVar.f3472d, 1);
            }
        }
    }

    static /* synthetic */ class g {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3343a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                androidx.recyclerview.widget.RecyclerView$h$a[] r0 = androidx.recyclerview.widget.RecyclerView.h.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3343a = r0
                androidx.recyclerview.widget.RecyclerView$h$a r1 = androidx.recyclerview.widget.RecyclerView.h.a.PREVENT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3343a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.recyclerview.widget.RecyclerView$h$a r1 = androidx.recyclerview.widget.RecyclerView.h.a.PREVENT_WHEN_EMPTY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.g.<clinit>():void");
        }
    }

    public static abstract class h<VH extends c0> {
        private boolean mHasStableIds = false;
        private final i mObservable = new i();
        private a mStateRestorationPolicy = a.ALLOW;

        public enum a {
            ALLOW,
            PREVENT_WHEN_EMPTY,
            PREVENT
        }

        public final void bindViewHolder(VH vh, int i10) {
            boolean z10 = vh.mBindingAdapter == null;
            if (z10) {
                vh.mPosition = i10;
                if (hasStableIds()) {
                    vh.mItemId = getItemId(i10);
                }
                vh.setFlags(1, 519);
                t0.i.a("RV OnBindView");
            }
            vh.mBindingAdapter = this;
            onBindViewHolder(vh, i10, vh.getUnmodifiedPayloads());
            if (z10) {
                vh.clearPayload();
                ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
                if (layoutParams instanceof LayoutParams) {
                    ((LayoutParams) layoutParams).f3328c = true;
                }
                t0.i.b();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean canRestoreState() {
            int i10 = g.f3343a[this.mStateRestorationPolicy.ordinal()];
            if (i10 == 1) {
                return false;
            }
            if (i10 != 2) {
                return true;
            }
            return getItemCount() > 0;
        }

        public final VH createViewHolder(ViewGroup viewGroup, int i10) {
            try {
                t0.i.a("RV CreateView");
                VH onCreateViewHolder = onCreateViewHolder(viewGroup, i10);
                if (onCreateViewHolder.itemView.getParent() == null) {
                    onCreateViewHolder.mItemViewType = i10;
                    return onCreateViewHolder;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } finally {
                t0.i.b();
            }
        }

        public int findRelativeAdapterPositionIn(h<? extends c0> hVar, c0 c0Var, int i10) {
            if (hVar == this) {
                return i10;
            }
            return -1;
        }

        public abstract int getItemCount();

        public long getItemId(int i10) {
            return -1;
        }

        public int getItemViewType(int i10) {
            return 0;
        }

        public final a getStateRestorationPolicy() {
            return this.mStateRestorationPolicy;
        }

        public final boolean hasObservers() {
            return this.mObservable.a();
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final void notifyDataSetChanged() {
            this.mObservable.b();
        }

        public final void notifyItemChanged(int i10) {
            this.mObservable.d(i10, 1);
        }

        public final void notifyItemChanged(int i10, Object obj) {
            this.mObservable.e(i10, 1, obj);
        }

        public final void notifyItemInserted(int i10) {
            this.mObservable.f(i10, 1);
        }

        public final void notifyItemMoved(int i10, int i11) {
            this.mObservable.c(i10, i11);
        }

        public final void notifyItemRangeChanged(int i10, int i11) {
            this.mObservable.d(i10, i11);
        }

        public final void notifyItemRangeChanged(int i10, int i11, Object obj) {
            this.mObservable.e(i10, i11, obj);
        }

        public final void notifyItemRangeInserted(int i10, int i11) {
            this.mObservable.f(i10, i11);
        }

        public final void notifyItemRangeRemoved(int i10, int i11) {
            this.mObservable.g(i10, i11);
        }

        public final void notifyItemRemoved(int i10) {
            this.mObservable.g(i10, 1);
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(VH vh, int i10);

        public void onBindViewHolder(VH vh, int i10, List<Object> list) {
            onBindViewHolder(vh, i10);
        }

        public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i10);

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(VH vh) {
            return false;
        }

        public void onViewAttachedToWindow(VH vh) {
        }

        public void onViewDetachedFromWindow(VH vh) {
        }

        public void onViewRecycled(VH vh) {
        }

        public void registerAdapterDataObserver(j jVar) {
            this.mObservable.registerObserver(jVar);
        }

        public void setHasStableIds(boolean z10) {
            if (!hasObservers()) {
                this.mHasStableIds = z10;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public void setStateRestorationPolicy(a aVar) {
            this.mStateRestorationPolicy = aVar;
            this.mObservable.h();
        }

        public void unregisterAdapterDataObserver(j jVar) {
            this.mObservable.unregisterObserver(jVar);
        }
    }

    static class i extends Observable<j> {
        i() {
        }

        public boolean a() {
            return !this.mObservers.isEmpty();
        }

        public void b() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((j) this.mObservers.get(size)).a();
            }
        }

        public void c(int i10, int i11) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((j) this.mObservers.get(size)).e(i10, i11, 1);
            }
        }

        public void d(int i10, int i11) {
            e(i10, i11, (Object) null);
        }

        public void e(int i10, int i11, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((j) this.mObservers.get(size)).c(i10, i11, obj);
            }
        }

        public void f(int i10, int i11) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((j) this.mObservers.get(size)).d(i10, i11);
            }
        }

        public void g(int i10, int i11) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((j) this.mObservers.get(size)).f(i10, i11);
            }
        }

        public void h() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((j) this.mObservers.get(size)).g();
            }
        }
    }

    public static abstract class j {
        public void a() {
        }

        public void b(int i10, int i11) {
        }

        public void c(int i10, int i11, Object obj) {
            b(i10, i11);
        }

        public void d(int i10, int i11) {
        }

        public void e(int i10, int i11, int i12) {
        }

        public void f(int i10, int i11) {
        }

        public void g() {
        }
    }

    public interface k {
        int a(int i10, int i11);
    }

    public static class l {
        /* access modifiers changed from: protected */
        public EdgeEffect a(RecyclerView recyclerView, int i10) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class m {
        public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        public static final int FLAG_CHANGED = 2;
        public static final int FLAG_INVALIDATED = 4;
        public static final int FLAG_MOVED = 2048;
        public static final int FLAG_REMOVED = 8;
        private long mAddDuration = 120;
        private long mChangeDuration = 250;
        private ArrayList<a> mFinishedListeners = new ArrayList<>();
        private b mListener = null;
        private long mMoveDuration = 250;
        private long mRemoveDuration = 120;

        public interface a {
            void a();
        }

        interface b {
            void a(c0 c0Var);
        }

        public static class c {

            /* renamed from: a  reason: collision with root package name */
            public int f3348a;

            /* renamed from: b  reason: collision with root package name */
            public int f3349b;

            public c a(c0 c0Var) {
                return b(c0Var, 0);
            }

            public c b(c0 c0Var, int i10) {
                View view = c0Var.itemView;
                this.f3348a = view.getLeft();
                this.f3349b = view.getTop();
                view.getRight();
                view.getBottom();
                return this;
            }
        }

        static int buildAdapterChangeFlagsForAnimations(c0 c0Var) {
            int i10 = c0Var.mFlags & 14;
            if (c0Var.isInvalid()) {
                return 4;
            }
            if ((i10 & 4) != 0) {
                return i10;
            }
            int oldPosition = c0Var.getOldPosition();
            int absoluteAdapterPosition = c0Var.getAbsoluteAdapterPosition();
            return (oldPosition == -1 || absoluteAdapterPosition == -1 || oldPosition == absoluteAdapterPosition) ? i10 : i10 | FLAG_MOVED;
        }

        public abstract boolean animateAppearance(c0 c0Var, c cVar, c cVar2);

        public abstract boolean animateChange(c0 c0Var, c0 c0Var2, c cVar, c cVar2);

        public abstract boolean animateDisappearance(c0 c0Var, c cVar, c cVar2);

        public abstract boolean animatePersistence(c0 c0Var, c cVar, c cVar2);

        public abstract boolean canReuseUpdatedViewHolder(c0 c0Var);

        public boolean canReuseUpdatedViewHolder(c0 c0Var, List<Object> list) {
            return canReuseUpdatedViewHolder(c0Var);
        }

        public final void dispatchAnimationFinished(c0 c0Var) {
            onAnimationFinished(c0Var);
            b bVar = this.mListener;
            if (bVar != null) {
                bVar.a(c0Var);
            }
        }

        public final void dispatchAnimationStarted(c0 c0Var) {
            onAnimationStarted(c0Var);
        }

        public final void dispatchAnimationsFinished() {
            int size = this.mFinishedListeners.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.mFinishedListeners.get(i10).a();
            }
            this.mFinishedListeners.clear();
        }

        public abstract void endAnimation(c0 c0Var);

        public abstract void endAnimations();

        public long getAddDuration() {
            return this.mAddDuration;
        }

        public long getChangeDuration() {
            return this.mChangeDuration;
        }

        public long getMoveDuration() {
            return this.mMoveDuration;
        }

        public long getRemoveDuration() {
            return this.mRemoveDuration;
        }

        public abstract boolean isRunning();

        public final boolean isRunning(a aVar) {
            boolean isRunning = isRunning();
            if (aVar != null) {
                if (!isRunning) {
                    aVar.a();
                } else {
                    this.mFinishedListeners.add(aVar);
                }
            }
            return isRunning;
        }

        public c obtainHolderInfo() {
            return new c();
        }

        public void onAnimationFinished(c0 c0Var) {
        }

        public void onAnimationStarted(c0 c0Var) {
        }

        public c recordPostLayoutInformation(z zVar, c0 c0Var) {
            return obtainHolderInfo().a(c0Var);
        }

        public c recordPreLayoutInformation(z zVar, c0 c0Var, int i10, List<Object> list) {
            return obtainHolderInfo().a(c0Var);
        }

        public abstract void runPendingAnimations();

        public void setAddDuration(long j10) {
            this.mAddDuration = j10;
        }

        public void setChangeDuration(long j10) {
            this.mChangeDuration = j10;
        }

        /* access modifiers changed from: package-private */
        public void setListener(b bVar) {
            this.mListener = bVar;
        }

        public void setMoveDuration(long j10) {
            this.mMoveDuration = j10;
        }

        public void setRemoveDuration(long j10) {
            this.mRemoveDuration = j10;
        }
    }

    private class n implements m.b {
        n() {
        }

        public void a(c0 c0Var) {
            c0Var.setIsRecyclable(true);
            if (c0Var.mShadowedHolder != null && c0Var.mShadowingHolder == null) {
                c0Var.mShadowedHolder = null;
            }
            c0Var.mShadowingHolder = null;
            if (!c0Var.shouldBeKeptAsChild() && !RecyclerView.this.X0(c0Var.itemView) && c0Var.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(c0Var.itemView, false);
            }
        }
    }

    public static abstract class o {
        @Deprecated
        public void f(Rect rect, int i10, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void g(Rect rect, View view, RecyclerView recyclerView, z zVar) {
            f(rect, ((LayoutParams) view.getLayoutParams()).a(), recyclerView);
        }

        @Deprecated
        public void h(Canvas canvas, RecyclerView recyclerView) {
        }

        public void i(Canvas canvas, RecyclerView recyclerView, z zVar) {
            h(canvas, recyclerView);
        }

        @Deprecated
        public void j(Canvas canvas, RecyclerView recyclerView) {
        }

        public void k(Canvas canvas, RecyclerView recyclerView, z zVar) {
            j(canvas, recyclerView);
        }
    }

    public static abstract class p {

        /* renamed from: a  reason: collision with root package name */
        f f3351a;

        /* renamed from: b  reason: collision with root package name */
        RecyclerView f3352b;

        /* renamed from: c  reason: collision with root package name */
        private final y.b f3353c;

        /* renamed from: d  reason: collision with root package name */
        private final y.b f3354d;

        /* renamed from: e  reason: collision with root package name */
        y f3355e;

        /* renamed from: f  reason: collision with root package name */
        y f3356f;

        /* renamed from: g  reason: collision with root package name */
        y f3357g;

        /* renamed from: h  reason: collision with root package name */
        boolean f3358h = false;

        /* renamed from: i  reason: collision with root package name */
        boolean f3359i = false;

        /* renamed from: j  reason: collision with root package name */
        boolean f3360j = false;

        /* renamed from: k  reason: collision with root package name */
        private boolean f3361k = true;

        /* renamed from: l  reason: collision with root package name */
        private boolean f3362l = true;

        /* renamed from: m  reason: collision with root package name */
        int f3363m;

        /* renamed from: n  reason: collision with root package name */
        boolean f3364n;

        /* renamed from: o  reason: collision with root package name */
        private int f3365o;

        /* renamed from: p  reason: collision with root package name */
        private int f3366p;

        /* renamed from: q  reason: collision with root package name */
        private int f3367q;

        /* renamed from: r  reason: collision with root package name */
        private int f3368r;

        class a implements y.b {
            a() {
            }

            public View a(int i10) {
                return p.this.W(i10);
            }

            public int b() {
                return p.this.y0() - p.this.getPaddingRight();
            }

            public int c(View view) {
                return p.this.e0(view) - ((LayoutParams) view.getLayoutParams()).leftMargin;
            }

            public int d() {
                return p.this.getPaddingLeft();
            }

            public int e(View view) {
                return p.this.h0(view) + ((LayoutParams) view.getLayoutParams()).rightMargin;
            }
        }

        class b implements y.b {
            b() {
            }

            public View a(int i10) {
                return p.this.W(i10);
            }

            public int b() {
                return p.this.k0() - p.this.getPaddingBottom();
            }

            public int c(View view) {
                return p.this.i0(view) - ((LayoutParams) view.getLayoutParams()).topMargin;
            }

            public int d() {
                return p.this.getPaddingTop();
            }

            public int e(View view) {
                return p.this.c0(view) + ((LayoutParams) view.getLayoutParams()).bottomMargin;
            }
        }

        public interface c {
            void a(int i10, int i11);
        }

        public static class d {

            /* renamed from: a  reason: collision with root package name */
            public int f3371a;

            /* renamed from: b  reason: collision with root package name */
            public int f3372b;

            /* renamed from: c  reason: collision with root package name */
            public boolean f3373c;

            /* renamed from: d  reason: collision with root package name */
            public boolean f3374d;
        }

        public p() {
            a aVar = new a();
            this.f3353c = aVar;
            b bVar = new b();
            this.f3354d = bVar;
            this.f3355e = new y(aVar);
            this.f3356f = new y(bVar);
        }

        private boolean D0(RecyclerView recyclerView, int i10, int i11) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int y02 = y0() - getPaddingRight();
            int k02 = k0() - getPaddingBottom();
            Rect rect = this.f3352b.f3292i;
            d0(focusedChild, rect);
            return rect.left - i10 < y02 && rect.right - i10 > paddingLeft && rect.top - i11 < k02 && rect.bottom - i11 > paddingTop;
        }

        private static boolean H0(int i10, int i11, int i12) {
            int mode = View.MeasureSpec.getMode(i11);
            int size = View.MeasureSpec.getSize(i11);
            if (i12 > 0 && i10 != i12) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i10;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i10;
            }
            return true;
        }

        private void H1(v vVar, int i10, View view) {
            c0 h02 = RecyclerView.h0(view);
            if (!h02.shouldIgnore()) {
                if (!h02.isInvalid() || h02.isRemoved() || this.f3352b.f3298l.hasStableIds()) {
                    L(i10);
                    vVar.D(view);
                    this.f3352b.f3286f.k(h02);
                    return;
                }
                C1(i10);
                vVar.C(h02);
            }
        }

        private void M(int i10, View view) {
            this.f3351a.d(i10);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
            if (r5 == 1073741824) goto L_0x0020;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int Y(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L_0x001a
                if (r7 < 0) goto L_0x0011
                goto L_0x001c
            L_0x0011:
                if (r7 != r1) goto L_0x002f
                if (r5 == r2) goto L_0x0020
                if (r5 == 0) goto L_0x002f
                if (r5 == r3) goto L_0x0020
                goto L_0x002f
            L_0x001a:
                if (r7 < 0) goto L_0x001e
            L_0x001c:
                r5 = r3
                goto L_0x0031
            L_0x001e:
                if (r7 != r1) goto L_0x0022
            L_0x0020:
                r7 = r4
                goto L_0x0031
            L_0x0022:
                if (r7 != r0) goto L_0x002f
                if (r5 == r2) goto L_0x002c
                if (r5 != r3) goto L_0x0029
                goto L_0x002c
            L_0x0029:
                r7 = r4
                r5 = r6
                goto L_0x0031
            L_0x002c:
                r7 = r4
                r5 = r2
                goto L_0x0031
            L_0x002f:
                r5 = r6
                r7 = r5
            L_0x0031:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.p.Y(int, int, int, int, boolean):int");
        }

        private int[] Z(View view, Rect rect) {
            int[] iArr = new int[2];
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int y02 = y0() - getPaddingRight();
            int k02 = k0() - getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = rect.width() + left;
            int height = rect.height() + top;
            int i10 = left - paddingLeft;
            int min = Math.min(0, i10);
            int i11 = top - paddingTop;
            int min2 = Math.min(0, i11);
            int i12 = width - y02;
            int max = Math.max(0, i12);
            int max2 = Math.max(0, height - k02);
            if (n0() != 1) {
                if (min == 0) {
                    min = Math.min(i10, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i12);
            }
            if (min2 == 0) {
                min2 = Math.min(i11, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            return iArr;
        }

        private void q(View view, int i10, boolean z10) {
            c0 h02 = RecyclerView.h0(view);
            if (z10 || h02.isRemoved()) {
                this.f3352b.f3286f.b(h02);
            } else {
                this.f3352b.f3286f.p(h02);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (h02.wasReturnedFromScrap() || h02.isScrap()) {
                if (h02.isScrap()) {
                    h02.unScrap();
                } else {
                    h02.clearReturnedFromScrapFlag();
                }
                this.f3351a.c(view, i10, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f3352b) {
                int m10 = this.f3351a.m(view);
                if (i10 == -1) {
                    i10 = this.f3351a.g();
                }
                if (m10 == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f3352b.indexOfChild(view) + this.f3352b.Q());
                } else if (m10 != i10) {
                    this.f3352b.f3300m.M0(m10, i10);
                }
            } else {
                this.f3351a.a(view, i10, false);
                layoutParams.f3328c = true;
                y yVar = this.f3357g;
                if (yVar != null && yVar.h()) {
                    this.f3357g.k(view);
                }
            }
            if (layoutParams.f3329d) {
                h02.itemView.invalidate();
                layoutParams.f3329d = false;
            }
        }

        public static d s0(Context context, AttributeSet attributeSet, int i10, int i11) {
            d dVar = new d();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p1.d.RecyclerView, i10, i11);
            dVar.f3371a = obtainStyledAttributes.getInt(p1.d.RecyclerView_android_orientation, 1);
            dVar.f3372b = obtainStyledAttributes.getInt(p1.d.RecyclerView_spanCount, 1);
            dVar.f3373c = obtainStyledAttributes.getBoolean(p1.d.RecyclerView_reverseLayout, false);
            dVar.f3374d = obtainStyledAttributes.getBoolean(p1.d.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return dVar;
        }

        public static int z(int i10, int i11, int i12) {
            int mode = View.MeasureSpec.getMode(i10);
            int size = View.MeasureSpec.getSize(i10);
            return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i11, i12) : size : Math.min(size, Math.max(i11, i12));
        }

        public void A(int i10, int i11, z zVar, c cVar) {
        }

        /* access modifiers changed from: package-private */
        public boolean A0() {
            int X = X();
            for (int i10 = 0; i10 < X; i10++) {
                ViewGroup.LayoutParams layoutParams = W(i10).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public boolean A1(Runnable runnable) {
            RecyclerView recyclerView = this.f3352b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void B(int i10, c cVar) {
        }

        public boolean B0() {
            return this.f3359i;
        }

        public void B1(View view) {
            this.f3351a.p(view);
        }

        public int C(z zVar) {
            return 0;
        }

        public boolean C0() {
            return this.f3360j;
        }

        public void C1(int i10) {
            if (W(i10) != null) {
                this.f3351a.q(i10);
            }
        }

        public int D(z zVar) {
            return 0;
        }

        public boolean D1(RecyclerView recyclerView, View view, Rect rect, boolean z10) {
            return E1(recyclerView, view, rect, z10, false);
        }

        public int E(z zVar) {
            return 0;
        }

        public final boolean E0() {
            return this.f3362l;
        }

        public boolean E1(RecyclerView recyclerView, View view, Rect rect, boolean z10, boolean z11) {
            int[] Z = Z(view, rect);
            int i10 = Z[0];
            int i11 = Z[1];
            if ((z11 && !D0(recyclerView, i10, i11)) || (i10 == 0 && i11 == 0)) {
                return false;
            }
            if (z10) {
                recyclerView.scrollBy(i10, i11);
            } else {
                recyclerView.o1(i10, i11);
            }
            return true;
        }

        public int F(z zVar) {
            return 0;
        }

        public boolean F0(v vVar, z zVar) {
            return false;
        }

        public void F1() {
            RecyclerView recyclerView = this.f3352b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public int G(z zVar) {
            return 0;
        }

        public boolean G0() {
            return this.f3361k;
        }

        public void G1() {
            this.f3358h = true;
        }

        public int H(z zVar) {
            return 0;
        }

        public void I(v vVar) {
            for (int X = X() - 1; X >= 0; X--) {
                H1(vVar, X, W(X));
            }
        }

        public boolean I0() {
            y yVar = this.f3357g;
            return yVar != null && yVar.h();
        }

        public int I1(int i10, v vVar, z zVar) {
            return 0;
        }

        public void J(View view, v vVar) {
            H1(vVar, this.f3351a.m(view), view);
        }

        public boolean J0(View view, boolean z10, boolean z11) {
            boolean z12 = this.f3355e.b(view, 24579) && this.f3356f.b(view, 24579);
            return z10 ? z12 : !z12;
        }

        public void J1(int i10) {
        }

        public void K(View view) {
            int m10 = this.f3351a.m(view);
            if (m10 >= 0) {
                M(m10, view);
            }
        }

        public void K0(View view, int i10, int i11, int i12, int i13) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.f3327b;
            view.layout(i10 + rect.left + layoutParams.leftMargin, i11 + rect.top + layoutParams.topMargin, (i12 - rect.right) - layoutParams.rightMargin, (i13 - rect.bottom) - layoutParams.bottomMargin);
        }

        public int K1(int i10, v vVar, z zVar) {
            return 0;
        }

        public void L(int i10) {
            M(i10, W(i10));
        }

        public void L0(View view, int i10, int i11) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect l02 = this.f3352b.l0(view);
            int i12 = i10 + l02.left + l02.right;
            int i13 = i11 + l02.top + l02.bottom;
            int Y = Y(y0(), z0(), getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin + i12, layoutParams.width, w());
            int Y2 = Y(k0(), l0(), getPaddingTop() + getPaddingBottom() + layoutParams.topMargin + layoutParams.bottomMargin + i13, layoutParams.height, x());
            if (R1(view, Y, Y2, layoutParams)) {
                view.measure(Y, Y2);
            }
        }

        /* access modifiers changed from: package-private */
        public void L1(RecyclerView recyclerView) {
            M1(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public void M0(int i10, int i11) {
            View W = W(i10);
            if (W != null) {
                L(i10);
                t(W, i11);
                return;
            }
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i10 + this.f3352b.toString());
        }

        /* access modifiers changed from: package-private */
        public void M1(int i10, int i11) {
            this.f3367q = View.MeasureSpec.getSize(i10);
            int mode = View.MeasureSpec.getMode(i10);
            this.f3365o = mode;
            if (mode == 0 && !RecyclerView.A1) {
                this.f3367q = 0;
            }
            this.f3368r = View.MeasureSpec.getSize(i11);
            int mode2 = View.MeasureSpec.getMode(i11);
            this.f3366p = mode2;
            if (mode2 == 0 && !RecyclerView.A1) {
                this.f3368r = 0;
            }
        }

        /* access modifiers changed from: package-private */
        public void N(RecyclerView recyclerView) {
            this.f3359i = true;
            R0(recyclerView);
        }

        public void N0(int i10) {
            RecyclerView recyclerView = this.f3352b;
            if (recyclerView != null) {
                recyclerView.B0(i10);
            }
        }

        public void N1(int i10, int i11) {
            this.f3352b.setMeasuredDimension(i10, i11);
        }

        /* access modifiers changed from: package-private */
        public void O(RecyclerView recyclerView, v vVar) {
            this.f3359i = false;
            T0(recyclerView, vVar);
        }

        public void O0(int i10) {
            RecyclerView recyclerView = this.f3352b;
            if (recyclerView != null) {
                recyclerView.C0(i10);
            }
        }

        public void O1(Rect rect, int i10, int i11) {
            N1(z(i10, rect.width() + getPaddingLeft() + getPaddingRight(), q0()), z(i11, rect.height() + getPaddingTop() + getPaddingBottom(), p0()));
        }

        public View P(View view) {
            View T;
            RecyclerView recyclerView = this.f3352b;
            if (recyclerView == null || (T = recyclerView.T(view)) == null || this.f3351a.n(T)) {
                return null;
            }
            return T;
        }

        public void P0(h hVar, h hVar2) {
        }

        /* access modifiers changed from: package-private */
        public void P1(int i10, int i11) {
            int X = X();
            if (X == 0) {
                this.f3352b.x(i10, i11);
                return;
            }
            int i12 = Integer.MIN_VALUE;
            int i13 = Integer.MAX_VALUE;
            int i14 = Integer.MAX_VALUE;
            int i15 = Integer.MIN_VALUE;
            for (int i16 = 0; i16 < X; i16++) {
                View W = W(i16);
                Rect rect = this.f3352b.f3292i;
                d0(W, rect);
                int i17 = rect.left;
                if (i17 < i13) {
                    i13 = i17;
                }
                int i18 = rect.right;
                if (i18 > i12) {
                    i12 = i18;
                }
                int i19 = rect.top;
                if (i19 < i14) {
                    i14 = i19;
                }
                int i20 = rect.bottom;
                if (i20 > i15) {
                    i15 = i20;
                }
            }
            this.f3352b.f3292i.set(i13, i14, i12, i15);
            O1(this.f3352b.f3292i, i10, i11);
        }

        public View Q(int i10) {
            int X = X();
            for (int i11 = 0; i11 < X; i11++) {
                View W = W(i11);
                c0 h02 = RecyclerView.h0(W);
                if (h02 != null && h02.getLayoutPosition() == i10 && !h02.shouldIgnore() && (this.f3352b.f3285e1.f() || !h02.isRemoved())) {
                    return W;
                }
            }
            return null;
        }

        public boolean Q0(RecyclerView recyclerView, ArrayList<View> arrayList, int i10, int i11) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public void Q1(RecyclerView recyclerView) {
            int i10;
            if (recyclerView == null) {
                this.f3352b = null;
                this.f3351a = null;
                i10 = 0;
                this.f3367q = 0;
            } else {
                this.f3352b = recyclerView;
                this.f3351a = recyclerView.f3284e;
                this.f3367q = recyclerView.getWidth();
                i10 = recyclerView.getHeight();
            }
            this.f3368r = i10;
            this.f3365o = 1073741824;
            this.f3366p = 1073741824;
        }

        public abstract LayoutParams R();

        public void R0(RecyclerView recyclerView) {
        }

        /* access modifiers changed from: package-private */
        public boolean R1(View view, int i10, int i11, LayoutParams layoutParams) {
            return view.isLayoutRequested() || !this.f3361k || !H0(view.getWidth(), i10, layoutParams.width) || !H0(view.getHeight(), i11, layoutParams.height);
        }

        public LayoutParams S(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        @Deprecated
        public void S0(RecyclerView recyclerView) {
        }

        /* access modifiers changed from: package-private */
        public boolean S1() {
            return false;
        }

        public LayoutParams T(ViewGroup.LayoutParams layoutParams) {
            return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
        }

        public void T0(RecyclerView recyclerView, v vVar) {
            S0(recyclerView);
        }

        /* access modifiers changed from: package-private */
        public boolean T1(View view, int i10, int i11, LayoutParams layoutParams) {
            return !this.f3361k || !H0(view.getMeasuredWidth(), i10, layoutParams.width) || !H0(view.getMeasuredHeight(), i11, layoutParams.height);
        }

        public int U() {
            return -1;
        }

        public View U0(View view, int i10, v vVar, z zVar) {
            return null;
        }

        public void U1(RecyclerView recyclerView, z zVar, int i10) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public int V(View view) {
            return ((LayoutParams) view.getLayoutParams()).f3327b.bottom;
        }

        public void V0(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f3352b;
            W0(recyclerView.f3276b, recyclerView.f3285e1, accessibilityEvent);
        }

        public void V1(y yVar) {
            y yVar2 = this.f3357g;
            if (!(yVar2 == null || yVar == yVar2 || !yVar2.h())) {
                this.f3357g.r();
            }
            this.f3357g = yVar;
            yVar.q(this.f3352b, this);
        }

        public View W(int i10) {
            f fVar = this.f3351a;
            if (fVar != null) {
                return fVar.f(i10);
            }
            return null;
        }

        public void W0(v vVar, z zVar, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f3352b;
            if (recyclerView != null && accessibilityEvent != null) {
                boolean z10 = true;
                if (!recyclerView.canScrollVertically(1) && !this.f3352b.canScrollVertically(-1) && !this.f3352b.canScrollHorizontally(-1) && !this.f3352b.canScrollHorizontally(1)) {
                    z10 = false;
                }
                accessibilityEvent.setScrollable(z10);
                h hVar = this.f3352b.f3298l;
                if (hVar != null) {
                    accessibilityEvent.setItemCount(hVar.getItemCount());
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void W1() {
            y yVar = this.f3357g;
            if (yVar != null) {
                yVar.r();
            }
        }

        public int X() {
            f fVar = this.f3351a;
            if (fVar != null) {
                return fVar.g();
            }
            return 0;
        }

        public void X0(v vVar, z zVar, x0.c cVar) {
            if (this.f3352b.canScrollVertically(-1) || this.f3352b.canScrollHorizontally(-1)) {
                cVar.a(8192);
                cVar.y0(true);
            }
            if (this.f3352b.canScrollVertically(1) || this.f3352b.canScrollHorizontally(1)) {
                cVar.a(m.FLAG_APPEARED_IN_PRE_LAYOUT);
                cVar.y0(true);
            }
            cVar.e0(c.b.b(u0(vVar, zVar), b0(vVar, zVar), F0(vVar, zVar), v0(vVar, zVar)));
        }

        public boolean X1() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public void Y0(x0.c cVar) {
            RecyclerView recyclerView = this.f3352b;
            X0(recyclerView.f3276b, recyclerView.f3285e1, cVar);
        }

        /* access modifiers changed from: package-private */
        public void Z0(View view, x0.c cVar) {
            c0 h02 = RecyclerView.h0(view);
            if (h02 != null && !h02.isRemoved() && !this.f3351a.n(h02.itemView)) {
                RecyclerView recyclerView = this.f3352b;
                a1(recyclerView.f3276b, recyclerView.f3285e1, view, cVar);
            }
        }

        public boolean a0() {
            RecyclerView recyclerView = this.f3352b;
            return recyclerView != null && recyclerView.f3288g;
        }

        public void a1(v vVar, z zVar, View view, x0.c cVar) {
        }

        public int b0(v vVar, z zVar) {
            return -1;
        }

        public View b1(View view, int i10) {
            return null;
        }

        public int c0(View view) {
            return view.getBottom() + V(view);
        }

        public void c1(RecyclerView recyclerView, int i10, int i11) {
        }

        public void d0(View view, Rect rect) {
            RecyclerView.i0(view, rect);
        }

        public void d1(RecyclerView recyclerView) {
        }

        public int e0(View view) {
            return view.getLeft() - o0(view);
        }

        public void e1(RecyclerView recyclerView, int i10, int i11, int i12) {
        }

        public int f0(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f3327b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void f1(RecyclerView recyclerView, int i10, int i11) {
        }

        public int g0(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f3327b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public void g1(RecyclerView recyclerView, int i10, int i11) {
        }

        public int getPaddingBottom() {
            RecyclerView recyclerView = this.f3352b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int getPaddingEnd() {
            RecyclerView recyclerView = this.f3352b;
            if (recyclerView != null) {
                return androidx.core.view.x.H(recyclerView);
            }
            return 0;
        }

        public int getPaddingLeft() {
            RecyclerView recyclerView = this.f3352b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int getPaddingRight() {
            RecyclerView recyclerView = this.f3352b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int getPaddingStart() {
            RecyclerView recyclerView = this.f3352b;
            if (recyclerView != null) {
                return androidx.core.view.x.I(recyclerView);
            }
            return 0;
        }

        public int getPaddingTop() {
            RecyclerView recyclerView = this.f3352b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int h0(View view) {
            return view.getRight() + t0(view);
        }

        public void h1(RecyclerView recyclerView, int i10, int i11, Object obj) {
            g1(recyclerView, i10, i11);
        }

        public int i0(View view) {
            return view.getTop() - w0(view);
        }

        public void i1(v vVar, z zVar) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public View j0() {
            View focusedChild;
            RecyclerView recyclerView = this.f3352b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.f3351a.n(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public void j1(z zVar) {
        }

        public int k0() {
            return this.f3368r;
        }

        public void k1(v vVar, z zVar, int i10, int i11) {
            this.f3352b.x(i10, i11);
        }

        public int l0() {
            return this.f3366p;
        }

        @Deprecated
        public boolean l1(RecyclerView recyclerView, View view, View view2) {
            return I0() || recyclerView.v0();
        }

        public void m(View view) {
            n(view, -1);
        }

        public int m0() {
            RecyclerView recyclerView = this.f3352b;
            h adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public boolean m1(RecyclerView recyclerView, z zVar, View view, View view2) {
            return l1(recyclerView, view, view2);
        }

        public void n(View view, int i10) {
            q(view, i10, true);
        }

        public int n0() {
            return androidx.core.view.x.C(this.f3352b);
        }

        public void n1(Parcelable parcelable) {
        }

        public void o(View view) {
            p(view, -1);
        }

        public int o0(View view) {
            return ((LayoutParams) view.getLayoutParams()).f3327b.left;
        }

        public Parcelable o1() {
            return null;
        }

        public void p(View view, int i10) {
            q(view, i10, false);
        }

        public int p0() {
            return androidx.core.view.x.D(this.f3352b);
        }

        public void p1(int i10) {
        }

        public int q0() {
            return androidx.core.view.x.E(this.f3352b);
        }

        /* access modifiers changed from: package-private */
        public void q1(y yVar) {
            if (this.f3357g == yVar) {
                this.f3357g = null;
            }
        }

        public void r(String str) {
            RecyclerView recyclerView = this.f3352b;
            if (recyclerView != null) {
                recyclerView.p(str);
            }
        }

        public int r0(View view) {
            return ((LayoutParams) view.getLayoutParams()).a();
        }

        /* access modifiers changed from: package-private */
        public boolean r1(int i10, Bundle bundle) {
            RecyclerView recyclerView = this.f3352b;
            return s1(recyclerView.f3276b, recyclerView.f3285e1, i10, bundle);
        }

        public void s(View view) {
            t(view, -1);
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x0075 A[ADDED_TO_REGION] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean s1(androidx.recyclerview.widget.RecyclerView.v r8, androidx.recyclerview.widget.RecyclerView.z r9, int r10, android.os.Bundle r11) {
            /*
                r7 = this;
                androidx.recyclerview.widget.RecyclerView r8 = r7.f3352b
                r9 = 0
                if (r8 != 0) goto L_0x0006
                return r9
            L_0x0006:
                r11 = 4096(0x1000, float:5.74E-42)
                r0 = 1
                if (r10 == r11) goto L_0x0042
                r11 = 8192(0x2000, float:1.14794E-41)
                if (r10 == r11) goto L_0x0012
                r2 = r9
                r3 = r2
                goto L_0x0073
            L_0x0012:
                r10 = -1
                boolean r8 = r8.canScrollVertically(r10)
                if (r8 == 0) goto L_0x0029
                int r8 = r7.k0()
                int r11 = r7.getPaddingTop()
                int r8 = r8 - r11
                int r11 = r7.getPaddingBottom()
                int r8 = r8 - r11
                int r8 = -r8
                goto L_0x002a
            L_0x0029:
                r8 = r9
            L_0x002a:
                androidx.recyclerview.widget.RecyclerView r11 = r7.f3352b
                boolean r10 = r11.canScrollHorizontally(r10)
                if (r10 == 0) goto L_0x0071
                int r10 = r7.y0()
                int r11 = r7.getPaddingLeft()
                int r10 = r10 - r11
                int r11 = r7.getPaddingRight()
                int r10 = r10 - r11
                int r10 = -r10
                goto L_0x006e
            L_0x0042:
                boolean r8 = r8.canScrollVertically(r0)
                if (r8 == 0) goto L_0x0057
                int r8 = r7.k0()
                int r10 = r7.getPaddingTop()
                int r8 = r8 - r10
                int r10 = r7.getPaddingBottom()
                int r8 = r8 - r10
                goto L_0x0058
            L_0x0057:
                r8 = r9
            L_0x0058:
                androidx.recyclerview.widget.RecyclerView r10 = r7.f3352b
                boolean r10 = r10.canScrollHorizontally(r0)
                if (r10 == 0) goto L_0x0071
                int r10 = r7.y0()
                int r11 = r7.getPaddingLeft()
                int r10 = r10 - r11
                int r11 = r7.getPaddingRight()
                int r10 = r10 - r11
            L_0x006e:
                r3 = r8
                r2 = r10
                goto L_0x0073
            L_0x0071:
                r3 = r8
                r2 = r9
            L_0x0073:
                if (r3 != 0) goto L_0x0078
                if (r2 != 0) goto L_0x0078
                return r9
            L_0x0078:
                androidx.recyclerview.widget.RecyclerView r1 = r7.f3352b
                r4 = 0
                r5 = -2147483648(0xffffffff80000000, float:-0.0)
                r6 = 1
                r1.r1(r2, r3, r4, r5, r6)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.p.s1(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$z, int, android.os.Bundle):boolean");
        }

        public void t(View view, int i10) {
            u(view, i10, (LayoutParams) view.getLayoutParams());
        }

        public int t0(View view) {
            return ((LayoutParams) view.getLayoutParams()).f3327b.right;
        }

        /* access modifiers changed from: package-private */
        public boolean t1(View view, int i10, Bundle bundle) {
            RecyclerView recyclerView = this.f3352b;
            return u1(recyclerView.f3276b, recyclerView.f3285e1, view, i10, bundle);
        }

        public void u(View view, int i10, LayoutParams layoutParams) {
            c0 h02 = RecyclerView.h0(view);
            if (h02.isRemoved()) {
                this.f3352b.f3286f.b(h02);
            } else {
                this.f3352b.f3286f.p(h02);
            }
            this.f3351a.c(view, i10, layoutParams, h02.isRemoved());
        }

        public int u0(v vVar, z zVar) {
            return -1;
        }

        public boolean u1(v vVar, z zVar, View view, int i10, Bundle bundle) {
            return false;
        }

        public void v(View view, Rect rect) {
            RecyclerView recyclerView = this.f3352b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.l0(view));
            }
        }

        public int v0(v vVar, z zVar) {
            return 0;
        }

        public void v1() {
            for (int X = X() - 1; X >= 0; X--) {
                this.f3351a.q(X);
            }
        }

        public boolean w() {
            return false;
        }

        public int w0(View view) {
            return ((LayoutParams) view.getLayoutParams()).f3327b.top;
        }

        public void w1(v vVar) {
            for (int X = X() - 1; X >= 0; X--) {
                if (!RecyclerView.h0(W(X)).shouldIgnore()) {
                    z1(X, vVar);
                }
            }
        }

        public boolean x() {
            return false;
        }

        public void x0(View view, boolean z10, Rect rect) {
            Matrix matrix;
            if (z10) {
                Rect rect2 = ((LayoutParams) view.getLayoutParams()).f3327b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (!(this.f3352b == null || (matrix = view.getMatrix()) == null || matrix.isIdentity())) {
                RectF rectF = this.f3352b.f3296k;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        /* access modifiers changed from: package-private */
        public void x1(v vVar) {
            int j10 = vVar.j();
            for (int i10 = j10 - 1; i10 >= 0; i10--) {
                View n10 = vVar.n(i10);
                c0 h02 = RecyclerView.h0(n10);
                if (!h02.shouldIgnore()) {
                    h02.setIsRecyclable(false);
                    if (h02.isTmpDetached()) {
                        this.f3352b.removeDetachedView(n10, false);
                    }
                    m mVar = this.f3352b.N;
                    if (mVar != null) {
                        mVar.endAnimation(h02);
                    }
                    h02.setIsRecyclable(true);
                    vVar.y(n10);
                }
            }
            vVar.e();
            if (j10 > 0) {
                this.f3352b.invalidate();
            }
        }

        public boolean y(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        public int y0() {
            return this.f3367q;
        }

        public void y1(View view, v vVar) {
            B1(view);
            vVar.B(view);
        }

        public int z0() {
            return this.f3365o;
        }

        public void z1(int i10, v vVar) {
            View W = W(i10);
            C1(i10);
            vVar.B(W);
        }
    }

    public interface q {
        void b(View view);

        void d(View view);
    }

    public static abstract class r {
        public abstract boolean a(int i10, int i11);
    }

    public interface s {
        boolean a(RecyclerView recyclerView, MotionEvent motionEvent);

        void c(RecyclerView recyclerView, MotionEvent motionEvent);

        void e(boolean z10);
    }

    public static abstract class t {
        public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
        }

        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
        }
    }

    public static class u {

        /* renamed from: a  reason: collision with root package name */
        SparseArray<a> f3375a = new SparseArray<>();

        /* renamed from: b  reason: collision with root package name */
        private int f3376b = 0;

        static class a {

            /* renamed from: a  reason: collision with root package name */
            final ArrayList<c0> f3377a = new ArrayList<>();

            /* renamed from: b  reason: collision with root package name */
            int f3378b = 5;

            /* renamed from: c  reason: collision with root package name */
            long f3379c = 0;

            /* renamed from: d  reason: collision with root package name */
            long f3380d = 0;

            a() {
            }
        }

        private a g(int i10) {
            a aVar = this.f3375a.get(i10);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.f3375a.put(i10, aVar2);
            return aVar2;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f3376b++;
        }

        public void b() {
            for (int i10 = 0; i10 < this.f3375a.size(); i10++) {
                this.f3375a.valueAt(i10).f3377a.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.f3376b--;
        }

        /* access modifiers changed from: package-private */
        public void d(int i10, long j10) {
            a g10 = g(i10);
            g10.f3380d = j(g10.f3380d, j10);
        }

        /* access modifiers changed from: package-private */
        public void e(int i10, long j10) {
            a g10 = g(i10);
            g10.f3379c = j(g10.f3379c, j10);
        }

        public c0 f(int i10) {
            a aVar = this.f3375a.get(i10);
            if (aVar == null || aVar.f3377a.isEmpty()) {
                return null;
            }
            ArrayList<c0> arrayList = aVar.f3377a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!arrayList.get(size).isAttachedToTransitionOverlay()) {
                    return arrayList.remove(size);
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public void h(h hVar, h hVar2, boolean z10) {
            if (hVar != null) {
                c();
            }
            if (!z10 && this.f3376b == 0) {
                b();
            }
            if (hVar2 != null) {
                a();
            }
        }

        public void i(c0 c0Var) {
            int itemViewType = c0Var.getItemViewType();
            ArrayList<c0> arrayList = g(itemViewType).f3377a;
            if (this.f3375a.get(itemViewType).f3378b > arrayList.size()) {
                c0Var.resetInternal();
                arrayList.add(c0Var);
            }
        }

        /* access modifiers changed from: package-private */
        public long j(long j10, long j11) {
            return j10 == 0 ? j11 : ((j10 / 4) * 3) + (j11 / 4);
        }

        /* access modifiers changed from: package-private */
        public boolean k(int i10, long j10, long j11) {
            long j12 = g(i10).f3380d;
            return j12 == 0 || j10 + j12 < j11;
        }

        /* access modifiers changed from: package-private */
        public boolean l(int i10, long j10, long j11) {
            long j12 = g(i10).f3379c;
            return j12 == 0 || j10 + j12 < j11;
        }
    }

    public final class v {

        /* renamed from: a  reason: collision with root package name */
        final ArrayList<c0> f3381a;

        /* renamed from: b  reason: collision with root package name */
        ArrayList<c0> f3382b = null;

        /* renamed from: c  reason: collision with root package name */
        final ArrayList<c0> f3383c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        private final List<c0> f3384d;

        /* renamed from: e  reason: collision with root package name */
        private int f3385e;

        /* renamed from: f  reason: collision with root package name */
        int f3386f;

        /* renamed from: g  reason: collision with root package name */
        u f3387g;

        public v() {
            ArrayList<c0> arrayList = new ArrayList<>();
            this.f3381a = arrayList;
            this.f3384d = Collections.unmodifiableList(arrayList);
            this.f3385e = 2;
            this.f3386f = 2;
        }

        private boolean H(c0 c0Var, int i10, int i11, long j10) {
            c0Var.mBindingAdapter = null;
            c0Var.mOwnerRecyclerView = RecyclerView.this;
            int itemViewType = c0Var.getItemViewType();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j10 != Long.MAX_VALUE && !this.f3387g.k(itemViewType, nanoTime, j10)) {
                return false;
            }
            RecyclerView.this.f3298l.bindViewHolder(c0Var, i10);
            this.f3387g.d(c0Var.getItemViewType(), RecyclerView.this.getNanoTime() - nanoTime);
            b(c0Var);
            if (!RecyclerView.this.f3285e1.f()) {
                return true;
            }
            c0Var.mPreLayoutPosition = i11;
            return true;
        }

        private void b(c0 c0Var) {
            if (RecyclerView.this.u0()) {
                View view = c0Var.itemView;
                if (androidx.core.view.x.A(view) == 0) {
                    androidx.core.view.x.B0(view, 1);
                }
                u uVar = RecyclerView.this.f3299l1;
                if (uVar != null) {
                    androidx.core.view.a n10 = uVar.n();
                    if (n10 instanceof u.a) {
                        ((u.a) n10).o(view);
                    }
                    androidx.core.view.x.r0(view, n10);
                }
            }
        }

        private void q(ViewGroup viewGroup, boolean z10) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    q((ViewGroup) childAt, true);
                }
            }
            if (z10) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                    return;
                }
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }

        private void r(c0 c0Var) {
            View view = c0Var.itemView;
            if (view instanceof ViewGroup) {
                q((ViewGroup) view, false);
            }
        }

        /* access modifiers changed from: package-private */
        public void A(int i10) {
            a(this.f3383c.get(i10), true);
            this.f3383c.remove(i10);
        }

        public void B(View view) {
            c0 h02 = RecyclerView.h0(view);
            if (h02.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (h02.isScrap()) {
                h02.unScrap();
            } else if (h02.wasReturnedFromScrap()) {
                h02.clearReturnedFromScrapFlag();
            }
            C(h02);
            if (RecyclerView.this.N != null && !h02.isRecyclable()) {
                RecyclerView.this.N.endAnimation(h02);
            }
        }

        /* access modifiers changed from: package-private */
        public void C(c0 c0Var) {
            boolean z10;
            boolean z11 = false;
            boolean z12 = true;
            if (c0Var.isScrap() || c0Var.itemView.getParent() != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Scrapped or attached views may not be recycled. isScrap:");
                sb2.append(c0Var.isScrap());
                sb2.append(" isAttached:");
                if (c0Var.itemView.getParent() != null) {
                    z11 = true;
                }
                sb2.append(z11);
                sb2.append(RecyclerView.this.Q());
                throw new IllegalArgumentException(sb2.toString());
            } else if (c0Var.isTmpDetached()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + c0Var + RecyclerView.this.Q());
            } else if (!c0Var.shouldIgnore()) {
                boolean doesTransientStatePreventRecycling = c0Var.doesTransientStatePreventRecycling();
                h hVar = RecyclerView.this.f3298l;
                if ((hVar != null && doesTransientStatePreventRecycling && hVar.onFailedToRecycleView(c0Var)) || c0Var.isRecyclable()) {
                    if (this.f3386f <= 0 || c0Var.hasAnyOfTheFlags(526)) {
                        z10 = false;
                    } else {
                        int size = this.f3383c.size();
                        if (size >= this.f3386f && size > 0) {
                            A(0);
                            size--;
                        }
                        if (RecyclerView.C1 && size > 0 && !RecyclerView.this.f3283d1.d(c0Var.mPosition)) {
                            int i10 = size - 1;
                            while (i10 >= 0) {
                                if (!RecyclerView.this.f3283d1.d(this.f3383c.get(i10).mPosition)) {
                                    break;
                                }
                                i10--;
                            }
                            size = i10 + 1;
                        }
                        this.f3383c.add(size, c0Var);
                        z10 = true;
                    }
                    if (!z10) {
                        a(c0Var, true);
                    } else {
                        z12 = false;
                    }
                    z11 = z10;
                } else {
                    z12 = false;
                }
                RecyclerView.this.f3286f.q(c0Var);
                if (!z11 && !z12 && doesTransientStatePreventRecycling) {
                    c0Var.mBindingAdapter = null;
                    c0Var.mOwnerRecyclerView = null;
                }
            } else {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.Q());
            }
        }

        /* access modifiers changed from: package-private */
        public void D(View view) {
            ArrayList<c0> arrayList;
            c0 h02 = RecyclerView.h0(view);
            if (!h02.hasAnyOfTheFlags(12) && h02.isUpdated() && !RecyclerView.this.q(h02)) {
                if (this.f3382b == null) {
                    this.f3382b = new ArrayList<>();
                }
                h02.setScrapContainer(this, true);
                arrayList = this.f3382b;
            } else if (!h02.isInvalid() || h02.isRemoved() || RecyclerView.this.f3298l.hasStableIds()) {
                h02.setScrapContainer(this, false);
                arrayList = this.f3381a;
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.Q());
            }
            arrayList.add(h02);
        }

        /* access modifiers changed from: package-private */
        public void E(u uVar) {
            u uVar2 = this.f3387g;
            if (uVar2 != null) {
                uVar2.c();
            }
            this.f3387g = uVar;
            if (uVar != null && RecyclerView.this.getAdapter() != null) {
                this.f3387g.a();
            }
        }

        /* access modifiers changed from: package-private */
        public void F(a0 a0Var) {
        }

        public void G(int i10) {
            this.f3385e = i10;
            K();
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x005f  */
        /* JADX WARNING: Removed duplicated region for block: B:66:0x014d  */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x0176  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x0179  */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x01a9  */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x01b7  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.recyclerview.widget.RecyclerView.c0 I(int r17, boolean r18, long r19) {
            /*
                r16 = this;
                r6 = r16
                r3 = r17
                r0 = r18
                if (r3 < 0) goto L_0x01d3
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$z r1 = r1.f3285e1
                int r1 = r1.b()
                if (r3 >= r1) goto L_0x01d3
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$z r1 = r1.f3285e1
                boolean r1 = r1.f()
                r2 = 0
                r7 = 1
                r8 = 0
                if (r1 == 0) goto L_0x0027
                androidx.recyclerview.widget.RecyclerView$c0 r1 = r16.h(r17)
                if (r1 == 0) goto L_0x0028
                r4 = r7
                goto L_0x0029
            L_0x0027:
                r1 = r2
            L_0x0028:
                r4 = r8
            L_0x0029:
                if (r1 != 0) goto L_0x005d
                androidx.recyclerview.widget.RecyclerView$c0 r1 = r16.m(r17, r18)
                if (r1 == 0) goto L_0x005d
                boolean r5 = r6.L(r1)
                if (r5 != 0) goto L_0x005c
                if (r0 != 0) goto L_0x005a
                r5 = 4
                r1.addFlags(r5)
                boolean r5 = r1.isScrap()
                if (r5 == 0) goto L_0x004e
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                android.view.View r9 = r1.itemView
                r5.removeDetachedView(r9, r8)
                r1.unScrap()
                goto L_0x0057
            L_0x004e:
                boolean r5 = r1.wasReturnedFromScrap()
                if (r5 == 0) goto L_0x0057
                r1.clearReturnedFromScrapFlag()
            L_0x0057:
                r6.C(r1)
            L_0x005a:
                r1 = r2
                goto L_0x005d
            L_0x005c:
                r4 = r7
            L_0x005d:
                if (r1 != 0) goto L_0x012c
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.a r5 = r5.f3282d
                int r5 = r5.m(r3)
                if (r5 < 0) goto L_0x00f4
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$h r9 = r9.f3298l
                int r9 = r9.getItemCount()
                if (r5 >= r9) goto L_0x00f4
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$h r9 = r9.f3298l
                int r9 = r9.getItemViewType(r5)
                androidx.recyclerview.widget.RecyclerView r10 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$h r10 = r10.f3298l
                boolean r10 = r10.hasStableIds()
                if (r10 == 0) goto L_0x0096
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$h r1 = r1.f3298l
                long r10 = r1.getItemId(r5)
                androidx.recyclerview.widget.RecyclerView$c0 r1 = r6.l(r10, r9, r0)
                if (r1 == 0) goto L_0x0096
                r1.mPosition = r5
                r4 = r7
            L_0x0096:
                if (r1 != 0) goto L_0x00ad
                androidx.recyclerview.widget.RecyclerView$u r0 = r16.i()
                androidx.recyclerview.widget.RecyclerView$c0 r0 = r0.f(r9)
                if (r0 == 0) goto L_0x00ac
                r0.resetInternal()
                boolean r1 = androidx.recyclerview.widget.RecyclerView.f3272z1
                if (r1 == 0) goto L_0x00ac
                r6.r(r0)
            L_0x00ac:
                r1 = r0
            L_0x00ad:
                if (r1 != 0) goto L_0x012c
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                long r0 = r0.getNanoTime()
                r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r5 = (r19 > r10 ? 1 : (r19 == r10 ? 0 : -1))
                if (r5 == 0) goto L_0x00cb
                androidx.recyclerview.widget.RecyclerView$u r10 = r6.f3387g
                r11 = r9
                r12 = r0
                r14 = r19
                boolean r5 = r10.l(r11, r12, r14)
                if (r5 != 0) goto L_0x00cb
                return r2
            L_0x00cb:
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$h r5 = r2.f3298l
                androidx.recyclerview.widget.RecyclerView$c0 r2 = r5.createViewHolder(r2, r9)
                boolean r5 = androidx.recyclerview.widget.RecyclerView.C1
                if (r5 == 0) goto L_0x00e6
                android.view.View r5 = r2.itemView
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.X(r5)
                if (r5 == 0) goto L_0x00e6
                java.lang.ref.WeakReference r10 = new java.lang.ref.WeakReference
                r10.<init>(r5)
                r2.mNestedRecyclerView = r10
            L_0x00e6:
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                long r10 = r5.getNanoTime()
                androidx.recyclerview.widget.RecyclerView$u r5 = r6.f3387g
                long r10 = r10 - r0
                r5.e(r9, r10)
                r9 = r2
                goto L_0x012d
            L_0x00f4:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Inconsistency detected. Invalid item position "
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "(offset:"
                r1.append(r2)
                r1.append(r5)
                java.lang.String r2 = ").state:"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$z r2 = r2.f3285e1
                int r2 = r2.b()
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.Q()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x012c:
                r9 = r1
            L_0x012d:
                r10 = r4
                if (r10 == 0) goto L_0x0166
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$z r0 = r0.f3285e1
                boolean r0 = r0.f()
                if (r0 != 0) goto L_0x0166
                r0 = 8192(0x2000, float:1.14794E-41)
                boolean r1 = r9.hasAnyOfTheFlags(r0)
                if (r1 == 0) goto L_0x0166
                r9.setFlags(r8, r0)
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$z r0 = r0.f3285e1
                boolean r0 = r0.f3415k
                if (r0 == 0) goto L_0x0166
                int r0 = androidx.recyclerview.widget.RecyclerView.m.buildAdapterChangeFlagsForAnimations(r9)
                r0 = r0 | 4096(0x1000, float:5.74E-42)
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$m r2 = r1.N
                androidx.recyclerview.widget.RecyclerView$z r1 = r1.f3285e1
                java.util.List r4 = r9.getUnmodifiedPayloads()
                androidx.recyclerview.widget.RecyclerView$m$c r0 = r2.recordPreLayoutInformation(r1, r9, r0, r4)
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                r1.T0(r9, r0)
            L_0x0166:
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$z r0 = r0.f3285e1
                boolean r0 = r0.f()
                if (r0 == 0) goto L_0x0179
                boolean r0 = r9.isBound()
                if (r0 == 0) goto L_0x0179
                r9.mPreLayoutPosition = r3
                goto L_0x018c
            L_0x0179:
                boolean r0 = r9.isBound()
                if (r0 == 0) goto L_0x018e
                boolean r0 = r9.needsUpdate()
                if (r0 != 0) goto L_0x018e
                boolean r0 = r9.isInvalid()
                if (r0 == 0) goto L_0x018c
                goto L_0x018e
            L_0x018c:
                r0 = r8
                goto L_0x01a1
            L_0x018e:
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.a r0 = r0.f3282d
                int r2 = r0.m(r3)
                r0 = r16
                r1 = r9
                r3 = r17
                r4 = r19
                boolean r0 = r0.H(r1, r2, r3, r4)
            L_0x01a1:
                android.view.View r1 = r9.itemView
                android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
                if (r1 != 0) goto L_0x01b7
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r1 = r1.generateDefaultLayoutParams()
            L_0x01af:
                androidx.recyclerview.widget.RecyclerView$LayoutParams r1 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r1
                android.view.View r2 = r9.itemView
                r2.setLayoutParams(r1)
                goto L_0x01c8
            L_0x01b7:
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                boolean r2 = r2.checkLayoutParams(r1)
                if (r2 != 0) goto L_0x01c6
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r1 = r2.generateLayoutParams((android.view.ViewGroup.LayoutParams) r1)
                goto L_0x01af
            L_0x01c6:
                androidx.recyclerview.widget.RecyclerView$LayoutParams r1 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r1
            L_0x01c8:
                r1.f3326a = r9
                if (r10 == 0) goto L_0x01cf
                if (r0 == 0) goto L_0x01cf
                goto L_0x01d0
            L_0x01cf:
                r7 = r8
            L_0x01d0:
                r1.f3329d = r7
                return r9
            L_0x01d3:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Invalid item position "
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "("
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "). Item count:"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$z r2 = r2.f3285e1
                int r2 = r2.b()
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.Q()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.v.I(int, boolean, long):androidx.recyclerview.widget.RecyclerView$c0");
        }

        /* access modifiers changed from: package-private */
        public void J(c0 c0Var) {
            (c0Var.mInChangeScrap ? this.f3382b : this.f3381a).remove(c0Var);
            c0Var.mScrapContainer = null;
            c0Var.mInChangeScrap = false;
            c0Var.clearReturnedFromScrapFlag();
        }

        /* access modifiers changed from: package-private */
        public void K() {
            p pVar = RecyclerView.this.f3300m;
            this.f3386f = this.f3385e + (pVar != null ? pVar.f3363m : 0);
            for (int size = this.f3383c.size() - 1; size >= 0 && this.f3383c.size() > this.f3386f; size--) {
                A(size);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean L(c0 c0Var) {
            if (c0Var.isRemoved()) {
                return RecyclerView.this.f3285e1.f();
            }
            int i10 = c0Var.mPosition;
            if (i10 < 0 || i10 >= RecyclerView.this.f3298l.getItemCount()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + c0Var + RecyclerView.this.Q());
            } else if (!RecyclerView.this.f3285e1.f() && RecyclerView.this.f3298l.getItemViewType(c0Var.mPosition) != c0Var.getItemViewType()) {
                return false;
            } else {
                if (RecyclerView.this.f3298l.hasStableIds()) {
                    return c0Var.getItemId() == RecyclerView.this.f3298l.getItemId(c0Var.mPosition);
                }
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public void M(int i10, int i11) {
            int i12;
            int i13 = i11 + i10;
            for (int size = this.f3383c.size() - 1; size >= 0; size--) {
                c0 c0Var = this.f3383c.get(size);
                if (c0Var != null && (i12 = c0Var.mPosition) >= i10 && i12 < i13) {
                    c0Var.addFlags(2);
                    A(size);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(c0 c0Var, boolean z10) {
            RecyclerView.s(c0Var);
            View view = c0Var.itemView;
            u uVar = RecyclerView.this.f3299l1;
            if (uVar != null) {
                androidx.core.view.a n10 = uVar.n();
                androidx.core.view.x.r0(view, n10 instanceof u.a ? ((u.a) n10).n(view) : null);
            }
            if (z10) {
                g(c0Var);
            }
            c0Var.mBindingAdapter = null;
            c0Var.mOwnerRecyclerView = null;
            i().i(c0Var);
        }

        public void c() {
            this.f3381a.clear();
            z();
        }

        /* access modifiers changed from: package-private */
        public void d() {
            int size = this.f3383c.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f3383c.get(i10).clearOldPosition();
            }
            int size2 = this.f3381a.size();
            for (int i11 = 0; i11 < size2; i11++) {
                this.f3381a.get(i11).clearOldPosition();
            }
            ArrayList<c0> arrayList = this.f3382b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i12 = 0; i12 < size3; i12++) {
                    this.f3382b.get(i12).clearOldPosition();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void e() {
            this.f3381a.clear();
            ArrayList<c0> arrayList = this.f3382b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public int f(int i10) {
            if (i10 >= 0 && i10 < RecyclerView.this.f3285e1.b()) {
                return !RecyclerView.this.f3285e1.f() ? i10 : RecyclerView.this.f3282d.m(i10);
            }
            throw new IndexOutOfBoundsException("invalid position " + i10 + ". State item count is " + RecyclerView.this.f3285e1.b() + RecyclerView.this.Q());
        }

        /* access modifiers changed from: package-private */
        public void g(c0 c0Var) {
            w wVar = RecyclerView.this.f3302n;
            if (wVar != null) {
                wVar.a(c0Var);
            }
            int size = RecyclerView.this.f3304o.size();
            for (int i10 = 0; i10 < size; i10++) {
                RecyclerView.this.f3304o.get(i10).a(c0Var);
            }
            h hVar = RecyclerView.this.f3298l;
            if (hVar != null) {
                hVar.onViewRecycled(c0Var);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f3285e1 != null) {
                recyclerView.f3286f.q(c0Var);
            }
        }

        /* access modifiers changed from: package-private */
        public c0 h(int i10) {
            int size;
            int m10;
            ArrayList<c0> arrayList = this.f3382b;
            if (!(arrayList == null || (size = arrayList.size()) == 0)) {
                int i11 = 0;
                int i12 = 0;
                while (i12 < size) {
                    c0 c0Var = this.f3382b.get(i12);
                    if (c0Var.wasReturnedFromScrap() || c0Var.getLayoutPosition() != i10) {
                        i12++;
                    } else {
                        c0Var.addFlags(32);
                        return c0Var;
                    }
                }
                if (RecyclerView.this.f3298l.hasStableIds() && (m10 = RecyclerView.this.f3282d.m(i10)) > 0 && m10 < RecyclerView.this.f3298l.getItemCount()) {
                    long itemId = RecyclerView.this.f3298l.getItemId(m10);
                    while (i11 < size) {
                        c0 c0Var2 = this.f3382b.get(i11);
                        if (c0Var2.wasReturnedFromScrap() || c0Var2.getItemId() != itemId) {
                            i11++;
                        } else {
                            c0Var2.addFlags(32);
                            return c0Var2;
                        }
                    }
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public u i() {
            if (this.f3387g == null) {
                this.f3387g = new u();
            }
            return this.f3387g;
        }

        /* access modifiers changed from: package-private */
        public int j() {
            return this.f3381a.size();
        }

        public List<c0> k() {
            return this.f3384d;
        }

        /* access modifiers changed from: package-private */
        public c0 l(long j10, int i10, boolean z10) {
            for (int size = this.f3381a.size() - 1; size >= 0; size--) {
                c0 c0Var = this.f3381a.get(size);
                if (c0Var.getItemId() == j10 && !c0Var.wasReturnedFromScrap()) {
                    if (i10 == c0Var.getItemViewType()) {
                        c0Var.addFlags(32);
                        if (c0Var.isRemoved() && !RecyclerView.this.f3285e1.f()) {
                            c0Var.setFlags(2, 14);
                        }
                        return c0Var;
                    } else if (!z10) {
                        this.f3381a.remove(size);
                        RecyclerView.this.removeDetachedView(c0Var.itemView, false);
                        y(c0Var.itemView);
                    }
                }
            }
            int size2 = this.f3383c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                c0 c0Var2 = this.f3383c.get(size2);
                if (c0Var2.getItemId() == j10 && !c0Var2.isAttachedToTransitionOverlay()) {
                    if (i10 == c0Var2.getItemViewType()) {
                        if (!z10) {
                            this.f3383c.remove(size2);
                        }
                        return c0Var2;
                    } else if (!z10) {
                        A(size2);
                        return null;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public c0 m(int i10, boolean z10) {
            View e10;
            int size = this.f3381a.size();
            int i11 = 0;
            int i12 = 0;
            while (i12 < size) {
                c0 c0Var = this.f3381a.get(i12);
                if (c0Var.wasReturnedFromScrap() || c0Var.getLayoutPosition() != i10 || c0Var.isInvalid() || (!RecyclerView.this.f3285e1.f3412h && c0Var.isRemoved())) {
                    i12++;
                } else {
                    c0Var.addFlags(32);
                    return c0Var;
                }
            }
            if (z10 || (e10 = RecyclerView.this.f3284e.e(i10)) == null) {
                int size2 = this.f3383c.size();
                while (i11 < size2) {
                    c0 c0Var2 = this.f3383c.get(i11);
                    if (c0Var2.isInvalid() || c0Var2.getLayoutPosition() != i10 || c0Var2.isAttachedToTransitionOverlay()) {
                        i11++;
                    } else {
                        if (!z10) {
                            this.f3383c.remove(i11);
                        }
                        return c0Var2;
                    }
                }
                return null;
            }
            c0 h02 = RecyclerView.h0(e10);
            RecyclerView.this.f3284e.s(e10);
            int m10 = RecyclerView.this.f3284e.m(e10);
            if (m10 != -1) {
                RecyclerView.this.f3284e.d(m10);
                D(e10);
                h02.addFlags(8224);
                return h02;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + h02 + RecyclerView.this.Q());
        }

        /* access modifiers changed from: package-private */
        public View n(int i10) {
            return this.f3381a.get(i10).itemView;
        }

        public View o(int i10) {
            return p(i10, false);
        }

        /* access modifiers changed from: package-private */
        public View p(int i10, boolean z10) {
            return I(i10, z10, Long.MAX_VALUE).itemView;
        }

        /* access modifiers changed from: package-private */
        public void s() {
            int size = this.f3383c.size();
            for (int i10 = 0; i10 < size; i10++) {
                LayoutParams layoutParams = (LayoutParams) this.f3383c.get(i10).itemView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.f3328c = true;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void t() {
            int size = this.f3383c.size();
            for (int i10 = 0; i10 < size; i10++) {
                c0 c0Var = this.f3383c.get(i10);
                if (c0Var != null) {
                    c0Var.addFlags(6);
                    c0Var.addChangePayload((Object) null);
                }
            }
            h hVar = RecyclerView.this.f3298l;
            if (hVar == null || !hVar.hasStableIds()) {
                z();
            }
        }

        /* access modifiers changed from: package-private */
        public void u(int i10, int i11) {
            int size = this.f3383c.size();
            for (int i12 = 0; i12 < size; i12++) {
                c0 c0Var = this.f3383c.get(i12);
                if (c0Var != null && c0Var.mPosition >= i10) {
                    c0Var.offsetPosition(i11, false);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void v(int i10, int i11) {
            int i12;
            int i13;
            int i14;
            int i15;
            if (i10 < i11) {
                i14 = -1;
                i13 = i10;
                i12 = i11;
            } else {
                i14 = 1;
                i12 = i10;
                i13 = i11;
            }
            int size = this.f3383c.size();
            for (int i16 = 0; i16 < size; i16++) {
                c0 c0Var = this.f3383c.get(i16);
                if (c0Var != null && (i15 = c0Var.mPosition) >= i13 && i15 <= i12) {
                    if (i15 == i10) {
                        c0Var.offsetPosition(i11 - i10, false);
                    } else {
                        c0Var.offsetPosition(i14, false);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void w(int i10, int i11, boolean z10) {
            int i12 = i10 + i11;
            for (int size = this.f3383c.size() - 1; size >= 0; size--) {
                c0 c0Var = this.f3383c.get(size);
                if (c0Var != null) {
                    int i13 = c0Var.mPosition;
                    if (i13 >= i12) {
                        c0Var.offsetPosition(-i11, z10);
                    } else if (i13 >= i10) {
                        c0Var.addFlags(8);
                        A(size);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void x(h hVar, h hVar2, boolean z10) {
            c();
            i().h(hVar, hVar2, z10);
        }

        /* access modifiers changed from: package-private */
        public void y(View view) {
            c0 h02 = RecyclerView.h0(view);
            h02.mScrapContainer = null;
            h02.mInChangeScrap = false;
            h02.clearReturnedFromScrapFlag();
            C(h02);
        }

        /* access modifiers changed from: package-private */
        public void z() {
            for (int size = this.f3383c.size() - 1; size >= 0; size--) {
                A(size);
            }
            this.f3383c.clear();
            if (RecyclerView.C1) {
                RecyclerView.this.f3283d1.b();
            }
        }
    }

    public interface w {
        void a(c0 c0Var);
    }

    private class x extends j {
        x() {
        }

        public void a() {
            RecyclerView.this.p((String) null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f3285e1.f3411g = true;
            recyclerView.R0(true);
            if (!RecyclerView.this.f3282d.p()) {
                RecyclerView.this.requestLayout();
            }
        }

        public void c(int i10, int i11, Object obj) {
            RecyclerView.this.p((String) null);
            if (RecyclerView.this.f3282d.r(i10, i11, obj)) {
                h();
            }
        }

        public void d(int i10, int i11) {
            RecyclerView.this.p((String) null);
            if (RecyclerView.this.f3282d.s(i10, i11)) {
                h();
            }
        }

        public void e(int i10, int i11, int i12) {
            RecyclerView.this.p((String) null);
            if (RecyclerView.this.f3282d.t(i10, i11, i12)) {
                h();
            }
        }

        public void f(int i10, int i11) {
            RecyclerView.this.p((String) null);
            if (RecyclerView.this.f3282d.u(i10, i11)) {
                h();
            }
        }

        public void g() {
            h hVar;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f3279c != null && (hVar = recyclerView.f3298l) != null && hVar.canRestoreState()) {
                RecyclerView.this.requestLayout();
            }
        }

        /* access modifiers changed from: package-private */
        public void h() {
            if (RecyclerView.B1) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.f3314t && recyclerView.f3312s) {
                    androidx.core.view.x.j0(recyclerView, recyclerView.f3290h);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.B = true;
            recyclerView2.requestLayout();
        }
    }

    public static abstract class y {

        /* renamed from: a  reason: collision with root package name */
        private int f3390a = -1;

        /* renamed from: b  reason: collision with root package name */
        private RecyclerView f3391b;

        /* renamed from: c  reason: collision with root package name */
        private p f3392c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f3393d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f3394e;

        /* renamed from: f  reason: collision with root package name */
        private View f3395f;

        /* renamed from: g  reason: collision with root package name */
        private final a f3396g = new a(0, 0);

        /* renamed from: h  reason: collision with root package name */
        private boolean f3397h;

        public static class a {

            /* renamed from: a  reason: collision with root package name */
            private int f3398a;

            /* renamed from: b  reason: collision with root package name */
            private int f3399b;

            /* renamed from: c  reason: collision with root package name */
            private int f3400c;

            /* renamed from: d  reason: collision with root package name */
            private int f3401d;

            /* renamed from: e  reason: collision with root package name */
            private Interpolator f3402e;

            /* renamed from: f  reason: collision with root package name */
            private boolean f3403f;

            /* renamed from: g  reason: collision with root package name */
            private int f3404g;

            public a(int i10, int i11) {
                this(i10, i11, Integer.MIN_VALUE, (Interpolator) null);
            }

            public a(int i10, int i11, int i12, Interpolator interpolator) {
                this.f3401d = -1;
                this.f3403f = false;
                this.f3404g = 0;
                this.f3398a = i10;
                this.f3399b = i11;
                this.f3400c = i12;
                this.f3402e = interpolator;
            }

            private void e() {
                if (this.f3402e != null && this.f3400c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else if (this.f3400c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            /* access modifiers changed from: package-private */
            public boolean a() {
                return this.f3401d >= 0;
            }

            public void b(int i10) {
                this.f3401d = i10;
            }

            /* access modifiers changed from: package-private */
            public void c(RecyclerView recyclerView) {
                int i10 = this.f3401d;
                if (i10 >= 0) {
                    this.f3401d = -1;
                    recyclerView.x0(i10);
                    this.f3403f = false;
                } else if (this.f3403f) {
                    e();
                    recyclerView.f3278b1.e(this.f3398a, this.f3399b, this.f3400c, this.f3402e);
                    int i11 = this.f3404g + 1;
                    this.f3404g = i11;
                    if (i11 > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f3403f = false;
                } else {
                    this.f3404g = 0;
                }
            }

            public void d(int i10, int i11, int i12, Interpolator interpolator) {
                this.f3398a = i10;
                this.f3399b = i11;
                this.f3400c = i12;
                this.f3402e = interpolator;
                this.f3403f = true;
            }
        }

        public interface b {
            PointF d(int i10);
        }

        public PointF a(int i10) {
            p e10 = e();
            if (e10 instanceof b) {
                return ((b) e10).d(i10);
            }
            Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + b.class.getCanonicalName());
            return null;
        }

        public View b(int i10) {
            return this.f3391b.f3300m.Q(i10);
        }

        public int c() {
            return this.f3391b.f3300m.X();
        }

        public int d(View view) {
            return this.f3391b.f0(view);
        }

        public p e() {
            return this.f3392c;
        }

        public int f() {
            return this.f3390a;
        }

        public boolean g() {
            return this.f3393d;
        }

        public boolean h() {
            return this.f3394e;
        }

        /* access modifiers changed from: protected */
        public void i(PointF pointF) {
            float f10 = pointF.x;
            float f11 = pointF.y;
            float sqrt = (float) Math.sqrt((double) ((f10 * f10) + (f11 * f11)));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }

        /* access modifiers changed from: package-private */
        public void j(int i10, int i11) {
            PointF a10;
            RecyclerView recyclerView = this.f3391b;
            if (this.f3390a == -1 || recyclerView == null) {
                r();
            }
            if (this.f3393d && this.f3395f == null && this.f3392c != null && (a10 = a(this.f3390a)) != null) {
                float f10 = a10.x;
                if (!(f10 == 0.0f && a10.y == 0.0f)) {
                    recyclerView.j1((int) Math.signum(f10), (int) Math.signum(a10.y), (int[]) null);
                }
            }
            this.f3393d = false;
            View view = this.f3395f;
            if (view != null) {
                if (d(view) == this.f3390a) {
                    o(this.f3395f, recyclerView.f3285e1, this.f3396g);
                    this.f3396g.c(recyclerView);
                    r();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f3395f = null;
                }
            }
            if (this.f3394e) {
                l(i10, i11, recyclerView.f3285e1, this.f3396g);
                boolean a11 = this.f3396g.a();
                this.f3396g.c(recyclerView);
                if (a11 && this.f3394e) {
                    this.f3393d = true;
                    recyclerView.f3278b1.d();
                }
            }
        }

        /* access modifiers changed from: protected */
        public void k(View view) {
            if (d(view) == f()) {
                this.f3395f = view;
            }
        }

        /* access modifiers changed from: protected */
        public abstract void l(int i10, int i11, z zVar, a aVar);

        /* access modifiers changed from: protected */
        public abstract void m();

        /* access modifiers changed from: protected */
        public abstract void n();

        /* access modifiers changed from: protected */
        public abstract void o(View view, z zVar, a aVar);

        public void p(int i10) {
            this.f3390a = i10;
        }

        /* access modifiers changed from: package-private */
        public void q(RecyclerView recyclerView, p pVar) {
            recyclerView.f3278b1.f();
            if (this.f3397h) {
                Log.w("RecyclerView", "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.f3391b = recyclerView;
            this.f3392c = pVar;
            int i10 = this.f3390a;
            if (i10 != -1) {
                recyclerView.f3285e1.f3405a = i10;
                this.f3394e = true;
                this.f3393d = true;
                this.f3395f = b(f());
                m();
                this.f3391b.f3278b1.d();
                this.f3397h = true;
                return;
            }
            throw new IllegalArgumentException("Invalid target position");
        }

        /* access modifiers changed from: protected */
        public final void r() {
            if (this.f3394e) {
                this.f3394e = false;
                n();
                this.f3391b.f3285e1.f3405a = -1;
                this.f3395f = null;
                this.f3390a = -1;
                this.f3393d = false;
                this.f3392c.q1(this);
                this.f3392c = null;
                this.f3391b = null;
            }
        }
    }

    public static class z {

        /* renamed from: a  reason: collision with root package name */
        int f3405a = -1;

        /* renamed from: b  reason: collision with root package name */
        private SparseArray<Object> f3406b;

        /* renamed from: c  reason: collision with root package name */
        int f3407c = 0;

        /* renamed from: d  reason: collision with root package name */
        int f3408d = 0;

        /* renamed from: e  reason: collision with root package name */
        int f3409e = 1;

        /* renamed from: f  reason: collision with root package name */
        int f3410f = 0;

        /* renamed from: g  reason: collision with root package name */
        boolean f3411g = false;

        /* renamed from: h  reason: collision with root package name */
        boolean f3412h = false;

        /* renamed from: i  reason: collision with root package name */
        boolean f3413i = false;

        /* renamed from: j  reason: collision with root package name */
        boolean f3414j = false;

        /* renamed from: k  reason: collision with root package name */
        boolean f3415k = false;

        /* renamed from: l  reason: collision with root package name */
        boolean f3416l = false;

        /* renamed from: m  reason: collision with root package name */
        int f3417m;

        /* renamed from: n  reason: collision with root package name */
        long f3418n;

        /* renamed from: o  reason: collision with root package name */
        int f3419o;

        /* renamed from: p  reason: collision with root package name */
        int f3420p;

        /* access modifiers changed from: package-private */
        public void a(int i10) {
            if ((this.f3409e & i10) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i10) + " but it is " + Integer.toBinaryString(this.f3409e));
            }
        }

        public int b() {
            return this.f3412h ? this.f3407c - this.f3408d : this.f3410f;
        }

        public int c() {
            return this.f3405a;
        }

        public boolean d() {
            return this.f3405a != -1;
        }

        public boolean e() {
            return this.f3414j;
        }

        public boolean f() {
            return this.f3412h;
        }

        /* access modifiers changed from: package-private */
        public void g(h hVar) {
            this.f3409e = 1;
            this.f3410f = hVar.getItemCount();
            this.f3412h = false;
            this.f3413i = false;
            this.f3414j = false;
        }

        public boolean h() {
            return this.f3416l;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f3405a + ", mData=" + this.f3406b + ", mItemCount=" + this.f3410f + ", mIsMeasuring=" + this.f3414j + ", mPreviousLayoutItemCount=" + this.f3407c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f3408d + ", mStructureChanged=" + this.f3411g + ", mInPreLayout=" + this.f3412h + ", mRunSimpleAnimations=" + this.f3415k + ", mRunPredictiveAnimations=" + this.f3416l + '}';
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r0 = 1
            int[] r1 = new int[r0]
            r2 = 16843830(0x1010436, float:2.369658E-38)
            r3 = 0
            r1[r3] = r2
            f3271y1 = r1
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 18
            if (r1 == r2) goto L_0x001c
            r2 = 19
            if (r1 == r2) goto L_0x001c
            r2 = 20
            if (r1 != r2) goto L_0x001a
            goto L_0x001c
        L_0x001a:
            r2 = r3
            goto L_0x001d
        L_0x001c:
            r2 = r0
        L_0x001d:
            f3272z1 = r2
            r2 = 23
            if (r1 < r2) goto L_0x0025
            r2 = r0
            goto L_0x0026
        L_0x0025:
            r2 = r3
        L_0x0026:
            A1 = r2
            r2 = 16
            if (r1 < r2) goto L_0x002e
            r2 = r0
            goto L_0x002f
        L_0x002e:
            r2 = r3
        L_0x002f:
            B1 = r2
            r2 = 21
            if (r1 < r2) goto L_0x0037
            r2 = r0
            goto L_0x0038
        L_0x0037:
            r2 = r3
        L_0x0038:
            C1 = r2
            r2 = 15
            if (r1 > r2) goto L_0x0040
            r4 = r0
            goto L_0x0041
        L_0x0040:
            r4 = r3
        L_0x0041:
            D1 = r4
            if (r1 > r2) goto L_0x0047
            r1 = r0
            goto L_0x0048
        L_0x0047:
            r1 = r3
        L_0x0048:
            E1 = r1
            r1 = 4
            java.lang.Class[] r1 = new java.lang.Class[r1]
            java.lang.Class<android.content.Context> r2 = android.content.Context.class
            r1[r3] = r2
            java.lang.Class<android.util.AttributeSet> r2 = android.util.AttributeSet.class
            r1[r0] = r2
            r0 = 2
            java.lang.Class r2 = java.lang.Integer.TYPE
            r1[r0] = r2
            r0 = 3
            r1[r0] = r2
            F1 = r1
            androidx.recyclerview.widget.RecyclerView$c r0 = new androidx.recyclerview.widget.RecyclerView$c
            r0.<init>()
            G1 = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.<clinit>():void");
    }

    public RecyclerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, p1.a.recyclerViewStyle);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f3273a = new x();
        this.f3276b = new v();
        this.f3286f = new z();
        this.f3290h = new a();
        this.f3292i = new Rect();
        this.f3294j = new Rect();
        this.f3296k = new RectF();
        this.f3304o = new ArrayList();
        this.f3306p = new ArrayList<>();
        this.f3308q = new ArrayList<>();
        this.f3320w = 0;
        this.E = false;
        this.F = false;
        this.G = 0;
        this.H = 0;
        this.I = new l();
        this.N = new g();
        this.O = 0;
        this.P = -1;
        this.f3280c0 = Float.MIN_VALUE;
        this.Z0 = Float.MIN_VALUE;
        boolean z10 = true;
        this.f3275a1 = true;
        this.f3278b1 = new b0();
        this.f3283d1 = C1 ? new j.b() : null;
        this.f3285e1 = new z();
        this.f3291h1 = false;
        this.f3293i1 = false;
        this.f3295j1 = new n();
        this.f3297k1 = false;
        this.f3303n1 = new int[2];
        this.f3307p1 = new int[2];
        this.f3309q1 = new int[2];
        this.f3311r1 = new int[2];
        this.f3313s1 = new ArrayList();
        this.f3315t1 = new b();
        this.f3319v1 = 0;
        this.f3321w1 = 0;
        this.f3323x1 = new d();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.V = viewConfiguration.getScaledTouchSlop();
        this.f3280c0 = androidx.core.view.y.b(viewConfiguration, context);
        this.Z0 = androidx.core.view.y.d(viewConfiguration, context);
        this.f3274a0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f3277b0 = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.N.setListener(this.f3295j1);
        p0();
        r0();
        q0();
        if (androidx.core.view.x.A(this) == 0) {
            androidx.core.view.x.B0(this, 1);
        }
        this.C = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new u(this));
        int[] iArr = p1.d.RecyclerView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i10, 0);
        androidx.core.view.x.p0(this, context, iArr, attributeSet, obtainStyledAttributes, i10, 0);
        String string = obtainStyledAttributes.getString(p1.d.RecyclerView_layoutManager);
        if (obtainStyledAttributes.getInt(p1.d.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.f3288g = obtainStyledAttributes.getBoolean(p1.d.RecyclerView_android_clipToPadding, true);
        boolean z11 = obtainStyledAttributes.getBoolean(p1.d.RecyclerView_fastScrollEnabled, false);
        this.f3316u = z11;
        if (z11) {
            s0((StateListDrawable) obtainStyledAttributes.getDrawable(p1.d.RecyclerView_fastScrollVerticalThumbDrawable), obtainStyledAttributes.getDrawable(p1.d.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) obtainStyledAttributes.getDrawable(p1.d.RecyclerView_fastScrollHorizontalThumbDrawable), obtainStyledAttributes.getDrawable(p1.d.RecyclerView_fastScrollHorizontalTrackDrawable));
        }
        obtainStyledAttributes.recycle();
        w(context, string, attributeSet, i10, 0);
        if (Build.VERSION.SDK_INT >= 21) {
            int[] iArr2 = f3271y1;
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i10, 0);
            androidx.core.view.x.p0(this, context, iArr2, attributeSet, obtainStyledAttributes2, i10, 0);
            z10 = obtainStyledAttributes2.getBoolean(0, true);
            obtainStyledAttributes2.recycle();
        }
        setNestedScrollingEnabled(z10);
    }

    private void A0(int i10, int i11, MotionEvent motionEvent, int i12) {
        p pVar = this.f3300m;
        if (pVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.f3324y) {
            int[] iArr = this.f3311r1;
            int i13 = 0;
            iArr[0] = 0;
            iArr[1] = 0;
            boolean w10 = pVar.w();
            boolean x10 = this.f3300m.x();
            u1(x10 ? w10 | true : w10 ? 1 : 0, i12);
            if (G(w10 ? i10 : 0, x10 ? i11 : 0, this.f3311r1, this.f3307p1, i12)) {
                int[] iArr2 = this.f3311r1;
                i10 -= iArr2[0];
                i11 -= iArr2[1];
            }
            int i14 = w10 ? i10 : 0;
            if (x10) {
                i13 = i11;
            }
            i1(i14, i13, motionEvent, i12);
            j jVar = this.f3281c1;
            if (!(jVar == null || (i10 == 0 && i11 == 0))) {
                jVar.f(this, i10, i11);
            }
            w1(i12);
        }
    }

    private void B() {
        int i10 = this.A;
        this.A = 0;
        if (i10 != 0 && u0()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(m.FLAG_MOVED);
            x0.b.b(obtain, i10);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    private void D() {
        boolean z10 = true;
        this.f3285e1.a(1);
        R(this.f3285e1);
        this.f3285e1.f3414j = false;
        t1();
        this.f3286f.f();
        I0();
        Q0();
        g1();
        z zVar = this.f3285e1;
        if (!zVar.f3415k || !this.f3293i1) {
            z10 = false;
        }
        zVar.f3413i = z10;
        this.f3293i1 = false;
        this.f3291h1 = false;
        zVar.f3412h = zVar.f3416l;
        zVar.f3410f = this.f3298l.getItemCount();
        W(this.f3303n1);
        if (this.f3285e1.f3415k) {
            int g10 = this.f3284e.g();
            for (int i10 = 0; i10 < g10; i10++) {
                c0 h02 = h0(this.f3284e.f(i10));
                if (!h02.shouldIgnore() && (!h02.isInvalid() || this.f3298l.hasStableIds())) {
                    this.f3286f.e(h02, this.N.recordPreLayoutInformation(this.f3285e1, h02, m.buildAdapterChangeFlagsForAnimations(h02), h02.getUnmodifiedPayloads()));
                    if (this.f3285e1.f3413i && h02.isUpdated() && !h02.isRemoved() && !h02.shouldIgnore() && !h02.isInvalid()) {
                        this.f3286f.c(e0(h02), h02);
                    }
                }
            }
        }
        if (this.f3285e1.f3416l) {
            h1();
            z zVar2 = this.f3285e1;
            boolean z11 = zVar2.f3411g;
            zVar2.f3411g = false;
            this.f3300m.i1(this.f3276b, zVar2);
            this.f3285e1.f3411g = z11;
            for (int i11 = 0; i11 < this.f3284e.g(); i11++) {
                c0 h03 = h0(this.f3284e.f(i11));
                if (!h03.shouldIgnore() && !this.f3286f.i(h03)) {
                    int buildAdapterChangeFlagsForAnimations = m.buildAdapterChangeFlagsForAnimations(h03);
                    boolean hasAnyOfTheFlags = h03.hasAnyOfTheFlags(8192);
                    if (!hasAnyOfTheFlags) {
                        buildAdapterChangeFlagsForAnimations |= m.FLAG_APPEARED_IN_PRE_LAYOUT;
                    }
                    m.c recordPreLayoutInformation = this.N.recordPreLayoutInformation(this.f3285e1, h03, buildAdapterChangeFlagsForAnimations, h03.getUnmodifiedPayloads());
                    if (hasAnyOfTheFlags) {
                        T0(h03, recordPreLayoutInformation);
                    } else {
                        this.f3286f.a(h03, recordPreLayoutInformation);
                    }
                }
            }
        }
        t();
        J0();
        v1(false);
        this.f3285e1.f3409e = 2;
    }

    private void E() {
        t1();
        I0();
        this.f3285e1.a(6);
        this.f3282d.j();
        this.f3285e1.f3410f = this.f3298l.getItemCount();
        this.f3285e1.f3408d = 0;
        if (this.f3279c != null && this.f3298l.canRestoreState()) {
            Parcelable parcelable = this.f3279c.f3330c;
            if (parcelable != null) {
                this.f3300m.n1(parcelable);
            }
            this.f3279c = null;
        }
        z zVar = this.f3285e1;
        zVar.f3412h = false;
        this.f3300m.i1(this.f3276b, zVar);
        z zVar2 = this.f3285e1;
        zVar2.f3411g = false;
        zVar2.f3415k = zVar2.f3415k && this.N != null;
        zVar2.f3409e = 4;
        J0();
        v1(false);
    }

    private void F() {
        this.f3285e1.a(4);
        t1();
        I0();
        z zVar = this.f3285e1;
        zVar.f3409e = 1;
        if (zVar.f3415k) {
            for (int g10 = this.f3284e.g() - 1; g10 >= 0; g10--) {
                c0 h02 = h0(this.f3284e.f(g10));
                if (!h02.shouldIgnore()) {
                    long e02 = e0(h02);
                    m.c recordPostLayoutInformation = this.N.recordPostLayoutInformation(this.f3285e1, h02);
                    c0 g11 = this.f3286f.g(e02);
                    if (g11 != null && !g11.shouldIgnore()) {
                        boolean h10 = this.f3286f.h(g11);
                        boolean h11 = this.f3286f.h(h02);
                        if (!h10 || g11 != h02) {
                            m.c n10 = this.f3286f.n(g11);
                            this.f3286f.d(h02, recordPostLayoutInformation);
                            m.c m10 = this.f3286f.m(h02);
                            if (n10 == null) {
                                m0(e02, h02, g11);
                            } else {
                                n(g11, h02, n10, m10, h10, h11);
                            }
                        }
                    }
                    this.f3286f.d(h02, recordPostLayoutInformation);
                }
            }
            this.f3286f.o(this.f3323x1);
        }
        this.f3300m.x1(this.f3276b);
        z zVar2 = this.f3285e1;
        zVar2.f3407c = zVar2.f3410f;
        this.E = false;
        this.F = false;
        zVar2.f3415k = false;
        zVar2.f3416l = false;
        this.f3300m.f3358h = false;
        ArrayList<c0> arrayList = this.f3276b.f3382b;
        if (arrayList != null) {
            arrayList.clear();
        }
        p pVar = this.f3300m;
        if (pVar.f3364n) {
            pVar.f3363m = 0;
            pVar.f3364n = false;
            this.f3276b.K();
        }
        this.f3300m.j1(this.f3285e1);
        J0();
        v1(false);
        this.f3286f.f();
        int[] iArr = this.f3303n1;
        if (y(iArr[0], iArr[1])) {
            J(0, 0);
        }
        U0();
        e1();
    }

    private boolean L(MotionEvent motionEvent) {
        s sVar = this.f3310r;
        if (sVar != null) {
            sVar.c(this, motionEvent);
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.f3310r = null;
            }
            return true;
        } else if (motionEvent.getAction() == 0) {
            return false;
        } else {
            return V(motionEvent);
        }
    }

    private void L0(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.P) {
            int i10 = actionIndex == 0 ? 1 : 0;
            this.P = motionEvent.getPointerId(i10);
            int x10 = (int) (motionEvent.getX(i10) + 0.5f);
            this.T = x10;
            this.R = x10;
            int y10 = (int) (motionEvent.getY(i10) + 0.5f);
            this.U = y10;
            this.S = y10;
        }
    }

    private boolean P0() {
        return this.N != null && this.f3300m.X1();
    }

    private void Q0() {
        boolean z10;
        if (this.E) {
            this.f3282d.y();
            if (this.F) {
                this.f3300m.d1(this);
            }
        }
        if (P0()) {
            this.f3282d.w();
        } else {
            this.f3282d.j();
        }
        boolean z11 = false;
        boolean z12 = this.f3291h1 || this.f3293i1;
        this.f3285e1.f3415k = this.f3318v && this.N != null && ((z10 = this.E) || z12 || this.f3300m.f3358h) && (!z10 || this.f3298l.hasStableIds());
        z zVar = this.f3285e1;
        if (zVar.f3415k && z12 && !this.E && P0()) {
            z11 = true;
        }
        zVar.f3416l = z11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void S0(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 0
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 1
            if (r1 >= 0) goto L_0x0021
            r6.N()
            android.widget.EdgeEffect r1 = r6.J
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r2 - r9
        L_0x001c:
            androidx.core.widget.f.a(r1, r4, r9)
            r9 = r3
            goto L_0x0039
        L_0x0021:
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r1 <= 0) goto L_0x0038
            r6.O()
            android.widget.EdgeEffect r1 = r6.L
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            goto L_0x001c
        L_0x0038:
            r9 = 0
        L_0x0039:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L_0x0053
            r6.P()
            android.widget.EdgeEffect r9 = r6.K
            float r1 = -r10
            int r2 = r6.getHeight()
            float r2 = (float) r2
            float r1 = r1 / r2
            int r2 = r6.getWidth()
            float r2 = (float) r2
            float r7 = r7 / r2
            androidx.core.widget.f.a(r9, r1, r7)
            goto L_0x006f
        L_0x0053:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 <= 0) goto L_0x006e
            r6.M()
            android.widget.EdgeEffect r9 = r6.M
            int r1 = r6.getHeight()
            float r1 = (float) r1
            float r1 = r10 / r1
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r2 = r2 - r7
            androidx.core.widget.f.a(r9, r1, r2)
            goto L_0x006f
        L_0x006e:
            r3 = r9
        L_0x006f:
            if (r3 != 0) goto L_0x0079
            int r7 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r7 != 0) goto L_0x0079
            int r7 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r7 == 0) goto L_0x007c
        L_0x0079:
            androidx.core.view.x.h0(r6)
        L_0x007c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.S0(float, float, float, float):void");
    }

    private void U0() {
        View findViewById;
        if (this.f3275a1 && this.f3298l != null && hasFocus() && getDescendantFocusability() != 393216) {
            if (getDescendantFocusability() != 131072 || !isFocused()) {
                if (!isFocused()) {
                    View focusedChild = getFocusedChild();
                    if (!E1 || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                        if (!this.f3284e.n(focusedChild)) {
                            return;
                        }
                    } else if (this.f3284e.g() == 0) {
                        requestFocus();
                        return;
                    }
                }
                View view = null;
                c0 a02 = (this.f3285e1.f3418n == -1 || !this.f3298l.hasStableIds()) ? null : a0(this.f3285e1.f3418n);
                if (a02 != null && !this.f3284e.n(a02.itemView) && a02.itemView.hasFocusable()) {
                    view = a02.itemView;
                } else if (this.f3284e.g() > 0) {
                    view = Y();
                }
                if (view != null) {
                    int i10 = this.f3285e1.f3419o;
                    if (!(((long) i10) == -1 || (findViewById = view.findViewById(i10)) == null || !findViewById.isFocusable())) {
                        view = findViewById;
                    }
                    view.requestFocus();
                }
            }
        }
    }

    private boolean V(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.f3308q.size();
        int i10 = 0;
        while (i10 < size) {
            s sVar = this.f3308q.get(i10);
            if (!sVar.a(this, motionEvent) || action == 3) {
                i10++;
            } else {
                this.f3310r = sVar;
                return true;
            }
        }
        return false;
    }

    private void V0() {
        boolean z10;
        EdgeEffect edgeEffect = this.J;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z10 = this.J.isFinished();
        } else {
            z10 = false;
        }
        EdgeEffect edgeEffect2 = this.K;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z10 |= this.K.isFinished();
        }
        EdgeEffect edgeEffect3 = this.L;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z10 |= this.L.isFinished();
        }
        EdgeEffect edgeEffect4 = this.M;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z10 |= this.M.isFinished();
        }
        if (z10) {
            androidx.core.view.x.h0(this);
        }
    }

    private void W(int[] iArr) {
        int g10 = this.f3284e.g();
        if (g10 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i10 = Integer.MAX_VALUE;
        int i11 = Integer.MIN_VALUE;
        for (int i12 = 0; i12 < g10; i12++) {
            c0 h02 = h0(this.f3284e.f(i12));
            if (!h02.shouldIgnore()) {
                int layoutPosition = h02.getLayoutPosition();
                if (layoutPosition < i10) {
                    i10 = layoutPosition;
                }
                if (layoutPosition > i11) {
                    i11 = layoutPosition;
                }
            }
        }
        iArr[0] = i10;
        iArr[1] = i11;
    }

    static RecyclerView X(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            RecyclerView X = X(viewGroup.getChildAt(i10));
            if (X != null) {
                return X;
            }
        }
        return null;
    }

    private View Y() {
        c0 Z;
        z zVar = this.f3285e1;
        int i10 = zVar.f3417m;
        if (i10 == -1) {
            i10 = 0;
        }
        int b10 = zVar.b();
        int i11 = i10;
        while (i11 < b10) {
            c0 Z2 = Z(i11);
            if (Z2 == null) {
                break;
            } else if (Z2.itemView.hasFocusable()) {
                return Z2.itemView;
            } else {
                i11++;
            }
        }
        int min = Math.min(b10, i10);
        while (true) {
            min--;
            if (min < 0 || (Z = Z(min)) == null) {
                return null;
            }
            if (Z.itemView.hasFocusable()) {
                return Z.itemView;
            }
        }
    }

    private void d1(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.f3292i.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.f3328c) {
                Rect rect = layoutParams2.f3327b;
                Rect rect2 = this.f3292i;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.f3292i);
            offsetRectIntoDescendantCoords(view, this.f3292i);
        }
        this.f3300m.E1(this, view, this.f3292i, !this.f3318v, view2 == null);
    }

    private void e1() {
        z zVar = this.f3285e1;
        zVar.f3418n = -1;
        zVar.f3417m = -1;
        zVar.f3419o = -1;
    }

    private void f1() {
        VelocityTracker velocityTracker = this.Q;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        w1(0);
        V0();
    }

    private void g(c0 c0Var) {
        View view = c0Var.itemView;
        boolean z10 = view.getParent() == this;
        this.f3276b.J(g0(view));
        if (c0Var.isTmpDetached()) {
            this.f3284e.c(view, -1, view.getLayoutParams(), true);
            return;
        }
        f fVar = this.f3284e;
        if (!z10) {
            fVar.b(view, true);
        } else {
            fVar.k(view);
        }
    }

    private void g1() {
        c0 c0Var = null;
        View focusedChild = (!this.f3275a1 || !hasFocus() || this.f3298l == null) ? null : getFocusedChild();
        if (focusedChild != null) {
            c0Var = U(focusedChild);
        }
        if (c0Var == null) {
            e1();
            return;
        }
        this.f3285e1.f3418n = this.f3298l.hasStableIds() ? c0Var.getItemId() : -1;
        this.f3285e1.f3417m = this.E ? -1 : c0Var.isRemoved() ? c0Var.mOldPosition : c0Var.getAbsoluteAdapterPosition();
        this.f3285e1.f3419o = j0(c0Var.itemView);
    }

    private androidx.core.view.m getScrollingChildHelper() {
        if (this.f3305o1 == null) {
            this.f3305o1 = new androidx.core.view.m(this);
        }
        return this.f3305o1;
    }

    static c0 h0(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).f3326a;
    }

    static void i0(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.f3327b;
        rect.set((view.getLeft() - rect2.left) - layoutParams.leftMargin, (view.getTop() - rect2.top) - layoutParams.topMargin, view.getRight() + rect2.right + layoutParams.rightMargin, view.getBottom() + rect2.bottom + layoutParams.bottomMargin);
    }

    private int j0(View view) {
        int id2;
        loop0:
        while (true) {
            id2 = view.getId();
            while (true) {
                if (view.isFocused() || !(view instanceof ViewGroup) || !view.hasFocus()) {
                    return id2;
                }
                view = ((ViewGroup) view).getFocusedChild();
                if (view.getId() != -1) {
                }
            }
        }
        return id2;
    }

    private String k0(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        } else if (str.contains(".")) {
            return str;
        } else {
            return RecyclerView.class.getPackage().getName() + '.' + str;
        }
    }

    private void l1(h hVar, boolean z10, boolean z11) {
        h hVar2 = this.f3298l;
        if (hVar2 != null) {
            hVar2.unregisterAdapterDataObserver(this.f3273a);
            this.f3298l.onDetachedFromRecyclerView(this);
        }
        if (!z10 || z11) {
            W0();
        }
        this.f3282d.y();
        h hVar3 = this.f3298l;
        this.f3298l = hVar;
        if (hVar != null) {
            hVar.registerAdapterDataObserver(this.f3273a);
            hVar.onAttachedToRecyclerView(this);
        }
        p pVar = this.f3300m;
        if (pVar != null) {
            pVar.P0(hVar3, this.f3298l);
        }
        this.f3276b.x(hVar3, this.f3298l, z10);
        this.f3285e1.f3411g = true;
    }

    private void m0(long j10, c0 c0Var, c0 c0Var2) {
        int g10 = this.f3284e.g();
        for (int i10 = 0; i10 < g10; i10++) {
            c0 h02 = h0(this.f3284e.f(i10));
            if (h02 != c0Var && e0(h02) == j10) {
                h hVar = this.f3298l;
                if (hVar == null || !hVar.hasStableIds()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + h02 + " \n View Holder 2:" + c0Var + Q());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + h02 + " \n View Holder 2:" + c0Var + Q());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + c0Var2 + " cannot be found but it is necessary for " + c0Var + Q());
    }

    private void n(c0 c0Var, c0 c0Var2, m.c cVar, m.c cVar2, boolean z10, boolean z11) {
        c0Var.setIsRecyclable(false);
        if (z10) {
            g(c0Var);
        }
        if (c0Var != c0Var2) {
            if (z11) {
                g(c0Var2);
            }
            c0Var.mShadowedHolder = c0Var2;
            g(c0Var);
            this.f3276b.J(c0Var);
            c0Var2.setIsRecyclable(false);
            c0Var2.mShadowingHolder = c0Var;
        }
        if (this.N.animateChange(c0Var, c0Var2, cVar, cVar2)) {
            O0();
        }
    }

    private boolean o0() {
        int g10 = this.f3284e.g();
        for (int i10 = 0; i10 < g10; i10++) {
            c0 h02 = h0(this.f3284e.f(i10));
            if (h02 != null && !h02.shouldIgnore() && h02.isUpdated()) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"InlinedApi"})
    private void q0() {
        if (androidx.core.view.x.B(this) == 0) {
            androidx.core.view.x.C0(this, 8);
        }
    }

    private void r() {
        f1();
        setScrollState(0);
    }

    private void r0() {
        this.f3284e = new f(new e());
    }

    static void s(c0 c0Var) {
        WeakReference<RecyclerView> weakReference = c0Var.mNestedRecyclerView;
        if (weakReference != null) {
            Object obj = weakReference.get();
            while (true) {
                View view = (View) obj;
                while (true) {
                    if (view == null) {
                        c0Var.mNestedRecyclerView = null;
                        return;
                    } else if (view != c0Var.itemView) {
                        obj = view.getParent();
                        if (!(obj instanceof View)) {
                            view = null;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private void w(Context context, String str, AttributeSet attributeSet, int i10, int i11) {
        Constructor<? extends U> constructor;
        if (str != null) {
            String trim = str.trim();
            if (!trim.isEmpty()) {
                String k02 = k0(context, trim);
                try {
                    Class<? extends U> asSubclass = Class.forName(k02, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(p.class);
                    Object[] objArr = null;
                    try {
                        constructor = asSubclass.getConstructor(F1);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i10), Integer.valueOf(i11)};
                    } catch (NoSuchMethodException e10) {
                        constructor = asSubclass.getConstructor(new Class[0]);
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((p) constructor.newInstance(objArr));
                } catch (NoSuchMethodException e11) {
                    e11.initCause(e10);
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + k02, e11);
                } catch (ClassNotFoundException e12) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + k02, e12);
                } catch (InvocationTargetException e13) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + k02, e13);
                } catch (InstantiationException e14) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + k02, e14);
                } catch (IllegalAccessException e15) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + k02, e15);
                } catch (ClassCastException e16) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + k02, e16);
                }
            }
        }
    }

    private boolean w0(View view, View view2, int i10) {
        int i11;
        if (view2 == null || view2 == this || view2 == view || T(view2) == null) {
            return false;
        }
        if (view == null || T(view) == null) {
            return true;
        }
        this.f3292i.set(0, 0, view.getWidth(), view.getHeight());
        this.f3294j.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.f3292i);
        offsetDescendantRectToMyCoords(view2, this.f3294j);
        char c10 = 65535;
        int i12 = this.f3300m.n0() == 1 ? -1 : 1;
        Rect rect = this.f3292i;
        int i13 = rect.left;
        Rect rect2 = this.f3294j;
        int i14 = rect2.left;
        if ((i13 < i14 || rect.right <= i14) && rect.right < rect2.right) {
            i11 = 1;
        } else {
            int i15 = rect.right;
            int i16 = rect2.right;
            i11 = ((i15 > i16 || i13 >= i16) && i13 > i14) ? -1 : 0;
        }
        int i17 = rect.top;
        int i18 = rect2.top;
        if ((i17 < i18 || rect.bottom <= i18) && rect.bottom < rect2.bottom) {
            c10 = 1;
        } else {
            int i19 = rect.bottom;
            int i20 = rect2.bottom;
            if ((i19 <= i20 && i17 < i20) || i17 <= i18) {
                c10 = 0;
            }
        }
        if (i10 == 1) {
            return c10 < 0 || (c10 == 0 && i11 * i12 < 0);
        }
        if (i10 == 2) {
            return c10 > 0 || (c10 == 0 && i11 * i12 > 0);
        }
        if (i10 == 17) {
            return i11 < 0;
        }
        if (i10 == 33) {
            return c10 < 0;
        }
        if (i10 == 66) {
            return i11 > 0;
        }
        if (i10 == 130) {
            return c10 > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i10 + Q());
    }

    private boolean y(int i10, int i11) {
        W(this.f3303n1);
        int[] iArr = this.f3303n1;
        return (iArr[0] == i10 && iArr[1] == i11) ? false : true;
    }

    private void y1() {
        this.f3278b1.f();
        p pVar = this.f3300m;
        if (pVar != null) {
            pVar.W1();
        }
    }

    /* access modifiers changed from: package-private */
    public void A(View view) {
        c0 h02 = h0(view);
        H0(view);
        h hVar = this.f3298l;
        if (!(hVar == null || h02 == null)) {
            hVar.onViewDetachedFromWindow(h02);
        }
        List<q> list = this.D;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.D.get(size).d(view);
            }
        }
    }

    public void B0(int i10) {
        int g10 = this.f3284e.g();
        for (int i11 = 0; i11 < g10; i11++) {
            this.f3284e.f(i11).offsetLeftAndRight(i10);
        }
    }

    /* access modifiers changed from: package-private */
    public void C() {
        if (this.f3298l == null) {
            Log.w("RecyclerView", "No adapter attached; skipping layout");
        } else if (this.f3300m == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
        } else {
            this.f3285e1.f3414j = false;
            boolean z10 = this.f3317u1 && !(this.f3319v1 == getWidth() && this.f3321w1 == getHeight());
            this.f3319v1 = 0;
            this.f3321w1 = 0;
            this.f3317u1 = false;
            if (this.f3285e1.f3409e == 1) {
                D();
            } else if (!this.f3282d.q() && !z10 && this.f3300m.y0() == getWidth() && this.f3300m.k0() == getHeight()) {
                this.f3300m.L1(this);
                F();
            }
            this.f3300m.L1(this);
            E();
            F();
        }
    }

    public void C0(int i10) {
        int g10 = this.f3284e.g();
        for (int i11 = 0; i11 < g10; i11++) {
            this.f3284e.f(i11).offsetTopAndBottom(i10);
        }
    }

    /* access modifiers changed from: package-private */
    public void D0(int i10, int i11) {
        int j10 = this.f3284e.j();
        for (int i12 = 0; i12 < j10; i12++) {
            c0 h02 = h0(this.f3284e.i(i12));
            if (h02 != null && !h02.shouldIgnore() && h02.mPosition >= i10) {
                h02.offsetPosition(i11, false);
                this.f3285e1.f3411g = true;
            }
        }
        this.f3276b.u(i10, i11);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void E0(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int j10 = this.f3284e.j();
        if (i10 < i11) {
            i14 = -1;
            i13 = i10;
            i12 = i11;
        } else {
            i12 = i10;
            i13 = i11;
            i14 = 1;
        }
        for (int i16 = 0; i16 < j10; i16++) {
            c0 h02 = h0(this.f3284e.i(i16));
            if (h02 != null && (i15 = h02.mPosition) >= i13 && i15 <= i12) {
                if (i15 == i10) {
                    h02.offsetPosition(i11 - i10, false);
                } else {
                    h02.offsetPosition(i14, false);
                }
                this.f3285e1.f3411g = true;
            }
        }
        this.f3276b.v(i10, i11);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void F0(int i10, int i11, boolean z10) {
        int i12 = i10 + i11;
        int j10 = this.f3284e.j();
        for (int i13 = 0; i13 < j10; i13++) {
            c0 h02 = h0(this.f3284e.i(i13));
            if (h02 != null && !h02.shouldIgnore()) {
                int i14 = h02.mPosition;
                if (i14 >= i12) {
                    h02.offsetPosition(-i11, z10);
                } else if (i14 >= i10) {
                    h02.flagRemovedAndOffsetPosition(i10 - 1, -i11, z10);
                }
                this.f3285e1.f3411g = true;
            }
        }
        this.f3276b.w(i10, i11, z10);
        requestLayout();
    }

    public boolean G(int i10, int i11, int[] iArr, int[] iArr2, int i12) {
        return getScrollingChildHelper().d(i10, i11, iArr, iArr2, i12);
    }

    public void G0(View view) {
    }

    public final void H(int i10, int i11, int i12, int i13, int[] iArr, int i14, int[] iArr2) {
        getScrollingChildHelper().e(i10, i11, i12, i13, iArr, i14, iArr2);
    }

    public void H0(View view) {
    }

    /* access modifiers changed from: package-private */
    public void I(int i10) {
        p pVar = this.f3300m;
        if (pVar != null) {
            pVar.p1(i10);
        }
        M0(i10);
        t tVar = this.f3287f1;
        if (tVar != null) {
            tVar.onScrollStateChanged(this, i10);
        }
        List<t> list = this.f3289g1;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f3289g1.get(size).onScrollStateChanged(this, i10);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void I0() {
        this.G++;
    }

    /* access modifiers changed from: package-private */
    public void J(int i10, int i11) {
        this.H++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i10, scrollY - i11);
        N0(i10, i11);
        t tVar = this.f3287f1;
        if (tVar != null) {
            tVar.onScrolled(this, i10, i11);
        }
        List<t> list = this.f3289g1;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f3289g1.get(size).onScrolled(this, i10, i11);
            }
        }
        this.H--;
    }

    /* access modifiers changed from: package-private */
    public void J0() {
        K0(true);
    }

    /* access modifiers changed from: package-private */
    public void K() {
        int i10;
        for (int size = this.f3313s1.size() - 1; size >= 0; size--) {
            c0 c0Var = this.f3313s1.get(size);
            if (c0Var.itemView.getParent() == this && !c0Var.shouldIgnore() && (i10 = c0Var.mPendingAccessibilityState) != -1) {
                androidx.core.view.x.B0(c0Var.itemView, i10);
                c0Var.mPendingAccessibilityState = -1;
            }
        }
        this.f3313s1.clear();
    }

    /* access modifiers changed from: package-private */
    public void K0(boolean z10) {
        int i10 = this.G - 1;
        this.G = i10;
        if (i10 < 1) {
            this.G = 0;
            if (z10) {
                B();
                K();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void M() {
        int i10;
        int i11;
        if (this.M == null) {
            EdgeEffect a10 = this.I.a(this, 3);
            this.M = a10;
            if (this.f3288g) {
                i11 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
                i10 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            } else {
                i11 = getMeasuredWidth();
                i10 = getMeasuredHeight();
            }
            a10.setSize(i11, i10);
        }
    }

    public void M0(int i10) {
    }

    /* access modifiers changed from: package-private */
    public void N() {
        int i10;
        int i11;
        if (this.J == null) {
            EdgeEffect a10 = this.I.a(this, 0);
            this.J = a10;
            if (this.f3288g) {
                i11 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
                i10 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            } else {
                i11 = getMeasuredHeight();
                i10 = getMeasuredWidth();
            }
            a10.setSize(i11, i10);
        }
    }

    public void N0(int i10, int i11) {
    }

    /* access modifiers changed from: package-private */
    public void O() {
        int i10;
        int i11;
        if (this.L == null) {
            EdgeEffect a10 = this.I.a(this, 2);
            this.L = a10;
            if (this.f3288g) {
                i11 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
                i10 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            } else {
                i11 = getMeasuredHeight();
                i10 = getMeasuredWidth();
            }
            a10.setSize(i11, i10);
        }
    }

    /* access modifiers changed from: package-private */
    public void O0() {
        if (!this.f3297k1 && this.f3312s) {
            androidx.core.view.x.j0(this, this.f3315t1);
            this.f3297k1 = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void P() {
        int i10;
        int i11;
        if (this.K == null) {
            EdgeEffect a10 = this.I.a(this, 1);
            this.K = a10;
            if (this.f3288g) {
                i11 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
                i10 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            } else {
                i11 = getMeasuredWidth();
                i10 = getMeasuredHeight();
            }
            a10.setSize(i11, i10);
        }
    }

    /* access modifiers changed from: package-private */
    public String Q() {
        return " " + super.toString() + ", adapter:" + this.f3298l + ", layout:" + this.f3300m + ", context:" + getContext();
    }

    /* access modifiers changed from: package-private */
    public final void R(z zVar) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.f3278b1.f3335c;
            zVar.f3420p = overScroller.getFinalX() - overScroller.getCurrX();
            overScroller.getFinalY();
            overScroller.getCurrY();
            return;
        }
        zVar.f3420p = 0;
    }

    /* access modifiers changed from: package-private */
    public void R0(boolean z10) {
        this.F = z10 | this.F;
        this.E = true;
        z0();
    }

    public View S(float f10, float f11) {
        for (int g10 = this.f3284e.g() - 1; g10 >= 0; g10--) {
            View f12 = this.f3284e.f(g10);
            float translationX = f12.getTranslationX();
            float translationY = f12.getTranslationY();
            if (f10 >= ((float) f12.getLeft()) + translationX && f10 <= ((float) f12.getRight()) + translationX && f11 >= ((float) f12.getTop()) + translationY && f11 <= ((float) f12.getBottom()) + translationY) {
                return f12;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0013 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View T(android.view.View r3) {
        /*
            r2 = this;
        L_0x0000:
            android.view.ViewParent r0 = r3.getParent()
            if (r0 == 0) goto L_0x0010
            if (r0 == r2) goto L_0x0010
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L_0x0010
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            goto L_0x0000
        L_0x0010:
            if (r0 != r2) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            r3 = 0
        L_0x0014:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.T(android.view.View):android.view.View");
    }

    /* access modifiers changed from: package-private */
    public void T0(c0 c0Var, m.c cVar) {
        c0Var.setFlags(0, 8192);
        if (this.f3285e1.f3413i && c0Var.isUpdated() && !c0Var.isRemoved() && !c0Var.shouldIgnore()) {
            this.f3286f.c(e0(c0Var), c0Var);
        }
        this.f3286f.e(c0Var, cVar);
    }

    public c0 U(View view) {
        View T2 = T(view);
        if (T2 == null) {
            return null;
        }
        return g0(T2);
    }

    /* access modifiers changed from: package-private */
    public void W0() {
        m mVar = this.N;
        if (mVar != null) {
            mVar.endAnimations();
        }
        p pVar = this.f3300m;
        if (pVar != null) {
            pVar.w1(this.f3276b);
            this.f3300m.x1(this.f3276b);
        }
        this.f3276b.c();
    }

    /* access modifiers changed from: package-private */
    public boolean X0(View view) {
        t1();
        boolean r10 = this.f3284e.r(view);
        if (r10) {
            c0 h02 = h0(view);
            this.f3276b.J(h02);
            this.f3276b.C(h02);
        }
        v1(!r10);
        return r10;
    }

    public void Y0(o oVar) {
        p pVar = this.f3300m;
        if (pVar != null) {
            pVar.r("Cannot remove item decoration during a scroll  or layout");
        }
        this.f3306p.remove(oVar);
        if (this.f3306p.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        y0();
        requestLayout();
    }

    public c0 Z(int i10) {
        c0 c0Var = null;
        if (this.E) {
            return null;
        }
        int j10 = this.f3284e.j();
        for (int i11 = 0; i11 < j10; i11++) {
            c0 h02 = h0(this.f3284e.i(i11));
            if (h02 != null && !h02.isRemoved() && d0(h02) == i10) {
                if (!this.f3284e.n(h02.itemView)) {
                    return h02;
                }
                c0Var = h02;
            }
        }
        return c0Var;
    }

    public void Z0(q qVar) {
        List<q> list = this.D;
        if (list != null) {
            list.remove(qVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i10, int i11) {
        if (i10 < 0) {
            N();
            if (this.J.isFinished()) {
                this.J.onAbsorb(-i10);
            }
        } else if (i10 > 0) {
            O();
            if (this.L.isFinished()) {
                this.L.onAbsorb(i10);
            }
        }
        if (i11 < 0) {
            P();
            if (this.K.isFinished()) {
                this.K.onAbsorb(-i11);
            }
        } else if (i11 > 0) {
            M();
            if (this.M.isFinished()) {
                this.M.onAbsorb(i11);
            }
        }
        if (i10 != 0 || i11 != 0) {
            androidx.core.view.x.h0(this);
        }
    }

    public c0 a0(long j10) {
        h hVar = this.f3298l;
        c0 c0Var = null;
        if (hVar != null && hVar.hasStableIds()) {
            int j11 = this.f3284e.j();
            for (int i10 = 0; i10 < j11; i10++) {
                c0 h02 = h0(this.f3284e.i(i10));
                if (h02 != null && !h02.isRemoved() && h02.getItemId() == j10) {
                    if (!this.f3284e.n(h02.itemView)) {
                        return h02;
                    }
                    c0Var = h02;
                }
            }
        }
        return c0Var;
    }

    public void a1(s sVar) {
        this.f3308q.remove(sVar);
        if (this.f3310r == sVar) {
            this.f3310r = null;
        }
    }

    public void addFocusables(ArrayList<View> arrayList, int i10, int i11) {
        p pVar = this.f3300m;
        if (pVar == null || !pVar.Q0(this, arrayList, i10, i11)) {
            super.addFocusables(arrayList, i10, i11);
        }
    }

    /* access modifiers changed from: package-private */
    public c0 b0(int i10, boolean z10) {
        int j10 = this.f3284e.j();
        c0 c0Var = null;
        for (int i11 = 0; i11 < j10; i11++) {
            c0 h02 = h0(this.f3284e.i(i11));
            if (h02 != null && !h02.isRemoved()) {
                if (z10) {
                    if (h02.mPosition != i10) {
                        continue;
                    }
                } else if (h02.getLayoutPosition() != i10) {
                    continue;
                }
                if (!this.f3284e.n(h02.itemView)) {
                    return h02;
                }
                c0Var = h02;
            }
        }
        return c0Var;
    }

    public void b1(t tVar) {
        List<t> list = this.f3289g1;
        if (list != null) {
            list.remove(tVar);
        }
    }

    public boolean c0(int i10, int i11) {
        p pVar = this.f3300m;
        if (pVar == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.f3324y) {
            return false;
        } else {
            boolean w10 = pVar.w();
            boolean x10 = this.f3300m.x();
            if (!w10 || Math.abs(i10) < this.f3274a0) {
                i10 = 0;
            }
            if (!x10 || Math.abs(i11) < this.f3274a0) {
                i11 = 0;
            }
            if (i10 == 0 && i11 == 0) {
                return false;
            }
            float f10 = (float) i10;
            float f11 = (float) i11;
            if (!dispatchNestedPreFling(f10, f11)) {
                boolean z10 = w10 || x10;
                dispatchNestedFling(f10, f11, z10);
                r rVar = this.W;
                if (rVar != null && rVar.a(i10, i11)) {
                    return true;
                }
                if (z10) {
                    if (x10) {
                        w10 |= true;
                    }
                    u1(w10 ? 1 : 0, 1);
                    int i12 = this.f3277b0;
                    int max = Math.max(-i12, Math.min(i10, i12));
                    int i13 = this.f3277b0;
                    this.f3278b1.b(max, Math.max(-i13, Math.min(i11, i13)));
                    return true;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void c1() {
        c0 c0Var;
        int g10 = this.f3284e.g();
        for (int i10 = 0; i10 < g10; i10++) {
            View f10 = this.f3284e.f(i10);
            c0 g02 = g0(f10);
            if (!(g02 == null || (c0Var = g02.mShadowingHolder) == null)) {
                View view = c0Var.itemView;
                int left = f10.getLeft();
                int top = f10.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.f3300m.y((LayoutParams) layoutParams);
    }

    public int computeHorizontalScrollExtent() {
        p pVar = this.f3300m;
        if (pVar != null && pVar.w()) {
            return this.f3300m.C(this.f3285e1);
        }
        return 0;
    }

    public int computeHorizontalScrollOffset() {
        p pVar = this.f3300m;
        if (pVar != null && pVar.w()) {
            return this.f3300m.D(this.f3285e1);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        p pVar = this.f3300m;
        if (pVar != null && pVar.w()) {
            return this.f3300m.E(this.f3285e1);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        p pVar = this.f3300m;
        if (pVar != null && pVar.x()) {
            return this.f3300m.F(this.f3285e1);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        p pVar = this.f3300m;
        if (pVar != null && pVar.x()) {
            return this.f3300m.G(this.f3285e1);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        p pVar = this.f3300m;
        if (pVar != null && pVar.x()) {
            return this.f3300m.H(this.f3285e1);
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int d0(c0 c0Var) {
        if (c0Var.hasAnyOfTheFlags(524) || !c0Var.isBound()) {
            return -1;
        }
        return this.f3282d.e(c0Var.mPosition);
    }

    public boolean dispatchNestedFling(float f10, float f11, boolean z10) {
        return getScrollingChildHelper().a(f10, f11, z10);
    }

    public boolean dispatchNestedPreFling(float f10, float f11) {
        return getScrollingChildHelper().b(f10, f11);
    }

    public boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i10, i11, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr) {
        return getScrollingChildHelper().f(i10, i11, i12, i13, iArr);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    public void draw(Canvas canvas) {
        boolean z10;
        int i10;
        float f10;
        super.draw(canvas);
        int size = this.f3306p.size();
        boolean z11 = false;
        for (int i11 = 0; i11 < size; i11++) {
            this.f3306p.get(i11).k(canvas, this, this.f3285e1);
        }
        EdgeEffect edgeEffect = this.J;
        boolean z12 = true;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z10 = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.f3288g ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) ((-getHeight()) + paddingBottom), 0.0f);
            EdgeEffect edgeEffect2 = this.J;
            z10 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.K;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.f3288g) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.K;
            z10 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.L;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f3288g ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate((float) paddingTop, (float) (-width));
            EdgeEffect edgeEffect6 = this.L;
            z10 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.M;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f3288g) {
                f10 = (float) ((-getWidth()) + getPaddingRight());
                i10 = (-getHeight()) + getPaddingBottom();
            } else {
                f10 = (float) (-getWidth());
                i10 = -getHeight();
            }
            canvas.translate(f10, (float) i10);
            EdgeEffect edgeEffect8 = this.M;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z11 = true;
            }
            z10 |= z11;
            canvas.restoreToCount(save4);
        }
        if (z10 || this.N == null || this.f3306p.size() <= 0 || !this.N.isRunning()) {
            z12 = z10;
        }
        if (z12) {
            androidx.core.view.x.h0(this);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j10) {
        return super.drawChild(canvas, view, j10);
    }

    /* access modifiers changed from: package-private */
    public long e0(c0 c0Var) {
        return this.f3298l.hasStableIds() ? c0Var.getItemId() : (long) c0Var.mPosition;
    }

    public int f0(View view) {
        c0 h02 = h0(view);
        if (h02 != null) {
            return h02.getLayoutPosition();
        }
        return -1;
    }

    public View focusSearch(View view, int i10) {
        View view2;
        boolean z10;
        View b12 = this.f3300m.b1(view, i10);
        if (b12 != null) {
            return b12;
        }
        boolean z11 = true;
        boolean z12 = this.f3298l != null && this.f3300m != null && !v0() && !this.f3324y;
        FocusFinder instance = FocusFinder.getInstance();
        if (!z12 || !(i10 == 2 || i10 == 1)) {
            View findNextFocus = instance.findNextFocus(this, view, i10);
            if (findNextFocus != null || !z12) {
                view2 = findNextFocus;
            } else {
                v();
                if (T(view) == null) {
                    return null;
                }
                t1();
                view2 = this.f3300m.U0(view, i10, this.f3276b, this.f3285e1);
                v1(false);
            }
        } else {
            if (this.f3300m.x()) {
                int i11 = i10 == 2 ? 130 : 33;
                z10 = instance.findNextFocus(this, view, i11) == null;
                if (D1) {
                    i10 = i11;
                }
            } else {
                z10 = false;
            }
            if (!z10 && this.f3300m.w()) {
                int i12 = (this.f3300m.n0() == 1) ^ (i10 == 2) ? 66 : 17;
                if (instance.findNextFocus(this, view, i12) != null) {
                    z11 = false;
                }
                if (D1) {
                    i10 = i12;
                }
                z10 = z11;
            }
            if (z10) {
                v();
                if (T(view) == null) {
                    return null;
                }
                t1();
                this.f3300m.U0(view, i10, this.f3276b, this.f3285e1);
                v1(false);
            }
            view2 = instance.findNextFocus(this, view, i10);
        }
        if (view2 == null || view2.hasFocusable()) {
            return w0(view, view2, i10) ? view2 : super.focusSearch(view, i10);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i10);
        }
        d1(view2, (View) null);
        return view;
    }

    public c0 g0(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return h0(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        p pVar = this.f3300m;
        if (pVar != null) {
            return pVar.R();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + Q());
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        p pVar = this.f3300m;
        if (pVar != null) {
            return pVar.S(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + Q());
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        p pVar = this.f3300m;
        if (pVar != null) {
            return pVar.T(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + Q());
    }

    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public h getAdapter() {
        return this.f3298l;
    }

    public int getBaseline() {
        p pVar = this.f3300m;
        return pVar != null ? pVar.U() : super.getBaseline();
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i10, int i11) {
        k kVar = this.f3301m1;
        return kVar == null ? super.getChildDrawingOrder(i10, i11) : kVar.a(i10, i11);
    }

    public boolean getClipToPadding() {
        return this.f3288g;
    }

    public u getCompatAccessibilityDelegate() {
        return this.f3299l1;
    }

    public l getEdgeEffectFactory() {
        return this.I;
    }

    public m getItemAnimator() {
        return this.N;
    }

    public int getItemDecorationCount() {
        return this.f3306p.size();
    }

    public p getLayoutManager() {
        return this.f3300m;
    }

    public int getMaxFlingVelocity() {
        return this.f3277b0;
    }

    public int getMinFlingVelocity() {
        return this.f3274a0;
    }

    /* access modifiers changed from: package-private */
    public long getNanoTime() {
        if (C1) {
            return System.nanoTime();
        }
        return 0;
    }

    public r getOnFlingListener() {
        return this.W;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f3275a1;
    }

    public u getRecycledViewPool() {
        return this.f3276b.i();
    }

    public int getScrollState() {
        return this.O;
    }

    public void h(o oVar) {
        i(oVar, -1);
    }

    /* access modifiers changed from: package-private */
    public void h1() {
        int j10 = this.f3284e.j();
        for (int i10 = 0; i10 < j10; i10++) {
            c0 h02 = h0(this.f3284e.i(i10));
            if (!h02.shouldIgnore()) {
                h02.saveOldPosition();
            }
        }
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().j();
    }

    public void i(o oVar, int i10) {
        p pVar = this.f3300m;
        if (pVar != null) {
            pVar.r("Cannot add item decoration during a scroll  or layout");
        }
        if (this.f3306p.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i10 < 0) {
            this.f3306p.add(oVar);
        } else {
            this.f3306p.add(i10, oVar);
        }
        y0();
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public boolean i1(int i10, int i11, MotionEvent motionEvent, int i12) {
        int i13;
        int i14;
        int i15;
        int i16;
        int i17 = i10;
        int i18 = i11;
        MotionEvent motionEvent2 = motionEvent;
        v();
        if (this.f3298l != null) {
            int[] iArr = this.f3311r1;
            iArr[0] = 0;
            iArr[1] = 0;
            j1(i17, i18, iArr);
            int[] iArr2 = this.f3311r1;
            int i19 = iArr2[0];
            int i20 = iArr2[1];
            i16 = i20;
            i15 = i19;
            i14 = i17 - i19;
            i13 = i18 - i20;
        } else {
            i16 = 0;
            i15 = 0;
            i14 = 0;
            i13 = 0;
        }
        if (!this.f3306p.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.f3311r1;
        iArr3[0] = 0;
        iArr3[1] = 0;
        H(i15, i16, i14, i13, this.f3307p1, i12, iArr3);
        int[] iArr4 = this.f3311r1;
        int i21 = i14 - iArr4[0];
        int i22 = i13 - iArr4[1];
        boolean z10 = (iArr4[0] == 0 && iArr4[1] == 0) ? false : true;
        int i23 = this.T;
        int[] iArr5 = this.f3307p1;
        this.T = i23 - iArr5[0];
        this.U -= iArr5[1];
        int[] iArr6 = this.f3309q1;
        iArr6[0] = iArr6[0] + iArr5[0];
        iArr6[1] = iArr6[1] + iArr5[1];
        if (getOverScrollMode() != 2) {
            if (motionEvent2 != null && !androidx.core.view.k.a(motionEvent2, 8194)) {
                S0(motionEvent.getX(), (float) i21, motionEvent.getY(), (float) i22);
            }
            u(i10, i11);
        }
        if (!(i15 == 0 && i16 == 0)) {
            J(i15, i16);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z10 && i15 == 0 && i16 == 0) ? false : true;
    }

    public boolean isAttachedToWindow() {
        return this.f3312s;
    }

    public final boolean isLayoutSuppressed() {
        return this.f3324y;
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().l();
    }

    public void j(q qVar) {
        if (this.D == null) {
            this.D = new ArrayList();
        }
        this.D.add(qVar);
    }

    /* access modifiers changed from: package-private */
    public void j1(int i10, int i11, int[] iArr) {
        t1();
        I0();
        t0.i.a("RV Scroll");
        R(this.f3285e1);
        int I1 = i10 != 0 ? this.f3300m.I1(i10, this.f3276b, this.f3285e1) : 0;
        int K1 = i11 != 0 ? this.f3300m.K1(i11, this.f3276b, this.f3285e1) : 0;
        t0.i.b();
        c1();
        J0();
        v1(false);
        if (iArr != null) {
            iArr[0] = I1;
            iArr[1] = K1;
        }
    }

    public void k(s sVar) {
        this.f3308q.add(sVar);
    }

    public void k1(int i10) {
        if (!this.f3324y) {
            x1();
            p pVar = this.f3300m;
            if (pVar == null) {
                Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
                return;
            }
            pVar.J1(i10);
            awakenScrollBars();
        }
    }

    public void l(t tVar) {
        if (this.f3289g1 == null) {
            this.f3289g1 = new ArrayList();
        }
        this.f3289g1.add(tVar);
    }

    /* access modifiers changed from: package-private */
    public Rect l0(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.f3328c) {
            return layoutParams.f3327b;
        }
        if (this.f3285e1.f() && (layoutParams.b() || layoutParams.d())) {
            return layoutParams.f3327b;
        }
        Rect rect = layoutParams.f3327b;
        rect.set(0, 0, 0, 0);
        int size = this.f3306p.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f3292i.set(0, 0, 0, 0);
            this.f3306p.get(i10).g(this.f3292i, view, this, this.f3285e1);
            int i11 = rect.left;
            Rect rect2 = this.f3292i;
            rect.left = i11 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        layoutParams.f3328c = false;
        return rect;
    }

    /* access modifiers changed from: package-private */
    public void m(c0 c0Var, m.c cVar, m.c cVar2) {
        c0Var.setIsRecyclable(false);
        if (this.N.animateAppearance(c0Var, cVar, cVar2)) {
            O0();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean m1(c0 c0Var, int i10) {
        if (v0()) {
            c0Var.mPendingAccessibilityState = i10;
            this.f3313s1.add(c0Var);
            return false;
        }
        androidx.core.view.x.B0(c0Var.itemView, i10);
        return true;
    }

    public boolean n0() {
        return !this.f3318v || this.E || this.f3282d.p();
    }

    /* access modifiers changed from: package-private */
    public boolean n1(AccessibilityEvent accessibilityEvent) {
        int i10 = 0;
        if (!v0()) {
            return false;
        }
        int a10 = accessibilityEvent != null ? x0.b.a(accessibilityEvent) : 0;
        if (a10 != 0) {
            i10 = a10;
        }
        this.A |= i10;
        return true;
    }

    /* access modifiers changed from: package-private */
    public void o(c0 c0Var, m.c cVar, m.c cVar2) {
        g(c0Var);
        c0Var.setIsRecyclable(false);
        if (this.N.animateDisappearance(c0Var, cVar, cVar2)) {
            O0();
        }
    }

    public void o1(int i10, int i11) {
        p1(i10, i11, (Interpolator) null);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.G = 0;
        boolean z10 = true;
        this.f3312s = true;
        if (!this.f3318v || isLayoutRequested()) {
            z10 = false;
        }
        this.f3318v = z10;
        p pVar = this.f3300m;
        if (pVar != null) {
            pVar.N(this);
        }
        this.f3297k1 = false;
        if (C1) {
            ThreadLocal<j> threadLocal = j.f3604e;
            j jVar = threadLocal.get();
            this.f3281c1 = jVar;
            if (jVar == null) {
                this.f3281c1 = new j();
                Display v10 = androidx.core.view.x.v(this);
                float f10 = 60.0f;
                if (!isInEditMode() && v10 != null) {
                    float refreshRate = v10.getRefreshRate();
                    if (refreshRate >= 30.0f) {
                        f10 = refreshRate;
                    }
                }
                j jVar2 = this.f3281c1;
                jVar2.f3608c = (long) (1.0E9f / f10);
                threadLocal.set(jVar2);
            }
            this.f3281c1.a(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        j jVar;
        super.onDetachedFromWindow();
        m mVar = this.N;
        if (mVar != null) {
            mVar.endAnimations();
        }
        x1();
        this.f3312s = false;
        p pVar = this.f3300m;
        if (pVar != null) {
            pVar.O(this, this.f3276b);
        }
        this.f3313s1.clear();
        removeCallbacks(this.f3315t1);
        this.f3286f.j();
        if (C1 && (jVar = this.f3281c1) != null) {
            jVar.j(this);
            this.f3281c1 = null;
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.f3306p.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f3306p.get(i10).i(canvas, this, this.f3285e1);
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f10;
        float f11;
        if (this.f3300m != null && !this.f3324y && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f11 = this.f3300m.x() ? -motionEvent.getAxisValue(9) : 0.0f;
                if (this.f3300m.w()) {
                    f10 = motionEvent.getAxisValue(10);
                    if (!(f11 == 0.0f && f10 == 0.0f)) {
                        A0((int) (f10 * this.f3280c0), (int) (f11 * this.Z0), motionEvent, 1);
                    }
                }
            } else {
                if ((motionEvent.getSource() & 4194304) != 0) {
                    float axisValue = motionEvent.getAxisValue(26);
                    if (this.f3300m.x()) {
                        f11 = -axisValue;
                    } else if (this.f3300m.w()) {
                        f10 = axisValue;
                        f11 = 0.0f;
                        A0((int) (f10 * this.f3280c0), (int) (f11 * this.Z0), motionEvent, 1);
                    }
                }
                f11 = 0.0f;
                f10 = 0.0f;
                A0((int) (f10 * this.f3280c0), (int) (f11 * this.Z0), motionEvent, 1);
            }
            f10 = 0.0f;
            A0((int) (f10 * this.f3280c0), (int) (f11 * this.Z0), motionEvent, 1);
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        if (this.f3324y) {
            return false;
        }
        this.f3310r = null;
        if (V(motionEvent)) {
            r();
            return true;
        }
        p pVar = this.f3300m;
        if (pVar == null) {
            return false;
        }
        boolean w10 = pVar.w();
        boolean x10 = this.f3300m.x();
        if (this.Q == null) {
            this.Q = VelocityTracker.obtain();
        }
        this.Q.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.f3325z) {
                this.f3325z = false;
            }
            this.P = motionEvent.getPointerId(0);
            int x11 = (int) (motionEvent.getX() + 0.5f);
            this.T = x11;
            this.R = x11;
            int y10 = (int) (motionEvent.getY() + 0.5f);
            this.U = y10;
            this.S = y10;
            if (this.O == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                w1(1);
            }
            int[] iArr = this.f3309q1;
            iArr[1] = 0;
            iArr[0] = 0;
            if (x10) {
                w10 |= true;
            }
            u1(w10 ? 1 : 0, 0);
        } else if (actionMasked == 1) {
            this.Q.clear();
            w1(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.P);
            if (findPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.P + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x12 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y11 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.O != 1) {
                int i10 = x12 - this.R;
                int i11 = y11 - this.S;
                if (!w10 || Math.abs(i10) <= this.V) {
                    z10 = false;
                } else {
                    this.T = x12;
                    z10 = true;
                }
                if (x10 && Math.abs(i11) > this.V) {
                    this.U = y11;
                    z10 = true;
                }
                if (z10) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            r();
        } else if (actionMasked == 5) {
            this.P = motionEvent.getPointerId(actionIndex);
            int x13 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.T = x13;
            this.R = x13;
            int y12 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.U = y12;
            this.S = y12;
        } else if (actionMasked == 6) {
            L0(motionEvent);
        }
        return this.O == 1;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        t0.i.a("RV OnLayout");
        C();
        t0.i.b();
        this.f3318v = true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        p pVar = this.f3300m;
        if (pVar == null) {
            x(i10, i11);
            return;
        }
        boolean z10 = false;
        if (pVar.C0()) {
            int mode = View.MeasureSpec.getMode(i10);
            int mode2 = View.MeasureSpec.getMode(i11);
            this.f3300m.k1(this.f3276b, this.f3285e1, i10, i11);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z10 = true;
            }
            this.f3317u1 = z10;
            if (!z10 && this.f3298l != null) {
                if (this.f3285e1.f3409e == 1) {
                    D();
                }
                this.f3300m.M1(i10, i11);
                this.f3285e1.f3414j = true;
                E();
                this.f3300m.P1(i10, i11);
                if (this.f3300m.S1()) {
                    this.f3300m.M1(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.f3285e1.f3414j = true;
                    E();
                    this.f3300m.P1(i10, i11);
                }
                this.f3319v1 = getMeasuredWidth();
                this.f3321w1 = getMeasuredHeight();
            }
        } else if (this.f3314t) {
            this.f3300m.k1(this.f3276b, this.f3285e1, i10, i11);
        } else {
            if (this.B) {
                t1();
                I0();
                Q0();
                J0();
                z zVar = this.f3285e1;
                if (zVar.f3416l) {
                    zVar.f3412h = true;
                } else {
                    this.f3282d.j();
                    this.f3285e1.f3412h = false;
                }
                this.B = false;
                v1(false);
            } else if (this.f3285e1.f3416l) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            h hVar = this.f3298l;
            if (hVar != null) {
                this.f3285e1.f3410f = hVar.getItemCount();
            } else {
                this.f3285e1.f3410f = 0;
            }
            t1();
            this.f3300m.k1(this.f3276b, this.f3285e1, i10, i11);
            v1(false);
            this.f3285e1.f3412h = false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i10, Rect rect) {
        if (v0()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i10, rect);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.f3279c = savedState;
        super.onRestoreInstanceState(savedState.a());
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.f3279c;
        if (savedState2 != null) {
            savedState.b(savedState2);
        } else {
            p pVar = this.f3300m;
            savedState.f3330c = pVar != null ? pVar.o1() : null;
        }
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (i10 != i12 || i11 != i13) {
            t0();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00f4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r6 = r17
            r7 = r18
            boolean r0 = r6.f3324y
            r8 = 0
            if (r0 != 0) goto L_0x01db
            boolean r0 = r6.f3325z
            if (r0 == 0) goto L_0x000f
            goto L_0x01db
        L_0x000f:
            boolean r0 = r17.L(r18)
            r9 = 1
            if (r0 == 0) goto L_0x001a
            r17.r()
            return r9
        L_0x001a:
            androidx.recyclerview.widget.RecyclerView$p r0 = r6.f3300m
            if (r0 != 0) goto L_0x001f
            return r8
        L_0x001f:
            boolean r10 = r0.w()
            androidx.recyclerview.widget.RecyclerView$p r0 = r6.f3300m
            boolean r11 = r0.x()
            android.view.VelocityTracker r0 = r6.Q
            if (r0 != 0) goto L_0x0033
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r6.Q = r0
        L_0x0033:
            int r0 = r18.getActionMasked()
            int r1 = r18.getActionIndex()
            if (r0 != 0) goto L_0x0043
            int[] r2 = r6.f3309q1
            r2[r9] = r8
            r2[r8] = r8
        L_0x0043:
            android.view.MotionEvent r12 = android.view.MotionEvent.obtain(r18)
            int[] r2 = r6.f3309q1
            r3 = r2[r8]
            float r3 = (float) r3
            r2 = r2[r9]
            float r2 = (float) r2
            r12.offsetLocation(r3, r2)
            r2 = 1056964608(0x3f000000, float:0.5)
            if (r0 == 0) goto L_0x01af
            if (r0 == r9) goto L_0x016d
            r3 = 2
            if (r0 == r3) goto L_0x008c
            r3 = 3
            if (r0 == r3) goto L_0x0087
            r3 = 5
            if (r0 == r3) goto L_0x006b
            r1 = 6
            if (r0 == r1) goto L_0x0066
            goto L_0x01d0
        L_0x0066:
            r17.L0(r18)
            goto L_0x01d0
        L_0x006b:
            int r0 = r7.getPointerId(r1)
            r6.P = r0
            float r0 = r7.getX(r1)
            float r0 = r0 + r2
            int r0 = (int) r0
            r6.T = r0
            r6.R = r0
            float r0 = r7.getY(r1)
            float r0 = r0 + r2
            int r0 = (int) r0
            r6.U = r0
            r6.S = r0
            goto L_0x01d0
        L_0x0087:
            r17.r()
            goto L_0x01d0
        L_0x008c:
            int r0 = r6.P
            int r0 = r7.findPointerIndex(r0)
            if (r0 >= 0) goto L_0x00b2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Error processing scroll; pointer index for id "
            r0.append(r1)
            int r1 = r6.P
            r0.append(r1)
            java.lang.String r1 = " not found. Did any MotionEvents get skipped?"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "RecyclerView"
            android.util.Log.e(r1, r0)
            return r8
        L_0x00b2:
            float r1 = r7.getX(r0)
            float r1 = r1 + r2
            int r13 = (int) r1
            float r0 = r7.getY(r0)
            float r0 = r0 + r2
            int r14 = (int) r0
            int r0 = r6.T
            int r0 = r0 - r13
            int r1 = r6.U
            int r1 = r1 - r14
            int r2 = r6.O
            if (r2 == r9) goto L_0x00f7
            if (r10 == 0) goto L_0x00dd
            int r2 = r6.V
            if (r0 <= 0) goto L_0x00d4
            int r0 = r0 - r2
            int r0 = java.lang.Math.max(r8, r0)
            goto L_0x00d9
        L_0x00d4:
            int r0 = r0 + r2
            int r0 = java.lang.Math.min(r8, r0)
        L_0x00d9:
            if (r0 == 0) goto L_0x00dd
            r2 = r9
            goto L_0x00de
        L_0x00dd:
            r2 = r8
        L_0x00de:
            if (r11 == 0) goto L_0x00f2
            int r3 = r6.V
            if (r1 <= 0) goto L_0x00ea
            int r1 = r1 - r3
            int r1 = java.lang.Math.max(r8, r1)
            goto L_0x00ef
        L_0x00ea:
            int r1 = r1 + r3
            int r1 = java.lang.Math.min(r8, r1)
        L_0x00ef:
            if (r1 == 0) goto L_0x00f2
            r2 = r9
        L_0x00f2:
            if (r2 == 0) goto L_0x00f7
            r6.setScrollState(r9)
        L_0x00f7:
            r15 = r0
            r16 = r1
            int r0 = r6.O
            if (r0 != r9) goto L_0x01d0
            int[] r3 = r6.f3311r1
            r3[r8] = r8
            r3[r9] = r8
            if (r10 == 0) goto L_0x0108
            r1 = r15
            goto L_0x0109
        L_0x0108:
            r1 = r8
        L_0x0109:
            if (r11 == 0) goto L_0x010e
            r2 = r16
            goto L_0x010f
        L_0x010e:
            r2 = r8
        L_0x010f:
            int[] r4 = r6.f3307p1
            r5 = 0
            r0 = r17
            boolean r0 = r0.G(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x013c
            int[] r0 = r6.f3311r1
            r1 = r0[r8]
            int r15 = r15 - r1
            r0 = r0[r9]
            int r16 = r16 - r0
            int[] r0 = r6.f3309q1
            r1 = r0[r8]
            int[] r2 = r6.f3307p1
            r3 = r2[r8]
            int r1 = r1 + r3
            r0[r8] = r1
            r1 = r0[r9]
            r2 = r2[r9]
            int r1 = r1 + r2
            r0[r9] = r1
            android.view.ViewParent r0 = r17.getParent()
            r0.requestDisallowInterceptTouchEvent(r9)
        L_0x013c:
            r0 = r16
            int[] r1 = r6.f3307p1
            r2 = r1[r8]
            int r13 = r13 - r2
            r6.T = r13
            r1 = r1[r9]
            int r14 = r14 - r1
            r6.U = r14
            if (r10 == 0) goto L_0x014e
            r1 = r15
            goto L_0x014f
        L_0x014e:
            r1 = r8
        L_0x014f:
            if (r11 == 0) goto L_0x0153
            r2 = r0
            goto L_0x0154
        L_0x0153:
            r2 = r8
        L_0x0154:
            boolean r1 = r6.i1(r1, r2, r7, r8)
            if (r1 == 0) goto L_0x0161
            android.view.ViewParent r1 = r17.getParent()
            r1.requestDisallowInterceptTouchEvent(r9)
        L_0x0161:
            androidx.recyclerview.widget.j r1 = r6.f3281c1
            if (r1 == 0) goto L_0x01d0
            if (r15 != 0) goto L_0x0169
            if (r0 == 0) goto L_0x01d0
        L_0x0169:
            r1.f(r6, r15, r0)
            goto L_0x01d0
        L_0x016d:
            android.view.VelocityTracker r0 = r6.Q
            r0.addMovement(r12)
            android.view.VelocityTracker r0 = r6.Q
            r1 = 1000(0x3e8, float:1.401E-42)
            int r2 = r6.f3277b0
            float r2 = (float) r2
            r0.computeCurrentVelocity(r1, r2)
            r0 = 0
            if (r10 == 0) goto L_0x0189
            android.view.VelocityTracker r1 = r6.Q
            int r2 = r6.P
            float r1 = r1.getXVelocity(r2)
            float r1 = -r1
            goto L_0x018a
        L_0x0189:
            r1 = r0
        L_0x018a:
            if (r11 == 0) goto L_0x0196
            android.view.VelocityTracker r2 = r6.Q
            int r3 = r6.P
            float r2 = r2.getYVelocity(r3)
            float r2 = -r2
            goto L_0x0197
        L_0x0196:
            r2 = r0
        L_0x0197:
            int r3 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r3 != 0) goto L_0x019f
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 == 0) goto L_0x01a7
        L_0x019f:
            int r0 = (int) r1
            int r1 = (int) r2
            boolean r0 = r6.c0(r0, r1)
            if (r0 != 0) goto L_0x01aa
        L_0x01a7:
            r6.setScrollState(r8)
        L_0x01aa:
            r17.f1()
            r8 = r9
            goto L_0x01d0
        L_0x01af:
            int r0 = r7.getPointerId(r8)
            r6.P = r0
            float r0 = r18.getX()
            float r0 = r0 + r2
            int r0 = (int) r0
            r6.T = r0
            r6.R = r0
            float r0 = r18.getY()
            float r0 = r0 + r2
            int r0 = (int) r0
            r6.U = r0
            r6.S = r0
            if (r11 == 0) goto L_0x01cd
            r10 = r10 | 2
        L_0x01cd:
            r6.u1(r10, r8)
        L_0x01d0:
            if (r8 != 0) goto L_0x01d7
            android.view.VelocityTracker r0 = r6.Q
            r0.addMovement(r12)
        L_0x01d7:
            r12.recycle()
            return r9
        L_0x01db:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: package-private */
    public void p(String str) {
        if (v0()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + Q());
            }
            throw new IllegalStateException(str);
        } else if (this.H > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + Q()));
        }
    }

    /* access modifiers changed from: package-private */
    public void p0() {
        this.f3282d = new a(new f());
    }

    public void p1(int i10, int i11, Interpolator interpolator) {
        q1(i10, i11, interpolator, Integer.MIN_VALUE);
    }

    /* access modifiers changed from: package-private */
    public boolean q(c0 c0Var) {
        m mVar = this.N;
        return mVar == null || mVar.canReuseUpdatedViewHolder(c0Var, c0Var.getUnmodifiedPayloads());
    }

    public void q1(int i10, int i11, Interpolator interpolator, int i12) {
        r1(i10, i11, interpolator, i12, false);
    }

    /* access modifiers changed from: package-private */
    public void r1(int i10, int i11, Interpolator interpolator, int i12, boolean z10) {
        p pVar = this.f3300m;
        if (pVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.f3324y) {
            int i13 = 0;
            if (!pVar.w()) {
                i10 = 0;
            }
            if (!this.f3300m.x()) {
                i11 = 0;
            }
            if (i10 != 0 || i11 != 0) {
                if (i12 == Integer.MIN_VALUE || i12 > 0) {
                    if (z10) {
                        if (i10 != 0) {
                            i13 = 1;
                        }
                        if (i11 != 0) {
                            i13 |= 2;
                        }
                        u1(i13, 1);
                    }
                    this.f3278b1.e(i10, i11, i12, interpolator);
                    return;
                }
                scrollBy(i10, i11);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void removeDetachedView(View view, boolean z10) {
        c0 h02 = h0(view);
        if (h02 != null) {
            if (h02.isTmpDetached()) {
                h02.clearTmpDetachFlag();
            } else if (!h02.shouldIgnore()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + h02 + Q());
            }
        }
        view.clearAnimation();
        A(view);
        super.removeDetachedView(view, z10);
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.f3300m.m1(this, this.f3285e1, view, view2) && view2 != null) {
            d1(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z10) {
        return this.f3300m.D1(this, view, rect, z10);
    }

    public void requestDisallowInterceptTouchEvent(boolean z10) {
        int size = this.f3308q.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f3308q.get(i10).e(z10);
        }
        super.requestDisallowInterceptTouchEvent(z10);
    }

    public void requestLayout() {
        if (this.f3320w != 0 || this.f3324y) {
            this.f3322x = true;
        } else {
            super.requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public void s0(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + Q());
        }
        Resources resources = getContext().getResources();
        new i(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(p1.b.fastscroll_default_thickness), resources.getDimensionPixelSize(p1.b.fastscroll_minimum_range), resources.getDimensionPixelOffset(p1.b.fastscroll_margin));
    }

    public void s1(int i10) {
        if (!this.f3324y) {
            p pVar = this.f3300m;
            if (pVar == null) {
                Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            } else {
                pVar.U1(this, this.f3285e1, i10);
            }
        }
    }

    public void scrollBy(int i10, int i11) {
        p pVar = this.f3300m;
        if (pVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.f3324y) {
            boolean w10 = pVar.w();
            boolean x10 = this.f3300m.x();
            if (w10 || x10) {
                if (!w10) {
                    i10 = 0;
                }
                if (!x10) {
                    i11 = 0;
                }
                i1(i10, i11, (MotionEvent) null, 0);
            }
        }
    }

    public void scrollTo(int i10, int i11) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!n1(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public void setAccessibilityDelegateCompat(u uVar) {
        this.f3299l1 = uVar;
        androidx.core.view.x.r0(this, uVar);
    }

    public void setAdapter(h hVar) {
        setLayoutFrozen(false);
        l1(hVar, false, true);
        R0(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(k kVar) {
        if (kVar != this.f3301m1) {
            this.f3301m1 = kVar;
            setChildrenDrawingOrderEnabled(kVar != null);
        }
    }

    public void setClipToPadding(boolean z10) {
        if (z10 != this.f3288g) {
            t0();
        }
        this.f3288g = z10;
        super.setClipToPadding(z10);
        if (this.f3318v) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(l lVar) {
        w0.h.e(lVar);
        this.I = lVar;
        t0();
    }

    public void setHasFixedSize(boolean z10) {
        this.f3314t = z10;
    }

    public void setItemAnimator(m mVar) {
        m mVar2 = this.N;
        if (mVar2 != null) {
            mVar2.endAnimations();
            this.N.setListener((m.b) null);
        }
        this.N = mVar;
        if (mVar != null) {
            mVar.setListener(this.f3295j1);
        }
    }

    public void setItemViewCacheSize(int i10) {
        this.f3276b.G(i10);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z10) {
        suppressLayout(z10);
    }

    public void setLayoutManager(p pVar) {
        if (pVar != this.f3300m) {
            x1();
            if (this.f3300m != null) {
                m mVar = this.N;
                if (mVar != null) {
                    mVar.endAnimations();
                }
                this.f3300m.w1(this.f3276b);
                this.f3300m.x1(this.f3276b);
                this.f3276b.c();
                if (this.f3312s) {
                    this.f3300m.O(this, this.f3276b);
                }
                this.f3300m.Q1((RecyclerView) null);
                this.f3300m = null;
            } else {
                this.f3276b.c();
            }
            this.f3284e.o();
            this.f3300m = pVar;
            if (pVar != null) {
                if (pVar.f3352b == null) {
                    pVar.Q1(this);
                    if (this.f3312s) {
                        this.f3300m.N(this);
                    }
                } else {
                    throw new IllegalArgumentException("LayoutManager " + pVar + " is already attached to a RecyclerView:" + pVar.f3352b.Q());
                }
            }
            this.f3276b.K();
            requestLayout();
        }
    }

    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (Build.VERSION.SDK_INT < 18) {
            if (layoutTransition == null) {
                suppressLayout(false);
                return;
            } else if (layoutTransition.getAnimator(0) == null && layoutTransition.getAnimator(1) == null && layoutTransition.getAnimator(2) == null && layoutTransition.getAnimator(3) == null && layoutTransition.getAnimator(4) == null) {
                suppressLayout(true);
                return;
            }
        }
        if (layoutTransition == null) {
            super.setLayoutTransition((LayoutTransition) null);
            return;
        }
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    public void setNestedScrollingEnabled(boolean z10) {
        getScrollingChildHelper().m(z10);
    }

    public void setOnFlingListener(r rVar) {
        this.W = rVar;
    }

    @Deprecated
    public void setOnScrollListener(t tVar) {
        this.f3287f1 = tVar;
    }

    public void setPreserveFocusAfterLayout(boolean z10) {
        this.f3275a1 = z10;
    }

    public void setRecycledViewPool(u uVar) {
        this.f3276b.E(uVar);
    }

    @Deprecated
    public void setRecyclerListener(w wVar) {
        this.f3302n = wVar;
    }

    /* access modifiers changed from: package-private */
    public void setScrollState(int i10) {
        if (i10 != this.O) {
            this.O = i10;
            if (i10 != 2) {
                y1();
            }
            I(i10);
        }
    }

    public void setScrollingTouchSlop(int i10) {
        int i11;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i10 != 0) {
            if (i10 != 1) {
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i10 + "; using default value");
            } else {
                i11 = viewConfiguration.getScaledPagingTouchSlop();
                this.V = i11;
            }
        }
        i11 = viewConfiguration.getScaledTouchSlop();
        this.V = i11;
    }

    public void setViewCacheExtension(a0 a0Var) {
        this.f3276b.F(a0Var);
    }

    public boolean startNestedScroll(int i10) {
        return getScrollingChildHelper().o(i10);
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().q();
    }

    public final void suppressLayout(boolean z10) {
        if (z10 != this.f3324y) {
            p("Do not suppressLayout in layout or scroll");
            if (!z10) {
                this.f3324y = false;
                if (!(!this.f3322x || this.f3300m == null || this.f3298l == null)) {
                    requestLayout();
                }
                this.f3322x = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.f3324y = true;
            this.f3325z = true;
            x1();
        }
    }

    /* access modifiers changed from: package-private */
    public void t() {
        int j10 = this.f3284e.j();
        for (int i10 = 0; i10 < j10; i10++) {
            c0 h02 = h0(this.f3284e.i(i10));
            if (!h02.shouldIgnore()) {
                h02.clearOldPosition();
            }
        }
        this.f3276b.d();
    }

    /* access modifiers changed from: package-private */
    public void t0() {
        this.M = null;
        this.K = null;
        this.L = null;
        this.J = null;
    }

    /* access modifiers changed from: package-private */
    public void t1() {
        int i10 = this.f3320w + 1;
        this.f3320w = i10;
        if (i10 == 1 && !this.f3324y) {
            this.f3322x = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void u(int i10, int i11) {
        boolean z10;
        EdgeEffect edgeEffect = this.J;
        if (edgeEffect == null || edgeEffect.isFinished() || i10 <= 0) {
            z10 = false;
        } else {
            this.J.onRelease();
            z10 = this.J.isFinished();
        }
        EdgeEffect edgeEffect2 = this.L;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i10 < 0) {
            this.L.onRelease();
            z10 |= this.L.isFinished();
        }
        EdgeEffect edgeEffect3 = this.K;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i11 > 0) {
            this.K.onRelease();
            z10 |= this.K.isFinished();
        }
        EdgeEffect edgeEffect4 = this.M;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i11 < 0) {
            this.M.onRelease();
            z10 |= this.M.isFinished();
        }
        if (z10) {
            androidx.core.view.x.h0(this);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean u0() {
        AccessibilityManager accessibilityManager = this.C;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public boolean u1(int i10, int i11) {
        return getScrollingChildHelper().p(i10, i11);
    }

    /* access modifiers changed from: package-private */
    public void v() {
        if (!this.f3318v || this.E) {
            t0.i.a("RV FullInvalidate");
            C();
            t0.i.b();
        } else if (this.f3282d.p()) {
            if (this.f3282d.o(4) && !this.f3282d.o(11)) {
                t0.i.a("RV PartialInvalidate");
                t1();
                I0();
                this.f3282d.w();
                if (!this.f3322x) {
                    if (o0()) {
                        C();
                    } else {
                        this.f3282d.i();
                    }
                }
                v1(true);
                J0();
            } else if (this.f3282d.p()) {
                t0.i.a("RV FullInvalidate");
                C();
            } else {
                return;
            }
            t0.i.b();
        }
    }

    public boolean v0() {
        return this.G > 0;
    }

    /* access modifiers changed from: package-private */
    public void v1(boolean z10) {
        if (this.f3320w < 1) {
            this.f3320w = 1;
        }
        if (!z10 && !this.f3324y) {
            this.f3322x = false;
        }
        if (this.f3320w == 1) {
            if (z10 && this.f3322x && !this.f3324y && this.f3300m != null && this.f3298l != null) {
                C();
            }
            if (!this.f3324y) {
                this.f3322x = false;
            }
        }
        this.f3320w--;
    }

    public void w1(int i10) {
        getScrollingChildHelper().r(i10);
    }

    /* access modifiers changed from: package-private */
    public void x(int i10, int i11) {
        setMeasuredDimension(p.z(i10, getPaddingLeft() + getPaddingRight(), androidx.core.view.x.E(this)), p.z(i11, getPaddingTop() + getPaddingBottom(), androidx.core.view.x.D(this)));
    }

    /* access modifiers changed from: package-private */
    public void x0(int i10) {
        if (this.f3300m != null) {
            setScrollState(2);
            this.f3300m.J1(i10);
            awakenScrollBars();
        }
    }

    public void x1() {
        setScrollState(0);
        y1();
    }

    /* access modifiers changed from: package-private */
    public void y0() {
        int j10 = this.f3284e.j();
        for (int i10 = 0; i10 < j10; i10++) {
            ((LayoutParams) this.f3284e.i(i10).getLayoutParams()).f3328c = true;
        }
        this.f3276b.s();
    }

    /* access modifiers changed from: package-private */
    public void z(View view) {
        c0 h02 = h0(view);
        G0(view);
        h hVar = this.f3298l;
        if (!(hVar == null || h02 == null)) {
            hVar.onViewAttachedToWindow(h02);
        }
        List<q> list = this.D;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.D.get(size).b(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void z0() {
        int j10 = this.f3284e.j();
        for (int i10 = 0; i10 < j10; i10++) {
            c0 h02 = h0(this.f3284e.i(i10));
            if (h02 != null && !h02.shouldIgnore()) {
                h02.addFlags(6);
            }
        }
        y0();
        this.f3276b.t();
    }

    /* access modifiers changed from: package-private */
    public void z1(int i10, int i11, Object obj) {
        int i12;
        int j10 = this.f3284e.j();
        int i13 = i10 + i11;
        for (int i14 = 0; i14 < j10; i14++) {
            View i15 = this.f3284e.i(i14);
            c0 h02 = h0(i15);
            if (h02 != null && !h02.shouldIgnore() && (i12 = h02.mPosition) >= i10 && i12 < i13) {
                h02.addFlags(2);
                h02.addChangePayload(obj);
                ((LayoutParams) i15.getLayoutParams()).f3328c = true;
            }
        }
        this.f3276b.M(i10, i11);
    }
}
