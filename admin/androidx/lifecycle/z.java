package androidx.lifecycle;

import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.savedstate.SavedStateRegistry;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class z {

    /* renamed from: e  reason: collision with root package name */
    private static final Class[] f3061e;

    /* renamed from: a  reason: collision with root package name */
    final Map<String, Object> f3062a;

    /* renamed from: b  reason: collision with root package name */
    final Map<String, SavedStateRegistry.b> f3063b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Object> f3064c;

    /* renamed from: d  reason: collision with root package name */
    private final SavedStateRegistry.b f3065d;

    class a implements SavedStateRegistry.b {
        a() {
        }

        public Bundle a() {
            for (Map.Entry entry : new HashMap(z.this.f3063b).entrySet()) {
                z.this.c((String) entry.getKey(), ((SavedStateRegistry.b) entry.getValue()).a());
            }
            Set<String> keySet = z.this.f3062a.keySet();
            ArrayList arrayList = new ArrayList(keySet.size());
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            for (String next : keySet) {
                arrayList.add(next);
                arrayList2.add(z.this.f3062a.get(next));
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("keys", arrayList);
            bundle.putParcelableArrayList("values", arrayList2);
            return bundle;
        }
    }

    static {
        Class[] clsArr = new Class[29];
        clsArr[0] = Boolean.TYPE;
        clsArr[1] = boolean[].class;
        clsArr[2] = Double.TYPE;
        clsArr[3] = double[].class;
        Class<SizeF> cls = Integer.TYPE;
        clsArr[4] = cls;
        clsArr[5] = int[].class;
        clsArr[6] = Long.TYPE;
        clsArr[7] = long[].class;
        clsArr[8] = String.class;
        clsArr[9] = String[].class;
        clsArr[10] = Binder.class;
        clsArr[11] = Bundle.class;
        clsArr[12] = Byte.TYPE;
        clsArr[13] = byte[].class;
        clsArr[14] = Character.TYPE;
        clsArr[15] = char[].class;
        clsArr[16] = CharSequence.class;
        clsArr[17] = CharSequence[].class;
        clsArr[18] = ArrayList.class;
        clsArr[19] = Float.TYPE;
        clsArr[20] = float[].class;
        clsArr[21] = Parcelable.class;
        clsArr[22] = Parcelable[].class;
        clsArr[23] = Serializable.class;
        clsArr[24] = Short.TYPE;
        clsArr[25] = short[].class;
        clsArr[26] = SparseArray.class;
        int i10 = Build.VERSION.SDK_INT;
        clsArr[27] = i10 >= 21 ? Size.class : cls;
        if (i10 >= 21) {
            cls = SizeF.class;
        }
        clsArr[28] = cls;
        f3061e = clsArr;
    }

    public z() {
        this.f3063b = new HashMap();
        this.f3064c = new HashMap();
        this.f3065d = new a();
        this.f3062a = new HashMap();
    }

    public z(Map<String, Object> map) {
        this.f3063b = new HashMap();
        this.f3064c = new HashMap();
        this.f3065d = new a();
        this.f3062a = new HashMap(map);
    }

    static z a(Bundle bundle, Bundle bundle2) {
        if (bundle == null && bundle2 == null) {
            return new z();
        }
        HashMap hashMap = new HashMap();
        if (bundle2 != null) {
            for (String str : bundle2.keySet()) {
                hashMap.put(str, bundle2.get(str));
            }
        }
        if (bundle == null) {
            return new z(hashMap);
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
        ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
        if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
            throw new IllegalStateException("Invalid bundle passed as restored state");
        }
        for (int i10 = 0; i10 < parcelableArrayList.size(); i10++) {
            hashMap.put((String) parcelableArrayList.get(i10), parcelableArrayList2.get(i10));
        }
        return new z(hashMap);
    }

    private static void d(Object obj) {
        if (obj != null) {
            Class[] clsArr = f3061e;
            int length = clsArr.length;
            int i10 = 0;
            while (i10 < length) {
                if (!clsArr[i10].isInstance(obj)) {
                    i10++;
                } else {
                    return;
                }
            }
            throw new IllegalArgumentException("Can't put value with type " + obj.getClass() + " into saved state");
        }
    }

    /* access modifiers changed from: package-private */
    public SavedStateRegistry.b b() {
        return this.f3065d;
    }

    public <T> void c(String str, T t10) {
        d(t10);
        u uVar = (u) this.f3064c.get(str);
        if (uVar != null) {
            uVar.l(t10);
        } else {
            this.f3062a.put(str, t10);
        }
    }
}
