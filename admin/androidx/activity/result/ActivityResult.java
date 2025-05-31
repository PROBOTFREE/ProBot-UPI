package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
public final class ActivityResult implements Parcelable {
    public static final Parcelable.Creator<ActivityResult> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final int f196a;

    /* renamed from: b  reason: collision with root package name */
    private final Intent f197b;

    class a implements Parcelable.Creator<ActivityResult> {
        a() {
        }

        /* renamed from: a */
        public ActivityResult createFromParcel(Parcel parcel) {
            return new ActivityResult(parcel);
        }

        /* renamed from: b */
        public ActivityResult[] newArray(int i10) {
            return new ActivityResult[i10];
        }
    }

    public ActivityResult(int i10, Intent intent) {
        this.f196a = i10;
        this.f197b = intent;
    }

    ActivityResult(Parcel parcel) {
        this.f196a = parcel.readInt();
        this.f197b = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }

    public static String c(int i10) {
        return i10 != -1 ? i10 != 0 ? String.valueOf(i10) : "RESULT_CANCELED" : "RESULT_OK";
    }

    public Intent a() {
        return this.f197b;
    }

    public int b() {
        return this.f196a;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + c(this.f196a) + ", data=" + this.f197b + '}';
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f196a);
        parcel.writeInt(this.f197b == null ? 0 : 1);
        Intent intent = this.f197b;
        if (intent != null) {
            intent.writeToParcel(parcel, i10);
        }
    }
}
