package androidx.recyclerview.widget;

import android.view.View;

class y {

    /* renamed from: a  reason: collision with root package name */
    final b f3704a;

    /* renamed from: b  reason: collision with root package name */
    a f3705b = new a();

    static class a {

        /* renamed from: a  reason: collision with root package name */
        int f3706a = 0;

        /* renamed from: b  reason: collision with root package name */
        int f3707b;

        /* renamed from: c  reason: collision with root package name */
        int f3708c;

        /* renamed from: d  reason: collision with root package name */
        int f3709d;

        /* renamed from: e  reason: collision with root package name */
        int f3710e;

        a() {
        }

        /* access modifiers changed from: package-private */
        public void a(int i10) {
            this.f3706a = i10 | this.f3706a;
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            int i10 = this.f3706a;
            if ((i10 & 7) != 0 && (i10 & (c(this.f3709d, this.f3707b) << 0)) == 0) {
                return false;
            }
            int i11 = this.f3706a;
            if ((i11 & 112) != 0 && (i11 & (c(this.f3709d, this.f3708c) << 4)) == 0) {
                return false;
            }
            int i12 = this.f3706a;
            if ((i12 & 1792) != 0 && (i12 & (c(this.f3710e, this.f3707b) << 8)) == 0) {
                return false;
            }
            int i13 = this.f3706a;
            return (i13 & 28672) == 0 || (i13 & (c(this.f3710e, this.f3708c) << 12)) != 0;
        }

        /* access modifiers changed from: package-private */
        public int c(int i10, int i11) {
            if (i10 > i11) {
                return 1;
            }
            return i10 == i11 ? 2 : 4;
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.f3706a = 0;
        }

        /* access modifiers changed from: package-private */
        public void e(int i10, int i11, int i12, int i13) {
            this.f3707b = i10;
            this.f3708c = i11;
            this.f3709d = i12;
            this.f3710e = i13;
        }
    }

    interface b {
        View a(int i10);

        int b();

        int c(View view);

        int d();

        int e(View view);
    }

    y(b bVar) {
        this.f3704a = bVar;
    }

    /* access modifiers changed from: package-private */
    public View a(int i10, int i11, int i12, int i13) {
        int d10 = this.f3704a.d();
        int b10 = this.f3704a.b();
        int i14 = i11 > i10 ? 1 : -1;
        View view = null;
        while (i10 != i11) {
            View a10 = this.f3704a.a(i10);
            this.f3705b.e(d10, b10, this.f3704a.c(a10), this.f3704a.e(a10));
            if (i12 != 0) {
                this.f3705b.d();
                this.f3705b.a(i12);
                if (this.f3705b.b()) {
                    return a10;
                }
            }
            if (i13 != 0) {
                this.f3705b.d();
                this.f3705b.a(i13);
                if (this.f3705b.b()) {
                    view = a10;
                }
            }
            i10 += i14;
        }
        return view;
    }

    /* access modifiers changed from: package-private */
    public boolean b(View view, int i10) {
        this.f3705b.e(this.f3704a.d(), this.f3704a.b(), this.f3704a.c(view), this.f3704a.e(view));
        if (i10 == 0) {
            return false;
        }
        this.f3705b.d();
        this.f3705b.a(i10);
        return this.f3705b.b();
    }
}
