package androidx.recyclerview.widget;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private static final Comparator<d> f3548a = new a();

    class a implements Comparator<d> {
        a() {
        }

        /* renamed from: a */
        public int compare(d dVar, d dVar2) {
            return dVar.f3551a - dVar2.f3551a;
        }
    }

    public static abstract class b {
        public abstract boolean a(int i10, int i11);

        public abstract boolean b(int i10, int i11);

        public abstract Object c(int i10, int i11);

        public abstract int d();

        public abstract int e();
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        private final int[] f3549a;

        /* renamed from: b  reason: collision with root package name */
        private final int f3550b;

        c(int i10) {
            int[] iArr = new int[i10];
            this.f3549a = iArr;
            this.f3550b = iArr.length / 2;
        }

        /* access modifiers changed from: package-private */
        public int[] a() {
            return this.f3549a;
        }

        /* access modifiers changed from: package-private */
        public int b(int i10) {
            return this.f3549a[i10 + this.f3550b];
        }

        /* access modifiers changed from: package-private */
        public void c(int i10, int i11) {
            this.f3549a[i10 + this.f3550b] = i11;
        }
    }

    static class d {

        /* renamed from: a  reason: collision with root package name */
        public final int f3551a;

        /* renamed from: b  reason: collision with root package name */
        public final int f3552b;

        /* renamed from: c  reason: collision with root package name */
        public final int f3553c;

        d(int i10, int i11, int i12) {
            this.f3551a = i10;
            this.f3552b = i11;
            this.f3553c = i12;
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return this.f3551a + this.f3553c;
        }

        /* access modifiers changed from: package-private */
        public int b() {
            return this.f3552b + this.f3553c;
        }
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        private final List<d> f3554a;

        /* renamed from: b  reason: collision with root package name */
        private final int[] f3555b;

        /* renamed from: c  reason: collision with root package name */
        private final int[] f3556c;

        /* renamed from: d  reason: collision with root package name */
        private final b f3557d;

        /* renamed from: e  reason: collision with root package name */
        private final int f3558e;

        /* renamed from: f  reason: collision with root package name */
        private final int f3559f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f3560g;

        e(b bVar, List<d> list, int[] iArr, int[] iArr2, boolean z10) {
            this.f3554a = list;
            this.f3555b = iArr;
            this.f3556c = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.f3557d = bVar;
            this.f3558e = bVar.e();
            this.f3559f = bVar.d();
            this.f3560g = z10;
            a();
            d();
        }

        private void a() {
            d dVar = this.f3554a.isEmpty() ? null : this.f3554a.get(0);
            if (!(dVar != null && dVar.f3551a == 0 && dVar.f3552b == 0)) {
                this.f3554a.add(0, new d(0, 0, 0));
            }
            this.f3554a.add(new d(this.f3558e, this.f3559f, 0));
        }

        private void c(int i10) {
            int size = this.f3554a.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                d dVar = this.f3554a.get(i12);
                while (i11 < dVar.f3552b) {
                    if (this.f3556c[i11] != 0 || !this.f3557d.b(i10, i11)) {
                        i11++;
                    } else {
                        int i13 = this.f3557d.a(i10, i11) ? 8 : 4;
                        this.f3555b[i10] = (i11 << 4) | i13;
                        this.f3556c[i11] = (i10 << 4) | i13;
                        return;
                    }
                }
                i11 = dVar.b();
            }
        }

        private void d() {
            for (d next : this.f3554a) {
                for (int i10 = 0; i10 < next.f3553c; i10++) {
                    int i11 = next.f3551a + i10;
                    int i12 = next.f3552b + i10;
                    int i13 = this.f3557d.a(i11, i12) ? 1 : 2;
                    this.f3555b[i11] = (i12 << 4) | i13;
                    this.f3556c[i12] = (i11 << 4) | i13;
                }
            }
            if (this.f3560g) {
                e();
            }
        }

        private void e() {
            int i10 = 0;
            for (d next : this.f3554a) {
                while (i10 < next.f3551a) {
                    if (this.f3555b[i10] == 0) {
                        c(i10);
                    }
                    i10++;
                }
                i10 = next.a();
            }
        }

        private static g f(Collection<g> collection, int i10, boolean z10) {
            g gVar;
            Iterator<g> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    gVar = null;
                    break;
                }
                gVar = it.next();
                if (gVar.f3561a == i10 && gVar.f3563c == z10) {
                    it.remove();
                    break;
                }
            }
            while (it.hasNext()) {
                g next = it.next();
                int i11 = next.f3562b;
                next.f3562b = z10 ? i11 - 1 : i11 + 1;
            }
            return gVar;
        }

        public void b(q qVar) {
            int i10;
            e eVar = qVar instanceof e ? (e) qVar : new e(qVar);
            int i11 = this.f3558e;
            ArrayDeque arrayDeque = new ArrayDeque();
            int i12 = this.f3558e;
            int i13 = this.f3559f;
            for (int size = this.f3554a.size() - 1; size >= 0; size--) {
                d dVar = this.f3554a.get(size);
                int a10 = dVar.a();
                int b10 = dVar.b();
                while (true) {
                    if (i12 <= a10) {
                        break;
                    }
                    i12--;
                    int i14 = this.f3555b[i12];
                    if ((i14 & 12) != 0) {
                        int i15 = i14 >> 4;
                        g f10 = f(arrayDeque, i15, false);
                        if (f10 != null) {
                            int i16 = (i11 - f10.f3562b) - 1;
                            eVar.b(i12, i16);
                            if ((i14 & 4) != 0) {
                                eVar.d(i16, 1, this.f3557d.c(i12, i15));
                            }
                        } else {
                            arrayDeque.add(new g(i12, (i11 - i12) - 1, true));
                        }
                    } else {
                        eVar.a(i12, 1);
                        i11--;
                    }
                }
                while (i13 > b10) {
                    i13--;
                    int i17 = this.f3556c[i13];
                    if ((i17 & 12) != 0) {
                        int i18 = i17 >> 4;
                        g f11 = f(arrayDeque, i18, true);
                        if (f11 == null) {
                            arrayDeque.add(new g(i13, i11 - i12, false));
                        } else {
                            eVar.b((i11 - f11.f3562b) - 1, i12);
                            if ((i17 & 4) != 0) {
                                eVar.d(i12, 1, this.f3557d.c(i18, i13));
                            }
                        }
                    } else {
                        eVar.c(i12, 1);
                        i11++;
                    }
                }
                int i19 = dVar.f3551a;
                int i20 = dVar.f3552b;
                for (i10 = 0; i10 < dVar.f3553c; i10++) {
                    if ((this.f3555b[i19] & 15) == 2) {
                        eVar.d(i19, 1, this.f3557d.c(i19, i20));
                    }
                    i19++;
                    i20++;
                }
                i12 = dVar.f3551a;
                i13 = dVar.f3552b;
            }
            eVar.e();
        }
    }

    public static abstract class f<T> {
        public abstract boolean areContentsTheSame(T t10, T t11);

        public abstract boolean areItemsTheSame(T t10, T t11);

        public Object getChangePayload(T t10, T t11) {
            return null;
        }
    }

    private static class g {

        /* renamed from: a  reason: collision with root package name */
        int f3561a;

        /* renamed from: b  reason: collision with root package name */
        int f3562b;

        /* renamed from: c  reason: collision with root package name */
        boolean f3563c;

        g(int i10, int i11, boolean z10) {
            this.f3561a = i10;
            this.f3562b = i11;
            this.f3563c = z10;
        }
    }

    /* renamed from: androidx.recyclerview.widget.h$h  reason: collision with other inner class name */
    static class C0037h {

        /* renamed from: a  reason: collision with root package name */
        int f3564a;

        /* renamed from: b  reason: collision with root package name */
        int f3565b;

        /* renamed from: c  reason: collision with root package name */
        int f3566c;

        /* renamed from: d  reason: collision with root package name */
        int f3567d;

        public C0037h() {
        }

        public C0037h(int i10, int i11, int i12, int i13) {
            this.f3564a = i10;
            this.f3565b = i11;
            this.f3566c = i12;
            this.f3567d = i13;
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return this.f3567d - this.f3566c;
        }

        /* access modifiers changed from: package-private */
        public int b() {
            return this.f3565b - this.f3564a;
        }
    }

    static class i {

        /* renamed from: a  reason: collision with root package name */
        public int f3568a;

        /* renamed from: b  reason: collision with root package name */
        public int f3569b;

        /* renamed from: c  reason: collision with root package name */
        public int f3570c;

        /* renamed from: d  reason: collision with root package name */
        public int f3571d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f3572e;

        i() {
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return Math.min(this.f3570c - this.f3568a, this.f3571d - this.f3569b);
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            return this.f3571d - this.f3569b != this.f3570c - this.f3568a;
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            return this.f3571d - this.f3569b > this.f3570c - this.f3568a;
        }

        /* access modifiers changed from: package-private */
        public d d() {
            if (b()) {
                return this.f3572e ? new d(this.f3568a, this.f3569b, a()) : c() ? new d(this.f3568a, this.f3569b + 1, a()) : new d(this.f3568a + 1, this.f3569b, a());
            }
            int i10 = this.f3568a;
            return new d(i10, this.f3569b, this.f3570c - i10);
        }
    }

    private static i a(C0037h hVar, b bVar, c cVar, c cVar2, int i10) {
        int i11;
        int i12;
        int i13;
        boolean z10 = (hVar.b() - hVar.a()) % 2 == 0;
        int b10 = hVar.b() - hVar.a();
        int i14 = -i10;
        int i15 = i14;
        while (i15 <= i10) {
            if (i15 == i14 || (i15 != i10 && cVar2.b(i15 + 1) < cVar2.b(i15 - 1))) {
                i12 = cVar2.b(i15 + 1);
                i11 = i12;
            } else {
                i12 = cVar2.b(i15 - 1);
                i11 = i12 - 1;
            }
            int i16 = hVar.f3567d - ((hVar.f3565b - i11) - i15);
            int i17 = (i10 == 0 || i11 != i12) ? i16 : i16 + 1;
            while (i11 > hVar.f3564a && i16 > hVar.f3566c && bVar.b(i11 - 1, i16 - 1)) {
                i11--;
                i16--;
            }
            cVar2.c(i15, i11);
            if (!z10 || (i13 = b10 - i15) < i14 || i13 > i10 || cVar.b(i13) < i11) {
                i15 += 2;
            } else {
                i iVar = new i();
                iVar.f3568a = i11;
                iVar.f3569b = i16;
                iVar.f3570c = i12;
                iVar.f3571d = i17;
                iVar.f3572e = true;
                return iVar;
            }
        }
        return null;
    }

    public static e b(b bVar) {
        return c(bVar, true);
    }

    public static e c(b bVar, boolean z10) {
        int e10 = bVar.e();
        int d10 = bVar.d();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new C0037h(0, e10, 0, d10));
        int i10 = ((((e10 + d10) + 1) / 2) * 2) + 1;
        c cVar = new c(i10);
        c cVar2 = new c(i10);
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            C0037h hVar = (C0037h) arrayList2.remove(arrayList2.size() - 1);
            i e11 = e(hVar, bVar, cVar, cVar2);
            if (e11 != null) {
                if (e11.a() > 0) {
                    arrayList.add(e11.d());
                }
                C0037h hVar2 = arrayList3.isEmpty() ? new C0037h() : (C0037h) arrayList3.remove(arrayList3.size() - 1);
                hVar2.f3564a = hVar.f3564a;
                hVar2.f3566c = hVar.f3566c;
                hVar2.f3565b = e11.f3568a;
                hVar2.f3567d = e11.f3569b;
                arrayList2.add(hVar2);
                hVar.f3565b = hVar.f3565b;
                hVar.f3567d = hVar.f3567d;
                hVar.f3564a = e11.f3570c;
                hVar.f3566c = e11.f3571d;
                arrayList2.add(hVar);
            } else {
                arrayList3.add(hVar);
            }
        }
        Collections.sort(arrayList, f3548a);
        return new e(bVar, arrayList, cVar.a(), cVar2.a(), z10);
    }

    private static i d(C0037h hVar, b bVar, c cVar, c cVar2, int i10) {
        int i11;
        int i12;
        int i13;
        boolean z10 = true;
        if (Math.abs(hVar.b() - hVar.a()) % 2 != 1) {
            z10 = false;
        }
        int b10 = hVar.b() - hVar.a();
        int i14 = -i10;
        int i15 = i14;
        while (i15 <= i10) {
            if (i15 == i14 || (i15 != i10 && cVar.b(i15 + 1) > cVar.b(i15 - 1))) {
                i12 = cVar.b(i15 + 1);
                i11 = i12;
            } else {
                i12 = cVar.b(i15 - 1);
                i11 = i12 + 1;
            }
            int i16 = (hVar.f3566c + (i11 - hVar.f3564a)) - i15;
            int i17 = (i10 == 0 || i11 != i12) ? i16 : i16 - 1;
            while (i11 < hVar.f3565b && i16 < hVar.f3567d && bVar.b(i11, i16)) {
                i11++;
                i16++;
            }
            cVar.c(i15, i11);
            if (!z10 || (i13 = b10 - i15) < i14 + 1 || i13 > i10 - 1 || cVar2.b(i13) > i11) {
                i15 += 2;
            } else {
                i iVar = new i();
                iVar.f3568a = i12;
                iVar.f3569b = i17;
                iVar.f3570c = i11;
                iVar.f3571d = i16;
                iVar.f3572e = false;
                return iVar;
            }
        }
        return null;
    }

    private static i e(C0037h hVar, b bVar, c cVar, c cVar2) {
        if (hVar.b() >= 1 && hVar.a() >= 1) {
            int b10 = ((hVar.b() + hVar.a()) + 1) / 2;
            cVar.c(1, hVar.f3564a);
            cVar2.c(1, hVar.f3565b);
            for (int i10 = 0; i10 < b10; i10++) {
                i d10 = d(hVar, bVar, cVar, cVar2, i10);
                if (d10 != null) {
                    return d10;
                }
                i a10 = a(hVar, bVar, cVar, cVar2, i10);
                if (a10 != null) {
                    return a10;
                }
            }
        }
        return null;
    }
}
