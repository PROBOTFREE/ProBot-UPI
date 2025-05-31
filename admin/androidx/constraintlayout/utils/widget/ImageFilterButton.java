package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.f;

public class ImageFilterButton extends AppCompatImageButton {

    /* renamed from: c  reason: collision with root package name */
    private ImageFilterView.c f1763c = new ImageFilterView.c();

    /* renamed from: d  reason: collision with root package name */
    private float f1764d = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public float f1765e = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public float f1766f = Float.NaN;

    /* renamed from: g  reason: collision with root package name */
    private Path f1767g;

    /* renamed from: h  reason: collision with root package name */
    ViewOutlineProvider f1768h;

    /* renamed from: i  reason: collision with root package name */
    RectF f1769i;

    /* renamed from: j  reason: collision with root package name */
    Drawable[] f1770j = new Drawable[2];

    /* renamed from: k  reason: collision with root package name */
    LayerDrawable f1771k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f1772l = true;

    /* renamed from: m  reason: collision with root package name */
    private Drawable f1773m = null;

    /* renamed from: n  reason: collision with root package name */
    private Drawable f1774n = null;

    /* renamed from: o  reason: collision with root package name */
    private float f1775o = Float.NaN;

    /* renamed from: p  reason: collision with root package name */
    private float f1776p = Float.NaN;

    /* renamed from: q  reason: collision with root package name */
    private float f1777q = Float.NaN;

    /* renamed from: r  reason: collision with root package name */
    private float f1778r = Float.NaN;

    class a extends ViewOutlineProvider {
        a() {
        }

        public void getOutline(View view, Outline outline) {
            int width = ImageFilterButton.this.getWidth();
            int height = ImageFilterButton.this.getHeight();
            outline.setRoundRect(0, 0, width, height, (((float) Math.min(width, height)) * ImageFilterButton.this.f1765e) / 2.0f);
        }
    }

