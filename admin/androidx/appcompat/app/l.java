package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.core.content.b;
import java.util.Calendar;

class l {

    /* renamed from: d  reason: collision with root package name */
    private static l f429d;

    /* renamed from: a  reason: collision with root package name */
    private final Context f430a;

    /* renamed from: b  reason: collision with root package name */
    private final LocationManager f431b;

    /* renamed from: c  reason: collision with root package name */
    private final a f432c = new a();

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f433a;

        /* renamed from: b  reason: collision with root package name */
        long f434b;

        a() {
        }
    }

    l(Context context, LocationManager locationManager) {
        this.f430a = context;
        this.f431b = locationManager;
    }

    static l a(Context context) {
        if (f429d == null) {
            Context applicationContext = context.getApplicationContext();
            f429d = new l(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f429d;
    }

    @SuppressLint({"MissingPermission"})
    private Location b() {
        Location location = null;
        Location c10 = b.c(this.f430a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? c("network") : null;
        if (b.c(this.f430a, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = c("gps");
        }
        return (location == null || c10 == null) ? location != null ? location : c10 : location.getTime() > c10.getTime() ? location : c10;
    }

    private Location c(String str) {
        try {
            if (this.f431b.isProviderEnabled(str)) {
                return this.f431b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e10) {
            Log.d("TwilightManager", "Failed to get last known location", e10);
            return null;
        }
    }

    private boolean e() {
        return this.f432c.f434b > System.currentTimeMillis();
    }

    private void f(Location location) {
        long j10;
        a aVar = this.f432c;
        long currentTimeMillis = System.currentTimeMillis();
        k b10 = k.b();
        k kVar = b10;
        kVar.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        kVar.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z10 = true;
        if (b10.f428c != 1) {
            z10 = false;
        }
        boolean z11 = z10;
        long j11 = b10.f427b;
        long j12 = b10.f426a;
        long j13 = j11;
        b10.a(currentTimeMillis + 86400000, location.getLatitude(), location.getLongitude());
        long j14 = b10.f427b;
        if (j13 == -1 || j12 == -1) {
            j10 = 43200000 + currentTimeMillis;
        } else {
            j10 = (currentTimeMillis > j12 ? j14 + 0 : currentTimeMillis > j13 ? j12 + 0 : j13 + 0) + 60000;
        }
        aVar.f433a = z11;
        aVar.f434b = j10;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        a aVar = this.f432c;
        if (e()) {
            return aVar.f433a;
        }
        Location b10 = b();
        if (b10 != null) {
            f(b10);
            return aVar.f433a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i10 = Calendar.getInstance().get(11);
        return i10 < 6 || i10 >= 22;
    }
}
