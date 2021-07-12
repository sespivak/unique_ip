@echo off
if not exist "build\unique_ip.jar" (
    if not exist build (
        mkdir build
    )
    cd build
    javac ..\src\com\ecwid\ip4count\*.java -d .
    jar cfm unique_ip.jar ..\resources\manifest.mf com\ecwid\ip4count\*.class
    cd ..
)
java -jar build\unique_ip.jar %1