package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import c0.h;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private final String f3176a;

    /* renamed from: b  reason: collision with root package name */
    private j f3177b;

    /* renamed from: c  reason: collision with root package name */
    private int f3178c;

    /* renamed from: d  reason: collision with root package name */
    private String f3179d;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f3180e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<g> f3181f;

    /* renamed from: g  reason: collision with root package name */
    private h<c> f3182g;

    /* renamed from: h  reason: collision with root package name */
    private HashMap<String, d> f3183h;

    static class a implements Comparable<a> {

        /* renamed from: a  reason: collision with root package name */
        private final i f3184a;

        /* renamed from: b  reason: collision with root package name */
        private final Bundle f3185b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f3186c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f3187d;

        /* renamed from: e  reason: collision with root package name */
        private final int f3188e;

        a(i iVar, Bundle bundle, boolean z10, boolean z11, int i10) {
            this.f3184a = iVar;
            this.f3185b = bundle;
            this.f3186c = z10;
            this.f3187d = z11;
            this.f3188e = i10;
        }

        /* renamed from: a */
        public int compareTo(a aVar) {
            boolean z10 = this.f3186c;
            if (z10 && !aVar.f3186c) {
                return 1;
            }
            if (!z10 && aVar.f3186c) {
                return -1;
            }
            Bundle bundle = this.f3185b;
            if (bundle != null && aVar.f3185b == null) {
                return 1;
            }
            if (bundle == null && aVar.f3185b != null) {
                return -1;
            }
            if (bundle != null) {
                int size = bundle.size() - aVar.f3185b.size();
                if (size > 0) {
                    return 1;
                }
                if (size < 0) {
                    return -1;
                }
            }
            boolean z11 = this.f3187d;
            if (z11 && !aVar.f3187d) {
                return 1;
            }
            if (z11 || !aVar.f3187d) {
                return this.f3188e - aVar.f3188e;
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        public i b() {
            return this.f3184a;
        }

        /* access modifiers changed from: package-private */
        public Bundle e() {
            return this.f3185b;
        }
    }

    static {
        new HashMap();
    }

    public i(q<? extends i> qVar) {
        this(r.c(qVar.getClass()));
    }

    public i(String str) {
        this.f3176a = str;
    }

    static String v(Context context, int i10) {
        if (i10 <= 16777215) {
            return Integer.toString(i10);
        }
        try {
            return context.getResources().getResourceName(i10);
        } catch (Resources.NotFoundException unused) {
            return Integer.toString(i10);
        }
    }

    public void A(Context context, AttributeSet attributeSet) {
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, o1.a.Navigator);
        C(obtainAttributes.getResourceId(o1.a.Navigator_android_id, 0));
        this.f3179d = v(context, this.f3178c);
        D(obtainAttributes.getText(o1.a.Navigator_android_label));
        obtainAttributes.recycle();
    }

    public final void B(int i10, c cVar) {
        if (!F()) {
            throw new UnsupportedOperationException("Cannot add action " + i10 + " to " + this + " as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
        } else if (i10 != 0) {
            if (this.f3182g == null) {
                this.f3182g = new h<>();
            }
            this.f3182g.n(i10, cVar);
        } else {
            throw new IllegalArgumentException("Cannot have an action with actionId 0");
        }
    }

    public final void C(int i10) {
        this.f3178c = i10;
        this.f3179d = null;
    }

    public final void D(CharSequence charSequence) {
        this.f3180e = charSequence;
    }

    /* access modifiers changed from: package-private */
    public final void E(j jVar) {
        this.f3177b = jVar;
    }

    /* access modifiers changed from: package-private */
    public boolean F() {
        return true;
    }

    public final void c(String str, d dVar) {
        if (this.f3183h == null) {
            this.f3183h = new HashMap<>();
        }
        this.f3183h.put(str, dVar);
    }

    public final void f(g gVar) {
        if (this.f3181f == null) {
            this.f3181f = new ArrayList<>();
        }
        this.f3181f.add(gVar);
    }

    /* access modifiers changed from: package-private */
    public Bundle h(Bundle bundle) {
        HashMap<String, d> hashMap;
        if (bundle == null && ((hashMap = this.f3183h) == null || hashMap.isEmpty())) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        HashMap<String, d> hashMap2 = this.f3183h;
        if (hashMap2 != null) {
            for (Map.Entry next : hashMap2.entrySet()) {
                ((d) next.getValue()).c((String) next.getKey(), bundle2);
            }
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
            HashMap<String, d> hashMap3 = this.f3183h;
            if (hashMap3 != null) {
                for (Map.Entry next2 : hashMap3.entrySet()) {
                    if (!((d) next2.getValue()).d((String) next2.getKey(), bundle2)) {
                        throw new IllegalArgumentException("Wrong argument type for '" + ((String) next2.getKey()) + "' in argument bundle. " + ((d) next2.getValue()).a().c() + " expected.");
                    }
                }
            }
        }
        return bundle2;
    }

    /* access modifiers changed from: package-private */
    public int[] i() {
        ArrayDeque arrayDeque = new ArrayDeque();
        j jVar = this;
        while (true) {
            j y10 = jVar.y();
            if (y10 == null || y10.K() != jVar.w()) {
                arrayDeque.addFirst(jVar);
            }
            if (y10 == null) {
                break;
            }
            jVar = y10;
        }
        int[] iArr = new int[arrayDeque.size()];
        int i10 = 0;
        Iterator it = arrayDeque.iterator();
        while (it.hasNext()) {
            iArr[i10] = ((i) it.next()).w();
            i10++;
        }
        return iArr;
    }

    public final c k(int i10) {
        h<c> hVar = this.f3182g;
        c i11 = hVar == null ? null : hVar.i(i10);
        if (i11 != null) {
            return i11;
        }
        if (y() != null) {
            return y().k(i10);
        }
        return null;
    }

    public final Map<String, d> t() {
        HashMap<String, d> hashMap = this.f3183h;
        return hashMap == null ? Collections.emptyMap() : Collections.unmodifiableMap(hashMap);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append("(");
        String str = this.f3179d;
        if (str == null) {
            sb2.append("0x");
            str = Integer.toHexString(this.f3178c);
        }
        sb2.append(str);
        sb2.append(")");
        if (this.f3180e != null) {
            sb2.append(" label=");
            sb2.append(this.f3180e);
        }
        return sb2.toString();
    }

    public String u() {
        if (this.f3179d == null) {
            this.f3179d = Integer.toString(this.f3178c);
        }
        return this.f3179d;
    }

    public final int w() {
        return this.f3178c;
    }

    public final String x() {
        return this.f3176a;
    }

    public final j y() {
        return this.f3177b;
    }

    /* access modifiers changed from: package-private */
    public a z(h hVar) {
        ArrayList<g> arrayList = this.f3181f;
        if (arrayList == null) {
            return null;
        }
        Iterator<g> it = arrayList.iterator();
        a aVar = null;
        while (it.hasNext()) {
            g next = it.next();
            Uri c10 = hVar.c();
            Bundle c11 = c10 != null ? next.c(c10, t()) : null;
            String a10 = hVar.a();
            boolean z10 = a10 != null && a10.equals(next.b());
            String b10 = hVar.b();
            int d10 = b10 != null ? next.d(b10) : -1;
            if (c11 != null || z10 || d10 > -1) {
                a aVar2 = new a(this, c11, next.e(), z10, d10);
                if (aVar == null || aVar2.compareTo(aVar) > 0) {
                    aVar = aVar2;
                }
            }
        }
        return aVar;
    }
}
