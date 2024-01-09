package demo.ignat.consumer.adapters.input.kafka;

import demo.ignat.consumer.adapters.input.ChuckMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
//@PropertySource("classpath:kafka.properties")
@Slf4j

public class KafkaInputListener {

//    @Value(value = "${spring.kafka.topic-name}")
//    private String topicName;

//    @Value(value = "${spring.kafka.group-id}")
//    private String groupId;


    //@KafkaListener(topics = {"chuck-norris-topic"})//, groupId = "task-group")
    @KafkaListener(topics = "chuck-norris-topic", groupId = "chuck-norris-group")
    public void consume(ChuckMessage value) {
        log.info(value.message());
    }

}


