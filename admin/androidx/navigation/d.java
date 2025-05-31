package androidx.navigation;

import android.os.Bundle;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final o f3119a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f3120b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f3121c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f3122d;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private o<?> f3123a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f3124b = false;

        /* renamed from: c  reason: collision with root package name */
        private Object f3125c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f3126d = false;

        public d a() {
            if (this.f3123a == null) {
                this.f3123a = o.e(this.f3125c);
            }
            return new d(this.f3123a, this.f3124b, this.f3125c, this.f3126d);
        }

        public a b(Object obj) {
            this.f3125c = obj;
            this.f3126d = true;
            return this;
        }

        public a c(boolean z10) {
            this.f3124b = z10;
            return this;
        }

        public a d(o<?> oVar) {
            this.f3123a = oVar;
            return this;
        }
    }

    d(o<?> oVar, boolean z10, Object obj, boolean z11) {
        if (!oVar.f() && z10) {
            throw new IllegalArgumentException(oVar.c() + " does not allow nullable values");
        } else if (z10 || !z11 || obj != null) {
            this.f3119a = oVar;
            this.f3120b = z10;
            this.f3122d = obj;
            this.f3121c = z11;
        } else {
            throw new IllegalArgumentException("Argument with type " + oVar.c() + " has null value but is not nullable.");
        }
    }

    public o<?> a() {
        return this.f3119a;
    }

    public boolean b() {
        return this.f3121c;
    }

    /* access modifiers changed from: package-private */
    public void c(String str, Bundle bundle) {
        if (this.f3121c) {
            this.f3119a.i(bundle, str, this.f3122d);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean d(String str, Bundle bundle) {
        if (!this.f3120b && bundle.containsKey(str) && bundle.get(str) == null) {
            return false;
        }
        try {
            this.f3119a.b(bundle, str);
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f3120b != dVar.f3120b || this.f3121c != dVar.f3121c || !this.f3119a.equals(dVar.f3119a)) {
            return false;
        }
        Object obj2 = this.f3122d;
        Object obj3 = dVar.f3122d;
        return obj2 != null ? obj2.equals(obj3) : obj3 == null;
    }

    public int hashCode() {
        int hashCode = ((((this.f3119a.hashCode() * 31) + (this.f3120b ? 1 : 0)) * 31) + (this.f3121c ? 1 : 0)) * 31;
        Object obj = this.f3122d;
        return hashCode + (obj != null ? obj.hashCode() : 0);
    }
}
