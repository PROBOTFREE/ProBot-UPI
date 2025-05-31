package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.view.u;
import androidx.core.view.x;
import androidx.core.view.z;
import androidx.fragment.app.d;
import androidx.fragment.app.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import t0.b;

class b extends y {

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2728a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.fragment.app.y$e$c[] r0 = androidx.fragment.app.y.e.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2728a = r0
                androidx.fragment.app.y$e$c r1 = androidx.fragment.app.y.e.c.GONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f2728a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.fragment.app.y$e$c r1 = androidx.fragment.app.y.e.c.INVISIBLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f2728a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.fragment.app.y$e$c r1 = androidx.fragment.app.y.e.c.REMOVED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f2728a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.fragment.app.y$e$c r1 = androidx.fragment.app.y.e.c.VISIBLE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.b.a.<clinit>():void");
        }
    }

    /* renamed from: androidx.fragment.app.b$b  reason: collision with other inner class name */
    class C0025b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f2729a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ y.e f2730b;

        C0025b(List list, y.e eVar) {
            this.f2729a = list;
            this.f2730b = eVar;
        }

        public void run() {
            if (this.f2729a.contains(this.f2730b)) {
                this.f2729a.remove(this.f2730b);
                b.this.s(this.f2730b);
            }
        }
    }

    class c extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f2732a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f2733b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f2734c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ y.e f2735d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ k f2736e;

        c(b bVar, ViewGroup viewGroup, View view, boolean z10, y.e eVar, k kVar) {
            this.f2732a = viewGroup;
            this.f2733b = view;
            this.f2734c = z10;
            this.f2735d = eVar;
            this.f2736e = kVar;
        }

        public void onAnimationEnd(Animator animator) {
            this.f2732a.endViewTransition(this.f2733b);
            if (this.f2734c) {
                this.f2735d.e().a(this.f2733b);
            }
            this.f2736e.a();
        }
    }

    class d implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Animator f2737a;

        d(b bVar, Animator animator) {
            this.f2737a = animator;
        }

        public void a() {
            this.f2737a.end();
        }
    }

    class e implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f2738a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f2739b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ k f2740c;

        class a implements Runnable {
            a() {
            }

            public void run() {
                e eVar = e.this;
                eVar.f2738a.endViewTransition(eVar.f2739b);
                e.this.f2740c.a();
            }
        }

        e(b bVar, ViewGroup viewGroup, View view, k kVar) {
            this.f2738a = viewGroup;
            this.f2739b = view;
            this.f2740c = kVar;
        }

        public void onAnimationEnd(Animation animation) {
            this.f2738a.post(new a());
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    class f implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f2742a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewGroup f2743b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ k f2744c;

        f(b bVar, View view, ViewGroup viewGroup, k kVar) {
            this.f2742a = view;
            this.f2743b = viewGroup;
            this.f2744c = kVar;
        }

        public void a() {
            this.f2742a.clearAnimation();
            this.f2743b.endViewTransition(this.f2742a);
            this.f2744c.a();
        }
    }

    class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y.e f2745a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ y.e f2746b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f2747c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ c0.a f2748d;

        g(b bVar, y.e eVar, y.e eVar2, boolean z10, c0.a aVar) {
            this.f2745a = eVar;
            this.f2746b = eVar2;
            this.f2747c = z10;
            this.f2748d = aVar;
        }

        public void run() {
            t.f(this.f2745a.f(), this.f2746b.f(), this.f2747c, this.f2748d, false);
        }
    }

    class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ v f2749a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f2750b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Rect f2751c;

        h(b bVar, v vVar, View view, Rect rect) {
            this.f2749a = vVar;
            this.f2750b = view;
            this.f2751c = rect;
        }

        public void run() {
            this.f2749a.k(this.f2750b, this.f2751c);
        }
    }

    class i implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f2752a;

        i(b bVar, ArrayList arrayList) {
            this.f2752a = arrayList;
        }

        public void run() {
            t.A(this.f2752a, 4);
        }
    }

    class j implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f2753a;

        j(b bVar, m mVar) {
            this.f2753a = mVar;
        }

        public void run() {
            this.f2753a.a();
        }
    }

    private static class k extends l {

        /* renamed from: c  reason: collision with root package name */
        private boolean f2754c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f2755d = false;

        /* renamed from: e  reason: collision with root package name */
        private d.C0027d f2756e;

        k(y.e eVar, t0.b bVar, boolean z10) {
            super(eVar, bVar);
            this.f2754c = z10;
        }

        /* access modifiers changed from: package-private */
        public d.C0027d e(Context context) {
            if (this.f2755d) {
                return this.f2756e;
            }
            d.C0027d c10 = d.c(context, b().f(), b().e() == y.e.c.VISIBLE, this.f2754c);
            this.f2756e = c10;
            this.f2755d = true;
            return c10;
        }
    }

    private static class l {

        /* renamed from: a  reason: collision with root package name */
        private final y.e f2757a;

        /* renamed from: b  reason: collision with root package name */
        private final t0.b f2758b;

        l(y.e eVar, t0.b bVar) {
            this.f2757a = eVar;
            this.f2758b = bVar;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f2757a.d(this.f2758b);
        }

        /* access modifiers changed from: package-private */
        public y.e b() {
            return this.f2757a;
        }

        /* access modifiers changed from: package-private */
        public t0.b c() {
            return this.f2758b;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0014, code lost:
            r2 = androidx.fragment.app.y.e.c.f2942b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean d() {
            /*
                r3 = this;
                androidx.fragment.app.y$e r0 = r3.f2757a
                androidx.fragment.app.Fragment r0 = r0.f()
                android.view.View r0 = r0.mView
                androidx.fragment.app.y$e$c r0 = androidx.fragment.app.y.e.c.e(r0)
                androidx.fragment.app.y$e r1 = r3.f2757a
                androidx.fragment.app.y$e$c r1 = r1.e()
                if (r0 == r1) goto L_0x001d
                androidx.fragment.app.y$e$c r2 = androidx.fragment.app.y.e.c.VISIBLE
                if (r0 == r2) goto L_0x001b
                if (r1 == r2) goto L_0x001b
                goto L_0x001d
            L_0x001b:
                r0 = 0
                goto L_0x001e
            L_0x001d:
                r0 = 1
            L_0x001e:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.b.l.d():boolean");
        }
    }

    private static class m extends l {

        /* renamed from: c  reason: collision with root package name */
        private final Object f2759c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f2760d;

        /* renamed from: e  reason: collision with root package name */
        private final Object f2761e;

        m(y.e eVar, t0.b bVar, boolean z10, boolean z11) {
            super(eVar, bVar);
            boolean z12;
            Object obj;
            if (eVar.e() == y.e.c.VISIBLE) {
                Fragment f10 = eVar.f();
                this.f2759c = z10 ? f10.getReenterTransition() : f10.getEnterTransition();
                Fragment f11 = eVar.f();
                z12 = z10 ? f11.getAllowReturnTransitionOverlap() : f11.getAllowEnterTransitionOverlap();
            } else {
                Fragment f12 = eVar.f();
                this.f2759c = z10 ? f12.getReturnTransition() : f12.getExitTransition();
                z12 = true;
            }
            this.f2760d = z12;
            if (z11) {
                Fragment f13 = eVar.f();
                obj = z10 ? f13.getSharedElementReturnTransition() : f13.getSharedElementEnterTransition();
            } else {
                obj = null;
            }
            this.f2761e = obj;
        }

        private v f(Object obj) {
            if (obj == null) {
                return null;
            }
            v vVar = t.f2847b;
            if (vVar != null && vVar.e(obj)) {
                return vVar;
            }
            v vVar2 = t.f2848c;
            if (vVar2 != null && vVar2.e(obj)) {
                return vVar2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + b().f() + " is not a valid framework Transition or AndroidX Transition");
        }

        /* access modifiers changed from: package-private */
        public v e() {
            v f10 = f(this.f2759c);
            v f11 = f(this.f2761e);
            if (f10 == null || f11 == null || f10 == f11) {
                return f10 != null ? f10 : f11;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + b().f() + " returned Transition " + this.f2759c + " which uses a different Transition  type than its shared element transition " + this.f2761e);
        }

        public Object g() {
            return this.f2761e;
        }

        /* access modifiers changed from: package-private */
        public Object h() {
            return this.f2759c;
        }

        public boolean i() {
            return this.f2761e != null;
        }

        /* access modifiers changed from: package-private */
        public boolean j() {
            return this.f2760d;
        }
    }

    b(ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void w(List<k> list, List<y.e> list2, boolean z10, Map<y.e, Boolean> map) {
        StringBuilder sb2;
        String str;
        d.C0027d e10;
        ViewGroup m10 = m();
        Context context = m10.getContext();
        ArrayList arrayList = new ArrayList();
        boolean z11 = false;
        for (k next : list) {
            if (!next.d() && (e10 = next.e(context)) != null) {
                Animator animator = e10.f2780b;
                if (animator == null) {
                    arrayList.add(next);
                } else {
                    y.e b10 = next.b();
                    Fragment f10 = b10.f();
                    if (Boolean.TRUE.equals(map.get(b10))) {
                        if (FragmentManager.H0(2)) {
                            Log.v("FragmentManager", "Ignoring Animator set on " + f10 + " as this Fragment was involved in a Transition.");
                        }
                        next.a();
                    } else {
                        boolean z12 = b10.e() == y.e.c.GONE;
                        List<y.e> list3 = list2;
                        if (z12) {
                            list3.remove(b10);
                        }
                        View view = f10.mView;
                        m10.startViewTransition(view);
                        c cVar = r0;
                        c cVar2 = new c(this, m10, view, z12, b10, next);
                        animator.addListener(cVar);
                        animator.setTarget(view);
                        animator.start();
                        next.c().c(new d(this, animator));
                        z11 = true;
                    }
                }
            } else {
                next.a();
            }
            Map<y.e, Boolean> map2 = map;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            k kVar = (k) it.next();
            y.e b11 = kVar.b();
            Fragment f11 = b11.f();
            if (z10) {
                if (FragmentManager.H0(2)) {
                    sb2 = new StringBuilder();
                    sb2.append("Ignoring Animation set on ");
                    sb2.append(f11);
                    str = " as Animations cannot run alongside Transitions.";
                }
                kVar.a();
            } else if (z11) {
                if (FragmentManager.H0(2)) {
                    sb2 = new StringBuilder();
                    sb2.append("Ignoring Animation set on ");
                    sb2.append(f11);
                    str = " as Animations cannot run alongside Animators.";
                }
                kVar.a();
            } else {
                View view2 = f11.mView;
                Animation animation = (Animation) w0.h.e(((d.C0027d) w0.h.e(kVar.e(context))).f2779a);
                if (b11.e() != y.e.c.REMOVED) {
                    view2.startAnimation(animation);
                    kVar.a();
                } else {
                    m10.startViewTransition(view2);
                    d.e eVar = new d.e(animation, m10, view2);
                    eVar.setAnimationListener(new e(this, m10, view2, kVar));
                    view2.startAnimation(eVar);
                }
                kVar.c().c(new f(this, view2, m10, kVar));
            }
            sb2.append(str);
            Log.v("FragmentManager", sb2.toString());
            kVar.a();
        }
    }

    private Map<y.e, Boolean> x(List<m> list, List<y.e> list2, boolean z10, y.e eVar, y.e eVar2) {
        ArrayList arrayList;
        ArrayList arrayList2;
        View view;
        View view2;
        Object obj;
        y.e eVar3;
        y.e eVar4;
        Object obj2;
        Object obj3;
        c0.a aVar;
        y.e eVar5;
        v vVar;
        View view3;
        Rect rect;
        ArrayList arrayList3;
        y.e eVar6;
        ArrayList arrayList4;
        boolean z11 = z10;
        y.e eVar7 = eVar;
        y.e eVar8 = eVar2;
        HashMap hashMap = new HashMap();
        v vVar2 = null;
        for (m next : list) {
            if (!next.d()) {
                v e10 = next.e();
                if (vVar2 == null) {
                    vVar2 = e10;
                } else if (!(e10 == null || vVar2 == e10)) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + next.b().f() + " returned Transition " + next.h() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (vVar2 == null) {
            for (m next2 : list) {
                hashMap.put(next2.b(), Boolean.FALSE);
                next2.a();
            }
            return hashMap;
        }
        View view4 = new View(m().getContext());
        Rect rect2 = new Rect();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        c0.a aVar2 = new c0.a();
        Object obj4 = null;
        View view5 = null;
        boolean z12 = false;
        for (m next3 : list) {
            if (!next3.i() || eVar7 == null || eVar8 == null) {
                aVar = aVar2;
                arrayList4 = arrayList6;
                eVar6 = eVar7;
                arrayList3 = arrayList5;
                rect = rect2;
                view3 = view4;
                vVar = vVar2;
                eVar5 = eVar8;
                view5 = view5;
            } else {
                Object B = vVar2.B(vVar2.g(next3.g()));
                ArrayList<String> sharedElementSourceNames = eVar2.f().getSharedElementSourceNames();
                ArrayList<String> sharedElementSourceNames2 = eVar.f().getSharedElementSourceNames();
                ArrayList<String> sharedElementTargetNames = eVar.f().getSharedElementTargetNames();
                Object obj5 = B;
                View view6 = view5;
                int i10 = 0;
                while (i10 < sharedElementTargetNames.size()) {
                    int indexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i10));
                    ArrayList<String> arrayList7 = sharedElementTargetNames;
                    if (indexOf != -1) {
                        sharedElementSourceNames.set(indexOf, sharedElementSourceNames2.get(i10));
                    }
                    i10++;
                    sharedElementTargetNames = arrayList7;
                }
                ArrayList<String> sharedElementTargetNames2 = eVar2.f().getSharedElementTargetNames();
                Fragment f10 = eVar.f();
                if (!z11) {
                    f10.getExitTransitionCallback();
                    eVar2.f().getEnterTransitionCallback();
                } else {
                    f10.getEnterTransitionCallback();
                    eVar2.f().getExitTransitionCallback();
                }
                int i11 = 0;
                for (int size = sharedElementSourceNames.size(); i11 < size; size = size) {
                    aVar2.put(sharedElementSourceNames.get(i11), sharedElementTargetNames2.get(i11));
                    i11++;
                }
                c0.a aVar3 = new c0.a();
                u(aVar3, eVar.f().mView);
                aVar3.q(sharedElementSourceNames);
                aVar2.q(aVar3.keySet());
                c0.a aVar4 = new c0.a();
                u(aVar4, eVar2.f().mView);
                aVar4.q(sharedElementTargetNames2);
                aVar4.q(aVar2.values());
                t.x(aVar2, aVar4);
                v(aVar3, aVar2.keySet());
                v(aVar4, aVar2.values());
                if (aVar2.isEmpty()) {
                    arrayList5.clear();
                    arrayList6.clear();
                    aVar = aVar2;
                    arrayList4 = arrayList6;
                    eVar6 = eVar7;
                    arrayList3 = arrayList5;
                    rect = rect2;
                    view3 = view4;
                    vVar = vVar2;
                    view5 = view6;
                    obj4 = null;
                    eVar5 = eVar8;
                } else {
                    t.f(eVar2.f(), eVar.f(), z11, aVar3, true);
                    ArrayList<String> arrayList8 = sharedElementSourceNames;
                    g gVar = r0;
                    ViewGroup m10 = m();
                    Object obj6 = obj5;
                    c0.a aVar5 = aVar4;
                    View view7 = view6;
                    c0.a aVar6 = aVar3;
                    aVar = aVar2;
                    ArrayList arrayList9 = arrayList6;
                    g gVar2 = new g(this, eVar2, eVar, z10, aVar5);
                    u.a(m10, gVar2);
                    arrayList5.addAll(aVar6.values());
                    if (!arrayList8.isEmpty()) {
                        View view8 = (View) aVar6.get(arrayList8.get(0));
                        vVar2.v(obj6, view8);
                        view5 = view8;
                    } else {
                        view5 = view7;
                    }
                    arrayList4 = arrayList9;
                    arrayList4.addAll(aVar5.values());
                    if (!sharedElementTargetNames2.isEmpty()) {
                        View view9 = (View) aVar5.get(sharedElementTargetNames2.get(0));
                        if (view9 != null) {
                            u.a(m(), new h(this, vVar2, view9, rect2));
                            z12 = true;
                        }
                    }
                    vVar2.z(obj6, view4, arrayList5);
                    arrayList3 = arrayList5;
                    rect = rect2;
                    view3 = view4;
                    vVar = vVar2;
                    vVar2.t(obj6, (Object) null, (ArrayList<View>) null, (Object) null, (ArrayList<View>) null, obj6, arrayList4);
                    Boolean bool = Boolean.TRUE;
                    eVar6 = eVar;
                    hashMap.put(eVar6, bool);
                    eVar5 = eVar2;
                    hashMap.put(eVar5, bool);
                    obj4 = obj6;
                }
            }
            eVar7 = eVar6;
            arrayList5 = arrayList3;
            rect2 = rect;
            view4 = view3;
            eVar8 = eVar5;
            aVar2 = aVar;
            z11 = z10;
            arrayList6 = arrayList4;
            vVar2 = vVar;
        }
        View view10 = view5;
        c0.a aVar7 = aVar2;
        ArrayList arrayList10 = arrayList6;
        y.e eVar9 = eVar7;
        ArrayList arrayList11 = arrayList5;
        Rect rect3 = rect2;
        View view11 = view4;
        v vVar3 = vVar2;
        boolean z13 = false;
        y.e eVar10 = eVar8;
        ArrayList arrayList12 = new ArrayList();
        Object obj7 = null;
        Object obj8 = null;
        for (m next4 : list) {
            if (next4.d()) {
                hashMap.put(next4.b(), Boolean.FALSE);
                next4.a();
            } else {
                Object g10 = vVar3.g(next4.h());
                y.e b10 = next4.b();
                boolean z14 = (obj4 == null || !(b10 == eVar9 || b10 == eVar10)) ? z13 : true;
                if (g10 == null) {
                    if (!z14) {
                        hashMap.put(b10, Boolean.FALSE);
                        next4.a();
                    }
                    List<y.e> list3 = list2;
                    arrayList = arrayList10;
                    arrayList2 = arrayList11;
                    view = view11;
                    obj = obj7;
                    eVar3 = eVar10;
                    view2 = view10;
                } else {
                    ArrayList arrayList13 = new ArrayList();
                    Object obj9 = obj7;
                    t(arrayList13, b10.f().mView);
                    if (z14) {
                        if (b10 == eVar9) {
                            arrayList13.removeAll(arrayList11);
                        } else {
                            arrayList13.removeAll(arrayList10);
                        }
                    }
                    if (arrayList13.isEmpty()) {
                        vVar3.a(g10, view11);
                        arrayList = arrayList10;
                        arrayList2 = arrayList11;
                        view = view11;
                        eVar4 = b10;
                        obj3 = obj8;
                        eVar3 = eVar10;
                        List<y.e> list4 = list2;
                        obj2 = obj9;
                    } else {
                        vVar3.b(g10, arrayList13);
                        view = view11;
                        obj2 = obj9;
                        y.e eVar11 = b10;
                        arrayList2 = arrayList11;
                        obj3 = obj8;
                        arrayList = arrayList10;
                        eVar3 = eVar10;
                        vVar3.t(g10, g10, arrayList13, (Object) null, (ArrayList<View>) null, (Object) null, (ArrayList<View>) null);
                        if (eVar11.e() == y.e.c.GONE) {
                            eVar4 = eVar11;
                            list2.remove(eVar4);
                            ArrayList arrayList14 = new ArrayList(arrayList13);
                            arrayList14.remove(eVar4.f().mView);
                            vVar3.r(g10, eVar4.f().mView, arrayList14);
                            u.a(m(), new i(this, arrayList13));
                        } else {
                            List<y.e> list5 = list2;
                            eVar4 = eVar11;
                        }
                    }
                    if (eVar4.e() == y.e.c.VISIBLE) {
                        arrayList12.addAll(arrayList13);
                        if (z12) {
                            vVar3.u(g10, rect3);
                        }
                        view2 = view10;
                    } else {
                        view2 = view10;
                        vVar3.v(g10, view2);
                    }
                    hashMap.put(eVar4, Boolean.TRUE);
                    if (next4.j()) {
                        obj8 = vVar3.n(obj3, g10, (Object) null);
                        obj = obj2;
                    } else {
                        obj = vVar3.n(obj2, g10, (Object) null);
                        obj8 = obj3;
                    }
                }
                eVar10 = eVar3;
                obj7 = obj;
                view10 = view2;
                view11 = view;
                arrayList11 = arrayList2;
                arrayList10 = arrayList;
                z13 = false;
            }
        }
        ArrayList arrayList15 = arrayList10;
        ArrayList arrayList16 = arrayList11;
        y.e eVar12 = eVar10;
        Object m11 = vVar3.m(obj8, obj7, obj4);
        for (m next5 : list) {
            if (!next5.d()) {
                Object h10 = next5.h();
                y.e b11 = next5.b();
                boolean z15 = obj4 != null && (b11 == eVar9 || b11 == eVar12);
                if (h10 != null || z15) {
                    if (!x.V(m())) {
                        if (FragmentManager.H0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Container " + m() + " has not been laid out. Completing operation " + b11);
                        }
                        next5.a();
                    } else {
                        vVar3.w(next5.b().f(), m11, next5.c(), new j(this, next5));
                    }
                }
            }
        }
        if (!x.V(m())) {
            return hashMap;
        }
        t.A(arrayList12, 4);
        ArrayList arrayList17 = arrayList15;
        ArrayList<String> o10 = vVar3.o(arrayList17);
        vVar3.c(m(), m11);
        vVar3.y(m(), arrayList16, arrayList17, o10, aVar7);
        t.A(arrayList12, 0);
        vVar3.A(obj4, arrayList16, arrayList17);
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public void f(List<y.e> list, boolean z10) {
        y.e eVar = null;
        y.e eVar2 = null;
        for (y.e next : list) {
            y.e.c e10 = y.e.c.e(next.f().mView);
            int i10 = a.f2728a[next.e().ordinal()];
            if (i10 == 1 || i10 == 2 || i10 == 3) {
                if (e10 == y.e.c.VISIBLE && eVar == null) {
                    eVar = next;
                }
            } else if (i10 == 4 && e10 != y.e.c.VISIBLE) {
                eVar2 = next;
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList<y.e> arrayList3 = new ArrayList<>(list);
        for (y.e next2 : list) {
            t0.b bVar = new t0.b();
            next2.j(bVar);
            arrayList.add(new k(next2, bVar, z10));
            t0.b bVar2 = new t0.b();
            next2.j(bVar2);
            boolean z11 = false;
            if (z10) {
                if (next2 != eVar) {
                    arrayList2.add(new m(next2, bVar2, z10, z11));
                    next2.a(new C0025b(arrayList3, next2));
                }
            } else if (next2 != eVar2) {
                arrayList2.add(new m(next2, bVar2, z10, z11));
                next2.a(new C0025b(arrayList3, next2));
            }
            z11 = true;
            arrayList2.add(new m(next2, bVar2, z10, z11));
            next2.a(new C0025b(arrayList3, next2));
        }
        Map<y.e, Boolean> x10 = x(arrayList2, arrayList3, z10, eVar, eVar2);
        w(arrayList, arrayList3, x10.containsValue(Boolean.TRUE), x10);
        for (y.e s10 : arrayList3) {
            s(s10);
        }
        arrayList3.clear();
    }

    /* access modifiers changed from: package-private */
    public void s(y.e eVar) {
        eVar.e().a(eVar.f().mView);
    }

    /* access modifiers changed from: package-private */
    public void t(ArrayList<View> arrayList, View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (!z.a(viewGroup)) {
                int childCount = viewGroup.getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    View childAt = viewGroup.getChildAt(i10);
                    if (childAt.getVisibility() == 0) {
                        t(arrayList, childAt);
                    }
                }
            } else if (!arrayList.contains(view)) {
                arrayList.add(viewGroup);
            }
        } else if (!arrayList.contains(view)) {
            arrayList.add(view);
        }
    }

    /* access modifiers changed from: package-private */
    public void u(Map<String, View> map, View view) {
        String M = x.M(view);
        if (M != null) {
            map.put(M, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                if (childAt.getVisibility() == 0) {
                    u(map, childAt);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void v(c0.a<String, View> aVar, Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it = aVar.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(x.M((View) it.next().getValue()))) {
                it.remove();
            }
        }
    }
}
