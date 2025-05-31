package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.c;
import h0.e;
import h0.f;
import h0.i;
import h0.j;
import java.util.Arrays;
import java.util.HashMap;

public abstract class ConstraintHelper extends View {

    /* renamed from: a  reason: collision with root package name */
    protected int[] f1862a = new int[32];

    /* renamed from: b  reason: collision with root package name */
    protected int f1863b;

    /* renamed from: c  reason: collision with root package name */
    protected Context f1864c;

    /* renamed from: d  reason: collision with root package name */
    protected i f1865d;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f1866e = false;

    /* renamed from: f  reason: collision with root package name */
    protected String f1867f;

    /* renamed from: g  reason: collision with root package name */
    protected String f1868g;

    /* renamed from: h  reason: collision with root package name */
    private View[] f1869h = null;

    /* renamed from: i  reason: collision with root package name */
    protected HashMap<Integer, String> f1870i = new HashMap<>();

    public ConstraintHelper(Context context) {
        super(context);
        this.f1864c = context;
        o((AttributeSet) null);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1864c = context;
        o(attributeSet);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f1864c = context;
        o(attributeSet);
    }

    private void e(String str) {
        if (str != null && str.length() != 0 && this.f1864c != null) {
            String trim = str.trim();
            if (getParent() instanceof ConstraintLayout) {
                ConstraintLayout constraintLayout = (ConstraintLayout) getParent();
            }
            int m10 = m(trim);
            if (m10 != 0) {
                this.f1870i.put(Integer.valueOf(m10), trim);
                f(m10);
                return;
            }
            Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
        }
    }

    private void f(int i10) {
        if (i10 != getId()) {
            int i11 = this.f1863b + 1;
            int[] iArr = this.f1862a;
            if (i11 > iArr.length) {
                this.f1862a = Arrays.copyOf(iArr, iArr.length * 2);
            }
            int[] iArr2 = this.f1862a;
            int i12 = this.f1863b;
            iArr2[i12] = i10;
            this.f1863b = i12 + 1;
        }
    }

