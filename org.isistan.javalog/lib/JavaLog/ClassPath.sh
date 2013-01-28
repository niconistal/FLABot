#!/bin/sh
# $Id: ClassPath.sh.tmpl,v 1.3 2002/03/04 12:21:05 azunino Exp $
JAVALOG_PATH=/home/asoria/Tesis/Editores/aldeditors/nietoperezmedina/editor/libraries/JavaLog
JGL_PATH=/home/asoria/Tesis/Editores/aldeditors/nietoperezmedina/editor/libraries/JavaLog
ANTLR_PATH=/home/asoria/Tesis/Editores/aldeditors/nietoperezmedina/editor/libraries/JavaLog/lib
JDK_PATH=/usr/java/jdk1.3.1_11/jre
JAVAREGEX_PATH=/home/asoria/Tesis/Editores/aldeditors/nietoperezmedina/editor/libraries/JavaLog/lib
JSDK_PATH=/home/asoria/Tesis/Editores/aldeditors/nietoperezmedina/editor/libraries/JavaLog/lib

# --- CONFIGURATION ENDS HERE ---

export CLASSPATH=$JAVALOG_PATH/classes:$JGL_PATH/lib/jgl3.1.0.jar:$ANTLR_PATH/antlrall.jar:$JAVAREGEX_PATH/lib/gnu-regexp-1.1.4.jar:$JSDK_PATH/servlet.jar:$CLASSPATH

if test ! -d ${JAVALOG_PATH}/classes; then
    echo ${JAVALOG_PATH}/classes does not exist.
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
