package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import j.d;
import j.f;
import j.g;
import j.i;

class k0 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1134a;

    /* renamed from: b  reason: collision with root package name */
    private final View f1135b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f1136c;

    /* renamed from: d  reason: collision with root package name */
    private final WindowManager.LayoutParams f1137d;

    /* renamed from: e  reason: collision with root package name */
    private final Rect f1138e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    private final int[] f1139f = new int[2];

    /* renamed from: g  reason: collision with root package name */
    private final int[] f1140g = new int[2];

    k0(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f1137d = layoutParams;
        this.f1134a = context;
        View inflate = LayoutInflater.from(context).inflate(g.abc_tooltip, (ViewGroup) null);
        this.f1135b = inflate;
        this.f1136c = (TextView) inflate.findViewById(f.message);
        layoutParams.setTitle(k0.class.getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = i.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }

    private void a(View view, int i10, int i11, boolean z10, WindowManager.LayoutParams layoutParams) {
        int i12;
        int i13;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f1134a.getResources().getDimensionPixelOffset(d.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i10 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f1134a.getResources().getDimensionPixelOffset(d.tooltip_precise_anchor_extra_offset);
            i13 = i11 + dimensionPixelOffset2;
            i12 = i11 - dimensionPixelOffset2;
        } else {
            i13 = view.getHeight();
            i12 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f1134a.getResources().getDimensionPixelOffset(z10 ? d.tooltip_y_offset_touch : d.tooltip_y_offset_non_touch);
        View b10 = b(view);
        if (b10 == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        b10.getWindowVisibleDisplayFrame(this.f1138e);
        Rect rect = this.f1138e;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources = this.f1134a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f1138e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        b10.getLocationOnScreen(this.f1140g);
        view.getLocationOnScreen(this.f1139f);
        int[] iArr = this.f1139f;
        int i14 = iArr[0];
        int[] iArr2 = this.f1140g;
        iArr[0] = i14 - iArr2[0];
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (iArr[0] + i10) - (b10.getWidth() / 2);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f1135b.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = this.f1135b.getMeasuredHeight();
        int[] iArr3 = this.f1139f;
        int i15 = ((iArr3[1] + i12) - dimensionPixelOffset3) - measuredHeight;
        int i16 = iArr3[1] + i13 + dimensionPixelOffset3;
        if (!z10 ? measuredHeight + i16 > this.f1138e.height() : i15 >= 0) {
            layoutParams.y = i15;
        } else {
            layoutParams.y = i16;
        }
    }

    private static View b(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (d()) {
            ((WindowManager) this.f1134a.getSystemService("window")).removeView(this.f1135b);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.f1135b.getParent() != null;
    }

    /* access modifiers changed from: package-private */
    public void e(View view, int i10, int i11, boolean z10, CharSequence charSequence) {
        if (d()) {
            c();
        }
        this.f1136c.setText(charSequence);
        a(view, i10, i11, z10, this.f1137d);
        ((WindowManager) this.f1134a.getSystemService("window")).addView(this.f1135b, this.f1137d);
    }
}
