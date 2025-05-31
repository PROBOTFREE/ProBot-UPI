package androidx.work.impl;

import androidx.room.h;
import androidx.room.i;
import i2.b;
import i2.e;
import i2.h;
import i2.k;
import i2.l;
import i2.n;
import i2.o;
import i2.q;
import i2.r;
import i2.t;
import i2.u;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import s1.c;
import s1.f;
import t1.c;

public final class WorkDatabase_Impl extends WorkDatabase {

    /* renamed from: k  reason: collision with root package name */
    private volatile q f4493k;

    /* renamed from: l  reason: collision with root package name */
    private volatile b f4494l;

    /* renamed from: m  reason: collision with root package name */
    private volatile t f4495m;

    /* renamed from: n  reason: collision with root package name */
    private volatile h f4496n;

    /* renamed from: o  reason: collision with root package name */
    private volatile k f4497o;

    /* renamed from: p  reason: collision with root package name */
    private volatile n f4498p;

    /* renamed from: q  reason: collision with root package name */
    private volatile e f4499q;

    class a extends i.a {
        a(int i10) {
            super(i10);
        }

        public void a(t1.b bVar) {
            bVar.execSQL("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            bVar.execSQL("CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
            bVar.execSQL("CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
            bVar.execSQL("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `period_start_time` INTEGER NOT NULL, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `required_network_type` INTEGER, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB, PRIMARY KEY(`id`))");
            bVar.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
            bVar.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `WorkSpec` (`period_start_time`)");
            bVar.execSQL("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            bVar.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
            bVar.execSQL("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            bVar.execSQL("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            bVar.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
            bVar.execSQL("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            bVar.execSQL("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
            bVar.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            bVar.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c103703e120ae8cc73c9248622f3cd1e')");
        }

        public void b(t1.b bVar) {
            bVar.execSQL("DROP TABLE IF EXISTS `Dependency`");
            bVar.execSQL("DROP TABLE IF EXISTS `WorkSpec`");
            bVar.execSQL("DROP TABLE IF EXISTS `WorkTag`");
            bVar.execSQL("DROP TABLE IF EXISTS `SystemIdInfo`");
            bVar.execSQL("DROP TABLE IF EXISTS `WorkName`");
            bVar.execSQL("DROP TABLE IF EXISTS `WorkProgress`");
            bVar.execSQL("DROP TABLE IF EXISTS `Preference`");
            if (WorkDatabase_Impl.this.f3786g != null) {
                int size = WorkDatabase_Impl.this.f3786g.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((h.b) WorkDatabase_Impl.this.f3786g.get(i10)).b(bVar);
                }
            }
        }

        /* access modifiers changed from: protected */
        public void c(t1.b bVar) {
            if (WorkDatabase_Impl.this.f3786g != null) {
                int size = WorkDatabase_Impl.this.f3786g.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((h.b) WorkDatabase_Impl.this.f3786g.get(i10)).a(bVar);
                }
            }
        }

        public void d(t1.b bVar) {
            t1.b unused = WorkDatabase_Impl.this.f3780a = bVar;
            bVar.execSQL("PRAGMA foreign_keys = ON");
            WorkDatabase_Impl.this.m(bVar);
            if (WorkDatabase_Impl.this.f3786g != null) {
                int size = WorkDatabase_Impl.this.f3786g.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((h.b) WorkDatabase_Impl.this.f3786g.get(i10)).c(bVar);
                }
            }
        }

        public void e(t1.b bVar) {
        }

        public void f(t1.b bVar) {
            c.a(bVar);
        }

        /* access modifiers changed from: protected */
        public i.b g(t1.b bVar) {
            t1.b bVar2 = bVar;
            HashMap hashMap = new HashMap(2);
            hashMap.put("work_spec_id", new f.a("work_spec_id", "TEXT", true, 1, (String) null, 1));
            hashMap.put("prerequisite_id", new f.a("prerequisite_id", "TEXT", true, 2, (String) null, 1));
            HashSet hashSet = new HashSet(2);
            hashSet.add(new f.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
            hashSet.add(new f.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"prerequisite_id"}), Arrays.asList(new String[]{"id"})));
            HashSet hashSet2 = new HashSet(2);
            hashSet2.add(new f.d("index_Dependency_work_spec_id", false, Arrays.asList(new String[]{"work_spec_id"})));
            hashSet2.add(new f.d("index_Dependency_prerequisite_id", false, Arrays.asList(new String[]{"prerequisite_id"})));
            f fVar = new f("Dependency", hashMap, hashSet, hashSet2);
            f a10 = f.a(bVar2, "Dependency");
            if (!fVar.equals(a10)) {
                return new i.b(false, "Dependency(androidx.work.impl.model.Dependency).\n Expected:\n" + fVar + "\n Found:\n" + a10);
            }
            HashMap hashMap2 = new HashMap(25);
            hashMap2.put("id", new f.a("id", "TEXT", true, 1, (String) null, 1));
            hashMap2.put("state", new f.a("state", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("worker_class_name", new f.a("worker_class_name", "TEXT", true, 0, (String) null, 1));
            hashMap2.put("input_merger_class_name", new f.a("input_merger_class_name", "TEXT", false, 0, (String) null, 1));
            hashMap2.put("input", new f.a("input", "BLOB", true, 0, (String) null, 1));
            hashMap2.put("output", new f.a("output", "BLOB", true, 0, (String) null, 1));
            hashMap2.put("initial_delay", new f.a("initial_delay", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("interval_duration", new f.a("interval_duration", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("flex_duration", new f.a("flex_duration", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("run_attempt_count", new f.a("run_attempt_count", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("backoff_policy", new f.a("backoff_policy", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("backoff_delay_duration", new f.a("backoff_delay_duration", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("period_start_time", new f.a("period_start_time", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("minimum_retention_duration", new f.a("minimum_retention_duration", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("schedule_requested_at", new f.a("schedule_requested_at", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("run_in_foreground", new f.a("run_in_foreground", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("out_of_quota_policy", new f.a("out_of_quota_policy", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("required_network_type", new f.a("required_network_type", "INTEGER", false, 0, (String) null, 1));
            hashMap2.put("requires_charging", new f.a("requires_charging", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("requires_device_idle", new f.a("requires_device_idle", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("requires_battery_not_low", new f.a("requires_battery_not_low", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("requires_storage_not_low", new f.a("requires_storage_not_low", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("trigger_content_update_delay", new f.a("trigger_content_update_delay", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("trigger_max_content_delay", new f.a("trigger_max_content_delay", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("content_uri_triggers", new f.a("content_uri_triggers", "BLOB", false, 0, (String) null, 1));
            HashSet hashSet3 = new HashSet(0);
            HashSet hashSet4 = new HashSet(2);
            hashSet4.add(new f.d("index_WorkSpec_schedule_requested_at", false, Arrays.asList(new String[]{"schedule_requested_at"})));
            hashSet4.add(new f.d("index_WorkSpec_period_start_time", false, Arrays.asList(new String[]{"period_start_time"})));
            f fVar2 = new f("WorkSpec", hashMap2, hashSet3, hashSet4);
            f a11 = f.a(bVar2, "WorkSpec");
            if (!fVar2.equals(a11)) {
                return new i.b(false, "WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n" + fVar2 + "\n Found:\n" + a11);
            }
            HashMap hashMap3 = new HashMap(2);
            hashMap3.put("tag", new f.a("tag", "TEXT", true, 1, (String) null, 1));
            hashMap3.put("work_spec_id", new f.a("work_spec_id", "TEXT", true, 2, (String) null, 1));
            HashSet hashSet5 = new HashSet(1);
            hashSet5.add(new f.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
            HashSet hashSet6 = new HashSet(1);
            hashSet6.add(new f.d("index_WorkTag_work_spec_id", false, Arrays.asList(new String[]{"work_spec_id"})));
            f fVar3 = new f("WorkTag", hashMap3, hashSet5, hashSet6);
            f a12 = f.a(bVar2, "WorkTag");
            if (!fVar3.equals(a12)) {
                return new i.b(false, "WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n" + fVar3 + "\n Found:\n" + a12);
            }
            HashMap hashMap4 = new HashMap(2);
            hashMap4.put("work_spec_id", new f.a("work_spec_id", "TEXT", true, 1, (String) null, 1));
            hashMap4.put("system_id", new f.a("system_id", "INTEGER", true, 0, (String) null, 1));
            HashSet hashSet7 = new HashSet(1);
            hashSet7.add(new f.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
            f fVar4 = new f("SystemIdInfo", hashMap4, hashSet7, new HashSet(0));
            f a13 = f.a(bVar2, "SystemIdInfo");
            if (!fVar4.equals(a13)) {
                return new i.b(false, "SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n" + fVar4 + "\n Found:\n" + a13);
            }
            HashMap hashMap5 = new HashMap(2);
            hashMap5.put("name", new f.a("name", "TEXT", true, 1, (String) null, 1));
            hashMap5.put("work_spec_id", new f.a("work_spec_id", "TEXT", true, 2, (String) null, 1));
            HashSet hashSet8 = new HashSet(1);
            hashSet8.add(new f.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
            HashSet hashSet9 = new HashSet(1);
            hashSet9.add(new f.d("index_WorkName_work_spec_id", false, Arrays.asList(new String[]{"work_spec_id"})));
            f fVar5 = new f("WorkName", hashMap5, hashSet8, hashSet9);
            f a14 = f.a(bVar2, "WorkName");
            if (!fVar5.equals(a14)) {
                return new i.b(false, "WorkName(androidx.work.impl.model.WorkName).\n Expected:\n" + fVar5 + "\n Found:\n" + a14);
            }
            HashMap hashMap6 = new HashMap(2);
            hashMap6.put("work_spec_id", new f.a("work_spec_id", "TEXT", true, 1, (String) null, 1));
            hashMap6.put("progress", new f.a("progress", "BLOB", true, 0, (String) null, 1));
            HashSet hashSet10 = new HashSet(1);
            hashSet10.add(new f.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
            f fVar6 = new f("WorkProgress", hashMap6, hashSet10, new HashSet(0));
            f a15 = f.a(bVar2, "WorkProgress");
            if (!fVar6.equals(a15)) {
                return new i.b(false, "WorkProgress(androidx.work.impl.model.WorkProgress).\n Expected:\n" + fVar6 + "\n Found:\n" + a15);
            }
            HashMap hashMap7 = new HashMap(2);
            hashMap7.put("key", new f.a("key", "TEXT", true, 1, (String) null, 1));
            hashMap7.put("long_value", new f.a("long_value", "INTEGER", false, 0, (String) null, 1));
            f fVar7 = new f("Preference", hashMap7, new HashSet(0), new HashSet(0));
            f a16 = f.a(bVar2, "Preference");
            if (fVar7.equals(a16)) {
                return new i.b(true, (String) null);
            }
            return new i.b(false, "Preference(androidx.work.impl.model.Preference).\n Expected:\n" + fVar7 + "\n Found:\n" + a16);
        }
    }

    public n A() {
        n nVar;
        if (this.f4498p != null) {
            return this.f4498p;
        }
        synchronized (this) {
            if (this.f4498p == null) {
                this.f4498p = new o(this);
            }
            nVar = this.f4498p;
        }
        return nVar;
    }

    public q B() {
        q qVar;
        if (this.f4493k != null) {
            return this.f4493k;
        }
        synchronized (this) {
            if (this.f4493k == null) {
                this.f4493k = new r(this);
            }
            qVar = this.f4493k;
        }
        return qVar;
    }

    public t C() {
        t tVar;
        if (this.f4495m != null) {
            return this.f4495m;
        }
        synchronized (this) {
            if (this.f4495m == null) {
                this.f4495m = new u(this);
            }
            tVar = this.f4495m;
        }
        return tVar;
    }

    /* access modifiers changed from: protected */
    public androidx.room.e e() {
        return new androidx.room.e(this, new HashMap(0), new HashMap(0), "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference");
    }

    /* access modifiers changed from: protected */
    public t1.c f(androidx.room.a aVar) {
        return aVar.f3723a.create(c.b.a(aVar.f3724b).c(aVar.f3725c).b(new i(aVar, new a(12), "c103703e120ae8cc73c9248622f3cd1e", "49f946663a8deb7054212b8adda248c6")).a());
    }

    public b t() {
        b bVar;
        if (this.f4494l != null) {
            return this.f4494l;
        }
        synchronized (this) {
            if (this.f4494l == null) {
                this.f4494l = new i2.c(this);
            }
            bVar = this.f4494l;
        }
        return bVar;
    }

    public e x() {
        e eVar;
        if (this.f4499q != null) {
            return this.f4499q;
        }
        synchronized (this) {
            if (this.f4499q == null) {
                this.f4499q = new i2.f(this);
            }
            eVar = this.f4499q;
        }
        return eVar;
    }

    public i2.h y() {
        i2.h hVar;
        if (this.f4496n != null) {
            return this.f4496n;
        }
        synchronized (this) {
            if (this.f4496n == null) {
                this.f4496n = new i2.i(this);
            }
            hVar = this.f4496n;
        }
        return hVar;
    }

    public k z() {
        k kVar;
        if (this.f4497o != null) {
            return this.f4497o;
        }
        synchronized (this) {
            if (this.f4497o == null) {
                this.f4497o = new l(this);
            }
            kVar = this.f4497o;
        }
        return kVar;
    }
}
