package androidx.databinding;

import java.util.ArrayList;
import java.util.List;

public class c<C, T, A> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private List<C> f2527a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private long f2528b = 0;

    /* renamed from: c  reason: collision with root package name */
    private long[] f2529c;

    /* renamed from: d  reason: collision with root package name */
    private int f2530d;

    /* renamed from: e  reason: collision with root package name */
    private final a<C, T, A> f2531e;

    public static abstract class a<C, T, A> {
        public abstract void a(C c10, T t10, int i10, A a10);
    }

    public c(a<C, T, A> aVar) {
        this.f2531e = aVar;
    }

    private boolean e(int i10) {
        int i11;
        if (i10 < 64) {
            return ((1 << i10) & this.f2528b) != 0;
        }
        long[] jArr = this.f2529c;
        if (jArr == null || (i11 = (i10 / 64) - 1) >= jArr.length) {
            return false;
        }
        return ((1 << (i10 % 64)) & jArr[i11]) != 0;
    }

    private void i(T t10, int i10, A a10, int i11, int i12, long j10) {
        long j11 = 1;
        while (i11 < i12) {
            if ((j10 & j11) == 0) {
                this.f2531e.a(this.f2527a.get(i11), t10, i10, a10);
            }
            j11 <<= 1;
            i11++;
        }
    }

    private void j(T t10, int i10, A a10) {
        i(t10, i10, a10, 0, Math.min(64, this.f2527a.size()), this.f2528b);
    }

    private void l(T t10, int i10, A a10) {
        int size = this.f2527a.size();
        long[] jArr = this.f2529c;
        int length = jArr == null ? -1 : jArr.length - 1;
        m(t10, i10, a10, length);
        i(t10, i10, a10, (length + 2) * 64, size, 0);
    }

    private void m(T t10, int i10, A a10, int i11) {
        if (i11 < 0) {
            j(t10, i10, a10);
            return;
        }
        long j10 = this.f2529c[i11];
        int i12 = (i11 + 1) * 64;
        int min = Math.min(this.f2527a.size(), i12 + 64);
        m(t10, i10, a10, i11 - 1);
        i(t10, i10, a10, i12, min, j10);
    }

    private void o(int i10, long j10) {
        long j11 = Long.MIN_VALUE;
        for (int i11 = (i10 + 64) - 1; i11 >= i10; i11--) {
            if ((j10 & j11) != 0) {
                this.f2527a.remove(i11);
            }
            j11 >>>= 1;
        }
    }

    private void p(int i10) {
        if (i10 < 64) {
            this.f2528b = (1 << i10) | this.f2528b;
            return;
        }
        int i11 = (i10 / 64) - 1;
        long[] jArr = this.f2529c;
        if (jArr == null) {
            this.f2529c = new long[(this.f2527a.size() / 64)];
        } else if (jArr.length <= i11) {
            long[] jArr2 = new long[(this.f2527a.size() / 64)];
            long[] jArr3 = this.f2529c;
            System.arraycopy(jArr3, 0, jArr2, 0, jArr3.length);
            this.f2529c = jArr2;
        }
        long j10 = 1 << (i10 % 64);
        long[] jArr4 = this.f2529c;
        jArr4[i11] = j10 | jArr4[i11];
    }

    public synchronized void a(C c10) {
        if (c10 != null) {
            int lastIndexOf = this.f2527a.lastIndexOf(c10);
            if (lastIndexOf < 0 || e(lastIndexOf)) {
                this.f2527a.add(c10);
            }
        } else {
            throw new IllegalArgumentException("callback cannot be null");
        }
    }

    /* renamed from: b */
    public synchronized c<C, T, A> clone() {
        c<C, T, A> cVar;
        CloneNotSupportedException e10;
        try {
            cVar = (c) super.clone();
            try {
                cVar.f2528b = 0;
                cVar.f2529c = null;
                cVar.f2530d = 0;
                cVar.f2527a = new ArrayList();
                int size = this.f2527a.size();
                for (int i10 = 0; i10 < size; i10++) {
                    if (!e(i10)) {
                        cVar.f2527a.add(this.f2527a.get(i10));
                    }
                }
            } catch (CloneNotSupportedException e11) {
                e10 = e11;
                e10.printStackTrace();
                return cVar;
            }
        } catch (CloneNotSupportedException e12) {
            CloneNotSupportedException cloneNotSupportedException = e12;
            cVar = null;
            e10 = cloneNotSupportedException;
            e10.printStackTrace();
            return cVar;
        }
        return cVar;
    }

    public synchronized void g(T t10, int i10, A a10) {
        this.f2530d++;
        l(t10, i10, a10);
        int i11 = this.f2530d - 1;
        this.f2530d = i11;
        if (i11 == 0) {
            long[] jArr = this.f2529c;
            if (jArr != null) {
                for (int length = jArr.length - 1; length >= 0; length--) {
                    long j10 = this.f2529c[length];
                    if (j10 != 0) {
                        o((length + 1) * 64, j10);
                        this.f2529c[length] = 0;
                    }
                }
            }
            long j11 = this.f2528b;
            if (j11 != 0) {
                o(0, j11);
                this.f2528b = 0;
            }
        }
    }

    public synchronized void n(C c10) {
        if (this.f2530d == 0) {
            this.f2527a.remove(c10);
        } else {
            int lastIndexOf = this.f2527a.lastIndexOf(c10);
            if (lastIndexOf >= 0) {
                p(lastIndexOf);
            }
        }
    }
}
