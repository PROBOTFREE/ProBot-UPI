package androidx.work.impl.background.systemalarm;

import a2.h;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import androidx.work.impl.WorkDatabase;
import b2.i;
import i2.g;
import j2.c;

class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4519a = h.f("Alarms");

    public static void a(Context context, i iVar, String str) {
        i2.h y10 = iVar.n().y();
        g b10 = y10.b(str);
        if (b10 != null) {
            b(context, str, b10.f14698b);
            h.c().a(f4519a, String.format("Removing SystemIdInfo for workSpecId (%s)", new Object[]{str}), new Throwable[0]);
            y10.d(str);
        }
    }

    private static void b(Context context, String str, int i10) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent service = PendingIntent.getService(context, i10, b.c(context, str), Build.VERSION.SDK_INT >= 23 ? 603979776 : 536870912);
        if (service != null && alarmManager != null) {
            h.c().a(f4519a, String.format("Cancelling existing alarm with (workSpecId, systemId) (%s, %s)", new Object[]{str, Integer.valueOf(i10)}), new Throwable[0]);
            alarmManager.cancel(service);
        }
    }

    public static void c(Context context, i iVar, String str, long j10) {
        int i10;
        WorkDatabase n10 = iVar.n();
        i2.h y10 = n10.y();
        g b10 = y10.b(str);
        if (b10 != null) {
            b(context, str, b10.f14698b);
            i10 = b10.f14698b;
        } else {
            i10 = new c(n10).b();
            y10.c(new g(str, i10));
        }
        d(context, str, i10, j10);
    }

    private static void d(Context context, String str, int i10, long j10) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        int i11 = Build.VERSION.SDK_INT;
        PendingIntent service = PendingIntent.getService(context, i10, b.c(context, str), i11 >= 23 ? 201326592 : 134217728);
        if (alarmManager == null) {
            return;
        }
        if (i11 >= 19) {
            alarmManager.setExact(0, j10, service);
        } else {
            alarmManager.set(0, j10, service);
        }
    }
}
