package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class r extends Service implements o {

    /* renamed from: a  reason: collision with root package name */
    private final b0 f3045a = new b0(this);

    public h getLifecycle() {
        return this.f3045a.a();
    }

    public IBinder onBind(Intent intent) {
        this.f3045a.b();
        return null;
    }

    public void onCreate() {
        this.f3045a.c();
        super.onCreate();
    }

    public void onDestroy() {
        this.f3045a.d();
        super.onDestroy();
    }

    public void onStart(Intent intent, int i10) {
        this.f3045a.e();
        super.onStart(intent, i10);
    }

    public int onStartCommand(Intent intent, int i10, int i11) {
        return super.onStartCommand(intent, i10, i11);
    }
}
