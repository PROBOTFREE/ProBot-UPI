package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class c0 {
    private final Map<String, Object> mBagOfTags = new HashMap();
    private volatile boolean mCleared = false;

    private static void closeWithRuntimeException(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void clear() {
        this.mCleared = true;
        Map<String, Object> map = this.mBagOfTags;
        if (map != null) {
            synchronized (map) {
                for (Object closeWithRuntimeException : this.mBagOfTags.values()) {
                    closeWithRuntimeException(closeWithRuntimeException);
                }
            }
        }
        onCleared();
    }

    /* access modifiers changed from: package-private */
    public <T> T getTag(String str) {
        T t10;
        Map<String, Object> map = this.mBagOfTags;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            t10 = this.mBagOfTags.get(str);
        }
        return t10;
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
    }

    /* access modifiers changed from: package-private */
    public <T> T setTagIfAbsent(String str, T t10) {
        T t11;
        synchronized (this.mBagOfTags) {
            t11 = this.mBagOfTags.get(str);
            if (t11 == null) {
                this.mBagOfTags.put(str, t10);
            }
        }
        if (t11 != null) {
            t10 = t11;
        }
        if (this.mCleared) {
            closeWithRuntimeException(t10);
        }
        return t10;
    }
}
