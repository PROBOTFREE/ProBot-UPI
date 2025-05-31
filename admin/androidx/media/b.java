package androidx.media;

import android.media.session.MediaSessionManager;
import android.os.Build;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    c f3084a;

    public b(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        this.f3084a = new d(remoteUserInfo);
    }

    public b(String str, int i10, int i11) {
        this.f3084a = Build.VERSION.SDK_INT >= 28 ? new d(str, i10, i11) : new e(str, i10, i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        return this.f3084a.equals(((b) obj).f3084a);
    }

    public int hashCode() {
        return this.f3084a.hashCode();
    }
}
