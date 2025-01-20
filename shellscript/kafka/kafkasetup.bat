

@echo off
echo Navigating to C:\Users
cd D:\softwares\kafka
echo Listing files in the directory:
REM  dir

REM set /p name=Enter your name:
REM echo Hello, %name%!

.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties


pause




