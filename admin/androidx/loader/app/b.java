package androidx.loader.app;

import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.c0;
import androidx.lifecycle.d0;
import androidx.lifecycle.f0;
import androidx.lifecycle.o;
import androidx.lifecycle.u;
import androidx.lifecycle.v;
import c0.h;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class b extends a {

    /* renamed from: c  reason: collision with root package name */
    static boolean f3067c = false;

    /* renamed from: a  reason: collision with root package name */
    private final o f3068a;

    /* renamed from: b  reason: collision with root package name */
    private final C0030b f3069b;

    public static class a<D> extends u<D> {

        /* renamed from: l  reason: collision with root package name */
        private final int f3070l;

        /* renamed from: m  reason: collision with root package name */
        private final Bundle f3071m;

        /* renamed from: n  reason: collision with root package name */
        private final k1.a<D> f3072n;

        /* renamed from: o  reason: collision with root package name */
        private o f3073o;

        /* access modifiers changed from: protected */
        public void h() {
            if (b.f3067c) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            throw null;
        }

        /* access modifiers changed from: protected */
        public void i() {
            if (b.f3067c) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            throw null;
        }

        public void k(v<? super D> vVar) {
            super.k(vVar);
            this.f3073o = null;
        }

        public void l(D d10) {
            super.l(d10);
        }

        /* access modifiers changed from: package-private */
        public k1.a<D> m(boolean z10) {
            if (b.f3067c) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            throw null;
        }

        public void n(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f3070l);
            printWriter.print(" mArgs=");
            printWriter.println(this.f3071m);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f3072n);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("  ");
            throw null;
        }

        /* access modifiers changed from: package-private */
        public void o() {
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(64);
            sb2.append("LoaderInfo{");
            sb2.append(Integer.toHexString(System.identityHashCode(this)));
            sb2.append(" #");
            sb2.append(this.f3070l);
            sb2.append(" : ");
            w0.b.a(this.f3072n, sb2);
            sb2.append("}}");
            return sb2.toString();
        }
    }

    /* renamed from: androidx.loader.app.b$b  reason: collision with other inner class name */
    static class C0030b extends c0 {

        /* renamed from: b  reason: collision with root package name */
        private static final d0.b f3074b = new a();

        /* renamed from: a  reason: collision with root package name */
        private h<a> f3075a = new h<>();

        /* renamed from: androidx.loader.app.b$b$a */
        static class a implements d0.b {
            a() {
            }

            public <T extends c0> T create(Class<T> cls) {
                return new C0030b();
            }
        }

        C0030b() {
        }

        static C0030b b(f0 f0Var) {
            return (C0030b) new d0(f0Var, f3074b).a(C0030b.class);
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f3075a.p() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i10 = 0; i10 < this.f3075a.p(); i10++) {
                    a q10 = this.f3075a.q(i10);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f3075a.m(i10));
                    printWriter.print(": ");
                    printWriter.println(q10.toString());
                    q10.n(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            int p10 = this.f3075a.p();
            for (int i10 = 0; i10 < p10; i10++) {
                this.f3075a.q(i10).o();
            }
        }

        /* access modifiers changed from: protected */
        public void onCleared() {
            super.onCleared();
            int p10 = this.f3075a.p();
            for (int i10 = 0; i10 < p10; i10++) {
                this.f3075a.q(i10).m(true);
            }
            this.f3075a.b();
        }
    }

    b(o oVar, f0 f0Var) {
        this.f3068a = oVar;
        this.f3069b = C0030b.b(f0Var);
    }

    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f3069b.a(str, fileDescriptor, printWriter, strArr);
    }

    public void c() {
        this.f3069b.c();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("LoaderManager{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" in ");
        w0.b.a(this.f3068a, sb2);
        sb2.append("}}");
        return sb2.toString();
    }
}
