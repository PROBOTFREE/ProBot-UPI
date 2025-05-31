package androidx.databinding;

import android.util.Log;
import android.view.View;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class MergedDataBinderMapper extends d {

    /* renamed from: a  reason: collision with root package name */
    private Set<Class<? extends d>> f2501a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    private List<d> f2502b = new CopyOnWriteArrayList();

    /* renamed from: c  reason: collision with root package name */
    private List<String> f2503c = new CopyOnWriteArrayList();

    private boolean b() {
        StringBuilder sb2;
        boolean z10 = false;
        for (String next : this.f2503c) {
            try {
                Class<?> cls = Class.forName(next);
                if (d.class.isAssignableFrom(cls)) {
                    a((d) cls.newInstance());
                    this.f2503c.remove(next);
                    z10 = true;
                }
            } catch (ClassNotFoundException unused) {
            } catch (IllegalAccessException e10) {
                e = e10;
                sb2 = new StringBuilder();
                sb2.append("unable to add feature mapper for ");
                sb2.append(next);
                Log.e("MergedDataBinderMapper", sb2.toString(), e);
            } catch (InstantiationException e11) {
                e = e11;
                sb2 = new StringBuilder();
                sb2.append("unable to add feature mapper for ");
                sb2.append(next);
                Log.e("MergedDataBinderMapper", sb2.toString(), e);
            }
        }
        return z10;
    }

    public void a(d dVar) {
        if (this.f2501a.add(dVar.getClass())) {
            this.f2502b.add(dVar);
            for (d a10 : dVar.collectDependencies()) {
                a(a10);
            }
        }
    }

    public String convertBrIdToString(int i10) {
        for (d convertBrIdToString : this.f2502b) {
            String convertBrIdToString2 = convertBrIdToString.convertBrIdToString(i10);
            if (convertBrIdToString2 != null) {
                return convertBrIdToString2;
            }
        }
        if (b()) {
            return convertBrIdToString(i10);
        }
        return null;
    }

    public ViewDataBinding getDataBinder(e eVar, View view, int i10) {
        for (d dataBinder : this.f2502b) {
            ViewDataBinding dataBinder2 = dataBinder.getDataBinder(eVar, view, i10);
            if (dataBinder2 != null) {
                return dataBinder2;
            }
        }
        if (b()) {
            return getDataBinder(eVar, view, i10);
        }
        return null;
    }

    public ViewDataBinding getDataBinder(e eVar, View[] viewArr, int i10) {
        for (d dataBinder : this.f2502b) {
            ViewDataBinding dataBinder2 = dataBinder.getDataBinder(eVar, viewArr, i10);
            if (dataBinder2 != null) {
                return dataBinder2;
            }
        }
        if (b()) {
            return getDataBinder(eVar, viewArr, i10);
        }
        return null;
    }

    public int getLayoutId(String str) {
        for (d layoutId : this.f2502b) {
            int layoutId2 = layoutId.getLayoutId(str);
            if (layoutId2 != 0) {
                return layoutId2;
            }
        }
        if (b()) {
            return getLayoutId(str);
        }
        return 0;
    }
}
