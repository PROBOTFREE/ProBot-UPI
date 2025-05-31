package androidx.cardview.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.cardview.widget.g;

class a extends c {

    /* renamed from: androidx.cardview.widget.a$a  reason: collision with other inner class name */
    class C0012a implements g.a {
        C0012a(a aVar) {
        }

        public void a(Canvas canvas, RectF rectF, float f10, Paint paint) {
            canvas.drawRoundRect(rectF, f10, f10, paint);
        }
    }

    a() {
    }

    public void g() {
        g.f1330r = new C0012a(this);
    }
}
