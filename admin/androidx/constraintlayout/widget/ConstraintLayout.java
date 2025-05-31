package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import h0.d;
import h0.e;
import h0.f;
import h0.h;
import i0.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.sourceforge.zbar.Config;

public class ConstraintLayout extends ViewGroup {

    /* renamed from: t  reason: collision with root package name */
    private static g f1871t;

    /* renamed from: a  reason: collision with root package name */
    SparseArray<View> f1872a = new SparseArray<>();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<ConstraintHelper> f1873b = new ArrayList<>(4);
    /* access modifiers changed from: protected */

    /* renamed from: c  reason: collision with root package name */
    public f f1874c = new f();

    /* renamed from: d  reason: collision with root package name */
    private int f1875d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f1876e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f1877f = Integer.MAX_VALUE;

    /* renamed from: g  reason: collision with root package name */
    private int f1878g = Integer.MAX_VALUE;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f1879h = true;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public int f1880i = Config.Y_DENSITY;

    /* renamed from: j  reason: collision with root package name */
    private c f1881j = null;

    /* renamed from: k  reason: collision with root package name */
    protected b f1882k = null;

    /* renamed from: l  reason: collision with root package name */
    private int f1883l = -1;

    /* renamed from: m  reason: collision with root package name */
    private HashMap<String, Integer> f1884m = new HashMap<>();

    /* renamed from: n  reason: collision with root package name */
    private int f1885n = -1;

    /* renamed from: o  reason: collision with root package name */
    private int f1886o = -1;

    /* renamed from: p  reason: collision with root package name */
    private SparseArray<e> f1887p = new SparseArray<>();

    /* renamed from: q  reason: collision with root package name */
    b f1888q = new b(this);

    /* renamed from: r  reason: collision with root package name */
    private int f1889r = 0;

    /* renamed from: s  reason: collision with root package name */
    private int f1890s = 0;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int A = Integer.MIN_VALUE;
        public int B = Integer.MIN_VALUE;
        public int C = Integer.MIN_VALUE;
        public int D = 0;
        public float E = 0.5f;
        public float F = 0.5f;
        public String G = null;
        public float H = -1.0f;
        public float I = -1.0f;
        public int J = 0;
        public int K = 0;
        public int L = 0;
        public int M = 0;
        public int N = 0;
        public int O = 0;
        public int P = 0;
        public int Q = 0;
        public float R = 1.0f;
        public float S = 1.0f;
        public int T = -1;
        public int U = -1;
        public int V = -1;
        public boolean W = false;
        public boolean X = false;
        public String Y = null;
        public int Z = 0;

        /* renamed from: a  reason: collision with root package name */
        public int f1891a = -1;

        /* renamed from: a0  reason: collision with root package name */
        boolean f1892a0 = true;

        /* renamed from: b  reason: collision with root package name */
        public int f1893b = -1;

        /* renamed from: b0  reason: collision with root package name */
        boolean f1894b0 = true;

        /* renamed from: c  reason: collision with root package name */
        public float f1895c = -1.0f;

        /* renamed from: c0  reason: collision with root package name */
        boolean f1896c0 = false;

        /* renamed from: d  reason: collision with root package name */
        public boolean f1897d = true;

        /* renamed from: d0  reason: collision with root package name */
        boolean f1898d0 = false;

        /* renamed from: e  reason: collision with root package name */
        public int f1899e = -1;

        /* renamed from: e0  reason: collision with root package name */
        boolean f1900e0 = false;

        /* renamed from: f  reason: collision with root package name */
        public int f1901f = -1;

        /* renamed from: f0  reason: collision with root package name */
        boolean f1902f0 = false;

        /* renamed from: g  reason: collision with root package name */
        public int f1903g = -1;

        /* renamed from: g0  reason: collision with root package name */
        boolean f1904g0 = false;

        /* renamed from: h  reason: collision with root package name */
        public int f1905h = -1;

        /* renamed from: h0  reason: collision with root package name */
        int f1906h0 = -1;

        /* renamed from: i  reason: collision with root package name */
        public int f1907i = -1;

        /* renamed from: i0  reason: collision with root package name */
        int f1908i0 = -1;

        /* renamed from: j  reason: collision with root package name */
        public int f1909j = -1;

        /* renamed from: j0  reason: collision with root package name */
        int f1910j0 = -1;

        /* renamed from: k  reason: collision with root package name */
        public int f1911k = -1;

        /* renamed from: k0  reason: collision with root package name */
        int f1912k0 = -1;

        /* renamed from: l  reason: collision with root package name */
        public int f1913l = -1;

        /* renamed from: l0  reason: collision with root package name */
        int f1914l0 = Integer.MIN_VALUE;

        /* renamed from: m  reason: collision with root package name */
        public int f1915m = -1;

        /* renamed from: m0  reason: collision with root package name */
        int f1916m0 = Integer.MIN_VALUE;

        /* renamed from: n  reason: collision with root package name */
        public int f1917n = -1;

        /* renamed from: n0  reason: collision with root package name */
        float f1918n0 = 0.5f;

        /* renamed from: o  reason: collision with root package name */
        public int f1919o = -1;

        /* renamed from: o0  reason: collision with root package name */
        int f1920o0;

        /* renamed from: p  reason: collision with root package name */
        public int f1921p = -1;

        /* renamed from: p0  reason: collision with root package name */
        int f1922p0;

        /* renamed from: q  reason: collision with root package name */
        public int f1923q = 0;

        /* renamed from: q0  reason: collision with root package name */
        float f1924q0;

        /* renamed from: r  reason: collision with root package name */
        public float f1925r = 0.0f;

        /* renamed from: r0  reason: collision with root package name */
        e f1926r0 = new e();

        /* renamed from: s  reason: collision with root package name */
        public int f1927s = -1;

        /* renamed from: t  reason: collision with root package name */
        public int f1928t = -1;

        /* renamed from: u  reason: collision with root package name */
        public int f1929u = -1;

        /* renamed from: v  reason: collision with root package name */
        public int f1930v = -1;

        /* renamed from: w  reason: collision with root package name */
        public int f1931w = Integer.MIN_VALUE;

        /* renamed from: x  reason: collision with root package name */
        public int f1932x = Integer.MIN_VALUE;

        /* renamed from: y  reason: collision with root package name */
        public int f1933y = Integer.MIN_VALUE;

        /* renamed from: z  reason: collision with root package name */
        public int f1934z = Integer.MIN_VALUE;

        private static class a {

