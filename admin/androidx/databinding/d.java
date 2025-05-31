package androidx.databinding;

import android.view.View;
import java.util.Collections;
import java.util.List;

public abstract class d {
    public List<d> collectDependencies() {
        return Collections.emptyList();
    }

    public abstract String convertBrIdToString(int i10);

    public abstract ViewDataBinding getDataBinder(e eVar, View view, int i10);

    public abstract ViewDataBinding getDataBinder(e eVar, View[] viewArr, int i10);

    public abstract int getLayoutId(String str);
}
