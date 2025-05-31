package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompatApi21;

class MediaSessionCompatApi23 {

    public interface Callback extends MediaSessionCompatApi21.Callback {
        void onPlayFromUri(Uri uri, Bundle bundle);
    }

    static class CallbackProxy<T extends Callback> extends MediaSessionCompatApi21.CallbackProxy<T> {
        public CallbackProxy(T t10) {
            super(t10);
        }

        public void onPlayFromUri(Uri uri, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            ((Callback) this.mCallback).onPlayFromUri(uri, bundle);
        }
    }

    private MediaSessionCompatApi23() {
    }

    public static Object createCallback(Callback callback) {
        return new CallbackProxy(callback);
    }
}
