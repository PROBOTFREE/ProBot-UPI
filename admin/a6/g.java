package a6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.SleepClassifyEvent;
import d5.a;

public final class g implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int L = a.L(parcel);
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        boolean z10 = false;
        int i17 = 0;
        while (parcel.dataPosition() < L) {
            int B = a.B(parcel);
            switch (a.v(B)) {
                case 1:
                    i10 = a.D(parcel, B);
                    break;
                case 2:
                    i11 = a.D(parcel, B);
                    break;
                case 3:
                    i12 = a.D(parcel, B);
                    break;
                case 4:
                    i13 = a.D(parcel, B);
                    break;
                case 5:
                    i14 = a.D(parcel, B);
                    break;
                case 6:
                    i15 = a.D(parcel, B);
                    break;
                case 7:
                    i16 = a.D(parcel, B);
                    break;
                case 8:
                    z10 = a.w(parcel, B);
                    break;
                case 9:
                    i17 = a.D(parcel, B);
                    break;
                default:
                    a.K(parcel, B);
                    break;
            }
        }
        a.u(parcel, L);
        return new SleepClassifyEvent(i10, i11, i12, i13, i14, i15, i16, z10, i17);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new SleepClassifyEvent[i10];
    }
}
