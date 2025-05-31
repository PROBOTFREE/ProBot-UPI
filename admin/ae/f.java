package ae;

import de.f;
import de.m;
import de.n;
import ge.d;
import ie.g;
import ie.o;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import mb.h;
import mb.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vd.a0;
import vd.b0;
import vd.c0;
import vd.d0;
import vd.f0;
import vd.j;
import vd.r;
import vd.t;
import vd.v;
import vd.z;
import zd.e;

public final class f extends f.d implements j {

    /* renamed from: b  reason: collision with root package name */
    private Socket f19177b;

    /* renamed from: c  reason: collision with root package name */
    private Socket f19178c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public t f19179d;

    /* renamed from: e  reason: collision with root package name */
    private a0 f19180e;

    /* renamed from: f  reason: collision with root package name */
    private de.f f19181f;

    /* renamed from: g  reason: collision with root package name */
    private g f19182g;

    /* renamed from: h  reason: collision with root package name */
    private ie.f f19183h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f19184i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f19185j;

    /* renamed from: k  reason: collision with root package name */
    private int f19186k;

    /* renamed from: l  reason: collision with root package name */
    private int f19187l;

    /* renamed from: m  reason: collision with root package name */
    private int f19188m;

    /* renamed from: n  reason: collision with root package name */
    private int f19189n = 1;
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    private final List<Reference<e>> f19190o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    private long f19191p = Long.MAX_VALUE;

