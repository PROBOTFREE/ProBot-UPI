package androidx.core.content;

import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.AppOpsManager;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.app.UiModeManager;
import android.app.WallpaperManager;
import android.app.admin.DevicePolicyManager;
import android.app.job.JobScheduler;
import android.app.usage.UsageStatsManager;
import android.appwidget.AppWidgetManager;
import android.bluetooth.BluetoothManager;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.RestrictionsManager;
import android.content.pm.LauncherApps;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.hardware.ConsumerIrManager;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraManager;
import android.hardware.display.DisplayManager;
import android.hardware.input.InputManager;
import android.hardware.usb.UsbManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaRouter;
import android.media.projection.MediaProjectionManager;
import android.media.session.MediaSessionManager;
import android.media.tv.TvInputManager;
import android.net.ConnectivityManager;
import android.net.nsd.NsdManager;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.NfcManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.os.PowerManager;
import android.os.Process;
import android.os.UserManager;
import android.os.Vibrator;
import android.os.storage.StorageManager;
import android.print.PrintManager;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.CaptioningManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;
import com.mintoak.corelib.util.Constants;
import java.io.File;
import java.util.HashMap;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f2275a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static final Object f2276b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static TypedValue f2277c;

    /* renamed from: androidx.core.content.a$a  reason: collision with other inner class name */
    static class C0021a {
        static void a(Context context, Intent[] intentArr, Bundle bundle) {
            context.startActivities(intentArr, bundle);
        }

        static void b(Context context, Intent intent, Bundle bundle) {
            context.startActivity(intent, bundle);
        }
    }

    static class b {
        static File[] a(Context context) {
            return context.getExternalCacheDirs();
        }

        static File[] b(Context context, String str) {
            return context.getExternalFilesDirs(str);
        }

        static File[] c(Context context) {
            return context.getObbDirs();
        }
    }

    static class c {
        static File a(Context context) {
            return context.getCodeCacheDir();
        }

        static Drawable b(Context context, int i10) {
            return context.getDrawable(i10);
        }

        static File c(Context context) {
            return context.getNoBackupFilesDir();
        }
    }

    static class d {
        static int a(Context context, int i10) {
            return context.getColor(i10);
        }

        static ColorStateList b(Context context, int i10) {
            return context.getColorStateList(i10);
        }

        static <T> T c(Context context, Class<T> cls) {
            return context.getSystemService(cls);
        }

        static String d(Context context, Class<?> cls) {
            return context.getSystemServiceName(cls);
        }
    }

    static class e {
        static Context a(Context context) {
            return context.createDeviceProtectedStorageContext();
        }

        static File b(Context context) {
            return context.getDataDir();
        }

        static boolean c(Context context) {
            return context.isDeviceProtectedStorage();
        }
    }

    static class f {
        static ComponentName a(Context context, Intent intent) {
            return context.startForegroundService(intent);
        }
    }

    private static final class g {

        /* renamed from: a  reason: collision with root package name */
        static final HashMap<Class<?>, String> f2278a;

        static {
            HashMap<Class<?>, String> hashMap = new HashMap<>();
            f2278a = hashMap;
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 22) {
                hashMap.put(SubscriptionManager.class, "telephony_subscription_service");
                hashMap.put(UsageStatsManager.class, "usagestats");
            }
            if (i10 >= 21) {
                hashMap.put(AppWidgetManager.class, "appwidget");
                hashMap.put(BatteryManager.class, "batterymanager");
                hashMap.put(CameraManager.class, "camera");
                hashMap.put(JobScheduler.class, "jobscheduler");
                hashMap.put(LauncherApps.class, "launcherapps");
                hashMap.put(MediaProjectionManager.class, "media_projection");
                hashMap.put(MediaSessionManager.class, "media_session");
                hashMap.put(RestrictionsManager.class, "restrictions");
                hashMap.put(TelecomManager.class, "telecom");
                hashMap.put(TvInputManager.class, "tv_input");
            }
            if (i10 >= 19) {
                hashMap.put(AppOpsManager.class, "appops");
                hashMap.put(CaptioningManager.class, "captioning");
                hashMap.put(ConsumerIrManager.class, "consumer_ir");
                hashMap.put(PrintManager.class, "print");
            }
            if (i10 >= 18) {
                hashMap.put(BluetoothManager.class, "bluetooth");
            }
            if (i10 >= 17) {
                hashMap.put(DisplayManager.class, "display");
                hashMap.put(UserManager.class, Constants.ADDED_USER);
            }
            if (i10 >= 16) {
                hashMap.put(InputManager.class, "input");
                hashMap.put(MediaRouter.class, "media_router");
                hashMap.put(NsdManager.class, "servicediscovery");
            }
            hashMap.put(AccessibilityManager.class, "accessibility");
            hashMap.put(AccountManager.class, "account");
            hashMap.put(ActivityManager.class, "activity");
            hashMap.put(AlarmManager.class, "alarm");
            hashMap.put(AudioManager.class, "audio");
            hashMap.put(ClipboardManager.class, "clipboard");
            hashMap.put(ConnectivityManager.class, "connectivity");
            hashMap.put(DevicePolicyManager.class, "device_policy");
            hashMap.put(DownloadManager.class, "download");
            hashMap.put(DropBoxManager.class, "dropbox");
            hashMap.put(InputMethodManager.class, "input_method");
            hashMap.put(KeyguardManager.class, "keyguard");
            hashMap.put(LayoutInflater.class, "layout_inflater");
            hashMap.put(LocationManager.class, "location");
            hashMap.put(NfcManager.class, "nfc");
            hashMap.put(NotificationManager.class, "notification");
            hashMap.put(PowerManager.class, "power");
            hashMap.put(SearchManager.class, "search");
            hashMap.put(SensorManager.class, "sensor");
            hashMap.put(StorageManager.class, "storage");
            hashMap.put(TelephonyManager.class, "phone");
            hashMap.put(TextServicesManager.class, "textservices");
            hashMap.put(UiModeManager.class, "uimode");
            hashMap.put(UsbManager.class, "usb");
            hashMap.put(Vibrator.class, "vibrator");
            hashMap.put(WallpaperManager.class, "wallpaper");
            hashMap.put(WifiP2pManager.class, "wifip2p");
            hashMap.put(WifiManager.class, "wifi");
            hashMap.put(WindowManager.class, "window");
        }
    }

    public static int a(Context context, String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }

    public static Context b(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return e.a(context);
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.io.File c(java.io.File r4) {
        /*
            java.lang.Object r0 = f2276b
            monitor-enter(r0)
            boolean r1 = r4.exists()     // Catch:{ all -> 0x002d }
            if (r1 != 0) goto L_0x002b
            boolean r1 = r4.mkdirs()     // Catch:{ all -> 0x002d }
            if (r1 == 0) goto L_0x0011
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return r4
        L_0x0011:
            java.lang.String r1 = "ContextCompat"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x002d }
            r2.<init>()     // Catch:{ all -> 0x002d }
            java.lang.String r3 = "Unable to create files subdir "
            r2.append(r3)     // Catch:{ all -> 0x002d }
            java.lang.String r3 = r4.getPath()     // Catch:{ all -> 0x002d }
            r2.append(r3)     // Catch:{ all -> 0x002d }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x002d }
            android.util.Log.w(r1, r2)     // Catch:{ all -> 0x002d }
        L_0x002b:
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return r4
        L_0x002d:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.a.c(java.io.File):java.io.File");
    }

    public static int d(Context context, int i10) {
        return Build.VERSION.SDK_INT >= 23 ? d.a(context, i10) : context.getResources().getColor(i10);
    }

    public static ColorStateList e(Context context, int i10) {
        return n0.f.e(context.getResources(), i10, context.getTheme());
    }

    public static Drawable f(Context context, int i10) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 21) {
            return c.b(context, i10);
        }
        if (i11 < 16) {
            synchronized (f2275a) {
                if (f2277c == null) {
                    f2277c = new TypedValue();
                }
                context.getResources().getValue(i10, f2277c, true);
                i10 = f2277c.resourceId;
            }
        }
        return context.getResources().getDrawable(i10);
    }

    public static File[] g(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return b.a(context);
        }
        return new File[]{context.getExternalCacheDir()};
    }

    public static File[] h(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 19) {
            return b.b(context, str);
        }
        return new File[]{context.getExternalFilesDir(str)};
    }

    public static File i(Context context) {
        return Build.VERSION.SDK_INT >= 21 ? c.c(context) : c(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }

    public static <T> T j(Context context, Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 23) {
            return d.c(context, cls);
        }
        String k10 = k(context, cls);
        if (k10 != null) {
            return context.getSystemService(k10);
        }
        return null;
    }

    public static String k(Context context, Class<?> cls) {
        return Build.VERSION.SDK_INT >= 23 ? d.d(context, cls) : g.f2278a.get(cls);
    }

    public static boolean l(Context context, Intent[] intentArr, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            C0021a.a(context, intentArr, bundle);
            return true;
        }
        context.startActivities(intentArr);
        return true;
    }

    public static void m(Context context, Intent intent, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            C0021a.b(context, intent, bundle);
        } else {
            context.startActivity(intent);
        }
    }

    public static void n(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            f.a(context, intent);
        } else {
            context.startService(intent);
        }
    }
}
