package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;

public class h {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final Bundle f2204a;

        /* renamed from: b  reason: collision with root package name */
        private IconCompat f2205b;

        /* renamed from: c  reason: collision with root package name */
        private final l[] f2206c;

        /* renamed from: d  reason: collision with root package name */
        private final l[] f2207d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f2208e;

        /* renamed from: f  reason: collision with root package name */
        boolean f2209f;

        /* renamed from: g  reason: collision with root package name */
        private final int f2210g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f2211h;
        @Deprecated

        /* renamed from: i  reason: collision with root package name */
        public int f2212i;

        /* renamed from: j  reason: collision with root package name */
        public CharSequence f2213j;

        /* renamed from: k  reason: collision with root package name */
        public PendingIntent f2214k;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public a(int i10, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i10 != 0 ? IconCompat.c((Resources) null, "", i10) : null, charSequence, pendingIntent);
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), (l[]) null, (l[]) null, true, 0, true, false);
        }

        a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, l[] lVarArr, l[] lVarArr2, boolean z10, int i10, boolean z11, boolean z12) {
            this.f2209f = true;
            this.f2205b = iconCompat;
            if (iconCompat != null && iconCompat.i() == 2) {
                this.f2212i = iconCompat.e();
            }
            this.f2213j = e.d(charSequence);
            this.f2214k = pendingIntent;
            this.f2204a = bundle == null ? new Bundle() : bundle;
            this.f2206c = lVarArr;
            this.f2207d = lVarArr2;
            this.f2208e = z10;
            this.f2210g = i10;
            this.f2209f = z11;
            this.f2211h = z12;
        }

        public PendingIntent a() {
            return this.f2214k;
        }

        public boolean b() {
            return this.f2208e;
        }

        public l[] c() {
            return this.f2207d;
        }

        public Bundle d() {
            return this.f2204a;
        }

        public IconCompat e() {
            int i10;
            if (this.f2205b == null && (i10 = this.f2212i) != 0) {
                this.f2205b = IconCompat.c((Resources) null, "", i10);
            }
            return this.f2205b;
        }

        public l[] f() {
            return this.f2206c;
        }

        public int g() {
            return this.f2210g;
        }

        public boolean h() {
            return this.f2209f;
        }

        public CharSequence i() {
            return this.f2213j;
        }

        public boolean j() {
            return this.f2211h;
        }
    }

    public static class b extends f {

        /* renamed from: e  reason: collision with root package name */
        private Bitmap f2215e;

        /* renamed from: f  reason: collision with root package name */
        private IconCompat f2216f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f2217g;

        private static class a {
            static void a(Notification.BigPictureStyle bigPictureStyle, Bitmap bitmap) {
                bigPictureStyle.bigLargeIcon(bitmap);
            }

            static void b(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                bigPictureStyle.setSummaryText(charSequence);
            }
        }

        /* renamed from: androidx.core.app.h$b$b  reason: collision with other inner class name */
        private static class C0020b {
            static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigLargeIcon(icon);
            }
        }

        public void b(g gVar) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 16) {
                Notification.BigPictureStyle bigPicture = new Notification.BigPictureStyle(gVar.a()).setBigContentTitle(this.f2246b).bigPicture(this.f2215e);
                if (this.f2217g) {
                    IconCompat iconCompat = this.f2216f;
                    Context context = null;
                    if (iconCompat != null) {
                        if (i10 >= 23) {
                            if (gVar instanceof i) {
                                context = ((i) gVar).f();
                            }
                            C0020b.a(bigPicture, this.f2216f.q(context));
                        } else if (iconCompat.i() == 1) {
                            a.a(bigPicture, this.f2216f.d());
                        }
                    }
                    a.a(bigPicture, (Bitmap) null);
                }
                if (this.f2248d) {
                    a.b(bigPicture, this.f2247c);
                }
            }
        }

        /* access modifiers changed from: protected */
        public String c() {
            return "androidx.core.app.NotificationCompat$BigPictureStyle";
        }

        public b h(Bitmap bitmap) {
            this.f2216f = bitmap == null ? null : IconCompat.b(bitmap);
            this.f2217g = true;
            return this;
        }

        public b i(Bitmap bitmap) {
            this.f2215e = bitmap;
            return this;
        }
    }

    public static class c extends f {

        /* renamed from: e  reason: collision with root package name */
        private CharSequence f2218e;

        public void a(Bundle bundle) {
            super.a(bundle);
            if (Build.VERSION.SDK_INT < 21) {
                bundle.putCharSequence("android.bigText", this.f2218e);
            }
        }

        public void b(g gVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigTextStyle bigText = new Notification.BigTextStyle(gVar.a()).setBigContentTitle(this.f2246b).bigText(this.f2218e);
                if (this.f2248d) {
                    bigText.setSummaryText(this.f2247c);
                }
            }
        }

        /* access modifiers changed from: protected */
        public String c() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        public c h(CharSequence charSequence) {
            this.f2218e = e.d(charSequence);
            return this;
        }
    }

    public static final class d {
        public static Notification.BubbleMetadata a(d dVar) {
            return null;
        }
    }

    public static class e {
        boolean A;
        boolean B;
        String C;
        Bundle D;
        int E;
        int F;
        Notification G;
        RemoteViews H;
        RemoteViews I;
        RemoteViews J;
        String K;
        int L;
        String M;
        long N;
        int O;
        boolean P;
        d Q;
        Notification R;
        boolean S;
        Icon T;
        @Deprecated
        public ArrayList<String> U;

        /* renamed from: a  reason: collision with root package name */
        public Context f2219a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<a> f2220b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<k> f2221c;

        /* renamed from: d  reason: collision with root package name */
        ArrayList<a> f2222d;

        /* renamed from: e  reason: collision with root package name */
        CharSequence f2223e;

        /* renamed from: f  reason: collision with root package name */
        CharSequence f2224f;

        /* renamed from: g  reason: collision with root package name */
        PendingIntent f2225g;

        /* renamed from: h  reason: collision with root package name */
        PendingIntent f2226h;

        /* renamed from: i  reason: collision with root package name */
        RemoteViews f2227i;

        /* renamed from: j  reason: collision with root package name */
        Bitmap f2228j;

        /* renamed from: k  reason: collision with root package name */
        CharSequence f2229k;

        /* renamed from: l  reason: collision with root package name */
        int f2230l;

        /* renamed from: m  reason: collision with root package name */
        int f2231m;

        /* renamed from: n  reason: collision with root package name */
        boolean f2232n;

        /* renamed from: o  reason: collision with root package name */
        boolean f2233o;

        /* renamed from: p  reason: collision with root package name */
        f f2234p;

        /* renamed from: q  reason: collision with root package name */
        CharSequence f2235q;

        /* renamed from: r  reason: collision with root package name */
        CharSequence f2236r;

        /* renamed from: s  reason: collision with root package name */
        CharSequence[] f2237s;

        /* renamed from: t  reason: collision with root package name */
        int f2238t;

        /* renamed from: u  reason: collision with root package name */
        int f2239u;

        /* renamed from: v  reason: collision with root package name */
        boolean f2240v;

        /* renamed from: w  reason: collision with root package name */
        String f2241w;

        /* renamed from: x  reason: collision with root package name */
        boolean f2242x;

        /* renamed from: y  reason: collision with root package name */
        String f2243y;

        /* renamed from: z  reason: collision with root package name */
        boolean f2244z;

        @Deprecated
        public e(Context context) {
            this(context, (String) null);
        }

        public e(Context context, String str) {
            this.f2220b = new ArrayList<>();
            this.f2221c = new ArrayList<>();
            this.f2222d = new ArrayList<>();
            this.f2232n = true;
            this.f2244z = false;
            this.E = 0;
            this.F = 0;
            this.L = 0;
            this.O = 0;
            Notification notification = new Notification();
            this.R = notification;
            this.f2219a = context;
            this.K = str;
            notification.when = System.currentTimeMillis();
            this.R.audioStreamType = -1;
            this.f2231m = 0;
            this.U = new ArrayList<>();
            this.P = true;
        }

        protected static CharSequence d(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        private Bitmap e(Bitmap bitmap) {
            if (bitmap == null || Build.VERSION.SDK_INT >= 27) {
                return bitmap;
            }
            Resources resources = this.f2219a.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(m0.b.compat_notification_large_icon_max_width);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(m0.b.compat_notification_large_icon_max_height);
            if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
                return bitmap;
            }
            double min = Math.min(((double) dimensionPixelSize) / ((double) Math.max(1, bitmap.getWidth())), ((double) dimensionPixelSize2) / ((double) Math.max(1, bitmap.getHeight())));
            return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * min), (int) Math.ceil(((double) bitmap.getHeight()) * min), true);
        }

        private void p(int i10, boolean z10) {
            Notification notification;
            int i11;
            if (z10) {
                notification = this.R;
                i11 = i10 | notification.flags;
            } else {
                notification = this.R;
                i11 = (~i10) & notification.flags;
            }
            notification.flags = i11;
        }

        public e A(f fVar) {
            if (this.f2234p != fVar) {
                this.f2234p = fVar;
                if (fVar != null) {
                    fVar.g(this);
                }
            }
            return this;
        }

        public e B(CharSequence charSequence) {
            this.R.tickerText = d(charSequence);
            return this;
        }

        public e C(long[] jArr) {
            this.R.vibrate = jArr;
            return this;
        }

        public e D(int i10) {
            this.F = i10;
            return this;
        }

        public e E(long j10) {
            this.R.when = j10;
            return this;
        }

        public e a(int i10, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f2220b.add(new a(i10, charSequence, pendingIntent));
            return this;
        }

        public Notification b() {
            return new i(this).c();
        }

        public Bundle c() {
            if (this.D == null) {
                this.D = new Bundle();
            }
            return this.D;
        }

        public e f(boolean z10) {
            p(16, z10);
            return this;
        }

        public e g(String str) {
            this.C = str;
            return this;
        }

        public e h(String str) {
            this.K = str;
            return this;
        }

        public e i(int i10) {
            this.E = i10;
            return this;
        }

        public e j(RemoteViews remoteViews) {
            this.R.contentView = remoteViews;
            return this;
        }

        public e k(PendingIntent pendingIntent) {
            this.f2225g = pendingIntent;
            return this;
        }

        public e l(CharSequence charSequence) {
            this.f2224f = d(charSequence);
            return this;
        }

        public e m(CharSequence charSequence) {
            this.f2223e = d(charSequence);
            return this;
        }

        public e n(int i10) {
            Notification notification = this.R;
            notification.defaults = i10;
            if ((i10 & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        public e o(PendingIntent pendingIntent) {
            this.R.deleteIntent = pendingIntent;
            return this;
        }

        public e q(Bitmap bitmap) {
            this.f2228j = e(bitmap);
            return this;
        }

        public e r(int i10, int i11, int i12) {
            Notification notification = this.R;
            notification.ledARGB = i10;
            notification.ledOnMS = i11;
            notification.ledOffMS = i12;
            notification.flags = ((i11 == 0 || i12 == 0) ? 0 : 1) | (notification.flags & -2);
            return this;
        }

        public e s(boolean z10) {
            this.f2244z = z10;
            return this;
        }

        public e t(int i10) {
            this.f2230l = i10;
            return this;
        }

        public e u(boolean z10) {
            p(2, z10);
            return this;
        }

        public e v(boolean z10) {
            p(8, z10);
            return this;
        }

        public e w(int i10) {
            this.f2231m = i10;
            return this;
        }

        public e x(boolean z10) {
            this.f2232n = z10;
            return this;
        }

        public e y(int i10) {
            this.R.icon = i10;
            return this;
        }

        public e z(Uri uri) {
            Notification notification = this.R;
            notification.sound = uri;
            notification.audioStreamType = -1;
            if (Build.VERSION.SDK_INT >= 21) {
                notification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
            }
            return this;
        }
    }

    public static abstract class f {

        /* renamed from: a  reason: collision with root package name */
        protected e f2245a;

        /* renamed from: b  reason: collision with root package name */
        CharSequence f2246b;

        /* renamed from: c  reason: collision with root package name */
        CharSequence f2247c;

        /* renamed from: d  reason: collision with root package name */
        boolean f2248d = false;

        public void a(Bundle bundle) {
            if (this.f2248d) {
                bundle.putCharSequence("android.summaryText", this.f2247c);
            }
            CharSequence charSequence = this.f2246b;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String c10 = c();
            if (c10 != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", c10);
            }
        }

        public abstract void b(g gVar);

        /* access modifiers changed from: protected */
        public abstract String c();

        public RemoteViews d(g gVar) {
            return null;
        }

        public RemoteViews e(g gVar) {
            return null;
        }

        public RemoteViews f(g gVar) {
            return null;
        }

        public void g(e eVar) {
            if (this.f2245a != eVar) {
                this.f2245a = eVar;
                if (eVar != null) {
                    eVar.A(this);
                }
            }
        }
    }

    public static Bundle a(Notification notification) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 19) {
            return notification.extras;
        }
        if (i10 >= 16) {
            return j.c(notification);
        }
        return null;
    }
}