    class b extends ViewOutlineProvider {
        b() {
        }

        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, ImageFilterButton.this.getWidth(), ImageFilterButton.this.getHeight(), ImageFilterButton.this.f1766f);
        }
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context, attributeSet);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        c(context, attributeSet);
    }

    private void c(Context context, AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, f.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            this.f1773m = obtainStyledAttributes.getDrawable(f.ImageFilterView_altSrc);
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == f.ImageFilterView_crossfade) {
                    this.f1764d = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == f.ImageFilterView_warmth) {
                    setWarmth(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == f.ImageFilterView_saturation) {
                    setSaturation(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == f.ImageFilterView_contrast) {
                    setContrast(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == f.ImageFilterView_round) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                    }
                } else if (index == f.ImageFilterView_roundPercent) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                    }
                } else if (index == f.ImageFilterView_overlay) {
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.f1772l));
                } else if (index == f.ImageFilterView_imagePanX) {
                    setImagePanX(obtainStyledAttributes.getFloat(index, this.f1775o));
                } else if (index == f.ImageFilterView_imagePanY) {
                    setImagePanY(obtainStyledAttributes.getFloat(index, this.f1776p));
                } else if (index == f.ImageFilterView_imageRotate) {
                    setImageRotate(obtainStyledAttributes.getFloat(index, this.f1778r));
                } else if (index == f.ImageFilterView_imageZoom) {
                    setImageZoom(obtainStyledAttributes.getFloat(index, this.f1777q));
                }
            }
            obtainStyledAttributes.recycle();
            Drawable drawable = getDrawable();
            this.f1774n = drawable;
            if (this.f1773m == null || drawable == null) {
                Drawable drawable2 = getDrawable();
                this.f1774n = drawable2;
                if (drawable2 != null) {
                    Drawable[] drawableArr = this.f1770j;
                    Drawable mutate = drawable2.mutate();
                    this.f1774n = mutate;
                    drawableArr[0] = mutate;
                    return;
                }
                return;
            }
            Drawable[] drawableArr2 = this.f1770j;
            Drawable mutate2 = getDrawable().mutate();
            this.f1774n = mutate2;
            drawableArr2[0] = mutate2;
            this.f1770j[1] = this.f1773m.mutate();
            LayerDrawable layerDrawable = new LayerDrawable(this.f1770j);
            this.f1771k = layerDrawable;
            layerDrawable.getDrawable(1).setAlpha((int) (this.f1764d * 255.0f));
            if (!this.f1772l) {
                this.f1771k.getDrawable(0).setAlpha((int) ((1.0f - this.f1764d) * 255.0f));
            }
            super.setImageDrawable(this.f1771k);
        }
    }

    private void d() {
        if (!Float.isNaN(this.f1775o) || !Float.isNaN(this.f1776p) || !Float.isNaN(this.f1777q) || !Float.isNaN(this.f1778r)) {
            float f10 = 0.0f;
            float f11 = Float.isNaN(this.f1775o) ? 0.0f : this.f1775o;
            float f12 = Float.isNaN(this.f1776p) ? 0.0f : this.f1776p;
            float f13 = Float.isNaN(this.f1777q) ? 1.0f : this.f1777q;
            if (!Float.isNaN(this.f1778r)) {
                f10 = this.f1778r;
            }
            Matrix matrix = new Matrix();
            matrix.reset();
            float intrinsicWidth = (float) getDrawable().getIntrinsicWidth();
            float intrinsicHeight = (float) getDrawable().getIntrinsicHeight();
            float width = (float) getWidth();
            float height = (float) getHeight();
            float f14 = f13 * (intrinsicWidth * height < intrinsicHeight * width ? width / intrinsicWidth : height / intrinsicHeight);
            matrix.postScale(f14, f14);
            float f15 = intrinsicWidth * f14;
            float f16 = f14 * intrinsicHeight;
            matrix.postTranslate((((f11 * (width - f15)) + width) - f15) * 0.5f, (((f12 * (height - f16)) + height) - f16) * 0.5f);
            matrix.postRotate(f10, width / 2.0f, height / 2.0f);
            setImageMatrix(matrix);
            setScaleType(ImageView.ScaleType.MATRIX);
        }
    }

    private void e() {
        if (!Float.isNaN(this.f1775o) || !Float.isNaN(this.f1776p) || !Float.isNaN(this.f1777q) || !Float.isNaN(this.f1778r)) {
            d();
        } else {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
    }

    private void setOverlay(boolean z10) {
        this.f1772l = z10;
    }

    public void draw(Canvas canvas) {
        boolean z10;
        if (Build.VERSION.SDK_INT >= 21 || this.f1766f == 0.0f || this.f1767g == null) {
            z10 = false;
        } else {
            z10 = true;
            canvas.save();
            canvas.clipPath(this.f1767g);
        }
        super.draw(canvas);
        if (z10) {
            canvas.restore();
        }
    }

    public float getContrast() {
        return this.f1763c.f1804f;
    }

    public float getCrossfade() {
        return this.f1764d;
    }

    public float getImagePanX() {
        return this.f1775o;
    }

    public float getImagePanY() {
        return this.f1776p;
    }

    public float getImageRotate() {
        return this.f1778r;
    }

    public float getImageZoom() {
        return this.f1777q;
    }

    public float getRound() {
        return this.f1766f;
    }

    public float getRoundPercent() {
        return this.f1765e;
    }

    public float getSaturation() {
        return this.f1763c.f1803e;
    }

    public float getWarmth() {
        return this.f1763c.f1805g;
    }

    public void layout(int i10, int i11, int i12, int i13) {
        super.layout(i10, i11, i12, i13);
        d();
    }

    public void setAltImageResource(int i10) {
        Drawable mutate = k.a.d(getContext(), i10).mutate();
        this.f1773m = mutate;
        Drawable[] drawableArr = this.f1770j;
        drawableArr[0] = this.f1774n;
        drawableArr[1] = mutate;
        LayerDrawable layerDrawable = new LayerDrawable(this.f1770j);
        this.f1771k = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f1764d);
    }

    public void setBrightness(float f10) {
        ImageFilterView.c cVar = this.f1763c;
        cVar.f1802d = f10;
        cVar.c(this);
    }

    public void setContrast(float f10) {
        ImageFilterView.c cVar = this.f1763c;
        cVar.f1804f = f10;
        cVar.c(this);
    }

    public void setCrossfade(float f10) {
        this.f1764d = f10;
        if (this.f1770j != null) {
            if (!this.f1772l) {
                this.f1771k.getDrawable(0).setAlpha((int) ((1.0f - this.f1764d) * 255.0f));
            }
            this.f1771k.getDrawable(1).setAlpha((int) (this.f1764d * 255.0f));
            super.setImageDrawable(this.f1771k);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        if (this.f1773m == null || drawable == null) {
            super.setImageDrawable(drawable);
            return;
        }
        Drawable mutate = drawable.mutate();
        this.f1774n = mutate;
        Drawable[] drawableArr = this.f1770j;
        drawableArr[0] = mutate;
        drawableArr[1] = this.f1773m;
        LayerDrawable layerDrawable = new LayerDrawable(this.f1770j);
        this.f1771k = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f1764d);
    }

    public void setImagePanX(float f10) {
        this.f1775o = f10;
        e();
    }

    public void setImagePanY(float f10) {
        this.f1776p = f10;
        e();
    }

    public void setImageResource(int i10) {
        if (this.f1773m != null) {
            Drawable mutate = k.a.d(getContext(), i10).mutate();
            this.f1774n = mutate;
            Drawable[] drawableArr = this.f1770j;
            drawableArr[0] = mutate;
            drawableArr[1] = this.f1773m;
            LayerDrawable layerDrawable = new LayerDrawable(this.f1770j);
            this.f1771k = layerDrawable;
            super.setImageDrawable(layerDrawable);
            setCrossfade(this.f1764d);
            return;
        }
        super.setImageResource(i10);
    }

    public void setImageRotate(float f10) {
        this.f1778r = f10;
        e();
    }

    public void setImageZoom(float f10) {
        this.f1777q = f10;
        e();
    }

    public void setRound(float f10) {
        if (Float.isNaN(f10)) {
            this.f1766f = f10;
            float f11 = this.f1765e;
            this.f1765e = -1.0f;
            setRoundPercent(f11);
            return;
        }
        boolean z10 = this.f1766f != f10;
        this.f1766f = f10;
        if (f10 != 0.0f) {
            if (this.f1767g == null) {
                this.f1767g = new Path();
            }
            if (this.f1769i == null) {
                this.f1769i = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.f1768h == null) {
                    b bVar = new b();
                    this.f1768h = bVar;
                    setOutlineProvider(bVar);
                }
                setClipToOutline(true);
            }
            this.f1769i.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.f1767g.reset();
            Path path = this.f1767g;
            RectF rectF = this.f1769i;
            float f12 = this.f1766f;
            path.addRoundRect(rectF, f12, f12, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(false);
        }
        if (z10 && Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f10) {
        boolean z10 = this.f1765e != f10;
        this.f1765e = f10;
        if (f10 != 0.0f) {
            if (this.f1767g == null) {
                this.f1767g = new Path();
            }
            if (this.f1769i == null) {
                this.f1769i = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.f1768h == null) {
                    a aVar = new a();
                    this.f1768h = aVar;
                    setOutlineProvider(aVar);
                }
                setClipToOutline(true);
            }
            int width = getWidth();
            int height = getHeight();
            float min = (((float) Math.min(width, height)) * this.f1765e) / 2.0f;
            this.f1769i.set(0.0f, 0.0f, (float) width, (float) height);
            this.f1767g.reset();
            this.f1767g.addRoundRect(this.f1769i, min, min, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(false);
        }
        if (z10 && Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f10) {
        ImageFilterView.c cVar = this.f1763c;
        cVar.f1803e = f10;
        cVar.c(this);
    }

    public void setWarmth(float f10) {
        ImageFilterView.c cVar = this.f1763c;
        cVar.f1805g = f10;
        cVar.c(this);
    }
}
