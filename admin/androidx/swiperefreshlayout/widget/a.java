package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.core.view.x;

class a extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private Animation.AnimationListener f3918a;

    /* renamed from: b  reason: collision with root package name */
    int f3919b;

    /* renamed from: androidx.swiperefreshlayout.widget.a$a  reason: collision with other inner class name */
    private class C0042a extends OvalShape {

        /* renamed from: a  reason: collision with root package name */
        private RadialGradient f3920a;

        /* renamed from: b  reason: collision with root package name */
        private Paint f3921b = new Paint();

        C0042a(int i10) {
            a.this.f3919b = i10;
            a((int) rect().width());
        }

        private void a(int i10) {
            float f10 = (float) (i10 / 2);
            RadialGradient radialGradient = new RadialGradient(f10, f10, (float) a.this.f3919b, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.f3920a = radialGradient;
            this.f3921b.setShader(radialGradient);
        }

        public void draw(Canvas canvas, Paint paint) {
            int width = a.this.getWidth() / 2;
            float f10 = (float) width;
            float height = (float) (a.this.getHeight() / 2);
            canvas.drawCircle(f10, height, f10, this.f3921b);
            canvas.drawCircle(f10, height, (float) (width - a.this.f3919b), paint);
        }

        /* access modifiers changed from: protected */
        public void onResize(float f10, float f11) {
            super.onResize(f10, f11);
            a((int) f10);
        }
    }

    a(Context context, int i10) {
        super(context);
        ShapeDrawable shapeDrawable;
        float f10 = getContext().getResources().getDisplayMetrics().density;
        int i11 = (int) (1.75f * f10);
        int i12 = (int) (0.0f * f10);
        this.f3919b = (int) (3.5f * f10);
        if (a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            x.y0(this, f10 * 4.0f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new C0042a(this.f3919b));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer((float) this.f3919b, (float) i12, (float) i11, 503316480);
            int i13 = this.f3919b;
            setPadding(i13, i13, i13, i13);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(i10);
        x.u0(this, shapeDrawable);
    }

    private boolean a() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public void b(Animation.AnimationListener animationListener) {
        this.f3918a = animationListener;
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.f3918a;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.f3918a;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (!a()) {
            setMeasuredDimension(getMeasuredWidth() + (this.f3919b * 2), getMeasuredHeight() + (this.f3919b * 2));
        }
    }

    public void setBackgroundColor(int i10) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i10);
        }
    }
}
