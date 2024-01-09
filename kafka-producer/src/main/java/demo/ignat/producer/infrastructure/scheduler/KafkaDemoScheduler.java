package demo.ignat.producer.infrastructure.scheduler;


import demo.ignat.producer.adapter.output.dto.ChuckMessageDto;
import demo.ignat.producer.adapter.output.dto.mapper.ChuckMapper;
import demo.ignat.producer.adapter.output.kafka.KafkaService;
import demo.ignat.producer.application.service.ChuckMessagesService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@AllArgsConstructor
public class KafkaDemoScheduler {


    private final ChuckMessagesService messagesService;
    private final ChuckMapper mapper;
    private final KafkaService kafkaService;

    private final String topicName = "chuck-norris-topic";

    @Scheduled(fixedDelay = 1000)
    public void sendKafkaMessage() {
        var message = messagesService.message();
        var dto = mapper.map(message);
        kafkaService.sendKafkaMessage(dto);

        System.out.println("message=" + message);
        System.out.println("dto=" + dto);
    }
}
