package androidx.navigation;

import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;

public abstract class o<T> {

    /* renamed from: b  reason: collision with root package name */
    public static final o<Integer> f3213b = new c(false);

    /* renamed from: c  reason: collision with root package name */
    public static final o<Integer> f3214c = new d(false);

    /* renamed from: d  reason: collision with root package name */
    public static final o<int[]> f3215d = new e(true);

    /* renamed from: e  reason: collision with root package name */
    public static final o<Long> f3216e = new f(false);

    /* renamed from: f  reason: collision with root package name */
    public static final o<long[]> f3217f = new g(true);

    /* renamed from: g  reason: collision with root package name */
    public static final o<Float> f3218g = new h(false);

    /* renamed from: h  reason: collision with root package name */
    public static final o<float[]> f3219h = new i(true);

    /* renamed from: i  reason: collision with root package name */
    public static final o<Boolean> f3220i = new j(false);

    /* renamed from: j  reason: collision with root package name */
    public static final o<boolean[]> f3221j = new k(true);

    /* renamed from: k  reason: collision with root package name */
    public static final o<String> f3222k = new a(true);

    /* renamed from: l  reason: collision with root package name */
    public static final o<String[]> f3223l = new b(true);

    /* renamed from: a  reason: collision with root package name */
    private final boolean f3224a;

    class a extends o<String> {
        a(boolean z10) {
            super(z10);
        }

        public String c() {
            return "string";
        }

        /* renamed from: j */
        public String b(Bundle bundle, String str) {
            return (String) bundle.get(str);
        }

        /* renamed from: k */
        public String h(String str) {
            return str;
        }

        /* renamed from: l */
        public void i(Bundle bundle, String str, String str2) {
            bundle.putString(str, str2);
        }
    }

    class b extends o<String[]> {
        b(boolean z10) {
            super(z10);
        }

        public String c() {
            return "string[]";
        }

        /* renamed from: j */
        public String[] b(Bundle bundle, String str) {
            return (String[]) bundle.get(str);
        }

        /* renamed from: k */
        public String[] h(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* renamed from: l */
        public void i(Bundle bundle, String str, String[] strArr) {
            bundle.putStringArray(str, strArr);
        }
    }

    class c extends o<Integer> {
        c(boolean z10) {
            super(z10);
        }

        public String c() {
            return "integer";
        }

        /* renamed from: j */
        public Integer b(Bundle bundle, String str) {
            return (Integer) bundle.get(str);
        }

        /* renamed from: k */
        public Integer h(String str) {
            return Integer.valueOf(str.startsWith("0x") ? Integer.parseInt(str.substring(2), 16) : Integer.parseInt(str));
        }

        /* renamed from: l */
        public void i(Bundle bundle, String str, Integer num) {
            bundle.putInt(str, num.intValue());
        }
    }

    class d extends o<Integer> {
        d(boolean z10) {
            super(z10);
        }

        public String c() {
            return "reference";
        }

        /* renamed from: j */
        public Integer b(Bundle bundle, String str) {
            return (Integer) bundle.get(str);
        }

        /* renamed from: k */
        public Integer h(String str) {
            return Integer.valueOf(str.startsWith("0x") ? Integer.parseInt(str.substring(2), 16) : Integer.parseInt(str));
        }

        /* renamed from: l */
        public void i(Bundle bundle, String str, Integer num) {
            bundle.putInt(str, num.intValue());
        }
    }

    class e extends o<int[]> {
        e(boolean z10) {
            super(z10);
        }

        public String c() {
            return "integer[]";
        }

        /* renamed from: j */
        public int[] b(Bundle bundle, String str) {
            return (int[]) bundle.get(str);
        }

        /* renamed from: k */
        public int[] h(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* renamed from: l */
        public void i(Bundle bundle, String str, int[] iArr) {
            bundle.putIntArray(str, iArr);
        }
    }

    class f extends o<Long> {
        f(boolean z10) {
            super(z10);
        }

        public String c() {
            return "long";
        }

        /* renamed from: j */
        public Long b(Bundle bundle, String str) {
            return (Long) bundle.get(str);
        }

        /* renamed from: k */
        public Long h(String str) {
            if (str.endsWith("L")) {
                str = str.substring(0, str.length() - 1);
            }
            return Long.valueOf(str.startsWith("0x") ? Long.parseLong(str.substring(2), 16) : Long.parseLong(str));
        }

        /* renamed from: l */
        public void i(Bundle bundle, String str, Long l10) {
            bundle.putLong(str, l10.longValue());
        }
    }

    class g extends o<long[]> {
        g(boolean z10) {
            super(z10);
        }

        public String c() {
            return "long[]";
        }

        /* renamed from: j */
        public long[] b(Bundle bundle, String str) {
            return (long[]) bundle.get(str);
        }

