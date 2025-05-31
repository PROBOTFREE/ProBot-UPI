package androidx.work;

import a2.e;
import a2.g;
import a2.l;
import a2.o;
import android.os.Build;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    final Executor f4432a;

    /* renamed from: b  reason: collision with root package name */
    final Executor f4433b;

    /* renamed from: c  reason: collision with root package name */
    final o f4434c;

    /* renamed from: d  reason: collision with root package name */
    final g f4435d;

    /* renamed from: e  reason: collision with root package name */
    final l f4436e;

    /* renamed from: f  reason: collision with root package name */
    final e f4437f;

    /* renamed from: g  reason: collision with root package name */
    final String f4438g;

    /* renamed from: h  reason: collision with root package name */
    final int f4439h;

    /* renamed from: i  reason: collision with root package name */
    final int f4440i;

    /* renamed from: j  reason: collision with root package name */
    final int f4441j;

    /* renamed from: k  reason: collision with root package name */
    final int f4442k;

    class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f4443a = new AtomicInteger(0);

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f4444b;

        a(b bVar, boolean z10) {
            this.f4444b = z10;
        }

        public Thread newThread(Runnable runnable) {
            String str = this.f4444b ? "WM.task-" : "androidx.work-";
            return new Thread(runnable, str + this.f4443a.incrementAndGet());
        }
    }

    /* renamed from: androidx.work.b$b  reason: collision with other inner class name */
    public static final class C0051b {

        /* renamed from: a  reason: collision with root package name */
        Executor f4445a;

        /* renamed from: b  reason: collision with root package name */
        o f4446b;

        /* renamed from: c  reason: collision with root package name */
        g f4447c;

        /* renamed from: d  reason: collision with root package name */
        Executor f4448d;

        /* renamed from: e  reason: collision with root package name */
        l f4449e;

        /* renamed from: f  reason: collision with root package name */
        e f4450f;

        /* renamed from: g  reason: collision with root package name */
        String f4451g;

        /* renamed from: h  reason: collision with root package name */
        int f4452h = 4;

        /* renamed from: i  reason: collision with root package name */
        int f4453i = 0;

        /* renamed from: j  reason: collision with root package name */
        int f4454j = Integer.MAX_VALUE;

        /* renamed from: k  reason: collision with root package name */
        int f4455k = 20;

        public b a() {
            return new b(this);
        }
    }

    public interface c {
        b a();
    }

    b(C0051b bVar) {
        Executor executor = bVar.f4445a;
        this.f4432a = executor == null ? a(false) : executor;
        Executor executor2 = bVar.f4448d;
        this.f4433b = executor2 == null ? a(true) : executor2;
        o oVar = bVar.f4446b;
        this.f4434c = oVar == null ? o.c() : oVar;
        g gVar = bVar.f4447c;
        this.f4435d = gVar == null ? g.c() : gVar;
        l lVar = bVar.f4449e;
        this.f4436e = lVar == null ? new b2.a() : lVar;
        this.f4439h = bVar.f4452h;
        this.f4440i = bVar.f4453i;
        this.f4441j = bVar.f4454j;
        this.f4442k = bVar.f4455k;
        this.f4437f = bVar.f4450f;
        this.f4438g = bVar.f4451g;
    }

    private Executor a(boolean z10) {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), b(z10));
    }

    private ThreadFactory b(boolean z10) {
        return new a(this, z10);
    }

    public String c() {
        return this.f4438g;
    }

    public e d() {
        return this.f4437f;
    }

    public Executor e() {
        return this.f4432a;
    }

    public g f() {
        return this.f4435d;
    }

    public int g() {
        return this.f4441j;
    }

    public int h() {
        return Build.VERSION.SDK_INT == 23 ? this.f4442k / 2 : this.f4442k;
    }

    public int i() {
        return this.f4440i;
    }

    public int j() {
        return this.f4439h;
    }

    public l k() {
        return this.f4436e;
    }

    public Executor l() {
        return this.f4433b;
    }

    public o m() {
        return this.f4434c;
    }
}
