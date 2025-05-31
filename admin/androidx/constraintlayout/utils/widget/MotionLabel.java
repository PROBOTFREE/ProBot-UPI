package androidx.constraintlayout.utils.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.constraintlayout.motion.widget.c;
import androidx.constraintlayout.widget.f;

public class MotionLabel extends View implements c {
    static String V = "MotionLabel";
    private float A;
    private float B;
    private float C;
    private Drawable D;
    Matrix E;
    private Bitmap F;
    private BitmapShader G;
    private Matrix H;
    private float I = Float.NaN;
    private float J = Float.NaN;
    private float K = 0.0f;
    private float L = 0.0f;
    Paint M = new Paint();
    private int N = 0;
    Rect O;
    Paint P;
    float Q;
    float R = Float.NaN;
    float S = Float.NaN;
    float T = Float.NaN;
    float U = Float.NaN;

    /* renamed from: a  reason: collision with root package name */
    TextPaint f1824a = new TextPaint();

    /* renamed from: b  reason: collision with root package name */
    Path f1825b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private int f1826c = 65535;

    /* renamed from: d  reason: collision with root package name */
    private int f1827d = 65535;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1828e = false;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public float f1829f = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public float f1830g = Float.NaN;

    /* renamed from: h  reason: collision with root package name */
    ViewOutlineProvider f1831h;

    /* renamed from: i  reason: collision with root package name */
    RectF f1832i;

    /* renamed from: j  reason: collision with root package name */
    private float f1833j = 48.0f;

    /* renamed from: k  reason: collision with root package name */
    private float f1834k = Float.NaN;

    /* renamed from: l  reason: collision with root package name */
    private int f1835l;

    /* renamed from: m  reason: collision with root package name */
    private int f1836m;

    /* renamed from: n  reason: collision with root package name */
    private float f1837n = 0.0f;

    /* renamed from: o  reason: collision with root package name */
    private String f1838o = "Hello World";

    /* renamed from: p  reason: collision with root package name */
    boolean f1839p = true;

    /* renamed from: q  reason: collision with root package name */
    private Rect f1840q = new Rect();

    /* renamed from: r  reason: collision with root package name */
    private int f1841r = 1;

    /* renamed from: s  reason: collision with root package name */
    private int f1842s = 1;

    /* renamed from: t  reason: collision with root package name */
    private int f1843t = 1;

    /* renamed from: u  reason: collision with root package name */
    private int f1844u = 1;

    /* renamed from: v  reason: collision with root package name */
    private String f1845v;

    /* renamed from: w  reason: collision with root package name */
    private Layout f1846w;

    /* renamed from: x  reason: collision with root package name */
    private int f1847x = 8388659;

    /* renamed from: y  reason: collision with root package name */
    private int f1848y = 0;

    /* renamed from: z  reason: collision with root package name */
    private boolean f1849z = false;

    class a extends ViewOutlineProvider {
        a() {
        }

        public void getOutline(View view, Outline outline) {
            int width = MotionLabel.this.getWidth();
            int height = MotionLabel.this.getHeight();
            outline.setRoundRect(0, 0, width, height, (((float) Math.min(width, height)) * MotionLabel.this.f1829f) / 2.0f);
        }
    }

