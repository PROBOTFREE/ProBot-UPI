package androidx.navigation;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.a0;
import androidx.lifecycle.d0;
import androidx.lifecycle.f0;
import androidx.lifecycle.g;
import androidx.lifecycle.g0;
import androidx.lifecycle.h;
import androidx.lifecycle.o;
import androidx.lifecycle.p;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.b;
import androidx.savedstate.c;
import java.util.UUID;

public final class e implements o, g0, g, c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f3127a;

    /* renamed from: b  reason: collision with root package name */
    private final i f3128b;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f3129c;

    /* renamed from: d  reason: collision with root package name */
    private final p f3130d;

    /* renamed from: e  reason: collision with root package name */
    private final b f3131e;

    /* renamed from: f  reason: collision with root package name */
    final UUID f3132f;

    /* renamed from: g  reason: collision with root package name */
    private h.c f3133g;

    /* renamed from: h  reason: collision with root package name */
    private h.c f3134h;

    /* renamed from: i  reason: collision with root package name */
    private f f3135i;

    /* renamed from: j  reason: collision with root package name */
    private d0.b f3136j;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3137a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.lifecycle.h$b[] r0 = androidx.lifecycle.h.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3137a = r0
                androidx.lifecycle.h$b r1 = androidx.lifecycle.h.b.ON_CREATE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3137a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.lifecycle.h$b r1 = androidx.lifecycle.h.b.ON_STOP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f3137a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.lifecycle.h$b r1 = androidx.lifecycle.h.b.ON_START     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f3137a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.lifecycle.h$b r1 = androidx.lifecycle.h.b.ON_PAUSE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f3137a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.lifecycle.h$b r1 = androidx.lifecycle.h.b.ON_RESUME     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f3137a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.lifecycle.h$b r1 = androidx.lifecycle.h.b.ON_DESTROY     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f3137a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.lifecycle.h$b r1 = androidx.lifecycle.h.b.ON_ANY     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.e.a.<clinit>():void");
        }
    }

    e(Context context, i iVar, Bundle bundle, o oVar, f fVar) {
        this(context, iVar, bundle, oVar, fVar, UUID.randomUUID(), (Bundle) null);
    }

    e(Context context, i iVar, Bundle bundle, o oVar, f fVar, UUID uuid, Bundle bundle2) {
        this.f3130d = new p(this);
        b a10 = b.a(this);
        this.f3131e = a10;
        this.f3133g = h.c.CREATED;
        this.f3134h = h.c.RESUMED;
        this.f3127a = context;
        this.f3132f = uuid;
        this.f3128b = iVar;
        this.f3129c = bundle;
        this.f3135i = fVar;
        a10.c(bundle2);
        if (oVar != null) {
            this.f3133g = oVar.getLifecycle().b();
        }
    }

    private static h.c d(h.b bVar) {
        switch (a.f3137a[bVar.ordinal()]) {
            case 1:
            case 2:
                return h.c.CREATED;
            case 3:
            case 4:
                return h.c.STARTED;
            case 5:
                return h.c.RESUMED;
            case 6:
                return h.c.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + bVar);
        }
    }

    public Bundle a() {
        return this.f3129c;
    }

    public i b() {
        return this.f3128b;
    }

    /* access modifiers changed from: package-private */
    public h.c c() {
        return this.f3134h;
    }

    /* access modifiers changed from: package-private */
    public void e(h.b bVar) {
        this.f3133g = d(bVar);
        i();
    }

    /* access modifiers changed from: package-private */
    public void f(Bundle bundle) {
        this.f3129c = bundle;
    }

    /* access modifiers changed from: package-private */
    public void g(Bundle bundle) {
        this.f3131e.d(bundle);
    }

    public d0.b getDefaultViewModelProviderFactory() {
        if (this.f3136j == null) {
            this.f3136j = new a0((Application) this.f3127a.getApplicationContext(), this, this.f3129c);
        }
        return this.f3136j;
    }

    public h getLifecycle() {
        return this.f3130d;
    }

    public SavedStateRegistry getSavedStateRegistry() {
        return this.f3131e.b();
    }

    public f0 getViewModelStore() {
        f fVar = this.f3135i;
        if (fVar != null) {
            return fVar.c(this.f3132f);
        }
        throw new IllegalStateException("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.");
    }

    /* access modifiers changed from: package-private */
    public void h(h.c cVar) {
        this.f3134h = cVar;
        i();
    }

    /* access modifiers changed from: package-private */
    public void i() {
        h.c cVar;
        p pVar;
        if (this.f3133g.ordinal() < this.f3134h.ordinal()) {
            pVar = this.f3130d;
            cVar = this.f3133g;
        } else {
            pVar = this.f3130d;
            cVar = this.f3134h;
        }
        pVar.o(cVar);
    }
}
