package androidx.room;

import android.content.Context;
import androidx.room.h;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import t1.c;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final c.C0218c f3723a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f3724b;

    /* renamed from: c  reason: collision with root package name */
    public final String f3725c;

    /* renamed from: d  reason: collision with root package name */
    public final h.d f3726d;

    /* renamed from: e  reason: collision with root package name */
    public final List<h.b> f3727e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f3728f;

    /* renamed from: g  reason: collision with root package name */
    public final h.c f3729g;

    /* renamed from: h  reason: collision with root package name */
    public final Executor f3730h;

    /* renamed from: i  reason: collision with root package name */
    public final Executor f3731i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f3732j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f3733k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f3734l;

    /* renamed from: m  reason: collision with root package name */
    private final Set<Integer> f3735m;

    public a(Context context, String str, c.C0218c cVar, h.d dVar, List<h.b> list, boolean z10, h.c cVar2, Executor executor, Executor executor2, boolean z11, boolean z12, boolean z13, Set<Integer> set, String str2, File file) {
        this.f3723a = cVar;
        this.f3724b = context;
        this.f3725c = str;
        this.f3726d = dVar;
        this.f3727e = list;
        this.f3728f = z10;
        this.f3729g = cVar2;
        this.f3730h = executor;
        this.f3731i = executor2;
        this.f3732j = z11;
        this.f3733k = z12;
        this.f3734l = z13;
        this.f3735m = set;
    }

    public boolean a(int i10, int i11) {
        Set<Integer> set;
        if (!(i10 > i11) || !this.f3734l) {
            return this.f3733k && ((set = this.f3735m) == null || !set.contains(Integer.valueOf(i10)));
        }
        return false;
    }
}
