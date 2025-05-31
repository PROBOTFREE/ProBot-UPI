package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1964a = false;

    /* renamed from: b  reason: collision with root package name */
    String f1965b;

    /* renamed from: c  reason: collision with root package name */
    private b f1966c;

    /* renamed from: d  reason: collision with root package name */
    private int f1967d;

    /* renamed from: e  reason: collision with root package name */
    private float f1968e;

    /* renamed from: f  reason: collision with root package name */
    private String f1969f;

    /* renamed from: g  reason: collision with root package name */
    boolean f1970g;

    /* renamed from: h  reason: collision with root package name */
    private int f1971h;

    /* renamed from: androidx.constraintlayout.widget.a$a  reason: collision with other inner class name */
    static /* synthetic */ class C0014a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1972a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.constraintlayout.widget.a$b[] r0 = androidx.constraintlayout.widget.a.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1972a = r0
                androidx.constraintlayout.widget.a$b r1 = androidx.constraintlayout.widget.a.b.REFERENCE_TYPE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f1972a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.widget.a$b r1 = androidx.constraintlayout.widget.a.b.BOOLEAN_TYPE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f1972a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.widget.a$b r1 = androidx.constraintlayout.widget.a.b.STRING_TYPE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f1972a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.widget.a$b r1 = androidx.constraintlayout.widget.a.b.COLOR_TYPE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f1972a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.constraintlayout.widget.a$b r1 = androidx.constraintlayout.widget.a.b.COLOR_DRAWABLE_TYPE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f1972a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.constraintlayout.widget.a$b r1 = androidx.constraintlayout.widget.a.b.INT_TYPE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f1972a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.constraintlayout.widget.a$b r1 = androidx.constraintlayout.widget.a.b.FLOAT_TYPE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f1972a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.constraintlayout.widget.a$b r1 = androidx.constraintlayout.widget.a.b.DIMENSION_TYPE     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.a.C0014a.<clinit>():void");
        }
    }

    public enum b {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE,
        REFERENCE_TYPE
    }

    public a(a aVar, Object obj) {
        this.f1965b = aVar.f1965b;
        this.f1966c = aVar.f1966c;
        k(obj);
    }

    public a(String str, b bVar, Object obj, boolean z10) {
        this.f1965b = str;
        this.f1966c = bVar;
        this.f1964a = z10;
        k(obj);
    }

    public static HashMap<String, a> b(HashMap<String, a> hashMap, View view) {
        a aVar;
        HashMap<String, a> hashMap2 = new HashMap<>();
        Class<?> cls = view.getClass();
        for (String next : hashMap.keySet()) {
            a aVar2 = hashMap.get(next);
            try {
                if (next.equals("BackgroundColor")) {
                    aVar = new a(aVar2, Integer.valueOf(((ColorDrawable) view.getBackground()).getColor()));
                } else {
                    aVar = new a(aVar2, cls.getMethod("getMap" + next, new Class[0]).invoke(view, new Object[0]));
                }
                hashMap2.put(next, aVar);
            } catch (NoSuchMethodException e10) {
                e10.printStackTrace();
            } catch (IllegalAccessException e11) {
                e11.printStackTrace();
            } catch (InvocationTargetException e12) {
                e12.printStackTrace();
            }
        }
        return hashMap2;
    }

    public static void i(Context context, XmlPullParser xmlPullParser, HashMap<String, a> hashMap) {
        b bVar;
        int resourceId;
        Object string;
        b bVar2;
        float f10;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), f.CustomAttribute);
        int indexCount = obtainStyledAttributes.getIndexCount();
        String str = null;
        Object obj = null;
        b bVar3 = null;
        boolean z10 = false;
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = obtainStyledAttributes.getIndex(i10);
            if (index == f.CustomAttribute_attributeName) {
                str = obtainStyledAttributes.getString(index);
                if (str != null && str.length() > 0) {
                    str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
                }
            } else if (index == f.CustomAttribute_methodName) {
                str = obtainStyledAttributes.getString(index);
                z10 = true;
            } else if (index == f.CustomAttribute_customBoolean) {
                obj = Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                bVar3 = b.BOOLEAN_TYPE;
            } else {
                if (index == f.CustomAttribute_customColorValue) {
                    bVar = b.COLOR_TYPE;
                } else if (index == f.CustomAttribute_customColorDrawableValue) {
                    bVar = b.COLOR_DRAWABLE_TYPE;
                } else {
                    if (index == f.CustomAttribute_customPixelDimension) {
                        bVar2 = b.DIMENSION_TYPE;
                        f10 = TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics());
                    } else if (index == f.CustomAttribute_customDimension) {
                        bVar2 = b.DIMENSION_TYPE;
                        f10 = obtainStyledAttributes.getDimension(index, 0.0f);
                    } else if (index == f.CustomAttribute_customFloatValue) {
                        bVar2 = b.FLOAT_TYPE;
                        f10 = obtainStyledAttributes.getFloat(index, Float.NaN);
                    } else {
                        if (index == f.CustomAttribute_customIntegerValue) {
                            bVar = b.INT_TYPE;
                            resourceId = obtainStyledAttributes.getInteger(index, -1);
                        } else if (index == f.CustomAttribute_customStringValue) {
                            bVar = b.STRING_TYPE;
                            string = obtainStyledAttributes.getString(index);
                            Object obj2 = string;
                            bVar3 = bVar;
                            obj = obj2;
                        } else if (index == f.CustomAttribute_customReference) {
                            bVar = b.REFERENCE_TYPE;
                            resourceId = obtainStyledAttributes.getResourceId(index, -1);
                            if (resourceId == -1) {
                                resourceId = obtainStyledAttributes.getInt(index, -1);
                            }
                        }
                        string = Integer.valueOf(resourceId);
                        Object obj22 = string;
                        bVar3 = bVar;
                        obj = obj22;
                    }
                    string = Float.valueOf(f10);
                    Object obj222 = string;
                    bVar3 = bVar;
                    obj = obj222;
                }
                resourceId = obtainStyledAttributes.getColor(index, 0);
                string = Integer.valueOf(resourceId);
                Object obj2222 = string;
                bVar3 = bVar;
                obj = obj2222;
            }
        }
        if (!(str == null || obj == null)) {
            hashMap.put(str, new a(str, bVar3, obj, z10));
        }
        obtainStyledAttributes.recycle();
    }

    public static void j(View view, HashMap<String, a> hashMap) {
        String str;
        Class<?> cls = view.getClass();
        for (String next : hashMap.keySet()) {
            a aVar = hashMap.get(next);
            if (!aVar.f1964a) {
                str = "set" + next;
            } else {
                str = next;
            }
            try {
                switch (C0014a.f1972a[aVar.f1966c.ordinal()]) {
                    case 1:
                        cls.getMethod(str, new Class[]{Integer.TYPE}).invoke(view, new Object[]{Integer.valueOf(aVar.f1967d)});
                        break;
                    case 2:
                        cls.getMethod(str, new Class[]{Boolean.TYPE}).invoke(view, new Object[]{Boolean.valueOf(aVar.f1970g)});
                        break;
                    case 3:
                        cls.getMethod(str, new Class[]{CharSequence.class}).invoke(view, new Object[]{aVar.f1969f});
                        break;
                    case 4:
                        cls.getMethod(str, new Class[]{Integer.TYPE}).invoke(view, new Object[]{Integer.valueOf(aVar.f1971h)});
                        break;
                    case 5:
                        Method method = cls.getMethod(str, new Class[]{Drawable.class});
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(aVar.f1971h);
                        method.invoke(view, new Object[]{colorDrawable});
                        break;
                    case 6:
                        cls.getMethod(str, new Class[]{Integer.TYPE}).invoke(view, new Object[]{Integer.valueOf(aVar.f1967d)});
                        break;
                    case 7:
                        cls.getMethod(str, new Class[]{Float.TYPE}).invoke(view, new Object[]{Float.valueOf(aVar.f1968e)});
                        break;
                    case 8:
                        cls.getMethod(str, new Class[]{Float.TYPE}).invoke(view, new Object[]{Float.valueOf(aVar.f1968e)});
                        break;
                }
            } catch (NoSuchMethodException e10) {
                Log.e("TransitionLayout", e10.getMessage());
                Log.e("TransitionLayout", " Custom Attribute \"" + next + "\" not found on " + cls.getName());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(cls.getName());
                sb2.append(" must have a method ");
                sb2.append(str);
                Log.e("TransitionLayout", sb2.toString());
            } catch (IllegalAccessException e11) {
                Log.e("TransitionLayout", " Custom Attribute \"" + next + "\" not found on " + cls.getName());
                e11.printStackTrace();
            } catch (InvocationTargetException e12) {
                Log.e("TransitionLayout", " Custom Attribute \"" + next + "\" not found on " + cls.getName());
                e12.printStackTrace();
            }
        }
    }

    public void a(View view) {
        String str;
        Class<?> cls = view.getClass();
        String str2 = this.f1965b;
        if (!this.f1964a) {
            str = "set" + str2;
        } else {
            str = str2;
        }
        try {
            switch (C0014a.f1972a[this.f1966c.ordinal()]) {
                case 1:
                case 6:
                    cls.getMethod(str, new Class[]{Integer.TYPE}).invoke(view, new Object[]{Integer.valueOf(this.f1967d)});
                    return;
                case 2:
                    cls.getMethod(str, new Class[]{Boolean.TYPE}).invoke(view, new Object[]{Boolean.valueOf(this.f1970g)});
                    return;
                case 3:
                    cls.getMethod(str, new Class[]{CharSequence.class}).invoke(view, new Object[]{this.f1969f});
                    return;
                case 4:
                    cls.getMethod(str, new Class[]{Integer.TYPE}).invoke(view, new Object[]{Integer.valueOf(this.f1971h)});
                    return;
                case 5:
                    Method method = cls.getMethod(str, new Class[]{Drawable.class});
                    ColorDrawable colorDrawable = new ColorDrawable();
                    colorDrawable.setColor(this.f1971h);
                    method.invoke(view, new Object[]{colorDrawable});
                    return;
                case 7:
                    cls.getMethod(str, new Class[]{Float.TYPE}).invoke(view, new Object[]{Float.valueOf(this.f1968e)});
                    return;
                case 8:
                    cls.getMethod(str, new Class[]{Float.TYPE}).invoke(view, new Object[]{Float.valueOf(this.f1968e)});
                    return;
                default:
                    return;
            }
        } catch (NoSuchMethodException e10) {
            Log.e("TransitionLayout", e10.getMessage());
            Log.e("TransitionLayout", " Custom Attribute \"" + str2 + "\" not found on " + cls.getName());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cls.getName());
            sb2.append(" must have a method ");
            sb2.append(str);
            Log.e("TransitionLayout", sb2.toString());
        } catch (IllegalAccessException e11) {
            Log.e("TransitionLayout", " Custom Attribute \"" + str2 + "\" not found on " + cls.getName());
            e11.printStackTrace();
        } catch (InvocationTargetException e12) {
            Log.e("TransitionLayout", " Custom Attribute \"" + str2 + "\" not found on " + cls.getName());
            e12.printStackTrace();
        }
    }

    public String c() {
        return this.f1965b;
    }

    public b d() {
        return this.f1966c;
    }

    public float e() {
        switch (C0014a.f1972a[this.f1966c.ordinal()]) {
            case 2:
                return this.f1970g ? 1.0f : 0.0f;
            case 3:
                throw new RuntimeException("Cannot interpolate String");
            case 4:
            case 5:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 6:
                return (float) this.f1967d;
            case 7:
                return this.f1968e;
            case 8:
                return this.f1968e;
            default:
                return Float.NaN;
        }
    }

    public void f(float[] fArr) {
        switch (C0014a.f1972a[this.f1966c.ordinal()]) {
            case 2:
                fArr[0] = this.f1970g ? 1.0f : 0.0f;
                return;
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
            case 5:
                int i10 = this.f1971h;
                float pow = (float) Math.pow((double) (((float) ((i10 >> 16) & 255)) / 255.0f), 2.2d);
                float pow2 = (float) Math.pow((double) (((float) ((i10 >> 8) & 255)) / 255.0f), 2.2d);
                fArr[0] = pow;
                fArr[1] = pow2;
                fArr[2] = (float) Math.pow((double) (((float) (i10 & 255)) / 255.0f), 2.2d);
                fArr[3] = ((float) ((i10 >> 24) & 255)) / 255.0f;
                return;
            case 6:
                fArr[0] = (float) this.f1967d;
                return;
            case 7:
                fArr[0] = this.f1968e;
                return;
            case 8:
                fArr[0] = this.f1968e;
                return;
            default:
                return;
        }
    }

    public boolean g() {
        int i10 = C0014a.f1972a[this.f1966c.ordinal()];
        return (i10 == 1 || i10 == 2 || i10 == 3) ? false : true;
    }

    public int h() {
        int i10 = C0014a.f1972a[this.f1966c.ordinal()];
        return (i10 == 4 || i10 == 5) ? 4 : 1;
    }

    public void k(Object obj) {
        switch (C0014a.f1972a[this.f1966c.ordinal()]) {
            case 1:
            case 6:
                this.f1967d = ((Integer) obj).intValue();
                return;
            case 2:
                this.f1970g = ((Boolean) obj).booleanValue();
                return;
            case 3:
                this.f1969f = (String) obj;
                return;
            case 4:
            case 5:
                this.f1971h = ((Integer) obj).intValue();
                return;
            case 7:
            case 8:
                this.f1968e = ((Float) obj).floatValue();
                return;
            default:
                return;
        }
    }
}
