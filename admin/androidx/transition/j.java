package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import java.lang.reflect.Field;

class j {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f4121a = true;

    /* renamed from: b  reason: collision with root package name */
    private static Field f4122b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f4123c;

    static void a(ImageView imageView, Matrix matrix) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29) {
            imageView.animateTransform(matrix);
            return;
        }
        if (matrix == null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable != null) {
                drawable.setBounds(0, 0, (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight(), (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom());
            } else {
                return;
            }
        } else if (i10 >= 21) {
            c(imageView, matrix);
            return;
        } else {
            Drawable drawable2 = imageView.getDrawable();
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
                Matrix matrix2 = null;
                b();
                Field field = f4122b;
                if (field != null) {
                    try {
                        Matrix matrix3 = (Matrix) field.get(imageView);
                        if (matrix3 == null) {
                            try {
                                matrix2 = new Matrix();
                                f4122b.set(imageView, matrix2);
                            } catch (IllegalAccessException unused) {
                            }
                        }
                        matrix2 = matrix3;
                    } catch (IllegalAccessException unused2) {
                    }
                }
                if (matrix2 != null) {
                    matrix2.set(matrix);
                }
            } else {
                return;
            }
        }
        imageView.invalidate();
    }

    private static void b() {
        if (!f4123c) {
            try {
                Field declaredField = ImageView.class.getDeclaredField("mDrawMatrix");
                f4122b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f4123c = true;
        }
    }

    @SuppressLint({"NewApi"})
    private static void c(ImageView imageView, Matrix matrix) {
        if (f4121a) {
            try {
                imageView.animateTransform(matrix);
            } catch (NoSuchMethodError unused) {
                f4121a = false;
            }
        }
    }
}
