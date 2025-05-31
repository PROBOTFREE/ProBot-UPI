package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.motion.widget.s;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.c;
import androidx.constraintlayout.widget.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class t {

    /* renamed from: a  reason: collision with root package name */
    private final MotionLayout f1757a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<s> f1758b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private HashSet<View> f1759c;

    /* renamed from: d  reason: collision with root package name */
    private String f1760d = "ViewTransitionController";

    /* renamed from: e  reason: collision with root package name */
    ArrayList<s.b> f1761e;

    /* renamed from: f  reason: collision with root package name */
    ArrayList<s.b> f1762f = new ArrayList<>();

    class a implements g.a {
        a(t tVar, s sVar, int i10, boolean z10, int i11) {
        }
    }

    public t(MotionLayout motionLayout) {
        this.f1757a = motionLayout;
    }

    private void f(s sVar, boolean z10) {
        ConstraintLayout.getSharedValues().a(sVar.h(), new a(this, sVar, sVar.h(), z10, sVar.g()));
    }

    private void j(s sVar, View... viewArr) {
        int currentState = this.f1757a.getCurrentState();
        if (sVar.f1725e == 2) {
            sVar.c(this, this.f1757a, currentState, (c) null, viewArr);
        } else if (currentState == -1) {
            String str = this.f1760d;
            Log.w(str, "No support for ViewTransition within transition yet. Currently: " + this.f1757a.toString());
        } else {
            c m02 = this.f1757a.m0(currentState);
            if (m02 != null) {
                sVar.c(this, this.f1757a, currentState, m02, viewArr);
            }
        }
    }

    public void a(s sVar) {
        boolean z10;
        this.f1758b.add(sVar);
        this.f1759c = null;
        if (sVar.i() == 4) {
            z10 = true;
        } else if (sVar.i() == 5) {
            z10 = false;
        } else {
            return;
        }
        f(sVar, z10);
    }

    /* access modifiers changed from: package-private */
    public void b(s.b bVar) {
        if (this.f1761e == null) {
            this.f1761e = new ArrayList<>();
        }
        this.f1761e.add(bVar);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        ArrayList<s.b> arrayList = this.f1761e;
        if (arrayList != null) {
            Iterator<s.b> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            this.f1761e.removeAll(this.f1762f);
            this.f1762f.clear();
            if (this.f1761e.isEmpty()) {
                this.f1761e = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean d(int i10, m mVar) {
        Iterator<s> it = this.f1758b.iterator();
        while (it.hasNext()) {
            s next = it.next();
            if (next.e() == i10) {
                next.f1726f.a(mVar);
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.f1757a.invalidate();
    }

    /* access modifiers changed from: package-private */
    public void g(s.b bVar) {
        this.f1762f.add(bVar);
    }

    /* access modifiers changed from: package-private */
    public void h(MotionEvent motionEvent) {
        s sVar;
        int currentState = this.f1757a.getCurrentState();
        if (currentState != -1) {
            if (this.f1759c == null) {
                this.f1759c = new HashSet<>();
                Iterator<s> it = this.f1758b.iterator();
                while (it.hasNext()) {
                    s next = it.next();
                    int childCount = this.f1757a.getChildCount();
                    for (int i10 = 0; i10 < childCount; i10++) {
                        View childAt = this.f1757a.getChildAt(i10);
                        if (next.k(childAt)) {
                            childAt.getId();
                            this.f1759c.add(childAt);
                        }
                    }
                }
            }
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            Rect rect = new Rect();
            int action = motionEvent.getAction();
            ArrayList<s.b> arrayList = this.f1761e;
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator<s.b> it2 = this.f1761e.iterator();
                while (it2.hasNext()) {
                    it2.next().d(action, x10, y10);
                }
            }
            if (action == 0 || action == 1) {
                c m02 = this.f1757a.m0(currentState);
                Iterator<s> it3 = this.f1758b.iterator();
                while (it3.hasNext()) {
                    s next2 = it3.next();
                    if (next2.m(action)) {
                        Iterator<View> it4 = this.f1759c.iterator();
                        while (it4.hasNext()) {
                            View next3 = it4.next();
                            if (next2.k(next3)) {
                                next3.getHitRect(rect);
                                if (rect.contains((int) x10, (int) y10)) {
                                    sVar = next2;
                                    next2.c(this, this.f1757a, currentState, m02, next3);
                                } else {
                                    sVar = next2;
                                }
                                next2 = sVar;
                            }
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void i(int i10, View... viewArr) {
        ArrayList arrayList = new ArrayList();
        Iterator<s> it = this.f1758b.iterator();
        s sVar = null;
        while (it.hasNext()) {
            s next = it.next();
            if (next.e() == i10) {
                for (View view : viewArr) {
                    if (next.d(view)) {
                        arrayList.add(view);
                    }
                }
                if (!arrayList.isEmpty()) {
                    j(next, (View[]) arrayList.toArray(new View[0]));
                    arrayList.clear();
                }
                sVar = next;
            }
        }
        if (sVar == null) {
            Log.e(this.f1760d, " Could not find ViewTransition");
        }
    }
}
