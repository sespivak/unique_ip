package com.ecwid.ip4count;

public class IpParser {

    public static long parse(String ipString) {
        int beginIndex = 0;
        int endIndex;
        long res = 0;
        long segment;
        for (int i = 0; i<4; i++) {
            if (i < 3) {
                endIndex = ipString.indexOf('.', beginIndex + 1);
                if (endIndex == -1) {
                    System.out.println(ipString);
                    return 0;
                }
            } else {
                endIndex = ipString.length();
            }
            try {
                segment = Integer.parseUnsignedInt(ipString.substring(beginIndex, endIndex));
                beginIndex = endIndex + 1;
            }
            catch (NumberFormatException e) {
                System.out.println(ipString);
                return 0;
            }
            if (segment > 255 || segment < 0) {
                System.out.println(ipString);
                return 0;
            }
            res += segment << ((3 - i) * 8);
        }
        return res;
    }
}
