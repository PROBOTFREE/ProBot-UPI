package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.j;
import androidx.core.view.f;
import androidx.core.view.x;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private final Context f621a;

    /* renamed from: b  reason: collision with root package name */
    private final e f622b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f623c;

    /* renamed from: d  reason: collision with root package name */
    private final int f624d;

    /* renamed from: e  reason: collision with root package name */
    private final int f625e;

    /* renamed from: f  reason: collision with root package name */
    private View f626f;

    /* renamed from: g  reason: collision with root package name */
    private int f627g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f628h;

    /* renamed from: i  reason: collision with root package name */
    private j.a f629i;

    /* renamed from: j  reason: collision with root package name */
    private h f630j;

    /* renamed from: k  reason: collision with root package name */
    private PopupWindow.OnDismissListener f631k;

    /* renamed from: l  reason: collision with root package name */
    private final PopupWindow.OnDismissListener f632l;

    class a implements PopupWindow.OnDismissListener {
        a() {
        }

        public void onDismiss() {
            i.this.e();
        }
    }

    public i(Context context, e eVar, View view, boolean z10, int i10) {
        this(context, eVar, view, z10, i10, 0);
    }

    public i(Context context, e eVar, View view, boolean z10, int i10, int i11) {
        this.f627g = 8388611;
        this.f632l = new a();
        this.f621a = context;
        this.f622b = eVar;
        this.f626f = view;
        this.f623c = z10;
        this.f624d = i10;
        this.f625e = i11;
    }

    /* JADX WARNING: type inference failed for: r0v7, types: [androidx.appcompat.view.menu.h, androidx.appcompat.view.menu.j] */
    /* JADX WARNING: type inference failed for: r7v1, types: [androidx.appcompat.view.menu.l] */
    /* JADX WARNING: type inference failed for: r1v13, types: [androidx.appcompat.view.menu.b] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private androidx.appcompat.view.menu.h a() {
        /*
            r14 = this;
            android.content.Context r0 = r14.f621a
            java.lang.String r1 = "window"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.view.Display r0 = r0.getDefaultDisplay()
            android.graphics.Point r1 = new android.graphics.Point
            r1.<init>()
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 17
            if (r2 < r3) goto L_0x001d
            r0.getRealSize(r1)
            goto L_0x0020
        L_0x001d:
            r0.getSize(r1)
        L_0x0020:
            int r0 = r1.x
            int r1 = r1.y
            int r0 = java.lang.Math.min(r0, r1)
            android.content.Context r1 = r14.f621a
            android.content.res.Resources r1 = r1.getResources()
            int r2 = j.d.abc_cascading_menus_min_smallest_width
            int r1 = r1.getDimensionPixelSize(r2)
            if (r0 < r1) goto L_0x0038
            r0 = 1
            goto L_0x0039
        L_0x0038:
            r0 = 0
        L_0x0039:
            if (r0 == 0) goto L_0x004c
            androidx.appcompat.view.menu.b r0 = new androidx.appcompat.view.menu.b
            android.content.Context r2 = r14.f621a
            android.view.View r3 = r14.f626f
            int r4 = r14.f624d
            int r5 = r14.f625e
            boolean r6 = r14.f623c
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            goto L_0x005e
        L_0x004c:
            androidx.appcompat.view.menu.l r0 = new androidx.appcompat.view.menu.l
            android.content.Context r8 = r14.f621a
            androidx.appcompat.view.menu.e r9 = r14.f622b
            android.view.View r10 = r14.f626f
            int r11 = r14.f624d
            int r12 = r14.f625e
            boolean r13 = r14.f623c
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13)
        L_0x005e:
            androidx.appcompat.view.menu.e r1 = r14.f622b
            r0.o(r1)
            android.widget.PopupWindow$OnDismissListener r1 = r14.f632l
            r0.x(r1)
            android.view.View r1 = r14.f626f
            r0.s(r1)
            androidx.appcompat.view.menu.j$a r1 = r14.f629i
            r0.n(r1)
            boolean r1 = r14.f628h
            r0.u(r1)
            int r1 = r14.f627g
            r0.v(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.i.a():androidx.appcompat.view.menu.h");
    }

    private void l(int i10, int i11, boolean z10, boolean z11) {
        h c10 = c();
        c10.y(z11);
        if (z10) {
            if ((f.b(this.f627g, x.C(this.f626f)) & 7) == 5) {
                i10 -= this.f626f.getWidth();
            }
            c10.w(i10);
            c10.z(i11);
            int i12 = (int) ((this.f621a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            c10.t(new Rect(i10 - i12, i11 - i12, i10 + i12, i11 + i12));
        }
        c10.b();
    }

    public void b() {
        if (d()) {
            this.f630j.dismiss();
        }
    }

    public h c() {
        if (this.f630j == null) {
            this.f630j = a();
        }
        return this.f630j;
    }

    public boolean d() {
        h hVar = this.f630j;
        return hVar != null && hVar.d();
    }

    /* access modifiers changed from: protected */
    public void e() {
        this.f630j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f631k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void f(View view) {
        this.f626f = view;
    }

    public void g(boolean z10) {
        this.f628h = z10;
        h hVar = this.f630j;
        if (hVar != null) {
            hVar.u(z10);
        }
    }

    public void h(int i10) {
        this.f627g = i10;
    }

    public void i(PopupWindow.OnDismissListener onDismissListener) {
        this.f631k = onDismissListener;
    }

    public void j(j.a aVar) {
        this.f629i = aVar;
        h hVar = this.f630j;
        if (hVar != null) {
            hVar.n(aVar);
        }
    }

    public void k() {
        if (!m()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean m() {
        if (d()) {
            return true;
        }
        if (this.f626f == null) {
            return false;
        }
        l(0, 0, false, false);
        return true;
    }

    public boolean n(int i10, int i11) {
        if (d()) {
            return true;
        }
        if (this.f626f == null) {
            return false;
        }
        l(i10, i11, true, true);
        return true;
    }
}
