package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import h0.e;

public class Placeholder extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f1955a = -1;

    /* renamed from: b  reason: collision with root package name */
    private View f1956b = null;

    /* renamed from: c  reason: collision with root package name */
    private int f1957c = 4;

    public Placeholder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public Placeholder(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        super.setVisibility(this.f1957c);
        this.f1955a = -1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, f.ConstraintLayout_placeholder);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == f.ConstraintLayout_placeholder_content) {
                    this.f1955a = obtainStyledAttributes.getResourceId(index, this.f1955a);
                } else if (index == f.ConstraintLayout_placeholder_placeholder_emptyVisibility) {
                    this.f1957c = obtainStyledAttributes.getInt(index, this.f1957c);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void b(ConstraintLayout constraintLayout) {
        if (this.f1956b != null) {
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f1956b.getLayoutParams();
            layoutParams2.f1926r0.n1(0);
            e.b C = layoutParams.f1926r0.C();
            e.b bVar = e.b.FIXED;
            if (C != bVar) {
                layoutParams.f1926r0.o1(layoutParams2.f1926r0.Y());
            }
            if (layoutParams.f1926r0.V() != bVar) {
                layoutParams.f1926r0.P0(layoutParams2.f1926r0.z());
            }
            layoutParams2.f1926r0.n1(8);
        }
    }

    public void c(ConstraintLayout constraintLayout) {
        if (this.f1955a == -1 && !isInEditMode()) {
            setVisibility(this.f1957c);
        }
        View findViewById = constraintLayout.findViewById(this.f1955a);
        this.f1956b = findViewById;
        if (findViewById != null) {
            ((ConstraintLayout.LayoutParams) findViewById.getLayoutParams()).f1902f0 = true;
            this.f1956b.setVisibility(0);
            setVisibility(0);
        }
    }

    public View getContent() {
        return this.f1956b;
    }

    public int getEmptyVisibility() {
        return this.f1957c;
    }

    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize((float) rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((((float) width) / 2.0f) - (((float) rect.width()) / 2.0f)) - ((float) rect.left), ((((float) height) / 2.0f) + (((float) rect.height()) / 2.0f)) - ((float) rect.bottom), paint);
        }
    }

    public void setContentId(int i10) {
        View findViewById;
        if (this.f1955a != i10) {
            View view = this.f1956b;
            if (view != null) {
                view.setVisibility(0);
                ((ConstraintLayout.LayoutParams) this.f1956b.getLayoutParams()).f1902f0 = false;
                this.f1956b = null;
            }
            this.f1955a = i10;
            if (i10 != -1 && (findViewById = ((View) getParent()).findViewById(i10)) != null) {
                findViewById.setVisibility(8);
            }
        }
    }

    public void setEmptyVisibility(int i10) {
        this.f1957c = i10;
    }
}
