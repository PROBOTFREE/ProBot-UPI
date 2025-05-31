package androidx.work.impl.background.systemalarm;

import a2.h;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import b2.i;
import j2.g;
import j2.j;
import j2.n;
import java.util.ArrayList;
import java.util.List;

public class e implements b2.b {

    /* renamed from: k  reason: collision with root package name */
    static final String f4539k = h.f("SystemAlarmDispatcher");

    /* renamed from: a  reason: collision with root package name */
    final Context f4540a;

    /* renamed from: b  reason: collision with root package name */
    private final k2.a f4541b;

    /* renamed from: c  reason: collision with root package name */
    private final n f4542c;

    /* renamed from: d  reason: collision with root package name */
    private final b2.d f4543d;

    /* renamed from: e  reason: collision with root package name */
    private final i f4544e;

    /* renamed from: f  reason: collision with root package name */
    final b f4545f;

    /* renamed from: g  reason: collision with root package name */
    private final Handler f4546g;

    /* renamed from: h  reason: collision with root package name */
    final List<Intent> f4547h;

    /* renamed from: i  reason: collision with root package name */
    Intent f4548i;

    /* renamed from: j  reason: collision with root package name */
    private c f4549j;

    class a implements Runnable {
        a() {
        }

        public void run() {
            d dVar;
            e eVar;
            synchronized (e.this.f4547h) {
                e eVar2 = e.this;
                eVar2.f4548i = eVar2.f4547h.get(0);
            }
            Intent intent = e.this.f4548i;
            if (intent != null) {
                String action = intent.getAction();
                int intExtra = e.this.f4548i.getIntExtra("KEY_START_ID", 0);
                h c10 = h.c();
                String str = e.f4539k;
                c10.a(str, String.format("Processing command %s, %s", new Object[]{e.this.f4548i, Integer.valueOf(intExtra)}), new Throwable[0]);
                PowerManager.WakeLock b10 = j.b(e.this.f4540a, String.format("%s (%s)", new Object[]{action, Integer.valueOf(intExtra)}));
                try {
                    h.c().a(str, String.format("Acquiring operation wake lock (%s) %s", new Object[]{action, b10}), new Throwable[0]);
                    b10.acquire();
                    e eVar3 = e.this;
                    eVar3.f4545f.p(eVar3.f4548i, intExtra, eVar3);
                    h.c().a(str, String.format("Releasing operation wake lock (%s) %s", new Object[]{action, b10}), new Throwable[0]);
                    b10.release();
                    eVar = e.this;
                    dVar = new d(eVar);
                } catch (Throwable th) {
                    h.c().a(e.f4539k, String.format("Releasing operation wake lock (%s) %s", new Object[]{action, b10}), new Throwable[0]);
                    b10.release();
                    e eVar4 = e.this;
                    eVar4.k(new d(eVar4));
                    throw th;
                }
                eVar.k(dVar);
            }
        }
    }

    static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final e f4551a;

        /* renamed from: b  reason: collision with root package name */
        private final Intent f4552b;

        /* renamed from: c  reason: collision with root package name */
        private final int f4553c;

        b(e eVar, Intent intent, int i10) {
            this.f4551a = eVar;
            this.f4552b = intent;
            this.f4553c = i10;
        }

        public void run() {
            this.f4551a.b(this.f4552b, this.f4553c);
        }
    }

    interface c {
        void a();
    }

    static class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final e f4554a;

        d(e eVar) {
            this.f4554a = eVar;
        }

        public void run() {
            this.f4554a.d();
        }
    }

    e(Context context) {
        this(context, (b2.d) null, (i) null);
    }

    e(Context context, b2.d dVar, i iVar) {
        Context applicationContext = context.getApplicationContext();
        this.f4540a = applicationContext;
        this.f4545f = new b(applicationContext);
        this.f4542c = new n();
        iVar = iVar == null ? i.j(context) : iVar;
        this.f4544e = iVar;
        dVar = dVar == null ? iVar.l() : dVar;
        this.f4543d = dVar;
        this.f4541b = iVar.o();
        dVar.d(this);
        this.f4547h = new ArrayList();
        this.f4548i = null;
        this.f4546g = new Handler(Looper.getMainLooper());
    }

    private void c() {
        if (this.f4546g.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    private boolean i(String str) {
        c();
        synchronized (this.f4547h) {
            for (Intent action : this.f4547h) {
                if (str.equals(action.getAction())) {
                    return true;
                }
            }
            return false;
        }
    }

    private void l() {
        c();
        PowerManager.WakeLock b10 = j.b(this.f4540a, "ProcessCommand");
        try {
            b10.acquire();
            this.f4544e.o().b(new a());
        } finally {
            b10.release();
        }
    }

    public void a(String str, boolean z10) {
        k(new b(this, b.d(this.f4540a, str, z10), 0));
    }

    public boolean b(Intent intent, int i10) {
        h c10 = h.c();
        String str = f4539k;
        boolean z10 = false;
        c10.a(str, String.format("Adding command %s (%s)", new Object[]{intent, Integer.valueOf(i10)}), new Throwable[0]);
        c();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            h.c().h(str, "Unknown command. Ignoring", new Throwable[0]);
            return false;
        } else if ("ACTION_CONSTRAINTS_CHANGED".equals(action) && i("ACTION_CONSTRAINTS_CHANGED")) {
            return false;
        } else {
            intent.putExtra("KEY_START_ID", i10);
            synchronized (this.f4547h) {
                if (!this.f4547h.isEmpty()) {
                    z10 = true;
                }
                this.f4547h.add(intent);
                if (!z10) {
                    l();
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        h c10 = h.c();
        String str = f4539k;
        c10.a(str, "Checking if commands are complete.", new Throwable[0]);
        c();
        synchronized (this.f4547h) {
            if (this.f4548i != null) {
                h.c().a(str, String.format("Removing command %s", new Object[]{this.f4548i}), new Throwable[0]);
                if (this.f4547h.remove(0).equals(this.f4548i)) {
                    this.f4548i = null;
                } else {
                    throw new IllegalStateException("Dequeue-d command is not the first.");
                }
            }
            g c11 = this.f4541b.c();
            if (!this.f4545f.o() && this.f4547h.isEmpty() && !c11.a()) {
                h.c().a(str, "No more commands & intents.", new Throwable[0]);
                c cVar = this.f4549j;
                if (cVar != null) {
                    cVar.a();
                }
            } else if (!this.f4547h.isEmpty()) {
                l();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public b2.d e() {
        return this.f4543d;
    }

    /* access modifiers changed from: package-private */
    public k2.a f() {
        return this.f4541b;
    }

    /* access modifiers changed from: package-private */
    public i g() {
        return this.f4544e;
    }

    /* access modifiers changed from: package-private */
    public n h() {
        return this.f4542c;
    }

    /* access modifiers changed from: package-private */
    public void j() {
        h.c().a(f4539k, "Destroying SystemAlarmDispatcher", new Throwable[0]);
        this.f4543d.i(this);
        this.f4542c.a();
        this.f4549j = null;
    }

    /* access modifiers changed from: package-private */
    public void k(Runnable runnable) {
        this.f4546g.post(runnable);
    }

    /* access modifiers changed from: package-private */
    public void m(c cVar) {
        if (this.f4549j != null) {
            h.c().b(f4539k, "A completion listener for SystemAlarmDispatcher already exists.", new Throwable[0]);
        } else {
            this.f4549j = cVar;
        }
    }
}
