package com.ecwid.ip4count;

public class Main {

    public static void main(String[] args) {
        IpSource ipSource = new IpSource("C:\\Downloads\\ip_addresses");
        String ip;
        long uniqueIpCount = 0;
        IpUniqueChecker ipUniqueChecker = new IpUniqueChecker();
        long ipNum;
        while (true) {
            ip = ipSource.getIp();
            if (ip == null) break;
            ipNum = IpParser.parse(ip);
            if (ipUniqueChecker.addNewIp(ipNum)) {
                uniqueIpCount++;
            }
        }
        System.out.println(uniqueIpCount);
    }
}
