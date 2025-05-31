package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.constraintlayout.widget.a;
import androidx.constraintlayout.widget.c;
import f0.c;
import java.util.Arrays;
import java.util.LinkedHashMap;

class o implements Comparable<o> {

    /* renamed from: r  reason: collision with root package name */
    static String[] f1631r = {"position", "x", "y", "width", "height", "pathRotate"};

    /* renamed from: a  reason: collision with root package name */
    c f1632a;

    /* renamed from: b  reason: collision with root package name */
    int f1633b = 0;

    /* renamed from: c  reason: collision with root package name */
    float f1634c;

    /* renamed from: d  reason: collision with root package name */
    float f1635d;

    /* renamed from: e  reason: collision with root package name */
    float f1636e;

    /* renamed from: f  reason: collision with root package name */
    float f1637f;

    /* renamed from: g  reason: collision with root package name */
    float f1638g;

    /* renamed from: h  reason: collision with root package name */
    float f1639h;

    /* renamed from: i  reason: collision with root package name */
    float f1640i = Float.NaN;

    /* renamed from: j  reason: collision with root package name */
    int f1641j;

    /* renamed from: k  reason: collision with root package name */
    int f1642k;

    /* renamed from: l  reason: collision with root package name */
    float f1643l;

    /* renamed from: m  reason: collision with root package name */
    m f1644m;

    /* renamed from: n  reason: collision with root package name */
    LinkedHashMap<String, a> f1645n;

    /* renamed from: o  reason: collision with root package name */
    int f1646o;

    /* renamed from: p  reason: collision with root package name */
    double[] f1647p;

    /* renamed from: q  reason: collision with root package name */
    double[] f1648q;

    public o() {
        int i10 = d.f1485f;
        this.f1641j = i10;
        this.f1642k = i10;
        this.f1643l = Float.NaN;
        this.f1644m = null;
        this.f1645n = new LinkedHashMap<>();
        this.f1646o = 0;
        this.f1647p = new double[18];
        this.f1648q = new double[18];
    }

    public o(int i10, int i11, h hVar, o oVar, o oVar2) {
        int i12 = d.f1485f;
        this.f1641j = i12;
        this.f1642k = i12;
        this.f1643l = Float.NaN;
        this.f1644m = null;
        this.f1645n = new LinkedHashMap<>();
        this.f1646o = 0;
        this.f1647p = new double[18];
        this.f1648q = new double[18];
        if (oVar.f1642k != d.f1485f) {
            r(i10, i11, hVar, oVar, oVar2);
            return;
        }
        int i13 = hVar.f1541q;
        if (i13 == 1) {
            q(hVar, oVar, oVar2);
        } else if (i13 != 2) {
            p(hVar, oVar, oVar2);
        } else {
            s(i10, i11, hVar, oVar, oVar2);
        }
    }

    private boolean e(float f10, float f11) {
        return (Float.isNaN(f10) || Float.isNaN(f11)) ? Float.isNaN(f10) != Float.isNaN(f11) : Math.abs(f10 - f11) > 1.0E-6f;
    }

    public void a(c.a aVar) {
        this.f1632a = f0.c.c(aVar.f2010d.f2074d);
        c.C0017c cVar = aVar.f2010d;
        this.f1641j = cVar.f2075e;
        this.f1642k = cVar.f2072b;
        this.f1640i = cVar.f2079i;
        this.f1633b = cVar.f2076f;
        int i10 = cVar.f2073c;
        float f10 = aVar.f2009c.f2089e;
        this.f1643l = aVar.f2011e.C;
        for (String next : aVar.f2013g.keySet()) {
            a aVar2 = aVar.f2013g.get(next);
            if (aVar2 != null && aVar2.g()) {
                this.f1645n.put(next, aVar2);
            }
        }
    }

    /* renamed from: b */
    public int compareTo(o oVar) {
        return Float.compare(this.f1635d, oVar.f1635d);
    }

    /* access modifiers changed from: package-private */
    public void f(o oVar, boolean[] zArr, String[] strArr, boolean z10) {
        boolean e10 = e(this.f1636e, oVar.f1636e);
        boolean e11 = e(this.f1637f, oVar.f1637f);
        zArr[0] = zArr[0] | e(this.f1635d, oVar.f1635d);
        boolean z11 = e10 | e11 | z10;
        zArr[1] = zArr[1] | z11;
        zArr[2] = z11 | zArr[2];
        zArr[3] = zArr[3] | e(this.f1638g, oVar.f1638g);
        zArr[4] = e(this.f1639h, oVar.f1639h) | zArr[4];
    }

