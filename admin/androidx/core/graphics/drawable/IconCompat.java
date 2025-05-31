package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k  reason: collision with root package name */
    static final PorterDuff.Mode f2279k = PorterDuff.Mode.SRC_IN;

    /* renamed from: a  reason: collision with root package name */
    public int f2280a = -1;

    /* renamed from: b  reason: collision with root package name */
    Object f2281b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f2282c = null;

    /* renamed from: d  reason: collision with root package name */
    public Parcelable f2283d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f2284e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f2285f = 0;

    /* renamed from: g  reason: collision with root package name */
    public ColorStateList f2286g = null;

    /* renamed from: h  reason: collision with root package name */
    PorterDuff.Mode f2287h = f2279k;

    /* renamed from: i  reason: collision with root package name */
    public String f2288i = null;

    /* renamed from: j  reason: collision with root package name */
    public String f2289j;

    public IconCompat() {
    }

    private IconCompat(int i10) {
        this.f2280a = i10;
    }

    static Bitmap a(Bitmap bitmap, boolean z10) {
        int min = (int) (((float) Math.min(bitmap.getWidth(), bitmap.getHeight())) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f10 = (float) min;
        float f11 = 0.5f * f10;
        float f12 = 0.9166667f * f11;
        if (z10) {
            float f13 = 0.010416667f * f10;
            paint.setColor(0);
            paint.setShadowLayer(f13, 0.0f, f10 * 0.020833334f, 1023410176);
            canvas.drawCircle(f11, f11, f12, paint);
            paint.setShadowLayer(f13, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f11, f11, f12, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((float) ((-(bitmap.getWidth() - min)) / 2), (float) ((-(bitmap.getHeight() - min)) / 2));
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f11, f11, f12, paint);
        canvas.setBitmap((Bitmap) null);
        return createBitmap;
    }

    public static IconCompat b(Bitmap bitmap) {
        if (bitmap != null) {
            IconCompat iconCompat = new IconCompat(1);
            iconCompat.f2281b = bitmap;
            return iconCompat;
        }
        throw new IllegalArgumentException("Bitmap must not be null.");
    }

    public static IconCompat c(Resources resources, String str, int i10) {
        if (str == null) {
            throw new IllegalArgumentException("Package must not be null.");
        } else if (i10 != 0) {
            IconCompat iconCompat = new IconCompat(2);
            iconCompat.f2284e = i10;
            if (resources != null) {
                try {
                    iconCompat.f2281b = resources.getResourceName(i10);
                } catch (Resources.NotFoundException unused) {
                    throw new IllegalArgumentException("Icon resource cannot be found");
                }
            } else {
                iconCompat.f2281b = str;
            }
            iconCompat.f2289j = str;
            return iconCompat;
        } else {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
    }

    private static int f(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResId();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e10) {
            Log.e("IconCompat", "Unable to get icon resource", e10);
            return 0;
        } catch (InvocationTargetException e11) {
            Log.e("IconCompat", "Unable to get icon resource", e11);
            return 0;
        } catch (NoSuchMethodException e12) {
            Log.e("IconCompat", "Unable to get icon resource", e12);
            return 0;
        }
    }

    private static String h(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResPackage();
        }
        try {
            return (String) icon.getClass().getMethod("getResPackage", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e10) {
            Log.e("IconCompat", "Unable to get icon package", e10);
            return null;
        } catch (InvocationTargetException e11) {
            Log.e("IconCompat", "Unable to get icon package", e11);
            return null;
        } catch (NoSuchMethodException e12) {
            Log.e("IconCompat", "Unable to get icon package", e12);
            return null;
        }
    }

    private static int j(Icon icon) {
        StringBuilder sb2;
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getType();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getType", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e10) {
            e = e10;
            sb2 = new StringBuilder();
            sb2.append("Unable to get icon type ");
            sb2.append(icon);
            Log.e("IconCompat", sb2.toString(), e);
            return -1;
        } catch (InvocationTargetException e11) {
            e = e11;
            sb2 = new StringBuilder();
            sb2.append("Unable to get icon type ");
            sb2.append(icon);
            Log.e("IconCompat", sb2.toString(), e);
            return -1;
        } catch (NoSuchMethodException e12) {
            e = e12;
            sb2 = new StringBuilder();
            sb2.append("Unable to get icon type ");
            sb2.append(icon);
            Log.e("IconCompat", sb2.toString(), e);
            return -1;
        }
    }

    private static Uri l(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getUri();
        }
        try {
            return (Uri) icon.getClass().getMethod("getUri", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e10) {
            Log.e("IconCompat", "Unable to get icon uri", e10);
            return null;
        } catch (InvocationTargetException e11) {
            Log.e("IconCompat", "Unable to get icon uri", e11);
            return null;
        } catch (NoSuchMethodException e12) {
            Log.e("IconCompat", "Unable to get icon uri", e12);
            return null;
        }
    }

    private static String r(int i10) {
        switch (i10) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    public Bitmap d() {
        int i10 = this.f2280a;
        if (i10 == -1 && Build.VERSION.SDK_INT >= 23) {
            Object obj = this.f2281b;
            if (obj instanceof Bitmap) {
                return (Bitmap) obj;
            }
            return null;
        } else if (i10 == 1) {
            return (Bitmap) this.f2281b;
        } else {
            if (i10 == 5) {
                return a((Bitmap) this.f2281b, true);
            }
            throw new IllegalStateException("called getBitmap() on " + this);
        }
    }

    public int e() {
        int i10 = this.f2280a;
        if (i10 == -1 && Build.VERSION.SDK_INT >= 23) {
            return f((Icon) this.f2281b);
        }
        if (i10 == 2) {
            return this.f2284e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String g() {
        int i10 = this.f2280a;
        if (i10 == -1 && Build.VERSION.SDK_INT >= 23) {
            return h((Icon) this.f2281b);
        }
        if (i10 == 2) {
            return TextUtils.isEmpty(this.f2289j) ? ((String) this.f2281b).split(":", -1)[0] : this.f2289j;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int i() {
        int i10 = this.f2280a;
        return (i10 != -1 || Build.VERSION.SDK_INT < 23) ? i10 : j((Icon) this.f2281b);
    }

    public Uri k() {
        int i10 = this.f2280a;
        if (i10 == -1 && Build.VERSION.SDK_INT >= 23) {
            return l((Icon) this.f2281b);
        }
        if (i10 == 4 || i10 == 6) {
            return Uri.parse((String) this.f2281b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public InputStream m(Context context) {
        String str;
        StringBuilder sb2;
        Uri k10 = k();
        String scheme = k10.getScheme();
        if ("content".equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(k10);
            } catch (Exception e10) {
                e = e10;
                sb2 = new StringBuilder();
                str = "Unable to load image from URI: ";
                sb2.append(str);
                sb2.append(k10);
                Log.w("IconCompat", sb2.toString(), e);
                return null;
            }
        } else {
            try {
                return new FileInputStream(new File((String) this.f2281b));
            } catch (FileNotFoundException e11) {
                e = e11;
                sb2 = new StringBuilder();
                str = "Unable to load image from path: ";
                sb2.append(str);
                sb2.append(k10);
                Log.w("IconCompat", sb2.toString(), e);
                return null;
            }
        }
    }

    public void n() {
        Parcelable parcelable;
        this.f2287h = PorterDuff.Mode.valueOf(this.f2288i);
        switch (this.f2280a) {
            case -1:
                parcelable = this.f2283d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                break;
            case 1:
            case 5:
                parcelable = this.f2283d;
                if (parcelable == null) {
                    byte[] bArr = this.f2282c;
                    this.f2281b = bArr;
                    this.f2280a = 3;
                    this.f2284e = 0;
                    this.f2285f = bArr.length;
                    return;
                }
                break;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f2282c, Charset.forName("UTF-16"));
                this.f2281b = str;
                if (this.f2280a == 2 && this.f2289j == null) {
                    this.f2289j = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.f2281b = this.f2282c;
                return;
            default:
                return;
        }
        this.f2281b = parcelable;
    }

    public void o(boolean z10) {
        this.f2288i = this.f2287h.name();
        switch (this.f2280a) {
            case -1:
                if (z10) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                break;
            case 1:
            case 5:
                if (z10) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ((Bitmap) this.f2281b).compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                    this.f2282c = byteArrayOutputStream.toByteArray();
                    return;
                }
                break;
            case 2:
                this.f2282c = ((String) this.f2281b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f2282c = (byte[]) this.f2281b;
                return;
            case 4:
            case 6:
                this.f2282c = this.f2281b.toString().getBytes(Charset.forName("UTF-16"));
                return;
            default:
                return;
        }
        this.f2283d = (Parcelable) this.f2281b;
    }

    @Deprecated
    public Icon p() {
        return q((Context) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
        if (r0 >= 26) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006d, code lost:
        r5 = android.graphics.drawable.Icon.createWithAdaptiveBitmap(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0076, code lost:
        r5 = a(r5, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a0, code lost:
        r5 = android.graphics.drawable.Icon.createWithBitmap(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a4, code lost:
        r0 = r4.f2286g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a6, code lost:
        if (r0 == null) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a8, code lost:
        r5.setTintList(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ab, code lost:
        r0 = r4.f2287h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00af, code lost:
        if (r0 == f2279k) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b1, code lost:
        r5.setTintMode(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b4, code lost:
        return r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.drawable.Icon q(android.content.Context r5) {
        /*
            r4 = this;
            int r0 = r4.f2280a
            r1 = 0
            r2 = 26
            switch(r0) {
                case -1: goto L_0x00b5;
                case 0: goto L_0x0008;
                case 1: goto L_0x009c;
                case 2: goto L_0x0091;
                case 3: goto L_0x0084;
                case 4: goto L_0x007b;
                case 5: goto L_0x0065;
                case 6: goto L_0x0010;
                default: goto L_0x0008;
            }
        L_0x0008:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Unknown type"
            r5.<init>(r0)
            throw r5
        L_0x0010:
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 30
            if (r0 < r3) goto L_0x0020
            android.net.Uri r5 = r4.k()
            android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithAdaptiveBitmapContentUri(r5)
            goto L_0x00a4
        L_0x0020:
            if (r5 == 0) goto L_0x004a
            java.io.InputStream r5 = r4.m(r5)
            if (r5 == 0) goto L_0x002f
            android.graphics.Bitmap r5 = android.graphics.BitmapFactory.decodeStream(r5)
            if (r0 < r2) goto L_0x0076
            goto L_0x006d
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Cannot load adaptive icon from uri: "
            r0.append(r1)
            android.net.Uri r1 = r4.k()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        L_0x004a:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Context is required to resolve the file uri of the icon: "
            r0.append(r1)
            android.net.Uri r1 = r4.k()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        L_0x0065:
            int r5 = android.os.Build.VERSION.SDK_INT
            if (r5 < r2) goto L_0x0072
            java.lang.Object r5 = r4.f2281b
            android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
        L_0x006d:
            android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithAdaptiveBitmap(r5)
            goto L_0x00a4
        L_0x0072:
            java.lang.Object r5 = r4.f2281b
            android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
        L_0x0076:
            android.graphics.Bitmap r5 = a(r5, r1)
            goto L_0x00a0
        L_0x007b:
            java.lang.Object r5 = r4.f2281b
            java.lang.String r5 = (java.lang.String) r5
            android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithContentUri(r5)
            goto L_0x00a4
        L_0x0084:
            java.lang.Object r5 = r4.f2281b
            byte[] r5 = (byte[]) r5
            int r0 = r4.f2284e
            int r1 = r4.f2285f
            android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithData(r5, r0, r1)
            goto L_0x00a4
        L_0x0091:
            java.lang.String r5 = r4.g()
            int r0 = r4.f2284e
            android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithResource(r5, r0)
            goto L_0x00a4
        L_0x009c:
            java.lang.Object r5 = r4.f2281b
            android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
        L_0x00a0:
            android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithBitmap(r5)
        L_0x00a4:
            android.content.res.ColorStateList r0 = r4.f2286g
            if (r0 == 0) goto L_0x00ab
            r5.setTintList(r0)
        L_0x00ab:
            android.graphics.PorterDuff$Mode r0 = r4.f2287h
            android.graphics.PorterDuff$Mode r1 = f2279k
            if (r0 == r1) goto L_0x00b4
            r5.setTintMode(r0)
        L_0x00b4:
            return r5
        L_0x00b5:
            java.lang.Object r5 = r4.f2281b
            android.graphics.drawable.Icon r5 = (android.graphics.drawable.Icon) r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.IconCompat.q(android.content.Context):android.graphics.drawable.Icon");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r4 = this;
            int r0 = r4.f2280a
            r1 = -1
            if (r0 != r1) goto L_0x000c
            java.lang.Object r0 = r4.f2281b
            java.lang.String r0 = java.lang.String.valueOf(r0)
            return r0
        L_0x000c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Icon(typ="
            r0.<init>(r1)
            int r1 = r4.f2280a
            java.lang.String r1 = r(r1)
            r0.append(r1)
            int r1 = r4.f2280a
            switch(r1) {
                case 1: goto L_0x006a;
                case 2: goto L_0x0043;
                case 3: goto L_0x002d;
                case 4: goto L_0x0022;
                case 5: goto L_0x006a;
                case 6: goto L_0x0022;
                default: goto L_0x0021;
            }
        L_0x0021:
            goto L_0x008a
        L_0x0022:
            java.lang.String r1 = " uri="
            r0.append(r1)
            java.lang.Object r1 = r4.f2281b
            r0.append(r1)
            goto L_0x008a
        L_0x002d:
            java.lang.String r1 = " len="
            r0.append(r1)
            int r1 = r4.f2284e
            r0.append(r1)
            int r1 = r4.f2285f
            if (r1 == 0) goto L_0x008a
            java.lang.String r1 = " off="
            r0.append(r1)
            int r1 = r4.f2285f
            goto L_0x0087
        L_0x0043:
            java.lang.String r1 = " pkg="
            r0.append(r1)
            java.lang.String r1 = r4.f2289j
            r0.append(r1)
            java.lang.String r1 = " id="
            r0.append(r1)
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = 0
            int r3 = r4.e()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r1[r2] = r3
            java.lang.String r2 = "0x%08x"
            java.lang.String r1 = java.lang.String.format(r2, r1)
            r0.append(r1)
            goto L_0x008a
        L_0x006a:
            java.lang.String r1 = " size="
            r0.append(r1)
            java.lang.Object r1 = r4.f2281b
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            int r1 = r1.getWidth()
            r0.append(r1)
            java.lang.String r1 = "x"
            r0.append(r1)
            java.lang.Object r1 = r4.f2281b
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            int r1 = r1.getHeight()
        L_0x0087:
            r0.append(r1)
        L_0x008a:
            android.content.res.ColorStateList r1 = r4.f2286g
            if (r1 == 0) goto L_0x0098
            java.lang.String r1 = " tint="
            r0.append(r1)
            android.content.res.ColorStateList r1 = r4.f2286g
            r0.append(r1)
        L_0x0098:
            android.graphics.PorterDuff$Mode r1 = r4.f2287h
            android.graphics.PorterDuff$Mode r2 = f2279k
            if (r1 == r2) goto L_0x00a8
            java.lang.String r1 = " mode="
            r0.append(r1)
            android.graphics.PorterDuff$Mode r1 = r4.f2287h
            r0.append(r1)
        L_0x00a8:
            java.lang.String r1 = ")"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.IconCompat.toString():java.lang.String");
    }
}
