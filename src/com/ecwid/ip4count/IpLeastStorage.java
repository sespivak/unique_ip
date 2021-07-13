package com.ecwid.ip4count;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IpLeastStorage {
    private final long[] ipArray;
    private final Lock lock;
    private int usedBits;

    public IpLeastStorage() {
        ipArray = new long[1024];
        lock = new ReentrantLock();
        usedBits = 0;
    }

    public boolean addNewIp(int leastIpBytes) {
        int leastIpIndex = leastIpBytes >> 6;
        long leastIpBitmask = (long) 1 << (leastIpBytes & 63);
        if ((ipArray[leastIpIndex] & leastIpBitmask) != 0) return false;
        lock.lock();
        try {
            if ((ipArray[leastIpIndex] & leastIpBitmask) == 0) {
                ipArray[leastIpIndex] |= leastIpBitmask;
                usedBits++;
                return true;
            }
        }
        finally {
            lock.unlock();
        }
        return false;
    }

    public int getUsedBits() {
        return usedBits;
    }
}
