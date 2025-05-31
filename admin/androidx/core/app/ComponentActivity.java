package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.view.g;
import androidx.lifecycle.h;
import androidx.lifecycle.o;
import androidx.lifecycle.p;
import androidx.lifecycle.y;

public class ComponentActivity extends Activity implements o, g.a {
    private c0.g<Class<? extends a>, a> mExtraDataMap = new c0.g<>();
    private p mLifecycleRegistry = new p(this);

    @Deprecated
    public static class a {
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !g.d(decorView, keyEvent)) {
            return g.e(this, decorView, this, keyEvent);
        }
        return true;
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !g.d(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    @Deprecated
    public <T extends a> T getExtraData(Class<T> cls) {
        return (a) this.mExtraDataMap.get(cls);
    }

    public h getLifecycle() {
        return this.mLifecycleRegistry;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"RestrictedApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        y.g(this);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        this.mLifecycleRegistry.j(h.c.CREATED);
        super.onSaveInstanceState(bundle);
    }

    @Deprecated
    public void putExtraData(a aVar) {
        this.mExtraDataMap.put(aVar.getClass(), aVar);
    }

    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }
}
