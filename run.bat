if not exist "build\unique_ip.jar" (
    CALL build.bat
)
java -jar build\unique_ip.jar %1
