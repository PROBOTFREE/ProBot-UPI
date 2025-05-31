package androidx.appcompat.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.core.view.x;
import com.android.volley.toolbox.k;
import j.h;
import j.j;

public class SwitchCompat extends CompoundButton {
    private static final Property<SwitchCompat, Float> N = new a(Float.class, "thumbPos");
    private static final int[] O = {16842912};
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private final TextPaint F;
    private ColorStateList G;
    private Layout H;
    private Layout I;
    private TransformationMethod J;
    ObjectAnimator K;
    private final m L;
    private final Rect M;

    /* renamed from: a  reason: collision with root package name */
    private Drawable f948a;

    /* renamed from: b  reason: collision with root package name */
    private ColorStateList f949b;

    /* renamed from: c  reason: collision with root package name */
    private PorterDuff.Mode f950c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f951d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f952e;

    /* renamed from: f  reason: collision with root package name */
    private Drawable f953f;

    /* renamed from: g  reason: collision with root package name */
    private ColorStateList f954g;

    /* renamed from: h  reason: collision with root package name */
    private PorterDuff.Mode f955h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f956i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f957j;

    /* renamed from: k  reason: collision with root package name */
    private int f958k;

    /* renamed from: l  reason: collision with root package name */
    private int f959l;

    /* renamed from: m  reason: collision with root package name */
    private int f960m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f961n;

    /* renamed from: o  reason: collision with root package name */
    private CharSequence f962o;

    /* renamed from: p  reason: collision with root package name */
    private CharSequence f963p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f964q;

    /* renamed from: r  reason: collision with root package name */
    private int f965r;

    /* renamed from: s  reason: collision with root package name */
    private int f966s;

    /* renamed from: t  reason: collision with root package name */
    private float f967t;

    /* renamed from: u  reason: collision with root package name */
    private float f968u;

    /* renamed from: v  reason: collision with root package name */
    private VelocityTracker f969v;

    /* renamed from: w  reason: collision with root package name */
    private int f970w;

    /* renamed from: x  reason: collision with root package name */
    float f971x;

    /* renamed from: y  reason: collision with root package name */
    private int f972y;

    /* renamed from: z  reason: collision with root package name */
    private int f973z;

