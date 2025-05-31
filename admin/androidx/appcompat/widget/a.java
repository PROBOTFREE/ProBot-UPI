package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.b0;
import androidx.core.view.c0;
import androidx.core.view.x;
import j.j;

abstract class a extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    protected final C0009a f1014a;

    /* renamed from: b  reason: collision with root package name */
    protected final Context f1015b;

    /* renamed from: c  reason: collision with root package name */
    protected ActionMenuView f1016c;

    /* renamed from: d  reason: collision with root package name */
    protected ActionMenuPresenter f1017d;

    /* renamed from: e  reason: collision with root package name */
    protected int f1018e;

    /* renamed from: f  reason: collision with root package name */
    protected b0 f1019f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1020g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1021h;

    /* renamed from: androidx.appcompat.widget.a$a  reason: collision with other inner class name */
    protected class C0009a implements c0 {

        /* renamed from: a  reason: collision with root package name */
        private boolean f1022a = false;

        /* renamed from: b  reason: collision with root package name */
        int f1023b;

        protected C0009a() {
        }

        public void a(View view) {
            this.f1022a = true;
        }

        public void b(View view) {
            if (!this.f1022a) {
                a aVar = a.this;
                aVar.f1019f = null;
                a.super.setVisibility(this.f1023b);
            }
        }

        public void c(View view) {
            a.super.setVisibility(0);
            this.f1022a = false;
        }

        public C0009a d(b0 b0Var, int i10) {
            a.this.f1019f = b0Var;
            this.f1023b = i10;
            return this;
        }
    }

    a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    a(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f1014a = new C0009a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(j.a.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f1015b = context;
        } else {
            this.f1015b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    protected static int d(int i10, int i11, boolean z10) {
        return z10 ? i10 - i11 : i10 + i11;
    }

    /* access modifiers changed from: protected */
    public int c(View view, int i10, int i11, int i12) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i10, Integer.MIN_VALUE), i11);
        return Math.max(0, (i10 - view.getMeasuredWidth()) - i12);
    }

    /* access modifiers changed from: protected */
    public int e(View view, int i10, int i11, int i12, boolean z10) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i13 = i11 + ((i12 - measuredHeight) / 2);
        if (z10) {
            view.layout(i10 - measuredWidth, i13, i10, measuredHeight + i13);
        } else {
            view.layout(i10, i13, i10 + measuredWidth, measuredHeight + i13);
        }
        return z10 ? -measuredWidth : measuredWidth;
    }

    public b0 f(int i10, long j10) {
        b0 a10;
        b0 b0Var = this.f1019f;
        if (b0Var != null) {
            b0Var.b();
        }
        if (i10 == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            a10 = x.d(this).a(1.0f);
        } else {
            a10 = x.d(this).a(0.0f);
        }
        a10.d(j10);
        a10.f(this.f1014a.d(a10, i10));
        return a10;
    }

    public int getAnimatedVisibility() {
        return this.f1019f != null ? this.f1014a.f1023b : getVisibility();
    }

    public int getContentHeight() {
        return this.f1018e;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes((AttributeSet) null, j.ActionBar, j.a.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(j.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        ActionMenuPresenter actionMenuPresenter = this.f1017d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.J(configuration);
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f1021h = false;
        }
        if (!this.f1021h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f1021h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f1021h = false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1020g = false;
        }
        if (!this.f1020g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f1020g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f1020g = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i10);

    public void setVisibility(int i10) {
        if (i10 != getVisibility()) {
            b0 b0Var = this.f1019f;
            if (b0Var != null) {
                b0Var.b();
            }
            super.setVisibility(i10);
        }
    }
}
