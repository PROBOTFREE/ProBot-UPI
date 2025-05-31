package android.support.v4.media;

import android.media.MediaDescription;
import android.net.Uri;

class MediaDescriptionCompatApi23 {

    static class Builder {
        private Builder() {
        }

        public static void setMediaUri(Object obj, Uri uri) {
            ((MediaDescription.Builder) obj).setMediaUri(uri);
        }
    }

    private MediaDescriptionCompatApi23() {
    }

    public static Uri getMediaUri(Object obj) {
        return ((MediaDescription) obj).getMediaUri();
    }
}
