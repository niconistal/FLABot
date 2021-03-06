@echo off
rem $Id: JavaLog.bat.tmpl,v 1.4 2002/03/04 12:21:05 azunino Exp $

set CLASS=JavaLog.Main
set JDK_PATH=/usr/java/jdk1.3.1_11/jre

set OPTION=%1

IF "%OPTION%"=="-p" goto PREP
IF "%OPTION%"=="-preprocessor" goto PREP
IF "%OPTION%"=="-d" goto DEBUGGER
IF "%OPTION%"=="-debugger" goto DEBUGGER
IF "%OPTION%"=="-v" goto VIEWER
IF "%OPTION%"=="-viewer" goto VIEWER
IF "%OPTION%"=="-g" goto GUI
IF "%OPTION%"=="-gui" goto GUI
IF "%OPTION%"=="-c" goto CLASS
IF "%OPTION%"=="-class" goto CLASS
IF "%OPTION%"=="-h" goto HELP
IF "%OPTION%"=="-?" goto HELP
IF "%OPTION%"=="-help" goto HELP

:HELP
echo Usage: JavaLog.bat [options]
echo Options:
echo     -p -preprocessor    Runs preprocessor
echo     -d -debugger          Runs preprocessor
echo     -v -viewer               Runs Movilog viewer
echo     -g -gui                      Runs JavaLog GUI
echo     -c -class                    Runs [class]
echo     -h -help                   This message
goto EXIT

:GUI
set CLASS=JavaLog.Main
goto JAVALOG

:DEBUGGER
set CLASS=JavaLog.debugger.gui.DebuggerGUI
goto JAVALOG


:VIEWER
set CLASS=JavaLog.mobility.viewer.ui.ViewLoader
goto JAVALOG


:PREP
set CLASS=JavaLog.Preprocessor
goto JAVALOG

:CLASS
set CLASS=%2
goto JAVALOG

:JAVALOG
%JDK_PATH%\bin\java -classpath /home/asoria/Tesis/Editores/aldeditors/nietoperezmedina/editor/libraries/JavaLog\web\WEB-INF\classes;/home/asoria/Tesis/Editores/aldeditors/nietoperezmedina/editor/libraries/JavaLog\lib\jgl3.1.0.jar;/home/asoria/Tesis/Editores/aldeditors/nietoperezmedina/editor/libraries/JavaLog\lib\antlrall.jar;/home/asoria/Tesis/Editores/aldeditors/nietoperezmedina/editor/libraries/JavaLog\lib\gnu-regexp-1.1.4.jar;/home/asoria/Tesis/Editores/aldeditors/nietoperezmedina/editor/libraries/JavaLog\lib\servlet.jar;. %CLASS% %2 %3 %4 %5

:EXIT
