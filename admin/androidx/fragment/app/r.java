package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class r {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<Fragment> f2818a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, p> f2819b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private l f2820c;

    r() {
    }

    /* access modifiers changed from: package-private */
    public void a(Fragment fragment) {
        if (!this.f2818a.contains(fragment)) {
            synchronized (this.f2818a) {
                this.f2818a.add(fragment);
            }
            fragment.mAdded = true;
            return;
        }
        throw new IllegalStateException("Fragment already added: " + fragment);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f2819b.values().removeAll(Collections.singleton((Object) null));
    }

    /* access modifiers changed from: package-private */
    public boolean c(String str) {
        return this.f2819b.get(str) != null;
    }

    /* access modifiers changed from: package-private */
    public void d(int i10) {
        for (p next : this.f2819b.values()) {
            if (next != null) {
                next.u(i10);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.f2819b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (p next : this.f2819b.values()) {
                printWriter.print(str);
                if (next != null) {
                    Fragment k10 = next.k();
                    printWriter.println(k10);
                    k10.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.f2818a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i10 = 0; i10 < size; i10++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.println(this.f2818a.get(i10).toString());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Fragment f(String str) {
        p pVar = this.f2819b.get(str);
        if (pVar != null) {
            return pVar.k();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Fragment g(int i10) {
        for (int size = this.f2818a.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f2818a.get(size);
            if (fragment != null && fragment.mFragmentId == i10) {
                return fragment;
            }
        }
        for (p next : this.f2819b.values()) {
            if (next != null) {
                Fragment k10 = next.k();
                if (k10.mFragmentId == i10) {
                    return k10;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Fragment h(String str) {
        if (str != null) {
            for (int size = this.f2818a.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f2818a.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (p next : this.f2819b.values()) {
            if (next != null) {
                Fragment k10 = next.k();
                if (str.equals(k10.mTag)) {
                    return k10;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Fragment i(String str) {
        Fragment findFragmentByWho;
        for (p next : this.f2819b.values()) {
            if (next != null && (findFragmentByWho = next.k().findFragmentByWho(str)) != null) {
                return findFragmentByWho;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public int j(Fragment fragment) {
        View view;
        View view2;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null) {
            return -1;
        }
        int indexOf = this.f2818a.indexOf(fragment);
        for (int i10 = indexOf - 1; i10 >= 0; i10--) {
            Fragment fragment2 = this.f2818a.get(i10);
            if (fragment2.mContainer == viewGroup && (view2 = fragment2.mView) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            indexOf++;
            if (indexOf >= this.f2818a.size()) {
                return -1;
            }
            Fragment fragment3 = this.f2818a.get(indexOf);
            if (fragment3.mContainer == viewGroup && (view = fragment3.mView) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public List<p> k() {
        ArrayList arrayList = new ArrayList();
        for (p next : this.f2819b.values()) {
            if (next != null) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public List<Fragment> l() {
        ArrayList arrayList = new ArrayList();
        Iterator<p> it = this.f2819b.values().iterator();
        while (it.hasNext()) {
            p next = it.next();
            arrayList.add(next != null ? next.k() : null);
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public p m(String str) {
        return this.f2819b.get(str);
    }

    /* access modifiers changed from: package-private */
    public List<Fragment> n() {
        ArrayList arrayList;
        if (this.f2818a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f2818a) {
            arrayList = new ArrayList(this.f2818a);
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public l o() {
        return this.f2820c;
    }

    /* access modifiers changed from: package-private */
    public void p(p pVar) {
        Fragment k10 = pVar.k();
        if (!c(k10.mWho)) {
            this.f2819b.put(k10.mWho, pVar);
            if (k10.mRetainInstanceChangedWhileDetached) {
                if (k10.mRetainInstance) {
                    this.f2820c.a(k10);
                } else {
                    this.f2820c.i(k10);
                }
                k10.mRetainInstanceChangedWhileDetached = false;
            }
            if (FragmentManager.H0(2)) {
                Log.v("FragmentManager", "Added fragment to active set " + k10);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void q(p pVar) {
        Fragment k10 = pVar.k();
        if (k10.mRetainInstance) {
            this.f2820c.i(k10);
        }
        if (this.f2819b.put(k10.mWho, (Object) null) != null && FragmentManager.H0(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + k10);
        }
    }

    /* access modifiers changed from: package-private */
    public void r() {
        Iterator<Fragment> it = this.f2818a.iterator();
        while (it.hasNext()) {
            p pVar = this.f2819b.get(it.next().mWho);
            if (pVar != null) {
                pVar.m();
            }
        }
        for (p next : this.f2819b.values()) {
            if (next != null) {
                next.m();
                Fragment k10 = next.k();
                if (k10.mRemoving && !k10.isInBackStack()) {
                    q(next);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void s(Fragment fragment) {
        synchronized (this.f2818a) {
            this.f2818a.remove(fragment);
        }
        fragment.mAdded = false;
    }

    /* access modifiers changed from: package-private */
    public void t() {
        this.f2819b.clear();
    }

    /* access modifiers changed from: package-private */
    public void u(List<String> list) {
        this.f2818a.clear();
        if (list != null) {
            for (String next : list) {
                Fragment f10 = f(next);
                if (f10 != null) {
                    if (FragmentManager.H0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: added (" + next + "): " + f10);
                    }
                    a(f10);
                } else {
                    throw new IllegalStateException("No instantiated fragment for (" + next + ")");
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ArrayList<FragmentState> v() {
        ArrayList<FragmentState> arrayList = new ArrayList<>(this.f2819b.size());
        for (p next : this.f2819b.values()) {
            if (next != null) {
                Fragment k10 = next.k();
                FragmentState s10 = next.s();
                arrayList.add(s10);
                if (FragmentManager.H0(2)) {
                    Log.v("FragmentManager", "Saved state of " + k10 + ": " + s10.f2712m);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public ArrayList<String> w() {
        synchronized (this.f2818a) {
            if (this.f2818a.isEmpty()) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>(this.f2818a.size());
            Iterator<Fragment> it = this.f2818a.iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                arrayList.add(next.mWho);
                if (FragmentManager.H0(2)) {
                    Log.v("FragmentManager", "saveAllState: adding fragment (" + next.mWho + "): " + next);
                }
            }
            return arrayList;
        }
    }

    /* access modifiers changed from: package-private */
    public void x(l lVar) {
        this.f2820c = lVar;
    }
}
