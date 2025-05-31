package a3;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    private final int f104a;

    /* renamed from: b  reason: collision with root package name */
    private final int f105b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f106c;

    /* renamed from: d  reason: collision with root package name */
    private final int f107d;

    public static final class a {

        /* renamed from: i  reason: collision with root package name */
        static final int f108i = (Build.VERSION.SDK_INT < 26 ? 4 : 1);

        /* renamed from: a  reason: collision with root package name */
        final Context f109a;

        /* renamed from: b  reason: collision with root package name */
        ActivityManager f110b;

        /* renamed from: c  reason: collision with root package name */
        c f111c;

        /* renamed from: d  reason: collision with root package name */
        float f112d = 2.0f;

        /* renamed from: e  reason: collision with root package name */
        float f113e = ((float) f108i);

        /* renamed from: f  reason: collision with root package name */
        float f114f = 0.4f;

        /* renamed from: g  reason: collision with root package name */
        float f115g = 0.33f;

        /* renamed from: h  reason: collision with root package name */
        int f116h = 4194304;

        public a(Context context) {
            this.f109a = context;
            this.f110b = (ActivityManager) context.getSystemService("activity");
            this.f111c = new b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT >= 26 && i.e(this.f110b)) {
                this.f113e = 0.0f;
            }
        }

        public i a() {
            return new i(this);
        }
    }

    private static final class b implements c {

        /* renamed from: a  reason: collision with root package name */
        private final DisplayMetrics f117a;

        b(DisplayMetrics displayMetrics) {
            this.f117a = displayMetrics;
        }

        public int a() {
            return this.f117a.heightPixels;
        }

        public int b() {
            return this.f117a.widthPixels;
        }
    }

    interface c {
        int a();

        int b();
    }

    i(a aVar) {
        this.f106c = aVar.f109a;
        int i10 = e(aVar.f110b) ? aVar.f116h / 2 : aVar.f116h;
        this.f107d = i10;
        int c10 = c(aVar.f110b, aVar.f114f, aVar.f115g);
        float b10 = (float) (aVar.f111c.b() * aVar.f111c.a() * 4);
        int round = Math.round(aVar.f113e * b10);
        int round2 = Math.round(b10 * aVar.f112d);
        int i11 = c10 - i10;
        int i12 = round2 + round;
        if (i12 <= i11) {
            this.f105b = round2;
            this.f104a = round;
        } else {
            float f10 = (float) i11;
            float f11 = aVar.f113e;
            float f12 = aVar.f112d;
            float f13 = f10 / (f11 + f12);
            this.f105b = Math.round(f12 * f13);
            this.f104a = Math.round(f13 * aVar.f113e);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Calculation complete, Calculated memory cache size: ");
            sb2.append(f(this.f105b));
            sb2.append(", pool size: ");
            sb2.append(f(this.f104a));
            sb2.append(", byte array size: ");
            sb2.append(f(i10));
            sb2.append(", memory class limited? ");
            sb2.append(i12 > c10);
            sb2.append(", max size: ");
            sb2.append(f(c10));
            sb2.append(", memoryClass: ");
            sb2.append(aVar.f110b.getMemoryClass());
            sb2.append(", isLowMemoryDevice: ");
            sb2.append(e(aVar.f110b));
            Log.d("MemorySizeCalculator", sb2.toString());
        }
    }

    private static int c(ActivityManager activityManager, float f10, float f11) {
        boolean e10 = e(activityManager);
        float memoryClass = (float) (activityManager.getMemoryClass() * 1024 * 1024);
        if (e10) {
            f10 = f11;
        }
        return Math.round(memoryClass * f10);
    }

    @TargetApi(19)
    static boolean e(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return true;
    }

    private String f(int i10) {
        return Formatter.formatFileSize(this.f106c, (long) i10);
    }

    public int a() {
        return this.f107d;
    }

    public int b() {
        return this.f104a;
    }

    public int d() {
        return this.f105b;
    }
}
