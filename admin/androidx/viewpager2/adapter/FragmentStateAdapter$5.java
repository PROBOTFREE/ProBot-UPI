package androidx.viewpager2.adapter;

import android.os.Handler;
import androidx.lifecycle.h;
import androidx.lifecycle.m;
import androidx.lifecycle.o;

class FragmentStateAdapter$5 implements m {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Handler f4339a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Runnable f4340b;

    public void c(o oVar, h.b bVar) {
        if (bVar == h.b.ON_DESTROY) {
            this.f4339a.removeCallbacks(this.f4340b);
            oVar.getLifecycle().c(this);
        }
    }
}
