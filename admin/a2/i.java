package a2;

import android.annotation.SuppressLint;

public interface i {
    @SuppressLint({"SyntheticAccessor"})

    /* renamed from: a  reason: collision with root package name */
    public static final b.c f85a = new b.c();
    @SuppressLint({"SyntheticAccessor"})

    /* renamed from: b  reason: collision with root package name */
    public static final b.C0004b f86b = new b.C0004b();

    public static abstract class b {

        public static final class a extends b {

            /* renamed from: a  reason: collision with root package name */
            private final Throwable f87a;

            public a(Throwable th) {
                this.f87a = th;
            }

            public Throwable a() {
                return this.f87a;
            }

            public String toString() {
                return String.format("FAILURE (%s)", new Object[]{this.f87a.getMessage()});
            }
        }

        /* renamed from: a2.i$b$b  reason: collision with other inner class name */
        public static final class C0004b extends b {
            private C0004b() {
            }

            public String toString() {
                return "IN_PROGRESS";
            }
        }

        public static final class c extends b {
            private c() {
            }

            public String toString() {
                return "SUCCESS";
            }
        }

        b() {
        }
    }
}
