package a2;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;

public abstract class o {

    /* renamed from: a  reason: collision with root package name */
    private static final String f88a = h.f("WorkerFactory");

    class a extends o {
        a() {
        }

        public ListenableWorker a(Context context, String str, WorkerParameters workerParameters) {
            return null;
        }
    }

    public static o c() {
        return new a();
    }

    public abstract ListenableWorker a(Context context, String str, WorkerParameters workerParameters);

    public final ListenableWorker b(Context context, String str, WorkerParameters workerParameters) {
        ListenableWorker a10 = a(context, str, workerParameters);
        if (a10 == null) {
            Class<? extends U> cls = null;
            try {
                cls = Class.forName(str).asSubclass(ListenableWorker.class);
            } catch (Throwable th) {
                h c10 = h.c();
                String str2 = f88a;
                c10.b(str2, "Invalid class: " + str, th);
            }
            if (cls != null) {
                try {
                    a10 = (ListenableWorker) cls.getDeclaredConstructor(new Class[]{Context.class, WorkerParameters.class}).newInstance(new Object[]{context, workerParameters});
                } catch (Throwable th2) {
                    h c11 = h.c();
                    String str3 = f88a;
                    c11.b(str3, "Could not instantiate " + str, th2);
                }
            }
        }
        if (a10 == null || !a10.l()) {
            return a10;
        }
        throw new IllegalStateException(String.format("WorkerFactory (%s) returned an instance of a ListenableWorker (%s) which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.", new Object[]{getClass().getName(), str}));
    }
}
