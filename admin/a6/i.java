package a6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.SleepSegmentRequest;
import com.google.android.gms.location.zzaj;
import d5.a;
import java.util.ArrayList;

public final class i implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int L = a.L(parcel);
        ArrayList<zzaj> arrayList = null;
        int i10 = 0;
        while (parcel.dataPosition() < L) {
            int B = a.B(parcel);
            int v10 = a.v(B);
            if (v10 == 1) {
                arrayList = a.t(parcel, B, zzaj.CREATOR);
            } else if (v10 != 2) {
                a.K(parcel, B);
            } else {
                i10 = a.D(parcel, B);
            }
        }
        a.u(parcel, L);
        return new SleepSegmentRequest(arrayList, i10);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new SleepSegmentRequest[i10];
    }
}
