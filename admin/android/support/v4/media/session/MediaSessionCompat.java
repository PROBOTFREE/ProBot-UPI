package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.Rating;
import android.media.RemoteControlClient;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompatApi21;
import android.support.v4.media.session.MediaSessionCompatApi23;
import android.support.v4.media.session.MediaSessionCompatApi24;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import androidx.core.app.e;
import androidx.media.b;
import androidx.media.f;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.sourceforge.zbar.Config;

public class MediaSessionCompat {
    public static final String ACTION_ARGUMENT_CAPTIONING_ENABLED = "android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED";
    public static final String ACTION_ARGUMENT_EXTRAS = "android.support.v4.media.session.action.ARGUMENT_EXTRAS";
    public static final String ACTION_ARGUMENT_MEDIA_ID = "android.support.v4.media.session.action.ARGUMENT_MEDIA_ID";
    public static final String ACTION_ARGUMENT_QUERY = "android.support.v4.media.session.action.ARGUMENT_QUERY";
    public static final String ACTION_ARGUMENT_RATING = "android.support.v4.media.session.action.ARGUMENT_RATING";
    public static final String ACTION_ARGUMENT_REPEAT_MODE = "android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE";
    public static final String ACTION_ARGUMENT_SHUFFLE_MODE = "android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE";
    public static final String ACTION_ARGUMENT_URI = "android.support.v4.media.session.action.ARGUMENT_URI";
    public static final String ACTION_FLAG_AS_INAPPROPRIATE = "android.support.v4.media.session.action.FLAG_AS_INAPPROPRIATE";
    public static final String ACTION_FOLLOW = "android.support.v4.media.session.action.FOLLOW";
    public static final String ACTION_PLAY_FROM_URI = "android.support.v4.media.session.action.PLAY_FROM_URI";
    public static final String ACTION_PREPARE = "android.support.v4.media.session.action.PREPARE";
    public static final String ACTION_PREPARE_FROM_MEDIA_ID = "android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID";
    public static final String ACTION_PREPARE_FROM_SEARCH = "android.support.v4.media.session.action.PREPARE_FROM_SEARCH";
    public static final String ACTION_PREPARE_FROM_URI = "android.support.v4.media.session.action.PREPARE_FROM_URI";
    public static final String ACTION_SET_CAPTIONING_ENABLED = "android.support.v4.media.session.action.SET_CAPTIONING_ENABLED";
    public static final String ACTION_SET_RATING = "android.support.v4.media.session.action.SET_RATING";
    public static final String ACTION_SET_REPEAT_MODE = "android.support.v4.media.session.action.SET_REPEAT_MODE";
    public static final String ACTION_SET_SHUFFLE_MODE = "android.support.v4.media.session.action.SET_SHUFFLE_MODE";
    public static final String ACTION_SKIP_AD = "android.support.v4.media.session.action.SKIP_AD";
    public static final String ACTION_UNFOLLOW = "android.support.v4.media.session.action.UNFOLLOW";
    public static final String ARGUMENT_MEDIA_ATTRIBUTE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE";
    public static final String ARGUMENT_MEDIA_ATTRIBUTE_VALUE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE_VALUE";
    private static final String DATA_CALLING_PACKAGE = "data_calling_pkg";
    private static final String DATA_CALLING_PID = "data_calling_pid";
    private static final String DATA_CALLING_UID = "data_calling_uid";
    private static final String DATA_EXTRAS = "data_extras";
    public static final int FLAG_HANDLES_MEDIA_BUTTONS = 1;
    public static final int FLAG_HANDLES_QUEUE_COMMANDS = 4;
    public static final int FLAG_HANDLES_TRANSPORT_CONTROLS = 2;
    public static final String KEY_EXTRA_BINDER = "android.support.v4.media.session.EXTRA_BINDER";
    public static final String KEY_SESSION_TOKEN2_BUNDLE = "android.support.v4.media.session.SESSION_TOKEN2_BUNDLE";
    public static final String KEY_TOKEN = "android.support.v4.media.session.TOKEN";
    private static final int MAX_BITMAP_SIZE_IN_DP = 320;
    public static final int MEDIA_ATTRIBUTE_ALBUM = 1;
    public static final int MEDIA_ATTRIBUTE_ARTIST = 0;
    public static final int MEDIA_ATTRIBUTE_PLAYLIST = 2;
    static final String TAG = "MediaSessionCompat";
    static int sMaxBitmapSize;
    private final ArrayList<OnActiveChangeListener> mActiveListeners;
    private final MediaControllerCompat mController;
    private final MediaSessionImpl mImpl;

    public static abstract class Callback {
        private CallbackHandler mCallbackHandler = null;
        final Object mCallbackObj;
        private boolean mMediaPlayPauseKeyPending;
        WeakReference<MediaSessionImpl> mSessionImpl;

        private class CallbackHandler extends Handler {
            private static final int MSG_MEDIA_PLAY_PAUSE_KEY_DOUBLE_TAP_TIMEOUT = 1;

            CallbackHandler(Looper looper) {
                super(looper);
            }

            public void handleMessage(Message message) {
                if (message.what == 1) {
                    Callback.this.handleMediaPlayPauseKeySingleTapIfPending((b) message.obj);
                }
            }
        }

