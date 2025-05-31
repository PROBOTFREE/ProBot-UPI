package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

public class h {

    /* renamed from: a  reason: collision with root package name */
    int f2106a = -1;

    /* renamed from: b  reason: collision with root package name */
    int f2107b = -1;

    /* renamed from: c  reason: collision with root package name */
    int f2108c = -1;

    /* renamed from: d  reason: collision with root package name */
    private SparseArray<a> f2109d = new SparseArray<>();

    static class a {

        /* renamed from: a  reason: collision with root package name */
        int f2110a;

        /* renamed from: b  reason: collision with root package name */
        ArrayList<b> f2111b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        int f2112c = -1;

        public a(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), f.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == f.State_android_id) {
                    this.f2110a = obtainStyledAttributes.getResourceId(index, this.f2110a);
                } else if (index == f.State_constraints) {
                    this.f2112c = obtainStyledAttributes.getResourceId(index, this.f2112c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f2112c);
                    context.getResources().getResourceName(this.f2112c);
                    "layout".equals(resourceTypeName);
                }
            }
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        public void a(b bVar) {
            this.f2111b.add(bVar);
        }

        public int b(float f10, float f11) {
            for (int i10 = 0; i10 < this.f2111b.size(); i10++) {
                if (this.f2111b.get(i10).a(f10, f11)) {
                    return i10;
                }
            }
            return -1;
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        float f2113a = Float.NaN;

        /* renamed from: b  reason: collision with root package name */
        float f2114b = Float.NaN;

        /* renamed from: c  reason: collision with root package name */
        float f2115c = Float.NaN;

        /* renamed from: d  reason: collision with root package name */
        float f2116d = Float.NaN;

        /* renamed from: e  reason: collision with root package name */
        int f2117e = -1;

        public b(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), f.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == f.Variant_constraints) {
                    this.f2117e = obtainStyledAttributes.getResourceId(index, this.f2117e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f2117e);
                    context.getResources().getResourceName(this.f2117e);
                    "layout".equals(resourceTypeName);
                } else if (index == f.Variant_region_heightLessThan) {
                    this.f2116d = obtainStyledAttributes.getDimension(index, this.f2116d);
                } else if (index == f.Variant_region_heightMoreThan) {
                    this.f2114b = obtainStyledAttributes.getDimension(index, this.f2114b);
                } else if (index == f.Variant_region_widthLessThan) {
                    this.f2115c = obtainStyledAttributes.getDimension(index, this.f2115c);
                } else if (index == f.Variant_region_widthMoreThan) {
                    this.f2113a = obtainStyledAttributes.getDimension(index, this.f2113a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        public boolean a(float f10, float f11) {
            if (!Float.isNaN(this.f2113a) && f10 < this.f2113a) {
                return false;
            }
            if (!Float.isNaN(this.f2114b) && f11 < this.f2114b) {
                return false;
            }
            if (Float.isNaN(this.f2115c) || f10 <= this.f2115c) {
                return Float.isNaN(this.f2116d) || f11 <= this.f2116d;
            }
            return false;
        }
    }

    public h(Context context, XmlPullParser xmlPullParser) {
        new SparseArray();
        b(context, xmlPullParser);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11) {
        /*
            r9 = this;
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)
            int[] r1 = androidx.constraintlayout.widget.f.StateSet
            android.content.res.TypedArray r0 = r10.obtainStyledAttributes(r0, r1)
            int r1 = r0.getIndexCount()
            r2 = 0
            r3 = r2
        L_0x0010:
            if (r3 >= r1) goto L_0x0025
            int r4 = r0.getIndex(r3)
            int r5 = androidx.constraintlayout.widget.f.StateSet_defaultState
            if (r4 != r5) goto L_0x0022
            int r5 = r9.f2106a
            int r4 = r0.getResourceId(r4, r5)
            r9.f2106a = r4
        L_0x0022:
            int r3 = r3 + 1
            goto L_0x0010
        L_0x0025:
            r0.recycle()
            r0 = 0
            int r1 = r11.getEventType()     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
        L_0x002d:
            r3 = 1
            if (r1 == r3) goto L_0x00a8
            if (r1 == 0) goto L_0x0097
            java.lang.String r4 = "StateSet"
            r5 = 3
            r6 = 2
            if (r1 == r6) goto L_0x0047
            if (r1 == r5) goto L_0x003c
            goto L_0x009a
        L_0x003c:
            java.lang.String r1 = r11.getName()     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            boolean r1 = r4.equals(r1)     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            if (r1 == 0) goto L_0x009a
            return
        L_0x0047:
            java.lang.String r1 = r11.getName()     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            r7 = -1
            int r8 = r1.hashCode()     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            switch(r8) {
                case 80204913: goto L_0x006f;
                case 1301459538: goto L_0x0065;
                case 1382829617: goto L_0x005e;
                case 1901439077: goto L_0x0054;
                default: goto L_0x0053;
            }     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
        L_0x0053:
            goto L_0x0079
        L_0x0054:
            java.lang.String r3 = "Variant"
            boolean r1 = r1.equals(r3)     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            if (r1 == 0) goto L_0x0079
            r3 = r5
            goto L_0x007a
        L_0x005e:
            boolean r1 = r1.equals(r4)     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            if (r1 == 0) goto L_0x0079
            goto L_0x007a
        L_0x0065:
            java.lang.String r3 = "LayoutDescription"
            boolean r1 = r1.equals(r3)     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            if (r1 == 0) goto L_0x0079
            r3 = r2
            goto L_0x007a
        L_0x006f:
            java.lang.String r3 = "State"
            boolean r1 = r1.equals(r3)     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            if (r1 == 0) goto L_0x0079
            r3 = r6
            goto L_0x007a
        L_0x0079:
            r3 = r7
        L_0x007a:
            if (r3 == r6) goto L_0x008a
            if (r3 == r5) goto L_0x007f
            goto L_0x009a
        L_0x007f:
            androidx.constraintlayout.widget.h$b r1 = new androidx.constraintlayout.widget.h$b     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            r1.<init>(r10, r11)     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            if (r0 == 0) goto L_0x009a
            r0.a(r1)     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            goto L_0x009a
        L_0x008a:
            androidx.constraintlayout.widget.h$a r0 = new androidx.constraintlayout.widget.h$a     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            r0.<init>(r10, r11)     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            android.util.SparseArray<androidx.constraintlayout.widget.h$a> r1 = r9.f2109d     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            int r3 = r0.f2110a     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            r1.put(r3, r0)     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            goto L_0x009a
        L_0x0097:
            r11.getName()     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
        L_0x009a:
            int r1 = r11.next()     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            goto L_0x002d
        L_0x009f:
            r10 = move-exception
            r10.printStackTrace()
            goto L_0x00a8
        L_0x00a4:
            r10 = move-exception
            r10.printStackTrace()
        L_0x00a8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.h.b(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public int a(int i10, int i11, float f10, float f11) {
        a aVar = this.f2109d.get(i11);
        if (aVar == null) {
            return i11;
        }
        if (f10 != -1.0f && f11 != -1.0f) {
            b bVar = null;
            Iterator<b> it = aVar.f2111b.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next.a(f10, f11)) {
                    if (i10 == next.f2117e) {
                        return i10;
                    }
                    bVar = next;
                }
            }
            return bVar != null ? bVar.f2117e : aVar.f2112c;
        } else if (aVar.f2112c == i10) {
            return i10;
        } else {
            Iterator<b> it2 = aVar.f2111b.iterator();
            while (it2.hasNext()) {
                if (i10 == it2.next().f2117e) {
                    return i10;
                }
            }
            return aVar.f2112c;
        }
    }

    public int c(int i10, int i11, int i12) {
        return d(-1, i10, (float) i11, (float) i12);
    }

    public int d(int i10, int i11, float f10, float f11) {
        int b10;
        if (i10 == i11) {
            a aVar = (a) (i11 == -1 ? this.f2109d.valueAt(0) : this.f2109d.get(this.f2107b));
            if (aVar == null) {
                return -1;
            }
            return ((this.f2108c == -1 || !aVar.f2111b.get(i10).a(f10, f11)) && i10 != (b10 = aVar.b(f10, f11))) ? b10 == -1 ? aVar.f2112c : aVar.f2111b.get(b10).f2117e : i10;
        }
        a aVar2 = this.f2109d.get(i11);
        if (aVar2 == null) {
            return -1;
        }
        int b11 = aVar2.b(f10, f11);
        return b11 == -1 ? aVar2.f2112c : aVar2.f2111b.get(b11).f2117e;
    }
}
