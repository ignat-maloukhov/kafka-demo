package demo.ignat.producer.adapter.output.kafka;

import demo.ignat.producer.adapter.output.dto.ChuckMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class KafkaService {

    @Autowired
    KafkaTemplate<String, ChuckMessage> kafkaTemplate;

    public void sendKafkaMessage(String topicName, String key, ChuckMessage value) {

        var future = kafkaTemplate.send(topicName, key, value);

        future.whenComplete((sendResult, exception) -> {
            if (exception != null) {
                future.completeExceptionally(exception);
            } else {
                future.complete(sendResult);
            }
            log.info("Task status send to Kafka topic : " + value);
        });
    }
}