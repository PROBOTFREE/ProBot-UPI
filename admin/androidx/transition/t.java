package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

class t {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f4158a;

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f4159b;

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f4160c;

    static class a implements TypeEvaluator<Matrix> {

        /* renamed from: a  reason: collision with root package name */
        final float[] f4161a = new float[9];

        /* renamed from: b  reason: collision with root package name */
        final float[] f4162b = new float[9];

        /* renamed from: c  reason: collision with root package name */
        final Matrix f4163c = new Matrix();

        a() {
        }

        /* renamed from: a */
        public Matrix evaluate(float f10, Matrix matrix, Matrix matrix2) {
            matrix.getValues(this.f4161a);
            matrix2.getValues(this.f4162b);
            for (int i10 = 0; i10 < 9; i10++) {
                float[] fArr = this.f4162b;
                float f11 = fArr[i10];
                float[] fArr2 = this.f4161a;
                fArr[i10] = fArr2[i10] + ((f11 - fArr2[i10]) * f10);
            }
            this.f4163c.setValues(this.f4162b);
            return this.f4163c;
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        boolean z10 = true;
        f4158a = i10 >= 19;
        f4159b = i10 >= 18;
        if (i10 < 28) {
            z10 = false;
        }
        f4160c = z10;
    }

    static View a(ViewGroup viewGroup, View view, View view2) {
        Matrix matrix = new Matrix();
        matrix.setTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        f0.j(view, matrix);
        f0.k(viewGroup, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        matrix.mapRect(rectF);
        int round = Math.round(rectF.left);
        int round2 = Math.round(rectF.top);
        int round3 = Math.round(rectF.right);
        int round4 = Math.round(rectF.bottom);
        ImageView imageView = new ImageView(view.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Bitmap b10 = b(view, matrix, rectF, viewGroup);
        if (b10 != null) {
            imageView.setImageBitmap(b10);
        }
        imageView.measure(View.MeasureSpec.makeMeasureSpec(round3 - round, 1073741824), View.MeasureSpec.makeMeasureSpec(round4 - round2, 1073741824));
        imageView.layout(round, round2, round3, round4);
        return imageView;
    }

    private static Bitmap b(View view, Matrix matrix, RectF rectF, ViewGroup viewGroup) {
        boolean z10;
        boolean z11;
        int i10;
        ViewGroup viewGroup2;
        if (f4158a) {
            z11 = !view.isAttachedToWindow();
            z10 = viewGroup == null ? false : viewGroup.isAttachedToWindow();
        } else {
            z11 = false;
            z10 = false;
        }
        boolean z12 = f4159b;
        Bitmap bitmap = null;
        if (!z12 || !z11) {
            i10 = 0;
            viewGroup2 = null;
        } else if (!z10) {
            return null;
        } else {
            viewGroup2 = (ViewGroup) view.getParent();
            i10 = viewGroup2.indexOfChild(view);
            viewGroup.getOverlay().add(view);
        }
        int round = Math.round(rectF.width());
        int round2 = Math.round(rectF.height());
        if (round > 0 && round2 > 0) {
            float min = Math.min(1.0f, 1048576.0f / ((float) (round * round2)));
            int round3 = Math.round(((float) round) * min);
            int round4 = Math.round(((float) round2) * min);
            matrix.postTranslate(-rectF.left, -rectF.top);
            matrix.postScale(min, min);
            if (f4160c) {
                Picture picture = new Picture();
                Canvas beginRecording = picture.beginRecording(round3, round4);
                beginRecording.concat(matrix);
                view.draw(beginRecording);
                picture.endRecording();
                bitmap = Bitmap.createBitmap(picture);
            } else {
                bitmap = Bitmap.createBitmap(round3, round4, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                canvas.concat(matrix);
                view.draw(canvas);
            }
        }
        if (z12 && z11) {
            viewGroup.getOverlay().remove(view);
            viewGroup2.addView(view, i10);
        }
        return bitmap;
    }

    static Animator c(Animator animator, Animator animator2) {
        if (animator == null) {
            return animator2;
        }
        if (animator2 == null) {
            return animator;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{animator, animator2});
        return animatorSet;
    }
}
