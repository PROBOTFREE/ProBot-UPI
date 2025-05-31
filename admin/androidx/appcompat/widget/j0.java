package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.x;
import androidx.core.view.y;

class j0 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: j  reason: collision with root package name */
    private static j0 f1115j;

    /* renamed from: k  reason: collision with root package name */
    private static j0 f1116k;

    /* renamed from: a  reason: collision with root package name */
    private final View f1117a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f1118b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1119c;

    /* renamed from: d  reason: collision with root package name */
    private final Runnable f1120d = new a();

    /* renamed from: e  reason: collision with root package name */
    private final Runnable f1121e = new b();

    /* renamed from: f  reason: collision with root package name */
    private int f1122f;

    /* renamed from: g  reason: collision with root package name */
    private int f1123g;

    /* renamed from: h  reason: collision with root package name */
    private k0 f1124h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1125i;

    class a implements Runnable {
        a() {
        }

        public void run() {
            j0.this.g(false);
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            j0.this.c();
        }
    }

    private j0(View view, CharSequence charSequence) {
        this.f1117a = view;
        this.f1118b = charSequence;
        this.f1119c = y.c(ViewConfiguration.get(view.getContext()));
        b();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    private void a() {
        this.f1117a.removeCallbacks(this.f1120d);
    }

    private void b() {
        this.f1122f = Integer.MAX_VALUE;
        this.f1123g = Integer.MAX_VALUE;
    }

    private void d() {
        this.f1117a.postDelayed(this.f1120d, (long) ViewConfiguration.getLongPressTimeout());
    }

    private static void e(j0 j0Var) {
        j0 j0Var2 = f1115j;
        if (j0Var2 != null) {
            j0Var2.a();
        }
        f1115j = j0Var;
        if (j0Var != null) {
            j0Var.d();
        }
    }

    public static void f(View view, CharSequence charSequence) {
        j0 j0Var = f1115j;
        if (j0Var != null && j0Var.f1117a == view) {
            e((j0) null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            j0 j0Var2 = f1116k;
            if (j0Var2 != null && j0Var2.f1117a == view) {
                j0Var2.c();
            }
            view.setOnLongClickListener((View.OnLongClickListener) null);
            view.setLongClickable(false);
            view.setOnHoverListener((View.OnHoverListener) null);
            return;
        }
        new j0(view, charSequence);
    }

    private boolean h(MotionEvent motionEvent) {
        int x10 = (int) motionEvent.getX();
        int y10 = (int) motionEvent.getY();
        if (Math.abs(x10 - this.f1122f) <= this.f1119c && Math.abs(y10 - this.f1123g) <= this.f1119c) {
            return false;
        }
        this.f1122f = x10;
        this.f1123g = y10;
        return true;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (f1116k == this) {
            f1116k = null;
            k0 k0Var = this.f1124h;
            if (k0Var != null) {
                k0Var.c();
                this.f1124h = null;
                b();
                this.f1117a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f1115j == this) {
            e((j0) null);
        }
        this.f1117a.removeCallbacks(this.f1121e);
    }

    /* access modifiers changed from: package-private */
    public void g(boolean z10) {
        long j10;
        if (x.U(this.f1117a)) {
            e((j0) null);
            j0 j0Var = f1116k;
            if (j0Var != null) {
                j0Var.c();
            }
            f1116k = this;
            this.f1125i = z10;
            k0 k0Var = new k0(this.f1117a.getContext());
            this.f1124h = k0Var;
            k0Var.e(this.f1117a, this.f1122f, this.f1123g, this.f1125i, this.f1118b);
            this.f1117a.addOnAttachStateChangeListener(this);
            if (this.f1125i) {
                j10 = 2500;
            } else {
                j10 = ((x.O(this.f1117a) & 1) == 1 ? 3000 : 15000) - ((long) ViewConfiguration.getLongPressTimeout());
            }
            this.f1117a.removeCallbacks(this.f1121e);
            this.f1117a.postDelayed(this.f1121e, j10);
        }
    }

    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f1124h != null && this.f1125i) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f1117a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                b();
                c();
            }
        } else if (this.f1117a.isEnabled() && this.f1124h == null && h(motionEvent)) {
            e(this);
        }
        return false;
    }

    public boolean onLongClick(View view) {
        this.f1122f = view.getWidth() / 2;
        this.f1123g = view.getHeight() / 2;
        g(true);
        return true;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        c();
    }
}
