package androidx.work.impl.workers;

import a2.h;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.recyclerview.widget.k;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import b2.i;
import i2.g;
import i2.k;
import i2.p;
import i2.q;
import i2.t;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DiagnosticsWorker extends Worker {

    /* renamed from: g  reason: collision with root package name */
    private static final String f4633g = h.f("DiagnosticsWrkr");

    public DiagnosticsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    private static String s(p pVar, String str, Integer num, String str2) {
        return String.format("\n%s\t %s\t %s\t %s\t %s\t %s\t", new Object[]{pVar.f14711a, pVar.f14713c, num, pVar.f14712b.name(), str, str2});
    }

    private static String t(k kVar, t tVar, i2.h hVar, List<p> list) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(String.format("\n Id \t Class Name\t %s\t State\t Unique Name\t Tags\t", new Object[]{Build.VERSION.SDK_INT >= 23 ? "Job Id" : "Alarm Id"}));
        for (p next : list) {
            Integer num = null;
            g b10 = hVar.b(next.f14711a);
            if (b10 != null) {
                num = Integer.valueOf(b10.f14698b);
            }
            sb2.append(s(next, TextUtils.join(",", kVar.b(next.f14711a)), num, TextUtils.join(",", tVar.b(next.f14711a))));
        }
        return sb2.toString();
    }

    public ListenableWorker.a r() {
        WorkDatabase n10 = i.j(a()).n();
        q B = n10.B();
        k z10 = n10.z();
        t C = n10.C();
        i2.h y10 = n10.y();
        List<p> h10 = B.h(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1));
        List<p> c10 = B.c();
        List<p> r10 = B.r(k.f.DEFAULT_DRAG_ANIMATION_DURATION);
        if (h10 != null && !h10.isEmpty()) {
            h c11 = h.c();
            String str = f4633g;
            c11.d(str, "Recently completed work:\n\n", new Throwable[0]);
            h.c().d(str, t(z10, C, y10, h10), new Throwable[0]);
        }
        if (c10 != null && !c10.isEmpty()) {
            h c12 = h.c();
            String str2 = f4633g;
            c12.d(str2, "Running work:\n\n", new Throwable[0]);
            h.c().d(str2, t(z10, C, y10, c10), new Throwable[0]);
        }
        if (r10 != null && !r10.isEmpty()) {
            h c13 = h.c();
            String str3 = f4633g;
            c13.d(str3, "Enqueued work:\n\n", new Throwable[0]);
            h.c().d(str3, t(z10, C, y10, r10), new Throwable[0]);
        }
        return ListenableWorker.a.c();
    }
}
