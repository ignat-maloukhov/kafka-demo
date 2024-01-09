package demo.ignat.producer.application.service;

import demo.ignat.producer.application.model.ChuckFact;
import net.datafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ChuckMessagesService implements MessageService<ChuckFact> {

    private static Faker faker = new Faker();

    @Override
    public ChuckFact message() {
        return new ChuckFact(UUID.randomUUID(), faker.chuckNorris().fact());
    }
}
