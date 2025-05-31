package androidx.camera.core.impl;

import android.util.ArrayMap;
import androidx.camera.core.impl.b;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import v.d;

public class e implements b {

    /* renamed from: d  reason: collision with root package name */
    protected static final Comparator<b.a<?>> f1261d;

    /* renamed from: c  reason: collision with root package name */
    protected final TreeMap<b.a<?>, Map<b.C0010b, Object>> f1262c;

    static {
        d dVar = d.f21048a;
        f1261d = dVar;
        new e(new TreeMap(dVar));
    }

    e(TreeMap<b.a<?>, Map<b.C0010b, Object>> treeMap) {
        this.f1262c = treeMap;
    }

    public static e i(b bVar) {
        if (e.class.equals(bVar.getClass())) {
            return (e) bVar;
        }
        TreeMap treeMap = new TreeMap(f1261d);
        for (b.a next : bVar.c()) {
            Set<b.C0010b> a10 = bVar.a(next);
            ArrayMap arrayMap = new ArrayMap();
            for (b.C0010b next2 : a10) {
                arrayMap.put(next2, bVar.b(next, next2));
            }
            treeMap.put(next, arrayMap);
        }
        return new e(treeMap);
    }

    public Set<b.C0010b> a(b.a<?> aVar) {
        Map map = this.f1262c.get(aVar);
        return map == null ? Collections.emptySet() : Collections.unmodifiableSet(map.keySet());
    }

    public <ValueT> ValueT b(b.a<ValueT> aVar, b.C0010b bVar) {
        Map map = this.f1262c.get(aVar);
        if (map == null) {
            throw new IllegalArgumentException("Option does not exist: " + aVar);
        } else if (map.containsKey(bVar)) {
            return map.get(bVar);
        } else {
            throw new IllegalArgumentException("Option does not exist: " + aVar + " with priority=" + bVar);
        }
    }

    public Set<b.a<?>> c() {
        return Collections.unmodifiableSet(this.f1262c.keySet());
    }

    public <ValueT> ValueT g(b.a<ValueT> aVar, ValueT valuet) {
        try {
            return k(aVar);
        } catch (IllegalArgumentException unused) {
            return valuet;
        }
    }

    public <ValueT> ValueT k(b.a<ValueT> aVar) {
        Map map = this.f1262c.get(aVar);
        if (map != null) {
            return map.get((b.C0010b) Collections.min(map.keySet()));
        }
        throw new IllegalArgumentException("Option does not exist: " + aVar);
    }
}
