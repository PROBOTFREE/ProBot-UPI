package androidx.databinding;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static d f2532a = new DataBinderMapperImpl();

    /* renamed from: b  reason: collision with root package name */
    private static e f2533b = null;

    static <T extends ViewDataBinding> T a(e eVar, View view, int i10) {
        return f2532a.getDataBinder(eVar, view, i10);
    }

    static <T extends ViewDataBinding> T b(e eVar, View[] viewArr, int i10) {
        return f2532a.getDataBinder(eVar, viewArr, i10);
    }

    private static <T extends ViewDataBinding> T c(e eVar, ViewGroup viewGroup, int i10, int i11) {
        int childCount = viewGroup.getChildCount();
        int i12 = childCount - i10;
        if (i12 == 1) {
            return a(eVar, viewGroup.getChildAt(childCount - 1), i11);
        }
        View[] viewArr = new View[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            viewArr[i13] = viewGroup.getChildAt(i13 + i10);
        }
        return b(eVar, viewArr, i11);
    }

    public static e d() {
        return f2533b;
    }

    public static <T extends ViewDataBinding> T e(LayoutInflater layoutInflater, int i10, ViewGroup viewGroup, boolean z10) {
        return f(layoutInflater, i10, viewGroup, z10, f2533b);
    }

    public static <T extends ViewDataBinding> T f(LayoutInflater layoutInflater, int i10, ViewGroup viewGroup, boolean z10, e eVar) {
        int i11 = 0;
        boolean z11 = viewGroup != null && z10;
        if (z11) {
            i11 = viewGroup.getChildCount();
        }
        return z11 ? c(eVar, viewGroup, i11, i10) : a(eVar, layoutInflater.inflate(i10, viewGroup, z10), i10);
    }

    public static <T extends ViewDataBinding> T g(Activity activity, int i10) {
        return h(activity, i10, f2533b);
    }

    public static <T extends ViewDataBinding> T h(Activity activity, int i10, e eVar) {
        activity.setContentView(i10);
        return c(eVar, (ViewGroup) activity.getWindow().getDecorView().findViewById(16908290), 0, i10);
    }
}
