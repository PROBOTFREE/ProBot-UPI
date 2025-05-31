package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.b;
import androidx.appcompat.view.menu.j;
import j.g;

class f implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, j.a {

    /* renamed from: a  reason: collision with root package name */
    private e f589a;

    /* renamed from: b  reason: collision with root package name */
    private b f590b;

    /* renamed from: c  reason: collision with root package name */
    c f591c;

    /* renamed from: d  reason: collision with root package name */
    private j.a f592d;

    public f(e eVar) {
        this.f589a = eVar;
    }

    public void a() {
        b bVar = this.f590b;
        if (bVar != null) {
            bVar.dismiss();
        }
    }

    public void b(IBinder iBinder) {
        e eVar = this.f589a;
        b.a aVar = new b.a(eVar.w());
        c cVar = new c(aVar.b(), g.abc_list_menu_item_layout);
        this.f591c = cVar;
        cVar.n(this);
        this.f589a.b(this.f591c);
        aVar.c(this.f591c.b(), this);
        View A = eVar.A();
        if (A != null) {
            aVar.e(A);
        } else {
            aVar.f(eVar.y()).m(eVar.z());
        }
        aVar.j(this);
        b a10 = aVar.a();
        this.f590b = a10;
        a10.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f590b.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f590b.show();
    }

    public void c(e eVar, boolean z10) {
        if (z10 || eVar == this.f589a) {
            a();
        }
        j.a aVar = this.f592d;
        if (aVar != null) {
            aVar.c(eVar, z10);
        }
    }

    public boolean d(e eVar) {
        j.a aVar = this.f592d;
        if (aVar != null) {
            return aVar.d(eVar);
        }
        return false;
    }

    public void onClick(DialogInterface dialogInterface, int i10) {
        this.f589a.N((g) this.f591c.b().getItem(i10), 0);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f591c.c(this.f589a, true);
    }

    public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i10 == 82 || i10 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f590b.getWindow();
                if (!(window2 == null || (decorView2 = window2.getDecorView()) == null || (keyDispatcherState2 = decorView2.getKeyDispatcherState()) == null)) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f590b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f589a.e(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f589a.performShortcut(i10, keyEvent, 0);
    }
}
