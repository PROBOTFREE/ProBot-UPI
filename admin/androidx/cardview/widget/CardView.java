package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import b0.b;
import b0.d;
import b0.e;

public class CardView extends FrameLayout {

    /* renamed from: h  reason: collision with root package name */
    private static final int[] f1305h = {16842801};

    /* renamed from: i  reason: collision with root package name */
    private static final e f1306i;

    /* renamed from: a  reason: collision with root package name */
    private boolean f1307a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1308b;

    /* renamed from: c  reason: collision with root package name */
    int f1309c;

    /* renamed from: d  reason: collision with root package name */
    int f1310d;

    /* renamed from: e  reason: collision with root package name */
    final Rect f1311e;

    /* renamed from: f  reason: collision with root package name */
    final Rect f1312f;

    /* renamed from: g  reason: collision with root package name */
    private final d f1313g;

    class a implements d {

        /* renamed from: a  reason: collision with root package name */
        private Drawable f1314a;

        a() {
        }

        public void a(int i10, int i11, int i12, int i13) {
            CardView.this.f1312f.set(i10, i11, i12, i13);
            CardView cardView = CardView.this;
            Rect rect = cardView.f1311e;
            CardView.super.setPadding(i10 + rect.left, i11 + rect.top, i12 + rect.right, i13 + rect.bottom);
        }

        public View b() {
            return CardView.this;
        }

        public void c(int i10, int i11) {
            CardView cardView = CardView.this;
            if (i10 > cardView.f1309c) {
                CardView.super.setMinimumWidth(i10);
            }
            CardView cardView2 = CardView.this;
            if (i11 > cardView2.f1310d) {
                CardView.super.setMinimumHeight(i11);
            }
        }

        public void d(Drawable drawable) {
            this.f1314a = drawable;
            CardView.this.setBackgroundDrawable(drawable);
        }

        public boolean e() {
            return CardView.this.getPreventCornerOverlap();
        }

        public boolean f() {
            return CardView.this.getUseCompatPadding();
        }

        public Drawable g() {
            return this.f1314a;
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        f1306i = i10 >= 21 ? new b() : i10 >= 17 ? new a() : new c();
        f1306i.g();
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b0.a.cardViewStyle);
    }

    public CardView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Resources resources;
        int i11;
        ColorStateList valueOf;
        Rect rect = new Rect();
        this.f1311e = rect;
        this.f1312f = new Rect();
        a aVar = new a();
        this.f1313g = aVar;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.CardView, i10, d.CardView);
        int i12 = e.CardView_cardBackgroundColor;
        if (obtainStyledAttributes.hasValue(i12)) {
            valueOf = obtainStyledAttributes.getColorStateList(i12);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(f1305h);
            int color = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            if (fArr[2] > 0.5f) {
                resources = getResources();
                i11 = b.cardview_light_background;
            } else {
                resources = getResources();
                i11 = b.cardview_dark_background;
            }
            valueOf = ColorStateList.valueOf(resources.getColor(i11));
        }
        ColorStateList colorStateList = valueOf;
        float dimension = obtainStyledAttributes.getDimension(e.CardView_cardCornerRadius, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(e.CardView_cardElevation, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(e.CardView_cardMaxElevation, 0.0f);
        this.f1307a = obtainStyledAttributes.getBoolean(e.CardView_cardUseCompatPadding, false);
        this.f1308b = obtainStyledAttributes.getBoolean(e.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(e.CardView_contentPadding, 0);
        rect.left = obtainStyledAttributes.getDimensionPixelSize(e.CardView_contentPaddingLeft, dimensionPixelSize);
        rect.top = obtainStyledAttributes.getDimensionPixelSize(e.CardView_contentPaddingTop, dimensionPixelSize);
        rect.right = obtainStyledAttributes.getDimensionPixelSize(e.CardView_contentPaddingRight, dimensionPixelSize);
        rect.bottom = obtainStyledAttributes.getDimensionPixelSize(e.CardView_contentPaddingBottom, dimensionPixelSize);
        float f10 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f1309c = obtainStyledAttributes.getDimensionPixelSize(e.CardView_android_minWidth, 0);
        this.f1310d = obtainStyledAttributes.getDimensionPixelSize(e.CardView_android_minHeight, 0);
        obtainStyledAttributes.recycle();
        f1306i.c(aVar, context, colorStateList, dimension, dimension2, f10);
    }

    public ColorStateList getCardBackgroundColor() {
        return f1306i.b(this.f1313g);
    }

    public float getCardElevation() {
        return f1306i.e(this.f1313g);
    }

    public int getContentPaddingBottom() {
        return this.f1311e.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f1311e.left;
    }

    public int getContentPaddingRight() {
        return this.f1311e.right;
    }

    public int getContentPaddingTop() {
        return this.f1311e.top;
    }

    public float getMaxCardElevation() {
        return f1306i.a(this.f1313g);
    }

    public boolean getPreventCornerOverlap() {
        return this.f1308b;
    }

    public float getRadius() {
        return f1306i.h(this.f1313g);
    }

    public boolean getUseCompatPadding() {
        return this.f1307a;
    }

    public void h(int i10, int i11, int i12, int i13) {
        this.f1311e.set(i10, i11, i12, i13);
        f1306i.f(this.f1313g);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        e eVar = f1306i;
        if (!(eVar instanceof b)) {
            int mode = View.MeasureSpec.getMode(i10);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i10 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) eVar.j(this.f1313g)), View.MeasureSpec.getSize(i10)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i11);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i11 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) eVar.i(this.f1313g)), View.MeasureSpec.getSize(i11)), mode2);
            }
        }
        super.onMeasure(i10, i11);
    }

    public void setCardBackgroundColor(int i10) {
        f1306i.n(this.f1313g, ColorStateList.valueOf(i10));
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f1306i.n(this.f1313g, colorStateList);
    }

    public void setCardElevation(float f10) {
        f1306i.l(this.f1313g, f10);
    }

    public void setMaxCardElevation(float f10) {
        f1306i.o(this.f1313g, f10);
    }

    public void setMinimumHeight(int i10) {
        this.f1310d = i10;
        super.setMinimumHeight(i10);
    }

    public void setMinimumWidth(int i10) {
        this.f1309c = i10;
        super.setMinimumWidth(i10);
    }

    public void setPadding(int i10, int i11, int i12, int i13) {
    }

    public void setPaddingRelative(int i10, int i11, int i12, int i13) {
    }

    public void setPreventCornerOverlap(boolean z10) {
        if (z10 != this.f1308b) {
            this.f1308b = z10;
            f1306i.m(this.f1313g);
        }
    }

    public void setRadius(float f10) {
        f1306i.d(this.f1313g, f10);
    }

    public void setUseCompatPadding(boolean z10) {
        if (this.f1307a != z10) {
            this.f1307a = z10;
            f1306i.k(this.f1313g);
        }
    }
}
