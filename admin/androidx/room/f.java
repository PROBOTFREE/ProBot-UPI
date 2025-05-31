package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.b;
import androidx.room.c;
import androidx.room.e;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

class f {

    /* renamed from: a  reason: collision with root package name */
    final Context f3760a;

    /* renamed from: b  reason: collision with root package name */
    final String f3761b;

    /* renamed from: c  reason: collision with root package name */
    int f3762c;

    /* renamed from: d  reason: collision with root package name */
    final e f3763d;

    /* renamed from: e  reason: collision with root package name */
    final e.c f3764e;

    /* renamed from: f  reason: collision with root package name */
    c f3765f;

    /* renamed from: g  reason: collision with root package name */
    final Executor f3766g;

    /* renamed from: h  reason: collision with root package name */
    final b f3767h = new a();

    /* renamed from: i  reason: collision with root package name */
    final AtomicBoolean f3768i = new AtomicBoolean(false);

    /* renamed from: j  reason: collision with root package name */
    final ServiceConnection f3769j;

    /* renamed from: k  reason: collision with root package name */
    final Runnable f3770k;

    /* renamed from: l  reason: collision with root package name */
    final Runnable f3771l;

    class a extends b.a {

        /* renamed from: androidx.room.f$a$a  reason: collision with other inner class name */
        class C0040a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String[] f3773a;

            C0040a(String[] strArr) {
                this.f3773a = strArr;
            }

            public void run() {
                f.this.f3763d.e(this.f3773a);
            }
        }

        a() {
        }

        public void t(String[] strArr) {
            f.this.f3766g.execute(new C0040a(strArr));
        }
    }

    class b implements ServiceConnection {
        b() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            f.this.f3765f = c.a.b0(iBinder);
            f fVar = f.this;
            fVar.f3766g.execute(fVar.f3770k);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            f fVar = f.this;
            fVar.f3766g.execute(fVar.f3771l);
            f.this.f3765f = null;
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            try {
                f fVar = f.this;
                c cVar = fVar.f3765f;
                if (cVar != null) {
                    fVar.f3762c = cVar.D(fVar.f3767h, fVar.f3761b);
                    f fVar2 = f.this;
                    fVar2.f3763d.a(fVar2.f3764e);
                }
            } catch (RemoteException e10) {
                Log.w("ROOM", "Cannot register multi-instance invalidation callback", e10);
            }
        }
    }

    class d implements Runnable {
        d() {
        }

        public void run() {
            f fVar = f.this;
            fVar.f3763d.g(fVar.f3764e);
        }
    }

    class e implements Runnable {
        e() {
        }

        public void run() {
            f fVar = f.this;
            fVar.f3763d.g(fVar.f3764e);
            try {
                f fVar2 = f.this;
                c cVar = fVar2.f3765f;
                if (cVar != null) {
                    cVar.X(fVar2.f3767h, fVar2.f3762c);
                }
            } catch (RemoteException e10) {
                Log.w("ROOM", "Cannot unregister multi-instance invalidation callback", e10);
            }
            f fVar3 = f.this;
            fVar3.f3760a.unbindService(fVar3.f3769j);
        }
    }

    /* renamed from: androidx.room.f$f  reason: collision with other inner class name */
    class C0041f extends e.c {
        C0041f(String[] strArr) {
            super(strArr);
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return true;
        }

        public void b(Set<String> set) {
            if (!f.this.f3768i.get()) {
                try {
                    f fVar = f.this;
                    c cVar = fVar.f3765f;
                    if (cVar != null) {
                        cVar.S(fVar.f3762c, (String[]) set.toArray(new String[0]));
                    }
                } catch (RemoteException e10) {
                    Log.w("ROOM", "Cannot broadcast invalidation", e10);
                }
            }
        }
    }

    f(Context context, String str, e eVar, Executor executor) {
        b bVar = new b();
        this.f3769j = bVar;
        this.f3770k = new c();
        this.f3771l = new d();
        new e();
        Context applicationContext = context.getApplicationContext();
        this.f3760a = applicationContext;
        this.f3761b = str;
        this.f3763d = eVar;
        this.f3766g = executor;
        this.f3764e = new C0041f((String[]) eVar.f3739a.keySet().toArray(new String[0]));
        applicationContext.bindService(new Intent(applicationContext, MultiInstanceInvalidationService.class), bVar, 1);
    }
}
