package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

class v {
    static int a(RecyclerView.z zVar, s sVar, View view, View view2, RecyclerView.p pVar, boolean z10) {
        if (pVar.X() == 0 || zVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z10) {
            return Math.abs(pVar.r0(view) - pVar.r0(view2)) + 1;
        }
        return Math.min(sVar.n(), sVar.d(view2) - sVar.g(view));
    }

    static int b(RecyclerView.z zVar, s sVar, View view, View view2, RecyclerView.p pVar, boolean z10, boolean z11) {
        if (pVar.X() == 0 || zVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z11 ? Math.max(0, (zVar.b() - Math.max(pVar.r0(view), pVar.r0(view2))) - 1) : Math.max(0, Math.min(pVar.r0(view), pVar.r0(view2)));
        if (!z10) {
            return max;
        }
        return Math.round((((float) max) * (((float) Math.abs(sVar.d(view2) - sVar.g(view))) / ((float) (Math.abs(pVar.r0(view) - pVar.r0(view2)) + 1)))) + ((float) (sVar.m() - sVar.g(view))));
    }

    static int c(RecyclerView.z zVar, s sVar, View view, View view2, RecyclerView.p pVar, boolean z10) {
        if (pVar.X() == 0 || zVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z10) {
            return zVar.b();
        }
        return (int) ((((float) (sVar.d(view2) - sVar.g(view))) / ((float) (Math.abs(pVar.r0(view) - pVar.r0(view2)) + 1))) * ((float) zVar.b()));
    }
}
