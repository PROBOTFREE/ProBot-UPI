package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import x1.b;

class l0 {

    /* renamed from: b  reason: collision with root package name */
    private static Method f4126b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f4127c;

    /* renamed from: d  reason: collision with root package name */
    private static Field f4128d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f4129e;

    /* renamed from: a  reason: collision with root package name */
    private float[] f4130a;

    l0() {
    }

    @SuppressLint({"PrivateApi"})
    private void b() {
        if (!f4127c) {
            Class<View> cls = View.class;
            try {
                Class cls2 = Integer.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("setFrame", new Class[]{cls2, cls2, cls2, cls2});
                f4126b = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e10) {
                Log.i("ViewUtilsBase", "Failed to retrieve setFrame method", e10);
            }
            f4127c = true;
        }
    }

    public void a(View view) {
        if (view.getVisibility() == 0) {
            view.setTag(b.save_non_transition_alpha, (Object) null);
        }
    }

    public float c(View view) {
        Float f10 = (Float) view.getTag(b.save_non_transition_alpha);
        float alpha = view.getAlpha();
        return f10 != null ? alpha / f10.floatValue() : alpha;
    }

    public void d(View view) {
        int i10 = b.save_non_transition_alpha;
        if (view.getTag(i10) == null) {
            view.setTag(i10, Float.valueOf(view.getAlpha()));
        }
    }

    public void e(View view, Matrix matrix) {
        if (matrix == null || matrix.isIdentity()) {
            view.setPivotX((float) (view.getWidth() / 2));
            view.setPivotY((float) (view.getHeight() / 2));
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.setRotation(0.0f);
            return;
        }
        float[] fArr = this.f4130a;
        if (fArr == null) {
            fArr = new float[9];
            this.f4130a = fArr;
        }
        matrix.getValues(fArr);
        float f10 = fArr[3];
        float sqrt = ((float) Math.sqrt((double) (1.0f - (f10 * f10)))) * ((float) (fArr[0] < 0.0f ? -1 : 1));
        float degrees = (float) Math.toDegrees(Math.atan2((double) f10, (double) sqrt));
        float f11 = fArr[0] / sqrt;
        float f12 = fArr[4] / sqrt;
        float f13 = fArr[2];
        float f14 = fArr[5];
        view.setPivotX(0.0f);
        view.setPivotY(0.0f);
        view.setTranslationX(f13);
        view.setTranslationY(f14);
        view.setRotation(degrees);
        view.setScaleX(f11);
        view.setScaleY(f12);
    }

    public void f(View view, int i10, int i11, int i12, int i13) {
        b();
        Method method = f4126b;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13)});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e10) {
                throw new RuntimeException(e10.getCause());
            }
        }
    }

    public void g(View view, float f10) {
        Float f11 = (Float) view.getTag(b.save_non_transition_alpha);
        if (f11 != null) {
            view.setAlpha(f11.floatValue() * f10);
        } else {
            view.setAlpha(f10);
        }
    }

    public void h(View view, int i10) {
        if (!f4129e) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f4128d = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsBase", "fetchViewFlagsField: ");
            }
            f4129e = true;
        }
        Field field = f4128d;
        if (field != null) {
            try {
                f4128d.setInt(view, i10 | (field.getInt(view) & -13));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public void i(View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            i(view2, matrix);
            matrix.preTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        }
        matrix.preTranslate((float) view.getLeft(), (float) view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (!matrix2.isIdentity()) {
            matrix.preConcat(matrix2);
        }
    }

    public void j(View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            j(view2, matrix);
            matrix.postTranslate((float) view2.getScrollX(), (float) view2.getScrollY());
        }
        matrix.postTranslate((float) (-view.getLeft()), (float) (-view.getTop()));
        Matrix matrix2 = view.getMatrix();
        if (!matrix2.isIdentity()) {
            Matrix matrix3 = new Matrix();
            if (matrix2.invert(matrix3)) {
                matrix.postConcat(matrix3);
            }
        }
    }
}
