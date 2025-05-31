package ae;

import be.d;
import ie.a0;
import ie.e;
import ie.i;
import ie.j;
import ie.o;
import ie.y;
import java.io.IOException;
import java.net.ProtocolException;
import mb.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vd.b0;
import vd.c0;
import vd.d0;
import vd.e0;
import vd.r;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private boolean f19127a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final f f19128b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final e f19129c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final r f19130d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final d f19131e;

    /* renamed from: f  reason: collision with root package name */
    private final d f19132f;

    private final class a extends i {

        /* renamed from: b  reason: collision with root package name */
        private boolean f19133b;

        /* renamed from: c  reason: collision with root package name */
        private long f19134c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f19135d;

        /* renamed from: e  reason: collision with root package name */
        private final long f19136e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ c f19137f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(@NotNull c cVar, y yVar, long j10) {
            super(yVar);
            h.e(yVar, "delegate");
            this.f19137f = cVar;
            this.f19136e = j10;
        }

        private final <E extends IOException> E c(E e10) {
            if (this.f19133b) {
                return e10;
            }
            this.f19133b = true;
            return this.f19137f.a(this.f19134c, false, true, e10);
        }

        public void a0(@NotNull e eVar, long j10) {
            h.e(eVar, "source");
            if (!this.f19135d) {
                long j11 = this.f19136e;
                if (j11 == -1 || this.f19134c + j10 <= j11) {
                    try {
                        super.a0(eVar, j10);
                        this.f19134c += j10;
                    } catch (IOException e10) {
                        throw c(e10);
                    }
                } else {
                    throw new ProtocolException("expected " + this.f19136e + " bytes but received " + (this.f19134c + j10));
                }
            } else {
                throw new IllegalStateException("closed".toString());
            }
        }

        public void close() {
            if (!this.f19135d) {
                this.f19135d = true;
                long j10 = this.f19136e;
                if (j10 == -1 || this.f19134c == j10) {
                    try {
                        super.close();
                        c((IOException) null);
                    } catch (IOException e10) {
                        throw c(e10);
                    }
                } else {
                    throw new ProtocolException("unexpected end of stream");
                }
            }
        }

        public void flush() {
            try {
                super.flush();
            } catch (IOException e10) {
                throw c(e10);
            }
        }
    }

    public final class b extends j {

        /* renamed from: b  reason: collision with root package name */
        private long f19138b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f19139c = true;

        /* renamed from: d  reason: collision with root package name */
        private boolean f19140d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f19141e;

        /* renamed from: f  reason: collision with root package name */
        private final long f19142f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ c f19143g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(@NotNull c cVar, a0 a0Var, long j10) {
            super(a0Var);
            h.e(a0Var, "delegate");
            this.f19143g = cVar;
            this.f19142f = j10;
            if (j10 == 0) {
                d((IOException) null);
            }
        }

        public long C(@NotNull e eVar, long j10) {
            h.e(eVar, "sink");
            if (!this.f19141e) {
                try {
                    long C = c().C(eVar, j10);
                    if (this.f19139c) {
                        this.f19139c = false;
                        this.f19143g.i().v(this.f19143g.g());
                    }
                    if (C == -1) {
                        d((IOException) null);
                        return -1;
                    }
                    long j11 = this.f19138b + C;
                    long j12 = this.f19142f;
                    if (j12 != -1) {
                        if (j11 > j12) {
                            throw new ProtocolException("expected " + this.f19142f + " bytes but received " + j11);
                        }
                    }
                    this.f19138b = j11;
                    if (j11 == j12) {
                        d((IOException) null);
                    }
                    return C;
                } catch (IOException e10) {
                    throw d(e10);
                }
            } else {
                throw new IllegalStateException("closed".toString());
            }
        }

        public void close() {
            if (!this.f19141e) {
                this.f19141e = true;
                try {
                    super.close();
                    d((IOException) null);
                } catch (IOException e10) {
                    throw d(e10);
                }
            }
        }

        public final <E extends IOException> E d(E e10) {
            if (this.f19140d) {
                return e10;
            }
            this.f19140d = true;
            if (e10 == null && this.f19139c) {
                this.f19139c = false;
                this.f19143g.i().v(this.f19143g.g());
            }
            return this.f19143g.a(this.f19138b, true, false, e10);
        }
    }

    public c(@NotNull e eVar, @NotNull r rVar, @NotNull d dVar, @NotNull d dVar2) {
        h.e(eVar, "call");
        h.e(rVar, "eventListener");
        h.e(dVar, "finder");
        h.e(dVar2, "codec");
        this.f19129c = eVar;
        this.f19130d = rVar;
        this.f19131e = dVar;
        this.f19132f = dVar2;
        this.f19128b = dVar2.h();
    }

    private final void s(IOException iOException) {
        this.f19131e.h(iOException);
        this.f19132f.h().H(this.f19129c, iOException);
    }

    public final <E extends IOException> E a(long j10, boolean z10, boolean z11, E e10) {
        if (e10 != null) {
            s(e10);
        }
        if (z11) {
            r rVar = this.f19130d;
            e eVar = this.f19129c;
            if (e10 != null) {
                rVar.r(eVar, e10);
            } else {
                rVar.p(eVar, j10);
            }
        }
        if (z10) {
            if (e10 != null) {
                this.f19130d.w(this.f19129c, e10);
            } else {
                this.f19130d.u(this.f19129c, j10);
            }
        }
        return this.f19129c.A(this, z11, z10, e10);
    }

    public final void b() {
        this.f19132f.cancel();
    }

    @NotNull
    public final y c(@NotNull b0 b0Var, boolean z10) {
        h.e(b0Var, "request");
        this.f19127a = z10;
        c0 a10 = b0Var.a();
        h.c(a10);
        long a11 = a10.a();
        this.f19130d.q(this.f19129c);
        return new a(this, this.f19132f.d(b0Var, a11), a11);
    }

    public final void d() {
        this.f19132f.cancel();
        this.f19129c.A(this, true, true, null);
    }

    public final void e() {
        try {
            this.f19132f.b();
        } catch (IOException e10) {
            this.f19130d.r(this.f19129c, e10);
            s(e10);
            throw e10;
        }
    }

    public final void f() {
        try {
            this.f19132f.c();
        } catch (IOException e10) {
            this.f19130d.r(this.f19129c, e10);
            s(e10);
            throw e10;
        }
    }

    @NotNull
    public final e g() {
        return this.f19129c;
    }

    @NotNull
    public final f h() {
        return this.f19128b;
    }

    @NotNull
    public final r i() {
        return this.f19130d;
    }

    @NotNull
    public final d j() {
        return this.f19131e;
    }

    public final boolean k() {
        return !h.a(this.f19131e.d().l().i(), this.f19128b.A().a().l().i());
    }

    public final boolean l() {
        return this.f19127a;
    }

    public final void m() {
        this.f19132f.h().z();
    }

    public final void n() {
        this.f19129c.A(this, true, false, null);
    }

    @NotNull
    public final e0 o(@NotNull d0 d0Var) {
        h.e(d0Var, "response");
        try {
            String s10 = d0.s(d0Var, "Content-Type", (String) null, 2, (Object) null);
            long f10 = this.f19132f.f(d0Var);
            return new be.h(s10, f10, o.b(new b(this, this.f19132f.e(d0Var), f10)));
        } catch (IOException e10) {
            this.f19130d.w(this.f19129c, e10);
            s(e10);
            throw e10;
        }
    }

    @Nullable
    public final d0.a p(boolean z10) {
        try {
            d0.a g10 = this.f19132f.g(z10);
            if (g10 != null) {
                g10.l(this);
            }
            return g10;
        } catch (IOException e10) {
            this.f19130d.w(this.f19129c, e10);
            s(e10);
            throw e10;
        }
    }

    public final void q(@NotNull d0 d0Var) {
        h.e(d0Var, "response");
        this.f19130d.x(this.f19129c, d0Var);
    }

    public final void r() {
        this.f19130d.y(this.f19129c);
    }

    public final void t(@NotNull b0 b0Var) {
        h.e(b0Var, "request");
        try {
            this.f19130d.t(this.f19129c);
            this.f19132f.a(b0Var);
            this.f19130d.s(this.f19129c, b0Var);
        } catch (IOException e10) {
            this.f19130d.r(this.f19129c, e10);
            s(e10);
            throw e10;
        }
    }
}
