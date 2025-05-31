package a3;

import a3.a;
import java.io.File;

public class d implements a.C0005a {

    /* renamed from: a  reason: collision with root package name */
    private final long f94a;

    /* renamed from: b  reason: collision with root package name */
    private final a f95b;

    public interface a {
        File a();
    }

    public d(a aVar, long j10) {
        this.f94a = j10;
        this.f95b = aVar;
    }

    public a a() {
        File a10 = this.f95b.a();
        if (a10 == null) {
            return null;
        }
        if (a10.isDirectory() || a10.mkdirs()) {
            return e.c(a10, this.f94a);
        }
        return null;
    }
}
