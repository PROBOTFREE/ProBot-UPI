package androidx.core.app;

import android.app.RemoteInput;

public final class l {
    static RemoteInput a(l lVar) {
        throw null;
    }

    static RemoteInput[] b(l[] lVarArr) {
        if (lVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[lVarArr.length];
        for (int i10 = 0; i10 < lVarArr.length; i10++) {
            remoteInputArr[i10] = a(lVarArr[i10]);
        }
        return remoteInputArr;
    }
}
