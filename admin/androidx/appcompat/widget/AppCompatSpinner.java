package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.app.b;
import androidx.core.view.w;
import androidx.core.view.x;

public class AppCompatSpinner extends Spinner implements w {

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f805i = {16843505};

    /* renamed from: a  reason: collision with root package name */
    private final d f806a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f807b;

    /* renamed from: c  reason: collision with root package name */
    private t f808c;

    /* renamed from: d  reason: collision with root package name */
    private SpinnerAdapter f809d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f810e;

    /* renamed from: f  reason: collision with root package name */
    private f f811f;

    /* renamed from: g  reason: collision with root package name */
    int f812g;

    /* renamed from: h  reason: collision with root package name */
    final Rect f813h;

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        boolean f814a;

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

        SavedState(Parcel parcel) {
            super(parcel);
            this.f814a = parcel.readByte() != 0;
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeByte(this.f814a ? (byte) 1 : 0);
        }
    }

    class a extends t {

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ e f815j;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(View view, e eVar) {
            super(view);
            this.f815j = eVar;
        }

        public p.e b() {
            return this.f815j;
        }

        @SuppressLint({"SyntheticAccessor"})
        public boolean c() {
            if (AppCompatSpinner.this.getInternalPopup().d()) {
                return true;
            }
            AppCompatSpinner.this.b();
            return true;
        }
    }

    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        public void onGlobalLayout() {
            if (!AppCompatSpinner.this.getInternalPopup().d()) {
                AppCompatSpinner.this.b();
            }
            ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
            if (viewTreeObserver == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 16) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            } else {
                viewTreeObserver.removeGlobalOnLayoutListener(this);
            }
        }
    }

    class c implements f, DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        androidx.appcompat.app.b f818a;

        /* renamed from: b  reason: collision with root package name */
        private ListAdapter f819b;

        /* renamed from: c  reason: collision with root package name */
        private CharSequence f820c;

        c() {
        }

        public void c(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        public boolean d() {
            androidx.appcompat.app.b bVar = this.f818a;
            if (bVar != null) {
                return bVar.isShowing();
            }
            return false;
        }

        public void dismiss() {
            androidx.appcompat.app.b bVar = this.f818a;
            if (bVar != null) {
                bVar.dismiss();
                this.f818a = null;
            }
        }

        public int e() {
            return 0;
        }

        public Drawable g() {
            return null;
        }

        public void i(CharSequence charSequence) {
            this.f820c = charSequence;
        }

        public void j(int i10) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        public void k(int i10) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        public void l(int i10) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        public void m(int i10, int i11) {
            if (this.f819b != null) {
                b.a aVar = new b.a(AppCompatSpinner.this.getPopupContext());
                CharSequence charSequence = this.f820c;
                if (charSequence != null) {
                    aVar.m(charSequence);
                }
                androidx.appcompat.app.b a10 = aVar.l(this.f819b, AppCompatSpinner.this.getSelectedItemPosition(), this).a();
                this.f818a = a10;
                ListView e10 = a10.e();
                if (Build.VERSION.SDK_INT >= 17) {
                    e10.setTextDirection(i10);
                    e10.setTextAlignment(i11);
                }
                this.f818a.show();
            }
        }

        public int n() {
            return 0;
        }

        public CharSequence o() {
            return this.f820c;
        }

        public void onClick(DialogInterface dialogInterface, int i10) {
            AppCompatSpinner.this.setSelection(i10);
            if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                AppCompatSpinner.this.performItemClick((View) null, i10, this.f819b.getItemId(i10));
            }
            dismiss();
        }

        public void p(ListAdapter listAdapter) {
            this.f819b = listAdapter;
        }
    }

    private static class d implements ListAdapter, SpinnerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private SpinnerAdapter f822a;

        /* renamed from: b  reason: collision with root package name */
        private ListAdapter f823b;

        public d(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f822a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f823b = (ListAdapter) spinnerAdapter;
            }
            if (theme == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            } else if (spinnerAdapter instanceof c0) {
                c0 c0Var = (c0) spinnerAdapter;
                if (c0Var.getDropDownViewTheme() == null) {
                    c0Var.setDropDownViewTheme(theme);
                }
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f823b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f822a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        public View getDropDownView(int i10, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f822a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i10, view, viewGroup);
        }

        public Object getItem(int i10) {
            SpinnerAdapter spinnerAdapter = this.f822a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i10);
        }

        public long getItemId(int i10) {
            SpinnerAdapter spinnerAdapter = this.f822a;
            if (spinnerAdapter == null) {
                return -1;
            }
            return spinnerAdapter.getItemId(i10);
        }

        public int getItemViewType(int i10) {
            return 0;
        }

        public View getView(int i10, View view, ViewGroup viewGroup) {
            return getDropDownView(i10, view, viewGroup);
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f822a;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }

        public boolean isEnabled(int i10) {
            ListAdapter listAdapter = this.f823b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i10);
            }
            return true;
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f822a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f822a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    class e extends ListPopupWindow implements f {
        private CharSequence I;
        ListAdapter J;
        private final Rect K = new Rect();
        private int L;

        class a implements AdapterView.OnItemClickListener {
            a(AppCompatSpinner appCompatSpinner) {
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
                AppCompatSpinner.this.setSelection(i10);
                if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                    e eVar = e.this;
                    AppCompatSpinner.this.performItemClick(view, i10, eVar.J.getItemId(i10));
                }
                e.this.dismiss();
            }
        }

        class b implements ViewTreeObserver.OnGlobalLayoutListener {
            b() {
            }

            public void onGlobalLayout() {
                e eVar = e.this;
                if (!eVar.U(AppCompatSpinner.this)) {
                    e.this.dismiss();
                    return;
                }
                e.this.S();
                e.super.b();
            }
        }

        class c implements PopupWindow.OnDismissListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f826a;

            c(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.f826a = onGlobalLayoutListener;
            }

            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f826a);
                }
            }
        }

        public e(Context context, AttributeSet attributeSet, int i10) {
            super(context, attributeSet, i10);
            D(AppCompatSpinner.this);
            J(true);
            O(0);
            L(new a(AppCompatSpinner.this));
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x008d  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x009a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void S() {
            /*
                r8 = this;
                android.graphics.drawable.Drawable r0 = r8.g()
                r1 = 0
                if (r0 == 0) goto L_0x0026
                androidx.appcompat.widget.AppCompatSpinner r1 = androidx.appcompat.widget.AppCompatSpinner.this
                android.graphics.Rect r1 = r1.f813h
                r0.getPadding(r1)
                androidx.appcompat.widget.AppCompatSpinner r0 = androidx.appcompat.widget.AppCompatSpinner.this
                boolean r0 = androidx.appcompat.widget.m0.b(r0)
                if (r0 == 0) goto L_0x001d
                androidx.appcompat.widget.AppCompatSpinner r0 = androidx.appcompat.widget.AppCompatSpinner.this
                android.graphics.Rect r0 = r0.f813h
                int r0 = r0.right
                goto L_0x0024
            L_0x001d:
                androidx.appcompat.widget.AppCompatSpinner r0 = androidx.appcompat.widget.AppCompatSpinner.this
                android.graphics.Rect r0 = r0.f813h
                int r0 = r0.left
                int r0 = -r0
            L_0x0024:
                r1 = r0
                goto L_0x002e
            L_0x0026:
                androidx.appcompat.widget.AppCompatSpinner r0 = androidx.appcompat.widget.AppCompatSpinner.this
                android.graphics.Rect r0 = r0.f813h
                r0.right = r1
                r0.left = r1
            L_0x002e:
                androidx.appcompat.widget.AppCompatSpinner r0 = androidx.appcompat.widget.AppCompatSpinner.this
                int r0 = r0.getPaddingLeft()
                androidx.appcompat.widget.AppCompatSpinner r2 = androidx.appcompat.widget.AppCompatSpinner.this
                int r2 = r2.getPaddingRight()
                androidx.appcompat.widget.AppCompatSpinner r3 = androidx.appcompat.widget.AppCompatSpinner.this
                int r3 = r3.getWidth()
                androidx.appcompat.widget.AppCompatSpinner r4 = androidx.appcompat.widget.AppCompatSpinner.this
                int r5 = r4.f812g
                r6 = -2
                if (r5 != r6) goto L_0x0078
                android.widget.ListAdapter r5 = r8.J
                android.widget.SpinnerAdapter r5 = (android.widget.SpinnerAdapter) r5
                android.graphics.drawable.Drawable r6 = r8.g()
                int r4 = r4.a(r5, r6)
                androidx.appcompat.widget.AppCompatSpinner r5 = androidx.appcompat.widget.AppCompatSpinner.this
                android.content.Context r5 = r5.getContext()
                android.content.res.Resources r5 = r5.getResources()
                android.util.DisplayMetrics r5 = r5.getDisplayMetrics()
                int r5 = r5.widthPixels
                androidx.appcompat.widget.AppCompatSpinner r6 = androidx.appcompat.widget.AppCompatSpinner.this
                android.graphics.Rect r6 = r6.f813h
                int r7 = r6.left
                int r5 = r5 - r7
                int r6 = r6.right
                int r5 = r5 - r6
                if (r4 <= r5) goto L_0x0070
                r4 = r5
            L_0x0070:
                int r5 = r3 - r0
                int r5 = r5 - r2
                int r4 = java.lang.Math.max(r4, r5)
                goto L_0x007e
            L_0x0078:
                r4 = -1
                if (r5 != r4) goto L_0x0082
                int r4 = r3 - r0
                int r4 = r4 - r2
            L_0x007e:
                r8.F(r4)
                goto L_0x0085
            L_0x0082:
                r8.F(r5)
            L_0x0085:
                androidx.appcompat.widget.AppCompatSpinner r4 = androidx.appcompat.widget.AppCompatSpinner.this
                boolean r4 = androidx.appcompat.widget.m0.b(r4)
                if (r4 == 0) goto L_0x009a
                int r3 = r3 - r2
                int r0 = r8.z()
                int r3 = r3 - r0
                int r0 = r8.T()
                int r3 = r3 - r0
                int r1 = r1 + r3
                goto L_0x00a0
            L_0x009a:
                int r2 = r8.T()
                int r0 = r0 + r2
                int r1 = r1 + r0
            L_0x00a0:
                r8.l(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatSpinner.e.S():void");
        }

        public int T() {
            return this.L;
        }

        /* access modifiers changed from: package-private */
        public boolean U(View view) {
            return x.U(view) && view.getGlobalVisibleRect(this.K);
        }

        public void i(CharSequence charSequence) {
            this.I = charSequence;
        }

        public void k(int i10) {
            this.L = i10;
        }

        public void m(int i10, int i11) {
            ViewTreeObserver viewTreeObserver;
            boolean d10 = d();
            S();
            I(2);
            super.b();
            ListView h10 = h();
            h10.setChoiceMode(1);
            if (Build.VERSION.SDK_INT >= 17) {
                h10.setTextDirection(i10);
                h10.setTextAlignment(i11);
            }
            P(AppCompatSpinner.this.getSelectedItemPosition());
            if (!d10 && (viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver()) != null) {
                b bVar = new b();
                viewTreeObserver.addOnGlobalLayoutListener(bVar);
                K(new c(bVar));
            }
        }

        public CharSequence o() {
            return this.I;
        }

        public void p(ListAdapter listAdapter) {
            super.p(listAdapter);
            this.J = listAdapter;
        }
    }

    interface f {
        void c(Drawable drawable);

        boolean d();

        void dismiss();

        int e();

        Drawable g();

        void i(CharSequence charSequence);

        void j(int i10);

        void k(int i10);

        void l(int i10);

        void m(int i10, int i11);

        int n();

        CharSequence o();

        void p(ListAdapter listAdapter);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, j.a.spinnerStyle);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, -1);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i10, int i11) {
        this(context, attributeSet, i10, i11, (Resources.Theme) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005e, code lost:
        if (r11 != null) goto L_0x004d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x003d A[SYNTHETIC, Splitter:B:10:0x003d] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AppCompatSpinner(android.content.Context r7, android.util.AttributeSet r8, int r9, int r10, android.content.res.Resources.Theme r11) {
        /*
            r6 = this;
            r6.<init>(r7, r8, r9)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r6.f813h = r0
            android.content.Context r0 = r6.getContext()
            androidx.appcompat.widget.b0.a(r6, r0)
            int[] r0 = j.j.Spinner
            r1 = 0
            androidx.appcompat.widget.g0 r0 = androidx.appcompat.widget.g0.v(r7, r8, r0, r9, r1)
            androidx.appcompat.widget.d r2 = new androidx.appcompat.widget.d
            r2.<init>(r6)
            r6.f806a = r2
            if (r11 == 0) goto L_0x0029
            o.d r2 = new o.d
            r2.<init>((android.content.Context) r7, (android.content.res.Resources.Theme) r11)
        L_0x0026:
            r6.f807b = r2
            goto L_0x0039
        L_0x0029:
            int r11 = j.j.Spinner_popupTheme
            int r11 = r0.n(r11, r1)
            if (r11 == 0) goto L_0x0037
            o.d r2 = new o.d
            r2.<init>((android.content.Context) r7, (int) r11)
            goto L_0x0026
        L_0x0037:
            r6.f807b = r7
        L_0x0039:
            r11 = -1
            r2 = 0
            if (r10 != r11) goto L_0x0069
            int[] r11 = f805i     // Catch:{ Exception -> 0x0055, all -> 0x0053 }
            android.content.res.TypedArray r11 = r7.obtainStyledAttributes(r8, r11, r9, r1)     // Catch:{ Exception -> 0x0055, all -> 0x0053 }
            boolean r3 = r11.hasValue(r1)     // Catch:{ Exception -> 0x0051 }
            if (r3 == 0) goto L_0x004d
            int r10 = r11.getInt(r1, r1)     // Catch:{ Exception -> 0x0051 }
        L_0x004d:
            r11.recycle()
            goto L_0x0069
        L_0x0051:
            r3 = move-exception
            goto L_0x0057
        L_0x0053:
            r7 = move-exception
            goto L_0x0063
        L_0x0055:
            r3 = move-exception
            r11 = r2
        L_0x0057:
            java.lang.String r4 = "AppCompatSpinner"
            java.lang.String r5 = "Could not read android:spinnerMode"
            android.util.Log.i(r4, r5, r3)     // Catch:{ all -> 0x0061 }
            if (r11 == 0) goto L_0x0069
            goto L_0x004d
        L_0x0061:
            r7 = move-exception
            r2 = r11
        L_0x0063:
            if (r2 == 0) goto L_0x0068
            r2.recycle()
        L_0x0068:
            throw r7
        L_0x0069:
            r11 = 1
            if (r10 == 0) goto L_0x00a6
            if (r10 == r11) goto L_0x006f
            goto L_0x00b6
        L_0x006f:
            androidx.appcompat.widget.AppCompatSpinner$e r10 = new androidx.appcompat.widget.AppCompatSpinner$e
            android.content.Context r3 = r6.f807b
            r10.<init>(r3, r8, r9)
            android.content.Context r3 = r6.f807b
            int[] r4 = j.j.Spinner
            androidx.appcompat.widget.g0 r1 = androidx.appcompat.widget.g0.v(r3, r8, r4, r9, r1)
            int r3 = j.j.Spinner_android_dropDownWidth
            r4 = -2
            int r3 = r1.m(r3, r4)
            r6.f812g = r3
            int r3 = j.j.Spinner_android_popupBackground
            android.graphics.drawable.Drawable r3 = r1.g(r3)
            r10.c(r3)
            int r3 = j.j.Spinner_android_prompt
            java.lang.String r3 = r0.o(r3)
            r10.i(r3)
            r1.w()
            r6.f811f = r10
            androidx.appcompat.widget.AppCompatSpinner$a r1 = new androidx.appcompat.widget.AppCompatSpinner$a
            r1.<init>(r6, r10)
            r6.f808c = r1
            goto L_0x00b6
        L_0x00a6:
            androidx.appcompat.widget.AppCompatSpinner$c r10 = new androidx.appcompat.widget.AppCompatSpinner$c
            r10.<init>()
            r6.f811f = r10
            int r1 = j.j.Spinner_android_prompt
            java.lang.String r1 = r0.o(r1)
            r10.i(r1)
        L_0x00b6:
            int r10 = j.j.Spinner_android_entries
            java.lang.CharSequence[] r10 = r0.q(r10)
            if (r10 == 0) goto L_0x00ce
            android.widget.ArrayAdapter r1 = new android.widget.ArrayAdapter
            r3 = 17367048(0x1090008, float:2.5162948E-38)
            r1.<init>(r7, r3, r10)
            int r7 = j.g.support_simple_spinner_dropdown_item
            r1.setDropDownViewResource(r7)
            r6.setAdapter((android.widget.SpinnerAdapter) r1)
        L_0x00ce:
            r0.w()
            r6.f810e = r11
            android.widget.SpinnerAdapter r7 = r6.f809d
            if (r7 == 0) goto L_0x00dc
            r6.setAdapter((android.widget.SpinnerAdapter) r7)
            r6.f809d = r2
        L_0x00dc:
            androidx.appcompat.widget.d r7 = r6.f806a
            r7.e(r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }

    /* access modifiers changed from: package-private */
    public int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i10 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i11 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i10) {
                view = null;
                i10 = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i11 = Math.max(i11, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i11;
        }
        drawable.getPadding(this.f813h);
        Rect rect = this.f813h;
        return i11 + rect.left + rect.right;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.f811f.m(getTextDirection(), getTextAlignment());
        } else {
            this.f811f.m(-1, -1);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f806a;
        if (dVar != null) {
            dVar.b();
        }
    }

    public int getDropDownHorizontalOffset() {
        f fVar = this.f811f;
        if (fVar != null) {
            return fVar.e();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    public int getDropDownVerticalOffset() {
        f fVar = this.f811f;
        if (fVar != null) {
            return fVar.n();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    public int getDropDownWidth() {
        if (this.f811f != null) {
            return this.f812g;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final f getInternalPopup() {
        return this.f811f;
    }

    public Drawable getPopupBackground() {
        f fVar = this.f811f;
        if (fVar != null) {
            return fVar.g();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    public Context getPopupContext() {
        return this.f807b;
    }

    public CharSequence getPrompt() {
        f fVar = this.f811f;
        return fVar != null ? fVar.o() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f806a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f806a;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f fVar = this.f811f;
        if (fVar != null && fVar.d()) {
            this.f811f.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f811f != null && View.MeasureSpec.getMode(i10) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i10)), getMeasuredHeight());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f814a && (viewTreeObserver = getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new b());
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        f fVar = this.f811f;
        savedState.f814a = fVar != null && fVar.d();
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        t tVar = this.f808c;
        if (tVar == null || !tVar.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public boolean performClick() {
        f fVar = this.f811f;
        if (fVar == null) {
            return super.performClick();
        }
        if (fVar.d()) {
            return true;
        }
        b();
        return true;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f810e) {
            this.f809d = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f811f != null) {
            Context context = this.f807b;
            if (context == null) {
                context = getContext();
            }
            this.f811f.p(new d(spinnerAdapter, context.getTheme()));
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f806a;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        d dVar = this.f806a;
        if (dVar != null) {
            dVar.g(i10);
        }
    }

    public void setDropDownHorizontalOffset(int i10) {
        f fVar = this.f811f;
        if (fVar != null) {
            fVar.k(i10);
            this.f811f.l(i10);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i10);
        }
    }

    public void setDropDownVerticalOffset(int i10) {
        f fVar = this.f811f;
        if (fVar != null) {
            fVar.j(i10);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i10);
        }
    }

    public void setDropDownWidth(int i10) {
        if (this.f811f != null) {
            this.f812g = i10;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i10);
        }
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        f fVar = this.f811f;
        if (fVar != null) {
            fVar.c(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i10) {
        setPopupBackgroundDrawable(k.a.d(getPopupContext(), i10));
    }

    public void setPrompt(CharSequence charSequence) {
        f fVar = this.f811f;
        if (fVar != null) {
            fVar.i(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f806a;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f806a;
        if (dVar != null) {
            dVar.j(mode);
        }
    }
}
