package androidx.viewpager2.widget;

import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

final class b extends ViewPager2.i {

    /* renamed from: a  reason: collision with root package name */
    private final List<ViewPager2.i> f4381a;

    b(int i10) {
        this.f4381a = new ArrayList(i10);
    }

    private void b(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }

    /* access modifiers changed from: package-private */
    public void a(ViewPager2.i iVar) {
        this.f4381a.add(iVar);
    }

    public void onPageScrollStateChanged(int i10) {
        try {
            for (ViewPager2.i onPageScrollStateChanged : this.f4381a) {
                onPageScrollStateChanged.onPageScrollStateChanged(i10);
            }
        } catch (ConcurrentModificationException e10) {
            b(e10);
        }
    }

    public void onPageScrolled(int i10, float f10, int i11) {
        try {
            for (ViewPager2.i onPageScrolled : this.f4381a) {
                onPageScrolled.onPageScrolled(i10, f10, i11);
            }
        } catch (ConcurrentModificationException e10) {
            b(e10);
        }
    }

    public void onPageSelected(int i10) {
        try {
            for (ViewPager2.i onPageSelected : this.f4381a) {
                onPageSelected.onPageSelected(i10);
            }
        } catch (ConcurrentModificationException e10) {
            b(e10);
        }
    }
}
