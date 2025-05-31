package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar extends ProgressBar {

    /* renamed from: a  reason: collision with root package name */
    boolean f2419a = false;

    /* renamed from: b  reason: collision with root package name */
    private final Runnable f2420b = new d(this);

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f2421c = new e(this);

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c() {
        setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d() {
        if (!this.f2419a) {
            System.currentTimeMillis();
            setVisibility(0);
        }
    }

    private void e() {
        removeCallbacks(this.f2420b);
        removeCallbacks(this.f2421c);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        e();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }
}
