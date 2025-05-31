package androidx.transition;

import android.view.View;
import android.view.WindowId;

class n0 implements o0 {

    /* renamed from: a  reason: collision with root package name */
    private final WindowId f4138a;

    n0(View view) {
        this.f4138a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof n0) && ((n0) obj).f4138a.equals(this.f4138a);
    }

    public int hashCode() {
        return this.f4138a.hashCode();
    }
}
