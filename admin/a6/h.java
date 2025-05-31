package a6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.SleepSegmentEvent;
import d5.a;

public final class h implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int L = a.L(parcel);
        long j10 = 0;
        long j11 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (parcel.dataPosition() < L) {
            int B = a.B(parcel);
            int v10 = a.v(B);
            if (v10 == 1) {
                j10 = a.G(parcel, B);
            } else if (v10 == 2) {
                j11 = a.G(parcel, B);
            } else if (v10 == 3) {
                i10 = a.D(parcel, B);
            } else if (v10 == 4) {
                i11 = a.D(parcel, B);
            } else if (v10 != 5) {
                a.K(parcel, B);
            } else {
                i12 = a.D(parcel, B);
            }
        }
        a.u(parcel, L);
        return new SleepSegmentEvent(j10, j11, i10, i11, i12);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new SleepSegmentEvent[i10];
    }
}
