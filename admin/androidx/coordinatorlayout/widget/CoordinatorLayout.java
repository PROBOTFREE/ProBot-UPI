package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.core.view.f0;
import androidx.core.view.n;
import androidx.core.view.o;
import androidx.core.view.q;
import androidx.core.view.r;
import androidx.core.view.x;
import androidx.customview.view.AbsSavedState;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements n, o {

    /* renamed from: u  reason: collision with root package name */
    static final String f2118u;

    /* renamed from: v  reason: collision with root package name */
    static final Class<?>[] f2119v = {Context.class, AttributeSet.class};

    /* renamed from: w  reason: collision with root package name */
    static final ThreadLocal<Map<String, Constructor<Behavior>>> f2120w = new ThreadLocal<>();

    /* renamed from: x  reason: collision with root package name */
    static final Comparator<View> f2121x;

    /* renamed from: y  reason: collision with root package name */
    private static final w0.e<Rect> f2122y = new w0.g(12);

    /* renamed from: a  reason: collision with root package name */
    private final List<View> f2123a;

    /* renamed from: b  reason: collision with root package name */
    private final a<View> f2124b;

    /* renamed from: c  reason: collision with root package name */
    private final List<View> f2125c;

    /* renamed from: d  reason: collision with root package name */
    private final List<View> f2126d;

    /* renamed from: e  reason: collision with root package name */
    private Paint f2127e;

    /* renamed from: f  reason: collision with root package name */
    private final int[] f2128f;

    /* renamed from: g  reason: collision with root package name */
    private final int[] f2129g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f2130h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f2131i;

    /* renamed from: j  reason: collision with root package name */
    private int[] f2132j;

    /* renamed from: k  reason: collision with root package name */
    private View f2133k;

    /* renamed from: l  reason: collision with root package name */
    private View f2134l;

    /* renamed from: m  reason: collision with root package name */
    private f f2135m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f2136n;

    /* renamed from: o  reason: collision with root package name */
    private f0 f2137o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f2138p;

    /* renamed from: q  reason: collision with root package name */
    private Drawable f2139q;

    /* renamed from: r  reason: collision with root package name */
    ViewGroup.OnHierarchyChangeListener f2140r;

    /* renamed from: s  reason: collision with root package name */
    private r f2141s;

    /* renamed from: t  reason: collision with root package name */
    private final q f2142t;

    public static abstract class Behavior<V extends View> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
        }

        public boolean A(CoordinatorLayout coordinatorLayout, V v10, View view, View view2, int i10, int i11) {
            if (i11 == 0) {
                return z(coordinatorLayout, v10, view, view2, i10);
            }
            return false;
        }

        @Deprecated
        public void B(CoordinatorLayout coordinatorLayout, V v10, View view) {
        }

        public void C(CoordinatorLayout coordinatorLayout, V v10, View view, int i10) {
            if (i10 == 0) {
                B(coordinatorLayout, v10, view);
            }
        }

        public boolean D(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v10) {
            return d(coordinatorLayout, v10) > 0.0f;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v10, Rect rect) {
            return false;
        }

        public int c(CoordinatorLayout coordinatorLayout, V v10) {
            return -16777216;
        }

        public float d(CoordinatorLayout coordinatorLayout, V v10) {
            return 0.0f;
        }

        public boolean e(CoordinatorLayout coordinatorLayout, V v10, View view) {
            return false;
        }

        public f0 f(CoordinatorLayout coordinatorLayout, V v10, f0 f0Var) {
            return f0Var;
        }

        public void g(e eVar) {
        }

        public boolean h(CoordinatorLayout coordinatorLayout, V v10, View view) {
            return false;
        }

        public void i(CoordinatorLayout coordinatorLayout, V v10, View view) {
        }

        public void j() {
        }

        public boolean k(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
            return false;
        }

        public boolean l(CoordinatorLayout coordinatorLayout, V v10, int i10) {
            return false;
        }

        public boolean m(CoordinatorLayout coordinatorLayout, V v10, int i10, int i11, int i12, int i13) {
            return false;
        }

        public boolean n(CoordinatorLayout coordinatorLayout, V v10, View view, float f10, float f11, boolean z10) {
            return false;
        }

        public boolean o(CoordinatorLayout coordinatorLayout, V v10, View view, float f10, float f11) {
            return false;
        }

        @Deprecated
        public void p(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int[] iArr) {
        }

        public void q(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int[] iArr, int i12) {
            if (i12 == 0) {
                p(coordinatorLayout, v10, view, i10, i11, iArr);
            }
        }

        @Deprecated
        public void r(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int i12, int i13) {
        }

        @Deprecated
        public void s(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int i12, int i13, int i14) {
            if (i14 == 0) {
                r(coordinatorLayout, v10, view, i10, i11, i12, i13);
            }
        }

        public void t(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
            iArr[0] = iArr[0] + i12;
            iArr[1] = iArr[1] + i13;
            s(coordinatorLayout, v10, view, i10, i11, i12, i13, i14);
        }

        @Deprecated
        public void u(CoordinatorLayout coordinatorLayout, V v10, View view, View view2, int i10) {
        }

        public void v(CoordinatorLayout coordinatorLayout, V v10, View view, View view2, int i10, int i11) {
            if (i11 == 0) {
                u(coordinatorLayout, v10, view, view2, i10);
            }
        }

        public boolean w(CoordinatorLayout coordinatorLayout, V v10, Rect rect, boolean z10) {
            return false;
        }

        public void x(CoordinatorLayout coordinatorLayout, V v10, Parcelable parcelable) {
        }

        public Parcelable y(CoordinatorLayout coordinatorLayout, V v10) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public boolean z(CoordinatorLayout coordinatorLayout, V v10, View view, View view2, int i10) {
            return false;
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        SparseArray<Parcelable> f2143c;

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

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.f2143c = new SparseArray<>(readInt);
            for (int i10 = 0; i10 < readInt; i10++) {
                this.f2143c.append(iArr[i10], readParcelableArray[i10]);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            SparseArray<Parcelable> sparseArray = this.f2143c;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i11 = 0; i11 < size; i11++) {
                iArr[i11] = this.f2143c.keyAt(i11);
                parcelableArr[i11] = this.f2143c.valueAt(i11);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i10);
        }
    }

    class a implements r {
        a() {
        }

        public f0 a(View view, f0 f0Var) {
            return CoordinatorLayout.this.a0(f0Var);
        }
    }

    public interface b {
        Behavior getBehavior();
    }

    @Deprecated
    @Retention(RetentionPolicy.RUNTIME)
    public @interface c {
        Class<? extends Behavior> value();
    }

    private class d implements ViewGroup.OnHierarchyChangeListener {
        d() {
        }

        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f2140r;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.L(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f2140r;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public static class e extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        Behavior f2146a;

        /* renamed from: b  reason: collision with root package name */
        boolean f2147b = false;

        /* renamed from: c  reason: collision with root package name */
        public int f2148c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f2149d = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f2150e = -1;

        /* renamed from: f  reason: collision with root package name */
        int f2151f = -1;

        /* renamed from: g  reason: collision with root package name */
        public int f2152g = 0;

        /* renamed from: h  reason: collision with root package name */
        public int f2153h = 0;

        /* renamed from: i  reason: collision with root package name */
        int f2154i;

        /* renamed from: j  reason: collision with root package name */
        int f2155j;

        /* renamed from: k  reason: collision with root package name */
        View f2156k;

        /* renamed from: l  reason: collision with root package name */
        View f2157l;

        /* renamed from: m  reason: collision with root package name */
        private boolean f2158m;

        /* renamed from: n  reason: collision with root package name */
        private boolean f2159n;

        /* renamed from: o  reason: collision with root package name */
        private boolean f2160o;

        /* renamed from: p  reason: collision with root package name */
        private boolean f2161p;

        /* renamed from: q  reason: collision with root package name */
        final Rect f2162q = new Rect();

        public e(int i10, int i11) {
            super(i10, i11);
        }

        e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l0.c.CoordinatorLayout_Layout);
            this.f2148c = obtainStyledAttributes.getInteger(l0.c.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f2151f = obtainStyledAttributes.getResourceId(l0.c.CoordinatorLayout_Layout_layout_anchor, -1);
            this.f2149d = obtainStyledAttributes.getInteger(l0.c.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.f2150e = obtainStyledAttributes.getInteger(l0.c.CoordinatorLayout_Layout_layout_keyline, -1);
            this.f2152g = obtainStyledAttributes.getInt(l0.c.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.f2153h = obtainStyledAttributes.getInt(l0.c.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            int i10 = l0.c.CoordinatorLayout_Layout_layout_behavior;
            boolean hasValue = obtainStyledAttributes.hasValue(i10);
            this.f2147b = hasValue;
            if (hasValue) {
                this.f2146a = CoordinatorLayout.O(context, attributeSet, obtainStyledAttributes.getString(i10));
            }
            obtainStyledAttributes.recycle();
            Behavior behavior = this.f2146a;
            if (behavior != null) {
                behavior.g(this);
            }
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public e(e eVar) {
            super(eVar);
        }

        private void n(View view, CoordinatorLayout coordinatorLayout) {
            View findViewById = coordinatorLayout.findViewById(this.f2151f);
            this.f2156k = findViewById;
            if (findViewById != null) {
                if (findViewById != coordinatorLayout) {
                    ViewParent parent = findViewById.getParent();
                    while (parent != coordinatorLayout && parent != null) {
                        if (parent != view) {
                            if (parent instanceof View) {
                                findViewById = (View) parent;
                            }
                            parent = parent.getParent();
                        } else if (!coordinatorLayout.isInEditMode()) {
                            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                        }
                    }
                    this.f2157l = findViewById;
                    return;
                } else if (!coordinatorLayout.isInEditMode()) {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
            } else if (!coordinatorLayout.isInEditMode()) {
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f2151f) + " to anchor view " + view);
            }
            this.f2157l = null;
            this.f2156k = null;
        }

        private boolean s(View view, int i10) {
            int b10 = androidx.core.view.f.b(((e) view.getLayoutParams()).f2152g, i10);
            return b10 != 0 && (androidx.core.view.f.b(this.f2153h, i10) & b10) == b10;
        }

        private boolean t(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f2156k.getId() != this.f2151f) {
                return false;
            }
            View view2 = this.f2156k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.f2157l = null;
                    this.f2156k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = (View) parent;
                }
            }
            this.f2157l = view2;
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.f2156k == null && this.f2151f != -1;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
            r0 = r1.f2146a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean b(androidx.coordinatorlayout.widget.CoordinatorLayout r2, android.view.View r3, android.view.View r4) {
            /*
                r1 = this;
                android.view.View r0 = r1.f2157l
                if (r4 == r0) goto L_0x001b
                int r0 = androidx.core.view.x.C(r2)
                boolean r0 = r1.s(r4, r0)
                if (r0 != 0) goto L_0x001b
                androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r0 = r1.f2146a
                if (r0 == 0) goto L_0x0019
                boolean r2 = r0.e(r2, r3, r4)
                if (r2 == 0) goto L_0x0019
                goto L_0x001b
            L_0x0019:
                r2 = 0
                goto L_0x001c
            L_0x001b:
                r2 = 1
            L_0x001c:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.e.b(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View):boolean");
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            if (this.f2146a == null) {
                this.f2158m = false;
            }
            return this.f2158m;
        }

        /* access modifiers changed from: package-private */
        public View d(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f2151f == -1) {
                this.f2157l = null;
                this.f2156k = null;
                return null;
            }
            if (this.f2156k == null || !t(view, coordinatorLayout)) {
                n(view, coordinatorLayout);
            }
            return this.f2156k;
        }

        public int e() {
            return this.f2151f;
        }

        public Behavior f() {
            return this.f2146a;
        }

        /* access modifiers changed from: package-private */
        public boolean g() {
            return this.f2161p;
        }

        /* access modifiers changed from: package-private */
        public Rect h() {
            return this.f2162q;
        }

        /* access modifiers changed from: package-private */
        public boolean i(CoordinatorLayout coordinatorLayout, View view) {
            boolean z10 = this.f2158m;
            if (z10) {
                return true;
            }
            Behavior behavior = this.f2146a;
            boolean a10 = (behavior != null ? behavior.a(coordinatorLayout, view) : false) | z10;
            this.f2158m = a10;
            return a10;
        }

        /* access modifiers changed from: package-private */
        public boolean j(int i10) {
            if (i10 == 0) {
                return this.f2159n;
            }
            if (i10 != 1) {
                return false;
            }
            return this.f2160o;
        }

        /* access modifiers changed from: package-private */
        public void k() {
            this.f2161p = false;
        }

        /* access modifiers changed from: package-private */
        public void l(int i10) {
            r(i10, false);
        }

        /* access modifiers changed from: package-private */
        public void m() {
            this.f2158m = false;
        }

        public void o(Behavior behavior) {
            Behavior behavior2 = this.f2146a;
            if (behavior2 != behavior) {
                if (behavior2 != null) {
                    behavior2.j();
                }
                this.f2146a = behavior;
                this.f2147b = true;
                if (behavior != null) {
                    behavior.g(this);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void p(boolean z10) {
            this.f2161p = z10;
        }

        /* access modifiers changed from: package-private */
        public void q(Rect rect) {
            this.f2162q.set(rect);
        }

        /* access modifiers changed from: package-private */
        public void r(int i10, boolean z10) {
            if (i10 == 0) {
                this.f2159n = z10;
            } else if (i10 == 1) {
                this.f2160o = z10;
            }
        }
    }

    class f implements ViewTreeObserver.OnPreDrawListener {
        f() {
        }

        public boolean onPreDraw() {
            CoordinatorLayout.this.L(0);
            return true;
        }
    }

    static class g implements Comparator<View> {
        g() {
        }

        /* renamed from: a */
        public int compare(View view, View view2) {
            float P = x.P(view);
            float P2 = x.P(view2);
            if (P > P2) {
                return -1;
            }
            return P < P2 ? 1 : 0;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.Class<androidx.coordinatorlayout.widget.CoordinatorLayout> r0 = androidx.coordinatorlayout.widget.CoordinatorLayout.class
            java.lang.Package r0 = r0.getPackage()
            r1 = 0
            if (r0 == 0) goto L_0x000e
            java.lang.String r0 = r0.getName()
            goto L_0x000f
        L_0x000e:
            r0 = r1
        L_0x000f:
            f2118u = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 21
            if (r0 < r2) goto L_0x001f
            androidx.coordinatorlayout.widget.CoordinatorLayout$g r0 = new androidx.coordinatorlayout.widget.CoordinatorLayout$g
            r0.<init>()
            f2121x = r0
            goto L_0x0021
        L_0x001f:
            f2121x = r1
        L_0x0021:
            r0 = 2
            java.lang.Class[] r0 = new java.lang.Class[r0]
            r1 = 0
            java.lang.Class<android.content.Context> r2 = android.content.Context.class
            r0[r1] = r2
            r1 = 1
            java.lang.Class<android.util.AttributeSet> r2 = android.util.AttributeSet.class
            r0[r1] = r2
            f2119v = r0
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            f2120w = r0
            w0.g r0 = new w0.g
            r1 = 12
            r0.<init>(r1)
            f2122y = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.<clinit>():void");
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, l0.a.coordinatorLayoutStyle);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2123a = new ArrayList();
        this.f2124b = new a<>();
        this.f2125c = new ArrayList();
        this.f2126d = new ArrayList();
        this.f2128f = new int[2];
        this.f2129g = new int[2];
        this.f2142t = new q(this);
        int[] iArr = l0.c.CoordinatorLayout;
        TypedArray obtainStyledAttributes = i10 == 0 ? context.obtainStyledAttributes(attributeSet, iArr, 0, l0.b.Widget_Support_CoordinatorLayout) : context.obtainStyledAttributes(attributeSet, iArr, i10, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            int[] iArr2 = l0.c.CoordinatorLayout;
            if (i10 == 0) {
                saveAttributeDataForStyleable(context, iArr2, attributeSet, obtainStyledAttributes, 0, l0.b.Widget_Support_CoordinatorLayout);
            } else {
                saveAttributeDataForStyleable(context, iArr2, attributeSet, obtainStyledAttributes, i10, 0);
            }
        }
        int resourceId = obtainStyledAttributes.getResourceId(l0.c.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.f2132j = resources.getIntArray(resourceId);
            float f10 = resources.getDisplayMetrics().density;
            int length = this.f2132j.length;
            for (int i11 = 0; i11 < length; i11++) {
                int[] iArr3 = this.f2132j;
                iArr3[i11] = (int) (((float) iArr3[i11]) * f10);
            }
        }
        this.f2139q = obtainStyledAttributes.getDrawable(l0.c.CoordinatorLayout_statusBarBackground);
        obtainStyledAttributes.recycle();
        b0();
        super.setOnHierarchyChangeListener(new d());
        if (x.A(this) == 0) {
            x.B0(this, 1);
        }
    }

    private int A(int i10) {
        StringBuilder sb2;
        int[] iArr = this.f2132j;
        if (iArr == null) {
            sb2 = new StringBuilder();
            sb2.append("No keylines defined for ");
            sb2.append(this);
            sb2.append(" - attempted index lookup ");
            sb2.append(i10);
        } else if (i10 >= 0 && i10 < iArr.length) {
            return iArr[i10];
        } else {
            sb2 = new StringBuilder();
            sb2.append("Keyline index ");
            sb2.append(i10);
            sb2.append(" out of range for ");
            sb2.append(this);
        }
        Log.e("CoordinatorLayout", sb2.toString());
        return 0;
    }

    private void D(List<View> list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i10 = childCount - 1; i10 >= 0; i10--) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i10) : i10));
        }
        Comparator<View> comparator = f2121x;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    private boolean E(View view) {
        return this.f2124b.j(view);
    }

    private void G(View view, int i10) {
        e eVar = (e) view.getLayoutParams();
        Rect f10 = f();
        f10.set(getPaddingLeft() + eVar.leftMargin, getPaddingTop() + eVar.topMargin, (getWidth() - getPaddingRight()) - eVar.rightMargin, (getHeight() - getPaddingBottom()) - eVar.bottomMargin);
        if (this.f2137o != null && x.z(this) && !x.z(view)) {
            f10.left += this.f2137o.k();
            f10.top += this.f2137o.m();
            f10.right -= this.f2137o.l();
            f10.bottom -= this.f2137o.j();
        }
        Rect f11 = f();
        androidx.core.view.f.a(W(eVar.f2148c), view.getMeasuredWidth(), view.getMeasuredHeight(), f10, f11, i10);
        view.layout(f11.left, f11.top, f11.right, f11.bottom);
        S(f10);
        S(f11);
    }

    private void H(View view, View view2, int i10) {
        Rect f10 = f();
        Rect f11 = f();
        try {
            x(view2, f10);
            y(view, i10, f10, f11);
            view.layout(f11.left, f11.top, f11.right, f11.bottom);
        } finally {
            S(f10);
            S(f11);
        }
    }

    private void I(View view, int i10, int i11) {
        e eVar = (e) view.getLayoutParams();
        int b10 = androidx.core.view.f.b(X(eVar.f2148c), i11);
        int i12 = b10 & 7;
        int i13 = b10 & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i11 == 1) {
            i10 = width - i10;
        }
        int A = A(i10) - measuredWidth;
        int i14 = 0;
        if (i12 == 1) {
            A += measuredWidth / 2;
        } else if (i12 == 5) {
            A += measuredWidth;
        }
        if (i13 == 16) {
            i14 = 0 + (measuredHeight / 2);
        } else if (i13 == 80) {
            i14 = measuredHeight + 0;
        }
        int max = Math.max(getPaddingLeft() + eVar.leftMargin, Math.min(A, ((width - getPaddingRight()) - measuredWidth) - eVar.rightMargin));
        int max2 = Math.max(getPaddingTop() + eVar.topMargin, Math.min(i14, ((height - getPaddingBottom()) - measuredHeight) - eVar.bottomMargin));
        view.layout(max, max2, measuredWidth + max, measuredHeight + max2);
    }

    private void J(View view, Rect rect, int i10) {
        boolean z10;
        boolean z11;
        int width;
        int i11;
        int i12;
        int i13;
        int height;
        int i14;
        int i15;
        int i16;
        if (x.V(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            e eVar = (e) view.getLayoutParams();
            Behavior f10 = eVar.f();
            Rect f11 = f();
            Rect f12 = f();
            f12.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (f10 == null || !f10.b(this, view, f11)) {
                f11.set(f12);
            } else if (!f12.contains(f11)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + f11.toShortString() + " | Bounds:" + f12.toShortString());
            }
            S(f12);
            if (f11.isEmpty()) {
                S(f11);
                return;
            }
            int b10 = androidx.core.view.f.b(eVar.f2153h, i10);
            boolean z12 = true;
            if ((b10 & 48) != 48 || (i15 = (f11.top - eVar.topMargin) - eVar.f2155j) >= (i16 = rect.top)) {
                z10 = false;
            } else {
                Z(view, i16 - i15);
                z10 = true;
            }
            if ((b10 & 80) == 80 && (height = ((getHeight() - f11.bottom) - eVar.bottomMargin) + eVar.f2155j) < (i14 = rect.bottom)) {
                Z(view, height - i14);
                z10 = true;
            }
            if (!z10) {
                Z(view, 0);
            }
            if ((b10 & 3) != 3 || (i12 = (f11.left - eVar.leftMargin) - eVar.f2154i) >= (i13 = rect.left)) {
                z11 = false;
            } else {
                Y(view, i13 - i12);
                z11 = true;
            }
            if ((b10 & 5) != 5 || (width = ((getWidth() - f11.right) - eVar.rightMargin) + eVar.f2154i) >= (i11 = rect.right)) {
                z12 = z11;
            } else {
                Y(view, width - i11);
            }
            if (!z12) {
                Y(view, 0);
            }
            S(f11);
        }
    }

    static Behavior O(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0) {
            String str2 = f2118u;
            if (!TextUtils.isEmpty(str2)) {
                str = str2 + '.' + str;
            }
        }
        try {
            ThreadLocal<Map<String, Constructor<Behavior>>> threadLocal = f2120w;
            Map map = threadLocal.get();
            if (map == null) {
                map = new HashMap();
                threadLocal.set(map);
            }
            Constructor<?> constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(f2119v);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (Behavior) constructor.newInstance(new Object[]{context, attributeSet});
        } catch (Exception e10) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e10);
        }
    }

    private boolean P(MotionEvent motionEvent, int i10) {
        MotionEvent motionEvent2 = motionEvent;
        int i11 = i10;
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.f2125c;
        D(list);
        int size = list.size();
        MotionEvent motionEvent3 = null;
        boolean z10 = false;
        boolean z11 = false;
        for (int i12 = 0; i12 < size; i12++) {
            View view = list.get(i12);
            e eVar = (e) view.getLayoutParams();
            Behavior f10 = eVar.f();
            if ((!z10 && !z11) || actionMasked == 0) {
                if (!z10 && f10 != null) {
                    if (i11 == 0) {
                        z10 = f10.k(this, view, motionEvent2);
                    } else if (i11 == 1) {
                        z10 = f10.D(this, view, motionEvent2);
                    }
                    if (z10) {
                        this.f2133k = view;
                    }
                }
                boolean c10 = eVar.c();
                boolean i13 = eVar.i(this, view);
                z11 = i13 && !c10;
                if (i13 && !z11) {
                    break;
                }
            } else if (f10 != null) {
                if (motionEvent3 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent3 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i11 == 0) {
                    f10.k(this, view, motionEvent3);
                } else if (i11 == 1) {
                    f10.D(this, view, motionEvent3);
                }
            }
        }
        list.clear();
        return z10;
    }

    private void Q() {
        this.f2123a.clear();
        this.f2124b.c();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            e C = C(childAt);
            C.d(this, childAt);
            this.f2124b.b(childAt);
            for (int i11 = 0; i11 < childCount; i11++) {
                if (i11 != i10) {
                    View childAt2 = getChildAt(i11);
                    if (C.b(this, childAt, childAt2)) {
                        if (!this.f2124b.d(childAt2)) {
                            this.f2124b.b(childAt2);
                        }
                        this.f2124b.a(childAt2, childAt);
                    }
                }
            }
        }
        this.f2123a.addAll(this.f2124b.i());
        Collections.reverse(this.f2123a);
    }

    private static void S(Rect rect) {
        rect.setEmpty();
        f2122y.a(rect);
    }

    private void U(boolean z10) {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            Behavior f10 = ((e) childAt.getLayoutParams()).f();
            if (f10 != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z10) {
                    f10.k(this, childAt, obtain);
                } else {
                    f10.D(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i11 = 0; i11 < childCount; i11++) {
            ((e) getChildAt(i11).getLayoutParams()).m();
        }
        this.f2133k = null;
        this.f2130h = false;
    }

    private static int V(int i10) {
        if (i10 == 0) {
            return 17;
        }
        return i10;
    }

    private static int W(int i10) {
        if ((i10 & 7) == 0) {
            i10 |= 8388611;
        }
        return (i10 & 112) == 0 ? i10 | 48 : i10;
    }

    private static int X(int i10) {
        if (i10 == 0) {
            return 8388661;
        }
        return i10;
    }

    private void Y(View view, int i10) {
        e eVar = (e) view.getLayoutParams();
        int i11 = eVar.f2154i;
        if (i11 != i10) {
            x.a0(view, i10 - i11);
            eVar.f2154i = i10;
        }
    }

    private void Z(View view, int i10) {
        e eVar = (e) view.getLayoutParams();
        int i11 = eVar.f2155j;
        if (i11 != i10) {
            x.b0(view, i10 - i11);
            eVar.f2155j = i10;
        }
    }

    private void b0() {
        if (Build.VERSION.SDK_INT >= 21) {
            if (x.z(this)) {
                if (this.f2141s == null) {
                    this.f2141s = new a();
                }
                x.F0(this, this.f2141s);
                setSystemUiVisibility(1280);
                return;
            }
            x.F0(this, (r) null);
        }
    }

    private static Rect f() {
        Rect b10 = f2122y.b();
        return b10 == null ? new Rect() : b10;
    }

    private static int h(int i10, int i11, int i12) {
        return i10 < i11 ? i11 : i10 > i12 ? i12 : i10;
    }

    private void k(e eVar, Rect rect, int i10, int i11) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + eVar.leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i10) - eVar.rightMargin));
        int max2 = Math.max(getPaddingTop() + eVar.topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i11) - eVar.bottomMargin));
        rect.set(max, max2, i10 + max, i11 + max2);
    }

    private f0 l(f0 f0Var) {
        Behavior f10;
        if (f0Var.q()) {
            return f0Var;
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (x.z(childAt) && (f10 = ((e) childAt.getLayoutParams()).f()) != null) {
                f0Var = f10.f(this, childAt, f0Var);
                if (f0Var.q()) {
                    break;
                }
            }
        }
        return f0Var;
    }

    private void z(View view, int i10, Rect rect, Rect rect2, e eVar, int i11, int i12) {
        int b10 = androidx.core.view.f.b(V(eVar.f2148c), i10);
        int b11 = androidx.core.view.f.b(W(eVar.f2149d), i10);
        int i13 = b10 & 7;
        int i14 = b10 & 112;
        int i15 = b11 & 7;
        int i16 = b11 & 112;
        int width = i15 != 1 ? i15 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int height = i16 != 16 ? i16 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i13 == 1) {
            width -= i11 / 2;
        } else if (i13 != 5) {
            width -= i11;
        }
        if (i14 == 16) {
            height -= i12 / 2;
        } else if (i14 != 80) {
            height -= i12;
        }
        rect2.set(width, height, i11 + width, i12 + height);
    }

    /* access modifiers changed from: package-private */
    public void B(View view, Rect rect) {
        rect.set(((e) view.getLayoutParams()).h());
    }

    /* access modifiers changed from: package-private */
    public e C(View view) {
        e eVar = (e) view.getLayoutParams();
        if (!eVar.f2147b) {
            if (view instanceof b) {
                Behavior behavior = ((b) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                eVar.o(behavior);
            } else {
                c cVar = null;
                for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    cVar = (c) cls.getAnnotation(c.class);
                    if (cVar != null) {
                        break;
                    }
                }
                if (cVar != null) {
                    try {
                        eVar.o((Behavior) cVar.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e10) {
                        Log.e("CoordinatorLayout", "Default behavior class " + cVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e10);
                    }
                }
            }
            eVar.f2147b = true;
        }
        return eVar;
    }

    public boolean F(View view, int i10, int i11) {
        Rect f10 = f();
        x(view, f10);
        try {
            return f10.contains(i10, i11);
        } finally {
            S(f10);
        }
    }

    /* access modifiers changed from: package-private */
    public void K(View view, int i10) {
        Behavior f10;
        View view2 = view;
        e eVar = (e) view.getLayoutParams();
        if (eVar.f2156k != null) {
            Rect f11 = f();
            Rect f12 = f();
            Rect f13 = f();
            x(eVar.f2156k, f11);
            boolean z10 = false;
            u(view2, false, f12);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            int i11 = measuredHeight;
            z(view, i10, f11, f13, eVar, measuredWidth, measuredHeight);
            if (!(f13.left == f12.left && f13.top == f12.top)) {
                z10 = true;
            }
            k(eVar, f13, measuredWidth, i11);
            int i12 = f13.left - f12.left;
            int i13 = f13.top - f12.top;
            if (i12 != 0) {
                x.a0(view2, i12);
            }
            if (i13 != 0) {
                x.b0(view2, i13);
            }
            if (z10 && (f10 = eVar.f()) != null) {
                f10.h(this, view2, eVar.f2156k);
            }
            S(f11);
            S(f12);
            S(f13);
        }
    }

    /* access modifiers changed from: package-private */
    public final void L(int i10) {
        boolean z10;
        int i11 = i10;
        int C = x.C(this);
        int size = this.f2123a.size();
        Rect f10 = f();
        Rect f11 = f();
        Rect f12 = f();
        for (int i12 = 0; i12 < size; i12++) {
            View view = this.f2123a.get(i12);
            e eVar = (e) view.getLayoutParams();
            if (i11 != 0 || view.getVisibility() != 8) {
                for (int i13 = 0; i13 < i12; i13++) {
                    if (eVar.f2157l == this.f2123a.get(i13)) {
                        K(view, C);
                    }
                }
                u(view, true, f11);
                if (eVar.f2152g != 0 && !f11.isEmpty()) {
                    int b10 = androidx.core.view.f.b(eVar.f2152g, C);
                    int i14 = b10 & 112;
                    if (i14 == 48) {
                        f10.top = Math.max(f10.top, f11.bottom);
                    } else if (i14 == 80) {
                        f10.bottom = Math.max(f10.bottom, getHeight() - f11.top);
                    }
                    int i15 = b10 & 7;
                    if (i15 == 3) {
                        f10.left = Math.max(f10.left, f11.right);
                    } else if (i15 == 5) {
                        f10.right = Math.max(f10.right, getWidth() - f11.left);
                    }
                }
                if (eVar.f2153h != 0 && view.getVisibility() == 0) {
                    J(view, f10, C);
                }
                if (i11 != 2) {
                    B(view, f12);
                    if (!f12.equals(f11)) {
                        R(view, f11);
                    }
                }
                for (int i16 = i12 + 1; i16 < size; i16++) {
                    View view2 = this.f2123a.get(i16);
                    e eVar2 = (e) view2.getLayoutParams();
                    Behavior f13 = eVar2.f();
                    if (f13 != null && f13.e(this, view2, view)) {
                        if (i11 != 0 || !eVar2.g()) {
                            if (i11 != 2) {
                                z10 = f13.h(this, view2, view);
                            } else {
                                f13.i(this, view2, view);
                                z10 = true;
                            }
                            if (i11 == 1) {
                                eVar2.p(z10);
                            }
                        } else {
                            eVar2.k();
                        }
                    }
                }
            }
        }
        S(f10);
        S(f11);
        S(f12);
    }

    public void M(View view, int i10) {
        e eVar = (e) view.getLayoutParams();
        if (!eVar.a()) {
            View view2 = eVar.f2156k;
            if (view2 != null) {
                H(view, view2, i10);
                return;
            }
            int i11 = eVar.f2150e;
            if (i11 >= 0) {
                I(view, i11, i10);
            } else {
                G(view, i10);
            }
        } else {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
    }

    public void N(View view, int i10, int i11, int i12, int i13) {
        measureChildWithMargins(view, i10, i11, i12, i13);
    }

    /* access modifiers changed from: package-private */
    public void R(View view, Rect rect) {
        ((e) view.getLayoutParams()).q(rect);
    }

    /* access modifiers changed from: package-private */
    public void T() {
        if (this.f2131i && this.f2135m != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f2135m);
        }
        this.f2136n = false;
    }

    /* access modifiers changed from: package-private */
    public final f0 a0(f0 f0Var) {
        if (w0.c.a(this.f2137o, f0Var)) {
            return f0Var;
        }
        this.f2137o = f0Var;
        boolean z10 = true;
        boolean z11 = f0Var != null && f0Var.m() > 0;
        this.f2138p = z11;
        if (z11 || getBackground() != null) {
            z10 = false;
        }
        setWillNotDraw(z10);
        f0 l10 = l(f0Var);
        requestLayout();
        return l10;
    }

    public void c(View view, View view2, int i10, int i11) {
        Behavior f10;
        this.f2142t.c(view, view2, i10, i11);
        this.f2134l = view2;
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            e eVar = (e) childAt.getLayoutParams();
            if (eVar.j(i11) && (f10 = eVar.f()) != null) {
                f10.v(this, childAt, view, view2, i10, i11);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof e) && super.checkLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j10) {
        e eVar = (e) view.getLayoutParams();
        Behavior behavior = eVar.f2146a;
        if (behavior != null) {
            float d10 = behavior.d(this, view);
            if (d10 > 0.0f) {
                if (this.f2127e == null) {
                    this.f2127e = new Paint();
                }
                this.f2127e.setColor(eVar.f2146a.c(this, view));
                this.f2127e.setAlpha(h(Math.round(d10 * 255.0f), 0, 255));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()), this.f2127e);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j10);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f2139q;
        boolean z10 = false;
        if (drawable != null && drawable.isStateful()) {
            z10 = false | drawable.setState(drawableState);
        }
        if (z10) {
            invalidate();
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        if (this.f2131i) {
            if (this.f2135m == null) {
                this.f2135m = new f();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f2135m);
        }
        this.f2136n = true;
    }

    /* access modifiers changed from: package-private */
    public final List<View> getDependencySortedChildren() {
        Q();
        return Collections.unmodifiableList(this.f2123a);
    }

    public final f0 getLastWindowInsets() {
        return this.f2137o;
    }

    public int getNestedScrollAxes() {
        return this.f2142t.a();
    }

    public Drawable getStatusBarBackground() {
        return this.f2139q;
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    public void i(View view, int i10) {
        this.f2142t.e(view, i10);
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            e eVar = (e) childAt.getLayoutParams();
            if (eVar.j(i10)) {
                Behavior f10 = eVar.f();
                if (f10 != null) {
                    f10.C(this, childAt, view, i10);
                }
                eVar.l(i10);
                eVar.k();
            }
        }
        this.f2134l = null;
    }

    public void j(View view, int i10, int i11, int[] iArr, int i12) {
        Behavior f10;
        int childCount = getChildCount();
        boolean z10 = false;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() == 8) {
                int i16 = i12;
            } else {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.j(i12) && (f10 = eVar.f()) != null) {
                    int[] iArr2 = this.f2128f;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    f10.q(this, childAt, view, i10, i11, iArr2, i12);
                    int[] iArr3 = this.f2128f;
                    i13 = i10 > 0 ? Math.max(i13, iArr3[0]) : Math.min(i13, iArr3[0]);
                    int[] iArr4 = this.f2128f;
                    i14 = i11 > 0 ? Math.max(i14, iArr4[1]) : Math.min(i14, iArr4[1]);
                    z10 = true;
                }
            }
        }
        iArr[0] = i13;
        iArr[1] = i14;
        if (z10) {
            L(1);
        }
    }

    public void m(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        Behavior f10;
        boolean z10;
        int i15;
        int childCount = getChildCount();
        boolean z11 = false;
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.j(i14) && (f10 = eVar.f()) != null) {
                    int[] iArr2 = this.f2128f;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    f10.t(this, childAt, view, i10, i11, i12, i13, i14, iArr2);
                    int[] iArr3 = this.f2128f;
                    i16 = i12 > 0 ? Math.max(i16, iArr3[0]) : Math.min(i16, iArr3[0]);
                    if (i13 > 0) {
                        z10 = true;
                        i15 = Math.max(i17, this.f2128f[1]);
                    } else {
                        z10 = true;
                        i15 = Math.min(i17, this.f2128f[1]);
                    }
                    i17 = i15;
                    z11 = z10;
                }
            }
        }
        iArr[0] = iArr[0] + i16;
        iArr[1] = iArr[1] + i17;
        if (z11) {
            L(1);
        }
    }

    public void n(View view, int i10, int i11, int i12, int i13, int i14) {
        m(view, i10, i11, i12, i13, 0, this.f2129g);
    }

    public boolean o(View view, View view2, int i10, int i11) {
        int i12 = i11;
        int childCount = getChildCount();
        int i13 = 0;
        boolean z10 = false;
        while (true) {
            if (i13 >= childCount) {
                return z10;
            }
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                Behavior f10 = eVar.f();
                if (f10 != null) {
                    boolean A = f10.A(this, childAt, view, view2, i10, i11);
                    z10 |= A;
                    eVar.r(i12, A);
                } else {
                    eVar.r(i12, false);
                }
            }
            i13++;
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        U(false);
        if (this.f2136n) {
            if (this.f2135m == null) {
                this.f2135m = new f();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f2135m);
        }
        if (this.f2137o == null && x.z(this)) {
            x.o0(this);
        }
        this.f2131i = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        U(false);
        if (this.f2136n && this.f2135m != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f2135m);
        }
        View view = this.f2134l;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.f2131i = false;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f2138p && this.f2139q != null) {
            f0 f0Var = this.f2137o;
            int m10 = f0Var != null ? f0Var.m() : 0;
            if (m10 > 0) {
                this.f2139q.setBounds(0, 0, getWidth(), m10);
                this.f2139q.draw(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            U(true);
        }
        boolean P = P(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            U(true);
        }
        return P;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        Behavior f10;
        int C = x.C(this);
        int size = this.f2123a.size();
        for (int i14 = 0; i14 < size; i14++) {
            View view = this.f2123a.get(i14);
            if (view.getVisibility() != 8 && ((f10 = ((e) view.getLayoutParams()).f()) == null || !f10.l(this, view, C))) {
                M(view, C);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x011a, code lost:
        if (r0.m(r30, r20, r11, r21, r23, 0) == false) goto L_0x012a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x011d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r31, int r32) {
        /*
            r30 = this;
            r7 = r30
            r30.Q()
            r30.q()
            int r8 = r30.getPaddingLeft()
            int r0 = r30.getPaddingTop()
            int r9 = r30.getPaddingRight()
            int r1 = r30.getPaddingBottom()
            int r10 = androidx.core.view.x.C(r30)
            r2 = 1
            if (r10 != r2) goto L_0x0021
            r12 = r2
            goto L_0x0022
        L_0x0021:
            r12 = 0
        L_0x0022:
            int r13 = android.view.View.MeasureSpec.getMode(r31)
            int r14 = android.view.View.MeasureSpec.getSize(r31)
            int r15 = android.view.View.MeasureSpec.getMode(r32)
            int r16 = android.view.View.MeasureSpec.getSize(r32)
            int r17 = r8 + r9
            int r18 = r0 + r1
            int r0 = r30.getSuggestedMinimumWidth()
            int r1 = r30.getSuggestedMinimumHeight()
            androidx.core.view.f0 r3 = r7.f2137o
            if (r3 == 0) goto L_0x004b
            boolean r3 = androidx.core.view.x.z(r30)
            if (r3 == 0) goto L_0x004b
            r19 = r2
            goto L_0x004d
        L_0x004b:
            r19 = 0
        L_0x004d:
            java.util.List<android.view.View> r2 = r7.f2123a
            int r6 = r2.size()
            r5 = r0
            r4 = r1
            r2 = 0
            r3 = 0
        L_0x0057:
            if (r3 >= r6) goto L_0x016f
            java.util.List<android.view.View> r0 = r7.f2123a
            java.lang.Object r0 = r0.get(r3)
            r20 = r0
            android.view.View r20 = (android.view.View) r20
            int r0 = r20.getVisibility()
            r1 = 8
            if (r0 != r1) goto L_0x0073
            r22 = r3
            r29 = r6
            r28 = r8
            goto L_0x0167
        L_0x0073:
            android.view.ViewGroup$LayoutParams r0 = r20.getLayoutParams()
            r1 = r0
            androidx.coordinatorlayout.widget.CoordinatorLayout$e r1 = (androidx.coordinatorlayout.widget.CoordinatorLayout.e) r1
            int r0 = r1.f2150e
            if (r0 < 0) goto L_0x00ba
            if (r13 == 0) goto L_0x00ba
            int r0 = r7.A(r0)
            int r11 = r1.f2148c
            int r11 = X(r11)
            int r11 = androidx.core.view.f.b(r11, r10)
            r11 = r11 & 7
            r22 = r2
            r2 = 3
            if (r11 != r2) goto L_0x0097
            if (r12 == 0) goto L_0x009c
        L_0x0097:
            r2 = 5
            if (r11 != r2) goto L_0x00a8
            if (r12 == 0) goto L_0x00a8
        L_0x009c:
            int r2 = r14 - r9
            int r2 = r2 - r0
            r0 = 0
            int r2 = java.lang.Math.max(r0, r2)
            r11 = r0
            r21 = r2
            goto L_0x00bf
        L_0x00a8:
            if (r11 != r2) goto L_0x00ac
            if (r12 == 0) goto L_0x00b1
        L_0x00ac:
            r2 = 3
            if (r11 != r2) goto L_0x00bc
            if (r12 == 0) goto L_0x00bc
        L_0x00b1:
            int r0 = r0 - r8
            r11 = 0
            int r0 = java.lang.Math.max(r11, r0)
            r21 = r0
            goto L_0x00bf
        L_0x00ba:
            r22 = r2
        L_0x00bc:
            r11 = 0
            r21 = r11
        L_0x00bf:
            if (r19 == 0) goto L_0x00f1
            boolean r0 = androidx.core.view.x.z(r20)
            if (r0 != 0) goto L_0x00f1
            androidx.core.view.f0 r0 = r7.f2137o
            int r0 = r0.k()
            androidx.core.view.f0 r2 = r7.f2137o
            int r2 = r2.l()
            int r0 = r0 + r2
            androidx.core.view.f0 r2 = r7.f2137o
            int r2 = r2.m()
            androidx.core.view.f0 r11 = r7.f2137o
            int r11 = r11.j()
            int r2 = r2 + r11
            int r0 = r14 - r0
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r13)
            int r2 = r16 - r2
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r15)
            r11 = r0
            r23 = r2
            goto L_0x00f5
        L_0x00f1:
            r11 = r31
            r23 = r32
        L_0x00f5:
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r0 = r1.f()
            if (r0 == 0) goto L_0x011d
            r24 = 0
            r2 = r1
            r1 = r30
            r26 = r2
            r25 = r22
            r2 = r20
            r22 = r3
            r3 = r11
            r27 = r4
            r4 = r21
            r28 = r8
            r8 = r5
            r5 = r23
            r29 = r6
            r6 = r24
            boolean r0 = r0.m(r1, r2, r3, r4, r5, r6)
            if (r0 != 0) goto L_0x0137
            goto L_0x012a
        L_0x011d:
            r26 = r1
            r27 = r4
            r29 = r6
            r28 = r8
            r25 = r22
            r22 = r3
            r8 = r5
        L_0x012a:
            r5 = 0
            r0 = r30
            r1 = r20
            r2 = r11
            r3 = r21
            r4 = r23
            r0.N(r1, r2, r3, r4, r5)
        L_0x0137:
            int r0 = r20.getMeasuredWidth()
            int r0 = r17 + r0
            r1 = r26
            int r2 = r1.leftMargin
            int r0 = r0 + r2
            int r2 = r1.rightMargin
            int r0 = r0 + r2
            int r0 = java.lang.Math.max(r8, r0)
            int r2 = r20.getMeasuredHeight()
            int r2 = r18 + r2
            int r3 = r1.topMargin
            int r2 = r2 + r3
            int r1 = r1.bottomMargin
            int r2 = r2 + r1
            r1 = r27
            int r1 = java.lang.Math.max(r1, r2)
            int r2 = r20.getMeasuredState()
            r11 = r25
            int r2 = android.view.View.combineMeasuredStates(r11, r2)
            r5 = r0
            r4 = r1
        L_0x0167:
            int r3 = r22 + 1
            r8 = r28
            r6 = r29
            goto L_0x0057
        L_0x016f:
            r11 = r2
            r1 = r4
            r8 = r5
            r0 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r0 = r0 & r11
            r2 = r31
            int r0 = android.view.View.resolveSizeAndState(r8, r2, r0)
            int r2 = r11 << 16
            r3 = r32
            int r1 = android.view.View.resolveSizeAndState(r1, r3, r2)
            r7.setMeasuredDimension(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        Behavior f12;
        int childCount = getChildCount();
        boolean z11 = false;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.j(0) && (f12 = eVar.f()) != null) {
                    z11 |= f12.n(this, childAt, view, f10, f11, z10);
                }
            }
        }
        if (z11) {
            L(1);
        }
        return z11;
    }

    public boolean onNestedPreFling(View view, float f10, float f11) {
        Behavior f12;
        int childCount = getChildCount();
        boolean z10 = false;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.j(0) && (f12 = eVar.f()) != null) {
                    z10 |= f12.o(this, childAt, view, f10, f11);
                }
            }
        }
        return z10;
    }

    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
        j(view, i10, i11, iArr, 0);
    }

    public void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        n(view, i10, i11, i12, i13, 0);
    }

    public void onNestedScrollAccepted(View view, View view2, int i10) {
        c(view, view2, i10, 0);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        SparseArray<Parcelable> sparseArray = savedState.f2143c;
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            int id2 = childAt.getId();
            Behavior f10 = C(childAt).f();
            if (!(id2 == -1 || f10 == null || (parcelable2 = sparseArray.get(id2)) == null)) {
                f10.x(this, childAt, parcelable2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Parcelable y10;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            int id2 = childAt.getId();
            Behavior f10 = ((e) childAt.getLayoutParams()).f();
            if (!(id2 == -1 || f10 == null || (y10 = f10.y(this, childAt)) == null)) {
                sparseArray.append(id2, y10);
            }
        }
        savedState.f2143c = sparseArray;
        return savedState;
    }

    public boolean onStartNestedScroll(View view, View view2, int i10) {
        return o(view, view2, i10, 0);
    }

    public void onStopNestedScroll(View view) {
        i(view, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0012, code lost:
        if (r3 != false) goto L_0x0016;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.f2133k
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L_0x0015
            boolean r3 = r0.P(r1, r4)
            if (r3 == 0) goto L_0x002b
            goto L_0x0016
        L_0x0015:
            r3 = r5
        L_0x0016:
            android.view.View r6 = r0.f2133k
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$e r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.e) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r6 = r6.f()
            if (r6 == 0) goto L_0x002b
            android.view.View r7 = r0.f2133k
            boolean r6 = r6.D(r0, r7, r1)
            goto L_0x002c
        L_0x002b:
            r6 = r5
        L_0x002c:
            android.view.View r7 = r0.f2133k
            r8 = 0
            if (r7 != 0) goto L_0x0037
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L_0x004a
        L_0x0037:
            if (r3 == 0) goto L_0x004a
            long r11 = android.os.SystemClock.uptimeMillis()
            r13 = 3
            r14 = 0
            r15 = 0
            r16 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L_0x004a:
            if (r8 == 0) goto L_0x004f
            r8.recycle()
        L_0x004f:
            if (r2 == r4) goto L_0x0054
            r1 = 3
            if (r2 != r1) goto L_0x0057
        L_0x0054:
            r0.U(r5)
        L_0x0057:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void p(View view) {
        List g10 = this.f2124b.g(view);
        if (g10 != null && !g10.isEmpty()) {
            for (int i10 = 0; i10 < g10.size(); i10++) {
                View view2 = (View) g10.get(i10);
                Behavior f10 = ((e) view2.getLayoutParams()).f();
                if (f10 != null) {
                    f10.h(this, view2, view);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void q() {
        int childCount = getChildCount();
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= childCount) {
                break;
            } else if (E(getChildAt(i10))) {
                z10 = true;
                break;
            } else {
                i10++;
            }
        }
        if (z10 == this.f2136n) {
            return;
        }
        if (z10) {
            g();
        } else {
            T();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public e generateDefaultLayoutParams() {
        return new e(-2, -2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z10) {
        Behavior f10 = ((e) view.getLayoutParams()).f();
        if (f10 == null || !f10.w(this, view, rect, z10)) {
            return super.requestChildRectangleOnScreen(view, rect, z10);
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z10) {
        super.requestDisallowInterceptTouchEvent(z10);
        if (z10 && !this.f2130h) {
            U(false);
            this.f2130h = true;
        }
    }

    /* renamed from: s */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    public void setFitsSystemWindows(boolean z10) {
        super.setFitsSystemWindows(z10);
        b0();
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f2140r = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.f2139q;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f2139q = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f2139q.setState(getDrawableState());
                }
                p0.a.m(this.f2139q, x.C(this));
                this.f2139q.setVisible(getVisibility() == 0, false);
                this.f2139q.setCallback(this);
            }
            x.h0(this);
        }
    }

    public void setStatusBarBackgroundColor(int i10) {
        setStatusBarBackground(new ColorDrawable(i10));
    }

    public void setStatusBarBackgroundResource(int i10) {
        setStatusBarBackground(i10 != 0 ? androidx.core.content.a.f(getContext(), i10) : null);
    }

    public void setVisibility(int i10) {
        super.setVisibility(i10);
        boolean z10 = i10 == 0;
        Drawable drawable = this.f2139q;
        if (drawable != null && drawable.isVisible() != z10) {
            this.f2139q.setVisible(z10, false);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: t */
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e ? new e((e) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }

    /* access modifiers changed from: package-private */
    public void u(View view, boolean z10, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z10) {
            x(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public List<View> v(View view) {
        List<View> h10 = this.f2124b.h(view);
        this.f2126d.clear();
        if (h10 != null) {
            this.f2126d.addAll(h10);
        }
        return this.f2126d;
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f2139q;
    }

    public List<View> w(View view) {
        List g10 = this.f2124b.g(view);
        this.f2126d.clear();
        if (g10 != null) {
            this.f2126d.addAll(g10);
        }
        return this.f2126d;
    }

    /* access modifiers changed from: package-private */
    public void x(View view, Rect rect) {
        b.a(this, view, rect);
    }

    /* access modifiers changed from: package-private */
    public void y(View view, int i10, Rect rect, Rect rect2) {
        e eVar = (e) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        z(view, i10, rect, rect2, eVar, measuredWidth, measuredHeight);
        k(eVar, rect2, measuredWidth, measuredHeight);
    }
}
