package a6;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;
import d5.a;
import java.util.ArrayList;

public final class l implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int L = a.L(parcel);
        long j10 = 0;
        long j11 = 0;
        ArrayList<DetectedActivity> arrayList = null;
        Bundle bundle = null;
        int i10 = 0;
        while (parcel.dataPosition() < L) {
            int B = a.B(parcel);
            int v10 = a.v(B);
            if (v10 == 1) {
                arrayList = a.t(parcel, B, DetectedActivity.CREATOR);
            } else if (v10 == 2) {
                j10 = a.G(parcel, B);
            } else if (v10 == 3) {
                j11 = a.G(parcel, B);
            } else if (v10 == 4) {
                i10 = a.D(parcel, B);
            } else if (v10 != 5) {
                a.K(parcel, B);
            } else {
                bundle = a.f(parcel, B);
            }
        }
        a.u(parcel, L);
        return new ActivityRecognitionResult(arrayList, j10, j11, i10, bundle);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new ActivityRecognitionResult[i10];
    }
}
