package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.b;
import java.util.ArrayList;

class ActionMenuPresenter extends androidx.appcompat.view.menu.a implements b.a {
    private b A;
    final f B = new f();
    int C;

    /* renamed from: j  reason: collision with root package name */
    d f709j;

    /* renamed from: k  reason: collision with root package name */
    private Drawable f710k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f711l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f712m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f713n;

    /* renamed from: o  reason: collision with root package name */
    private int f714o;

    /* renamed from: p  reason: collision with root package name */
    private int f715p;

    /* renamed from: q  reason: collision with root package name */
    private int f716q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f717r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f718s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f719t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f720u;

    /* renamed from: v  reason: collision with root package name */
    private int f721v;

    /* renamed from: w  reason: collision with root package name */
    private final SparseBooleanArray f722w = new SparseBooleanArray();

    /* renamed from: x  reason: collision with root package name */
    e f723x;

    /* renamed from: y  reason: collision with root package name */
    a f724y;

    /* renamed from: z  reason: collision with root package name */
    c f725z;

    @SuppressLint({"BanParcelableUsage"})
    private static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public int f726a;

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

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f726a = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f726a);
        }
    }

    private class a extends i {
        public a(Context context, m mVar, View view) {
            super(context, mVar, view, false, j.a.actionOverflowMenuStyle);
            if (!((g) mVar.getItem()).l()) {
                View view2 = ActionMenuPresenter.this.f709j;
                f(view2 == null ? (View) ActionMenuPresenter.this.f508h : view2);
            }
            j(ActionMenuPresenter.this.B);
        }

        /* access modifiers changed from: protected */
        public void e() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.f724y = null;
            actionMenuPresenter.C = 0;
            super.e();
        }
    }

    private class b extends ActionMenuItemView.b {
        b() {
        }

        public p.e a() {
            a aVar = ActionMenuPresenter.this.f724y;
            if (aVar != null) {
                return aVar.c();
            }
            return null;
        }
    }

    private class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private e f729a;

        public c(e eVar) {
            this.f729a = eVar;
        }

        public void run() {
            if (ActionMenuPresenter.this.f503c != null) {
                ActionMenuPresenter.this.f503c.d();
            }
            View view = (View) ActionMenuPresenter.this.f508h;
            if (!(view == null || view.getWindowToken() == null || !this.f729a.m())) {
                ActionMenuPresenter.this.f723x = this.f729a;
            }
            ActionMenuPresenter.this.f725z = null;
        }
    }

    private class d extends AppCompatImageView implements ActionMenuView.a {

        class a extends t {
            a(View view, ActionMenuPresenter actionMenuPresenter) {
                super(view);
            }

            public p.e b() {
                e eVar = ActionMenuPresenter.this.f723x;
                if (eVar == null) {
                    return null;
                }
                return eVar.c();
            }

            public boolean c() {
                ActionMenuPresenter.this.O();
                return true;
            }

            public boolean d() {
                ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
                if (actionMenuPresenter.f725z != null) {
                    return false;
                }
                actionMenuPresenter.F();
                return true;
            }
        }

        public d(Context context) {
            super(context, (AttributeSet) null, j.a.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            i0.a(this, getContentDescription());
            setOnTouchListener(new a(this, ActionMenuPresenter.this));
        }

        public boolean e() {
            return false;
        }

        public boolean f() {
            return false;
        }

        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.O();
            return true;
        }

        /* access modifiers changed from: protected */
        public boolean setFrame(int i10, int i11, int i12, int i13) {
            boolean frame = super.setFrame(i10, i11, i12, i13);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                p0.a.l(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    private class e extends i {
        public e(Context context, androidx.appcompat.view.menu.e eVar, View view, boolean z10) {
            super(context, eVar, view, z10, j.a.actionOverflowMenuStyle);
            h(8388613);
            j(ActionMenuPresenter.this.B);
        }

        /* access modifiers changed from: protected */
        public void e() {
            if (ActionMenuPresenter.this.f503c != null) {
                ActionMenuPresenter.this.f503c.close();
            }
            ActionMenuPresenter.this.f723x = null;
            super.e();
        }
    }

    private class f implements j.a {
        f() {
        }

        public void c(androidx.appcompat.view.menu.e eVar, boolean z10) {
            if (eVar instanceof m) {
                eVar.F().e(false);
            }
            j.a q10 = ActionMenuPresenter.this.q();
            if (q10 != null) {
                q10.c(eVar, z10);
            }
        }

        public boolean d(androidx.appcompat.view.menu.e eVar) {
            if (eVar == ActionMenuPresenter.this.f503c) {
                return false;
            }
            ActionMenuPresenter.this.C = ((m) eVar).getItem().getItemId();
            j.a q10 = ActionMenuPresenter.this.q();
            if (q10 != null) {
                return q10.d(eVar);
            }
            return false;
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, j.g.abc_action_menu_layout, j.g.abc_action_menu_item_layout);
    }

    private View D(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f508h;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if ((childAt instanceof k.a) && ((k.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public boolean C() {
        return F() | G();
    }

    public Drawable E() {
        d dVar = this.f709j;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.f711l) {
            return this.f710k;
        }
        return null;
    }

    public boolean F() {
        k kVar;
        c cVar = this.f725z;
        if (cVar == null || (kVar = this.f508h) == null) {
            e eVar = this.f723x;
            if (eVar == null) {
                return false;
            }
            eVar.b();
            return true;
        }
        ((View) kVar).removeCallbacks(cVar);
        this.f725z = null;
        return true;
    }

    public boolean G() {
        a aVar = this.f724y;
        if (aVar == null) {
            return false;
        }
        aVar.b();
        return true;
    }

    public boolean H() {
        return this.f725z != null || I();
    }

    public boolean I() {
        e eVar = this.f723x;
        return eVar != null && eVar.d();
    }

    public void J(Configuration configuration) {
        if (!this.f717r) {
            this.f716q = o.a.b(this.f502b).d();
        }
        androidx.appcompat.view.menu.e eVar = this.f503c;
        if (eVar != null) {
            eVar.M(true);
        }
    }

    public void K(boolean z10) {
        this.f720u = z10;
    }

    public void L(ActionMenuView actionMenuView) {
        this.f508h = actionMenuView;
        actionMenuView.b(this.f503c);
    }

    public void M(Drawable drawable) {
        d dVar = this.f709j;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
            return;
        }
        this.f711l = true;
        this.f710k = drawable;
    }

    public void N(boolean z10) {
        this.f712m = z10;
        this.f713n = true;
    }

    public boolean O() {
        androidx.appcompat.view.menu.e eVar;
        if (!this.f712m || I() || (eVar = this.f503c) == null || this.f508h == null || this.f725z != null || eVar.B().isEmpty()) {
            return false;
        }
        c cVar = new c(new e(this.f502b, this.f503c, this.f709j, true));
        this.f725z = cVar;
        ((View) this.f508h).post(cVar);
        return true;
    }

    public void b(boolean z10) {
        if (z10) {
            super.g((m) null);
            return;
        }
        androidx.appcompat.view.menu.e eVar = this.f503c;
        if (eVar != null) {
            eVar.e(false);
        }
    }

    public void c(androidx.appcompat.view.menu.e eVar, boolean z10) {
        C();
        super.c(eVar, z10);
    }

    public void e(Context context, androidx.appcompat.view.menu.e eVar) {
        super.e(context, eVar);
        Resources resources = context.getResources();
        o.a b10 = o.a.b(context);
        if (!this.f713n) {
            this.f712m = b10.h();
        }
        if (!this.f719t) {
            this.f714o = b10.c();
        }
        if (!this.f717r) {
            this.f716q = b10.d();
        }
        int i10 = this.f714o;
        if (this.f712m) {
            if (this.f709j == null) {
                d dVar = new d(this.f501a);
                this.f709j = dVar;
                if (this.f711l) {
                    dVar.setImageDrawable(this.f710k);
                    this.f710k = null;
                    this.f711l = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f709j.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i10 -= this.f709j.getMeasuredWidth();
        } else {
            this.f709j = null;
        }
        this.f715p = i10;
        this.f721v = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    public void f(Parcelable parcelable) {
        int i10;
        MenuItem findItem;
        if ((parcelable instanceof SavedState) && (i10 = ((SavedState) parcelable).f726a) > 0 && (findItem = this.f503c.findItem(i10)) != null) {
            g((m) findItem.getSubMenu());
        }
    }

    public boolean g(m mVar) {
        boolean z10 = false;
        if (!mVar.hasVisibleItems()) {
            return false;
        }
        m mVar2 = mVar;
        while (mVar2.i0() != this.f503c) {
            mVar2 = (m) mVar2.i0();
        }
        View D = D(mVar2.getItem());
        if (D == null) {
            return false;
        }
        this.C = mVar.getItem().getItemId();
        int size = mVar.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                break;
            }
            MenuItem item = mVar.getItem(i10);
            if (item.isVisible() && item.getIcon() != null) {
                z10 = true;
                break;
            }
            i10++;
        }
        a aVar = new a(this.f502b, mVar, D);
        this.f724y = aVar;
        aVar.g(z10);
        this.f724y.k();
        super.g(mVar);
        return true;
    }

    public void h(g gVar, k.a aVar) {
        aVar.g(gVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f508h);
        if (this.A == null) {
            this.A = new b();
        }
        actionMenuItemView.setPopupCallback(this.A);
    }

    public void i(boolean z10) {
        k kVar;
        super.i(z10);
        ((View) this.f508h).requestLayout();
        androidx.appcompat.view.menu.e eVar = this.f503c;
        boolean z11 = false;
        if (eVar != null) {
            ArrayList<g> u10 = eVar.u();
            int size = u10.size();
            for (int i10 = 0; i10 < size; i10++) {
                androidx.core.view.b b10 = u10.get(i10).b();
                if (b10 != null) {
                    b10.i(this);
                }
            }
        }
        androidx.appcompat.view.menu.e eVar2 = this.f503c;
        ArrayList<g> B2 = eVar2 != null ? eVar2.B() : null;
        if (this.f712m && B2 != null) {
            int size2 = B2.size();
            if (size2 == 1) {
                z11 = !B2.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z11 = true;
            }
        }
        d dVar = this.f709j;
        if (z11) {
            if (dVar == null) {
                this.f709j = new d(this.f501a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f709j.getParent();
            if (viewGroup != this.f508h) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f709j);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f508h;
                actionMenuView.addView(this.f709j, actionMenuView.F());
            }
        } else if (dVar != null && dVar.getParent() == (kVar = this.f508h)) {
            ((ViewGroup) kVar).removeView(this.f709j);
        }
        ((ActionMenuView) this.f508h).setOverflowReserved(this.f712m);
    }

    public boolean j() {
        int i10;
        ArrayList<g> arrayList;
        int i11;
        int i12;
        int i13;
        boolean z10;
        ActionMenuPresenter actionMenuPresenter = this;
        androidx.appcompat.view.menu.e eVar = actionMenuPresenter.f503c;
        View view = null;
        boolean z11 = false;
        if (eVar != null) {
            arrayList = eVar.G();
            i10 = arrayList.size();
        } else {
            arrayList = null;
            i10 = 0;
        }
        int i14 = actionMenuPresenter.f716q;
        int i15 = actionMenuPresenter.f715p;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.f508h;
        boolean z12 = false;
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < i10; i18++) {
            g gVar = arrayList.get(i18);
            if (gVar.o()) {
                i16++;
            } else if (gVar.n()) {
                i17++;
            } else {
                z12 = true;
            }
            if (actionMenuPresenter.f720u && gVar.isActionViewExpanded()) {
                i14 = 0;
            }
        }
        if (actionMenuPresenter.f712m && (z12 || i17 + i16 > i14)) {
            i14--;
        }
        int i19 = i14 - i16;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.f722w;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.f718s) {
            int i20 = actionMenuPresenter.f721v;
            i11 = i15 / i20;
            i12 = i20 + ((i15 % i20) / i11);
        } else {
            i12 = 0;
            i11 = 0;
        }
        int i21 = 0;
        int i22 = 0;
        while (i21 < i10) {
            g gVar2 = arrayList.get(i21);
            if (gVar2.o()) {
                View r10 = actionMenuPresenter.r(gVar2, view, viewGroup);
                if (actionMenuPresenter.f718s) {
                    i11 -= ActionMenuView.L(r10, i12, i11, makeMeasureSpec, z11 ? 1 : 0);
                } else {
                    r10.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = r10.getMeasuredWidth();
                i15 -= measuredWidth;
                if (i22 == 0) {
                    i22 = measuredWidth;
                }
                int groupId = gVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                gVar2.u(true);
                z10 = z11;
                i13 = i10;
            } else if (gVar2.n()) {
                int groupId2 = gVar2.getGroupId();
                boolean z13 = sparseBooleanArray.get(groupId2);
                boolean z14 = (i19 > 0 || z13) && i15 > 0 && (!actionMenuPresenter.f718s || i11 > 0);
                boolean z15 = z14;
                i13 = i10;
                if (z14) {
                    View r11 = actionMenuPresenter.r(gVar2, (View) null, viewGroup);
                    if (actionMenuPresenter.f718s) {
                        int L = ActionMenuView.L(r11, i12, i11, makeMeasureSpec, 0);
                        i11 -= L;
                        if (L == 0) {
                            z15 = false;
                        }
                    } else {
                        r11.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    boolean z16 = z15;
                    int measuredWidth2 = r11.getMeasuredWidth();
                    i15 -= measuredWidth2;
                    if (i22 == 0) {
                        i22 = measuredWidth2;
                    }
                    z14 = z16 & (!actionMenuPresenter.f718s ? i15 + i22 > 0 : i15 >= 0);
                }
                if (z14 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z13) {
                    sparseBooleanArray.put(groupId2, false);
                    int i23 = 0;
                    while (i23 < i21) {
                        g gVar3 = arrayList.get(i23);
                        if (gVar3.getGroupId() == groupId2) {
                            if (gVar3.l()) {
                                i19++;
                            }
                            gVar3.u(false);
                        }
                        i23++;
                    }
                }
                if (z14) {
                    i19--;
                }
                gVar2.u(z14);
                z10 = false;
            } else {
                z10 = z11;
                i13 = i10;
                gVar2.u(z10);
            }
            i21++;
            z11 = z10;
            i10 = i13;
            view = null;
            actionMenuPresenter = this;
        }
        return true;
    }

    public Parcelable k() {
        SavedState savedState = new SavedState();
        savedState.f726a = this.C;
        return savedState;
    }

    public boolean p(ViewGroup viewGroup, int i10) {
        if (viewGroup.getChildAt(i10) == this.f709j) {
            return false;
        }
        return super.p(viewGroup, i10);
    }

    public View r(g gVar, View view, ViewGroup viewGroup) {
        View actionView = gVar.getActionView();
        if (actionView == null || gVar.j()) {
            actionView = super.r(gVar, view, viewGroup);
        }
        actionView.setVisibility(gVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.o(layoutParams));
        }
        return actionView;
    }

    public k s(ViewGroup viewGroup) {
        k kVar = this.f508h;
        k s10 = super.s(viewGroup);
        if (kVar != s10) {
            ((ActionMenuView) s10).setPresenter(this);
        }
        return s10;
    }

    public boolean u(int i10, g gVar) {
        return gVar.l();
    }
}
