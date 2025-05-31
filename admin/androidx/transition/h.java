package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.x;
import x1.b;

@SuppressLint({"ViewConstructor"})
class h extends ViewGroup implements e {

    /* renamed from: a  reason: collision with root package name */
    ViewGroup f4110a;

    /* renamed from: b  reason: collision with root package name */
    View f4111b;

    /* renamed from: c  reason: collision with root package name */
    final View f4112c;

    /* renamed from: d  reason: collision with root package name */
    int f4113d;

    /* renamed from: e  reason: collision with root package name */
    private Matrix f4114e;

    /* renamed from: f  reason: collision with root package name */
    private final ViewTreeObserver.OnPreDrawListener f4115f = new a();

    class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        public boolean onPreDraw() {
            View view;
            x.h0(h.this);
            h hVar = h.this;
            ViewGroup viewGroup = hVar.f4110a;
            if (viewGroup == null || (view = hVar.f4111b) == null) {
                return true;
            }
            viewGroup.endViewTransition(view);
            x.h0(h.this.f4110a);
            h hVar2 = h.this;
            hVar2.f4110a = null;
            hVar2.f4111b = null;
            return true;
        }
    }

    h(View view) {
        super(view.getContext());
        this.f4112c = view;
        setWillNotDraw(false);
        setLayerType(2, (Paint) null);
    }

    static h b(View view, ViewGroup viewGroup, Matrix matrix) {
        f fVar;
        if (view.getParent() instanceof ViewGroup) {
            f b10 = f.b(viewGroup);
            h e10 = e(view);
            int i10 = 0;
            if (!(e10 == null || (fVar = (f) e10.getParent()) == b10)) {
                i10 = e10.f4113d;
                fVar.removeView(e10);
                e10 = null;
            }
            if (e10 == null) {
                if (matrix == null) {
                    matrix = new Matrix();
                    c(view, viewGroup, matrix);
                }
                e10 = new h(view);
                e10.h(matrix);
                if (b10 == null) {
                    b10 = new f(viewGroup);
                } else {
                    b10.g();
                }
                d(viewGroup, b10);
                d(viewGroup, e10);
                b10.a(e10);
                e10.f4113d = i10;
            } else if (matrix != null) {
                e10.h(matrix);
            }
            e10.f4113d++;
            return e10;
        }
        throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
    }

    static void c(View view, ViewGroup viewGroup, Matrix matrix) {
        ViewGroup viewGroup2 = (ViewGroup) view.getParent();
        matrix.reset();
        f0.j(viewGroup2, matrix);
        matrix.preTranslate((float) (-viewGroup2.getScrollX()), (float) (-viewGroup2.getScrollY()));
        f0.k(viewGroup, matrix);
    }

    static void d(View view, View view2) {
        f0.g(view2, view2.getLeft(), view2.getTop(), view2.getLeft() + view.getWidth(), view2.getTop() + view.getHeight());
    }

    static h e(View view) {
        return (h) view.getTag(b.ghost_view);
    }

    static void f(View view) {
        h e10 = e(view);
        if (e10 != null) {
            int i10 = e10.f4113d - 1;
            e10.f4113d = i10;
            if (i10 <= 0) {
                ((f) e10.getParent()).removeView(e10);
            }
        }
    }

    static void g(View view, h hVar) {
        view.setTag(b.ghost_view, hVar);
    }

    public void a(ViewGroup viewGroup, View view) {
        this.f4110a = viewGroup;
        this.f4111b = view;
    }

    /* access modifiers changed from: package-private */
    public void h(Matrix matrix) {
        this.f4114e = matrix;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        g(this.f4112c, this);
        this.f4112c.getViewTreeObserver().addOnPreDrawListener(this.f4115f);
        f0.i(this.f4112c, 4);
        if (this.f4112c.getParent() != null) {
            ((View) this.f4112c.getParent()).invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.f4112c.getViewTreeObserver().removeOnPreDrawListener(this.f4115f);
        f0.i(this.f4112c, 0);
        g(this.f4112c, (h) null);
        if (this.f4112c.getParent() != null) {
            ((View) this.f4112c.getParent()).invalidate();
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        b.a(canvas, true);
        canvas.setMatrix(this.f4114e);
        f0.i(this.f4112c, 0);
        this.f4112c.invalidate();
        f0.i(this.f4112c, 4);
        drawChild(canvas, this.f4112c, getDrawingTime());
        b.a(canvas, false);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
    }

    public void setVisibility(int i10) {
        super.setVisibility(i10);
        if (e(this.f4112c) == this) {
            f0.i(this.f4112c, i10 == 0 ? 4 : 0);
        }
    }
}
