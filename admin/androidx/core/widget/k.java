package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.text.Editable;
import android.text.Spanned;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import v0.d;
import w0.h;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    private static Field f2489a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f2490b;

    /* renamed from: c  reason: collision with root package name */
    private static Field f2491c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f2492d;

    private static class a implements ActionMode.Callback {

        /* renamed from: a  reason: collision with root package name */
        private final ActionMode.Callback f2493a;

        /* renamed from: b  reason: collision with root package name */
        private final TextView f2494b;

        /* renamed from: c  reason: collision with root package name */
        private Class<?> f2495c;

        /* renamed from: d  reason: collision with root package name */
        private Method f2496d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f2497e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f2498f = false;

        a(ActionMode.Callback callback, TextView textView) {
            this.f2493a = callback;
            this.f2494b = textView;
        }

        private Intent a() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }

        private Intent b(ResolveInfo resolveInfo, TextView textView) {
            Intent putExtra = a().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !d(textView));
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            return putExtra.setClassName(activityInfo.packageName, activityInfo.name);
        }

        private List<ResolveInfo> c(Context context, PackageManager packageManager) {
            ArrayList arrayList = new ArrayList();
            if (!(context instanceof Activity)) {
                return arrayList;
            }
            for (ResolveInfo next : packageManager.queryIntentActivities(a(), 0)) {
                if (e(next, context)) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        }

        private boolean d(TextView textView) {
            return (textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled();
        }

        private boolean e(ResolveInfo resolveInfo, Context context) {
            if (context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                return true;
            }
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (!activityInfo.exported) {
                return false;
            }
            String str = activityInfo.permission;
            return str == null || context.checkSelfPermission(str) == 0;
        }

        private void f(Menu menu) {
            Method method;
            Context context = this.f2494b.getContext();
            PackageManager packageManager = context.getPackageManager();
            if (!this.f2498f) {
                this.f2498f = true;
                try {
                    Class<?> cls = Class.forName("com.android.internal.view.menu.MenuBuilder");
                    this.f2495c = cls;
                    this.f2496d = cls.getDeclaredMethod("removeItemAt", new Class[]{Integer.TYPE});
                    this.f2497e = true;
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    this.f2495c = null;
                    this.f2496d = null;
                    this.f2497e = false;
                }
            }
            try {
                if (!this.f2497e || !this.f2495c.isInstance(menu)) {
                    method = menu.getClass().getDeclaredMethod("removeItemAt", new Class[]{Integer.TYPE});
                } else {
                    method = this.f2496d;
                }
                for (int size = menu.size() - 1; size >= 0; size--) {
                    MenuItem item = menu.getItem(size);
                    if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                        method.invoke(menu, new Object[]{Integer.valueOf(size)});
                    }
                }
                List<ResolveInfo> c10 = c(context, packageManager);
                for (int i10 = 0; i10 < c10.size(); i10++) {
                    ResolveInfo resolveInfo = c10.get(i10);
                    menu.add(0, 0, i10 + 100, resolveInfo.loadLabel(packageManager)).setIntent(b(resolveInfo, this.f2494b)).setShowAsAction(1);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }

        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f2493a.onActionItemClicked(actionMode, menuItem);
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f2493a.onCreateActionMode(actionMode, menu);
        }

        public void onDestroyActionMode(ActionMode actionMode) {
            this.f2493a.onDestroyActionMode(actionMode);
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            f(menu);
            return this.f2493a.onPrepareActionMode(actionMode, menu);
        }
    }

    public static Drawable[] a(TextView textView) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 18) {
            return textView.getCompoundDrawablesRelative();
        }
        if (i10 < 17) {
            return textView.getCompoundDrawables();
        }
        boolean z10 = true;
        if (textView.getLayoutDirection() != 1) {
            z10 = false;
        }
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        if (z10) {
            Drawable drawable = compoundDrawables[2];
            Drawable drawable2 = compoundDrawables[0];
            compoundDrawables[0] = drawable;
            compoundDrawables[2] = drawable2;
        }
        return compoundDrawables;
    }

    public static int b(TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }

    public static int c(TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }

    public static int d(TextView textView) {
        if (Build.VERSION.SDK_INT >= 16) {
            return textView.getMaxLines();
        }
        if (!f2492d) {
            f2491c = h("mMaxMode");
            f2492d = true;
        }
        Field field = f2491c;
        if (field == null || i(field, textView) != 1) {
            return -1;
        }
        if (!f2490b) {
            f2489a = h("mMaximum");
            f2490b = true;
        }
        Field field2 = f2489a;
        if (field2 != null) {
            return i(field2, textView);
        }
        return -1;
    }

    private static int e(TextDirectionHeuristic textDirectionHeuristic) {
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL || textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 1;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
            return 2;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
            return 3;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
            return 4;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
            return 5;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 6;
        }
        return textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL ? 7 : 1;
    }

    private static TextDirectionHeuristic f(TextView textView) {
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            return TextDirectionHeuristics.LTR;
        }
        boolean z10 = false;
        if (Build.VERSION.SDK_INT < 28 || (textView.getInputType() & 15) != 3) {
            if (textView.getLayoutDirection() == 1) {
                z10 = true;
            }
            switch (textView.getTextDirection()) {
                case 2:
                    return TextDirectionHeuristics.ANYRTL_LTR;
                case 3:
                    return TextDirectionHeuristics.LTR;
                case 4:
                    return TextDirectionHeuristics.RTL;
                case 5:
                    return TextDirectionHeuristics.LOCALE;
                case 6:
                    return TextDirectionHeuristics.FIRSTSTRONG_LTR;
                case 7:
                    return TextDirectionHeuristics.FIRSTSTRONG_RTL;
                default:
                    return z10 ? TextDirectionHeuristics.FIRSTSTRONG_RTL : TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }
        } else {
            byte directionality = Character.getDirectionality(DecimalFormatSymbols.getInstance(textView.getTextLocale()).getDigitStrings()[0].codePointAt(0));
            return (directionality == 1 || directionality == 2) ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
        }
    }

    public static d.a g(TextView textView) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            return new d.a(textView.getTextMetricsParams());
        }
        d.a.C0234a aVar = new d.a.C0234a(new TextPaint(textView.getPaint()));
        if (i10 >= 23) {
            aVar.b(textView.getBreakStrategy());
            aVar.c(textView.getHyphenationFrequency());
        }
        if (i10 >= 18) {
            aVar.d(f(textView));
        }
        return aVar.a();
    }

    private static Field h(String str) {
        Field field = null;
        try {
            field = TextView.class.getDeclaredField(str);
            field.setAccessible(true);
            return field;
        } catch (NoSuchFieldException unused) {
            Log.e("TextViewCompat", "Could not retrieve " + str + " field.");
            return field;
        }
    }

    private static int i(Field field, TextView textView) {
        try {
            return field.getInt(textView);
        } catch (IllegalAccessException unused) {
            Log.d("TextViewCompat", "Could not retrieve value of " + field.getName() + " field.");
            return -1;
        }
    }

    public static void j(TextView textView, ColorStateList colorStateList) {
        h.e(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            textView.setCompoundDrawableTintList(colorStateList);
        } else if (textView instanceof n) {
            ((n) textView).setSupportCompoundDrawablesTintList(colorStateList);
        }
    }

    public static void k(TextView textView, PorterDuff.Mode mode) {
        h.e(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            textView.setCompoundDrawableTintMode(mode);
        } else if (textView instanceof n) {
            ((n) textView).setSupportCompoundDrawablesTintMode(mode);
        }
    }

    public static void l(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 18) {
            textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        } else if (i10 >= 17) {
            boolean z10 = true;
            if (textView.getLayoutDirection() != 1) {
                z10 = false;
            }
            Drawable drawable5 = z10 ? drawable3 : drawable;
            if (!z10) {
                drawable = drawable3;
            }
            textView.setCompoundDrawables(drawable5, drawable2, drawable, drawable4);
        } else {
            textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        }
    }

    public static void m(TextView textView, int i10) {
        h.c(i10);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 28) {
            textView.setFirstBaselineToTopHeight(i10);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i12 = (i11 < 16 || textView.getIncludeFontPadding()) ? fontMetricsInt.top : fontMetricsInt.ascent;
        if (i10 > Math.abs(i12)) {
            textView.setPadding(textView.getPaddingLeft(), i10 + i12, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void n(TextView textView, int i10) {
        h.c(i10);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i11 = (Build.VERSION.SDK_INT < 16 || textView.getIncludeFontPadding()) ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i10 > Math.abs(i11)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i10 - i11);
        }
    }

    public static void o(TextView textView, int i10) {
        h.c(i10);
        int fontMetricsInt = textView.getPaint().getFontMetricsInt((Paint.FontMetricsInt) null);
        if (i10 != fontMetricsInt) {
            textView.setLineSpacing((float) (i10 - fontMetricsInt), 1.0f);
        }
    }

    public static void p(TextView textView, d dVar) {
        Spanned spanned;
        if (Build.VERSION.SDK_INT >= 29) {
            spanned = dVar.b();
        } else {
            boolean a10 = g(textView).a(dVar.a());
            spanned = dVar;
            if (!a10) {
                throw new IllegalArgumentException("Given text can not be applied to TextView.");
            }
        }
        textView.setText(spanned);
    }

    public static void q(TextView textView, int i10) {
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i10);
        } else {
            textView.setTextAppearance(textView.getContext(), i10);
        }
    }

    public static void r(TextView textView, d.a aVar) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 18) {
            textView.setTextDirection(e(aVar.d()));
        }
        if (i10 < 23) {
            float textScaleX = aVar.e().getTextScaleX();
            textView.getPaint().set(aVar.e());
            if (textScaleX == textView.getTextScaleX()) {
                textView.setTextScaleX((textScaleX / 2.0f) + 1.0f);
            }
            textView.setTextScaleX(textScaleX);
            return;
        }
        textView.getPaint().set(aVar.e());
        textView.setBreakStrategy(aVar.b());
        textView.setHyphenationFrequency(aVar.c());
    }

    public static ActionMode.Callback s(TextView textView, ActionMode.Callback callback) {
        int i10 = Build.VERSION.SDK_INT;
        return (i10 < 26 || i10 > 27 || (callback instanceof a) || callback == null) ? callback : new a(callback, textView);
    }
}
