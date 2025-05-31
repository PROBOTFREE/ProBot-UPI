package androidx.navigation;

import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class g {

    /* renamed from: i  reason: collision with root package name */
    private static final Pattern f3157i = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<String> f3158a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, c> f3159b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private Pattern f3160c = null;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3161d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3162e;

    /* renamed from: f  reason: collision with root package name */
    private final String f3163f;

    /* renamed from: g  reason: collision with root package name */
    private Pattern f3164g;

    /* renamed from: h  reason: collision with root package name */
    private final String f3165h;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private String f3166a;

        /* renamed from: b  reason: collision with root package name */
        private String f3167b;

        /* renamed from: c  reason: collision with root package name */
        private String f3168c;

        a() {
        }

        public g a() {
            return new g(this.f3166a, this.f3167b, this.f3168c);
        }

        public a b(String str) {
            if (!str.isEmpty()) {
                this.f3167b = str;
                return this;
            }
            throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
        }

        public a c(String str) {
            this.f3168c = str;
            return this;
        }

        public a d(String str) {
            this.f3166a = str;
            return this;
        }
    }

    private static class b implements Comparable<b> {

        /* renamed from: a  reason: collision with root package name */
        String f3169a;

        /* renamed from: b  reason: collision with root package name */
        String f3170b;

        b(String str) {
            String[] split = str.split("/", -1);
            this.f3169a = split[0];
            this.f3170b = split[1];
        }

        /* renamed from: a */
        public int compareTo(b bVar) {
            int i10 = this.f3169a.equals(bVar.f3169a) ? 2 : 0;
            return this.f3170b.equals(bVar.f3170b) ? i10 + 1 : i10;
        }
    }

    private static class c {

        /* renamed from: a  reason: collision with root package name */
        private String f3171a;

        /* renamed from: b  reason: collision with root package name */
        private ArrayList<String> f3172b = new ArrayList<>();

        c() {
        }

        /* access modifiers changed from: package-private */
        public void a(String str) {
            this.f3172b.add(str);
        }

        /* access modifiers changed from: package-private */
        public String b(int i10) {
            return this.f3172b.get(i10);
        }

        /* access modifiers changed from: package-private */
        public String c() {
            return this.f3171a;
        }

        /* access modifiers changed from: package-private */
        public void d(String str) {
            this.f3171a = str;
        }

        public int e() {
            return this.f3172b.size();
        }
    }

    g(String str, String str2, String str3) {
        String str4 = str;
        String str5 = str3;
        int i10 = 0;
        this.f3161d = false;
        this.f3162e = false;
        this.f3164g = null;
        this.f3163f = str2;
        this.f3165h = str5;
        if (str4 != null) {
            Uri parse = Uri.parse(str);
            this.f3162e = parse.getQuery() != null;
            StringBuilder sb2 = new StringBuilder("^");
            if (!f3157i.matcher(str4).find()) {
                sb2.append("http[s]?://");
            }
            Pattern compile = Pattern.compile("\\{(.+?)\\}");
            if (this.f3162e) {
                Matcher matcher = Pattern.compile("(\\?)").matcher(str4);
                if (matcher.find()) {
                    a(str4.substring(0, matcher.start()), sb2, compile);
                }
                this.f3161d = false;
                for (String next : parse.getQueryParameterNames()) {
                    StringBuilder sb3 = new StringBuilder();
                    String queryParameter = parse.getQueryParameter(next);
                    Matcher matcher2 = compile.matcher(queryParameter);
                    c cVar = new c();
                    int i11 = i10;
                    while (matcher2.find()) {
                        cVar.a(matcher2.group(1));
                        sb3.append(Pattern.quote(queryParameter.substring(i11, matcher2.start())));
                        sb3.append("(.+?)?");
                        i11 = matcher2.end();
                    }
                    if (i11 < queryParameter.length()) {
                        sb3.append(Pattern.quote(queryParameter.substring(i11)));
                    }
                    cVar.d(sb3.toString().replace(".*", "\\E.*\\Q"));
                    this.f3159b.put(next, cVar);
                    i10 = 0;
                }
            } else {
                this.f3161d = a(str4, sb2, compile);
            }
            this.f3160c = Pattern.compile(sb2.toString().replace(".*", "\\E.*\\Q"), 2);
        }
        if (str5 == null) {
            return;
        }
        if (Pattern.compile("^[\\s\\S]+/[\\s\\S]+$").matcher(str5).matches()) {
            b bVar = new b(str5);
            this.f3164g = Pattern.compile(("^(" + bVar.f3169a + "|[*]+)/(" + bVar.f3170b + "|[*]+)$").replace("*|[*]", "[\\s\\S]"));
            return;
        }
        throw new IllegalArgumentException("The given mimeType " + str5 + " does not match to required \"type/subtype\" format");
    }

    private boolean a(String str, StringBuilder sb2, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        boolean z10 = !str.contains(".*");
        int i10 = 0;
        while (matcher.find()) {
            this.f3158a.add(matcher.group(1));
            sb2.append(Pattern.quote(str.substring(i10, matcher.start())));
            sb2.append("(.+?)");
            i10 = matcher.end();
            z10 = false;
        }
        if (i10 < str.length()) {
            sb2.append(Pattern.quote(str.substring(i10)));
        }
        sb2.append("($|(\\?(.)*))");
        return z10;
    }

    private boolean f(Bundle bundle, String str, String str2, d dVar) {
        if (dVar != null) {
            try {
                dVar.a().g(bundle, str, str2);
                return false;
            } catch (IllegalArgumentException unused) {
                return true;
            }
        } else {
            bundle.putString(str, str2);
            return false;
        }
    }

    public String b() {
        return this.f3163f;
    }

    /* access modifiers changed from: package-private */
    public Bundle c(Uri uri, Map<String, d> map) {
        Matcher matcher;
        Matcher matcher2 = this.f3160c.matcher(uri.toString());
        if (!matcher2.matches()) {
            return null;
        }
        Bundle bundle = new Bundle();
        int size = this.f3158a.size();
        int i10 = 0;
        while (i10 < size) {
            String str = this.f3158a.get(i10);
            i10++;
            if (f(bundle, str, Uri.decode(matcher2.group(i10)), map.get(str))) {
                return null;
            }
        }
        if (this.f3162e) {
            for (String next : this.f3159b.keySet()) {
                c cVar = this.f3159b.get(next);
                String queryParameter = uri.getQueryParameter(next);
                if (queryParameter != null) {
                    matcher = Pattern.compile(cVar.c()).matcher(queryParameter);
                    if (!matcher.matches()) {
                        return null;
                    }
                } else {
                    matcher = null;
                }
                int i11 = 0;
                while (true) {
                    if (i11 < cVar.e()) {
                        String decode = matcher != null ? Uri.decode(matcher.group(i11 + 1)) : null;
                        String b10 = cVar.b(i11);
                        d dVar = map.get(b10);
                        if (decode != null && !decode.replaceAll("[{}]", "").equals(b10) && f(bundle, b10, decode, dVar)) {
                            return null;
                        }
                        i11++;
                    }
                }
            }
        }
        return bundle;
    }

    /* access modifiers changed from: package-private */
    public int d(String str) {
        if (this.f3165h == null || !this.f3164g.matcher(str).matches()) {
            return -1;
        }
        return new b(this.f3165h).compareTo(new b(str));
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        return this.f3161d;
    }
}
