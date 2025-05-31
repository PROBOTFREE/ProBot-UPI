package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;

public class ObservableParcelable<T extends Parcelable> extends i<T> implements Parcelable {
    public static final Parcelable.Creator<ObservableParcelable> CREATOR = new a();

    static class a implements Parcelable.Creator<ObservableParcelable> {
        a() {
        }

        /* renamed from: a */
        public ObservableParcelable createFromParcel(Parcel parcel) {
            return new ObservableParcelable(parcel.readParcelable(a.class.getClassLoader()));
        }

        /* renamed from: b */
        public ObservableParcelable[] newArray(int i10) {
            return new ObservableParcelable[i10];
        }
    }

    public ObservableParcelable() {
    }

    public ObservableParcelable(T t10) {
        super(t10);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable((Parcelable) a(), 0);
    }
}
