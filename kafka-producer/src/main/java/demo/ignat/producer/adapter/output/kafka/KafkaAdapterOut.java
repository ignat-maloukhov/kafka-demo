package demo.ignat.producer.adapter.output.kafka;

import demo.ignat.producer.adapter.output.ChuckMessage.ChuckMessage;
import demo.ignat.producer.adapter.output.ChuckMessage.mapper.ChuckMapper;
import demo.ignat.producer.application.core.model.ChuckFact;
import demo.ignat.producer.application.port.ChuckInstancePortOut;
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
public class KafkaAdapterOut implements ChuckInstancePortOut {


    @Autowired
    private KafkaTemplate<String, ChuckMessage> kafkaTemplate;

    private final ChuckMapper mapper;

    @Value(value = "${topic.topic-name}")
    private String topicName;

    /**
     * Send message to Kafka.
     *
     * @param model - Chuck fact model
     */
    public void send(ChuckFact model) {

        //If key is null random topic partitions will use.
        //This is load balanced strategy.
        var future = kafkaTemplate.send(topicName, UUID.randomUUID().toString(), mapper.map(model));

        future.whenComplete((sendResult, exception) -> {
            if (exception != null) {
                future.completeExceptionally(exception);
            } else {
                future.complete(sendResult);
            }
            log.info("Task status send to Kafka topic : " + mapper.map(model).message());
        });
    }

}