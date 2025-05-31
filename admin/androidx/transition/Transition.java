package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.core.view.x;
import com.mintoak.corelib.util.StringConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import n0.g;

public abstract class Transition implements Cloneable {
    private static final int[] G = {2, 1, 3, 4};
    private static final PathMotion H = new a();
    private static ThreadLocal<c0.a<Animator, d>> I = new ThreadLocal<>();
    private ArrayList<f> A = null;
    private ArrayList<Animator> B = new ArrayList<>();
    x1.d C;
    private e D;
    private c0.a<String, String> E;
    private PathMotion F = H;

    /* renamed from: a  reason: collision with root package name */
    private String f4013a = getClass().getName();

    /* renamed from: b  reason: collision with root package name */
    private long f4014b = -1;

    /* renamed from: c  reason: collision with root package name */
    long f4015c = -1;

    /* renamed from: d  reason: collision with root package name */
    private TimeInterpolator f4016d = null;

    /* renamed from: e  reason: collision with root package name */
    ArrayList<Integer> f4017e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    ArrayList<View> f4018f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<String> f4019g = null;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<Class<?>> f4020h = null;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<Integer> f4021i = null;

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<View> f4022j = null;

    /* renamed from: k  reason: collision with root package name */
    private ArrayList<Class<?>> f4023k = null;

    /* renamed from: l  reason: collision with root package name */
    private ArrayList<String> f4024l = null;

    /* renamed from: m  reason: collision with root package name */
    private ArrayList<Integer> f4025m = null;

    /* renamed from: n  reason: collision with root package name */
    private ArrayList<View> f4026n = null;

    /* renamed from: o  reason: collision with root package name */
    private ArrayList<Class<?>> f4027o = null;

    /* renamed from: p  reason: collision with root package name */
    private v f4028p = new v();

    /* renamed from: q  reason: collision with root package name */
    private v f4029q = new v();

    /* renamed from: r  reason: collision with root package name */
    TransitionSet f4030r = null;

    /* renamed from: s  reason: collision with root package name */
    private int[] f4031s = G;

    /* renamed from: t  reason: collision with root package name */
    private ArrayList<u> f4032t;

    /* renamed from: u  reason: collision with root package name */
    private ArrayList<u> f4033u;

    /* renamed from: v  reason: collision with root package name */
    boolean f4034v = false;

    /* renamed from: w  reason: collision with root package name */
    ArrayList<Animator> f4035w = new ArrayList<>();

    /* renamed from: x  reason: collision with root package name */
    private int f4036x = 0;

    /* renamed from: y  reason: collision with root package name */
    private boolean f4037y = false;

    /* renamed from: z  reason: collision with root package name */
    private boolean f4038z = false;

    static class a extends PathMotion {
        a() {
        }

        public Path a(float f10, float f11, float f12, float f13) {
            Path path = new Path();
            path.moveTo(f10, f11);
            path.lineTo(f12, f13);
            return path;
        }
    }

    class b extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c0.a f4039a;

        b(c0.a aVar) {
            this.f4039a = aVar;
        }

        public void onAnimationEnd(Animator animator) {
            this.f4039a.remove(animator);
            Transition.this.f4035w.remove(animator);
        }

