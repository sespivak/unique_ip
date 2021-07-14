package com.ecwid.ip4count;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IpUniqueChecker {
    private final Lock[] locks;
    private final long[] ipArray;
    private long usedBits;

    public IpUniqueChecker() {
        locks = new Lock[64];
        for (int i=0; i<64; i++) {
            locks[i] = new ReentrantLock();
        }
        usedBits = 0;
        ipArray = new long[1024 * 256 * 256];
    }

    public boolean addNewIp(String ip) {
        if (ip == null) return false;
        long ipNum = IpParser.parse(ip);
        return addNewIp(ipNum);
    }

    public boolean addNewIp(long ipNum) {
        if (ipNum == 0) return false;
        int ipIndex = (int) (ipNum >> 6);
        int lockIndex = (int) (ipNum >> 26);
        long ipBitmask = (long) 1 << (ipNum & 63);
        if ((ipArray[ipIndex] & ipBitmask) != 0) return false;
        locks[lockIndex].lock();
        try {
            if ((ipArray[ipIndex] & ipBitmask) == 0) {
                ipArray[ipIndex] |= ipBitmask;
                usedBits++;
                return true;
            }
        }
        finally {
            locks[lockIndex].unlock();
        }
        return false;
    }

    public void printStatistics() {
        System.out.print("IP Storage usage: ");
        System.out.println(usedBits);
        System.out.print("IP Storage usage, %: ");
        System.out.println((100.0 * usedBits / (65536 * 65536.0)));
    }
}
