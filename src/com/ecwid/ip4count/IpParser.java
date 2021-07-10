package com.ecwid.ip4count;

public class IpParser {

    public static int[] parse(String ipString) {
        String[] segments = ipString.split("\\.");
        if (segments.length != 4) {
            System.out.println(ipString);
            return null;
        }
        int[] res = new int[4];
        for (int i = 0; i<4; i++) {
            try {
                res[i] = Integer.parseUnsignedInt(segments[i]);
            }
            catch (NumberFormatException e) {
                System.out.println(ipString);
                return null;
            }
            if (res[i] > 255 || res[i] < 0) {
                System.out.println(ipString);
                return null;
            }
        }
        return res;
    }
}