        /* renamed from: k */
        public long[] h(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* renamed from: l */
        public void i(Bundle bundle, String str, long[] jArr) {
            bundle.putLongArray(str, jArr);
        }
    }

    class h extends o<Float> {
        h(boolean z10) {
            super(z10);
        }

        public String c() {
            return "float";
        }

        /* renamed from: j */
        public Float b(Bundle bundle, String str) {
            return (Float) bundle.get(str);
        }

        /* renamed from: k */
        public Float h(String str) {
            return Float.valueOf(Float.parseFloat(str));
        }

        /* renamed from: l */
        public void i(Bundle bundle, String str, Float f10) {
            bundle.putFloat(str, f10.floatValue());
        }
    }

    class i extends o<float[]> {
        i(boolean z10) {
            super(z10);
        }

        public String c() {
            return "float[]";
        }

        /* renamed from: j */
        public float[] b(Bundle bundle, String str) {
            return (float[]) bundle.get(str);
        }

        /* renamed from: k */
        public float[] h(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* renamed from: l */
        public void i(Bundle bundle, String str, float[] fArr) {
            bundle.putFloatArray(str, fArr);
        }
    }

    class j extends o<Boolean> {
        j(boolean z10) {
            super(z10);
        }

        public String c() {
            return "boolean";
        }

        /* renamed from: j */
        public Boolean b(Bundle bundle, String str) {
            return (Boolean) bundle.get(str);
        }

        /* renamed from: k */
        public Boolean h(String str) {
            if ("true".equals(str)) {
                return Boolean.TRUE;
            }
            if ("false".equals(str)) {
                return Boolean.FALSE;
            }
            throw new IllegalArgumentException("A boolean NavType only accepts \"true\" or \"false\" values.");
        }

        /* renamed from: l */
        public void i(Bundle bundle, String str, Boolean bool) {
            bundle.putBoolean(str, bool.booleanValue());
        }
    }

    class k extends o<boolean[]> {
        k(boolean z10) {
            super(z10);
        }

        public String c() {
            return "boolean[]";
        }

        /* renamed from: j */
        public boolean[] b(Bundle bundle, String str) {
            return (boolean[]) bundle.get(str);
        }

        /* renamed from: k */
        public boolean[] h(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* renamed from: l */
        public void i(Bundle bundle, String str, boolean[] zArr) {
            bundle.putBooleanArray(str, zArr);
        }
    }

    public static final class l<D extends Enum> extends p<D> {

        /* renamed from: n  reason: collision with root package name */
        private final Class<D> f3225n;

        public l(Class<D> cls) {
            super(false, cls);
            if (cls.isEnum()) {
                this.f3225n = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " is not an Enum type.");
        }

        public String c() {
            return this.f3225n.getName();
        }

        /* renamed from: m */
        public D k(String str) {
            for (D d10 : (Enum[]) this.f3225n.getEnumConstants()) {
                if (d10.name().equals(str)) {
                    return d10;
                }
            }
            throw new IllegalArgumentException("Enum value " + str + " not found for type " + this.f3225n.getName() + ".");
        }
    }

    public static final class m<D extends Parcelable> extends o<D[]> {

        /* renamed from: m  reason: collision with root package name */
        private final Class<D[]> f3226m;

        public m(Class<D> cls) {
            super(true);
            if (Parcelable.class.isAssignableFrom(cls)) {
                try {
                    this.f3226m = Class.forName("[L" + cls.getName() + ";");
                } catch (ClassNotFoundException e10) {
                    throw new RuntimeException(e10);
                }
            } else {
                throw new IllegalArgumentException(cls + " does not implement Parcelable.");
            }
        }

        public String c() {
            return this.f3226m.getName();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || m.class != obj.getClass()) {
                return false;
            }
            return this.f3226m.equals(((m) obj).f3226m);
        }

        public int hashCode() {
            return this.f3226m.hashCode();
        }

        /* renamed from: j */
        public D[] b(Bundle bundle, String str) {
            return (Parcelable[]) bundle.get(str);
        }

        /* renamed from: k */
        public D[] h(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* renamed from: l */
        public void i(Bundle bundle, String str, D[] dArr) {
            this.f3226m.cast(dArr);
            bundle.putParcelableArray(str, dArr);
        }
    }

    public static final class n<D> extends o<D> {

        /* renamed from: m  reason: collision with root package name */
        private final Class<D> f3227m;

        public n(Class<D> cls) {
            super(true);
            if (Parcelable.class.isAssignableFrom(cls) || Serializable.class.isAssignableFrom(cls)) {
                this.f3227m = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " does not implement Parcelable or Serializable.");
        }

        public D b(Bundle bundle, String str) {
            return bundle.get(str);
        }

