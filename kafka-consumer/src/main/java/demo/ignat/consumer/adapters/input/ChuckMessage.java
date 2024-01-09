package demo.ignat.consumer.adapters.input;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ChuckMessage(@JsonProperty("message") String message) {

}