package androidx.core.app;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import net.sqlcipher.database.SQLiteDatabase;

public final class n implements Iterable<Intent> {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<Intent> f2267a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final Context f2268b;

    public interface a {
        Intent getSupportParentActivityIntent();
    }

    private n(Context context) {
        this.f2268b = context;
    }

    public static n t(Context context) {
        return new n(context);
    }

    public n c(Intent intent) {
        this.f2267a.add(intent);
        return this;
    }

    public n f(Intent intent) {
        ComponentName component = intent.getComponent();
        if (component == null) {
            component = intent.resolveActivity(this.f2268b.getPackageManager());
        }
        if (component != null) {
            i(component);
        }
        c(intent);
        return this;
    }

    public n h(Activity activity) {
        Intent supportParentActivityIntent = activity instanceof a ? ((a) activity).getSupportParentActivityIntent() : null;
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = f.a(activity);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(this.f2268b.getPackageManager());
            }
            i(component);
            c(supportParentActivityIntent);
        }
        return this;
    }

    public n i(ComponentName componentName) {
        int size = this.f2267a.size();
        try {
            Context context = this.f2268b;
            while (true) {
                Intent b10 = f.b(context, componentName);
                if (b10 == null) {
                    return this;
                }
                this.f2267a.add(size, b10);
                context = this.f2268b;
                componentName = b10.getComponent();
            }
        } catch (PackageManager.NameNotFoundException e10) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e10);
        }
    }

    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f2267a.iterator();
    }

    public n k(Class<?> cls) {
        return i(new ComponentName(this.f2268b, cls));
    }

    public PendingIntent u(int i10, int i11) {
        return v(i10, i11, (Bundle) null);
    }

    public PendingIntent v(int i10, int i11, Bundle bundle) {
        if (!this.f2267a.isEmpty()) {
            ArrayList<Intent> arrayList = this.f2267a;
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            return Build.VERSION.SDK_INT >= 16 ? PendingIntent.getActivities(this.f2268b, i10, intentArr, i11, bundle) : PendingIntent.getActivities(this.f2268b, i10, intentArr, i11);
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
    }

    public void w() {
        x((Bundle) null);
    }

    public void x(Bundle bundle) {
        if (!this.f2267a.isEmpty()) {
            ArrayList<Intent> arrayList = this.f2267a;
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            if (!androidx.core.content.a.l(this.f2268b, intentArr, bundle)) {
                Intent intent = new Intent(intentArr[intentArr.length - 1]);
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                this.f2268b.startActivity(intent);
                return;
            }
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }
}
