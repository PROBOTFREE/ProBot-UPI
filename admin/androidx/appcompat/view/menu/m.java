package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.e;

public class m extends e implements SubMenu {
    private e B;
    private g C;

    public m(Context context, e eVar, g gVar) {
        super(context);
        this.B = eVar;
        this.C = gVar;
    }

    public e F() {
        return this.B.F();
    }

    public boolean H() {
        return this.B.H();
    }

    public boolean I() {
        return this.B.I();
    }

    public boolean J() {
        return this.B.J();
    }

    public void V(e.a aVar) {
        this.B.V(aVar);
    }

    public boolean f(g gVar) {
        return this.B.f(gVar);
    }

    public MenuItem getItem() {
        return this.C;
    }

    /* access modifiers changed from: package-private */
    public boolean h(e eVar, MenuItem menuItem) {
        return super.h(eVar, menuItem) || this.B.h(eVar, menuItem);
    }

    public Menu i0() {
        return this.B;
    }

    public boolean m(g gVar) {
        return this.B.m(gVar);
    }

    public void setGroupDividerEnabled(boolean z10) {
        this.B.setGroupDividerEnabled(z10);
    }

    public SubMenu setHeaderIcon(int i10) {
        return (SubMenu) super.Y(i10);
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.Z(drawable);
    }

    public SubMenu setHeaderTitle(int i10) {
        return (SubMenu) super.b0(i10);
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.c0(charSequence);
    }

    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.d0(view);
    }

    public SubMenu setIcon(int i10) {
        this.C.setIcon(i10);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        this.C.setIcon(drawable);
        return this;
    }

    public void setQwertyMode(boolean z10) {
        this.B.setQwertyMode(z10);
    }

    public String v() {
        g gVar = this.C;
        int itemId = gVar != null ? gVar.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.v() + ":" + itemId;
    }
}
