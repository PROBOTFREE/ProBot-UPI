package androidx.activity;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.m;
import java.lang.reflect.Field;

final class ImmLeaksCleaner implements m {

    /* renamed from: b  reason: collision with root package name */
    private static int f183b;

    /* renamed from: c  reason: collision with root package name */
    private static Field f184c;

    /* renamed from: d  reason: collision with root package name */
    private static Field f185d;

    /* renamed from: e  reason: collision with root package name */
    private static Field f186e;

    /* renamed from: a  reason: collision with root package name */
    private Activity f187a;

    ImmLeaksCleaner(Activity activity) {
        this.f187a = activity;
    }

    private static void d() {
        try {
            f183b = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            f185d = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            f186e = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            f184c = declaredField3;
            declaredField3.setAccessible(true);
            f183b = 1;
        } catch (NoSuchFieldException unused) {
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:29|30|31) */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0045, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0044 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(androidx.lifecycle.o r3, androidx.lifecycle.h.b r4) {
        /*
            r2 = this;
            androidx.lifecycle.h$b r3 = androidx.lifecycle.h.b.ON_DESTROY
            if (r4 == r3) goto L_0x0005
            return
        L_0x0005:
            int r3 = f183b
            if (r3 != 0) goto L_0x000c
            d()
        L_0x000c:
            int r3 = f183b
            r4 = 1
            if (r3 != r4) goto L_0x004e
            android.app.Activity r3 = r2.f187a
            java.lang.String r4 = "input_method"
            java.lang.Object r3 = r3.getSystemService(r4)
            android.view.inputmethod.InputMethodManager r3 = (android.view.inputmethod.InputMethodManager) r3
            java.lang.reflect.Field r4 = f184c     // Catch:{ IllegalAccessException -> 0x004e }
            java.lang.Object r4 = r4.get(r3)     // Catch:{ IllegalAccessException -> 0x004e }
            if (r4 != 0) goto L_0x0024
            return
        L_0x0024:
            monitor-enter(r4)
            java.lang.reflect.Field r0 = f185d     // Catch:{ IllegalAccessException -> 0x004a, ClassCastException -> 0x0048 }
            java.lang.Object r0 = r0.get(r3)     // Catch:{ IllegalAccessException -> 0x004a, ClassCastException -> 0x0048 }
            android.view.View r0 = (android.view.View) r0     // Catch:{ IllegalAccessException -> 0x004a, ClassCastException -> 0x0048 }
            if (r0 != 0) goto L_0x0031
            monitor-exit(r4)     // Catch:{ all -> 0x0046 }
            return
        L_0x0031:
            boolean r0 = r0.isAttachedToWindow()     // Catch:{ all -> 0x0046 }
            if (r0 == 0) goto L_0x0039
            monitor-exit(r4)     // Catch:{ all -> 0x0046 }
            return
        L_0x0039:
            java.lang.reflect.Field r0 = f186e     // Catch:{ IllegalAccessException -> 0x0044 }
            r1 = 0
            r0.set(r3, r1)     // Catch:{ IllegalAccessException -> 0x0044 }
            monitor-exit(r4)     // Catch:{ all -> 0x0046 }
            r3.isActive()
            goto L_0x004e
        L_0x0044:
            monitor-exit(r4)     // Catch:{ all -> 0x0046 }
            return
        L_0x0046:
            r3 = move-exception
            goto L_0x004c
        L_0x0048:
            monitor-exit(r4)     // Catch:{ all -> 0x0046 }
            return
        L_0x004a:
            monitor-exit(r4)     // Catch:{ all -> 0x0046 }
            return
        L_0x004c:
            monitor-exit(r4)     // Catch:{ all -> 0x0046 }
            throw r3
        L_0x004e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.ImmLeaksCleaner.c(androidx.lifecycle.o, androidx.lifecycle.h$b):void");
    }
}
