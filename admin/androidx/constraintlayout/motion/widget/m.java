package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.c;
import f0.b;
import f0.j;
import f0.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import k0.c;
import k0.d;
import k0.e;
import k0.f;

public class m {
    private HashMap<String, f> A;
    private HashMap<String, d> B;
    private HashMap<String, c> C;
    private k[] D;
    private int E;
    private int F;
    private View G;
    private int H;
    private float I;
    private Interpolator J;
    private boolean K;

    /* renamed from: a  reason: collision with root package name */
    Rect f1604a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    View f1605b;

    /* renamed from: c  reason: collision with root package name */
    int f1606c;

    /* renamed from: d  reason: collision with root package name */
    boolean f1607d = false;

    /* renamed from: e  reason: collision with root package name */
    private int f1608e = -1;

    /* renamed from: f  reason: collision with root package name */
    private o f1609f = new o();

    /* renamed from: g  reason: collision with root package name */
    private o f1610g = new o();

    /* renamed from: h  reason: collision with root package name */
    private l f1611h = new l();

    /* renamed from: i  reason: collision with root package name */
    private l f1612i = new l();

    /* renamed from: j  reason: collision with root package name */
    private b[] f1613j;

    /* renamed from: k  reason: collision with root package name */
    private b f1614k;

    /* renamed from: l  reason: collision with root package name */
    float f1615l = Float.NaN;

    /* renamed from: m  reason: collision with root package name */
    float f1616m = 0.0f;

    /* renamed from: n  reason: collision with root package name */
    float f1617n = 1.0f;

    /* renamed from: o  reason: collision with root package name */
    float f1618o;

    /* renamed from: p  reason: collision with root package name */
    float f1619p;

    /* renamed from: q  reason: collision with root package name */
    private int[] f1620q;

    /* renamed from: r  reason: collision with root package name */
    private double[] f1621r;

    /* renamed from: s  reason: collision with root package name */
    private double[] f1622s;

    /* renamed from: t  reason: collision with root package name */
    private String[] f1623t;

    /* renamed from: u  reason: collision with root package name */
    private int[] f1624u;

    /* renamed from: v  reason: collision with root package name */
    private int f1625v = 4;

    /* renamed from: w  reason: collision with root package name */
    private float[] f1626w = new float[4];

    /* renamed from: x  reason: collision with root package name */
    private ArrayList<o> f1627x = new ArrayList<>();

    /* renamed from: y  reason: collision with root package name */
    private float[] f1628y = new float[1];

    /* renamed from: z  reason: collision with root package name */
    private ArrayList<d> f1629z = new ArrayList<>();

    class a implements Interpolator {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f0.c f1630a;

        a(f0.c cVar) {
            this.f1630a = cVar;
        }

        public float getInterpolation(float f10) {
            return (float) this.f1630a.a((double) f10);
        }
    }

    m(View view) {
        int i10 = d.f1485f;
        this.E = i10;
        this.F = i10;
        this.G = null;
        this.H = i10;
        this.I = Float.NaN;
        this.J = null;
        this.K = false;
        H(view);
    }

