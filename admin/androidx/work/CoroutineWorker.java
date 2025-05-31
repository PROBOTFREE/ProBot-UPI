package androidx.work;

import ab.o;
import ab.u;
import android.content.Context;
import androidx.work.ListenableWorker;
import db.d;
import db.g;
import fb.j;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.c0;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.e0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.x;
import lb.p;
import mb.f;
import mb.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ub.e;

public abstract class CoroutineWorker extends ListenableWorker {
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final e f4401f = e1.b((a1) null, 1, (Object) null);
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final androidx.work.impl.utils.futures.c<ListenableWorker.a> f4402g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final x f4403h;

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CoroutineWorker f4404a;

        a(CoroutineWorker coroutineWorker) {
            this.f4404a = coroutineWorker;
        }

        public final void run() {
            if (this.f4404a.v().isCancelled()) {
                a1.a.a(this.f4404a.w(), (CancellationException) null, 1, (Object) null);
            }
        }
    }

    @fb.e(c = "androidx.work.CoroutineWorker$getForegroundInfoAsync$1", f = "CoroutineWorker.kt", l = {134}, m = "invokeSuspend")
    static final class b extends j implements p<c0, d<? super u>, Object> {

        /* renamed from: e  reason: collision with root package name */
        Object f4405e;

        /* renamed from: f  reason: collision with root package name */
        int f4406f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ e<a2.c> f4407g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ CoroutineWorker f4408h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(e<a2.c> eVar, CoroutineWorker coroutineWorker, d<? super b> dVar) {
            super(2, dVar);
            this.f4407g = eVar;
            this.f4408h = coroutineWorker;
        }

        @NotNull
        public final d<u> h(@Nullable Object obj, @NotNull d<?> dVar) {
            return new b(this.f4407g, this.f4408h, dVar);
        }

        @Nullable
        public final Object m(@NotNull Object obj) {
            e<a2.c> eVar;
            Object c10 = d.c();
            int i10 = this.f4406f;
            if (i10 == 0) {
                o.b(obj);
                e<a2.c> eVar2 = this.f4407g;
                CoroutineWorker coroutineWorker = this.f4408h;
                this.f4405e = eVar2;
                this.f4406f = 1;
                Object t10 = coroutineWorker.t(this);
                if (t10 == c10) {
                    return c10;
                }
                eVar = eVar2;
                obj = t10;
            } else if (i10 == 1) {
                eVar = (e) this.f4405e;
                o.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            eVar.c(obj);
            return u.f160a;
        }

        @Nullable
        /* renamed from: p */
        public final Object f(@NotNull c0 c0Var, @Nullable d<? super u> dVar) {
            return ((b) h(c0Var, dVar)).m(u.f160a);
        }
    }

    @fb.e(c = "androidx.work.CoroutineWorker$startWork$1", f = "CoroutineWorker.kt", l = {68}, m = "invokeSuspend")
    static final class c extends j implements p<c0, d<? super u>, Object> {

        /* renamed from: e  reason: collision with root package name */
        int f4409e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ CoroutineWorker f4410f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(CoroutineWorker coroutineWorker, d<? super c> dVar) {
            super(2, dVar);
            this.f4410f = coroutineWorker;
        }

        @NotNull
        public final d<u> h(@Nullable Object obj, @NotNull d<?> dVar) {
            return new c(this.f4410f, dVar);
        }

        @Nullable
        public final Object m(@NotNull Object obj) {
            Object c10 = d.c();
            int i10 = this.f4409e;
            if (i10 == 0) {
                o.b(obj);
                CoroutineWorker coroutineWorker = this.f4410f;
                this.f4409e = 1;
                obj = coroutineWorker.r(this);
                if (obj == c10) {
                    return c10;
                }
            } else if (i10 == 1) {
                try {
                    o.b(obj);
                } catch (Throwable th) {
                    this.f4410f.v().q(th);
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.f4410f.v().p((ListenableWorker.a) obj);
            return u.f160a;
        }

        @Nullable
        /* renamed from: p */
        public final Object f(@NotNull c0 c0Var, @Nullable d<? super u> dVar) {
            return ((c) h(c0Var, dVar)).m(u.f160a);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoroutineWorker(@NotNull Context context, @NotNull WorkerParameters workerParameters) {
        super(context, workerParameters);
        h.e(context, "appContext");
        h.e(workerParameters, "params");
        androidx.work.impl.utils.futures.c<ListenableWorker.a> t10 = androidx.work.impl.utils.futures.c.t();
        h.d(t10, "create()");
        this.f4402g = t10;
        t10.a(new a(this), h().c());
        this.f4403h = m0.a();
    }

    static /* synthetic */ Object u(CoroutineWorker coroutineWorker, d dVar) {
        throw new IllegalStateException("Not implemented");
    }

    @NotNull
    public final e7.a<a2.c> c() {
        e b10 = e1.b((a1) null, 1, (Object) null);
        c0 a10 = d0.a(s().plus(b10));
        e eVar = new e(b10, (androidx.work.impl.utils.futures.c) null, 2, (f) null);
        a1 unused = f.b(a10, (g) null, (e0) null, new b(eVar, this, (d<? super b>) null), 3, (Object) null);
        return eVar;
    }

    public final void m() {
        super.m();
        this.f4402g.cancel(false);
    }

    @NotNull
    public final e7.a<ListenableWorker.a> p() {
        a1 unused = f.b(d0.a(s().plus(this.f4401f)), (g) null, (e0) null, new c(this, (d<? super c>) null), 3, (Object) null);
        return this.f4402g;
    }

    @Nullable
    public abstract Object r(@NotNull d<? super ListenableWorker.a> dVar);

    @NotNull
    public x s() {
        return this.f4403h;
    }

    @Nullable
    public Object t(@NotNull d<? super a2.c> dVar) {
        return u(this, dVar);
    }

    @NotNull
    public final androidx.work.impl.utils.futures.c<ListenableWorker.a> v() {
        return this.f4402g;
    }

    @NotNull
    public final e w() {
        return this.f4401f;
    }
}
