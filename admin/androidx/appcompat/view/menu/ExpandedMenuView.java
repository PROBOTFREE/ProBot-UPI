package androidx.appcompat.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.g0;

public final class ExpandedMenuView extends ListView implements e.b, k, AdapterView.OnItemClickListener {

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f481c = {16842964, 16843049};

    /* renamed from: a  reason: collision with root package name */
    private e f482a;

    /* renamed from: b  reason: collision with root package name */
    private int f483b;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        g0 v10 = g0.v(context, attributeSet, f481c, i10, 0);
        if (v10.s(0)) {
            setBackgroundDrawable(v10.g(0));
        }
        if (v10.s(1)) {
            setDivider(v10.g(1));
        }
        v10.w();
    }

    public boolean a(g gVar) {
        return this.f482a.N(gVar, 0);
    }

    public void b(e eVar) {
        this.f482a = eVar;
    }

    public int getWindowAnimations() {
        return this.f483b;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
        a((g) getAdapter().getItem(i10));
    }
}
