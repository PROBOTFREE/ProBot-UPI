package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    ArrayList<FragmentState> f2692a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<String> f2693b;

    /* renamed from: c  reason: collision with root package name */
    BackStackState[] f2694c;

    /* renamed from: d  reason: collision with root package name */
    int f2695d;

    /* renamed from: e  reason: collision with root package name */
    String f2696e = null;

    /* renamed from: f  reason: collision with root package name */
    ArrayList<String> f2697f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    ArrayList<Bundle> f2698g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    ArrayList<FragmentManager.LaunchedFragmentInfo> f2699h;

    class a implements Parcelable.Creator<FragmentManagerState> {
        a() {
        }

        /* renamed from: a */
        public FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        /* renamed from: b */
        public FragmentManagerState[] newArray(int i10) {
            return new FragmentManagerState[i10];
        }
    }

    public FragmentManagerState() {
    }

    public FragmentManagerState(Parcel parcel) {
        this.f2692a = parcel.createTypedArrayList(FragmentState.CREATOR);
        this.f2693b = parcel.createStringArrayList();
        this.f2694c = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
        this.f2695d = parcel.readInt();
        this.f2696e = parcel.readString();
        this.f2697f = parcel.createStringArrayList();
        this.f2698g = parcel.createTypedArrayList(Bundle.CREATOR);
        this.f2699h = parcel.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeTypedList(this.f2692a);
        parcel.writeStringList(this.f2693b);
        parcel.writeTypedArray(this.f2694c, i10);
        parcel.writeInt(this.f2695d);
        parcel.writeString(this.f2696e);
        parcel.writeStringList(this.f2697f);
        parcel.writeTypedList(this.f2698g);
        parcel.writeTypedList(this.f2699h);
    }
}
