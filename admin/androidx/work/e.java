package androidx.work;

import ab.u;
import androidx.work.impl.utils.futures.c;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.a1;
import lb.l;
import mb.h;
import mb.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class e<R> implements e7.a<R> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final a1 f4465a;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final c<R> f4466b;

    static final class a extends i implements l<Throwable, u> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ e<R> f4467b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(e<R> eVar) {
            super(1);
            this.f4467b = eVar;
        }

        public final void a(@Nullable Throwable th) {
            if (th == null) {
                if (!this.f4467b.f4466b.isDone()) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            } else if (th instanceof CancellationException) {
                this.f4467b.f4466b.cancel(true);
            } else {
                c b10 = this.f4467b.f4466b;
                Throwable cause = th.getCause();
                if (cause != null) {
                    th = cause;
                }
                b10.q(th);
            }
        }

        public /* bridge */ /* synthetic */ Object j(Object obj) {
            a((Throwable) obj);
            return u.f160a;
        }
    }

    public e(@NotNull a1 a1Var, @NotNull c<R> cVar) {
        h.e(a1Var, "job");
        h.e(cVar, "underlying");
        this.f4465a = a1Var;
        this.f4466b = cVar;
        a1Var.r(new a(this));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ e(kotlinx.coroutines.a1 r1, androidx.work.impl.utils.futures.c r2, int r3, mb.f r4) {
        /*
            r0 = this;
            r3 = r3 & 2
            if (r3 == 0) goto L_0x000d
            androidx.work.impl.utils.futures.c r2 = androidx.work.impl.utils.futures.c.t()
            java.lang.String r3 = "create()"
            mb.h.d(r2, r3)
        L_0x000d:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.e.<init>(kotlinx.coroutines.a1, androidx.work.impl.utils.futures.c, int, mb.f):void");
    }

    public void a(Runnable runnable, Executor executor) {
        this.f4466b.a(runnable, executor);
    }

    public final void c(R r10) {
        this.f4466b.p(r10);
    }

    public boolean cancel(boolean z10) {
        return this.f4466b.cancel(z10);
    }

    public R get() {
        return this.f4466b.get();
    }

    public R get(long j10, TimeUnit timeUnit) {
        return this.f4466b.get(j10, timeUnit);
    }

    public boolean isCancelled() {
        return this.f4466b.isCancelled();
    }

    public boolean isDone() {
        return this.f4466b.isDone();
    }
}
