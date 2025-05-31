package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.r;
import java.util.ArrayList;
import java.util.List;
import w0.e;
import w0.f;

final class a implements r.a {

    /* renamed from: a  reason: collision with root package name */
    private e<b> f3461a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<b> f3462b;

    /* renamed from: c  reason: collision with root package name */
    final ArrayList<b> f3463c;

    /* renamed from: d  reason: collision with root package name */
    final C0034a f3464d;

    /* renamed from: e  reason: collision with root package name */
    Runnable f3465e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f3466f;

    /* renamed from: g  reason: collision with root package name */
    final r f3467g;

    /* renamed from: h  reason: collision with root package name */
    private int f3468h;

    /* renamed from: androidx.recyclerview.widget.a$a  reason: collision with other inner class name */
    interface C0034a {
        void a(int i10, int i11);

        void b(b bVar);

        RecyclerView.c0 c(int i10);

        void d(int i10, int i11);

        void e(int i10, int i11);

        void f(int i10, int i11);

        void g(b bVar);

        void h(int i10, int i11, Object obj);
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        int f3469a;

        /* renamed from: b  reason: collision with root package name */
        int f3470b;

        /* renamed from: c  reason: collision with root package name */
        Object f3471c;

        /* renamed from: d  reason: collision with root package name */
        int f3472d;

        b(int i10, int i11, int i12, Object obj) {
            this.f3469a = i10;
            this.f3470b = i11;
            this.f3472d = i12;
            this.f3471c = obj;
        }

