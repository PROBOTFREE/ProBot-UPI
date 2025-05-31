package androidx.recyclerview.widget;

public class e implements q {

    /* renamed from: a  reason: collision with root package name */
    final q f3499a;

    /* renamed from: b  reason: collision with root package name */
    int f3500b = 0;

    /* renamed from: c  reason: collision with root package name */
    int f3501c = -1;

    /* renamed from: d  reason: collision with root package name */
    int f3502d = -1;

    /* renamed from: e  reason: collision with root package name */
    Object f3503e = null;

    public e(q qVar) {
        this.f3499a = qVar;
    }

    public void a(int i10, int i11) {
        int i12;
        if (this.f3500b != 2 || (i12 = this.f3501c) < i10 || i12 > i10 + i11) {
            e();
            this.f3501c = i10;
            this.f3502d = i11;
            this.f3500b = 2;
            return;
        }
        this.f3502d += i11;
        this.f3501c = i10;
    }

    public void b(int i10, int i11) {
        e();
        this.f3499a.b(i10, i11);
    }

    public void c(int i10, int i11) {
        int i12;
        if (this.f3500b == 1 && i10 >= (i12 = this.f3501c)) {
            int i13 = this.f3502d;
            if (i10 <= i12 + i13) {
                this.f3502d = i13 + i11;
                this.f3501c = Math.min(i10, i12);
                return;
            }
        }
        e();
        this.f3501c = i10;
        this.f3502d = i11;
        this.f3500b = 1;
    }

    public void d(int i10, int i11, Object obj) {
        int i12;
        if (this.f3500b == 3) {
            int i13 = this.f3501c;
            int i14 = this.f3502d;
            if (i10 <= i13 + i14 && (i12 = i10 + i11) >= i13 && this.f3503e == obj) {
                this.f3501c = Math.min(i10, i13);
                this.f3502d = Math.max(i14 + i13, i12) - this.f3501c;
                return;
            }
        }
        e();
        this.f3501c = i10;
        this.f3502d = i11;
        this.f3503e = obj;
        this.f3500b = 3;
    }

    public void e() {
        int i10 = this.f3500b;
        if (i10 != 0) {
            if (i10 == 1) {
                this.f3499a.c(this.f3501c, this.f3502d);
            } else if (i10 == 2) {
                this.f3499a.a(this.f3501c, this.f3502d);
            } else if (i10 == 3) {
                this.f3499a.d(this.f3501c, this.f3502d, this.f3503e);
            }
            this.f3503e = null;
            this.f3500b = 0;
        }
    }
}
