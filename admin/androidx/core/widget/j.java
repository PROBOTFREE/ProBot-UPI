package androidx.core.widget;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import androidx.core.view.f;
import androidx.core.view.x;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    private static Method f2485a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f2486b;

    /* renamed from: c  reason: collision with root package name */
    private static Field f2487c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f2488d;

    public static void a(PopupWindow popupWindow, boolean z10) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 23) {
            popupWindow.setOverlapAnchor(z10);
        } else if (i10 >= 21) {
            if (!f2488d) {
                try {
                    Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                    f2487c = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e10) {
                    Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e10);
                }
                f2488d = true;
            }
            Field field = f2487c;
            if (field != null) {
                try {
                    field.set(popupWindow, Boolean.valueOf(z10));
                } catch (IllegalAccessException e11) {
                    Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e11);
                }
            }
        }
    }

    public static void b(PopupWindow popupWindow, int i10) {
        if (Build.VERSION.SDK_INT >= 23) {
            popupWindow.setWindowLayoutType(i10);
            return;
        }
        if (!f2486b) {
            Class<PopupWindow> cls = PopupWindow.class;
            try {
                Method declaredMethod = cls.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
                f2485a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception unused) {
            }
            f2486b = true;
        }
        Method method = f2485a;
        if (method != null) {
            try {
                method.invoke(popupWindow, new Object[]{Integer.valueOf(i10)});
            } catch (Exception unused2) {
            }
        }
    }

    public static void c(PopupWindow popupWindow, View view, int i10, int i11, int i12) {
        if (Build.VERSION.SDK_INT >= 19) {
            popupWindow.showAsDropDown(view, i10, i11, i12);
            return;
        }
        if ((f.b(i12, x.C(view)) & 7) == 5) {
            i10 -= popupWindow.getWidth() - view.getWidth();
        }
        popupWindow.showAsDropDown(view, i10, i11);
    }
}
