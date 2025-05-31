package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class w extends RecyclerView.m {
    private static final boolean DEBUG = false;
    private static final String TAG = "SimpleItemAnimator";
    boolean mSupportsChangeAnimations = true;

    public abstract boolean animateAdd(RecyclerView.c0 c0Var);

    public boolean animateAppearance(RecyclerView.c0 c0Var, RecyclerView.m.c cVar, RecyclerView.m.c cVar2) {
        int i10;
        int i11;
        if (cVar == null || ((i10 = cVar.f3348a) == (i11 = cVar2.f3348a) && cVar.f3349b == cVar2.f3349b)) {
            return animateAdd(c0Var);
        }
        return animateMove(c0Var, i10, cVar.f3349b, i11, cVar2.f3349b);
    }

    public abstract boolean animateChange(RecyclerView.c0 c0Var, RecyclerView.c0 c0Var2, int i10, int i11, int i12, int i13);

    public boolean animateChange(RecyclerView.c0 c0Var, RecyclerView.c0 c0Var2, RecyclerView.m.c cVar, RecyclerView.m.c cVar2) {
        int i10;
        int i11;
        int i12 = cVar.f3348a;
        int i13 = cVar.f3349b;
        if (c0Var2.shouldIgnore()) {
            int i14 = cVar.f3348a;
            i10 = cVar.f3349b;
            i11 = i14;
        } else {
            i11 = cVar2.f3348a;
            i10 = cVar2.f3349b;
        }
        return animateChange(c0Var, c0Var2, i12, i13, i11, i10);
    }

    public boolean animateDisappearance(RecyclerView.c0 c0Var, RecyclerView.m.c cVar, RecyclerView.m.c cVar2) {
        int i10 = cVar.f3348a;
        int i11 = cVar.f3349b;
        View view = c0Var.itemView;
        int left = cVar2 == null ? view.getLeft() : cVar2.f3348a;
        int top = cVar2 == null ? view.getTop() : cVar2.f3349b;
        if (c0Var.isRemoved() || (i10 == left && i11 == top)) {
            return animateRemove(c0Var);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return animateMove(c0Var, i10, i11, left, top);
    }

    public abstract boolean animateMove(RecyclerView.c0 c0Var, int i10, int i11, int i12, int i13);

    public boolean animatePersistence(RecyclerView.c0 c0Var, RecyclerView.m.c cVar, RecyclerView.m.c cVar2) {
        int i10 = cVar.f3348a;
        int i11 = cVar2.f3348a;
        if (i10 == i11 && cVar.f3349b == cVar2.f3349b) {
            dispatchMoveFinished(c0Var);
            return false;
        }
        return animateMove(c0Var, i10, cVar.f3349b, i11, cVar2.f3349b);
    }

    public abstract boolean animateRemove(RecyclerView.c0 c0Var);

    public boolean canReuseUpdatedViewHolder(RecyclerView.c0 c0Var) {
        return !this.mSupportsChangeAnimations || c0Var.isInvalid();
    }

    public final void dispatchAddFinished(RecyclerView.c0 c0Var) {
        onAddFinished(c0Var);
        dispatchAnimationFinished(c0Var);
    }

    public final void dispatchAddStarting(RecyclerView.c0 c0Var) {
        onAddStarting(c0Var);
    }

    public final void dispatchChangeFinished(RecyclerView.c0 c0Var, boolean z10) {
        onChangeFinished(c0Var, z10);
        dispatchAnimationFinished(c0Var);
    }

    public final void dispatchChangeStarting(RecyclerView.c0 c0Var, boolean z10) {
        onChangeStarting(c0Var, z10);
    }

    public final void dispatchMoveFinished(RecyclerView.c0 c0Var) {
        onMoveFinished(c0Var);
        dispatchAnimationFinished(c0Var);
    }

    public final void dispatchMoveStarting(RecyclerView.c0 c0Var) {
        onMoveStarting(c0Var);
    }

    public final void dispatchRemoveFinished(RecyclerView.c0 c0Var) {
        onRemoveFinished(c0Var);
        dispatchAnimationFinished(c0Var);
    }

    public final void dispatchRemoveStarting(RecyclerView.c0 c0Var) {
        onRemoveStarting(c0Var);
    }

    public boolean getSupportsChangeAnimations() {
        return this.mSupportsChangeAnimations;
    }

    public void onAddFinished(RecyclerView.c0 c0Var) {
    }

    public void onAddStarting(RecyclerView.c0 c0Var) {
    }

    public void onChangeFinished(RecyclerView.c0 c0Var, boolean z10) {
    }

    public void onChangeStarting(RecyclerView.c0 c0Var, boolean z10) {
    }

    public void onMoveFinished(RecyclerView.c0 c0Var) {
    }

    public void onMoveStarting(RecyclerView.c0 c0Var) {
    }

    public void onRemoveFinished(RecyclerView.c0 c0Var) {
    }

    public void onRemoveStarting(RecyclerView.c0 c0Var) {
    }

    public void setSupportsChangeAnimations(boolean z10) {
        this.mSupportsChangeAnimations = z10;
    }
}
