package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.k;
import androidx.core.view.b;
import androidx.recyclerview.widget.RecyclerView;
import j.h;
import q0.b;

public final class g implements b {
    private View A;
    private androidx.core.view.b B;
    private MenuItem.OnActionExpandListener C;
    private boolean D = false;
    private ContextMenu.ContextMenuInfo E;

    /* renamed from: a  reason: collision with root package name */
    private final int f593a;

    /* renamed from: b  reason: collision with root package name */
    private final int f594b;

    /* renamed from: c  reason: collision with root package name */
    private final int f595c;

    /* renamed from: d  reason: collision with root package name */
    private final int f596d;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f597e;

    /* renamed from: f  reason: collision with root package name */
    private CharSequence f598f;

    /* renamed from: g  reason: collision with root package name */
    private Intent f599g;

    /* renamed from: h  reason: collision with root package name */
    private char f600h;

    /* renamed from: i  reason: collision with root package name */
    private int f601i = RecyclerView.m.FLAG_APPEARED_IN_PRE_LAYOUT;

    /* renamed from: j  reason: collision with root package name */
    private char f602j;

    /* renamed from: k  reason: collision with root package name */
    private int f603k = RecyclerView.m.FLAG_APPEARED_IN_PRE_LAYOUT;

    /* renamed from: l  reason: collision with root package name */
    private Drawable f604l;

    /* renamed from: m  reason: collision with root package name */
    private int f605m = 0;

    /* renamed from: n  reason: collision with root package name */
    e f606n;

    /* renamed from: o  reason: collision with root package name */
    private m f607o;

    /* renamed from: p  reason: collision with root package name */
    private Runnable f608p;

    /* renamed from: q  reason: collision with root package name */
    private MenuItem.OnMenuItemClickListener f609q;

    /* renamed from: r  reason: collision with root package name */
    private CharSequence f610r;

    /* renamed from: s  reason: collision with root package name */
    private CharSequence f611s;

    /* renamed from: t  reason: collision with root package name */
    private ColorStateList f612t = null;

    /* renamed from: u  reason: collision with root package name */
    private PorterDuff.Mode f613u = null;

    /* renamed from: v  reason: collision with root package name */
    private boolean f614v = false;

    /* renamed from: w  reason: collision with root package name */
    private boolean f615w = false;

    /* renamed from: x  reason: collision with root package name */
    private boolean f616x = false;

    /* renamed from: y  reason: collision with root package name */
    private int f617y = 16;

    /* renamed from: z  reason: collision with root package name */
    private int f618z = 0;

    class a implements b.C0023b {
        a() {
        }

        public void onActionProviderVisibilityChanged(boolean z10) {
            g gVar = g.this;
            gVar.f606n.L(gVar);
        }
    }

    g(e eVar, int i10, int i11, int i12, int i13, CharSequence charSequence, int i14) {
        this.f606n = eVar;
        this.f593a = i11;
        this.f594b = i10;
        this.f595c = i12;
        this.f596d = i13;
        this.f597e = charSequence;
        this.f618z = i14;
    }

    private static void d(StringBuilder sb2, int i10, int i11, String str) {
        if ((i10 & i11) == i11) {
            sb2.append(str);
        }
    }

    private Drawable e(Drawable drawable) {
        if (drawable != null && this.f616x && (this.f614v || this.f615w)) {
            drawable = p0.a.r(drawable).mutate();
            if (this.f614v) {
                p0.a.o(drawable, this.f612t);
            }
            if (this.f615w) {
                p0.a.p(drawable, this.f613u);
            }
            this.f616x = false;
        }
        return drawable;
    }

    /* access modifiers changed from: package-private */
    public boolean A() {
        return this.f606n.J() && g() != 0;
    }

    public boolean B() {
        return (this.f618z & 4) == 4;
    }

    public q0.b a(androidx.core.view.b bVar) {
        androidx.core.view.b bVar2 = this.B;
        if (bVar2 != null) {
            bVar2.h();
        }
        this.A = null;
        this.B = bVar;
        this.f606n.M(true);
        androidx.core.view.b bVar3 = this.B;
        if (bVar3 != null) {
            bVar3.j(new a());
        }
        return this;
    }

    public androidx.core.view.b b() {
        return this.B;
    }

    public void c() {
        this.f606n.K(this);
    }

    public boolean collapseActionView() {
        if ((this.f618z & 8) == 0) {
            return false;
        }
        if (this.A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f606n.f(this);
        }
        return false;
    }

    public boolean expandActionView() {
        if (!j()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f606n.m(this);
        }
        return false;
    }

    public int f() {
        return this.f596d;
    }

