package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.a;

public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f2170a = (IconCompat) aVar.v(remoteActionCompat.f2170a, 1);
        remoteActionCompat.f2171b = aVar.l(remoteActionCompat.f2171b, 2);
        remoteActionCompat.f2172c = aVar.l(remoteActionCompat.f2172c, 3);
        remoteActionCompat.f2173d = (PendingIntent) aVar.r(remoteActionCompat.f2173d, 4);
        remoteActionCompat.f2174e = aVar.h(remoteActionCompat.f2174e, 5);
        remoteActionCompat.f2175f = aVar.h(remoteActionCompat.f2175f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, a aVar) {
        aVar.x(false, false);
        aVar.M(remoteActionCompat.f2170a, 1);
        aVar.D(remoteActionCompat.f2171b, 2);
        aVar.D(remoteActionCompat.f2172c, 3);
        aVar.H(remoteActionCompat.f2173d, 4);
        aVar.z(remoteActionCompat.f2174e, 5);
        aVar.z(remoteActionCompat.f2175f, 6);
    }
}
