package androidx.room;

import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
import androidx.room.migration.Migration;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import t1.c;
import t1.e;
import t1.f;

public abstract class h {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    protected volatile t1.b f3780a;

    /* renamed from: b  reason: collision with root package name */
    private Executor f3781b;

    /* renamed from: c  reason: collision with root package name */
    private t1.c f3782c;

    /* renamed from: d  reason: collision with root package name */
    private final e f3783d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3784e;

    /* renamed from: f  reason: collision with root package name */
    boolean f3785f;
    @Deprecated

    /* renamed from: g  reason: collision with root package name */
    protected List<b> f3786g;

    /* renamed from: h  reason: collision with root package name */
    private final ReentrantReadWriteLock f3787h = new ReentrantReadWriteLock();

    /* renamed from: i  reason: collision with root package name */
    private final ThreadLocal<Integer> f3788i = new ThreadLocal<>();

    public static class a<T extends h> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<T> f3789a;

        /* renamed from: b  reason: collision with root package name */
        private final String f3790b;

        /* renamed from: c  reason: collision with root package name */
        private final Context f3791c;

        /* renamed from: d  reason: collision with root package name */
        private ArrayList<b> f3792d;

        /* renamed from: e  reason: collision with root package name */
        private Executor f3793e;

        /* renamed from: f  reason: collision with root package name */
        private Executor f3794f;

        /* renamed from: g  reason: collision with root package name */
        private c.C0218c f3795g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f3796h;

        /* renamed from: i  reason: collision with root package name */
        private c f3797i = c.AUTOMATIC;

        /* renamed from: j  reason: collision with root package name */
        private boolean f3798j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f3799k = true;

        /* renamed from: l  reason: collision with root package name */
        private boolean f3800l;

        /* renamed from: m  reason: collision with root package name */
        private final d f3801m = new d();

        /* renamed from: n  reason: collision with root package name */
        private Set<Integer> f3802n;

        /* renamed from: o  reason: collision with root package name */
        private Set<Integer> f3803o;

        /* renamed from: p  reason: collision with root package name */
        private String f3804p;

        /* renamed from: q  reason: collision with root package name */
        private File f3805q;

        a(Context context, Class<T> cls, String str) {
            this.f3791c = context;
            this.f3789a = cls;
            this.f3790b = str;
        }

        public a<T> a(b bVar) {
            if (this.f3792d == null) {
                this.f3792d = new ArrayList<>();
            }
            this.f3792d.add(bVar);
            return this;
        }

        public a<T> b(Migration... migrationArr) {
            if (this.f3803o == null) {
                this.f3803o = new HashSet();
            }
            for (r1.a aVar : migrationArr) {
                this.f3803o.add(Integer.valueOf(aVar.f16837a));
                this.f3803o.add(Integer.valueOf(aVar.f16838b));
            }
            this.f3801m.b(migrationArr);
            return this;
        }

