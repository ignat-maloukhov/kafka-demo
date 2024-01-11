package demo.ignat.producer.adapter.output.kafka;

import demo.ignat.producer.adapter.output.message.ChuckMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@PropertySource("classpath:kafka.properties")
@RequiredArgsConstructor
@Slf4j
public class KafkaAdapterOut {

    @Autowired
    private KafkaTemplate<String, ChuckMessage> kafkaTemplate;

    @Value(value = "${topic.topic-name}")
    private String topicName;

    /**
     * Send message to Kafka.
     *
     * @param message - Chuck fact dto
     */
    public void send(ChuckMessage message) {
        var future = kafkaTemplate.send(topicName, UUID.randomUUID().toString(), message);

        future.whenComplete((sendResult, exception) -> {
            if (exception != null) {
                future.completeExceptionally(exception);
            } else {
                future.complete(sendResult);
            }
            log.info("Task status send to Kafka topic : " + message.message());
        });
    }
}