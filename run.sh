#!/bin/sh

if [ ! -f "./build/unique_ip.jar" ]
then
  [ ! -d build ] && mkdir build
  cd build
  javac ../src/com/ecwid/ip4count/*.java -d .
  jar cfm unique_ip.jar ../resources/manifest.mf com/ecwid/ip4count/*.class
  cd ..
fi
[ -f "./build/unique_ip.jar" ] && java -jar ./build/unique_ip.jar $1
