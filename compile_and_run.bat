@echo off
REM Batch script to compile and run Employee Management System

REM Set the path to your MySQL Connector/J .jar file here
SET JAR_PATH=C:\Users\dominik\Desktop\mysql-connector-j-9.3.0.jar

javac -cp ".;%JAR_PATH%" *.java
if %ERRORLEVEL% neq 0 (
    echo Compilation failed.
    exit /b %ERRORLEVEL%
)

java -cp ".;%JAR_PATH%" Main