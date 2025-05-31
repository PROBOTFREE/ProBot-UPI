package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class ObservableBoolean extends b implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableBoolean> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private boolean f2504a;

    static class a implements Parcelable.Creator<ObservableBoolean> {
        a() {
        }

        /* renamed from: a */
        public ObservableBoolean createFromParcel(Parcel parcel) {
            boolean z10 = true;
            if (parcel.readInt() != 1) {
                z10 = false;
            }
            return new ObservableBoolean(z10);
        }

        /* renamed from: b */
        public ObservableBoolean[] newArray(int i10) {
            return new ObservableBoolean[i10];
        }
    }

    public ObservableBoolean() {
    }

    public ObservableBoolean(boolean z10) {
        this.f2504a = z10;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f2504a ? 1 : 0);
    }
}