    /* access modifiers changed from: package-private */
    public char g() {
        return this.f606n.I() ? this.f602j : this.f600h;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public View getActionView() {
        View view = this.A;
        if (view != null) {
            return view;
        }
        androidx.core.view.b bVar = this.B;
        if (bVar == null) {
            return null;
        }
        View d10 = bVar.d(this);
        this.A = d10;
        return d10;
    }

    public int getAlphabeticModifiers() {
        return this.f603k;
    }

    public char getAlphabeticShortcut() {
        return this.f602j;
    }

    public CharSequence getContentDescription() {
        return this.f610r;
    }

    public int getGroupId() {
        return this.f594b;
    }

    public Drawable getIcon() {
        Drawable drawable = this.f604l;
        if (drawable != null) {
            return e(drawable);
        }
        if (this.f605m == 0) {
            return null;
        }
        Drawable d10 = k.a.d(this.f606n.w(), this.f605m);
        this.f605m = 0;
        this.f604l = d10;
        return e(d10);
    }

    public ColorStateList getIconTintList() {
        return this.f612t;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f613u;
    }

    public Intent getIntent() {
        return this.f599g;
    }

    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f593a;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.E;
    }

    public int getNumericModifiers() {
        return this.f601i;
    }

    public char getNumericShortcut() {
        return this.f600h;
    }

    public int getOrder() {
        return this.f595c;
    }

