package demo.ignat.producer;

import demo.ignat.producer.application.model.ChuckMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaProducerApplication implements CommandLineRunner {

    @Autowired
    KafkaTemplate<String, ChuckMessage> producer;

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var topic = "chuck-norris-topic";
        for (int i = 0; i < 10; i++) {
            var message = new ChuckMessage("ЧААААААААААААААААККККККККК " + i, i);
            producer.send(topic, message);
        }
    }
}
