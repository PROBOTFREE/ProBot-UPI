package androidx.work;

import a2.f;
import androidx.work.c;
import java.util.HashMap;
import java.util.List;

public final class OverwritingInputMerger extends f {
    public c b(List<c> list) {
        c.a aVar = new c.a();
        HashMap hashMap = new HashMap();
        for (c h10 : list) {
            hashMap.putAll(h10.h());
        }
        aVar.d(hashMap);
        return aVar.a();
    }
}