        private class StubApi21 implements MediaSessionCompatApi21.Callback {
            StubApi21() {
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: android.support.v4.media.session.MediaSessionCompat$QueueItem} */
            /* JADX WARNING: type inference failed for: r1v0 */
            /* JADX WARNING: type inference failed for: r1v4, types: [android.os.IBinder] */
            /* JADX WARNING: type inference failed for: r1v6 */
            /* JADX WARNING: type inference failed for: r1v7 */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onCommand(java.lang.String r5, android.os.Bundle r6, android.os.ResultReceiver r7) {
                /*
                    r4 = this;
                    java.lang.String r0 = "android.support.v4.media.session.command.GET_EXTRA_BINDER"
                    boolean r0 = r5.equals(r0)     // Catch:{ BadParcelableException -> 0x00c1 }
                    r1 = 0
                    if (r0 == 0) goto L_0x003d
                    android.support.v4.media.session.MediaSessionCompat$Callback r5 = android.support.v4.media.session.MediaSessionCompat.Callback.this     // Catch:{ BadParcelableException -> 0x00c1 }
                    java.lang.ref.WeakReference<android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl> r5 = r5.mSessionImpl     // Catch:{ BadParcelableException -> 0x00c1 }
                    java.lang.Object r5 = r5.get()     // Catch:{ BadParcelableException -> 0x00c1 }
                    android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi21 r5 = (android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21) r5     // Catch:{ BadParcelableException -> 0x00c1 }
                    if (r5 == 0) goto L_0x00c8
                    android.os.Bundle r6 = new android.os.Bundle     // Catch:{ BadParcelableException -> 0x00c1 }
                    r6.<init>()     // Catch:{ BadParcelableException -> 0x00c1 }
                    android.support.v4.media.session.MediaSessionCompat$Token r5 = r5.getSessionToken()     // Catch:{ BadParcelableException -> 0x00c1 }
                    android.support.v4.media.session.IMediaSession r0 = r5.getExtraBinder()     // Catch:{ BadParcelableException -> 0x00c1 }
                    java.lang.String r2 = "android.support.v4.media.session.EXTRA_BINDER"
                    if (r0 != 0) goto L_0x0027
                    goto L_0x002b
                L_0x0027:
                    android.os.IBinder r1 = r0.asBinder()     // Catch:{ BadParcelableException -> 0x00c1 }
                L_0x002b:
                    androidx.core.app.e.b(r6, r2, r1)     // Catch:{ BadParcelableException -> 0x00c1 }
                    android.os.Bundle r5 = r5.getSessionToken2Bundle()     // Catch:{ BadParcelableException -> 0x00c1 }
                    java.lang.String r0 = "android.support.v4.media.session.SESSION_TOKEN2_BUNDLE"
                    r6.putBundle(r0, r5)     // Catch:{ BadParcelableException -> 0x00c1 }
                    r5 = 0
                    r7.send(r5, r6)     // Catch:{ BadParcelableException -> 0x00c1 }
                    goto L_0x00c8
                L_0x003d:
                    java.lang.String r0 = "android.support.v4.media.session.command.ADD_QUEUE_ITEM"
                    boolean r0 = r5.equals(r0)     // Catch:{ BadParcelableException -> 0x00c1 }
                    java.lang.String r2 = "android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"
                    if (r0 == 0) goto L_0x0054
                    android.support.v4.media.session.MediaSessionCompat$Callback r5 = android.support.v4.media.session.MediaSessionCompat.Callback.this     // Catch:{ BadParcelableException -> 0x00c1 }
                    android.os.Parcelable r6 = r6.getParcelable(r2)     // Catch:{ BadParcelableException -> 0x00c1 }
                    android.support.v4.media.MediaDescriptionCompat r6 = (android.support.v4.media.MediaDescriptionCompat) r6     // Catch:{ BadParcelableException -> 0x00c1 }
                    r5.onAddQueueItem(r6)     // Catch:{ BadParcelableException -> 0x00c1 }
                    goto L_0x00c8
                L_0x0054:
                    java.lang.String r0 = "android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT"
                    boolean r0 = r5.equals(r0)     // Catch:{ BadParcelableException -> 0x00c1 }
                    java.lang.String r3 = "android.support.v4.media.session.command.ARGUMENT_INDEX"
                    if (r0 == 0) goto L_0x006e
                    android.support.v4.media.session.MediaSessionCompat$Callback r5 = android.support.v4.media.session.MediaSessionCompat.Callback.this     // Catch:{ BadParcelableException -> 0x00c1 }
                    android.os.Parcelable r7 = r6.getParcelable(r2)     // Catch:{ BadParcelableException -> 0x00c1 }
                    android.support.v4.media.MediaDescriptionCompat r7 = (android.support.v4.media.MediaDescriptionCompat) r7     // Catch:{ BadParcelableException -> 0x00c1 }
                    int r6 = r6.getInt(r3)     // Catch:{ BadParcelableException -> 0x00c1 }
                    r5.onAddQueueItem(r7, r6)     // Catch:{ BadParcelableException -> 0x00c1 }
                    goto L_0x00c8
                L_0x006e:
                    java.lang.String r0 = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM"
                    boolean r0 = r5.equals(r0)     // Catch:{ BadParcelableException -> 0x00c1 }
                    if (r0 == 0) goto L_0x0082
                    android.support.v4.media.session.MediaSessionCompat$Callback r5 = android.support.v4.media.session.MediaSessionCompat.Callback.this     // Catch:{ BadParcelableException -> 0x00c1 }
                    android.os.Parcelable r6 = r6.getParcelable(r2)     // Catch:{ BadParcelableException -> 0x00c1 }
                    android.support.v4.media.MediaDescriptionCompat r6 = (android.support.v4.media.MediaDescriptionCompat) r6     // Catch:{ BadParcelableException -> 0x00c1 }
                L_0x007e:
                    r5.onRemoveQueueItem(r6)     // Catch:{ BadParcelableException -> 0x00c1 }
                    goto L_0x00c8
                L_0x0082:
                    java.lang.String r0 = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT"
                    boolean r0 = r5.equals(r0)     // Catch:{ BadParcelableException -> 0x00c1 }
                    if (r0 == 0) goto L_0x00bb
                    android.support.v4.media.session.MediaSessionCompat$Callback r5 = android.support.v4.media.session.MediaSessionCompat.Callback.this     // Catch:{ BadParcelableException -> 0x00c1 }
                    java.lang.ref.WeakReference<android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl> r5 = r5.mSessionImpl     // Catch:{ BadParcelableException -> 0x00c1 }
                    java.lang.Object r5 = r5.get()     // Catch:{ BadParcelableException -> 0x00c1 }
                    android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi21 r5 = (android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21) r5     // Catch:{ BadParcelableException -> 0x00c1 }
                    if (r5 == 0) goto L_0x00c8
                    java.util.List<android.support.v4.media.session.MediaSessionCompat$QueueItem> r7 = r5.mQueue     // Catch:{ BadParcelableException -> 0x00c1 }
                    if (r7 == 0) goto L_0x00c8
                    r7 = -1
                    int r6 = r6.getInt(r3, r7)     // Catch:{ BadParcelableException -> 0x00c1 }
                    if (r6 < 0) goto L_0x00b2
                    java.util.List<android.support.v4.media.session.MediaSessionCompat$QueueItem> r7 = r5.mQueue     // Catch:{ BadParcelableException -> 0x00c1 }
                    int r7 = r7.size()     // Catch:{ BadParcelableException -> 0x00c1 }
                    if (r6 >= r7) goto L_0x00b2
                    java.util.List<android.support.v4.media.session.MediaSessionCompat$QueueItem> r5 = r5.mQueue     // Catch:{ BadParcelableException -> 0x00c1 }
                    java.lang.Object r5 = r5.get(r6)     // Catch:{ BadParcelableException -> 0x00c1 }
                    r1 = r5
                    android.support.v4.media.session.MediaSessionCompat$QueueItem r1 = (android.support.v4.media.session.MediaSessionCompat.QueueItem) r1     // Catch:{ BadParcelableException -> 0x00c1 }
                L_0x00b2:
                    if (r1 == 0) goto L_0x00c8
                    android.support.v4.media.session.MediaSessionCompat$Callback r5 = android.support.v4.media.session.MediaSessionCompat.Callback.this     // Catch:{ BadParcelableException -> 0x00c1 }
                    android.support.v4.media.MediaDescriptionCompat r6 = r1.getDescription()     // Catch:{ BadParcelableException -> 0x00c1 }
                    goto L_0x007e
                L_0x00bb:
                    android.support.v4.media.session.MediaSessionCompat$Callback r0 = android.support.v4.media.session.MediaSessionCompat.Callback.this     // Catch:{ BadParcelableException -> 0x00c1 }
                    r0.onCommand(r5, r6, r7)     // Catch:{ BadParcelableException -> 0x00c1 }
                    goto L_0x00c8
                L_0x00c1:
                    java.lang.String r5 = "MediaSessionCompat"
                    java.lang.String r6 = "Could not unparcel the extra data."
                    android.util.Log.e(r5, r6)
                L_0x00c8:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.Callback.StubApi21.onCommand(java.lang.String, android.os.Bundle, android.os.ResultReceiver):void");
            }

            public void onCustomAction(String str, Bundle bundle) {
                Bundle bundle2 = bundle.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS);
                MediaSessionCompat.ensureClassLoader(bundle2);
                if (str.equals(MediaSessionCompat.ACTION_PLAY_FROM_URI)) {
                    Callback.this.onPlayFromUri((Uri) bundle.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI), bundle2);
                } else if (str.equals(MediaSessionCompat.ACTION_PREPARE)) {
                    Callback.this.onPrepare();
                } else if (str.equals(MediaSessionCompat.ACTION_PREPARE_FROM_MEDIA_ID)) {
                    Callback.this.onPrepareFromMediaId(bundle.getString(MediaSessionCompat.ACTION_ARGUMENT_MEDIA_ID), bundle2);
                } else if (str.equals(MediaSessionCompat.ACTION_PREPARE_FROM_SEARCH)) {
                    Callback.this.onPrepareFromSearch(bundle.getString(MediaSessionCompat.ACTION_ARGUMENT_QUERY), bundle2);
                } else if (str.equals(MediaSessionCompat.ACTION_PREPARE_FROM_URI)) {
                    Callback.this.onPrepareFromUri((Uri) bundle.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI), bundle2);
                } else if (str.equals(MediaSessionCompat.ACTION_SET_CAPTIONING_ENABLED)) {
                    Callback.this.onSetCaptioningEnabled(bundle.getBoolean(MediaSessionCompat.ACTION_ARGUMENT_CAPTIONING_ENABLED));
                } else if (str.equals(MediaSessionCompat.ACTION_SET_REPEAT_MODE)) {
                    Callback.this.onSetRepeatMode(bundle.getInt(MediaSessionCompat.ACTION_ARGUMENT_REPEAT_MODE));
                } else if (str.equals(MediaSessionCompat.ACTION_SET_SHUFFLE_MODE)) {
                    Callback.this.onSetShuffleMode(bundle.getInt(MediaSessionCompat.ACTION_ARGUMENT_SHUFFLE_MODE));
                } else if (str.equals(MediaSessionCompat.ACTION_SET_RATING)) {
                    Callback.this.onSetRating((RatingCompat) bundle.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_RATING), bundle2);
                } else {
                    Callback.this.onCustomAction(str, bundle);
                }
            }

            public void onFastForward() {
                Callback.this.onFastForward();
            }

            public boolean onMediaButtonEvent(Intent intent) {
                return Callback.this.onMediaButtonEvent(intent);
            }

            public void onPause() {
                Callback.this.onPause();
            }

            public void onPlay() {
                Callback.this.onPlay();
            }

            public void onPlayFromMediaId(String str, Bundle bundle) {
                Callback.this.onPlayFromMediaId(str, bundle);
            }

            public void onPlayFromSearch(String str, Bundle bundle) {
                Callback.this.onPlayFromSearch(str, bundle);
            }

            public void onRewind() {
                Callback.this.onRewind();
            }

            public void onSeekTo(long j10) {
                Callback.this.onSeekTo(j10);
            }

            public void onSetRating(Object obj) {
                Callback.this.onSetRating(RatingCompat.fromRating(obj));
            }

            public void onSetRating(Object obj, Bundle bundle) {
            }

            public void onSkipToNext() {
                Callback.this.onSkipToNext();
            }

            public void onSkipToPrevious() {
                Callback.this.onSkipToPrevious();
            }

            public void onSkipToQueueItem(long j10) {
                Callback.this.onSkipToQueueItem(j10);
            }

            public void onStop() {
                Callback.this.onStop();
            }
        }

        private class StubApi23 extends StubApi21 implements MediaSessionCompatApi23.Callback {
            StubApi23() {
                super();
            }

            public void onPlayFromUri(Uri uri, Bundle bundle) {
                Callback.this.onPlayFromUri(uri, bundle);
            }
        }

        private class StubApi24 extends StubApi23 implements MediaSessionCompatApi24.Callback {
            StubApi24() {
                super();
            }

            public void onPrepare() {
                Callback.this.onPrepare();
            }

            public void onPrepareFromMediaId(String str, Bundle bundle) {
                Callback.this.onPrepareFromMediaId(str, bundle);
            }

            public void onPrepareFromSearch(String str, Bundle bundle) {
                Callback.this.onPrepareFromSearch(str, bundle);
            }

            public void onPrepareFromUri(Uri uri, Bundle bundle) {
                Callback.this.onPrepareFromUri(uri, bundle);
            }
        }

        public Callback() {
            Object obj = null;
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 24) {
                obj = MediaSessionCompatApi24.createCallback(new StubApi24());
            } else if (i10 >= 23) {
                obj = MediaSessionCompatApi23.createCallback(new StubApi23());
            } else if (i10 >= 21) {
                obj = MediaSessionCompatApi21.createCallback(new StubApi21());
            }
            this.mCallbackObj = obj;
        }

        /* access modifiers changed from: package-private */
        public void handleMediaPlayPauseKeySingleTapIfPending(b bVar) {
            if (this.mMediaPlayPauseKeyPending) {
                boolean z10 = false;
                this.mMediaPlayPauseKeyPending = false;
                this.mCallbackHandler.removeMessages(1);
                MediaSessionImpl mediaSessionImpl = (MediaSessionImpl) this.mSessionImpl.get();
                if (mediaSessionImpl != null) {
                    PlaybackStateCompat playbackState = mediaSessionImpl.getPlaybackState();
                    long actions = playbackState == null ? 0 : playbackState.getActions();
                    boolean z11 = playbackState != null && playbackState.getState() == 3;
                    boolean z12 = (516 & actions) != 0;
                    if ((actions & 514) != 0) {
                        z10 = true;
                    }
                    mediaSessionImpl.setCurrentControllerInfo(bVar);
                    if (z11 && z10) {
                        onPause();
                    } else if (!z11 && z12) {
                        onPlay();
                    }
                    mediaSessionImpl.setCurrentControllerInfo((b) null);
                }
            }
        }

        public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        }

        public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i10) {
        }

        public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
        }

        public void onCustomAction(String str, Bundle bundle) {
        }

        public void onFastForward() {
        }

