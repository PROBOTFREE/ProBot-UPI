package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TabHost;
import java.util.ArrayList;

@Deprecated
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<a> f2713a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private Context f2714b;

    /* renamed from: c  reason: collision with root package name */
    private FragmentManager f2715c;

    /* renamed from: d  reason: collision with root package name */
    private int f2716d;

    /* renamed from: e  reason: collision with root package name */
    private TabHost.OnTabChangeListener f2717e;

    /* renamed from: f  reason: collision with root package name */
    private a f2718f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f2719g;

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        String f2720a;

        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f2720a = parcel.readString();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f2720a + "}";
        }

        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeString(this.f2720a);
        }
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        final String f2721a;

        /* renamed from: b  reason: collision with root package name */
        final Class<?> f2722b;

        /* renamed from: c  reason: collision with root package name */
        final Bundle f2723c;

        /* renamed from: d  reason: collision with root package name */
        Fragment f2724d;
    }

    @Deprecated
    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context, attributeSet);
    }

    private s a(String str, s sVar) {
        Fragment fragment;
        a b10 = b(str);
        if (this.f2718f != b10) {
            if (sVar == null) {
                sVar = this.f2715c.m();
            }
            a aVar = this.f2718f;
            if (!(aVar == null || (fragment = aVar.f2724d) == null)) {
                sVar.n(fragment);
            }
            if (b10 != null) {
                Fragment fragment2 = b10.f2724d;
                if (fragment2 == null) {
                    Fragment instantiate = this.f2715c.s0().instantiate(this.f2714b.getClassLoader(), b10.f2722b.getName());
                    b10.f2724d = instantiate;
                    instantiate.setArguments(b10.f2723c);
                    sVar.c(this.f2716d, b10.f2724d, b10.f2721a);
                } else {
                    sVar.i(fragment2);
                }
            }
            this.f2718f = b10;
        }
        return sVar;
    }

    private a b(String str) {
        int size = this.f2713a.size();
        for (int i10 = 0; i10 < size; i10++) {
            a aVar = this.f2713a.get(i10);
            if (aVar.f2721a.equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842995}, 0, 0);
        this.f2716d = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        int size = this.f2713a.size();
        s sVar = null;
        for (int i10 = 0; i10 < size; i10++) {
            a aVar = this.f2713a.get(i10);
            Fragment j02 = this.f2715c.j0(aVar.f2721a);
            aVar.f2724d = j02;
            if (j02 != null && !j02.isDetached()) {
                if (aVar.f2721a.equals(currentTabTag)) {
                    this.f2718f = aVar;
                } else {
                    if (sVar == null) {
                        sVar = this.f2715c.m();
                    }
                    sVar.n(aVar.f2724d);
                }
            }
        }
        this.f2719g = true;
        s a10 = a(currentTabTag, sVar);
        if (a10 != null) {
            a10.j();
            this.f2715c.f0();
        }
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2719g = false;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onRestoreInstanceState(@SuppressLint({"UnknownNullness"}) Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.f2720a);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f2720a = getCurrentTabTag();
        return savedState;
    }

    @Deprecated
    public void onTabChanged(String str) {
        s a10;
        if (this.f2719g && (a10 = a(str, (s) null)) != null) {
            a10.j();
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.f2717e;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    @Deprecated
    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        this.f2717e = onTabChangeListener;
    }

    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }
}
