package demo.ignat.producer;

import demo.ignat.producer.adapter.output.dto.ChuckMessageDto;
import demo.ignat.producer.infrastructure.scheduler.KafkaDemoScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaProducerApplication {

    @Autowired
    KafkaDemoScheduler kafkaDemoScheduler;

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//
//        kafkaDemoScheduler.sendKafkaMessage();
//
//
//    }

//    CommandLineRunner commandLineRunner(KafkaTemplate<Integer, ChuckMessageDto> kafkaTemplate) {
//        return args -> {
//            kafkaTemplate.send("chuck-norris-topic", new ChuckMessageDto("HIIIIIIIIIIIIIIIIIIII"));
//        };
//    }
}
