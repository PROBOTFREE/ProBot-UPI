package ac;

import bd.d;
import java.math.BigInteger;
import java.util.Hashtable;
import jc.e;
import jc.f;
import jc.g;
import zb.n;

public class a {

    /* renamed from: a  reason: collision with root package name */
    static f f161a = new C0006a();

    /* renamed from: b  reason: collision with root package name */
    static final Hashtable f162b = new Hashtable();

    /* renamed from: c  reason: collision with root package name */
    static final Hashtable f163c = new Hashtable();

    /* renamed from: d  reason: collision with root package name */
    static final Hashtable f164d = new Hashtable();

    /* renamed from: ac.a$a  reason: collision with other inner class name */
    static class C0006a extends f {
        C0006a() {
        }

        /* access modifiers changed from: protected */
        public e a() {
            BigInteger a10 = a.e("F1FD178C0B3AD58F10126DE8CE42435B3961ADBCABC8CA6DE8FCF353D86E9C03");
            BigInteger a11 = a.e("F1FD178C0B3AD58F10126DE8CE42435B3961ADBCABC8CA6DE8FCF353D86E9C00");
            BigInteger a12 = a.e("EE353FCA5428A9300D4ABA754A44C00FDFEC0C9AE4B1A1803075ED967B7BB73F");
            BigInteger a13 = a.e("F1FD178C0B3AD58F10126DE8CE42435B53DC67E140D2BF941FFDD459C6D655E1");
            BigInteger valueOf = BigInteger.valueOf(1);
            d b10 = a.c(new d.f(a10, a11, a12, a13, valueOf));
            return new e(b10, new g(b10, od.f.a("04B6B3D4C356C139EB31183D4749D423958C27D2DCAF98B70164C97A2DD98F5CFF6142E0F7C8B204911F9271F0F3ECEF8C2701C307E8E4C9E183115A1554062CFB")), a13, valueOf, (byte[]) null);
        }
    }

    static {
        d("FRP256v1", b.f165a, f161a);
    }

    /* access modifiers changed from: private */
    public static d c(d dVar) {
        return dVar;
    }

    static void d(String str, n nVar, f fVar) {
        f162b.put(nd.g.g(str), nVar);
        f164d.put(nVar, str);
        f163c.put(nVar, fVar);
    }

    /* access modifiers changed from: private */
    public static BigInteger e(String str) {
        return new BigInteger(1, od.f.a(str));
    }

    public static e f(n nVar) {
        f fVar = (f) f163c.get(nVar);
        if (fVar == null) {
            return null;
        }
        return fVar.b();
    }

    public static String g(n nVar) {
        return (String) f164d.get(nVar);
    }
}
