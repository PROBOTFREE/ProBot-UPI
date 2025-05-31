package androidx.work.impl.background.systemalarm;

import a2.h;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.background.systemalarm.e;
import e2.d;
import i2.p;
import java.util.ArrayList;
import java.util.List;

class c {

    /* renamed from: e  reason: collision with root package name */
    private static final String f4524e = h.f("ConstraintsCmdHandler");

    /* renamed from: a  reason: collision with root package name */
    private final Context f4525a;

    /* renamed from: b  reason: collision with root package name */
    private final int f4526b;

    /* renamed from: c  reason: collision with root package name */
    private final e f4527c;

    /* renamed from: d  reason: collision with root package name */
    private final d f4528d;

    c(Context context, int i10, e eVar) {
        this.f4525a = context;
        this.f4526b = i10;
        this.f4527c = eVar;
        this.f4528d = new d(context, eVar.f(), (e2.c) null);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        List<p> q10 = this.f4527c.g().n().B().q();
        ConstraintProxy.a(this.f4525a, q10);
        this.f4528d.d(q10);
        ArrayList<p> arrayList = new ArrayList<>(q10.size());
        long currentTimeMillis = System.currentTimeMillis();
        for (p next : q10) {
            String str = next.f14711a;
            if (currentTimeMillis >= next.a() && (!next.b() || this.f4528d.c(str))) {
                arrayList.add(next);
            }
        }
        for (p pVar : arrayList) {
            String str2 = pVar.f14711a;
            Intent c10 = b.c(this.f4525a, str2);
            h.c().a(f4524e, String.format("Creating a delay_met command for workSpec with id (%s)", new Object[]{str2}), new Throwable[0]);
            e eVar = this.f4527c;
            eVar.k(new e.b(eVar, c10, this.f4526b));
        }
        this.f4528d.e();
    }
}
