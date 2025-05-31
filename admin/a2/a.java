package a2;

import android.os.Build;
import androidx.work.f;

public final class a {

    /* renamed from: i  reason: collision with root package name */
    public static final a f58i = new C0003a().a();

    /* renamed from: a  reason: collision with root package name */
    private f f59a = f.NOT_REQUIRED;

    /* renamed from: b  reason: collision with root package name */
    private boolean f60b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f61c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f62d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f63e;

    /* renamed from: f  reason: collision with root package name */
    private long f64f = -1;

    /* renamed from: g  reason: collision with root package name */
    private long f65g = -1;

    /* renamed from: h  reason: collision with root package name */
    private b f66h = new b();

    /* renamed from: a2.a$a  reason: collision with other inner class name */
    public static final class C0003a {

        /* renamed from: a  reason: collision with root package name */
        boolean f67a = false;

        /* renamed from: b  reason: collision with root package name */
        boolean f68b = false;

        /* renamed from: c  reason: collision with root package name */
        f f69c = f.NOT_REQUIRED;

        /* renamed from: d  reason: collision with root package name */
        boolean f70d = false;

        /* renamed from: e  reason: collision with root package name */
        boolean f71e = false;

        /* renamed from: f  reason: collision with root package name */
        long f72f = -1;

        /* renamed from: g  reason: collision with root package name */
        long f73g = -1;

        /* renamed from: h  reason: collision with root package name */
        b f74h = new b();

        public a a() {
            return new a(this);
        }
    }

    public a() {
    }

    a(C0003a aVar) {
        this.f60b = aVar.f67a;
        int i10 = Build.VERSION.SDK_INT;
        this.f61c = i10 >= 23 && aVar.f68b;
        this.f59a = aVar.f69c;
        this.f62d = aVar.f70d;
        this.f63e = aVar.f71e;
        if (i10 >= 24) {
            this.f66h = aVar.f74h;
            this.f64f = aVar.f72f;
            this.f65g = aVar.f73g;
        }
    }

    public a(a aVar) {
        this.f60b = aVar.f60b;
        this.f61c = aVar.f61c;
        this.f59a = aVar.f59a;
        this.f62d = aVar.f62d;
        this.f63e = aVar.f63e;
        this.f66h = aVar.f66h;
    }

    public b a() {
        return this.f66h;
    }

    public f b() {
        return this.f59a;
    }

    public long c() {
        return this.f64f;
    }

    public long d() {
        return this.f65g;
    }

    public boolean e() {
        return this.f66h.c() > 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f60b == aVar.f60b && this.f61c == aVar.f61c && this.f62d == aVar.f62d && this.f63e == aVar.f63e && this.f64f == aVar.f64f && this.f65g == aVar.f65g && this.f59a == aVar.f59a) {
            return this.f66h.equals(aVar.f66h);
        }
        return false;
    }

    public boolean f() {
        return this.f62d;
    }

    public boolean g() {
        return this.f60b;
    }

    public boolean h() {
        return this.f61c;
    }

    public int hashCode() {
        long j10 = this.f64f;
        long j11 = this.f65g;
        return (((((((((((((this.f59a.hashCode() * 31) + (this.f60b ? 1 : 0)) * 31) + (this.f61c ? 1 : 0)) * 31) + (this.f62d ? 1 : 0)) * 31) + (this.f63e ? 1 : 0)) * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31) + this.f66h.hashCode();
    }

    public boolean i() {
        return this.f63e;
    }

    public void j(b bVar) {
        this.f66h = bVar;
    }

    public void k(f fVar) {
        this.f59a = fVar;
    }

    public void l(boolean z10) {
        this.f62d = z10;
    }

    public void m(boolean z10) {
        this.f60b = z10;
    }

    public void n(boolean z10) {
        this.f61c = z10;
    }

    public void o(boolean z10) {
        this.f63e = z10;
    }

    public void p(long j10) {
        this.f64f = j10;
    }

    public void q(long j10) {
        this.f65g = j10;
    }
}
