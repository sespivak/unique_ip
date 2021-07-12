#!/bin/sh

cd ./build
javac ../src/com/ecwid/ip4count/*.java -d .
jar cfm unique_ip.jar manifest.mf com/ecwid/ip4count/*.class
