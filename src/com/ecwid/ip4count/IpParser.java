package com.ecwid.ip4count;

public class IpParser {

    public static int[] parse(String ipString) {
        String[] segments = ipString.split("\\.", 4);
        assert segments.length == 4;
        int[] res = {0, 0, 0, 0};
        for (int i = 0; i<4; i++) {
            res[i] = Integer.parseUnsignedInt(segments[i]);
        }
        return res;
    }
}
