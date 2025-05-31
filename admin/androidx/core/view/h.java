package androidx.core.view;

import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import java.lang.reflect.Field;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static Field f2381a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f2382b;

    private static void a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        if (!f2382b) {
            try {
                Field declaredField = LayoutInflater.class.getDeclaredField("mFactory2");
                f2381a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e10) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e10);
            }
            f2382b = true;
        }
        Field field = f2381a;
        if (field != null) {
            try {
                field.set(layoutInflater, factory2);
            } catch (IllegalAccessException e11) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e11);
            }
        }
    }

    public static void b(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        layoutInflater.setFactory2(factory2);
        if (Build.VERSION.SDK_INT < 21) {
            LayoutInflater.Factory factory = layoutInflater.getFactory();
            if (factory instanceof LayoutInflater.Factory2) {
                a(layoutInflater, (LayoutInflater.Factory2) factory);
            } else {
                a(layoutInflater, factory2);
            }
        }
    }
}
