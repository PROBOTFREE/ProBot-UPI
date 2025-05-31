package androidx.camera.core.impl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MetadataHolderService extends Service {
    private MetadataHolderService() {
    }

    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException();
    }
}
