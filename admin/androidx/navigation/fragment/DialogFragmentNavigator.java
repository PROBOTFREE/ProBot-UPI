package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.c;
import androidx.lifecycle.h;
import androidx.lifecycle.m;
import androidx.lifecycle.o;
import androidx.navigation.b;
import androidx.navigation.i;
import androidx.navigation.n;
import androidx.navigation.q;
import java.util.HashSet;

@q.b("dialog")
public final class DialogFragmentNavigator extends q<a> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f3140a;

    /* renamed from: b  reason: collision with root package name */
    private final FragmentManager f3141b;

    /* renamed from: c  reason: collision with root package name */
    private int f3142c = 0;

    /* renamed from: d  reason: collision with root package name */
    private final HashSet<String> f3143d = new HashSet<>();

    /* renamed from: e  reason: collision with root package name */
    private m f3144e = new m(this) {
        public void c(o oVar, h.b bVar) {
            if (bVar == h.b.ON_STOP) {
                c cVar = (c) oVar;
                if (!cVar.requireDialog().isShowing()) {
                    NavHostFragment.i(cVar).q();
                }
            }
        }
    };

    public static class a extends i implements b {

        /* renamed from: i  reason: collision with root package name */
        private String f3145i;

        public a(q<? extends a> qVar) {
            super((q<? extends i>) qVar);
        }

        public void A(Context context, AttributeSet attributeSet) {
            super.A(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, c.DialogFragmentNavigator);
            String string = obtainAttributes.getString(c.DialogFragmentNavigator_android_name);
            if (string != null) {
                H(string);
            }
            obtainAttributes.recycle();
        }

        public final String G() {
            String str = this.f3145i;
            if (str != null) {
                return str;
            }
            throw new IllegalStateException("DialogFragment class was not set");
        }

        public final a H(String str) {
            this.f3145i = str;
            return this;
        }
    }

    public DialogFragmentNavigator(Context context, FragmentManager fragmentManager) {
        this.f3140a = context;
        this.f3141b = fragmentManager;
    }

    public void c(Bundle bundle) {
        if (bundle != null) {
            this.f3142c = bundle.getInt("androidx-nav-dialogfragment:navigator:count", 0);
            for (int i10 = 0; i10 < this.f3142c; i10++) {
                FragmentManager fragmentManager = this.f3141b;
                c cVar = (c) fragmentManager.j0("androidx-nav-fragment:navigator:dialog:" + i10);
                if (cVar != null) {
                    cVar.getLifecycle().a(this.f3144e);
                } else {
                    HashSet<String> hashSet = this.f3143d;
                    hashSet.add("androidx-nav-fragment:navigator:dialog:" + i10);
                }
            }
        }
    }

    public Bundle d() {
        if (this.f3142c == 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("androidx-nav-dialogfragment:navigator:count", this.f3142c);
        return bundle;
    }

    public boolean e() {
        if (this.f3142c == 0) {
            return false;
        }
        if (this.f3141b.M0()) {
            Log.i("DialogFragmentNavigator", "Ignoring popBackStack() call: FragmentManager has already saved its state");
            return false;
        }
        FragmentManager fragmentManager = this.f3141b;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("androidx-nav-fragment:navigator:dialog:");
        int i10 = this.f3142c - 1;
        this.f3142c = i10;
        sb2.append(i10);
        Fragment j02 = fragmentManager.j0(sb2.toString());
        if (j02 != null) {
            j02.getLifecycle().c(this.f3144e);
            ((c) j02).dismiss();
        }
        return true;
    }

    /* renamed from: f */
    public a a() {
        return new a(this);
    }

    /* renamed from: g */
    public i b(a aVar, Bundle bundle, n nVar, q.a aVar2) {
        if (this.f3141b.M0()) {
            Log.i("DialogFragmentNavigator", "Ignoring navigate() call: FragmentManager has already saved its state");
            return null;
        }
        String G = aVar.G();
        if (G.charAt(0) == '.') {
            G = this.f3140a.getPackageName() + G;
        }
        Fragment instantiate = this.f3141b.s0().instantiate(this.f3140a.getClassLoader(), G);
        if (c.class.isAssignableFrom(instantiate.getClass())) {
            c cVar = (c) instantiate;
            cVar.setArguments(bundle);
            cVar.getLifecycle().a(this.f3144e);
            FragmentManager fragmentManager = this.f3141b;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("androidx-nav-fragment:navigator:dialog:");
            int i10 = this.f3142c;
            this.f3142c = i10 + 1;
            sb2.append(i10);
            cVar.show(fragmentManager, sb2.toString());
            return aVar;
        }
        throw new IllegalArgumentException("Dialog destination " + aVar.G() + " is not an instance of DialogFragment");
    }

    /* access modifiers changed from: package-private */
    public void h(Fragment fragment) {
        if (this.f3143d.remove(fragment.getTag())) {
            fragment.getLifecycle().a(this.f3144e);
        }
    }
}
