package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.h0;
import androidx.appcompat.widget.p;
import androidx.core.view.x;
import java.util.ArrayList;
import o.i;

class j extends ActionBar {

    /* renamed from: a  reason: collision with root package name */
    p f411a;

    /* renamed from: b  reason: collision with root package name */
    boolean f412b;

    /* renamed from: c  reason: collision with root package name */
    Window.Callback f413c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f414d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f415e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<ActionBar.a> f416f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private final Runnable f417g = new a();

    /* renamed from: h  reason: collision with root package name */
    private final Toolbar.e f418h;

    class a implements Runnable {
        a() {
        }

        public void run() {
            j.this.x();
        }
    }

    class b implements Toolbar.e {
        b() {
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return j.this.f413c.onMenuItemSelected(0, menuItem);
        }
    }

    private final class c implements j.a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f421a;

        c() {
        }

        public void c(androidx.appcompat.view.menu.e eVar, boolean z10) {
            if (!this.f421a) {
                this.f421a = true;
                j.this.f411a.i();
                Window.Callback callback = j.this.f413c;
                if (callback != null) {
                    callback.onPanelClosed(108, eVar);
                }
                this.f421a = false;
            }
        }

        public boolean d(androidx.appcompat.view.menu.e eVar) {
            Window.Callback callback = j.this.f413c;
            if (callback == null) {
                return false;
            }
            callback.onMenuOpened(108, eVar);
            return true;
        }
    }

    private final class d implements e.a {
        d() {
        }

        public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            return false;
        }

        public void b(androidx.appcompat.view.menu.e eVar) {
            j jVar = j.this;
            if (jVar.f413c == null) {
                return;
            }
            if (jVar.f411a.b()) {
                j.this.f413c.onPanelClosed(108, eVar);
            } else if (j.this.f413c.onPreparePanel(0, (View) null, eVar)) {
                j.this.f413c.onMenuOpened(108, eVar);
            }
        }
    }

    private class e extends i {
        public e(Window.Callback callback) {
            super(callback);
        }

        public View onCreatePanelView(int i10) {
            return i10 == 0 ? new View(j.this.f411a.c()) : super.onCreatePanelView(i10);
        }

        public boolean onPreparePanel(int i10, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i10, view, menu);
            if (onPreparePanel) {
                j jVar = j.this;
                if (!jVar.f412b) {
                    jVar.f411a.d();
                    j.this.f412b = true;
                }
            }
            return onPreparePanel;
        }
    }

    j(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        b bVar = new b();
        this.f418h = bVar;
        this.f411a = new h0(toolbar, false);
        e eVar = new e(callback);
        this.f413c = eVar;
        this.f411a.setWindowCallback(eVar);
        toolbar.setOnMenuItemClickListener(bVar);
        this.f411a.setWindowTitle(charSequence);
    }

    private Menu v() {
        if (!this.f414d) {
            this.f411a.j(new c(), new d());
            this.f414d = true;
        }
        return this.f411a.q();
    }

    public boolean g() {
        return this.f411a.f();
    }

    public boolean h() {
        if (!this.f411a.n()) {
            return false;
        }
        this.f411a.collapseActionView();
        return true;
    }

    public void i(boolean z10) {
        if (z10 != this.f415e) {
            this.f415e = z10;
            int size = this.f416f.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f416f.get(i10).a(z10);
            }
        }
    }

    public int j() {
        return this.f411a.p();
    }

    public Context k() {
        return this.f411a.c();
    }

    public boolean l() {
        this.f411a.l().removeCallbacks(this.f417g);
        x.j0(this.f411a.l(), this.f417g);
        return true;
    }

    public void m(Configuration configuration) {
        super.m(configuration);
    }

    /* access modifiers changed from: package-private */
    public void n() {
        this.f411a.l().removeCallbacks(this.f417g);
    }

    public boolean o(int i10, KeyEvent keyEvent) {
        Menu v10 = v();
        if (v10 == null) {
            return false;
        }
        boolean z10 = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z10 = false;
        }
        v10.setQwertyMode(z10);
        return v10.performShortcut(i10, keyEvent, 0);
    }

    public boolean p(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            q();
        }
        return true;
    }

    public boolean q() {
        return this.f411a.g();
    }

    public void r(boolean z10) {
    }

    public void s(boolean z10) {
    }

    public void t(CharSequence charSequence) {
        this.f411a.setWindowTitle(charSequence);
    }

    public Window.Callback w() {
        return this.f413c;
    }

    /* access modifiers changed from: package-private */
    public void x() {
        Menu v10 = v();
        androidx.appcompat.view.menu.e eVar = v10 instanceof androidx.appcompat.view.menu.e ? (androidx.appcompat.view.menu.e) v10 : null;
        if (eVar != null) {
            eVar.h0();
        }
        try {
            v10.clear();
            if (!this.f413c.onCreatePanelMenu(0, v10) || !this.f413c.onPreparePanel(0, (View) null, v10)) {
                v10.clear();
            }
        } finally {
            if (eVar != null) {
                eVar.g0();
            }
        }
    }
}
