package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.widget.w;
import j.c;
import j.d;
import j.e;

public final class f {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final PorterDuff.Mode f1072b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c  reason: collision with root package name */
    private static f f1073c;

    /* renamed from: a  reason: collision with root package name */
    private w f1074a;

    class a implements w.f {

        /* renamed from: a  reason: collision with root package name */
        private final int[] f1075a = {e.abc_textfield_search_default_mtrl_alpha, e.abc_textfield_default_mtrl_alpha, e.abc_ab_share_pack_mtrl_alpha};

        /* renamed from: b  reason: collision with root package name */
        private final int[] f1076b = {e.abc_ic_commit_search_api_mtrl_alpha, e.abc_seekbar_tick_mark_material, e.abc_ic_menu_share_mtrl_alpha, e.abc_ic_menu_copy_mtrl_am_alpha, e.abc_ic_menu_cut_mtrl_alpha, e.abc_ic_menu_selectall_mtrl_alpha, e.abc_ic_menu_paste_mtrl_am_alpha};

        /* renamed from: c  reason: collision with root package name */
        private final int[] f1077c = {e.abc_textfield_activated_mtrl_alpha, e.abc_textfield_search_activated_mtrl_alpha, e.abc_cab_background_top_mtrl_alpha, e.abc_text_cursor_material, e.abc_text_select_handle_left_mtrl, e.abc_text_select_handle_middle_mtrl, e.abc_text_select_handle_right_mtrl};

        /* renamed from: d  reason: collision with root package name */
        private final int[] f1078d = {e.abc_popup_background_mtrl_mult, e.abc_cab_background_internal_bg, e.abc_menu_hardkey_panel_mtrl_mult};

        /* renamed from: e  reason: collision with root package name */
        private final int[] f1079e = {e.abc_tab_indicator_material, e.abc_textfield_search_material};

        /* renamed from: f  reason: collision with root package name */
        private final int[] f1080f = {e.abc_btn_check_material, e.abc_btn_radio_material, e.abc_btn_check_material_anim, e.abc_btn_radio_material_anim};

        a() {
        }

        private boolean f(int[] iArr, int i10) {
            for (int i11 : iArr) {
                if (i11 == i10) {
                    return true;
                }
            }
            return false;
        }

        private ColorStateList g(Context context) {
            return h(context, 0);
        }

        private ColorStateList h(Context context, int i10) {
            int c10 = b0.c(context, j.a.colorControlHighlight);
            int b10 = b0.b(context, j.a.colorButtonNormal);
            return new ColorStateList(new int[][]{b0.f1046b, b0.f1048d, b0.f1047c, b0.f1050f}, new int[]{b10, o0.a.e(c10, i10), o0.a.e(c10, i10), i10});
        }

        private ColorStateList i(Context context) {
            return h(context, b0.c(context, j.a.colorAccent));
        }

        private ColorStateList j(Context context) {
            return h(context, b0.c(context, j.a.colorButtonNormal));
        }

        private ColorStateList k(Context context) {
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            int i10 = j.a.colorSwitchThumbNormal;
            ColorStateList e10 = b0.e(context, i10);
            if (e10 == null || !e10.isStateful()) {
                iArr[0] = b0.f1046b;
                iArr2[0] = b0.b(context, i10);
                iArr[1] = b0.f1049e;
                iArr2[1] = b0.c(context, j.a.colorControlActivated);
                iArr[2] = b0.f1050f;
                iArr2[2] = b0.c(context, i10);
            } else {
                iArr[0] = b0.f1046b;
                iArr2[0] = e10.getColorForState(iArr[0], 0);
                iArr[1] = b0.f1049e;
                iArr2[1] = b0.c(context, j.a.colorControlActivated);
                iArr[2] = b0.f1050f;
                iArr2[2] = e10.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        private LayerDrawable l(w wVar, Context context, int i10) {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i10);
            Drawable j10 = wVar.j(context, e.abc_star_black_48dp);
            Drawable j11 = wVar.j(context, e.abc_star_half_black_48dp);
            if ((j10 instanceof BitmapDrawable) && j10.getIntrinsicWidth() == dimensionPixelSize && j10.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable2 = (BitmapDrawable) j10;
                bitmapDrawable = new BitmapDrawable(bitmapDrawable2.getBitmap());
            } else {
                Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                j10.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                j10.draw(canvas);
                bitmapDrawable2 = new BitmapDrawable(createBitmap);
                bitmapDrawable = new BitmapDrawable(createBitmap);
            }
            bitmapDrawable.setTileModeX(Shader.TileMode.REPEAT);
            if ((j11 instanceof BitmapDrawable) && j11.getIntrinsicWidth() == dimensionPixelSize && j11.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) j11;
            } else {
                Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap2);
                j11.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                j11.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(createBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable2, bitmapDrawable3, bitmapDrawable});
            layerDrawable.setId(0, 16908288);
            layerDrawable.setId(1, 16908303);
            layerDrawable.setId(2, 16908301);
            return layerDrawable;
        }

