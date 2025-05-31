package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.core.widget.k;
import androidx.viewpager.widget.ViewPager;
import java.lang.ref.WeakReference;
import java.util.Locale;

@ViewPager.e
public class PagerTitleStrip extends ViewGroup {

    /* renamed from: o  reason: collision with root package name */
    private static final int[] f4301o = {16842804, 16842901, 16842904, 16842927};

    /* renamed from: p  reason: collision with root package name */
    private static final int[] f4302p = {16843660};

    /* renamed from: a  reason: collision with root package name */
    ViewPager f4303a;

    /* renamed from: b  reason: collision with root package name */
    TextView f4304b;

    /* renamed from: c  reason: collision with root package name */
    TextView f4305c;

    /* renamed from: d  reason: collision with root package name */
    TextView f4306d;

    /* renamed from: e  reason: collision with root package name */
    private int f4307e = -1;

    /* renamed from: f  reason: collision with root package name */
    float f4308f = -1.0f;

    /* renamed from: g  reason: collision with root package name */
    private int f4309g;

    /* renamed from: h  reason: collision with root package name */
    private int f4310h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f4311i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f4312j;

    /* renamed from: k  reason: collision with root package name */
    private final a f4313k = new a();

    /* renamed from: l  reason: collision with root package name */
    private WeakReference<a> f4314l;

    /* renamed from: m  reason: collision with root package name */
    private int f4315m;

    /* renamed from: n  reason: collision with root package name */
    int f4316n;

    private class a extends DataSetObserver implements ViewPager.i, ViewPager.h {

        /* renamed from: a  reason: collision with root package name */
        private int f4317a;

        a() {
        }

        public void a(int i10, float f10, int i11) {
            if (f10 > 0.5f) {
                i10++;
            }
            PagerTitleStrip.this.d(i10, f10, false);
        }

        public void b(int i10) {
            this.f4317a = i10;
        }

        public void c(int i10) {
            if (this.f4317a == 0) {
                PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
                pagerTitleStrip.c(pagerTitleStrip.f4303a.getCurrentItem(), PagerTitleStrip.this.f4303a.getAdapter());
                PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
                float f10 = pagerTitleStrip2.f4308f;
                if (f10 < 0.0f) {
                    f10 = 0.0f;
                }
                pagerTitleStrip2.d(pagerTitleStrip2.f4303a.getCurrentItem(), f10, true);
            }
        }

        public void d(ViewPager viewPager, a aVar, a aVar2) {
            PagerTitleStrip.this.b(aVar, aVar2);
        }

        public void onChanged() {
            PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
            pagerTitleStrip.c(pagerTitleStrip.f4303a.getCurrentItem(), PagerTitleStrip.this.f4303a.getAdapter());
            PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
            float f10 = pagerTitleStrip2.f4308f;
            if (f10 < 0.0f) {
                f10 = 0.0f;
            }
            pagerTitleStrip2.d(pagerTitleStrip2.f4303a.getCurrentItem(), f10, true);
        }
    }

    private static class b extends SingleLineTransformationMethod {

        /* renamed from: a  reason: collision with root package name */
        private Locale f4319a;

