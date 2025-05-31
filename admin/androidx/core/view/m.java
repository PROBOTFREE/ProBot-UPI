package androidx.core.view;

import android.view.View;
import android.view.ViewParent;

public class m {

    /* renamed from: a  reason: collision with root package name */
    private ViewParent f2383a;

    /* renamed from: b  reason: collision with root package name */
    private ViewParent f2384b;

    /* renamed from: c  reason: collision with root package name */
    private final View f2385c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2386d;

    /* renamed from: e  reason: collision with root package name */
    private int[] f2387e;

    public m(View view) {
        this.f2385c = view;
    }

    private boolean g(int i10, int i11, int i12, int i13, int[] iArr, int i14, int[] iArr2) {
        ViewParent h10;
        int i15;
        int i16;
        int[] iArr3;
        int[] iArr4 = iArr;
        if (!l() || (h10 = h(i14)) == null) {
            return false;
        }
        if (i10 == 0 && i11 == 0 && i12 == 0 && i13 == 0) {
            if (iArr4 != null) {
                iArr4[0] = 0;
                iArr4[1] = 0;
            }
            return false;
        }
        if (iArr4 != null) {
            this.f2385c.getLocationInWindow(iArr4);
            i16 = iArr4[0];
            i15 = iArr4[1];
        } else {
            i16 = 0;
            i15 = 0;
        }
        if (iArr2 == null) {
            int[] i17 = i();
            i17[0] = 0;
            i17[1] = 0;
            iArr3 = i17;
        } else {
            iArr3 = iArr2;
        }
        a0.d(h10, this.f2385c, i10, i11, i12, i13, i14, iArr3);
        if (iArr4 != null) {
            this.f2385c.getLocationInWindow(iArr4);
            iArr4[0] = iArr4[0] - i16;
            iArr4[1] = iArr4[1] - i15;
        }
        return true;
    }

    private ViewParent h(int i10) {
        if (i10 == 0) {
            return this.f2383a;
        }
        if (i10 != 1) {
            return null;
        }
        return this.f2384b;
    }

    private int[] i() {
        if (this.f2387e == null) {
            this.f2387e = new int[2];
        }
        return this.f2387e;
    }

    private void n(int i10, ViewParent viewParent) {
        if (i10 == 0) {
            this.f2383a = viewParent;
        } else if (i10 == 1) {
            this.f2384b = viewParent;
        }
    }

    public boolean a(float f10, float f11, boolean z10) {
        ViewParent h10;
        if (!l() || (h10 = h(0)) == null) {
            return false;
        }
        return a0.a(h10, this.f2385c, f10, f11, z10);
    }

    public boolean b(float f10, float f11) {
        ViewParent h10;
        if (!l() || (h10 = h(0)) == null) {
            return false;
        }
        return a0.b(h10, this.f2385c, f10, f11);
    }

    public boolean c(int i10, int i11, int[] iArr, int[] iArr2) {
        return d(i10, i11, iArr, iArr2, 0);
    }

    public boolean d(int i10, int i11, int[] iArr, int[] iArr2, int i12) {
        ViewParent h10;
        int i13;
        int i14;
        if (!l() || (h10 = h(i12)) == null) {
            return false;
        }
        if (i10 != 0 || i11 != 0) {
            if (iArr2 != null) {
                this.f2385c.getLocationInWindow(iArr2);
                i14 = iArr2[0];
                i13 = iArr2[1];
            } else {
                i14 = 0;
                i13 = 0;
            }
            if (iArr == null) {
                iArr = i();
            }
            iArr[0] = 0;
            iArr[1] = 0;
            a0.c(h10, this.f2385c, i10, i11, iArr, i12);
            if (iArr2 != null) {
                this.f2385c.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i14;
                iArr2[1] = iArr2[1] - i13;
            }
            return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
        } else if (iArr2 == null) {
            return false;
        } else {
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
    }

    public void e(int i10, int i11, int i12, int i13, int[] iArr, int i14, int[] iArr2) {
        g(i10, i11, i12, i13, iArr, i14, iArr2);
    }

    public boolean f(int i10, int i11, int i12, int i13, int[] iArr) {
        return g(i10, i11, i12, i13, iArr, 0, (int[]) null);
    }

    public boolean j() {
        return k(0);
    }

    public boolean k(int i10) {
        return h(i10) != null;
    }

    public boolean l() {
        return this.f2386d;
    }

    public void m(boolean z10) {
        if (this.f2386d) {
            x.P0(this.f2385c);
        }
        this.f2386d = z10;
    }

    public boolean o(int i10) {
        return p(i10, 0);
    }

    public boolean p(int i10, int i11) {
        if (k(i11)) {
            return true;
        }
        if (!l()) {
            return false;
        }
        View view = this.f2385c;
        for (ViewParent parent = this.f2385c.getParent(); parent != null; parent = parent.getParent()) {
            if (a0.f(parent, view, this.f2385c, i10, i11)) {
                n(i11, parent);
                a0.e(parent, view, this.f2385c, i10, i11);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public void q() {
        r(0);
    }

    public void r(int i10) {
        ViewParent h10 = h(i10);
        if (h10 != null) {
            a0.g(h10, this.f2385c, i10);
            n(i10, (ViewParent) null);
        }
    }
}
