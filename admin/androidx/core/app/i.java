package androidx.core.app;

import android.app.Notification;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.app.h;
import androidx.core.graphics.drawable.IconCompat;
import c0.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class i implements g {

    /* renamed from: a  reason: collision with root package name */
    private final Context f2249a;

    /* renamed from: b  reason: collision with root package name */
    private final Notification.Builder f2250b;

    /* renamed from: c  reason: collision with root package name */
    private final h.e f2251c;

    /* renamed from: d  reason: collision with root package name */
    private RemoteViews f2252d;

    /* renamed from: e  reason: collision with root package name */
    private RemoteViews f2253e;

    /* renamed from: f  reason: collision with root package name */
    private final List<Bundle> f2254f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private final Bundle f2255g = new Bundle();

    /* renamed from: h  reason: collision with root package name */
    private int f2256h;

    /* renamed from: i  reason: collision with root package name */
    private RemoteViews f2257i;

    i(h.e eVar) {
        Notification.Builder builder;
        Icon icon;
        List<String> e10;
        String str;
        Bundle bundle;
        this.f2251c = eVar;
        this.f2249a = eVar.f2219a;
        int i10 = Build.VERSION.SDK_INT;
        Context context = eVar.f2219a;
        if (i10 >= 26) {
            String str2 = eVar.K;
        } else {
            builder = new Notification.Builder(context);
        }
        this.f2250b = builder;
        Notification notification = eVar.R;
        this.f2250b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, eVar.f2227i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(eVar.f2223e).setContentText(eVar.f2224f).setContentInfo(eVar.f2229k).setContentIntent(eVar.f2225g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(eVar.f2226h, (notification.flags & 128) != 0).setLargeIcon(eVar.f2228j).setNumber(eVar.f2230l).setProgress(eVar.f2238t, eVar.f2239u, eVar.f2240v);
        if (i10 < 21) {
            this.f2250b.setSound(notification.sound, notification.audioStreamType);
        }
        if (i10 >= 16) {
            this.f2250b.setSubText(eVar.f2235q).setUsesChronometer(eVar.f2233o).setPriority(eVar.f2231m);
            Iterator<h.a> it = eVar.f2220b.iterator();
            while (it.hasNext()) {
                b(it.next());
            }
            Bundle bundle2 = eVar.D;
            if (bundle2 != null) {
                this.f2255g.putAll(bundle2);
            }
            if (Build.VERSION.SDK_INT < 20) {
                if (eVar.f2244z) {
                    this.f2255g.putBoolean("android.support.localOnly", true);
                }
                String str3 = eVar.f2241w;
                if (str3 != null) {
                    this.f2255g.putString("android.support.groupKey", str3);
                    if (eVar.f2242x) {
                        bundle = this.f2255g;
                        str = "android.support.isGroupSummary";
                    } else {
                        bundle = this.f2255g;
                        str = "android.support.useSideChannel";
                    }
                    bundle.putBoolean(str, true);
                }
                String str4 = eVar.f2243y;
                if (str4 != null) {
                    this.f2255g.putString("android.support.sortKey", str4);
                }
            }
            this.f2252d = eVar.H;
            this.f2253e = eVar.I;
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 17) {
            this.f2250b.setShowWhen(eVar.f2232n);
        }
        if (i11 >= 19 && i11 < 21 && (e10 = e(g(eVar.f2221c), eVar.U)) != null && !e10.isEmpty()) {
            this.f2255g.putStringArray("android.people", (String[]) e10.toArray(new String[e10.size()]));
        }
        if (i11 >= 20) {
            this.f2250b.setLocalOnly(eVar.f2244z).setGroup(eVar.f2241w).setGroupSummary(eVar.f2242x).setSortKey(eVar.f2243y);
            this.f2256h = eVar.O;
        }
        if (i11 >= 21) {
            this.f2250b.setCategory(eVar.C).setColor(eVar.E).setVisibility(eVar.F).setPublicVersion(eVar.G).setSound(notification.sound, notification.audioAttributes);
            List<String> e11 = i11 < 28 ? e(g(eVar.f2221c), eVar.U) : eVar.U;
            if (e11 != null && !e11.isEmpty()) {
                for (String addPerson : e11) {
                    this.f2250b.addPerson(addPerson);
                }
            }
            this.f2257i = eVar.J;
            if (eVar.f2222d.size() > 0) {
                Bundle bundle3 = eVar.c().getBundle("android.car.EXTENSIONS");
                bundle3 = bundle3 == null ? new Bundle() : bundle3;
                Bundle bundle4 = new Bundle(bundle3);
                Bundle bundle5 = new Bundle();
                for (int i12 = 0; i12 < eVar.f2222d.size(); i12++) {
                    bundle5.putBundle(Integer.toString(i12), j.b(eVar.f2222d.get(i12)));
                }
                bundle3.putBundle("invisible_actions", bundle5);
                bundle4.putBundle("invisible_actions", bundle5);
                eVar.c().putBundle("android.car.EXTENSIONS", bundle3);
                this.f2255g.putBundle("android.car.EXTENSIONS", bundle4);
            }
        }
        int i13 = Build.VERSION.SDK_INT;
        if (i13 >= 23 && (icon = eVar.T) != null) {
            this.f2250b.setSmallIcon(icon);
        }
        if (i13 >= 24) {
            this.f2250b.setExtras(eVar.D).setRemoteInputHistory(eVar.f2237s);
            RemoteViews remoteViews = eVar.H;
            if (remoteViews != null) {
                this.f2250b.setCustomContentView(remoteViews);
            }
            RemoteViews remoteViews2 = eVar.I;
            if (remoteViews2 != null) {
                this.f2250b.setCustomBigContentView(remoteViews2);
            }
            RemoteViews remoteViews3 = eVar.J;
            if (remoteViews3 != null) {
                this.f2250b.setCustomHeadsUpContentView(remoteViews3);
            }
        }
        if (i13 >= 26) {
            this.f2250b.setBadgeIconType(eVar.L).setSettingsText(eVar.f2236r).setShortcutId(eVar.M).setTimeoutAfter(eVar.N).setGroupAlertBehavior(eVar.O);
            if (eVar.B) {
                this.f2250b.setColorized(eVar.A);
            }
            if (!TextUtils.isEmpty(eVar.K)) {
                this.f2250b.setSound((Uri) null).setDefaults(0).setLights(0, 0, 0).setVibrate((long[]) null);
            }
        }
        if (i13 >= 28) {
            Iterator<k> it2 = eVar.f2221c.iterator();
            while (it2.hasNext()) {
                this.f2250b.addPerson(it2.next().h());
            }
        }
        int i14 = Build.VERSION.SDK_INT;
        if (i14 >= 29) {
            this.f2250b.setAllowSystemGeneratedContextualActions(eVar.P);
            this.f2250b.setBubbleMetadata(h.d.a(eVar.Q));
        }
        if (eVar.S) {
            if (this.f2251c.f2242x) {
                this.f2256h = 2;
            } else {
                this.f2256h = 1;
            }
            this.f2250b.setVibrate((long[]) null);
            this.f2250b.setSound((Uri) null);
            int i15 = notification.defaults & -2;
            notification.defaults = i15;
            int i16 = i15 & -3;
            notification.defaults = i16;
            this.f2250b.setDefaults(i16);
            if (i14 >= 26) {
                if (TextUtils.isEmpty(this.f2251c.f2241w)) {
                    this.f2250b.setGroup("silent");
                }
                this.f2250b.setGroupAlertBehavior(this.f2256h);
            }
        }
    }

    private void b(h.a aVar) {
        Notification.Action.Builder builder;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 20) {
            IconCompat e10 = aVar.e();
            if (i10 >= 23) {
                builder = new Notification.Action.Builder(e10 != null ? e10.p() : null, aVar.i(), aVar.a());
            } else {
                builder = new Notification.Action.Builder(e10 != null ? e10.e() : 0, aVar.i(), aVar.a());
            }
            if (aVar.f() != null) {
                for (RemoteInput addRemoteInput : l.b(aVar.f())) {
                    builder.addRemoteInput(addRemoteInput);
                }
            }
            Bundle bundle = aVar.d() != null ? new Bundle(aVar.d()) : new Bundle();
            bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 24) {
                builder.setAllowGeneratedReplies(aVar.b());
            }
            bundle.putInt("android.support.action.semanticAction", aVar.g());
            if (i11 >= 28) {
                builder.setSemanticAction(aVar.g());
            }
            if (i11 >= 29) {
                builder.setContextual(aVar.j());
            }
            bundle.putBoolean("android.support.action.showsUserInterface", aVar.h());
            builder.addExtras(bundle);
            this.f2250b.addAction(builder.build());
        } else if (i10 >= 16) {
            this.f2254f.add(j.f(this.f2250b, aVar));
        }
    }

    private static List<String> e(List<String> list, List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        b bVar = new b(list.size() + list2.size());
        bVar.addAll(list);
        bVar.addAll(list2);
        return new ArrayList(bVar);
    }

    private static List<String> g(List<k> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (k g10 : list) {
            arrayList.add(g10.g());
        }
        return arrayList;
    }

    private void h(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        int i10 = notification.defaults & -2;
        notification.defaults = i10;
        notification.defaults = i10 & -3;
    }

    public Notification.Builder a() {
        return this.f2250b;
    }

    public Notification c() {
        Bundle a10;
        RemoteViews f10;
        RemoteViews d10;
        h.f fVar = this.f2251c.f2234p;
        if (fVar != null) {
            fVar.b(this);
        }
        RemoteViews e10 = fVar != null ? fVar.e(this) : null;
        Notification d11 = d();
        if (!(e10 == null && (e10 = this.f2251c.H) == null)) {
            d11.contentView = e10;
        }
        int i10 = Build.VERSION.SDK_INT;
        if (!(i10 < 16 || fVar == null || (d10 = fVar.d(this)) == null)) {
            d11.bigContentView = d10;
        }
        if (!(i10 < 21 || fVar == null || (f10 = this.f2251c.f2234p.f(this)) == null)) {
            d11.headsUpContentView = f10;
        }
        if (!(i10 < 16 || fVar == null || (a10 = h.a(d11)) == null)) {
            fVar.a(a10);
        }
        return d11;
    }

    /* access modifiers changed from: protected */
    public Notification d() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26) {
            return this.f2250b.build();
        }
        if (i10 >= 24) {
            Notification build = this.f2250b.build();
            if (this.f2256h != 0) {
                if (!(build.getGroup() == null || (build.flags & 512) == 0 || this.f2256h != 2)) {
                    h(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.f2256h == 1) {
                    h(build);
                }
            }
            return build;
        } else if (i10 >= 21) {
            this.f2250b.setExtras(this.f2255g);
            Notification build2 = this.f2250b.build();
            RemoteViews remoteViews = this.f2252d;
            if (remoteViews != null) {
                build2.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.f2253e;
            if (remoteViews2 != null) {
                build2.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = this.f2257i;
            if (remoteViews3 != null) {
                build2.headsUpContentView = remoteViews3;
            }
            if (this.f2256h != 0) {
                if (!(build2.getGroup() == null || (build2.flags & 512) == 0 || this.f2256h != 2)) {
                    h(build2);
                }
                if (build2.getGroup() != null && (build2.flags & 512) == 0 && this.f2256h == 1) {
                    h(build2);
                }
            }
            return build2;
        } else if (i10 >= 20) {
            this.f2250b.setExtras(this.f2255g);
            Notification build3 = this.f2250b.build();
            RemoteViews remoteViews4 = this.f2252d;
            if (remoteViews4 != null) {
                build3.contentView = remoteViews4;
            }
            RemoteViews remoteViews5 = this.f2253e;
            if (remoteViews5 != null) {
                build3.bigContentView = remoteViews5;
            }
            if (this.f2256h != 0) {
                if (!(build3.getGroup() == null || (build3.flags & 512) == 0 || this.f2256h != 2)) {
                    h(build3);
                }
                if (build3.getGroup() != null && (build3.flags & 512) == 0 && this.f2256h == 1) {
                    h(build3);
                }
            }
            return build3;
        } else if (i10 >= 19) {
            SparseArray<Bundle> a10 = j.a(this.f2254f);
            if (a10 != null) {
                this.f2255g.putSparseParcelableArray("android.support.actionExtras", a10);
            }
            this.f2250b.setExtras(this.f2255g);
            Notification build4 = this.f2250b.build();
            RemoteViews remoteViews6 = this.f2252d;
            if (remoteViews6 != null) {
                build4.contentView = remoteViews6;
            }
            RemoteViews remoteViews7 = this.f2253e;
            if (remoteViews7 != null) {
                build4.bigContentView = remoteViews7;
            }
            return build4;
        } else if (i10 < 16) {
            return this.f2250b.getNotification();
        } else {
            Notification build5 = this.f2250b.build();
            Bundle a11 = h.a(build5);
            Bundle bundle = new Bundle(this.f2255g);
            for (String str : this.f2255g.keySet()) {
                if (a11.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            a11.putAll(bundle);
            SparseArray<Bundle> a12 = j.a(this.f2254f);
            if (a12 != null) {
                h.a(build5).putSparseParcelableArray("android.support.actionExtras", a12);
            }
            RemoteViews remoteViews8 = this.f2252d;
            if (remoteViews8 != null) {
                build5.contentView = remoteViews8;
            }
            RemoteViews remoteViews9 = this.f2253e;
            if (remoteViews9 != null) {
                build5.bigContentView = remoteViews9;
            }
            return build5;
        }
    }

    /* access modifiers changed from: package-private */
    public Context f() {
        return this.f2249a;
    }
}
