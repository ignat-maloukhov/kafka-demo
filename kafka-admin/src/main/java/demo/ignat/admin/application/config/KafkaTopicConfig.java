package demo.ignat.admin.application.config;

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

    @Value(value = "${topic.partition-count}")
    private int partitionCount;

    @Value(value = "${topic.replica-count}")
    private int replicaCount;

    /**
     * Creates Kafka Topic using given parameters: topicName, partitionCount and replicaCount from kafka.properties.
     *
     * @return instance of NewTopic.
     */
    @Bean
    public NewTopic defaultTopic() {
        var topic = TopicBuilder.name(topicName)
                .partitions(partitionCount)
                .replicas(replicaCount)
                .compact()
                .build();

        log.info("Kafka Topic created");

        return topic;
    }
}
