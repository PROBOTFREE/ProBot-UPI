package a3;

import a3.d;
import android.content.Context;
import java.io.File;

public final class f extends d {

    class a implements d.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f101a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f102b;

        a(Context context, String str) {
            this.f101a = context;
            this.f102b = str;
        }

        public File a() {
            File cacheDir = this.f101a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.f102b != null ? new File(cacheDir, this.f102b) : cacheDir;
        }
    }

    public f(Context context) {
        this(context, "image_manager_disk_cache", 262144000);
    }

    public f(Context context, String str, long j10) {
        super(new a(context, str), j10);
    }
}
