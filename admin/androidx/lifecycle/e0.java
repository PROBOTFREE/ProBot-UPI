package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.d0;

public class e0 {
    private static Application a(Activity activity) {
        Application application = activity.getApplication();
        if (application != null) {
            return application;
        }
        throw new IllegalStateException("Your activity/fragment is not yet attached to Application. You can't request ViewModel before onCreate call.");
    }

    public static d0 b(FragmentActivity fragmentActivity, d0.b bVar) {
        Application a10 = a(fragmentActivity);
        if (bVar == null) {
            bVar = d0.a.b(a10);
        }
        return new d0(fragmentActivity.getViewModelStore(), bVar);
    }
}
