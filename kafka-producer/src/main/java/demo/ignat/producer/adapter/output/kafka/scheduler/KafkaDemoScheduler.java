package demo.ignat.producer.adapter.output.kafka.scheduler;


import demo.ignat.producer.adapter.output.kafka.KafkaAdapterOut;
import demo.ignat.producer.application.core.ChuckFactService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@AllArgsConstructor
//@PropertySource("classpath:kafka.properties")
public class KafkaDemoScheduler {

    private final ChuckFactService messagesService;
    private final KafkaAdapterOut kafkaAdapterOut;

    //@Value(value = "${topic.topic-name}")
    //private String topicName;

    @Scheduled(fixedDelay = 2000, initialDelay = 5000)
    public void sendKafkaMessage() {
        var fact = messagesService.fact();
        kafkaAdapterOut.send(fact);
    }
}
