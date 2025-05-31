package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.a;
import java.util.HashMap;
import java.util.HashSet;

public abstract class d {

    /* renamed from: f  reason: collision with root package name */
    public static int f1485f = -1;

    /* renamed from: a  reason: collision with root package name */
    int f1486a;

    /* renamed from: b  reason: collision with root package name */
    int f1487b;

    /* renamed from: c  reason: collision with root package name */
    String f1488c = null;

    /* renamed from: d  reason: collision with root package name */
    protected int f1489d;

    /* renamed from: e  reason: collision with root package name */
    HashMap<String, a> f1490e;

    public d() {
        int i10 = f1485f;
        this.f1486a = i10;
        this.f1487b = i10;
    }

    public abstract void a(HashMap<String, k0.d> hashMap);

    /* renamed from: b */
    public abstract d clone();

    public d c(d dVar) {
        this.f1486a = dVar.f1486a;
        this.f1487b = dVar.f1487b;
        this.f1488c = dVar.f1488c;
        this.f1489d = dVar.f1489d;
        this.f1490e = dVar.f1490e;
        return this;
    }

    /* access modifiers changed from: package-private */
    public abstract void d(HashSet<String> hashSet);

    /* access modifiers changed from: package-private */
    public abstract void e(Context context, AttributeSet attributeSet);

    /* access modifiers changed from: package-private */
    public boolean f(String str) {
        String str2 = this.f1488c;
        if (str2 == null || str == null) {
            return false;
        }
        return str.matches(str2);
    }

    public void g(int i10) {
        this.f1486a = i10;
    }

    public void h(HashMap<String, Integer> hashMap) {
    }

    public d i(int i10) {
        this.f1487b = i10;
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean j(Object obj) {
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : Boolean.parseBoolean(obj.toString());
    }

    /* access modifiers changed from: package-private */
    public float k(Object obj) {
        return obj instanceof Float ? ((Float) obj).floatValue() : Float.parseFloat(obj.toString());
    }

    /* access modifiers changed from: package-private */
    public int l(Object obj) {
        return obj instanceof Integer ? ((Integer) obj).intValue() : Integer.parseInt(obj.toString());
    }
}
