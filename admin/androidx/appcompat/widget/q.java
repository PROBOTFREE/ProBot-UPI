package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Field;
import p0.a;
import p0.c;

@SuppressLint({"RestrictedAPI"})
public class q {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f1180a = {16842912};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f1181b = new int[0];

    /* renamed from: c  reason: collision with root package name */
    public static final Rect f1182c = new Rect();

    /* renamed from: d  reason: collision with root package name */
    private static Class<?> f1183d;

    static {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                f1183d = Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException unused) {
            }
        }
    }

    public static boolean a(Drawable drawable) {
        Drawable drawable2;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 15 && (drawable instanceof InsetDrawable)) {
            return false;
        }
        if (i10 < 15 && (drawable instanceof GradientDrawable)) {
            return false;
        }
        if (i10 < 17 && (drawable instanceof LayerDrawable)) {
            return false;
        }
        if (drawable instanceof DrawableContainer) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (!(constantState instanceof DrawableContainer.DrawableContainerState)) {
                return true;
            }
            for (Drawable a10 : ((DrawableContainer.DrawableContainerState) constantState).getChildren()) {
                if (!a(a10)) {
                    return false;
                }
            }
            return true;
        }
        if (drawable instanceof c) {
            drawable2 = ((c) drawable).b();
        } else if (drawable instanceof l.c) {
            drawable2 = ((l.c) drawable).a();
        } else if (!(drawable instanceof ScaleDrawable)) {
            return true;
        } else {
            drawable2 = ((ScaleDrawable) drawable).getDrawable();
        }
        return a(drawable2);
    }

    static void b(Drawable drawable) {
        if (Build.VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            c(drawable);
        }
    }

    private static void c(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(f1180a);
        } else {
            drawable.setState(f1181b);
        }
        drawable.setState(state);
    }

    public static Rect d(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 29) {
            Insets opticalInsets = drawable.getOpticalInsets();
            Rect rect = new Rect();
            rect.left = opticalInsets.left;
            rect.right = opticalInsets.right;
            rect.top = opticalInsets.top;
            rect.bottom = opticalInsets.bottom;
            return rect;
        }
        if (f1183d != null) {
            try {
                Drawable q10 = a.q(drawable);
                Object invoke = q10.getClass().getMethod("getOpticalInsets", new Class[0]).invoke(q10, new Object[0]);
                if (invoke != null) {
                    Rect rect2 = new Rect();
                    for (Field field : f1183d.getFields()) {
                        String name = field.getName();
                        char c10 = 65535;
                        switch (name.hashCode()) {
                            case -1383228885:
                                if (name.equals("bottom")) {
                                    c10 = 3;
                                    break;
                                }
                                break;
                            case 115029:
                                if (name.equals("top")) {
                                    c10 = 1;
                                    break;
                                }
                                break;
                            case 3317767:
                                if (name.equals("left")) {
                                    c10 = 0;
                                    break;
                                }
                                break;
                            case 108511772:
                                if (name.equals("right")) {
                                    c10 = 2;
                                    break;
                                }
                                break;
                        }
                        if (c10 == 0) {
                            rect2.left = field.getInt(invoke);
                        } else if (c10 == 1) {
                            rect2.top = field.getInt(invoke);
                        } else if (c10 == 2) {
                            rect2.right = field.getInt(invoke);
                        } else if (c10 == 3) {
                            rect2.bottom = field.getInt(invoke);
                        }
                    }
                    return rect2;
                }
            } catch (Exception unused) {
                Log.e("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
            }
        }
        return f1182c;
    }

    public static PorterDuff.Mode e(int i10, PorterDuff.Mode mode) {
        if (i10 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i10 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i10 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i10) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
