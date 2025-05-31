package androidx.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;

@TargetApi(21)
class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* renamed from: a  reason: collision with root package name */
    AudioAttributes f3078a;

    /* renamed from: b  reason: collision with root package name */
    int f3079b = -1;

    AudioAttributesImplApi21() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplApi21)) {
            return false;
        }
        return this.f3078a.equals(((AudioAttributesImplApi21) obj).f3078a);
    }

    public int hashCode() {
        return this.f3078a.hashCode();
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f3078a;
    }
}
