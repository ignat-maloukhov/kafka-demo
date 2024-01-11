package demo.ignat.consumer.adapter.input.kafka;

import demo.ignat.consumer.adapter.input.message.ChuckMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
@Slf4j
public class KafkaInputListener {


    private final String topics = "chuck-norris-topic";
    private final String groupId = "chuck-norris-group";

    @KafkaListener(topics = topics, groupId = groupId)
    public ChuckMessage consume(ChuckMessage payload) {
        log.info(payload.message());
        return payload;
    }

}


