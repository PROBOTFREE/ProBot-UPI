package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

public final class b implements q {

    /* renamed from: a  reason: collision with root package name */
    private final RecyclerView.h f3473a;

    public b(RecyclerView.h hVar) {
        this.f3473a = hVar;
    }

    public void a(int i10, int i11) {
        this.f3473a.notifyItemRangeRemoved(i10, i11);
    }

    public void b(int i10, int i11) {
        this.f3473a.notifyItemMoved(i10, i11);
    }

    public void c(int i10, int i11) {
        this.f3473a.notifyItemRangeInserted(i10, i11);
    }

    public void d(int i10, int i11, Object obj) {
        this.f3473a.notifyItemRangeChanged(i10, i11, obj);
    }
}
