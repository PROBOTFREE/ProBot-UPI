package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.g;
import o.b;

public class e extends Dialog implements c {

    /* renamed from: a  reason: collision with root package name */
    private d f390a;

    /* renamed from: b  reason: collision with root package name */
    private final g.a f391b = new a();

    class a implements g.a {
        a() {
        }

        public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
            return e.this.c(keyEvent);
        }
    }

    public e(Context context, int i10) {
        super(context, b(context, i10));
        d a10 = a();
        a10.G(b(context, i10));
        a10.r((Bundle) null);
    }

    private static int b(Context context, int i10) {
        if (i10 != 0) {
            return i10;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(j.a.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public d a() {
        if (this.f390a == null) {
            this.f390a = d.h(this, this);
        }
        return this.f390a;
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().d(view, layoutParams);
    }

    /* access modifiers changed from: package-private */
    public boolean c(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean d(int i10) {
        return a().A(i10);
    }

    public void dismiss() {
        super.dismiss();
        a().s();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return g.e(this.f391b, getWindow().getDecorView(), this, keyEvent);
    }

    public <T extends View> T findViewById(int i10) {
        return a().i(i10);
    }

    public void invalidateOptionsMenu() {
        a().p();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        a().o();
        super.onCreate(bundle);
        a().r(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        a().x();
    }

    public void onSupportActionModeFinished(b bVar) {
    }

    public void onSupportActionModeStarted(b bVar) {
    }

    public b onWindowStartingSupportActionMode(b.a aVar) {
        return null;
    }

    public void setContentView(int i10) {
        a().C(i10);
    }

    public void setContentView(View view) {
        a().D(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().E(view, layoutParams);
    }

    public void setTitle(int i10) {
        super.setTitle(i10);
        a().H(getContext().getString(i10));
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        a().H(charSequence);
    }
}
