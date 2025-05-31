package androidx.media;

import androidx.versionedparcelable.a;

public final class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(a aVar) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.f3077a = (AudioAttributesImpl) aVar.v(audioAttributesCompat.f3077a, 1);
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, a aVar) {
        aVar.x(false, false);
        aVar.M(audioAttributesCompat.f3077a, 1);
    }
}
