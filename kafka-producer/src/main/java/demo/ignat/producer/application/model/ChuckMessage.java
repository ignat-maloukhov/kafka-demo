package demo.ignat.producer.application.model;

import java.util.UUID;

public record ChuckMessage(UUID id, String message) {
}
