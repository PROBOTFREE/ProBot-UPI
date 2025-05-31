package androidx.viewpager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

public class PagerTabStrip extends PagerTitleStrip {
    private boolean A = false;
    private int B;
    private boolean C;
    private float D;
    private float E;
    private int F;

    /* renamed from: q  reason: collision with root package name */
    private int f4289q;

    /* renamed from: r  reason: collision with root package name */
    private int f4290r;

    /* renamed from: s  reason: collision with root package name */
    private int f4291s;

    /* renamed from: t  reason: collision with root package name */
    private int f4292t;

    /* renamed from: u  reason: collision with root package name */
    private int f4293u;

    /* renamed from: v  reason: collision with root package name */
    private int f4294v;

    /* renamed from: w  reason: collision with root package name */
    private final Paint f4295w;

    /* renamed from: x  reason: collision with root package name */
    private final Rect f4296x = new Rect();

    /* renamed from: y  reason: collision with root package name */
    private int f4297y = 255;

    /* renamed from: z  reason: collision with root package name */
    private boolean f4298z = false;

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            ViewPager viewPager = PagerTabStrip.this.f4303a;
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View view) {
            ViewPager viewPager = PagerTabStrip.this.f4303a;
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        }
    }

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.f4295w = paint;
        int i10 = this.f4316n;
        this.f4289q = i10;
        paint.setColor(i10);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.f4290r = (int) ((3.0f * f10) + 0.5f);
        this.f4291s = (int) ((6.0f * f10) + 0.5f);
        this.f4292t = (int) (64.0f * f10);
        this.f4294v = (int) ((16.0f * f10) + 0.5f);
        this.B = (int) ((1.0f * f10) + 0.5f);
        this.f4293u = (int) ((f10 * 32.0f) + 0.5f);
        this.F = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.f4304b.setFocusable(true);
        this.f4304b.setOnClickListener(new a());
        this.f4306d.setFocusable(true);
        this.f4306d.setOnClickListener(new b());
        if (getBackground() == null) {
            this.f4298z = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void d(int i10, float f10, boolean z10) {
        Rect rect = this.f4296x;
        int height = getHeight();
        int left = this.f4305c.getLeft() - this.f4294v;
        int right = this.f4305c.getRight() + this.f4294v;
        int i11 = height - this.f4290r;
        rect.set(left, i11, right, height);
        super.d(i10, f10, z10);
        this.f4297y = (int) (Math.abs(f10 - 0.5f) * 2.0f * 255.0f);
        rect.union(this.f4305c.getLeft() - this.f4294v, i11, this.f4305c.getRight() + this.f4294v, height);
        invalidate(rect);
    }

    public boolean getDrawFullUnderline() {
        return this.f4298z;
    }

    /* access modifiers changed from: package-private */
    public int getMinHeight() {
        return Math.max(super.getMinHeight(), this.f4293u);
    }

    public int getTabIndicatorColor() {
        return this.f4289q;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.f4305c.getLeft() - this.f4294v;
        int right = this.f4305c.getRight() + this.f4294v;
        this.f4295w.setColor((this.f4297y << 24) | (this.f4289q & 16777215));
        float f10 = (float) height;
        canvas.drawRect((float) left, (float) (height - this.f4290r), (float) right, f10, this.f4295w);
        if (this.f4298z) {
            this.f4295w.setColor(-16777216 | (this.f4289q & 16777215));
            canvas.drawRect((float) getPaddingLeft(), (float) (height - this.B), (float) (getWidth() - getPaddingRight()), f10, this.f4295w);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewPager viewPager;
        int currentItem;
        int action = motionEvent.getAction();
        if (action != 0 && this.C) {
            return false;
        }
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        if (action == 0) {
            this.D = x10;
            this.E = y10;
            this.C = false;
        } else if (action == 1) {
            if (x10 < ((float) (this.f4305c.getLeft() - this.f4294v))) {
                viewPager = this.f4303a;
                currentItem = viewPager.getCurrentItem() - 1;
            } else if (x10 > ((float) (this.f4305c.getRight() + this.f4294v))) {
                viewPager = this.f4303a;
                currentItem = viewPager.getCurrentItem() + 1;
            }
            viewPager.setCurrentItem(currentItem);
        } else if (action == 2 && (Math.abs(x10 - this.D) > ((float) this.F) || Math.abs(y10 - this.E) > ((float) this.F))) {
            this.C = true;
        }
        return true;
    }

    public void setBackgroundColor(int i10) {
        super.setBackgroundColor(i10);
        if (!this.A) {
            this.f4298z = (i10 & -16777216) == 0;
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (!this.A) {
            this.f4298z = drawable == null;
        }
    }

    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        if (!this.A) {
            this.f4298z = i10 == 0;
        }
    }

    public void setDrawFullUnderline(boolean z10) {
        this.f4298z = z10;
        this.A = true;
        invalidate();
    }

    public void setPadding(int i10, int i11, int i12, int i13) {
        int i14 = this.f4291s;
        if (i13 < i14) {
            i13 = i14;
        }
        super.setPadding(i10, i11, i12, i13);
    }

    public void setTabIndicatorColor(int i10) {
        this.f4289q = i10;
        this.f4295w.setColor(i10);
        invalidate();
    }

    public void setTabIndicatorColorResource(int i10) {
        setTabIndicatorColor(androidx.core.content.a.d(getContext(), i10));
    }

    public void setTextSpacing(int i10) {
        int i11 = this.f4292t;
        if (i10 < i11) {
            i10 = i11;
        }
        super.setTextSpacing(i10);
    }
}
