package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.core.view.x;
import j.j;
import java.lang.reflect.Method;

public class ListPopupWindow implements p.e {
    private static Method F;
    private static Method G;
    private static Method H;
    final Handler A;
    private final Rect B;
    private Rect C;
    private boolean D;
    PopupWindow E;

    /* renamed from: a  reason: collision with root package name */
    private Context f863a;

    /* renamed from: b  reason: collision with root package name */
    private ListAdapter f864b;

    /* renamed from: c  reason: collision with root package name */
    r f865c;

    /* renamed from: d  reason: collision with root package name */
    private int f866d;

    /* renamed from: e  reason: collision with root package name */
    private int f867e;

    /* renamed from: f  reason: collision with root package name */
    private int f868f;

    /* renamed from: g  reason: collision with root package name */
    private int f869g;

    /* renamed from: h  reason: collision with root package name */
    private int f870h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f871i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f872j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f873k;

    /* renamed from: l  reason: collision with root package name */
    private int f874l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f875m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f876n;

    /* renamed from: o  reason: collision with root package name */
    int f877o;

    /* renamed from: p  reason: collision with root package name */
    private View f878p;

    /* renamed from: q  reason: collision with root package name */
    private int f879q;

    /* renamed from: r  reason: collision with root package name */
    private DataSetObserver f880r;

    /* renamed from: s  reason: collision with root package name */
    private View f881s;

    /* renamed from: t  reason: collision with root package name */
    private Drawable f882t;

    /* renamed from: u  reason: collision with root package name */
    private AdapterView.OnItemClickListener f883u;

    /* renamed from: v  reason: collision with root package name */
    private AdapterView.OnItemSelectedListener f884v;

    /* renamed from: w  reason: collision with root package name */
    final g f885w;

    /* renamed from: x  reason: collision with root package name */
    private final f f886x;

    /* renamed from: y  reason: collision with root package name */
    private final e f887y;

    /* renamed from: z  reason: collision with root package name */
    private final c f888z;

    class a implements Runnable {
        a() {
        }

        public void run() {
            View t10 = ListPopupWindow.this.t();
            if (t10 != null && t10.getWindowToken() != null) {
                ListPopupWindow.this.b();
            }
        }
    }

