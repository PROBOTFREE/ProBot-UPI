package androidx.transition;

import android.graphics.Matrix;
import android.graphics.RectF;

class k {

    /* renamed from: a  reason: collision with root package name */
    static final Matrix f4125a = new a();

    static class a extends Matrix {
        a() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            throw new IllegalStateException("Matrix can not be modified");
        }

        public boolean postConcat(Matrix matrix) {
            a();
            return false;
        }

        public boolean postRotate(float f10) {
            a();
            return false;
        }

        public boolean postRotate(float f10, float f11, float f12) {
            a();
            return false;
        }

        public boolean postScale(float f10, float f11) {
            a();
            return false;
        }

        public boolean postScale(float f10, float f11, float f12, float f13) {
            a();
            return false;
        }

        public boolean postSkew(float f10, float f11) {
            a();
            return false;
        }

        public boolean postSkew(float f10, float f11, float f12, float f13) {
            a();
            return false;
        }

        public boolean postTranslate(float f10, float f11) {
            a();
            return false;
        }

        public boolean preConcat(Matrix matrix) {
            a();
            return false;
        }

        public boolean preRotate(float f10) {
            a();
            return false;
        }

        public boolean preRotate(float f10, float f11, float f12) {
            a();
            return false;
        }

        public boolean preScale(float f10, float f11) {
            a();
            return false;
        }

        public boolean preScale(float f10, float f11, float f12, float f13) {
            a();
            return false;
        }

        public boolean preSkew(float f10, float f11) {
            a();
            return false;
        }

        public boolean preSkew(float f10, float f11, float f12, float f13) {
            a();
            return false;
        }

        public boolean preTranslate(float f10, float f11) {
            a();
            return false;
        }

        public void reset() {
            a();
        }

        public void set(Matrix matrix) {
            a();
        }

        public boolean setConcat(Matrix matrix, Matrix matrix2) {
            a();
            return false;
        }

        public boolean setPolyToPoly(float[] fArr, int i10, float[] fArr2, int i11, int i12) {
            a();
            return false;
        }

        public boolean setRectToRect(RectF rectF, RectF rectF2, Matrix.ScaleToFit scaleToFit) {
            a();
            return false;
        }

        public void setRotate(float f10) {
            a();
        }

        public void setRotate(float f10, float f11, float f12) {
            a();
        }

        public void setScale(float f10, float f11) {
            a();
        }

        public void setScale(float f10, float f11, float f12, float f13) {
            a();
        }

        public void setSinCos(float f10, float f11) {
            a();
        }

        public void setSinCos(float f10, float f11, float f12, float f13) {
            a();
        }

        public void setSkew(float f10, float f11) {
            a();
        }

        public void setSkew(float f10, float f11, float f12, float f13) {
            a();
        }

        public void setTranslate(float f10, float f11) {
            a();
        }

        public void setValues(float[] fArr) {
            a();
        }
    }
}
