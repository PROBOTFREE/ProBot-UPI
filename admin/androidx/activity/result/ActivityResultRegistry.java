package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.h;
import androidx.lifecycle.m;
import androidx.lifecycle.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public abstract class ActivityResultRegistry {

    /* renamed from: a  reason: collision with root package name */
    private Random f198a = new Random();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Integer, String> f199b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    final Map<String, Integer> f200c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, d> f201d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    ArrayList<String> f202e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    final transient Map<String, c<?>> f203f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    final Map<String, Object> f204g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    final Bundle f205h = new Bundle();

    class a extends b<I> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f210a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f211b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ i.a f212c;

        a(String str, int i10, i.a aVar) {
            this.f210a = str;
            this.f211b = i10;
            this.f212c = aVar;
        }

        public void b(I i10, androidx.core.app.b bVar) {
            ActivityResultRegistry.this.f202e.add(this.f210a);
            Integer num = ActivityResultRegistry.this.f200c.get(this.f210a);
            ActivityResultRegistry.this.f(num != null ? num.intValue() : this.f211b, this.f212c, i10, bVar);
        }

        public void c() {
            ActivityResultRegistry.this.l(this.f210a);
        }
    }

    class b extends b<I> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f214a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f215b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ i.a f216c;

        b(String str, int i10, i.a aVar) {
            this.f214a = str;
            this.f215b = i10;
            this.f216c = aVar;
        }

        public void b(I i10, androidx.core.app.b bVar) {
            ActivityResultRegistry.this.f202e.add(this.f214a);
            Integer num = ActivityResultRegistry.this.f200c.get(this.f214a);
            ActivityResultRegistry.this.f(num != null ? num.intValue() : this.f215b, this.f216c, i10, bVar);
        }

        public void c() {
            ActivityResultRegistry.this.l(this.f214a);
        }
    }

    private static class c<O> {

        /* renamed from: a  reason: collision with root package name */
        final a<O> f218a;

        /* renamed from: b  reason: collision with root package name */
        final i.a<?, O> f219b;

        c(a<O> aVar, i.a<?, O> aVar2) {
            this.f218a = aVar;
            this.f219b = aVar2;
        }
    }

    private static class d {

        /* renamed from: a  reason: collision with root package name */
        final h f220a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList<m> f221b = new ArrayList<>();

        d(h hVar) {
            this.f220a = hVar;
        }

        /* access modifiers changed from: package-private */
        public void a(m mVar) {
            this.f220a.a(mVar);
            this.f221b.add(mVar);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            Iterator<m> it = this.f221b.iterator();
            while (it.hasNext()) {
                this.f220a.c(it.next());
            }
            this.f221b.clear();
        }
    }

    private void a(int i10, String str) {
        this.f199b.put(Integer.valueOf(i10), str);
        this.f200c.put(str, Integer.valueOf(i10));
    }

    private <O> void d(String str, int i10, Intent intent, c<O> cVar) {
        a<O> aVar;
        if (cVar == null || (aVar = cVar.f218a) == null) {
            this.f204g.remove(str);
            this.f205h.putParcelable(str, new ActivityResult(i10, intent));
            return;
        }
        aVar.onActivityResult(cVar.f219b.c(i10, intent));
    }

    private int e() {
        int nextInt = this.f198a.nextInt(2147418112);
        while (true) {
            int i10 = nextInt + 65536;
            if (!this.f199b.containsKey(Integer.valueOf(i10))) {
                return i10;
            }
            nextInt = this.f198a.nextInt(2147418112);
        }
    }

    private int k(String str) {
        Integer num = this.f200c.get(str);
        if (num != null) {
            return num.intValue();
        }
        int e10 = e();
        a(e10, str);
        return e10;
    }

    public final boolean b(int i10, int i11, Intent intent) {
        String str = this.f199b.get(Integer.valueOf(i10));
        if (str == null) {
            return false;
        }
        this.f202e.remove(str);
        d(str, i11, intent, this.f203f.get(str));
        return true;
    }

    public final <O> boolean c(int i10, @SuppressLint({"UnknownNullness"}) O o10) {
        a<O> aVar;
        String str = this.f199b.get(Integer.valueOf(i10));
        if (str == null) {
            return false;
        }
        this.f202e.remove(str);
        c cVar = this.f203f.get(str);
        if (cVar == null || (aVar = cVar.f218a) == null) {
            this.f205h.remove(str);
            this.f204g.put(str, o10);
            return true;
        }
        aVar.onActivityResult(o10);
        return true;
    }

    public abstract <I, O> void f(int i10, i.a<I, O> aVar, @SuppressLint({"UnknownNullness"}) I i11, androidx.core.app.b bVar);

    public final void g(Bundle bundle) {
        if (bundle != null) {
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
            ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
            if (stringArrayList != null && integerArrayList != null) {
                this.f202e = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                this.f198a = (Random) bundle.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
                this.f205h.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
                for (int i10 = 0; i10 < stringArrayList.size(); i10++) {
                    String str = stringArrayList.get(i10);
                    if (this.f200c.containsKey(str)) {
                        Integer remove = this.f200c.remove(str);
                        if (!this.f205h.containsKey(str)) {
                            this.f199b.remove(remove);
                        }
                    }
                    a(integerArrayList.get(i10).intValue(), stringArrayList.get(i10));
                }
            }
        }
    }

    public final void h(Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList(this.f200c.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList(this.f200c.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList(this.f202e));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.f205h.clone());
        bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", this.f198a);
    }

    public final <I, O> b<I> i(final String str, o oVar, final i.a<I, O> aVar, final a<O> aVar2) {
        h lifecycle = oVar.getLifecycle();
        if (!lifecycle.b().a(h.c.STARTED)) {
            int k10 = k(str);
            d dVar = this.f201d.get(str);
            if (dVar == null) {
                dVar = new d(lifecycle);
            }
            dVar.a(new m() {
                public void c(o oVar, h.b bVar) {
                    if (h.b.ON_START.equals(bVar)) {
                        ActivityResultRegistry.this.f203f.put(str, new c(aVar2, aVar));
                        if (ActivityResultRegistry.this.f204g.containsKey(str)) {
                            Object obj = ActivityResultRegistry.this.f204g.get(str);
                            ActivityResultRegistry.this.f204g.remove(str);
                            aVar2.onActivityResult(obj);
                        }
                        ActivityResult activityResult = (ActivityResult) ActivityResultRegistry.this.f205h.getParcelable(str);
                        if (activityResult != null) {
                            ActivityResultRegistry.this.f205h.remove(str);
                            aVar2.onActivityResult(aVar.c(activityResult.b(), activityResult.a()));
                        }
                    } else if (h.b.ON_STOP.equals(bVar)) {
                        ActivityResultRegistry.this.f203f.remove(str);
                    } else if (h.b.ON_DESTROY.equals(bVar)) {
                        ActivityResultRegistry.this.l(str);
                    }
                }
            });
            this.f201d.put(str, dVar);
            return new a(str, k10, aVar);
        }
        throw new IllegalStateException("LifecycleOwner " + oVar + " is attempting to register while current state is " + lifecycle.b() + ". LifecycleOwners must call register before they are STARTED.");
    }

    public final <I, O> b<I> j(String str, i.a<I, O> aVar, a<O> aVar2) {
        int k10 = k(str);
        this.f203f.put(str, new c(aVar2, aVar));
        if (this.f204g.containsKey(str)) {
            Object obj = this.f204g.get(str);
            this.f204g.remove(str);
            aVar2.onActivityResult(obj);
        }
        ActivityResult activityResult = (ActivityResult) this.f205h.getParcelable(str);
        if (activityResult != null) {
            this.f205h.remove(str);
            aVar2.onActivityResult(aVar.c(activityResult.b(), activityResult.a()));
        }
        return new b(str, k10, aVar);
    }

    /* access modifiers changed from: package-private */
    public final void l(String str) {
        Integer remove;
        if (!this.f202e.contains(str) && (remove = this.f200c.remove(str)) != null) {
            this.f199b.remove(remove);
        }
        this.f203f.remove(str);
        if (this.f204g.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f204g.get(str));
            this.f204g.remove(str);
        }
        if (this.f205h.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f205h.getParcelable(str));
            this.f205h.remove(str);
        }
        d dVar = this.f201d.get(str);
        if (dVar != null) {
            dVar.b();
            this.f201d.remove(str);
        }
    }
}
