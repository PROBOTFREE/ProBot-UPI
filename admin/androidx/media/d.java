package androidx.media;

import android.media.session.MediaSessionManager;
import w0.c;

final class d implements c {

    /* renamed from: a  reason: collision with root package name */
    final MediaSessionManager.RemoteUserInfo f3085a;

    d(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        this.f3085a = remoteUserInfo;
    }

    d(String str, int i10, int i11) {
        this.f3085a = new MediaSessionManager.RemoteUserInfo(str, i10, i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        return this.f3085a.equals(((d) obj).f3085a);
    }

    public int hashCode() {
        return c.b(this.f3085a);
    }
}
