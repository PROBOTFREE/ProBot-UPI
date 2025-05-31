package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.x;
import androidx.customview.view.AbsSavedState;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import net.sourceforge.zbar.Config;
import net.sqlcipher.database.SQLiteDatabase;

public class SearchView extends LinearLayoutCompat implements o.c {

    /* renamed from: m1  reason: collision with root package name */
    static final n f896m1 = (Build.VERSION.SDK_INT < 29 ? new n() : null);
    private Rect A;
    private int[] B;
    private int[] C;
    private final ImageView D;
    private final Drawable E;
    private final int F;
    private final int G;
    private final Intent H;
    private final Intent I;
    private final CharSequence J;
    private l K;
    private k L;
    View.OnFocusChangeListener M;
    private m N;
    private View.OnClickListener O;
    private boolean P;
    private boolean Q;
    z0.a R;
    private boolean S;
    private CharSequence T;
    private boolean U;
    private boolean V;
    private int W;
    private boolean Z0;

    /* renamed from: a0  reason: collision with root package name */
    private boolean f897a0;

    /* renamed from: a1  reason: collision with root package name */
    private int f898a1;

    /* renamed from: b0  reason: collision with root package name */
    private CharSequence f899b0;

    /* renamed from: b1  reason: collision with root package name */
    SearchableInfo f900b1;

    /* renamed from: c0  reason: collision with root package name */
    private CharSequence f901c0;

    /* renamed from: c1  reason: collision with root package name */
    private Bundle f902c1;

    /* renamed from: d1  reason: collision with root package name */
    private final Runnable f903d1;

    /* renamed from: e1  reason: collision with root package name */
    private Runnable f904e1;

    /* renamed from: f1  reason: collision with root package name */
    private final WeakHashMap<String, Drawable.ConstantState> f905f1;

    /* renamed from: g1  reason: collision with root package name */
    private final View.OnClickListener f906g1;

    /* renamed from: h1  reason: collision with root package name */
    View.OnKeyListener f907h1;

    /* renamed from: i1  reason: collision with root package name */
    private final TextView.OnEditorActionListener f908i1;

    /* renamed from: j1  reason: collision with root package name */
    private final AdapterView.OnItemClickListener f909j1;

    /* renamed from: k1  reason: collision with root package name */
    private final AdapterView.OnItemSelectedListener f910k1;

    /* renamed from: l1  reason: collision with root package name */
    private TextWatcher f911l1;

    /* renamed from: p  reason: collision with root package name */
    final SearchAutoComplete f912p;

    /* renamed from: q  reason: collision with root package name */
    private final View f913q;

    /* renamed from: r  reason: collision with root package name */
    private final View f914r;

    /* renamed from: s  reason: collision with root package name */
    private final View f915s;

    /* renamed from: t  reason: collision with root package name */
    final ImageView f916t;

    /* renamed from: u  reason: collision with root package name */
    final ImageView f917u;

    /* renamed from: v  reason: collision with root package name */
    final ImageView f918v;

    /* renamed from: w  reason: collision with root package name */
    final ImageView f919w;

    /* renamed from: x  reason: collision with root package name */
    private final View f920x;

    /* renamed from: y  reason: collision with root package name */
    private o f921y;

