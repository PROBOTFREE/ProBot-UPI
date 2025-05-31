package androidx.databinding.library.baseAdapters;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import androidx.databinding.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends d {

    /* renamed from: a  reason: collision with root package name */
    private static final SparseIntArray f2535a = new SparseIntArray(0);

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        static final SparseArray<String> f2536a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(1);
            f2536a = sparseArray;
            sparseArray.put(0, "_all");
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        static final HashMap<String, Integer> f2537a = new HashMap<>(0);
    }

    public List<d> collectDependencies() {
        return new ArrayList(0);
    }

    public String convertBrIdToString(int i10) {
        return a.f2536a.get(i10);
    }

    public ViewDataBinding getDataBinder(e eVar, View view, int i10) {
        if (f2535a.get(i10) <= 0 || view.getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public ViewDataBinding getDataBinder(e eVar, View[] viewArr, int i10) {
        if (viewArr == null || viewArr.length == 0 || f2535a.get(i10) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f2537a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }
}
