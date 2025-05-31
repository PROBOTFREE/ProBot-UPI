package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.Iterator;
import java.util.List;

class PlaybackStateCompatApi22 {
    private PlaybackStateCompatApi22() {
    }

    public static Bundle getExtras(Object obj) {
        return ((PlaybackState) obj).getExtras();
    }

    public static Object newInstance(int i10, long j10, long j11, float f10, long j12, CharSequence charSequence, long j13, List<Object> list, long j14, Bundle bundle) {
        PlaybackState.Builder builder = new PlaybackState.Builder();
        builder.setState(i10, j10, f10, j13);
        long j15 = j11;
        builder.setBufferedPosition(j11);
        long j16 = j12;
        builder.setActions(j12);
        builder.setErrorMessage(charSequence);
        Iterator<Object> it = list.iterator();
        while (it.hasNext()) {
            builder.addCustomAction((PlaybackState.CustomAction) it.next());
        }
        builder.setActiveQueueItemId(j14);
        builder.setExtras(bundle);
        return builder.build();
    }
}
