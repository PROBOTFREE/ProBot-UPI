package androidx.coordinatorlayout.widget;

import c0.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import w0.e;
import w0.f;

public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final e<ArrayList<T>> f2164a = new f(10);

    /* renamed from: b  reason: collision with root package name */
    private final g<T, ArrayList<T>> f2165b = new g<>();

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<T> f2166c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private final HashSet<T> f2167d = new HashSet<>();

    private void e(T t10, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t10)) {
            if (!hashSet.contains(t10)) {
                hashSet.add(t10);
                ArrayList arrayList2 = this.f2165b.get(t10);
                if (arrayList2 != null) {
                    int size = arrayList2.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        e(arrayList2.get(i10), arrayList, hashSet);
                    }
                }
                hashSet.remove(t10);
                arrayList.add(t10);
                return;
            }
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
    }

    private ArrayList<T> f() {
        ArrayList<T> b10 = this.f2164a.b();
        return b10 == null ? new ArrayList<>() : b10;
    }

    private void k(ArrayList<T> arrayList) {
        arrayList.clear();
        this.f2164a.a(arrayList);
    }

    public void a(T t10, T t11) {
        if (!this.f2165b.containsKey(t10) || !this.f2165b.containsKey(t11)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList arrayList = this.f2165b.get(t10);
        if (arrayList == null) {
            arrayList = f();
            this.f2165b.put(t10, arrayList);
        }
        arrayList.add(t11);
    }

    public void b(T t10) {
        if (!this.f2165b.containsKey(t10)) {
            this.f2165b.put(t10, null);
        }
    }

    public void c() {
        int size = this.f2165b.size();
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList o10 = this.f2165b.o(i10);
            if (o10 != null) {
                k(o10);
            }
        }
        this.f2165b.clear();
    }

    public boolean d(T t10) {
        return this.f2165b.containsKey(t10);
    }

    public List g(T t10) {
        return this.f2165b.get(t10);
    }

    public List<T> h(T t10) {
        int size = this.f2165b.size();
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList o10 = this.f2165b.o(i10);
            if (o10 != null && o10.contains(t10)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f2165b.k(i10));
            }
        }
        return arrayList;
    }

    public ArrayList<T> i() {
        this.f2166c.clear();
        this.f2167d.clear();
        int size = this.f2165b.size();
        for (int i10 = 0; i10 < size; i10++) {
            e(this.f2165b.k(i10), this.f2166c, this.f2167d);
        }
        return this.f2166c;
    }

    public boolean j(T t10) {
        int size = this.f2165b.size();
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList o10 = this.f2165b.o(i10);
            if (o10 != null && o10.contains(t10)) {
                return true;
            }
        }
        return false;
    }
}
