package a6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.DetectedActivity;
import d5.a;

public final class p implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int L = a.L(parcel);
        int i10 = 0;
        int i11 = 0;
        while (parcel.dataPosition() < L) {
            int B = a.B(parcel);
            int v10 = a.v(B);
            if (v10 == 1) {
                i10 = a.D(parcel, B);
            } else if (v10 != 2) {
                a.K(parcel, B);
            } else {
                i11 = a.D(parcel, B);
            }
        }
        a.u(parcel, L);
        return new DetectedActivity(i10, i11);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new DetectedActivity[i10];
    }
}
