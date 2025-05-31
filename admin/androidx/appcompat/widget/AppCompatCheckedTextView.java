package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import androidx.core.widget.k;
import k.a;

public class AppCompatCheckedTextView extends CheckedTextView {

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f791b = {16843016};

    /* renamed from: a  reason: collision with root package name */
    private final m f792a;

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet, int i10) {
        super(d0.b(context), attributeSet, i10);
        b0.a(this, getContext());
        m mVar = new m(this);
        this.f792a = mVar;
        mVar.m(attributeSet, i10);
        mVar.b();
        g0 v10 = g0.v(getContext(), attributeSet, f791b, i10, 0);
        setCheckMarkDrawable(v10.g(0));
        v10.w();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        m mVar = this.f792a;
        if (mVar != null) {
            mVar.b();
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return g.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    public void setCheckMarkDrawable(int i10) {
        setCheckMarkDrawable(a.d(getContext(), i10));
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(k.s(this, callback));
    }

    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        m mVar = this.f792a;
        if (mVar != null) {
            mVar.q(context, i10);
        }
    }
}