        /* access modifiers changed from: package-private */
        public String a() {
            int i10 = this.f3469a;
            return i10 != 1 ? i10 != 2 ? i10 != 4 ? i10 != 8 ? "??" : "mv" : "up" : "rm" : "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            int i10 = this.f3469a;
            if (i10 != bVar.f3469a) {
                return false;
            }
            if (i10 == 8 && Math.abs(this.f3472d - this.f3470b) == 1 && this.f3472d == bVar.f3470b && this.f3470b == bVar.f3472d) {
                return true;
            }
            if (this.f3472d != bVar.f3472d || this.f3470b != bVar.f3470b) {
                return false;
            }
            Object obj2 = this.f3471c;
            Object obj3 = bVar.f3471c;
            if (obj2 != null) {
                if (!obj2.equals(obj3)) {
                    return false;
                }
            } else if (obj3 != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f3469a * 31) + this.f3470b) * 31) + this.f3472d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f3470b + "c:" + this.f3472d + ",p:" + this.f3471c + "]";
        }
    }

    a(C0034a aVar) {
        this(aVar, false);
    }

    a(C0034a aVar, boolean z10) {
        this.f3461a = new f(30);
        this.f3462b = new ArrayList<>();
        this.f3463c = new ArrayList<>();
        this.f3468h = 0;
        this.f3464d = aVar;
        this.f3466f = z10;
        this.f3467g = new r(this);
    }

    private void c(b bVar) {
        v(bVar);
    }

    private void d(b bVar) {
        v(bVar);
    }

    private void f(b bVar) {
        char c10;
        boolean z10;
        boolean z11;
        int i10 = bVar.f3470b;
        int i11 = bVar.f3472d + i10;
        char c11 = 65535;
        int i12 = i10;
        int i13 = 0;
        while (i12 < i11) {
            if (this.f3464d.c(i12) != null || h(i12)) {
                if (c11 == 0) {
                    k(b(2, i10, i13, (Object) null));
                    z11 = true;
                } else {
                    z11 = false;
                }
                c10 = 1;
            } else {
                if (c11 == 1) {
                    v(b(2, i10, i13, (Object) null));
                    z10 = true;
                } else {
                    z10 = false;
                }
                c10 = 0;
            }
            if (z10) {
                i12 -= i13;
                i11 -= i13;
                i13 = 1;
            } else {
                i13++;
            }
            i12++;
            c11 = c10;
        }
        if (i13 != bVar.f3472d) {
            a(bVar);
            bVar = b(2, i10, i13, (Object) null);
        }
        if (c11 == 0) {
            k(bVar);
        } else {
            v(bVar);
        }
    }

    private void g(b bVar) {
        int i10 = bVar.f3470b;
        int i11 = bVar.f3472d + i10;
        int i12 = 0;
        boolean z10 = true;
        int i13 = i10;
        while (i10 < i11) {
            if (this.f3464d.c(i10) != null || h(i10)) {
                if (!z10) {
                    k(b(4, i13, i12, bVar.f3471c));
                    i13 = i10;
                    i12 = 0;
                }
                z10 = true;
            } else {
                if (z10) {
                    v(b(4, i13, i12, bVar.f3471c));
                    i13 = i10;
                    i12 = 0;
                }
                z10 = false;
            }
            i12++;
            i10++;
        }
        if (i12 != bVar.f3472d) {
            Object obj = bVar.f3471c;
            a(bVar);
            bVar = b(4, i13, i12, obj);
        }
        if (!z10) {
            k(bVar);
        } else {
            v(bVar);
        }
    }

    private boolean h(int i10) {
        int size = this.f3463c.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = this.f3463c.get(i11);
            int i12 = bVar.f3469a;
            if (i12 == 8) {
                if (n(bVar.f3472d, i11 + 1) == i10) {
                    return true;
                }
            } else if (i12 == 1) {
                int i13 = bVar.f3470b;
                int i14 = bVar.f3472d + i13;
                while (i13 < i14) {
                    if (n(i13, i11 + 1) == i10) {
                        return true;
                    }
                    i13++;
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void k(b bVar) {
        int i10;
        int i11 = bVar.f3469a;
        if (i11 == 1 || i11 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int z10 = z(bVar.f3470b, i11);
        int i12 = bVar.f3470b;
        int i13 = bVar.f3469a;
        if (i13 == 2) {
            i10 = 0;
        } else if (i13 == 4) {
            i10 = 1;
        } else {
            throw new IllegalArgumentException("op should be remove or update." + bVar);
        }
        int i14 = 1;
        for (int i15 = 1; i15 < bVar.f3472d; i15++) {
            int z11 = z(bVar.f3470b + (i10 * i15), bVar.f3469a);
            int i16 = bVar.f3469a;
            if (i16 == 2 ? z11 == z10 : i16 == 4 && z11 == z10 + 1) {
                i14++;
            } else {
                b b10 = b(i16, z10, i14, bVar.f3471c);
                l(b10, i12);
                a(b10);
                if (bVar.f3469a == 4) {
                    i12 += i14;
                }
                i14 = 1;
                z10 = z11;
            }
        }
        Object obj = bVar.f3471c;
        a(bVar);
        if (i14 > 0) {
            b b11 = b(bVar.f3469a, z10, i14, obj);
            l(b11, i12);
            a(b11);
        }
    }

    private void v(b bVar) {
        this.f3463c.add(bVar);
        int i10 = bVar.f3469a;
        if (i10 == 1) {
            this.f3464d.e(bVar.f3470b, bVar.f3472d);
        } else if (i10 == 2) {
            this.f3464d.d(bVar.f3470b, bVar.f3472d);
        } else if (i10 == 4) {
            this.f3464d.h(bVar.f3470b, bVar.f3472d, bVar.f3471c);
        } else if (i10 == 8) {
            this.f3464d.a(bVar.f3470b, bVar.f3472d);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    private int z(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        for (int size = this.f3463c.size() - 1; size >= 0; size--) {
            b bVar = this.f3463c.get(size);
            int i18 = bVar.f3469a;
            if (i18 == 8) {
                int i19 = bVar.f3470b;
                int i20 = bVar.f3472d;
                if (i19 < i20) {
                    i14 = i19;
                    i13 = i20;
                } else {
                    i13 = i19;
                    i14 = i20;
                }
                if (i10 < i14 || i10 > i13) {
                    if (i10 < i19) {
                        if (i11 == 1) {
                            bVar.f3470b = i19 + 1;
                            i15 = i20 + 1;
                        } else if (i11 == 2) {
                            bVar.f3470b = i19 - 1;
                            i15 = i20 - 1;
                        }
                        bVar.f3472d = i15;
                    }
                } else if (i14 == i19) {
                    if (i11 == 1) {
                        i17 = i20 + 1;
                    } else {
                        if (i11 == 2) {
                            i17 = i20 - 1;
                        }
                        i10++;
                    }
                    bVar.f3472d = i17;
                    i10++;
                } else {
                    if (i11 == 1) {
                        i16 = i19 + 1;
                    } else {
                        if (i11 == 2) {
                            i16 = i19 - 1;
                        }
                        i10--;
                    }
                    bVar.f3470b = i16;
                    i10--;
                }
            } else {
                int i21 = bVar.f3470b;
                if (i21 > i10) {
                    if (i11 == 1) {
                        i12 = i21 + 1;
                    } else if (i11 == 2) {
                        i12 = i21 - 1;
                    }
                    bVar.f3470b = i12;
                } else if (i18 == 1) {
                    i10 -= bVar.f3472d;
                } else if (i18 == 2) {
                    i10 += bVar.f3472d;
                }
            }
        }
        for (int size2 = this.f3463c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.f3463c.get(size2);
            if (bVar2.f3469a == 8) {
                int i22 = bVar2.f3472d;
                if (i22 != bVar2.f3470b && i22 >= 0) {
                }
            } else if (bVar2.f3472d > 0) {
            }
            this.f3463c.remove(size2);
            a(bVar2);
        }
        return i10;
    }

    public void a(b bVar) {
        if (!this.f3466f) {
            bVar.f3471c = null;
            this.f3461a.a(bVar);
        }
    }

    public b b(int i10, int i11, int i12, Object obj) {
        b b10 = this.f3461a.b();
        if (b10 == null) {
            return new b(i10, i11, i12, obj);
        }
        b10.f3469a = i10;
        b10.f3470b = i11;
        b10.f3472d = i12;
        b10.f3471c = obj;
        return b10;
    }

    public int e(int i10) {
        int size = this.f3462b.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = this.f3462b.get(i11);
            int i12 = bVar.f3469a;
            if (i12 != 1) {
                if (i12 == 2) {
                    int i13 = bVar.f3470b;
                    if (i13 <= i10) {
                        int i14 = bVar.f3472d;
                        if (i13 + i14 > i10) {
                            return -1;
                        }
                        i10 -= i14;
                    } else {
                        continue;
                    }
                } else if (i12 == 8) {
                    int i15 = bVar.f3470b;
                    if (i15 == i10) {
                        i10 = bVar.f3472d;
                    } else {
                        if (i15 < i10) {
                            i10--;
                        }
                        if (bVar.f3472d <= i10) {
                            i10++;
                        }
                    }
                }
            } else if (bVar.f3470b <= i10) {
                i10 += bVar.f3472d;
            }
        }
        return i10;
    }

    /* access modifiers changed from: package-private */
    public void i() {
        int size = this.f3463c.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f3464d.b(this.f3463c.get(i10));
        }
        x(this.f3463c);
        this.f3468h = 0;
    }

    /* access modifiers changed from: package-private */
    public void j() {
        i();
        int size = this.f3462b.size();
        for (int i10 = 0; i10 < size; i10++) {
            b bVar = this.f3462b.get(i10);
            int i11 = bVar.f3469a;
            if (i11 == 1) {
                this.f3464d.b(bVar);
                this.f3464d.e(bVar.f3470b, bVar.f3472d);
            } else if (i11 == 2) {
                this.f3464d.b(bVar);
                this.f3464d.f(bVar.f3470b, bVar.f3472d);
            } else if (i11 == 4) {
                this.f3464d.b(bVar);
                this.f3464d.h(bVar.f3470b, bVar.f3472d, bVar.f3471c);
            } else if (i11 == 8) {
                this.f3464d.b(bVar);
                this.f3464d.a(bVar.f3470b, bVar.f3472d);
            }
            Runnable runnable = this.f3465e;
            if (runnable != null) {
                runnable.run();
            }
        }
        x(this.f3462b);
        this.f3468h = 0;
    }

    /* access modifiers changed from: package-private */
    public void l(b bVar, int i10) {
        this.f3464d.g(bVar);
        int i11 = bVar.f3469a;
        if (i11 == 2) {
            this.f3464d.f(i10, bVar.f3472d);
        } else if (i11 == 4) {
            this.f3464d.h(i10, bVar.f3472d, bVar.f3471c);
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    /* access modifiers changed from: package-private */
    public int m(int i10) {
        return n(i10, 0);
    }

    /* access modifiers changed from: package-private */
    public int n(int i10, int i11) {
        int size = this.f3463c.size();
        while (i11 < size) {
            b bVar = this.f3463c.get(i11);
            int i12 = bVar.f3469a;
            if (i12 == 8) {
                int i13 = bVar.f3470b;
                if (i13 == i10) {
                    i10 = bVar.f3472d;
                } else {
                    if (i13 < i10) {
                        i10--;
                    }
                    if (bVar.f3472d <= i10) {
                        i10++;
                    }
                }
            } else {
                int i14 = bVar.f3470b;
                if (i14 > i10) {
                    continue;
                } else if (i12 == 2) {
                    int i15 = bVar.f3472d;
                    if (i10 < i14 + i15) {
                        return -1;
                    }
                    i10 -= i15;
                } else if (i12 == 1) {
                    i10 += bVar.f3472d;
                }
            }
            i11++;
        }
        return i10;
    }

    /* access modifiers changed from: package-private */
    public boolean o(int i10) {
        return (i10 & this.f3468h) != 0;
    }

    /* access modifiers changed from: package-private */
    public boolean p() {
        return this.f3462b.size() > 0;
    }

    /* access modifiers changed from: package-private */
    public boolean q() {
        return !this.f3463c.isEmpty() && !this.f3462b.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public boolean r(int i10, int i11, Object obj) {
        if (i11 < 1) {
            return false;
        }
        this.f3462b.add(b(4, i10, i11, obj));
        this.f3468h |= 4;
        return this.f3462b.size() == 1;
    }

    /* access modifiers changed from: package-private */
    public boolean s(int i10, int i11) {
        if (i11 < 1) {
            return false;
        }
        this.f3462b.add(b(1, i10, i11, (Object) null));
        this.f3468h |= 1;
        return this.f3462b.size() == 1;
    }

    /* access modifiers changed from: package-private */
    public boolean t(int i10, int i11, int i12) {
        if (i10 == i11) {
            return false;
        }
        if (i12 == 1) {
            this.f3462b.add(b(8, i10, i11, (Object) null));
            this.f3468h |= 8;
            return this.f3462b.size() == 1;
        }
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }

    /* access modifiers changed from: package-private */
    public boolean u(int i10, int i11) {
        if (i11 < 1) {
            return false;
        }
        this.f3462b.add(b(2, i10, i11, (Object) null));
        this.f3468h |= 2;
        return this.f3462b.size() == 1;
    }

    /* access modifiers changed from: package-private */
    public void w() {
        this.f3467g.b(this.f3462b);
        int size = this.f3462b.size();
        for (int i10 = 0; i10 < size; i10++) {
            b bVar = this.f3462b.get(i10);
            int i11 = bVar.f3469a;
            if (i11 == 1) {
                c(bVar);
            } else if (i11 == 2) {
                f(bVar);
            } else if (i11 == 4) {
                g(bVar);
            } else if (i11 == 8) {
                d(bVar);
            }
            Runnable runnable = this.f3465e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f3462b.clear();
    }

    /* access modifiers changed from: package-private */
    public void x(List<b> list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            a(list.get(i10));
        }
        list.clear();
    }

    /* access modifiers changed from: package-private */
    public void y() {
        x(this.f3462b);
        x(this.f3463c);
        this.f3468h = 0;
    }
}
