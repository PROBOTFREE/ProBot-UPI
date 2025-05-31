package androidx.work.impl.background.systemjob;

import a2.h;
import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.PersistableBundle;
import android.text.TextUtils;
import b2.b;
import b2.i;
import java.util.HashMap;
import java.util.Map;

public class SystemJobService extends JobService implements b {

    /* renamed from: c  reason: collision with root package name */
    private static final String f4557c = h.f("SystemJobService");

    /* renamed from: a  reason: collision with root package name */
    private i f4558a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, JobParameters> f4559b = new HashMap();

    private static String b(JobParameters jobParameters) {
        try {
            PersistableBundle extras = jobParameters.getExtras();
            if (extras == null || !extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return extras.getString("EXTRA_WORK_SPEC_ID");
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public void a(String str, boolean z10) {
        JobParameters remove;
        h.c().a(f4557c, String.format("%s executed on JobScheduler", new Object[]{str}), new Throwable[0]);
        synchronized (this.f4559b) {
            remove = this.f4559b.remove(str);
        }
        if (remove != null) {
            jobFinished(remove, z10);
        }
    }

    public void onCreate() {
        super.onCreate();
        try {
            i j10 = i.j(getApplicationContext());
            this.f4558a = j10;
            j10.l().d(this);
        } catch (IllegalStateException unused) {
            if (Application.class.equals(getApplication().getClass())) {
                h.c().h(f4557c, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.", new Throwable[0]);
                return;
            }
            throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
        }
    }

    public void onDestroy() {
        super.onDestroy();
        i iVar = this.f4558a;
        if (iVar != null) {
            iVar.l().i(this);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006c, code lost:
        r2 = null;
        r3 = android.os.Build.VERSION.SDK_INT;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0071, code lost:
        if (r3 < 24) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0073, code lost:
        r2 = new androidx.work.WorkerParameters.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007c, code lost:
        if (r9.getTriggeredContentUris() == null) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007e, code lost:
        r2.f4428b = java.util.Arrays.asList(r9.getTriggeredContentUris());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008c, code lost:
        if (r9.getTriggeredContentAuthorities() == null) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008e, code lost:
        r2.f4427a = java.util.Arrays.asList(r9.getTriggeredContentAuthorities());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x009a, code lost:
        if (r3 < 28) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009c, code lost:
        r9.getNetwork();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009f, code lost:
        r8.f4558a.u(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a4, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onStartJob(android.app.job.JobParameters r9) {
        /*
            r8 = this;
            b2.i r0 = r8.f4558a
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0017
            a2.h r0 = a2.h.c()
            java.lang.String r3 = f4557c
            java.lang.String r4 = "WorkManager is not initialized; requesting retry."
            java.lang.Throwable[] r5 = new java.lang.Throwable[r2]
            r0.a(r3, r4, r5)
            r8.jobFinished(r9, r1)
            return r2
        L_0x0017:
            java.lang.String r0 = b(r9)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L_0x002f
            a2.h r9 = a2.h.c()
            java.lang.String r0 = f4557c
            java.lang.String r1 = "WorkSpec id not found!"
            java.lang.Throwable[] r3 = new java.lang.Throwable[r2]
            r9.b(r0, r1, r3)
            return r2
        L_0x002f:
            java.util.Map<java.lang.String, android.app.job.JobParameters> r3 = r8.f4559b
            monitor-enter(r3)
            java.util.Map<java.lang.String, android.app.job.JobParameters> r4 = r8.f4559b     // Catch:{ all -> 0x00a5 }
            boolean r4 = r4.containsKey(r0)     // Catch:{ all -> 0x00a5 }
            if (r4 == 0) goto L_0x0051
            a2.h r9 = a2.h.c()     // Catch:{ all -> 0x00a5 }
            java.lang.String r4 = f4557c     // Catch:{ all -> 0x00a5 }
            java.lang.String r5 = "Job is already being executed by SystemJobService: %s"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x00a5 }
            r1[r2] = r0     // Catch:{ all -> 0x00a5 }
            java.lang.String r0 = java.lang.String.format(r5, r1)     // Catch:{ all -> 0x00a5 }
            java.lang.Throwable[] r1 = new java.lang.Throwable[r2]     // Catch:{ all -> 0x00a5 }
            r9.a(r4, r0, r1)     // Catch:{ all -> 0x00a5 }
            monitor-exit(r3)     // Catch:{ all -> 0x00a5 }
            return r2
        L_0x0051:
            a2.h r4 = a2.h.c()     // Catch:{ all -> 0x00a5 }
            java.lang.String r5 = f4557c     // Catch:{ all -> 0x00a5 }
            java.lang.String r6 = "onStartJob for %s"
            java.lang.Object[] r7 = new java.lang.Object[r1]     // Catch:{ all -> 0x00a5 }
            r7[r2] = r0     // Catch:{ all -> 0x00a5 }
            java.lang.String r6 = java.lang.String.format(r6, r7)     // Catch:{ all -> 0x00a5 }
            java.lang.Throwable[] r2 = new java.lang.Throwable[r2]     // Catch:{ all -> 0x00a5 }
            r4.a(r5, r6, r2)     // Catch:{ all -> 0x00a5 }
            java.util.Map<java.lang.String, android.app.job.JobParameters> r2 = r8.f4559b     // Catch:{ all -> 0x00a5 }
            r2.put(r0, r9)     // Catch:{ all -> 0x00a5 }
            monitor-exit(r3)     // Catch:{ all -> 0x00a5 }
            r2 = 0
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 24
            if (r3 < r4) goto L_0x009f
            androidx.work.WorkerParameters$a r2 = new androidx.work.WorkerParameters$a
            r2.<init>()
            android.net.Uri[] r4 = r9.getTriggeredContentUris()
            if (r4 == 0) goto L_0x0088
            android.net.Uri[] r4 = r9.getTriggeredContentUris()
            java.util.List r4 = java.util.Arrays.asList(r4)
            r2.f4428b = r4
        L_0x0088:
            java.lang.String[] r4 = r9.getTriggeredContentAuthorities()
            if (r4 == 0) goto L_0x0098
            java.lang.String[] r4 = r9.getTriggeredContentAuthorities()
            java.util.List r4 = java.util.Arrays.asList(r4)
            r2.f4427a = r4
        L_0x0098:
            r4 = 28
            if (r3 < r4) goto L_0x009f
            r9.getNetwork()
        L_0x009f:
            b2.i r9 = r8.f4558a
            r9.u(r0, r2)
            return r1
        L_0x00a5:
            r9 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x00a5 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.background.systemjob.SystemJobService.onStartJob(android.app.job.JobParameters):boolean");
    }

    public boolean onStopJob(JobParameters jobParameters) {
        if (this.f4558a == null) {
            h.c().a(f4557c, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            return true;
        }
        String b10 = b(jobParameters);
        if (TextUtils.isEmpty(b10)) {
            h.c().b(f4557c, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        h.c().a(f4557c, String.format("onStopJob for %s", new Object[]{b10}), new Throwable[0]);
        synchronized (this.f4559b) {
            this.f4559b.remove(b10);
        }
        this.f4558a.w(b10);
        return !this.f4558a.l().f(b10);
    }
}
