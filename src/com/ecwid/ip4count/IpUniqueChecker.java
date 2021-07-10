package com.ecwid.ip4count;

public class IpUniqueChecker {
    private final IpLeastStorage[] ipMostStorage;

    public IpUniqueChecker() {
        this.ipMostStorage = new IpLeastStorage[256*256];
    }

    public boolean addNewIp(String ip) {
        long ipNum = IpParser.parse(ip);
        return this.addNewIp(ipNum);
    }

    public boolean addNewIp(long ipNum) {
        if (ipNum == 0) return false;
        int mostStorageIndex = (int) (ipNum >> 16);
        int leastStorageIndex = (int) (ipNum & 0xffff);
        IpLeastStorage ipLeastStorage = this.ipMostStorage[mostStorageIndex];
        if (ipLeastStorage == null) {
            ipLeastStorage = new IpLeastStorage();
            this.ipMostStorage[mostStorageIndex] = ipLeastStorage;
        }
        return ipLeastStorage.addNewIp(leastStorageIndex);
    }
}
