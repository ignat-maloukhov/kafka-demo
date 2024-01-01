https://www.youtube.com/watch?v=pSKY3-K9_qc
https://reflectoring.io/spring-boot-gradle-multi-module/
https://spring.io/guides/gs/multi-module/
https://spring.io/guides/topicals/spring-boot-docker/
https://www.docker.com/blog/kickstart-your-spring-boot-application-development/

Dockerizing:
1. build jar file
```
./gradlew clean kafka-broker:build
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