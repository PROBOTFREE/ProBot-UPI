package androidx.work.impl.background.systemalarm;

import a2.h;
import android.content.Context;
import b2.e;
import i2.p;

public class f implements e {

    /* renamed from: b  reason: collision with root package name */
    private static final String f4555b = h.f("SystemAlarmScheduler");

    /* renamed from: a  reason: collision with root package name */
    private final Context f4556a;

    public f(Context context) {
        this.f4556a = context.getApplicationContext();
    }

    private void a(p pVar) {
        h.c().a(f4555b, String.format("Scheduling work with workSpecId %s", new Object[]{pVar.f14711a}), new Throwable[0]);
        this.f4556a.startService(b.f(this.f4556a, pVar.f14711a));
    }

    public void b(String str) {
        this.f4556a.startService(b.g(this.f4556a, str));
    }

    public void c(p... pVarArr) {
        for (p a10 : pVarArr) {
            a(a10);
        }
    }

    public boolean f() {
        return true;
    }
}
