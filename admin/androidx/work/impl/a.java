package androidx.work.impl;

import android.content.Context;
import android.os.Build;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static r1.a f4501a = new C0052a(1, 2);

    /* renamed from: b  reason: collision with root package name */
    public static r1.a f4502b = new b(3, 4);

    /* renamed from: c  reason: collision with root package name */
    public static r1.a f4503c = new c(4, 5);

    /* renamed from: d  reason: collision with root package name */
    public static r1.a f4504d = new d(6, 7);

    /* renamed from: e  reason: collision with root package name */
    public static r1.a f4505e = new e(7, 8);

    /* renamed from: f  reason: collision with root package name */
    public static r1.a f4506f = new f(8, 9);

    /* renamed from: g  reason: collision with root package name */
    public static r1.a f4507g = new g(11, 12);

    /* renamed from: androidx.work.impl.a$a  reason: collision with other inner class name */
    class C0052a extends r1.a {
        C0052a(int i10, int i11) {
            super(i10, i11);
        }

        public void a(t1.b bVar) {
            bVar.execSQL("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            bVar.execSQL("INSERT INTO SystemIdInfo(work_spec_id, system_id) SELECT work_spec_id, alarm_id AS system_id FROM alarmInfo");
            bVar.execSQL("DROP TABLE IF EXISTS alarmInfo");
            bVar.execSQL("INSERT OR IGNORE INTO worktag(tag, work_spec_id) SELECT worker_class_name AS tag, id AS work_spec_id FROM workspec");
        }
    }

    class b extends r1.a {
        b(int i10, int i11) {
            super(i10, i11);
        }

        public void a(t1.b bVar) {
            if (Build.VERSION.SDK_INT >= 23) {
                bVar.execSQL("UPDATE workspec SET schedule_requested_at=0 WHERE state NOT IN (2, 3, 5) AND schedule_requested_at=-1 AND interval_duration<>0");
            }
        }
    }

    class c extends r1.a {
        c(int i10, int i11) {
            super(i10, i11);
        }

        public void a(t1.b bVar) {
            bVar.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_content_update_delay` INTEGER NOT NULL DEFAULT -1");
            bVar.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_max_content_delay` INTEGER NOT NULL DEFAULT -1");
        }
    }

    class d extends r1.a {
        d(int i10, int i11) {
            super(i10, i11);
        }

        public void a(t1.b bVar) {
            bVar.execSQL("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        }
    }

    class e extends r1.a {
        e(int i10, int i11) {
            super(i10, i11);
        }

        public void a(t1.b bVar) {
            bVar.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `workspec` (`period_start_time`)");
        }
    }

    class f extends r1.a {
        f(int i10, int i11) {
            super(i10, i11);
        }

        public void a(t1.b bVar) {
            bVar.execSQL("ALTER TABLE workspec ADD COLUMN `run_in_foreground` INTEGER NOT NULL DEFAULT 0");
        }
    }

    class g extends r1.a {
        g(int i10, int i11) {
            super(i10, i11);
        }

        public void a(t1.b bVar) {
            bVar.execSQL("ALTER TABLE workspec ADD COLUMN `out_of_quota_policy` INTEGER NOT NULL DEFAULT 0");
        }
    }

    public static class h extends r1.a {

        /* renamed from: c  reason: collision with root package name */
        final Context f4508c;

        public h(Context context, int i10, int i11) {
            super(i10, i11);
            this.f4508c = context;
        }

        public void a(t1.b bVar) {
            if (this.f16838b >= 10) {
                bVar.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", 1});
                return;
            }
            this.f4508c.getSharedPreferences("androidx.work.util.preferences", 0).edit().putBoolean("reschedule_needed", true).apply();
        }
    }

    public static class i extends r1.a {

        /* renamed from: c  reason: collision with root package name */
        final Context f4509c;

        public i(Context context) {
            super(9, 10);
            this.f4509c = context;
        }

        public void a(t1.b bVar) {
            bVar.execSQL("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
            j2.e.b(this.f4509c, bVar);
            j2.c.a(this.f4509c, bVar);
        }
    }
}
