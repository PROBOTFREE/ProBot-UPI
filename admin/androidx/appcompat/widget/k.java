package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.core.view.x;
import j.j;
import p0.a;

class k extends i {

    /* renamed from: d  reason: collision with root package name */
    private final SeekBar f1128d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f1129e;

    /* renamed from: f  reason: collision with root package name */
    private ColorStateList f1130f = null;

    /* renamed from: g  reason: collision with root package name */
    private PorterDuff.Mode f1131g = null;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1132h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1133i = false;

    k(SeekBar seekBar) {
        super(seekBar);
        this.f1128d = seekBar;
    }

    private void f() {
        Drawable drawable = this.f1129e;
        if (drawable == null) {
            return;
        }
        if (this.f1132h || this.f1133i) {
            Drawable r10 = a.r(drawable.mutate());
            this.f1129e = r10;
            if (this.f1132h) {
                a.o(r10, this.f1130f);
            }
            if (this.f1133i) {
                a.p(this.f1129e, this.f1131g);
            }
            if (this.f1129e.isStateful()) {
                this.f1129e.setState(this.f1128d.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(AttributeSet attributeSet, int i10) {
        super.c(attributeSet, i10);
        Context context = this.f1128d.getContext();
        int[] iArr = j.AppCompatSeekBar;
        g0 v10 = g0.v(context, attributeSet, iArr, i10, 0);
        SeekBar seekBar = this.f1128d;
        x.p0(seekBar, seekBar.getContext(), iArr, attributeSet, v10.r(), i10, 0);
        Drawable h10 = v10.h(j.AppCompatSeekBar_android_thumb);
        if (h10 != null) {
            this.f1128d.setThumb(h10);
        }
        j(v10.g(j.AppCompatSeekBar_tickMark));
        int i11 = j.AppCompatSeekBar_tickMarkTintMode;
        if (v10.s(i11)) {
            this.f1131g = q.e(v10.k(i11, -1), this.f1131g);
            this.f1133i = true;
        }
        int i12 = j.AppCompatSeekBar_tickMarkTint;
        if (v10.s(i12)) {
            this.f1130f = v10.c(i12);
            this.f1132h = true;
        }
        v10.w();
        f();
    }

    /* access modifiers changed from: package-private */
    public void g(Canvas canvas) {
        if (this.f1129e != null) {
            int max = this.f1128d.getMax();
            int i10 = 1;
            if (max > 1) {
                int intrinsicWidth = this.f1129e.getIntrinsicWidth();
                int intrinsicHeight = this.f1129e.getIntrinsicHeight();
                int i11 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i10 = intrinsicHeight / 2;
                }
                this.f1129e.setBounds(-i11, -i10, i11, i10);
                float width = ((float) ((this.f1128d.getWidth() - this.f1128d.getPaddingLeft()) - this.f1128d.getPaddingRight())) / ((float) max);
                int save = canvas.save();
                canvas.translate((float) this.f1128d.getPaddingLeft(), (float) (this.f1128d.getHeight() / 2));
                for (int i12 = 0; i12 <= max; i12++) {
                    this.f1129e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void h() {
        Drawable drawable = this.f1129e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f1128d.getDrawableState())) {
            this.f1128d.invalidateDrawable(drawable);
        }
    }

    /* access modifiers changed from: package-private */
    public void i() {
        Drawable drawable = this.f1129e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: package-private */
    public void j(Drawable drawable) {
        Drawable drawable2 = this.f1129e;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f1129e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f1128d);
            a.m(drawable, x.C(this.f1128d));
            if (drawable.isStateful()) {
                drawable.setState(this.f1128d.getDrawableState());
            }
            f();
        }
        this.f1128d.invalidate();
    }
}
