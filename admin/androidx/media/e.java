package androidx.media;

import android.text.TextUtils;
import w0.c;

class e implements c {

    /* renamed from: a  reason: collision with root package name */
    private String f3086a;

    /* renamed from: b  reason: collision with root package name */
    private int f3087b;

    /* renamed from: c  reason: collision with root package name */
    private int f3088c;

    e(String str, int i10, int i11) {
        this.f3086a = str;
        this.f3087b = i10;
        this.f3088c = i11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return TextUtils.equals(this.f3086a, eVar.f3086a) && this.f3087b == eVar.f3087b && this.f3088c == eVar.f3088c;
    }

    public int hashCode() {
        return c.b(this.f3086a, Integer.valueOf(this.f3087b), Integer.valueOf(this.f3088c));
    }
}
