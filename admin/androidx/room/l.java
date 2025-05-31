package androidx.room;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

class l implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f3828a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayDeque<Runnable> f3829b = new ArrayDeque<>();

    /* renamed from: c  reason: collision with root package name */
    private Runnable f3830c;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Runnable f3831a;

        a(Runnable runnable) {
            this.f3831a = runnable;
        }

        public void run() {
            try {
                this.f3831a.run();
            } finally {
                l.this.a();
            }
        }
    }

    l(Executor executor) {
        this.f3828a = executor;
    }

    /* access modifiers changed from: package-private */
    public synchronized void a() {
        Runnable poll = this.f3829b.poll();
        this.f3830c = poll;
        if (poll != null) {
            this.f3828a.execute(poll);
        }
    }

    public synchronized void execute(Runnable runnable) {
        this.f3829b.offer(new a(runnable));
        if (this.f3830c == null) {
            a();
        }
    }
}
