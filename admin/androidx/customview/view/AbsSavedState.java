package androidx.customview.view;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
public abstract class AbsSavedState implements Parcelable {
    public static final Parcelable.Creator<AbsSavedState> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final AbsSavedState f2499b = new AbsSavedState() {
    };

    /* renamed from: a  reason: collision with root package name */
    private final Parcelable f2500a;

    class a implements Parcelable.ClassLoaderCreator<AbsSavedState> {
        a() {
        }

        /* renamed from: a */
        public AbsSavedState createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, (ClassLoader) null);
        }

        /* renamed from: b */
        public AbsSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return AbsSavedState.f2499b;
            }
            throw new IllegalStateException("superState must be null");
        }

        /* renamed from: c */
        public AbsSavedState[] newArray(int i10) {
            return new AbsSavedState[i10];
        }
    }

    private AbsSavedState() {
        this.f2500a = null;
    }

    protected AbsSavedState(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.f2500a = readParcelable == null ? f2499b : readParcelable;
    }

    protected AbsSavedState(Parcelable parcelable) {
        if (parcelable != null) {
            this.f2500a = parcelable == f2499b ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    public final Parcelable a() {
        return this.f2500a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f2500a, i10);
    }
}
