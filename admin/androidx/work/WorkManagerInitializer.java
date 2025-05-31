package androidx.work;

import a2.h;
import a2.n;
import android.content.Context;
import androidx.work.b;
import java.util.Collections;
import java.util.List;
import v1.a;

public final class WorkManagerInitializer implements a<n> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4418a = h.f("WrkMgrInitializer");

    public List<Class<? extends a<?>>> a() {
        return Collections.emptyList();
    }

    /* renamed from: c */
    public n b(Context context) {
        h.c().a(f4418a, "Initializing WorkManager with default configuration.", new Throwable[0]);
        n.d(context, new b.C0051b().a());
        return n.c(context);
    }
}
