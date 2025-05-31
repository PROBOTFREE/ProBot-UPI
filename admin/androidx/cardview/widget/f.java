package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

class f extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private float f1318a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f1319b;

    /* renamed from: c  reason: collision with root package name */
    private final RectF f1320c;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f1321d;

    /* renamed from: e  reason: collision with root package name */
    private float f1322e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1323f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1324g = true;

    /* renamed from: h  reason: collision with root package name */
    private ColorStateList f1325h;

    /* renamed from: i  reason: collision with root package name */
    private PorterDuffColorFilter f1326i;

    /* renamed from: j  reason: collision with root package name */
    private ColorStateList f1327j;

    /* renamed from: k  reason: collision with root package name */
    private PorterDuff.Mode f1328k = PorterDuff.Mode.SRC_IN;

    f(ColorStateList colorStateList, float f10) {
        this.f1318a = f10;
        this.f1319b = new Paint(5);
        e(colorStateList);
        this.f1320c = new RectF();
        this.f1321d = new Rect();
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    private void e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f1325h = colorStateList;
        this.f1319b.setColor(colorStateList.getColorForState(getState(), this.f1325h.getDefaultColor()));
    }

    private void i(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f1320c.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.f1321d.set(rect);
        if (this.f1323f) {
            float d10 = g.d(this.f1322e, this.f1318a, this.f1324g);
            this.f1321d.inset((int) Math.ceil((double) g.c(this.f1322e, this.f1318a, this.f1324g)), (int) Math.ceil((double) d10));
            this.f1320c.set(this.f1321d);
        }
    }

    public ColorStateList b() {
        return this.f1325h;
    }

    /* access modifiers changed from: package-private */
    public float c() {
        return this.f1322e;
    }

    public float d() {
        return this.f1318a;
    }

    public void draw(Canvas canvas) {
        boolean z10;
        Paint paint = this.f1319b;
        if (this.f1326i == null || paint.getColorFilter() != null) {
            z10 = false;
        } else {
            paint.setColorFilter(this.f1326i);
            z10 = true;
        }
        RectF rectF = this.f1320c;
        float f10 = this.f1318a;
        canvas.drawRoundRect(rectF, f10, f10, paint);
        if (z10) {
            paint.setColorFilter((ColorFilter) null);
        }
    }

    public void f(ColorStateList colorStateList) {
        e(colorStateList);
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    public void g(float f10, boolean z10, boolean z11) {
        if (f10 != this.f1322e || this.f1323f != z10 || this.f1324g != z11) {
            this.f1322e = f10;
            this.f1323f = z10;
            this.f1324g = z11;
            i((Rect) null);
            invalidateSelf();
        }
    }

    public int getOpacity() {
        return -3;
    }

    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f1321d, this.f1318a);
    }

    /* access modifiers changed from: package-private */
    public void h(float f10) {
        if (f10 != this.f1318a) {
            this.f1318a = f10;
            i((Rect) null);
            invalidateSelf();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.f1325h;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r1 = this;
            android.content.res.ColorStateList r0 = r1.f1327j
            if (r0 == 0) goto L_0x000a
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x001a
        L_0x000a:
            android.content.res.ColorStateList r0 = r1.f1325h
            if (r0 == 0) goto L_0x0014
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x001a
        L_0x0014:
            boolean r0 = super.isStateful()
            if (r0 == 0) goto L_0x001c
        L_0x001a:
            r0 = 1
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.cardview.widget.f.isStateful():boolean");
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        i(rect);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f1325h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z10 = colorForState != this.f1319b.getColor();
        if (z10) {
            this.f1319b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f1327j;
        if (colorStateList2 == null || (mode = this.f1328k) == null) {
            return z10;
        }
        this.f1326i = a(colorStateList2, mode);
        return true;
    }

    public void setAlpha(int i10) {
        this.f1319b.setAlpha(i10);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1319b.setColorFilter(colorFilter);
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f1327j = colorStateList;
        this.f1326i = a(colorStateList, this.f1328k);
        invalidateSelf();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.f1328k = mode;
        this.f1326i = a(this.f1327j, mode);
        invalidateSelf();
    }
}