        public boolean onMediaButtonEvent(Intent intent) {
            MediaSessionImpl mediaSessionImpl;
            KeyEvent keyEvent;
            if (Build.VERSION.SDK_INT >= 27 || (mediaSessionImpl = (MediaSessionImpl) this.mSessionImpl.get()) == null || this.mCallbackHandler == null || (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) == null || keyEvent.getAction() != 0) {
                return false;
            }
            b currentControllerInfo = mediaSessionImpl.getCurrentControllerInfo();
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 79 || keyCode == 85) {
                if (keyEvent.getRepeatCount() > 0) {
                    handleMediaPlayPauseKeySingleTapIfPending(currentControllerInfo);
                } else if (this.mMediaPlayPauseKeyPending) {
                    this.mCallbackHandler.removeMessages(1);
                    this.mMediaPlayPauseKeyPending = false;
                    PlaybackStateCompat playbackState = mediaSessionImpl.getPlaybackState();
                    if (((playbackState == null ? 0 : playbackState.getActions()) & 32) != 0) {
                        onSkipToNext();
                    }
                } else {
                    this.mMediaPlayPauseKeyPending = true;
                    CallbackHandler callbackHandler = this.mCallbackHandler;
                    callbackHandler.sendMessageDelayed(callbackHandler.obtainMessage(1, currentControllerInfo), (long) ViewConfiguration.getDoubleTapTimeout());
                }
                return true;
            }
            handleMediaPlayPauseKeySingleTapIfPending(currentControllerInfo);
            return false;
        }

        public void onPause() {
        }

        public void onPlay() {
        }

        public void onPlayFromMediaId(String str, Bundle bundle) {
        }

        public void onPlayFromSearch(String str, Bundle bundle) {
        }

        public void onPlayFromUri(Uri uri, Bundle bundle) {
        }

        public void onPrepare() {
        }

        public void onPrepareFromMediaId(String str, Bundle bundle) {
        }

        public void onPrepareFromSearch(String str, Bundle bundle) {
        }

        public void onPrepareFromUri(Uri uri, Bundle bundle) {
        }

        public void onRemoveQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        }

        @Deprecated
        public void onRemoveQueueItemAt(int i10) {
        }

        public void onRewind() {
        }

        public void onSeekTo(long j10) {
        }

        public void onSetCaptioningEnabled(boolean z10) {
        }

        public void onSetRating(RatingCompat ratingCompat) {
        }

        public void onSetRating(RatingCompat ratingCompat, Bundle bundle) {
        }

        public void onSetRepeatMode(int i10) {
        }

        public void onSetShuffleMode(int i10) {
        }

        public void onSkipToNext() {
        }

        public void onSkipToPrevious() {
        }

        public void onSkipToQueueItem(long j10) {
        }

        public void onStop() {
        }

        /* access modifiers changed from: package-private */
        public void setSessionImpl(MediaSessionImpl mediaSessionImpl, Handler handler) {
            this.mSessionImpl = new WeakReference<>(mediaSessionImpl);
            CallbackHandler callbackHandler = this.mCallbackHandler;
            if (callbackHandler != null) {
                callbackHandler.removeCallbacksAndMessages((Object) null);
            }
            this.mCallbackHandler = new CallbackHandler(handler.getLooper());
        }
    }

    interface MediaSessionImpl {
        String getCallingPackage();

        b getCurrentControllerInfo();

        Object getMediaSession();

        PlaybackStateCompat getPlaybackState();

        Object getRemoteControlClient();

        Token getSessionToken();

        boolean isActive();

        void release();

        void sendSessionEvent(String str, Bundle bundle);

        void setActive(boolean z10);

        void setCallback(Callback callback, Handler handler);

        void setCaptioningEnabled(boolean z10);

        void setCurrentControllerInfo(b bVar);

        void setExtras(Bundle bundle);

        void setFlags(int i10);

        void setMediaButtonReceiver(PendingIntent pendingIntent);

        void setMetadata(MediaMetadataCompat mediaMetadataCompat);

        void setPlaybackState(PlaybackStateCompat playbackStateCompat);

        void setPlaybackToLocal(int i10);

        void setPlaybackToRemote(f fVar);

        void setQueue(List<QueueItem> list);

        void setQueueTitle(CharSequence charSequence);

        void setRatingType(int i10);

        void setRepeatMode(int i10);

        void setSessionActivity(PendingIntent pendingIntent);

        void setShuffleMode(int i10);
    }

    static class MediaSessionImplApi18 extends MediaSessionImplBase {
        private static boolean sIsMbrPendingIntentSupported = true;

        MediaSessionImplApi18(Context context, String str, ComponentName componentName, PendingIntent pendingIntent) {
            super(context, str, componentName, pendingIntent);
        }

        /* access modifiers changed from: package-private */
        public int getRccTransportControlFlagsFromActions(long j10) {
            int rccTransportControlFlagsFromActions = super.getRccTransportControlFlagsFromActions(j10);
            return (j10 & 256) != 0 ? rccTransportControlFlagsFromActions | Config.X_DENSITY : rccTransportControlFlagsFromActions;
        }

        /* access modifiers changed from: package-private */
        public void registerMediaButtonEventReceiver(PendingIntent pendingIntent, ComponentName componentName) {
            if (sIsMbrPendingIntentSupported) {
                try {
                    this.mAudioManager.registerMediaButtonEventReceiver(pendingIntent);
                } catch (NullPointerException unused) {
                    Log.w(MediaSessionCompat.TAG, "Unable to register media button event receiver with PendingIntent, falling back to ComponentName.");
                    sIsMbrPendingIntentSupported = false;
                }
            }
            if (!sIsMbrPendingIntentSupported) {
                super.registerMediaButtonEventReceiver(pendingIntent, componentName);
            }
        }

        public void setCallback(Callback callback, Handler handler) {
            super.setCallback(callback, handler);
            if (callback == null) {
                this.mRcc.setPlaybackPositionUpdateListener((RemoteControlClient.OnPlaybackPositionUpdateListener) null);
                return;
            }
            this.mRcc.setPlaybackPositionUpdateListener(new RemoteControlClient.OnPlaybackPositionUpdateListener() {
                public void onPlaybackPositionUpdate(long j10) {
                    MediaSessionImplApi18.this.postToHandler(18, -1, -1, Long.valueOf(j10), (Bundle) null);
                }
            });
        }

        /* access modifiers changed from: package-private */
        public void setRccState(PlaybackStateCompat playbackStateCompat) {
            long position = playbackStateCompat.getPosition();
            float playbackSpeed = playbackStateCompat.getPlaybackSpeed();
            long lastPositionUpdateTime = playbackStateCompat.getLastPositionUpdateTime();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (playbackStateCompat.getState() == 3) {
                long j10 = 0;
                if (position > 0) {
                    if (lastPositionUpdateTime > 0) {
                        j10 = elapsedRealtime - lastPositionUpdateTime;
                        if (playbackSpeed > 0.0f && playbackSpeed != 1.0f) {
                            j10 = (long) (((float) j10) * playbackSpeed);
                        }
                    }
                    position += j10;
                }
            }
            this.mRcc.setPlaybackState(getRccStateFromState(playbackStateCompat.getState()), position, playbackSpeed);
        }

        /* access modifiers changed from: package-private */
        public void unregisterMediaButtonEventReceiver(PendingIntent pendingIntent, ComponentName componentName) {
            if (sIsMbrPendingIntentSupported) {
                this.mAudioManager.unregisterMediaButtonEventReceiver(pendingIntent);
            } else {
                super.unregisterMediaButtonEventReceiver(pendingIntent, componentName);
            }
        }
    }

    static class MediaSessionImplApi19 extends MediaSessionImplApi18 {
        MediaSessionImplApi19(Context context, String str, ComponentName componentName, PendingIntent pendingIntent) {
            super(context, str, componentName, pendingIntent);
        }

        /* access modifiers changed from: package-private */
        public RemoteControlClient.MetadataEditor buildRccMetadata(Bundle bundle) {
            RemoteControlClient.MetadataEditor buildRccMetadata = super.buildRccMetadata(bundle);
            PlaybackStateCompat playbackStateCompat = this.mState;
            if (((playbackStateCompat == null ? 0 : playbackStateCompat.getActions()) & 128) != 0) {
                buildRccMetadata.addEditableKey(268435457);
            }
            if (bundle == null) {
                return buildRccMetadata;
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_YEAR)) {
                buildRccMetadata.putLong(8, bundle.getLong(MediaMetadataCompat.METADATA_KEY_YEAR));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_RATING)) {
                buildRccMetadata.putObject(101, bundle.getParcelable(MediaMetadataCompat.METADATA_KEY_RATING));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_USER_RATING)) {
                buildRccMetadata.putObject(268435457, bundle.getParcelable(MediaMetadataCompat.METADATA_KEY_USER_RATING));
            }
            return buildRccMetadata;
        }

        /* access modifiers changed from: package-private */
        public int getRccTransportControlFlagsFromActions(long j10) {
            int rccTransportControlFlagsFromActions = super.getRccTransportControlFlagsFromActions(j10);
            return (j10 & 128) != 0 ? rccTransportControlFlagsFromActions | 512 : rccTransportControlFlagsFromActions;
        }

        public void setCallback(Callback callback, Handler handler) {
            super.setCallback(callback, handler);
            if (callback == null) {
                this.mRcc.setMetadataUpdateListener((RemoteControlClient.OnMetadataUpdateListener) null);
                return;
            }
            this.mRcc.setMetadataUpdateListener(new RemoteControlClient.OnMetadataUpdateListener() {
                public void onMetadataUpdate(int i10, Object obj) {
                    if (i10 == 268435457 && (obj instanceof Rating)) {
                        MediaSessionImplApi19.this.postToHandler(19, -1, -1, RatingCompat.fromRating(obj), (Bundle) null);
                    }
                }
            });
        }
    }

    static class MediaSessionImplApi21 implements MediaSessionImpl {
        boolean mCaptioningEnabled;
        boolean mDestroyed = false;
        final RemoteCallbackList<IMediaControllerCallback> mExtraControllerCallbacks = new RemoteCallbackList<>();
        MediaMetadataCompat mMetadata;
        PlaybackStateCompat mPlaybackState;
        List<QueueItem> mQueue;
        int mRatingType;
        int mRepeatMode;
        final Object mSessionObj;
        int mShuffleMode;
        final Token mToken;

        class ExtraSession extends IMediaSession.Stub {
            ExtraSession() {
            }

            public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }

            public void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat, int i10) {
                throw new AssertionError();
            }

            public void adjustVolume(int i10, int i11, String str) {
                throw new AssertionError();
            }

            public void fastForward() {
                throw new AssertionError();
            }

            public Bundle getExtras() {
                throw new AssertionError();
            }

            public long getFlags() {
                throw new AssertionError();
            }

            public PendingIntent getLaunchPendingIntent() {
                throw new AssertionError();
            }

            public MediaMetadataCompat getMetadata() {
                throw new AssertionError();
            }

            public String getPackageName() {
                throw new AssertionError();
            }

            public PlaybackStateCompat getPlaybackState() {
                MediaSessionImplApi21 mediaSessionImplApi21 = MediaSessionImplApi21.this;
                return MediaSessionCompat.getStateWithUpdatedPosition(mediaSessionImplApi21.mPlaybackState, mediaSessionImplApi21.mMetadata);
            }

            public List<QueueItem> getQueue() {
                return null;
            }

            public CharSequence getQueueTitle() {
                throw new AssertionError();
            }

            public int getRatingType() {
                return MediaSessionImplApi21.this.mRatingType;
            }

            public int getRepeatMode() {
                return MediaSessionImplApi21.this.mRepeatMode;
            }

            public int getShuffleMode() {
                return MediaSessionImplApi21.this.mShuffleMode;
            }

            public String getTag() {
                throw new AssertionError();
            }

            public ParcelableVolumeInfo getVolumeAttributes() {
                throw new AssertionError();
            }

            public boolean isCaptioningEnabled() {
                return MediaSessionImplApi21.this.mCaptioningEnabled;
            }

            public boolean isShuffleModeEnabledRemoved() {
                return false;
            }

            public boolean isTransportControlEnabled() {
                throw new AssertionError();
            }

            public void next() {
                throw new AssertionError();
            }

            public void pause() {
                throw new AssertionError();
            }

            public void play() {
                throw new AssertionError();
            }

            public void playFromMediaId(String str, Bundle bundle) {
                throw new AssertionError();
            }

            public void playFromSearch(String str, Bundle bundle) {
                throw new AssertionError();
            }

            public void playFromUri(Uri uri, Bundle bundle) {
                throw new AssertionError();
            }

            public void prepare() {
                throw new AssertionError();
            }

            public void prepareFromMediaId(String str, Bundle bundle) {
                throw new AssertionError();
            }

            public void prepareFromSearch(String str, Bundle bundle) {
                throw new AssertionError();
            }

            public void prepareFromUri(Uri uri, Bundle bundle) {
                throw new AssertionError();
            }

            public void previous() {
                throw new AssertionError();
            }

            public void rate(RatingCompat ratingCompat) {
                throw new AssertionError();
            }

            public void rateWithExtras(RatingCompat ratingCompat, Bundle bundle) {
                throw new AssertionError();
            }

            public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                MediaSessionImplApi21 mediaSessionImplApi21 = MediaSessionImplApi21.this;
                if (!mediaSessionImplApi21.mDestroyed) {
                    String callingPackage = mediaSessionImplApi21.getCallingPackage();
                    if (callingPackage == null) {
                        callingPackage = "android.media.session.MediaController";
                    }
                    MediaSessionImplApi21.this.mExtraControllerCallbacks.register(iMediaControllerCallback, new b(callingPackage, Binder.getCallingPid(), Binder.getCallingUid()));
                }
            }

            public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }

            public void removeQueueItemAt(int i10) {
                throw new AssertionError();
            }

            public void rewind() {
                throw new AssertionError();
            }

            public void seekTo(long j10) {
                throw new AssertionError();
            }

            public void sendCommand(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                throw new AssertionError();
            }

            public void sendCustomAction(String str, Bundle bundle) {
                throw new AssertionError();
            }

            public boolean sendMediaButton(KeyEvent keyEvent) {
                throw new AssertionError();
            }

            public void setCaptioningEnabled(boolean z10) {
                throw new AssertionError();
            }

            public void setRepeatMode(int i10) {
                throw new AssertionError();
            }

            public void setShuffleMode(int i10) {
                throw new AssertionError();
            }

            public void setShuffleModeEnabledRemoved(boolean z10) {
            }

            public void setVolumeTo(int i10, int i11, String str) {
                throw new AssertionError();
            }

            public void skipToQueueItem(long j10) {
                throw new AssertionError();
            }

            public void stop() {
                throw new AssertionError();
            }

            public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                MediaSessionImplApi21.this.mExtraControllerCallbacks.unregister(iMediaControllerCallback);
            }
        }

        MediaSessionImplApi21(Context context, String str, Bundle bundle) {
            Object createSession = MediaSessionCompatApi21.createSession(context, str);
            this.mSessionObj = createSession;
            this.mToken = new Token(MediaSessionCompatApi21.getSessionToken(createSession), new ExtraSession(), bundle);
        }

        MediaSessionImplApi21(Object obj) {
            Object verifySession = MediaSessionCompatApi21.verifySession(obj);
            this.mSessionObj = verifySession;
            this.mToken = new Token(MediaSessionCompatApi21.getSessionToken(verifySession), new ExtraSession());
        }

        public String getCallingPackage() {
            if (Build.VERSION.SDK_INT < 24) {
                return null;
            }
            return MediaSessionCompatApi24.getCallingPackage(this.mSessionObj);
        }

        public b getCurrentControllerInfo() {
            return null;
        }

        public Object getMediaSession() {
            return this.mSessionObj;
        }

        public PlaybackStateCompat getPlaybackState() {
            return this.mPlaybackState;
        }

        public Object getRemoteControlClient() {
            return null;
        }

        public Token getSessionToken() {
            return this.mToken;
        }

        public boolean isActive() {
            return MediaSessionCompatApi21.isActive(this.mSessionObj);
        }

        public void release() {
            this.mDestroyed = true;
            MediaSessionCompatApi21.release(this.mSessionObj);
        }

        public void sendSessionEvent(String str, Bundle bundle) {
            if (Build.VERSION.SDK_INT < 23) {
                for (int beginBroadcast = this.mExtraControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mExtraControllerCallbacks.getBroadcastItem(beginBroadcast).onEvent(str, bundle);
                    } catch (RemoteException unused) {
                    }
                }
                this.mExtraControllerCallbacks.finishBroadcast();
            }
            MediaSessionCompatApi21.sendSessionEvent(this.mSessionObj, str, bundle);
        }

        public void setActive(boolean z10) {
            MediaSessionCompatApi21.setActive(this.mSessionObj, z10);
        }

        public void setCallback(Callback callback, Handler handler) {
            MediaSessionCompatApi21.setCallback(this.mSessionObj, callback == null ? null : callback.mCallbackObj, handler);
            if (callback != null) {
                callback.setSessionImpl(this, handler);
            }
        }

        public void setCaptioningEnabled(boolean z10) {
            if (this.mCaptioningEnabled != z10) {
                this.mCaptioningEnabled = z10;
                for (int beginBroadcast = this.mExtraControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mExtraControllerCallbacks.getBroadcastItem(beginBroadcast).onCaptioningEnabledChanged(z10);
                    } catch (RemoteException unused) {
                    }
                }
                this.mExtraControllerCallbacks.finishBroadcast();
            }
        }

        public void setCurrentControllerInfo(b bVar) {
        }

        public void setExtras(Bundle bundle) {
            MediaSessionCompatApi21.setExtras(this.mSessionObj, bundle);
        }

        public void setFlags(int i10) {
            MediaSessionCompatApi21.setFlags(this.mSessionObj, i10);
        }

        public void setMediaButtonReceiver(PendingIntent pendingIntent) {
            MediaSessionCompatApi21.setMediaButtonReceiver(this.mSessionObj, pendingIntent);
        }

        public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
            this.mMetadata = mediaMetadataCompat;
            MediaSessionCompatApi21.setMetadata(this.mSessionObj, mediaMetadataCompat == null ? null : mediaMetadataCompat.getMediaMetadata());
        }

        public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
            this.mPlaybackState = playbackStateCompat;
            for (int beginBroadcast = this.mExtraControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.mExtraControllerCallbacks.getBroadcastItem(beginBroadcast).onPlaybackStateChanged(playbackStateCompat);
                } catch (RemoteException unused) {
                }
            }
            this.mExtraControllerCallbacks.finishBroadcast();
            MediaSessionCompatApi21.setPlaybackState(this.mSessionObj, playbackStateCompat == null ? null : playbackStateCompat.getPlaybackState());
        }

        public void setPlaybackToLocal(int i10) {
            MediaSessionCompatApi21.setPlaybackToLocal(this.mSessionObj, i10);
        }

        public void setPlaybackToRemote(f fVar) {
            throw null;
        }

        public void setQueue(List<QueueItem> list) {
            ArrayList arrayList;
            this.mQueue = list;
            if (list != null) {
                arrayList = new ArrayList();
                for (QueueItem queueItem : list) {
                    arrayList.add(queueItem.getQueueItem());
                }
            } else {
                arrayList = null;
            }
            MediaSessionCompatApi21.setQueue(this.mSessionObj, arrayList);
        }

        public void setQueueTitle(CharSequence charSequence) {
            MediaSessionCompatApi21.setQueueTitle(this.mSessionObj, charSequence);
        }

        public void setRatingType(int i10) {
            if (Build.VERSION.SDK_INT < 22) {
                this.mRatingType = i10;
            } else {
                MediaSessionCompatApi22.setRatingType(this.mSessionObj, i10);
            }
        }

        public void setRepeatMode(int i10) {
            if (this.mRepeatMode != i10) {
                this.mRepeatMode = i10;
                for (int beginBroadcast = this.mExtraControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mExtraControllerCallbacks.getBroadcastItem(beginBroadcast).onRepeatModeChanged(i10);
                    } catch (RemoteException unused) {
                    }
                }
                this.mExtraControllerCallbacks.finishBroadcast();
            }
        }

        public void setSessionActivity(PendingIntent pendingIntent) {
            MediaSessionCompatApi21.setSessionActivity(this.mSessionObj, pendingIntent);
        }

        public void setShuffleMode(int i10) {
            if (this.mShuffleMode != i10) {
                this.mShuffleMode = i10;
                for (int beginBroadcast = this.mExtraControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mExtraControllerCallbacks.getBroadcastItem(beginBroadcast).onShuffleModeChanged(i10);
                    } catch (RemoteException unused) {
                    }
                }
                this.mExtraControllerCallbacks.finishBroadcast();
            }
        }
    }

    static class MediaSessionImplApi28 extends MediaSessionImplApi21 {
        MediaSessionImplApi28(Context context, String str, Bundle bundle) {
            super(context, str, bundle);
        }

        MediaSessionImplApi28(Object obj) {
            super(obj);
        }

        public final b getCurrentControllerInfo() {
            return new b(((MediaSession) this.mSessionObj).getCurrentControllerInfo());
        }

        public void setCurrentControllerInfo(b bVar) {
        }
    }

    static class MediaSessionImplBase implements MediaSessionImpl {
        static final int RCC_PLAYSTATE_NONE = 0;
        final AudioManager mAudioManager;
        volatile Callback mCallback;
        boolean mCaptioningEnabled;
        private final Context mContext;
        final RemoteCallbackList<IMediaControllerCallback> mControllerCallbacks = new RemoteCallbackList<>();
        boolean mDestroyed = false;
        Bundle mExtras;
        int mFlags;
        private MessageHandler mHandler;
        boolean mIsActive = false;
        private boolean mIsMbrRegistered = false;
        private boolean mIsRccRegistered = false;
        int mLocalStream;
        final Object mLock = new Object();
        private final ComponentName mMediaButtonReceiverComponentName;
        private final PendingIntent mMediaButtonReceiverIntent;
        MediaMetadataCompat mMetadata;
        final String mPackageName;
        List<QueueItem> mQueue;
        CharSequence mQueueTitle;
        int mRatingType;
        final RemoteControlClient mRcc;
        private b mRemoteUserInfo;
        int mRepeatMode;
        PendingIntent mSessionActivity;
        int mShuffleMode;
        PlaybackStateCompat mState;
        private final MediaSessionStub mStub;
        final String mTag;
        private final Token mToken;
        private f.a mVolumeCallback = new f.a() {
            public void onVolumeChanged(f fVar) {
                if (MediaSessionImplBase.this.mVolumeProvider == fVar) {
                    MediaSessionImplBase mediaSessionImplBase = MediaSessionImplBase.this;
                    int i10 = mediaSessionImplBase.mVolumeType;
                    int i11 = mediaSessionImplBase.mLocalStream;
                    throw null;
                }
            }
        };
        f mVolumeProvider;
        int mVolumeType;

        private static final class Command {
            public final String command;
            public final Bundle extras;
            public final ResultReceiver stub;

            public Command(String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.command = str;
                this.extras = bundle;
                this.stub = resultReceiver;
            }
        }

        class MediaSessionStub extends IMediaSession.Stub {
            MediaSessionStub() {
            }

            public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                postToHandler(25, (Object) mediaDescriptionCompat);
            }

            public void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat, int i10) {
                postToHandler(26, (Object) mediaDescriptionCompat, i10);
            }

            public void adjustVolume(int i10, int i11, String str) {
                MediaSessionImplBase.this.adjustVolume(i10, i11);
            }

            public void fastForward() {
                postToHandler(16);
            }

            public Bundle getExtras() {
                Bundle bundle;
                synchronized (MediaSessionImplBase.this.mLock) {
                    bundle = MediaSessionImplBase.this.mExtras;
                }
                return bundle;
            }

            public long getFlags() {
                long j10;
                synchronized (MediaSessionImplBase.this.mLock) {
                    j10 = (long) MediaSessionImplBase.this.mFlags;
                }
                return j10;
            }

            public PendingIntent getLaunchPendingIntent() {
                PendingIntent pendingIntent;
                synchronized (MediaSessionImplBase.this.mLock) {
                    pendingIntent = MediaSessionImplBase.this.mSessionActivity;
                }
                return pendingIntent;
            }

            public MediaMetadataCompat getMetadata() {
                return MediaSessionImplBase.this.mMetadata;
            }

            public String getPackageName() {
                return MediaSessionImplBase.this.mPackageName;
            }

            public PlaybackStateCompat getPlaybackState() {
                PlaybackStateCompat playbackStateCompat;
                MediaMetadataCompat mediaMetadataCompat;
                synchronized (MediaSessionImplBase.this.mLock) {
                    MediaSessionImplBase mediaSessionImplBase = MediaSessionImplBase.this;
                    playbackStateCompat = mediaSessionImplBase.mState;
                    mediaMetadataCompat = mediaSessionImplBase.mMetadata;
                }
                return MediaSessionCompat.getStateWithUpdatedPosition(playbackStateCompat, mediaMetadataCompat);
            }

            public List<QueueItem> getQueue() {
                List<QueueItem> list;
                synchronized (MediaSessionImplBase.this.mLock) {
                    list = MediaSessionImplBase.this.mQueue;
                }
                return list;
            }

            public CharSequence getQueueTitle() {
                return MediaSessionImplBase.this.mQueueTitle;
            }

            public int getRatingType() {
                return MediaSessionImplBase.this.mRatingType;
            }

            public int getRepeatMode() {
                return MediaSessionImplBase.this.mRepeatMode;
            }

            public int getShuffleMode() {
                return MediaSessionImplBase.this.mShuffleMode;
            }

            public String getTag() {
                return MediaSessionImplBase.this.mTag;
            }

            public ParcelableVolumeInfo getVolumeAttributes() {
                int i10;
                int i11;
                int streamMaxVolume;
                int streamVolume;
                synchronized (MediaSessionImplBase.this.mLock) {
                    MediaSessionImplBase mediaSessionImplBase = MediaSessionImplBase.this;
                    i10 = mediaSessionImplBase.mVolumeType;
                    i11 = mediaSessionImplBase.mLocalStream;
                    f fVar = mediaSessionImplBase.mVolumeProvider;
                    if (i10 != 2) {
                        streamMaxVolume = mediaSessionImplBase.mAudioManager.getStreamMaxVolume(i11);
                        streamVolume = MediaSessionImplBase.this.mAudioManager.getStreamVolume(i11);
                    } else {
                        throw null;
                    }
                }
                return new ParcelableVolumeInfo(i10, i11, 2, streamMaxVolume, streamVolume);
            }

            public boolean isCaptioningEnabled() {
                return MediaSessionImplBase.this.mCaptioningEnabled;
            }

            public boolean isShuffleModeEnabledRemoved() {
                return false;
            }

            public boolean isTransportControlEnabled() {
                return (MediaSessionImplBase.this.mFlags & 2) != 0;
            }

            public void next() {
                postToHandler(14);
            }

            public void pause() {
                postToHandler(12);
            }

            public void play() {
                postToHandler(7);
            }

            public void playFromMediaId(String str, Bundle bundle) {
                postToHandler(8, (Object) str, bundle);
            }

            public void playFromSearch(String str, Bundle bundle) {
                postToHandler(9, (Object) str, bundle);
            }

            public void playFromUri(Uri uri, Bundle bundle) {
                postToHandler(10, (Object) uri, bundle);
            }

            /* access modifiers changed from: package-private */
            public void postToHandler(int i10) {
                MediaSessionImplBase.this.postToHandler(i10, 0, 0, (Object) null, (Bundle) null);
            }

            /* access modifiers changed from: package-private */
            public void postToHandler(int i10, int i11) {
                MediaSessionImplBase.this.postToHandler(i10, i11, 0, (Object) null, (Bundle) null);
            }

            /* access modifiers changed from: package-private */
            public void postToHandler(int i10, Object obj) {
                MediaSessionImplBase.this.postToHandler(i10, 0, 0, obj, (Bundle) null);
            }

            /* access modifiers changed from: package-private */
            public void postToHandler(int i10, Object obj, int i11) {
                MediaSessionImplBase.this.postToHandler(i10, i11, 0, obj, (Bundle) null);
            }

            /* access modifiers changed from: package-private */
            public void postToHandler(int i10, Object obj, Bundle bundle) {
                MediaSessionImplBase.this.postToHandler(i10, 0, 0, obj, bundle);
            }

            public void prepare() {
                postToHandler(3);
            }

            public void prepareFromMediaId(String str, Bundle bundle) {
                postToHandler(4, (Object) str, bundle);
            }

            public void prepareFromSearch(String str, Bundle bundle) {
                postToHandler(5, (Object) str, bundle);
            }

            public void prepareFromUri(Uri uri, Bundle bundle) {
                postToHandler(6, (Object) uri, bundle);
            }

            public void previous() {
                postToHandler(15);
            }

            public void rate(RatingCompat ratingCompat) {
                postToHandler(19, (Object) ratingCompat);
            }

            public void rateWithExtras(RatingCompat ratingCompat, Bundle bundle) {
                postToHandler(31, (Object) ratingCompat, bundle);
            }

            public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                if (MediaSessionImplBase.this.mDestroyed) {
                    try {
                        iMediaControllerCallback.onSessionDestroyed();
                    } catch (Exception unused) {
                    }
                } else {
                    MediaSessionImplBase.this.mControllerCallbacks.register(iMediaControllerCallback, new b("android.media.session.MediaController", Binder.getCallingPid(), Binder.getCallingUid()));
                }
            }

            public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                postToHandler(27, (Object) mediaDescriptionCompat);
            }

            public void removeQueueItemAt(int i10) {
                postToHandler(28, i10);
            }

            public void rewind() {
                postToHandler(17);
            }

            public void seekTo(long j10) {
                postToHandler(18, (Object) Long.valueOf(j10));
            }

            public void sendCommand(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                postToHandler(1, (Object) new Command(str, bundle, resultReceiverWrapper.mResultReceiver));
            }

            public void sendCustomAction(String str, Bundle bundle) {
                postToHandler(20, (Object) str, bundle);
            }

            public boolean sendMediaButton(KeyEvent keyEvent) {
                boolean z10 = true;
                if ((MediaSessionImplBase.this.mFlags & 1) == 0) {
                    z10 = false;
                }
                if (z10) {
                    postToHandler(21, (Object) keyEvent);
                }
                return z10;
            }

            public void setCaptioningEnabled(boolean z10) {
                postToHandler(29, (Object) Boolean.valueOf(z10));
            }

            public void setRepeatMode(int i10) {
                postToHandler(23, i10);
            }

            public void setShuffleMode(int i10) {
                postToHandler(30, i10);
            }

            public void setShuffleModeEnabledRemoved(boolean z10) {
            }

            public void setVolumeTo(int i10, int i11, String str) {
                MediaSessionImplBase.this.setVolumeTo(i10, i11);
            }

            public void skipToQueueItem(long j10) {
                postToHandler(11, (Object) Long.valueOf(j10));
            }

            public void stop() {
                postToHandler(13);
            }

            public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                MediaSessionImplBase.this.mControllerCallbacks.unregister(iMediaControllerCallback);
            }
        }

        class MessageHandler extends Handler {
            private static final int KEYCODE_MEDIA_PAUSE = 127;
            private static final int KEYCODE_MEDIA_PLAY = 126;
            private static final int MSG_ADD_QUEUE_ITEM = 25;
            private static final int MSG_ADD_QUEUE_ITEM_AT = 26;
            private static final int MSG_ADJUST_VOLUME = 2;
            private static final int MSG_COMMAND = 1;
            private static final int MSG_CUSTOM_ACTION = 20;
            private static final int MSG_FAST_FORWARD = 16;
            private static final int MSG_MEDIA_BUTTON = 21;
            private static final int MSG_NEXT = 14;
            private static final int MSG_PAUSE = 12;
            private static final int MSG_PLAY = 7;
            private static final int MSG_PLAY_MEDIA_ID = 8;
            private static final int MSG_PLAY_SEARCH = 9;
            private static final int MSG_PLAY_URI = 10;
            private static final int MSG_PREPARE = 3;
            private static final int MSG_PREPARE_MEDIA_ID = 4;
            private static final int MSG_PREPARE_SEARCH = 5;
            private static final int MSG_PREPARE_URI = 6;
            private static final int MSG_PREVIOUS = 15;
            private static final int MSG_RATE = 19;
            private static final int MSG_RATE_EXTRA = 31;
            private static final int MSG_REMOVE_QUEUE_ITEM = 27;
            private static final int MSG_REMOVE_QUEUE_ITEM_AT = 28;
            private static final int MSG_REWIND = 17;
            private static final int MSG_SEEK_TO = 18;
            private static final int MSG_SET_CAPTIONING_ENABLED = 29;
            private static final int MSG_SET_REPEAT_MODE = 23;
            private static final int MSG_SET_SHUFFLE_MODE = 30;
            private static final int MSG_SET_VOLUME = 22;
            private static final int MSG_SKIP_TO_ITEM = 11;
            private static final int MSG_STOP = 13;

            public MessageHandler(Looper looper) {
                super(looper);
            }

            private void onMediaButtonEvent(KeyEvent keyEvent, Callback callback) {
                if (keyEvent != null && keyEvent.getAction() == 0) {
                    PlaybackStateCompat playbackStateCompat = MediaSessionImplBase.this.mState;
                    long actions = playbackStateCompat == null ? 0 : playbackStateCompat.getActions();
                    int keyCode = keyEvent.getKeyCode();
                    if (keyCode != 79) {
                        if (keyCode != 126) {
                            if (keyCode != KEYCODE_MEDIA_PAUSE) {
                                switch (keyCode) {
                                    case 85:
                                        break;
                                    case 86:
                                        if ((actions & 1) != 0) {
                                            callback.onStop();
                                            return;
                                        }
                                        return;
                                    case 87:
                                        if ((actions & 32) != 0) {
                                            callback.onSkipToNext();
                                            return;
                                        }
                                        return;
                                    case 88:
                                        if ((actions & 16) != 0) {
                                            callback.onSkipToPrevious();
                                            return;
                                        }
                                        return;
                                    case 89:
                                        if ((actions & 8) != 0) {
                                            callback.onRewind();
                                            return;
                                        }
                                        return;
                                    case 90:
                                        if ((actions & 64) != 0) {
                                            callback.onFastForward();
                                            return;
                                        }
                                        return;
                                    default:
                                        return;
                                }
                            } else if ((actions & 2) != 0) {
                                callback.onPause();
                                return;
                            } else {
                                return;
                            }
                        } else if ((actions & 4) != 0) {
                            callback.onPlay();
                            return;
                        } else {
                            return;
                        }
                    }
                    Log.w(MediaSessionCompat.TAG, "KEYCODE_MEDIA_PLAY_PAUSE and KEYCODE_HEADSETHOOK are handled already");
                }
            }

            /* JADX WARNING: Can't fix incorrect switch cases order */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void handleMessage(android.os.Message r8) {
                /*
                    r7 = this;
                    android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase r0 = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this
                    android.support.v4.media.session.MediaSessionCompat$Callback r0 = r0.mCallback
                    if (r0 != 0) goto L_0x0007
                    return
                L_0x0007:
                    android.os.Bundle r1 = r8.getData()
                    android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(r1)
                    android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase r2 = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this
                    androidx.media.b r3 = new androidx.media.b
                    java.lang.String r4 = "data_calling_pkg"
                    java.lang.String r4 = r1.getString(r4)
                    java.lang.String r5 = "data_calling_pid"
                    int r5 = r1.getInt(r5)
                    java.lang.String r6 = "data_calling_uid"
                    int r6 = r1.getInt(r6)
                    r3.<init>(r4, r5, r6)
                    r2.setCurrentControllerInfo(r3)
                    java.lang.String r2 = "data_extras"
                    android.os.Bundle r1 = r1.getBundle(r2)
                    android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(r1)
                    r2 = 0
                    int r3 = r8.what     // Catch:{ all -> 0x015f }
                    r4 = 0
                    switch(r3) {
                        case 1: goto L_0x014c;
                        case 2: goto L_0x0144;
                        case 3: goto L_0x0140;
                        case 4: goto L_0x0138;
                        case 5: goto L_0x0130;
                        case 6: goto L_0x0128;
                        case 7: goto L_0x0124;
                        case 8: goto L_0x011c;
                        case 9: goto L_0x0114;
                        case 10: goto L_0x010c;
                        case 11: goto L_0x0100;
                        case 12: goto L_0x00fc;
                        case 13: goto L_0x00f8;
                        case 14: goto L_0x00f4;
                        case 15: goto L_0x00ef;
                        case 16: goto L_0x00ea;
                        case 17: goto L_0x00e5;
                        case 18: goto L_0x00d8;
                        case 19: goto L_0x00cf;
                        case 20: goto L_0x00c6;
                        case 21: goto L_0x00ab;
                        case 22: goto L_0x00a2;
                        case 23: goto L_0x009b;
                        case 24: goto L_0x003a;
                        case 25: goto L_0x0092;
                        case 26: goto L_0x0087;
                        case 27: goto L_0x0082;
                        case 28: goto L_0x0059;
                        case 29: goto L_0x004c;
                        case 30: goto L_0x0045;
                        case 31: goto L_0x003c;
                        default: goto L_0x003a;
                    }     // Catch:{ all -> 0x015f }
                L_0x003a:
                    goto L_0x0159
                L_0x003c:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x015f }
                    android.support.v4.media.RatingCompat r8 = (android.support.v4.media.RatingCompat) r8     // Catch:{ all -> 0x015f }
                    r0.onSetRating(r8, r1)     // Catch:{ all -> 0x015f }
                    goto L_0x0159
                L_0x0045:
                    int r8 = r8.arg1     // Catch:{ all -> 0x015f }
                    r0.onSetShuffleMode(r8)     // Catch:{ all -> 0x015f }
                    goto L_0x0159
                L_0x004c:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x015f }
                    java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x015f }
                    boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x015f }
                    r0.onSetCaptioningEnabled(r8)     // Catch:{ all -> 0x015f }
                    goto L_0x0159
                L_0x0059:
                    android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase r1 = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this     // Catch:{ all -> 0x015f }
                    java.util.List<android.support.v4.media.session.MediaSessionCompat$QueueItem> r1 = r1.mQueue     // Catch:{ all -> 0x015f }
                    if (r1 == 0) goto L_0x0159
                    int r3 = r8.arg1     // Catch:{ all -> 0x015f }
                    if (r3 < 0) goto L_0x0076
                    int r1 = r1.size()     // Catch:{ all -> 0x015f }
                    if (r3 >= r1) goto L_0x0076
                    android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase r1 = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this     // Catch:{ all -> 0x015f }
                    java.util.List<android.support.v4.media.session.MediaSessionCompat$QueueItem> r1 = r1.mQueue     // Catch:{ all -> 0x015f }
                    int r8 = r8.arg1     // Catch:{ all -> 0x015f }
                    java.lang.Object r8 = r1.get(r8)     // Catch:{ all -> 0x015f }
                    android.support.v4.media.session.MediaSessionCompat$QueueItem r8 = (android.support.v4.media.session.MediaSessionCompat.QueueItem) r8     // Catch:{ all -> 0x015f }
                    goto L_0x0077
                L_0x0076:
                    r8 = r2
                L_0x0077:
                    if (r8 == 0) goto L_0x0159
                    android.support.v4.media.MediaDescriptionCompat r8 = r8.getDescription()     // Catch:{ all -> 0x015f }
                L_0x007d:
                    r0.onRemoveQueueItem(r8)     // Catch:{ all -> 0x015f }
                    goto L_0x0159
                L_0x0082:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x015f }
                    android.support.v4.media.MediaDescriptionCompat r8 = (android.support.v4.media.MediaDescriptionCompat) r8     // Catch:{ all -> 0x015f }
                    goto L_0x007d
                L_0x0087:
                    java.lang.Object r1 = r8.obj     // Catch:{ all -> 0x015f }
                    android.support.v4.media.MediaDescriptionCompat r1 = (android.support.v4.media.MediaDescriptionCompat) r1     // Catch:{ all -> 0x015f }
                    int r8 = r8.arg1     // Catch:{ all -> 0x015f }
                    r0.onAddQueueItem(r1, r8)     // Catch:{ all -> 0x015f }
                    goto L_0x0159
                L_0x0092:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x015f }
                    android.support.v4.media.MediaDescriptionCompat r8 = (android.support.v4.media.MediaDescriptionCompat) r8     // Catch:{ all -> 0x015f }
                    r0.onAddQueueItem(r8)     // Catch:{ all -> 0x015f }
                    goto L_0x0159
                L_0x009b:
                    int r8 = r8.arg1     // Catch:{ all -> 0x015f }
                    r0.onSetRepeatMode(r8)     // Catch:{ all -> 0x015f }
                    goto L_0x0159
                L_0x00a2:
                    android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase r0 = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this     // Catch:{ all -> 0x015f }
                    int r8 = r8.arg1     // Catch:{ all -> 0x015f }
                    r0.setVolumeTo(r8, r4)     // Catch:{ all -> 0x015f }
                    goto L_0x0159
                L_0x00ab:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x015f }
                    android.view.KeyEvent r8 = (android.view.KeyEvent) r8     // Catch:{ all -> 0x015f }
                    android.content.Intent r1 = new android.content.Intent     // Catch:{ all -> 0x015f }
                    java.lang.String r3 = "android.intent.action.MEDIA_BUTTON"
                    r1.<init>(r3)     // Catch:{ all -> 0x015f }
                    java.lang.String r3 = "android.intent.extra.KEY_EVENT"
                    r1.putExtra(r3, r8)     // Catch:{ all -> 0x015f }
                    boolean r1 = r0.onMediaButtonEvent(r1)     // Catch:{ all -> 0x015f }
                    if (r1 != 0) goto L_0x0159
                    r7.onMediaButtonEvent(r8, r0)     // Catch:{ all -> 0x015f }
                    goto L_0x0159
                L_0x00c6:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x015f }
                    java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x015f }
                    r0.onCustomAction(r8, r1)     // Catch:{ all -> 0x015f }
                    goto L_0x0159
                L_0x00cf:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x015f }
                    android.support.v4.media.RatingCompat r8 = (android.support.v4.media.RatingCompat) r8     // Catch:{ all -> 0x015f }
                    r0.onSetRating(r8)     // Catch:{ all -> 0x015f }
                    goto L_0x0159
                L_0x00d8:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x015f }
                    java.lang.Long r8 = (java.lang.Long) r8     // Catch:{ all -> 0x015f }
                    long r3 = r8.longValue()     // Catch:{ all -> 0x015f }
                    r0.onSeekTo(r3)     // Catch:{ all -> 0x015f }
                    goto L_0x0159
                L_0x00e5:
                    r0.onRewind()     // Catch:{ all -> 0x015f }
                    goto L_0x0159
                L_0x00ea:
                    r0.onFastForward()     // Catch:{ all -> 0x015f }
                    goto L_0x0159
                L_0x00ef:
                    r0.onSkipToPrevious()     // Catch:{ all -> 0x015f }
                    goto L_0x0159
                L_0x00f4:
                    r0.onSkipToNext()     // Catch:{ all -> 0x015f }
                    goto L_0x0159
                L_0x00f8:
                    r0.onStop()     // Catch:{ all -> 0x015f }
                    goto L_0x0159
                L_0x00fc:
                    r0.onPause()     // Catch:{ all -> 0x015f }
                    goto L_0x0159
                L_0x0100:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x015f }
                    java.lang.Long r8 = (java.lang.Long) r8     // Catch:{ all -> 0x015f }
                    long r3 = r8.longValue()     // Catch:{ all -> 0x015f }
                    r0.onSkipToQueueItem(r3)     // Catch:{ all -> 0x015f }
                    goto L_0x0159
                L_0x010c:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x015f }
                    android.net.Uri r8 = (android.net.Uri) r8     // Catch:{ all -> 0x015f }
                    r0.onPlayFromUri(r8, r1)     // Catch:{ all -> 0x015f }
                    goto L_0x0159
                L_0x0114:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x015f }
                    java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x015f }
                    r0.onPlayFromSearch(r8, r1)     // Catch:{ all -> 0x015f }
                    goto L_0x0159
                L_0x011c:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x015f }
                    java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x015f }
                    r0.onPlayFromMediaId(r8, r1)     // Catch:{ all -> 0x015f }
                    goto L_0x0159
                L_0x0124:
                    r0.onPlay()     // Catch:{ all -> 0x015f }
                    goto L_0x0159
                L_0x0128:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x015f }
                    android.net.Uri r8 = (android.net.Uri) r8     // Catch:{ all -> 0x015f }
                    r0.onPrepareFromUri(r8, r1)     // Catch:{ all -> 0x015f }
                    goto L_0x0159
                L_0x0130:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x015f }
                    java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x015f }
                    r0.onPrepareFromSearch(r8, r1)     // Catch:{ all -> 0x015f }
                    goto L_0x0159
                L_0x0138:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x015f }
                    java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x015f }
                    r0.onPrepareFromMediaId(r8, r1)     // Catch:{ all -> 0x015f }
                    goto L_0x0159
                L_0x0140:
                    r0.onPrepare()     // Catch:{ all -> 0x015f }
                    goto L_0x0159
                L_0x0144:
                    android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase r0 = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this     // Catch:{ all -> 0x015f }
                    int r8 = r8.arg1     // Catch:{ all -> 0x015f }
                    r0.adjustVolume(r8, r4)     // Catch:{ all -> 0x015f }
                    goto L_0x0159
                L_0x014c:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x015f }
                    android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$Command r8 = (android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.Command) r8     // Catch:{ all -> 0x015f }
                    java.lang.String r1 = r8.command     // Catch:{ all -> 0x015f }
                    android.os.Bundle r3 = r8.extras     // Catch:{ all -> 0x015f }
                    android.os.ResultReceiver r8 = r8.stub     // Catch:{ all -> 0x015f }
                    r0.onCommand(r1, r3, r8)     // Catch:{ all -> 0x015f }
                L_0x0159:
                    android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase r8 = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this
                    r8.setCurrentControllerInfo(r2)
                    return
                L_0x015f:
                    r8 = move-exception
                    android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase r0 = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this
                    r0.setCurrentControllerInfo(r2)
                    throw r8
                */
                throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.MessageHandler.handleMessage(android.os.Message):void");
            }
        }

        public MediaSessionImplBase(Context context, String str, ComponentName componentName, PendingIntent pendingIntent) {
            if (componentName != null) {
                this.mContext = context;
                this.mPackageName = context.getPackageName();
                this.mAudioManager = (AudioManager) context.getSystemService("audio");
                this.mTag = str;
                this.mMediaButtonReceiverComponentName = componentName;
                this.mMediaButtonReceiverIntent = pendingIntent;
                MediaSessionStub mediaSessionStub = new MediaSessionStub();
                this.mStub = mediaSessionStub;
                this.mToken = new Token(mediaSessionStub);
                this.mRatingType = 0;
                this.mVolumeType = 1;
                this.mLocalStream = 3;
                this.mRcc = new RemoteControlClient(pendingIntent);
                return;
            }
            throw new IllegalArgumentException("MediaButtonReceiver component may not be null.");
        }

        private void sendCaptioningEnabled(boolean z10) {
            for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onCaptioningEnabledChanged(z10);
                } catch (RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendEvent(String str, Bundle bundle) {
            for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onEvent(str, bundle);
                } catch (RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendExtras(Bundle bundle) {
            for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onExtrasChanged(bundle);
                } catch (RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendMetadata(MediaMetadataCompat mediaMetadataCompat) {
            for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onMetadataChanged(mediaMetadataCompat);
                } catch (RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendQueue(List<QueueItem> list) {
            for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onQueueChanged(list);
                } catch (RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendQueueTitle(CharSequence charSequence) {
            for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onQueueTitleChanged(charSequence);
                } catch (RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendRepeatMode(int i10) {
            for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onRepeatModeChanged(i10);
                } catch (RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendSessionDestroyed() {
            for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onSessionDestroyed();
                } catch (RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
            this.mControllerCallbacks.kill();
        }

        private void sendShuffleMode(int i10) {
            for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onShuffleModeChanged(i10);
                } catch (RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendState(PlaybackStateCompat playbackStateCompat) {
            for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onPlaybackStateChanged(playbackStateCompat);
                } catch (RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        /* access modifiers changed from: package-private */
        public void adjustVolume(int i10, int i11) {
            if (this.mVolumeType != 2) {
                this.mAudioManager.adjustStreamVolume(this.mLocalStream, i10, i11);
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0037, code lost:
            if (r2 != null) goto L_0x001d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x001b, code lost:
            if (r2 != null) goto L_0x001d;
         */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0042  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0051  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0062  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0072  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0082  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0093  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x00a3  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00b3  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00c4  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x00d5  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x00e5  */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x00f5  */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x0104  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.media.RemoteControlClient.MetadataEditor buildRccMetadata(android.os.Bundle r7) {
            /*
                r6 = this;
                android.media.RemoteControlClient r0 = r6.mRcc
                r1 = 1
                android.media.RemoteControlClient$MetadataEditor r0 = r0.editMetadata(r1)
                if (r7 != 0) goto L_0x000a
                return r0
            L_0x000a:
                java.lang.String r2 = "android.media.metadata.ART"
                boolean r3 = r7.containsKey(r2)
                r4 = 100
                r5 = 0
                if (r3 == 0) goto L_0x0029
                android.os.Parcelable r2 = r7.getParcelable(r2)
                android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2
                if (r2 == 0) goto L_0x0025
            L_0x001d:
                android.graphics.Bitmap$Config r3 = r2.getConfig()
                android.graphics.Bitmap r2 = r2.copy(r3, r5)
            L_0x0025:
                r0.putBitmap(r4, r2)
                goto L_0x003a
            L_0x0029:
                java.lang.String r2 = "android.media.metadata.ALBUM_ART"
                boolean r3 = r7.containsKey(r2)
                if (r3 == 0) goto L_0x003a
                android.os.Parcelable r2 = r7.getParcelable(r2)
                android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2
                if (r2 == 0) goto L_0x0025
                goto L_0x001d
            L_0x003a:
                java.lang.String r2 = "android.media.metadata.ALBUM"
                boolean r3 = r7.containsKey(r2)
                if (r3 == 0) goto L_0x0049
                java.lang.String r2 = r7.getString(r2)
                r0.putString(r1, r2)
            L_0x0049:
                java.lang.String r1 = "android.media.metadata.ALBUM_ARTIST"
                boolean r2 = r7.containsKey(r1)
                if (r2 == 0) goto L_0x005a
                r2 = 13
                java.lang.String r1 = r7.getString(r1)
                r0.putString(r2, r1)
            L_0x005a:
                java.lang.String r1 = "android.media.metadata.ARTIST"
                boolean r2 = r7.containsKey(r1)
                if (r2 == 0) goto L_0x006a
                r2 = 2
                java.lang.String r1 = r7.getString(r1)
                r0.putString(r2, r1)
            L_0x006a:
                java.lang.String r1 = "android.media.metadata.AUTHOR"
                boolean r2 = r7.containsKey(r1)
                if (r2 == 0) goto L_0x007a
                r2 = 3
                java.lang.String r1 = r7.getString(r1)
                r0.putString(r2, r1)
            L_0x007a:
                java.lang.String r1 = "android.media.metadata.COMPILATION"
                boolean r2 = r7.containsKey(r1)
                if (r2 == 0) goto L_0x008b
                r2 = 15
                java.lang.String r1 = r7.getString(r1)
                r0.putString(r2, r1)
            L_0x008b:
                java.lang.String r1 = "android.media.metadata.COMPOSER"
                boolean r2 = r7.containsKey(r1)
                if (r2 == 0) goto L_0x009b
                r2 = 4
                java.lang.String r1 = r7.getString(r1)
                r0.putString(r2, r1)
            L_0x009b:
                java.lang.String r1 = "android.media.metadata.DATE"
                boolean r2 = r7.containsKey(r1)
                if (r2 == 0) goto L_0x00ab
                r2 = 5
                java.lang.String r1 = r7.getString(r1)
                r0.putString(r2, r1)
            L_0x00ab:
                java.lang.String r1 = "android.media.metadata.DISC_NUMBER"
                boolean r2 = r7.containsKey(r1)
                if (r2 == 0) goto L_0x00bc
                r2 = 14
                long r3 = r7.getLong(r1)
                r0.putLong(r2, r3)
            L_0x00bc:
                java.lang.String r1 = "android.media.metadata.DURATION"
                boolean r2 = r7.containsKey(r1)
                if (r2 == 0) goto L_0x00cd
                r2 = 9
                long r3 = r7.getLong(r1)
                r0.putLong(r2, r3)
            L_0x00cd:
                java.lang.String r1 = "android.media.metadata.GENRE"
                boolean r2 = r7.containsKey(r1)
                if (r2 == 0) goto L_0x00dd
                r2 = 6
                java.lang.String r1 = r7.getString(r1)
                r0.putString(r2, r1)
            L_0x00dd:
                java.lang.String r1 = "android.media.metadata.TITLE"
                boolean r2 = r7.containsKey(r1)
                if (r2 == 0) goto L_0x00ed
                r2 = 7
                java.lang.String r1 = r7.getString(r1)
                r0.putString(r2, r1)
            L_0x00ed:
                java.lang.String r1 = "android.media.metadata.TRACK_NUMBER"
                boolean r2 = r7.containsKey(r1)
                if (r2 == 0) goto L_0x00fc
                long r1 = r7.getLong(r1)
                r0.putLong(r5, r1)
            L_0x00fc:
                java.lang.String r1 = "android.media.metadata.WRITER"
                boolean r2 = r7.containsKey(r1)
                if (r2 == 0) goto L_0x010d
                r2 = 11
                java.lang.String r7 = r7.getString(r1)
                r0.putString(r2, r7)
            L_0x010d:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.buildRccMetadata(android.os.Bundle):android.media.RemoteControlClient$MetadataEditor");
        }

        public String getCallingPackage() {
            return null;
        }

        public b getCurrentControllerInfo() {
            b bVar;
            synchronized (this.mLock) {
                bVar = this.mRemoteUserInfo;
            }
            return bVar;
        }

        public Object getMediaSession() {
            return null;
        }

        public PlaybackStateCompat getPlaybackState() {
            PlaybackStateCompat playbackStateCompat;
            synchronized (this.mLock) {
                playbackStateCompat = this.mState;
            }
            return playbackStateCompat;
        }

        /* access modifiers changed from: package-private */
        public int getRccStateFromState(int i10) {
            switch (i10) {
                case 0:
                    return 0;
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                case 8:
                    return 8;
                case 7:
                    return 9;
                case 9:
                    return 7;
                case 10:
                case 11:
                    return 6;
                default:
                    return -1;
            }
        }

        /* access modifiers changed from: package-private */
        public int getRccTransportControlFlagsFromActions(long j10) {
            int i10 = (1 & j10) != 0 ? 32 : 0;
            if ((2 & j10) != 0) {
                i10 |= 16;
            }
            if ((4 & j10) != 0) {
                i10 |= 4;
            }
            if ((8 & j10) != 0) {
                i10 |= 2;
            }
            if ((16 & j10) != 0) {
                i10 |= 1;
            }
            if ((32 & j10) != 0) {
                i10 |= 128;
            }
            if ((64 & j10) != 0) {
                i10 |= 64;
            }
            return (j10 & 512) != 0 ? i10 | 8 : i10;
        }

        public Object getRemoteControlClient() {
            return null;
        }

        public Token getSessionToken() {
            return this.mToken;
        }

        public boolean isActive() {
            return this.mIsActive;
        }

        /* access modifiers changed from: package-private */
        public void postToHandler(int i10, int i11, int i12, Object obj, Bundle bundle) {
            synchronized (this.mLock) {
                MessageHandler messageHandler = this.mHandler;
                if (messageHandler != null) {
                    Message obtainMessage = messageHandler.obtainMessage(i10, i11, i12, obj);
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(MediaSessionCompat.DATA_CALLING_PACKAGE, "android.media.session.MediaController");
                    bundle2.putInt(MediaSessionCompat.DATA_CALLING_PID, Binder.getCallingPid());
                    bundle2.putInt(MediaSessionCompat.DATA_CALLING_UID, Binder.getCallingUid());
                    if (bundle != null) {
                        bundle2.putBundle(MediaSessionCompat.DATA_EXTRAS, bundle);
                    }
                    obtainMessage.setData(bundle2);
                    obtainMessage.sendToTarget();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void registerMediaButtonEventReceiver(PendingIntent pendingIntent, ComponentName componentName) {
            this.mAudioManager.registerMediaButtonEventReceiver(componentName);
        }

        public void release() {
            this.mIsActive = false;
            this.mDestroyed = true;
            update();
            sendSessionDestroyed();
        }

        public void sendSessionEvent(String str, Bundle bundle) {
            sendEvent(str, bundle);
        }

        /* access modifiers changed from: package-private */
        public void sendVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) {
            for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onVolumeInfoChanged(parcelableVolumeInfo);
                } catch (RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        public void setActive(boolean z10) {
            if (z10 != this.mIsActive) {
                this.mIsActive = z10;
                if (update()) {
                    setMetadata(this.mMetadata);
                    setPlaybackState(this.mState);
                }
            }
        }

        public void setCallback(Callback callback, Handler handler) {
            this.mCallback = callback;
            if (callback != null) {
                if (handler == null) {
                    handler = new Handler();
                }
                synchronized (this.mLock) {
                    MessageHandler messageHandler = this.mHandler;
                    if (messageHandler != null) {
                        messageHandler.removeCallbacksAndMessages((Object) null);
                    }
                    this.mHandler = new MessageHandler(handler.getLooper());
                    this.mCallback.setSessionImpl(this, handler);
                }
            }
        }

        public void setCaptioningEnabled(boolean z10) {
            if (this.mCaptioningEnabled != z10) {
                this.mCaptioningEnabled = z10;
                sendCaptioningEnabled(z10);
            }
        }

        public void setCurrentControllerInfo(b bVar) {
            synchronized (this.mLock) {
                this.mRemoteUserInfo = bVar;
            }
        }

        public void setExtras(Bundle bundle) {
            this.mExtras = bundle;
            sendExtras(bundle);
        }

        public void setFlags(int i10) {
            synchronized (this.mLock) {
                this.mFlags = i10;
            }
            update();
        }

        public void setMediaButtonReceiver(PendingIntent pendingIntent) {
        }

        public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
            if (mediaMetadataCompat != null) {
                mediaMetadataCompat = new MediaMetadataCompat.Builder(mediaMetadataCompat, MediaSessionCompat.sMaxBitmapSize).build();
            }
            synchronized (this.mLock) {
                this.mMetadata = mediaMetadataCompat;
            }
            sendMetadata(mediaMetadataCompat);
            if (this.mIsActive) {
                buildRccMetadata(mediaMetadataCompat == null ? null : mediaMetadataCompat.getBundle()).apply();
            }
        }

        public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
            synchronized (this.mLock) {
                this.mState = playbackStateCompat;
            }
            sendState(playbackStateCompat);
            if (this.mIsActive) {
                if (playbackStateCompat == null) {
                    this.mRcc.setPlaybackState(0);
                    this.mRcc.setTransportControlFlags(0);
                    return;
                }
                setRccState(playbackStateCompat);
                this.mRcc.setTransportControlFlags(getRccTransportControlFlagsFromActions(playbackStateCompat.getActions()));
            }
        }

        public void setPlaybackToLocal(int i10) {
            this.mLocalStream = i10;
            this.mVolumeType = 1;
            int i11 = this.mVolumeType;
            int i12 = this.mLocalStream;
            sendVolumeInfoChanged(new ParcelableVolumeInfo(i11, i12, 2, this.mAudioManager.getStreamMaxVolume(i12), this.mAudioManager.getStreamVolume(this.mLocalStream)));
        }

        public void setPlaybackToRemote(f fVar) {
            throw new IllegalArgumentException("volumeProvider may not be null");
        }

        public void setQueue(List<QueueItem> list) {
            this.mQueue = list;
            sendQueue(list);
        }

        public void setQueueTitle(CharSequence charSequence) {
            this.mQueueTitle = charSequence;
            sendQueueTitle(charSequence);
        }

        public void setRatingType(int i10) {
            this.mRatingType = i10;
        }

        /* access modifiers changed from: package-private */
        public void setRccState(PlaybackStateCompat playbackStateCompat) {
            this.mRcc.setPlaybackState(getRccStateFromState(playbackStateCompat.getState()));
        }

        public void setRepeatMode(int i10) {
            if (this.mRepeatMode != i10) {
                this.mRepeatMode = i10;
                sendRepeatMode(i10);
            }
        }

        public void setSessionActivity(PendingIntent pendingIntent) {
            synchronized (this.mLock) {
                this.mSessionActivity = pendingIntent;
            }
        }

        public void setShuffleMode(int i10) {
            if (this.mShuffleMode != i10) {
                this.mShuffleMode = i10;
                sendShuffleMode(i10);
            }
        }

        /* access modifiers changed from: package-private */
        public void setVolumeTo(int i10, int i11) {
            if (this.mVolumeType != 2) {
                this.mAudioManager.setStreamVolume(this.mLocalStream, i10, i11);
            }
        }

        /* access modifiers changed from: package-private */
        public void unregisterMediaButtonEventReceiver(PendingIntent pendingIntent, ComponentName componentName) {
            this.mAudioManager.unregisterMediaButtonEventReceiver(componentName);
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0043, code lost:
            if ((r4.mFlags & 2) == 0) goto L_0x0057;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0055, code lost:
            if (r4.mIsRccRegistered != false) goto L_0x0057;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean update() {
            /*
                r4 = this;
                boolean r0 = r4.mIsActive
                r1 = 1
                r2 = 0
                if (r0 == 0) goto L_0x0046
                boolean r0 = r4.mIsMbrRegistered
                if (r0 != 0) goto L_0x0019
                int r3 = r4.mFlags
                r3 = r3 & r1
                if (r3 == 0) goto L_0x0019
                android.app.PendingIntent r0 = r4.mMediaButtonReceiverIntent
                android.content.ComponentName r3 = r4.mMediaButtonReceiverComponentName
                r4.registerMediaButtonEventReceiver(r0, r3)
                r4.mIsMbrRegistered = r1
                goto L_0x0029
            L_0x0019:
                if (r0 == 0) goto L_0x0029
                int r0 = r4.mFlags
                r0 = r0 & r1
                if (r0 != 0) goto L_0x0029
                android.app.PendingIntent r0 = r4.mMediaButtonReceiverIntent
                android.content.ComponentName r3 = r4.mMediaButtonReceiverComponentName
                r4.unregisterMediaButtonEventReceiver(r0, r3)
                r4.mIsMbrRegistered = r2
            L_0x0029:
                boolean r0 = r4.mIsRccRegistered
                if (r0 != 0) goto L_0x003d
                int r3 = r4.mFlags
                r3 = r3 & 2
                if (r3 == 0) goto L_0x003d
                android.media.AudioManager r0 = r4.mAudioManager
                android.media.RemoteControlClient r2 = r4.mRcc
                r0.registerRemoteControlClient(r2)
                r4.mIsRccRegistered = r1
                goto L_0x0066
            L_0x003d:
                if (r0 == 0) goto L_0x0065
                int r0 = r4.mFlags
                r0 = r0 & 2
                if (r0 != 0) goto L_0x0065
                goto L_0x0057
            L_0x0046:
                boolean r0 = r4.mIsMbrRegistered
                if (r0 == 0) goto L_0x0053
                android.app.PendingIntent r0 = r4.mMediaButtonReceiverIntent
                android.content.ComponentName r1 = r4.mMediaButtonReceiverComponentName
                r4.unregisterMediaButtonEventReceiver(r0, r1)
                r4.mIsMbrRegistered = r2
            L_0x0053:
                boolean r0 = r4.mIsRccRegistered
                if (r0 == 0) goto L_0x0065
            L_0x0057:
                android.media.RemoteControlClient r0 = r4.mRcc
                r0.setPlaybackState(r2)
                android.media.AudioManager r0 = r4.mAudioManager
                android.media.RemoteControlClient r1 = r4.mRcc
                r0.unregisterRemoteControlClient(r1)
                r4.mIsRccRegistered = r2
            L_0x0065:
                r1 = r2
            L_0x0066:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.update():boolean");
        }
    }

    public interface OnActiveChangeListener {
        void onActiveChanged();
    }

    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new Parcelable.Creator<QueueItem>() {
            public QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            public QueueItem[] newArray(int i10) {
                return new QueueItem[i10];
            }
        };
        public static final int UNKNOWN_ID = -1;
        private final MediaDescriptionCompat mDescription;
        private final long mId;
        private Object mItem;

        QueueItem(Parcel parcel) {
            this.mDescription = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.mId = parcel.readLong();
        }

        public QueueItem(MediaDescriptionCompat mediaDescriptionCompat, long j10) {
            this((Object) null, mediaDescriptionCompat, j10);
        }

        private QueueItem(Object obj, MediaDescriptionCompat mediaDescriptionCompat, long j10) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null.");
            } else if (j10 != -1) {
                this.mDescription = mediaDescriptionCompat;
                this.mId = j10;
                this.mItem = obj;
            } else {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }
        }

        public static QueueItem fromQueueItem(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            return new QueueItem(obj, MediaDescriptionCompat.fromMediaDescription(MediaSessionCompatApi21.QueueItem.getDescription(obj)), MediaSessionCompatApi21.QueueItem.getQueueId(obj));
        }

        public static List<QueueItem> fromQueueItemList(List<?> list) {
            if (list == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Object fromQueueItem : list) {
                arrayList.add(fromQueueItem(fromQueueItem));
            }
            return arrayList;
        }

        public int describeContents() {
            return 0;
        }

        public MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public long getQueueId() {
            return this.mId;
        }

        public Object getQueueItem() {
            Object obj = this.mItem;
            if (obj != null || Build.VERSION.SDK_INT < 21) {
                return obj;
            }
            Object createItem = MediaSessionCompatApi21.QueueItem.createItem(this.mDescription.getMediaDescription(), this.mId);
            this.mItem = createItem;
            return createItem;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.mDescription + ", Id=" + this.mId + " }";
        }

        public void writeToParcel(Parcel parcel, int i10) {
            this.mDescription.writeToParcel(parcel, i10);
            parcel.writeLong(this.mId);
        }
    }

    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new Parcelable.Creator<ResultReceiverWrapper>() {
            public ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            public ResultReceiverWrapper[] newArray(int i10) {
                return new ResultReceiverWrapper[i10];
            }
        };
        ResultReceiver mResultReceiver;

        ResultReceiverWrapper(Parcel parcel) {
            this.mResultReceiver = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        public ResultReceiverWrapper(ResultReceiver resultReceiver) {
            this.mResultReceiver = resultReceiver;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            this.mResultReceiver.writeToParcel(parcel, i10);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SessionFlags {
    }

    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new Parcelable.Creator<Token>() {
            public Token createFromParcel(Parcel parcel) {
                return new Token(Build.VERSION.SDK_INT >= 21 ? parcel.readParcelable((ClassLoader) null) : parcel.readStrongBinder());
            }

            public Token[] newArray(int i10) {
                return new Token[i10];
            }
        };
        private IMediaSession mExtraBinder;
        private final Object mInner;
        private Bundle mSessionToken2Bundle;

        Token(Object obj) {
            this(obj, (IMediaSession) null, (Bundle) null);
        }

        Token(Object obj, IMediaSession iMediaSession) {
            this(obj, iMediaSession, (Bundle) null);
        }

        Token(Object obj, IMediaSession iMediaSession, Bundle bundle) {
            this.mInner = obj;
            this.mExtraBinder = iMediaSession;
            this.mSessionToken2Bundle = bundle;
        }

        public static Token fromBundle(Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            IMediaSession asInterface = IMediaSession.Stub.asInterface(e.a(bundle, MediaSessionCompat.KEY_EXTRA_BINDER));
            Bundle bundle2 = bundle.getBundle(MediaSessionCompat.KEY_SESSION_TOKEN2_BUNDLE);
            Token token = (Token) bundle.getParcelable(MediaSessionCompat.KEY_TOKEN);
            if (token == null) {
                return null;
            }
            return new Token(token.mInner, asInterface, bundle2);
        }

        public static Token fromToken(Object obj) {
            return fromToken(obj, (IMediaSession) null);
        }

        public static Token fromToken(Object obj, IMediaSession iMediaSession) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            return new Token(MediaSessionCompatApi21.verifyToken(obj), iMediaSession);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Object obj2 = this.mInner;
            Object obj3 = ((Token) obj).mInner;
            if (obj2 == null) {
                return obj3 == null;
            }
            if (obj3 == null) {
                return false;
            }
            return obj2.equals(obj3);
        }

        public IMediaSession getExtraBinder() {
            return this.mExtraBinder;
        }

        public Bundle getSessionToken2Bundle() {
            return this.mSessionToken2Bundle;
        }

        public Object getToken() {
            return this.mInner;
        }

        public int hashCode() {
            Object obj = this.mInner;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        public void setExtraBinder(IMediaSession iMediaSession) {
            this.mExtraBinder = iMediaSession;
        }

        public void setSessionToken2Bundle(Bundle bundle) {
            this.mSessionToken2Bundle = bundle;
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putParcelable(MediaSessionCompat.KEY_TOKEN, this);
            IMediaSession iMediaSession = this.mExtraBinder;
            if (iMediaSession != null) {
                e.b(bundle, MediaSessionCompat.KEY_EXTRA_BINDER, iMediaSession.asBinder());
            }
            Bundle bundle2 = this.mSessionToken2Bundle;
            if (bundle2 != null) {
                bundle.putBundle(MediaSessionCompat.KEY_SESSION_TOKEN2_BUNDLE, bundle2);
            }
            return bundle;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            if (Build.VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((Parcelable) this.mInner, i10);
            } else {
                parcel.writeStrongBinder((IBinder) this.mInner);
            }
        }
    }

    private MediaSessionCompat(Context context, MediaSessionImpl mediaSessionImpl) {
        this.mActiveListeners = new ArrayList<>();
        this.mImpl = mediaSessionImpl;
        if (Build.VERSION.SDK_INT >= 21 && !MediaSessionCompatApi21.hasCallback(mediaSessionImpl.getMediaSession())) {
            setCallback(new Callback() {
            });
        }
        this.mController = new MediaControllerCompat(context, this);
    }

    public MediaSessionCompat(Context context, String str) {
        this(context, str, (ComponentName) null, (PendingIntent) null);
    }

    public MediaSessionCompat(Context context, String str, ComponentName componentName, PendingIntent pendingIntent) {
        this(context, str, componentName, pendingIntent, (Bundle) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private MediaSessionCompat(android.content.Context r3, java.lang.String r4, android.content.ComponentName r5, android.app.PendingIntent r6, android.os.Bundle r7) {
        /*
            r2 = this;
            r2.<init>()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r2.mActiveListeners = r0
            if (r3 == 0) goto L_0x00a3
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 != 0) goto L_0x009b
            if (r5 != 0) goto L_0x0021
            android.content.ComponentName r5 = m1.a.a(r3)
            if (r5 != 0) goto L_0x0021
            java.lang.String r0 = "MediaSessionCompat"
            java.lang.String r1 = "Couldn't find a unique registered media button receiver in the given context."
            android.util.Log.w(r0, r1)
        L_0x0021:
            if (r5 == 0) goto L_0x0034
            if (r6 != 0) goto L_0x0034
            android.content.Intent r6 = new android.content.Intent
            java.lang.String r0 = "android.intent.action.MEDIA_BUTTON"
            r6.<init>(r0)
            r6.setComponent(r5)
            r0 = 0
            android.app.PendingIntent r6 = android.app.PendingIntent.getBroadcast(r3, r0, r6, r0)
        L_0x0034:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 < r1) goto L_0x004d
            android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi28 r5 = new android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi28
            r5.<init>(r3, r4, r7)
            r2.mImpl = r5
            android.support.v4.media.session.MediaSessionCompat$1 r4 = new android.support.v4.media.session.MediaSessionCompat$1
            r4.<init>()
        L_0x0046:
            r2.setCallback(r4)
            r5.setMediaButtonReceiver(r6)
            goto L_0x007a
        L_0x004d:
            r1 = 21
            if (r0 < r1) goto L_0x005e
            android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi21 r5 = new android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi21
            r5.<init>(r3, r4, r7)
            r2.mImpl = r5
            android.support.v4.media.session.MediaSessionCompat$2 r4 = new android.support.v4.media.session.MediaSessionCompat$2
            r4.<init>()
            goto L_0x0046
        L_0x005e:
            r7 = 19
            if (r0 < r7) goto L_0x006a
            android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi19 r7 = new android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi19
            r7.<init>(r3, r4, r5, r6)
        L_0x0067:
            r2.mImpl = r7
            goto L_0x007a
        L_0x006a:
            r7 = 18
            if (r0 < r7) goto L_0x0074
            android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi18 r7 = new android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi18
            r7.<init>(r3, r4, r5, r6)
            goto L_0x0067
        L_0x0074:
            android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase r7 = new android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase
            r7.<init>(r3, r4, r5, r6)
            goto L_0x0067
        L_0x007a:
            android.support.v4.media.session.MediaControllerCompat r4 = new android.support.v4.media.session.MediaControllerCompat
            r4.<init>((android.content.Context) r3, (android.support.v4.media.session.MediaSessionCompat) r2)
            r2.mController = r4
            int r4 = sMaxBitmapSize
            if (r4 != 0) goto L_0x009a
            r4 = 1
            r5 = 1134559232(0x43a00000, float:320.0)
            android.content.res.Resources r3 = r3.getResources()
            android.util.DisplayMetrics r3 = r3.getDisplayMetrics()
            float r3 = android.util.TypedValue.applyDimension(r4, r5, r3)
            r4 = 1056964608(0x3f000000, float:0.5)
            float r3 = r3 + r4
            int r3 = (int) r3
            sMaxBitmapSize = r3
        L_0x009a:
            return
        L_0x009b:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "tag must not be null or empty"
            r3.<init>(r4)
            throw r3
        L_0x00a3:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "context must not be null"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.<init>(android.content.Context, java.lang.String, android.content.ComponentName, android.app.PendingIntent, android.os.Bundle):void");
    }

    public MediaSessionCompat(Context context, String str, Bundle bundle) {
        this(context, str, (ComponentName) null, (PendingIntent) null, bundle);
    }

    public static void ensureClassLoader(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    public static MediaSessionCompat fromMediaSession(Context context, Object obj) {
        if (context == null || obj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        return new MediaSessionCompat(context, (MediaSessionImpl) new MediaSessionImplApi21(obj));
    }

    static PlaybackStateCompat getStateWithUpdatedPosition(PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat) {
        if (playbackStateCompat == null) {
            return playbackStateCompat;
        }
        long j10 = -1;
        if (playbackStateCompat.getPosition() == -1) {
            return playbackStateCompat;
        }
        if (playbackStateCompat.getState() != 3 && playbackStateCompat.getState() != 4 && playbackStateCompat.getState() != 5) {
            return playbackStateCompat;
        }
        long lastPositionUpdateTime = playbackStateCompat.getLastPositionUpdateTime();
        if (lastPositionUpdateTime <= 0) {
            return playbackStateCompat;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long playbackSpeed = ((long) (playbackStateCompat.getPlaybackSpeed() * ((float) (elapsedRealtime - lastPositionUpdateTime)))) + playbackStateCompat.getPosition();
        if (mediaMetadataCompat != null && mediaMetadataCompat.containsKey(MediaMetadataCompat.METADATA_KEY_DURATION)) {
            j10 = mediaMetadataCompat.getLong(MediaMetadataCompat.METADATA_KEY_DURATION);
        }
        return new PlaybackStateCompat.Builder(playbackStateCompat).setState(playbackStateCompat.getState(), (j10 < 0 || playbackSpeed <= j10) ? playbackSpeed < 0 ? 0 : playbackSpeed : j10, playbackStateCompat.getPlaybackSpeed(), elapsedRealtime).build();
    }

    public void addOnActiveChangeListener(OnActiveChangeListener onActiveChangeListener) {
        if (onActiveChangeListener != null) {
            this.mActiveListeners.add(onActiveChangeListener);
            return;
        }
        throw new IllegalArgumentException("Listener may not be null");
    }

    public String getCallingPackage() {
        return this.mImpl.getCallingPackage();
    }

    public MediaControllerCompat getController() {
        return this.mController;
    }

    public final b getCurrentControllerInfo() {
        return this.mImpl.getCurrentControllerInfo();
    }

    public Object getMediaSession() {
        return this.mImpl.getMediaSession();
    }

    public Object getRemoteControlClient() {
        return this.mImpl.getRemoteControlClient();
    }

    public Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    public boolean isActive() {
        return this.mImpl.isActive();
    }

    public void release() {
        this.mImpl.release();
    }

    public void removeOnActiveChangeListener(OnActiveChangeListener onActiveChangeListener) {
        if (onActiveChangeListener != null) {
            this.mActiveListeners.remove(onActiveChangeListener);
            return;
        }
        throw new IllegalArgumentException("Listener may not be null");
    }

    public void sendSessionEvent(String str, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            this.mImpl.sendSessionEvent(str, bundle);
            return;
        }
        throw new IllegalArgumentException("event cannot be null or empty");
    }

    public void setActive(boolean z10) {
        this.mImpl.setActive(z10);
        Iterator<OnActiveChangeListener> it = this.mActiveListeners.iterator();
        while (it.hasNext()) {
            it.next().onActiveChanged();
        }
    }

    public void setCallback(Callback callback) {
        setCallback(callback, (Handler) null);
    }

    public void setCallback(Callback callback, Handler handler) {
        if (callback == null) {
            this.mImpl.setCallback((Callback) null, (Handler) null);
            return;
        }
        MediaSessionImpl mediaSessionImpl = this.mImpl;
        if (handler == null) {
            handler = new Handler();
        }
        mediaSessionImpl.setCallback(callback, handler);
    }

    public void setCaptioningEnabled(boolean z10) {
        this.mImpl.setCaptioningEnabled(z10);
    }

    public void setExtras(Bundle bundle) {
        this.mImpl.setExtras(bundle);
    }

    public void setFlags(int i10) {
        this.mImpl.setFlags(i10);
    }

    public void setMediaButtonReceiver(PendingIntent pendingIntent) {
        this.mImpl.setMediaButtonReceiver(pendingIntent);
    }

    public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
        this.mImpl.setMetadata(mediaMetadataCompat);
    }

    public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
        this.mImpl.setPlaybackState(playbackStateCompat);
    }

    public void setPlaybackToLocal(int i10) {
        this.mImpl.setPlaybackToLocal(i10);
    }

    public void setPlaybackToRemote(f fVar) {
        throw new IllegalArgumentException("volumeProvider may not be null!");
    }

    public void setQueue(List<QueueItem> list) {
        this.mImpl.setQueue(list);
    }

    public void setQueueTitle(CharSequence charSequence) {
        this.mImpl.setQueueTitle(charSequence);
    }

    public void setRatingType(int i10) {
        this.mImpl.setRatingType(i10);
    }

    public void setRepeatMode(int i10) {
        this.mImpl.setRepeatMode(i10);
    }

    public void setSessionActivity(PendingIntent pendingIntent) {
        this.mImpl.setSessionActivity(pendingIntent);
    }

    public void setShuffleMode(int i10) {
        this.mImpl.setShuffleMode(i10);
    }
}