    private void g(String str) {
        if (str != null && str.length() != 0 && this.f1864c != null) {
            String trim = str.trim();
            ConstraintLayout constraintLayout = null;
            if (getParent() instanceof ConstraintLayout) {
                constraintLayout = (ConstraintLayout) getParent();
            }
            if (constraintLayout == null) {
                Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
                return;
            }
            int childCount = constraintLayout.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = constraintLayout.getChildAt(i10);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if ((layoutParams instanceof ConstraintLayout.LayoutParams) && trim.equals(((ConstraintLayout.LayoutParams) layoutParams).Y)) {
                    if (childAt.getId() == -1) {
                        Log.w("ConstraintHelper", "to use ConstraintTag view " + childAt.getClass().getSimpleName() + " must have an ID");
                    } else {
                        f(childAt.getId());
                    }
                }
            }
        }
    }

    private int[] k(View view, String str) {
        String[] split = str.split(",");
        view.getContext();
        int[] iArr = new int[split.length];
        int i10 = 0;
        for (String trim : split) {
            int m10 = m(trim.trim());
            if (m10 != 0) {
                iArr[i10] = m10;
                i10++;
            }
        }
        return i10 != split.length ? Arrays.copyOf(iArr, i10) : iArr;
    }

    private int l(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        if (str == null || constraintLayout == null || (resources = this.f1864c.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            if (childAt.getId() != -1) {
                String str2 = null;
                try {
                    str2 = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                }
                if (str.equals(str2)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    private int m(String str) {
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int i10 = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object h10 = constraintLayout.h(0, str);
            if (h10 instanceof Integer) {
                i10 = ((Integer) h10).intValue();
            }
        }
        if (i10 == 0 && constraintLayout != null) {
            i10 = l(constraintLayout, str);
        }
        if (i10 == 0) {
            try {
                i10 = e.class.getField(str).getInt((Object) null);
            } catch (Exception unused) {
            }
        }
        return i10 == 0 ? this.f1864c.getResources().getIdentifier(str, "id", this.f1864c.getPackageName()) : i10;
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f1862a, this.f1863b);
    }

    /* access modifiers changed from: protected */
    public void h() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ConstraintLayout)) {
            i((ConstraintLayout) parent);
        }
    }

    /* access modifiers changed from: protected */
    public void i(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = Build.VERSION.SDK_INT >= 21 ? getElevation() : 0.0f;
        for (int i10 = 0; i10 < this.f1863b; i10++) {
            View l10 = constraintLayout.l(this.f1862a[i10]);
            if (l10 != null) {
                l10.setVisibility(visibility);
                if (elevation > 0.0f && Build.VERSION.SDK_INT >= 21) {
                    l10.setTranslationZ(l10.getTranslationZ() + elevation);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void j(ConstraintLayout constraintLayout) {
    }

    /* access modifiers changed from: protected */
    public View[] n(ConstraintLayout constraintLayout) {
        View[] viewArr = this.f1869h;
        if (viewArr == null || viewArr.length != this.f1863b) {
            this.f1869h = new View[this.f1863b];
        }
        for (int i10 = 0; i10 < this.f1863b; i10++) {
            this.f1869h[i10] = constraintLayout.l(this.f1862a[i10]);
        }
        return this.f1869h;
    }

    /* access modifiers changed from: protected */
    public void o(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, f.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == f.ConstraintLayout_Layout_constraint_referenced_ids) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f1867f = string;
                    setIds(string);
                } else if (index == f.ConstraintLayout_Layout_constraint_referenced_tags) {
                    String string2 = obtainStyledAttributes.getString(index);
                    this.f1868g = string2;
                    setReferenceTags(string2);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f1867f;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.f1868g;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    public void onDraw(Canvas canvas) {
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        if (this.f1866e) {
            super.onMeasure(i10, i11);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void p(c.a aVar, j jVar, ConstraintLayout.LayoutParams layoutParams, SparseArray<e> sparseArray) {
        c.b bVar = aVar.f2011e;
        int[] iArr = bVar.f2047j0;
        if (iArr != null) {
            setReferencedIds(iArr);
        } else {
            String str = bVar.f2049k0;
            if (str != null) {
                if (str.length() > 0) {
                    c.b bVar2 = aVar.f2011e;
                    bVar2.f2047j0 = k(this, bVar2.f2049k0);
                } else {
                    aVar.f2011e.f2047j0 = null;
                }
            }
        }
        if (jVar != null) {
            jVar.a();
            if (aVar.f2011e.f2047j0 != null) {
                int i10 = 0;
                while (true) {
                    int[] iArr2 = aVar.f2011e.f2047j0;
                    if (i10 < iArr2.length) {
                        e eVar = sparseArray.get(iArr2[i10]);
                        if (eVar != null) {
                            jVar.b(eVar);
                        }
                        i10++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void q(e eVar, boolean z10) {
    }

    public void r(ConstraintLayout constraintLayout) {
    }

    public void s(ConstraintLayout constraintLayout) {
    }

    /* access modifiers changed from: protected */
    public void setIds(String str) {
        this.f1867f = str;
        if (str != null) {
            int i10 = 0;
            this.f1863b = 0;
            while (true) {
                int indexOf = str.indexOf(44, i10);
                if (indexOf == -1) {
                    e(str.substring(i10));
                    return;
                } else {
                    e(str.substring(i10, indexOf));
                    i10 = indexOf + 1;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setReferenceTags(String str) {
        this.f1868g = str;
        if (str != null) {
            int i10 = 0;
            this.f1863b = 0;
            while (true) {
                int indexOf = str.indexOf(44, i10);
                if (indexOf == -1) {
                    g(str.substring(i10));
                    return;
                } else {
                    g(str.substring(i10, indexOf));
                    i10 = indexOf + 1;
                }
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f1867f = null;
        this.f1863b = 0;
        for (int f10 : iArr) {
            f(f10);
        }
    }

    public void setTag(int i10, Object obj) {
        super.setTag(i10, obj);
        if (obj == null && this.f1867f == null) {
            f(i10);
        }
    }

    public void t(ConstraintLayout constraintLayout) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        r1 = r5.f1870i.get(java.lang.Integer.valueOf(r1));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void u(androidx.constraintlayout.widget.ConstraintLayout r6) {
        /*
            r5 = this;
            boolean r0 = r5.isInEditMode()
            if (r0 == 0) goto L_0x000b
            java.lang.String r0 = r5.f1867f
            r5.setIds(r0)
        L_0x000b:
            h0.i r0 = r5.f1865d
            if (r0 != 0) goto L_0x0010
            return
        L_0x0010:
            r0.a()
            r0 = 0
        L_0x0014:
            int r1 = r5.f1863b
            if (r0 >= r1) goto L_0x0053
            int[] r1 = r5.f1862a
            r1 = r1[r0]
            android.view.View r2 = r6.l(r1)
            if (r2 != 0) goto L_0x0045
            java.util.HashMap<java.lang.Integer, java.lang.String> r3 = r5.f1870i
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Object r1 = r3.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            int r3 = r5.l(r6, r1)
            if (r3 == 0) goto L_0x0045
            int[] r2 = r5.f1862a
            r2[r0] = r3
            java.util.HashMap<java.lang.Integer, java.lang.String> r2 = r5.f1870i
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            r2.put(r4, r1)
            android.view.View r2 = r6.l(r3)
        L_0x0045:
            if (r2 == 0) goto L_0x0050
            h0.i r1 = r5.f1865d
            h0.e r2 = r6.p(r2)
            r1.b(r2)
        L_0x0050:
            int r0 = r0 + 1
            goto L_0x0014
        L_0x0053:
            h0.i r0 = r5.f1865d
            h0.f r6 = r6.f1874c
            r0.c(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintHelper.u(androidx.constraintlayout.widget.ConstraintLayout):void");
    }

    public void v(f fVar, i iVar, SparseArray<e> sparseArray) {
        iVar.a();
        for (int i10 = 0; i10 < this.f1863b; i10++) {
            iVar.b(sparseArray.get(this.f1862a[i10]));
        }
    }

    public void w() {
        if (this.f1865d != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.LayoutParams) {
                ((ConstraintLayout.LayoutParams) layoutParams).f1926r0 = (e) this.f1865d;
            }
        }
    }
}
