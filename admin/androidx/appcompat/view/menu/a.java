package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import java.util.ArrayList;

public abstract class a implements j {

    /* renamed from: a  reason: collision with root package name */
    protected Context f501a;

    /* renamed from: b  reason: collision with root package name */
    protected Context f502b;

    /* renamed from: c  reason: collision with root package name */
    protected e f503c;

    /* renamed from: d  reason: collision with root package name */
    protected LayoutInflater f504d;

    /* renamed from: e  reason: collision with root package name */
    private j.a f505e;

    /* renamed from: f  reason: collision with root package name */
    private int f506f;

    /* renamed from: g  reason: collision with root package name */
    private int f507g;

    /* renamed from: h  reason: collision with root package name */
    protected k f508h;

    /* renamed from: i  reason: collision with root package name */
    private int f509i;

    public a(Context context, int i10, int i11) {
        this.f501a = context;
        this.f504d = LayoutInflater.from(context);
        this.f506f = i10;
        this.f507g = i11;
    }

    public int a() {
        return this.f509i;
    }

    public void c(e eVar, boolean z10) {
        j.a aVar = this.f505e;
        if (aVar != null) {
            aVar.c(eVar, z10);
        }
    }

    /* access modifiers changed from: protected */
    public void d(View view, int i10) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f508h).addView(view, i10);
    }

    public void e(Context context, e eVar) {
        this.f502b = context;
        LayoutInflater.from(context);
        this.f503c = eVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean g(androidx.appcompat.view.menu.m r2) {
        /*
            r1 = this;
            androidx.appcompat.view.menu.j$a r0 = r1.f505e
            if (r0 == 0) goto L_0x000e
            if (r2 == 0) goto L_0x0007
            goto L_0x0009
        L_0x0007:
            androidx.appcompat.view.menu.e r2 = r1.f503c
        L_0x0009:
            boolean r2 = r0.d(r2)
            return r2
        L_0x000e:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.a.g(androidx.appcompat.view.menu.m):boolean");
    }

    public abstract void h(g gVar, k.a aVar);

    public void i(boolean z10) {
        ViewGroup viewGroup = (ViewGroup) this.f508h;
        if (viewGroup != null) {
            e eVar = this.f503c;
            int i10 = 0;
            if (eVar != null) {
                eVar.t();
                ArrayList<g> G = this.f503c.G();
                int size = G.size();
                int i11 = 0;
                for (int i12 = 0; i12 < size; i12++) {
                    g gVar = G.get(i12);
                    if (u(i11, gVar)) {
                        View childAt = viewGroup.getChildAt(i11);
                        g itemData = childAt instanceof k.a ? ((k.a) childAt).getItemData() : null;
                        View r10 = r(gVar, childAt, viewGroup);
                        if (gVar != itemData) {
                            r10.setPressed(false);
                            r10.jumpDrawablesToCurrentState();
                        }
                        if (r10 != childAt) {
                            d(r10, i11);
                        }
                        i11++;
                    }
                }
                i10 = i11;
            }
            while (i10 < viewGroup.getChildCount()) {
                if (!p(viewGroup, i10)) {
                    i10++;
                }
            }
        }
    }

    public boolean l(e eVar, g gVar) {
        return false;
    }

    public boolean m(e eVar, g gVar) {
        return false;
    }

    public void n(j.a aVar) {
        this.f505e = aVar;
    }

    public k.a o(ViewGroup viewGroup) {
        return (k.a) this.f504d.inflate(this.f507g, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    public boolean p(ViewGroup viewGroup, int i10) {
        viewGroup.removeViewAt(i10);
        return true;
    }

    public j.a q() {
        return this.f505e;
    }

    public View r(g gVar, View view, ViewGroup viewGroup) {
        k.a o10 = view instanceof k.a ? (k.a) view : o(viewGroup);
        h(gVar, o10);
        return (View) o10;
    }

    public k s(ViewGroup viewGroup) {
        if (this.f508h == null) {
            k kVar = (k) this.f504d.inflate(this.f506f, viewGroup, false);
            this.f508h = kVar;
            kVar.b(this.f503c);
            i(true);
        }
        return this.f508h;
    }

    public void t(int i10) {
        this.f509i = i10;
    }

    public abstract boolean u(int i10, g gVar);
}
