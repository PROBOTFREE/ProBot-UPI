package ab;

import mb.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class f implements Comparable<f> {
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public static final f f147e = g.a();

    /* renamed from: a  reason: collision with root package name */
    private final int f148a;

    /* renamed from: b  reason: collision with root package name */
    private final int f149b;

    /* renamed from: c  reason: collision with root package name */
    private final int f150c;

    /* renamed from: d  reason: collision with root package name */
    private final int f151d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(mb.f fVar) {
            this();
        }
    }

    static {
        new a((mb.f) null);
    }

    public f(int i10, int i11, int i12) {
        this.f149b = i10;
        this.f150c = i11;
        this.f151d = i12;
        this.f148a = b(i10, i11, i12);
    }

    private final int b(int i10, int i11, int i12) {
        if (i10 >= 0 && 255 >= i10 && i11 >= 0 && 255 >= i11 && i12 >= 0 && 255 >= i12) {
            return (i10 << 16) + (i11 << 8) + i12;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i10 + '.' + i11 + '.' + i12).toString());
    }

    /* renamed from: a */
    public int compareTo(@NotNull f fVar) {
        h.e(fVar, "other");
        return this.f148a - fVar.f148a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            obj = null;
        }
        f fVar = (f) obj;
        if (fVar != null) {
            return this.f148a == fVar.f148a;
        }
        return false;
    }

    public int hashCode() {
        return this.f148a;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f149b);
        sb2.append('.');
        sb2.append(this.f150c);
        sb2.append('.');
        sb2.append(this.f151d);
        return sb2.toString();
    }
}
