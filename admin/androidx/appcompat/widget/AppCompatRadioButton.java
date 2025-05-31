package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import androidx.core.view.w;
import androidx.core.widget.m;
import j.a;

public class AppCompatRadioButton extends RadioButton implements m, w {

    /* renamed from: a  reason: collision with root package name */
    private final e f800a;

    /* renamed from: b  reason: collision with root package name */
    private final d f801b;

    /* renamed from: c  reason: collision with root package name */
    private final m f802c;

    public AppCompatRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.radioButtonStyle);
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet, int i10) {
        super(d0.b(context), attributeSet, i10);
        b0.a(this, getContext());
        e eVar = new e(this);
        this.f800a = eVar;
        eVar.e(attributeSet, i10);
        d dVar = new d(this);
        this.f801b = dVar;
        dVar.e(attributeSet, i10);
        m mVar = new m(this);
        this.f802c = mVar;
        mVar.m(attributeSet, i10);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f801b;
        if (dVar != null) {
            dVar.b();
        }
        m mVar = this.f802c;
        if (mVar != null) {
            mVar.b();
        }
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        e eVar = this.f800a;
        return eVar != null ? eVar.b(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f801b;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f801b;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    public ColorStateList getSupportButtonTintList() {
        e eVar = this.f800a;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        e eVar = this.f800a;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f801b;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        d dVar = this.f801b;
        if (dVar != null) {
            dVar.g(i10);
        }
    }

    public void setButtonDrawable(int i10) {
        setButtonDrawable(k.a.d(getContext(), i10));
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        e eVar = this.f800a;
        if (eVar != null) {
            eVar.f();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f801b;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f801b;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        e eVar = this.f800a;
        if (eVar != null) {
            eVar.g(colorStateList);
        }
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        e eVar = this.f800a;
        if (eVar != null) {
            eVar.h(mode);
        }
    }
}
