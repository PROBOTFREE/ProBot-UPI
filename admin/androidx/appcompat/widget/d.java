package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.x;
import j.j;

class d {

    /* renamed from: a  reason: collision with root package name */
    private final View f1052a;

    /* renamed from: b  reason: collision with root package name */
    private final f f1053b;

    /* renamed from: c  reason: collision with root package name */
    private int f1054c = -1;

    /* renamed from: d  reason: collision with root package name */
    private e0 f1055d;

    /* renamed from: e  reason: collision with root package name */
    private e0 f1056e;

    /* renamed from: f  reason: collision with root package name */
    private e0 f1057f;

    d(View view) {
        this.f1052a = view;
        this.f1053b = f.b();
    }

    private boolean a(Drawable drawable) {
        if (this.f1057f == null) {
            this.f1057f = new e0();
        }
        e0 e0Var = this.f1057f;
        e0Var.a();
        ColorStateList s10 = x.s(this.f1052a);
        if (s10 != null) {
            e0Var.f1071d = true;
            e0Var.f1068a = s10;
        }
        PorterDuff.Mode t10 = x.t(this.f1052a);
        if (t10 != null) {
            e0Var.f1070c = true;
            e0Var.f1069b = t10;
        }
        if (!e0Var.f1071d && !e0Var.f1070c) {
            return false;
        }
        f.i(drawable, e0Var, this.f1052a.getDrawableState());
        return true;
    }

    private boolean k() {
        int i10 = Build.VERSION.SDK_INT;
        return i10 > 21 ? this.f1055d != null : i10 == 21;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        Drawable background = this.f1052a.getBackground();
        if (background == null) {
            return;
        }
        if (!k() || !a(background)) {
            e0 e0Var = this.f1056e;
            if (e0Var != null) {
                f.i(background, e0Var, this.f1052a.getDrawableState());
                return;
            }
            e0 e0Var2 = this.f1055d;
            if (e0Var2 != null) {
                f.i(background, e0Var2, this.f1052a.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ColorStateList c() {
        e0 e0Var = this.f1056e;
        if (e0Var != null) {
            return e0Var.f1068a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode d() {
        e0 e0Var = this.f1056e;
        if (e0Var != null) {
            return e0Var.f1069b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void e(AttributeSet attributeSet, int i10) {
        Context context = this.f1052a.getContext();
        int[] iArr = j.ViewBackgroundHelper;
        g0 v10 = g0.v(context, attributeSet, iArr, i10, 0);
        View view = this.f1052a;
        x.p0(view, view.getContext(), iArr, attributeSet, v10.r(), i10, 0);
        try {
            int i11 = j.ViewBackgroundHelper_android_background;
            if (v10.s(i11)) {
                this.f1054c = v10.n(i11, -1);
                ColorStateList f10 = this.f1053b.f(this.f1052a.getContext(), this.f1054c);
                if (f10 != null) {
                    h(f10);
                }
            }
            int i12 = j.ViewBackgroundHelper_backgroundTint;
            if (v10.s(i12)) {
                x.v0(this.f1052a, v10.c(i12));
            }
            int i13 = j.ViewBackgroundHelper_backgroundTintMode;
            if (v10.s(i13)) {
                x.w0(this.f1052a, q.e(v10.k(i13, -1), (PorterDuff.Mode) null));
            }
        } finally {
            v10.w();
        }
    }

    /* access modifiers changed from: package-private */
    public void f(Drawable drawable) {
        this.f1054c = -1;
        h((ColorStateList) null);
        b();
    }

    /* access modifiers changed from: package-private */
    public void g(int i10) {
        this.f1054c = i10;
        f fVar = this.f1053b;
        h(fVar != null ? fVar.f(this.f1052a.getContext(), i10) : null);
        b();
    }

    /* access modifiers changed from: package-private */
    public void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f1055d == null) {
                this.f1055d = new e0();
            }
            e0 e0Var = this.f1055d;
            e0Var.f1068a = colorStateList;
            e0Var.f1071d = true;
        } else {
            this.f1055d = null;
        }
        b();
    }

    /* access modifiers changed from: package-private */
    public void i(ColorStateList colorStateList) {
        if (this.f1056e == null) {
            this.f1056e = new e0();
        }
        e0 e0Var = this.f1056e;
        e0Var.f1068a = colorStateList;
        e0Var.f1071d = true;
        b();
    }

    /* access modifiers changed from: package-private */
    public void j(PorterDuff.Mode mode) {
        if (this.f1056e == null) {
            this.f1056e = new e0();
        }
        e0 e0Var = this.f1056e;
        e0Var.f1069b = mode;
        e0Var.f1070c = true;
        b();
    }
}
