package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.f;
import androidx.recyclerview.widget.k;

public class MockView extends View {

    /* renamed from: a  reason: collision with root package name */
    private Paint f1806a = new Paint();

    /* renamed from: b  reason: collision with root package name */
    private Paint f1807b = new Paint();

    /* renamed from: c  reason: collision with root package name */
    private Paint f1808c = new Paint();

    /* renamed from: d  reason: collision with root package name */
    private boolean f1809d = true;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1810e = true;

    /* renamed from: f  reason: collision with root package name */
    protected String f1811f = null;

    /* renamed from: g  reason: collision with root package name */
    private Rect f1812g = new Rect();

    /* renamed from: h  reason: collision with root package name */
    private int f1813h = Color.argb(255, 0, 0, 0);

    /* renamed from: i  reason: collision with root package name */
    private int f1814i = Color.argb(255, k.f.DEFAULT_DRAG_ANIMATION_DURATION, k.f.DEFAULT_DRAG_ANIMATION_DURATION, k.f.DEFAULT_DRAG_ANIMATION_DURATION);

    /* renamed from: j  reason: collision with root package name */
    private int f1815j = Color.argb(255, 50, 50, 50);

    /* renamed from: k  reason: collision with root package name */
    private int f1816k = 4;

    public MockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public MockView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.MockView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == f.MockView_mock_label) {
                    this.f1811f = obtainStyledAttributes.getString(index);
                } else if (index == f.MockView_mock_showDiagonals) {
                    this.f1809d = obtainStyledAttributes.getBoolean(index, this.f1809d);
                } else if (index == f.MockView_mock_diagonalsColor) {
                    this.f1813h = obtainStyledAttributes.getColor(index, this.f1813h);
                } else if (index == f.MockView_mock_labelBackgroundColor) {
                    this.f1815j = obtainStyledAttributes.getColor(index, this.f1815j);
                } else if (index == f.MockView_mock_labelColor) {
                    this.f1814i = obtainStyledAttributes.getColor(index, this.f1814i);
                } else if (index == f.MockView_mock_showLabel) {
                    this.f1810e = obtainStyledAttributes.getBoolean(index, this.f1810e);
                }
            }
            obtainStyledAttributes.recycle();
        }
        if (this.f1811f == null) {
            try {
                this.f1811f = context.getResources().getResourceEntryName(getId());
            } catch (Exception unused) {
            }
        }
        this.f1806a.setColor(this.f1813h);
        this.f1806a.setAntiAlias(true);
        this.f1807b.setColor(this.f1814i);
        this.f1807b.setAntiAlias(true);
        this.f1808c.setColor(this.f1815j);
        this.f1816k = Math.round(((float) this.f1816k) * (getResources().getDisplayMetrics().xdpi / 160.0f));
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f1809d) {
            width--;
            height--;
            float f10 = (float) width;
            float f11 = (float) height;
            canvas.drawLine(0.0f, 0.0f, f10, f11, this.f1806a);
            Canvas canvas2 = canvas;
            float f12 = f10;
            canvas2.drawLine(0.0f, f11, f12, 0.0f, this.f1806a);
            canvas2.drawLine(0.0f, 0.0f, f12, 0.0f, this.f1806a);
            float f13 = f10;
            float f14 = f11;
            canvas2.drawLine(f13, 0.0f, f12, f14, this.f1806a);
            float f15 = f11;
            canvas2.drawLine(f13, f15, 0.0f, f14, this.f1806a);
            canvas2.drawLine(0.0f, f15, 0.0f, 0.0f, this.f1806a);
        }
        String str = this.f1811f;
        if (str != null && this.f1810e) {
            this.f1807b.getTextBounds(str, 0, str.length(), this.f1812g);
            float width2 = ((float) (width - this.f1812g.width())) / 2.0f;
            float height2 = (((float) (height - this.f1812g.height())) / 2.0f) + ((float) this.f1812g.height());
            this.f1812g.offset((int) width2, (int) height2);
            Rect rect = this.f1812g;
            int i10 = rect.left;
            int i11 = this.f1816k;
            rect.set(i10 - i11, rect.top - i11, rect.right + i11, rect.bottom + i11);
            canvas.drawRect(this.f1812g, this.f1808c);
            canvas.drawText(this.f1811f, width2, height2, this.f1807b);
        }
    }
}
