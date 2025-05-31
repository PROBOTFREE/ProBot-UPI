package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.constraintlayout.motion.widget.p;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.core.view.o;
import h0.e;
import h0.l;
import h0.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class MotionLayout extends ConstraintLayout implements o {
    public static boolean O1;
    /* access modifiers changed from: private */
    public int A = -1;
    /* access modifiers changed from: private */
    public boolean A1 = false;
    /* access modifiers changed from: private */
    public int B = 0;
    int B1 = 0;
    /* access modifiers changed from: private */
    public int C = 0;
    HashMap<View, k0.e> C1 = new HashMap<>();
    private boolean D = true;
    /* access modifiers changed from: private */
    public int D1;
    HashMap<View, m> E = new HashMap<>();
    /* access modifiers changed from: private */
    public int E1;
    private long F = 0;
    Rect F1 = new Rect();
    private float G = 1.0f;
    private boolean G1 = false;
    float H = 0.0f;
    k H1 = k.UNDEFINED;
    float I = 0.0f;
    f I1 = new f();
    private long J;
    private boolean J1 = false;
    float K = 0.0f;
    private RectF K1 = new RectF();
    private boolean L;
    private View L1 = null;
    boolean M = false;
    private Matrix M1 = null;
    private j N;
    ArrayList<Integer> N1 = new ArrayList<>();
    private float O;
    private float P;
    int Q = 0;
    e R;
    private boolean S = false;
    private k0.b T = new k0.b();
    private d U = new d();
    private b V;
    int W;
    float Z0;

    /* renamed from: a0  reason: collision with root package name */
    int f1406a0;

    /* renamed from: a1  reason: collision with root package name */
    long f1407a1;

    /* renamed from: b0  reason: collision with root package name */
    boolean f1408b0 = false;

    /* renamed from: b1  reason: collision with root package name */
    float f1409b1;

    /* renamed from: c0  reason: collision with root package name */
    float f1410c0;

    /* renamed from: c1  reason: collision with root package name */
    private boolean f1411c1 = false;

    /* renamed from: d1  reason: collision with root package name */
    private ArrayList<MotionHelper> f1412d1 = null;

    /* renamed from: e1  reason: collision with root package name */
    private ArrayList<MotionHelper> f1413e1 = null;

    /* renamed from: f1  reason: collision with root package name */
    private ArrayList<MotionHelper> f1414f1 = null;

    /* renamed from: g1  reason: collision with root package name */
    private CopyOnWriteArrayList<j> f1415g1 = null;

    /* renamed from: h1  reason: collision with root package name */
    private int f1416h1 = 0;

    /* renamed from: i1  reason: collision with root package name */
    private long f1417i1 = -1;

    /* renamed from: j1  reason: collision with root package name */
    private float f1418j1 = 0.0f;

    /* renamed from: k1  reason: collision with root package name */
    private int f1419k1 = 0;

    /* renamed from: l1  reason: collision with root package name */
    private float f1420l1 = 0.0f;

    /* renamed from: m1  reason: collision with root package name */
    protected boolean f1421m1 = false;

    /* renamed from: n1  reason: collision with root package name */
    int f1422n1;

    /* renamed from: o1  reason: collision with root package name */
    int f1423o1;

    /* renamed from: p1  reason: collision with root package name */
    int f1424p1;

    /* renamed from: q1  reason: collision with root package name */
    int f1425q1;

    /* renamed from: r1  reason: collision with root package name */
    int f1426r1;

    /* renamed from: s1  reason: collision with root package name */
    int f1427s1;

    /* renamed from: t1  reason: collision with root package name */
    float f1428t1;

    /* renamed from: u  reason: collision with root package name */
    p f1429u;

    /* renamed from: u1  reason: collision with root package name */
    private f0.d f1430u1 = new f0.d();

    /* renamed from: v  reason: collision with root package name */
    Interpolator f1431v;

    /* renamed from: v1  reason: collision with root package name */
    private boolean f1432v1 = false;

    /* renamed from: w  reason: collision with root package name */
    Interpolator f1433w = null;
    /* access modifiers changed from: private */

    /* renamed from: w1  reason: collision with root package name */
    public i f1434w1;

    /* renamed from: x  reason: collision with root package name */
    float f1435x = 0.0f;

    /* renamed from: x1  reason: collision with root package name */
    private Runnable f1436x1 = null;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public int f1437y = -1;

    /* renamed from: y1  reason: collision with root package name */
    private int[] f1438y1 = null;

    /* renamed from: z  reason: collision with root package name */
    int f1439z = -1;

    /* renamed from: z1  reason: collision with root package name */
    int f1440z1 = 0;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f1441a;

        a(MotionLayout motionLayout, View view) {
            this.f1441a = view;
        }

        public void run() {
            this.f1441a.setNestedScrollingEnabled(true);
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            MotionLayout.this.f1434w1.a();
        }
    }

    static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1443a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.constraintlayout.motion.widget.MotionLayout$k[] r0 = androidx.constraintlayout.motion.widget.MotionLayout.k.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1443a = r0
                androidx.constraintlayout.motion.widget.MotionLayout$k r1 = androidx.constraintlayout.motion.widget.MotionLayout.k.UNDEFINED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f1443a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.motion.widget.MotionLayout$k r1 = androidx.constraintlayout.motion.widget.MotionLayout.k.SETUP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f1443a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.motion.widget.MotionLayout$k r1 = androidx.constraintlayout.motion.widget.MotionLayout.k.MOVING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f1443a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.motion.widget.MotionLayout$k r1 = androidx.constraintlayout.motion.widget.MotionLayout.k.FINISHED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.c.<clinit>():void");
        }
    }

    class d extends n {

        /* renamed from: a  reason: collision with root package name */
        float f1444a = 0.0f;

        /* renamed from: b  reason: collision with root package name */
        float f1445b = 0.0f;

        /* renamed from: c  reason: collision with root package name */
        float f1446c;

        d() {
        }

        public float a() {
            return MotionLayout.this.f1435x;
        }

        public void b(float f10, float f11, float f12) {
            this.f1444a = f10;
            this.f1445b = f11;
            this.f1446c = f12;
        }

        public float getInterpolation(float f10) {
            float f11;
            float f12 = this.f1444a;
            if (f12 > 0.0f) {
                float f13 = this.f1446c;
                if (f12 / f13 < f10) {
                    f10 = f12 / f13;
                }
                MotionLayout.this.f1435x = f12 - (f13 * f10);
                f11 = (f12 * f10) - (((f13 * f10) * f10) / 2.0f);
            } else {
                float f14 = this.f1446c;
                if ((-f12) / f14 < f10) {
                    f10 = (-f12) / f14;
                }
                MotionLayout.this.f1435x = (f14 * f10) + f12;
                f11 = (f12 * f10) + (((f14 * f10) * f10) / 2.0f);
            }
            return f11 + this.f1445b;
        }
    }

    private class e {

        /* renamed from: a  reason: collision with root package name */
        float[] f1448a;

        /* renamed from: b  reason: collision with root package name */
        int[] f1449b;

        /* renamed from: c  reason: collision with root package name */
        float[] f1450c;

        /* renamed from: d  reason: collision with root package name */
        Path f1451d;

        /* renamed from: e  reason: collision with root package name */
        Paint f1452e;

        /* renamed from: f  reason: collision with root package name */
        Paint f1453f;

        /* renamed from: g  reason: collision with root package name */
        Paint f1454g;

        /* renamed from: h  reason: collision with root package name */
        Paint f1455h;

        /* renamed from: i  reason: collision with root package name */
        Paint f1456i;

        /* renamed from: j  reason: collision with root package name */
        private float[] f1457j;

        /* renamed from: k  reason: collision with root package name */
        DashPathEffect f1458k;

        /* renamed from: l  reason: collision with root package name */
        int f1459l;

        /* renamed from: m  reason: collision with root package name */
        Rect f1460m = new Rect();

        /* renamed from: n  reason: collision with root package name */
        boolean f1461n = false;

        /* renamed from: o  reason: collision with root package name */
        int f1462o = 1;

        public e() {
            Paint paint = new Paint();
            this.f1452e = paint;
            paint.setAntiAlias(true);
            this.f1452e.setColor(-21965);
            this.f1452e.setStrokeWidth(2.0f);
            this.f1452e.setStyle(Paint.Style.STROKE);
            Paint paint2 = new Paint();
            this.f1453f = paint2;
            paint2.setAntiAlias(true);
            this.f1453f.setColor(-2067046);
            this.f1453f.setStrokeWidth(2.0f);
            this.f1453f.setStyle(Paint.Style.STROKE);
            Paint paint3 = new Paint();
            this.f1454g = paint3;
            paint3.setAntiAlias(true);
            this.f1454g.setColor(-13391360);
            this.f1454g.setStrokeWidth(2.0f);
            this.f1454g.setStyle(Paint.Style.STROKE);
            Paint paint4 = new Paint();
            this.f1455h = paint4;
            paint4.setAntiAlias(true);
            this.f1455h.setColor(-13391360);
            this.f1455h.setTextSize(MotionLayout.this.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.f1457j = new float[8];
            Paint paint5 = new Paint();
            this.f1456i = paint5;
            paint5.setAntiAlias(true);
            DashPathEffect dashPathEffect = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.f1458k = dashPathEffect;
            this.f1454g.setPathEffect(dashPathEffect);
            this.f1450c = new float[100];
            this.f1449b = new int[50];
            if (this.f1461n) {
                this.f1452e.setStrokeWidth(8.0f);
                this.f1456i.setStrokeWidth(8.0f);
                this.f1453f.setStrokeWidth(8.0f);
                this.f1462o = 4;
            }
        }

        private void c(Canvas canvas) {
            canvas.drawLines(this.f1448a, this.f1452e);
        }

        private void d(Canvas canvas) {
            boolean z10 = false;
            boolean z11 = false;
            for (int i10 = 0; i10 < this.f1459l; i10++) {
                int[] iArr = this.f1449b;
                if (iArr[i10] == 1) {
                    z10 = true;
                }
                if (iArr[i10] == 0) {
                    z11 = true;
                }
            }
            if (z10) {
                g(canvas);
            }
            if (z11) {
                e(canvas);
            }
        }

        private void e(Canvas canvas) {
            float[] fArr = this.f1448a;
            float f10 = fArr[0];
            float f11 = fArr[1];
            float f12 = fArr[fArr.length - 2];
            float f13 = fArr[fArr.length - 1];
            canvas.drawLine(Math.min(f10, f12), Math.max(f11, f13), Math.max(f10, f12), Math.max(f11, f13), this.f1454g);
            canvas.drawLine(Math.min(f10, f12), Math.min(f11, f13), Math.min(f10, f12), Math.max(f11, f13), this.f1454g);
        }

        private void f(Canvas canvas, float f10, float f11) {
            Canvas canvas2 = canvas;
            float[] fArr = this.f1448a;
            float f12 = fArr[0];
            float f13 = fArr[1];
            float f14 = fArr[fArr.length - 2];
            float f15 = fArr[fArr.length - 1];
            float min = Math.min(f12, f14);
            float max = Math.max(f13, f15);
            float min2 = f10 - Math.min(f12, f14);
            float max2 = Math.max(f13, f15) - f11;
            String str = "" + (((float) ((int) (((double) ((min2 * 100.0f) / Math.abs(f14 - f12))) + 0.5d))) / 100.0f);
            l(str, this.f1455h);
            canvas2.drawText(str, ((min2 / 2.0f) - ((float) (this.f1460m.width() / 2))) + min, f11 - 20.0f, this.f1455h);
            canvas.drawLine(f10, f11, Math.min(f12, f14), f11, this.f1454g);
            String str2 = "" + (((float) ((int) (((double) ((max2 * 100.0f) / Math.abs(f15 - f13))) + 0.5d))) / 100.0f);
            l(str2, this.f1455h);
            canvas2.drawText(str2, f10 + 5.0f, max - ((max2 / 2.0f) - ((float) (this.f1460m.height() / 2))), this.f1455h);
            canvas.drawLine(f10, f11, f10, Math.max(f13, f15), this.f1454g);
        }

        private void g(Canvas canvas) {
            float[] fArr = this.f1448a;
            canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.f1454g);
        }

        private void h(Canvas canvas, float f10, float f11) {
            float[] fArr = this.f1448a;
            float f12 = fArr[0];
            float f13 = fArr[1];
            float f14 = fArr[fArr.length - 2];
            float f15 = fArr[fArr.length - 1];
            float hypot = (float) Math.hypot((double) (f12 - f14), (double) (f13 - f15));
            float f16 = f14 - f12;
            float f17 = f15 - f13;
            float f18 = (((f10 - f12) * f16) + ((f11 - f13) * f17)) / (hypot * hypot);
            float f19 = f12 + (f16 * f18);
            float f20 = f13 + (f18 * f17);
            Path path = new Path();
            path.moveTo(f10, f11);
            path.lineTo(f19, f20);
            float hypot2 = (float) Math.hypot((double) (f19 - f10), (double) (f20 - f11));
            String str = "" + (((float) ((int) ((hypot2 * 100.0f) / hypot))) / 100.0f);
            l(str, this.f1455h);
            canvas.drawTextOnPath(str, path, (hypot2 / 2.0f) - ((float) (this.f1460m.width() / 2)), -20.0f, this.f1455h);
            canvas.drawLine(f10, f11, f19, f20, this.f1454g);
        }

        private void i(Canvas canvas, float f10, float f11, int i10, int i11) {
            Canvas canvas2 = canvas;
            String str = "" + (((float) ((int) (((double) (((f10 - ((float) (i10 / 2))) * 100.0f) / ((float) (MotionLayout.this.getWidth() - i10)))) + 0.5d))) / 100.0f);
            l(str, this.f1455h);
            canvas2.drawText(str, ((f10 / 2.0f) - ((float) (this.f1460m.width() / 2))) + 0.0f, f11 - 20.0f, this.f1455h);
            canvas.drawLine(f10, f11, Math.min(0.0f, 1.0f), f11, this.f1454g);
            String str2 = "" + (((float) ((int) (((double) (((f11 - ((float) (i11 / 2))) * 100.0f) / ((float) (MotionLayout.this.getHeight() - i11)))) + 0.5d))) / 100.0f);
            l(str2, this.f1455h);
            canvas2.drawText(str2, f10 + 5.0f, 0.0f - ((f11 / 2.0f) - ((float) (this.f1460m.height() / 2))), this.f1455h);
            canvas.drawLine(f10, f11, f10, Math.max(0.0f, 1.0f), this.f1454g);
        }

        private void j(Canvas canvas, m mVar) {
            this.f1451d.reset();
            for (int i10 = 0; i10 <= 50; i10++) {
                mVar.e(((float) i10) / ((float) 50), this.f1457j, 0);
                Path path = this.f1451d;
                float[] fArr = this.f1457j;
                path.moveTo(fArr[0], fArr[1]);
                Path path2 = this.f1451d;
                float[] fArr2 = this.f1457j;
                path2.lineTo(fArr2[2], fArr2[3]);
                Path path3 = this.f1451d;
                float[] fArr3 = this.f1457j;
                path3.lineTo(fArr3[4], fArr3[5]);
                Path path4 = this.f1451d;
                float[] fArr4 = this.f1457j;
                path4.lineTo(fArr4[6], fArr4[7]);
                this.f1451d.close();
            }
            this.f1452e.setColor(1140850688);
            canvas.translate(2.0f, 2.0f);
            canvas.drawPath(this.f1451d, this.f1452e);
            canvas.translate(-2.0f, -2.0f);
            this.f1452e.setColor(-65536);
            canvas.drawPath(this.f1451d, this.f1452e);
        }

        private void k(Canvas canvas, int i10, int i11, m mVar) {
            int i12;
            int i13;
            float f10;
            float f11;
            Canvas canvas2 = canvas;
            int i14 = i10;
            m mVar2 = mVar;
            View view = mVar2.f1605b;
            if (view != null) {
                i13 = view.getWidth();
                i12 = mVar2.f1605b.getHeight();
            } else {
                i13 = 0;
                i12 = 0;
            }
            for (int i15 = 1; i15 < i11 - 1; i15++) {
                if (i14 != 4 || this.f1449b[i15 - 1] != 0) {
                    float[] fArr = this.f1450c;
                    int i16 = i15 * 2;
                    float f12 = fArr[i16];
                    float f13 = fArr[i16 + 1];
                    this.f1451d.reset();
                    this.f1451d.moveTo(f12, f13 + 10.0f);
                    this.f1451d.lineTo(f12 + 10.0f, f13);
                    this.f1451d.lineTo(f12, f13 - 10.0f);
                    this.f1451d.lineTo(f12 - 10.0f, f13);
                    this.f1451d.close();
                    int i17 = i15 - 1;
                    mVar2.q(i17);
                    if (i14 == 4) {
                        int[] iArr = this.f1449b;
                        if (iArr[i17] == 1) {
                            h(canvas2, f12 - 0.0f, f13 - 0.0f);
                        } else if (iArr[i17] == 0) {
                            f(canvas2, f12 - 0.0f, f13 - 0.0f);
                        } else if (iArr[i17] == 2) {
                            f11 = f13;
                            f10 = f12;
                            i(canvas, f12 - 0.0f, f13 - 0.0f, i13, i12);
                            canvas2.drawPath(this.f1451d, this.f1456i);
                        }
                        f11 = f13;
                        f10 = f12;
                        canvas2.drawPath(this.f1451d, this.f1456i);
                    } else {
                        f11 = f13;
                        f10 = f12;
                    }
                    if (i14 == 2) {
                        h(canvas2, f10 - 0.0f, f11 - 0.0f);
                    }
                    if (i14 == 3) {
                        f(canvas2, f10 - 0.0f, f11 - 0.0f);
                    }
                    if (i14 == 6) {
                        i(canvas, f10 - 0.0f, f11 - 0.0f, i13, i12);
                    }
                    canvas2.drawPath(this.f1451d, this.f1456i);
                }
            }
            float[] fArr2 = this.f1448a;
            if (fArr2.length > 1) {
                canvas2.drawCircle(fArr2[0], fArr2[1], 8.0f, this.f1453f);
                float[] fArr3 = this.f1448a;
                canvas2.drawCircle(fArr3[fArr3.length - 2], fArr3[fArr3.length - 1], 8.0f, this.f1453f);
            }
        }

        public void a(Canvas canvas, HashMap<View, m> hashMap, int i10, int i11) {
            if (hashMap != null && hashMap.size() != 0) {
                canvas.save();
                if (!MotionLayout.this.isInEditMode() && (i11 & 1) == 2) {
                    String str = MotionLayout.this.getContext().getResources().getResourceName(MotionLayout.this.A) + ":" + MotionLayout.this.getProgress();
                    canvas.drawText(str, 10.0f, (float) (MotionLayout.this.getHeight() - 30), this.f1455h);
                    canvas.drawText(str, 11.0f, (float) (MotionLayout.this.getHeight() - 29), this.f1452e);
                }
                for (m next : hashMap.values()) {
                    int m10 = next.m();
                    if (i11 > 0 && m10 == 0) {
                        m10 = 1;
                    }
                    if (m10 != 0) {
                        this.f1459l = next.c(this.f1450c, this.f1449b);
                        if (m10 >= 1) {
                            int i12 = i10 / 16;
                            float[] fArr = this.f1448a;
                            if (fArr == null || fArr.length != i12 * 2) {
                                this.f1448a = new float[(i12 * 2)];
                                this.f1451d = new Path();
                            }
                            int i13 = this.f1462o;
                            canvas.translate((float) i13, (float) i13);
                            this.f1452e.setColor(1996488704);
                            this.f1456i.setColor(1996488704);
                            this.f1453f.setColor(1996488704);
                            this.f1454g.setColor(1996488704);
                            next.d(this.f1448a, i12);
                            b(canvas, m10, this.f1459l, next);
                            this.f1452e.setColor(-21965);
                            this.f1453f.setColor(-2067046);
                            this.f1456i.setColor(-2067046);
                            this.f1454g.setColor(-13391360);
                            int i14 = this.f1462o;
                            canvas.translate((float) (-i14), (float) (-i14));
                            b(canvas, m10, this.f1459l, next);
                            if (m10 == 5) {
                                j(canvas, next);
                            }
                        }
                    }
                }
                canvas.restore();
            }
        }

        public void b(Canvas canvas, int i10, int i11, m mVar) {
            if (i10 == 4) {
                d(canvas);
            }
            if (i10 == 2) {
                g(canvas);
            }
            if (i10 == 3) {
                e(canvas);
            }
            c(canvas);
            k(canvas, i10, i11, mVar);
        }

        /* access modifiers changed from: package-private */
        public void l(String str, Paint paint) {
            paint.getTextBounds(str, 0, str.length(), this.f1460m);
        }
    }

    class f {

        /* renamed from: a  reason: collision with root package name */
        h0.f f1464a = new h0.f();

        /* renamed from: b  reason: collision with root package name */
        h0.f f1465b = new h0.f();

        /* renamed from: c  reason: collision with root package name */
        androidx.constraintlayout.widget.c f1466c = null;

        /* renamed from: d  reason: collision with root package name */
        androidx.constraintlayout.widget.c f1467d = null;

        /* renamed from: e  reason: collision with root package name */
        int f1468e;

        /* renamed from: f  reason: collision with root package name */
        int f1469f;

        f() {
        }

        private void b(int i10, int i11) {
            int optimizationLevel = MotionLayout.this.getOptimizationLevel();
            MotionLayout motionLayout = MotionLayout.this;
            if (motionLayout.f1439z == motionLayout.getStartState()) {
                MotionLayout motionLayout2 = MotionLayout.this;
                h0.f fVar = this.f1465b;
                androidx.constraintlayout.widget.c cVar = this.f1467d;
                motionLayout2.v(fVar, optimizationLevel, (cVar == null || cVar.f2003c == 0) ? i10 : i11, (cVar == null || cVar.f2003c == 0) ? i11 : i10);
                androidx.constraintlayout.widget.c cVar2 = this.f1466c;
                if (cVar2 != null) {
                    MotionLayout motionLayout3 = MotionLayout.this;
                    h0.f fVar2 = this.f1464a;
                    int i12 = cVar2.f2003c;
                    int i13 = i12 == 0 ? i10 : i11;
                    if (i12 == 0) {
                        i10 = i11;
                    }
                    motionLayout3.v(fVar2, optimizationLevel, i13, i10);
                    return;
                }
                return;
            }
            androidx.constraintlayout.widget.c cVar3 = this.f1466c;
            if (cVar3 != null) {
                MotionLayout motionLayout4 = MotionLayout.this;
                h0.f fVar3 = this.f1464a;
                int i14 = cVar3.f2003c;
                motionLayout4.v(fVar3, optimizationLevel, i14 == 0 ? i10 : i11, i14 == 0 ? i11 : i10);
            }
            MotionLayout motionLayout5 = MotionLayout.this;
            h0.f fVar4 = this.f1465b;
            androidx.constraintlayout.widget.c cVar4 = this.f1467d;
            int i15 = (cVar4 == null || cVar4.f2003c == 0) ? i10 : i11;
            if (cVar4 == null || cVar4.f2003c == 0) {
                i10 = i11;
            }
            motionLayout5.v(fVar4, optimizationLevel, i15, i10);
        }

        private void j(h0.f fVar, androidx.constraintlayout.widget.c cVar) {
            SparseArray sparseArray = new SparseArray();
            Constraints.LayoutParams layoutParams = new Constraints.LayoutParams(-2, -2);
            sparseArray.clear();
            sparseArray.put(0, fVar);
            sparseArray.put(MotionLayout.this.getId(), fVar);
            if (!(cVar == null || cVar.f2003c == 0)) {
                MotionLayout motionLayout = MotionLayout.this;
                motionLayout.v(this.f1465b, motionLayout.getOptimizationLevel(), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getHeight(), 1073741824), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getWidth(), 1073741824));
            }
            Iterator<h0.e> it = fVar.v1().iterator();
            while (it.hasNext()) {
                h0.e next = it.next();
                next.D0(true);
                sparseArray.put(((View) next.u()).getId(), next);
            }
            Iterator<h0.e> it2 = fVar.v1().iterator();
            while (it2.hasNext()) {
                h0.e next2 = it2.next();
                View view = (View) next2.u();
                cVar.l(view.getId(), layoutParams);
                next2.o1(cVar.C(view.getId()));
                next2.P0(cVar.x(view.getId()));
                if (view instanceof ConstraintHelper) {
                    cVar.j((ConstraintHelper) view, next2, layoutParams, sparseArray);
                    if (view instanceof Barrier) {
                        ((Barrier) view).w();
                    }
                }
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.resolveLayoutDirection(MotionLayout.this.getLayoutDirection());
                } else {
                    layoutParams.resolveLayoutDirection(0);
                }
                MotionLayout.this.e(false, view, next2, layoutParams, sparseArray);
                next2.n1(cVar.B(view.getId()) == 1 ? view.getVisibility() : cVar.A(view.getId()));
            }
            Iterator<h0.e> it3 = fVar.v1().iterator();
            while (it3.hasNext()) {
                h0.e next3 = it3.next();
                if (next3 instanceof m) {
                    h0.i iVar = (h0.i) next3;
                    ((ConstraintHelper) next3.u()).v(fVar, iVar, sparseArray);
                    ((m) iVar).y1();
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x00e9  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x013d A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a() {
            /*
                r18 = this;
                r0 = r18
                androidx.constraintlayout.motion.widget.MotionLayout r1 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r1 = r1.getChildCount()
                androidx.constraintlayout.motion.widget.MotionLayout r2 = androidx.constraintlayout.motion.widget.MotionLayout.this
                java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.m> r2 = r2.E
                r2.clear()
                android.util.SparseArray r2 = new android.util.SparseArray
                r2.<init>()
                int[] r3 = new int[r1]
                r5 = 0
            L_0x0017:
                if (r5 >= r1) goto L_0x0037
                androidx.constraintlayout.motion.widget.MotionLayout r6 = androidx.constraintlayout.motion.widget.MotionLayout.this
                android.view.View r6 = r6.getChildAt(r5)
                androidx.constraintlayout.motion.widget.m r7 = new androidx.constraintlayout.motion.widget.m
                r7.<init>(r6)
                int r8 = r6.getId()
                r3[r5] = r8
                r2.put(r8, r7)
                androidx.constraintlayout.motion.widget.MotionLayout r8 = androidx.constraintlayout.motion.widget.MotionLayout.this
                java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.m> r8 = r8.E
                r8.put(r6, r7)
                int r5 = r5 + 1
                goto L_0x0017
            L_0x0037:
                r5 = 0
            L_0x0038:
                if (r5 >= r1) goto L_0x0143
                androidx.constraintlayout.motion.widget.MotionLayout r6 = androidx.constraintlayout.motion.widget.MotionLayout.this
                android.view.View r6 = r6.getChildAt(r5)
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.m> r7 = r7.E
                java.lang.Object r7 = r7.get(r6)
                r13 = r7
                androidx.constraintlayout.motion.widget.m r13 = (androidx.constraintlayout.motion.widget.m) r13
                if (r13 != 0) goto L_0x0051
                r16 = r2
                goto L_0x013d
            L_0x0051:
                androidx.constraintlayout.widget.c r7 = r0.f1466c
                java.lang.String r14 = ")"
                java.lang.String r15 = " ("
                java.lang.String r12 = "no widget for  "
                java.lang.String r11 = "MotionLayout"
                if (r7 == 0) goto L_0x00b2
                h0.f r7 = r0.f1464a
                h0.e r7 = r0.d(r7, r6)
                if (r7 == 0) goto L_0x007d
                androidx.constraintlayout.motion.widget.MotionLayout r8 = androidx.constraintlayout.motion.widget.MotionLayout.this
                android.graphics.Rect r7 = r8.B0(r7)
                androidx.constraintlayout.widget.c r8 = r0.f1466c
                androidx.constraintlayout.motion.widget.MotionLayout r9 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r9 = r9.getWidth()
                androidx.constraintlayout.motion.widget.MotionLayout r10 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r10 = r10.getHeight()
                r13.F(r7, r8, r9, r10)
                goto L_0x00e1
            L_0x007d:
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r7 = r7.Q
                if (r7 == 0) goto L_0x00e1
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r8 = androidx.constraintlayout.motion.widget.a.b()
                r7.append(r8)
                r7.append(r12)
                java.lang.String r8 = androidx.constraintlayout.motion.widget.a.d(r6)
                r7.append(r8)
                r7.append(r15)
                java.lang.Class r8 = r6.getClass()
                java.lang.String r8 = r8.getName()
                r7.append(r8)
                r7.append(r14)
                java.lang.String r7 = r7.toString()
                android.util.Log.e(r11, r7)
                goto L_0x00e1
            L_0x00b2:
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                boolean r7 = r7.A1
                if (r7 == 0) goto L_0x00e1
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                java.util.HashMap<android.view.View, k0.e> r7 = r7.C1
                java.lang.Object r7 = r7.get(r6)
                r8 = r7
                k0.e r8 = (k0.e) r8
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r10 = r7.B1
                int r16 = r7.D1
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r17 = r7.E1
                r7 = r13
                r9 = r6
                r4 = r11
                r11 = r16
                r16 = r2
                r2 = r12
                r12 = r17
                r7.G(r8, r9, r10, r11, r12)
                goto L_0x00e5
            L_0x00e1:
                r16 = r2
                r4 = r11
                r2 = r12
            L_0x00e5:
                androidx.constraintlayout.widget.c r7 = r0.f1467d
                if (r7 == 0) goto L_0x013d
                h0.f r7 = r0.f1465b
                h0.e r7 = r0.d(r7, r6)
                if (r7 == 0) goto L_0x0109
                androidx.constraintlayout.motion.widget.MotionLayout r2 = androidx.constraintlayout.motion.widget.MotionLayout.this
                android.graphics.Rect r2 = r2.B0(r7)
                androidx.constraintlayout.widget.c r4 = r0.f1467d
                androidx.constraintlayout.motion.widget.MotionLayout r6 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r6 = r6.getWidth()
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r7 = r7.getHeight()
                r13.C(r2, r4, r6, r7)
                goto L_0x013d
            L_0x0109:
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r7 = r7.Q
                if (r7 == 0) goto L_0x013d
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r8 = androidx.constraintlayout.motion.widget.a.b()
                r7.append(r8)
                r7.append(r2)
                java.lang.String r2 = androidx.constraintlayout.motion.widget.a.d(r6)
                r7.append(r2)
                r7.append(r15)
                java.lang.Class r2 = r6.getClass()
                java.lang.String r2 = r2.getName()
                r7.append(r2)
                r7.append(r14)
                java.lang.String r2 = r7.toString()
                android.util.Log.e(r4, r2)
            L_0x013d:
                int r5 = r5 + 1
                r2 = r16
                goto L_0x0038
            L_0x0143:
                r16 = r2
                r4 = 0
            L_0x0146:
                if (r4 >= r1) goto L_0x0167
                r2 = r3[r4]
                r5 = r16
                java.lang.Object r2 = r5.get(r2)
                androidx.constraintlayout.motion.widget.m r2 = (androidx.constraintlayout.motion.widget.m) r2
                int r6 = r2.h()
                r7 = -1
                if (r6 == r7) goto L_0x0162
                java.lang.Object r6 = r5.get(r6)
                androidx.constraintlayout.motion.widget.m r6 = (androidx.constraintlayout.motion.widget.m) r6
                r2.J(r6)
            L_0x0162:
                int r4 = r4 + 1
                r16 = r5
                goto L_0x0146
            L_0x0167:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.f.a():void");
        }

        /* access modifiers changed from: package-private */
        public void c(h0.f fVar, h0.f fVar2) {
            ArrayList<h0.e> v12 = fVar.v1();
            HashMap hashMap = new HashMap();
            hashMap.put(fVar, fVar2);
            fVar2.v1().clear();
            fVar2.n(fVar, hashMap);
            Iterator<h0.e> it = v12.iterator();
            while (it.hasNext()) {
                h0.e next = it.next();
                h0.e aVar = next instanceof h0.a ? new h0.a() : next instanceof h0.h ? new h0.h() : next instanceof h0.g ? new h0.g() : next instanceof l ? new l() : next instanceof h0.i ? new h0.j() : new h0.e();
                fVar2.b(aVar);
                hashMap.put(next, aVar);
            }
            Iterator<h0.e> it2 = v12.iterator();
            while (it2.hasNext()) {
                h0.e next2 = it2.next();
                ((h0.e) hashMap.get(next2)).n(next2, hashMap);
            }
        }

        /* access modifiers changed from: package-private */
        public h0.e d(h0.f fVar, View view) {
            if (fVar.u() == view) {
                return fVar;
            }
            ArrayList<h0.e> v12 = fVar.v1();
            int size = v12.size();
            for (int i10 = 0; i10 < size; i10++) {
                h0.e eVar = v12.get(i10);
                if (eVar.u() == view) {
                    return eVar;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public void e(h0.f fVar, androidx.constraintlayout.widget.c cVar, androidx.constraintlayout.widget.c cVar2) {
            this.f1466c = cVar;
            this.f1467d = cVar2;
            this.f1464a = new h0.f();
            this.f1465b = new h0.f();
            this.f1464a.Z1(MotionLayout.this.f1874c.M1());
            this.f1465b.Z1(MotionLayout.this.f1874c.M1());
            this.f1464a.y1();
            this.f1465b.y1();
            c(MotionLayout.this.f1874c, this.f1464a);
            c(MotionLayout.this.f1874c, this.f1465b);
            if (((double) MotionLayout.this.I) > 0.5d) {
                if (cVar != null) {
                    j(this.f1464a, cVar);
                }
                j(this.f1465b, cVar2);
            } else {
                j(this.f1465b, cVar2);
                if (cVar != null) {
                    j(this.f1464a, cVar);
                }
            }
            this.f1464a.c2(MotionLayout.this.r());
            this.f1464a.e2();
            this.f1465b.c2(MotionLayout.this.r());
            this.f1465b.e2();
            ViewGroup.LayoutParams layoutParams = MotionLayout.this.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams.width == -2) {
                    h0.f fVar2 = this.f1464a;
                    e.b bVar = e.b.WRAP_CONTENT;
                    fVar2.T0(bVar);
                    this.f1465b.T0(bVar);
                }
                if (layoutParams.height == -2) {
                    h0.f fVar3 = this.f1464a;
                    e.b bVar2 = e.b.WRAP_CONTENT;
                    fVar3.k1(bVar2);
                    this.f1465b.k1(bVar2);
                }
            }
        }

        public boolean f(int i10, int i11) {
            return (i10 == this.f1468e && i11 == this.f1469f) ? false : true;
        }

        public void g(int i10, int i11) {
            int mode = View.MeasureSpec.getMode(i10);
            int mode2 = View.MeasureSpec.getMode(i11);
            MotionLayout motionLayout = MotionLayout.this;
            motionLayout.f1426r1 = mode;
            motionLayout.f1427s1 = mode2;
            motionLayout.getOptimizationLevel();
            b(i10, i11);
            if (((MotionLayout.this.getParent() instanceof MotionLayout) && mode == 1073741824 && mode2 == 1073741824) ? false : true) {
                b(i10, i11);
                MotionLayout.this.f1422n1 = this.f1464a.Y();
                MotionLayout.this.f1423o1 = this.f1464a.z();
                MotionLayout.this.f1424p1 = this.f1465b.Y();
                MotionLayout.this.f1425q1 = this.f1465b.z();
                MotionLayout motionLayout2 = MotionLayout.this;
                motionLayout2.f1421m1 = (motionLayout2.f1422n1 == motionLayout2.f1424p1 && motionLayout2.f1423o1 == motionLayout2.f1425q1) ? false : true;
            }
            MotionLayout motionLayout3 = MotionLayout.this;
            int i12 = motionLayout3.f1422n1;
            int i13 = motionLayout3.f1423o1;
            int i14 = motionLayout3.f1426r1;
            if (i14 == Integer.MIN_VALUE || i14 == 0) {
                i12 = (int) (((float) i12) + (motionLayout3.f1428t1 * ((float) (motionLayout3.f1424p1 - i12))));
            }
            int i15 = i12;
            int i16 = motionLayout3.f1427s1;
            if (i16 == Integer.MIN_VALUE || i16 == 0) {
                i13 = (int) (((float) i13) + (motionLayout3.f1428t1 * ((float) (motionLayout3.f1425q1 - i13))));
            }
            MotionLayout.this.u(i10, i11, i15, i13, this.f1464a.U1() || this.f1465b.U1(), this.f1464a.S1() || this.f1465b.S1());
        }

        public void h() {
            g(MotionLayout.this.B, MotionLayout.this.C);
            MotionLayout.this.A0();
        }

        public void i(int i10, int i11) {
            this.f1468e = i10;
            this.f1469f = i11;
        }
    }

    protected interface g {
        void b();

        void c(MotionEvent motionEvent);

        float d();

        float e();

        void f(int i10);
    }

    private static class h implements g {

        /* renamed from: b  reason: collision with root package name */
        private static h f1471b = new h();

        /* renamed from: a  reason: collision with root package name */
        VelocityTracker f1472a;

        private h() {
        }

        public static h a() {
            f1471b.f1472a = VelocityTracker.obtain();
            return f1471b;
        }

        public void b() {
            VelocityTracker velocityTracker = this.f1472a;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f1472a = null;
            }
        }

        public void c(MotionEvent motionEvent) {
            VelocityTracker velocityTracker = this.f1472a;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
        }

        public float d() {
            VelocityTracker velocityTracker = this.f1472a;
            if (velocityTracker != null) {
                return velocityTracker.getYVelocity();
            }
            return 0.0f;
        }

        public float e() {
            VelocityTracker velocityTracker = this.f1472a;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity();
            }
            return 0.0f;
        }

        public void f(int i10) {
            VelocityTracker velocityTracker = this.f1472a;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(i10);
            }
        }
    }

    class i {

        /* renamed from: a  reason: collision with root package name */
        float f1473a = Float.NaN;

        /* renamed from: b  reason: collision with root package name */
        float f1474b = Float.NaN;

        /* renamed from: c  reason: collision with root package name */
        int f1475c = -1;

        /* renamed from: d  reason: collision with root package name */
        int f1476d = -1;

        i() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            int i10 = this.f1475c;
            if (!(i10 == -1 && this.f1476d == -1)) {
                if (i10 == -1) {
                    MotionLayout.this.G0(this.f1476d);
                } else {
                    int i11 = this.f1476d;
                    if (i11 == -1) {
                        MotionLayout.this.y0(i10, -1, -1);
                    } else {
                        MotionLayout.this.z0(i10, i11);
                    }
                }
                MotionLayout.this.setState(k.SETUP);
            }
            if (!Float.isNaN(this.f1474b)) {
                MotionLayout.this.x0(this.f1473a, this.f1474b);
                this.f1473a = Float.NaN;
                this.f1474b = Float.NaN;
                this.f1475c = -1;
                this.f1476d = -1;
            } else if (!Float.isNaN(this.f1473a)) {
                MotionLayout.this.setProgress(this.f1473a);
            }
        }

        public Bundle b() {
            Bundle bundle = new Bundle();
            bundle.putFloat("motion.progress", this.f1473a);
            bundle.putFloat("motion.velocity", this.f1474b);
            bundle.putInt("motion.StartState", this.f1475c);
            bundle.putInt("motion.EndState", this.f1476d);
            return bundle;
        }

        public void c() {
            this.f1476d = MotionLayout.this.A;
            this.f1475c = MotionLayout.this.f1437y;
            this.f1474b = MotionLayout.this.getVelocity();
            this.f1473a = MotionLayout.this.getProgress();
        }

        public void d(int i10) {
            this.f1476d = i10;
        }

        public void e(float f10) {
            this.f1473a = f10;
        }

        public void f(int i10) {
            this.f1475c = i10;
        }

        public void g(Bundle bundle) {
            this.f1473a = bundle.getFloat("motion.progress");
            this.f1474b = bundle.getFloat("motion.velocity");
            this.f1475c = bundle.getInt("motion.StartState");
            this.f1476d = bundle.getInt("motion.EndState");
        }

        public void h(float f10) {
            this.f1474b = f10;
        }
    }

    public interface j {
        void a(MotionLayout motionLayout, int i10, int i11, float f10);

        void b(MotionLayout motionLayout, int i10, int i11);

        void c(MotionLayout motionLayout, int i10, boolean z10, float f10);

        void d(MotionLayout motionLayout, int i10);
    }

    enum k {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    public MotionLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        r0(attributeSet);
    }

    public MotionLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        r0(attributeSet);
    }

    /* access modifiers changed from: private */
    public void A0() {
        int childCount = getChildCount();
        this.I1.a();
        boolean z10 = true;
        this.M = true;
        SparseArray sparseArray = new SparseArray();
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            sparseArray.put(childAt.getId(), this.E.get(childAt));
        }
        int width = getWidth();
        int height = getHeight();
        int j10 = this.f1429u.j();
        if (j10 != -1) {
            for (int i12 = 0; i12 < childCount; i12++) {
                m mVar = this.E.get(getChildAt(i12));
                if (mVar != null) {
                    mVar.D(j10);
                }
            }
        }
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        int[] iArr = new int[this.E.size()];
        int i13 = 0;
        for (int i14 = 0; i14 < childCount; i14++) {
            m mVar2 = this.E.get(getChildAt(i14));
            if (mVar2.h() != -1) {
                sparseBooleanArray.put(mVar2.h(), true);
                iArr[i13] = mVar2.h();
                i13++;
            }
        }
        if (this.f1414f1 != null) {
            for (int i15 = 0; i15 < i13; i15++) {
                m mVar3 = this.E.get(findViewById(iArr[i15]));
                if (mVar3 != null) {
                    this.f1429u.t(mVar3);
                }
            }
            Iterator<MotionHelper> it = this.f1414f1.iterator();
            while (it.hasNext()) {
                it.next().D(this, this.E);
            }
            for (int i16 = 0; i16 < i13; i16++) {
                m mVar4 = this.E.get(findViewById(iArr[i16]));
                if (mVar4 != null) {
                    mVar4.I(width, height, this.G, getNanoTime());
                }
            }
        } else {
            for (int i17 = 0; i17 < i13; i17++) {
                m mVar5 = this.E.get(findViewById(iArr[i17]));
                if (mVar5 != null) {
                    this.f1429u.t(mVar5);
                    mVar5.I(width, height, this.G, getNanoTime());
                }
            }
        }
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt2 = getChildAt(i18);
            m mVar6 = this.E.get(childAt2);
            if (!sparseBooleanArray.get(childAt2.getId()) && mVar6 != null) {
                this.f1429u.t(mVar6);
                mVar6.I(width, height, this.G, getNanoTime());
            }
        }
        float E2 = this.f1429u.E();
        if (E2 != 0.0f) {
            boolean z11 = ((double) E2) < 0.0d;
            float abs = Math.abs(E2);
            float f10 = -3.4028235E38f;
            float f11 = Float.MAX_VALUE;
            int i19 = 0;
            float f12 = -3.4028235E38f;
            float f13 = Float.MAX_VALUE;
            while (true) {
                if (i19 >= childCount) {
                    z10 = false;
                    break;
                }
                m mVar7 = this.E.get(getChildAt(i19));
                if (!Float.isNaN(mVar7.f1615l)) {
                    break;
                }
                float n10 = mVar7.n();
                float o10 = mVar7.o();
                float f14 = z11 ? o10 - n10 : o10 + n10;
                f13 = Math.min(f13, f14);
                f12 = Math.max(f12, f14);
                i19++;
            }
            if (z10) {
                for (int i20 = 0; i20 < childCount; i20++) {
                    m mVar8 = this.E.get(getChildAt(i20));
                    if (!Float.isNaN(mVar8.f1615l)) {
                        f11 = Math.min(f11, mVar8.f1615l);
                        f10 = Math.max(f10, mVar8.f1615l);
                    }
                }
                while (i10 < childCount) {
                    m mVar9 = this.E.get(getChildAt(i10));
                    if (!Float.isNaN(mVar9.f1615l)) {
                        mVar9.f1617n = 1.0f / (1.0f - abs);
                        float f15 = mVar9.f1615l;
                        mVar9.f1616m = abs - (z11 ? ((f10 - f15) / (f10 - f11)) * abs : ((f15 - f11) * abs) / (f10 - f11));
                    }
                    i10++;
                }
                return;
            }
            while (i10 < childCount) {
                m mVar10 = this.E.get(getChildAt(i10));
                float n11 = mVar10.n();
                float o11 = mVar10.o();
                float f16 = z11 ? o11 - n11 : o11 + n11;
                mVar10.f1617n = 1.0f / (1.0f - abs);
                mVar10.f1616m = abs - (((f16 - f13) * abs) / (f12 - f13));
                i10++;
            }
        }
    }

    /* access modifiers changed from: private */
    public Rect B0(h0.e eVar) {
        this.F1.top = eVar.a0();
        this.F1.left = eVar.Z();
        Rect rect = this.F1;
        int Y = eVar.Y();
        Rect rect2 = this.F1;
        rect.right = Y + rect2.left;
        int z10 = eVar.z();
        Rect rect3 = this.F1;
        rect2.bottom = z10 + rect3.top;
        return rect3;
    }

    private static boolean N0(float f10, float f11, float f12) {
        if (f10 > 0.0f) {
            float f13 = f10 / f12;
            return f11 + ((f10 * f13) - (((f12 * f13) * f13) / 2.0f)) > 1.0f;
        }
        float f14 = (-f10) / f12;
        return f11 + ((f10 * f14) + (((f12 * f14) * f14) / 2.0f)) < 0.0f;
    }

    private boolean a0(View view, MotionEvent motionEvent, float f10, float f11) {
        Matrix matrix = view.getMatrix();
        if (matrix.isIdentity()) {
            motionEvent.offsetLocation(f10, f11);
            boolean onTouchEvent = view.onTouchEvent(motionEvent);
            motionEvent.offsetLocation(-f10, -f11);
            return onTouchEvent;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(f10, f11);
        if (this.M1 == null) {
            this.M1 = new Matrix();
        }
        matrix.invert(this.M1);
        obtain.transform(this.M1);
        boolean onTouchEvent2 = view.onTouchEvent(obtain);
        obtain.recycle();
        return onTouchEvent2;
    }

    private void b0() {
        p pVar = this.f1429u;
        if (pVar == null) {
            Log.e("MotionLayout", "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
            return;
        }
        int F2 = pVar.F();
        p pVar2 = this.f1429u;
        c0(F2, pVar2.l(pVar2.F()));
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        Iterator<p.b> it = this.f1429u.o().iterator();
        while (it.hasNext()) {
            p.b next = it.next();
            if (next == this.f1429u.f1651c) {
                Log.v("MotionLayout", "CHECK: CURRENT");
            }
            d0(next);
            int A2 = next.A();
            int y10 = next.y();
            String c10 = a.c(getContext(), A2);
            String c11 = a.c(getContext(), y10);
            if (sparseIntArray.get(A2) == y10) {
                Log.e("MotionLayout", "CHECK: two transitions with the same start and end " + c10 + "->" + c11);
            }
            if (sparseIntArray2.get(y10) == A2) {
                Log.e("MotionLayout", "CHECK: you can't have reverse transitions" + c10 + "->" + c11);
            }
            sparseIntArray.put(A2, y10);
            sparseIntArray2.put(y10, A2);
            if (this.f1429u.l(A2) == null) {
                Log.e("MotionLayout", " no such constraintSetStart " + c10);
            }
            if (this.f1429u.l(y10) == null) {
                Log.e("MotionLayout", " no such constraintSetEnd " + c10);
            }
        }
    }

    private void c0(int i10, androidx.constraintlayout.widget.c cVar) {
        String c10 = a.c(getContext(), i10);
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            int id2 = childAt.getId();
            if (id2 == -1) {
                Log.w("MotionLayout", "CHECK: " + c10 + " ALL VIEWS SHOULD HAVE ID's " + childAt.getClass().getName() + " does not!");
            }
            if (cVar.w(id2) == null) {
                Log.w("MotionLayout", "CHECK: " + c10 + " NO CONSTRAINTS for " + a.d(childAt));
            }
        }
        int[] y10 = cVar.y();
        for (int i12 = 0; i12 < y10.length; i12++) {
            int i13 = y10[i12];
            String c11 = a.c(getContext(), i13);
            if (findViewById(y10[i12]) == null) {
                Log.w("MotionLayout", "CHECK: " + c10 + " NO View matches id " + c11);
            }
            if (cVar.x(i13) == -1) {
                Log.w("MotionLayout", "CHECK: " + c10 + "(" + c11 + ") no LAYOUT_HEIGHT");
            }
            if (cVar.C(i13) == -1) {
                Log.w("MotionLayout", "CHECK: " + c10 + "(" + c11 + ") no LAYOUT_HEIGHT");
            }
        }
    }

    private void d0(p.b bVar) {
        if (bVar.A() == bVar.y()) {
            Log.e("MotionLayout", "CHECK: start and end constraint set should not be the same!");
        }
    }

    private void e0() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            m mVar = this.E.get(childAt);
            if (mVar != null) {
                mVar.E(childAt);
            }
        }
    }

    private void h0() {
        boolean z10;
        float signum = Math.signum(this.K - this.I);
        long nanoTime = getNanoTime();
        Interpolator interpolator = this.f1431v;
        float f10 = this.I + (!(interpolator instanceof k0.b) ? ((((float) (nanoTime - this.J)) * signum) * 1.0E-9f) / this.G : 0.0f);
        if (this.L) {
            f10 = this.K;
        }
        int i10 = (signum > 0.0f ? 1 : (signum == 0.0f ? 0 : -1));
        if ((i10 <= 0 || f10 < this.K) && (signum > 0.0f || f10 > this.K)) {
            z10 = false;
        } else {
            f10 = this.K;
            z10 = true;
        }
        if (interpolator != null && !z10) {
            f10 = this.S ? interpolator.getInterpolation(((float) (nanoTime - this.F)) * 1.0E-9f) : interpolator.getInterpolation(f10);
        }
        if ((i10 > 0 && f10 >= this.K) || (signum <= 0.0f && f10 <= this.K)) {
            f10 = this.K;
        }
        this.f1428t1 = f10;
        int childCount = getChildCount();
        long nanoTime2 = getNanoTime();
        Interpolator interpolator2 = this.f1433w;
        if (interpolator2 != null) {
            f10 = interpolator2.getInterpolation(f10);
        }
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            m mVar = this.E.get(childAt);
            if (mVar != null) {
                mVar.x(childAt, f10, nanoTime2, this.f1430u1);
            }
        }
        if (this.f1421m1) {
            requestLayout();
        }
    }

    private void i0() {
        CopyOnWriteArrayList<j> copyOnWriteArrayList;
        if ((this.N != null || ((copyOnWriteArrayList = this.f1415g1) != null && !copyOnWriteArrayList.isEmpty())) && this.f1420l1 != this.H) {
            if (this.f1419k1 != -1) {
                j jVar = this.N;
                if (jVar != null) {
                    jVar.b(this, this.f1437y, this.A);
                }
                CopyOnWriteArrayList<j> copyOnWriteArrayList2 = this.f1415g1;
                if (copyOnWriteArrayList2 != null) {
                    Iterator<j> it = copyOnWriteArrayList2.iterator();
                    while (it.hasNext()) {
                        it.next().b(this, this.f1437y, this.A);
                    }
                }
            }
            this.f1419k1 = -1;
            float f10 = this.H;
            this.f1420l1 = f10;
            j jVar2 = this.N;
            if (jVar2 != null) {
                jVar2.a(this, this.f1437y, this.A, f10);
            }
            CopyOnWriteArrayList<j> copyOnWriteArrayList3 = this.f1415g1;
            if (copyOnWriteArrayList3 != null) {
                Iterator<j> it2 = copyOnWriteArrayList3.iterator();
                while (it2.hasNext()) {
                    it2.next().a(this, this.f1437y, this.A, this.H);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean q0(float r8, float r9, android.view.View r10, android.view.MotionEvent r11) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof android.view.ViewGroup
            r1 = 1
            if (r0 == 0) goto L_0x0036
            r0 = r10
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            int r2 = r0.getChildCount()
            int r2 = r2 - r1
        L_0x000d:
            if (r2 < 0) goto L_0x0036
            android.view.View r3 = r0.getChildAt(r2)
            int r4 = r3.getLeft()
            float r4 = (float) r4
            float r4 = r4 + r8
            int r5 = r10.getScrollX()
            float r5 = (float) r5
            float r4 = r4 - r5
            int r5 = r3.getTop()
            float r5 = (float) r5
            float r5 = r5 + r9
            int r6 = r10.getScrollY()
            float r6 = (float) r6
            float r5 = r5 - r6
            boolean r3 = r7.q0(r4, r5, r3, r11)
            if (r3 == 0) goto L_0x0033
            r0 = r1
            goto L_0x0037
        L_0x0033:
            int r2 = r2 + -1
            goto L_0x000d
        L_0x0036:
            r0 = 0
        L_0x0037:
            if (r0 != 0) goto L_0x0075
            android.graphics.RectF r2 = r7.K1
            int r3 = r10.getRight()
            float r3 = (float) r3
            float r3 = r3 + r8
            int r4 = r10.getLeft()
            float r4 = (float) r4
            float r3 = r3 - r4
            int r4 = r10.getBottom()
            float r4 = (float) r4
            float r4 = r4 + r9
            int r5 = r10.getTop()
            float r5 = (float) r5
            float r4 = r4 - r5
            r2.set(r8, r9, r3, r4)
            int r2 = r11.getAction()
            if (r2 != 0) goto L_0x006c
            android.graphics.RectF r2 = r7.K1
            float r3 = r11.getX()
            float r4 = r11.getY()
            boolean r2 = r2.contains(r3, r4)
            if (r2 == 0) goto L_0x0075
        L_0x006c:
            float r8 = -r8
            float r9 = -r9
            boolean r8 = r7.a0(r10, r11, r8, r9)
            if (r8 == 0) goto L_0x0075
            goto L_0x0076
        L_0x0075:
            r1 = r0
        L_0x0076:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.q0(float, float, android.view.View, android.view.MotionEvent):boolean");
    }

    private void r0(AttributeSet attributeSet) {
        p pVar;
        int i10;
        O1 = isInEditMode();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.f.MotionLayout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            boolean z10 = true;
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == androidx.constraintlayout.widget.f.MotionLayout_layoutDescription) {
                    this.f1429u = new p(getContext(), this, obtainStyledAttributes.getResourceId(index, -1));
                } else if (index == androidx.constraintlayout.widget.f.MotionLayout_currentState) {
                    this.f1439z = obtainStyledAttributes.getResourceId(index, -1);
                } else if (index == androidx.constraintlayout.widget.f.MotionLayout_motionProgress) {
                    this.K = obtainStyledAttributes.getFloat(index, 0.0f);
                    this.M = true;
                } else if (index == androidx.constraintlayout.widget.f.MotionLayout_applyMotionScene) {
                    z10 = obtainStyledAttributes.getBoolean(index, z10);
                } else {
                    if (index == androidx.constraintlayout.widget.f.MotionLayout_showPaths) {
                        if (this.Q == 0) {
                            i10 = obtainStyledAttributes.getBoolean(index, false) ? 2 : 0;
                        }
                    } else if (index == androidx.constraintlayout.widget.f.MotionLayout_motionDebug) {
                        i10 = obtainStyledAttributes.getInt(index, 0);
                    }
                    this.Q = i10;
                }
            }
            obtainStyledAttributes.recycle();
            if (this.f1429u == null) {
                Log.e("MotionLayout", "WARNING NO app:layoutDescription tag");
            }
            if (!z10) {
                this.f1429u = null;
            }
        }
        if (this.Q != 0) {
            b0();
        }
        if (this.f1439z == -1 && (pVar = this.f1429u) != null) {
            this.f1439z = pVar.F();
            this.f1437y = this.f1429u.F();
            this.A = this.f1429u.q();
        }
    }

    private void v0() {
        CopyOnWriteArrayList<j> copyOnWriteArrayList;
        if (this.N != null || ((copyOnWriteArrayList = this.f1415g1) != null && !copyOnWriteArrayList.isEmpty())) {
            Iterator<Integer> it = this.N1.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                j jVar = this.N;
                if (jVar != null) {
                    jVar.d(this, next.intValue());
                }
                CopyOnWriteArrayList<j> copyOnWriteArrayList2 = this.f1415g1;
                if (copyOnWriteArrayList2 != null) {
                    Iterator<j> it2 = copyOnWriteArrayList2.iterator();
                    while (it2.hasNext()) {
                        it2.next().d(this, next.intValue());
                    }
                }
            }
            this.N1.clear();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0037, code lost:
        if (r10 != 7) goto L_0x00cf;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void C0(int r10, float r11, float r12) {
        /*
            r9 = this;
            androidx.constraintlayout.motion.widget.p r0 = r9.f1429u
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            float r0 = r9.I
            int r0 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r0 != 0) goto L_0x000c
            return
        L_0x000c:
            r0 = 1
            r9.S = r0
            long r1 = r9.getNanoTime()
            r9.F = r1
            androidx.constraintlayout.motion.widget.p r1 = r9.f1429u
            int r1 = r1.p()
            float r1 = (float) r1
            r2 = 1148846080(0x447a0000, float:1000.0)
            float r1 = r1 / r2
            r9.G = r1
            r9.K = r11
            r9.M = r0
            r1 = 0
            r2 = 7
            r3 = 6
            r4 = 2
            if (r10 == 0) goto L_0x007e
            if (r10 == r0) goto L_0x007e
            if (r10 == r4) goto L_0x007e
            r5 = 4
            if (r10 == r5) goto L_0x006c
            r5 = 5
            if (r10 == r5) goto L_0x003b
            if (r10 == r3) goto L_0x007e
            if (r10 == r2) goto L_0x007e
            goto L_0x00cf
        L_0x003b:
            float r10 = r9.I
            androidx.constraintlayout.motion.widget.p r0 = r9.f1429u
            float r0 = r0.u()
            boolean r10 = N0(r12, r10, r0)
            if (r10 == 0) goto L_0x004a
            goto L_0x006c
        L_0x004a:
            k0.b r2 = r9.T
            float r3 = r9.I
            float r6 = r9.G
            androidx.constraintlayout.motion.widget.p r10 = r9.f1429u
            float r7 = r10.u()
            androidx.constraintlayout.motion.widget.p r10 = r9.f1429u
            float r8 = r10.v()
            r4 = r11
            r5 = r12
            r2.b(r3, r4, r5, r6, r7, r8)
            r9.f1435x = r1
        L_0x0063:
            int r10 = r9.f1439z
            r9.K = r11
            r9.f1439z = r10
            k0.b r10 = r9.T
            goto L_0x007b
        L_0x006c:
            androidx.constraintlayout.motion.widget.MotionLayout$d r10 = r9.U
            float r11 = r9.I
            androidx.constraintlayout.motion.widget.p r0 = r9.f1429u
            float r0 = r0.u()
            r10.b(r12, r11, r0)
            androidx.constraintlayout.motion.widget.MotionLayout$d r10 = r9.U
        L_0x007b:
            r9.f1431v = r10
            goto L_0x00cf
        L_0x007e:
            if (r10 == r0) goto L_0x008a
            if (r10 != r2) goto L_0x0083
            goto L_0x008a
        L_0x0083:
            if (r10 == r4) goto L_0x0087
            if (r10 != r3) goto L_0x008b
        L_0x0087:
            r11 = 1065353216(0x3f800000, float:1.0)
            goto L_0x008b
        L_0x008a:
            r11 = r1
        L_0x008b:
            androidx.constraintlayout.motion.widget.p r10 = r9.f1429u
            int r10 = r10.k()
            k0.b r0 = r9.T
            float r1 = r9.I
            if (r10 != 0) goto L_0x00ab
            float r4 = r9.G
            androidx.constraintlayout.motion.widget.p r10 = r9.f1429u
            float r5 = r10.u()
            androidx.constraintlayout.motion.widget.p r10 = r9.f1429u
            float r6 = r10.v()
            r2 = r11
            r3 = r12
            r0.b(r1, r2, r3, r4, r5, r6)
            goto L_0x0063
        L_0x00ab:
            androidx.constraintlayout.motion.widget.p r10 = r9.f1429u
            float r4 = r10.B()
            androidx.constraintlayout.motion.widget.p r10 = r9.f1429u
            float r5 = r10.C()
            androidx.constraintlayout.motion.widget.p r10 = r9.f1429u
            float r6 = r10.A()
            androidx.constraintlayout.motion.widget.p r10 = r9.f1429u
            float r7 = r10.D()
            androidx.constraintlayout.motion.widget.p r10 = r9.f1429u
            int r8 = r10.z()
            r2 = r11
            r3 = r12
            r0.d(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0063
        L_0x00cf:
            r10 = 0
            r9.L = r10
            long r10 = r9.getNanoTime()
            r9.F = r10
            r9.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.C0(int, float, float):void");
    }

    public void D0() {
        Y(1.0f);
        this.f1436x1 = null;
    }

    public void E0(Runnable runnable) {
        Y(1.0f);
        this.f1436x1 = runnable;
    }

    public void F0() {
        Y(0.0f);
    }

    public void G0(int i10) {
        if (!isAttachedToWindow()) {
            if (this.f1434w1 == null) {
                this.f1434w1 = new i();
            }
            this.f1434w1.d(i10);
            return;
        }
        I0(i10, -1, -1);
    }

    public void H0(int i10, int i11) {
        if (!isAttachedToWindow()) {
            if (this.f1434w1 == null) {
                this.f1434w1 = new i();
            }
            this.f1434w1.d(i10);
            return;
        }
        J0(i10, -1, -1, i11);
    }

    public void I0(int i10, int i11, int i12) {
        J0(i10, i11, i12, -1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0091, code lost:
        if (r14 > 0) goto L_0x008c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void J0(int r11, int r12, int r13, int r14) {
        /*
            r10 = this;
            androidx.constraintlayout.motion.widget.p r0 = r10.f1429u
            r1 = -1
            if (r0 == 0) goto L_0x0014
            androidx.constraintlayout.widget.h r0 = r0.f1650b
            if (r0 == 0) goto L_0x0014
            int r2 = r10.f1439z
            float r12 = (float) r12
            float r13 = (float) r13
            int r12 = r0.a(r2, r11, r12, r13)
            if (r12 == r1) goto L_0x0014
            r11 = r12
        L_0x0014:
            int r12 = r10.f1439z
            if (r12 != r11) goto L_0x0019
            return
        L_0x0019:
            int r13 = r10.f1437y
            r0 = 1148846080(0x447a0000, float:1000.0)
            r2 = 0
            if (r13 != r11) goto L_0x002a
            r10.Y(r2)
            if (r14 <= 0) goto L_0x0029
            float r11 = (float) r14
            float r11 = r11 / r0
            r10.G = r11
        L_0x0029:
            return
        L_0x002a:
            int r13 = r10.A
            r3 = 1065353216(0x3f800000, float:1.0)
            if (r13 != r11) goto L_0x003a
            r10.Y(r3)
            if (r14 <= 0) goto L_0x0039
            float r11 = (float) r14
            float r11 = r11 / r0
            r10.G = r11
        L_0x0039:
            return
        L_0x003a:
            r10.A = r11
            if (r12 == r1) goto L_0x0050
            r10.z0(r12, r11)
            r10.Y(r3)
            r10.I = r2
            r10.D0()
            if (r14 <= 0) goto L_0x004f
            float r11 = (float) r14
            float r11 = r11 / r0
            r10.G = r11
        L_0x004f:
            return
        L_0x0050:
            r12 = 0
            r10.S = r12
            r10.K = r3
            r10.H = r2
            r10.I = r2
            long r4 = r10.getNanoTime()
            r10.J = r4
            long r4 = r10.getNanoTime()
            r10.F = r4
            r10.L = r12
            r13 = 0
            r10.f1431v = r13
            if (r14 != r1) goto L_0x0076
            androidx.constraintlayout.motion.widget.p r4 = r10.f1429u
            int r4 = r4.p()
            float r4 = (float) r4
            float r4 = r4 / r0
            r10.G = r4
        L_0x0076:
            r10.f1437y = r1
            androidx.constraintlayout.motion.widget.p r4 = r10.f1429u
            int r5 = r10.A
            r4.X(r1, r5)
            android.util.SparseArray r1 = new android.util.SparseArray
            r1.<init>()
            if (r14 != 0) goto L_0x0091
            androidx.constraintlayout.motion.widget.p r14 = r10.f1429u
            int r14 = r14.p()
        L_0x008c:
            float r14 = (float) r14
            float r14 = r14 / r0
            r10.G = r14
            goto L_0x0094
        L_0x0091:
            if (r14 <= 0) goto L_0x0094
            goto L_0x008c
        L_0x0094:
            int r14 = r10.getChildCount()
            java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.m> r0 = r10.E
            r0.clear()
            r0 = r12
        L_0x009e:
            if (r0 >= r14) goto L_0x00c0
            android.view.View r4 = r10.getChildAt(r0)
            androidx.constraintlayout.motion.widget.m r5 = new androidx.constraintlayout.motion.widget.m
            r5.<init>(r4)
            java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.m> r6 = r10.E
            r6.put(r4, r5)
            int r5 = r4.getId()
            java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.m> r6 = r10.E
            java.lang.Object r4 = r6.get(r4)
            androidx.constraintlayout.motion.widget.m r4 = (androidx.constraintlayout.motion.widget.m) r4
            r1.put(r5, r4)
            int r0 = r0 + 1
            goto L_0x009e
        L_0x00c0:
            r0 = 1
            r10.M = r0
            androidx.constraintlayout.motion.widget.MotionLayout$f r1 = r10.I1
            h0.f r4 = r10.f1874c
            androidx.constraintlayout.motion.widget.p r5 = r10.f1429u
            androidx.constraintlayout.widget.c r11 = r5.l(r11)
            r1.e(r4, r13, r11)
            r10.w0()
            androidx.constraintlayout.motion.widget.MotionLayout$f r11 = r10.I1
            r11.a()
            r10.e0()
            int r11 = r10.getWidth()
            int r13 = r10.getHeight()
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionHelper> r1 = r10.f1414f1
            if (r1 == 0) goto L_0x0139
            r1 = r12
        L_0x00e8:
            if (r1 >= r14) goto L_0x0101
            java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.m> r4 = r10.E
            android.view.View r5 = r10.getChildAt(r1)
            java.lang.Object r4 = r4.get(r5)
            androidx.constraintlayout.motion.widget.m r4 = (androidx.constraintlayout.motion.widget.m) r4
            if (r4 != 0) goto L_0x00f9
            goto L_0x00fe
        L_0x00f9:
            androidx.constraintlayout.motion.widget.p r5 = r10.f1429u
            r5.t(r4)
        L_0x00fe:
            int r1 = r1 + 1
            goto L_0x00e8
        L_0x0101:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionHelper> r1 = r10.f1414f1
            java.util.Iterator r1 = r1.iterator()
        L_0x0107:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0119
            java.lang.Object r4 = r1.next()
            androidx.constraintlayout.motion.widget.MotionHelper r4 = (androidx.constraintlayout.motion.widget.MotionHelper) r4
            java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.m> r5 = r10.E
            r4.D(r10, r5)
            goto L_0x0107
        L_0x0119:
            r1 = r12
        L_0x011a:
            if (r1 >= r14) goto L_0x015e
            java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.m> r4 = r10.E
            android.view.View r5 = r10.getChildAt(r1)
            java.lang.Object r4 = r4.get(r5)
            androidx.constraintlayout.motion.widget.m r4 = (androidx.constraintlayout.motion.widget.m) r4
            if (r4 != 0) goto L_0x012b
            goto L_0x0136
        L_0x012b:
            float r7 = r10.G
            long r8 = r10.getNanoTime()
            r5 = r11
            r6 = r13
            r4.I(r5, r6, r7, r8)
        L_0x0136:
            int r1 = r1 + 1
            goto L_0x011a
        L_0x0139:
            r1 = r12
        L_0x013a:
            if (r1 >= r14) goto L_0x015e
            java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.m> r4 = r10.E
            android.view.View r5 = r10.getChildAt(r1)
            java.lang.Object r4 = r4.get(r5)
            androidx.constraintlayout.motion.widget.m r4 = (androidx.constraintlayout.motion.widget.m) r4
            if (r4 != 0) goto L_0x014b
            goto L_0x015b
        L_0x014b:
            androidx.constraintlayout.motion.widget.p r5 = r10.f1429u
            r5.t(r4)
            float r7 = r10.G
            long r8 = r10.getNanoTime()
            r5 = r11
            r6 = r13
            r4.I(r5, r6, r7, r8)
        L_0x015b:
            int r1 = r1 + 1
            goto L_0x013a
        L_0x015e:
            androidx.constraintlayout.motion.widget.p r11 = r10.f1429u
            float r11 = r11.E()
            int r13 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r13 == 0) goto L_0x01ba
            r13 = 2139095039(0x7f7fffff, float:3.4028235E38)
            r1 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            r4 = r12
        L_0x016f:
            if (r4 >= r14) goto L_0x0191
            java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.m> r5 = r10.E
            android.view.View r6 = r10.getChildAt(r4)
            java.lang.Object r5 = r5.get(r6)
            androidx.constraintlayout.motion.widget.m r5 = (androidx.constraintlayout.motion.widget.m) r5
            float r6 = r5.n()
            float r5 = r5.o()
            float r5 = r5 + r6
            float r13 = java.lang.Math.min(r13, r5)
            float r1 = java.lang.Math.max(r1, r5)
            int r4 = r4 + 1
            goto L_0x016f
        L_0x0191:
            if (r12 >= r14) goto L_0x01ba
            java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.m> r4 = r10.E
            android.view.View r5 = r10.getChildAt(r12)
            java.lang.Object r4 = r4.get(r5)
            androidx.constraintlayout.motion.widget.m r4 = (androidx.constraintlayout.motion.widget.m) r4
            float r5 = r4.n()
            float r6 = r4.o()
            float r7 = r3 - r11
            float r7 = r3 / r7
            r4.f1617n = r7
            float r5 = r5 + r6
            float r5 = r5 - r13
            float r5 = r5 * r11
            float r6 = r1 - r13
            float r5 = r5 / r6
            float r5 = r11 - r5
            r4.f1616m = r5
            int r12 = r12 + 1
            goto L_0x0191
        L_0x01ba:
            r10.H = r2
            r10.I = r2
            r10.M = r0
            r10.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.J0(int, int, int, int):void");
    }

    public void K0() {
        this.I1.e(this.f1874c, this.f1429u.l(this.f1437y), this.f1429u.l(this.A));
        w0();
    }

    public void L0(int i10, androidx.constraintlayout.widget.c cVar) {
        p pVar = this.f1429u;
        if (pVar != null) {
            pVar.U(i10, cVar);
        }
        K0();
        if (this.f1439z == i10) {
            cVar.i(this);
        }
    }

    public void M0(int i10, View... viewArr) {
        p pVar = this.f1429u;
        if (pVar != null) {
            pVar.c0(i10, viewArr);
        } else {
            Log.e("MotionLayout", " no motionScene");
        }
    }

    /* access modifiers changed from: package-private */
    public void Y(float f10) {
        p pVar = this.f1429u;
        if (pVar != null) {
            float f11 = this.I;
            float f12 = this.H;
            if (f11 != f12 && this.L) {
                this.I = f12;
            }
            float f13 = this.I;
            if (f13 != f10) {
                this.S = false;
                this.K = f10;
                this.G = ((float) pVar.p()) / 1000.0f;
                setProgress(this.K);
                this.f1431v = null;
                this.f1433w = this.f1429u.s();
                this.L = false;
                this.F = getNanoTime();
                this.M = true;
                this.H = f13;
                this.I = f13;
                invalidate();
            }
        }
    }

    public boolean Z(int i10, m mVar) {
        p pVar = this.f1429u;
        if (pVar != null) {
            return pVar.g(i10, mVar);
        }
        return false;
    }

    public void c(View view, View view2, int i10, int i11) {
        this.f1407a1 = getNanoTime();
        this.f1409b1 = 0.0f;
        this.f1410c0 = 0.0f;
        this.Z0 = 0.0f;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00c7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dispatchDraw(android.graphics.Canvas r10) {
        /*
            r9 = this;
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionHelper> r0 = r9.f1414f1
            if (r0 == 0) goto L_0x0018
            java.util.Iterator r0 = r0.iterator()
        L_0x0008:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0018
            java.lang.Object r1 = r0.next()
            androidx.constraintlayout.motion.widget.MotionHelper r1 = (androidx.constraintlayout.motion.widget.MotionHelper) r1
            r1.C(r10)
            goto L_0x0008
        L_0x0018:
            r0 = 0
            r9.g0(r0)
            androidx.constraintlayout.motion.widget.p r1 = r9.f1429u
            if (r1 == 0) goto L_0x0027
            androidx.constraintlayout.motion.widget.t r1 = r1.f1667s
            if (r1 == 0) goto L_0x0027
            r1.c()
        L_0x0027:
            super.dispatchDraw(r10)
            androidx.constraintlayout.motion.widget.p r1 = r9.f1429u
            if (r1 != 0) goto L_0x002f
            return
        L_0x002f:
            int r1 = r9.Q
            r2 = 1
            r1 = r1 & r2
            if (r1 != r2) goto L_0x00f3
            boolean r1 = r9.isInEditMode()
            if (r1 != 0) goto L_0x00f3
            int r1 = r9.f1416h1
            int r1 = r1 + r2
            r9.f1416h1 = r1
            long r3 = r9.getNanoTime()
            long r5 = r9.f1417i1
            r7 = -1
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r1 == 0) goto L_0x0068
            long r5 = r3 - r5
            r7 = 200000000(0xbebc200, double:9.8813129E-316)
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r1 <= 0) goto L_0x006a
            int r1 = r9.f1416h1
            float r1 = (float) r1
            float r5 = (float) r5
            r6 = 814313567(0x3089705f, float:1.0E-9)
            float r5 = r5 * r6
            float r1 = r1 / r5
            r5 = 1120403456(0x42c80000, float:100.0)
            float r1 = r1 * r5
            int r1 = (int) r1
            float r1 = (float) r1
            float r1 = r1 / r5
            r9.f1418j1 = r1
            r9.f1416h1 = r0
        L_0x0068:
            r9.f1417i1 = r3
        L_0x006a:
            android.graphics.Paint r0 = new android.graphics.Paint
            r0.<init>()
            r1 = 1109917696(0x42280000, float:42.0)
            r0.setTextSize(r1)
            float r1 = r9.getProgress()
            r3 = 1148846080(0x447a0000, float:1000.0)
            float r1 = r1 * r3
            int r1 = (int) r1
            float r1 = (float) r1
            r3 = 1092616192(0x41200000, float:10.0)
            float r1 = r1 / r3
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            float r5 = r9.f1418j1
            r4.append(r5)
            java.lang.String r5 = " fps "
            r4.append(r5)
            int r5 = r9.f1437y
            java.lang.String r5 = androidx.constraintlayout.motion.widget.a.e(r9, r5)
            r4.append(r5)
            java.lang.String r5 = " -> "
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            int r4 = r9.A
            java.lang.String r4 = androidx.constraintlayout.motion.widget.a.e(r9, r4)
            r5.append(r4)
            java.lang.String r4 = " (progress: "
            r5.append(r4)
            r5.append(r1)
            java.lang.String r1 = " ) state="
            r5.append(r1)
            int r1 = r9.f1439z
            r4 = -1
            if (r1 != r4) goto L_0x00c7
            java.lang.String r1 = "undefined"
            goto L_0x00cb
        L_0x00c7:
            java.lang.String r1 = androidx.constraintlayout.motion.widget.a.e(r9, r1)
        L_0x00cb:
            r5.append(r1)
            java.lang.String r1 = r5.toString()
            r4 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r0.setColor(r4)
            r4 = 1093664768(0x41300000, float:11.0)
            int r5 = r9.getHeight()
            int r5 = r5 + -29
            float r5 = (float) r5
            r10.drawText(r1, r4, r5, r0)
            r4 = -7864184(0xffffffffff880088, float:NaN)
            r0.setColor(r4)
            int r4 = r9.getHeight()
            int r4 = r4 + -30
            float r4 = (float) r4
            r10.drawText(r1, r3, r4, r0)
        L_0x00f3:
            int r0 = r9.Q
            if (r0 <= r2) goto L_0x0111
            androidx.constraintlayout.motion.widget.MotionLayout$e r0 = r9.R
            if (r0 != 0) goto L_0x0102
            androidx.constraintlayout.motion.widget.MotionLayout$e r0 = new androidx.constraintlayout.motion.widget.MotionLayout$e
            r0.<init>()
            r9.R = r0
        L_0x0102:
            androidx.constraintlayout.motion.widget.MotionLayout$e r0 = r9.R
            java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.m> r1 = r9.E
            androidx.constraintlayout.motion.widget.p r2 = r9.f1429u
            int r2 = r2.p()
            int r3 = r9.Q
            r0.a(r10, r1, r2, r3)
        L_0x0111:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionHelper> r0 = r9.f1414f1
            if (r0 == 0) goto L_0x0129
            java.util.Iterator r0 = r0.iterator()
        L_0x0119:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0129
            java.lang.Object r1 = r0.next()
            androidx.constraintlayout.motion.widget.MotionHelper r1 = (androidx.constraintlayout.motion.widget.MotionHelper) r1
            r1.B(r10)
            goto L_0x0119
        L_0x0129:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.dispatchDraw(android.graphics.Canvas):void");
    }

    /* access modifiers changed from: package-private */
    public void f0(boolean z10) {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            m mVar = this.E.get(getChildAt(i10));
            if (mVar != null) {
                mVar.f(z10);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0249, code lost:
        if (r1 != r2) goto L_0x024d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0259, code lost:
        if (r1 != r2) goto L_0x024d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0209 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x021f  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0115 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x016d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g0(boolean r24) {
        /*
            r23 = this;
            r0 = r23
            long r1 = r0.J
            r3 = -1
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x0010
            long r1 = r23.getNanoTime()
            r0.J = r1
        L_0x0010:
            float r1 = r0.I
            r2 = 0
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r4 = -1
            r5 = 1065353216(0x3f800000, float:1.0)
            if (r3 <= 0) goto L_0x0020
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 >= 0) goto L_0x0020
            r0.f1439z = r4
        L_0x0020:
            boolean r3 = r0.f1411c1
            r6 = 1
            r7 = 0
            if (r3 != 0) goto L_0x0032
            boolean r3 = r0.M
            if (r3 == 0) goto L_0x023d
            if (r24 != 0) goto L_0x0032
            float r3 = r0.K
            int r3 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x023d
        L_0x0032:
            float r3 = r0.K
            float r3 = r3 - r1
            float r1 = java.lang.Math.signum(r3)
            long r8 = r23.getNanoTime()
            android.view.animation.Interpolator r3 = r0.f1431v
            boolean r10 = r3 instanceof androidx.constraintlayout.motion.widget.n
            r11 = 814313567(0x3089705f, float:1.0E-9)
            if (r10 != 0) goto L_0x0051
            long r12 = r0.J
            long r12 = r8 - r12
            float r10 = (float) r12
            float r10 = r10 * r1
            float r10 = r10 * r11
            float r12 = r0.G
            float r10 = r10 / r12
            goto L_0x0052
        L_0x0051:
            r10 = r2
        L_0x0052:
            float r12 = r0.I
            float r12 = r12 + r10
            boolean r13 = r0.L
            if (r13 == 0) goto L_0x005b
            float r12 = r0.K
        L_0x005b:
            int r13 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r13 <= 0) goto L_0x0065
            float r14 = r0.K
            int r14 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r14 >= 0) goto L_0x006f
        L_0x0065:
            int r14 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r14 > 0) goto L_0x0075
            float r14 = r0.K
            int r14 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r14 > 0) goto L_0x0075
        L_0x006f:
            float r12 = r0.K
            r0.M = r7
            r14 = r6
            goto L_0x0076
        L_0x0075:
            r14 = r7
        L_0x0076:
            r0.I = r12
            r0.H = r12
            r0.J = r8
            r15 = 2
            r16 = 925353388(0x3727c5ac, float:1.0E-5)
            if (r3 == 0) goto L_0x0101
            if (r14 != 0) goto L_0x0101
            boolean r14 = r0.S
            if (r14 == 0) goto L_0x00e4
            long r4 = r0.F
            long r4 = r8 - r4
            float r4 = (float) r4
            float r4 = r4 * r11
            float r3 = r3.getInterpolation(r4)
            android.view.animation.Interpolator r4 = r0.f1431v
            k0.b r5 = r0.T
            if (r4 != r5) goto L_0x00a2
            boolean r4 = r5.c()
            if (r4 == 0) goto L_0x00a0
            r4 = r15
            goto L_0x00a3
        L_0x00a0:
            r4 = r6
            goto L_0x00a3
        L_0x00a2:
            r4 = r7
        L_0x00a3:
            r0.I = r3
            r0.J = r8
            android.view.animation.Interpolator r5 = r0.f1431v
            boolean r8 = r5 instanceof androidx.constraintlayout.motion.widget.n
            if (r8 == 0) goto L_0x00e2
            androidx.constraintlayout.motion.widget.n r5 = (androidx.constraintlayout.motion.widget.n) r5
            float r5 = r5.a()
            r0.f1435x = r5
            float r8 = java.lang.Math.abs(r5)
            float r9 = r0.G
            float r8 = r8 * r9
            int r8 = (r8 > r16 ? 1 : (r8 == r16 ? 0 : -1))
            if (r8 > 0) goto L_0x00c4
            if (r4 != r15) goto L_0x00c4
            r0.M = r7
        L_0x00c4:
            int r8 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r8 <= 0) goto L_0x00d4
            r8 = 1065353216(0x3f800000, float:1.0)
            int r9 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r9 < 0) goto L_0x00d4
            r0.I = r8
            r0.M = r7
            r3 = 1065353216(0x3f800000, float:1.0)
        L_0x00d4:
            int r5 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r5 >= 0) goto L_0x00e2
            int r5 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r5 > 0) goto L_0x00e2
            r0.I = r2
            r0.M = r7
            r12 = r2
            goto L_0x0104
        L_0x00e2:
            r12 = r3
            goto L_0x0104
        L_0x00e4:
            float r3 = r3.getInterpolation(r12)
            android.view.animation.Interpolator r4 = r0.f1431v
            boolean r5 = r4 instanceof androidx.constraintlayout.motion.widget.n
            if (r5 == 0) goto L_0x00f5
            androidx.constraintlayout.motion.widget.n r4 = (androidx.constraintlayout.motion.widget.n) r4
            float r4 = r4.a()
            goto L_0x00fd
        L_0x00f5:
            float r12 = r12 + r10
            float r4 = r4.getInterpolation(r12)
            float r4 = r4 - r3
            float r4 = r4 * r1
            float r4 = r4 / r10
        L_0x00fd:
            r0.f1435x = r4
            r12 = r3
            goto L_0x0103
        L_0x0101:
            r0.f1435x = r10
        L_0x0103:
            r4 = r7
        L_0x0104:
            float r3 = r0.f1435x
            float r3 = java.lang.Math.abs(r3)
            int r3 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
            if (r3 <= 0) goto L_0x0113
            androidx.constraintlayout.motion.widget.MotionLayout$k r3 = androidx.constraintlayout.motion.widget.MotionLayout.k.MOVING
            r0.setState(r3)
        L_0x0113:
            if (r4 == r6) goto L_0x013c
            if (r13 <= 0) goto L_0x011d
            float r3 = r0.K
            int r3 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x0127
        L_0x011d:
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r3 > 0) goto L_0x012b
            float r3 = r0.K
            int r3 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r3 > 0) goto L_0x012b
        L_0x0127:
            float r12 = r0.K
            r0.M = r7
        L_0x012b:
            r3 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r4 >= 0) goto L_0x0135
            int r3 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r3 > 0) goto L_0x013c
        L_0x0135:
            r0.M = r7
            androidx.constraintlayout.motion.widget.MotionLayout$k r3 = androidx.constraintlayout.motion.widget.MotionLayout.k.FINISHED
            r0.setState(r3)
        L_0x013c:
            int r3 = r23.getChildCount()
            r0.f1411c1 = r7
            long r4 = r23.getNanoTime()
            r0.f1428t1 = r12
            android.view.animation.Interpolator r8 = r0.f1433w
            if (r8 != 0) goto L_0x014e
            r8 = r12
            goto L_0x0152
        L_0x014e:
            float r8 = r8.getInterpolation(r12)
        L_0x0152:
            android.view.animation.Interpolator r9 = r0.f1433w
            if (r9 == 0) goto L_0x016a
            float r10 = r0.G
            float r10 = r1 / r10
            float r10 = r10 + r12
            float r9 = r9.getInterpolation(r10)
            r0.f1435x = r9
            android.view.animation.Interpolator r10 = r0.f1433w
            float r10 = r10.getInterpolation(r12)
            float r9 = r9 - r10
            r0.f1435x = r9
        L_0x016a:
            r9 = r7
        L_0x016b:
            if (r9 >= r3) goto L_0x0193
            android.view.View r10 = r0.getChildAt(r9)
            java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.m> r11 = r0.E
            java.lang.Object r11 = r11.get(r10)
            r17 = r11
            androidx.constraintlayout.motion.widget.m r17 = (androidx.constraintlayout.motion.widget.m) r17
            if (r17 == 0) goto L_0x0190
            boolean r11 = r0.f1411c1
            f0.d r15 = r0.f1430u1
            r18 = r10
            r19 = r8
            r20 = r4
            r22 = r15
            boolean r10 = r17.x(r18, r19, r20, r22)
            r10 = r10 | r11
            r0.f1411c1 = r10
        L_0x0190:
            int r9 = r9 + 1
            goto L_0x016b
        L_0x0193:
            if (r13 <= 0) goto L_0x019b
            float r3 = r0.K
            int r3 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x01a5
        L_0x019b:
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r3 > 0) goto L_0x01a7
            float r3 = r0.K
            int r3 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r3 > 0) goto L_0x01a7
        L_0x01a5:
            r3 = r6
            goto L_0x01a8
        L_0x01a7:
            r3 = r7
        L_0x01a8:
            boolean r4 = r0.f1411c1
            if (r4 != 0) goto L_0x01b7
            boolean r4 = r0.M
            if (r4 != 0) goto L_0x01b7
            if (r3 == 0) goto L_0x01b7
            androidx.constraintlayout.motion.widget.MotionLayout$k r4 = androidx.constraintlayout.motion.widget.MotionLayout.k.FINISHED
            r0.setState(r4)
        L_0x01b7:
            boolean r4 = r0.f1421m1
            if (r4 == 0) goto L_0x01be
            r23.requestLayout()
        L_0x01be:
            boolean r4 = r0.f1411c1
            r3 = r3 ^ r6
            r3 = r3 | r4
            r0.f1411c1 = r3
            int r3 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r3 > 0) goto L_0x01e2
            int r3 = r0.f1437y
            r4 = -1
            if (r3 == r4) goto L_0x01e2
            int r4 = r0.f1439z
            if (r4 == r3) goto L_0x01e2
            r0.f1439z = r3
            androidx.constraintlayout.motion.widget.p r4 = r0.f1429u
            androidx.constraintlayout.widget.c r3 = r4.l(r3)
            r3.g(r0)
            androidx.constraintlayout.motion.widget.MotionLayout$k r3 = androidx.constraintlayout.motion.widget.MotionLayout.k.FINISHED
            r0.setState(r3)
            r7 = r6
        L_0x01e2:
            double r3 = (double) r12
            r8 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 < 0) goto L_0x0200
            int r3 = r0.f1439z
            int r4 = r0.A
            if (r3 == r4) goto L_0x0200
            r0.f1439z = r4
            androidx.constraintlayout.motion.widget.p r3 = r0.f1429u
            androidx.constraintlayout.widget.c r3 = r3.l(r4)
            r3.g(r0)
            androidx.constraintlayout.motion.widget.MotionLayout$k r3 = androidx.constraintlayout.motion.widget.MotionLayout.k.FINISHED
            r0.setState(r3)
            r7 = r6
        L_0x0200:
            boolean r3 = r0.f1411c1
            if (r3 != 0) goto L_0x021f
            boolean r3 = r0.M
            if (r3 == 0) goto L_0x0209
            goto L_0x021f
        L_0x0209:
            if (r13 <= 0) goto L_0x0211
            r3 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r4 == 0) goto L_0x0219
        L_0x0211:
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x0222
            int r3 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r3 != 0) goto L_0x0222
        L_0x0219:
            androidx.constraintlayout.motion.widget.MotionLayout$k r3 = androidx.constraintlayout.motion.widget.MotionLayout.k.FINISHED
            r0.setState(r3)
            goto L_0x0222
        L_0x021f:
            r23.invalidate()
        L_0x0222:
            boolean r3 = r0.f1411c1
            if (r3 != 0) goto L_0x023d
            boolean r3 = r0.M
            if (r3 != 0) goto L_0x023d
            if (r13 <= 0) goto L_0x0232
            r3 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r4 == 0) goto L_0x023a
        L_0x0232:
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x023d
            int r1 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x023d
        L_0x023a:
            r23.u0()
        L_0x023d:
            float r1 = r0.I
            r3 = 1065353216(0x3f800000, float:1.0)
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 < 0) goto L_0x0251
            int r1 = r0.f1439z
            int r2 = r0.A
            if (r1 == r2) goto L_0x024c
            goto L_0x024d
        L_0x024c:
            r6 = r7
        L_0x024d:
            r0.f1439z = r2
            r7 = r6
            goto L_0x025c
        L_0x0251:
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 > 0) goto L_0x025c
            int r1 = r0.f1439z
            int r2 = r0.f1437y
            if (r1 == r2) goto L_0x024c
            goto L_0x024d
        L_0x025c:
            boolean r1 = r0.J1
            r1 = r1 | r7
            r0.J1 = r1
            if (r7 == 0) goto L_0x026a
            boolean r1 = r0.f1432v1
            if (r1 != 0) goto L_0x026a
            r23.requestLayout()
        L_0x026a:
            float r1 = r0.I
            r0.H = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.g0(boolean):void");
    }

    public int[] getConstraintSetIds() {
        p pVar = this.f1429u;
        if (pVar == null) {
            return null;
        }
        return pVar.n();
    }

    public int getCurrentState() {
        return this.f1439z;
    }

    public ArrayList<p.b> getDefinedTransitions() {
        p pVar = this.f1429u;
        if (pVar == null) {
            return null;
        }
        return pVar.o();
    }

    public b getDesignTool() {
        if (this.V == null) {
            this.V = new b(this);
        }
        return this.V;
    }

    public int getEndState() {
        return this.A;
    }

    /* access modifiers changed from: protected */
    public long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.I;
    }

    public p getScene() {
        return this.f1429u;
    }

    public int getStartState() {
        return this.f1437y;
    }

    public float getTargetPosition() {
        return this.K;
    }

    public Bundle getTransitionState() {
        if (this.f1434w1 == null) {
            this.f1434w1 = new i();
        }
        this.f1434w1.c();
        return this.f1434w1.b();
    }

    public long getTransitionTimeMs() {
        p pVar = this.f1429u;
        if (pVar != null) {
            this.G = ((float) pVar.p()) / 1000.0f;
        }
        return (long) (this.G * 1000.0f);
    }

    public float getVelocity() {
        return this.f1435x;
    }

    public void i(View view, int i10) {
        p pVar = this.f1429u;
        if (pVar != null) {
            float f10 = this.f1409b1;
            if (f10 != 0.0f) {
                pVar.Q(this.f1410c0 / f10, this.Z0 / f10);
            }
        }
    }

    public boolean isAttachedToWindow() {
        return Build.VERSION.SDK_INT >= 19 ? super.isAttachedToWindow() : getWindowToken() != null;
    }

    public void j(View view, int i10, int i11, int[] iArr, int i12) {
        p.b bVar;
        q B2;
        int q10;
        p pVar = this.f1429u;
        if (pVar != null && (bVar = pVar.f1651c) != null && bVar.C()) {
            int i13 = -1;
            if (!bVar.C() || (B2 = bVar.B()) == null || (q10 = B2.q()) == -1 || view.getId() == q10) {
                if (pVar.w()) {
                    q B3 = bVar.B();
                    if (!(B3 == null || (B3.e() & 4) == 0)) {
                        i13 = i11;
                    }
                    float f10 = this.H;
                    if ((f10 == 1.0f || f10 == 0.0f) && view.canScrollVertically(i13)) {
                        return;
                    }
                }
                if (!(bVar.B() == null || (bVar.B().e() & 1) == 0)) {
                    float x10 = pVar.x((float) i10, (float) i11);
                    float f11 = this.I;
                    if ((f11 <= 0.0f && x10 < 0.0f) || (f11 >= 1.0f && x10 > 0.0f)) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            view.setNestedScrollingEnabled(false);
                            view.post(new a(this, view));
                            return;
                        }
                        return;
                    }
                }
                float f12 = this.H;
                long nanoTime = getNanoTime();
                float f13 = (float) i10;
                this.f1410c0 = f13;
                float f14 = (float) i11;
                this.Z0 = f14;
                this.f1409b1 = (float) (((double) (nanoTime - this.f1407a1)) * 1.0E-9d);
                this.f1407a1 = nanoTime;
                pVar.P(f13, f14);
                if (f12 != this.H) {
                    iArr[0] = i10;
                    iArr[1] = i11;
                }
                g0(false);
                if (iArr[0] != 0 || iArr[1] != 0) {
                    this.f1408b0 = true;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void j0() {
        int i10;
        CopyOnWriteArrayList<j> copyOnWriteArrayList;
        if ((this.N != null || ((copyOnWriteArrayList = this.f1415g1) != null && !copyOnWriteArrayList.isEmpty())) && this.f1419k1 == -1) {
            this.f1419k1 = this.f1439z;
            if (!this.N1.isEmpty()) {
                ArrayList<Integer> arrayList = this.N1;
                i10 = arrayList.get(arrayList.size() - 1).intValue();
            } else {
                i10 = -1;
            }
            int i11 = this.f1439z;
            if (!(i10 == i11 || i11 == -1)) {
                this.N1.add(Integer.valueOf(i11));
            }
        }
        v0();
        Runnable runnable = this.f1436x1;
        if (runnable != null) {
            runnable.run();
        }
        int[] iArr = this.f1438y1;
        if (iArr != null && this.f1440z1 > 0) {
            G0(iArr[0]);
            int[] iArr2 = this.f1438y1;
            System.arraycopy(iArr2, 1, iArr2, 0, iArr2.length - 1);
            this.f1440z1--;
        }
    }

    public void k0(int i10, boolean z10, float f10) {
        j jVar = this.N;
        if (jVar != null) {
            jVar.c(this, i10, z10, f10);
        }
        CopyOnWriteArrayList<j> copyOnWriteArrayList = this.f1415g1;
        if (copyOnWriteArrayList != null) {
            Iterator<j> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                it.next().c(this, i10, z10, f10);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void l0(int i10, float f10, float f11, float f12, float[] fArr) {
        String str;
        HashMap<View, m> hashMap = this.E;
        View l10 = l(i10);
        m mVar = hashMap.get(l10);
        if (mVar != null) {
            mVar.l(f10, f11, f12, fArr);
            float y10 = l10.getY();
            this.O = f10;
            this.P = y10;
            return;
        }
        if (l10 == null) {
            str = "" + i10;
        } else {
            str = l10.getContext().getResources().getResourceName(i10);
        }
        Log.w("MotionLayout", "WARNING could not find view id " + str);
    }

    public void m(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        if (!(!this.f1408b0 && i10 == 0 && i11 == 0)) {
            iArr[0] = iArr[0] + i12;
            iArr[1] = iArr[1] + i13;
        }
        this.f1408b0 = false;
    }

    public androidx.constraintlayout.widget.c m0(int i10) {
        p pVar = this.f1429u;
        if (pVar == null) {
            return null;
        }
        return pVar.l(i10);
    }

    public void n(View view, int i10, int i11, int i12, int i13, int i14) {
    }

    /* access modifiers changed from: package-private */
    public m n0(int i10) {
        return this.E.get(findViewById(i10));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r1.f1651c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean o(android.view.View r1, android.view.View r2, int r3, int r4) {
        /*
            r0 = this;
            androidx.constraintlayout.motion.widget.p r1 = r0.f1429u
            if (r1 == 0) goto L_0x0021
            androidx.constraintlayout.motion.widget.p$b r1 = r1.f1651c
            if (r1 == 0) goto L_0x0021
            androidx.constraintlayout.motion.widget.q r1 = r1.B()
            if (r1 == 0) goto L_0x0021
            androidx.constraintlayout.motion.widget.p r1 = r0.f1429u
            androidx.constraintlayout.motion.widget.p$b r1 = r1.f1651c
            androidx.constraintlayout.motion.widget.q r1 = r1.B()
            int r1 = r1.e()
            r1 = r1 & 2
            if (r1 == 0) goto L_0x001f
            goto L_0x0021
        L_0x001f:
            r1 = 1
            return r1
        L_0x0021:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.o(android.view.View, android.view.View, int, int):boolean");
    }

    public p.b o0(int i10) {
        return this.f1429u.G(i10);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        p.b bVar;
        int i10;
        Display display;
        super.onAttachedToWindow();
        if (Build.VERSION.SDK_INT >= 17 && (display = getDisplay()) != null) {
            display.getRotation();
        }
        p pVar = this.f1429u;
        if (!(pVar == null || (i10 = this.f1439z) == -1)) {
            androidx.constraintlayout.widget.c l10 = pVar.l(i10);
            this.f1429u.T(this);
            ArrayList<MotionHelper> arrayList = this.f1414f1;
            if (arrayList != null) {
                Iterator<MotionHelper> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().A(this);
                }
            }
            if (l10 != null) {
                l10.i(this);
            }
            this.f1437y = this.f1439z;
        }
        u0();
        i iVar = this.f1434w1;
        if (iVar == null) {
            p pVar2 = this.f1429u;
            if (pVar2 != null && (bVar = pVar2.f1651c) != null && bVar.x() == 4) {
                D0();
                setState(k.SETUP);
                setState(k.MOVING);
            }
        } else if (this.G1) {
            post(new b());
        } else {
            iVar.a();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        q B2;
        int q10;
        RectF p10;
        p pVar = this.f1429u;
        if (pVar != null && this.D) {
            t tVar = pVar.f1667s;
            if (tVar != null) {
                tVar.h(motionEvent);
            }
            p.b bVar = this.f1429u.f1651c;
            if (bVar != null && bVar.C() && (B2 = bVar.B()) != null && ((motionEvent.getAction() != 0 || (p10 = B2.p(this, new RectF())) == null || p10.contains(motionEvent.getX(), motionEvent.getY())) && (q10 = B2.q()) != -1)) {
                View view = this.L1;
                if (view == null || view.getId() != q10) {
                    this.L1 = findViewById(q10);
                }
                View view2 = this.L1;
                if (view2 != null) {
                    this.K1.set((float) view2.getLeft(), (float) this.L1.getTop(), (float) this.L1.getRight(), (float) this.L1.getBottom());
                    if (this.K1.contains(motionEvent.getX(), motionEvent.getY()) && !q0((float) this.L1.getLeft(), (float) this.L1.getTop(), this.L1, motionEvent)) {
                        return onTouchEvent(motionEvent);
                    }
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        this.f1432v1 = true;
        try {
            if (this.f1429u == null) {
                super.onLayout(z10, i10, i11, i12, i13);
                return;
            }
            int i14 = i12 - i10;
            int i15 = i13 - i11;
            if (!(this.W == i14 && this.f1406a0 == i15)) {
                w0();
                g0(true);
            }
            this.W = i14;
            this.f1406a0 = i15;
            this.f1432v1 = false;
        } finally {
            this.f1432v1 = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        if (this.f1429u == null) {
            super.onMeasure(i10, i11);
            return;
        }
        boolean z10 = false;
        boolean z11 = (this.B == i10 && this.C == i11) ? false : true;
        if (this.J1) {
            this.J1 = false;
            u0();
            v0();
            z11 = true;
        }
        if (this.f1879h) {
            z11 = true;
        }
        this.B = i10;
        this.C = i11;
        int F2 = this.f1429u.F();
        int q10 = this.f1429u.q();
        if ((z11 || this.I1.f(F2, q10)) && this.f1437y != -1) {
            super.onMeasure(i10, i11);
            this.I1.e(this.f1874c, this.f1429u.l(F2), this.f1429u.l(q10));
            this.I1.h();
            this.I1.i(F2, q10);
        } else {
            if (z11) {
                super.onMeasure(i10, i11);
            }
            z10 = true;
        }
        if (this.f1421m1 || z10) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int Y = this.f1874c.Y() + getPaddingLeft() + getPaddingRight();
            int z12 = this.f1874c.z() + paddingTop;
            int i12 = this.f1426r1;
            if (i12 == Integer.MIN_VALUE || i12 == 0) {
                int i13 = this.f1422n1;
                Y = (int) (((float) i13) + (this.f1428t1 * ((float) (this.f1424p1 - i13))));
                requestLayout();
            }
            int i14 = this.f1427s1;
            if (i14 == Integer.MIN_VALUE || i14 == 0) {
                int i15 = this.f1423o1;
                z12 = (int) (((float) i15) + (this.f1428t1 * ((float) (this.f1425q1 - i15))));
                requestLayout();
            }
            setMeasuredDimension(Y, z12);
        }
        h0();
    }

    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        return false;
    }

    public boolean onNestedPreFling(View view, float f10, float f11) {
        return false;
    }

    public void onRtlPropertiesChanged(int i10) {
        p pVar = this.f1429u;
        if (pVar != null) {
            pVar.W(r());
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        p pVar = this.f1429u;
        if (pVar == null || !this.D || !pVar.b0()) {
            return super.onTouchEvent(motionEvent);
        }
        p.b bVar = this.f1429u.f1651c;
        if (bVar != null && !bVar.C()) {
            return super.onTouchEvent(motionEvent);
        }
        this.f1429u.R(motionEvent, getCurrentState(), this);
        if (this.f1429u.f1651c.D(4)) {
            return this.f1429u.f1651c.B().r();
        }
        return true;
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof MotionHelper) {
            MotionHelper motionHelper = (MotionHelper) view;
            if (this.f1415g1 == null) {
                this.f1415g1 = new CopyOnWriteArrayList<>();
            }
            this.f1415g1.add(motionHelper);
            if (motionHelper.z()) {
                if (this.f1412d1 == null) {
                    this.f1412d1 = new ArrayList<>();
                }
                this.f1412d1.add(motionHelper);
            }
            if (motionHelper.y()) {
                if (this.f1413e1 == null) {
                    this.f1413e1 = new ArrayList<>();
                }
                this.f1413e1.add(motionHelper);
            }
            if (motionHelper.x()) {
                if (this.f1414f1 == null) {
                    this.f1414f1 = new ArrayList<>();
                }
                this.f1414f1.add(motionHelper);
            }
        }
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList<MotionHelper> arrayList = this.f1412d1;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList<MotionHelper> arrayList2 = this.f1413e1;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    public void p0(View view, float f10, float f11, float[] fArr, int i10) {
        float f12;
        float f13 = this.f1435x;
        float f14 = this.I;
        if (this.f1431v != null) {
            float signum = Math.signum(this.K - f14);
            float interpolation = this.f1431v.getInterpolation(this.I + 1.0E-5f);
            float interpolation2 = this.f1431v.getInterpolation(this.I);
            f13 = (signum * ((interpolation - interpolation2) / 1.0E-5f)) / this.G;
            f12 = interpolation2;
        } else {
            f12 = f14;
        }
        Interpolator interpolator = this.f1431v;
        if (interpolator instanceof n) {
            f13 = ((n) interpolator).a();
        }
        m mVar = this.E.get(view);
        if ((i10 & 1) == 0) {
            mVar.r(f12, view.getWidth(), view.getHeight(), f10, f11, fArr);
        } else {
            mVar.l(f12, f10, f11, fArr);
        }
        if (i10 < 2) {
            fArr[0] = fArr[0] * f13;
            fArr[1] = fArr[1] * f13;
        }
    }

    public void requestLayout() {
        p pVar;
        p.b bVar;
        if (!this.f1421m1 && this.f1439z == -1 && (pVar = this.f1429u) != null && (bVar = pVar.f1651c) != null) {
            int z10 = bVar.z();
            if (z10 != 0) {
                if (z10 == 2) {
                    int childCount = getChildCount();
                    for (int i10 = 0; i10 < childCount; i10++) {
                        this.E.get(getChildAt(i10)).z();
                    }
                    return;
                }
            } else {
                return;
            }
        }
        super.requestLayout();
    }

    public boolean s0() {
        return this.D;
    }

    public void setDebugMode(int i10) {
        this.Q = i10;
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean z10) {
        this.G1 = z10;
    }

    public void setInteractionEnabled(boolean z10) {
        this.D = z10;
    }

    public void setInterpolatedProgress(float f10) {
        if (this.f1429u != null) {
            setState(k.MOVING);
            Interpolator s10 = this.f1429u.s();
            if (s10 != null) {
                setProgress(s10.getInterpolation(f10));
                return;
            }
        }
        setProgress(f10);
    }

    public void setOnHide(float f10) {
        ArrayList<MotionHelper> arrayList = this.f1413e1;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f1413e1.get(i10).setProgress(f10);
            }
        }
    }

    public void setOnShow(float f10) {
        ArrayList<MotionHelper> arrayList = this.f1412d1;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f1412d1.get(i10).setProgress(f10);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0044, code lost:
        if (r5.I == 0.0f) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0066, code lost:
        if (r5.I == 1.0f) goto L_0x0046;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0075 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProgress(float r6) {
        /*
            r5 = this;
            r0 = 0
            int r1 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            r2 = 1065353216(0x3f800000, float:1.0)
            if (r1 < 0) goto L_0x000b
            int r3 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x0012
        L_0x000b:
            java.lang.String r3 = "MotionLayout"
            java.lang.String r4 = "Warning! Progress is defined for values between 0.0 and 1.0 inclusive"
            android.util.Log.w(r3, r4)
        L_0x0012:
            boolean r3 = r5.isAttachedToWindow()
            if (r3 != 0) goto L_0x0029
            androidx.constraintlayout.motion.widget.MotionLayout$i r0 = r5.f1434w1
            if (r0 != 0) goto L_0x0023
            androidx.constraintlayout.motion.widget.MotionLayout$i r0 = new androidx.constraintlayout.motion.widget.MotionLayout$i
            r0.<init>()
            r5.f1434w1 = r0
        L_0x0023:
            androidx.constraintlayout.motion.widget.MotionLayout$i r0 = r5.f1434w1
            r0.e(r6)
            return
        L_0x0029:
            if (r1 > 0) goto L_0x0049
            float r1 = r5.I
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x003c
            int r1 = r5.f1439z
            int r2 = r5.A
            if (r1 != r2) goto L_0x003c
            androidx.constraintlayout.motion.widget.MotionLayout$k r1 = androidx.constraintlayout.motion.widget.MotionLayout.k.MOVING
            r5.setState(r1)
        L_0x003c:
            int r1 = r5.f1437y
            r5.f1439z = r1
            float r1 = r5.I
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 != 0) goto L_0x0071
        L_0x0046:
            androidx.constraintlayout.motion.widget.MotionLayout$k r0 = androidx.constraintlayout.motion.widget.MotionLayout.k.FINISHED
            goto L_0x006e
        L_0x0049:
            int r1 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r1 < 0) goto L_0x0069
            float r1 = r5.I
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 != 0) goto L_0x005e
            int r0 = r5.f1439z
            int r1 = r5.f1437y
            if (r0 != r1) goto L_0x005e
            androidx.constraintlayout.motion.widget.MotionLayout$k r0 = androidx.constraintlayout.motion.widget.MotionLayout.k.MOVING
            r5.setState(r0)
        L_0x005e:
            int r0 = r5.A
            r5.f1439z = r0
            float r0 = r5.I
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0071
            goto L_0x0046
        L_0x0069:
            r0 = -1
            r5.f1439z = r0
            androidx.constraintlayout.motion.widget.MotionLayout$k r0 = androidx.constraintlayout.motion.widget.MotionLayout.k.MOVING
        L_0x006e:
            r5.setState(r0)
        L_0x0071:
            androidx.constraintlayout.motion.widget.p r0 = r5.f1429u
            if (r0 != 0) goto L_0x0076
            return
        L_0x0076:
            r0 = 1
            r5.L = r0
            r5.K = r6
            r5.H = r6
            r1 = -1
            r5.J = r1
            r5.F = r1
            r6 = 0
            r5.f1431v = r6
            r5.M = r0
            r5.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.setProgress(float):void");
    }

    public void setScene(p pVar) {
        this.f1429u = pVar;
        pVar.W(r());
        w0();
    }

    /* access modifiers changed from: package-private */
    public void setStartState(int i10) {
        if (!isAttachedToWindow()) {
            if (this.f1434w1 == null) {
                this.f1434w1 = new i();
            }
            this.f1434w1.f(i10);
            this.f1434w1.d(i10);
            return;
        }
        this.f1439z = i10;
    }

    /* access modifiers changed from: package-private */
    public void setState(k kVar) {
        k kVar2 = k.FINISHED;
        if (kVar != kVar2 || this.f1439z != -1) {
            k kVar3 = this.H1;
            this.H1 = kVar;
            k kVar4 = k.MOVING;
            if (kVar3 == kVar4 && kVar == kVar4) {
                i0();
            }
            int i10 = c.f1443a[kVar3.ordinal()];
            if (i10 == 1 || i10 == 2) {
                if (kVar == kVar4) {
                    i0();
                }
                if (kVar != kVar2) {
                    return;
                }
            } else if (!(i10 == 3 && kVar == kVar2)) {
                return;
            }
            j0();
        }
    }

    public void setTransition(int i10) {
        p pVar;
        int i11;
        if (this.f1429u != null) {
            p.b o02 = o0(i10);
            this.f1437y = o02.A();
            this.A = o02.y();
            if (!isAttachedToWindow()) {
                if (this.f1434w1 == null) {
                    this.f1434w1 = new i();
                }
                this.f1434w1.f(this.f1437y);
                this.f1434w1.d(this.A);
                return;
            }
            float f10 = Float.NaN;
            int i12 = this.f1439z;
            float f11 = 0.0f;
            if (i12 == this.f1437y) {
                f10 = 0.0f;
            } else if (i12 == this.A) {
                f10 = 1.0f;
            }
            this.f1429u.Y(o02);
            this.I1.e(this.f1874c, this.f1429u.l(this.f1437y), this.f1429u.l(this.A));
            w0();
            if (this.I != f10) {
                if (f10 == 0.0f) {
                    f0(true);
                    pVar = this.f1429u;
                    i11 = this.f1437y;
                } else if (f10 == 1.0f) {
                    f0(false);
                    pVar = this.f1429u;
                    i11 = this.A;
                }
                pVar.l(i11).i(this);
            }
            if (!Float.isNaN(f10)) {
                f11 = f10;
            }
            this.I = f11;
            if (Float.isNaN(f10)) {
                Log.v("MotionLayout", a.b() + " transitionToStart ");
                F0();
                return;
            }
            setProgress(f10);
        }
    }

    /* access modifiers changed from: protected */
    public void setTransition(p.b bVar) {
        this.f1429u.Y(bVar);
        setState(k.SETUP);
        float f10 = this.f1439z == this.f1429u.q() ? 1.0f : 0.0f;
        this.I = f10;
        this.H = f10;
        this.K = f10;
        this.J = bVar.D(1) ? -1 : getNanoTime();
        int F2 = this.f1429u.F();
        int q10 = this.f1429u.q();
        if (F2 != this.f1437y || q10 != this.A) {
            this.f1437y = F2;
            this.A = q10;
            this.f1429u.X(F2, q10);
            this.I1.e(this.f1874c, this.f1429u.l(this.f1437y), this.f1429u.l(this.A));
            this.I1.i(this.f1437y, this.A);
            this.I1.h();
            w0();
        }
    }

    public void setTransitionDuration(int i10) {
        p pVar = this.f1429u;
        if (pVar == null) {
            Log.e("MotionLayout", "MotionScene not defined");
        } else {
            pVar.V(i10);
        }
    }

    public void setTransitionListener(j jVar) {
        this.N = jVar;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.f1434w1 == null) {
            this.f1434w1 = new i();
        }
        this.f1434w1.g(bundle);
        if (isAttachedToWindow()) {
            this.f1434w1.a();
        }
    }

    /* access modifiers changed from: protected */
    public void t(int i10) {
        this.f1882k = null;
    }

    /* access modifiers changed from: protected */
    public g t0() {
        return h.a();
    }

    public String toString() {
        Context context = getContext();
        return a.c(context, this.f1437y) + "->" + a.c(context, this.A) + " (pos:" + this.I + " Dpos/Dt:" + this.f1435x;
    }

    /* access modifiers changed from: package-private */
    public void u0() {
        p pVar = this.f1429u;
        if (pVar != null) {
            if (pVar.h(this, this.f1439z)) {
                requestLayout();
                return;
            }
            int i10 = this.f1439z;
            if (i10 != -1) {
                this.f1429u.f(this, i10);
            }
            if (this.f1429u.b0()) {
                this.f1429u.Z();
            }
        }
    }

    public void w0() {
        this.I1.h();
        invalidate();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0040, code lost:
        if (r3 > 0.5f) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002d, code lost:
        if (r4 > 0) goto L_0x002f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void x0(float r3, float r4) {
        /*
            r2 = this;
            boolean r0 = r2.isAttachedToWindow()
            if (r0 != 0) goto L_0x001c
            androidx.constraintlayout.motion.widget.MotionLayout$i r0 = r2.f1434w1
            if (r0 != 0) goto L_0x0011
            androidx.constraintlayout.motion.widget.MotionLayout$i r0 = new androidx.constraintlayout.motion.widget.MotionLayout$i
            r0.<init>()
            r2.f1434w1 = r0
        L_0x0011:
            androidx.constraintlayout.motion.widget.MotionLayout$i r0 = r2.f1434w1
            r0.e(r3)
            androidx.constraintlayout.motion.widget.MotionLayout$i r3 = r2.f1434w1
            r3.h(r4)
            return
        L_0x001c:
            r2.setProgress(r3)
            androidx.constraintlayout.motion.widget.MotionLayout$k r0 = androidx.constraintlayout.motion.widget.MotionLayout.k.MOVING
            r2.setState(r0)
            r2.f1435x = r4
            r0 = 0
            int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            r1 = 1065353216(0x3f800000, float:1.0)
            if (r4 == 0) goto L_0x0034
            if (r4 <= 0) goto L_0x0030
        L_0x002f:
            r0 = r1
        L_0x0030:
            r2.Y(r0)
            goto L_0x0043
        L_0x0034:
            int r4 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r4 == 0) goto L_0x0043
            int r4 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r4 == 0) goto L_0x0043
            r4 = 1056964608(0x3f000000, float:0.5)
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x0030
            goto L_0x002f
        L_0x0043:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.x0(float, float):void");
    }

    public void y0(int i10, int i11, int i12) {
        setState(k.SETUP);
        this.f1439z = i10;
        this.f1437y = -1;
        this.A = -1;
        androidx.constraintlayout.widget.b bVar = this.f1882k;
        if (bVar != null) {
            bVar.d(i10, (float) i11, (float) i12);
            return;
        }
        p pVar = this.f1429u;
        if (pVar != null) {
            pVar.l(i10).i(this);
        }
    }

    public void z0(int i10, int i11) {
        if (!isAttachedToWindow()) {
            if (this.f1434w1 == null) {
                this.f1434w1 = new i();
            }
            this.f1434w1.f(i10);
            this.f1434w1.d(i11);
            return;
        }
        p pVar = this.f1429u;
        if (pVar != null) {
            this.f1437y = i10;
            this.A = i11;
            pVar.X(i10, i11);
            this.I1.e(this.f1874c, this.f1429u.l(i10), this.f1429u.l(i11));
            w0();
            this.I = 0.0f;
            F0();
        }
    }
}
