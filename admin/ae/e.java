package ae;

import ab.u;
import ie.d;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import mb.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vd.b0;
import vd.d0;
import vd.f;
import vd.g;
import vd.p;
import vd.r;
import vd.v;
import vd.z;

public final class e implements vd.e {

    /* renamed from: a  reason: collision with root package name */
    private final h f19154a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final r f19155b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final c f19156c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicBoolean f19157d = new AtomicBoolean();

    /* renamed from: e  reason: collision with root package name */
    private Object f19158e;

    /* renamed from: f  reason: collision with root package name */
    private d f19159f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private f f19160g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f19161h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private c f19162i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f19163j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f19164k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f19165l = true;

    /* renamed from: m  reason: collision with root package name */
    private volatile boolean f19166m;

    /* renamed from: n  reason: collision with root package name */
    private volatile c f19167n;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    private volatile f f19168o;
    @NotNull

    /* renamed from: p  reason: collision with root package name */
    private final z f19169p;
    @NotNull

    /* renamed from: q  reason: collision with root package name */
    private final b0 f19170q;

    /* renamed from: r  reason: collision with root package name */
    private final boolean f19171r;

    public final class a implements Runnable {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private volatile AtomicInteger f19172a = new AtomicInteger(0);

        /* renamed from: b  reason: collision with root package name */
        private final f f19173b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ e f19174c;

        public a(@NotNull e eVar, f fVar) {
            h.e(fVar, "responseCallback");
            this.f19174c = eVar;
            this.f19173b = fVar;
        }

