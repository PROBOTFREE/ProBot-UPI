package androidx.camera.view;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import androidx.camera.view.PreviewView;
import w0.h;
import z.d;

final class a {

    /* renamed from: g  reason: collision with root package name */
    private static final PreviewView.e f1296g = PreviewView.e.FILL_CENTER;

    /* renamed from: a  reason: collision with root package name */
    private Size f1297a;

    /* renamed from: b  reason: collision with root package name */
    private Rect f1298b;

    /* renamed from: c  reason: collision with root package name */
    private Rect f1299c;

    /* renamed from: d  reason: collision with root package name */
    private int f1300d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1301e;

    /* renamed from: f  reason: collision with root package name */
    private PreviewView.e f1302f = f1296g;

    /* renamed from: androidx.camera.view.a$a  reason: collision with other inner class name */
    static /* synthetic */ class C0011a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1303a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.camera.view.PreviewView$e[] r0 = androidx.camera.view.PreviewView.e.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1303a = r0
                androidx.camera.view.PreviewView$e r1 = androidx.camera.view.PreviewView.e.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f1303a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.view.PreviewView$e r1 = androidx.camera.view.PreviewView.e.FILL_CENTER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f1303a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.camera.view.PreviewView$e r1 = androidx.camera.view.PreviewView.e.FIT_END     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f1303a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.camera.view.PreviewView$e r1 = androidx.camera.view.PreviewView.e.FILL_END     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f1303a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.camera.view.PreviewView$e r1 = androidx.camera.view.PreviewView.e.FIT_START     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f1303a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.camera.view.PreviewView$e r1 = androidx.camera.view.PreviewView.e.FILL_START     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.view.a.C0011a.<clinit>():void");
        }
    }

    a() {
    }

    private static RectF a(RectF rectF, float f10) {
        float f11 = f10 + f10;
        return new RectF(f11 - rectF.right, rectF.top, f11 - rectF.left, rectF.bottom);
    }

    private Size d() {
        return d.d(this.f1300d) ? new Size(this.f1299c.height(), this.f1299c.width()) : new Size(this.f1299c.width(), this.f1299c.height());
    }

    private boolean h() {
        return (this.f1298b == null || this.f1297a == null) ? false : true;
    }

    private static void j(Matrix matrix, RectF rectF, RectF rectF2, PreviewView.e eVar) {
        Matrix.ScaleToFit scaleToFit;
        switch (C0011a.f1303a[eVar.ordinal()]) {
            case 1:
            case 2:
                scaleToFit = Matrix.ScaleToFit.CENTER;
                break;
            case 3:
            case 4:
                scaleToFit = Matrix.ScaleToFit.END;
                break;
            case 5:
            case 6:
                scaleToFit = Matrix.ScaleToFit.START;
                break;
            default:
                u.d.c("PreviewTransform", "Unexpected crop rect: " + eVar);
                scaleToFit = Matrix.ScaleToFit.FILL;
                break;
        }
        if (eVar == PreviewView.e.FIT_CENTER || eVar == PreviewView.e.FIT_START || eVar == PreviewView.e.FIT_END) {
            matrix.setRectToRect(rectF, rectF2, scaleToFit);
            return;
        }
        matrix.setRectToRect(rectF2, rectF, scaleToFit);
        matrix.invert(matrix);
    }

    /* access modifiers changed from: package-private */
    public Matrix b(Size size, int i10) {
        if (!h()) {
            return null;
        }
        Matrix matrix = new Matrix();
        g(size, i10).invert(matrix);
        Matrix matrix2 = new Matrix();
        matrix2.setRectToRect(new RectF(0.0f, 0.0f, (float) this.f1297a.getWidth(), (float) this.f1297a.getHeight()), new RectF(0.0f, 0.0f, 1.0f, 1.0f), Matrix.ScaleToFit.FILL);
        matrix.postConcat(matrix2);
        return matrix;
    }

    /* access modifiers changed from: package-private */
    public RectF c(Size size, int i10) {
        RectF rectF = new RectF(0.0f, 0.0f, (float) size.getWidth(), (float) size.getHeight());
        Size d10 = d();
        RectF rectF2 = new RectF(0.0f, 0.0f, (float) d10.getWidth(), (float) d10.getHeight());
        Matrix matrix = new Matrix();
        j(matrix, rectF2, rectF, this.f1302f);
        matrix.mapRect(rectF2);
        return i10 == 1 ? a(rectF2, ((float) size.getWidth()) / 2.0f) : rectF2;
    }

    /* access modifiers changed from: package-private */
    public PreviewView.e e() {
        return this.f1302f;
    }

    /* access modifiers changed from: package-private */
    public Rect f() {
        return this.f1298b;
    }

    /* access modifiers changed from: package-private */
    public Matrix g(Size size, int i10) {
        h.g(h());
        Matrix c10 = d.c(new RectF(this.f1298b), i(size) ? new RectF(0.0f, 0.0f, (float) size.getWidth(), (float) size.getHeight()) : c(size, i10), this.f1300d);
        if (this.f1301e) {
            if (d.d(this.f1300d)) {
                c10.preScale(1.0f, -1.0f, (float) this.f1298b.centerX(), (float) this.f1298b.centerY());
            } else {
                c10.preScale(-1.0f, 1.0f, (float) this.f1298b.centerX(), (float) this.f1298b.centerY());
            }
        }
        return c10;
    }

    /* access modifiers changed from: package-private */
    public boolean i(Size size) {
        return d.e(size, true, d(), false);
    }

    /* access modifiers changed from: package-private */
    public void k(PreviewView.e eVar) {
        this.f1302f = eVar;
    }
}
