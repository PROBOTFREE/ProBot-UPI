package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.navigation.d;
import androidx.navigation.g;
import androidx.navigation.n;
import o1.a;
import org.xmlpull.v1.XmlPullParserException;

public final class m {

    /* renamed from: c  reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f3196c = new ThreadLocal<>();

    /* renamed from: a  reason: collision with root package name */
    private Context f3197a;

    /* renamed from: b  reason: collision with root package name */
    private r f3198b;

    public m(Context context, r rVar) {
        this.f3197a = context;
        this.f3198b = rVar;
    }

    private static o a(TypedValue typedValue, o oVar, o oVar2, String str, String str2) {
        if (oVar == null || oVar == oVar2) {
            return oVar != null ? oVar : oVar2;
        }
        throw new XmlPullParserException("Type is " + str + " but found " + str2 + ": " + typedValue.data);
    }

    private i b(Resources resources, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, int i10) {
        int depth;
        i a10 = this.f3198b.e(xmlResourceParser.getName()).a();
        a10.A(this.f3197a, attributeSet);
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                return a10;
            }
            if (next == 2 && depth <= depth2) {
                String name = xmlResourceParser.getName();
                if ("argument".equals(name)) {
                    g(resources, a10, attributeSet, i10);
                } else if ("deepLink".equals(name)) {
                    h(resources, a10, attributeSet);
                } else if ("action".equals(name)) {
                    d(resources, a10, attributeSet, xmlResourceParser, i10);
                } else if ("include".equals(name) && (a10 instanceof j)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, t.NavInclude);
                    ((j) a10).G(c(obtainAttributes.getResourceId(t.NavInclude_graph, 0)));
                    obtainAttributes.recycle();
                } else if (a10 instanceof j) {
                    ((j) a10).G(b(resources, xmlResourceParser, attributeSet, i10));
                }
            }
        }
        return a10;
    }

    private void d(Resources resources, i iVar, AttributeSet attributeSet, XmlResourceParser xmlResourceParser, int i10) {
        int depth;
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, a.NavAction);
        int resourceId = obtainAttributes.getResourceId(a.NavAction_android_id, 0);
        c cVar = new c(obtainAttributes.getResourceId(a.NavAction_destination, 0));
        n.a aVar = new n.a();
        aVar.d(obtainAttributes.getBoolean(a.NavAction_launchSingleTop, false));
        aVar.g(obtainAttributes.getResourceId(a.NavAction_popUpTo, -1), obtainAttributes.getBoolean(a.NavAction_popUpToInclusive, false));
        aVar.b(obtainAttributes.getResourceId(a.NavAction_enterAnim, -1));
        aVar.c(obtainAttributes.getResourceId(a.NavAction_exitAnim, -1));
        aVar.e(obtainAttributes.getResourceId(a.NavAction_popEnterAnim, -1));
        aVar.f(obtainAttributes.getResourceId(a.NavAction_popExitAnim, -1));
        cVar.e(aVar.a());
        Bundle bundle = new Bundle();
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next != 1 && ((depth = xmlResourceParser.getDepth()) >= depth2 || next != 3)) {
                if (next == 2 && depth <= depth2 && "argument".equals(xmlResourceParser.getName())) {
                    f(resources, bundle, attributeSet, i10);
                }
            }
        }
        if (!bundle.isEmpty()) {
            cVar.d(bundle);
        }
        iVar.B(resourceId, cVar);
        obtainAttributes.recycle();
    }

    private d e(TypedArray typedArray, Resources resources, int i10) {
        float f10;
        o a10;
        int dimension;
        d.a aVar = new d.a();
        boolean z10 = false;
        aVar.c(typedArray.getBoolean(a.NavArgument_nullable, false));
        ThreadLocal<TypedValue> threadLocal = f3196c;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        String string = typedArray.getString(a.NavArgument_argType);
        int i11 = null;
        o<Integer> a11 = string != null ? o.a(string, resources.getResourcePackageName(i10)) : null;
        int i12 = a.NavArgument_android_defaultValue;
        if (typedArray.getValue(i12, typedValue)) {
            o<Integer> oVar = o.f3214c;
            if (a11 == oVar) {
                dimension = typedValue.resourceId;
                if (dimension == 0) {
                    if (typedValue.type == 16 && typedValue.data == 0) {
                        i11 = 0;
                    } else {
                        throw new XmlPullParserException("unsupported value '" + typedValue.string + "' for " + a11.c() + ". Must be a reference to a resource.");
                    }
                }
            } else {
                int i13 = typedValue.resourceId;
                if (i13 != 0) {
                    if (a11 == null) {
                        a11 = oVar;
                        i11 = Integer.valueOf(i13);
                    } else {
                        throw new XmlPullParserException("unsupported value '" + typedValue.string + "' for " + a11.c() + ". You must use a \"" + oVar.c() + "\" type to reference other resources.");
                    }
                } else if (a11 == o.f3222k) {
                    i11 = typedArray.getString(i12);
                } else {
                    int i14 = typedValue.type;
                    if (i14 != 3) {
                        if (i14 == 4) {
                            a10 = a(typedValue, a11, o.f3218g, string, "float");
                            f10 = typedValue.getFloat();
                        } else if (i14 == 5) {
                            a11 = a(typedValue, a11, o.f3213b, string, "dimension");
                            dimension = (int) typedValue.getDimension(resources.getDisplayMetrics());
                        } else if (i14 == 18) {
                            a11 = a(typedValue, a11, o.f3220i, string, "boolean");
                            if (typedValue.data != 0) {
                                z10 = true;
                            }
                            i11 = Boolean.valueOf(z10);
                        } else if (i14 < 16 || i14 > 31) {
                            throw new XmlPullParserException("unsupported argument type " + typedValue.type);
                        } else {
                            o<Float> oVar2 = o.f3218g;
                            if (a11 == oVar2) {
                                a10 = a(typedValue, a11, oVar2, string, "float");
                                f10 = (float) typedValue.data;
                            } else {
                                a11 = a(typedValue, a11, o.f3213b, string, "integer");
                                dimension = typedValue.data;
                            }
                        }
                        i11 = Float.valueOf(f10);
                    } else {
                        String charSequence = typedValue.string.toString();
                        if (a11 == null) {
                            a11 = o.d(charSequence);
                        }
                        i11 = a11.h(charSequence);
                    }
                }
            }
            i11 = Integer.valueOf(dimension);
        }
        if (i11 != null) {
            aVar.b(i11);
        }
        if (a11 != null) {
            aVar.d(a11);
        }
        return aVar.a();
    }

    private void f(Resources resources, Bundle bundle, AttributeSet attributeSet, int i10) {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, a.NavArgument);
        String string = obtainAttributes.getString(a.NavArgument_android_name);
        if (string != null) {
            d e10 = e(obtainAttributes, resources, i10);
            if (e10.b()) {
                e10.c(string, bundle);
            }
            obtainAttributes.recycle();
            return;
        }
        throw new XmlPullParserException("Arguments must have a name");
    }

    private void g(Resources resources, i iVar, AttributeSet attributeSet, int i10) {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, a.NavArgument);
        String string = obtainAttributes.getString(a.NavArgument_android_name);
        if (string != null) {
            iVar.c(string, e(obtainAttributes, resources, i10));
            obtainAttributes.recycle();
            return;
        }
        throw new XmlPullParserException("Arguments must have a name");
    }

    private void h(Resources resources, i iVar, AttributeSet attributeSet) {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, a.NavDeepLink);
        String string = obtainAttributes.getString(a.NavDeepLink_uri);
        String string2 = obtainAttributes.getString(a.NavDeepLink_action);
        String string3 = obtainAttributes.getString(a.NavDeepLink_mimeType);
        if (!TextUtils.isEmpty(string) || !TextUtils.isEmpty(string2) || !TextUtils.isEmpty(string3)) {
            g.a aVar = new g.a();
            if (string != null) {
                aVar.d(string.replace("${applicationId}", this.f3197a.getPackageName()));
            }
            if (!TextUtils.isEmpty(string2)) {
                aVar.b(string2.replace("${applicationId}", this.f3197a.getPackageName()));
            }
            if (string3 != null) {
                aVar.c(string3.replace("${applicationId}", this.f3197a.getPackageName()));
            }
            iVar.f(aVar.a());
            obtainAttributes.recycle();
            return;
        }
        throw new XmlPullParserException("Every <deepLink> must include at least one of app:uri, app:action, or app:mimeType");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0049 A[Catch:{ Exception -> 0x0053, all -> 0x0051 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001b A[Catch:{ Exception -> 0x0053, all -> 0x0051 }] */
    @android.annotation.SuppressLint({"ResourceType"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.navigation.j c(int r7) {
        /*
            r6 = this;
            android.content.Context r0 = r6.f3197a
            android.content.res.Resources r0 = r0.getResources()
            android.content.res.XmlResourceParser r1 = r0.getXml(r7)
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r1)
        L_0x000e:
            int r3 = r1.next()     // Catch:{ Exception -> 0x0053 }
            r4 = 2
            if (r3 == r4) goto L_0x0019
            r5 = 1
            if (r3 == r5) goto L_0x0019
            goto L_0x000e
        L_0x0019:
            if (r3 != r4) goto L_0x0049
            java.lang.String r3 = r1.getName()     // Catch:{ Exception -> 0x0053 }
            androidx.navigation.i r2 = r6.b(r0, r1, r2, r7)     // Catch:{ Exception -> 0x0053 }
            boolean r4 = r2 instanceof androidx.navigation.j     // Catch:{ Exception -> 0x0053 }
            if (r4 == 0) goto L_0x002d
            androidx.navigation.j r2 = (androidx.navigation.j) r2     // Catch:{ Exception -> 0x0053 }
            r1.close()
            return r2
        L_0x002d:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x0053 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0053 }
            r4.<init>()     // Catch:{ Exception -> 0x0053 }
            java.lang.String r5 = "Root element <"
            r4.append(r5)     // Catch:{ Exception -> 0x0053 }
            r4.append(r3)     // Catch:{ Exception -> 0x0053 }
            java.lang.String r3 = "> did not inflate into a NavGraph"
            r4.append(r3)     // Catch:{ Exception -> 0x0053 }
            java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x0053 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0053 }
            throw r2     // Catch:{ Exception -> 0x0053 }
        L_0x0049:
            org.xmlpull.v1.XmlPullParserException r2 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ Exception -> 0x0053 }
            java.lang.String r3 = "No start tag found"
            r2.<init>(r3)     // Catch:{ Exception -> 0x0053 }
            throw r2     // Catch:{ Exception -> 0x0053 }
        L_0x0051:
            r7 = move-exception
            goto L_0x007b
        L_0x0053:
            r2 = move-exception
            java.lang.RuntimeException r3 = new java.lang.RuntimeException     // Catch:{ all -> 0x0051 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0051 }
            r4.<init>()     // Catch:{ all -> 0x0051 }
            java.lang.String r5 = "Exception inflating "
            r4.append(r5)     // Catch:{ all -> 0x0051 }
            java.lang.String r7 = r0.getResourceName(r7)     // Catch:{ all -> 0x0051 }
            r4.append(r7)     // Catch:{ all -> 0x0051 }
            java.lang.String r7 = " line "
            r4.append(r7)     // Catch:{ all -> 0x0051 }
            int r7 = r1.getLineNumber()     // Catch:{ all -> 0x0051 }
            r4.append(r7)     // Catch:{ all -> 0x0051 }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x0051 }
            r3.<init>(r7, r2)     // Catch:{ all -> 0x0051 }
            throw r3     // Catch:{ all -> 0x0051 }
        L_0x007b:
            r1.close()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.m.c(int):androidx.navigation.j");
    }
}
