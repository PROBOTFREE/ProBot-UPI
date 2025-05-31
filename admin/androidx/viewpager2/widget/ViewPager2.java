package androidx.viewpager2.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.x;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.t;
import x0.c;
import x0.f;

public final class ViewPager2 extends ViewGroup {

    /* renamed from: u  reason: collision with root package name */
    static boolean f4341u = true;

    /* renamed from: a  reason: collision with root package name */
    private final Rect f4342a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    private final Rect f4343b = new Rect();

    /* renamed from: c  reason: collision with root package name */
    private b f4344c = new b(3);

    /* renamed from: d  reason: collision with root package name */
    int f4345d;

    /* renamed from: e  reason: collision with root package name */
    boolean f4346e = false;

    /* renamed from: f  reason: collision with root package name */
    private RecyclerView.j f4347f = new a();

    /* renamed from: g  reason: collision with root package name */
    private LinearLayoutManager f4348g;

    /* renamed from: h  reason: collision with root package name */
    private int f4349h = -1;

    /* renamed from: i  reason: collision with root package name */
    private Parcelable f4350i;

    /* renamed from: j  reason: collision with root package name */
    RecyclerView f4351j;

    /* renamed from: k  reason: collision with root package name */
    private t f4352k;

    /* renamed from: l  reason: collision with root package name */
    e f4353l;

    /* renamed from: m  reason: collision with root package name */
    private b f4354m;

    /* renamed from: n  reason: collision with root package name */
    private c f4355n;

    /* renamed from: o  reason: collision with root package name */
    private d f4356o;

    /* renamed from: p  reason: collision with root package name */
    private RecyclerView.m f4357p = null;

    /* renamed from: q  reason: collision with root package name */
    private boolean f4358q = false;

    /* renamed from: r  reason: collision with root package name */
    private boolean f4359r = true;

    /* renamed from: s  reason: collision with root package name */
    private int f4360s = -1;

    /* renamed from: t  reason: collision with root package name */
    e f4361t;

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        int f4362a;

        /* renamed from: b  reason: collision with root package name */
        int f4363b;

        /* renamed from: c  reason: collision with root package name */
        Parcelable f4364c;

