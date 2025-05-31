package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

class f0 extends x {

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<Context> f1081b;

    public f0(Context context, Resources resources) {
        super(resources);
        this.f1081b = new WeakReference<>(context);
    }

    public Drawable getDrawable(int i10) {
        Drawable drawable = super.getDrawable(i10);
        Context context = (Context) this.f1081b.get();
        if (!(drawable == null || context == null)) {
            w.h().x(context, i10, drawable);
        }
        return drawable;
    }
}