        public String c() {
            return this.f3227m.getName();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || n.class != obj.getClass()) {
                return false;
            }
            return this.f3227m.equals(((n) obj).f3227m);
        }

        public D h(String str) {
            throw new UnsupportedOperationException("Parcelables don't support default values.");
        }

        public int hashCode() {
            return this.f3227m.hashCode();
        }

        public void i(Bundle bundle, String str, D d10) {
            this.f3227m.cast(d10);
            if (d10 == null || (d10 instanceof Parcelable)) {
                bundle.putParcelable(str, (Parcelable) d10);
            } else if (d10 instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) d10);
            }
        }
    }

    /* renamed from: androidx.navigation.o$o  reason: collision with other inner class name */
    public static final class C0033o<D extends Serializable> extends o<D[]> {

        /* renamed from: m  reason: collision with root package name */
        private final Class<D[]> f3228m;

        public C0033o(Class<D> cls) {
            super(true);
            if (Serializable.class.isAssignableFrom(cls)) {
                try {
                    this.f3228m = Class.forName("[L" + cls.getName() + ";");
                } catch (ClassNotFoundException e10) {
                    throw new RuntimeException(e10);
                }
            } else {
                throw new IllegalArgumentException(cls + " does not implement Serializable.");
            }
        }

        public String c() {
            return this.f3228m.getName();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C0033o.class != obj.getClass()) {
                return false;
            }
            return this.f3228m.equals(((C0033o) obj).f3228m);
        }

        public int hashCode() {
            return this.f3228m.hashCode();
        }

        /* renamed from: j */
        public D[] b(Bundle bundle, String str) {
            return (Serializable[]) bundle.get(str);
        }

        /* renamed from: k */
        public D[] h(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* JADX WARNING: type inference failed for: r4v0, types: [D[], java.lang.Object, java.io.Serializable] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* renamed from: l */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void i(android.os.Bundle r2, java.lang.String r3, D[] r4) {
            /*
                r1 = this;
                java.lang.Class<D[]> r0 = r1.f3228m
                r0.cast(r4)
                r2.putSerializable(r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.o.C0033o.i(android.os.Bundle, java.lang.String, java.io.Serializable[]):void");
        }
    }

    public static class p<D extends Serializable> extends o<D> {

        /* renamed from: m  reason: collision with root package name */
        private final Class<D> f3229m;

        public p(Class<D> cls) {
            super(true);
            if (!Serializable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException(cls + " does not implement Serializable.");
            } else if (!cls.isEnum()) {
                this.f3229m = cls;
            } else {
                throw new IllegalArgumentException(cls + " is an Enum. You should use EnumType instead.");
            }
        }

        p(boolean z10, Class<D> cls) {
            super(z10);
            if (Serializable.class.isAssignableFrom(cls)) {
                this.f3229m = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " does not implement Serializable.");
        }

        public String c() {
            return this.f3229m.getName();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof p)) {
                return false;
            }
            return this.f3229m.equals(((p) obj).f3229m);
        }

        public int hashCode() {
            return this.f3229m.hashCode();
        }

        /* renamed from: j */
        public D b(Bundle bundle, String str) {
            return (Serializable) bundle.get(str);
        }

        /* renamed from: k */
        public D h(String str) {
            throw new UnsupportedOperationException("Serializables don't support default values.");
        }

        /* renamed from: l */
        public void i(Bundle bundle, String str, D d10) {
            this.f3229m.cast(d10);
            bundle.putSerializable(str, d10);
        }
    }

    o(boolean z10) {
        this.f3224a = z10;
    }

