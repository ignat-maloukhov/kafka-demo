package demo.ignat.admin.application.core.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:kafka.properties")
@Slf4j
public class KafkaTopicConfig {

    @Autowired
    KafkaBrokerConfig kafkaBrokerConfig;

    @Value(value = "${topic.default-topic-name}")
    private String topicName;

    private int partitionCount;

    @Value(value = "${topic.default-replica-count}")
    private int replicaCount;

    /**
     * Creates Kafka Topic using given parameters: topicName, partitionCount and replicaCount from kafka.properties.
     *
     * @return instance of NewTopic.
     */
    @Bean
    public NewTopic defaultTopic() {
        var topic = TopicBuilder.name(topicName)
                .partitions(numberOfCores())
                .replicas(replicaCount)
                .compact()
                .build();

        log.info("Kafka Topic created");

        return topic;
    }


    /**
     * In Kafka the main level of parallelism is number of partitions in a topic.
     * Method allow to set number of partitions equal number of processor`s cores.
     *
     * @return number of processor`s cores
     */
    private int numberOfCores() {
        return Runtime.getRuntime().availableProcessors();
    }
}
