package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.f;
import f0.c;
import java.util.HashMap;
import k0.d;

public class h extends i {

    /* renamed from: h  reason: collision with root package name */
    String f1532h = null;

    /* renamed from: i  reason: collision with root package name */
    int f1533i = d.f1485f;

    /* renamed from: j  reason: collision with root package name */
    int f1534j = 0;

    /* renamed from: k  reason: collision with root package name */
    float f1535k = Float.NaN;

    /* renamed from: l  reason: collision with root package name */
    float f1536l = Float.NaN;

    /* renamed from: m  reason: collision with root package name */
    float f1537m = Float.NaN;

    /* renamed from: n  reason: collision with root package name */
    float f1538n = Float.NaN;

    /* renamed from: o  reason: collision with root package name */
    float f1539o = Float.NaN;

    /* renamed from: p  reason: collision with root package name */
    float f1540p = Float.NaN;

    /* renamed from: q  reason: collision with root package name */
    int f1541q = 0;

    /* renamed from: r  reason: collision with root package name */
    private float f1542r = Float.NaN;

    /* renamed from: s  reason: collision with root package name */
    private float f1543s = Float.NaN;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static SparseIntArray f1544a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1544a = sparseIntArray;
            sparseIntArray.append(f.KeyPosition_motionTarget, 1);
            f1544a.append(f.KeyPosition_framePosition, 2);
            f1544a.append(f.KeyPosition_transitionEasing, 3);
            f1544a.append(f.KeyPosition_curveFit, 4);
            f1544a.append(f.KeyPosition_drawPath, 5);
            f1544a.append(f.KeyPosition_percentX, 6);
            f1544a.append(f.KeyPosition_percentY, 7);
            f1544a.append(f.KeyPosition_keyPositionType, 9);
            f1544a.append(f.KeyPosition_sizePercent, 8);
            f1544a.append(f.KeyPosition_percentWidth, 11);
            f1544a.append(f.KeyPosition_percentHeight, 12);
            f1544a.append(f.KeyPosition_pathMotionArc, 10);
        }

        /* access modifiers changed from: private */
        public static void b(h hVar, TypedArray typedArray) {
            float f10;
            int indexCount = typedArray.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArray.getIndex(i10);
                switch (f1544a.get(index)) {
                    case 1:
                        if (MotionLayout.O1) {
                            int resourceId = typedArray.getResourceId(index, hVar.f1487b);
                            hVar.f1487b = resourceId;
                            if (resourceId != -1) {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type != 3) {
                            hVar.f1487b = typedArray.getResourceId(index, hVar.f1487b);
                            continue;
                        }
                        hVar.f1488c = typedArray.getString(index);
                        break;
                    case 2:
                        hVar.f1486a = typedArray.getInt(index, hVar.f1486a);
                        continue;
                    case 3:
                        hVar.f1532h = typedArray.peekValue(index).type == 3 ? typedArray.getString(index) : c.f13857c[typedArray.getInteger(index, 0)];
                        continue;
                    case 4:
                        hVar.f1545g = typedArray.getInteger(index, hVar.f1545g);
                        continue;
                    case 5:
                        hVar.f1534j = typedArray.getInt(index, hVar.f1534j);
                        continue;
                    case 6:
                        hVar.f1537m = typedArray.getFloat(index, hVar.f1537m);
                        continue;
                    case 7:
                        hVar.f1538n = typedArray.getFloat(index, hVar.f1538n);
                        continue;
                    case 8:
                        f10 = typedArray.getFloat(index, hVar.f1536l);
                        hVar.f1535k = f10;
                        break;
                    case 9:
                        hVar.f1541q = typedArray.getInt(index, hVar.f1541q);
                        continue;
                    case 10:
                        hVar.f1533i = typedArray.getInt(index, hVar.f1533i);
                        continue;
                    case 11:
                        hVar.f1535k = typedArray.getFloat(index, hVar.f1535k);
                        continue;
                    case 12:
                        f10 = typedArray.getFloat(index, hVar.f1536l);
                        break;
                    default:
                        Log.e("KeyPosition", "unused attribute 0x" + Integer.toHexString(index) + "   " + f1544a.get(index));
                        continue;
                }
                hVar.f1536l = f10;
            }
            if (hVar.f1486a == -1) {
                Log.e("KeyPosition", "no frame position");
            }
        }
    }

    public h() {
        this.f1489d = 2;
    }

    public void a(HashMap<String, d> hashMap) {
    }

    /* renamed from: b */
    public d clone() {
        return new h().c(this);
    }

    public d c(d dVar) {
        super.c(dVar);
        h hVar = (h) dVar;
        this.f1532h = hVar.f1532h;
        this.f1533i = hVar.f1533i;
        this.f1534j = hVar.f1534j;
        this.f1535k = hVar.f1535k;
        this.f1536l = Float.NaN;
        this.f1537m = hVar.f1537m;
        this.f1538n = hVar.f1538n;
        this.f1539o = hVar.f1539o;
        this.f1540p = hVar.f1540p;
        this.f1542r = hVar.f1542r;
        this.f1543s = hVar.f1543s;
        return this;
    }

    public void e(Context context, AttributeSet attributeSet) {
        a.b(this, context.obtainStyledAttributes(attributeSet, f.KeyPosition));
    }

    public void m(int i10) {
        this.f1541q = i10;
    }

    public void n(String str, Object obj) {
        float f10;
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1812823328:
                if (str.equals("transitionEasing")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1127236479:
                if (str.equals("percentWidth")) {
                    c10 = 1;
                    break;
                }
                break;
            case -1017587252:
                if (str.equals("percentHeight")) {
                    c10 = 2;
                    break;
                }
                break;
            case -827014263:
                if (str.equals("drawPath")) {
                    c10 = 3;
                    break;
                }
                break;
            case -200259324:
                if (str.equals("sizePercent")) {
                    c10 = 4;
                    break;
                }
                break;
            case 428090547:
                if (str.equals("percentX")) {
                    c10 = 5;
                    break;
                }
                break;
            case 428090548:
                if (str.equals("percentY")) {
                    c10 = 6;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                this.f1532h = obj.toString();
                return;
            case 1:
                this.f1535k = k(obj);
                return;
            case 2:
                f10 = k(obj);
                break;
            case 3:
                this.f1534j = l(obj);
                return;
            case 4:
                f10 = k(obj);
                this.f1535k = f10;
                break;
            case 5:
                this.f1537m = k(obj);
                return;
            case 6:
                this.f1538n = k(obj);
                return;
            default:
                return;
        }
        this.f1536l = f10;
    }
}
