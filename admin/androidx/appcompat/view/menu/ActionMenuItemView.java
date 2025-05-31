package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.i0;
import androidx.appcompat.widget.t;
import j.j;

public class ActionMenuItemView extends AppCompatTextView implements k.a, View.OnClickListener, ActionMenuView.a {

    /* renamed from: f  reason: collision with root package name */
    g f469f;

    /* renamed from: g  reason: collision with root package name */
    private CharSequence f470g;

    /* renamed from: h  reason: collision with root package name */
    private Drawable f471h;

    /* renamed from: i  reason: collision with root package name */
    e.b f472i;

    /* renamed from: j  reason: collision with root package name */
    private t f473j;

    /* renamed from: k  reason: collision with root package name */
    b f474k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f475l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f476m;

    /* renamed from: n  reason: collision with root package name */
    private int f477n;

    /* renamed from: o  reason: collision with root package name */
    private int f478o;

    /* renamed from: p  reason: collision with root package name */
    private int f479p;

    private class a extends t {
        public a() {
            super(ActionMenuItemView.this);
        }

        public p.e b() {
            b bVar = ActionMenuItemView.this.f474k;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
            r0 = b();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean c() {
            /*
                r3 = this;
                androidx.appcompat.view.menu.ActionMenuItemView r0 = androidx.appcompat.view.menu.ActionMenuItemView.this
                androidx.appcompat.view.menu.e$b r1 = r0.f472i
                r2 = 0
                if (r1 == 0) goto L_0x001c
                androidx.appcompat.view.menu.g r0 = r0.f469f
                boolean r0 = r1.a(r0)
                if (r0 == 0) goto L_0x001c
                p.e r0 = r3.b()
                if (r0 == 0) goto L_0x001c
                boolean r0 = r0.d()
                if (r0 == 0) goto L_0x001c
                r2 = 1
            L_0x001c:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.ActionMenuItemView.a.c():boolean");
        }
    }

    public static abstract class b {
        public abstract p.e a();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Resources resources = context.getResources();
        this.f475l = c();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ActionMenuItemView, i10, 0);
        this.f477n = obtainStyledAttributes.getDimensionPixelSize(j.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.f479p = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f478o = -1;
        setSaveEnabled(false);
    }

    private boolean c() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i10 = configuration.screenWidthDp;
        return i10 >= 480 || (i10 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    private void h() {
        boolean z10 = true;
        boolean z11 = !TextUtils.isEmpty(this.f470g);
        if (this.f471h != null && (!this.f469f.B() || (!this.f475l && !this.f476m))) {
            z10 = false;
        }
        boolean z12 = z11 & z10;
        CharSequence charSequence = null;
        setText(z12 ? this.f470g : null);
        CharSequence contentDescription = this.f469f.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            contentDescription = z12 ? null : this.f469f.getTitle();
        }
        setContentDescription(contentDescription);
        CharSequence tooltipText = this.f469f.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            if (!z12) {
                charSequence = this.f469f.getTitle();
            }
            i0.a(this, charSequence);
            return;
        }
        i0.a(this, tooltipText);
    }

    public boolean b() {
        return !TextUtils.isEmpty(getText());
    }

    public boolean d() {
        return true;
    }

    public boolean e() {
        return b();
    }

    public boolean f() {
        return b() && this.f469f.getIcon() == null;
    }

    public void g(g gVar, int i10) {
        this.f469f = gVar;
        setIcon(gVar.getIcon());
        setTitle(gVar.i(this));
        setId(gVar.getItemId());
        setVisibility(gVar.isVisible() ? 0 : 8);
        setEnabled(gVar.isEnabled());
        if (gVar.hasSubMenu() && this.f473j == null) {
            this.f473j = new a();
        }
    }

    public g getItemData() {
        return this.f469f;
    }

    public void onClick(View view) {
        e.b bVar = this.f472i;
        if (bVar != null) {
            bVar.a(this.f469f);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f475l = c();
        h();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        int i12;
        boolean b10 = b();
        if (b10 && (i12 = this.f478o) >= 0) {
            super.setPadding(i12, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int measuredWidth = getMeasuredWidth();
        int min = mode == Integer.MIN_VALUE ? Math.min(size, this.f477n) : this.f477n;
        if (mode != 1073741824 && this.f477n > 0 && measuredWidth < min) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, 1073741824), i11);
        }
        if (!b10 && this.f471h != null) {
            super.setPadding((getMeasuredWidth() - this.f471h.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState((Parcelable) null);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        t tVar;
        if (!this.f469f.hasSubMenu() || (tVar = this.f473j) == null || !tVar.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void setCheckable(boolean z10) {
    }

    public void setChecked(boolean z10) {
    }

    public void setExpandedFormat(boolean z10) {
        if (this.f476m != z10) {
            this.f476m = z10;
            g gVar = this.f469f;
            if (gVar != null) {
                gVar.c();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f471h = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i10 = this.f479p;
            if (intrinsicWidth > i10) {
                intrinsicHeight = (int) (((float) intrinsicHeight) * (((float) i10) / ((float) intrinsicWidth)));
                intrinsicWidth = i10;
            }
            if (intrinsicHeight > i10) {
                intrinsicWidth = (int) (((float) intrinsicWidth) * (((float) i10) / ((float) intrinsicHeight)));
            } else {
                i10 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i10);
        }
        setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        h();
    }

    public void setItemInvoker(e.b bVar) {
        this.f472i = bVar;
    }

    public void setPadding(int i10, int i11, int i12, int i13) {
        this.f478o = i10;
        super.setPadding(i10, i11, i12, i13);
    }

    public void setPopupCallback(b bVar) {
        this.f474k = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f470g = charSequence;
        h();
    }
}
