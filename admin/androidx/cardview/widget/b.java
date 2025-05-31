package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

class b implements e {
    b() {
    }

    private f p(d dVar) {
        return (f) dVar.g();
    }

    public float a(d dVar) {
        return p(dVar).c();
    }

    public ColorStateList b(d dVar) {
        return p(dVar).b();
    }

    public void c(d dVar, Context context, ColorStateList colorStateList, float f10, float f11, float f12) {
        dVar.d(new f(colorStateList, f10));
        View b10 = dVar.b();
        b10.setClipToOutline(true);
        b10.setElevation(f11);
        o(dVar, f12);
    }

    public void d(d dVar, float f10) {
        p(dVar).h(f10);
    }

    public float e(d dVar) {
        return dVar.b().getElevation();
    }

    public void f(d dVar) {
        if (!dVar.f()) {
            dVar.a(0, 0, 0, 0);
            return;
        }
        float a10 = a(dVar);
        float h10 = h(dVar);
        int ceil = (int) Math.ceil((double) g.c(a10, h10, dVar.e()));
        int ceil2 = (int) Math.ceil((double) g.d(a10, h10, dVar.e()));
        dVar.a(ceil, ceil2, ceil, ceil2);
    }

    public void g() {
    }

    public float h(d dVar) {
        return p(dVar).d();
    }

    public float i(d dVar) {
        return h(dVar) * 2.0f;
    }

    public float j(d dVar) {
        return h(dVar) * 2.0f;
    }

    public void k(d dVar) {
        o(dVar, a(dVar));
    }

    public void l(d dVar, float f10) {
        dVar.b().setElevation(f10);
    }

    public void m(d dVar) {
        o(dVar, a(dVar));
    }

    public void n(d dVar, ColorStateList colorStateList) {
        p(dVar).f(colorStateList);
    }

    public void o(d dVar, float f10) {
        p(dVar).g(f10, dVar.f(), dVar.e());
        f(dVar);
    }
}
