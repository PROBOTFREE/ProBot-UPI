package androidx.camera.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Rational;
import android.util.Size;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.x;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.u;
import java.util.concurrent.atomic.AtomicReference;
import u.g;

public final class PreviewView extends FrameLayout {

    /* renamed from: j  reason: collision with root package name */
    private static final c f1268j = c.PERFORMANCE;

    /* renamed from: a  reason: collision with root package name */
    c f1269a;

    /* renamed from: b  reason: collision with root package name */
    final a f1270b;

    /* renamed from: c  reason: collision with root package name */
    final u<f> f1271c;

    /* renamed from: d  reason: collision with root package name */
    z.a f1272d;

    /* renamed from: e  reason: collision with root package name */
    b f1273e;

    /* renamed from: f  reason: collision with root package name */
    private final ScaleGestureDetector f1274f;

    /* renamed from: g  reason: collision with root package name */
    private MotionEvent f1275g;

    /* renamed from: h  reason: collision with root package name */
    private final View.OnLayoutChangeListener f1276h;

    /* renamed from: i  reason: collision with root package name */
    final u.f f1277i;

    class a implements u.f {
        a(PreviewView previewView) {
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1278a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f1279b;

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|(3:19|20|22)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|1|2|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0038 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0059 */
        static {
            /*
                androidx.camera.view.PreviewView$c[] r0 = androidx.camera.view.PreviewView.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1279b = r0
                r1 = 1
                androidx.camera.view.PreviewView$c r2 = androidx.camera.view.PreviewView.c.COMPATIBLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f1279b     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.view.PreviewView$c r3 = androidx.camera.view.PreviewView.c.PERFORMANCE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                androidx.camera.view.PreviewView$e[] r2 = androidx.camera.view.PreviewView.e.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f1278a = r2
                androidx.camera.view.PreviewView$e r3 = androidx.camera.view.PreviewView.e.FILL_END     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = f1278a     // Catch:{ NoSuchFieldError -> 0x0038 }
                androidx.camera.view.PreviewView$e r2 = androidx.camera.view.PreviewView.e.FILL_CENTER     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                int[] r0 = f1278a     // Catch:{ NoSuchFieldError -> 0x0043 }
                androidx.camera.view.PreviewView$e r1 = androidx.camera.view.PreviewView.e.FILL_START     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f1278a     // Catch:{ NoSuchFieldError -> 0x004e }
                androidx.camera.view.PreviewView$e r1 = androidx.camera.view.PreviewView.e.FIT_END     // Catch:{ NoSuchFieldError -> 0x004e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = f1278a     // Catch:{ NoSuchFieldError -> 0x0059 }
                androidx.camera.view.PreviewView$e r1 = androidx.camera.view.PreviewView.e.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                int[] r0 = f1278a     // Catch:{ NoSuchFieldError -> 0x0064 }
                androidx.camera.view.PreviewView$e r1 = androidx.camera.view.PreviewView.e.FIT_START     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.view.PreviewView.b.<clinit>():void");
        }
    }

    public enum c {
        PERFORMANCE(0),
        COMPATIBLE(1);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f1283a;

        private c(int i10) {
            this.f1283a = i10;
        }

        static c a(int i10) {
            for (c cVar : values()) {
                if (cVar.f1283a == i10) {
                    return cVar;
                }
            }
            throw new IllegalArgumentException("Unknown implementation mode id " + i10);
        }

        /* access modifiers changed from: package-private */
        public int b() {
            return this.f1283a;
        }
    }

    class d extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        d() {
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            z.a aVar = PreviewView.this.f1272d;
            return true;
        }
    }

    public enum e {
        FILL_START(0),
        FILL_CENTER(1),
        FILL_END(2),
        FIT_START(3),
        FIT_CENTER(4),
        FIT_END(5);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f1292a;

        private e(int i10) {
            this.f1292a = i10;
        }

        static e a(int i10) {
            for (e eVar : values()) {
                if (eVar.f1292a == i10) {
                    return eVar;
                }
            }
            throw new IllegalArgumentException("Unknown scale type id " + i10);
        }

        /* access modifiers changed from: package-private */
        public int b() {
            return this.f1292a;
        }
    }

