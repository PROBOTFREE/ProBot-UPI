package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.p;
import androidx.constraintlayout.widget.c;
import androidx.constraintlayout.widget.f;
import androidx.recyclerview.widget.k;
import java.util.ArrayList;

public class Carousel extends MotionHelper {
    private int A = 4;
    /* access modifiers changed from: private */
    public int B = 1;
    /* access modifiers changed from: private */
    public float C = 2.0f;
    private int D = -1;
    private int E = k.f.DEFAULT_DRAG_ANIMATION_DURATION;
    Runnable F = new a();
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public b f1347n = null;

    /* renamed from: o  reason: collision with root package name */
    private final ArrayList<View> f1348o = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public int f1349p = 0;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public int f1350q = 0;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public MotionLayout f1351r;

    /* renamed from: s  reason: collision with root package name */
    private int f1352s = -1;

    /* renamed from: t  reason: collision with root package name */
    private boolean f1353t = false;

    /* renamed from: u  reason: collision with root package name */
    private int f1354u = -1;

    /* renamed from: v  reason: collision with root package name */
    private int f1355v = -1;

    /* renamed from: w  reason: collision with root package name */
    private int f1356w = -1;

    /* renamed from: x  reason: collision with root package name */
    private int f1357x = -1;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public float f1358y = 0.9f;

    /* renamed from: z  reason: collision with root package name */
    private int f1359z = 0;

    class a implements Runnable {

        /* renamed from: androidx.constraintlayout.helper.widget.Carousel$a$a  reason: collision with other inner class name */
        class C0013a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ float f1361a;

            C0013a(float f10) {
                this.f1361a = f10;
            }

            public void run() {
                Carousel.this.f1351r.C0(5, 1.0f, this.f1361a);
            }
        }

        a() {
        }

