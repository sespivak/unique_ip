package com.ecwid.ip4count;

import java.io.File;
import java.util.Arrays;

import static java.lang.Math.round;

public class Main {

    public static final int IP_BATCH_SIZE = 10000;

    public static void main(String[] args) {

        if (args.length > 0) {
            File f = new File(args[0]);
            if (!f.exists()) {
                System.out.println("File " + args[0] + " not exists!");
                System.exit(1);
            }
        } else {
            System.out.println("IP address filename required in argument!");
            System.exit(1);
        }

        long startTimestamp = System.currentTimeMillis();
        long monitorTimestamp = startTimestamp;
        long timeElapsed;
        long ipReadCount = 0;
        long uniqueIpCount = 0;

        IpSource ipSource = new IpSource(args[0]);
        IpUniqueChecker ipUniqueChecker = new IpUniqueChecker();
        String[] ipArray = new String[IP_BATCH_SIZE];
        String ip = null;

        while (ipArray.length == IP_BATCH_SIZE) {
            for (int i=0; i < ipArray.length; i++) {
                ip = ipSource.getIp();
                if (ip == null) {
                    ipArray = Arrays.copyOf(ipArray, i);
                    break;
                }
                ipReadCount++;
                ipArray[i] = ip;
            }
            uniqueIpCount += Arrays.stream(ipArray).parallel().reduce(
                    (long) 0,
                    (partialSum, ipString) -> partialSum + (ipUniqueChecker.addNewIp(ipString) ? 1 : 0),
                    Long::sum
            );
            if (System.currentTimeMillis() - monitorTimestamp >= 10000) {
                monitorTimestamp = System.currentTimeMillis();
                timeElapsed = monitorTimestamp - startTimestamp;
                printStatistics(timeElapsed, ipReadCount, uniqueIpCount, ip);
            }
        }
        timeElapsed = System.currentTimeMillis() - startTimestamp;
        printStatistics(timeElapsed, ipReadCount, uniqueIpCount, ip);
    }

    public static void printStatistics(long timeElapsed, long ipReadCount, long uniqueIpCount, String lastIp) {
        System.out.print("Time elapsed, sec.: ");
        System.out.print(round(timeElapsed * 0.001));
        System.out.print(" Total IPs read: ");
        System.out.print(ipReadCount);
        System.out.print(" Unique IPs: ");
        System.out.print(uniqueIpCount);
        System.out.print(" Unique percent: ");
        System.out.print(round(100.0 * uniqueIpCount/ipReadCount));
        System.out.print(" Last IP: ");
        System.out.print(lastIp);
        System.out.println();
    }
}
