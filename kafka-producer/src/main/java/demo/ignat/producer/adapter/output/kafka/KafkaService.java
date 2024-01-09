package demo.ignat.producer.adapter.output.kafka;

import demo.ignat.producer.adapter.output.dto.ChuckMessageDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Service
@Slf4j
@AllArgsConstructor
public class KafkaService {

    private final KafkaTemplate<Integer, ChuckMessageDto> kafkaTemplate;

    private String topicName = "chuck-norris-topic";

//    public void sendKafkaMessage(String topicName, ChuckMessageDto dto) {
//        System.out.println("Из KafkaService=" + dto);
//        kafkaTemplate.send(topicName, dto);
//    }


//    public void sendKafkaMessage(final ChuckMessageDto dto) {
//        final ProducerRecord<String, String> record =
//                new ProducerRecord<>(topicName, dto.message());
//
//        CompletableFuture<SendResult<Integer, String>> future = kafkaTemplate.send(record);
//        future.whenComplete((result, ex) -> {
//            if (ex == null) {
//                System.out.println("Ok");
//                //handleSuccess(data);
//            }
//            else {
//                System.out.println("Ptoblem");
//                //handleFailure(data, record, ex);
//            }
//        });
//    }

    public void sendKafkaMessage(final ChuckMessageDto dto) {
        final ProducerRecord<String, ChuckMessageDto> record = new ProducerRecord<>(topicName, dto);

        try {
            kafkaTemplate.send((Message<?>) record).get(10, TimeUnit.SECONDS);
            //handleSuccess(data);
        } catch (ExecutionException e) {
            //handleFailure(data, record, e.getCause());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
//        catch (TimeoutException | InterruptedException e) {
//            handleFailure(data, record, e);
    }
}

