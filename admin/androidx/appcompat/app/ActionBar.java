package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import j.j;
import o.b;

public abstract class ActionBar {

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f230a;

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
            this.f230a = 0;
            this.f230a = 8388627;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f230a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ActionBarLayout);
            this.f230a = obtainStyledAttributes.getInt(j.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f230a = 0;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.f230a = 0;
            this.f230a = layoutParams.f230a;
        }
    }

    public interface a {
        void a(boolean z10);
    }

    @Deprecated
    public static abstract class b {
        public abstract CharSequence a();

        public abstract View b();

        public abstract Drawable c();

        public abstract CharSequence d();

        public abstract void e();
    }

    public boolean g() {
        return false;
    }

    public abstract boolean h();

    public abstract void i(boolean z10);

    public abstract int j();

    public abstract Context k();

    public boolean l() {
        return false;
    }

    public void m(Configuration configuration) {
    }

    /* access modifiers changed from: package-private */
    public void n() {
    }

    public abstract boolean o(int i10, KeyEvent keyEvent);

    public boolean p(KeyEvent keyEvent) {
        return false;
    }

    public boolean q() {
        return false;
    }

    public abstract void r(boolean z10);

    public abstract void s(boolean z10);

    public abstract void t(CharSequence charSequence);

    public o.b u(b.a aVar) {
        return null;
    }
}
