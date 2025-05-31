package androidx.core.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.a;
import androidx.core.view.f0;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import x0.c;

@SuppressLint({"PrivateConstructorForUtilityClass"})
public class x {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f2394a = new AtomicInteger(1);

    /* renamed from: b  reason: collision with root package name */
    private static Field f2395b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f2396c;

    /* renamed from: d  reason: collision with root package name */
    private static Field f2397d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f2398e;

    /* renamed from: f  reason: collision with root package name */
    private static WeakHashMap<View, String> f2399f;

    /* renamed from: g  reason: collision with root package name */
    private static WeakHashMap<View, b0> f2400g = null;

    /* renamed from: h  reason: collision with root package name */
    private static Field f2401h;

    /* renamed from: i  reason: collision with root package name */
    private static boolean f2402i = false;

    /* renamed from: j  reason: collision with root package name */
    private static ThreadLocal<Rect> f2403j;

    /* renamed from: k  reason: collision with root package name */
    private static final int[] f2404k = {m0.c.accessibility_custom_action_0, m0.c.accessibility_custom_action_1, m0.c.accessibility_custom_action_2, m0.c.accessibility_custom_action_3, m0.c.accessibility_custom_action_4, m0.c.accessibility_custom_action_5, m0.c.accessibility_custom_action_6, m0.c.accessibility_custom_action_7, m0.c.accessibility_custom_action_8, m0.c.accessibility_custom_action_9, m0.c.accessibility_custom_action_10, m0.c.accessibility_custom_action_11, m0.c.accessibility_custom_action_12, m0.c.accessibility_custom_action_13, m0.c.accessibility_custom_action_14, m0.c.accessibility_custom_action_15, m0.c.accessibility_custom_action_16, m0.c.accessibility_custom_action_17, m0.c.accessibility_custom_action_18, m0.c.accessibility_custom_action_19, m0.c.accessibility_custom_action_20, m0.c.accessibility_custom_action_21, m0.c.accessibility_custom_action_22, m0.c.accessibility_custom_action_23, m0.c.accessibility_custom_action_24, m0.c.accessibility_custom_action_25, m0.c.accessibility_custom_action_26, m0.c.accessibility_custom_action_27, m0.c.accessibility_custom_action_28, m0.c.accessibility_custom_action_29, m0.c.accessibility_custom_action_30, m0.c.accessibility_custom_action_31};

    /* renamed from: l  reason: collision with root package name */
    private static final t f2405l = new a();

    class a implements t {
        a() {
        }

        public c onReceiveContent(c cVar) {
            return cVar;
        }
    }

