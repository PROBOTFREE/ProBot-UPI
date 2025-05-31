package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import b0.b;
import b0.c;

class g extends Drawable {

    /* renamed from: q  reason: collision with root package name */
    private static final double f1329q = Math.cos(Math.toRadians(45.0d));

    /* renamed from: r  reason: collision with root package name */
    static a f1330r;

    /* renamed from: a  reason: collision with root package name */
    private final int f1331a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f1332b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f1333c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f1334d;

    /* renamed from: e  reason: collision with root package name */
    private final RectF f1335e;

    /* renamed from: f  reason: collision with root package name */
    private float f1336f;

    /* renamed from: g  reason: collision with root package name */
    private Path f1337g;

    /* renamed from: h  reason: collision with root package name */
    private float f1338h;

    /* renamed from: i  reason: collision with root package name */
    private float f1339i;

    /* renamed from: j  reason: collision with root package name */
    private float f1340j;

    /* renamed from: k  reason: collision with root package name */
    private ColorStateList f1341k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f1342l = true;

    /* renamed from: m  reason: collision with root package name */
    private final int f1343m;

    /* renamed from: n  reason: collision with root package name */
    private final int f1344n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f1345o = true;

    /* renamed from: p  reason: collision with root package name */
    private boolean f1346p = false;

    interface a {
        void a(Canvas canvas, RectF rectF, float f10, Paint paint);
    }

    g(Resources resources, ColorStateList colorStateList, float f10, float f11, float f12) {
        this.f1343m = resources.getColor(b.cardview_shadow_start_color);
        this.f1344n = resources.getColor(b.cardview_shadow_end_color);
        this.f1331a = resources.getDimensionPixelSize(c.cardview_compat_inset_shadow);
        this.f1332b = new Paint(5);
        n(colorStateList);
        Paint paint = new Paint(5);
        this.f1333c = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f1336f = (float) ((int) (f10 + 0.5f));
        this.f1335e = new RectF();
        Paint paint2 = new Paint(this.f1333c);
        this.f1334d = paint2;
        paint2.setAntiAlias(false);
        s(f11, f12);
    }

    private void a(Rect rect) {
        float f10 = this.f1338h;
        float f11 = 1.5f * f10;
        this.f1335e.set(((float) rect.left) + f10, ((float) rect.top) + f11, ((float) rect.right) - f10, ((float) rect.bottom) - f11);
        b();
    }

