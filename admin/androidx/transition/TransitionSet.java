package androidx.transition;

import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.Iterator;
import n0.g;
import x1.d;

public class TransitionSet extends Transition {
    private ArrayList<Transition> J = new ArrayList<>();
    private boolean K = true;
    int L;
    boolean M = false;
    private int N = 0;

    class a extends r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Transition f4047a;

        a(TransitionSet transitionSet, Transition transition) {
            this.f4047a = transition;
        }

        public void e(Transition transition) {
            this.f4047a.h0();
            transition.d0(this);
        }
    }

    static class b extends r {

        /* renamed from: a  reason: collision with root package name */
        TransitionSet f4048a;

        b(TransitionSet transitionSet) {
            this.f4048a = transitionSet;
        }

        public void a(Transition transition) {
            TransitionSet transitionSet = this.f4048a;
            if (!transitionSet.M) {
                transitionSet.r0();
                this.f4048a.M = true;
            }
        }

        public void e(Transition transition) {
            TransitionSet transitionSet = this.f4048a;
            int i10 = transitionSet.L - 1;
            transitionSet.L = i10;
            if (i10 == 0) {
                transitionSet.M = false;
                transitionSet.v();
            }
            transition.d0(this);
        }
    }

    public TransitionSet() {
    }

    @SuppressLint({"RestrictedApi"})
    public TransitionSet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, q.f4148g);
        D0(g.g(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionOrdering", 0, 0));
        obtainStyledAttributes.recycle();
    }

    private void F0() {
        b bVar = new b(this);
        Iterator<Transition> it = this.J.iterator();
        while (it.hasNext()) {
            it.next().a(bVar);
        }
        this.L = this.J.size();
    }

    private void w0(Transition transition) {
        this.J.add(transition);
        transition.f4030r = this;
    }

    /* renamed from: A0 */
    public TransitionSet e0(View view) {
        for (int i10 = 0; i10 < this.J.size(); i10++) {
            this.J.get(i10).e0(view);
        }
        return (TransitionSet) super.e0(view);
    }

    /* renamed from: B0 */
    public TransitionSet i0(long j10) {
        ArrayList<Transition> arrayList;
        super.i0(j10);
        if (this.f4015c >= 0 && (arrayList = this.J) != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.J.get(i10).i0(j10);
            }
        }
        return this;
    }

    /* renamed from: C0 */
    public TransitionSet k0(TimeInterpolator timeInterpolator) {
        this.N |= 1;
        ArrayList<Transition> arrayList = this.J;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.J.get(i10).k0(timeInterpolator);
            }
        }
        return (TransitionSet) super.k0(timeInterpolator);
    }

    public TransitionSet D0(int i10) {
        if (i10 == 0) {
            this.K = true;
        } else if (i10 == 1) {
            this.K = false;
        } else {
            throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i10);
        }
        return this;
    }

    /* renamed from: E0 */
    public TransitionSet p0(long j10) {
        return (TransitionSet) super.p0(j10);
    }

    public void a0(View view) {
        super.a0(view);
        int size = this.J.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.J.get(i10).a0(view);
        }
    }

    /* access modifiers changed from: protected */
    public void cancel() {
        super.cancel();
        int size = this.J.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.J.get(i10).cancel();
        }
    }

    public void f0(View view) {
        super.f0(view);
        int size = this.J.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.J.get(i10).f0(view);
        }
    }

    /* access modifiers changed from: protected */
    public void h0() {
        if (this.J.isEmpty()) {
            r0();
            v();
            return;
        }
        F0();
        if (!this.K) {
            for (int i10 = 1; i10 < this.J.size(); i10++) {
                this.J.get(i10 - 1).a(new a(this, this.J.get(i10)));
            }
            Transition transition = this.J.get(0);
            if (transition != null) {
                transition.h0();
                return;
            }
            return;
        }
        Iterator<Transition> it = this.J.iterator();
        while (it.hasNext()) {
            it.next().h0();
        }
    }

    public void j0(Transition.e eVar) {
        super.j0(eVar);
        this.N |= 8;
        int size = this.J.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.J.get(i10).j0(eVar);
        }
    }

    public void l(u uVar) {
        if (R(uVar.f4165b)) {
            Iterator<Transition> it = this.J.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.R(uVar.f4165b)) {
                    next.l(uVar);
                    uVar.f4166c.add(next);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void n(u uVar) {
        super.n(uVar);
        int size = this.J.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.J.get(i10).n(uVar);
        }
    }

    public void n0(PathMotion pathMotion) {
        super.n0(pathMotion);
        this.N |= 4;
        if (this.J != null) {
            for (int i10 = 0; i10 < this.J.size(); i10++) {
                this.J.get(i10).n0(pathMotion);
            }
        }
    }

    public void o(u uVar) {
        if (R(uVar.f4165b)) {
            Iterator<Transition> it = this.J.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.R(uVar.f4165b)) {
                    next.o(uVar);
                    uVar.f4166c.add(next);
                }
            }
        }
    }

    public void o0(d dVar) {
        super.o0(dVar);
        this.N |= 2;
        int size = this.J.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.J.get(i10).o0(dVar);
        }
    }

    /* renamed from: r */
    public Transition clone() {
        TransitionSet transitionSet = (TransitionSet) super.clone();
        transitionSet.J = new ArrayList<>();
        int size = this.J.size();
        for (int i10 = 0; i10 < size; i10++) {
            transitionSet.w0(this.J.get(i10).clone());
        }
        return transitionSet;
    }

    /* access modifiers changed from: package-private */
    public String s0(String str) {
        String s02 = super.s0(str);
        for (int i10 = 0; i10 < this.J.size(); i10++) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(s02);
            sb2.append("\n");
            sb2.append(this.J.get(i10).s0(str + "  "));
            s02 = sb2.toString();
        }
        return s02;
    }

    /* access modifiers changed from: protected */
    public void t(ViewGroup viewGroup, v vVar, v vVar2, ArrayList<u> arrayList, ArrayList<u> arrayList2) {
        long I = I();
        int size = this.J.size();
        for (int i10 = 0; i10 < size; i10++) {
            Transition transition = this.J.get(i10);
            if (I > 0 && (this.K || i10 == 0)) {
                long I2 = transition.I();
                if (I2 > 0) {
                    transition.p0(I2 + I);
                } else {
                    transition.p0(I);
                }
            }
            transition.t(viewGroup, vVar, vVar2, arrayList, arrayList2);
        }
    }

    /* renamed from: t0 */
    public TransitionSet a(Transition.f fVar) {
        return (TransitionSet) super.a(fVar);
    }

    /* renamed from: u0 */
    public TransitionSet b(View view) {
        for (int i10 = 0; i10 < this.J.size(); i10++) {
            this.J.get(i10).b(view);
        }
        return (TransitionSet) super.b(view);
    }

    public TransitionSet v0(Transition transition) {
        w0(transition);
        long j10 = this.f4015c;
        if (j10 >= 0) {
            transition.i0(j10);
        }
        if ((this.N & 1) != 0) {
            transition.k0(C());
        }
        if ((this.N & 2) != 0) {
            transition.o0(G());
        }
        if ((this.N & 4) != 0) {
            transition.n0(F());
        }
        if ((this.N & 8) != 0) {
            transition.j0(B());
        }
        return this;
    }

    public Transition x0(int i10) {
        if (i10 < 0 || i10 >= this.J.size()) {
            return null;
        }
        return this.J.get(i10);
    }

    public int y0() {
        return this.J.size();
    }

    /* renamed from: z0 */
    public TransitionSet d0(Transition.f fVar) {
        return (TransitionSet) super.d0(fVar);
    }
}
