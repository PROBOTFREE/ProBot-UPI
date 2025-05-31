package androidx.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import androidx.lifecycle.a0;
import androidx.lifecycle.d0;
import androidx.lifecycle.f0;
import androidx.lifecycle.g;
import androidx.lifecycle.g0;
import androidx.lifecycle.h;
import androidx.lifecycle.h0;
import androidx.lifecycle.i0;
import androidx.lifecycle.m;
import androidx.lifecycle.o;
import androidx.lifecycle.p;
import androidx.lifecycle.y;
import androidx.savedstate.SavedStateRegistry;
import i.a;
import java.util.concurrent.atomic.AtomicInteger;

public class ComponentActivity extends androidx.core.app.ComponentActivity implements g0, g, androidx.savedstate.c, c, androidx.activity.result.c {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    /* access modifiers changed from: private */
    public final ActivityResultRegistry mActivityResultRegistry;
    private int mContentLayoutId;
    final h.a mContextAwareHelper;
    private d0.b mDefaultFactory;
    private final p mLifecycleRegistry;
    private final AtomicInteger mNextLocalRequestCode;
    private final OnBackPressedDispatcher mOnBackPressedDispatcher;
    final androidx.savedstate.b mSavedStateRegistryController;
    private f0 mViewModelStore;

    class a implements Runnable {
        a() {
        }

        public void run() {
            try {
                ComponentActivity.super.onBackPressed();
            } catch (IllegalStateException e10) {
                if (!TextUtils.equals(e10.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    throw e10;
                }
            }
        }
    }

    class b extends ActivityResultRegistry {

        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f173a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ a.C0167a f174b;

            a(int i10, a.C0167a aVar) {
                this.f173a = i10;
                this.f174b = aVar;
            }

            public void run() {
                b.this.c(this.f173a, this.f174b.a());
            }
        }

        /* renamed from: androidx.activity.ComponentActivity$b$b  reason: collision with other inner class name */
        class C0007b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f176a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ IntentSender.SendIntentException f177b;

            C0007b(int i10, IntentSender.SendIntentException sendIntentException) {
                this.f176a = i10;
                this.f177b = sendIntentException;
            }

            public void run() {
                b.this.b(this.f176a, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", this.f177b));
            }
        }

        b() {
        }

