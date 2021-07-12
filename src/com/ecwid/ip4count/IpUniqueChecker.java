package com.ecwid.ip4count;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IpUniqueChecker {
    private final IpLeastStorage[] ipMostStorage;
    private final Lock lock;

    public IpUniqueChecker() {
        ipMostStorage = new IpLeastStorage[256*256];
        lock = new ReentrantLock();
    }

    public boolean addNewIp(String ip) {
        if (ip == null) return false;
        long ipNum = IpParser.parse(ip);
        return addNewIp(ipNum);
    }

    private IpLeastStorage getIpLeastStorage(int mostIpBytes) {
        if (ipMostStorage[mostIpBytes] == null) {
            lock.lock();
            try {
                if (ipMostStorage[mostIpBytes] == null) {
                    ipMostStorage[mostIpBytes] = new IpLeastStorage();
                }
            } finally {
                lock.unlock();
            }
        }
        return ipMostStorage[mostIpBytes];
    }

    public boolean addNewIp(long ipNum) {
        if (ipNum == 0) return false;
        int mostIpBytes = (int) (ipNum >> 16);
        int leastIpBytes = (int) (ipNum & 0xffff);
        return getIpLeastStorage(mostIpBytes).addNewIp(leastIpBytes);
    }
}
