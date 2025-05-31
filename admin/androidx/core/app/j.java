package androidx.core.app;

import android.app.Notification;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.app.h;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.Field;
import java.util.List;

class j {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f2258a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static Field f2259b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f2260c;

    public static SparseArray<Bundle> a(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i10 = 0; i10 < size; i10++) {
            Bundle bundle = list.get(i10);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i10, bundle);
            }
        }
        return sparseArray;
    }

    static Bundle b(h.a aVar) {
        Bundle bundle = new Bundle();
        IconCompat e10 = aVar.e();
        bundle.putInt("icon", e10 != null ? e10.e() : 0);
        bundle.putCharSequence("title", aVar.i());
        bundle.putParcelable("actionIntent", aVar.a());
        Bundle bundle2 = aVar.d() != null ? new Bundle(aVar.d()) : new Bundle();
        bundle2.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        bundle.putBundle("extras", bundle2);
        bundle.putParcelableArray("remoteInputs", e(aVar.f()));
        bundle.putBoolean("showsUserInterface", aVar.h());
        bundle.putInt("semanticAction", aVar.g());
        return bundle;
    }

    public static Bundle c(Notification notification) {
        String str;
        String str2;
        synchronized (f2258a) {
            if (f2260c) {
                return null;
            }
            try {
                if (f2259b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f2260c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    f2259b = declaredField;
                }
                Bundle bundle = (Bundle) f2259b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f2259b.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e10) {
                e = e10;
                str = "NotificationCompat";
                str2 = "Unable to access notification extras";
                Log.e(str, str2, e);
                f2260c = true;
                return null;
            } catch (NoSuchFieldException e11) {
                e = e11;
                str = "NotificationCompat";
                str2 = "Unable to access notification extras";
                Log.e(str, str2, e);
                f2260c = true;
                return null;
            }
        }
    }

    private static Bundle d(l lVar) {
        new Bundle();
        throw null;
    }

    private static Bundle[] e(l[] lVarArr) {
        if (lVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[lVarArr.length];
        for (int i10 = 0; i10 < lVarArr.length; i10++) {
            bundleArr[i10] = d(lVarArr[i10]);
        }
        return bundleArr;
    }

    public static Bundle f(Notification.Builder builder, h.a aVar) {
        IconCompat e10 = aVar.e();
        builder.addAction(e10 != null ? e10.e() : 0, aVar.i(), aVar.a());
        Bundle bundle = new Bundle(aVar.d());
        if (aVar.f() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", e(aVar.f()));
        }
        if (aVar.c() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", e(aVar.c()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        return bundle;
    }
}
