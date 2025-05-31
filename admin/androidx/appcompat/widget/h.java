package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.view.x;
import androidx.core.widget.g;
import j.j;
import k.a;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private final ImageView f1085a;

    /* renamed from: b  reason: collision with root package name */
    private e0 f1086b;

    /* renamed from: c  reason: collision with root package name */
    private e0 f1087c;

    /* renamed from: d  reason: collision with root package name */
    private e0 f1088d;

    public h(ImageView imageView) {
        this.f1085a = imageView;
    }

    private boolean a(Drawable drawable) {
        if (this.f1088d == null) {
            this.f1088d = new e0();
        }
        e0 e0Var = this.f1088d;
        e0Var.a();
        ColorStateList a10 = g.a(this.f1085a);
        if (a10 != null) {
            e0Var.f1071d = true;
            e0Var.f1068a = a10;
        }
        PorterDuff.Mode b10 = g.b(this.f1085a);
        if (b10 != null) {
            e0Var.f1070c = true;
            e0Var.f1069b = b10;
        }
        if (!e0Var.f1071d && !e0Var.f1070c) {
            return false;
        }
        f.i(drawable, e0Var, this.f1085a.getDrawableState());
        return true;
    }

    private boolean j() {
        int i10 = Build.VERSION.SDK_INT;
        return i10 > 21 ? this.f1086b != null : i10 == 21;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        Drawable drawable = this.f1085a.getDrawable();
        if (drawable != null) {
            q.b(drawable);
        }
        if (drawable == null) {
            return;
        }
        if (!j() || !a(drawable)) {
            e0 e0Var = this.f1087c;
            if (e0Var != null) {
                f.i(drawable, e0Var, this.f1085a.getDrawableState());
                return;
            }
            e0 e0Var2 = this.f1086b;
            if (e0Var2 != null) {
                f.i(drawable, e0Var2, this.f1085a.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ColorStateList c() {
        e0 e0Var = this.f1087c;
        if (e0Var != null) {
            return e0Var.f1068a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode d() {
        e0 e0Var = this.f1087c;
        if (e0Var != null) {
            return e0Var.f1069b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        return Build.VERSION.SDK_INT < 21 || !(this.f1085a.getBackground() instanceof RippleDrawable);
    }

    public void f(AttributeSet attributeSet, int i10) {
        int n10;
        Context context = this.f1085a.getContext();
        int[] iArr = j.AppCompatImageView;
        g0 v10 = g0.v(context, attributeSet, iArr, i10, 0);
        ImageView imageView = this.f1085a;
        x.p0(imageView, imageView.getContext(), iArr, attributeSet, v10.r(), i10, 0);
        try {
            Drawable drawable = this.f1085a.getDrawable();
            if (!(drawable != null || (n10 = v10.n(j.AppCompatImageView_srcCompat, -1)) == -1 || (drawable = a.d(this.f1085a.getContext(), n10)) == null)) {
                this.f1085a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                q.b(drawable);
            }
            int i11 = j.AppCompatImageView_tint;
            if (v10.s(i11)) {
                g.c(this.f1085a, v10.c(i11));
            }
            int i12 = j.AppCompatImageView_tintMode;
            if (v10.s(i12)) {
                g.d(this.f1085a, q.e(v10.k(i12, -1), (PorterDuff.Mode) null));
            }
        } finally {
            v10.w();
        }
    }

    public void g(int i10) {
        if (i10 != 0) {
            Drawable d10 = a.d(this.f1085a.getContext(), i10);
            if (d10 != null) {
                q.b(d10);
            }
            this.f1085a.setImageDrawable(d10);
        } else {
            this.f1085a.setImageDrawable((Drawable) null);
        }
        b();
    }

    /* access modifiers changed from: package-private */
    public void h(ColorStateList colorStateList) {
        if (this.f1087c == null) {
            this.f1087c = new e0();
        }
        e0 e0Var = this.f1087c;
        e0Var.f1068a = colorStateList;
        e0Var.f1071d = true;
        b();
    }

    /* access modifiers changed from: package-private */
    public void i(PorterDuff.Mode mode) {
        if (this.f1087c == null) {
            this.f1087c = new e0();
        }
        e0 e0Var = this.f1087c;
        e0Var.f1069b = mode;
        e0Var.f1070c = true;
        b();
    }
}
