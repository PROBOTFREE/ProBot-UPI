package androidx.work.impl.background.systemalarm;

import a2.h;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.background.systemalarm.ConstraintProxy;
import b2.i;
import j2.d;

public class ConstraintProxyUpdateReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    static final String f4511a = h.f("ConstrntProxyUpdtRecvr");

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Intent f4512a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f4513b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ BroadcastReceiver.PendingResult f4514c;

        a(ConstraintProxyUpdateReceiver constraintProxyUpdateReceiver, Intent intent, Context context, BroadcastReceiver.PendingResult pendingResult) {
            this.f4512a = intent;
            this.f4513b = context;
            this.f4514c = pendingResult;
        }

        public void run() {
            try {
                boolean booleanExtra = this.f4512a.getBooleanExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", false);
                boolean booleanExtra2 = this.f4512a.getBooleanExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", false);
                boolean booleanExtra3 = this.f4512a.getBooleanExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", false);
                boolean booleanExtra4 = this.f4512a.getBooleanExtra("KEY_NETWORK_STATE_PROXY_ENABLED", false);
                h.c().a(ConstraintProxyUpdateReceiver.f4511a, String.format("Updating proxies: BatteryNotLowProxy enabled (%s), BatteryChargingProxy enabled (%s), StorageNotLowProxy (%s), NetworkStateProxy enabled (%s)", new Object[]{Boolean.valueOf(booleanExtra), Boolean.valueOf(booleanExtra2), Boolean.valueOf(booleanExtra3), Boolean.valueOf(booleanExtra4)}), new Throwable[0]);
                d.a(this.f4513b, ConstraintProxy.BatteryNotLowProxy.class, booleanExtra);
                d.a(this.f4513b, ConstraintProxy.BatteryChargingProxy.class, booleanExtra2);
                d.a(this.f4513b, ConstraintProxy.StorageNotLowProxy.class, booleanExtra3);
                d.a(this.f4513b, ConstraintProxy.NetworkStateProxy.class, booleanExtra4);
            } finally {
                this.f4514c.finish();
            }
        }
    }

    public static Intent a(Context context, boolean z10, boolean z11, boolean z12, boolean z13) {
        Intent intent = new Intent("androidx.work.impl.background.systemalarm.UpdateProxies");
        intent.setComponent(new ComponentName(context, ConstraintProxyUpdateReceiver.class));
        intent.putExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", z10).putExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", z11).putExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", z12).putExtra("KEY_NETWORK_STATE_PROXY_ENABLED", z13);
        return intent;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent != null ? intent.getAction() : null;
        if (!"androidx.work.impl.background.systemalarm.UpdateProxies".equals(action)) {
            h.c().a(f4511a, String.format("Ignoring unknown action %s", new Object[]{action}), new Throwable[0]);
        } else {
            i.j(context).o().b(new a(this, intent, context, goAsync()));
        }
    }
}
