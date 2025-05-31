package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.core.view.x;
import j.j;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

class n {

    /* renamed from: l  reason: collision with root package name */
    private static final RectF f1166l = new RectF();
    @SuppressLint({"BanConcurrentHashMap"})

    /* renamed from: m  reason: collision with root package name */
    private static ConcurrentHashMap<String, Method> f1167m = new ConcurrentHashMap<>();
    @SuppressLint({"BanConcurrentHashMap"})

    /* renamed from: n  reason: collision with root package name */
    private static ConcurrentHashMap<String, Field> f1168n = new ConcurrentHashMap<>();

    /* renamed from: a  reason: collision with root package name */
    private int f1169a = 0;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1170b = false;

    /* renamed from: c  reason: collision with root package name */
    private float f1171c = -1.0f;

    /* renamed from: d  reason: collision with root package name */
    private float f1172d = -1.0f;

    /* renamed from: e  reason: collision with root package name */
    private float f1173e = -1.0f;

    /* renamed from: f  reason: collision with root package name */
    private int[] f1174f = new int[0];

    /* renamed from: g  reason: collision with root package name */
    private boolean f1175g = false;

    /* renamed from: h  reason: collision with root package name */
    private TextPaint f1176h;

    /* renamed from: i  reason: collision with root package name */
    private final TextView f1177i;

    /* renamed from: j  reason: collision with root package name */
    private final Context f1178j;

    /* renamed from: k  reason: collision with root package name */
    private final c f1179k;

    private static class a extends c {
        a() {
        }

