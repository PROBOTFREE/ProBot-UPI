package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.x;
import java.util.Map;
import java.util.WeakHashMap;
import x0.c;
import x0.d;

public class u extends androidx.core.view.a {

    /* renamed from: d  reason: collision with root package name */
    final RecyclerView f3696d;

    /* renamed from: e  reason: collision with root package name */
    private final a f3697e;

    public static class a extends androidx.core.view.a {

        /* renamed from: d  reason: collision with root package name */
        final u f3698d;

        /* renamed from: e  reason: collision with root package name */
        private Map<View, androidx.core.view.a> f3699e = new WeakHashMap();

        public a(u uVar) {
            this.f3698d = uVar;
        }

        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            androidx.core.view.a aVar = this.f3699e.get(view);
            return aVar != null ? aVar.a(view, accessibilityEvent) : super.a(view, accessibilityEvent);
        }

        public d b(View view) {
            androidx.core.view.a aVar = this.f3699e.get(view);
            return aVar != null ? aVar.b(view) : super.b(view);
        }

        public void f(View view, AccessibilityEvent accessibilityEvent) {
            androidx.core.view.a aVar = this.f3699e.get(view);
            if (aVar != null) {
                aVar.f(view, accessibilityEvent);
            } else {
                super.f(view, accessibilityEvent);
            }
        }

        public void g(View view, c cVar) {
            if (!this.f3698d.o() && this.f3698d.f3696d.getLayoutManager() != null) {
                this.f3698d.f3696d.getLayoutManager().Z0(view, cVar);
                androidx.core.view.a aVar = this.f3699e.get(view);
                if (aVar != null) {
                    aVar.g(view, cVar);
                    return;
                }
            }
            super.g(view, cVar);
        }

        public void h(View view, AccessibilityEvent accessibilityEvent) {
            androidx.core.view.a aVar = this.f3699e.get(view);
            if (aVar != null) {
                aVar.h(view, accessibilityEvent);
            } else {
                super.h(view, accessibilityEvent);
            }
        }

        public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            androidx.core.view.a aVar = this.f3699e.get(viewGroup);
            return aVar != null ? aVar.i(viewGroup, view, accessibilityEvent) : super.i(viewGroup, view, accessibilityEvent);
        }

        public boolean j(View view, int i10, Bundle bundle) {
            if (this.f3698d.o() || this.f3698d.f3696d.getLayoutManager() == null) {
                return super.j(view, i10, bundle);
            }
            androidx.core.view.a aVar = this.f3699e.get(view);
            if (aVar != null) {
                if (aVar.j(view, i10, bundle)) {
                    return true;
                }
            } else if (super.j(view, i10, bundle)) {
                return true;
            }
            return this.f3698d.f3696d.getLayoutManager().t1(view, i10, bundle);
        }

        public void l(View view, int i10) {
            androidx.core.view.a aVar = this.f3699e.get(view);
            if (aVar != null) {
                aVar.l(view, i10);
            } else {
                super.l(view, i10);
            }
        }

        public void m(View view, AccessibilityEvent accessibilityEvent) {
            androidx.core.view.a aVar = this.f3699e.get(view);
            if (aVar != null) {
                aVar.m(view, accessibilityEvent);
            } else {
                super.m(view, accessibilityEvent);
            }
        }

        /* access modifiers changed from: package-private */
        public androidx.core.view.a n(View view) {
            return this.f3699e.remove(view);
        }

        /* access modifiers changed from: package-private */
        public void o(View view) {
            androidx.core.view.a l10 = x.l(view);
            if (l10 != null && l10 != this) {
                this.f3699e.put(view, l10);
            }
        }
    }

    public u(RecyclerView recyclerView) {
        this.f3696d = recyclerView;
        androidx.core.view.a n10 = n();
        this.f3697e = (n10 == null || !(n10 instanceof a)) ? new a(this) : (a) n10;
    }

    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        if ((view instanceof RecyclerView) && !o()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().V0(accessibilityEvent);
            }
        }
    }

    public void g(View view, c cVar) {
        super.g(view, cVar);
        if (!o() && this.f3696d.getLayoutManager() != null) {
            this.f3696d.getLayoutManager().Y0(cVar);
        }
    }

    public boolean j(View view, int i10, Bundle bundle) {
        if (super.j(view, i10, bundle)) {
            return true;
        }
        if (o() || this.f3696d.getLayoutManager() == null) {
            return false;
        }
        return this.f3696d.getLayoutManager().r1(i10, bundle);
    }

    public androidx.core.view.a n() {
        return this.f3697e;
    }

    /* access modifiers changed from: package-private */
    public boolean o() {
        return this.f3696d.n0();
    }
}
