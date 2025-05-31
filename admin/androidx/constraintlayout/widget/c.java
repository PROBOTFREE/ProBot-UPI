package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import h0.j;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class c {
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final int[] f1998g = {0, 4, 8};

    /* renamed from: h  reason: collision with root package name */
    private static SparseIntArray f1999h = new SparseIntArray();

    /* renamed from: i  reason: collision with root package name */
    private static SparseIntArray f2000i = new SparseIntArray();

    /* renamed from: a  reason: collision with root package name */
    public String f2001a;

    /* renamed from: b  reason: collision with root package name */
    public String f2002b = "";

    /* renamed from: c  reason: collision with root package name */
    public int f2003c = 0;

    /* renamed from: d  reason: collision with root package name */
    private HashMap<String, a> f2004d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private boolean f2005e = true;

    /* renamed from: f  reason: collision with root package name */
    private HashMap<Integer, a> f2006f = new HashMap<>();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        int f2007a;

        /* renamed from: b  reason: collision with root package name */
        String f2008b;

        /* renamed from: c  reason: collision with root package name */
        public final d f2009c = new d();

        /* renamed from: d  reason: collision with root package name */
        public final C0017c f2010d = new C0017c();

        /* renamed from: e  reason: collision with root package name */
        public final b f2011e = new b();

        /* renamed from: f  reason: collision with root package name */
        public final e f2012f = new e();

        /* renamed from: g  reason: collision with root package name */
        public HashMap<String, a> f2013g = new HashMap<>();

        /* renamed from: h  reason: collision with root package name */
        C0016a f2014h;

        /* renamed from: androidx.constraintlayout.widget.c$a$a  reason: collision with other inner class name */
        static class C0016a {

            /* renamed from: a  reason: collision with root package name */
            int[] f2015a = new int[10];

            /* renamed from: b  reason: collision with root package name */
            int[] f2016b = new int[10];

            /* renamed from: c  reason: collision with root package name */
            int f2017c = 0;

            /* renamed from: d  reason: collision with root package name */
            int[] f2018d = new int[10];

            /* renamed from: e  reason: collision with root package name */
            float[] f2019e = new float[10];

            /* renamed from: f  reason: collision with root package name */
            int f2020f = 0;

            /* renamed from: g  reason: collision with root package name */
            int[] f2021g = new int[5];

            /* renamed from: h  reason: collision with root package name */
            String[] f2022h = new String[5];

            /* renamed from: i  reason: collision with root package name */
            int f2023i = 0;

            /* renamed from: j  reason: collision with root package name */
            int[] f2024j = new int[4];

            /* renamed from: k  reason: collision with root package name */
            boolean[] f2025k = new boolean[4];

            /* renamed from: l  reason: collision with root package name */
            int f2026l = 0;

            C0016a() {
            }

            /* access modifiers changed from: package-private */
            public void a(int i10, float f10) {
                int i11 = this.f2020f;
                int[] iArr = this.f2018d;
                if (i11 >= iArr.length) {
                    this.f2018d = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.f2019e;
                    this.f2019e = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.f2018d;
                int i12 = this.f2020f;
                iArr2[i12] = i10;
                float[] fArr2 = this.f2019e;
                this.f2020f = i12 + 1;
                fArr2[i12] = f10;
            }

            /* access modifiers changed from: package-private */
            public void b(int i10, int i11) {
                int i12 = this.f2017c;
                int[] iArr = this.f2015a;
                if (i12 >= iArr.length) {
                    this.f2015a = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.f2016b;
                    this.f2016b = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.f2015a;
                int i13 = this.f2017c;
                iArr3[i13] = i10;
                int[] iArr4 = this.f2016b;
                this.f2017c = i13 + 1;
                iArr4[i13] = i11;
            }

            /* access modifiers changed from: package-private */
            public void c(int i10, String str) {
                int i11 = this.f2023i;
                int[] iArr = this.f2021g;
                if (i11 >= iArr.length) {
                    this.f2021g = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.f2022h;
                    this.f2022h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.f2021g;
                int i12 = this.f2023i;
                iArr2[i12] = i10;
                String[] strArr2 = this.f2022h;
                this.f2023i = i12 + 1;
                strArr2[i12] = str;
            }

            /* access modifiers changed from: package-private */
            public void d(int i10, boolean z10) {
                int i11 = this.f2026l;
                int[] iArr = this.f2024j;
                if (i11 >= iArr.length) {
                    this.f2024j = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.f2025k;
                    this.f2025k = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.f2024j;
                int i12 = this.f2026l;
                iArr2[i12] = i10;
                boolean[] zArr2 = this.f2025k;
                this.f2026l = i12 + 1;
                zArr2[i12] = z10;
            }

            /* access modifiers changed from: package-private */
            public void e(a aVar) {
                for (int i10 = 0; i10 < this.f2017c; i10++) {
                    c.O(aVar, this.f2015a[i10], this.f2016b[i10]);
                }
                for (int i11 = 0; i11 < this.f2020f; i11++) {
                    c.N(aVar, this.f2018d[i11], this.f2019e[i11]);
                }
                for (int i12 = 0; i12 < this.f2023i; i12++) {
                    c.P(aVar, this.f2021g[i12], this.f2022h[i12]);
                }
                for (int i13 = 0; i13 < this.f2026l; i13++) {
                    c.Q(aVar, this.f2024j[i13], this.f2025k[i13]);
                }
            }
        }

        /* access modifiers changed from: private */
        public void g(int i10, ConstraintLayout.LayoutParams layoutParams) {
            this.f2007a = i10;
            b bVar = this.f2011e;
            bVar.f2044i = layoutParams.f1899e;
            bVar.f2046j = layoutParams.f1901f;
            bVar.f2048k = layoutParams.f1903g;
            bVar.f2050l = layoutParams.f1905h;
            bVar.f2052m = layoutParams.f1907i;
            bVar.f2054n = layoutParams.f1909j;
            bVar.f2056o = layoutParams.f1911k;
            bVar.f2058p = layoutParams.f1913l;
            bVar.f2060q = layoutParams.f1915m;
            bVar.f2061r = layoutParams.f1917n;
            bVar.f2062s = layoutParams.f1919o;
            bVar.f2063t = layoutParams.f1927s;
            bVar.f2064u = layoutParams.f1928t;
            bVar.f2065v = layoutParams.f1929u;
            bVar.f2066w = layoutParams.f1930v;
            bVar.f2067x = layoutParams.E;
            bVar.f2068y = layoutParams.F;
            bVar.f2069z = layoutParams.G;
            bVar.A = layoutParams.f1921p;
            bVar.B = layoutParams.f1923q;
            bVar.C = layoutParams.f1925r;
            bVar.D = layoutParams.T;
            bVar.E = layoutParams.U;
            bVar.F = layoutParams.V;
            bVar.f2040g = layoutParams.f1895c;
            bVar.f2036e = layoutParams.f1891a;
            bVar.f2038f = layoutParams.f1893b;
            bVar.f2032c = layoutParams.width;
            bVar.f2034d = layoutParams.height;
            bVar.G = layoutParams.leftMargin;
            bVar.H = layoutParams.rightMargin;
            bVar.I = layoutParams.topMargin;
            bVar.J = layoutParams.bottomMargin;
            bVar.M = layoutParams.D;
            bVar.U = layoutParams.I;
            bVar.V = layoutParams.H;
            bVar.X = layoutParams.K;
            bVar.W = layoutParams.J;
            bVar.f2053m0 = layoutParams.W;
            bVar.f2055n0 = layoutParams.X;
            bVar.Y = layoutParams.L;
            bVar.Z = layoutParams.M;
            bVar.f2029a0 = layoutParams.P;
            bVar.f2031b0 = layoutParams.Q;
            bVar.f2033c0 = layoutParams.N;
            bVar.f2035d0 = layoutParams.O;
            bVar.f2037e0 = layoutParams.R;
            bVar.f2039f0 = layoutParams.S;
            bVar.f2051l0 = layoutParams.Y;
            bVar.O = layoutParams.f1932x;
            bVar.Q = layoutParams.f1934z;
            bVar.N = layoutParams.f1931w;
            bVar.P = layoutParams.f1933y;
            bVar.S = layoutParams.A;
            bVar.R = layoutParams.B;
            bVar.T = layoutParams.C;
            bVar.f2059p0 = layoutParams.Z;
            if (Build.VERSION.SDK_INT >= 17) {
                bVar.K = layoutParams.getMarginEnd();
                this.f2011e.L = layoutParams.getMarginStart();
            }
        }

        /* access modifiers changed from: private */
        public void h(int i10, Constraints.LayoutParams layoutParams) {
            g(i10, layoutParams);
            this.f2009c.f2088d = layoutParams.f1946s0;
            e eVar = this.f2012f;
            eVar.f2092b = layoutParams.f1949v0;
            eVar.f2093c = layoutParams.f1950w0;
            eVar.f2094d = layoutParams.f1951x0;
            eVar.f2095e = layoutParams.f1952y0;
            eVar.f2096f = layoutParams.f1953z0;
            eVar.f2097g = layoutParams.A0;
            eVar.f2098h = layoutParams.B0;
            eVar.f2100j = layoutParams.C0;
            eVar.f2101k = layoutParams.D0;
            eVar.f2102l = layoutParams.E0;
            eVar.f2104n = layoutParams.f1948u0;
            eVar.f2103m = layoutParams.f1947t0;
        }

        /* access modifiers changed from: private */
        public void i(ConstraintHelper constraintHelper, int i10, Constraints.LayoutParams layoutParams) {
            h(i10, layoutParams);
            if (constraintHelper instanceof Barrier) {
                b bVar = this.f2011e;
                bVar.f2045i0 = 1;
                Barrier barrier = (Barrier) constraintHelper;
                bVar.f2041g0 = barrier.getType();
                this.f2011e.f2047j0 = barrier.getReferencedIds();
                this.f2011e.f2043h0 = barrier.getMargin();
            }
        }

        public void d(a aVar) {
            C0016a aVar2 = this.f2014h;
            if (aVar2 != null) {
                aVar2.e(aVar);
            }
        }

        public void e(ConstraintLayout.LayoutParams layoutParams) {
            b bVar = this.f2011e;
            layoutParams.f1899e = bVar.f2044i;
            layoutParams.f1901f = bVar.f2046j;
            layoutParams.f1903g = bVar.f2048k;
            layoutParams.f1905h = bVar.f2050l;
            layoutParams.f1907i = bVar.f2052m;
            layoutParams.f1909j = bVar.f2054n;
            layoutParams.f1911k = bVar.f2056o;
            layoutParams.f1913l = bVar.f2058p;
            layoutParams.f1915m = bVar.f2060q;
            layoutParams.f1917n = bVar.f2061r;
            layoutParams.f1919o = bVar.f2062s;
            layoutParams.f1927s = bVar.f2063t;
            layoutParams.f1928t = bVar.f2064u;
            layoutParams.f1929u = bVar.f2065v;
            layoutParams.f1930v = bVar.f2066w;
            layoutParams.leftMargin = bVar.G;
            layoutParams.rightMargin = bVar.H;
            layoutParams.topMargin = bVar.I;
            layoutParams.bottomMargin = bVar.J;
            layoutParams.A = bVar.S;
            layoutParams.B = bVar.R;
            layoutParams.f1932x = bVar.O;
            layoutParams.f1934z = bVar.Q;
            layoutParams.E = bVar.f2067x;
            layoutParams.F = bVar.f2068y;
            layoutParams.f1921p = bVar.A;
            layoutParams.f1923q = bVar.B;
            layoutParams.f1925r = bVar.C;
            layoutParams.G = bVar.f2069z;
            layoutParams.T = bVar.D;
            layoutParams.U = bVar.E;
            layoutParams.I = bVar.U;
            layoutParams.H = bVar.V;
            layoutParams.K = bVar.X;
            layoutParams.J = bVar.W;
            layoutParams.W = bVar.f2053m0;
            layoutParams.X = bVar.f2055n0;
            layoutParams.L = bVar.Y;
            layoutParams.M = bVar.Z;
            layoutParams.P = bVar.f2029a0;
            layoutParams.Q = bVar.f2031b0;
            layoutParams.N = bVar.f2033c0;
            layoutParams.O = bVar.f2035d0;
            layoutParams.R = bVar.f2037e0;
            layoutParams.S = bVar.f2039f0;
            layoutParams.V = bVar.F;
            layoutParams.f1895c = bVar.f2040g;
            layoutParams.f1891a = bVar.f2036e;
            layoutParams.f1893b = bVar.f2038f;
            layoutParams.width = bVar.f2032c;
            layoutParams.height = bVar.f2034d;
            String str = bVar.f2051l0;
            if (str != null) {
                layoutParams.Y = str;
            }
            layoutParams.Z = bVar.f2059p0;
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.setMarginStart(bVar.L);
                layoutParams.setMarginEnd(this.f2011e.K);
            }
            layoutParams.c();
        }

        /* renamed from: f */
        public a clone() {
            a aVar = new a();
            aVar.f2011e.a(this.f2011e);
            aVar.f2010d.a(this.f2010d);
            aVar.f2009c.a(this.f2009c);
            aVar.f2012f.a(this.f2012f);
            aVar.f2007a = this.f2007a;
            aVar.f2014h = this.f2014h;
            return aVar;
        }
    }

    public static class b {

        /* renamed from: q0  reason: collision with root package name */
        private static SparseIntArray f2027q0;
        public int A = -1;
        public int B = 0;
        public float C = 0.0f;
        public int D = -1;
        public int E = -1;
        public int F = -1;
        public int G = 0;
        public int H = 0;
        public int I = 0;
        public int J = 0;
        public int K = 0;
        public int L = 0;
        public int M = 0;
        public int N = Integer.MIN_VALUE;
        public int O = Integer.MIN_VALUE;
        public int P = Integer.MIN_VALUE;
        public int Q = Integer.MIN_VALUE;
        public int R = Integer.MIN_VALUE;
        public int S = Integer.MIN_VALUE;
        public int T = Integer.MIN_VALUE;
        public float U = -1.0f;
        public float V = -1.0f;
        public int W = 0;
        public int X = 0;
        public int Y = 0;
        public int Z = 0;

        /* renamed from: a  reason: collision with root package name */
        public boolean f2028a = false;

        /* renamed from: a0  reason: collision with root package name */
        public int f2029a0 = 0;

        /* renamed from: b  reason: collision with root package name */
        public boolean f2030b = false;

        /* renamed from: b0  reason: collision with root package name */
        public int f2031b0 = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f2032c;

        /* renamed from: c0  reason: collision with root package name */
        public int f2033c0 = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f2034d;

        /* renamed from: d0  reason: collision with root package name */
        public int f2035d0 = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f2036e = -1;

        /* renamed from: e0  reason: collision with root package name */
        public float f2037e0 = 1.0f;

        /* renamed from: f  reason: collision with root package name */
        public int f2038f = -1;

        /* renamed from: f0  reason: collision with root package name */
        public float f2039f0 = 1.0f;

        /* renamed from: g  reason: collision with root package name */
        public float f2040g = -1.0f;

        /* renamed from: g0  reason: collision with root package name */
        public int f2041g0 = -1;

        /* renamed from: h  reason: collision with root package name */
        public boolean f2042h = true;

        /* renamed from: h0  reason: collision with root package name */
        public int f2043h0 = 0;

        /* renamed from: i  reason: collision with root package name */
        public int f2044i = -1;

        /* renamed from: i0  reason: collision with root package name */
        public int f2045i0 = -1;

        /* renamed from: j  reason: collision with root package name */
        public int f2046j = -1;

        /* renamed from: j0  reason: collision with root package name */
        public int[] f2047j0;

        /* renamed from: k  reason: collision with root package name */
        public int f2048k = -1;

        /* renamed from: k0  reason: collision with root package name */
        public String f2049k0;

        /* renamed from: l  reason: collision with root package name */
        public int f2050l = -1;

        /* renamed from: l0  reason: collision with root package name */
        public String f2051l0;

        /* renamed from: m  reason: collision with root package name */
        public int f2052m = -1;

        /* renamed from: m0  reason: collision with root package name */
        public boolean f2053m0 = false;

        /* renamed from: n  reason: collision with root package name */
        public int f2054n = -1;

        /* renamed from: n0  reason: collision with root package name */
        public boolean f2055n0 = false;

        /* renamed from: o  reason: collision with root package name */
        public int f2056o = -1;

        /* renamed from: o0  reason: collision with root package name */
        public boolean f2057o0 = true;

        /* renamed from: p  reason: collision with root package name */
        public int f2058p = -1;

        /* renamed from: p0  reason: collision with root package name */
        public int f2059p0 = 0;

        /* renamed from: q  reason: collision with root package name */
        public int f2060q = -1;

        /* renamed from: r  reason: collision with root package name */
        public int f2061r = -1;

        /* renamed from: s  reason: collision with root package name */
        public int f2062s = -1;

        /* renamed from: t  reason: collision with root package name */
        public int f2063t = -1;

        /* renamed from: u  reason: collision with root package name */
        public int f2064u = -1;

        /* renamed from: v  reason: collision with root package name */
        public int f2065v = -1;

        /* renamed from: w  reason: collision with root package name */
        public int f2066w = -1;

        /* renamed from: x  reason: collision with root package name */
        public float f2067x = 0.5f;

        /* renamed from: y  reason: collision with root package name */
        public float f2068y = 0.5f;

        /* renamed from: z  reason: collision with root package name */
        public String f2069z = null;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f2027q0 = sparseIntArray;
            sparseIntArray.append(f.Layout_layout_constraintLeft_toLeftOf, 24);
            f2027q0.append(f.Layout_layout_constraintLeft_toRightOf, 25);
            f2027q0.append(f.Layout_layout_constraintRight_toLeftOf, 28);
            f2027q0.append(f.Layout_layout_constraintRight_toRightOf, 29);
            f2027q0.append(f.Layout_layout_constraintTop_toTopOf, 35);
            f2027q0.append(f.Layout_layout_constraintTop_toBottomOf, 34);
            f2027q0.append(f.Layout_layout_constraintBottom_toTopOf, 4);
            f2027q0.append(f.Layout_layout_constraintBottom_toBottomOf, 3);
            f2027q0.append(f.Layout_layout_constraintBaseline_toBaselineOf, 1);
            f2027q0.append(f.Layout_layout_editor_absoluteX, 6);
            f2027q0.append(f.Layout_layout_editor_absoluteY, 7);
            f2027q0.append(f.Layout_layout_constraintGuide_begin, 17);
            f2027q0.append(f.Layout_layout_constraintGuide_end, 18);
            f2027q0.append(f.Layout_layout_constraintGuide_percent, 19);
            f2027q0.append(f.Layout_guidelineUseRtl, 90);
            f2027q0.append(f.Layout_android_orientation, 26);
            f2027q0.append(f.Layout_layout_constraintStart_toEndOf, 31);
            f2027q0.append(f.Layout_layout_constraintStart_toStartOf, 32);
            f2027q0.append(f.Layout_layout_constraintEnd_toStartOf, 10);
            f2027q0.append(f.Layout_layout_constraintEnd_toEndOf, 9);
            f2027q0.append(f.Layout_layout_goneMarginLeft, 13);
            f2027q0.append(f.Layout_layout_goneMarginTop, 16);
            f2027q0.append(f.Layout_layout_goneMarginRight, 14);
            f2027q0.append(f.Layout_layout_goneMarginBottom, 11);
            f2027q0.append(f.Layout_layout_goneMarginStart, 15);
            f2027q0.append(f.Layout_layout_goneMarginEnd, 12);
            f2027q0.append(f.Layout_layout_constraintVertical_weight, 38);
            f2027q0.append(f.Layout_layout_constraintHorizontal_weight, 37);
            f2027q0.append(f.Layout_layout_constraintHorizontal_chainStyle, 39);
            f2027q0.append(f.Layout_layout_constraintVertical_chainStyle, 40);
            f2027q0.append(f.Layout_layout_constraintHorizontal_bias, 20);
            f2027q0.append(f.Layout_layout_constraintVertical_bias, 36);
            f2027q0.append(f.Layout_layout_constraintDimensionRatio, 5);
            f2027q0.append(f.Layout_layout_constraintLeft_creator, 91);
            f2027q0.append(f.Layout_layout_constraintTop_creator, 91);
            f2027q0.append(f.Layout_layout_constraintRight_creator, 91);
            f2027q0.append(f.Layout_layout_constraintBottom_creator, 91);
            f2027q0.append(f.Layout_layout_constraintBaseline_creator, 91);
            f2027q0.append(f.Layout_android_layout_marginLeft, 23);
            f2027q0.append(f.Layout_android_layout_marginRight, 27);
            f2027q0.append(f.Layout_android_layout_marginStart, 30);
            f2027q0.append(f.Layout_android_layout_marginEnd, 8);
            f2027q0.append(f.Layout_android_layout_marginTop, 33);
            f2027q0.append(f.Layout_android_layout_marginBottom, 2);
            f2027q0.append(f.Layout_android_layout_width, 22);
            f2027q0.append(f.Layout_android_layout_height, 21);
            f2027q0.append(f.Layout_layout_constraintWidth, 41);
            f2027q0.append(f.Layout_layout_constraintHeight, 42);
            f2027q0.append(f.Layout_layout_constrainedWidth, 41);
            f2027q0.append(f.Layout_layout_constrainedHeight, 42);
            f2027q0.append(f.Layout_layout_wrapBehaviorInParent, 76);
            f2027q0.append(f.Layout_layout_constraintCircle, 61);
            f2027q0.append(f.Layout_layout_constraintCircleRadius, 62);
            f2027q0.append(f.Layout_layout_constraintCircleAngle, 63);
            f2027q0.append(f.Layout_layout_constraintWidth_percent, 69);
            f2027q0.append(f.Layout_layout_constraintHeight_percent, 70);
            f2027q0.append(f.Layout_chainUseRtl, 71);
            f2027q0.append(f.Layout_barrierDirection, 72);
            f2027q0.append(f.Layout_barrierMargin, 73);
            f2027q0.append(f.Layout_constraint_referenced_ids, 74);
            f2027q0.append(f.Layout_barrierAllowsGoneWidgets, 75);
        }

        public void a(b bVar) {
            this.f2028a = bVar.f2028a;
            this.f2032c = bVar.f2032c;
            this.f2030b = bVar.f2030b;
            this.f2034d = bVar.f2034d;
            this.f2036e = bVar.f2036e;
            this.f2038f = bVar.f2038f;
            this.f2040g = bVar.f2040g;
            this.f2042h = bVar.f2042h;
            this.f2044i = bVar.f2044i;
            this.f2046j = bVar.f2046j;
            this.f2048k = bVar.f2048k;
            this.f2050l = bVar.f2050l;
            this.f2052m = bVar.f2052m;
            this.f2054n = bVar.f2054n;
            this.f2056o = bVar.f2056o;
            this.f2058p = bVar.f2058p;
            this.f2060q = bVar.f2060q;
            this.f2061r = bVar.f2061r;
            this.f2062s = bVar.f2062s;
            this.f2063t = bVar.f2063t;
            this.f2064u = bVar.f2064u;
            this.f2065v = bVar.f2065v;
            this.f2066w = bVar.f2066w;
            this.f2067x = bVar.f2067x;
            this.f2068y = bVar.f2068y;
            this.f2069z = bVar.f2069z;
            this.A = bVar.A;
            this.B = bVar.B;
            this.C = bVar.C;
            this.D = bVar.D;
            this.E = bVar.E;
            this.F = bVar.F;
            this.G = bVar.G;
            this.H = bVar.H;
            this.I = bVar.I;
            this.J = bVar.J;
            this.K = bVar.K;
            this.L = bVar.L;
            this.M = bVar.M;
            this.N = bVar.N;
            this.O = bVar.O;
            this.P = bVar.P;
            this.Q = bVar.Q;
            this.R = bVar.R;
            this.S = bVar.S;
            this.T = bVar.T;
            this.U = bVar.U;
            this.V = bVar.V;
            this.W = bVar.W;
            this.X = bVar.X;
            this.Y = bVar.Y;
            this.Z = bVar.Z;
            this.f2029a0 = bVar.f2029a0;
            this.f2031b0 = bVar.f2031b0;
            this.f2033c0 = bVar.f2033c0;
            this.f2035d0 = bVar.f2035d0;
            this.f2037e0 = bVar.f2037e0;
            this.f2039f0 = bVar.f2039f0;
            this.f2041g0 = bVar.f2041g0;
            this.f2043h0 = bVar.f2043h0;
            this.f2045i0 = bVar.f2045i0;
            this.f2051l0 = bVar.f2051l0;
            int[] iArr = bVar.f2047j0;
            if (iArr == null || bVar.f2049k0 != null) {
                this.f2047j0 = null;
            } else {
                this.f2047j0 = Arrays.copyOf(iArr, iArr.length);
            }
            this.f2049k0 = bVar.f2049k0;
            this.f2053m0 = bVar.f2053m0;
            this.f2055n0 = bVar.f2055n0;
            this.f2057o0 = bVar.f2057o0;
            this.f2059p0 = bVar.f2059p0;
        }

        /* access modifiers changed from: package-private */
        public void b(Context context, AttributeSet attributeSet) {
            StringBuilder sb2;
            String str;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.Layout);
            this.f2030b = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                int i11 = f2027q0.get(index);
                switch (i11) {
                    case 1:
                        this.f2060q = c.F(obtainStyledAttributes, index, this.f2060q);
                        break;
                    case 2:
                        this.J = obtainStyledAttributes.getDimensionPixelSize(index, this.J);
                        break;
                    case 3:
                        this.f2058p = c.F(obtainStyledAttributes, index, this.f2058p);
                        break;
                    case 4:
                        this.f2056o = c.F(obtainStyledAttributes, index, this.f2056o);
                        break;
                    case 5:
                        this.f2069z = obtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        this.D = obtainStyledAttributes.getDimensionPixelOffset(index, this.D);
                        break;
                    case 7:
                        this.E = obtainStyledAttributes.getDimensionPixelOffset(index, this.E);
                        break;
                    case 8:
                        if (Build.VERSION.SDK_INT < 17) {
                            break;
                        } else {
                            this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                            break;
                        }
                    case 9:
                        this.f2066w = c.F(obtainStyledAttributes, index, this.f2066w);
                        break;
                    case 10:
                        this.f2065v = c.F(obtainStyledAttributes, index, this.f2065v);
                        break;
                    case 11:
                        this.Q = obtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                        break;
                    case 12:
                        this.R = obtainStyledAttributes.getDimensionPixelSize(index, this.R);
                        break;
                    case 13:
                        this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                        break;
                    case 14:
                        this.P = obtainStyledAttributes.getDimensionPixelSize(index, this.P);
                        break;
                    case 15:
                        this.S = obtainStyledAttributes.getDimensionPixelSize(index, this.S);
                        break;
                    case 16:
                        this.O = obtainStyledAttributes.getDimensionPixelSize(index, this.O);
                        break;
                    case 17:
                        this.f2036e = obtainStyledAttributes.getDimensionPixelOffset(index, this.f2036e);
                        break;
                    case 18:
                        this.f2038f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f2038f);
                        break;
                    case 19:
                        this.f2040g = obtainStyledAttributes.getFloat(index, this.f2040g);
                        break;
                    case 20:
                        this.f2067x = obtainStyledAttributes.getFloat(index, this.f2067x);
                        break;
                    case 21:
                        this.f2034d = obtainStyledAttributes.getLayoutDimension(index, this.f2034d);
                        break;
                    case 22:
                        this.f2032c = obtainStyledAttributes.getLayoutDimension(index, this.f2032c);
                        break;
                    case 23:
                        this.G = obtainStyledAttributes.getDimensionPixelSize(index, this.G);
                        break;
                    case 24:
                        this.f2044i = c.F(obtainStyledAttributes, index, this.f2044i);
                        break;
                    case 25:
                        this.f2046j = c.F(obtainStyledAttributes, index, this.f2046j);
                        break;
                    case 26:
                        this.F = obtainStyledAttributes.getInt(index, this.F);
                        break;
                    case 27:
                        this.H = obtainStyledAttributes.getDimensionPixelSize(index, this.H);
                        break;
                    case 28:
                        this.f2048k = c.F(obtainStyledAttributes, index, this.f2048k);
                        break;
                    case 29:
                        this.f2050l = c.F(obtainStyledAttributes, index, this.f2050l);
                        break;
                    case 30:
                        if (Build.VERSION.SDK_INT < 17) {
                            break;
                        } else {
                            this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                            break;
                        }
                    case 31:
                        this.f2063t = c.F(obtainStyledAttributes, index, this.f2063t);
                        break;
                    case 32:
                        this.f2064u = c.F(obtainStyledAttributes, index, this.f2064u);
                        break;
                    case 33:
                        this.I = obtainStyledAttributes.getDimensionPixelSize(index, this.I);
                        break;
                    case 34:
                        this.f2054n = c.F(obtainStyledAttributes, index, this.f2054n);
                        break;
                    case 35:
                        this.f2052m = c.F(obtainStyledAttributes, index, this.f2052m);
                        break;
                    case 36:
                        this.f2068y = obtainStyledAttributes.getFloat(index, this.f2068y);
                        break;
                    case 37:
                        this.V = obtainStyledAttributes.getFloat(index, this.V);
                        break;
                    case 38:
                        this.U = obtainStyledAttributes.getFloat(index, this.U);
                        break;
                    case 39:
                        this.W = obtainStyledAttributes.getInt(index, this.W);
                        break;
                    case 40:
                        this.X = obtainStyledAttributes.getInt(index, this.X);
                        break;
                    case 41:
                        c.G(this, obtainStyledAttributes, index, 0);
                        break;
                    case 42:
                        c.G(this, obtainStyledAttributes, index, 1);
                        break;
                    default:
                        switch (i11) {
                            case 61:
                                this.A = c.F(obtainStyledAttributes, index, this.A);
                                break;
                            case 62:
                                this.B = obtainStyledAttributes.getDimensionPixelSize(index, this.B);
                                break;
                            case 63:
                                this.C = obtainStyledAttributes.getFloat(index, this.C);
                                break;
                            default:
                                switch (i11) {
                                    case 69:
                                        this.f2037e0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                        continue;
                                    case 70:
                                        this.f2039f0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                        continue;
                                    case 71:
                                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                        continue;
                                    case 72:
                                        this.f2041g0 = obtainStyledAttributes.getInt(index, this.f2041g0);
                                        continue;
                                    case 73:
                                        this.f2043h0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f2043h0);
                                        continue;
                                    case 74:
                                        this.f2049k0 = obtainStyledAttributes.getString(index);
                                        continue;
                                    case 75:
                                        this.f2057o0 = obtainStyledAttributes.getBoolean(index, this.f2057o0);
                                        continue;
                                    case 76:
                                        this.f2059p0 = obtainStyledAttributes.getInt(index, this.f2059p0);
                                        continue;
                                    case 77:
                                        this.f2061r = c.F(obtainStyledAttributes, index, this.f2061r);
                                        continue;
                                    case 78:
                                        this.f2062s = c.F(obtainStyledAttributes, index, this.f2062s);
                                        continue;
                                    case 79:
                                        this.T = obtainStyledAttributes.getDimensionPixelSize(index, this.T);
                                        continue;
                                    case 80:
                                        this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                                        continue;
                                    case 81:
                                        this.Y = obtainStyledAttributes.getInt(index, this.Y);
                                        continue;
                                    case 82:
                                        this.Z = obtainStyledAttributes.getInt(index, this.Z);
                                        continue;
                                    case 83:
                                        this.f2031b0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f2031b0);
                                        continue;
                                    case 84:
                                        this.f2029a0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f2029a0);
                                        continue;
                                    case 85:
                                        this.f2035d0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f2035d0);
                                        continue;
                                    case 86:
                                        this.f2033c0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f2033c0);
                                        continue;
                                    case 87:
                                        this.f2053m0 = obtainStyledAttributes.getBoolean(index, this.f2053m0);
                                        continue;
                                    case 88:
                                        this.f2055n0 = obtainStyledAttributes.getBoolean(index, this.f2055n0);
                                        continue;
                                    case 89:
                                        this.f2051l0 = obtainStyledAttributes.getString(index);
                                        continue;
                                    case 90:
                                        this.f2042h = obtainStyledAttributes.getBoolean(index, this.f2042h);
                                        continue;
                                    case 91:
                                        sb2 = new StringBuilder();
                                        str = "unused attribute 0x";
                                        break;
                                    default:
                                        sb2 = new StringBuilder();
                                        str = "Unknown attribute 0x";
                                        break;
                                }
                                sb2.append(str);
                                sb2.append(Integer.toHexString(index));
                                sb2.append("   ");
                                sb2.append(f2027q0.get(index));
                                Log.w("ConstraintSet", sb2.toString());
                                break;
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: androidx.constraintlayout.widget.c$c  reason: collision with other inner class name */
    public static class C0017c {

        /* renamed from: o  reason: collision with root package name */
        private static SparseIntArray f2070o;

        /* renamed from: a  reason: collision with root package name */
        public boolean f2071a = false;

        /* renamed from: b  reason: collision with root package name */
        public int f2072b = -1;

        /* renamed from: c  reason: collision with root package name */
        public int f2073c = 0;

        /* renamed from: d  reason: collision with root package name */
        public String f2074d = null;

        /* renamed from: e  reason: collision with root package name */
        public int f2075e = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f2076f = 0;

        /* renamed from: g  reason: collision with root package name */
        public float f2077g = Float.NaN;

        /* renamed from: h  reason: collision with root package name */
        public int f2078h = -1;

        /* renamed from: i  reason: collision with root package name */
        public float f2079i = Float.NaN;

        /* renamed from: j  reason: collision with root package name */
        public float f2080j = Float.NaN;

        /* renamed from: k  reason: collision with root package name */
        public int f2081k = -1;

        /* renamed from: l  reason: collision with root package name */
        public String f2082l = null;

        /* renamed from: m  reason: collision with root package name */
        public int f2083m = -3;

        /* renamed from: n  reason: collision with root package name */
        public int f2084n = -1;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f2070o = sparseIntArray;
            sparseIntArray.append(f.Motion_motionPathRotate, 1);
            f2070o.append(f.Motion_pathMotionArc, 2);
            f2070o.append(f.Motion_transitionEasing, 3);
            f2070o.append(f.Motion_drawPath, 4);
            f2070o.append(f.Motion_animateRelativeTo, 5);
            f2070o.append(f.Motion_animateCircleAngleTo, 6);
            f2070o.append(f.Motion_motionStagger, 7);
            f2070o.append(f.Motion_quantizeMotionSteps, 8);
            f2070o.append(f.Motion_quantizeMotionPhase, 9);
            f2070o.append(f.Motion_quantizeMotionInterpolator, 10);
        }

        public void a(C0017c cVar) {
            this.f2071a = cVar.f2071a;
            this.f2072b = cVar.f2072b;
            this.f2074d = cVar.f2074d;
            this.f2075e = cVar.f2075e;
            this.f2076f = cVar.f2076f;
            this.f2079i = cVar.f2079i;
            this.f2077g = cVar.f2077g;
            this.f2078h = cVar.f2078h;
        }

        /* access modifiers changed from: package-private */
        public void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.Motion);
            this.f2071a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                switch (f2070o.get(index)) {
                    case 1:
                        this.f2079i = obtainStyledAttributes.getFloat(index, this.f2079i);
                        break;
                    case 2:
                        this.f2075e = obtainStyledAttributes.getInt(index, this.f2075e);
                        break;
                    case 3:
                        this.f2074d = obtainStyledAttributes.peekValue(index).type == 3 ? obtainStyledAttributes.getString(index) : f0.c.f13857c[obtainStyledAttributes.getInteger(index, 0)];
                        break;
                    case 4:
                        this.f2076f = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.f2072b = c.F(obtainStyledAttributes, index, this.f2072b);
                        break;
                    case 6:
                        this.f2073c = obtainStyledAttributes.getInteger(index, this.f2073c);
                        break;
                    case 7:
                        this.f2077g = obtainStyledAttributes.getFloat(index, this.f2077g);
                        break;
                    case 8:
                        this.f2081k = obtainStyledAttributes.getInteger(index, this.f2081k);
                        break;
                    case 9:
                        this.f2080j = obtainStyledAttributes.getFloat(index, this.f2080j);
                        break;
                    case 10:
                        int i11 = obtainStyledAttributes.peekValue(index).type;
                        if (i11 != 1) {
                            if (i11 != 3) {
                                this.f2083m = obtainStyledAttributes.getInteger(index, this.f2084n);
                                break;
                            } else {
                                String string = obtainStyledAttributes.getString(index);
                                this.f2082l = string;
                                if (string.indexOf("/") <= 0) {
                                    this.f2083m = -1;
                                    break;
                                } else {
                                    this.f2084n = obtainStyledAttributes.getResourceId(index, -1);
                                }
                            }
                        } else {
                            int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                            this.f2084n = resourceId;
                            if (resourceId == -1) {
                                break;
                            }
                        }
                        this.f2083m = -2;
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public boolean f2085a = false;

        /* renamed from: b  reason: collision with root package name */
        public int f2086b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f2087c = 0;

        /* renamed from: d  reason: collision with root package name */
        public float f2088d = 1.0f;

        /* renamed from: e  reason: collision with root package name */
        public float f2089e = Float.NaN;

        public void a(d dVar) {
            this.f2085a = dVar.f2085a;
            this.f2086b = dVar.f2086b;
            this.f2088d = dVar.f2088d;
            this.f2089e = dVar.f2089e;
            this.f2087c = dVar.f2087c;
        }

        /* access modifiers changed from: package-private */
        public void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.PropertySet);
            this.f2085a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == f.PropertySet_android_alpha) {
                    this.f2088d = obtainStyledAttributes.getFloat(index, this.f2088d);
                } else if (index == f.PropertySet_android_visibility) {
                    this.f2086b = obtainStyledAttributes.getInt(index, this.f2086b);
                    this.f2086b = c.f1998g[this.f2086b];
                } else if (index == f.PropertySet_visibilityMode) {
                    this.f2087c = obtainStyledAttributes.getInt(index, this.f2087c);
                } else if (index == f.PropertySet_motionProgress) {
                    this.f2089e = obtainStyledAttributes.getFloat(index, this.f2089e);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class e {

        /* renamed from: o  reason: collision with root package name */
        private static SparseIntArray f2090o;

        /* renamed from: a  reason: collision with root package name */
        public boolean f2091a = false;

        /* renamed from: b  reason: collision with root package name */
        public float f2092b = 0.0f;

        /* renamed from: c  reason: collision with root package name */
        public float f2093c = 0.0f;

        /* renamed from: d  reason: collision with root package name */
        public float f2094d = 0.0f;

        /* renamed from: e  reason: collision with root package name */
        public float f2095e = 1.0f;

        /* renamed from: f  reason: collision with root package name */
        public float f2096f = 1.0f;

        /* renamed from: g  reason: collision with root package name */
        public float f2097g = Float.NaN;

        /* renamed from: h  reason: collision with root package name */
        public float f2098h = Float.NaN;

        /* renamed from: i  reason: collision with root package name */
        public int f2099i = -1;

        /* renamed from: j  reason: collision with root package name */
        public float f2100j = 0.0f;

        /* renamed from: k  reason: collision with root package name */
        public float f2101k = 0.0f;

        /* renamed from: l  reason: collision with root package name */
        public float f2102l = 0.0f;

        /* renamed from: m  reason: collision with root package name */
        public boolean f2103m = false;

        /* renamed from: n  reason: collision with root package name */
        public float f2104n = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f2090o = sparseIntArray;
            sparseIntArray.append(f.Transform_android_rotation, 1);
            f2090o.append(f.Transform_android_rotationX, 2);
            f2090o.append(f.Transform_android_rotationY, 3);
            f2090o.append(f.Transform_android_scaleX, 4);
            f2090o.append(f.Transform_android_scaleY, 5);
            f2090o.append(f.Transform_android_transformPivotX, 6);
            f2090o.append(f.Transform_android_transformPivotY, 7);
            f2090o.append(f.Transform_android_translationX, 8);
            f2090o.append(f.Transform_android_translationY, 9);
            f2090o.append(f.Transform_android_translationZ, 10);
            f2090o.append(f.Transform_android_elevation, 11);
            f2090o.append(f.Transform_transformPivotTarget, 12);
        }

        public void a(e eVar) {
            this.f2091a = eVar.f2091a;
            this.f2092b = eVar.f2092b;
            this.f2093c = eVar.f2093c;
            this.f2094d = eVar.f2094d;
            this.f2095e = eVar.f2095e;
            this.f2096f = eVar.f2096f;
            this.f2097g = eVar.f2097g;
            this.f2098h = eVar.f2098h;
            this.f2099i = eVar.f2099i;
            this.f2100j = eVar.f2100j;
            this.f2101k = eVar.f2101k;
            this.f2102l = eVar.f2102l;
            this.f2103m = eVar.f2103m;
            this.f2104n = eVar.f2104n;
        }

        /* access modifiers changed from: package-private */
        public void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.Transform);
            this.f2091a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                switch (f2090o.get(index)) {
                    case 1:
                        this.f2092b = obtainStyledAttributes.getFloat(index, this.f2092b);
                        break;
                    case 2:
                        this.f2093c = obtainStyledAttributes.getFloat(index, this.f2093c);
                        break;
                    case 3:
                        this.f2094d = obtainStyledAttributes.getFloat(index, this.f2094d);
                        break;
                    case 4:
                        this.f2095e = obtainStyledAttributes.getFloat(index, this.f2095e);
                        break;
                    case 5:
                        this.f2096f = obtainStyledAttributes.getFloat(index, this.f2096f);
                        break;
                    case 6:
                        this.f2097g = obtainStyledAttributes.getDimension(index, this.f2097g);
                        break;
                    case 7:
                        this.f2098h = obtainStyledAttributes.getDimension(index, this.f2098h);
                        break;
                    case 8:
                        this.f2100j = obtainStyledAttributes.getDimension(index, this.f2100j);
                        break;
                    case 9:
                        this.f2101k = obtainStyledAttributes.getDimension(index, this.f2101k);
                        break;
                    case 10:
                        if (Build.VERSION.SDK_INT < 21) {
                            break;
                        } else {
                            this.f2102l = obtainStyledAttributes.getDimension(index, this.f2102l);
                            break;
                        }
                    case 11:
                        if (Build.VERSION.SDK_INT < 21) {
                            break;
                        } else {
                            this.f2103m = true;
                            this.f2104n = obtainStyledAttributes.getDimension(index, this.f2104n);
                            break;
                        }
                    case 12:
                        this.f2099i = c.F(obtainStyledAttributes, index, this.f2099i);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    static {
        f1999h.append(f.Constraint_layout_constraintLeft_toLeftOf, 25);
        f1999h.append(f.Constraint_layout_constraintLeft_toRightOf, 26);
        f1999h.append(f.Constraint_layout_constraintRight_toLeftOf, 29);
        f1999h.append(f.Constraint_layout_constraintRight_toRightOf, 30);
        f1999h.append(f.Constraint_layout_constraintTop_toTopOf, 36);
        f1999h.append(f.Constraint_layout_constraintTop_toBottomOf, 35);
        f1999h.append(f.Constraint_layout_constraintBottom_toTopOf, 4);
        f1999h.append(f.Constraint_layout_constraintBottom_toBottomOf, 3);
        f1999h.append(f.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        f1999h.append(f.Constraint_layout_constraintBaseline_toTopOf, 91);
        f1999h.append(f.Constraint_layout_constraintBaseline_toBottomOf, 92);
        f1999h.append(f.Constraint_layout_editor_absoluteX, 6);
        f1999h.append(f.Constraint_layout_editor_absoluteY, 7);
        f1999h.append(f.Constraint_layout_constraintGuide_begin, 17);
        f1999h.append(f.Constraint_layout_constraintGuide_end, 18);
        f1999h.append(f.Constraint_layout_constraintGuide_percent, 19);
        f1999h.append(f.Constraint_guidelineUseRtl, 99);
        f1999h.append(f.Constraint_android_orientation, 27);
        f1999h.append(f.Constraint_layout_constraintStart_toEndOf, 32);
        f1999h.append(f.Constraint_layout_constraintStart_toStartOf, 33);
        f1999h.append(f.Constraint_layout_constraintEnd_toStartOf, 10);
        f1999h.append(f.Constraint_layout_constraintEnd_toEndOf, 9);
        f1999h.append(f.Constraint_layout_goneMarginLeft, 13);
        f1999h.append(f.Constraint_layout_goneMarginTop, 16);
        f1999h.append(f.Constraint_layout_goneMarginRight, 14);
        f1999h.append(f.Constraint_layout_goneMarginBottom, 11);
        f1999h.append(f.Constraint_layout_goneMarginStart, 15);
        f1999h.append(f.Constraint_layout_goneMarginEnd, 12);
        f1999h.append(f.Constraint_layout_constraintVertical_weight, 40);
        f1999h.append(f.Constraint_layout_constraintHorizontal_weight, 39);
        f1999h.append(f.Constraint_layout_constraintHorizontal_chainStyle, 41);
        f1999h.append(f.Constraint_layout_constraintVertical_chainStyle, 42);
        f1999h.append(f.Constraint_layout_constraintHorizontal_bias, 20);
        f1999h.append(f.Constraint_layout_constraintVertical_bias, 37);
        f1999h.append(f.Constraint_layout_constraintDimensionRatio, 5);
        f1999h.append(f.Constraint_layout_constraintLeft_creator, 87);
        f1999h.append(f.Constraint_layout_constraintTop_creator, 87);
        f1999h.append(f.Constraint_layout_constraintRight_creator, 87);
        f1999h.append(f.Constraint_layout_constraintBottom_creator, 87);
        f1999h.append(f.Constraint_layout_constraintBaseline_creator, 87);
        f1999h.append(f.Constraint_android_layout_marginLeft, 24);
        f1999h.append(f.Constraint_android_layout_marginRight, 28);
        f1999h.append(f.Constraint_android_layout_marginStart, 31);
        f1999h.append(f.Constraint_android_layout_marginEnd, 8);
        f1999h.append(f.Constraint_android_layout_marginTop, 34);
        f1999h.append(f.Constraint_android_layout_marginBottom, 2);
        f1999h.append(f.Constraint_android_layout_width, 23);
        f1999h.append(f.Constraint_android_layout_height, 21);
        f1999h.append(f.Constraint_layout_constraintWidth, 95);
        f1999h.append(f.Constraint_layout_constraintHeight, 96);
        f1999h.append(f.Constraint_android_visibility, 22);
        f1999h.append(f.Constraint_android_alpha, 43);
        f1999h.append(f.Constraint_android_elevation, 44);
        f1999h.append(f.Constraint_android_rotationX, 45);
        f1999h.append(f.Constraint_android_rotationY, 46);
        f1999h.append(f.Constraint_android_rotation, 60);
        f1999h.append(f.Constraint_android_scaleX, 47);
        f1999h.append(f.Constraint_android_scaleY, 48);
        f1999h.append(f.Constraint_android_transformPivotX, 49);
        f1999h.append(f.Constraint_android_transformPivotY, 50);
        f1999h.append(f.Constraint_android_translationX, 51);
        f1999h.append(f.Constraint_android_translationY, 52);
        f1999h.append(f.Constraint_android_translationZ, 53);
        f1999h.append(f.Constraint_layout_constraintWidth_default, 54);
        f1999h.append(f.Constraint_layout_constraintHeight_default, 55);
        f1999h.append(f.Constraint_layout_constraintWidth_max, 56);
        f1999h.append(f.Constraint_layout_constraintHeight_max, 57);
        f1999h.append(f.Constraint_layout_constraintWidth_min, 58);
        f1999h.append(f.Constraint_layout_constraintHeight_min, 59);
        f1999h.append(f.Constraint_layout_constraintCircle, 61);
        f1999h.append(f.Constraint_layout_constraintCircleRadius, 62);
        f1999h.append(f.Constraint_layout_constraintCircleAngle, 63);
        f1999h.append(f.Constraint_animateRelativeTo, 64);
        f1999h.append(f.Constraint_transitionEasing, 65);
        f1999h.append(f.Constraint_drawPath, 66);
        f1999h.append(f.Constraint_transitionPathRotate, 67);
        f1999h.append(f.Constraint_motionStagger, 79);
        f1999h.append(f.Constraint_android_id, 38);
        f1999h.append(f.Constraint_motionProgress, 68);
        f1999h.append(f.Constraint_layout_constraintWidth_percent, 69);
        f1999h.append(f.Constraint_layout_constraintHeight_percent, 70);
        f1999h.append(f.Constraint_layout_wrapBehaviorInParent, 97);
        f1999h.append(f.Constraint_chainUseRtl, 71);
        f1999h.append(f.Constraint_barrierDirection, 72);
        f1999h.append(f.Constraint_barrierMargin, 73);
        f1999h.append(f.Constraint_constraint_referenced_ids, 74);
        f1999h.append(f.Constraint_barrierAllowsGoneWidgets, 75);
        f1999h.append(f.Constraint_pathMotionArc, 76);
        f1999h.append(f.Constraint_layout_constraintTag, 77);
        f1999h.append(f.Constraint_visibilityMode, 78);
        f1999h.append(f.Constraint_layout_constrainedWidth, 80);
        f1999h.append(f.Constraint_layout_constrainedHeight, 81);
        f1999h.append(f.Constraint_polarRelativeTo, 82);
        f1999h.append(f.Constraint_transformPivotTarget, 83);
        f1999h.append(f.Constraint_quantizeMotionSteps, 84);
        f1999h.append(f.Constraint_quantizeMotionPhase, 85);
        f1999h.append(f.Constraint_quantizeMotionInterpolator, 86);
        SparseIntArray sparseIntArray = f2000i;
        int i10 = f.ConstraintOverride_layout_editor_absoluteY;
        sparseIntArray.append(i10, 6);
        f2000i.append(i10, 7);
        f2000i.append(f.ConstraintOverride_android_orientation, 27);
        f2000i.append(f.ConstraintOverride_layout_goneMarginLeft, 13);
        f2000i.append(f.ConstraintOverride_layout_goneMarginTop, 16);
        f2000i.append(f.ConstraintOverride_layout_goneMarginRight, 14);
        f2000i.append(f.ConstraintOverride_layout_goneMarginBottom, 11);
        f2000i.append(f.ConstraintOverride_layout_goneMarginStart, 15);
        f2000i.append(f.ConstraintOverride_layout_goneMarginEnd, 12);
        f2000i.append(f.ConstraintOverride_layout_constraintVertical_weight, 40);
        f2000i.append(f.ConstraintOverride_layout_constraintHorizontal_weight, 39);
        f2000i.append(f.ConstraintOverride_layout_constraintHorizontal_chainStyle, 41);
        f2000i.append(f.ConstraintOverride_layout_constraintVertical_chainStyle, 42);
        f2000i.append(f.ConstraintOverride_layout_constraintHorizontal_bias, 20);
        f2000i.append(f.ConstraintOverride_layout_constraintVertical_bias, 37);
        f2000i.append(f.ConstraintOverride_layout_constraintDimensionRatio, 5);
        f2000i.append(f.ConstraintOverride_layout_constraintLeft_creator, 87);
        f2000i.append(f.ConstraintOverride_layout_constraintTop_creator, 87);
        f2000i.append(f.ConstraintOverride_layout_constraintRight_creator, 87);
        f2000i.append(f.ConstraintOverride_layout_constraintBottom_creator, 87);
        f2000i.append(f.ConstraintOverride_layout_constraintBaseline_creator, 87);
        f2000i.append(f.ConstraintOverride_android_layout_marginLeft, 24);
        f2000i.append(f.ConstraintOverride_android_layout_marginRight, 28);
        f2000i.append(f.ConstraintOverride_android_layout_marginStart, 31);
        f2000i.append(f.ConstraintOverride_android_layout_marginEnd, 8);
        f2000i.append(f.ConstraintOverride_android_layout_marginTop, 34);
        f2000i.append(f.ConstraintOverride_android_layout_marginBottom, 2);
        f2000i.append(f.ConstraintOverride_android_layout_width, 23);
        f2000i.append(f.ConstraintOverride_android_layout_height, 21);
        f2000i.append(f.ConstraintOverride_layout_constraintWidth, 95);
        f2000i.append(f.ConstraintOverride_layout_constraintHeight, 96);
        f2000i.append(f.ConstraintOverride_android_visibility, 22);
        f2000i.append(f.ConstraintOverride_android_alpha, 43);
        f2000i.append(f.ConstraintOverride_android_elevation, 44);
        f2000i.append(f.ConstraintOverride_android_rotationX, 45);
        f2000i.append(f.ConstraintOverride_android_rotationY, 46);
        f2000i.append(f.ConstraintOverride_android_rotation, 60);
        f2000i.append(f.ConstraintOverride_android_scaleX, 47);
        f2000i.append(f.ConstraintOverride_android_scaleY, 48);
        f2000i.append(f.ConstraintOverride_android_transformPivotX, 49);
        f2000i.append(f.ConstraintOverride_android_transformPivotY, 50);
        f2000i.append(f.ConstraintOverride_android_translationX, 51);
        f2000i.append(f.ConstraintOverride_android_translationY, 52);
        f2000i.append(f.ConstraintOverride_android_translationZ, 53);
        f2000i.append(f.ConstraintOverride_layout_constraintWidth_default, 54);
        f2000i.append(f.ConstraintOverride_layout_constraintHeight_default, 55);
        f2000i.append(f.ConstraintOverride_layout_constraintWidth_max, 56);
        f2000i.append(f.ConstraintOverride_layout_constraintHeight_max, 57);
        f2000i.append(f.ConstraintOverride_layout_constraintWidth_min, 58);
        f2000i.append(f.ConstraintOverride_layout_constraintHeight_min, 59);
        f2000i.append(f.ConstraintOverride_layout_constraintCircleRadius, 62);
        f2000i.append(f.ConstraintOverride_layout_constraintCircleAngle, 63);
        f2000i.append(f.ConstraintOverride_animateRelativeTo, 64);
        f2000i.append(f.ConstraintOverride_transitionEasing, 65);
        f2000i.append(f.ConstraintOverride_drawPath, 66);
        f2000i.append(f.ConstraintOverride_transitionPathRotate, 67);
        f2000i.append(f.ConstraintOverride_motionStagger, 79);
        f2000i.append(f.ConstraintOverride_android_id, 38);
        f2000i.append(f.ConstraintOverride_motionTarget, 98);
        f2000i.append(f.ConstraintOverride_motionProgress, 68);
        f2000i.append(f.ConstraintOverride_layout_constraintWidth_percent, 69);
        f2000i.append(f.ConstraintOverride_layout_constraintHeight_percent, 70);
        f2000i.append(f.ConstraintOverride_chainUseRtl, 71);
        f2000i.append(f.ConstraintOverride_barrierDirection, 72);
        f2000i.append(f.ConstraintOverride_barrierMargin, 73);
        f2000i.append(f.ConstraintOverride_constraint_referenced_ids, 74);
        f2000i.append(f.ConstraintOverride_barrierAllowsGoneWidgets, 75);
        f2000i.append(f.ConstraintOverride_pathMotionArc, 76);
        f2000i.append(f.ConstraintOverride_layout_constraintTag, 77);
        f2000i.append(f.ConstraintOverride_visibilityMode, 78);
        f2000i.append(f.ConstraintOverride_layout_constrainedWidth, 80);
        f2000i.append(f.ConstraintOverride_layout_constrainedHeight, 81);
        f2000i.append(f.ConstraintOverride_polarRelativeTo, 82);
        f2000i.append(f.ConstraintOverride_transformPivotTarget, 83);
        f2000i.append(f.ConstraintOverride_quantizeMotionSteps, 84);
        f2000i.append(f.ConstraintOverride_quantizeMotionPhase, 85);
        f2000i.append(f.ConstraintOverride_quantizeMotionInterpolator, 86);
        f2000i.append(f.ConstraintOverride_layout_wrapBehaviorInParent, 97);
    }

    /* access modifiers changed from: private */
    public static int F(TypedArray typedArray, int i10, int i11) {
        int resourceId = typedArray.getResourceId(i10, i11);
        return resourceId == -1 ? typedArray.getInt(i10, -1) : resourceId;
    }

    static void G(Object obj, TypedArray typedArray, int i10, int i11) {
        int i12;
        if (obj != null) {
            int i13 = typedArray.peekValue(i10).type;
            if (i13 != 3) {
                int i14 = -2;
                boolean z10 = false;
                if (i13 != 5) {
                    int i15 = typedArray.getInt(i10, 0);
                    if (i15 != -4) {
                        i14 = (i15 == -3 || !(i15 == -2 || i15 == -1)) ? 0 : i15;
                    } else {
                        z10 = true;
                    }
                } else {
                    i14 = typedArray.getDimensionPixelSize(i10, 0);
                }
                if (obj instanceof ConstraintLayout.LayoutParams) {
                    ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) obj;
                    if (i11 == 0) {
                        layoutParams.width = i14;
                        layoutParams.W = z10;
                        return;
                    }
                    layoutParams.height = i14;
                    layoutParams.X = z10;
                } else if (obj instanceof b) {
                    b bVar = (b) obj;
                    if (i11 == 0) {
                        bVar.f2032c = i14;
                        bVar.f2053m0 = z10;
                        return;
                    }
                    bVar.f2034d = i14;
                    bVar.f2055n0 = z10;
                } else if (obj instanceof a.C0016a) {
                    a.C0016a aVar = (a.C0016a) obj;
                    if (i11 == 0) {
                        aVar.b(23, i14);
                        i12 = 80;
                    } else {
                        aVar.b(21, i14);
                        i12 = 81;
                    }
                    aVar.d(i12, z10);
                }
            } else {
                H(obj, typedArray.getString(i10), i11);
            }
        }
    }

    static void H(Object obj, String str, int i10) {
        int i11;
        int i12;
        if (str != null) {
            int indexOf = str.indexOf(61);
            int length = str.length();
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                String substring2 = str.substring(indexOf + 1);
                if (substring2.length() > 0) {
                    String trim = substring.trim();
                    String trim2 = substring2.trim();
                    if ("ratio".equalsIgnoreCase(trim)) {
                        if (obj instanceof ConstraintLayout.LayoutParams) {
                            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) obj;
                            if (i10 == 0) {
                                layoutParams.width = 0;
                            } else {
                                layoutParams.height = 0;
                            }
                            I(layoutParams, trim2);
                        } else if (obj instanceof b) {
                            ((b) obj).f2069z = trim2;
                        } else if (obj instanceof a.C0016a) {
                            ((a.C0016a) obj).c(5, trim2);
                        }
                    } else if ("weight".equalsIgnoreCase(trim)) {
                        try {
                            float parseFloat = Float.parseFloat(trim2);
                            if (obj instanceof ConstraintLayout.LayoutParams) {
                                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) obj;
                                if (i10 == 0) {
                                    layoutParams2.width = 0;
                                    layoutParams2.H = parseFloat;
                                    return;
                                }
                                layoutParams2.height = 0;
                                layoutParams2.I = parseFloat;
                            } else if (obj instanceof b) {
                                b bVar = (b) obj;
                                if (i10 == 0) {
                                    bVar.f2032c = 0;
                                    bVar.V = parseFloat;
                                    return;
                                }
                                bVar.f2034d = 0;
                                bVar.U = parseFloat;
                            } else if (obj instanceof a.C0016a) {
                                a.C0016a aVar = (a.C0016a) obj;
                                if (i10 == 0) {
                                    aVar.b(23, 0);
                                    i12 = 39;
                                } else {
                                    aVar.b(21, 0);
                                    i12 = 40;
                                }
                                aVar.a(i12, parseFloat);
                            }
                        } catch (NumberFormatException unused) {
                        }
                    } else if ("parent".equalsIgnoreCase(trim)) {
                        float max = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(trim2)));
                        if (obj instanceof ConstraintLayout.LayoutParams) {
                            ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) obj;
                            if (i10 == 0) {
                                layoutParams3.width = 0;
                                layoutParams3.R = max;
                                layoutParams3.L = 2;
                                return;
                            }
                            layoutParams3.height = 0;
                            layoutParams3.S = max;
                            layoutParams3.M = 2;
                        } else if (obj instanceof b) {
                            b bVar2 = (b) obj;
                            if (i10 == 0) {
                                bVar2.f2032c = 0;
                                bVar2.f2037e0 = max;
                                bVar2.Y = 2;
                                return;
                            }
                            bVar2.f2034d = 0;
                            bVar2.f2039f0 = max;
                            bVar2.Z = 2;
                        } else if (obj instanceof a.C0016a) {
                            a.C0016a aVar2 = (a.C0016a) obj;
                            if (i10 == 0) {
                                aVar2.b(23, 0);
                                i11 = 54;
                            } else {
                                aVar2.b(21, 0);
                                i11 = 55;
                            }
                            aVar2.b(i11, 2);
                        }
                    }
                }
            }
        }
    }

    static void I(ConstraintLayout.LayoutParams layoutParams, String str) {
        if (str != null) {
            int length = str.length();
            int indexOf = str.indexOf(44);
            int i10 = 0;
            int i11 = -1;
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                if (!substring.equalsIgnoreCase("W")) {
                    i10 = substring.equalsIgnoreCase("H") ? 1 : -1;
                }
                i11 = i10;
                i10 = indexOf + 1;
            }
            int indexOf2 = str.indexOf(58);
            if (indexOf2 < 0 || indexOf2 >= length - 1) {
                String substring2 = str.substring(i10);
                if (substring2.length() > 0) {
                    Float.parseFloat(substring2);
                }
            } else {
                String substring3 = str.substring(i10, indexOf2);
                String substring4 = str.substring(indexOf2 + 1);
                if (substring3.length() > 0 && substring4.length() > 0) {
                    try {
                        float parseFloat = Float.parseFloat(substring3);
                        float parseFloat2 = Float.parseFloat(substring4);
                        if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                            if (i11 == 1) {
                                Math.abs(parseFloat2 / parseFloat);
                            } else {
                                Math.abs(parseFloat / parseFloat2);
                            }
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
        layoutParams.G = str;
    }

    private void J(Context context, a aVar, TypedArray typedArray, boolean z10) {
        C0017c cVar;
        String str;
        C0017c cVar2;
        String str2;
        StringBuilder sb2;
        if (z10) {
            K(context, aVar, typedArray);
            return;
        }
        int indexCount = typedArray.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArray.getIndex(i10);
            if (!(index == f.Constraint_android_id || f.Constraint_android_layout_marginStart == index || f.Constraint_android_layout_marginEnd == index)) {
                aVar.f2010d.f2071a = true;
                aVar.f2011e.f2030b = true;
                aVar.f2009c.f2085a = true;
                aVar.f2012f.f2091a = true;
            }
            switch (f1999h.get(index)) {
                case 1:
                    b bVar = aVar.f2011e;
                    bVar.f2060q = F(typedArray, index, bVar.f2060q);
                    continue;
                case 2:
                    b bVar2 = aVar.f2011e;
                    bVar2.J = typedArray.getDimensionPixelSize(index, bVar2.J);
                    continue;
                case 3:
                    b bVar3 = aVar.f2011e;
                    bVar3.f2058p = F(typedArray, index, bVar3.f2058p);
                    continue;
                case 4:
                    b bVar4 = aVar.f2011e;
                    bVar4.f2056o = F(typedArray, index, bVar4.f2056o);
                    continue;
                case 5:
                    aVar.f2011e.f2069z = typedArray.getString(index);
                    continue;
                case 6:
                    b bVar5 = aVar.f2011e;
                    bVar5.D = typedArray.getDimensionPixelOffset(index, bVar5.D);
                    continue;
                case 7:
                    b bVar6 = aVar.f2011e;
                    bVar6.E = typedArray.getDimensionPixelOffset(index, bVar6.E);
                    continue;
                case 8:
                    if (Build.VERSION.SDK_INT >= 17) {
                        b bVar7 = aVar.f2011e;
                        bVar7.K = typedArray.getDimensionPixelSize(index, bVar7.K);
                        break;
                    } else {
                        continue;
                    }
                case 9:
                    b bVar8 = aVar.f2011e;
                    bVar8.f2066w = F(typedArray, index, bVar8.f2066w);
                    continue;
                case 10:
                    b bVar9 = aVar.f2011e;
                    bVar9.f2065v = F(typedArray, index, bVar9.f2065v);
                    continue;
                case 11:
                    b bVar10 = aVar.f2011e;
                    bVar10.Q = typedArray.getDimensionPixelSize(index, bVar10.Q);
                    continue;
                case 12:
                    b bVar11 = aVar.f2011e;
                    bVar11.R = typedArray.getDimensionPixelSize(index, bVar11.R);
                    continue;
                case 13:
                    b bVar12 = aVar.f2011e;
                    bVar12.N = typedArray.getDimensionPixelSize(index, bVar12.N);
                    continue;
                case 14:
                    b bVar13 = aVar.f2011e;
                    bVar13.P = typedArray.getDimensionPixelSize(index, bVar13.P);
                    continue;
                case 15:
                    b bVar14 = aVar.f2011e;
                    bVar14.S = typedArray.getDimensionPixelSize(index, bVar14.S);
                    continue;
                case 16:
                    b bVar15 = aVar.f2011e;
                    bVar15.O = typedArray.getDimensionPixelSize(index, bVar15.O);
                    continue;
                case 17:
                    b bVar16 = aVar.f2011e;
                    bVar16.f2036e = typedArray.getDimensionPixelOffset(index, bVar16.f2036e);
                    continue;
                case 18:
                    b bVar17 = aVar.f2011e;
                    bVar17.f2038f = typedArray.getDimensionPixelOffset(index, bVar17.f2038f);
                    continue;
                case 19:
                    b bVar18 = aVar.f2011e;
                    bVar18.f2040g = typedArray.getFloat(index, bVar18.f2040g);
                    continue;
                case 20:
                    b bVar19 = aVar.f2011e;
                    bVar19.f2067x = typedArray.getFloat(index, bVar19.f2067x);
                    continue;
                case 21:
                    b bVar20 = aVar.f2011e;
                    bVar20.f2034d = typedArray.getLayoutDimension(index, bVar20.f2034d);
                    continue;
                case 22:
                    d dVar = aVar.f2009c;
                    dVar.f2086b = typedArray.getInt(index, dVar.f2086b);
                    d dVar2 = aVar.f2009c;
                    dVar2.f2086b = f1998g[dVar2.f2086b];
                    continue;
                case 23:
                    b bVar21 = aVar.f2011e;
                    bVar21.f2032c = typedArray.getLayoutDimension(index, bVar21.f2032c);
                    continue;
                case 24:
                    b bVar22 = aVar.f2011e;
                    bVar22.G = typedArray.getDimensionPixelSize(index, bVar22.G);
                    continue;
                case 25:
                    b bVar23 = aVar.f2011e;
                    bVar23.f2044i = F(typedArray, index, bVar23.f2044i);
                    continue;
                case 26:
                    b bVar24 = aVar.f2011e;
                    bVar24.f2046j = F(typedArray, index, bVar24.f2046j);
                    continue;
                case 27:
                    b bVar25 = aVar.f2011e;
                    bVar25.F = typedArray.getInt(index, bVar25.F);
                    continue;
                case 28:
                    b bVar26 = aVar.f2011e;
                    bVar26.H = typedArray.getDimensionPixelSize(index, bVar26.H);
                    continue;
                case 29:
                    b bVar27 = aVar.f2011e;
                    bVar27.f2048k = F(typedArray, index, bVar27.f2048k);
                    continue;
                case 30:
                    b bVar28 = aVar.f2011e;
                    bVar28.f2050l = F(typedArray, index, bVar28.f2050l);
                    continue;
                case 31:
                    if (Build.VERSION.SDK_INT >= 17) {
                        b bVar29 = aVar.f2011e;
                        bVar29.L = typedArray.getDimensionPixelSize(index, bVar29.L);
                        break;
                    } else {
                        continue;
                    }
                case 32:
                    b bVar30 = aVar.f2011e;
                    bVar30.f2063t = F(typedArray, index, bVar30.f2063t);
                    continue;
                case 33:
                    b bVar31 = aVar.f2011e;
                    bVar31.f2064u = F(typedArray, index, bVar31.f2064u);
                    continue;
                case 34:
                    b bVar32 = aVar.f2011e;
                    bVar32.I = typedArray.getDimensionPixelSize(index, bVar32.I);
                    continue;
                case 35:
                    b bVar33 = aVar.f2011e;
                    bVar33.f2054n = F(typedArray, index, bVar33.f2054n);
                    continue;
                case 36:
                    b bVar34 = aVar.f2011e;
                    bVar34.f2052m = F(typedArray, index, bVar34.f2052m);
                    continue;
                case 37:
                    b bVar35 = aVar.f2011e;
                    bVar35.f2068y = typedArray.getFloat(index, bVar35.f2068y);
                    continue;
                case 38:
                    aVar.f2007a = typedArray.getResourceId(index, aVar.f2007a);
                    continue;
                case 39:
                    b bVar36 = aVar.f2011e;
                    bVar36.V = typedArray.getFloat(index, bVar36.V);
                    continue;
                case 40:
                    b bVar37 = aVar.f2011e;
                    bVar37.U = typedArray.getFloat(index, bVar37.U);
                    continue;
                case 41:
                    b bVar38 = aVar.f2011e;
                    bVar38.W = typedArray.getInt(index, bVar38.W);
                    continue;
                case 42:
                    b bVar39 = aVar.f2011e;
                    bVar39.X = typedArray.getInt(index, bVar39.X);
                    continue;
                case 43:
                    d dVar3 = aVar.f2009c;
                    dVar3.f2088d = typedArray.getFloat(index, dVar3.f2088d);
                    continue;
                case 44:
                    if (Build.VERSION.SDK_INT >= 21) {
                        e eVar = aVar.f2012f;
                        eVar.f2103m = true;
                        eVar.f2104n = typedArray.getDimension(index, eVar.f2104n);
                        break;
                    } else {
                        continue;
                    }
                case 45:
                    e eVar2 = aVar.f2012f;
                    eVar2.f2093c = typedArray.getFloat(index, eVar2.f2093c);
                    continue;
                case 46:
                    e eVar3 = aVar.f2012f;
                    eVar3.f2094d = typedArray.getFloat(index, eVar3.f2094d);
                    continue;
                case 47:
                    e eVar4 = aVar.f2012f;
                    eVar4.f2095e = typedArray.getFloat(index, eVar4.f2095e);
                    continue;
                case 48:
                    e eVar5 = aVar.f2012f;
                    eVar5.f2096f = typedArray.getFloat(index, eVar5.f2096f);
                    continue;
                case 49:
                    e eVar6 = aVar.f2012f;
                    eVar6.f2097g = typedArray.getDimension(index, eVar6.f2097g);
                    continue;
                case 50:
                    e eVar7 = aVar.f2012f;
                    eVar7.f2098h = typedArray.getDimension(index, eVar7.f2098h);
                    continue;
                case 51:
                    e eVar8 = aVar.f2012f;
                    eVar8.f2100j = typedArray.getDimension(index, eVar8.f2100j);
                    continue;
                case 52:
                    e eVar9 = aVar.f2012f;
                    eVar9.f2101k = typedArray.getDimension(index, eVar9.f2101k);
                    continue;
                case 53:
                    if (Build.VERSION.SDK_INT >= 21) {
                        e eVar10 = aVar.f2012f;
                        eVar10.f2102l = typedArray.getDimension(index, eVar10.f2102l);
                        break;
                    } else {
                        continue;
                    }
                case 54:
                    b bVar40 = aVar.f2011e;
                    bVar40.Y = typedArray.getInt(index, bVar40.Y);
                    continue;
                case 55:
                    b bVar41 = aVar.f2011e;
                    bVar41.Z = typedArray.getInt(index, bVar41.Z);
                    continue;
                case 56:
                    b bVar42 = aVar.f2011e;
                    bVar42.f2029a0 = typedArray.getDimensionPixelSize(index, bVar42.f2029a0);
                    continue;
                case 57:
                    b bVar43 = aVar.f2011e;
                    bVar43.f2031b0 = typedArray.getDimensionPixelSize(index, bVar43.f2031b0);
                    continue;
                case 58:
                    b bVar44 = aVar.f2011e;
                    bVar44.f2033c0 = typedArray.getDimensionPixelSize(index, bVar44.f2033c0);
                    continue;
                case 59:
                    b bVar45 = aVar.f2011e;
                    bVar45.f2035d0 = typedArray.getDimensionPixelSize(index, bVar45.f2035d0);
                    continue;
                case 60:
                    e eVar11 = aVar.f2012f;
                    eVar11.f2092b = typedArray.getFloat(index, eVar11.f2092b);
                    continue;
                case 61:
                    b bVar46 = aVar.f2011e;
                    bVar46.A = F(typedArray, index, bVar46.A);
                    continue;
                case 62:
                    b bVar47 = aVar.f2011e;
                    bVar47.B = typedArray.getDimensionPixelSize(index, bVar47.B);
                    continue;
                case 63:
                    b bVar48 = aVar.f2011e;
                    bVar48.C = typedArray.getFloat(index, bVar48.C);
                    continue;
                case 64:
                    C0017c cVar3 = aVar.f2010d;
                    cVar3.f2072b = F(typedArray, index, cVar3.f2072b);
                    continue;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        cVar = aVar.f2010d;
                        str = typedArray.getString(index);
                    } else {
                        cVar = aVar.f2010d;
                        str = f0.c.f13857c[typedArray.getInteger(index, 0)];
                    }
                    cVar.f2074d = str;
                    continue;
                case 66:
                    aVar.f2010d.f2076f = typedArray.getInt(index, 0);
                    continue;
                case 67:
                    C0017c cVar4 = aVar.f2010d;
                    cVar4.f2079i = typedArray.getFloat(index, cVar4.f2079i);
                    continue;
                case 68:
                    d dVar4 = aVar.f2009c;
                    dVar4.f2089e = typedArray.getFloat(index, dVar4.f2089e);
                    continue;
                case 69:
                    aVar.f2011e.f2037e0 = typedArray.getFloat(index, 1.0f);
                    continue;
                case 70:
                    aVar.f2011e.f2039f0 = typedArray.getFloat(index, 1.0f);
                    continue;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    continue;
                case 72:
                    b bVar49 = aVar.f2011e;
                    bVar49.f2041g0 = typedArray.getInt(index, bVar49.f2041g0);
                    continue;
                case 73:
                    b bVar50 = aVar.f2011e;
                    bVar50.f2043h0 = typedArray.getDimensionPixelSize(index, bVar50.f2043h0);
                    continue;
                case 74:
                    aVar.f2011e.f2049k0 = typedArray.getString(index);
                    continue;
                case 75:
                    b bVar51 = aVar.f2011e;
                    bVar51.f2057o0 = typedArray.getBoolean(index, bVar51.f2057o0);
                    continue;
                case 76:
                    C0017c cVar5 = aVar.f2010d;
                    cVar5.f2075e = typedArray.getInt(index, cVar5.f2075e);
                    continue;
                case 77:
                    aVar.f2011e.f2051l0 = typedArray.getString(index);
                    continue;
                case 78:
                    d dVar5 = aVar.f2009c;
                    dVar5.f2087c = typedArray.getInt(index, dVar5.f2087c);
                    continue;
                case 79:
                    C0017c cVar6 = aVar.f2010d;
                    cVar6.f2077g = typedArray.getFloat(index, cVar6.f2077g);
                    continue;
                case 80:
                    b bVar52 = aVar.f2011e;
                    bVar52.f2053m0 = typedArray.getBoolean(index, bVar52.f2053m0);
                    continue;
                case 81:
                    b bVar53 = aVar.f2011e;
                    bVar53.f2055n0 = typedArray.getBoolean(index, bVar53.f2055n0);
                    continue;
                case 82:
                    C0017c cVar7 = aVar.f2010d;
                    cVar7.f2073c = typedArray.getInteger(index, cVar7.f2073c);
                    continue;
                case 83:
                    e eVar12 = aVar.f2012f;
                    eVar12.f2099i = F(typedArray, index, eVar12.f2099i);
                    continue;
                case 84:
                    C0017c cVar8 = aVar.f2010d;
                    cVar8.f2081k = typedArray.getInteger(index, cVar8.f2081k);
                    continue;
                case 85:
                    C0017c cVar9 = aVar.f2010d;
                    cVar9.f2080j = typedArray.getFloat(index, cVar9.f2080j);
                    continue;
                case 86:
                    int i11 = typedArray.peekValue(index).type;
                    if (i11 != 1) {
                        if (i11 != 3) {
                            C0017c cVar10 = aVar.f2010d;
                            cVar10.f2083m = typedArray.getInteger(index, cVar10.f2084n);
                            break;
                        } else {
                            aVar.f2010d.f2082l = typedArray.getString(index);
                            if (aVar.f2010d.f2082l.indexOf("/") <= 0) {
                                aVar.f2010d.f2083m = -1;
                                break;
                            } else {
                                aVar.f2010d.f2084n = typedArray.getResourceId(index, -1);
                                cVar2 = aVar.f2010d;
                            }
                        }
                    } else {
                        aVar.f2010d.f2084n = typedArray.getResourceId(index, -1);
                        cVar2 = aVar.f2010d;
                        if (cVar2.f2084n == -1) {
                            continue;
                        }
                    }
                    cVar2.f2083m = -2;
                    break;
                case 87:
                    sb2 = new StringBuilder();
                    str2 = "unused attribute 0x";
                    break;
                case 91:
                    b bVar54 = aVar.f2011e;
                    bVar54.f2061r = F(typedArray, index, bVar54.f2061r);
                    continue;
                case 92:
                    b bVar55 = aVar.f2011e;
                    bVar55.f2062s = F(typedArray, index, bVar55.f2062s);
                    continue;
                case 93:
                    b bVar56 = aVar.f2011e;
                    bVar56.M = typedArray.getDimensionPixelSize(index, bVar56.M);
                    continue;
                case 94:
                    b bVar57 = aVar.f2011e;
                    bVar57.T = typedArray.getDimensionPixelSize(index, bVar57.T);
                    continue;
                case 95:
                    G(aVar.f2011e, typedArray, index, 0);
                    continue;
                case 96:
                    G(aVar.f2011e, typedArray, index, 1);
                    continue;
                case 97:
                    b bVar58 = aVar.f2011e;
                    bVar58.f2059p0 = typedArray.getInt(index, bVar58.f2059p0);
                    continue;
                default:
                    sb2 = new StringBuilder();
                    str2 = "Unknown attribute 0x";
                    break;
            }
            sb2.append(str2);
            sb2.append(Integer.toHexString(index));
            sb2.append("   ");
            sb2.append(f1999h.get(index));
            Log.w("ConstraintSet", sb2.toString());
        }
        b bVar59 = aVar.f2011e;
        if (bVar59.f2049k0 != null) {
            bVar59.f2047j0 = null;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x031b, code lost:
        r0.b(r8, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x032d, code lost:
        r3 = r15.getFloat(r3, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0331, code lost:
        r0.a(r4, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0389, code lost:
        r3 = r15.getDimensionPixelOffset(r3, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x038f, code lost:
        r0.c(r4, r15.getString(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x039c, code lost:
        r3 = r15.getDimensionPixelSize(r3, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x03a0, code lost:
        r0.b(r4, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x03a3, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x014a, code lost:
        r3 = r15.getInteger(r3, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0180, code lost:
        r0.d(r4, r15.getBoolean(r3, r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0040, code lost:
        r4.append(r5);
        r4.append(java.lang.Integer.toHexString(r3));
        r4.append("   ");
        r4.append(f1999h.get(r3));
        android.util.Log.w("ConstraintSet", r4.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01e6, code lost:
        r3 = F(r15, r3, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x025a, code lost:
        r3 = r15.getDimension(r3, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x02e9, code lost:
        r3 = r15.getInt(r3, r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void K(android.content.Context r13, androidx.constraintlayout.widget.c.a r14, android.content.res.TypedArray r15) {
        /*
            int r13 = r15.getIndexCount()
            androidx.constraintlayout.widget.c$a$a r0 = new androidx.constraintlayout.widget.c$a$a
            r0.<init>()
            r14.f2014h = r0
            androidx.constraintlayout.widget.c$c r1 = r14.f2010d
            r2 = 0
            r1.f2071a = r2
            androidx.constraintlayout.widget.c$b r1 = r14.f2011e
            r1.f2030b = r2
            androidx.constraintlayout.widget.c$d r1 = r14.f2009c
            r1.f2085a = r2
            androidx.constraintlayout.widget.c$e r1 = r14.f2012f
            r1.f2091a = r2
            r1 = r2
        L_0x001d:
            if (r1 >= r13) goto L_0x03a7
            int r3 = r15.getIndex(r1)
            android.util.SparseIntArray r4 = f2000i
            int r4 = r4.get(r3)
            r5 = 1065353216(0x3f800000, float:1.0)
            java.lang.String r6 = "   "
            r7 = 3
            r8 = 21
            r9 = 17
            java.lang.String r10 = "ConstraintSet"
            r11 = 1
            r12 = -1
            switch(r4) {
                case 2: goto L_0x0397;
                case 3: goto L_0x0039;
                case 4: goto L_0x0039;
                case 5: goto L_0x038e;
                case 6: goto L_0x0384;
                case 7: goto L_0x037e;
                case 8: goto L_0x0373;
                case 9: goto L_0x0039;
                case 10: goto L_0x0039;
                case 11: goto L_0x036c;
                case 12: goto L_0x0365;
                case 13: goto L_0x035e;
                case 14: goto L_0x0357;
                case 15: goto L_0x0350;
                case 16: goto L_0x0349;
                case 17: goto L_0x033d;
                case 18: goto L_0x0336;
                case 19: goto L_0x0327;
                case 20: goto L_0x0320;
                case 21: goto L_0x0313;
                case 22: goto L_0x0303;
                case 23: goto L_0x02f7;
                case 24: goto L_0x02ef;
                case 25: goto L_0x0039;
                case 26: goto L_0x0039;
                case 27: goto L_0x02e3;
                case 28: goto L_0x02db;
                case 29: goto L_0x0039;
                case 30: goto L_0x0039;
                case 31: goto L_0x02cf;
                case 32: goto L_0x0039;
                case 33: goto L_0x0039;
                case 34: goto L_0x02c7;
                case 35: goto L_0x0039;
                case 36: goto L_0x0039;
                case 37: goto L_0x02c0;
                case 38: goto L_0x02b4;
                case 39: goto L_0x02ac;
                case 40: goto L_0x02a4;
                case 41: goto L_0x029d;
                case 42: goto L_0x0296;
                case 43: goto L_0x028e;
                case 44: goto L_0x0280;
                case 45: goto L_0x0278;
                case 46: goto L_0x0270;
                case 47: goto L_0x0268;
                case 48: goto L_0x0260;
                case 49: goto L_0x0254;
                case 50: goto L_0x024d;
                case 51: goto L_0x0246;
                case 52: goto L_0x023f;
                case 53: goto L_0x0234;
                case 54: goto L_0x022c;
                case 55: goto L_0x0224;
                case 56: goto L_0x021c;
                case 57: goto L_0x0214;
                case 58: goto L_0x020c;
                case 59: goto L_0x0204;
                case 60: goto L_0x01fc;
                case 61: goto L_0x0039;
                case 62: goto L_0x01f4;
                case 63: goto L_0x01ec;
                case 64: goto L_0x01e0;
                case 65: goto L_0x01c4;
                case 66: goto L_0x01bc;
                case 67: goto L_0x01b4;
                case 68: goto L_0x01ac;
                case 69: goto L_0x01a8;
                case 70: goto L_0x01a4;
                case 71: goto L_0x019d;
                case 72: goto L_0x0195;
                case 73: goto L_0x018d;
                case 74: goto L_0x0189;
                case 75: goto L_0x017a;
                case 76: goto L_0x0172;
                case 77: goto L_0x016e;
                case 78: goto L_0x0166;
                case 79: goto L_0x015e;
                case 80: goto L_0x0157;
                case 81: goto L_0x0150;
                case 82: goto L_0x0144;
                case 83: goto L_0x013c;
                case 84: goto L_0x0135;
                case 85: goto L_0x012d;
                case 86: goto L_0x00ba;
                case 87: goto L_0x00b2;
                case 88: goto L_0x0039;
                case 89: goto L_0x0039;
                case 90: goto L_0x0039;
                case 91: goto L_0x0039;
                case 92: goto L_0x0039;
                case 93: goto L_0x00aa;
                case 94: goto L_0x00a2;
                case 95: goto L_0x009d;
                case 96: goto L_0x0098;
                case 97: goto L_0x0090;
                case 98: goto L_0x0067;
                case 99: goto L_0x005f;
                default: goto L_0x0039;
            }
        L_0x0039:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Unknown attribute 0x"
        L_0x0040:
            r4.append(r5)
            java.lang.String r5 = java.lang.Integer.toHexString(r3)
            r4.append(r5)
            r4.append(r6)
            android.util.SparseIntArray r5 = f1999h
            int r3 = r5.get(r3)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            android.util.Log.w(r10, r3)
            goto L_0x03a3
        L_0x005f:
            r4 = 99
            androidx.constraintlayout.widget.c$b r5 = r14.f2011e
            boolean r5 = r5.f2042h
            goto L_0x0180
        L_0x0067:
            boolean r4 = androidx.constraintlayout.motion.widget.MotionLayout.O1
            if (r4 == 0) goto L_0x0076
            int r4 = r14.f2007a
            int r4 = r15.getResourceId(r3, r4)
            r14.f2007a = r4
            if (r4 != r12) goto L_0x03a3
            goto L_0x007e
        L_0x0076:
            android.util.TypedValue r4 = r15.peekValue(r3)
            int r4 = r4.type
            if (r4 != r7) goto L_0x0086
        L_0x007e:
            java.lang.String r3 = r15.getString(r3)
            r14.f2008b = r3
            goto L_0x03a3
        L_0x0086:
            int r4 = r14.f2007a
            int r3 = r15.getResourceId(r3, r4)
            r14.f2007a = r3
            goto L_0x03a3
        L_0x0090:
            r4 = 97
            androidx.constraintlayout.widget.c$b r5 = r14.f2011e
            int r5 = r5.f2059p0
            goto L_0x02e9
        L_0x0098:
            G(r0, r15, r3, r11)
            goto L_0x03a3
        L_0x009d:
            G(r0, r15, r3, r2)
            goto L_0x03a3
        L_0x00a2:
            r4 = 94
            androidx.constraintlayout.widget.c$b r5 = r14.f2011e
            int r5 = r5.T
            goto L_0x039c
        L_0x00aa:
            r4 = 93
            androidx.constraintlayout.widget.c$b r5 = r14.f2011e
            int r5 = r5.M
            goto L_0x039c
        L_0x00b2:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "unused attribute 0x"
            goto L_0x0040
        L_0x00ba:
            android.util.TypedValue r4 = r15.peekValue(r3)
            int r4 = r4.type
            r5 = -2
            r6 = 89
            r8 = 88
            if (r4 != r11) goto L_0x00e3
            androidx.constraintlayout.widget.c$c r4 = r14.f2010d
            int r3 = r15.getResourceId(r3, r12)
            r4.f2084n = r3
            androidx.constraintlayout.widget.c$c r3 = r14.f2010d
            int r3 = r3.f2084n
            r0.b(r6, r3)
            androidx.constraintlayout.widget.c$c r3 = r14.f2010d
            int r4 = r3.f2084n
            if (r4 == r12) goto L_0x03a3
        L_0x00dc:
            r3.f2083m = r5
            r0.b(r8, r5)
            goto L_0x03a3
        L_0x00e3:
            if (r4 != r7) goto L_0x011d
            androidx.constraintlayout.widget.c$c r4 = r14.f2010d
            java.lang.String r7 = r15.getString(r3)
            r4.f2082l = r7
            r4 = 90
            androidx.constraintlayout.widget.c$c r7 = r14.f2010d
            java.lang.String r7 = r7.f2082l
            r0.c(r4, r7)
            androidx.constraintlayout.widget.c$c r4 = r14.f2010d
            java.lang.String r4 = r4.f2082l
            java.lang.String r7 = "/"
            int r4 = r4.indexOf(r7)
            if (r4 <= 0) goto L_0x0114
            androidx.constraintlayout.widget.c$c r4 = r14.f2010d
            int r3 = r15.getResourceId(r3, r12)
            r4.f2084n = r3
            androidx.constraintlayout.widget.c$c r3 = r14.f2010d
            int r3 = r3.f2084n
            r0.b(r6, r3)
            androidx.constraintlayout.widget.c$c r3 = r14.f2010d
            goto L_0x00dc
        L_0x0114:
            androidx.constraintlayout.widget.c$c r3 = r14.f2010d
            r3.f2083m = r12
            r0.b(r8, r12)
            goto L_0x03a3
        L_0x011d:
            androidx.constraintlayout.widget.c$c r4 = r14.f2010d
            int r5 = r4.f2084n
            int r3 = r15.getInteger(r3, r5)
            r4.f2083m = r3
            androidx.constraintlayout.widget.c$c r3 = r14.f2010d
            int r3 = r3.f2083m
            goto L_0x031b
        L_0x012d:
            r4 = 85
            androidx.constraintlayout.widget.c$c r5 = r14.f2010d
            float r5 = r5.f2080j
            goto L_0x032d
        L_0x0135:
            r4 = 84
            androidx.constraintlayout.widget.c$c r5 = r14.f2010d
            int r5 = r5.f2081k
            goto L_0x014a
        L_0x013c:
            r4 = 83
            androidx.constraintlayout.widget.c$e r5 = r14.f2012f
            int r5 = r5.f2099i
            goto L_0x01e6
        L_0x0144:
            r4 = 82
            androidx.constraintlayout.widget.c$c r5 = r14.f2010d
            int r5 = r5.f2073c
        L_0x014a:
            int r3 = r15.getInteger(r3, r5)
            goto L_0x03a0
        L_0x0150:
            r4 = 81
            androidx.constraintlayout.widget.c$b r5 = r14.f2011e
            boolean r5 = r5.f2055n0
            goto L_0x0180
        L_0x0157:
            r4 = 80
            androidx.constraintlayout.widget.c$b r5 = r14.f2011e
            boolean r5 = r5.f2053m0
            goto L_0x0180
        L_0x015e:
            r4 = 79
            androidx.constraintlayout.widget.c$c r5 = r14.f2010d
            float r5 = r5.f2077g
            goto L_0x032d
        L_0x0166:
            r4 = 78
            androidx.constraintlayout.widget.c$d r5 = r14.f2009c
            int r5 = r5.f2087c
            goto L_0x02e9
        L_0x016e:
            r4 = 77
            goto L_0x038f
        L_0x0172:
            r4 = 76
            androidx.constraintlayout.widget.c$c r5 = r14.f2010d
            int r5 = r5.f2075e
            goto L_0x02e9
        L_0x017a:
            r4 = 75
            androidx.constraintlayout.widget.c$b r5 = r14.f2011e
            boolean r5 = r5.f2057o0
        L_0x0180:
            boolean r3 = r15.getBoolean(r3, r5)
            r0.d(r4, r3)
            goto L_0x03a3
        L_0x0189:
            r4 = 74
            goto L_0x038f
        L_0x018d:
            r4 = 73
            androidx.constraintlayout.widget.c$b r5 = r14.f2011e
            int r5 = r5.f2043h0
            goto L_0x039c
        L_0x0195:
            r4 = 72
            androidx.constraintlayout.widget.c$b r5 = r14.f2011e
            int r5 = r5.f2041g0
            goto L_0x02e9
        L_0x019d:
            java.lang.String r3 = "CURRENTLY UNSUPPORTED"
            android.util.Log.e(r10, r3)
            goto L_0x03a3
        L_0x01a4:
            r4 = 70
            goto L_0x032d
        L_0x01a8:
            r4 = 69
            goto L_0x032d
        L_0x01ac:
            r4 = 68
            androidx.constraintlayout.widget.c$d r5 = r14.f2009c
            float r5 = r5.f2089e
            goto L_0x032d
        L_0x01b4:
            r4 = 67
            androidx.constraintlayout.widget.c$c r5 = r14.f2010d
            float r5 = r5.f2079i
            goto L_0x032d
        L_0x01bc:
            r4 = 66
            int r3 = r15.getInt(r3, r2)
            goto L_0x03a0
        L_0x01c4:
            android.util.TypedValue r4 = r15.peekValue(r3)
            int r4 = r4.type
            r5 = 65
            if (r4 != r7) goto L_0x01d3
            java.lang.String r3 = r15.getString(r3)
            goto L_0x01db
        L_0x01d3:
            java.lang.String[] r4 = f0.c.f13857c
            int r3 = r15.getInteger(r3, r2)
            r3 = r4[r3]
        L_0x01db:
            r0.c(r5, r3)
            goto L_0x03a3
        L_0x01e0:
            r4 = 64
            androidx.constraintlayout.widget.c$c r5 = r14.f2010d
            int r5 = r5.f2072b
        L_0x01e6:
            int r3 = F(r15, r3, r5)
            goto L_0x03a0
        L_0x01ec:
            r4 = 63
            androidx.constraintlayout.widget.c$b r5 = r14.f2011e
            float r5 = r5.C
            goto L_0x032d
        L_0x01f4:
            r4 = 62
            androidx.constraintlayout.widget.c$b r5 = r14.f2011e
            int r5 = r5.B
            goto L_0x039c
        L_0x01fc:
            r4 = 60
            androidx.constraintlayout.widget.c$e r5 = r14.f2012f
            float r5 = r5.f2092b
            goto L_0x032d
        L_0x0204:
            r4 = 59
            androidx.constraintlayout.widget.c$b r5 = r14.f2011e
            int r5 = r5.f2035d0
            goto L_0x039c
        L_0x020c:
            r4 = 58
            androidx.constraintlayout.widget.c$b r5 = r14.f2011e
            int r5 = r5.f2033c0
            goto L_0x039c
        L_0x0214:
            r4 = 57
            androidx.constraintlayout.widget.c$b r5 = r14.f2011e
            int r5 = r5.f2031b0
            goto L_0x039c
        L_0x021c:
            r4 = 56
            androidx.constraintlayout.widget.c$b r5 = r14.f2011e
            int r5 = r5.f2029a0
            goto L_0x039c
        L_0x0224:
            r4 = 55
            androidx.constraintlayout.widget.c$b r5 = r14.f2011e
            int r5 = r5.Z
            goto L_0x02e9
        L_0x022c:
            r4 = 54
            androidx.constraintlayout.widget.c$b r5 = r14.f2011e
            int r5 = r5.Y
            goto L_0x02e9
        L_0x0234:
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r8) goto L_0x03a3
            r4 = 53
            androidx.constraintlayout.widget.c$e r5 = r14.f2012f
            float r5 = r5.f2102l
            goto L_0x025a
        L_0x023f:
            r4 = 52
            androidx.constraintlayout.widget.c$e r5 = r14.f2012f
            float r5 = r5.f2101k
            goto L_0x025a
        L_0x0246:
            r4 = 51
            androidx.constraintlayout.widget.c$e r5 = r14.f2012f
            float r5 = r5.f2100j
            goto L_0x025a
        L_0x024d:
            r4 = 50
            androidx.constraintlayout.widget.c$e r5 = r14.f2012f
            float r5 = r5.f2098h
            goto L_0x025a
        L_0x0254:
            r4 = 49
            androidx.constraintlayout.widget.c$e r5 = r14.f2012f
            float r5 = r5.f2097g
        L_0x025a:
            float r3 = r15.getDimension(r3, r5)
            goto L_0x0331
        L_0x0260:
            r4 = 48
            androidx.constraintlayout.widget.c$e r5 = r14.f2012f
            float r5 = r5.f2096f
            goto L_0x032d
        L_0x0268:
            r4 = 47
            androidx.constraintlayout.widget.c$e r5 = r14.f2012f
            float r5 = r5.f2095e
            goto L_0x032d
        L_0x0270:
            r4 = 46
            androidx.constraintlayout.widget.c$e r5 = r14.f2012f
            float r5 = r5.f2094d
            goto L_0x032d
        L_0x0278:
            r4 = 45
            androidx.constraintlayout.widget.c$e r5 = r14.f2012f
            float r5 = r5.f2093c
            goto L_0x032d
        L_0x0280:
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r8) goto L_0x03a3
            r4 = 44
            r0.d(r4, r11)
            androidx.constraintlayout.widget.c$e r5 = r14.f2012f
            float r5 = r5.f2104n
            goto L_0x025a
        L_0x028e:
            r4 = 43
            androidx.constraintlayout.widget.c$d r5 = r14.f2009c
            float r5 = r5.f2088d
            goto L_0x032d
        L_0x0296:
            r4 = 42
            androidx.constraintlayout.widget.c$b r5 = r14.f2011e
            int r5 = r5.X
            goto L_0x02e9
        L_0x029d:
            r4 = 41
            androidx.constraintlayout.widget.c$b r5 = r14.f2011e
            int r5 = r5.W
            goto L_0x02e9
        L_0x02a4:
            r4 = 40
            androidx.constraintlayout.widget.c$b r5 = r14.f2011e
            float r5 = r5.U
            goto L_0x032d
        L_0x02ac:
            r4 = 39
            androidx.constraintlayout.widget.c$b r5 = r14.f2011e
            float r5 = r5.V
            goto L_0x032d
        L_0x02b4:
            int r4 = r14.f2007a
            int r3 = r15.getResourceId(r3, r4)
            r14.f2007a = r3
            r4 = 38
            goto L_0x03a0
        L_0x02c0:
            r4 = 37
            androidx.constraintlayout.widget.c$b r5 = r14.f2011e
            float r5 = r5.f2068y
            goto L_0x032d
        L_0x02c7:
            r4 = 34
            androidx.constraintlayout.widget.c$b r5 = r14.f2011e
            int r5 = r5.I
            goto L_0x039c
        L_0x02cf:
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r9) goto L_0x03a3
            r4 = 31
            androidx.constraintlayout.widget.c$b r5 = r14.f2011e
            int r5 = r5.L
            goto L_0x039c
        L_0x02db:
            r4 = 28
            androidx.constraintlayout.widget.c$b r5 = r14.f2011e
            int r5 = r5.H
            goto L_0x039c
        L_0x02e3:
            r4 = 27
            androidx.constraintlayout.widget.c$b r5 = r14.f2011e
            int r5 = r5.F
        L_0x02e9:
            int r3 = r15.getInt(r3, r5)
            goto L_0x03a0
        L_0x02ef:
            r4 = 24
            androidx.constraintlayout.widget.c$b r5 = r14.f2011e
            int r5 = r5.G
            goto L_0x039c
        L_0x02f7:
            r4 = 23
            androidx.constraintlayout.widget.c$b r5 = r14.f2011e
            int r5 = r5.f2032c
            int r3 = r15.getLayoutDimension(r3, r5)
            goto L_0x03a0
        L_0x0303:
            r4 = 22
            int[] r5 = f1998g
            androidx.constraintlayout.widget.c$d r6 = r14.f2009c
            int r6 = r6.f2086b
            int r3 = r15.getInt(r3, r6)
            r3 = r5[r3]
            goto L_0x03a0
        L_0x0313:
            androidx.constraintlayout.widget.c$b r4 = r14.f2011e
            int r4 = r4.f2034d
            int r3 = r15.getLayoutDimension(r3, r4)
        L_0x031b:
            r0.b(r8, r3)
            goto L_0x03a3
        L_0x0320:
            r4 = 20
            androidx.constraintlayout.widget.c$b r5 = r14.f2011e
            float r5 = r5.f2067x
            goto L_0x032d
        L_0x0327:
            r4 = 19
            androidx.constraintlayout.widget.c$b r5 = r14.f2011e
            float r5 = r5.f2040g
        L_0x032d:
            float r3 = r15.getFloat(r3, r5)
        L_0x0331:
            r0.a(r4, r3)
            goto L_0x03a3
        L_0x0336:
            r4 = 18
            androidx.constraintlayout.widget.c$b r5 = r14.f2011e
            int r5 = r5.f2038f
            goto L_0x0389
        L_0x033d:
            androidx.constraintlayout.widget.c$b r4 = r14.f2011e
            int r4 = r4.f2036e
            int r3 = r15.getDimensionPixelOffset(r3, r4)
            r0.b(r9, r3)
            goto L_0x03a3
        L_0x0349:
            r4 = 16
            androidx.constraintlayout.widget.c$b r5 = r14.f2011e
            int r5 = r5.O
            goto L_0x039c
        L_0x0350:
            r4 = 15
            androidx.constraintlayout.widget.c$b r5 = r14.f2011e
            int r5 = r5.S
            goto L_0x039c
        L_0x0357:
            r4 = 14
            androidx.constraintlayout.widget.c$b r5 = r14.f2011e
            int r5 = r5.P
            goto L_0x039c
        L_0x035e:
            r4 = 13
            androidx.constraintlayout.widget.c$b r5 = r14.f2011e
            int r5 = r5.N
            goto L_0x039c
        L_0x0365:
            r4 = 12
            androidx.constraintlayout.widget.c$b r5 = r14.f2011e
            int r5 = r5.R
            goto L_0x039c
        L_0x036c:
            r4 = 11
            androidx.constraintlayout.widget.c$b r5 = r14.f2011e
            int r5 = r5.Q
            goto L_0x039c
        L_0x0373:
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r9) goto L_0x03a3
            r4 = 8
            androidx.constraintlayout.widget.c$b r5 = r14.f2011e
            int r5 = r5.K
            goto L_0x039c
        L_0x037e:
            r4 = 7
            androidx.constraintlayout.widget.c$b r5 = r14.f2011e
            int r5 = r5.E
            goto L_0x0389
        L_0x0384:
            r4 = 6
            androidx.constraintlayout.widget.c$b r5 = r14.f2011e
            int r5 = r5.D
        L_0x0389:
            int r3 = r15.getDimensionPixelOffset(r3, r5)
            goto L_0x03a0
        L_0x038e:
            r4 = 5
        L_0x038f:
            java.lang.String r3 = r15.getString(r3)
            r0.c(r4, r3)
            goto L_0x03a3
        L_0x0397:
            r4 = 2
            androidx.constraintlayout.widget.c$b r5 = r14.f2011e
            int r5 = r5.J
        L_0x039c:
            int r3 = r15.getDimensionPixelSize(r3, r5)
        L_0x03a0:
            r0.b(r4, r3)
        L_0x03a3:
            int r1 = r1 + 1
            goto L_0x001d
        L_0x03a7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.c.K(android.content.Context, androidx.constraintlayout.widget.c$a, android.content.res.TypedArray):void");
    }

    /* access modifiers changed from: private */
    public static void N(a aVar, int i10, float f10) {
        if (i10 == 19) {
            aVar.f2011e.f2040g = f10;
        } else if (i10 == 20) {
            aVar.f2011e.f2067x = f10;
        } else if (i10 == 37) {
            aVar.f2011e.f2068y = f10;
        } else if (i10 == 60) {
            aVar.f2012f.f2092b = f10;
        } else if (i10 == 63) {
            aVar.f2011e.C = f10;
        } else if (i10 == 79) {
            aVar.f2010d.f2077g = f10;
        } else if (i10 == 85) {
            aVar.f2010d.f2080j = f10;
        } else if (i10 == 87) {
        } else {
            if (i10 == 39) {
                aVar.f2011e.V = f10;
            } else if (i10 != 40) {
                switch (i10) {
                    case 43:
                        aVar.f2009c.f2088d = f10;
                        return;
                    case 44:
                        e eVar = aVar.f2012f;
                        eVar.f2104n = f10;
                        eVar.f2103m = true;
                        return;
                    case 45:
                        aVar.f2012f.f2093c = f10;
                        return;
                    case 46:
                        aVar.f2012f.f2094d = f10;
                        return;
                    case 47:
                        aVar.f2012f.f2095e = f10;
                        return;
                    case 48:
                        aVar.f2012f.f2096f = f10;
                        return;
                    case 49:
                        aVar.f2012f.f2097g = f10;
                        return;
                    case 50:
                        aVar.f2012f.f2098h = f10;
                        return;
                    case 51:
                        aVar.f2012f.f2100j = f10;
                        return;
                    case 52:
                        aVar.f2012f.f2101k = f10;
                        return;
                    case 53:
                        aVar.f2012f.f2102l = f10;
                        return;
                    default:
                        switch (i10) {
                            case 67:
                                aVar.f2010d.f2079i = f10;
                                return;
                            case 68:
                                aVar.f2009c.f2089e = f10;
                                return;
                            case 69:
                                aVar.f2011e.f2037e0 = f10;
                                return;
                            case 70:
                                aVar.f2011e.f2039f0 = f10;
                                return;
                            default:
                                Log.w("ConstraintSet", "Unknown attribute 0x");
                                return;
                        }
                }
            } else {
                aVar.f2011e.U = f10;
            }
        }
    }

    /* access modifiers changed from: private */
    public static void O(a aVar, int i10, int i11) {
        if (i10 == 6) {
            aVar.f2011e.D = i11;
        } else if (i10 == 7) {
            aVar.f2011e.E = i11;
        } else if (i10 == 8) {
            aVar.f2011e.K = i11;
        } else if (i10 == 27) {
            aVar.f2011e.F = i11;
        } else if (i10 == 28) {
            aVar.f2011e.H = i11;
        } else if (i10 == 41) {
            aVar.f2011e.W = i11;
        } else if (i10 == 42) {
            aVar.f2011e.X = i11;
        } else if (i10 == 61) {
            aVar.f2011e.A = i11;
        } else if (i10 == 62) {
            aVar.f2011e.B = i11;
        } else if (i10 == 72) {
            aVar.f2011e.f2041g0 = i11;
        } else if (i10 != 73) {
            switch (i10) {
                case 2:
                    aVar.f2011e.J = i11;
                    return;
                case 11:
                    aVar.f2011e.Q = i11;
                    return;
                case 12:
                    aVar.f2011e.R = i11;
                    return;
                case 13:
                    aVar.f2011e.N = i11;
                    return;
                case 14:
                    aVar.f2011e.P = i11;
                    return;
                case 15:
                    aVar.f2011e.S = i11;
                    return;
                case 16:
                    aVar.f2011e.O = i11;
                    return;
                case 17:
                    aVar.f2011e.f2036e = i11;
                    return;
                case 18:
                    aVar.f2011e.f2038f = i11;
                    return;
                case 31:
                    aVar.f2011e.L = i11;
                    return;
                case 34:
                    aVar.f2011e.I = i11;
                    return;
                case 38:
                    aVar.f2007a = i11;
                    return;
                case 64:
                    aVar.f2010d.f2072b = i11;
                    return;
                case 66:
                    aVar.f2010d.f2076f = i11;
                    return;
                case 76:
                    aVar.f2010d.f2075e = i11;
                    return;
                case 78:
                    aVar.f2009c.f2087c = i11;
                    return;
                case 93:
                    aVar.f2011e.M = i11;
                    return;
                case 94:
                    aVar.f2011e.T = i11;
                    return;
                case 97:
                    aVar.f2011e.f2059p0 = i11;
                    return;
                default:
                    switch (i10) {
                        case 21:
                            aVar.f2011e.f2034d = i11;
                            return;
                        case 22:
                            aVar.f2009c.f2086b = i11;
                            return;
                        case 23:
                            aVar.f2011e.f2032c = i11;
                            return;
                        case 24:
                            aVar.f2011e.G = i11;
                            return;
                        default:
                            switch (i10) {
                                case 54:
                                    aVar.f2011e.Y = i11;
                                    return;
                                case 55:
                                    aVar.f2011e.Z = i11;
                                    return;
                                case 56:
                                    aVar.f2011e.f2029a0 = i11;
                                    return;
                                case 57:
                                    aVar.f2011e.f2031b0 = i11;
                                    return;
                                case 58:
                                    aVar.f2011e.f2033c0 = i11;
                                    return;
                                case 59:
                                    aVar.f2011e.f2035d0 = i11;
                                    return;
                                default:
                                    switch (i10) {
                                        case 82:
                                            aVar.f2010d.f2073c = i11;
                                            return;
                                        case 83:
                                            aVar.f2012f.f2099i = i11;
                                            return;
                                        case 84:
                                            aVar.f2010d.f2081k = i11;
                                            return;
                                        default:
                                            switch (i10) {
                                                case 87:
                                                    return;
                                                case 88:
                                                    aVar.f2010d.f2083m = i11;
                                                    return;
                                                case 89:
                                                    aVar.f2010d.f2084n = i11;
                                                    return;
                                                default:
                                                    Log.w("ConstraintSet", "Unknown attribute 0x");
                                                    return;
                                            }
                                    }
                            }
                    }
            }
        } else {
            aVar.f2011e.f2043h0 = i11;
        }
    }

    /* access modifiers changed from: private */
    public static void P(a aVar, int i10, String str) {
        if (i10 == 5) {
            aVar.f2011e.f2069z = str;
        } else if (i10 == 65) {
            aVar.f2010d.f2074d = str;
        } else if (i10 == 74) {
            b bVar = aVar.f2011e;
            bVar.f2049k0 = str;
            bVar.f2047j0 = null;
        } else if (i10 == 77) {
            aVar.f2011e.f2051l0 = str;
        } else if (i10 == 87) {
        } else {
            if (i10 != 90) {
                Log.w("ConstraintSet", "Unknown attribute 0x");
            } else {
                aVar.f2010d.f2082l = str;
            }
        }
    }

    /* access modifiers changed from: private */
    public static void Q(a aVar, int i10, boolean z10) {
        if (i10 == 44) {
            aVar.f2012f.f2103m = z10;
        } else if (i10 == 75) {
            aVar.f2011e.f2057o0 = z10;
        } else if (i10 == 87) {
        } else {
            if (i10 == 80) {
                aVar.f2011e.f2053m0 = z10;
            } else if (i10 != 81) {
                Log.w("ConstraintSet", "Unknown attribute 0x");
            } else {
                aVar.f2011e.f2055n0 = z10;
            }
        }
    }

    public static a m(Context context, XmlPullParser xmlPullParser) {
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        a aVar = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(asAttributeSet, f.ConstraintOverride);
        K(context, aVar, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return aVar;
    }

    private int[] t(View view, String str) {
        int i10;
        Object h10;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i11 = 0;
        int i12 = 0;
        while (i11 < split.length) {
            String trim = split[i11].trim();
            try {
                i10 = e.class.getField(trim).getInt((Object) null);
            } catch (Exception unused) {
                i10 = 0;
            }
            if (i10 == 0) {
                i10 = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i10 == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (h10 = ((ConstraintLayout) view.getParent()).h(0, trim)) != null && (h10 instanceof Integer)) {
                i10 = ((Integer) h10).intValue();
            }
            iArr[i12] = i10;
            i11++;
            i12++;
        }
        return i12 != split.length ? Arrays.copyOf(iArr, i12) : iArr;
    }

    private a u(Context context, AttributeSet attributeSet, boolean z10) {
        a aVar = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z10 ? f.ConstraintOverride : f.Constraint);
        J(context, aVar, obtainStyledAttributes, z10);
        obtainStyledAttributes.recycle();
        return aVar;
    }

    private a v(int i10) {
        if (!this.f2006f.containsKey(Integer.valueOf(i10))) {
            this.f2006f.put(Integer.valueOf(i10), new a());
        }
        return this.f2006f.get(Integer.valueOf(i10));
    }

    public int A(int i10) {
        return v(i10).f2009c.f2086b;
    }

    public int B(int i10) {
        return v(i10).f2009c.f2087c;
    }

    public int C(int i10) {
        return v(i10).f2011e.f2032c;
    }

    public void D(Context context, int i10) {
        XmlResourceParser xml = context.getResources().getXml(i10);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    a u10 = u(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        u10.f2011e.f2028a = true;
                    }
                    this.f2006f.put(Integer.valueOf(u10.f2007a), u10);
                }
            }
        } catch (XmlPullParserException e10) {
            e10.printStackTrace();
        } catch (IOException e11) {
            e11.printStackTrace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:115:0x01cb, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void E(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11) {
        /*
            r9 = this;
            int r0 = r11.getEventType()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1 = 0
            r2 = r1
        L_0x0006:
            r3 = 1
            if (r0 == r3) goto L_0x01da
            if (r0 == 0) goto L_0x01c8
            r4 = -1
            r5 = 3
            r6 = 2
            r7 = 0
            if (r0 == r6) goto L_0x0067
            if (r0 == r5) goto L_0x0015
            goto L_0x01cb
        L_0x0015:
            java.lang.String r0 = r11.getName()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.util.Locale r8 = java.util.Locale.ROOT     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.String r0 = r0.toLowerCase(r8)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            int r8 = r0.hashCode()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            switch(r8) {
                case -2075718416: goto L_0x0045;
                case -190376483: goto L_0x003b;
                case 426575017: goto L_0x0031;
                case 2146106725: goto L_0x0027;
                default: goto L_0x0026;
            }     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x0026:
            goto L_0x004e
        L_0x0027:
            java.lang.String r8 = "constraintset"
            boolean r0 = r0.equals(r8)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x004e
            r4 = r7
            goto L_0x004e
        L_0x0031:
            java.lang.String r7 = "constraintoverride"
            boolean r0 = r0.equals(r7)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x004e
            r4 = r6
            goto L_0x004e
        L_0x003b:
            java.lang.String r7 = "constraint"
            boolean r0 = r0.equals(r7)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x004e
            r4 = r3
            goto L_0x004e
        L_0x0045:
            java.lang.String r7 = "guideline"
            boolean r0 = r0.equals(r7)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x004e
            r4 = r5
        L_0x004e:
            if (r4 == 0) goto L_0x0066
            if (r4 == r3) goto L_0x0058
            if (r4 == r6) goto L_0x0058
            if (r4 == r5) goto L_0x0058
            goto L_0x01cb
        L_0x0058:
            java.util.HashMap<java.lang.Integer, androidx.constraintlayout.widget.c$a> r0 = r9.f2006f     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            int r3 = r2.f2007a     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r0.put(r3, r2)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r2 = r1
            goto L_0x01cb
        L_0x0066:
            return
        L_0x0067:
            java.lang.String r0 = r11.getName()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            int r8 = r0.hashCode()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            switch(r8) {
                case -2025855158: goto L_0x00d0;
                case -1984451626: goto L_0x00c6;
                case -1962203927: goto L_0x00bc;
                case -1269513683: goto L_0x00b2;
                case -1238332596: goto L_0x00a8;
                case -71750448: goto L_0x009e;
                case 366511058: goto L_0x0093;
                case 1331510167: goto L_0x0089;
                case 1791837707: goto L_0x007e;
                case 1803088381: goto L_0x0074;
                default: goto L_0x0072;
            }     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x0072:
            goto L_0x00d9
        L_0x0074:
            java.lang.String r5 = "Constraint"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = r7
            goto L_0x00d9
        L_0x007e:
            java.lang.String r5 = "CustomAttribute"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = 8
            goto L_0x00d9
        L_0x0089:
            java.lang.String r6 = "Barrier"
            boolean r0 = r0.equals(r6)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = r5
            goto L_0x00d9
        L_0x0093:
            java.lang.String r5 = "CustomMethod"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = 9
            goto L_0x00d9
        L_0x009e:
            java.lang.String r5 = "Guideline"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = r6
            goto L_0x00d9
        L_0x00a8:
            java.lang.String r5 = "Transform"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = 5
            goto L_0x00d9
        L_0x00b2:
            java.lang.String r5 = "PropertySet"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = 4
            goto L_0x00d9
        L_0x00bc:
            java.lang.String r5 = "ConstraintOverride"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = r3
            goto L_0x00d9
        L_0x00c6:
            java.lang.String r5 = "Motion"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = 7
            goto L_0x00d9
        L_0x00d0:
            java.lang.String r5 = "Layout"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = 6
        L_0x00d9:
            java.lang.String r0 = "XML parser error must be within a Constraint "
            switch(r4) {
                case 0: goto L_0x01be;
                case 1: goto L_0x01b5;
                case 2: goto L_0x01a6;
                case 3: goto L_0x0199;
                case 4: goto L_0x0174;
                case 5: goto L_0x014e;
                case 6: goto L_0x0128;
                case 7: goto L_0x0102;
                case 8: goto L_0x00e0;
                case 9: goto L_0x00e0;
                default: goto L_0x00de;
            }
        L_0x00de:
            goto L_0x01cb
        L_0x00e0:
            if (r2 == 0) goto L_0x00e9
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.a> r0 = r2.f2013g     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            androidx.constraintlayout.widget.a.i(r10, r11, r0)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x01cb
        L_0x00e9:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r0)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.String r11 = r1.toString()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            throw r10     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x0102:
            if (r2 == 0) goto L_0x010f
            androidx.constraintlayout.widget.c$c r0 = r2.f2010d     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r0.b(r10, r3)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x01cb
        L_0x010f:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r0)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.String r11 = r1.toString()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            throw r10     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x0128:
            if (r2 == 0) goto L_0x0135
            androidx.constraintlayout.widget.c$b r0 = r2.f2011e     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r0.b(r10, r3)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x01cb
        L_0x0135:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r0)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.String r11 = r1.toString()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            throw r10     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x014e:
            if (r2 == 0) goto L_0x015b
            androidx.constraintlayout.widget.c$e r0 = r2.f2012f     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r0.b(r10, r3)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x01cb
        L_0x015b:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r0)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.String r11 = r1.toString()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            throw r10     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x0174:
            if (r2 == 0) goto L_0x0180
            androidx.constraintlayout.widget.c$d r0 = r2.f2009c     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r0.b(r10, r3)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x01cb
        L_0x0180:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r0)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.String r11 = r1.toString()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            throw r10     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x0199:
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            androidx.constraintlayout.widget.c$a r0 = r9.u(r10, r0, r7)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            androidx.constraintlayout.widget.c$b r2 = r0.f2011e     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r2.f2045i0 = r3     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x01c6
        L_0x01a6:
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            androidx.constraintlayout.widget.c$a r0 = r9.u(r10, r0, r7)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            androidx.constraintlayout.widget.c$b r2 = r0.f2011e     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r2.f2028a = r3     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r2.f2030b = r3     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x01c6
        L_0x01b5:
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            androidx.constraintlayout.widget.c$a r0 = r9.u(r10, r0, r3)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x01c6
        L_0x01be:
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            androidx.constraintlayout.widget.c$a r0 = r9.u(r10, r0, r7)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x01c6:
            r2 = r0
            goto L_0x01cb
        L_0x01c8:
            r11.getName()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x01cb:
            int r0 = r11.next()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x0006
        L_0x01d1:
            r10 = move-exception
            r10.printStackTrace()
            goto L_0x01da
        L_0x01d6:
            r10 = move-exception
            r10.printStackTrace()
        L_0x01da:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.c.E(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public void L(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        int i10 = 0;
        while (i10 < childCount) {
            View childAt = constraintLayout.getChildAt(i10);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (!this.f2005e || id2 != -1) {
                if (!this.f2006f.containsKey(Integer.valueOf(id2))) {
                    this.f2006f.put(Integer.valueOf(id2), new a());
                }
                a aVar = this.f2006f.get(Integer.valueOf(id2));
                if (aVar != null) {
                    if (!aVar.f2011e.f2030b) {
                        aVar.g(id2, layoutParams);
                        if (childAt instanceof ConstraintHelper) {
                            aVar.f2011e.f2047j0 = ((ConstraintHelper) childAt).getReferencedIds();
                            if (childAt instanceof Barrier) {
                                Barrier barrier = (Barrier) childAt;
                                aVar.f2011e.f2057o0 = barrier.getAllowsGoneWidget();
                                aVar.f2011e.f2041g0 = barrier.getType();
                                aVar.f2011e.f2043h0 = barrier.getMargin();
                            }
                        }
                        aVar.f2011e.f2030b = true;
                    }
                    d dVar = aVar.f2009c;
                    if (!dVar.f2085a) {
                        dVar.f2086b = childAt.getVisibility();
                        aVar.f2009c.f2088d = childAt.getAlpha();
                        aVar.f2009c.f2085a = true;
                    }
                    int i11 = Build.VERSION.SDK_INT;
                    if (i11 >= 17) {
                        e eVar = aVar.f2012f;
                        if (!eVar.f2091a) {
                            eVar.f2091a = true;
                            eVar.f2092b = childAt.getRotation();
                            aVar.f2012f.f2093c = childAt.getRotationX();
                            aVar.f2012f.f2094d = childAt.getRotationY();
                            aVar.f2012f.f2095e = childAt.getScaleX();
                            aVar.f2012f.f2096f = childAt.getScaleY();
                            float pivotX = childAt.getPivotX();
                            float pivotY = childAt.getPivotY();
                            if (!(((double) pivotX) == 0.0d && ((double) pivotY) == 0.0d)) {
                                e eVar2 = aVar.f2012f;
                                eVar2.f2097g = pivotX;
                                eVar2.f2098h = pivotY;
                            }
                            aVar.f2012f.f2100j = childAt.getTranslationX();
                            aVar.f2012f.f2101k = childAt.getTranslationY();
                            if (i11 >= 21) {
                                aVar.f2012f.f2102l = childAt.getTranslationZ();
                                e eVar3 = aVar.f2012f;
                                if (eVar3.f2103m) {
                                    eVar3.f2104n = childAt.getElevation();
                                }
                            }
                        }
                    }
                }
                i10++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public void M(c cVar) {
        for (Integer next : cVar.f2006f.keySet()) {
            int intValue = next.intValue();
            a aVar = cVar.f2006f.get(next);
            if (!this.f2006f.containsKey(Integer.valueOf(intValue))) {
                this.f2006f.put(Integer.valueOf(intValue), new a());
            }
            a aVar2 = this.f2006f.get(Integer.valueOf(intValue));
            if (aVar2 != null) {
                b bVar = aVar2.f2011e;
                if (!bVar.f2030b) {
                    bVar.a(aVar.f2011e);
                }
                d dVar = aVar2.f2009c;
                if (!dVar.f2085a) {
                    dVar.a(aVar.f2009c);
                }
                e eVar = aVar2.f2012f;
                if (!eVar.f2091a) {
                    eVar.a(aVar.f2012f);
                }
                C0017c cVar2 = aVar2.f2010d;
                if (!cVar2.f2071a) {
                    cVar2.a(aVar.f2010d);
                }
                for (String next2 : aVar.f2013g.keySet()) {
                    if (!aVar2.f2013g.containsKey(next2)) {
                        aVar2.f2013g.put(next2, aVar.f2013g.get(next2));
                    }
                }
            }
        }
    }

    public void R(boolean z10) {
        this.f2005e = z10;
    }

    public void S(boolean z10) {
    }

    public void g(ConstraintLayout constraintLayout) {
        a aVar;
        int childCount = constraintLayout.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            int id2 = childAt.getId();
            if (!this.f2006f.containsKey(Integer.valueOf(id2))) {
                Log.w("ConstraintSet", "id unknown " + androidx.constraintlayout.motion.widget.a.d(childAt));
            } else if (this.f2005e && id2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else if (this.f2006f.containsKey(Integer.valueOf(id2)) && (aVar = this.f2006f.get(Integer.valueOf(id2))) != null) {
                a.j(childAt, aVar.f2013g);
            }
        }
    }

    public void h(c cVar) {
        for (a next : cVar.f2006f.values()) {
            if (next.f2014h != null) {
                if (next.f2008b != null) {
                    for (Integer intValue : this.f2006f.keySet()) {
                        a w10 = w(intValue.intValue());
                        String str = w10.f2011e.f2051l0;
                        if (str != null && next.f2008b.matches(str)) {
                            next.f2014h.e(w10);
                            w10.f2013g.putAll((HashMap) next.f2013g.clone());
                        }
                    }
                } else {
                    next.f2014h.e(w(next.f2007a));
                }
            }
        }
    }

    public void i(ConstraintLayout constraintLayout) {
        k(constraintLayout, true);
        constraintLayout.setConstraintSet((c) null);
        constraintLayout.requestLayout();
    }

    public void j(ConstraintHelper constraintHelper, h0.e eVar, ConstraintLayout.LayoutParams layoutParams, SparseArray<h0.e> sparseArray) {
        a aVar;
        int id2 = constraintHelper.getId();
        if (this.f2006f.containsKey(Integer.valueOf(id2)) && (aVar = this.f2006f.get(Integer.valueOf(id2))) != null && (eVar instanceof j)) {
            constraintHelper.p(aVar, (j) eVar, layoutParams, sparseArray);
        }
    }

    /* access modifiers changed from: package-private */
    public void k(ConstraintLayout constraintLayout, boolean z10) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f2006f.keySet());
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            int id2 = childAt.getId();
            if (!this.f2006f.containsKey(Integer.valueOf(id2))) {
                Log.w("ConstraintSet", "id unknown " + androidx.constraintlayout.motion.widget.a.d(childAt));
            } else if (this.f2005e && id2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else if (id2 != -1) {
                if (this.f2006f.containsKey(Integer.valueOf(id2))) {
                    hashSet.remove(Integer.valueOf(id2));
                    a aVar = this.f2006f.get(Integer.valueOf(id2));
                    if (aVar != null) {
                        if (childAt instanceof Barrier) {
                            aVar.f2011e.f2045i0 = 1;
                            Barrier barrier = (Barrier) childAt;
                            barrier.setId(id2);
                            barrier.setType(aVar.f2011e.f2041g0);
                            barrier.setMargin(aVar.f2011e.f2043h0);
                            barrier.setAllowsGoneWidget(aVar.f2011e.f2057o0);
                            b bVar = aVar.f2011e;
                            int[] iArr = bVar.f2047j0;
                            if (iArr != null) {
                                barrier.setReferencedIds(iArr);
                            } else {
                                String str = bVar.f2049k0;
                                if (str != null) {
                                    bVar.f2047j0 = t(barrier, str);
                                    barrier.setReferencedIds(aVar.f2011e.f2047j0);
                                }
                            }
                        }
                        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                        layoutParams.c();
                        aVar.e(layoutParams);
                        if (z10) {
                            a.j(childAt, aVar.f2013g);
                        }
                        childAt.setLayoutParams(layoutParams);
                        d dVar = aVar.f2009c;
                        if (dVar.f2087c == 0) {
                            childAt.setVisibility(dVar.f2086b);
                        }
                        int i11 = Build.VERSION.SDK_INT;
                        if (i11 >= 17) {
                            childAt.setAlpha(aVar.f2009c.f2088d);
                            childAt.setRotation(aVar.f2012f.f2092b);
                            childAt.setRotationX(aVar.f2012f.f2093c);
                            childAt.setRotationY(aVar.f2012f.f2094d);
                            childAt.setScaleX(aVar.f2012f.f2095e);
                            childAt.setScaleY(aVar.f2012f.f2096f);
                            e eVar = aVar.f2012f;
                            if (eVar.f2099i != -1) {
                                View findViewById = ((View) childAt.getParent()).findViewById(aVar.f2012f.f2099i);
                                if (findViewById != null) {
                                    float top = ((float) (findViewById.getTop() + findViewById.getBottom())) / 2.0f;
                                    float left = ((float) (findViewById.getLeft() + findViewById.getRight())) / 2.0f;
                                    if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                        childAt.setPivotX(left - ((float) childAt.getLeft()));
                                        childAt.setPivotY(top - ((float) childAt.getTop()));
                                    }
                                }
                            } else {
                                if (!Float.isNaN(eVar.f2097g)) {
                                    childAt.setPivotX(aVar.f2012f.f2097g);
                                }
                                if (!Float.isNaN(aVar.f2012f.f2098h)) {
                                    childAt.setPivotY(aVar.f2012f.f2098h);
                                }
                            }
                            childAt.setTranslationX(aVar.f2012f.f2100j);
                            childAt.setTranslationY(aVar.f2012f.f2101k);
                            if (i11 >= 21) {
                                childAt.setTranslationZ(aVar.f2012f.f2102l);
                                e eVar2 = aVar.f2012f;
                                if (eVar2.f2103m) {
                                    childAt.setElevation(eVar2.f2104n);
                                }
                            }
                        }
                    }
                } else {
                    Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id2);
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            a aVar2 = this.f2006f.get(num);
            if (aVar2 != null) {
                if (aVar2.f2011e.f2045i0 == 1) {
                    Barrier barrier2 = new Barrier(constraintLayout.getContext());
                    barrier2.setId(num.intValue());
                    b bVar2 = aVar2.f2011e;
                    int[] iArr2 = bVar2.f2047j0;
                    if (iArr2 != null) {
                        barrier2.setReferencedIds(iArr2);
                    } else {
                        String str2 = bVar2.f2049k0;
                        if (str2 != null) {
                            bVar2.f2047j0 = t(barrier2, str2);
                            barrier2.setReferencedIds(aVar2.f2011e.f2047j0);
                        }
                    }
                    barrier2.setType(aVar2.f2011e.f2041g0);
                    barrier2.setMargin(aVar2.f2011e.f2043h0);
                    ConstraintLayout.LayoutParams f10 = constraintLayout.generateDefaultLayoutParams();
                    barrier2.w();
                    aVar2.e(f10);
                    constraintLayout.addView(barrier2, f10);
                }
                if (aVar2.f2011e.f2028a) {
                    Guideline guideline = new Guideline(constraintLayout.getContext());
                    guideline.setId(num.intValue());
                    ConstraintLayout.LayoutParams f11 = constraintLayout.generateDefaultLayoutParams();
                    aVar2.e(f11);
                    constraintLayout.addView(guideline, f11);
                }
            }
        }
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt2 = constraintLayout.getChildAt(i12);
            if (childAt2 instanceof ConstraintHelper) {
                ((ConstraintHelper) childAt2).j(constraintLayout);
            }
        }
    }

    public void l(int i10, ConstraintLayout.LayoutParams layoutParams) {
        a aVar;
        if (this.f2006f.containsKey(Integer.valueOf(i10)) && (aVar = this.f2006f.get(Integer.valueOf(i10))) != null) {
            aVar.e(layoutParams);
        }
    }

    public void n(int i10, int i11) {
        a aVar;
        if (this.f2006f.containsKey(Integer.valueOf(i10)) && (aVar = this.f2006f.get(Integer.valueOf(i10))) != null) {
            switch (i11) {
                case 1:
                    b bVar = aVar.f2011e;
                    bVar.f2046j = -1;
                    bVar.f2044i = -1;
                    bVar.G = -1;
                    bVar.N = Integer.MIN_VALUE;
                    return;
                case 2:
                    b bVar2 = aVar.f2011e;
                    bVar2.f2050l = -1;
                    bVar2.f2048k = -1;
                    bVar2.H = -1;
                    bVar2.P = Integer.MIN_VALUE;
                    return;
                case 3:
                    b bVar3 = aVar.f2011e;
                    bVar3.f2054n = -1;
                    bVar3.f2052m = -1;
                    bVar3.I = 0;
                    bVar3.O = Integer.MIN_VALUE;
                    return;
                case 4:
                    b bVar4 = aVar.f2011e;
                    bVar4.f2056o = -1;
                    bVar4.f2058p = -1;
                    bVar4.J = 0;
                    bVar4.Q = Integer.MIN_VALUE;
                    return;
                case 5:
                    b bVar5 = aVar.f2011e;
                    bVar5.f2060q = -1;
                    bVar5.f2061r = -1;
                    bVar5.f2062s = -1;
                    bVar5.M = 0;
                    bVar5.T = Integer.MIN_VALUE;
                    return;
                case 6:
                    b bVar6 = aVar.f2011e;
                    bVar6.f2063t = -1;
                    bVar6.f2064u = -1;
                    bVar6.L = 0;
                    bVar6.S = Integer.MIN_VALUE;
                    return;
                case 7:
                    b bVar7 = aVar.f2011e;
                    bVar7.f2065v = -1;
                    bVar7.f2066w = -1;
                    bVar7.K = 0;
                    bVar7.R = Integer.MIN_VALUE;
                    return;
                case 8:
                    b bVar8 = aVar.f2011e;
                    bVar8.C = -1.0f;
                    bVar8.B = -1;
                    bVar8.A = -1;
                    return;
                default:
                    throw new IllegalArgumentException("unknown constraint");
            }
        }
    }

    public void o(Context context, int i10) {
        p((ConstraintLayout) LayoutInflater.from(context).inflate(i10, (ViewGroup) null));
    }

    public void p(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.f2006f.clear();
        int i10 = 0;
        while (i10 < childCount) {
            View childAt = constraintLayout.getChildAt(i10);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (!this.f2005e || id2 != -1) {
                if (!this.f2006f.containsKey(Integer.valueOf(id2))) {
                    this.f2006f.put(Integer.valueOf(id2), new a());
                }
                a aVar = this.f2006f.get(Integer.valueOf(id2));
                if (aVar != null) {
                    aVar.f2013g = a.b(this.f2004d, childAt);
                    aVar.g(id2, layoutParams);
                    aVar.f2009c.f2086b = childAt.getVisibility();
                    int i11 = Build.VERSION.SDK_INT;
                    if (i11 >= 17) {
                        aVar.f2009c.f2088d = childAt.getAlpha();
                        aVar.f2012f.f2092b = childAt.getRotation();
                        aVar.f2012f.f2093c = childAt.getRotationX();
                        aVar.f2012f.f2094d = childAt.getRotationY();
                        aVar.f2012f.f2095e = childAt.getScaleX();
                        aVar.f2012f.f2096f = childAt.getScaleY();
                        float pivotX = childAt.getPivotX();
                        float pivotY = childAt.getPivotY();
                        if (!(((double) pivotX) == 0.0d && ((double) pivotY) == 0.0d)) {
                            e eVar = aVar.f2012f;
                            eVar.f2097g = pivotX;
                            eVar.f2098h = pivotY;
                        }
                        aVar.f2012f.f2100j = childAt.getTranslationX();
                        aVar.f2012f.f2101k = childAt.getTranslationY();
                        if (i11 >= 21) {
                            aVar.f2012f.f2102l = childAt.getTranslationZ();
                            e eVar2 = aVar.f2012f;
                            if (eVar2.f2103m) {
                                eVar2.f2104n = childAt.getElevation();
                            }
                        }
                    }
                    if (childAt instanceof Barrier) {
                        Barrier barrier = (Barrier) childAt;
                        aVar.f2011e.f2057o0 = barrier.getAllowsGoneWidget();
                        aVar.f2011e.f2047j0 = barrier.getReferencedIds();
                        aVar.f2011e.f2041g0 = barrier.getType();
                        aVar.f2011e.f2043h0 = barrier.getMargin();
                    }
                }
                i10++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public void q(c cVar) {
        this.f2006f.clear();
        for (Integer next : cVar.f2006f.keySet()) {
            a aVar = cVar.f2006f.get(next);
            if (aVar != null) {
                this.f2006f.put(next, aVar.clone());
            }
        }
    }

    public void r(Constraints constraints) {
        int childCount = constraints.getChildCount();
        this.f2006f.clear();
        int i10 = 0;
        while (i10 < childCount) {
            View childAt = constraints.getChildAt(i10);
            Constraints.LayoutParams layoutParams = (Constraints.LayoutParams) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (!this.f2005e || id2 != -1) {
                if (!this.f2006f.containsKey(Integer.valueOf(id2))) {
                    this.f2006f.put(Integer.valueOf(id2), new a());
                }
                a aVar = this.f2006f.get(Integer.valueOf(id2));
                if (aVar != null) {
                    if (childAt instanceof ConstraintHelper) {
                        aVar.i((ConstraintHelper) childAt, id2, layoutParams);
                    }
                    aVar.h(id2, layoutParams);
                }
                i10++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public void s(int i10, int i11, int i12, float f10) {
        b bVar = v(i10).f2011e;
        bVar.A = i11;
        bVar.B = i12;
        bVar.C = f10;
    }

    public a w(int i10) {
        if (this.f2006f.containsKey(Integer.valueOf(i10))) {
            return this.f2006f.get(Integer.valueOf(i10));
        }
        return null;
    }

    public int x(int i10) {
        return v(i10).f2011e.f2034d;
    }

    public int[] y() {
        Integer[] numArr = (Integer[]) this.f2006f.keySet().toArray(new Integer[0]);
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            iArr[i10] = numArr[i10].intValue();
        }
        return iArr;
    }

    public a z(int i10) {
        return v(i10);
    }
}
