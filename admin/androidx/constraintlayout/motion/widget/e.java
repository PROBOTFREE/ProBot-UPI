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

public class e extends d {
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f1491g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f1492h = -1;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1493i = false;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public float f1494j = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public float f1495k = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public float f1496l = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public float f1497m = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public float f1498n = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public float f1499o = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public float f1500p = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public float f1501q = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public float f1502r = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public float f1503s = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public float f1504t = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public float f1505u = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public float f1506v = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public float f1507w = Float.NaN;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static SparseIntArray f1508a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1508a = sparseIntArray;
            sparseIntArray.append(f.KeyAttribute_android_alpha, 1);
            f1508a.append(f.KeyAttribute_android_elevation, 2);
            f1508a.append(f.KeyAttribute_android_rotation, 4);
            f1508a.append(f.KeyAttribute_android_rotationX, 5);
            f1508a.append(f.KeyAttribute_android_rotationY, 6);
            f1508a.append(f.KeyAttribute_android_transformPivotX, 19);
            f1508a.append(f.KeyAttribute_android_transformPivotY, 20);
            f1508a.append(f.KeyAttribute_android_scaleX, 7);
            f1508a.append(f.KeyAttribute_transitionPathRotate, 8);
            f1508a.append(f.KeyAttribute_transitionEasing, 9);
            f1508a.append(f.KeyAttribute_motionTarget, 10);
            f1508a.append(f.KeyAttribute_framePosition, 12);
            f1508a.append(f.KeyAttribute_curveFit, 13);
            f1508a.append(f.KeyAttribute_android_scaleY, 14);
            f1508a.append(f.KeyAttribute_android_translationX, 15);
            f1508a.append(f.KeyAttribute_android_translationY, 16);
            f1508a.append(f.KeyAttribute_android_translationZ, 17);
            f1508a.append(f.KeyAttribute_motionProgress, 18);
        }

        public static void a(e eVar, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArray.getIndex(i10);
                switch (f1508a.get(index)) {
                    case 1:
                        float unused = eVar.f1494j = typedArray.getFloat(index, eVar.f1494j);
                        break;
                    case 2:
                        float unused2 = eVar.f1495k = typedArray.getDimension(index, eVar.f1495k);
                        break;
                    case 4:
                        float unused3 = eVar.f1496l = typedArray.getFloat(index, eVar.f1496l);
                        break;
                    case 5:
                        float unused4 = eVar.f1497m = typedArray.getFloat(index, eVar.f1497m);
                        break;
                    case 6:
                        float unused5 = eVar.f1498n = typedArray.getFloat(index, eVar.f1498n);
                        break;
                    case 7:
                        float unused6 = eVar.f1502r = typedArray.getFloat(index, eVar.f1502r);
                        break;
                    case 8:
                        float unused7 = eVar.f1501q = typedArray.getFloat(index, eVar.f1501q);
                        break;
                    case 9:
                        String unused8 = eVar.f1491g = typedArray.getString(index);
                        break;
                    case 10:
                        if (!MotionLayout.O1) {
                            if (typedArray.peekValue(index).type != 3) {
                                eVar.f1487b = typedArray.getResourceId(index, eVar.f1487b);
                                break;
                            }
                        } else {
                            int resourceId = typedArray.getResourceId(index, eVar.f1487b);
                            eVar.f1487b = resourceId;
                            if (resourceId != -1) {
                                break;
                            }
                        }
                        eVar.f1488c = typedArray.getString(index);
                        break;
                    case 12:
                        eVar.f1486a = typedArray.getInt(index, eVar.f1486a);
                        break;
                    case 13:
                        int unused9 = eVar.f1492h = typedArray.getInteger(index, eVar.f1492h);
                        break;
                    case 14:
                        float unused10 = eVar.f1503s = typedArray.getFloat(index, eVar.f1503s);
                        break;
                    case 15:
                        float unused11 = eVar.f1504t = typedArray.getDimension(index, eVar.f1504t);
                        break;
                    case 16:
                        float unused12 = eVar.f1505u = typedArray.getDimension(index, eVar.f1505u);
                        break;
                    case 17:
                        if (Build.VERSION.SDK_INT < 21) {
                            break;
                        } else {
                            float unused13 = eVar.f1506v = typedArray.getDimension(index, eVar.f1506v);
                            break;
                        }
                    case 18:
                        float unused14 = eVar.f1507w = typedArray.getFloat(index, eVar.f1507w);
                        break;
                    case 19:
                        float unused15 = eVar.f1499o = typedArray.getDimension(index, eVar.f1499o);
                        break;
                    case 20:
                        float unused16 = eVar.f1500p = typedArray.getDimension(index, eVar.f1500p);
                        break;
                    default:
                        Log.e("KeyAttribute", "unused attribute 0x" + Integer.toHexString(index) + "   " + f1508a.get(index));
                        break;
                }
            }
        }
    }

    public e() {
        this.f1489d = 1;
        this.f1490e = new HashMap<>();
    }

    public void R(String str, Object obj) {
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1913008125:
                if (str.equals("motionProgress")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1812823328:
                if (str.equals("transitionEasing")) {
                    c10 = 1;
                    break;
                }
                break;
            case -1249320806:
                if (str.equals("rotationX")) {
                    c10 = 2;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c10 = 3;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c10 = 4;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c10 = 5;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c10 = 6;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c10 = 7;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c10 = 8;
                    break;
                }
                break;
            case -760884510:
                if (str.equals("transformPivotX")) {
                    c10 = 9;
                    break;
                }
                break;
            case -760884509:
                if (str.equals("transformPivotY")) {
                    c10 = 10;
                    break;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c10 = 11;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c10 = 12;
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c10 = 13;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c10 = 14;
                    break;
                }
                break;
            case 579057826:
                if (str.equals("curveFit")) {
                    c10 = 15;
                    break;
                }
                break;
            case 1941332754:
                if (str.equals("visibility")) {
                    c10 = 16;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                this.f1507w = k(obj);
                return;
            case 1:
                obj.toString();
                return;
            case 2:
                this.f1497m = k(obj);
                return;
            case 3:
                this.f1498n = k(obj);
                return;
            case 4:
                this.f1504t = k(obj);
                return;
            case 5:
                this.f1505u = k(obj);
                return;
            case 6:
                this.f1506v = k(obj);
                return;
            case 7:
                this.f1502r = k(obj);
                return;
            case 8:
                this.f1503s = k(obj);
                return;
            case 9:
                this.f1499o = k(obj);
                return;
            case 10:
                this.f1500p = k(obj);
                return;
            case 11:
                this.f1496l = k(obj);
                return;
            case 12:
                this.f1495k = k(obj);
                return;
            case 13:
                this.f1501q = k(obj);
                return;
            case 14:
                this.f1494j = k(obj);
                return;
            case 15:
                this.f1492h = l(obj);
                return;
            case 16:
                this.f1493i = j(obj);
                return;
            default:
                return;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009a, code lost:
        if (r1.equals("scaleY") == false) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00fe, code lost:
        r2.c(r1, r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.util.HashMap<java.lang.String, k0.d> r7) {
        /*
            r6 = this;
            java.util.Set r0 = r7.keySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0008:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x01b0
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r7.get(r1)
            f0.j r2 = (f0.j) r2
            if (r2 != 0) goto L_0x001d
            goto L_0x0008
        L_0x001d:
            java.lang.String r3 = "CUSTOM"
            boolean r3 = r1.startsWith(r3)
            r4 = 7
            if (r3 == 0) goto L_0x003c
            java.lang.String r1 = r1.substring(r4)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.a> r3 = r6.f1490e
            java.lang.Object r1 = r3.get(r1)
            androidx.constraintlayout.widget.a r1 = (androidx.constraintlayout.widget.a) r1
            if (r1 == 0) goto L_0x0008
            k0.d$b r2 = (k0.d.b) r2
            int r3 = r6.f1486a
            r2.i(r3, r1)
            goto L_0x0008
        L_0x003c:
            r3 = -1
            int r5 = r1.hashCode()
            switch(r5) {
                case -1249320806: goto L_0x00e2;
                case -1249320805: goto L_0x00d6;
                case -1225497657: goto L_0x00ca;
                case -1225497656: goto L_0x00be;
                case -1225497655: goto L_0x00b3;
                case -1001078227: goto L_0x00a8;
                case -908189618: goto L_0x009d;
                case -908189617: goto L_0x0094;
                case -760884510: goto L_0x0088;
                case -760884509: goto L_0x007b;
                case -40300674: goto L_0x006e;
                case -4379043: goto L_0x0061;
                case 37232917: goto L_0x0054;
                case 92909918: goto L_0x0047;
                default: goto L_0x0044;
            }
        L_0x0044:
            r4 = r3
            goto L_0x00ed
        L_0x0047:
            java.lang.String r4 = "alpha"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x0050
            goto L_0x0044
        L_0x0050:
            r4 = 13
            goto L_0x00ed
        L_0x0054:
            java.lang.String r4 = "transitionPathRotate"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x005d
            goto L_0x0044
        L_0x005d:
            r4 = 12
            goto L_0x00ed
        L_0x0061:
            java.lang.String r4 = "elevation"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x006a
            goto L_0x0044
        L_0x006a:
            r4 = 11
            goto L_0x00ed
        L_0x006e:
            java.lang.String r4 = "rotation"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x0077
            goto L_0x0044
        L_0x0077:
            r4 = 10
            goto L_0x00ed
        L_0x007b:
            java.lang.String r4 = "transformPivotY"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x0084
            goto L_0x0044
        L_0x0084:
            r4 = 9
            goto L_0x00ed
        L_0x0088:
            java.lang.String r4 = "transformPivotX"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x0091
            goto L_0x0044
        L_0x0091:
            r4 = 8
            goto L_0x00ed
        L_0x0094:
            java.lang.String r5 = "scaleY"
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x00ed
            goto L_0x0044
        L_0x009d:
            java.lang.String r4 = "scaleX"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x00a6
            goto L_0x0044
        L_0x00a6:
            r4 = 6
            goto L_0x00ed
        L_0x00a8:
            java.lang.String r4 = "progress"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x00b1
            goto L_0x0044
        L_0x00b1:
            r4 = 5
            goto L_0x00ed
        L_0x00b3:
            java.lang.String r4 = "translationZ"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x00bc
            goto L_0x0044
        L_0x00bc:
            r4 = 4
            goto L_0x00ed
        L_0x00be:
            java.lang.String r4 = "translationY"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x00c8
            goto L_0x0044
        L_0x00c8:
            r4 = 3
            goto L_0x00ed
        L_0x00ca:
            java.lang.String r4 = "translationX"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x00d4
            goto L_0x0044
        L_0x00d4:
            r4 = 2
            goto L_0x00ed
        L_0x00d6:
            java.lang.String r4 = "rotationY"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x00e0
            goto L_0x0044
        L_0x00e0:
            r4 = 1
            goto L_0x00ed
        L_0x00e2:
            java.lang.String r4 = "rotationX"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x00ec
            goto L_0x0044
        L_0x00ec:
            r4 = 0
        L_0x00ed:
            switch(r4) {
                case 0: goto L_0x01a2;
                case 1: goto L_0x0194;
                case 2: goto L_0x0186;
                case 3: goto L_0x0178;
                case 4: goto L_0x016b;
                case 5: goto L_0x015e;
                case 6: goto L_0x0151;
                case 7: goto L_0x0144;
                case 8: goto L_0x0137;
                case 9: goto L_0x012a;
                case 10: goto L_0x011d;
                case 11: goto L_0x0110;
                case 12: goto L_0x0103;
                case 13: goto L_0x00f2;
                default: goto L_0x00f0;
            }
        L_0x00f0:
            goto L_0x0008
        L_0x00f2:
            float r1 = r6.f1494j
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f1486a
            float r3 = r6.f1494j
        L_0x00fe:
            r2.c(r1, r3)
            goto L_0x0008
        L_0x0103:
            float r1 = r6.f1501q
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f1486a
            float r3 = r6.f1501q
            goto L_0x00fe
        L_0x0110:
            float r1 = r6.f1495k
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f1486a
            float r3 = r6.f1495k
            goto L_0x00fe
        L_0x011d:
            float r1 = r6.f1496l
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f1486a
            float r3 = r6.f1496l
            goto L_0x00fe
        L_0x012a:
            float r1 = r6.f1498n
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f1486a
            float r3 = r6.f1500p
            goto L_0x00fe
        L_0x0137:
            float r1 = r6.f1497m
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f1486a
            float r3 = r6.f1499o
            goto L_0x00fe
        L_0x0144:
            float r1 = r6.f1503s
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f1486a
            float r3 = r6.f1503s
            goto L_0x00fe
        L_0x0151:
            float r1 = r6.f1502r
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f1486a
            float r3 = r6.f1502r
            goto L_0x00fe
        L_0x015e:
            float r1 = r6.f1507w
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f1486a
            float r3 = r6.f1507w
            goto L_0x00fe
        L_0x016b:
            float r1 = r6.f1506v
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f1486a
            float r3 = r6.f1506v
            goto L_0x00fe
        L_0x0178:
            float r1 = r6.f1505u
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f1486a
            float r3 = r6.f1505u
            goto L_0x00fe
        L_0x0186:
            float r1 = r6.f1504t
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f1486a
            float r3 = r6.f1504t
            goto L_0x00fe
        L_0x0194:
            float r1 = r6.f1498n
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f1486a
            float r3 = r6.f1498n
            goto L_0x00fe
        L_0x01a2:
            float r1 = r6.f1497m
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f1486a
            float r3 = r6.f1497m
            goto L_0x00fe
        L_0x01b0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.e.a(java.util.HashMap):void");
    }

    /* renamed from: b */
    public d clone() {
        return new e().c(this);
    }

    public d c(d dVar) {
        super.c(dVar);
        e eVar = (e) dVar;
        this.f1492h = eVar.f1492h;
        this.f1493i = eVar.f1493i;
        this.f1494j = eVar.f1494j;
        this.f1495k = eVar.f1495k;
        this.f1496l = eVar.f1496l;
        this.f1497m = eVar.f1497m;
        this.f1498n = eVar.f1498n;
        this.f1499o = eVar.f1499o;
        this.f1500p = eVar.f1500p;
        this.f1501q = eVar.f1501q;
        this.f1502r = eVar.f1502r;
        this.f1503s = eVar.f1503s;
        this.f1504t = eVar.f1504t;
        this.f1505u = eVar.f1505u;
        this.f1506v = eVar.f1506v;
        this.f1507w = eVar.f1507w;
        return this;
    }

    public void d(HashSet<String> hashSet) {
        if (!Float.isNaN(this.f1494j)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.f1495k)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f1496l)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f1497m)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f1498n)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f1499o)) {
            hashSet.add("transformPivotX");
        }
        if (!Float.isNaN(this.f1500p)) {
            hashSet.add("transformPivotY");
        }
        if (!Float.isNaN(this.f1504t)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f1505u)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.f1506v)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.f1501q)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f1502r)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.f1503s)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.f1507w)) {
            hashSet.add("progress");
        }
        if (this.f1490e.size() > 0) {
            for (String str : this.f1490e.keySet()) {
                hashSet.add("CUSTOM," + str);
            }
        }
    }

    public void e(Context context, AttributeSet attributeSet) {
        a.a(this, context.obtainStyledAttributes(attributeSet, f.KeyAttribute));
    }

    public void h(HashMap<String, Integer> hashMap) {
        if (this.f1492h != -1) {
            if (!Float.isNaN(this.f1494j)) {
                hashMap.put("alpha", Integer.valueOf(this.f1492h));
            }
            if (!Float.isNaN(this.f1495k)) {
                hashMap.put("elevation", Integer.valueOf(this.f1492h));
            }
            if (!Float.isNaN(this.f1496l)) {
                hashMap.put("rotation", Integer.valueOf(this.f1492h));
            }
            if (!Float.isNaN(this.f1497m)) {
                hashMap.put("rotationX", Integer.valueOf(this.f1492h));
            }
            if (!Float.isNaN(this.f1498n)) {
                hashMap.put("rotationY", Integer.valueOf(this.f1492h));
            }
            if (!Float.isNaN(this.f1499o)) {
                hashMap.put("transformPivotX", Integer.valueOf(this.f1492h));
            }
            if (!Float.isNaN(this.f1500p)) {
                hashMap.put("transformPivotY", Integer.valueOf(this.f1492h));
            }
            if (!Float.isNaN(this.f1504t)) {
                hashMap.put("translationX", Integer.valueOf(this.f1492h));
            }
            if (!Float.isNaN(this.f1505u)) {
                hashMap.put("translationY", Integer.valueOf(this.f1492h));
            }
            if (!Float.isNaN(this.f1506v)) {
                hashMap.put("translationZ", Integer.valueOf(this.f1492h));
            }
            if (!Float.isNaN(this.f1501q)) {
                hashMap.put("transitionPathRotate", Integer.valueOf(this.f1492h));
            }
            if (!Float.isNaN(this.f1502r)) {
                hashMap.put("scaleX", Integer.valueOf(this.f1492h));
            }
            if (!Float.isNaN(this.f1503s)) {
                hashMap.put("scaleY", Integer.valueOf(this.f1492h));
            }
            if (!Float.isNaN(this.f1507w)) {
                hashMap.put("progress", Integer.valueOf(this.f1492h));
            }
            if (this.f1490e.size() > 0) {
                for (String str : this.f1490e.keySet()) {
                    hashMap.put("CUSTOM," + str, Integer.valueOf(this.f1492h));
                }
            }
        }
    }
}
