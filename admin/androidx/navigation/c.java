package androidx.navigation;

import android.os.Bundle;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final int f3116a;

    /* renamed from: b  reason: collision with root package name */
    private n f3117b;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f3118c;

    public c(int i10) {
        this(i10, (n) null);
    }

    public c(int i10, n nVar) {
        this(i10, nVar, (Bundle) null);
    }

    public c(int i10, n nVar, Bundle bundle) {
        this.f3116a = i10;
        this.f3117b = nVar;
        this.f3118c = bundle;
    }

    public Bundle a() {
        return this.f3118c;
    }

    public int b() {
        return this.f3116a;
    }

    public n c() {
        return this.f3117b;
    }

    public void d(Bundle bundle) {
        this.f3118c = bundle;
    }

    public void e(n nVar) {
        this.f3117b = nVar;
    }
}
