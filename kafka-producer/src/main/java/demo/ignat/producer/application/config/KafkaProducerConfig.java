package demo.ignat.producer.application.config;

import demo.ignat.producer.application.model.ChuckMessage;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

//    @Autowired
//    KafkaProperties kafkaProperties;


    //@Value("${topic.topic-name}")
    private String topicName = "chuck-norris-topic";

    //@Value(value = "${spring.kafka.producer.bootstrap-servers}")
    private String bootstrapAddress = "kafka:9092";

//    @Value(value = "${spring.kafka.key-serializer}")
//    private String keySerializer;

//    @Value(value = "${spring.kafka.key-serializer}")
//    private String valueSerializer;

    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return properties;
    }

    @Bean
    public ProducerFactory<String, ChuckMessage> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public KafkaTemplate<String, ChuckMessage> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

}
