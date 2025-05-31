package androidx.work.impl.background.systemalarm;

import a2.h;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import b2.i;

public class RescheduleReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4515a = h.f("RescheduleReceiver");

    public void onReceive(Context context, Intent intent) {
        h.c().a(f4515a, String.format("Received intent %s", new Object[]{intent}), new Throwable[0]);
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                i.j(context).s(goAsync());
            } catch (IllegalStateException e10) {
                h.c().b(f4515a, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e10);
            }
        } else {
            context.startService(b.e(context));
        }
    }
}
