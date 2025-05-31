package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.f;
import androidx.core.widget.NestedScrollView;
import com.android.volley.toolbox.k;
import org.xmlpull.v1.XmlPullParser;

class q {
    private static final float[][] G = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
    private static final float[][] H = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};
    private float A = 10.0f;
    private float B = 1.0f;
    private float C = Float.NaN;
    private float D = Float.NaN;
    private int E = 0;
    private int F = 0;

    /* renamed from: a  reason: collision with root package name */
    private int f1692a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f1693b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f1694c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f1695d = -1;

    /* renamed from: e  reason: collision with root package name */
    private int f1696e = -1;

    /* renamed from: f  reason: collision with root package name */
    private int f1697f = -1;

    /* renamed from: g  reason: collision with root package name */
    private float f1698g = 0.5f;

    /* renamed from: h  reason: collision with root package name */
    private float f1699h = 0.5f;

    /* renamed from: i  reason: collision with root package name */
    float f1700i = 0.5f;

    /* renamed from: j  reason: collision with root package name */
    float f1701j = 0.5f;

    /* renamed from: k  reason: collision with root package name */
    private int f1702k = -1;

    /* renamed from: l  reason: collision with root package name */
    boolean f1703l = false;

    /* renamed from: m  reason: collision with root package name */
    private float f1704m = 0.0f;

    /* renamed from: n  reason: collision with root package name */
    private float f1705n = 1.0f;

    /* renamed from: o  reason: collision with root package name */
    private boolean f1706o = false;

    /* renamed from: p  reason: collision with root package name */
    private float[] f1707p = new float[2];

    /* renamed from: q  reason: collision with root package name */
    private int[] f1708q = new int[2];

    /* renamed from: r  reason: collision with root package name */
    private float f1709r;

    /* renamed from: s  reason: collision with root package name */
    private float f1710s;

    /* renamed from: t  reason: collision with root package name */
    private final MotionLayout f1711t;

    /* renamed from: u  reason: collision with root package name */
    private float f1712u = 4.0f;

    /* renamed from: v  reason: collision with root package name */
    private float f1713v = 1.2f;

    /* renamed from: w  reason: collision with root package name */
    private boolean f1714w = true;

    /* renamed from: x  reason: collision with root package name */
    private float f1715x = 1.0f;

    /* renamed from: y  reason: collision with root package name */
    private int f1716y = 0;

    /* renamed from: z  reason: collision with root package name */
    private float f1717z = 10.0f;

    class a implements View.OnTouchListener {
        a(q qVar) {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    class b implements NestedScrollView.b {
        b(q qVar) {
        }

        public void onScrollChange(NestedScrollView nestedScrollView, int i10, int i11, int i12, int i13) {
        }
    }

    q(Context context, MotionLayout motionLayout, XmlPullParser xmlPullParser) {
        this.f1711t = motionLayout;
        c(context, Xml.asAttributeSet(xmlPullParser));
    }

    private void b(TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArray.getIndex(i10);
            if (index == f.OnSwipe_touchAnchorId) {
                this.f1695d = typedArray.getResourceId(index, this.f1695d);
            } else if (index == f.OnSwipe_touchAnchorSide) {
                int i11 = typedArray.getInt(index, this.f1692a);
                this.f1692a = i11;
                float[][] fArr = G;
                this.f1699h = fArr[i11][0];
                this.f1698g = fArr[i11][1];
            } else if (index == f.OnSwipe_dragDirection) {
                int i12 = typedArray.getInt(index, this.f1693b);
                this.f1693b = i12;
                float[][] fArr2 = H;
                if (i12 < fArr2.length) {
                    this.f1704m = fArr2[i12][0];
                    this.f1705n = fArr2[i12][1];
                } else {
                    this.f1705n = Float.NaN;
                    this.f1704m = Float.NaN;
                    this.f1703l = true;
                }
            } else if (index == f.OnSwipe_maxVelocity) {
                this.f1712u = typedArray.getFloat(index, this.f1712u);
            } else if (index == f.OnSwipe_maxAcceleration) {
                this.f1713v = typedArray.getFloat(index, this.f1713v);
            } else if (index == f.OnSwipe_moveWhenScrollAtTop) {
                this.f1714w = typedArray.getBoolean(index, this.f1714w);
            } else if (index == f.OnSwipe_dragScale) {
                this.f1715x = typedArray.getFloat(index, this.f1715x);
            } else if (index == f.OnSwipe_dragThreshold) {
                this.f1717z = typedArray.getFloat(index, this.f1717z);
            } else if (index == f.OnSwipe_touchRegionId) {
                this.f1696e = typedArray.getResourceId(index, this.f1696e);
            } else if (index == f.OnSwipe_onTouchUp) {
                this.f1694c = typedArray.getInt(index, this.f1694c);
            } else if (index == f.OnSwipe_nestedScrollFlags) {
                this.f1716y = typedArray.getInteger(index, 0);
            } else if (index == f.OnSwipe_limitBoundsTo) {
                this.f1697f = typedArray.getResourceId(index, 0);
            } else if (index == f.OnSwipe_rotationCenterId) {
                this.f1702k = typedArray.getResourceId(index, this.f1702k);
            } else if (index == f.OnSwipe_springDamping) {
                this.A = typedArray.getFloat(index, this.A);
            } else if (index == f.OnSwipe_springMass) {
                this.B = typedArray.getFloat(index, this.B);
            } else if (index == f.OnSwipe_springStiffness) {
                this.C = typedArray.getFloat(index, this.C);
            } else if (index == f.OnSwipe_springStopThreshold) {
                this.D = typedArray.getFloat(index, this.D);
            } else if (index == f.OnSwipe_springBoundary) {
                this.E = typedArray.getInt(index, this.E);
            } else if (index == f.OnSwipe_autoCompleteMode) {
                this.F = typedArray.getInt(index, this.F);
            }
        }
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.OnSwipe);
        b(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: package-private */
    public void A() {
        View view;
        int i10 = this.f1695d;
        if (i10 != -1) {
            view = this.f1711t.findViewById(i10);
            if (view == null) {
                Log.e("TouchResponse", "cannot find TouchAnchorId @id/" + a.c(this.f1711t.getContext(), this.f1695d));
            }
        } else {
            view = null;
        }
        if (view instanceof NestedScrollView) {
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            nestedScrollView.setOnTouchListener(new a(this));
            nestedScrollView.setOnScrollChangeListener(new b(this));
        }
    }

    /* access modifiers changed from: package-private */
    public float a(float f10, float f11) {
        return (f10 * this.f1704m) + (f11 * this.f1705n);
    }

    public int d() {
        return this.F;
    }

    public int e() {
        return this.f1716y;
    }

    /* access modifiers changed from: package-private */
    public RectF f(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i10 = this.f1697f;
        if (i10 == -1 || (findViewById = viewGroup.findViewById(i10)) == null) {
            return null;
        }
        rectF.set((float) findViewById.getLeft(), (float) findViewById.getTop(), (float) findViewById.getRight(), (float) findViewById.getBottom());
        return rectF;
    }

    /* access modifiers changed from: package-private */
    public float g() {
        return this.f1713v;
    }

    public float h() {
        return this.f1712u;
    }

    /* access modifiers changed from: package-private */
    public boolean i() {
        return this.f1714w;
    }

    /* access modifiers changed from: package-private */
    public float j(float f10, float f11) {
        this.f1711t.l0(this.f1695d, this.f1711t.getProgress(), this.f1699h, this.f1698g, this.f1707p);
        float f12 = this.f1704m;
        if (f12 != 0.0f) {
            float[] fArr = this.f1707p;
            if (fArr[0] == 0.0f) {
                fArr[0] = 1.0E-7f;
            }
            return (f10 * f12) / fArr[0];
        }
        float[] fArr2 = this.f1707p;
        if (fArr2[1] == 0.0f) {
            fArr2[1] = 1.0E-7f;
        }
        return (f11 * this.f1705n) / fArr2[1];
    }

    public int k() {
        return this.E;
    }

    public float l() {
        return this.A;
    }

    public float m() {
        return this.B;
    }

    public float n() {
        return this.C;
    }

    public float o() {
        return this.D;
    }

    /* access modifiers changed from: package-private */
    public RectF p(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i10 = this.f1696e;
        if (i10 == -1 || (findViewById = viewGroup.findViewById(i10)) == null) {
            return null;
        }
        rectF.set((float) findViewById.getLeft(), (float) findViewById.getTop(), (float) findViewById.getRight(), (float) findViewById.getBottom());
        return rectF;
    }

    /* access modifiers changed from: package-private */
    public int q() {
        return this.f1696e;
    }

    /* access modifiers changed from: package-private */
    public boolean r() {
        return this.f1706o;
    }

    /* access modifiers changed from: package-private */
    public void s(MotionEvent motionEvent, MotionLayout.g gVar, int i10, p pVar) {
        int i11;
        MotionLayout.g gVar2 = gVar;
        if (this.f1703l) {
            t(motionEvent, gVar, i10, pVar);
            return;
        }
        gVar2.c(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f1709r = motionEvent.getRawX();
            this.f1710s = motionEvent.getRawY();
            this.f1706o = false;
        } else if (action == 1) {
            this.f1706o = false;
            gVar2.f(k.DEFAULT_IMAGE_TIMEOUT_MS);
            float e10 = gVar.e();
            float d10 = gVar.d();
            float progress = this.f1711t.getProgress();
            int i12 = this.f1695d;
            if (i12 != -1) {
                this.f1711t.l0(i12, progress, this.f1699h, this.f1698g, this.f1707p);
            } else {
                float min = (float) Math.min(this.f1711t.getWidth(), this.f1711t.getHeight());
                float[] fArr = this.f1707p;
                fArr[1] = this.f1705n * min;
                fArr[0] = min * this.f1704m;
            }
            float f10 = this.f1704m;
            float[] fArr2 = this.f1707p;
            float f11 = fArr2[0];
            float f12 = fArr2[1];
            float f13 = f10 != 0.0f ? e10 / fArr2[0] : d10 / fArr2[1];
            float f14 = !Float.isNaN(f13) ? (f13 / 3.0f) + progress : progress;
            if (f14 != 0.0f && f14 != 1.0f && (i11 = this.f1694c) != 3) {
                float f15 = ((double) f14) < 0.5d ? 0.0f : 1.0f;
                if (i11 == 6) {
                    if (progress + f13 < 0.0f) {
                        f13 = Math.abs(f13);
                    }
                    f15 = 1.0f;
                }
                if (this.f1694c == 7) {
                    if (progress + f13 > 1.0f) {
                        f13 = -Math.abs(f13);
                    }
                    f15 = 0.0f;
                }
                this.f1711t.C0(this.f1694c, f15, f13);
                if (0.0f < progress && 1.0f > progress) {
                    return;
                }
            } else if (0.0f < f14 && 1.0f > f14) {
                return;
            }
            this.f1711t.setState(MotionLayout.k.FINISHED);
        } else if (action == 2) {
            float rawY = motionEvent.getRawY() - this.f1710s;
            float rawX = motionEvent.getRawX() - this.f1709r;
            if (Math.abs((this.f1704m * rawX) + (this.f1705n * rawY)) > this.f1717z || this.f1706o) {
                float progress2 = this.f1711t.getProgress();
                if (!this.f1706o) {
                    this.f1706o = true;
                    this.f1711t.setProgress(progress2);
                }
                int i13 = this.f1695d;
                if (i13 != -1) {
                    this.f1711t.l0(i13, progress2, this.f1699h, this.f1698g, this.f1707p);
                } else {
                    float min2 = (float) Math.min(this.f1711t.getWidth(), this.f1711t.getHeight());
                    float[] fArr3 = this.f1707p;
                    fArr3[1] = this.f1705n * min2;
                    fArr3[0] = min2 * this.f1704m;
                }
                float f16 = this.f1704m;
                float[] fArr4 = this.f1707p;
                if (((double) Math.abs(((f16 * fArr4[0]) + (this.f1705n * fArr4[1])) * this.f1715x)) < 0.01d) {
                    float[] fArr5 = this.f1707p;
                    fArr5[0] = 0.01f;
                    fArr5[1] = 0.01f;
                }
                float max = Math.max(Math.min(progress2 + (this.f1704m != 0.0f ? rawX / this.f1707p[0] : rawY / this.f1707p[1]), 1.0f), 0.0f);
                if (this.f1694c == 6) {
                    max = Math.max(max, 0.01f);
                }
                if (this.f1694c == 7) {
                    max = Math.min(max, 0.99f);
                }
                float progress3 = this.f1711t.getProgress();
                if (max != progress3) {
                    int i14 = (progress3 > 0.0f ? 1 : (progress3 == 0.0f ? 0 : -1));
                    if (i14 == 0 || progress3 == 1.0f) {
                        this.f1711t.f0(i14 == 0);
                    }
                    this.f1711t.setProgress(max);
                    gVar2.f(k.DEFAULT_IMAGE_TIMEOUT_MS);
                    this.f1711t.f1435x = this.f1704m != 0.0f ? gVar.e() / this.f1707p[0] : gVar.d() / this.f1707p[1];
                } else {
                    this.f1711t.f1435x = 0.0f;
                }
                this.f1709r = motionEvent.getRawX();
                this.f1710s = motionEvent.getRawY();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0267  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x028b  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x02a8  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x02b4  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x02c5  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x030f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void t(android.view.MotionEvent r24, androidx.constraintlayout.motion.widget.MotionLayout.g r25, int r26, androidx.constraintlayout.motion.widget.p r27) {
        /*
            r23 = this;
            r0 = r23
            r1 = r25
            r2 = r24
            r1.c(r2)
            int r3 = r24.getAction()
            r4 = 0
            if (r3 == 0) goto L_0x0322
            r5 = 1135869952(0x43b40000, float:360.0)
            r6 = -1
            r9 = 1073741824(0x40000000, float:2.0)
            r10 = 1
            if (r3 == r10) goto L_0x01c1
            r11 = 2
            if (r3 == r11) goto L_0x001d
            goto L_0x0330
        L_0x001d:
            r24.getRawY()
            r24.getRawX()
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r0.f1711t
            int r3 = r3.getWidth()
            float r3 = (float) r3
            float r3 = r3 / r9
            androidx.constraintlayout.motion.widget.MotionLayout r11 = r0.f1711t
            int r11 = r11.getHeight()
            float r11 = (float) r11
            float r11 = r11 / r9
            int r12 = r0.f1702k
            if (r12 == r6) goto L_0x006c
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r0.f1711t
            android.view.View r3 = r3.findViewById(r12)
            androidx.constraintlayout.motion.widget.MotionLayout r11 = r0.f1711t
            int[] r12 = r0.f1708q
            r11.getLocationOnScreen(r12)
            int[] r11 = r0.f1708q
            r11 = r11[r4]
            float r11 = (float) r11
            int r12 = r3.getLeft()
            int r13 = r3.getRight()
            int r12 = r12 + r13
            float r12 = (float) r12
            float r12 = r12 / r9
            float r11 = r11 + r12
            int[] r12 = r0.f1708q
            r12 = r12[r10]
            float r12 = (float) r12
            int r13 = r3.getTop()
            int r3 = r3.getBottom()
            int r13 = r13 + r3
            float r3 = (float) r13
            float r3 = r3 / r9
            float r3 = r3 + r12
            r22 = r11
            r11 = r3
            r3 = r22
            goto L_0x00b3
        L_0x006c:
            int r12 = r0.f1695d
            if (r12 == r6) goto L_0x00b3
            androidx.constraintlayout.motion.widget.MotionLayout r13 = r0.f1711t
            androidx.constraintlayout.motion.widget.m r12 = r13.n0(r12)
            androidx.constraintlayout.motion.widget.MotionLayout r13 = r0.f1711t
            int r12 = r12.h()
            android.view.View r12 = r13.findViewById(r12)
            if (r12 != 0) goto L_0x008a
            java.lang.String r9 = "TouchResponse"
            java.lang.String r12 = "could not find view to animate to"
            android.util.Log.e(r9, r12)
            goto L_0x00b3
        L_0x008a:
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r0.f1711t
            int[] r11 = r0.f1708q
            r3.getLocationOnScreen(r11)
            int[] r3 = r0.f1708q
            r3 = r3[r4]
            float r3 = (float) r3
            int r11 = r12.getLeft()
            int r13 = r12.getRight()
            int r11 = r11 + r13
            float r11 = (float) r11
            float r11 = r11 / r9
            float r3 = r3 + r11
            int[] r11 = r0.f1708q
            r11 = r11[r10]
            float r11 = (float) r11
            int r13 = r12.getTop()
            int r12 = r12.getBottom()
            int r13 = r13 + r12
            float r12 = (float) r13
            float r12 = r12 / r9
            float r11 = r11 + r12
        L_0x00b3:
            float r9 = r24.getRawX()
            float r9 = r9 - r3
            float r12 = r24.getRawY()
            float r12 = r12 - r11
            float r13 = r24.getRawY()
            float r13 = r13 - r11
            double r13 = (double) r13
            float r15 = r24.getRawX()
            float r15 = r15 - r3
            r27 = r9
            double r8 = (double) r15
            double r8 = java.lang.Math.atan2(r13, r8)
            float r13 = r0.f1710s
            float r13 = r13 - r11
            double r13 = (double) r13
            float r11 = r0.f1709r
            float r11 = r11 - r3
            double r6 = (double) r11
            double r6 = java.lang.Math.atan2(r13, r6)
            double r6 = r8 - r6
            r13 = 4640537203540230144(0x4066800000000000, double:180.0)
            double r6 = r6 * r13
            r13 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            double r6 = r6 / r13
            float r6 = (float) r6
            r7 = 1134886912(0x43a50000, float:330.0)
            int r7 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r7 <= 0) goto L_0x00f2
            float r6 = r6 - r5
            goto L_0x00f9
        L_0x00f2:
            r7 = -1012596736(0xffffffffc3a50000, float:-330.0)
            int r7 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r7 >= 0) goto L_0x00f9
            float r6 = r6 + r5
        L_0x00f9:
            float r7 = java.lang.Math.abs(r6)
            double r13 = (double) r7
            r16 = 4576918229304087675(0x3f847ae147ae147b, double:0.01)
            int r7 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
            if (r7 > 0) goto L_0x010b
            boolean r7 = r0.f1706o
            if (r7 == 0) goto L_0x0330
        L_0x010b:
            androidx.constraintlayout.motion.widget.MotionLayout r7 = r0.f1711t
            float r7 = r7.getProgress()
            boolean r11 = r0.f1706o
            if (r11 != 0) goto L_0x011c
            r0.f1706o = r10
            androidx.constraintlayout.motion.widget.MotionLayout r11 = r0.f1711t
            r11.setProgress(r7)
        L_0x011c:
            int r11 = r0.f1695d
            r3 = -1
            if (r11 == r3) goto L_0x0145
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r0.f1711t
            float r5 = r0.f1699h
            float r13 = r0.f1698g
            float[] r14 = r0.f1707p
            r16 = r3
            r17 = r11
            r18 = r7
            r19 = r5
            r20 = r13
            r21 = r14
            r16.l0(r17, r18, r19, r20, r21)
            float[] r3 = r0.f1707p
            r5 = r3[r10]
            double r13 = (double) r5
            double r13 = java.lang.Math.toDegrees(r13)
            float r5 = (float) r13
            r3[r10] = r5
            goto L_0x0149
        L_0x0145:
            float[] r3 = r0.f1707p
            r3[r10] = r5
        L_0x0149:
            float r3 = r0.f1715x
            float r6 = r6 * r3
            float[] r3 = r0.f1707p
            r3 = r3[r10]
            float r6 = r6 / r3
            float r7 = r7 + r6
            r3 = 1065353216(0x3f800000, float:1.0)
            float r5 = java.lang.Math.min(r7, r3)
            r6 = 0
            float r5 = java.lang.Math.max(r5, r6)
            androidx.constraintlayout.motion.widget.MotionLayout r7 = r0.f1711t
            float r7 = r7.getProgress()
            int r11 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r11 == 0) goto L_0x01ae
            int r6 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
            if (r6 == 0) goto L_0x016f
            int r3 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r3 != 0) goto L_0x0177
        L_0x016f:
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r0.f1711t
            if (r6 != 0) goto L_0x0174
            r4 = r10
        L_0x0174:
            r3.f0(r4)
        L_0x0177:
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r0.f1711t
            r3.setProgress(r5)
            r3 = 1000(0x3e8, float:1.401E-42)
            r1.f(r3)
            float r3 = r25.e()
            float r1 = r25.d()
            double r4 = (double) r1
            double r6 = (double) r3
            double r10 = java.lang.Math.hypot(r4, r6)
            double r3 = java.lang.Math.atan2(r4, r6)
            double r3 = r3 - r8
            double r3 = java.lang.Math.sin(r3)
            double r10 = r10 * r3
            r9 = r27
            double r3 = (double) r9
            double r5 = (double) r12
            double r3 = java.lang.Math.hypot(r3, r5)
            double r10 = r10 / r3
            float r1 = (float) r10
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r0.f1711t
            double r4 = (double) r1
            double r4 = java.lang.Math.toDegrees(r4)
            float r1 = (float) r4
            r3.f1435x = r1
            goto L_0x01b3
        L_0x01ae:
            androidx.constraintlayout.motion.widget.MotionLayout r1 = r0.f1711t
            r3 = 0
            r1.f1435x = r3
        L_0x01b3:
            float r1 = r24.getRawX()
            r0.f1709r = r1
            float r1 = r24.getRawY()
            r0.f1710s = r1
            goto L_0x0330
        L_0x01c1:
            r0.f1706o = r4
            r6 = 16
            r1.f(r6)
            float r6 = r25.e()
            float r1 = r25.d()
            androidx.constraintlayout.motion.widget.MotionLayout r7 = r0.f1711t
            float r7 = r7.getProgress()
            androidx.constraintlayout.motion.widget.MotionLayout r8 = r0.f1711t
            int r8 = r8.getWidth()
            float r8 = (float) r8
            float r8 = r8 / r9
            androidx.constraintlayout.motion.widget.MotionLayout r11 = r0.f1711t
            int r11 = r11.getHeight()
            float r11 = (float) r11
            float r11 = r11 / r9
            int r12 = r0.f1702k
            r3 = -1
            if (r12 == r3) goto L_0x021c
            androidx.constraintlayout.motion.widget.MotionLayout r8 = r0.f1711t
            android.view.View r8 = r8.findViewById(r12)
            androidx.constraintlayout.motion.widget.MotionLayout r11 = r0.f1711t
            int[] r12 = r0.f1708q
            r11.getLocationOnScreen(r12)
            int[] r11 = r0.f1708q
            r4 = r11[r4]
            float r4 = (float) r4
            int r11 = r8.getLeft()
            int r12 = r8.getRight()
            int r11 = r11 + r12
            float r11 = (float) r11
            float r11 = r11 / r9
            float r4 = r4 + r11
            int[] r11 = r0.f1708q
            r11 = r11[r10]
        L_0x020d:
            float r11 = (float) r11
            int r12 = r8.getTop()
            int r8 = r8.getBottom()
            int r12 = r12 + r8
            float r8 = (float) r12
            float r8 = r8 / r9
            float r11 = r11 + r8
            r8 = r4
            goto L_0x024e
        L_0x021c:
            int r12 = r0.f1695d
            r3 = -1
            if (r12 == r3) goto L_0x024e
            androidx.constraintlayout.motion.widget.MotionLayout r8 = r0.f1711t
            androidx.constraintlayout.motion.widget.m r8 = r8.n0(r12)
            androidx.constraintlayout.motion.widget.MotionLayout r11 = r0.f1711t
            int r8 = r8.h()
            android.view.View r8 = r11.findViewById(r8)
            androidx.constraintlayout.motion.widget.MotionLayout r11 = r0.f1711t
            int[] r12 = r0.f1708q
            r11.getLocationOnScreen(r12)
            int[] r11 = r0.f1708q
            r4 = r11[r4]
            float r4 = (float) r4
            int r11 = r8.getLeft()
            int r12 = r8.getRight()
            int r11 = r11 + r12
            float r11 = (float) r11
            float r11 = r11 / r9
            float r4 = r4 + r11
            int[] r11 = r0.f1708q
            r11 = r11[r10]
            goto L_0x020d
        L_0x024e:
            float r4 = r24.getRawX()
            float r4 = r4 - r8
            float r2 = r24.getRawY()
            float r2 = r2 - r11
            double r8 = (double) r2
            double r11 = (double) r4
            double r8 = java.lang.Math.atan2(r8, r11)
            double r8 = java.lang.Math.toDegrees(r8)
            int r11 = r0.f1695d
            r3 = -1
            if (r11 == r3) goto L_0x028b
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r0.f1711t
            float r5 = r0.f1699h
            float r12 = r0.f1698g
            float[] r13 = r0.f1707p
            r16 = r3
            r17 = r11
            r18 = r7
            r19 = r5
            r20 = r12
            r21 = r13
            r16.l0(r17, r18, r19, r20, r21)
            float[] r3 = r0.f1707p
            r5 = r3[r10]
            double r11 = (double) r5
            double r11 = java.lang.Math.toDegrees(r11)
            float r5 = (float) r11
            r3[r10] = r5
            goto L_0x028f
        L_0x028b:
            float[] r3 = r0.f1707p
            r3[r10] = r5
        L_0x028f:
            float r1 = r1 + r2
            double r1 = (double) r1
            float r6 = r6 + r4
            double r3 = (double) r6
            double r1 = java.lang.Math.atan2(r1, r3)
            double r1 = java.lang.Math.toDegrees(r1)
            double r1 = r1 - r8
            float r1 = (float) r1
            r2 = 1115291648(0x427a0000, float:62.5)
            float r1 = r1 * r2
            boolean r2 = java.lang.Float.isNaN(r1)
            r3 = 1077936128(0x40400000, float:3.0)
            if (r2 != 0) goto L_0x02b4
            float r2 = r1 * r3
            float r4 = r0.f1715x
            float r2 = r2 * r4
            float[] r4 = r0.f1707p
            r4 = r4[r10]
            float r2 = r2 / r4
            float r2 = r2 + r7
            goto L_0x02b5
        L_0x02b4:
            r2 = r7
        L_0x02b5:
            r4 = 0
            int r5 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r5 == 0) goto L_0x030f
            r4 = 1065353216(0x3f800000, float:1.0)
            int r5 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r5 == 0) goto L_0x030f
            int r4 = r0.f1694c
            r5 = 3
            if (r4 == r5) goto L_0x030f
            float r5 = r0.f1715x
            float r1 = r1 * r5
            float[] r5 = r0.f1707p
            r5 = r5[r10]
            float r1 = r1 / r5
            double r5 = (double) r2
            r8 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            int r2 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r2 >= 0) goto L_0x02d6
            r2 = 0
            goto L_0x02d8
        L_0x02d6:
            r2 = 1065353216(0x3f800000, float:1.0)
        L_0x02d8:
            r5 = 6
            if (r4 != r5) goto L_0x02e8
            float r2 = r7 + r1
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x02e6
            float r1 = java.lang.Math.abs(r1)
        L_0x02e6:
            r2 = 1065353216(0x3f800000, float:1.0)
        L_0x02e8:
            int r4 = r0.f1694c
            r5 = 7
            if (r4 != r5) goto L_0x02fb
            float r2 = r7 + r1
            r4 = 1065353216(0x3f800000, float:1.0)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x02fa
            float r1 = java.lang.Math.abs(r1)
            float r1 = -r1
        L_0x02fa:
            r2 = 0
        L_0x02fb:
            androidx.constraintlayout.motion.widget.MotionLayout r4 = r0.f1711t
            int r5 = r0.f1694c
            float r1 = r1 * r3
            r4.C0(r5, r2, r1)
            r1 = 0
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 >= 0) goto L_0x031a
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 > 0) goto L_0x0330
            goto L_0x031a
        L_0x030f:
            r1 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x031a
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 > 0) goto L_0x0330
        L_0x031a:
            androidx.constraintlayout.motion.widget.MotionLayout r1 = r0.f1711t
            androidx.constraintlayout.motion.widget.MotionLayout$k r2 = androidx.constraintlayout.motion.widget.MotionLayout.k.FINISHED
            r1.setState(r2)
            goto L_0x0330
        L_0x0322:
            float r1 = r24.getRawX()
            r0.f1709r = r1
            float r1 = r24.getRawY()
            r0.f1710s = r1
            r0.f1706o = r4
        L_0x0330:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.q.t(android.view.MotionEvent, androidx.constraintlayout.motion.widget.MotionLayout$g, int, androidx.constraintlayout.motion.widget.p):void");
    }

    public String toString() {
        if (Float.isNaN(this.f1704m)) {
            return "rotation";
        }
        return this.f1704m + " , " + this.f1705n;
    }

    /* access modifiers changed from: package-private */
    public void u(float f10, float f11) {
        float progress = this.f1711t.getProgress();
        if (!this.f1706o) {
            this.f1706o = true;
            this.f1711t.setProgress(progress);
        }
        this.f1711t.l0(this.f1695d, progress, this.f1699h, this.f1698g, this.f1707p);
        float f12 = this.f1704m;
        float[] fArr = this.f1707p;
        if (((double) Math.abs((f12 * fArr[0]) + (this.f1705n * fArr[1]))) < 0.01d) {
            float[] fArr2 = this.f1707p;
            fArr2[0] = 0.01f;
            fArr2[1] = 0.01f;
        }
        float f13 = this.f1704m;
        float max = Math.max(Math.min(progress + (f13 != 0.0f ? (f10 * f13) / this.f1707p[0] : (f11 * this.f1705n) / this.f1707p[1]), 1.0f), 0.0f);
        if (max != this.f1711t.getProgress()) {
            this.f1711t.setProgress(max);
        }
    }

    /* access modifiers changed from: package-private */
    public void v(float f10, float f11) {
        boolean z10 = false;
        this.f1706o = false;
        float progress = this.f1711t.getProgress();
        this.f1711t.l0(this.f1695d, progress, this.f1699h, this.f1698g, this.f1707p);
        float f12 = this.f1704m;
        float[] fArr = this.f1707p;
        float f13 = fArr[0];
        float f14 = this.f1705n;
        float f15 = fArr[1];
        float f16 = 0.0f;
        float f17 = f12 != 0.0f ? (f10 * f12) / fArr[0] : (f11 * f14) / fArr[1];
        if (!Float.isNaN(f17)) {
            progress += f17 / 3.0f;
        }
        if (progress != 0.0f) {
            boolean z11 = progress != 1.0f;
            int i10 = this.f1694c;
            if (i10 != 3) {
                z10 = true;
            }
            if (z10 && z11) {
                MotionLayout motionLayout = this.f1711t;
                if (((double) progress) >= 0.5d) {
                    f16 = 1.0f;
                }
                motionLayout.C0(i10, f16, f17);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void w(float f10, float f11) {
        this.f1709r = f10;
        this.f1710s = f11;
    }

    public void x(boolean z10) {
        if (z10) {
            float[][] fArr = H;
            fArr[4] = fArr[3];
            fArr[5] = fArr[2];
            float[][] fArr2 = G;
            fArr2[5] = fArr2[2];
            fArr2[6] = fArr2[1];
        } else {
            float[][] fArr3 = H;
            fArr3[4] = fArr3[2];
            fArr3[5] = fArr3[3];
            float[][] fArr4 = G;
            fArr4[5] = fArr4[1];
            fArr4[6] = fArr4[2];
        }
        float[][] fArr5 = G;
        int i10 = this.f1692a;
        this.f1699h = fArr5[i10][0];
        this.f1698g = fArr5[i10][1];
        int i11 = this.f1693b;
        float[][] fArr6 = H;
        if (i11 < fArr6.length) {
            this.f1704m = fArr6[i11][0];
            this.f1705n = fArr6[i11][1];
        }
    }

    public void y(int i10) {
        this.f1694c = i10;
    }

    /* access modifiers changed from: package-private */
    public void z(float f10, float f11) {
        this.f1709r = f10;
        this.f1710s = f11;
        this.f1706o = false;
    }
}
