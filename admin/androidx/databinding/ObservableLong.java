package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class ObservableLong extends b implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableLong> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private long f2510a;

    static class a implements Parcelable.Creator<ObservableLong> {
        a() {
        }

        /* renamed from: a */
        public ObservableLong createFromParcel(Parcel parcel) {
            return new ObservableLong(parcel.readLong());
        }

        /* renamed from: b */
        public ObservableLong[] newArray(int i10) {
            return new ObservableLong[i10];
        }
    }

    public ObservableLong() {
    }

    public ObservableLong(long j10) {
        this.f2510a = j10;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f2510a);
    }
}
