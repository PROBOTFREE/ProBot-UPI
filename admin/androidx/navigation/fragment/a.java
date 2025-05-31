package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.i;
import androidx.navigation.q;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

@q.b("fragment")
public class a extends q<C0032a> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f3151a;

    /* renamed from: b  reason: collision with root package name */
    private final FragmentManager f3152b;

    /* renamed from: c  reason: collision with root package name */
    private final int f3153c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayDeque<Integer> f3154d = new ArrayDeque<>();

    /* renamed from: androidx.navigation.fragment.a$a  reason: collision with other inner class name */
    public static class C0032a extends i {

        /* renamed from: i  reason: collision with root package name */
        private String f3155i;

        public C0032a(q<? extends C0032a> qVar) {
            super((q<? extends i>) qVar);
        }

        public void A(Context context, AttributeSet attributeSet) {
            super.A(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, c.FragmentNavigator);
            String string = obtainAttributes.getString(c.FragmentNavigator_android_name);
            if (string != null) {
                H(string);
            }
            obtainAttributes.recycle();
        }

        public final String G() {
            String str = this.f3155i;
            if (str != null) {
                return str;
            }
            throw new IllegalStateException("Fragment class was not set");
        }

        public final C0032a H(String str) {
            this.f3155i = str;
            return this;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(super.toString());
            sb2.append(" class=");
            String str = this.f3155i;
            if (str == null) {
                str = "null";
            }
            sb2.append(str);
            return sb2.toString();
        }
    }

    public static final class b implements q.a {

        /* renamed from: a  reason: collision with root package name */
        private final LinkedHashMap<View, String> f3156a;

        public Map<View, String> a() {
            return Collections.unmodifiableMap(this.f3156a);
        }
    }

    public a(Context context, FragmentManager fragmentManager, int i10) {
        this.f3151a = context;
        this.f3152b = fragmentManager;
        this.f3153c = i10;
    }

    private String g(int i10, int i11) {
        return i10 + "-" + i11;
    }

    public void c(Bundle bundle) {
        int[] intArray;
        if (bundle != null && (intArray = bundle.getIntArray("androidx-nav-fragment:navigator:backStackIds")) != null) {
            this.f3154d.clear();
            for (int valueOf : intArray) {
                this.f3154d.add(Integer.valueOf(valueOf));
            }
        }
    }

    public Bundle d() {
        Bundle bundle = new Bundle();
        int[] iArr = new int[this.f3154d.size()];
        Iterator<Integer> it = this.f3154d.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            iArr[i10] = it.next().intValue();
            i10++;
        }
        bundle.putIntArray("androidx-nav-fragment:navigator:backStackIds", iArr);
        return bundle;
    }

    public boolean e() {
        if (this.f3154d.isEmpty()) {
            return false;
        }
        if (this.f3152b.M0()) {
            Log.i("FragmentNavigator", "Ignoring popBackStack() call: FragmentManager has already saved its state");
            return false;
        }
        this.f3152b.Z0(g(this.f3154d.size(), this.f3154d.peekLast().intValue()), 1);
        this.f3154d.removeLast();
        return true;
    }

    /* renamed from: f */
    public C0032a a() {
        return new C0032a(this);
    }

    @Deprecated
    public Fragment h(Context context, FragmentManager fragmentManager, String str, Bundle bundle) {
        return fragmentManager.s0().instantiate(context.getClassLoader(), str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0134 A[RETURN] */
    /* renamed from: i */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.navigation.i b(androidx.navigation.fragment.a.C0032a r9, android.os.Bundle r10, androidx.navigation.n r11, androidx.navigation.q.a r12) {
        /*
            r8 = this;
            androidx.fragment.app.FragmentManager r0 = r8.f3152b
            boolean r0 = r0.M0()
            r1 = 0
            if (r0 == 0) goto L_0x0011
            java.lang.String r9 = "FragmentNavigator"
            java.lang.String r10 = "Ignoring navigate() call: FragmentManager has already saved its state"
            android.util.Log.i(r9, r10)
            return r1
        L_0x0011:
            java.lang.String r0 = r9.G()
            r2 = 0
            char r3 = r0.charAt(r2)
            r4 = 46
            if (r3 != r4) goto L_0x0033
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            android.content.Context r4 = r8.f3151a
            java.lang.String r4 = r4.getPackageName()
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
        L_0x0033:
            android.content.Context r3 = r8.f3151a
            androidx.fragment.app.FragmentManager r4 = r8.f3152b
            androidx.fragment.app.Fragment r0 = r8.h(r3, r4, r0, r10)
            r0.setArguments(r10)
            androidx.fragment.app.FragmentManager r10 = r8.f3152b
            androidx.fragment.app.s r10 = r10.m()
            r3 = -1
            if (r11 == 0) goto L_0x004c
            int r4 = r11.a()
            goto L_0x004d
        L_0x004c:
            r4 = r3
        L_0x004d:
            if (r11 == 0) goto L_0x0054
            int r5 = r11.b()
            goto L_0x0055
        L_0x0054:
            r5 = r3
        L_0x0055:
            if (r11 == 0) goto L_0x005c
            int r6 = r11.c()
            goto L_0x005d
        L_0x005c:
            r6 = r3
        L_0x005d:
            if (r11 == 0) goto L_0x0064
            int r7 = r11.d()
            goto L_0x0065
        L_0x0064:
            r7 = r3
        L_0x0065:
            if (r4 != r3) goto L_0x006d
            if (r5 != r3) goto L_0x006d
            if (r6 != r3) goto L_0x006d
            if (r7 == r3) goto L_0x0080
        L_0x006d:
            if (r4 == r3) goto L_0x0070
            goto L_0x0071
        L_0x0070:
            r4 = r2
        L_0x0071:
            if (r5 == r3) goto L_0x0074
            goto L_0x0075
        L_0x0074:
            r5 = r2
        L_0x0075:
            if (r6 == r3) goto L_0x0078
            goto L_0x0079
        L_0x0078:
            r6 = r2
        L_0x0079:
            if (r7 == r3) goto L_0x007c
            goto L_0x007d
        L_0x007c:
            r7 = r2
        L_0x007d:
            r10.t(r4, r5, r6, r7)
        L_0x0080:
            int r3 = r8.f3153c
            r10.r(r3, r0)
            r10.v(r0)
            int r0 = r9.w()
            java.util.ArrayDeque<java.lang.Integer> r3 = r8.f3154d
            boolean r3 = r3.isEmpty()
            r4 = 1
            if (r11 == 0) goto L_0x00ad
            if (r3 != 0) goto L_0x00ad
            boolean r11 = r11.g()
            if (r11 == 0) goto L_0x00ad
            java.util.ArrayDeque<java.lang.Integer> r11 = r8.f3154d
            java.lang.Object r11 = r11.peekLast()
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            if (r11 != r0) goto L_0x00ad
            r11 = r4
            goto L_0x00ae
        L_0x00ad:
            r11 = r2
        L_0x00ae:
            if (r3 == 0) goto L_0x00b2
        L_0x00b0:
            r2 = r4
            goto L_0x00f4
        L_0x00b2:
            if (r11 == 0) goto L_0x00e5
            java.util.ArrayDeque<java.lang.Integer> r11 = r8.f3154d
            int r11 = r11.size()
            if (r11 <= r4) goto L_0x00f4
            androidx.fragment.app.FragmentManager r11 = r8.f3152b
            java.util.ArrayDeque<java.lang.Integer> r3 = r8.f3154d
            int r3 = r3.size()
            java.util.ArrayDeque<java.lang.Integer> r5 = r8.f3154d
            java.lang.Object r5 = r5.peekLast()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            java.lang.String r3 = r8.g(r3, r5)
            r11.Z0(r3, r4)
            java.util.ArrayDeque<java.lang.Integer> r11 = r8.f3154d
            int r11 = r11.size()
            java.lang.String r11 = r8.g(r11, r0)
            r10.h(r11)
            goto L_0x00f4
        L_0x00e5:
            java.util.ArrayDeque<java.lang.Integer> r11 = r8.f3154d
            int r11 = r11.size()
            int r11 = r11 + r4
            java.lang.String r11 = r8.g(r11, r0)
            r10.h(r11)
            goto L_0x00b0
        L_0x00f4:
            boolean r11 = r12 instanceof androidx.navigation.fragment.a.b
            if (r11 == 0) goto L_0x0122
            androidx.navigation.fragment.a$b r12 = (androidx.navigation.fragment.a.b) r12
            java.util.Map r11 = r12.a()
            java.util.Set r11 = r11.entrySet()
            java.util.Iterator r11 = r11.iterator()
        L_0x0106:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x0122
            java.lang.Object r12 = r11.next()
            java.util.Map$Entry r12 = (java.util.Map.Entry) r12
            java.lang.Object r3 = r12.getKey()
            android.view.View r3 = (android.view.View) r3
            java.lang.Object r12 = r12.getValue()
            java.lang.String r12 = (java.lang.String) r12
            r10.g(r3, r12)
            goto L_0x0106
        L_0x0122:
            r10.w(r4)
            r10.j()
            if (r2 == 0) goto L_0x0134
            java.util.ArrayDeque<java.lang.Integer> r10 = r8.f3154d
            java.lang.Integer r11 = java.lang.Integer.valueOf(r0)
            r10.add(r11)
            return r9
        L_0x0134:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.fragment.a.b(androidx.navigation.fragment.a$a, android.os.Bundle, androidx.navigation.n, androidx.navigation.q$a):androidx.navigation.i");
    }
}
