package androidx.core.view;

import android.os.Build;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import x0.c;
import x0.d;

public class a {

    /* renamed from: c  reason: collision with root package name */
    private static final View.AccessibilityDelegate f2290c = new View.AccessibilityDelegate();

    /* renamed from: a  reason: collision with root package name */
    private final View.AccessibilityDelegate f2291a;

    /* renamed from: b  reason: collision with root package name */
    private final View.AccessibilityDelegate f2292b;

    /* renamed from: androidx.core.view.a$a  reason: collision with other inner class name */
    static final class C0022a extends View.AccessibilityDelegate {

        /* renamed from: a  reason: collision with root package name */
        final a f2293a;

        C0022a(a aVar) {
            this.f2293a = aVar;
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f2293a.a(view, accessibilityEvent);
        }

        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            d b10 = this.f2293a.b(view);
            if (b10 != null) {
                return (AccessibilityNodeProvider) b10.e();
            }
            return null;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f2293a.f(view, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            c I0 = c.I0(accessibilityNodeInfo);
            I0.x0(x.Y(view));
            I0.m0(x.T(view));
            I0.s0(x.p(view));
            I0.D0(x.L(view));
            this.f2293a.g(view, I0);
            I0.f(accessibilityNodeInfo.getText(), view);
            List<c.a> c10 = a.c(view);
            for (int i10 = 0; i10 < c10.size(); i10++) {
                I0.b(c10.get(i10));
            }
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f2293a.h(view, accessibilityEvent);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f2293a.i(viewGroup, view, accessibilityEvent);
        }

        public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
            return this.f2293a.j(view, i10, bundle);
        }

        public void sendAccessibilityEvent(View view, int i10) {
            this.f2293a.l(view, i10);
        }

        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f2293a.m(view, accessibilityEvent);
        }
    }

    public a() {
        this(f2290c);
    }

    public a(View.AccessibilityDelegate accessibilityDelegate) {
        this.f2291a = accessibilityDelegate;
        this.f2292b = new C0022a(this);
    }

    static List<c.a> c(View view) {
        List<c.a> list = (List) view.getTag(m0.c.tag_accessibility_actions);
        return list == null ? Collections.emptyList() : list;
    }

    private boolean e(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] q10 = c.q(view.createAccessibilityNodeInfo().getText());
            int i10 = 0;
            while (q10 != null && i10 < q10.length) {
                if (clickableSpan.equals(q10[i10])) {
                    return true;
                }
                i10++;
            }
        }
        return false;
    }

    private boolean k(int i10, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(m0.c.tag_accessibility_clickable_spans);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i10)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!e(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f2291a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public d b(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        if (Build.VERSION.SDK_INT < 16 || (accessibilityNodeProvider = this.f2291a.getAccessibilityNodeProvider(view)) == null) {
            return null;
        }
        return new d(accessibilityNodeProvider);
    }

    /* access modifiers changed from: package-private */
    public View.AccessibilityDelegate d() {
        return this.f2292b;
    }

    public void f(View view, AccessibilityEvent accessibilityEvent) {
        this.f2291a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void g(View view, c cVar) {
        this.f2291a.onInitializeAccessibilityNodeInfo(view, cVar.H0());
    }

    public void h(View view, AccessibilityEvent accessibilityEvent) {
        this.f2291a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f2291a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean j(View view, int i10, Bundle bundle) {
        List<c.a> c10 = c(view);
        boolean z10 = false;
        int i11 = 0;
        while (true) {
            if (i11 >= c10.size()) {
                break;
            }
            c.a aVar = c10.get(i11);
            if (aVar.b() == i10) {
                z10 = aVar.d(view, bundle);
                break;
            }
            i11++;
        }
        if (!z10 && Build.VERSION.SDK_INT >= 16) {
            z10 = this.f2291a.performAccessibilityAction(view, i10, bundle);
        }
        return (z10 || i10 != m0.c.accessibility_action_clickable_span) ? z10 : k(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    public void l(View view, int i10) {
        this.f2291a.sendAccessibilityEvent(view, i10);
    }

    public void m(View view, AccessibilityEvent accessibilityEvent) {
        this.f2291a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }
}
