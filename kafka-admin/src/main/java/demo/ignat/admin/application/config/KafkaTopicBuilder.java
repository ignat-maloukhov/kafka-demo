package demo.ignat.admin.application.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.yml")
public class KafkaTopicBuilder {

    @Autowired
    KafkaAdmin kafkaAdmin;

    @Value(value = "${topic.default-topic-name}")
    private String topicName;

    @Bean
    public NewTopic defaultTopic() {
        return TopicBuilder.name(topicName)
                .partitions(10)
                .replicas(3)
                .compact()
                .build();
    }
}
