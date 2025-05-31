package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.work.ListenableWorker;
import androidx.work.impl.utils.futures.c;

public abstract class Worker extends ListenableWorker {

    /* renamed from: f  reason: collision with root package name */
    c<ListenableWorker.a> f4419f;

    class a implements Runnable {
        a() {
        }

        public void run() {
            try {
                Worker.this.f4419f.p(Worker.this.r());
            } catch (Throwable th) {
                Worker.this.f4419f.q(th);
            }
        }
    }

    @SuppressLint({"BanKeepAnnotation"})
    @Keep
    public Worker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public final e7.a<ListenableWorker.a> p() {
        this.f4419f = c.t();
        b().execute(new a());
        return this.f4419f;
    }

    public abstract ListenableWorker.a r();
}
