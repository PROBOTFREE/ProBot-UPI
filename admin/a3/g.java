package a3;

import a3.h;
import android.annotation.SuppressLint;
import w2.c;
import y2.v;

public class g extends s3.g<c, v<?>> implements h {

    /* renamed from: d  reason: collision with root package name */
    private h.a f103d;

    public g(long j10) {
        super(j10);
    }

    @SuppressLint({"InlinedApi"})
    public void a(int i10) {
        if (i10 >= 40) {
            b();
        } else if (i10 >= 20 || i10 == 15) {
            m(h() / 2);
        }
    }

    public /* bridge */ /* synthetic */ v c(c cVar, v vVar) {
        return (v) super.k(cVar, vVar);
    }

    public void d(h.a aVar) {
        this.f103d = aVar;
    }

    public /* bridge */ /* synthetic */ v e(c cVar) {
        return (v) super.l(cVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public int i(v<?> vVar) {
        return vVar == null ? super.i(null) : vVar.c();
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public void j(c cVar, v<?> vVar) {
        h.a aVar = this.f103d;
        if (aVar != null && vVar != null) {
            aVar.c(vVar);
        }
    }
}