    class b extends ViewOutlineProvider {
        b() {
        }

        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, MotionLabel.this.getWidth(), MotionLabel.this.getHeight(), MotionLabel.this.f1830g);
        }
    }

    public MotionLabel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        g(context, attributeSet);
    }

    public MotionLabel(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        g(context, attributeSet);
    }

    private void d(float f10, float f11, float f12, float f13) {
        if (this.H != null) {
            this.B = f12 - f10;
            this.C = f13 - f11;
            l();
        }
    }

    private void g(Context context, AttributeSet attributeSet) {
        i(context, attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, f.MotionLabel);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == f.MotionLabel_android_text) {
                    setText(obtainStyledAttributes.getText(index));
                } else if (index == f.MotionLabel_android_fontFamily) {
                    this.f1845v = obtainStyledAttributes.getString(index);
                } else if (index == f.MotionLabel_scaleFromTextSize) {
                    this.f1834k = (float) obtainStyledAttributes.getDimensionPixelSize(index, (int) this.f1834k);
                } else if (index == f.MotionLabel_android_textSize) {
                    this.f1833j = (float) obtainStyledAttributes.getDimensionPixelSize(index, (int) this.f1833j);
                } else if (index == f.MotionLabel_android_textStyle) {
                    this.f1835l = obtainStyledAttributes.getInt(index, this.f1835l);
                } else if (index == f.MotionLabel_android_typeface) {
                    this.f1836m = obtainStyledAttributes.getInt(index, this.f1836m);
                } else if (index == f.MotionLabel_android_textColor) {
                    this.f1826c = obtainStyledAttributes.getColor(index, this.f1826c);
                } else if (index == f.MotionLabel_borderRound) {
                    float dimension = obtainStyledAttributes.getDimension(index, this.f1830g);
                    this.f1830g = dimension;
                    if (Build.VERSION.SDK_INT >= 21) {
                        setRound(dimension);
                    }
                } else if (index == f.MotionLabel_borderRoundPercent) {
                    float f10 = obtainStyledAttributes.getFloat(index, this.f1829f);
                    this.f1829f = f10;
                    if (Build.VERSION.SDK_INT >= 21) {
                        setRoundPercent(f10);
                    }
                } else if (index == f.MotionLabel_android_gravity) {
                    setGravity(obtainStyledAttributes.getInt(index, -1));
                } else if (index == f.MotionLabel_android_autoSizeTextType) {
                    this.f1848y = obtainStyledAttributes.getInt(index, 0);
                } else {
                    if (index == f.MotionLabel_textOutlineColor) {
                        this.f1827d = obtainStyledAttributes.getInt(index, this.f1827d);
                    } else if (index == f.MotionLabel_textOutlineThickness) {
                        this.f1837n = obtainStyledAttributes.getDimension(index, this.f1837n);
                    } else if (index == f.MotionLabel_textBackground) {
                        this.D = obtainStyledAttributes.getDrawable(index);
                    } else if (index == f.MotionLabel_textBackgroundPanX) {
                        this.R = obtainStyledAttributes.getFloat(index, this.R);
                    } else if (index == f.MotionLabel_textBackgroundPanY) {
                        this.S = obtainStyledAttributes.getFloat(index, this.S);
                    } else if (index == f.MotionLabel_textPanX) {
                        this.K = obtainStyledAttributes.getFloat(index, this.K);
                    } else if (index == f.MotionLabel_textPanY) {
                        this.L = obtainStyledAttributes.getFloat(index, this.L);
                    } else if (index == f.MotionLabel_textBackgroundRotate) {
                        this.U = obtainStyledAttributes.getFloat(index, this.U);
                    } else if (index == f.MotionLabel_textBackgroundZoom) {
                        this.T = obtainStyledAttributes.getFloat(index, this.T);
                    } else if (index == f.MotionLabel_textureHeight) {
                        this.I = obtainStyledAttributes.getDimension(index, this.I);
                    } else if (index == f.MotionLabel_textureWidth) {
                        this.J = obtainStyledAttributes.getDimension(index, this.J);
                    } else if (index == f.MotionLabel_textureEffect) {
                        this.N = obtainStyledAttributes.getInt(index, this.N);
                    }
                    this.f1828e = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
        k();
        j();
    }

    private float getHorizontalOffset() {
        float f10 = Float.isNaN(this.f1834k) ? 1.0f : this.f1833j / this.f1834k;
        TextPaint textPaint = this.f1824a;
        String str = this.f1838o;
        return (((((Float.isNaN(this.B) ? (float) getMeasuredWidth() : this.B) - ((float) getPaddingLeft())) - ((float) getPaddingRight())) - (f10 * textPaint.measureText(str, 0, str.length()))) * (this.K + 1.0f)) / 2.0f;
    }

    private float getVerticalOffset() {
        float f10 = Float.isNaN(this.f1834k) ? 1.0f : this.f1833j / this.f1834k;
        Paint.FontMetrics fontMetrics = this.f1824a.getFontMetrics();
        float measuredHeight = ((Float.isNaN(this.C) ? (float) getMeasuredHeight() : this.C) - ((float) getPaddingTop())) - ((float) getPaddingBottom());
        float f11 = fontMetrics.descent;
        float f12 = fontMetrics.ascent;
        return (((measuredHeight - ((f11 - f12) * f10)) * (1.0f - this.L)) / 2.0f) - (f10 * f12);
    }

    private void h(String str, int i10, int i11) {
        Typeface typeface;
        if (str != null) {
            typeface = Typeface.create(str, i11);
            if (typeface != null) {
                setTypeface(typeface);
                return;
            }
        } else {
            typeface = null;
        }
        boolean z10 = true;
        if (i10 == 1) {
            typeface = Typeface.SANS_SERIF;
        } else if (i10 == 2) {
            typeface = Typeface.SERIF;
        } else if (i10 == 3) {
            typeface = Typeface.MONOSPACE;
        }
        float f10 = 0.0f;
        if (i11 > 0) {
            Typeface defaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i11) : Typeface.create(typeface, i11);
            setTypeface(defaultFromStyle);
            int i12 = (~(defaultFromStyle != null ? defaultFromStyle.getStyle() : 0)) & i11;
            TextPaint textPaint = this.f1824a;
            if ((i12 & 1) == 0) {
                z10 = false;
            }
            textPaint.setFakeBoldText(z10);
            TextPaint textPaint2 = this.f1824a;
            if ((i12 & 2) != 0) {
                f10 = -0.25f;
            }
            textPaint2.setTextSkewX(f10);
            return;
        }
        this.f1824a.setFakeBoldText(false);
        this.f1824a.setTextSkewX(0.0f);
        setTypeface(typeface);
    }

    private void i(Context context, AttributeSet attributeSet) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(j.a.colorPrimary, typedValue, true);
        TextPaint textPaint = this.f1824a;
        int i10 = typedValue.data;
        this.f1826c = i10;
        textPaint.setColor(i10);
    }

    private void k() {
        if (this.D != null) {
            this.H = new Matrix();
            int intrinsicWidth = this.D.getIntrinsicWidth();
            int intrinsicHeight = this.D.getIntrinsicHeight();
            int i10 = 128;
            if (intrinsicWidth <= 0 && (intrinsicWidth = getWidth()) == 0) {
                intrinsicWidth = Float.isNaN(this.J) ? 128 : (int) this.J;
            }
            if (intrinsicHeight <= 0 && (intrinsicHeight = getHeight()) == 0) {
                if (!Float.isNaN(this.I)) {
                    i10 = (int) this.I;
                }
                intrinsicHeight = i10;
            }
            if (this.N != 0) {
                intrinsicWidth /= 2;
                intrinsicHeight /= 2;
            }
            this.F = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.F);
            this.D.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            this.D.setFilterBitmap(true);
            this.D.draw(canvas);
            if (this.N != 0) {
                this.F = e(this.F, 4);
            }
            Bitmap bitmap = this.F;
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            this.G = new BitmapShader(bitmap, tileMode, tileMode);
        }
    }

    private void l() {
        float f10 = 0.0f;
        float f11 = Float.isNaN(this.R) ? 0.0f : this.R;
        float f12 = Float.isNaN(this.S) ? 0.0f : this.S;
        float f13 = Float.isNaN(this.T) ? 1.0f : this.T;
        if (!Float.isNaN(this.U)) {
            f10 = this.U;
        }
        this.H.reset();
        float width = (float) this.F.getWidth();
        float height = (float) this.F.getHeight();
        float f14 = Float.isNaN(this.J) ? this.B : this.J;
        float f15 = Float.isNaN(this.I) ? this.C : this.I;
        float f16 = f13 * (width * f15 < height * f14 ? f14 / width : f15 / height);
        this.H.postScale(f16, f16);
        float f17 = width * f16;
        float f18 = f14 - f17;
        float f19 = f16 * height;
        float f20 = f15 - f19;
        if (!Float.isNaN(this.I)) {
            f20 = this.I / 2.0f;
        }
        if (!Float.isNaN(this.J)) {
            f18 = this.J / 2.0f;
        }
        this.H.postTranslate((((f11 * f18) + f14) - f17) * 0.5f, (((f12 * f20) + f15) - f19) * 0.5f);
        this.H.postRotate(f10, f14 / 2.0f, f15 / 2.0f);
        this.G.setLocalMatrix(this.H);
    }

    public void a(float f10, float f11, float f12, float f13) {
        int i10 = (int) (f10 + 0.5f);
        this.A = f10 - ((float) i10);
        int i11 = (int) (f12 + 0.5f);
        int i12 = i11 - i10;
        int i13 = (int) (f13 + 0.5f);
        int i14 = (int) (0.5f + f11);
        int i15 = i13 - i14;
        float f14 = f12 - f10;
        this.B = f14;
        float f15 = f13 - f11;
        this.C = f15;
        d(f10, f11, f12, f13);
        if (!(getMeasuredHeight() == i15 && getMeasuredWidth() == i12)) {
            measure(View.MeasureSpec.makeMeasureSpec(i12, 1073741824), View.MeasureSpec.makeMeasureSpec(i15, 1073741824));
        }
        super.layout(i10, i14, i11, i13);
        if (this.f1849z) {
            if (this.O == null) {
                this.P = new Paint();
                this.O = new Rect();
                this.P.set(this.f1824a);
                this.Q = this.P.getTextSize();
            }
            this.B = f14;
            this.C = f15;
            Paint paint = this.P;
            String str = this.f1838o;
            paint.getTextBounds(str, 0, str.length(), this.O);
            int width = this.O.width();
            float height = ((float) this.O.height()) * 1.3f;
            float f16 = (f14 - ((float) this.f1842s)) - ((float) this.f1841r);
            float f17 = (f15 - ((float) this.f1844u)) - ((float) this.f1843t);
            float f18 = (float) width;
            if (f18 * f17 > height * f16) {
                this.f1824a.setTextSize((this.Q * f16) / f18);
            } else {
                this.f1824a.setTextSize((this.Q * f17) / height);
            }
            if (this.f1828e || !Float.isNaN(this.f1834k)) {
                f(Float.isNaN(this.f1834k) ? 1.0f : this.f1833j / this.f1834k);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Bitmap e(Bitmap bitmap, int i10) {
        System.nanoTime();
        int width = bitmap.getWidth() / 2;
        int height = bitmap.getHeight() / 2;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
        for (int i11 = 0; i11 < i10 && width >= 32 && height >= 32; i11++) {
            width /= 2;
            height /= 2;
            createScaledBitmap = Bitmap.createScaledBitmap(createScaledBitmap, width, height, true);
        }
        return createScaledBitmap;
    }

    /* access modifiers changed from: package-private */
    public void f(float f10) {
        if (this.f1828e || f10 != 1.0f) {
            this.f1825b.reset();
            String str = this.f1838o;
            int length = str.length();
            this.f1824a.getTextBounds(str, 0, length, this.f1840q);
            this.f1824a.getTextPath(str, 0, length, 0.0f, 0.0f, this.f1825b);
            if (f10 != 1.0f) {
                Log.v(V, androidx.constraintlayout.motion.widget.a.a() + " scale " + f10);
                Matrix matrix = new Matrix();
                matrix.postScale(f10, f10);
                this.f1825b.transform(matrix);
            }
            Rect rect = this.f1840q;
            rect.right--;
            rect.left++;
            rect.bottom++;
            rect.top--;
            RectF rectF = new RectF();
            rectF.bottom = (float) getHeight();
            rectF.right = (float) getWidth();
            this.f1839p = false;
        }
    }

    public float getRound() {
        return this.f1830g;
    }

    public float getRoundPercent() {
        return this.f1829f;
    }

    public float getScaleFromTextSize() {
        return this.f1834k;
    }

    public float getTextBackgroundPanX() {
        return this.R;
    }

    public float getTextBackgroundPanY() {
        return this.S;
    }

    public float getTextBackgroundRotate() {
        return this.U;
    }

    public float getTextBackgroundZoom() {
        return this.T;
    }

    public int getTextOutlineColor() {
        return this.f1827d;
    }

    public float getTextPanX() {
        return this.K;
    }

    public float getTextPanY() {
        return this.L;
    }

    public float getTextureHeight() {
        return this.I;
    }

    public float getTextureWidth() {
        return this.J;
    }

    public Typeface getTypeface() {
        return this.f1824a.getTypeface();
    }

    /* access modifiers changed from: package-private */
    public void j() {
        this.f1841r = getPaddingLeft();
        this.f1842s = getPaddingRight();
        this.f1843t = getPaddingTop();
        this.f1844u = getPaddingBottom();
        h(this.f1845v, this.f1836m, this.f1835l);
        this.f1824a.setColor(this.f1826c);
        this.f1824a.setStrokeWidth(this.f1837n);
        this.f1824a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f1824a.setFlags(128);
        setTextSize(this.f1833j);
        this.f1824a.setAntiAlias(true);
    }

    public void layout(int i10, int i11, int i12, int i13) {
        super.layout(i10, i11, i12, i13);
        boolean isNaN = Float.isNaN(this.f1834k);
        float f10 = isNaN ? 1.0f : this.f1833j / this.f1834k;
        this.B = (float) (i12 - i10);
        this.C = (float) (i13 - i11);
        if (this.f1849z) {
            if (this.O == null) {
                this.P = new Paint();
                this.O = new Rect();
                this.P.set(this.f1824a);
                this.Q = this.P.getTextSize();
            }
            Paint paint = this.P;
            String str = this.f1838o;
            paint.getTextBounds(str, 0, str.length(), this.O);
            int width = this.O.width();
            int height = (int) (((float) this.O.height()) * 1.3f);
            float f11 = (this.B - ((float) this.f1842s)) - ((float) this.f1841r);
            float f12 = (this.C - ((float) this.f1844u)) - ((float) this.f1843t);
            if (isNaN) {
                float f13 = (float) width;
                float f14 = (float) height;
                if (f13 * f12 > f14 * f11) {
                    this.f1824a.setTextSize((this.Q * f11) / f13);
                } else {
                    this.f1824a.setTextSize((this.Q * f12) / f14);
                }
            } else {
                float f15 = (float) width;
                float f16 = (float) height;
                f10 = f15 * f12 > f16 * f11 ? f11 / f15 : f12 / f16;
            }
        }
        if (this.f1828e || !isNaN) {
            d((float) i10, (float) i11, (float) i12, (float) i13);
            f(f10);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f10 = Float.isNaN(this.f1834k) ? 1.0f : this.f1833j / this.f1834k;
        super.onDraw(canvas);
        if (this.f1828e || f10 != 1.0f) {
            if (this.f1839p) {
                f(f10);
            }
            if (this.E == null) {
                this.E = new Matrix();
            }
            if (this.f1828e) {
                this.M.set(this.f1824a);
                this.E.reset();
                float horizontalOffset = ((float) this.f1841r) + getHorizontalOffset();
                float verticalOffset = ((float) this.f1843t) + getVerticalOffset();
                this.E.postTranslate(horizontalOffset, verticalOffset);
                this.E.preScale(f10, f10);
                this.f1825b.transform(this.E);
                if (this.G != null) {
                    this.f1824a.setFilterBitmap(true);
                    this.f1824a.setShader(this.G);
                } else {
                    this.f1824a.setColor(this.f1826c);
                }
                this.f1824a.setStyle(Paint.Style.FILL);
                this.f1824a.setStrokeWidth(this.f1837n);
                canvas.drawPath(this.f1825b, this.f1824a);
                if (this.G != null) {
                    this.f1824a.setShader((Shader) null);
                }
                this.f1824a.setColor(this.f1827d);
                this.f1824a.setStyle(Paint.Style.STROKE);
                this.f1824a.setStrokeWidth(this.f1837n);
                canvas.drawPath(this.f1825b, this.f1824a);
                this.E.reset();
                this.E.postTranslate(-horizontalOffset, -verticalOffset);
                this.f1825b.transform(this.E);
                this.f1824a.set(this.M);
                return;
            }
            float horizontalOffset2 = ((float) this.f1841r) + getHorizontalOffset();
            float verticalOffset2 = ((float) this.f1843t) + getVerticalOffset();
            this.E.reset();
            this.E.preTranslate(horizontalOffset2, verticalOffset2);
            this.f1825b.transform(this.E);
            this.f1824a.setColor(this.f1826c);
            this.f1824a.setStyle(Paint.Style.FILL_AND_STROKE);
            this.f1824a.setStrokeWidth(this.f1837n);
            canvas.drawPath(this.f1825b, this.f1824a);
            this.E.reset();
            this.E.preTranslate(-horizontalOffset2, -verticalOffset2);
            this.f1825b.transform(this.E);
            return;
        }
        canvas.drawText(this.f1838o, this.A + ((float) this.f1841r) + getHorizontalOffset(), ((float) this.f1843t) + getVerticalOffset(), this.f1824a);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        this.f1849z = false;
        this.f1841r = getPaddingLeft();
        this.f1842s = getPaddingRight();
        this.f1843t = getPaddingTop();
        this.f1844u = getPaddingBottom();
        if (mode != 1073741824 || mode2 != 1073741824) {
            TextPaint textPaint = this.f1824a;
            String str = this.f1838o;
            textPaint.getTextBounds(str, 0, str.length(), this.f1840q);
            if (mode != 1073741824) {
                size = (int) (((float) this.f1840q.width()) + 0.99999f);
            }
            size += this.f1841r + this.f1842s;
            if (mode2 != 1073741824) {
                int fontMetricsInt = (int) (((float) this.f1824a.getFontMetricsInt((Paint.FontMetricsInt) null)) + 0.99999f);
                if (mode2 == Integer.MIN_VALUE) {
                    fontMetricsInt = Math.min(size2, fontMetricsInt);
                }
                size2 = this.f1843t + this.f1844u + fontMetricsInt;
            }
        } else if (this.f1848y != 0) {
            this.f1849z = true;
        }
        setMeasuredDimension(size, size2);
    }

    @SuppressLint({"RtlHardcoded"})
    public void setGravity(int i10) {
        if ((i10 & 8388615) == 0) {
            i10 |= 8388611;
        }
        if ((i10 & 112) == 0) {
            i10 |= 48;
        }
        if (i10 != this.f1847x) {
            invalidate();
        }
        this.f1847x = i10;
        int i11 = i10 & 112;
        if (i11 == 48) {
            this.L = -1.0f;
        } else if (i11 != 80) {
            this.L = 0.0f;
        } else {
            this.L = 1.0f;
        }
        int i12 = i10 & 8388615;
        if (i12 != 3) {
            if (i12 != 5) {
                if (i12 != 8388611) {
                    if (i12 != 8388613) {
                        this.K = 0.0f;
                        return;
                    }
                }
            }
            this.K = 1.0f;
            return;
        }
        this.K = -1.0f;
    }

    public void setRound(float f10) {
        if (Float.isNaN(f10)) {
            this.f1830g = f10;
            float f11 = this.f1829f;
            this.f1829f = -1.0f;
            setRoundPercent(f11);
            return;
        }
        boolean z10 = this.f1830g != f10;
        this.f1830g = f10;
        if (f10 != 0.0f) {
            if (this.f1825b == null) {
                this.f1825b = new Path();
            }
            if (this.f1832i == null) {
                this.f1832i = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.f1831h == null) {
                    b bVar = new b();
                    this.f1831h = bVar;
                    setOutlineProvider(bVar);
                }
                setClipToOutline(true);
            }
            this.f1832i.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.f1825b.reset();
            Path path = this.f1825b;
            RectF rectF = this.f1832i;
            float f12 = this.f1830g;
            path.addRoundRect(rectF, f12, f12, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(false);
        }
        if (z10 && Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f10) {
        boolean z10 = this.f1829f != f10;
        this.f1829f = f10;
        if (f10 != 0.0f) {
            if (this.f1825b == null) {
                this.f1825b = new Path();
            }
            if (this.f1832i == null) {
                this.f1832i = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.f1831h == null) {
                    a aVar = new a();
                    this.f1831h = aVar;
                    setOutlineProvider(aVar);
                }
                setClipToOutline(true);
            }
            int width = getWidth();
            int height = getHeight();
            float min = (((float) Math.min(width, height)) * this.f1829f) / 2.0f;
            this.f1832i.set(0.0f, 0.0f, (float) width, (float) height);
            this.f1825b.reset();
            this.f1825b.addRoundRect(this.f1832i, min, min, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(false);
        }
        if (z10 && Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setScaleFromTextSize(float f10) {
        this.f1834k = f10;
    }

    public void setText(CharSequence charSequence) {
        this.f1838o = charSequence.toString();
        invalidate();
    }

    public void setTextBackgroundPanX(float f10) {
        this.R = f10;
        l();
        invalidate();
    }

    public void setTextBackgroundPanY(float f10) {
        this.S = f10;
        l();
        invalidate();
    }

    public void setTextBackgroundRotate(float f10) {
        this.U = f10;
        l();
        invalidate();
    }

    public void setTextBackgroundZoom(float f10) {
        this.T = f10;
        l();
        invalidate();
    }

    public void setTextFillColor(int i10) {
        this.f1826c = i10;
        invalidate();
    }

    public void setTextOutlineColor(int i10) {
        this.f1827d = i10;
        this.f1828e = true;
        invalidate();
    }

    public void setTextOutlineThickness(float f10) {
        this.f1837n = f10;
        this.f1828e = true;
        if (Float.isNaN(f10)) {
            this.f1837n = 1.0f;
            this.f1828e = false;
        }
        invalidate();
    }

    public void setTextPanX(float f10) {
        this.K = f10;
        invalidate();
    }

    public void setTextPanY(float f10) {
        this.L = f10;
        invalidate();
    }

    public void setTextSize(float f10) {
        this.f1833j = f10;
        String str = V;
        Log.v(str, androidx.constraintlayout.motion.widget.a.a() + "  " + f10 + " / " + this.f1834k);
        TextPaint textPaint = this.f1824a;
        if (!Float.isNaN(this.f1834k)) {
            f10 = this.f1834k;
        }
        textPaint.setTextSize(f10);
        f(Float.isNaN(this.f1834k) ? 1.0f : this.f1833j / this.f1834k);
        requestLayout();
        invalidate();
    }

    public void setTextureHeight(float f10) {
        this.I = f10;
        l();
        invalidate();
    }

    public void setTextureWidth(float f10) {
        this.J = f10;
        l();
        invalidate();
    }

    public void setTypeface(Typeface typeface) {
        if (this.f1824a.getTypeface() != typeface) {
            this.f1824a.setTypeface(typeface);
            if (this.f1846w != null) {
                this.f1846w = null;
                requestLayout();
                invalidate();
            }
        }
    }
}
