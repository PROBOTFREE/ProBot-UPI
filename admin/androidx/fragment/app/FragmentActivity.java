package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.core.app.a;
import androidx.core.app.m;
import androidx.lifecycle.f0;
import androidx.lifecycle.g0;
import androidx.lifecycle.h;
import androidx.lifecycle.p;
import androidx.savedstate.SavedStateRegistry;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class FragmentActivity extends ComponentActivity implements a.c, a.e {
    static final String FRAGMENTS_TAG = "android:support:fragments";
    boolean mCreated;
    final p mFragmentLifecycleRegistry = new p(this);
    final f mFragments = f.b(new c());
    boolean mResumed;
    boolean mStopped = true;

    class a implements SavedStateRegistry.b {
        a() {
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            FragmentActivity.this.markFragmentsCreated();
            FragmentActivity.this.mFragmentLifecycleRegistry.h(h.b.ON_STOP);
            Parcelable x10 = FragmentActivity.this.mFragments.x();
            if (x10 != null) {
                bundle.putParcelable(FragmentActivity.FRAGMENTS_TAG, x10);
            }
            return bundle;
        }
    }

    class b implements h.b {
        b() {
        }

        public void a(Context context) {
            FragmentActivity.this.mFragments.a((Fragment) null);
            Bundle a10 = FragmentActivity.this.getSavedStateRegistry().a(FragmentActivity.FRAGMENTS_TAG);
            if (a10 != null) {
                FragmentActivity.this.mFragments.w(a10.getParcelable(FragmentActivity.FRAGMENTS_TAG));
            }
        }
    }

    class c extends h<FragmentActivity> implements g0, androidx.activity.c, androidx.activity.result.c, m {
        public c() {
            super(FragmentActivity.this);
        }

        public void a(FragmentManager fragmentManager, Fragment fragment) {
            FragmentActivity.this.onAttachFragment(fragment);
        }

        public View c(int i10) {
            return FragmentActivity.this.findViewById(i10);
        }

        public boolean d() {
            Window window = FragmentActivity.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        public ActivityResultRegistry getActivityResultRegistry() {
            return FragmentActivity.this.getActivityResultRegistry();
        }

        public h getLifecycle() {
            return FragmentActivity.this.mFragmentLifecycleRegistry;
        }

        public OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return FragmentActivity.this.getOnBackPressedDispatcher();
        }

        public f0 getViewModelStore() {
            return FragmentActivity.this.getViewModelStore();
        }

        public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            FragmentActivity.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        public LayoutInflater j() {
            return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
        }

        public boolean l(Fragment fragment) {
            return !FragmentActivity.this.isFinishing();
        }

        public boolean m(String str) {
            return androidx.core.app.a.v(FragmentActivity.this, str);
        }

        public void p() {
            FragmentActivity.this.supportInvalidateOptionsMenu();
        }

        /* renamed from: q */
        public FragmentActivity i() {
            return FragmentActivity.this;
        }
    }

    public FragmentActivity() {
        init();
    }

    public FragmentActivity(int i10) {
        super(i10);
        init();
    }

    private void init() {
        getSavedStateRegistry().d(FRAGMENTS_TAG, new a());
        addOnContextAvailableListener(new b());
    }

    private static boolean markState(FragmentManager fragmentManager, h.c cVar) {
        boolean z10 = false;
        for (Fragment next : fragmentManager.u0()) {
            if (next != null) {
                if (next.getHost() != null) {
                    z10 |= markState(next.getChildFragmentManager(), cVar);
                }
                w wVar = next.mViewLifecycleOwner;
                if (wVar != null && wVar.getLifecycle().b().a(h.c.STARTED)) {
                    next.mViewLifecycleOwner.f(cVar);
                    z10 = true;
                }
                if (next.mLifecycleRegistry.b().a(h.c.STARTED)) {
                    next.mLifecycleRegistry.o(cVar);
                    z10 = true;
                }
            }
        }
        return z10;
    }

    /* access modifiers changed from: package-private */
    public final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.v(view, str, context, attributeSet);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print(" mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        if (getApplication() != null) {
            androidx.loader.app.a.b(this).a(str2, fileDescriptor, printWriter, strArr);
        }
        this.mFragments.t().X(str, fileDescriptor, printWriter, strArr);
    }

    public FragmentManager getSupportFragmentManager() {
        return this.mFragments.t();
    }

    @Deprecated
    public androidx.loader.app.a getSupportLoaderManager() {
        return androidx.loader.app.a.b(this);
    }

    /* access modifiers changed from: package-private */
    public void markFragmentsCreated() {
        do {
        } while (markState(getSupportFragmentManager(), h.c.CREATED));
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i10, int i11, Intent intent) {
        this.mFragments.u();
        super.onActivityResult(i10, i11, intent);
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.mFragments.u();
        super.onConfigurationChanged(configuration);
        this.mFragments.d(configuration);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.h(h.b.ON_CREATE);
        this.mFragments.f();
    }

    public boolean onCreatePanelMenu(int i10, Menu menu) {
        return i10 == 0 ? super.onCreatePanelMenu(i10, menu) | this.mFragments.g(menu, getMenuInflater()) : super.onCreatePanelMenu(i10, menu);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView((View) null, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.mFragments.h();
        this.mFragmentLifecycleRegistry.h(h.b.ON_DESTROY);
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.i();
    }

    public boolean onMenuItemSelected(int i10, MenuItem menuItem) {
        if (super.onMenuItemSelected(i10, menuItem)) {
            return true;
        }
        if (i10 == 0) {
            return this.mFragments.k(menuItem);
        }
        if (i10 != 6) {
            return false;
        }
        return this.mFragments.e(menuItem);
    }

    public void onMultiWindowModeChanged(boolean z10) {
        this.mFragments.j(z10);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        this.mFragments.u();
        super.onNewIntent(intent);
    }

    public void onPanelClosed(int i10, Menu menu) {
        if (i10 == 0) {
            this.mFragments.l(menu);
        }
        super.onPanelClosed(i10, menu);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.m();
        this.mFragmentLifecycleRegistry.h(h.b.ON_PAUSE);
    }

    public void onPictureInPictureModeChanged(boolean z10) {
        this.mFragments.n(z10);
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public boolean onPreparePanel(int i10, View view, Menu menu) {
        return i10 == 0 ? onPrepareOptionsPanel(view, menu) | this.mFragments.o(menu) : super.onPreparePanel(i10, view, menu);
    }

    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        this.mFragments.u();
        super.onRequestPermissionsResult(i10, strArr, iArr);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        this.mFragments.u();
        super.onResume();
        this.mResumed = true;
        this.mFragments.s();
    }

    /* access modifiers changed from: protected */
    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.h(h.b.ON_RESUME);
        this.mFragments.p();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        this.mFragments.u();
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.c();
        }
        this.mFragments.s();
        this.mFragmentLifecycleRegistry.h(h.b.ON_START);
        this.mFragments.q();
    }

    public void onStateNotSaved() {
        this.mFragments.u();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mFragments.r();
        this.mFragmentLifecycleRegistry.h(h.b.ON_STOP);
    }

    public void setEnterSharedElementCallback(m mVar) {
        androidx.core.app.a.t(this, mVar);
    }

    public void setExitSharedElementCallback(m mVar) {
        androidx.core.app.a.u(this, mVar);
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i10) {
        startActivityFromFragment(fragment, intent, i10, (Bundle) null);
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i10, Bundle bundle) {
        if (i10 == -1) {
            androidx.core.app.a.w(this, intent, -1, bundle);
        } else {
            fragment.startActivityForResult(intent, i10, bundle);
        }
    }

    @Deprecated
    public void startIntentSenderFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) {
        if (i10 == -1) {
            androidx.core.app.a.x(this, intentSender, i10, intent, i11, i12, i13, bundle);
        } else {
            fragment.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13, bundle);
        }
    }

    public void supportFinishAfterTransition() {
        androidx.core.app.a.p(this);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void supportPostponeEnterTransition() {
        androidx.core.app.a.q(this);
    }

    public void supportStartPostponedEnterTransition() {
        androidx.core.app.a.y(this);
    }

    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i10) {
    }
}
