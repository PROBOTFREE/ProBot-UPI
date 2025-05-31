package a6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStates;
import d5.a;

public final class d implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int L = a.L(parcel);
        Status status = null;
        LocationSettingsStates locationSettingsStates = null;
        while (parcel.dataPosition() < L) {
            int B = a.B(parcel);
            int v10 = a.v(B);
            if (v10 == 1) {
                status = (Status) a.o(parcel, B, Status.CREATOR);
            } else if (v10 != 2) {
                a.K(parcel, B);
            } else {
                locationSettingsStates = (LocationSettingsStates) a.o(parcel, B, LocationSettingsStates.CREATOR);
            }
        }
        a.u(parcel, L);
        return new LocationSettingsResult(status, locationSettingsStates);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new LocationSettingsResult[i10];
    }
}
