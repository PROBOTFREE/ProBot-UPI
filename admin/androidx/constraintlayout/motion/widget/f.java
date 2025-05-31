package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.a;
import f0.j;
import java.util.HashMap;
import java.util.HashSet;
import k0.c;
import k0.d;

public class f extends d {
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f1509g = null;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f1510h = 0;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public int f1511i = -1;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public String f1512j = null;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public float f1513k = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public float f1514l = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public float f1515m = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public float f1516n = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public int f1517o = -1;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public float f1518p = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public float f1519q = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public float f1520r = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public float f1521s = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public float f1522t = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public float f1523u = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public float f1524v = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public float f1525w = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public float f1526x = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public float f1527y = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public float f1528z = Float.NaN;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static SparseIntArray f1529a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1529a = sparseIntArray;
            sparseIntArray.append(androidx.constraintlayout.widget.f.KeyCycle_motionTarget, 1);
            f1529a.append(androidx.constraintlayout.widget.f.KeyCycle_framePosition, 2);
            f1529a.append(androidx.constraintlayout.widget.f.KeyCycle_transitionEasing, 3);
            f1529a.append(androidx.constraintlayout.widget.f.KeyCycle_curveFit, 4);
            f1529a.append(androidx.constraintlayout.widget.f.KeyCycle_waveShape, 5);
            f1529a.append(androidx.constraintlayout.widget.f.KeyCycle_wavePeriod, 6);
            f1529a.append(androidx.constraintlayout.widget.f.KeyCycle_waveOffset, 7);
            f1529a.append(androidx.constraintlayout.widget.f.KeyCycle_waveVariesBy, 8);
            f1529a.append(androidx.constraintlayout.widget.f.KeyCycle_android_alpha, 9);
            f1529a.append(androidx.constraintlayout.widget.f.KeyCycle_android_elevation, 10);
            f1529a.append(androidx.constraintlayout.widget.f.KeyCycle_android_rotation, 11);
            f1529a.append(androidx.constraintlayout.widget.f.KeyCycle_android_rotationX, 12);
            f1529a.append(androidx.constraintlayout.widget.f.KeyCycle_android_rotationY, 13);
            f1529a.append(androidx.constraintlayout.widget.f.KeyCycle_transitionPathRotate, 14);
            f1529a.append(androidx.constraintlayout.widget.f.KeyCycle_android_scaleX, 15);
            f1529a.append(androidx.constraintlayout.widget.f.KeyCycle_android_scaleY, 16);
            f1529a.append(androidx.constraintlayout.widget.f.KeyCycle_android_translationX, 17);
            f1529a.append(androidx.constraintlayout.widget.f.KeyCycle_android_translationY, 18);
            f1529a.append(androidx.constraintlayout.widget.f.KeyCycle_android_translationZ, 19);
            f1529a.append(androidx.constraintlayout.widget.f.KeyCycle_motionProgress, 20);
            f1529a.append(androidx.constraintlayout.widget.f.KeyCycle_wavePhase, 21);
        }

        /* access modifiers changed from: private */
        public static void b(f fVar, TypedArray typedArray) {
            int i10;
            int indexCount = typedArray.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArray.getIndex(i11);
                switch (f1529a.get(index)) {
                    case 1:
                        if (!MotionLayout.O1) {
                            if (typedArray.peekValue(index).type != 3) {
                                fVar.f1487b = typedArray.getResourceId(index, fVar.f1487b);
                                break;
                            }
                        } else {
                            int resourceId = typedArray.getResourceId(index, fVar.f1487b);
                            fVar.f1487b = resourceId;
                            if (resourceId != -1) {
                                break;
                            }
                        }
                        fVar.f1488c = typedArray.getString(index);
                        break;
                    case 2:
                        fVar.f1486a = typedArray.getInt(index, fVar.f1486a);
                        break;
                    case 3:
                        String unused = fVar.f1509g = typedArray.getString(index);
                        break;
                    case 4:
                        int unused2 = fVar.f1510h = typedArray.getInteger(index, fVar.f1510h);
                        break;
                    case 5:
                        if (typedArray.peekValue(index).type == 3) {
                            String unused3 = fVar.f1512j = typedArray.getString(index);
                            i10 = 7;
                        } else {
                            i10 = typedArray.getInt(index, fVar.f1511i);
                        }
                        int unused4 = fVar.f1511i = i10;
                        break;
                    case 6:
                        float unused5 = fVar.f1513k = typedArray.getFloat(index, fVar.f1513k);
                        break;
                    case 7:
                        float unused6 = fVar.f1514l = typedArray.peekValue(index).type == 5 ? typedArray.getDimension(index, fVar.f1514l) : typedArray.getFloat(index, fVar.f1514l);
                        break;
                    case 8:
                        int unused7 = fVar.f1517o = typedArray.getInt(index, fVar.f1517o);
                        break;
                    case 9:
                        float unused8 = fVar.f1518p = typedArray.getFloat(index, fVar.f1518p);
                        break;
                    case 10:
                        float unused9 = fVar.f1519q = typedArray.getDimension(index, fVar.f1519q);
                        break;
                    case 11:
                        float unused10 = fVar.f1520r = typedArray.getFloat(index, fVar.f1520r);
                        break;
                    case 12:
                        float unused11 = fVar.f1522t = typedArray.getFloat(index, fVar.f1522t);
                        break;
                    case 13:
                        float unused12 = fVar.f1523u = typedArray.getFloat(index, fVar.f1523u);
                        break;
                    case 14:
                        float unused13 = fVar.f1521s = typedArray.getFloat(index, fVar.f1521s);
                        break;
                    case 15:
                        float unused14 = fVar.f1524v = typedArray.getFloat(index, fVar.f1524v);
                        break;
                    case 16:
                        float unused15 = fVar.f1525w = typedArray.getFloat(index, fVar.f1525w);
                        break;
                    case 17:
                        float unused16 = fVar.f1526x = typedArray.getDimension(index, fVar.f1526x);
                        break;
                    case 18:
                        float unused17 = fVar.f1527y = typedArray.getDimension(index, fVar.f1527y);
                        break;
                    case 19:
                        if (Build.VERSION.SDK_INT < 21) {
                            break;
                        } else {
                            float unused18 = fVar.f1528z = typedArray.getDimension(index, fVar.f1528z);
                            break;
                        }
                    case 20:
                        float unused19 = fVar.f1516n = typedArray.getFloat(index, fVar.f1516n);
                        break;
                    case 21:
                        float unused20 = fVar.f1515m = typedArray.getFloat(index, fVar.f1515m) / 360.0f;
                        break;
                    default:
                        Log.e("KeyCycle", "unused attribute 0x" + Integer.toHexString(index) + "   " + f1529a.get(index));
                        break;
                }
            }
        }
    }

    public f() {
        this.f1489d = 4;
        this.f1490e = new HashMap<>();
    }

    public void Y(HashMap<String, c> hashMap) {
        c cVar;
        c cVar2;
        HashMap<String, c> hashMap2 = hashMap;
        for (String next : hashMap.keySet()) {
            if (next.startsWith("CUSTOM")) {
                androidx.constraintlayout.widget.a aVar = this.f1490e.get(next.substring(7));
                if (!(aVar == null || aVar.d() != a.b.FLOAT_TYPE || (cVar2 = hashMap2.get(next)) == null)) {
                    cVar2.e(this.f1486a, this.f1511i, this.f1512j, this.f1517o, this.f1513k, this.f1514l, this.f1515m, aVar.e(), aVar);
                }
            } else {
                float Z = Z(next);
                if (!Float.isNaN(Z) && (cVar = hashMap2.get(next)) != null) {
                    cVar.d(this.f1486a, this.f1511i, this.f1512j, this.f1517o, this.f1513k, this.f1514l, this.f1515m, Z);
                }
            }
        }
    }

    public float Z(String str) {
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c10 = 1;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c10 = 2;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c10 = 3;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c10 = 4;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c10 = 5;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c10 = 6;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c10 = 7;
                    break;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c10 = 8;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c10 = 9;
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c10 = 10;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c10 = 11;
                    break;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c10 = 12;
                    break;
                }
                break;
            case 1530034690:
                if (str.equals("wavePhase")) {
                    c10 = 13;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return this.f1522t;
            case 1:
                return this.f1523u;
            case 2:
                return this.f1526x;
            case 3:
                return this.f1527y;
            case 4:
                return this.f1528z;
            case 5:
                return this.f1516n;
            case 6:
                return this.f1524v;
            case 7:
                return this.f1525w;
            case 8:
                return this.f1520r;
            case 9:
                return this.f1519q;
            case 10:
                return this.f1521s;
            case 11:
                return this.f1518p;
            case 12:
                return this.f1514l;
            case 13:
                return this.f1515m;
            default:
                if (str.startsWith("CUSTOM")) {
                    return Float.NaN;
                }
                Log.v("WARNING! KeyCycle", "  UNKNOWN  " + str);
                return Float.NaN;
        }
    }

    public void a(HashMap<String, d> hashMap) {
        int i10;
        float f10;
        a.g("KeyCycle", "add " + hashMap.size() + " values", 2);
        for (String next : hashMap.keySet()) {
            j jVar = hashMap.get(next);
            if (jVar != null) {
                next.hashCode();
                char c10 = 65535;
                switch (next.hashCode()) {
                    case -1249320806:
                        if (next.equals("rotationX")) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case -1249320805:
                        if (next.equals("rotationY")) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case -1225497657:
                        if (next.equals("translationX")) {
                            c10 = 2;
                            break;
                        }
                        break;
                    case -1225497656:
                        if (next.equals("translationY")) {
                            c10 = 3;
                            break;
                        }
                        break;
                    case -1225497655:
                        if (next.equals("translationZ")) {
                            c10 = 4;
                            break;
                        }
                        break;
                    case -1001078227:
                        if (next.equals("progress")) {
                            c10 = 5;
                            break;
                        }
                        break;
                    case -908189618:
                        if (next.equals("scaleX")) {
                            c10 = 6;
                            break;
                        }
                        break;
                    case -908189617:
                        if (next.equals("scaleY")) {
                            c10 = 7;
                            break;
                        }
                        break;
                    case -40300674:
                        if (next.equals("rotation")) {
                            c10 = 8;
                            break;
                        }
                        break;
                    case -4379043:
                        if (next.equals("elevation")) {
                            c10 = 9;
                            break;
                        }
                        break;
                    case 37232917:
                        if (next.equals("transitionPathRotate")) {
                            c10 = 10;
                            break;
                        }
                        break;
                    case 92909918:
                        if (next.equals("alpha")) {
                            c10 = 11;
                            break;
                        }
                        break;
                    case 156108012:
                        if (next.equals("waveOffset")) {
                            c10 = 12;
                            break;
                        }
                        break;
                    case 1530034690:
                        if (next.equals("wavePhase")) {
                            c10 = 13;
                            break;
                        }
                        break;
                }
                switch (c10) {
                    case 0:
                        i10 = this.f1486a;
                        f10 = this.f1522t;
                        break;
                    case 1:
                        i10 = this.f1486a;
                        f10 = this.f1523u;
                        break;
                    case 2:
                        i10 = this.f1486a;
                        f10 = this.f1526x;
                        break;
                    case 3:
                        i10 = this.f1486a;
                        f10 = this.f1527y;
                        break;
                    case 4:
                        i10 = this.f1486a;
                        f10 = this.f1528z;
                        break;
                    case 5:
                        i10 = this.f1486a;
                        f10 = this.f1516n;
                        break;
                    case 6:
                        i10 = this.f1486a;
                        f10 = this.f1524v;
                        break;
                    case 7:
                        i10 = this.f1486a;
                        f10 = this.f1525w;
                        break;
                    case 8:
                        i10 = this.f1486a;
                        f10 = this.f1520r;
                        break;
                    case 9:
                        i10 = this.f1486a;
                        f10 = this.f1519q;
                        break;
                    case 10:
                        i10 = this.f1486a;
                        f10 = this.f1521s;
                        break;
                    case 11:
                        i10 = this.f1486a;
                        f10 = this.f1518p;
                        break;
                    case 12:
                        i10 = this.f1486a;
                        f10 = this.f1514l;
                        break;
                    case 13:
                        i10 = this.f1486a;
                        f10 = this.f1515m;
                        break;
                    default:
                        if (!next.startsWith("CUSTOM")) {
                            Log.v("WARNING KeyCycle", "  UNKNOWN  " + next);
                            break;
                        } else {
                            continue;
                        }
                }
                jVar.c(i10, f10);
            }
        }
    }

    /* renamed from: b */
    public d clone() {
        return new f().c(this);
    }

    public d c(d dVar) {
        super.c(dVar);
        f fVar = (f) dVar;
        this.f1509g = fVar.f1509g;
        this.f1510h = fVar.f1510h;
        this.f1511i = fVar.f1511i;
        this.f1512j = fVar.f1512j;
        this.f1513k = fVar.f1513k;
        this.f1514l = fVar.f1514l;
        this.f1515m = fVar.f1515m;
        this.f1516n = fVar.f1516n;
        this.f1517o = fVar.f1517o;
        this.f1518p = fVar.f1518p;
        this.f1519q = fVar.f1519q;
        this.f1520r = fVar.f1520r;
        this.f1521s = fVar.f1521s;
        this.f1522t = fVar.f1522t;
        this.f1523u = fVar.f1523u;
        this.f1524v = fVar.f1524v;
        this.f1525w = fVar.f1525w;
        this.f1526x = fVar.f1526x;
        this.f1527y = fVar.f1527y;
        this.f1528z = fVar.f1528z;
        return this;
    }

    public void d(HashSet<String> hashSet) {
        if (!Float.isNaN(this.f1518p)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.f1519q)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f1520r)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f1522t)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f1523u)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f1524v)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.f1525w)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.f1521s)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f1526x)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f1527y)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.f1528z)) {
            hashSet.add("translationZ");
        }
        if (this.f1490e.size() > 0) {
            for (String str : this.f1490e.keySet()) {
                hashSet.add("CUSTOM," + str);
            }
        }
    }

    public void e(Context context, AttributeSet attributeSet) {
        a.b(this, context.obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.f.KeyCycle));
    }
}
