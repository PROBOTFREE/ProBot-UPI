package androidx.appcompat.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.l0;
import androidx.core.app.f;
import androidx.core.app.n;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.h0;
import androidx.lifecycle.i0;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.d;
import o.b;

public class AppCompatActivity extends FragmentActivity implements c, n.a {
    private static final String DELEGATE_TAG = "androidx:appcompat";
    private d mDelegate;
    private Resources mResources;

    class a implements SavedStateRegistry.b {
        a() {
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            AppCompatActivity.this.getDelegate().v(bundle);
            return bundle;
        }
    }

    class b implements h.b {
        b() {
        }

        public void a(Context context) {
            d delegate = AppCompatActivity.this.getDelegate();
            delegate.o();
            delegate.r(AppCompatActivity.this.getSavedStateRegistry().a(AppCompatActivity.DELEGATE_TAG));
        }
    }

    public AppCompatActivity() {
        initDelegate();
    }

    public AppCompatActivity(int i10) {
        super(i10);
        initDelegate();
    }

    private void initDelegate() {
        getSavedStateRegistry().d(DELEGATE_TAG, new a());
        addOnContextAvailableListener(new b());
    }

    private void initViewTreeOwners() {
        h0.a(getWindow().getDecorView(), this);
        i0.a(getWindow().getDecorView(), this);
        d.a(getWindow().getDecorView(), this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        r0 = getWindow();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean performMenuItemShortcut(android.view.KeyEvent r3) {
        /*
            r2 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r0 >= r1) goto L_0x003e
            boolean r0 = r3.isCtrlPressed()
            if (r0 != 0) goto L_0x003e
            int r0 = r3.getMetaState()
            boolean r0 = android.view.KeyEvent.metaStateHasNoModifiers(r0)
            if (r0 != 0) goto L_0x003e
            int r0 = r3.getRepeatCount()
            if (r0 != 0) goto L_0x003e
            int r0 = r3.getKeyCode()
            boolean r0 = android.view.KeyEvent.isModifierKey(r0)
            if (r0 != 0) goto L_0x003e
            android.view.Window r0 = r2.getWindow()
            if (r0 == 0) goto L_0x003e
            android.view.View r1 = r0.getDecorView()
            if (r1 == 0) goto L_0x003e
            android.view.View r0 = r0.getDecorView()
            boolean r3 = r0.dispatchKeyShortcutEvent(r3)
            if (r3 == 0) goto L_0x003e
            r3 = 1
            return r3
        L_0x003e:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatActivity.performMenuItemShortcut(android.view.KeyEvent):boolean");
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        getDelegate().d(view, layoutParams);
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(getDelegate().f(context));
    }

    public void closeOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (supportActionBar == null || !supportActionBar.g()) {
            super.closeOptionsMenu();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        ActionBar supportActionBar = getSupportActionBar();
        if (keyCode != 82 || supportActionBar == null || !supportActionBar.p(keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    public <T extends View> T findViewById(int i10) {
        return getDelegate().i(i10);
    }

    public d getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = d.g(this, this);
        }
        return this.mDelegate;
    }

    public a getDrawerToggleDelegate() {
        return getDelegate().k();
    }

    public MenuInflater getMenuInflater() {
        return getDelegate().m();
    }

    public Resources getResources() {
        if (this.mResources == null && l0.c()) {
            this.mResources = new l0(this, super.getResources());
        }
        Resources resources = this.mResources;
        return resources == null ? super.getResources() : resources;
    }

    public ActionBar getSupportActionBar() {
        return getDelegate().n();
    }

    public Intent getSupportParentActivityIntent() {
        return f.a(this);
    }

    public void invalidateOptionsMenu() {
        getDelegate().p();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
        getDelegate().q(configuration);
    }

    public void onContentChanged() {
        onSupportContentChanged();
    }

    public void onCreateSupportNavigateUpTaskStack(n nVar) {
        nVar.h(this);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        getDelegate().s();
    }

    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (performMenuItemShortcut(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    public final boolean onMenuItemSelected(int i10, MenuItem menuItem) {
        if (super.onMenuItemSelected(i10, menuItem)) {
            return true;
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() != 16908332 || supportActionBar == null || (supportActionBar.j() & 4) == 0) {
            return false;
        }
        return onSupportNavigateUp();
    }

    public boolean onMenuOpened(int i10, Menu menu) {
        return super.onMenuOpened(i10, menu);
    }

    /* access modifiers changed from: protected */
    public void onNightModeChanged(int i10) {
    }

    public void onPanelClosed(int i10, Menu menu) {
        super.onPanelClosed(i10, menu);
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        getDelegate().t(bundle);
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        getDelegate().u();
    }

    public void onPrepareSupportNavigateUpTaskStack(n nVar) {
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        getDelegate().w();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        getDelegate().x();
    }

    public void onSupportActionModeFinished(o.b bVar) {
    }

    public void onSupportActionModeStarted(o.b bVar) {
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public boolean onSupportNavigateUp() {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            return false;
        }
        if (supportShouldUpRecreateTask(supportParentActivityIntent)) {
            n t10 = n.t(this);
            onCreateSupportNavigateUpTaskStack(t10);
            onPrepareSupportNavigateUpTaskStack(t10);
            t10.w();
            try {
                androidx.core.app.a.o(this);
                return true;
            } catch (IllegalStateException unused) {
                finish();
                return true;
            }
        } else {
            supportNavigateUpTo(supportParentActivityIntent);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onTitleChanged(CharSequence charSequence, int i10) {
        super.onTitleChanged(charSequence, i10);
        getDelegate().H(charSequence);
    }

    public o.b onWindowStartingSupportActionMode(b.a aVar) {
        return null;
    }

    public void openOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (supportActionBar == null || !supportActionBar.q()) {
            super.openOptionsMenu();
        }
    }

    public void setContentView(int i10) {
        initViewTreeOwners();
        getDelegate().C(i10);
    }

    public void setContentView(View view) {
        initViewTreeOwners();
        getDelegate().D(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        getDelegate().E(view, layoutParams);
    }

    public void setSupportActionBar(Toolbar toolbar) {
        getDelegate().F(toolbar);
    }

    @Deprecated
    public void setSupportProgress(int i10) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean z10) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean z10) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean z10) {
    }

    public void setTheme(int i10) {
        super.setTheme(i10);
        getDelegate().G(i10);
    }

    public o.b startSupportActionMode(b.a aVar) {
        return getDelegate().I(aVar);
    }

    public void supportInvalidateOptionsMenu() {
        getDelegate().p();
    }

    public void supportNavigateUpTo(Intent intent) {
        f.e(this, intent);
    }

    public boolean supportRequestWindowFeature(int i10) {
        return getDelegate().A(i10);
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        return f.f(this, intent);
    }
}
