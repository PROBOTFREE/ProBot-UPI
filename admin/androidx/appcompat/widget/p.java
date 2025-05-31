package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;
import androidx.core.view.b0;

public interface p {
    void a(Menu menu, j.a aVar);

    boolean b();

    Context c();

    void collapseActionView();

    void d();

    boolean e();

    boolean f();

    boolean g();

    CharSequence getTitle();

    boolean h();

    void i();

    void j(j.a aVar, e.a aVar2);

    void k(z zVar);

    ViewGroup l();

    void m(boolean z10);

    boolean n();

    void o(int i10);

    int p();

    Menu q();

    void r(int i10);

    int s();

    void setIcon(int i10);

    void setIcon(Drawable drawable);

    void setVisibility(int i10);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    b0 t(int i10, long j10);

    void u();

    void v();

    void w(boolean z10);
}
