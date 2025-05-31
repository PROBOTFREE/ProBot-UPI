package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import o0.c;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class i extends h {

    /* renamed from: j  reason: collision with root package name */
    static final PorterDuff.Mode f4209j = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    private h f4210b;

    /* renamed from: c  reason: collision with root package name */
    private PorterDuffColorFilter f4211c;

    /* renamed from: d  reason: collision with root package name */
    private ColorFilter f4212d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f4213e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4214f;

    /* renamed from: g  reason: collision with root package name */
    private final float[] f4215g;

    /* renamed from: h  reason: collision with root package name */
    private final Matrix f4216h;

    /* renamed from: i  reason: collision with root package name */
    private final Rect f4217i;

    private static class b extends f {
        b() {
        }

        b(b bVar) {
            super(bVar);
        }

        private void f(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f4244b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f4243a = o0.c.d(string2);
            }
            this.f4245c = n0.g.g(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        public boolean c() {
            return true;
        }

        public void e(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (n0.g.j(xmlPullParser, "pathData")) {
                TypedArray k10 = n0.g.k(resources, theme, attributeSet, a.f4184d);
                f(k10, xmlPullParser);
                k10.recycle();
            }
        }
    }

    private static class c extends f {

        /* renamed from: e  reason: collision with root package name */
        private int[] f4218e;

        /* renamed from: f  reason: collision with root package name */
        n0.b f4219f;

        /* renamed from: g  reason: collision with root package name */
        float f4220g = 0.0f;

        /* renamed from: h  reason: collision with root package name */
        n0.b f4221h;

        /* renamed from: i  reason: collision with root package name */
        float f4222i = 1.0f;

        /* renamed from: j  reason: collision with root package name */
        float f4223j = 1.0f;

        /* renamed from: k  reason: collision with root package name */
        float f4224k = 0.0f;

        /* renamed from: l  reason: collision with root package name */
        float f4225l = 1.0f;

        /* renamed from: m  reason: collision with root package name */
        float f4226m = 0.0f;

        /* renamed from: n  reason: collision with root package name */
        Paint.Cap f4227n = Paint.Cap.BUTT;

        /* renamed from: o  reason: collision with root package name */
        Paint.Join f4228o = Paint.Join.MITER;

        /* renamed from: p  reason: collision with root package name */
        float f4229p = 4.0f;

        c() {
        }

        c(c cVar) {
            super(cVar);
            this.f4218e = cVar.f4218e;
            this.f4219f = cVar.f4219f;
            this.f4220g = cVar.f4220g;
            this.f4222i = cVar.f4222i;
            this.f4221h = cVar.f4221h;
            this.f4245c = cVar.f4245c;
            this.f4223j = cVar.f4223j;
            this.f4224k = cVar.f4224k;
            this.f4225l = cVar.f4225l;
            this.f4226m = cVar.f4226m;
            this.f4227n = cVar.f4227n;
            this.f4228o = cVar.f4228o;
            this.f4229p = cVar.f4229p;
        }

        private Paint.Cap e(int i10, Paint.Cap cap) {
            return i10 != 0 ? i10 != 1 ? i10 != 2 ? cap : Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }

        private Paint.Join f(int i10, Paint.Join join) {
            return i10 != 0 ? i10 != 1 ? i10 != 2 ? join : Paint.Join.BEVEL : Paint.Join.ROUND : Paint.Join.MITER;
        }

        private void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f4218e = null;
            if (n0.g.j(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f4244b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f4243a = o0.c.d(string2);
                }
                Resources.Theme theme2 = theme;
                this.f4221h = n0.g.e(typedArray, xmlPullParser, theme2, "fillColor", 1, 0);
                this.f4223j = n0.g.f(typedArray, xmlPullParser, "fillAlpha", 12, this.f4223j);
                this.f4227n = e(n0.g.g(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f4227n);
                this.f4228o = f(n0.g.g(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f4228o);
                this.f4229p = n0.g.f(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f4229p);
                this.f4219f = n0.g.e(typedArray, xmlPullParser, theme2, "strokeColor", 3, 0);
                this.f4222i = n0.g.f(typedArray, xmlPullParser, "strokeAlpha", 11, this.f4222i);
                this.f4220g = n0.g.f(typedArray, xmlPullParser, "strokeWidth", 4, this.f4220g);
                this.f4225l = n0.g.f(typedArray, xmlPullParser, "trimPathEnd", 6, this.f4225l);
                this.f4226m = n0.g.f(typedArray, xmlPullParser, "trimPathOffset", 7, this.f4226m);
                this.f4224k = n0.g.f(typedArray, xmlPullParser, "trimPathStart", 5, this.f4224k);
                this.f4245c = n0.g.g(typedArray, xmlPullParser, "fillType", 13, this.f4245c);
            }
        }

        public boolean a() {
            return this.f4221h.i() || this.f4219f.i();
        }

        public boolean b(int[] iArr) {
            return this.f4219f.j(iArr) | this.f4221h.j(iArr);
        }

        public void g(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray k10 = n0.g.k(resources, theme, attributeSet, a.f4183c);
            h(k10, xmlPullParser, theme);
            k10.recycle();
        }

        /* access modifiers changed from: package-private */
        public float getFillAlpha() {
            return this.f4223j;
        }

        /* access modifiers changed from: package-private */
        public int getFillColor() {
            return this.f4221h.e();
        }

        /* access modifiers changed from: package-private */
        public float getStrokeAlpha() {
            return this.f4222i;
        }

        /* access modifiers changed from: package-private */
        public int getStrokeColor() {
            return this.f4219f.e();
        }

        /* access modifiers changed from: package-private */
        public float getStrokeWidth() {
            return this.f4220g;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathEnd() {
            return this.f4225l;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathOffset() {
            return this.f4226m;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathStart() {
            return this.f4224k;
        }

        /* access modifiers changed from: package-private */
        public void setFillAlpha(float f10) {
            this.f4223j = f10;
        }

        /* access modifiers changed from: package-private */
        public void setFillColor(int i10) {
            this.f4221h.k(i10);
        }

        /* access modifiers changed from: package-private */
        public void setStrokeAlpha(float f10) {
            this.f4222i = f10;
        }

        /* access modifiers changed from: package-private */
        public void setStrokeColor(int i10) {
            this.f4219f.k(i10);
        }

        /* access modifiers changed from: package-private */
        public void setStrokeWidth(float f10) {
            this.f4220g = f10;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathEnd(float f10) {
            this.f4225l = f10;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathOffset(float f10) {
            this.f4226m = f10;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathStart(float f10) {
            this.f4224k = f10;
        }
    }

    private static class d extends e {

        /* renamed from: a  reason: collision with root package name */
        final Matrix f4230a;

        /* renamed from: b  reason: collision with root package name */
        final ArrayList<e> f4231b;

        /* renamed from: c  reason: collision with root package name */
        float f4232c;

        /* renamed from: d  reason: collision with root package name */
        private float f4233d;

        /* renamed from: e  reason: collision with root package name */
        private float f4234e;

        /* renamed from: f  reason: collision with root package name */
        private float f4235f;

        /* renamed from: g  reason: collision with root package name */
        private float f4236g;

        /* renamed from: h  reason: collision with root package name */
        private float f4237h;

        /* renamed from: i  reason: collision with root package name */
        private float f4238i;

        /* renamed from: j  reason: collision with root package name */
        final Matrix f4239j;

        /* renamed from: k  reason: collision with root package name */
        int f4240k;

        /* renamed from: l  reason: collision with root package name */
        private int[] f4241l;

        /* renamed from: m  reason: collision with root package name */
        private String f4242m;

        public d() {
            super();
            this.f4230a = new Matrix();
            this.f4231b = new ArrayList<>();
            this.f4232c = 0.0f;
            this.f4233d = 0.0f;
            this.f4234e = 0.0f;
            this.f4235f = 1.0f;
            this.f4236g = 1.0f;
            this.f4237h = 0.0f;
            this.f4238i = 0.0f;
            this.f4239j = new Matrix();
            this.f4242m = null;
        }

        public d(d dVar, c0.a<String, Object> aVar) {
            super();
            f fVar;
            this.f4230a = new Matrix();
            this.f4231b = new ArrayList<>();
            this.f4232c = 0.0f;
            this.f4233d = 0.0f;
            this.f4234e = 0.0f;
            this.f4235f = 1.0f;
            this.f4236g = 1.0f;
            this.f4237h = 0.0f;
            this.f4238i = 0.0f;
            Matrix matrix = new Matrix();
            this.f4239j = matrix;
            this.f4242m = null;
            this.f4232c = dVar.f4232c;
            this.f4233d = dVar.f4233d;
            this.f4234e = dVar.f4234e;
            this.f4235f = dVar.f4235f;
            this.f4236g = dVar.f4236g;
            this.f4237h = dVar.f4237h;
            this.f4238i = dVar.f4238i;
            this.f4241l = dVar.f4241l;
            String str = dVar.f4242m;
            this.f4242m = str;
            this.f4240k = dVar.f4240k;
            if (str != null) {
                aVar.put(str, this);
            }
            matrix.set(dVar.f4239j);
            ArrayList<e> arrayList = dVar.f4231b;
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                e eVar = arrayList.get(i10);
                if (eVar instanceof d) {
                    this.f4231b.add(new d((d) eVar, aVar));
                } else {
                    if (eVar instanceof c) {
                        fVar = new c((c) eVar);
                    } else if (eVar instanceof b) {
                        fVar = new b((b) eVar);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f4231b.add(fVar);
                    String str2 = fVar.f4244b;
                    if (str2 != null) {
                        aVar.put(str2, fVar);
                    }
                }
            }
        }

        private void d() {
            this.f4239j.reset();
            this.f4239j.postTranslate(-this.f4233d, -this.f4234e);
            this.f4239j.postScale(this.f4235f, this.f4236g);
            this.f4239j.postRotate(this.f4232c, 0.0f, 0.0f);
            this.f4239j.postTranslate(this.f4237h + this.f4233d, this.f4238i + this.f4234e);
        }

        private void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f4241l = null;
            this.f4232c = n0.g.f(typedArray, xmlPullParser, "rotation", 5, this.f4232c);
            this.f4233d = typedArray.getFloat(1, this.f4233d);
            this.f4234e = typedArray.getFloat(2, this.f4234e);
            this.f4235f = n0.g.f(typedArray, xmlPullParser, "scaleX", 3, this.f4235f);
            this.f4236g = n0.g.f(typedArray, xmlPullParser, "scaleY", 4, this.f4236g);
            this.f4237h = n0.g.f(typedArray, xmlPullParser, "translateX", 6, this.f4237h);
            this.f4238i = n0.g.f(typedArray, xmlPullParser, "translateY", 7, this.f4238i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f4242m = string;
            }
            d();
        }

        public boolean a() {
            for (int i10 = 0; i10 < this.f4231b.size(); i10++) {
                if (this.f4231b.get(i10).a()) {
                    return true;
                }
            }
            return false;
        }

        public boolean b(int[] iArr) {
            boolean z10 = false;
            for (int i10 = 0; i10 < this.f4231b.size(); i10++) {
                z10 |= this.f4231b.get(i10).b(iArr);
            }
            return z10;
        }

        public void c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray k10 = n0.g.k(resources, theme, attributeSet, a.f4182b);
            e(k10, xmlPullParser);
            k10.recycle();
        }

        public String getGroupName() {
            return this.f4242m;
        }

        public Matrix getLocalMatrix() {
            return this.f4239j;
        }

        public float getPivotX() {
            return this.f4233d;
        }

        public float getPivotY() {
            return this.f4234e;
        }

        public float getRotation() {
            return this.f4232c;
        }

        public float getScaleX() {
            return this.f4235f;
        }

        public float getScaleY() {
            return this.f4236g;
        }

        public float getTranslateX() {
            return this.f4237h;
        }

        public float getTranslateY() {
            return this.f4238i;
        }

        public void setPivotX(float f10) {
            if (f10 != this.f4233d) {
                this.f4233d = f10;
                d();
            }
        }

        public void setPivotY(float f10) {
            if (f10 != this.f4234e) {
                this.f4234e = f10;
                d();
            }
        }

        public void setRotation(float f10) {
            if (f10 != this.f4232c) {
                this.f4232c = f10;
                d();
            }
        }

        public void setScaleX(float f10) {
            if (f10 != this.f4235f) {
                this.f4235f = f10;
                d();
            }
        }

        public void setScaleY(float f10) {
            if (f10 != this.f4236g) {
                this.f4236g = f10;
                d();
            }
        }

        public void setTranslateX(float f10) {
            if (f10 != this.f4237h) {
                this.f4237h = f10;
                d();
            }
        }

        public void setTranslateY(float f10) {
            if (f10 != this.f4238i) {
                this.f4238i = f10;
                d();
            }
        }
    }

    private static abstract class e {
        private e() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    private static abstract class f extends e {

        /* renamed from: a  reason: collision with root package name */
        protected c.b[] f4243a = null;

        /* renamed from: b  reason: collision with root package name */
        String f4244b;

        /* renamed from: c  reason: collision with root package name */
        int f4245c = 0;

        /* renamed from: d  reason: collision with root package name */
        int f4246d;

        public f() {
            super();
        }

        public f(f fVar) {
            super();
            this.f4244b = fVar.f4244b;
            this.f4246d = fVar.f4246d;
            this.f4243a = o0.c.f(fVar.f4243a);
        }

        public boolean c() {
            return false;
        }

        public void d(Path path) {
            path.reset();
            c.b[] bVarArr = this.f4243a;
            if (bVarArr != null) {
                c.b.e(bVarArr, path);
            }
        }

        public c.b[] getPathData() {
            return this.f4243a;
        }

        public String getPathName() {
            return this.f4244b;
        }

        public void setPathData(c.b[] bVarArr) {
            if (!o0.c.b(this.f4243a, bVarArr)) {
                this.f4243a = o0.c.f(bVarArr);
            } else {
                o0.c.j(this.f4243a, bVarArr);
            }
        }
    }

    private static class g {

        /* renamed from: q  reason: collision with root package name */
        private static final Matrix f4247q = new Matrix();

        /* renamed from: a  reason: collision with root package name */
        private final Path f4248a;

        /* renamed from: b  reason: collision with root package name */
        private final Path f4249b;

        /* renamed from: c  reason: collision with root package name */
        private final Matrix f4250c;

        /* renamed from: d  reason: collision with root package name */
        Paint f4251d;

        /* renamed from: e  reason: collision with root package name */
        Paint f4252e;

        /* renamed from: f  reason: collision with root package name */
        private PathMeasure f4253f;

        /* renamed from: g  reason: collision with root package name */
        private int f4254g;

        /* renamed from: h  reason: collision with root package name */
        final d f4255h;

        /* renamed from: i  reason: collision with root package name */
        float f4256i;

        /* renamed from: j  reason: collision with root package name */
        float f4257j;

        /* renamed from: k  reason: collision with root package name */
        float f4258k;

        /* renamed from: l  reason: collision with root package name */
        float f4259l;

        /* renamed from: m  reason: collision with root package name */
        int f4260m;

        /* renamed from: n  reason: collision with root package name */
        String f4261n;

        /* renamed from: o  reason: collision with root package name */
        Boolean f4262o;

        /* renamed from: p  reason: collision with root package name */
        final c0.a<String, Object> f4263p;

        public g() {
            this.f4250c = new Matrix();
            this.f4256i = 0.0f;
            this.f4257j = 0.0f;
            this.f4258k = 0.0f;
            this.f4259l = 0.0f;
            this.f4260m = 255;
            this.f4261n = null;
            this.f4262o = null;
            this.f4263p = new c0.a<>();
            this.f4255h = new d();
            this.f4248a = new Path();
            this.f4249b = new Path();
        }

        public g(g gVar) {
            this.f4250c = new Matrix();
            this.f4256i = 0.0f;
            this.f4257j = 0.0f;
            this.f4258k = 0.0f;
            this.f4259l = 0.0f;
            this.f4260m = 255;
            this.f4261n = null;
            this.f4262o = null;
            c0.a<String, Object> aVar = new c0.a<>();
            this.f4263p = aVar;
            this.f4255h = new d(gVar.f4255h, aVar);
            this.f4248a = new Path(gVar.f4248a);
            this.f4249b = new Path(gVar.f4249b);
            this.f4256i = gVar.f4256i;
            this.f4257j = gVar.f4257j;
            this.f4258k = gVar.f4258k;
            this.f4259l = gVar.f4259l;
            this.f4254g = gVar.f4254g;
            this.f4260m = gVar.f4260m;
            this.f4261n = gVar.f4261n;
            String str = gVar.f4261n;
            if (str != null) {
                aVar.put(str, this);
            }
            this.f4262o = gVar.f4262o;
        }

        private static float a(float f10, float f11, float f12, float f13) {
            return (f10 * f13) - (f11 * f12);
        }

        private void c(d dVar, Matrix matrix, Canvas canvas, int i10, int i11, ColorFilter colorFilter) {
            dVar.f4230a.set(matrix);
            dVar.f4230a.preConcat(dVar.f4239j);
            canvas.save();
            for (int i12 = 0; i12 < dVar.f4231b.size(); i12++) {
                e eVar = dVar.f4231b.get(i12);
                if (eVar instanceof d) {
                    c((d) eVar, dVar.f4230a, canvas, i10, i11, colorFilter);
                } else if (eVar instanceof f) {
                    d(dVar, (f) eVar, canvas, i10, i11, colorFilter);
                }
            }
            canvas.restore();
        }

        private void d(d dVar, f fVar, Canvas canvas, int i10, int i11, ColorFilter colorFilter) {
            float f10 = ((float) i10) / this.f4258k;
            float f11 = ((float) i11) / this.f4259l;
            float min = Math.min(f10, f11);
            Matrix matrix = dVar.f4230a;
            this.f4250c.set(matrix);
            this.f4250c.postScale(f10, f11);
            float e10 = e(matrix);
            if (e10 != 0.0f) {
                fVar.d(this.f4248a);
                Path path = this.f4248a;
                this.f4249b.reset();
                if (fVar.c()) {
                    this.f4249b.setFillType(fVar.f4245c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                    this.f4249b.addPath(path, this.f4250c);
                    canvas.clipPath(this.f4249b);
                    return;
                }
                c cVar = (c) fVar;
                float f12 = cVar.f4224k;
                if (!(f12 == 0.0f && cVar.f4225l == 1.0f)) {
                    float f13 = cVar.f4226m;
                    float f14 = (f12 + f13) % 1.0f;
                    float f15 = (cVar.f4225l + f13) % 1.0f;
                    if (this.f4253f == null) {
                        this.f4253f = new PathMeasure();
                    }
                    this.f4253f.setPath(this.f4248a, false);
                    float length = this.f4253f.getLength();
                    float f16 = f14 * length;
                    float f17 = f15 * length;
                    path.reset();
                    if (f16 > f17) {
                        this.f4253f.getSegment(f16, length, path, true);
                        this.f4253f.getSegment(0.0f, f17, path, true);
                    } else {
                        this.f4253f.getSegment(f16, f17, path, true);
                    }
                    path.rLineTo(0.0f, 0.0f);
                }
                this.f4249b.addPath(path, this.f4250c);
                if (cVar.f4221h.l()) {
                    n0.b bVar = cVar.f4221h;
                    if (this.f4252e == null) {
                        Paint paint = new Paint(1);
                        this.f4252e = paint;
                        paint.setStyle(Paint.Style.FILL);
                    }
                    Paint paint2 = this.f4252e;
                    if (bVar.h()) {
                        Shader f18 = bVar.f();
                        f18.setLocalMatrix(this.f4250c);
                        paint2.setShader(f18);
                        paint2.setAlpha(Math.round(cVar.f4223j * 255.0f));
                    } else {
                        paint2.setShader((Shader) null);
                        paint2.setAlpha(255);
                        paint2.setColor(i.a(bVar.e(), cVar.f4223j));
                    }
                    paint2.setColorFilter(colorFilter);
                    this.f4249b.setFillType(cVar.f4245c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                    canvas.drawPath(this.f4249b, paint2);
                }
                if (cVar.f4219f.l()) {
                    n0.b bVar2 = cVar.f4219f;
                    if (this.f4251d == null) {
                        Paint paint3 = new Paint(1);
                        this.f4251d = paint3;
                        paint3.setStyle(Paint.Style.STROKE);
                    }
                    Paint paint4 = this.f4251d;
                    Paint.Join join = cVar.f4228o;
                    if (join != null) {
                        paint4.setStrokeJoin(join);
                    }
                    Paint.Cap cap = cVar.f4227n;
                    if (cap != null) {
                        paint4.setStrokeCap(cap);
                    }
                    paint4.setStrokeMiter(cVar.f4229p);
                    if (bVar2.h()) {
                        Shader f19 = bVar2.f();
                        f19.setLocalMatrix(this.f4250c);
                        paint4.setShader(f19);
                        paint4.setAlpha(Math.round(cVar.f4222i * 255.0f));
                    } else {
                        paint4.setShader((Shader) null);
                        paint4.setAlpha(255);
                        paint4.setColor(i.a(bVar2.e(), cVar.f4222i));
                    }
                    paint4.setColorFilter(colorFilter);
                    paint4.setStrokeWidth(cVar.f4220g * min * e10);
                    canvas.drawPath(this.f4249b, paint4);
                }
            }
        }

        private float e(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float a10 = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max((float) Math.hypot((double) fArr[0], (double) fArr[1]), (float) Math.hypot((double) fArr[2], (double) fArr[3]));
            if (max > 0.0f) {
                return Math.abs(a10) / max;
            }
            return 0.0f;
        }

        public void b(Canvas canvas, int i10, int i11, ColorFilter colorFilter) {
            c(this.f4255h, f4247q, canvas, i10, i11, colorFilter);
        }

        public boolean f() {
            if (this.f4262o == null) {
                this.f4262o = Boolean.valueOf(this.f4255h.a());
            }
            return this.f4262o.booleanValue();
        }

        public boolean g(int[] iArr) {
            return this.f4255h.b(iArr);
        }

        public float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public int getRootAlpha() {
            return this.f4260m;
        }

        public void setAlpha(float f10) {
            setRootAlpha((int) (f10 * 255.0f));
        }

        public void setRootAlpha(int i10) {
            this.f4260m = i10;
        }
    }

    private static class h extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f4264a;

        /* renamed from: b  reason: collision with root package name */
        g f4265b;

        /* renamed from: c  reason: collision with root package name */
        ColorStateList f4266c;

        /* renamed from: d  reason: collision with root package name */
        PorterDuff.Mode f4267d;

        /* renamed from: e  reason: collision with root package name */
        boolean f4268e;

        /* renamed from: f  reason: collision with root package name */
        Bitmap f4269f;

        /* renamed from: g  reason: collision with root package name */
        ColorStateList f4270g;

        /* renamed from: h  reason: collision with root package name */
        PorterDuff.Mode f4271h;

        /* renamed from: i  reason: collision with root package name */
        int f4272i;

        /* renamed from: j  reason: collision with root package name */
        boolean f4273j;

        /* renamed from: k  reason: collision with root package name */
        boolean f4274k;

        /* renamed from: l  reason: collision with root package name */
        Paint f4275l;

        public h() {
            this.f4266c = null;
            this.f4267d = i.f4209j;
            this.f4265b = new g();
        }

        public h(h hVar) {
            this.f4266c = null;
            this.f4267d = i.f4209j;
            if (hVar != null) {
                this.f4264a = hVar.f4264a;
                g gVar = new g(hVar.f4265b);
                this.f4265b = gVar;
                if (hVar.f4265b.f4252e != null) {
                    gVar.f4252e = new Paint(hVar.f4265b.f4252e);
                }
                if (hVar.f4265b.f4251d != null) {
                    this.f4265b.f4251d = new Paint(hVar.f4265b.f4251d);
                }
                this.f4266c = hVar.f4266c;
                this.f4267d = hVar.f4267d;
                this.f4268e = hVar.f4268e;
            }
        }

        public boolean a(int i10, int i11) {
            return i10 == this.f4269f.getWidth() && i11 == this.f4269f.getHeight();
        }

        public boolean b() {
            return !this.f4274k && this.f4270g == this.f4266c && this.f4271h == this.f4267d && this.f4273j == this.f4268e && this.f4272i == this.f4265b.getRootAlpha();
        }

        public void c(int i10, int i11) {
            if (this.f4269f == null || !a(i10, i11)) {
                this.f4269f = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
                this.f4274k = true;
            }
        }

        public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f4269f, (Rect) null, rect, e(colorFilter));
        }

        public Paint e(ColorFilter colorFilter) {
            if (!f() && colorFilter == null) {
                return null;
            }
            if (this.f4275l == null) {
                Paint paint = new Paint();
                this.f4275l = paint;
                paint.setFilterBitmap(true);
            }
            this.f4275l.setAlpha(this.f4265b.getRootAlpha());
            this.f4275l.setColorFilter(colorFilter);
            return this.f4275l;
        }

        public boolean f() {
            return this.f4265b.getRootAlpha() < 255;
        }

        public boolean g() {
            return this.f4265b.f();
        }

        public int getChangingConfigurations() {
            return this.f4264a;
        }

        public boolean h(int[] iArr) {
            boolean g10 = this.f4265b.g(iArr);
            this.f4274k |= g10;
            return g10;
        }

        public void i() {
            this.f4270g = this.f4266c;
            this.f4271h = this.f4267d;
            this.f4272i = this.f4265b.getRootAlpha();
            this.f4273j = this.f4268e;
            this.f4274k = false;
        }

        public void j(int i10, int i11) {
            this.f4269f.eraseColor(0);
            this.f4265b.b(new Canvas(this.f4269f), i10, i11, (ColorFilter) null);
        }

        public Drawable newDrawable() {
            return new i(this);
        }

        public Drawable newDrawable(Resources resources) {
            return new i(this);
        }
    }

    /* renamed from: androidx.vectordrawable.graphics.drawable.i$i  reason: collision with other inner class name */
    private static class C0048i extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f4276a;

        public C0048i(Drawable.ConstantState constantState) {
            this.f4276a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f4276a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f4276a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            i iVar = new i();
            iVar.f4208a = (VectorDrawable) this.f4276a.newDrawable();
            return iVar;
        }

        public Drawable newDrawable(Resources resources) {
            i iVar = new i();
            iVar.f4208a = (VectorDrawable) this.f4276a.newDrawable(resources);
            return iVar;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            i iVar = new i();
            iVar.f4208a = (VectorDrawable) this.f4276a.newDrawable(resources, theme);
            return iVar;
        }
    }

    i() {
        this.f4214f = true;
        this.f4215g = new float[9];
        this.f4216h = new Matrix();
        this.f4217i = new Rect();
        this.f4210b = new h();
    }

    i(h hVar) {
        this.f4214f = true;
        this.f4215g = new float[9];
        this.f4216h = new Matrix();
        this.f4217i = new Rect();
        this.f4210b = hVar;
        this.f4211c = j(this.f4211c, hVar.f4266c, hVar.f4267d);
    }

    static int a(int i10, float f10) {
        return (i10 & 16777215) | (((int) (((float) Color.alpha(i10)) * f10)) << 24);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036 A[Catch:{ IOException | XmlPullParserException -> 0x0043 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003b A[Catch:{ IOException | XmlPullParserException -> 0x0043 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.vectordrawable.graphics.drawable.i b(android.content.res.Resources r6, int r7, android.content.res.Resources.Theme r8) {
        /*
            java.lang.String r0 = "parser error"
            java.lang.String r1 = "VectorDrawableCompat"
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            if (r2 < r3) goto L_0x0021
            androidx.vectordrawable.graphics.drawable.i r0 = new androidx.vectordrawable.graphics.drawable.i
            r0.<init>()
            android.graphics.drawable.Drawable r6 = n0.f.f(r6, r7, r8)
            r0.f4208a = r6
            androidx.vectordrawable.graphics.drawable.i$i r6 = new androidx.vectordrawable.graphics.drawable.i$i
            android.graphics.drawable.Drawable r7 = r0.f4208a
            android.graphics.drawable.Drawable$ConstantState r7 = r7.getConstantState()
            r6.<init>(r7)
            return r0
        L_0x0021:
            android.content.res.XmlResourceParser r7 = r6.getXml(r7)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0043 }
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r7)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0043 }
        L_0x0029:
            int r3 = r7.next()     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0043 }
            r4 = 2
            if (r3 == r4) goto L_0x0034
            r5 = 1
            if (r3 == r5) goto L_0x0034
            goto L_0x0029
        L_0x0034:
            if (r3 != r4) goto L_0x003b
            androidx.vectordrawable.graphics.drawable.i r6 = c(r6, r7, r2, r8)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0043 }
            return r6
        L_0x003b:
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0043 }
            java.lang.String r7 = "No start tag found"
            r6.<init>(r7)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0043 }
            throw r6     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0043 }
        L_0x0043:
            r6 = move-exception
            goto L_0x0046
        L_0x0045:
            r6 = move-exception
        L_0x0046:
            android.util.Log.e(r1, r0, r6)
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.i.b(android.content.res.Resources, int, android.content.res.Resources$Theme):androidx.vectordrawable.graphics.drawable.i");
    }

    public static i c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        i iVar = new i();
        iVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return iVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: androidx.vectordrawable.graphics.drawable.i$b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: androidx.vectordrawable.graphics.drawable.i$c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: androidx.vectordrawable.graphics.drawable.i$b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: androidx.vectordrawable.graphics.drawable.i$b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: androidx.vectordrawable.graphics.drawable.i$b} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e(android.content.res.Resources r11, org.xmlpull.v1.XmlPullParser r12, android.util.AttributeSet r13, android.content.res.Resources.Theme r14) {
        /*
            r10 = this;
            androidx.vectordrawable.graphics.drawable.i$h r0 = r10.f4210b
            androidx.vectordrawable.graphics.drawable.i$g r1 = r0.f4265b
            java.util.ArrayDeque r2 = new java.util.ArrayDeque
            r2.<init>()
            androidx.vectordrawable.graphics.drawable.i$d r3 = r1.f4255h
            r2.push(r3)
            int r3 = r12.getEventType()
            int r4 = r12.getDepth()
            r5 = 1
            int r4 = r4 + r5
            r6 = r5
        L_0x0019:
            if (r3 == r5) goto L_0x00c4
            int r7 = r12.getDepth()
            r8 = 3
            if (r7 >= r4) goto L_0x0024
            if (r3 == r8) goto L_0x00c4
        L_0x0024:
            r7 = 2
            java.lang.String r9 = "group"
            if (r3 != r7) goto L_0x00af
            java.lang.String r3 = r12.getName()
            java.lang.Object r7 = r2.peek()
            androidx.vectordrawable.graphics.drawable.i$d r7 = (androidx.vectordrawable.graphics.drawable.i.d) r7
            java.lang.String r8 = "path"
            boolean r8 = r8.equals(r3)
            if (r8 == 0) goto L_0x0059
            androidx.vectordrawable.graphics.drawable.i$c r3 = new androidx.vectordrawable.graphics.drawable.i$c
            r3.<init>()
            r3.g(r11, r13, r14, r12)
            java.util.ArrayList<androidx.vectordrawable.graphics.drawable.i$e> r6 = r7.f4231b
            r6.add(r3)
            java.lang.String r6 = r3.getPathName()
            if (r6 == 0) goto L_0x0057
            c0.a<java.lang.String, java.lang.Object> r6 = r1.f4263p
            java.lang.String r7 = r3.getPathName()
            r6.put(r7, r3)
        L_0x0057:
            r6 = 0
            goto L_0x007d
        L_0x0059:
            java.lang.String r8 = "clip-path"
            boolean r8 = r8.equals(r3)
            if (r8 == 0) goto L_0x0085
            androidx.vectordrawable.graphics.drawable.i$b r3 = new androidx.vectordrawable.graphics.drawable.i$b
            r3.<init>()
            r3.e(r11, r13, r14, r12)
            java.util.ArrayList<androidx.vectordrawable.graphics.drawable.i$e> r7 = r7.f4231b
            r7.add(r3)
            java.lang.String r7 = r3.getPathName()
            if (r7 == 0) goto L_0x007d
            c0.a<java.lang.String, java.lang.Object> r7 = r1.f4263p
            java.lang.String r8 = r3.getPathName()
            r7.put(r8, r3)
        L_0x007d:
            int r7 = r0.f4264a
            int r3 = r3.f4246d
        L_0x0081:
            r3 = r3 | r7
            r0.f4264a = r3
            goto L_0x00be
        L_0x0085:
            boolean r3 = r9.equals(r3)
            if (r3 == 0) goto L_0x00be
            androidx.vectordrawable.graphics.drawable.i$d r3 = new androidx.vectordrawable.graphics.drawable.i$d
            r3.<init>()
            r3.c(r11, r13, r14, r12)
            java.util.ArrayList<androidx.vectordrawable.graphics.drawable.i$e> r7 = r7.f4231b
            r7.add(r3)
            r2.push(r3)
            java.lang.String r7 = r3.getGroupName()
            if (r7 == 0) goto L_0x00aa
            c0.a<java.lang.String, java.lang.Object> r7 = r1.f4263p
            java.lang.String r8 = r3.getGroupName()
            r7.put(r8, r3)
        L_0x00aa:
            int r7 = r0.f4264a
            int r3 = r3.f4240k
            goto L_0x0081
        L_0x00af:
            if (r3 != r8) goto L_0x00be
            java.lang.String r3 = r12.getName()
            boolean r3 = r9.equals(r3)
            if (r3 == 0) goto L_0x00be
            r2.pop()
        L_0x00be:
            int r3 = r12.next()
            goto L_0x0019
        L_0x00c4:
            if (r6 != 0) goto L_0x00c7
            return
        L_0x00c7:
            org.xmlpull.v1.XmlPullParserException r11 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r12 = "no path defined"
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.i.e(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):void");
    }

    private boolean f() {
        return Build.VERSION.SDK_INT >= 17 && isAutoMirrored() && p0.a.f(this) == 1;
    }

    private static PorterDuff.Mode g(int i10, PorterDuff.Mode mode) {
        if (i10 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i10 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i10 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i10) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    private void i(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
        h hVar = this.f4210b;
        g gVar = hVar.f4265b;
        hVar.f4267d = g(n0.g.g(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList c10 = n0.g.c(typedArray, xmlPullParser, theme, "tint", 1);
        if (c10 != null) {
            hVar.f4266c = c10;
        }
        hVar.f4268e = n0.g.a(typedArray, xmlPullParser, "autoMirrored", 5, hVar.f4268e);
        gVar.f4258k = n0.g.f(typedArray, xmlPullParser, "viewportWidth", 7, gVar.f4258k);
        float f10 = n0.g.f(typedArray, xmlPullParser, "viewportHeight", 8, gVar.f4259l);
        gVar.f4259l = f10;
        if (gVar.f4258k <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (f10 > 0.0f) {
            gVar.f4256i = typedArray.getDimension(3, gVar.f4256i);
            float dimension = typedArray.getDimension(2, gVar.f4257j);
            gVar.f4257j = dimension;
            if (gVar.f4256i <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (dimension > 0.0f) {
                gVar.setAlpha(n0.g.f(typedArray, xmlPullParser, "alpha", 4, gVar.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    gVar.f4261n = string;
                    gVar.f4263p.put(string, gVar);
                }
            } else {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            }
        } else {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.f4208a;
        if (drawable == null) {
            return false;
        }
        p0.a.b(drawable);
        return false;
    }

    /* access modifiers changed from: package-private */
    public Object d(String str) {
        return this.f4210b.f4265b.f4263p.get(str);
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f4208a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f4217i);
        if (this.f4217i.width() > 0 && this.f4217i.height() > 0) {
            ColorFilter colorFilter = this.f4212d;
            if (colorFilter == null) {
                colorFilter = this.f4211c;
            }
            canvas.getMatrix(this.f4216h);
            this.f4216h.getValues(this.f4215g);
            float abs = Math.abs(this.f4215g[0]);
            float abs2 = Math.abs(this.f4215g[4]);
            float abs3 = Math.abs(this.f4215g[1]);
            float abs4 = Math.abs(this.f4215g[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs = 1.0f;
                abs2 = 1.0f;
            }
            int min = Math.min(RecyclerView.m.FLAG_MOVED, (int) (((float) this.f4217i.width()) * abs));
            int min2 = Math.min(RecyclerView.m.FLAG_MOVED, (int) (((float) this.f4217i.height()) * abs2));
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                Rect rect = this.f4217i;
                canvas.translate((float) rect.left, (float) rect.top);
                if (f()) {
                    canvas.translate((float) this.f4217i.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.f4217i.offsetTo(0, 0);
                this.f4210b.c(min, min2);
                if (!this.f4214f) {
                    this.f4210b.j(min, min2);
                } else if (!this.f4210b.b()) {
                    this.f4210b.j(min, min2);
                    this.f4210b.i();
                }
                this.f4210b.d(canvas, colorFilter, this.f4217i);
                canvas.restoreToCount(save);
            }
        }
    }

    public int getAlpha() {
        Drawable drawable = this.f4208a;
        return drawable != null ? p0.a.d(drawable) : this.f4210b.f4265b.getRootAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.f4208a;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f4210b.getChangingConfigurations();
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.f4208a;
        return drawable != null ? p0.a.e(drawable) : this.f4212d;
    }

    public Drawable.ConstantState getConstantState() {
        if (this.f4208a != null && Build.VERSION.SDK_INT >= 24) {
            return new C0048i(this.f4208a.getConstantState());
        }
        this.f4210b.f4264a = getChangingConfigurations();
        return this.f4210b;
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.f4208a;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f4210b.f4265b.f4257j;
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.f4208a;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f4210b.f4265b.f4256i;
    }

    public int getOpacity() {
        Drawable drawable = this.f4208a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    /* access modifiers changed from: package-private */
    public void h(boolean z10) {
        this.f4214f = z10;
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        Drawable drawable = this.f4208a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Drawable drawable = this.f4208a;
        if (drawable != null) {
            p0.a.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        h hVar = this.f4210b;
        hVar.f4265b = new g();
        TypedArray k10 = n0.g.k(resources, theme, attributeSet, a.f4181a);
        i(k10, xmlPullParser, theme);
        k10.recycle();
        hVar.f4264a = getChangingConfigurations();
        hVar.f4274k = true;
        e(resources, xmlPullParser, attributeSet, theme);
        this.f4211c = j(this.f4211c, hVar.f4266c, hVar.f4267d);
    }

    public void invalidateSelf() {
        Drawable drawable = this.f4208a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.f4208a;
        return drawable != null ? p0.a.h(drawable) : this.f4210b.f4268e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
        r0 = r1.f4210b.f4266c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
        r0 = r1.f4210b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r1 = this;
            android.graphics.drawable.Drawable r0 = r1.f4208a
            if (r0 == 0) goto L_0x0009
            boolean r0 = r0.isStateful()
            return r0
        L_0x0009:
            boolean r0 = super.isStateful()
            if (r0 != 0) goto L_0x0028
            androidx.vectordrawable.graphics.drawable.i$h r0 = r1.f4210b
            if (r0 == 0) goto L_0x0026
            boolean r0 = r0.g()
            if (r0 != 0) goto L_0x0028
            androidx.vectordrawable.graphics.drawable.i$h r0 = r1.f4210b
            android.content.res.ColorStateList r0 = r0.f4266c
            if (r0 == 0) goto L_0x0026
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r0 = 0
            goto L_0x0029
        L_0x0028:
            r0 = 1
        L_0x0029:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.i.isStateful():boolean");
    }

    /* access modifiers changed from: package-private */
    public PorterDuffColorFilter j(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public Drawable mutate() {
        Drawable drawable = this.f4208a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f4213e && super.mutate() == this) {
            this.f4210b = new h(this.f4210b);
            this.f4213e = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f4208a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.f4208a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z10 = false;
        h hVar = this.f4210b;
        ColorStateList colorStateList = hVar.f4266c;
        if (!(colorStateList == null || (mode = hVar.f4267d) == null)) {
            this.f4211c = j(this.f4211c, colorStateList, mode);
            invalidateSelf();
            z10 = true;
        }
        if (!hVar.g() || !hVar.h(iArr)) {
            return z10;
        }
        invalidateSelf();
        return true;
    }

    public void scheduleSelf(Runnable runnable, long j10) {
        Drawable drawable = this.f4208a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j10);
        } else {
            super.scheduleSelf(runnable, j10);
        }
    }

    public void setAlpha(int i10) {
        Drawable drawable = this.f4208a;
        if (drawable != null) {
            drawable.setAlpha(i10);
        } else if (this.f4210b.f4265b.getRootAlpha() != i10) {
            this.f4210b.f4265b.setRootAlpha(i10);
            invalidateSelf();
        }
    }

    public void setAutoMirrored(boolean z10) {
        Drawable drawable = this.f4208a;
        if (drawable != null) {
            p0.a.j(drawable, z10);
        } else {
            this.f4210b.f4268e = z10;
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f4208a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.f4212d = colorFilter;
        invalidateSelf();
    }

    public void setTint(int i10) {
        Drawable drawable = this.f4208a;
        if (drawable != null) {
            p0.a.n(drawable, i10);
        } else {
            setTintList(ColorStateList.valueOf(i10));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f4208a;
        if (drawable != null) {
            p0.a.o(drawable, colorStateList);
            return;
        }
        h hVar = this.f4210b;
        if (hVar.f4266c != colorStateList) {
            hVar.f4266c = colorStateList;
            this.f4211c = j(this.f4211c, colorStateList, hVar.f4267d);
            invalidateSelf();
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f4208a;
        if (drawable != null) {
            p0.a.p(drawable, mode);
            return;
        }
        h hVar = this.f4210b;
        if (hVar.f4267d != mode) {
            hVar.f4267d = mode;
            this.f4211c = j(this.f4211c, hVar.f4266c, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z10, boolean z11) {
        Drawable drawable = this.f4208a;
        return drawable != null ? drawable.setVisible(z10, z11) : super.setVisible(z10, z11);
    }

    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f4208a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
