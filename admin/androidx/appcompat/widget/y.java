package androidx.appcompat.widget;

class y {

    /* renamed from: a  reason: collision with root package name */
    private int f1226a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f1227b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f1228c = Integer.MIN_VALUE;

    /* renamed from: d  reason: collision with root package name */
    private int f1229d = Integer.MIN_VALUE;

    /* renamed from: e  reason: collision with root package name */
    private int f1230e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f1231f = 0;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1232g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1233h = false;

    y() {
    }

    public int a() {
        return this.f1232g ? this.f1226a : this.f1227b;
    }

    public int b() {
        return this.f1226a;
    }

    public int c() {
        return this.f1227b;
    }

    public int d() {
        return this.f1232g ? this.f1227b : this.f1226a;
    }

    public void e(int i10, int i11) {
        this.f1233h = false;
        if (i10 != Integer.MIN_VALUE) {
            this.f1230e = i10;
            this.f1226a = i10;
        }
        if (i11 != Integer.MIN_VALUE) {
            this.f1231f = i11;
            this.f1227b = i11;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
        if (r2 != Integer.MIN_VALUE) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
        if (r2 != Integer.MIN_VALUE) goto L_0x0031;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(boolean r2) {
        /*
            r1 = this;
            boolean r0 = r1.f1232g
            if (r2 != r0) goto L_0x0005
            return
        L_0x0005:
            r1.f1232g = r2
            boolean r0 = r1.f1233h
            if (r0 == 0) goto L_0x002b
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r2 == 0) goto L_0x001d
            int r2 = r1.f1229d
            if (r2 == r0) goto L_0x0014
            goto L_0x0016
        L_0x0014:
            int r2 = r1.f1230e
        L_0x0016:
            r1.f1226a = r2
            int r2 = r1.f1228c
            if (r2 == r0) goto L_0x002f
            goto L_0x0031
        L_0x001d:
            int r2 = r1.f1228c
            if (r2 == r0) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            int r2 = r1.f1230e
        L_0x0024:
            r1.f1226a = r2
            int r2 = r1.f1229d
            if (r2 == r0) goto L_0x002f
            goto L_0x0031
        L_0x002b:
            int r2 = r1.f1230e
            r1.f1226a = r2
        L_0x002f:
            int r2 = r1.f1231f
        L_0x0031:
            r1.f1227b = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.y.f(boolean):void");
    }

    public void g(int i10, int i11) {
        this.f1228c = i10;
        this.f1229d = i11;
        this.f1233h = true;
        if (this.f1232g) {
            if (i11 != Integer.MIN_VALUE) {
                this.f1226a = i11;
            }
            if (i10 != Integer.MIN_VALUE) {
                this.f1227b = i10;
                return;
            }
            return;
        }
        if (i10 != Integer.MIN_VALUE) {
            this.f1226a = i10;
        }
        if (i11 != Integer.MIN_VALUE) {
            this.f1227b = i11;
        }
    }
}
