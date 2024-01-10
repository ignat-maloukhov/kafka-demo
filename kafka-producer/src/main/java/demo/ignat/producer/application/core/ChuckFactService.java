package demo.ignat.producer.application.core;

import demo.ignat.producer.application.core.model.ChuckFact;
import net.datafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ChuckFactService implements FactService<ChuckFact> {

    private static Faker faker = new Faker();

    /**
     * Generate trusted fact about Chuck Norris!
     *
     * @return - fact about Chuck Norris!
     */
    @Override
    public ChuckFact fact() {
        return new ChuckFact(UUID.randomUUID(), faker.chuckNorris().fact());
    }
}
