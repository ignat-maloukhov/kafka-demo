https://www.youtube.com/watch?v=pSKY3-K9_qc
https://reflectoring.io/spring-boot-gradle-multi-module/
https://spring.io/guides/gs/multi-module/
https://spring.io/guides/topicals/spring-boot-docker/
https://www.docker.com/blog/kickstart-your-spring-boot-application-development/

Dockerizing:
1. build single jar files
```
./gradlew clean kafka-broker:build
./gradlew clean kafka-prosucer:build
./gradlew clean kafka-consumer:build
```
or build all services 
```
./gradlew clean build
```

2. create images
```
docker build --build-arg JAR_FILE=kafka-broker/build/libs/*.jar -f kafka-broker/Dockerfile . -t kafka-broker
docker build --build-arg JAR_FILE=kafka-producer/build/libs/*.jar -f kafka-producer/Dockerfile . -t kafka-producer
docker build --build-arg JAR_FILE=kafka-consumer/build/libs/*.jar -f kafka-consumer/Dockerfile . -t kafka-consumer
```
3. run single container on port 9090
```
docker run -p 9090:8090 kafka-broker
docker run -p 9091:8091 kafka-producer
docker run -p 9092:8092 kafka-consumer
```
or run all containers using Docker-compose
```
docker-compose up
```