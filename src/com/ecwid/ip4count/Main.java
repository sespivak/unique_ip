package com.ecwid.ip4count;

import java.io.File;

import static java.lang.Math.round;

public class Main {

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

        IpSource ipSource = new IpSource(args[0]);
        long startTimestamp = System.currentTimeMillis();
        long monitorTimestamp = startTimestamp;
        long ipReadCount = 0;
        long timeElapsed;
        String ip;
        long uniqueIpCount = 0;
        IpUniqueChecker ipUniqueChecker = new IpUniqueChecker();
        long ipNum;

        while (true) {
            ip = ipSource.getIp();
            if (ip == null) break;
            ipReadCount += 1;
            ipNum = IpParser.parse(ip);
            if (ipUniqueChecker.addNewIp(ipNum)) {
                uniqueIpCount++;
            }
            if ((ipReadCount & 0xfffff) == 0) {
                if (System.currentTimeMillis() - monitorTimestamp >= 10000) {
                    monitorTimestamp = System.currentTimeMillis();
                    timeElapsed = monitorTimestamp - startTimestamp;
                    Main.printStatistics(timeElapsed, ipReadCount, uniqueIpCount, ip);
                }
            }
        }
        timeElapsed = System.currentTimeMillis() - startTimestamp;
        Main.printStatistics(timeElapsed, ipReadCount, uniqueIpCount, ip);
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
