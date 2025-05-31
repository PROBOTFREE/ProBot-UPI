package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.lifecycle.g0;
import w0.h;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private final h<?> f2786a;

    private f(h<?> hVar) {
        this.f2786a = hVar;
    }

    public static f b(h<?> hVar) {
        return new f((h) h.f(hVar, "callbacks == null"));
    }

    public void a(Fragment fragment) {
        h<?> hVar = this.f2786a;
        hVar.f2790d.k(hVar, hVar, fragment);
    }

    public void c() {
        this.f2786a.f2790d.z();
    }

    public void d(Configuration configuration) {
        this.f2786a.f2790d.B(configuration);
    }

    public boolean e(MenuItem menuItem) {
        return this.f2786a.f2790d.C(menuItem);
    }

    public void f() {
        this.f2786a.f2790d.D();
    }

    public boolean g(Menu menu, MenuInflater menuInflater) {
        return this.f2786a.f2790d.E(menu, menuInflater);
    }

    public void h() {
        this.f2786a.f2790d.F();
    }

    public void i() {
        this.f2786a.f2790d.H();
    }

    public void j(boolean z10) {
        this.f2786a.f2790d.I(z10);
    }

    public boolean k(MenuItem menuItem) {
        return this.f2786a.f2790d.K(menuItem);
    }

    public void l(Menu menu) {
        this.f2786a.f2790d.L(menu);
    }

    public void m() {
        this.f2786a.f2790d.N();
    }

    public void n(boolean z10) {
        this.f2786a.f2790d.O(z10);
    }

    public boolean o(Menu menu) {
        return this.f2786a.f2790d.P(menu);
    }

    public void p() {
        this.f2786a.f2790d.R();
    }

    public void q() {
        this.f2786a.f2790d.S();
    }

    public void r() {
        this.f2786a.f2790d.U();
    }

    public boolean s() {
        return this.f2786a.f2790d.b0(true);
    }

    public FragmentManager t() {
        return this.f2786a.f2790d;
    }

    public void u() {
        this.f2786a.f2790d.V0();
    }

    public View v(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f2786a.f2790d.w0().onCreateView(view, str, context, attributeSet);
    }

    public void w(Parcelable parcelable) {
        h<?> hVar = this.f2786a;
        if (hVar instanceof g0) {
            hVar.f2790d.k1(parcelable);
            return;
        }
        throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
    }

    public Parcelable x() {
        return this.f2786a.f2790d.m1();
    }
}