    /* access modifiers changed from: package-private */
    public void g(double[] dArr, int[] iArr) {
        float[] fArr = {this.f1635d, this.f1636e, this.f1637f, this.f1638g, this.f1639h, this.f1640i};
        int i10 = 0;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            if (iArr[i11] < 6) {
                dArr[i10] = (double) fArr[iArr[i11]];
                i10++;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void i(double d10, int[] iArr, double[] dArr, float[] fArr, int i10) {
        int[] iArr2 = iArr;
        float f10 = this.f1636e;
        float f11 = this.f1637f;
        float f12 = this.f1638g;
        float f13 = this.f1639h;
        for (int i11 = 0; i11 < iArr2.length; i11++) {
            float f14 = (float) dArr[i11];
            int i12 = iArr2[i11];
            if (i12 == 1) {
                f10 = f14;
            } else if (i12 == 2) {
                f11 = f14;
            } else if (i12 == 3) {
                f12 = f14;
            } else if (i12 == 4) {
                f13 = f14;
            }
        }
        m mVar = this.f1644m;
        if (mVar != null) {
            float[] fArr2 = new float[2];
            mVar.i(d10, fArr2, new float[2]);
            float f15 = fArr2[0];
            float f16 = fArr2[1];
            double d11 = (double) f15;
            double d12 = (double) f10;
            double d13 = (double) f11;
            f10 = (float) ((d11 + (Math.sin(d13) * d12)) - ((double) (f12 / 2.0f)));
            f11 = (float) ((((double) f16) - (d12 * Math.cos(d13))) - ((double) (f13 / 2.0f)));
        }
        fArr[i10] = f10 + (f12 / 2.0f) + 0.0f;
        fArr[i10 + 1] = f11 + (f13 / 2.0f) + 0.0f;
    }

    /* access modifiers changed from: package-private */
    public void j(double d10, int[] iArr, double[] dArr, float[] fArr, double[] dArr2, float[] fArr2) {
        float f10;
        int[] iArr2 = iArr;
        float f11 = this.f1636e;
        float f12 = this.f1637f;
        float f13 = this.f1638g;
        float f14 = this.f1639h;
        float f15 = 0.0f;
        float f16 = 0.0f;
        float f17 = 0.0f;
        float f18 = 0.0f;
        for (int i10 = 0; i10 < iArr2.length; i10++) {
            float f19 = (float) dArr[i10];
            float f20 = (float) dArr2[i10];
            int i11 = iArr2[i10];
            if (i11 == 1) {
                f11 = f19;
                f15 = f20;
            } else if (i11 == 2) {
                f12 = f19;
                f17 = f20;
            } else if (i11 == 3) {
                f13 = f19;
                f16 = f20;
            } else if (i11 == 4) {
                f14 = f19;
                f18 = f20;
            }
        }
        float f21 = 2.0f;
        float f22 = (f16 / 2.0f) + f15;
        float f23 = (f18 / 2.0f) + f17;
        m mVar = this.f1644m;
        if (mVar != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            mVar.i(d10, fArr3, fArr4);
            float f24 = fArr3[0];
            float f25 = fArr3[1];
            float f26 = fArr4[0];
            double d11 = (double) f11;
            float f27 = fArr4[1];
            double d12 = (double) f12;
            f10 = f13;
            double d13 = (double) f15;
            double d14 = (double) f17;
            float sin = (float) (((double) f26) + (Math.sin(d12) * d13) + (Math.cos(d12) * d14));
            f23 = (float) ((((double) f27) - (d13 * Math.cos(d12))) + (Math.sin(d12) * d14));
            f22 = sin;
            f11 = (float) ((((double) f24) + (Math.sin(d12) * d11)) - ((double) (f13 / 2.0f)));
            f12 = (float) ((((double) f25) - (d11 * Math.cos(d12))) - ((double) (f14 / 2.0f)));
            f21 = 2.0f;
        } else {
            f10 = f13;
        }
        fArr[0] = f11 + (f10 / f21) + 0.0f;
        fArr[1] = f12 + (f14 / f21) + 0.0f;
        fArr2[0] = f22;
        fArr2[1] = f23;
    }

    /* access modifiers changed from: package-private */
    public int l(String str, double[] dArr, int i10) {
        a aVar = this.f1645n.get(str);
        int i11 = 0;
        if (aVar == null) {
            return 0;
        }
        if (aVar.h() == 1) {
            dArr[i10] = (double) aVar.e();
            return 1;
        }
        int h10 = aVar.h();
        float[] fArr = new float[h10];
        aVar.f(fArr);
        while (i11 < h10) {
            dArr[i10] = (double) fArr[i11];
            i11++;
            i10++;
        }
        return h10;
    }

    /* access modifiers changed from: package-private */
    public int m(String str) {
        a aVar = this.f1645n.get(str);
        if (aVar == null) {
            return 0;
        }
        return aVar.h();
    }

    /* access modifiers changed from: package-private */
    public void n(int[] iArr, double[] dArr, float[] fArr, int i10) {
        float f10 = this.f1636e;
        float f11 = this.f1637f;
        float f12 = this.f1638g;
        float f13 = this.f1639h;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            float f14 = (float) dArr[i11];
            int i12 = iArr[i11];
            if (i12 == 1) {
                f10 = f14;
            } else if (i12 == 2) {
                f11 = f14;
            } else if (i12 == 3) {
                f12 = f14;
            } else if (i12 == 4) {
                f13 = f14;
            }
        }
        m mVar = this.f1644m;
        if (mVar != null) {
            float j10 = mVar.j();
            double d10 = (double) f10;
            double d11 = (double) f11;
            f11 = (float) ((((double) this.f1644m.k()) - (d10 * Math.cos(d11))) - ((double) (f13 / 2.0f)));
            f10 = (float) ((((double) j10) + (Math.sin(d11) * d10)) - ((double) (f12 / 2.0f)));
        }
        float f15 = f12 + f10;
        float f16 = f13 + f11;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        int i13 = i10 + 1;
        fArr[i10] = f10 + 0.0f;
        int i14 = i13 + 1;
        fArr[i13] = f11 + 0.0f;
        int i15 = i14 + 1;
        fArr[i14] = f15 + 0.0f;
        int i16 = i15 + 1;
        fArr[i15] = f11 + 0.0f;
        int i17 = i16 + 1;
        fArr[i16] = f15 + 0.0f;
        int i18 = i17 + 1;
        fArr[i17] = f16 + 0.0f;
        fArr[i18] = f10 + 0.0f;
        fArr[i18 + 1] = f16 + 0.0f;
    }

    /* access modifiers changed from: package-private */
    public boolean o(String str) {
        return this.f1645n.containsKey(str);
    }

    /* access modifiers changed from: package-private */
    public void p(h hVar, o oVar, o oVar2) {
        h hVar2 = hVar;
        o oVar3 = oVar;
        o oVar4 = oVar2;
        float f10 = ((float) hVar2.f1486a) / 100.0f;
        this.f1634c = f10;
        this.f1633b = hVar2.f1534j;
        float f11 = Float.isNaN(hVar2.f1535k) ? f10 : hVar2.f1535k;
        float f12 = Float.isNaN(hVar2.f1536l) ? f10 : hVar2.f1536l;
        float f13 = oVar4.f1638g;
        float f14 = oVar3.f1638g;
        float f15 = oVar4.f1639h;
        float f16 = oVar3.f1639h;
        this.f1635d = this.f1634c;
        float f17 = oVar3.f1636e;
        float f18 = oVar3.f1637f;
        float f19 = (oVar4.f1636e + (f13 / 2.0f)) - ((f14 / 2.0f) + f17);
        float f20 = (oVar4.f1637f + (f15 / 2.0f)) - (f18 + (f16 / 2.0f));
        float f21 = (f13 - f14) * f11;
        float f22 = f21 / 2.0f;
        this.f1636e = (float) ((int) ((f17 + (f19 * f10)) - f22));
        float f23 = (f15 - f16) * f12;
        float f24 = f23 / 2.0f;
        this.f1637f = (float) ((int) ((f18 + (f20 * f10)) - f24));
        this.f1638g = (float) ((int) (f14 + f21));
        this.f1639h = (float) ((int) (f16 + f23));
        h hVar3 = hVar;
        float f25 = Float.isNaN(hVar3.f1537m) ? f10 : hVar3.f1537m;
        float f26 = 0.0f;
        float f27 = Float.isNaN(hVar3.f1540p) ? 0.0f : hVar3.f1540p;
        if (!Float.isNaN(hVar3.f1538n)) {
            f10 = hVar3.f1538n;
        }
        if (!Float.isNaN(hVar3.f1539o)) {
            f26 = hVar3.f1539o;
        }
        this.f1646o = 0;
        o oVar5 = oVar;
        this.f1636e = (float) ((int) (((oVar5.f1636e + (f25 * f19)) + (f26 * f20)) - f22));
        this.f1637f = (float) ((int) (((oVar5.f1637f + (f19 * f27)) + (f20 * f10)) - f24));
        this.f1632a = f0.c.c(hVar3.f1532h);
        this.f1641j = hVar3.f1533i;
    }

    /* access modifiers changed from: package-private */
    public void q(h hVar, o oVar, o oVar2) {
        h hVar2 = hVar;
        o oVar3 = oVar;
        o oVar4 = oVar2;
        float f10 = ((float) hVar2.f1486a) / 100.0f;
        this.f1634c = f10;
        this.f1633b = hVar2.f1534j;
        float f11 = Float.isNaN(hVar2.f1535k) ? f10 : hVar2.f1535k;
        float f12 = Float.isNaN(hVar2.f1536l) ? f10 : hVar2.f1536l;
        float f13 = oVar4.f1638g - oVar3.f1638g;
        float f14 = oVar4.f1639h - oVar3.f1639h;
        this.f1635d = this.f1634c;
        if (!Float.isNaN(hVar2.f1537m)) {
            f10 = hVar2.f1537m;
        }
        float f15 = oVar3.f1636e;
        float f16 = oVar3.f1638g;
        float f17 = oVar3.f1637f;
        float f18 = oVar3.f1639h;
        float f19 = (oVar4.f1636e + (oVar4.f1638g / 2.0f)) - ((f16 / 2.0f) + f15);
        float f20 = (oVar4.f1637f + (oVar4.f1639h / 2.0f)) - ((f18 / 2.0f) + f17);
        float f21 = f19 * f10;
        float f22 = f13 * f11;
        float f23 = f22 / 2.0f;
        this.f1636e = (float) ((int) ((f15 + f21) - f23));
        float f24 = f10 * f20;
        float f25 = f14 * f12;
        float f26 = f25 / 2.0f;
        this.f1637f = (float) ((int) ((f17 + f24) - f26));
        this.f1638g = (float) ((int) (f16 + f22));
        this.f1639h = (float) ((int) (f18 + f25));
        h hVar3 = hVar;
        float f27 = Float.isNaN(hVar3.f1538n) ? 0.0f : hVar3.f1538n;
        float f28 = (-f20) * f27;
        float f29 = f19 * f27;
        this.f1646o = 1;
        o oVar5 = oVar;
        float f30 = (float) ((int) ((oVar5.f1636e + f21) - f23));
        this.f1636e = f30;
        float f31 = (float) ((int) ((oVar5.f1637f + f24) - f26));
        this.f1637f = f31;
        this.f1636e = f30 + f28;
        this.f1637f = f31 + f29;
        this.f1642k = this.f1642k;
        this.f1632a = f0.c.c(hVar3.f1532h);
        this.f1641j = hVar3.f1533i;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0065, code lost:
        if (java.lang.Float.isNaN(r9.f1538n) != false) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b4, code lost:
        if (java.lang.Float.isNaN(r9.f1538n) != false) goto L_0x006a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void r(int r7, int r8, androidx.constraintlayout.motion.widget.h r9, androidx.constraintlayout.motion.widget.o r10, androidx.constraintlayout.motion.widget.o r11) {
        /*
            r6 = this;
            int r7 = r9.f1486a
            float r7 = (float) r7
            r8 = 1120403456(0x42c80000, float:100.0)
            float r7 = r7 / r8
            r6.f1634c = r7
            int r8 = r9.f1534j
            r6.f1633b = r8
            int r8 = r9.f1541q
            r6.f1646o = r8
            float r8 = r9.f1535k
            boolean r8 = java.lang.Float.isNaN(r8)
            if (r8 == 0) goto L_0x001a
            r8 = r7
            goto L_0x001c
        L_0x001a:
            float r8 = r9.f1535k
        L_0x001c:
            float r0 = r9.f1536l
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 == 0) goto L_0x0026
            r0 = r7
            goto L_0x0028
        L_0x0026:
            float r0 = r9.f1536l
        L_0x0028:
            float r1 = r11.f1638g
            float r2 = r10.f1638g
            float r1 = r1 - r2
            float r3 = r11.f1639h
            float r4 = r10.f1639h
            float r3 = r3 - r4
            float r5 = r6.f1634c
            r6.f1635d = r5
            float r1 = r1 * r8
            float r2 = r2 + r1
            int r1 = (int) r2
            float r1 = (float) r1
            r6.f1638g = r1
            float r3 = r3 * r0
            float r4 = r4 + r3
            int r1 = (int) r4
            float r1 = (float) r1
            r6.f1639h = r1
            int r1 = r9.f1541q
            r2 = 1
            if (r1 == r2) goto L_0x0099
            r2 = 2
            if (r1 == r2) goto L_0x0074
            float r8 = r9.f1537m
            boolean r8 = java.lang.Float.isNaN(r8)
            if (r8 == 0) goto L_0x0054
            r8 = r7
            goto L_0x0056
        L_0x0054:
            float r8 = r9.f1537m
        L_0x0056:
            float r0 = r11.f1636e
            float r1 = r10.f1636e
            float r0 = r0 - r1
            float r8 = r8 * r0
            float r8 = r8 + r1
            r6.f1636e = r8
            float r8 = r9.f1538n
            boolean r8 = java.lang.Float.isNaN(r8)
            if (r8 == 0) goto L_0x0068
            goto L_0x006a
        L_0x0068:
            float r7 = r9.f1538n
        L_0x006a:
            float r8 = r11.f1637f
            float r11 = r10.f1637f
            float r8 = r8 - r11
            float r7 = r7 * r8
            float r7 = r7 + r11
        L_0x0071:
            r6.f1637f = r7
            goto L_0x00b7
        L_0x0074:
            float r1 = r9.f1537m
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x0084
            float r8 = r11.f1636e
            float r0 = r10.f1636e
            float r8 = r8 - r0
            float r8 = r8 * r7
            float r8 = r8 + r0
            goto L_0x008b
        L_0x0084:
            float r1 = r9.f1537m
            float r8 = java.lang.Math.min(r0, r8)
            float r8 = r8 * r1
        L_0x008b:
            r6.f1636e = r8
            float r8 = r9.f1538n
            boolean r8 = java.lang.Float.isNaN(r8)
            if (r8 == 0) goto L_0x0096
            goto L_0x006a
        L_0x0096:
            float r7 = r9.f1538n
            goto L_0x0071
        L_0x0099:
            float r8 = r9.f1537m
            boolean r8 = java.lang.Float.isNaN(r8)
            if (r8 == 0) goto L_0x00a3
            r8 = r7
            goto L_0x00a5
        L_0x00a3:
            float r8 = r9.f1537m
        L_0x00a5:
            float r0 = r11.f1636e
            float r1 = r10.f1636e
            float r0 = r0 - r1
            float r8 = r8 * r0
            float r8 = r8 + r1
            r6.f1636e = r8
            float r8 = r9.f1538n
            boolean r8 = java.lang.Float.isNaN(r8)
            if (r8 == 0) goto L_0x0068
            goto L_0x006a
        L_0x00b7:
            int r7 = r10.f1642k
            r6.f1642k = r7
            java.lang.String r7 = r9.f1532h
            f0.c r7 = f0.c.c(r7)
            r6.f1632a = r7
            int r7 = r9.f1533i
            r6.f1641j = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.o.r(int, int, androidx.constraintlayout.motion.widget.h, androidx.constraintlayout.motion.widget.o, androidx.constraintlayout.motion.widget.o):void");
    }

    /* access modifiers changed from: package-private */
    public void s(int i10, int i11, h hVar, o oVar, o oVar2) {
        h hVar2 = hVar;
        o oVar3 = oVar;
        o oVar4 = oVar2;
        float f10 = ((float) hVar2.f1486a) / 100.0f;
        this.f1634c = f10;
        this.f1633b = hVar2.f1534j;
        float f11 = Float.isNaN(hVar2.f1535k) ? f10 : hVar2.f1535k;
        float f12 = Float.isNaN(hVar2.f1536l) ? f10 : hVar2.f1536l;
        float f13 = oVar4.f1638g;
        float f14 = oVar3.f1638g;
        float f15 = oVar4.f1639h;
        float f16 = oVar3.f1639h;
        this.f1635d = this.f1634c;
        float f17 = oVar3.f1636e;
        float f18 = oVar3.f1637f;
        float f19 = oVar4.f1636e + (f13 / 2.0f);
        float f20 = oVar4.f1637f + (f15 / 2.0f);
        float f21 = (f13 - f14) * f11;
        this.f1636e = (float) ((int) ((f17 + ((f19 - ((f14 / 2.0f) + f17)) * f10)) - (f21 / 2.0f)));
        float f22 = (f15 - f16) * f12;
        this.f1637f = (float) ((int) ((f18 + ((f20 - (f18 + (f16 / 2.0f))) * f10)) - (f22 / 2.0f)));
        this.f1638g = (float) ((int) (f14 + f21));
        this.f1639h = (float) ((int) (f16 + f22));
        this.f1646o = 2;
        h hVar3 = hVar;
        if (!Float.isNaN(hVar3.f1537m)) {
            this.f1636e = (float) ((int) (hVar3.f1537m * ((float) ((int) (((float) i10) - this.f1638g)))));
        }
        if (!Float.isNaN(hVar3.f1538n)) {
            this.f1637f = (float) ((int) (hVar3.f1538n * ((float) ((int) (((float) i11) - this.f1639h)))));
        }
        this.f1642k = this.f1642k;
        this.f1632a = f0.c.c(hVar3.f1532h);
        this.f1641j = hVar3.f1533i;
    }

    /* access modifiers changed from: package-private */
    public void t(float f10, float f11, float f12, float f13) {
        this.f1636e = f10;
        this.f1637f = f11;
        this.f1638g = f12;
        this.f1639h = f13;
    }

    /* access modifiers changed from: package-private */
    public void u(float f10, float f11, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        int[] iArr2 = iArr;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        for (int i10 = 0; i10 < iArr2.length; i10++) {
            float f16 = (float) dArr[i10];
            double d10 = dArr2[i10];
            int i11 = iArr2[i10];
            if (i11 == 1) {
                f12 = f16;
            } else if (i11 == 2) {
                f14 = f16;
            } else if (i11 == 3) {
                f13 = f16;
            } else if (i11 == 4) {
                f15 = f16;
            }
        }
        float f17 = f12 - ((0.0f * f13) / 2.0f);
        float f18 = f14 - ((0.0f * f15) / 2.0f);
        fArr[0] = (f17 * (1.0f - f10)) + (((f13 * 1.0f) + f17) * f10) + 0.0f;
        fArr[1] = (f18 * (1.0f - f11)) + (((f15 * 1.0f) + f18) * f11) + 0.0f;
    }

    /* access modifiers changed from: package-private */
    public void v(float f10, View view, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3, boolean z10) {
        float f11;
        boolean z11;
        boolean z12;
        float f12;
        View view2 = view;
        int[] iArr2 = iArr;
        double[] dArr4 = dArr2;
        float f13 = this.f1636e;
        float f14 = this.f1637f;
        float f15 = this.f1638g;
        float f16 = this.f1639h;
        if (iArr2.length != 0 && this.f1647p.length <= iArr2[iArr2.length - 1]) {
            int i10 = iArr2[iArr2.length - 1] + 1;
            this.f1647p = new double[i10];
            this.f1648q = new double[i10];
        }
        Arrays.fill(this.f1647p, Double.NaN);
        for (int i11 = 0; i11 < iArr2.length; i11++) {
            this.f1647p[iArr2[i11]] = dArr[i11];
            this.f1648q[iArr2[i11]] = dArr4[i11];
        }
        float f17 = Float.NaN;
        int i12 = 0;
        float f18 = 0.0f;
        float f19 = 0.0f;
        float f20 = 0.0f;
        float f21 = 0.0f;
        while (true) {
            double[] dArr5 = this.f1647p;
            if (i12 >= dArr5.length) {
                break;
            }
            double d10 = 0.0d;
            if (!Double.isNaN(dArr5[i12]) || !(dArr3 == null || dArr3[i12] == 0.0d)) {
                if (dArr3 != null) {
                    d10 = dArr3[i12];
                }
                if (!Double.isNaN(this.f1647p[i12])) {
                    d10 = this.f1647p[i12] + d10;
                }
                f12 = f17;
                float f22 = (float) d10;
                float f23 = (float) this.f1648q[i12];
                if (i12 == 1) {
                    f17 = f12;
                    f18 = f23;
                    f13 = f22;
                } else if (i12 == 2) {
                    f17 = f12;
                    f19 = f23;
                    f14 = f22;
                } else if (i12 == 3) {
                    f17 = f12;
                    f20 = f23;
                    f15 = f22;
                } else if (i12 == 4) {
                    f17 = f12;
                    f21 = f23;
                    f16 = f22;
                } else if (i12 == 5) {
                    f17 = f22;
                }
                i12++;
                double[] dArr6 = dArr2;
            } else {
                f12 = f17;
            }
            f17 = f12;
            i12++;
            double[] dArr62 = dArr2;
        }
        float f24 = f17;
        m mVar = this.f1644m;
        if (mVar != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            mVar.i((double) f10, fArr, fArr2);
            float f25 = fArr[0];
            float f26 = fArr[1];
            float f27 = fArr2[0];
            float f28 = fArr2[1];
            double d11 = (double) f13;
            double d12 = (double) f14;
            double sin = ((double) f25) + (Math.sin(d12) * d11);
            f11 = f16;
            float f29 = (float) (sin - ((double) (f15 / 2.0f)));
            float cos = (float) ((((double) f26) - (Math.cos(d12) * d11)) - ((double) (f16 / 2.0f)));
            double d13 = (double) f18;
            double d14 = (double) f19;
            float sin2 = (float) (((double) f27) + (Math.sin(d12) * d13) + (Math.cos(d12) * d11 * d14));
            float f30 = f29;
            float cos2 = (float) ((((double) f28) - (d13 * Math.cos(d12))) + (d11 * Math.sin(d12) * d14));
            double[] dArr7 = dArr2;
            if (dArr7.length >= 2) {
                z12 = false;
                dArr7[0] = (double) sin2;
                z11 = true;
                dArr7[1] = (double) cos2;
            } else {
                z12 = false;
                z11 = true;
            }
            if (!Float.isNaN(f24)) {
                view2.setRotation((float) (((double) f24) + Math.toDegrees(Math.atan2((double) cos2, (double) sin2))));
            }
            f13 = f30;
            f14 = cos;
        } else {
            float f31 = f24;
            f11 = f16;
            z12 = false;
            z11 = true;
            if (!Float.isNaN(f31)) {
                view2.setRotation((float) (((double) 0.0f) + ((double) f31) + Math.toDegrees(Math.atan2((double) (f19 + (f21 / 2.0f)), (double) (f18 + (f20 / 2.0f))))));
            }
        }
        if (view2 instanceof c) {
            ((c) view2).a(f13, f14, f15 + f13, f14 + f11);
            return;
        }
        float f32 = f13 + 0.5f;
        int i13 = (int) f32;
        float f33 = f14 + 0.5f;
        int i14 = (int) f33;
        int i15 = (int) (f32 + f15);
        int i16 = (int) (f33 + f11);
        int i17 = i15 - i13;
        int i18 = i16 - i14;
        if (!(i17 == view.getMeasuredWidth() && i18 == view.getMeasuredHeight())) {
            z12 = z11;
        }
        if (z12 || z10) {
            view2.measure(View.MeasureSpec.makeMeasureSpec(i17, 1073741824), View.MeasureSpec.makeMeasureSpec(i18, 1073741824));
        }
        view2.layout(i13, i14, i15, i16);
    }

    public void y(m mVar, o oVar) {
        double d10 = (double) (((this.f1636e + (this.f1638g / 2.0f)) - oVar.f1636e) - (oVar.f1638g / 2.0f));
        double d11 = (double) (((this.f1637f + (this.f1639h / 2.0f)) - oVar.f1637f) - (oVar.f1639h / 2.0f));
        this.f1644m = mVar;
        this.f1636e = (float) Math.hypot(d11, d10);
        this.f1637f = (float) (Float.isNaN(this.f1643l) ? Math.atan2(d11, d10) + 1.5707963267948966d : Math.toRadians((double) this.f1643l));
    }
}
