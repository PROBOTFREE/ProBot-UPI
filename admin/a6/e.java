package a6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.LocationSettingsStates;
import d5.a;

public final class e implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int L = a.L(parcel);
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = false;
        while (parcel.dataPosition() < L) {
            int B = a.B(parcel);
            switch (a.v(B)) {
                case 1:
                    z10 = a.w(parcel, B);
                    break;
                case 2:
                    z11 = a.w(parcel, B);
                    break;
                case 3:
                    z12 = a.w(parcel, B);
                    break;
                case 4:
                    z13 = a.w(parcel, B);
                    break;
                case 5:
                    z14 = a.w(parcel, B);
                    break;
                case 6:
                    z15 = a.w(parcel, B);
                    break;
                default:
                    a.K(parcel, B);
                    break;
            }
        }
        a.u(parcel, L);
        return new LocationSettingsStates(z10, z11, z12, z13, z14, z15);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new LocationSettingsStates[i10];
    }
}
