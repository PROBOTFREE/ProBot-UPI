package androidx.transition;

import android.os.IBinder;

class m0 implements o0 {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f4137a;

    m0(IBinder iBinder) {
        this.f4137a = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof m0) && ((m0) obj).f4137a.equals(this.f4137a);
    }

    public int hashCode() {
        return this.f4137a.hashCode();
    }
}
