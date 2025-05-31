package androidx.appcompat.widget;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.x;
import j.h;
import j.j;

public class ActivityChooserView extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    final f f753a;

    /* renamed from: b  reason: collision with root package name */
    private final g f754b;

    /* renamed from: c  reason: collision with root package name */
    private final View f755c;

    /* renamed from: d  reason: collision with root package name */
    private final Drawable f756d;

    /* renamed from: e  reason: collision with root package name */
    final FrameLayout f757e;

    /* renamed from: f  reason: collision with root package name */
    private final ImageView f758f;

    /* renamed from: g  reason: collision with root package name */
    final FrameLayout f759g;

    /* renamed from: h  reason: collision with root package name */
    private final ImageView f760h;

    /* renamed from: i  reason: collision with root package name */
    private final int f761i;

    /* renamed from: j  reason: collision with root package name */
    androidx.core.view.b f762j;

    /* renamed from: k  reason: collision with root package name */
    final DataSetObserver f763k;

    /* renamed from: l  reason: collision with root package name */
    private final ViewTreeObserver.OnGlobalLayoutListener f764l;

    /* renamed from: m  reason: collision with root package name */
    private ListPopupWindow f765m;

    /* renamed from: n  reason: collision with root package name */
    PopupWindow.OnDismissListener f766n;

    /* renamed from: o  reason: collision with root package name */
    boolean f767o;

    /* renamed from: p  reason: collision with root package name */
    int f768p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f769q;

    /* renamed from: r  reason: collision with root package name */
    private int f770r;

    public static class InnerLayout extends LinearLayout {

        /* renamed from: a  reason: collision with root package name */
        private static final int[] f771a = {16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            g0 u10 = g0.u(context, attributeSet, f771a);
            setBackgroundDrawable(u10.g(0));
            u10.w();
        }
    }

    class a extends DataSetObserver {
        a() {
        }

        public void onChanged() {
            super.onChanged();
            ActivityChooserView.this.f753a.notifyDataSetChanged();
        }

        public void onInvalidated() {
            super.onInvalidated();
            ActivityChooserView.this.f753a.notifyDataSetInvalidated();
        }
    }

    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        public void onGlobalLayout() {
            if (!ActivityChooserView.this.b()) {
                return;
            }
            if (!ActivityChooserView.this.isShown()) {
                ActivityChooserView.this.getListPopupWindow().dismiss();
                return;
            }
            ActivityChooserView.this.getListPopupWindow().b();
            androidx.core.view.b bVar = ActivityChooserView.this.f762j;
            if (bVar != null) {
                bVar.k(true);
            }
        }
    }

    class c extends View.AccessibilityDelegate {
        c(ActivityChooserView activityChooserView) {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            x0.c.I0(accessibilityNodeInfo).Z(true);
        }
    }

    class d extends t {
        d(View view) {
            super(view);
        }

        public p.e b() {
            return ActivityChooserView.this.getListPopupWindow();
        }

        /* access modifiers changed from: protected */
        public boolean c() {
            ActivityChooserView.this.c();
            return true;
        }

        /* access modifiers changed from: protected */
        public boolean d() {
            ActivityChooserView.this.a();
            return true;
        }
    }

    class e extends DataSetObserver {
        e() {
        }

        public void onChanged() {
            super.onChanged();
            ActivityChooserView.this.e();
        }
    }

    private class f extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        private c f776a;

        /* renamed from: b  reason: collision with root package name */
        private int f777b = 4;

        /* renamed from: c  reason: collision with root package name */
        private boolean f778c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f779d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f780e;

        f() {
        }

        public int a() {
            throw null;
        }

        public c b() {
            return this.f776a;
        }

        public ResolveInfo c() {
            throw null;
        }

        public int d() {
            throw null;
        }

        public boolean e() {
            return this.f778c;
        }

        public void f(c cVar) {
            ActivityChooserView.this.f753a.b();
            notifyDataSetChanged();
        }

        public int getCount() {
            throw null;
        }

        public Object getItem(int i10) {
            int itemViewType = getItemViewType(i10);
            if (itemViewType == 0) {
                boolean z10 = this.f778c;
                throw null;
            } else if (itemViewType == 1) {
                return null;
            } else {
                throw new IllegalArgumentException();
            }
        }

        public long getItemId(int i10) {
            return (long) i10;
        }

        public int getItemViewType(int i10) {
            return (!this.f780e || i10 != getCount() - 1) ? 0 : 1;
        }

        public View getView(int i10, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i10);
            if (itemViewType == 0) {
                if (view == null || view.getId() != j.f.list_item) {
                    view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(j.g.abc_activity_chooser_view_list_item, viewGroup, false);
                }
                PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
                ResolveInfo resolveInfo = (ResolveInfo) getItem(i10);
                ((ImageView) view.findViewById(j.f.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                ((TextView) view.findViewById(j.f.title)).setText(resolveInfo.loadLabel(packageManager));
                if (!this.f778c || i10 != 0 || !this.f779d) {
                    view.setActivated(false);
                } else {
                    view.setActivated(true);
                }
                return view;
            } else if (itemViewType != 1) {
                throw new IllegalArgumentException();
            } else if (view != null && view.getId() == 1) {
                return view;
            } else {
                View inflate = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(j.g.abc_activity_chooser_view_list_item, viewGroup, false);
                inflate.setId(1);
                ((TextView) inflate.findViewById(j.f.title)).setText(ActivityChooserView.this.getContext().getString(h.abc_activity_chooser_view_see_all));
                return inflate;
            }
        }

        public int getViewTypeCount() {
            return 3;
        }
    }

    private class g implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {
        g() {
        }

        private void a() {
            PopupWindow.OnDismissListener onDismissListener = ActivityChooserView.this.f766n;
            if (onDismissListener != null) {
                onDismissListener.onDismiss();
            }
        }

        public void onClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view == activityChooserView.f759g) {
                activityChooserView.a();
                ActivityChooserView.this.f753a.c();
                ActivityChooserView.this.f753a.b();
                throw null;
            } else if (view == activityChooserView.f757e) {
                activityChooserView.f767o = false;
                activityChooserView.d(activityChooserView.f768p);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public void onDismiss() {
            a();
            androidx.core.view.b bVar = ActivityChooserView.this.f762j;
            if (bVar != null) {
                bVar.k(false);
            }
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            int itemViewType = ((f) adapterView.getAdapter()).getItemViewType(i10);
            if (itemViewType == 0) {
                ActivityChooserView.this.a();
                ActivityChooserView activityChooserView = ActivityChooserView.this;
                if (!activityChooserView.f767o) {
                    activityChooserView.f753a.e();
                    ActivityChooserView.this.f753a.b();
                    throw null;
                } else if (i10 > 0) {
                    activityChooserView.f753a.b();
                    throw null;
                }
            } else if (itemViewType == 1) {
                ActivityChooserView.this.d(Integer.MAX_VALUE);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public boolean onLongClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view == activityChooserView.f759g) {
                if (activityChooserView.f753a.getCount() > 0) {
                    ActivityChooserView activityChooserView2 = ActivityChooserView.this;
                    activityChooserView2.f767o = true;
                    activityChooserView2.d(activityChooserView2.f768p);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f763k = new a();
        this.f764l = new b();
        this.f768p = 4;
        int[] iArr = j.ActivityChooserView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i10, 0);
        x.p0(this, context, iArr, attributeSet, obtainStyledAttributes, i10, 0);
        this.f768p = obtainStyledAttributes.getInt(j.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(j.ActivityChooserView_expandActivityOverflowButtonDrawable);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(j.g.abc_activity_chooser_view, this, true);
        g gVar = new g();
        this.f754b = gVar;
        View findViewById = findViewById(j.f.activity_chooser_view_content);
        this.f755c = findViewById;
        this.f756d = findViewById.getBackground();
        FrameLayout frameLayout = (FrameLayout) findViewById(j.f.default_activity_button);
        this.f759g = frameLayout;
        frameLayout.setOnClickListener(gVar);
        frameLayout.setOnLongClickListener(gVar);
        int i11 = j.f.image;
        this.f760h = (ImageView) frameLayout.findViewById(i11);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(j.f.expand_activities_button);
        frameLayout2.setOnClickListener(gVar);
        frameLayout2.setAccessibilityDelegate(new c(this));
        frameLayout2.setOnTouchListener(new d(frameLayout2));
        this.f757e = frameLayout2;
        ImageView imageView = (ImageView) frameLayout2.findViewById(i11);
        this.f758f = imageView;
        imageView.setImageDrawable(drawable);
        f fVar = new f();
        this.f753a = fVar;
        fVar.registerDataSetObserver(new e());
        Resources resources = context.getResources();
        this.f761i = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(j.d.abc_config_prefDialogWidth));
    }

    public boolean a() {
        if (!b()) {
            return true;
        }
        getListPopupWindow().dismiss();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.f764l);
        return true;
    }

    public boolean b() {
        return getListPopupWindow().d();
    }

    public boolean c() {
        if (b() || !this.f769q) {
            return false;
        }
        this.f767o = false;
        d(this.f768p);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void d(int i10) {
        this.f753a.b();
        throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }

    /* access modifiers changed from: package-private */
    public void e() {
        Drawable drawable;
        View view;
        if (this.f753a.getCount() > 0) {
            this.f757e.setEnabled(true);
        } else {
            this.f757e.setEnabled(false);
        }
        int a10 = this.f753a.a();
        int d10 = this.f753a.d();
        if (a10 == 1 || (a10 > 1 && d10 > 0)) {
            this.f759g.setVisibility(0);
            ResolveInfo c10 = this.f753a.c();
            PackageManager packageManager = getContext().getPackageManager();
            this.f760h.setImageDrawable(c10.loadIcon(packageManager));
            if (this.f770r != 0) {
                CharSequence loadLabel = c10.loadLabel(packageManager);
                this.f759g.setContentDescription(getContext().getString(this.f770r, new Object[]{loadLabel}));
            }
        } else {
            this.f759g.setVisibility(8);
        }
        if (this.f759g.getVisibility() == 0) {
            view = this.f755c;
            drawable = this.f756d;
        } else {
            view = this.f755c;
            drawable = null;
        }
        view.setBackgroundDrawable(drawable);
    }

    public c getDataModel() {
        return this.f753a.b();
    }

    /* access modifiers changed from: package-private */
    public ListPopupWindow getListPopupWindow() {
        if (this.f765m == null) {
            ListPopupWindow listPopupWindow = new ListPopupWindow(getContext());
            this.f765m = listPopupWindow;
            listPopupWindow.p(this.f753a);
            this.f765m.D(this);
            this.f765m.J(true);
            this.f765m.L(this.f754b);
            this.f765m.K(this.f754b);
        }
        return this.f765m;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f753a.b();
        this.f769q = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f753a.b();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f764l);
        }
        if (b()) {
            a();
        }
        this.f769q = false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        this.f755c.layout(0, 0, i12 - i10, i13 - i11);
        if (!b()) {
            a();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        View view = this.f755c;
        if (this.f759g.getVisibility() != 0) {
            i11 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i11), 1073741824);
        }
        measureChild(view, i10, i11);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setActivityChooserModel(c cVar) {
        this.f753a.f(cVar);
        if (b()) {
            a();
            c();
        }
    }

    public void setDefaultActionButtonContentDescription(int i10) {
        this.f770r = i10;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i10) {
        this.f758f.setContentDescription(getContext().getString(i10));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f758f.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i10) {
        this.f768p = i10;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f766n = onDismissListener;
    }

    public void setProvider(androidx.core.view.b bVar) {
        this.f762j = bVar;
    }
}
