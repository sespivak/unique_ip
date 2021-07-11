package com.ecwid.ip4count;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IpUniqueChecker {
    private final IpLeastStorage[] ipMostStorage;
    private long uniqueIpCount;
    private Lock lock;

    public IpUniqueChecker() {
        this.ipMostStorage = new IpLeastStorage[256*256];
        this.lock = new ReentrantLock();
    }

    public boolean addNewIp(String ip) {
        if (ip == null) return false;
        long ipNum = IpParser.parse(ip);
        return this.addNewIp(ipNum);
    }

    private IpLeastStorage getIpLeastStorage(int mostIpBytes) {
        if (this.ipMostStorage[mostIpBytes] == null) {
            this.lock.lock();
            try {
                if (this.ipMostStorage[mostIpBytes] == null) {
                    this.ipMostStorage[mostIpBytes] = new IpLeastStorage();
                }
            } finally {
                this.lock.unlock();
            }
        }
        return this.ipMostStorage[mostIpBytes];
    }

    public boolean addNewIp(long ipNum) {
        if (ipNum == 0) return false;
        int mostIpBytes = (int) (ipNum >> 16);
        int leastIpBytes = (int) (ipNum & 0xffff);
        if (this.getIpLeastStorage(mostIpBytes).addNewIp(leastIpBytes)) {
            this.uniqueIpCount++;
            return true;
        }
        return false;
    }

    public long getUniqueIpCount() {
        return this.uniqueIpCount;
    }
}
