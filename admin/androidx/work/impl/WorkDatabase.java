package androidx.work.impl;

import android.content.Context;
import androidx.room.g;
import androidx.room.h;
import androidx.work.impl.a;
import i2.e;
import i2.k;
import i2.n;
import i2.q;
import i2.t;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import t1.c;

public abstract class WorkDatabase extends h {

    /* renamed from: j  reason: collision with root package name */
    private static final long f4491j = TimeUnit.DAYS.toMillis(1);

    class a implements c.C0218c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f4492a;

        a(Context context) {
            this.f4492a = context;
        }

        public c create(c.b bVar) {
            c.b.a a10 = c.b.a(this.f4492a);
            a10.c(bVar.f17254b).b(bVar.f17255c).d(true);
            return new u1.c().create(a10.a());
        }
    }

    class b extends h.b {
        b() {
        }

        public void c(t1.b bVar) {
            super.c(bVar);
            bVar.beginTransaction();
            try {
                bVar.execSQL(WorkDatabase.w());
                bVar.setTransactionSuccessful();
            } finally {
                bVar.endTransaction();
            }
        }
    }

    public static WorkDatabase s(Context context, Executor executor, boolean z10) {
        h.a<WorkDatabase> aVar;
        Class<WorkDatabase> cls = WorkDatabase.class;
        if (z10) {
            aVar = g.c(context, cls).c();
        } else {
            aVar = g.a(context, cls, b2.h.d());
            aVar.f(new a(context));
        }
        return aVar.g(executor).a(u()).b(a.f4501a).b(new a.h(context, 2, 3)).b(a.f4502b).b(a.f4503c).b(new a.h(context, 5, 6)).b(a.f4504d).b(a.f4505e).b(a.f4506f).b(new a.i(context)).b(new a.h(context, 10, 11)).b(a.f4507g).e().d();
    }

    static h.b u() {
        return new b();
    }

    static long v() {
        return System.currentTimeMillis() - f4491j;
    }

    static String w() {
        return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (period_start_time + minimum_retention_duration) < " + v() + " AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
    }

    public abstract n A();

    public abstract q B();

    public abstract t C();

    public abstract i2.b t();

    public abstract e x();

    public abstract i2.h y();

    public abstract k z();
}
