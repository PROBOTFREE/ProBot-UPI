package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.g0;
import androidx.appcompat.widget.m0;
import androidx.appcompat.widget.s;
import androidx.core.view.b0;
import androidx.core.view.c0;
import androidx.core.view.d0;
import androidx.core.view.f0;
import androidx.core.view.g;
import androidx.core.view.x;
import androidx.lifecycle.h;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.Thread;
import java.util.List;
import n0.f;
import o.b;
import o.f;

class AppCompatDelegateImpl extends d implements e.a, LayoutInflater.Factory2 {
    private static final int[] Z0 = {16842836};

    /* renamed from: a1  reason: collision with root package name */
    private static final boolean f311a1 = (!"robolectric".equals(Build.FINGERPRINT));

    /* renamed from: b0  reason: collision with root package name */
    private static final c0.g<String, Integer> f312b0 = new c0.g<>();

    /* renamed from: b1  reason: collision with root package name */
    private static final boolean f313b1;

    /* renamed from: c0  reason: collision with root package name */
    private static final boolean f314c0;

    /* renamed from: c1  reason: collision with root package name */
    private static boolean f315c1 = true;
    boolean A;
    boolean B;
    boolean C;
    boolean D;
    boolean E;
    private boolean F;
    private PanelFeatureState[] G;
    private PanelFeatureState H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    boolean M;
    private int N;
    private int O;
    private boolean P;
    private boolean Q;
    private q R;
    private q S;
    boolean T;
    int U;
    private final Runnable V;
    private boolean W;
    private Rect X;
    private Rect Y;
    private g Z;

    /* renamed from: a0  reason: collision with root package name */
    private h f316a0;

    /* renamed from: d  reason: collision with root package name */
    final Object f317d;

    /* renamed from: e  reason: collision with root package name */
    final Context f318e;

    /* renamed from: f  reason: collision with root package name */
    Window f319f;

    /* renamed from: g  reason: collision with root package name */
    private o f320g;

    /* renamed from: h  reason: collision with root package name */
    final c f321h;

    /* renamed from: i  reason: collision with root package name */
    ActionBar f322i;

    /* renamed from: j  reason: collision with root package name */
    MenuInflater f323j;

    /* renamed from: k  reason: collision with root package name */
    private CharSequence f324k;

    /* renamed from: l  reason: collision with root package name */
    private androidx.appcompat.widget.o f325l;

    /* renamed from: m  reason: collision with root package name */
    private i f326m;

    /* renamed from: n  reason: collision with root package name */
    private u f327n;

    /* renamed from: o  reason: collision with root package name */
    o.b f328o;

    /* renamed from: p  reason: collision with root package name */
    ActionBarContextView f329p;

    /* renamed from: q  reason: collision with root package name */
    PopupWindow f330q;

    /* renamed from: r  reason: collision with root package name */
    Runnable f331r;

    /* renamed from: s  reason: collision with root package name */
    b0 f332s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f333t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f334u;

    /* renamed from: v  reason: collision with root package name */
    ViewGroup f335v;

    /* renamed from: w  reason: collision with root package name */
    private TextView f336w;

    /* renamed from: x  reason: collision with root package name */
    private View f337x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f338y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f339z;

    protected static final class PanelFeatureState {

        /* renamed from: a  reason: collision with root package name */
        int f340a;

        /* renamed from: b  reason: collision with root package name */
        int f341b;

        /* renamed from: c  reason: collision with root package name */
        int f342c;

        /* renamed from: d  reason: collision with root package name */
        int f343d;

        /* renamed from: e  reason: collision with root package name */
        int f344e;

        /* renamed from: f  reason: collision with root package name */
        int f345f;

        /* renamed from: g  reason: collision with root package name */
        ViewGroup f346g;

        /* renamed from: h  reason: collision with root package name */
        View f347h;

        /* renamed from: i  reason: collision with root package name */
        View f348i;

        /* renamed from: j  reason: collision with root package name */
        androidx.appcompat.view.menu.e f349j;

        /* renamed from: k  reason: collision with root package name */
        androidx.appcompat.view.menu.c f350k;

        /* renamed from: l  reason: collision with root package name */
        Context f351l;

        /* renamed from: m  reason: collision with root package name */
        boolean f352m;

        /* renamed from: n  reason: collision with root package name */
        boolean f353n;

        /* renamed from: o  reason: collision with root package name */
        boolean f354o;

        /* renamed from: p  reason: collision with root package name */
        public boolean f355p;

        /* renamed from: q  reason: collision with root package name */
        boolean f356q = false;

        /* renamed from: r  reason: collision with root package name */
        boolean f357r;

        /* renamed from: s  reason: collision with root package name */
        Bundle f358s;

        @SuppressLint({"BanParcelableUsage"})
        private static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            int f359a;

            /* renamed from: b  reason: collision with root package name */
            boolean f360b;

            /* renamed from: c  reason: collision with root package name */
            Bundle f361c;

            class a implements Parcelable.ClassLoaderCreator<SavedState> {
                a() {
                }

                /* renamed from: a */
                public SavedState createFromParcel(Parcel parcel) {
                    return SavedState.a(parcel, (ClassLoader) null);
                }

                /* renamed from: b */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.a(parcel, classLoader);
                }

                /* renamed from: c */
                public SavedState[] newArray(int i10) {
                    return new SavedState[i10];
                }
            }

            SavedState() {
            }

            static SavedState a(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.f359a = parcel.readInt();
                boolean z10 = true;
                if (parcel.readInt() != 1) {
                    z10 = false;
                }
                savedState.f360b = z10;
                if (z10) {
                    savedState.f361c = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                parcel.writeInt(this.f359a);
                parcel.writeInt(this.f360b ? 1 : 0);
                if (this.f360b) {
                    parcel.writeBundle(this.f361c);
                }
            }
        }

        PanelFeatureState(int i10) {
            this.f340a = i10;
        }

        /* access modifiers changed from: package-private */
        public androidx.appcompat.view.menu.k a(j.a aVar) {
            if (this.f349j == null) {
                return null;
            }
            if (this.f350k == null) {
                androidx.appcompat.view.menu.c cVar = new androidx.appcompat.view.menu.c(this.f351l, j.g.abc_list_menu_item_layout);
                this.f350k = cVar;
                cVar.n(aVar);
                this.f349j.b(this.f350k);
            }
            return this.f350k.d(this.f346g);
        }

        public boolean b() {
            if (this.f347h == null) {
                return false;
            }
            if (this.f348i != null) {
                return true;
            }
            return this.f350k.b().getCount() > 0;
        }

