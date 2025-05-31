package a6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.zzaj;
import d5.a;

public final class k implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int L = a.L(parcel);
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (parcel.dataPosition() < L) {
            int B = a.B(parcel);
            int v10 = a.v(B);
            if (v10 == 1) {
                i10 = a.D(parcel, B);
            } else if (v10 == 2) {
                i11 = a.D(parcel, B);
            } else if (v10 == 3) {
                i12 = a.D(parcel, B);
            } else if (v10 != 4) {
                a.K(parcel, B);
            } else {
                i13 = a.D(parcel, B);
            }
        }
        a.u(parcel, L);
        return new zzaj(i10, i11, i12, i13);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzaj[i10];
    }
}
