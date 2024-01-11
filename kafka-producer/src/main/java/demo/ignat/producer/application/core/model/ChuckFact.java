package demo.ignat.producer.application.core.model;

import lombok.Getter;
import lombok.ToString;
import net.datafaker.Faker;

import java.util.UUID;


/*
 * This is model
 */
@Getter
@ToString
public class ChuckFact {

    private static Faker faker = new Faker();

    private final UUID id;
    private final String fact;

    public ChuckFact() {
        this.id = UUID.randomUUID();
        this.fact = faker.chuckNorris().fact();
    }

}
