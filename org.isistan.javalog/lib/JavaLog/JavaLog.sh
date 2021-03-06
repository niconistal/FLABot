#!/bin/sh
# $Id: JavaLog.sh.tmpl,v 1.5 2002/05/10 19:17:43 azunino Exp $
JAVALOG_PATH=/home/asoria/Tesis/Editores/aldeditors/nietoperezmedina/editor/libraries/JavaLog
JGL_PATH=/home/asoria/Tesis/Editores/aldeditors/nietoperezmedina/editor/libraries/JavaLog
ANTLR_PATH=/home/asoria/Tesis/Editores/aldeditors/nietoperezmedina/editor/libraries/JavaLog/lib
JDK_PATH=/usr/java/jdk1.3.1_11/jre
JAVAREGEX_PATH=/home/asoria/Tesis/Editores/aldeditors/nietoperezmedina/editor/libraries/JavaLog/lib
JSDK_PATH=/home/asoria/Tesis/Editores/aldeditors/nietoperezmedina/editor/libraries/JavaLog/lib


# --- CONFIGURATION ENDS HERE ---

JAVA=$JDK_PATH/bin/java
CLASS=JavaLog.Main

if test ! -d ${JAVALOG_PATH}/web/WEB-INF/classes; then
    echo ${JAVALOG_PATH}/web/WEB-INF/classes does not exist.
    echo Please set JAVALOG_PATH=${JAVALOG_PATH} variable correctly.
    exit
fi

if test ! -f ${JSDK_PATH}/servlet.jar; then
    echo ${JSDK_PATH}/servlet.jar does not exist.
    echo Please set JSDK_PATH=${JSDK_PATH} variable correctly.
    exit
fi

if test ! -f ${JGL_PATH}/lib/jgl3.1.0.jar; then
    echo ${JGL_PATH}/lib/jgl3.1.0.jar does not exist.
    echo Please set JGL_PATH=${JGL_PATH} variable correctly.
    exit
fi

if test ! -f ${ANTLR_PATH}/antlrall.jar; then
    echo ${ANTLR_PATH}/antlrall.jar does not exist.
    echo Please set ANTLR_PATH=${ANTLR_PATH} variable correctly.
    exit
fi

if test ! -f ${JAVAREGEX_PATH}/gnu-regexp-1.1.4.jar; then
    echo ${JAVAREGEX_PATH}/gnu-regexp-1.1.4.jar does not exist.
    echo Please set JAVAREGEX_PATH=${JAVAREGEX_PATH} variable correctly.
    exit
fi


OPTION=$1
case "$OPTION" in
 -p | -preprocessor | --preprocessor)
    CLASS=JavaLog.Preprocessor ;;
 -d | -debugger | --debugger)
    CLASS=JavaLog.debugger.gui.DebuggerGUI ;;

 -v | -viewer | --viewer)
    CLASS=JavaLog.mobility.viewer.ui.ViewLoader;;	
 -g | -gui | --gui)
    CLASS=JavaLog.Main ;;
 -c | -class | --class)
    CLASS=$2 ;;
 -h | -help | -? | --help |*)
    cat <<EOF
Usage: JavaLog.sh [options] [class]
Options:
    -p -preprocessor    Runs the preprocessor
    -d -debugger        Runs the JavaLog debugger
    -g -gui             Runs the JavaLog GUI
    -c -class           Runs [class]
    -h -help            This message
EOF
    exit 0 ;;
esac

shift

exec $JAVA -ms3M -classpath $JAVALOG_PATH/web/WEB-INF/classes:$JGL_PATH/lib/jgl3.1.0.jar:$ANTLR_PATH/antlrall.jar:$JAVAREGEX_PATH/gnu-regexp-1.1.4.jar:$JSDK_PATH/servlet.jar:. $CLASS $*



