package androidx.core.view;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import w0.h;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    final ClipData f2306a;

    /* renamed from: b  reason: collision with root package name */
    final int f2307b;

    /* renamed from: c  reason: collision with root package name */
    final int f2308c;

    /* renamed from: d  reason: collision with root package name */
    final Uri f2309d;

    /* renamed from: e  reason: collision with root package name */
    final Bundle f2310e;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        ClipData f2311a;

        /* renamed from: b  reason: collision with root package name */
        int f2312b;

        /* renamed from: c  reason: collision with root package name */
        int f2313c;

        /* renamed from: d  reason: collision with root package name */
        Uri f2314d;

        /* renamed from: e  reason: collision with root package name */
        Bundle f2315e;

        public a(ClipData clipData, int i10) {
            this.f2311a = clipData;
            this.f2312b = i10;
        }

        public c a() {
            return new c(this);
        }

        public a b(Bundle bundle) {
            this.f2315e = bundle;
            return this;
        }

        public a c(int i10) {
            this.f2313c = i10;
            return this;
        }

        public a d(Uri uri) {
            this.f2314d = uri;
            return this;
        }
    }

    c(a aVar) {
        this.f2306a = (ClipData) h.e(aVar.f2311a);
        this.f2307b = h.b(aVar.f2312b, 0, 3, "source");
        this.f2308c = h.d(aVar.f2313c, 1);
        this.f2309d = aVar.f2314d;
        this.f2310e = aVar.f2315e;
    }

    static String a(int i10) {
        return (i10 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i10);
    }

    static String e(int i10) {
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? String.valueOf(i10) : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP";
    }

    public ClipData b() {
        return this.f2306a;
    }

    public int c() {
        return this.f2308c;
    }

    public int d() {
        return this.f2307b;
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ContentInfoCompat{clip=");
        sb2.append(this.f2306a.getDescription());
        sb2.append(", source=");
        sb2.append(e(this.f2307b));
        sb2.append(", flags=");
        sb2.append(a(this.f2308c));
        String str2 = "";
        if (this.f2309d == null) {
            str = str2;
        } else {
            str = ", hasLinkUri(" + this.f2309d.toString().length() + ")";
        }
        sb2.append(str);
        if (this.f2310e != null) {
            str2 = ", hasExtras";
        }
        sb2.append(str2);
        sb2.append("}");
        return sb2.toString();
    }
}
