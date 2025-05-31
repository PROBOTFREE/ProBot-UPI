package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.d;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.g;
import java.lang.reflect.Method;

public class v extends ListPopupWindow implements u {
    private static Method J;
    private u I;

    public static class a extends r {

        /* renamed from: o  reason: collision with root package name */
        final int f1211o;

        /* renamed from: p  reason: collision with root package name */
        final int f1212p;

        /* renamed from: q  reason: collision with root package name */
        private u f1213q;

        /* renamed from: r  reason: collision with root package name */
        private MenuItem f1214r;

        public a(Context context, boolean z10) {
            super(context, z10);
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT < 17 || 1 != configuration.getLayoutDirection()) {
                this.f1211o = 22;
                this.f1212p = 21;
                return;
            }
            this.f1211o = 21;
            this.f1212p = 22;
        }

        public boolean onHoverEvent(MotionEvent motionEvent) {
            int i10;
            int pointToPosition;
            int i11;
            if (this.f1213q != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i10 = headerViewListAdapter.getHeadersCount();
                    adapter = headerViewListAdapter.getWrappedAdapter();
                } else {
                    i10 = 0;
                }
                d dVar = (d) adapter;
                g gVar = null;
                if (motionEvent.getAction() != 10 && (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i11 = pointToPosition - i10) >= 0 && i11 < dVar.getCount()) {
                    gVar = dVar.getItem(i11);
                }
                MenuItem menuItem = this.f1214r;
                if (menuItem != gVar) {
                    e b10 = dVar.b();
                    if (menuItem != null) {
                        this.f1213q.f(b10, menuItem);
                    }
                    this.f1214r = gVar;
                    if (gVar != null) {
                        this.f1213q.a(b10, gVar);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        public boolean onKeyDown(int i10, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i10 == this.f1211o) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView == null || i10 != this.f1212p) {
                return super.onKeyDown(i10, keyEvent);
            } else {
                setSelection(-1);
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
                }
                ((d) adapter).b().e(false);
                return true;
            }
        }

        public void setHoverListener(u uVar) {
            this.f1213q = uVar;
        }

        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                J = PopupWindow.class.getDeclaredMethod("setTouchModal", new Class[]{Boolean.TYPE});
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public v(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }

    public void R(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.E.setEnterTransition((Transition) obj);
        }
    }

    public void S(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.E.setExitTransition((Transition) obj);
        }
    }

    public void T(u uVar) {
        this.I = uVar;
    }

    public void U(boolean z10) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = J;
            if (method != null) {
                try {
                    method.invoke(this.E, new Object[]{Boolean.valueOf(z10)});
                } catch (Exception unused) {
                    Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
                }
            }
        } else {
            this.E.setTouchModal(z10);
        }
    }

    public void a(e eVar, MenuItem menuItem) {
        u uVar = this.I;
        if (uVar != null) {
            uVar.a(eVar, menuItem);
        }
    }

    public void f(e eVar, MenuItem menuItem) {
        u uVar = this.I;
        if (uVar != null) {
            uVar.f(eVar, menuItem);
        }
    }

    /* access modifiers changed from: package-private */
    public r s(Context context, boolean z10) {
        a aVar = new a(context, z10);
        aVar.setHoverListener(this);
        return aVar;
    }
}
