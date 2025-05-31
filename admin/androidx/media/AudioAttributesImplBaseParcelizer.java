package androidx.media;

import androidx.versionedparcelable.a;

public final class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(a aVar) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f3080a = aVar.p(audioAttributesImplBase.f3080a, 1);
        audioAttributesImplBase.f3081b = aVar.p(audioAttributesImplBase.f3081b, 2);
        audioAttributesImplBase.f3082c = aVar.p(audioAttributesImplBase.f3082c, 3);
        audioAttributesImplBase.f3083d = aVar.p(audioAttributesImplBase.f3083d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, a aVar) {
        aVar.x(false, false);
        aVar.F(audioAttributesImplBase.f3080a, 1);
        aVar.F(audioAttributesImplBase.f3081b, 2);
        aVar.F(audioAttributesImplBase.f3082c, 3);
        aVar.F(audioAttributesImplBase.f3083d, 4);
    }
}
