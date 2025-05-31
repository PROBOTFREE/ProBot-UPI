package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.c;
import java.util.HashMap;

public class MultiInstanceInvalidationService extends Service {

    /* renamed from: a  reason: collision with root package name */
    int f3717a = 0;

    /* renamed from: b  reason: collision with root package name */
    final HashMap<Integer, String> f3718b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    final RemoteCallbackList<b> f3719c = new a();

    /* renamed from: d  reason: collision with root package name */
    private final c.a f3720d = new b();

    class a extends RemoteCallbackList<b> {
        a() {
        }

        /* renamed from: a */
        public void onCallbackDied(b bVar, Object obj) {
            MultiInstanceInvalidationService.this.f3718b.remove(Integer.valueOf(((Integer) obj).intValue()));
        }
    }

    class b extends c.a {
        b() {
        }

        public int D(b bVar, String str) {
            if (str == null) {
                return 0;
            }
            synchronized (MultiInstanceInvalidationService.this.f3719c) {
                MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
                int i10 = multiInstanceInvalidationService.f3717a + 1;
                multiInstanceInvalidationService.f3717a = i10;
                if (multiInstanceInvalidationService.f3719c.register(bVar, Integer.valueOf(i10))) {
                    MultiInstanceInvalidationService.this.f3718b.put(Integer.valueOf(i10), str);
                    return i10;
                }
                MultiInstanceInvalidationService multiInstanceInvalidationService2 = MultiInstanceInvalidationService.this;
                multiInstanceInvalidationService2.f3717a--;
                return 0;
            }
        }

        public void S(int i10, String[] strArr) {
            synchronized (MultiInstanceInvalidationService.this.f3719c) {
                String str = MultiInstanceInvalidationService.this.f3718b.get(Integer.valueOf(i10));
                if (str == null) {
                    Log.w("ROOM", "Remote invalidation client ID not registered");
                    return;
                }
                int beginBroadcast = MultiInstanceInvalidationService.this.f3719c.beginBroadcast();
                for (int i11 = 0; i11 < beginBroadcast; i11++) {
                    try {
                        int intValue = ((Integer) MultiInstanceInvalidationService.this.f3719c.getBroadcastCookie(i11)).intValue();
                        String str2 = MultiInstanceInvalidationService.this.f3718b.get(Integer.valueOf(intValue));
                        if (i10 != intValue && str.equals(str2)) {
                            MultiInstanceInvalidationService.this.f3719c.getBroadcastItem(i11).t(strArr);
                        }
                    } catch (RemoteException e10) {
                        Log.w("ROOM", "Error invoking a remote callback", e10);
                    } catch (Throwable th) {
                        MultiInstanceInvalidationService.this.f3719c.finishBroadcast();
                        throw th;
                    }
                }
                MultiInstanceInvalidationService.this.f3719c.finishBroadcast();
            }
        }

        public void X(b bVar, int i10) {
            synchronized (MultiInstanceInvalidationService.this.f3719c) {
                MultiInstanceInvalidationService.this.f3719c.unregister(bVar);
                MultiInstanceInvalidationService.this.f3718b.remove(Integer.valueOf(i10));
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return this.f3720d;
    }
}
