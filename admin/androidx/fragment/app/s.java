package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.x;
import androidx.lifecycle.h;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public abstract class s {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<a> f2821a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    int f2822b;

    /* renamed from: c  reason: collision with root package name */
    int f2823c;

    /* renamed from: d  reason: collision with root package name */
    int f2824d;

    /* renamed from: e  reason: collision with root package name */
    int f2825e;

    /* renamed from: f  reason: collision with root package name */
    int f2826f;

    /* renamed from: g  reason: collision with root package name */
    boolean f2827g;

    /* renamed from: h  reason: collision with root package name */
    boolean f2828h = true;

    /* renamed from: i  reason: collision with root package name */
    String f2829i;

    /* renamed from: j  reason: collision with root package name */
    int f2830j;

    /* renamed from: k  reason: collision with root package name */
    CharSequence f2831k;

    /* renamed from: l  reason: collision with root package name */
    int f2832l;

    /* renamed from: m  reason: collision with root package name */
    CharSequence f2833m;

    /* renamed from: n  reason: collision with root package name */
    ArrayList<String> f2834n;

    /* renamed from: o  reason: collision with root package name */
    ArrayList<String> f2835o;

    /* renamed from: p  reason: collision with root package name */
    boolean f2836p = false;

    /* renamed from: q  reason: collision with root package name */
    ArrayList<Runnable> f2837q;

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        int f2838a;

        /* renamed from: b  reason: collision with root package name */
        Fragment f2839b;

        /* renamed from: c  reason: collision with root package name */
        int f2840c;

        /* renamed from: d  reason: collision with root package name */
        int f2841d;

        /* renamed from: e  reason: collision with root package name */
        int f2842e;

        /* renamed from: f  reason: collision with root package name */
        int f2843f;

        /* renamed from: g  reason: collision with root package name */
        h.c f2844g;

        /* renamed from: h  reason: collision with root package name */
        h.c f2845h;

        a() {
        }

        a(int i10, Fragment fragment) {
            this.f2838a = i10;
            this.f2839b = fragment;
            h.c cVar = h.c.RESUMED;
            this.f2844g = cVar;
            this.f2845h = cVar;
        }

        a(int i10, Fragment fragment, h.c cVar) {
            this.f2838a = i10;
            this.f2839b = fragment;
            this.f2844g = fragment.mMaxState;
            this.f2845h = cVar;
        }
    }

    s(g gVar, ClassLoader classLoader) {
    }

    public s b(int i10, Fragment fragment) {
        p(i10, fragment, (String) null, 1);
        return this;
    }

    public s c(int i10, Fragment fragment, String str) {
        p(i10, fragment, str, 1);
        return this;
    }

    /* access modifiers changed from: package-private */
    public s d(ViewGroup viewGroup, Fragment fragment, String str) {
        fragment.mContainer = viewGroup;
        return c(viewGroup.getId(), fragment, str);
    }

    public s e(Fragment fragment, String str) {
        p(0, fragment, str, 1);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void f(a aVar) {
        this.f2821a.add(aVar);
        aVar.f2840c = this.f2822b;
        aVar.f2841d = this.f2823c;
        aVar.f2842e = this.f2824d;
        aVar.f2843f = this.f2825e;
    }

    public s g(View view, String str) {
        if (t.C()) {
            String M = x.M(view);
            if (M != null) {
                if (this.f2834n == null) {
                    this.f2834n = new ArrayList<>();
                    this.f2835o = new ArrayList<>();
                } else if (this.f2835o.contains(str)) {
                    throw new IllegalArgumentException("A shared element with the target name '" + str + "' has already been added to the transaction.");
                } else if (this.f2834n.contains(M)) {
                    throw new IllegalArgumentException("A shared element with the source name '" + M + "' has already been added to the transaction.");
                }
                this.f2834n.add(M);
                this.f2835o.add(str);
            } else {
                throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
            }
        }
        return this;
    }

    public s h(String str) {
        if (this.f2828h) {
            this.f2827g = true;
            this.f2829i = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    public s i(Fragment fragment) {
        f(new a(7, fragment));
        return this;
    }

    public abstract int j();

    public abstract int k();

    public abstract void l();

    public abstract void m();

    public s n(Fragment fragment) {
        f(new a(6, fragment));
        return this;
    }

    public s o() {
        if (!this.f2827g) {
            this.f2828h = false;
            return this;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    /* access modifiers changed from: package-private */
    public void p(int i10, Fragment fragment, String str, int i11) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str2 = fragment.mTag;
            if (str2 == null || str.equals(str2)) {
                fragment.mTag = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
        }
        if (i10 != 0) {
            if (i10 != -1) {
                int i12 = fragment.mFragmentId;
                if (i12 == 0 || i12 == i10) {
                    fragment.mFragmentId = i10;
                    fragment.mContainerId = i10;
                } else {
                    throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i10);
                }
            } else {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
        }
        f(new a(i11, fragment));
    }

    public s q(Fragment fragment) {
        f(new a(3, fragment));
        return this;
    }

    public s r(int i10, Fragment fragment) {
        return s(i10, fragment, (String) null);
    }

    public s s(int i10, Fragment fragment, String str) {
        if (i10 != 0) {
            p(i10, fragment, str, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    public s t(int i10, int i11, int i12, int i13) {
        this.f2822b = i10;
        this.f2823c = i11;
        this.f2824d = i12;
        this.f2825e = i13;
        return this;
    }

    public s u(Fragment fragment, h.c cVar) {
        f(new a(10, fragment, cVar));
        return this;
    }

    public s v(Fragment fragment) {
        f(new a(8, fragment));
        return this;
    }

    public s w(boolean z10) {
        this.f2836p = z10;
        return this;
    }
}
