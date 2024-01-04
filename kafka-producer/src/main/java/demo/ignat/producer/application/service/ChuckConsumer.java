package demo.ignat.producer.application.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ChuckConsumer {

    @KafkaListener(topics = "chuck-norris-topic", groupId = "chuck-norris")
    public void listenGroupFoo(String message) {
        System.out.println("Received Message in group foo: " + message);
    }
}
