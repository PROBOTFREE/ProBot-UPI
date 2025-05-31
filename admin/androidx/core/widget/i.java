package androidx.core.widget;

import android.os.Build;
import android.view.View;
import android.widget.ListView;

public final class i {
    public static boolean a(ListView listView, int i10) {
        if (Build.VERSION.SDK_INT >= 19) {
            return listView.canScrollList(i10);
        }
        int childCount = listView.getChildCount();
        if (childCount == 0) {
            return false;
        }
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        if (i10 > 0) {
            return firstVisiblePosition + childCount < listView.getCount() || listView.getChildAt(childCount + -1).getBottom() > listView.getHeight() - listView.getListPaddingBottom();
        }
        return firstVisiblePosition > 0 || listView.getChildAt(0).getTop() < listView.getListPaddingTop();
    }

    public static void b(ListView listView, int i10) {
        View childAt;
        if (Build.VERSION.SDK_INT >= 19) {
            listView.scrollListBy(i10);
            return;
        }
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        if (firstVisiblePosition != -1 && (childAt = listView.getChildAt(0)) != null) {
            listView.setSelectionFromTop(firstVisiblePosition, childAt.getTop() - i10);
        }
    }
}
