package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
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
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.f;

public class ImageFilterView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    private c f1781a = new c();

    /* renamed from: b  reason: collision with root package name */
    private boolean f1782b = true;

    /* renamed from: c  reason: collision with root package name */
    private Drawable f1783c = null;

    /* renamed from: d  reason: collision with root package name */
    private Drawable f1784d = null;

    /* renamed from: e  reason: collision with root package name */
    private float f1785e = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public float f1786f = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public float f1787g = Float.NaN;

    /* renamed from: h  reason: collision with root package name */
    private Path f1788h;

    /* renamed from: i  reason: collision with root package name */
    ViewOutlineProvider f1789i;

    /* renamed from: j  reason: collision with root package name */
    RectF f1790j;

    /* renamed from: k  reason: collision with root package name */
    Drawable[] f1791k = new Drawable[2];

    /* renamed from: l  reason: collision with root package name */
    LayerDrawable f1792l;

    /* renamed from: m  reason: collision with root package name */
    float f1793m = Float.NaN;

    /* renamed from: n  reason: collision with root package name */
    float f1794n = Float.NaN;

    /* renamed from: o  reason: collision with root package name */
    float f1795o = Float.NaN;

    /* renamed from: p  reason: collision with root package name */
    float f1796p = Float.NaN;

    class a extends ViewOutlineProvider {
        a() {
        }

        public void getOutline(View view, Outline outline) {
            int width = ImageFilterView.this.getWidth();
            int height = ImageFilterView.this.getHeight();
            outline.setRoundRect(0, 0, width, height, (((float) Math.min(width, height)) * ImageFilterView.this.f1786f) / 2.0f);
        }
    }

    class b extends ViewOutlineProvider {
        b() {
        }

        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), ImageFilterView.this.f1787g);
        }
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        float[] f1799a = new float[20];

        /* renamed from: b  reason: collision with root package name */
        ColorMatrix f1800b = new ColorMatrix();

        /* renamed from: c  reason: collision with root package name */
        ColorMatrix f1801c = new ColorMatrix();

        /* renamed from: d  reason: collision with root package name */
        float f1802d = 1.0f;

        /* renamed from: e  reason: collision with root package name */
        float f1803e = 1.0f;

        /* renamed from: f  reason: collision with root package name */
        float f1804f = 1.0f;

        /* renamed from: g  reason: collision with root package name */
        float f1805g = 1.0f;

        c() {
        }

        private void a(float f10) {
            float[] fArr = this.f1799a;
            fArr[0] = f10;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = f10;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = f10;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        private void b(float f10) {
            float f11 = 1.0f - f10;
            float f12 = 0.2999f * f11;
            float f13 = 0.587f * f11;
            float f14 = f11 * 0.114f;
            float[] fArr = this.f1799a;
            fArr[0] = f12 + f10;
            fArr[1] = f13;
            fArr[2] = f14;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = f12;
            fArr[6] = f13 + f10;
            fArr[7] = f14;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = f12;
            fArr[11] = f13;
            fArr[12] = f14 + f10;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        private void d(float f10) {
            float f11;
            float f12;
            if (f10 <= 0.0f) {
                f10 = 0.01f;
            }
            float f13 = (5000.0f / f10) / 100.0f;
            if (f13 > 66.0f) {
                double d10 = (double) (f13 - 60.0f);
                f12 = ((float) Math.pow(d10, -0.13320475816726685d)) * 329.69873f;
                f11 = ((float) Math.pow(d10, 0.07551484555006027d)) * 288.12216f;
            } else {
                f11 = (((float) Math.log((double) f13)) * 99.4708f) - 161.11957f;
                f12 = 255.0f;
            }
            float log = f13 < 66.0f ? f13 > 19.0f ? (((float) Math.log((double) (f13 - 10.0f))) * 138.51773f) - 305.0448f : 0.0f : 255.0f;
            float min = Math.min(255.0f, Math.max(f12, 0.0f));
            float min2 = Math.min(255.0f, Math.max(f11, 0.0f));
            float min3 = Math.min(255.0f, Math.max(log, 0.0f));
            float min4 = Math.min(255.0f, Math.max(255.0f, 0.0f));
            float min5 = Math.min(255.0f, Math.max((((float) Math.log((double) 50.0f)) * 99.4708f) - 161.11957f, 0.0f));
            float min6 = min3 / Math.min(255.0f, Math.max((((float) Math.log((double) 40.0f)) * 138.51773f) - 305.0448f, 0.0f));
            float[] fArr = this.f1799a;
            fArr[0] = min / min4;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = min2 / min5;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = min6;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        /* access modifiers changed from: package-private */
        public void c(ImageView imageView) {
            boolean z10;
            this.f1800b.reset();
            float f10 = this.f1803e;
            boolean z11 = true;
            if (f10 != 1.0f) {
                b(f10);
                this.f1800b.set(this.f1799a);
                z10 = true;
            } else {
                z10 = false;
            }
            float f11 = this.f1804f;
            if (f11 != 1.0f) {
                this.f1801c.setScale(f11, f11, f11, 1.0f);
                this.f1800b.postConcat(this.f1801c);
                z10 = true;
            }
            float f12 = this.f1805g;
            if (f12 != 1.0f) {
                d(f12);
                this.f1801c.set(this.f1799a);
                this.f1800b.postConcat(this.f1801c);
                z10 = true;
            }
            float f13 = this.f1802d;
            if (f13 != 1.0f) {
                a(f13);
                this.f1801c.set(this.f1799a);
                this.f1800b.postConcat(this.f1801c);
            } else {
                z11 = z10;
            }
            if (z11) {
                imageView.setColorFilter(new ColorMatrixColorFilter(this.f1800b));
            } else {
                imageView.clearColorFilter();
            }
        }
    }

    public ImageFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context, attributeSet);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        c(context, attributeSet);
    }

    private void c(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, f.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            this.f1783c = obtainStyledAttributes.getDrawable(f.ImageFilterView_altSrc);
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == f.ImageFilterView_crossfade) {
                    this.f1785e = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == f.ImageFilterView_warmth) {
                    setWarmth(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == f.ImageFilterView_saturation) {
                    setSaturation(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == f.ImageFilterView_contrast) {
                    setContrast(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == f.ImageFilterView_brightness) {
                    setBrightness(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == f.ImageFilterView_round) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                    }
                } else if (index == f.ImageFilterView_roundPercent) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                    }
                } else if (index == f.ImageFilterView_overlay) {
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.f1782b));
                } else if (index == f.ImageFilterView_imagePanX) {
                    setImagePanX(obtainStyledAttributes.getFloat(index, this.f1793m));
                } else if (index == f.ImageFilterView_imagePanY) {
                    setImagePanY(obtainStyledAttributes.getFloat(index, this.f1794n));
                } else if (index == f.ImageFilterView_imageRotate) {
                    setImageRotate(obtainStyledAttributes.getFloat(index, this.f1796p));
                } else if (index == f.ImageFilterView_imageZoom) {
                    setImageZoom(obtainStyledAttributes.getFloat(index, this.f1795o));
                }
            }
            obtainStyledAttributes.recycle();
            Drawable drawable = getDrawable();
            this.f1784d = drawable;
            if (this.f1783c == null || drawable == null) {
                Drawable drawable2 = getDrawable();
                this.f1784d = drawable2;
                if (drawable2 != null) {
                    Drawable[] drawableArr = this.f1791k;
                    Drawable mutate = drawable2.mutate();
                    this.f1784d = mutate;
                    drawableArr[0] = mutate;
                    return;
                }
                return;
            }
            Drawable[] drawableArr2 = this.f1791k;
            Drawable mutate2 = getDrawable().mutate();
            this.f1784d = mutate2;
            drawableArr2[0] = mutate2;
            this.f1791k[1] = this.f1783c.mutate();
            LayerDrawable layerDrawable = new LayerDrawable(this.f1791k);
            this.f1792l = layerDrawable;
            layerDrawable.getDrawable(1).setAlpha((int) (this.f1785e * 255.0f));
            if (!this.f1782b) {
                this.f1792l.getDrawable(0).setAlpha((int) ((1.0f - this.f1785e) * 255.0f));
            }
            super.setImageDrawable(this.f1792l);
        }
    }

    private void g() {
        if (!Float.isNaN(this.f1793m) || !Float.isNaN(this.f1794n) || !Float.isNaN(this.f1795o) || !Float.isNaN(this.f1796p)) {
            float f10 = 0.0f;
            float f11 = Float.isNaN(this.f1793m) ? 0.0f : this.f1793m;
            float f12 = Float.isNaN(this.f1794n) ? 0.0f : this.f1794n;
            float f13 = Float.isNaN(this.f1795o) ? 1.0f : this.f1795o;
            if (!Float.isNaN(this.f1796p)) {
                f10 = this.f1796p;
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

    private void h() {
        if (!Float.isNaN(this.f1793m) || !Float.isNaN(this.f1794n) || !Float.isNaN(this.f1795o) || !Float.isNaN(this.f1796p)) {
            g();
        } else {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
    }

    private void setOverlay(boolean z10) {
        this.f1782b = z10;
    }

    public void draw(Canvas canvas) {
        boolean z10;
        if (Build.VERSION.SDK_INT >= 21 || this.f1786f == 0.0f || this.f1788h == null) {
            z10 = false;
        } else {
            z10 = true;
            canvas.save();
            canvas.clipPath(this.f1788h);
        }
        super.draw(canvas);
        if (z10) {
            canvas.restore();
        }
    }

    public float getBrightness() {
        return this.f1781a.f1802d;
    }

    public float getContrast() {
        return this.f1781a.f1804f;
    }

    public float getCrossfade() {
        return this.f1785e;
    }

    public float getImagePanX() {
        return this.f1793m;
    }

    public float getImagePanY() {
        return this.f1794n;
    }

    public float getImageRotate() {
        return this.f1796p;
    }

    public float getImageZoom() {
        return this.f1795o;
    }

    public float getRound() {
        return this.f1787g;
    }

    public float getRoundPercent() {
        return this.f1786f;
    }

    public float getSaturation() {
        return this.f1781a.f1803e;
    }

    public float getWarmth() {
        return this.f1781a.f1805g;
    }

    public void layout(int i10, int i11, int i12, int i13) {
        super.layout(i10, i11, i12, i13);
        g();
    }

    public void setAltImageResource(int i10) {
        Drawable mutate = k.a.d(getContext(), i10).mutate();
        this.f1783c = mutate;
        Drawable[] drawableArr = this.f1791k;
        drawableArr[0] = this.f1784d;
        drawableArr[1] = mutate;
        LayerDrawable layerDrawable = new LayerDrawable(this.f1791k);
        this.f1792l = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f1785e);
    }

    public void setBrightness(float f10) {
        c cVar = this.f1781a;
        cVar.f1802d = f10;
        cVar.c(this);
    }

    public void setContrast(float f10) {
        c cVar = this.f1781a;
        cVar.f1804f = f10;
        cVar.c(this);
    }

    public void setCrossfade(float f10) {
        this.f1785e = f10;
        if (this.f1791k != null) {
            if (!this.f1782b) {
                this.f1792l.getDrawable(0).setAlpha((int) ((1.0f - this.f1785e) * 255.0f));
            }
            this.f1792l.getDrawable(1).setAlpha((int) (this.f1785e * 255.0f));
            super.setImageDrawable(this.f1792l);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        if (this.f1783c == null || drawable == null) {
            super.setImageDrawable(drawable);
            return;
        }
        Drawable mutate = drawable.mutate();
        this.f1784d = mutate;
        Drawable[] drawableArr = this.f1791k;
        drawableArr[0] = mutate;
        drawableArr[1] = this.f1783c;
        LayerDrawable layerDrawable = new LayerDrawable(this.f1791k);
        this.f1792l = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f1785e);
    }

    public void setImagePanX(float f10) {
        this.f1793m = f10;
        h();
    }

    public void setImagePanY(float f10) {
        this.f1794n = f10;
        h();
    }

    public void setImageResource(int i10) {
        if (this.f1783c != null) {
            Drawable mutate = k.a.d(getContext(), i10).mutate();
            this.f1784d = mutate;
            Drawable[] drawableArr = this.f1791k;
            drawableArr[0] = mutate;
            drawableArr[1] = this.f1783c;
            LayerDrawable layerDrawable = new LayerDrawable(this.f1791k);
            this.f1792l = layerDrawable;
            super.setImageDrawable(layerDrawable);
            setCrossfade(this.f1785e);
            return;
        }
        super.setImageResource(i10);
    }

    public void setImageRotate(float f10) {
        this.f1796p = f10;
        h();
    }

    public void setImageZoom(float f10) {
        this.f1795o = f10;
        h();
    }

    public void setRound(float f10) {
        if (Float.isNaN(f10)) {
            this.f1787g = f10;
            float f11 = this.f1786f;
            this.f1786f = -1.0f;
            setRoundPercent(f11);
            return;
        }
        boolean z10 = this.f1787g != f10;
        this.f1787g = f10;
        if (f10 != 0.0f) {
            if (this.f1788h == null) {
                this.f1788h = new Path();
            }
            if (this.f1790j == null) {
                this.f1790j = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.f1789i == null) {
                    b bVar = new b();
                    this.f1789i = bVar;
                    setOutlineProvider(bVar);
                }
                setClipToOutline(true);
            }
            this.f1790j.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.f1788h.reset();
            Path path = this.f1788h;
            RectF rectF = this.f1790j;
            float f12 = this.f1787g;
            path.addRoundRect(rectF, f12, f12, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(false);
        }
        if (z10 && Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f10) {
        boolean z10 = this.f1786f != f10;
        this.f1786f = f10;
        if (f10 != 0.0f) {
            if (this.f1788h == null) {
                this.f1788h = new Path();
            }
            if (this.f1790j == null) {
                this.f1790j = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.f1789i == null) {
                    a aVar = new a();
                    this.f1789i = aVar;
                    setOutlineProvider(aVar);
                }
                setClipToOutline(true);
            }
            int width = getWidth();
            int height = getHeight();
            float min = (((float) Math.min(width, height)) * this.f1786f) / 2.0f;
            this.f1790j.set(0.0f, 0.0f, (float) width, (float) height);
            this.f1788h.reset();
            this.f1788h.addRoundRect(this.f1790j, min, min, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(false);
        }
        if (z10 && Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f10) {
        c cVar = this.f1781a;
        cVar.f1803e = f10;
        cVar.c(this);
    }

    public void setWarmth(float f10) {
        c cVar = this.f1781a;
        cVar.f1805g = f10;
        cVar.c(this);
    }
}
