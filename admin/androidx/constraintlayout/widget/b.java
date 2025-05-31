package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f1982a;

    /* renamed from: b  reason: collision with root package name */
    c f1983b;

    /* renamed from: c  reason: collision with root package name */
    int f1984c = -1;

    /* renamed from: d  reason: collision with root package name */
    int f1985d = -1;

    /* renamed from: e  reason: collision with root package name */
    private SparseArray<a> f1986e = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    private SparseArray<c> f1987f = new SparseArray<>();

    static class a {

        /* renamed from: a  reason: collision with root package name */
        int f1988a;

        /* renamed from: b  reason: collision with root package name */
        ArrayList<C0015b> f1989b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        int f1990c = -1;

        /* renamed from: d  reason: collision with root package name */
        c f1991d;

        public a(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), f.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == f.State_android_id) {
                    this.f1988a = obtainStyledAttributes.getResourceId(index, this.f1988a);
                } else if (index == f.State_constraints) {
                    this.f1990c = obtainStyledAttributes.getResourceId(index, this.f1990c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f1990c);
                    context.getResources().getResourceName(this.f1990c);
                    if ("layout".equals(resourceTypeName)) {
                        c cVar = new c();
                        this.f1991d = cVar;
                        cVar.o(context, this.f1990c);
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        public void a(C0015b bVar) {
            this.f1989b.add(bVar);
        }

        public int b(float f10, float f11) {
            for (int i10 = 0; i10 < this.f1989b.size(); i10++) {
                if (this.f1989b.get(i10).a(f10, f11)) {
                    return i10;
                }
            }
            return -1;
        }
    }

    /* renamed from: androidx.constraintlayout.widget.b$b  reason: collision with other inner class name */
    static class C0015b {

        /* renamed from: a  reason: collision with root package name */
        float f1992a = Float.NaN;

        /* renamed from: b  reason: collision with root package name */
        float f1993b = Float.NaN;

        /* renamed from: c  reason: collision with root package name */
        float f1994c = Float.NaN;

        /* renamed from: d  reason: collision with root package name */
        float f1995d = Float.NaN;

        /* renamed from: e  reason: collision with root package name */
        int f1996e = -1;

        /* renamed from: f  reason: collision with root package name */
        c f1997f;

        public C0015b(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), f.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == f.Variant_constraints) {
                    this.f1996e = obtainStyledAttributes.getResourceId(index, this.f1996e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f1996e);
                    context.getResources().getResourceName(this.f1996e);
                    if ("layout".equals(resourceTypeName)) {
                        c cVar = new c();
                        this.f1997f = cVar;
                        cVar.o(context, this.f1996e);
                    }
                } else if (index == f.Variant_region_heightLessThan) {
                    this.f1995d = obtainStyledAttributes.getDimension(index, this.f1995d);
                } else if (index == f.Variant_region_heightMoreThan) {
                    this.f1993b = obtainStyledAttributes.getDimension(index, this.f1993b);
                } else if (index == f.Variant_region_widthLessThan) {
                    this.f1994c = obtainStyledAttributes.getDimension(index, this.f1994c);
                } else if (index == f.Variant_region_widthMoreThan) {
                    this.f1992a = obtainStyledAttributes.getDimension(index, this.f1992a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        public boolean a(float f10, float f11) {
            if (!Float.isNaN(this.f1992a) && f10 < this.f1992a) {
                return false;
            }
            if (!Float.isNaN(this.f1993b) && f11 < this.f1993b) {
                return false;
            }
            if (Float.isNaN(this.f1994c) || f10 <= this.f1994c) {
                return Float.isNaN(this.f1995d) || f11 <= this.f1995d;
            }
            return false;
        }
    }

    b(Context context, ConstraintLayout constraintLayout, int i10) {
        this.f1982a = constraintLayout;
        a(context, i10);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.content.Context r9, int r10) {
        /*
            r8 = this;
            android.content.res.Resources r0 = r9.getResources()
            android.content.res.XmlResourceParser r10 = r0.getXml(r10)
            r0 = 0
            int r1 = r10.getEventType()     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
        L_0x000d:
            r2 = 1
            if (r1 == r2) goto L_0x008c
            if (r1 == 0) goto L_0x007b
            r3 = 2
            if (r1 == r3) goto L_0x0017
            goto L_0x007e
        L_0x0017:
            java.lang.String r1 = r10.getName()     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            r4 = -1
            int r5 = r1.hashCode()     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            r6 = 4
            r7 = 3
            switch(r5) {
                case -1349929691: goto L_0x004d;
                case 80204913: goto L_0x0043;
                case 1382829617: goto L_0x003a;
                case 1657696882: goto L_0x0030;
                case 1901439077: goto L_0x0026;
                default: goto L_0x0025;
            }     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
        L_0x0025:
            goto L_0x0057
        L_0x0026:
            java.lang.String r2 = "Variant"
            boolean r1 = r1.equals(r2)     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            if (r1 == 0) goto L_0x0057
            r2 = r7
            goto L_0x0058
        L_0x0030:
            java.lang.String r2 = "layoutDescription"
            boolean r1 = r1.equals(r2)     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            if (r1 == 0) goto L_0x0057
            r2 = 0
            goto L_0x0058
        L_0x003a:
            java.lang.String r5 = "StateSet"
            boolean r1 = r1.equals(r5)     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            if (r1 == 0) goto L_0x0057
            goto L_0x0058
        L_0x0043:
            java.lang.String r2 = "State"
            boolean r1 = r1.equals(r2)     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            if (r1 == 0) goto L_0x0057
            r2 = r3
            goto L_0x0058
        L_0x004d:
            java.lang.String r2 = "ConstraintSet"
            boolean r1 = r1.equals(r2)     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            if (r1 == 0) goto L_0x0057
            r2 = r6
            goto L_0x0058
        L_0x0057:
            r2 = r4
        L_0x0058:
            if (r2 == r3) goto L_0x006e
            if (r2 == r7) goto L_0x0063
            if (r2 == r6) goto L_0x005f
            goto L_0x007e
        L_0x005f:
            r8.b(r9, r10)     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            goto L_0x007e
        L_0x0063:
            androidx.constraintlayout.widget.b$b r1 = new androidx.constraintlayout.widget.b$b     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            r1.<init>(r9, r10)     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            if (r0 == 0) goto L_0x007e
            r0.a(r1)     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            goto L_0x007e
        L_0x006e:
            androidx.constraintlayout.widget.b$a r0 = new androidx.constraintlayout.widget.b$a     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            r0.<init>(r9, r10)     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            android.util.SparseArray<androidx.constraintlayout.widget.b$a> r1 = r8.f1986e     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            int r2 = r0.f1988a     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            r1.put(r2, r0)     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            goto L_0x007e
        L_0x007b:
            r10.getName()     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
        L_0x007e:
            int r1 = r10.next()     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            goto L_0x000d
        L_0x0083:
            r9 = move-exception
            r9.printStackTrace()
            goto L_0x008c
        L_0x0088:
            r9 = move-exception
            r9.printStackTrace()
        L_0x008c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.b.a(android.content.Context, int):void");
    }

    private void b(Context context, XmlPullParser xmlPullParser) {
        int i10;
        c cVar = new c();
        int attributeCount = xmlPullParser.getAttributeCount();
        int i11 = 0;
        while (i11 < attributeCount) {
            String attributeName = xmlPullParser.getAttributeName(i11);
            String attributeValue = xmlPullParser.getAttributeValue(i11);
            if (attributeName == null || attributeValue == null || !"id".equals(attributeName)) {
                i11++;
            } else {
                if (attributeValue.contains("/")) {
                    i10 = context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName());
                } else {
                    i10 = -1;
                }
                if (i10 == -1) {
                    if (attributeValue.length() > 1) {
                        i10 = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                cVar.E(context, xmlPullParser);
                this.f1987f.put(i10, cVar);
                return;
            }
        }
    }

    public void c(d dVar) {
    }

    public void d(int i10, float f10, float f11) {
        int b10;
        int i11 = this.f1984c;
        if (i11 == i10) {
            a aVar = (a) (i10 == -1 ? this.f1986e.valueAt(0) : this.f1986e.get(i11));
            int i12 = this.f1985d;
            if ((i12 == -1 || !aVar.f1989b.get(i12).a(f10, f11)) && this.f1985d != (b10 = aVar.b(f10, f11))) {
                c cVar = b10 == -1 ? this.f1983b : aVar.f1989b.get(b10).f1997f;
                if (b10 != -1) {
                    int i13 = aVar.f1989b.get(b10).f1996e;
                }
                if (cVar != null) {
                    this.f1985d = b10;
                    cVar.i(this.f1982a);
                    return;
                }
                return;
            }
            return;
        }
        this.f1984c = i10;
        a aVar2 = this.f1986e.get(i10);
        int b11 = aVar2.b(f10, f11);
        c cVar2 = b11 == -1 ? aVar2.f1991d : aVar2.f1989b.get(b11).f1997f;
        if (b11 != -1) {
            int i14 = aVar2.f1989b.get(b11).f1996e;
        }
        if (cVar2 == null) {
            Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + i10 + ", dim =" + f10 + ", " + f11);
            return;
        }
        this.f1985d = b11;
        cVar2.i(this.f1982a);
    }
}
