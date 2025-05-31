package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import androidx.core.view.c;
import androidx.core.view.t;
import androidx.core.view.w;
import androidx.core.view.x;
import androidx.core.widget.k;
import androidx.core.widget.l;
import j.a;
import y0.b;

public class AppCompatEditText extends EditText implements w, t {
    private final d mBackgroundTintHelper;
    private final l mDefaultOnReceiveContentListener;
    private final l mTextClassifierHelper;
    private final m mTextHelper;

    public AppCompatEditText(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.editTextStyle);
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet, int i10) {
        super(d0.b(context), attributeSet, i10);
        b0.a(this, getContext());
        d dVar = new d(this);
        this.mBackgroundTintHelper = dVar;
        dVar.e(attributeSet, i10);
        m mVar = new m(this);
        this.mTextHelper = mVar;
        mVar.m(attributeSet, i10);
        mVar.b();
        this.mTextClassifierHelper = new l(this);
        this.mDefaultOnReceiveContentListener = new l();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.mBackgroundTintHelper;
        if (dVar != null) {
            dVar.b();
        }
        m mVar = this.mTextHelper;
        if (mVar != null) {
            mVar.b();
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

    public Editable getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : super.getEditableText();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r2.mTextClassifierHelper;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.textclassifier.TextClassifier getTextClassifier() {
        /*
            r2 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 >= r1) goto L_0x0010
            androidx.appcompat.widget.l r0 = r2.mTextClassifierHelper
            if (r0 != 0) goto L_0x000b
            goto L_0x0010
        L_0x000b:
            android.view.textclassifier.TextClassifier r0 = r0.a()
            return r0
        L_0x0010:
            android.view.textclassifier.TextClassifier r0 = super.getTextClassifier()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatEditText.getTextClassifier():android.view.textclassifier.TextClassifier");
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.mTextHelper.r(this, onCreateInputConnection, editorInfo);
        InputConnection a10 = g.a(onCreateInputConnection, editorInfo, this);
        String[] F = x.F(this);
        if (a10 == null || F == null) {
            return a10;
        }
        y0.a.d(editorInfo, F);
        return b.a(a10, editorInfo, j.a(this));
    }

    public boolean onDragEvent(DragEvent dragEvent) {
        if (j.b(this, dragEvent)) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    public c onReceiveContent(c cVar) {
        return this.mDefaultOnReceiveContentListener.a(this, cVar);
    }

    public boolean onTextContextMenuItem(int i10) {
        if (j.c(this, i10)) {
            return true;
        }
        return super.onTextContextMenuItem(i10);
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

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(k.s(this, callback));
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

    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        m mVar = this.mTextHelper;
        if (mVar != null) {
            mVar.q(context, i10);
        }
    }

    public void setTextClassifier(TextClassifier textClassifier) {
        l lVar;
        if (Build.VERSION.SDK_INT >= 28 || (lVar = this.mTextClassifierHelper) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            lVar.b(textClassifier);
        }
    }
}
