package androidx.work.impl.background.systemalarm;

import a2.h;
import android.content.Intent;
import androidx.lifecycle.r;
import androidx.work.impl.background.systemalarm.e;
import j2.j;

public class SystemAlarmService extends r implements e.c {

    /* renamed from: d  reason: collision with root package name */
    private static final String f4516d = h.f("SystemAlarmService");

    /* renamed from: b  reason: collision with root package name */
    private e f4517b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4518c;

    private void e() {
        e eVar = new e(this);
        this.f4517b = eVar;
        eVar.m(this);
    }

    public void a() {
        this.f4518c = true;
        h.c().a(f4516d, "All commands completed in dispatcher", new Throwable[0]);
        j.a();
        stopSelf();
    }

    public void onCreate() {
        super.onCreate();
        e();
        this.f4518c = false;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f4518c = true;
        this.f4517b.j();
    }

    public int onStartCommand(Intent intent, int i10, int i11) {
        super.onStartCommand(intent, i10, i11);
        if (this.f4518c) {
            h.c().d(f4516d, "Re-initializing SystemAlarmDispatcher after a request to shut-down.", new Throwable[0]);
            this.f4517b.j();
            e();
            this.f4518c = false;
        }
        if (intent == null) {
            return 3;
        }
        this.f4517b.b(intent, i11);
        return 3;
    }
}