    /* renamed from: q  reason: collision with root package name */
    private final f0 f19192q;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(mb.f fVar) {
            this();
        }
    }

    static final class b extends i implements lb.a<List<? extends Certificate>> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ vd.g f19193b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ t f19194c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ vd.a f19195d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(vd.g gVar, t tVar, vd.a aVar) {
            super(0);
            this.f19193b = gVar;
            this.f19194c = tVar;
            this.f19195d = aVar;
        }

        @NotNull
        /* renamed from: a */
        public final List<Certificate> b() {
            ge.c d10 = this.f19193b.d();
            h.c(d10);
            return d10.a(this.f19194c.d(), this.f19195d.l().i());
        }
    }

    static final class c extends i implements lb.a<List<? extends X509Certificate>> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f f19196b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(f fVar) {
            super(0);
            this.f19196b = fVar;
        }

        @NotNull
        /* renamed from: a */
        public final List<X509Certificate> b() {
            t d10 = this.f19196b.f19179d;
            h.c(d10);
            List<Certificate> d11 = d10.d();
            ArrayList arrayList = new ArrayList(m.n(d11, 10));
            for (Certificate certificate : d11) {
                Objects.requireNonNull(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                arrayList.add((X509Certificate) certificate);
            }
            return arrayList;
        }
    }

    static {
        new a((mb.f) null);
    }

    public f(@NotNull h hVar, @NotNull f0 f0Var) {
        h.e(hVar, "connectionPool");
        h.e(f0Var, "route");
        this.f19192q = f0Var;
    }

    private final boolean B(List<f0> list) {
        boolean z10;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (f0 f0Var : list) {
                if (f0Var.b().type() == Proxy.Type.DIRECT && this.f19192q.b().type() == Proxy.Type.DIRECT && h.a(this.f19192q.d(), f0Var.d())) {
                    z10 = true;
                    continue;
                } else {
                    z10 = false;
                    continue;
                }
                if (z10) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void F(int i10) {
        Socket socket = this.f19178c;
        h.c(socket);
        g gVar = this.f19182g;
        h.c(gVar);
        ie.f fVar = this.f19183h;
        h.c(fVar);
        socket.setSoTimeout(0);
        de.f a10 = new f.b(true, e.f21830h).m(socket, this.f19192q.a().l().i(), gVar, fVar).k(this).l(i10).a();
        this.f19181f = a10;
        this.f19189n = de.f.D.a().d();
        de.f.C0(a10, false, (e) null, 3, (Object) null);
    }

    private final boolean G(v vVar) {
        t tVar;
        if (!wd.b.f21518g || Thread.holdsLock(this)) {
            v l10 = this.f19192q.a().l();
            if (vVar.n() != l10.n()) {
                return false;
            }
            if (h.a(vVar.i(), l10.i())) {
                return true;
            }
            if (this.f19185j || (tVar = this.f19179d) == null) {
                return false;
            }
            h.c(tVar);
            return f(vVar, tVar);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Thread ");
        Thread currentThread = Thread.currentThread();
        h.d(currentThread, "Thread.currentThread()");
        sb2.append(currentThread.getName());
        sb2.append(" MUST hold lock on ");
        sb2.append(this);
        throw new AssertionError(sb2.toString());
    }

    private final boolean f(v vVar, t tVar) {
        List<Certificate> d10 = tVar.d();
        if (!d10.isEmpty()) {
            d dVar = d.f20001a;
            String i10 = vVar.i();
            Certificate certificate = d10.get(0);
            Objects.requireNonNull(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            if (dVar.c(i10, (X509Certificate) certificate)) {
                return true;
            }
        }
        return false;
    }

    private final void i(int i10, int i11, vd.e eVar, r rVar) {
        Socket socket;
        int i12;
        Proxy b10 = this.f19192q.b();
        vd.a a10 = this.f19192q.a();
        Proxy.Type type = b10.type();
        if (type != null && ((i12 = g.f19197a[type.ordinal()]) == 1 || i12 == 2)) {
            socket = a10.j().createSocket();
            h.c(socket);
        } else {
            socket = new Socket(b10);
        }
        this.f19177b = socket;
        rVar.i(eVar, this.f19192q.d(), b10);
        socket.setSoTimeout(i11);
        try {
            okhttp3.internal.platform.h.f20683c.g().f(socket, this.f19192q.d(), i10);
            try {
                this.f19182g = o.b(o.f(socket));
                this.f19183h = o.a(o.d(socket));
            } catch (NullPointerException e10) {
                if (h.a(e10.getMessage(), "throw with null exception")) {
                    throw new IOException(e10);
                }
            }
        } catch (ConnectException e11) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f19192q.d());
            connectException.initCause(e11);
            throw connectException;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x018d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void j(ae.b r11) {
        /*
            r10 = this;
            vd.f0 r0 = r10.f19192q
            vd.a r0 = r0.a()
            javax.net.ssl.SSLSocketFactory r1 = r0.k()
            r2 = 0
            mb.h.c(r1)     // Catch:{ all -> 0x017f }
            java.net.Socket r3 = r10.f19177b     // Catch:{ all -> 0x017f }
            vd.v r4 = r0.l()     // Catch:{ all -> 0x017f }
            java.lang.String r4 = r4.i()     // Catch:{ all -> 0x017f }
            vd.v r5 = r0.l()     // Catch:{ all -> 0x017f }
            int r5 = r5.n()     // Catch:{ all -> 0x017f }
            r6 = 1
            java.net.Socket r1 = r1.createSocket(r3, r4, r5, r6)     // Catch:{ all -> 0x017f }
            if (r1 == 0) goto L_0x0177
            javax.net.ssl.SSLSocket r1 = (javax.net.ssl.SSLSocket) r1     // Catch:{ all -> 0x017f }
            vd.l r11 = r11.a(r1)     // Catch:{ all -> 0x0174 }
            boolean r3 = r11.h()     // Catch:{ all -> 0x0174 }
            if (r3 == 0) goto L_0x0048
            okhttp3.internal.platform.h$a r3 = okhttp3.internal.platform.h.f20683c     // Catch:{ all -> 0x0174 }
            okhttp3.internal.platform.h r3 = r3.g()     // Catch:{ all -> 0x0174 }
            vd.v r4 = r0.l()     // Catch:{ all -> 0x0174 }
            java.lang.String r4 = r4.i()     // Catch:{ all -> 0x0174 }
            java.util.List r5 = r0.f()     // Catch:{ all -> 0x0174 }
            r3.e(r1, r4, r5)     // Catch:{ all -> 0x0174 }
        L_0x0048:
            r1.startHandshake()     // Catch:{ all -> 0x0174 }
            javax.net.ssl.SSLSession r3 = r1.getSession()     // Catch:{ all -> 0x0174 }
            vd.t$a r4 = vd.t.f21233e     // Catch:{ all -> 0x0174 }
            java.lang.String r5 = "sslSocketSession"
            mb.h.d(r3, r5)     // Catch:{ all -> 0x0174 }
            vd.t r4 = r4.a(r3)     // Catch:{ all -> 0x0174 }
            javax.net.ssl.HostnameVerifier r5 = r0.e()     // Catch:{ all -> 0x0174 }
            mb.h.c(r5)     // Catch:{ all -> 0x0174 }
            vd.v r7 = r0.l()     // Catch:{ all -> 0x0174 }
            java.lang.String r7 = r7.i()     // Catch:{ all -> 0x0174 }
            boolean r3 = r5.verify(r7, r3)     // Catch:{ all -> 0x0174 }
            if (r3 != 0) goto L_0x0108
            java.util.List r11 = r4.d()     // Catch:{ all -> 0x0174 }
            boolean r3 = r11.isEmpty()     // Catch:{ all -> 0x0174 }
            r3 = r3 ^ r6
            if (r3 == 0) goto L_0x00e4
            r3 = 0
            java.lang.Object r11 = r11.get(r3)     // Catch:{ all -> 0x0174 }
            if (r11 != 0) goto L_0x0089
            java.lang.NullPointerException r11 = new java.lang.NullPointerException     // Catch:{ all -> 0x0174 }
            java.lang.String r0 = "null cannot be cast to non-null type java.security.cert.X509Certificate"
            r11.<init>(r0)     // Catch:{ all -> 0x0174 }
            throw r11     // Catch:{ all -> 0x0174 }
        L_0x0089:
            java.security.cert.X509Certificate r11 = (java.security.cert.X509Certificate) r11     // Catch:{ all -> 0x0174 }
            javax.net.ssl.SSLPeerUnverifiedException r3 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ all -> 0x0174 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0174 }
            r4.<init>()     // Catch:{ all -> 0x0174 }
            java.lang.String r5 = "\n              |Hostname "
            r4.append(r5)     // Catch:{ all -> 0x0174 }
            vd.v r0 = r0.l()     // Catch:{ all -> 0x0174 }
            java.lang.String r0 = r0.i()     // Catch:{ all -> 0x0174 }
            r4.append(r0)     // Catch:{ all -> 0x0174 }
            java.lang.String r0 = " not verified:\n              |    certificate: "
            r4.append(r0)     // Catch:{ all -> 0x0174 }
            vd.g$b r0 = vd.g.f21150d     // Catch:{ all -> 0x0174 }
            java.lang.String r0 = r0.a(r11)     // Catch:{ all -> 0x0174 }
            r4.append(r0)     // Catch:{ all -> 0x0174 }
            java.lang.String r0 = "\n              |    DN: "
            r4.append(r0)     // Catch:{ all -> 0x0174 }
            java.security.Principal r0 = r11.getSubjectDN()     // Catch:{ all -> 0x0174 }
            java.lang.String r5 = "cert.subjectDN"
            mb.h.d(r0, r5)     // Catch:{ all -> 0x0174 }
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x0174 }
            r4.append(r0)     // Catch:{ all -> 0x0174 }
            java.lang.String r0 = "\n              |    subjectAltNames: "
            r4.append(r0)     // Catch:{ all -> 0x0174 }
            ge.d r0 = ge.d.f20001a     // Catch:{ all -> 0x0174 }
            java.util.List r11 = r0.a(r11)     // Catch:{ all -> 0x0174 }
            r4.append(r11)     // Catch:{ all -> 0x0174 }
            java.lang.String r11 = "\n              "
            r4.append(r11)     // Catch:{ all -> 0x0174 }
            java.lang.String r11 = r4.toString()     // Catch:{ all -> 0x0174 }
            java.lang.String r11 = tb.i.e(r11, r2, r6, r2)     // Catch:{ all -> 0x0174 }
            r3.<init>(r11)     // Catch:{ all -> 0x0174 }
            throw r3     // Catch:{ all -> 0x0174 }
        L_0x00e4:
            javax.net.ssl.SSLPeerUnverifiedException r11 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ all -> 0x0174 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0174 }
            r2.<init>()     // Catch:{ all -> 0x0174 }
            java.lang.String r3 = "Hostname "
            r2.append(r3)     // Catch:{ all -> 0x0174 }
            vd.v r0 = r0.l()     // Catch:{ all -> 0x0174 }
            java.lang.String r0 = r0.i()     // Catch:{ all -> 0x0174 }
            r2.append(r0)     // Catch:{ all -> 0x0174 }
            java.lang.String r0 = " not verified (no certificates)"
            r2.append(r0)     // Catch:{ all -> 0x0174 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0174 }
            r11.<init>(r0)     // Catch:{ all -> 0x0174 }
            throw r11     // Catch:{ all -> 0x0174 }
        L_0x0108:
            vd.g r3 = r0.a()     // Catch:{ all -> 0x0174 }
            mb.h.c(r3)     // Catch:{ all -> 0x0174 }
            vd.t r5 = new vd.t     // Catch:{ all -> 0x0174 }
            vd.g0 r6 = r4.e()     // Catch:{ all -> 0x0174 }
            vd.i r7 = r4.a()     // Catch:{ all -> 0x0174 }
            java.util.List r8 = r4.c()     // Catch:{ all -> 0x0174 }
            ae.f$b r9 = new ae.f$b     // Catch:{ all -> 0x0174 }
            r9.<init>(r3, r4, r0)     // Catch:{ all -> 0x0174 }
            r5.<init>(r6, r7, r8, r9)     // Catch:{ all -> 0x0174 }
            r10.f19179d = r5     // Catch:{ all -> 0x0174 }
            vd.v r0 = r0.l()     // Catch:{ all -> 0x0174 }
            java.lang.String r0 = r0.i()     // Catch:{ all -> 0x0174 }
            ae.f$c r4 = new ae.f$c     // Catch:{ all -> 0x0174 }
            r4.<init>(r10)     // Catch:{ all -> 0x0174 }
            r3.b(r0, r4)     // Catch:{ all -> 0x0174 }
            boolean r11 = r11.h()     // Catch:{ all -> 0x0174 }
            if (r11 == 0) goto L_0x0147
            okhttp3.internal.platform.h$a r11 = okhttp3.internal.platform.h.f20683c     // Catch:{ all -> 0x0174 }
            okhttp3.internal.platform.h r11 = r11.g()     // Catch:{ all -> 0x0174 }
            java.lang.String r2 = r11.g(r1)     // Catch:{ all -> 0x0174 }
        L_0x0147:
            r10.f19178c = r1     // Catch:{ all -> 0x0174 }
            ie.a0 r11 = ie.o.f(r1)     // Catch:{ all -> 0x0174 }
            ie.g r11 = ie.o.b(r11)     // Catch:{ all -> 0x0174 }
            r10.f19182g = r11     // Catch:{ all -> 0x0174 }
            ie.y r11 = ie.o.d(r1)     // Catch:{ all -> 0x0174 }
            ie.f r11 = ie.o.a(r11)     // Catch:{ all -> 0x0174 }
            r10.f19183h = r11     // Catch:{ all -> 0x0174 }
            if (r2 == 0) goto L_0x0166
            vd.a0$a r11 = vd.a0.f21067i     // Catch:{ all -> 0x0174 }
            vd.a0 r11 = r11.a(r2)     // Catch:{ all -> 0x0174 }
            goto L_0x0168
        L_0x0166:
            vd.a0 r11 = vd.a0.HTTP_1_1     // Catch:{ all -> 0x0174 }
        L_0x0168:
            r10.f19180e = r11     // Catch:{ all -> 0x0174 }
            okhttp3.internal.platform.h$a r11 = okhttp3.internal.platform.h.f20683c
            okhttp3.internal.platform.h r11 = r11.g()
            r11.b(r1)
            return
        L_0x0174:
            r11 = move-exception
            r2 = r1
            goto L_0x0180
        L_0x0177:
            java.lang.NullPointerException r11 = new java.lang.NullPointerException     // Catch:{ all -> 0x017f }
            java.lang.String r0 = "null cannot be cast to non-null type javax.net.ssl.SSLSocket"
            r11.<init>(r0)     // Catch:{ all -> 0x017f }
            throw r11     // Catch:{ all -> 0x017f }
        L_0x017f:
            r11 = move-exception
        L_0x0180:
            if (r2 == 0) goto L_0x018b
            okhttp3.internal.platform.h$a r0 = okhttp3.internal.platform.h.f20683c
            okhttp3.internal.platform.h r0 = r0.g()
            r0.b(r2)
        L_0x018b:
            if (r2 == 0) goto L_0x0190
            wd.b.k(r2)
        L_0x0190:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: ae.f.j(ae.b):void");
    }

    private final void k(int i10, int i11, int i12, vd.e eVar, r rVar) {
        b0 m10 = m();
        v j10 = m10.j();
        int i13 = 0;
        while (i13 < 21) {
            i(i10, i11, eVar, rVar);
            m10 = l(i11, i12, m10, j10);
            if (m10 != null) {
                Socket socket = this.f19177b;
                if (socket != null) {
                    wd.b.k(socket);
                }
                this.f19177b = null;
                this.f19183h = null;
                this.f19182g = null;
                rVar.g(eVar, this.f19192q.d(), this.f19192q.b(), (a0) null);
                i13++;
            } else {
                return;
            }
        }
    }

    private final b0 l(int i10, int i11, b0 b0Var, v vVar) {
        String str = "CONNECT " + wd.b.L(vVar, true) + " HTTP/1.1";
        while (true) {
            g gVar = this.f19182g;
            h.c(gVar);
            ie.f fVar = this.f19183h;
            h.c(fVar);
            ce.b bVar = new ce.b((z) null, this, gVar, fVar);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            gVar.g().g((long) i10, timeUnit);
            fVar.g().g((long) i11, timeUnit);
            bVar.A(b0Var.e(), str);
            bVar.b();
            d0.a g10 = bVar.g(false);
            h.c(g10);
            d0 c10 = g10.r(b0Var).c();
            bVar.z(c10);
            int k10 = c10.k();
            if (k10 != 200) {
                if (k10 == 407) {
                    b0 a10 = this.f19192q.a().h().a(this.f19192q, c10);
                    if (a10 == null) {
                        throw new IOException("Failed to authenticate with proxy");
                    } else if (p.l("close", d0.s(c10, "Connection", (String) null, 2, (Object) null), true)) {
                        return a10;
                    } else {
                        b0Var = a10;
                    }
                } else {
                    throw new IOException("Unexpected response code for CONNECT: " + c10.k());
                }
            } else if (gVar.b().G() && fVar.b().G()) {
                return null;
            } else {
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
        }
    }

    private final b0 m() {
        b0 b10 = new b0.a().h(this.f19192q.a().l()).e("CONNECT", (c0) null).c("Host", wd.b.L(this.f19192q.a().l(), true)).c("Proxy-Connection", "Keep-Alive").c("User-Agent", "okhttp/4.9.1").b();
        b0 a10 = this.f19192q.a().h().a(this.f19192q, new d0.a().r(b10).p(a0.HTTP_1_1).g(407).m("Preemptive Authenticate").b(wd.b.f21514c).s(-1).q(-1).j("Proxy-Authenticate", "OkHttp-Preemptive").c());
        return a10 != null ? a10 : b10;
    }

    private final void n(b bVar, int i10, vd.e eVar, r rVar) {
        if (this.f19192q.a().k() == null) {
            List<a0> f10 = this.f19192q.a().f();
            a0 a0Var = a0.H2_PRIOR_KNOWLEDGE;
            if (f10.contains(a0Var)) {
                this.f19178c = this.f19177b;
                this.f19180e = a0Var;
                F(i10);
                return;
            }
            this.f19178c = this.f19177b;
            this.f19180e = a0.HTTP_1_1;
            return;
        }
        rVar.B(eVar);
        j(bVar);
        rVar.A(eVar, this.f19179d);
        if (this.f19180e == a0.HTTP_2) {
            F(i10);
        }
    }

    @NotNull
    public f0 A() {
        return this.f19192q;
    }

    public final void C(long j10) {
        this.f19191p = j10;
    }

    public final void D(boolean z10) {
        this.f19184i = z10;
    }

    @NotNull
    public Socket E() {
        Socket socket = this.f19178c;
        h.c(socket);
        return socket;
    }

    public final synchronized void H(@NotNull e eVar, @Nullable IOException iOException) {
        int i10;
        h.e(eVar, "call");
        if (iOException instanceof n) {
            if (((n) iOException).f19494a == de.b.REFUSED_STREAM) {
                int i11 = this.f19188m + 1;
                this.f19188m = i11;
                if (i11 > 1) {
                    this.f19184i = true;
                    i10 = this.f19186k;
                }
            } else if (((n) iOException).f19494a != de.b.CANCEL || !eVar.h()) {
                this.f19184i = true;
                i10 = this.f19186k;
            }
        } else if (!w() || (iOException instanceof de.a)) {
            this.f19184i = true;
            if (this.f19187l == 0) {
                if (iOException != null) {
                    h(eVar.o(), this.f19192q, iOException);
                }
                i10 = this.f19186k;
            }
        }
        this.f19186k = i10 + 1;
    }

    @NotNull
    public a0 a() {
        a0 a0Var = this.f19180e;
        h.c(a0Var);
        return a0Var;
    }

    public synchronized void b(@NotNull de.f fVar, @NotNull m mVar) {
        h.e(fVar, "connection");
        h.e(mVar, "settings");
        this.f19189n = mVar.d();
    }

    public void c(@NotNull de.i iVar) {
        h.e(iVar, "stream");
        iVar.d(de.b.REFUSED_STREAM, (IOException) null);
    }

    public final void e() {
        Socket socket = this.f19177b;
        if (socket != null) {
            wd.b.k(socket);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a2 A[Catch:{ IOException -> 0x00fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x013f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g(int r17, int r18, int r19, int r20, boolean r21, @org.jetbrains.annotations.NotNull vd.e r22, @org.jetbrains.annotations.NotNull vd.r r23) {
        /*
            r16 = this;
            r7 = r16
            r8 = r22
            r9 = r23
            java.lang.String r0 = "call"
            mb.h.e(r8, r0)
            java.lang.String r0 = "eventListener"
            mb.h.e(r9, r0)
            vd.a0 r0 = r7.f19180e
            r10 = 1
            if (r0 != 0) goto L_0x0017
            r0 = r10
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            if (r0 == 0) goto L_0x015a
            vd.f0 r0 = r7.f19192q
            vd.a r0 = r0.a()
            java.util.List r0 = r0.b()
            ae.b r11 = new ae.b
            r11.<init>(r0)
            vd.f0 r1 = r7.f19192q
            vd.a r1 = r1.a()
            javax.net.ssl.SSLSocketFactory r1 = r1.k()
            if (r1 != 0) goto L_0x0086
            vd.l r1 = vd.l.f21194h
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0079
            vd.f0 r0 = r7.f19192q
            vd.a r0 = r0.a()
            vd.v r0 = r0.l()
            java.lang.String r0 = r0.i()
            okhttp3.internal.platform.h$a r1 = okhttp3.internal.platform.h.f20683c
            okhttp3.internal.platform.h r1 = r1.g()
            boolean r1 = r1.i(r0)
            if (r1 == 0) goto L_0x0058
            goto L_0x0098
        L_0x0058:
            ae.j r1 = new ae.j
            java.net.UnknownServiceException r2 = new java.net.UnknownServiceException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "CLEARTEXT communication to "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = " not permitted by network security policy"
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            r1.<init>(r2)
            throw r1
        L_0x0079:
            ae.j r0 = new ae.j
            java.net.UnknownServiceException r1 = new java.net.UnknownServiceException
            java.lang.String r2 = "CLEARTEXT communication not enabled for client"
            r1.<init>(r2)
            r0.<init>(r1)
            throw r0
        L_0x0086:
            vd.f0 r0 = r7.f19192q
            vd.a r0 = r0.a()
            java.util.List r0 = r0.f()
            vd.a0 r1 = vd.a0.H2_PRIOR_KNOWLEDGE
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L_0x014d
        L_0x0098:
            r12 = 0
            r13 = r12
        L_0x009a:
            vd.f0 r0 = r7.f19192q     // Catch:{ IOException -> 0x00fd }
            boolean r0 = r0.c()     // Catch:{ IOException -> 0x00fd }
            if (r0 == 0) goto L_0x00bb
            r1 = r16
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r22
            r6 = r23
            r1.k(r2, r3, r4, r5, r6)     // Catch:{ IOException -> 0x00fd }
            java.net.Socket r0 = r7.f19177b     // Catch:{ IOException -> 0x00fd }
            if (r0 != 0) goto L_0x00b6
            goto L_0x00d8
        L_0x00b6:
            r14 = r17
            r15 = r18
            goto L_0x00c2
        L_0x00bb:
            r14 = r17
            r15 = r18
            r7.i(r14, r15, r8, r9)     // Catch:{ IOException -> 0x00fb }
        L_0x00c2:
            r6 = r20
            r7.n(r11, r6, r8, r9)     // Catch:{ IOException -> 0x00f9 }
            vd.f0 r0 = r7.f19192q     // Catch:{ IOException -> 0x00f9 }
            java.net.InetSocketAddress r0 = r0.d()     // Catch:{ IOException -> 0x00f9 }
            vd.f0 r1 = r7.f19192q     // Catch:{ IOException -> 0x00f9 }
            java.net.Proxy r1 = r1.b()     // Catch:{ IOException -> 0x00f9 }
            vd.a0 r2 = r7.f19180e     // Catch:{ IOException -> 0x00f9 }
            r9.g(r8, r0, r1, r2)     // Catch:{ IOException -> 0x00f9 }
        L_0x00d8:
            vd.f0 r0 = r7.f19192q
            boolean r0 = r0.c()
            if (r0 == 0) goto L_0x00f2
            java.net.Socket r0 = r7.f19177b
            if (r0 == 0) goto L_0x00e5
            goto L_0x00f2
        L_0x00e5:
            ae.j r0 = new ae.j
            java.net.ProtocolException r1 = new java.net.ProtocolException
            java.lang.String r2 = "Too many tunnel connections attempted: 21"
            r1.<init>(r2)
            r0.<init>(r1)
            throw r0
        L_0x00f2:
            long r0 = java.lang.System.nanoTime()
            r7.f19191p = r0
            return
        L_0x00f9:
            r0 = move-exception
            goto L_0x0104
        L_0x00fb:
            r0 = move-exception
            goto L_0x0102
        L_0x00fd:
            r0 = move-exception
            r14 = r17
            r15 = r18
        L_0x0102:
            r6 = r20
        L_0x0104:
            java.net.Socket r1 = r7.f19178c
            if (r1 == 0) goto L_0x010b
            wd.b.k(r1)
        L_0x010b:
            java.net.Socket r1 = r7.f19177b
            if (r1 == 0) goto L_0x0112
            wd.b.k(r1)
        L_0x0112:
            r7.f19178c = r12
            r7.f19177b = r12
            r7.f19182g = r12
            r7.f19183h = r12
            r7.f19179d = r12
            r7.f19180e = r12
            r7.f19181f = r12
            r7.f19189n = r10
            vd.f0 r1 = r7.f19192q
            java.net.InetSocketAddress r3 = r1.d()
            vd.f0 r1 = r7.f19192q
            java.net.Proxy r4 = r1.b()
            r5 = 0
            r1 = r23
            r2 = r22
            r6 = r0
            r1.h(r2, r3, r4, r5, r6)
            if (r13 != 0) goto L_0x013f
            ae.j r13 = new ae.j
            r13.<init>(r0)
            goto L_0x0142
        L_0x013f:
            r13.a(r0)
        L_0x0142:
            if (r21 == 0) goto L_0x014c
            boolean r0 = r11.b(r0)
            if (r0 == 0) goto L_0x014c
            goto L_0x009a
        L_0x014c:
            throw r13
        L_0x014d:
            ae.j r0 = new ae.j
            java.net.UnknownServiceException r1 = new java.net.UnknownServiceException
            java.lang.String r2 = "H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"
            r1.<init>(r2)
            r0.<init>(r1)
            throw r0
        L_0x015a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "already connected"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ae.f.g(int, int, int, int, boolean, vd.e, vd.r):void");
    }

    public final void h(@NotNull z zVar, @NotNull f0 f0Var, @NotNull IOException iOException) {
        h.e(zVar, "client");
        h.e(f0Var, "failedRoute");
        h.e(iOException, "failure");
        if (f0Var.b().type() != Proxy.Type.DIRECT) {
            vd.a a10 = f0Var.a();
            a10.i().connectFailed(a10.l().s(), f0Var.b().address(), iOException);
        }
        zVar.y().b(f0Var);
    }

    @NotNull
    public final List<Reference<e>> o() {
        return this.f19190o;
    }

    public final long p() {
        return this.f19191p;
    }

    public final boolean q() {
        return this.f19184i;
    }

    public final int r() {
        return this.f19186k;
    }

    @Nullable
    public t s() {
        return this.f19179d;
    }

    public final synchronized void t() {
        this.f19187l++;
    }

    @NotNull
    public String toString() {
        Object obj;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Connection{");
        sb2.append(this.f19192q.a().l().i());
        sb2.append(':');
        sb2.append(this.f19192q.a().l().n());
        sb2.append(',');
        sb2.append(" proxy=");
        sb2.append(this.f19192q.b());
        sb2.append(" hostAddress=");
        sb2.append(this.f19192q.d());
        sb2.append(" cipherSuite=");
        t tVar = this.f19179d;
        if (tVar == null || (obj = tVar.a()) == null) {
            obj = "none";
        }
        sb2.append(obj);
        sb2.append(" protocol=");
        sb2.append(this.f19180e);
        sb2.append('}');
        return sb2.toString();
    }

    public final boolean u(@NotNull vd.a aVar, @Nullable List<f0> list) {
        h.e(aVar, "address");
        if (wd.b.f21518g && !Thread.holdsLock(this)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Thread ");
            Thread currentThread = Thread.currentThread();
            h.d(currentThread, "Thread.currentThread()");
            sb2.append(currentThread.getName());
            sb2.append(" MUST hold lock on ");
            sb2.append(this);
            throw new AssertionError(sb2.toString());
        } else if (this.f19190o.size() >= this.f19189n || this.f19184i || !this.f19192q.a().d(aVar)) {
            return false;
        } else {
            if (h.a(aVar.l().i(), A().a().l().i())) {
                return true;
            }
            if (this.f19181f == null || list == null || !B(list) || aVar.e() != d.f20001a || !G(aVar.l())) {
                return false;
            }
            try {
                vd.g a10 = aVar.a();
                h.c(a10);
                String i10 = aVar.l().i();
                t s10 = s();
                h.c(s10);
                a10.a(i10, s10.d());
                return true;
            } catch (SSLPeerUnverifiedException unused) {
                return false;
            }
        }
    }

    public final boolean v(boolean z10) {
        long j10;
        if (!wd.b.f21518g || !Thread.holdsLock(this)) {
            long nanoTime = System.nanoTime();
            Socket socket = this.f19177b;
            h.c(socket);
            Socket socket2 = this.f19178c;
            h.c(socket2);
            g gVar = this.f19182g;
            h.c(gVar);
            if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
                return false;
            }
            de.f fVar = this.f19181f;
            if (fVar != null) {
                return fVar.f0(nanoTime);
            }
            synchronized (this) {
                j10 = nanoTime - this.f19191p;
            }
            if (j10 < 10000000000L || !z10) {
                return true;
            }
            return wd.b.C(socket2, gVar);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Thread ");
        Thread currentThread = Thread.currentThread();
        h.d(currentThread, "Thread.currentThread()");
        sb2.append(currentThread.getName());
        sb2.append(" MUST NOT hold lock on ");
        sb2.append(this);
        throw new AssertionError(sb2.toString());
    }

    public final boolean w() {
        return this.f19181f != null;
    }

    @NotNull
    public final be.d x(@NotNull z zVar, @NotNull be.g gVar) {
        h.e(zVar, "client");
        h.e(gVar, "chain");
        Socket socket = this.f19178c;
        h.c(socket);
        g gVar2 = this.f19182g;
        h.c(gVar2);
        ie.f fVar = this.f19183h;
        h.c(fVar);
        de.f fVar2 = this.f19181f;
        if (fVar2 != null) {
            return new de.g(zVar, this, gVar, fVar2);
        }
        socket.setSoTimeout(gVar.l());
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        gVar2.g().g((long) gVar.i(), timeUnit);
        fVar.g().g((long) gVar.k(), timeUnit);
        return new ce.b(zVar, this, gVar2, fVar);
    }

    public final synchronized void y() {
        this.f19185j = true;
    }

    public final synchronized void z() {
        this.f19184i = true;
    }
}
