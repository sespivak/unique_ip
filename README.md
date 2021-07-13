# Unique IP Counter

Application reads textfile that contains one ipv4 address per line and counts
only unique ips.

Key features:
* Sparse storage for upper B-class networks. Memory allocated for network only if it contains at least one ip.
* Memory-effective storage for every B-class network (8kB worst case and 1 bit per IP best case).
* Parallel processing of read IP blocks.
* Low algorithm complexity of read/write operations in IP storage - O(1).

There is a Kotlin version in another [repository](https://github.com/sespivak/unique_ip_kt).

## Requirements

JDK v.11 or above

## Run

    ./run.sh <ip_addresses_filename>

## Test

Test results with [ip_addresses](https://ecwid-vgv-storage.s3.eu-central-1.amazonaws.com/ip_addresses.zip) on Core i7-9700.

    Time elapsed, sec.: 10 Total IPs read: 119710000 Unique IPs: 119710000 Unique percent: 100 Last IP: 235.1.89.38
    Time elapsed, sec.: 20 Total IPs read: 235060000 Unique IPs: 235060000 Unique percent: 100 Last IP: 220.153.9.231
    Time elapsed, sec.: 30 Total IPs read: 346860000 Unique IPs: 346860000 Unique percent: 100 Last IP: 96.29.236.245
    Time elapsed, sec.: 40 Total IPs read: 458600000 Unique IPs: 458600000 Unique percent: 100 Last IP: 80.84.124.91
    Time elapsed, sec.: 50 Total IPs read: 573970000 Unique IPs: 573970000 Unique percent: 100 Last IP: 77.67.82.12
    Time elapsed, sec.: 60 Total IPs read: 687860000 Unique IPs: 687860000 Unique percent: 100 Last IP: 221.133.225.233
    Time elapsed, sec.: 70 Total IPs read: 799160000 Unique IPs: 799160000 Unique percent: 100 Last IP: 173.24.6.238
    Time elapsed, sec.: 80 Total IPs read: 911310000 Unique IPs: 911310000 Unique percent: 100 Last IP: 94.39.144.229
    Time elapsed, sec.: 90 Total IPs read: 1021340000 Unique IPs: 1000000000 Unique percent: 98 Last IP: 232.230.32.72
    Time elapsed, sec.: 100 Total IPs read: 1137210000 Unique IPs: 1000000000 Unique percent: 88 Last IP: 148.47.247.169
    Time elapsed, sec.: 110 Total IPs read: 1252570000 Unique IPs: 1000000000 Unique percent: 80 Last IP: 54.119.41.161
    Time elapsed, sec.: 120 Total IPs read: 1369770000 Unique IPs: 1000000000 Unique percent: 73 Last IP: 191.30.178.196
    Time elapsed, sec.: 130 Total IPs read: 1484990000 Unique IPs: 1000000000 Unique percent: 67 Last IP: 39.135.145.159
    Time elapsed, sec.: 140 Total IPs read: 1597660000 Unique IPs: 1000000000 Unique percent: 63 Last IP: 221.212.11.233
    Time elapsed, sec.: 150 Total IPs read: 1711920000 Unique IPs: 1000000000 Unique percent: 58 Last IP: 119.50.117.165
    Time elapsed, sec.: 160 Total IPs read: 1824010000 Unique IPs: 1000000000 Unique percent: 55 Last IP: 136.144.35.10
    Time elapsed, sec.: 170 Total IPs read: 1938830000 Unique IPs: 1000000000 Unique percent: 52 Last IP: 178.250.206.154
    Time elapsed, sec.: 180 Total IPs read: 2056510000 Unique IPs: 1000000000 Unique percent: 49 Last IP: 156.75.98.232
    Time elapsed, sec.: 190 Total IPs read: 2172270000 Unique IPs: 1000000000 Unique percent: 46 Last IP: 250.90.225.197
    Time elapsed, sec.: 200 Total IPs read: 2290780000 Unique IPs: 1000000000 Unique percent: 44 Last IP: 100.133.233.55
    Time elapsed, sec.: 210 Total IPs read: 2404850000 Unique IPs: 1000000000 Unique percent: 42 Last IP: 241.214.186.73
    Time elapsed, sec.: 220 Total IPs read: 2518050000 Unique IPs: 1000000000 Unique percent: 40 Last IP: 165.19.198.91
    Time elapsed, sec.: 230 Total IPs read: 2634010000 Unique IPs: 1000000000 Unique percent: 38 Last IP: 4.160.246.142
    Time elapsed, sec.: 240 Total IPs read: 2750050000 Unique IPs: 1000000000 Unique percent: 36 Last IP: 225.182.176.252
    Time elapsed, sec.: 250 Total IPs read: 2863180000 Unique IPs: 1000000000 Unique percent: 35 Last IP: 77.71.148.61
    Time elapsed, sec.: 260 Total IPs read: 2974420000 Unique IPs: 1000000000 Unique percent: 34 Last IP: 104.211.19.17
    Time elapsed, sec.: 270 Total IPs read: 3087110000 Unique IPs: 1000000000 Unique percent: 32 Last IP: 46.85.11.147
    Time elapsed, sec.: 280 Total IPs read: 3200510000 Unique IPs: 1000000000 Unique percent: 31 Last IP: 23.166.198.19
    Time elapsed, sec.: 290 Total IPs read: 3315890000 Unique IPs: 1000000000 Unique percent: 30 Last IP: 210.195.207.217
    Time elapsed, sec.: 300 Total IPs read: 3430500000 Unique IPs: 1000000000 Unique percent: 29 Last IP: 47.74.20.39
    Time elapsed, sec.: 310 Total IPs read: 3545370000 Unique IPs: 1000000000 Unique percent: 28 Last IP: 221.65.138.15
    Time elapsed, sec.: 320 Total IPs read: 3657740000 Unique IPs: 1000000000 Unique percent: 27 Last IP: 170.116.219.67
    Time elapsed, sec.: 330 Total IPs read: 3769710000 Unique IPs: 1000000000 Unique percent: 27 Last IP: 113.131.4.4
    Time elapsed, sec.: 340 Total IPs read: 3880640000 Unique IPs: 1000000000 Unique percent: 26 Last IP: 76.133.18.93
    Time elapsed, sec.: 350 Total IPs read: 3989690000 Unique IPs: 1000000000 Unique percent: 25 Last IP: 140.186.187.160
    Time elapsed, sec.: 360 Total IPs read: 4105560000 Unique IPs: 1000000000 Unique percent: 24 Last IP: 153.94.203.135
    Time elapsed, sec.: 370 Total IPs read: 4218930000 Unique IPs: 1000000000 Unique percent: 24 Last IP: 24.251.15.139
    Time elapsed, sec.: 380 Total IPs read: 4318810000 Unique IPs: 1000000000 Unique percent: 23 Last IP: 192.211.248.92
    Time elapsed, sec.: 390 Total IPs read: 4422010000 Unique IPs: 1000000000 Unique percent: 23 Last IP: 144.73.32.28
    Time elapsed, sec.: 400 Total IPs read: 4536790000 Unique IPs: 1000000000 Unique percent: 22 Last IP: 188.24.164.254
    Time elapsed, sec.: 410 Total IPs read: 4649920000 Unique IPs: 1000000000 Unique percent: 22 Last IP: 96.71.73.105
    Time elapsed, sec.: 420 Total IPs read: 4762630000 Unique IPs: 1000000000 Unique percent: 21 Last IP: 54.75.74.61
    Time elapsed, sec.: 430 Total IPs read: 4876000000 Unique IPs: 1000000000 Unique percent: 21 Last IP: 117.41.180.59
    Time elapsed, sec.: 440 Total IPs read: 4990780000 Unique IPs: 1000000000 Unique percent: 20 Last IP: 99.208.254.214
    Time elapsed, sec.: 450 Total IPs read: 5103270000 Unique IPs: 1000000000 Unique percent: 20 Last IP: 120.26.48.168
    Time elapsed, sec.: 460 Total IPs read: 5217250000 Unique IPs: 1000000000 Unique percent: 19 Last IP: 21.26.176.146
    Time elapsed, sec.: 470 Total IPs read: 5331120000 Unique IPs: 1000000000 Unique percent: 19 Last IP: 108.60.129.227
    Time elapsed, sec.: 480 Total IPs read: 5442300000 Unique IPs: 1000000000 Unique percent: 18 Last IP: 190.229.62.168
    Time elapsed, sec.: 490 Total IPs read: 5562450000 Unique IPs: 1000000000 Unique percent: 18 Last IP: 177.217.101.61
    Time elapsed, sec.: 500 Total IPs read: 5682050000 Unique IPs: 1000000000 Unique percent: 18 Last IP: 149.246.63.101
    Time elapsed, sec.: 510 Total IPs read: 5804490000 Unique IPs: 1000000000 Unique percent: 17 Last IP: 63.146.97.101
    Time elapsed, sec.: 520 Total IPs read: 5924590000 Unique IPs: 1000000000 Unique percent: 17 Last IP: 215.2.177.157
    Time elapsed, sec.: 530 Total IPs read: 6041680000 Unique IPs: 1000000000 Unique percent: 17 Last IP: 51.80.188.124
    Time elapsed, sec.: 540 Total IPs read: 6161050000 Unique IPs: 1000000000 Unique percent: 16 Last IP: 125.197.22.197
    Time elapsed, sec.: 550 Total IPs read: 6278160000 Unique IPs: 1000000000 Unique percent: 16 Last IP: 202.250.214.217
    Time elapsed, sec.: 560 Total IPs read: 6397910000 Unique IPs: 1000000000 Unique percent: 16 Last IP: 131.110.55.6
    Time elapsed, sec.: 570 Total IPs read: 6515040000 Unique IPs: 1000000000 Unique percent: 15 Last IP: 239.26.158.57
    Time elapsed, sec.: 580 Total IPs read: 6633420000 Unique IPs: 1000000000 Unique percent: 15 Last IP: 91.40.111.111
    Time elapsed, sec.: 590 Total IPs read: 6748140000 Unique IPs: 1000000000 Unique percent: 15 Last IP: 103.69.220.253
    Time elapsed, sec.: 600 Total IPs read: 6867860000 Unique IPs: 1000000000 Unique percent: 15 Last IP: 137.161.244.210
    Time elapsed, sec.: 610 Total IPs read: 6979870000 Unique IPs: 1000000000 Unique percent: 14 Last IP: 107.177.239.240
    Time elapsed, sec.: 620 Total IPs read: 7095630000 Unique IPs: 1000000000 Unique percent: 14 Last IP: 20.196.109.217
    Time elapsed, sec.: 630 Total IPs read: 7208290000 Unique IPs: 1000000000 Unique percent: 14 Last IP: 42.245.50.64
    Time elapsed, sec.: 640 Total IPs read: 7325730000 Unique IPs: 1000000000 Unique percent: 14 Last IP: 244.197.231.151
    Time elapsed, sec.: 650 Total IPs read: 7441070000 Unique IPs: 1000000000 Unique percent: 13 Last IP: 239.109.196.181
    Time elapsed, sec.: 660 Total IPs read: 7556000000 Unique IPs: 1000000000 Unique percent: 13 Last IP: 137.11.79.92
    Time elapsed, sec.: 670 Total IPs read: 7670260000 Unique IPs: 1000000000 Unique percent: 13 Last IP: 144.113.193.171
    Time elapsed, sec.: 680 Total IPs read: 7782630000 Unique IPs: 1000000000 Unique percent: 13 Last IP: 187.120.27.116
    Time elapsed, sec.: 690 Total IPs read: 7896180000 Unique IPs: 1000000000 Unique percent: 13 Last IP: 99.122.107.185
    Time elapsed, sec.: 700 Total IPs read: 8000000000 Unique IPs: 1000000000 Unique percent: 13 Last IP: 122.225.71.182
    LeastStorages used: 65536
    MostStorage usage, %: 100
    Min LeastStorage usage, bits: 10658
    Max LeastStorage usage, bits: 19723
    Average LeastStorage usage, bits: 15259
    Average LeastStorage usage, %: 23