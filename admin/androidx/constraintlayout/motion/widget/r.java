package androidx.constraintlayout.motion.widget;

import android.view.View;

public final /* synthetic */ class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ s f1718a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View[] f1719b;

    public /* synthetic */ r(s sVar, View[] viewArr) {
        this.f1718a = sVar;
        this.f1719b = viewArr;
    }

    public final void run() {
        this.f1718a.j(this.f1719b);
    }
}