        public final void a(@NotNull ExecutorService executorService) {
            h.e(executorService, "executorService");
            p q10 = this.f19174c.o().q();
            if (!wd.b.f21518g || !Thread.holdsLock(q10)) {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e10) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e10);
                    this.f19174c.B(interruptedIOException);
                    this.f19173b.b(this.f19174c, interruptedIOException);
                    this.f19174c.o().q().f(this);
                } catch (Throwable th) {
                    this.f19174c.o().q().f(this);
                    throw th;
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Thread ");
                Thread currentThread = Thread.currentThread();
                h.d(currentThread, "Thread.currentThread()");
                sb2.append(currentThread.getName());
                sb2.append(" MUST NOT hold lock on ");
                sb2.append(q10);
                throw new AssertionError(sb2.toString());
            }
        }

        @NotNull
        public final e b() {
            return this.f19174c;
        }

        @NotNull
        public final AtomicInteger c() {
            return this.f19172a;
        }

        @NotNull
        public final String d() {
            return this.f19174c.t().j().i();
        }

        public final void e(@NotNull a aVar) {
            h.e(aVar, "other");
            this.f19172a = aVar.f19172a;
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x005d A[Catch:{ all -> 0x007e, all -> 0x00cc }] */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0086 A[Catch:{ all -> 0x007e, all -> 0x00cc }] */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x00a8 A[Catch:{ all -> 0x007e, all -> 0x00cc }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r7 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "OkHttp "
                r0.append(r1)
                ae.e r1 = r7.f19174c
                java.lang.String r1 = r1.C()
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                java.lang.Thread r1 = java.lang.Thread.currentThread()
                java.lang.String r2 = "currentThread"
                mb.h.d(r1, r2)
                java.lang.String r2 = r1.getName()
                r1.setName(r0)
                r0 = 0
                ae.e r3 = r7.f19174c     // Catch:{ all -> 0x00cc }
                ae.e$c r3 = r3.f19156c     // Catch:{ all -> 0x00cc }
                r3.r()     // Catch:{ all -> 0x00cc }
                ae.e r3 = r7.f19174c     // Catch:{ IOException -> 0x0080, all -> 0x0052 }
                vd.d0 r0 = r3.v()     // Catch:{ IOException -> 0x0080, all -> 0x0052 }
                r3 = 1
                vd.f r4 = r7.f19173b     // Catch:{ IOException -> 0x0050, all -> 0x004e }
                ae.e r5 = r7.f19174c     // Catch:{ IOException -> 0x0050, all -> 0x004e }
                r4.a(r5, r0)     // Catch:{ IOException -> 0x0050, all -> 0x004e }
                ae.e r0 = r7.f19174c     // Catch:{ all -> 0x00cc }
                vd.z r0 = r0.o()     // Catch:{ all -> 0x00cc }
                vd.p r0 = r0.q()     // Catch:{ all -> 0x00cc }
            L_0x0049:
                r0.f(r7)     // Catch:{ all -> 0x00cc }
                goto L_0x00ba
            L_0x004e:
                r0 = move-exception
                goto L_0x0056
            L_0x0050:
                r0 = move-exception
                goto L_0x0084
            L_0x0052:
                r3 = move-exception
                r6 = r3
                r3 = r0
                r0 = r6
            L_0x0056:
                ae.e r4 = r7.f19174c     // Catch:{ all -> 0x007e }
                r4.cancel()     // Catch:{ all -> 0x007e }
                if (r3 != 0) goto L_0x007d
                java.io.IOException r3 = new java.io.IOException     // Catch:{ all -> 0x007e }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x007e }
                r4.<init>()     // Catch:{ all -> 0x007e }
                java.lang.String r5 = "canceled due to "
                r4.append(r5)     // Catch:{ all -> 0x007e }
                r4.append(r0)     // Catch:{ all -> 0x007e }
                java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x007e }
                r3.<init>(r4)     // Catch:{ all -> 0x007e }
                ab.b.a(r3, r0)     // Catch:{ all -> 0x007e }
                vd.f r4 = r7.f19173b     // Catch:{ all -> 0x007e }
                ae.e r5 = r7.f19174c     // Catch:{ all -> 0x007e }
                r4.b(r5, r3)     // Catch:{ all -> 0x007e }
            L_0x007d:
                throw r0     // Catch:{ all -> 0x007e }
            L_0x007e:
                r0 = move-exception
                goto L_0x00be
            L_0x0080:
                r3 = move-exception
                r6 = r3
                r3 = r0
                r0 = r6
            L_0x0084:
                if (r3 == 0) goto L_0x00a8
                okhttp3.internal.platform.h$a r3 = okhttp3.internal.platform.h.f20683c     // Catch:{ all -> 0x007e }
                okhttp3.internal.platform.h r3 = r3.g()     // Catch:{ all -> 0x007e }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x007e }
                r4.<init>()     // Catch:{ all -> 0x007e }
                java.lang.String r5 = "Callback failure for "
                r4.append(r5)     // Catch:{ all -> 0x007e }
                ae.e r5 = r7.f19174c     // Catch:{ all -> 0x007e }
                java.lang.String r5 = r5.I()     // Catch:{ all -> 0x007e }
                r4.append(r5)     // Catch:{ all -> 0x007e }
                java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x007e }
                r5 = 4
                r3.j(r4, r5, r0)     // Catch:{ all -> 0x007e }
                goto L_0x00af
            L_0x00a8:
                vd.f r3 = r7.f19173b     // Catch:{ all -> 0x007e }
                ae.e r4 = r7.f19174c     // Catch:{ all -> 0x007e }
                r3.b(r4, r0)     // Catch:{ all -> 0x007e }
            L_0x00af:
                ae.e r0 = r7.f19174c     // Catch:{ all -> 0x00cc }
                vd.z r0 = r0.o()     // Catch:{ all -> 0x00cc }
                vd.p r0 = r0.q()     // Catch:{ all -> 0x00cc }
                goto L_0x0049
            L_0x00ba:
                r1.setName(r2)
                return
            L_0x00be:
                ae.e r3 = r7.f19174c     // Catch:{ all -> 0x00cc }
                vd.z r3 = r3.o()     // Catch:{ all -> 0x00cc }
                vd.p r3 = r3.q()     // Catch:{ all -> 0x00cc }
                r3.f(r7)     // Catch:{ all -> 0x00cc }
                throw r0     // Catch:{ all -> 0x00cc }
            L_0x00cc:
                r0 = move-exception
                r1.setName(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: ae.e.a.run():void");
        }
    }

    public static final class b extends WeakReference<e> {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private final Object f19175a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(@NotNull e eVar, @Nullable Object obj) {
            super(eVar);
            h.e(eVar, "referent");
            this.f19175a = obj;
        }

        @Nullable
        public final Object a() {
            return this.f19175a;
        }
    }

    public static final class c extends d {

        /* renamed from: l  reason: collision with root package name */
        final /* synthetic */ e f19176l;

        c(e eVar) {
            this.f19176l = eVar;
        }

        /* access modifiers changed from: protected */
        public void x() {
            this.f19176l.cancel();
        }
    }

    public e(@NotNull z zVar, @NotNull b0 b0Var, boolean z10) {
        h.e(zVar, "client");
        h.e(b0Var, "originalRequest");
        this.f19169p = zVar;
        this.f19170q = b0Var;
        this.f19171r = z10;
        this.f19154a = zVar.n().a();
        this.f19155b = zVar.s().a(this);
        c cVar = new c(this);
        cVar.g((long) zVar.j(), TimeUnit.MILLISECONDS);
        u uVar = u.f160a;
        this.f19156c = cVar;
    }

    private final <E extends IOException> E H(E e10) {
        if (this.f19161h || !this.f19156c.s()) {
            return e10;
        }
        E interruptedIOException = new InterruptedIOException("timeout");
        if (e10 != null) {
            interruptedIOException.initCause(e10);
        }
        return interruptedIOException;
    }

    /* access modifiers changed from: private */
    public final String I() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(h() ? "canceled " : "");
        sb2.append(this.f19171r ? "web socket" : "call");
        sb2.append(" to ");
        sb2.append(C());
        return sb2.toString();
    }

    private final <E extends IOException> E g(E e10) {
        Socket D;
        boolean z10 = wd.b.f21518g;
        if (!z10 || !Thread.holdsLock(this)) {
            f fVar = this.f19160g;
            if (fVar != null) {
                if (!z10 || !Thread.holdsLock(fVar)) {
                    synchronized (fVar) {
                        D = D();
                    }
                    if (this.f19160g == null) {
                        if (D != null) {
                            wd.b.k(D);
                        }
                        this.f19155b.k(this, fVar);
                    } else {
                        if (!(D == null)) {
                            throw new IllegalStateException("Check failed.".toString());
                        }
                    }
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Thread ");
                    Thread currentThread = Thread.currentThread();
                    h.d(currentThread, "Thread.currentThread()");
                    sb2.append(currentThread.getName());
                    sb2.append(" MUST NOT hold lock on ");
                    sb2.append(fVar);
                    throw new AssertionError(sb2.toString());
                }
            }
            E H = H(e10);
            if (e10 != null) {
                r rVar = this.f19155b;
                h.c(H);
                rVar.d(this, H);
            } else {
                this.f19155b.c(this);
            }
            return H;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Thread ");
        Thread currentThread2 = Thread.currentThread();
        h.d(currentThread2, "Thread.currentThread()");
        sb3.append(currentThread2.getName());
        sb3.append(" MUST NOT hold lock on ");
        sb3.append(this);
        throw new AssertionError(sb3.toString());
    }

    private final void i() {
        this.f19158e = okhttp3.internal.platform.h.f20683c.g().h("response.body().close()");
        this.f19155b.e(this);
    }

    private final vd.a l(v vVar) {
        g gVar;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        if (vVar.j()) {
            SSLSocketFactory L = this.f19169p.L();
            hostnameVerifier = this.f19169p.A();
            sSLSocketFactory = L;
            gVar = this.f19169p.l();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            gVar = null;
        }
        return new vd.a(vVar.i(), vVar.n(), this.f19169p.r(), this.f19169p.K(), sSLSocketFactory, hostnameVerifier, gVar, this.f19169p.G(), this.f19169p.F(), this.f19169p.E(), this.f19169p.o(), this.f19169p.H());
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0023 A[Catch:{ all -> 0x0019 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0027 A[Catch:{ all -> 0x0019 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0031 A[Catch:{ all -> 0x0019 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0033 A[Catch:{ all -> 0x0019 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x003e A[Catch:{ all -> 0x0019 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x003f A[Catch:{ all -> 0x0019 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <E extends java.io.IOException> E A(@org.jetbrains.annotations.NotNull ae.c r3, boolean r4, boolean r5, E r6) {
        /*
            r2 = this;
            java.lang.String r0 = "exchange"
            mb.h.e(r3, r0)
            ae.c r0 = r2.f19167n
            boolean r3 = mb.h.a(r3, r0)
            r0 = 1
            r3 = r3 ^ r0
            if (r3 == 0) goto L_0x0010
            return r6
        L_0x0010:
            monitor-enter(r2)
            r3 = 0
            if (r4 == 0) goto L_0x001b
            boolean r1 = r2.f19163j     // Catch:{ all -> 0x0019 }
            if (r1 != 0) goto L_0x0021
            goto L_0x001b
        L_0x0019:
            r3 = move-exception
            goto L_0x005a
        L_0x001b:
            if (r5 == 0) goto L_0x0042
            boolean r1 = r2.f19164k     // Catch:{ all -> 0x0019 }
            if (r1 == 0) goto L_0x0042
        L_0x0021:
            if (r4 == 0) goto L_0x0025
            r2.f19163j = r3     // Catch:{ all -> 0x0019 }
        L_0x0025:
            if (r5 == 0) goto L_0x0029
            r2.f19164k = r3     // Catch:{ all -> 0x0019 }
        L_0x0029:
            boolean r4 = r2.f19163j     // Catch:{ all -> 0x0019 }
            if (r4 != 0) goto L_0x0033
            boolean r5 = r2.f19164k     // Catch:{ all -> 0x0019 }
            if (r5 != 0) goto L_0x0033
            r5 = r0
            goto L_0x0034
        L_0x0033:
            r5 = r3
        L_0x0034:
            if (r4 != 0) goto L_0x003f
            boolean r4 = r2.f19164k     // Catch:{ all -> 0x0019 }
            if (r4 != 0) goto L_0x003f
            boolean r4 = r2.f19165l     // Catch:{ all -> 0x0019 }
            if (r4 != 0) goto L_0x003f
            goto L_0x0040
        L_0x003f:
            r0 = r3
        L_0x0040:
            r3 = r5
            goto L_0x0043
        L_0x0042:
            r0 = r3
        L_0x0043:
            ab.u r4 = ab.u.f160a     // Catch:{ all -> 0x0019 }
            monitor-exit(r2)
            if (r3 == 0) goto L_0x0052
            r3 = 0
            r2.f19167n = r3
            ae.f r3 = r2.f19160g
            if (r3 == 0) goto L_0x0052
            r3.t()
        L_0x0052:
            if (r0 == 0) goto L_0x0059
            java.io.IOException r3 = r2.g(r6)
            return r3
        L_0x0059:
            return r6
        L_0x005a:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ae.e.A(ae.c, boolean, boolean, java.io.IOException):java.io.IOException");
    }

    @Nullable
    public final IOException B(@Nullable IOException iOException) {
        boolean z10;
        synchronized (this) {
            z10 = false;
            if (this.f19165l) {
                this.f19165l = false;
                if (!this.f19163j && !this.f19164k) {
                    z10 = true;
                }
            }
            u uVar = u.f160a;
        }
        return z10 ? g(iOException) : iOException;
    }

    @NotNull
    public final String C() {
        return this.f19170q.j().p();
    }

    @Nullable
    public final Socket D() {
        f fVar = this.f19160g;
        h.c(fVar);
        if (!wd.b.f21518g || Thread.holdsLock(fVar)) {
            List<Reference<e>> o10 = fVar.o();
            Iterator<Reference<e>> it = o10.iterator();
            boolean z10 = false;
            int i10 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i10 = -1;
                    break;
                } else if (h.a((e) it.next().get(), this)) {
                    break;
                } else {
                    i10++;
                }
            }
            if (i10 != -1) {
                z10 = true;
            }
            if (z10) {
                o10.remove(i10);
                this.f19160g = null;
                if (o10.isEmpty()) {
                    fVar.C(System.nanoTime());
                    if (this.f19154a.c(fVar)) {
                        return fVar.E();
                    }
                }
                return null;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Thread ");
        Thread currentThread = Thread.currentThread();
        h.d(currentThread, "Thread.currentThread()");
        sb2.append(currentThread.getName());
        sb2.append(" MUST hold lock on ");
        sb2.append(fVar);
        throw new AssertionError(sb2.toString());
    }

    public final boolean E() {
        d dVar = this.f19159f;
        h.c(dVar);
        return dVar.e();
    }

    public final void F(@Nullable f fVar) {
        this.f19168o = fVar;
    }

    public final void G() {
        if (!this.f19161h) {
            this.f19161h = true;
            this.f19156c.s();
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @NotNull
    public d0 c() {
        if (this.f19157d.compareAndSet(false, true)) {
            this.f19156c.r();
            i();
            try {
                this.f19169p.q().b(this);
                return v();
            } finally {
                this.f19169p.q().g(this);
            }
        } else {
            throw new IllegalStateException("Already Executed".toString());
        }
    }

    public void cancel() {
        if (!this.f19166m) {
            this.f19166m = true;
            c cVar = this.f19167n;
            if (cVar != null) {
                cVar.b();
            }
            f fVar = this.f19168o;
            if (fVar != null) {
                fVar.e();
            }
            this.f19155b.f(this);
        }
    }

    public final void e(@NotNull f fVar) {
        h.e(fVar, "connection");
        if (!wd.b.f21518g || Thread.holdsLock(fVar)) {
            if (this.f19160g == null) {
                this.f19160g = fVar;
                fVar.o().add(new b(this, this.f19158e));
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Thread ");
        Thread currentThread = Thread.currentThread();
        h.d(currentThread, "Thread.currentThread()");
        sb2.append(currentThread.getName());
        sb2.append(" MUST hold lock on ");
        sb2.append(fVar);
        throw new AssertionError(sb2.toString());
    }

    @NotNull
    public b0 f() {
        return this.f19170q;
    }

    public boolean h() {
        return this.f19166m;
    }

    @NotNull
    /* renamed from: j */
    public e clone() {
        return new e(this.f19169p, this.f19170q, this.f19171r);
    }

    public final void m(@NotNull b0 b0Var, boolean z10) {
        h.e(b0Var, "request");
        if (this.f19162i == null) {
            synchronized (this) {
                if (!(!this.f19164k)) {
                    throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
                } else if (!this.f19163j) {
                    u uVar = u.f160a;
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
            if (z10) {
                this.f19159f = new d(this.f19154a, l(b0Var.j()), this, this.f19155b);
                return;
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final void n(boolean z10) {
        c cVar;
        synchronized (this) {
            if (this.f19165l) {
                u uVar = u.f160a;
            } else {
                throw new IllegalStateException("released".toString());
            }
        }
        if (z10 && (cVar = this.f19167n) != null) {
            cVar.d();
        }
        this.f19162i = null;
    }

    @NotNull
    public final z o() {
        return this.f19169p;
    }

    @Nullable
    public final f p() {
        return this.f19160g;
    }

    @NotNull
    public final r q() {
        return this.f19155b;
    }

    public final boolean r() {
        return this.f19171r;
    }

    @Nullable
    public final c s() {
        return this.f19162i;
    }

    @NotNull
    public final b0 t() {
        return this.f19170q;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a3  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final vd.d0 v() {
        /*
            r11 = this;
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            vd.z r0 = r11.f19169p
            java.util.List r0 = r0.B()
            boolean unused = bb.q.p(r2, r0)
            be.j r0 = new be.j
            vd.z r1 = r11.f19169p
            r0.<init>(r1)
            r2.add(r0)
            be.a r0 = new be.a
            vd.z r1 = r11.f19169p
            vd.n r1 = r1.p()
            r0.<init>(r1)
            r2.add(r0)
            yd.a r0 = new yd.a
            vd.z r1 = r11.f19169p
            vd.c r1 = r1.i()
            r0.<init>(r1)
            r2.add(r0)
            ae.a r0 = ae.a.f19122a
            r2.add(r0)
            boolean r0 = r11.f19171r
            if (r0 != 0) goto L_0x0046
            vd.z r0 = r11.f19169p
            java.util.List r0 = r0.C()
            boolean unused = bb.q.p(r2, r0)
        L_0x0046:
            be.b r0 = new be.b
            boolean r1 = r11.f19171r
            r0.<init>(r1)
            r2.add(r0)
            be.g r9 = new be.g
            r3 = 0
            r4 = 0
            vd.b0 r5 = r11.f19170q
            vd.z r0 = r11.f19169p
            int r6 = r0.m()
            vd.z r0 = r11.f19169p
            int r7 = r0.I()
            vd.z r0 = r11.f19169p
            int r8 = r0.N()
            r0 = r9
            r1 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = 0
            r1 = 0
            vd.b0 r2 = r11.f19170q     // Catch:{ IOException -> 0x008c, all -> 0x008a }
            vd.d0 r2 = r9.a(r2)     // Catch:{ IOException -> 0x008c, all -> 0x008a }
            boolean r3 = r11.h()     // Catch:{ IOException -> 0x008c, all -> 0x008a }
            if (r3 != 0) goto L_0x007f
            r11.B(r1)
            return r2
        L_0x007f:
            wd.b.j(r2)     // Catch:{ IOException -> 0x008c, all -> 0x008a }
            java.io.IOException r2 = new java.io.IOException     // Catch:{ IOException -> 0x008c, all -> 0x008a }
            java.lang.String r3 = "Canceled"
            r2.<init>(r3)     // Catch:{ IOException -> 0x008c, all -> 0x008a }
            throw r2     // Catch:{ IOException -> 0x008c, all -> 0x008a }
        L_0x008a:
            r2 = move-exception
            goto L_0x00a1
        L_0x008c:
            r0 = move-exception
            r2 = 1
            java.io.IOException r0 = r11.B(r0)     // Catch:{ all -> 0x009d }
            if (r0 != 0) goto L_0x009c
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ all -> 0x009d }
            java.lang.String r3 = "null cannot be cast to non-null type kotlin.Throwable"
            r0.<init>(r3)     // Catch:{ all -> 0x009d }
            throw r0     // Catch:{ all -> 0x009d }
        L_0x009c:
            throw r0     // Catch:{ all -> 0x009d }
        L_0x009d:
            r0 = move-exception
            r10 = r2
            r2 = r0
            r0 = r10
        L_0x00a1:
            if (r0 != 0) goto L_0x00a6
            r11.B(r1)
        L_0x00a6:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ae.e.v():vd.d0");
    }

    public void w(@NotNull f fVar) {
        h.e(fVar, "responseCallback");
        if (this.f19157d.compareAndSet(false, true)) {
            i();
            this.f19169p.q().a(new a(this, fVar));
            return;
        }
        throw new IllegalStateException("Already Executed".toString());
    }

    @NotNull
    public final c y(@NotNull be.g gVar) {
        h.e(gVar, "chain");
        synchronized (this) {
            if (!this.f19165l) {
                throw new IllegalStateException("released".toString());
            } else if (!(!this.f19164k)) {
                throw new IllegalStateException("Check failed.".toString());
            } else if (!this.f19163j) {
                u uVar = u.f160a;
            } else {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        d dVar = this.f19159f;
        h.c(dVar);
        c cVar = new c(this, this.f19155b, dVar, dVar.a(this.f19169p, gVar));
        this.f19162i = cVar;
        this.f19167n = cVar;
        synchronized (this) {
            this.f19163j = true;
            this.f19164k = true;
        }
        if (!this.f19166m) {
            return cVar;
        }
        throw new IOException("Canceled");
    }
}
