package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.h;
import androidx.lifecycle.m;
import androidx.lifecycle.o;
import androidx.savedstate.SavedStateRegistry;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@SuppressLint({"RestrictedApi"})
final class Recreator implements m {

    /* renamed from: a  reason: collision with root package name */
    private final c f3833a;

    static final class a implements SavedStateRegistry.b {

        /* renamed from: a  reason: collision with root package name */
        final Set<String> f3834a = new HashSet();

        a(SavedStateRegistry savedStateRegistry) {
            savedStateRegistry.d("androidx.savedstate.Restarter", this);
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList(this.f3834a));
            return bundle;
        }

        /* access modifiers changed from: package-private */
        public void b(String str) {
            this.f3834a.add(str);
        }
    }

    Recreator(c cVar) {
        this.f3833a = cVar;
    }

    private void d(String str) {
        try {
            Class<? extends U> asSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(SavedStateRegistry.a.class);
            try {
                Constructor<? extends U> declaredConstructor = asSubclass.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                try {
                    ((SavedStateRegistry.a) declaredConstructor.newInstance(new Object[0])).a(this.f3833a);
                } catch (Exception e10) {
                    throw new RuntimeException("Failed to instantiate " + str, e10);
                }
            } catch (NoSuchMethodException e11) {
                throw new IllegalStateException("Class" + asSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e11);
            }
        } catch (ClassNotFoundException e12) {
            throw new RuntimeException("Class " + str + " wasn't found", e12);
        }
    }

    public void c(o oVar, h.b bVar) {
        if (bVar == h.b.ON_CREATE) {
            oVar.getLifecycle().c(this);
            Bundle a10 = this.f3833a.getSavedStateRegistry().a("androidx.savedstate.Restarter");
            if (a10 != null) {
                ArrayList<String> stringArrayList = a10.getStringArrayList("classes_to_restore");
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        d(it.next());
                    }
                    return;
                }
                throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
            }
            return;
        }
        throw new AssertionError("Next event must be ON_CREATE");
    }
}
