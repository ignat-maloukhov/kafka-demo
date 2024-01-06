package demo.ignat.admin;

import demo.ignat.admin.onstartup.OnStartup;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@AllArgsConstructor
@SpringBootApplication
public class KafkaAdminApplication implements CommandLineRunner {

    @Autowired
    OnStartup onStartup;

    public static void main(String[] args) {
        SpringApplication.run(KafkaAdminApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        onStartup.initKafkaAdmin();
        onStartup.createDefaultTopic();

    }
}
