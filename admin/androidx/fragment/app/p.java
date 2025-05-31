package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.x;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.y;
import androidx.lifecycle.g0;
import androidx.lifecycle.h;

class p {

    /* renamed from: a  reason: collision with root package name */
    private final j f2811a;

    /* renamed from: b  reason: collision with root package name */
    private final r f2812b;

    /* renamed from: c  reason: collision with root package name */
    private final Fragment f2813c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2814d = false;

    /* renamed from: e  reason: collision with root package name */
    private int f2815e = -1;

    class a implements View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f2816a;

        a(p pVar, View view) {
            this.f2816a = view;
        }

        public void onViewAttachedToWindow(View view) {
            this.f2816a.removeOnAttachStateChangeListener(this);
            x.o0(this.f2816a);
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2817a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.lifecycle.h$c[] r0 = androidx.lifecycle.h.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2817a = r0
                androidx.lifecycle.h$c r1 = androidx.lifecycle.h.c.RESUMED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f2817a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.lifecycle.h$c r1 = androidx.lifecycle.h.c.STARTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f2817a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.lifecycle.h$c r1 = androidx.lifecycle.h.c.CREATED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f2817a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.lifecycle.h$c r1 = androidx.lifecycle.h.c.INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.p.b.<clinit>():void");
        }
    }

    p(j jVar, r rVar, Fragment fragment) {
        this.f2811a = jVar;
        this.f2812b = rVar;
        this.f2813c = fragment;
    }

    p(j jVar, r rVar, Fragment fragment, FragmentState fragmentState) {
        this.f2811a = jVar;
        this.f2812b = rVar;
        this.f2813c = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        Bundle bundle = fragmentState.f2712m;
        fragment.mSavedFragmentState = bundle == null ? new Bundle() : bundle;
    }

    p(j jVar, r rVar, ClassLoader classLoader, g gVar, FragmentState fragmentState) {
        this.f2811a = jVar;
        this.f2812b = rVar;
        Fragment instantiate = gVar.instantiate(classLoader, fragmentState.f2700a);
        this.f2813c = instantiate;
        Bundle bundle = fragmentState.f2709j;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        instantiate.setArguments(fragmentState.f2709j);
        instantiate.mWho = fragmentState.f2701b;
        instantiate.mFromLayout = fragmentState.f2702c;
        instantiate.mRestored = true;
        instantiate.mFragmentId = fragmentState.f2703d;
        instantiate.mContainerId = fragmentState.f2704e;
        instantiate.mTag = fragmentState.f2705f;
        instantiate.mRetainInstance = fragmentState.f2706g;
        instantiate.mRemoving = fragmentState.f2707h;
        instantiate.mDetached = fragmentState.f2708i;
        instantiate.mHidden = fragmentState.f2710k;
        instantiate.mMaxState = h.c.values()[fragmentState.f2711l];
        Bundle bundle2 = fragmentState.f2712m;
        instantiate.mSavedFragmentState = bundle2 == null ? new Bundle() : bundle2;
        if (FragmentManager.H0(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + instantiate);
        }
    }

    private boolean l(View view) {
        if (view == this.f2813c.mView) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.f2813c.mView) {
                return true;
            }
        }
        return false;
    }

    private Bundle q() {
        Bundle bundle = new Bundle();
        this.f2813c.performSaveInstanceState(bundle);
        this.f2811a.j(this.f2813c, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.f2813c.mView != null) {
            t();
        }
        if (this.f2813c.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.f2813c.mSavedViewState);
        }
        if (this.f2813c.mSavedViewRegistryState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle("android:view_registry_state", this.f2813c.mSavedViewRegistryState);
        }
        if (!this.f2813c.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.f2813c.mUserVisibleHint);
        }
        return bundle;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.f2813c);
        }
        Fragment fragment = this.f2813c;
        fragment.performActivityCreated(fragment.mSavedFragmentState);
        j jVar = this.f2811a;
        Fragment fragment2 = this.f2813c;
        jVar.a(fragment2, fragment2.mSavedFragmentState, false);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        int j10 = this.f2812b.j(this.f2813c);
        Fragment fragment = this.f2813c;
        fragment.mContainer.addView(fragment.mView, j10);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "moveto ATTACHED: " + this.f2813c);
        }
        Fragment fragment = this.f2813c;
        Fragment fragment2 = fragment.mTarget;
        p pVar = null;
        if (fragment2 != null) {
            p m10 = this.f2812b.m(fragment2.mWho);
            if (m10 != null) {
                Fragment fragment3 = this.f2813c;
                fragment3.mTargetWho = fragment3.mTarget.mWho;
                fragment3.mTarget = null;
                pVar = m10;
            } else {
                throw new IllegalStateException("Fragment " + this.f2813c + " declared target fragment " + this.f2813c.mTarget + " that does not belong to this FragmentManager!");
            }
        } else {
            String str = fragment.mTargetWho;
            if (str != null && (pVar = this.f2812b.m(str)) == null) {
                throw new IllegalStateException("Fragment " + this.f2813c + " declared target fragment " + this.f2813c.mTargetWho + " that does not belong to this FragmentManager!");
            }
        }
        if (pVar != null && (FragmentManager.P || pVar.k().mState < 1)) {
            pVar.m();
        }
        Fragment fragment4 = this.f2813c;
        fragment4.mHost = fragment4.mFragmentManager.v0();
        Fragment fragment5 = this.f2813c;
        fragment5.mParentFragment = fragment5.mFragmentManager.y0();
        this.f2811a.g(this.f2813c, false);
        this.f2813c.performAttach();
        this.f2811a.b(this.f2813c, false);
    }

    /* access modifiers changed from: package-private */
    public int d() {
        Fragment fragment;
        ViewGroup viewGroup;
        Fragment fragment2 = this.f2813c;
        if (fragment2.mFragmentManager == null) {
            return fragment2.mState;
        }
        int i10 = this.f2815e;
        int i11 = b.f2817a[fragment2.mMaxState.ordinal()];
        if (i11 != 1) {
            i10 = i11 != 2 ? i11 != 3 ? i11 != 4 ? Math.min(i10, -1) : Math.min(i10, 0) : Math.min(i10, 1) : Math.min(i10, 5);
        }
        Fragment fragment3 = this.f2813c;
        if (fragment3.mFromLayout) {
            if (fragment3.mInLayout) {
                i10 = Math.max(this.f2815e, 2);
                View view = this.f2813c.mView;
                if (view != null && view.getParent() == null) {
                    i10 = Math.min(i10, 2);
                }
            } else {
                i10 = this.f2815e < 4 ? Math.min(i10, fragment3.mState) : Math.min(i10, 1);
            }
        }
        if (!this.f2813c.mAdded) {
            i10 = Math.min(i10, 1);
        }
        y.e.b bVar = null;
        if (FragmentManager.P && (viewGroup = fragment.mContainer) != null) {
            bVar = y.n(viewGroup, (fragment = this.f2813c).getParentFragmentManager()).l(this);
        }
        if (bVar == y.e.b.ADDING) {
            i10 = Math.min(i10, 6);
        } else if (bVar == y.e.b.REMOVING) {
            i10 = Math.max(i10, 3);
        } else {
            Fragment fragment4 = this.f2813c;
            if (fragment4.mRemoving) {
                i10 = fragment4.isInBackStack() ? Math.min(i10, 1) : Math.min(i10, -1);
            }
        }
        Fragment fragment5 = this.f2813c;
        if (fragment5.mDeferStart && fragment5.mState < 5) {
            i10 = Math.min(i10, 4);
        }
        if (FragmentManager.H0(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + i10 + " for " + this.f2813c);
        }
        return i10;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.f2813c);
        }
        Fragment fragment = this.f2813c;
        if (!fragment.mIsCreated) {
            this.f2811a.h(fragment, fragment.mSavedFragmentState, false);
            Fragment fragment2 = this.f2813c;
            fragment2.performCreate(fragment2.mSavedFragmentState);
            j jVar = this.f2811a;
            Fragment fragment3 = this.f2813c;
            jVar.c(fragment3, fragment3.mSavedFragmentState, false);
            return;
        }
        fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
        this.f2813c.mState = 1;
    }

    /* access modifiers changed from: package-private */
    public void f() {
        String str;
        if (!this.f2813c.mFromLayout) {
            if (FragmentManager.H0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f2813c);
            }
            Fragment fragment = this.f2813c;
            LayoutInflater performGetLayoutInflater = fragment.performGetLayoutInflater(fragment.mSavedFragmentState);
            ViewGroup viewGroup = null;
            Fragment fragment2 = this.f2813c;
            ViewGroup viewGroup2 = fragment2.mContainer;
            if (viewGroup2 != null) {
                viewGroup = viewGroup2;
            } else {
                int i10 = fragment2.mContainerId;
                if (i10 != 0) {
                    if (i10 != -1) {
                        viewGroup = (ViewGroup) fragment2.mFragmentManager.p0().c(this.f2813c.mContainerId);
                        if (viewGroup == null) {
                            Fragment fragment3 = this.f2813c;
                            if (!fragment3.mRestored) {
                                try {
                                    str = fragment3.getResources().getResourceName(this.f2813c.mContainerId);
                                } catch (Resources.NotFoundException unused) {
                                    str = "unknown";
                                }
                                throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f2813c.mContainerId) + " (" + str + ") for fragment " + this.f2813c);
                            }
                        }
                    } else {
                        throw new IllegalArgumentException("Cannot create fragment " + this.f2813c + " for a container view with no id");
                    }
                }
            }
            Fragment fragment4 = this.f2813c;
            fragment4.mContainer = viewGroup;
            fragment4.performCreateView(performGetLayoutInflater, viewGroup, fragment4.mSavedFragmentState);
            View view = this.f2813c.mView;
            if (view != null) {
                boolean z10 = false;
                view.setSaveFromParentEnabled(false);
                Fragment fragment5 = this.f2813c;
                fragment5.mView.setTag(g1.b.fragment_container_view_tag, fragment5);
                if (viewGroup != null) {
                    b();
                }
                Fragment fragment6 = this.f2813c;
                if (fragment6.mHidden) {
                    fragment6.mView.setVisibility(8);
                }
                if (x.U(this.f2813c.mView)) {
                    x.o0(this.f2813c.mView);
                } else {
                    View view2 = this.f2813c.mView;
                    view2.addOnAttachStateChangeListener(new a(this, view2));
                }
                this.f2813c.performViewCreated();
                j jVar = this.f2811a;
                Fragment fragment7 = this.f2813c;
                jVar.m(fragment7, fragment7.mView, fragment7.mSavedFragmentState, false);
                int visibility = this.f2813c.mView.getVisibility();
                float alpha = this.f2813c.mView.getAlpha();
                if (FragmentManager.P) {
                    this.f2813c.setPostOnViewCreatedAlpha(alpha);
                    Fragment fragment8 = this.f2813c;
                    if (fragment8.mContainer != null && visibility == 0) {
                        View findFocus = fragment8.mView.findFocus();
                        if (findFocus != null) {
                            this.f2813c.setFocusedView(findFocus);
                            if (FragmentManager.H0(2)) {
                                Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + this.f2813c);
                            }
                        }
                        this.f2813c.mView.setAlpha(0.0f);
                    }
                } else {
                    Fragment fragment9 = this.f2813c;
                    if (visibility == 0 && fragment9.mContainer != null) {
                        z10 = true;
                    }
                    fragment9.mIsNewlyAdded = z10;
                }
            }
            this.f2813c.mState = 2;
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        Fragment f10;
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.f2813c);
        }
        Fragment fragment = this.f2813c;
        boolean z10 = true;
        boolean z11 = fragment.mRemoving && !fragment.isInBackStack();
        if (z11 || this.f2812b.o().k(this.f2813c)) {
            h<?> hVar = this.f2813c.mHost;
            if (hVar instanceof g0) {
                z10 = this.f2812b.o().h();
            } else if (hVar.f() instanceof Activity) {
                z10 = true ^ ((Activity) hVar.f()).isChangingConfigurations();
            }
            if (z11 || z10) {
                this.f2812b.o().b(this.f2813c);
            }
            this.f2813c.performDestroy();
            this.f2811a.d(this.f2813c, false);
            for (p next : this.f2812b.k()) {
                if (next != null) {
                    Fragment k10 = next.k();
                    if (this.f2813c.mWho.equals(k10.mTargetWho)) {
                        k10.mTarget = this.f2813c;
                        k10.mTargetWho = null;
                    }
                }
            }
            Fragment fragment2 = this.f2813c;
            String str = fragment2.mTargetWho;
            if (str != null) {
                fragment2.mTarget = this.f2812b.f(str);
            }
            this.f2812b.q(this);
            return;
        }
        String str2 = this.f2813c.mTargetWho;
        if (!(str2 == null || (f10 = this.f2812b.f(str2)) == null || !f10.mRetainInstance)) {
            this.f2813c.mTarget = f10;
        }
        this.f2813c.mState = 0;
    }

    /* access modifiers changed from: package-private */
    public void h() {
        View view;
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.f2813c);
        }
        Fragment fragment = this.f2813c;
        ViewGroup viewGroup = fragment.mContainer;
        if (!(viewGroup == null || (view = fragment.mView) == null)) {
            viewGroup.removeView(view);
        }
        this.f2813c.performDestroyView();
        this.f2811a.n(this.f2813c, false);
        Fragment fragment2 = this.f2813c;
        fragment2.mContainer = null;
        fragment2.mView = null;
        fragment2.mViewLifecycleOwner = null;
        fragment2.mViewLifecycleOwnerLiveData.l(null);
        this.f2813c.mInLayout = false;
    }

    /* access modifiers changed from: package-private */
    public void i() {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.f2813c);
        }
        this.f2813c.performDetach();
        boolean z10 = false;
        this.f2811a.e(this.f2813c, false);
        Fragment fragment = this.f2813c;
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if (fragment.mRemoving && !fragment.isInBackStack()) {
            z10 = true;
        }
        if (z10 || this.f2812b.o().k(this.f2813c)) {
            if (FragmentManager.H0(3)) {
                Log.d("FragmentManager", "initState called for fragment: " + this.f2813c);
            }
            this.f2813c.initState();
        }
    }

    /* access modifiers changed from: package-private */
    public void j() {
        Fragment fragment = this.f2813c;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (FragmentManager.H0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f2813c);
            }
            Fragment fragment2 = this.f2813c;
            fragment2.performCreateView(fragment2.performGetLayoutInflater(fragment2.mSavedFragmentState), (ViewGroup) null, this.f2813c.mSavedFragmentState);
            View view = this.f2813c.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.f2813c;
                fragment3.mView.setTag(g1.b.fragment_container_view_tag, fragment3);
                Fragment fragment4 = this.f2813c;
                if (fragment4.mHidden) {
                    fragment4.mView.setVisibility(8);
                }
                this.f2813c.performViewCreated();
                j jVar = this.f2811a;
                Fragment fragment5 = this.f2813c;
                jVar.m(fragment5, fragment5.mView, fragment5.mSavedFragmentState, false);
                this.f2813c.mState = 2;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Fragment k() {
        return this.f2813c;
    }

    /* access modifiers changed from: package-private */
    public void m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (!this.f2814d) {
            boolean z10 = false;
            z10 = true;
            try {
                while (true) {
                    int d10 = d();
                    Fragment fragment = this.f2813c;
                    int i10 = fragment.mState;
                    if (d10 != i10) {
                        if (d10 <= i10) {
                            switch (i10 - 1) {
                                case -1:
                                    i();
                                    break;
                                case 0:
                                    g();
                                    break;
                                case 1:
                                    h();
                                    this.f2813c.mState = z10 ? 1 : 0;
                                    break;
                                case 2:
                                    fragment.mInLayout = z10;
                                    fragment.mState = 2;
                                    break;
                                case 3:
                                    if (FragmentManager.H0(3)) {
                                        Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.f2813c);
                                    }
                                    Fragment fragment2 = this.f2813c;
                                    if (fragment2.mView != null && fragment2.mSavedViewState == null) {
                                        t();
                                    }
                                    Fragment fragment3 = this.f2813c;
                                    if (!(fragment3.mView == null || (viewGroup2 = fragment3.mContainer) == null)) {
                                        y.n(viewGroup2, fragment3.getParentFragmentManager()).d(this);
                                    }
                                    this.f2813c.mState = 3;
                                    break;
                                case 4:
                                    w();
                                    break;
                                case 5:
                                    fragment.mState = 5;
                                    break;
                                case 6:
                                    n();
                                    break;
                            }
                        } else {
                            switch (i10 + 1) {
                                case 0:
                                    c();
                                    break;
                                case 1:
                                    e();
                                    break;
                                case 2:
                                    j();
                                    f();
                                    break;
                                case 3:
                                    a();
                                    break;
                                case 4:
                                    if (!(fragment.mView == null || (viewGroup3 = fragment.mContainer) == null)) {
                                        y.n(viewGroup3, fragment.getParentFragmentManager()).b(y.e.c.b(this.f2813c.mView.getVisibility()), this);
                                    }
                                    this.f2813c.mState = 4;
                                    break;
                                case 5:
                                    v();
                                    break;
                                case 6:
                                    fragment.mState = 6;
                                    break;
                                case 7:
                                    p();
                                    break;
                            }
                        }
                    } else {
                        if (FragmentManager.P && fragment.mHiddenChanged) {
                            if (!(fragment.mView == null || (viewGroup = fragment.mContainer) == null)) {
                                y n10 = y.n(viewGroup, fragment.getParentFragmentManager());
                                if (this.f2813c.mHidden) {
                                    n10.c(this);
                                } else {
                                    n10.e(this);
                                }
                            }
                            Fragment fragment4 = this.f2813c;
                            FragmentManager fragmentManager = fragment4.mFragmentManager;
                            if (fragmentManager != null) {
                                fragmentManager.F0(fragment4);
                            }
                            Fragment fragment5 = this.f2813c;
                            fragment5.mHiddenChanged = z10;
                            fragment5.onHiddenChanged(fragment5.mHidden);
                        }
                        this.f2814d = z10;
                        return;
                    }
                }
            } finally {
                this.f2814d = z10;
            }
        } else if (FragmentManager.H0(2)) {
            Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + k());
        }
    }

    /* access modifiers changed from: package-private */
    public void n() {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.f2813c);
        }
        this.f2813c.performPause();
        this.f2811a.f(this.f2813c, false);
    }

    /* access modifiers changed from: package-private */
    public void o(ClassLoader classLoader) {
        Bundle bundle = this.f2813c.mSavedFragmentState;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
            Fragment fragment = this.f2813c;
            fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
            Fragment fragment2 = this.f2813c;
            fragment2.mSavedViewRegistryState = fragment2.mSavedFragmentState.getBundle("android:view_registry_state");
            Fragment fragment3 = this.f2813c;
            fragment3.mTargetWho = fragment3.mSavedFragmentState.getString("android:target_state");
            Fragment fragment4 = this.f2813c;
            if (fragment4.mTargetWho != null) {
                fragment4.mTargetRequestCode = fragment4.mSavedFragmentState.getInt("android:target_req_state", 0);
            }
            Fragment fragment5 = this.f2813c;
            Boolean bool = fragment5.mSavedUserVisibleHint;
            if (bool != null) {
                fragment5.mUserVisibleHint = bool.booleanValue();
                this.f2813c.mSavedUserVisibleHint = null;
            } else {
                fragment5.mUserVisibleHint = fragment5.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
            }
            Fragment fragment6 = this.f2813c;
            if (!fragment6.mUserVisibleHint) {
                fragment6.mDeferStart = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void p() {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.f2813c);
        }
        View focusedView = this.f2813c.getFocusedView();
        if (focusedView != null && l(focusedView)) {
            boolean requestFocus = focusedView.requestFocus();
            if (FragmentManager.H0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("requestFocus: Restoring focused view ");
                sb2.append(focusedView);
                sb2.append(" ");
                sb2.append(requestFocus ? "succeeded" : "failed");
                sb2.append(" on Fragment ");
                sb2.append(this.f2813c);
                sb2.append(" resulting in focused view ");
                sb2.append(this.f2813c.mView.findFocus());
                Log.v("FragmentManager", sb2.toString());
            }
        }
        this.f2813c.setFocusedView((View) null);
        this.f2813c.performResume();
        this.f2811a.i(this.f2813c, false);
        Fragment fragment = this.f2813c;
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
    }

    /* access modifiers changed from: package-private */
    public Fragment.SavedState r() {
        Bundle q10;
        if (this.f2813c.mState <= -1 || (q10 = q()) == null) {
            return null;
        }
        return new Fragment.SavedState(q10);
    }

    /* access modifiers changed from: package-private */
    public FragmentState s() {
        FragmentState fragmentState = new FragmentState(this.f2813c);
        Fragment fragment = this.f2813c;
        if (fragment.mState <= -1 || fragmentState.f2712m != null) {
            fragmentState.f2712m = fragment.mSavedFragmentState;
        } else {
            Bundle q10 = q();
            fragmentState.f2712m = q10;
            if (this.f2813c.mTargetWho != null) {
                if (q10 == null) {
                    fragmentState.f2712m = new Bundle();
                }
                fragmentState.f2712m.putString("android:target_state", this.f2813c.mTargetWho);
                int i10 = this.f2813c.mTargetRequestCode;
                if (i10 != 0) {
                    fragmentState.f2712m.putInt("android:target_req_state", i10);
                }
            }
        }
        return fragmentState;
    }

    /* access modifiers changed from: package-private */
    public void t() {
        if (this.f2813c.mView != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f2813c.mView.saveHierarchyState(sparseArray);
            if (sparseArray.size() > 0) {
                this.f2813c.mSavedViewState = sparseArray;
            }
            Bundle bundle = new Bundle();
            this.f2813c.mViewLifecycleOwner.e(bundle);
            if (!bundle.isEmpty()) {
                this.f2813c.mSavedViewRegistryState = bundle;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void u(int i10) {
        this.f2815e = i10;
    }

    /* access modifiers changed from: package-private */
    public void v() {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.f2813c);
        }
        this.f2813c.performStart();
        this.f2811a.k(this.f2813c, false);
    }

    /* access modifiers changed from: package-private */
    public void w() {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.f2813c);
        }
        this.f2813c.performStop();
        this.f2811a.l(this.f2813c, false);
    }
}