    public SubMenu getSubMenu() {
        return this.f607o;
    }

    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f597e;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f598f;
        if (charSequence == null) {
            charSequence = this.f597e;
        }
        return (Build.VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    public CharSequence getTooltipText() {
        return this.f611s;
    }

    /* access modifiers changed from: package-private */
    public String h() {
        int i10;
        char g10 = g();
        if (g10 == 0) {
            return "";
        }
        Resources resources = this.f606n.w().getResources();
        StringBuilder sb2 = new StringBuilder();
        if (ViewConfiguration.get(this.f606n.w()).hasPermanentMenuKey()) {
            sb2.append(resources.getString(h.abc_prepend_shortcut_label));
        }
        int i11 = this.f606n.I() ? this.f603k : this.f601i;
        d(sb2, i11, 65536, resources.getString(h.abc_menu_meta_shortcut_label));
        d(sb2, i11, RecyclerView.m.FLAG_APPEARED_IN_PRE_LAYOUT, resources.getString(h.abc_menu_ctrl_shortcut_label));
        d(sb2, i11, 2, resources.getString(h.abc_menu_alt_shortcut_label));
        d(sb2, i11, 1, resources.getString(h.abc_menu_shift_shortcut_label));
        d(sb2, i11, 4, resources.getString(h.abc_menu_sym_shortcut_label));
        d(sb2, i11, 8, resources.getString(h.abc_menu_function_shortcut_label));
        if (g10 == 8) {
            i10 = h.abc_menu_delete_shortcut_label;
        } else if (g10 == 10) {
            i10 = h.abc_menu_enter_shortcut_label;
        } else if (g10 != ' ') {
            sb2.append(g10);
            return sb2.toString();
        } else {
            i10 = h.abc_menu_space_shortcut_label;
        }
        sb2.append(resources.getString(i10));
        return sb2.toString();
    }

    public boolean hasSubMenu() {
        return this.f607o != null;
    }

    /* access modifiers changed from: package-private */
    public CharSequence i(k.a aVar) {
        return (aVar == null || !aVar.d()) ? getTitle() : getTitleCondensed();
    }

    public boolean isActionViewExpanded() {
        return this.D;
    }

    public boolean isCheckable() {
        return (this.f617y & 1) == 1;
    }

    public boolean isChecked() {
        return (this.f617y & 2) == 2;
    }

    public boolean isEnabled() {
        return (this.f617y & 16) != 0;
    }

    public boolean isVisible() {
        androidx.core.view.b bVar = this.B;
        return (bVar == null || !bVar.g()) ? (this.f617y & 8) == 0 : (this.f617y & 8) == 0 && this.B.b();
    }

    public boolean j() {
        androidx.core.view.b bVar;
        if ((this.f618z & 8) == 0) {
            return false;
        }
        if (this.A == null && (bVar = this.B) != null) {
            this.A = bVar.d(this);
        }
        return this.A != null;
    }

    public boolean k() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f609q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        e eVar = this.f606n;
        if (eVar.h(eVar, this)) {
            return true;
        }
        Runnable runnable = this.f608p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f599g != null) {
            try {
                this.f606n.w().startActivity(this.f599g);
                return true;
            } catch (ActivityNotFoundException e10) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e10);
            }
        }
        androidx.core.view.b bVar = this.B;
        return bVar != null && bVar.e();
    }

    public boolean l() {
        return (this.f617y & 32) == 32;
    }

    public boolean m() {
        return (this.f617y & 4) != 0;
    }

    public boolean n() {
        return (this.f618z & 1) == 1;
    }

    public boolean o() {
        return (this.f618z & 2) == 2;
    }

    /* renamed from: p */
    public q0.b setActionView(int i10) {
        Context w10 = this.f606n.w();
        setActionView(LayoutInflater.from(w10).inflate(i10, new LinearLayout(w10), false));
        return this;
    }

    /* renamed from: q */
    public q0.b setActionView(View view) {
        int i10;
        this.A = view;
        this.B = null;
        if (view != null && view.getId() == -1 && (i10 = this.f593a) > 0) {
            view.setId(i10);
        }
        this.f606n.K(this);
        return this;
    }

    public void r(boolean z10) {
        this.D = z10;
        this.f606n.M(false);
    }

    /* access modifiers changed from: package-private */
    public void s(boolean z10) {
        int i10 = this.f617y;
        int i11 = (z10 ? 2 : 0) | (i10 & -3);
        this.f617y = i11;
        if (i10 != i11) {
            this.f606n.M(false);
        }
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public MenuItem setAlphabeticShortcut(char c10) {
        if (this.f602j == c10) {
            return this;
        }
        this.f602j = Character.toLowerCase(c10);
        this.f606n.M(false);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c10, int i10) {
        if (this.f602j == c10 && this.f603k == i10) {
            return this;
        }
        this.f602j = Character.toLowerCase(c10);
        this.f603k = KeyEvent.normalizeMetaState(i10);
        this.f606n.M(false);
        return this;
    }

    public MenuItem setCheckable(boolean z10) {
        int i10 = this.f617y;
        boolean z11 = z10 | (i10 & true);
        this.f617y = z11 ? 1 : 0;
        if (i10 != z11) {
            this.f606n.M(false);
        }
        return this;
    }

    public MenuItem setChecked(boolean z10) {
        if ((this.f617y & 4) != 0) {
            this.f606n.X(this);
        } else {
            s(z10);
        }
        return this;
    }

    public q0.b setContentDescription(CharSequence charSequence) {
        this.f610r = charSequence;
        this.f606n.M(false);
        return this;
    }

    public MenuItem setEnabled(boolean z10) {
        this.f617y = z10 ? this.f617y | 16 : this.f617y & -17;
        this.f606n.M(false);
        return this;
    }

    public MenuItem setIcon(int i10) {
        this.f604l = null;
        this.f605m = i10;
        this.f616x = true;
        this.f606n.M(false);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f605m = 0;
        this.f604l = drawable;
        this.f616x = true;
        this.f606n.M(false);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f612t = colorStateList;
        this.f614v = true;
        this.f616x = true;
        this.f606n.M(false);
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f613u = mode;
        this.f615w = true;
        this.f616x = true;
        this.f606n.M(false);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f599g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c10) {
        if (this.f600h == c10) {
            return this;
        }
        this.f600h = c10;
        this.f606n.M(false);
        return this;
    }

    public MenuItem setNumericShortcut(char c10, int i10) {
        if (this.f600h == c10 && this.f601i == i10) {
            return this;
        }
        this.f600h = c10;
        this.f601i = KeyEvent.normalizeMetaState(i10);
        this.f606n.M(false);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.C = onActionExpandListener;
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f609q = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c10, char c11) {
        this.f600h = c10;
        this.f602j = Character.toLowerCase(c11);
        this.f606n.M(false);
        return this;
    }

    public MenuItem setShortcut(char c10, char c11, int i10, int i11) {
        this.f600h = c10;
        this.f601i = KeyEvent.normalizeMetaState(i10);
        this.f602j = Character.toLowerCase(c11);
        this.f603k = KeyEvent.normalizeMetaState(i11);
        this.f606n.M(false);
        return this;
    }

    public void setShowAsAction(int i10) {
        int i11 = i10 & 3;
        if (i11 == 0 || i11 == 1 || i11 == 2) {
            this.f618z = i10;
            this.f606n.K(this);
            return;
        }
        throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }

    public MenuItem setTitle(int i10) {
        return setTitle((CharSequence) this.f606n.w().getString(i10));
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f597e = charSequence;
        this.f606n.M(false);
        m mVar = this.f607o;
        if (mVar != null) {
            mVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f598f = charSequence;
        this.f606n.M(false);
        return this;
    }

    public q0.b setTooltipText(CharSequence charSequence) {
        this.f611s = charSequence;
        this.f606n.M(false);
        return this;
    }

    public MenuItem setVisible(boolean z10) {
        if (y(z10)) {
            this.f606n.L(this);
        }
        return this;
    }

    public void t(boolean z10) {
        this.f617y = (z10 ? 4 : 0) | (this.f617y & -5);
    }

    public String toString() {
        CharSequence charSequence = this.f597e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void u(boolean z10) {
        this.f617y = z10 ? this.f617y | 32 : this.f617y & -33;
    }

    /* access modifiers changed from: package-private */
    public void v(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.E = contextMenuInfo;
    }

    /* renamed from: w */
    public q0.b setShowAsActionFlags(int i10) {
        setShowAsAction(i10);
        return this;
    }

    public void x(m mVar) {
        this.f607o = mVar;
        mVar.setHeaderTitle(getTitle());
    }

    /* access modifiers changed from: package-private */
    public boolean y(boolean z10) {
        int i10 = this.f617y;
        int i11 = (z10 ? 0 : 8) | (i10 & -9);
        this.f617y = i11;
        return i10 != i11;
    }

    public boolean z() {
        return this.f606n.C();
    }
}
