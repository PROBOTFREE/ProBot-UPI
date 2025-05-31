package androidx.transition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.x;
import java.util.ArrayList;

class c0 implements e0 {

    /* renamed from: a  reason: collision with root package name */
    protected a f4077a;

    static class a extends ViewGroup {

        /* renamed from: a  reason: collision with root package name */
        ViewGroup f4078a;

        /* renamed from: b  reason: collision with root package name */
        View f4079b;

        /* renamed from: c  reason: collision with root package name */
        ArrayList<Drawable> f4080c = null;

        /* renamed from: d  reason: collision with root package name */
        c0 f4081d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f4082e;

        static {
            Class<ViewGroup> cls = ViewGroup.class;
            try {
                Class cls2 = Integer.TYPE;
                cls.getDeclaredMethod("invalidateChildInParentFast", new Class[]{cls2, cls2, Rect.class});
            } catch (NoSuchMethodException unused) {
            }
        }

        a(Context context, ViewGroup viewGroup, View view, c0 c0Var) {
            super(context);
            this.f4078a = viewGroup;
            this.f4079b = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.f4081d = c0Var;
        }

        private void c() {
            if (this.f4082e) {
                throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
            }
        }

        private void d() {
            if (getChildCount() == 0) {
                ArrayList<Drawable> arrayList = this.f4080c;
                if (arrayList == null || arrayList.size() == 0) {
                    this.f4082e = true;
                    this.f4078a.removeView(this);
                }
            }
        }

        private void e(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.f4078a.getLocationOnScreen(iArr2);
            this.f4079b.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }

        public void a(Drawable drawable) {
            c();
            if (this.f4080c == null) {
                this.f4080c = new ArrayList<>();
            }
            if (!this.f4080c.contains(drawable)) {
                this.f4080c.add(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(this);
            }
        }

        public void b(View view) {
            c();
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (!(viewGroup == this.f4078a || viewGroup.getParent() == null || !x.U(viewGroup))) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.f4078a.getLocationOnScreen(iArr2);
                    x.a0(view, iArr[0] - iArr2[0]);
                    x.b0(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view);
        }

        /* access modifiers changed from: protected */
        public void dispatchDraw(Canvas canvas) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.f4078a.getLocationOnScreen(iArr);
            this.f4079b.getLocationOnScreen(iArr2);
            canvas.translate((float) (iArr2[0] - iArr[0]), (float) (iArr2[1] - iArr[1]));
            canvas.clipRect(new Rect(0, 0, this.f4079b.getWidth(), this.f4079b.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList<Drawable> arrayList = this.f4080c;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f4080c.get(i10).draw(canvas);
            }
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        public void f(Drawable drawable) {
            ArrayList<Drawable> arrayList = this.f4080c;
            if (arrayList != null) {
                arrayList.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback((Drawable.Callback) null);
                d();
            }
        }

        public void g(View view) {
            super.removeView(view);
            d();
        }

        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.f4078a == null) {
                return null;
            }
            rect.offset(iArr[0], iArr[1]);
            if (this.f4078a instanceof ViewGroup) {
                iArr[0] = 0;
                iArr[1] = 0;
                int[] iArr2 = new int[2];
                e(iArr2);
                rect.offset(iArr2[0], iArr2[1]);
                return super.invalidateChildInParent(iArr, rect);
            }
            invalidate(rect);
            return null;
        }

        public void invalidateDrawable(Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
            r0 = r1.f4080c;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean verifyDrawable(android.graphics.drawable.Drawable r2) {
            /*
                r1 = this;
                boolean r0 = super.verifyDrawable(r2)
                if (r0 != 0) goto L_0x0013
                java.util.ArrayList<android.graphics.drawable.Drawable> r0 = r1.f4080c
                if (r0 == 0) goto L_0x0011
                boolean r2 = r0.contains(r2)
                if (r2 == 0) goto L_0x0011
                goto L_0x0013
            L_0x0011:
                r2 = 0
                goto L_0x0014
            L_0x0013:
                r2 = 1
            L_0x0014:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.transition.c0.a.verifyDrawable(android.graphics.drawable.Drawable):boolean");
        }
    }

    c0(Context context, ViewGroup viewGroup, View view) {
        this.f4077a = new a(context, viewGroup, view, this);
    }

    static c0 e(View view) {
        ViewGroup f10 = f(view);
        if (f10 == null) {
            return null;
        }
        int childCount = f10.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = f10.getChildAt(i10);
            if (childAt instanceof a) {
                return ((a) childAt).f4081d;
            }
        }
        return new x(f10.getContext(), f10, view);
    }

    static ViewGroup f(View view) {
        while (view != null) {
            if (view.getId() == 16908290 && (view instanceof ViewGroup)) {
                return (ViewGroup) view;
            }
            if (view.getParent() instanceof ViewGroup) {
                view = (ViewGroup) view.getParent();
            }
        }
        return null;
    }

    public void a(Drawable drawable) {
        this.f4077a.a(drawable);
    }

    public void b(Drawable drawable) {
        this.f4077a.f(drawable);
    }
}
