package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.h;
import androidx.viewpager.widget.a;
import java.util.ArrayList;

@Deprecated
public abstract class q extends a {
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;
    @Deprecated
    public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;
    private static final boolean DEBUG = false;
    private static final String TAG = "FragmentStatePagerAdapt";
    private final int mBehavior;
    private s mCurTransaction;
    private Fragment mCurrentPrimaryItem;
    private boolean mExecutingFinishUpdate;
    private final FragmentManager mFragmentManager;
    private ArrayList<Fragment> mFragments;
    private ArrayList<Fragment.SavedState> mSavedState;

    @Deprecated
    public q(FragmentManager fragmentManager) {
        this(fragmentManager, 0);
    }

    public q(FragmentManager fragmentManager, int i10) {
        this.mCurTransaction = null;
        this.mSavedState = new ArrayList<>();
        this.mFragments = new ArrayList<>();
        this.mCurrentPrimaryItem = null;
        this.mFragmentManager = fragmentManager;
        this.mBehavior = i10;
    }

    public void destroyItem(ViewGroup viewGroup, int i10, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.m();
        }
        while (this.mSavedState.size() <= i10) {
            this.mSavedState.add((Object) null);
        }
        this.mSavedState.set(i10, fragment.isAdded() ? this.mFragmentManager.n1(fragment) : null);
        this.mFragments.set(i10, (Object) null);
        this.mCurTransaction.q(fragment);
        if (fragment.equals(this.mCurrentPrimaryItem)) {
            this.mCurrentPrimaryItem = null;
        }
    }

    /* JADX INFO: finally extract failed */
    public void finishUpdate(ViewGroup viewGroup) {
        s sVar = this.mCurTransaction;
        if (sVar != null) {
            if (!this.mExecutingFinishUpdate) {
                try {
                    this.mExecutingFinishUpdate = true;
                    sVar.m();
                    this.mExecutingFinishUpdate = false;
                } catch (Throwable th) {
                    this.mExecutingFinishUpdate = false;
                    throw th;
                }
            }
            this.mCurTransaction = null;
        }
    }

    public abstract Fragment getItem(int i10);

    public Object instantiateItem(ViewGroup viewGroup, int i10) {
        Fragment.SavedState savedState;
        Fragment fragment;
        if (this.mFragments.size() > i10 && (fragment = this.mFragments.get(i10)) != null) {
            return fragment;
        }
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.m();
        }
        Fragment item = getItem(i10);
        if (this.mSavedState.size() > i10 && (savedState = this.mSavedState.get(i10)) != null) {
            item.setInitialSavedState(savedState);
        }
        while (this.mFragments.size() <= i10) {
            this.mFragments.add((Object) null);
        }
        item.setMenuVisibility(false);
        if (this.mBehavior == 0) {
            item.setUserVisibleHint(false);
        }
        this.mFragments.set(i10, item);
        this.mCurTransaction.b(viewGroup.getId(), item);
        if (this.mBehavior == 1) {
            this.mCurTransaction.u(item, h.c.STARTED);
        }
        return item;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.mSavedState.clear();
            this.mFragments.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.mSavedState.add((Fragment.SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment q02 = this.mFragmentManager.q0(bundle, str);
                    if (q02 != null) {
                        while (this.mFragments.size() <= parseInt) {
                            this.mFragments.add((Object) null);
                        }
                        q02.setMenuVisibility(false);
                        this.mFragments.set(parseInt, q02);
                    } else {
                        Log.w(TAG, "Bad fragment at key " + str);
                    }
                }
            }
        }
    }

    public Parcelable saveState() {
        Bundle bundle;
        if (this.mSavedState.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.mSavedState.size()];
            this.mSavedState.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        } else {
            bundle = null;
        }
        for (int i10 = 0; i10 < this.mFragments.size(); i10++) {
            Fragment fragment = this.mFragments.get(i10);
            if (fragment != null && fragment.isAdded()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.mFragmentManager.e1(bundle, "f" + i10, fragment);
            }
        }
        return bundle;
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i10, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.mCurrentPrimaryItem;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.mBehavior == 1) {
                    if (this.mCurTransaction == null) {
                        this.mCurTransaction = this.mFragmentManager.m();
                    }
                    this.mCurTransaction.u(this.mCurrentPrimaryItem, h.c.STARTED);
                } else {
                    this.mCurrentPrimaryItem.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.mBehavior == 1) {
                if (this.mCurTransaction == null) {
                    this.mCurTransaction = this.mFragmentManager.m();
                }
                this.mCurTransaction.u(fragment, h.c.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.mCurrentPrimaryItem = fragment;
        }
    }

    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }
}
