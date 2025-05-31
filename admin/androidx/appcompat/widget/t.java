package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import p.e;

public abstract class t implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private final float f1200a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1201b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1202c;

    /* renamed from: d  reason: collision with root package name */
    final View f1203d;

    /* renamed from: e  reason: collision with root package name */
    private Runnable f1204e;

    /* renamed from: f  reason: collision with root package name */
    private Runnable f1205f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1206g;

    /* renamed from: h  reason: collision with root package name */
    private int f1207h;

    /* renamed from: i  reason: collision with root package name */
    private final int[] f1208i = new int[2];

    private class a implements Runnable {
        a() {
        }

        public void run() {
            ViewParent parent = t.this.f1203d.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    private class b implements Runnable {
        b() {
        }

        public void run() {
            t.this.e();
        }
    }

    public t(View view) {
        this.f1203d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f1200a = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f1201b = tapTimeout;
        this.f1202c = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    private void a() {
        Runnable runnable = this.f1205f;
        if (runnable != null) {
            this.f1203d.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f1204e;
        if (runnable2 != null) {
            this.f1203d.removeCallbacks(runnable2);
        }
    }

    private boolean f(MotionEvent motionEvent) {
        r rVar;
        View view = this.f1203d;
        e b10 = b();
        if (b10 == null || !b10.d() || (rVar = (r) b10.h()) == null || !rVar.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        i(view, obtainNoHistory);
        j(rVar, obtainNoHistory);
        boolean e10 = rVar.e(obtainNoHistory, this.f1207h);
        obtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return e10 && (actionMasked != 1 && actionMasked != 3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        if (r1 != 3) goto L_0x006d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean g(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.f1203d
            boolean r1 = r0.isEnabled()
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            int r1 = r6.getActionMasked()
            if (r1 == 0) goto L_0x0041
            r3 = 1
            if (r1 == r3) goto L_0x003d
            r4 = 2
            if (r1 == r4) goto L_0x001a
            r6 = 3
            if (r1 == r6) goto L_0x003d
            goto L_0x006d
        L_0x001a:
            int r1 = r5.f1207h
            int r1 = r6.findPointerIndex(r1)
            if (r1 < 0) goto L_0x006d
            float r4 = r6.getX(r1)
            float r6 = r6.getY(r1)
            float r1 = r5.f1200a
            boolean r6 = h(r0, r4, r6, r1)
            if (r6 != 0) goto L_0x006d
            r5.a()
            android.view.ViewParent r6 = r0.getParent()
            r6.requestDisallowInterceptTouchEvent(r3)
            return r3
        L_0x003d:
            r5.a()
            goto L_0x006d
        L_0x0041:
            int r6 = r6.getPointerId(r2)
            r5.f1207h = r6
            java.lang.Runnable r6 = r5.f1204e
            if (r6 != 0) goto L_0x0052
            androidx.appcompat.widget.t$a r6 = new androidx.appcompat.widget.t$a
            r6.<init>()
            r5.f1204e = r6
        L_0x0052:
            java.lang.Runnable r6 = r5.f1204e
            int r1 = r5.f1201b
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
            java.lang.Runnable r6 = r5.f1205f
            if (r6 != 0) goto L_0x0065
            androidx.appcompat.widget.t$b r6 = new androidx.appcompat.widget.t$b
            r6.<init>()
            r5.f1205f = r6
        L_0x0065:
            java.lang.Runnable r6 = r5.f1205f
            int r1 = r5.f1202c
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
        L_0x006d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.t.g(android.view.MotionEvent):boolean");
    }

    private static boolean h(View view, float f10, float f11, float f12) {
        float f13 = -f12;
        return f10 >= f13 && f11 >= f13 && f10 < ((float) (view.getRight() - view.getLeft())) + f12 && f11 < ((float) (view.getBottom() - view.getTop())) + f12;
    }

    private boolean i(View view, MotionEvent motionEvent) {
        int[] iArr = this.f1208i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) iArr[0], (float) iArr[1]);
        return true;
    }

    private boolean j(View view, MotionEvent motionEvent) {
        int[] iArr = this.f1208i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) (-iArr[0]), (float) (-iArr[1]));
        return true;
    }

    public abstract e b();

    /* access modifiers changed from: protected */
    public abstract boolean c();

    /* access modifiers changed from: protected */
    public boolean d() {
        e b10 = b();
        if (b10 == null || !b10.d()) {
            return true;
        }
        b10.dismiss();
        return true;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        a();
        View view = this.f1203d;
        if (view.isEnabled() && !view.isLongClickable() && c()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.f1206g = true;
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z10;
        boolean z11 = this.f1206g;
        if (z11) {
            z10 = f(motionEvent) || !d();
        } else {
            z10 = g(motionEvent) && c();
            if (z10) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f1203d.onTouchEvent(obtain);
                obtain.recycle();
            }
        }
        this.f1206g = z10;
        return z10 || z11;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        this.f1206g = false;
        this.f1207h = -1;
        Runnable runnable = this.f1204e;
        if (runnable != null) {
            this.f1203d.removeCallbacks(runnable);
        }
    }
}
