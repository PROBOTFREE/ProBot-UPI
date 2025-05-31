package a2;

import android.util.Log;

public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    private static h f82a = null;

    /* renamed from: b  reason: collision with root package name */
    private static final int f83b = 20;

    public static class a extends h {

        /* renamed from: c  reason: collision with root package name */
        private int f84c;

        public a(int i10) {
            super(i10);
            this.f84c = i10;
        }

        public void a(String str, String str2, Throwable... thArr) {
            if (this.f84c > 3) {
                return;
            }
            if (thArr == null || thArr.length < 1) {
                Log.d(str, str2);
            } else {
                Log.d(str, str2, thArr[0]);
            }
        }

        public void b(String str, String str2, Throwable... thArr) {
            if (this.f84c > 6) {
                return;
            }
            if (thArr == null || thArr.length < 1) {
                Log.e(str, str2);
            } else {
                Log.e(str, str2, thArr[0]);
            }
        }

        public void d(String str, String str2, Throwable... thArr) {
            if (this.f84c > 4) {
                return;
            }
            if (thArr == null || thArr.length < 1) {
                Log.i(str, str2);
            } else {
                Log.i(str, str2, thArr[0]);
            }
        }

        public void g(String str, String str2, Throwable... thArr) {
            if (this.f84c > 2) {
                return;
            }
            if (thArr == null || thArr.length < 1) {
                Log.v(str, str2);
            } else {
                Log.v(str, str2, thArr[0]);
            }
        }

        public void h(String str, String str2, Throwable... thArr) {
            if (this.f84c > 5) {
                return;
            }
            if (thArr == null || thArr.length < 1) {
                Log.w(str, str2);
            } else {
                Log.w(str, str2, thArr[0]);
            }
        }
    }

    public h(int i10) {
    }

    public static synchronized h c() {
        h hVar;
        synchronized (h.class) {
            if (f82a == null) {
                f82a = new a(3);
            }
            hVar = f82a;
        }
        return hVar;
    }

    public static synchronized void e(h hVar) {
        synchronized (h.class) {
            f82a = hVar;
        }
    }

    public static String f(String str) {
        int length = str.length();
        StringBuilder sb2 = new StringBuilder(23);
        sb2.append("WM-");
        int i10 = f83b;
        if (length >= i10) {
            str = str.substring(0, i10);
        }
        sb2.append(str);
        return sb2.toString();
    }

    public abstract void a(String str, String str2, Throwable... thArr);

    public abstract void b(String str, String str2, Throwable... thArr);

    public abstract void d(String str, String str2, Throwable... thArr);

    public abstract void g(String str, String str2, Throwable... thArr);

    public abstract void h(String str, String str2, Throwable... thArr);
}
