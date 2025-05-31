package androidx.fragment.app;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.u;
import androidx.core.view.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class t {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f2846a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* renamed from: b  reason: collision with root package name */
    static final v f2847b = (Build.VERSION.SDK_INT >= 21 ? new u() : null);

    /* renamed from: c  reason: collision with root package name */
    static final v f2848c = w();

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f2849a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Fragment f2850b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ t0.b f2851c;

        a(g gVar, Fragment fragment, t0.b bVar) {
            this.f2849a = gVar;
            this.f2850b = fragment;
            this.f2851c = bVar;
        }

        public void run() {
            this.f2849a.a(this.f2850b, this.f2851c);
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f2852a;

        b(ArrayList arrayList) {
            this.f2852a = arrayList;
        }

        public void run() {
            t.A(this.f2852a, 4);
        }
    }

    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f2853a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Fragment f2854b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ t0.b f2855c;

        c(g gVar, Fragment fragment, t0.b bVar) {
            this.f2853a = gVar;
            this.f2854b = fragment;
            this.f2855c = bVar;
        }

        public void run() {
            this.f2853a.a(this.f2854b, this.f2855c);
        }
    }

    class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f2856a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ v f2857b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f2858c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Fragment f2859d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ArrayList f2860e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ ArrayList f2861f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ ArrayList f2862g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ Object f2863h;

        d(Object obj, v vVar, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
            this.f2856a = obj;
            this.f2857b = vVar;
            this.f2858c = view;
            this.f2859d = fragment;
            this.f2860e = arrayList;
            this.f2861f = arrayList2;
            this.f2862g = arrayList3;
            this.f2863h = obj2;
        }

        public void run() {
            Object obj = this.f2856a;
            if (obj != null) {
                this.f2857b.p(obj, this.f2858c);
                this.f2861f.addAll(t.k(this.f2857b, this.f2856a, this.f2859d, this.f2860e, this.f2858c));
            }
            if (this.f2862g != null) {
                if (this.f2863h != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.f2858c);
                    this.f2857b.q(this.f2863h, this.f2862g, arrayList);
                }
                this.f2862g.clear();
                this.f2862g.add(this.f2858c);
            }
        }
    }

    class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Fragment f2864a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Fragment f2865b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f2866c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ c0.a f2867d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ View f2868e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ v f2869f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ Rect f2870g;

        e(Fragment fragment, Fragment fragment2, boolean z10, c0.a aVar, View view, v vVar, Rect rect) {
            this.f2864a = fragment;
            this.f2865b = fragment2;
            this.f2866c = z10;
            this.f2867d = aVar;
            this.f2868e = view;
            this.f2869f = vVar;
            this.f2870g = rect;
        }

        public void run() {
            t.f(this.f2864a, this.f2865b, this.f2866c, this.f2867d, false);
            View view = this.f2868e;
            if (view != null) {
                this.f2869f.k(view, this.f2870g);
            }
        }
    }

    class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ v f2871a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c0.a f2872b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f2873c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ h f2874d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ArrayList f2875e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ View f2876f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ Fragment f2877g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ Fragment f2878h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ boolean f2879i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ ArrayList f2880j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ Object f2881k;

        /* renamed from: l  reason: collision with root package name */
        final /* synthetic */ Rect f2882l;

        f(v vVar, c0.a aVar, Object obj, h hVar, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z10, ArrayList arrayList2, Object obj2, Rect rect) {
            this.f2871a = vVar;
            this.f2872b = aVar;
            this.f2873c = obj;
            this.f2874d = hVar;
            this.f2875e = arrayList;
            this.f2876f = view;
            this.f2877g = fragment;
            this.f2878h = fragment2;
            this.f2879i = z10;
            this.f2880j = arrayList2;
            this.f2881k = obj2;
            this.f2882l = rect;
        }

        public void run() {
            c0.a<String, View> h10 = t.h(this.f2871a, this.f2872b, this.f2873c, this.f2874d);
            if (h10 != null) {
                this.f2875e.addAll(h10.values());
                this.f2875e.add(this.f2876f);
            }
            t.f(this.f2877g, this.f2878h, this.f2879i, h10, false);
            Object obj = this.f2873c;
            if (obj != null) {
                this.f2871a.A(obj, this.f2880j, this.f2875e);
                View s10 = t.s(h10, this.f2874d, this.f2881k, this.f2879i);
                if (s10 != null) {
                    this.f2871a.k(s10, this.f2882l);
                }
            }
        }
    }

    interface g {
        void a(Fragment fragment, t0.b bVar);

        void b(Fragment fragment, t0.b bVar);
    }

    static class h {

        /* renamed from: a  reason: collision with root package name */
        public Fragment f2883a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f2884b;

        /* renamed from: c  reason: collision with root package name */
        public a f2885c;

        /* renamed from: d  reason: collision with root package name */
        public Fragment f2886d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f2887e;

        /* renamed from: f  reason: collision with root package name */
        public a f2888f;

        h() {
        }
    }

    static void A(ArrayList<View> arrayList, int i10) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).setVisibility(i10);
            }
        }
    }

    static void B(Context context, e eVar, ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i10, int i11, boolean z10, g gVar) {
        ViewGroup viewGroup;
        SparseArray sparseArray = new SparseArray();
        for (int i12 = i10; i12 < i11; i12++) {
            a aVar = arrayList.get(i12);
            if (arrayList2.get(i12).booleanValue()) {
                e(aVar, sparseArray, z10);
            } else {
                c(aVar, sparseArray, z10);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(context);
            int size = sparseArray.size();
            for (int i13 = 0; i13 < size; i13++) {
                int keyAt = sparseArray.keyAt(i13);
                c0.a<String, String> d10 = d(keyAt, arrayList, arrayList2, i10, i11);
                h hVar = (h) sparseArray.valueAt(i13);
                if (eVar.d() && (viewGroup = (ViewGroup) eVar.c(keyAt)) != null) {
                    if (z10) {
                        o(viewGroup, hVar, view, d10, gVar);
                    } else {
                        n(viewGroup, hVar, view, d10, gVar);
                    }
                }
            }
        }
    }

    static boolean C() {
        return (f2847b == null && f2848c == null) ? false : true;
    }

    private static void a(ArrayList<View> arrayList, c0.a<String, View> aVar, Collection<String> collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View o10 = aVar.o(size);
            if (collection.contains(x.M(o10))) {
                arrayList.add(o10);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0039, code lost:
        if (r0.mAdded != false) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x006e, code lost:
        r9 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0088, code lost:
        if (r0.mHidden == false) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x008a, code lost:
        r9 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00d7 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:90:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(androidx.fragment.app.a r8, androidx.fragment.app.s.a r9, android.util.SparseArray<androidx.fragment.app.t.h> r10, boolean r11, boolean r12) {
        /*
            androidx.fragment.app.Fragment r0 = r9.f2839b
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            int r1 = r0.mContainerId
            if (r1 != 0) goto L_0x000a
            return
        L_0x000a:
            if (r11 == 0) goto L_0x0013
            int[] r2 = f2846a
            int r9 = r9.f2838a
            r9 = r2[r9]
            goto L_0x0015
        L_0x0013:
            int r9 = r9.f2838a
        L_0x0015:
            r2 = 0
            r3 = 1
            if (r9 == r3) goto L_0x007d
            r4 = 3
            if (r9 == r4) goto L_0x0057
            r4 = 4
            if (r9 == r4) goto L_0x003f
            r4 = 5
            if (r9 == r4) goto L_0x002d
            r4 = 6
            if (r9 == r4) goto L_0x0057
            r4 = 7
            if (r9 == r4) goto L_0x007d
            r9 = r2
            r3 = r9
            r4 = r3
            goto L_0x0090
        L_0x002d:
            if (r12 == 0) goto L_0x003c
            boolean r9 = r0.mHiddenChanged
            if (r9 == 0) goto L_0x008c
            boolean r9 = r0.mHidden
            if (r9 != 0) goto L_0x008c
            boolean r9 = r0.mAdded
            if (r9 == 0) goto L_0x008c
            goto L_0x008a
        L_0x003c:
            boolean r9 = r0.mHidden
            goto L_0x008d
        L_0x003f:
            if (r12 == 0) goto L_0x004e
            boolean r9 = r0.mHiddenChanged
            if (r9 == 0) goto L_0x0070
            boolean r9 = r0.mAdded
            if (r9 == 0) goto L_0x0070
            boolean r9 = r0.mHidden
            if (r9 == 0) goto L_0x0070
        L_0x004d:
            goto L_0x006e
        L_0x004e:
            boolean r9 = r0.mAdded
            if (r9 == 0) goto L_0x0070
            boolean r9 = r0.mHidden
            if (r9 != 0) goto L_0x0070
            goto L_0x004d
        L_0x0057:
            boolean r9 = r0.mAdded
            if (r12 == 0) goto L_0x0072
            if (r9 != 0) goto L_0x0070
            android.view.View r9 = r0.mView
            if (r9 == 0) goto L_0x0070
            int r9 = r9.getVisibility()
            if (r9 != 0) goto L_0x0070
            float r9 = r0.mPostponedAlpha
            r4 = 0
            int r9 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r9 < 0) goto L_0x0070
        L_0x006e:
            r9 = r3
            goto L_0x0079
        L_0x0070:
            r9 = r2
            goto L_0x0079
        L_0x0072:
            if (r9 == 0) goto L_0x0070
            boolean r9 = r0.mHidden
            if (r9 != 0) goto L_0x0070
            goto L_0x006e
        L_0x0079:
            r4 = r9
            r9 = r3
            r3 = r2
            goto L_0x0090
        L_0x007d:
            if (r12 == 0) goto L_0x0082
            boolean r9 = r0.mIsNewlyAdded
            goto L_0x008d
        L_0x0082:
            boolean r9 = r0.mAdded
            if (r9 != 0) goto L_0x008c
            boolean r9 = r0.mHidden
            if (r9 != 0) goto L_0x008c
        L_0x008a:
            r9 = r3
            goto L_0x008d
        L_0x008c:
            r9 = r2
        L_0x008d:
            r4 = r2
            r2 = r9
            r9 = r4
        L_0x0090:
            java.lang.Object r5 = r10.get(r1)
            androidx.fragment.app.t$h r5 = (androidx.fragment.app.t.h) r5
            if (r2 == 0) goto L_0x00a2
            androidx.fragment.app.t$h r5 = p(r5, r10, r1)
            r5.f2883a = r0
            r5.f2884b = r11
            r5.f2885c = r8
        L_0x00a2:
            r2 = 0
            if (r12 != 0) goto L_0x00c3
            if (r3 == 0) goto L_0x00c3
            if (r5 == 0) goto L_0x00af
            androidx.fragment.app.Fragment r3 = r5.f2886d
            if (r3 != r0) goto L_0x00af
            r5.f2886d = r2
        L_0x00af:
            boolean r3 = r8.f2836p
            if (r3 != 0) goto L_0x00c3
            androidx.fragment.app.FragmentManager r3 = r8.f2725r
            androidx.fragment.app.p r6 = r3.w(r0)
            androidx.fragment.app.r r7 = r3.t0()
            r7.p(r6)
            r3.T0(r0)
        L_0x00c3:
            if (r4 == 0) goto L_0x00d5
            if (r5 == 0) goto L_0x00cb
            androidx.fragment.app.Fragment r3 = r5.f2886d
            if (r3 != 0) goto L_0x00d5
        L_0x00cb:
            androidx.fragment.app.t$h r5 = p(r5, r10, r1)
            r5.f2886d = r0
            r5.f2887e = r11
            r5.f2888f = r8
        L_0x00d5:
            if (r12 != 0) goto L_0x00e1
            if (r9 == 0) goto L_0x00e1
            if (r5 == 0) goto L_0x00e1
            androidx.fragment.app.Fragment r8 = r5.f2883a
            if (r8 != r0) goto L_0x00e1
            r5.f2883a = r2
        L_0x00e1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.t.b(androidx.fragment.app.a, androidx.fragment.app.s$a, android.util.SparseArray, boolean, boolean):void");
    }

    public static void c(a aVar, SparseArray<h> sparseArray, boolean z10) {
        int size = aVar.f2821a.size();
        for (int i10 = 0; i10 < size; i10++) {
            b(aVar, aVar.f2821a.get(i10), sparseArray, false, z10);
        }
    }

    private static c0.a<String, String> d(int i10, ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i11, int i12) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        c0.a<String, String> aVar = new c0.a<>();
        for (int i13 = i12 - 1; i13 >= i11; i13--) {
            a aVar2 = arrayList.get(i13);
            if (aVar2.F(i10)) {
                boolean booleanValue = arrayList2.get(i13).booleanValue();
                ArrayList<String> arrayList5 = aVar2.f2834n;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (booleanValue) {
                        arrayList3 = aVar2.f2834n;
                        arrayList4 = aVar2.f2835o;
                    } else {
                        ArrayList<String> arrayList6 = aVar2.f2834n;
                        arrayList3 = aVar2.f2835o;
                        arrayList4 = arrayList6;
                    }
                    for (int i14 = 0; i14 < size; i14++) {
                        String str = arrayList4.get(i14);
                        String str2 = arrayList3.get(i14);
                        String remove = aVar.remove(str2);
                        if (remove != null) {
                            aVar.put(str, remove);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    public static void e(a aVar, SparseArray<h> sparseArray, boolean z10) {
        if (aVar.f2725r.p0().d()) {
            for (int size = aVar.f2821a.size() - 1; size >= 0; size--) {
                b(aVar, aVar.f2821a.get(size), sparseArray, true, z10);
            }
        }
    }

    static void f(Fragment fragment, Fragment fragment2, boolean z10, c0.a<String, View> aVar, boolean z11) {
        if (z10) {
            fragment2.getEnterTransitionCallback();
        } else {
            fragment.getEnterTransitionCallback();
        }
    }

    private static boolean g(v vVar, List<Object> list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!vVar.e(list.get(i10))) {
                return false;
            }
        }
        return true;
    }

    static c0.a<String, View> h(v vVar, c0.a<String, String> aVar, Object obj, h hVar) {
        ArrayList<String> arrayList;
        Fragment fragment = hVar.f2883a;
        View view = fragment.getView();
        if (aVar.isEmpty() || obj == null || view == null) {
            aVar.clear();
            return null;
        }
        c0.a<String, View> aVar2 = new c0.a<>();
        vVar.j(aVar2, view);
        a aVar3 = hVar.f2885c;
        if (hVar.f2884b) {
            fragment.getExitTransitionCallback();
            arrayList = aVar3.f2834n;
        } else {
            fragment.getEnterTransitionCallback();
            arrayList = aVar3.f2835o;
        }
        if (arrayList != null) {
            aVar2.q(arrayList);
            aVar2.q(aVar.values());
        }
        x(aVar, aVar2);
        return aVar2;
    }

    private static c0.a<String, View> i(v vVar, c0.a<String, String> aVar, Object obj, h hVar) {
        ArrayList<String> arrayList;
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        Fragment fragment = hVar.f2886d;
        c0.a<String, View> aVar2 = new c0.a<>();
        vVar.j(aVar2, fragment.requireView());
        a aVar3 = hVar.f2888f;
        if (hVar.f2887e) {
            fragment.getEnterTransitionCallback();
            arrayList = aVar3.f2835o;
        } else {
            fragment.getExitTransitionCallback();
            arrayList = aVar3.f2834n;
        }
        if (arrayList != null) {
            aVar2.q(arrayList);
        }
        aVar.q(aVar2.keySet());
        return aVar2;
    }

    private static v j(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        v vVar = f2847b;
        if (vVar != null && g(vVar, arrayList)) {
            return vVar;
        }
        v vVar2 = f2848c;
        if (vVar2 != null && g(vVar2, arrayList)) {
            return vVar2;
        }
        if (vVar == null && vVar2 == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    static ArrayList<View> k(v vVar, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View view2 = fragment.getView();
        if (view2 != null) {
            vVar.f(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        vVar.b(obj, arrayList2);
        return arrayList2;
    }

    private static Object l(v vVar, ViewGroup viewGroup, View view, c0.a<String, String> aVar, h hVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        c0.a<String, String> aVar2;
        Object obj3;
        Object obj4;
        Rect rect;
        v vVar2 = vVar;
        h hVar2 = hVar;
        ArrayList<View> arrayList3 = arrayList;
        Object obj5 = obj;
        Fragment fragment = hVar2.f2883a;
        Fragment fragment2 = hVar2.f2886d;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z10 = hVar2.f2884b;
        if (aVar.isEmpty()) {
            aVar2 = aVar;
            obj3 = null;
        } else {
            obj3 = t(vVar2, fragment, fragment2, z10);
            aVar2 = aVar;
        }
        c0.a<String, View> i10 = i(vVar2, aVar2, obj3, hVar2);
        if (aVar.isEmpty()) {
            obj4 = null;
        } else {
            arrayList3.addAll(i10.values());
            obj4 = obj3;
        }
        if (obj5 == null && obj2 == null && obj4 == null) {
            return null;
        }
        f(fragment, fragment2, z10, i10, true);
        if (obj4 != null) {
            rect = new Rect();
            vVar2.z(obj4, view, arrayList3);
            z(vVar, obj4, obj2, i10, hVar2.f2887e, hVar2.f2888f);
            if (obj5 != null) {
                vVar2.u(obj5, rect);
            }
        } else {
            rect = null;
        }
        f fVar = r0;
        f fVar2 = new f(vVar, aVar, obj4, hVar, arrayList2, view, fragment, fragment2, z10, arrayList, obj, rect);
        u.a(viewGroup, fVar);
        return obj4;
    }

    private static Object m(v vVar, ViewGroup viewGroup, View view, c0.a<String, String> aVar, h hVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        Rect rect;
        View view2;
        v vVar2 = vVar;
        View view3 = view;
        c0.a<String, String> aVar2 = aVar;
        h hVar2 = hVar;
        ArrayList<View> arrayList3 = arrayList;
        ArrayList<View> arrayList4 = arrayList2;
        Object obj4 = obj;
        Fragment fragment = hVar2.f2883a;
        Fragment fragment2 = hVar2.f2886d;
        if (fragment != null) {
            fragment.requireView().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z10 = hVar2.f2884b;
        Object t10 = aVar.isEmpty() ? null : t(vVar, fragment, fragment2, z10);
        c0.a<String, View> i10 = i(vVar, aVar2, t10, hVar2);
        c0.a<String, View> h10 = h(vVar, aVar2, t10, hVar2);
        if (aVar.isEmpty()) {
            if (i10 != null) {
                i10.clear();
            }
            if (h10 != null) {
                h10.clear();
            }
            obj3 = null;
        } else {
            a(arrayList3, i10, aVar.keySet());
            a(arrayList4, h10, aVar.values());
            obj3 = t10;
        }
        if (obj4 == null && obj2 == null && obj3 == null) {
            return null;
        }
        f(fragment, fragment2, z10, i10, true);
        if (obj3 != null) {
            arrayList4.add(view3);
            vVar.z(obj3, view3, arrayList3);
            z(vVar, obj3, obj2, i10, hVar2.f2887e, hVar2.f2888f);
            Rect rect2 = new Rect();
            View s10 = s(h10, hVar2, obj4, z10);
            if (s10 != null) {
                vVar.u(obj4, rect2);
            }
            rect = rect2;
            view2 = s10;
        } else {
            view2 = null;
            rect = null;
        }
        u.a(viewGroup, new e(fragment, fragment2, z10, h10, view2, vVar, rect));
        return obj3;
    }

    private static void n(ViewGroup viewGroup, h hVar, View view, c0.a<String, String> aVar, g gVar) {
        Object obj;
        ViewGroup viewGroup2 = viewGroup;
        h hVar2 = hVar;
        View view2 = view;
        c0.a<String, String> aVar2 = aVar;
        g gVar2 = gVar;
        Fragment fragment = hVar2.f2883a;
        Fragment fragment2 = hVar2.f2886d;
        v j10 = j(fragment2, fragment);
        if (j10 != null) {
            boolean z10 = hVar2.f2884b;
            boolean z11 = hVar2.f2887e;
            Object q10 = q(j10, fragment, z10);
            Object r10 = r(j10, fragment2, z11);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = arrayList;
            Object obj2 = r10;
            v vVar = j10;
            Object l10 = l(j10, viewGroup, view, aVar, hVar, arrayList, arrayList2, q10, obj2);
            Object obj3 = q10;
            if (obj3 == null && l10 == null) {
                obj = obj2;
                if (obj == null) {
                    return;
                }
            } else {
                obj = obj2;
            }
            ArrayList arrayList4 = arrayList3;
            ArrayList<View> k10 = k(vVar, obj, fragment2, arrayList4, view2);
            if (k10 == null || k10.isEmpty()) {
                obj = null;
            }
            Object obj4 = obj;
            vVar.a(obj3, view2);
            Object u10 = u(vVar, obj3, obj4, l10, fragment, hVar2.f2884b);
            if (!(fragment2 == null || k10 == null || (k10.size() <= 0 && arrayList4.size() <= 0))) {
                t0.b bVar = new t0.b();
                gVar2.b(fragment2, bVar);
                vVar.w(fragment2, u10, bVar, new c(gVar2, fragment2, bVar));
            }
            if (u10 != null) {
                ArrayList arrayList5 = new ArrayList();
                v vVar2 = vVar;
                vVar2.t(u10, obj3, arrayList5, obj4, k10, l10, arrayList2);
                y(vVar2, viewGroup, fragment, view, arrayList2, obj3, arrayList5, obj4, k10);
                ViewGroup viewGroup3 = viewGroup;
                v vVar3 = vVar;
                ArrayList arrayList6 = arrayList2;
                vVar3.x(viewGroup3, arrayList6, aVar2);
                vVar3.c(viewGroup3, u10);
                vVar3.s(viewGroup3, arrayList6, aVar2);
            }
        }
    }

    private static void o(ViewGroup viewGroup, h hVar, View view, c0.a<String, String> aVar, g gVar) {
        Object obj;
        h hVar2 = hVar;
        View view2 = view;
        g gVar2 = gVar;
        Fragment fragment = hVar2.f2883a;
        Fragment fragment2 = hVar2.f2886d;
        v j10 = j(fragment2, fragment);
        if (j10 != null) {
            boolean z10 = hVar2.f2884b;
            boolean z11 = hVar2.f2887e;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Object q10 = q(j10, fragment, z10);
            Object r10 = r(j10, fragment2, z11);
            ArrayList arrayList3 = arrayList2;
            Object m10 = m(j10, viewGroup, view, aVar, hVar, arrayList2, arrayList, q10, r10);
            Object obj2 = q10;
            if (obj2 == null && m10 == null) {
                obj = r10;
                if (obj == null) {
                    return;
                }
            } else {
                obj = r10;
            }
            ArrayList<View> k10 = k(j10, obj, fragment2, arrayList3, view2);
            ArrayList<View> k11 = k(j10, obj2, fragment, arrayList, view2);
            A(k11, 4);
            Fragment fragment3 = fragment;
            ArrayList<View> arrayList4 = k10;
            Object u10 = u(j10, obj2, obj, m10, fragment3, z10);
            if (!(fragment2 == null || arrayList4 == null || (arrayList4.size() <= 0 && arrayList3.size() <= 0))) {
                t0.b bVar = new t0.b();
                g gVar3 = gVar;
                gVar3.b(fragment2, bVar);
                j10.w(fragment2, u10, bVar, new a(gVar3, fragment2, bVar));
            }
            if (u10 != null) {
                v(j10, obj, fragment2, arrayList4);
                ArrayList<String> o10 = j10.o(arrayList);
                v vVar = j10;
                vVar.t(u10, obj2, k11, obj, arrayList4, m10, arrayList);
                ViewGroup viewGroup2 = viewGroup;
                j10.c(viewGroup2, u10);
                vVar.y(viewGroup2, arrayList3, arrayList, o10, aVar);
                A(k11, 0);
                j10.A(m10, arrayList3, arrayList);
            }
        }
    }

    private static h p(h hVar, SparseArray<h> sparseArray, int i10) {
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h();
        sparseArray.put(i10, hVar2);
        return hVar2;
    }

    private static Object q(v vVar, Fragment fragment, boolean z10) {
        if (fragment == null) {
            return null;
        }
        return vVar.g(z10 ? fragment.getReenterTransition() : fragment.getEnterTransition());
    }

    private static Object r(v vVar, Fragment fragment, boolean z10) {
        if (fragment == null) {
            return null;
        }
        return vVar.g(z10 ? fragment.getReturnTransition() : fragment.getExitTransition());
    }

    static View s(c0.a<String, View> aVar, h hVar, Object obj, boolean z10) {
        ArrayList<String> arrayList;
        a aVar2 = hVar.f2885c;
        if (obj == null || aVar == null || (arrayList = aVar2.f2834n) == null || arrayList.isEmpty()) {
            return null;
        }
        return aVar.get((z10 ? aVar2.f2834n : aVar2.f2835o).get(0));
    }

    private static Object t(v vVar, Fragment fragment, Fragment fragment2, boolean z10) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return vVar.B(vVar.g(z10 ? fragment2.getSharedElementReturnTransition() : fragment.getSharedElementEnterTransition()));
    }

    private static Object u(v vVar, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z10) {
        return (obj == null || obj2 == null || fragment == null) ? true : z10 ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap() ? vVar.n(obj2, obj, obj3) : vVar.m(obj2, obj, obj3);
    }

    private static void v(v vVar, Object obj, Fragment fragment, ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.mAdded && fragment.mHidden && fragment.mHiddenChanged) {
            fragment.setHideReplaced(true);
            vVar.r(obj, fragment.getView(), arrayList);
            u.a(fragment.mContainer, new b(arrayList));
        }
    }

    private static v w() {
        try {
            return androidx.transition.d.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static void x(c0.a<String, String> aVar, c0.a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey(aVar.o(size))) {
                aVar.m(size);
            }
        }
    }

    private static void y(v vVar, ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        ViewGroup viewGroup2 = viewGroup;
        u.a(viewGroup, new d(obj, vVar, view, fragment, arrayList, arrayList2, arrayList3, obj2));
    }

    private static void z(v vVar, Object obj, Object obj2, c0.a<String, View> aVar, boolean z10, a aVar2) {
        ArrayList<String> arrayList = aVar2.f2834n;
        if (arrayList != null && !arrayList.isEmpty()) {
            View view = aVar.get((z10 ? aVar2.f2835o : aVar2.f2834n).get(0));
            vVar.v(obj, view);
            if (obj2 != null) {
                vVar.v(obj2, view);
            }
        }
    }
}
