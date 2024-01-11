package demo.ignat.producer.adapter.output.kafka.scheduler;

import demo.ignat.producer.adapter.output.message.mapper.ChuckMapper;
import demo.ignat.producer.adapter.output.kafka.KafkaAdapterOut;
import demo.ignat.producer.application.core.model.ChuckFact;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@AllArgsConstructor
public class KafkaDemoScheduler {

    private final ChuckMapper mapper;
    private final KafkaAdapterOut kafkaAdapterOut;

    @Scheduled(fixedDelay = 2000, initialDelay = 5000)
    public void sendKafkaMessage() {
        var message = mapper.map(new ChuckFact());
        kafkaAdapterOut.send(message);
    }
}