        public a<T> c() {
            this.f3796h = true;
            return this;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
            if (r1 != null) goto L_0x0018;
         */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x003d  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0067  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x007a  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x00d4  */
        @android.annotation.SuppressLint({"RestrictedApi"})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public T d() {
            /*
                r21 = this;
                r0 = r21
                android.content.Context r1 = r0.f3791c
                if (r1 == 0) goto L_0x00e4
                java.lang.Class<T> r1 = r0.f3789a
                if (r1 == 0) goto L_0x00dc
                java.util.concurrent.Executor r1 = r0.f3793e
                if (r1 != 0) goto L_0x001b
                java.util.concurrent.Executor r2 = r0.f3794f
                if (r2 != 0) goto L_0x001b
                java.util.concurrent.Executor r1 = q.a.d()
                r0.f3794f = r1
            L_0x0018:
                r0.f3793e = r1
                goto L_0x002b
            L_0x001b:
                if (r1 == 0) goto L_0x0024
                java.util.concurrent.Executor r2 = r0.f3794f
                if (r2 != 0) goto L_0x0024
                r0.f3794f = r1
                goto L_0x002b
            L_0x0024:
                if (r1 != 0) goto L_0x002b
                java.util.concurrent.Executor r1 = r0.f3794f
                if (r1 == 0) goto L_0x002b
                goto L_0x0018
            L_0x002b:
                java.util.Set<java.lang.Integer> r1 = r0.f3803o
                if (r1 == 0) goto L_0x0063
                java.util.Set<java.lang.Integer> r2 = r0.f3802n
                if (r2 == 0) goto L_0x0063
                java.util.Iterator r1 = r1.iterator()
            L_0x0037:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L_0x0063
                java.lang.Object r2 = r1.next()
                java.lang.Integer r2 = (java.lang.Integer) r2
                java.util.Set<java.lang.Integer> r3 = r0.f3802n
                boolean r3 = r3.contains(r2)
                if (r3 != 0) goto L_0x004c
                goto L_0x0037
            L_0x004c:
                java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: "
                r3.append(r4)
                r3.append(r2)
                java.lang.String r2 = r3.toString()
                r1.<init>(r2)
                throw r1
            L_0x0063:
                t1.c$c r1 = r0.f3795g
                if (r1 != 0) goto L_0x006e
                u1.c r1 = new u1.c
                r1.<init>()
                r0.f3795g = r1
            L_0x006e:
                java.lang.String r1 = r0.f3804p
                if (r1 != 0) goto L_0x0076
                java.io.File r2 = r0.f3805q
                if (r2 == 0) goto L_0x0094
            L_0x0076:
                java.lang.String r2 = r0.f3790b
                if (r2 == 0) goto L_0x00d4
                if (r1 == 0) goto L_0x0089
                java.io.File r2 = r0.f3805q
                if (r2 != 0) goto L_0x0081
                goto L_0x0089
            L_0x0081:
                java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
                java.lang.String r2 = "Both createFromAsset() and createFromFile() was called on this Builder but the database can only be created using one of the two configurations."
                r1.<init>(r2)
                throw r1
            L_0x0089:
                androidx.room.k r2 = new androidx.room.k
                java.io.File r3 = r0.f3805q
                t1.c$c r4 = r0.f3795g
                r2.<init>(r1, r3, r4)
                r0.f3795g = r2
            L_0x0094:
                androidx.room.a r1 = new androidx.room.a
                android.content.Context r6 = r0.f3791c
                java.lang.String r7 = r0.f3790b
                t1.c$c r8 = r0.f3795g
                androidx.room.h$d r9 = r0.f3801m
                java.util.ArrayList<androidx.room.h$b> r10 = r0.f3792d
                boolean r11 = r0.f3796h
                androidx.room.h$c r2 = r0.f3797i
                androidx.room.h$c r12 = r2.b(r6)
                java.util.concurrent.Executor r13 = r0.f3793e
                java.util.concurrent.Executor r14 = r0.f3794f
                boolean r15 = r0.f3798j
                boolean r2 = r0.f3799k
                boolean r3 = r0.f3800l
                java.util.Set<java.lang.Integer> r4 = r0.f3802n
                java.lang.String r5 = r0.f3804p
                r18 = r4
                java.io.File r4 = r0.f3805q
                r19 = r5
                r5 = r1
                r16 = r2
                r17 = r3
                r20 = r4
                r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
                java.lang.Class<T> r2 = r0.f3789a
                java.lang.String r3 = "_Impl"
                java.lang.Object r2 = androidx.room.g.b(r2, r3)
                androidx.room.h r2 = (androidx.room.h) r2
                r2.l(r1)
                return r2
            L_0x00d4:
                java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
                java.lang.String r2 = "Cannot create from asset or file for an in-memory database."
                r1.<init>(r2)
                throw r1
            L_0x00dc:
                java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
                java.lang.String r2 = "Must provide an abstract class that extends RoomDatabase"
                r1.<init>(r2)
                throw r1
            L_0x00e4:
                java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
                java.lang.String r2 = "Cannot provide null context for the database."
                r1.<init>(r2)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.h.a.d():androidx.room.h");
        }

        public a<T> e() {
            this.f3799k = false;
            this.f3800l = true;
            return this;
        }

        public a<T> f(c.C0218c cVar) {
            this.f3795g = cVar;
            return this;
        }

        public a<T> g(Executor executor) {
            this.f3793e = executor;
            return this;
        }
    }

    public static abstract class b {
        public void a(t1.b bVar) {
        }

        public void b(t1.b bVar) {
        }

        public void c(t1.b bVar) {
        }
    }

    public enum c {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        private static boolean a(ActivityManager activityManager) {
            if (Build.VERSION.SDK_INT >= 19) {
                return activityManager.isLowRamDevice();
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x000b, code lost:
            r3 = (android.app.ActivityManager) r3.getSystemService("activity");
         */
        @android.annotation.SuppressLint({"NewApi"})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.room.h.c b(android.content.Context r3) {
            /*
                r2 = this;
                androidx.room.h$c r0 = AUTOMATIC
                if (r2 == r0) goto L_0x0005
                return r2
            L_0x0005:
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 16
                if (r0 < r1) goto L_0x001e
                java.lang.String r0 = "activity"
                java.lang.Object r3 = r3.getSystemService(r0)
                android.app.ActivityManager r3 = (android.app.ActivityManager) r3
                if (r3 == 0) goto L_0x001e
                boolean r3 = a(r3)
                if (r3 != 0) goto L_0x001e
                androidx.room.h$c r3 = WRITE_AHEAD_LOGGING
                return r3
            L_0x001e:
                androidx.room.h$c r3 = TRUNCATE
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.h.c.b(android.content.Context):androidx.room.h$c");
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private HashMap<Integer, TreeMap<Integer, r1.a>> f3810a = new HashMap<>();

        private void a(r1.a aVar) {
            int i10 = aVar.f16837a;
            int i11 = aVar.f16838b;
            TreeMap treeMap = this.f3810a.get(Integer.valueOf(i10));
            if (treeMap == null) {
                treeMap = new TreeMap();
                this.f3810a.put(Integer.valueOf(i10), treeMap);
            }
            r1.a aVar2 = (r1.a) treeMap.get(Integer.valueOf(i11));
            if (aVar2 != null) {
                Log.w("ROOM", "Overriding migration " + aVar2 + " with " + aVar);
            }
            treeMap.put(Integer.valueOf(i11), aVar);
        }

        private List<r1.a> d(List<r1.a> list, boolean z10, int i10, int i11) {
            boolean z11;
            do {
                if (z10) {
                    if (i10 >= i11) {
                        return list;
                    }
                } else if (i10 <= i11) {
                    return list;
                }
                TreeMap treeMap = this.f3810a.get(Integer.valueOf(i10));
                if (treeMap != null) {
                    Iterator it = (z10 ? treeMap.descendingKeySet() : treeMap.keySet()).iterator();
                    while (true) {
                        z11 = true;
                        boolean z12 = false;
                        if (!it.hasNext()) {
                            z11 = false;
                            continue;
                            break;
                        }
                        int intValue = ((Integer) it.next()).intValue();
                        if (!z10 ? !(intValue < i11 || intValue >= i10) : !(intValue > i11 || intValue <= i10)) {
                            z12 = true;
                            continue;
                        }
                        if (z12) {
                            list.add(treeMap.get(Integer.valueOf(intValue)));
                            i10 = intValue;
                            continue;
                            break;
                        }
                    }
                } else {
                    return null;
                }
            } while (z11);
            return null;
        }

        public void b(r1.a... aVarArr) {
            for (r1.a a10 : aVarArr) {
                a(a10);
            }
        }

        public List<r1.a> c(int i10, int i11) {
            if (i10 == i11) {
                return Collections.emptyList();
            }
            return d(new ArrayList(), i11 > i10, i10, i11);
        }
    }

    public h() {
        new ConcurrentHashMap();
        this.f3783d = e();
    }

    private static boolean n() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public void a() {
        if (!this.f3784e && n()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public void b() {
        if (!k() && this.f3788i.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    @Deprecated
    public void c() {
        a();
        t1.b writableDatabase = this.f3782c.getWritableDatabase();
        this.f3783d.m(writableDatabase);
        writableDatabase.beginTransaction();
    }

    public f d(String str) {
        a();
        b();
        return this.f3782c.getWritableDatabase().compileStatement(str);
    }

    /* access modifiers changed from: protected */
    public abstract e e();

    /* access modifiers changed from: protected */
    public abstract t1.c f(a aVar);

    @Deprecated
    public void g() {
        this.f3782c.getWritableDatabase().endTransaction();
        if (!k()) {
            this.f3783d.f();
        }
    }

    /* access modifiers changed from: package-private */
    public Lock h() {
        return this.f3787h.readLock();
    }

    public t1.c i() {
        return this.f3782c;
    }

    public Executor j() {
        return this.f3781b;
    }

    public boolean k() {
        return this.f3782c.getWritableDatabase().inTransaction();
    }

    public void l(a aVar) {
        t1.c f10 = f(aVar);
        this.f3782c = f10;
        if (f10 instanceof j) {
            ((j) f10).d(aVar);
        }
        boolean z10 = false;
        if (Build.VERSION.SDK_INT >= 16) {
            if (aVar.f3729g == c.WRITE_AHEAD_LOGGING) {
                z10 = true;
            }
            this.f3782c.setWriteAheadLoggingEnabled(z10);
        }
        this.f3786g = aVar.f3727e;
        this.f3781b = aVar.f3730h;
        new l(aVar.f3731i);
        this.f3784e = aVar.f3728f;
        this.f3785f = z10;
        if (aVar.f3732j) {
            this.f3783d.i(aVar.f3724b, aVar.f3725c);
        }
    }

    /* access modifiers changed from: protected */
    public void m(t1.b bVar) {
        this.f3783d.d(bVar);
    }

    public boolean o() {
        t1.b bVar = this.f3780a;
        return bVar != null && bVar.isOpen();
    }

    public Cursor p(e eVar) {
        return q(eVar, (CancellationSignal) null);
    }

    public Cursor q(e eVar, CancellationSignal cancellationSignal) {
        a();
        b();
        return (cancellationSignal == null || Build.VERSION.SDK_INT < 16) ? this.f3782c.getWritableDatabase().query(eVar) : this.f3782c.getWritableDatabase().query(eVar, cancellationSignal);
    }

    @Deprecated
    public void r() {
        this.f3782c.getWritableDatabase().setTransactionSuccessful();
    }
}
