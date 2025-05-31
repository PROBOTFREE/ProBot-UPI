package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import t1.f;

public class e {

    /* renamed from: k  reason: collision with root package name */
    private static final String[] f3738k = {"UPDATE", "DELETE", "INSERT"};

    /* renamed from: a  reason: collision with root package name */
    final HashMap<String, Integer> f3739a;

    /* renamed from: b  reason: collision with root package name */
    final String[] f3740b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, Set<String>> f3741c;

    /* renamed from: d  reason: collision with root package name */
    final h f3742d;

    /* renamed from: e  reason: collision with root package name */
    AtomicBoolean f3743e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f3744f = false;

    /* renamed from: g  reason: collision with root package name */
    volatile f f3745g;

    /* renamed from: h  reason: collision with root package name */
    private b f3746h;
    @SuppressLint({"RestrictedApi"})

    /* renamed from: i  reason: collision with root package name */
    final r.b<c, d> f3747i = new r.b<>();

    /* renamed from: j  reason: collision with root package name */
    Runnable f3748j = new a();

    class a implements Runnable {
        a() {
        }

        /* JADX INFO: finally extract failed */
        private Set<Integer> a() {
            HashSet hashSet = new HashSet();
            Cursor p10 = e.this.f3742d.p(new t1.a("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
            while (p10.moveToNext()) {
                try {
                    hashSet.add(Integer.valueOf(p10.getInt(0)));
                } catch (Throwable th) {
                    p10.close();
                    throw th;
                }
            }
            p10.close();
            if (!hashSet.isEmpty()) {
                e.this.f3745g.executeUpdateDelete();
            }
            return hashSet;
        }

        public void run() {
            t1.b writableDatabase;
            Lock h10 = e.this.f3742d.h();
            Set<Integer> set = null;
            try {
                h10.lock();
                if (!e.this.c()) {
                    h10.unlock();
                } else if (!e.this.f3743e.compareAndSet(true, false)) {
                    h10.unlock();
                } else if (e.this.f3742d.k()) {
                    h10.unlock();
                } else {
                    h hVar = e.this.f3742d;
                    if (hVar.f3785f) {
                        writableDatabase = hVar.i().getWritableDatabase();
                        writableDatabase.beginTransaction();
                        set = a();
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } else {
                        set = a();
                    }
                    h10.unlock();
                    if (set != null && !set.isEmpty()) {
                        synchronized (e.this.f3747i) {
                            Iterator<Map.Entry<c, d>> it = e.this.f3747i.iterator();
                            while (it.hasNext()) {
                                ((d) it.next().getValue()).a(set);
                            }
                        }
                    }
                }
            } catch (SQLiteException | IllegalStateException e10) {
                try {
                    Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e10);
                } catch (Throwable th) {
                    h10.unlock();
                    throw th;
                }
            } catch (Throwable th2) {
                writableDatabase.endTransaction();
                throw th2;
            }
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        final long[] f3750a;

        /* renamed from: b  reason: collision with root package name */
        final boolean[] f3751b;

        /* renamed from: c  reason: collision with root package name */
        final int[] f3752c;

        /* renamed from: d  reason: collision with root package name */
        boolean f3753d;

        /* renamed from: e  reason: collision with root package name */
        boolean f3754e;

        b(int i10) {
            long[] jArr = new long[i10];
            this.f3750a = jArr;
            boolean[] zArr = new boolean[i10];
            this.f3751b = zArr;
            this.f3752c = new int[i10];
            Arrays.fill(jArr, 0);
            Arrays.fill(zArr, false);
        }

        /* access modifiers changed from: package-private */
        public int[] a() {
            synchronized (this) {
                if (this.f3753d) {
                    if (!this.f3754e) {
                        int length = this.f3750a.length;
                        int i10 = 0;
                        while (true) {
                            int i11 = 1;
                            if (i10 < length) {
                                boolean z10 = this.f3750a[i10] > 0;
                                boolean[] zArr = this.f3751b;
                                if (z10 != zArr[i10]) {
                                    int[] iArr = this.f3752c;
                                    if (!z10) {
                                        i11 = 2;
                                    }
                                    iArr[i10] = i11;
                                } else {
                                    this.f3752c[i10] = 0;
                                }
                                zArr[i10] = z10;
                                i10++;
                            } else {
                                this.f3754e = true;
                                this.f3753d = false;
                                int[] iArr2 = this.f3752c;
                                return iArr2;
                            }
                        }
                    }
                }
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b(int... iArr) {
            boolean z10;
            synchronized (this) {
                z10 = false;
                for (int i10 : iArr) {
                    long[] jArr = this.f3750a;
                    long j10 = jArr[i10];
                    jArr[i10] = 1 + j10;
                    if (j10 == 0) {
                        this.f3753d = true;
                        z10 = true;
                    }
                }
            }
            return z10;
        }

        /* access modifiers changed from: package-private */
        public boolean c(int... iArr) {
            boolean z10;
            synchronized (this) {
                z10 = false;
                for (int i10 : iArr) {
                    long[] jArr = this.f3750a;
                    long j10 = jArr[i10];
                    jArr[i10] = j10 - 1;
                    if (j10 == 1) {
                        this.f3753d = true;
                        z10 = true;
                    }
                }
            }
            return z10;
        }

        /* access modifiers changed from: package-private */
        public void d() {
            synchronized (this) {
                this.f3754e = false;
            }
        }
    }

    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        final String[] f3755a;

        public c(String[] strArr) {
            this.f3755a = (String[]) Arrays.copyOf(strArr, strArr.length);
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return false;
        }

        public abstract void b(Set<String> set);
    }

    static class d {

        /* renamed from: a  reason: collision with root package name */
        final int[] f3756a;

        /* renamed from: b  reason: collision with root package name */
        private final String[] f3757b;

        /* renamed from: c  reason: collision with root package name */
        final c f3758c;

        /* renamed from: d  reason: collision with root package name */
        private final Set<String> f3759d;

        d(c cVar, int[] iArr, String[] strArr) {
            Set<String> set;
            this.f3758c = cVar;
            this.f3756a = iArr;
            this.f3757b = strArr;
            if (iArr.length == 1) {
                HashSet hashSet = new HashSet();
                hashSet.add(strArr[0]);
                set = Collections.unmodifiableSet(hashSet);
            } else {
                set = null;
            }
            this.f3759d = set;
        }

        /* access modifiers changed from: package-private */
        public void a(Set<Integer> set) {
            int length = this.f3756a.length;
            Set set2 = null;
            for (int i10 = 0; i10 < length; i10++) {
                if (set.contains(Integer.valueOf(this.f3756a[i10]))) {
                    if (length == 1) {
                        set2 = this.f3759d;
                    } else {
                        if (set2 == null) {
                            set2 = new HashSet(length);
                        }
                        set2.add(this.f3757b[i10]);
                    }
                }
            }
            if (set2 != null) {
                this.f3758c.b(set2);
            }
        }

        /* access modifiers changed from: package-private */
        public void b(String[] strArr) {
            Set<String> set = null;
            if (this.f3757b.length == 1) {
                int length = strArr.length;
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        break;
                    } else if (strArr[i10].equalsIgnoreCase(this.f3757b[0])) {
                        set = this.f3759d;
                        break;
                    } else {
                        i10++;
                    }
                }
            } else {
                HashSet hashSet = new HashSet();
                for (String str : strArr) {
                    String[] strArr2 = this.f3757b;
                    int length2 = strArr2.length;
                    int i11 = 0;
                    while (true) {
                        if (i11 >= length2) {
                            break;
                        }
                        String str2 = strArr2[i11];
                        if (str2.equalsIgnoreCase(str)) {
                            hashSet.add(str2);
                            break;
                        }
                        i11++;
                    }
                }
                if (hashSet.size() > 0) {
                    set = hashSet;
                }
            }
            if (set != null) {
                this.f3758c.b(set);
            }
        }
    }

