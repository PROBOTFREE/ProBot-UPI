package androidx.transition;

import android.animation.LayoutTransition;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class b0 {

    /* renamed from: a  reason: collision with root package name */
    private static LayoutTransition f4071a;

    /* renamed from: b  reason: collision with root package name */
    private static Field f4072b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f4073c;

    /* renamed from: d  reason: collision with root package name */
    private static Method f4074d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f4075e;

    static class a extends LayoutTransition {
        a() {
        }

        public boolean isChangingLayout() {
            return true;
        }
    }

    private static void a(LayoutTransition layoutTransition) {
        if (!f4075e) {
            try {
                Method declaredMethod = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
                f4074d = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            }
            f4075e = true;
        }
        Method method = f4074d;
        if (method != null) {
            try {
                method.invoke(layoutTransition, new Object[0]);
            } catch (IllegalAccessException unused2) {
                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            } catch (InvocationTargetException unused3) {
                Log.i("ViewGroupUtilsApi14", "Failed to invoke cancel method by reflection");
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void b(android.view.ViewGroup r5, boolean r6) {
        /*
            android.animation.LayoutTransition r0 = f4071a
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 != 0) goto L_0x0028
            androidx.transition.b0$a r0 = new androidx.transition.b0$a
            r0.<init>()
            f4071a = r0
            r4 = 2
            r0.setAnimator(r4, r3)
            android.animation.LayoutTransition r0 = f4071a
            r0.setAnimator(r2, r3)
            android.animation.LayoutTransition r0 = f4071a
            r0.setAnimator(r1, r3)
            android.animation.LayoutTransition r0 = f4071a
            r4 = 3
            r0.setAnimator(r4, r3)
            android.animation.LayoutTransition r0 = f4071a
            r4 = 4
            r0.setAnimator(r4, r3)
        L_0x0028:
            if (r6 == 0) goto L_0x0048
            android.animation.LayoutTransition r6 = r5.getLayoutTransition()
            if (r6 == 0) goto L_0x0042
            boolean r0 = r6.isRunning()
            if (r0 == 0) goto L_0x0039
            a(r6)
        L_0x0039:
            android.animation.LayoutTransition r0 = f4071a
            if (r6 == r0) goto L_0x0042
            int r0 = x1.b.transition_layout_save
            r5.setTag(r0, r6)
        L_0x0042:
            android.animation.LayoutTransition r6 = f4071a
            r5.setLayoutTransition(r6)
            goto L_0x0094
        L_0x0048:
            r5.setLayoutTransition(r3)
            boolean r6 = f4073c
            java.lang.String r0 = "ViewGroupUtilsApi14"
            if (r6 != 0) goto L_0x0066
            java.lang.Class<android.view.ViewGroup> r6 = android.view.ViewGroup.class
            java.lang.String r4 = "mLayoutSuppressed"
            java.lang.reflect.Field r6 = r6.getDeclaredField(r4)     // Catch:{ NoSuchFieldException -> 0x005f }
            f4072b = r6     // Catch:{ NoSuchFieldException -> 0x005f }
            r6.setAccessible(r1)     // Catch:{ NoSuchFieldException -> 0x005f }
            goto L_0x0064
        L_0x005f:
            java.lang.String r6 = "Failed to access mLayoutSuppressed field by reflection"
            android.util.Log.i(r0, r6)
        L_0x0064:
            f4073c = r1
        L_0x0066:
            java.lang.reflect.Field r6 = f4072b
            if (r6 == 0) goto L_0x007f
            boolean r6 = r6.getBoolean(r5)     // Catch:{ IllegalAccessException -> 0x007a }
            if (r6 == 0) goto L_0x0078
            java.lang.reflect.Field r1 = f4072b     // Catch:{ IllegalAccessException -> 0x0076 }
            r1.setBoolean(r5, r2)     // Catch:{ IllegalAccessException -> 0x0076 }
            goto L_0x0078
        L_0x0076:
            r2 = r6
            goto L_0x007a
        L_0x0078:
            r2 = r6
            goto L_0x007f
        L_0x007a:
            java.lang.String r6 = "Failed to get mLayoutSuppressed field by reflection"
            android.util.Log.i(r0, r6)
        L_0x007f:
            if (r2 == 0) goto L_0x0084
            r5.requestLayout()
        L_0x0084:
            int r6 = x1.b.transition_layout_save
            java.lang.Object r0 = r5.getTag(r6)
            android.animation.LayoutTransition r0 = (android.animation.LayoutTransition) r0
            if (r0 == 0) goto L_0x0094
            r5.setTag(r6, r3)
            r5.setLayoutTransition(r0)
        L_0x0094:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.b0.b(android.view.ViewGroup, boolean):void");
    }
}
