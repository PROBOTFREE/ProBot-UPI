package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Arrays;

public class a extends androidx.core.content.a {

    /* renamed from: d  reason: collision with root package name */
    private static d f2176d;

    /* renamed from: androidx.core.app.a$a  reason: collision with other inner class name */
    class C0018a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String[] f2177a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f2178b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f2179c;

        C0018a(String[] strArr, Activity activity, int i10) {
            this.f2177a = strArr;
            this.f2178b = activity;
            this.f2179c = i10;
        }

        public void run() {
            int[] iArr = new int[this.f2177a.length];
            PackageManager packageManager = this.f2178b.getPackageManager();
            String packageName = this.f2178b.getPackageName();
            int length = this.f2177a.length;
            for (int i10 = 0; i10 < length; i10++) {
                iArr[i10] = packageManager.checkPermission(this.f2177a[i10], packageName);
            }
            ((c) this.f2178b).onRequestPermissionsResult(this.f2179c, this.f2177a, iArr);
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f2180a;

        b(Activity activity) {
            this.f2180a = activity;
        }

        public void run() {
            if (!this.f2180a.isFinishing() && !c.i(this.f2180a)) {
                this.f2180a.recreate();
            }
        }
    }

    public interface c {
        void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr);
    }

    public interface d {
        boolean a(Activity activity, String[] strArr, int i10);
    }

    public interface e {
        void validateRequestPermissionsRequestCode(int i10);
    }

    public static void o(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }

    public static void p(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.finishAfterTransition();
        } else {
            activity.finish();
        }
    }

    public static void q(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.postponeEnterTransition();
        }
    }

    public static void r(Activity activity) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 28) {
            if (i10 <= 23) {
                new Handler(activity.getMainLooper()).post(new b(activity));
                return;
            } else if (c.i(activity)) {
                return;
            }
        }
        activity.recreate();
    }

    public static void s(Activity activity, String[] strArr, int i10) {
        d dVar = f2176d;
        if (dVar == null || !dVar.a(activity, strArr, i10)) {
            int length = strArr.length;
            int i11 = 0;
            while (i11 < length) {
                if (!TextUtils.isEmpty(strArr[i11])) {
                    i11++;
                } else {
                    throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
                }
            }
            if (Build.VERSION.SDK_INT >= 23) {
                if (activity instanceof e) {
                    ((e) activity).validateRequestPermissionsRequestCode(i10);
                }
                activity.requestPermissions(strArr, i10);
            } else if (activity instanceof c) {
                new Handler(Looper.getMainLooper()).post(new C0018a(strArr, activity, i10));
            }
        }
    }

    public static void t(Activity activity, m mVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setEnterSharedElementCallback((SharedElementCallback) null);
        }
    }

    public static void u(Activity activity, m mVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setExitSharedElementCallback((SharedElementCallback) null);
        }
    }

    public static boolean v(Activity activity, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
        return false;
    }

    public static void w(Activity activity, Intent intent, int i10, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startActivityForResult(intent, i10, bundle);
        } else {
            activity.startActivityForResult(intent, i10);
        }
    }

    public static void x(Activity activity, IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13, bundle);
        } else {
            activity.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13);
        }
    }

    public static void y(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.startPostponedEnterTransition();
        }
    }
}
