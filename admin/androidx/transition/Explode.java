package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import x1.a;
import x1.b;

public class Explode extends Visibility {
    private static final TimeInterpolator M = new DecelerateInterpolator();
    private static final TimeInterpolator N = new AccelerateInterpolator();
    private int[] L = new int[2];

    public Explode() {
        o0(new a());
    }

    public Explode(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        o0(new a());
    }

    private static float B0(float f10, float f11) {
        return (float) Math.sqrt((double) ((f10 * f10) + (f11 * f11)));
    }

    private static float C0(View view, int i10, int i11) {
        return B0((float) Math.max(i10, view.getWidth() - i10), (float) Math.max(i11, view.getHeight() - i11));
    }

    private void D0(View view, Rect rect, int[] iArr) {
        int i10;
        int i11;
        View view2 = view;
        view2.getLocationOnScreen(this.L);
        int[] iArr2 = this.L;
        int i12 = iArr2[0];
        int i13 = iArr2[1];
        Rect A = A();
        if (A == null) {
            i11 = (view.getWidth() / 2) + i12 + Math.round(view.getTranslationX());
            i10 = (view.getHeight() / 2) + i13 + Math.round(view.getTranslationY());
        } else {
            int centerX = A.centerX();
            i10 = A.centerY();
            i11 = centerX;
        }
        float centerX2 = (float) (rect.centerX() - i11);
        float centerY = (float) (rect.centerY() - i10);
        if (centerX2 == 0.0f && centerY == 0.0f) {
            centerX2 = ((float) (Math.random() * 2.0d)) - 1.0f;
            centerY = ((float) (Math.random() * 2.0d)) - 1.0f;
        }
        float B0 = B0(centerX2, centerY);
        float C0 = C0(view2, i11 - i12, i10 - i13);
        iArr[0] = Math.round((centerX2 / B0) * C0);
        iArr[1] = Math.round(C0 * (centerY / B0));
    }

    private void t0(u uVar) {
        View view = uVar.f4165b;
        view.getLocationOnScreen(this.L);
        int[] iArr = this.L;
        int i10 = iArr[0];
        int i11 = iArr[1];
        uVar.f4164a.put("android:explode:screenBounds", new Rect(i10, i11, view.getWidth() + i10, view.getHeight() + i11));
    }

    public void l(u uVar) {
        super.l(uVar);
        t0(uVar);
    }

    public void o(u uVar) {
        super.o(uVar);
        t0(uVar);
    }

    public Animator w0(ViewGroup viewGroup, View view, u uVar, u uVar2) {
        if (uVar2 == null) {
            return null;
        }
        Rect rect = (Rect) uVar2.f4164a.get("android:explode:screenBounds");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        D0(viewGroup, rect, this.L);
        int[] iArr = this.L;
        return w.a(view, uVar2, rect.left, rect.top, translationX + ((float) iArr[0]), translationY + ((float) iArr[1]), translationX, translationY, M, this);
    }

    public Animator y0(ViewGroup viewGroup, View view, u uVar, u uVar2) {
        float f10;
        float f11;
        if (uVar == null) {
            return null;
        }
        Rect rect = (Rect) uVar.f4164a.get("android:explode:screenBounds");
        int i10 = rect.left;
        int i11 = rect.top;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) uVar.f4165b.getTag(b.transition_position);
        if (iArr != null) {
            f11 = ((float) (iArr[0] - rect.left)) + translationX;
            f10 = ((float) (iArr[1] - rect.top)) + translationY;
            rect.offsetTo(iArr[0], iArr[1]);
        } else {
            f11 = translationX;
            f10 = translationY;
        }
        D0(viewGroup, rect, this.L);
        int[] iArr2 = this.L;
        return w.a(view, uVar, i10, i11, translationX, translationY, f11 + ((float) iArr2[0]), f10 + ((float) iArr2[1]), N, this);
    }
}
