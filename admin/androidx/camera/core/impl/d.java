package androidx.camera.core.impl;

import android.util.ArrayMap;
import androidx.camera.core.impl.b;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public final class d extends e implements c {

    /* renamed from: e  reason: collision with root package name */
    private static final b.C0010b f1260e = b.C0010b.OPTIONAL;

    private d(TreeMap<b.a<?>, Map<b.C0010b, Object>> treeMap) {
        super(treeMap);
    }

    public static d l() {
        return new d(new TreeMap(e.f1261d));
    }

    public <ValueT> void f(b.a<ValueT> aVar, ValueT valuet) {
        m(aVar, f1260e, valuet);
    }

    public <ValueT> void m(b.a<ValueT> aVar, b.C0010b bVar, ValueT valuet) {
        Map map = this.f1262c.get(aVar);
        if (map == null) {
            ArrayMap arrayMap = new ArrayMap();
            this.f1262c.put(aVar, arrayMap);
            arrayMap.put(bVar, valuet);
            return;
        }
        b.C0010b bVar2 = (b.C0010b) Collections.min(map.keySet());
        if (map.get(bVar2).equals(valuet) || !b.d(bVar2, bVar)) {
            map.put(bVar, valuet);
            return;
        }
        throw new IllegalArgumentException("Option values conflicts: " + aVar.c() + ", existing value (" + bVar2 + ")=" + map.get(bVar2) + ", conflicting (" + bVar + ")=" + valuet);
    }
}
