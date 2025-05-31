package a6;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.ActivityTransitionEvent;
import com.google.android.gms.location.ActivityTransitionResult;
import d5.a;
import java.util.ArrayList;

public final class o implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int L = a.L(parcel);
        ArrayList<ActivityTransitionEvent> arrayList = null;
        Bundle bundle = null;
        while (parcel.dataPosition() < L) {
            int B = a.B(parcel);
            int v10 = a.v(B);
            if (v10 == 1) {
                arrayList = a.t(parcel, B, ActivityTransitionEvent.CREATOR);
            } else if (v10 != 2) {
                a.K(parcel, B);
            } else {
                bundle = a.f(parcel, B);
            }
        }
        a.u(parcel, L);
        return new ActivityTransitionResult(arrayList, bundle);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new ActivityTransitionResult[i10];
    }
}
