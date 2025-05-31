package androidx.lifecycle;

import androidx.lifecycle.h;

class CompositeGeneratedAdaptersObserver implements m {

    /* renamed from: a  reason: collision with root package name */
    private final f[] f2946a;

    CompositeGeneratedAdaptersObserver(f[] fVarArr) {
        this.f2946a = fVarArr;
    }

    public void c(o oVar, h.b bVar) {
        t tVar = new t();
        for (f a10 : this.f2946a) {
            a10.a(oVar, bVar, false, tVar);
        }
        for (f a11 : this.f2946a) {
            a11.a(oVar, bVar, true, tVar);
        }
    }
}