        /* access modifiers changed from: package-private */
        public void c(androidx.appcompat.view.menu.e eVar) {
            androidx.appcompat.view.menu.c cVar;
            androidx.appcompat.view.menu.e eVar2 = this.f349j;
            if (eVar != eVar2) {
                if (eVar2 != null) {
                    eVar2.Q(this.f350k);
                }
                this.f349j = eVar;
                if (eVar != null && (cVar = this.f350k) != null) {
                    eVar.b(cVar);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void d(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(j.a.actionBarPopupTheme, typedValue, true);
            int i10 = typedValue.resourceId;
            if (i10 != 0) {
                newTheme.applyStyle(i10, true);
            }
            newTheme.resolveAttribute(j.a.panelMenuListTheme, typedValue, true);
            int i11 = typedValue.resourceId;
            if (i11 == 0) {
                i11 = j.i.Theme_AppCompat_CompactMenu;
            }
            newTheme.applyStyle(i11, true);
            o.d dVar = new o.d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.f351l = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(j.j.AppCompatTheme);
            this.f341b = obtainStyledAttributes.getResourceId(j.j.AppCompatTheme_panelBackground, 0);
            this.f345f = obtainStyledAttributes.getResourceId(j.j.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }
    }

    class a implements Thread.UncaughtExceptionHandler {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Thread.UncaughtExceptionHandler f362a;

        a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f362a = uncaughtExceptionHandler;
        }

        private boolean a(Throwable th) {
            String message;
            if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                return false;
            }
            return message.contains("drawable") || message.contains("Drawable");
        }

        public void uncaughtException(Thread thread, Throwable th) {
            if (a(th)) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                notFoundException.initCause(th.getCause());
                notFoundException.setStackTrace(th.getStackTrace());
                this.f362a.uncaughtException(thread, notFoundException);
                return;
            }
            this.f362a.uncaughtException(thread, th);
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl.U & 1) != 0) {
                appCompatDelegateImpl.Y(0);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl2.U & RecyclerView.m.FLAG_APPEARED_IN_PRE_LAYOUT) != 0) {
                appCompatDelegateImpl2.Y(108);
            }
            AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl3.T = false;
            appCompatDelegateImpl3.U = 0;
        }
    }

    class c implements androidx.core.view.r {
        c() {
        }

        public f0 a(View view, f0 f0Var) {
            int m10 = f0Var.m();
            int O0 = AppCompatDelegateImpl.this.O0(f0Var, (Rect) null);
            if (m10 != O0) {
                f0Var = f0Var.r(f0Var.k(), O0, f0Var.l(), f0Var.j());
            }
            return x.c0(view, f0Var);
        }
    }

    class d implements s.a {
        d() {
        }

        public void a(Rect rect) {
            rect.top = AppCompatDelegateImpl.this.O0((f0) null, rect);
        }
    }

    class e implements ContentFrameLayout.a {
        e() {
        }

        public void a() {
        }

        public void onDetachedFromWindow() {
            AppCompatDelegateImpl.this.W();
        }
    }

    class f implements Runnable {

        class a extends d0 {
            a() {
            }

            public void b(View view) {
                AppCompatDelegateImpl.this.f329p.setAlpha(1.0f);
                AppCompatDelegateImpl.this.f332s.f((c0) null);
                AppCompatDelegateImpl.this.f332s = null;
            }

            public void c(View view) {
                AppCompatDelegateImpl.this.f329p.setVisibility(0);
            }
        }

        f() {
        }

        public void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            appCompatDelegateImpl.f330q.showAtLocation(appCompatDelegateImpl.f329p, 55, 0, 0);
            AppCompatDelegateImpl.this.Z();
            if (AppCompatDelegateImpl.this.H0()) {
                AppCompatDelegateImpl.this.f329p.setAlpha(0.0f);
                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl2.f332s = x.d(appCompatDelegateImpl2.f329p).a(1.0f);
                AppCompatDelegateImpl.this.f332s.f(new a());
                return;
            }
            AppCompatDelegateImpl.this.f329p.setAlpha(1.0f);
            AppCompatDelegateImpl.this.f329p.setVisibility(0);
        }
    }

    class g extends d0 {
        g() {
        }

        public void b(View view) {
            AppCompatDelegateImpl.this.f329p.setAlpha(1.0f);
            AppCompatDelegateImpl.this.f332s.f((c0) null);
            AppCompatDelegateImpl.this.f332s = null;
        }

        public void c(View view) {
            AppCompatDelegateImpl.this.f329p.setVisibility(0);
            AppCompatDelegateImpl.this.f329p.sendAccessibilityEvent(32);
            if (AppCompatDelegateImpl.this.f329p.getParent() instanceof View) {
                x.o0((View) AppCompatDelegateImpl.this.f329p.getParent());
            }
        }
    }

    private class h implements a {
        h(AppCompatDelegateImpl appCompatDelegateImpl) {
        }
    }

    private final class i implements j.a {
        i() {
        }

        public void c(androidx.appcompat.view.menu.e eVar, boolean z10) {
            AppCompatDelegateImpl.this.P(eVar);
        }

        public boolean d(androidx.appcompat.view.menu.e eVar) {
            Window.Callback j02 = AppCompatDelegateImpl.this.j0();
            if (j02 == null) {
                return true;
            }
            j02.onMenuOpened(108, eVar);
            return true;
        }
    }

    class j implements b.a {

        /* renamed from: a  reason: collision with root package name */
        private b.a f371a;

        class a extends d0 {
            a() {
            }

            public void b(View view) {
                AppCompatDelegateImpl.this.f329p.setVisibility(8);
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                PopupWindow popupWindow = appCompatDelegateImpl.f330q;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (appCompatDelegateImpl.f329p.getParent() instanceof View) {
                    x.o0((View) AppCompatDelegateImpl.this.f329p.getParent());
                }
                AppCompatDelegateImpl.this.f329p.k();
                AppCompatDelegateImpl.this.f332s.f((c0) null);
                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl2.f332s = null;
                x.o0(appCompatDelegateImpl2.f335v);
            }
        }

        public j(b.a aVar) {
            this.f371a = aVar;
        }

        public boolean a(o.b bVar, Menu menu) {
            return this.f371a.a(bVar, menu);
        }

        public void b(o.b bVar) {
            this.f371a.b(bVar);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl.f330q != null) {
                appCompatDelegateImpl.f319f.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.f331r);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl2.f329p != null) {
                appCompatDelegateImpl2.Z();
                AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl3.f332s = x.d(appCompatDelegateImpl3.f329p).a(0.0f);
                AppCompatDelegateImpl.this.f332s.f(new a());
            }
            AppCompatDelegateImpl appCompatDelegateImpl4 = AppCompatDelegateImpl.this;
            c cVar = appCompatDelegateImpl4.f321h;
            if (cVar != null) {
                cVar.onSupportActionModeFinished(appCompatDelegateImpl4.f328o);
            }
            AppCompatDelegateImpl appCompatDelegateImpl5 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl5.f328o = null;
            x.o0(appCompatDelegateImpl5.f335v);
        }

        public boolean c(o.b bVar, MenuItem menuItem) {
            return this.f371a.c(bVar, menuItem);
        }

        public boolean d(o.b bVar, Menu menu) {
            x.o0(AppCompatDelegateImpl.this.f335v);
            return this.f371a.d(bVar, menu);
        }
    }

    static class k {
        static Context a(Context context, Configuration configuration) {
            return context.createConfigurationContext(configuration);
        }

        static void b(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i10 = configuration.densityDpi;
            int i11 = configuration2.densityDpi;
            if (i10 != i11) {
                configuration3.densityDpi = i11;
            }
        }
    }

    static class l {
        static boolean a(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }
    }

    static class m {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (!locales.equals(locales2)) {
                configuration3.setLocales(locales2);
                configuration3.locale = configuration2.locale;
            }
        }
    }

    static class n {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i10 = configuration.colorMode & 3;
            int i11 = configuration2.colorMode;
            if (i10 != (i11 & 3)) {
                configuration3.colorMode |= i11 & 3;
            }
            int i12 = configuration.colorMode & 12;
            int i13 = configuration2.colorMode;
            if (i12 != (i13 & 12)) {
                configuration3.colorMode |= i13 & 12;
            }
        }
    }

    class o extends o.i {
        o(Window.Callback callback) {
            super(callback);
        }

        /* access modifiers changed from: package-private */
        public final ActionMode b(ActionMode.Callback callback) {
            f.a aVar = new f.a(AppCompatDelegateImpl.this.f318e, callback);
            o.b I = AppCompatDelegateImpl.this.I(aVar);
            if (I != null) {
                return aVar.e(I);
            }
            return null;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.X(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImpl.this.v0(keyEvent.getKeyCode(), keyEvent);
        }

        public void onContentChanged() {
        }

        public boolean onCreatePanelMenu(int i10, Menu menu) {
            if (i10 != 0 || (menu instanceof androidx.appcompat.view.menu.e)) {
                return super.onCreatePanelMenu(i10, menu);
            }
            return false;
        }

        public boolean onMenuOpened(int i10, Menu menu) {
            super.onMenuOpened(i10, menu);
            AppCompatDelegateImpl.this.y0(i10);
            return true;
        }

        public void onPanelClosed(int i10, Menu menu) {
            super.onPanelClosed(i10, menu);
            AppCompatDelegateImpl.this.z0(i10);
        }

        public boolean onPreparePanel(int i10, View view, Menu menu) {
            androidx.appcompat.view.menu.e eVar = menu instanceof androidx.appcompat.view.menu.e ? (androidx.appcompat.view.menu.e) menu : null;
            if (i10 == 0 && eVar == null) {
                return false;
            }
            if (eVar != null) {
                eVar.e0(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i10, view, menu);
            if (eVar != null) {
                eVar.e0(false);
            }
            return onPreparePanel;
        }

        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i10) {
            androidx.appcompat.view.menu.e eVar;
            PanelFeatureState h02 = AppCompatDelegateImpl.this.h0(0, true);
            if (h02 == null || (eVar = h02.f349j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i10);
            } else {
                super.onProvideKeyboardShortcuts(list, eVar, i10);
            }
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            return AppCompatDelegateImpl.this.q0() ? b(callback) : super.onWindowStartingActionMode(callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i10) {
            return (!AppCompatDelegateImpl.this.q0() || i10 != 0) ? super.onWindowStartingActionMode(callback, i10) : b(callback);
        }
    }

    private class p extends q {

        /* renamed from: c  reason: collision with root package name */
        private final PowerManager f375c;

        p(Context context) {
            super();
            this.f375c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        /* access modifiers changed from: package-private */
        public IntentFilter b() {
            if (Build.VERSION.SDK_INT < 21) {
                return null;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        public int c() {
            return (Build.VERSION.SDK_INT < 21 || !l.a(this.f375c)) ? 1 : 2;
        }

        public void d() {
            AppCompatDelegateImpl.this.J();
        }
    }

    abstract class q {

        /* renamed from: a  reason: collision with root package name */
        private BroadcastReceiver f377a;

        class a extends BroadcastReceiver {
            a() {
            }

            public void onReceive(Context context, Intent intent) {
                q.this.d();
            }
        }

        q() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            BroadcastReceiver broadcastReceiver = this.f377a;
            if (broadcastReceiver != null) {
                try {
                    AppCompatDelegateImpl.this.f318e.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f377a = null;
            }
        }

        /* access modifiers changed from: package-private */
        public abstract IntentFilter b();

        /* access modifiers changed from: package-private */
        public abstract int c();

        /* access modifiers changed from: package-private */
        public abstract void d();

        /* access modifiers changed from: package-private */
        public void e() {
            a();
            IntentFilter b10 = b();
            if (b10 != null && b10.countActions() != 0) {
                if (this.f377a == null) {
                    this.f377a = new a();
                }
                AppCompatDelegateImpl.this.f318e.registerReceiver(this.f377a, b10);
            }
        }
    }

    private class r extends q {

        /* renamed from: c  reason: collision with root package name */
        private final l f380c;

        r(l lVar) {
            super();
            this.f380c = lVar;
        }

        /* access modifiers changed from: package-private */
        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        public int c() {
            return this.f380c.d() ? 2 : 1;
        }

        public void d() {
            AppCompatDelegateImpl.this.J();
        }
    }

    private static class s {
        static void a(ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
            contextThemeWrapper.applyOverrideConfiguration(configuration);
        }
    }

    private class t extends ContentFrameLayout {
        public t(Context context) {
            super(context);
        }

        private boolean c(int i10, int i11) {
            return i10 < -5 || i11 < -5 || i10 > getWidth() + 5 || i11 > getHeight() + 5;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.X(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !c((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            AppCompatDelegateImpl.this.R(0);
            return true;
        }

        public void setBackgroundResource(int i10) {
            setBackgroundDrawable(k.a.d(getContext(), i10));
        }
    }

    private final class u implements j.a {
        u() {
        }

        public void c(androidx.appcompat.view.menu.e eVar, boolean z10) {
            androidx.appcompat.view.menu.e F = eVar.F();
            boolean z11 = F != eVar;
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z11) {
                eVar = F;
            }
            PanelFeatureState c02 = appCompatDelegateImpl.c0(eVar);
            if (c02 == null) {
                return;
            }
            if (z11) {
                AppCompatDelegateImpl.this.O(c02.f340a, c02, F);
                AppCompatDelegateImpl.this.S(c02, true);
                return;
            }
            AppCompatDelegateImpl.this.S(c02, z10);
        }

        public boolean d(androidx.appcompat.view.menu.e eVar) {
            Window.Callback j02;
            if (eVar != eVar.F()) {
                return true;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (!appCompatDelegateImpl.A || (j02 = appCompatDelegateImpl.j0()) == null || AppCompatDelegateImpl.this.M) {
                return true;
            }
            j02.onMenuOpened(108, eVar);
            return true;
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        boolean z10 = false;
        boolean z11 = i10 < 21;
        f314c0 = z11;
        if (i10 >= 17) {
            z10 = true;
        }
        f313b1 = z10;
        if (z11 && !f315c1) {
            Thread.setDefaultUncaughtExceptionHandler(new a(Thread.getDefaultUncaughtExceptionHandler()));
        }
    }

    AppCompatDelegateImpl(Activity activity, c cVar) {
        this(activity, (Window) null, cVar, activity);
    }

    AppCompatDelegateImpl(Dialog dialog, c cVar) {
        this(dialog.getContext(), dialog.getWindow(), cVar, dialog);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0036, code lost:
        r3 = f312b0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private AppCompatDelegateImpl(android.content.Context r3, android.view.Window r4, androidx.appcompat.app.c r5, java.lang.Object r6) {
        /*
            r2 = this;
            r2.<init>()
            r0 = 0
            r2.f332s = r0
            r0 = 1
            r2.f333t = r0
            r0 = -100
            r2.N = r0
            androidx.appcompat.app.AppCompatDelegateImpl$b r1 = new androidx.appcompat.app.AppCompatDelegateImpl$b
            r1.<init>()
            r2.V = r1
            r2.f318e = r3
            r2.f321h = r5
            r2.f317d = r6
            int r3 = r2.N
            if (r3 != r0) goto L_0x0032
            boolean r3 = r6 instanceof android.app.Dialog
            if (r3 == 0) goto L_0x0032
            androidx.appcompat.app.AppCompatActivity r3 = r2.L0()
            if (r3 == 0) goto L_0x0032
            androidx.appcompat.app.d r3 = r3.getDelegate()
            int r3 = r3.l()
            r2.N = r3
        L_0x0032:
            int r3 = r2.N
            if (r3 != r0) goto L_0x0059
            c0.g<java.lang.String, java.lang.Integer> r3 = f312b0
            java.lang.Class r5 = r6.getClass()
            java.lang.String r5 = r5.getName()
            java.lang.Object r5 = r3.get(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            if (r5 == 0) goto L_0x0059
            int r5 = r5.intValue()
            r2.N = r5
            java.lang.Class r5 = r6.getClass()
            java.lang.String r5 = r5.getName()
            r3.remove(r5)
        L_0x0059:
            if (r4 == 0) goto L_0x005e
            r2.M(r4)
        L_0x005e:
            androidx.appcompat.widget.f.h()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.<init>(android.content.Context, android.view.Window, androidx.appcompat.app.c, java.lang.Object):void");
    }

    private void B0(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        int i10;
        ViewGroup.LayoutParams layoutParams;
        if (!panelFeatureState.f354o && !this.M) {
            if (panelFeatureState.f340a == 0) {
                if ((this.f318e.getResources().getConfiguration().screenLayout & 15) == 4) {
                    return;
                }
            }
            Window.Callback j02 = j0();
            if (j02 == null || j02.onMenuOpened(panelFeatureState.f340a, panelFeatureState.f349j)) {
                WindowManager windowManager = (WindowManager) this.f318e.getSystemService("window");
                if (windowManager != null && E0(panelFeatureState, keyEvent)) {
                    ViewGroup viewGroup = panelFeatureState.f346g;
                    if (viewGroup == null || panelFeatureState.f356q) {
                        if (viewGroup == null) {
                            if (!m0(panelFeatureState) || panelFeatureState.f346g == null) {
                                return;
                            }
                        } else if (panelFeatureState.f356q && viewGroup.getChildCount() > 0) {
                            panelFeatureState.f346g.removeAllViews();
                        }
                        if (!l0(panelFeatureState) || !panelFeatureState.b()) {
                            panelFeatureState.f356q = true;
                            return;
                        }
                        ViewGroup.LayoutParams layoutParams2 = panelFeatureState.f347h.getLayoutParams();
                        if (layoutParams2 == null) {
                            layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                        }
                        panelFeatureState.f346g.setBackgroundResource(panelFeatureState.f341b);
                        ViewParent parent = panelFeatureState.f347h.getParent();
                        if (parent instanceof ViewGroup) {
                            ((ViewGroup) parent).removeView(panelFeatureState.f347h);
                        }
                        panelFeatureState.f346g.addView(panelFeatureState.f347h, layoutParams2);
                        if (!panelFeatureState.f347h.hasFocus()) {
                            panelFeatureState.f347h.requestFocus();
                        }
                    } else {
                        View view = panelFeatureState.f348i;
                        if (!(view == null || (layoutParams = view.getLayoutParams()) == null || layoutParams.width != -1)) {
                            i10 = -1;
                            panelFeatureState.f353n = false;
                            WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i10, -2, panelFeatureState.f343d, panelFeatureState.f344e, 1002, 8519680, -3);
                            layoutParams3.gravity = panelFeatureState.f342c;
                            layoutParams3.windowAnimations = panelFeatureState.f345f;
                            windowManager.addView(panelFeatureState.f346g, layoutParams3);
                            panelFeatureState.f354o = true;
                            return;
                        }
                    }
                    i10 = -2;
                    panelFeatureState.f353n = false;
                    WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i10, -2, panelFeatureState.f343d, panelFeatureState.f344e, 1002, 8519680, -3);
                    layoutParams32.gravity = panelFeatureState.f342c;
                    layoutParams32.windowAnimations = panelFeatureState.f345f;
                    windowManager.addView(panelFeatureState.f346g, layoutParams32);
                    panelFeatureState.f354o = true;
                    return;
                }
                return;
            }
            S(panelFeatureState, true);
        }
    }

    private boolean D0(PanelFeatureState panelFeatureState, int i10, KeyEvent keyEvent, int i11) {
        androidx.appcompat.view.menu.e eVar;
        boolean z10 = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.f352m || E0(panelFeatureState, keyEvent)) && (eVar = panelFeatureState.f349j) != null) {
            z10 = eVar.performShortcut(i10, keyEvent, i11);
        }
        if (z10 && (i11 & 1) == 0 && this.f325l == null) {
            S(panelFeatureState, true);
        }
        return z10;
    }

    private boolean E0(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        androidx.appcompat.widget.o oVar;
        androidx.appcompat.widget.o oVar2;
        androidx.appcompat.widget.o oVar3;
        if (this.M) {
            return false;
        }
        if (panelFeatureState.f352m) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.H;
        if (!(panelFeatureState2 == null || panelFeatureState2 == panelFeatureState)) {
            S(panelFeatureState2, false);
        }
        Window.Callback j02 = j0();
        if (j02 != null) {
            panelFeatureState.f348i = j02.onCreatePanelView(panelFeatureState.f340a);
        }
        int i10 = panelFeatureState.f340a;
        boolean z10 = i10 == 0 || i10 == 108;
        if (z10 && (oVar3 = this.f325l) != null) {
            oVar3.d();
        }
        if (panelFeatureState.f348i == null && (!z10 || !(C0() instanceof j))) {
            androidx.appcompat.view.menu.e eVar = panelFeatureState.f349j;
            if (eVar == null || panelFeatureState.f357r) {
                if (eVar == null && (!n0(panelFeatureState) || panelFeatureState.f349j == null)) {
                    return false;
                }
                if (z10 && this.f325l != null) {
                    if (this.f326m == null) {
                        this.f326m = new i();
                    }
                    this.f325l.a(panelFeatureState.f349j, this.f326m);
                }
                panelFeatureState.f349j.h0();
                if (!j02.onCreatePanelMenu(panelFeatureState.f340a, panelFeatureState.f349j)) {
                    panelFeatureState.c((androidx.appcompat.view.menu.e) null);
                    if (z10 && (oVar2 = this.f325l) != null) {
                        oVar2.a((Menu) null, this.f326m);
                    }
                    return false;
                }
                panelFeatureState.f357r = false;
            }
            panelFeatureState.f349j.h0();
            Bundle bundle = panelFeatureState.f358s;
            if (bundle != null) {
                panelFeatureState.f349j.R(bundle);
                panelFeatureState.f358s = null;
            }
            if (!j02.onPreparePanel(0, panelFeatureState.f348i, panelFeatureState.f349j)) {
                if (z10 && (oVar = this.f325l) != null) {
                    oVar.a((Menu) null, this.f326m);
                }
                panelFeatureState.f349j.g0();
                return false;
            }
            boolean z11 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.f355p = z11;
            panelFeatureState.f349j.setQwertyMode(z11);
            panelFeatureState.f349j.g0();
        }
        panelFeatureState.f352m = true;
        panelFeatureState.f353n = false;
        this.H = panelFeatureState;
        return true;
    }

    private void F0(boolean z10) {
        androidx.appcompat.widget.o oVar = this.f325l;
        if (oVar == null || !oVar.h() || (ViewConfiguration.get(this.f318e).hasPermanentMenuKey() && !this.f325l.e())) {
            PanelFeatureState h02 = h0(0, true);
            h02.f356q = true;
            S(h02, false);
            B0(h02, (KeyEvent) null);
            return;
        }
        Window.Callback j02 = j0();
        if (this.f325l.b() && z10) {
            this.f325l.f();
            if (!this.M) {
                j02.onPanelClosed(108, h0(0, true).f349j);
            }
        } else if (j02 != null && !this.M) {
            if (this.T && (this.U & 1) != 0) {
                this.f319f.getDecorView().removeCallbacks(this.V);
                this.V.run();
            }
            PanelFeatureState h03 = h0(0, true);
            androidx.appcompat.view.menu.e eVar = h03.f349j;
            if (eVar != null && !h03.f357r && j02.onPreparePanel(0, h03.f348i, eVar)) {
                j02.onMenuOpened(108, h03.f349j);
                this.f325l.g();
            }
        }
    }

    private int G0(int i10) {
        if (i10 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        } else if (i10 != 9) {
            return i10;
        } else {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        }
    }

    private boolean I0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f319f.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || x.U((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private boolean K(boolean z10) {
        if (this.M) {
            return false;
        }
        int N2 = N();
        boolean M0 = M0(r0(this.f318e, N2), z10);
        if (N2 == 0) {
            g0(this.f318e).e();
        } else {
            q qVar = this.R;
            if (qVar != null) {
                qVar.a();
            }
        }
        if (N2 == 3) {
            f0(this.f318e).e();
        } else {
            q qVar2 = this.S;
            if (qVar2 != null) {
                qVar2.a();
            }
        }
        return M0;
    }

    private void K0() {
        if (this.f334u) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private void L() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f335v.findViewById(16908290);
        View decorView = this.f319f.getDecorView();
        contentFrameLayout.b(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.f318e.obtainStyledAttributes(j.j.AppCompatTheme);
        obtainStyledAttributes.getValue(j.j.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(j.j.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        int i10 = j.j.AppCompatTheme_windowFixedWidthMajor;
        if (obtainStyledAttributes.hasValue(i10)) {
            obtainStyledAttributes.getValue(i10, contentFrameLayout.getFixedWidthMajor());
        }
        int i11 = j.j.AppCompatTheme_windowFixedWidthMinor;
        if (obtainStyledAttributes.hasValue(i11)) {
            obtainStyledAttributes.getValue(i11, contentFrameLayout.getFixedWidthMinor());
        }
        int i12 = j.j.AppCompatTheme_windowFixedHeightMajor;
        if (obtainStyledAttributes.hasValue(i12)) {
            obtainStyledAttributes.getValue(i12, contentFrameLayout.getFixedHeightMajor());
        }
        int i13 = j.j.AppCompatTheme_windowFixedHeightMinor;
        if (obtainStyledAttributes.hasValue(i13)) {
            obtainStyledAttributes.getValue(i13, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private AppCompatActivity L0() {
        Context context = this.f318e;
        while (context != null) {
            if (!(context instanceof AppCompatActivity)) {
                if (!(context instanceof ContextWrapper)) {
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            } else {
                return (AppCompatActivity) context;
            }
        }
        return null;
    }

    private void M(Window window) {
        if (this.f319f == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof o)) {
                o oVar = new o(callback);
                this.f320g = oVar;
                window.setCallback(oVar);
                g0 u10 = g0.u(this.f318e, (AttributeSet) null, Z0);
                Drawable h10 = u10.h(0);
                if (h10 != null) {
                    window.setBackgroundDrawable(h10);
                }
                u10.w();
                this.f319f = window;
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean M0(int r7, boolean r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.f318e
            r1 = 0
            android.content.res.Configuration r0 = r6.T(r0, r7, r1)
            boolean r2 = r6.p0()
            android.content.Context r3 = r6.f318e
            android.content.res.Resources r3 = r3.getResources()
            android.content.res.Configuration r3 = r3.getConfiguration()
            int r3 = r3.uiMode
            r3 = r3 & 48
            int r0 = r0.uiMode
            r0 = r0 & 48
            r4 = 1
            if (r3 == r0) goto L_0x0047
            if (r8 == 0) goto L_0x0047
            if (r2 != 0) goto L_0x0047
            boolean r8 = r6.J
            if (r8 == 0) goto L_0x0047
            boolean r8 = f311a1
            if (r8 != 0) goto L_0x0030
            boolean r8 = r6.K
            if (r8 == 0) goto L_0x0047
        L_0x0030:
            java.lang.Object r8 = r6.f317d
            boolean r5 = r8 instanceof android.app.Activity
            if (r5 == 0) goto L_0x0047
            android.app.Activity r8 = (android.app.Activity) r8
            boolean r8 = r8.isChild()
            if (r8 != 0) goto L_0x0047
            java.lang.Object r8 = r6.f317d
            android.app.Activity r8 = (android.app.Activity) r8
            androidx.core.app.a.r(r8)
            r8 = r4
            goto L_0x0048
        L_0x0047:
            r8 = 0
        L_0x0048:
            if (r8 != 0) goto L_0x0050
            if (r3 == r0) goto L_0x0050
            r6.N0(r0, r2, r1)
            goto L_0x0051
        L_0x0050:
            r4 = r8
        L_0x0051:
            if (r4 == 0) goto L_0x005e
            java.lang.Object r8 = r6.f317d
            boolean r0 = r8 instanceof androidx.appcompat.app.AppCompatActivity
            if (r0 == 0) goto L_0x005e
            androidx.appcompat.app.AppCompatActivity r8 = (androidx.appcompat.app.AppCompatActivity) r8
            r8.onNightModeChanged(r7)
        L_0x005e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.M0(int, boolean):boolean");
    }

    private int N() {
        int i10 = this.N;
        return i10 != -100 ? i10 : d.j();
    }

    private void N0(int i10, boolean z10, Configuration configuration) {
        Resources resources = this.f318e.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i10 | (resources.getConfiguration().uiMode & -49);
        resources.updateConfiguration(configuration2, (DisplayMetrics) null);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 26) {
            i.a(resources);
        }
        int i12 = this.O;
        if (i12 != 0) {
            this.f318e.setTheme(i12);
            if (i11 >= 23) {
                this.f318e.getTheme().applyStyle(this.O, true);
            }
        }
        if (z10) {
            Object obj = this.f317d;
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                if (activity instanceof androidx.lifecycle.o) {
                    if (!((androidx.lifecycle.o) activity).getLifecycle().b().a(h.c.STARTED)) {
                        return;
                    }
                } else if (!this.L) {
                    return;
                }
                activity.onConfigurationChanged(configuration2);
            }
        }
    }

    private void P0(View view) {
        int i10;
        Context context;
        if ((x.O(view) & 8192) != 0) {
            context = this.f318e;
            i10 = j.c.abc_decor_view_status_guard_light;
        } else {
            context = this.f318e;
            i10 = j.c.abc_decor_view_status_guard;
        }
        view.setBackgroundColor(androidx.core.content.a.d(context, i10));
    }

    private void Q() {
        q qVar = this.R;
        if (qVar != null) {
            qVar.a();
        }
        q qVar2 = this.S;
        if (qVar2 != null) {
            qVar2.a();
        }
    }

    private Configuration T(Context context, int i10, Configuration configuration) {
        int i11 = i10 != 1 ? i10 != 2 ? context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i11 | (configuration2.uiMode & -49);
        return configuration2;
    }

    private ViewGroup U() {
        ViewGroup viewGroup;
        TypedArray obtainStyledAttributes = this.f318e.obtainStyledAttributes(j.j.AppCompatTheme);
        int i10 = j.j.AppCompatTheme_windowActionBar;
        if (obtainStyledAttributes.hasValue(i10)) {
            if (obtainStyledAttributes.getBoolean(j.j.AppCompatTheme_windowNoTitle, false)) {
                A(1);
            } else if (obtainStyledAttributes.getBoolean(i10, false)) {
                A(108);
            }
            if (obtainStyledAttributes.getBoolean(j.j.AppCompatTheme_windowActionBarOverlay, false)) {
                A(109);
            }
            if (obtainStyledAttributes.getBoolean(j.j.AppCompatTheme_windowActionModeOverlay, false)) {
                A(10);
            }
            this.D = obtainStyledAttributes.getBoolean(j.j.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            b0();
            this.f319f.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.f318e);
            if (this.E) {
                viewGroup = (ViewGroup) from.inflate(this.C ? j.g.abc_screen_simple_overlay_action_mode : j.g.abc_screen_simple, (ViewGroup) null);
            } else if (this.D) {
                viewGroup = (ViewGroup) from.inflate(j.g.abc_dialog_title_material, (ViewGroup) null);
                this.B = false;
                this.A = false;
            } else if (this.A) {
                TypedValue typedValue = new TypedValue();
                this.f318e.getTheme().resolveAttribute(j.a.actionBarTheme, typedValue, true);
                viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new o.d(this.f318e, typedValue.resourceId) : this.f318e).inflate(j.g.abc_screen_toolbar, (ViewGroup) null);
                androidx.appcompat.widget.o oVar = (androidx.appcompat.widget.o) viewGroup.findViewById(j.f.decor_content_parent);
                this.f325l = oVar;
                oVar.setWindowCallback(j0());
                if (this.B) {
                    this.f325l.k(109);
                }
                if (this.f338y) {
                    this.f325l.k(2);
                }
                if (this.f339z) {
                    this.f325l.k(5);
                }
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    x.F0(viewGroup, new c());
                } else if (viewGroup instanceof androidx.appcompat.widget.s) {
                    ((androidx.appcompat.widget.s) viewGroup).setOnFitSystemWindowsListener(new d());
                }
                if (this.f325l == null) {
                    this.f336w = (TextView) viewGroup.findViewById(j.f.title);
                }
                m0.c(viewGroup);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(j.f.action_bar_activity_content);
                ViewGroup viewGroup2 = (ViewGroup) this.f319f.findViewById(16908290);
                if (viewGroup2 != null) {
                    while (viewGroup2.getChildCount() > 0) {
                        View childAt = viewGroup2.getChildAt(0);
                        viewGroup2.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup2.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup2 instanceof FrameLayout) {
                        ((FrameLayout) viewGroup2).setForeground((Drawable) null);
                    }
                }
                this.f319f.setContentView(viewGroup);
                contentFrameLayout.setAttachListener(new e());
                return viewGroup;
            }
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.A + ", windowActionBarOverlay: " + this.B + ", android:windowIsFloating: " + this.D + ", windowActionModeOverlay: " + this.C + ", windowNoTitle: " + this.E + " }");
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    private void a0() {
        if (!this.f334u) {
            this.f335v = U();
            CharSequence i02 = i0();
            if (!TextUtils.isEmpty(i02)) {
                androidx.appcompat.widget.o oVar = this.f325l;
                if (oVar != null) {
                    oVar.setWindowTitle(i02);
                } else if (C0() != null) {
                    C0().t(i02);
                } else {
                    TextView textView = this.f336w;
                    if (textView != null) {
                        textView.setText(i02);
                    }
                }
            }
            L();
            A0(this.f335v);
            this.f334u = true;
            PanelFeatureState h02 = h0(0, false);
            if (this.M) {
                return;
            }
            if (h02 == null || h02.f349j == null) {
                o0(108);
            }
        }
    }

    private void b0() {
        if (this.f319f == null) {
            Object obj = this.f317d;
            if (obj instanceof Activity) {
                M(((Activity) obj).getWindow());
            }
        }
        if (this.f319f == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    private static Configuration d0(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (!(configuration2 == null || configuration.diff(configuration2) == 0)) {
            float f10 = configuration.fontScale;
            float f11 = configuration2.fontScale;
            if (f10 != f11) {
                configuration3.fontScale = f11;
            }
            int i10 = configuration.mcc;
            int i11 = configuration2.mcc;
            if (i10 != i11) {
                configuration3.mcc = i11;
            }
            int i12 = configuration.mnc;
            int i13 = configuration2.mnc;
            if (i12 != i13) {
                configuration3.mnc = i13;
            }
            int i14 = Build.VERSION.SDK_INT;
            if (i14 >= 24) {
                m.a(configuration, configuration2, configuration3);
            } else if (!w0.c.a(configuration.locale, configuration2.locale)) {
                configuration3.locale = configuration2.locale;
            }
            int i15 = configuration.touchscreen;
            int i16 = configuration2.touchscreen;
            if (i15 != i16) {
                configuration3.touchscreen = i16;
            }
            int i17 = configuration.keyboard;
            int i18 = configuration2.keyboard;
            if (i17 != i18) {
                configuration3.keyboard = i18;
            }
            int i19 = configuration.keyboardHidden;
            int i20 = configuration2.keyboardHidden;
            if (i19 != i20) {
                configuration3.keyboardHidden = i20;
            }
            int i21 = configuration.navigation;
            int i22 = configuration2.navigation;
            if (i21 != i22) {
                configuration3.navigation = i22;
            }
            int i23 = configuration.navigationHidden;
            int i24 = configuration2.navigationHidden;
            if (i23 != i24) {
                configuration3.navigationHidden = i24;
            }
            int i25 = configuration.orientation;
            int i26 = configuration2.orientation;
            if (i25 != i26) {
                configuration3.orientation = i26;
            }
            int i27 = configuration.screenLayout & 15;
            int i28 = configuration2.screenLayout;
            if (i27 != (i28 & 15)) {
                configuration3.screenLayout |= i28 & 15;
            }
            int i29 = configuration.screenLayout & 192;
            int i30 = configuration2.screenLayout;
            if (i29 != (i30 & 192)) {
                configuration3.screenLayout |= i30 & 192;
            }
            int i31 = configuration.screenLayout & 48;
            int i32 = configuration2.screenLayout;
            if (i31 != (i32 & 48)) {
                configuration3.screenLayout |= i32 & 48;
            }
            int i33 = configuration.screenLayout & 768;
            int i34 = configuration2.screenLayout;
            if (i33 != (i34 & 768)) {
                configuration3.screenLayout |= i34 & 768;
            }
            if (i14 >= 26) {
                n.a(configuration, configuration2, configuration3);
            }
            int i35 = configuration.uiMode & 15;
            int i36 = configuration2.uiMode;
            if (i35 != (i36 & 15)) {
                configuration3.uiMode |= i36 & 15;
            }
            int i37 = configuration.uiMode & 48;
            int i38 = configuration2.uiMode;
            if (i37 != (i38 & 48)) {
                configuration3.uiMode |= i38 & 48;
            }
            int i39 = configuration.screenWidthDp;
            int i40 = configuration2.screenWidthDp;
            if (i39 != i40) {
                configuration3.screenWidthDp = i40;
            }
            int i41 = configuration.screenHeightDp;
            int i42 = configuration2.screenHeightDp;
            if (i41 != i42) {
                configuration3.screenHeightDp = i42;
            }
            int i43 = configuration.smallestScreenWidthDp;
            int i44 = configuration2.smallestScreenWidthDp;
            if (i43 != i44) {
                configuration3.smallestScreenWidthDp = i44;
            }
            if (i14 >= 17) {
                k.b(configuration, configuration2, configuration3);
            }
        }
        return configuration3;
    }

    private q f0(Context context) {
        if (this.S == null) {
            this.S = new p(context);
        }
        return this.S;
    }

    private q g0(Context context) {
        if (this.R == null) {
            this.R = new r(l.a(context));
        }
        return this.R;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void k0() {
        /*
            r3 = this;
            r3.a0()
            boolean r0 = r3.A
            if (r0 == 0) goto L_0x0037
            androidx.appcompat.app.ActionBar r0 = r3.f322i
            if (r0 == 0) goto L_0x000c
            goto L_0x0037
        L_0x000c:
            java.lang.Object r0 = r3.f317d
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L_0x0020
            androidx.appcompat.app.m r0 = new androidx.appcompat.app.m
            java.lang.Object r1 = r3.f317d
            android.app.Activity r1 = (android.app.Activity) r1
            boolean r2 = r3.B
            r0.<init>(r1, r2)
        L_0x001d:
            r3.f322i = r0
            goto L_0x002e
        L_0x0020:
            boolean r0 = r0 instanceof android.app.Dialog
            if (r0 == 0) goto L_0x002e
            androidx.appcompat.app.m r0 = new androidx.appcompat.app.m
            java.lang.Object r1 = r3.f317d
            android.app.Dialog r1 = (android.app.Dialog) r1
            r0.<init>(r1)
            goto L_0x001d
        L_0x002e:
            androidx.appcompat.app.ActionBar r0 = r3.f322i
            if (r0 == 0) goto L_0x0037
            boolean r1 = r3.W
            r0.r(r1)
        L_0x0037:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.k0():void");
    }

    private boolean l0(PanelFeatureState panelFeatureState) {
        View view = panelFeatureState.f348i;
        if (view != null) {
            panelFeatureState.f347h = view;
            return true;
        } else if (panelFeatureState.f349j == null) {
            return false;
        } else {
            if (this.f327n == null) {
                this.f327n = new u();
            }
            View view2 = (View) panelFeatureState.a(this.f327n);
            panelFeatureState.f347h = view2;
            return view2 != null;
        }
    }

    private boolean m0(PanelFeatureState panelFeatureState) {
        panelFeatureState.d(e0());
        panelFeatureState.f346g = new t(panelFeatureState.f351l);
        panelFeatureState.f342c = 81;
        return true;
    }

    private boolean n0(PanelFeatureState panelFeatureState) {
        Context context = this.f318e;
        int i10 = panelFeatureState.f340a;
        if ((i10 == 0 || i10 == 108) && this.f325l != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(j.a.actionBarTheme, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(j.a.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(j.a.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                o.d dVar = new o.d(context, 0);
                dVar.getTheme().setTo(theme2);
                context = dVar;
            }
        }
        androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(context);
        eVar.V(this);
        panelFeatureState.c(eVar);
        return true;
    }

    private void o0(int i10) {
        this.U = (1 << i10) | this.U;
        if (!this.T) {
            x.j0(this.f319f.getDecorView(), this.V);
            this.T = true;
        }
    }

    private boolean p0() {
        if (!this.Q && (this.f317d instanceof Activity)) {
            PackageManager packageManager = this.f318e.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                int i10 = Build.VERSION.SDK_INT;
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.f318e, this.f317d.getClass()), i10 >= 29 ? 269221888 : i10 >= 24 ? 786432 : 0);
                this.P = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException e10) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e10);
                this.P = false;
            }
        }
        this.Q = true;
        return this.P;
    }

    private boolean u0(int i10, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        PanelFeatureState h02 = h0(i10, true);
        if (!h02.f354o) {
            return E0(h02, keyEvent);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x006a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean x0(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            o.b r0 = r4.f328o
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            r0 = 1
            androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r2 = r4.h0(r5, r0)
            if (r5 != 0) goto L_0x0043
            androidx.appcompat.widget.o r5 = r4.f325l
            if (r5 == 0) goto L_0x0043
            boolean r5 = r5.h()
            if (r5 == 0) goto L_0x0043
            android.content.Context r5 = r4.f318e
            android.view.ViewConfiguration r5 = android.view.ViewConfiguration.get(r5)
            boolean r5 = r5.hasPermanentMenuKey()
            if (r5 != 0) goto L_0x0043
            androidx.appcompat.widget.o r5 = r4.f325l
            boolean r5 = r5.b()
            if (r5 != 0) goto L_0x003c
            boolean r5 = r4.M
            if (r5 != 0) goto L_0x0062
            boolean r5 = r4.E0(r2, r6)
            if (r5 == 0) goto L_0x0062
            androidx.appcompat.widget.o r5 = r4.f325l
            boolean r0 = r5.g()
            goto L_0x0068
        L_0x003c:
            androidx.appcompat.widget.o r5 = r4.f325l
            boolean r0 = r5.f()
            goto L_0x0068
        L_0x0043:
            boolean r5 = r2.f354o
            if (r5 != 0) goto L_0x0064
            boolean r3 = r2.f353n
            if (r3 == 0) goto L_0x004c
            goto L_0x0064
        L_0x004c:
            boolean r5 = r2.f352m
            if (r5 == 0) goto L_0x0062
            boolean r5 = r2.f357r
            if (r5 == 0) goto L_0x005b
            r2.f352m = r1
            boolean r5 = r4.E0(r2, r6)
            goto L_0x005c
        L_0x005b:
            r5 = r0
        L_0x005c:
            if (r5 == 0) goto L_0x0062
            r4.B0(r2, r6)
            goto L_0x0068
        L_0x0062:
            r0 = r1
            goto L_0x0068
        L_0x0064:
            r4.S(r2, r0)
            r0 = r5
        L_0x0068:
            if (r0 == 0) goto L_0x0085
            android.content.Context r5 = r4.f318e
            android.content.Context r5 = r5.getApplicationContext()
            java.lang.String r6 = "audio"
            java.lang.Object r5 = r5.getSystemService(r6)
            android.media.AudioManager r5 = (android.media.AudioManager) r5
            if (r5 == 0) goto L_0x007e
            r5.playSoundEffect(r1)
            goto L_0x0085
        L_0x007e:
            java.lang.String r5 = "AppCompatDelegate"
            java.lang.String r6 = "Couldn't get audio manager"
            android.util.Log.w(r5, r6)
        L_0x0085:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.x0(int, android.view.KeyEvent):boolean");
    }

    public boolean A(int i10) {
        int G0 = G0(i10);
        if (this.E && G0 == 108) {
            return false;
        }
        if (this.A && G0 == 1) {
            this.A = false;
        }
        if (G0 == 1) {
            K0();
            this.E = true;
            return true;
        } else if (G0 == 2) {
            K0();
            this.f338y = true;
            return true;
        } else if (G0 == 5) {
            K0();
            this.f339z = true;
            return true;
        } else if (G0 == 10) {
            K0();
            this.C = true;
            return true;
        } else if (G0 == 108) {
            K0();
            this.A = true;
            return true;
        } else if (G0 != 109) {
            return this.f319f.requestFeature(G0);
        } else {
            K0();
            this.B = true;
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public void A0(ViewGroup viewGroup) {
    }

    public void C(int i10) {
        a0();
        ViewGroup viewGroup = (ViewGroup) this.f335v.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f318e).inflate(i10, viewGroup);
        this.f320g.a().onContentChanged();
    }

    /* access modifiers changed from: package-private */
    public final ActionBar C0() {
        return this.f322i;
    }

    public void D(View view) {
        a0();
        ViewGroup viewGroup = (ViewGroup) this.f335v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f320g.a().onContentChanged();
    }

    public void E(View view, ViewGroup.LayoutParams layoutParams) {
        a0();
        ViewGroup viewGroup = (ViewGroup) this.f335v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f320g.a().onContentChanged();
    }

    public void F(Toolbar toolbar) {
        Window window;
        Window.Callback callback;
        if (this.f317d instanceof Activity) {
            ActionBar n10 = n();
            if (!(n10 instanceof m)) {
                this.f323j = null;
                if (n10 != null) {
                    n10.n();
                }
                if (toolbar != null) {
                    j jVar = new j(toolbar, i0(), this.f320g);
                    this.f322i = jVar;
                    window = this.f319f;
                    callback = jVar.w();
                } else {
                    this.f322i = null;
                    window = this.f319f;
                    callback = this.f320g;
                }
                window.setCallback(callback);
                p();
                return;
            }
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
    }

    public void G(int i10) {
        this.O = i10;
    }

    public final void H(CharSequence charSequence) {
        this.f324k = charSequence;
        androidx.appcompat.widget.o oVar = this.f325l;
        if (oVar != null) {
            oVar.setWindowTitle(charSequence);
        } else if (C0() != null) {
            C0().t(charSequence);
        } else {
            TextView textView = this.f336w;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.f335v;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean H0() {
        /*
            r1 = this;
            boolean r0 = r1.f334u
            if (r0 == 0) goto L_0x0010
            android.view.ViewGroup r0 = r1.f335v
            if (r0 == 0) goto L_0x0010
            boolean r0 = androidx.core.view.x.V(r0)
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.H0():boolean");
    }

    public o.b I(b.a aVar) {
        c cVar;
        if (aVar != null) {
            o.b bVar = this.f328o;
            if (bVar != null) {
                bVar.c();
            }
            j jVar = new j(aVar);
            ActionBar n10 = n();
            if (n10 != null) {
                o.b u10 = n10.u(jVar);
                this.f328o = u10;
                if (!(u10 == null || (cVar = this.f321h) == null)) {
                    cVar.onSupportActionModeStarted(u10);
                }
            }
            if (this.f328o == null) {
                this.f328o = J0(jVar);
            }
            return this.f328o;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    public boolean J() {
        return K(true);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public o.b J0(o.b.a r8) {
        /*
            r7 = this;
            r7.Z()
            o.b r0 = r7.f328o
            if (r0 == 0) goto L_0x000a
            r0.c()
        L_0x000a:
            boolean r0 = r8 instanceof androidx.appcompat.app.AppCompatDelegateImpl.j
            if (r0 != 0) goto L_0x0014
            androidx.appcompat.app.AppCompatDelegateImpl$j r0 = new androidx.appcompat.app.AppCompatDelegateImpl$j
            r0.<init>(r8)
            r8 = r0
        L_0x0014:
            androidx.appcompat.app.c r0 = r7.f321h
            r1 = 0
            if (r0 == 0) goto L_0x0022
            boolean r2 = r7.M
            if (r2 != 0) goto L_0x0022
            o.b r0 = r0.onWindowStartingSupportActionMode(r8)     // Catch:{ AbstractMethodError -> 0x0022 }
            goto L_0x0023
        L_0x0022:
            r0 = r1
        L_0x0023:
            if (r0 == 0) goto L_0x0029
            r7.f328o = r0
            goto L_0x0162
        L_0x0029:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.f329p
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x00d4
            boolean r0 = r7.D
            if (r0 == 0) goto L_0x00b5
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            android.content.Context r4 = r7.f318e
            android.content.res.Resources$Theme r4 = r4.getTheme()
            int r5 = j.a.actionBarTheme
            r4.resolveAttribute(r5, r0, r3)
            int r5 = r0.resourceId
            if (r5 == 0) goto L_0x0068
            android.content.Context r5 = r7.f318e
            android.content.res.Resources r5 = r5.getResources()
            android.content.res.Resources$Theme r5 = r5.newTheme()
            r5.setTo(r4)
            int r4 = r0.resourceId
            r5.applyStyle(r4, r3)
            o.d r4 = new o.d
            android.content.Context r6 = r7.f318e
            r4.<init>((android.content.Context) r6, (int) r2)
            android.content.res.Resources$Theme r6 = r4.getTheme()
            r6.setTo(r5)
            goto L_0x006a
        L_0x0068:
            android.content.Context r4 = r7.f318e
        L_0x006a:
            androidx.appcompat.widget.ActionBarContextView r5 = new androidx.appcompat.widget.ActionBarContextView
            r5.<init>(r4)
            r7.f329p = r5
            android.widget.PopupWindow r5 = new android.widget.PopupWindow
            int r6 = j.a.actionModePopupWindowStyle
            r5.<init>(r4, r1, r6)
            r7.f330q = r5
            r6 = 2
            androidx.core.widget.j.b(r5, r6)
            android.widget.PopupWindow r5 = r7.f330q
            androidx.appcompat.widget.ActionBarContextView r6 = r7.f329p
            r5.setContentView(r6)
            android.widget.PopupWindow r5 = r7.f330q
            r6 = -1
            r5.setWidth(r6)
            android.content.res.Resources$Theme r5 = r4.getTheme()
            int r6 = j.a.actionBarSize
            r5.resolveAttribute(r6, r0, r3)
            int r0 = r0.data
            android.content.res.Resources r4 = r4.getResources()
            android.util.DisplayMetrics r4 = r4.getDisplayMetrics()
            int r0 = android.util.TypedValue.complexToDimensionPixelSize(r0, r4)
            androidx.appcompat.widget.ActionBarContextView r4 = r7.f329p
            r4.setContentHeight(r0)
            android.widget.PopupWindow r0 = r7.f330q
            r4 = -2
            r0.setHeight(r4)
            androidx.appcompat.app.AppCompatDelegateImpl$f r0 = new androidx.appcompat.app.AppCompatDelegateImpl$f
            r0.<init>()
            r7.f331r = r0
            goto L_0x00d4
        L_0x00b5:
            android.view.ViewGroup r0 = r7.f335v
            int r4 = j.f.action_mode_bar_stub
            android.view.View r0 = r0.findViewById(r4)
            androidx.appcompat.widget.ViewStubCompat r0 = (androidx.appcompat.widget.ViewStubCompat) r0
            if (r0 == 0) goto L_0x00d4
            android.content.Context r4 = r7.e0()
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)
            r0.setLayoutInflater(r4)
            android.view.View r0 = r0.a()
            androidx.appcompat.widget.ActionBarContextView r0 = (androidx.appcompat.widget.ActionBarContextView) r0
            r7.f329p = r0
        L_0x00d4:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.f329p
            if (r0 == 0) goto L_0x0162
            r7.Z()
            androidx.appcompat.widget.ActionBarContextView r0 = r7.f329p
            r0.k()
            o.e r0 = new o.e
            androidx.appcompat.widget.ActionBarContextView r4 = r7.f329p
            android.content.Context r4 = r4.getContext()
            androidx.appcompat.widget.ActionBarContextView r5 = r7.f329p
            android.widget.PopupWindow r6 = r7.f330q
            if (r6 != 0) goto L_0x00ef
            goto L_0x00f0
        L_0x00ef:
            r3 = r2
        L_0x00f0:
            r0.<init>(r4, r5, r8, r3)
            android.view.Menu r3 = r0.e()
            boolean r8 = r8.a(r0, r3)
            if (r8 == 0) goto L_0x0160
            r0.k()
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f329p
            r8.h(r0)
            r7.f328o = r0
            boolean r8 = r7.H0()
            r0 = 1065353216(0x3f800000, float:1.0)
            if (r8 == 0) goto L_0x012a
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f329p
            r1 = 0
            r8.setAlpha(r1)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f329p
            androidx.core.view.b0 r8 = androidx.core.view.x.d(r8)
            androidx.core.view.b0 r8 = r8.a(r0)
            r7.f332s = r8
            androidx.appcompat.app.AppCompatDelegateImpl$g r0 = new androidx.appcompat.app.AppCompatDelegateImpl$g
            r0.<init>()
            r8.f(r0)
            goto L_0x0150
        L_0x012a:
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f329p
            r8.setAlpha(r0)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f329p
            r8.setVisibility(r2)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f329p
            r0 = 32
            r8.sendAccessibilityEvent(r0)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f329p
            android.view.ViewParent r8 = r8.getParent()
            boolean r8 = r8 instanceof android.view.View
            if (r8 == 0) goto L_0x0150
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f329p
            android.view.ViewParent r8 = r8.getParent()
            android.view.View r8 = (android.view.View) r8
            androidx.core.view.x.o0(r8)
        L_0x0150:
            android.widget.PopupWindow r8 = r7.f330q
            if (r8 == 0) goto L_0x0162
            android.view.Window r8 = r7.f319f
            android.view.View r8 = r8.getDecorView()
            java.lang.Runnable r0 = r7.f331r
            r8.post(r0)
            goto L_0x0162
        L_0x0160:
            r7.f328o = r1
        L_0x0162:
            o.b r8 = r7.f328o
            if (r8 == 0) goto L_0x016d
            androidx.appcompat.app.c r0 = r7.f321h
            if (r0 == 0) goto L_0x016d
            r0.onSupportActionModeStarted(r8)
        L_0x016d:
            o.b r8 = r7.f328o
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.J0(o.b$a):o.b");
    }

    /* access modifiers changed from: package-private */
    public void O(int i10, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i10 >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.G;
                if (i10 < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i10];
                }
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.f349j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.f354o) && !this.M) {
            this.f320g.a().onPanelClosed(i10, menu);
        }
    }

    /* access modifiers changed from: package-private */
    public final int O0(f0 f0Var, Rect rect) {
        boolean z10;
        boolean z11;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i10;
        int i11 = 0;
        int m10 = f0Var != null ? f0Var.m() : rect != null ? rect.top : 0;
        ActionBarContextView actionBarContextView = this.f329p;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z10 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f329p.getLayoutParams();
            boolean z12 = true;
            if (this.f329p.isShown()) {
                if (this.X == null) {
                    this.X = new Rect();
                    this.Y = new Rect();
                }
                Rect rect2 = this.X;
                Rect rect3 = this.Y;
                if (f0Var == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(f0Var.k(), f0Var.m(), f0Var.l(), f0Var.j());
                }
                m0.a(this.f335v, rect2, rect3);
                int i12 = rect2.top;
                int i13 = rect2.left;
                int i14 = rect2.right;
                f0 K2 = x.K(this.f335v);
                int k10 = K2 == null ? 0 : K2.k();
                int l10 = K2 == null ? 0 : K2.l();
                if (marginLayoutParams2.topMargin == i12 && marginLayoutParams2.leftMargin == i13 && marginLayoutParams2.rightMargin == i14) {
                    z11 = false;
                } else {
                    marginLayoutParams2.topMargin = i12;
                    marginLayoutParams2.leftMargin = i13;
                    marginLayoutParams2.rightMargin = i14;
                    z11 = true;
                }
                if (i12 <= 0 || this.f337x != null) {
                    View view = this.f337x;
                    if (!(view == null || ((marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()).height == (i10 = marginLayoutParams2.topMargin) && marginLayoutParams.leftMargin == k10 && marginLayoutParams.rightMargin == l10))) {
                        marginLayoutParams.height = i10;
                        marginLayoutParams.leftMargin = k10;
                        marginLayoutParams.rightMargin = l10;
                        this.f337x.setLayoutParams(marginLayoutParams);
                    }
                } else {
                    View view2 = new View(this.f318e);
                    this.f337x = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams2.topMargin, 51);
                    layoutParams.leftMargin = k10;
                    layoutParams.rightMargin = l10;
                    this.f335v.addView(this.f337x, -1, layoutParams);
                }
                View view3 = this.f337x;
                if (view3 == null) {
                    z12 = false;
                }
                if (z12 && view3.getVisibility() != 0) {
                    P0(this.f337x);
                }
                if (!this.C && z12) {
                    m10 = 0;
                }
                z10 = z12;
                z12 = z11;
            } else if (marginLayoutParams2.topMargin != 0) {
                marginLayoutParams2.topMargin = 0;
                z10 = false;
            } else {
                z10 = false;
                z12 = false;
            }
            if (z12) {
                this.f329p.setLayoutParams(marginLayoutParams2);
            }
        }
        View view4 = this.f337x;
        if (view4 != null) {
            if (!z10) {
                i11 = 8;
            }
            view4.setVisibility(i11);
        }
        return m10;
    }

    /* access modifiers changed from: package-private */
    public void P(androidx.appcompat.view.menu.e eVar) {
        if (!this.F) {
            this.F = true;
            this.f325l.l();
            Window.Callback j02 = j0();
            if (j02 != null && !this.M) {
                j02.onPanelClosed(108, eVar);
            }
            this.F = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void R(int i10) {
        S(h0(i10, true), true);
    }

    /* access modifiers changed from: package-private */
    public void S(PanelFeatureState panelFeatureState, boolean z10) {
        ViewGroup viewGroup;
        androidx.appcompat.widget.o oVar;
        if (!z10 || panelFeatureState.f340a != 0 || (oVar = this.f325l) == null || !oVar.b()) {
            WindowManager windowManager = (WindowManager) this.f318e.getSystemService("window");
            if (!(windowManager == null || !panelFeatureState.f354o || (viewGroup = panelFeatureState.f346g) == null)) {
                windowManager.removeView(viewGroup);
                if (z10) {
                    O(panelFeatureState.f340a, panelFeatureState, (Menu) null);
                }
            }
            panelFeatureState.f352m = false;
            panelFeatureState.f353n = false;
            panelFeatureState.f354o = false;
            panelFeatureState.f347h = null;
            panelFeatureState.f356q = true;
            if (this.H == panelFeatureState) {
                this.H = null;
                return;
            }
            return;
        }
        P(panelFeatureState.f349j);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0079, code lost:
        if (((org.xmlpull.v1.XmlPullParser) r15).getDepth() > 1) goto L_0x0083;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View V(android.view.View r12, java.lang.String r13, android.content.Context r14, android.util.AttributeSet r15) {
        /*
            r11 = this;
            androidx.appcompat.app.g r0 = r11.Z
            r1 = 0
            if (r0 != 0) goto L_0x0054
            android.content.Context r0 = r11.f318e
            int[] r2 = j.j.AppCompatTheme
            android.content.res.TypedArray r0 = r0.obtainStyledAttributes(r2)
            int r2 = j.j.AppCompatTheme_viewInflaterClass
            java.lang.String r0 = r0.getString(r2)
            if (r0 != 0) goto L_0x001d
            androidx.appcompat.app.g r0 = new androidx.appcompat.app.g
            r0.<init>()
        L_0x001a:
            r11.Z = r0
            goto L_0x0054
        L_0x001d:
            java.lang.Class r2 = java.lang.Class.forName(r0)     // Catch:{ all -> 0x0032 }
            java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch:{ all -> 0x0032 }
            java.lang.reflect.Constructor r2 = r2.getDeclaredConstructor(r3)     // Catch:{ all -> 0x0032 }
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ all -> 0x0032 }
            java.lang.Object r2 = r2.newInstance(r3)     // Catch:{ all -> 0x0032 }
            androidx.appcompat.app.g r2 = (androidx.appcompat.app.g) r2     // Catch:{ all -> 0x0032 }
            r11.Z = r2     // Catch:{ all -> 0x0032 }
            goto L_0x0054
        L_0x0032:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Failed to instantiate custom view inflater "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = ". Falling back to default."
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            java.lang.String r3 = "AppCompatDelegate"
            android.util.Log.i(r3, r0, r2)
            androidx.appcompat.app.g r0 = new androidx.appcompat.app.g
            r0.<init>()
            goto L_0x001a
        L_0x0054:
            boolean r8 = f314c0
            r0 = 1
            if (r8 == 0) goto L_0x0084
            androidx.appcompat.app.h r2 = r11.f316a0
            if (r2 != 0) goto L_0x0064
            androidx.appcompat.app.h r2 = new androidx.appcompat.app.h
            r2.<init>()
            r11.f316a0 = r2
        L_0x0064:
            androidx.appcompat.app.h r2 = r11.f316a0
            boolean r2 = r2.a(r15)
            if (r2 == 0) goto L_0x006e
            r7 = r0
            goto L_0x0085
        L_0x006e:
            boolean r2 = r15 instanceof org.xmlpull.v1.XmlPullParser
            if (r2 == 0) goto L_0x007c
            r2 = r15
            org.xmlpull.v1.XmlPullParser r2 = (org.xmlpull.v1.XmlPullParser) r2
            int r2 = r2.getDepth()
            if (r2 <= r0) goto L_0x0084
            goto L_0x0083
        L_0x007c:
            r0 = r12
            android.view.ViewParent r0 = (android.view.ViewParent) r0
            boolean r0 = r11.I0(r0)
        L_0x0083:
            r1 = r0
        L_0x0084:
            r7 = r1
        L_0x0085:
            androidx.appcompat.app.g r2 = r11.Z
            r9 = 1
            boolean r10 = androidx.appcompat.widget.l0.c()
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            android.view.View r12 = r2.q(r3, r4, r5, r6, r7, r8, r9, r10)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.V(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    /* access modifiers changed from: package-private */
    public void W() {
        androidx.appcompat.view.menu.e eVar;
        androidx.appcompat.widget.o oVar = this.f325l;
        if (oVar != null) {
            oVar.l();
        }
        if (this.f330q != null) {
            this.f319f.getDecorView().removeCallbacks(this.f331r);
            if (this.f330q.isShowing()) {
                try {
                    this.f330q.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.f330q = null;
        }
        Z();
        PanelFeatureState h02 = h0(0, false);
        if (h02 != null && (eVar = h02.f349j) != null) {
            eVar.close();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean X(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f317d;
        boolean z10 = true;
        if (((obj instanceof g.a) || (obj instanceof e)) && (decorView = this.f319f.getDecorView()) != null && androidx.core.view.g.d(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f320g.a().dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z10 = false;
        }
        return z10 ? t0(keyCode, keyEvent) : w0(keyCode, keyEvent);
    }

    /* access modifiers changed from: package-private */
    public void Y(int i10) {
        PanelFeatureState h02;
        PanelFeatureState h03 = h0(i10, true);
        if (h03.f349j != null) {
            Bundle bundle = new Bundle();
            h03.f349j.T(bundle);
            if (bundle.size() > 0) {
                h03.f358s = bundle;
            }
            h03.f349j.h0();
            h03.f349j.clear();
        }
        h03.f357r = true;
        h03.f356q = true;
        if ((i10 == 108 || i10 == 0) && this.f325l != null && (h02 = h0(0, false)) != null) {
            h02.f352m = false;
            E0(h02, (KeyEvent) null);
        }
    }

    /* access modifiers changed from: package-private */
    public void Z() {
        b0 b0Var = this.f332s;
        if (b0Var != null) {
            b0Var.b();
        }
    }

    public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        PanelFeatureState c02;
        Window.Callback j02 = j0();
        if (j02 == null || this.M || (c02 = c0(eVar.F())) == null) {
            return false;
        }
        return j02.onMenuItemSelected(c02.f340a, menuItem);
    }

    public void b(androidx.appcompat.view.menu.e eVar) {
        F0(true);
    }

    /* access modifiers changed from: package-private */
    public PanelFeatureState c0(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.G;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i10 = 0; i10 < length; i10++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i10];
            if (panelFeatureState != null && panelFeatureState.f349j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    public void d(View view, ViewGroup.LayoutParams layoutParams) {
        a0();
        ((ViewGroup) this.f335v.findViewById(16908290)).addView(view, layoutParams);
        this.f320g.a().onContentChanged();
    }

    /* access modifiers changed from: package-private */
    public final Context e0() {
        ActionBar n10 = n();
        Context k10 = n10 != null ? n10.k() : null;
        return k10 == null ? this.f318e : k10;
    }

    public Context f(Context context) {
        boolean z10 = true;
        this.J = true;
        int r02 = r0(context, N());
        Configuration configuration = null;
        if (f313b1 && (context instanceof ContextThemeWrapper)) {
            try {
                s.a((ContextThemeWrapper) context, T(context, r02, (Configuration) null));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof o.d) {
            try {
                ((o.d) context).a(T(context, r02, (Configuration) null));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!f311a1) {
            return super.f(context);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            Configuration configuration2 = new Configuration();
            configuration2.uiMode = -1;
            configuration2.fontScale = 0.0f;
            Configuration configuration3 = k.a(context, configuration2).getResources().getConfiguration();
            Configuration configuration4 = context.getResources().getConfiguration();
            configuration3.uiMode = configuration4.uiMode;
            if (!configuration3.equals(configuration4)) {
                configuration = d0(configuration3, configuration4);
            }
        }
        Configuration T2 = T(context, r02, configuration);
        o.d dVar = new o.d(context, j.i.Theme_AppCompat_Empty);
        dVar.a(T2);
        boolean z11 = false;
        try {
            if (context.getTheme() == null) {
                z10 = false;
            }
            z11 = z10;
        } catch (NullPointerException unused3) {
        }
        if (z11) {
            f.d.a(dVar.getTheme());
        }
        return super.f(dVar);
    }

    /* access modifiers changed from: protected */
    public PanelFeatureState h0(int i10, boolean z10) {
        PanelFeatureState[] panelFeatureStateArr = this.G;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i10) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[(i10 + 1)];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.G = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i10];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i10);
        panelFeatureStateArr[i10] = panelFeatureState2;
        return panelFeatureState2;
    }

    public <T extends View> T i(int i10) {
        a0();
        return this.f319f.findViewById(i10);
    }

    /* access modifiers changed from: package-private */
    public final CharSequence i0() {
        Object obj = this.f317d;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.f324k;
    }

    /* access modifiers changed from: package-private */
    public final Window.Callback j0() {
        return this.f319f.getCallback();
    }

    public final a k() {
        return new h(this);
    }

    public int l() {
        return this.N;
    }

    public MenuInflater m() {
        if (this.f323j == null) {
            k0();
            ActionBar actionBar = this.f322i;
            this.f323j = new o.g(actionBar != null ? actionBar.k() : this.f318e);
        }
        return this.f323j;
    }

    public ActionBar n() {
        k0();
        return this.f322i;
    }

    public void o() {
        LayoutInflater from = LayoutInflater.from(this.f318e);
        if (from.getFactory() == null) {
            androidx.core.view.h.b(from, this);
        } else if (!(from.getFactory2() instanceof AppCompatDelegateImpl)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return V(view, str, context, attributeSet);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }

    public void p() {
        ActionBar n10 = n();
        if (n10 == null || !n10.l()) {
            o0(0);
        }
    }

    public void q(Configuration configuration) {
        ActionBar n10;
        if (this.A && this.f334u && (n10 = n()) != null) {
            n10.m(configuration);
        }
        androidx.appcompat.widget.f.b().g(this.f318e);
        K(false);
    }

    public boolean q0() {
        return this.f333t;
    }

    public void r(Bundle bundle) {
        this.J = true;
        K(false);
        b0();
        Object obj = this.f317d;
        if (obj instanceof Activity) {
            String str = null;
            try {
                str = androidx.core.app.f.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                ActionBar C0 = C0();
                if (C0 == null) {
                    this.W = true;
                } else {
                    C0.r(true);
                }
            }
            d.c(this);
        }
        this.K = true;
    }

    /* access modifiers changed from: package-private */
    public int r0(Context context, int i10) {
        q g02;
        if (i10 == -100) {
            return -1;
        }
        if (i10 != -1) {
            if (i10 != 0) {
                if (!(i10 == 1 || i10 == 2)) {
                    if (i10 == 3) {
                        g02 = f0(context);
                    } else {
                        throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                    }
                }
            } else if (Build.VERSION.SDK_INT >= 23 && ((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                return -1;
            } else {
                g02 = g0(context);
            }
            return g02.c();
        }
        return i10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void s() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f317d
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L_0x0009
            androidx.appcompat.app.d.y(r3)
        L_0x0009:
            boolean r0 = r3.T
            if (r0 == 0) goto L_0x0018
            android.view.Window r0 = r3.f319f
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.V
            r0.removeCallbacks(r1)
        L_0x0018:
            r0 = 0
            r3.L = r0
            r0 = 1
            r3.M = r0
            int r0 = r3.N
            r1 = -100
            if (r0 == r1) goto L_0x0048
            java.lang.Object r0 = r3.f317d
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L_0x0048
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L_0x0048
            c0.g<java.lang.String, java.lang.Integer> r0 = f312b0
            java.lang.Object r1 = r3.f317d
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.N
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L_0x0057
        L_0x0048:
            c0.g<java.lang.String, java.lang.Integer> r0 = f312b0
            java.lang.Object r1 = r3.f317d
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L_0x0057:
            androidx.appcompat.app.ActionBar r0 = r3.f322i
            if (r0 == 0) goto L_0x005e
            r0.n()
        L_0x005e:
            r3.Q()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.s():void");
    }

    /* access modifiers changed from: package-private */
    public boolean s0() {
        o.b bVar = this.f328o;
        if (bVar != null) {
            bVar.c();
            return true;
        }
        ActionBar n10 = n();
        return n10 != null && n10.h();
    }

    public void t(Bundle bundle) {
        a0();
    }

    /* access modifiers changed from: package-private */
    public boolean t0(int i10, KeyEvent keyEvent) {
        boolean z10 = true;
        if (i10 == 4) {
            if ((keyEvent.getFlags() & 128) == 0) {
                z10 = false;
            }
            this.I = z10;
        } else if (i10 == 82) {
            u0(0, keyEvent);
            return true;
        }
        return false;
    }

    public void u() {
        ActionBar n10 = n();
        if (n10 != null) {
            n10.s(true);
        }
    }

    public void v(Bundle bundle) {
    }

    /* access modifiers changed from: package-private */
    public boolean v0(int i10, KeyEvent keyEvent) {
        ActionBar n10 = n();
        if (n10 != null && n10.o(i10, keyEvent)) {
            return true;
        }
        PanelFeatureState panelFeatureState = this.H;
        if (panelFeatureState == null || !D0(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.H == null) {
                PanelFeatureState h02 = h0(0, true);
                E0(h02, keyEvent);
                boolean D0 = D0(h02, keyEvent.getKeyCode(), keyEvent, 1);
                h02.f352m = false;
                if (D0) {
                    return true;
                }
            }
            return false;
        }
        PanelFeatureState panelFeatureState2 = this.H;
        if (panelFeatureState2 != null) {
            panelFeatureState2.f353n = true;
        }
        return true;
    }

    public void w() {
        this.L = true;
        J();
    }

    /* access modifiers changed from: package-private */
    public boolean w0(int i10, KeyEvent keyEvent) {
        if (i10 == 4) {
            boolean z10 = this.I;
            this.I = false;
            PanelFeatureState h02 = h0(0, false);
            if (h02 != null && h02.f354o) {
                if (!z10) {
                    S(h02, true);
                }
                return true;
            } else if (s0()) {
                return true;
            }
        } else if (i10 == 82) {
            x0(0, keyEvent);
            return true;
        }
        return false;
    }

    public void x() {
        this.L = false;
        ActionBar n10 = n();
        if (n10 != null) {
            n10.s(false);
        }
    }

    /* access modifiers changed from: package-private */
    public void y0(int i10) {
        ActionBar n10;
        if (i10 == 108 && (n10 = n()) != null) {
            n10.i(true);
        }
    }

    /* access modifiers changed from: package-private */
    public void z0(int i10) {
        if (i10 == 108) {
            ActionBar n10 = n();
            if (n10 != null) {
                n10.i(false);
            }
        } else if (i10 == 0) {
            PanelFeatureState h02 = h0(i10, true);
            if (h02.f354o) {
                S(h02, false);
            }
        }
    }
}
