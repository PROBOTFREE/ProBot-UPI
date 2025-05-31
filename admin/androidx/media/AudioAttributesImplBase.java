package androidx.media;

import java.util.Arrays;

class AudioAttributesImplBase implements AudioAttributesImpl {

    /* renamed from: a  reason: collision with root package name */
    int f3080a = 0;

    /* renamed from: b  reason: collision with root package name */
    int f3081b = 0;

    /* renamed from: c  reason: collision with root package name */
    int f3082c = 0;

    /* renamed from: d  reason: collision with root package name */
    int f3083d = -1;

    AudioAttributesImplBase() {
    }

    public int a() {
        return this.f3081b;
    }

    public int b() {
        int i10 = this.f3082c;
        int c10 = c();
        if (c10 == 6) {
            i10 |= 4;
        } else if (c10 == 7) {
            i10 |= 1;
        }
        return i10 & 273;
    }

    public int c() {
        int i10 = this.f3083d;
        return i10 != -1 ? i10 : AudioAttributesCompat.a(false, this.f3082c, this.f3080a);
    }

    public int d() {
        return this.f3080a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        return this.f3081b == audioAttributesImplBase.a() && this.f3082c == audioAttributesImplBase.b() && this.f3080a == audioAttributesImplBase.d() && this.f3083d == audioAttributesImplBase.f3083d;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f3081b), Integer.valueOf(this.f3082c), Integer.valueOf(this.f3080a), Integer.valueOf(this.f3083d)});
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("AudioAttributesCompat:");
        if (this.f3083d != -1) {
            sb2.append(" stream=");
            sb2.append(this.f3083d);
            sb2.append(" derived");
        }
        sb2.append(" usage=");
        sb2.append(AudioAttributesCompat.b(this.f3080a));
        sb2.append(" content=");
        sb2.append(this.f3081b);
        sb2.append(" flags=0x");
        sb2.append(Integer.toHexString(this.f3082c).toUpperCase());
        return sb2.toString();
    }
}