        public <I, O> void f(int i10, i.a<I, O> aVar, I i11, androidx.core.app.b bVar) {
            ComponentActivity componentActivity = ComponentActivity.this;
            a.C0167a<O> b10 = aVar.b(componentActivity, i11);
            if (b10 != null) {
                new Handler(Looper.getMainLooper()).post(new a(i10, b10));
                return;
            }
            Intent a10 = aVar.a(componentActivity, i11);
            Bundle bundle = null;
            if (a10.getExtras() != null && a10.getExtras().getClassLoader() == null) {
                a10.setExtrasClassLoader(componentActivity.getClassLoader());
            }
            if (a10.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                bundle = a10.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                a10.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            }
            Bundle bundle2 = bundle;
            if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(a10.getAction())) {
                String[] stringArrayExtra = a10.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                if (stringArrayExtra == null) {
                    stringArrayExtra = new String[0];
                }
                androidx.core.app.a.s(componentActivity, stringArrayExtra, i10);
            } else if ("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(a10.getAction())) {
                IntentSenderRequest intentSenderRequest = (IntentSenderRequest) a10.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
                try {
                    androidx.core.app.a.x(componentActivity, intentSenderRequest.d(), i10, intentSenderRequest.a(), intentSenderRequest.b(), intentSenderRequest.c(), 0, bundle2);
                } catch (IntentSender.SendIntentException e10) {
                    new Handler(Looper.getMainLooper()).post(new C0007b(i10, e10));
                }
            } else {
                androidx.core.app.a.w(componentActivity, a10, i10, bundle2);
            }
        }
    }

    class c implements SavedStateRegistry.b {
        c() {
        }

        @SuppressLint({"SyntheticAccessor"})
        public Bundle a() {
            Bundle bundle = new Bundle();
            ComponentActivity.this.mActivityResultRegistry.h(bundle);
            return bundle;
        }
    }

    class d implements h.b {
        d() {
        }

        @SuppressLint({"SyntheticAccessor"})
        public void a(Context context) {
            Bundle a10 = ComponentActivity.this.getSavedStateRegistry().a(ComponentActivity.ACTIVITY_RESULT_TAG);
            if (a10 != null) {
                ComponentActivity.this.mActivityResultRegistry.g(a10);
            }
        }
    }

    static final class e {

        /* renamed from: a  reason: collision with root package name */
        Object f181a;

        /* renamed from: b  reason: collision with root package name */
        f0 f182b;

        e() {
        }
    }

    public ComponentActivity() {
        this.mContextAwareHelper = new h.a();
        this.mLifecycleRegistry = new p(this);
        this.mSavedStateRegistryController = androidx.savedstate.b.a(this);
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new a());
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new b();
        if (getLifecycle() != null) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 19) {
                getLifecycle().a(new m() {
                    public void c(o oVar, h.b bVar) {
                        if (bVar == h.b.ON_STOP) {
                            Window window = ComponentActivity.this.getWindow();
                            View peekDecorView = window != null ? window.peekDecorView() : null;
                            if (peekDecorView != null) {
                                peekDecorView.cancelPendingInputEvents();
                            }
                        }
                    }
                });
            }
            getLifecycle().a(new m() {
                public void c(o oVar, h.b bVar) {
                    if (bVar == h.b.ON_DESTROY) {
                        ComponentActivity.this.mContextAwareHelper.b();
                        if (!ComponentActivity.this.isChangingConfigurations()) {
                            ComponentActivity.this.getViewModelStore().a();
                        }
                    }
                }
            });
            getLifecycle().a(new m() {
                public void c(o oVar, h.b bVar) {
                    ComponentActivity.this.ensureViewModelStore();
                    ComponentActivity.this.getLifecycle().c(this);
                }
            });
            if (19 <= i10 && i10 <= 23) {
                getLifecycle().a(new ImmLeaksCleaner(this));
            }
            getSavedStateRegistry().d(ACTIVITY_RESULT_TAG, new c());
            addOnContextAvailableListener(new d());
            return;
        }
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    public ComponentActivity(int i10) {
        this();
        this.mContentLayoutId = i10;
    }

    private void initViewTreeOwners() {
        h0.a(getWindow().getDecorView(), this);
        i0.a(getWindow().getDecorView(), this);
        androidx.savedstate.d.a(getWindow().getDecorView(), this);
    }

    public void addContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        super.addContentView(view, layoutParams);
    }

    public final void addOnContextAvailableListener(h.b bVar) {
        this.mContextAwareHelper.a(bVar);
    }

    /* access modifiers changed from: package-private */
    public void ensureViewModelStore() {
        if (this.mViewModelStore == null) {
            e eVar = (e) getLastNonConfigurationInstance();
            if (eVar != null) {
                this.mViewModelStore = eVar.f182b;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new f0();
            }
        }
    }

    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    public d0.b getDefaultViewModelProviderFactory() {
        if (getApplication() != null) {
            if (this.mDefaultFactory == null) {
                this.mDefaultFactory = new a0(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
            }
            return this.mDefaultFactory;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        e eVar = (e) getLastNonConfigurationInstance();
        if (eVar != null) {
            return eVar.f181a;
        }
        return null;
    }

    public h getLifecycle() {
        return this.mLifecycleRegistry;
    }

    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }

    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.b();
    }

    public f0 getViewModelStore() {
        if (getApplication() != null) {
            ensureViewModelStore();
            return this.mViewModelStore;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (!this.mActivityResultRegistry.b(i10, i11, intent)) {
            super.onActivityResult(i10, i11, intent);
        }
    }

    public void onBackPressed() {
        this.mOnBackPressedDispatcher.c();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        this.mSavedStateRegistryController.c(bundle);
        this.mContextAwareHelper.c(this);
        super.onCreate(bundle);
        y.g(this);
        int i10 = this.mContentLayoutId;
        if (i10 != 0) {
            setContentView(i10);
        }
    }

    @Deprecated
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        if (!this.mActivityResultRegistry.b(i10, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr)) && Build.VERSION.SDK_INT >= 23) {
            super.onRequestPermissionsResult(i10, strArr, iArr);
        }
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    public final Object onRetainNonConfigurationInstance() {
        e eVar;
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        f0 f0Var = this.mViewModelStore;
        if (f0Var == null && (eVar = (e) getLastNonConfigurationInstance()) != null) {
            f0Var = eVar.f182b;
        }
        if (f0Var == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        e eVar2 = new e();
        eVar2.f181a = onRetainCustomNonConfigurationInstance;
        eVar2.f182b = f0Var;
        return eVar2;
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        h lifecycle = getLifecycle();
        if (lifecycle instanceof p) {
            ((p) lifecycle).o(h.c.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.d(bundle);
    }

    public Context peekAvailableContext() {
        return this.mContextAwareHelper.d();
    }

    public final <I, O> androidx.activity.result.b<I> registerForActivityResult(i.a<I, O> aVar, ActivityResultRegistry activityResultRegistry, androidx.activity.result.a<O> aVar2) {
        return activityResultRegistry.i("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, aVar, aVar2);
    }

    public final <I, O> androidx.activity.result.b<I> registerForActivityResult(i.a<I, O> aVar, androidx.activity.result.a<O> aVar2) {
        return registerForActivityResult(aVar, this.mActivityResultRegistry, aVar2);
    }

    public final void removeOnContextAvailableListener(h.b bVar) {
        this.mContextAwareHelper.e(bVar);
    }

    public void reportFullyDrawn() {
        try {
            if (w1.a.d()) {
                w1.a.a("reportFullyDrawn() for " + getComponentName());
            }
            int i10 = Build.VERSION.SDK_INT;
            if (i10 > 19 || (i10 == 19 && androidx.core.content.a.a(this, "android.permission.UPDATE_DEVICE_STATS") == 0)) {
                super.reportFullyDrawn();
            }
        } finally {
            w1.a.b();
        }
    }

    public void setContentView(int i10) {
        initViewTreeOwners();
        super.setContentView(i10);
    }

    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        initViewTreeOwners();
        super.setContentView(view);
    }

    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        super.setContentView(view, layoutParams);
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i10) {
        super.startActivityForResult(intent, i10);
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i10, Bundle bundle) {
        super.startActivityForResult(intent, i10, bundle);
    }

    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13) {
        super.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13);
    }

    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) {
        super.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13, bundle);
    }
}
