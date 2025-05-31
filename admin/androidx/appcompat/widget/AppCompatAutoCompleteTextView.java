package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import androidx.core.view.w;
import androidx.core.widget.k;
import j.a;

public class AppCompatAutoCompleteTextView extends AutoCompleteTextView implements w {

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f783c = {16843126};

    /* renamed from: a  reason: collision with root package name */
    private final d f784a;

    /* renamed from: b  reason: collision with root package name */
    private final m f785b;

    public AppCompatAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.autoCompleteTextViewStyle);
    }

    public AppCompatAutoCompleteTextView(Context context, AttributeSet attributeSet, int i10) {
        super(d0.b(context), attributeSet, i10);
        b0.a(this, getContext());
        g0 v10 = g0.v(getContext(), attributeSet, f783c, i10, 0);
        if (v10.s(0)) {
            setDropDownBackgroundDrawable(v10.g(0));
        }
        v10.w();
        d dVar = new d(this);
        this.f784a = dVar;
        dVar.e(attributeSet, i10);
        m mVar = new m(this);
        this.f785b = mVar;
        mVar.m(attributeSet, i10);
        mVar.b();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f784a;
        if (dVar != null) {
            dVar.b();
        }
        m mVar = this.f785b;
        if (mVar != null) {
            mVar.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f784a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f784a;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return g.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f784a;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        d dVar = this.f784a;
        if (dVar != null) {
            dVar.g(i10);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(k.s(this, callback));
    }

    public void setDropDownBackgroundResource(int i10) {
        setDropDownBackgroundDrawable(k.a.d(getContext(), i10));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f784a;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f784a;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        m mVar = this.f785b;
        if (mVar != null) {
            mVar.q(context, i10);
        }
    }
}
