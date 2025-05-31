package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.c;
import h0.a;
import h0.e;
import h0.f;
import h0.j;

public class Barrier extends ConstraintHelper {

    /* renamed from: j  reason: collision with root package name */
    private int f1859j;

    /* renamed from: k  reason: collision with root package name */
    private int f1860k;

    /* renamed from: l  reason: collision with root package name */
    private a f1861l;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        super.setVisibility(8);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
        if (r7 == 6) goto L_0x0010;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        if (r7 == 6) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0013, code lost:
        if (r7 == 6) goto L_0x001c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void x(h0.e r6, int r7, boolean r8) {
        /*
            r5 = this;
            r5.f1860k = r7
            int r7 = android.os.Build.VERSION.SDK_INT
            r0 = 1
            r1 = 0
            r2 = 6
            r3 = 5
            r4 = 17
            if (r7 >= r4) goto L_0x0016
            int r7 = r5.f1859j
            if (r7 != r3) goto L_0x0013
        L_0x0010:
            r5.f1860k = r1
            goto L_0x0028
        L_0x0013:
            if (r7 != r2) goto L_0x0028
        L_0x0015:
            goto L_0x001c
        L_0x0016:
            int r7 = r5.f1859j
            if (r8 == 0) goto L_0x0022
            if (r7 != r3) goto L_0x001f
        L_0x001c:
            r5.f1860k = r0
            goto L_0x0028
        L_0x001f:
            if (r7 != r2) goto L_0x0028
            goto L_0x0010
        L_0x0022:
            if (r7 != r3) goto L_0x0025
            goto L_0x0010
        L_0x0025:
            if (r7 != r2) goto L_0x0028
            goto L_0x0015
        L_0x0028:
            boolean r7 = r6 instanceof h0.a
            if (r7 == 0) goto L_0x0033
            h0.a r6 = (h0.a) r6
            int r7 = r5.f1860k
            r6.E1(r7)
        L_0x0033:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.Barrier.x(h0.e, int, boolean):void");
    }

    public boolean getAllowsGoneWidget() {
        return this.f1861l.y1();
    }

    public int getMargin() {
        return this.f1861l.A1();
    }

    public int getType() {
        return this.f1859j;
    }

    /* access modifiers changed from: protected */
    public void o(AttributeSet attributeSet) {
        super.o(attributeSet);
        this.f1861l = new a();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, f.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == f.ConstraintLayout_Layout_barrierDirection) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == f.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.f1861l.D1(obtainStyledAttributes.getBoolean(index, true));
                } else if (index == f.ConstraintLayout_Layout_barrierMargin) {
                    this.f1861l.F1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f1865d = this.f1861l;
        w();
    }

    public void p(c.a aVar, j jVar, ConstraintLayout.LayoutParams layoutParams, SparseArray<e> sparseArray) {
        super.p(aVar, jVar, layoutParams, sparseArray);
        if (jVar instanceof a) {
            a aVar2 = (a) jVar;
            x(aVar2, aVar.f2011e.f2041g0, ((f) jVar.M()).T1());
            aVar2.D1(aVar.f2011e.f2057o0);
            aVar2.F1(aVar.f2011e.f2043h0);
        }
    }

    public void q(e eVar, boolean z10) {
        x(eVar, this.f1859j, z10);
    }

    public void setAllowsGoneWidget(boolean z10) {
        this.f1861l.D1(z10);
    }

    public void setDpMargin(int i10) {
        a aVar = this.f1861l;
        aVar.F1((int) ((((float) i10) * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int i10) {
        this.f1861l.F1(i10);
    }

    public void setType(int i10) {
        this.f1859j = i10;
    }
}