    public e(h hVar, Map<String, String> map, Map<String, Set<String>> map2, String... strArr) {
        this.f3742d = hVar;
        this.f3746h = new b(strArr.length);
        this.f3739a = new HashMap<>();
        this.f3741c = map2;
        new d(hVar);
        int length = strArr.length;
        this.f3740b = new String[length];
        for (int i10 = 0; i10 < length; i10++) {
            String str = strArr[i10];
            Locale locale = Locale.US;
            String lowerCase = str.toLowerCase(locale);
            this.f3739a.put(lowerCase, Integer.valueOf(i10));
            String str2 = map.get(strArr[i10]);
            if (str2 != null) {
                this.f3740b[i10] = str2.toLowerCase(locale);
            } else {
                this.f3740b[i10] = lowerCase;
            }
        }
        for (Map.Entry next : map.entrySet()) {
            Locale locale2 = Locale.US;
            String lowerCase2 = ((String) next.getValue()).toLowerCase(locale2);
            if (this.f3739a.containsKey(lowerCase2)) {
                String lowerCase3 = ((String) next.getKey()).toLowerCase(locale2);
                HashMap<String, Integer> hashMap = this.f3739a;
                hashMap.put(lowerCase3, hashMap.get(lowerCase2));
            }
        }
    }

    private static void b(StringBuilder sb2, String str, String str2) {
        sb2.append("`");
        sb2.append("room_table_modification_trigger_");
        sb2.append(str);
        sb2.append("_");
        sb2.append(str2);
        sb2.append("`");
    }

