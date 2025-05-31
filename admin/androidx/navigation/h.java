package androidx.navigation;

import android.content.Intent;
import android.net.Uri;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f3173a;

    /* renamed from: b  reason: collision with root package name */
    private final String f3174b;

    /* renamed from: c  reason: collision with root package name */
    private final String f3175c;

    h(Intent intent) {
        this(intent.getData(), intent.getAction(), intent.getType());
    }

    h(Uri uri, String str, String str2) {
        this.f3173a = uri;
        this.f3174b = str;
        this.f3175c = str2;
    }

    public String a() {
        return this.f3174b;
    }

    public String b() {
        return this.f3175c;
    }

    public Uri c() {
        return this.f3173a;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("NavDeepLinkRequest");
        sb2.append("{");
        if (this.f3173a != null) {
            sb2.append(" uri=");
            sb2.append(this.f3173a.toString());
        }
        if (this.f3174b != null) {
            sb2.append(" action=");
            sb2.append(this.f3174b);
        }
        if (this.f3175c != null) {
            sb2.append(" mimetype=");
            sb2.append(this.f3175c);
        }
        sb2.append(" }");
        return sb2.toString();
    }
}
