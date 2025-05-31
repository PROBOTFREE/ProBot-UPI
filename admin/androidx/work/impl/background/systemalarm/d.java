package androidx.work.impl.background.systemalarm;

import a2.h;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.work.impl.background.systemalarm.e;
import b2.b;
import e2.c;
import i2.p;
import j2.j;
import j2.n;
import java.util.Collections;
import java.util.List;

public class d implements c, b, n.b {

    /* renamed from: j  reason: collision with root package name */
    private static final String f4529j = h.f("DelayMetCommandHandler");

    /* renamed from: a  reason: collision with root package name */
    private final Context f4530a;

    /* renamed from: b  reason: collision with root package name */
    private final int f4531b;

    /* renamed from: c  reason: collision with root package name */
    private final String f4532c;

    /* renamed from: d  reason: collision with root package name */
    private final e f4533d;

    /* renamed from: e  reason: collision with root package name */
    private final e2.d f4534e;

    /* renamed from: f  reason: collision with root package name */
    private final Object f4535f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private int f4536g = 0;

    /* renamed from: h  reason: collision with root package name */
    private PowerManager.WakeLock f4537h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f4538i = false;

    d(Context context, int i10, String str, e eVar) {
        this.f4530a = context;
        this.f4531b = i10;
        this.f4533d = eVar;
        this.f4532c = str;
        this.f4534e = new e2.d(context, eVar.f(), this);
    }

    private void c() {
        synchronized (this.f4535f) {
            this.f4534e.e();
            this.f4533d.h().c(this.f4532c);
            PowerManager.WakeLock wakeLock = this.f4537h;
            if (wakeLock != null && wakeLock.isHeld()) {
                h.c().a(f4529j, String.format("Releasing wakelock %s for WorkSpec %s", new Object[]{this.f4537h, this.f4532c}), new Throwable[0]);
                this.f4537h.release();
            }
        }
    }

    private void g() {
        synchronized (this.f4535f) {
            if (this.f4536g < 2) {
                this.f4536g = 2;
                h c10 = h.c();
                String str = f4529j;
                c10.a(str, String.format("Stopping work for WorkSpec %s", new Object[]{this.f4532c}), new Throwable[0]);
                Intent g10 = b.g(this.f4530a, this.f4532c);
                e eVar = this.f4533d;
                eVar.k(new e.b(eVar, g10, this.f4531b));
                if (this.f4533d.e().g(this.f4532c)) {
                    h.c().a(str, String.format("WorkSpec %s needs to be rescheduled", new Object[]{this.f4532c}), new Throwable[0]);
                    Intent f10 = b.f(this.f4530a, this.f4532c);
                    e eVar2 = this.f4533d;
                    eVar2.k(new e.b(eVar2, f10, this.f4531b));
                } else {
                    h.c().a(str, String.format("Processor does not have WorkSpec %s. No need to reschedule ", new Object[]{this.f4532c}), new Throwable[0]);
                }
            } else {
                h.c().a(f4529j, String.format("Already stopped work for %s", new Object[]{this.f4532c}), new Throwable[0]);
            }
        }
    }

    public void a(String str, boolean z10) {
        h.c().a(f4529j, String.format("onExecuted %s, %s", new Object[]{str, Boolean.valueOf(z10)}), new Throwable[0]);
        c();
        if (z10) {
            Intent f10 = b.f(this.f4530a, this.f4532c);
            e eVar = this.f4533d;
            eVar.k(new e.b(eVar, f10, this.f4531b));
        }
        if (this.f4538i) {
            Intent b10 = b.b(this.f4530a);
            e eVar2 = this.f4533d;
            eVar2.k(new e.b(eVar2, b10, this.f4531b));
        }
    }

    public void b(String str) {
        h.c().a(f4529j, String.format("Exceeded time limits on execution for %s", new Object[]{str}), new Throwable[0]);
        g();
    }

    public void d(List<String> list) {
        g();
    }

    public void e(List<String> list) {
        if (list.contains(this.f4532c)) {
            synchronized (this.f4535f) {
                if (this.f4536g == 0) {
                    this.f4536g = 1;
                    h.c().a(f4529j, String.format("onAllConstraintsMet for %s", new Object[]{this.f4532c}), new Throwable[0]);
                    if (this.f4533d.e().j(this.f4532c)) {
                        this.f4533d.h().b(this.f4532c, 600000, this);
                    } else {
                        c();
                    }
                } else {
                    h.c().a(f4529j, String.format("Already started work for %s", new Object[]{this.f4532c}), new Throwable[0]);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.f4537h = j.b(this.f4530a, String.format("%s (%s)", new Object[]{this.f4532c, Integer.valueOf(this.f4531b)}));
        h c10 = h.c();
        String str = f4529j;
        c10.a(str, String.format("Acquiring wakelock %s for WorkSpec %s", new Object[]{this.f4537h, this.f4532c}), new Throwable[0]);
        this.f4537h.acquire();
        p k10 = this.f4533d.g().n().B().k(this.f4532c);
        if (k10 == null) {
            g();
            return;
        }
        boolean b10 = k10.b();
        this.f4538i = b10;
        if (!b10) {
            h.c().a(str, String.format("No constraints for %s", new Object[]{this.f4532c}), new Throwable[0]);
            e(Collections.singletonList(this.f4532c));
            return;
        }
        this.f4534e.d(Collections.singletonList(k10));
    }
}
