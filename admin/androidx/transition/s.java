package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class s {

    /* renamed from: a  reason: collision with root package name */
    private static Transition f4151a = new AutoTransition();

    /* renamed from: b  reason: collision with root package name */
    private static ThreadLocal<WeakReference<c0.a<ViewGroup, ArrayList<Transition>>>> f4152b = new ThreadLocal<>();

    /* renamed from: c  reason: collision with root package name */
    static ArrayList<ViewGroup> f4153c = new ArrayList<>();

    private static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        Transition f4154a;

        /* renamed from: b  reason: collision with root package name */
        ViewGroup f4155b;

        /* renamed from: androidx.transition.s$a$a  reason: collision with other inner class name */
        class C0046a extends r {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c0.a f4156a;

            C0046a(c0.a aVar) {
                this.f4156a = aVar;
            }

            public void e(Transition transition) {
                ((ArrayList) this.f4156a.get(a.this.f4155b)).remove(transition);
                transition.d0(this);
            }
        }

        a(Transition transition, ViewGroup viewGroup) {
            this.f4154a = transition;
            this.f4155b = viewGroup;
        }

        private void a() {
            this.f4155b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f4155b.removeOnAttachStateChangeListener(this);
        }

        public boolean onPreDraw() {
            a();
            if (!s.f4153c.remove(this.f4155b)) {
                return true;
            }
            c0.a<ViewGroup, ArrayList<Transition>> b10 = s.b();
            ArrayList arrayList = b10.get(this.f4155b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                b10.put(this.f4155b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f4154a);
            this.f4154a.a(new C0046a(b10));
            this.f4154a.p(this.f4155b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((Transition) it.next()).f0(this.f4155b);
                }
            }
            this.f4154a.b0(this.f4155b);
            return true;
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            a();
            s.f4153c.remove(this.f4155b);
            ArrayList arrayList = s.b().get(this.f4155b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((Transition) it.next()).f0(this.f4155b);
                }
            }
            this.f4154a.q(true);
        }
    }

    public static void a(ViewGroup viewGroup, Transition transition) {
        if (!f4153c.contains(viewGroup) && x.V(viewGroup)) {
            f4153c.add(viewGroup);
            if (transition == null) {
                transition = f4151a;
            }
            Transition r10 = transition.clone();
            d(viewGroup, r10);
            p.c(viewGroup, (p) null);
            c(viewGroup, r10);
        }
    }

    static c0.a<ViewGroup, ArrayList<Transition>> b() {
        c0.a<ViewGroup, ArrayList<Transition>> aVar;
        WeakReference weakReference = f4152b.get();
        if (weakReference != null && (aVar = (c0.a) weakReference.get()) != null) {
            return aVar;
        }
        c0.a<ViewGroup, ArrayList<Transition>> aVar2 = new c0.a<>();
        f4152b.set(new WeakReference(aVar2));
        return aVar2;
    }

    private static void c(ViewGroup viewGroup, Transition transition) {
        if (transition != null && viewGroup != null) {
            a aVar = new a(transition, viewGroup);
            viewGroup.addOnAttachStateChangeListener(aVar);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
        }
    }

    private static void d(ViewGroup viewGroup, Transition transition) {
        ArrayList arrayList = b().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((Transition) it.next()).a0(viewGroup);
            }
        }
        if (transition != null) {
            transition.p(viewGroup, true);
        }
        p b10 = p.b(viewGroup);
        if (b10 != null) {
            b10.a();
        }
    }
}
