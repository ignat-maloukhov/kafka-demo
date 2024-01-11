package demo.ignat.consumer.application.core.model;

import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

/*
 * This is model
 */
@Getter
@ToString
public class ChuckFact {

    private final UUID id;
    private final String fact;

    public ChuckFact(String fact) {
        this.id = UUID.randomUUID();
        this.fact = fact;
    }

}