@echo off
echo 启动Big Event应用程序...
echo 使用Java 25和原生访问权限...

java --enable-native-access=ALL-UNNAMED -jar target/big-event-1.0-SNAPSHOT.jar

pause
