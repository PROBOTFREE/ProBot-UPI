package androidx.work;

import android.os.Build;
import androidx.work.j;

public final class g extends j {

    public static final class a extends j.a<a, g> {
        public a(Class<? extends ListenableWorker> cls) {
            super(cls);
            this.f4639c.f14714d = OverwritingInputMerger.class.getName();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public g c() {
            if (!this.f4637a || Build.VERSION.SDK_INT < 23 || !this.f4639c.f14720j.h()) {
                return new g(this);
            }
            throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public a d() {
            return this;
        }
    }

    g(a aVar) {
        super(aVar.f4638b, aVar.f4639c, aVar.f4640d);
    }

    public static g d(Class<? extends ListenableWorker> cls) {
        return (g) new a(cls).b();
    }
}