        public void run() {
            Carousel.this.f1351r.setProgress(0.0f);
            Carousel.this.R();
            Carousel.this.f1347n.b(Carousel.this.f1350q);
            float velocity = Carousel.this.f1351r.getVelocity();
            if (Carousel.this.B == 2 && velocity > Carousel.this.C && Carousel.this.f1350q < Carousel.this.f1347n.count() - 1) {
                float M = velocity * Carousel.this.f1358y;
                if (Carousel.this.f1350q == 0 && Carousel.this.f1349p > Carousel.this.f1350q) {
                    return;
                }
                if (Carousel.this.f1350q != Carousel.this.f1347n.count() - 1 || Carousel.this.f1349p >= Carousel.this.f1350q) {
                    Carousel.this.f1351r.post(new C0013a(M));
                }
            }
        }
    }

    public interface b {
        void a(View view, int i10);

        void b(int i10);

        int count();
    }

    public Carousel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        P(context, attributeSet);
    }

    public Carousel(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        P(context, attributeSet);
    }

    private boolean O(int i10, boolean z10) {
        MotionLayout motionLayout;
        p.b o02;
        if (i10 == -1 || (motionLayout = this.f1351r) == null || (o02 = motionLayout.o0(i10)) == null || z10 == o02.C()) {
            return false;
        }
        o02.F(z10);
        return true;
    }

    private void P(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.Carousel);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == f.Carousel_carousel_firstView) {
                    this.f1352s = obtainStyledAttributes.getResourceId(index, this.f1352s);
                } else if (index == f.Carousel_carousel_backwardTransition) {
                    this.f1354u = obtainStyledAttributes.getResourceId(index, this.f1354u);
                } else if (index == f.Carousel_carousel_forwardTransition) {
                    this.f1355v = obtainStyledAttributes.getResourceId(index, this.f1355v);
                } else if (index == f.Carousel_carousel_emptyViewsBehavior) {
                    this.A = obtainStyledAttributes.getInt(index, this.A);
                } else if (index == f.Carousel_carousel_previousState) {
                    this.f1356w = obtainStyledAttributes.getResourceId(index, this.f1356w);
                } else if (index == f.Carousel_carousel_nextState) {
                    this.f1357x = obtainStyledAttributes.getResourceId(index, this.f1357x);
                } else if (index == f.Carousel_carousel_touchUp_dampeningFactor) {
                    this.f1358y = obtainStyledAttributes.getFloat(index, this.f1358y);
                } else if (index == f.Carousel_carousel_touchUpMode) {
                    this.B = obtainStyledAttributes.getInt(index, this.B);
                } else if (index == f.Carousel_carousel_touchUp_velocityThreshold) {
                    this.C = obtainStyledAttributes.getFloat(index, this.C);
                } else if (index == f.Carousel_carousel_infinite) {
                    this.f1353t = obtainStyledAttributes.getBoolean(index, this.f1353t);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Q() {
        int i10;
        MotionLayout motionLayout;
        this.f1351r.setTransitionDuration(this.E);
        if (this.D < this.f1350q) {
            motionLayout = this.f1351r;
            i10 = this.f1356w;
        } else {
            motionLayout = this.f1351r;
            i10 = this.f1357x;
        }
        motionLayout.H0(i10, this.E);
    }

    /* access modifiers changed from: private */
    public void R() {
        b bVar = this.f1347n;
        if (bVar != null && this.f1351r != null && bVar.count() != 0) {
            int size = this.f1348o.size();
            for (int i10 = 0; i10 < size; i10++) {
                View view = this.f1348o.get(i10);
                int i11 = (this.f1350q + i10) - this.f1359z;
                if (this.f1353t) {
                    if (i11 < 0) {
                        int i12 = this.A;
                        if (i12 != 4) {
                            T(view, i12);
                        } else {
                            T(view, 0);
                        }
                        if (i11 % this.f1347n.count() == 0) {
                            this.f1347n.a(view, 0);
                        } else {
                            b bVar2 = this.f1347n;
                            bVar2.a(view, bVar2.count() + (i11 % this.f1347n.count()));
                        }
                    } else if (i11 >= this.f1347n.count()) {
                        if (i11 == this.f1347n.count()) {
                            i11 = 0;
                        } else if (i11 > this.f1347n.count()) {
                            i11 %= this.f1347n.count();
                        }
                        int i13 = this.A;
                        if (i13 != 4) {
                            T(view, i13);
                            this.f1347n.a(view, i11);
                        }
                    }
                } else if (i11 < 0 || i11 >= this.f1347n.count()) {
                    T(view, this.A);
                }
                T(view, 0);
                this.f1347n.a(view, i11);
            }
            int i14 = this.D;
            if (i14 != -1 && i14 != this.f1350q) {
                this.f1351r.post(new j0.a(this));
            } else if (i14 == this.f1350q) {
                this.D = -1;
            }
            if (this.f1354u == -1 || this.f1355v == -1) {
                Log.w("Carousel", "No backward or forward transitions defined for Carousel!");
            } else if (!this.f1353t) {
                int count = this.f1347n.count();
                if (this.f1350q == 0) {
                    O(this.f1354u, false);
                } else {
                    O(this.f1354u, true);
                    this.f1351r.setTransition(this.f1354u);
                }
                if (this.f1350q == count - 1) {
                    O(this.f1355v, false);
                    return;
                }
                O(this.f1355v, true);
                this.f1351r.setTransition(this.f1355v);
            }
        }
    }

    private boolean S(int i10, View view, int i11) {
        c.a w10;
        c m02 = this.f1351r.m0(i10);
        if (m02 == null || (w10 = m02.w(view.getId())) == null) {
            return false;
        }
        w10.f2009c.f2087c = 1;
        view.setVisibility(i11);
        return true;
    }

    private boolean T(View view, int i10) {
        MotionLayout motionLayout = this.f1351r;
        if (motionLayout == null) {
            return false;
        }
        int[] constraintSetIds = motionLayout.getConstraintSetIds();
        boolean z10 = false;
        for (int S : constraintSetIds) {
            z10 |= S(S, view, i10);
        }
        return z10;
    }

    public void a(MotionLayout motionLayout, int i10, int i11, float f10) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0019  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(androidx.constraintlayout.motion.widget.MotionLayout r2, int r3) {
        /*
            r1 = this;
            int r2 = r1.f1350q
            r1.f1349p = r2
            int r0 = r1.f1357x
            if (r3 != r0) goto L_0x000d
            int r2 = r2 + 1
        L_0x000a:
            r1.f1350q = r2
            goto L_0x0014
        L_0x000d:
            int r0 = r1.f1356w
            if (r3 != r0) goto L_0x0014
            int r2 = r2 + -1
            goto L_0x000a
        L_0x0014:
            boolean r2 = r1.f1353t
            r3 = 0
            if (r2 == 0) goto L_0x0034
            int r2 = r1.f1350q
            androidx.constraintlayout.helper.widget.Carousel$b r0 = r1.f1347n
            int r0 = r0.count()
            if (r2 < r0) goto L_0x0025
            r1.f1350q = r3
        L_0x0025:
            int r2 = r1.f1350q
            if (r2 >= 0) goto L_0x004e
            androidx.constraintlayout.helper.widget.Carousel$b r2 = r1.f1347n
            int r2 = r2.count()
            int r2 = r2 + -1
            r1.f1350q = r2
            goto L_0x004e
        L_0x0034:
            int r2 = r1.f1350q
            androidx.constraintlayout.helper.widget.Carousel$b r0 = r1.f1347n
            int r0 = r0.count()
            if (r2 < r0) goto L_0x0048
            androidx.constraintlayout.helper.widget.Carousel$b r2 = r1.f1347n
            int r2 = r2.count()
            int r2 = r2 + -1
            r1.f1350q = r2
        L_0x0048:
            int r2 = r1.f1350q
            if (r2 >= 0) goto L_0x004e
            r1.f1350q = r3
        L_0x004e:
            int r2 = r1.f1349p
            int r3 = r1.f1350q
            if (r2 == r3) goto L_0x005b
            androidx.constraintlayout.motion.widget.MotionLayout r2 = r1.f1351r
            java.lang.Runnable r3 = r1.F
            r2.post(r3)
        L_0x005b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.helper.widget.Carousel.d(androidx.constraintlayout.motion.widget.MotionLayout, int):void");
    }

    public int getCount() {
        b bVar = this.f1347n;
        if (bVar != null) {
            return bVar.count();
        }
        return 0;
    }

    public int getCurrentIndex() {
        return this.f1350q;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getParent() instanceof MotionLayout) {
            MotionLayout motionLayout = (MotionLayout) getParent();
            for (int i10 = 0; i10 < this.f1863b; i10++) {
                int i11 = this.f1862a[i10];
                View l10 = motionLayout.l(i11);
                if (this.f1352s == i11) {
                    this.f1359z = i10;
                }
                this.f1348o.add(l10);
            }
            this.f1351r = motionLayout;
            if (this.B == 2) {
                p.b o02 = motionLayout.o0(this.f1355v);
                if (o02 != null) {
                    o02.H(5);
                }
                p.b o03 = this.f1351r.o0(this.f1354u);
                if (o03 != null) {
                    o03.H(5);
                }
            }
            R();
        }
    }

    public void setAdapter(b bVar) {
        this.f1347n = bVar;
    }
}
