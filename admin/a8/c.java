package a8;

import e8.b;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import z7.a;
import z7.g;
import z7.u;

public final class c implements u {
    private static b b(String str, a aVar, int i10, int i11, Charset charset, int i12, int i13) {
        if (aVar == a.AZTEC) {
            return c(d8.c.d(str.getBytes(charset), i12, i13), i10, i11);
        }
        throw new IllegalArgumentException("Can only encode AZTEC, but got ".concat(String.valueOf(aVar)));
    }

    private static b c(d8.a aVar, int i10, int i11) {
        b a10 = aVar.a();
        if (a10 != null) {
            int p10 = a10.p();
            int m10 = a10.m();
            int max = Math.max(i10, p10);
            int max2 = Math.max(i11, m10);
            int min = Math.min(max / p10, max2 / m10);
            int i12 = (max - (p10 * min)) / 2;
            int i13 = (max2 - (m10 * min)) / 2;
            b bVar = new b(max, max2);
            int i14 = 0;
            while (i14 < m10) {
                int i15 = 0;
                int i16 = i12;
                while (i15 < p10) {
                    if (a10.i(i15, i14)) {
                        bVar.s(i16, i13, min, min);
                    }
                    i15++;
                    i16 += min;
                }
                i14++;
                i13 += min;
            }
            return bVar;
        }
        throw new IllegalStateException();
    }

    public b a(String str, a aVar, int i10, int i11, Map<g, ?> map) {
        Charset charset = StandardCharsets.ISO_8859_1;
        int i12 = 33;
        int i13 = 0;
        if (map != null) {
            g gVar = g.CHARACTER_SET;
            if (map.containsKey(gVar)) {
                charset = Charset.forName(map.get(gVar).toString());
            }
            g gVar2 = g.ERROR_CORRECTION;
            if (map.containsKey(gVar2)) {
                i12 = Integer.parseInt(map.get(gVar2).toString());
            }
            g gVar3 = g.AZTEC_LAYERS;
            if (map.containsKey(gVar3)) {
                i13 = Integer.parseInt(map.get(gVar3).toString());
            }
        }
        return b(str, aVar, i10, i11, charset, i12, i13);
    }
}
