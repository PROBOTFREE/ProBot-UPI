package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import androidx.constraintlayout.widget.a;
import androidx.constraintlayout.widget.c;
import java.util.HashSet;
import java.util.LinkedHashMap;

class l implements Comparable<l> {

    /* renamed from: a  reason: collision with root package name */
    private float f1586a = 1.0f;

    /* renamed from: b  reason: collision with root package name */
    int f1587b = 0;

    /* renamed from: c  reason: collision with root package name */
    int f1588c;

    /* renamed from: d  reason: collision with root package name */
    private float f1589d = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    private float f1590e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    private float f1591f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    public float f1592g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    private float f1593h = 1.0f;

    /* renamed from: i  reason: collision with root package name */
    private float f1594i = 1.0f;

    /* renamed from: j  reason: collision with root package name */
    private float f1595j = Float.NaN;

    /* renamed from: k  reason: collision with root package name */
    private float f1596k = Float.NaN;

    /* renamed from: l  reason: collision with root package name */
    private float f1597l = 0.0f;

    /* renamed from: m  reason: collision with root package name */
    private float f1598m = 0.0f;

    /* renamed from: n  reason: collision with root package name */
    private float f1599n = 0.0f;

    /* renamed from: o  reason: collision with root package name */
    private float f1600o;

    /* renamed from: p  reason: collision with root package name */
    private float f1601p = Float.NaN;

    /* renamed from: q  reason: collision with root package name */
    private float f1602q = Float.NaN;

    /* renamed from: r  reason: collision with root package name */
    LinkedHashMap<String, a> f1603r = new LinkedHashMap<>();

