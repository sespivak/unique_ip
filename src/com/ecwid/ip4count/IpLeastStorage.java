package com.ecwid.ip4count;

public class IpLeastStorage {
    private final long[] ipArray;

    public IpLeastStorage() {
        this.ipArray = new long[1024];
    }

    public boolean addNewIp(int leastIpBytes) {
        int leastIpIndex = leastIpBytes >> 6;
        long leastIpBitmask = (long) 1 << (leastIpBytes & 63);
        if ((this.ipArray[leastIpIndex] & leastIpBitmask) == 0) {
            this.ipArray[leastIpIndex] |= leastIpBitmask;
            return true;
        }
        return false;
    }
}
