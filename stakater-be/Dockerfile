FROM openjdk:8-jdk-alpine
ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    WAIT_TIME=0 \
    JAVA_OPTS=""
VOLUME /stakater-be-service
ARG JAR_FILE=target/*.jar
ARG DEF_NAME_PREFIX=Super-Man
ENV name.prefix $DEF_NAME_PREFIX
COPY ${JAR_FILE} /stakater-be-service/stakater-be.jar
ENTRYPOINT ["java","-jar","/stakater-be-service/stakater-be.jar"]
EXPOSE 8081