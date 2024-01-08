package demo.ignat.admin.infrastructure.onstartup;

import demo.ignat.admin.application.config.KafkaBrokerConfig;
import demo.ignat.admin.application.config.KafkaTopicConfig;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class OnStartup {

    private final KafkaBrokerConfig kafkaBrokerConfig;
    private final KafkaTopicConfig kafkaTopicConfig;

    public void initKafkaAdmin() {
        kafkaBrokerConfig.init();
    }

    public void createDefaultTopic() {
        kafkaTopicConfig.defaultTopic();
    }

}
