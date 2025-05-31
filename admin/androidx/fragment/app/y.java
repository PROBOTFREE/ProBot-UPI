package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import t0.b;

abstract class y {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f2917a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<e> f2918b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    final ArrayList<e> f2919c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    boolean f2920d = false;

    /* renamed from: e  reason: collision with root package name */
    boolean f2921e = false;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f2922a;

        a(d dVar) {
            this.f2922a = dVar;
        }

        public void run() {
            if (y.this.f2918b.contains(this.f2922a)) {
                this.f2922a.e().a(this.f2922a.f().mView);
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f2924a;

        b(d dVar) {
            this.f2924a = dVar;
        }

        public void run() {
            y.this.f2918b.remove(this.f2924a);
            y.this.f2919c.remove(this.f2924a);
        }
    }

    static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2926a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f2927b;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004d */
        static {
            /*
                androidx.fragment.app.y$e$b[] r0 = androidx.fragment.app.y.e.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2927b = r0
                r1 = 1
                androidx.fragment.app.y$e$b r2 = androidx.fragment.app.y.e.b.ADDING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f2927b     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.fragment.app.y$e$b r3 = androidx.fragment.app.y.e.b.REMOVING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f2927b     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.fragment.app.y$e$b r4 = androidx.fragment.app.y.e.b.NONE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                androidx.fragment.app.y$e$c[] r3 = androidx.fragment.app.y.e.c.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f2926a = r3
                androidx.fragment.app.y$e$c r4 = androidx.fragment.app.y.e.c.REMOVED     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = f2926a     // Catch:{ NoSuchFieldError -> 0x0043 }
                androidx.fragment.app.y$e$c r3 = androidx.fragment.app.y.e.c.VISIBLE     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f2926a     // Catch:{ NoSuchFieldError -> 0x004d }
                androidx.fragment.app.y$e$c r1 = androidx.fragment.app.y.e.c.GONE     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                int[] r0 = f2926a     // Catch:{ NoSuchFieldError -> 0x0058 }
                androidx.fragment.app.y$e$c r1 = androidx.fragment.app.y.e.c.INVISIBLE     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.y.c.<clinit>():void");
        }
    }

    private static class d extends e {

        /* renamed from: h  reason: collision with root package name */
        private final p f2928h;

        d(e.c cVar, e.b bVar, p pVar, t0.b bVar2) {
            super(cVar, bVar, pVar.k(), bVar2);
            this.f2928h = pVar;
        }

        public void c() {
            super.c();
            this.f2928h.m();
        }

        /* access modifiers changed from: package-private */
        public void l() {
            if (g() == e.b.ADDING) {
                Fragment k10 = this.f2928h.k();
                View findFocus = k10.mView.findFocus();
                if (findFocus != null) {
                    k10.setFocusedView(findFocus);
                    if (FragmentManager.H0(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + k10);
                    }
                }
                View requireView = f().requireView();
                if (requireView.getParent() == null) {
                    this.f2928h.b();
                    requireView.setAlpha(0.0f);
                }
                if (requireView.getAlpha() == 0.0f && requireView.getVisibility() == 0) {
                    requireView.setVisibility(4);
                }
                requireView.setAlpha(k10.getPostOnViewCreatedAlpha());
            }
        }
    }

    static class e {

        /* renamed from: a  reason: collision with root package name */
        private c f2929a;

        /* renamed from: b  reason: collision with root package name */
        private b f2930b;

        /* renamed from: c  reason: collision with root package name */
        private final Fragment f2931c;

        /* renamed from: d  reason: collision with root package name */
        private final List<Runnable> f2932d = new ArrayList();

        /* renamed from: e  reason: collision with root package name */
        private final HashSet<t0.b> f2933e = new HashSet<>();

        /* renamed from: f  reason: collision with root package name */
        private boolean f2934f = false;

        /* renamed from: g  reason: collision with root package name */
        private boolean f2935g = false;

        class a implements b.a {
            a() {
            }

            public void a() {
                e.this.b();
            }
        }

        enum b {
            NONE,
            ADDING,
            REMOVING
        }

        enum c {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            static c b(int i10) {
                if (i10 == 0) {
                    return VISIBLE;
                }
                if (i10 == 4) {
                    return INVISIBLE;
                }
                if (i10 == 8) {
                    return GONE;
                }
                throw new IllegalArgumentException("Unknown visibility " + i10);
            }

            static c e(View view) {
                return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? INVISIBLE : b(view.getVisibility());
            }

            /* access modifiers changed from: package-private */
            public void a(View view) {
                int i10;
                int i11 = c.f2926a[ordinal()];
                if (i11 != 1) {
                    if (i11 == 2) {
                        if (FragmentManager.H0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                        }
                        i10 = 0;
                    } else if (i11 == 3) {
                        if (FragmentManager.H0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                        }
                        i10 = 8;
                    } else if (i11 == 4) {
                        if (FragmentManager.H0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                        }
                        view.setVisibility(4);
                        return;
                    } else {
                        return;
                    }
                    view.setVisibility(i10);
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    if (FragmentManager.H0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                    }
                    viewGroup.removeView(view);
                }
            }
        }

        e(c cVar, b bVar, Fragment fragment, t0.b bVar2) {
            this.f2929a = cVar;
            this.f2930b = bVar;
            this.f2931c = fragment;
            bVar2.c(new a());
        }

        /* access modifiers changed from: package-private */
        public final void a(Runnable runnable) {
            this.f2932d.add(runnable);
        }

        /* access modifiers changed from: package-private */
        public final void b() {
            if (!h()) {
                this.f2934f = true;
                if (this.f2933e.isEmpty()) {
                    c();
                    return;
                }
                Iterator it = new ArrayList(this.f2933e).iterator();
                while (it.hasNext()) {
                    ((t0.b) it.next()).a();
                }
            }
        }

        public void c() {
            if (!this.f2935g) {
                if (FragmentManager.H0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
                }
                this.f2935g = true;
                for (Runnable run : this.f2932d) {
                    run.run();
                }
            }
        }

        public final void d(t0.b bVar) {
            if (this.f2933e.remove(bVar) && this.f2933e.isEmpty()) {
                c();
            }
        }

        public c e() {
            return this.f2929a;
        }

        public final Fragment f() {
            return this.f2931c;
        }

        /* access modifiers changed from: package-private */
        public b g() {
            return this.f2930b;
        }

        /* access modifiers changed from: package-private */
        public final boolean h() {
            return this.f2934f;
        }

        /* access modifiers changed from: package-private */
        public final boolean i() {
            return this.f2935g;
        }

        public final void j(t0.b bVar) {
            l();
            this.f2933e.add(bVar);
        }

        /* access modifiers changed from: package-private */
        public final void k(c cVar, b bVar) {
            b bVar2;
            int i10 = c.f2927b[bVar.ordinal()];
            if (i10 != 1) {
                if (i10 == 2) {
                    if (FragmentManager.H0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f2931c + " mFinalState = " + this.f2929a + " -> REMOVED. mLifecycleImpact  = " + this.f2930b + " to REMOVING.");
                    }
                    this.f2929a = c.REMOVED;
                    bVar2 = b.REMOVING;
                } else if (i10 == 3 && this.f2929a != c.REMOVED) {
                    if (FragmentManager.H0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f2931c + " mFinalState = " + this.f2929a + " -> " + cVar + ". ");
                    }
                    this.f2929a = cVar;
                    return;
                } else {
                    return;
                }
            } else if (this.f2929a == c.REMOVED) {
                if (FragmentManager.H0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f2931c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f2930b + " to ADDING.");
                }
                this.f2929a = c.VISIBLE;
                bVar2 = b.ADDING;
            } else {
                return;
            }
            this.f2930b = bVar2;
        }

        /* access modifiers changed from: package-private */
        public void l() {
        }

        public String toString() {
            return "Operation " + "{" + Integer.toHexString(System.identityHashCode(this)) + "} " + "{" + "mFinalState = " + this.f2929a + "} " + "{" + "mLifecycleImpact = " + this.f2930b + "} " + "{" + "mFragment = " + this.f2931c + "}";
        }
    }

    y(ViewGroup viewGroup) {
        this.f2917a = viewGroup;
    }

    private void a(e.c cVar, e.b bVar, p pVar) {
        synchronized (this.f2918b) {
            t0.b bVar2 = new t0.b();
            e h10 = h(pVar.k());
            if (h10 != null) {
                h10.k(cVar, bVar);
                return;
            }
            d dVar = new d(cVar, bVar, pVar, bVar2);
            this.f2918b.add(dVar);
            dVar.a(new a(dVar));
            dVar.a(new b(dVar));
        }
    }

    private e h(Fragment fragment) {
        Iterator<e> it = this.f2918b.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next.f().equals(fragment) && !next.h()) {
                return next;
            }
        }
        return null;
    }

    private e i(Fragment fragment) {
        Iterator<e> it = this.f2919c.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next.f().equals(fragment) && !next.h()) {
                return next;
            }
        }
        return null;
    }

    static y n(ViewGroup viewGroup, FragmentManager fragmentManager) {
        return o(viewGroup, fragmentManager.A0());
    }

    static y o(ViewGroup viewGroup, z zVar) {
        int i10 = g1.b.special_effects_controller_view_tag;
        Object tag = viewGroup.getTag(i10);
        if (tag instanceof y) {
            return (y) tag;
        }
        y a10 = zVar.a(viewGroup);
        viewGroup.setTag(i10, a10);
        return a10;
    }

    private void q() {
        Iterator<e> it = this.f2918b.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next.g() == e.b.ADDING) {
                next.k(e.c.b(next.f().requireView().getVisibility()), e.b.NONE);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(e.c cVar, p pVar) {
        if (FragmentManager.H0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + pVar.k());
        }
        a(cVar, e.b.ADDING, pVar);
    }

    /* access modifiers changed from: package-private */
    public void c(p pVar) {
        if (FragmentManager.H0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + pVar.k());
        }
        a(e.c.GONE, e.b.NONE, pVar);
    }

    /* access modifiers changed from: package-private */
    public void d(p pVar) {
        if (FragmentManager.H0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + pVar.k());
        }
        a(e.c.REMOVED, e.b.REMOVING, pVar);
    }

    /* access modifiers changed from: package-private */
    public void e(p pVar) {
        if (FragmentManager.H0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + pVar.k());
        }
        a(e.c.VISIBLE, e.b.NONE, pVar);
    }

    /* access modifiers changed from: package-private */
    public abstract void f(List<e> list, boolean z10);

    /* access modifiers changed from: package-private */
    public void g() {
        if (!this.f2921e) {
            if (!x.U(this.f2917a)) {
                j();
                this.f2920d = false;
                return;
            }
            synchronized (this.f2918b) {
                if (!this.f2918b.isEmpty()) {
                    ArrayList arrayList = new ArrayList(this.f2919c);
                    this.f2919c.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        e eVar = (e) it.next();
                        if (FragmentManager.H0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + eVar);
                        }
                        eVar.b();
                        if (!eVar.i()) {
                            this.f2919c.add(eVar);
                        }
                    }
                    q();
                    ArrayList arrayList2 = new ArrayList(this.f2918b);
                    this.f2918b.clear();
                    this.f2919c.addAll(arrayList2);
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        ((e) it2.next()).l();
                    }
                    f(arrayList2, this.f2920d);
                    this.f2920d = false;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void j() {
        String str;
        String str2;
        boolean U = x.U(this.f2917a);
        synchronized (this.f2918b) {
            q();
            Iterator<e> it = this.f2918b.iterator();
            while (it.hasNext()) {
                it.next().l();
            }
            Iterator it2 = new ArrayList(this.f2919c).iterator();
            while (it2.hasNext()) {
                e eVar = (e) it2.next();
                if (FragmentManager.H0(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SpecialEffectsController: ");
                    if (U) {
                        str2 = "";
                    } else {
                        str2 = "Container " + this.f2917a + " is not attached to window. ";
                    }
                    sb2.append(str2);
                    sb2.append("Cancelling running operation ");
                    sb2.append(eVar);
                    Log.v("FragmentManager", sb2.toString());
                }
                eVar.b();
            }
            Iterator it3 = new ArrayList(this.f2918b).iterator();
            while (it3.hasNext()) {
                e eVar2 = (e) it3.next();
                if (FragmentManager.H0(2)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("SpecialEffectsController: ");
                    if (U) {
                        str = "";
                    } else {
                        str = "Container " + this.f2917a + " is not attached to window. ";
                    }
                    sb3.append(str);
                    sb3.append("Cancelling pending operation ");
                    sb3.append(eVar2);
                    Log.v("FragmentManager", sb3.toString());
                }
                eVar2.b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void k() {
        if (this.f2921e) {
            this.f2921e = false;
            g();
        }
    }

    /* access modifiers changed from: package-private */
    public e.b l(p pVar) {
        e h10 = h(pVar.k());
        e.b g10 = h10 != null ? h10.g() : null;
        e i10 = i(pVar.k());
        return (i10 == null || !(g10 == null || g10 == e.b.NONE)) ? g10 : i10.g();
    }

    public ViewGroup m() {
        return this.f2917a;
    }

    /* access modifiers changed from: package-private */
    public void p() {
        synchronized (this.f2918b) {
            q();
            this.f2921e = false;
            int size = this.f2918b.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                e eVar = this.f2918b.get(size);
                e.c e10 = e.c.e(eVar.f().mView);
                e.c e11 = eVar.e();
                e.c cVar = e.c.VISIBLE;
                if (e11 == cVar && e10 != cVar) {
                    this.f2921e = eVar.f().isPostponed();
                    break;
                }
                size--;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void r(boolean z10) {
        this.f2920d = z10;
    }
}
