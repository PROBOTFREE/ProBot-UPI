package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.view.w;
import androidx.core.widget.b;
import androidx.core.widget.k;
import androidx.core.widget.n;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import k.a;
import v0.d;

public class AppCompatTextView extends TextView implements w, n, b {

    /* renamed from: a  reason: collision with root package name */
    private final d f828a;

    /* renamed from: b  reason: collision with root package name */
    private final m f829b;

    /* renamed from: c  reason: collision with root package name */
    private final l f830c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f831d;

    /* renamed from: e  reason: collision with root package name */
    private Future<d> f832e;

    public AppCompatTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet, int i10) {
        super(d0.b(context), attributeSet, i10);
        this.f831d = false;
        b0.a(this, getContext());
        d dVar = new d(this);
        this.f828a = dVar;
        dVar.e(attributeSet, i10);
        m mVar = new m(this);
        this.f829b = mVar;
        mVar.m(attributeSet, i10);
        mVar.b();
        this.f830c = new l(this);
    }

    private void a() {
        Future<d> future = this.f832e;
        if (future != null) {
            try {
                this.f832e = null;
                k.p(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f828a;
        if (dVar != null) {
            dVar.b();
        }
        m mVar = this.f829b;
        if (mVar != null) {
            mVar.b();
        }
    }

    public int getAutoSizeMaxTextSize() {
        if (b.f2479d0) {
            return super.getAutoSizeMaxTextSize();
        }
        m mVar = this.f829b;
        if (mVar != null) {
            return mVar.e();
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (b.f2479d0) {
            return super.getAutoSizeMinTextSize();
        }
        m mVar = this.f829b;
        if (mVar != null) {
            return mVar.f();
        }
        return -1;
    }

    public int getAutoSizeStepGranularity() {
        if (b.f2479d0) {
            return super.getAutoSizeStepGranularity();
        }
        m mVar = this.f829b;
        if (mVar != null) {
            return mVar.g();
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (b.f2479d0) {
            return super.getAutoSizeTextAvailableSizes();
        }
        m mVar = this.f829b;
        return mVar != null ? mVar.h() : new int[0];
    }

    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (b.f2479d0) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        m mVar = this.f829b;
        if (mVar != null) {
            return mVar.i();
        }
        return 0;
    }

    public int getFirstBaselineToTopHeight() {
        return k.b(this);
    }

    public int getLastBaselineToBottomHeight() {
        return k.c(this);
    }

    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f828a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f828a;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f829b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f829b.k();
    }

    public CharSequence getText() {
        a();
        return super.getText();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r2.f830c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.textclassifier.TextClassifier getTextClassifier() {
        /*
            r2 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 >= r1) goto L_0x0010
            androidx.appcompat.widget.l r0 = r2.f830c
            if (r0 != 0) goto L_0x000b
            goto L_0x0010
        L_0x000b:
            android.view.textclassifier.TextClassifier r0 = r0.a()
            return r0
        L_0x0010:
            android.view.textclassifier.TextClassifier r0 = super.getTextClassifier()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatTextView.getTextClassifier():android.view.textclassifier.TextClassifier");
    }

    public d.a getTextMetricsParamsCompat() {
        return k.g(this);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f829b.r(this, onCreateInputConnection, editorInfo);
        return g.a(onCreateInputConnection, editorInfo, this);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        m mVar = this.f829b;
        if (mVar != null) {
            mVar.o(z10, i10, i11, i12, i13);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        a();
        super.onMeasure(i10, i11);
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        super.onTextChanged(charSequence, i10, i11, i12);
        m mVar = this.f829b;
        if (mVar != null && !b.f2479d0 && mVar.l()) {
            this.f829b.c();
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i10, int i11, int i12, int i13) {
        if (b.f2479d0) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i10, i11, i12, i13);
            return;
        }
        m mVar = this.f829b;
        if (mVar != null) {
            mVar.t(i10, i11, i12, i13);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i10) {
        if (b.f2479d0) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i10);
            return;
        }
        m mVar = this.f829b;
        if (mVar != null) {
            mVar.u(iArr, i10);
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i10) {
        if (b.f2479d0) {
            super.setAutoSizeTextTypeWithDefaults(i10);
            return;
        }
        m mVar = this.f829b;
        if (mVar != null) {
            mVar.v(i10);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f828a;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        d dVar = this.f828a;
        if (dVar != null) {
            dVar.g(i10);
        }
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        m mVar = this.f829b;
        if (mVar != null) {
            mVar.p();
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        m mVar = this.f829b;
        if (mVar != null) {
            mVar.p();
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable d10 = i10 != 0 ? a.d(context, i10) : null;
        Drawable d11 = i11 != 0 ? a.d(context, i11) : null;
        Drawable d12 = i12 != 0 ? a.d(context, i12) : null;
        if (i13 != 0) {
            drawable = a.d(context, i13);
        }
        setCompoundDrawablesRelativeWithIntrinsicBounds(d10, d11, d12, drawable);
        m mVar = this.f829b;
        if (mVar != null) {
            mVar.p();
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        m mVar = this.f829b;
        if (mVar != null) {
            mVar.p();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable d10 = i10 != 0 ? a.d(context, i10) : null;
        Drawable d11 = i11 != 0 ? a.d(context, i11) : null;
        Drawable d12 = i12 != 0 ? a.d(context, i12) : null;
        if (i13 != 0) {
            drawable = a.d(context, i13);
        }
        setCompoundDrawablesWithIntrinsicBounds(d10, d11, d12, drawable);
        m mVar = this.f829b;
        if (mVar != null) {
            mVar.p();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        m mVar = this.f829b;
        if (mVar != null) {
            mVar.p();
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(k.s(this, callback));
    }

    public void setFirstBaselineToTopHeight(int i10) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i10);
        } else {
            k.m(this, i10);
        }
    }

    public void setLastBaselineToBottomHeight(int i10) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i10);
        } else {
            k.n(this, i10);
        }
    }

    public void setLineHeight(int i10) {
        k.o(this, i10);
    }

    public void setPrecomputedText(d dVar) {
        k.p(this, dVar);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f828a;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f828a;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f829b.w(colorStateList);
        this.f829b.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f829b.x(mode);
        this.f829b.b();
    }

    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        m mVar = this.f829b;
        if (mVar != null) {
            mVar.q(context, i10);
        }
    }

    public void setTextClassifier(TextClassifier textClassifier) {
        l lVar;
        if (Build.VERSION.SDK_INT >= 28 || (lVar = this.f830c) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            lVar.b(textClassifier);
        }
    }

    public void setTextFuture(Future<d> future) {
        this.f832e = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(d.a aVar) {
        k.r(this, aVar);
    }

    public void setTextSize(int i10, float f10) {
        if (b.f2479d0) {
            super.setTextSize(i10, f10);
            return;
        }
        m mVar = this.f829b;
        if (mVar != null) {
            mVar.A(i10, f10);
        }
    }

    public void setTypeface(Typeface typeface, int i10) {
        if (!this.f831d) {
            Typeface typeface2 = null;
            if (typeface != null && i10 > 0) {
                typeface2 = o0.d.a(getContext(), typeface, i10);
            }
            this.f831d = true;
            if (typeface2 != null) {
                typeface = typeface2;
            }
            try {
                super.setTypeface(typeface, i10);
            } finally {
                this.f831d = false;
            }
        }
    }
}
