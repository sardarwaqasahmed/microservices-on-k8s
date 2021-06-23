#!/bin/sh
echo "*****************************************************"
echo "		Starting Front End Service On Docker           "
echo "		This will consume BackEnd Service using K8S DNS"
echo "*****************************************************"
java $JAVA_OPT -jar /usr/local/stakater-fe-service/stakater-fe-0.0.1-SNAPSHOT.jar