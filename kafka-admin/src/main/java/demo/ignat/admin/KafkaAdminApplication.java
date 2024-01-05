package demo.ignat.admin;

import demo.ignat.admin.application.config.TopicConfig;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class KafkaAdminApplication implements CommandLineRunner {

	@Autowired
	TopicConfig config;

	public static void main(String[] args) {
		SpringApplication.run(KafkaAdminApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		config.chuckTopic1();

	}
}
