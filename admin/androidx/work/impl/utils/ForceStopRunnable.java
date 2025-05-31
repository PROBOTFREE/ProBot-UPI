package androidx.work.impl.utils;

import a2.e;
import a2.h;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.ApplicationExitInfo;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.i;
import androidx.work.impl.WorkDatabase;
import b2.f;
import b2.i;
import d2.b;
import i2.n;
import i2.p;
import i2.q;
import java.util.List;
import java.util.concurrent.TimeUnit;
import t0.a;

public class ForceStopRunnable implements Runnable {

    /* renamed from: d  reason: collision with root package name */
    private static final String f4589d = h.f("ForceStopRunnable");

    /* renamed from: e  reason: collision with root package name */
    private static final long f4590e = TimeUnit.DAYS.toMillis(3650);

    /* renamed from: a  reason: collision with root package name */
    private final Context f4591a;

    /* renamed from: b  reason: collision with root package name */
    private final i f4592b;

    /* renamed from: c  reason: collision with root package name */
    private int f4593c = 0;

    public static class BroadcastReceiver extends android.content.BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private static final String f4594a = h.f("ForceStopRunnable$Rcvr");

        public void onReceive(Context context, Intent intent) {
            if (intent != null && "ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
                h.c().g(f4594a, "Rescheduling alarm that keeps track of force-stops.", new Throwable[0]);
                ForceStopRunnable.g(context);
            }
        }
    }

    public ForceStopRunnable(Context context, i iVar) {
        this.f4591a = context.getApplicationContext();
        this.f4592b = iVar;
    }

    static Intent c(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        return intent;
    }

    private static PendingIntent d(Context context, int i10) {
        return PendingIntent.getBroadcast(context, -1, c(context), i10);
    }

    @SuppressLint({"ClassVerificationFailure"})
    static void g(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent d10 = d(context, a.c() ? 167772160 : 134217728);
        long currentTimeMillis = System.currentTimeMillis() + f4590e;
        if (alarmManager == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            alarmManager.setExact(0, currentTimeMillis, d10);
        } else {
            alarmManager.set(0, currentTimeMillis, d10);
        }
    }

    public boolean a() {
        boolean i10 = Build.VERSION.SDK_INT >= 23 ? b.i(this.f4591a, this.f4592b) : false;
        WorkDatabase n10 = this.f4592b.n();
        q B = n10.B();
        n A = n10.A();
        n10.c();
        try {
            List<p> c10 = B.c();
            boolean z10 = c10 != null && !c10.isEmpty();
            if (z10) {
                for (p next : c10) {
                    B.b(i.a.ENQUEUED, next.f14711a);
                    B.e(next.f14711a, -1);
                }
            }
            A.b();
            n10.r();
            return z10 || i10;
        } finally {
            n10.g();
        }
    }

    public void b() {
        boolean a10 = a();
        if (h()) {
            h.c().a(f4589d, "Rescheduling Workers.", new Throwable[0]);
            this.f4592b.r();
            this.f4592b.k().c(false);
        } else if (e()) {
            h.c().a(f4589d, "Application was force-stopped, rescheduling.", new Throwable[0]);
            this.f4592b.r();
        } else if (a10) {
            h.c().a(f4589d, "Found unfinished work, scheduling it.", new Throwable[0]);
            f.b(this.f4592b.h(), this.f4592b.n(), this.f4592b.m());
        }
    }

    @SuppressLint({"ClassVerificationFailure"})
    public boolean e() {
        int i10 = 536870912;
        try {
            if (a.c()) {
                i10 = 570425344;
            }
            PendingIntent d10 = d(this.f4591a, i10);
            if (Build.VERSION.SDK_INT >= 30) {
                if (d10 != null) {
                    d10.cancel();
                }
                List historicalProcessExitReasons = ((ActivityManager) this.f4591a.getSystemService("activity")).getHistoricalProcessExitReasons((String) null, 0, 0);
                if (historicalProcessExitReasons != null && !historicalProcessExitReasons.isEmpty()) {
                    for (int i11 = 0; i11 < historicalProcessExitReasons.size(); i11++) {
                        if (((ApplicationExitInfo) historicalProcessExitReasons.get(i11)).getReason() == 10) {
                            return true;
                        }
                    }
                }
            } else if (d10 == null) {
                g(this.f4591a);
                return true;
            }
            return false;
        } catch (IllegalArgumentException | SecurityException e10) {
            h.c().h(f4589d, "Ignoring exception", e10);
            return true;
        }
    }

    public boolean f() {
        androidx.work.b h10 = this.f4592b.h();
        if (TextUtils.isEmpty(h10.c())) {
            h.c().a(f4589d, "The default process name was not specified.", new Throwable[0]);
            return true;
        }
        boolean b10 = j2.f.b(this.f4591a, h10);
        h.c().a(f4589d, String.format("Is default app process = %s", new Object[]{Boolean.valueOf(b10)}), new Throwable[0]);
        return b10;
    }

    /* access modifiers changed from: package-private */
    public boolean h() {
        return this.f4592b.k().a();
    }

    public void i(long j10) {
        try {
            Thread.sleep(j10);
        } catch (InterruptedException unused) {
        }
    }

    public void run() {
        try {
            if (!f()) {
                this.f4592b.q();
                return;
            }
            while (true) {
                b2.h.e(this.f4591a);
                h.c().a(f4589d, "Performing cleanup operations.", new Throwable[0]);
                b();
                break;
            }
            this.f4592b.q();
        } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteTableLockedException e10) {
            int i10 = this.f4593c + 1;
            this.f4593c = i10;
            if (i10 >= 3) {
                h c10 = h.c();
                String str = f4589d;
                c10.b(str, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e10);
                IllegalStateException illegalStateException = new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e10);
                e d10 = this.f4592b.h().d();
                if (d10 != null) {
                    h.c().a(str, "Routing exception to the specified exception handler", illegalStateException);
                    d10.a(illegalStateException);
                } else {
                    throw illegalStateException;
                }
            } else {
                h.c().a(f4589d, String.format("Retrying after %s", new Object[]{Long.valueOf(((long) i10) * 300)}), e10);
                i(((long) this.f4593c) * 300);
            }
        } catch (Throwable th) {
            this.f4592b.q();
            throw th;
        }
    }
}
