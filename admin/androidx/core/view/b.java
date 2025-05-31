package androidx.core.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private a f2294a;

    /* renamed from: b  reason: collision with root package name */
    private C0023b f2295b;

    public interface a {
        void b(boolean z10);
    }

    /* renamed from: androidx.core.view.b$b  reason: collision with other inner class name */
    public interface C0023b {
        void onActionProviderVisibilityChanged(boolean z10);
    }

    public b(Context context) {
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return true;
    }

    public abstract View c();

    public View d(MenuItem menuItem) {
        return c();
    }

    public boolean e() {
        return false;
    }

    public void f(SubMenu subMenu) {
    }

    public boolean g() {
        return false;
    }

    public void h() {
        this.f2295b = null;
        this.f2294a = null;
    }

    public void i(a aVar) {
        this.f2294a = aVar;
    }

    public void j(C0023b bVar) {
        if (!(this.f2295b == null || bVar == null)) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f2295b = bVar;
    }

    public void k(boolean z10) {
        a aVar = this.f2294a;
        if (aVar != null) {
            aVar.b(z10);
        }
    }
}
