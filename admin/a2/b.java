package a2;

import android.net.Uri;
import java.util.HashSet;
import java.util.Set;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final Set<a> f75a = new HashSet();

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f76a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f77b;

        a(Uri uri, boolean z10) {
            this.f76a = uri;
            this.f77b = z10;
        }

        public Uri a() {
            return this.f76a;
        }

        public boolean b() {
            return this.f77b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f77b == aVar.f77b && this.f76a.equals(aVar.f76a);
        }

        public int hashCode() {
            return (this.f76a.hashCode() * 31) + (this.f77b ? 1 : 0);
        }
    }

    public void a(Uri uri, boolean z10) {
        this.f75a.add(new a(uri, z10));
    }

    public Set<a> b() {
        return this.f75a;
    }

    public int c() {
        return this.f75a.size();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        return this.f75a.equals(((b) obj).f75a);
    }

    public int hashCode() {
        return this.f75a.hashCode();
    }
}