    class b extends g<Boolean> {
        b(int i10, Class cls, int i11) {
            super(i10, cls, i11);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public Boolean d(View view) {
            return Boolean.valueOf(view.isScreenReaderFocusable());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public void e(View view, Boolean bool) {
            view.setScreenReaderFocusable(bool.booleanValue());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public boolean h(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    class c extends g<CharSequence> {
        c(int i10, Class cls, int i11, int i12) {
            super(i10, cls, i11, i12);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public CharSequence d(View view) {
            return view.getAccessibilityPaneTitle();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public void e(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public boolean h(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    class d extends g<CharSequence> {
        d(int i10, Class cls, int i11, int i12) {
            super(i10, cls, i11, i12);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public CharSequence d(View view) {
            return view.getStateDescription();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public void e(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public boolean h(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    class e extends g<Boolean> {
        e(int i10, Class cls, int i11) {
            super(i10, cls, i11);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public Boolean d(View view) {
            return Boolean.valueOf(view.isAccessibilityHeading());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public void e(View view, Boolean bool) {
            view.setAccessibilityHeading(bool.booleanValue());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public boolean h(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    static class f implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        private WeakHashMap<View, Boolean> f2406a = new WeakHashMap<>();

        f() {
        }

        private void a(View view, boolean z10) {
            boolean z11 = view.getVisibility() == 0;
            if (z10 != z11) {
                x.Z(view, z11 ? 16 : 32);
                this.f2406a.put(view, Boolean.valueOf(z11));
            }
        }

        private void b(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry next : this.f2406a.entrySet()) {
                    a((View) next.getKey(), ((Boolean) next.getValue()).booleanValue());
                }
            }
        }

        public void onViewAttachedToWindow(View view) {
            b(view);
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    static abstract class g<T> {

        /* renamed from: a  reason: collision with root package name */
        private final int f2407a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<T> f2408b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2409c;

        /* renamed from: d  reason: collision with root package name */
        private final int f2410d;

        g(int i10, Class<T> cls, int i11) {
            this(i10, cls, 0, i11);
        }

        g(int i10, Class<T> cls, int i11, int i12) {
            this.f2407a = i10;
            this.f2408b = cls;
            this.f2410d = i11;
            this.f2409c = i12;
        }

        private boolean b() {
            return Build.VERSION.SDK_INT >= 19;
        }

        private boolean c() {
            return Build.VERSION.SDK_INT >= this.f2409c;
        }

        /* access modifiers changed from: package-private */
        public boolean a(Boolean bool, Boolean bool2) {
            return (bool == null ? false : bool.booleanValue()) == (bool2 == null ? false : bool2.booleanValue());
        }

        /* access modifiers changed from: package-private */
        public abstract T d(View view);

        /* access modifiers changed from: package-private */
        public abstract void e(View view, T t10);

        /* access modifiers changed from: package-private */
        public T f(View view) {
            if (c()) {
                return d(view);
            }
            if (!b()) {
                return null;
            }
            T tag = view.getTag(this.f2407a);
            if (this.f2408b.isInstance(tag)) {
                return tag;
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public void g(View view, T t10) {
            if (c()) {
                e(view, t10);
            } else if (b() && h(f(view), t10)) {
                x.G(view);
                view.setTag(this.f2407a, t10);
                x.Z(view, this.f2410d);
            }
        }

        /* access modifiers changed from: package-private */
        public abstract boolean h(T t10, T t11);
    }

    private static class h {

        class a implements View.OnApplyWindowInsetsListener {

            /* renamed from: a  reason: collision with root package name */
            f0 f2411a = null;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ View f2412b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ r f2413c;

            a(View view, r rVar) {
                this.f2412b = view;
                this.f2413c = rVar;
            }

            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                f0 y10 = f0.y(windowInsets, view);
                int i10 = Build.VERSION.SDK_INT;
                if (i10 < 30) {
                    h.a(windowInsets, this.f2412b);
                    if (y10.equals(this.f2411a)) {
                        return this.f2413c.a(view, y10).w();
                    }
                }
                this.f2411a = y10;
                f0 a10 = this.f2413c.a(view, y10);
                if (i10 >= 30) {
                    return a10.w();
                }
                x.o0(view);
                return a10.w();
            }
        }

        static void a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(m0.c.tag_window_insets_animation_callback);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        static f0 b(View view, f0 f0Var, Rect rect) {
            WindowInsets w10 = f0Var.w();
            if (w10 != null) {
                return f0.y(view.computeSystemWindowInsets(w10, rect), view);
            }
            rect.setEmpty();
            return f0Var;
        }

        public static f0 c(View view) {
            return f0.a.a(view);
        }

        static void d(View view, r rVar) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(m0.c.tag_on_apply_window_listener, rVar);
            }
            if (rVar == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(m0.c.tag_window_insets_animation_callback));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, rVar));
            }
        }
    }

    private static class i {
        public static f0 a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            f0 x10 = f0.x(rootWindowInsets);
            x10.u(x10);
            x10.d(view.getRootView());
            return x10;
        }
    }

    private static class j {
        static void a(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i10, int i11) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i10, i11);
        }
    }

    public interface k {
        boolean a(View view, KeyEvent keyEvent);
    }

    static class l {

        /* renamed from: d  reason: collision with root package name */
        private static final ArrayList<WeakReference<View>> f2414d = new ArrayList<>();

        /* renamed from: a  reason: collision with root package name */
        private WeakHashMap<View, Boolean> f2415a = null;

        /* renamed from: b  reason: collision with root package name */
        private SparseArray<WeakReference<View>> f2416b = null;

        /* renamed from: c  reason: collision with root package name */
        private WeakReference<KeyEvent> f2417c = null;

        l() {
        }

        static l a(View view) {
            int i10 = m0.c.tag_unhandled_key_event_manager;
            l lVar = (l) view.getTag(i10);
            if (lVar != null) {
                return lVar;
            }
            l lVar2 = new l();
            view.setTag(i10, lVar2);
            return lVar2;
        }

        private View c(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.f2415a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View c10 = c(viewGroup.getChildAt(childCount), keyEvent);
                        if (c10 != null) {
                            return c10;
                        }
                    }
                }
                if (e(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        private SparseArray<WeakReference<View>> d() {
            if (this.f2416b == null) {
                this.f2416b = new SparseArray<>();
            }
            return this.f2416b;
        }

        private boolean e(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(m0.c.tag_unhandled_key_listeners);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((k) arrayList.get(size)).a(view, keyEvent)) {
                    return true;
                }
            }
            return false;
        }

        private void g() {
            WeakHashMap<View, Boolean> weakHashMap = this.f2415a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList = f2414d;
            if (!arrayList.isEmpty()) {
                synchronized (arrayList) {
                    if (this.f2415a == null) {
                        this.f2415a = new WeakHashMap<>();
                    }
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        ArrayList<WeakReference<View>> arrayList2 = f2414d;
                        View view = (View) arrayList2.get(size).get();
                        if (view == null) {
                            arrayList2.remove(size);
                        } else {
                            this.f2415a.put(view, Boolean.TRUE);
                            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                                this.f2415a.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                g();
            }
            View c10 = c(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (c10 != null && !KeyEvent.isModifierKey(keyCode)) {
                    d().put(keyCode, new WeakReference(c10));
                }
            }
            return c10 != null;
        }

        /* access modifiers changed from: package-private */
        public boolean f(KeyEvent keyEvent) {
            int indexOfKey;
            WeakReference<KeyEvent> weakReference = this.f2417c;
            if (weakReference != null && weakReference.get() == keyEvent) {
                return false;
            }
            this.f2417c = new WeakReference<>(keyEvent);
            WeakReference weakReference2 = null;
            SparseArray<WeakReference<View>> d10 = d();
            if (keyEvent.getAction() == 1 && (indexOfKey = d10.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                weakReference2 = d10.valueAt(indexOfKey);
                d10.removeAt(indexOfKey);
            }
            if (weakReference2 == null) {
                weakReference2 = d10.get(keyEvent.getKeyCode());
            }
            if (weakReference2 == null) {
                return false;
            }
            View view = (View) weakReference2.get();
            if (view != null && x.U(view)) {
                e(view, keyEvent);
            }
            return true;
        }
    }

    static {
        new f();
    }

    public static int A(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getImportantForAccessibility();
        }
        return 0;
    }

    public static void A0(View view, boolean z10) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setHasTransientState(z10);
        }
    }

    @SuppressLint({"InlinedApi"})
    public static int B(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    public static void B0(View view, int i10) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 19) {
            if (i11 < 16) {
                return;
            }
            if (i10 == 4) {
                i10 = 2;
            }
        }
        view.setImportantForAccessibility(i10);
    }

    public static int C(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }

    public static void C0(View view, int i10) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i10);
        }
    }

    public static int D(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumHeight();
        }
        if (!f2398e) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinHeight");
                f2397d = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f2398e = true;
        }
        Field field = f2397d;
        if (field == null) {
            return 0;
        }
        try {
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    public static void D0(View view, Paint paint) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setLayerPaint(paint);
            return;
        }
        view.setLayerType(view.getLayerType(), paint);
        view.invalidate();
    }

    public static int E(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumWidth();
        }
        if (!f2396c) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinWidth");
                f2395b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f2396c = true;
        }
        Field field = f2395b;
        if (field == null) {
            return 0;
        }
        try {
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    public static void E0(View view, boolean z10) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setNestedScrollingEnabled(z10);
        } else if (view instanceof l) {
            ((l) view).setNestedScrollingEnabled(z10);
        }
    }

    public static String[] F(View view) {
        return (String[]) view.getTag(m0.c.tag_on_receive_content_mime_types);
    }

    public static void F0(View view, r rVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            h.d(view, rVar);
        }
    }

    static a G(View view) {
        a l10 = l(view);
        if (l10 == null) {
            l10 = new a();
        }
        r0(view, l10);
        return l10;
    }

    public static void G0(View view, int i10, int i11, int i12, int i13) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(i10, i11, i12, i13);
        } else {
            view.setPadding(i10, i11, i12, i13);
        }
    }