    /* renamed from: z  reason: collision with root package name */
    private Rect f922z;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        boolean f923c;

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
            this.f923c = ((Boolean) parcel.readValue((ClassLoader) null)).booleanValue();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f923c + "}";
        }

        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeValue(Boolean.valueOf(this.f923c));
        }
    }

    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {

        /* renamed from: d  reason: collision with root package name */
        private int f924d;

        /* renamed from: e  reason: collision with root package name */
        private SearchView f925e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f926f;

        /* renamed from: g  reason: collision with root package name */
        final Runnable f927g;

        class a implements Runnable {
            a() {
            }

            public void run() {
                SearchAutoComplete.this.c();
            }
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, j.a.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i10) {
            super(context, attributeSet, i10);
            this.f927g = new a();
            this.f924d = getThreshold();
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i10 = configuration.screenWidthDp;
            int i11 = configuration.screenHeightDp;
            if (i10 >= 960 && i11 >= 720 && configuration.orientation == 2) {
                return Config.X_DENSITY;
            }
            if (i10 < 600) {
                return (i10 < 640 || i11 < 480) ? 160 : 192;
            }
            return 192;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (Build.VERSION.SDK_INT >= 29) {
                setInputMethodMode(1);
                if (enoughToFilter()) {
                    showDropDown();
                    return;
                }
                return;
            }
            SearchView.f896m1.c(this);
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            if (this.f926f) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f926f = false;
            }
        }

        public boolean enoughToFilter() {
            return this.f924d <= 0 || super.enoughToFilter();
        }

        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f926f) {
                removeCallbacks(this.f927g);
                post(this.f927g);
            }
            return onCreateInputConnection;
        }

        /* access modifiers changed from: protected */
        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, (float) getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        /* access modifiers changed from: protected */
        public void onFocusChanged(boolean z10, int i10, Rect rect) {
            super.onFocusChanged(z10, i10, rect);
            this.f925e.Z();
        }

        public boolean onKeyPreIme(int i10, KeyEvent keyEvent) {
            if (i10 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f925e.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i10, keyEvent);
        }

        public void onWindowFocusChanged(boolean z10) {
            super.onWindowFocusChanged(z10);
            if (z10 && this.f925e.hasFocus() && getVisibility() == 0) {
                this.f926f = true;
                if (SearchView.M(getContext())) {
                    a();
                }
            }
        }

        public void performCompletion() {
        }

        /* access modifiers changed from: protected */
        public void replaceText(CharSequence charSequence) {
        }

        /* access modifiers changed from: package-private */
        public void setImeVisibility(boolean z10) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z10) {
                this.f926f = false;
                removeCallbacks(this.f927g);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this)) {
                this.f926f = false;
                removeCallbacks(this.f927g);
                inputMethodManager.showSoftInput(this, 0);
            } else {
                this.f926f = true;
            }
        }

        /* access modifiers changed from: package-private */
        public void setSearchView(SearchView searchView) {
            this.f925e = searchView;
        }

        public void setThreshold(int i10) {
            super.setThreshold(i10);
            this.f924d = i10;
        }
    }

    class a implements TextWatcher {
        a() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            SearchView.this.Y(charSequence);
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            SearchView.this.f0();
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            z0.a aVar = SearchView.this.R;
            if (aVar instanceof a0) {
                aVar.a((Cursor) null);
            }
        }
    }

    class d implements View.OnFocusChangeListener {
        d() {
        }

        public void onFocusChange(View view, boolean z10) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.M;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z10);
            }
        }
    }

    class e implements View.OnLayoutChangeListener {
        e() {
        }

        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            SearchView.this.B();
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        public void onClick(View view) {
            SearchView searchView = SearchView.this;
            if (view == searchView.f916t) {
                searchView.V();
            } else if (view == searchView.f918v) {
                searchView.R();
            } else if (view == searchView.f917u) {
                searchView.W();
            } else if (view == searchView.f919w) {
                searchView.a0();
            } else if (view == searchView.f912p) {
                searchView.H();
            }
        }
    }

    class g implements View.OnKeyListener {
        g() {
        }

        public boolean onKey(View view, int i10, KeyEvent keyEvent) {
            SearchView searchView = SearchView.this;
            if (searchView.f900b1 == null) {
                return false;
            }
            if (searchView.f912p.isPopupShowing() && SearchView.this.f912p.getListSelection() != -1) {
                return SearchView.this.X(view, i10, keyEvent);
            }
            if (SearchView.this.f912p.b() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i10 != 66) {
                return false;
            }
            view.cancelLongPress();
            SearchView searchView2 = SearchView.this;
            searchView2.P(0, (String) null, searchView2.f912p.getText().toString());
            return true;
        }
    }

    class h implements TextView.OnEditorActionListener {
        h() {
        }

        public boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
            SearchView.this.W();
            return true;
        }
    }

    class i implements AdapterView.OnItemClickListener {
        i() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            SearchView.this.S(i10, 0, (String) null);
        }
    }

    class j implements AdapterView.OnItemSelectedListener {
        j() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
            SearchView.this.T(i10);
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public interface k {
        boolean a();
    }

    public interface l {
        boolean a(String str);

        boolean b(String str);
    }

    public interface m {
        boolean a(int i10);

        boolean b(int i10);
    }

    private static class n {

        /* renamed from: a  reason: collision with root package name */
        private Method f939a = null;

        /* renamed from: b  reason: collision with root package name */
        private Method f940b = null;

        /* renamed from: c  reason: collision with root package name */
        private Method f941c = null;

        @SuppressLint({"DiscouragedPrivateApi", "SoonBlockedPrivateApi"})
        n() {
            d();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f939a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f940b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            Class<AutoCompleteTextView> cls = AutoCompleteTextView.class;
            try {
                Method method = cls.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
                this.f941c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        private static void d() {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }

        /* access modifiers changed from: package-private */
        public void a(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f940b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f939a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void c(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f941c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[]{Boolean.TRUE});
                } catch (Exception unused) {
                }
            }
        }
    }

    private static class o extends TouchDelegate {

        /* renamed from: a  reason: collision with root package name */
        private final View f942a;

        /* renamed from: b  reason: collision with root package name */
        private final Rect f943b = new Rect();

        /* renamed from: c  reason: collision with root package name */
        private final Rect f944c = new Rect();

        /* renamed from: d  reason: collision with root package name */
        private final Rect f945d = new Rect();

        /* renamed from: e  reason: collision with root package name */
        private final int f946e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f947f;

        public o(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f946e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            a(rect, rect2);
            this.f942a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.f943b.set(rect);
            this.f945d.set(rect);
            Rect rect3 = this.f945d;
            int i10 = this.f946e;
            rect3.inset(-i10, -i10);
            this.f944c.set(rect2);
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0043  */
        /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouchEvent(android.view.MotionEvent r9) {
            /*
                r8 = this;
                float r0 = r9.getX()
                int r0 = (int) r0
                float r1 = r9.getY()
                int r1 = (int) r1
                int r2 = r9.getAction()
                r3 = 2
                r4 = 1
                r5 = 0
                if (r2 == 0) goto L_0x0033
                if (r2 == r4) goto L_0x0020
                if (r2 == r3) goto L_0x0020
                r6 = 3
                if (r2 == r6) goto L_0x001b
                goto L_0x003f
            L_0x001b:
                boolean r2 = r8.f947f
                r8.f947f = r5
                goto L_0x002f
            L_0x0020:
                boolean r2 = r8.f947f
                if (r2 == 0) goto L_0x002f
                android.graphics.Rect r6 = r8.f945d
                boolean r6 = r6.contains(r0, r1)
                if (r6 != 0) goto L_0x002f
                r4 = r2
                r2 = r5
                goto L_0x0041
            L_0x002f:
                r7 = r4
                r4 = r2
                r2 = r7
                goto L_0x0041
            L_0x0033:
                android.graphics.Rect r2 = r8.f943b
                boolean r2 = r2.contains(r0, r1)
                if (r2 == 0) goto L_0x003f
                r8.f947f = r4
                r2 = r4
                goto L_0x0041
            L_0x003f:
                r2 = r4
                r4 = r5
            L_0x0041:
                if (r4 == 0) goto L_0x0070
                if (r2 == 0) goto L_0x005d
                android.graphics.Rect r2 = r8.f944c
                boolean r2 = r2.contains(r0, r1)
                if (r2 != 0) goto L_0x005d
                android.view.View r0 = r8.f942a
                int r0 = r0.getWidth()
                int r0 = r0 / r3
                float r0 = (float) r0
                android.view.View r1 = r8.f942a
                int r1 = r1.getHeight()
                int r1 = r1 / r3
                goto L_0x0066
            L_0x005d:
                android.graphics.Rect r2 = r8.f944c
                int r3 = r2.left
                int r0 = r0 - r3
                float r0 = (float) r0
                int r2 = r2.top
                int r1 = r1 - r2
            L_0x0066:
                float r1 = (float) r1
                r9.setLocation(r0, r1)
                android.view.View r0 = r8.f942a
                boolean r5 = r0.dispatchTouchEvent(r9)
            L_0x0070:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.o.onTouchEvent(android.view.MotionEvent):boolean");
        }
    }

    public SearchView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, j.a.searchViewStyle);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f922z = new Rect();
        this.A = new Rect();
        this.B = new int[2];
        this.C = new int[2];
        this.f903d1 = new b();
        this.f904e1 = new c();
        this.f905f1 = new WeakHashMap<>();
        f fVar = new f();
        this.f906g1 = fVar;
        this.f907h1 = new g();
        h hVar = new h();
        this.f908i1 = hVar;
        i iVar = new i();
        this.f909j1 = iVar;
        j jVar = new j();
        this.f910k1 = jVar;
        this.f911l1 = new a();
        g0 v10 = g0.v(context, attributeSet, j.j.SearchView, i10, 0);
        LayoutInflater.from(context).inflate(v10.n(j.j.SearchView_layout, j.g.abc_search_view), this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(j.f.search_src_text);
        this.f912p = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f913q = findViewById(j.f.search_edit_frame);
        View findViewById = findViewById(j.f.search_plate);
        this.f914r = findViewById;
        View findViewById2 = findViewById(j.f.submit_area);
        this.f915s = findViewById2;
        ImageView imageView = (ImageView) findViewById(j.f.search_button);
        this.f916t = imageView;
        ImageView imageView2 = (ImageView) findViewById(j.f.search_go_btn);
        this.f917u = imageView2;
        ImageView imageView3 = (ImageView) findViewById(j.f.search_close_btn);
        this.f918v = imageView3;
        ImageView imageView4 = (ImageView) findViewById(j.f.search_voice_btn);
        this.f919w = imageView4;
        ImageView imageView5 = (ImageView) findViewById(j.f.search_mag_icon);
        this.D = imageView5;
        x.u0(findViewById, v10.g(j.j.SearchView_queryBackground));
        x.u0(findViewById2, v10.g(j.j.SearchView_submitBackground));
        int i11 = j.j.SearchView_searchIcon;
        imageView.setImageDrawable(v10.g(i11));
        imageView2.setImageDrawable(v10.g(j.j.SearchView_goIcon));
        imageView3.setImageDrawable(v10.g(j.j.SearchView_closeIcon));
        imageView4.setImageDrawable(v10.g(j.j.SearchView_voiceIcon));
        imageView5.setImageDrawable(v10.g(i11));
        this.E = v10.g(j.j.SearchView_searchHintIcon);
        i0.a(imageView, getResources().getString(j.h.abc_searchview_description_search));
        this.F = v10.n(j.j.SearchView_suggestionRowLayout, j.g.abc_search_dropdown_item_icons_2line);
        this.G = v10.n(j.j.SearchView_commitIcon, 0);
        imageView.setOnClickListener(fVar);
        imageView3.setOnClickListener(fVar);
        imageView2.setOnClickListener(fVar);
        imageView4.setOnClickListener(fVar);
        searchAutoComplete.setOnClickListener(fVar);
        searchAutoComplete.addTextChangedListener(this.f911l1);
        searchAutoComplete.setOnEditorActionListener(hVar);
        searchAutoComplete.setOnItemClickListener(iVar);
        searchAutoComplete.setOnItemSelectedListener(jVar);
        searchAutoComplete.setOnKeyListener(this.f907h1);
        searchAutoComplete.setOnFocusChangeListener(new d());
        setIconifiedByDefault(v10.a(j.j.SearchView_iconifiedByDefault, true));
        int f10 = v10.f(j.j.SearchView_android_maxWidth, -1);
        if (f10 != -1) {
            setMaxWidth(f10);
        }
        this.J = v10.p(j.j.SearchView_defaultQueryHint);
        this.T = v10.p(j.j.SearchView_queryHint);
        int k10 = v10.k(j.j.SearchView_android_imeOptions, -1);
        if (k10 != -1) {
            setImeOptions(k10);
        }
        int k11 = v10.k(j.j.SearchView_android_inputType, -1);
        if (k11 != -1) {
            setInputType(k11);
        }
        setFocusable(v10.a(j.j.SearchView_android_focusable, true));
        v10.w();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.H = intent;
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.I = intent2;
        intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        View findViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.f920x = findViewById3;
        if (findViewById3 != null) {
            findViewById3.addOnLayoutChangeListener(new e());
        }
        k0(this.P);
        g0();
    }

    private Intent C(String str, Uri uri, String str2, String str3, int i10, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f901c0);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f902c1;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i10 != 0) {
            intent.putExtra("action_key", i10);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.f900b1.getSearchActivity());
        return intent;
    }

    private Intent D(Cursor cursor, int i10, String str) {
        int i11;
        String o10;
        try {
            String o11 = a0.o(cursor, "suggest_intent_action");
            if (o11 == null) {
                o11 = this.f900b1.getSuggestIntentAction();
            }
            if (o11 == null) {
                o11 = "android.intent.action.SEARCH";
            }
            String str2 = o11;
            String o12 = a0.o(cursor, "suggest_intent_data");
            if (o12 == null) {
                o12 = this.f900b1.getSuggestIntentData();
            }
            if (!(o12 == null || (o10 = a0.o(cursor, "suggest_intent_data_id")) == null)) {
                o12 = o12 + "/" + Uri.encode(o10);
            }
            return C(str2, o12 == null ? null : Uri.parse(o12), a0.o(cursor, "suggest_intent_extra_data"), a0.o(cursor, "suggest_intent_query"), i10, str);
        } catch (RuntimeException e10) {
            try {
                i11 = cursor.getPosition();
            } catch (RuntimeException unused) {
                i11 = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + i11 + " returned exception.", e10);
            return null;
        }
    }

    private Intent E(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f902c1;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        int i10 = 1;
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String str = null;
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        if (searchableInfo.getVoiceMaxResults() != 0) {
            i10 = searchableInfo.getVoiceMaxResults();
        }
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", i10);
        if (searchActivity != null) {
            str = searchActivity.flattenToShortString();
        }
        intent3.putExtra("calling_package", str);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private Intent F(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    private void G() {
        this.f912p.dismissDropDown();
    }

    private void I(View view, Rect rect) {
        view.getLocationInWindow(this.B);
        getLocationInWindow(this.C);
        int[] iArr = this.B;
        int i10 = iArr[1];
        int[] iArr2 = this.C;
        int i11 = i10 - iArr2[1];
        int i12 = iArr[0] - iArr2[0];
        rect.set(i12, i11, view.getWidth() + i12, view.getHeight() + i11);
    }

    private CharSequence J(CharSequence charSequence) {
        if (!this.P || this.E == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.f912p.getTextSize()) * 1.25d);
        this.E.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.E), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private boolean K() {
        SearchableInfo searchableInfo = this.f900b1;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.f900b1.getVoiceSearchLaunchWebSearch()) {
            intent = this.H;
        } else if (this.f900b1.getVoiceSearchLaunchRecognizer()) {
            intent = this.I;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    static boolean M(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private boolean N() {
        return (this.S || this.f897a0) && !L();
    }

    private void O(Intent intent) {
        if (intent != null) {
            try {
                getContext().startActivity(intent);
            } catch (RuntimeException e10) {
                Log.e("SearchView", "Failed launch activity: " + intent, e10);
            }
        }
    }

    private boolean Q(int i10, int i11, String str) {
        Cursor b10 = this.R.b();
        if (b10 == null || !b10.moveToPosition(i10)) {
            return false;
        }
        O(D(b10, i11, str));
        return true;
    }

    private void b0() {
        post(this.f903d1);
    }

    private void c0(int i10) {
        CharSequence c10;
        Editable text = this.f912p.getText();
        Cursor b10 = this.R.b();
        if (b10 != null) {
            if (!b10.moveToPosition(i10) || (c10 = this.R.c(b10)) == null) {
                setQuery(text);
            } else {
                setQuery(c10);
            }
        }
    }

    private void e0() {
        boolean z10 = true;
        boolean z11 = !TextUtils.isEmpty(this.f912p.getText());
        int i10 = 0;
        if (!z11 && (!this.P || this.Z0)) {
            z10 = false;
        }
        ImageView imageView = this.f918v;
        if (!z10) {
            i10 = 8;
        }
        imageView.setVisibility(i10);
        Drawable drawable = this.f918v.getDrawable();
        if (drawable != null) {
            drawable.setState(z11 ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    private void g0() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f912p;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(J(queryHint));
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(j.d.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(j.d.abc_search_view_preferred_width);
    }

    private void h0() {
        this.f912p.setThreshold(this.f900b1.getSuggestThreshold());
        this.f912p.setImeOptions(this.f900b1.getImeOptions());
        int inputType = this.f900b1.getInputType();
        int i10 = 1;
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f900b1.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | 524288;
            }
        }
        this.f912p.setInputType(inputType);
        z0.a aVar = this.R;
        if (aVar != null) {
            aVar.a((Cursor) null);
        }
        if (this.f900b1.getSuggestAuthority() != null) {
            a0 a0Var = new a0(getContext(), this, this.f900b1, this.f905f1);
            this.R = a0Var;
            this.f912p.setAdapter(a0Var);
            a0 a0Var2 = (a0) this.R;
            if (this.U) {
                i10 = 2;
            }
            a0Var2.x(i10);
        }
    }

    private void i0() {
        this.f915s.setVisibility((!N() || !(this.f917u.getVisibility() == 0 || this.f919w.getVisibility() == 0)) ? 8 : 0);
    }

    private void j0(boolean z10) {
        this.f917u.setVisibility((!this.S || !N() || !hasFocus() || (!z10 && this.f897a0)) ? 8 : 0);
    }

    private void k0(boolean z10) {
        this.Q = z10;
        int i10 = 0;
        int i11 = z10 ? 0 : 8;
        boolean z11 = !TextUtils.isEmpty(this.f912p.getText());
        this.f916t.setVisibility(i11);
        j0(z11);
        this.f913q.setVisibility(z10 ? 8 : 0);
        if (this.D.getDrawable() == null || this.P) {
            i10 = 8;
        }
        this.D.setVisibility(i10);
        e0();
        l0(!z11);
        i0();
    }

    private void l0(boolean z10) {
        int i10 = 8;
        if (this.f897a0 && !L() && z10) {
            this.f917u.setVisibility(8);
            i10 = 0;
        }
        this.f919w.setVisibility(i10);
    }

    private void setQuery(CharSequence charSequence) {
        this.f912p.setText(charSequence);
        this.f912p.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    /* access modifiers changed from: package-private */
    public void B() {
        if (this.f920x.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.f914r.getPaddingLeft();
            Rect rect = new Rect();
            boolean b10 = m0.b(this);
            int dimensionPixelSize = this.P ? resources.getDimensionPixelSize(j.d.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(j.d.abc_dropdownitem_text_padding_left) : 0;
            this.f912p.getDropDownBackground().getPadding(rect);
            int i10 = rect.left;
            this.f912p.setDropDownHorizontalOffset(b10 ? -i10 : paddingLeft - (i10 + dimensionPixelSize));
            this.f912p.setDropDownWidth((((this.f920x.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    /* access modifiers changed from: package-private */
    public void H() {
        if (Build.VERSION.SDK_INT >= 29) {
            this.f912p.refreshAutoCompleteResults();
            return;
        }
        n nVar = f896m1;
        nVar.b(this.f912p);
        nVar.a(this.f912p);
    }

    public boolean L() {
        return this.Q;
    }

    /* access modifiers changed from: package-private */
    public void P(int i10, String str, String str2) {
        getContext().startActivity(C("android.intent.action.SEARCH", (Uri) null, (String) null, str2, i10, str));
    }

    /* access modifiers changed from: package-private */
    public void R() {
        if (!TextUtils.isEmpty(this.f912p.getText())) {
            this.f912p.setText("");
            this.f912p.requestFocus();
            this.f912p.setImeVisibility(true);
        } else if (this.P) {
            k kVar = this.L;
            if (kVar == null || !kVar.a()) {
                clearFocus();
                k0(true);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean S(int i10, int i11, String str) {
        m mVar = this.N;
        if (mVar != null && mVar.b(i10)) {
            return false;
        }
        Q(i10, 0, (String) null);
        this.f912p.setImeVisibility(false);
        G();
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean T(int i10) {
        m mVar = this.N;
        if (mVar != null && mVar.a(i10)) {
            return false;
        }
        c0(i10);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void U(CharSequence charSequence) {
        setQuery(charSequence);
    }

    /* access modifiers changed from: package-private */
    public void V() {
        k0(false);
        this.f912p.requestFocus();
        this.f912p.setImeVisibility(true);
        View.OnClickListener onClickListener = this.O;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void W() {
        Editable text = this.f912p.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            l lVar = this.K;
            if (lVar == null || !lVar.b(text.toString())) {
                if (this.f900b1 != null) {
                    P(0, (String) null, text.toString());
                }
                this.f912p.setImeVisibility(false);
                G();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean X(View view, int i10, KeyEvent keyEvent) {
        if (this.f900b1 != null && this.R != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i10 == 66 || i10 == 84 || i10 == 61) {
                return S(this.f912p.getListSelection(), 0, (String) null);
            }
            if (i10 == 21 || i10 == 22) {
                this.f912p.setSelection(i10 == 21 ? 0 : this.f912p.length());
                this.f912p.setListSelection(0);
                this.f912p.clearListSelection();
                this.f912p.a();
                return true;
            } else if (i10 == 19) {
                this.f912p.getListSelection();
                return false;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void Y(CharSequence charSequence) {
        Editable text = this.f912p.getText();
        this.f901c0 = text;
        boolean z10 = !TextUtils.isEmpty(text);
        j0(z10);
        l0(!z10);
        e0();
        i0();
        if (this.K != null && !TextUtils.equals(charSequence, this.f899b0)) {
            this.K.a(charSequence.toString());
        }
        this.f899b0 = charSequence.toString();
    }

    /* access modifiers changed from: package-private */
    public void Z() {
        k0(L());
        b0();
        if (this.f912p.hasFocus()) {
            H();
        }
    }

    /* access modifiers changed from: package-private */
    public void a0() {
        Intent E2;
        SearchableInfo searchableInfo = this.f900b1;
        if (searchableInfo != null) {
            try {
                if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                    E2 = F(this.H, searchableInfo);
                } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                    E2 = E(this.I, searchableInfo);
                } else {
                    return;
                }
                getContext().startActivity(E2);
            } catch (ActivityNotFoundException unused) {
                Log.w("SearchView", "Could not find voice search activity");
            }
        }
    }

    public void c() {
        if (!this.Z0) {
            this.Z0 = true;
            int imeOptions = this.f912p.getImeOptions();
            this.f898a1 = imeOptions;
            this.f912p.setImeOptions(imeOptions | 33554432);
            this.f912p.setText("");
            setIconified(false);
        }
    }

    public void clearFocus() {
        this.V = true;
        super.clearFocus();
        this.f912p.clearFocus();
        this.f912p.setImeVisibility(false);
        this.V = false;
    }

    public void d0(CharSequence charSequence, boolean z10) {
        this.f912p.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.f912p;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.f901c0 = charSequence;
        }
        if (z10 && !TextUtils.isEmpty(charSequence)) {
            W();
        }
    }

    public void e() {
        d0("", false);
        clearFocus();
        k0(true);
        this.f912p.setImeOptions(this.f898a1);
        this.Z0 = false;
    }

    /* access modifiers changed from: package-private */
    public void f0() {
        int[] iArr = this.f912p.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.f914r.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f915s.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public int getImeOptions() {
        return this.f912p.getImeOptions();
    }

    public int getInputType() {
        return this.f912p.getInputType();
    }

    public int getMaxWidth() {
        return this.W;
    }

    public CharSequence getQuery() {
        return this.f912p.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.T;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f900b1;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.J : getContext().getText(this.f900b1.getHintId());
    }

    /* access modifiers changed from: package-private */
    public int getSuggestionCommitIconResId() {
        return this.G;
    }

    /* access modifiers changed from: package-private */
    public int getSuggestionRowLayout() {
        return this.F;
    }

    public z0.a getSuggestionsAdapter() {
        return this.R;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.f903d1);
        post(this.f904e1);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10) {
            I(this.f912p, this.f922z);
            Rect rect = this.A;
            Rect rect2 = this.f922z;
            rect.set(rect2.left, 0, rect2.right, i13 - i11);
            o oVar = this.f921y;
            if (oVar == null) {
                o oVar2 = new o(this.A, this.f922z, this.f912p);
                this.f921y = oVar2;
                setTouchDelegate(oVar2);
                return;
            }
            oVar.a(this.A, this.f922z);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        if (r0 <= 0) goto L_0x0039;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r4, int r5) {
        /*
            r3 = this;
            boolean r0 = r3.L()
            if (r0 == 0) goto L_0x000a
            super.onMeasure(r4, r5)
            return
        L_0x000a:
            int r0 = android.view.View.MeasureSpec.getMode(r4)
            int r4 = android.view.View.MeasureSpec.getSize(r4)
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 == r1) goto L_0x002c
            if (r0 == 0) goto L_0x0022
            if (r0 == r2) goto L_0x001d
            goto L_0x0039
        L_0x001d:
            int r0 = r3.W
            if (r0 <= 0) goto L_0x0039
            goto L_0x0030
        L_0x0022:
            int r4 = r3.W
            if (r4 <= 0) goto L_0x0027
            goto L_0x0039
        L_0x0027:
            int r4 = r3.getPreferredWidth()
            goto L_0x0039
        L_0x002c:
            int r0 = r3.W
            if (r0 <= 0) goto L_0x0031
        L_0x0030:
            goto L_0x0035
        L_0x0031:
            int r0 = r3.getPreferredWidth()
        L_0x0035:
            int r4 = java.lang.Math.min(r0, r4)
        L_0x0039:
            int r0 = android.view.View.MeasureSpec.getMode(r5)
            int r5 = android.view.View.MeasureSpec.getSize(r5)
            if (r0 == r1) goto L_0x004b
            if (r0 == 0) goto L_0x0046
            goto L_0x0053
        L_0x0046:
            int r5 = r3.getPreferredHeight()
            goto L_0x0053
        L_0x004b:
            int r0 = r3.getPreferredHeight()
            int r5 = java.lang.Math.min(r0, r5)
        L_0x0053:
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r2)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r2)
            super.onMeasure(r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        k0(savedState.f923c);
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f923c = L();
        return savedState;
    }

    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        b0();
    }

    public boolean requestFocus(int i10, Rect rect) {
        if (this.V || !isFocusable()) {
            return false;
        }
        if (L()) {
            return super.requestFocus(i10, rect);
        }
        boolean requestFocus = this.f912p.requestFocus(i10, rect);
        if (requestFocus) {
            k0(false);
        }
        return requestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.f902c1 = bundle;
    }

    public void setIconified(boolean z10) {
        if (z10) {
            R();
        } else {
            V();
        }
    }

    public void setIconifiedByDefault(boolean z10) {
        if (this.P != z10) {
            this.P = z10;
            k0(z10);
            g0();
        }
    }

    public void setImeOptions(int i10) {
        this.f912p.setImeOptions(i10);
    }

    public void setInputType(int i10) {
        this.f912p.setInputType(i10);
    }

    public void setMaxWidth(int i10) {
        this.W = i10;
        requestLayout();
    }

    public void setOnCloseListener(k kVar) {
        this.L = kVar;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.M = onFocusChangeListener;
    }

    public void setOnQueryTextListener(l lVar) {
        this.K = lVar;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.O = onClickListener;
    }

    public void setOnSuggestionListener(m mVar) {
        this.N = mVar;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.T = charSequence;
        g0();
    }

    public void setQueryRefinementEnabled(boolean z10) {
        this.U = z10;
        z0.a aVar = this.R;
        if (aVar instanceof a0) {
            ((a0) aVar).x(z10 ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f900b1 = searchableInfo;
        if (searchableInfo != null) {
            h0();
            g0();
        }
        boolean K2 = K();
        this.f897a0 = K2;
        if (K2) {
            this.f912p.setPrivateImeOptions("nm");
        }
        k0(L());
    }

    public void setSubmitButtonEnabled(boolean z10) {
        this.S = z10;
        k0(L());
    }

    public void setSuggestionsAdapter(z0.a aVar) {
        this.R = aVar;
        this.f912p.setAdapter(aVar);
    }
}
