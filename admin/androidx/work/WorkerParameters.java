package androidx.work;

import a2.d;
import a2.j;
import a2.o;
import android.net.Uri;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;

public final class WorkerParameters {

    /* renamed from: a  reason: collision with root package name */
    private UUID f4421a;

    /* renamed from: b  reason: collision with root package name */
    private c f4422b;

    /* renamed from: c  reason: collision with root package name */
    private Executor f4423c;

    /* renamed from: d  reason: collision with root package name */
    private k2.a f4424d;

    /* renamed from: e  reason: collision with root package name */
    private o f4425e;

    /* renamed from: f  reason: collision with root package name */
    private d f4426f;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public List<String> f4427a = Collections.emptyList();

        /* renamed from: b  reason: collision with root package name */
        public List<Uri> f4428b = Collections.emptyList();
    }

    public WorkerParameters(UUID uuid, c cVar, Collection<String> collection, a aVar, int i10, Executor executor, k2.a aVar2, o oVar, j jVar, d dVar) {
        this.f4421a = uuid;
        this.f4422b = cVar;
        new HashSet(collection);
        this.f4423c = executor;
        this.f4424d = aVar2;
        this.f4425e = oVar;
        this.f4426f = dVar;
    }

    public Executor a() {
        return this.f4423c;
    }

    public d b() {
        return this.f4426f;
    }

    public UUID c() {
        return this.f4421a;
    }

    public c d() {
        return this.f4422b;
    }

    public k2.a e() {
        return this.f4424d;
    }

    public o f() {
        return this.f4425e;
    }
}