    public static int H(View view) {
        return Build.VERSION.SDK_INT >= 17 ? view.getPaddingEnd() : view.getPaddingRight();
    }

    public static void H0(View view, v vVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            view.setPointerIcon((PointerIcon) (vVar != null ? vVar.a() : null));
        }
    }

    public static int I(View view) {
        return Build.VERSION.SDK_INT >= 17 ? view.getPaddingStart() : view.getPaddingLeft();
    }

    public static void I0(View view, int i10, int i11) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i10, i11);
        }
    }

    public static ViewParent J(View view) {
        return Build.VERSION.SDK_INT >= 16 ? view.getParentForAccessibility() : view.getParent();
    }

    public static void J0(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 19) {
            O0().g(view, charSequence);
        }
    }

    public static f0 K(View view) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 23) {
            return i.a(view);
        }
        if (i10 >= 21) {
            return h.c(view);
        }
        return null;
    }

    public static void K0(View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTransitionName(str);
            return;
        }
        if (f2399f == null) {
            f2399f = new WeakHashMap<>();
        }
        f2399f.put(view, str);
    }

    public static final CharSequence L(View view) {
        return O0().f(view);
    }

    public static void L0(View view, float f10) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTranslationZ(f10);
        }
    }

    public static String M(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        WeakHashMap<View, String> weakHashMap = f2399f;
        if (weakHashMap == null) {
            return null;
        }
        return weakHashMap.get(view);
    }

    private static void M0(View view) {
        if (A(view) == 0) {
            B0(view, 1);
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (A((View) parent) == 4) {
                B0(view, 2);
                return;
            }
        }
    }

    public static float N(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTranslationZ();
        }
        return 0.0f;
    }

    public static void N0(View view, float f10) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setZ(f10);
        }
    }

    public static int O(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getWindowSystemUiVisibility();
        }
        return 0;
    }

    private static g<CharSequence> O0() {
        return new d(m0.c.tag_state_description, CharSequence.class, 64, 30);
    }

    public static float P(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getZ();
        }
        return 0.0f;
    }

    public static void P0(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else if (view instanceof l) {
            ((l) view).stopNestedScroll();
        }
    }

    public static boolean Q(View view) {
        if (Build.VERSION.SDK_INT >= 15) {
            return view.hasOnClickListeners();
        }
        return false;
    }

    private static void Q0(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    public static boolean R(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasOverlappingRendering();
        }
        return true;
    }

    public static boolean S(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasTransientState();
        }
        return false;
    }

    public static boolean T(View view) {
        Boolean f10 = a().f(view);
        if (f10 == null) {
            return false;
        }
        return f10.booleanValue();
    }

    public static boolean U(View view) {
        return Build.VERSION.SDK_INT >= 19 ? view.isAttachedToWindow() : view.getWindowToken() != null;
    }

    public static boolean V(View view) {
        return Build.VERSION.SDK_INT >= 19 ? view.isLaidOut() : view.getWidth() > 0 && view.getHeight() > 0;
    }

    public static boolean W(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.isNestedScrollingEnabled();
        }
        if (view instanceof l) {
            return ((l) view).isNestedScrollingEnabled();
        }
        return false;
    }

    public static boolean X(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.isPaddingRelative();
        }
        return false;
    }

    public static boolean Y(View view) {
        Boolean f10 = q0().f(view);
        if (f10 == null) {
            return false;
        }
        return f10.booleanValue();
    }

    static void Z(View view, int i10) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z10 = p(view) != null && view.getVisibility() == 0;
            int i11 = 32;
            if (o(view) != 0 || z10) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                if (!z10) {
                    i11 = RecyclerView.m.FLAG_MOVED;
                }
                obtain.setEventType(i11);
                obtain.setContentChangeTypes(i10);
                if (z10) {
                    obtain.getText().add(p(view));
                    M0(view);
                }
                view.sendAccessibilityEventUnchecked(obtain);
            } else if (i10 == 32) {
                AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain2);
                obtain2.setEventType(32);
                obtain2.setContentChangeTypes(i10);
                obtain2.setSource(view);
                view.onPopulateAccessibilityEvent(obtain2);
                obtain2.getText().add(p(view));
                accessibilityManager.sendAccessibilityEvent(obtain2);
            } else if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i10);
                } catch (AbstractMethodError e10) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e10);
                }
            }
        }
    }

    private static g<Boolean> a() {
        return new e(m0.c.tag_accessibility_heading, Boolean.class, 28);
    }

    public static void a0(View view, int i10) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 23) {
            view.offsetLeftAndRight(i10);
        } else if (i11 >= 21) {
            Rect x10 = x();
            boolean z10 = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                x10.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z10 = !x10.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            e(view, i10);
            if (z10 && x10.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(x10);
            }
        } else {
            e(view, i10);
        }
    }

    public static int b(View view, CharSequence charSequence, x0.f fVar) {
        int r10 = r(view, charSequence);
        if (r10 != -1) {
            c(view, new c.a(r10, charSequence, fVar));
        }
        return r10;
    }

    public static void b0(View view, int i10) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 23) {
            view.offsetTopAndBottom(i10);
        } else if (i11 >= 21) {
            Rect x10 = x();
            boolean z10 = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                x10.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z10 = !x10.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            f(view, i10);
            if (z10 && x10.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(x10);
            }
        } else {
            f(view, i10);
        }
    }

    private static void c(View view, c.a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            G(view);
            m0(aVar.b(), view);
            q(view).add(aVar);
            Z(view, 0);
        }
    }

    public static f0 c0(View view, f0 f0Var) {
        WindowInsets w10;
        if (Build.VERSION.SDK_INT >= 21 && (w10 = f0Var.w()) != null) {
            WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(w10);
            if (!onApplyWindowInsets.equals(w10)) {
                return f0.y(onApplyWindowInsets, view);
            }
        }
        return f0Var;
    }

    public static b0 d(View view) {
        if (f2400g == null) {
            f2400g = new WeakHashMap<>();
        }
        b0 b0Var = f2400g.get(view);
        if (b0Var != null) {
            return b0Var;
        }
        b0 b0Var2 = new b0(view);
        f2400g.put(view, b0Var2);
        return b0Var2;
    }

    public static void d0(View view, x0.c cVar) {
        view.onInitializeAccessibilityNodeInfo(cVar.H0());
    }

    private static void e(View view, int i10) {
        view.offsetLeftAndRight(i10);
        if (view.getVisibility() == 0) {
            Q0(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                Q0((View) parent);
            }
        }
    }

    private static g<CharSequence> e0() {
        return new c(m0.c.tag_accessibility_pane_title, CharSequence.class, 8, 28);
    }

    private static void f(View view, int i10) {
        view.offsetTopAndBottom(i10);
        if (view.getVisibility() == 0) {
            Q0(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                Q0((View) parent);
            }
        }
    }

    public static boolean f0(View view, int i10, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.performAccessibilityAction(i10, bundle);
        }
        return false;
    }

    public static f0 g(View view, f0 f0Var, Rect rect) {
        return Build.VERSION.SDK_INT >= 21 ? h.b(view, f0Var, rect) : f0Var;
    }

    public static c g0(View view, c cVar) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + cVar + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        s sVar = (s) view.getTag(m0.c.tag_on_receive_content_listener);
        if (sVar == null) {
            return y(view).onReceiveContent(cVar);
        }
        c a10 = sVar.a(view, cVar);
        if (a10 == null) {
            return null;
        }
        return y(view).onReceiveContent(a10);
    }

    public static f0 h(View view, f0 f0Var) {
        WindowInsets w10;
        if (Build.VERSION.SDK_INT >= 21 && (w10 = f0Var.w()) != null) {
            WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(w10);
            if (!dispatchApplyWindowInsets.equals(w10)) {
                return f0.y(dispatchApplyWindowInsets, view);
            }
        }
        return f0Var;
    }

    public static void h0(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidate();
        }
    }

    static boolean i(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return l.a(view).b(view, keyEvent);
    }

    public static void i0(View view, int i10, int i11, int i12, int i13) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation(i10, i11, i12, i13);
        } else {
            view.postInvalidate(i10, i11, i12, i13);
        }
    }

    static boolean j(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return l.a(view).f(keyEvent);
    }

    public static void j0(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    public static int k() {
        AtomicInteger atomicInteger;
        int i10;
        int i11;
        if (Build.VERSION.SDK_INT >= 17) {
            return View.generateViewId();
        }
        do {
            atomicInteger = f2394a;
            i10 = atomicInteger.get();
            i11 = i10 + 1;
            if (i11 > 16777215) {
                i11 = 1;
            }
        } while (!atomicInteger.compareAndSet(i10, i11));
        return i10;
    }

    public static void k0(View view, Runnable runnable, long j10) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimationDelayed(runnable, j10);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j10);
        }
    }

    public static a l(View view) {
        View.AccessibilityDelegate m10 = m(view);
        if (m10 == null) {
            return null;
        }
        return m10 instanceof a.C0022a ? ((a.C0022a) m10).f2293a : new a(m10);
    }

    public static void l0(View view, int i10) {
        if (Build.VERSION.SDK_INT >= 21) {
            m0(i10, view);
            Z(view, 0);
        }
    }

    private static View.AccessibilityDelegate m(View view) {
        return Build.VERSION.SDK_INT >= 29 ? view.getAccessibilityDelegate() : n(view);
    }

    private static void m0(int i10, View view) {
        List<c.a> q10 = q(view);
        for (int i11 = 0; i11 < q10.size(); i11++) {
            if (q10.get(i11).b() == i10) {
                q10.remove(i11);
                return;
            }
        }
    }

    private static View.AccessibilityDelegate n(View view) {
        if (f2402i) {
            return null;
        }
        if (f2401h == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f2401h = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f2402i = true;
                return null;
            }
        }
        try {
            Object obj = f2401h.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f2402i = true;
            return null;
        }
    }

    public static void n0(View view, c.a aVar, CharSequence charSequence, x0.f fVar) {
        if (fVar == null && charSequence == null) {
            l0(view, aVar.b());
        } else {
            c(view, aVar.a(charSequence, fVar));
        }
    }

    public static int o(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.getAccessibilityLiveRegion();
        }
        return 0;
    }

    public static void o0(View view) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 20) {
            view.requestApplyInsets();
        } else if (i10 >= 16) {
            view.requestFitSystemWindows();
        }
    }

    public static CharSequence p(View view) {
        return e0().f(view);
    }

    public static void p0(View view, @SuppressLint({"ContextFirst"}) Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i10, int i11) {
        if (Build.VERSION.SDK_INT >= 29) {
            j.a(view, context, iArr, attributeSet, typedArray, i10, i11);
        }
    }

    private static List<c.a> q(View view) {
        int i10 = m0.c.tag_accessibility_actions;
        ArrayList arrayList = (ArrayList) view.getTag(i10);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(i10, arrayList2);
        return arrayList2;
    }

    private static g<Boolean> q0() {
        return new b(m0.c.tag_screen_reader_focusable, Boolean.class, 28);
    }

    private static int r(View view, CharSequence charSequence) {
        List<c.a> q10 = q(view);
        for (int i10 = 0; i10 < q10.size(); i10++) {
            if (TextUtils.equals(charSequence, q10.get(i10).c())) {
                return q10.get(i10).b();
            }
        }
        int i11 = -1;
        int i12 = 0;
        while (true) {
            int[] iArr = f2404k;
            if (i12 >= iArr.length || i11 != -1) {
                return i11;
            }
            int i13 = iArr[i12];
            boolean z10 = true;
            for (int i14 = 0; i14 < q10.size(); i14++) {
                z10 &= q10.get(i14).b() != i13;
            }
            if (z10) {
                i11 = i13;
            }
            i12++;
        }
        return i11;
    }

    public static void r0(View view, a aVar) {
        if (aVar == null && (m(view) instanceof a.C0022a)) {
            aVar = new a();
        }
        view.setAccessibilityDelegate(aVar == null ? null : aVar.d());
    }

    public static ColorStateList s(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        if (view instanceof w) {
            return ((w) view).getSupportBackgroundTintList();
        }
        return null;
    }

    public static void s0(View view, boolean z10) {
        a().g(view, Boolean.valueOf(z10));
    }

    public static PorterDuff.Mode t(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintMode();
        }
        if (view instanceof w) {
            return ((w) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    public static void t0(View view, int i10) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setAccessibilityLiveRegion(i10);
        }
    }

    public static Rect u(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return view.getClipBounds();
        }
        return null;
    }

    public static void u0(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static Display v(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getDisplay();
        }
        if (U(view)) {
            return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
        }
        return null;
    }

    public static void v0(View view, ColorStateList colorStateList) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 21) {
            view.setBackgroundTintList(colorStateList);
            if (i10 == 21) {
                Drawable background = view.getBackground();
                boolean z10 = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background != null && z10) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        } else if (view instanceof w) {
            ((w) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    public static float w(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getElevation();
        }
        return 0.0f;
    }

    public static void w0(View view, PorterDuff.Mode mode) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 21) {
            view.setBackgroundTintMode(mode);
            if (i10 == 21) {
                Drawable background = view.getBackground();
                boolean z10 = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background != null && z10) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        } else if (view instanceof w) {
            ((w) view).setSupportBackgroundTintMode(mode);
        }
    }

    private static Rect x() {
        if (f2403j == null) {
            f2403j = new ThreadLocal<>();
        }
        Rect rect = f2403j.get();
        if (rect == null) {
            rect = new Rect();
            f2403j.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static void x0(View view, Rect rect) {
        if (Build.VERSION.SDK_INT >= 18) {
            view.setClipBounds(rect);
        }
    }

    private static t y(View view) {
        return view instanceof t ? (t) view : f2405l;
    }

    public static void y0(View view, float f10) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation(f10);
        }
    }

    public static boolean z(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getFitsSystemWindows();
        }
        return false;
    }

    @Deprecated
    public static void z0(View view, boolean z10) {
        view.setFitsSystemWindows(z10);
    }
}
