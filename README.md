https://www.youtube.com/watch?v=pSKY3-K9_qc
https://spring.io/guides/topicals/spring-boot-docker/

Dockerizing:
1. build jar file
```
./gradlew kafka-broker:build
```
2. create image
```
docker build --build-arg JAR_FILE=kafka-broker/build/libs/*.jar -f kafka-broker/Dockerfile . -t kafka-broker
```
3. run container on port 8090
```
docker run -p 9090:8090 kafka-broker
```
4. run using Docker-compose
```
docker-compose up
```