    private String[] h(String[] strArr) {
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (this.f3741c.containsKey(lowerCase)) {
                hashSet.addAll(this.f3741c.get(lowerCase));
            } else {
                hashSet.add(str);
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    private void j(t1.b bVar, int i10) {
        bVar.execSQL("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i10 + ", 0)");
        String str = this.f3740b[i10];
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : f3738k) {
            sb2.setLength(0);
            sb2.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            b(sb2, str, str2);
            sb2.append(" AFTER ");
            sb2.append(str2);
            sb2.append(" ON `");
            sb2.append(str);
            sb2.append("` BEGIN UPDATE ");
            sb2.append("room_table_modification_log");
            sb2.append(" SET ");
            sb2.append("invalidated");
            sb2.append(" = 1");
            sb2.append(" WHERE ");
            sb2.append("table_id");
            sb2.append(" = ");
            sb2.append(i10);
            sb2.append(" AND ");
            sb2.append("invalidated");
            sb2.append(" = 0");
            sb2.append("; END");
            bVar.execSQL(sb2.toString());
        }
    }

    private void k(t1.b bVar, int i10) {
        String str = this.f3740b[i10];
        StringBuilder sb2 = new StringBuilder();
        for (String b10 : f3738k) {
            sb2.setLength(0);
            sb2.append("DROP TRIGGER IF EXISTS ");
            b(sb2, str, b10);
            bVar.execSQL(sb2.toString());
        }
    }

    @SuppressLint({"RestrictedApi"})
    public void a(c cVar) {
        d u10;
        String[] h10 = h(cVar.f3755a);
        int[] iArr = new int[h10.length];
        int length = h10.length;
        int i10 = 0;
        while (i10 < length) {
            Integer num = this.f3739a.get(h10[i10].toLowerCase(Locale.US));
            if (num != null) {
                iArr[i10] = num.intValue();
                i10++;
            } else {
                throw new IllegalArgumentException("There is no table with name " + h10[i10]);
            }
        }
        d dVar = new d(cVar, iArr, h10);
        synchronized (this.f3747i) {
            u10 = this.f3747i.u(cVar, dVar);
        }
        if (u10 == null && this.f3746h.b(iArr)) {
            l();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        if (!this.f3742d.o()) {
            return false;
        }
        if (!this.f3744f) {
            this.f3742d.i().getWritableDatabase();
        }
        if (this.f3744f) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    /* access modifiers changed from: package-private */
    public void d(t1.b bVar) {
        synchronized (this) {
            if (this.f3744f) {
                Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                return;
            }
            bVar.execSQL("PRAGMA temp_store = MEMORY;");
            bVar.execSQL("PRAGMA recursive_triggers='ON';");
            bVar.execSQL("CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
            m(bVar);
            this.f3745g = bVar.compileStatement("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ");
            this.f3744f = true;
        }
    }

    public void e(String... strArr) {
        synchronized (this.f3747i) {
            Iterator<Map.Entry<c, d>> it = this.f3747i.iterator();
            while (it.hasNext()) {
                Map.Entry next = it.next();
                if (!((c) next.getKey()).a()) {
                    ((d) next.getValue()).b(strArr);
                }
            }
        }
    }

    public void f() {
        if (this.f3743e.compareAndSet(false, true)) {
            this.f3742d.j().execute(this.f3748j);
        }
    }

    @SuppressLint({"RestrictedApi"})
    public void g(c cVar) {
        d v10;
        synchronized (this.f3747i) {
            v10 = this.f3747i.v(cVar);
        }
        if (v10 != null && this.f3746h.c(v10.f3756a)) {
            l();
        }
    }

    /* access modifiers changed from: package-private */
    public void i(Context context, String str) {
        new f(context, str, this, this.f3742d.j());
    }

    /* access modifiers changed from: package-private */
    public void l() {
        if (this.f3742d.o()) {
            m(this.f3742d.i().getWritableDatabase());
        }
    }

    /* access modifiers changed from: package-private */
    public void m(t1.b bVar) {
        if (!bVar.inTransaction()) {
            while (true) {
                try {
                    Lock h10 = this.f3742d.h();
                    h10.lock();
                    try {
                        int[] a10 = this.f3746h.a();
                        if (a10 == null) {
                            h10.unlock();
                            return;
                        }
                        int length = a10.length;
                        bVar.beginTransaction();
                        for (int i10 = 0; i10 < length; i10++) {
                            int i11 = a10[i10];
                            if (i11 == 1) {
                                j(bVar, i10);
                            } else if (i11 == 2) {
                                k(bVar, i10);
                            }
                        }
                        bVar.setTransactionSuccessful();
                        bVar.endTransaction();
                        this.f3746h.d();
                        h10.unlock();
                    } catch (Throwable th) {
                        h10.unlock();
                        throw th;
                    }
                } catch (SQLiteException | IllegalStateException e10) {
                    Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e10);
                    return;
                }
            }
        }
    }
}