        private void m(Drawable drawable, int i10, PorterDuff.Mode mode) {
            if (q.a(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = f.f1072b;
            }
            drawable.setColorFilter(f.e(i10, mode));
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0046  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0061 A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
            /*
                r6 = this;
                android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.f.f1072b
                int[] r1 = r6.f1075a
                boolean r1 = r6.f(r1, r8)
                r2 = 16842801(0x1010031, float:2.3693695E-38)
                r3 = -1
                r4 = 0
                r5 = 1
                if (r1 == 0) goto L_0x0017
                int r2 = j.a.colorControlNormal
            L_0x0014:
                r8 = r3
            L_0x0015:
                r1 = r5
                goto L_0x0044
            L_0x0017:
                int[] r1 = r6.f1077c
                boolean r1 = r6.f(r1, r8)
                if (r1 == 0) goto L_0x0022
                int r2 = j.a.colorControlActivated
                goto L_0x0014
            L_0x0022:
                int[] r1 = r6.f1078d
                boolean r1 = r6.f(r1, r8)
                if (r1 == 0) goto L_0x002d
                android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
                goto L_0x0014
            L_0x002d:
                int r1 = j.e.abc_list_divider_mtrl_alpha
                if (r8 != r1) goto L_0x003c
                r2 = 16842800(0x1010030, float:2.3693693E-38)
                r8 = 1109603123(0x42233333, float:40.8)
                int r8 = java.lang.Math.round(r8)
                goto L_0x0015
            L_0x003c:
                int r1 = j.e.abc_dialog_material_background
                if (r8 != r1) goto L_0x0041
                goto L_0x0014
            L_0x0041:
                r8 = r3
                r1 = r4
                r2 = r1
            L_0x0044:
                if (r1 == 0) goto L_0x0061
                boolean r1 = androidx.appcompat.widget.q.a(r9)
                if (r1 == 0) goto L_0x0050
                android.graphics.drawable.Drawable r9 = r9.mutate()
            L_0x0050:
                int r7 = androidx.appcompat.widget.b0.c(r7, r2)
                android.graphics.PorterDuffColorFilter r7 = androidx.appcompat.widget.f.e(r7, r0)
                r9.setColorFilter(r7)
                if (r8 == r3) goto L_0x0060
                r9.setAlpha(r8)
            L_0x0060:
                return r5
            L_0x0061:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.f.a.a(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
        }

        public PorterDuff.Mode b(int i10) {
            if (i10 == e.abc_switch_thumb_material) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }

        public Drawable c(w wVar, Context context, int i10) {
            int i11;
            if (i10 == e.abc_cab_background_top_material) {
                return new LayerDrawable(new Drawable[]{wVar.j(context, e.abc_cab_background_internal_bg), wVar.j(context, e.abc_cab_background_top_mtrl_alpha)});
            }
            if (i10 == e.abc_ratingbar_material) {
                i11 = d.abc_star_big;
            } else if (i10 == e.abc_ratingbar_indicator_material) {
                i11 = d.abc_star_medium;
            } else if (i10 != e.abc_ratingbar_small_material) {
                return null;
            } else {
                i11 = d.abc_star_small;
            }
            return l(wVar, context, i11);
        }

        public ColorStateList d(Context context, int i10) {
            if (i10 == e.abc_edit_text_material) {
                return k.a.c(context, c.abc_tint_edittext);
            }
            if (i10 == e.abc_switch_track_mtrl_alpha) {
                return k.a.c(context, c.abc_tint_switch_track);
            }
            if (i10 == e.abc_switch_thumb_material) {
                return k(context);
            }
            if (i10 == e.abc_btn_default_mtrl_shape) {
                return j(context);
            }
            if (i10 == e.abc_btn_borderless_material) {
                return g(context);
            }
            if (i10 == e.abc_btn_colored_material) {
                return i(context);
            }
            if (i10 == e.abc_spinner_mtrl_am_alpha || i10 == e.abc_spinner_textfield_background_material) {
                return k.a.c(context, c.abc_tint_spinner);
            }
            if (f(this.f1076b, i10)) {
                return b0.e(context, j.a.colorControlNormal);
            }
            if (f(this.f1079e, i10)) {
                return k.a.c(context, c.abc_tint_default);
            }
            if (f(this.f1080f, i10)) {
                return k.a.c(context, c.abc_tint_btn_checkable);
            }
            if (i10 == e.abc_seekbar_thumb_material) {
                return k.a.c(context, c.abc_tint_seek_thumb);
            }
            return null;
        }

        public boolean e(Context context, int i10, Drawable drawable) {
            Drawable findDrawableByLayerId;
            int c10;
            if (i10 == e.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable findDrawableByLayerId2 = layerDrawable.findDrawableByLayerId(16908288);
                int i11 = j.a.colorControlNormal;
                m(findDrawableByLayerId2, b0.c(context, i11), f.f1072b);
                m(layerDrawable.findDrawableByLayerId(16908303), b0.c(context, i11), f.f1072b);
                findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908301);
                c10 = b0.c(context, j.a.colorControlActivated);
            } else if (i10 != e.abc_ratingbar_material && i10 != e.abc_ratingbar_indicator_material && i10 != e.abc_ratingbar_small_material) {
                return false;
            } else {
                LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                m(layerDrawable2.findDrawableByLayerId(16908288), b0.b(context, j.a.colorControlNormal), f.f1072b);
                Drawable findDrawableByLayerId3 = layerDrawable2.findDrawableByLayerId(16908303);
                int i12 = j.a.colorControlActivated;
                m(findDrawableByLayerId3, b0.c(context, i12), f.f1072b);
                findDrawableByLayerId = layerDrawable2.findDrawableByLayerId(16908301);
                c10 = b0.c(context, i12);
            }
            m(findDrawableByLayerId, c10, f.f1072b);
            return true;
        }
    }

    public static synchronized f b() {
        f fVar;
        synchronized (f.class) {
            if (f1073c == null) {
                h();
            }
            fVar = f1073c;
        }
        return fVar;
    }

    public static synchronized PorterDuffColorFilter e(int i10, PorterDuff.Mode mode) {
        PorterDuffColorFilter l10;
        synchronized (f.class) {
            l10 = w.l(i10, mode);
        }
        return l10;
    }

    public static synchronized void h() {
        synchronized (f.class) {
            if (f1073c == null) {
                f fVar = new f();
                f1073c = fVar;
                fVar.f1074a = w.h();
                f1073c.f1074a.u(new a());
            }
        }
    }

    static void i(Drawable drawable, e0 e0Var, int[] iArr) {
        w.w(drawable, e0Var, iArr);
    }

    public synchronized Drawable c(Context context, int i10) {
        return this.f1074a.j(context, i10);
    }

    /* access modifiers changed from: package-private */
    public synchronized Drawable d(Context context, int i10, boolean z10) {
        return this.f1074a.k(context, i10, z10);
    }

    /* access modifiers changed from: package-private */
    public synchronized ColorStateList f(Context context, int i10) {
        return this.f1074a.m(context, i10);
    }

    public synchronized void g(Context context) {
        this.f1074a.s(context);
    }
}
