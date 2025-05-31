package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.transition.t;
import java.util.Map;

public class ChangeImageTransform extends Transition {
    private static final String[] J = {"android:changeImageTransform:matrix", "android:changeImageTransform:bounds"};
    private static final TypeEvaluator<Matrix> K = new a();
    private static final Property<ImageView, Matrix> L = new b(Matrix.class, "animatedTransform");

    static class a implements TypeEvaluator<Matrix> {
        a() {
        }

        /* renamed from: a */
        public Matrix evaluate(float f10, Matrix matrix, Matrix matrix2) {
            return null;
        }
    }

    static class b extends Property<ImageView, Matrix> {
        b(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Matrix get(ImageView imageView) {
            return null;
        }

        /* renamed from: b */
        public void set(ImageView imageView, Matrix matrix) {
            j.a(imageView, matrix);
        }
    }

    static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3984a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                android.widget.ImageView$ScaleType[] r0 = android.widget.ImageView.ScaleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3984a = r0
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3984a     // Catch:{ NoSuchFieldError -> 0x001d }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ChangeImageTransform.c.<clinit>():void");
        }
    }

    public ChangeImageTransform() {
    }

    public ChangeImageTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void t0(u uVar) {
        View view = uVar.f4165b;
        if ((view instanceof ImageView) && view.getVisibility() == 0) {
            ImageView imageView = (ImageView) view;
            if (imageView.getDrawable() != null) {
                Map<String, Object> map = uVar.f4164a;
                map.put("android:changeImageTransform:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
                map.put("android:changeImageTransform:matrix", v0(imageView));
            }
        }
    }

    private static Matrix u0(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        float width = (float) imageView.getWidth();
        float f10 = (float) intrinsicWidth;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        float height = (float) imageView.getHeight();
        float f11 = (float) intrinsicHeight;
        float max = Math.max(width / f10, height / f11);
        int round = Math.round((width - (f10 * max)) / 2.0f);
        int round2 = Math.round((height - (f11 * max)) / 2.0f);
        Matrix matrix = new Matrix();
        matrix.postScale(max, max);
        matrix.postTranslate((float) round, (float) round2);
        return matrix;
    }

    private static Matrix v0(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        if (drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0) {
            int i10 = c.f3984a[imageView.getScaleType().ordinal()];
            if (i10 == 1) {
                return y0(imageView);
            }
            if (i10 == 2) {
                return u0(imageView);
            }
        }
        return new Matrix(imageView.getImageMatrix());
    }

    private ObjectAnimator w0(ImageView imageView, Matrix matrix, Matrix matrix2) {
        return ObjectAnimator.ofObject(imageView, L, new t.a(), new Matrix[]{matrix, matrix2});
    }

    private ObjectAnimator x0(ImageView imageView) {
        Property<ImageView, Matrix> property = L;
        TypeEvaluator<Matrix> typeEvaluator = K;
        Matrix matrix = k.f4125a;
        return ObjectAnimator.ofObject(imageView, property, typeEvaluator, new Matrix[]{matrix, matrix});
    }

    private static Matrix y0(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        Matrix matrix = new Matrix();
        matrix.postScale(((float) imageView.getWidth()) / ((float) drawable.getIntrinsicWidth()), ((float) imageView.getHeight()) / ((float) drawable.getIntrinsicHeight()));
        return matrix;
    }

    public String[] N() {
        return J;
    }

    public void l(u uVar) {
        t0(uVar);
    }

    public void o(u uVar) {
        t0(uVar);
    }

    public Animator s(ViewGroup viewGroup, u uVar, u uVar2) {
        if (uVar == null || uVar2 == null) {
            return null;
        }
        Rect rect = (Rect) uVar.f4164a.get("android:changeImageTransform:bounds");
        Rect rect2 = (Rect) uVar2.f4164a.get("android:changeImageTransform:bounds");
        if (rect == null || rect2 == null) {
            return null;
        }
        Matrix matrix = (Matrix) uVar.f4164a.get("android:changeImageTransform:matrix");
        Matrix matrix2 = (Matrix) uVar2.f4164a.get("android:changeImageTransform:matrix");
        boolean z10 = (matrix == null && matrix2 == null) || (matrix != null && matrix.equals(matrix2));
        if (rect.equals(rect2) && z10) {
            return null;
        }
        ImageView imageView = (ImageView) uVar2.f4165b;
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return x0(imageView);
        }
        if (matrix == null) {
            matrix = k.f4125a;
        }
        if (matrix2 == null) {
            matrix2 = k.f4125a;
        }
        L.set(imageView, matrix);
        return w0(imageView, matrix, matrix2);
    }
}
