package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.os.Parcel;

class MediaBrowserCompatApi23 {

    interface ItemCallback {
        void onError(String str);

        void onItemLoaded(Parcel parcel);
    }

    static class ItemCallbackProxy<T extends ItemCallback> extends MediaBrowser.ItemCallback {
        protected final T mItemCallback;

        public ItemCallbackProxy(T t10) {
            this.mItemCallback = t10;
        }

        public void onError(String str) {
            this.mItemCallback.onError(str);
        }

        public void onItemLoaded(MediaBrowser.MediaItem mediaItem) {
            T t10;
            Parcel parcel;
            if (mediaItem == null) {
                t10 = this.mItemCallback;
                parcel = null;
            } else {
                parcel = Parcel.obtain();
                mediaItem.writeToParcel(parcel, 0);
                t10 = this.mItemCallback;
            }
            t10.onItemLoaded(parcel);
        }
    }

    private MediaBrowserCompatApi23() {
    }

    public static Object createItemCallback(ItemCallback itemCallback) {
        return new ItemCallbackProxy(itemCallback);
    }

    public static void getItem(Object obj, String str, Object obj2) {
        ((MediaBrowser) obj).getItem(str, (MediaBrowser.ItemCallback) obj2);
    }
}
