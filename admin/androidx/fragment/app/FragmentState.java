package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    final String f2700a;

    /* renamed from: b  reason: collision with root package name */
    final String f2701b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f2702c;

    /* renamed from: d  reason: collision with root package name */
    final int f2703d;

    /* renamed from: e  reason: collision with root package name */
    final int f2704e;

    /* renamed from: f  reason: collision with root package name */
    final String f2705f;

    /* renamed from: g  reason: collision with root package name */
    final boolean f2706g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f2707h;

    /* renamed from: i  reason: collision with root package name */
    final boolean f2708i;

    /* renamed from: j  reason: collision with root package name */
    final Bundle f2709j;

    /* renamed from: k  reason: collision with root package name */
    final boolean f2710k;

    /* renamed from: l  reason: collision with root package name */
    final int f2711l;

    /* renamed from: m  reason: collision with root package name */
    Bundle f2712m;

    class a implements Parcelable.Creator<FragmentState> {
        a() {
        }

        /* renamed from: a */
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        /* renamed from: b */
        public FragmentState[] newArray(int i10) {
            return new FragmentState[i10];
        }
    }

    FragmentState(Parcel parcel) {
        this.f2700a = parcel.readString();
        this.f2701b = parcel.readString();
        boolean z10 = true;
        this.f2702c = parcel.readInt() != 0;
        this.f2703d = parcel.readInt();
        this.f2704e = parcel.readInt();
        this.f2705f = parcel.readString();
        this.f2706g = parcel.readInt() != 0;
        this.f2707h = parcel.readInt() != 0;
        this.f2708i = parcel.readInt() != 0;
        this.f2709j = parcel.readBundle();
        this.f2710k = parcel.readInt() == 0 ? false : z10;
        this.f2712m = parcel.readBundle();
        this.f2711l = parcel.readInt();
    }

    FragmentState(Fragment fragment) {
        this.f2700a = fragment.getClass().getName();
        this.f2701b = fragment.mWho;
        this.f2702c = fragment.mFromLayout;
        this.f2703d = fragment.mFragmentId;
        this.f2704e = fragment.mContainerId;
        this.f2705f = fragment.mTag;
        this.f2706g = fragment.mRetainInstance;
        this.f2707h = fragment.mRemoving;
        this.f2708i = fragment.mDetached;
        this.f2709j = fragment.mArguments;
        this.f2710k = fragment.mHidden;
        this.f2711l = fragment.mMaxState.ordinal();
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("FragmentState{");
        sb2.append(this.f2700a);
        sb2.append(" (");
        sb2.append(this.f2701b);
        sb2.append(")}:");
        if (this.f2702c) {
            sb2.append(" fromLayout");
        }
        if (this.f2704e != 0) {
            sb2.append(" id=0x");
            sb2.append(Integer.toHexString(this.f2704e));
        }
        String str = this.f2705f;
        if (str != null && !str.isEmpty()) {
            sb2.append(" tag=");
            sb2.append(this.f2705f);
        }
        if (this.f2706g) {
            sb2.append(" retainInstance");
        }
        if (this.f2707h) {
            sb2.append(" removing");
        }
        if (this.f2708i) {
            sb2.append(" detached");
        }
        if (this.f2710k) {
            sb2.append(" hidden");
        }
        return sb2.toString();
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f2700a);
        parcel.writeString(this.f2701b);
        parcel.writeInt(this.f2702c ? 1 : 0);
        parcel.writeInt(this.f2703d);
        parcel.writeInt(this.f2704e);
        parcel.writeString(this.f2705f);
        parcel.writeInt(this.f2706g ? 1 : 0);
        parcel.writeInt(this.f2707h ? 1 : 0);
        parcel.writeInt(this.f2708i ? 1 : 0);
        parcel.writeBundle(this.f2709j);
        parcel.writeInt(this.f2710k ? 1 : 0);
        parcel.writeBundle(this.f2712m);
        parcel.writeInt(this.f2711l);
    }
}
