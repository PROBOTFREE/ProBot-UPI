package androidx.constraintlayout.widget;

import android.util.SparseIntArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private HashMap<Integer, HashSet<WeakReference<a>>> f2105a = new HashMap<>();

    public interface a {
    }

    public g() {
        new SparseIntArray();
    }

    public void a(int i10, a aVar) {
        HashSet hashSet = this.f2105a.get(Integer.valueOf(i10));
        if (hashSet == null) {
            hashSet = new HashSet();
            this.f2105a.put(Integer.valueOf(i10), hashSet);
        }
        hashSet.add(new WeakReference(aVar));
    }

    public void b(int i10, a aVar) {
        HashSet hashSet = this.f2105a.get(Integer.valueOf(i10));
        if (hashSet != null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                a aVar2 = (a) weakReference.get();
                if (aVar2 == null || aVar2 == aVar) {
                    arrayList.add(weakReference);
                }
            }
            hashSet.removeAll(arrayList);
        }
    }
}
