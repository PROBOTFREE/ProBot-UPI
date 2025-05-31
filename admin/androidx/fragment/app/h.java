package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.content.a;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class h<E> extends e {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f2787a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f2788b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f2789c;

    /* renamed from: d  reason: collision with root package name */
    final FragmentManager f2790d;

    h(Activity activity, Context context, Handler handler, int i10) {
        this.f2790d = new k();
        this.f2787a = activity;
        this.f2788b = (Context) w0.h.f(context, "context == null");
        this.f2789c = (Handler) w0.h.f(handler, "handler == null");
    }

    h(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, new Handler(), 0);
    }

    public View c(int i10) {
        return null;
    }

    public boolean d() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public Activity e() {
        return this.f2787a;
    }

    /* access modifiers changed from: package-private */
    public Context f() {
        return this.f2788b;
    }

    /* access modifiers changed from: package-private */
    public Handler g() {
        return this.f2789c;
    }

    public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public abstract E i();

    public LayoutInflater j() {
        return LayoutInflater.from(this.f2788b);
    }

    @Deprecated
    public void k(Fragment fragment, String[] strArr, int i10) {
    }

    public boolean l(Fragment fragment) {
        return true;
    }

    public boolean m(String str) {
        return false;
    }

    public void n(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i10, Bundle bundle) {
        if (i10 == -1) {
            a.m(this.f2788b, intent, bundle);
            return;
        }
        throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }

    @Deprecated
    public void o(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) {
        if (i10 == -1) {
            androidx.core.app.a.x(this.f2787a, intentSender, i10, intent, i11, i12, i13, bundle);
        } else {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
    }

    public void p() {
    }
}
