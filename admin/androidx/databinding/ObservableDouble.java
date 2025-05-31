package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class ObservableDouble extends b implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableDouble> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private double f2507a;

    static class a implements Parcelable.Creator<ObservableDouble> {
        a() {
        }

        /* renamed from: a */
        public ObservableDouble createFromParcel(Parcel parcel) {
            return new ObservableDouble(parcel.readDouble());
        }

        /* renamed from: b */
        public ObservableDouble[] newArray(int i10) {
            return new ObservableDouble[i10];
        }
    }

    public ObservableDouble() {
    }

    public ObservableDouble(double d10) {
        this.f2507a = d10;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeDouble(this.f2507a);
    }
}
