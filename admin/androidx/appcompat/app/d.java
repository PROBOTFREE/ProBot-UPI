package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.l0;
import c0.b;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import o.b;

public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    private static int f387a = -100;

    /* renamed from: b  reason: collision with root package name */
    private static final b<WeakReference<d>> f388b = new b<>();

    /* renamed from: c  reason: collision with root package name */
    private static final Object f389c = new Object();

    d() {
    }

    public static void B(boolean z10) {
        l0.b(z10);
    }

    static void c(d dVar) {
        synchronized (f389c) {
            z(dVar);
            f388b.add(new WeakReference(dVar));
        }
    }

    public static d g(Activity activity, c cVar) {
        return new AppCompatDelegateImpl(activity, cVar);
    }

    public static d h(Dialog dialog, c cVar) {
        return new AppCompatDelegateImpl(dialog, cVar);
    }

    public static int j() {
        return f387a;
    }

    static void y(d dVar) {
        synchronized (f389c) {
            z(dVar);
        }
    }

    private static void z(d dVar) {
        synchronized (f389c) {
            Iterator<WeakReference<d>> it = f388b.iterator();
            while (it.hasNext()) {
                d dVar2 = (d) it.next().get();
                if (dVar2 == dVar || dVar2 == null) {
                    it.remove();
                }
            }
        }
    }

    public abstract boolean A(int i10);

    public abstract void C(int i10);

    public abstract void D(View view);

    public abstract void E(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void F(Toolbar toolbar);

    public void G(int i10) {
    }

    public abstract void H(CharSequence charSequence);

    public abstract o.b I(b.a aVar);

    public abstract void d(View view, ViewGroup.LayoutParams layoutParams);

    @Deprecated
    public void e(Context context) {
    }

    public Context f(Context context) {
        e(context);
        return context;
    }

    public abstract <T extends View> T i(int i10);

    public abstract a k();

    public int l() {
        return -100;
    }

    public abstract MenuInflater m();

    public abstract ActionBar n();

    public abstract void o();

    public abstract void p();

    public abstract void q(Configuration configuration);

    public abstract void r(Bundle bundle);

    public abstract void s();

    public abstract void t(Bundle bundle);

    public abstract void u();

    public abstract void v(Bundle bundle);

    public abstract void w();

    public abstract void x();
}
