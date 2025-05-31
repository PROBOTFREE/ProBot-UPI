package ae;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import mb.f;
import mb.h;
import mb.i;
import org.jetbrains.annotations.NotNull;
import vd.e;
import vd.f0;
import vd.r;
import vd.v;

public final class k {

    /* renamed from: i  reason: collision with root package name */
    public static final a f19207i = new a((f) null);

    /* renamed from: a  reason: collision with root package name */
    private List<? extends Proxy> f19208a = l.f();

    /* renamed from: b  reason: collision with root package name */
    private int f19209b;

    /* renamed from: c  reason: collision with root package name */
    private List<? extends InetSocketAddress> f19210c = l.f();

    /* renamed from: d  reason: collision with root package name */
    private final List<f0> f19211d = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final vd.a f19212e;

    /* renamed from: f  reason: collision with root package name */
    private final i f19213f;

    /* renamed from: g  reason: collision with root package name */
    private final e f19214g;

    /* renamed from: h  reason: collision with root package name */
    private final r f19215h;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        @NotNull
        public final String a(@NotNull InetSocketAddress inetSocketAddress) {
            String hostName;
            String str;
            h.e(inetSocketAddress, "$this$socketHost");
            InetAddress address = inetSocketAddress.getAddress();
            if (address != null) {
                hostName = address.getHostAddress();
                str = "address.hostAddress";
            } else {
                hostName = inetSocketAddress.getHostName();
                str = "hostName";
            }
            h.d(hostName, str);
            return hostName;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private int f19216a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final List<f0> f19217b;

        public b(@NotNull List<f0> list) {
            h.e(list, "routes");
            this.f19217b = list;
        }

        @NotNull
        public final List<f0> a() {
            return this.f19217b;
        }

        public final boolean b() {
            return this.f19216a < this.f19217b.size();
        }

        @NotNull
        public final f0 c() {
            if (b()) {
                List<f0> list = this.f19217b;
                int i10 = this.f19216a;
                this.f19216a = i10 + 1;
                return list.get(i10);
            }
            throw new NoSuchElementException();
        }
    }

    static final class c extends i implements lb.a<List<? extends Proxy>> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ k f19218b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Proxy f19219c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ v f19220d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(k kVar, Proxy proxy, v vVar) {
            super(0);
            this.f19218b = kVar;
            this.f19219c = proxy;
            this.f19220d = vVar;
        }

        @NotNull
        /* renamed from: a */
        public final List<Proxy> b() {
            Proxy proxy = this.f19219c;
            if (proxy != null) {
                return k.b(proxy);
            }
            URI s10 = this.f19220d.s();
            if (s10.getHost() == null) {
                return wd.b.t(Proxy.NO_PROXY);
            }
            List<Proxy> select = this.f19218b.f19212e.i().select(s10);
            if (!(select == null || select.isEmpty())) {
                return wd.b.N(select);
            }
            return wd.b.t(Proxy.NO_PROXY);
        }
    }

    public k(@NotNull vd.a aVar, @NotNull i iVar, @NotNull e eVar, @NotNull r rVar) {
        h.e(aVar, "address");
        h.e(iVar, "routeDatabase");
        h.e(eVar, "call");
        h.e(rVar, "eventListener");
        this.f19212e = aVar;
        this.f19213f = iVar;
        this.f19214g = eVar;
        this.f19215h = rVar;
        g(aVar.l(), aVar.g());
    }

    private final boolean c() {
        return this.f19209b < this.f19208a.size();
    }

    private final Proxy e() {
        if (c()) {
            List<? extends Proxy> list = this.f19208a;
            int i10 = this.f19209b;
            this.f19209b = i10 + 1;
            Proxy proxy = (Proxy) list.get(i10);
            f(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f19212e.l().i() + "; exhausted proxy configurations: " + this.f19208a);
    }

    private final void f(Proxy proxy) {
        String str;
        int i10;
        ArrayList arrayList = new ArrayList();
        this.f19210c = arrayList;
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            str = this.f19212e.l().i();
            i10 = this.f19212e.l().n();
        } else {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                str = f19207i.a(inetSocketAddress);
                i10 = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException(("Proxy.address() is not an InetSocketAddress: " + address.getClass()).toString());
            }
        }
        if (1 > i10 || 65535 < i10) {
            throw new SocketException("No route to " + str + ':' + i10 + "; port is out of range");
        } else if (proxy.type() == Proxy.Type.SOCKS) {
            arrayList.add(InetSocketAddress.createUnresolved(str, i10));
        } else {
            this.f19215h.m(this.f19214g, str);
            List<InetAddress> a10 = this.f19212e.c().a(str);
            if (!a10.isEmpty()) {
                this.f19215h.l(this.f19214g, str, a10);
                for (InetAddress inetSocketAddress2 : a10) {
                    arrayList.add(new InetSocketAddress(inetSocketAddress2, i10));
                }
                return;
            }
            throw new UnknownHostException(this.f19212e.c() + " returned no addresses for " + str);
        }
    }

    private final void g(v vVar, Proxy proxy) {
        c cVar = new c(this, proxy, vVar);
        this.f19215h.o(this.f19214g, vVar);
        List<Proxy> a10 = cVar.b();
        this.f19208a = a10;
        this.f19209b = 0;
        this.f19215h.n(this.f19214g, vVar, a10);
    }

    public final boolean b() {
        return c() || (this.f19211d.isEmpty() ^ true);
    }

    @NotNull
    public final b d() {
        if (b()) {
            ArrayList arrayList = new ArrayList();
            while (c()) {
                Proxy e10 = e();
                for (InetSocketAddress f0Var : this.f19210c) {
                    f0 f0Var2 = new f0(this.f19212e, e10, f0Var);
                    if (this.f19213f.c(f0Var2)) {
                        this.f19211d.add(f0Var2);
                    } else {
                        arrayList.add(f0Var2);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                boolean unused = q.p(arrayList, this.f19211d);
                this.f19211d.clear();
            }
            return new b(arrayList);
        }
        throw new NoSuchElementException();
    }
}
