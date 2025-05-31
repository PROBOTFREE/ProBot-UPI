package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.h;
import androidx.lifecycle.y;

public class x implements o {

    /* renamed from: i  reason: collision with root package name */
    private static final x f3048i = new x();

    /* renamed from: a  reason: collision with root package name */
    private int f3049a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f3050b = 0;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3051c = true;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3052d = true;

    /* renamed from: e  reason: collision with root package name */
    private Handler f3053e;

    /* renamed from: f  reason: collision with root package name */
    private final p f3054f = new p(this);

    /* renamed from: g  reason: collision with root package name */
    private Runnable f3055g = new a();

    /* renamed from: h  reason: collision with root package name */
    y.a f3056h = new b();

    class a implements Runnable {
        a() {
        }

        public void run() {
            x.this.f();
            x.this.g();
        }
    }

    class b implements y.a {
        b() {
        }

        public void a() {
            x.this.c();
        }

        public void b() {
            x.this.b();
        }

        public void c() {
        }
    }

    class c extends d {
        c() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            y.f(activity).h(x.this.f3056h);
        }

        public void onActivityPaused(Activity activity) {
            x.this.a();
        }

        public void onActivityStopped(Activity activity) {
            x.this.d();
        }
    }

    private x() {
    }

    static void h(Context context) {
        f3048i.e(context);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        int i10 = this.f3050b - 1;
        this.f3050b = i10;
        if (i10 == 0) {
            this.f3053e.postDelayed(this.f3055g, 700);
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        int i10 = this.f3050b + 1;
        this.f3050b = i10;
        if (i10 != 1) {
            return;
        }
        if (this.f3051c) {
            this.f3054f.h(h.b.ON_RESUME);
            this.f3051c = false;
            return;
        }
        this.f3053e.removeCallbacks(this.f3055g);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        int i10 = this.f3049a + 1;
        this.f3049a = i10;
        if (i10 == 1 && this.f3052d) {
            this.f3054f.h(h.b.ON_START);
            this.f3052d = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f3049a--;
        g();
    }

    /* access modifiers changed from: package-private */
    public void e(Context context) {
        this.f3053e = new Handler();
        this.f3054f.h(h.b.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new c());
    }

    /* access modifiers changed from: package-private */
    public void f() {
        if (this.f3050b == 0) {
            this.f3051c = true;
            this.f3054f.h(h.b.ON_PAUSE);
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        if (this.f3049a == 0 && this.f3051c) {
            this.f3054f.h(h.b.ON_STOP);
            this.f3052d = true;
        }
    }

    public h getLifecycle() {
        return this.f3054f;
    }
}
