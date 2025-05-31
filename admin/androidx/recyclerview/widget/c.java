package androidx.recyclerview.widget;

import androidx.recyclerview.widget.h;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class c<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f3474a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f3475b;

    /* renamed from: c  reason: collision with root package name */
    private final h.f<T> f3476c;

    public static final class a<T> {

        /* renamed from: d  reason: collision with root package name */
        private static final Object f3477d = new Object();

        /* renamed from: e  reason: collision with root package name */
        private static Executor f3478e;

        /* renamed from: a  reason: collision with root package name */
        private Executor f3479a;

        /* renamed from: b  reason: collision with root package name */
        private Executor f3480b;

        /* renamed from: c  reason: collision with root package name */
        private final h.f<T> f3481c;

        public a(h.f<T> fVar) {
            this.f3481c = fVar;
        }

        public c<T> a() {
            if (this.f3480b == null) {
                synchronized (f3477d) {
                    if (f3478e == null) {
                        f3478e = Executors.newFixedThreadPool(2);
                    }
                }
                this.f3480b = f3478e;
            }
            return new c<>(this.f3479a, this.f3480b, this.f3481c);
        }
    }

    c(Executor executor, Executor executor2, h.f<T> fVar) {
        this.f3474a = executor;
        this.f3475b = executor2;
        this.f3476c = fVar;
    }

    public Executor a() {
        return this.f3475b;
    }

    public h.f<T> b() {
        return this.f3476c;
    }

    public Executor c() {
        return this.f3474a;
    }
}
