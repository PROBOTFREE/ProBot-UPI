package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ToggleButton;
import androidx.core.view.w;

public class AppCompatToggleButton extends ToggleButton implements w {

    /* renamed from: a  reason: collision with root package name */
    private final d f833a;

    /* renamed from: b  reason: collision with root package name */
    private final m f834b;

    public AppCompatToggleButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842827);
    }

    public AppCompatToggleButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        b0.a(this, getContext());
        d dVar = new d(this);
        this.f833a = dVar;
        dVar.e(attributeSet, i10);
        m mVar = new m(this);
        this.f834b = mVar;
        mVar.m(attributeSet, i10);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f833a;
        if (dVar != null) {
            dVar.b();
        }
        m mVar = this.f834b;
        if (mVar != null) {
            mVar.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f833a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f833a;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f833a;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        d dVar = this.f833a;
        if (dVar != null) {
            dVar.g(i10);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f833a;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f833a;
        if (dVar != null) {
            dVar.j(mode);
        }
    }
}
