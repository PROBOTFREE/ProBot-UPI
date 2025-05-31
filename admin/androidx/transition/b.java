package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class b {

    /* renamed from: a  reason: collision with root package name */
    private static Method f4068a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f4069b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f4070c;

    @SuppressLint({"SoonBlockedPrivateApi"})
    static void a(Canvas canvas, boolean z10) {
        Method method;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 21) {
            if (i10 >= 29) {
                if (z10) {
                    canvas.enableZ();
                } else {
                    canvas.disableZ();
                }
            } else if (i10 != 28) {
                if (!f4070c) {
                    try {
                        Method declaredMethod = Canvas.class.getDeclaredMethod("insertReorderBarrier", new Class[0]);
                        f4068a = declaredMethod;
                        declaredMethod.setAccessible(true);
                        Method declaredMethod2 = Canvas.class.getDeclaredMethod("insertInorderBarrier", new Class[0]);
                        f4069b = declaredMethod2;
                        declaredMethod2.setAccessible(true);
                    } catch (NoSuchMethodException unused) {
                    }
                    f4070c = true;
                }
                if (z10) {
                    try {
                        Method method2 = f4068a;
                        if (method2 != null) {
                            method2.invoke(canvas, new Object[0]);
                        }
                    } catch (IllegalAccessException unused2) {
                        return;
                    } catch (InvocationTargetException e10) {
                        throw new RuntimeException(e10.getCause());
                    }
                }
                if (!z10 && (method = f4069b) != null) {
                    method.invoke(canvas, new Object[0]);
                }
            } else {
                throw new IllegalStateException("This method doesn't work on Pie!");
            }
        }
    }
}
