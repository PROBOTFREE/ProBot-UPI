package androidx.work;

import a2.c;
import a2.o;
import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import java.util.UUID;
import java.util.concurrent.Executor;

public abstract class ListenableWorker {

    /* renamed from: a  reason: collision with root package name */
    private Context f4411a;

    /* renamed from: b  reason: collision with root package name */
    private WorkerParameters f4412b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f4413c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f4414d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f4415e;

    public static abstract class a {

        /* renamed from: androidx.work.ListenableWorker$a$a  reason: collision with other inner class name */
        public static final class C0050a extends a {

            /* renamed from: a  reason: collision with root package name */
            private final c f4416a;

            public C0050a() {
                this(c.f4457c);
            }

            public C0050a(c cVar) {
                this.f4416a = cVar;
            }

            public c e() {
                return this.f4416a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || C0050a.class != obj.getClass()) {
                    return false;
                }
                return this.f4416a.equals(((C0050a) obj).f4416a);
            }

            public int hashCode() {
                return (C0050a.class.getName().hashCode() * 31) + this.f4416a.hashCode();
            }

            public String toString() {
                return "Failure {mOutputData=" + this.f4416a + '}';
            }
        }

        public static final class b extends a {
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && b.class == obj.getClass();
            }

            public int hashCode() {
                return b.class.getName().hashCode();
            }

            public String toString() {
                return "Retry";
            }
        }

        public static final class c extends a {

            /* renamed from: a  reason: collision with root package name */
            private final c f4417a;

            public c() {
                this(c.f4457c);
            }

            public c(c cVar) {
                this.f4417a = cVar;
            }

            public c e() {
                return this.f4417a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || c.class != obj.getClass()) {
                    return false;
                }
                return this.f4417a.equals(((c) obj).f4417a);
            }

            public int hashCode() {
                return (c.class.getName().hashCode() * 31) + this.f4417a.hashCode();
            }

            public String toString() {
                return "Success {mOutputData=" + this.f4417a + '}';
            }
        }

        a() {
        }

        public static a a() {
            return new C0050a();
        }

        public static a b() {
            return new b();
        }

        public static a c() {
            return new c();
        }

        public static a d(c cVar) {
            return new c(cVar);
        }
    }

    @SuppressLint({"BanKeepAnnotation"})
    @Keep
    public ListenableWorker(Context context, WorkerParameters workerParameters) {
        if (context == null) {
            throw new IllegalArgumentException("Application Context is null");
        } else if (workerParameters != null) {
            this.f4411a = context;
            this.f4412b = workerParameters;
        } else {
            throw new IllegalArgumentException("WorkerParameters is null");
        }
    }

    public final Context a() {
        return this.f4411a;
    }

    public Executor b() {
        return this.f4412b.a();
    }

    public e7.a<c> c() {
        androidx.work.impl.utils.futures.c t10 = androidx.work.impl.utils.futures.c.t();
        t10.q(new IllegalStateException("Expedited WorkRequests require a ListenableWorker to provide an implementation for `getForegroundInfoAsync()`"));
        return t10;
    }

    public final UUID f() {
        return this.f4412b.c();
    }

    public final c g() {
        return this.f4412b.d();
    }

    public k2.a h() {
        return this.f4412b.e();
    }

    public o i() {
        return this.f4412b.f();
    }

    public boolean j() {
        return this.f4415e;
    }

    public final boolean k() {
        return this.f4413c;
    }

    public final boolean l() {
        return this.f4414d;
    }

    public void m() {
    }

    public void n(boolean z10) {
        this.f4415e = z10;
    }

    public final void o() {
        this.f4414d = true;
    }

    public abstract e7.a<a> p();

    public final void q() {
        this.f4413c = true;
        m();
    }
}
