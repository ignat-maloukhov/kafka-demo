package demo.ignat.producer.application.service;

import demo.ignat.producer.application.model.ChuckMessage;
import net.datafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ChuckMessagesService implements MessageService<ChuckMessage> {

    private static Faker faker = new Faker();

    @Override
    public ChuckMessage message() {
        return new ChuckMessage(UUID.randomUUID(), faker.chuckNorris().fact());
    }
}