    private float g(float f10, float[] fArr) {
        float f11 = 0.0f;
        float f12 = 1.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f13 = this.f1617n;
            if (((double) f13) != 1.0d) {
                float f14 = this.f1616m;
                if (f10 < f14) {
                    f10 = 0.0f;
                }
                if (f10 > f14 && ((double) f10) < 1.0d) {
                    f10 = Math.min((f10 - f14) * f13, 1.0f);
                }
            }
        }
        f0.c cVar = this.f1609f.f1632a;
        float f15 = Float.NaN;
        Iterator<o> it = this.f1627x.iterator();
        while (it.hasNext()) {
            o next = it.next();
            f0.c cVar2 = next.f1632a;
            if (cVar2 != null) {
                float f16 = next.f1634c;
                if (f16 < f10) {
                    cVar = cVar2;
                    f11 = f16;
                } else if (Float.isNaN(f15)) {
                    f15 = next.f1634c;
                }
            }
        }
        if (cVar != null) {
            if (!Float.isNaN(f15)) {
                f12 = f15;
            }
            float f17 = f12 - f11;
            double d10 = (double) ((f10 - f11) / f17);
            f10 = (((float) cVar.a(d10)) * f17) + f11;
            if (fArr != null) {
                fArr[0] = (float) cVar.b(d10);
            }
        }
        return f10;
    }

    private static Interpolator p(Context context, int i10, String str, int i11) {
        if (i10 == -2) {
            return AnimationUtils.loadInterpolator(context, i11);
        }
        if (i10 == -1) {
            return new a(f0.c.c(str));
        }
        if (i10 == 0) {
            return new AccelerateDecelerateInterpolator();
        }
        if (i10 == 1) {
            return new AccelerateInterpolator();
        }
        if (i10 == 2) {
            return new DecelerateInterpolator();
        }
        if (i10 == 4) {
            return new BounceInterpolator();
        }
        if (i10 != 5) {
            return null;
        }
        return new OvershootInterpolator();
    }

    private float s() {
        char c10;
        float f10;
        float[] fArr = new float[2];
        float f11 = 1.0f / ((float) 99);
        double d10 = 0.0d;
        double d11 = 0.0d;
        float f12 = 0.0f;
        int i10 = 0;
        while (i10 < 100) {
            float f13 = ((float) i10) * f11;
            double d12 = (double) f13;
            f0.c cVar = this.f1609f.f1632a;
            Iterator<o> it = this.f1627x.iterator();
            float f14 = Float.NaN;
            float f15 = 0.0f;
            while (it.hasNext()) {
                o next = it.next();
                f0.c cVar2 = next.f1632a;
                if (cVar2 != null) {
                    float f16 = next.f1634c;
                    if (f16 < f13) {
                        cVar = cVar2;
                        f15 = f16;
                    } else if (Float.isNaN(f14)) {
                        f14 = next.f1634c;
                    }
                }
            }
            if (cVar != null) {
                if (Float.isNaN(f14)) {
                    f14 = 1.0f;
                }
                float f17 = f14 - f15;
                d12 = (double) ((((float) cVar.a((double) ((f13 - f15) / f17))) * f17) + f15);
            }
            this.f1613j[0].d(d12, this.f1621r);
            float f18 = f12;
            int i11 = i10;
            this.f1609f.i(d12, this.f1620q, this.f1621r, fArr, 0);
            if (i11 > 0) {
                c10 = 0;
                f10 = (float) (((double) f18) + Math.hypot(d11 - ((double) fArr[1]), d10 - ((double) fArr[0])));
            } else {
                c10 = 0;
                f10 = f18;
            }
            d10 = (double) fArr[c10];
            i10 = i11 + 1;
            f12 = f10;
            d11 = (double) fArr[1];
        }
        return f12;
    }

    private void w(o oVar) {
        int binarySearch = Collections.binarySearch(this.f1627x, oVar);
        if (binarySearch == 0) {
            Log.e("MotionController", " KeyPath position \"" + oVar.f1635d + "\" outside of range");
        }
        this.f1627x.add((-binarySearch) - 1, oVar);
    }

    private void y(o oVar) {
        oVar.t((float) ((int) this.f1605b.getX()), (float) ((int) this.f1605b.getY()), (float) this.f1605b.getWidth(), (float) this.f1605b.getHeight());
    }

    /* access modifiers changed from: package-private */
    public void A(Rect rect, Rect rect2, int i10, int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        if (i10 != 1) {
            if (i10 == 2) {
                i16 = rect.left + rect.right;
                i15 = rect.top;
                i17 = rect.bottom;
            } else if (i10 == 3) {
                i14 = rect.left + rect.right;
                i13 = ((rect.height() / 2) + rect.top) - (i14 / 2);
            } else if (i10 == 4) {
                i16 = rect.left + rect.right;
                i15 = rect.bottom;
                i17 = rect.top;
            } else {
                return;
            }
            rect2.left = i11 - (((i15 + i17) + rect.width()) / 2);
            rect2.top = (i16 - rect.height()) / 2;
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
        }
        i14 = rect.left + rect.right;
        i13 = ((rect.top + rect.bottom) - rect.width()) / 2;
        rect2.left = i13;
        rect2.top = i12 - ((i14 + rect.height()) / 2);
        rect2.right = rect2.left + rect.width();
        rect2.bottom = rect2.top + rect.height();
    }

    /* access modifiers changed from: package-private */
    public void B(View view) {
        o oVar = this.f1609f;
        oVar.f1634c = 0.0f;
        oVar.f1635d = 0.0f;
        this.K = true;
        oVar.t(view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
        this.f1610g.t(view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
        this.f1611h.n(view);
        this.f1612i.n(view);
    }

    /* access modifiers changed from: package-private */
    public void C(Rect rect, androidx.constraintlayout.widget.c cVar, int i10, int i11) {
        int i12 = cVar.f2003c;
        if (i12 != 0) {
            A(rect, this.f1604a, i12, i10, i11);
            rect = this.f1604a;
        }
        o oVar = this.f1610g;
        oVar.f1634c = 1.0f;
        oVar.f1635d = 1.0f;
        y(oVar);
        this.f1610g.t((float) rect.left, (float) rect.top, (float) rect.width(), (float) rect.height());
        this.f1610g.a(cVar.z(this.f1606c));
        this.f1612i.m(rect, cVar, i12, this.f1606c);
    }

    public void D(int i10) {
        this.E = i10;
    }

    /* access modifiers changed from: package-private */
    public void E(View view) {
        o oVar = this.f1609f;
        oVar.f1634c = 0.0f;
        oVar.f1635d = 0.0f;
        oVar.t(view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
        this.f1611h.n(view);
    }

    /* access modifiers changed from: package-private */
    public void F(Rect rect, androidx.constraintlayout.widget.c cVar, int i10, int i11) {
        int i12 = cVar.f2003c;
        if (i12 != 0) {
            A(rect, this.f1604a, i12, i10, i11);
        }
        o oVar = this.f1609f;
        oVar.f1634c = 0.0f;
        oVar.f1635d = 0.0f;
        y(oVar);
        this.f1609f.t((float) rect.left, (float) rect.top, (float) rect.width(), (float) rect.height());
        c.a z10 = cVar.z(this.f1606c);
        this.f1609f.a(z10);
        this.f1615l = z10.f2010d.f2077g;
        this.f1611h.m(rect, cVar, i12, this.f1606c);
        this.F = z10.f2012f.f2099i;
        c.C0017c cVar2 = z10.f2010d;
        this.H = cVar2.f2081k;
        this.I = cVar2.f2080j;
        Context context = this.f1605b.getContext();
        c.C0017c cVar3 = z10.f2010d;
        this.J = p(context, cVar3.f2083m, cVar3.f2082l, cVar3.f2084n);
    }

    public void G(e eVar, View view, int i10, int i11, int i12) {
        int i13;
        o oVar = this.f1609f;
        oVar.f1634c = 0.0f;
        oVar.f1635d = 0.0f;
        Rect rect = new Rect();
        if (i10 != 1) {
            if (i10 == 2) {
                int i14 = eVar.f15269b + eVar.f15271d;
                rect.left = i12 - (((eVar.f15270c + eVar.f15272e) + eVar.b()) / 2);
                i13 = (i14 - eVar.a()) / 2;
            }
            this.f1609f.t((float) rect.left, (float) rect.top, (float) rect.width(), (float) rect.height());
            this.f1611h.l(rect, view, i10, eVar.f15268a);
        }
        int i15 = eVar.f15269b + eVar.f15271d;
        rect.left = ((eVar.f15270c + eVar.f15272e) - eVar.b()) / 2;
        i13 = i11 - ((i15 + eVar.a()) / 2);
        rect.top = i13;
        rect.right = rect.left + eVar.b();
        rect.bottom = rect.top + eVar.a();
        this.f1609f.t((float) rect.left, (float) rect.top, (float) rect.width(), (float) rect.height());
        this.f1611h.l(rect, view, i10, eVar.f15268a);
    }

    public void H(View view) {
        this.f1605b = view;
        this.f1606c = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            ((ConstraintLayout.LayoutParams) layoutParams).a();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0157, code lost:
        r11 = (java.lang.Integer) r5.get(r8);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void I(int r18, int r19, float r20, long r21) {
        /*
            r17 = this;
            r0 = r17
            java.lang.Class<double> r1 = double.class
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            java.util.HashSet r4 = new java.util.HashSet
            r4.<init>()
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            int r6 = r0.E
            int r7 = androidx.constraintlayout.motion.widget.d.f1485f
            if (r6 == r7) goto L_0x0027
            androidx.constraintlayout.motion.widget.o r7 = r0.f1609f
            r7.f1641j = r6
        L_0x0027:
            androidx.constraintlayout.motion.widget.l r6 = r0.f1611h
            androidx.constraintlayout.motion.widget.l r7 = r0.f1612i
            r6.i(r7, r3)
            java.util.ArrayList<androidx.constraintlayout.motion.widget.d> r6 = r0.f1629z
            if (r6 == 0) goto L_0x008e
            java.util.Iterator r6 = r6.iterator()
            r8 = 0
        L_0x0037:
            boolean r9 = r6.hasNext()
            if (r9 == 0) goto L_0x008f
            java.lang.Object r9 = r6.next()
            androidx.constraintlayout.motion.widget.d r9 = (androidx.constraintlayout.motion.widget.d) r9
            boolean r10 = r9 instanceof androidx.constraintlayout.motion.widget.h
            if (r10 == 0) goto L_0x0066
            androidx.constraintlayout.motion.widget.h r9 = (androidx.constraintlayout.motion.widget.h) r9
            androidx.constraintlayout.motion.widget.o r10 = new androidx.constraintlayout.motion.widget.o
            androidx.constraintlayout.motion.widget.o r15 = r0.f1609f
            androidx.constraintlayout.motion.widget.o r14 = r0.f1610g
            r11 = r10
            r12 = r18
            r13 = r19
            r16 = r14
            r14 = r9
            r11.<init>(r12, r13, r14, r15, r16)
            r0.w(r10)
            int r9 = r9.f1545g
            int r10 = androidx.constraintlayout.motion.widget.d.f1485f
            if (r9 == r10) goto L_0x0037
            r0.f1608e = r9
            goto L_0x0037
        L_0x0066:
            boolean r10 = r9 instanceof androidx.constraintlayout.motion.widget.f
            if (r10 == 0) goto L_0x006e
            r9.d(r4)
            goto L_0x0037
        L_0x006e:
            boolean r10 = r9 instanceof androidx.constraintlayout.motion.widget.j
            if (r10 == 0) goto L_0x0076
            r9.d(r2)
            goto L_0x0037
        L_0x0076:
            boolean r10 = r9 instanceof androidx.constraintlayout.motion.widget.k
            if (r10 == 0) goto L_0x0087
            if (r8 != 0) goto L_0x0081
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
        L_0x0081:
            androidx.constraintlayout.motion.widget.k r9 = (androidx.constraintlayout.motion.widget.k) r9
            r8.add(r9)
            goto L_0x0037
        L_0x0087:
            r9.h(r5)
            r9.d(r3)
            goto L_0x0037
        L_0x008e:
            r8 = 0
        L_0x008f:
            r6 = 0
            if (r8 == 0) goto L_0x009c
            androidx.constraintlayout.motion.widget.k[] r9 = new androidx.constraintlayout.motion.widget.k[r6]
            java.lang.Object[] r8 = r8.toArray(r9)
            androidx.constraintlayout.motion.widget.k[] r8 = (androidx.constraintlayout.motion.widget.k[]) r8
            r0.D = r8
        L_0x009c:
            boolean r8 = r3.isEmpty()
            java.lang.String r9 = ","
            java.lang.String r10 = "CUSTOM,"
            r11 = 1
            if (r8 != 0) goto L_0x0173
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            r0.B = r8
            java.util.Iterator r8 = r3.iterator()
        L_0x00b2:
            boolean r12 = r8.hasNext()
            if (r12 == 0) goto L_0x010d
            java.lang.Object r12 = r8.next()
            java.lang.String r12 = (java.lang.String) r12
            boolean r13 = r12.startsWith(r10)
            if (r13 == 0) goto L_0x00fc
            android.util.SparseArray r13 = new android.util.SparseArray
            r13.<init>()
            java.lang.String[] r14 = r12.split(r9)
            r14 = r14[r11]
            java.util.ArrayList<androidx.constraintlayout.motion.widget.d> r15 = r0.f1629z
            java.util.Iterator r15 = r15.iterator()
        L_0x00d5:
            boolean r16 = r15.hasNext()
            if (r16 == 0) goto L_0x00f7
            java.lang.Object r16 = r15.next()
            r7 = r16
            androidx.constraintlayout.motion.widget.d r7 = (androidx.constraintlayout.motion.widget.d) r7
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.a> r11 = r7.f1490e
            if (r11 != 0) goto L_0x00e9
        L_0x00e7:
            r11 = 1
            goto L_0x00d5
        L_0x00e9:
            java.lang.Object r11 = r11.get(r14)
            androidx.constraintlayout.widget.a r11 = (androidx.constraintlayout.widget.a) r11
            if (r11 == 0) goto L_0x00e7
            int r7 = r7.f1486a
            r13.append(r7, r11)
            goto L_0x00e7
        L_0x00f7:
            k0.d r7 = k0.d.f(r12, r13)
            goto L_0x0100
        L_0x00fc:
            k0.d r7 = k0.d.g(r12)
        L_0x0100:
            if (r7 != 0) goto L_0x0103
            goto L_0x010b
        L_0x0103:
            r7.d(r12)
            java.util.HashMap<java.lang.String, k0.d> r11 = r0.B
            r11.put(r12, r7)
        L_0x010b:
            r11 = 1
            goto L_0x00b2
        L_0x010d:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.d> r7 = r0.f1629z
            if (r7 == 0) goto L_0x012b
            java.util.Iterator r7 = r7.iterator()
        L_0x0115:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x012b
            java.lang.Object r8 = r7.next()
            androidx.constraintlayout.motion.widget.d r8 = (androidx.constraintlayout.motion.widget.d) r8
            boolean r11 = r8 instanceof androidx.constraintlayout.motion.widget.e
            if (r11 == 0) goto L_0x0115
            java.util.HashMap<java.lang.String, k0.d> r11 = r0.B
            r8.a(r11)
            goto L_0x0115
        L_0x012b:
            androidx.constraintlayout.motion.widget.l r7 = r0.f1611h
            java.util.HashMap<java.lang.String, k0.d> r8 = r0.B
            r7.a(r8, r6)
            androidx.constraintlayout.motion.widget.l r7 = r0.f1612i
            java.util.HashMap<java.lang.String, k0.d> r8 = r0.B
            r11 = 100
            r7.a(r8, r11)
            java.util.HashMap<java.lang.String, k0.d> r7 = r0.B
            java.util.Set r7 = r7.keySet()
            java.util.Iterator r7 = r7.iterator()
        L_0x0145:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0173
            java.lang.Object r8 = r7.next()
            java.lang.String r8 = (java.lang.String) r8
            boolean r11 = r5.containsKey(r8)
            if (r11 == 0) goto L_0x0164
            java.lang.Object r11 = r5.get(r8)
            java.lang.Integer r11 = (java.lang.Integer) r11
            if (r11 == 0) goto L_0x0164
            int r11 = r11.intValue()
            goto L_0x0165
        L_0x0164:
            r11 = r6
        L_0x0165:
            java.util.HashMap<java.lang.String, k0.d> r12 = r0.B
            java.lang.Object r8 = r12.get(r8)
            f0.j r8 = (f0.j) r8
            if (r8 == 0) goto L_0x0145
            r8.e(r11)
            goto L_0x0145
        L_0x0173:
            boolean r7 = r2.isEmpty()
            if (r7 != 0) goto L_0x0241
            java.util.HashMap<java.lang.String, k0.f> r7 = r0.A
            if (r7 != 0) goto L_0x0184
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            r0.A = r7
        L_0x0184:
            java.util.Iterator r2 = r2.iterator()
        L_0x0188:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L_0x01ed
            java.lang.Object r7 = r2.next()
            java.lang.String r7 = (java.lang.String) r7
            java.util.HashMap<java.lang.String, k0.f> r8 = r0.A
            boolean r8 = r8.containsKey(r7)
            if (r8 == 0) goto L_0x019d
            goto L_0x0188
        L_0x019d:
            boolean r8 = r7.startsWith(r10)
            if (r8 == 0) goto L_0x01db
            android.util.SparseArray r8 = new android.util.SparseArray
            r8.<init>()
            java.lang.String[] r11 = r7.split(r9)
            r12 = 1
            r11 = r11[r12]
            java.util.ArrayList<androidx.constraintlayout.motion.widget.d> r12 = r0.f1629z
            java.util.Iterator r12 = r12.iterator()
        L_0x01b5:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x01d4
            java.lang.Object r13 = r12.next()
            androidx.constraintlayout.motion.widget.d r13 = (androidx.constraintlayout.motion.widget.d) r13
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.a> r14 = r13.f1490e
            if (r14 != 0) goto L_0x01c6
            goto L_0x01b5
        L_0x01c6:
            java.lang.Object r14 = r14.get(r11)
            androidx.constraintlayout.widget.a r14 = (androidx.constraintlayout.widget.a) r14
            if (r14 == 0) goto L_0x01b5
            int r13 = r13.f1486a
            r8.append(r13, r14)
            goto L_0x01b5
        L_0x01d4:
            k0.f r8 = k0.f.g(r7, r8)
            r11 = r21
            goto L_0x01e1
        L_0x01db:
            r11 = r21
            k0.f r8 = k0.f.h(r7, r11)
        L_0x01e1:
            if (r8 != 0) goto L_0x01e4
            goto L_0x0188
        L_0x01e4:
            r8.d(r7)
            java.util.HashMap<java.lang.String, k0.f> r13 = r0.A
            r13.put(r7, r8)
            goto L_0x0188
        L_0x01ed:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.d> r2 = r0.f1629z
            if (r2 == 0) goto L_0x020d
            java.util.Iterator r2 = r2.iterator()
        L_0x01f5:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L_0x020d
            java.lang.Object r7 = r2.next()
            androidx.constraintlayout.motion.widget.d r7 = (androidx.constraintlayout.motion.widget.d) r7
            boolean r8 = r7 instanceof androidx.constraintlayout.motion.widget.j
            if (r8 == 0) goto L_0x01f5
            androidx.constraintlayout.motion.widget.j r7 = (androidx.constraintlayout.motion.widget.j) r7
            java.util.HashMap<java.lang.String, k0.f> r8 = r0.A
            r7.U(r8)
            goto L_0x01f5
        L_0x020d:
            java.util.HashMap<java.lang.String, k0.f> r2 = r0.A
            java.util.Set r2 = r2.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0217:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L_0x0241
            java.lang.Object r7 = r2.next()
            java.lang.String r7 = (java.lang.String) r7
            boolean r8 = r5.containsKey(r7)
            if (r8 == 0) goto L_0x0234
            java.lang.Object r8 = r5.get(r7)
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            goto L_0x0235
        L_0x0234:
            r8 = r6
        L_0x0235:
            java.util.HashMap<java.lang.String, k0.f> r9 = r0.A
            java.lang.Object r7 = r9.get(r7)
            k0.f r7 = (k0.f) r7
            r7.e(r8)
            goto L_0x0217
        L_0x0241:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.o> r2 = r0.f1627x
            int r2 = r2.size()
            r5 = 2
            int r2 = r2 + r5
            androidx.constraintlayout.motion.widget.o[] r7 = new androidx.constraintlayout.motion.widget.o[r2]
            androidx.constraintlayout.motion.widget.o r8 = r0.f1609f
            r7[r6] = r8
            int r8 = r2 + -1
            androidx.constraintlayout.motion.widget.o r9 = r0.f1610g
            r7[r8] = r9
            java.util.ArrayList<androidx.constraintlayout.motion.widget.o> r8 = r0.f1627x
            int r8 = r8.size()
            if (r8 <= 0) goto L_0x0264
            int r8 = r0.f1608e
            r9 = -1
            if (r8 != r9) goto L_0x0264
            r0.f1608e = r6
        L_0x0264:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.o> r8 = r0.f1627x
            java.util.Iterator r8 = r8.iterator()
            r9 = 1
        L_0x026b:
            boolean r11 = r8.hasNext()
            if (r11 == 0) goto L_0x027d
            java.lang.Object r11 = r8.next()
            androidx.constraintlayout.motion.widget.o r11 = (androidx.constraintlayout.motion.widget.o) r11
            int r12 = r9 + 1
            r7[r9] = r11
            r9 = r12
            goto L_0x026b
        L_0x027d:
            r8 = 18
            java.util.HashSet r9 = new java.util.HashSet
            r9.<init>()
            androidx.constraintlayout.motion.widget.o r11 = r0.f1610g
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.a> r11 = r11.f1645n
            java.util.Set r11 = r11.keySet()
            java.util.Iterator r11 = r11.iterator()
        L_0x0290:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x02bf
            java.lang.Object r12 = r11.next()
            java.lang.String r12 = (java.lang.String) r12
            androidx.constraintlayout.motion.widget.o r13 = r0.f1609f
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.a> r13 = r13.f1645n
            boolean r13 = r13.containsKey(r12)
            if (r13 == 0) goto L_0x0290
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r10)
            r13.append(r12)
            java.lang.String r13 = r13.toString()
            boolean r13 = r3.contains(r13)
            if (r13 != 0) goto L_0x0290
            r9.add(r12)
            goto L_0x0290
        L_0x02bf:
            java.lang.String[] r3 = new java.lang.String[r6]
            java.lang.Object[] r3 = r9.toArray(r3)
            java.lang.String[] r3 = (java.lang.String[]) r3
            r0.f1623t = r3
            int r3 = r3.length
            int[] r3 = new int[r3]
            r0.f1624u = r3
            r3 = r6
        L_0x02cf:
            java.lang.String[] r9 = r0.f1623t
            int r10 = r9.length
            if (r3 >= r10) goto L_0x0305
            r9 = r9[r3]
            int[] r10 = r0.f1624u
            r10[r3] = r6
            r10 = r6
        L_0x02db:
            if (r10 >= r2) goto L_0x0302
            r11 = r7[r10]
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.a> r11 = r11.f1645n
            boolean r11 = r11.containsKey(r9)
            if (r11 == 0) goto L_0x02ff
            r11 = r7[r10]
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.a> r11 = r11.f1645n
            java.lang.Object r11 = r11.get(r9)
            androidx.constraintlayout.widget.a r11 = (androidx.constraintlayout.widget.a) r11
            if (r11 == 0) goto L_0x02ff
            int[] r9 = r0.f1624u
            r10 = r9[r3]
            int r11 = r11.h()
            int r10 = r10 + r11
            r9[r3] = r10
            goto L_0x0302
        L_0x02ff:
            int r10 = r10 + 1
            goto L_0x02db
        L_0x0302:
            int r3 = r3 + 1
            goto L_0x02cf
        L_0x0305:
            r3 = r7[r6]
            int r3 = r3.f1641j
            int r10 = androidx.constraintlayout.motion.widget.d.f1485f
            if (r3 == r10) goto L_0x030f
            r3 = 1
            goto L_0x0310
        L_0x030f:
            r3 = r6
        L_0x0310:
            int r9 = r9.length
            int r8 = r8 + r9
            boolean[] r9 = new boolean[r8]
            r10 = 1
        L_0x0315:
            if (r10 >= r2) goto L_0x0325
            r11 = r7[r10]
            int r12 = r10 + -1
            r12 = r7[r12]
            java.lang.String[] r13 = r0.f1623t
            r11.f(r12, r9, r13, r3)
            int r10 = r10 + 1
            goto L_0x0315
        L_0x0325:
            r10 = r6
            r3 = 1
        L_0x0327:
            if (r3 >= r8) goto L_0x0332
            boolean r11 = r9[r3]
            if (r11 == 0) goto L_0x032f
            int r10 = r10 + 1
        L_0x032f:
            int r3 = r3 + 1
            goto L_0x0327
        L_0x0332:
            int[] r3 = new int[r10]
            r0.f1620q = r3
            int r3 = java.lang.Math.max(r5, r10)
            double[] r10 = new double[r3]
            r0.f1621r = r10
            double[] r3 = new double[r3]
            r0.f1622s = r3
            r10 = r6
            r3 = 1
        L_0x0344:
            if (r3 >= r8) goto L_0x0354
            boolean r11 = r9[r3]
            if (r11 == 0) goto L_0x0351
            int[] r11 = r0.f1620q
            int r12 = r10 + 1
            r11[r10] = r3
            r10 = r12
        L_0x0351:
            int r3 = r3 + 1
            goto L_0x0344
        L_0x0354:
            int[] r3 = r0.f1620q
            int r3 = r3.length
            int[] r8 = new int[r5]
            r9 = 1
            r8[r9] = r3
            r8[r6] = r2
            java.lang.Object r3 = java.lang.reflect.Array.newInstance(r1, r8)
            double[][] r3 = (double[][]) r3
            double[] r8 = new double[r2]
            r9 = r6
        L_0x0367:
            if (r9 >= r2) goto L_0x037c
            r10 = r7[r9]
            r11 = r3[r9]
            int[] r12 = r0.f1620q
            r10.g(r11, r12)
            r10 = r7[r9]
            float r10 = r10.f1634c
            double r10 = (double) r10
            r8[r9] = r10
            int r9 = r9 + 1
            goto L_0x0367
        L_0x037c:
            r9 = r6
        L_0x037d:
            int[] r10 = r0.f1620q
            int r11 = r10.length
            if (r9 >= r11) goto L_0x03be
            r10 = r10[r9]
            java.lang.String[] r11 = androidx.constraintlayout.motion.widget.o.f1631r
            int r11 = r11.length
            if (r10 >= r11) goto L_0x03bb
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String[] r11 = androidx.constraintlayout.motion.widget.o.f1631r
            int[] r12 = r0.f1620q
            r12 = r12[r9]
            r11 = r11[r12]
            r10.append(r11)
            java.lang.String r11 = " ["
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r11 = r6
        L_0x03a3:
            if (r11 >= r2) goto L_0x03bb
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r10)
            r10 = r3[r11]
            r13 = r10[r9]
            r12.append(r13)
            java.lang.String r10 = r12.toString()
            int r11 = r11 + 1
            goto L_0x03a3
        L_0x03bb:
            int r9 = r9 + 1
            goto L_0x037d
        L_0x03be:
            java.lang.String[] r9 = r0.f1623t
            int r9 = r9.length
            r10 = 1
            int r9 = r9 + r10
            f0.b[] r9 = new f0.b[r9]
            r0.f1613j = r9
            r9 = r6
        L_0x03c8:
            java.lang.String[] r10 = r0.f1623t
            int r11 = r10.length
            if (r9 >= r11) goto L_0x0424
            r10 = r10[r9]
            r11 = r6
            r13 = r11
            r12 = 0
            r14 = 0
        L_0x03d3:
            if (r11 >= r2) goto L_0x040b
            r15 = r7[r11]
            boolean r15 = r15.o(r10)
            if (r15 == 0) goto L_0x0406
            if (r14 != 0) goto L_0x03f5
            double[] r12 = new double[r2]
            r14 = r7[r11]
            int r14 = r14.m(r10)
            int[] r15 = new int[r5]
            r16 = 1
            r15[r16] = r14
            r15[r6] = r2
            java.lang.Object r14 = java.lang.reflect.Array.newInstance(r1, r15)
            double[][] r14 = (double[][]) r14
        L_0x03f5:
            r15 = r7[r11]
            float r15 = r15.f1634c
            double r5 = (double) r15
            r12[r13] = r5
            r5 = r7[r11]
            r6 = r14[r13]
            r15 = 0
            r5.l(r10, r6, r15)
            int r13 = r13 + 1
        L_0x0406:
            int r11 = r11 + 1
            r5 = 2
            r6 = 0
            goto L_0x03d3
        L_0x040b:
            double[] r5 = java.util.Arrays.copyOf(r12, r13)
            java.lang.Object[] r6 = java.util.Arrays.copyOf(r14, r13)
            double[][] r6 = (double[][]) r6
            f0.b[] r10 = r0.f1613j
            int r9 = r9 + 1
            int r11 = r0.f1608e
            f0.b r5 = f0.b.a(r11, r5, r6)
            r10[r9] = r5
            r5 = 2
            r6 = 0
            goto L_0x03c8
        L_0x0424:
            f0.b[] r5 = r0.f1613j
            int r6 = r0.f1608e
            f0.b r3 = f0.b.a(r6, r8, r3)
            r6 = 0
            r5[r6] = r3
            r3 = r7[r6]
            int r3 = r3.f1641j
            int r5 = androidx.constraintlayout.motion.widget.d.f1485f
            if (r3 == r5) goto L_0x0476
            int[] r3 = new int[r2]
            double[] r5 = new double[r2]
            r8 = 2
            int[] r9 = new int[r8]
            r10 = 1
            r9[r10] = r8
            r9[r6] = r2
            java.lang.Object r1 = java.lang.reflect.Array.newInstance(r1, r9)
            double[][] r1 = (double[][]) r1
            r15 = 0
        L_0x044a:
            if (r15 >= r2) goto L_0x0470
            r6 = r7[r15]
            int r6 = r6.f1641j
            r3[r15] = r6
            r6 = r7[r15]
            float r6 = r6.f1634c
            double r8 = (double) r6
            r5[r15] = r8
            r6 = r1[r15]
            r8 = r7[r15]
            float r8 = r8.f1636e
            double r8 = (double) r8
            r10 = 0
            r6[r10] = r8
            r6 = r1[r15]
            r8 = r7[r15]
            float r8 = r8.f1637f
            double r8 = (double) r8
            r11 = 1
            r6[r11] = r8
            int r15 = r15 + 1
            goto L_0x044a
        L_0x0470:
            f0.b r1 = f0.b.b(r3, r5, r1)
            r0.f1614k = r1
        L_0x0476:
            r1 = 2143289344(0x7fc00000, float:NaN)
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r0.C = r2
            java.util.ArrayList<androidx.constraintlayout.motion.widget.d> r2 = r0.f1629z
            if (r2 == 0) goto L_0x04eb
            java.util.Iterator r2 = r4.iterator()
        L_0x0487:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x04b3
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            k0.c r4 = k0.c.i(r3)
            if (r4 != 0) goto L_0x049a
            goto L_0x0487
        L_0x049a:
            boolean r5 = r4.h()
            if (r5 == 0) goto L_0x04aa
            boolean r5 = java.lang.Float.isNaN(r1)
            if (r5 == 0) goto L_0x04aa
            float r1 = r17.s()
        L_0x04aa:
            r4.f(r3)
            java.util.HashMap<java.lang.String, k0.c> r5 = r0.C
            r5.put(r3, r4)
            goto L_0x0487
        L_0x04b3:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.d> r2 = r0.f1629z
            java.util.Iterator r2 = r2.iterator()
        L_0x04b9:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x04d1
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.motion.widget.d r3 = (androidx.constraintlayout.motion.widget.d) r3
            boolean r4 = r3 instanceof androidx.constraintlayout.motion.widget.f
            if (r4 == 0) goto L_0x04b9
            androidx.constraintlayout.motion.widget.f r3 = (androidx.constraintlayout.motion.widget.f) r3
            java.util.HashMap<java.lang.String, k0.c> r4 = r0.C
            r3.Y(r4)
            goto L_0x04b9
        L_0x04d1:
            java.util.HashMap<java.lang.String, k0.c> r2 = r0.C
            java.util.Collection r2 = r2.values()
            java.util.Iterator r2 = r2.iterator()
        L_0x04db:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x04eb
            java.lang.Object r3 = r2.next()
            k0.c r3 = (k0.c) r3
            r3.g(r1)
            goto L_0x04db
        L_0x04eb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.m.I(int, int, float, long):void");
    }

    public void J(m mVar) {
        this.f1609f.y(mVar, mVar.f1609f);
        this.f1610g.y(mVar, mVar.f1610g);
    }

    public void a(d dVar) {
        this.f1629z.add(dVar);
    }

    /* access modifiers changed from: package-private */
    public void b(ArrayList<d> arrayList) {
        this.f1629z.addAll(arrayList);
    }

    /* access modifiers changed from: package-private */
    public int c(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] h10 = this.f1613j[0].h();
        if (iArr != null) {
            Iterator<o> it = this.f1627x.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                iArr[i10] = it.next().f1646o;
                i10++;
            }
        }
        int i11 = 0;
        for (int i12 = 0; i12 < h10.length; i12++) {
            this.f1613j[0].d(h10[i12], this.f1621r);
            this.f1609f.i(h10[i12], this.f1620q, this.f1621r, fArr, i11);
            i11 += 2;
        }
        return i11 / 2;
    }

    /* access modifiers changed from: package-private */
    public void d(float[] fArr, int i10) {
        double d10;
        int i11 = i10;
        float f10 = 1.0f;
        float f11 = 1.0f / ((float) (i11 - 1));
        HashMap<String, d> hashMap = this.B;
        k0.c cVar = null;
        j jVar = hashMap == null ? null : hashMap.get("translationX");
        HashMap<String, d> hashMap2 = this.B;
        j jVar2 = hashMap2 == null ? null : hashMap2.get("translationY");
        HashMap<String, k0.c> hashMap3 = this.C;
        k0.c cVar2 = hashMap3 == null ? null : hashMap3.get("translationX");
        HashMap<String, k0.c> hashMap4 = this.C;
        if (hashMap4 != null) {
            cVar = hashMap4.get("translationY");
        }
        k0.c cVar3 = cVar;
        int i12 = 0;
        while (i12 < i11) {
            float f12 = ((float) i12) * f11;
            float f13 = this.f1617n;
            if (f13 != f10) {
                float f14 = this.f1616m;
                if (f12 < f14) {
                    f12 = 0.0f;
                }
                if (f12 > f14 && ((double) f12) < 1.0d) {
                    f12 = Math.min((f12 - f14) * f13, f10);
                }
            }
            float f15 = f12;
            double d11 = (double) f15;
            f0.c cVar4 = this.f1609f.f1632a;
            float f16 = Float.NaN;
            Iterator<o> it = this.f1627x.iterator();
            float f17 = 0.0f;
            while (it.hasNext()) {
                o next = it.next();
                f0.c cVar5 = next.f1632a;
                double d12 = d11;
                if (cVar5 != null) {
                    float f18 = next.f1634c;
                    if (f18 < f15) {
                        f17 = f18;
                        cVar4 = cVar5;
                    } else if (Float.isNaN(f16)) {
                        f16 = next.f1634c;
                    }
                }
                d11 = d12;
            }
            double d13 = d11;
            if (cVar4 != null) {
                if (Float.isNaN(f16)) {
                    f16 = 1.0f;
                }
                float f19 = f16 - f17;
                d10 = (double) ((((float) cVar4.a((double) ((f15 - f17) / f19))) * f19) + f17);
            } else {
                d10 = d13;
            }
            this.f1613j[0].d(d10, this.f1621r);
            b bVar = this.f1614k;
            if (bVar != null) {
                double[] dArr = this.f1621r;
                if (dArr.length > 0) {
                    bVar.d(d10, dArr);
                }
            }
            int i13 = i12 * 2;
            float f20 = f15;
            int i14 = i12;
            this.f1609f.i(d10, this.f1620q, this.f1621r, fArr, i13);
            if (cVar2 != null) {
                fArr[i13] = fArr[i13] + cVar2.a(f20);
            } else if (jVar != null) {
                fArr[i13] = fArr[i13] + jVar.a(f20);
            }
            if (cVar3 != null) {
                int i15 = i13 + 1;
                fArr[i15] = fArr[i15] + cVar3.a(f20);
            } else if (jVar2 != null) {
                int i16 = i13 + 1;
                fArr[i16] = fArr[i16] + jVar2.a(f20);
            }
            i12 = i14 + 1;
            f10 = 1.0f;
        }
    }

    /* access modifiers changed from: package-private */
    public void e(float f10, float[] fArr, int i10) {
        this.f1613j[0].d((double) g(f10, (float[]) null), this.f1621r);
        this.f1609f.n(this.f1620q, this.f1621r, fArr, i10);
    }

    /* access modifiers changed from: package-private */
    public void f(boolean z10) {
        if ("button".equals(a.d(this.f1605b)) && this.D != null) {
            int i10 = 0;
            while (true) {
                k[] kVarArr = this.D;
                if (i10 < kVarArr.length) {
                    kVarArr[i10].y(z10 ? -100.0f : 100.0f, this.f1605b);
                    i10++;
                } else {
                    return;
                }
            }
        }
    }

    public int h() {
        return this.f1609f.f1642k;
    }

    public void i(double d10, float[] fArr, float[] fArr2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.f1613j[0].d(d10, dArr);
        this.f1613j[0].g(d10, dArr2);
        Arrays.fill(fArr2, 0.0f);
        this.f1609f.j(d10, this.f1620q, dArr, fArr, dArr2, fArr2);
    }

    public float j() {
        return this.f1618o;
    }

    public float k() {
        return this.f1619p;
    }

    /* access modifiers changed from: package-private */
    public void l(float f10, float f11, float f12, float[] fArr) {
        double[] dArr;
        float g10 = g(f10, this.f1628y);
        b[] bVarArr = this.f1613j;
        int i10 = 0;
        if (bVarArr != null) {
            double d10 = (double) g10;
            bVarArr[0].g(d10, this.f1622s);
            this.f1613j[0].d(d10, this.f1621r);
            float f13 = this.f1628y[0];
            while (true) {
                dArr = this.f1622s;
                if (i10 >= dArr.length) {
                    break;
                }
                dArr[i10] = dArr[i10] * ((double) f13);
                i10++;
            }
            b bVar = this.f1614k;
            if (bVar != null) {
                double[] dArr2 = this.f1621r;
                if (dArr2.length > 0) {
                    bVar.d(d10, dArr2);
                    this.f1614k.g(d10, this.f1622s);
                    this.f1609f.u(f11, f12, fArr, this.f1620q, this.f1622s, this.f1621r);
                    return;
                }
                return;
            }
            this.f1609f.u(f11, f12, fArr, this.f1620q, dArr, this.f1621r);
            return;
        }
        o oVar = this.f1610g;
        float f14 = oVar.f1636e;
        o oVar2 = this.f1609f;
        float f15 = f14 - oVar2.f1636e;
        float f16 = oVar.f1637f - oVar2.f1637f;
        float f17 = (oVar.f1638g - oVar2.f1638g) + f15;
        float f18 = (oVar.f1639h - oVar2.f1639h) + f16;
        fArr[0] = (f15 * (1.0f - f11)) + (f17 * f11);
        fArr[1] = (f16 * (1.0f - f12)) + (f18 * f12);
    }

    public int m() {
        int i10 = this.f1609f.f1633b;
        Iterator<o> it = this.f1627x.iterator();
        while (it.hasNext()) {
            i10 = Math.max(i10, it.next().f1633b);
        }
        return Math.max(i10, this.f1610g.f1633b);
    }

    public float n() {
        return this.f1610g.f1636e;
    }

    public float o() {
        return this.f1610g.f1637f;
    }

    /* access modifiers changed from: package-private */
    public o q(int i10) {
        return this.f1627x.get(i10);
    }

    /* access modifiers changed from: package-private */
    public void r(float f10, int i10, int i11, float f11, float f12, float[] fArr) {
        float g10 = g(f10, this.f1628y);
        HashMap<String, d> hashMap = this.B;
        k0.c cVar = null;
        j jVar = hashMap == null ? null : hashMap.get("translationX");
        HashMap<String, d> hashMap2 = this.B;
        j jVar2 = hashMap2 == null ? null : hashMap2.get("translationY");
        HashMap<String, d> hashMap3 = this.B;
        j jVar3 = hashMap3 == null ? null : hashMap3.get("rotation");
        HashMap<String, d> hashMap4 = this.B;
        j jVar4 = hashMap4 == null ? null : hashMap4.get("scaleX");
        HashMap<String, d> hashMap5 = this.B;
        j jVar5 = hashMap5 == null ? null : hashMap5.get("scaleY");
        HashMap<String, k0.c> hashMap6 = this.C;
        k0.c cVar2 = hashMap6 == null ? null : hashMap6.get("translationX");
        HashMap<String, k0.c> hashMap7 = this.C;
        k0.c cVar3 = hashMap7 == null ? null : hashMap7.get("translationY");
        HashMap<String, k0.c> hashMap8 = this.C;
        k0.c cVar4 = hashMap8 == null ? null : hashMap8.get("rotation");
        HashMap<String, k0.c> hashMap9 = this.C;
        k0.c cVar5 = hashMap9 == null ? null : hashMap9.get("scaleX");
        HashMap<String, k0.c> hashMap10 = this.C;
        if (hashMap10 != null) {
            cVar = hashMap10.get("scaleY");
        }
        p pVar = new p();
        pVar.b();
        pVar.d(jVar3, g10);
        pVar.h(jVar, jVar2, g10);
        pVar.f(jVar4, jVar5, g10);
        pVar.c(cVar4, g10);
        pVar.g(cVar2, cVar3, g10);
        pVar.e(cVar5, cVar, g10);
        b bVar = this.f1614k;
        if (bVar != null) {
            double[] dArr = this.f1621r;
            if (dArr.length > 0) {
                double d10 = (double) g10;
                bVar.d(d10, dArr);
                this.f1614k.g(d10, this.f1622s);
                this.f1609f.u(f11, f12, fArr, this.f1620q, this.f1622s, this.f1621r);
            }
            pVar.a(f11, f12, i10, i11, fArr);
            return;
        }
        int i12 = 0;
        if (this.f1613j != null) {
            double g11 = (double) g(g10, this.f1628y);
            this.f1613j[0].g(g11, this.f1622s);
            this.f1613j[0].d(g11, this.f1621r);
            float f13 = this.f1628y[0];
            while (true) {
                double[] dArr2 = this.f1622s;
                if (i12 < dArr2.length) {
                    dArr2[i12] = dArr2[i12] * ((double) f13);
                    i12++;
                } else {
                    float f14 = f11;
                    float f15 = f12;
                    this.f1609f.u(f14, f15, fArr, this.f1620q, dArr2, this.f1621r);
                    pVar.a(f14, f15, i10, i11, fArr);
                    return;
                }
            }
        } else {
            o oVar = this.f1610g;
            float f16 = oVar.f1636e;
            o oVar2 = this.f1609f;
            float f17 = f16 - oVar2.f1636e;
            float f18 = oVar.f1637f - oVar2.f1637f;
            k0.c cVar6 = cVar5;
            float f19 = (oVar.f1639h - oVar2.f1639h) + f18;
            fArr[0] = (f17 * (1.0f - f11)) + (((oVar.f1638g - oVar2.f1638g) + f17) * f11);
            fArr[1] = (f18 * (1.0f - f12)) + (f19 * f12);
            pVar.b();
            pVar.d(jVar3, g10);
            pVar.h(jVar, jVar2, g10);
            pVar.f(jVar4, jVar5, g10);
            pVar.c(cVar4, g10);
            pVar.g(cVar2, cVar3, g10);
            pVar.e(cVar6, cVar, g10);
            pVar.a(f11, f12, i10, i11, fArr);
        }
    }

    public float t() {
        return this.f1609f.f1636e;
    }

    public String toString() {
        return " start: x: " + this.f1609f.f1636e + " y: " + this.f1609f.f1637f + " end: x: " + this.f1610g.f1636e + " y: " + this.f1610g.f1637f;
    }

    public float u() {
        return this.f1609f.f1637f;
    }

    public View v() {
        return this.f1605b;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v59, resolved type: k0.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: k0.f$d} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean x(android.view.View r21, float r22, long r23, f0.d r25) {
        /*
            r20 = this;
            r0 = r20
            r11 = r21
            r1 = 0
            r2 = r22
            float r2 = r0.g(r2, r1)
            int r3 = r0.H
            int r4 = androidx.constraintlayout.motion.widget.d.f1485f
            r13 = 1065353216(0x3f800000, float:1.0)
            if (r3 == r4) goto L_0x0042
            float r3 = (float) r3
            float r3 = r13 / r3
            float r4 = r2 / r3
            double r4 = (double) r4
            double r4 = java.lang.Math.floor(r4)
            float r4 = (float) r4
            float r4 = r4 * r3
            float r2 = r2 % r3
            float r2 = r2 / r3
            float r5 = r0.I
            boolean r5 = java.lang.Float.isNaN(r5)
            if (r5 != 0) goto L_0x002d
            float r5 = r0.I
            float r2 = r2 + r5
            float r2 = r2 % r13
        L_0x002d:
            android.view.animation.Interpolator r5 = r0.J
            if (r5 == 0) goto L_0x0036
            float r2 = r5.getInterpolation(r2)
            goto L_0x0040
        L_0x0036:
            double r5 = (double) r2
            r7 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 <= 0) goto L_0x003f
            r2 = r13
            goto L_0x0040
        L_0x003f:
            r2 = 0
        L_0x0040:
            float r2 = r2 * r3
            float r2 = r2 + r4
        L_0x0042:
            r14 = r2
            java.util.HashMap<java.lang.String, k0.d> r2 = r0.B
            if (r2 == 0) goto L_0x005f
            java.util.Collection r2 = r2.values()
            java.util.Iterator r2 = r2.iterator()
        L_0x004f:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x005f
            java.lang.Object r3 = r2.next()
            k0.d r3 = (k0.d) r3
            r3.h(r11, r14)
            goto L_0x004f
        L_0x005f:
            java.util.HashMap<java.lang.String, k0.f> r2 = r0.A
            r15 = 0
            if (r2 == 0) goto L_0x0093
            java.util.Collection r2 = r2.values()
            java.util.Iterator r7 = r2.iterator()
            r8 = r1
            r9 = r15
        L_0x006e:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x008f
            java.lang.Object r1 = r7.next()
            k0.f r1 = (k0.f) r1
            boolean r2 = r1 instanceof k0.f.d
            if (r2 == 0) goto L_0x0082
            r8 = r1
            k0.f$d r8 = (k0.f.d) r8
            goto L_0x006e
        L_0x0082:
            r2 = r21
            r3 = r14
            r4 = r23
            r6 = r25
            boolean r1 = r1.i(r2, r3, r4, r6)
            r9 = r9 | r1
            goto L_0x006e
        L_0x008f:
            r16 = r9
            r9 = r8
            goto L_0x0096
        L_0x0093:
            r9 = r1
            r16 = r15
        L_0x0096:
            f0.b[] r1 = r0.f1613j
            r10 = 1
            if (r1 == 0) goto L_0x01ec
            r1 = r1[r15]
            double r7 = (double) r14
            double[] r2 = r0.f1621r
            r1.d(r7, r2)
            f0.b[] r1 = r0.f1613j
            r1 = r1[r15]
            double[] r2 = r0.f1622s
            r1.g(r7, r2)
            f0.b r1 = r0.f1614k
            if (r1 == 0) goto L_0x00bf
            double[] r2 = r0.f1621r
            int r3 = r2.length
            if (r3 <= 0) goto L_0x00bf
            r1.d(r7, r2)
            f0.b r1 = r0.f1614k
            double[] r2 = r0.f1622s
            r1.g(r7, r2)
        L_0x00bf:
            boolean r1 = r0.K
            if (r1 != 0) goto L_0x00df
            androidx.constraintlayout.motion.widget.o r1 = r0.f1609f
            int[] r4 = r0.f1620q
            double[] r5 = r0.f1621r
            double[] r6 = r0.f1622s
            r17 = 0
            boolean r3 = r0.f1607d
            r2 = r14
            r18 = r3
            r3 = r21
            r12 = r7
            r7 = r17
            r8 = r18
            r1.v(r2, r3, r4, r5, r6, r7, r8)
            r0.f1607d = r15
            goto L_0x00e0
        L_0x00df:
            r12 = r7
        L_0x00e0:
            int r1 = r0.F
            int r2 = androidx.constraintlayout.motion.widget.d.f1485f
            if (r1 == r2) goto L_0x0142
            android.view.View r1 = r0.G
            if (r1 != 0) goto L_0x00f8
            android.view.ViewParent r1 = r21.getParent()
            android.view.View r1 = (android.view.View) r1
            int r2 = r0.F
            android.view.View r1 = r1.findViewById(r2)
            r0.G = r1
        L_0x00f8:
            android.view.View r1 = r0.G
            if (r1 == 0) goto L_0x0142
            int r1 = r1.getTop()
            android.view.View r2 = r0.G
            int r2 = r2.getBottom()
            int r1 = r1 + r2
            float r1 = (float) r1
            r2 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 / r2
            android.view.View r3 = r0.G
            int r3 = r3.getLeft()
            android.view.View r4 = r0.G
            int r4 = r4.getRight()
            int r3 = r3 + r4
            float r3 = (float) r3
            float r3 = r3 / r2
            int r2 = r21.getRight()
            int r4 = r21.getLeft()
            int r2 = r2 - r4
            if (r2 <= 0) goto L_0x0142
            int r2 = r21.getBottom()
            int r4 = r21.getTop()
            int r2 = r2 - r4
            if (r2 <= 0) goto L_0x0142
            int r2 = r21.getLeft()
            float r2 = (float) r2
            float r3 = r3 - r2
            int r2 = r21.getTop()
            float r2 = (float) r2
            float r1 = r1 - r2
            r11.setPivotX(r3)
            r11.setPivotY(r1)
        L_0x0142:
            java.util.HashMap<java.lang.String, k0.d> r1 = r0.B
            if (r1 == 0) goto L_0x0170
            java.util.Collection r1 = r1.values()
            java.util.Iterator r8 = r1.iterator()
        L_0x014e:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x0170
            java.lang.Object r1 = r8.next()
            f0.j r1 = (f0.j) r1
            boolean r2 = r1 instanceof k0.d.C0182d
            if (r2 == 0) goto L_0x014e
            double[] r2 = r0.f1622s
            int r3 = r2.length
            if (r3 <= r10) goto L_0x014e
            k0.d$d r1 = (k0.d.C0182d) r1
            r4 = r2[r15]
            r6 = r2[r10]
            r2 = r21
            r3 = r14
            r1.i(r2, r3, r4, r6)
            goto L_0x014e
        L_0x0170:
            if (r9 == 0) goto L_0x018d
            double[] r1 = r0.f1622s
            r7 = r1[r15]
            r17 = r1[r10]
            r1 = r9
            r2 = r21
            r3 = r25
            r4 = r14
            r5 = r23
            r19 = r10
            r9 = r17
            boolean r1 = r1.j(r2, r3, r4, r5, r7, r9)
            r1 = r16 | r1
            r16 = r1
            goto L_0x018f
        L_0x018d:
            r19 = r10
        L_0x018f:
            r10 = r19
        L_0x0191:
            f0.b[] r1 = r0.f1613j
            int r2 = r1.length
            if (r10 >= r2) goto L_0x01b5
            r1 = r1[r10]
            float[] r2 = r0.f1626w
            r1.e(r12, r2)
            androidx.constraintlayout.motion.widget.o r1 = r0.f1609f
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.a> r1 = r1.f1645n
            java.lang.String[] r2 = r0.f1623t
            int r3 = r10 + -1
            r2 = r2[r3]
            java.lang.Object r1 = r1.get(r2)
            androidx.constraintlayout.widget.a r1 = (androidx.constraintlayout.widget.a) r1
            float[] r2 = r0.f1626w
            k0.a.b(r1, r11, r2)
            int r10 = r10 + 1
            goto L_0x0191
        L_0x01b5:
            androidx.constraintlayout.motion.widget.l r1 = r0.f1611h
            int r2 = r1.f1587b
            if (r2 != 0) goto L_0x01da
            r2 = 0
            int r2 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r2 > 0) goto L_0x01c6
        L_0x01c0:
            int r1 = r1.f1588c
            r11.setVisibility(r1)
            goto L_0x01da
        L_0x01c6:
            r2 = 1065353216(0x3f800000, float:1.0)
            int r2 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x01cf
            androidx.constraintlayout.motion.widget.l r1 = r0.f1612i
            goto L_0x01c0
        L_0x01cf:
            androidx.constraintlayout.motion.widget.l r2 = r0.f1612i
            int r2 = r2.f1588c
            int r1 = r1.f1588c
            if (r2 == r1) goto L_0x01da
            r11.setVisibility(r15)
        L_0x01da:
            androidx.constraintlayout.motion.widget.k[] r1 = r0.D
            if (r1 == 0) goto L_0x023c
            r1 = r15
        L_0x01df:
            androidx.constraintlayout.motion.widget.k[] r2 = r0.D
            int r3 = r2.length
            if (r1 >= r3) goto L_0x023c
            r2 = r2[r1]
            r2.y(r14, r11)
            int r1 = r1 + 1
            goto L_0x01df
        L_0x01ec:
            r19 = r10
            androidx.constraintlayout.motion.widget.o r1 = r0.f1609f
            float r2 = r1.f1636e
            androidx.constraintlayout.motion.widget.o r3 = r0.f1610g
            float r4 = r3.f1636e
            float r4 = r4 - r2
            float r4 = r4 * r14
            float r2 = r2 + r4
            float r4 = r1.f1637f
            float r5 = r3.f1637f
            float r5 = r5 - r4
            float r5 = r5 * r14
            float r4 = r4 + r5
            float r5 = r1.f1638g
            float r6 = r3.f1638g
            float r7 = r6 - r5
            float r7 = r7 * r14
            float r7 = r7 + r5
            float r1 = r1.f1639h
            float r3 = r3.f1639h
            float r8 = r3 - r1
            float r8 = r8 * r14
            float r8 = r8 + r1
            r9 = 1056964608(0x3f000000, float:0.5)
            float r2 = r2 + r9
            int r10 = (int) r2
            float r4 = r4 + r9
            int r9 = (int) r4
            float r2 = r2 + r7
            int r2 = (int) r2
            float r4 = r4 + r8
            int r4 = (int) r4
            int r7 = r2 - r10
            int r8 = r4 - r9
            int r5 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r5 != 0) goto L_0x022a
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x022a
            boolean r1 = r0.f1607d
            if (r1 == 0) goto L_0x0239
        L_0x022a:
            r1 = 1073741824(0x40000000, float:2.0)
            int r3 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r1)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r1)
            r11.measure(r3, r1)
            r0.f1607d = r15
        L_0x0239:
            r11.layout(r10, r9, r2, r4)
        L_0x023c:
            java.util.HashMap<java.lang.String, k0.c> r1 = r0.C
            if (r1 == 0) goto L_0x026b
            java.util.Collection r1 = r1.values()
            java.util.Iterator r8 = r1.iterator()
        L_0x0248:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x026b
            java.lang.Object r1 = r8.next()
            k0.c r1 = (k0.c) r1
            boolean r2 = r1 instanceof k0.c.d
            if (r2 == 0) goto L_0x0267
            k0.c$d r1 = (k0.c.d) r1
            double[] r2 = r0.f1622s
            r4 = r2[r15]
            r6 = r2[r19]
            r2 = r21
            r3 = r14
            r1.k(r2, r3, r4, r6)
            goto L_0x0248
        L_0x0267:
            r1.j(r11, r14)
            goto L_0x0248
        L_0x026b:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.m.x(android.view.View, float, long, f0.d):boolean");
    }

    public void z() {
        this.f1607d = true;
    }
}
