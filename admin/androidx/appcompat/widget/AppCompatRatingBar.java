package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import j.a;

public class AppCompatRatingBar extends RatingBar {

    /* renamed from: a  reason: collision with root package name */
    private final i f803a;

    public AppCompatRatingBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.ratingBarStyle);
    }

    public AppCompatRatingBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        b0.a(this, getContext());
        i iVar = new i(this);
        this.f803a = iVar;
        iVar.c(attributeSet, i10);
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        Bitmap b10 = this.f803a.b();
        if (b10 != null) {
            setMeasuredDimension(View.resolveSizeAndState(b10.getWidth() * getNumStars(), i10, 0), getMeasuredHeight());
        }
    }
}
