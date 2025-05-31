package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import androidx.lifecycle.h;

public class y extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private a f3060a;

    interface a {
        void a();

        void b();

        void c();
    }

    static class b implements Application.ActivityLifecycleCallbacks {
        b() {
        }

        static void registerIn(Activity activity) {
            activity.registerActivityLifecycleCallbacks(new b());
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            y.a(activity, h.b.ON_CREATE);
        }

        public void onActivityPostResumed(Activity activity) {
            y.a(activity, h.b.ON_RESUME);
        }

        public void onActivityPostStarted(Activity activity) {
            y.a(activity, h.b.ON_START);
        }

        public void onActivityPreDestroyed(Activity activity) {
            y.a(activity, h.b.ON_DESTROY);
        }

        public void onActivityPrePaused(Activity activity) {
            y.a(activity, h.b.ON_PAUSE);
        }

        public void onActivityPreStopped(Activity activity) {
            y.a(activity, h.b.ON_STOP);
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    static void a(Activity activity, h.b bVar) {
        if (activity instanceof q) {
            ((q) activity).getLifecycle().h(bVar);
        } else if (activity instanceof o) {
            h lifecycle = ((o) activity).getLifecycle();
            if (lifecycle instanceof p) {
                ((p) lifecycle).h(bVar);
            }
        }
    }

    private void b(h.b bVar) {
        if (Build.VERSION.SDK_INT < 29) {
            a(getActivity(), bVar);
        }
    }

    private void c(a aVar) {
        if (aVar != null) {
            aVar.c();
        }
    }

    private void d(a aVar) {
        if (aVar != null) {
            aVar.b();
        }
    }

    private void e(a aVar) {
        if (aVar != null) {
            aVar.a();
        }
    }

    static y f(Activity activity) {
        return (y) activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
    }

    public static void g(Activity activity) {
        if (Build.VERSION.SDK_INT >= 29) {
            b.registerIn(activity);
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new y(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    /* access modifiers changed from: package-private */
    public void h(a aVar) {
        this.f3060a = aVar;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        c(this.f3060a);
        b(h.b.ON_CREATE);
    }

    public void onDestroy() {
        super.onDestroy();
        b(h.b.ON_DESTROY);
        this.f3060a = null;
    }

    public void onPause() {
        super.onPause();
        b(h.b.ON_PAUSE);
    }

    public void onResume() {
        super.onResume();
        d(this.f3060a);
        b(h.b.ON_RESUME);
    }

    public void onStart() {
        super.onStart();
        e(this.f3060a);
        b(h.b.ON_START);
    }

    public void onStop() {
        super.onStop();
        b(h.b.ON_STOP);
    }
}
