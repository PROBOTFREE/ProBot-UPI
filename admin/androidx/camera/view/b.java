package androidx.camera.view;

import android.graphics.PointF;
import u.e;

class b extends e {

    /* renamed from: a  reason: collision with root package name */
    private final a f1304a;

    static {
        new PointF(2.0f, 2.0f);
    }

    b(a aVar) {
        this.f1304a = aVar;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0019, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.util.Size r2, int r3) {
        /*
            r1 = this;
            w.a.a()
            monitor-enter(r1)
            int r0 = r2.getWidth()     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x0018
            int r0 = r2.getHeight()     // Catch:{ all -> 0x001a }
            if (r0 != 0) goto L_0x0011
            goto L_0x0018
        L_0x0011:
            androidx.camera.view.a r0 = r1.f1304a     // Catch:{ all -> 0x001a }
            r0.b(r2, r3)     // Catch:{ all -> 0x001a }
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            return
        L_0x0018:
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            return
        L_0x001a:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.view.b.a(android.util.Size, int):void");
    }
}
