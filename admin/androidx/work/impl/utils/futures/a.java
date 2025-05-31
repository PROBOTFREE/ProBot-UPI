package androidx.work.impl.utils.futures;

import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class a<V> implements e7.a<V> {

    /* renamed from: d  reason: collision with root package name */
    static final boolean f4595d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: e  reason: collision with root package name */
    private static final Logger f4596e = Logger.getLogger(a.class.getName());

    /* renamed from: f  reason: collision with root package name */
    static final b f4597f;

    /* renamed from: g  reason: collision with root package name */
    private static final Object f4598g = new Object();

    /* renamed from: a  reason: collision with root package name */
    volatile Object f4599a;

    /* renamed from: b  reason: collision with root package name */
    volatile e f4600b;

    /* renamed from: c  reason: collision with root package name */
    volatile i f4601c;

    private static abstract class b {
        private b() {
        }

        /* access modifiers changed from: package-private */
        public abstract boolean a(a<?> aVar, e eVar, e eVar2);

        /* access modifiers changed from: package-private */
        public abstract boolean b(a<?> aVar, Object obj, Object obj2);

        /* access modifiers changed from: package-private */
        public abstract boolean c(a<?> aVar, i iVar, i iVar2);

        /* access modifiers changed from: package-private */
        public abstract void d(i iVar, i iVar2);

        /* access modifiers changed from: package-private */
        public abstract void e(i iVar, Thread thread);
    }

    private static final class c {

        /* renamed from: c  reason: collision with root package name */
        static final c f4602c;

        /* renamed from: d  reason: collision with root package name */
        static final c f4603d;

        /* renamed from: a  reason: collision with root package name */
        final boolean f4604a;

        /* renamed from: b  reason: collision with root package name */
        final Throwable f4605b;

        static {
            if (a.f4595d) {
                f4603d = null;
                f4602c = null;
                return;
            }
            f4603d = new c(false, (Throwable) null);
            f4602c = new c(true, (Throwable) null);
        }

        c(boolean z10, Throwable th) {
            this.f4604a = z10;
            this.f4605b = th;
        }
    }

    private static final class d {

        /* renamed from: b  reason: collision with root package name */
        static final d f4606b = new d(new C0055a("Failure occurred while trying to finish a future."));

        /* renamed from: a  reason: collision with root package name */
        final Throwable f4607a;

        /* renamed from: androidx.work.impl.utils.futures.a$d$a  reason: collision with other inner class name */
        class C0055a extends Throwable {
            C0055a(String str) {
                super(str);
            }

            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        d(Throwable th) {
            this.f4607a = (Throwable) a.e(th);
        }
    }

    private static final class e {

        /* renamed from: d  reason: collision with root package name */
        static final e f4608d = new e((Runnable) null, (Executor) null);

        /* renamed from: a  reason: collision with root package name */
        final Runnable f4609a;

        /* renamed from: b  reason: collision with root package name */
        final Executor f4610b;

        /* renamed from: c  reason: collision with root package name */
        e f4611c;

        e(Runnable runnable, Executor executor) {
            this.f4609a = runnable;
            this.f4610b = executor;
        }
    }

    private static final class f extends b {

        /* renamed from: a  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<i, Thread> f4612a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<i, i> f4613b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, i> f4614c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, e> f4615d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, Object> f4616e;

        f(AtomicReferenceFieldUpdater<i, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<i, i> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<a, i> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<a, e> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<a, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f4612a = atomicReferenceFieldUpdater;
            this.f4613b = atomicReferenceFieldUpdater2;
            this.f4614c = atomicReferenceFieldUpdater3;
            this.f4615d = atomicReferenceFieldUpdater4;
            this.f4616e = atomicReferenceFieldUpdater5;
        }

        /* access modifiers changed from: package-private */
        public boolean a(a<?> aVar, e eVar, e eVar2) {
            return this.f4615d.compareAndSet(aVar, eVar, eVar2);
        }

        /* access modifiers changed from: package-private */
        public boolean b(a<?> aVar, Object obj, Object obj2) {
            return this.f4616e.compareAndSet(aVar, obj, obj2);
        }

        /* access modifiers changed from: package-private */
        public boolean c(a<?> aVar, i iVar, i iVar2) {
            return this.f4614c.compareAndSet(aVar, iVar, iVar2);
        }

        /* access modifiers changed from: package-private */
        public void d(i iVar, i iVar2) {
            this.f4613b.lazySet(iVar, iVar2);
        }

        /* access modifiers changed from: package-private */
        public void e(i iVar, Thread thread) {
            this.f4612a.lazySet(iVar, thread);
        }
    }

    private static final class g<V> implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final a<V> f4617a;

        /* renamed from: b  reason: collision with root package name */
        final e7.a<? extends V> f4618b;

        g(a<V> aVar, e7.a<? extends V> aVar2) {
            this.f4617a = aVar;
            this.f4618b = aVar2;
        }

        public void run() {
            if (this.f4617a.f4599a == this) {
                if (a.f4597f.b(this.f4617a, this, a.j(this.f4618b))) {
                    a.g(this.f4617a);
                }
            }
        }
    }

    private static final class h extends b {
        h() {
            super();
        }

        /* access modifiers changed from: package-private */
        public boolean a(a<?> aVar, e eVar, e eVar2) {
            synchronized (aVar) {
                if (aVar.f4600b != eVar) {
                    return false;
                }
                aVar.f4600b = eVar2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b(a<?> aVar, Object obj, Object obj2) {
            synchronized (aVar) {
                if (aVar.f4599a != obj) {
                    return false;
                }
                aVar.f4599a = obj2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean c(a<?> aVar, i iVar, i iVar2) {
            synchronized (aVar) {
                if (aVar.f4601c != iVar) {
                    return false;
                }
                aVar.f4601c = iVar2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public void d(i iVar, i iVar2) {
            iVar.f4621b = iVar2;
        }

        /* access modifiers changed from: package-private */
        public void e(i iVar, Thread thread) {
            iVar.f4620a = thread;
        }
    }

    private static final class i {

        /* renamed from: c  reason: collision with root package name */
        static final i f4619c = new i(false);

        /* renamed from: a  reason: collision with root package name */
        volatile Thread f4620a;

        /* renamed from: b  reason: collision with root package name */
        volatile i f4621b;

        i() {
            a.f4597f.e(this, Thread.currentThread());
        }

        i(boolean z10) {
        }

        /* access modifiers changed from: package-private */
        public void a(i iVar) {
            a.f4597f.d(this, iVar);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            Thread thread = this.f4620a;
            if (thread != null) {
                this.f4620a = null;
                LockSupport.unpark(thread);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: androidx.work.impl.utils.futures.a$f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: androidx.work.impl.utils.futures.a$h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: androidx.work.impl.utils.futures.a$f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: androidx.work.impl.utils.futures.a$f} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.Class<androidx.work.impl.utils.futures.a$i> r0 = androidx.work.impl.utils.futures.a.i.class
            java.lang.String r1 = "guava.concurrent.generate_cancellation_cause"
            java.lang.String r2 = "false"
            java.lang.String r1 = java.lang.System.getProperty(r1, r2)
            boolean r1 = java.lang.Boolean.parseBoolean(r1)
            f4595d = r1
            java.lang.Class<androidx.work.impl.utils.futures.a> r1 = androidx.work.impl.utils.futures.a.class
            java.lang.String r1 = r1.getName()
            java.util.logging.Logger r1 = java.util.logging.Logger.getLogger(r1)
            f4596e = r1
            androidx.work.impl.utils.futures.a$f r1 = new androidx.work.impl.utils.futures.a$f     // Catch:{ all -> 0x004e }
            java.lang.Class<java.lang.Thread> r2 = java.lang.Thread.class
            java.lang.String r3 = "a"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r2, r3)     // Catch:{ all -> 0x004e }
            java.lang.String r2 = "b"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r0, r2)     // Catch:{ all -> 0x004e }
            java.lang.Class<androidx.work.impl.utils.futures.a> r2 = androidx.work.impl.utils.futures.a.class
            java.lang.String r5 = "c"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r2, r0, r5)     // Catch:{ all -> 0x004e }
            java.lang.Class<androidx.work.impl.utils.futures.a> r0 = androidx.work.impl.utils.futures.a.class
            java.lang.Class<androidx.work.impl.utils.futures.a$e> r2 = androidx.work.impl.utils.futures.a.e.class
            java.lang.String r6 = "b"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r2, r6)     // Catch:{ all -> 0x004e }
            java.lang.Class<androidx.work.impl.utils.futures.a> r0 = androidx.work.impl.utils.futures.a.class
            java.lang.Class<java.lang.Object> r2 = java.lang.Object.class
            java.lang.String r7 = "a"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r2, r7)     // Catch:{ all -> 0x004e }
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x004e }
            r0 = 0
            goto L_0x0054
        L_0x004e:
            r0 = move-exception
            androidx.work.impl.utils.futures.a$h r1 = new androidx.work.impl.utils.futures.a$h
            r1.<init>()
        L_0x0054:
            f4597f = r1
            java.lang.Class<java.util.concurrent.locks.LockSupport> r1 = java.util.concurrent.locks.LockSupport.class
            if (r0 == 0) goto L_0x0063
            java.util.logging.Logger r1 = f4596e
            java.util.logging.Level r2 = java.util.logging.Level.SEVERE
            java.lang.String r3 = "SafeAtomicHelper is broken!"
            r1.log(r2, r3, r0)
        L_0x0063:
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            f4598g = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.futures.a.<clinit>():void");
    }

    protected a() {
    }

    private void b(StringBuilder sb2) {
        String str = "]";
        try {
            Object k10 = k(this);
            sb2.append("SUCCESS, result=[");
            sb2.append(s(k10));
            sb2.append(str);
            return;
        } catch (ExecutionException e10) {
            sb2.append("FAILURE, cause=[");
            sb2.append(e10.getCause());
        } catch (CancellationException unused) {
            str = "CANCELLED";
        } catch (RuntimeException e11) {
            sb2.append("UNKNOWN, cause=[");
            sb2.append(e11.getClass());
            str = " thrown from get()]";
        }
        sb2.append(str);
    }

    private static CancellationException d(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    static <T> T e(T t10) {
        Objects.requireNonNull(t10);
        return t10;
    }

    private e f(e eVar) {
        e eVar2;
        do {
            eVar2 = this.f4600b;
        } while (!f4597f.a(this, eVar2, e.f4608d));
        e eVar3 = eVar2;
        e eVar4 = eVar;
        e eVar5 = eVar3;
        while (eVar5 != null) {
            e eVar6 = eVar5.f4611c;
            eVar5.f4611c = eVar4;
            eVar4 = eVar5;
            eVar5 = eVar6;
        }
        return eVar4;
    }

    static void g(a<?> aVar) {
        e eVar = null;
        a<V> aVar2 = aVar;
        while (true) {
            aVar2.n();
            aVar2.c();
            e f10 = aVar2.f(eVar);
            while (true) {
                if (f10 != null) {
                    eVar = f10.f4611c;
                    Runnable runnable = f10.f4609a;
                    if (runnable instanceof g) {
                        g gVar = (g) runnable;
                        a<V> aVar3 = gVar.f4617a;
                        if (aVar3.f4599a == gVar) {
                            if (f4597f.b(aVar3, gVar, j(gVar.f4618b))) {
                                aVar2 = aVar3;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        h(runnable, f10.f4610b);
                    }
                    f10 = eVar;
                } else {
                    return;
                }
            }
        }
    }

    private static void h(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e10) {
            Logger logger = f4596e;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, e10);
        }
    }

    private V i(Object obj) {
        if (obj instanceof c) {
            throw d("Task was cancelled.", ((c) obj).f4605b);
        } else if (obj instanceof d) {
            throw new ExecutionException(((d) obj).f4607a);
        } else if (obj == f4598g) {
            return null;
        } else {
            return obj;
        }
    }

    static Object j(e7.a<?> aVar) {
        if (aVar instanceof a) {
            Object obj = ((a) aVar).f4599a;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            return cVar.f4604a ? cVar.f4605b != null ? new c(false, cVar.f4605b) : c.f4603d : obj;
        }
        boolean isCancelled = aVar.isCancelled();
        if ((!f4595d) && isCancelled) {
            return c.f4603d;
        }
        try {
            Object k10 = k(aVar);
            return k10 == null ? f4598g : k10;
        } catch (ExecutionException e10) {
            return new d(e10.getCause());
        } catch (CancellationException e11) {
            if (isCancelled) {
                return new c(false, e11);
            }
            return new d(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + aVar, e11));
        } catch (Throwable th) {
            return new d(th);
        }
    }

    private static <V> V k(Future<V> future) {
        V v10;
        boolean z10 = false;
        while (true) {
            try {
                v10 = future.get();
                break;
            } catch (InterruptedException unused) {
                z10 = true;
            } catch (Throwable th) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        return v10;
    }

    private void n() {
        i iVar;
        do {
            iVar = this.f4601c;
        } while (!f4597f.c(this, iVar, i.f4619c));
        while (iVar != null) {
            iVar.b();
            iVar = iVar.f4621b;
        }
    }

    private void o(i iVar) {
        iVar.f4620a = null;
        while (true) {
            i iVar2 = this.f4601c;
            if (iVar2 != i.f4619c) {
                i iVar3 = null;
                while (iVar2 != null) {
                    i iVar4 = iVar2.f4621b;
                    if (iVar2.f4620a != null) {
                        iVar3 = iVar2;
                    } else if (iVar3 != null) {
                        iVar3.f4621b = iVar4;
                        if (iVar3.f4620a == null) {
                        }
                    } else if (!f4597f.c(this, iVar2, iVar4)) {
                    }
                    iVar2 = iVar4;
                }
                return;
            }
            return;
        }
    }

    private String s(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    public final void a(Runnable runnable, Executor executor) {
        e(runnable);
        e(executor);
        e eVar = this.f4600b;
        if (eVar != e.f4608d) {
            e eVar2 = new e(runnable, executor);
            do {
                eVar2.f4611c = eVar;
                if (!f4597f.a(this, eVar, eVar2)) {
                    eVar = this.f4600b;
                } else {
                    return;
                }
            } while (eVar != e.f4608d);
        }
        h(runnable, executor);
    }

    /* access modifiers changed from: protected */
    public void c() {
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [java.util.concurrent.Future, e7.a<? extends V>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.f4599a
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0008
            r3 = r1
            goto L_0x0009
        L_0x0008:
            r3 = r2
        L_0x0009:
            boolean r4 = r0 instanceof androidx.work.impl.utils.futures.a.g
            r3 = r3 | r4
            if (r3 == 0) goto L_0x0061
            boolean r3 = f4595d
            if (r3 == 0) goto L_0x001f
            androidx.work.impl.utils.futures.a$c r3 = new androidx.work.impl.utils.futures.a$c
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r3.<init>(r8, r4)
            goto L_0x0026
        L_0x001f:
            if (r8 == 0) goto L_0x0024
            androidx.work.impl.utils.futures.a$c r3 = androidx.work.impl.utils.futures.a.c.f4602c
            goto L_0x0026
        L_0x0024:
            androidx.work.impl.utils.futures.a$c r3 = androidx.work.impl.utils.futures.a.c.f4603d
        L_0x0026:
            r4 = r7
            r5 = r2
        L_0x0028:
            androidx.work.impl.utils.futures.a$b r6 = f4597f
            boolean r6 = r6.b(r4, r0, r3)
            if (r6 == 0) goto L_0x0059
            if (r8 == 0) goto L_0x0035
            r4.l()
        L_0x0035:
            g(r4)
            boolean r4 = r0 instanceof androidx.work.impl.utils.futures.a.g
            if (r4 == 0) goto L_0x0062
            androidx.work.impl.utils.futures.a$g r0 = (androidx.work.impl.utils.futures.a.g) r0
            e7.a<? extends V> r0 = r0.f4618b
            boolean r4 = r0 instanceof androidx.work.impl.utils.futures.a
            if (r4 == 0) goto L_0x0055
            r4 = r0
            androidx.work.impl.utils.futures.a r4 = (androidx.work.impl.utils.futures.a) r4
            java.lang.Object r0 = r4.f4599a
            if (r0 != 0) goto L_0x004d
            r5 = r1
            goto L_0x004e
        L_0x004d:
            r5 = r2
        L_0x004e:
            boolean r6 = r0 instanceof androidx.work.impl.utils.futures.a.g
            r5 = r5 | r6
            if (r5 == 0) goto L_0x0062
            r5 = r1
            goto L_0x0028
        L_0x0055:
            r0.cancel(r8)
            goto L_0x0062
        L_0x0059:
            java.lang.Object r0 = r4.f4599a
            boolean r6 = r0 instanceof androidx.work.impl.utils.futures.a.g
            if (r6 != 0) goto L_0x0028
            r1 = r5
            goto L_0x0062
        L_0x0061:
            r1 = r2
        L_0x0062:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.futures.a.cancel(boolean):boolean");
    }

    public final V get() {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f4599a;
            if ((obj2 != null) && (!(obj2 instanceof g))) {
                return i(obj2);
            }
            i iVar = this.f4601c;
            if (iVar != i.f4619c) {
                i iVar2 = new i();
                do {
                    iVar2.a(iVar);
                    if (f4597f.c(this, iVar, iVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f4599a;
                            } else {
                                o(iVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof g))));
                        return i(obj);
                    }
                    iVar = this.f4601c;
                } while (iVar != i.f4619c);
            }
            return i(this.f4599a);
        }
        throw new InterruptedException();
    }

    public final V get(long j10, TimeUnit timeUnit) {
        long j11 = j10;
        TimeUnit timeUnit2 = timeUnit;
        long nanos = timeUnit2.toNanos(j11);
        if (!Thread.interrupted()) {
            Object obj = this.f4599a;
            if ((obj != null) && (!(obj instanceof g))) {
                return i(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                i iVar = this.f4601c;
                if (iVar != i.f4619c) {
                    i iVar2 = new i();
                    do {
                        iVar2.a(iVar);
                        if (f4597f.c(this, iVar, iVar2)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.f4599a;
                                    if ((obj2 != null) && (!(obj2 instanceof g))) {
                                        return i(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    o(iVar2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            o(iVar2);
                        } else {
                            iVar = this.f4601c;
                        }
                    } while (iVar != i.f4619c);
                }
                return i(this.f4599a);
            }
            while (nanos > 0) {
                Object obj3 = this.f4599a;
                if ((obj3 != null) && (!(obj3 instanceof g))) {
                    return i(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String aVar = toString();
            String timeUnit3 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = timeUnit3.toLowerCase(locale);
            String str = "Waited " + j11 + " " + timeUnit.toString().toLowerCase(locale);
            if (nanos + 1000 < 0) {
                String str2 = str + " (plus ";
                long j12 = -nanos;
                long convert = timeUnit2.convert(j12, TimeUnit.NANOSECONDS);
                long nanos2 = j12 - timeUnit2.toNanos(convert);
                int i10 = (convert > 0 ? 1 : (convert == 0 ? 0 : -1));
                boolean z10 = i10 == 0 || nanos2 > 1000;
                if (i10 > 0) {
                    String str3 = str2 + convert + " " + lowerCase;
                    if (z10) {
                        str3 = str3 + ",";
                    }
                    str2 = str3 + " ";
                }
                if (z10) {
                    str2 = str2 + nanos2 + " nanoseconds ";
                }
                str = str2 + "delay)";
            }
            if (isDone()) {
                throw new TimeoutException(str + " but future completed as timeout expired");
            }
            throw new TimeoutException(str + " for " + aVar);
        }
        throw new InterruptedException();
    }

    public final boolean isCancelled() {
        return this.f4599a instanceof c;
    }

    public final boolean isDone() {
        Object obj = this.f4599a;
        return (!(obj instanceof g)) & (obj != null);
    }

    /* access modifiers changed from: protected */
    public void l() {
    }

    /* access modifiers changed from: protected */
    public String m() {
        Object obj = this.f4599a;
        if (obj instanceof g) {
            return "setFuture=[" + s(((g) obj).f4618b) + "]";
        } else if (!(this instanceof ScheduledFuture)) {
            return null;
        } else {
            return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        }
    }

    /* access modifiers changed from: protected */
    public boolean p(V v10) {
        if (v10 == null) {
            v10 = f4598g;
        }
        if (!f4597f.b(this, (Object) null, v10)) {
            return false;
        }
        g(this);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean q(Throwable th) {
        if (!f4597f.b(this, (Object) null, new d((Throwable) e(th)))) {
            return false;
        }
        g(this);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean r(e7.a<? extends V> aVar) {
        g gVar;
        d dVar;
        e(aVar);
        Object obj = this.f4599a;
        if (obj == null) {
            if (aVar.isDone()) {
                if (!f4597f.b(this, (Object) null, j(aVar))) {
                    return false;
                }
                g(this);
                return true;
            }
            gVar = new g(this, aVar);
            if (f4597f.b(this, (Object) null, gVar)) {
                try {
                    aVar.a(gVar, b.INSTANCE);
                } catch (Throwable unused) {
                    dVar = d.f4606b;
                }
                return true;
            }
            obj = this.f4599a;
        }
        if (obj instanceof c) {
            aVar.cancel(((c) obj).f4604a);
        }
        return false;
        f4597f.b(this, gVar, dVar);
        return true;
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("[status=");
        if (isCancelled()) {
            str2 = "CANCELLED";
        } else {
            if (!isDone()) {
                try {
                    str = m();
                } catch (RuntimeException e10) {
                    str = "Exception thrown from implementation: " + e10.getClass();
                }
                if (str != null && !str.isEmpty()) {
                    sb2.append("PENDING, info=[");
                    sb2.append(str);
                    sb2.append("]");
                    sb2.append("]");
                    return sb2.toString();
                } else if (!isDone()) {
                    str2 = "PENDING";
                }
            }
            b(sb2);
            sb2.append("]");
            return sb2.toString();
        }
        sb2.append(str2);
        sb2.append("]");
        return sb2.toString();
    }
}
