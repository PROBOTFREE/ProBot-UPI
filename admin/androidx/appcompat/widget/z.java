package androidx.appcompat.widget;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.LinearLayoutCompat;

public class z extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: a  reason: collision with root package name */
    Runnable f1234a;

    /* renamed from: b  reason: collision with root package name */
    private c f1235b;

    /* renamed from: c  reason: collision with root package name */
    LinearLayoutCompat f1236c;

    /* renamed from: d  reason: collision with root package name */
    private Spinner f1237d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1238e;

    /* renamed from: f  reason: collision with root package name */
    int f1239f;

    /* renamed from: g  reason: collision with root package name */
    int f1240g;

    /* renamed from: h  reason: collision with root package name */
    private int f1241h;

    /* renamed from: i  reason: collision with root package name */
    private int f1242i;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f1243a;

        a(View view) {
            this.f1243a = view;
        }

        public void run() {
            z.this.smoothScrollTo(this.f1243a.getLeft() - ((z.this.getWidth() - this.f1243a.getWidth()) / 2), 0);
            z.this.f1234a = null;
        }
    }

    private class b extends BaseAdapter {
        b() {
        }

        public int getCount() {
            return z.this.f1236c.getChildCount();
        }

        public Object getItem(int i10) {
            return ((d) z.this.f1236c.getChildAt(i10)).b();
        }

        public long getItemId(int i10) {
            return (long) i10;
        }

        public View getView(int i10, View view, ViewGroup viewGroup) {
            if (view == null) {
                return z.this.c((ActionBar.b) getItem(i10), true);
            }
            ((d) view).a((ActionBar.b) getItem(i10));
            return view;
        }
    }

    private class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View view) {
            ((d) view).b().e();
            int childCount = z.this.f1236c.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = z.this.f1236c.getChildAt(i10);
                childAt.setSelected(childAt == view);
            }
        }
    }

    private class d extends LinearLayout {

        /* renamed from: a  reason: collision with root package name */
        private final int[] f1247a;

        /* renamed from: b  reason: collision with root package name */
        private ActionBar.b f1248b;

        /* renamed from: c  reason: collision with root package name */
        private TextView f1249c;

        /* renamed from: d  reason: collision with root package name */
        private ImageView f1250d;

        /* renamed from: e  reason: collision with root package name */
        private View f1251e;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public d(android.content.Context r6, androidx.appcompat.app.ActionBar.b r7, boolean r8) {
            /*
                r4 = this;
                androidx.appcompat.widget.z.this = r5
                int r5 = j.a.actionBarTabStyle
                r0 = 0
                r4.<init>(r6, r0, r5)
                r1 = 1
                int[] r1 = new int[r1]
                r2 = 16842964(0x10100d4, float:2.3694152E-38)
                r3 = 0
                r1[r3] = r2
                r4.f1247a = r1
                r4.f1248b = r7
                androidx.appcompat.widget.g0 r5 = androidx.appcompat.widget.g0.v(r6, r0, r1, r5, r3)
                boolean r6 = r5.s(r3)
                if (r6 == 0) goto L_0x0026
                android.graphics.drawable.Drawable r6 = r5.g(r3)
                r4.setBackgroundDrawable(r6)
            L_0x0026:
                r5.w()
                if (r8 == 0) goto L_0x0031
                r5 = 8388627(0x800013, float:1.175497E-38)
                r4.setGravity(r5)
            L_0x0031:
                r4.c()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.z.d.<init>(androidx.appcompat.widget.z, android.content.Context, androidx.appcompat.app.ActionBar$b, boolean):void");
        }

        public void a(ActionBar.b bVar) {
            this.f1248b = bVar;
            c();
        }

        public ActionBar.b b() {
            return this.f1248b;
        }

        public void c() {
            ActionBar.b bVar = this.f1248b;
            View b10 = bVar.b();
            CharSequence charSequence = null;
            if (b10 != null) {
                ViewParent parent = b10.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(b10);
                    }
                    addView(b10);
                }
                this.f1251e = b10;
                TextView textView = this.f1249c;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f1250d;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f1250d.setImageDrawable((Drawable) null);
                    return;
                }
                return;
            }
            View view = this.f1251e;
            if (view != null) {
                removeView(view);
                this.f1251e = null;
            }
            Drawable c10 = bVar.c();
            CharSequence d10 = bVar.d();
            if (c10 != null) {
                if (this.f1250d == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.f1250d = appCompatImageView;
                }
                this.f1250d.setImageDrawable(c10);
                this.f1250d.setVisibility(0);
            } else {
                ImageView imageView2 = this.f1250d;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f1250d.setImageDrawable((Drawable) null);
                }
            }
            boolean z10 = !TextUtils.isEmpty(d10);
            if (z10) {
                if (this.f1249c == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), (AttributeSet) null, j.a.actionBarTabTextStyle);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.f1249c = appCompatTextView;
                }
                this.f1249c.setText(d10);
                this.f1249c.setVisibility(0);
            } else {
                TextView textView2 = this.f1249c;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f1249c.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.f1250d;
            if (imageView3 != null) {
                imageView3.setContentDescription(bVar.a());
            }
            if (!z10) {
                charSequence = bVar.a();
            }
            i0.a(this, charSequence);
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        public void onMeasure(int i10, int i11) {
            int i12;
            super.onMeasure(i10, i11);
            if (z.this.f1239f > 0 && getMeasuredWidth() > (i12 = z.this.f1239f)) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(i12, 1073741824), i11);
            }
        }

        public void setSelected(boolean z10) {
            boolean z11 = isSelected() != z10;
            super.setSelected(z10);
            if (z11 && z10) {
                sendAccessibilityEvent(4);
            }
        }
    }

    static {
        new DecelerateInterpolator();
    }

    private Spinner b() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), (AttributeSet) null, j.a.actionDropDownStyle);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    private boolean d() {
        Spinner spinner = this.f1237d;
        return spinner != null && spinner.getParent() == this;
    }

    private void e() {
        if (!d()) {
            if (this.f1237d == null) {
                this.f1237d = b();
            }
            removeView(this.f1236c);
            addView(this.f1237d, new ViewGroup.LayoutParams(-2, -1));
            if (this.f1237d.getAdapter() == null) {
                this.f1237d.setAdapter(new b());
            }
            Runnable runnable = this.f1234a;
            if (runnable != null) {
                removeCallbacks(runnable);
                this.f1234a = null;
            }
            this.f1237d.setSelection(this.f1242i);
        }
    }

    private boolean f() {
        if (!d()) {
            return false;
        }
        removeView(this.f1237d);
        addView(this.f1236c, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f1237d.getSelectedItemPosition());
        return false;
    }

    public void a(int i10) {
        View childAt = this.f1236c.getChildAt(i10);
        Runnable runnable = this.f1234a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        a aVar = new a(childAt);
        this.f1234a = aVar;
        post(aVar);
    }

    /* access modifiers changed from: package-private */
    public d c(ActionBar.b bVar, boolean z10) {
        d dVar = new d(getContext(), bVar, z10);
        if (z10) {
            dVar.setBackgroundDrawable((Drawable) null);
            dVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.f1241h));
        } else {
            dVar.setFocusable(true);
            if (this.f1235b == null) {
                this.f1235b = new c();
            }
            dVar.setOnClickListener(this.f1235b);
        }
        return dVar;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f1234a;
        if (runnable != null) {
            post(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        o.a b10 = o.a.b(getContext());
        setContentHeight(b10.f());
        this.f1240g = b10.e();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f1234a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
        ((d) view).b().e();
    }

    public void onMeasure(int i10, int i11) {
        int i12;
        int mode = View.MeasureSpec.getMode(i10);
        boolean z10 = true;
        boolean z11 = mode == 1073741824;
        setFillViewport(z11);
        int childCount = this.f1236c.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            i12 = -1;
        } else {
            if (childCount > 2) {
                this.f1239f = (int) (((float) View.MeasureSpec.getSize(i10)) * 0.4f);
            } else {
                this.f1239f = View.MeasureSpec.getSize(i10) / 2;
            }
            i12 = Math.min(this.f1239f, this.f1240g);
        }
        this.f1239f = i12;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f1241h, 1073741824);
        if (z11 || !this.f1238e) {
            z10 = false;
        }
        if (z10) {
            this.f1236c.measure(0, makeMeasureSpec);
            if (this.f1236c.getMeasuredWidth() > View.MeasureSpec.getSize(i10)) {
                e();
                int measuredWidth = getMeasuredWidth();
                super.onMeasure(i10, makeMeasureSpec);
                int measuredWidth2 = getMeasuredWidth();
                if (z11 && measuredWidth != measuredWidth2) {
                    setTabSelected(this.f1242i);
                    return;
                }
            }
        }
        f();
        int measuredWidth3 = getMeasuredWidth();
        super.onMeasure(i10, makeMeasureSpec);
        int measuredWidth22 = getMeasuredWidth();
        if (z11) {
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z10) {
        this.f1238e = z10;
    }

    public void setContentHeight(int i10) {
        this.f1241h = i10;
        requestLayout();
    }

    public void setTabSelected(int i10) {
        this.f1242i = i10;
        int childCount = this.f1236c.getChildCount();
        int i11 = 0;
        while (i11 < childCount) {
            View childAt = this.f1236c.getChildAt(i11);
            boolean z10 = i11 == i10;
            childAt.setSelected(z10);
            if (z10) {
                a(i10);
            }
            i11++;
        }
        Spinner spinner = this.f1237d;
        if (spinner != null && i10 >= 0) {
            spinner.setSelection(i10);
        }
    }
}
