package demo.ignat.producer.application.service;

import demo.ignat.producer.application.model.ChuckMessage;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ChuckMessageService {

    private final KafkaTemplate<String, ChuckMessage> kafkaTemplate;

    public void sendMessage(String topicName, ChuckMessage data) {
        kafkaTemplate.send(topicName, data);
    }
}

