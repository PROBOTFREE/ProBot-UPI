package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.core.view.w;
import androidx.core.widget.o;
import j.a;

public class AppCompatImageButton extends ImageButton implements w, o {

    /* renamed from: a  reason: collision with root package name */
    private final d f793a;

    /* renamed from: b  reason: collision with root package name */
    private final h f794b;

    public AppCompatImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.imageButtonStyle);
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet, int i10) {
        super(d0.b(context), attributeSet, i10);
        b0.a(this, getContext());
        d dVar = new d(this);
        this.f793a = dVar;
        dVar.e(attributeSet, i10);
        h hVar = new h(this);
        this.f794b = hVar;
        hVar.f(attributeSet, i10);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f793a;
        if (dVar != null) {
            dVar.b();
        }
        h hVar = this.f794b;
        if (hVar != null) {
            hVar.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f793a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f793a;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        h hVar = this.f794b;
        if (hVar != null) {
            return hVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        h hVar = this.f794b;
        if (hVar != null) {
            return hVar.d();
        }
        return null;
    }

    public boolean hasOverlappingRendering() {
        return this.f794b.e() && super.hasOverlappingRendering();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f793a;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        d dVar = this.f793a;
        if (dVar != null) {
            dVar.g(i10);
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        h hVar = this.f794b;
        if (hVar != null) {
            hVar.b();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        h hVar = this.f794b;
        if (hVar != null) {
            hVar.b();
        }
    }

    public void setImageResource(int i10) {
        this.f794b.g(i10);
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        h hVar = this.f794b;
        if (hVar != null) {
            hVar.b();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f793a;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f793a;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        h hVar = this.f794b;
        if (hVar != null) {
            hVar.h(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        h hVar = this.f794b;
        if (hVar != null) {
            hVar.i(mode);
        }
    }
}
