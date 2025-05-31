package a6;

import c5.g;

public final class r {
    public static int a(int i10) {
        boolean z10;
        if (!(i10 == 0 || i10 == 1)) {
            if (i10 == 2) {
                i10 = 2;
            } else {
                z10 = false;
                g.c(z10, "granularity %d must be a Granularity.GRANULARITY_* constant", Integer.valueOf(i10));
                return i10;
            }
        }
        z10 = true;
        g.c(z10, "granularity %d must be a Granularity.GRANULARITY_* constant", Integer.valueOf(i10));
        return i10;
    }

    public static String b(int i10) {
        if (i10 == 0) {
            return "GRANULARITY_PERMISSION_LEVEL";
        }
        if (i10 == 1) {
            return "GRANULARITY_COARSE";
        }
        if (i10 == 2) {
            return "GRANULARITY_FINE";
        }
        throw new IllegalArgumentException();
    }
}
