package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

final class a {

    /* renamed from: b  reason: collision with root package name */
    private static final ViewGroup.MarginLayoutParams f4379b;

    /* renamed from: a  reason: collision with root package name */
    private LinearLayoutManager f4380a;

    /* renamed from: androidx.viewpager2.widget.a$a  reason: collision with other inner class name */
    class C0049a implements Comparator<int[]> {
        C0049a(a aVar) {
        }

        /* renamed from: a */
        public int compare(int[] iArr, int[] iArr2) {
            return iArr[0] - iArr2[0];
        }
    }

    static {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        f4379b = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    a(LinearLayoutManager linearLayoutManager) {
        this.f4380a = linearLayoutManager;
    }

    private boolean a() {
        int i10;
        int i11;
        int i12;
        int i13;
        int X = this.f4380a.X();
        if (X == 0) {
            return true;
        }
        boolean z10 = this.f4380a.x2() == 0;
        int[] iArr = new int[2];
        iArr[1] = 2;
        iArr[0] = X;
        int[][] iArr2 = (int[][]) Array.newInstance(int.class, iArr);
        int i14 = 0;
        while (i14 < X) {
            View W = this.f4380a.W(i14);
            if (W != null) {
                ViewGroup.LayoutParams layoutParams = W.getLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : f4379b;
                int[] iArr3 = iArr2[i14];
                if (z10) {
                    i11 = W.getLeft();
                    i10 = marginLayoutParams.leftMargin;
                } else {
                    i11 = W.getTop();
                    i10 = marginLayoutParams.topMargin;
                }
                iArr3[0] = i11 - i10;
                int[] iArr4 = iArr2[i14];
                if (z10) {
                    i13 = W.getRight();
                    i12 = marginLayoutParams.rightMargin;
                } else {
                    i13 = W.getBottom();
                    i12 = marginLayoutParams.bottomMargin;
                }
                iArr4[1] = i13 + i12;
                i14++;
            } else {
                throw new IllegalStateException("null view contained in the view hierarchy");
            }
        }
        Arrays.sort(iArr2, new C0049a(this));
        for (int i15 = 1; i15 < X; i15++) {
            if (iArr2[i15 - 1][1] != iArr2[i15][0]) {
                return false;
            }
        }
        return iArr2[0][0] <= 0 && iArr2[X - 1][1] >= iArr2[0][1] - iArr2[0][0];
    }

    private boolean b() {
        int X = this.f4380a.X();
        for (int i10 = 0; i10 < X; i10++) {
            if (c(this.f4380a.W(i10))) {
                return true;
            }
        }
        return false;
    }

    private static boolean c(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                if (c(viewGroup.getChildAt(i10))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return (!a() || this.f4380a.X() <= 1) && b();
    }
}
