package com.ecwid.ip4count;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Math.*;

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

    public void printStatistics() {
        int usedLeastStorages = 0;
        int usedBitsInLs;
        long usedBitsInLsSum = 0;
        int minUsedBitsInLs = 256*256;
        int maxUsedBitsInLs = 0;
        for (IpLeastStorage ls : ipMostStorage) {
            if (ls != null) {
                usedLeastStorages++;
                usedBitsInLs = ls.getUsedBits();
                usedBitsInLsSum += ls.getUsedBits();
                minUsedBitsInLs = min(usedBitsInLs, minUsedBitsInLs);
                maxUsedBitsInLs = max(usedBitsInLs, maxUsedBitsInLs);
            }
        }
        System.out.print("LeastStorages used: ");
        System.out.println(usedLeastStorages);
        System.out.print("MostStorage usage, %: ");
        System.out.println(round(100.0 * usedLeastStorages / (256*256.0)));
        System.out.print("Min LeastStorage usage, bits: ");
        System.out.println(minUsedBitsInLs);
        System.out.print("Max LeastStorage usage, bits: ");
        System.out.println(maxUsedBitsInLs);
        System.out.print("Average LeastStorage usage, bits: ");
        System.out.println(round((float) usedBitsInLsSum / usedLeastStorages));
        System.out.print("Average LeastStorage usage, %: ");
        System.out.println(round(100.0 * usedBitsInLsSum / (usedLeastStorages * 256*256.0)));
    }
}