    class b implements AdapterView.OnItemSelectedListener {
        b() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
            r rVar;
            if (i10 != -1 && (rVar = ListPopupWindow.this.f865c) != null) {
                rVar.setListSelectionHidden(false);
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    private class c implements Runnable {
        c() {
        }

        public void run() {
            ListPopupWindow.this.r();
        }
    }

    private class d extends DataSetObserver {
        d() {
        }

        public void onChanged() {
            if (ListPopupWindow.this.d()) {
                ListPopupWindow.this.b();
            }
        }

        public void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    private class e implements AbsListView.OnScrollListener {
        e() {
        }

        public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i10) {
            if (i10 == 1 && !ListPopupWindow.this.A() && ListPopupWindow.this.E.getContentView() != null) {
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                listPopupWindow.A.removeCallbacks(listPopupWindow.f885w);
                ListPopupWindow.this.f885w.run();
            }
        }
    }

    private class f implements View.OnTouchListener {
        f() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x10 = (int) motionEvent.getX();
            int y10 = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = ListPopupWindow.this.E) != null && popupWindow.isShowing() && x10 >= 0 && x10 < ListPopupWindow.this.E.getWidth() && y10 >= 0 && y10 < ListPopupWindow.this.E.getHeight()) {
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                listPopupWindow.A.postDelayed(listPopupWindow.f885w, 250);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                ListPopupWindow listPopupWindow2 = ListPopupWindow.this;
                listPopupWindow2.A.removeCallbacks(listPopupWindow2.f885w);
                return false;
            }
        }
    }

    private class g implements Runnable {
        g() {
        }

        public void run() {
            r rVar = ListPopupWindow.this.f865c;
            if (rVar != null && x.U(rVar) && ListPopupWindow.this.f865c.getCount() > ListPopupWindow.this.f865c.getChildCount()) {
                int childCount = ListPopupWindow.this.f865c.getChildCount();
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                if (childCount <= listPopupWindow.f877o) {
                    listPopupWindow.E.setInputMethodMode(2);
                    ListPopupWindow.this.b();
                }
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            Class<PopupWindow> cls = PopupWindow.class;
            try {
                F = cls.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                H = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            Class<PopupWindow> cls2 = PopupWindow.class;
            try {
                G = cls2.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public ListPopupWindow(Context context) {
        this(context, (AttributeSet) null, j.a.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, j.a.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.f866d = -2;
        this.f867e = -2;
        this.f870h = 1002;
        this.f874l = 0;
        this.f875m = false;
        this.f876n = false;
        this.f877o = Integer.MAX_VALUE;
        this.f879q = 0;
        this.f885w = new g();
        this.f886x = new f();
        this.f887y = new e();
        this.f888z = new c();
        this.B = new Rect();
        this.f863a = context;
        this.A = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ListPopupWindow, i10, i11);
        this.f868f = obtainStyledAttributes.getDimensionPixelOffset(j.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(j.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.f869g = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f871i = true;
        }
        obtainStyledAttributes.recycle();
        AppCompatPopupWindow appCompatPopupWindow = new AppCompatPopupWindow(context, attributeSet, i10, i11);
        this.E = appCompatPopupWindow;
        appCompatPopupWindow.setInputMethodMode(1);
    }

    private void C() {
        View view = this.f878p;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f878p);
            }
        }
    }

    private void N(boolean z10) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = F;
            if (method != null) {
                try {
                    method.invoke(this.E, new Object[]{Boolean.valueOf(z10)});
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            this.E.setIsClippedToScreen(z10);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v23, resolved type: androidx.appcompat.widget.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: androidx.appcompat.widget.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: android.widget.LinearLayout} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v29, resolved type: androidx.appcompat.widget.r} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x014e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int q() {
        /*
            r12 = this;
            androidx.appcompat.widget.r r0 = r12.f865c
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = -1
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L_0x00bc
            android.content.Context r0 = r12.f863a
            androidx.appcompat.widget.ListPopupWindow$a r5 = new androidx.appcompat.widget.ListPopupWindow$a
            r5.<init>()
            boolean r5 = r12.D
            r5 = r5 ^ r3
            androidx.appcompat.widget.r r5 = r12.s(r0, r5)
            r12.f865c = r5
            android.graphics.drawable.Drawable r6 = r12.f882t
            if (r6 == 0) goto L_0x0020
            r5.setSelector(r6)
        L_0x0020:
            androidx.appcompat.widget.r r5 = r12.f865c
            android.widget.ListAdapter r6 = r12.f864b
            r5.setAdapter(r6)
            androidx.appcompat.widget.r r5 = r12.f865c
            android.widget.AdapterView$OnItemClickListener r6 = r12.f883u
            r5.setOnItemClickListener(r6)
            androidx.appcompat.widget.r r5 = r12.f865c
            r5.setFocusable(r3)
            androidx.appcompat.widget.r r5 = r12.f865c
            r5.setFocusableInTouchMode(r3)
            androidx.appcompat.widget.r r5 = r12.f865c
            androidx.appcompat.widget.ListPopupWindow$b r6 = new androidx.appcompat.widget.ListPopupWindow$b
            r6.<init>()
            r5.setOnItemSelectedListener(r6)
            androidx.appcompat.widget.r r5 = r12.f865c
            androidx.appcompat.widget.ListPopupWindow$e r6 = r12.f887y
            r5.setOnScrollListener(r6)
            android.widget.AdapterView$OnItemSelectedListener r5 = r12.f884v
            if (r5 == 0) goto L_0x0052
            androidx.appcompat.widget.r r6 = r12.f865c
            r6.setOnItemSelectedListener(r5)
        L_0x0052:
            androidx.appcompat.widget.r r5 = r12.f865c
            android.view.View r6 = r12.f878p
            if (r6 == 0) goto L_0x00b5
            android.widget.LinearLayout r7 = new android.widget.LinearLayout
            r7.<init>(r0)
            r7.setOrientation(r3)
            android.widget.LinearLayout$LayoutParams r0 = new android.widget.LinearLayout$LayoutParams
            r8 = 1065353216(0x3f800000, float:1.0)
            r0.<init>(r2, r4, r8)
            int r8 = r12.f879q
            if (r8 == 0) goto L_0x008d
            if (r8 == r3) goto L_0x0086
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "Invalid hint position "
            r0.append(r5)
            int r5 = r12.f879q
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            java.lang.String r5 = "ListPopupWindow"
            android.util.Log.e(r5, r0)
            goto L_0x0093
        L_0x0086:
            r7.addView(r5, r0)
            r7.addView(r6)
            goto L_0x0093
        L_0x008d:
            r7.addView(r6)
            r7.addView(r5, r0)
        L_0x0093:
            int r0 = r12.f867e
            if (r0 < 0) goto L_0x0099
            r5 = r1
            goto L_0x009b
        L_0x0099:
            r0 = r4
            r5 = r0
        L_0x009b:
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r5)
            r6.measure(r0, r4)
            android.view.ViewGroup$LayoutParams r0 = r6.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            int r5 = r6.getMeasuredHeight()
            int r6 = r0.topMargin
            int r5 = r5 + r6
            int r0 = r0.bottomMargin
            int r5 = r5 + r0
            r0 = r5
            r5 = r7
            goto L_0x00b6
        L_0x00b5:
            r0 = r4
        L_0x00b6:
            android.widget.PopupWindow r6 = r12.E
            r6.setContentView(r5)
            goto L_0x00da
        L_0x00bc:
            android.widget.PopupWindow r0 = r12.E
            android.view.View r0 = r0.getContentView()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            android.view.View r0 = r12.f878p
            if (r0 == 0) goto L_0x00d9
            android.view.ViewGroup$LayoutParams r5 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r5 = (android.widget.LinearLayout.LayoutParams) r5
            int r0 = r0.getMeasuredHeight()
            int r6 = r5.topMargin
            int r0 = r0 + r6
            int r5 = r5.bottomMargin
            int r0 = r0 + r5
            goto L_0x00da
        L_0x00d9:
            r0 = r4
        L_0x00da:
            android.widget.PopupWindow r5 = r12.E
            android.graphics.drawable.Drawable r5 = r5.getBackground()
            if (r5 == 0) goto L_0x00f6
            android.graphics.Rect r6 = r12.B
            r5.getPadding(r6)
            android.graphics.Rect r5 = r12.B
            int r6 = r5.top
            int r5 = r5.bottom
            int r5 = r5 + r6
            boolean r7 = r12.f871i
            if (r7 != 0) goto L_0x00fc
            int r6 = -r6
            r12.f869g = r6
            goto L_0x00fc
        L_0x00f6:
            android.graphics.Rect r5 = r12.B
            r5.setEmpty()
            r5 = r4
        L_0x00fc:
            android.widget.PopupWindow r6 = r12.E
            int r6 = r6.getInputMethodMode()
            r7 = 2
            if (r6 != r7) goto L_0x0106
            goto L_0x0107
        L_0x0106:
            r3 = r4
        L_0x0107:
            android.view.View r4 = r12.t()
            int r6 = r12.f869g
            int r3 = r12.u(r4, r6, r3)
            boolean r4 = r12.f875m
            if (r4 != 0) goto L_0x015f
            int r4 = r12.f866d
            if (r4 != r2) goto L_0x011a
            goto L_0x015f
        L_0x011a:
            int r4 = r12.f867e
            r6 = -2
            if (r4 == r6) goto L_0x0128
            r1 = 1073741824(0x40000000, float:2.0)
            if (r4 == r2) goto L_0x0128
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r1)
            goto L_0x0140
        L_0x0128:
            android.content.Context r2 = r12.f863a
            android.content.res.Resources r2 = r2.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            android.graphics.Rect r4 = r12.B
            int r6 = r4.left
            int r4 = r4.right
            int r6 = r6 + r4
            int r2 = r2 - r6
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r1)
        L_0x0140:
            r7 = r1
            androidx.appcompat.widget.r r6 = r12.f865c
            r8 = 0
            r9 = -1
            int r10 = r3 - r0
            r11 = -1
            int r1 = r6.d(r7, r8, r9, r10, r11)
            if (r1 <= 0) goto L_0x015d
            androidx.appcompat.widget.r r2 = r12.f865c
            int r2 = r2.getPaddingTop()
            androidx.appcompat.widget.r r3 = r12.f865c
            int r3 = r3.getPaddingBottom()
            int r2 = r2 + r3
            int r5 = r5 + r2
            int r0 = r0 + r5
        L_0x015d:
            int r1 = r1 + r0
            return r1
        L_0x015f:
            int r3 = r3 + r5
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ListPopupWindow.q():int");
    }

    private int u(View view, int i10, boolean z10) {
        if (Build.VERSION.SDK_INT > 23) {
            return this.E.getMaxAvailableHeight(view, i10, z10);
        }
        Method method = G;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.E, new Object[]{view, Integer.valueOf(i10), Boolean.valueOf(z10)})).intValue();
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.E.getMaxAvailableHeight(view, i10);
    }

    public boolean A() {
        return this.E.getInputMethodMode() == 2;
    }

    public boolean B() {
        return this.D;
    }

    public void D(View view) {
        this.f881s = view;
    }

    public void E(int i10) {
        this.E.setAnimationStyle(i10);
    }

    public void F(int i10) {
        Drawable background = this.E.getBackground();
        if (background != null) {
            background.getPadding(this.B);
            Rect rect = this.B;
            this.f867e = rect.left + rect.right + i10;
            return;
        }
        Q(i10);
    }

    public void G(int i10) {
        this.f874l = i10;
    }

    public void H(Rect rect) {
        this.C = rect != null ? new Rect(rect) : null;
    }

    public void I(int i10) {
        this.E.setInputMethodMode(i10);
    }

    public void J(boolean z10) {
        this.D = z10;
        this.E.setFocusable(z10);
    }

    public void K(PopupWindow.OnDismissListener onDismissListener) {
        this.E.setOnDismissListener(onDismissListener);
    }

    public void L(AdapterView.OnItemClickListener onItemClickListener) {
        this.f883u = onItemClickListener;
    }

    public void M(boolean z10) {
        this.f873k = true;
        this.f872j = z10;
    }

    public void O(int i10) {
        this.f879q = i10;
    }

    public void P(int i10) {
        r rVar = this.f865c;
        if (d() && rVar != null) {
            rVar.setListSelectionHidden(false);
            rVar.setSelection(i10);
            if (rVar.getChoiceMode() != 0) {
                rVar.setItemChecked(i10, true);
            }
        }
    }

    public void Q(int i10) {
        this.f867e = i10;
    }

    public void b() {
        int q10 = q();
        boolean A2 = A();
        androidx.core.widget.j.b(this.E, this.f870h);
        boolean z10 = true;
        if (!this.E.isShowing()) {
            int i10 = this.f867e;
            if (i10 == -1) {
                i10 = -1;
            } else if (i10 == -2) {
                i10 = t().getWidth();
            }
            int i11 = this.f866d;
            if (i11 == -1) {
                q10 = -1;
            } else if (i11 != -2) {
                q10 = i11;
            }
            this.E.setWidth(i10);
            this.E.setHeight(q10);
            N(true);
            this.E.setOutsideTouchable(!this.f876n && !this.f875m);
            this.E.setTouchInterceptor(this.f886x);
            if (this.f873k) {
                androidx.core.widget.j.a(this.E, this.f872j);
            }
            if (Build.VERSION.SDK_INT <= 28) {
                Method method = H;
                if (method != null) {
                    try {
                        method.invoke(this.E, new Object[]{this.C});
                    } catch (Exception e10) {
                        Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e10);
                    }
                }
            } else {
                this.E.setEpicenterBounds(this.C);
            }
            androidx.core.widget.j.c(this.E, t(), this.f868f, this.f869g, this.f874l);
            this.f865c.setSelection(-1);
            if (!this.D || this.f865c.isInTouchMode()) {
                r();
            }
            if (!this.D) {
                this.A.post(this.f888z);
            }
        } else if (x.U(t())) {
            int i12 = this.f867e;
            if (i12 == -1) {
                i12 = -1;
            } else if (i12 == -2) {
                i12 = t().getWidth();
            }
            int i13 = this.f866d;
            if (i13 == -1) {
                if (!A2) {
                    q10 = -1;
                }
                if (A2) {
                    this.E.setWidth(this.f867e == -1 ? -1 : 0);
                    this.E.setHeight(0);
                } else {
                    this.E.setWidth(this.f867e == -1 ? -1 : 0);
                    this.E.setHeight(-1);
                }
            } else if (i13 != -2) {
                q10 = i13;
            }
            PopupWindow popupWindow = this.E;
            if (this.f876n || this.f875m) {
                z10 = false;
            }
            popupWindow.setOutsideTouchable(z10);
            this.E.update(t(), this.f868f, this.f869g, i12 < 0 ? -1 : i12, q10 < 0 ? -1 : q10);
        }
    }

    public void c(Drawable drawable) {
        this.E.setBackgroundDrawable(drawable);
    }

    public boolean d() {
        return this.E.isShowing();
    }

    public void dismiss() {
        this.E.dismiss();
        C();
        this.E.setContentView((View) null);
        this.f865c = null;
        this.A.removeCallbacks(this.f885w);
    }

    public int e() {
        return this.f868f;
    }

    public Drawable g() {
        return this.E.getBackground();
    }

    public ListView h() {
        return this.f865c;
    }

    public void j(int i10) {
        this.f869g = i10;
        this.f871i = true;
    }

    public void l(int i10) {
        this.f868f = i10;
    }

    public int n() {
        if (!this.f871i) {
            return 0;
        }
        return this.f869g;
    }

    public void p(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f880r;
        if (dataSetObserver == null) {
            this.f880r = new d();
        } else {
            ListAdapter listAdapter2 = this.f864b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f864b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f880r);
        }
        r rVar = this.f865c;
        if (rVar != null) {
            rVar.setAdapter(this.f864b);
        }
    }

    public void r() {
        r rVar = this.f865c;
        if (rVar != null) {
            rVar.setListSelectionHidden(true);
            rVar.requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public r s(Context context, boolean z10) {
        return new r(context, z10);
    }

    public View t() {
        return this.f881s;
    }

    public Object v() {
        if (!d()) {
            return null;
        }
        return this.f865c.getSelectedItem();
    }

    public long w() {
        if (!d()) {
            return Long.MIN_VALUE;
        }
        return this.f865c.getSelectedItemId();
    }

    public int x() {
        if (!d()) {
            return -1;
        }
        return this.f865c.getSelectedItemPosition();
    }

    public View y() {
        if (!d()) {
            return null;
        }
        return this.f865c.getSelectedView();
    }

    public int z() {
        return this.f867e;
    }
}