        static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return Build.VERSION.SDK_INT >= 24 ? new SavedState(parcel, classLoader) : new SavedState(parcel);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        SavedState(Parcel parcel) {
            super(parcel);
            a(parcel, (ClassLoader) null);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void a(Parcel parcel, ClassLoader classLoader) {
            this.f4362a = parcel.readInt();
            this.f4363b = parcel.readInt();
            this.f4364c = parcel.readParcelable(classLoader);
        }

        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f4362a);
            parcel.writeInt(this.f4363b);
            parcel.writeParcelable(this.f4364c, i10);
        }
    }

    class a extends g {
        a() {
            super((a) null);
        }

        public void a() {
            ViewPager2 viewPager2 = ViewPager2.this;
            viewPager2.f4346e = true;
            viewPager2.f4353l.j();
        }
    }

    class b extends i {
        b() {
        }

        public void onPageScrollStateChanged(int i10) {
            if (i10 == 0) {
                ViewPager2.this.n();
            }
        }

        public void onPageSelected(int i10) {
            ViewPager2 viewPager2 = ViewPager2.this;
            if (viewPager2.f4345d != i10) {
                viewPager2.f4345d = i10;
                viewPager2.f4361t.q();
            }
        }
    }

    class c extends i {
        c() {
        }

        public void onPageSelected(int i10) {
            ViewPager2.this.clearFocus();
            if (ViewPager2.this.hasFocus()) {
                ViewPager2.this.f4351j.requestFocus(2);
            }
        }
    }

    class d implements RecyclerView.q {
        d(ViewPager2 viewPager2) {
        }

        public void b(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            if (layoutParams.width != -1 || layoutParams.height != -1) {
                throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
            }
        }

        public void d(View view) {
        }
    }

    private abstract class e {
        private e(ViewPager2 viewPager2) {
        }

        /* synthetic */ e(ViewPager2 viewPager2, a aVar) {
            this(viewPager2);
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean b(int i10) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean c(int i10, Bundle bundle) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean d() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public void e(RecyclerView.h<?> hVar) {
        }

        /* access modifiers changed from: package-private */
        public void f(RecyclerView.h<?> hVar) {
        }

        /* access modifiers changed from: package-private */
        public String g() {
            throw new IllegalStateException("Not implemented.");
        }

        /* access modifiers changed from: package-private */
        public void h(b bVar, RecyclerView recyclerView) {
        }

        /* access modifiers changed from: package-private */
        public void i(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        /* access modifiers changed from: package-private */
        public void j(x0.c cVar) {
        }

        /* access modifiers changed from: package-private */
        public boolean k(int i10) {
            throw new IllegalStateException("Not implemented.");
        }

        /* access modifiers changed from: package-private */
        public boolean l(int i10, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }

        /* access modifiers changed from: package-private */
        public void m() {
        }

        /* access modifiers changed from: package-private */
        public CharSequence n() {
            throw new IllegalStateException("Not implemented.");
        }

        /* access modifiers changed from: package-private */
        public void o(AccessibilityEvent accessibilityEvent) {
        }

        /* access modifiers changed from: package-private */
        public void p() {
        }

        /* access modifiers changed from: package-private */
        public void q() {
        }

        /* access modifiers changed from: package-private */
        public void r() {
        }

        /* access modifiers changed from: package-private */
        public void s() {
        }
    }

    class f extends e {
        f() {
            super(ViewPager2.this, (a) null);
        }

        public boolean b(int i10) {
            return (i10 == 8192 || i10 == 4096) && !ViewPager2.this.e();
        }

        public boolean d() {
            return true;
        }

        public void j(x0.c cVar) {
            if (!ViewPager2.this.e()) {
                cVar.T(c.a.f18126i);
                cVar.T(c.a.f18125h);
                cVar.y0(false);
            }
        }

        public boolean k(int i10) {
            if (b(i10)) {
                return false;
            }
            throw new IllegalStateException();
        }

        public CharSequence n() {
            if (d()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }
    }

    private static abstract class g extends RecyclerView.j {
        private g() {
        }

        /* synthetic */ g(a aVar) {
            this();
        }

        public final void b(int i10, int i11) {
            a();
        }

        public final void c(int i10, int i11, Object obj) {
            a();
        }

        public final void d(int i10, int i11) {
            a();
        }

        public final void e(int i10, int i11, int i12) {
            a();
        }

        public final void f(int i10, int i11) {
            a();
        }
    }

    private class h extends LinearLayoutManager {
        h(Context context) {
            super(context);
        }

        public boolean E1(RecyclerView recyclerView, View view, Rect rect, boolean z10, boolean z11) {
            return false;
        }

        public void X0(RecyclerView.v vVar, RecyclerView.z zVar, x0.c cVar) {
            super.X0(vVar, zVar, cVar);
            ViewPager2.this.f4361t.j(cVar);
        }

        /* access modifiers changed from: protected */
        public void Y1(RecyclerView.z zVar, int[] iArr) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.Y1(zVar, iArr);
                return;
            }
            int pageSize = ViewPager2.this.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }

        public boolean s1(RecyclerView.v vVar, RecyclerView.z zVar, int i10, Bundle bundle) {
            return ViewPager2.this.f4361t.b(i10) ? ViewPager2.this.f4361t.k(i10) : super.s1(vVar, zVar, i10, bundle);
        }
    }

    public static abstract class i {
        public void onPageScrollStateChanged(int i10) {
        }

        public void onPageScrolled(int i10, float f10, int i11) {
        }

        public void onPageSelected(int i10) {
        }
    }

    class j extends e {

        /* renamed from: a  reason: collision with root package name */
        private final x0.f f4369a = new a();

        /* renamed from: b  reason: collision with root package name */
        private final x0.f f4370b = new b();

        /* renamed from: c  reason: collision with root package name */
        private RecyclerView.j f4371c;

        class a implements x0.f {
            a() {
            }

            public boolean a(View view, f.a aVar) {
                j.this.v(((ViewPager2) view).getCurrentItem() + 1);
                return true;
            }
        }

        class b implements x0.f {
            b() {
            }

            public boolean a(View view, f.a aVar) {
                j.this.v(((ViewPager2) view).getCurrentItem() - 1);
                return true;
            }
        }

        class c extends g {
            c() {
                super((a) null);
            }

            public void a() {
                j.this.w();
            }
        }

        j() {
            super(ViewPager2.this, (a) null);
        }

        private void t(AccessibilityNodeInfo accessibilityNodeInfo) {
            int i10;
            int i11;
            if (ViewPager2.this.getAdapter() == null) {
                i11 = 0;
                i10 = 0;
            } else if (ViewPager2.this.getOrientation() == 1) {
                i11 = ViewPager2.this.getAdapter().getItemCount();
                i10 = 0;
            } else {
                i10 = ViewPager2.this.getAdapter().getItemCount();
                i11 = 0;
            }
            x0.c.I0(accessibilityNodeInfo).e0(c.b.b(i11, i10, false, 0));
        }

        private void u(AccessibilityNodeInfo accessibilityNodeInfo) {
            int itemCount;
            RecyclerView.h adapter = ViewPager2.this.getAdapter();
            if (adapter != null && (itemCount = adapter.getItemCount()) != 0 && ViewPager2.this.e()) {
                if (ViewPager2.this.f4345d > 0) {
                    accessibilityNodeInfo.addAction(8192);
                }
                if (ViewPager2.this.f4345d < itemCount - 1) {
                    accessibilityNodeInfo.addAction(RecyclerView.m.FLAG_APPEARED_IN_PRE_LAYOUT);
                }
                accessibilityNodeInfo.setScrollable(true);
            }
        }

        public boolean a() {
            return true;
        }

        public boolean c(int i10, Bundle bundle) {
            return i10 == 8192 || i10 == 4096;
        }

        public void e(RecyclerView.h<?> hVar) {
            w();
            if (hVar != null) {
                hVar.registerAdapterDataObserver(this.f4371c);
            }
        }

        public void f(RecyclerView.h<?> hVar) {
            if (hVar != null) {
                hVar.unregisterAdapterDataObserver(this.f4371c);
            }
        }

        public String g() {
            if (a()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }

        public void h(b bVar, RecyclerView recyclerView) {
            x.B0(recyclerView, 2);
            this.f4371c = new c();
            if (x.A(ViewPager2.this) == 0) {
                x.B0(ViewPager2.this, 1);
            }
        }

        public void i(AccessibilityNodeInfo accessibilityNodeInfo) {
            t(accessibilityNodeInfo);
            if (Build.VERSION.SDK_INT >= 16) {
                u(accessibilityNodeInfo);
            }
        }

        public boolean l(int i10, Bundle bundle) {
            if (c(i10, bundle)) {
                v(i10 == 8192 ? ViewPager2.this.getCurrentItem() - 1 : ViewPager2.this.getCurrentItem() + 1);
                return true;
            }
            throw new IllegalStateException();
        }

        public void m() {
            w();
        }

        public void o(AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setSource(ViewPager2.this);
            accessibilityEvent.setClassName(g());
        }

        public void p() {
            w();
        }

        public void q() {
            w();
        }

        public void r() {
            w();
        }

        public void s() {
            w();
            if (Build.VERSION.SDK_INT < 21) {
                ViewPager2.this.sendAccessibilityEvent(RecyclerView.m.FLAG_MOVED);
            }
        }

        /* access modifiers changed from: package-private */
        public void v(int i10) {
            if (ViewPager2.this.e()) {
                ViewPager2.this.k(i10, true);
            }
        }

        /* access modifiers changed from: package-private */
        public void w() {
            int itemCount;
            ViewPager2 viewPager2 = ViewPager2.this;
            int i10 = 16908360;
            x.l0(viewPager2, 16908360);
            x.l0(viewPager2, 16908361);
            x.l0(viewPager2, 16908358);
            x.l0(viewPager2, 16908359);
            if (ViewPager2.this.getAdapter() != null && (itemCount = ViewPager2.this.getAdapter().getItemCount()) != 0 && ViewPager2.this.e()) {
                if (ViewPager2.this.getOrientation() == 0) {
                    boolean d10 = ViewPager2.this.d();
                    int i11 = d10 ? 16908360 : 16908361;
                    if (d10) {
                        i10 = 16908361;
                    }
                    if (ViewPager2.this.f4345d < itemCount - 1) {
                        x.n0(viewPager2, new c.a(i11, (CharSequence) null), (CharSequence) null, this.f4369a);
                    }
                    if (ViewPager2.this.f4345d > 0) {
                        x.n0(viewPager2, new c.a(i10, (CharSequence) null), (CharSequence) null, this.f4370b);
                        return;
                    }
                    return;
                }
                if (ViewPager2.this.f4345d < itemCount - 1) {
                    x.n0(viewPager2, new c.a(16908359, (CharSequence) null), (CharSequence) null, this.f4369a);
                }
                if (ViewPager2.this.f4345d > 0) {
                    x.n0(viewPager2, new c.a(16908358, (CharSequence) null), (CharSequence) null, this.f4370b);
                }
            }
        }
    }

    public interface k {
        void a(View view, float f10);
    }

    private class l extends t {
        l() {
        }

        public View f(RecyclerView.p pVar) {
            if (ViewPager2.this.c()) {
                return null;
            }
            return super.f(pVar);
        }
    }

    private class m extends RecyclerView {
        m(Context context) {
            super(context);
        }

        public CharSequence getAccessibilityClassName() {
            return ViewPager2.this.f4361t.d() ? ViewPager2.this.f4361t.n() : super.getAccessibilityClassName();
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.f4345d);
            accessibilityEvent.setToIndex(ViewPager2.this.f4345d);
            ViewPager2.this.f4361t.o(accessibilityEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.e() && super.onInterceptTouchEvent(motionEvent);
        }

        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.e() && super.onTouchEvent(motionEvent);
        }
    }

    private static class n implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final int f4377a;

        /* renamed from: b  reason: collision with root package name */
        private final RecyclerView f4378b;

        n(int i10, RecyclerView recyclerView) {
            this.f4377a = i10;
            this.f4378b = recyclerView;
        }

        public void run() {
            this.f4378b.s1(this.f4377a);
        }
    }

    public ViewPager2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet);
    }

    public ViewPager2(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        b(context, attributeSet);
    }

    private RecyclerView.q a() {
        return new d(this);
    }

    private void b(Context context, AttributeSet attributeSet) {
        this.f4361t = f4341u ? new j() : new f();
        m mVar = new m(context);
        this.f4351j = mVar;
        mVar.setId(x.k());
        this.f4351j.setDescendantFocusability(131072);
        h hVar = new h(context);
        this.f4348g = hVar;
        this.f4351j.setLayoutManager(hVar);
        this.f4351j.setScrollingTouchSlop(1);
        l(context, attributeSet);
        this.f4351j.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f4351j.j(a());
        e eVar = new e(this);
        this.f4353l = eVar;
        this.f4355n = new c(this, eVar, this.f4351j);
        l lVar = new l();
        this.f4352k = lVar;
        lVar.b(this.f4351j);
        this.f4351j.l(this.f4353l);
        b bVar = new b(3);
        this.f4354m = bVar;
        this.f4353l.m(bVar);
        b bVar2 = new b();
        c cVar = new c();
        this.f4354m.a(bVar2);
        this.f4354m.a(cVar);
        this.f4361t.h(this.f4354m, this.f4351j);
        this.f4354m.a(this.f4344c);
        d dVar = new d(this.f4348g);
        this.f4356o = dVar;
        this.f4354m.a(dVar);
        RecyclerView recyclerView = this.f4351j;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    private void f(RecyclerView.h<?> hVar) {
        if (hVar != null) {
            hVar.registerAdapterDataObserver(this.f4347f);
        }
    }

    private void i() {
        RecyclerView.h adapter;
        if (this.f4349h != -1 && (adapter = getAdapter()) != null) {
            Parcelable parcelable = this.f4350i;
            if (parcelable != null) {
                if (adapter instanceof androidx.viewpager2.adapter.a) {
                    ((androidx.viewpager2.adapter.a) adapter).b(parcelable);
                }
                this.f4350i = null;
            }
            int max = Math.max(0, Math.min(this.f4349h, adapter.getItemCount() - 1));
            this.f4345d = max;
            this.f4349h = -1;
            this.f4351j.k1(max);
            this.f4361t.m();
        }
    }

    private void l(Context context, AttributeSet attributeSet) {
        int[] iArr = z1.a.ViewPager2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        }
        try {
            setOrientation(obtainStyledAttributes.getInt(z1.a.ViewPager2_android_orientation, 0));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void m(RecyclerView.h<?> hVar) {
        if (hVar != null) {
            hVar.unregisterAdapterDataObserver(this.f4347f);
        }
    }

    public boolean c() {
        return this.f4355n.a();
    }

    public boolean canScrollHorizontally(int i10) {
        return this.f4351j.canScrollHorizontally(i10);
    }

    public boolean canScrollVertically(int i10) {
        return this.f4351j.canScrollVertically(i10);
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.f4348g.n0() == 1;
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i10 = ((SavedState) parcelable).f4362a;
            sparseArray.put(this.f4351j.getId(), sparseArray.get(i10));
            sparseArray.remove(i10);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        i();
    }

    public boolean e() {
        return this.f4359r;
    }

    public void g(i iVar) {
        this.f4344c.a(iVar);
    }

    public CharSequence getAccessibilityClassName() {
        return this.f4361t.a() ? this.f4361t.g() : super.getAccessibilityClassName();
    }

    public RecyclerView.h getAdapter() {
        return this.f4351j.getAdapter();
    }

    public int getCurrentItem() {
        return this.f4345d;
    }

    public int getItemDecorationCount() {
        return this.f4351j.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.f4360s;
    }

    public int getOrientation() {
        return this.f4348g.x2();
    }

    /* access modifiers changed from: package-private */
    public int getPageSize() {
        int i10;
        int i11;
        RecyclerView recyclerView = this.f4351j;
        if (getOrientation() == 0) {
            i10 = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            i11 = recyclerView.getPaddingRight();
        } else {
            i10 = recyclerView.getHeight() - recyclerView.getPaddingTop();
            i11 = recyclerView.getPaddingBottom();
        }
        return i10 - i11;
    }

    public int getScrollState() {
        return this.f4353l.f();
    }

    public void h() {
        if (this.f4356o.a() != null) {
            double e10 = this.f4353l.e();
            int i10 = (int) e10;
            float f10 = (float) (e10 - ((double) i10));
            this.f4356o.onPageScrolled(i10, f10, Math.round(((float) getPageSize()) * f10));
        }
    }

    public void j(int i10, boolean z10) {
        if (!c()) {
            k(i10, z10);
            return;
        }
        throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
    }

    /* access modifiers changed from: package-private */
    public void k(int i10, boolean z10) {
        RecyclerView.h adapter = getAdapter();
        if (adapter == null) {
            if (this.f4349h != -1) {
                this.f4349h = Math.max(i10, 0);
            }
        } else if (adapter.getItemCount() > 0) {
            int min = Math.min(Math.max(i10, 0), adapter.getItemCount() - 1);
            if (min != this.f4345d || !this.f4353l.h()) {
                int i11 = this.f4345d;
                if (min != i11 || !z10) {
                    double d10 = (double) i11;
                    this.f4345d = min;
                    this.f4361t.q();
                    if (!this.f4353l.h()) {
                        d10 = this.f4353l.e();
                    }
                    this.f4353l.k(min, z10);
                    if (!z10) {
                        this.f4351j.k1(min);
                        return;
                    }
                    double d11 = (double) min;
                    if (Math.abs(d11 - d10) > 3.0d) {
                        this.f4351j.k1(d11 > d10 ? min - 3 : min + 3);
                        RecyclerView recyclerView = this.f4351j;
                        recyclerView.post(new n(min, recyclerView));
                        return;
                    }
                    this.f4351j.s1(min);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void n() {
        t tVar = this.f4352k;
        if (tVar != null) {
            View f10 = tVar.f(this.f4348g);
            if (f10 != null) {
                int r02 = this.f4348g.r0(f10);
                if (r02 != this.f4345d && getScrollState() == 0) {
                    this.f4354m.onPageSelected(r02);
                }
                this.f4346e = false;
                return;
            }
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.f4361t.i(accessibilityNodeInfo);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int measuredWidth = this.f4351j.getMeasuredWidth();
        int measuredHeight = this.f4351j.getMeasuredHeight();
        this.f4342a.left = getPaddingLeft();
        this.f4342a.right = (i12 - i10) - getPaddingRight();
        this.f4342a.top = getPaddingTop();
        this.f4342a.bottom = (i13 - i11) - getPaddingBottom();
        Gravity.apply(8388659, measuredWidth, measuredHeight, this.f4342a, this.f4343b);
        RecyclerView recyclerView = this.f4351j;
        Rect rect = this.f4343b;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.f4346e) {
            n();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        measureChild(this.f4351j, i10, i11);
        int measuredWidth = this.f4351j.getMeasuredWidth();
        int measuredHeight = this.f4351j.getMeasuredHeight();
        int measuredState = this.f4351j.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(ViewGroup.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i10, measuredState), ViewGroup.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i11, measuredState << 16));
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f4349h = savedState.f4363b;
        this.f4350i = savedState.f4364c;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f4362a = this.f4351j.getId();
        int i10 = this.f4349h;
        if (i10 == -1) {
            i10 = this.f4345d;
        }
        savedState.f4363b = i10;
        Parcelable parcelable = this.f4350i;
        if (parcelable == null) {
            RecyclerView.h adapter = this.f4351j.getAdapter();
            if (adapter instanceof androidx.viewpager2.adapter.a) {
                parcelable = ((androidx.viewpager2.adapter.a) adapter).a();
            }
            return savedState;
        }
        savedState.f4364c = parcelable;
        return savedState;
    }

    public void onViewAdded(View view) {
        throw new IllegalStateException(ViewPager2.class.getSimpleName() + " does not support direct child views");
    }

    public boolean performAccessibilityAction(int i10, Bundle bundle) {
        return this.f4361t.c(i10, bundle) ? this.f4361t.l(i10, bundle) : super.performAccessibilityAction(i10, bundle);
    }

    public void setAdapter(RecyclerView.h hVar) {
        RecyclerView.h adapter = this.f4351j.getAdapter();
        this.f4361t.f(adapter);
        m(adapter);
        this.f4351j.setAdapter(hVar);
        this.f4345d = 0;
        i();
        this.f4361t.e(hVar);
        f(hVar);
    }

    public void setCurrentItem(int i10) {
        j(i10, true);
    }

    public void setLayoutDirection(int i10) {
        super.setLayoutDirection(i10);
        this.f4361t.p();
    }

    public void setOffscreenPageLimit(int i10) {
        if (i10 >= 1 || i10 == -1) {
            this.f4360s = i10;
            this.f4351j.requestLayout();
            return;
        }
        throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
    }

    public void setOrientation(int i10) {
        this.f4348g.L2(i10);
        this.f4361t.r();
    }

    public void setPageTransformer(k kVar) {
        boolean z10 = this.f4358q;
        if (kVar != null) {
            if (!z10) {
                this.f4357p = this.f4351j.getItemAnimator();
                this.f4358q = true;
            }
            this.f4351j.setItemAnimator((RecyclerView.m) null);
        } else if (z10) {
            this.f4351j.setItemAnimator(this.f4357p);
            this.f4357p = null;
            this.f4358q = false;
        }
        if (kVar != this.f4356o.a()) {
            this.f4356o.b(kVar);
            h();
        }
    }

    public void setUserInputEnabled(boolean z10) {
        this.f4359r = z10;
        this.f4361t.s();
    }
}
