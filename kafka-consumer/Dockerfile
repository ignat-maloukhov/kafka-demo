FROM eclipse-temurin:17-jdk-alpine
MAINTAINER Ignat Malouhov
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} kafka-consumer-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/kafka-consumer-1.0-SNAPSHOT.jar"]