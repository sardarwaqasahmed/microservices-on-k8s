FROM openjdk:8-jdk-alpine
ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    WAIT_TIME=0 \
    JAVA_OPTS=""
VOLUME /stakater-fe-service
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /stakater-fe-service/stakater-fe.jar
ENTRYPOINT ["java","-jar","/stakater-fe-service/stakater-fe.jar"]
EXPOSE 9091