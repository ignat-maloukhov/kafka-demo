package demo.ignat.producer.adapter.output.kafka;

import demo.ignat.producer.adapter.output.dto.ChuckMessageDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class KafkaService {

    private final KafkaTemplate<Integer, ChuckMessageDto> kafkaTemplate;

    //private String topicName = "chuck-norris-topic";

    public void sendKafkaMessage(String topicName, ChuckMessageDto dto) {
        System.out.println("Из KafkaService=" + dto);
        kafkaTemplate.send(topicName, dto);
    }


//    public void sendKafkaMessage(final ChuckMessageDto dto) {
//        final ProducerRecord<String, String> record = createRecord(data);
//
//        CompletableFuture<SendResult<Integer, String>> future = template.send(record);
//        future.whenComplete((result, ex) -> {
//            if (ex == null) {
//                handleSuccess(data);
//            }
//            else {
//                handleFailure(data, record, ex);
//            }
//        });
//    }
}
