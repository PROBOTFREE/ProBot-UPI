package androidx.work;

import a2.h;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class c {

    /* renamed from: b  reason: collision with root package name */
    private static final String f4456b = h.f("Data");

    /* renamed from: c  reason: collision with root package name */
    public static final c f4457c = new a().a();

    /* renamed from: a  reason: collision with root package name */
    Map<String, Object> f4458a;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private Map<String, Object> f4459a = new HashMap();

        public c a() {
            c cVar = new c((Map<String, ?>) this.f4459a);
            c.k(cVar);
            return cVar;
        }

        public a b(String str, Object obj) {
            if (obj == null) {
                this.f4459a.put(str, (Object) null);
            } else {
                Class<?> cls = obj.getClass();
                if (cls == Boolean.class || cls == Byte.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class || cls == Boolean[].class || cls == Byte[].class || cls == Integer[].class || cls == Long[].class || cls == Float[].class || cls == Double[].class || cls == String[].class) {
                    this.f4459a.put(str, obj);
                } else if (cls == boolean[].class) {
                    this.f4459a.put(str, c.a((boolean[]) obj));
                } else if (cls == byte[].class) {
                    this.f4459a.put(str, c.b((byte[]) obj));
                } else if (cls == int[].class) {
                    this.f4459a.put(str, c.e((int[]) obj));
                } else if (cls == long[].class) {
                    this.f4459a.put(str, c.f((long[]) obj));
                } else if (cls == float[].class) {
                    this.f4459a.put(str, c.d((float[]) obj));
                } else if (cls == double[].class) {
                    this.f4459a.put(str, c.c((double[]) obj));
                } else {
                    throw new IllegalArgumentException(String.format("Key %s has invalid type %s", new Object[]{str, cls}));
                }
            }
            return this;
        }

        public a c(c cVar) {
            d(cVar.f4458a);
            return this;
        }

        public a d(Map<String, Object> map) {
            for (Map.Entry next : map.entrySet()) {
                b((String) next.getKey(), next.getValue());
            }
            return this;
        }

        public a e(String str, String str2) {
            this.f4459a.put(str, str2);
            return this;
        }
    }

    c() {
    }

    public c(c cVar) {
        this.f4458a = new HashMap(cVar.f4458a);
    }

    public c(Map<String, ?> map) {
        this.f4458a = new HashMap(map);
    }

    public static Boolean[] a(boolean[] zArr) {
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i10 = 0; i10 < zArr.length; i10++) {
            boolArr[i10] = Boolean.valueOf(zArr[i10]);
        }
        return boolArr;
    }

    public static Byte[] b(byte[] bArr) {
        Byte[] bArr2 = new Byte[bArr.length];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            bArr2[i10] = Byte.valueOf(bArr[i10]);
        }
        return bArr2;
    }

    public static Double[] c(double[] dArr) {
        Double[] dArr2 = new Double[dArr.length];
        for (int i10 = 0; i10 < dArr.length; i10++) {
            dArr2[i10] = Double.valueOf(dArr[i10]);
        }
        return dArr2;
    }

    public static Float[] d(float[] fArr) {
        Float[] fArr2 = new Float[fArr.length];
        for (int i10 = 0; i10 < fArr.length; i10++) {
            fArr2[i10] = Float.valueOf(fArr[i10]);
        }
        return fArr2;
    }

    public static Integer[] e(int[] iArr) {
        Integer[] numArr = new Integer[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            numArr[i10] = Integer.valueOf(iArr[i10]);
        }
        return numArr;
    }

    public static Long[] f(long[] jArr) {
        Long[] lArr = new Long[jArr.length];
        for (int i10 = 0; i10 < jArr.length; i10++) {
            lArr[i10] = Long.valueOf(jArr[i10]);
        }
        return lArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e A[SYNTHETIC, Splitter:B:24:0x004e] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006b A[SYNTHETIC, Splitter:B:36:0x006b] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:14:0x0035=Splitter:B:14:0x0035, B:28:0x0058=Splitter:B:28:0x0058} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.work.c g(byte[] r7) {
        /*
            java.lang.String r0 = "Error in Data#fromByteArray: "
            int r1 = r7.length
            r2 = 10240(0x2800, float:1.4349E-41)
            if (r1 > r2) goto L_0x0080
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream
            r2.<init>(r7)
            r7 = 0
            java.io.ObjectInputStream r3 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x0043, ClassNotFoundException -> 0x0041, all -> 0x003d }
            r3.<init>(r2)     // Catch:{ IOException -> 0x0043, ClassNotFoundException -> 0x0041, all -> 0x003d }
            int r7 = r3.readInt()     // Catch:{ IOException -> 0x003b, ClassNotFoundException -> 0x0039 }
        L_0x001b:
            if (r7 <= 0) goto L_0x002b
            java.lang.String r4 = r3.readUTF()     // Catch:{ IOException -> 0x003b, ClassNotFoundException -> 0x0039 }
            java.lang.Object r5 = r3.readObject()     // Catch:{ IOException -> 0x003b, ClassNotFoundException -> 0x0039 }
            r1.put(r4, r5)     // Catch:{ IOException -> 0x003b, ClassNotFoundException -> 0x0039 }
            int r7 = r7 + -1
            goto L_0x001b
        L_0x002b:
            r3.close()     // Catch:{ IOException -> 0x002f }
            goto L_0x0035
        L_0x002f:
            r7 = move-exception
            java.lang.String r3 = f4456b
            android.util.Log.e(r3, r0, r7)
        L_0x0035:
            r2.close()     // Catch:{ IOException -> 0x005c }
            goto L_0x0062
        L_0x0039:
            r7 = move-exception
            goto L_0x0047
        L_0x003b:
            r7 = move-exception
            goto L_0x0047
        L_0x003d:
            r1 = move-exception
            r3 = r7
            r7 = r1
            goto L_0x0069
        L_0x0041:
            r3 = move-exception
            goto L_0x0044
        L_0x0043:
            r3 = move-exception
        L_0x0044:
            r6 = r3
            r3 = r7
            r7 = r6
        L_0x0047:
            java.lang.String r4 = f4456b     // Catch:{ all -> 0x0068 }
            android.util.Log.e(r4, r0, r7)     // Catch:{ all -> 0x0068 }
            if (r3 == 0) goto L_0x0058
            r3.close()     // Catch:{ IOException -> 0x0052 }
            goto L_0x0058
        L_0x0052:
            r7 = move-exception
            java.lang.String r3 = f4456b
            android.util.Log.e(r3, r0, r7)
        L_0x0058:
            r2.close()     // Catch:{ IOException -> 0x005c }
            goto L_0x0062
        L_0x005c:
            r7 = move-exception
            java.lang.String r2 = f4456b
            android.util.Log.e(r2, r0, r7)
        L_0x0062:
            androidx.work.c r7 = new androidx.work.c
            r7.<init>((java.util.Map<java.lang.String, ?>) r1)
            return r7
        L_0x0068:
            r7 = move-exception
        L_0x0069:
            if (r3 == 0) goto L_0x0075
            r3.close()     // Catch:{ IOException -> 0x006f }
            goto L_0x0075
        L_0x006f:
            r1 = move-exception
            java.lang.String r3 = f4456b
            android.util.Log.e(r3, r0, r1)
        L_0x0075:
            r2.close()     // Catch:{ IOException -> 0x0079 }
            goto L_0x007f
        L_0x0079:
            r1 = move-exception
            java.lang.String r2 = f4456b
            android.util.Log.e(r2, r0, r1)
        L_0x007f:
            throw r7
        L_0x0080:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "Data cannot occupy more than 10240 bytes when serialized"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.c.g(byte[]):androidx.work.c");
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0078 A[SYNTHETIC, Splitter:B:31:0x0078] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008f A[SYNTHETIC, Splitter:B:41:0x008f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] k(androidx.work.c r5) {
        /*
            java.lang.String r0 = "Error in Data#toByteArray: "
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            r2 = 0
            java.io.ObjectOutputStream r3 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x006c }
            r3.<init>(r1)     // Catch:{ IOException -> 0x006c }
            int r2 = r5.j()     // Catch:{ IOException -> 0x0067, all -> 0x0064 }
            r3.writeInt(r2)     // Catch:{ IOException -> 0x0067, all -> 0x0064 }
            java.util.Map<java.lang.String, java.lang.Object> r5 = r5.f4458a     // Catch:{ IOException -> 0x0067, all -> 0x0064 }
            java.util.Set r5 = r5.entrySet()     // Catch:{ IOException -> 0x0067, all -> 0x0064 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ IOException -> 0x0067, all -> 0x0064 }
        L_0x001e:
            boolean r2 = r5.hasNext()     // Catch:{ IOException -> 0x0067, all -> 0x0064 }
            if (r2 == 0) goto L_0x003b
            java.lang.Object r2 = r5.next()     // Catch:{ IOException -> 0x0067, all -> 0x0064 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ IOException -> 0x0067, all -> 0x0064 }
            java.lang.Object r4 = r2.getKey()     // Catch:{ IOException -> 0x0067, all -> 0x0064 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ IOException -> 0x0067, all -> 0x0064 }
            r3.writeUTF(r4)     // Catch:{ IOException -> 0x0067, all -> 0x0064 }
            java.lang.Object r2 = r2.getValue()     // Catch:{ IOException -> 0x0067, all -> 0x0064 }
            r3.writeObject(r2)     // Catch:{ IOException -> 0x0067, all -> 0x0064 }
            goto L_0x001e
        L_0x003b:
            r3.close()     // Catch:{ IOException -> 0x003f }
            goto L_0x0045
        L_0x003f:
            r5 = move-exception
            java.lang.String r2 = f4456b
            android.util.Log.e(r2, r0, r5)
        L_0x0045:
            r1.close()     // Catch:{ IOException -> 0x0049 }
            goto L_0x004f
        L_0x0049:
            r5 = move-exception
            java.lang.String r2 = f4456b
            android.util.Log.e(r2, r0, r5)
        L_0x004f:
            int r5 = r1.size()
            r0 = 10240(0x2800, float:1.4349E-41)
            if (r5 > r0) goto L_0x005c
            byte[] r5 = r1.toByteArray()
            return r5
        L_0x005c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Data cannot occupy more than 10240 bytes when serialized"
            r5.<init>(r0)
            throw r5
        L_0x0064:
            r5 = move-exception
            r2 = r3
            goto L_0x008d
        L_0x0067:
            r5 = move-exception
            r2 = r3
            goto L_0x006d
        L_0x006a:
            r5 = move-exception
            goto L_0x008d
        L_0x006c:
            r5 = move-exception
        L_0x006d:
            java.lang.String r3 = f4456b     // Catch:{ all -> 0x006a }
            android.util.Log.e(r3, r0, r5)     // Catch:{ all -> 0x006a }
            byte[] r5 = r1.toByteArray()     // Catch:{ all -> 0x006a }
            if (r2 == 0) goto L_0x0082
            r2.close()     // Catch:{ IOException -> 0x007c }
            goto L_0x0082
        L_0x007c:
            r2 = move-exception
            java.lang.String r3 = f4456b
            android.util.Log.e(r3, r0, r2)
        L_0x0082:
            r1.close()     // Catch:{ IOException -> 0x0086 }
            goto L_0x008c
        L_0x0086:
            r1 = move-exception
            java.lang.String r2 = f4456b
            android.util.Log.e(r2, r0, r1)
        L_0x008c:
            return r5
        L_0x008d:
            if (r2 == 0) goto L_0x0099
            r2.close()     // Catch:{ IOException -> 0x0093 }
            goto L_0x0099
        L_0x0093:
            r2 = move-exception
            java.lang.String r3 = f4456b
            android.util.Log.e(r3, r0, r2)
        L_0x0099:
            r1.close()     // Catch:{ IOException -> 0x009d }
            goto L_0x00a3
        L_0x009d:
            r1 = move-exception
            java.lang.String r2 = f4456b
            android.util.Log.e(r2, r0, r1)
        L_0x00a3:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.c.k(androidx.work.c):byte[]");
    }

    public boolean equals(Object obj) {
        boolean z10;
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        Set<String> keySet = this.f4458a.keySet();
        if (!keySet.equals(cVar.f4458a.keySet())) {
            return false;
        }
        for (String next : keySet) {
            Object obj2 = this.f4458a.get(next);
            Object obj3 = cVar.f4458a.get(next);
            if (obj2 == null || obj3 == null) {
                if (obj2 == obj3) {
                    z10 = true;
                    continue;
                } else {
                    z10 = false;
                    continue;
                }
            } else if (!(obj2 instanceof Object[]) || !(obj3 instanceof Object[])) {
                z10 = obj2.equals(obj3);
                continue;
            } else {
                z10 = Arrays.deepEquals((Object[]) obj2, (Object[]) obj3);
                continue;
            }
            if (!z10) {
                return false;
            }
        }
        return true;
    }

    public Map<String, Object> h() {
        return Collections.unmodifiableMap(this.f4458a);
    }

    public int hashCode() {
        return this.f4458a.hashCode() * 31;
    }

    public String i(String str) {
        Object obj = this.f4458a.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public int j() {
        return this.f4458a.size();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Data {");
        if (!this.f4458a.isEmpty()) {
            for (String next : this.f4458a.keySet()) {
                sb2.append(next);
                sb2.append(" : ");
                Object obj = this.f4458a.get(next);
                if (obj instanceof Object[]) {
                    sb2.append(Arrays.toString((Object[]) obj));
                } else {
                    sb2.append(obj);
                }
                sb2.append(", ");
            }
        }
        sb2.append("}");
        return sb2.toString();
    }
}
