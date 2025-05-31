package androidx.drawerlayout.widget;

import a1.c;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.f0;
import androidx.core.view.x;
import androidx.customview.view.AbsSavedState;
import java.util.ArrayList;
import java.util.List;
import x0.c;
import x0.f;

public class DrawerLayout extends ViewGroup {
    private static final int[] L = {16843828};
    static final int[] M = {16842931};
    static final boolean N;
    private static final boolean O;
    private static boolean P;
    private CharSequence A;
    private Object B;
    private boolean C;
    private Drawable D;
    private Drawable E;
    private Drawable F;
    private Drawable G;
    private final ArrayList<View> H;
    private Rect I;
    private Matrix J;
    private final x0.f K;

    /* renamed from: a  reason: collision with root package name */
    private final d f2539a;

    /* renamed from: b  reason: collision with root package name */
    private float f2540b;

    /* renamed from: c  reason: collision with root package name */
    private int f2541c;

    /* renamed from: d  reason: collision with root package name */
    private int f2542d;

    /* renamed from: e  reason: collision with root package name */
    private float f2543e;

    /* renamed from: f  reason: collision with root package name */
    private Paint f2544f;

    /* renamed from: g  reason: collision with root package name */
    private final a1.c f2545g;

    /* renamed from: h  reason: collision with root package name */
    private final a1.c f2546h;

    /* renamed from: i  reason: collision with root package name */
    private final f f2547i;

    /* renamed from: j  reason: collision with root package name */
    private final f f2548j;

    /* renamed from: k  reason: collision with root package name */
    private int f2549k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f2550l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f2551m;

    /* renamed from: n  reason: collision with root package name */
    private int f2552n;

    /* renamed from: o  reason: collision with root package name */
    private int f2553o;

    /* renamed from: p  reason: collision with root package name */
    private int f2554p;

    /* renamed from: q  reason: collision with root package name */
    private int f2555q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f2556r;

    /* renamed from: s  reason: collision with root package name */
    private e f2557s;

    /* renamed from: t  reason: collision with root package name */
    private List<e> f2558t;

    /* renamed from: u  reason: collision with root package name */
    private float f2559u;

    /* renamed from: v  reason: collision with root package name */
    private float f2560v;

    /* renamed from: w  reason: collision with root package name */
    private Drawable f2561w;

    /* renamed from: x  reason: collision with root package name */
    private Drawable f2562x;

    /* renamed from: y  reason: collision with root package name */
    private Drawable f2563y;

    /* renamed from: z  reason: collision with root package name */
    private CharSequence f2564z;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f2565a = 0;

        /* renamed from: b  reason: collision with root package name */
        float f2566b;

        /* renamed from: c  reason: collision with root package name */
        boolean f2567c;

