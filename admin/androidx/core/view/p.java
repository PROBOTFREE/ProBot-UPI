package androidx.core.view;

import android.view.View;

public interface p {
    boolean onNestedFling(View view, float f10, float f11, boolean z10);

    boolean onNestedPreFling(View view, float f10, float f11);

    void onNestedPreScroll(View view, int i10, int i11, int[] iArr);

    void onNestedScroll(View view, int i10, int i11, int i12, int i13);

    void onNestedScrollAccepted(View view, View view2, int i10);

    boolean onStartNestedScroll(View view, View view2, int i10);

    void onStopNestedScroll(View view);
}
