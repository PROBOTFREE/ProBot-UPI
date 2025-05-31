package a3;

import a3.a;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import u2.a;
import w2.c;

public class e implements a {

    /* renamed from: a  reason: collision with root package name */
    private final j f96a;

    /* renamed from: b  reason: collision with root package name */
    private final File f97b;

    /* renamed from: c  reason: collision with root package name */
    private final long f98c;

    /* renamed from: d  reason: collision with root package name */
    private final c f99d = new c();

    /* renamed from: e  reason: collision with root package name */
    private a f100e;

    @Deprecated
    protected e(File file, long j10) {
        this.f97b = file;
        this.f98c = j10;
        this.f96a = new j();
    }

    public static a c(File file, long j10) {
        return new e(file, j10);
    }

    private synchronized a d() {
        if (this.f100e == null) {
            this.f100e = a.I(this.f97b, 1, 1, this.f98c);
        }
        return this.f100e;
    }

    public void a(c cVar, a.b bVar) {
        a.c y10;
        String b10 = this.f96a.b(cVar);
        this.f99d.a(b10);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + b10 + " for for Key: " + cVar);
            }
            try {
                u2.a d10 = d();
                if (d10.D(b10) == null) {
                    y10 = d10.y(b10);
                    if (y10 != null) {
                        if (bVar.a(y10.f(0))) {
                            y10.e();
                        }
                        y10.b();
                        this.f99d.b(b10);
                        return;
                    }
                    throw new IllegalStateException("Had two simultaneous puts for: " + b10);
                }
            } catch (IOException e10) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e10);
                }
            } catch (Throwable th) {
                y10.b();
                throw th;
            }
        } finally {
            this.f99d.b(b10);
        }
    }

    public File b(c cVar) {
        String b10 = this.f96a.b(cVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + b10 + " for for Key: " + cVar);
        }
        try {
            a.e D = d().D(b10);
            if (D != null) {
                return D.a(0);
            }
            return null;
        } catch (IOException e10) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e10);
            return null;
        }
    }
}
