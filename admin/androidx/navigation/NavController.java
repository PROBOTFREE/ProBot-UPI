package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.activity.OnBackPressedDispatcher;
import androidx.lifecycle.f0;
import androidx.lifecycle.h;
import androidx.lifecycle.m;
import androidx.lifecycle.n;
import androidx.lifecycle.o;
import androidx.navigation.i;
import androidx.navigation.n;
import androidx.navigation.q;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class NavController {

    /* renamed from: a  reason: collision with root package name */
    private final Context f3093a;

    /* renamed from: b  reason: collision with root package name */
    private Activity f3094b;

    /* renamed from: c  reason: collision with root package name */
    private m f3095c;

    /* renamed from: d  reason: collision with root package name */
    j f3096d;

    /* renamed from: e  reason: collision with root package name */
    private Bundle f3097e;

    /* renamed from: f  reason: collision with root package name */
    private Parcelable[] f3098f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f3099g;

    /* renamed from: h  reason: collision with root package name */
    final Deque<e> f3100h = new ArrayDeque();

    /* renamed from: i  reason: collision with root package name */
    private o f3101i;

    /* renamed from: j  reason: collision with root package name */
    private f f3102j;

    /* renamed from: k  reason: collision with root package name */
    private r f3103k = new r();

    /* renamed from: l  reason: collision with root package name */
    private final CopyOnWriteArrayList<b> f3104l = new CopyOnWriteArrayList<>();

    /* renamed from: m  reason: collision with root package name */
    private final n f3105m = new m() {
        public void c(o oVar, h.b bVar) {
            NavController navController = NavController.this;
            if (navController.f3096d != null) {
                for (e e10 : navController.f3100h) {
                    e10.e(bVar);
                }
            }
        }
    };

    /* renamed from: n  reason: collision with root package name */
    private final androidx.activity.b f3106n = new a(false);

    /* renamed from: o  reason: collision with root package name */
    private boolean f3107o = true;

    class a extends androidx.activity.b {
        a(boolean z10) {
            super(z10);
        }

        public void handleOnBackPressed() {
            NavController.this.q();
        }
    }

    public interface b {
        void a(NavController navController, i iVar, Bundle bundle);
    }

    public NavController(Context context) {
        this.f3093a = context;
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                break;
            } else if (context instanceof Activity) {
                this.f3094b = (Activity) context;
                break;
            } else {
                context = ((ContextWrapper) context).getBaseContext();
            }
        }
        r rVar = this.f3103k;
        rVar.a(new k(rVar));
        this.f3103k.a(new a(this.f3093a));
    }

    private void B() {
        androidx.activity.b bVar = this.f3106n;
        boolean z10 = true;
        if (!this.f3107o || g() <= 1) {
            z10 = false;
        }
        bVar.setEnabled(z10);
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:5:0x002d, LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a() {
        /*
            r10 = this;
        L_0x0000:
            java.util.Deque<androidx.navigation.e> r0 = r10.f3100h
            boolean r0 = r0.isEmpty()
            r1 = 1
            if (r0 != 0) goto L_0x0030
            java.util.Deque<androidx.navigation.e> r0 = r10.f3100h
            java.lang.Object r0 = r0.peekLast()
            androidx.navigation.e r0 = (androidx.navigation.e) r0
            androidx.navigation.i r0 = r0.b()
            boolean r0 = r0 instanceof androidx.navigation.j
            if (r0 == 0) goto L_0x0030
            java.util.Deque<androidx.navigation.e> r0 = r10.f3100h
            java.lang.Object r0 = r0.peekLast()
            androidx.navigation.e r0 = (androidx.navigation.e) r0
            androidx.navigation.i r0 = r0.b()
            int r0 = r0.w()
            boolean r0 = r10.s(r0, r1)
            if (r0 == 0) goto L_0x0030
            goto L_0x0000
        L_0x0030:
            java.util.Deque<androidx.navigation.e> r0 = r10.f3100h
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0110
            java.util.Deque<androidx.navigation.e> r0 = r10.f3100h
            java.lang.Object r0 = r0.peekLast()
            androidx.navigation.e r0 = (androidx.navigation.e) r0
            androidx.navigation.i r0 = r0.b()
            r2 = 0
            boolean r3 = r0 instanceof androidx.navigation.b
            if (r3 == 0) goto L_0x0068
            java.util.Deque<androidx.navigation.e> r3 = r10.f3100h
            java.util.Iterator r3 = r3.descendingIterator()
        L_0x004f:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0068
            java.lang.Object r4 = r3.next()
            androidx.navigation.e r4 = (androidx.navigation.e) r4
            androidx.navigation.i r4 = r4.b()
            boolean r5 = r4 instanceof androidx.navigation.j
            if (r5 != 0) goto L_0x004f
            boolean r5 = r4 instanceof androidx.navigation.b
            if (r5 != 0) goto L_0x004f
            r2 = r4
        L_0x0068:
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.util.Deque<androidx.navigation.e> r4 = r10.f3100h
            java.util.Iterator r4 = r4.descendingIterator()
        L_0x0073:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x00c7
            java.lang.Object r5 = r4.next()
            androidx.navigation.e r5 = (androidx.navigation.e) r5
            androidx.lifecycle.h$c r6 = r5.c()
            androidx.navigation.i r7 = r5.b()
            if (r0 == 0) goto L_0x009f
            int r8 = r7.w()
            int r9 = r0.w()
            if (r8 != r9) goto L_0x009f
            androidx.lifecycle.h$c r7 = androidx.lifecycle.h.c.RESUMED
            if (r6 == r7) goto L_0x009a
            r3.put(r5, r7)
        L_0x009a:
            androidx.navigation.j r0 = r0.y()
            goto L_0x0073
        L_0x009f:
            if (r2 == 0) goto L_0x00c1
            int r7 = r7.w()
            int r8 = r2.w()
            if (r7 != r8) goto L_0x00c1
            androidx.lifecycle.h$c r7 = androidx.lifecycle.h.c.RESUMED
            if (r6 != r7) goto L_0x00b5
            androidx.lifecycle.h$c r6 = androidx.lifecycle.h.c.STARTED
            r5.h(r6)
            goto L_0x00bc
        L_0x00b5:
            androidx.lifecycle.h$c r7 = androidx.lifecycle.h.c.STARTED
            if (r6 == r7) goto L_0x00bc
            r3.put(r5, r7)
        L_0x00bc:
            androidx.navigation.j r2 = r2.y()
            goto L_0x0073
        L_0x00c1:
            androidx.lifecycle.h$c r6 = androidx.lifecycle.h.c.CREATED
            r5.h(r6)
            goto L_0x0073
        L_0x00c7:
            java.util.Deque<androidx.navigation.e> r0 = r10.f3100h
            java.util.Iterator r0 = r0.iterator()
        L_0x00cd:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00e9
            java.lang.Object r2 = r0.next()
            androidx.navigation.e r2 = (androidx.navigation.e) r2
            java.lang.Object r4 = r3.get(r2)
            androidx.lifecycle.h$c r4 = (androidx.lifecycle.h.c) r4
            if (r4 == 0) goto L_0x00e5
            r2.h(r4)
            goto L_0x00cd
        L_0x00e5:
            r2.i()
            goto L_0x00cd
        L_0x00e9:
            java.util.Deque<androidx.navigation.e> r0 = r10.f3100h
            java.lang.Object r0 = r0.peekLast()
            androidx.navigation.e r0 = (androidx.navigation.e) r0
            java.util.concurrent.CopyOnWriteArrayList<androidx.navigation.NavController$b> r2 = r10.f3104l
            java.util.Iterator r2 = r2.iterator()
        L_0x00f7:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x010f
            java.lang.Object r3 = r2.next()
            androidx.navigation.NavController$b r3 = (androidx.navigation.NavController.b) r3
            androidx.navigation.i r4 = r0.b()
            android.os.Bundle r5 = r0.a()
            r3.a(r10, r4, r5)
            goto L_0x00f7
        L_0x010f:
            return r1
        L_0x0110:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.a():boolean");
    }

    private String d(int[] iArr) {
        j jVar;
        j jVar2 = this.f3096d;
        int i10 = 0;
        while (true) {
            i iVar = null;
            if (i10 >= iArr.length) {
                return null;
            }
            int i11 = iArr[i10];
            if (i10 != 0) {
                iVar = jVar2.H(i11);
            } else if (this.f3096d.w() == i11) {
                iVar = this.f3096d;
            }
            if (iVar == null) {
                return i.v(this.f3093a, i11);
            }
            if (i10 != iArr.length - 1) {
                while (true) {
                    jVar = (j) iVar;
                    if (!(jVar.H(jVar.K()) instanceof j)) {
                        break;
                    }
                    iVar = jVar.H(jVar.K());
                }
                jVar2 = jVar;
            }
            i10++;
        }
    }

    private int g() {
        int i10 = 0;
        for (e b10 : this.f3100h) {
            if (!(b10.b() instanceof j)) {
                i10++;
            }
        }
        return i10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0031 A[LOOP:0: B:10:0x0031->B:15:0x005d, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ed A[LOOP:3: B:43:0x00ed->B:50:0x0131, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void o(androidx.navigation.i r12, android.os.Bundle r13, androidx.navigation.n r14, androidx.navigation.q.a r15) {
        /*
            r11 = this;
            r0 = 0
            if (r14 == 0) goto L_0x0017
            int r1 = r14.e()
            r2 = -1
            if (r1 == r2) goto L_0x0017
            int r1 = r14.e()
            boolean r2 = r14.f()
            boolean r1 = r11.s(r1, r2)
            goto L_0x0018
        L_0x0017:
            r1 = r0
        L_0x0018:
            androidx.navigation.r r2 = r11.f3103k
            java.lang.String r3 = r12.x()
            androidx.navigation.q r2 = r2.e(r3)
            android.os.Bundle r13 = r12.h(r13)
            androidx.navigation.i r15 = r2.b(r12, r13, r14, r15)
            r2 = 1
            if (r15 == 0) goto L_0x017c
            boolean r14 = r15 instanceof androidx.navigation.b
            if (r14 != 0) goto L_0x0060
        L_0x0031:
            java.util.Deque<androidx.navigation.e> r14 = r11.f3100h
            boolean r14 = r14.isEmpty()
            if (r14 != 0) goto L_0x0060
            java.util.Deque<androidx.navigation.e> r14 = r11.f3100h
            java.lang.Object r14 = r14.peekLast()
            androidx.navigation.e r14 = (androidx.navigation.e) r14
            androidx.navigation.i r14 = r14.b()
            boolean r14 = r14 instanceof androidx.navigation.b
            if (r14 == 0) goto L_0x0060
            java.util.Deque<androidx.navigation.e> r14 = r11.f3100h
            java.lang.Object r14 = r14.peekLast()
            androidx.navigation.e r14 = (androidx.navigation.e) r14
            androidx.navigation.i r14 = r14.b()
            int r14 = r14.w()
            boolean r14 = r11.s(r14, r2)
            if (r14 == 0) goto L_0x0060
            goto L_0x0031
        L_0x0060:
            java.util.ArrayDeque r14 = new java.util.ArrayDeque
            r14.<init>()
            boolean r3 = r12 instanceof androidx.navigation.j
            if (r3 == 0) goto L_0x00a5
            r3 = r15
        L_0x006a:
            androidx.navigation.j r9 = r3.y()
            if (r9 == 0) goto L_0x009e
            androidx.navigation.e r10 = new androidx.navigation.e
            android.content.Context r4 = r11.f3093a
            androidx.lifecycle.o r7 = r11.f3101i
            androidx.navigation.f r8 = r11.f3102j
            r3 = r10
            r5 = r9
            r6 = r13
            r3.<init>(r4, r5, r6, r7, r8)
            r14.addFirst(r10)
            java.util.Deque<androidx.navigation.e> r3 = r11.f3100h
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x009e
            java.util.Deque<androidx.navigation.e> r3 = r11.f3100h
            java.lang.Object r3 = r3.getLast()
            androidx.navigation.e r3 = (androidx.navigation.e) r3
            androidx.navigation.i r3 = r3.b()
            if (r3 != r9) goto L_0x009e
            int r3 = r9.w()
            r11.s(r3, r2)
        L_0x009e:
            if (r9 == 0) goto L_0x00a5
            if (r9 != r12) goto L_0x00a3
            goto L_0x00a5
        L_0x00a3:
            r3 = r9
            goto L_0x006a
        L_0x00a5:
            boolean r12 = r14.isEmpty()
            if (r12 == 0) goto L_0x00ad
            r12 = r15
            goto L_0x00b7
        L_0x00ad:
            java.lang.Object r12 = r14.getFirst()
            androidx.navigation.e r12 = (androidx.navigation.e) r12
            androidx.navigation.i r12 = r12.b()
        L_0x00b7:
            if (r12 == 0) goto L_0x00db
            int r3 = r12.w()
            androidx.navigation.i r3 = r11.c(r3)
            if (r3 != 0) goto L_0x00db
            androidx.navigation.j r12 = r12.y()
            if (r12 == 0) goto L_0x00b7
            androidx.navigation.e r9 = new androidx.navigation.e
            android.content.Context r4 = r11.f3093a
            androidx.lifecycle.o r7 = r11.f3101i
            androidx.navigation.f r8 = r11.f3102j
            r3 = r9
            r5 = r12
            r6 = r13
            r3.<init>(r4, r5, r6, r7, r8)
            r14.addFirst(r9)
            goto L_0x00b7
        L_0x00db:
            boolean r12 = r14.isEmpty()
            if (r12 == 0) goto L_0x00e3
            r12 = r15
            goto L_0x00ed
        L_0x00e3:
            java.lang.Object r12 = r14.getLast()
            androidx.navigation.e r12 = (androidx.navigation.e) r12
            androidx.navigation.i r12 = r12.b()
        L_0x00ed:
            java.util.Deque<androidx.navigation.e> r3 = r11.f3100h
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x0134
            java.util.Deque<androidx.navigation.e> r3 = r11.f3100h
            java.lang.Object r3 = r3.getLast()
            androidx.navigation.e r3 = (androidx.navigation.e) r3
            androidx.navigation.i r3 = r3.b()
            boolean r3 = r3 instanceof androidx.navigation.j
            if (r3 == 0) goto L_0x0134
            java.util.Deque<androidx.navigation.e> r3 = r11.f3100h
            java.lang.Object r3 = r3.getLast()
            androidx.navigation.e r3 = (androidx.navigation.e) r3
            androidx.navigation.i r3 = r3.b()
            androidx.navigation.j r3 = (androidx.navigation.j) r3
            int r4 = r12.w()
            androidx.navigation.i r3 = r3.I(r4, r0)
            if (r3 != 0) goto L_0x0134
            java.util.Deque<androidx.navigation.e> r3 = r11.f3100h
            java.lang.Object r3 = r3.getLast()
            androidx.navigation.e r3 = (androidx.navigation.e) r3
            androidx.navigation.i r3 = r3.b()
            int r3 = r3.w()
            boolean r3 = r11.s(r3, r2)
            if (r3 == 0) goto L_0x0134
            goto L_0x00ed
        L_0x0134:
            java.util.Deque<androidx.navigation.e> r12 = r11.f3100h
            r12.addAll(r14)
            java.util.Deque<androidx.navigation.e> r12 = r11.f3100h
            boolean r12 = r12.isEmpty()
            if (r12 != 0) goto L_0x0151
            java.util.Deque<androidx.navigation.e> r12 = r11.f3100h
            java.lang.Object r12 = r12.getFirst()
            androidx.navigation.e r12 = (androidx.navigation.e) r12
            androidx.navigation.i r12 = r12.b()
            androidx.navigation.j r14 = r11.f3096d
            if (r12 == r14) goto L_0x0165
        L_0x0151:
            androidx.navigation.e r12 = new androidx.navigation.e
            android.content.Context r4 = r11.f3093a
            androidx.navigation.j r5 = r11.f3096d
            androidx.lifecycle.o r7 = r11.f3101i
            androidx.navigation.f r8 = r11.f3102j
            r3 = r12
            r6 = r13
            r3.<init>(r4, r5, r6, r7, r8)
            java.util.Deque<androidx.navigation.e> r14 = r11.f3100h
            r14.addFirst(r12)
        L_0x0165:
            androidx.navigation.e r12 = new androidx.navigation.e
            android.content.Context r4 = r11.f3093a
            android.os.Bundle r6 = r15.h(r13)
            androidx.lifecycle.o r7 = r11.f3101i
            androidx.navigation.f r8 = r11.f3102j
            r3 = r12
            r5 = r15
            r3.<init>(r4, r5, r6, r7, r8)
            java.util.Deque<androidx.navigation.e> r13 = r11.f3100h
            r13.add(r12)
            goto L_0x0192
        L_0x017c:
            if (r14 == 0) goto L_0x0192
            boolean r12 = r14.g()
            if (r12 == 0) goto L_0x0192
            java.util.Deque<androidx.navigation.e> r12 = r11.f3100h
            java.lang.Object r12 = r12.peekLast()
            androidx.navigation.e r12 = (androidx.navigation.e) r12
            if (r12 == 0) goto L_0x0191
            r12.f(r13)
        L_0x0191:
            r0 = r2
        L_0x0192:
            r11.B()
            if (r1 != 0) goto L_0x019b
            if (r15 != 0) goto L_0x019b
            if (r0 == 0) goto L_0x019e
        L_0x019b:
            r11.a()
        L_0x019e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.o(androidx.navigation.i, android.os.Bundle, androidx.navigation.n, androidx.navigation.q$a):void");
    }

    private void p(Bundle bundle) {
        Activity activity;
        ArrayList<String> stringArrayList;
        Bundle bundle2 = this.f3097e;
        if (!(bundle2 == null || (stringArrayList = bundle2.getStringArrayList("android-support-nav:controller:navigatorState:names")) == null)) {
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                q e10 = this.f3103k.e(next);
                Bundle bundle3 = this.f3097e.getBundle(next);
                if (bundle3 != null) {
                    e10.c(bundle3);
                }
            }
        }
        Parcelable[] parcelableArr = this.f3098f;
        boolean z10 = false;
        if (parcelableArr != null) {
            int length = parcelableArr.length;
            int i10 = 0;
            while (i10 < length) {
                NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) parcelableArr[i10];
                i c10 = c(navBackStackEntryState.b());
                if (c10 != null) {
                    Bundle a10 = navBackStackEntryState.a();
                    if (a10 != null) {
                        a10.setClassLoader(this.f3093a.getClassLoader());
                    }
                    this.f3100h.add(new e(this.f3093a, c10, a10, this.f3101i, this.f3102j, navBackStackEntryState.d(), navBackStackEntryState.c()));
                    i10++;
                } else {
                    throw new IllegalStateException("Restoring the Navigation back stack failed: destination " + i.v(this.f3093a, navBackStackEntryState.b()) + " cannot be found from the current destination " + f());
                }
            }
            B();
            this.f3098f = null;
        }
        if (this.f3096d == null || !this.f3100h.isEmpty()) {
            a();
            return;
        }
        if (!this.f3099g && (activity = this.f3094b) != null && j(activity.getIntent())) {
            z10 = true;
        }
        if (!z10) {
            o(this.f3096d, bundle, (n) null, (q.a) null);
        }
    }

    /* access modifiers changed from: package-private */
    public void A(f0 f0Var) {
        if (this.f3102j != f.b(f0Var)) {
            if (this.f3100h.isEmpty()) {
                this.f3102j = f.b(f0Var);
                return;
            }
            throw new IllegalStateException("ViewModelStore should be set before setGraph call");
        }
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z10) {
        this.f3107o = z10;
        B();
    }

    /* access modifiers changed from: package-private */
    public i c(int i10) {
        j jVar = this.f3096d;
        if (jVar == null) {
            return null;
        }
        if (jVar.w() == i10) {
            return this.f3096d;
        }
        i b10 = this.f3100h.isEmpty() ? this.f3096d : this.f3100h.getLast().b();
        return (b10 instanceof j ? (j) b10 : b10.y()).H(i10);
    }

    public e e() {
        if (this.f3100h.isEmpty()) {
            return null;
        }
        return this.f3100h.getLast();
    }

    public i f() {
        e e10 = e();
        if (e10 != null) {
            return e10.b();
        }
        return null;
    }

    public m h() {
        if (this.f3095c == null) {
            this.f3095c = new m(this.f3093a, this.f3103k);
        }
        return this.f3095c;
    }

    public r i() {
        return this.f3103k;
    }

    public boolean j(Intent intent) {
        j jVar;
        i.a z10;
        if (intent == null) {
            return false;
        }
        Bundle extras = intent.getExtras();
        int[] intArray = extras != null ? extras.getIntArray("android-support-nav:controller:deepLinkIds") : null;
        Bundle bundle = new Bundle();
        Bundle bundle2 = extras != null ? extras.getBundle("android-support-nav:controller:deepLinkExtras") : null;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if (!((intArray != null && intArray.length != 0) || intent.getData() == null || (z10 = this.f3096d.z(new h(intent))) == null)) {
            i b10 = z10.b();
            int[] i10 = b10.i();
            bundle.putAll(b10.h(z10.e()));
            intArray = i10;
        }
        if (intArray == null || intArray.length == 0) {
            return false;
        }
        String d10 = d(intArray);
        if (d10 != null) {
            Log.i("NavController", "Could not find destination " + d10 + " in the navigation graph, ignoring the deep link from " + intent);
            return false;
        }
        bundle.putParcelable("android-support-nav:controller:deepLinkIntent", intent);
        int flags = intent.getFlags();
        int i11 = 268435456 & flags;
        if (i11 != 0 && (flags & 32768) == 0) {
            intent.addFlags(32768);
            androidx.core.app.n.t(this.f3093a).f(intent).w();
            Activity activity = this.f3094b;
            if (activity != null) {
                activity.finish();
                this.f3094b.overridePendingTransition(0, 0);
            }
            return true;
        } else if (i11 != 0) {
            if (!this.f3100h.isEmpty()) {
                s(this.f3096d.w(), true);
            }
            int i12 = 0;
            while (i12 < intArray.length) {
                int i13 = i12 + 1;
                int i14 = intArray[i12];
                i c10 = c(i14);
                if (c10 != null) {
                    o(c10, bundle, new n.a().b(0).c(0).a(), (q.a) null);
                    i12 = i13;
                } else {
                    throw new IllegalStateException("Deep Linking failed: destination " + i.v(this.f3093a, i14) + " cannot be found from the current destination " + f());
                }
            }
            return true;
        } else {
            j jVar2 = this.f3096d;
            int i15 = 0;
            while (i15 < intArray.length) {
                int i16 = intArray[i15];
                i H = i15 == 0 ? this.f3096d : jVar2.H(i16);
                if (H != null) {
                    if (i15 != intArray.length - 1) {
                        while (true) {
                            jVar = (j) H;
                            if (!(jVar.H(jVar.K()) instanceof j)) {
                                break;
                            }
                            H = jVar.H(jVar.K());
                        }
                        jVar2 = jVar;
                    } else {
                        o(H, H.h(bundle), new n.a().g(this.f3096d.w(), true).b(0).c(0).a(), (q.a) null);
                    }
                    i15++;
                } else {
                    throw new IllegalStateException("Deep Linking failed: destination " + i.v(this.f3093a, i16) + " cannot be found in graph " + jVar2);
                }
            }
            this.f3099g = true;
            return true;
        }
    }

    public void k(int i10) {
        l(i10, (Bundle) null);
    }

    public void l(int i10, Bundle bundle) {
        m(i10, bundle, (n) null);
    }

    public void m(int i10, Bundle bundle, n nVar) {
        n(i10, bundle, nVar, (q.a) null);
    }

    public void n(int i10, Bundle bundle, n nVar, q.a aVar) {
        int i11;
        i b10 = this.f3100h.isEmpty() ? this.f3096d : this.f3100h.getLast().b();
        if (b10 != null) {
            c k10 = b10.k(i10);
            Bundle bundle2 = null;
            if (k10 != null) {
                if (nVar == null) {
                    nVar = k10.c();
                }
                i11 = k10.b();
                Bundle a10 = k10.a();
                if (a10 != null) {
                    bundle2 = new Bundle();
                    bundle2.putAll(a10);
                }
            } else {
                i11 = i10;
            }
            if (bundle != null) {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                bundle2.putAll(bundle);
            }
            if (i11 == 0 && nVar != null && nVar.e() != -1) {
                r(nVar.e(), nVar.f());
            } else if (i11 != 0) {
                i c10 = c(i11);
                if (c10 == null) {
                    String v10 = i.v(this.f3093a, i11);
                    if (k10 != null) {
                        throw new IllegalArgumentException("Navigation destination " + v10 + " referenced from action " + i.v(this.f3093a, i10) + " cannot be found from the current destination " + b10);
                    }
                    throw new IllegalArgumentException("Navigation action/destination " + v10 + " cannot be found from the current destination " + b10);
                }
                o(c10, bundle2, nVar, aVar);
            } else {
                throw new IllegalArgumentException("Destination id == 0 can only be used in conjunction with a valid navOptions.popUpTo");
            }
        } else {
            throw new IllegalStateException("no current navigation node");
        }
    }

    public boolean q() {
        if (this.f3100h.isEmpty()) {
            return false;
        }
        return r(f().w(), true);
    }

    public boolean r(int i10, boolean z10) {
        return s(i10, z10) && a();
    }

    /* access modifiers changed from: package-private */
    public boolean s(int i10, boolean z10) {
        boolean z11;
        boolean z12 = false;
        if (this.f3100h.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<e> descendingIterator = this.f3100h.descendingIterator();
        while (true) {
            if (!descendingIterator.hasNext()) {
                z11 = false;
                break;
            }
            i b10 = descendingIterator.next().b();
            q e10 = this.f3103k.e(b10.x());
            if (z10 || b10.w() != i10) {
                arrayList.add(e10);
            }
            if (b10.w() == i10) {
                z11 = true;
                break;
            }
        }
        if (!z11) {
            Log.i("NavController", "Ignoring popBackStack to destination " + i.v(this.f3093a, i10) + " as it was not found on the current back stack");
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext() && ((q) it.next()).e()) {
            e removeLast = this.f3100h.removeLast();
            if (removeLast.getLifecycle().b().a(h.c.CREATED)) {
                removeLast.h(h.c.DESTROYED);
            }
            f fVar = this.f3102j;
            if (fVar != null) {
                fVar.a(removeLast.f3132f);
            }
            z12 = true;
        }
        B();
        return z12;
    }

    public void t(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(this.f3093a.getClassLoader());
            this.f3097e = bundle.getBundle("android-support-nav:controller:navigatorState");
            this.f3098f = bundle.getParcelableArray("android-support-nav:controller:backStack");
            this.f3099g = bundle.getBoolean("android-support-nav:controller:deepLinkHandled");
        }
    }

    public Bundle u() {
        Bundle bundle;
        ArrayList arrayList = new ArrayList();
        Bundle bundle2 = new Bundle();
        for (Map.Entry next : this.f3103k.f().entrySet()) {
            String str = (String) next.getKey();
            Bundle d10 = ((q) next.getValue()).d();
            if (d10 != null) {
                arrayList.add(str);
                bundle2.putBundle(str, d10);
            }
        }
        if (!arrayList.isEmpty()) {
            bundle = new Bundle();
            bundle2.putStringArrayList("android-support-nav:controller:navigatorState:names", arrayList);
            bundle.putBundle("android-support-nav:controller:navigatorState", bundle2);
        } else {
            bundle = null;
        }
        if (!this.f3100h.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            Parcelable[] parcelableArr = new Parcelable[this.f3100h.size()];
            int i10 = 0;
            for (e navBackStackEntryState : this.f3100h) {
                parcelableArr[i10] = new NavBackStackEntryState(navBackStackEntryState);
                i10++;
            }
            bundle.putParcelableArray("android-support-nav:controller:backStack", parcelableArr);
        }
        if (this.f3099g) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android-support-nav:controller:deepLinkHandled", this.f3099g);
        }
        return bundle;
    }

    public void v(int i10) {
        w(i10, (Bundle) null);
    }

    public void w(int i10, Bundle bundle) {
        x(h().c(i10), bundle);
    }

    public void x(j jVar, Bundle bundle) {
        j jVar2 = this.f3096d;
        if (jVar2 != null) {
            s(jVar2.w(), true);
        }
        this.f3096d = jVar;
        p(bundle);
    }

    /* access modifiers changed from: package-private */
    public void y(o oVar) {
        if (oVar != this.f3101i) {
            this.f3101i = oVar;
            oVar.getLifecycle().a(this.f3105m);
        }
    }

    /* access modifiers changed from: package-private */
    public void z(OnBackPressedDispatcher onBackPressedDispatcher) {
        if (this.f3101i != null) {
            this.f3106n.remove();
            onBackPressedDispatcher.a(this.f3101i, this.f3106n);
            this.f3101i.getLifecycle().c(this.f3105m);
            this.f3101i.getLifecycle().a(this.f3105m);
            return;
        }
        throw new IllegalStateException("You must call setLifecycleOwner() before calling setOnBackPressedDispatcher()");
    }
}
