package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.view.x;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class g extends w {
    private static final boolean DEBUG = false;
    private static TimeInterpolator sDefaultInterpolator;
    ArrayList<RecyclerView.c0> mAddAnimations = new ArrayList<>();
    ArrayList<ArrayList<RecyclerView.c0>> mAdditionsList = new ArrayList<>();
    ArrayList<RecyclerView.c0> mChangeAnimations = new ArrayList<>();
    ArrayList<ArrayList<i>> mChangesList = new ArrayList<>();
    ArrayList<RecyclerView.c0> mMoveAnimations = new ArrayList<>();
    ArrayList<ArrayList<j>> mMovesList = new ArrayList<>();
    private ArrayList<RecyclerView.c0> mPendingAdditions = new ArrayList<>();
    private ArrayList<i> mPendingChanges = new ArrayList<>();
    private ArrayList<j> mPendingMoves = new ArrayList<>();
    private ArrayList<RecyclerView.c0> mPendingRemovals = new ArrayList<>();
    ArrayList<RecyclerView.c0> mRemoveAnimations = new ArrayList<>();

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f3509a;

        a(ArrayList arrayList) {
            this.f3509a = arrayList;
        }

        public void run() {
            Iterator it = this.f3509a.iterator();
            while (it.hasNext()) {
                j jVar = (j) it.next();
                g.this.animateMoveImpl(jVar.f3543a, jVar.f3544b, jVar.f3545c, jVar.f3546d, jVar.f3547e);
            }
            this.f3509a.clear();
            g.this.mMovesList.remove(this.f3509a);
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f3511a;

        b(ArrayList arrayList) {
            this.f3511a = arrayList;
        }

        public void run() {
            Iterator it = this.f3511a.iterator();
            while (it.hasNext()) {
                g.this.animateChangeImpl((i) it.next());
            }
            this.f3511a.clear();
            g.this.mChangesList.remove(this.f3511a);
        }
    }

    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f3513a;

        c(ArrayList arrayList) {
            this.f3513a = arrayList;
        }

        public void run() {
            Iterator it = this.f3513a.iterator();
            while (it.hasNext()) {
                g.this.animateAddImpl((RecyclerView.c0) it.next());
            }
            this.f3513a.clear();
            g.this.mAdditionsList.remove(this.f3513a);
        }
    }

    class d extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecyclerView.c0 f3515a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f3516b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f3517c;

        d(RecyclerView.c0 c0Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f3515a = c0Var;
            this.f3516b = viewPropertyAnimator;
            this.f3517c = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.f3516b.setListener((Animator.AnimatorListener) null);
            this.f3517c.setAlpha(1.0f);
            g.this.dispatchRemoveFinished(this.f3515a);
            g.this.mRemoveAnimations.remove(this.f3515a);
            g.this.dispatchFinishedWhenDone();
        }

        public void onAnimationStart(Animator animator) {
            g.this.dispatchRemoveStarting(this.f3515a);
        }
    }

    class e extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecyclerView.c0 f3519a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f3520b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f3521c;

        e(RecyclerView.c0 c0Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f3519a = c0Var;
            this.f3520b = view;
            this.f3521c = viewPropertyAnimator;
        }

        public void onAnimationCancel(Animator animator) {
            this.f3520b.setAlpha(1.0f);
        }

        public void onAnimationEnd(Animator animator) {
            this.f3521c.setListener((Animator.AnimatorListener) null);
            g.this.dispatchAddFinished(this.f3519a);
            g.this.mAddAnimations.remove(this.f3519a);
            g.this.dispatchFinishedWhenDone();
        }

        public void onAnimationStart(Animator animator) {
            g.this.dispatchAddStarting(this.f3519a);
        }
    }

    class f extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecyclerView.c0 f3523a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f3524b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f3525c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f3526d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f3527e;

        f(RecyclerView.c0 c0Var, int i10, View view, int i11, ViewPropertyAnimator viewPropertyAnimator) {
            this.f3523a = c0Var;
            this.f3524b = i10;
            this.f3525c = view;
            this.f3526d = i11;
            this.f3527e = viewPropertyAnimator;
        }

        public void onAnimationCancel(Animator animator) {
            if (this.f3524b != 0) {
                this.f3525c.setTranslationX(0.0f);
            }
            if (this.f3526d != 0) {
                this.f3525c.setTranslationY(0.0f);
            }
        }

        public void onAnimationEnd(Animator animator) {
            this.f3527e.setListener((Animator.AnimatorListener) null);
            g.this.dispatchMoveFinished(this.f3523a);
            g.this.mMoveAnimations.remove(this.f3523a);
            g.this.dispatchFinishedWhenDone();
        }

        public void onAnimationStart(Animator animator) {
            g.this.dispatchMoveStarting(this.f3523a);
        }
    }

    /* renamed from: androidx.recyclerview.widget.g$g  reason: collision with other inner class name */
    class C0036g extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f3529a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f3530b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f3531c;

        C0036g(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f3529a = iVar;
            this.f3530b = viewPropertyAnimator;
            this.f3531c = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.f3530b.setListener((Animator.AnimatorListener) null);
            this.f3531c.setAlpha(1.0f);
            this.f3531c.setTranslationX(0.0f);
            this.f3531c.setTranslationY(0.0f);
            g.this.dispatchChangeFinished(this.f3529a.f3537a, true);
            g.this.mChangeAnimations.remove(this.f3529a.f3537a);
            g.this.dispatchFinishedWhenDone();
        }

        public void onAnimationStart(Animator animator) {
            g.this.dispatchChangeStarting(this.f3529a.f3537a, true);
        }
    }

    class h extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f3533a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f3534b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f3535c;

        h(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f3533a = iVar;
            this.f3534b = viewPropertyAnimator;
            this.f3535c = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.f3534b.setListener((Animator.AnimatorListener) null);
            this.f3535c.setAlpha(1.0f);
            this.f3535c.setTranslationX(0.0f);
            this.f3535c.setTranslationY(0.0f);
            g.this.dispatchChangeFinished(this.f3533a.f3538b, false);
            g.this.mChangeAnimations.remove(this.f3533a.f3538b);
            g.this.dispatchFinishedWhenDone();
        }

        public void onAnimationStart(Animator animator) {
            g.this.dispatchChangeStarting(this.f3533a.f3538b, false);
        }
    }

    private static class i {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.c0 f3537a;

        /* renamed from: b  reason: collision with root package name */
        public RecyclerView.c0 f3538b;

        /* renamed from: c  reason: collision with root package name */
        public int f3539c;

        /* renamed from: d  reason: collision with root package name */
        public int f3540d;

        /* renamed from: e  reason: collision with root package name */
        public int f3541e;

        /* renamed from: f  reason: collision with root package name */
        public int f3542f;

        private i(RecyclerView.c0 c0Var, RecyclerView.c0 c0Var2) {
            this.f3537a = c0Var;
            this.f3538b = c0Var2;
        }

        i(RecyclerView.c0 c0Var, RecyclerView.c0 c0Var2, int i10, int i11, int i12, int i13) {
            this(c0Var, c0Var2);
            this.f3539c = i10;
            this.f3540d = i11;
            this.f3541e = i12;
            this.f3542f = i13;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f3537a + ", newHolder=" + this.f3538b + ", fromX=" + this.f3539c + ", fromY=" + this.f3540d + ", toX=" + this.f3541e + ", toY=" + this.f3542f + '}';
        }
    }

    private static class j {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.c0 f3543a;

        /* renamed from: b  reason: collision with root package name */
        public int f3544b;

        /* renamed from: c  reason: collision with root package name */
        public int f3545c;

        /* renamed from: d  reason: collision with root package name */
        public int f3546d;

        /* renamed from: e  reason: collision with root package name */
        public int f3547e;

        j(RecyclerView.c0 c0Var, int i10, int i11, int i12, int i13) {
            this.f3543a = c0Var;
            this.f3544b = i10;
            this.f3545c = i11;
            this.f3546d = i12;
            this.f3547e = i13;
        }
    }

    private void animateRemoveImpl(RecyclerView.c0 c0Var) {
        View view = c0Var.itemView;
        ViewPropertyAnimator animate = view.animate();
        this.mRemoveAnimations.add(c0Var);
        animate.setDuration(getRemoveDuration()).alpha(0.0f).setListener(new d(c0Var, animate, view)).start();
    }

    private void endChangeAnimation(List<i> list, RecyclerView.c0 c0Var) {
        for (int size = list.size() - 1; size >= 0; size--) {
            i iVar = list.get(size);
            if (endChangeAnimationIfNecessary(iVar, c0Var) && iVar.f3537a == null && iVar.f3538b == null) {
                list.remove(iVar);
            }
        }
    }

    private void endChangeAnimationIfNecessary(i iVar) {
        RecyclerView.c0 c0Var = iVar.f3537a;
        if (c0Var != null) {
            endChangeAnimationIfNecessary(iVar, c0Var);
        }
        RecyclerView.c0 c0Var2 = iVar.f3538b;
        if (c0Var2 != null) {
            endChangeAnimationIfNecessary(iVar, c0Var2);
        }
    }

    private boolean endChangeAnimationIfNecessary(i iVar, RecyclerView.c0 c0Var) {
        boolean z10 = false;
        if (iVar.f3538b == c0Var) {
            iVar.f3538b = null;
        } else if (iVar.f3537a != c0Var) {
            return false;
        } else {
            iVar.f3537a = null;
            z10 = true;
        }
        c0Var.itemView.setAlpha(1.0f);
        c0Var.itemView.setTranslationX(0.0f);
        c0Var.itemView.setTranslationY(0.0f);
        dispatchChangeFinished(c0Var, z10);
        return true;
    }

    private void resetAnimation(RecyclerView.c0 c0Var) {
        if (sDefaultInterpolator == null) {
            sDefaultInterpolator = new ValueAnimator().getInterpolator();
        }
        c0Var.itemView.animate().setInterpolator(sDefaultInterpolator);
        endAnimation(c0Var);
    }

    public boolean animateAdd(RecyclerView.c0 c0Var) {
        resetAnimation(c0Var);
        c0Var.itemView.setAlpha(0.0f);
        this.mPendingAdditions.add(c0Var);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void animateAddImpl(RecyclerView.c0 c0Var) {
        View view = c0Var.itemView;
        ViewPropertyAnimator animate = view.animate();
        this.mAddAnimations.add(c0Var);
        animate.alpha(1.0f).setDuration(getAddDuration()).setListener(new e(c0Var, view, animate)).start();
    }

    public boolean animateChange(RecyclerView.c0 c0Var, RecyclerView.c0 c0Var2, int i10, int i11, int i12, int i13) {
        if (c0Var == c0Var2) {
            return animateMove(c0Var, i10, i11, i12, i13);
        }
        float translationX = c0Var.itemView.getTranslationX();
        float translationY = c0Var.itemView.getTranslationY();
        float alpha = c0Var.itemView.getAlpha();
        resetAnimation(c0Var);
        int i14 = (int) (((float) (i12 - i10)) - translationX);
        int i15 = (int) (((float) (i13 - i11)) - translationY);
        c0Var.itemView.setTranslationX(translationX);
        c0Var.itemView.setTranslationY(translationY);
        c0Var.itemView.setAlpha(alpha);
        if (c0Var2 != null) {
            resetAnimation(c0Var2);
            c0Var2.itemView.setTranslationX((float) (-i14));
            c0Var2.itemView.setTranslationY((float) (-i15));
            c0Var2.itemView.setAlpha(0.0f);
        }
        this.mPendingChanges.add(new i(c0Var, c0Var2, i10, i11, i12, i13));
        return true;
    }

    /* access modifiers changed from: package-private */
    public void animateChangeImpl(i iVar) {
        RecyclerView.c0 c0Var = iVar.f3537a;
        View view = null;
        View view2 = c0Var == null ? null : c0Var.itemView;
        RecyclerView.c0 c0Var2 = iVar.f3538b;
        if (c0Var2 != null) {
            view = c0Var2.itemView;
        }
        if (view2 != null) {
            ViewPropertyAnimator duration = view2.animate().setDuration(getChangeDuration());
            this.mChangeAnimations.add(iVar.f3537a);
            duration.translationX((float) (iVar.f3541e - iVar.f3539c));
            duration.translationY((float) (iVar.f3542f - iVar.f3540d));
            duration.alpha(0.0f).setListener(new C0036g(iVar, duration, view2)).start();
        }
        if (view != null) {
            ViewPropertyAnimator animate = view.animate();
            this.mChangeAnimations.add(iVar.f3538b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(getChangeDuration()).alpha(1.0f).setListener(new h(iVar, animate, view)).start();
        }
    }

    public boolean animateMove(RecyclerView.c0 c0Var, int i10, int i11, int i12, int i13) {
        View view = c0Var.itemView;
        int translationX = i10 + ((int) view.getTranslationX());
        int translationY = i11 + ((int) c0Var.itemView.getTranslationY());
        resetAnimation(c0Var);
        int i14 = i12 - translationX;
        int i15 = i13 - translationY;
        if (i14 == 0 && i15 == 0) {
            dispatchMoveFinished(c0Var);
            return false;
        }
        if (i14 != 0) {
            view.setTranslationX((float) (-i14));
        }
        if (i15 != 0) {
            view.setTranslationY((float) (-i15));
        }
        this.mPendingMoves.add(new j(c0Var, translationX, translationY, i12, i13));
        return true;
    }

    /* access modifiers changed from: package-private */
    public void animateMoveImpl(RecyclerView.c0 c0Var, int i10, int i11, int i12, int i13) {
        View view = c0Var.itemView;
        int i14 = i12 - i10;
        int i15 = i13 - i11;
        if (i14 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i15 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator animate = view.animate();
        this.mMoveAnimations.add(c0Var);
        animate.setDuration(getMoveDuration()).setListener(new f(c0Var, i14, view, i15, animate)).start();
    }

    public boolean animateRemove(RecyclerView.c0 c0Var) {
        resetAnimation(c0Var);
        this.mPendingRemovals.add(c0Var);
        return true;
    }

    public boolean canReuseUpdatedViewHolder(RecyclerView.c0 c0Var, List<Object> list) {
        return !list.isEmpty() || super.canReuseUpdatedViewHolder(c0Var, list);
    }

    /* access modifiers changed from: package-private */
    public void cancelAll(List<RecyclerView.c0> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).itemView.animate().cancel();
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchFinishedWhenDone() {
        if (!isRunning()) {
            dispatchAnimationsFinished();
        }
    }

    public void endAnimation(RecyclerView.c0 c0Var) {
        View view = c0Var.itemView;
        view.animate().cancel();
        int size = this.mPendingMoves.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.mPendingMoves.get(size).f3543a == c0Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                dispatchMoveFinished(c0Var);
                this.mPendingMoves.remove(size);
            }
        }
        endChangeAnimation(this.mPendingChanges, c0Var);
        if (this.mPendingRemovals.remove(c0Var)) {
            view.setAlpha(1.0f);
            dispatchRemoveFinished(c0Var);
        }
        if (this.mPendingAdditions.remove(c0Var)) {
            view.setAlpha(1.0f);
            dispatchAddFinished(c0Var);
        }
        for (int size2 = this.mChangesList.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = this.mChangesList.get(size2);
            endChangeAnimation(arrayList, c0Var);
            if (arrayList.isEmpty()) {
                this.mChangesList.remove(size2);
            }
        }
        for (int size3 = this.mMovesList.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = this.mMovesList.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (((j) arrayList2.get(size4)).f3543a == c0Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    dispatchMoveFinished(c0Var);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.mMovesList.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.mAdditionsList.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList3 = this.mAdditionsList.get(size5);
            if (arrayList3.remove(c0Var)) {
                view.setAlpha(1.0f);
                dispatchAddFinished(c0Var);
                if (arrayList3.isEmpty()) {
                    this.mAdditionsList.remove(size5);
                }
            }
        }
        this.mRemoveAnimations.remove(c0Var);
        this.mAddAnimations.remove(c0Var);
        this.mChangeAnimations.remove(c0Var);
        this.mMoveAnimations.remove(c0Var);
        dispatchFinishedWhenDone();
    }

    public void endAnimations() {
        int size = this.mPendingMoves.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            j jVar = this.mPendingMoves.get(size);
            View view = jVar.f3543a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            dispatchMoveFinished(jVar.f3543a);
            this.mPendingMoves.remove(size);
        }
        for (int size2 = this.mPendingRemovals.size() - 1; size2 >= 0; size2--) {
            dispatchRemoveFinished(this.mPendingRemovals.get(size2));
            this.mPendingRemovals.remove(size2);
        }
        int size3 = this.mPendingAdditions.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.c0 c0Var = this.mPendingAdditions.get(size3);
            c0Var.itemView.setAlpha(1.0f);
            dispatchAddFinished(c0Var);
            this.mPendingAdditions.remove(size3);
        }
        for (int size4 = this.mPendingChanges.size() - 1; size4 >= 0; size4--) {
            endChangeAnimationIfNecessary(this.mPendingChanges.get(size4));
        }
        this.mPendingChanges.clear();
        if (isRunning()) {
            for (int size5 = this.mMovesList.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = this.mMovesList.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    j jVar2 = (j) arrayList.get(size6);
                    View view2 = jVar2.f3543a.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    dispatchMoveFinished(jVar2.f3543a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.mMovesList.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.mAdditionsList.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = this.mAdditionsList.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.c0 c0Var2 = (RecyclerView.c0) arrayList2.get(size8);
                    c0Var2.itemView.setAlpha(1.0f);
                    dispatchAddFinished(c0Var2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.mAdditionsList.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.mChangesList.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = this.mChangesList.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    endChangeAnimationIfNecessary((i) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.mChangesList.remove(arrayList3);
                    }
                }
            }
            cancelAll(this.mRemoveAnimations);
            cancelAll(this.mMoveAnimations);
            cancelAll(this.mAddAnimations);
            cancelAll(this.mChangeAnimations);
            dispatchAnimationsFinished();
        }
    }

    public boolean isRunning() {
        return !this.mPendingAdditions.isEmpty() || !this.mPendingChanges.isEmpty() || !this.mPendingMoves.isEmpty() || !this.mPendingRemovals.isEmpty() || !this.mMoveAnimations.isEmpty() || !this.mRemoveAnimations.isEmpty() || !this.mAddAnimations.isEmpty() || !this.mChangeAnimations.isEmpty() || !this.mMovesList.isEmpty() || !this.mAdditionsList.isEmpty() || !this.mChangesList.isEmpty();
    }

    public void runPendingAnimations() {
        boolean z10 = !this.mPendingRemovals.isEmpty();
        boolean z11 = !this.mPendingMoves.isEmpty();
        boolean z12 = !this.mPendingChanges.isEmpty();
        boolean z13 = !this.mPendingAdditions.isEmpty();
        if (z10 || z11 || z13 || z12) {
            Iterator<RecyclerView.c0> it = this.mPendingRemovals.iterator();
            while (it.hasNext()) {
                animateRemoveImpl(it.next());
            }
            this.mPendingRemovals.clear();
            if (z11) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.mPendingMoves);
                this.mMovesList.add(arrayList);
                this.mPendingMoves.clear();
                a aVar = new a(arrayList);
                if (z10) {
                    x.k0(((j) arrayList.get(0)).f3543a.itemView, aVar, getRemoveDuration());
                } else {
                    aVar.run();
                }
            }
            if (z12) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.mPendingChanges);
                this.mChangesList.add(arrayList2);
                this.mPendingChanges.clear();
                b bVar = new b(arrayList2);
                if (z10) {
                    x.k0(((i) arrayList2.get(0)).f3537a.itemView, bVar, getRemoveDuration());
                } else {
                    bVar.run();
                }
            }
            if (z13) {
                ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(this.mPendingAdditions);
                this.mAdditionsList.add(arrayList3);
                this.mPendingAdditions.clear();
                c cVar = new c(arrayList3);
                if (z10 || z11 || z12) {
                    long j10 = 0;
                    long removeDuration = z10 ? getRemoveDuration() : 0;
                    long moveDuration = z11 ? getMoveDuration() : 0;
                    if (z12) {
                        j10 = getChangeDuration();
                    }
                    x.k0(((RecyclerView.c0) arrayList3.get(0)).itemView, cVar, removeDuration + Math.max(moveDuration, j10));
                    return;
                }
                cVar.run();
            }
        }
    }
}
