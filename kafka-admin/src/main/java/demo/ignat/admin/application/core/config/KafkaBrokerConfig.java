package demo.ignat.admin.application.core.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource("classpath:kafka.properties")
@Slf4j
public class KafkaBrokerConfig {

    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    /**
     * Creates KafkaAdmin using given parameters: bootstrapAddress from kafka.properties.
     *
     * @return instance of KafkaAdmin.
     */
    @Bean
    public KafkaAdmin init() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        var admin = new KafkaAdmin(configs);

        log.info("KafkaAdmin started");

        return admin;
    }
}
