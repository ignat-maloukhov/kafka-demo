FROM eclipse-temurin:17-jdk-alpine
MAINTAINER Ignat Malouhov
#EXPOSE 8080
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} kafka-admin-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/kafka-admin-1.0-SNAPSHOT.jar"]