package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.f;

public class MotionButton extends AppCompatButton {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public float f1817c = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public float f1818d = Float.NaN;

    /* renamed from: e  reason: collision with root package name */
    private Path f1819e;

    /* renamed from: f  reason: collision with root package name */
    ViewOutlineProvider f1820f;

    /* renamed from: g  reason: collision with root package name */
    RectF f1821g;

    class a extends ViewOutlineProvider {
        a() {
        }

        public void getOutline(View view, Outline outline) {
            int width = MotionButton.this.getWidth();
            int height = MotionButton.this.getHeight();
            outline.setRoundRect(0, 0, width, height, (((float) Math.min(width, height)) * MotionButton.this.f1817c) / 2.0f);
        }
    }

    class b extends ViewOutlineProvider {
        b() {
        }

        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, MotionButton.this.getWidth(), MotionButton.this.getHeight(), MotionButton.this.f1818d);
        }
    }

    public MotionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context, attributeSet);
    }

    public MotionButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        c(context, attributeSet);
    }

    private void c(Context context, AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, f.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == f.ImageFilterView_round) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                    }
                } else if (index == f.ImageFilterView_roundPercent && Build.VERSION.SDK_INT >= 21) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void draw(Canvas canvas) {
        boolean z10;
        if (Build.VERSION.SDK_INT >= 21 || this.f1818d == 0.0f || this.f1819e == null) {
            z10 = false;
        } else {
            z10 = true;
            canvas.save();
            canvas.clipPath(this.f1819e);
        }
        super.draw(canvas);
        if (z10) {
            canvas.restore();
        }
    }

    public float getRound() {
        return this.f1818d;
    }

    public float getRoundPercent() {
        return this.f1817c;
    }

    public void setRound(float f10) {
        if (Float.isNaN(f10)) {
            this.f1818d = f10;
            float f11 = this.f1817c;
            this.f1817c = -1.0f;
            setRoundPercent(f11);
            return;
        }
        boolean z10 = this.f1818d != f10;
        this.f1818d = f10;
        if (f10 != 0.0f) {
            if (this.f1819e == null) {
                this.f1819e = new Path();
            }
            if (this.f1821g == null) {
                this.f1821g = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.f1820f == null) {
                    b bVar = new b();
                    this.f1820f = bVar;
                    setOutlineProvider(bVar);
                }
                setClipToOutline(true);
            }
            this.f1821g.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.f1819e.reset();
            Path path = this.f1819e;
            RectF rectF = this.f1821g;
            float f12 = this.f1818d;
            path.addRoundRect(rectF, f12, f12, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(false);
        }
        if (z10 && Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f10) {
        boolean z10 = this.f1817c != f10;
        this.f1817c = f10;
        if (f10 != 0.0f) {
            if (this.f1819e == null) {
                this.f1819e = new Path();
            }
            if (this.f1821g == null) {
                this.f1821g = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.f1820f == null) {
                    a aVar = new a();
                    this.f1820f = aVar;
                    setOutlineProvider(aVar);
                }
                setClipToOutline(true);
            }
            int width = getWidth();
            int height = getHeight();
            float min = (((float) Math.min(width, height)) * this.f1817c) / 2.0f;
            this.f1821g.set(0.0f, 0.0f, (float) width, (float) height);
            this.f1819e.reset();
            this.f1819e.addRoundRect(this.f1821g, min, min, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(false);
        }
        if (z10 && Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }
}
