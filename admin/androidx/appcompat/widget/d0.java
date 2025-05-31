package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class d0 extends ContextWrapper {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f1058c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static ArrayList<WeakReference<d0>> f1059d;

    /* renamed from: a  reason: collision with root package name */
    private final Resources f1060a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources.Theme f1061b;

    private d0(Context context) {
        super(context);
        if (l0.c()) {
            l0 l0Var = new l0(this, context.getResources());
            this.f1060a = l0Var;
            Resources.Theme newTheme = l0Var.newTheme();
            this.f1061b = newTheme;
            newTheme.setTo(context.getTheme());
            return;
        }
        this.f1060a = new f0(this, context.getResources());
        this.f1061b = null;
    }

    private static boolean a(Context context) {
        if ((context instanceof d0) || (context.getResources() instanceof f0) || (context.getResources() instanceof l0)) {
            return false;
        }
        return Build.VERSION.SDK_INT < 21 || l0.c();
    }

    public static Context b(Context context) {
        if (!a(context)) {
            return context;
        }
        synchronized (f1058c) {
            ArrayList<WeakReference<d0>> arrayList = f1059d;
            if (arrayList == null) {
                f1059d = new ArrayList<>();
            } else {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    WeakReference weakReference = f1059d.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f1059d.remove(size);
                    }
                }
                for (int size2 = f1059d.size() - 1; size2 >= 0; size2--) {
                    WeakReference weakReference2 = f1059d.get(size2);
                    d0 d0Var = weakReference2 != null ? (d0) weakReference2.get() : null;
                    if (d0Var != null && d0Var.getBaseContext() == context) {
                        return d0Var;
                    }
                }
            }
            d0 d0Var2 = new d0(context);
            f1059d.add(new WeakReference(d0Var2));
            return d0Var2;
        }
    }

    public AssetManager getAssets() {
        return this.f1060a.getAssets();
    }

    public Resources getResources() {
        return this.f1060a;
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f1061b;
        return theme == null ? super.getTheme() : theme;
    }

    public void setTheme(int i10) {
        Resources.Theme theme = this.f1061b;
        if (theme == null) {
            super.setTheme(i10);
        } else {
            theme.applyStyle(i10, true);
        }
    }
}
