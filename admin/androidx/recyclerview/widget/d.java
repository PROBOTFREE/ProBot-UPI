package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.h;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

public class d<T> {

    /* renamed from: h  reason: collision with root package name */
    private static final Executor f3482h = new c();

    /* renamed from: a  reason: collision with root package name */
    private final q f3483a;

    /* renamed from: b  reason: collision with root package name */
    final c<T> f3484b;

    /* renamed from: c  reason: collision with root package name */
    Executor f3485c;

    /* renamed from: d  reason: collision with root package name */
    private final List<b<T>> f3486d = new CopyOnWriteArrayList();

    /* renamed from: e  reason: collision with root package name */
    private List<T> f3487e;

    /* renamed from: f  reason: collision with root package name */
    private List<T> f3488f = Collections.emptyList();

    /* renamed from: g  reason: collision with root package name */
    int f3489g;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f3490a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f3491b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f3492c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Runnable f3493d;

        /* renamed from: androidx.recyclerview.widget.d$a$a  reason: collision with other inner class name */
        class C0035a extends h.b {
            C0035a() {
            }

            public boolean a(int i10, int i11) {
                Object obj = a.this.f3490a.get(i10);
                Object obj2 = a.this.f3491b.get(i11);
                if (obj != null && obj2 != null) {
                    return d.this.f3484b.b().areContentsTheSame(obj, obj2);
                }
                if (obj == null && obj2 == null) {
                    return true;
                }
                throw new AssertionError();
            }

            public boolean b(int i10, int i11) {
                Object obj = a.this.f3490a.get(i10);
                Object obj2 = a.this.f3491b.get(i11);
                return (obj == null || obj2 == null) ? obj == null && obj2 == null : d.this.f3484b.b().areItemsTheSame(obj, obj2);
            }

            public Object c(int i10, int i11) {
                Object obj = a.this.f3490a.get(i10);
                Object obj2 = a.this.f3491b.get(i11);
                if (obj != null && obj2 != null) {
                    return d.this.f3484b.b().getChangePayload(obj, obj2);
                }
                throw new AssertionError();
            }

            public int d() {
                return a.this.f3491b.size();
            }

            public int e() {
                return a.this.f3490a.size();
            }
        }

        class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ h.e f3496a;

            b(h.e eVar) {
                this.f3496a = eVar;
            }

            public void run() {
                a aVar = a.this;
                d dVar = d.this;
                if (dVar.f3489g == aVar.f3492c) {
                    dVar.c(aVar.f3491b, this.f3496a, aVar.f3493d);
                }
            }
        }

        a(List list, List list2, int i10, Runnable runnable) {
            this.f3490a = list;
            this.f3491b = list2;
            this.f3492c = i10;
            this.f3493d = runnable;
        }

        public void run() {
            d.this.f3485c.execute(new b(h.b(new C0035a())));
        }
    }

    public interface b<T> {
        void a(List<T> list, List<T> list2);
    }

    private static class c implements Executor {

        /* renamed from: a  reason: collision with root package name */
        final Handler f3498a = new Handler(Looper.getMainLooper());

        c() {
        }

        public void execute(Runnable runnable) {
            this.f3498a.post(runnable);
        }
    }

    public d(q qVar, c<T> cVar) {
        this.f3483a = qVar;
        this.f3484b = cVar;
        this.f3485c = cVar.c() != null ? cVar.c() : f3482h;
    }

    private void d(List<T> list, Runnable runnable) {
        for (b<T> a10 : this.f3486d) {
            a10.a(list, this.f3488f);
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public void a(b<T> bVar) {
        this.f3486d.add(bVar);
    }

    public List<T> b() {
        return this.f3488f;
    }

    /* access modifiers changed from: package-private */
    public void c(List<T> list, h.e eVar, Runnable runnable) {
        List<T> list2 = this.f3488f;
        this.f3487e = list;
        this.f3488f = Collections.unmodifiableList(list);
        eVar.b(this.f3483a);
        d(list2, runnable);
    }

    public void e(List<T> list) {
        f(list, (Runnable) null);
    }

    public void f(List<T> list, Runnable runnable) {
        int i10 = this.f3489g + 1;
        this.f3489g = i10;
        List<T> list2 = this.f3487e;
        if (list != list2) {
            List<T> list3 = this.f3488f;
            if (list == null) {
                int size = list2.size();
                this.f3487e = null;
                this.f3488f = Collections.emptyList();
                this.f3483a.a(0, size);
                d(list3, runnable);
            } else if (list2 == null) {
                this.f3487e = list;
                this.f3488f = Collections.unmodifiableList(list);
                this.f3483a.c(0, list.size());
                d(list3, runnable);
            } else {
                this.f3484b.a().execute(new a(list2, list, i10, runnable));
            }
        } else if (runnable != null) {
            runnable.run();
        }
    }
}
