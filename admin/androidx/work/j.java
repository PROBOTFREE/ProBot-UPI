package androidx.work;

import android.os.Build;
import i2.p;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public abstract class j {

    /* renamed from: a  reason: collision with root package name */
    private UUID f4634a;

    /* renamed from: b  reason: collision with root package name */
    private p f4635b;

    /* renamed from: c  reason: collision with root package name */
    private Set<String> f4636c;

    public static abstract class a<B extends a<?, ?>, W extends j> {

        /* renamed from: a  reason: collision with root package name */
        boolean f4637a = false;

        /* renamed from: b  reason: collision with root package name */
        UUID f4638b = UUID.randomUUID();

        /* renamed from: c  reason: collision with root package name */
        p f4639c;

        /* renamed from: d  reason: collision with root package name */
        Set<String> f4640d = new HashSet();

        a(Class<? extends ListenableWorker> cls) {
            this.f4639c = new p(this.f4638b.toString(), cls.getName());
            a(cls.getName());
        }

        public final B a(String str) {
            this.f4640d.add(str);
            return d();
        }

        public final W b() {
            W c10 = c();
            a2.a aVar = this.f4639c.f14720j;
            int i10 = Build.VERSION.SDK_INT;
            boolean z10 = (i10 >= 24 && aVar.e()) || aVar.f() || aVar.g() || (i10 >= 23 && aVar.h());
            p pVar = this.f4639c;
            if (pVar.f14727q) {
                if (z10) {
                    throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
                } else if (pVar.f14717g > 0) {
                    throw new IllegalArgumentException("Expedited jobs cannot be delayed");
                }
            }
            this.f4638b = UUID.randomUUID();
            p pVar2 = new p(this.f4639c);
            this.f4639c = pVar2;
            pVar2.f14711a = this.f4638b.toString();
            return c10;
        }

        /* access modifiers changed from: package-private */
        public abstract W c();

        /* access modifiers changed from: package-private */
        public abstract B d();
    }

    protected j(UUID uuid, p pVar, Set<String> set) {
        this.f4634a = uuid;
        this.f4635b = pVar;
        this.f4636c = set;
    }

    public String a() {
        return this.f4634a.toString();
    }

    public Set<String> b() {
        return this.f4636c;
    }

    public p c() {
        return this.f4635b;
    }
}
