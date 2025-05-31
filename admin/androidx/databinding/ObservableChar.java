package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class ObservableChar extends b implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableChar> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private char f2506a;

    static class a implements Parcelable.Creator<ObservableChar> {
        a() {
        }

        /* renamed from: a */
        public ObservableChar createFromParcel(Parcel parcel) {
            return new ObservableChar((char) parcel.readInt());
        }

        /* renamed from: b */
        public ObservableChar[] newArray(int i10) {
            return new ObservableChar[i10];
        }
    }

    public ObservableChar() {
    }

    public ObservableChar(char c10) {
        this.f2506a = c10;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f2506a);
    }
}
