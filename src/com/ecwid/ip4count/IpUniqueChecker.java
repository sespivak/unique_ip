package com.ecwid.ip4count;

public class IpUniqueChecker {
    private final IpLeastStorage[] ipMostStorage;

    public IpUniqueChecker() {
        this.ipMostStorage = new IpLeastStorage[256*256];
    }

    public boolean addNewIp(String ip) {
        int[] ipBytes = IpParser.parse(ip);
        int mostStorageIndex = (ipBytes[0] << 8) + ipBytes[1];
        int leastStorageIndex = (ipBytes[2] << 8) + ipBytes[3];
        if (this.ipMostStorage[mostStorageIndex] == null) {
            this.ipMostStorage[mostStorageIndex] = new IpLeastStorage();
        }
        IpLeastStorage ipLeastStorage = this.ipMostStorage[mostStorageIndex];
        return ipLeastStorage.addNewIp(leastStorageIndex);
    }
}
