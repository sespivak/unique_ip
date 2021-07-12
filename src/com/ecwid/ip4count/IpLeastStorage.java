package com.ecwid.ip4count;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IpLeastStorage {
    private final long[] ipArray;
    private final Lock lock;

    public IpLeastStorage() {
        ipArray = new long[1024];
        lock = new ReentrantLock();
    }

    public boolean addNewIp(int leastIpBytes) {
        int leastIpIndex = leastIpBytes >> 6;
        long leastIpBitmask = (long) 1 << (leastIpBytes & 63);
        lock.lock();
        try {
            if ((ipArray[leastIpIndex] & leastIpBitmask) == 0) {
                ipArray[leastIpIndex] |= leastIpBitmask;
                return true;
            }
            return false;
        }
        finally {
            lock.unlock();
        }
    }
}
