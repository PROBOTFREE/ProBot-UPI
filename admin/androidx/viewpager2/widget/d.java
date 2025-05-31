package androidx.viewpager2.widget;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

final class d extends ViewPager2.i {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayoutManager f4383a;

    /* renamed from: b  reason: collision with root package name */
    private ViewPager2.k f4384b;

    d(LinearLayoutManager linearLayoutManager) {
        this.f4383a = linearLayoutManager;
    }

    /* access modifiers changed from: package-private */
    public ViewPager2.k a() {
        return this.f4384b;
    }

    /* access modifiers changed from: package-private */
    public void b(ViewPager2.k kVar) {
        this.f4384b = kVar;
    }

    public void onPageScrollStateChanged(int i10) {
    }

    public void onPageScrolled(int i10, float f10, int i11) {
        if (this.f4384b != null) {
            float f11 = -f10;
            int i12 = 0;
            while (i12 < this.f4383a.X()) {
                View W = this.f4383a.W(i12);
                if (W != null) {
                    this.f4384b.a(W, ((float) (this.f4383a.r0(W) - i10)) + f11);
                    i12++;
                } else {
                    throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", new Object[]{Integer.valueOf(i12), Integer.valueOf(this.f4383a.X())}));
                }
            }
        }
    }

    public void onPageSelected(int i10) {
    }
}
