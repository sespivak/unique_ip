package com.ecwid.ip4count;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IpLeastStorage {
    private final long[] ipArray;
    private final Lock lock;

    public IpLeastStorage() {
        this.ipArray = new long[1024];
        this.lock = new ReentrantLock();
    }

    public boolean addNewIp(int leastIpBytes) {
        int leastIpIndex = leastIpBytes >> 6;
        long leastIpBitmask = (long) 1 << (leastIpBytes & 63);
        this.lock.lock();
        try {
            if ((this.ipArray[leastIpIndex] & leastIpBitmask) == 0) {
                this.ipArray[leastIpIndex] |= leastIpBitmask;
                return true;
            }
            return false;
        }
        finally {
            this.lock.unlock();
        }
    }
}