        b(Context context) {
            this.f4319a = context.getResources().getConfiguration().locale;
        }

        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.f4319a);
            }
            return null;
        }
    }

    public PagerTitleStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TextView textView = new TextView(context);
        this.f4304b = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.f4305c = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.f4306d = textView3;
        addView(textView3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f4301o);
        boolean z10 = false;
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            k.q(this.f4304b, resourceId);
            k.q(this.f4305c, resourceId);
            k.q(this.f4306d, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            a(0, (float) dimensionPixelSize);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            int color = obtainStyledAttributes.getColor(2, 0);
            this.f4304b.setTextColor(color);
            this.f4305c.setTextColor(color);
            this.f4306d.setTextColor(color);
        }
        this.f4310h = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.f4316n = this.f4305c.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        this.f4304b.setEllipsize(TextUtils.TruncateAt.END);
        this.f4305c.setEllipsize(TextUtils.TruncateAt.END);
        this.f4306d.setEllipsize(TextUtils.TruncateAt.END);
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, f4302p);
            z10 = obtainStyledAttributes2.getBoolean(0, false);
            obtainStyledAttributes2.recycle();
        }
        TextView textView4 = this.f4304b;
        if (z10) {
            setSingleLineAllCaps(textView4);
            setSingleLineAllCaps(this.f4305c);
            setSingleLineAllCaps(this.f4306d);
        } else {
            textView4.setSingleLine();
            this.f4305c.setSingleLine();
            this.f4306d.setSingleLine();
        }
        this.f4309g = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }

    private static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new b(textView.getContext()));
    }

    public void a(int i10, float f10) {
        this.f4304b.setTextSize(i10, f10);
        this.f4305c.setTextSize(i10, f10);
        this.f4306d.setTextSize(i10, f10);
    }

    /* access modifiers changed from: package-private */
    public void b(a aVar, a aVar2) {
        if (aVar != null) {
            aVar.unregisterDataSetObserver(this.f4313k);
            this.f4314l = null;
        }
        if (aVar2 != null) {
            aVar2.registerDataSetObserver(this.f4313k);
            this.f4314l = new WeakReference<>(aVar2);
        }
        ViewPager viewPager = this.f4303a;
        if (viewPager != null) {
            this.f4307e = -1;
            this.f4308f = -1.0f;
            c(viewPager.getCurrentItem(), aVar2);
            requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public void c(int i10, a aVar) {
        int count = aVar != null ? aVar.getCount() : 0;
        this.f4311i = true;
        CharSequence charSequence = null;
        this.f4304b.setText((i10 < 1 || aVar == null) ? null : aVar.getPageTitle(i10 - 1));
        this.f4305c.setText((aVar == null || i10 >= count) ? null : aVar.getPageTitle(i10));
        int i11 = i10 + 1;
        if (i11 < count && aVar != null) {
            charSequence = aVar.getPageTitle(i11);
        }
        this.f4306d.setText(charSequence);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((float) ((getWidth() - getPaddingLeft()) - getPaddingRight())) * 0.8f)), Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.f4304b.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f4305c.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f4306d.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f4307e = i10;
        if (!this.f4312j) {
            d(i10, this.f4308f, false);
        }
        this.f4311i = false;
    }

    /* access modifiers changed from: package-private */
    public void d(int i10, float f10, boolean z10) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15 = i10;
        float f11 = f10;
        if (i15 != this.f4307e) {
            c(i15, this.f4303a.getAdapter());
        } else if (!z10 && f11 == this.f4308f) {
            return;
        }
        this.f4312j = true;
        int measuredWidth = this.f4304b.getMeasuredWidth();
        int measuredWidth2 = this.f4305c.getMeasuredWidth();
        int measuredWidth3 = this.f4306d.getMeasuredWidth();
        int i16 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i17 = paddingRight + i16;
        int i18 = (width - (paddingLeft + i16)) - i17;
        float f12 = 0.5f + f11;
        if (f12 > 1.0f) {
            f12 -= 1.0f;
        }
        int i19 = ((width - i17) - ((int) (((float) i18) * f12))) - i16;
        int i20 = measuredWidth2 + i19;
        int baseline = this.f4304b.getBaseline();
        int baseline2 = this.f4305c.getBaseline();
        int baseline3 = this.f4306d.getBaseline();
        int max = Math.max(Math.max(baseline, baseline2), baseline3);
        int i21 = max - baseline;
        int i22 = max - baseline2;
        int i23 = max - baseline3;
        int i24 = measuredWidth3;
        int max2 = Math.max(Math.max(this.f4304b.getMeasuredHeight() + i21, this.f4305c.getMeasuredHeight() + i22), this.f4306d.getMeasuredHeight() + i23);
        int i25 = this.f4310h & 112;
        if (i25 == 16) {
            i14 = (((height - paddingTop) - paddingBottom) - max2) / 2;
        } else if (i25 != 80) {
            i13 = i21 + paddingTop;
            i11 = i22 + paddingTop;
            i12 = paddingTop + i23;
            TextView textView = this.f4305c;
            textView.layout(i19, i11, i20, textView.getMeasuredHeight() + i11);
            int min = Math.min(paddingLeft, (i19 - this.f4309g) - measuredWidth);
            TextView textView2 = this.f4304b;
            textView2.layout(min, i13, measuredWidth + min, textView2.getMeasuredHeight() + i13);
            int max3 = Math.max((width - paddingRight) - i24, i20 + this.f4309g);
            TextView textView3 = this.f4306d;
            textView3.layout(max3, i12, max3 + i24, textView3.getMeasuredHeight() + i12);
            this.f4308f = f10;
            this.f4312j = false;
        } else {
            i14 = (height - paddingBottom) - max2;
        }
        i13 = i21 + i14;
        i11 = i22 + i14;
        i12 = i14 + i23;
        TextView textView4 = this.f4305c;
        textView4.layout(i19, i11, i20, textView4.getMeasuredHeight() + i11);
        int min2 = Math.min(paddingLeft, (i19 - this.f4309g) - measuredWidth);
        TextView textView22 = this.f4304b;
        textView22.layout(min2, i13, measuredWidth + min2, textView22.getMeasuredHeight() + i13);
        int max32 = Math.max((width - paddingRight) - i24, i20 + this.f4309g);
        TextView textView32 = this.f4306d;
        textView32.layout(max32, i12, max32 + i24, textView32.getMeasuredHeight() + i12);
        this.f4308f = f10;
        this.f4312j = false;
    }

    /* access modifiers changed from: package-private */
    public int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    public int getTextSpacing() {
        return this.f4309g;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) parent;
            a adapter = viewPager.getAdapter();
            viewPager.setInternalPageChangeListener(this.f4313k);
            viewPager.addOnAdapterChangeListener(this.f4313k);
            this.f4303a = viewPager;
            WeakReference<a> weakReference = this.f4314l;
            b(weakReference != null ? (a) weakReference.get() : null, adapter);
            return;
        }
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.f4303a;
        if (viewPager != null) {
            b(viewPager.getAdapter(), (a) null);
            this.f4303a.setInternalPageChangeListener((ViewPager.i) null);
            this.f4303a.removeOnAdapterChangeListener(this.f4313k);
            this.f4303a = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (this.f4303a != null) {
            float f10 = this.f4308f;
            if (f10 < 0.0f) {
                f10 = 0.0f;
            }
            d(this.f4307e, f10, true);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        int i12;
        if (View.MeasureSpec.getMode(i10) == 1073741824) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i11, paddingTop, -2);
            int size = View.MeasureSpec.getSize(i10);
            int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i10, (int) (((float) size) * 0.2f), -2);
            this.f4304b.measure(childMeasureSpec2, childMeasureSpec);
            this.f4305c.measure(childMeasureSpec2, childMeasureSpec);
            this.f4306d.measure(childMeasureSpec2, childMeasureSpec);
            if (View.MeasureSpec.getMode(i11) == 1073741824) {
                i12 = View.MeasureSpec.getSize(i11);
            } else {
                i12 = Math.max(getMinHeight(), this.f4305c.getMeasuredHeight() + paddingTop);
            }
            setMeasuredDimension(size, View.resolveSizeAndState(i12, i11, this.f4305c.getMeasuredState() << 16));
            return;
        }
        throw new IllegalStateException("Must measure with an exact width");
    }

    public void requestLayout() {
        if (!this.f4311i) {
            super.requestLayout();
        }
    }

    public void setGravity(int i10) {
        this.f4310h = i10;
        requestLayout();
    }

    public void setNonPrimaryAlpha(float f10) {
        int i10 = ((int) (f10 * 255.0f)) & 255;
        this.f4315m = i10;
        int i11 = (i10 << 24) | (this.f4316n & 16777215);
        this.f4304b.setTextColor(i11);
        this.f4306d.setTextColor(i11);
    }

    public void setTextColor(int i10) {
        this.f4316n = i10;
        this.f4305c.setTextColor(i10);
        int i11 = (this.f4315m << 24) | (this.f4316n & 16777215);
        this.f4304b.setTextColor(i11);
        this.f4306d.setTextColor(i11);
    }

    public void setTextSpacing(int i10) {
        this.f4309g = i10;
        requestLayout();
    }
}