        /* access modifiers changed from: package-private */
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) n.r(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    private static class b extends a {
        b() {
        }

        /* access modifiers changed from: package-private */
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }

        /* access modifiers changed from: package-private */
        public boolean b(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }

    private static class c {
        c() {
        }

        /* access modifiers changed from: package-private */
        public void a(StaticLayout.Builder builder, TextView textView) {
        }

        /* access modifiers changed from: package-private */
        public boolean b(TextView textView) {
            return ((Boolean) n.r(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    n(TextView textView) {
        this.f1177i = textView;
        this.f1178j = textView.getContext();
        int i10 = Build.VERSION.SDK_INT;
        this.f1179k = i10 >= 29 ? new b() : i10 >= 23 ? new a() : new c();
    }

    private void A(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i10 = 0; i10 < length; i10++) {
                iArr[i10] = typedArray.getDimensionPixelSize(i10, -1);
            }
            this.f1174f = c(iArr);
            B();
        }
    }

    private boolean B() {
        int[] iArr = this.f1174f;
        int length = iArr.length;
        boolean z10 = length > 0;
        this.f1175g = z10;
        if (z10) {
            this.f1169a = 1;
            this.f1172d = (float) iArr[0];
            this.f1173e = (float) iArr[length - 1];
            this.f1171c = -1.0f;
        }
        return z10;
    }

    private boolean C(int i10, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f1177i.getText();
        TransformationMethod transformationMethod = this.f1177i.getTransformationMethod();
        if (!(transformationMethod == null || (transformation = transformationMethod.getTransformation(text, this.f1177i)) == null)) {
            text = transformation;
        }
        int maxLines = Build.VERSION.SDK_INT >= 16 ? this.f1177i.getMaxLines() : -1;
        q(i10);
        StaticLayout e10 = e(text, (Layout.Alignment) r(this.f1177i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines);
        return (maxLines == -1 || (e10.getLineCount() <= maxLines && e10.getLineEnd(e10.getLineCount() - 1) == text.length())) && ((float) e10.getHeight()) <= rectF.bottom;
    }

    private boolean D() {
        return !(this.f1177i instanceof AppCompatEditText);
    }

    private void E(float f10, float f11, float f12) {
        if (f10 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f10 + "px) is less or equal to (0px)");
        } else if (f11 <= f10) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f11 + "px) is less or equal to minimum auto-size text size (" + f10 + "px)");
        } else if (f12 > 0.0f) {
            this.f1169a = 1;
            this.f1172d = f10;
            this.f1173e = f11;
            this.f1171c = f12;
            this.f1175g = false;
        } else {
            throw new IllegalArgumentException("The auto-size step granularity (" + f12 + "px) is less or equal to (0px)");
        }
    }

    private static <T> T a(Object obj, String str, T t10) {
        try {
            Field o10 = o(str);
            return o10 == null ? t10 : o10.get(obj);
        } catch (IllegalAccessException e10) {
            Log.w("ACTVAutoSizeHelper", "Failed to access TextView#" + str + " member", e10);
            return t10;
        }
    }

    private int[] c(int[] iArr) {
        if (r0 == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i10 : iArr) {
            if (i10 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i10)) < 0) {
                arrayList.add(Integer.valueOf(i10));
            }
        }
        if (r0 == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i11 = 0; i11 < size; i11++) {
            iArr2[i11] = ((Integer) arrayList.get(i11)).intValue();
        }
        return iArr2;
    }

    private void d() {
        this.f1169a = 0;
        this.f1172d = -1.0f;
        this.f1173e = -1.0f;
        this.f1171c = -1.0f;
        this.f1174f = new int[0];
        this.f1170b = false;
    }

    private StaticLayout f(CharSequence charSequence, Layout.Alignment alignment, int i10, int i11) {
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.f1176h, i10);
        StaticLayout.Builder hyphenationFrequency = obtain.setAlignment(alignment).setLineSpacing(this.f1177i.getLineSpacingExtra(), this.f1177i.getLineSpacingMultiplier()).setIncludePad(this.f1177i.getIncludeFontPadding()).setBreakStrategy(this.f1177i.getBreakStrategy()).setHyphenationFrequency(this.f1177i.getHyphenationFrequency());
        if (i11 == -1) {
            i11 = Integer.MAX_VALUE;
        }
        hyphenationFrequency.setMaxLines(i11);
        try {
            this.f1179k.a(obtain, this.f1177i);
        } catch (ClassCastException unused) {
            Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
        }
        return obtain.build();
    }

    private StaticLayout g(CharSequence charSequence, Layout.Alignment alignment, int i10) {
        return new StaticLayout(charSequence, this.f1176h, i10, alignment, ((Float) a(this.f1177i, "mSpacingMult", Float.valueOf(1.0f))).floatValue(), ((Float) a(this.f1177i, "mSpacingAdd", Float.valueOf(0.0f))).floatValue(), ((Boolean) a(this.f1177i, "mIncludePad", Boolean.TRUE)).booleanValue());
    }

    private StaticLayout h(CharSequence charSequence, Layout.Alignment alignment, int i10) {
        return new StaticLayout(charSequence, this.f1176h, i10, alignment, this.f1177i.getLineSpacingMultiplier(), this.f1177i.getLineSpacingExtra(), this.f1177i.getIncludeFontPadding());
    }

    private int i(RectF rectF) {
        int length = this.f1174f.length;
        if (length != 0) {
            int i10 = 0;
            int i11 = 1;
            int i12 = length - 1;
            while (true) {
                int i13 = i11;
                int i14 = i10;
                i10 = i13;
                while (i10 <= i12) {
                    int i15 = (i10 + i12) / 2;
                    if (C(this.f1174f[i15], rectF)) {
                        i11 = i15 + 1;
                    } else {
                        i14 = i15 - 1;
                        i12 = i14;
                    }
                }
                return this.f1174f[i14];
            }
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    private static Field o(String str) {
        try {
            Field field = f1168n.get(str);
            if (field == null && (field = TextView.class.getDeclaredField(str)) != null) {
                field.setAccessible(true);
                f1168n.put(str, field);
            }
            return field;
        } catch (NoSuchFieldException e10) {
            Log.w("ACTVAutoSizeHelper", "Failed to access TextView#" + str + " member", e10);
            return null;
        }
    }

    private static Method p(String str) {
        try {
            Method method = f1167m.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                method.setAccessible(true);
                f1167m.put(str, method);
            }
            return method;
        } catch (Exception e10) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e10);
            return null;
        }
    }

    static <T> T r(Object obj, String str, T t10) {
        try {
            return p(str).invoke(obj, new Object[0]);
        } catch (Exception e10) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e10);
            return t10;
        }
    }

    private void x(float f10) {
        if (f10 != this.f1177i.getPaint().getTextSize()) {
            this.f1177i.getPaint().setTextSize(f10);
            boolean isInLayout = Build.VERSION.SDK_INT >= 18 ? this.f1177i.isInLayout() : false;
            if (this.f1177i.getLayout() != null) {
                this.f1170b = false;
                try {
                    Method p10 = p("nullLayouts");
                    if (p10 != null) {
                        p10.invoke(this.f1177i, new Object[0]);
                    }
                } catch (Exception e10) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e10);
                }
                if (!isInLayout) {
                    this.f1177i.requestLayout();
                } else {
                    this.f1177i.forceLayout();
                }
                this.f1177i.invalidate();
            }
        }
    }

    private boolean z() {
        if (!D() || this.f1169a != 1) {
            this.f1170b = false;
        } else {
            if (!this.f1175g || this.f1174f.length == 0) {
                int floor = ((int) Math.floor((double) ((this.f1173e - this.f1172d) / this.f1171c))) + 1;
                int[] iArr = new int[floor];
                for (int i10 = 0; i10 < floor; i10++) {
                    iArr[i10] = Math.round(this.f1172d + (((float) i10) * this.f1171c));
                }
                this.f1174f = c(iArr);
            }
            this.f1170b = true;
        }
        return this.f1170b;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (s()) {
            if (this.f1170b) {
                if (this.f1177i.getMeasuredHeight() > 0 && this.f1177i.getMeasuredWidth() > 0) {
                    int measuredWidth = this.f1179k.b(this.f1177i) ? 1048576 : (this.f1177i.getMeasuredWidth() - this.f1177i.getTotalPaddingLeft()) - this.f1177i.getTotalPaddingRight();
                    int height = (this.f1177i.getHeight() - this.f1177i.getCompoundPaddingBottom()) - this.f1177i.getCompoundPaddingTop();
                    if (measuredWidth > 0 && height > 0) {
                        RectF rectF = f1166l;
                        synchronized (rectF) {
                            rectF.setEmpty();
                            rectF.right = (float) measuredWidth;
                            rectF.bottom = (float) height;
                            float i10 = (float) i(rectF);
                            if (i10 != this.f1177i.getTextSize()) {
                                y(0, i10);
                            }
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.f1170b = true;
        }
    }

    /* access modifiers changed from: package-private */
    public StaticLayout e(CharSequence charSequence, Layout.Alignment alignment, int i10, int i11) {
        int i12 = Build.VERSION.SDK_INT;
        return i12 >= 23 ? f(charSequence, alignment, i10, i11) : i12 >= 16 ? h(charSequence, alignment, i10) : g(charSequence, alignment, i10);
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return Math.round(this.f1173e);
    }

    /* access modifiers changed from: package-private */
    public int k() {
        return Math.round(this.f1172d);
    }

    /* access modifiers changed from: package-private */
    public int l() {
        return Math.round(this.f1171c);
    }

    /* access modifiers changed from: package-private */
    public int[] m() {
        return this.f1174f;
    }

    /* access modifiers changed from: package-private */
    public int n() {
        return this.f1169a;
    }

    /* access modifiers changed from: package-private */
    public void q(int i10) {
        TextPaint textPaint = this.f1176h;
        if (textPaint == null) {
            this.f1176h = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f1176h.set(this.f1177i.getPaint());
        this.f1176h.setTextSize((float) i10);
    }

    /* access modifiers changed from: package-private */
    public boolean s() {
        return D() && this.f1169a != 0;
    }

    /* access modifiers changed from: package-private */
    public void t(AttributeSet attributeSet, int i10) {
        int resourceId;
        Context context = this.f1178j;
        int[] iArr = j.AppCompatTextView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i10, 0);
        TextView textView = this.f1177i;
        x.p0(textView, textView.getContext(), iArr, attributeSet, obtainStyledAttributes, i10, 0);
        int i11 = j.AppCompatTextView_autoSizeTextType;
        if (obtainStyledAttributes.hasValue(i11)) {
            this.f1169a = obtainStyledAttributes.getInt(i11, 0);
        }
        int i12 = j.AppCompatTextView_autoSizeStepGranularity;
        float dimension = obtainStyledAttributes.hasValue(i12) ? obtainStyledAttributes.getDimension(i12, -1.0f) : -1.0f;
        int i13 = j.AppCompatTextView_autoSizeMinTextSize;
        float dimension2 = obtainStyledAttributes.hasValue(i13) ? obtainStyledAttributes.getDimension(i13, -1.0f) : -1.0f;
        int i14 = j.AppCompatTextView_autoSizeMaxTextSize;
        float dimension3 = obtainStyledAttributes.hasValue(i14) ? obtainStyledAttributes.getDimension(i14, -1.0f) : -1.0f;
        int i15 = j.AppCompatTextView_autoSizePresetSizes;
        if (obtainStyledAttributes.hasValue(i15) && (resourceId = obtainStyledAttributes.getResourceId(i15, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            A(obtainTypedArray);
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (!D()) {
            this.f1169a = 0;
        } else if (this.f1169a == 1) {
            if (!this.f1175g) {
                DisplayMetrics displayMetrics = this.f1178j.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                E(dimension2, dimension3, dimension);
            }
            z();
        }
    }

    /* access modifiers changed from: package-private */
    public void u(int i10, int i11, int i12, int i13) {
        if (D()) {
            DisplayMetrics displayMetrics = this.f1178j.getResources().getDisplayMetrics();
            E(TypedValue.applyDimension(i13, (float) i10, displayMetrics), TypedValue.applyDimension(i13, (float) i11, displayMetrics), TypedValue.applyDimension(i13, (float) i12, displayMetrics));
            if (z()) {
                b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void v(int[] iArr, int i10) {
        if (D()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i10 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f1178j.getResources().getDisplayMetrics();
                    for (int i11 = 0; i11 < length; i11++) {
                        iArr2[i11] = Math.round(TypedValue.applyDimension(i10, (float) iArr[i11], displayMetrics));
                    }
                }
                this.f1174f = c(iArr2);
                if (!B()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f1175g = false;
            }
            if (z()) {
                b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void w(int i10) {
        if (!D()) {
            return;
        }
        if (i10 == 0) {
            d();
        } else if (i10 == 1) {
            DisplayMetrics displayMetrics = this.f1178j.getResources().getDisplayMetrics();
            E(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (z()) {
                b();
            }
        } else {
            throw new IllegalArgumentException("Unknown auto-size text type: " + i10);
        }
    }

    /* access modifiers changed from: package-private */
    public void y(int i10, float f10) {
        Context context = this.f1178j;
        x(TypedValue.applyDimension(i10, f10, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }
}
