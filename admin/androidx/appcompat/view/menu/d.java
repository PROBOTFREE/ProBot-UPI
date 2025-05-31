package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.k;
import java.util.ArrayList;

public class d extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    e f557a;

    /* renamed from: b  reason: collision with root package name */
    private int f558b = -1;

    /* renamed from: c  reason: collision with root package name */
    private boolean f559c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f560d;

    /* renamed from: e  reason: collision with root package name */
    private final LayoutInflater f561e;

    /* renamed from: f  reason: collision with root package name */
    private final int f562f;

    public d(e eVar, LayoutInflater layoutInflater, boolean z10, int i10) {
        this.f560d = z10;
        this.f561e = layoutInflater;
        this.f557a = eVar;
        this.f562f = i10;
        a();
    }

    /* access modifiers changed from: package-private */
    public void a() {
        g x10 = this.f557a.x();
        if (x10 != null) {
            ArrayList<g> B = this.f557a.B();
            int size = B.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (B.get(i10) == x10) {
                    this.f558b = i10;
                    return;
                }
            }
        }
        this.f558b = -1;
    }

    public e b() {
        return this.f557a;
    }

    /* renamed from: c */
    public g getItem(int i10) {
        ArrayList<g> B = this.f560d ? this.f557a.B() : this.f557a.G();
        int i11 = this.f558b;
        if (i11 >= 0 && i10 >= i11) {
            i10++;
        }
        return B.get(i10);
    }

    public void d(boolean z10) {
        this.f559c = z10;
    }

    public int getCount() {
        ArrayList<g> B = this.f560d ? this.f557a.B() : this.f557a.G();
        int i10 = this.f558b;
        int size = B.size();
        return i10 < 0 ? size : size - 1;
    }

    public long getItemId(int i10) {
        return (long) i10;
    }

    public View getView(int i10, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f561e.inflate(this.f562f, viewGroup, false);
        }
        int groupId = getItem(i10).getGroupId();
        int i11 = i10 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f557a.H() && groupId != (i11 >= 0 ? getItem(i11).getGroupId() : groupId));
        k.a aVar = (k.a) view;
        if (this.f559c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.g(getItem(i10), 0);
        return view;
    }

    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
