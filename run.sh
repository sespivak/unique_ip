#!/bin/sh

[ ! -f "./build/unique_ip.jar" ] && ./build.sh
[ -f "./build/unique_ip.jar" ] && java -jar ./build/unique_ip.jar $1
