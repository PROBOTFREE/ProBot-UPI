package a6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.location.ActivityTransition;
import com.google.android.gms.location.ActivityTransitionRequest;
import d5.a;
import java.util.ArrayList;

public final class n implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int L = a.L(parcel);
        ArrayList<ActivityTransition> arrayList = null;
        String str = null;
        ArrayList<ClientIdentity> arrayList2 = null;
        String str2 = null;
        while (parcel.dataPosition() < L) {
            int B = a.B(parcel);
            int v10 = a.v(B);
            if (v10 == 1) {
                arrayList = a.t(parcel, B, ActivityTransition.CREATOR);
            } else if (v10 == 2) {
                str = a.p(parcel, B);
            } else if (v10 == 3) {
                arrayList2 = a.t(parcel, B, ClientIdentity.CREATOR);
            } else if (v10 != 4) {
                a.K(parcel, B);
            } else {
                str2 = a.p(parcel, B);
            }
        }
        a.u(parcel, L);
        return new ActivityTransitionRequest(arrayList, str, arrayList2, str2);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new ActivityTransitionRequest[i10];
    }
}