        /* renamed from: d  reason: collision with root package name */
        int f2568d;

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.M);
            this.f2565a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.f2565a = layoutParams.f2565a;
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        int f2569c = 0;

        /* renamed from: d  reason: collision with root package name */
        int f2570d;

        /* renamed from: e  reason: collision with root package name */
        int f2571e;

        /* renamed from: f  reason: collision with root package name */
        int f2572f;

        /* renamed from: g  reason: collision with root package name */
        int f2573g;

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

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2569c = parcel.readInt();
            this.f2570d = parcel.readInt();
            this.f2571e = parcel.readInt();
            this.f2572f = parcel.readInt();
            this.f2573g = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f2569c);
            parcel.writeInt(this.f2570d);
            parcel.writeInt(this.f2571e);
            parcel.writeInt(this.f2572f);
            parcel.writeInt(this.f2573g);
        }
    }

    class a implements x0.f {
        a() {
        }

        public boolean a(View view, f.a aVar) {
            if (!DrawerLayout.this.B(view) || DrawerLayout.this.q(view) == 2) {
                return false;
            }
            DrawerLayout.this.e(view);
            return true;
        }
    }

    class b implements View.OnApplyWindowInsetsListener {
        b(DrawerLayout drawerLayout) {
        }

        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            ((DrawerLayout) view).P(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
            return windowInsets.consumeSystemWindowInsets();
        }
    }

    class c extends androidx.core.view.a {

        /* renamed from: d  reason: collision with root package name */
        private final Rect f2575d = new Rect();

        c() {
        }

        private void n(x0.c cVar, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                if (DrawerLayout.z(childAt)) {
                    cVar.c(childAt);
                }
            }
        }

        private void o(x0.c cVar, x0.c cVar2) {
            Rect rect = this.f2575d;
            cVar2.n(rect);
            cVar.Y(rect);
            cVar.G0(cVar2.N());
            cVar.r0(cVar2.v());
            cVar.c0(cVar2.p());
            cVar.g0(cVar2.r());
            cVar.i0(cVar2.F());
            cVar.l0(cVar2.H());
            cVar.V(cVar2.B());
            cVar.z0(cVar2.L());
            cVar.a(cVar2.k());
        }

        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            CharSequence r10;
            if (accessibilityEvent.getEventType() != 32) {
                return super.a(view, accessibilityEvent);
            }
            List text = accessibilityEvent.getText();
            View o10 = DrawerLayout.this.o();
            if (o10 == null || (r10 = DrawerLayout.this.r(DrawerLayout.this.s(o10))) == null) {
                return true;
            }
            text.add(r10);
            return true;
        }

        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            accessibilityEvent.setClassName("androidx.drawerlayout.widget.DrawerLayout");
        }

        public void g(View view, x0.c cVar) {
            if (DrawerLayout.N) {
                super.g(view, cVar);
            } else {
                x0.c Q = x0.c.Q(cVar);
                super.g(view, Q);
                cVar.B0(view);
                ViewParent J = x.J(view);
                if (J instanceof View) {
                    cVar.t0((View) J);
                }
                o(cVar, Q);
                Q.S();
                n(cVar, (ViewGroup) view);
            }
            cVar.c0("androidx.drawerlayout.widget.DrawerLayout");
            cVar.k0(false);
            cVar.l0(false);
            cVar.T(c.a.f18122e);
            cVar.T(c.a.f18123f);
        }

        public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.N || DrawerLayout.z(view)) {
                return super.i(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    static final class d extends androidx.core.view.a {
        d() {
        }

        public void g(View view, x0.c cVar) {
            super.g(view, cVar);
            if (!DrawerLayout.z(view)) {
                cVar.t0((View) null);
            }
        }
    }

    public interface e {
        void a(int i10);

        void b(View view, float f10);

        void c(View view);

        void d(View view);
    }

    private class f extends c.C0002c {

        /* renamed from: a  reason: collision with root package name */
        private final int f2577a;

        /* renamed from: b  reason: collision with root package name */
        private a1.c f2578b;

        /* renamed from: c  reason: collision with root package name */
        private final Runnable f2579c = new a();

        class a implements Runnable {
            a() {
            }

            public void run() {
                f.this.o();
            }
        }

        f(int i10) {
            this.f2577a = i10;
        }

        private void n() {
            int i10 = 3;
            if (this.f2577a == 3) {
                i10 = 5;
            }
            View m10 = DrawerLayout.this.m(i10);
            if (m10 != null) {
                DrawerLayout.this.e(m10);
            }
        }

        public int a(View view, int i10, int i11) {
            int width;
            int width2;
            if (DrawerLayout.this.c(view, 3)) {
                width2 = -view.getWidth();
                width = 0;
            } else {
                width = DrawerLayout.this.getWidth();
                width2 = width - view.getWidth();
            }
            return Math.max(width2, Math.min(i10, width));
        }

        public int b(View view, int i10, int i11) {
            return view.getTop();
        }

        public int d(View view) {
            if (DrawerLayout.this.C(view)) {
                return view.getWidth();
            }
            return 0;
        }

        public void f(int i10, int i11) {
            DrawerLayout drawerLayout;
            int i12;
            if ((i10 & 1) == 1) {
                drawerLayout = DrawerLayout.this;
                i12 = 3;
            } else {
                drawerLayout = DrawerLayout.this;
                i12 = 5;
            }
            View m10 = drawerLayout.m(i12);
            if (m10 != null && DrawerLayout.this.q(m10) == 0) {
                this.f2578b.c(m10, i11);
            }
        }

        public boolean g(int i10) {
            return false;
        }

        public void h(int i10, int i11) {
            DrawerLayout.this.postDelayed(this.f2579c, 160);
        }

        public void i(View view, int i10) {
            ((LayoutParams) view.getLayoutParams()).f2567c = false;
            n();
        }

        public void j(int i10) {
            DrawerLayout.this.U(i10, this.f2578b.w());
        }

        public void k(View view, int i10, int i11, int i12, int i13) {
            int width = view.getWidth();
            float width2 = (DrawerLayout.this.c(view, 3) ? (float) (i10 + width) : (float) (DrawerLayout.this.getWidth() - i10)) / ((float) width);
            DrawerLayout.this.R(view, width2);
            view.setVisibility(width2 == 0.0f ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        public void l(View view, float f10, float f11) {
            int i10;
            float t10 = DrawerLayout.this.t(view);
            int width = view.getWidth();
            if (DrawerLayout.this.c(view, 3)) {
                int i11 = (f10 > 0.0f ? 1 : (f10 == 0.0f ? 0 : -1));
                i10 = (i11 > 0 || (i11 == 0 && t10 > 0.5f)) ? 0 : -width;
            } else {
                int width2 = DrawerLayout.this.getWidth();
                if (f10 < 0.0f || (f10 == 0.0f && t10 > 0.5f)) {
                    width2 -= width;
                }
                i10 = width2;
            }
            this.f2578b.P(i10, view.getTop());
            DrawerLayout.this.invalidate();
        }

        public boolean m(View view, int i10) {
            return DrawerLayout.this.C(view) && DrawerLayout.this.c(view, this.f2577a) && DrawerLayout.this.q(view) == 0;
        }

        /* access modifiers changed from: package-private */
        public void o() {
            View view;
            int i10;
            int y10 = this.f2578b.y();
            int i11 = 0;
            boolean z10 = this.f2577a == 3;
            if (z10) {
                view = DrawerLayout.this.m(3);
                if (view != null) {
                    i11 = -view.getWidth();
                }
                i10 = i11 + y10;
            } else {
                view = DrawerLayout.this.m(5);
                i10 = DrawerLayout.this.getWidth() - y10;
            }
            if (view == null) {
                return;
            }
            if (((z10 && view.getLeft() < i10) || (!z10 && view.getLeft() > i10)) && DrawerLayout.this.q(view) == 0) {
                this.f2578b.R(view, i10, view.getTop());
                ((LayoutParams) view.getLayoutParams()).f2567c = true;
                DrawerLayout.this.invalidate();
                n();
                DrawerLayout.this.b();
            }
        }

        public void p() {
            DrawerLayout.this.removeCallbacks(this.f2579c);
        }

        public void q(a1.c cVar) {
            this.f2578b = cVar;
        }
    }

    static {
        boolean z10 = true;
        int i10 = Build.VERSION.SDK_INT;
        N = i10 >= 19;
        O = i10 >= 21;
        if (i10 < 29) {
            z10 = false;
        }
        P = z10;
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d1.a.drawerLayoutStyle);
    }

    /* JADX INFO: finally extract failed */
    public DrawerLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2539a = new d();
        this.f2542d = -1728053248;
        this.f2544f = new Paint();
        this.f2551m = true;
        this.f2552n = 3;
        this.f2553o = 3;
        this.f2554p = 3;
        this.f2555q = 3;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.K = new a();
        setDescendantFocusability(262144);
        float f10 = getResources().getDisplayMetrics().density;
        this.f2541c = (int) ((64.0f * f10) + 0.5f);
        float f11 = f10 * 400.0f;
        f fVar = new f(3);
        this.f2547i = fVar;
        f fVar2 = new f(5);
        this.f2548j = fVar2;
        a1.c o10 = a1.c.o(this, 1.0f, fVar);
        this.f2545g = o10;
        o10.N(1);
        o10.O(f11);
        fVar.q(o10);
        a1.c o11 = a1.c.o(this, 1.0f, fVar2);
        this.f2546h = o11;
        o11.N(2);
        o11.O(f11);
        fVar2.q(o11);
        setFocusableInTouchMode(true);
        x.B0(this, 1);
        x.r0(this, new c());
        setMotionEventSplittingEnabled(false);
        if (x.z(this)) {
            if (Build.VERSION.SDK_INT >= 21) {
                setOnApplyWindowInsetsListener(new b(this));
                setSystemUiVisibility(1280);
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(L);
                try {
                    this.f2561w = obtainStyledAttributes.getDrawable(0);
                } finally {
                    obtainStyledAttributes.recycle();
                }
            } else {
                this.f2561w = null;
            }
        }
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, d1.c.DrawerLayout, i10, 0);
        try {
            int i11 = d1.c.DrawerLayout_elevation;
            this.f2540b = obtainStyledAttributes2.hasValue(i11) ? obtainStyledAttributes2.getDimension(i11, 0.0f) : getResources().getDimension(d1.b.def_drawer_elevation);
            obtainStyledAttributes2.recycle();
            this.H = new ArrayList<>();
        } catch (Throwable th) {
            obtainStyledAttributes2.recycle();
            throw th;
        }
    }

    private boolean E(float f10, float f11, View view) {
        if (this.I == null) {
            this.I = new Rect();
        }
        view.getHitRect(this.I);
        return this.I.contains((int) f10, (int) f11);
    }

    private void F(Drawable drawable, int i10) {
        if (drawable != null && p0.a.h(drawable)) {
            p0.a.m(drawable, i10);
        }
    }

    private Drawable M() {
        int C2 = x.C(this);
        if (C2 == 0) {
            Drawable drawable = this.D;
            if (drawable != null) {
                F(drawable, C2);
                return this.D;
            }
        } else {
            Drawable drawable2 = this.E;
            if (drawable2 != null) {
                F(drawable2, C2);
                return this.E;
            }
        }
        return this.F;
    }

    private Drawable N() {
        int C2 = x.C(this);
        if (C2 == 0) {
            Drawable drawable = this.E;
            if (drawable != null) {
                F(drawable, C2);
                return this.E;
            }
        } else {
            Drawable drawable2 = this.D;
            if (drawable2 != null) {
                F(drawable2, C2);
                return this.D;
            }
        }
        return this.G;
    }

    private void O() {
        if (!O) {
            this.f2562x = M();
            this.f2563y = N();
        }
    }

    private void S(View view) {
        c.a aVar = c.a.f18129l;
        x.l0(view, aVar.b());
        if (B(view) && q(view) != 2) {
            x.n0(view, aVar, (CharSequence) null, this.K);
        }
    }

    private void T(View view, boolean z10) {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            x.B0(childAt, ((z10 || C(childAt)) && (!z10 || childAt != view)) ? 4 : 1);
        }
    }

    private boolean l(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent u10 = u(motionEvent, view);
            boolean dispatchGenericMotionEvent = view.dispatchGenericMotionEvent(u10);
            u10.recycle();
            return dispatchGenericMotionEvent;
        }
        float scrollX = (float) (getScrollX() - view.getLeft());
        float scrollY = (float) (getScrollY() - view.getTop());
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean dispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return dispatchGenericMotionEvent2;
    }

    private MotionEvent u(MotionEvent motionEvent, View view) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation((float) (getScrollX() - view.getLeft()), (float) (getScrollY() - view.getTop()));
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.J == null) {
                this.J = new Matrix();
            }
            matrix.invert(this.J);
            obtain.transform(this.J);
        }
        return obtain;
    }

    static String v(int i10) {
        return (i10 & 3) == 3 ? "LEFT" : (i10 & 5) == 5 ? "RIGHT" : Integer.toHexString(i10);
    }

    private static boolean w(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    private boolean x() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (((LayoutParams) getChildAt(i10).getLayoutParams()).f2567c) {
                return true;
            }
        }
        return false;
    }

    private boolean y() {
        return o() != null;
    }

    static boolean z(View view) {
        return (x.A(view) == 4 || x.A(view) == 2) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public boolean A(View view) {
        return ((LayoutParams) view.getLayoutParams()).f2565a == 0;
    }

    public boolean B(View view) {
        if (C(view)) {
            return (((LayoutParams) view.getLayoutParams()).f2568d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    /* access modifiers changed from: package-private */
    public boolean C(View view) {
        int b10 = androidx.core.view.f.b(((LayoutParams) view.getLayoutParams()).f2565a, x.C(view));
        return ((b10 & 3) == 0 && (b10 & 5) == 0) ? false : true;
    }

    public boolean D(View view) {
        if (C(view)) {
            return ((LayoutParams) view.getLayoutParams()).f2566b > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    /* access modifiers changed from: package-private */
    public void G(View view, float f10) {
        float t10 = t(view);
        float width = (float) view.getWidth();
        int i10 = ((int) (width * f10)) - ((int) (t10 * width));
        if (!c(view, 3)) {
            i10 = -i10;
        }
        view.offsetLeftAndRight(i10);
        R(view, f10);
    }

    public void H(int i10) {
        I(i10, true);
    }

    public void I(int i10, boolean z10) {
        View m10 = m(i10);
        if (m10 != null) {
            K(m10, z10);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + v(i10));
    }

    public void J(View view) {
        K(view, true);
    }

    public void K(View view, boolean z10) {
        if (C(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.f2551m) {
                layoutParams.f2566b = 1.0f;
                layoutParams.f2568d = 1;
                T(view, true);
                S(view);
            } else if (z10) {
                layoutParams.f2568d |= 2;
                if (c(view, 3)) {
                    this.f2545g.R(view, 0, view.getTop());
                } else {
                    this.f2546h.R(view, getWidth() - view.getWidth(), view.getTop());
                }
            } else {
                G(view, 1.0f);
                U(0, view);
                view.setVisibility(0);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public void L(e eVar) {
        List<e> list;
        if (eVar != null && (list = this.f2558t) != null) {
            list.remove(eVar);
        }
    }

    public void P(Object obj, boolean z10) {
        this.B = obj;
        this.C = z10;
        setWillNotDraw(!z10 && getBackground() == null);
        requestLayout();
    }

    public void Q(int i10, int i11) {
        View m10;
        int b10 = androidx.core.view.f.b(i11, x.C(this));
        if (i11 == 3) {
            this.f2552n = i10;
        } else if (i11 == 5) {
            this.f2553o = i10;
        } else if (i11 == 8388611) {
            this.f2554p = i10;
        } else if (i11 == 8388613) {
            this.f2555q = i10;
        }
        if (i10 != 0) {
            (b10 == 3 ? this.f2545g : this.f2546h).b();
        }
        if (i10 == 1) {
            View m11 = m(b10);
            if (m11 != null) {
                e(m11);
            }
        } else if (i10 == 2 && (m10 = m(b10)) != null) {
            J(m10);
        }
    }

    /* access modifiers changed from: package-private */
    public void R(View view, float f10) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f10 != layoutParams.f2566b) {
            layoutParams.f2566b = f10;
            k(view, f10);
        }
    }

    /* access modifiers changed from: package-private */
    public void U(int i10, View view) {
        int B2 = this.f2545g.B();
        int B3 = this.f2546h.B();
        int i11 = 2;
        if (B2 == 1 || B3 == 1) {
            i11 = 1;
        } else if (!(B2 == 2 || B3 == 2)) {
            i11 = 0;
        }
        if (view != null && i10 == 0) {
            float f10 = ((LayoutParams) view.getLayoutParams()).f2566b;
            if (f10 == 0.0f) {
                i(view);
            } else if (f10 == 1.0f) {
                j(view);
            }
        }
        if (i11 != this.f2549k) {
            this.f2549k = i11;
            List<e> list = this.f2558t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f2558t.get(size).a(i11);
                }
            }
        }
    }

    public void a(e eVar) {
        if (eVar != null) {
            if (this.f2558t == null) {
                this.f2558t = new ArrayList();
            }
            this.f2558t.add(eVar);
        }
    }

    public void addFocusables(ArrayList<View> arrayList, int i10, int i11) {
        if (getDescendantFocusability() != 393216) {
            int childCount = getChildCount();
            boolean z10 = false;
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                if (!C(childAt)) {
                    this.H.add(childAt);
                } else if (B(childAt)) {
                    childAt.addFocusables(arrayList, i10, i11);
                    z10 = true;
                }
            }
            if (!z10) {
                int size = this.H.size();
                for (int i13 = 0; i13 < size; i13++) {
                    View view = this.H.get(i13);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i10, i11);
                    }
                }
            }
            this.H.clear();
        }
    }

    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i10, layoutParams);
        x.B0(view, (n() != null || C(view)) ? 4 : 1);
        if (!N) {
            x.r0(view, this.f2539a);
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (!this.f2556r) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                getChildAt(i10).dispatchTouchEvent(obtain);
            }
            obtain.recycle();
            this.f2556r = true;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean c(View view, int i10) {
        return (s(view) & i10) == i10;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f10 = 0.0f;
        for (int i10 = 0; i10 < childCount; i10++) {
            f10 = Math.max(f10, ((LayoutParams) getChildAt(i10).getLayoutParams()).f2566b);
        }
        this.f2543e = f10;
        boolean n10 = this.f2545g.n(true);
        boolean n11 = this.f2546h.n(true);
        if (n10 || n11) {
            x.h0(this);
        }
    }

    public void d(int i10, boolean z10) {
        View m10 = m(i10);
        if (m10 != null) {
            f(m10, z10);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + v(i10));
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.f2543e <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        for (int i10 = childCount - 1; i10 >= 0; i10--) {
            View childAt = getChildAt(i10);
            if (E(x10, y10, childAt) && !A(childAt) && l(motionEvent, childAt)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j10) {
        Drawable drawable;
        Canvas canvas2 = canvas;
        View view2 = view;
        int height = getHeight();
        boolean A2 = A(view2);
        int width = getWidth();
        int save = canvas.save();
        int i10 = 0;
        if (A2) {
            int childCount = getChildCount();
            int i11 = 0;
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                if (childAt != view2 && childAt.getVisibility() == 0 && w(childAt) && C(childAt) && childAt.getHeight() >= height) {
                    if (c(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i11) {
                            i11 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i11, 0, width, getHeight());
            i10 = i11;
        }
        boolean drawChild = super.drawChild(canvas, view, j10);
        canvas.restoreToCount(save);
        float f10 = this.f2543e;
        if (f10 <= 0.0f || !A2) {
            if (this.f2562x != null && c(view2, 3)) {
                int intrinsicWidth = this.f2562x.getIntrinsicWidth();
                int right2 = view.getRight();
                float max = Math.max(0.0f, Math.min(((float) right2) / ((float) this.f2545g.y()), 1.0f));
                this.f2562x.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
                this.f2562x.setAlpha((int) (max * 255.0f));
                drawable = this.f2562x;
            } else if (this.f2563y != null && c(view2, 5)) {
                int intrinsicWidth2 = this.f2563y.getIntrinsicWidth();
                int left2 = view.getLeft();
                float max2 = Math.max(0.0f, Math.min(((float) (getWidth() - left2)) / ((float) this.f2546h.y()), 1.0f));
                this.f2563y.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
                this.f2563y.setAlpha((int) (max2 * 255.0f));
                drawable = this.f2563y;
            }
            drawable.draw(canvas);
        } else {
            int i13 = this.f2542d;
            this.f2544f.setColor((i13 & 16777215) | (((int) (((float) ((-16777216 & i13) >>> 24)) * f10)) << 24));
            canvas.drawRect((float) i10, 0.0f, (float) width, (float) getHeight(), this.f2544f);
        }
        return drawChild;
    }

    public void e(View view) {
        f(view, true);
    }

    public void f(View view, boolean z10) {
        a1.c cVar;
        int i10;
        if (C(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.f2551m) {
                layoutParams.f2566b = 0.0f;
                layoutParams.f2568d = 0;
            } else if (z10) {
                layoutParams.f2568d |= 4;
                if (c(view, 3)) {
                    cVar = this.f2545g;
                    i10 = -view.getWidth();
                } else {
                    cVar = this.f2546h;
                    i10 = getWidth();
                }
                cVar.R(view, i10, view.getTop());
            } else {
                G(view, 0.0f);
                U(0, view);
                view.setVisibility(4);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public void g() {
        h(false);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public float getDrawerElevation() {
        if (O) {
            return this.f2540b;
        }
        return 0.0f;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.f2561w;
    }

    /* access modifiers changed from: package-private */
    public void h(boolean z10) {
        int childCount = getChildCount();
        boolean z11 = false;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (C(childAt) && (!z10 || layoutParams.f2567c)) {
                z11 |= c(childAt, 3) ? this.f2545g.R(childAt, -childAt.getWidth(), childAt.getTop()) : this.f2546h.R(childAt, getWidth(), childAt.getTop());
                layoutParams.f2567c = false;
            }
        }
        this.f2547i.p();
        this.f2548j.p();
        if (z11) {
            invalidate();
        }
    }

    /* access modifiers changed from: package-private */
    public void i(View view) {
        View rootView;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.f2568d & 1) == 1) {
            layoutParams.f2568d = 0;
            List<e> list = this.f2558t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f2558t.get(size).d(view);
                }
            }
            T(view, false);
            S(view);
            if (hasWindowFocus() && (rootView = getRootView()) != null) {
                rootView.sendAccessibilityEvent(32);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void j(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.f2568d & 1) == 0) {
            layoutParams.f2568d = 1;
            List<e> list = this.f2558t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f2558t.get(size).c(view);
                }
            }
            T(view, true);
            S(view);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void k(View view, float f10) {
        List<e> list = this.f2558t;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f2558t.get(size).b(view, f10);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public View m(int i10) {
        int b10 = androidx.core.view.f.b(i10, x.C(this)) & 7;
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if ((s(childAt) & 7) == b10) {
                return childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public View n() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if ((((LayoutParams) childAt.getLayoutParams()).f2568d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public View o() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (C(childAt) && D(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2551m = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2551m = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        r0 = r4.B;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r5) {
        /*
            r4 = this;
            super.onDraw(r5)
            boolean r0 = r4.C
            if (r0 == 0) goto L_0x002e
            android.graphics.drawable.Drawable r0 = r4.f2561w
            if (r0 == 0) goto L_0x002e
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            r2 = 0
            if (r0 < r1) goto L_0x001d
            java.lang.Object r0 = r4.B
            if (r0 == 0) goto L_0x001d
            android.view.WindowInsets r0 = (android.view.WindowInsets) r0
            int r0 = r0.getSystemWindowInsetTop()
            goto L_0x001e
        L_0x001d:
            r0 = r2
        L_0x001e:
            if (r0 <= 0) goto L_0x002e
            android.graphics.drawable.Drawable r1 = r4.f2561w
            int r3 = r4.getWidth()
            r1.setBounds(r2, r2, r3, r0)
            android.graphics.drawable.Drawable r0 = r4.f2561w
            r0.draw(r5)
        L_0x002e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onDraw(android.graphics.Canvas):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004b, code lost:
        r7 = r6.f2545g.u((int) r0, (int) r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if (r0 != 3) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getActionMasked()
            a1.c r1 = r6.f2545g
            boolean r1 = r1.Q(r7)
            a1.c r2 = r6.f2546h
            boolean r2 = r2.Q(r7)
            r1 = r1 | r2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0038
            if (r0 == r2) goto L_0x0031
            r7 = 2
            r4 = 3
            if (r0 == r7) goto L_0x001e
            if (r0 == r4) goto L_0x0031
            goto L_0x0036
        L_0x001e:
            a1.c r7 = r6.f2545g
            boolean r7 = r7.e(r4)
            if (r7 == 0) goto L_0x0036
            androidx.drawerlayout.widget.DrawerLayout$f r7 = r6.f2547i
            r7.p()
            androidx.drawerlayout.widget.DrawerLayout$f r7 = r6.f2548j
            r7.p()
            goto L_0x0036
        L_0x0031:
            r6.h(r2)
            r6.f2556r = r3
        L_0x0036:
            r7 = r3
            goto L_0x0060
        L_0x0038:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.f2559u = r0
            r6.f2560v = r7
            float r4 = r6.f2543e
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x005d
            a1.c r4 = r6.f2545g
            int r0 = (int) r0
            int r7 = (int) r7
            android.view.View r7 = r4.u(r0, r7)
            if (r7 == 0) goto L_0x005d
            boolean r7 = r6.A(r7)
            if (r7 == 0) goto L_0x005d
            r7 = r2
            goto L_0x005e
        L_0x005d:
            r7 = r3
        L_0x005e:
            r6.f2556r = r3
        L_0x0060:
            if (r1 != 0) goto L_0x0070
            if (r7 != 0) goto L_0x0070
            boolean r7 = r6.x()
            if (r7 != 0) goto L_0x0070
            boolean r7 = r6.f2556r
            if (r7 == 0) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r2 = r3
        L_0x0070:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 != 4 || !y()) {
            return super.onKeyDown(i10, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        if (i10 != 4) {
            return super.onKeyUp(i10, keyEvent);
        }
        View o10 = o();
        if (o10 != null && q(o10) == 0) {
            g();
        }
        return o10 != null;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        WindowInsets rootWindowInsets;
        float f10;
        int i14;
        int measuredHeight;
        int i15;
        int i16;
        boolean z11 = true;
        this.f2550l = true;
        int i17 = i12 - i10;
        int childCount = getChildCount();
        int i18 = 0;
        while (i18 < childCount) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (A(childAt)) {
                    int i19 = layoutParams.leftMargin;
                    childAt.layout(i19, layoutParams.topMargin, childAt.getMeasuredWidth() + i19, layoutParams.topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight2 = childAt.getMeasuredHeight();
                    if (c(childAt, 3)) {
                        float f11 = (float) measuredWidth;
                        i14 = (-measuredWidth) + ((int) (layoutParams.f2566b * f11));
                        f10 = ((float) (measuredWidth + i14)) / f11;
                    } else {
                        float f12 = (float) measuredWidth;
                        int i20 = i17 - ((int) (layoutParams.f2566b * f12));
                        f10 = ((float) (i17 - i20)) / f12;
                        i14 = i20;
                    }
                    boolean z12 = f10 != layoutParams.f2566b ? z11 : false;
                    int i21 = layoutParams.f2565a & 112;
                    if (i21 != 16) {
                        if (i21 != 80) {
                            measuredHeight = layoutParams.topMargin;
                            i15 = measuredWidth + i14;
                            i16 = measuredHeight2 + measuredHeight;
                        } else {
                            int i22 = i13 - i11;
                            measuredHeight = (i22 - layoutParams.bottomMargin) - childAt.getMeasuredHeight();
                            i15 = measuredWidth + i14;
                            i16 = i22 - layoutParams.bottomMargin;
                        }
                        childAt.layout(i14, measuredHeight, i15, i16);
                    } else {
                        int i23 = i13 - i11;
                        int i24 = (i23 - measuredHeight2) / 2;
                        int i25 = layoutParams.topMargin;
                        if (i24 < i25) {
                            i24 = i25;
                        } else {
                            int i26 = i24 + measuredHeight2;
                            int i27 = layoutParams.bottomMargin;
                            if (i26 > i23 - i27) {
                                i24 = (i23 - i27) - measuredHeight2;
                            }
                        }
                        childAt.layout(i14, i24, measuredWidth + i14, measuredHeight2 + i24);
                    }
                    if (z12) {
                        R(childAt, f10);
                    }
                    int i28 = layoutParams.f2566b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i28) {
                        childAt.setVisibility(i28);
                    }
                }
            }
            i18++;
            z11 = true;
        }
        if (P && (rootWindowInsets = getRootWindowInsets()) != null) {
            o0.b i29 = f0.x(rootWindowInsets).i();
            a1.c cVar = this.f2545g;
            cVar.M(Math.max(cVar.x(), i29.f16299a));
            a1.c cVar2 = this.f2546h;
            cVar2.M(Math.max(cVar2.x(), i29.f16301c));
        }
        this.f2550l = false;
        this.f2551m = false;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"WrongConstant"})
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        if (!(mode == 1073741824 && mode2 == 1073741824)) {
            if (isInEditMode()) {
                if (mode == 0) {
                    size = 300;
                }
                if (mode2 == 0) {
                    size2 = 300;
                }
            } else {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
        }
        setMeasuredDimension(size, size2);
        int i12 = 0;
        boolean z10 = this.B != null && x.z(this);
        int C2 = x.C(this);
        int childCount = getChildCount();
        int i13 = 0;
        boolean z11 = false;
        boolean z12 = false;
        while (i13 < childCount) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (z10) {
                    int b10 = androidx.core.view.f.b(layoutParams.f2565a, C2);
                    boolean z13 = x.z(childAt);
                    int i14 = Build.VERSION.SDK_INT;
                    if (z13) {
                        if (i14 >= 21) {
                            WindowInsets windowInsets = (WindowInsets) this.B;
                            if (b10 == 3) {
                                windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), i12, windowInsets.getSystemWindowInsetBottom());
                            } else if (b10 == 5) {
                                windowInsets = windowInsets.replaceSystemWindowInsets(i12, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                            }
                            childAt.dispatchApplyWindowInsets(windowInsets);
                        }
                    } else if (i14 >= 21) {
                        WindowInsets windowInsets2 = (WindowInsets) this.B;
                        if (b10 == 3) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(windowInsets2.getSystemWindowInsetLeft(), windowInsets2.getSystemWindowInsetTop(), i12, windowInsets2.getSystemWindowInsetBottom());
                        } else if (b10 == 5) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(i12, windowInsets2.getSystemWindowInsetTop(), windowInsets2.getSystemWindowInsetRight(), windowInsets2.getSystemWindowInsetBottom());
                        }
                        layoutParams.leftMargin = windowInsets2.getSystemWindowInsetLeft();
                        layoutParams.topMargin = windowInsets2.getSystemWindowInsetTop();
                        layoutParams.rightMargin = windowInsets2.getSystemWindowInsetRight();
                        layoutParams.bottomMargin = windowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (A(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - layoutParams.leftMargin) - layoutParams.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - layoutParams.topMargin) - layoutParams.bottomMargin, 1073741824));
                } else if (C(childAt)) {
                    if (O) {
                        float w10 = x.w(childAt);
                        float f10 = this.f2540b;
                        if (w10 != f10) {
                            x.y0(childAt, f10);
                        }
                    }
                    int s10 = s(childAt) & 7;
                    int i15 = s10 == 3 ? 1 : i12;
                    if ((i15 == 0 || !z11) && (i15 != 0 || !z12)) {
                        if (i15 != 0) {
                            z11 = true;
                        } else {
                            z12 = true;
                        }
                        childAt.measure(ViewGroup.getChildMeasureSpec(i10, this.f2541c + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), ViewGroup.getChildMeasureSpec(i11, layoutParams.topMargin + layoutParams.bottomMargin, layoutParams.height));
                        i13++;
                        i12 = 0;
                    } else {
                        throw new IllegalStateException("Child drawer has absolute gravity " + v(s10) + " but this " + "DrawerLayout" + " already has a drawer view along that edge");
                    }
                } else {
                    throw new IllegalStateException("Child " + childAt + " at index " + i13 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                }
            }
            int i16 = i10;
            int i17 = i11;
            i13++;
            i12 = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        View m10;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        int i10 = savedState.f2569c;
        if (!(i10 == 0 || (m10 = m(i10)) == null)) {
            J(m10);
        }
        int i11 = savedState.f2570d;
        if (i11 != 3) {
            Q(i11, 3);
        }
        int i12 = savedState.f2571e;
        if (i12 != 3) {
            Q(i12, 5);
        }
        int i13 = savedState.f2572f;
        if (i13 != 3) {
            Q(i13, 8388611);
        }
        int i14 = savedState.f2573g;
        if (i14 != 3) {
            Q(i14, 8388613);
        }
    }

    public void onRtlPropertiesChanged(int i10) {
        O();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        int i10 = 0;
        while (true) {
            if (i10 >= childCount) {
                break;
            }
            LayoutParams layoutParams = (LayoutParams) getChildAt(i10).getLayoutParams();
            int i11 = layoutParams.f2568d;
            boolean z10 = true;
            boolean z11 = i11 == 1;
            if (i11 != 2) {
                z10 = false;
            }
            if (z11 || z10) {
                savedState.f2569c = layoutParams.f2565a;
            } else {
                i10++;
            }
        }
        savedState.f2570d = this.f2552n;
        savedState.f2571e = this.f2553o;
        savedState.f2572f = this.f2554p;
        savedState.f2573g = this.f2555q;
        return savedState;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0056, code lost:
        if (q(r7) != 2) goto L_0x0059;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            a1.c r0 = r6.f2545g
            r0.G(r7)
            a1.c r0 = r6.f2546h
            r0.G(r7)
            int r0 = r7.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x005d
            if (r0 == r2) goto L_0x001e
            r7 = 3
            if (r0 == r7) goto L_0x001a
            goto L_0x006b
        L_0x001a:
            r6.h(r2)
            goto L_0x0069
        L_0x001e:
            float r0 = r7.getX()
            float r7 = r7.getY()
            a1.c r3 = r6.f2545g
            int r4 = (int) r0
            int r5 = (int) r7
            android.view.View r3 = r3.u(r4, r5)
            if (r3 == 0) goto L_0x0058
            boolean r3 = r6.A(r3)
            if (r3 == 0) goto L_0x0058
            float r3 = r6.f2559u
            float r0 = r0 - r3
            float r3 = r6.f2560v
            float r7 = r7 - r3
            a1.c r3 = r6.f2545g
            int r3 = r3.A()
            float r0 = r0 * r0
            float r7 = r7 * r7
            float r0 = r0 + r7
            int r3 = r3 * r3
            float r7 = (float) r3
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 >= 0) goto L_0x0058
            android.view.View r7 = r6.n()
            if (r7 == 0) goto L_0x0058
            int r7 = r6.q(r7)
            r0 = 2
            if (r7 != r0) goto L_0x0059
        L_0x0058:
            r1 = r2
        L_0x0059:
            r6.h(r1)
            goto L_0x006b
        L_0x005d:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.f2559u = r0
            r6.f2560v = r7
        L_0x0069:
            r6.f2556r = r1
        L_0x006b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public int p(int i10) {
        int C2 = x.C(this);
        if (i10 == 3) {
            int i11 = this.f2552n;
            if (i11 != 3) {
                return i11;
            }
            int i12 = C2 == 0 ? this.f2554p : this.f2555q;
            if (i12 != 3) {
                return i12;
            }
            return 0;
        } else if (i10 == 5) {
            int i13 = this.f2553o;
            if (i13 != 3) {
                return i13;
            }
            int i14 = C2 == 0 ? this.f2555q : this.f2554p;
            if (i14 != 3) {
                return i14;
            }
            return 0;
        } else if (i10 == 8388611) {
            int i15 = this.f2554p;
            if (i15 != 3) {
                return i15;
            }
            int i16 = C2 == 0 ? this.f2552n : this.f2553o;
            if (i16 != 3) {
                return i16;
            }
            return 0;
        } else if (i10 != 8388613) {
            return 0;
        } else {
            int i17 = this.f2555q;
            if (i17 != 3) {
                return i17;
            }
            int i18 = C2 == 0 ? this.f2553o : this.f2552n;
            if (i18 != 3) {
                return i18;
            }
            return 0;
        }
    }

    public int q(View view) {
        if (C(view)) {
            return p(((LayoutParams) view.getLayoutParams()).f2565a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public CharSequence r(int i10) {
        int b10 = androidx.core.view.f.b(i10, x.C(this));
        if (b10 == 3) {
            return this.f2564z;
        }
        if (b10 == 5) {
            return this.A;
        }
        return null;
    }

    public void requestDisallowInterceptTouchEvent(boolean z10) {
        super.requestDisallowInterceptTouchEvent(z10);
        if (z10) {
            h(true);
        }
    }

    public void requestLayout() {
        if (!this.f2550l) {
            super.requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public int s(View view) {
        return androidx.core.view.f.b(((LayoutParams) view.getLayoutParams()).f2565a, x.C(this));
    }

    public void setDrawerElevation(float f10) {
        this.f2540b = f10;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (C(childAt)) {
                x.y0(childAt, this.f2540b);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(e eVar) {
        e eVar2 = this.f2557s;
        if (eVar2 != null) {
            L(eVar2);
        }
        if (eVar != null) {
            a(eVar);
        }
        this.f2557s = eVar;
    }

    public void setDrawerLockMode(int i10) {
        Q(i10, 3);
        Q(i10, 5);
    }

    public void setScrimColor(int i10) {
        this.f2542d = i10;
        invalidate();
    }

    public void setStatusBarBackground(int i10) {
        this.f2561w = i10 != 0 ? androidx.core.content.a.f(getContext(), i10) : null;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.f2561w = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i10) {
        this.f2561w = new ColorDrawable(i10);
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public float t(View view) {
        return ((LayoutParams) view.getLayoutParams()).f2566b;
    }
}
