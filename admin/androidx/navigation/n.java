package androidx.navigation;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    private boolean f3199a;

    /* renamed from: b  reason: collision with root package name */
    private int f3200b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3201c;

    /* renamed from: d  reason: collision with root package name */
    private int f3202d;

    /* renamed from: e  reason: collision with root package name */
    private int f3203e;

    /* renamed from: f  reason: collision with root package name */
    private int f3204f;

    /* renamed from: g  reason: collision with root package name */
    private int f3205g;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f3206a;

        /* renamed from: b  reason: collision with root package name */
        int f3207b = -1;

        /* renamed from: c  reason: collision with root package name */
        boolean f3208c;

        /* renamed from: d  reason: collision with root package name */
        int f3209d = -1;

        /* renamed from: e  reason: collision with root package name */
        int f3210e = -1;

        /* renamed from: f  reason: collision with root package name */
        int f3211f = -1;

        /* renamed from: g  reason: collision with root package name */
        int f3212g = -1;

        public n a() {
            return new n(this.f3206a, this.f3207b, this.f3208c, this.f3209d, this.f3210e, this.f3211f, this.f3212g);
        }

        public a b(int i10) {
            this.f3209d = i10;
            return this;
        }

        public a c(int i10) {
            this.f3210e = i10;
            return this;
        }

        public a d(boolean z10) {
            this.f3206a = z10;
            return this;
        }

        public a e(int i10) {
            this.f3211f = i10;
            return this;
        }

        public a f(int i10) {
            this.f3212g = i10;
            return this;
        }

        public a g(int i10, boolean z10) {
            this.f3207b = i10;
            this.f3208c = z10;
            return this;
        }
    }

    n(boolean z10, int i10, boolean z11, int i11, int i12, int i13, int i14) {
        this.f3199a = z10;
        this.f3200b = i10;
        this.f3201c = z11;
        this.f3202d = i11;
        this.f3203e = i12;
        this.f3204f = i13;
        this.f3205g = i14;
    }

    public int a() {
        return this.f3202d;
    }

    public int b() {
        return this.f3203e;
    }

    public int c() {
        return this.f3204f;
    }

    public int d() {
        return this.f3205g;
    }

    public int e() {
        return this.f3200b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n.class != obj.getClass()) {
            return false;
        }
        n nVar = (n) obj;
        return this.f3199a == nVar.f3199a && this.f3200b == nVar.f3200b && this.f3201c == nVar.f3201c && this.f3202d == nVar.f3202d && this.f3203e == nVar.f3203e && this.f3204f == nVar.f3204f && this.f3205g == nVar.f3205g;
    }

    public boolean f() {
        return this.f3201c;
    }

    public boolean g() {
        return this.f3199a;
    }

    public int hashCode() {
        return ((((((((((((g() ? 1 : 0) * true) + e()) * 31) + (f() ? 1 : 0)) * 31) + a()) * 31) + b()) * 31) + c()) * 31) + d();
    }
}
