#!/bin/sh
echo "*****************************************************"
echo "		Starting Backend Service On Docker             "
echo "		name.prefix is mandatory environment variables,"
echo "		Make sure that you are passing them.		   "
echo "*****************************************************"
java $JAVA_OPT -Dname.prefix=$NAME_PREFIX \
-jar /usr/local/stakater-be-service/stakater-be-0.0.1-SNAPSHOT.jar