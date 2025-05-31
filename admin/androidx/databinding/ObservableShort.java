package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class ObservableShort extends b implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableShort> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private short f2511a;

    static class a implements Parcelable.Creator<ObservableShort> {
        a() {
        }

        /* renamed from: a */
        public ObservableShort createFromParcel(Parcel parcel) {
            return new ObservableShort((short) parcel.readInt());
        }

        /* renamed from: b */
        public ObservableShort[] newArray(int i10) {
            return new ObservableShort[i10];
        }
    }

    public ObservableShort() {
    }

    public ObservableShort(short s10) {
        this.f2511a = s10;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f2511a);
    }
}
