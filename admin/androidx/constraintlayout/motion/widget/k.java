package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.f;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import k0.d;

public class k extends d {
    HashMap<String, Method> A;

    /* renamed from: g  reason: collision with root package name */
    private int f1565g = -1;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f1566h = null;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public int f1567i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public String f1568j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public String f1569k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public int f1570l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public int f1571m;

    /* renamed from: n  reason: collision with root package name */
    private View f1572n;

    /* renamed from: o  reason: collision with root package name */
    float f1573o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f1574p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f1575q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f1576r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public float f1577s;

    /* renamed from: t  reason: collision with root package name */
    private float f1578t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public boolean f1579u;

    /* renamed from: v  reason: collision with root package name */
    int f1580v;

    /* renamed from: w  reason: collision with root package name */
    int f1581w;

    /* renamed from: x  reason: collision with root package name */
    int f1582x;

    /* renamed from: y  reason: collision with root package name */
    RectF f1583y;

    /* renamed from: z  reason: collision with root package name */
    RectF f1584z;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static SparseIntArray f1585a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1585a = sparseIntArray;
            sparseIntArray.append(f.KeyTrigger_framePosition, 8);
            f1585a.append(f.KeyTrigger_onCross, 4);
            f1585a.append(f.KeyTrigger_onNegativeCross, 1);
            f1585a.append(f.KeyTrigger_onPositiveCross, 2);
            f1585a.append(f.KeyTrigger_motionTarget, 7);
            f1585a.append(f.KeyTrigger_triggerId, 6);
            f1585a.append(f.KeyTrigger_triggerSlack, 5);
            f1585a.append(f.KeyTrigger_motion_triggerOnCollision, 9);
            f1585a.append(f.KeyTrigger_motion_postLayoutCollision, 10);
            f1585a.append(f.KeyTrigger_triggerReceiver, 11);
            f1585a.append(f.KeyTrigger_viewTransitionOnCross, 12);
            f1585a.append(f.KeyTrigger_viewTransitionOnNegativeCross, 13);
            f1585a.append(f.KeyTrigger_viewTransitionOnPositiveCross, 14);
        }

        public static void a(k kVar, TypedArray typedArray, Context context) {
            int indexCount = typedArray.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArray.getIndex(i10);
                switch (f1585a.get(index)) {
                    case 1:
                        String unused = kVar.f1568j = typedArray.getString(index);
                        break;
                    case 2:
                        String unused2 = kVar.f1569k = typedArray.getString(index);
                        break;
                    case 4:
                        String unused3 = kVar.f1566h = typedArray.getString(index);
                        break;
                    case 5:
                        kVar.f1573o = typedArray.getFloat(index, kVar.f1573o);
                        break;
                    case 6:
                        int unused4 = kVar.f1570l = typedArray.getResourceId(index, kVar.f1570l);
                        break;
                    case 7:
                        if (!MotionLayout.O1) {
                            if (typedArray.peekValue(index).type != 3) {
                                kVar.f1487b = typedArray.getResourceId(index, kVar.f1487b);
                                break;
                            }
                        } else {
                            int resourceId = typedArray.getResourceId(index, kVar.f1487b);
                            kVar.f1487b = resourceId;
                            if (resourceId != -1) {
                                break;
                            }
                        }
                        kVar.f1488c = typedArray.getString(index);
                        break;
                    case 8:
                        int integer = typedArray.getInteger(index, kVar.f1486a);
                        kVar.f1486a = integer;
                        float unused5 = kVar.f1577s = (((float) integer) + 0.5f) / 100.0f;
                        break;
                    case 9:
                        int unused6 = kVar.f1571m = typedArray.getResourceId(index, kVar.f1571m);
                        break;
                    case 10:
                        boolean unused7 = kVar.f1579u = typedArray.getBoolean(index, kVar.f1579u);
                        break;
                    case 11:
                        int unused8 = kVar.f1567i = typedArray.getResourceId(index, kVar.f1567i);
                        break;
                    case 12:
                        kVar.f1582x = typedArray.getResourceId(index, kVar.f1582x);
                        break;
                    case 13:
                        kVar.f1580v = typedArray.getResourceId(index, kVar.f1580v);
                        break;
                    case 14:
                        kVar.f1581w = typedArray.getResourceId(index, kVar.f1581w);
                        break;
                    default:
                        Log.e("KeyTrigger", "unused attribute 0x" + Integer.toHexString(index) + "   " + f1585a.get(index));
                        break;
                }
            }
        }
    }

    public k() {
        int i10 = d.f1485f;
        this.f1567i = i10;
        this.f1568j = null;
        this.f1569k = null;
        this.f1570l = i10;
        this.f1571m = i10;
        this.f1572n = null;
        this.f1573o = 0.1f;
        this.f1574p = true;
        this.f1575q = true;
        this.f1576r = true;
        this.f1577s = Float.NaN;
        this.f1579u = false;
        this.f1580v = i10;
        this.f1581w = i10;
        this.f1582x = i10;
        this.f1583y = new RectF();
        this.f1584z = new RectF();
        this.A = new HashMap<>();
        this.f1489d = 5;
        this.f1490e = new HashMap<>();
    }

    private void A(String str, View view) {
        androidx.constraintlayout.widget.a aVar;
        boolean z10 = str.length() == 1;
        if (!z10) {
            str = str.substring(1).toLowerCase(Locale.ROOT);
        }
        for (String next : this.f1490e.keySet()) {
            String lowerCase = next.toLowerCase(Locale.ROOT);
            if ((z10 || lowerCase.matches(str)) && (aVar = this.f1490e.get(next)) != null) {
                aVar.a(view);
            }
        }
    }

    private void B(RectF rectF, View view, boolean z10) {
        rectF.top = (float) view.getTop();
        rectF.bottom = (float) view.getBottom();
        rectF.left = (float) view.getLeft();
        rectF.right = (float) view.getRight();
        if (z10) {
            view.getMatrix().mapRect(rectF);
        }
    }

    private void z(String str, View view) {
        Method method;
        if (str != null) {
            if (str.startsWith(".")) {
                A(str, view);
                return;
            }
            if (this.A.containsKey(str)) {
                method = this.A.get(str);
                if (method == null) {
                    return;
                }
            } else {
                method = null;
            }
            if (method == null) {
                try {
                    method = view.getClass().getMethod(str, new Class[0]);
                    this.A.put(str, method);
                } catch (NoSuchMethodException unused) {
                    this.A.put(str, (Object) null);
                    Log.e("KeyTrigger", "Could not find method \"" + str + "\"on class " + view.getClass().getSimpleName() + " " + a.d(view));
                    return;
                }
            }
            try {
                method.invoke(view, new Object[0]);
            } catch (Exception unused2) {
                Log.e("KeyTrigger", "Exception in call \"" + this.f1566h + "\"on class " + view.getClass().getSimpleName() + " " + a.d(view));
            }
        }
    }

    public void a(HashMap<String, d> hashMap) {
    }

    /* renamed from: b */
    public d clone() {
        return new k().c(this);
    }

    public d c(d dVar) {
        super.c(dVar);
        k kVar = (k) dVar;
        this.f1565g = kVar.f1565g;
        this.f1566h = kVar.f1566h;
        this.f1567i = kVar.f1567i;
        this.f1568j = kVar.f1568j;
        this.f1569k = kVar.f1569k;
        this.f1570l = kVar.f1570l;
        this.f1571m = kVar.f1571m;
        this.f1572n = kVar.f1572n;
        this.f1573o = kVar.f1573o;
        this.f1574p = kVar.f1574p;
        this.f1575q = kVar.f1575q;
        this.f1576r = kVar.f1576r;
        this.f1577s = kVar.f1577s;
        this.f1578t = kVar.f1578t;
        this.f1579u = kVar.f1579u;
        this.f1583y = kVar.f1583y;
        this.f1584z = kVar.f1584z;
        this.A = kVar.A;
        return this;
    }

    public void d(HashSet<String> hashSet) {
    }

    public void e(Context context, AttributeSet attributeSet) {
        a.a(this, context.obtainStyledAttributes(attributeSet, f.KeyTrigger), context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void y(float r10, android.view.View r11) {
        /*
            r9 = this;
            int r0 = r9.f1571m
            int r1 = androidx.constraintlayout.motion.widget.d.f1485f
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L_0x0062
            android.view.View r0 = r9.f1572n
            if (r0 != 0) goto L_0x001a
            android.view.ViewParent r0 = r11.getParent()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            int r1 = r9.f1571m
            android.view.View r0 = r0.findViewById(r1)
            r9.f1572n = r0
        L_0x001a:
            android.graphics.RectF r0 = r9.f1583y
            android.view.View r1 = r9.f1572n
            boolean r4 = r9.f1579u
            r9.B(r0, r1, r4)
            android.graphics.RectF r0 = r9.f1584z
            boolean r1 = r9.f1579u
            r9.B(r0, r11, r1)
            android.graphics.RectF r0 = r9.f1583y
            android.graphics.RectF r1 = r9.f1584z
            boolean r0 = r0.intersect(r1)
            if (r0 == 0) goto L_0x004c
            boolean r0 = r9.f1574p
            if (r0 == 0) goto L_0x003c
            r9.f1574p = r2
            r0 = r3
            goto L_0x003d
        L_0x003c:
            r0 = r2
        L_0x003d:
            boolean r1 = r9.f1576r
            if (r1 == 0) goto L_0x0045
            r9.f1576r = r2
            r1 = r3
            goto L_0x0046
        L_0x0045:
            r1 = r2
        L_0x0046:
            r9.f1575q = r3
            r4 = r1
            r1 = r2
            goto L_0x00e0
        L_0x004c:
            boolean r0 = r9.f1574p
            if (r0 != 0) goto L_0x0054
            r9.f1574p = r3
            r0 = r3
            goto L_0x0055
        L_0x0054:
            r0 = r2
        L_0x0055:
            boolean r1 = r9.f1575q
            if (r1 == 0) goto L_0x005d
            r9.f1575q = r2
            r1 = r3
            goto L_0x005e
        L_0x005d:
            r1 = r2
        L_0x005e:
            r9.f1576r = r3
            goto L_0x00df
        L_0x0062:
            boolean r0 = r9.f1574p
            r1 = 0
            if (r0 == 0) goto L_0x0077
            float r0 = r9.f1577s
            float r4 = r10 - r0
            float r5 = r9.f1578t
            float r5 = r5 - r0
            float r4 = r4 * r5
            int r0 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0087
            r9.f1574p = r2
            r0 = r3
            goto L_0x0088
        L_0x0077:
            float r0 = r9.f1577s
            float r0 = r10 - r0
            float r0 = java.lang.Math.abs(r0)
            float r4 = r9.f1573o
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0087
            r9.f1574p = r3
        L_0x0087:
            r0 = r2
        L_0x0088:
            boolean r4 = r9.f1575q
            if (r4 == 0) goto L_0x00a0
            float r4 = r9.f1577s
            float r5 = r10 - r4
            float r6 = r9.f1578t
            float r6 = r6 - r4
            float r6 = r6 * r5
            int r4 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r4 >= 0) goto L_0x00b0
            int r4 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r4 >= 0) goto L_0x00b0
            r9.f1575q = r2
            r4 = r3
            goto L_0x00b1
        L_0x00a0:
            float r4 = r9.f1577s
            float r4 = r10 - r4
            float r4 = java.lang.Math.abs(r4)
            float r5 = r9.f1573o
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x00b0
            r9.f1575q = r3
        L_0x00b0:
            r4 = r2
        L_0x00b1:
            boolean r5 = r9.f1576r
            if (r5 == 0) goto L_0x00ce
            float r5 = r9.f1577s
            float r6 = r10 - r5
            float r7 = r9.f1578t
            float r7 = r7 - r5
            float r7 = r7 * r6
            int r5 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r5 >= 0) goto L_0x00c9
            int r1 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x00c9
            r9.f1576r = r2
            r1 = r3
            goto L_0x00ca
        L_0x00c9:
            r1 = r2
        L_0x00ca:
            r8 = r4
            r4 = r1
            r1 = r8
            goto L_0x00e0
        L_0x00ce:
            float r1 = r9.f1577s
            float r1 = r10 - r1
            float r1 = java.lang.Math.abs(r1)
            float r5 = r9.f1573o
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x00de
            r9.f1576r = r3
        L_0x00de:
            r1 = r4
        L_0x00df:
            r4 = r2
        L_0x00e0:
            r9.f1578t = r10
            if (r1 != 0) goto L_0x00e8
            if (r0 != 0) goto L_0x00e8
            if (r4 == 0) goto L_0x00f3
        L_0x00e8:
            android.view.ViewParent r5 = r11.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r5 = (androidx.constraintlayout.motion.widget.MotionLayout) r5
            int r6 = r9.f1570l
            r5.k0(r6, r4, r10)
        L_0x00f3:
            int r10 = r9.f1567i
            int r5 = androidx.constraintlayout.motion.widget.d.f1485f
            if (r10 != r5) goto L_0x00fb
            r10 = r11
            goto L_0x0107
        L_0x00fb:
            android.view.ViewParent r10 = r11.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r10 = (androidx.constraintlayout.motion.widget.MotionLayout) r10
            int r5 = r9.f1567i
            android.view.View r10 = r10.findViewById(r5)
        L_0x0107:
            if (r1 == 0) goto L_0x0125
            java.lang.String r1 = r9.f1568j
            if (r1 == 0) goto L_0x0110
            r9.z(r1, r10)
        L_0x0110:
            int r1 = r9.f1580v
            int r5 = androidx.constraintlayout.motion.widget.d.f1485f
            if (r1 == r5) goto L_0x0125
            android.view.ViewParent r1 = r11.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r1 = (androidx.constraintlayout.motion.widget.MotionLayout) r1
            int r5 = r9.f1580v
            android.view.View[] r6 = new android.view.View[r3]
            r6[r2] = r10
            r1.M0(r5, r6)
        L_0x0125:
            if (r4 == 0) goto L_0x0143
            java.lang.String r1 = r9.f1569k
            if (r1 == 0) goto L_0x012e
            r9.z(r1, r10)
        L_0x012e:
            int r1 = r9.f1581w
            int r4 = androidx.constraintlayout.motion.widget.d.f1485f
            if (r1 == r4) goto L_0x0143
            android.view.ViewParent r1 = r11.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r1 = (androidx.constraintlayout.motion.widget.MotionLayout) r1
            int r4 = r9.f1581w
            android.view.View[] r5 = new android.view.View[r3]
            r5[r2] = r10
            r1.M0(r4, r5)
        L_0x0143:
            if (r0 == 0) goto L_0x0161
            java.lang.String r0 = r9.f1566h
            if (r0 == 0) goto L_0x014c
            r9.z(r0, r10)
        L_0x014c:
            int r0 = r9.f1582x
            int r1 = androidx.constraintlayout.motion.widget.d.f1485f
            if (r0 == r1) goto L_0x0161
            android.view.ViewParent r11 = r11.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r11 = (androidx.constraintlayout.motion.widget.MotionLayout) r11
            int r0 = r9.f1582x
            android.view.View[] r1 = new android.view.View[r3]
            r1[r2] = r10
            r11.M0(r0, r1)
        L_0x0161:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.k.y(float, android.view.View):void");
    }
}
