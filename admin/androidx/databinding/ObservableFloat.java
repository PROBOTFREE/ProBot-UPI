package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class ObservableFloat extends b implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableFloat> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private float f2508a;

    static class a implements Parcelable.Creator<ObservableFloat> {
        a() {
        }

        /* renamed from: a */
        public ObservableFloat createFromParcel(Parcel parcel) {
            return new ObservableFloat(parcel.readFloat());
        }

        /* renamed from: b */
        public ObservableFloat[] newArray(int i10) {
            return new ObservableFloat[i10];
        }
    }

    public ObservableFloat() {
    }

    public ObservableFloat(float f10) {
        this.f2508a = f10;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeFloat(this.f2508a);
    }
}
