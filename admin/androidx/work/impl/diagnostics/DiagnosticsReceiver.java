package androidx.work.impl.diagnostics;

import a2.h;
import a2.n;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.g;
import androidx.work.impl.workers.DiagnosticsWorker;

public class DiagnosticsReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4560a = h.f("DiagnosticsRcvr");

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            h.c().a(f4560a, "Requesting diagnostics", new Throwable[0]);
            try {
                n.c(context).a(g.d(DiagnosticsWorker.class));
            } catch (IllegalStateException e10) {
                h.c().b(f4560a, "WorkManager is not initialized", e10);
            }
        }
    }
}
