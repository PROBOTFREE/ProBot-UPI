package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.view.w;
import androidx.core.widget.o;

public class AppCompatImageView extends ImageView implements w, o {
    private final d mBackgroundTintHelper;
    private final h mImageHelper;

    public AppCompatImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet, int i10) {
        super(d0.b(context), attributeSet, i10);
        b0.a(this, getContext());
        d dVar = new d(this);
        this.mBackgroundTintHelper = dVar;
        dVar.e(attributeSet, i10);
        h hVar = new h(this);
        this.mImageHelper = hVar;
        hVar.f(attributeSet, i10);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.mBackgroundTintHelper;
        if (dVar != null) {
            dVar.b();
        }
        h hVar = this.mImageHelper;
        if (hVar != null) {
            hVar.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.mBackgroundTintHelper;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.mBackgroundTintHelper;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        h hVar = this.mImageHelper;
        if (hVar != null) {
            return hVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        h hVar = this.mImageHelper;
        if (hVar != null) {
            return hVar.d();
        }
        return null;
    }

    public boolean hasOverlappingRendering() {
        return this.mImageHelper.e() && super.hasOverlappingRendering();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.mBackgroundTintHelper;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        d dVar = this.mBackgroundTintHelper;
        if (dVar != null) {
            dVar.g(i10);
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        h hVar = this.mImageHelper;
        if (hVar != null) {
            hVar.b();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        h hVar = this.mImageHelper;
        if (hVar != null) {
            hVar.b();
        }
    }

    public void setImageResource(int i10) {
        h hVar = this.mImageHelper;
        if (hVar != null) {
            hVar.g(i10);
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        h hVar = this.mImageHelper;
        if (hVar != null) {
            hVar.b();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.mBackgroundTintHelper;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.mBackgroundTintHelper;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        h hVar = this.mImageHelper;
        if (hVar != null) {
            hVar.h(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        h hVar = this.mImageHelper;
        if (hVar != null) {
            hVar.i(mode);
        }
    }
}
