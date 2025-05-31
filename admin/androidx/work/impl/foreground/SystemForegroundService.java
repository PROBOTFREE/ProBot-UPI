package androidx.work.impl.foreground;

import a2.h;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.r;
import androidx.work.impl.foreground.a;

public class SystemForegroundService extends r implements a.b {

    /* renamed from: f  reason: collision with root package name */
    private static final String f4561f = h.f("SystemFgService");

    /* renamed from: b  reason: collision with root package name */
    private Handler f4562b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4563c;

    /* renamed from: d  reason: collision with root package name */
    a f4564d;

    /* renamed from: e  reason: collision with root package name */
    NotificationManager f4565e;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f4566a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Notification f4567b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f4568c;

        a(int i10, Notification notification, int i11) {
            this.f4566a = i10;
            this.f4567b = notification;
            this.f4568c = i11;
        }

        public void run() {
            if (Build.VERSION.SDK_INT >= 29) {
                SystemForegroundService.this.startForeground(this.f4566a, this.f4567b, this.f4568c);
            } else {
                SystemForegroundService.this.startForeground(this.f4566a, this.f4567b);
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f4570a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Notification f4571b;

        b(int i10, Notification notification) {
            this.f4570a = i10;
            this.f4571b = notification;
        }

        public void run() {
            SystemForegroundService.this.f4565e.notify(this.f4570a, this.f4571b);
        }
    }

    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f4573a;

        c(int i10) {
            this.f4573a = i10;
        }

        public void run() {
            SystemForegroundService.this.f4565e.cancel(this.f4573a);
        }
    }

    private void e() {
        this.f4562b = new Handler(Looper.getMainLooper());
        this.f4565e = (NotificationManager) getApplicationContext().getSystemService("notification");
        a aVar = new a(getApplicationContext());
        this.f4564d = aVar;
        aVar.m(this);
    }

    public void b(int i10) {
        this.f4562b.post(new c(i10));
    }

    public void c(int i10, int i11, Notification notification) {
        this.f4562b.post(new a(i10, notification, i11));
    }

    public void d(int i10, Notification notification) {
        this.f4562b.post(new b(i10, notification));
    }

    public void onCreate() {
        super.onCreate();
        e();
    }

    public void onDestroy() {
        super.onDestroy();
        this.f4564d.k();
    }

    public int onStartCommand(Intent intent, int i10, int i11) {
        super.onStartCommand(intent, i10, i11);
        if (this.f4563c) {
            h.c().d(f4561f, "Re-initializing SystemForegroundService after a request to shut-down.", new Throwable[0]);
            this.f4564d.k();
            e();
            this.f4563c = false;
        }
        if (intent == null) {
            return 3;
        }
        this.f4564d.l(intent);
        return 3;
    }

    public void stop() {
        this.f4563c = true;
        h.c().a(f4561f, "All commands completed.", new Throwable[0]);
        if (Build.VERSION.SDK_INT >= 26) {
            stopForeground(true);
        }
        stopSelf();
    }
}
