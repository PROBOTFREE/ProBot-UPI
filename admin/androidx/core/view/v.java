package androidx.core.view;

import android.content.Context;
import android.os.Build;
import android.view.PointerIcon;

public final class v {

    /* renamed from: a  reason: collision with root package name */
    private Object f2393a;

    private v(Object obj) {
        this.f2393a = obj;
    }

    public static v b(Context context, int i10) {
        return Build.VERSION.SDK_INT >= 24 ? new v(PointerIcon.getSystemIcon(context, i10)) : new v((Object) null);
    }

    public Object a() {
        return this.f2393a;
    }
}