    public enum f {
        IDLE,
        STREAMING
    }

    public PreviewView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreviewView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    /* JADX INFO: finally extract failed */
    public PreviewView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        c cVar = f1268j;
        this.f1269a = cVar;
        a aVar = new a();
        this.f1270b = aVar;
        this.f1271c = new u<>(f.IDLE);
        new AtomicReference();
        this.f1273e = new b(aVar);
        this.f1276h = new z.b(this);
        this.f1277i = new a(this);
        w.a.a();
        Resources.Theme theme = context.getTheme();
        int[] iArr = z.c.PreviewView;
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, iArr, i10, i11);
        x.p0(this, context, iArr, attributeSet, obtainStyledAttributes, i10, i11);
        try {
            setScaleType(e.a(obtainStyledAttributes.getInteger(z.c.PreviewView_scaleType, aVar.e().b())));
            setImplementationMode(c.a(obtainStyledAttributes.getInteger(z.c.PreviewView_implementationMode, cVar.b())));
            obtainStyledAttributes.recycle();
            this.f1274f = new ScaleGestureDetector(context, new d());
            if (getBackground() == null) {
                setBackgroundColor(androidx.core.content.a.d(getContext(), 17170444));
            }
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    private void b(boolean z10) {
        getDisplay();
        getViewPort();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        if ((i12 - i10 == i16 - i14 && i13 - i11 == i17 - i15) ? false : true) {
            e();
            b(true);
        }
    }

    private int getViewPortScaleType() {
        switch (b.f1278a[getScaleType().ordinal()]) {
            case 1:
                return 2;
            case 2:
                return 1;
            case 3:
                return 0;
            case 4:
            case 5:
            case 6:
                return 3;
            default:
                throw new IllegalStateException("Unexpected scale type: " + getScaleType());
        }
    }

    @SuppressLint({"WrongConstant", "UnsafeOptInUsageError"})
    public g c(int i10) {
        w.a.a();
        if (getWidth() == 0 || getHeight() == 0) {
            return null;
        }
        return new g.a(new Rational(getWidth(), getHeight()), i10).c(getViewPortScaleType()).b(getLayoutDirection()).a();
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.f1273e.a(new Size(getWidth(), getHeight()), getLayoutDirection());
    }

    public Bitmap getBitmap() {
        w.a.a();
        return null;
    }

    public z.a getController() {
        w.a.a();
        return this.f1272d;
    }

    public c getImplementationMode() {
        w.a.a();
        return this.f1269a;
    }

    public u.e getMeteringPointFactory() {
        w.a.a();
        return this.f1273e;
    }

    public a0.a getOutputTransform() {
        Matrix matrix;
        w.a.a();
        try {
            matrix = this.f1270b.g(new Size(getWidth(), getHeight()), getLayoutDirection());
        } catch (IllegalStateException unused) {
            matrix = null;
        }
        Rect f10 = this.f1270b.f();
        if (matrix == null || f10 == null) {
            u.d.a("PreviewView", "Transform info is not ready");
            return null;
        }
        matrix.preConcat(z.d.a(f10));
        u.d.i("PreviewView", "PreviewView needs to be in COMPATIBLE mode for the transform to work correctly.");
        return new a0.a(matrix, new Size(f10.width(), f10.height()));
    }

    public LiveData<f> getPreviewStreamState() {
        return this.f1271c;
    }

    public e getScaleType() {
        w.a.a();
        return this.f1270b.e();
    }

    public u.f getSurfaceProvider() {
        w.a.a();
        return this.f1277i;
    }

    public g getViewPort() {
        w.a.a();
        if (getDisplay() == null) {
            return null;
        }
        return c(getDisplay().getRotation());
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        addOnLayoutChangeListener(this.f1276h);
        b(true);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeOnLayoutChangeListener(this.f1276h);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public boolean performClick() {
        this.f1275g = null;
        return super.performClick();
    }

    public void setController(z.a aVar) {
        w.a.a();
        b(false);
    }

    public void setImplementationMode(c cVar) {
        w.a.a();
        this.f1269a = cVar;
    }

    public void setScaleType(e eVar) {
        w.a.a();
        this.f1270b.k(eVar);
        e();
        b(false);
    }
}
