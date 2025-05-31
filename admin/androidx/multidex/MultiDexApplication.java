package androidx.multidex;

import android.app.Application;
import android.content.Context;
import n1.a;

public class MultiDexApplication extends Application {
    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        a.l(this);
    }
}
