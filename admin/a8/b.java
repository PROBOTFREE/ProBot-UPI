package a8;

import z7.o;

public final class b implements o {
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005e A[LOOP:0: B:29:0x005c->B:30:0x005e, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public z7.q a(z7.c r11, java.util.Map<z7.e, ?> r12) {
        /*
            r10 = this;
            c8.a r0 = new c8.a
            e8.b r11 = r11.a()
            r0.<init>(r11)
            r11 = 0
            r1 = 0
            a8.a r2 = r0.a(r11)     // Catch:{ m -> 0x002b, h -> 0x0025 }
            z7.s[] r3 = r2.b()     // Catch:{ m -> 0x002b, h -> 0x0025 }
            b8.a r4 = new b8.a     // Catch:{ m -> 0x0023, h -> 0x0021 }
            r4.<init>()     // Catch:{ m -> 0x0023, h -> 0x0021 }
            e8.e r2 = r4.c(r2)     // Catch:{ m -> 0x0023, h -> 0x0021 }
            r4 = r3
            r3 = r1
            r1 = r2
            r2 = r3
            goto L_0x002f
        L_0x0021:
            r2 = move-exception
            goto L_0x0027
        L_0x0023:
            r2 = move-exception
            goto L_0x002d
        L_0x0025:
            r2 = move-exception
            r3 = r1
        L_0x0027:
            r4 = r3
            r3 = r2
            r2 = r1
            goto L_0x002f
        L_0x002b:
            r2 = move-exception
            r3 = r1
        L_0x002d:
            r4 = r3
            r3 = r1
        L_0x002f:
            if (r1 != 0) goto L_0x004e
            r1 = 1
            a8.a r0 = r0.a(r1)     // Catch:{ m -> 0x0046, h -> 0x0044 }
            z7.s[] r4 = r0.b()     // Catch:{ m -> 0x0046, h -> 0x0044 }
            b8.a r1 = new b8.a     // Catch:{ m -> 0x0046, h -> 0x0044 }
            r1.<init>()     // Catch:{ m -> 0x0046, h -> 0x0044 }
            e8.e r1 = r1.c(r0)     // Catch:{ m -> 0x0046, h -> 0x0044 }
            goto L_0x004e
        L_0x0044:
            r11 = move-exception
            goto L_0x0047
        L_0x0046:
            r11 = move-exception
        L_0x0047:
            if (r2 != 0) goto L_0x004d
            if (r3 == 0) goto L_0x004c
            throw r3
        L_0x004c:
            throw r11
        L_0x004d:
            throw r2
        L_0x004e:
            r6 = r4
            if (r12 == 0) goto L_0x0066
            z7.e r0 = z7.e.NEED_RESULT_POINT_CALLBACK
            java.lang.Object r12 = r12.get(r0)
            z7.t r12 = (z7.t) r12
            if (r12 == 0) goto L_0x0066
            int r0 = r6.length
        L_0x005c:
            if (r11 >= r0) goto L_0x0066
            r2 = r6[r11]
            r12.a(r2)
            int r11 = r11 + 1
            goto L_0x005c
        L_0x0066:
            z7.q r11 = new z7.q
            java.lang.String r3 = r1.h()
            byte[] r4 = r1.e()
            int r5 = r1.c()
            z7.a r7 = z7.a.AZTEC
            long r8 = java.lang.System.currentTimeMillis()
            r2 = r11
            r2.<init>(r3, r4, r5, r6, r7, r8)
            java.util.List r12 = r1.a()
            if (r12 == 0) goto L_0x0089
            z7.r r0 = z7.r.BYTE_SEGMENTS
            r11.h(r0, r12)
        L_0x0089:
            java.lang.String r12 = r1.b()
            if (r12 == 0) goto L_0x0094
            z7.r r0 = z7.r.ERROR_CORRECTION_LEVEL
            r11.h(r0, r12)
        L_0x0094:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: a8.b.a(z7.c, java.util.Map):z7.q");
    }

    public void b() {
    }
}
