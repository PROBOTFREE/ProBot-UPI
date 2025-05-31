package androidx.work.impl.workers;

import a2.h;
import android.content.Context;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import b2.i;
import e2.c;
import e2.d;
import i2.p;
import java.util.Collections;
import java.util.List;

public class ConstraintTrackingWorker extends ListenableWorker implements c {

    /* renamed from: k  reason: collision with root package name */
    private static final String f4624k = h.f("ConstraintTrkngWrkr");

    /* renamed from: f  reason: collision with root package name */
    private WorkerParameters f4625f;

    /* renamed from: g  reason: collision with root package name */
    final Object f4626g = new Object();

    /* renamed from: h  reason: collision with root package name */
    volatile boolean f4627h = false;

    /* renamed from: i  reason: collision with root package name */
    androidx.work.impl.utils.futures.c<ListenableWorker.a> f4628i = androidx.work.impl.utils.futures.c.t();

    /* renamed from: j  reason: collision with root package name */
    private ListenableWorker f4629j;

    class a implements Runnable {
        a() {
        }

        public void run() {
            ConstraintTrackingWorker.this.u();
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e7.a f4631a;

        b(e7.a aVar) {
            this.f4631a = aVar;
        }

        public void run() {
            synchronized (ConstraintTrackingWorker.this.f4626g) {
                if (ConstraintTrackingWorker.this.f4627h) {
                    ConstraintTrackingWorker.this.t();
                } else {
                    ConstraintTrackingWorker.this.f4628i.r(this.f4631a);
                }
            }
        }
    }

    public ConstraintTrackingWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.f4625f = workerParameters;
    }

    public void d(List<String> list) {
        h.c().a(f4624k, String.format("Constraints changed for %s", new Object[]{list}), new Throwable[0]);
        synchronized (this.f4626g) {
            this.f4627h = true;
        }
    }

    public void e(List<String> list) {
    }

    public k2.a h() {
        return i.j(a()).o();
    }

    public boolean j() {
        ListenableWorker listenableWorker = this.f4629j;
        return listenableWorker != null && listenableWorker.j();
    }

    public void m() {
        super.m();
        ListenableWorker listenableWorker = this.f4629j;
        if (listenableWorker != null && !listenableWorker.k()) {
            this.f4629j.q();
        }
    }

    public e7.a<ListenableWorker.a> p() {
        b().execute(new a());
        return this.f4628i;
    }

    public WorkDatabase r() {
        return i.j(a()).n();
    }

    /* access modifiers changed from: package-private */
    public void s() {
        this.f4628i.p(ListenableWorker.a.a());
    }

    /* access modifiers changed from: package-private */
    public void t() {
        this.f4628i.p(ListenableWorker.a.b());
    }

    /* access modifiers changed from: package-private */
    public void u() {
        String i10 = g().i("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
        if (TextUtils.isEmpty(i10)) {
            h.c().b(f4624k, "No worker to delegate to.", new Throwable[0]);
        } else {
            ListenableWorker b10 = i().b(a(), i10, this.f4625f);
            this.f4629j = b10;
            if (b10 == null) {
                h.c().a(f4624k, "No worker to delegate to.", new Throwable[0]);
            } else {
                p k10 = r().B().k(f().toString());
                if (k10 == null) {
                    s();
                    return;
                }
                d dVar = new d(a(), h(), this);
                dVar.d(Collections.singletonList(k10));
                if (dVar.c(f().toString())) {
                    h.c().a(f4624k, String.format("Constraints met for delegate %s", new Object[]{i10}), new Throwable[0]);
                    try {
                        e7.a<ListenableWorker.a> p10 = this.f4629j.p();
                        p10.a(new b(p10), b());
                        return;
                    } catch (Throwable th) {
                        h c10 = h.c();
                        String str = f4624k;
                        c10.a(str, String.format("Delegated worker %s threw exception in startWork.", new Object[]{i10}), th);
                        synchronized (this.f4626g) {
                            if (this.f4627h) {
                                h.c().a(str, "Constraints were unmet, Retrying.", new Throwable[0]);
                                t();
                            } else {
                                s();
                            }
                            return;
                        }
                    }
                } else {
                    h.c().a(f4624k, String.format("Constraints not met for delegate %s. Requesting retry.", new Object[]{i10}), new Throwable[0]);
                    t();
                    return;
                }
            }
        }
        s();
    }
}
