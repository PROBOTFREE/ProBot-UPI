package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.ref.WeakReference;

public class l0 extends Resources {

    /* renamed from: b  reason: collision with root package name */
    private static boolean f1143b = false;

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Context> f1144a;

    public l0(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f1144a = new WeakReference<>(context);
    }

    public static boolean a() {
        return f1143b;
    }

    public static void b(boolean z10) {
        f1143b = z10;
    }

    public static boolean c() {
        return a() && Build.VERSION.SDK_INT <= 20;
    }

    /* access modifiers changed from: package-private */
    public final Drawable d(int i10) {
        return super.getDrawable(i10);
    }

    public Drawable getDrawable(int i10) {
        Context context = (Context) this.f1144a.get();
        return context != null ? w.h().t(context, this, i10) : super.getDrawable(i10);
    }
}
