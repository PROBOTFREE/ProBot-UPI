package ae;

import ae.k;
import be.g;
import de.n;
import java.io.IOException;
import mb.h;
import org.jetbrains.annotations.NotNull;
import vd.a;
import vd.f0;
import vd.r;
import vd.v;
import vd.z;
import wd.b;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private k.b f19144a;

    /* renamed from: b  reason: collision with root package name */
    private k f19145b;

    /* renamed from: c  reason: collision with root package name */
    private int f19146c;

    /* renamed from: d  reason: collision with root package name */
    private int f19147d;

    /* renamed from: e  reason: collision with root package name */
    private int f19148e;

    /* renamed from: f  reason: collision with root package name */
    private f0 f19149f;

    /* renamed from: g  reason: collision with root package name */
    private final h f19150g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final a f19151h;

    /* renamed from: i  reason: collision with root package name */
    private final e f19152i;

    /* renamed from: j  reason: collision with root package name */
    private final r f19153j;

    public d(@NotNull h hVar, @NotNull a aVar, @NotNull e eVar, @NotNull r rVar) {
        h.e(hVar, "connectionPool");
        h.e(aVar, "address");
        h.e(eVar, "call");
        h.e(rVar, "eventListener");
        this.f19150g = hVar;
        this.f19151h = aVar;
        this.f19152i = eVar;
        this.f19153j = rVar;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x013a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final ae.f b(int r15, int r16, int r17, int r18, boolean r19) {
        /*
            r14 = this;
            r1 = r14
            ae.e r0 = r1.f19152i
            boolean r0 = r0.h()
            if (r0 != 0) goto L_0x0162
            ae.e r0 = r1.f19152i
            ae.f r2 = r0.p()
            r0 = 1
            r3 = 0
            r4 = 0
            if (r2 == 0) goto L_0x0064
            monitor-enter(r2)
            boolean r5 = r2.q()     // Catch:{ all -> 0x0061 }
            if (r5 != 0) goto L_0x0030
            vd.f0 r5 = r2.A()     // Catch:{ all -> 0x0061 }
            vd.a r5 = r5.a()     // Catch:{ all -> 0x0061 }
            vd.v r5 = r5.l()     // Catch:{ all -> 0x0061 }
            boolean r5 = r14.g(r5)     // Catch:{ all -> 0x0061 }
            if (r5 != 0) goto L_0x002e
            goto L_0x0030
        L_0x002e:
            r5 = r4
            goto L_0x0036
        L_0x0030:
            ae.e r5 = r1.f19152i     // Catch:{ all -> 0x0061 }
            java.net.Socket r5 = r5.D()     // Catch:{ all -> 0x0061 }
        L_0x0036:
            ab.u r6 = ab.u.f160a     // Catch:{ all -> 0x0061 }
            monitor-exit(r2)
            ae.e r6 = r1.f19152i
            ae.f r6 = r6.p()
            if (r6 == 0) goto L_0x0054
            if (r5 != 0) goto L_0x0044
            goto L_0x0045
        L_0x0044:
            r0 = r3
        L_0x0045:
            if (r0 == 0) goto L_0x0048
            return r2
        L_0x0048:
            java.lang.String r0 = "Check failed."
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            throw r2
        L_0x0054:
            if (r5 == 0) goto L_0x0059
            wd.b.k(r5)
        L_0x0059:
            vd.r r5 = r1.f19153j
            ae.e r6 = r1.f19152i
            r5.k(r6, r2)
            goto L_0x0064
        L_0x0061:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        L_0x0064:
            r1.f19146c = r3
            r1.f19147d = r3
            r1.f19148e = r3
            ae.h r2 = r1.f19150g
            vd.a r5 = r1.f19151h
            ae.e r6 = r1.f19152i
            boolean r2 = r2.a(r5, r6, r4, r3)
            if (r2 == 0) goto L_0x0087
        L_0x0076:
            ae.e r0 = r1.f19152i
            ae.f r0 = r0.p()
            mb.h.c(r0)
        L_0x007f:
            vd.r r2 = r1.f19153j
            ae.e r3 = r1.f19152i
            r2.j(r3, r0)
            return r0
        L_0x0087:
            vd.f0 r2 = r1.f19149f
            if (r2 == 0) goto L_0x0092
            mb.h.c(r2)
            r1.f19149f = r4
        L_0x0090:
            r5 = r4
            goto L_0x00e7
        L_0x0092:
            ae.k$b r2 = r1.f19144a
            if (r2 == 0) goto L_0x00a9
            mb.h.c(r2)
            boolean r2 = r2.b()
            if (r2 == 0) goto L_0x00a9
            ae.k$b r2 = r1.f19144a
            mb.h.c(r2)
            vd.f0 r2 = r2.c()
            goto L_0x0090
        L_0x00a9:
            ae.k r2 = r1.f19145b
            if (r2 != 0) goto L_0x00c4
            ae.k r2 = new ae.k
            vd.a r5 = r1.f19151h
            ae.e r6 = r1.f19152i
            vd.z r6 = r6.o()
            ae.i r6 = r6.y()
            ae.e r7 = r1.f19152i
            vd.r r8 = r1.f19153j
            r2.<init>(r5, r6, r7, r8)
            r1.f19145b = r2
        L_0x00c4:
            ae.k$b r2 = r2.d()
            r1.f19144a = r2
            java.util.List r5 = r2.a()
            ae.e r6 = r1.f19152i
            boolean r6 = r6.h()
            if (r6 != 0) goto L_0x015a
            ae.h r6 = r1.f19150g
            vd.a r7 = r1.f19151h
            ae.e r8 = r1.f19152i
            boolean r3 = r6.a(r7, r8, r5, r3)
            if (r3 == 0) goto L_0x00e3
            goto L_0x0076
        L_0x00e3:
            vd.f0 r2 = r2.c()
        L_0x00e7:
            ae.f r3 = new ae.f
            ae.h r6 = r1.f19150g
            r3.<init>(r6, r2)
            ae.e r6 = r1.f19152i
            r6.F(r3)
            ae.e r12 = r1.f19152i     // Catch:{ all -> 0x0153 }
            vd.r r13 = r1.f19153j     // Catch:{ all -> 0x0153 }
            r6 = r3
            r7 = r15
            r8 = r16
            r9 = r17
            r10 = r18
            r11 = r19
            r6.g(r7, r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x0153 }
            ae.e r6 = r1.f19152i
            r6.F(r4)
            ae.e r4 = r1.f19152i
            vd.z r4 = r4.o()
            ae.i r4 = r4.y()
            vd.f0 r6 = r3.A()
            r4.a(r6)
            ae.h r4 = r1.f19150g
            vd.a r6 = r1.f19151h
            ae.e r7 = r1.f19152i
            boolean r0 = r4.a(r6, r7, r5, r0)
            if (r0 == 0) goto L_0x013a
            ae.e r0 = r1.f19152i
            ae.f r0 = r0.p()
            mb.h.c(r0)
            r1.f19149f = r2
            java.net.Socket r2 = r3.E()
            wd.b.k(r2)
            goto L_0x007f
        L_0x013a:
            monitor-enter(r3)
            ae.h r0 = r1.f19150g     // Catch:{ all -> 0x0150 }
            r0.e(r3)     // Catch:{ all -> 0x0150 }
            ae.e r0 = r1.f19152i     // Catch:{ all -> 0x0150 }
            r0.e(r3)     // Catch:{ all -> 0x0150 }
            ab.u r0 = ab.u.f160a     // Catch:{ all -> 0x0150 }
            monitor-exit(r3)
            vd.r r0 = r1.f19153j
            ae.e r2 = r1.f19152i
            r0.j(r2, r3)
            return r3
        L_0x0150:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        L_0x0153:
            r0 = move-exception
            ae.e r2 = r1.f19152i
            r2.F(r4)
            throw r0
        L_0x015a:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r2 = "Canceled"
            r0.<init>(r2)
            throw r0
        L_0x0162:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r2 = "Canceled"
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ae.d.b(int, int, int, int, boolean):ae.f");
    }

    private final f c(int i10, int i11, int i12, int i13, boolean z10, boolean z11) {
        while (true) {
            f b10 = b(i10, i11, i12, i13, z10);
            if (b10.v(z11)) {
                return b10;
            }
            b10.z();
            if (this.f19149f == null) {
                k.b bVar = this.f19144a;
                boolean z12 = true;
                if (!(bVar != null ? bVar.b() : true)) {
                    k kVar = this.f19145b;
                    if (kVar != null) {
                        z12 = kVar.b();
                    }
                    if (!z12) {
                        throw new IOException("exhausted all routes");
                    }
                } else {
                    continue;
                }
            }
        }
    }

    private final f0 f() {
        f p10;
        if (this.f19146c > 1 || this.f19147d > 1 || this.f19148e > 0 || (p10 = this.f19152i.p()) == null) {
            return null;
        }
        synchronized (p10) {
            if (p10.r() != 0) {
                return null;
            }
            if (!b.g(p10.A().a().l(), this.f19151h.l())) {
                return null;
            }
            f0 A = p10.A();
            return A;
        }
    }

    @NotNull
    public final be.d a(@NotNull z zVar, @NotNull g gVar) {
        h.e(zVar, "client");
        h.e(gVar, "chain");
        try {
            return c(gVar.g(), gVar.i(), gVar.k(), zVar.D(), zVar.J(), !h.a(gVar.j().g(), "GET")).x(zVar, gVar);
        } catch (j e10) {
            h(e10.c());
            throw e10;
        } catch (IOException e11) {
            h(e11);
            throw new j(e11);
        }
    }

    @NotNull
    public final a d() {
        return this.f19151h;
    }

    public final boolean e() {
        k kVar;
        if (this.f19146c == 0 && this.f19147d == 0 && this.f19148e == 0) {
            return false;
        }
        if (this.f19149f != null) {
            return true;
        }
        f0 f10 = f();
        if (f10 != null) {
            this.f19149f = f10;
            return true;
        }
        k.b bVar = this.f19144a;
        if ((bVar == null || !bVar.b()) && (kVar = this.f19145b) != null) {
            return kVar.b();
        }
        return true;
    }

    public final boolean g(@NotNull v vVar) {
        h.e(vVar, "url");
        v l10 = this.f19151h.l();
        return vVar.n() == l10.n() && h.a(vVar.i(), l10.i());
    }

    public final void h(@NotNull IOException iOException) {
        h.e(iOException, "e");
        this.f19149f = null;
        if ((iOException instanceof n) && ((n) iOException).f19494a == de.b.REFUSED_STREAM) {
            this.f19146c++;
        } else if (iOException instanceof de.a) {
            this.f19147d++;
        } else {
            this.f19148e++;
        }
    }
}
