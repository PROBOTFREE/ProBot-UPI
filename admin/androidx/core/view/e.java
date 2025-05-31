package androidx.core.view;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final a f2317a;

    interface a {
        boolean a(MotionEvent motionEvent);
    }

    static class b implements a {

        /* renamed from: v  reason: collision with root package name */
        private static final int f2318v = ViewConfiguration.getTapTimeout();

        /* renamed from: w  reason: collision with root package name */
        private static final int f2319w = ViewConfiguration.getDoubleTapTimeout();

        /* renamed from: a  reason: collision with root package name */
        private int f2320a;

        /* renamed from: b  reason: collision with root package name */
        private int f2321b;

        /* renamed from: c  reason: collision with root package name */
        private int f2322c;

        /* renamed from: d  reason: collision with root package name */
        private int f2323d;

        /* renamed from: e  reason: collision with root package name */
        private final Handler f2324e;

        /* renamed from: f  reason: collision with root package name */
        final GestureDetector.OnGestureListener f2325f;

        /* renamed from: g  reason: collision with root package name */
        GestureDetector.OnDoubleTapListener f2326g;

        /* renamed from: h  reason: collision with root package name */
        boolean f2327h;

        /* renamed from: i  reason: collision with root package name */
        boolean f2328i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f2329j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f2330k;

        /* renamed from: l  reason: collision with root package name */
        private boolean f2331l;

        /* renamed from: m  reason: collision with root package name */
        MotionEvent f2332m;

        /* renamed from: n  reason: collision with root package name */
        private MotionEvent f2333n;

        /* renamed from: o  reason: collision with root package name */
        private boolean f2334o;

        /* renamed from: p  reason: collision with root package name */
        private float f2335p;

        /* renamed from: q  reason: collision with root package name */
        private float f2336q;

        /* renamed from: r  reason: collision with root package name */
        private float f2337r;

        /* renamed from: s  reason: collision with root package name */
        private float f2338s;

        /* renamed from: t  reason: collision with root package name */
        private boolean f2339t;

        /* renamed from: u  reason: collision with root package name */
        private VelocityTracker f2340u;

        private class a extends Handler {
            a() {
            }

            a(Handler handler) {
                super(handler.getLooper());
            }

            public void handleMessage(Message message) {
                int i10 = message.what;
                if (i10 == 1) {
                    b bVar = b.this;
                    bVar.f2325f.onShowPress(bVar.f2332m);
                } else if (i10 == 2) {
                    b.this.d();
                } else if (i10 == 3) {
                    b bVar2 = b.this;
                    GestureDetector.OnDoubleTapListener onDoubleTapListener = bVar2.f2326g;
                    if (onDoubleTapListener == null) {
                        return;
                    }
                    if (!bVar2.f2327h) {
                        onDoubleTapListener.onSingleTapConfirmed(bVar2.f2332m);
                    } else {
                        bVar2.f2328i = true;
                    }
                } else {
                    throw new RuntimeException("Unknown message " + message);
                }
            }
        }

        b(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            if (handler != null) {
                this.f2324e = new a(handler);
            } else {
                this.f2324e = new a();
            }
            this.f2325f = onGestureListener;
            if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
                g((GestureDetector.OnDoubleTapListener) onGestureListener);
            }
            e(context);
        }

        private void b() {
            this.f2324e.removeMessages(1);
            this.f2324e.removeMessages(2);
            this.f2324e.removeMessages(3);
            this.f2340u.recycle();
            this.f2340u = null;
            this.f2334o = false;
            this.f2327h = false;
            this.f2330k = false;
            this.f2331l = false;
            this.f2328i = false;
            if (this.f2329j) {
                this.f2329j = false;
            }
        }

        private void c() {
            this.f2324e.removeMessages(1);
            this.f2324e.removeMessages(2);
            this.f2324e.removeMessages(3);
            this.f2334o = false;
            this.f2330k = false;
            this.f2331l = false;
            this.f2328i = false;
            if (this.f2329j) {
                this.f2329j = false;
            }
        }

        private void e(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            } else if (this.f2325f != null) {
                this.f2339t = true;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
                int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
                this.f2322c = viewConfiguration.getScaledMinimumFlingVelocity();
                this.f2323d = viewConfiguration.getScaledMaximumFlingVelocity();
                this.f2320a = scaledTouchSlop * scaledTouchSlop;
                this.f2321b = scaledDoubleTapSlop * scaledDoubleTapSlop;
            } else {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            }
        }

        private boolean f(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            if (!this.f2331l || motionEvent3.getEventTime() - motionEvent2.getEventTime() > ((long) f2319w)) {
                return false;
            }
            int x10 = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
            int y10 = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
            return (x10 * x10) + (y10 * y10) < this.f2321b;
        }

        /* JADX WARNING: Removed duplicated region for block: B:100:0x0204  */
        /* JADX WARNING: Removed duplicated region for block: B:103:0x021b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(android.view.MotionEvent r13) {
            /*
                r12 = this;
                int r0 = r13.getAction()
                android.view.VelocityTracker r1 = r12.f2340u
                if (r1 != 0) goto L_0x000e
                android.view.VelocityTracker r1 = android.view.VelocityTracker.obtain()
                r12.f2340u = r1
            L_0x000e:
                android.view.VelocityTracker r1 = r12.f2340u
                r1.addMovement(r13)
                r0 = r0 & 255(0xff, float:3.57E-43)
                r1 = 6
                r2 = 1
                r3 = 0
                if (r0 != r1) goto L_0x001c
                r4 = r2
                goto L_0x001d
            L_0x001c:
                r4 = r3
            L_0x001d:
                if (r4 == 0) goto L_0x0024
                int r5 = r13.getActionIndex()
                goto L_0x0025
            L_0x0024:
                r5 = -1
            L_0x0025:
                int r6 = r13.getPointerCount()
                r7 = 0
                r8 = r3
                r9 = r7
                r10 = r9
            L_0x002d:
                if (r8 >= r6) goto L_0x003f
                if (r5 != r8) goto L_0x0032
                goto L_0x003c
            L_0x0032:
                float r11 = r13.getX(r8)
                float r9 = r9 + r11
                float r11 = r13.getY(r8)
                float r10 = r10 + r11
            L_0x003c:
                int r8 = r8 + 1
                goto L_0x002d
            L_0x003f:
                if (r4 == 0) goto L_0x0044
                int r4 = r6 + -1
                goto L_0x0045
            L_0x0044:
                r4 = r6
            L_0x0045:
                float r4 = (float) r4
                float r9 = r9 / r4
                float r10 = r10 / r4
                r4 = 2
                r5 = 3
                if (r0 == 0) goto L_0x01bb
                r8 = 1000(0x3e8, float:1.401E-42)
                if (r0 == r2) goto L_0x012d
                if (r0 == r4) goto L_0x00b8
                if (r0 == r5) goto L_0x00b3
                r2 = 5
                if (r0 == r2) goto L_0x00a6
                if (r0 == r1) goto L_0x005b
                goto L_0x024c
            L_0x005b:
                r12.f2335p = r9
                r12.f2337r = r9
                r12.f2336q = r10
                r12.f2338s = r10
                android.view.VelocityTracker r0 = r12.f2340u
                int r1 = r12.f2323d
                float r1 = (float) r1
                r0.computeCurrentVelocity(r8, r1)
                int r0 = r13.getActionIndex()
                int r1 = r13.getPointerId(r0)
                android.view.VelocityTracker r2 = r12.f2340u
                float r2 = r2.getXVelocity(r1)
                android.view.VelocityTracker r4 = r12.f2340u
                float r1 = r4.getYVelocity(r1)
                r4 = r3
            L_0x0080:
                if (r4 >= r6) goto L_0x024c
                if (r4 != r0) goto L_0x0085
                goto L_0x00a3
            L_0x0085:
                int r5 = r13.getPointerId(r4)
                android.view.VelocityTracker r8 = r12.f2340u
                float r8 = r8.getXVelocity(r5)
                float r8 = r8 * r2
                android.view.VelocityTracker r9 = r12.f2340u
                float r5 = r9.getYVelocity(r5)
                float r5 = r5 * r1
                float r8 = r8 + r5
                int r5 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
                if (r5 >= 0) goto L_0x00a3
                android.view.VelocityTracker r13 = r12.f2340u
                r13.clear()
                goto L_0x024c
            L_0x00a3:
                int r4 = r4 + 1
                goto L_0x0080
            L_0x00a6:
                r12.f2335p = r9
                r12.f2337r = r9
                r12.f2336q = r10
                r12.f2338s = r10
                r12.c()
                goto L_0x024c
            L_0x00b3:
                r12.b()
                goto L_0x024c
            L_0x00b8:
                boolean r0 = r12.f2329j
                if (r0 == 0) goto L_0x00be
                goto L_0x024c
            L_0x00be:
                float r0 = r12.f2335p
                float r0 = r0 - r9
                float r1 = r12.f2336q
                float r1 = r1 - r10
                boolean r6 = r12.f2334o
                if (r6 == 0) goto L_0x00d1
                android.view.GestureDetector$OnDoubleTapListener r0 = r12.f2326g
                boolean r13 = r0.onDoubleTapEvent(r13)
                r3 = r3 | r13
                goto L_0x024c
            L_0x00d1:
                boolean r6 = r12.f2330k
                if (r6 == 0) goto L_0x010d
                float r6 = r12.f2337r
                float r6 = r9 - r6
                int r6 = (int) r6
                float r7 = r12.f2338s
                float r7 = r10 - r7
                int r7 = (int) r7
                int r6 = r6 * r6
                int r7 = r7 * r7
                int r6 = r6 + r7
                int r7 = r12.f2320a
                if (r6 <= r7) goto L_0x0104
                android.view.GestureDetector$OnGestureListener r7 = r12.f2325f
                android.view.MotionEvent r8 = r12.f2332m
                boolean r13 = r7.onScroll(r8, r13, r0, r1)
                r12.f2335p = r9
                r12.f2336q = r10
                r12.f2330k = r3
                android.os.Handler r0 = r12.f2324e
                r0.removeMessages(r5)
                android.os.Handler r0 = r12.f2324e
                r0.removeMessages(r2)
                android.os.Handler r0 = r12.f2324e
                r0.removeMessages(r4)
                goto L_0x0105
            L_0x0104:
                r13 = r3
            L_0x0105:
                int r0 = r12.f2320a
                if (r6 <= r0) goto L_0x01b8
                r12.f2331l = r3
                goto L_0x01b8
            L_0x010d:
                float r2 = java.lang.Math.abs(r0)
                r4 = 1065353216(0x3f800000, float:1.0)
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 >= 0) goto L_0x011f
                float r2 = java.lang.Math.abs(r1)
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 < 0) goto L_0x024c
            L_0x011f:
                android.view.GestureDetector$OnGestureListener r2 = r12.f2325f
                android.view.MotionEvent r3 = r12.f2332m
                boolean r3 = r2.onScroll(r3, r13, r0, r1)
                r12.f2335p = r9
                r12.f2336q = r10
                goto L_0x024c
            L_0x012d:
                r12.f2327h = r3
                android.view.MotionEvent r0 = android.view.MotionEvent.obtain(r13)
                boolean r1 = r12.f2334o
                if (r1 == 0) goto L_0x013f
                android.view.GestureDetector$OnDoubleTapListener r1 = r12.f2326g
                boolean r13 = r1.onDoubleTapEvent(r13)
                r13 = r13 | r3
                goto L_0x0197
            L_0x013f:
                boolean r1 = r12.f2329j
                if (r1 == 0) goto L_0x014b
                android.os.Handler r13 = r12.f2324e
                r13.removeMessages(r5)
                r12.f2329j = r3
                goto L_0x018d
            L_0x014b:
                boolean r1 = r12.f2330k
                if (r1 == 0) goto L_0x0162
                android.view.GestureDetector$OnGestureListener r1 = r12.f2325f
                boolean r1 = r1.onSingleTapUp(r13)
                boolean r5 = r12.f2328i
                if (r5 == 0) goto L_0x0160
                android.view.GestureDetector$OnDoubleTapListener r5 = r12.f2326g
                if (r5 == 0) goto L_0x0160
                r5.onSingleTapConfirmed(r13)
            L_0x0160:
                r13 = r1
                goto L_0x0197
            L_0x0162:
                android.view.VelocityTracker r1 = r12.f2340u
                int r5 = r13.getPointerId(r3)
                int r6 = r12.f2323d
                float r6 = (float) r6
                r1.computeCurrentVelocity(r8, r6)
                float r6 = r1.getYVelocity(r5)
                float r1 = r1.getXVelocity(r5)
                float r5 = java.lang.Math.abs(r6)
                int r7 = r12.f2322c
                float r7 = (float) r7
                int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r5 > 0) goto L_0x018f
                float r5 = java.lang.Math.abs(r1)
                int r7 = r12.f2322c
                float r7 = (float) r7
                int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r5 <= 0) goto L_0x018d
                goto L_0x018f
            L_0x018d:
                r13 = r3
                goto L_0x0197
            L_0x018f:
                android.view.GestureDetector$OnGestureListener r5 = r12.f2325f
                android.view.MotionEvent r7 = r12.f2332m
                boolean r13 = r5.onFling(r7, r13, r1, r6)
            L_0x0197:
                android.view.MotionEvent r1 = r12.f2333n
                if (r1 == 0) goto L_0x019e
                r1.recycle()
            L_0x019e:
                r12.f2333n = r0
                android.view.VelocityTracker r0 = r12.f2340u
                if (r0 == 0) goto L_0x01aa
                r0.recycle()
                r0 = 0
                r12.f2340u = r0
            L_0x01aa:
                r12.f2334o = r3
                r12.f2328i = r3
                android.os.Handler r0 = r12.f2324e
                r0.removeMessages(r2)
                android.os.Handler r0 = r12.f2324e
                r0.removeMessages(r4)
            L_0x01b8:
                r3 = r13
                goto L_0x024c
            L_0x01bb:
                android.view.GestureDetector$OnDoubleTapListener r0 = r12.f2326g
                if (r0 == 0) goto L_0x01f7
                android.os.Handler r0 = r12.f2324e
                boolean r0 = r0.hasMessages(r5)
                if (r0 == 0) goto L_0x01cc
                android.os.Handler r1 = r12.f2324e
                r1.removeMessages(r5)
            L_0x01cc:
                android.view.MotionEvent r1 = r12.f2332m
                if (r1 == 0) goto L_0x01ef
                android.view.MotionEvent r6 = r12.f2333n
                if (r6 == 0) goto L_0x01ef
                if (r0 == 0) goto L_0x01ef
                boolean r0 = r12.f(r1, r6, r13)
                if (r0 == 0) goto L_0x01ef
                r12.f2334o = r2
                android.view.GestureDetector$OnDoubleTapListener r0 = r12.f2326g
                android.view.MotionEvent r1 = r12.f2332m
                boolean r0 = r0.onDoubleTap(r1)
                r0 = r0 | r3
                android.view.GestureDetector$OnDoubleTapListener r1 = r12.f2326g
                boolean r1 = r1.onDoubleTapEvent(r13)
                r0 = r0 | r1
                goto L_0x01f8
            L_0x01ef:
                android.os.Handler r0 = r12.f2324e
                int r1 = f2319w
                long r6 = (long) r1
                r0.sendEmptyMessageDelayed(r5, r6)
            L_0x01f7:
                r0 = r3
            L_0x01f8:
                r12.f2335p = r9
                r12.f2337r = r9
                r12.f2336q = r10
                r12.f2338s = r10
                android.view.MotionEvent r1 = r12.f2332m
                if (r1 == 0) goto L_0x0207
                r1.recycle()
            L_0x0207:
                android.view.MotionEvent r1 = android.view.MotionEvent.obtain(r13)
                r12.f2332m = r1
                r12.f2330k = r2
                r12.f2331l = r2
                r12.f2327h = r2
                r12.f2329j = r3
                r12.f2328i = r3
                boolean r1 = r12.f2339t
                if (r1 == 0) goto L_0x0235
                android.os.Handler r1 = r12.f2324e
                r1.removeMessages(r4)
                android.os.Handler r1 = r12.f2324e
                android.view.MotionEvent r3 = r12.f2332m
                long r5 = r3.getDownTime()
                int r3 = f2318v
                long r7 = (long) r3
                long r5 = r5 + r7
                int r3 = android.view.ViewConfiguration.getLongPressTimeout()
                long r7 = (long) r3
                long r5 = r5 + r7
                r1.sendEmptyMessageAtTime(r4, r5)
            L_0x0235:
                android.os.Handler r1 = r12.f2324e
                android.view.MotionEvent r3 = r12.f2332m
                long r3 = r3.getDownTime()
                int r5 = f2318v
                long r5 = (long) r5
                long r3 = r3 + r5
                r1.sendEmptyMessageAtTime(r2, r3)
                android.view.GestureDetector$OnGestureListener r1 = r12.f2325f
                boolean r13 = r1.onDown(r13)
                r3 = r0 | r13
            L_0x024c:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.e.b.a(android.view.MotionEvent):boolean");
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.f2324e.removeMessages(3);
            this.f2328i = false;
            this.f2329j = true;
            this.f2325f.onLongPress(this.f2332m);
        }

        public void g(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.f2326g = onDoubleTapListener;
        }
    }

    static class c implements a {

        /* renamed from: a  reason: collision with root package name */
        private final GestureDetector f2342a;

        c(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.f2342a = new GestureDetector(context, onGestureListener, handler);
        }

        public boolean a(MotionEvent motionEvent) {
            return this.f2342a.onTouchEvent(motionEvent);
        }
    }

    public e(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, (Handler) null);
    }

    public e(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        this.f2317a = Build.VERSION.SDK_INT > 17 ? new c(context, onGestureListener, handler) : new b(context, onGestureListener, handler);
    }

    public boolean a(MotionEvent motionEvent) {
        return this.f2317a.a(motionEvent);
    }
}
