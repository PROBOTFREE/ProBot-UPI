package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class ObservableInt extends b implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableInt> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private int f2509a;

    static class a implements Parcelable.Creator<ObservableInt> {
        a() {
        }

        /* renamed from: a */
        public ObservableInt createFromParcel(Parcel parcel) {
            return new ObservableInt(parcel.readInt());
        }

        /* renamed from: b */
        public ObservableInt[] newArray(int i10) {
            return new ObservableInt[i10];
        }
    }

    public ObservableInt() {
    }

    public ObservableInt(int i10) {
        this.f2509a = i10;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f2509a);
    }
}
