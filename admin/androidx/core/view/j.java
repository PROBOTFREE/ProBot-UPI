package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import q0.b;

public final class j {
    public static MenuItem a(MenuItem menuItem, b bVar) {
        if (menuItem instanceof b) {
            return ((b) menuItem).a(bVar);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static void b(MenuItem menuItem, char c10, int i10) {
        if (menuItem instanceof b) {
            ((b) menuItem).setAlphabeticShortcut(c10, i10);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setAlphabeticShortcut(c10, i10);
        }
    }

    public static void c(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof b) {
            ((b) menuItem).setContentDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setContentDescription(charSequence);
        }
    }

    public static void d(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof b) {
            ((b) menuItem).setIconTintList(colorStateList);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setIconTintList(colorStateList);
        }
    }

    public static void e(MenuItem menuItem, PorterDuff.Mode mode) {
        if (menuItem instanceof b) {
            ((b) menuItem).setIconTintMode(mode);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setIconTintMode(mode);
        }
    }

    public static void f(MenuItem menuItem, char c10, int i10) {
        if (menuItem instanceof b) {
            ((b) menuItem).setNumericShortcut(c10, i10);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setNumericShortcut(c10, i10);
        }
    }

    public static void g(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof b) {
            ((b) menuItem).setTooltipText(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setTooltipText(charSequence);
        }
    }
}
