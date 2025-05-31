package a6;

import android.os.IBinder;
import android.os.IInterface;
import w5.c;

public abstract class t extends c implements u {
    public static u b0(IBinder iBinder) {
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
        return queryLocalInterface instanceof u ? (u) queryLocalInterface : new s(iBinder);
    }
}
