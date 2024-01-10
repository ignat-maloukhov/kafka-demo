Hi everyone and me in the future :wave: this demo project is grokking [Apache Kafka](https://kafka.apache.org/) & [Spring for Apache Kafka](https://spring.io/projects/spring-kafka/) project.

### Action plan
**Step one.** Set up [Gradle](https://gradle.org/) multi-module project according to the instructions in this [article](https://reflectoring.io/spring-boot-gradle-multi-module/) and [documentation](https://docs.gradle.org/current/userguide/multi_project_builds.html).  
**Step two.** Read these brilliant articles about LISTENERS and ADVERTISED_LISTENERS setup:  
* [Kafka Listeners – Explained](https://www.confluent.io/blog/kafka-listeners-explained/);  
* [My Python/Java/Spring/Go/Whatever Client Won’t Connect to My Apache Kafka Cluster in Docker/AWS/My Brother’s Laptop. Please Help!](https://www.confluent.io/blog/kafka-client-cannot-connect-to-broker-on-aws-on-docker-etc/).

**Step three.** Run [Zookeeper](https://zookeeper.apache.org/) and [Apache Kafka](https://kafka.apache.org/) in [Docker](https://www.docker.com/) according to the instructions in this [article](https://www.baeldung.com/ops/kafka-docker-setup) considering the information in step two. Use this [article](https://howtodoinjava.com/kafka/kafka-cluster-setup-using-docker-compose/) for multi-node cluster.    
**Step four.** Create and configure Kafka topic using Spring KafkaAdmin according to the chapter [4.1.2. Configuring Topics](https://docs.spring.io/spring-kafka/docs/latest-ga/reference/html/#configuring-topics) of the documentation, and this [article](https://howtodoinjava.com/kafka/spring-kafka-admin-create-new-topics/). For multi-node Kafka cluster bootstrap-server config explained in this [article](https://www.baeldung.com/java-kafka-bootstrap-server).  
**Step five.** Code producer and consumer according to the instructions in these articles:  
* [Apache Kafka using Spring Boot](https://howtodoinjava.com/spring-boot/apache-kafka-using-spring-boot/);
* [Using Kafka with Spring Boot](https://reflectoring.io/spring-boot-kafka/). 
* [Intro to Apache Kafka with Spring](https://www.baeldung.com/spring-kafka);  
* [Spring Boot and Kafka – Practical Example](https://thepracticaldeveloper.com/spring-boot-kafka-config/);  

**Step six (optional).** In case of an error "The class '{path to the POJO}' is not in the trusted packages:..." use this [solution](https://www.baeldung.com/spring-kafka-trusted-packages-feature).  
**Step seven (under construction).** Test using Testcontainers according to the instructions in this [article](https://www.baeldung.com/spring-boot-kafka-testing).  
**Step six.** Run run run :rocket:
</br>
</br>

Youtube tutorials and presentations:
* [Владимир Богдановский. Про Kafka (основы)](https://youtu.be/-AZOi3kP9Js)  
* [Amigoscode. Kafka Tutorial - Spring Boot Microservices](https://youtu.be/SqVfCyfCJqw)  
* [Bouali Ali. Apache Kafka Tutorial with Spring Boot Reactive & WebFlux | Kafka Tutorial](https://youtu.be/KQDTtvZMS9c)  
* [Devtiro. Stream Big Data: How to use Kafka with Spring Boot](https://youtu.be/QngHCFFsa00)  
</br>
</br>
Offtopic
* [Organizing Layers Using Hexagonal Architecture, DDD, and Spring](https://www.baeldung.com/hexagonal-architecture-ddd-spring)
* [Compose file version 3 reference](https://docs.docker.com/compose/compose-file/compose-file-v3/)  
* [30 команд Git, необходимых для освоения интерфейса командной строки Git](https://habr.com/ru/companies/ruvds/articles/599929/)  
* [A Guide to Datafaker](https://www.baeldung.com/java-datafaker)
* [MapStruct 1.5.5.Final Reference Guide](https://mapstruct.org/documentation/stable/reference/html/)
* [Mapping JPA Entities into DTOs in Spring Boot Using MapStruct](https://auth0.com/blog/how-to-automatically-map-jpa-entities-into-dtos-in-spring-boot-using-mapstruct/)


Dockerizing:
1. build single jar files
```
./gradlew clean kafka-broker:build
./gradlew clean kafka-prosucer:build
./gradlew clean kafka-consumer:build
```
or build all services using one command
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
docker run -p 8080:8080 kafka-admin
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

try https://www.confluent.io/blog/kafka-listeners-explained/
try https://stackoverflow.com/questions/66590997/kafka-server-issue-in-docker
try https://habr.com/ru/articles/505720/
try https://stackoverflow.com/questions/61504171/spring-boot-app-refuses-to-connect-to-the-kafka-brokers
try https://docs.docker.com/compose/compose-file/compose-file-v3/
try https://www.baeldung.com/kafka-docker-connection
try https://devapo.io/blog/technology/kafka-in-spring-boot-on-docker/