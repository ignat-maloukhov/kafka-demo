Hi everyone and me in the future :wave: this demo project is grokking [Apache Kafka](https://kafka.apache.org/) & [Spring for Apache Kafka](https://spring.io/projects/spring-kafka/) project.

### Action plan
**Step one.** Set up [Gradle](https://gradle.org/) multi-module project according to the instructions in this [article](https://reflectoring.io/spring-boot-gradle-multi-module/) and [documentation](https://docs.gradle.org/current/userguide/multi_project_builds.html).</br>
**Step two.** Run [Zookeeper](https://zookeeper.apache.org/) and [Apache Kafka](https://kafka.apache.org/) in [Docker](https://www.docker.com/)according to the instructions in this [article](https://www.baeldung.com/ops/kafka-docker-setup).</br>
**Step three.** Code and configure Kafka topic using Spring KafkaAdmin, at the same time, you need to take into account the specifics of the ports in the container which are described in this [answer](https://stackoverflow.com/questions/72113718/how-to-docker-compose-spring-boot-with-kafka).</br>
**Step four.** Code producer and consumer according to the instructions in these articles:
* [Intro to Apache Kafka with Spring](https://www.baeldung.com/spring-kafka);
* [Spring Boot and Kafka – Practical Example](https://thepracticaldeveloper.com/spring-boot-kafka-config/);
* [Apache Kafka using Spring Boot](https://howtodoinjava.com/spring-boot/apache-kafka-using-spring-boot/).</br></br>
**Step five.** Test using Testcontainers according to the instructions in this [article](https://www.baeldung.com/spring-boot-kafka-testing).</br>
</br>
Youtube tutorials and presentations:
* [Владимир Богдановский. Про Kafka (основы)](https://youtu.be/-AZOi3kP9Js)</br>
* [Amigoscode. Kafka Tutorial - Spring Boot Microservices](https://youtu.be/SqVfCyfCJqw)</br>
* [Bouali Ali. Apache Kafka Tutorial with Spring Boot Reactive & WebFlux | Kafka Tutorial](https://youtu.be/KQDTtvZMS9c)</br>
* [Devtiro. Stream Big Data: How to use Kafka with Spring Boot](https://youtu.be/QngHCFFsa00)</br>


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
docker build --build-arg JAR_FILE=kafka-admin/build/libs/*.jar -f kafka-admin/Dockerfile . -t kafka-admin
docker build --build-arg JAR_FILE=kafka-producer/build/libs/*.jar -f kafka-producer/Dockerfile . -t kafka-producer
docker build --build-arg JAR_FILE=kafka-consumer/build/libs/*.jar -f kafka-consumer/Dockerfile . -t kafka-consumer
```
3. run single container on given port
```
docker run -p 9099:8099 kafka-admin
docker run -p 9090:8090 kafka-producer
docker run -p 9091:8091 kafka-consumer
```
or run all containers using Docker-compose
```
docker-compose up -d
```
4. stop servers
```
docker-compose down
```
