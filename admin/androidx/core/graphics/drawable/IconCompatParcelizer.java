package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.versionedparcelable.a;

public class IconCompatParcelizer {
    public static IconCompat read(a aVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f2280a = aVar.p(iconCompat.f2280a, 1);
        iconCompat.f2282c = aVar.j(iconCompat.f2282c, 2);
        iconCompat.f2283d = aVar.r(iconCompat.f2283d, 3);
        iconCompat.f2284e = aVar.p(iconCompat.f2284e, 4);
        iconCompat.f2285f = aVar.p(iconCompat.f2285f, 5);
        iconCompat.f2286g = (ColorStateList) aVar.r(iconCompat.f2286g, 6);
        iconCompat.f2288i = aVar.t(iconCompat.f2288i, 7);
        iconCompat.f2289j = aVar.t(iconCompat.f2289j, 8);
        iconCompat.n();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, a aVar) {
        aVar.x(true, true);
        iconCompat.o(aVar.f());
        int i10 = iconCompat.f2280a;
        if (-1 != i10) {
            aVar.F(i10, 1);
        }
        byte[] bArr = iconCompat.f2282c;
        if (bArr != null) {
            aVar.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f2283d;
        if (parcelable != null) {
            aVar.H(parcelable, 3);
        }
        int i11 = iconCompat.f2284e;
        if (i11 != 0) {
            aVar.F(i11, 4);
        }
        int i12 = iconCompat.f2285f;
        if (i12 != 0) {
            aVar.F(i12, 5);
        }
        ColorStateList colorStateList = iconCompat.f2286g;
        if (colorStateList != null) {
            aVar.H(colorStateList, 6);
        }
        String str = iconCompat.f2288i;
        if (str != null) {
            aVar.J(str, 7);
        }
        String str2 = iconCompat.f2289j;
        if (str2 != null) {
            aVar.J(str2, 8);
        }
    }
}
