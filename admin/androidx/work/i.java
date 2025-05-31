package androidx.work;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    private UUID f4478a;

    /* renamed from: b  reason: collision with root package name */
    private a f4479b;

    /* renamed from: c  reason: collision with root package name */
    private c f4480c;

    /* renamed from: d  reason: collision with root package name */
    private Set<String> f4481d;

    /* renamed from: e  reason: collision with root package name */
    private c f4482e;

    /* renamed from: f  reason: collision with root package name */
    private int f4483f;

    public enum a {
        ENQUEUED,
        RUNNING,
        SUCCEEDED,
        FAILED,
        BLOCKED,
        CANCELLED;

        public boolean a() {
            return this == SUCCEEDED || this == FAILED || this == CANCELLED;
        }
    }

    public i(UUID uuid, a aVar, c cVar, List<String> list, c cVar2, int i10) {
        this.f4478a = uuid;
        this.f4479b = aVar;
        this.f4480c = cVar;
        this.f4481d = new HashSet(list);
        this.f4482e = cVar2;
        this.f4483f = i10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        if (this.f4483f == iVar.f4483f && this.f4478a.equals(iVar.f4478a) && this.f4479b == iVar.f4479b && this.f4480c.equals(iVar.f4480c) && this.f4481d.equals(iVar.f4481d)) {
            return this.f4482e.equals(iVar.f4482e);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.f4478a.hashCode() * 31) + this.f4479b.hashCode()) * 31) + this.f4480c.hashCode()) * 31) + this.f4481d.hashCode()) * 31) + this.f4482e.hashCode()) * 31) + this.f4483f;
    }

    public String toString() {
        return "WorkInfo{mId='" + this.f4478a + '\'' + ", mState=" + this.f4479b + ", mOutputData=" + this.f4480c + ", mTags=" + this.f4481d + ", mProgress=" + this.f4482e + '}';
    }
}
