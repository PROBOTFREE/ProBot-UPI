package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.core.view.x;
import j.j;
import java.lang.ref.WeakReference;
import n0.f;

class m {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f1145a;

    /* renamed from: b  reason: collision with root package name */
    private e0 f1146b;

    /* renamed from: c  reason: collision with root package name */
    private e0 f1147c;

    /* renamed from: d  reason: collision with root package name */
    private e0 f1148d;

    /* renamed from: e  reason: collision with root package name */
    private e0 f1149e;

    /* renamed from: f  reason: collision with root package name */
    private e0 f1150f;

    /* renamed from: g  reason: collision with root package name */
    private e0 f1151g;

    /* renamed from: h  reason: collision with root package name */
    private e0 f1152h;

    /* renamed from: i  reason: collision with root package name */
    private final n f1153i;

    /* renamed from: j  reason: collision with root package name */
    private int f1154j = 0;

    /* renamed from: k  reason: collision with root package name */
    private int f1155k = -1;

    /* renamed from: l  reason: collision with root package name */
    private Typeface f1156l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f1157m;

    class a extends f.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f1158a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f1159b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ WeakReference f1160c;

        a(int i10, int i11, WeakReference weakReference) {
            this.f1158a = i10;
            this.f1159b = i11;
            this.f1160c = weakReference;
        }

        public void d(int i10) {
        }

        public void e(Typeface typeface) {
            int i10;
            if (Build.VERSION.SDK_INT >= 28 && (i10 = this.f1158a) != -1) {
                typeface = Typeface.create(typeface, i10, (this.f1159b & 2) != 0);
            }
            m.this.n(this.f1160c, typeface);
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f1162a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Typeface f1163b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f1164c;

        b(m mVar, TextView textView, Typeface typeface, int i10) {
            this.f1162a = textView;
            this.f1163b = typeface;
            this.f1164c = i10;
        }

        public void run() {
            this.f1162a.setTypeface(this.f1163b, this.f1164c);
        }
    }

    m(TextView textView) {
        this.f1145a = textView;
        this.f1153i = new n(textView);
    }

    private void B(int i10, float f10) {
        this.f1153i.y(i10, f10);
    }

