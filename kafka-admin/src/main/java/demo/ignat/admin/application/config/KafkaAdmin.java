package demo.ignat.admin.application.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource("classpath:application.yml")
public class KafkaAdmin {

    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;


    @Bean
    public org.springframework.kafka.core.KafkaAdmin init() {
        System.out.println("bootstrapAddress="+bootstrapAddress);
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        org.springframework.kafka.core.KafkaAdmin admin = new org.springframework.kafka.core.KafkaAdmin(configs);
        System.out.println("СВОЙСТВА");
        System.out.println(admin.getConfigurationProperties());
        return admin;
    }



}
