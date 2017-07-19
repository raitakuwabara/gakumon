@echo off
rem Licensed to the gakumon.tech under one or more
rem 2017/02/10
rem ---------------------------------------------------------------------------
rem Start First Java Sample
rem ---------------------------------------------------------------------------

setlocal

rem check JAVA_HOME
if exist "%JAVA_HOME%" goto okExec
echo Cannot find "%JAVA_HOME%"
echo "JAVA_HOME is not setting."
goto end

:okExec
rem java
set JAVAC_COMMAND=%JAVA_HOME%\bin\javac

cd %~dp0\..

set JAVAC_ARGS=-d deploy\classes -s src\main\java src\main\java\jp\co\yourcompany\education\samples\HowToWriteJava.java -encoding UTF8
call "%JAVAC_COMMAND%" %JAVAC_ARGS%

rem java
set JAVA_COMMAND=%JAVA_HOME%\bin\java
set JAVA_ARGS=-cp deploy\classes jp.co.yourcompany.education.samples.HowToWriteJava
call "%JAVA_COMMAND%" %JAVA_ARGS%

goto end
:end
