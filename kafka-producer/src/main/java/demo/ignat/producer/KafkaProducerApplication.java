package demo.ignat.producer;

import demo.ignat.producer.adapter.output.dto.ChuckMessageDto;
import demo.ignat.producer.infrastructure.scheduler.KafkaDemoScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaProducerApplication implements CommandLineRunner{

    @Autowired
    KafkaDemoScheduler kafkaDemoScheduler;

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);



    }

    @Override
    public void run(String... args) throws Exception {

        kafkaDemoScheduler.sendKafkaMessage();


    }


//    static void runConsumer() {
//        Consumer<Long, String> consumer = ConsumerCreator.createConsumer();
//
//        int noMessageToFetch = 0;
//
//        while (true) {
//            final ConsumerRecords<Long, String> consumerRecords = consumer.poll(1000);
//            if (consumerRecords.count() == 0) {
//                noMessageToFetch++;
//                if (noMessageToFetch > IKafkaConstants.MAX_NO_MESSAGE_FOUND_COUNT)
//                    break;
//                else
//                    continue;
//            }
//
//            consumerRecords.forEach(record -> {
//                System.out.println("Record Key " + record.key());
//                System.out.println("Record value " + record.value());
//                System.out.println("Record partition " + record.partition());
//                System.out.println("Record offset " + record.offset());
//            });
//            consumer.commitAsync();
//        }
//        consumer.close();
//    }

}
