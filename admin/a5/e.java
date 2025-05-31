package a5;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import d5.a;

public final class e implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int L = a.L(parcel);
        String str = null;
        int i10 = 0;
        long j10 = -1;
        while (parcel.dataPosition() < L) {
            int B = a.B(parcel);
            int v10 = a.v(B);
            if (v10 == 1) {
                str = a.p(parcel, B);
            } else if (v10 == 2) {
                i10 = a.D(parcel, B);
            } else if (v10 != 3) {
                a.K(parcel, B);
            } else {
                j10 = a.G(parcel, B);
            }
        }
        a.u(parcel, L);
        return new Feature(str, i10, j10);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new Feature[i10];
    }
}
