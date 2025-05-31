package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;
import j.a;

public class AppCompatSeekBar extends SeekBar {

    /* renamed from: a  reason: collision with root package name */
    private final k f804a;

    public AppCompatSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.seekBarStyle);
    }

    public AppCompatSeekBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        b0.a(this, getContext());
        k kVar = new k(this);
        this.f804a = kVar;
        kVar.c(attributeSet, i10);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.f804a.h();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.f804a.i();
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f804a.g(canvas);
    }
}
