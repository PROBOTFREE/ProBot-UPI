package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.v;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.List;
import t0.b;

@SuppressLint({"RestrictedApi"})
public class d extends v {

    class a extends Transition.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Rect f4083a;

        a(d dVar, Rect rect) {
            this.f4083a = rect;
        }

        public Rect a(Transition transition) {
            return this.f4083a;
        }
    }

    class b implements Transition.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f4084a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f4085b;

        b(d dVar, View view, ArrayList arrayList) {
            this.f4084a = view;
            this.f4085b = arrayList;
        }

        public void a(Transition transition) {
            transition.d0(this);
            transition.a(this);
        }

        public void b(Transition transition) {
        }

        public void c(Transition transition) {
        }

        public void d(Transition transition) {
        }

        public void e(Transition transition) {
            transition.d0(this);
            this.f4084a.setVisibility(8);
            int size = this.f4085b.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((View) this.f4085b.get(i10)).setVisibility(0);
            }
        }
    }

    class c extends r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f4086a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f4087b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f4088c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ArrayList f4089d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Object f4090e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ ArrayList f4091f;

        c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f4086a = obj;
            this.f4087b = arrayList;
            this.f4088c = obj2;
            this.f4089d = arrayList2;
            this.f4090e = obj3;
            this.f4091f = arrayList3;
        }

        public void a(Transition transition) {
            Object obj = this.f4086a;
            if (obj != null) {
                d.this.q(obj, this.f4087b, (ArrayList<View>) null);
            }
            Object obj2 = this.f4088c;
            if (obj2 != null) {
                d.this.q(obj2, this.f4089d, (ArrayList<View>) null);
            }
            Object obj3 = this.f4090e;
            if (obj3 != null) {
                d.this.q(obj3, this.f4091f, (ArrayList<View>) null);
            }
        }

        public void e(Transition transition) {
            transition.d0(this);
        }
    }

    /* renamed from: androidx.transition.d$d  reason: collision with other inner class name */
    class C0045d implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Transition f4093a;

        C0045d(d dVar, Transition transition) {
            this.f4093a = transition;
        }

        public void a() {
            this.f4093a.cancel();
        }
    }

    class e implements Transition.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Runnable f4094a;

        e(d dVar, Runnable runnable) {
            this.f4094a = runnable;
        }

        public void a(Transition transition) {
        }

        public void b(Transition transition) {
        }

        public void c(Transition transition) {
        }

        public void d(Transition transition) {
        }

        public void e(Transition transition) {
            this.f4094a.run();
        }
    }

    class f extends Transition.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Rect f4095a;

        f(d dVar, Rect rect) {
            this.f4095a = rect;
        }

        public Rect a(Transition transition) {
            Rect rect = this.f4095a;
            if (rect == null || rect.isEmpty()) {
                return null;
            }
            return this.f4095a;
        }
    }

    private static boolean C(Transition transition) {
        return !v.l(transition.J()) || !v.l(transition.K()) || !v.l(transition.L());
    }

    public void A(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.M().clear();
            transitionSet.M().addAll(arrayList2);
            q(transitionSet, arrayList, arrayList2);
        }
    }

    public Object B(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.v0((Transition) obj);
        return transitionSet;
    }

    public void a(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).b(view);
        }
    }

    public void b(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        if (transition != null) {
            int i10 = 0;
            if (transition instanceof TransitionSet) {
                TransitionSet transitionSet = (TransitionSet) transition;
                int y02 = transitionSet.y0();
                while (i10 < y02) {
                    b(transitionSet.x0(i10), arrayList);
                    i10++;
                }
            } else if (!C(transition) && v.l(transition.M())) {
                int size = arrayList.size();
                while (i10 < size) {
                    transition.b(arrayList.get(i10));
                    i10++;
                }
            }
        }
    }

    public void c(ViewGroup viewGroup, Object obj) {
        s.a(viewGroup, (Transition) obj);
    }

    public boolean e(Object obj) {
        return obj instanceof Transition;
    }

    public Object g(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    public Object m(Object obj, Object obj2, Object obj3) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition != null && transition2 != null) {
            transition = new TransitionSet().v0(transition).v0(transition2).D0(1);
        } else if (transition == null) {
            transition = transition2 != null ? transition2 : null;
        }
        if (transition3 == null) {
            return transition;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (transition != null) {
            transitionSet.v0(transition);
        }
        transitionSet.v0(transition3);
        return transitionSet;
    }

    public Object n(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.v0((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.v0((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.v0((Transition) obj3);
        }
        return transitionSet;
    }

    public void p(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).e0(view);
        }
    }

    public void q(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        Transition transition = (Transition) obj;
        int i10 = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int y02 = transitionSet.y0();
            while (i10 < y02) {
                q(transitionSet.x0(i10), arrayList, arrayList2);
                i10++;
            }
        } else if (!C(transition)) {
            List<View> M = transition.M();
            if (M.size() == arrayList.size() && M.containsAll(arrayList)) {
                int size = arrayList2 == null ? 0 : arrayList2.size();
                while (i10 < size) {
                    transition.b(arrayList2.get(i10));
                    i10++;
                }
                for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                    transition.e0(arrayList.get(size2));
                }
            }
        }
    }

    public void r(Object obj, View view, ArrayList<View> arrayList) {
        ((Transition) obj).a(new b(this, view, arrayList));
    }

    public void t(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((Transition) obj).a(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    public void u(Object obj, Rect rect) {
        if (obj != null) {
            ((Transition) obj).j0(new f(this, rect));
        }
    }

    public void v(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            k(view, rect);
            ((Transition) obj).j0(new a(this, rect));
        }
    }

    public void w(Fragment fragment, Object obj, t0.b bVar, Runnable runnable) {
        Transition transition = (Transition) obj;
        bVar.c(new C0045d(this, transition));
        transition.a(new e(this, runnable));
    }

    public void z(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List<View> M = transitionSet.M();
        M.clear();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            v.d(M, arrayList.get(i10));
        }
        M.add(view);
        arrayList.add(view);
        b(transitionSet, arrayList);
    }
}
