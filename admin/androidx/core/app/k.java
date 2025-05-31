package androidx.core.app;

import android.app.Person;
import androidx.core.graphics.drawable.IconCompat;

public class k {

    /* renamed from: a  reason: collision with root package name */
    CharSequence f2261a;

    /* renamed from: b  reason: collision with root package name */
    IconCompat f2262b;

    /* renamed from: c  reason: collision with root package name */
    String f2263c;

    /* renamed from: d  reason: collision with root package name */
    String f2264d;

    /* renamed from: e  reason: collision with root package name */
    boolean f2265e;

    /* renamed from: f  reason: collision with root package name */
    boolean f2266f;

    public IconCompat a() {
        return this.f2262b;
    }

    public String b() {
        return this.f2264d;
    }

    public CharSequence c() {
        return this.f2261a;
    }

    public String d() {
        return this.f2263c;
    }

    public boolean e() {
        return this.f2265e;
    }

    public boolean f() {
        return this.f2266f;
    }

    public String g() {
        String str = this.f2263c;
        if (str != null) {
            return str;
        }
        if (this.f2261a == null) {
            return "";
        }
        return "name:" + this.f2261a;
    }

    public Person h() {
        return new Person.Builder().setName(c()).setIcon(a() != null ? a().p() : null).setUri(d()).setKey(b()).setBot(e()).setImportant(f()).build();
    }
}
