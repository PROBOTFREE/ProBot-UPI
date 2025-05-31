package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.s;
import androidx.lifecycle.h;
import java.io.PrintWriter;
import java.util.ArrayList;

final class a extends s implements FragmentManager.n {

    /* renamed from: r  reason: collision with root package name */
    final FragmentManager f2725r;

    /* renamed from: s  reason: collision with root package name */
    boolean f2726s;

    /* renamed from: t  reason: collision with root package name */
    int f2727t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    a(FragmentManager fragmentManager) {
        super(fragmentManager.s0(), fragmentManager.v0() != null ? fragmentManager.v0().f().getClassLoader() : null);
        this.f2727t = -1;
        this.f2725r = fragmentManager;
    }

    private static boolean H(s.a aVar) {
        Fragment fragment = aVar.f2839b;
        return fragment != null && fragment.mAdded && fragment.mView != null && !fragment.mDetached && !fragment.mHidden && fragment.isPostponed();
    }

    public void A(String str, PrintWriter printWriter, boolean z10) {
        String str2;
        if (z10) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f2829i);
            printWriter.print(" mIndex=");
            printWriter.print(this.f2727t);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f2726s);
            if (this.f2826f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f2826f));
            }
            if (!(this.f2822b == 0 && this.f2823c == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f2822b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f2823c));
            }
            if (!(this.f2824d == 0 && this.f2825e == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f2824d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f2825e));
            }
            if (!(this.f2830j == 0 && this.f2831k == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f2830j));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f2831k);
            }
            if (!(this.f2832l == 0 && this.f2833m == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f2832l));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f2833m);
            }
        }
        if (!this.f2821a.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = this.f2821a.size();
            for (int i10 = 0; i10 < size; i10++) {
                s.a aVar = this.f2821a.get(i10);
                switch (aVar.f2838a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    case 10:
                        str2 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    default:
                        str2 = "cmd=" + aVar.f2838a;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(aVar.f2839b);
                if (z10) {
                    if (!(aVar.f2840c == 0 && aVar.f2841d == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f2840c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f2841d));
                    }
                    if (aVar.f2842e != 0 || aVar.f2843f != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f2842e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f2843f));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void B() {
        int size = this.f2821a.size();
        for (int i10 = 0; i10 < size; i10++) {
            s.a aVar = this.f2821a.get(i10);
            Fragment fragment = aVar.f2839b;
            if (fragment != null) {
                fragment.setPopDirection(false);
                fragment.setNextTransition(this.f2826f);
                fragment.setSharedElementNames(this.f2834n, this.f2835o);
            }
            switch (aVar.f2838a) {
                case 1:
                    fragment.setAnimations(aVar.f2840c, aVar.f2841d, aVar.f2842e, aVar.f2843f);
                    this.f2725r.p1(fragment, false);
                    this.f2725r.g(fragment);
                    break;
                case 3:
                    fragment.setAnimations(aVar.f2840c, aVar.f2841d, aVar.f2842e, aVar.f2843f);
                    this.f2725r.g1(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.f2840c, aVar.f2841d, aVar.f2842e, aVar.f2843f);
                    this.f2725r.E0(fragment);
                    break;
                case 5:
                    fragment.setAnimations(aVar.f2840c, aVar.f2841d, aVar.f2842e, aVar.f2843f);
                    this.f2725r.p1(fragment, false);
                    this.f2725r.u1(fragment);
                    break;
                case 6:
                    fragment.setAnimations(aVar.f2840c, aVar.f2841d, aVar.f2842e, aVar.f2843f);
                    this.f2725r.y(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.f2840c, aVar.f2841d, aVar.f2842e, aVar.f2843f);
                    this.f2725r.p1(fragment, false);
                    this.f2725r.l(fragment);
                    break;
                case 8:
                    this.f2725r.s1(fragment);
                    break;
                case 9:
                    this.f2725r.s1((Fragment) null);
                    break;
                case 10:
                    this.f2725r.r1(fragment, aVar.f2845h);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f2838a);
            }
            if (!this.f2836p && aVar.f2838a != 1 && fragment != null && !FragmentManager.P) {
                this.f2725r.R0(fragment);
            }
        }
        if (!this.f2836p && !FragmentManager.P) {
            FragmentManager fragmentManager = this.f2725r;
            fragmentManager.S0(fragmentManager.f2658q, true);
        }
    }

    /* access modifiers changed from: package-private */
    public void C(boolean z10) {
        for (int size = this.f2821a.size() - 1; size >= 0; size--) {
            s.a aVar = this.f2821a.get(size);
            Fragment fragment = aVar.f2839b;
            if (fragment != null) {
                fragment.setPopDirection(true);
                fragment.setNextTransition(FragmentManager.l1(this.f2826f));
                fragment.setSharedElementNames(this.f2835o, this.f2834n);
            }
            switch (aVar.f2838a) {
                case 1:
                    fragment.setAnimations(aVar.f2840c, aVar.f2841d, aVar.f2842e, aVar.f2843f);
                    this.f2725r.p1(fragment, true);
                    this.f2725r.g1(fragment);
                    break;
                case 3:
                    fragment.setAnimations(aVar.f2840c, aVar.f2841d, aVar.f2842e, aVar.f2843f);
                    this.f2725r.g(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.f2840c, aVar.f2841d, aVar.f2842e, aVar.f2843f);
                    this.f2725r.u1(fragment);
                    break;
                case 5:
                    fragment.setAnimations(aVar.f2840c, aVar.f2841d, aVar.f2842e, aVar.f2843f);
                    this.f2725r.p1(fragment, true);
                    this.f2725r.E0(fragment);
                    break;
                case 6:
                    fragment.setAnimations(aVar.f2840c, aVar.f2841d, aVar.f2842e, aVar.f2843f);
                    this.f2725r.l(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.f2840c, aVar.f2841d, aVar.f2842e, aVar.f2843f);
                    this.f2725r.p1(fragment, true);
                    this.f2725r.y(fragment);
                    break;
                case 8:
                    this.f2725r.s1((Fragment) null);
                    break;
                case 9:
                    this.f2725r.s1(fragment);
                    break;
                case 10:
                    this.f2725r.r1(fragment, aVar.f2844g);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f2838a);
            }
            if (!this.f2836p && aVar.f2838a != 3 && fragment != null && !FragmentManager.P) {
                this.f2725r.R0(fragment);
            }
        }
        if (!this.f2836p && z10 && !FragmentManager.P) {
            FragmentManager fragmentManager = this.f2725r;
            fragmentManager.S0(fragmentManager.f2658q, true);
        }
    }

    /* access modifiers changed from: package-private */
    public Fragment D(ArrayList<Fragment> arrayList, Fragment fragment) {
        ArrayList<Fragment> arrayList2 = arrayList;
        Fragment fragment2 = fragment;
        int i10 = 0;
        while (i10 < this.f2821a.size()) {
            s.a aVar = this.f2821a.get(i10);
            int i11 = aVar.f2838a;
            if (i11 != 1) {
                if (i11 == 2) {
                    Fragment fragment3 = aVar.f2839b;
                    int i12 = fragment3.mContainerId;
                    boolean z10 = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment4 = arrayList2.get(size);
                        if (fragment4.mContainerId == i12) {
                            if (fragment4 == fragment3) {
                                z10 = true;
                            } else {
                                if (fragment4 == fragment2) {
                                    this.f2821a.add(i10, new s.a(9, fragment4));
                                    i10++;
                                    fragment2 = null;
                                }
                                s.a aVar2 = new s.a(3, fragment4);
                                aVar2.f2840c = aVar.f2840c;
                                aVar2.f2842e = aVar.f2842e;
                                aVar2.f2841d = aVar.f2841d;
                                aVar2.f2843f = aVar.f2843f;
                                this.f2821a.add(i10, aVar2);
                                arrayList2.remove(fragment4);
                                i10++;
                            }
                        }
                    }
                    if (z10) {
                        this.f2821a.remove(i10);
                        i10--;
                    } else {
                        aVar.f2838a = 1;
                        arrayList2.add(fragment3);
                    }
                } else if (i11 == 3 || i11 == 6) {
                    arrayList2.remove(aVar.f2839b);
                    Fragment fragment5 = aVar.f2839b;
                    if (fragment5 == fragment2) {
                        this.f2821a.add(i10, new s.a(9, fragment5));
                        i10++;
                        fragment2 = null;
                    }
                } else if (i11 != 7) {
                    if (i11 == 8) {
                        this.f2821a.add(i10, new s.a(9, fragment2));
                        i10++;
                        fragment2 = aVar.f2839b;
                    }
                }
                i10++;
            }
            arrayList2.add(aVar.f2839b);
            i10++;
        }
        return fragment2;
    }

    public String E() {
        return this.f2829i;
    }

    /* access modifiers changed from: package-private */
    public boolean F(int i10) {
        int size = this.f2821a.size();
        for (int i11 = 0; i11 < size; i11++) {
            Fragment fragment = this.f2821a.get(i11).f2839b;
            int i12 = fragment != null ? fragment.mContainerId : 0;
            if (i12 != 0 && i12 == i10) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean G(ArrayList<a> arrayList, int i10, int i11) {
        if (i11 == i10) {
            return false;
        }
        int size = this.f2821a.size();
        int i12 = -1;
        for (int i13 = 0; i13 < size; i13++) {
            Fragment fragment = this.f2821a.get(i13).f2839b;
            int i14 = fragment != null ? fragment.mContainerId : 0;
            if (!(i14 == 0 || i14 == i12)) {
                for (int i15 = i10; i15 < i11; i15++) {
                    a aVar = arrayList.get(i15);
                    int size2 = aVar.f2821a.size();
                    for (int i16 = 0; i16 < size2; i16++) {
                        Fragment fragment2 = aVar.f2821a.get(i16).f2839b;
                        if ((fragment2 != null ? fragment2.mContainerId : 0) == i14) {
                            return true;
                        }
                    }
                }
                i12 = i14;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean I() {
        for (int i10 = 0; i10 < this.f2821a.size(); i10++) {
            if (H(this.f2821a.get(i10))) {
                return true;
            }
        }
        return false;
    }

    public void J() {
        if (this.f2837q != null) {
            for (int i10 = 0; i10 < this.f2837q.size(); i10++) {
                this.f2837q.get(i10).run();
            }
            this.f2837q = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void K(Fragment.l lVar) {
        for (int i10 = 0; i10 < this.f2821a.size(); i10++) {
            s.a aVar = this.f2821a.get(i10);
            if (H(aVar)) {
                aVar.f2839b.setOnStartEnterTransitionListener(lVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Fragment L(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int size = this.f2821a.size() - 1; size >= 0; size--) {
            s.a aVar = this.f2821a.get(size);
            int i10 = aVar.f2838a;
            if (i10 != 1) {
                if (i10 != 3) {
                    switch (i10) {
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = aVar.f2839b;
                            break;
                        case 10:
                            aVar.f2845h = aVar.f2844g;
                            break;
                    }
                }
                arrayList.add(aVar.f2839b);
            }
            arrayList.remove(aVar.f2839b);
        }
        return fragment;
    }

    public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (FragmentManager.H0(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f2827g) {
            return true;
        }
        this.f2725r.e(this);
        return true;
    }

    public int j() {
        return y(false);
    }

    public int k() {
        return y(true);
    }

    public void l() {
        o();
        this.f2725r.c0(this, false);
    }

    public void m() {
        o();
        this.f2725r.c0(this, true);
    }

    public s n(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.f2725r) {
            return super.n(fragment);
        }
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    /* access modifiers changed from: package-private */
    public void p(int i10, Fragment fragment, String str, int i11) {
        super.p(i10, fragment, str, i11);
        fragment.mFragmentManager = this.f2725r;
    }

    public s q(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.f2725r) {
            return super.q(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("BackStackEntry{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f2727t >= 0) {
            sb2.append(" #");
            sb2.append(this.f2727t);
        }
        if (this.f2829i != null) {
            sb2.append(" ");
            sb2.append(this.f2829i);
        }
        sb2.append("}");
        return sb2.toString();
    }

    public s u(Fragment fragment, h.c cVar) {
        if (fragment.mFragmentManager != this.f2725r) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.f2725r);
        } else if (cVar == h.c.INITIALIZED && fragment.mState > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + cVar + " after the Fragment has been created");
        } else if (cVar != h.c.DESTROYED) {
            return super.u(fragment, cVar);
        } else {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + cVar + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
        }
    }

    public s v(Fragment fragment) {
        FragmentManager fragmentManager;
        if (fragment == null || (fragmentManager = fragment.mFragmentManager) == null || fragmentManager == this.f2725r) {
            return super.v(fragment);
        }
        throw new IllegalStateException("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    /* access modifiers changed from: package-private */
    public void x(int i10) {
        if (this.f2827g) {
            if (FragmentManager.H0(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i10);
            }
            int size = this.f2821a.size();
            for (int i11 = 0; i11 < size; i11++) {
                s.a aVar = this.f2821a.get(i11);
                Fragment fragment = aVar.f2839b;
                if (fragment != null) {
                    fragment.mBackStackNesting += i10;
                    if (FragmentManager.H0(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f2839b + " to " + aVar.f2839b.mBackStackNesting);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int y(boolean z10) {
        if (!this.f2726s) {
            if (FragmentManager.H0(2)) {
                Log.v("FragmentManager", "Commit: " + this);
                PrintWriter printWriter = new PrintWriter(new x("FragmentManager"));
                z("  ", printWriter);
                printWriter.close();
            }
            this.f2726s = true;
            this.f2727t = this.f2827g ? this.f2725r.j() : -1;
            this.f2725r.Z(this, z10);
            return this.f2727t;
        }
        throw new IllegalStateException("commit already called");
    }

    public void z(String str, PrintWriter printWriter) {
        A(str, printWriter, true);
    }
}
