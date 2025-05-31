package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.lifecycle.a0;
import androidx.lifecycle.d0;
import androidx.lifecycle.f0;
import androidx.lifecycle.g;
import androidx.lifecycle.g0;
import androidx.lifecycle.h;
import androidx.lifecycle.p;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.b;
import androidx.savedstate.c;

class w implements g, c, g0 {

    /* renamed from: a  reason: collision with root package name */
    private final Fragment f2910a;

    /* renamed from: b  reason: collision with root package name */
    private final f0 f2911b;

    /* renamed from: c  reason: collision with root package name */
    private d0.b f2912c;

    /* renamed from: d  reason: collision with root package name */
    private p f2913d = null;

    /* renamed from: e  reason: collision with root package name */
    private b f2914e = null;

    w(Fragment fragment, f0 f0Var) {
        this.f2910a = fragment;
        this.f2911b = f0Var;
    }

    /* access modifiers changed from: package-private */
    public void a(h.b bVar) {
        this.f2913d.h(bVar);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (this.f2913d == null) {
            this.f2913d = new p(this);
            this.f2914e = b.a(this);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        return this.f2913d != null;
    }

    /* access modifiers changed from: package-private */
    public void d(Bundle bundle) {
        this.f2914e.c(bundle);
    }

    /* access modifiers changed from: package-private */
    public void e(Bundle bundle) {
        this.f2914e.d(bundle);
    }

    /* access modifiers changed from: package-private */
    public void f(h.c cVar) {
        this.f2913d.o(cVar);
    }

    public d0.b getDefaultViewModelProviderFactory() {
        d0.b defaultViewModelProviderFactory = this.f2910a.getDefaultViewModelProviderFactory();
        if (!defaultViewModelProviderFactory.equals(this.f2910a.mDefaultFactory)) {
            this.f2912c = defaultViewModelProviderFactory;
            return defaultViewModelProviderFactory;
        }
        if (this.f2912c == null) {
            Application application = null;
            Context context = this.f2910a.requireContext().getApplicationContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    break;
                } else if (context instanceof Application) {
                    application = (Application) context;
                    break;
                } else {
                    context = ((ContextWrapper) context).getBaseContext();
                }
            }
            this.f2912c = new a0(application, this, this.f2910a.getArguments());
        }
        return this.f2912c;
    }

    public h getLifecycle() {
        b();
        return this.f2913d;
    }

    public SavedStateRegistry getSavedStateRegistry() {
        b();
        return this.f2914e.b();
    }

    public f0 getViewModelStore() {
        b();
        return this.f2911b;
    }
}