            /* renamed from: a  reason: collision with root package name */
            public static final SparseIntArray f1935a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f1935a = sparseIntArray;
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintWidth, 64);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintHeight, 65);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintBaseline_toTopOf, 52);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintBaseline_toBottomOf, 53);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintCircle, 2);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                sparseIntArray.append(f.ConstraintLayout_Layout_guidelineUseRtl, 67);
                sparseIntArray.append(f.ConstraintLayout_Layout_android_orientation, 1);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_goneMarginBaseline, 55);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_marginBaseline, 54);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_constraintTag, 51);
                sparseIntArray.append(f.ConstraintLayout_Layout_layout_wrapBehaviorInParent, 66);
            }
        }

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x01ed, code lost:
            android.util.Log.e("ConstraintLayout", r5);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public LayoutParams(android.content.Context r11, android.util.AttributeSet r12) {
            /*
                r10 = this;
                r10.<init>(r11, r12)
                r0 = -1
                r10.f1891a = r0
                r10.f1893b = r0
                r1 = -1082130432(0xffffffffbf800000, float:-1.0)
                r10.f1895c = r1
                r2 = 1
                r10.f1897d = r2
                r10.f1899e = r0
                r10.f1901f = r0
                r10.f1903g = r0
                r10.f1905h = r0
                r10.f1907i = r0
                r10.f1909j = r0
                r10.f1911k = r0
                r10.f1913l = r0
                r10.f1915m = r0
                r10.f1917n = r0
                r10.f1919o = r0
                r10.f1921p = r0
                r3 = 0
                r10.f1923q = r3
                r4 = 0
                r10.f1925r = r4
                r10.f1927s = r0
                r10.f1928t = r0
                r10.f1929u = r0
                r10.f1930v = r0
                r5 = -2147483648(0xffffffff80000000, float:-0.0)
                r10.f1931w = r5
                r10.f1932x = r5
                r10.f1933y = r5
                r10.f1934z = r5
                r10.A = r5
                r10.B = r5
                r10.C = r5
                r10.D = r3
                r6 = 1056964608(0x3f000000, float:0.5)
                r10.E = r6
                r10.F = r6
                r7 = 0
                r10.G = r7
                r10.H = r1
                r10.I = r1
                r10.J = r3
                r10.K = r3
                r10.L = r3
                r10.M = r3
                r10.N = r3
                r10.O = r3
                r10.P = r3
                r10.Q = r3
                r1 = 1065353216(0x3f800000, float:1.0)
                r10.R = r1
                r10.S = r1
                r10.T = r0
                r10.U = r0
                r10.V = r0
                r10.W = r3
                r10.X = r3
                r10.Y = r7
                r10.Z = r3
                r10.f1892a0 = r2
                r10.f1894b0 = r2
                r10.f1896c0 = r3
                r10.f1898d0 = r3
                r10.f1900e0 = r3
                r10.f1902f0 = r3
                r10.f1904g0 = r3
                r10.f1906h0 = r0
                r10.f1908i0 = r0
                r10.f1910j0 = r0
                r10.f1912k0 = r0
                r10.f1914l0 = r5
                r10.f1916m0 = r5
                r10.f1918n0 = r6
                h0.e r1 = new h0.e
                r1.<init>()
                r10.f1926r0 = r1
                int[] r1 = androidx.constraintlayout.widget.f.ConstraintLayout_Layout
                android.content.res.TypedArray r11 = r11.obtainStyledAttributes(r12, r1)
                int r12 = r11.getIndexCount()
                r1 = r3
            L_0x00a6:
                if (r1 >= r12) goto L_0x0394
                int r5 = r11.getIndex(r1)
                android.util.SparseIntArray r6 = androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.a.f1935a
                int r6 = r6.get(r5)
                java.lang.String r7 = "ConstraintLayout"
                r8 = 2
                r9 = -2
                switch(r6) {
                    case 1: goto L_0x0388;
                    case 2: goto L_0x0377;
                    case 3: goto L_0x036e;
                    case 4: goto L_0x0359;
                    case 5: goto L_0x0350;
                    case 6: goto L_0x0347;
                    case 7: goto L_0x033e;
                    case 8: goto L_0x032d;
                    case 9: goto L_0x031c;
                    case 10: goto L_0x030a;
                    case 11: goto L_0x02f8;
                    case 12: goto L_0x02e6;
                    case 13: goto L_0x02d4;
                    case 14: goto L_0x02c2;
                    case 15: goto L_0x02b0;
                    case 16: goto L_0x029e;
                    case 17: goto L_0x028c;
                    case 18: goto L_0x027a;
                    case 19: goto L_0x0268;
                    case 20: goto L_0x0256;
                    case 21: goto L_0x024c;
                    case 22: goto L_0x0242;
                    case 23: goto L_0x0238;
                    case 24: goto L_0x022e;
                    case 25: goto L_0x0224;
                    case 26: goto L_0x021a;
                    case 27: goto L_0x0210;
                    case 28: goto L_0x0206;
                    case 29: goto L_0x01fc;
                    case 30: goto L_0x01f2;
                    case 31: goto L_0x01e3;
                    case 32: goto L_0x01d8;
                    case 33: goto L_0x01c2;
                    case 34: goto L_0x01ac;
                    case 35: goto L_0x019c;
                    case 36: goto L_0x0186;
                    case 37: goto L_0x0170;
                    case 38: goto L_0x0160;
                    default: goto L_0x00b9;
                }
            L_0x00b9:
                switch(r6) {
                    case 44: goto L_0x0157;
                    case 45: goto L_0x014d;
                    case 46: goto L_0x0143;
                    case 47: goto L_0x013b;
                    case 48: goto L_0x0133;
                    case 49: goto L_0x0129;
                    case 50: goto L_0x011f;
                    case 51: goto L_0x0117;
                    case 52: goto L_0x0105;
                    case 53: goto L_0x00f3;
                    case 54: goto L_0x00e9;
                    case 55: goto L_0x00df;
                    default: goto L_0x00bc;
                }
            L_0x00bc:
                switch(r6) {
                    case 64: goto L_0x00da;
                    case 65: goto L_0x00d5;
                    case 66: goto L_0x00cb;
                    case 67: goto L_0x00c1;
                    default: goto L_0x00bf;
                }
            L_0x00bf:
                goto L_0x0390
            L_0x00c1:
                boolean r6 = r10.f1897d
                boolean r5 = r11.getBoolean(r5, r6)
                r10.f1897d = r5
                goto L_0x0390
            L_0x00cb:
                int r6 = r10.Z
                int r5 = r11.getInt(r5, r6)
                r10.Z = r5
                goto L_0x0390
            L_0x00d5:
                androidx.constraintlayout.widget.c.G(r10, r11, r5, r2)
                goto L_0x0390
            L_0x00da:
                androidx.constraintlayout.widget.c.G(r10, r11, r5, r3)
                goto L_0x0390
            L_0x00df:
                int r6 = r10.C
                int r5 = r11.getDimensionPixelSize(r5, r6)
                r10.C = r5
                goto L_0x0390
            L_0x00e9:
                int r6 = r10.D
                int r5 = r11.getDimensionPixelSize(r5, r6)
                r10.D = r5
                goto L_0x0390
            L_0x00f3:
                int r6 = r10.f1919o
                int r6 = r11.getResourceId(r5, r6)
                r10.f1919o = r6
                if (r6 != r0) goto L_0x0390
                int r5 = r11.getInt(r5, r0)
                r10.f1919o = r5
                goto L_0x0390
            L_0x0105:
                int r6 = r10.f1917n
                int r6 = r11.getResourceId(r5, r6)
                r10.f1917n = r6
                if (r6 != r0) goto L_0x0390
                int r5 = r11.getInt(r5, r0)
                r10.f1917n = r5
                goto L_0x0390
            L_0x0117:
                java.lang.String r5 = r11.getString(r5)
                r10.Y = r5
                goto L_0x0390
            L_0x011f:
                int r6 = r10.U
                int r5 = r11.getDimensionPixelOffset(r5, r6)
                r10.U = r5
                goto L_0x0390
            L_0x0129:
                int r6 = r10.T
                int r5 = r11.getDimensionPixelOffset(r5, r6)
                r10.T = r5
                goto L_0x0390
            L_0x0133:
                int r5 = r11.getInt(r5, r3)
                r10.K = r5
                goto L_0x0390
            L_0x013b:
                int r5 = r11.getInt(r5, r3)
                r10.J = r5
                goto L_0x0390
            L_0x0143:
                float r6 = r10.I
                float r5 = r11.getFloat(r5, r6)
                r10.I = r5
                goto L_0x0390
            L_0x014d:
                float r6 = r10.H
                float r5 = r11.getFloat(r5, r6)
                r10.H = r5
                goto L_0x0390
            L_0x0157:
                java.lang.String r5 = r11.getString(r5)
                androidx.constraintlayout.widget.c.I(r10, r5)
                goto L_0x0390
            L_0x0160:
                float r6 = r10.S
                float r5 = r11.getFloat(r5, r6)
                float r5 = java.lang.Math.max(r4, r5)
                r10.S = r5
                r10.M = r8
                goto L_0x0390
            L_0x0170:
                int r6 = r10.Q     // Catch:{ Exception -> 0x017a }
                int r6 = r11.getDimensionPixelSize(r5, r6)     // Catch:{ Exception -> 0x017a }
                r10.Q = r6     // Catch:{ Exception -> 0x017a }
                goto L_0x0390
            L_0x017a:
                int r6 = r10.Q
                int r5 = r11.getInt(r5, r6)
                if (r5 != r9) goto L_0x0390
                r10.Q = r9
                goto L_0x0390
            L_0x0186:
                int r6 = r10.O     // Catch:{ Exception -> 0x0190 }
                int r6 = r11.getDimensionPixelSize(r5, r6)     // Catch:{ Exception -> 0x0190 }
                r10.O = r6     // Catch:{ Exception -> 0x0190 }
                goto L_0x0390
            L_0x0190:
                int r6 = r10.O
                int r5 = r11.getInt(r5, r6)
                if (r5 != r9) goto L_0x0390
                r10.O = r9
                goto L_0x0390
            L_0x019c:
                float r6 = r10.R
                float r5 = r11.getFloat(r5, r6)
                float r5 = java.lang.Math.max(r4, r5)
                r10.R = r5
                r10.L = r8
                goto L_0x0390
            L_0x01ac:
                int r6 = r10.P     // Catch:{ Exception -> 0x01b6 }
                int r6 = r11.getDimensionPixelSize(r5, r6)     // Catch:{ Exception -> 0x01b6 }
                r10.P = r6     // Catch:{ Exception -> 0x01b6 }
                goto L_0x0390
            L_0x01b6:
                int r6 = r10.P
                int r5 = r11.getInt(r5, r6)
                if (r5 != r9) goto L_0x0390
                r10.P = r9
                goto L_0x0390
            L_0x01c2:
                int r6 = r10.N     // Catch:{ Exception -> 0x01cc }
                int r6 = r11.getDimensionPixelSize(r5, r6)     // Catch:{ Exception -> 0x01cc }
                r10.N = r6     // Catch:{ Exception -> 0x01cc }
                goto L_0x0390
            L_0x01cc:
                int r6 = r10.N
                int r5 = r11.getInt(r5, r6)
                if (r5 != r9) goto L_0x0390
                r10.N = r9
                goto L_0x0390
            L_0x01d8:
                int r5 = r11.getInt(r5, r3)
                r10.M = r5
                if (r5 != r2) goto L_0x0390
                java.lang.String r5 = "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead."
                goto L_0x01ed
            L_0x01e3:
                int r5 = r11.getInt(r5, r3)
                r10.L = r5
                if (r5 != r2) goto L_0x0390
                java.lang.String r5 = "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead."
            L_0x01ed:
                android.util.Log.e(r7, r5)
                goto L_0x0390
            L_0x01f2:
                float r6 = r10.F
                float r5 = r11.getFloat(r5, r6)
                r10.F = r5
                goto L_0x0390
            L_0x01fc:
                float r6 = r10.E
                float r5 = r11.getFloat(r5, r6)
                r10.E = r5
                goto L_0x0390
            L_0x0206:
                boolean r6 = r10.X
                boolean r5 = r11.getBoolean(r5, r6)
                r10.X = r5
                goto L_0x0390
            L_0x0210:
                boolean r6 = r10.W
                boolean r5 = r11.getBoolean(r5, r6)
                r10.W = r5
                goto L_0x0390
            L_0x021a:
                int r6 = r10.B
                int r5 = r11.getDimensionPixelSize(r5, r6)
                r10.B = r5
                goto L_0x0390
            L_0x0224:
                int r6 = r10.A
                int r5 = r11.getDimensionPixelSize(r5, r6)
                r10.A = r5
                goto L_0x0390
            L_0x022e:
                int r6 = r10.f1934z
                int r5 = r11.getDimensionPixelSize(r5, r6)
                r10.f1934z = r5
                goto L_0x0390
            L_0x0238:
                int r6 = r10.f1933y
                int r5 = r11.getDimensionPixelSize(r5, r6)
                r10.f1933y = r5
                goto L_0x0390
            L_0x0242:
                int r6 = r10.f1932x
                int r5 = r11.getDimensionPixelSize(r5, r6)
                r10.f1932x = r5
                goto L_0x0390
            L_0x024c:
                int r6 = r10.f1931w
                int r5 = r11.getDimensionPixelSize(r5, r6)
                r10.f1931w = r5
                goto L_0x0390
            L_0x0256:
                int r6 = r10.f1930v
                int r6 = r11.getResourceId(r5, r6)
                r10.f1930v = r6
                if (r6 != r0) goto L_0x0390
                int r5 = r11.getInt(r5, r0)
                r10.f1930v = r5
                goto L_0x0390
            L_0x0268:
                int r6 = r10.f1929u
                int r6 = r11.getResourceId(r5, r6)
                r10.f1929u = r6
                if (r6 != r0) goto L_0x0390
                int r5 = r11.getInt(r5, r0)
                r10.f1929u = r5
                goto L_0x0390
            L_0x027a:
                int r6 = r10.f1928t
                int r6 = r11.getResourceId(r5, r6)
                r10.f1928t = r6
                if (r6 != r0) goto L_0x0390
                int r5 = r11.getInt(r5, r0)
                r10.f1928t = r5
                goto L_0x0390
            L_0x028c:
                int r6 = r10.f1927s
                int r6 = r11.getResourceId(r5, r6)
                r10.f1927s = r6
                if (r6 != r0) goto L_0x0390
                int r5 = r11.getInt(r5, r0)
                r10.f1927s = r5
                goto L_0x0390
            L_0x029e:
                int r6 = r10.f1915m
                int r6 = r11.getResourceId(r5, r6)
                r10.f1915m = r6
                if (r6 != r0) goto L_0x0390
                int r5 = r11.getInt(r5, r0)
                r10.f1915m = r5
                goto L_0x0390
            L_0x02b0:
                int r6 = r10.f1913l
                int r6 = r11.getResourceId(r5, r6)
                r10.f1913l = r6
                if (r6 != r0) goto L_0x0390
                int r5 = r11.getInt(r5, r0)
                r10.f1913l = r5
                goto L_0x0390
            L_0x02c2:
                int r6 = r10.f1911k
                int r6 = r11.getResourceId(r5, r6)
                r10.f1911k = r6
                if (r6 != r0) goto L_0x0390
                int r5 = r11.getInt(r5, r0)
                r10.f1911k = r5
                goto L_0x0390
            L_0x02d4:
                int r6 = r10.f1909j
                int r6 = r11.getResourceId(r5, r6)
                r10.f1909j = r6
                if (r6 != r0) goto L_0x0390
                int r5 = r11.getInt(r5, r0)
                r10.f1909j = r5
                goto L_0x0390
            L_0x02e6:
                int r6 = r10.f1907i
                int r6 = r11.getResourceId(r5, r6)
                r10.f1907i = r6
                if (r6 != r0) goto L_0x0390
                int r5 = r11.getInt(r5, r0)
                r10.f1907i = r5
                goto L_0x0390
            L_0x02f8:
                int r6 = r10.f1905h
                int r6 = r11.getResourceId(r5, r6)
                r10.f1905h = r6
                if (r6 != r0) goto L_0x0390
                int r5 = r11.getInt(r5, r0)
                r10.f1905h = r5
                goto L_0x0390
            L_0x030a:
                int r6 = r10.f1903g
                int r6 = r11.getResourceId(r5, r6)
                r10.f1903g = r6
                if (r6 != r0) goto L_0x0390
                int r5 = r11.getInt(r5, r0)
                r10.f1903g = r5
                goto L_0x0390
            L_0x031c:
                int r6 = r10.f1901f
                int r6 = r11.getResourceId(r5, r6)
                r10.f1901f = r6
                if (r6 != r0) goto L_0x0390
                int r5 = r11.getInt(r5, r0)
                r10.f1901f = r5
                goto L_0x0390
            L_0x032d:
                int r6 = r10.f1899e
                int r6 = r11.getResourceId(r5, r6)
                r10.f1899e = r6
                if (r6 != r0) goto L_0x0390
                int r5 = r11.getInt(r5, r0)
                r10.f1899e = r5
                goto L_0x0390
            L_0x033e:
                float r6 = r10.f1895c
                float r5 = r11.getFloat(r5, r6)
                r10.f1895c = r5
                goto L_0x0390
            L_0x0347:
                int r6 = r10.f1893b
                int r5 = r11.getDimensionPixelOffset(r5, r6)
                r10.f1893b = r5
                goto L_0x0390
            L_0x0350:
                int r6 = r10.f1891a
                int r5 = r11.getDimensionPixelOffset(r5, r6)
                r10.f1891a = r5
                goto L_0x0390
            L_0x0359:
                float r6 = r10.f1925r
                float r5 = r11.getFloat(r5, r6)
                r6 = 1135869952(0x43b40000, float:360.0)
                float r5 = r5 % r6
                r10.f1925r = r5
                int r7 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
                if (r7 >= 0) goto L_0x0390
                float r5 = r6 - r5
                float r5 = r5 % r6
                r10.f1925r = r5
                goto L_0x0390
            L_0x036e:
                int r6 = r10.f1923q
                int r5 = r11.getDimensionPixelSize(r5, r6)
                r10.f1923q = r5
                goto L_0x0390
            L_0x0377:
                int r6 = r10.f1921p
                int r6 = r11.getResourceId(r5, r6)
                r10.f1921p = r6
                if (r6 != r0) goto L_0x0390
                int r5 = r11.getInt(r5, r0)
                r10.f1921p = r5
                goto L_0x0390
            L_0x0388:
                int r6 = r10.V
                int r5 = r11.getInt(r5, r6)
                r10.V = r5
            L_0x0390:
                int r1 = r1 + 1
                goto L_0x00a6
            L_0x0394:
                r11.recycle()
                r10.c()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.<init>(android.content.Context, android.util.AttributeSet):void");
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public String a() {
            return this.Y;
        }

        public e b() {
            return this.f1926r0;
        }

        public void c() {
            this.f1898d0 = false;
            this.f1892a0 = true;
            this.f1894b0 = true;
            int i10 = this.width;
            if (i10 == -2 && this.W) {
                this.f1892a0 = false;
                if (this.L == 0) {
                    this.L = 1;
                }
            }
            int i11 = this.height;
            if (i11 == -2 && this.X) {
                this.f1894b0 = false;
                if (this.M == 0) {
                    this.M = 1;
                }
            }
            if (i10 == 0 || i10 == -1) {
                this.f1892a0 = false;
                if (i10 == 0 && this.L == 1) {
                    this.width = -2;
                    this.W = true;
                }
            }
            if (i11 == 0 || i11 == -1) {
                this.f1894b0 = false;
                if (i11 == 0 && this.M == 1) {
                    this.height = -2;
                    this.X = true;
                }
            }
            if (this.f1895c != -1.0f || this.f1891a != -1 || this.f1893b != -1) {
                this.f1898d0 = true;
                this.f1892a0 = true;
                this.f1894b0 = true;
                if (!(this.f1926r0 instanceof h)) {
                    this.f1926r0 = new h();
                }
                ((h) this.f1926r0).E1(this.V);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:74:0x00da, code lost:
            if (r1 > 0) goto L_0x00dc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x00e9, code lost:
            if (r1 > 0) goto L_0x00dc;
         */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0054  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x005b  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0062  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0068  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x006e  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x0084  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x008c  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x009c  */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x00d0  */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x00f0  */
        /* JADX WARNING: Removed duplicated region for block: B:87:0x00fb  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0041  */
        /* JADX WARNING: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
        @android.annotation.TargetApi(17)
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void resolveLayoutDirection(int r11) {
            /*
                r10 = this;
                int r0 = r10.leftMargin
                int r1 = r10.rightMargin
                int r2 = android.os.Build.VERSION.SDK_INT
                r3 = 0
                r4 = 1
                r5 = 17
                if (r2 < r5) goto L_0x0017
                super.resolveLayoutDirection(r11)
                int r11 = r10.getLayoutDirection()
                if (r4 != r11) goto L_0x0017
                r11 = r4
                goto L_0x0018
            L_0x0017:
                r11 = r3
            L_0x0018:
                r2 = -1
                r10.f1910j0 = r2
                r10.f1912k0 = r2
                r10.f1906h0 = r2
                r10.f1908i0 = r2
                r10.f1914l0 = r2
                r10.f1916m0 = r2
                int r5 = r10.f1931w
                r10.f1914l0 = r5
                int r5 = r10.f1933y
                r10.f1916m0 = r5
                float r5 = r10.E
                r10.f1918n0 = r5
                int r6 = r10.f1891a
                r10.f1920o0 = r6
                int r7 = r10.f1893b
                r10.f1922p0 = r7
                float r8 = r10.f1895c
                r10.f1924q0 = r8
                r9 = -2147483648(0xffffffff80000000, float:-0.0)
                if (r11 == 0) goto L_0x009c
                int r11 = r10.f1927s
                if (r11 == r2) goto L_0x0049
                r10.f1910j0 = r11
            L_0x0047:
                r3 = r4
                goto L_0x0050
            L_0x0049:
                int r11 = r10.f1928t
                if (r11 == r2) goto L_0x0050
                r10.f1912k0 = r11
                goto L_0x0047
            L_0x0050:
                int r11 = r10.f1929u
                if (r11 == r2) goto L_0x0057
                r10.f1908i0 = r11
                r3 = r4
            L_0x0057:
                int r11 = r10.f1930v
                if (r11 == r2) goto L_0x005e
                r10.f1906h0 = r11
                r3 = r4
            L_0x005e:
                int r11 = r10.A
                if (r11 == r9) goto L_0x0064
                r10.f1916m0 = r11
            L_0x0064:
                int r11 = r10.B
                if (r11 == r9) goto L_0x006a
                r10.f1914l0 = r11
            L_0x006a:
                r11 = 1065353216(0x3f800000, float:1.0)
                if (r3 == 0) goto L_0x0072
                float r3 = r11 - r5
                r10.f1918n0 = r3
            L_0x0072:
                boolean r3 = r10.f1898d0
                if (r3 == 0) goto L_0x00c0
                int r3 = r10.V
                if (r3 != r4) goto L_0x00c0
                boolean r3 = r10.f1897d
                if (r3 == 0) goto L_0x00c0
                r3 = -1082130432(0xffffffffbf800000, float:-1.0)
                int r4 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
                if (r4 == 0) goto L_0x008c
                float r11 = r11 - r8
                r10.f1924q0 = r11
                r10.f1920o0 = r2
                r10.f1922p0 = r2
                goto L_0x00c0
            L_0x008c:
                if (r6 == r2) goto L_0x0095
                r10.f1922p0 = r6
                r10.f1920o0 = r2
            L_0x0092:
                r10.f1924q0 = r3
                goto L_0x00c0
            L_0x0095:
                if (r7 == r2) goto L_0x00c0
                r10.f1920o0 = r7
                r10.f1922p0 = r2
                goto L_0x0092
            L_0x009c:
                int r11 = r10.f1927s
                if (r11 == r2) goto L_0x00a2
                r10.f1908i0 = r11
            L_0x00a2:
                int r11 = r10.f1928t
                if (r11 == r2) goto L_0x00a8
                r10.f1906h0 = r11
            L_0x00a8:
                int r11 = r10.f1929u
                if (r11 == r2) goto L_0x00ae
                r10.f1910j0 = r11
            L_0x00ae:
                int r11 = r10.f1930v
                if (r11 == r2) goto L_0x00b4
                r10.f1912k0 = r11
            L_0x00b4:
                int r11 = r10.A
                if (r11 == r9) goto L_0x00ba
                r10.f1914l0 = r11
            L_0x00ba:
                int r11 = r10.B
                if (r11 == r9) goto L_0x00c0
                r10.f1916m0 = r11
            L_0x00c0:
                int r11 = r10.f1929u
                if (r11 != r2) goto L_0x0108
                int r11 = r10.f1930v
                if (r11 != r2) goto L_0x0108
                int r11 = r10.f1928t
                if (r11 != r2) goto L_0x0108
                int r11 = r10.f1927s
                if (r11 != r2) goto L_0x0108
                int r11 = r10.f1903g
                if (r11 == r2) goto L_0x00df
                r10.f1910j0 = r11
                int r11 = r10.rightMargin
                if (r11 > 0) goto L_0x00ec
                if (r1 <= 0) goto L_0x00ec
            L_0x00dc:
                r10.rightMargin = r1
                goto L_0x00ec
            L_0x00df:
                int r11 = r10.f1905h
                if (r11 == r2) goto L_0x00ec
                r10.f1912k0 = r11
                int r11 = r10.rightMargin
                if (r11 > 0) goto L_0x00ec
                if (r1 <= 0) goto L_0x00ec
                goto L_0x00dc
            L_0x00ec:
                int r11 = r10.f1899e
                if (r11 == r2) goto L_0x00fb
                r10.f1906h0 = r11
                int r11 = r10.leftMargin
                if (r11 > 0) goto L_0x0108
                if (r0 <= 0) goto L_0x0108
            L_0x00f8:
                r10.leftMargin = r0
                goto L_0x0108
            L_0x00fb:
                int r11 = r10.f1901f
                if (r11 == r2) goto L_0x0108
                r10.f1908i0 = r11
                int r11 = r10.leftMargin
                if (r11 > 0) goto L_0x0108
                if (r0 <= 0) goto L_0x0108
                goto L_0x00f8
            L_0x0108:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.resolveLayoutDirection(int):void");
        }
    }

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1936a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                h0.e$b[] r0 = h0.e.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1936a = r0
                h0.e$b r1 = h0.e.b.FIXED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f1936a     // Catch:{ NoSuchFieldError -> 0x001d }
                h0.e$b r1 = h0.e.b.WRAP_CONTENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f1936a     // Catch:{ NoSuchFieldError -> 0x0028 }
                h0.e$b r1 = h0.e.b.MATCH_PARENT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f1936a     // Catch:{ NoSuchFieldError -> 0x0033 }
                h0.e$b r1 = h0.e.b.MATCH_CONSTRAINT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.a.<clinit>():void");
        }
    }

    class b implements b.C0168b {

        /* renamed from: a  reason: collision with root package name */
        ConstraintLayout f1937a;

        /* renamed from: b  reason: collision with root package name */
        int f1938b;

        /* renamed from: c  reason: collision with root package name */
        int f1939c;

        /* renamed from: d  reason: collision with root package name */
        int f1940d;

        /* renamed from: e  reason: collision with root package name */
        int f1941e;

        /* renamed from: f  reason: collision with root package name */
        int f1942f;

        /* renamed from: g  reason: collision with root package name */
        int f1943g;

        public b(ConstraintLayout constraintLayout) {
            this.f1937a = constraintLayout;
        }

        private boolean d(int i10, int i11, int i12) {
            if (i10 == i11) {
                return true;
            }
            int mode = View.MeasureSpec.getMode(i10);
            View.MeasureSpec.getSize(i10);
            int mode2 = View.MeasureSpec.getMode(i11);
            int size = View.MeasureSpec.getSize(i11);
            if (mode2 == 1073741824) {
                return (mode == Integer.MIN_VALUE || mode == 0) && i12 == size;
            }
            return false;
        }

        /* JADX WARNING: Removed duplicated region for block: B:104:0x0187  */
        /* JADX WARNING: Removed duplicated region for block: B:105:0x0189  */
        /* JADX WARNING: Removed duplicated region for block: B:107:0x018c  */
        /* JADX WARNING: Removed duplicated region for block: B:111:0x01a3  */
        /* JADX WARNING: Removed duplicated region for block: B:112:0x01a5  */
        /* JADX WARNING: Removed duplicated region for block: B:114:0x01a8  */
        /* JADX WARNING: Removed duplicated region for block: B:115:0x01aa  */
        /* JADX WARNING: Removed duplicated region for block: B:120:0x01b4  */
        /* JADX WARNING: Removed duplicated region for block: B:121:0x01b6  */
        /* JADX WARNING: Removed duplicated region for block: B:125:0x01be  */
        /* JADX WARNING: Removed duplicated region for block: B:126:0x01c0  */
        /* JADX WARNING: Removed duplicated region for block: B:131:0x01ca  */
        /* JADX WARNING: Removed duplicated region for block: B:132:0x01cc  */
        /* JADX WARNING: Removed duplicated region for block: B:136:0x01d5  */
        /* JADX WARNING: Removed duplicated region for block: B:137:0x01d7  */
        /* JADX WARNING: Removed duplicated region for block: B:139:0x01da A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:140:0x01db  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x00b6  */
        @android.annotation.SuppressLint({"WrongCall"})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(h0.e r18, i0.b.a r19) {
            /*
                r17 = this;
                r0 = r17
                r1 = r18
                r2 = r19
                if (r1 != 0) goto L_0x0009
                return
            L_0x0009:
                int r3 = r18.X()
                r4 = 8
                r5 = 0
                if (r3 != r4) goto L_0x001f
                boolean r3 = r18.l0()
                if (r3 != 0) goto L_0x001f
                r2.f14618e = r5
                r2.f14619f = r5
                r2.f14620g = r5
                return
            L_0x001f:
                h0.e r3 = r18.M()
                if (r3 != 0) goto L_0x0026
                return
            L_0x0026:
                h0.e$b r3 = r2.f14614a
                h0.e$b r4 = r2.f14615b
                int r6 = r2.f14616c
                int r7 = r2.f14617d
                int r8 = r0.f1938b
                int r9 = r0.f1939c
                int r8 = r8 + r9
                int r9 = r0.f1940d
                java.lang.Object r10 = r18.u()
                android.view.View r10 = (android.view.View) r10
                int[] r11 = androidx.constraintlayout.widget.ConstraintLayout.a.f1936a
                int r12 = r3.ordinal()
                r12 = r11[r12]
                r13 = 4
                r14 = 3
                r15 = 2
                r5 = 1
                if (r12 == r5) goto L_0x00a8
                if (r12 == r15) goto L_0x00a0
                if (r12 == r14) goto L_0x0097
                if (r12 == r13) goto L_0x0051
                r6 = 0
                goto L_0x00ae
            L_0x0051:
                int r6 = r0.f1942f
                r12 = -2
                int r6 = android.view.ViewGroup.getChildMeasureSpec(r6, r9, r12)
                int r9 = r1.f14392t
                if (r9 != r5) goto L_0x005e
                r9 = r5
                goto L_0x005f
            L_0x005e:
                r9 = 0
            L_0x005f:
                int r12 = r2.f14623j
                int r13 = i0.b.a.f14612l
                if (r12 == r13) goto L_0x0069
                int r13 = i0.b.a.f14613m
                if (r12 != r13) goto L_0x00ae
            L_0x0069:
                int r12 = r10.getMeasuredHeight()
                int r13 = r18.z()
                if (r12 != r13) goto L_0x0075
                r12 = r5
                goto L_0x0076
            L_0x0075:
                r12 = 0
            L_0x0076:
                int r13 = r2.f14623j
                int r14 = i0.b.a.f14613m
                if (r13 == r14) goto L_0x008f
                if (r9 == 0) goto L_0x008f
                if (r9 == 0) goto L_0x0082
                if (r12 != 0) goto L_0x008f
            L_0x0082:
                boolean r9 = r10 instanceof androidx.constraintlayout.widget.Placeholder
                if (r9 != 0) goto L_0x008f
                boolean r9 = r18.p0()
                if (r9 == 0) goto L_0x008d
                goto L_0x008f
            L_0x008d:
                r9 = 0
                goto L_0x0090
            L_0x008f:
                r9 = r5
            L_0x0090:
                if (r9 == 0) goto L_0x00ae
                int r6 = r18.Y()
                goto L_0x00a8
            L_0x0097:
                int r6 = r0.f1942f
                int r12 = r18.D()
                int r9 = r9 + r12
                r12 = -1
                goto L_0x00a3
            L_0x00a0:
                int r6 = r0.f1942f
                r12 = -2
            L_0x00a3:
                int r6 = android.view.ViewGroup.getChildMeasureSpec(r6, r9, r12)
                goto L_0x00ae
            L_0x00a8:
                r9 = 1073741824(0x40000000, float:2.0)
                int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r9)
            L_0x00ae:
                int r9 = r4.ordinal()
                r9 = r11[r9]
                if (r9 == r5) goto L_0x0117
                if (r9 == r15) goto L_0x010f
                r7 = 3
                if (r9 == r7) goto L_0x0106
                r7 = 4
                if (r9 == r7) goto L_0x00c0
                r7 = 0
                goto L_0x011d
            L_0x00c0:
                int r7 = r0.f1943g
                r9 = -2
                int r7 = android.view.ViewGroup.getChildMeasureSpec(r7, r8, r9)
                int r8 = r1.f14394u
                if (r8 != r5) goto L_0x00cd
                r8 = r5
                goto L_0x00ce
            L_0x00cd:
                r8 = 0
            L_0x00ce:
                int r9 = r2.f14623j
                int r11 = i0.b.a.f14612l
                if (r9 == r11) goto L_0x00d8
                int r11 = i0.b.a.f14613m
                if (r9 != r11) goto L_0x011d
            L_0x00d8:
                int r9 = r10.getMeasuredWidth()
                int r11 = r18.Y()
                if (r9 != r11) goto L_0x00e4
                r9 = r5
                goto L_0x00e5
            L_0x00e4:
                r9 = 0
            L_0x00e5:
                int r11 = r2.f14623j
                int r12 = i0.b.a.f14613m
                if (r11 == r12) goto L_0x00fe
                if (r8 == 0) goto L_0x00fe
                if (r8 == 0) goto L_0x00f1
                if (r9 != 0) goto L_0x00fe
            L_0x00f1:
                boolean r8 = r10 instanceof androidx.constraintlayout.widget.Placeholder
                if (r8 != 0) goto L_0x00fe
                boolean r8 = r18.q0()
                if (r8 == 0) goto L_0x00fc
                goto L_0x00fe
            L_0x00fc:
                r8 = 0
                goto L_0x00ff
            L_0x00fe:
                r8 = r5
            L_0x00ff:
                if (r8 == 0) goto L_0x011d
                int r7 = r18.z()
                goto L_0x0117
            L_0x0106:
                int r7 = r0.f1943g
                int r9 = r18.W()
                int r8 = r8 + r9
                r9 = -1
                goto L_0x0112
            L_0x010f:
                int r7 = r0.f1943g
                r9 = -2
            L_0x0112:
                int r7 = android.view.ViewGroup.getChildMeasureSpec(r7, r8, r9)
                goto L_0x011d
            L_0x0117:
                r8 = 1073741824(0x40000000, float:2.0)
                int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r8)
            L_0x011d:
                h0.e r8 = r18.M()
                h0.f r8 = (h0.f) r8
                if (r8 == 0) goto L_0x019f
                androidx.constraintlayout.widget.ConstraintLayout r9 = androidx.constraintlayout.widget.ConstraintLayout.this
                int r9 = r9.f1880i
                r11 = 256(0x100, float:3.59E-43)
                boolean r9 = h0.k.b(r9, r11)
                if (r9 == 0) goto L_0x019f
                int r9 = r10.getMeasuredWidth()
                int r11 = r18.Y()
                if (r9 != r11) goto L_0x019f
                int r9 = r10.getMeasuredWidth()
                int r11 = r8.Y()
                if (r9 >= r11) goto L_0x019f
                int r9 = r10.getMeasuredHeight()
                int r11 = r18.z()
                if (r9 != r11) goto L_0x019f
                int r9 = r10.getMeasuredHeight()
                int r8 = r8.z()
                if (r9 >= r8) goto L_0x019f
                int r8 = r10.getBaseline()
                int r9 = r18.r()
                if (r8 != r9) goto L_0x019f
                boolean r8 = r18.o0()
                if (r8 != 0) goto L_0x019f
                int r8 = r18.E()
                int r9 = r18.Y()
                boolean r8 = r0.d(r8, r6, r9)
                if (r8 == 0) goto L_0x0189
                int r8 = r18.F()
                int r9 = r18.z()
                boolean r8 = r0.d(r8, r7, r9)
                if (r8 == 0) goto L_0x0189
                r8 = r5
                goto L_0x018a
            L_0x0189:
                r8 = 0
            L_0x018a:
                if (r8 == 0) goto L_0x019f
                int r3 = r18.Y()
                r2.f14618e = r3
                int r3 = r18.z()
                r2.f14619f = r3
                int r1 = r18.r()
                r2.f14620g = r1
                return
            L_0x019f:
                h0.e$b r8 = h0.e.b.MATCH_CONSTRAINT
                if (r3 != r8) goto L_0x01a5
                r9 = r5
                goto L_0x01a6
            L_0x01a5:
                r9 = 0
            L_0x01a6:
                if (r4 != r8) goto L_0x01aa
                r8 = r5
                goto L_0x01ab
            L_0x01aa:
                r8 = 0
            L_0x01ab:
                h0.e$b r11 = h0.e.b.MATCH_PARENT
                if (r4 == r11) goto L_0x01b6
                h0.e$b r12 = h0.e.b.FIXED
                if (r4 != r12) goto L_0x01b4
                goto L_0x01b6
            L_0x01b4:
                r4 = 0
                goto L_0x01b7
            L_0x01b6:
                r4 = r5
            L_0x01b7:
                if (r3 == r11) goto L_0x01c0
                h0.e$b r11 = h0.e.b.FIXED
                if (r3 != r11) goto L_0x01be
                goto L_0x01c0
            L_0x01be:
                r3 = 0
                goto L_0x01c1
            L_0x01c0:
                r3 = r5
            L_0x01c1:
                r11 = 0
                if (r9 == 0) goto L_0x01cc
                float r12 = r1.f14359c0
                int r12 = (r12 > r11 ? 1 : (r12 == r11 ? 0 : -1))
                if (r12 <= 0) goto L_0x01cc
                r12 = r5
                goto L_0x01cd
            L_0x01cc:
                r12 = 0
            L_0x01cd:
                if (r8 == 0) goto L_0x01d7
                float r13 = r1.f14359c0
                int r11 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
                if (r11 <= 0) goto L_0x01d7
                r11 = r5
                goto L_0x01d8
            L_0x01d7:
                r11 = 0
            L_0x01d8:
                if (r10 != 0) goto L_0x01db
                return
            L_0x01db:
                android.view.ViewGroup$LayoutParams r13 = r10.getLayoutParams()
                androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r13 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r13
                int r14 = r2.f14623j
                int r15 = i0.b.a.f14612l
                if (r14 == r15) goto L_0x01fe
                int r15 = i0.b.a.f14613m
                if (r14 == r15) goto L_0x01fe
                if (r9 == 0) goto L_0x01fe
                int r9 = r1.f14392t
                if (r9 != 0) goto L_0x01fe
                if (r8 == 0) goto L_0x01fe
                int r8 = r1.f14394u
                if (r8 == 0) goto L_0x01f8
                goto L_0x01fe
            L_0x01f8:
                r0 = -1
                r5 = 0
                r14 = 0
                r15 = 0
                goto L_0x0299
            L_0x01fe:
                boolean r8 = r10 instanceof androidx.constraintlayout.widget.VirtualLayout
                if (r8 == 0) goto L_0x0210
                boolean r8 = r1 instanceof h0.m
                if (r8 == 0) goto L_0x0210
                r8 = r1
                h0.m r8 = (h0.m) r8
                r9 = r10
                androidx.constraintlayout.widget.VirtualLayout r9 = (androidx.constraintlayout.widget.VirtualLayout) r9
                r9.x(r8, r6, r7)
                goto L_0x0213
            L_0x0210:
                r10.measure(r6, r7)
            L_0x0213:
                r1.Z0(r6, r7)
                int r8 = r10.getMeasuredWidth()
                int r9 = r10.getMeasuredHeight()
                int r14 = r10.getBaseline()
                int r15 = r1.f14398w
                if (r15 <= 0) goto L_0x022b
                int r15 = java.lang.Math.max(r15, r8)
                goto L_0x022c
            L_0x022b:
                r15 = r8
            L_0x022c:
                int r5 = r1.f14400x
                if (r5 <= 0) goto L_0x0234
                int r15 = java.lang.Math.min(r5, r15)
            L_0x0234:
                int r5 = r1.f14404z
                if (r5 <= 0) goto L_0x023f
                int r5 = java.lang.Math.max(r5, r9)
                r16 = r6
                goto L_0x0242
            L_0x023f:
                r16 = r6
                r5 = r9
            L_0x0242:
                int r6 = r1.A
                if (r6 <= 0) goto L_0x024a
                int r5 = java.lang.Math.min(r6, r5)
            L_0x024a:
                androidx.constraintlayout.widget.ConstraintLayout r6 = androidx.constraintlayout.widget.ConstraintLayout.this
                int r6 = r6.f1880i
                r0 = 1
                boolean r6 = h0.k.b(r6, r0)
                if (r6 != 0) goto L_0x026e
                r0 = 1056964608(0x3f000000, float:0.5)
                if (r12 == 0) goto L_0x0264
                if (r4 == 0) goto L_0x0264
                float r3 = r1.f14359c0
                float r4 = (float) r5
                float r4 = r4 * r3
                float r4 = r4 + r0
                int r15 = (int) r4
                goto L_0x026e
            L_0x0264:
                if (r11 == 0) goto L_0x026e
                if (r3 == 0) goto L_0x026e
                float r3 = r1.f14359c0
                float r4 = (float) r15
                float r4 = r4 / r3
                float r4 = r4 + r0
                int r5 = (int) r4
            L_0x026e:
                if (r8 != r15) goto L_0x0275
                if (r9 == r5) goto L_0x0273
                goto L_0x0275
            L_0x0273:
                r0 = -1
                goto L_0x0299
            L_0x0275:
                r0 = 1073741824(0x40000000, float:2.0)
                if (r8 == r15) goto L_0x027e
                int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r0)
                goto L_0x0280
            L_0x027e:
                r6 = r16
            L_0x0280:
                if (r9 == r5) goto L_0x0286
                int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r0)
            L_0x0286:
                r10.measure(r6, r7)
                r1.Z0(r6, r7)
                int r15 = r10.getMeasuredWidth()
                int r5 = r10.getMeasuredHeight()
                int r14 = r10.getBaseline()
                goto L_0x0273
            L_0x0299:
                if (r14 == r0) goto L_0x029d
                r0 = 1
                goto L_0x029e
            L_0x029d:
                r0 = 0
            L_0x029e:
                int r3 = r2.f14616c
                if (r15 != r3) goto L_0x02a9
                int r3 = r2.f14617d
                if (r5 == r3) goto L_0x02a7
                goto L_0x02a9
            L_0x02a7:
                r3 = 0
                goto L_0x02aa
            L_0x02a9:
                r3 = 1
            L_0x02aa:
                r2.f14622i = r3
                boolean r3 = r13.f1896c0
                if (r3 == 0) goto L_0x02b1
                r0 = 1
            L_0x02b1:
                if (r0 == 0) goto L_0x02bf
                r3 = -1
                if (r14 == r3) goto L_0x02bf
                int r1 = r18.r()
                if (r1 == r14) goto L_0x02bf
                r1 = 1
                r2.f14622i = r1
            L_0x02bf:
                r2.f14618e = r15
                r2.f14619f = r5
                r2.f14621h = r0
                r2.f14620g = r14
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.b.a(h0.e, i0.b$a):void");
        }

        public final void b() {
            int childCount = this.f1937a.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = this.f1937a.getChildAt(i10);
                if (childAt instanceof Placeholder) {
                    ((Placeholder) childAt).b(this.f1937a);
                }
            }
            int size = this.f1937a.f1873b.size();
            if (size > 0) {
                for (int i11 = 0; i11 < size; i11++) {
                    ((ConstraintHelper) this.f1937a.f1873b.get(i11)).s(this.f1937a);
                }
            }
        }

        public void c(int i10, int i11, int i12, int i13, int i14, int i15) {
            this.f1938b = i12;
            this.f1939c = i13;
            this.f1940d = i14;
            this.f1941e = i15;
            this.f1942f = i10;
            this.f1943g = i11;
        }
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        q(attributeSet, 0, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        q(attributeSet, i10, 0);
    }

    private boolean A() {
        int childCount = getChildCount();
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= childCount) {
                break;
            } else if (getChildAt(i10).isLayoutRequested()) {
                z10 = true;
                break;
            } else {
                i10++;
            }
        }
        if (z10) {
            w();
        }
        return z10;
    }

    private int getPaddingWidth() {
        int i10 = 0;
        int max = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        if (Build.VERSION.SDK_INT >= 17) {
            i10 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        }
        return i10 > 0 ? i10 : max;
    }

    public static g getSharedValues() {
        if (f1871t == null) {
            f1871t = new g();
        }
        return f1871t;
    }

    private final e k(int i10) {
        if (i10 == 0) {
            return this.f1874c;
        }
        View view = this.f1872a.get(i10);
        if (view == null && (view = findViewById(i10)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.f1874c;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).f1926r0;
    }

    private void q(AttributeSet attributeSet, int i10, int i11) {
        this.f1874c.F0(this);
        this.f1874c.Z1(this.f1888q);
        this.f1872a.put(getId(), this);
        this.f1881j = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, f.ConstraintLayout_Layout, i10, i11);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i12 = 0; i12 < indexCount; i12++) {
                int index = obtainStyledAttributes.getIndex(i12);
                if (index == f.ConstraintLayout_Layout_android_minWidth) {
                    this.f1875d = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1875d);
                } else if (index == f.ConstraintLayout_Layout_android_minHeight) {
                    this.f1876e = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1876e);
                } else if (index == f.ConstraintLayout_Layout_android_maxWidth) {
                    this.f1877f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1877f);
                } else if (index == f.ConstraintLayout_Layout_android_maxHeight) {
                    this.f1878g = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1878g);
                } else if (index == f.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.f1880i = obtainStyledAttributes.getInt(index, this.f1880i);
                } else if (index == f.ConstraintLayout_Layout_layoutDescription) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            t(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.f1882k = null;
                        }
                    }
                } else if (index == f.ConstraintLayout_Layout_constraintSet) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        c cVar = new c();
                        this.f1881j = cVar;
                        cVar.D(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.f1881j = null;
                    }
                    this.f1883l = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f1874c.a2(this.f1880i);
    }

    private void s() {
        this.f1879h = true;
        this.f1885n = -1;
        this.f1886o = -1;
    }

    private void w() {
        boolean isInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            e p10 = p(getChildAt(i10));
            if (p10 != null) {
                p10.v0();
            }
        }
        if (isInEditMode) {
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    x(0, resourceName, Integer.valueOf(childAt.getId()));
                    int indexOf = resourceName.indexOf(47);
                    if (indexOf != -1) {
                        resourceName = resourceName.substring(indexOf + 1);
                    }
                    k(childAt.getId()).G0(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.f1883l != -1) {
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2.getId() == this.f1883l && (childAt2 instanceof Constraints)) {
                    this.f1881j = ((Constraints) childAt2).getConstraintSet();
                }
            }
        }
        c cVar = this.f1881j;
        if (cVar != null) {
            cVar.k(this, true);
        }
        this.f1874c.y1();
        int size = this.f1873b.size();
        if (size > 0) {
            for (int i13 = 0; i13 < size; i13++) {
                this.f1873b.get(i13).u(this);
            }
        }
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt3 = getChildAt(i14);
            if (childAt3 instanceof Placeholder) {
                ((Placeholder) childAt3).c(this);
            }
        }
        this.f1887p.clear();
        this.f1887p.put(0, this.f1874c);
        this.f1887p.put(getId(), this.f1874c);
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt4 = getChildAt(i15);
            this.f1887p.put(childAt4.getId(), p(childAt4));
        }
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt5 = getChildAt(i16);
            e p11 = p(childAt5);
            if (p11 != null) {
                this.f1874c.b(p11);
                e(isInEditMode, childAt5, p11, (LayoutParams) childAt5.getLayoutParams(), this.f1887p);
            }
        }
    }

    private void z(e eVar, LayoutParams layoutParams, SparseArray<e> sparseArray, int i10, d.b bVar) {
        View view = this.f1872a.get(i10);
        e eVar2 = sparseArray.get(i10);
        if (eVar2 != null && view != null && (view.getLayoutParams() instanceof LayoutParams)) {
            layoutParams.f1896c0 = true;
            d.b bVar2 = d.b.BASELINE;
            if (bVar == bVar2) {
                LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                layoutParams2.f1896c0 = true;
                layoutParams2.f1926r0.O0(true);
            }
            eVar.q(bVar2).b(eVar2.q(bVar), layoutParams.D, layoutParams.C, true);
            eVar.O0(true);
            eVar.q(d.b.TOP).q();
            eVar.q(d.b.BOTTOM).q();
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<ConstraintHelper> arrayList = this.f1873b;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i10 = 0; i10 < size; i10++) {
                this.f1873b.get(i10).t(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = (float) getWidth();
            float height = (float) getHeight();
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                if (!(childAt.getVisibility() == 8 || (tag = childAt.getTag()) == null || !(tag instanceof String))) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i12 = (int) ((((float) parseInt) / 1080.0f) * width);
                        int i13 = (int) ((((float) parseInt2) / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f10 = (float) i12;
                        float f11 = (float) (i12 + ((int) ((((float) parseInt3) / 1080.0f) * width)));
                        Canvas canvas2 = canvas;
                        float f12 = (float) i13;
                        float f13 = f10;
                        float f14 = f10;
                        float f15 = f12;
                        Paint paint2 = paint;
                        float f16 = f11;
                        Paint paint3 = paint2;
                        canvas2.drawLine(f13, f15, f16, f12, paint3);
                        float parseInt4 = (float) (i13 + ((int) ((((float) Integer.parseInt(split[3])) / 1920.0f) * height)));
                        float f17 = f11;
                        float f18 = parseInt4;
                        canvas2.drawLine(f17, f15, f16, f18, paint3);
                        float f19 = parseInt4;
                        float f20 = f14;
                        canvas2.drawLine(f17, f19, f20, f18, paint3);
                        float f21 = f14;
                        canvas2.drawLine(f21, f19, f20, f12, paint3);
                        Paint paint4 = paint2;
                        paint4.setColor(-16711936);
                        Paint paint5 = paint4;
                        float f22 = f11;
                        Paint paint6 = paint5;
                        canvas2.drawLine(f21, f12, f22, parseInt4, paint6);
                        canvas2.drawLine(f21, parseInt4, f22, f12, paint6);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0107 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(boolean r16, android.view.View r17, h0.e r18, androidx.constraintlayout.widget.ConstraintLayout.LayoutParams r19, android.util.SparseArray<h0.e> r20) {
        /*
            r15 = this;
            r0 = r17
            r6 = r18
            r7 = r19
            r8 = r20
            r19.c()
            int r1 = r17.getVisibility()
            r6.n1(r1)
            boolean r1 = r7.f1902f0
            if (r1 == 0) goto L_0x001f
            r1 = 1
            r6.X0(r1)
            r1 = 8
            r6.n1(r1)
        L_0x001f:
            r6.F0(r0)
            boolean r1 = r0 instanceof androidx.constraintlayout.widget.ConstraintHelper
            if (r1 == 0) goto L_0x0033
            androidx.constraintlayout.widget.ConstraintHelper r0 = (androidx.constraintlayout.widget.ConstraintHelper) r0
            r9 = r15
            h0.f r1 = r9.f1874c
            boolean r1 = r1.T1()
            r0.q(r6, r1)
            goto L_0x0034
        L_0x0033:
            r9 = r15
        L_0x0034:
            boolean r0 = r7.f1898d0
            r1 = 17
            r10 = -1
            if (r0 == 0) goto L_0x0067
            r0 = r6
            h0.h r0 = (h0.h) r0
            int r2 = r7.f1920o0
            int r3 = r7.f1922p0
            float r4 = r7.f1924q0
            int r5 = android.os.Build.VERSION.SDK_INT
            if (r5 >= r1) goto L_0x004e
            int r2 = r7.f1891a
            int r3 = r7.f1893b
            float r4 = r7.f1895c
        L_0x004e:
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r1 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r1 == 0) goto L_0x0059
            r0.D1(r4)
            goto L_0x027e
        L_0x0059:
            if (r2 == r10) goto L_0x0060
            r0.B1(r2)
            goto L_0x027e
        L_0x0060:
            if (r3 == r10) goto L_0x027e
            r0.C1(r3)
            goto L_0x027e
        L_0x0067:
            int r0 = r7.f1906h0
            int r2 = r7.f1908i0
            int r3 = r7.f1910j0
            int r4 = r7.f1912k0
            int r5 = r7.f1914l0
            int r11 = r7.f1916m0
            float r12 = r7.f1918n0
            int r13 = android.os.Build.VERSION.SDK_INT
            if (r13 >= r1) goto L_0x00b1
            int r0 = r7.f1899e
            int r1 = r7.f1901f
            int r3 = r7.f1903g
            int r4 = r7.f1905h
            int r2 = r7.f1931w
            int r5 = r7.f1933y
            float r12 = r7.E
            if (r0 != r10) goto L_0x0096
            if (r1 != r10) goto L_0x0096
            int r11 = r7.f1928t
            if (r11 == r10) goto L_0x0091
            r0 = r11
            goto L_0x0096
        L_0x0091:
            int r11 = r7.f1927s
            if (r11 == r10) goto L_0x0096
            r1 = r11
        L_0x0096:
            if (r3 != r10) goto L_0x00aa
            if (r4 != r10) goto L_0x00aa
            int r11 = r7.f1929u
            if (r11 == r10) goto L_0x009f
            goto L_0x00ab
        L_0x009f:
            int r11 = r7.f1930v
            if (r11 == r10) goto L_0x00aa
            r13 = r5
            r14 = r12
            r5 = r2
            r12 = r11
            r2 = r1
            r11 = r3
            goto L_0x00b5
        L_0x00aa:
            r11 = r3
        L_0x00ab:
            r13 = r5
            r14 = r12
            r5 = r2
            r12 = r4
            r2 = r1
            goto L_0x00b5
        L_0x00b1:
            r13 = r11
            r14 = r12
            r11 = r3
            r12 = r4
        L_0x00b5:
            int r1 = r7.f1921p
            if (r1 == r10) goto L_0x00ca
            java.lang.Object r0 = r8.get(r1)
            h0.e r0 = (h0.e) r0
            if (r0 == 0) goto L_0x01af
            float r1 = r7.f1925r
            int r2 = r7.f1923q
            r6.m(r0, r1, r2)
            goto L_0x01af
        L_0x00ca:
            if (r0 == r10) goto L_0x00dd
            java.lang.Object r0 = r8.get(r0)
            r2 = r0
            h0.e r2 = (h0.e) r2
            if (r2 == 0) goto L_0x00f3
            h0.d$b r3 = h0.d.b.LEFT
            int r4 = r7.leftMargin
            r0 = r18
            r1 = r3
            goto L_0x00f0
        L_0x00dd:
            if (r2 == r10) goto L_0x00f3
            java.lang.Object r0 = r8.get(r2)
            r2 = r0
            h0.e r2 = (h0.e) r2
            if (r2 == 0) goto L_0x00f3
            h0.d$b r1 = h0.d.b.LEFT
            h0.d$b r3 = h0.d.b.RIGHT
            int r4 = r7.leftMargin
            r0 = r18
        L_0x00f0:
            r0.g0(r1, r2, r3, r4, r5)
        L_0x00f3:
            if (r11 == r10) goto L_0x0107
            java.lang.Object r0 = r8.get(r11)
            r2 = r0
            h0.e r2 = (h0.e) r2
            if (r2 == 0) goto L_0x011d
            h0.d$b r1 = h0.d.b.RIGHT
            h0.d$b r3 = h0.d.b.LEFT
            int r4 = r7.rightMargin
            r0 = r18
            goto L_0x0119
        L_0x0107:
            if (r12 == r10) goto L_0x011d
            java.lang.Object r0 = r8.get(r12)
            r2 = r0
            h0.e r2 = (h0.e) r2
            if (r2 == 0) goto L_0x011d
            h0.d$b r3 = h0.d.b.RIGHT
            int r4 = r7.rightMargin
            r0 = r18
            r1 = r3
        L_0x0119:
            r5 = r13
            r0.g0(r1, r2, r3, r4, r5)
        L_0x011d:
            int r0 = r7.f1907i
            if (r0 == r10) goto L_0x0134
            java.lang.Object r0 = r8.get(r0)
            r2 = r0
            h0.e r2 = (h0.e) r2
            if (r2 == 0) goto L_0x014e
            h0.d$b r3 = h0.d.b.TOP
            int r4 = r7.topMargin
            int r5 = r7.f1932x
            r0 = r18
            r1 = r3
            goto L_0x014b
        L_0x0134:
            int r0 = r7.f1909j
            if (r0 == r10) goto L_0x014e
            java.lang.Object r0 = r8.get(r0)
            r2 = r0
            h0.e r2 = (h0.e) r2
            if (r2 == 0) goto L_0x014e
            h0.d$b r1 = h0.d.b.TOP
            h0.d$b r3 = h0.d.b.BOTTOM
            int r4 = r7.topMargin
            int r5 = r7.f1932x
            r0 = r18
        L_0x014b:
            r0.g0(r1, r2, r3, r4, r5)
        L_0x014e:
            int r0 = r7.f1911k
            if (r0 == r10) goto L_0x0166
            java.lang.Object r0 = r8.get(r0)
            r2 = r0
            h0.e r2 = (h0.e) r2
            if (r2 == 0) goto L_0x017f
            h0.d$b r1 = h0.d.b.BOTTOM
            h0.d$b r3 = h0.d.b.TOP
            int r4 = r7.bottomMargin
            int r5 = r7.f1934z
            r0 = r18
            goto L_0x017c
        L_0x0166:
            int r0 = r7.f1913l
            if (r0 == r10) goto L_0x017f
            java.lang.Object r0 = r8.get(r0)
            r2 = r0
            h0.e r2 = (h0.e) r2
            if (r2 == 0) goto L_0x017f
            h0.d$b r3 = h0.d.b.BOTTOM
            int r4 = r7.bottomMargin
            int r5 = r7.f1934z
            r0 = r18
            r1 = r3
        L_0x017c:
            r0.g0(r1, r2, r3, r4, r5)
        L_0x017f:
            int r4 = r7.f1915m
            if (r4 == r10) goto L_0x0190
            h0.d$b r5 = h0.d.b.BASELINE
        L_0x0185:
            r0 = r15
            r1 = r18
            r2 = r19
            r3 = r20
            r0.z(r1, r2, r3, r4, r5)
            goto L_0x019e
        L_0x0190:
            int r4 = r7.f1917n
            if (r4 == r10) goto L_0x0197
            h0.d$b r5 = h0.d.b.TOP
            goto L_0x0185
        L_0x0197:
            int r4 = r7.f1919o
            if (r4 == r10) goto L_0x019e
            h0.d$b r5 = h0.d.b.BOTTOM
            goto L_0x0185
        L_0x019e:
            r0 = 0
            int r1 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r1 < 0) goto L_0x01a6
            r6.Q0(r14)
        L_0x01a6:
            float r1 = r7.F
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 < 0) goto L_0x01af
            r6.h1(r1)
        L_0x01af:
            if (r16 == 0) goto L_0x01be
            int r0 = r7.T
            if (r0 != r10) goto L_0x01b9
            int r1 = r7.U
            if (r1 == r10) goto L_0x01be
        L_0x01b9:
            int r1 = r7.U
            r6.f1(r0, r1)
        L_0x01be:
            boolean r0 = r7.f1892a0
            r1 = 0
            r2 = -2
            if (r0 != 0) goto L_0x01f2
            int r0 = r7.width
            if (r0 != r10) goto L_0x01e9
            boolean r0 = r7.W
            if (r0 == 0) goto L_0x01cf
            h0.e$b r0 = h0.e.b.MATCH_CONSTRAINT
            goto L_0x01d1
        L_0x01cf:
            h0.e$b r0 = h0.e.b.MATCH_PARENT
        L_0x01d1:
            r6.T0(r0)
            h0.d$b r0 = h0.d.b.LEFT
            h0.d r0 = r6.q(r0)
            int r3 = r7.leftMargin
            r0.f14340g = r3
            h0.d$b r0 = h0.d.b.RIGHT
            h0.d r0 = r6.q(r0)
            int r3 = r7.rightMargin
            r0.f14340g = r3
            goto L_0x0205
        L_0x01e9:
            h0.e$b r0 = h0.e.b.MATCH_CONSTRAINT
            r6.T0(r0)
            r6.o1(r1)
            goto L_0x0205
        L_0x01f2:
            h0.e$b r0 = h0.e.b.FIXED
            r6.T0(r0)
            int r0 = r7.width
            r6.o1(r0)
            int r0 = r7.width
            if (r0 != r2) goto L_0x0205
            h0.e$b r0 = h0.e.b.WRAP_CONTENT
            r6.T0(r0)
        L_0x0205:
            boolean r0 = r7.f1894b0
            if (r0 != 0) goto L_0x0237
            int r0 = r7.height
            if (r0 != r10) goto L_0x022e
            boolean r0 = r7.X
            if (r0 == 0) goto L_0x0214
            h0.e$b r0 = h0.e.b.MATCH_CONSTRAINT
            goto L_0x0216
        L_0x0214:
            h0.e$b r0 = h0.e.b.MATCH_PARENT
        L_0x0216:
            r6.k1(r0)
            h0.d$b r0 = h0.d.b.TOP
            h0.d r0 = r6.q(r0)
            int r1 = r7.topMargin
            r0.f14340g = r1
            h0.d$b r0 = h0.d.b.BOTTOM
            h0.d r0 = r6.q(r0)
            int r1 = r7.bottomMargin
            r0.f14340g = r1
            goto L_0x024a
        L_0x022e:
            h0.e$b r0 = h0.e.b.MATCH_CONSTRAINT
            r6.k1(r0)
            r6.P0(r1)
            goto L_0x024a
        L_0x0237:
            h0.e$b r0 = h0.e.b.FIXED
            r6.k1(r0)
            int r0 = r7.height
            r6.P0(r0)
            int r0 = r7.height
            if (r0 != r2) goto L_0x024a
            h0.e$b r0 = h0.e.b.WRAP_CONTENT
            r6.k1(r0)
        L_0x024a:
            java.lang.String r0 = r7.G
            r6.H0(r0)
            float r0 = r7.H
            r6.V0(r0)
            float r0 = r7.I
            r6.m1(r0)
            int r0 = r7.J
            r6.R0(r0)
            int r0 = r7.K
            r6.i1(r0)
            int r0 = r7.Z
            r6.p1(r0)
            int r0 = r7.L
            int r1 = r7.N
            int r2 = r7.P
            float r3 = r7.R
            r6.U0(r0, r1, r2, r3)
            int r0 = r7.M
            int r1 = r7.O
            int r2 = r7.Q
            float r3 = r7.S
            r6.l1(r0, r1, r2, r3)
        L_0x027e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.e(boolean, android.view.View, h0.e, androidx.constraintlayout.widget.ConstraintLayout$LayoutParams, android.util.SparseArray):void");
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public void forceLayout() {
        s();
        super.forceLayout();
    }

    /* renamed from: g */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public int getMaxHeight() {
        return this.f1878g;
    }

    public int getMaxWidth() {
        return this.f1877f;
    }

    public int getMinHeight() {
        return this.f1876e;
    }

    public int getMinWidth() {
        return this.f1875d;
    }

    public int getOptimizationLevel() {
        return this.f1874c.N1();
    }

    public String getSceneString() {
        int id2;
        StringBuilder sb2 = new StringBuilder();
        if (this.f1874c.f14376l == null) {
            int id3 = getId();
            if (id3 != -1) {
                this.f1874c.f14376l = getContext().getResources().getResourceEntryName(id3);
            } else {
                this.f1874c.f14376l = "parent";
            }
        }
        if (this.f1874c.v() == null) {
            f fVar = this.f1874c;
            fVar.G0(fVar.f14376l);
            Log.v("ConstraintLayout", " setDebugName " + this.f1874c.v());
        }
        Iterator<e> it = this.f1874c.v1().iterator();
        while (it.hasNext()) {
            e next = it.next();
            View view = (View) next.u();
            if (view != null) {
                if (next.f14376l == null && (id2 = view.getId()) != -1) {
                    next.f14376l = getContext().getResources().getResourceEntryName(id2);
                }
                if (next.v() == null) {
                    next.G0(next.f14376l);
                    Log.v("ConstraintLayout", " setDebugName " + next.v());
                }
            }
        }
        this.f1874c.Q(sb2);
        return sb2.toString();
    }

    public Object h(int i10, Object obj) {
        if (i10 != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> hashMap = this.f1884m;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return null;
        }
        return this.f1884m.get(str);
    }

    public View l(int i10) {
        return this.f1872a.get(i10);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            e eVar = layoutParams.f1926r0;
            if ((childAt.getVisibility() != 8 || layoutParams.f1898d0 || layoutParams.f1900e0 || layoutParams.f1904g0 || isInEditMode) && !layoutParams.f1902f0) {
                int Z = eVar.Z();
                int a02 = eVar.a0();
                int Y = eVar.Y() + Z;
                int z11 = eVar.z() + a02;
                childAt.layout(Z, a02, Y, z11);
                if ((childAt instanceof Placeholder) && (content = ((Placeholder) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(Z, a02, Y, z11);
                }
            }
        }
        int size = this.f1873b.size();
        if (size > 0) {
            for (int i15 = 0; i15 < size; i15++) {
                this.f1873b.get(i15).r(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        if (this.f1889r == i10) {
            int i12 = this.f1890s;
        }
        if (!this.f1879h) {
            int childCount = getChildCount();
            int i13 = 0;
            while (true) {
                if (i13 >= childCount) {
                    break;
                } else if (getChildAt(i13).isLayoutRequested()) {
                    this.f1879h = true;
                    break;
                } else {
                    i13++;
                }
            }
        }
        boolean z10 = this.f1879h;
        this.f1889r = i10;
        this.f1890s = i11;
        this.f1874c.c2(r());
        if (this.f1879h) {
            this.f1879h = false;
            if (A()) {
                this.f1874c.e2();
            }
        }
        v(this.f1874c, this.f1880i, i10, i11);
        u(i10, i11, this.f1874c.Y(), this.f1874c.z(), this.f1874c.U1(), this.f1874c.S1());
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        e p10 = p(view);
        if ((view instanceof Guideline) && !(p10 instanceof h)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            h hVar = new h();
            layoutParams.f1926r0 = hVar;
            layoutParams.f1898d0 = true;
            hVar.E1(layoutParams.V);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.w();
            ((LayoutParams) view.getLayoutParams()).f1900e0 = true;
            if (!this.f1873b.contains(constraintHelper)) {
                this.f1873b.add(constraintHelper);
            }
        }
        this.f1872a.put(view.getId(), view);
        this.f1879h = true;
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f1872a.remove(view.getId());
        this.f1874c.x1(p(view));
        this.f1873b.remove(view);
        this.f1879h = true;
    }

    public final e p(View view) {
        if (view == this) {
            return this.f1874c;
        }
        if (view == null) {
            return null;
        }
        if (!(view.getLayoutParams() instanceof LayoutParams)) {
            view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
            if (!(view.getLayoutParams() instanceof LayoutParams)) {
                return null;
            }
        }
        return ((LayoutParams) view.getLayoutParams()).f1926r0;
    }

    /* access modifiers changed from: protected */
    public boolean r() {
        if (Build.VERSION.SDK_INT < 17) {
            return false;
        }
        return ((getContext().getApplicationInfo().flags & 4194304) != 0) && 1 == getLayoutDirection();
    }

    public void requestLayout() {
        s();
        super.requestLayout();
    }

    public void setConstraintSet(c cVar) {
        this.f1881j = cVar;
    }

    public void setId(int i10) {
        this.f1872a.remove(getId());
        super.setId(i10);
        this.f1872a.put(getId(), this);
    }

    public void setMaxHeight(int i10) {
        if (i10 != this.f1878g) {
            this.f1878g = i10;
            requestLayout();
        }
    }

    public void setMaxWidth(int i10) {
        if (i10 != this.f1877f) {
            this.f1877f = i10;
            requestLayout();
        }
    }

    public void setMinHeight(int i10) {
        if (i10 != this.f1876e) {
            this.f1876e = i10;
            requestLayout();
        }
    }

    public void setMinWidth(int i10) {
        if (i10 != this.f1875d) {
            this.f1875d = i10;
            requestLayout();
        }
    }

    public void setOnConstraintsChanged(d dVar) {
        b bVar = this.f1882k;
        if (bVar != null) {
            bVar.c(dVar);
        }
    }

    public void setOptimizationLevel(int i10) {
        this.f1880i = i10;
        this.f1874c.a2(i10);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void t(int i10) {
        this.f1882k = new b(getContext(), this, i10);
    }

    /* access modifiers changed from: protected */
    public void u(int i10, int i11, int i12, int i13, boolean z10, boolean z11) {
        b bVar = this.f1888q;
        int i14 = bVar.f1941e;
        int resolveSizeAndState = ViewGroup.resolveSizeAndState(i12 + bVar.f1940d, i10, 0);
        int min = Math.min(this.f1877f, resolveSizeAndState & 16777215);
        int min2 = Math.min(this.f1878g, ViewGroup.resolveSizeAndState(i13 + i14, i11, 0) & 16777215);
        if (z10) {
            min |= 16777216;
        }
        if (z11) {
            min2 |= 16777216;
        }
        setMeasuredDimension(min, min2);
        this.f1885n = min;
        this.f1886o = min2;
    }

    /* access modifiers changed from: protected */
    public void v(f fVar, int i10, int i11, int i12) {
        int i13;
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size2 = View.MeasureSpec.getSize(i12);
        int max = Math.max(0, getPaddingTop());
        int max2 = Math.max(0, getPaddingBottom());
        int i14 = max + max2;
        int paddingWidth = getPaddingWidth();
        this.f1888q.c(i11, i12, max, max2, paddingWidth, i14);
        if (Build.VERSION.SDK_INT >= 17) {
            int max3 = Math.max(0, getPaddingStart());
            int max4 = Math.max(0, getPaddingEnd());
            if (max3 <= 0 && max4 <= 0) {
                max3 = Math.max(0, getPaddingLeft());
            } else if (r()) {
                max3 = max4;
            }
            i13 = max3;
        } else {
            i13 = Math.max(0, getPaddingLeft());
        }
        int i15 = size - paddingWidth;
        int i16 = size2 - i14;
        y(fVar, mode, i15, mode2, i16);
        fVar.V1(i10, mode, i15, mode2, i16, this.f1885n, this.f1886o, i13, max);
    }

    public void x(int i10, Object obj, Object obj2) {
        if (i10 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.f1884m == null) {
                this.f1884m = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            this.f1884m.put(str, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002a, code lost:
        if (r3 == 0) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0044, code lost:
        if (r3 == 0) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0049, code lost:
        if (r3 == 0) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0025, code lost:
        if (r3 == 0) goto L_0x002c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0047  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void y(h0.f r8, int r9, int r10, int r11, int r12) {
        /*
            r7 = this;
            androidx.constraintlayout.widget.ConstraintLayout$b r0 = r7.f1888q
            int r1 = r0.f1941e
            int r0 = r0.f1940d
            h0.e$b r2 = h0.e.b.FIXED
            int r3 = r7.getChildCount()
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = 0
            if (r9 == r5) goto L_0x0028
            if (r9 == 0) goto L_0x0023
            if (r9 == r4) goto L_0x001a
            r9 = r2
        L_0x0018:
            r10 = r6
            goto L_0x0032
        L_0x001a:
            int r9 = r7.f1877f
            int r9 = r9 - r0
            int r10 = java.lang.Math.min(r9, r10)
            r9 = r2
            goto L_0x0032
        L_0x0023:
            h0.e$b r9 = h0.e.b.WRAP_CONTENT
            if (r3 != 0) goto L_0x0018
            goto L_0x002c
        L_0x0028:
            h0.e$b r9 = h0.e.b.WRAP_CONTENT
            if (r3 != 0) goto L_0x0032
        L_0x002c:
            int r10 = r7.f1875d
            int r10 = java.lang.Math.max(r6, r10)
        L_0x0032:
            if (r11 == r5) goto L_0x0047
            if (r11 == 0) goto L_0x0042
            if (r11 == r4) goto L_0x003a
        L_0x0038:
            r12 = r6
            goto L_0x0051
        L_0x003a:
            int r11 = r7.f1878g
            int r11 = r11 - r1
            int r12 = java.lang.Math.min(r11, r12)
            goto L_0x0051
        L_0x0042:
            h0.e$b r2 = h0.e.b.WRAP_CONTENT
            if (r3 != 0) goto L_0x0038
            goto L_0x004b
        L_0x0047:
            h0.e$b r2 = h0.e.b.WRAP_CONTENT
            if (r3 != 0) goto L_0x0051
        L_0x004b:
            int r11 = r7.f1876e
            int r12 = java.lang.Math.max(r6, r11)
        L_0x0051:
            int r11 = r8.Y()
            if (r10 != r11) goto L_0x005d
            int r11 = r8.z()
            if (r12 == r11) goto L_0x0060
        L_0x005d:
            r8.R1()
        L_0x0060:
            r8.q1(r6)
            r8.r1(r6)
            int r11 = r7.f1877f
            int r11 = r11 - r0
            r8.b1(r11)
            int r11 = r7.f1878g
            int r11 = r11 - r1
            r8.a1(r11)
            r8.e1(r6)
            r8.d1(r6)
            r8.T0(r9)
            r8.o1(r10)
            r8.k1(r2)
            r8.P0(r12)
            int r9 = r7.f1875d
            int r9 = r9 - r0
            r8.e1(r9)
            int r9 = r7.f1876e
            int r9 = r9 - r1
            r8.d1(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.y(h0.f, int, int, int, int):void");
    }
}
