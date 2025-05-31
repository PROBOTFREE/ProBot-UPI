package androidx.room;

import android.database.Cursor;
import java.util.List;
import t1.c;
import t1.e;

public class i extends c.a {

    /* renamed from: b  reason: collision with root package name */
    private a f3811b;

    /* renamed from: c  reason: collision with root package name */
    private final a f3812c;

    /* renamed from: d  reason: collision with root package name */
    private final String f3813d;

    /* renamed from: e  reason: collision with root package name */
    private final String f3814e;

    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f3815a;

        public a(int i10) {
            this.f3815a = i10;
        }

        /* access modifiers changed from: protected */
        public abstract void a(t1.b bVar);

        /* access modifiers changed from: protected */
        public abstract void b(t1.b bVar);

        /* access modifiers changed from: protected */
        public abstract void c(t1.b bVar);

        /* access modifiers changed from: protected */
        public abstract void d(t1.b bVar);

        /* access modifiers changed from: protected */
        public abstract void e(t1.b bVar);

        /* access modifiers changed from: protected */
        public abstract void f(t1.b bVar);

        /* access modifiers changed from: protected */
        public abstract b g(t1.b bVar);
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f3816a;

        /* renamed from: b  reason: collision with root package name */
        public final String f3817b;

        public b(boolean z10, String str) {
            this.f3816a = z10;
            this.f3817b = str;
        }
    }

    public i(a aVar, a aVar2, String str, String str2) {
        super(aVar2.f3815a);
        this.f3811b = aVar;
        this.f3812c = aVar2;
        this.f3813d = str;
        this.f3814e = str2;
    }

    /* JADX INFO: finally extract failed */
    private void h(t1.b bVar) {
        if (k(bVar)) {
            String str = null;
            Cursor query = bVar.query((e) new t1.a("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
            try {
                if (query.moveToFirst()) {
                    str = query.getString(0);
                }
                query.close();
                if (!this.f3813d.equals(str) && !this.f3814e.equals(str)) {
                    throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
                }
            } catch (Throwable th) {
                query.close();
                throw th;
            }
        } else {
            b g10 = this.f3812c.g(bVar);
            if (g10.f3816a) {
                this.f3812c.e(bVar);
                l(bVar);
                return;
            }
            throw new IllegalStateException("Pre-packaged database has an invalid schema: " + g10.f3817b);
        }
    }

    private void i(t1.b bVar) {
        bVar.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    private static boolean j(t1.b bVar) {
        Cursor query = bVar.query("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z10 = false;
            if (query.moveToFirst() && query.getInt(0) == 0) {
                z10 = true;
            }
            return z10;
        } finally {
            query.close();
        }
    }

    private static boolean k(t1.b bVar) {
        Cursor query = bVar.query("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
        try {
            boolean z10 = false;
            if (query.moveToFirst() && query.getInt(0) != 0) {
                z10 = true;
            }
            return z10;
        } finally {
            query.close();
        }
    }

    private void l(t1.b bVar) {
        i(bVar);
        bVar.execSQL(q1.b.a(this.f3813d));
    }

    public void b(t1.b bVar) {
        super.b(bVar);
    }

    public void d(t1.b bVar) {
        boolean j10 = j(bVar);
        this.f3812c.a(bVar);
        if (!j10) {
            b g10 = this.f3812c.g(bVar);
            if (!g10.f3816a) {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + g10.f3817b);
            }
        }
        l(bVar);
        this.f3812c.c(bVar);
    }

    public void e(t1.b bVar, int i10, int i11) {
        g(bVar, i10, i11);
    }

    public void f(t1.b bVar) {
        super.f(bVar);
        h(bVar);
        this.f3812c.d(bVar);
        this.f3811b = null;
    }

    public void g(t1.b bVar, int i10, int i11) {
        boolean z10;
        List<r1.a> c10;
        a aVar = this.f3811b;
        if (aVar == null || (c10 = aVar.f3726d.c(i10, i11)) == null) {
            z10 = false;
        } else {
            this.f3812c.f(bVar);
            for (r1.a a10 : c10) {
                a10.a(bVar);
            }
            b g10 = this.f3812c.g(bVar);
            if (g10.f3816a) {
                this.f3812c.e(bVar);
                l(bVar);
                z10 = true;
            } else {
                throw new IllegalStateException("Migration didn't properly handle: " + g10.f3817b);
            }
        }
        if (!z10) {
            a aVar2 = this.f3811b;
            if (aVar2 == null || aVar2.a(i10, i11)) {
                throw new IllegalStateException("A migration from " + i10 + " to " + i11 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
            }
            this.f3812c.b(bVar);
            this.f3812c.a(bVar);
        }
    }
}