    private void C(Context context, g0 g0Var) {
        String o10;
        Typeface typeface;
        Typeface typeface2;
        this.f1154j = g0Var.k(j.TextAppearance_android_textStyle, this.f1154j);
        int i10 = Build.VERSION.SDK_INT;
        boolean z10 = false;
        if (i10 >= 28) {
            int k10 = g0Var.k(j.TextAppearance_android_textFontWeight, -1);
            this.f1155k = k10;
            if (k10 != -1) {
                this.f1154j = (this.f1154j & 2) | 0;
            }
        }
        int i11 = j.TextAppearance_android_fontFamily;
        if (g0Var.s(i11) || g0Var.s(j.TextAppearance_fontFamily)) {
            this.f1156l = null;
            int i12 = j.TextAppearance_fontFamily;
            if (g0Var.s(i12)) {
                i11 = i12;
            }
            int i13 = this.f1155k;
            int i14 = this.f1154j;
            if (!context.isRestricted()) {
                try {
                    Typeface j10 = g0Var.j(i11, this.f1154j, new a(i13, i14, new WeakReference(this.f1145a)));
                    if (j10 != null) {
                        if (i10 >= 28 && this.f1155k != -1) {
                            j10 = Typeface.create(Typeface.create(j10, 0), this.f1155k, (this.f1154j & 2) != 0);
                        }
                        this.f1156l = j10;
                    }
                    this.f1157m = this.f1156l == null;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.f1156l == null && (o10 = g0Var.o(i11)) != null) {
                if (Build.VERSION.SDK_INT < 28 || this.f1155k == -1) {
                    typeface = Typeface.create(o10, this.f1154j);
                } else {
                    Typeface create = Typeface.create(o10, 0);
                    int i15 = this.f1155k;
                    if ((this.f1154j & 2) != 0) {
                        z10 = true;
                    }
                    typeface = Typeface.create(create, i15, z10);
                }
                this.f1156l = typeface;
                return;
            }
            return;
        }
        int i16 = j.TextAppearance_android_typeface;
        if (g0Var.s(i16)) {
            this.f1157m = false;
            int k11 = g0Var.k(i16, 1);
            if (k11 == 1) {
                typeface2 = Typeface.SANS_SERIF;
            } else if (k11 == 2) {
                typeface2 = Typeface.SERIF;
            } else if (k11 == 3) {
                typeface2 = Typeface.MONOSPACE;
            } else {
                return;
            }
            this.f1156l = typeface2;
        }
    }

    private void a(Drawable drawable, e0 e0Var) {
        if (drawable != null && e0Var != null) {
            f.i(drawable, e0Var, this.f1145a.getDrawableState());
        }
    }

    private static e0 d(Context context, f fVar, int i10) {
        ColorStateList f10 = fVar.f(context, i10);
        if (f10 == null) {
            return null;
        }
        e0 e0Var = new e0();
        e0Var.f1071d = true;
        e0Var.f1068a = f10;
        return e0Var;
    }

    private void y(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 17 && (drawable5 != null || drawable6 != null)) {
            Drawable[] compoundDrawablesRelative = this.f1145a.getCompoundDrawablesRelative();
            TextView textView = this.f1145a;
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
        } else if (drawable != null || drawable2 != null || drawable3 != null || drawable4 != null) {
            if (i10 >= 17) {
                Drawable[] compoundDrawablesRelative2 = this.f1145a.getCompoundDrawablesRelative();
                if (!(compoundDrawablesRelative2[0] == null && compoundDrawablesRelative2[2] == null)) {
                    TextView textView2 = this.f1145a;
                    Drawable drawable7 = compoundDrawablesRelative2[0];
                    if (drawable2 == null) {
                        drawable2 = compoundDrawablesRelative2[1];
                    }
                    Drawable drawable8 = compoundDrawablesRelative2[2];
                    if (drawable4 == null) {
                        drawable4 = compoundDrawablesRelative2[3];
                    }
                    textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
                    return;
                }
            }
            Drawable[] compoundDrawables = this.f1145a.getCompoundDrawables();
            TextView textView3 = this.f1145a;
            if (drawable == null) {
                drawable = compoundDrawables[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawables[1];
            }
            if (drawable3 == null) {
                drawable3 = compoundDrawables[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawables[3];
            }
            textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }
    }

    private void z() {
        e0 e0Var = this.f1152h;
        this.f1146b = e0Var;
        this.f1147c = e0Var;
        this.f1148d = e0Var;
        this.f1149e = e0Var;
        this.f1150f = e0Var;
        this.f1151g = e0Var;
    }

    /* access modifiers changed from: package-private */
    public void A(int i10, float f10) {
        if (!androidx.core.widget.b.f2479d0 && !l()) {
            B(i10, f10);
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (!(this.f1146b == null && this.f1147c == null && this.f1148d == null && this.f1149e == null)) {
            Drawable[] compoundDrawables = this.f1145a.getCompoundDrawables();
            a(compoundDrawables[0], this.f1146b);
            a(compoundDrawables[1], this.f1147c);
            a(compoundDrawables[2], this.f1148d);
            a(compoundDrawables[3], this.f1149e);
        }
        if (Build.VERSION.SDK_INT < 17) {
            return;
        }
        if (this.f1150f != null || this.f1151g != null) {
            Drawable[] compoundDrawablesRelative = this.f1145a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.f1150f);
            a(compoundDrawablesRelative[2], this.f1151g);
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f1153i.b();
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.f1153i.j();
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f1153i.k();
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.f1153i.l();
    }

    /* access modifiers changed from: package-private */
    public int[] h() {
        return this.f1153i.m();
    }

    /* access modifiers changed from: package-private */
    public int i() {
        return this.f1153i.n();
    }

    /* access modifiers changed from: package-private */
    public ColorStateList j() {
        e0 e0Var = this.f1152h;
        if (e0Var != null) {
            return e0Var.f1068a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode k() {
        e0 e0Var = this.f1152h;
        if (e0Var != null) {
            return e0Var.f1069b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return this.f1153i.s();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01e2  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x022b  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0268  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x026e  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0277  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x027d  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0286  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x028c  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0295  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x029b  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x02a4  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x02aa  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x02b3  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x02b9  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x02cd  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x02de  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x02ee  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0306  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x030d  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0314  */
    /* JADX WARNING: Removed duplicated region for block: B:161:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01ce  */
    @android.annotation.SuppressLint({"NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m(android.util.AttributeSet r24, int r25) {
        /*
            r23 = this;
            r7 = r23
            r8 = r24
            r9 = r25
            android.widget.TextView r0 = r7.f1145a
            android.content.Context r10 = r0.getContext()
            androidx.appcompat.widget.f r11 = androidx.appcompat.widget.f.b()
            int[] r2 = j.j.AppCompatTextHelper
            r12 = 0
            androidx.appcompat.widget.g0 r13 = androidx.appcompat.widget.g0.v(r10, r8, r2, r9, r12)
            android.widget.TextView r0 = r7.f1145a
            android.content.Context r1 = r0.getContext()
            android.content.res.TypedArray r4 = r13.r()
            r6 = 0
            r3 = r24
            r5 = r25
            androidx.core.view.x.p0(r0, r1, r2, r3, r4, r5, r6)
            int r0 = j.j.AppCompatTextHelper_android_textAppearance
            r14 = -1
            int r0 = r13.n(r0, r14)
            int r1 = j.j.AppCompatTextHelper_android_drawableLeft
            boolean r2 = r13.s(r1)
            if (r2 == 0) goto L_0x0042
            int r1 = r13.n(r1, r12)
            androidx.appcompat.widget.e0 r1 = d(r10, r11, r1)
            r7.f1146b = r1
        L_0x0042:
            int r1 = j.j.AppCompatTextHelper_android_drawableTop
            boolean r2 = r13.s(r1)
            if (r2 == 0) goto L_0x0054
            int r1 = r13.n(r1, r12)
            androidx.appcompat.widget.e0 r1 = d(r10, r11, r1)
            r7.f1147c = r1
        L_0x0054:
            int r1 = j.j.AppCompatTextHelper_android_drawableRight
            boolean r2 = r13.s(r1)
            if (r2 == 0) goto L_0x0066
            int r1 = r13.n(r1, r12)
            androidx.appcompat.widget.e0 r1 = d(r10, r11, r1)
            r7.f1148d = r1
        L_0x0066:
            int r1 = j.j.AppCompatTextHelper_android_drawableBottom
            boolean r2 = r13.s(r1)
            if (r2 == 0) goto L_0x0078
            int r1 = r13.n(r1, r12)
            androidx.appcompat.widget.e0 r1 = d(r10, r11, r1)
            r7.f1149e = r1
        L_0x0078:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 17
            if (r1 < r2) goto L_0x00a2
            int r2 = j.j.AppCompatTextHelper_android_drawableStart
            boolean r3 = r13.s(r2)
            if (r3 == 0) goto L_0x0090
            int r2 = r13.n(r2, r12)
            androidx.appcompat.widget.e0 r2 = d(r10, r11, r2)
            r7.f1150f = r2
        L_0x0090:
            int r2 = j.j.AppCompatTextHelper_android_drawableEnd
            boolean r3 = r13.s(r2)
            if (r3 == 0) goto L_0x00a2
            int r2 = r13.n(r2, r12)
            androidx.appcompat.widget.e0 r2 = d(r10, r11, r2)
            r7.f1151g = r2
        L_0x00a2:
            r13.w()
            android.widget.TextView r2 = r7.f1145a
            android.text.method.TransformationMethod r2 = r2.getTransformationMethod()
            boolean r2 = r2 instanceof android.text.method.PasswordTransformationMethod
            r3 = 26
            r5 = 23
            if (r0 == r14) goto L_0x011e
            int[] r6 = j.j.TextAppearance
            androidx.appcompat.widget.g0 r0 = androidx.appcompat.widget.g0.t(r10, r0, r6)
            if (r2 != 0) goto L_0x00c9
            int r6 = j.j.TextAppearance_textAllCaps
            boolean r15 = r0.s(r6)
            if (r15 == 0) goto L_0x00c9
            boolean r6 = r0.a(r6, r12)
            r15 = 1
            goto L_0x00cb
        L_0x00c9:
            r6 = r12
            r15 = r6
        L_0x00cb:
            r7.C(r10, r0)
            if (r1 >= r5) goto L_0x00f9
            int r4 = j.j.TextAppearance_android_textColor
            boolean r17 = r0.s(r4)
            if (r17 == 0) goto L_0x00dd
            android.content.res.ColorStateList r4 = r0.c(r4)
            goto L_0x00de
        L_0x00dd:
            r4 = 0
        L_0x00de:
            int r13 = j.j.TextAppearance_android_textColorHint
            boolean r18 = r0.s(r13)
            if (r18 == 0) goto L_0x00eb
            android.content.res.ColorStateList r13 = r0.c(r13)
            goto L_0x00ec
        L_0x00eb:
            r13 = 0
        L_0x00ec:
            int r14 = j.j.TextAppearance_android_textColorLink
            boolean r19 = r0.s(r14)
            if (r19 == 0) goto L_0x00fb
            android.content.res.ColorStateList r14 = r0.c(r14)
            goto L_0x00fc
        L_0x00f9:
            r4 = 0
            r13 = 0
        L_0x00fb:
            r14 = 0
        L_0x00fc:
            int r5 = j.j.TextAppearance_textLocale
            boolean r20 = r0.s(r5)
            if (r20 == 0) goto L_0x0109
            java.lang.String r5 = r0.o(r5)
            goto L_0x010a
        L_0x0109:
            r5 = 0
        L_0x010a:
            if (r1 < r3) goto L_0x0119
            int r3 = j.j.TextAppearance_fontVariationSettings
            boolean r21 = r0.s(r3)
            if (r21 == 0) goto L_0x0119
            java.lang.String r3 = r0.o(r3)
            goto L_0x011a
        L_0x0119:
            r3 = 0
        L_0x011a:
            r0.w()
            goto L_0x0125
        L_0x011e:
            r6 = r12
            r15 = r6
            r3 = 0
            r4 = 0
            r5 = 0
            r13 = 0
            r14 = 0
        L_0x0125:
            int[] r0 = j.j.TextAppearance
            androidx.appcompat.widget.g0 r0 = androidx.appcompat.widget.g0.v(r10, r8, r0, r9, r12)
            if (r2 != 0) goto L_0x0140
            int r12 = j.j.TextAppearance_textAllCaps
            boolean r22 = r0.s(r12)
            if (r22 == 0) goto L_0x0140
            r22 = r3
            r3 = 0
            boolean r6 = r0.a(r12, r3)
            r3 = 23
            r15 = 1
            goto L_0x0144
        L_0x0140:
            r22 = r3
            r3 = 23
        L_0x0144:
            if (r1 >= r3) goto L_0x016a
            int r3 = j.j.TextAppearance_android_textColor
            boolean r12 = r0.s(r3)
            if (r12 == 0) goto L_0x0152
            android.content.res.ColorStateList r4 = r0.c(r3)
        L_0x0152:
            int r3 = j.j.TextAppearance_android_textColorHint
            boolean r12 = r0.s(r3)
            if (r12 == 0) goto L_0x015e
            android.content.res.ColorStateList r13 = r0.c(r3)
        L_0x015e:
            int r3 = j.j.TextAppearance_android_textColorLink
            boolean r12 = r0.s(r3)
            if (r12 == 0) goto L_0x016a
            android.content.res.ColorStateList r14 = r0.c(r3)
        L_0x016a:
            int r3 = j.j.TextAppearance_textLocale
            boolean r12 = r0.s(r3)
            if (r12 == 0) goto L_0x0176
            java.lang.String r5 = r0.o(r3)
        L_0x0176:
            r3 = 26
            if (r1 < r3) goto L_0x0187
            int r3 = j.j.TextAppearance_fontVariationSettings
            boolean r12 = r0.s(r3)
            if (r12 == 0) goto L_0x0187
            java.lang.String r3 = r0.o(r3)
            goto L_0x0189
        L_0x0187:
            r3 = r22
        L_0x0189:
            r12 = 28
            if (r1 < r12) goto L_0x01a6
            int r12 = j.j.TextAppearance_android_textSize
            boolean r16 = r0.s(r12)
            if (r16 == 0) goto L_0x01a6
            r16 = r11
            r11 = -1
            int r12 = r0.f(r12, r11)
            if (r12 != 0) goto L_0x01a8
            android.widget.TextView r11 = r7.f1145a
            r12 = 0
            r8 = 0
            r11.setTextSize(r8, r12)
            goto L_0x01a8
        L_0x01a6:
            r16 = r11
        L_0x01a8:
            r7.C(r10, r0)
            r0.w()
            if (r4 == 0) goto L_0x01b5
            android.widget.TextView r0 = r7.f1145a
            r0.setTextColor(r4)
        L_0x01b5:
            if (r13 == 0) goto L_0x01bc
            android.widget.TextView r0 = r7.f1145a
            r0.setHintTextColor(r13)
        L_0x01bc:
            if (r14 == 0) goto L_0x01c3
            android.widget.TextView r0 = r7.f1145a
            r0.setLinkTextColor(r14)
        L_0x01c3:
            if (r2 != 0) goto L_0x01ca
            if (r15 == 0) goto L_0x01ca
            r7.s(r6)
        L_0x01ca:
            android.graphics.Typeface r0 = r7.f1156l
            if (r0 == 0) goto L_0x01e0
            int r2 = r7.f1155k
            r4 = -1
            if (r2 != r4) goto L_0x01db
            android.widget.TextView r2 = r7.f1145a
            int r4 = r7.f1154j
            r2.setTypeface(r0, r4)
            goto L_0x01e0
        L_0x01db:
            android.widget.TextView r2 = r7.f1145a
            r2.setTypeface(r0)
        L_0x01e0:
            if (r3 == 0) goto L_0x01e7
            android.widget.TextView r0 = r7.f1145a
            r0.setFontVariationSettings(r3)
        L_0x01e7:
            if (r5 == 0) goto L_0x020f
            r0 = 24
            if (r1 < r0) goto L_0x01f7
            android.widget.TextView r0 = r7.f1145a
            android.os.LocaleList r1 = android.os.LocaleList.forLanguageTags(r5)
            r0.setTextLocales(r1)
            goto L_0x020f
        L_0x01f7:
            r0 = 21
            if (r1 < r0) goto L_0x020f
            r0 = 44
            int r0 = r5.indexOf(r0)
            r1 = 0
            java.lang.String r0 = r5.substring(r1, r0)
            android.widget.TextView r1 = r7.f1145a
            java.util.Locale r0 = java.util.Locale.forLanguageTag(r0)
            r1.setTextLocale(r0)
        L_0x020f:
            androidx.appcompat.widget.n r0 = r7.f1153i
            r1 = r24
            r0.t(r1, r9)
            boolean r0 = androidx.core.widget.b.f2479d0
            if (r0 == 0) goto L_0x0257
            androidx.appcompat.widget.n r0 = r7.f1153i
            int r0 = r0.n()
            if (r0 == 0) goto L_0x0257
            androidx.appcompat.widget.n r0 = r7.f1153i
            int[] r0 = r0.m()
            int r2 = r0.length
            if (r2 <= 0) goto L_0x0257
            android.widget.TextView r2 = r7.f1145a
            int r2 = r2.getAutoSizeStepGranularity()
            float r2 = (float) r2
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x0251
            android.widget.TextView r0 = r7.f1145a
            androidx.appcompat.widget.n r2 = r7.f1153i
            int r2 = r2.k()
            androidx.appcompat.widget.n r3 = r7.f1153i
            int r3 = r3.j()
            androidx.appcompat.widget.n r4 = r7.f1153i
            int r4 = r4.l()
            r5 = 0
            r0.setAutoSizeTextTypeUniformWithConfiguration(r2, r3, r4, r5)
            goto L_0x0257
        L_0x0251:
            r5 = 0
            android.widget.TextView r2 = r7.f1145a
            r2.setAutoSizeTextTypeUniformWithPresetSizes(r0, r5)
        L_0x0257:
            int[] r0 = j.j.AppCompatTextView
            androidx.appcompat.widget.g0 r8 = androidx.appcompat.widget.g0.u(r10, r1, r0)
            int r0 = j.j.AppCompatTextView_drawableLeftCompat
            r1 = -1
            int r0 = r8.n(r0, r1)
            r2 = r16
            if (r0 == r1) goto L_0x026e
            android.graphics.drawable.Drawable r0 = r2.c(r10, r0)
            r3 = r0
            goto L_0x026f
        L_0x026e:
            r3 = 0
        L_0x026f:
            int r0 = j.j.AppCompatTextView_drawableTopCompat
            int r0 = r8.n(r0, r1)
            if (r0 == r1) goto L_0x027d
            android.graphics.drawable.Drawable r0 = r2.c(r10, r0)
            r4 = r0
            goto L_0x027e
        L_0x027d:
            r4 = 0
        L_0x027e:
            int r0 = j.j.AppCompatTextView_drawableRightCompat
            int r0 = r8.n(r0, r1)
            if (r0 == r1) goto L_0x028c
            android.graphics.drawable.Drawable r0 = r2.c(r10, r0)
            r5 = r0
            goto L_0x028d
        L_0x028c:
            r5 = 0
        L_0x028d:
            int r0 = j.j.AppCompatTextView_drawableBottomCompat
            int r0 = r8.n(r0, r1)
            if (r0 == r1) goto L_0x029b
            android.graphics.drawable.Drawable r0 = r2.c(r10, r0)
            r6 = r0
            goto L_0x029c
        L_0x029b:
            r6 = 0
        L_0x029c:
            int r0 = j.j.AppCompatTextView_drawableStartCompat
            int r0 = r8.n(r0, r1)
            if (r0 == r1) goto L_0x02aa
            android.graphics.drawable.Drawable r0 = r2.c(r10, r0)
            r9 = r0
            goto L_0x02ab
        L_0x02aa:
            r9 = 0
        L_0x02ab:
            int r0 = j.j.AppCompatTextView_drawableEndCompat
            int r0 = r8.n(r0, r1)
            if (r0 == r1) goto L_0x02b9
            android.graphics.drawable.Drawable r0 = r2.c(r10, r0)
            r10 = r0
            goto L_0x02ba
        L_0x02b9:
            r10 = 0
        L_0x02ba:
            r0 = r23
            r1 = r3
            r2 = r4
            r3 = r5
            r4 = r6
            r5 = r9
            r6 = r10
            r0.y(r1, r2, r3, r4, r5, r6)
            int r0 = j.j.AppCompatTextView_drawableTint
            boolean r1 = r8.s(r0)
            if (r1 == 0) goto L_0x02d6
            android.content.res.ColorStateList r0 = r8.c(r0)
            android.widget.TextView r1 = r7.f1145a
            androidx.core.widget.k.j(r1, r0)
        L_0x02d6:
            int r0 = j.j.AppCompatTextView_drawableTintMode
            boolean r1 = r8.s(r0)
            if (r1 == 0) goto L_0x02ee
            r1 = -1
            int r0 = r8.k(r0, r1)
            r2 = 0
            android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.q.e(r0, r2)
            android.widget.TextView r2 = r7.f1145a
            androidx.core.widget.k.k(r2, r0)
            goto L_0x02ef
        L_0x02ee:
            r1 = -1
        L_0x02ef:
            int r0 = j.j.AppCompatTextView_firstBaselineToTopHeight
            int r0 = r8.f(r0, r1)
            int r2 = j.j.AppCompatTextView_lastBaselineToBottomHeight
            int r2 = r8.f(r2, r1)
            int r3 = j.j.AppCompatTextView_lineHeight
            int r3 = r8.f(r3, r1)
            r8.w()
            if (r0 == r1) goto L_0x030b
            android.widget.TextView r4 = r7.f1145a
            androidx.core.widget.k.m(r4, r0)
        L_0x030b:
            if (r2 == r1) goto L_0x0312
            android.widget.TextView r0 = r7.f1145a
            androidx.core.widget.k.n(r0, r2)
        L_0x0312:
            if (r3 == r1) goto L_0x0319
            android.widget.TextView r0 = r7.f1145a
            androidx.core.widget.k.o(r0, r3)
        L_0x0319:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.m.m(android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: package-private */
    public void n(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.f1157m) {
            this.f1156l = typeface;
            TextView textView = (TextView) weakReference.get();
            if (textView == null) {
                return;
            }
            if (x.U(textView)) {
                textView.post(new b(this, textView, typeface, this.f1154j));
            } else {
                textView.setTypeface(typeface, this.f1154j);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void o(boolean z10, int i10, int i11, int i12, int i13) {
        if (!androidx.core.widget.b.f2479d0) {
            c();
        }
    }

    /* access modifiers changed from: package-private */
    public void p() {
        b();
    }

    /* access modifiers changed from: package-private */
    public void q(Context context, int i10) {
        String o10;
        ColorStateList c10;
        ColorStateList c11;
        ColorStateList c12;
        g0 t10 = g0.t(context, i10, j.TextAppearance);
        int i11 = j.TextAppearance_textAllCaps;
        if (t10.s(i11)) {
            s(t10.a(i11, false));
        }
        int i12 = Build.VERSION.SDK_INT;
        if (i12 < 23) {
            int i13 = j.TextAppearance_android_textColor;
            if (t10.s(i13) && (c12 = t10.c(i13)) != null) {
                this.f1145a.setTextColor(c12);
            }
            int i14 = j.TextAppearance_android_textColorLink;
            if (t10.s(i14) && (c11 = t10.c(i14)) != null) {
                this.f1145a.setLinkTextColor(c11);
            }
            int i15 = j.TextAppearance_android_textColorHint;
            if (t10.s(i15) && (c10 = t10.c(i15)) != null) {
                this.f1145a.setHintTextColor(c10);
            }
        }
        int i16 = j.TextAppearance_android_textSize;
        if (t10.s(i16) && t10.f(i16, -1) == 0) {
            this.f1145a.setTextSize(0, 0.0f);
        }
        C(context, t10);
        if (i12 >= 26) {
            int i17 = j.TextAppearance_fontVariationSettings;
            if (t10.s(i17) && (o10 = t10.o(i17)) != null) {
                this.f1145a.setFontVariationSettings(o10);
            }
        }
        t10.w();
        Typeface typeface = this.f1156l;
        if (typeface != null) {
            this.f1145a.setTypeface(typeface, this.f1154j);
        }
    }

    /* access modifiers changed from: package-private */
    public void r(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT < 30 && inputConnection != null) {
            y0.a.f(editorInfo, textView.getText());
        }
    }

    /* access modifiers changed from: package-private */
    public void s(boolean z10) {
        this.f1145a.setAllCaps(z10);
    }

    /* access modifiers changed from: package-private */
    public void t(int i10, int i11, int i12, int i13) {
        this.f1153i.u(i10, i11, i12, i13);
    }

    /* access modifiers changed from: package-private */
    public void u(int[] iArr, int i10) {
        this.f1153i.v(iArr, i10);
    }

    /* access modifiers changed from: package-private */
    public void v(int i10) {
        this.f1153i.w(i10);
    }

    /* access modifiers changed from: package-private */
    public void w(ColorStateList colorStateList) {
        if (this.f1152h == null) {
            this.f1152h = new e0();
        }
        e0 e0Var = this.f1152h;
        e0Var.f1068a = colorStateList;
        e0Var.f1071d = colorStateList != null;
        z();
    }

    /* access modifiers changed from: package-private */
    public void x(PorterDuff.Mode mode) {
        if (this.f1152h == null) {
            this.f1152h = new e0();
        }
        e0 e0Var = this.f1152h;
        e0Var.f1069b = mode;
        e0Var.f1070c = mode != null;
        z();
    }
}
