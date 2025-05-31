package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

class u extends v {

    class a extends Transition.EpicenterCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Rect f2889a;

        a(u uVar, Rect rect) {
            this.f2889a = rect;
        }

        public Rect onGetEpicenter(Transition transition) {
            return this.f2889a;
        }
    }

    class b implements Transition.TransitionListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f2890a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f2891b;

        b(u uVar, View view, ArrayList arrayList) {
            this.f2890a = view;
            this.f2891b = arrayList;
        }

        public void onTransitionCancel(Transition transition) {
        }

        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
            this.f2890a.setVisibility(8);
            int size = this.f2891b.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((View) this.f2891b.get(i10)).setVisibility(0);
            }
        }

        public void onTransitionPause(Transition transition) {
        }

        public void onTransitionResume(Transition transition) {
        }

        public void onTransitionStart(Transition transition) {
            transition.removeListener(this);
            transition.addListener(this);
        }
    }

    class c implements Transition.TransitionListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f2892a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f2893b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f2894c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ArrayList f2895d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Object f2896e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ ArrayList f2897f;

        c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f2892a = obj;
            this.f2893b = arrayList;
            this.f2894c = obj2;
            this.f2895d = arrayList2;
            this.f2896e = obj3;
            this.f2897f = arrayList3;
        }

        public void onTransitionCancel(Transition transition) {
        }

        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
        }

        public void onTransitionPause(Transition transition) {
        }

        public void onTransitionResume(Transition transition) {
        }

        public void onTransitionStart(Transition transition) {
            Object obj = this.f2892a;
            if (obj != null) {
                u.this.q(obj, this.f2893b, (ArrayList<View>) null);
            }
            Object obj2 = this.f2894c;
            if (obj2 != null) {
                u.this.q(obj2, this.f2895d, (ArrayList<View>) null);
            }
            Object obj3 = this.f2896e;
            if (obj3 != null) {
                u.this.q(obj3, this.f2897f, (ArrayList<View>) null);
            }
        }
    }

    class d implements Transition.TransitionListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Runnable f2899a;

        d(u uVar, Runnable runnable) {
            this.f2899a = runnable;
        }

        public void onTransitionCancel(Transition transition) {
        }

        public void onTransitionEnd(Transition transition) {
            this.f2899a.run();
        }

        public void onTransitionPause(Transition transition) {
        }

        public void onTransitionResume(Transition transition) {
        }

        public void onTransitionStart(Transition transition) {
        }
    }

    class e extends Transition.EpicenterCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Rect f2900a;

        e(u uVar, Rect rect) {
            this.f2900a = rect;
        }

        public Rect onGetEpicenter(Transition transition) {
            Rect rect = this.f2900a;
            if (rect == null || rect.isEmpty()) {
                return null;
            }
            return this.f2900a;
        }
    }

    u() {
    }

    private static boolean C(Transition transition) {
        return !v.l(transition.getTargetIds()) || !v.l(transition.getTargetNames()) || !v.l(transition.getTargetTypes());
    }

    public void A(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.getTargets().clear();
            transitionSet.getTargets().addAll(arrayList2);
            q(transitionSet, arrayList, arrayList2);
        }
    }

    public Object B(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition((Transition) obj);
        return transitionSet;
    }

    public void a(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).addTarget(view);
        }
    }

    public void b(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        if (transition != null) {
            int i10 = 0;
            if (transition instanceof TransitionSet) {
                TransitionSet transitionSet = (TransitionSet) transition;
                int transitionCount = transitionSet.getTransitionCount();
                while (i10 < transitionCount) {
                    b(transitionSet.getTransitionAt(i10), arrayList);
                    i10++;
                }
            } else if (!C(transition) && v.l(transition.getTargets())) {
                int size = arrayList.size();
                while (i10 < size) {
                    transition.addTarget(arrayList.get(i10));
                    i10++;
                }
            }
        }
    }

    public void c(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
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
            transition = new TransitionSet().addTransition(transition).addTransition(transition2).setOrdering(1);
        } else if (transition == null) {
            transition = transition2 != null ? transition2 : null;
        }
        if (transition3 == null) {
            return transition;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (transition != null) {
            transitionSet.addTransition(transition);
        }
        transitionSet.addTransition(transition3);
        return transitionSet;
    }

    public Object n(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.addTransition((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.addTransition((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.addTransition((Transition) obj3);
        }
        return transitionSet;
    }

    public void p(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).removeTarget(view);
        }
    }

    public void q(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        List<View> targets;
        Transition transition = (Transition) obj;
        int i10 = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i10 < transitionCount) {
                q(transitionSet.getTransitionAt(i10), arrayList, arrayList2);
                i10++;
            }
        } else if (!C(transition) && (targets = transition.getTargets()) != null && targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i10 < size) {
                transition.addTarget(arrayList2.get(i10));
                i10++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                transition.removeTarget(arrayList.get(size2));
            }
        }
    }

    public void r(Object obj, View view, ArrayList<View> arrayList) {
        ((Transition) obj).addListener(new b(this, view, arrayList));
    }

    public void t(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((Transition) obj).addListener(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    public void u(Object obj, Rect rect) {
        if (obj != null) {
            ((Transition) obj).setEpicenterCallback(new e(this, rect));
        }
    }

    public void v(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            k(view, rect);
            ((Transition) obj).setEpicenterCallback(new a(this, rect));
        }
    }

    public void w(Fragment fragment, Object obj, t0.b bVar, Runnable runnable) {
        ((Transition) obj).addListener(new d(this, runnable));
    }

    public void z(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            v.d(targets, arrayList.get(i10));
        }
        targets.add(view);
        arrayList.add(view);
        b(transitionSet, arrayList);
    }
}
