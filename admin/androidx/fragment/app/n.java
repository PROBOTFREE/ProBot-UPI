package androidx.fragment.app;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.h;
import androidx.viewpager.widget.a;

@Deprecated
public abstract class n extends a {

    /* renamed from: a  reason: collision with root package name */
    private final FragmentManager f2806a;

    /* renamed from: b  reason: collision with root package name */
    private final int f2807b;

    /* renamed from: c  reason: collision with root package name */
    private s f2808c;

    /* renamed from: d  reason: collision with root package name */
    private Fragment f2809d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f2810e;

    @Deprecated
    public n(FragmentManager fragmentManager) {
        this(fragmentManager, 0);
    }

    public n(FragmentManager fragmentManager, int i10) {
        this.f2808c = null;
        this.f2809d = null;
        this.f2806a = fragmentManager;
        this.f2807b = i10;
    }

    private static String b(int i10, long j10) {
        return "android:switcher:" + i10 + ":" + j10;
    }

    public long a(int i10) {
        return (long) i10;
    }

    public void destroyItem(ViewGroup viewGroup, int i10, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f2808c == null) {
            this.f2808c = this.f2806a.m();
        }
        this.f2808c.n(fragment);
        if (fragment.equals(this.f2809d)) {
            this.f2809d = null;
        }
    }

    /* JADX INFO: finally extract failed */
    public void finishUpdate(ViewGroup viewGroup) {
        s sVar = this.f2808c;
        if (sVar != null) {
            if (!this.f2810e) {
                try {
                    this.f2810e = true;
                    sVar.m();
                    this.f2810e = false;
                } catch (Throwable th) {
                    this.f2810e = false;
                    throw th;
                }
            }
            this.f2808c = null;
        }
    }

    public abstract Fragment getItem(int i10);

    public Object instantiateItem(ViewGroup viewGroup, int i10) {
        if (this.f2808c == null) {
            this.f2808c = this.f2806a.m();
        }
        long a10 = a(i10);
        Fragment j02 = this.f2806a.j0(b(viewGroup.getId(), a10));
        if (j02 != null) {
            this.f2808c.i(j02);
        } else {
            j02 = getItem(i10);
            this.f2808c.c(viewGroup.getId(), j02, b(viewGroup.getId(), a10));
        }
        if (j02 != this.f2809d) {
            j02.setMenuVisibility(false);
            if (this.f2807b == 1) {
                this.f2808c.u(j02, h.c.STARTED);
            } else {
                j02.setUserVisibleHint(false);
            }
        }
        return j02;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    public Parcelable saveState() {
        return null;
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i10, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f2809d;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.f2807b == 1) {
                    if (this.f2808c == null) {
                        this.f2808c = this.f2806a.m();
                    }
                    this.f2808c.u(this.f2809d, h.c.STARTED);
                } else {
                    this.f2809d.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.f2807b == 1) {
                if (this.f2808c == null) {
                    this.f2808c = this.f2806a.m();
                }
                this.f2808c.u(fragment, h.c.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.f2809d = fragment;
        }
    }

    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }
}
