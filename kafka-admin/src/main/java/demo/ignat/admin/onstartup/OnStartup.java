package demo.ignat.admin.onstartup;

import demo.ignat.admin.application.config.KafkaAdmin;
import demo.ignat.admin.application.config.KafkaTopicBuilder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class OnStartup {

    private final KafkaAdmin kafkaAdmin;
    private final KafkaTopicBuilder kafkaTopicBuilder;

    public void initKafkaAdmin() {
        kafkaAdmin.init();
    }

    public void createDefaultTopic() {
        kafkaTopicBuilder.defaultTopic();
    }

}