        public void onAnimationStart(Animator animator) {
            Transition.this.f4035w.add(animator);
        }
    }

    class c extends AnimatorListenerAdapter {
        c() {
        }

        public void onAnimationEnd(Animator animator) {
            Transition.this.v();
            animator.removeListener(this);
        }
    }

    private static class d {

        /* renamed from: a  reason: collision with root package name */
        View f4042a;

        /* renamed from: b  reason: collision with root package name */
        String f4043b;

        /* renamed from: c  reason: collision with root package name */
        u f4044c;

        /* renamed from: d  reason: collision with root package name */
        o0 f4045d;

        /* renamed from: e  reason: collision with root package name */
        Transition f4046e;

        d(View view, String str, Transition transition, o0 o0Var, u uVar) {
            this.f4042a = view;
            this.f4043b = str;
            this.f4044c = uVar;
            this.f4045d = o0Var;
            this.f4046e = transition;
        }
    }

    public static abstract class e {
        public abstract Rect a(Transition transition);
    }

    public interface f {
        void a(Transition transition);

        void b(Transition transition);

        void c(Transition transition);

        void d(Transition transition);

        void e(Transition transition);
    }

    public Transition() {
    }

    @SuppressLint({"RestrictedApi"})
    public Transition(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, q.f4142a);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long g10 = (long) g.g(obtainStyledAttributes, xmlResourceParser, StringConstants.DURATION, 1, -1);
        if (g10 >= 0) {
            i0(g10);
        }
        long g11 = (long) g.g(obtainStyledAttributes, xmlResourceParser, "startDelay", 2, -1);
        if (g11 > 0) {
            p0(g11);
        }
        int h10 = g.h(obtainStyledAttributes, xmlResourceParser, "interpolator", 0, 0);
        if (h10 > 0) {
            k0(AnimationUtils.loadInterpolator(context, h10));
        }
        String i10 = g.i(obtainStyledAttributes, xmlResourceParser, "matchOrder", 3);
        if (i10 != null) {
            l0(Z(i10));
        }
        obtainStyledAttributes.recycle();
    }

    private static c0.a<Animator, d> H() {
        c0.a<Animator, d> aVar = I.get();
        if (aVar != null) {
            return aVar;
        }
        c0.a<Animator, d> aVar2 = new c0.a<>();
        I.set(aVar2);
        return aVar2;
    }

    private static boolean Q(int i10) {
        return i10 >= 1 && i10 <= 4;
    }

    private static boolean S(u uVar, u uVar2, String str) {
        Object obj = uVar.f4164a.get(str);
        Object obj2 = uVar2.f4164a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    private void T(c0.a<View, u> aVar, c0.a<View, u> aVar2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            View valueAt = sparseArray.valueAt(i10);
            if (valueAt != null && R(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i10))) != null && R(view)) {
                u uVar = aVar.get(valueAt);
                u uVar2 = aVar2.get(view);
                if (!(uVar == null || uVar2 == null)) {
                    this.f4032t.add(uVar);
                    this.f4033u.add(uVar2);
                    aVar.remove(valueAt);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void U(c0.a<View, u> aVar, c0.a<View, u> aVar2) {
        u remove;
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View k10 = aVar.k(size);
            if (k10 != null && R(k10) && (remove = aVar2.remove(k10)) != null && R(remove.f4165b)) {
                this.f4032t.add(aVar.m(size));
                this.f4033u.add(remove);
            }
        }
    }

    private void W(c0.a<View, u> aVar, c0.a<View, u> aVar2, c0.d<View> dVar, c0.d<View> dVar2) {
        View i10;
        int q10 = dVar.q();
        for (int i11 = 0; i11 < q10; i11++) {
            View r10 = dVar.r(i11);
            if (r10 != null && R(r10) && (i10 = dVar2.i(dVar.m(i11))) != null && R(i10)) {
                u uVar = aVar.get(r10);
                u uVar2 = aVar2.get(i10);
                if (!(uVar == null || uVar2 == null)) {
                    this.f4032t.add(uVar);
                    this.f4033u.add(uVar2);
                    aVar.remove(r10);
                    aVar2.remove(i10);
                }
            }
        }
    }

    private void X(c0.a<View, u> aVar, c0.a<View, u> aVar2, c0.a<String, View> aVar3, c0.a<String, View> aVar4) {
        View view;
        int size = aVar3.size();
        for (int i10 = 0; i10 < size; i10++) {
            View o10 = aVar3.o(i10);
            if (o10 != null && R(o10) && (view = aVar4.get(aVar3.k(i10))) != null && R(view)) {
                u uVar = aVar.get(o10);
                u uVar2 = aVar2.get(view);
                if (!(uVar == null || uVar2 == null)) {
                    this.f4032t.add(uVar);
                    this.f4033u.add(uVar2);
                    aVar.remove(o10);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void Y(v vVar, v vVar2) {
        c0.a aVar = new c0.a((c0.g) vVar.f4167a);
        c0.a aVar2 = new c0.a((c0.g) vVar2.f4167a);
        int i10 = 0;
        while (true) {
            int[] iArr = this.f4031s;
            if (i10 < iArr.length) {
                int i11 = iArr[i10];
                if (i11 == 1) {
                    U(aVar, aVar2);
                } else if (i11 == 2) {
                    X(aVar, aVar2, vVar.f4170d, vVar2.f4170d);
                } else if (i11 == 3) {
                    T(aVar, aVar2, vVar.f4168b, vVar2.f4168b);
                } else if (i11 == 4) {
                    W(aVar, aVar2, vVar.f4169c, vVar2.f4169c);
                }
                i10++;
            } else {
                e(aVar, aVar2);
                return;
            }
        }
    }

    private static int[] Z(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        int[] iArr = new int[stringTokenizer.countTokens()];
        int i10 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String trim = stringTokenizer.nextToken().trim();
            if ("id".equalsIgnoreCase(trim)) {
                iArr[i10] = 3;
            } else if ("instance".equalsIgnoreCase(trim)) {
                iArr[i10] = 1;
            } else if ("name".equalsIgnoreCase(trim)) {
                iArr[i10] = 2;
            } else if ("itemId".equalsIgnoreCase(trim)) {
                iArr[i10] = 4;
            } else if (trim.isEmpty()) {
                int[] iArr2 = new int[(iArr.length - 1)];
                System.arraycopy(iArr, 0, iArr2, 0, i10);
                i10--;
                iArr = iArr2;
            } else {
                throw new InflateException("Unknown match type in matchOrder: '" + trim + "'");
            }
            i10++;
        }
        return iArr;
    }

    private void e(c0.a<View, u> aVar, c0.a<View, u> aVar2) {
        for (int i10 = 0; i10 < aVar.size(); i10++) {
            u o10 = aVar.o(i10);
            if (R(o10.f4165b)) {
                this.f4032t.add(o10);
                this.f4033u.add((Object) null);
            }
        }
        for (int i11 = 0; i11 < aVar2.size(); i11++) {
            u o11 = aVar2.o(i11);
            if (R(o11.f4165b)) {
                this.f4033u.add(o11);
                this.f4032t.add((Object) null);
            }
        }
    }

    private static void g(v vVar, View view, u uVar) {
        vVar.f4167a.put(view, uVar);
        int id2 = view.getId();
        if (id2 >= 0) {
            if (vVar.f4168b.indexOfKey(id2) >= 0) {
                vVar.f4168b.put(id2, (Object) null);
            } else {
                vVar.f4168b.put(id2, view);
            }
        }
        String M = x.M(view);
        if (M != null) {
            if (vVar.f4170d.containsKey(M)) {
                vVar.f4170d.put(M, null);
            } else {
                vVar.f4170d.put(M, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (vVar.f4169c.l(itemIdAtPosition) >= 0) {
                    View i10 = vVar.f4169c.i(itemIdAtPosition);
                    if (i10 != null) {
                        x.A0(i10, false);
                        vVar.f4169c.n(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                x.A0(view, true);
                vVar.f4169c.n(itemIdAtPosition, view);
            }
        }
    }

    private void g0(Animator animator, c0.a<Animator, d> aVar) {
        if (animator != null) {
            animator.addListener(new b(aVar));
            j(animator);
        }
    }

    private static boolean i(int[] iArr, int i10) {
        int i11 = iArr[i10];
        for (int i12 = 0; i12 < i10; i12++) {
            if (iArr[i12] == i11) {
                return true;
            }
        }
        return false;
    }

    private void m(View view, boolean z10) {
        if (view != null) {
            int id2 = view.getId();
            ArrayList<Integer> arrayList = this.f4021i;
            if (arrayList == null || !arrayList.contains(Integer.valueOf(id2))) {
                ArrayList<View> arrayList2 = this.f4022j;
                if (arrayList2 == null || !arrayList2.contains(view)) {
                    ArrayList<Class<?>> arrayList3 = this.f4023k;
                    if (arrayList3 != null) {
                        int size = arrayList3.size();
                        int i10 = 0;
                        while (i10 < size) {
                            if (!this.f4023k.get(i10).isInstance(view)) {
                                i10++;
                            } else {
                                return;
                            }
                        }
                    }
                    if (view.getParent() instanceof ViewGroup) {
                        u uVar = new u(view);
                        if (z10) {
                            o(uVar);
                        } else {
                            l(uVar);
                        }
                        uVar.f4166c.add(this);
                        n(uVar);
                        g(z10 ? this.f4028p : this.f4029q, view, uVar);
                    }
                    if (view instanceof ViewGroup) {
                        ArrayList<Integer> arrayList4 = this.f4025m;
                        if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id2))) {
                            ArrayList<View> arrayList5 = this.f4026n;
                            if (arrayList5 == null || !arrayList5.contains(view)) {
                                ArrayList<Class<?>> arrayList6 = this.f4027o;
                                if (arrayList6 != null) {
                                    int size2 = arrayList6.size();
                                    int i11 = 0;
                                    while (i11 < size2) {
                                        if (!this.f4027o.get(i11).isInstance(view)) {
                                            i11++;
                                        } else {
                                            return;
                                        }
                                    }
                                }
                                ViewGroup viewGroup = (ViewGroup) view;
                                for (int i12 = 0; i12 < viewGroup.getChildCount(); i12++) {
                                    m(viewGroup.getChildAt(i12), z10);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public Rect A() {
        e eVar = this.D;
        if (eVar == null) {
            return null;
        }
        return eVar.a(this);
    }

    public e B() {
        return this.D;
    }

    public TimeInterpolator C() {
        return this.f4016d;
    }

    /* access modifiers changed from: package-private */
    public u D(View view, boolean z10) {
        TransitionSet transitionSet = this.f4030r;
        if (transitionSet != null) {
            return transitionSet.D(view, z10);
        }
        ArrayList<u> arrayList = z10 ? this.f4032t : this.f4033u;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i10 = -1;
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                break;
            }
            u uVar = arrayList.get(i11);
            if (uVar == null) {
                return null;
            }
            if (uVar.f4165b == view) {
                i10 = i11;
                break;
            }
            i11++;
        }
        if (i10 < 0) {
            return null;
        }
        return (z10 ? this.f4033u : this.f4032t).get(i10);
    }

    public String E() {
        return this.f4013a;
    }

    public PathMotion F() {
        return this.F;
    }

    public x1.d G() {
        return this.C;
    }

    public long I() {
        return this.f4014b;
    }

    public List<Integer> J() {
        return this.f4017e;
    }

    public List<String> K() {
        return this.f4019g;
    }

    public List<Class<?>> L() {
        return this.f4020h;
    }

    public List<View> M() {
        return this.f4018f;
    }

    public String[] N() {
        return null;
    }

    public u O(View view, boolean z10) {
        TransitionSet transitionSet = this.f4030r;
        if (transitionSet != null) {
            return transitionSet.O(view, z10);
        }
        return (z10 ? this.f4028p : this.f4029q).f4167a.get(view);
    }

    public boolean P(u uVar, u uVar2) {
        if (uVar == null || uVar2 == null) {
            return false;
        }
        String[] N = N();
        if (N != null) {
            int length = N.length;
            int i10 = 0;
            while (i10 < length) {
                if (!S(uVar, uVar2, N[i10])) {
                    i10++;
                }
            }
            return false;
        }
        for (String S : uVar.f4164a.keySet()) {
            if (S(uVar, uVar2, S)) {
            }
        }
        return false;
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean R(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id2 = view.getId();
        ArrayList<Integer> arrayList3 = this.f4021i;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id2))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.f4022j;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.f4023k;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (this.f4023k.get(i10).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.f4024l != null && x.M(view) != null && this.f4024l.contains(x.M(view))) {
            return false;
        }
        if ((this.f4017e.size() == 0 && this.f4018f.size() == 0 && (((arrayList = this.f4020h) == null || arrayList.isEmpty()) && ((arrayList2 = this.f4019g) == null || arrayList2.isEmpty()))) || this.f4017e.contains(Integer.valueOf(id2)) || this.f4018f.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.f4019g;
        if (arrayList6 != null && arrayList6.contains(x.M(view))) {
            return true;
        }
        if (this.f4020h != null) {
            for (int i11 = 0; i11 < this.f4020h.size(); i11++) {
                if (this.f4020h.get(i11).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Transition a(f fVar) {
        if (this.A == null) {
            this.A = new ArrayList<>();
        }
        this.A.add(fVar);
        return this;
    }

    public void a0(View view) {
        if (!this.f4038z) {
            c0.a<Animator, d> H2 = H();
            int size = H2.size();
            o0 d10 = f0.d(view);
            for (int i10 = size - 1; i10 >= 0; i10--) {
                d o10 = H2.o(i10);
                if (o10.f4042a != null && d10.equals(o10.f4045d)) {
                    a.b(H2.k(i10));
                }
            }
            ArrayList<f> arrayList = this.A;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.A.clone();
                int size2 = arrayList2.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    ((f) arrayList2.get(i11)).c(this);
                }
            }
            this.f4037y = true;
        }
    }

    public Transition b(View view) {
        this.f4018f.add(view);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void b0(ViewGroup viewGroup) {
        d dVar;
        this.f4032t = new ArrayList<>();
        this.f4033u = new ArrayList<>();
        Y(this.f4028p, this.f4029q);
        c0.a<Animator, d> H2 = H();
        int size = H2.size();
        o0 d10 = f0.d(viewGroup);
        for (int i10 = size - 1; i10 >= 0; i10--) {
            Animator k10 = H2.k(i10);
            if (!(k10 == null || (dVar = H2.get(k10)) == null || dVar.f4042a == null || !d10.equals(dVar.f4045d))) {
                u uVar = dVar.f4044c;
                View view = dVar.f4042a;
                u O = O(view, true);
                u D2 = D(view, true);
                if (O == null && D2 == null) {
                    D2 = this.f4029q.f4167a.get(view);
                }
                if (!(O == null && D2 == null) && dVar.f4046e.P(uVar, D2)) {
                    if (k10.isRunning() || k10.isStarted()) {
                        k10.cancel();
                    } else {
                        H2.remove(k10);
                    }
                }
            }
        }
        t(viewGroup, this.f4028p, this.f4029q, this.f4032t, this.f4033u);
        h0();
    }

    /* access modifiers changed from: protected */
    public void cancel() {
        for (int size = this.f4035w.size() - 1; size >= 0; size--) {
            this.f4035w.get(size).cancel();
        }
        ArrayList<f> arrayList = this.A;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.A.clone();
            int size2 = arrayList2.size();
            for (int i10 = 0; i10 < size2; i10++) {
                ((f) arrayList2.get(i10)).b(this);
            }
        }
    }

    public Transition d0(f fVar) {
        ArrayList<f> arrayList = this.A;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(fVar);
        if (this.A.size() == 0) {
            this.A = null;
        }
        return this;
    }

    public Transition e0(View view) {
        this.f4018f.remove(view);
        return this;
    }

    public void f0(View view) {
        if (this.f4037y) {
            if (!this.f4038z) {
                c0.a<Animator, d> H2 = H();
                int size = H2.size();
                o0 d10 = f0.d(view);
                for (int i10 = size - 1; i10 >= 0; i10--) {
                    d o10 = H2.o(i10);
                    if (o10.f4042a != null && d10.equals(o10.f4045d)) {
                        a.c(H2.k(i10));
                    }
                }
                ArrayList<f> arrayList = this.A;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.A.clone();
                    int size2 = arrayList2.size();
                    for (int i11 = 0; i11 < size2; i11++) {
                        ((f) arrayList2.get(i11)).d(this);
                    }
                }
            }
            this.f4037y = false;
        }
    }

    /* access modifiers changed from: protected */
    public void h0() {
        r0();
        c0.a<Animator, d> H2 = H();
        Iterator<Animator> it = this.B.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (H2.containsKey(next)) {
                r0();
                g0(next, H2);
            }
        }
        this.B.clear();
        v();
    }

    public Transition i0(long j10) {
        this.f4015c = j10;
        return this;
    }

    /* access modifiers changed from: protected */
    public void j(Animator animator) {
        if (animator == null) {
            v();
            return;
        }
        if (y() >= 0) {
            animator.setDuration(y());
        }
        if (I() >= 0) {
            animator.setStartDelay(I() + animator.getStartDelay());
        }
        if (C() != null) {
            animator.setInterpolator(C());
        }
        animator.addListener(new c());
        animator.start();
    }

    public void j0(e eVar) {
        this.D = eVar;
    }

    public Transition k0(TimeInterpolator timeInterpolator) {
        this.f4016d = timeInterpolator;
        return this;
    }

    public abstract void l(u uVar);

    public void l0(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.f4031s = G;
            return;
        }
        int i10 = 0;
        while (i10 < iArr.length) {
            if (!Q(iArr[i10])) {
                throw new IllegalArgumentException("matches contains invalid value");
            } else if (!i(iArr, i10)) {
                i10++;
            } else {
                throw new IllegalArgumentException("matches contains a duplicate value");
            }
        }
        this.f4031s = (int[]) iArr.clone();
    }

    /* access modifiers changed from: package-private */
    public void n(u uVar) {
        String[] b10;
        if (this.C != null && !uVar.f4164a.isEmpty() && (b10 = this.C.b()) != null) {
            boolean z10 = false;
            int i10 = 0;
            while (true) {
                if (i10 >= b10.length) {
                    z10 = true;
                    break;
                } else if (!uVar.f4164a.containsKey(b10[i10])) {
                    break;
                } else {
                    i10++;
                }
            }
            if (!z10) {
                this.C.a(uVar);
            }
        }
    }

    public void n0(PathMotion pathMotion) {
        if (pathMotion == null) {
            pathMotion = H;
        }
        this.F = pathMotion;
    }

    public abstract void o(u uVar);

    public void o0(x1.d dVar) {
        this.C = dVar;
    }

    /* access modifiers changed from: package-private */
    public void p(ViewGroup viewGroup, boolean z10) {
        c0.a<String, String> aVar;
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        q(z10);
        if ((this.f4017e.size() > 0 || this.f4018f.size() > 0) && (((arrayList = this.f4019g) == null || arrayList.isEmpty()) && ((arrayList2 = this.f4020h) == null || arrayList2.isEmpty()))) {
            for (int i10 = 0; i10 < this.f4017e.size(); i10++) {
                View findViewById = viewGroup.findViewById(this.f4017e.get(i10).intValue());
                if (findViewById != null) {
                    u uVar = new u(findViewById);
                    if (z10) {
                        o(uVar);
                    } else {
                        l(uVar);
                    }
                    uVar.f4166c.add(this);
                    n(uVar);
                    g(z10 ? this.f4028p : this.f4029q, findViewById, uVar);
                }
            }
            for (int i11 = 0; i11 < this.f4018f.size(); i11++) {
                View view = this.f4018f.get(i11);
                u uVar2 = new u(view);
                if (z10) {
                    o(uVar2);
                } else {
                    l(uVar2);
                }
                uVar2.f4166c.add(this);
                n(uVar2);
                g(z10 ? this.f4028p : this.f4029q, view, uVar2);
            }
        } else {
            m(viewGroup, z10);
        }
        if (!z10 && (aVar = this.E) != null) {
            int size = aVar.size();
            ArrayList arrayList3 = new ArrayList(size);
            for (int i12 = 0; i12 < size; i12++) {
                arrayList3.add(this.f4028p.f4170d.remove(this.E.k(i12)));
            }
            for (int i13 = 0; i13 < size; i13++) {
                View view2 = (View) arrayList3.get(i13);
                if (view2 != null) {
                    this.f4028p.f4170d.put(this.E.o(i13), view2);
                }
            }
        }
    }

    public Transition p0(long j10) {
        this.f4014b = j10;
        return this;
    }

    /* access modifiers changed from: package-private */
    public void q(boolean z10) {
        v vVar;
        if (z10) {
            this.f4028p.f4167a.clear();
            this.f4028p.f4168b.clear();
            vVar = this.f4028p;
        } else {
            this.f4029q.f4167a.clear();
            this.f4029q.f4168b.clear();
            vVar = this.f4029q;
        }
        vVar.f4169c.b();
    }

    /* renamed from: r */
    public Transition clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.B = new ArrayList<>();
            transition.f4028p = new v();
            transition.f4029q = new v();
            transition.f4032t = null;
            transition.f4033u = null;
            return transition;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void r0() {
        if (this.f4036x == 0) {
            ArrayList<f> arrayList = this.A;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.A.clone();
                int size = arrayList2.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((f) arrayList2.get(i10)).a(this);
                }
            }
            this.f4038z = false;
        }
        this.f4036x++;
    }

    public Animator s(ViewGroup viewGroup, u uVar, u uVar2) {
        return null;
    }

    /* access modifiers changed from: package-private */
    public String s0(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f4015c != -1) {
            str2 = str2 + "dur(" + this.f4015c + ") ";
        }
        if (this.f4014b != -1) {
            str2 = str2 + "dly(" + this.f4014b + ") ";
        }
        if (this.f4016d != null) {
            str2 = str2 + "interp(" + this.f4016d + ") ";
        }
        if (this.f4017e.size() <= 0 && this.f4018f.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.f4017e.size() > 0) {
            for (int i10 = 0; i10 < this.f4017e.size(); i10++) {
                if (i10 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f4017e.get(i10);
            }
        }
        if (this.f4018f.size() > 0) {
            for (int i11 = 0; i11 < this.f4018f.size(); i11++) {
                if (i11 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f4018f.get(i11);
            }
        }
        return str3 + ")";
    }

    /* access modifiers changed from: protected */
    public void t(ViewGroup viewGroup, v vVar, v vVar2, ArrayList<u> arrayList, ArrayList<u> arrayList2) {
        int i10;
        int i11;
        Animator s10;
        View view;
        Animator animator;
        u uVar;
        u uVar2;
        Animator animator2;
        ViewGroup viewGroup2 = viewGroup;
        c0.a<Animator, d> H2 = H();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j10 = Long.MAX_VALUE;
        int i12 = 0;
        while (i12 < size) {
            u uVar3 = arrayList.get(i12);
            u uVar4 = arrayList2.get(i12);
            if (uVar3 != null && !uVar3.f4166c.contains(this)) {
                uVar3 = null;
            }
            if (uVar4 != null && !uVar4.f4166c.contains(this)) {
                uVar4 = null;
            }
            if (!(uVar3 == null && uVar4 == null)) {
                if ((uVar3 == null || uVar4 == null || P(uVar3, uVar4)) && (s10 = s(viewGroup2, uVar3, uVar4)) != null) {
                    if (uVar4 != null) {
                        view = uVar4.f4165b;
                        String[] N = N();
                        if (N != null && N.length > 0) {
                            uVar2 = new u(view);
                            Animator animator3 = s10;
                            i11 = size;
                            u uVar5 = vVar2.f4167a.get(view);
                            if (uVar5 != null) {
                                int i13 = 0;
                                while (i13 < N.length) {
                                    uVar2.f4164a.put(N[i13], uVar5.f4164a.get(N[i13]));
                                    i13++;
                                    ArrayList<u> arrayList3 = arrayList2;
                                    i12 = i12;
                                    uVar5 = uVar5;
                                }
                            }
                            i10 = i12;
                            int size2 = H2.size();
                            int i14 = 0;
                            while (true) {
                                if (i14 >= size2) {
                                    animator2 = animator3;
                                    break;
                                }
                                d dVar = H2.get(H2.k(i14));
                                if (dVar.f4044c != null && dVar.f4042a == view && dVar.f4043b.equals(E()) && dVar.f4044c.equals(uVar2)) {
                                    animator2 = null;
                                    break;
                                }
                                i14++;
                            }
                        } else {
                            i11 = size;
                            i10 = i12;
                            animator2 = s10;
                            uVar2 = null;
                        }
                        animator = animator2;
                        uVar = uVar2;
                    } else {
                        i11 = size;
                        i10 = i12;
                        view = uVar3.f4165b;
                        animator = s10;
                        uVar = null;
                    }
                    if (animator != null) {
                        x1.d dVar2 = this.C;
                        if (dVar2 != null) {
                            long c10 = dVar2.c(viewGroup2, this, uVar3, uVar4);
                            sparseIntArray.put(this.B.size(), (int) c10);
                            j10 = Math.min(c10, j10);
                        }
                        H2.put(animator, new d(view, E(), this, f0.d(viewGroup), uVar));
                        this.B.add(animator);
                        j10 = j10;
                    }
                    i12 = i10 + 1;
                    size = i11;
                }
            }
            i11 = size;
            i10 = i12;
            i12 = i10 + 1;
            size = i11;
        }
        if (sparseIntArray.size() != 0) {
            for (int i15 = 0; i15 < sparseIntArray.size(); i15++) {
                Animator animator4 = this.B.get(sparseIntArray.keyAt(i15));
                animator4.setStartDelay((((long) sparseIntArray.valueAt(i15)) - j10) + animator4.getStartDelay());
            }
        }
    }

    public String toString() {
        return s0("");
    }

    /* access modifiers changed from: protected */
    public void v() {
        int i10 = this.f4036x - 1;
        this.f4036x = i10;
        if (i10 == 0) {
            ArrayList<f> arrayList = this.A;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.A.clone();
                int size = arrayList2.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((f) arrayList2.get(i11)).e(this);
                }
            }
            for (int i12 = 0; i12 < this.f4028p.f4169c.q(); i12++) {
                View r10 = this.f4028p.f4169c.r(i12);
                if (r10 != null) {
                    x.A0(r10, false);
                }
            }
            for (int i13 = 0; i13 < this.f4029q.f4169c.q(); i13++) {
                View r11 = this.f4029q.f4169c.r(i13);
                if (r11 != null) {
                    x.A0(r11, false);
                }
            }
            this.f4038z = true;
        }
    }

    public long y() {
        return this.f4015c;
    }
}
