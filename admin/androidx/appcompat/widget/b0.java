package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import j.j;
import o0.a;

public class b0 {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f1045a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    static final int[] f1046b = {-16842910};

    /* renamed from: c  reason: collision with root package name */
    static final int[] f1047c = {16842908};

    /* renamed from: d  reason: collision with root package name */
    static final int[] f1048d = {16842919};

    /* renamed from: e  reason: collision with root package name */
    static final int[] f1049e = {16842912};

    /* renamed from: f  reason: collision with root package name */
    static final int[] f1050f = new int[0];

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f1051g = new int[1];

    public static void a(View view, Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(j.AppCompatTheme);
        try {
            if (!obtainStyledAttributes.hasValue(j.AppCompatTheme_windowActionBar)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int b(Context context, int i10) {
        ColorStateList e10 = e(context, i10);
        if (e10 != null && e10.isStateful()) {
            return e10.getColorForState(f1046b, e10.getDefaultColor());
        }
        TypedValue f10 = f();
        context.getTheme().resolveAttribute(16842803, f10, true);
        return d(context, i10, f10.getFloat());
    }

    public static int c(Context context, int i10) {
        int[] iArr = f1051g;
        iArr[0] = i10;
        g0 u10 = g0.u(context, (AttributeSet) null, iArr);
        try {
            return u10.b(0, 0);
        } finally {
            u10.w();
        }
    }

    static int d(Context context, int i10, float f10) {
        int c10 = c(context, i10);
        return a.h(c10, Math.round(((float) Color.alpha(c10)) * f10));
    }

    public static ColorStateList e(Context context, int i10) {
        int[] iArr = f1051g;
        iArr[0] = i10;
        g0 u10 = g0.u(context, (AttributeSet) null, iArr);
        try {
            return u10.c(0);
        } finally {
            u10.w();
        }
    }

    private static TypedValue f() {
        ThreadLocal<TypedValue> threadLocal = f1045a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }
}
