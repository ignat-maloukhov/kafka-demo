package demo.ignat.producer.application.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ChuckMessage(@JsonProperty("message") String message,
                           @JsonProperty("id") int id) {
}