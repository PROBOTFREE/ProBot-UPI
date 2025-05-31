package androidx.core.view;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f2377a = false;

    /* renamed from: b  reason: collision with root package name */
    private static Method f2378b = null;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f2379c = false;

    /* renamed from: d  reason: collision with root package name */
    private static Field f2380d;

    public interface a {
        boolean superDispatchKeyEvent(KeyEvent keyEvent);
    }

    private static boolean a(ActionBar actionBar, KeyEvent keyEvent) {
        if (!f2377a) {
            try {
                f2378b = actionBar.getClass().getMethod("onMenuKeyEvent", new Class[]{KeyEvent.class});
            } catch (NoSuchMethodException unused) {
            }
            f2377a = true;
        }
        Method method = f2378b;
        if (method != null) {
            try {
                return ((Boolean) method.invoke(actionBar, new Object[]{keyEvent})).booleanValue();
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
        }
        return false;
    }

    private static boolean b(Activity activity, KeyEvent keyEvent) {
        activity.onUserInteraction();
        Window window = activity.getWindow();
        if (window.hasFeature(8)) {
            ActionBar actionBar = activity.getActionBar();
            if (keyEvent.getKeyCode() == 82 && actionBar != null && a(actionBar, keyEvent)) {
                return true;
            }
        }
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView = window.getDecorView();
        if (x.i(decorView, keyEvent)) {
            return true;
        }
        return keyEvent.dispatch(activity, decorView != null ? decorView.getKeyDispatcherState() : null, activity);
    }

    private static boolean c(Dialog dialog, KeyEvent keyEvent) {
        DialogInterface.OnKeyListener f10 = f(dialog);
        if (f10 != null && f10.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
            return true;
        }
        Window window = dialog.getWindow();
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView = window.getDecorView();
        if (x.i(decorView, keyEvent)) {
            return true;
        }
        return keyEvent.dispatch(dialog, decorView != null ? decorView.getKeyDispatcherState() : null, dialog);
    }

    public static boolean d(View view, KeyEvent keyEvent) {
        return x.j(view, keyEvent);
    }

    public static boolean e(a aVar, View view, Window.Callback callback, KeyEvent keyEvent) {
        if (aVar == null) {
            return false;
        }
        return Build.VERSION.SDK_INT >= 28 ? aVar.superDispatchKeyEvent(keyEvent) : callback instanceof Activity ? b((Activity) callback, keyEvent) : callback instanceof Dialog ? c((Dialog) callback, keyEvent) : (view != null && x.i(view, keyEvent)) || aVar.superDispatchKeyEvent(keyEvent);
    }

    private static DialogInterface.OnKeyListener f(Dialog dialog) {
        if (!f2379c) {
            try {
                Field declaredField = Dialog.class.getDeclaredField("mOnKeyListener");
                f2380d = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f2379c = true;
        }
        Field field = f2380d;
        if (field == null) {
            return null;
        }
        try {
            return (DialogInterface.OnKeyListener) field.get(dialog);
        } catch (IllegalAccessException unused2) {
            return null;
        }
    }
}
