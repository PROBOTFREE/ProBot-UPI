package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class e implements q0.a {
    private static final int[] A = {1, 4, 5, 3, 2, 0};

    /* renamed from: a  reason: collision with root package name */
    private final Context f563a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f564b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f565c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f566d;

    /* renamed from: e  reason: collision with root package name */
    private a f567e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<g> f568f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<g> f569g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f570h;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<g> f571i;

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<g> f572j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f573k;

    /* renamed from: l  reason: collision with root package name */
    private int f574l = 0;

    /* renamed from: m  reason: collision with root package name */
    private ContextMenu.ContextMenuInfo f575m;

    /* renamed from: n  reason: collision with root package name */
    CharSequence f576n;

    /* renamed from: o  reason: collision with root package name */
    Drawable f577o;

    /* renamed from: p  reason: collision with root package name */
    View f578p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f579q = false;

    /* renamed from: r  reason: collision with root package name */
    private boolean f580r = false;

    /* renamed from: s  reason: collision with root package name */
    private boolean f581s = false;

    /* renamed from: t  reason: collision with root package name */
    private boolean f582t = false;

    /* renamed from: u  reason: collision with root package name */
    private boolean f583u = false;

    /* renamed from: v  reason: collision with root package name */
    private ArrayList<g> f584v = new ArrayList<>();

    /* renamed from: w  reason: collision with root package name */
    private CopyOnWriteArrayList<WeakReference<j>> f585w = new CopyOnWriteArrayList<>();

    /* renamed from: x  reason: collision with root package name */
    private g f586x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f587y = false;

    /* renamed from: z  reason: collision with root package name */
    private boolean f588z;

    public interface a {
        boolean a(e eVar, MenuItem menuItem);

        void b(e eVar);
    }

    public interface b {
        boolean a(g gVar);
    }

    public e(Context context) {
        this.f563a = context;
        this.f564b = context.getResources();
        this.f568f = new ArrayList<>();
        this.f569g = new ArrayList<>();
        this.f570h = true;
        this.f571i = new ArrayList<>();
        this.f572j = new ArrayList<>();
        this.f573k = true;
        f0(true);
    }

    private static int D(int i10) {
        int i11 = (-65536 & i10) >> 16;
        if (i11 >= 0) {
            int[] iArr = A;
            if (i11 < iArr.length) {
                return (i10 & 65535) | (iArr[i11] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void P(int i10, boolean z10) {
        if (i10 >= 0 && i10 < this.f568f.size()) {
            this.f568f.remove(i10);
            if (z10) {
                M(true);
            }
        }
    }

    private void a0(int i10, CharSequence charSequence, int i11, Drawable drawable, View view) {
        Resources E = E();
        if (view != null) {
            this.f578p = view;
            this.f576n = null;
            this.f577o = null;
        } else {
            if (i10 > 0) {
                this.f576n = E.getText(i10);
            } else if (charSequence != null) {
                this.f576n = charSequence;
            }
            if (i11 > 0) {
                this.f577o = androidx.core.content.a.f(w(), i11);
            } else if (drawable != null) {
                this.f577o = drawable;
            }
            this.f578p = null;
        }
        M(false);
    }

    private void f0(boolean z10) {
        boolean z11 = true;
        if (!z10 || this.f564b.getConfiguration().keyboard == 1 || !y.e(ViewConfiguration.get(this.f563a), this.f563a)) {
            z11 = false;
        }
        this.f566d = z11;
    }

    private g g(int i10, int i11, int i12, int i13, CharSequence charSequence, int i14) {
        return new g(this, i10, i11, i12, i13, charSequence, i14);
    }

    private void i(boolean z10) {
        if (!this.f585w.isEmpty()) {
            h0();
            Iterator<WeakReference<j>> it = this.f585w.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                j jVar = (j) next.get();
                if (jVar == null) {
                    this.f585w.remove(next);
                } else {
                    jVar.i(z10);
                }
            }
            g0();
        }
    }

    private void j(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray != null && !this.f585w.isEmpty()) {
            Iterator<WeakReference<j>> it = this.f585w.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                j jVar = (j) next.get();
                if (jVar == null) {
                    this.f585w.remove(next);
                } else {
                    int a10 = jVar.a();
                    if (a10 > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(a10)) != null) {
                        jVar.f(parcelable);
                    }
                }
            }
        }
    }

    private void k(Bundle bundle) {
        Parcelable k10;
        if (!this.f585w.isEmpty()) {
            SparseArray sparseArray = new SparseArray();
            Iterator<WeakReference<j>> it = this.f585w.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                j jVar = (j) next.get();
                if (jVar == null) {
                    this.f585w.remove(next);
                } else {
                    int a10 = jVar.a();
                    if (a10 > 0 && (k10 = jVar.k()) != null) {
                        sparseArray.put(a10, k10);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
        }
    }

    private boolean l(m mVar, j jVar) {
        boolean z10 = false;
        if (this.f585w.isEmpty()) {
            return false;
        }
        if (jVar != null) {
            z10 = jVar.g(mVar);
        }
        Iterator<WeakReference<j>> it = this.f585w.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            j jVar2 = (j) next.get();
            if (jVar2 == null) {
                this.f585w.remove(next);
            } else if (!z10) {
                z10 = jVar2.g(mVar);
            }
        }
        return z10;
    }

    private static int p(ArrayList<g> arrayList, int i10) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).f() <= i10) {
                return size + 1;
            }
        }
        return 0;
    }

    public View A() {
        return this.f578p;
    }

    public ArrayList<g> B() {
        t();
        return this.f572j;
    }

    /* access modifiers changed from: package-private */
    public boolean C() {
        return this.f582t;
    }

    /* access modifiers changed from: package-private */
    public Resources E() {
        return this.f564b;
    }

    public e F() {
        return this;
    }

    public ArrayList<g> G() {
        if (!this.f570h) {
            return this.f569g;
        }
        this.f569g.clear();
        int size = this.f568f.size();
        for (int i10 = 0; i10 < size; i10++) {
            g gVar = this.f568f.get(i10);
            if (gVar.isVisible()) {
                this.f569g.add(gVar);
            }
        }
        this.f570h = false;
        this.f573k = true;
        return this.f569g;
    }

    public boolean H() {
        return this.f587y;
    }

    /* access modifiers changed from: package-private */
    public boolean I() {
        return this.f565c;
    }

    public boolean J() {
        return this.f566d;
    }

    /* access modifiers changed from: package-private */
    public void K(g gVar) {
        this.f573k = true;
        M(true);
    }

    /* access modifiers changed from: package-private */
    public void L(g gVar) {
        this.f570h = true;
        M(true);
    }

    public void M(boolean z10) {
        if (!this.f579q) {
            if (z10) {
                this.f570h = true;
                this.f573k = true;
            }
            i(z10);
            return;
        }
        this.f580r = true;
        if (z10) {
            this.f581s = true;
        }
    }

    public boolean N(MenuItem menuItem, int i10) {
        return O(menuItem, (j) null, i10);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        if (r1 != false) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003c, code lost:
        if ((r9 & 1) == 0) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0068, code lost:
        if (r1 == false) goto L_0x002d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean O(android.view.MenuItem r7, androidx.appcompat.view.menu.j r8, int r9) {
        /*
            r6 = this;
            androidx.appcompat.view.menu.g r7 = (androidx.appcompat.view.menu.g) r7
            r0 = 0
            if (r7 == 0) goto L_0x006c
            boolean r1 = r7.isEnabled()
            if (r1 != 0) goto L_0x000c
            goto L_0x006c
        L_0x000c:
            boolean r1 = r7.k()
            androidx.core.view.b r2 = r7.b()
            r3 = 1
            if (r2 == 0) goto L_0x001f
            boolean r4 = r2.a()
            if (r4 == 0) goto L_0x001f
            r4 = r3
            goto L_0x0020
        L_0x001f:
            r4 = r0
        L_0x0020:
            boolean r5 = r7.j()
            if (r5 == 0) goto L_0x0031
            boolean r7 = r7.expandActionView()
            r1 = r1 | r7
            if (r1 == 0) goto L_0x006b
        L_0x002d:
            r6.e(r3)
            goto L_0x006b
        L_0x0031:
            boolean r5 = r7.hasSubMenu()
            if (r5 != 0) goto L_0x003f
            if (r4 == 0) goto L_0x003a
            goto L_0x003f
        L_0x003a:
            r7 = r9 & 1
            if (r7 != 0) goto L_0x006b
            goto L_0x002d
        L_0x003f:
            r9 = r9 & 4
            if (r9 != 0) goto L_0x0046
            r6.e(r0)
        L_0x0046:
            boolean r9 = r7.hasSubMenu()
            if (r9 != 0) goto L_0x0058
            androidx.appcompat.view.menu.m r9 = new androidx.appcompat.view.menu.m
            android.content.Context r0 = r6.w()
            r9.<init>(r0, r6, r7)
            r7.x(r9)
        L_0x0058:
            android.view.SubMenu r7 = r7.getSubMenu()
            androidx.appcompat.view.menu.m r7 = (androidx.appcompat.view.menu.m) r7
            if (r4 == 0) goto L_0x0063
            r2.f(r7)
        L_0x0063:
            boolean r7 = r6.l(r7, r8)
            r1 = r1 | r7
            if (r1 != 0) goto L_0x006b
            goto L_0x002d
        L_0x006b:
            return r1
        L_0x006c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.e.O(android.view.MenuItem, androidx.appcompat.view.menu.j, int):boolean");
    }

    public void Q(j jVar) {
        Iterator<WeakReference<j>> it = this.f585w.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            j jVar2 = (j) next.get();
            if (jVar2 == null || jVar2 == jVar) {
                this.f585w.remove(next);
            }
        }
    }

    public void R(Bundle bundle) {
        MenuItem findItem;
        if (bundle != null) {
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(v());
            int size = size();
            for (int i10 = 0; i10 < size; i10++) {
                MenuItem item = getItem(i10);
                View actionView = item.getActionView();
                if (!(actionView == null || actionView.getId() == -1)) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((m) item.getSubMenu()).R(bundle);
                }
            }
            int i11 = bundle.getInt("android:menu:expandedactionview");
            if (i11 > 0 && (findItem = findItem(i11)) != null) {
                findItem.expandActionView();
            }
        }
    }

    public void S(Bundle bundle) {
        j(bundle);
    }

    public void T(Bundle bundle) {
        int size = size();
        SparseArray sparseArray = null;
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = getItem(i10);
            View actionView = item.getActionView();
            if (!(actionView == null || actionView.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((m) item.getSubMenu()).T(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(v(), sparseArray);
        }
    }

    public void U(Bundle bundle) {
        k(bundle);
    }

    public void V(a aVar) {
        this.f567e = aVar;
    }

    public e W(int i10) {
        this.f574l = i10;
        return this;
    }

    /* access modifiers changed from: package-private */
    public void X(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f568f.size();
        h0();
        for (int i10 = 0; i10 < size; i10++) {
            g gVar = this.f568f.get(i10);
            if (gVar.getGroupId() == groupId && gVar.m() && gVar.isCheckable()) {
                gVar.s(gVar == menuItem);
            }
        }
        g0();
    }

    /* access modifiers changed from: protected */
    public e Y(int i10) {
        a0(0, (CharSequence) null, i10, (Drawable) null, (View) null);
        return this;
    }

    /* access modifiers changed from: protected */
    public e Z(Drawable drawable) {
        a0(0, (CharSequence) null, 0, drawable, (View) null);
        return this;
    }

    /* access modifiers changed from: protected */
    public MenuItem a(int i10, int i11, int i12, CharSequence charSequence) {
        int D = D(i12);
        g g10 = g(i10, i11, i12, D, charSequence, this.f574l);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.f575m;
        if (contextMenuInfo != null) {
            g10.v(contextMenuInfo);
        }
        ArrayList<g> arrayList = this.f568f;
        arrayList.add(p(arrayList, D), g10);
        M(true);
        return g10;
    }

    public MenuItem add(int i10) {
        return a(0, 0, 0, this.f564b.getString(i10));
    }

    public MenuItem add(int i10, int i11, int i12, int i13) {
        return a(i10, i11, i12, this.f564b.getString(i13));
    }

    public MenuItem add(int i10, int i11, int i12, CharSequence charSequence) {
        return a(i10, i11, i12, charSequence);
    }

    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    public int addIntentOptions(int i10, int i11, int i12, ComponentName componentName, Intent[] intentArr, Intent intent, int i13, MenuItem[] menuItemArr) {
        int i14;
        PackageManager packageManager = this.f563a.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i13 & 1) == 0) {
            removeGroup(i10);
        }
        for (int i15 = 0; i15 < size; i15++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i15);
            int i16 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i16 < 0 ? intent : intentArr[i16]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i10, i11, i12, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i14 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i14] = intent3;
            }
        }
        return size;
    }

    public SubMenu addSubMenu(int i10) {
        return addSubMenu(0, 0, 0, (CharSequence) this.f564b.getString(i10));
    }

    public SubMenu addSubMenu(int i10, int i11, int i12, int i13) {
        return addSubMenu(i10, i11, i12, (CharSequence) this.f564b.getString(i13));
    }

    public SubMenu addSubMenu(int i10, int i11, int i12, CharSequence charSequence) {
        g gVar = (g) a(i10, i11, i12, charSequence);
        m mVar = new m(this.f563a, this, gVar);
        gVar.x(mVar);
        return mVar;
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void b(j jVar) {
        c(jVar, this.f563a);
    }

    /* access modifiers changed from: protected */
    public e b0(int i10) {
        a0(i10, (CharSequence) null, 0, (Drawable) null, (View) null);
        return this;
    }

    public void c(j jVar, Context context) {
        this.f585w.add(new WeakReference(jVar));
        jVar.e(context, this);
        this.f573k = true;
    }

    /* access modifiers changed from: protected */
    public e c0(CharSequence charSequence) {
        a0(0, charSequence, 0, (Drawable) null, (View) null);
        return this;
    }

    public void clear() {
        g gVar = this.f586x;
        if (gVar != null) {
            f(gVar);
        }
        this.f568f.clear();
        M(true);
    }

    public void clearHeader() {
        this.f577o = null;
        this.f576n = null;
        this.f578p = null;
        M(false);
    }

    public void close() {
        e(true);
    }

    public void d() {
        a aVar = this.f567e;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    /* access modifiers changed from: protected */
    public e d0(View view) {
        a0(0, (CharSequence) null, 0, (Drawable) null, view);
        return this;
    }

    public final void e(boolean z10) {
        if (!this.f583u) {
            this.f583u = true;
            Iterator<WeakReference<j>> it = this.f585w.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                j jVar = (j) next.get();
                if (jVar == null) {
                    this.f585w.remove(next);
                } else {
                    jVar.c(this, z10);
                }
            }
            this.f583u = false;
        }
    }

    public void e0(boolean z10) {
        this.f588z = z10;
    }

    public boolean f(g gVar) {
        boolean z10 = false;
        if (!this.f585w.isEmpty() && this.f586x == gVar) {
            h0();
            Iterator<WeakReference<j>> it = this.f585w.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                j jVar = (j) next.get();
                if (jVar == null) {
                    this.f585w.remove(next);
                } else {
                    z10 = jVar.l(this, gVar);
                    if (z10) {
                        break;
                    }
                }
            }
            g0();
            if (z10) {
                this.f586x = null;
            }
        }
        return z10;
    }

    public MenuItem findItem(int i10) {
        MenuItem findItem;
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            g gVar = this.f568f.get(i11);
            if (gVar.getItemId() == i10) {
                return gVar;
            }
            if (gVar.hasSubMenu() && (findItem = gVar.getSubMenu().findItem(i10)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public void g0() {
        this.f579q = false;
        if (this.f580r) {
            this.f580r = false;
            M(this.f581s);
        }
    }

    public MenuItem getItem(int i10) {
        return this.f568f.get(i10);
    }

    /* access modifiers changed from: package-private */
    public boolean h(e eVar, MenuItem menuItem) {
        a aVar = this.f567e;
        return aVar != null && aVar.a(eVar, menuItem);
    }

    public void h0() {
        if (!this.f579q) {
            this.f579q = true;
            this.f580r = false;
            this.f581s = false;
        }
    }

    public boolean hasVisibleItems() {
        if (this.f588z) {
            return true;
        }
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f568f.get(i10).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public boolean isShortcutKey(int i10, KeyEvent keyEvent) {
        return r(i10, keyEvent) != null;
    }

    public boolean m(g gVar) {
        boolean z10 = false;
        if (this.f585w.isEmpty()) {
            return false;
        }
        h0();
        Iterator<WeakReference<j>> it = this.f585w.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            j jVar = (j) next.get();
            if (jVar == null) {
                this.f585w.remove(next);
            } else {
                z10 = jVar.m(this, gVar);
                if (z10) {
                    break;
                }
            }
        }
        g0();
        if (z10) {
            this.f586x = gVar;
        }
        return z10;
    }

    public int n(int i10) {
        return o(i10, 0);
    }

    public int o(int i10, int i11) {
        int size = size();
        if (i11 < 0) {
            i11 = 0;
        }
        while (i11 < size) {
            if (this.f568f.get(i11).getGroupId() == i10) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public boolean performIdentifierAction(int i10, int i11) {
        return N(findItem(i10), i11);
    }

    public boolean performShortcut(int i10, KeyEvent keyEvent, int i11) {
        g r10 = r(i10, keyEvent);
        boolean N = r10 != null ? N(r10, i11) : false;
        if ((i11 & 2) != 0) {
            e(true);
        }
        return N;
    }

    public int q(int i10) {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            if (this.f568f.get(i11).getItemId() == i10) {
                return i11;
            }
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public g r(int i10, KeyEvent keyEvent) {
        ArrayList<g> arrayList = this.f584v;
        arrayList.clear();
        s(arrayList, i10, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean I = I();
        for (int i11 = 0; i11 < size; i11++) {
            g gVar = arrayList.get(i11);
            char alphabeticShortcut = I ? gVar.getAlphabeticShortcut() : gVar.getNumericShortcut();
            char[] cArr = keyData.meta;
            if ((alphabeticShortcut == cArr[0] && (metaState & 2) == 0) || ((alphabeticShortcut == cArr[2] && (metaState & 2) != 0) || (I && alphabeticShortcut == 8 && i10 == 67))) {
                return gVar;
            }
        }
        return null;
    }

    public void removeGroup(int i10) {
        int n10 = n(i10);
        if (n10 >= 0) {
            int size = this.f568f.size() - n10;
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                if (i11 >= size || this.f568f.get(n10).getGroupId() != i10) {
                    M(true);
                } else {
                    P(n10, false);
                    i11 = i12;
                }
            }
            M(true);
        }
    }

    public void removeItem(int i10) {
        P(q(i10), true);
    }

    /* access modifiers changed from: package-private */
    public void s(List<g> list, int i10, KeyEvent keyEvent) {
        boolean I = I();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i10 == 67) {
            int size = this.f568f.size();
            for (int i11 = 0; i11 < size; i11++) {
                g gVar = this.f568f.get(i11);
                if (gVar.hasSubMenu()) {
                    ((e) gVar.getSubMenu()).s(list, i10, keyEvent);
                }
                char alphabeticShortcut = I ? gVar.getAlphabeticShortcut() : gVar.getNumericShortcut();
                if (((modifiers & 69647) == ((I ? gVar.getAlphabeticModifiers() : gVar.getNumericModifiers()) & 69647)) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (I && alphabeticShortcut == 8 && i10 == 67)) && gVar.isEnabled()) {
                        list.add(gVar);
                    }
                }
            }
        }
    }

    public void setGroupCheckable(int i10, boolean z10, boolean z11) {
        int size = this.f568f.size();
        for (int i11 = 0; i11 < size; i11++) {
            g gVar = this.f568f.get(i11);
            if (gVar.getGroupId() == i10) {
                gVar.t(z11);
                gVar.setCheckable(z10);
            }
        }
    }

    public void setGroupDividerEnabled(boolean z10) {
        this.f587y = z10;
    }

    public void setGroupEnabled(int i10, boolean z10) {
        int size = this.f568f.size();
        for (int i11 = 0; i11 < size; i11++) {
            g gVar = this.f568f.get(i11);
            if (gVar.getGroupId() == i10) {
                gVar.setEnabled(z10);
            }
        }
    }

    public void setGroupVisible(int i10, boolean z10) {
        int size = this.f568f.size();
        boolean z11 = false;
        for (int i11 = 0; i11 < size; i11++) {
            g gVar = this.f568f.get(i11);
            if (gVar.getGroupId() == i10 && gVar.y(z10)) {
                z11 = true;
            }
        }
        if (z11) {
            M(true);
        }
    }

    public void setQwertyMode(boolean z10) {
        this.f565c = z10;
        M(false);
    }

    public int size() {
        return this.f568f.size();
    }

    public void t() {
        ArrayList<g> G = G();
        if (this.f573k) {
            Iterator<WeakReference<j>> it = this.f585w.iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                WeakReference next = it.next();
                j jVar = (j) next.get();
                if (jVar == null) {
                    this.f585w.remove(next);
                } else {
                    z10 |= jVar.j();
                }
            }
            if (z10) {
                this.f571i.clear();
                this.f572j.clear();
                int size = G.size();
                for (int i10 = 0; i10 < size; i10++) {
                    g gVar = G.get(i10);
                    (gVar.l() ? this.f571i : this.f572j).add(gVar);
                }
            } else {
                this.f571i.clear();
                this.f572j.clear();
                this.f572j.addAll(G());
            }
            this.f573k = false;
        }
    }

    public ArrayList<g> u() {
        t();
        return this.f571i;
    }

    /* access modifiers changed from: protected */
    public String v() {
        return "android:menu:actionviewstates";
    }

    public Context w() {
        return this.f563a;
    }

    public g x() {
        return this.f586x;
    }

    public Drawable y() {
        return this.f577o;
    }

    public CharSequence z() {
        return this.f576n;
    }
}