    public static o<?> a(String str, String str2) {
        String str3;
        o<Integer> oVar = f3213b;
        if (oVar.c().equals(str)) {
            return oVar;
        }
        o<int[]> oVar2 = f3215d;
        if (oVar2.c().equals(str)) {
            return oVar2;
        }
        o<Long> oVar3 = f3216e;
        if (oVar3.c().equals(str)) {
            return oVar3;
        }
        o<long[]> oVar4 = f3217f;
        if (oVar4.c().equals(str)) {
            return oVar4;
        }
        o<Boolean> oVar5 = f3220i;
        if (oVar5.c().equals(str)) {
            return oVar5;
        }
        o<boolean[]> oVar6 = f3221j;
        if (oVar6.c().equals(str)) {
            return oVar6;
        }
        o<String> oVar7 = f3222k;
        if (oVar7.c().equals(str)) {
            return oVar7;
        }
        o<String[]> oVar8 = f3223l;
        if (oVar8.c().equals(str)) {
            return oVar8;
        }
        o<Float> oVar9 = f3218g;
        if (oVar9.c().equals(str)) {
            return oVar9;
        }
        o<float[]> oVar10 = f3219h;
        if (oVar10.c().equals(str)) {
            return oVar10;
        }
        o<Integer> oVar11 = f3214c;
        if (oVar11.c().equals(str)) {
            return oVar11;
        }
        if (str == null || str.isEmpty()) {
            return oVar7;
        }
        try {
            if (!str.startsWith(".") || str2 == null) {
                str3 = str;
            } else {
                str3 = str2 + str;
            }
            if (str.endsWith("[]")) {
                str3 = str3.substring(0, str3.length() - 2);
                Class<?> cls = Class.forName(str3);
                if (Parcelable.class.isAssignableFrom(cls)) {
                    return new m(cls);
                }
                if (Serializable.class.isAssignableFrom(cls)) {
                    return new C0033o(cls);
                }
            } else {
                Class<?> cls2 = Class.forName(str3);
                if (Parcelable.class.isAssignableFrom(cls2)) {
                    return new n(cls2);
                }
                if (Enum.class.isAssignableFrom(cls2)) {
                    return new l(cls2);
                }
                if (Serializable.class.isAssignableFrom(cls2)) {
                    return new p(cls2);
                }
            }
            throw new IllegalArgumentException(str3 + " is not Serializable or Parcelable.");
        } catch (ClassNotFoundException e10) {
            throw new RuntimeException(e10);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:3|4|5) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:6|7|8) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r0 = f3220i;
        r0.h(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001a, code lost:
        return f3222k;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:?, code lost:
        r0 = f3216e;
        r0.h(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000b, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r0 = f3218g;
        r0.h(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
        return r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0006 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x000c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static androidx.navigation.o d(java.lang.String r1) {
        /*
            androidx.navigation.o<java.lang.Integer> r0 = f3213b     // Catch:{ IllegalArgumentException -> 0x0006 }
            r0.h(r1)     // Catch:{ IllegalArgumentException -> 0x0006 }
            return r0
        L_0x0006:
            androidx.navigation.o<java.lang.Long> r0 = f3216e     // Catch:{ IllegalArgumentException -> 0x000c }
            r0.h(r1)     // Catch:{ IllegalArgumentException -> 0x000c }
            return r0
        L_0x000c:
            androidx.navigation.o<java.lang.Float> r0 = f3218g     // Catch:{ IllegalArgumentException -> 0x0012 }
            r0.h(r1)     // Catch:{ IllegalArgumentException -> 0x0012 }
            return r0
        L_0x0012:
            androidx.navigation.o<java.lang.Boolean> r0 = f3220i     // Catch:{ IllegalArgumentException -> 0x0018 }
            r0.h(r1)     // Catch:{ IllegalArgumentException -> 0x0018 }
            return r0
        L_0x0018:
            androidx.navigation.o<java.lang.String> r1 = f3222k
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.o.d(java.lang.String):androidx.navigation.o");
    }

    static o e(Object obj) {
        if (obj instanceof Integer) {
            return f3213b;
        }
        if (obj instanceof int[]) {
            return f3215d;
        }
        if (obj instanceof Long) {
            return f3216e;
        }
        if (obj instanceof long[]) {
            return f3217f;
        }
        if (obj instanceof Float) {
            return f3218g;
        }
        if (obj instanceof float[]) {
            return f3219h;
        }
        if (obj instanceof Boolean) {
            return f3220i;
        }
        if (obj instanceof boolean[]) {
            return f3221j;
        }
        if ((obj instanceof String) || obj == null) {
            return f3222k;
        }
        if (obj instanceof String[]) {
            return f3223l;
        }
        if (obj.getClass().isArray() && Parcelable.class.isAssignableFrom(obj.getClass().getComponentType())) {
            return new m(obj.getClass().getComponentType());
        }
        if (obj.getClass().isArray() && Serializable.class.isAssignableFrom(obj.getClass().getComponentType())) {
            return new C0033o(obj.getClass().getComponentType());
        }
        if (obj instanceof Parcelable) {
            return new n(obj.getClass());
        }
        if (obj instanceof Enum) {
            return new l(obj.getClass());
        }
        if (obj instanceof Serializable) {
            return new p(obj.getClass());
        }
        throw new IllegalArgumentException("Object of type " + obj.getClass().getName() + " is not supported for navigation arguments.");
    }

    public abstract T b(Bundle bundle, String str);

    public abstract String c();

    public boolean f() {
        return this.f3224a;
    }

    /* access modifiers changed from: package-private */
    public T g(Bundle bundle, String str, String str2) {
        T h10 = h(str2);
        i(bundle, str, h10);
        return h10;
    }

    public abstract T h(String str);

    public abstract void i(Bundle bundle, String str, T t10);

    public String toString() {
        return c();
    }
}