    private void b() {
        float f10 = this.f1336f;
        RectF rectF = new RectF(-f10, -f10, f10, f10);
        RectF rectF2 = new RectF(rectF);
        float f11 = this.f1339i;
        rectF2.inset(-f11, -f11);
        Path path = this.f1337g;
        if (path == null) {
            this.f1337g = new Path();
        } else {
            path.reset();
        }
        this.f1337g.setFillType(Path.FillType.EVEN_ODD);
        this.f1337g.moveTo(-this.f1336f, 0.0f);
        this.f1337g.rLineTo(-this.f1339i, 0.0f);
        this.f1337g.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f1337g.arcTo(rectF, 270.0f, -90.0f, false);
        this.f1337g.close();
        float f12 = this.f1336f;
        float f13 = f12 / (this.f1339i + f12);
        Paint paint = this.f1333c;
        float f14 = this.f1336f + this.f1339i;
        int i10 = this.f1343m;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f14, new int[]{i10, i10, this.f1344n}, new float[]{0.0f, f13, 1.0f}, Shader.TileMode.CLAMP));
        Paint paint2 = this.f1334d;
        float f15 = this.f1336f;
        float f16 = this.f1339i;
        int i11 = this.f1343m;
        paint2.setShader(new LinearGradient(0.0f, (-f15) + f16, 0.0f, (-f15) - f16, new int[]{i11, i11, this.f1344n}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f1334d.setAntiAlias(false);
    }

    static float c(float f10, float f11, boolean z10) {
        return z10 ? (float) (((double) f10) + ((1.0d - f1329q) * ((double) f11))) : f10;
    }

    static float d(float f10, float f11, boolean z10) {
        float f12 = f10 * 1.5f;
        return z10 ? (float) (((double) f12) + ((1.0d - f1329q) * ((double) f11))) : f12;
    }

    private void e(Canvas canvas) {
        float f10 = this.f1336f;
        float f11 = (-f10) - this.f1339i;
        float f12 = f10 + ((float) this.f1331a) + (this.f1340j / 2.0f);
        float f13 = f12 * 2.0f;
        boolean z10 = this.f1335e.width() - f13 > 0.0f;
        boolean z11 = this.f1335e.height() - f13 > 0.0f;
        int save = canvas.save();
        RectF rectF = this.f1335e;
        canvas.translate(rectF.left + f12, rectF.top + f12);
        canvas.drawPath(this.f1337g, this.f1333c);
        if (z10) {
            canvas.drawRect(0.0f, f11, this.f1335e.width() - f13, -this.f1336f, this.f1334d);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        RectF rectF2 = this.f1335e;
        canvas.translate(rectF2.right - f12, rectF2.bottom - f12);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f1337g, this.f1333c);
        if (z10) {
            canvas.drawRect(0.0f, f11, this.f1335e.width() - f13, (-this.f1336f) + this.f1339i, this.f1334d);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        RectF rectF3 = this.f1335e;
        canvas.translate(rectF3.left + f12, rectF3.bottom - f12);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f1337g, this.f1333c);
        if (z11) {
            canvas.drawRect(0.0f, f11, this.f1335e.height() - f13, -this.f1336f, this.f1334d);
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        RectF rectF4 = this.f1335e;
        canvas.translate(rectF4.right - f12, rectF4.top + f12);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f1337g, this.f1333c);
        if (z11) {
            canvas.drawRect(0.0f, f11, this.f1335e.height() - f13, -this.f1336f, this.f1334d);
        }
        canvas.restoreToCount(save4);
    }

    private void n(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f1341k = colorStateList;
        this.f1332b.setColor(colorStateList.getColorForState(getState(), this.f1341k.getDefaultColor()));
    }

    private void s(float f10, float f11) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f10 + ". Must be >= 0");
        } else if (f11 >= 0.0f) {
            float t10 = (float) t(f10);
            float t11 = (float) t(f11);
            if (t10 > t11) {
                if (!this.f1346p) {
                    this.f1346p = true;
                }
                t10 = t11;
            }
            if (this.f1340j != t10 || this.f1338h != t11) {
                this.f1340j = t10;
                this.f1338h = t11;
                this.f1339i = (float) ((int) ((t10 * 1.5f) + ((float) this.f1331a) + 0.5f));
                this.f1342l = true;
                invalidateSelf();
            }
        } else {
            throw new IllegalArgumentException("Invalid max shadow size " + f11 + ". Must be >= 0");
        }
    }

    private int t(float f10) {
        int i10 = (int) (f10 + 0.5f);
        return i10 % 2 == 1 ? i10 - 1 : i10;
    }

    public void draw(Canvas canvas) {
        if (this.f1342l) {
            a(getBounds());
            this.f1342l = false;
        }
        canvas.translate(0.0f, this.f1340j / 2.0f);
        e(canvas);
        canvas.translate(0.0f, (-this.f1340j) / 2.0f);
        f1330r.a(canvas, this.f1335e, this.f1336f, this.f1332b);
    }

    /* access modifiers changed from: package-private */
    public ColorStateList f() {
        return this.f1341k;
    }

    /* access modifiers changed from: package-private */
    public float g() {
        return this.f1336f;
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) d(this.f1338h, this.f1336f, this.f1345o));
        int ceil2 = (int) Math.ceil((double) c(this.f1338h, this.f1336f, this.f1345o));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void h(Rect rect) {
        getPadding(rect);
    }

    /* access modifiers changed from: package-private */
    public float i() {
        return this.f1338h;
    }

    public boolean isStateful() {
        ColorStateList colorStateList = this.f1341k;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    /* access modifiers changed from: package-private */
    public float j() {
        float f10 = this.f1338h;
        return (Math.max(f10, this.f1336f + ((float) this.f1331a) + ((f10 * 1.5f) / 2.0f)) * 2.0f) + (((this.f1338h * 1.5f) + ((float) this.f1331a)) * 2.0f);
    }

    /* access modifiers changed from: package-private */
    public float k() {
        float f10 = this.f1338h;
        return (Math.max(f10, this.f1336f + ((float) this.f1331a) + (f10 / 2.0f)) * 2.0f) + ((this.f1338h + ((float) this.f1331a)) * 2.0f);
    }

    /* access modifiers changed from: package-private */
    public float l() {
        return this.f1340j;
    }

    /* access modifiers changed from: package-private */
    public void m(boolean z10) {
        this.f1345o = z10;
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    public void o(ColorStateList colorStateList) {
        n(colorStateList);
        invalidateSelf();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f1342l = true;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.f1341k;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f1332b.getColor() == colorForState) {
            return false;
        }
        this.f1332b.setColor(colorForState);
        this.f1342l = true;
        invalidateSelf();
        return true;
    }

    /* access modifiers changed from: package-private */
    public void p(float f10) {
        if (f10 >= 0.0f) {
            float f11 = (float) ((int) (f10 + 0.5f));
            if (this.f1336f != f11) {
                this.f1336f = f11;
                this.f1342l = true;
                invalidateSelf();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid radius " + f10 + ". Must be >= 0");
    }

    /* access modifiers changed from: package-private */
    public void q(float f10) {
        s(this.f1340j, f10);
    }

    /* access modifiers changed from: package-private */
    public void r(float f10) {
        s(f10, this.f1338h);
    }

    public void setAlpha(int i10) {
        this.f1332b.setAlpha(i10);
        this.f1333c.setAlpha(i10);
        this.f1334d.setAlpha(i10);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1332b.setColorFilter(colorFilter);
    }
}
