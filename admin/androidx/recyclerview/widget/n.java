package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

class n {

    /* renamed from: a  reason: collision with root package name */
    boolean f3671a = true;

    /* renamed from: b  reason: collision with root package name */
    int f3672b;

    /* renamed from: c  reason: collision with root package name */
    int f3673c;

    /* renamed from: d  reason: collision with root package name */
    int f3674d;

    /* renamed from: e  reason: collision with root package name */
    int f3675e;

    /* renamed from: f  reason: collision with root package name */
    int f3676f = 0;

    /* renamed from: g  reason: collision with root package name */
    int f3677g = 0;

    /* renamed from: h  reason: collision with root package name */
    boolean f3678h;

    /* renamed from: i  reason: collision with root package name */
    boolean f3679i;

    n() {
    }

    /* access modifiers changed from: package-private */
    public boolean a(RecyclerView.z zVar) {
        int i10 = this.f3673c;
        return i10 >= 0 && i10 < zVar.b();
    }

    /* access modifiers changed from: package-private */
    public View b(RecyclerView.v vVar) {
        View o10 = vVar.o(this.f3673c);
        this.f3673c += this.f3674d;
        return o10;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f3672b + ", mCurrentPosition=" + this.f3673c + ", mItemDirection=" + this.f3674d + ", mLayoutDirection=" + this.f3675e + ", mStartLine=" + this.f3676f + ", mEndLine=" + this.f3677g + '}';
    }
}
