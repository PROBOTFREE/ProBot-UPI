package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import androidx.core.view.w;
import androidx.core.widget.b;
import androidx.core.widget.k;
import androidx.core.widget.n;
import j.a;

public class AppCompatButton extends Button implements w, b, n {

    /* renamed from: a  reason: collision with root package name */
    private final d f786a;

    /* renamed from: b  reason: collision with root package name */
    private final m f787b;

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.buttonStyle);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet, int i10) {
        super(d0.b(context), attributeSet, i10);
        b0.a(this, getContext());
        d dVar = new d(this);
        this.f786a = dVar;
        dVar.e(attributeSet, i10);
        m mVar = new m(this);
        this.f787b = mVar;
        mVar.m(attributeSet, i10);
        mVar.b();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f786a;
        if (dVar != null) {
            dVar.b();
        }
        m mVar = this.f787b;
        if (mVar != null) {
            mVar.b();
        }
    }

    public int getAutoSizeMaxTextSize() {
        if (b.f2479d0) {
            return super.getAutoSizeMaxTextSize();
        }
        m mVar = this.f787b;
        if (mVar != null) {
            return mVar.e();
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (b.f2479d0) {
            return super.getAutoSizeMinTextSize();
        }
        m mVar = this.f787b;
        if (mVar != null) {
            return mVar.f();
        }
        return -1;
    }

    public int getAutoSizeStepGranularity() {
        if (b.f2479d0) {
            return super.getAutoSizeStepGranularity();
        }
        m mVar = this.f787b;
        if (mVar != null) {
            return mVar.g();
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (b.f2479d0) {
            return super.getAutoSizeTextAvailableSizes();
        }
        m mVar = this.f787b;
        return mVar != null ? mVar.h() : new int[0];
    }

    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (b.f2479d0) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        m mVar = this.f787b;
        if (mVar != null) {
            return mVar.i();
        }
        return 0;
    }

    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f786a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f786a;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f787b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f787b.k();
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        m mVar = this.f787b;
        if (mVar != null) {
            mVar.o(z10, i10, i11, i12, i13);
        }
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        super.onTextChanged(charSequence, i10, i11, i12);
        m mVar = this.f787b;
        if (mVar != null && !b.f2479d0 && mVar.l()) {
            this.f787b.c();
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i10, int i11, int i12, int i13) {
        if (b.f2479d0) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i10, i11, i12, i13);
            return;
        }
        m mVar = this.f787b;
        if (mVar != null) {
            mVar.t(i10, i11, i12, i13);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i10) {
        if (b.f2479d0) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i10);
            return;
        }
        m mVar = this.f787b;
        if (mVar != null) {
            mVar.u(iArr, i10);
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i10) {
        if (b.f2479d0) {
            super.setAutoSizeTextTypeWithDefaults(i10);
            return;
        }
        m mVar = this.f787b;
        if (mVar != null) {
            mVar.v(i10);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f786a;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        d dVar = this.f786a;
        if (dVar != null) {
            dVar.g(i10);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(k.s(this, callback));
    }

    public void setSupportAllCaps(boolean z10) {
        m mVar = this.f787b;
        if (mVar != null) {
            mVar.s(z10);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f786a;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f786a;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f787b.w(colorStateList);
        this.f787b.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f787b.x(mode);
        this.f787b.b();
    }

    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        m mVar = this.f787b;
        if (mVar != null) {
            mVar.q(context, i10);
        }
    }

    public void setTextSize(int i10, float f10) {
        if (b.f2479d0) {
            super.setTextSize(i10, f10);
            return;
        }
        m mVar = this.f787b;
        if (mVar != null) {
            mVar.A(i10, f10);
        }
    }
}
