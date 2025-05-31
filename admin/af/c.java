package af;

import java.io.CharConversionException;
import java.util.Locale;
import of.k;

public final class c extends CharConversionException {

    /* renamed from: a  reason: collision with root package name */
    private k f19227a;

    /* renamed from: b  reason: collision with root package name */
    private Locale f19228b;

    /* renamed from: c  reason: collision with root package name */
    private String f19229c;

    /* renamed from: d  reason: collision with root package name */
    private String f19230d;

    /* renamed from: e  reason: collision with root package name */
    private Object[] f19231e;

    /* renamed from: f  reason: collision with root package name */
    private String f19232f;

    public c(k kVar, Locale locale, String str, String str2, Object[] objArr) {
        this.f19227a = kVar;
        this.f19228b = locale;
        this.f19229c = str;
        this.f19230d = str2;
        this.f19231e = objArr;
    }

    public Object[] a() {
        return this.f19231e;
    }

    public String b() {
        return this.f19229c;
    }

    public String c() {
        return this.f19230d;
    }

    public synchronized String getMessage() {
        if (this.f19232f == null) {
            this.f19232f = this.f19227a.a(this.f19228b, this.f19230d, this.f19231e);
            this.f19227a = null;
            this.f19228b = null;
        }
        return this.f19232f;
    }
}