    class a extends Property<SwitchCompat, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.f971x);
        }

        /* renamed from: b */
        public void set(SwitchCompat switchCompat, Float f10) {
            switchCompat.setThumbPosition(f10.floatValue());
        }
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, j.a.switchStyle);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f949b = null;
        this.f950c = null;
        this.f951d = false;
        this.f952e = false;
        this.f954g = null;
        this.f955h = null;
        this.f956i = false;
        this.f957j = false;
        this.f969v = VelocityTracker.obtain();
        this.M = new Rect();
        b0.a(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.F = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = j.SwitchCompat;
        g0 v10 = g0.v(context, attributeSet, iArr, i10, 0);
        x.p0(this, context, iArr, attributeSet, v10.r(), i10, 0);
        Drawable g10 = v10.g(j.SwitchCompat_android_thumb);
        this.f948a = g10;
        if (g10 != null) {
            g10.setCallback(this);
        }
        Drawable g11 = v10.g(j.SwitchCompat_track);
        this.f953f = g11;
        if (g11 != null) {
            g11.setCallback(this);
        }
        this.f962o = v10.p(j.SwitchCompat_android_textOn);
        this.f963p = v10.p(j.SwitchCompat_android_textOff);
        this.f964q = v10.a(j.SwitchCompat_showText, true);
        this.f958k = v10.f(j.SwitchCompat_thumbTextPadding, 0);
        this.f959l = v10.f(j.SwitchCompat_switchMinWidth, 0);
        this.f960m = v10.f(j.SwitchCompat_switchPadding, 0);
        this.f961n = v10.a(j.SwitchCompat_splitTrack, false);
        ColorStateList c10 = v10.c(j.SwitchCompat_thumbTint);
        if (c10 != null) {
            this.f949b = c10;
            this.f951d = true;
        }
        PorterDuff.Mode e10 = q.e(v10.k(j.SwitchCompat_thumbTintMode, -1), (PorterDuff.Mode) null);
        if (this.f950c != e10) {
            this.f950c = e10;
            this.f952e = true;
        }
        if (this.f951d || this.f952e) {
            b();
        }
        ColorStateList c11 = v10.c(j.SwitchCompat_trackTint);
        if (c11 != null) {
            this.f954g = c11;
            this.f956i = true;
        }
        PorterDuff.Mode e11 = q.e(v10.k(j.SwitchCompat_trackTintMode, -1), (PorterDuff.Mode) null);
        if (this.f955h != e11) {
            this.f955h = e11;
            this.f957j = true;
        }
        if (this.f956i || this.f957j) {
            c();
        }
        int n10 = v10.n(j.SwitchCompat_switchTextAppearance, 0);
        if (n10 != 0) {
            k(context, n10);
        }
        m mVar = new m(this);
        this.L = mVar;
        mVar.m(attributeSet, i10);
        v10.w();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f966s = viewConfiguration.getScaledTouchSlop();
        this.f970w = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    private void a(boolean z10) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, N, new float[]{z10 ? 1.0f : 0.0f});
        this.K = ofFloat;
        ofFloat.setDuration(250);
        if (Build.VERSION.SDK_INT >= 18) {
            this.K.setAutoCancel(true);
        }
        this.K.start();
    }

    private void b() {
        Drawable drawable = this.f948a;
        if (drawable == null) {
            return;
        }
        if (this.f951d || this.f952e) {
            Drawable mutate = p0.a.r(drawable).mutate();
            this.f948a = mutate;
            if (this.f951d) {
                p0.a.o(mutate, this.f949b);
            }
            if (this.f952e) {
                p0.a.p(this.f948a, this.f950c);
            }
            if (this.f948a.isStateful()) {
                this.f948a.setState(getDrawableState());
            }
        }
    }

    private void c() {
        Drawable drawable = this.f953f;
        if (drawable == null) {
            return;
        }
        if (this.f956i || this.f957j) {
            Drawable mutate = p0.a.r(drawable).mutate();
            this.f953f = mutate;
            if (this.f956i) {
                p0.a.o(mutate, this.f954g);
            }
            if (this.f957j) {
                p0.a.p(this.f953f, this.f955h);
            }
            if (this.f953f.isStateful()) {
                this.f953f.setState(getDrawableState());
            }
        }
    }

    private void d() {
        ObjectAnimator objectAnimator = this.K;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private void e(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    private static float f(float f10, float f11, float f12) {
        return f10 < f11 ? f11 : f10 > f12 ? f12 : f10;
    }

    private boolean g(float f10, float f11) {
        if (this.f948a == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f948a.getPadding(this.M);
        int i10 = this.C;
        int i11 = this.f966s;
        int i12 = i10 - i11;
        int i13 = (this.B + thumbOffset) - i11;
        Rect rect = this.M;
        return f10 > ((float) i13) && f10 < ((float) ((((this.A + i13) + rect.left) + rect.right) + i11)) && f11 > ((float) i12) && f11 < ((float) (this.E + i11));
    }

    private boolean getTargetCheckedState() {
        return this.f971x > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((m0.b(this) ? 1.0f - this.f971x : this.f971x) * ((float) getThumbScrollRange())) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.f953f;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.M;
        drawable.getPadding(rect);
        Drawable drawable2 = this.f948a;
        Rect d10 = drawable2 != null ? q.d(drawable2) : q.f1182c;
        return ((((this.f972y - this.A) - rect.left) - rect.right) - d10.left) - d10.right;
    }

    private Layout h(CharSequence charSequence) {
        TransformationMethod transformationMethod = this.J;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, this);
        }
        CharSequence charSequence2 = charSequence;
        TextPaint textPaint = this.F;
        return new StaticLayout(charSequence2, textPaint, charSequence2 != null ? (int) Math.ceil((double) Layout.getDesiredWidth(charSequence2, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private void i() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence charSequence = this.f963p;
            if (charSequence == null) {
                charSequence = getResources().getString(h.abc_capital_off);
            }
            x.J0(this, charSequence);
        }
    }

    private void j() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence charSequence = this.f962o;
            if (charSequence == null) {
                charSequence = getResources().getString(h.abc_capital_on);
            }
            x.J0(this, charSequence);
        }
    }

    private void m(int i10, int i11) {
        l(i10 != 1 ? i10 != 2 ? i10 != 3 ? null : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF, i11);
    }

    private void n(MotionEvent motionEvent) {
        this.f965r = 0;
        boolean z10 = true;
        boolean z11 = motionEvent.getAction() == 1 && isEnabled();
        boolean isChecked = isChecked();
        if (z11) {
            this.f969v.computeCurrentVelocity(k.DEFAULT_IMAGE_TIMEOUT_MS);
            float xVelocity = this.f969v.getXVelocity();
            if (Math.abs(xVelocity) <= ((float) this.f970w)) {
                z10 = getTargetCheckedState();
            } else if (!m0.b(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                z10 = false;
            }
        } else {
            z10 = isChecked;
        }
        if (z10 != isChecked) {
            playSoundEffect(0);
        }
        setChecked(z10);
        e(motionEvent);
    }

    public void draw(Canvas canvas) {
        int i10;
        int i11;
        Rect rect = this.M;
        int i12 = this.B;
        int i13 = this.C;
        int i14 = this.D;
        int i15 = this.E;
        int thumbOffset = getThumbOffset() + i12;
        Drawable drawable = this.f948a;
        Rect d10 = drawable != null ? q.d(drawable) : q.f1182c;
        Drawable drawable2 = this.f953f;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i16 = rect.left;
            thumbOffset += i16;
            if (d10 != null) {
                int i17 = d10.left;
                if (i17 > i16) {
                    i12 += i17 - i16;
                }
                int i18 = d10.top;
                int i19 = rect.top;
                i10 = i18 > i19 ? (i18 - i19) + i13 : i13;
                int i20 = d10.right;
                int i21 = rect.right;
                if (i20 > i21) {
                    i14 -= i20 - i21;
                }
                int i22 = d10.bottom;
                int i23 = rect.bottom;
                if (i22 > i23) {
                    i11 = i15 - (i22 - i23);
                    this.f953f.setBounds(i12, i10, i14, i11);
                }
            } else {
                i10 = i13;
            }
            i11 = i15;
            this.f953f.setBounds(i12, i10, i14, i11);
        }
        Drawable drawable3 = this.f948a;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i24 = thumbOffset - rect.left;
            int i25 = thumbOffset + this.A + rect.right;
            this.f948a.setBounds(i24, i13, i25, i15);
            Drawable background = getBackground();
            if (background != null) {
                p0.a.l(background, i24, i13, i25, i15);
            }
        }
        super.draw(canvas);
    }

    public void drawableHotspotChanged(float f10, float f11) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f10, f11);
        }
        Drawable drawable = this.f948a;
        if (drawable != null) {
            p0.a.k(drawable, f10, f11);
        }
        Drawable drawable2 = this.f953f;
        if (drawable2 != null) {
            p0.a.k(drawable2, f10, f11);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f948a;
        boolean z10 = false;
        if (drawable != null && drawable.isStateful()) {
            z10 = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.f953f;
        if (drawable2 != null && drawable2.isStateful()) {
            z10 |= drawable2.setState(drawableState);
        }
        if (z10) {
            invalidate();
        }
    }

    public int getCompoundPaddingLeft() {
        if (!m0.b(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.f972y;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f960m : compoundPaddingLeft;
    }

    public int getCompoundPaddingRight() {
        if (m0.b(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.f972y;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f960m : compoundPaddingRight;
    }

    public boolean getShowText() {
        return this.f964q;
    }

    public boolean getSplitTrack() {
        return this.f961n;
    }

    public int getSwitchMinWidth() {
        return this.f959l;
    }

    public int getSwitchPadding() {
        return this.f960m;
    }

    public CharSequence getTextOff() {
        return this.f963p;
    }

    public CharSequence getTextOn() {
        return this.f962o;
    }

    public Drawable getThumbDrawable() {
        return this.f948a;
    }

    public int getThumbTextPadding() {
        return this.f958k;
    }

    public ColorStateList getThumbTintList() {
        return this.f949b;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f950c;
    }

    public Drawable getTrackDrawable() {
        return this.f953f;
    }

    public ColorStateList getTrackTintList() {
        return this.f954g;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.f955h;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f948a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f953f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.K;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            this.K.end();
            this.K = null;
        }
    }

    public void k(Context context, int i10) {
        g0 t10 = g0.t(context, i10, j.TextAppearance);
        ColorStateList c10 = t10.c(j.TextAppearance_android_textColor);
        if (c10 == null) {
            c10 = getTextColors();
        }
        this.G = c10;
        int f10 = t10.f(j.TextAppearance_android_textSize, 0);
        if (f10 != 0) {
            float f11 = (float) f10;
            if (f11 != this.F.getTextSize()) {
                this.F.setTextSize(f11);
                requestLayout();
            }
        }
        m(t10.k(j.TextAppearance_android_typeface, -1), t10.k(j.TextAppearance_android_textStyle, -1));
        this.J = t10.a(j.TextAppearance_textAllCaps, false) ? new n.a(getContext()) : null;
        t10.w();
    }

    public void l(Typeface typeface, int i10) {
        float f10 = 0.0f;
        boolean z10 = false;
        if (i10 > 0) {
            Typeface defaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i10) : Typeface.create(typeface, i10);
            setSwitchTypeface(defaultFromStyle);
            int i11 = (~(defaultFromStyle != null ? defaultFromStyle.getStyle() : 0)) & i10;
            TextPaint textPaint = this.F;
            if ((i11 & 1) != 0) {
                z10 = true;
            }
            textPaint.setFakeBoldText(z10);
            TextPaint textPaint2 = this.F;
            if ((i11 & 2) != 0) {
                f10 = -0.25f;
            }
            textPaint2.setTextSkewX(f10);
            return;
        }
        this.F.setFakeBoldText(false);
        this.F.setTextSkewX(0.0f);
        setSwitchTypeface(typeface);
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        if (isChecked()) {
            CompoundButton.mergeDrawableStates(onCreateDrawableState, O);
        }
        return onCreateDrawableState;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i10;
        super.onDraw(canvas);
        Rect rect = this.M;
        Drawable drawable = this.f953f;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i11 = this.C;
        int i12 = this.E;
        int i13 = i11 + rect.top;
        int i14 = i12 - rect.bottom;
        Drawable drawable2 = this.f948a;
        if (drawable != null) {
            if (!this.f961n || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect d10 = q.d(drawable2);
                drawable2.copyBounds(rect);
                rect.left += d10.left;
                rect.right -= d10.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.H : this.I;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.G;
            if (colorStateList != null) {
                this.F.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.F.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                i10 = bounds.left + bounds.right;
            } else {
                i10 = getWidth();
            }
            canvas.translate((float) ((i10 / 2) - (layout.getWidth() / 2)), (float) (((i13 + i14) / 2) - (layout.getHeight() / 2)));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        if (Build.VERSION.SDK_INT < 30) {
            CharSequence charSequence = isChecked() ? this.f962o : this.f963p;
            if (!TextUtils.isEmpty(charSequence)) {
                CharSequence text = accessibilityNodeInfo.getText();
                if (TextUtils.isEmpty(text)) {
                    accessibilityNodeInfo.setText(charSequence);
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(text);
                sb2.append(' ');
                sb2.append(charSequence);
                accessibilityNodeInfo.setText(sb2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        super.onLayout(z10, i10, i11, i12, i13);
        int i20 = 0;
        if (this.f948a != null) {
            Rect rect = this.M;
            Drawable drawable = this.f953f;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect d10 = q.d(this.f948a);
            i14 = Math.max(0, d10.left - rect.left);
            i20 = Math.max(0, d10.right - rect.right);
        } else {
            i14 = 0;
        }
        if (m0.b(this)) {
            i16 = getPaddingLeft() + i14;
            i15 = ((this.f972y + i16) - i14) - i20;
        } else {
            i15 = (getWidth() - getPaddingRight()) - i20;
            i16 = (i15 - this.f972y) + i14 + i20;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            i19 = this.f973z;
            i18 = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (i19 / 2);
        } else if (gravity != 80) {
            i18 = getPaddingTop();
            i19 = this.f973z;
        } else {
            i17 = getHeight() - getPaddingBottom();
            i18 = i17 - this.f973z;
            this.B = i16;
            this.C = i18;
            this.E = i17;
            this.D = i15;
        }
        i17 = i19 + i18;
        this.B = i16;
        this.C = i18;
        this.E = i17;
        this.D = i15;
    }

    public void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        if (this.f964q) {
            if (this.H == null) {
                this.H = h(this.f962o);
            }
            if (this.I == null) {
                this.I = h(this.f963p);
            }
        }
        Rect rect = this.M;
        Drawable drawable = this.f948a;
        int i14 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            i13 = (this.f948a.getIntrinsicWidth() - rect.left) - rect.right;
            i12 = this.f948a.getIntrinsicHeight();
        } else {
            i13 = 0;
            i12 = 0;
        }
        this.A = Math.max(this.f964q ? Math.max(this.H.getWidth(), this.I.getWidth()) + (this.f958k * 2) : 0, i13);
        Drawable drawable2 = this.f953f;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i14 = this.f953f.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i15 = rect.left;
        int i16 = rect.right;
        Drawable drawable3 = this.f948a;
        if (drawable3 != null) {
            Rect d10 = q.d(drawable3);
            i15 = Math.max(i15, d10.left);
            i16 = Math.max(i16, d10.right);
        }
        int max = Math.max(this.f959l, (this.A * 2) + i15 + i16);
        int max2 = Math.max(i14, i12);
        this.f972y = max;
        this.f973z = max2;
        super.onMeasure(i10, i11);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(getMeasuredWidthAndState(), max2);
        }
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.f962o : this.f963p;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        if (r0 != 3) goto L_0x00b7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            android.view.VelocityTracker r0 = r6.f969v
            r0.addMovement(r7)
            int r0 = r7.getActionMasked()
            r1 = 1
            if (r0 == 0) goto L_0x009d
            r2 = 2
            if (r0 == r1) goto L_0x0089
            if (r0 == r2) goto L_0x0016
            r3 = 3
            if (r0 == r3) goto L_0x0089
            goto L_0x00b7
        L_0x0016:
            int r0 = r6.f965r
            if (r0 == r1) goto L_0x0055
            if (r0 == r2) goto L_0x001e
            goto L_0x00b7
        L_0x001e:
            float r7 = r7.getX()
            int r0 = r6.getThumbScrollRange()
            float r2 = r6.f967t
            float r2 = r7 - r2
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            if (r0 == 0) goto L_0x0032
            float r0 = (float) r0
            float r2 = r2 / r0
            goto L_0x003b
        L_0x0032:
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0038
            r2 = r3
            goto L_0x003b
        L_0x0038:
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r2 = r0
        L_0x003b:
            boolean r0 = androidx.appcompat.widget.m0.b(r6)
            if (r0 == 0) goto L_0x0042
            float r2 = -r2
        L_0x0042:
            float r0 = r6.f971x
            float r0 = r0 + r2
            float r0 = f(r0, r4, r3)
            float r2 = r6.f971x
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0054
            r6.f967t = r7
            r6.setThumbPosition(r0)
        L_0x0054:
            return r1
        L_0x0055:
            float r0 = r7.getX()
            float r3 = r7.getY()
            float r4 = r6.f967t
            float r4 = r0 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.f966s
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L_0x007b
            float r4 = r6.f968u
            float r4 = r3 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.f966s
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x00b7
        L_0x007b:
            r6.f965r = r2
            android.view.ViewParent r7 = r6.getParent()
            r7.requestDisallowInterceptTouchEvent(r1)
            r6.f967t = r0
            r6.f968u = r3
            return r1
        L_0x0089:
            int r0 = r6.f965r
            if (r0 != r2) goto L_0x0094
            r6.n(r7)
            super.onTouchEvent(r7)
            return r1
        L_0x0094:
            r0 = 0
            r6.f965r = r0
            android.view.VelocityTracker r0 = r6.f969v
            r0.clear()
            goto L_0x00b7
        L_0x009d:
            float r0 = r7.getX()
            float r2 = r7.getY()
            boolean r3 = r6.isEnabled()
            if (r3 == 0) goto L_0x00b7
            boolean r3 = r6.g(r0, r2)
            if (r3 == 0) goto L_0x00b7
            r6.f965r = r1
            r6.f967t = r0
            r6.f968u = r2
        L_0x00b7:
            boolean r7 = super.onTouchEvent(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setChecked(boolean z10) {
        super.setChecked(z10);
        boolean isChecked = isChecked();
        if (isChecked) {
            j();
        } else {
            i();
        }
        if (getWindowToken() == null || !x.V(this)) {
            d();
            setThumbPosition(isChecked ? 1.0f : 0.0f);
            return;
        }
        a(isChecked);
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.k.s(this, callback));
    }

    public void setShowText(boolean z10) {
        if (this.f964q != z10) {
            this.f964q = z10;
            requestLayout();
        }
    }

    public void setSplitTrack(boolean z10) {
        this.f961n = z10;
        invalidate();
    }

    public void setSwitchMinWidth(int i10) {
        this.f959l = i10;
        requestLayout();
    }

    public void setSwitchPadding(int i10) {
        this.f960m = i10;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.F.getTypeface() != null && !this.F.getTypeface().equals(typeface)) || (this.F.getTypeface() == null && typeface != null)) {
            this.F.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setTextOff(CharSequence charSequence) {
        this.f963p = charSequence;
        requestLayout();
        if (!isChecked()) {
            i();
        }
    }

    public void setTextOn(CharSequence charSequence) {
        this.f962o = charSequence;
        requestLayout();
        if (isChecked()) {
            j();
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f948a;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f948a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void setThumbPosition(float f10) {
        this.f971x = f10;
        invalidate();
    }

    public void setThumbResource(int i10) {
        setThumbDrawable(k.a.d(getContext(), i10));
    }

    public void setThumbTextPadding(int i10) {
        this.f958k = i10;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f949b = colorStateList;
        this.f951d = true;
        b();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f950c = mode;
        this.f952e = true;
        b();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f953f;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f953f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i10) {
        setTrackDrawable(k.a.d(getContext(), i10));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f954g = colorStateList;
        this.f956i = true;
        c();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.f955h = mode;
        this.f957j = true;
        c();
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f948a || drawable == this.f953f;
    }
}
