package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import j.g;
import java.util.ArrayList;

public class c implements j, AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    Context f545a;

    /* renamed from: b  reason: collision with root package name */
    LayoutInflater f546b;

    /* renamed from: c  reason: collision with root package name */
    e f547c;

    /* renamed from: d  reason: collision with root package name */
    ExpandedMenuView f548d;

    /* renamed from: e  reason: collision with root package name */
    int f549e;

    /* renamed from: f  reason: collision with root package name */
    int f550f;

    /* renamed from: g  reason: collision with root package name */
    int f551g;

    /* renamed from: h  reason: collision with root package name */
    private j.a f552h;

    /* renamed from: i  reason: collision with root package name */
    a f553i;

    /* renamed from: j  reason: collision with root package name */
    private int f554j;

    private class a extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        private int f555a = -1;

        public a() {
            a();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            g x10 = c.this.f547c.x();
            if (x10 != null) {
                ArrayList<g> B = c.this.f547c.B();
                int size = B.size();
                for (int i10 = 0; i10 < size; i10++) {
                    if (B.get(i10) == x10) {
                        this.f555a = i10;
                        return;
                    }
                }
            }
            this.f555a = -1;
        }

        /* renamed from: b */
        public g getItem(int i10) {
            ArrayList<g> B = c.this.f547c.B();
            int i11 = i10 + c.this.f549e;
            int i12 = this.f555a;
            if (i12 >= 0 && i11 >= i12) {
                i11++;
            }
            return B.get(i11);
        }

        public int getCount() {
            int size = c.this.f547c.B().size() - c.this.f549e;
            return this.f555a < 0 ? size : size - 1;
        }

        public long getItemId(int i10) {
            return (long) i10;
        }

        public View getView(int i10, View view, ViewGroup viewGroup) {
            if (view == null) {
                c cVar = c.this;
                view = cVar.f546b.inflate(cVar.f551g, viewGroup, false);
            }
            ((k.a) view).g(getItem(i10), 0);
            return view;
        }

        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public c(int i10, int i11) {
        this.f551g = i10;
        this.f550f = i11;
    }

    public c(Context context, int i10) {
        this(i10, 0);
        this.f545a = context;
        this.f546b = LayoutInflater.from(context);
    }

    public int a() {
        return this.f554j;
    }

    public ListAdapter b() {
        if (this.f553i == null) {
            this.f553i = new a();
        }
        return this.f553i;
    }

    public void c(e eVar, boolean z10) {
        j.a aVar = this.f552h;
        if (aVar != null) {
            aVar.c(eVar, z10);
        }
    }

    public k d(ViewGroup viewGroup) {
        if (this.f548d == null) {
            this.f548d = (ExpandedMenuView) this.f546b.inflate(g.abc_expanded_menu_layout, viewGroup, false);
            if (this.f553i == null) {
                this.f553i = new a();
            }
            this.f548d.setAdapter(this.f553i);
            this.f548d.setOnItemClickListener(this);
        }
        return this.f548d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(android.content.Context r3, androidx.appcompat.view.menu.e r4) {
        /*
            r2 = this;
            int r0 = r2.f550f
            if (r0 == 0) goto L_0x0014
            android.view.ContextThemeWrapper r0 = new android.view.ContextThemeWrapper
            int r1 = r2.f550f
            r0.<init>(r3, r1)
            r2.f545a = r0
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r0)
        L_0x0011:
            r2.f546b = r3
            goto L_0x0023
        L_0x0014:
            android.content.Context r0 = r2.f545a
            if (r0 == 0) goto L_0x0023
            r2.f545a = r3
            android.view.LayoutInflater r0 = r2.f546b
            if (r0 != 0) goto L_0x0023
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r3)
            goto L_0x0011
        L_0x0023:
            r2.f547c = r4
            androidx.appcompat.view.menu.c$a r3 = r2.f553i
            if (r3 == 0) goto L_0x002c
            r3.notifyDataSetChanged()
        L_0x002c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.c.e(android.content.Context, androidx.appcompat.view.menu.e):void");
    }

    public void f(Parcelable parcelable) {
        h((Bundle) parcelable);
    }

    public boolean g(m mVar) {
        if (!mVar.hasVisibleItems()) {
            return false;
        }
        new f(mVar).b((IBinder) null);
        j.a aVar = this.f552h;
        if (aVar == null) {
            return true;
        }
        aVar.d(mVar);
        return true;
    }

    public void h(Bundle bundle) {
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f548d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    public void i(boolean z10) {
        a aVar = this.f553i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public boolean j() {
        return false;
    }

    public Parcelable k() {
        if (this.f548d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        o(bundle);
        return bundle;
    }

    public boolean l(e eVar, g gVar) {
        return false;
    }

    public boolean m(e eVar, g gVar) {
        return false;
    }

    public void n(j.a aVar) {
        this.f552h = aVar;
    }

    public void o(Bundle bundle) {
        SparseArray sparseArray = new SparseArray();
        ExpandedMenuView expandedMenuView = this.f548d;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        this.f547c.O(this.f553i.getItem(i10), this, 0);
    }
}
