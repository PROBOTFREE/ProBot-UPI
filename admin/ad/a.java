package ad;

import java.math.BigInteger;
import java.security.SecureRandom;
import nd.b;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static final BigInteger f166a = BigInteger.valueOf(1);

    /* renamed from: b  reason: collision with root package name */
    private static final BigInteger f167b = BigInteger.valueOf(2);

    static {
        BigInteger.valueOf(3);
    }

    private static void a(BigInteger bigInteger, String str) {
        if (bigInteger == null || bigInteger.signum() < 1 || bigInteger.bitLength() < 2) {
            throw new IllegalArgumentException("'" + str + "' must be non-null and >= 2");
        }
    }

    public static boolean b(BigInteger bigInteger) {
        a(bigInteger, "candidate");
        return c(bigInteger);
    }

    private static boolean c(BigInteger bigInteger) {
        int intValue = bigInteger.mod(BigInteger.valueOf((long) 223092870)).intValue();
        if (!(intValue % 2 == 0 || intValue % 3 == 0 || intValue % 5 == 0 || intValue % 7 == 0 || intValue % 11 == 0 || intValue % 13 == 0 || intValue % 17 == 0 || intValue % 19 == 0 || intValue % 23 == 0)) {
            int intValue2 = bigInteger.mod(BigInteger.valueOf((long) 58642669)).intValue();
            if (!(intValue2 % 29 == 0 || intValue2 % 31 == 0 || intValue2 % 37 == 0 || intValue2 % 41 == 0 || intValue2 % 43 == 0)) {
                int intValue3 = bigInteger.mod(BigInteger.valueOf((long) 600662303)).intValue();
                if (!(intValue3 % 47 == 0 || intValue3 % 53 == 0 || intValue3 % 59 == 0 || intValue3 % 61 == 0 || intValue3 % 67 == 0)) {
                    int intValue4 = bigInteger.mod(BigInteger.valueOf((long) 33984931)).intValue();
                    if (!(intValue4 % 71 == 0 || intValue4 % 73 == 0 || intValue4 % 79 == 0 || intValue4 % 83 == 0)) {
                        int intValue5 = bigInteger.mod(BigInteger.valueOf((long) 89809099)).intValue();
                        if (!(intValue5 % 89 == 0 || intValue5 % 97 == 0 || intValue5 % 101 == 0 || intValue5 % 103 == 0)) {
                            int intValue6 = bigInteger.mod(BigInteger.valueOf((long) 167375713)).intValue();
                            if (!(intValue6 % 107 == 0 || intValue6 % 109 == 0 || intValue6 % 113 == 0 || intValue6 % 127 == 0)) {
                                int intValue7 = bigInteger.mod(BigInteger.valueOf((long) 371700317)).intValue();
                                if (!(intValue7 % 131 == 0 || intValue7 % 137 == 0 || intValue7 % 139 == 0 || intValue7 % 149 == 0)) {
                                    int intValue8 = bigInteger.mod(BigInteger.valueOf((long) 645328247)).intValue();
                                    if (!(intValue8 % 151 == 0 || intValue8 % 157 == 0 || intValue8 % 163 == 0 || intValue8 % 167 == 0)) {
                                        int intValue9 = bigInteger.mod(BigInteger.valueOf((long) 1070560157)).intValue();
                                        if (!(intValue9 % 173 == 0 || intValue9 % 179 == 0 || intValue9 % 181 == 0 || intValue9 % 191 == 0)) {
                                            int intValue10 = bigInteger.mod(BigInteger.valueOf((long) 1596463769)).intValue();
                                            return intValue10 % 193 == 0 || intValue10 % 197 == 0 || intValue10 % 199 == 0 || intValue10 % 211 == 0;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean d(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i10, BigInteger bigInteger4) {
        BigInteger modPow = bigInteger4.modPow(bigInteger3, bigInteger);
        if (modPow.equals(f166a) || modPow.equals(bigInteger2)) {
            return true;
        }
        for (int i11 = 1; i11 < i10; i11++) {
            modPow = modPow.modPow(f167b, bigInteger);
            if (modPow.equals(bigInteger2)) {
                return true;
            }
            if (modPow.equals(f166a)) {
                return false;
            }
        }
        return false;
    }

    public static boolean e(BigInteger bigInteger, SecureRandom secureRandom, int i10) {
        a(bigInteger, "candidate");
        if (secureRandom == null) {
            throw new IllegalArgumentException("'random' cannot be null");
        } else if (i10 < 1) {
            throw new IllegalArgumentException("'iterations' must be > 0");
        } else if (bigInteger.bitLength() == 2) {
            return true;
        } else {
            if (!bigInteger.testBit(0)) {
                return false;
            }
            BigInteger subtract = bigInteger.subtract(f166a);
            BigInteger subtract2 = bigInteger.subtract(f167b);
            int lowestSetBit = subtract.getLowestSetBit();
            BigInteger shiftRight = subtract.shiftRight(lowestSetBit);
            for (int i11 = 0; i11 < i10; i11++) {
                if (!d(bigInteger, subtract, shiftRight, lowestSetBit, b.c(f167b, subtract2, secureRandom))) {
                    return false;
                }
            }
            return true;
        }
    }
}
