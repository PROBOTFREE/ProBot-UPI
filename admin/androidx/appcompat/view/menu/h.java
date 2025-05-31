package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import p.e;

abstract class h implements e, j, AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Rect f620a;

    h() {
    }

    protected static boolean A(e eVar) {
        int size = eVar.size();
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = eVar.getItem(i10);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    protected static d B(ListAdapter listAdapter) {
        return listAdapter instanceof HeaderViewListAdapter ? (d) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter() : (d) listAdapter;
    }

    protected static int r(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i10) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i11 = 0;
        int i12 = 0;
        View view = null;
        for (int i13 = 0; i13 < count; i13++) {
            int itemViewType = listAdapter.getItemViewType(i13);
            if (itemViewType != i12) {
                view = null;
                i12 = itemViewType;
            }
            if (viewGroup == null) {
                viewGroup = new FrameLayout(context);
            }
            view = listAdapter.getView(i13, view, viewGroup);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i10) {
                return i10;
            }
            if (measuredWidth > i11) {
                i11 = measuredWidth;
            }
        }
        return i11;
    }

    public int a() {
        return 0;
    }

    public void e(Context context, e eVar) {
    }

    public boolean l(e eVar, g gVar) {
        return false;
    }

    public boolean m(e eVar, g gVar) {
        return false;
    }

    public abstract void o(e eVar);

    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        B(listAdapter).f557a.O((MenuItem) listAdapter.getItem(i10), this, p() ? 0 : 4);
    }

    /* access modifiers changed from: protected */
    public boolean p() {
        return true;
    }

    public Rect q() {
        return this.f620a;
    }

    public abstract void s(View view);

    public void t(Rect rect) {
        this.f620a = rect;
    }

    public abstract void u(boolean z10);

    public abstract void v(int i10);

    public abstract void w(int i10);

    public abstract void x(PopupWindow.OnDismissListener onDismissListener);

    public abstract void y(boolean z10);

    public abstract void z(int i10);
}
