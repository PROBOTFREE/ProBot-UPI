package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.g0;
import androidx.core.view.x;
import j.a;
import j.f;
import j.g;
import j.j;

public class ListMenuItemView extends LinearLayout implements k.a, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: a  reason: collision with root package name */
    private g f484a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f485b;

    /* renamed from: c  reason: collision with root package name */
    private RadioButton f486c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f487d;

    /* renamed from: e  reason: collision with root package name */
    private CheckBox f488e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f489f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f490g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f491h;

    /* renamed from: i  reason: collision with root package name */
    private LinearLayout f492i;

    /* renamed from: j  reason: collision with root package name */
    private Drawable f493j;

    /* renamed from: k  reason: collision with root package name */
    private int f494k;

    /* renamed from: l  reason: collision with root package name */
    private Context f495l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f496m;

    /* renamed from: n  reason: collision with root package name */
    private Drawable f497n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f498o;

    /* renamed from: p  reason: collision with root package name */
    private LayoutInflater f499p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f500q;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.listMenuViewStyle);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet);
        g0 v10 = g0.v(getContext(), attributeSet, j.MenuView, i10, 0);
        this.f493j = v10.g(j.MenuView_android_itemBackground);
        this.f494k = v10.n(j.MenuView_android_itemTextAppearance, -1);
        this.f496m = v10.a(j.MenuView_preserveIconSpacing, false);
        this.f495l = context;
        this.f497n = v10.g(j.MenuView_subMenuArrow);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes((AttributeSet) null, new int[]{16843049}, a.dropDownListViewStyle, 0);
        this.f498o = obtainStyledAttributes.hasValue(0);
        v10.w();
        obtainStyledAttributes.recycle();
    }

    private void a(View view) {
        b(view, -1);
    }

    private void b(View view, int i10) {
        LinearLayout linearLayout = this.f492i;
        if (linearLayout != null) {
            linearLayout.addView(view, i10);
        } else {
            addView(view, i10);
        }
    }

    private void c() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(g.abc_list_menu_item_checkbox, this, false);
        this.f488e = checkBox;
        a(checkBox);
    }

    private void e() {
        ImageView imageView = (ImageView) getInflater().inflate(g.abc_list_menu_item_icon, this, false);
        this.f485b = imageView;
        b(imageView, 0);
    }

    private void f() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(g.abc_list_menu_item_radio, this, false);
        this.f486c = radioButton;
        a(radioButton);
    }

    private LayoutInflater getInflater() {
        if (this.f499p == null) {
            this.f499p = LayoutInflater.from(getContext());
        }
        return this.f499p;
    }

    private void setSubMenuArrowVisible(boolean z10) {
        ImageView imageView = this.f490g;
        if (imageView != null) {
            imageView.setVisibility(z10 ? 0 : 8);
        }
    }

    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f491h;
        if (imageView != null && imageView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f491h.getLayoutParams();
            rect.top += this.f491h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
        }
    }

    public boolean d() {
        return false;
    }

    public void g(g gVar, int i10) {
        this.f484a = gVar;
        setVisibility(gVar.isVisible() ? 0 : 8);
        setTitle(gVar.i(this));
        setCheckable(gVar.isCheckable());
        h(gVar.A(), gVar.g());
        setIcon(gVar.getIcon());
        setEnabled(gVar.isEnabled());
        setSubMenuArrowVisible(gVar.hasSubMenu());
        setContentDescription(gVar.getContentDescription());
    }

    public g getItemData() {
        return this.f484a;
    }

    public void h(boolean z10, char c10) {
        int i10 = (!z10 || !this.f484a.A()) ? 8 : 0;
        if (i10 == 0) {
            this.f489f.setText(this.f484a.h());
        }
        if (this.f489f.getVisibility() != i10) {
            this.f489f.setVisibility(i10);
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        x.u0(this, this.f493j);
        TextView textView = (TextView) findViewById(f.title);
        this.f487d = textView;
        int i10 = this.f494k;
        if (i10 != -1) {
            textView.setTextAppearance(this.f495l, i10);
        }
        this.f489f = (TextView) findViewById(f.shortcut);
        ImageView imageView = (ImageView) findViewById(f.submenuarrow);
        this.f490g = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f497n);
        }
        this.f491h = (ImageView) findViewById(f.group_divider);
        this.f492i = (LinearLayout) findViewById(f.content);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        if (this.f485b != null && this.f496m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f485b.getLayoutParams();
            int i12 = layoutParams.height;
            if (i12 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i12;
            }
        }
        super.onMeasure(i10, i11);
    }

    public void setCheckable(boolean z10) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (z10 || this.f486c != null || this.f488e != null) {
            if (this.f484a.m()) {
                if (this.f486c == null) {
                    f();
                }
                compoundButton2 = this.f486c;
                compoundButton = this.f488e;
            } else {
                if (this.f488e == null) {
                    c();
                }
                compoundButton2 = this.f488e;
                compoundButton = this.f486c;
            }
            if (z10) {
                compoundButton2.setChecked(this.f484a.isChecked());
                if (compoundButton2.getVisibility() != 0) {
                    compoundButton2.setVisibility(0);
                }
                if (compoundButton != null && compoundButton.getVisibility() != 8) {
                    compoundButton.setVisibility(8);
                    return;
                }
                return;
            }
            CheckBox checkBox = this.f488e;
            if (checkBox != null) {
                checkBox.setVisibility(8);
            }
            RadioButton radioButton = this.f486c;
            if (radioButton != null) {
                radioButton.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z10) {
        CompoundButton compoundButton;
        if (this.f484a.m()) {
            if (this.f486c == null) {
                f();
            }
            compoundButton = this.f486c;
        } else {
            if (this.f488e == null) {
                c();
            }
            compoundButton = this.f488e;
        }
        compoundButton.setChecked(z10);
    }

    public void setForceShowIcon(boolean z10) {
        this.f500q = z10;
        this.f496m = z10;
    }

    public void setGroupDividerEnabled(boolean z10) {
        ImageView imageView = this.f491h;
        if (imageView != null) {
            imageView.setVisibility((this.f498o || !z10) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z10 = this.f484a.z() || this.f500q;
        if (z10 || this.f496m) {
            ImageView imageView = this.f485b;
            if (imageView != null || drawable != null || this.f496m) {
                if (imageView == null) {
                    e();
                }
                if (drawable != null || this.f496m) {
                    ImageView imageView2 = this.f485b;
                    if (!z10) {
                        drawable = null;
                    }
                    imageView2.setImageDrawable(drawable);
                    if (this.f485b.getVisibility() != 0) {
                        this.f485b.setVisibility(0);
                        return;
                    }
                    return;
                }
                this.f485b.setVisibility(8);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        TextView textView;
        int i10;
        if (charSequence != null) {
            this.f487d.setText(charSequence);
            if (this.f487d.getVisibility() != 0) {
                textView = this.f487d;
                i10 = 0;
            } else {
                return;
            }
        } else {
            i10 = 8;
            if (this.f487d.getVisibility() != 8) {
                textView = this.f487d;
            } else {
                return;
            }
        }
        textView.setVisibility(i10);
    }
}
