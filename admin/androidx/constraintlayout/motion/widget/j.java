package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.f;
import java.util.HashMap;
import java.util.HashSet;
import k0.d;

public class j extends d {
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f1546g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f1547h = -1;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public float f1548i = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public float f1549j = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public float f1550k = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public float f1551l = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public float f1552m = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public float f1553n = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public float f1554o = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public float f1555p = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public float f1556q = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public float f1557r = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public float f1558s = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public float f1559t = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public int f1560u = 0;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public String f1561v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public float f1562w = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public float f1563x = 0.0f;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static SparseIntArray f1564a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1564a = sparseIntArray;
            sparseIntArray.append(f.KeyTimeCycle_android_alpha, 1);
            f1564a.append(f.KeyTimeCycle_android_elevation, 2);
            f1564a.append(f.KeyTimeCycle_android_rotation, 4);
            f1564a.append(f.KeyTimeCycle_android_rotationX, 5);
            f1564a.append(f.KeyTimeCycle_android_rotationY, 6);
            f1564a.append(f.KeyTimeCycle_android_scaleX, 7);
            f1564a.append(f.KeyTimeCycle_transitionPathRotate, 8);
            f1564a.append(f.KeyTimeCycle_transitionEasing, 9);
            f1564a.append(f.KeyTimeCycle_motionTarget, 10);
            f1564a.append(f.KeyTimeCycle_framePosition, 12);
            f1564a.append(f.KeyTimeCycle_curveFit, 13);
            f1564a.append(f.KeyTimeCycle_android_scaleY, 14);
            f1564a.append(f.KeyTimeCycle_android_translationX, 15);
            f1564a.append(f.KeyTimeCycle_android_translationY, 16);
            f1564a.append(f.KeyTimeCycle_android_translationZ, 17);
            f1564a.append(f.KeyTimeCycle_motionProgress, 18);
            f1564a.append(f.KeyTimeCycle_wavePeriod, 20);
            f1564a.append(f.KeyTimeCycle_waveOffset, 21);
            f1564a.append(f.KeyTimeCycle_waveShape, 19);
        }

        public static void a(j jVar, TypedArray typedArray) {
            int i10;
            int indexCount = typedArray.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArray.getIndex(i11);
                switch (f1564a.get(index)) {
                    case 1:
                        float unused = jVar.f1548i = typedArray.getFloat(index, jVar.f1548i);
                        break;
                    case 2:
                        float unused2 = jVar.f1549j = typedArray.getDimension(index, jVar.f1549j);
                        break;
                    case 4:
                        float unused3 = jVar.f1550k = typedArray.getFloat(index, jVar.f1550k);
                        break;
                    case 5:
                        float unused4 = jVar.f1551l = typedArray.getFloat(index, jVar.f1551l);
                        break;
                    case 6:
                        float unused5 = jVar.f1552m = typedArray.getFloat(index, jVar.f1552m);
                        break;
                    case 7:
                        float unused6 = jVar.f1554o = typedArray.getFloat(index, jVar.f1554o);
                        break;
                    case 8:
                        float unused7 = jVar.f1553n = typedArray.getFloat(index, jVar.f1553n);
                        break;
                    case 9:
                        String unused8 = jVar.f1546g = typedArray.getString(index);
                        break;
                    case 10:
                        if (!MotionLayout.O1) {
                            if (typedArray.peekValue(index).type != 3) {
                                jVar.f1487b = typedArray.getResourceId(index, jVar.f1487b);
                                break;
                            }
                        } else {
                            int resourceId = typedArray.getResourceId(index, jVar.f1487b);
                            jVar.f1487b = resourceId;
                            if (resourceId != -1) {
                                break;
                            }
                        }
                        jVar.f1488c = typedArray.getString(index);
                        break;
                    case 12:
                        jVar.f1486a = typedArray.getInt(index, jVar.f1486a);
                        break;
                    case 13:
                        int unused9 = jVar.f1547h = typedArray.getInteger(index, jVar.f1547h);
                        break;
                    case 14:
                        float unused10 = jVar.f1555p = typedArray.getFloat(index, jVar.f1555p);
                        break;
                    case 15:
                        float unused11 = jVar.f1556q = typedArray.getDimension(index, jVar.f1556q);
                        break;
                    case 16:
                        float unused12 = jVar.f1557r = typedArray.getDimension(index, jVar.f1557r);
                        break;
                    case 17:
                        if (Build.VERSION.SDK_INT < 21) {
                            break;
                        } else {
                            float unused13 = jVar.f1558s = typedArray.getDimension(index, jVar.f1558s);
                            break;
                        }
                    case 18:
                        float unused14 = jVar.f1559t = typedArray.getFloat(index, jVar.f1559t);
                        break;
                    case 19:
                        if (typedArray.peekValue(index).type == 3) {
                            String unused15 = jVar.f1561v = typedArray.getString(index);
                            i10 = 7;
                        } else {
                            i10 = typedArray.getInt(index, jVar.f1560u);
                        }
                        int unused16 = jVar.f1560u = i10;
                        break;
                    case 20:
                        float unused17 = jVar.f1562w = typedArray.getFloat(index, jVar.f1562w);
                        break;
                    case 21:
                        float unused18 = jVar.f1563x = typedArray.peekValue(index).type == 5 ? typedArray.getDimension(index, jVar.f1563x) : typedArray.getFloat(index, jVar.f1563x);
                        break;
                    default:
                        Log.e("KeyTimeCycle", "unused attribute 0x" + Integer.toHexString(index) + "   " + f1564a.get(index));
                        break;
                }
            }
        }
    }

    public j() {
        this.f1489d = 3;
        this.f1490e = new HashMap<>();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0089, code lost:
        if (r1.equals("scaleY") == false) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0105, code lost:
        r3.b(r4, r5, r10.f1562w, r10.f1560u, r10.f1563x);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void U(java.util.HashMap<java.lang.String, k0.f> r11) {
        /*
            r10 = this;
            java.util.Set r0 = r11.keySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0008:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x01a1
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r11.get(r1)
            r3 = r2
            k0.f r3 = (k0.f) r3
            if (r3 != 0) goto L_0x001e
            goto L_0x0008
        L_0x001e:
            java.lang.String r2 = "CUSTOM"
            boolean r2 = r1.startsWith(r2)
            r4 = 7
            if (r2 == 0) goto L_0x0045
            java.lang.String r1 = r1.substring(r4)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.a> r2 = r10.f1490e
            java.lang.Object r1 = r2.get(r1)
            r6 = r1
            androidx.constraintlayout.widget.a r6 = (androidx.constraintlayout.widget.a) r6
            if (r6 == 0) goto L_0x0008
            r4 = r3
            k0.f$b r4 = (k0.f.b) r4
            int r5 = r10.f1486a
            float r7 = r10.f1562w
            int r8 = r10.f1560u
            float r9 = r10.f1563x
            r4.j(r5, r6, r7, r8, r9)
            goto L_0x0008
        L_0x0045:
            r2 = -1
            int r5 = r1.hashCode()
            switch(r5) {
                case -1249320806: goto L_0x00ce;
                case -1249320805: goto L_0x00c3;
                case -1225497657: goto L_0x00b8;
                case -1225497656: goto L_0x00ad;
                case -1225497655: goto L_0x00a2;
                case -1001078227: goto L_0x0097;
                case -908189618: goto L_0x008c;
                case -908189617: goto L_0x0083;
                case -40300674: goto L_0x0077;
                case -4379043: goto L_0x006a;
                case 37232917: goto L_0x005d;
                case 92909918: goto L_0x0050;
                default: goto L_0x004d;
            }
        L_0x004d:
            r4 = r2
            goto L_0x00d9
        L_0x0050:
            java.lang.String r4 = "alpha"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0059
            goto L_0x004d
        L_0x0059:
            r4 = 11
            goto L_0x00d9
        L_0x005d:
            java.lang.String r4 = "transitionPathRotate"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0066
            goto L_0x004d
        L_0x0066:
            r4 = 10
            goto L_0x00d9
        L_0x006a:
            java.lang.String r4 = "elevation"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0073
            goto L_0x004d
        L_0x0073:
            r4 = 9
            goto L_0x00d9
        L_0x0077:
            java.lang.String r4 = "rotation"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0080
            goto L_0x004d
        L_0x0080:
            r4 = 8
            goto L_0x00d9
        L_0x0083:
            java.lang.String r5 = "scaleY"
            boolean r5 = r1.equals(r5)
            if (r5 != 0) goto L_0x00d9
            goto L_0x004d
        L_0x008c:
            java.lang.String r4 = "scaleX"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0095
            goto L_0x004d
        L_0x0095:
            r4 = 6
            goto L_0x00d9
        L_0x0097:
            java.lang.String r4 = "progress"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x00a0
            goto L_0x004d
        L_0x00a0:
            r4 = 5
            goto L_0x00d9
        L_0x00a2:
            java.lang.String r4 = "translationZ"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x00ab
            goto L_0x004d
        L_0x00ab:
            r4 = 4
            goto L_0x00d9
        L_0x00ad:
            java.lang.String r4 = "translationY"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x00b6
            goto L_0x004d
        L_0x00b6:
            r4 = 3
            goto L_0x00d9
        L_0x00b8:
            java.lang.String r4 = "translationX"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x00c1
            goto L_0x004d
        L_0x00c1:
            r4 = 2
            goto L_0x00d9
        L_0x00c3:
            java.lang.String r4 = "rotationY"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x00cc
            goto L_0x004d
        L_0x00cc:
            r4 = 1
            goto L_0x00d9
        L_0x00ce:
            java.lang.String r4 = "rotationX"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x00d8
            goto L_0x004d
        L_0x00d8:
            r4 = 0
        L_0x00d9:
            switch(r4) {
                case 0: goto L_0x0193;
                case 1: goto L_0x0185;
                case 2: goto L_0x0178;
                case 3: goto L_0x016b;
                case 4: goto L_0x015e;
                case 5: goto L_0x0151;
                case 6: goto L_0x0144;
                case 7: goto L_0x0137;
                case 8: goto L_0x012a;
                case 9: goto L_0x011d;
                case 10: goto L_0x0110;
                case 11: goto L_0x00f9;
                default: goto L_0x00dc;
            }
        L_0x00dc:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "UNKNOWN addValues \""
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = "\""
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            java.lang.String r2 = "KeyTimeCycles"
            android.util.Log.e(r2, r1)
            goto L_0x0008
        L_0x00f9:
            float r1 = r10.f1548i
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f1486a
            float r5 = r10.f1548i
        L_0x0105:
            float r6 = r10.f1562w
            int r7 = r10.f1560u
            float r8 = r10.f1563x
            r3.b(r4, r5, r6, r7, r8)
            goto L_0x0008
        L_0x0110:
            float r1 = r10.f1553n
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f1486a
            float r5 = r10.f1553n
            goto L_0x0105
        L_0x011d:
            float r1 = r10.f1549j
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f1486a
            float r5 = r10.f1549j
            goto L_0x0105
        L_0x012a:
            float r1 = r10.f1550k
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f1486a
            float r5 = r10.f1550k
            goto L_0x0105
        L_0x0137:
            float r1 = r10.f1555p
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f1486a
            float r5 = r10.f1555p
            goto L_0x0105
        L_0x0144:
            float r1 = r10.f1554o
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f1486a
            float r5 = r10.f1554o
            goto L_0x0105
        L_0x0151:
            float r1 = r10.f1559t
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f1486a
            float r5 = r10.f1559t
            goto L_0x0105
        L_0x015e:
            float r1 = r10.f1558s
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f1486a
            float r5 = r10.f1558s
            goto L_0x0105
        L_0x016b:
            float r1 = r10.f1557r
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f1486a
            float r5 = r10.f1557r
            goto L_0x0105
        L_0x0178:
            float r1 = r10.f1556q
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f1486a
            float r5 = r10.f1556q
            goto L_0x0105
        L_0x0185:
            float r1 = r10.f1552m
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f1486a
            float r5 = r10.f1552m
            goto L_0x0105
        L_0x0193:
            float r1 = r10.f1551l
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f1486a
            float r5 = r10.f1551l
            goto L_0x0105
        L_0x01a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.j.U(java.util.HashMap):void");
    }

    public void a(HashMap<String, d> hashMap) {
        throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
    }

    /* renamed from: b */
    public d clone() {
        return new j().c(this);
    }

    public d c(d dVar) {
        super.c(dVar);
        j jVar = (j) dVar;
        this.f1546g = jVar.f1546g;
        this.f1547h = jVar.f1547h;
        this.f1560u = jVar.f1560u;
        this.f1562w = jVar.f1562w;
        this.f1563x = jVar.f1563x;
        this.f1559t = jVar.f1559t;
        this.f1548i = jVar.f1548i;
        this.f1549j = jVar.f1549j;
        this.f1550k = jVar.f1550k;
        this.f1553n = jVar.f1553n;
        this.f1551l = jVar.f1551l;
        this.f1552m = jVar.f1552m;
        this.f1554o = jVar.f1554o;
        this.f1555p = jVar.f1555p;
        this.f1556q = jVar.f1556q;
        this.f1557r = jVar.f1557r;
        this.f1558s = jVar.f1558s;
        return this;
    }

    public void d(HashSet<String> hashSet) {
        if (!Float.isNaN(this.f1548i)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.f1549j)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f1550k)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f1551l)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f1552m)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f1556q)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f1557r)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.f1558s)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.f1553n)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f1554o)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.f1555p)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.f1559t)) {
            hashSet.add("progress");
        }
        if (this.f1490e.size() > 0) {
            for (String str : this.f1490e.keySet()) {
                hashSet.add("CUSTOM," + str);
            }
        }
    }

    public void e(Context context, AttributeSet attributeSet) {
        a.a(this, context.obtainStyledAttributes(attributeSet, f.KeyTimeCycle));
    }

    public void h(HashMap<String, Integer> hashMap) {
        if (this.f1547h != -1) {
            if (!Float.isNaN(this.f1548i)) {
                hashMap.put("alpha", Integer.valueOf(this.f1547h));
            }
            if (!Float.isNaN(this.f1549j)) {
                hashMap.put("elevation", Integer.valueOf(this.f1547h));
            }
            if (!Float.isNaN(this.f1550k)) {
                hashMap.put("rotation", Integer.valueOf(this.f1547h));
            }
            if (!Float.isNaN(this.f1551l)) {
                hashMap.put("rotationX", Integer.valueOf(this.f1547h));
            }
            if (!Float.isNaN(this.f1552m)) {
                hashMap.put("rotationY", Integer.valueOf(this.f1547h));
            }
            if (!Float.isNaN(this.f1556q)) {
                hashMap.put("translationX", Integer.valueOf(this.f1547h));
            }
            if (!Float.isNaN(this.f1557r)) {
                hashMap.put("translationY", Integer.valueOf(this.f1547h));
            }
            if (!Float.isNaN(this.f1558s)) {
                hashMap.put("translationZ", Integer.valueOf(this.f1547h));
            }
            if (!Float.isNaN(this.f1553n)) {
                hashMap.put("transitionPathRotate", Integer.valueOf(this.f1547h));
            }
            if (!Float.isNaN(this.f1554o)) {
                hashMap.put("scaleX", Integer.valueOf(this.f1547h));
            }
            if (!Float.isNaN(this.f1554o)) {
                hashMap.put("scaleY", Integer.valueOf(this.f1547h));
            }
            if (!Float.isNaN(this.f1559t)) {
                hashMap.put("progress", Integer.valueOf(this.f1547h));
            }
            if (this.f1490e.size() > 0) {
                for (String str : this.f1490e.keySet()) {
                    hashMap.put("CUSTOM," + str, Integer.valueOf(this.f1547h));
                }
            }
        }
    }
}
