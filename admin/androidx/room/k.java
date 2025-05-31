package androidx.room;

import java.io.File;
import t1.c;

class k implements c.C0218c {

    /* renamed from: a  reason: collision with root package name */
    private final String f3825a;

    /* renamed from: b  reason: collision with root package name */
    private final File f3826b;

    /* renamed from: c  reason: collision with root package name */
    private final c.C0218c f3827c;

    k(String str, File file, c.C0218c cVar) {
        this.f3825a = str;
        this.f3826b = file;
        this.f3827c = cVar;
    }

    public c create(c.b bVar) {
        return new j(bVar.f17253a, this.f3825a, this.f3826b, bVar.f17255c.f17252a, this.f3827c.create(bVar));
    }
}
