package a6;

import android.os.IBinder;
import android.os.IInterface;
import w5.c;

public abstract class w extends c implements x {
    public static x b0(IBinder iBinder) {
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationListener");
        return queryLocalInterface instanceof x ? (x) queryLocalInterface : new v(iBinder);
    }
}
