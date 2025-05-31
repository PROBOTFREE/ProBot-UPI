package a3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import s3.g;
import s3.k;
import t3.a;
import w0.e;
import w2.c;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private final g<c, String> f118a = new g<>(1000);

    /* renamed from: b  reason: collision with root package name */
    private final e<b> f119b = t3.a.d(10, new a(this));

    class a implements a.d<b> {
        a(j jVar) {
        }

        /* renamed from: b */
        public b a() {
            try {
                return new b(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    private static final class b implements a.f {

        /* renamed from: a  reason: collision with root package name */
        final MessageDigest f120a;

        /* renamed from: b  reason: collision with root package name */
        private final t3.c f121b = t3.c.a();

        b(MessageDigest messageDigest) {
            this.f120a = messageDigest;
        }

        public t3.c f() {
            return this.f121b;
        }
    }

    private String a(c cVar) {
        b bVar = (b) s3.j.d(this.f119b.b());
        try {
            cVar.b(bVar.f120a);
            return k.w(bVar.f120a.digest());
        } finally {
            this.f119b.a(bVar);
        }
    }

    public String b(c cVar) {
        String g10;
        synchronized (this.f118a) {
            g10 = this.f118a.g(cVar);
        }
        if (g10 == null) {
            g10 = a(cVar);
        }
        synchronized (this.f118a) {
            this.f118a.k(cVar, g10);
        }
        return g10;
    }
}
