package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import n0.f;

public class g0 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1082a;

    /* renamed from: b  reason: collision with root package name */
    private final TypedArray f1083b;

    /* renamed from: c  reason: collision with root package name */
    private TypedValue f1084c;

    private g0(Context context, TypedArray typedArray) {
        this.f1082a = context;
        this.f1083b = typedArray;
    }

    public static g0 t(Context context, int i10, int[] iArr) {
        return new g0(context, context.obtainStyledAttributes(i10, iArr));
    }

    public static g0 u(Context context, AttributeSet attributeSet, int[] iArr) {
        return new g0(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static g0 v(Context context, AttributeSet attributeSet, int[] iArr, int i10, int i11) {
        return new g0(context, context.obtainStyledAttributes(attributeSet, iArr, i10, i11));
    }

    public boolean a(int i10, boolean z10) {
        return this.f1083b.getBoolean(i10, z10);
    }

    public int b(int i10, int i11) {
        return this.f1083b.getColor(i10, i11);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0011, code lost:
        r0 = k.a.c(r2.f1082a, (r0 = r2.f1083b.getResourceId(r3, 0)));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.content.res.ColorStateList c(int r3) {
        /*
            r2 = this;
            android.content.res.TypedArray r0 = r2.f1083b
            boolean r0 = r0.hasValue(r3)
            if (r0 == 0) goto L_0x001a
            android.content.res.TypedArray r0 = r2.f1083b
            r1 = 0
            int r0 = r0.getResourceId(r3, r1)
            if (r0 == 0) goto L_0x001a
            android.content.Context r1 = r2.f1082a
            android.content.res.ColorStateList r0 = k.a.c(r1, r0)
            if (r0 == 0) goto L_0x001a
            return r0
        L_0x001a:
            android.content.res.TypedArray r0 = r2.f1083b
            android.content.res.ColorStateList r3 = r0.getColorStateList(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.g0.c(int):android.content.res.ColorStateList");
    }

    public float d(int i10, float f10) {
        return this.f1083b.getDimension(i10, f10);
    }

    public int e(int i10, int i11) {
        return this.f1083b.getDimensionPixelOffset(i10, i11);
    }

    public int f(int i10, int i11) {
        return this.f1083b.getDimensionPixelSize(i10, i11);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r2.f1083b.getResourceId(r3, 0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.drawable.Drawable g(int r3) {
        /*
            r2 = this;
            android.content.res.TypedArray r0 = r2.f1083b
            boolean r0 = r0.hasValue(r3)
            if (r0 == 0) goto L_0x0018
            android.content.res.TypedArray r0 = r2.f1083b
            r1 = 0
            int r0 = r0.getResourceId(r3, r1)
            if (r0 == 0) goto L_0x0018
            android.content.Context r3 = r2.f1082a
            android.graphics.drawable.Drawable r3 = k.a.d(r3, r0)
            return r3
        L_0x0018:
            android.content.res.TypedArray r0 = r2.f1083b
            android.graphics.drawable.Drawable r3 = r0.getDrawable(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.g0.g(int):android.graphics.drawable.Drawable");
    }

    public Drawable h(int i10) {
        int resourceId;
        if (!this.f1083b.hasValue(i10) || (resourceId = this.f1083b.getResourceId(i10, 0)) == 0) {
            return null;
        }
        return f.b().d(this.f1082a, resourceId, true);
    }

    public float i(int i10, float f10) {
        return this.f1083b.getFloat(i10, f10);
    }

    public Typeface j(int i10, int i11, f.c cVar) {
        int resourceId = this.f1083b.getResourceId(i10, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f1084c == null) {
            this.f1084c = new TypedValue();
        }
        return f.h(this.f1082a, resourceId, this.f1084c, i11, cVar);
    }

    public int k(int i10, int i11) {
        return this.f1083b.getInt(i10, i11);
    }

    public int l(int i10, int i11) {
        return this.f1083b.getInteger(i10, i11);
    }

    public int m(int i10, int i11) {
        return this.f1083b.getLayoutDimension(i10, i11);
    }

    public int n(int i10, int i11) {
        return this.f1083b.getResourceId(i10, i11);
    }

    public String o(int i10) {
        return this.f1083b.getString(i10);
    }

    public CharSequence p(int i10) {
        return this.f1083b.getText(i10);
    }

    public CharSequence[] q(int i10) {
        return this.f1083b.getTextArray(i10);
    }

    public TypedArray r() {
        return this.f1083b;
    }

    public boolean s(int i10) {
        return this.f1083b.hasValue(i10);
    }

    public void w() {
        this.f1083b.recycle();
    }
}
