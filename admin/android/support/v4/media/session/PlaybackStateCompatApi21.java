package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.Iterator;
import java.util.List;

class PlaybackStateCompatApi21 {

    static final class CustomAction {
        private CustomAction() {
        }

        public static String getAction(Object obj) {
            return ((PlaybackState.CustomAction) obj).getAction();
        }

        public static Bundle getExtras(Object obj) {
            return ((PlaybackState.CustomAction) obj).getExtras();
        }

        public static int getIcon(Object obj) {
            return ((PlaybackState.CustomAction) obj).getIcon();
        }

        public static CharSequence getName(Object obj) {
            return ((PlaybackState.CustomAction) obj).getName();
        }

        public static Object newInstance(String str, CharSequence charSequence, int i10, Bundle bundle) {
            PlaybackState.CustomAction.Builder builder = new PlaybackState.CustomAction.Builder(str, charSequence, i10);
            builder.setExtras(bundle);
            return builder.build();
        }
    }

    private PlaybackStateCompatApi21() {
    }

    public static long getActions(Object obj) {
        return ((PlaybackState) obj).getActions();
    }

    public static long getActiveQueueItemId(Object obj) {
        return ((PlaybackState) obj).getActiveQueueItemId();
    }

    public static long getBufferedPosition(Object obj) {
        return ((PlaybackState) obj).getBufferedPosition();
    }

    public static List<Object> getCustomActions(Object obj) {
        return ((PlaybackState) obj).getCustomActions();
    }

    public static CharSequence getErrorMessage(Object obj) {
        return ((PlaybackState) obj).getErrorMessage();
    }

    public static long getLastPositionUpdateTime(Object obj) {
        return ((PlaybackState) obj).getLastPositionUpdateTime();
    }

    public static float getPlaybackSpeed(Object obj) {
        return ((PlaybackState) obj).getPlaybackSpeed();
    }

    public static long getPosition(Object obj) {
        return ((PlaybackState) obj).getPosition();
    }

    public static int getState(Object obj) {
        return ((PlaybackState) obj).getState();
    }

    public static Object newInstance(int i10, long j10, long j11, float f10, long j12, CharSequence charSequence, long j13, List<Object> list, long j14) {
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
        return builder.build();
    }
}
