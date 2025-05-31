package ae;

import ab.u;
import ae.e;
import java.lang.ref.Reference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import mb.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vd.f0;
import zd.d;
import zd.e;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private final long f19198a;

    /* renamed from: b  reason: collision with root package name */
    private final d f19199b;

    /* renamed from: c  reason: collision with root package name */
    private final b f19200c = new b(this, wd.b.f21519h + " ConnectionPool");

    /* renamed from: d  reason: collision with root package name */
    private final ConcurrentLinkedQueue<f> f19201d = new ConcurrentLinkedQueue<>();

    /* renamed from: e  reason: collision with root package name */
    private final int f19202e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public static final class b extends zd.a {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ h f19203e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(h hVar, String str) {
            super(str, false, 2, (f) null);
            this.f19203e = hVar;
        }

        public long f() {
            return this.f19203e.b(System.nanoTime());
        }
    }

    static {
        new a((f) null);
    }

    public h(@NotNull e eVar, int i10, long j10, @NotNull TimeUnit timeUnit) {
        mb.h.e(eVar, "taskRunner");
        mb.h.e(timeUnit, "timeUnit");
        this.f19202e = i10;
        this.f19198a = timeUnit.toNanos(j10);
        this.f19199b = eVar.i();
        if (!(j10 > 0)) {
            throw new IllegalArgumentException(("keepAliveDuration <= 0: " + j10).toString());
        }
    }

    private final int d(f fVar, long j10) {
        if (!wd.b.f21518g || Thread.holdsLock(fVar)) {
            List<Reference<e>> o10 = fVar.o();
            int i10 = 0;
            while (i10 < o10.size()) {
                Reference reference = o10.get(i10);
                if (reference.get() != null) {
                    i10++;
                } else {
                    okhttp3.internal.platform.h.f20683c.g().l("A connection to " + fVar.A().a().l() + " was leaked. " + "Did you forget to close a response body?", ((e.b) reference).a());
                    o10.remove(i10);
                    fVar.D(true);
                    if (o10.isEmpty()) {
                        fVar.C(j10 - this.f19198a);
                        return 0;
                    }
                }
            }
            return o10.size();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Thread ");
        Thread currentThread = Thread.currentThread();
        mb.h.d(currentThread, "Thread.currentThread()");
        sb2.append(currentThread.getName());
        sb2.append(" MUST hold lock on ");
        sb2.append(fVar);
        throw new AssertionError(sb2.toString());
    }

    public final boolean a(@NotNull vd.a aVar, @NotNull e eVar, @Nullable List<f0> list, boolean z10) {
        mb.h.e(aVar, "address");
        mb.h.e(eVar, "call");
        Iterator<f> it = this.f19201d.iterator();
        while (it.hasNext()) {
            f next = it.next();
            mb.h.d(next, "connection");
            synchronized (next) {
                if (z10) {
                    if (!next.w()) {
                        u uVar = u.f160a;
                    }
                }
                if (next.u(aVar, list)) {
                    eVar.e(next);
                    return true;
                }
                u uVar2 = u.f160a;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x007d, code lost:
        wd.b.k(r3.E());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x008a, code lost:
        if (r10.f19201d.isEmpty() == false) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x008c, code lost:
        r10.f19199b.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0091, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long b(long r11) {
        /*
            r10 = this;
            java.util.concurrent.ConcurrentLinkedQueue<ae.f> r0 = r10.f19201d
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
            r2 = 0
            r3 = -9223372036854775808
            r4 = r3
            r3 = r2
            r2 = r1
        L_0x000d:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto L_0x0040
            java.lang.Object r6 = r0.next()
            ae.f r6 = (ae.f) r6
            java.lang.String r7 = "connection"
            mb.h.d(r6, r7)
            monitor-enter(r6)
            int r7 = r10.d(r6, r11)     // Catch:{ all -> 0x003d }
            if (r7 <= 0) goto L_0x0028
            int r2 = r2 + 1
            goto L_0x003b
        L_0x0028:
            int r1 = r1 + 1
            long r7 = r6.p()     // Catch:{ all -> 0x003d }
            long r7 = r11 - r7
            int r9 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r9 <= 0) goto L_0x0039
            ab.u r3 = ab.u.f160a     // Catch:{ all -> 0x003d }
            r3 = r6
            r4 = r7
            goto L_0x003b
        L_0x0039:
            ab.u r7 = ab.u.f160a     // Catch:{ all -> 0x003d }
        L_0x003b:
            monitor-exit(r6)
            goto L_0x000d
        L_0x003d:
            r11 = move-exception
            monitor-exit(r6)
            throw r11
        L_0x0040:
            long r6 = r10.f19198a
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 >= 0) goto L_0x0055
            int r0 = r10.f19202e
            if (r1 <= r0) goto L_0x004b
            goto L_0x0055
        L_0x004b:
            if (r1 <= 0) goto L_0x004f
            long r6 = r6 - r4
            return r6
        L_0x004f:
            if (r2 <= 0) goto L_0x0052
            return r6
        L_0x0052:
            r11 = -1
            return r11
        L_0x0055:
            mb.h.c(r3)
            monitor-enter(r3)
            java.util.List r0 = r3.o()     // Catch:{ all -> 0x0092 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0092 }
            r1 = 1
            r0 = r0 ^ r1
            r6 = 0
            if (r0 == 0) goto L_0x0069
            monitor-exit(r3)
            return r6
        L_0x0069:
            long r8 = r3.p()     // Catch:{ all -> 0x0092 }
            long r8 = r8 + r4
            int r11 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r11 == 0) goto L_0x0074
            monitor-exit(r3)
            return r6
        L_0x0074:
            r3.D(r1)     // Catch:{ all -> 0x0092 }
            java.util.concurrent.ConcurrentLinkedQueue<ae.f> r11 = r10.f19201d     // Catch:{ all -> 0x0092 }
            r11.remove(r3)     // Catch:{ all -> 0x0092 }
            monitor-exit(r3)
            java.net.Socket r11 = r3.E()
            wd.b.k(r11)
            java.util.concurrent.ConcurrentLinkedQueue<ae.f> r11 = r10.f19201d
            boolean r11 = r11.isEmpty()
            if (r11 == 0) goto L_0x0091
            zd.d r11 = r10.f19199b
            r11.a()
        L_0x0091:
            return r6
        L_0x0092:
            r11 = move-exception
            monitor-exit(r3)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: ae.h.b(long):long");
    }

    public final boolean c(@NotNull f fVar) {
        mb.h.e(fVar, "connection");
        if (wd.b.f21518g && !Thread.holdsLock(fVar)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Thread ");
            Thread currentThread = Thread.currentThread();
            mb.h.d(currentThread, "Thread.currentThread()");
            sb2.append(currentThread.getName());
            sb2.append(" MUST hold lock on ");
            sb2.append(fVar);
            throw new AssertionError(sb2.toString());
        } else if (fVar.q() || this.f19202e == 0) {
            fVar.D(true);
            this.f19201d.remove(fVar);
            if (!this.f19201d.isEmpty()) {
                return true;
            }
            this.f19199b.a();
            return true;
        } else {
            d.j(this.f19199b, this.f19200c, 0, 2, (Object) null);
            return false;
        }
    }

    public final void e(@NotNull f fVar) {
        mb.h.e(fVar, "connection");
        if (!wd.b.f21518g || Thread.holdsLock(fVar)) {
            this.f19201d.add(fVar);
            d.j(this.f19199b, this.f19200c, 0, 2, (Object) null);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Thread ");
        Thread currentThread = Thread.currentThread();
        mb.h.d(currentThread, "Thread.currentThread()");
        sb2.append(currentThread.getName());
        sb2.append(" MUST hold lock on ");
        sb2.append(fVar);
        throw new AssertionError(sb2.toString());
    }
}
