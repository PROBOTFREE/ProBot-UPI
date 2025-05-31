package androidx.work.impl.background.systemalarm;

import a2.a;
import a2.h;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.f;
import i2.p;
import java.util.List;

abstract class ConstraintProxy extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4510a = h.f("ConstraintProxy");

    public static class BatteryChargingProxy extends ConstraintProxy {
    }

    public static class BatteryNotLowProxy extends ConstraintProxy {
    }

    public static class NetworkStateProxy extends ConstraintProxy {
    }

    public static class StorageNotLowProxy extends ConstraintProxy {
    }

    ConstraintProxy() {
    }

    static void a(Context context, List<p> list) {
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        for (p pVar : list) {
            a aVar = pVar.f14720j;
            z10 |= aVar.f();
            z11 |= aVar.g();
            z12 |= aVar.i();
            z13 |= aVar.b() != f.NOT_REQUIRED;
            if (z10 && z11 && z12 && z13) {
                break;
            }
        }
        context.sendBroadcast(ConstraintProxyUpdateReceiver.a(context, z10, z11, z12, z13));
    }

    public void onReceive(Context context, Intent intent) {
        h.c().a(f4510a, String.format("onReceive : %s", new Object[]{intent}), new Throwable[0]);
        context.startService(b.b(context));
    }
}
