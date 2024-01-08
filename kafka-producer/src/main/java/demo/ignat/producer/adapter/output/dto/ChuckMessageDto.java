package demo.ignat.producer.adapter.output.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ChuckMessageDto(@JsonProperty("message") String message) {


}
