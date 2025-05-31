package a3;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import s3.j;

final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, a> f89a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final b f90b = new b();

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        final Lock f91a = new ReentrantLock();

        /* renamed from: b  reason: collision with root package name */
        int f92b;

        a() {
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<a> f93a = new ArrayDeque();

        b() {
        }

        /* access modifiers changed from: package-private */
        public a a() {
            a poll;
            synchronized (this.f93a) {
                poll = this.f93a.poll();
            }
            return poll == null ? new a() : poll;
        }

        /* access modifiers changed from: package-private */
        public void b(a aVar) {
            synchronized (this.f93a) {
                if (this.f93a.size() < 10) {
                    this.f93a.offer(aVar);
                }
            }
        }
    }

    c() {
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        a aVar;
        synchronized (this) {
            aVar = this.f89a.get(str);
            if (aVar == null) {
                aVar = this.f90b.a();
                this.f89a.put(str, aVar);
            }
            aVar.f92b++;
        }
        aVar.f91a.lock();
    }

    /* access modifiers changed from: package-private */
    public void b(String str) {
        a aVar;
        synchronized (this) {
            aVar = (a) j.d(this.f89a.get(str));
            int i10 = aVar.f92b;
            if (i10 >= 1) {
                int i11 = i10 - 1;
                aVar.f92b = i11;
                if (i11 == 0) {
                    a remove = this.f89a.remove(str);
                    if (remove.equals(aVar)) {
                        this.f90b.b(remove);
                    } else {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + remove + ", safeKey: " + str);
                    }
                }
            } else {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.f92b);
            }
        }
        aVar.f91a.unlock();
    }
}
