package androidx.lifecycle;

import ab.n;
import ab.o;
import ab.u;
import androidx.lifecycle.h;
import db.d;
import db.g;
import fb.e;
import fb.j;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.c0;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.e0;
import lb.p;
import mb.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1 implements m {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h.b f2975a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ k<a1> f2976b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ c0 f2977c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ h.b f2978d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ kotlinx.coroutines.h<u> f2979e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ xb.a f2980f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ p<c0, d<? super u>, Object> f2981g;

    @e(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1", f = "RepeatOnLifecycle.kt", l = {171, 110}, m = "invokeSuspend")
    static final class a extends j implements p<c0, d<? super u>, Object> {

        /* renamed from: e  reason: collision with root package name */
        Object f2982e;

        /* renamed from: f  reason: collision with root package name */
        Object f2983f;

        /* renamed from: g  reason: collision with root package name */
        int f2984g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ xb.a f2985h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ p<c0, d<? super u>, Object> f2986i;

        @e(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1", f = "RepeatOnLifecycle.kt", l = {111}, m = "invokeSuspend")
        /* renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$a$a  reason: collision with other inner class name */
        static final class C0028a extends j implements p<c0, d<? super u>, Object> {

            /* renamed from: e  reason: collision with root package name */
            int f2987e;

            /* renamed from: f  reason: collision with root package name */
            private /* synthetic */ Object f2988f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ p<c0, d<? super u>, Object> f2989g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0028a(p<? super c0, ? super d<? super u>, ? extends Object> pVar, d<? super C0028a> dVar) {
                super(2, dVar);
                this.f2989g = pVar;
            }

            @NotNull
            public final d<u> h(@Nullable Object obj, @NotNull d<?> dVar) {
                C0028a aVar = new C0028a(this.f2989g, dVar);
                aVar.f2988f = obj;
                return aVar;
            }

            @Nullable
            public final Object m(@NotNull Object obj) {
                Object c10 = d.c();
                int i10 = this.f2987e;
                if (i10 == 0) {
                    o.b(obj);
                    p<c0, d<? super u>, Object> pVar = this.f2989g;
                    this.f2987e = 1;
                    if (pVar.f((c0) this.f2988f, this) == c10) {
                        return c10;
                    }
                } else if (i10 == 1) {
                    o.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return u.f160a;
            }

            @Nullable
            /* renamed from: p */
            public final Object f(@NotNull c0 c0Var, @Nullable d<? super u> dVar) {
                return ((C0028a) h(c0Var, dVar)).m(u.f160a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(xb.a aVar, p<? super c0, ? super d<? super u>, ? extends Object> pVar, d<? super a> dVar) {
            super(2, dVar);
            this.f2985h = aVar;
            this.f2986i = pVar;
        }

        @NotNull
        public final d<u> h(@Nullable Object obj, @NotNull d<?> dVar) {
            return new a(this.f2985h, this.f2986i, dVar);
        }

        @Nullable
        public final Object m(@NotNull Object obj) {
            Throwable th;
            xb.a aVar;
            xb.a aVar2;
            p<c0, d<? super u>, Object> pVar;
            Object c10 = d.c();
            int i10 = this.f2984g;
            if (i10 == 0) {
                o.b(obj);
                aVar2 = this.f2985h;
                pVar = this.f2986i;
                this.f2982e = aVar2;
                this.f2983f = pVar;
                this.f2984g = 1;
                if (aVar2.b((Object) null, this) == c10) {
                    return c10;
                }
            } else if (i10 == 1) {
                pVar = (p) this.f2983f;
                o.b(obj);
                aVar2 = (xb.a) this.f2982e;
            } else if (i10 == 2) {
                aVar = (xb.a) this.f2982e;
                try {
                    o.b(obj);
                    u uVar = u.f160a;
                    aVar.a((Object) null);
                    return uVar;
                } catch (Throwable th2) {
                    th = th2;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            try {
                C0028a aVar3 = new C0028a(pVar, (d<? super C0028a>) null);
                this.f2982e = aVar2;
                this.f2983f = null;
                this.f2984g = 2;
                if (d0.b(aVar3, this) == c10) {
                    return c10;
                }
                aVar = aVar2;
                u uVar2 = u.f160a;
                aVar.a((Object) null);
                return uVar2;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                aVar = aVar2;
                th = th4;
                aVar.a((Object) null);
                throw th;
            }
        }

        @Nullable
        /* renamed from: p */
        public final Object f(@NotNull c0 c0Var, @Nullable d<? super u> dVar) {
            return ((a) h(c0Var, dVar)).m(u.f160a);
        }
    }

    public final void c(@NotNull o oVar, @NotNull h.b bVar) {
        mb.h.e(oVar, "$noName_0");
        mb.h.e(bVar, "event");
        if (bVar == this.f2975a) {
            this.f2976b.f16017a = f.b(this.f2977c, (g) null, (e0) null, new a(this.f2980f, this.f2981g, (d<? super a>) null), 3, (Object) null);
            return;
        }
        if (bVar == this.f2978d) {
            a1 a1Var = (a1) this.f2976b.f16017a;
            if (a1Var != null) {
                a1.a.a(a1Var, (CancellationException) null, 1, (Object) null);
            }
            this.f2976b.f16017a = null;
        }
        if (bVar == h.b.ON_DESTROY) {
            kotlinx.coroutines.h<u> hVar = this.f2979e;
            u uVar = u.f160a;
            n.a aVar = n.f154a;
            hVar.e(n.a(uVar));
        }
    }
}
