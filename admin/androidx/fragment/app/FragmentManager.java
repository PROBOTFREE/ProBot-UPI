package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.fragment.app.s;
import androidx.fragment.app.t;
import androidx.lifecycle.f0;
import androidx.lifecycle.h;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class FragmentManager {
    private static boolean O = false;
    static boolean P = true;
    private androidx.activity.result.b<IntentSenderRequest> A;
    private androidx.activity.result.b<String[]> B;
    ArrayDeque<LaunchedFragmentInfo> C = new ArrayDeque<>();
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private ArrayList<a> I;
    private ArrayList<Boolean> J;
    private ArrayList<Fragment> K;
    private ArrayList<p> L;
    private l M;
    private Runnable N = new g();

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<n> f2642a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private boolean f2643b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final r f2644c = new r();

    /* renamed from: d  reason: collision with root package name */
    ArrayList<a> f2645d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<Fragment> f2646e;

    /* renamed from: f  reason: collision with root package name */
    private final i f2647f = new i(this);

    /* renamed from: g  reason: collision with root package name */
    private OnBackPressedDispatcher f2648g;

    /* renamed from: h  reason: collision with root package name */
    private final androidx.activity.b f2649h = new c(false);

    /* renamed from: i  reason: collision with root package name */
    private final AtomicInteger f2650i = new AtomicInteger();
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final Map<String, Bundle> f2651j = Collections.synchronizedMap(new HashMap());
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final Map<String, Object> f2652k = Collections.synchronizedMap(new HashMap());

    /* renamed from: l  reason: collision with root package name */
    private ArrayList<m> f2653l;

    /* renamed from: m  reason: collision with root package name */
    private Map<Fragment, HashSet<t0.b>> f2654m = Collections.synchronizedMap(new HashMap());

    /* renamed from: n  reason: collision with root package name */
    private final t.g f2655n = new d();

    /* renamed from: o  reason: collision with root package name */
    private final j f2656o = new j(this);

    /* renamed from: p  reason: collision with root package name */
    private final CopyOnWriteArrayList<m> f2657p = new CopyOnWriteArrayList<>();

    /* renamed from: q  reason: collision with root package name */
    int f2658q = -1;

    /* renamed from: r  reason: collision with root package name */
    private h<?> f2659r;

    /* renamed from: s  reason: collision with root package name */
    private e f2660s;

    /* renamed from: t  reason: collision with root package name */
    private Fragment f2661t;

    /* renamed from: u  reason: collision with root package name */
    Fragment f2662u;

    /* renamed from: v  reason: collision with root package name */
    private g f2663v = null;

    /* renamed from: w  reason: collision with root package name */
    private g f2664w = new e();

    /* renamed from: x  reason: collision with root package name */
    private z f2665x = null;

    /* renamed from: y  reason: collision with root package name */
    private z f2666y = new f(this);

    /* renamed from: z  reason: collision with root package name */
    private androidx.activity.result.b<Intent> f2667z;

    /* renamed from: androidx.fragment.app.FragmentManager$6  reason: invalid class name */
    class AnonymousClass6 implements androidx.lifecycle.m {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f2668a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ o f2669b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ androidx.lifecycle.h f2670c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ FragmentManager f2671d;

        public void c(androidx.lifecycle.o oVar, h.b bVar) {
            Bundle bundle;
            if (bVar == h.b.ON_START && (bundle = (Bundle) this.f2671d.f2651j.get(this.f2668a)) != null) {
                this.f2669b.a(this.f2668a, bundle);
                this.f2671d.r(this.f2668a);
            }
            if (bVar == h.b.ON_DESTROY) {
                this.f2670c.c(this);
                this.f2671d.f2652k.remove(this.f2668a);
            }
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        String f2672a;

        /* renamed from: b  reason: collision with root package name */
        int f2673b;

        class a implements Parcelable.Creator<LaunchedFragmentInfo> {
            a() {
            }

            /* renamed from: a */
            public LaunchedFragmentInfo createFromParcel(Parcel parcel) {
                return new LaunchedFragmentInfo(parcel);
            }

            /* renamed from: b */
            public LaunchedFragmentInfo[] newArray(int i10) {
                return new LaunchedFragmentInfo[i10];
            }
        }

        LaunchedFragmentInfo(Parcel parcel) {
            this.f2672a = parcel.readString();
            this.f2673b = parcel.readInt();
        }

        LaunchedFragmentInfo(String str, int i10) {
            this.f2672a = str;
            this.f2673b = i10;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f2672a);
            parcel.writeInt(this.f2673b);
        }
    }

    class a implements androidx.activity.result.a<ActivityResult> {
        a() {
        }

        /* renamed from: a */
        public void onActivityResult(ActivityResult activityResult) {
            LaunchedFragmentInfo pollFirst = FragmentManager.this.C.pollFirst();
            if (pollFirst == null) {
                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                return;
            }
            String str = pollFirst.f2672a;
            int i10 = pollFirst.f2673b;
            Fragment i11 = FragmentManager.this.f2644c.i(str);
            if (i11 == null) {
                Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
                return;
            }
            i11.onActivityResult(i10, activityResult.b(), activityResult.a());
        }
    }

    class b implements androidx.activity.result.a<Map<String, Boolean>> {
        b() {
        }

        @SuppressLint({"SyntheticAccessor"})
        /* renamed from: a */
        public void onActivityResult(Map<String, Boolean> map) {
            StringBuilder sb2;
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map.values());
            int[] iArr = new int[arrayList.size()];
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                iArr[i10] = ((Boolean) arrayList.get(i10)).booleanValue() ? 0 : -1;
            }
            LaunchedFragmentInfo pollFirst = FragmentManager.this.C.pollFirst();
            if (pollFirst == null) {
                sb2 = new StringBuilder();
                sb2.append("No permissions were requested for ");
                sb2.append(this);
            } else {
                String str = pollFirst.f2672a;
                int i11 = pollFirst.f2673b;
                Fragment i12 = FragmentManager.this.f2644c.i(str);
                if (i12 == null) {
                    sb2 = new StringBuilder();
                    sb2.append("Permission request result delivered for unknown Fragment ");
                    sb2.append(str);
                } else {
                    i12.onRequestPermissionsResult(i11, strArr, iArr);
                    return;
                }
            }
            Log.w("FragmentManager", sb2.toString());
        }
    }

    class c extends androidx.activity.b {
        c(boolean z10) {
            super(z10);
        }

        public void handleOnBackPressed() {
            FragmentManager.this.D0();
        }
    }

    class d implements t.g {
        d() {
        }

        public void a(Fragment fragment, t0.b bVar) {
            if (!bVar.b()) {
                FragmentManager.this.f1(fragment, bVar);
            }
        }

        public void b(Fragment fragment, t0.b bVar) {
            FragmentManager.this.f(fragment, bVar);
        }
    }

    class e extends g {
        e() {
        }

        public Fragment instantiate(ClassLoader classLoader, String str) {
            return FragmentManager.this.v0().b(FragmentManager.this.v0().f(), str, (Bundle) null);
        }
    }

    class f implements z {
        f(FragmentManager fragmentManager) {
        }

        public y a(ViewGroup viewGroup) {
            return new b(viewGroup);
        }
    }

    class g implements Runnable {
        g() {
        }

        public void run() {
            FragmentManager.this.b0(true);
        }
    }

    class h extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f2680a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f2681b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Fragment f2682c;

        h(FragmentManager fragmentManager, ViewGroup viewGroup, View view, Fragment fragment) {
            this.f2680a = viewGroup;
            this.f2681b = view;
            this.f2682c = fragment;
        }

        public void onAnimationEnd(Animator animator) {
            this.f2680a.endViewTransition(this.f2681b);
            animator.removeListener(this);
            Fragment fragment = this.f2682c;
            View view = fragment.mView;
            if (view != null && fragment.mHidden) {
                view.setVisibility(8);
            }
        }
    }

    class i implements m {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Fragment f2683a;

        i(FragmentManager fragmentManager, Fragment fragment) {
            this.f2683a = fragment;
        }

        public void a(FragmentManager fragmentManager, Fragment fragment) {
            this.f2683a.onAttachFragment(fragment);
        }
    }

    class j implements androidx.activity.result.a<ActivityResult> {
        j() {
        }

        /* renamed from: a */
        public void onActivityResult(ActivityResult activityResult) {
            LaunchedFragmentInfo pollFirst = FragmentManager.this.C.pollFirst();
            if (pollFirst == null) {
                Log.w("FragmentManager", "No Activities were started for result for " + this);
                return;
            }
            String str = pollFirst.f2672a;
            int i10 = pollFirst.f2673b;
            Fragment i11 = FragmentManager.this.f2644c.i(str);
            if (i11 == null) {
                Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
                return;
            }
            i11.onActivityResult(i10, activityResult.b(), activityResult.a());
        }
    }

    static class k extends i.a<IntentSenderRequest, ActivityResult> {
        k() {
        }

        /* renamed from: d */
        public Intent a(Context context, IntentSenderRequest intentSenderRequest) {
            Bundle bundleExtra;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent a10 = intentSenderRequest.a();
            if (!(a10 == null || (bundleExtra = a10.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) == null)) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                a10.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (a10.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    intentSenderRequest = new IntentSenderRequest.b(intentSenderRequest.d()).b((Intent) null).c(intentSenderRequest.c(), intentSenderRequest.b()).a();
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", intentSenderRequest);
            if (FragmentManager.H0(2)) {
                Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        /* renamed from: e */
        public ActivityResult c(int i10, Intent intent) {
            return new ActivityResult(i10, intent);
        }
    }

    public static abstract class l {
    }

    public interface m {
        void a();
    }

    interface n {
        boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2);
    }

    private class o implements n {

        /* renamed from: a  reason: collision with root package name */
        final String f2685a;

        /* renamed from: b  reason: collision with root package name */
        final int f2686b;

        /* renamed from: c  reason: collision with root package name */
        final int f2687c;

        o(String str, int i10, int i11) {
            this.f2685a = str;
            this.f2686b = i10;
            this.f2687c = i11;
        }

        public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
            Fragment fragment = FragmentManager.this.f2662u;
            if (fragment != null && this.f2686b < 0 && this.f2685a == null && fragment.getChildFragmentManager().a1()) {
                return false;
            }
            return FragmentManager.this.c1(arrayList, arrayList2, this.f2685a, this.f2686b, this.f2687c);
        }
    }

    static class p implements Fragment.l {

        /* renamed from: a  reason: collision with root package name */
        final boolean f2689a;

        /* renamed from: b  reason: collision with root package name */
        final a f2690b;

        /* renamed from: c  reason: collision with root package name */
        private int f2691c;

        p(a aVar, boolean z10) {
            this.f2689a = z10;
            this.f2690b = aVar;
        }

        public void a() {
            int i10 = this.f2691c - 1;
            this.f2691c = i10;
            if (i10 == 0) {
                this.f2690b.f2725r.o1();
            }
        }

        public void b() {
            this.f2691c++;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            a aVar = this.f2690b;
            aVar.f2725r.u(aVar, this.f2689a, false, false);
        }

        /* access modifiers changed from: package-private */
        public void d() {
            boolean z10 = this.f2691c > 0;
            for (Fragment next : this.f2690b.f2725r.u0()) {
                next.setOnStartEnterTransitionListener((Fragment.l) null);
                if (z10 && next.isPostponed()) {
                    next.startPostponedEnterTransition();
                }
            }
            a aVar = this.f2690b;
            aVar.f2725r.u(aVar, this.f2689a, !z10, true);
        }

        public boolean e() {
            return this.f2691c == 0;
        }
    }

    static Fragment B0(View view) {
        Object tag = view.getTag(g1.b.fragment_container_view_tag);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    static boolean H0(int i10) {
        return O || Log.isLoggable("FragmentManager", i10);
    }

    private boolean I0(Fragment fragment) {
        return (fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.o();
    }

    private void M(Fragment fragment) {
        if (fragment != null && fragment.equals(h0(fragment.mWho))) {
            fragment.performPrimaryNavigationFragmentChanged();
        }
    }

    private void Q0(c0.b<Fragment> bVar) {
        int size = bVar.size();
        for (int i10 = 0; i10 < size; i10++) {
            Fragment v10 = bVar.v(i10);
            if (!v10.mAdded) {
                View requireView = v10.requireView();
                v10.mPostponedAlpha = requireView.getAlpha();
                requireView.setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: finally extract failed */
    private void T(int i10) {
        try {
            this.f2643b = true;
            this.f2644c.d(i10);
            S0(i10, false);
            if (P) {
                for (y j10 : s()) {
                    j10.j();
                }
            }
            this.f2643b = false;
            b0(true);
        } catch (Throwable th) {
            this.f2643b = false;
            throw th;
        }
    }

    private void W() {
        if (this.H) {
            this.H = false;
            v1();
        }
    }

    private void Y() {
        if (P) {
            for (y j10 : s()) {
                j10.j();
            }
        } else if (!this.f2654m.isEmpty()) {
            for (Fragment next : this.f2654m.keySet()) {
                n(next);
                T0(next);
            }
        }
    }

    private void a0(boolean z10) {
        if (this.f2643b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.f2659r == null) {
            if (this.G) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            throw new IllegalStateException("FragmentManager has not been attached to a host.");
        } else if (Looper.myLooper() == this.f2659r.g().getLooper()) {
            if (!z10) {
                p();
            }
            if (this.I == null) {
                this.I = new ArrayList<>();
                this.J = new ArrayList<>();
            }
            this.f2643b = true;
            try {
                g0((ArrayList<a>) null, (ArrayList<Boolean>) null);
            } finally {
                this.f2643b = false;
            }
        } else {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
    }

    private boolean b1(String str, int i10, int i11) {
        b0(false);
        a0(true);
        Fragment fragment = this.f2662u;
        if (fragment != null && i10 < 0 && str == null && fragment.getChildFragmentManager().a1()) {
            return true;
        }
        boolean c12 = c1(this.I, this.J, str, i10, i11);
        if (c12) {
            this.f2643b = true;
            try {
                h1(this.I, this.J);
            } finally {
                q();
            }
        }
        x1();
        W();
        this.f2644c.b();
        return c12;
    }

    private void d(c0.b<Fragment> bVar) {
        int i10 = this.f2658q;
        if (i10 >= 1) {
            int min = Math.min(i10, 5);
            for (Fragment next : this.f2644c.n()) {
                if (next.mState < min) {
                    U0(next, min);
                    if (next.mView != null && !next.mHidden && next.mIsNewlyAdded) {
                        bVar.add(next);
                    }
                }
            }
        }
    }

    private static void d0(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i10, int i11) {
        while (i10 < i11) {
            a aVar = arrayList.get(i10);
            boolean z10 = true;
            if (arrayList2.get(i10).booleanValue()) {
                aVar.x(-1);
                if (i10 != i11 - 1) {
                    z10 = false;
                }
                aVar.C(z10);
            } else {
                aVar.x(1);
                aVar.B();
            }
            i10++;
        }
    }

    private int d1(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i10, int i11, c0.b<Fragment> bVar) {
        int i12 = i11;
        for (int i13 = i11 - 1; i13 >= i10; i13--) {
            a aVar = arrayList.get(i13);
            boolean booleanValue = arrayList2.get(i13).booleanValue();
            if (aVar.I() && !aVar.G(arrayList, i13 + 1, i11)) {
                if (this.L == null) {
                    this.L = new ArrayList<>();
                }
                p pVar = new p(aVar, booleanValue);
                this.L.add(pVar);
                aVar.K(pVar);
                if (booleanValue) {
                    aVar.B();
                } else {
                    aVar.C(false);
                }
                i12--;
                if (i13 != i12) {
                    arrayList.remove(i13);
                    arrayList.add(i12, aVar);
                }
                d(bVar);
            }
        }
        return i12;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v4, resolved type: int} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e0(java.util.ArrayList<androidx.fragment.app.a> r18, java.util.ArrayList<java.lang.Boolean> r19, int r20, int r21) {
        /*
            r17 = this;
            r6 = r17
            r15 = r18
            r5 = r19
            r4 = r20
            r3 = r21
            java.lang.Object r0 = r15.get(r4)
            androidx.fragment.app.a r0 = (androidx.fragment.app.a) r0
            boolean r2 = r0.f2836p
            java.util.ArrayList<androidx.fragment.app.Fragment> r0 = r6.K
            if (r0 != 0) goto L_0x001e
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r6.K = r0
            goto L_0x0021
        L_0x001e:
            r0.clear()
        L_0x0021:
            java.util.ArrayList<androidx.fragment.app.Fragment> r0 = r6.K
            androidx.fragment.app.r r1 = r6.f2644c
            java.util.List r1 = r1.n()
            r0.addAll(r1)
            androidx.fragment.app.Fragment r0 = r17.z0()
            r1 = 0
            r16 = r1
            r7 = r4
        L_0x0034:
            r14 = 1
            if (r7 >= r3) goto L_0x0065
            java.lang.Object r8 = r15.get(r7)
            androidx.fragment.app.a r8 = (androidx.fragment.app.a) r8
            java.lang.Object r9 = r5.get(r7)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L_0x0050
            java.util.ArrayList<androidx.fragment.app.Fragment> r9 = r6.K
            androidx.fragment.app.Fragment r0 = r8.D(r9, r0)
            goto L_0x0056
        L_0x0050:
            java.util.ArrayList<androidx.fragment.app.Fragment> r9 = r6.K
            androidx.fragment.app.Fragment r0 = r8.L(r9, r0)
        L_0x0056:
            if (r16 != 0) goto L_0x0060
            boolean r8 = r8.f2827g
            if (r8 == 0) goto L_0x005d
            goto L_0x0060
        L_0x005d:
            r16 = r1
            goto L_0x0062
        L_0x0060:
            r16 = r14
        L_0x0062:
            int r7 = r7 + 1
            goto L_0x0034
        L_0x0065:
            java.util.ArrayList<androidx.fragment.app.Fragment> r0 = r6.K
            r0.clear()
            if (r2 != 0) goto L_0x00bd
            int r0 = r6.f2658q
            if (r0 < r14) goto L_0x00bd
            boolean r0 = P
            if (r0 == 0) goto L_0x00a4
            r0 = r4
        L_0x0075:
            if (r0 >= r3) goto L_0x00bd
            java.lang.Object r1 = r15.get(r0)
            androidx.fragment.app.a r1 = (androidx.fragment.app.a) r1
            java.util.ArrayList<androidx.fragment.app.s$a> r1 = r1.f2821a
            java.util.Iterator r1 = r1.iterator()
        L_0x0083:
            boolean r7 = r1.hasNext()
            if (r7 == 0) goto L_0x00a1
            java.lang.Object r7 = r1.next()
            androidx.fragment.app.s$a r7 = (androidx.fragment.app.s.a) r7
            androidx.fragment.app.Fragment r7 = r7.f2839b
            if (r7 == 0) goto L_0x0083
            androidx.fragment.app.FragmentManager r8 = r7.mFragmentManager
            if (r8 == 0) goto L_0x0083
            androidx.fragment.app.p r7 = r6.w(r7)
            androidx.fragment.app.r r8 = r6.f2644c
            r8.p(r7)
            goto L_0x0083
        L_0x00a1:
            int r0 = r0 + 1
            goto L_0x0075
        L_0x00a4:
            androidx.fragment.app.h<?> r0 = r6.f2659r
            android.content.Context r7 = r0.f()
            androidx.fragment.app.e r8 = r6.f2660s
            r13 = 0
            androidx.fragment.app.t$g r0 = r6.f2655n
            r9 = r18
            r10 = r19
            r11 = r20
            r12 = r21
            r1 = r14
            r14 = r0
            androidx.fragment.app.t.B(r7, r8, r9, r10, r11, r12, r13, r14)
            goto L_0x00be
        L_0x00bd:
            r1 = r14
        L_0x00be:
            d0(r18, r19, r20, r21)
            boolean r0 = P
            if (r0 == 0) goto L_0x0143
            int r0 = r3 + -1
            java.lang.Object r0 = r5.get(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r2 = r4
        L_0x00d2:
            if (r2 >= r3) goto L_0x011c
            java.lang.Object r7 = r15.get(r2)
            androidx.fragment.app.a r7 = (androidx.fragment.app.a) r7
            if (r0 == 0) goto L_0x00fb
            java.util.ArrayList<androidx.fragment.app.s$a> r8 = r7.f2821a
            int r8 = r8.size()
            int r8 = r8 - r1
        L_0x00e3:
            if (r8 < 0) goto L_0x0119
            java.util.ArrayList<androidx.fragment.app.s$a> r9 = r7.f2821a
            java.lang.Object r9 = r9.get(r8)
            androidx.fragment.app.s$a r9 = (androidx.fragment.app.s.a) r9
            androidx.fragment.app.Fragment r9 = r9.f2839b
            if (r9 == 0) goto L_0x00f8
            androidx.fragment.app.p r9 = r6.w(r9)
            r9.m()
        L_0x00f8:
            int r8 = r8 + -1
            goto L_0x00e3
        L_0x00fb:
            java.util.ArrayList<androidx.fragment.app.s$a> r7 = r7.f2821a
            java.util.Iterator r7 = r7.iterator()
        L_0x0101:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0119
            java.lang.Object r8 = r7.next()
            androidx.fragment.app.s$a r8 = (androidx.fragment.app.s.a) r8
            androidx.fragment.app.Fragment r8 = r8.f2839b
            if (r8 == 0) goto L_0x0101
            androidx.fragment.app.p r8 = r6.w(r8)
            r8.m()
            goto L_0x0101
        L_0x0119:
            int r2 = r2 + 1
            goto L_0x00d2
        L_0x011c:
            int r2 = r6.f2658q
            r6.S0(r2, r1)
            java.util.Set r1 = r6.t(r15, r4, r3)
            java.util.Iterator r1 = r1.iterator()
        L_0x0129:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x013f
            java.lang.Object r2 = r1.next()
            androidx.fragment.app.y r2 = (androidx.fragment.app.y) r2
            r2.r(r0)
            r2.p()
            r2.g()
            goto L_0x0129
        L_0x013f:
            r0 = r3
            r3 = r5
            goto L_0x0199
        L_0x0143:
            if (r2 == 0) goto L_0x0165
            c0.b r7 = new c0.b
            r7.<init>()
            r6.d(r7)
            r0 = r17
            r14 = r1
            r1 = r18
            r8 = r2
            r2 = r19
            r13 = r3
            r3 = r20
            r12 = r4
            r4 = r21
            r11 = r5
            r5 = r7
            int r0 = r0.d1(r1, r2, r3, r4, r5)
            r6.Q0(r7)
            goto L_0x016b
        L_0x0165:
            r14 = r1
            r8 = r2
            r13 = r3
            r12 = r4
            r11 = r5
            r0 = r13
        L_0x016b:
            if (r0 == r12) goto L_0x0197
            if (r8 == 0) goto L_0x0197
            int r1 = r6.f2658q
            if (r1 < r14) goto L_0x018e
            androidx.fragment.app.h<?> r1 = r6.f2659r
            android.content.Context r7 = r1.f()
            androidx.fragment.app.e r8 = r6.f2660s
            r1 = 1
            androidx.fragment.app.t$g r2 = r6.f2655n
            r9 = r18
            r10 = r19
            r3 = r11
            r11 = r20
            r12 = r0
            r0 = r13
            r13 = r1
            r1 = r14
            r14 = r2
            androidx.fragment.app.t.B(r7, r8, r9, r10, r11, r12, r13, r14)
            goto L_0x0191
        L_0x018e:
            r3 = r11
            r0 = r13
            r1 = r14
        L_0x0191:
            int r2 = r6.f2658q
            r6.S0(r2, r1)
            goto L_0x0199
        L_0x0197:
            r3 = r11
            r0 = r13
        L_0x0199:
            r1 = r20
        L_0x019b:
            if (r1 >= r0) goto L_0x01bc
            java.lang.Object r2 = r15.get(r1)
            androidx.fragment.app.a r2 = (androidx.fragment.app.a) r2
            java.lang.Object r4 = r3.get(r1)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x01b6
            int r4 = r2.f2727t
            if (r4 < 0) goto L_0x01b6
            r4 = -1
            r2.f2727t = r4
        L_0x01b6:
            r2.J()
            int r1 = r1 + 1
            goto L_0x019b
        L_0x01bc:
            if (r16 == 0) goto L_0x01c1
            r17.j1()
        L_0x01c1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.e0(java.util.ArrayList, java.util.ArrayList, int, int):void");
    }

    private void g0(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<p> arrayList3 = this.L;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i10 = 0;
        while (i10 < size) {
            p pVar = this.L.get(i10);
            if (arrayList == null || pVar.f2689a || (indexOf2 = arrayList.indexOf(pVar.f2690b)) == -1 || arrayList2 == null || !arrayList2.get(indexOf2).booleanValue()) {
                if (pVar.e() || (arrayList != null && pVar.f2690b.G(arrayList, 0, arrayList.size()))) {
                    this.L.remove(i10);
                    i10--;
                    size--;
                    if (arrayList == null || pVar.f2689a || (indexOf = arrayList.indexOf(pVar.f2690b)) == -1 || arrayList2 == null || !arrayList2.get(indexOf).booleanValue()) {
                        pVar.d();
                    }
                }
                i10++;
            } else {
                this.L.remove(i10);
                i10--;
                size--;
            }
            pVar.c();
            i10++;
        }
    }

    private void h1(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (!arrayList.isEmpty()) {
            if (arrayList.size() == arrayList2.size()) {
                g0(arrayList, arrayList2);
                int size = arrayList.size();
                int i10 = 0;
                int i11 = 0;
                while (i10 < size) {
                    if (!arrayList.get(i10).f2836p) {
                        if (i11 != i10) {
                            e0(arrayList, arrayList2, i11, i10);
                        }
                        i11 = i10 + 1;
                        if (arrayList2.get(i10).booleanValue()) {
                            while (i11 < size && arrayList2.get(i11).booleanValue() && !arrayList.get(i11).f2836p) {
                                i11++;
                            }
                        }
                        e0(arrayList, arrayList2, i10, i11);
                        i10 = i11 - 1;
                    }
                    i10++;
                }
                if (i11 != size) {
                    e0(arrayList, arrayList2, i11, size);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error with the back stack records");
        }
    }

    private void j1() {
        if (this.f2653l != null) {
            for (int i10 = 0; i10 < this.f2653l.size(); i10++) {
                this.f2653l.get(i10).a();
            }
        }
    }

    private void l0() {
        if (P) {
            for (y k10 : s()) {
                k10.k();
            }
        } else if (this.L != null) {
            while (!this.L.isEmpty()) {
                this.L.remove(0).d();
            }
        }
    }

    static int l1(int i10) {
        if (i10 == 4097) {
            return 8194;
        }
        if (i10 != 4099) {
            return i10 != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    private boolean m0(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this.f2642a) {
            if (this.f2642a.isEmpty()) {
                return false;
            }
            int size = this.f2642a.size();
            boolean z10 = false;
            for (int i10 = 0; i10 < size; i10++) {
                z10 |= this.f2642a.get(i10).a(arrayList, arrayList2);
            }
            this.f2642a.clear();
            this.f2659r.g().removeCallbacks(this.N);
            return z10;
        }
    }

    private void n(Fragment fragment) {
        HashSet hashSet = this.f2654m.get(fragment);
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ((t0.b) it.next()).a();
            }
            hashSet.clear();
            x(fragment);
            this.f2654m.remove(fragment);
        }
    }

    private l o0(Fragment fragment) {
        return this.M.d(fragment);
    }

    private void p() {
        if (M0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private void q() {
        this.f2643b = false;
        this.J.clear();
        this.I.clear();
    }

    private ViewGroup r0(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId > 0 && this.f2660s.d()) {
            View c10 = this.f2660s.c(fragment.mContainerId);
            if (c10 instanceof ViewGroup) {
                return (ViewGroup) c10;
            }
        }
        return null;
    }

    private Set<y> s() {
        HashSet hashSet = new HashSet();
        for (p k10 : this.f2644c.k()) {
            ViewGroup viewGroup = k10.k().mContainer;
            if (viewGroup != null) {
                hashSet.add(y.o(viewGroup, A0()));
            }
        }
        return hashSet;
    }

    private Set<y> t(ArrayList<a> arrayList, int i10, int i11) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i10 < i11) {
            Iterator<s.a> it = arrayList.get(i10).f2821a.iterator();
            while (it.hasNext()) {
                Fragment fragment = it.next().f2839b;
                if (!(fragment == null || (viewGroup = fragment.mContainer) == null)) {
                    hashSet.add(y.n(viewGroup, this));
                }
            }
            i10++;
        }
        return hashSet;
    }

    private void t1(Fragment fragment) {
        ViewGroup r02 = r0(fragment);
        if (r02 != null && fragment.getEnterAnim() + fragment.getExitAnim() + fragment.getPopEnterAnim() + fragment.getPopExitAnim() > 0) {
            int i10 = g1.b.visible_removing_fragment_view_tag;
            if (r02.getTag(i10) == null) {
                r02.setTag(i10, fragment);
            }
            ((Fragment) r02.getTag(i10)).setPopDirection(fragment.getPopDirection());
        }
    }

    private void v(Fragment fragment) {
        Animator animator;
        if (fragment.mView != null) {
            d.C0027d c10 = d.c(this.f2659r.f(), fragment, !fragment.mHidden, fragment.getPopDirection());
            if (c10 == null || (animator = c10.f2780b) == null) {
                if (c10 != null) {
                    fragment.mView.startAnimation(c10.f2779a);
                    c10.f2779a.start();
                }
                fragment.mView.setVisibility((!fragment.mHidden || fragment.isHideReplaced()) ? 0 : 8);
                if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                }
            } else {
                animator.setTarget(fragment.mView);
                if (!fragment.mHidden) {
                    fragment.mView.setVisibility(0);
                } else if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                } else {
                    ViewGroup viewGroup = fragment.mContainer;
                    View view = fragment.mView;
                    viewGroup.startViewTransition(view);
                    c10.f2780b.addListener(new h(this, viewGroup, view, fragment));
                }
                c10.f2780b.start();
            }
        }
        F0(fragment);
        fragment.mHiddenChanged = false;
        fragment.onHiddenChanged(fragment.mHidden);
    }

    private void v1() {
        for (p X0 : this.f2644c.k()) {
            X0(X0);
        }
    }

    private void w1(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new x("FragmentManager"));
        h<?> hVar = this.f2659r;
        if (hVar != null) {
            try {
                hVar.h("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e10) {
                Log.e("FragmentManager", "Failed dumping state", e10);
            }
        } else {
            X("  ", (FileDescriptor) null, printWriter, new String[0]);
        }
        throw runtimeException;
    }

    private void x(Fragment fragment) {
        fragment.performDestroyView();
        this.f2656o.n(fragment, false);
        fragment.mContainer = null;
        fragment.mView = null;
        fragment.mViewLifecycleOwner = null;
        fragment.mViewLifecycleOwnerLiveData.l(null);
        fragment.mInLayout = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        if (n0() <= 0) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        if (K0(r3.f2661t) == false) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
        r0.setEnabled(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        r0 = r3.f2649h;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void x1() {
        /*
            r3 = this;
            java.util.ArrayList<androidx.fragment.app.FragmentManager$n> r0 = r3.f2642a
            monitor-enter(r0)
            java.util.ArrayList<androidx.fragment.app.FragmentManager$n> r1 = r3.f2642a     // Catch:{ all -> 0x002a }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x002a }
            r2 = 1
            if (r1 != 0) goto L_0x0013
            androidx.activity.b r1 = r3.f2649h     // Catch:{ all -> 0x002a }
            r1.setEnabled(r2)     // Catch:{ all -> 0x002a }
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            androidx.activity.b r0 = r3.f2649h
            int r1 = r3.n0()
            if (r1 <= 0) goto L_0x0025
            androidx.fragment.app.Fragment r1 = r3.f2661t
            boolean r1 = r3.K0(r1)
            if (r1 == 0) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r2 = 0
        L_0x0026:
            r0.setEnabled(r2)
            return
        L_0x002a:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.x1():void");
    }

    /* access modifiers changed from: package-private */
    public void A() {
        this.E = false;
        this.F = false;
        this.M.j(false);
        T(0);
    }

    /* access modifiers changed from: package-private */
    public z A0() {
        z zVar = this.f2665x;
        if (zVar != null) {
            return zVar;
        }
        Fragment fragment = this.f2661t;
        return fragment != null ? fragment.mFragmentManager.A0() : this.f2666y;
    }

    /* access modifiers changed from: package-private */
    public void B(Configuration configuration) {
        for (Fragment next : this.f2644c.n()) {
            if (next != null) {
                next.performConfigurationChanged(configuration);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean C(MenuItem menuItem) {
        if (this.f2658q < 1) {
            return false;
        }
        for (Fragment next : this.f2644c.n()) {
            if (next != null && next.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public f0 C0(Fragment fragment) {
        return this.M.g(fragment);
    }

    /* access modifiers changed from: package-private */
    public void D() {
        this.E = false;
        this.F = false;
        this.M.j(false);
        T(1);
    }

    /* access modifiers changed from: package-private */
    public void D0() {
        b0(true);
        if (this.f2649h.isEnabled()) {
            a1();
        } else {
            this.f2648g.c();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean E(Menu menu, MenuInflater menuInflater) {
        if (this.f2658q < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z10 = false;
        for (Fragment next : this.f2644c.n()) {
            if (next != null && J0(next) && next.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(next);
                z10 = true;
            }
        }
        if (this.f2646e != null) {
            for (int i10 = 0; i10 < this.f2646e.size(); i10++) {
                Fragment fragment = this.f2646e.get(i10);
                if (arrayList == null || !arrayList.contains(fragment)) {
                    fragment.onDestroyOptionsMenu();
                }
            }
        }
        this.f2646e = arrayList;
        return z10;
    }

    /* access modifiers changed from: package-private */
    public void E0(Fragment fragment) {
        if (H0(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
            t1(fragment);
        }
    }

    /* access modifiers changed from: package-private */
    public void F() {
        this.G = true;
        b0(true);
        Y();
        T(-1);
        this.f2659r = null;
        this.f2660s = null;
        this.f2661t = null;
        if (this.f2648g != null) {
            this.f2649h.remove();
            this.f2648g = null;
        }
        androidx.activity.result.b<Intent> bVar = this.f2667z;
        if (bVar != null) {
            bVar.c();
            this.A.c();
            this.B.c();
        }
    }

    /* access modifiers changed from: package-private */
    public void F0(Fragment fragment) {
        if (fragment.mAdded && I0(fragment)) {
            this.D = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void G() {
        T(1);
    }

    public boolean G0() {
        return this.G;
    }

    /* access modifiers changed from: package-private */
    public void H() {
        for (Fragment next : this.f2644c.n()) {
            if (next != null) {
                next.performLowMemory();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void I(boolean z10) {
        for (Fragment next : this.f2644c.n()) {
            if (next != null) {
                next.performMultiWindowModeChanged(z10);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void J(Fragment fragment) {
        Iterator<m> it = this.f2657p.iterator();
        while (it.hasNext()) {
            it.next().a(this, fragment);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean J0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.isMenuVisible();
    }

    /* access modifiers changed from: package-private */
    public boolean K(MenuItem menuItem) {
        if (this.f2658q < 1) {
            return false;
        }
        for (Fragment next : this.f2644c.n()) {
            if (next != null && next.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean K0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        return fragment.equals(fragmentManager.z0()) && K0(fragmentManager.f2661t);
    }

    /* access modifiers changed from: package-private */
    public void L(Menu menu) {
        if (this.f2658q >= 1) {
            for (Fragment next : this.f2644c.n()) {
                if (next != null) {
                    next.performOptionsMenuClosed(menu);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean L0(int i10) {
        return this.f2658q >= i10;
    }

    public boolean M0() {
        return this.E || this.F;
    }

    /* access modifiers changed from: package-private */
    public void N() {
        T(5);
    }

    /* access modifiers changed from: package-private */
    public void N0(Fragment fragment, String[] strArr, int i10) {
        if (this.B != null) {
            this.C.addLast(new LaunchedFragmentInfo(fragment.mWho, i10));
            this.B.a(strArr);
            return;
        }
        this.f2659r.k(fragment, strArr, i10);
    }

    /* access modifiers changed from: package-private */
    public void O(boolean z10) {
        for (Fragment next : this.f2644c.n()) {
            if (next != null) {
                next.performPictureInPictureModeChanged(z10);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void O0(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i10, Bundle bundle) {
        if (this.f2667z != null) {
            this.C.addLast(new LaunchedFragmentInfo(fragment.mWho, i10));
            if (!(intent == null || bundle == null)) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
            }
            this.f2667z.a(intent);
            return;
        }
        this.f2659r.n(fragment, intent, i10, bundle);
    }

    /* access modifiers changed from: package-private */
    public boolean P(Menu menu) {
        boolean z10 = false;
        if (this.f2658q < 1) {
            return false;
        }
        for (Fragment next : this.f2644c.n()) {
            if (next != null && J0(next) && next.performPrepareOptionsMenu(menu)) {
                z10 = true;
            }
        }
        return z10;
    }

    /* access modifiers changed from: package-private */
    public void P0(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) {
        Intent intent2;
        Fragment fragment2 = fragment;
        Bundle bundle2 = bundle;
        if (this.A != null) {
            if (bundle2 != null) {
                if (intent == null) {
                    intent2 = new Intent();
                    intent2.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
                } else {
                    intent2 = intent;
                }
                if (H0(2)) {
                    Log.v("FragmentManager", "ActivityOptions " + bundle2 + " were added to fillInIntent " + intent2 + " for fragment " + fragment);
                }
                intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle2);
            } else {
                intent2 = intent;
            }
            IntentSender intentSender2 = intentSender;
            IntentSenderRequest a10 = new IntentSenderRequest.b(intentSender).b(intent2).c(i12, i11).a();
            int i14 = i10;
            this.C.addLast(new LaunchedFragmentInfo(fragment2.mWho, i10));
            if (H0(2)) {
                Log.v("FragmentManager", "Fragment " + fragment + "is launching an IntentSender for result ");
            }
            this.A.a(a10);
            return;
        }
        IntentSender intentSender3 = intentSender;
        int i15 = i10;
        int i16 = i11;
        int i17 = i12;
        this.f2659r.o(fragment, intentSender, i10, intent, i11, i12, i13, bundle);
    }

    /* access modifiers changed from: package-private */
    public void Q() {
        x1();
        M(this.f2662u);
    }

    /* access modifiers changed from: package-private */
    public void R() {
        this.E = false;
        this.F = false;
        this.M.j(false);
        T(7);
    }

    /* access modifiers changed from: package-private */
    public void R0(Fragment fragment) {
        if (this.f2644c.c(fragment.mWho)) {
            T0(fragment);
            View view = fragment.mView;
            if (!(view == null || !fragment.mIsNewlyAdded || fragment.mContainer == null)) {
                float f10 = fragment.mPostponedAlpha;
                if (f10 > 0.0f) {
                    view.setAlpha(f10);
                }
                fragment.mPostponedAlpha = 0.0f;
                fragment.mIsNewlyAdded = false;
                d.C0027d c10 = d.c(this.f2659r.f(), fragment, true, fragment.getPopDirection());
                if (c10 != null) {
                    Animation animation = c10.f2779a;
                    if (animation != null) {
                        fragment.mView.startAnimation(animation);
                    } else {
                        c10.f2780b.setTarget(fragment.mView);
                        c10.f2780b.start();
                    }
                }
            }
            if (fragment.mHiddenChanged) {
                v(fragment);
            }
        } else if (H0(3)) {
            Log.d("FragmentManager", "Ignoring moving " + fragment + " to state " + this.f2658q + "since it is not added to " + this);
        }
    }

    /* access modifiers changed from: package-private */
    public void S() {
        this.E = false;
        this.F = false;
        this.M.j(false);
        T(5);
    }

    /* access modifiers changed from: package-private */
    public void S0(int i10, boolean z10) {
        h<?> hVar;
        if (this.f2659r == null && i10 != -1) {
            throw new IllegalStateException("No activity");
        } else if (z10 || i10 != this.f2658q) {
            this.f2658q = i10;
            if (P) {
                this.f2644c.r();
            } else {
                for (Fragment R0 : this.f2644c.n()) {
                    R0(R0);
                }
                for (p next : this.f2644c.k()) {
                    Fragment k10 = next.k();
                    if (!k10.mIsNewlyAdded) {
                        R0(k10);
                    }
                    if (k10.mRemoving && !k10.isInBackStack()) {
                        this.f2644c.q(next);
                    }
                }
            }
            v1();
            if (this.D && (hVar = this.f2659r) != null && this.f2658q == 7) {
                hVar.p();
                this.D = false;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void T0(Fragment fragment) {
        U0(fragment, this.f2658q);
    }

    /* access modifiers changed from: package-private */
    public void U() {
        this.F = true;
        this.M.j(true);
        T(4);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0053, code lost:
        if (r2 != 5) goto L_0x0164;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0160  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void U0(androidx.fragment.app.Fragment r11, int r12) {
        /*
            r10 = this;
            androidx.fragment.app.r r0 = r10.f2644c
            java.lang.String r1 = r11.mWho
            androidx.fragment.app.p r0 = r0.m(r1)
            r1 = 1
            if (r0 != 0) goto L_0x0017
            androidx.fragment.app.p r0 = new androidx.fragment.app.p
            androidx.fragment.app.j r2 = r10.f2656o
            androidx.fragment.app.r r3 = r10.f2644c
            r0.<init>(r2, r3, r11)
            r0.u(r1)
        L_0x0017:
            boolean r2 = r11.mFromLayout
            r3 = 2
            if (r2 == 0) goto L_0x0028
            boolean r2 = r11.mInLayout
            if (r2 == 0) goto L_0x0028
            int r2 = r11.mState
            if (r2 != r3) goto L_0x0028
            int r12 = java.lang.Math.max(r12, r3)
        L_0x0028:
            int r2 = r0.d()
            int r12 = java.lang.Math.min(r12, r2)
            int r2 = r11.mState
            r4 = 3
            java.lang.String r5 = "FragmentManager"
            r6 = -1
            r7 = 5
            r8 = 4
            if (r2 > r12) goto L_0x007c
            if (r2 >= r12) goto L_0x0047
            java.util.Map<androidx.fragment.app.Fragment, java.util.HashSet<t0.b>> r2 = r10.f2654m
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x0047
            r10.n(r11)
        L_0x0047:
            int r2 = r11.mState
            if (r2 == r6) goto L_0x0057
            if (r2 == 0) goto L_0x005c
            if (r2 == r1) goto L_0x0061
            if (r2 == r3) goto L_0x006b
            if (r2 == r8) goto L_0x0070
            if (r2 == r7) goto L_0x0075
            goto L_0x0164
        L_0x0057:
            if (r12 <= r6) goto L_0x005c
            r0.c()
        L_0x005c:
            if (r12 <= 0) goto L_0x0061
            r0.e()
        L_0x0061:
            if (r12 <= r6) goto L_0x0066
            r0.j()
        L_0x0066:
            if (r12 <= r1) goto L_0x006b
            r0.f()
        L_0x006b:
            if (r12 <= r3) goto L_0x0070
            r0.a()
        L_0x0070:
            if (r12 <= r8) goto L_0x0075
            r0.v()
        L_0x0075:
            if (r12 <= r7) goto L_0x0164
            r0.p()
            goto L_0x0164
        L_0x007c:
            if (r2 <= r12) goto L_0x0164
            if (r2 == 0) goto L_0x015d
            if (r2 == r1) goto L_0x014f
            if (r2 == r3) goto L_0x00c6
            if (r2 == r8) goto L_0x0097
            if (r2 == r7) goto L_0x0092
            r9 = 7
            if (r2 == r9) goto L_0x008d
            goto L_0x0164
        L_0x008d:
            if (r12 >= r9) goto L_0x0092
            r0.n()
        L_0x0092:
            if (r12 >= r7) goto L_0x0097
            r0.w()
        L_0x0097:
            if (r12 >= r8) goto L_0x00c6
            boolean r2 = H0(r4)
            if (r2 == 0) goto L_0x00b3
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r7 = "movefrom ACTIVITY_CREATED: "
            r2.append(r7)
            r2.append(r11)
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r5, r2)
        L_0x00b3:
            android.view.View r2 = r11.mView
            if (r2 == 0) goto L_0x00c6
            androidx.fragment.app.h<?> r2 = r10.f2659r
            boolean r2 = r2.l(r11)
            if (r2 == 0) goto L_0x00c6
            android.util.SparseArray<android.os.Parcelable> r2 = r11.mSavedViewState
            if (r2 != 0) goto L_0x00c6
            r0.t()
        L_0x00c6:
            if (r12 >= r3) goto L_0x014f
            r2 = 0
            android.view.View r7 = r11.mView
            if (r7 == 0) goto L_0x0144
            android.view.ViewGroup r8 = r11.mContainer
            if (r8 == 0) goto L_0x0144
            r8.endViewTransition(r7)
            android.view.View r7 = r11.mView
            r7.clearAnimation()
            boolean r7 = r11.isRemovingParent()
            if (r7 != 0) goto L_0x0144
            int r7 = r10.f2658q
            r8 = 0
            if (r7 <= r6) goto L_0x0105
            boolean r6 = r10.G
            if (r6 != 0) goto L_0x0105
            android.view.View r6 = r11.mView
            int r6 = r6.getVisibility()
            if (r6 != 0) goto L_0x0105
            float r6 = r11.mPostponedAlpha
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 < 0) goto L_0x0105
            androidx.fragment.app.h<?> r2 = r10.f2659r
            android.content.Context r2 = r2.f()
            r6 = 0
            boolean r7 = r11.getPopDirection()
            androidx.fragment.app.d$d r2 = androidx.fragment.app.d.c(r2, r11, r6, r7)
        L_0x0105:
            r11.mPostponedAlpha = r8
            android.view.ViewGroup r6 = r11.mContainer
            android.view.View r7 = r11.mView
            if (r2 == 0) goto L_0x0112
            androidx.fragment.app.t$g r8 = r10.f2655n
            androidx.fragment.app.d.a(r11, r2, r8)
        L_0x0112:
            r6.removeView(r7)
            boolean r2 = H0(r3)
            if (r2 == 0) goto L_0x013f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Removing view "
            r2.append(r3)
            r2.append(r7)
            java.lang.String r3 = " for fragment "
            r2.append(r3)
            r2.append(r11)
            java.lang.String r3 = " from container "
            r2.append(r3)
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            android.util.Log.v(r5, r2)
        L_0x013f:
            android.view.ViewGroup r2 = r11.mContainer
            if (r6 == r2) goto L_0x0144
            return
        L_0x0144:
            java.util.Map<androidx.fragment.app.Fragment, java.util.HashSet<t0.b>> r2 = r10.f2654m
            java.lang.Object r2 = r2.get(r11)
            if (r2 != 0) goto L_0x014f
            r0.h()
        L_0x014f:
            if (r12 >= r1) goto L_0x015d
            java.util.Map<androidx.fragment.app.Fragment, java.util.HashSet<t0.b>> r2 = r10.f2654m
            java.lang.Object r2 = r2.get(r11)
            if (r2 == 0) goto L_0x015a
            goto L_0x015e
        L_0x015a:
            r0.g()
        L_0x015d:
            r1 = r12
        L_0x015e:
            if (r1 >= 0) goto L_0x0163
            r0.i()
        L_0x0163:
            r12 = r1
        L_0x0164:
            int r0 = r11.mState
            if (r0 == r12) goto L_0x0196
            boolean r0 = H0(r4)
            if (r0 == 0) goto L_0x0194
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "moveToState: Fragment state for "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r1 = " not updated inline; expected state "
            r0.append(r1)
            r0.append(r12)
            java.lang.String r1 = " found "
            r0.append(r1)
            int r1 = r11.mState
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r5, r0)
        L_0x0194:
            r11.mState = r12
        L_0x0196:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.U0(androidx.fragment.app.Fragment, int):void");
    }

    /* access modifiers changed from: package-private */
    public void V() {
        T(2);
    }

    /* access modifiers changed from: package-private */
    public void V0() {
        if (this.f2659r != null) {
            this.E = false;
            this.F = false;
            this.M.j(false);
            for (Fragment next : this.f2644c.n()) {
                if (next != null) {
                    next.noteStateNotSaved();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void W0(FragmentContainerView fragmentContainerView) {
        View view;
        for (p next : this.f2644c.k()) {
            Fragment k10 = next.k();
            if (k10.mContainerId == fragmentContainerView.getId() && (view = k10.mView) != null && view.getParent() == null) {
                k10.mContainer = fragmentContainerView;
                next.b();
            }
        }
    }

    public void X(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.f2644c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList<Fragment> arrayList = this.f2646e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i10 = 0; i10 < size2; i10++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.println(this.f2646e.get(i10).toString());
            }
        }
        ArrayList<a> arrayList2 = this.f2645d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i11 = 0; i11 < size; i11++) {
                a aVar = this.f2645d.get(i11);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i11);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.z(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f2650i.get());
        synchronized (this.f2642a) {
            int size3 = this.f2642a.size();
            if (size3 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i12 = 0; i12 < size3; i12++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i12);
                    printWriter.print(": ");
                    printWriter.println(this.f2642a.get(i12));
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f2659r);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f2660s);
        if (this.f2661t != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f2661t);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f2658q);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.E);
        printWriter.print(" mStopped=");
        printWriter.print(this.F);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.G);
        if (this.D) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.D);
        }
    }

    /* access modifiers changed from: package-private */
    public void X0(p pVar) {
        Fragment k10 = pVar.k();
        if (!k10.mDeferStart) {
            return;
        }
        if (this.f2643b) {
            this.H = true;
            return;
        }
        k10.mDeferStart = false;
        if (P) {
            pVar.m();
        } else {
            T0(k10);
        }
    }

    public void Y0(int i10, int i11) {
        if (i10 >= 0) {
            Z(new o((String) null, i10, i11), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i10);
    }

    /* access modifiers changed from: package-private */
    public void Z(n nVar, boolean z10) {
        if (!z10) {
            if (this.f2659r != null) {
                p();
            } else if (this.G) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            } else {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
        }
        synchronized (this.f2642a) {
            if (this.f2659r != null) {
                this.f2642a.add(nVar);
                o1();
            } else if (!z10) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    public void Z0(String str, int i10) {
        Z(new o(str, -1, i10), false);
    }

    public boolean a1() {
        return b1((String) null, -1, 0);
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public boolean b0(boolean z10) {
        a0(z10);
        boolean z11 = false;
        while (m0(this.I, this.J)) {
            this.f2643b = true;
            try {
                h1(this.I, this.J);
                q();
                z11 = true;
            } catch (Throwable th) {
                q();
                throw th;
            }
        }
        x1();
        W();
        this.f2644c.b();
        return z11;
    }

    /* access modifiers changed from: package-private */
    public void c0(n nVar, boolean z10) {
        if (!z10 || (this.f2659r != null && !this.G)) {
            a0(z10);
            if (nVar.a(this.I, this.J)) {
                this.f2643b = true;
                try {
                    h1(this.I, this.J);
                } finally {
                    q();
                }
            }
            x1();
            W();
            this.f2644c.b();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean c1(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, String str, int i10, int i11) {
        int i12;
        ArrayList<a> arrayList3 = this.f2645d;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i10 < 0 && (i11 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f2645d.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            if (str != null || i10 >= 0) {
                int size2 = arrayList3.size() - 1;
                while (size2 >= 0) {
                    a aVar = this.f2645d.get(size2);
                    if ((str != null && str.equals(aVar.E())) || (i10 >= 0 && i10 == aVar.f2727t)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i11 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        a aVar2 = this.f2645d.get(size2);
                        if ((str == null || !str.equals(aVar2.E())) && (i10 < 0 || i10 != aVar2.f2727t)) {
                            break;
                        }
                    }
                }
                i12 = size2;
            } else {
                i12 = -1;
            }
            if (i12 == this.f2645d.size() - 1) {
                return false;
            }
            for (int size3 = this.f2645d.size() - 1; size3 > i12; size3--) {
                arrayList.add(this.f2645d.remove(size3));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void e(a aVar) {
        if (this.f2645d == null) {
            this.f2645d = new ArrayList<>();
        }
        this.f2645d.add(aVar);
    }

    public void e1(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mFragmentManager != this) {
            w1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, fragment.mWho);
    }

    /* access modifiers changed from: package-private */
    public void f(Fragment fragment, t0.b bVar) {
        if (this.f2654m.get(fragment) == null) {
            this.f2654m.put(fragment, new HashSet());
        }
        this.f2654m.get(fragment).add(bVar);
    }

    public boolean f0() {
        boolean b02 = b0(true);
        l0();
        return b02;
    }

    /* access modifiers changed from: package-private */
    public void f1(Fragment fragment, t0.b bVar) {
        HashSet hashSet = this.f2654m.get(fragment);
        if (hashSet != null && hashSet.remove(bVar) && hashSet.isEmpty()) {
            this.f2654m.remove(fragment);
            if (fragment.mState < 5) {
                x(fragment);
                T0(fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public p g(Fragment fragment) {
        if (H0(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        p w10 = w(fragment);
        fragment.mFragmentManager = this;
        this.f2644c.p(w10);
        if (!fragment.mDetached) {
            this.f2644c.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (I0(fragment)) {
                this.D = true;
            }
        }
        return w10;
    }

    /* access modifiers changed from: package-private */
    public void g1(Fragment fragment) {
        if (H0(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z10 = !fragment.isInBackStack();
        if (!fragment.mDetached || z10) {
            this.f2644c.s(fragment);
            if (I0(fragment)) {
                this.D = true;
            }
            fragment.mRemoving = true;
            t1(fragment);
        }
    }

    public void h(m mVar) {
        this.f2657p.add(mVar);
    }

    /* access modifiers changed from: package-private */
    public Fragment h0(String str) {
        return this.f2644c.f(str);
    }

    /* access modifiers changed from: package-private */
    public void i(Fragment fragment) {
        this.M.a(fragment);
    }

    public Fragment i0(int i10) {
        return this.f2644c.g(i10);
    }

    /* access modifiers changed from: package-private */
    public void i1(Fragment fragment) {
        this.M.i(fragment);
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return this.f2650i.getAndIncrement();
    }

    public Fragment j0(String str) {
        return this.f2644c.h(str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v17, resolved type: androidx.activity.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v18, resolved type: androidx.fragment.app.Fragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: androidx.fragment.app.Fragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v25, resolved type: androidx.fragment.app.Fragment} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    @android.annotation.SuppressLint({"SyntheticAccessor"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void k(androidx.fragment.app.h<?> r3, androidx.fragment.app.e r4, androidx.fragment.app.Fragment r5) {
        /*
            r2 = this;
            androidx.fragment.app.h<?> r0 = r2.f2659r
            if (r0 != 0) goto L_0x0103
            r2.f2659r = r3
            r2.f2660s = r4
            r2.f2661t = r5
            if (r5 == 0) goto L_0x0015
            androidx.fragment.app.FragmentManager$i r4 = new androidx.fragment.app.FragmentManager$i
            r4.<init>(r2, r5)
        L_0x0011:
            r2.h(r4)
            goto L_0x001d
        L_0x0015:
            boolean r4 = r3 instanceof androidx.fragment.app.m
            if (r4 == 0) goto L_0x001d
            r4 = r3
            androidx.fragment.app.m r4 = (androidx.fragment.app.m) r4
            goto L_0x0011
        L_0x001d:
            androidx.fragment.app.Fragment r4 = r2.f2661t
            if (r4 == 0) goto L_0x0024
            r2.x1()
        L_0x0024:
            boolean r4 = r3 instanceof androidx.activity.c
            if (r4 == 0) goto L_0x0039
            r4 = r3
            androidx.activity.c r4 = (androidx.activity.c) r4
            androidx.activity.OnBackPressedDispatcher r0 = r4.getOnBackPressedDispatcher()
            r2.f2648g = r0
            if (r5 == 0) goto L_0x0034
            r4 = r5
        L_0x0034:
            androidx.activity.b r1 = r2.f2649h
            r0.a(r4, r1)
        L_0x0039:
            if (r5 == 0) goto L_0x0044
            androidx.fragment.app.FragmentManager r3 = r5.mFragmentManager
            androidx.fragment.app.l r3 = r3.o0(r5)
        L_0x0041:
            r2.M = r3
            goto L_0x005a
        L_0x0044:
            boolean r4 = r3 instanceof androidx.lifecycle.g0
            if (r4 == 0) goto L_0x0053
            androidx.lifecycle.g0 r3 = (androidx.lifecycle.g0) r3
            androidx.lifecycle.f0 r3 = r3.getViewModelStore()
            androidx.fragment.app.l r3 = androidx.fragment.app.l.e(r3)
            goto L_0x0041
        L_0x0053:
            androidx.fragment.app.l r3 = new androidx.fragment.app.l
            r4 = 0
            r3.<init>(r4)
            goto L_0x0041
        L_0x005a:
            androidx.fragment.app.l r3 = r2.M
            boolean r4 = r2.M0()
            r3.j(r4)
            androidx.fragment.app.r r3 = r2.f2644c
            androidx.fragment.app.l r4 = r2.M
            r3.x(r4)
            androidx.fragment.app.h<?> r3 = r2.f2659r
            boolean r4 = r3 instanceof androidx.activity.result.c
            if (r4 == 0) goto L_0x0102
            androidx.activity.result.c r3 = (androidx.activity.result.c) r3
            androidx.activity.result.ActivityResultRegistry r3 = r3.getActivityResultRegistry()
            if (r5 == 0) goto L_0x008c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r5.mWho
            r4.append(r5)
            java.lang.String r5 = ":"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            goto L_0x008e
        L_0x008c:
            java.lang.String r4 = ""
        L_0x008e:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = "FragmentManager:"
            r5.append(r0)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            java.lang.String r0 = "StartActivityForResult"
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            i.c r0 = new i.c
            r0.<init>()
            androidx.fragment.app.FragmentManager$j r1 = new androidx.fragment.app.FragmentManager$j
            r1.<init>()
            androidx.activity.result.b r5 = r3.j(r5, r0, r1)
            r2.f2667z = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            java.lang.String r0 = "StartIntentSenderForResult"
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            androidx.fragment.app.FragmentManager$k r0 = new androidx.fragment.app.FragmentManager$k
            r0.<init>()
            androidx.fragment.app.FragmentManager$a r1 = new androidx.fragment.app.FragmentManager$a
            r1.<init>()
            androidx.activity.result.b r5 = r3.j(r5, r0, r1)
            r2.A = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            java.lang.String r4 = "RequestPermissions"
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            i.b r5 = new i.b
            r5.<init>()
            androidx.fragment.app.FragmentManager$b r0 = new androidx.fragment.app.FragmentManager$b
            r0.<init>()
            androidx.activity.result.b r3 = r3.j(r4, r5, r0)
            r2.B = r3
        L_0x0102:
            return
        L_0x0103:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "Already attached"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.k(androidx.fragment.app.h, androidx.fragment.app.e, androidx.fragment.app.Fragment):void");
    }

    /* access modifiers changed from: package-private */
    public Fragment k0(String str) {
        return this.f2644c.i(str);
    }

    /* access modifiers changed from: package-private */
    public void k1(Parcelable parcelable) {
        p pVar;
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.f2692a != null) {
                this.f2644c.t();
                Iterator<FragmentState> it = fragmentManagerState.f2692a.iterator();
                while (it.hasNext()) {
                    FragmentState next = it.next();
                    if (next != null) {
                        Fragment c10 = this.M.c(next.f2701b);
                        if (c10 != null) {
                            if (H0(2)) {
                                Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + c10);
                            }
                            pVar = new p(this.f2656o, this.f2644c, c10, next);
                        } else {
                            pVar = new p(this.f2656o, this.f2644c, this.f2659r.f().getClassLoader(), s0(), next);
                        }
                        Fragment k10 = pVar.k();
                        k10.mFragmentManager = this;
                        if (H0(2)) {
                            Log.v("FragmentManager", "restoreSaveState: active (" + k10.mWho + "): " + k10);
                        }
                        pVar.o(this.f2659r.f().getClassLoader());
                        this.f2644c.p(pVar);
                        pVar.u(this.f2658q);
                    }
                }
                for (Fragment next2 : this.M.f()) {
                    if (!this.f2644c.c(next2.mWho)) {
                        if (H0(2)) {
                            Log.v("FragmentManager", "Discarding retained Fragment " + next2 + " that was not found in the set of active Fragments " + fragmentManagerState.f2692a);
                        }
                        this.M.i(next2);
                        next2.mFragmentManager = this;
                        p pVar2 = new p(this.f2656o, this.f2644c, next2);
                        pVar2.u(1);
                        pVar2.m();
                        next2.mRemoving = true;
                        pVar2.m();
                    }
                }
                this.f2644c.u(fragmentManagerState.f2693b);
                if (fragmentManagerState.f2694c != null) {
                    this.f2645d = new ArrayList<>(fragmentManagerState.f2694c.length);
                    int i10 = 0;
                    while (true) {
                        BackStackState[] backStackStateArr = fragmentManagerState.f2694c;
                        if (i10 >= backStackStateArr.length) {
                            break;
                        }
                        a a10 = backStackStateArr[i10].a(this);
                        if (H0(2)) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i10 + " (index " + a10.f2727t + "): " + a10);
                            PrintWriter printWriter = new PrintWriter(new x("FragmentManager"));
                            a10.A("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.f2645d.add(a10);
                        i10++;
                    }
                } else {
                    this.f2645d = null;
                }
                this.f2650i.set(fragmentManagerState.f2695d);
                String str = fragmentManagerState.f2696e;
                if (str != null) {
                    Fragment h02 = h0(str);
                    this.f2662u = h02;
                    M(h02);
                }
                ArrayList<String> arrayList = fragmentManagerState.f2697f;
                if (arrayList != null) {
                    for (int i11 = 0; i11 < arrayList.size(); i11++) {
                        Bundle bundle = fragmentManagerState.f2698g.get(i11);
                        bundle.setClassLoader(this.f2659r.f().getClassLoader());
                        this.f2651j.put(arrayList.get(i11), bundle);
                    }
                }
                this.C = new ArrayDeque<>(fragmentManagerState.f2699h);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void l(Fragment fragment) {
        if (H0(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                this.f2644c.a(fragment);
                if (H0(2)) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                if (I0(fragment)) {
                    this.D = true;
                }
            }
        }
    }

    public s m() {
        return new a(this);
    }

    /* access modifiers changed from: package-private */
    public Parcelable m1() {
        int size;
        l0();
        Y();
        b0(true);
        this.E = true;
        this.M.j(true);
        ArrayList<FragmentState> v10 = this.f2644c.v();
        BackStackState[] backStackStateArr = null;
        if (v10.isEmpty()) {
            if (H0(2)) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        ArrayList<String> w10 = this.f2644c.w();
        ArrayList<a> arrayList = this.f2645d;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            backStackStateArr = new BackStackState[size];
            for (int i10 = 0; i10 < size; i10++) {
                backStackStateArr[i10] = new BackStackState(this.f2645d.get(i10));
                if (H0(2)) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i10 + ": " + this.f2645d.get(i10));
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.f2692a = v10;
        fragmentManagerState.f2693b = w10;
        fragmentManagerState.f2694c = backStackStateArr;
        fragmentManagerState.f2695d = this.f2650i.get();
        Fragment fragment = this.f2662u;
        if (fragment != null) {
            fragmentManagerState.f2696e = fragment.mWho;
        }
        fragmentManagerState.f2697f.addAll(this.f2651j.keySet());
        fragmentManagerState.f2698g.addAll(this.f2651j.values());
        fragmentManagerState.f2699h = new ArrayList<>(this.C);
        return fragmentManagerState;
    }

    public int n0() {
        ArrayList<a> arrayList = this.f2645d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public Fragment.SavedState n1(Fragment fragment) {
        p m10 = this.f2644c.m(fragment.mWho);
        if (m10 == null || !m10.k().equals(fragment)) {
            w1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        return m10.r();
    }

    /* access modifiers changed from: package-private */
    public boolean o() {
        boolean z10 = false;
        for (Fragment next : this.f2644c.l()) {
            if (next != null) {
                z10 = I0(next);
                continue;
            }
            if (z10) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void o1() {
        synchronized (this.f2642a) {
            ArrayList<p> arrayList = this.L;
            boolean z10 = false;
            boolean z11 = arrayList != null && !arrayList.isEmpty();
            if (this.f2642a.size() == 1) {
                z10 = true;
            }
            if (z11 || z10) {
                this.f2659r.g().removeCallbacks(this.N);
                this.f2659r.g().post(this.N);
                x1();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public e p0() {
        return this.f2660s;
    }

    /* access modifiers changed from: package-private */
    public void p1(Fragment fragment, boolean z10) {
        ViewGroup r02 = r0(fragment);
        if (r02 != null && (r02 instanceof FragmentContainerView)) {
            ((FragmentContainerView) r02).setDrawDisappearingViewsLast(!z10);
        }
    }

    public Fragment q0(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment h02 = h0(string);
        if (h02 == null) {
            w1(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return h02;
    }

    public void q1(g gVar) {
        this.f2663v = gVar;
    }

    public final void r(String str) {
        this.f2651j.remove(str);
    }

    /* access modifiers changed from: package-private */
    public void r1(Fragment fragment, h.c cVar) {
        if (!fragment.equals(h0(fragment.mWho)) || !(fragment.mHost == null || fragment.mFragmentManager == this)) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        fragment.mMaxState = cVar;
    }

    public g s0() {
        g gVar = this.f2663v;
        if (gVar != null) {
            return gVar;
        }
        Fragment fragment = this.f2661t;
        return fragment != null ? fragment.mFragmentManager.s0() : this.f2664w;
    }

    /* access modifiers changed from: package-private */
    public void s1(Fragment fragment) {
        if (fragment == null || (fragment.equals(h0(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this))) {
            Fragment fragment2 = this.f2662u;
            this.f2662u = fragment;
            M(fragment2);
            M(this.f2662u);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    /* access modifiers changed from: package-private */
    public r t0() {
        return this.f2644c;
    }

    public String toString() {
        Object obj;
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("FragmentManager{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" in ");
        Fragment fragment = this.f2661t;
        if (fragment != null) {
            sb2.append(fragment.getClass().getSimpleName());
            sb2.append("{");
            obj = this.f2661t;
        } else {
            h<?> hVar = this.f2659r;
            if (hVar != null) {
                sb2.append(hVar.getClass().getSimpleName());
                sb2.append("{");
                obj = this.f2659r;
            } else {
                sb2.append("null");
                sb2.append("}}");
                return sb2.toString();
            }
        }
        sb2.append(Integer.toHexString(System.identityHashCode(obj)));
        sb2.append("}");
        sb2.append("}}");
        return sb2.toString();
    }

    /* access modifiers changed from: package-private */
    public void u(a aVar, boolean z10, boolean z11, boolean z12) {
        if (z10) {
            aVar.C(z12);
        } else {
            aVar.B();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z10));
        if (z11 && this.f2658q >= 1) {
            t.B(this.f2659r.f(), this.f2660s, arrayList, arrayList2, 0, 1, true, this.f2655n);
        }
        if (z12) {
            S0(this.f2658q, true);
        }
        for (Fragment next : this.f2644c.l()) {
            if (next != null && next.mView != null && next.mIsNewlyAdded && aVar.F(next.mContainerId)) {
                float f10 = next.mPostponedAlpha;
                if (f10 > 0.0f) {
                    next.mView.setAlpha(f10);
                }
                if (z12) {
                    next.mPostponedAlpha = 0.0f;
                } else {
                    next.mPostponedAlpha = -1.0f;
                    next.mIsNewlyAdded = false;
                }
            }
        }
    }

    public List<Fragment> u0() {
        return this.f2644c.n();
    }

    /* access modifiers changed from: package-private */
    public void u1(Fragment fragment) {
        if (H0(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    /* access modifiers changed from: package-private */
    public h<?> v0() {
        return this.f2659r;
    }

    /* access modifiers changed from: package-private */
    public p w(Fragment fragment) {
        p m10 = this.f2644c.m(fragment.mWho);
        if (m10 != null) {
            return m10;
        }
        p pVar = new p(this.f2656o, this.f2644c, fragment);
        pVar.o(this.f2659r.f().getClassLoader());
        pVar.u(this.f2658q);
        return pVar;
    }

    /* access modifiers changed from: package-private */
    public LayoutInflater.Factory2 w0() {
        return this.f2647f;
    }

    /* access modifiers changed from: package-private */
    public j x0() {
        return this.f2656o;
    }

    /* access modifiers changed from: package-private */
    public void y(Fragment fragment) {
        if (H0(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (H0(2)) {
                    Log.v("FragmentManager", "remove from detach: " + fragment);
                }
                this.f2644c.s(fragment);
                if (I0(fragment)) {
                    this.D = true;
                }
                t1(fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Fragment y0() {
        return this.f2661t;
    }

    /* access modifiers changed from: package-private */
    public void z() {
        this.E = false;
        this.F = false;
        this.M.j(false);
        T(4);
    }

    public Fragment z0() {
        return this.f2662u;
    }
}
