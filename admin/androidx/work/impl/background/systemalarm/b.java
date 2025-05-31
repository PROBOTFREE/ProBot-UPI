package androidx.work.impl.background.systemalarm;

import a2.h;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.e;
import i2.p;
import java.util.HashMap;
import java.util.Map;

public class b implements b2.b {

    /* renamed from: d  reason: collision with root package name */
    private static final String f4520d = h.f("CommandHandler");

    /* renamed from: a  reason: collision with root package name */
    private final Context f4521a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, b2.b> f4522b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Object f4523c = new Object();

    b(Context context) {
        this.f4521a = context;
    }

    static Intent b(Context context) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_CONSTRAINTS_CHANGED");
        return intent;
    }

    static Intent c(Context context, String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    static Intent d(Context context, String str, boolean z10) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z10);
        return intent;
    }

    static Intent e(Context context) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_RESCHEDULE");
        return intent;
    }

    static Intent f(Context context, String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_SCHEDULE_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    static Intent g(Context context, String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    private void h(Intent intent, int i10, e eVar) {
        h.c().a(f4520d, String.format("Handling constraints changed %s", new Object[]{intent}), new Throwable[0]);
        new c(this.f4521a, i10, eVar).a();
    }

    private void i(Intent intent, int i10, e eVar) {
        Bundle extras = intent.getExtras();
        synchronized (this.f4523c) {
            String string = extras.getString("KEY_WORKSPEC_ID");
            h c10 = h.c();
            String str = f4520d;
            c10.a(str, String.format("Handing delay met for %s", new Object[]{string}), new Throwable[0]);
            if (!this.f4522b.containsKey(string)) {
                d dVar = new d(this.f4521a, i10, string, eVar);
                this.f4522b.put(string, dVar);
                dVar.f();
            } else {
                h.c().a(str, String.format("WorkSpec %s is already being handled for ACTION_DELAY_MET", new Object[]{string}), new Throwable[0]);
            }
        }
    }

    private void j(Intent intent, int i10) {
        Bundle extras = intent.getExtras();
        String string = extras.getString("KEY_WORKSPEC_ID");
        boolean z10 = extras.getBoolean("KEY_NEEDS_RESCHEDULE");
        h.c().a(f4520d, String.format("Handling onExecutionCompleted %s, %s", new Object[]{intent, Integer.valueOf(i10)}), new Throwable[0]);
        a(string, z10);
    }

    private void k(Intent intent, int i10, e eVar) {
        h.c().a(f4520d, String.format("Handling reschedule %s, %s", new Object[]{intent, Integer.valueOf(i10)}), new Throwable[0]);
        eVar.g().r();
    }

    private void l(Intent intent, int i10, e eVar) {
        String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
        h c10 = h.c();
        String str = f4520d;
        c10.a(str, String.format("Handling schedule work for %s", new Object[]{string}), new Throwable[0]);
        WorkDatabase n10 = eVar.g().n();
        n10.c();
        try {
            p k10 = n10.B().k(string);
            if (k10 == null) {
                h c11 = h.c();
                c11.h(str, "Skipping scheduling " + string + " because it's no longer in the DB", new Throwable[0]);
            } else if (k10.f14712b.a()) {
                h c12 = h.c();
                c12.h(str, "Skipping scheduling " + string + "because it is finished.", new Throwable[0]);
                n10.g();
            } else {
                long a10 = k10.a();
                if (!k10.b()) {
                    h.c().a(str, String.format("Setting up Alarms for %s at %s", new Object[]{string, Long.valueOf(a10)}), new Throwable[0]);
                    a.c(this.f4521a, eVar.g(), string, a10);
                } else {
                    h.c().a(str, String.format("Opportunistically setting an alarm for %s at %s", new Object[]{string, Long.valueOf(a10)}), new Throwable[0]);
                    a.c(this.f4521a, eVar.g(), string, a10);
                    eVar.k(new e.b(eVar, b(this.f4521a), i10));
                }
                n10.r();
                n10.g();
            }
        } finally {
            n10.g();
        }
    }

    private void m(Intent intent, e eVar) {
        String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
        h.c().a(f4520d, String.format("Handing stopWork work for %s", new Object[]{string}), new Throwable[0]);
        eVar.g().w(string);
        a.a(this.f4521a, eVar.g(), string);
        eVar.a(string, false);
    }

    private static boolean n(Bundle bundle, String... strArr) {
        if (bundle == null || bundle.isEmpty()) {
            return false;
        }
        for (String str : strArr) {
            if (bundle.get(str) == null) {
                return false;
            }
        }
        return true;
    }

    public void a(String str, boolean z10) {
        synchronized (this.f4523c) {
            b2.b remove = this.f4522b.remove(str);
            if (remove != null) {
                remove.a(str, z10);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean o() {
        boolean z10;
        synchronized (this.f4523c) {
            z10 = !this.f4522b.isEmpty();
        }
        return z10;
    }

    /* access modifiers changed from: package-private */
    public void p(Intent intent, int i10, e eVar) {
        String action = intent.getAction();
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            h(intent, i10, eVar);
        } else if ("ACTION_RESCHEDULE".equals(action)) {
            k(intent, i10, eVar);
        } else if (!n(intent.getExtras(), "KEY_WORKSPEC_ID")) {
            h.c().b(f4520d, String.format("Invalid request for %s, requires %s.", new Object[]{action, "KEY_WORKSPEC_ID"}), new Throwable[0]);
        } else if ("ACTION_SCHEDULE_WORK".equals(action)) {
            l(intent, i10, eVar);
        } else if ("ACTION_DELAY_MET".equals(action)) {
            i(intent, i10, eVar);
        } else if ("ACTION_STOP_WORK".equals(action)) {
            m(intent, eVar);
        } else if ("ACTION_EXECUTION_COMPLETED".equals(action)) {
            j(intent, i10);
        } else {
            h.c().h(f4520d, String.format("Ignoring intent %s", new Object[]{intent}), new Throwable[0]);
        }
    }
}
