package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import java.util.ArrayList;
import x1.b;

@SuppressLint({"ViewConstructor"})
class f extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private ViewGroup f4097a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f4098b = true;

    f(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        setClipChildren(false);
        this.f4097a = viewGroup;
        viewGroup.setTag(b.ghost_view_holder, this);
        a0.b(this.f4097a).c(this);
    }

    static f b(ViewGroup viewGroup) {
        return (f) viewGroup.getTag(b.ghost_view_holder);
    }

    private int c(ArrayList<View> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int childCount = getChildCount() - 1;
        int i10 = 0;
        while (i10 <= childCount) {
            int i11 = (i10 + childCount) / 2;
            d(((h) getChildAt(i11)).f4112c, arrayList2);
            if (f(arrayList, arrayList2)) {
                i10 = i11 + 1;
            } else {
                childCount = i11 - 1;
            }
            arrayList2.clear();
        }
        return i10;
    }

    private static void d(View view, ArrayList<View> arrayList) {
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            d((View) parent, arrayList);
        }
        arrayList.add(view);
    }

    private static boolean e(View view, View view2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int childCount = viewGroup.getChildCount();
        if (Build.VERSION.SDK_INT >= 21 && view.getZ() != view2.getZ()) {
            return view.getZ() > view2.getZ();
        }
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(a0.a(viewGroup, i10));
            if (childAt == view) {
                return false;
            }
            if (childAt == view2) {
                break;
            }
        }
        return true;
    }

    private static boolean f(ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        if (arrayList.isEmpty() || arrayList2.isEmpty() || arrayList.get(0) != arrayList2.get(0)) {
            return true;
        }
        int min = Math.min(arrayList.size(), arrayList2.size());
        for (int i10 = 1; i10 < min; i10++) {
            View view = arrayList.get(i10);
            View view2 = arrayList2.get(i10);
            if (view != view2) {
                return e(view, view2);
            }
        }
        return arrayList2.size() == min;
    }

    /* access modifiers changed from: package-private */
    public void a(h hVar) {
        ArrayList arrayList = new ArrayList();
        d(hVar.f4112c, arrayList);
        int c10 = c(arrayList);
        if (c10 < 0 || c10 >= getChildCount()) {
            addView(hVar);
        } else {
            addView(hVar, c10);
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        if (this.f4098b) {
            a0.b(this.f4097a).d(this);
            a0.b(this.f4097a).c(this);
            return;
        }
        throw new IllegalStateException("This GhostViewHolder is detached!");
    }

    public void onViewAdded(View view) {
        if (this.f4098b) {
            super.onViewAdded(view);
            return;
        }
        throw new IllegalStateException("This GhostViewHolder is detached!");
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if ((getChildCount() == 1 && getChildAt(0) == view) || getChildCount() == 0) {
            this.f4097a.setTag(b.ghost_view_holder, (Object) null);
            a0.b(this.f4097a).d(this);
            this.f4098b = false;
        }
    }
}