    private boolean g(float f10, float f11) {
        return (Float.isNaN(f10) || Float.isNaN(f11)) ? Float.isNaN(f10) != Float.isNaN(f11) : Math.abs(f10 - f11) > 1.0E-6f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:0x014b, code lost:
        r2.c(r9, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0167, code lost:
        r2.c(r9, r6);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.util.HashMap<java.lang.String, k0.d> r8, int r9) {
        /*
            r7 = this;
            java.util.Set r0 = r8.keySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0008:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x01f2
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r8.get(r1)
            k0.d r2 = (k0.d) r2
            r1.hashCode()
            r3 = -1
            int r4 = r1.hashCode()
            r5 = 1
            switch(r4) {
                case -1249320806: goto L_0x00c9;
                case -1249320805: goto L_0x00be;
                case -1225497657: goto L_0x00b3;
                case -1225497656: goto L_0x00a8;
                case -1225497655: goto L_0x009d;
                case -1001078227: goto L_0x0092;
                case -908189618: goto L_0x0087;
                case -908189617: goto L_0x007c;
                case -760884510: goto L_0x006e;
                case -760884509: goto L_0x0060;
                case -40300674: goto L_0x0052;
                case -4379043: goto L_0x0044;
                case 37232917: goto L_0x0036;
                case 92909918: goto L_0x0028;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x00d3
        L_0x0028:
            java.lang.String r4 = "alpha"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0032
            goto L_0x00d3
        L_0x0032:
            r3 = 13
            goto L_0x00d3
        L_0x0036:
            java.lang.String r4 = "transitionPathRotate"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0040
            goto L_0x00d3
        L_0x0040:
            r3 = 12
            goto L_0x00d3
        L_0x0044:
            java.lang.String r4 = "elevation"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x004e
            goto L_0x00d3
        L_0x004e:
            r3 = 11
            goto L_0x00d3
        L_0x0052:
            java.lang.String r4 = "rotation"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x005c
            goto L_0x00d3
        L_0x005c:
            r3 = 10
            goto L_0x00d3
        L_0x0060:
            java.lang.String r4 = "transformPivotY"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x006a
            goto L_0x00d3
        L_0x006a:
            r3 = 9
            goto L_0x00d3
        L_0x006e:
            java.lang.String r4 = "transformPivotX"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0078
            goto L_0x00d3
        L_0x0078:
            r3 = 8
            goto L_0x00d3
        L_0x007c:
            java.lang.String r4 = "scaleY"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0085
            goto L_0x00d3
        L_0x0085:
            r3 = 7
            goto L_0x00d3
        L_0x0087:
            java.lang.String r4 = "scaleX"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0090
            goto L_0x00d3
        L_0x0090:
            r3 = 6
            goto L_0x00d3
        L_0x0092:
            java.lang.String r4 = "progress"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x009b
            goto L_0x00d3
        L_0x009b:
            r3 = 5
            goto L_0x00d3
        L_0x009d:
            java.lang.String r4 = "translationZ"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x00a6
            goto L_0x00d3
        L_0x00a6:
            r3 = 4
            goto L_0x00d3
        L_0x00a8:
            java.lang.String r4 = "translationY"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x00b1
            goto L_0x00d3
        L_0x00b1:
            r3 = 3
            goto L_0x00d3
        L_0x00b3:
            java.lang.String r4 = "translationX"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x00bc
            goto L_0x00d3
        L_0x00bc:
            r3 = 2
            goto L_0x00d3
        L_0x00be:
            java.lang.String r4 = "rotationY"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x00c7
            goto L_0x00d3
        L_0x00c7:
            r3 = r5
            goto L_0x00d3
        L_0x00c9:
            java.lang.String r4 = "rotationX"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x00d2
            goto L_0x00d3
        L_0x00d2:
            r3 = 0
        L_0x00d3:
            r4 = 1065353216(0x3f800000, float:1.0)
            r6 = 0
            switch(r3) {
                case 0: goto L_0x01e4;
                case 1: goto L_0x01d8;
                case 2: goto L_0x01cc;
                case 3: goto L_0x01c0;
                case 4: goto L_0x01b4;
                case 5: goto L_0x01a8;
                case 6: goto L_0x019c;
                case 7: goto L_0x0190;
                case 8: goto L_0x0184;
                case 9: goto L_0x0178;
                case 10: goto L_0x016c;
                case 11: goto L_0x015c;
                case 12: goto L_0x0150;
                case 13: goto L_0x0140;
                default: goto L_0x00d9;
            }
        L_0x00d9:
            java.lang.String r3 = "CUSTOM"
            boolean r3 = r1.startsWith(r3)
            java.lang.String r4 = "MotionPaths"
            if (r3 == 0) goto L_0x012e
            java.lang.String r3 = ","
            java.lang.String[] r3 = r1.split(r3)
            r3 = r3[r5]
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.a> r5 = r7.f1603r
            boolean r5 = r5.containsKey(r3)
            if (r5 == 0) goto L_0x0008
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.a> r5 = r7.f1603r
            java.lang.Object r3 = r5.get(r3)
            androidx.constraintlayout.widget.a r3 = (androidx.constraintlayout.widget.a) r3
            boolean r5 = r2 instanceof k0.d.b
            if (r5 == 0) goto L_0x0106
            k0.d$b r2 = (k0.d.b) r2
            r2.i(r9, r3)
            goto L_0x0008
        L_0x0106:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r1)
            java.lang.String r1 = " ViewSpline not a CustomSet frame = "
            r5.append(r1)
            r5.append(r9)
            java.lang.String r1 = ", value"
            r5.append(r1)
            float r1 = r3.e()
            r5.append(r1)
            r5.append(r2)
            java.lang.String r1 = r5.toString()
        L_0x0129:
            android.util.Log.e(r4, r1)
            goto L_0x0008
        L_0x012e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "UNKNOWN spline "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            goto L_0x0129
        L_0x0140:
            float r1 = r7.f1586a
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x0149
            goto L_0x014b
        L_0x0149:
            float r4 = r7.f1586a
        L_0x014b:
            r2.c(r9, r4)
            goto L_0x0008
        L_0x0150:
            float r1 = r7.f1601p
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x0159
            goto L_0x0167
        L_0x0159:
            float r6 = r7.f1601p
            goto L_0x0167
        L_0x015c:
            float r1 = r7.f1589d
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x0165
            goto L_0x0167
        L_0x0165:
            float r6 = r7.f1589d
        L_0x0167:
            r2.c(r9, r6)
            goto L_0x0008
        L_0x016c:
            float r1 = r7.f1590e
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x0175
            goto L_0x0167
        L_0x0175:
            float r6 = r7.f1590e
            goto L_0x0167
        L_0x0178:
            float r1 = r7.f1596k
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x0181
            goto L_0x0167
        L_0x0181:
            float r6 = r7.f1596k
            goto L_0x0167
        L_0x0184:
            float r1 = r7.f1595j
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x018d
            goto L_0x0167
        L_0x018d:
            float r6 = r7.f1595j
            goto L_0x0167
        L_0x0190:
            float r1 = r7.f1594i
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x0199
            goto L_0x014b
        L_0x0199:
            float r4 = r7.f1594i
            goto L_0x014b
        L_0x019c:
            float r1 = r7.f1593h
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x01a5
            goto L_0x014b
        L_0x01a5:
            float r4 = r7.f1593h
            goto L_0x014b
        L_0x01a8:
            float r1 = r7.f1602q
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x01b1
            goto L_0x0167
        L_0x01b1:
            float r6 = r7.f1602q
            goto L_0x0167
        L_0x01b4:
            float r1 = r7.f1599n
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x01bd
            goto L_0x0167
        L_0x01bd:
            float r6 = r7.f1599n
            goto L_0x0167
        L_0x01c0:
            float r1 = r7.f1598m
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x01c9
            goto L_0x0167
        L_0x01c9:
            float r6 = r7.f1598m
            goto L_0x0167
        L_0x01cc:
            float r1 = r7.f1597l
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x01d5
            goto L_0x0167
        L_0x01d5:
            float r6 = r7.f1597l
            goto L_0x0167
        L_0x01d8:
            float r1 = r7.f1592g
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x01e1
            goto L_0x0167
        L_0x01e1:
            float r6 = r7.f1592g
            goto L_0x0167
        L_0x01e4:
            float r1 = r7.f1591f
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x01ee
            goto L_0x0167
        L_0x01ee:
            float r6 = r7.f1591f
            goto L_0x0167
        L_0x01f2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.l.a(java.util.HashMap, int):void");
    }

    public void b(View view) {
        this.f1588c = view.getVisibility();
        this.f1586a = view.getVisibility() != 0 ? 0.0f : view.getAlpha();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 21) {
            this.f1589d = view.getElevation();
        }
        this.f1590e = view.getRotation();
        this.f1591f = view.getRotationX();
        this.f1592g = view.getRotationY();
        this.f1593h = view.getScaleX();
        this.f1594i = view.getScaleY();
        this.f1595j = view.getPivotX();
        this.f1596k = view.getPivotY();
        this.f1597l = view.getTranslationX();
        this.f1598m = view.getTranslationY();
        if (i10 >= 21) {
            this.f1599n = view.getTranslationZ();
        }
    }

    public void e(c.a aVar) {
        c.d dVar = aVar.f2009c;
        int i10 = dVar.f2087c;
        this.f1587b = i10;
        int i11 = dVar.f2086b;
        this.f1588c = i11;
        this.f1586a = (i11 == 0 || i10 != 0) ? dVar.f2088d : 0.0f;
        c.e eVar = aVar.f2012f;
        boolean z10 = eVar.f2103m;
        this.f1589d = eVar.f2104n;
        this.f1590e = eVar.f2092b;
        this.f1591f = eVar.f2093c;
        this.f1592g = eVar.f2094d;
        this.f1593h = eVar.f2095e;
        this.f1594i = eVar.f2096f;
        this.f1595j = eVar.f2097g;
        this.f1596k = eVar.f2098h;
        this.f1597l = eVar.f2100j;
        this.f1598m = eVar.f2101k;
        this.f1599n = eVar.f2102l;
        f0.c.c(aVar.f2010d.f2074d);
        c.C0017c cVar = aVar.f2010d;
        this.f1601p = cVar.f2079i;
        int i12 = cVar.f2076f;
        int i13 = cVar.f2072b;
        this.f1602q = aVar.f2009c.f2089e;
        for (String next : aVar.f2013g.keySet()) {
            a aVar2 = aVar.f2013g.get(next);
            if (aVar2.g()) {
                this.f1603r.put(next, aVar2);
            }
        }
    }

    /* renamed from: f */
    public int compareTo(l lVar) {
        return Float.compare(this.f1600o, lVar.f1600o);
    }

    /* access modifiers changed from: package-private */
    public void i(l lVar, HashSet<String> hashSet) {
        if (g(this.f1586a, lVar.f1586a)) {
            hashSet.add("alpha");
        }
        if (g(this.f1589d, lVar.f1589d)) {
            hashSet.add("elevation");
        }
        int i10 = this.f1588c;
        int i11 = lVar.f1588c;
        if (i10 != i11 && this.f1587b == 0 && (i10 == 0 || i11 == 0)) {
            hashSet.add("alpha");
        }
        if (g(this.f1590e, lVar.f1590e)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f1601p) || !Float.isNaN(lVar.f1601p)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f1602q) || !Float.isNaN(lVar.f1602q)) {
            hashSet.add("progress");
        }
        if (g(this.f1591f, lVar.f1591f)) {
            hashSet.add("rotationX");
        }
        if (g(this.f1592g, lVar.f1592g)) {
            hashSet.add("rotationY");
        }
        if (g(this.f1595j, lVar.f1595j)) {
            hashSet.add("transformPivotX");
        }
        if (g(this.f1596k, lVar.f1596k)) {
            hashSet.add("transformPivotY");
        }
        if (g(this.f1593h, lVar.f1593h)) {
            hashSet.add("scaleX");
        }
        if (g(this.f1594i, lVar.f1594i)) {
            hashSet.add("scaleY");
        }
        if (g(this.f1597l, lVar.f1597l)) {
            hashSet.add("translationX");
        }
        if (g(this.f1598m, lVar.f1598m)) {
            hashSet.add("translationY");
        }
        if (g(this.f1599n, lVar.f1599n)) {
            hashSet.add("translationZ");
        }
    }

    /* access modifiers changed from: package-private */
    public void j(float f10, float f11, float f12, float f13) {
    }

    public void l(Rect rect, View view, int i10, float f10) {
        float f11;
        j((float) rect.left, (float) rect.top, (float) rect.width(), (float) rect.height());
        b(view);
        this.f1595j = Float.NaN;
        this.f1596k = Float.NaN;
        if (i10 == 1) {
            f11 = f10 - 90.0f;
        } else if (i10 == 2) {
            f11 = f10 + 90.0f;
        } else {
            return;
        }
        this.f1590e = f11;
    }

    public void m(Rect rect, c cVar, int i10, int i11) {
        float f10;
        j((float) rect.left, (float) rect.top, (float) rect.width(), (float) rect.height());
        e(cVar.z(i11));
        float f11 = 90.0f;
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 4) {
                        return;
                    }
                }
            }
            f10 = this.f1590e + 90.0f;
            this.f1590e = f10;
            if (f10 > 180.0f) {
                f11 = 360.0f;
                this.f1590e = f10 - f11;
            }
            return;
        }
        f10 = this.f1590e;
        this.f1590e = f10 - f11;
    }

    public void n(View view) {
        j(view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
        b(view);
    }
}
