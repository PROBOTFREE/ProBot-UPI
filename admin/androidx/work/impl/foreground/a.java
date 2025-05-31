package androidx.work.impl.foreground;

import a2.h;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import b2.i;
import e2.c;
import e2.d;
import i2.p;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class a implements c, b2.b {

    /* renamed from: k  reason: collision with root package name */
    static final String f4575k = h.f("SystemFgDispatcher");

    /* renamed from: a  reason: collision with root package name */
    private Context f4576a;

    /* renamed from: b  reason: collision with root package name */
    private i f4577b;

    /* renamed from: c  reason: collision with root package name */
    private final k2.a f4578c;

    /* renamed from: d  reason: collision with root package name */
    final Object f4579d = new Object();

    /* renamed from: e  reason: collision with root package name */
    String f4580e;

    /* renamed from: f  reason: collision with root package name */
    final Map<String, a2.c> f4581f;

    /* renamed from: g  reason: collision with root package name */
    final Map<String, p> f4582g;

    /* renamed from: h  reason: collision with root package name */
    final Set<p> f4583h;

    /* renamed from: i  reason: collision with root package name */
    final d f4584i;

    /* renamed from: j  reason: collision with root package name */
    private b f4585j;

    /* renamed from: androidx.work.impl.foreground.a$a  reason: collision with other inner class name */
    class C0053a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WorkDatabase f4586a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f4587b;

        C0053a(WorkDatabase workDatabase, String str) {
            this.f4586a = workDatabase;
            this.f4587b = str;
        }

        public void run() {
            p k10 = this.f4586a.B().k(this.f4587b);
            if (k10 != null && k10.b()) {
                synchronized (a.this.f4579d) {
                    a.this.f4582g.put(this.f4587b, k10);
                    a.this.f4583h.add(k10);
                    a aVar = a.this;
                    aVar.f4584i.d(aVar.f4583h);
                }
            }
        }
    }

    interface b {
        void b(int i10);

        void c(int i10, int i11, Notification notification);

        void d(int i10, Notification notification);

        void stop();
    }

    a(Context context) {
        this.f4576a = context;
        i j10 = i.j(context);
        this.f4577b = j10;
        k2.a o10 = j10.o();
        this.f4578c = o10;
        this.f4580e = null;
        this.f4581f = new LinkedHashMap();
        this.f4583h = new HashSet();
        this.f4582g = new HashMap();
        this.f4584i = new d(this.f4576a, o10, this);
        this.f4577b.l().d(this);
    }

    public static Intent b(Context context, String str, a2.c cVar) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_NOTIFY");
        intent.putExtra("KEY_NOTIFICATION_ID", cVar.c());
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", cVar.a());
        intent.putExtra("KEY_NOTIFICATION", cVar.b());
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent c(Context context, String str, a2.c cVar) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_START_FOREGROUND");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NOTIFICATION_ID", cVar.c());
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", cVar.a());
        intent.putExtra("KEY_NOTIFICATION", cVar.b());
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent f(Context context) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_STOP_FOREGROUND");
        return intent;
    }

    private void g(Intent intent) {
        h.c().d(f4575k, String.format("Stopping foreground work for %s", new Object[]{intent}), new Throwable[0]);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        if (stringExtra != null && !TextUtils.isEmpty(stringExtra)) {
            this.f4577b.e(UUID.fromString(stringExtra));
        }
    }

    private void h(Intent intent) {
        int i10 = 0;
        int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        h.c().a(f4575k, String.format("Notifying with (id: %s, workSpecId: %s, notificationType: %s)", new Object[]{Integer.valueOf(intExtra), stringExtra, Integer.valueOf(intExtra2)}), new Throwable[0]);
        if (notification != null && this.f4585j != null) {
            this.f4581f.put(stringExtra, new a2.c(intExtra, notification, intExtra2));
            if (TextUtils.isEmpty(this.f4580e)) {
                this.f4580e = stringExtra;
                this.f4585j.c(intExtra, intExtra2, notification);
                return;
            }
            this.f4585j.d(intExtra, notification);
            if (intExtra2 != 0 && Build.VERSION.SDK_INT >= 29) {
                for (Map.Entry<String, a2.c> value : this.f4581f.entrySet()) {
                    i10 |= ((a2.c) value.getValue()).a();
                }
                a2.c cVar = this.f4581f.get(this.f4580e);
                if (cVar != null) {
                    this.f4585j.c(cVar.c(), i10, cVar.b());
                }
            }
        }
    }

    private void i(Intent intent) {
        h.c().d(f4575k, String.format("Started foreground service %s", new Object[]{intent}), new Throwable[0]);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        this.f4578c.b(new C0053a(this.f4577b.n(), stringExtra));
    }

    public void a(String str, boolean z10) {
        Map.Entry next;
        synchronized (this.f4579d) {
            p remove = this.f4582g.remove(str);
            if (remove != null ? this.f4583h.remove(remove) : false) {
                this.f4584i.d(this.f4583h);
            }
        }
        a2.c remove2 = this.f4581f.remove(str);
        if (str.equals(this.f4580e) && this.f4581f.size() > 0) {
            Iterator<Map.Entry<String, a2.c>> it = this.f4581f.entrySet().iterator();
            do {
                next = it.next();
            } while (it.hasNext());
            this.f4580e = (String) next.getKey();
            if (this.f4585j != null) {
                a2.c cVar = (a2.c) next.getValue();
                this.f4585j.c(cVar.c(), cVar.a(), cVar.b());
                this.f4585j.b(cVar.c());
            }
        }
        b bVar = this.f4585j;
        if (remove2 != null && bVar != null) {
            h.c().a(f4575k, String.format("Removing Notification (id: %s, workSpecId: %s ,notificationType: %s)", new Object[]{Integer.valueOf(remove2.c()), str, Integer.valueOf(remove2.a())}), new Throwable[0]);
            bVar.b(remove2.c());
        }
    }

    public void d(List<String> list) {
        if (!list.isEmpty()) {
            for (String next : list) {
                h.c().a(f4575k, String.format("Constraints unmet for WorkSpec %s", new Object[]{next}), new Throwable[0]);
                this.f4577b.v(next);
            }
        }
    }

    public void e(List<String> list) {
    }

    /* access modifiers changed from: package-private */
    public void j(Intent intent) {
        h.c().d(f4575k, "Stopping foreground service", new Throwable[0]);
        b bVar = this.f4585j;
        if (bVar != null) {
            bVar.stop();
        }
    }

    /* access modifiers changed from: package-private */
    public void k() {
        this.f4585j = null;
        synchronized (this.f4579d) {
            this.f4584i.e();
        }
        this.f4577b.l().i(this);
    }

    /* access modifiers changed from: package-private */
    public void l(Intent intent) {
        String action = intent.getAction();
        if ("ACTION_START_FOREGROUND".equals(action)) {
            i(intent);
        } else if (!"ACTION_NOTIFY".equals(action)) {
            if ("ACTION_CANCEL_WORK".equals(action)) {
                g(intent);
                return;
            } else if ("ACTION_STOP_FOREGROUND".equals(action)) {
                j(intent);
                return;
            } else {
                return;
            }
        }
        h(intent);
    }

    /* access modifiers changed from: package-private */
    public void m(b bVar) {
        if (this.f4585j != null) {
            h.c().b(f4575k, "A callback already exists.", new Throwable[0]);
        } else {
            this.f4585j = bVar;
        }
    }
}
