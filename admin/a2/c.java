package a2;

import android.app.Notification;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final int f78a;

    /* renamed from: b  reason: collision with root package name */
    private final int f79b;

    /* renamed from: c  reason: collision with root package name */
    private final Notification f80c;

    public c(int i10, Notification notification, int i11) {
        this.f78a = i10;
        this.f80c = notification;
        this.f79b = i11;
    }

    public int a() {
        return this.f79b;
    }

    public Notification b() {
        return this.f80c;
    }

    public int c() {
        return this.f78a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f78a == cVar.f78a && this.f79b == cVar.f79b) {
            return this.f80c.equals(cVar.f80c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f78a * 31) + this.f79b) * 31) + this.f80c.hashCode();
    }

    public String toString() {
        return "ForegroundInfo{" + "mNotificationId=" + this.f78a + ", mForegroundServiceType=" + this.f79b + ", mNotification=" + this.f80c + '}';
    }
}
